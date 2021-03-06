/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package easyflow.execution;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see easyflow.execution.ExecutionPackage
 * @generated
 */
public interface ExecutionFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ExecutionFactory eINSTANCE = easyflow.execution.impl.ExecutionFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Default Execution System</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Default Execution System</em>'.
	 * @generated
	 */
	DefaultExecutionSystem createDefaultExecutionSystem();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ExecutionPackage getExecutionPackage();

} //ExecutionFactory
