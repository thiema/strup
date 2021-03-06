/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package easyflow.execution.makeflow;

import easyflow.execution.ExecutionPackage;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see easyflow.execution.makeflow.MakeflowFactory
 * @model kind="package"
 * @generated
 */
public interface MakeflowPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "makeflow";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///de/thiema/easyflow/execution/makeflow/1.0.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "easyflow";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MakeflowPackage eINSTANCE = easyflow.execution.makeflow.impl.MakeflowPackageImpl.init();

	/**
	 * The meta object id for the '{@link easyflow.execution.makeflow.impl.MakeflowImpl <em>Makeflow</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see easyflow.execution.makeflow.impl.MakeflowImpl
	 * @see easyflow.execution.makeflow.impl.MakeflowPackageImpl#getMakeflow()
	 * @generated
	 */
	int MAKEFLOW = 0;

	/**
	 * The feature id for the '<em><b>Logger</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAKEFLOW__LOGGER = ExecutionPackage.IEXECUTION_SYSTEM__LOGGER;

	/**
	 * The feature id for the '<em><b>Writer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAKEFLOW__WRITER = ExecutionPackage.IEXECUTION_SYSTEM__WRITER;

	/**
	 * The feature id for the '<em><b>Unix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAKEFLOW__UNIX = ExecutionPackage.IEXECUTION_SYSTEM_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Makeflow</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAKEFLOW_FEATURE_COUNT = ExecutionPackage.IEXECUTION_SYSTEM_FEATURE_COUNT + 1;


	/**
	 * The operation id for the '<em>Get Jgraphx Visitor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAKEFLOW___GET_JGRAPHX_VISITOR = ExecutionPackage.IEXECUTION_SYSTEM___GET_JGRAPHX_VISITOR;

	/**
	 * The operation id for the '<em>Generate Execution String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAKEFLOW___GENERATE_EXECUTION_STRING__RULE = ExecutionPackage.IEXECUTION_SYSTEM___GENERATE_EXECUTION_STRING__RULE;

	/**
	 * The number of operations of the '<em>Makeflow</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAKEFLOW_OPERATION_COUNT = ExecutionPackage.IEXECUTION_SYSTEM_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link easyflow.execution.makeflow.Makeflow <em>Makeflow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Makeflow</em>'.
	 * @see easyflow.execution.makeflow.Makeflow
	 * @generated
	 */
	EClass getMakeflow();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	MakeflowFactory getMakeflowFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link easyflow.execution.makeflow.impl.MakeflowImpl <em>Makeflow</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see easyflow.execution.makeflow.impl.MakeflowImpl
		 * @see easyflow.execution.makeflow.impl.MakeflowPackageImpl#getMakeflow()
		 * @generated
		 */
		EClass MAKEFLOW = eINSTANCE.getMakeflow();

	}

} //MakeflowPackage
