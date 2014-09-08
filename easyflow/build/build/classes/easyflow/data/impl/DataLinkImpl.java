/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package easyflow.data.impl;

import easyflow.core.Condition;
import easyflow.core.PreprocessingTask;
import easyflow.custom.util.Util;
import easyflow.data.Data;
import easyflow.data.DataFormat;
import easyflow.data.DataLink;
import easyflow.data.DataPackage;
import easyflow.data.DataPort;
import easyflow.traversal.TraversalChunk;
import easyflow.util.maps.MapsPackage;
import easyflow.util.maps.impl.StringToChunksMapImpl;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import org.apache.commons.lang.StringUtils;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Link</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link easyflow.data.impl.DataLinkImpl#getDataPort <em>Data Port</em>}</li>
 *   <li>{@link easyflow.data.impl.DataLinkImpl#getInDataPort <em>In Data Port</em>}</li>
 *   <li>{@link easyflow.data.impl.DataLinkImpl#getChunks <em>Chunks</em>}</li>
 *   <li>{@link easyflow.data.impl.DataLinkImpl#getId <em>Id</em>}</li>
 *   <li>{@link easyflow.data.impl.DataLinkImpl#getGroupingStr <em>Grouping Str</em>}</li>
 *   <li>{@link easyflow.data.impl.DataLinkImpl#getParentGroupingStr <em>Parent Grouping Str</em>}</li>
 *   <li>{@link easyflow.data.impl.DataLinkImpl#getParamStr <em>Param Str</em>}</li>
 *   <li>{@link easyflow.data.impl.DataLinkImpl#getParamNameStr <em>Param Name Str</em>}</li>
 *   <li>{@link easyflow.data.impl.DataLinkImpl#isIdenticalGrouping <em>Identical Grouping</em>}</li>
 *   <li>{@link easyflow.data.impl.DataLinkImpl#getCondition <em>Condition</em>}</li>
 *   <li>{@link easyflow.data.impl.DataLinkImpl#getIntermediateTasks <em>Intermediate Tasks</em>}</li>
 *   <li>{@link easyflow.data.impl.DataLinkImpl#getData <em>Data</em>}</li>
 *   <li>{@link easyflow.data.impl.DataLinkImpl#isTerminal <em>Terminal</em>}</li>
 *   <li>{@link easyflow.data.impl.DataLinkImpl#isProcessed <em>Processed</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DataLinkImpl extends EObjectImpl implements DataLink {
	/**
	 * The cached value of the '{@link #getDataPort() <em>Data Port</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataPort()
	 * @generated
	 * @ordered
	 */
	protected DataPort dataPort;

	/**
	 * The cached value of the '{@link #getInDataPort() <em>In Data Port</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInDataPort()
	 * @generated
	 * @ordered
	 */
	protected DataPort inDataPort;

	/**
	 * The cached value of the '{@link #getChunks() <em>Chunks</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChunks()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, EList<TraversalChunk>> chunks;

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final int ID_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected int id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getGroupingStr() <em>Grouping Str</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGroupingStr()
	 * @generated
	 * @ordered
	 */
	protected static final String GROUPING_STR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getGroupingStr() <em>Grouping Str</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGroupingStr()
	 * @generated
	 * @ordered
	 */
	protected String groupingStr = GROUPING_STR_EDEFAULT;

	/**
	 * The default value of the '{@link #getParentGroupingStr() <em>Parent Grouping Str</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParentGroupingStr()
	 * @generated
	 * @ordered
	 */
	protected static final String PARENT_GROUPING_STR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getParentGroupingStr() <em>Parent Grouping Str</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParentGroupingStr()
	 * @generated
	 * @ordered
	 */
	protected String parentGroupingStr = PARENT_GROUPING_STR_EDEFAULT;

	/**
	 * The default value of the '{@link #getParamStr() <em>Param Str</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParamStr()
	 * @generated
	 * @ordered
	 */
	protected static final String PARAM_STR_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getParamStr() <em>Param Str</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParamStr()
	 * @generated
	 * @ordered
	 */
	protected String paramStr = PARAM_STR_EDEFAULT;

	/**
	 * The default value of the '{@link #getParamNameStr() <em>Param Name Str</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParamNameStr()
	 * @generated
	 * @ordered
	 */
	protected static final String PARAM_NAME_STR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getParamNameStr() <em>Param Name Str</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParamNameStr()
	 * @generated
	 * @ordered
	 */
	protected String paramNameStr = PARAM_NAME_STR_EDEFAULT;

	/**
	 * The default value of the '{@link #isIdenticalGrouping() <em>Identical Grouping</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIdenticalGrouping()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IDENTICAL_GROUPING_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIdenticalGrouping() <em>Identical Grouping</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIdenticalGrouping()
	 * @generated
	 * @ordered
	 */
	protected boolean identicalGrouping = IDENTICAL_GROUPING_EDEFAULT;

	/**
	 * The cached value of the '{@link #getCondition() <em>Condition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCondition()
	 * @generated
	 * @ordered
	 */
	protected Condition condition;

	/**
	 * The cached value of the '{@link #getIntermediateTasks() <em>Intermediate Tasks</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntermediateTasks()
	 * @generated
	 * @ordered
	 */
	protected EList<PreprocessingTask> intermediateTasks;

	/**
	 * The cached value of the '{@link #getData() <em>Data</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getData()
	 * @generated
	 * @ordered
	 */
	protected Data data;

	/**
	 * The default value of the '{@link #isTerminal() <em>Terminal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTerminal()
	 * @generated
	 * @ordered
	 */
	protected static final boolean TERMINAL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isTerminal() <em>Terminal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTerminal()
	 * @generated
	 * @ordered
	 */
	protected boolean terminal = TERMINAL_EDEFAULT;

	/**
	 * The default value of the '{@link #isProcessed() <em>Processed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isProcessed()
	 * @generated
	 * @ordered
	 */
	protected static final boolean PROCESSED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isProcessed() <em>Processed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isProcessed()
	 * @generated
	 * @ordered
	 */
	protected boolean processed = PROCESSED_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataLinkImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DataPackage.Literals.DATA_LINK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataPort getDataPort() {
		if (dataPort != null && dataPort.eIsProxy()) {
			InternalEObject oldDataPort = (InternalEObject)dataPort;
			dataPort = (DataPort)eResolveProxy(oldDataPort);
			if (dataPort != oldDataPort) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DataPackage.DATA_LINK__DATA_PORT, oldDataPort, dataPort));
			}
		}
		return dataPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataPort basicGetDataPort() {
		return dataPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDataPort(DataPort newDataPort) {
		DataPort oldDataPort = dataPort;
		dataPort = newDataPort;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.DATA_LINK__DATA_PORT, oldDataPort, dataPort));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataPort getInDataPort() {
		if (inDataPort != null && inDataPort.eIsProxy()) {
			InternalEObject oldInDataPort = (InternalEObject)inDataPort;
			inDataPort = (DataPort)eResolveProxy(oldInDataPort);
			if (inDataPort != oldInDataPort) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DataPackage.DATA_LINK__IN_DATA_PORT, oldInDataPort, inDataPort));
			}
		}
		return inDataPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataPort basicGetInDataPort() {
		return inDataPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInDataPort(DataPort newInDataPort) {
		DataPort oldInDataPort = inDataPort;
		inDataPort = newInDataPort;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.DATA_LINK__IN_DATA_PORT, oldInDataPort, inDataPort));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<String, EList<TraversalChunk>> getChunks() {
		if (chunks == null) {
			chunks = new EcoreEMap<String,EList<TraversalChunk>>(MapsPackage.Literals.STRING_TO_CHUNKS_MAP, StringToChunksMapImpl.class, this, DataPackage.DATA_LINK__CHUNKS);
		}
		return chunks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(int newId) {
		int oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.DATA_LINK__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getGroupingStr() {
		return groupingStr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGroupingStr(String newGroupingStr) {
		String oldGroupingStr = groupingStr;
		groupingStr = newGroupingStr;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.DATA_LINK__GROUPING_STR, oldGroupingStr, groupingStr));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getParentGroupingStr() {
		return parentGroupingStr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentGroupingStr(String newParentGroupingStr) {
		String oldParentGroupingStr = parentGroupingStr;
		parentGroupingStr = newParentGroupingStr;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.DATA_LINK__PARENT_GROUPING_STR, oldParentGroupingStr, parentGroupingStr));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIdenticalGrouping() {
		return identicalGrouping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIdenticalGrouping(boolean newIdenticalGrouping) {
		boolean oldIdenticalGrouping = identicalGrouping;
		identicalGrouping = newIdenticalGrouping;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.DATA_LINK__IDENTICAL_GROUPING, oldIdenticalGrouping, identicalGrouping));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Condition getCondition() {
		if (condition != null && condition.eIsProxy()) {
			InternalEObject oldCondition = (InternalEObject)condition;
			condition = (Condition)eResolveProxy(oldCondition);
			if (condition != oldCondition) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DataPackage.DATA_LINK__CONDITION, oldCondition, condition));
			}
		}
		return condition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Condition basicGetCondition() {
		return condition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCondition(Condition newCondition) {
		Condition oldCondition = condition;
		condition = newCondition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.DATA_LINK__CONDITION, oldCondition, condition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PreprocessingTask> getIntermediateTasks() {
		if (intermediateTasks == null) {
			intermediateTasks = new EObjectResolvingEList<PreprocessingTask>(PreprocessingTask.class, this, DataPackage.DATA_LINK__INTERMEDIATE_TASKS);
		}
		return intermediateTasks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Data getData() {
		if (data != null && data.eIsProxy()) {
			InternalEObject oldData = (InternalEObject)data;
			data = (Data)eResolveProxy(oldData);
			if (data != oldData) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DataPackage.DATA_LINK__DATA, oldData, data));
			}
		}
		return data;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Data basicGetData() {
		return data;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setData(Data newData) {
		Data oldData = data;
		data = newData;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.DATA_LINK__DATA, oldData, data));
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isTerminal() {
		return terminal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTerminal(boolean newTerminal) {
		boolean oldTerminal = terminal;
		terminal = newTerminal;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.DATA_LINK__TERMINAL, oldTerminal, terminal));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isProcessed() {
		return processed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProcessed(boolean newProcessed) {
		boolean oldProcessed = processed;
		processed = newProcessed;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.DATA_LINK__PROCESSED, oldProcessed, processed));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getParamStr() {
		return paramStr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParamStr(String newParamStr) {
		String oldParamStr = paramStr;
		paramStr = newParamStr;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.DATA_LINK__PARAM_STR, oldParamStr, paramStr));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getParamNameStr() {
		return paramNameStr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParamNameStr(String newParamNameStr) {
		String oldParamNameStr = paramNameStr;
		paramNameStr = newParamNameStr;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.DATA_LINK__PARAM_NAME_STR, oldParamNameStr, paramNameStr));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	public boolean isUnconditional() {
		return (getCondition()==null || getCondition().isUnconditional());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	public String getUniqueString(String prefix, String suffix, String sep1) {
		
		String sep = sep1 == null ? "_" : sep1;
		String uniqueString = getUniqueString();
		
		if (prefix != null && !prefix.equals(""))
			uniqueString = prefix + sep + uniqueString;
		if (suffix != null && !suffix.equals(""))
			uniqueString += sep + suffix;
		
		return uniqueString;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	public String getUniqueString() {
		
		String sep1="_";
		String sep2="=";
		String sep3="-";
		
		String uniqueString = getGroupingStr();
		if (getChunks().containsKey(uniqueString) && !getChunks().get(getGroupingStr()).isEmpty())
			uniqueString+=sep2+Util.list2String(getChunks().get(getGroupingStr()), sep3);
		
		
			if (getData() != null && getData().getName() != null && !"".equals(getData().getName()))
				uniqueString+=sep1+getData().getName();
			else 
			{
				if (getData() != null && getData().getPort() != null)
				{
					if (getData().getPort().getName() != null && !"".equals(getData().getPort().getName()))
						uniqueString+=sep1+getData().getPort().getName();					
				}
				else if (getDataPort() != null && getDataPort().getName()!=null && !"".equals(getDataPort().getName()))
				{
					uniqueString+=sep1+getDataPort().getName();
				}
 
			}

		return uniqueString;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	public String getUniqueString(boolean isVerbose) {
		
		String uniqueStr1 = "";
		String uniqueStr2 = "";
		EList<String> uniqueStrs = new BasicEList<String>();
		String sep1="_";
		String sep2="=";
		String sep3="-";
		
		
		if (getParamStr()!=null && !getParamStr().equals(""))
		{
			uniqueStr1+=getParamStr();
			if (getChunks().containsKey(getParamStr()) && isVerbose)
				uniqueStr1+=sep2+Util.list2String(getChunks().get(getParamStr()), sep3);
			uniqueStrs.add(uniqueStr1);
		}
		if (getGroupingStr() != null && !getGroupingStr().equals(""))
		{
			uniqueStr2+=getGroupingStr();
			if (getChunks().containsKey(getGroupingStr()) && isVerbose)
				uniqueStr2+=sep2+Util.list2String(getChunks().get(getGroupingStr()), sep3);
			uniqueStrs.add(uniqueStr2);
		}
		
		return StringUtils.join(uniqueStrs, sep1);
				
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	public DataFormat getFormat() {
		DataFormat format = null;
		if (getData() != null && getData().getFormat() != null && !"".equals(getData().getFormat()))
		{
			format = getData().getFormat();
		}
		else 
		{
			if (getData() != null && getData().getPort() != null 
					&& getData().getPort().getDataFormats() != null 
					&& !getData().getPort().getDataFormats().isEmpty())
			{
				format = getData().getPort().getFormat();
			}
			else if (getDataPort() != null && getDataPort().getDataFormats() != null && !getDataPort().getDataFormats().isEmpty())
			{
				format = getDataPort().getFormat();
			}
			else if (getInDataPort() != null && getInDataPort().getDataFormats() != null && !getInDataPort().getDataFormats().isEmpty())
			{
				format = getInDataPort().getFormat();
			}
		}
		return format;
			
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DataPackage.DATA_LINK__CHUNKS:
				return ((InternalEList<?>)getChunks()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DataPackage.DATA_LINK__DATA_PORT:
				if (resolve) return getDataPort();
				return basicGetDataPort();
			case DataPackage.DATA_LINK__IN_DATA_PORT:
				if (resolve) return getInDataPort();
				return basicGetInDataPort();
			case DataPackage.DATA_LINK__CHUNKS:
				if (coreType) return getChunks();
				else return getChunks().map();
			case DataPackage.DATA_LINK__ID:
				return getId();
			case DataPackage.DATA_LINK__GROUPING_STR:
				return getGroupingStr();
			case DataPackage.DATA_LINK__PARENT_GROUPING_STR:
				return getParentGroupingStr();
			case DataPackage.DATA_LINK__PARAM_STR:
				return getParamStr();
			case DataPackage.DATA_LINK__PARAM_NAME_STR:
				return getParamNameStr();
			case DataPackage.DATA_LINK__IDENTICAL_GROUPING:
				return isIdenticalGrouping();
			case DataPackage.DATA_LINK__CONDITION:
				if (resolve) return getCondition();
				return basicGetCondition();
			case DataPackage.DATA_LINK__INTERMEDIATE_TASKS:
				return getIntermediateTasks();
			case DataPackage.DATA_LINK__DATA:
				if (resolve) return getData();
				return basicGetData();
			case DataPackage.DATA_LINK__TERMINAL:
				return isTerminal();
			case DataPackage.DATA_LINK__PROCESSED:
				return isProcessed();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case DataPackage.DATA_LINK__DATA_PORT:
				setDataPort((DataPort)newValue);
				return;
			case DataPackage.DATA_LINK__IN_DATA_PORT:
				setInDataPort((DataPort)newValue);
				return;
			case DataPackage.DATA_LINK__CHUNKS:
				((EStructuralFeature.Setting)getChunks()).set(newValue);
				return;
			case DataPackage.DATA_LINK__ID:
				setId((Integer)newValue);
				return;
			case DataPackage.DATA_LINK__GROUPING_STR:
				setGroupingStr((String)newValue);
				return;
			case DataPackage.DATA_LINK__PARENT_GROUPING_STR:
				setParentGroupingStr((String)newValue);
				return;
			case DataPackage.DATA_LINK__PARAM_STR:
				setParamStr((String)newValue);
				return;
			case DataPackage.DATA_LINK__PARAM_NAME_STR:
				setParamNameStr((String)newValue);
				return;
			case DataPackage.DATA_LINK__IDENTICAL_GROUPING:
				setIdenticalGrouping((Boolean)newValue);
				return;
			case DataPackage.DATA_LINK__CONDITION:
				setCondition((Condition)newValue);
				return;
			case DataPackage.DATA_LINK__INTERMEDIATE_TASKS:
				getIntermediateTasks().clear();
				getIntermediateTasks().addAll((Collection<? extends PreprocessingTask>)newValue);
				return;
			case DataPackage.DATA_LINK__DATA:
				setData((Data)newValue);
				return;
			case DataPackage.DATA_LINK__TERMINAL:
				setTerminal((Boolean)newValue);
				return;
			case DataPackage.DATA_LINK__PROCESSED:
				setProcessed((Boolean)newValue);
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
			case DataPackage.DATA_LINK__DATA_PORT:
				setDataPort((DataPort)null);
				return;
			case DataPackage.DATA_LINK__IN_DATA_PORT:
				setInDataPort((DataPort)null);
				return;
			case DataPackage.DATA_LINK__CHUNKS:
				getChunks().clear();
				return;
			case DataPackage.DATA_LINK__ID:
				setId(ID_EDEFAULT);
				return;
			case DataPackage.DATA_LINK__GROUPING_STR:
				setGroupingStr(GROUPING_STR_EDEFAULT);
				return;
			case DataPackage.DATA_LINK__PARENT_GROUPING_STR:
				setParentGroupingStr(PARENT_GROUPING_STR_EDEFAULT);
				return;
			case DataPackage.DATA_LINK__PARAM_STR:
				setParamStr(PARAM_STR_EDEFAULT);
				return;
			case DataPackage.DATA_LINK__PARAM_NAME_STR:
				setParamNameStr(PARAM_NAME_STR_EDEFAULT);
				return;
			case DataPackage.DATA_LINK__IDENTICAL_GROUPING:
				setIdenticalGrouping(IDENTICAL_GROUPING_EDEFAULT);
				return;
			case DataPackage.DATA_LINK__CONDITION:
				setCondition((Condition)null);
				return;
			case DataPackage.DATA_LINK__INTERMEDIATE_TASKS:
				getIntermediateTasks().clear();
				return;
			case DataPackage.DATA_LINK__DATA:
				setData((Data)null);
				return;
			case DataPackage.DATA_LINK__TERMINAL:
				setTerminal(TERMINAL_EDEFAULT);
				return;
			case DataPackage.DATA_LINK__PROCESSED:
				setProcessed(PROCESSED_EDEFAULT);
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
			case DataPackage.DATA_LINK__DATA_PORT:
				return dataPort != null;
			case DataPackage.DATA_LINK__IN_DATA_PORT:
				return inDataPort != null;
			case DataPackage.DATA_LINK__CHUNKS:
				return chunks != null && !chunks.isEmpty();
			case DataPackage.DATA_LINK__ID:
				return id != ID_EDEFAULT;
			case DataPackage.DATA_LINK__GROUPING_STR:
				return GROUPING_STR_EDEFAULT == null ? groupingStr != null : !GROUPING_STR_EDEFAULT.equals(groupingStr);
			case DataPackage.DATA_LINK__PARENT_GROUPING_STR:
				return PARENT_GROUPING_STR_EDEFAULT == null ? parentGroupingStr != null : !PARENT_GROUPING_STR_EDEFAULT.equals(parentGroupingStr);
			case DataPackage.DATA_LINK__PARAM_STR:
				return PARAM_STR_EDEFAULT == null ? paramStr != null : !PARAM_STR_EDEFAULT.equals(paramStr);
			case DataPackage.DATA_LINK__PARAM_NAME_STR:
				return PARAM_NAME_STR_EDEFAULT == null ? paramNameStr != null : !PARAM_NAME_STR_EDEFAULT.equals(paramNameStr);
			case DataPackage.DATA_LINK__IDENTICAL_GROUPING:
				return identicalGrouping != IDENTICAL_GROUPING_EDEFAULT;
			case DataPackage.DATA_LINK__CONDITION:
				return condition != null;
			case DataPackage.DATA_LINK__INTERMEDIATE_TASKS:
				return intermediateTasks != null && !intermediateTasks.isEmpty();
			case DataPackage.DATA_LINK__DATA:
				return data != null;
			case DataPackage.DATA_LINK__TERMINAL:
				return terminal != TERMINAL_EDEFAULT;
			case DataPackage.DATA_LINK__PROCESSED:
				return processed != PROCESSED_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (id: ");
		result.append(id);
		result.append(", groupingStr: ");
		result.append(groupingStr);
		result.append(", parentGroupingStr: ");
		result.append(parentGroupingStr);
		result.append(", paramStr: ");
		result.append(paramStr);
		result.append(", paramNameStr: ");
		result.append(paramNameStr);
		result.append(", identicalGrouping: ");
		result.append(identicalGrouping);
		result.append(", terminal: ");
		result.append(terminal);
		result.append(", processed: ");
		result.append(processed);
		result.append(')');
		return result.toString();
	}

} //DataLinkImpl