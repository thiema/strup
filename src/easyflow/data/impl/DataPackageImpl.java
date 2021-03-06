/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package easyflow.data.impl;

import easyflow.EasyflowPackage;
import easyflow.core.CorePackage;
import easyflow.core.impl.CorePackageImpl;
import easyflow.data.Data;
import easyflow.data.DataFactory;
import easyflow.data.DataFormat;
import easyflow.data.DataLink;
import easyflow.data.DataMatch;
import easyflow.data.DataPackage;
import easyflow.data.DataPort;
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
import easyflow.metadata.MetadataPackage;
import easyflow.metadata.impl.MetadataPackageImpl;
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
public class DataPackageImpl extends EPackageImpl implements DataPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataPortEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataLinkEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataFormatEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataMatchEClass = null;

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
	 * @see easyflow.data.DataPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private DataPackageImpl() {
		super(eNS_URI, DataFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link DataPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static DataPackage init() {
		if (isInited) return (DataPackage)EPackage.Registry.INSTANCE.getEPackage(DataPackage.eNS_URI);

		// Obtain or create and register package
		DataPackageImpl theDataPackage = (DataPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof DataPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new DataPackageImpl());

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
		MetadataPackageImpl theMetadataPackage = (MetadataPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(MetadataPackage.eNS_URI) instanceof MetadataPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(MetadataPackage.eNS_URI) : MetadataPackage.eINSTANCE);
		TraversalPackageImpl theTraversalPackage = (TraversalPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TraversalPackage.eNS_URI) instanceof TraversalPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TraversalPackage.eNS_URI) : TraversalPackage.eINSTANCE);
		UtilPackageImpl theUtilPackage = (UtilPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(UtilPackage.eNS_URI) instanceof UtilPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(UtilPackage.eNS_URI) : UtilPackage.eINSTANCE);
		MapsPackageImpl theMapsPackage = (MapsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(MapsPackage.eNS_URI) instanceof MapsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(MapsPackage.eNS_URI) : MapsPackage.eINSTANCE);

		// Create package meta-data objects
		theDataPackage.createPackageContents();
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
		theMetadataPackage.createPackageContents();
		theTraversalPackage.createPackageContents();
		theUtilPackage.createPackageContents();
		theMapsPackage.createPackageContents();

		// Initialize created meta-data
		theDataPackage.initializePackageContents();
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
		theMetadataPackage.initializePackageContents();
		theTraversalPackage.initializePackageContents();
		theUtilPackage.initializePackageContents();
		theMapsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theDataPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(DataPackage.eNS_URI, theDataPackage);
		return theDataPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataPort() {
		return dataPortEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataPort_GroupingCriteria() {
		return (EReference)dataPortEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataPort_Cardinality() {
		return (EAttribute)dataPortEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataPort_DataFormats() {
		return (EReference)dataPortEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataPort_Optional() {
		return (EAttribute)dataPortEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataPort_BitPos() {
		return (EAttribute)dataPortEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataPort_Name() {
		return (EAttribute)dataPortEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataPort_Tools() {
		return (EReference)dataPortEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataPort_Static() {
		return (EAttribute)dataPortEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataPort_ParameterName() {
		return (EAttribute)dataPortEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDataPort__IsCompatible__DataPort() {
		return dataPortEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDataPort__RemoveDataPortFrom__EList() {
		return dataPortEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDataPort__GetFormat() {
		return dataPortEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDataPort__Matches__DataFormat() {
		return dataPortEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDataPort__IsCompatibleStr__EList_boolean() {
		return dataPortEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDataPort__IsCompatibleStr__EList() {
		return dataPortEClass.getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDataPort__IsCompatible__EList_boolean() {
		return dataPortEClass.getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDataPort__IsCompatible__EList() {
		return dataPortEClass.getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDataPort__IsCompatible__String() {
		return dataPortEClass.getEOperations().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDataPort__IsCompatible__DataFormat() {
		return dataPortEClass.getEOperations().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDataPort__SetFormat__String() {
		return dataPortEClass.getEOperations().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDataPort__SetFormats__EList() {
		return dataPortEClass.getEOperations().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataLink() {
		return dataLinkEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataLink_DataPort() {
		return (EReference)dataLinkEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataLink_InDataPort() {
		return (EReference)dataLinkEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataLink_Chunks() {
		return (EReference)dataLinkEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataLink_Id() {
		return (EAttribute)dataLinkEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataLink_GroupingStr() {
		return (EAttribute)dataLinkEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataLink_ParentGroupingStr() {
		return (EAttribute)dataLinkEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataLink_IdenticalGrouping() {
		return (EAttribute)dataLinkEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataLink_Condition() {
		return (EReference)dataLinkEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataLink_IntermediateTasks() {
		return (EReference)dataLinkEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataLink_Data() {
		return (EReference)dataLinkEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataLink_InData() {
		return (EReference)dataLinkEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataLink_Terminal() {
		return (EAttribute)dataLinkEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataLink_Processed() {
		return (EAttribute)dataLinkEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataLink_DataResourceName() {
		return (EAttribute)dataLinkEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataLink_Pipe() {
		return (EAttribute)dataLinkEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataLink_Flags() {
		return (EAttribute)dataLinkEClass.getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDataLink__IsUnconditional() {
		return dataLinkEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDataLink__GetUniqueString__String_String_String() {
		return dataLinkEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDataLink__GetUniqueString() {
		return dataLinkEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDataLink__GetUniqueString__boolean() {
		return dataLinkEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDataLink__GetFormat() {
		return dataLinkEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDataLink__IsPipeable() {
		return dataLinkEClass.getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDataLink__GetMatchingDataFor__EList_EList_boolean() {
		return dataLinkEClass.getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataLink_ParamStr() {
		return (EAttribute)dataLinkEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataLink_ParamNameStr() {
		return (EAttribute)dataLinkEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataLink_ParamChunks() {
		return (EReference)dataLinkEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getData() {
		return dataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getData_Label() {
		return (EAttribute)dataEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getData_Port() {
		return (EReference)dataEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getData_Output() {
		return (EAttribute)dataEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getData_Name() {
		return (EAttribute)dataEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getData_Description() {
		return (EAttribute)dataEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getData_Parameter() {
		return (EReference)dataEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getData_ResolvedParam() {
		return (EReference)dataEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getData_Handle() {
		return (EAttribute)dataEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getData__GetFormat() {
		return dataEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getData__GetFormatStr() {
		return dataEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getData__IsAllowed() {
		return dataEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getData__GetSupportedHandles() {
		return dataEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getData__Match__Data() {
		return dataEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getData__MatchFormat__DataFormat() {
		return dataEClass.getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getData__ResolveHandle__Data() {
		return dataEClass.getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getData__ResolveHandle__String() {
		return dataEClass.getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getData__ResolveSupportedHandles() {
		return dataEClass.getEOperations().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getData__IsPipable() {
		return dataEClass.getEOperations().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataFormat() {
		return dataFormatEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataFormat_Name() {
		return (EAttribute)dataFormatEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataFormat_Description() {
		return (EAttribute)dataFormatEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDataFormat__Match__DataFormat() {
		return dataFormatEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDataFormat__RenderAsFileExtension() {
		return dataFormatEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataMatch() {
		return dataMatchEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataMatch_ParentData() {
		return (EReference)dataMatchEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataMatch_ChildData() {
		return (EReference)dataMatchEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataMatch_Score() {
		return (EAttribute)dataMatchEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDataMatch__ComputeScore__EMap() {
		return dataMatchEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDataMatch__IsPipable() {
		return dataMatchEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataFactory getDataFactory() {
		return (DataFactory)getEFactoryInstance();
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
		dataPortEClass = createEClass(DATA_PORT);
		createEReference(dataPortEClass, DATA_PORT__GROUPING_CRITERIA);
		createEAttribute(dataPortEClass, DATA_PORT__CARDINALITY);
		createEReference(dataPortEClass, DATA_PORT__DATA_FORMATS);
		createEAttribute(dataPortEClass, DATA_PORT__OPTIONAL);
		createEAttribute(dataPortEClass, DATA_PORT__BIT_POS);
		createEAttribute(dataPortEClass, DATA_PORT__NAME);
		createEReference(dataPortEClass, DATA_PORT__TOOLS);
		createEAttribute(dataPortEClass, DATA_PORT__STATIC);
		createEAttribute(dataPortEClass, DATA_PORT__PARAMETER_NAME);
		createEOperation(dataPortEClass, DATA_PORT___IS_COMPATIBLE__DATAPORT);
		createEOperation(dataPortEClass, DATA_PORT___REMOVE_DATA_PORT_FROM__ELIST);
		createEOperation(dataPortEClass, DATA_PORT___GET_FORMAT);
		createEOperation(dataPortEClass, DATA_PORT___MATCHES__DATAFORMAT);
		createEOperation(dataPortEClass, DATA_PORT___IS_COMPATIBLE_STR__ELIST_BOOLEAN);
		createEOperation(dataPortEClass, DATA_PORT___IS_COMPATIBLE_STR__ELIST);
		createEOperation(dataPortEClass, DATA_PORT___IS_COMPATIBLE__ELIST_BOOLEAN);
		createEOperation(dataPortEClass, DATA_PORT___IS_COMPATIBLE__ELIST);
		createEOperation(dataPortEClass, DATA_PORT___IS_COMPATIBLE__STRING);
		createEOperation(dataPortEClass, DATA_PORT___IS_COMPATIBLE__DATAFORMAT);
		createEOperation(dataPortEClass, DATA_PORT___SET_FORMAT__STRING);
		createEOperation(dataPortEClass, DATA_PORT___SET_FORMATS__ELIST);

		dataLinkEClass = createEClass(DATA_LINK);
		createEReference(dataLinkEClass, DATA_LINK__DATA_PORT);
		createEReference(dataLinkEClass, DATA_LINK__IN_DATA_PORT);
		createEReference(dataLinkEClass, DATA_LINK__CHUNKS);
		createEAttribute(dataLinkEClass, DATA_LINK__ID);
		createEAttribute(dataLinkEClass, DATA_LINK__GROUPING_STR);
		createEAttribute(dataLinkEClass, DATA_LINK__PARENT_GROUPING_STR);
		createEAttribute(dataLinkEClass, DATA_LINK__PARAM_STR);
		createEAttribute(dataLinkEClass, DATA_LINK__PARAM_NAME_STR);
		createEReference(dataLinkEClass, DATA_LINK__PARAM_CHUNKS);
		createEAttribute(dataLinkEClass, DATA_LINK__IDENTICAL_GROUPING);
		createEReference(dataLinkEClass, DATA_LINK__CONDITION);
		createEReference(dataLinkEClass, DATA_LINK__INTERMEDIATE_TASKS);
		createEReference(dataLinkEClass, DATA_LINK__DATA);
		createEReference(dataLinkEClass, DATA_LINK__IN_DATA);
		createEAttribute(dataLinkEClass, DATA_LINK__TERMINAL);
		createEAttribute(dataLinkEClass, DATA_LINK__PROCESSED);
		createEAttribute(dataLinkEClass, DATA_LINK__DATA_RESOURCE_NAME);
		createEAttribute(dataLinkEClass, DATA_LINK__PIPE);
		createEAttribute(dataLinkEClass, DATA_LINK__FLAGS);
		createEOperation(dataLinkEClass, DATA_LINK___IS_UNCONDITIONAL);
		createEOperation(dataLinkEClass, DATA_LINK___GET_UNIQUE_STRING__STRING_STRING_STRING);
		createEOperation(dataLinkEClass, DATA_LINK___GET_UNIQUE_STRING);
		createEOperation(dataLinkEClass, DATA_LINK___GET_UNIQUE_STRING__BOOLEAN);
		createEOperation(dataLinkEClass, DATA_LINK___GET_FORMAT);
		createEOperation(dataLinkEClass, DATA_LINK___IS_PIPEABLE);
		createEOperation(dataLinkEClass, DATA_LINK___GET_MATCHING_DATA_FOR__ELIST_ELIST_BOOLEAN);

		dataEClass = createEClass(DATA);
		createEAttribute(dataEClass, DATA__LABEL);
		createEReference(dataEClass, DATA__PORT);
		createEAttribute(dataEClass, DATA__OUTPUT);
		createEAttribute(dataEClass, DATA__NAME);
		createEAttribute(dataEClass, DATA__DESCRIPTION);
		createEReference(dataEClass, DATA__PARAMETER);
		createEReference(dataEClass, DATA__RESOLVED_PARAM);
		createEAttribute(dataEClass, DATA__HANDLE);
		createEOperation(dataEClass, DATA___GET_FORMAT);
		createEOperation(dataEClass, DATA___GET_FORMAT_STR);
		createEOperation(dataEClass, DATA___IS_ALLOWED);
		createEOperation(dataEClass, DATA___GET_SUPPORTED_HANDLES);
		createEOperation(dataEClass, DATA___MATCH__DATA);
		createEOperation(dataEClass, DATA___MATCH_FORMAT__DATAFORMAT);
		createEOperation(dataEClass, DATA___RESOLVE_HANDLE__DATA);
		createEOperation(dataEClass, DATA___RESOLVE_HANDLE__STRING);
		createEOperation(dataEClass, DATA___RESOLVE_SUPPORTED_HANDLES);
		createEOperation(dataEClass, DATA___IS_PIPABLE);

		dataFormatEClass = createEClass(DATA_FORMAT);
		createEAttribute(dataFormatEClass, DATA_FORMAT__NAME);
		createEAttribute(dataFormatEClass, DATA_FORMAT__DESCRIPTION);
		createEOperation(dataFormatEClass, DATA_FORMAT___MATCH__DATAFORMAT);
		createEOperation(dataFormatEClass, DATA_FORMAT___RENDER_AS_FILE_EXTENSION);

		dataMatchEClass = createEClass(DATA_MATCH);
		createEReference(dataMatchEClass, DATA_MATCH__PARENT_DATA);
		createEReference(dataMatchEClass, DATA_MATCH__CHILD_DATA);
		createEAttribute(dataMatchEClass, DATA_MATCH__SCORE);
		createEOperation(dataMatchEClass, DATA_MATCH___COMPUTE_SCORE__EMAP);
		createEOperation(dataMatchEClass, DATA_MATCH___IS_PIPABLE);
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
		TraversalPackage theTraversalPackage = (TraversalPackage)EPackage.Registry.INSTANCE.getEPackage(TraversalPackage.eNS_URI);
		MapsPackage theMapsPackage = (MapsPackage)EPackage.Registry.INSTANCE.getEPackage(MapsPackage.eNS_URI);
		CorePackage theCorePackage = (CorePackage)EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI);
		EasyflowPackage theEasyflowPackage = (EasyflowPackage)EPackage.Registry.INSTANCE.getEPackage(EasyflowPackage.eNS_URI);
		ToolPackage theToolPackage = (ToolPackage)EPackage.Registry.INSTANCE.getEPackage(ToolPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(dataPortEClass, DataPort.class, "DataPort", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDataPort_GroupingCriteria(), theTraversalPackage.getTraversalCriterion(), null, "groupingCriteria", null, 0, -1, DataPort.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDataPort_Cardinality(), ecorePackage.getEShort(), "cardinality", null, 0, 1, DataPort.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDataPort_DataFormats(), theMapsPackage.getStringToDataFormatMap(), null, "dataFormats", null, 0, -1, DataPort.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDataPort_Optional(), ecorePackage.getEBoolean(), "optional", "false", 0, 1, DataPort.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDataPort_BitPos(), ecorePackage.getEShort(), "bitPos", "-1", 0, 1, DataPort.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDataPort_Name(), ecorePackage.getEString(), "name", null, 0, 1, DataPort.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDataPort_Tools(), theMapsPackage.getStringToToolMap(), null, "tools", null, 0, -1, DataPort.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDataPort_Static(), ecorePackage.getEBoolean(), "static", "false", 0, 1, DataPort.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDataPort_ParameterName(), ecorePackage.getEString(), "parameterName", null, 0, 1, DataPort.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = initEOperation(getDataPort__IsCompatible__DataPort(), ecorePackage.getEBoolean(), "isCompatible", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getDataPort(), "dataPort", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getDataPort__RemoveDataPortFrom__EList(), ecorePackage.getEBoolean(), "removeDataPortFrom", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getDataPort(), "dataPort", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getDataPort__GetFormat(), this.getDataFormat(), "getFormat", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getDataPort__Matches__DataFormat(), ecorePackage.getEBoolean(), "matches", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getDataFormat(), "dataFormat", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getDataPort__IsCompatibleStr__EList_boolean(), ecorePackage.getEBoolean(), "isCompatibleStr", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "formats", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEBoolean(), "requireAll", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getDataPort__IsCompatibleStr__EList(), ecorePackage.getEBoolean(), "isCompatibleStr", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "formats", 0, -1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getDataPort__IsCompatible__EList_boolean(), ecorePackage.getEBoolean(), "isCompatible", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getDataFormat(), "formats", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEBoolean(), "requireAll", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getDataPort__IsCompatible__EList(), ecorePackage.getEBoolean(), "isCompatible", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getDataFormat(), "formats", 0, -1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getDataPort__IsCompatible__String(), ecorePackage.getEBoolean(), "isCompatible", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "format", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getDataPort__IsCompatible__DataFormat(), ecorePackage.getEBoolean(), "isCompatible", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getDataFormat(), "format", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getDataPort__SetFormat__String(), null, "setFormat", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "format", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getDataPort__SetFormats__EList(), null, "setFormats", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "formats", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEClass(dataLinkEClass, DataLink.class, "DataLink", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDataLink_DataPort(), this.getDataPort(), null, "dataPort", null, 0, 1, DataLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDataLink_InDataPort(), this.getDataPort(), null, "inDataPort", null, 0, 1, DataLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDataLink_Chunks(), theMapsPackage.getStringToChunksMap(), null, "chunks", null, 0, -1, DataLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDataLink_Id(), ecorePackage.getEInt(), "id", null, 0, 1, DataLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDataLink_GroupingStr(), ecorePackage.getEString(), "groupingStr", null, 0, 1, DataLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDataLink_ParentGroupingStr(), ecorePackage.getEString(), "parentGroupingStr", null, 0, 1, DataLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDataLink_ParamStr(), ecorePackage.getEString(), "paramStr", "", 0, 1, DataLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDataLink_ParamNameStr(), ecorePackage.getEString(), "paramNameStr", null, 0, 1, DataLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDataLink_ParamChunks(), theMapsPackage.getStringToChunksMap(), null, "paramChunks", null, 0, -1, DataLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDataLink_IdenticalGrouping(), ecorePackage.getEBoolean(), "identicalGrouping", "false", 0, 1, DataLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDataLink_Condition(), theCorePackage.getCondition(), null, "condition", null, 0, 1, DataLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDataLink_IntermediateTasks(), theCorePackage.getPreprocessingTask(), null, "intermediateTasks", null, 0, -1, DataLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDataLink_Data(), this.getData(), null, "data", null, 0, 1, DataLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDataLink_InData(), this.getData(), null, "inData", null, 0, 1, DataLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDataLink_Terminal(), ecorePackage.getEBoolean(), "terminal", "false", 0, 1, DataLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDataLink_Processed(), ecorePackage.getEBoolean(), "processed", "false", 0, 1, DataLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDataLink_DataResourceName(), theEasyflowPackage.getURI(), "dataResourceName", null, 0, 1, DataLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDataLink_Pipe(), ecorePackage.getEBooleanObject(), "pipe", null, 0, 1, DataLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDataLink_Flags(), ecorePackage.getEInt(), "flags", "0", 0, 1, DataLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getDataLink__IsUnconditional(), ecorePackage.getEBoolean(), "isUnconditional", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getDataLink__GetUniqueString__String_String_String(), ecorePackage.getEString(), "getUniqueString", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "prefix", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "suffix", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "sep", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getDataLink__GetUniqueString(), ecorePackage.getEString(), "getUniqueString", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getDataLink__GetUniqueString__boolean(), ecorePackage.getEString(), "getUniqueString", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEBoolean(), "isVerbose", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getDataLink__GetFormat(), this.getDataFormat(), "getFormat", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getDataLink__IsPipeable(), ecorePackage.getEBoolean(), "isPipeable", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getDataLink__GetMatchingDataFor__EList_EList_boolean(), this.getData(), "getMatchingDataFor", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getData(), "dataList", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "allowedHandles", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEBoolean(), "useOutDataPort", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theEasyflowPackage.getNoValidInOutDataException());

		initEClass(dataEClass, Data.class, "Data", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getData_Label(), ecorePackage.getEString(), "label", null, 0, 1, Data.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getData_Port(), this.getDataPort(), null, "port", null, 0, 1, Data.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getData_Output(), ecorePackage.getEBoolean(), "output", "false", 0, 1, Data.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getData_Name(), ecorePackage.getEString(), "name", null, 0, 1, Data.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getData_Description(), ecorePackage.getEString(), "description", null, 0, 1, Data.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getData_Parameter(), theToolPackage.getParameter(), null, "parameter", null, 0, 1, Data.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getData_ResolvedParam(), theToolPackage.getResolvedParam(), null, "resolvedParam", null, 0, 1, Data.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getData_Handle(), ecorePackage.getEString(), "handle", null, 0, 1, Data.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getData__GetFormat(), this.getDataFormat(), "getFormat", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getData__GetFormatStr(), ecorePackage.getEString(), "getFormatStr", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getData__IsAllowed(), ecorePackage.getEBoolean(), "isAllowed", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getData__GetSupportedHandles(), ecorePackage.getEString(), "getSupportedHandles", 0, -1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getData__Match__Data(), ecorePackage.getEBoolean(), "match", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getData(), "testData", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getData__MatchFormat__DataFormat(), ecorePackage.getEBoolean(), "matchFormat", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getDataFormat(), "testDataFormat", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getData__ResolveHandle__Data(), ecorePackage.getEBoolean(), "resolveHandle", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getData(), "testData", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getData__ResolveHandle__String(), ecorePackage.getEBoolean(), "resolveHandle", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "handle", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getData__ResolveSupportedHandles(), ecorePackage.getEString(), "resolveSupportedHandles", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getData__IsPipable(), ecorePackage.getEBoolean(), "isPipable", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(dataFormatEClass, DataFormat.class, "DataFormat", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDataFormat_Name(), ecorePackage.getEString(), "name", null, 0, 1, DataFormat.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDataFormat_Description(), ecorePackage.getEString(), "description", null, 0, 1, DataFormat.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getDataFormat__Match__DataFormat(), ecorePackage.getEBoolean(), "match", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getDataFormat(), "testDataFormat", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getDataFormat__RenderAsFileExtension(), ecorePackage.getEString(), "renderAsFileExtension", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(dataMatchEClass, DataMatch.class, "DataMatch", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDataMatch_ParentData(), this.getData(), null, "parentData", null, 0, 1, DataMatch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDataMatch_ChildData(), this.getData(), null, "childData", null, 0, 1, DataMatch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDataMatch_Score(), ecorePackage.getELong(), "score", "0", 0, 1, DataMatch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getDataMatch__ComputeScore__EMap(), ecorePackage.getELong(), "computeScore", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theMapsPackage.getStringToStringMap(), "constraints", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getDataMatch__IsPipable(), ecorePackage.getEBoolean(), "isPipable", 0, 1, IS_UNIQUE, IS_ORDERED);
	}

} //DataPackageImpl
