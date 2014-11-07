/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package easyflow.graph.jgraphx.impl;

import java.util.Iterator;
import java.util.Map;
import org.eclipse.emf.common.notify.Notification;
import java.util.Map.Entry;

import easyflow.core.PreprocessingTask;
import easyflow.core.Task;
import easyflow.core.impl.TaskImpl;
import easyflow.custom.exception.DataLinkNotFoundException;
import easyflow.custom.exception.DataPortNotFoundException;
import easyflow.custom.exception.TaskNotFoundException;
import easyflow.custom.exception.ToolNotFoundException;
import easyflow.custom.exception.UtilityTaskNotFoundException;
import easyflow.graph.jgraphx.Graph;
import easyflow.custom.jgraphx.graph.JGraphXUtil;
import easyflow.custom.ui.GlobalConfig;
import easyflow.custom.util.GlobalConstants;
import easyflow.custom.util.GlobalVar;
import easyflow.custom.util.GraphUtil;
import easyflow.data.DataFactory;
import easyflow.data.DataLink;
import easyflow.data.DataPort;
import easyflow.graph.jgraphx.JgraphxPackage;
import easyflow.graph.jgraphx.PreprocessingGraph;
import easyflow.graph.jgraphx.Preprocessing;
import easyflow.traversal.TraversalChunk;
import easyflow.traversal.TraversalEvent;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.mxgraph.model.mxCell;
import com.mxgraph.model.mxICell;
import com.mxgraph.view.mxGraph.mxICellVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Preprocessing</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link easyflow.graph.jgraphx.impl.PreprocessingGraphImpl#getGraph <em>Graph</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PreprocessingGraphImpl extends EObjectImpl implements PreprocessingGraph {
	
	/**
	 * The cached value of the '{@link #getGraph() <em>Graph</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGraph()
	 * @generated
	 * @ordered
	 */
	protected Graph graph;
	private static Logger logger = Logger.getLogger(Preprocessing.class);
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PreprocessingGraphImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	public EMap<mxICell, EList<mxICell>> findCellsWherePreprocessingIsRequired()
	{
		logger.debug("findCellsWherePreprocessingIsRequired(): defined utilityTasks="+GlobalVar.getUtilityTasks().keySet());
		final EMap<mxICell, EList<mxICell>> prepRequired = new BasicEMap<mxICell, EList<mxICell>>();
		mxICellVisitor visitor=new mxICellVisitor()
		{
			@Override
			public boolean visit(Object vertex, Object edge) {
				try {
					Task task = JGraphXUtil.loadTask(vertex);
					Task parentTask = JGraphXUtil.getSourceTask((mxCell) edge);
					
					if (!task.getPreprocessingTasks().isEmpty())
					{
						Iterator<PreprocessingTask> it = task.getPreprocessingTasks().iterator();
						
						while (it.hasNext())
						{
							//boolean add = false;
							PreprocessingTask prepTask = EcoreUtil.copy(it.next());
							
							DataLink dataLink = null;
							Object   inEdge   = null;
							
							// get the incoming edge, which matches the port associated to the preptask
							DataPort requiredDataPort = task.getInDataPorts().get(prepTask.getDataPortIndex());
							logger.debug("findCellsWherePreprocessingIsRequired(): required dataport="+requiredDataPort.getName()+" "+requiredDataPort.getFormat().getName());
							for (Object edgeIn : getGraph().getGraph().getIncomingEdges(vertex))
							{
								DataLink testDataLink = JGraphXUtil.loadDataLink(edgeIn);
								logger.debug(" test against "+testDataLink.getInDataPort().getName());
								if (requiredDataPort.isCompatible(testDataLink.getInDataPort()))
								{
									dataLink = testDataLink;
									inEdge   = edgeIn;
									break;
								}
							}
							
							if (dataLink == null)
							{
								logger.info("findCellsWherePreprocessingIsRequired(): could not find dataport for preptask="+prepTask.getName()
										+" of task="+task.getUniqueString()+". assume new datalink.");
								//break;
							}
							
							try 
							{
								logger.debug("findCellsWherePreprocessingIsRequired(): trying to find util task="
										+prepTask.getName()+" for task="+task.getUniqueString()
										+" for dataport="
										//+dataLink.getDataPort().getName()+" "+dataLink.getDataPort().getFormat().getName()
										+requiredDataPort.getFormat().getName()
										);
								Task utilTask = dataLink == null ?
										GraphUtil.getUtilityTask(requiredDataPort, prepTask.getName()) :
										GraphUtil.getUtilityTask(dataLink, prepTask.getName());

								logger.debug("findCellsWherePreprocessingIsRequired(): util task="+utilTask.getUniqueString()+" found.");
								
								EList<mxICell> prepEdges = prepRequired.containsKey(vertex) ? prepRequired.get(vertex) : new BasicEList<mxICell>();
								
								Task newPrepTask = //EcoreUtil.copy(getUtilityTasks().get(prepTask.getName()));
								EcoreUtil.copy(utilTask);
								//copyTask(getUtilityTasks().get(prepTask.getName()), newPrepTask);
								GraphUtil.copyTask(utilTask, newPrepTask);
								//newPrepTask.setName(newPrepTask.getName()+"_"+task.getUniqueURIString());
								newPrepTask.setName(newPrepTask.getName());
								newPrepTask.getChunks().addAll(EcoreUtil.copyAll(parentTask.getChunks()));
								GlobalVar.getTasks().put(newPrepTask.getUniqueString(), newPrepTask);
								prepTask.setTask(newPrepTask);
								
								if (dataLink == null)
								{
									DataPort testDataPort = utilTask.getInDataPorts().get(0);
									// create edge(s) (copy from all ingoing edges, which matches the dataport)
									for (Object edgeIn : getGraph().getGraph().getIncomingEdges(vertex))
									{
										DataLink testDataLink = JGraphXUtil.loadDataLink(edgeIn);
										if (testDataLink.getInDataPort().isCompatible(testDataPort))
										{
											dataLink = DataFactory.eINSTANCE.createDataLink();
											dataLink.setInDataPort(requiredDataPort);
											dataLink.setId(0);
											dataLink.setDataPort(testDataPort);
											dataLink.getIntermediateTasks().add(prepTask);
											Object e = getGraph().getGraph().insertEdgeEasyFlow(null, null, JGraphXUtil.getSource((mxCell) edgeIn), vertex, dataLink);
											prepEdges.add((mxICell) e);
										}
									}
								}
								else
								{
									if (!prepEdges.contains(inEdge))
										prepEdges.add((mxICell) inEdge);
									dataLink.getIntermediateTasks().add(prepTask);
								}
								logger.debug("findCellsWherePreprocessingIsRequired(): preprocessing task "
										+prepTask.getName()+" ("+newPrepTask.getUniqueString()+") added for "
										+task.getUniqueString()+" "+dataLink.hashCode());
								
								prepRequired.put((mxICell) vertex, prepEdges);
							}
							catch (UtilityTaskNotFoundException e) 
							{
								// TODO Auto-generated catch block
								e.printStackTrace();
								logger.warn("findCellsWherePreprocessingIsRequired(): omit preprocessing tasks for "+task.getUniqueString()
										+": Preptask="+prepTask.getName()+" expression="+prepTask.getExpression()
										+" found="+(GlobalVar.getUtilityTasks().get(prepTask.getName())!=null)
										+" dataport="+dataLink.getDataPort().getName()+" "+dataLink.getDataPort().getFormat().getName());
							}
						}
					}
				} catch (TaskNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (DataLinkNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return true;
			}
		};
		getGraph().getGraph().getModel().beginUpdate();		try		{
			getGraph().getGraph().traverse(getGraph().getDefaultRootCell(), true, visitor);
			JGraphXUtil.layoutGraph();
			
		}		finally		{			getGraph().getGraph().getModel().endUpdate();		}
		return prepRequired;

	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @throws DataLinkNotFoundException 
	 * @throws TaskNotFoundException 
	 * @generated not
	 */
	public boolean resolvePreprocessingTask(mxICell vertex, mxICell edge) throws DataLinkNotFoundException, TaskNotFoundException {
		
		boolean nested = true;
		if (nested)
			return resolvePreprocessingTaskChained(vertex, edge);
		else
			return resolvePreprocessingTaskParallel(vertex, edge);
	}
		
		
	private boolean resolvePreprocessingTaskParallel(mxICell vertex, mxICell edge) throws TaskNotFoundException, DataLinkNotFoundException
	{
		boolean rc = false;
		Task task  = JGraphXUtil.loadTask(vertex);
		Iterator<PreprocessingTask> it = JGraphXUtil.loadDataLink(edge).getIntermediateTasks().iterator();
		DataLink dataLink              = JGraphXUtil.loadDataLink(edge);
		
		
		getGraph().getGraph().getModel().beginUpdate();		try		{
		
		while (it.hasNext())
		{
			
			PreprocessingTask prepTask = it.next();
			Task newPrepTask = prepTask.getTask();
			logger.trace("resolvePreprocessingTask(): insertPrepTask="+newPrepTask.getUniqueString()+" for "+task.getUniqueString()+" "+prepTask.getTask().getPreferredTool());
			rc = true;
			// insert the new vertex 
			Object newVertex = getGraph().getGraph().insertVertexEasyFlow(null, null, newPrepTask);
			GlobalVar.getCells().put(newPrepTask.getUniqueString(), (mxICell) newVertex);
			// link with parent
			getGraph().getGraph().insertEdgeEasyFlow(null, null, JGraphXUtil.getSource((mxCell) edge), newVertex, GraphUtil.copyDataLink(dataLink));
			// link with child
			getGraph().getGraph().insertEdgeEasyFlow(null, null, newVertex, vertex, GraphUtil.copyDataLink(dataLink));
			
		}

		// remove obsolet parent and child edge
		getGraph().getGraph().removeCells(new Object[]{edge}, true);

		
			
			JGraphXUtil.layoutGraph();
		}		finally		{			getGraph().getGraph().getModel().endUpdate();		}
		
		return rc;
		
		
	}
	
	private Task findExistingUtilityTaskFor(String utilTaskString, Object edge) throws TaskNotFoundException, DataLinkNotFoundException
	{
		Task utilityTask = null;
		Object prepVertex = null;
		Task source = JGraphXUtil.getSourceTask((mxCell) edge);
		Task target = JGraphXUtil.getTargetTask((mxCell) edge);
		mxICell sourceVertex = JGraphXUtil.getSource((mxCell) edge);
		logger.debug("findExistingUtilityTaskFor(): find existing utility task="+utilTaskString+" inbetween of "+source.getUniqueString()+" "+target.getUniqueString());
		if (GlobalVar.getUtilityTasks().containsKey(utilTaskString) && GlobalVar.getUtilityTasks().get(utilTaskString) != null)
		{
			Task tmp = GlobalVar.getUtilityTasks().get(utilTaskString);
			Object parent = findParentForPrepVertexForPrepTask(sourceVertex, tmp);
			if (parent != null)
				prepVertex = findPrepVertexForPrepTask(parent, tmp);
			if (prepVertex != null)
			{
				utilityTask = JGraphXUtil.loadTask(prepVertex);
				logger.debug("createUtilityTask(): found prep task="+utilityTask.getUniqueString());
				
			}
		}
		return utilityTask;
	}
	

	
	// go along "identity"-utility tasks (e.g. BAM->BAM) and find the most distant from vertex
	private Object findParentForPrepVertexForPrepTask(Object vertex, Task prepTask) throws TaskNotFoundException, DataLinkNotFoundException
	{
		Object parent = vertex;
		for (Object edgeOut : getGraph().getGraph().getOutgoingEdges(vertex))
		{
			DataLink dataLink = JGraphXUtil.loadDataLink(edgeOut);
			if (dataLink.isTerminal())
				continue;
			Task testTask = JGraphXUtil.getTargetTask((mxCell) edgeOut);
			if (testTask.isUtil() &&
				testTask.isIdentityTransformation(prepTask.getInDataPorts().get(0))
				)
			{
				parent = findParentForPrepVertexForPrepTask(JGraphXUtil.getTarget((mxCell) edgeOut), prepTask);
				break;
			}
		}
		return parent;
	}
	
	private boolean isIdenticalPrepTask(Task prepTask,  Task testTask)
	{
		return (testTask.isUtil() &&
				testTask.getAnalysisTypes().equals(prepTask.getAnalysisTypes()) &&
				prepTask.isCompatibleWithOutDataPortFor(testTask.getInDataPorts().get(0)) &&
				prepTask.isCompatibleWithInDataPortFor(testTask.getOutDataPorts().get(0))
				);
				

	}
	
	// check if there is already a preprocessing task (and vertex) inserted for prepTask
	private Object findPrepVertexForPrepTask(Object vertex, Task prepTask) throws TaskNotFoundException, DataLinkNotFoundException
	{
		
		if (isIdenticalPrepTask(prepTask, JGraphXUtil.loadTask(vertex)))
			return vertex;
		
		Object prepVertex = null;
		for (Object edgeOut : getGraph().getGraph().getOutgoingEdges(vertex))
		{
			DataLink dataLink = JGraphXUtil.loadDataLink(edgeOut);
			if (dataLink.isTerminal())
				continue;

			Task testTask = JGraphXUtil.getTargetTask((mxCell) edgeOut);
			if (isIdenticalPrepTask(prepTask, testTask))
			{
				prepVertex = JGraphXUtil.getTarget((mxCell) edgeOut);
				break;
			}
		}
		return prepVertex;
	}
	
	private boolean resolvePreprocessingTaskChained(mxICell vertex, mxICell edge) throws DataLinkNotFoundException, TaskNotFoundException {
		
		boolean  rc       = false;
		Task     task     = JGraphXUtil.loadTask(vertex);
		DataLink dataLink = JGraphXUtil.loadDataLink(edge);
		boolean  first    = true;
		mxICell  last     = null;
		
		logger.debug("resolvePreprocessingTask(): process intermediate tasks for dataLink="+dataLink.getUniqueString());
		Iterator<PreprocessingTask> it  = dataLink.getIntermediateTasks().iterator();

		// init with source
		Object lastCompatibleVertex = JGraphXUtil.getSource((mxCell) edge);

		boolean incompatibleParentFound = false;
		
		getGraph().getGraph().getModel().beginUpdate();		try		{
		
		while (it.hasNext())
		{
			mxICell source = first ? JGraphXUtil.getSource((mxCell) edge) : last;
			first = false;
			PreprocessingTask prepTask = it.next();
			Task newPrepTask = prepTask.getTask();
			logger.debug("resolvePreprocessingTask(): insertPrepTask="+newPrepTask.getUniqueString()
					+" type="+newPrepTask.getAnalysisTypes()
					+" for "+task.getUniqueString()+" "
					+prepTask.getTask().getPreferredTool().getId()
					+" output compatibility to port="+dataLink.getInDataPort().getFormat().getName()+" ("+
					newPrepTask.isCompatibleWithInDataPortFor(dataLink.getInDataPort())+")");
			rc = true;
			boolean reusedPrepTask = false;
			Object newVertex = null;
			Object newSource = null;
			// check if this preprocessing task is already inserted
			if (incompatibleParentFound)
			{
				logger.debug("resolvePreprocessingTask(): check "+JGraphXUtil.loadTask(lastCompatibleVertex).getUniqueString()+" "+newPrepTask.getUniqueString());
				newSource = findParentForPrepVertexForPrepTask(lastCompatibleVertex, newPrepTask);
				logger.debug("resolvePreprocessingTask(): got new parent="+JGraphXUtil.loadTask(newSource).getUniqueString());
				//newVertex = findPrepVertexForPrepTask(lastCompatibleVertex, newPrepTask);
				newVertex = findPrepVertexForPrepTask(newSource, newPrepTask);
				if (newVertex != null)
				{
					logger.debug("resolvePreprocessingTask(): got final vertex="+JGraphXUtil.loadTask(newVertex).getUniqueString());
				}
			}
			else
			{
				logger.debug("resolvePreprocessingTask(): check2 "+JGraphXUtil.loadTask(source).getUniqueString()+" "+newPrepTask.getUniqueString());
				newSource = findParentForPrepVertexForPrepTask(source, newPrepTask);
				logger.debug("resolvePreprocessingTask(): got new parent="+JGraphXUtil.loadTask(newSource).getUniqueString());
				//newVertex = findPrepVertexForPrepTask(source, newPrepTask);
				newVertex = findPrepVertexForPrepTask(newSource, newPrepTask);
				if (newVertex != null)
				{
					logger.debug("resolvePreprocessingTask(): got final vertex="+JGraphXUtil.loadTask(newVertex).getUniqueString());
				}
			}
			if (newSource != null)
				source = (mxICell) newSource;
			
			// insert the new vertex
			if (newVertex == null)
				newVertex = getGraph().getGraph().insertVertexEasyFlow(null, null, newPrepTask);
			else
				reusedPrepTask = true;
			
			if (incompatibleParentFound)
			{
				incompatibleParentFound = false;
				getGraph().getGraph().insertEdgeEasyFlow(null, null, lastCompatibleVertex, newVertex, 
						//copyDataLink(dataLink)
						GraphUtil.createDataLink(dataLink, JGraphXUtil.loadTask(lastCompatibleVertex), false)
						);
				logger.debug("resolvePreprocessingTask(): insert edge: "+JGraphXUtil.loadTask(lastCompatibleVertex).getUniqueString()+" => "+newPrepTask.getUniqueString());
			}

			if (newPrepTask.isCompatibleWithInDataPortFor(dataLink.getInDataPort()))
				lastCompatibleVertex = newVertex;
			else
			{
				incompatibleParentFound = true;
			}
			
			if (!reusedPrepTask)
			{
				GlobalVar.getCells().put(newPrepTask.getUniqueString(), (mxICell) newVertex);
			
			// link with parent
			getGraph().getGraph().insertEdgeEasyFlow(null, null, source, newVertex, 
					//copyDataLink(dataLink, loadTask(source))
					GraphUtil.createDataLink(dataLink, JGraphXUtil.loadTask(source), false)
					);
			logger.debug("resolvePreprocessingTask(): insert edge: "+JGraphXUtil.loadTask(source).getUniqueString()+" => "+newPrepTask.getUniqueString());
			}
			last = (mxICell) newVertex;
			
		}
		
		if (incompatibleParentFound)
		{		 
			Task lastCompatibleTask = JGraphXUtil.loadTask(lastCompatibleVertex);
			logger.debug("trying to link with last compatible task="+lastCompatibleTask.getUniqueString()+"("+lastCompatibleVertex+")");
			getGraph().getGraph().insertEdgeEasyFlow(null, null, lastCompatibleVertex, vertex, 
					//copyDataLink(dataLink)
					GraphUtil.createDataLink(dataLink, lastCompatibleTask, false)
					);
			logger.debug("resolvePreprocessingTask(): insert edge:"+lastCompatibleTask.getUniqueString()+"=>"+JGraphXUtil.loadTask(vertex).getUniqueString());
		}
		Task lastTask = JGraphXUtil.loadTask(last);
		logger.debug("resolvePreprocessingTask(): trying to link with last task="+lastTask.getUniqueString()+"("+last+")");
		getGraph().getGraph().insertEdgeEasyFlow(null, null, last, vertex, 
				//copyDataLink(dataLink, loadTask(last))
				GraphUtil.createDataLink(dataLink, lastTask, incompatibleParentFound)
				);
		logger.debug("resolvePreprocessingTask(): insert edge:"+lastTask.getUniqueString()+"=>"+JGraphXUtil.loadTask(vertex).getUniqueString());
		
		// remove obsolet parent and child edge		
		getGraph().getGraph().removeCells(new Object[]{edge}, true);
		
		
		JGraphXUtil.layoutGraph();	
		}		finally		{			getGraph().getGraph().getModel().endUpdate();		}
		
		return rc;
	}
	

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * find tasks and all incoming datalinks that cannot be directly processed, i.e.
	 * another task is required to prepare (e.g. filter/merge) the inputs.
	 * 
	 *   
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	public EMap<mxICell, EList<mxICell>> findCellsWithUntranslatedDataLinks() {
		
		final EMap<mxICell, EList<mxICell>> edges = new BasicEMap<mxICell, EList<mxICell>>();
		mxICellVisitor visitor=new mxICellVisitor()
		{
			@Override
			public boolean visit(Object vertex, Object edge0) 
			{
				for (Object edge : getGraph().getGraph().getIncomingEdges(vertex))
				try {
					DataLink dataLink = JGraphXUtil.loadDataLink(edge);
					if (dataLink.getDataPort().isStatic())
						continue;

					Task sourceTask = JGraphXUtil.getSourceTask((mxCell) edge);
					//Task targetTask=getTargetTask((mxCell) edge);
					Task task = JGraphXUtil.loadTask(vertex);					

					EList<TraversalChunk> chunks        = task.getChunks().get(dataLink.getGroupingStr());
					EList<TraversalChunk> sourceChunks  = sourceTask.getChunks().get(dataLink.getParentGroupingStr());
					EList<TraversalChunk> inputs        = task.getInputs(true);
					//EList<TraversalChunk> sourceInputs  = sourceTask.getInputs(true);
					EList<TraversalChunk> records       = task.getRecords(true);
					//EList<TraversalChunk> sourceRecords = sourceTask.getRecords();
										
					String sourceBasicGrouping = GlobalConstants.METADATA_INPUT.equals(dataLink.getParentGroupingStr()) ? GlobalConstants.METADATA_INPUT : GlobalConstants.TRAVERSAL_CRITERION_RECORD;
					String targetBasicGrouping = GlobalConstants.METADATA_INPUT.equals(dataLink.getGroupingStr())       ? GlobalConstants.METADATA_INPUT : GlobalConstants.TRAVERSAL_CRITERION_RECORD;
					DataPort dataPortIn = dataLink.getDataPort();
					
					logger.debug("findCellsWithUntranslatedDataLinks(): "
							+"test "+task.getUniqueString()
							+" (against:"+sourceTask.getUniqueString()+"): "
							+ dataLink.getParentGroupingStr()+"= "
							+easyflow.custom.util.Util.list2String(sourceChunks, null)
							+" ==>> "+dataLink.getGroupingStr()+"= "
							+easyflow.custom.util.Util.list2String(chunks, null)
							+" groupings="+dataLink.getChunks().keySet()
							+" dataport="+dataPortIn.getName()+" "
							+" grouping crits(source)="+easyflow.custom.util.Util.list2String(sourceTask.getGroupingCriteria().keySet(), null)
							+" grouping crits(port)="+easyflow.custom.util.Util.list2String(dataPortIn.getGroupingCriteria(), null)
							);
					
					boolean found = false;
					assert dataLink.getGroupingStr() != null;
					if (!dataLink.getGroupingStr().equals(dataLink.getParentGroupingStr()))// && !sourceTask.isRoot())
					{
						if (sourceTask.canProvideDataPort(null, dataPortIn, dataLink.getGroupingStr(), null))
						{
							found = true;
							logger.debug("findCellsWithUntranslatedDataLinks(): source task can be configured to generate required grouping.");
						}
						// somehow get the relevant outdataport of source task
						else if (task.canComsumeDataPort(null, null, dataLink.getParentGroupingStr(), null))
						{
							found = true;
							logger.debug("findCellsWithUntranslatedDataLinks(): task can be configured to accepted grouping as provided by source task.");
						}
						else if (GlobalConstants.METADATA_INPUT.equals(dataLink.getGroupingStr())
								&& sourceTask.canProvideDataPort(null, null, GlobalConstants.METADATA_INPUT, inputs))
						{
							found = true;
							logger.debug("findCellsWithUntranslatedDataLinks(): direct conversion found (of grouping="+dataLink.getGroupingStr()+").");
							
						}
						// check if the required chunk is entirely provided by the parent, i.e.
						// conversion: RG1 -> ID1
						// in metadata a record is defined to be "ID1 RG1 ..." and data RG1 is the same as data ID1 
						else if (!GlobalConstants.METADATA_INPUT.equals(dataLink.getGroupingStr())
								&& records.size() == sourceChunks.size()
								&& sourceTask.canProvideDataPort(null, null, GlobalConstants.TRAVERSAL_CRITERION_RECORD, records))
						{
							found = true;
							logger.debug("findCellsWithUntranslatedDataLinks(): direct conversion found.");
						}
					}
					// for identical groupings check if the instances are the same
					else if (((TaskImpl) task).isEqual(chunks, sourceChunks, true))
					{
						found = true;
						logger.debug("findCellsWithUntranslatedDataLinks(): direct conversion found (identical grouping="+dataLink.getGroupingStr()+").");
					}
					
					if (!found)
					{
							logger.debug("findCellsWithUntranslatedDataLinks(): special conversion is required. track task in map. ");
							edges.put((mxICell) vertex, JGraphXUtil.getInEdgesForDataPort(vertex, dataLink.getDataPort()));

							// examples:
							// 1. task's input datalink has multiple chunks 
							
							// check if the parent output has to be filtered
							// - 1) filtering not necessary (because it just outputs the equivalent of a single record/input entity)
							// - 2) filtering not necessary (because the parent can do it itself)
							if (((//sourceBasicGrouping.equals(GlobalConstants.METADATA_INPUT) && 
									//(sourceInputs.size()  == 1 || sourceRecords.size() == 1) ||
									chunks.size() > sourceChunks.size() ||
									sourceTask.canProvideDataPort(null, null, sourceBasicGrouping, null))))
							{
								logger.debug("findCellsWithUntranslatedDataLinks(): mark to skip filtering.");
								task.setFlags(task.getFlags() | 0x1000);
							}
							
							// check if the parent output has to be merged
							// - 1) merging not necessary, because the task require only the equivalent of a single record)
							// - 2) merging not necessary, because the task can do merging itself
							else if ((targetBasicGrouping.equals(GlobalConstants.METADATA_INPUT) && inputs.size()  == 1) || 
									  records.size() == 1 || 
									  task.canComsumeDataPort(null, null, targetBasicGrouping, null))
							{
								logger.debug("findCellsWithUntranslatedDataLinks(): mark to skip merging.");
								task.setFlags(task.getFlags() | 0x2000);
							}
					}
					
				} catch (DataLinkNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (TaskNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (DataPortNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ToolNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return true;
			}
		};
		getGraph().getGraph().traverse(getGraph().getDefaultRootCell(), true, visitor);
		
		logger.debug("findCellsWithUntranslatedDataLinks(): "+edges.size()+" dataLinks found.");
		return edges;
	}

	/**
	 * <!-- begin-user-doc -->
	 	 * 1.   test if current task (entry key) and its DataPorts (entry value), which are going to be resolved
		 *   - have multiple inputs 
		 *   - have inputs consisting of more than one grouping instance
		 *   - have inputs consisting of instances of two or more different groups
		 * 1a.  test if the task can handle the inputs by its own 
		 *   - if yes: nothing to do
		 *   - else  : continue with step 2
		 *     
		 * 2. find the utility task that fits best to the input constellation as found in step 1
		 * 
		 * 3. create new filter task and insert into graph (using utility task from step 2 as template)
		 * 
		 * 
		 * argument entry: the cell/task and all (ingoing) edges to this cell 
		 * 
	 * <!-- end-user-doc -->
	 * @throws TaskNotFoundException 
	 * @throws DataLinkNotFoundException 
	 * @throws ToolNotFoundException 
	 * @throws DataPortNotFoundException 
	 * @throws UtilityTaskNotFoundException 
	 * @generated not
	 */
	public boolean resolveEdge(Map.Entry<mxICell, EList<mxICell>> entry) 
			throws TaskNotFoundException, DataLinkNotFoundException, 
			DataPortNotFoundException, ToolNotFoundException, 
			UtilityTaskNotFoundException 
	{
				
		boolean rc = true;
		
		int constellation = 0x00;
		
		// filter task can have multiple inputs
		int filterSupportMultipleInputs            = 0x01;
		// filter task can process multiple instances per single input
		int filterSupportMultipleInstancesPerInput = 0x02;
		// merge task can process multiple instances per single input
		int mergeSupportMultipleInstancesPerInput  = 0x04;
		
		
		//constellation|= filterSupportMultipleInputs;
		//constellation|= mergeSupportMultipleInstancesPerInput;
		//logger.debug("constellation: "+(constellation|filterSupportMultipleInputs)+" "+(constellation|filterSupportMultipleInstancesPerInput)+" ");
		logger.debug("resolveEdge(): constellation="+constellation);
		
		Task task = JGraphXUtil.loadTask(entry.getKey());
		logger.debug("resolveEdge(): apply filter for "+task.getUniqueString()+" "+entry.getValue().size());
		if (!entry.getValue().isEmpty())
		{
			Object   firstEdge     = entry.getValue().get(0);
			DataLink firstDataLink = JGraphXUtil.loadDataLink(firstEdge);
			
			
			//if (!task.canProcessMultipleInputsFor(null, firstDataLink.getDataPort())){}
			//else if (task.hasMultipleGroupingsFor(firstDataLink.getDataPort()) && task.canProcessMultipleGroupingsFor(null, firstDataLink.getDataPort())
			//		|| task.hasMultipleInputsFor(firstDataLink.getDataPort()) && task.canProcessMultipleInputsFor(null, firstDataLink.getDataPort()) ){//constellation|=1<<	}
			
			getGraph().getGraph().getModel().beginUpdate(); try {
				
				//String filterGroupingStr = firstDataLink.getParentGroupingStr() != null ? 
					//						firstDataLink.getParentGroupingStr() :
						//					GlobalConfig.getGroupingCriterionForFilterTask();
				
				Task utilityTask = null;
				String groupingStr = GlobalConfig.getGroupingCriterionForFilterTask();
				try
				{
					utilityTask = GraphUtil.getUtilityTask(firstDataLink.getDataPort(), firstDataLink.getInDataPort(), "filter");
					groupingStr = GraphUtil.getGroupingCriterionOfUtilityTask(utilityTask);
				}
				catch (UtilityTaskNotFoundException e)
				{
					logger.debug("createFilterTasks(): no filter task found. Assume parent provide chunks.");
				}


											
				// filter tasks can be the actual parent
				EMap<mxICell, DataLink> cellMap = createFilterTasks(entry.getKey(), entry.getValue(), 
						firstDataLink.getInDataPort(), groupingStr, constellation);
				EMap<String, EList<TraversalChunk>> traversalChunks = new BasicEMap<String, EList<TraversalChunk>>();
				
				if (!cellMap.isEmpty())
				{
					for (Entry<mxICell, DataLink> e:cellMap.entrySet())
					{
						Task t = JGraphXUtil.loadTask(e.getKey());
						if (t.getUniqueString().equals(task.getUniqueString()))
						{
							traversalChunks.put(GlobalConstants.TRAVERSAL_CRITERION_RECORD, t.getRecords(true));
						}
						else
						{
							for (Entry<String, EList<TraversalChunk>> e1:task.getChunks())
								traversalChunks.put(e1.getKey(), new BasicEList(EcoreUtil.copyAll(e1.getValue())));
						}
						
					}
					Task mergeTask = null;
					boolean existingMergeTaskFound = false;
					if (((task.getFlags() >> 13) & 0x1) == 1)
					{
						mergeTask=task;
					}
					else 
					{
						String utilTaskString = GraphUtil.getUtilityTaskKey(firstDataLink, "merge");
						mergeTask = findExistingUtilityTaskFor(utilTaskString, firstEdge);
						if (mergeTask == null)
							mergeTask = JGraphXUtil.createNewUtilityTask(traversalChunks, utilTaskString, firstEdge);
						else
							existingMergeTaskFound = true;
					}

					mxICell mergeCell = (mxICell) GlobalVar.getCells().get(mergeTask.getUniqueString());
					if (!existingMergeTaskFound)
						for (Entry<mxICell, DataLink> e : cellMap.entrySet())
						{
							Task source = JGraphXUtil.loadTask(e.getKey());
							logger.debug("resolveEdge(): insert edge: (filter-merge)"
									+ source.getUniqueString()
									+ "->"
									+ mergeTask.getUniqueString());
							getGraph().getGraph().insertEdgeEasyFlow(null, null, e.getKey(),
									mergeCell, 
									//e.getValue()
									//copyDataLink(e.getValue())
									GraphUtil.createDataLink(e.getValue(), task, false)
									);
						}
						
					if (((task.getFlags() >> 13) & 0x1) != 1)
					{
						logger.debug("resolveEdge(): insert edge: (merge-task) "
								+ mergeTask.getUniqueString() + "->"
								+ task.getUniqueString());
							
						getGraph().getGraph()
								.insertEdgeEasyFlow(
											null,
											null,
											mergeCell,
											entry.getKey(),
											GraphUtil.createDataLink(firstEdge, task, firstDataLink.getGroupingStr(), firstDataLink.getGroupingStr(), null)
											);
					}
				}				
			} finally {
				JGraphXUtil.layoutGraph();
				getGraph().getGraph().getModel().endUpdate(); 
			}
		}
		return rc;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case JgraphxPackage.PREPROCESSING_GRAPH__GRAPH:
				if (resolve) return getGraph();
				return basicGetGraph();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case JgraphxPackage.PREPROCESSING_GRAPH__GRAPH:
				setGraph((Graph)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case JgraphxPackage.PREPROCESSING_GRAPH__GRAPH:
				setGraph((Graph)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case JgraphxPackage.PREPROCESSING_GRAPH__GRAPH:
				return graph != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * 
	 * @param cell
	 * @param edges
	 * @param dataPort
	 * @param constellation
	 * @return Map: filter task (cell) -> edge (the source and the edge toward the task, for which filtering/merging has to done)
	 * @throws TaskNotFoundException
	 * @throws DataLinkNotFoundException
	 * @throws ToolNotFoundException
	 * @throws UtilityTaskNotFoundException
	 * @throws DataPortNotFoundException 
	 */
	private EMap<mxICell, DataLink> createFilterTasks(mxICell cell, EList<mxICell> edges, 
										DataPort dataPort,  
										String groupingStr, int constellation)
										
						throws TaskNotFoundException, 
								DataLinkNotFoundException, 
								ToolNotFoundException, 
								UtilityTaskNotFoundException, DataPortNotFoundException
	{
		
		//boolean rc = false;
		//boolean modeUnion=false;
		Task task = JGraphXUtil.loadTask(cell);
		EMap<mxICell, DataLink> cells = new BasicEMap<mxICell, DataLink>();
		EMap<String, EList<TraversalChunk>> coveredChunks = null;

		
		logger.debug("createFilterTasks(): find filterTasks for "+task.getUniqueString()
				+" for grouping="+groupingStr+" (all groupings="+task.getChunks().keySet()+" "+dataPort.getFormat().getName());
		
		for (mxICell edge:edges)
		{
			DataLink dataLink = JGraphXUtil.loadDataLink(edge);
			Task sourceTask   = JGraphXUtil.getSourceTask((mxCell) edge);
			Task targetTask   = JGraphXUtil.getTargetTask((mxCell) edge);
			
			logger.debug("createFilterTasks(): flags="+task.getFlags()
					+" (flags>>13="+(task.getFlags() >> 13)+")"
					+" is root="+sourceTask.isRoot());
			if (((task.getFlags() >> 12) & 0x1) == 1)
			{
				logger.debug("createFilterTasks(): no filtering necessary");
				cells.put(JGraphXUtil.getSource((mxCell) edge), dataLink);
				getGraph().getGraph().removeCells(new Object[]{edge}, true);
			}
			else
			{
				TraversalEvent te=task.getTraversalEvents().get(dataLink.getGroupingStr());
				logger.debug("createFilterTasks(): "+dataLink.getGroupingStr()+" "+dataLink.getParentGroupingStr()
						+(te!=null ? "type of te="+te.getType()+" "+te.getTraversalCriterion().getMode(): "")
						+" source tes="+sourceTask.getTraversalEvents().keySet());
				
				EMap<String, EList<TraversalChunk>> currentCoveredChunks = GraphUtil.getCoveredChunks(
					targetTask,
					sourceTask,
					dataLink.getDataPort(),
					groupingStr,
					true
				);
			
				logger.trace("createFilterTasks(): "+currentCoveredChunks.size()+" covered chunks found. "
						+" filter chunks from "+sourceTask.getUniqueString());
				if (currentCoveredChunks.isEmpty())
				{
					logger.debug("createFilterTasks(): no chunks found that can be translated.");	
				}
	
				else
				{
					if (coveredChunks==null)
						coveredChunks=currentCoveredChunks;
					else
						for (Entry<String, EList<TraversalChunk>> e:currentCoveredChunks.entrySet())
						{
							//if (coveredChunks.containsKey(e.getKey()))
							coveredChunks.get(e.getKey()).addAll(e.getValue());
						}
					
					logger.debug("createFilterTasks(): constallation="+(constellation & 0x04));
					if ((constellation & 0x04) > 0)
					{
						String utilTaskString = GraphUtil.getUtilityTaskKey(dataLink, "filter");
						Task newTask          = JGraphXUtil.createNewUtilityTask(currentCoveredChunks, utilTaskString, edge);
						mxICell newCell       = (mxICell) GlobalVar.getCells().get(newTask.getUniqueString());
						logger.debug("createFilterTasks(): insert edge: (parent-filter)"+sourceTask.getUniqueString()
								+"->"+newTask.getUniqueString()+" coveredChunks="+coveredChunks.keySet());
						DataLink dataLinkCopy = //copyDataLink(dataLink);
								GraphUtil.createDataLink(dataLink, newTask, false);
						mxICell newEdge       = (mxICell) getGraph().getGraph().insertEdgeEasyFlow(null, null, 
								JGraphXUtil.getSource((mxCell) edge), newCell, dataLinkCopy);
						cells.put(newCell, dataLinkCopy);
					}
					else
					{
						for (Entry<String, EList<TraversalChunk>> e:currentCoveredChunks.entrySet())
						{
							for (TraversalChunk traversalChunk:e.getValue())
							{
								if (sourceTask.canProvideMultipleInputsFor(null, dataPort))
								{
									logger.debug("createFilterTasks(): no filter task necessary (parent provide multiple inputs.) insert edge: "
											+sourceTask.getUniqueString()+"->"+task.getUniqueString()+" with chunk="+e.getKey()+" "+traversalChunk.getName());
									DataLink dataLinkCopy = 
											//copyDataLinkChunk(dataLink, e.getKey(), traversalChunk);
											GraphUtil.createDataLink(dataLink, task, groupingStr, groupingStr, traversalChunk);
									mxICell newCell = (mxICell) GlobalVar.getCells().get(task.getUniqueString());
									mxICell newEdge = (mxICell) getGraph().getGraph().insertEdgeEasyFlow(null, null, 
											JGraphXUtil.getSource((mxCell) edge), newCell, dataLinkCopy);
									//cells.put(newCell, dataLinkCopy);
									
								}
								else 
								{
									EList<TraversalChunk> chunks = new BasicEList<TraversalChunk>();
									EMap<String, EList<TraversalChunk>> curCoveredChunks = new BasicEMap<String, EList<TraversalChunk>>();
									chunks.add(traversalChunk);
									curCoveredChunks.put(e.getKey(), chunks);
									
									String utilTaskString = GraphUtil.getUtilityTaskKey(dataLink, "filter");
									Task newTask          = JGraphXUtil.createNewUtilityTask(curCoveredChunks, utilTaskString, edge);
									logger.debug("createFilterTasks(): insert edge: (parent-filter)"
											+sourceTask.getUniqueString()+"->"+newTask.getUniqueString()
											+" coveredChunks="+curCoveredChunks.keySet()+" single chunk="+groupingStr+" "+traversalChunk.getName());
									DataLink dataLinkCopy = 
											//copyDataLinkChunk(dataLink, groupingStr, traversalChunk);
											GraphUtil.createDataLink(dataLink, newTask, groupingStr, groupingStr, chunks);
									mxICell newCell       = (mxICell) GlobalVar.getCells().get(newTask.getUniqueString());
									mxICell newEdge       = (mxICell) getGraph().getGraph().insertEdgeEasyFlow(null, null, 
											JGraphXUtil.getSource((mxCell) edge), newCell, dataLinkCopy);
									cells.put(newCell, dataLinkCopy);
								}
							}
						}
					}
					getGraph().getGraph().removeCells(new Object[]{edge}, true);
				}
			}
		}
		return cells;
	}


	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JgraphxPackage.Literals.PREPROCESSING_GRAPH;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Graph getGraph() {
		if (graph != null && graph.eIsProxy()) {
			InternalEObject oldGraph = (InternalEObject)graph;
			graph = (Graph)eResolveProxy(oldGraph);
			if (graph != oldGraph) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, JgraphxPackage.PREPROCESSING_GRAPH__GRAPH, oldGraph, graph));
			}
		}
		return graph;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Graph basicGetGraph() {
		return graph;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGraph(Graph newGraph) {
		Graph oldGraph = graph;
		graph = newGraph;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JgraphxPackage.PREPROCESSING_GRAPH__GRAPH, oldGraph, graph));
	}

} //PreprocessingImpl