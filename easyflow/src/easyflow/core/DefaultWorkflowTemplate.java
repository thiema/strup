/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package easyflow.core;

import java.io.BufferedReader;

import org.apache.log4j.Logger;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Default Workflow Template</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link easyflow.core.DefaultWorkflowTemplate#getTasks <em>Tasks</em>}</li>
 *   <li>{@link easyflow.core.DefaultWorkflowTemplate#getReader <em>Reader</em>}</li>
 *   <li>{@link easyflow.core.DefaultWorkflowTemplate#getLogger <em>Logger</em>}</li>
 * </ul>
 * </p>
 *
 * @see easyflow.core.CorePackage#getDefaultWorkflowTemplate()
 * @model
 * @generated
 */
public interface DefaultWorkflowTemplate extends IWorkflowTemplate {
	/**
	 * Returns the value of the '<em><b>Tasks</b></em>' reference list.
	 * The list contents are of type {@link easyflow.core.Task}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tasks</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tasks</em>' reference list.
	 * @see easyflow.core.CorePackage#getDefaultWorkflowTemplate_Tasks()
	 * @model
	 * @generated
	 */
	EList<Task> getTasks();

	/**
	 * Returns the value of the '<em><b>Reader</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reader</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reader</em>' attribute.
	 * @see #setReader(BufferedReader)
	 * @see easyflow.core.CorePackage#getDefaultWorkflowTemplate_Reader()
	 * @model dataType="easyflow.BufferedReader"
	 * @generated
	 */
	BufferedReader getReader();

	/**
	 * Sets the value of the '{@link easyflow.core.DefaultWorkflowTemplate#getReader <em>Reader</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reader</em>' attribute.
	 * @see #getReader()
	 * @generated
	 */
	void setReader(BufferedReader value);

	/**
	 * Returns the value of the '<em><b>Logger</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Logger</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Logger</em>' attribute.
	 * @see #setLogger(Logger)
	 * @see easyflow.core.CorePackage#getDefaultWorkflowTemplate_Logger()
	 * @model dataType="easyflow.Logger" transient="true"
	 * @generated
	 */
	Logger getLogger();

	/**
	 * Sets the value of the '{@link easyflow.core.DefaultWorkflowTemplate#getLogger <em>Logger</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Logger</em>' attribute.
	 * @see #getLogger()
	 * @generated
	 */
	void setLogger(Logger value);

} // DefaultWorkflowTemplate
