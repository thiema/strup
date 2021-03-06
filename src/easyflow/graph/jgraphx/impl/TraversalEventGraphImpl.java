/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package easyflow.graph.jgraphx.impl;

import easyflow.util.Severity;
import easyflow.core.Task;
import easyflow.custom.exception.DataLinkNotFoundException;
import easyflow.custom.exception.TaskNotFoundException;
import easyflow.graph.jgraphx.Graph;
import easyflow.custom.exception.TraversalChunkNotFoundException;
import easyflow.custom.jgraphx.graph.JGraphXUtil;
import easyflow.custom.ui.GlobalConfig;
import easyflow.custom.util.GlobalConstants;
import easyflow.custom.util.GlobalVar;
import easyflow.custom.util.GraphUtil;
import easyflow.custom.util.Util;
import easyflow.data.DataLink;
import easyflow.graph.impl.DefaultGraphImpl;
import easyflow.graph.jgraphx.JgraphxPackage;
import easyflow.graph.jgraphx.TraversalEventGraph;
import easyflow.graph.jgraphx.TraversalCriteria;
import easyflow.metadata.GroupingInstance;
import easyflow.traversal.TraversalChunk;
import easyflow.traversal.TraversalEvent;

import easyflow.util.ReturnValue;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.mxgraph.model.mxCell;
import com.mxgraph.model.mxICell;
import com.mxgraph.view.mxGraph.mxICellVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Traversal Criteria</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link easyflow.graph.jgraphx.impl.TraversalEventGraphImpl#getGraph <em>Graph</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TraversalEventGraphImpl extends DefaultGraphImpl implements TraversalEventGraph {
	
	private static Logger logger = Logger.getLogger(TraversalCriteria.class);
	
	/**
	 * The cached value of the '{@link #getGraph() <em>Graph</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGraph()
	 * @generated
	 * @ordered
	 */
	protected Graph graph;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TraversalEventGraphImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	public boolean applyTraversalEvent(mxICell root, TraversalEvent traversalEvent, 
			String groupingStr, GroupingInstance groupingInstance) throws TaskNotFoundException {
		
		boolean rc;
		EList<GroupingInstance> groupingInstances = new BasicEList<GroupingInstance>();
		groupingInstances.add(groupingInstance);
		rc = applyTraversalEvent(root, traversalEvent, groupingStr, groupingInstances);
		if (!traversalEvent.isGrouping())
			getGraph().getGraph().removeCells(new Object[]{root}, true);
		return rc;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * apply the traversal event:
	 * go along the "template" graph defined by the parent cell
	 * and create a new cell for each chunk that is defined 
	 * for associated traversal event and integrate it into the main graph 
	 * (it can be seen as: copying the graph, one copy per chunklist)
	 * <!-- end-user-doc -->
	 * @throws TaskNotFoundException 
	 * @generated not
	 */
	
	public boolean applyTraversalEvent(mxICell root, 
			final TraversalEvent traversalEvent,
			final String groupingStr,
			final EList<GroupingInstance> groupingInstances
			//final String groupingInstance
			) throws TaskNotFoundException 
	{
		
		
		//final EMap<String, EList<String>> possibleMergeParents = new BasicEMap<String, EList<String>>();
		final EMap<String, mxICell> mergeCells   = new BasicEMap<String, mxICell>();
		// only used in case of param criterion
		final EList<String>         mergeTasks   = new BasicEList<String>();
		final EList<Boolean>        rc           = new BasicEList<Boolean>();
		rc.add(new Boolean(true));
		if (!traversalEvent.isGrouping())
			for (Task mergeTask:traversalEvent.getMergeTask())
				mergeTasks.add(mergeTask.getName());
		
		mxICellVisitor visitor=new mxICellVisitor() {
			
			
			@Override
			public boolean visit(Object vertex, Object edge) {
				// set the current task
				Task task = null;
				try {
					task = JGraphXUtil.loadTask(vertex);
				} catch (TaskNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String taskString = task.getUniqueString();
				logger.trace(
						"applyTraversalEvent(): "+taskString 
						+ " #mergeTasks="        +traversalEvent.getMergeTask().size()
						+ " #incomingTasks("     +task.getPreviousTaskStr()
						+ ")="                   +getGraph().getGraph().getIncomingEdges(GlobalVar.getCells().get(task.getPreviousTaskStr())).length
						+ " dataPort="           +traversalEvent.getTraversalCriterion().getDataPort().getName()
						);
				// apply the splitting criterion, i.e. check for all old parents
				// (task.getPreviousTask(), which doesn't have the te applied)				
				if (!task.isRoot())
				{
					logger.debug("applyTraversalEvent(): process "
							+getGraph().getGraph().getIncomingEdges(GlobalVar.getCells().get(task.getPreviousTaskStr())).length
							+" ingoing edges of prev task="+task.getPreviousTaskStr());
					
					for (Object edgeIn : getGraph().getGraph().getIncomingEdges(
							GlobalVar.getCells().get(task.getPreviousTaskStr())))
					{
						Object parentCell = JGraphXUtil.getSource((mxCell) edgeIn);
								//getGraph().getView().getVisibleTerminal(edgeIn, true);
						try {
							DataLink dataLink=JGraphXUtil.loadDataLink(edgeIn);
							logger.debug("applyTraversalEvent(): check datalink for "
									+" parent="+JGraphXUtil.getSourceTask((mxCell) edgeIn).getUniqueString()
									+" child="+JGraphXUtil.getTargetTask((mxCell) edgeIn).getUniqueString()
									+" link: group="+dataLink.getGroupingStr()
									+" port="+dataLink.getDataPort().getName()
									+" conditional="+!dataLink.isUnconditional()
									+" te parents="+GraphUtil.getTaskStringList(traversalEvent.getParentTask())
							);
							if (!traversalEvent.isGrouping())
							{
								//logger.debug(" isProcessed="+dataLink.isProcessed()+" ");
								if (dataLink.isProcessed())
									continue;
							}
							
							boolean shallProcess=true;
							if (traversalEvent.isGrouping() && !dataLink.isUnconditional()) // check the datalink condition
								shallProcess = (task.shallProcess(groupingInstances, groupingStr, 
													dataLink.getCondition().getForbidden(), true) &&
												!dataLink.getCondition().getCircumventingParents().
													containsAll(GraphUtil.getTaskStringList(traversalEvent.getParentTask()))
												);
							
							logger.debug("applyTraversalEvent(): check creation ("
									+" conditional="+!dataLink.isUnconditional()
									+", shallProcess="+shallProcess+" "
									+") of edge (to parent="
									+JGraphXUtil.getSourceTask((mxCell) edgeIn).getUniqueString()+") mode="
									+traversalEvent.getTraversalCriterion().getMode());
							
							if (dataLink.isUnconditional() || shallProcess)
							{
								applySplittingCriterion((mxICell) vertex,
									(mxICell) parentCell, edgeIn, groupingStr, 
									traversalEvent.getTraversalCriterion().getMode(),
									traversalEvent.isGrouping());
								logger.debug("applyTraversalEvent(): add "+taskString+" for key="+task.getPreviousTaskStr());
							}
						} catch (TaskNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (DataLinkNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (TraversalChunkNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				logger.trace("applyTraversalEvent():"
						+" mergeTasks="     +GraphUtil.getTaskStringList(traversalEvent.getMergeTask())
						+" size="           +traversalEvent.getMergeTask().size()
						+" depTE="			+traversalEvent.getDepNum()
						+" previousTaskStr="+task.getPreviousTaskStr()
						+" ("               +task.getUniqueString()+", "
						                    +GlobalVar.getTasks().get(task.getPreviousTaskStr()).getUniqueString()+")");

				if (traversalEvent.isGrouping() && GraphUtil.containsTask(traversalEvent.getMergeTask(),
						GlobalVar.getTasks().get(task.getPreviousTaskStr()))
					)
				{
					mergeCells.put(taskString, (mxICell) vertex);
					logger.debug("applyTraversalEvent(): previousTask="+task.getPreviousTaskStr()+" marked to be merged (for "+task.getUniqueString()+")");
				}
				else if (!traversalEvent.isGrouping())// && mergeTasks.contains(task.getName()))
				{
					mergeCells.put(taskString, (mxICell) vertex);
					logger.debug("applyTraversalEvent(): previousTask="+task.getPreviousTaskStr()+" marked to be merged (for "+task.getUniqueString()+")");
				}
				return true;
			}
		};		
		getGraph().getGraph().getModel().beginUpdate();try{
			getGraph().getGraph().traverse(root, true, visitor);
		JGraphXUtil.layoutGraph();
		}		finally		{			getGraph().getGraph().getModel().endUpdate();		}

		//mergeCells.put(traversalEvent.getSplitTask().getUniqueString(), getCells().get(traversalEvent.getSplitTask().getUniqueString()));
		logger.debug("applyTraversalEvent(): process merging cells="+mergeCells.keySet());
		// apply the mergingTasks
		for (String mergeTaskStr : mergeCells.keySet())
		{
			logger.debug("applyTraversalEvent(): merge task:"+mergeTaskStr+" ("+GlobalVar.getTasks().get(mergeTaskStr).getPreviousTaskStr()+")");
			try {
				applyMergingCriterion(mergeCells.get(mergeTaskStr), 
						(mxICell) GlobalVar.getCells().get(GlobalVar.getTasks().get(mergeTaskStr).getPreviousTaskStr()), 
						groupingStr, groupingInstances, traversalEvent.isGrouping());
			} catch (DataLinkNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (TraversalChunkNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return rc.get(0).booleanValue();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @throws TaskNotFoundException 
	 * @generated not
	 */
	public boolean applyTraversalEventCopyGraph(mxICell root, TraversalEvent traversalEvent, 
			GroupingInstance groupingInstance, ReturnValue returnCell) throws TaskNotFoundException {
		
		EList<GroupingInstance> groupingInstances = new BasicEList<GroupingInstance>();
		groupingInstances.add(groupingInstance);
		
		if (traversalEvent.isGrouping())
			return applyTraversalEventCopyGraph(root, traversalEvent, groupingInstances, returnCell);
		else
			return applyTraversalEventCopyGraph_Param(root, traversalEvent, groupingInstances, returnCell);
	}

	
	/**
	 * <!-- begin-user-doc -->
	 * apply the traversal criterion to the subgraph copy 
	 * - stop when grouping is not a valid along an edge
	 * - stop if task is not applicable to the grouping definition
	 * - stop if condition does not fit the conditional edge
	 * <!-- end-user-doc -->
	 * @throws TaskNotFoundException
	 * @generated not
	 */
	public boolean applyTraversalEventCopyGraph(mxICell root, 
			final TraversalEvent traversalEvent, 
			final EList<GroupingInstance> groupingInstances,
			final ReturnValue returnCell) throws TaskNotFoundException {

		logger.debug("applyTraversalEventCopyGraph()");
		final String               groupingStr              = traversalEvent.getTraversalCriterion().getId();
		final EMap<String, String> taskPreviousTaskMap      = new BasicEMap<String, String>();
		final EList<Task>          lastTask                 = new BasicEList<Task>();
		final EList<Boolean>       rc                       = new BasicEList<Boolean>();
		final Boolean rcTrue = new Boolean(true);
		final Boolean rcFalse = new Boolean(false);
		rc.add(rcTrue);
		
		returnCell.setObject(null);

		EList<String> instances = new BasicEList<String>(); 
		for (GroupingInstance groupingInstance : groupingInstances)
			instances.add(groupingInstance.getName());
			
		logger.trace("applyTraversalEventCopyGraph(): group="+groupingStr+" instance="+StringUtils.join(instances.toArray(), ","));
		mxICellVisitor visitor=new mxICellVisitor() {
			String debug="";
			
			@Override
			public boolean visit(Object vertex, Object edge) {
				// set the current task
				Task task = null;
				DataLink inDataLink = null;
				try {
					task = JGraphXUtil.loadTask(vertex);
					if (edge != null)
						inDataLink = JGraphXUtil.loadDataLink(edge);
					else
						lastTask.clear();
				} catch (TaskNotFoundException e) {
					rc.set(0, rcFalse);
					return false;
				} catch (DataLinkNotFoundException e) {
					rc.set(0, rcFalse);
					return false;
				}
				
				if (GlobalConfig.getDebugTasks().contains(task.getName()))
					logger.debug("debugging task="+task.getName());
						
				String taskString = task.getUniqueString();
				logger.debug("applyTraversalEventCopyGraph(): check task="+task.getUniqueString()
						+" group="+groupingStr
						+" valid="+GraphUtil.isValidConversion(task.getChunks(), groupingStr, groupingInstances)
						+" inDataLink is uncond="+(inDataLink!=null?inDataLink.isUnconditional():null)
						);
				
				boolean shouldAddCircumventingParents = false;
				// check special conditions to possibly break this path and stop copying tasks
				if (!GraphUtil.isValidConversion(task.getChunks(), groupingStr, groupingInstances))
				{
					logger.info("applyTraversalEventCopyGraph(): skip traversal. Cannot convert between "
							+ "chunks " +task.getChunks().keySet()
							+" and "+Util.list2String(groupingInstances, ",")
							+" for grouping="+groupingStr);
					
					return false;
				}
				if (!task.shallProcess(groupingInstances, groupingStr))
				{
					logger.info("applyTraversalEventCopyGraph(): skip traversal due to unmet "
							+ "condition = "+task.getJexlString()
							+" of task ="+task.getUniqueString()
							+" (mergetasks="+Util.tasksToStringList(traversalEvent.getMergeTask())
							+" lasttask="+(lastTask.isEmpty() ? null : lastTask.get(0).getUniqueString())
							+")");
					getLogMessage().generateLogMsg(
							GlobalConstants.LOG_MSG_APPLY_TRAVERSAL_EVENT_SKIP_CONDITIONAL_TASK_2,
							Severity.INFO,
							Util.generateStringList(taskString, task.getJexlString()));
					if (!lastTask.isEmpty())
					{
						logger.debug("applyTraversalEventCopyGraph(): is contained?="+traversalEvent.getMergeTask().contains(lastTask.get(0)));
						if (!traversalEvent.getMergeTask().contains(lastTask.get(0)))
						{
							logger.debug("applyTraversalEventCopyGraph(): update traversalEvents merge task list. Adding task="+lastTask.get(0).getUniqueString());
							traversalEvent.getMergeTask().add(lastTask.get(0));
						}
					}
					return false;
				}
				
				if (inDataLink != null && !inDataLink.isUnconditional())
				{
					logger.debug("applyTraversalEventCopyGraph(): check conditional edge.  "
							+" circumventing parents="+inDataLink.getCondition().getCircumventingParents()
							+" shall process="+GlobalVar.getTasks().get(inDataLink.getCondition().getCircumventingParents().get(0)).
							shallProcess(groupingInstances, groupingStr, 
									inDataLink.getCondition().getForbidden(),
									true)
					);
					// skip, because this processing is not permitted
					if (!task.shallProcess(groupingInstances, groupingStr, 
						inDataLink.getCondition().getForbidden(),
						true))
					{
						logger.info("skip due to unpermitted conditions: "+inDataLink.getCondition().getForbidden());
						return false;
					}
					// skip, because the circumventing parent
					else if (!GraphUtil.shallProcess(inDataLink.getCondition().getCircumventingParents(),
										groupingInstances, groupingStr, 
										inDataLink.getCondition().getForbidden(),
										true)
							)
					{
						logger.info("skip due to unpermitted conditions: "+inDataLink.getCondition().getForbidden());
						return false;
					}
					else if (!inDataLink.getCondition().isUnconditional())
					{
						shouldAddCircumventingParents=true;
					}
				}
				// create the new task/cell and add it to a map with key of 
				// tasks unique string (without the current instance information resolved)
				
				Task copyTask = GraphUtil.createTask(task, groupingStr, groupingInstances); 

				if (shouldAddCircumventingParents)
				{
					copyTask.getCircumventingParents().addAll(
							inDataLink.getCondition().getCircumventingParents());
				}

				logger.trace("applyTraversalEventCopyGraph(): prevTaskStringMap put: "+taskString+"->"+copyTask.getUniqueString());
				taskPreviousTaskMap.put(taskString, copyTask.getUniqueString());
				mxICell cell = null;
				if (GlobalVar.getTasks().containsKey(copyTask.getUniqueString()))
				{
					cell = (mxICell) GlobalVar.getCells().get(copyTask.getUniqueString());
				}
				else 
				{
					GlobalVar.getTasks().put(copyTask.getUniqueString(), copyTask);
					logger.trace("applyTraversalEventCopyGraph(): added task with key:"+copyTask.getUniqueString()+" in global tasks map.");
					// create the new cell
					cell = (mxICell) getGraph().getGraph().insertVertexEasyFlow(null, null, copyTask);
					logger.debug("applyTraversalEventCopyGraph(): added vertex:"+copyTask.getUniqueString());
				
					GlobalVar.getCells().put(copyTask.getUniqueString(), (mxICell) cell);
					if (task.isRoot())
					{
						getGraph().setDefaultRootCell(cell);
					}
				}				
				
				if (returnCell.getObject() == null) 
					returnCell.setObject(cell);
				
				boolean skipTerminalEdgeProcessing = false;
				if (edge != null)
				{
					try 
					{
						Task source = null;
						source = JGraphXUtil.getSourceTask((mxCell) edge);
						//DataLink oldDataLink=loadDataLink(edge);
						logger.debug("applyTraversalEventCopyGraph(): try to insert edge:"
								+(source!=null?source.getUniqueString():null)
								+" ("+taskPreviousTaskMap.get(source.getUniqueString())+") "
								+"->"+copyTask.getUniqueString()
								);
						if (
							getGraph().getProcessedEdgesCopyGraph().
								containsKey(taskPreviousTaskMap.get(source.getUniqueString())) &&
							getGraph().getProcessedEdgesCopyGraph().get(taskPreviousTaskMap.
								get(source.getUniqueString())).equals(copyTask.getUniqueString())
							)
						{
							skipTerminalEdgeProcessing = true;
							logger.debug("applyTraversalEventCopyGraph(): skip already inserted edge");
						}
						else
						{
							String taskStr=taskPreviousTaskMap.get(source.getUniqueString());

							try {
								DataLink dataLink = GraphUtil.createDataLink(edge, copyTask, groupingStr, groupingStr, null);
								
								logger.debug("applyTraversalEventCopyGraph(): insert edge (inserted!)");
								getGraph().getGraph().insertEdgeEasyFlow(null, null, 
										GlobalVar.getCells().get(taskStr),
										cell,
										dataLink
										);
								getGraph().getProcessedEdgesCopyGraph().put(
										taskPreviousTaskMap.get(source.getUniqueString()),
										copyTask.getUniqueString());
								
							}
							catch (DataLinkNotFoundException e) 
							{
								rc.set(0, rcFalse);
								return false;
							}
						}
					} 
					catch (TaskNotFoundException e) 
					{
						rc.set(0, rcFalse);
						return false;
					}	
				}
				if (!skipTerminalEdgeProcessing)
					applyTraversalEventCopyGraph_terminalEdge(vertex, copyTask, groupingStr, cell);
				
				if (lastTask.isEmpty())
					lastTask.add(task);
				else
					lastTask.set(0, task);
				return true;
			}
		};

		getGraph().getGraph().getModel().beginUpdate();		try		{
			getGraph().getGraph().traverseAllPaths(root, true, visitor, null);
			JGraphXUtil.layoutGraph();
		}		finally		{			getGraph().getGraph().getModel().endUpdate();		}
		
		int numVertices = returnCell.getObject() != null ? 
				getGraph().getGraph().getChildVertices(returnCell.getObject()).length + 1 : 0;
		if (numVertices > 0)
			getLogMessage().generateLogMsg(GlobalConstants.LOG_MSG_APPLY_TRAVERSAL_EVENT_COPY_GRAPH_END_1, Severity.DEBUG, 
				Integer.toString(numVertices));
		else
			getLogMessage().generateLogMsg(GlobalConstants.LOG_MSG_APPLY_TRAVERSAL_EVENT_COPY_GRAPH_NO_VERTICES_COPIED_0, Severity.DEBUG, (String)null);			

		return rc.get(0).booleanValue();
	}

	private void applyTraversalEventCopyGraph_terminalEdge(Object vertex, Task task, String groupingStr, Object sourceVertex)
	{
		// special handling for terminal edges
		int i = 0;
		for (Object o : getGraph().getGraph().getOutgoingEdges(vertex))
		{
			try {
				DataLink odl = JGraphXUtil.loadDataLink(o);
				if (odl.isTerminal())
				{
					//logger.debug(getGraph().getOutgoingEdges(sourceVertex).length);
					logger.debug("applyTraversalEventCopyGraph(): insert "+(i++)+"-th terminal edge for task="+task.getUniqueString());
					DataLink dataLink = GraphUtil.createDataLink(o, task, null, groupingStr, null);
					dataLink.setTerminal(true);
					getGraph().getGraph().insertEdgeEasyFlow(null, null, 
								sourceVertex,
								null,
								dataLink
							);
					//logger.debug(getGraph().getOutgoingEdges(sourceVertex).length);
				}
			} catch (DataLinkNotFoundException e) {
				// TODO Automatisch generierter Erfassungsblock
				e.printStackTrace();
			}
		}

	}
	
	private boolean applyTraversalEventCopyGraph_Param(mxICell root, 
			final TraversalEvent traversalEvent, 
			final EList<GroupingInstance> groupingInstances,
			final ReturnValue returnCell) throws TaskNotFoundException {
		
		final String               groupingStr         = traversalEvent.getTraversalCriterion().getId();
		final EMap<String, String> taskPreviousTaskMap = new BasicEMap<String, String>();
		returnCell.setObject(null);
		
		mxICellVisitor visitor=new mxICellVisitor() {
			String debug="";
			
			@Override
			public boolean visit(Object vertex, Object edge) {
				// set the current task
				
				
				try {
					Task task = JGraphXUtil.loadTask(vertex);
					
					String taskString = task.getUniqueString();
					// test if the current task is already specified with the current param
					//if (task.getGroupingCriteria().containsKey(traversalEvent.getTraversalCriterion().getName()))
					logger.debug("applyTraversalEventCopyGraph_Param(): processed events so far="+task.getChunks().keySet()
							+" cur crit name="+traversalEvent.getTraversalCriterion().getName()
							+" cur crit source="+traversalEvent.getTraversalCriterion().getChunkSource()
							+" cur crit id="+traversalEvent.getTraversalCriterion().getId());

					Task copyTask = GraphUtil.createTask_Param(task, groupingStr, groupingInstances);
					String debugTask = "RmDup";
					if (task.getName().equals(debugTask))
						logger.debug("debugging task="+debugTask);

					taskPreviousTaskMap.put(taskString, copyTask.getUniqueString());
					mxICell cell = null;
					if (GlobalVar.getTasks().containsKey(copyTask.getUniqueString()))
					{
						cell = (mxICell) GlobalVar.getCells().get(copyTask.getUniqueString());
					}
					else 
					{
						GlobalVar.getTasks().put(copyTask.getUniqueString(), copyTask);
						logger.debug("applyTraversalEventCopyGraph_Param(): added key:"+copyTask.getUniqueString()+" "+GlobalVar.getTasks().keySet());
						// create the new cell
						cell = (mxICell) getGraph().getGraph().insertVertexEasyFlow(null, null, copyTask);
						logger.debug("applyTraversalEventCopyGraph_Param(): added vertex:"+copyTask.getUniqueString());
					
						GlobalVar.getCells().put(copyTask.getUniqueString(), (mxICell) cell);
					}
					if (returnCell.getObject() == null)
						returnCell.setObject(cell);
					
					if (edge != null)
					{
						for (Object edgeIn : getGraph().getGraph().getIncomingEdges(vertex))
						{
							Task     source   = JGraphXUtil.getSourceTask((mxCell) edgeIn);
							String   taskStr  = taskPreviousTaskMap.get(source.getUniqueString());
							
							String debugSource = "RmDup";
							String debugTarget = "IndexSam";
							if (source.getName().equals(debugSource) && task.getName().equals(debugTarget))
							{
								DataLink dl = JGraphXUtil.loadDataLink(edgeIn);
								logger.debug("debug "+debugSource+"=>"+debugTarget);
							}
							DataLink dataLink = GraphUtil.createDataLink_Param_GroupingInstances(edgeIn, copyTask, groupingStr, groupingInstances);
							
							getGraph().getGraph().insertEdgeEasyFlow(null, null, 
									GlobalVar.getCells().get(taskStr),
									cell,
									dataLink
									);
							logger.debug("applyTraversalEventCopyGraph_Param(): insert edge="+taskStr+"->"+copyTask.getUniqueString()
									+" dataLink="+dataLink.getUniqueString(null, null, null)+" "+dataLink.getId()
										);
						}
					}
					applyTraversalEventCopyGraph_terminalEdge(vertex, copyTask, groupingStr, cell);
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
			getGraph().getGraph().traverseTopologicalOrder(root, visitor);
			JGraphXUtil.layoutGraph();
		}		finally		{			getGraph().getGraph().getModel().endUpdate();		}

		return returnCell.getObject() != null;
	}

	private String getMoreGranularGroupingCriterion(String crit1, String crit2)
	{
		if (GlobalConstants.METADATA_INPUT.equals(crit1))
			return crit1;
		else if (GlobalConstants.METADATA_INPUT.equals(crit2))
			return crit2;
		else
			return GlobalConstants.TRAVERSAL_CRITERION_RECORD;
			
	}
	
	private void applySplittingCriterion(mxICell cell, mxICell parentCell,
			Object edgeIn, final String groupingStr, String mode,
			boolean isGrouping) throws TaskNotFoundException,
			DataLinkNotFoundException, TraversalChunkNotFoundException {
		
		boolean modeRequireAll = true;
		// boolean modeUseFirstMatchingGroupingStr = true;
		boolean requireAllChunks = false;
		boolean requireAllInstances = true;

		if (mode.equals("batch")) {
			// batch
			requireAllChunks = true;
			requireAllInstances = false;
			modeRequireAll = false;
		} else {
			// when task is in joint mode
			requireAllChunks = false;
			requireAllInstances = true;
			modeRequireAll = true;
		}

		// String currentParentGroupingStr = "";
		DataLink dataLink = JGraphXUtil.loadDataLink(edgeIn);

		// setup the chunks
		Task parentTask = JGraphXUtil.loadTask((parentCell));
		Task task       = JGraphXUtil.loadTask(cell);
		//EList<TraversalChunk> overlap = task.getOverlappingRecordsProvidedBy(parentTask);
		EList<TraversalChunk> overlap = isGrouping ? 
				task.getOverlappingChunksFor(parentTask, 
				getMoreGranularGroupingCriterion(groupingStr, dataLink.getParentGroupingStr())) :
					dataLink.getChunks().get(dataLink.getParentGroupingStr())
					//task.getChunks().get(dataLink.getParentGroupingStr())
				;
		logger.trace("applySplittingCriterion(): test parentTask="
				+ parentTask.getUniqueString() + " for "
				+ task.getUniqueString() + " #(parents chunks)="
				+ parentTask.getChunks().size()
				+ " grouping="+groupingStr+" ("+dataLink.getGroupingStr()+")"
				+ " parentGrouping="+dataLink.getParentGroupingStr()
				+ " parent is root="+parentTask.isRoot()
				+ " isgrouping="+isGrouping 
				+ " overlapping recs="+(overlap != null ? overlap.size() : null)
		);
		if (overlap == null)
			logger.error("applySplittingCriterion(): no overlapping chunks found");
		else
			logger.debug("applySplittingCriterion(): task="+task.getUniqueString()+" chunks="+Util.list2String(overlap, ","));
		
		if (parentTask.isRoot() && !parentTask.getGroupingCriteria().containsKey(groupingStr)) {
			
				//DataLink newDataLink = GraphUtil.createDataLink(dataLink, task, groupingStr, null, traversalChunk);
			DataLink newDataLink = GraphUtil.createDataLink(edgeIn, parentTask, 
						isGrouping ? groupingStr : null, 
						null, 
						overlap, !isGrouping ? groupingStr : null);
				
			logger.debug("applySplittingCriterion(): insert edge: "
						+ parentTask.getUniqueString() + " ->"
						+ task.getUniqueString()+" case=root"+" static="+newDataLink.getDataPort().isStatic()+" added="+getGraph().getAddEdges().keySet());				

			getGraph().getGraph().insertEdgeEasyFlow(null, null, parentCell, cell, newDataLink);
				
		} else {
			if (!isGrouping ||
				!task.getOverlappingRecordsProvidedBy(parentTask).isEmpty()
				)
			{
				getGraph().getGraph().insertEdgeEasyFlow(null, null, parentCell, cell,
						GraphUtil.createDataLink(edgeIn, parentTask, isGrouping ? groupingStr : null, null, overlap, !isGrouping ? groupingStr : null));
				logger.debug("applySplittingCriterion(): insert edge: "
						+ parentTask.getUniqueString() + " ->"
						+ task.getUniqueString()+" case=non root");
			}
		}
	}

	private void applyMergingCriterion(mxICell cell, mxICell previousCell,
							String groupingStr, EList<GroupingInstance> groupingInstances, 
							boolean isGrouping)
									throws TaskNotFoundException, DataLinkNotFoundException, TraversalChunkNotFoundException 
		{
		logger.trace("applyMergingCriterion(): "
				+" num outgoing edges = "+ getGraph().getGraph().getOutgoingEdges(previousCell).length + " "
				+" num vertices = "+ getGraph().getGraph().getVertices(cell).size());

		Task task = JGraphXUtil.loadTask(cell);
		// TraversalEvent traversalEvent =
		// task.getTraversalEvents().get(groupingStr);
		// get all child cells
		for (Object edgeOut : getGraph().getGraph().getOutgoingEdges(previousCell)) {
			Object childCell = JGraphXUtil.getTarget((mxCell) edgeOut);
			if (childCell == null)
				continue;
			Task childTask = JGraphXUtil.loadTask(((mxICell) childCell));
			DataLink outDataLink = JGraphXUtil.loadDataLink(edgeOut);

			logger.trace("applyMergingCriterion(): " + "test edge: "
					+ task.getUniqueString()
					// +" (cell:"+cell+") "
					+ "->" + childTask.getUniqueString()
			// +"(cell"+childCell+")"
			);
			// logger.debug(childTask.getCircumventingParents());
			
			if (outDataLink != null) {
				if (!isGrouping) {
					// logger.debug(" isProcessed="+outDataLink.isProcessed()+" ");
					if (outDataLink.isProcessed())
						continue;
				}

				if (
				// test for conditional edges
				(outDataLink.isUnconditional() || !isGrouping || 
					(
					outDataLink.getCondition() != null 				&&
					(!outDataLink.getCondition().
						getCircumventingParents().isEmpty()			&& 
					GraphUtil.shallProcess(outDataLink.getCondition()
						.getCircumventingParents(), groupingInstances,
							groupingStr, outDataLink.getCondition()
								.getForbidden(), true) 				&&
					childTask.shallProcess(groupingInstances, groupingStr,
							(outDataLink.getCondition() != null ? 
									outDataLink.getCondition().
									getForbidden() : null),
							true)))
				) && 
				(!getGraph().getMetaData().containsColumn(groupingStr) ||
					(task.shallProcess(groupingInstances, groupingStr) && 
					childTask.shallProcess(groupingInstances, groupingStr)))
				) 
				{
					DataLink dataLink = GraphUtil.createDataLink(edgeOut, task,
							null, isGrouping ? groupingStr : null, null,
							!isGrouping ? groupingStr : null);

					if (
					// getProcessedEdgesCopyGraph().keySet().contains(task.getUniqueString())
					JGraphXUtil.isEdgeInGraph(task, childTask, dataLink))
						logger.trace("applyMergingCriterion(): skip inserting edge (already processed)");

					// insert edge from cell to its child cell
					else {
						logger.debug("applyMergingCriterion(): "
								+ "insert edge: " + task.getUniqueString()
								+ "->" + childTask.getUniqueString() + ")"
								+ " port=" + dataLink.getUniqueString());

						getGraph().getGraph().insertEdgeEasyFlow(null, null,
								cell, childCell, dataLink);
						// getProcessedEdges().put(task.getUniqueString(),
						// childTask.getUniqueString());
					}
				} else {
					logger.debug("applyMergingCriterion(): skip inserting edge to task "
							+ childTask.getUniqueString()
							+ " due unmatched condition.");

					if (getGraph().getGraph().getIncomingEdges(childCell).length == 1) {
						getLogMessage()
								.generateLogMsg(
										GlobalConstants.LOG_MSG_APPLY_TRAVERSAL_EVENT_REMOVE_MERGE_TASK_DUE_TO_CONDITION_2,
										Severity.INFO,
										Util.generateStringList(
												childTask.getUniqueString(),
												childTask.getJexlString()));
						logger.info("applyMergingCriterion(): mark task "
								+ childTask.getUniqueString()
								+ " to be removed. "
								+ "(No ingoing dataports other than the one omitted by condition.)");
						// childTask.setFlags(childTask.getFlags() | 0x0100);
					}

				}
			} else
				logger.debug("applyMergingCriterion(): skip inserting edge due datalink null pointer.");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case JgraphxPackage.TRAVERSAL_EVENT_GRAPH__GRAPH:
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
			case JgraphxPackage.TRAVERSAL_EVENT_GRAPH__GRAPH:
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
			case JgraphxPackage.TRAVERSAL_EVENT_GRAPH__GRAPH:
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
			case JgraphxPackage.TRAVERSAL_EVENT_GRAPH__GRAPH:
				return graph != null;
		}
		return super.eIsSet(featureID);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case JgraphxPackage.TRAVERSAL_EVENT_GRAPH___APPLY_TRAVERSAL_EVENT__MXICELL_TRAVERSALEVENT_STRING_GROUPINGINSTANCE:
				try {
					return applyTraversalEvent((mxICell)arguments.get(0), (TraversalEvent)arguments.get(1), (String)arguments.get(2), (GroupingInstance)arguments.get(3));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case JgraphxPackage.TRAVERSAL_EVENT_GRAPH___APPLY_TRAVERSAL_EVENT__MXICELL_TRAVERSALEVENT_STRING_ELIST:
				try {
					return applyTraversalEvent((mxICell)arguments.get(0), (TraversalEvent)arguments.get(1), (String)arguments.get(2), (EList<GroupingInstance>)arguments.get(3));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case JgraphxPackage.TRAVERSAL_EVENT_GRAPH___APPLY_TRAVERSAL_EVENT_COPY_GRAPH__MXICELL_TRAVERSALEVENT_GROUPINGINSTANCE_RETURNVALUE:
				try {
					return applyTraversalEventCopyGraph((mxICell)arguments.get(0), (TraversalEvent)arguments.get(1), (GroupingInstance)arguments.get(2), (ReturnValue)arguments.get(3));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case JgraphxPackage.TRAVERSAL_EVENT_GRAPH___APPLY_TRAVERSAL_EVENT_COPY_GRAPH__MXICELL_TRAVERSALEVENT_ELIST_RETURNVALUE:
				try {
					return applyTraversalEventCopyGraph((mxICell)arguments.get(0), (TraversalEvent)arguments.get(1), (EList<GroupingInstance>)arguments.get(2), (ReturnValue)arguments.get(3));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JgraphxPackage.Literals.TRAVERSAL_EVENT_GRAPH;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, JgraphxPackage.TRAVERSAL_EVENT_GRAPH__GRAPH, oldGraph, graph));
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
			eNotify(new ENotificationImpl(this, Notification.SET, JgraphxPackage.TRAVERSAL_EVENT_GRAPH__GRAPH, oldGraph, graph));
	}

} //TraversalCriteriaImpl
