/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package easyflow.metadata.impl;

import easyflow.EasyflowPackage;
import easyflow.core.CorePackage;
import easyflow.core.impl.CorePackageImpl;
import easyflow.data.DataPackage;
import easyflow.data.impl.DataPackageImpl;
import easyflow.example.ExamplePackage;
import easyflow.example.impl.ExamplePackageImpl;
import easyflow.execution.ExecutionPackage;
import easyflow.execution.impl.ExecutionPackageImpl;
import easyflow.execution.makeflow.MakeflowPackage;
import easyflow.execution.makeflow.impl.MakeflowPackageImpl;
import easyflow.execution.pegasus.PegasusPackage;
import easyflow.execution.pegasus.impl.PegasusPackageImpl;
import easyflow.execution.shell.ShellPackage;
import easyflow.execution.shell.impl.ShellPackageImpl;
import easyflow.graph.GraphPackage;
import easyflow.graph.impl.GraphPackageImpl;
import easyflow.graph.jgraphx.JgraphxPackage;
import easyflow.graph.jgraphx.impl.JgraphxPackageImpl;
import easyflow.impl.EasyflowPackageImpl;
import easyflow.metadata.DefaultMetaData;
import easyflow.metadata.Grouping;
import easyflow.metadata.GroupingFeature;
import easyflow.metadata.GroupingInstance;
import easyflow.metadata.GroupingInstanceList;
import easyflow.metadata.IMetaData;
import easyflow.metadata.IProjectMetaData;
import easyflow.metadata.MetadataFactory;
import easyflow.metadata.MetadataPackage;
import easyflow.tool.ToolPackage;
import easyflow.tool.impl.ToolPackageImpl;
import easyflow.traversal.TraversalPackage;
import easyflow.traversal.impl.TraversalPackageImpl;
import easyflow.ui.UiPackage;
import easyflow.ui.impl.UiPackageImpl;
import easyflow.util.UtilPackage;
import easyflow.util.impl.UtilPackageImpl;
import easyflow.util.maps.MapsPackage;
import easyflow.util.maps.impl.MapsPackageImpl;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MetadataPackageImpl extends EPackageImpl implements MetadataPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iMetaDataEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass defaultMetaDataEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iProjectMetaDataEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass groupingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass groupingInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass groupingFeatureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass groupingInstanceListEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see easyflow.metadata.MetadataPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private MetadataPackageImpl() {
		super(eNS_URI, MetadataFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link MetadataPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static MetadataPackage init() {
		if (isInited) return (MetadataPackage)EPackage.Registry.INSTANCE.getEPackage(MetadataPackage.eNS_URI);

		// Obtain or create and register package
		MetadataPackageImpl theMetadataPackage = (MetadataPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof MetadataPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new MetadataPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		EasyflowPackageImpl theEasyflowPackage = (EasyflowPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(EasyflowPackage.eNS_URI) instanceof EasyflowPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(EasyflowPackage.eNS_URI) : EasyflowPackage.eINSTANCE);
		CorePackageImpl theCorePackage = (CorePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI) instanceof CorePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI) : CorePackage.eINSTANCE);
		UiPackageImpl theUiPackage = (UiPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(UiPackage.eNS_URI) instanceof UiPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(UiPackage.eNS_URI) : UiPackage.eINSTANCE);
		GraphPackageImpl theGraphPackage = (GraphPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(GraphPackage.eNS_URI) instanceof GraphPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(GraphPackage.eNS_URI) : GraphPackage.eINSTANCE);
		JgraphxPackageImpl theJgraphxPackage = (JgraphxPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(JgraphxPackage.eNS_URI) instanceof JgraphxPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(JgraphxPackage.eNS_URI) : JgraphxPackage.eINSTANCE);
		ExamplePackageImpl theExamplePackage = (ExamplePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ExamplePackage.eNS_URI) instanceof ExamplePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ExamplePackage.eNS_URI) : ExamplePackage.eINSTANCE);
		ExecutionPackageImpl theExecutionPackage = (ExecutionPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ExecutionPackage.eNS_URI) instanceof ExecutionPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ExecutionPackage.eNS_URI) : ExecutionPackage.eINSTANCE);
		PegasusPackageImpl thePegasusPackage = (PegasusPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(PegasusPackage.eNS_URI) instanceof PegasusPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(PegasusPackage.eNS_URI) : PegasusPackage.eINSTANCE);
		ShellPackageImpl theShellPackage = (ShellPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ShellPackage.eNS_URI) instanceof ShellPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ShellPackage.eNS_URI) : ShellPackage.eINSTANCE);
		MakeflowPackageImpl theMakeflowPackage = (MakeflowPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(MakeflowPackage.eNS_URI) instanceof MakeflowPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(MakeflowPackage.eNS_URI) : MakeflowPackage.eINSTANCE);
		ToolPackageImpl theToolPackage = (ToolPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ToolPackage.eNS_URI) instanceof ToolPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ToolPackage.eNS_URI) : ToolPackage.eINSTANCE);
		TraversalPackageImpl theTraversalPackage = (TraversalPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TraversalPackage.eNS_URI) instanceof TraversalPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TraversalPackage.eNS_URI) : TraversalPackage.eINSTANCE);
		UtilPackageImpl theUtilPackage = (UtilPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(UtilPackage.eNS_URI) instanceof UtilPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(UtilPackage.eNS_URI) : UtilPackage.eINSTANCE);
		MapsPackageImpl theMapsPackage = (MapsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(MapsPackage.eNS_URI) instanceof MapsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(MapsPackage.eNS_URI) : MapsPackage.eINSTANCE);
		DataPackageImpl theDataPackage = (DataPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(DataPackage.eNS_URI) instanceof DataPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(DataPackage.eNS_URI) : DataPackage.eINSTANCE);

		// Create package meta-data objects
		theMetadataPackage.createPackageContents();
		theEasyflowPackage.createPackageContents();
		theCorePackage.createPackageContents();
		theUiPackage.createPackageContents();
		theGraphPackage.createPackageContents();
		theJgraphxPackage.createPackageContents();
		theExamplePackage.createPackageContents();
		theExecutionPackage.createPackageContents();
		thePegasusPackage.createPackageContents();
		theShellPackage.createPackageContents();
		theMakeflowPackage.createPackageContents();
		theToolPackage.createPackageContents();
		theTraversalPackage.createPackageContents();
		theUtilPackage.createPackageContents();
		theMapsPackage.createPackageContents();
		theDataPackage.createPackageContents();

		// Initialize created meta-data
		theMetadataPackage.initializePackageContents();
		theEasyflowPackage.initializePackageContents();
		theCorePackage.initializePackageContents();
		theUiPackage.initializePackageContents();
		theGraphPackage.initializePackageContents();
		theJgraphxPackage.initializePackageContents();
		theExamplePackage.initializePackageContents();
		theExecutionPackage.initializePackageContents();
		thePegasusPackage.initializePackageContents();
		theShellPackage.initializePackageContents();
		theMakeflowPackage.initializePackageContents();
		theToolPackage.initializePackageContents();
		theTraversalPackage.initializePackageContents();
		theUtilPackage.initializePackageContents();
		theMapsPackage.initializePackageContents();
		theDataPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theMetadataPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(MetadataPackage.eNS_URI, theMetadataPackage);
		return theMetadataPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIMetaData() {
		return iMetaDataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getIMetaData__InitMetaData() {
		return iMetaDataEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getIMetaData__ReadMetaData() {
		return iMetaDataEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getIMetaData__GetInstances__GroupingInstance_String() {
		return iMetaDataEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getIMetaData__GetInstances__String_String_String() {
		return iMetaDataEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getIMetaData__GetInstancesForRecords__String_EList() {
		return iMetaDataEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getIMetaData__GetValueForGroupingInstance__GroupingInstance_String() {
		return iMetaDataEClass.getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getIMetaData__GetRecordsBy__String_String() {
		return iMetaDataEClass.getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getIMetaData__GetRecord__GroupingInstance() {
		return iMetaDataEClass.getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getIMetaData__GetRecord__TraversalChunk() {
		return iMetaDataEClass.getEOperations().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getIMetaData__GetRow__String() {
		return iMetaDataEClass.getEOperations().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getIMetaData__GetColumn__String() {
		return iMetaDataEClass.getEOperations().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getIMetaData__ContainsColumn__String() {
		return iMetaDataEClass.getEOperations().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getIMetaData__ContainsRow__String() {
		return iMetaDataEClass.getEOperations().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getIMetaData__InitLogMessage() {
		return iMetaDataEClass.getEOperations().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDefaultMetaData() {
		return defaultMetaDataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDefaultMetaData_Reader() {
		return (EAttribute)defaultMetaDataEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDefaultMetaData_Logger() {
		return (EAttribute)defaultMetaDataEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDefaultMetaData_Groupings() {
		return (EReference)defaultMetaDataEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDefaultMetaData_GroupingInstances() {
		return (EReference)defaultMetaDataEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDefaultMetaData_Aliases() {
		return (EReference)defaultMetaDataEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDefaultMetaData_GroupingProps() {
		return (EReference)defaultMetaDataEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDefaultMetaData_LogMessage() {
		return (EReference)defaultMetaDataEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIProjectMetaData() {
		return iProjectMetaDataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getIProjectMetaData__ReadMetaData() {
		return iProjectMetaDataEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGrouping() {
		return groupingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGrouping_Name() {
		return (EAttribute)groupingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGrouping_Description() {
		return (EAttribute)groupingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGroupingInstance() {
		return groupingInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGroupingInstance_Name() {
		return (EAttribute)groupingInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGroupingInstance_Features() {
		return (EReference)groupingInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGroupingInstance_Grouping() {
		return (EReference)groupingInstanceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGroupingInstance_GroupingStr() {
		return (EAttribute)groupingInstanceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGroupingInstance_Records() {
		return (EAttribute)groupingInstanceEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGroupingInstance_TraversalChunk() {
		return (EReference)groupingInstanceEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getGroupingInstance__GetOverlappingRecords__EList() {
		return groupingInstanceEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getGroupingInstance__AsTraversalChunk() {
		return groupingInstanceEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGroupingFeature() {
		return groupingFeatureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGroupingFeature_Name() {
		return (EAttribute)groupingFeatureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGroupingFeature_Value() {
		return (EAttribute)groupingFeatureEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGroupingInstanceList() {
		return groupingInstanceListEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGroupingInstanceList_Instances() {
		return (EReference)groupingInstanceListEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetadataFactory getMetadataFactory() {
		return (MetadataFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		iMetaDataEClass = createEClass(IMETA_DATA);
		createEOperation(iMetaDataEClass, IMETA_DATA___INIT_META_DATA);
		createEOperation(iMetaDataEClass, IMETA_DATA___READ_META_DATA);
		createEOperation(iMetaDataEClass, IMETA_DATA___GET_INSTANCES__GROUPINGINSTANCE_STRING);
		createEOperation(iMetaDataEClass, IMETA_DATA___GET_INSTANCES__STRING_STRING_STRING);
		createEOperation(iMetaDataEClass, IMETA_DATA___GET_INSTANCES_FOR_RECORDS__STRING_ELIST);
		createEOperation(iMetaDataEClass, IMETA_DATA___GET_VALUE_FOR_GROUPING_INSTANCE__GROUPINGINSTANCE_STRING);
		createEOperation(iMetaDataEClass, IMETA_DATA___GET_RECORDS_BY__STRING_STRING);
		createEOperation(iMetaDataEClass, IMETA_DATA___GET_RECORD__GROUPINGINSTANCE);
		createEOperation(iMetaDataEClass, IMETA_DATA___GET_RECORD__TRAVERSALCHUNK);
		createEOperation(iMetaDataEClass, IMETA_DATA___GET_ROW__STRING);
		createEOperation(iMetaDataEClass, IMETA_DATA___GET_COLUMN__STRING);
		createEOperation(iMetaDataEClass, IMETA_DATA___CONTAINS_COLUMN__STRING);
		createEOperation(iMetaDataEClass, IMETA_DATA___CONTAINS_ROW__STRING);
		createEOperation(iMetaDataEClass, IMETA_DATA___INIT_LOG_MESSAGE);

		defaultMetaDataEClass = createEClass(DEFAULT_META_DATA);
		createEAttribute(defaultMetaDataEClass, DEFAULT_META_DATA__READER);
		createEAttribute(defaultMetaDataEClass, DEFAULT_META_DATA__LOGGER);
		createEReference(defaultMetaDataEClass, DEFAULT_META_DATA__GROUPINGS);
		createEReference(defaultMetaDataEClass, DEFAULT_META_DATA__GROUPING_INSTANCES);
		createEReference(defaultMetaDataEClass, DEFAULT_META_DATA__ALIASES);
		createEReference(defaultMetaDataEClass, DEFAULT_META_DATA__GROUPING_PROPS);
		createEReference(defaultMetaDataEClass, DEFAULT_META_DATA__LOG_MESSAGE);

		iProjectMetaDataEClass = createEClass(IPROJECT_META_DATA);
		createEOperation(iProjectMetaDataEClass, IPROJECT_META_DATA___READ_META_DATA);

		groupingEClass = createEClass(GROUPING);
		createEAttribute(groupingEClass, GROUPING__NAME);
		createEAttribute(groupingEClass, GROUPING__DESCRIPTION);

		groupingInstanceEClass = createEClass(GROUPING_INSTANCE);
		createEAttribute(groupingInstanceEClass, GROUPING_INSTANCE__NAME);
		createEReference(groupingInstanceEClass, GROUPING_INSTANCE__FEATURES);
		createEReference(groupingInstanceEClass, GROUPING_INSTANCE__GROUPING);
		createEAttribute(groupingInstanceEClass, GROUPING_INSTANCE__GROUPING_STR);
		createEAttribute(groupingInstanceEClass, GROUPING_INSTANCE__RECORDS);
		createEReference(groupingInstanceEClass, GROUPING_INSTANCE__TRAVERSAL_CHUNK);
		createEOperation(groupingInstanceEClass, GROUPING_INSTANCE___GET_OVERLAPPING_RECORDS__ELIST);
		createEOperation(groupingInstanceEClass, GROUPING_INSTANCE___AS_TRAVERSAL_CHUNK);

		groupingFeatureEClass = createEClass(GROUPING_FEATURE);
		createEAttribute(groupingFeatureEClass, GROUPING_FEATURE__NAME);
		createEAttribute(groupingFeatureEClass, GROUPING_FEATURE__VALUE);

		groupingInstanceListEClass = createEClass(GROUPING_INSTANCE_LIST);
		createEReference(groupingInstanceListEClass, GROUPING_INSTANCE_LIST__INSTANCES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		MapsPackage theMapsPackage = (MapsPackage)EPackage.Registry.INSTANCE.getEPackage(MapsPackage.eNS_URI);
		TraversalPackage theTraversalPackage = (TraversalPackage)EPackage.Registry.INSTANCE.getEPackage(TraversalPackage.eNS_URI);
		EasyflowPackage theEasyflowPackage = (EasyflowPackage)EPackage.Registry.INSTANCE.getEPackage(EasyflowPackage.eNS_URI);
		UtilPackage theUtilPackage = (UtilPackage)EPackage.Registry.INSTANCE.getEPackage(UtilPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		defaultMetaDataEClass.getESuperTypes().add(this.getIMetaData());

		// Initialize classes, features, and operations; add parameters
		initEClass(iMetaDataEClass, IMetaData.class, "IMetaData", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getIMetaData__InitMetaData(), null, "initMetaData", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getIMetaData__ReadMetaData(), null, "readMetaData", 0, 1, IS_UNIQUE, IS_ORDERED);

		EOperation op = initEOperation(getIMetaData__GetInstances__GroupingInstance_String(), this.getGroupingInstance(), "getInstances", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getGroupingInstance(), "groupingInstance", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "resolvedAs", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getIMetaData__GetInstances__String_String_String(), this.getGroupingInstance(), "getInstances", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "groupingStr1", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "groupingStr2", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "instanceStr", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getIMetaData__GetInstancesForRecords__String_EList(), this.getGroupingInstance(), "getInstancesForRecords", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "groupingStr", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "recordInstanceStr", 0, -1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getIMetaData__GetValueForGroupingInstance__GroupingInstance_String(), null, "getValueForGroupingInstance", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getGroupingInstance(), "groupingInstance", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "field", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getIMetaData__GetRecordsBy__String_String(), ecorePackage.getEString(), "getRecordsBy", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "groupingStr", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "instanceStr", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getIMetaData__GetRecord__GroupingInstance(), theMapsPackage.getStringToObjectMap(), "getRecord", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getGroupingInstance(), "recordInstance", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getIMetaData__GetRecord__TraversalChunk(), theMapsPackage.getStringToObjectMap(), "getRecord", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theTraversalPackage.getTraversalChunk(), "record", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getIMetaData__GetRow__String(), theMapsPackage.getStringToStringMap(), "getRow", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "key", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getIMetaData__GetColumn__String(), theMapsPackage.getStringToStringMap(), "getColumn", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "key", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getIMetaData__ContainsColumn__String(), ecorePackage.getEBoolean(), "containsColumn", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "column", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getIMetaData__ContainsRow__String(), ecorePackage.getEBoolean(), "containsRow", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "row", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getIMetaData__InitLogMessage(), null, "initLogMessage", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(defaultMetaDataEClass, DefaultMetaData.class, "DefaultMetaData", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDefaultMetaData_Reader(), theEasyflowPackage.getBufferedReader(), "reader", null, 0, 1, DefaultMetaData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDefaultMetaData_Logger(), theEasyflowPackage.getLogger(), "logger", null, 0, 1, DefaultMetaData.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDefaultMetaData_Groupings(), theMapsPackage.getStringToGroupingMap(), null, "groupings", null, 0, -1, DefaultMetaData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDefaultMetaData_GroupingInstances(), theMapsPackage.getStringToGroupingInstanceListMap(), null, "groupingInstances", null, 0, -1, DefaultMetaData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDefaultMetaData_Aliases(), theMapsPackage.getStringToStringMap(), null, "aliases", null, 0, -1, DefaultMetaData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDefaultMetaData_GroupingProps(), theMapsPackage.getStringToStringMap(), null, "groupingProps", null, 0, -1, DefaultMetaData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDefaultMetaData_LogMessage(), theUtilPackage.getLogMessage(), null, "logMessage", null, 0, 1, DefaultMetaData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iProjectMetaDataEClass, IProjectMetaData.class, "IProjectMetaData", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getIProjectMetaData__ReadMetaData(), null, "readMetaData", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(groupingEClass, Grouping.class, "Grouping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGrouping_Name(), ecorePackage.getEString(), "name", null, 0, 1, Grouping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGrouping_Description(), ecorePackage.getEString(), "description", null, 0, 1, Grouping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(groupingInstanceEClass, GroupingInstance.class, "GroupingInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGroupingInstance_Name(), ecorePackage.getEString(), "name", null, 0, 1, GroupingInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGroupingInstance_Features(), theMapsPackage.getStringToGroupingFeatureMap(), null, "features", null, 0, -1, GroupingInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGroupingInstance_Grouping(), this.getGrouping(), null, "grouping", null, 0, 1, GroupingInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGroupingInstance_GroupingStr(), ecorePackage.getEString(), "groupingStr", null, 0, 1, GroupingInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGroupingInstance_Records(), ecorePackage.getEString(), "records", null, 0, -1, GroupingInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGroupingInstance_TraversalChunk(), theTraversalPackage.getTraversalChunk(), null, "traversalChunk", null, 0, 1, GroupingInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getGroupingInstance__GetOverlappingRecords__EList(), ecorePackage.getEString(), "getOverlappingRecords", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "records", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getGroupingInstance__AsTraversalChunk(), theTraversalPackage.getTraversalChunk(), "asTraversalChunk", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(groupingFeatureEClass, GroupingFeature.class, "GroupingFeature", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGroupingFeature_Name(), ecorePackage.getEString(), "name", null, 0, 1, GroupingFeature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGroupingFeature_Value(), ecorePackage.getEString(), "value", null, 0, 1, GroupingFeature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(groupingInstanceListEClass, GroupingInstanceList.class, "GroupingInstanceList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGroupingInstanceList_Instances(), this.getGroupingInstance(), null, "instances", null, 0, -1, GroupingInstanceList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
	}

} //MetadataPackageImpl
