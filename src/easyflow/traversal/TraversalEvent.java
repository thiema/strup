/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package easyflow.traversal;

import com.mxgraph.model.mxICell;

import easyflow.core.Task;

import org.apache.log4j.Logger;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link easyflow.traversal.TraversalEvent#getMergeTask <em>Merge Task</em>}</li>
 *   <li>{@link easyflow.traversal.TraversalEvent#getSplitTask <em>Split Task</em>}</li>
 *   <li>{@link easyflow.traversal.TraversalEvent#getParentTask <em>Parent Task</em>}</li>
 *   <li>{@link easyflow.traversal.TraversalEvent#getMergeTasksParamCrit <em>Merge Tasks Param Crit</em>}</li>
 *   <li>{@link easyflow.traversal.TraversalEvent#getParentCells <em>Parent Cells</em>}</li>
 *   <li>{@link easyflow.traversal.TraversalEvent#getTraversalCriterion <em>Traversal Criterion</em>}</li>
 *   <li>{@link easyflow.traversal.TraversalEvent#getLogger <em>Logger</em>}</li>
 *   <li>{@link easyflow.traversal.TraversalEvent#getMetaData <em>Meta Data</em>}</li>
 *   <li>{@link easyflow.traversal.TraversalEvent#getDependancy <em>Dependancy</em>}</li>
 * </ul>
 * </p>
 *
 * @see easyflow.traversal.TraversalPackage#getTraversalEvent()
 * @model
 * @generated
 */
public interface TraversalEvent extends EObject {
	/**
	 * Returns the value of the '<em><b>Merge Task</b></em>' reference list.
	 * The list contents are of type {@link easyflow.core.Task}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Merge Task</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Merge Task</em>' reference list.
	 * @see easyflow.traversal.TraversalPackage#getTraversalEvent_MergeTask()
	 * @model
	 * @generated
	 */
	EList<Task> getMergeTask();

	/**
	 * Returns the value of the '<em><b>Split Task</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Split Task</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Split Task</em>' reference.
	 * @see #setSplitTask(Task)
	 * @see easyflow.traversal.TraversalPackage#getTraversalEvent_SplitTask()
	 * @model
	 * @generated
	 */
	Task getSplitTask();

	/**
	 * Sets the value of the '{@link easyflow.traversal.TraversalEvent#getSplitTask <em>Split Task</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Split Task</em>' reference.
	 * @see #getSplitTask()
	 * @generated
	 */
	void setSplitTask(Task value);

	/**
	 * Returns the value of the '<em><b>Parent Task</b></em>' reference list.
	 * The list contents are of type {@link easyflow.core.Task}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Task</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Task</em>' reference list.
	 * @see easyflow.traversal.TraversalPackage#getTraversalEvent_ParentTask()
	 * @model
	 * @generated
	 */
	EList<Task> getParentTask();

	/**
	 * Returns the value of the '<em><b>Merge Tasks Param Crit</b></em>' reference list.
	 * The list contents are of type {@link easyflow.core.Task}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Merge Tasks Param Crit</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Merge Tasks Param Crit</em>' reference list.
	 * @see easyflow.traversal.TraversalPackage#getTraversalEvent_MergeTasksParamCrit()
	 * @model
	 * @generated
	 */
	EList<Task> getMergeTasksParamCrit();

	/**
	 * Returns the value of the '<em><b>Parent Cells</b></em>' attribute list.
	 * The list contents are of type {@link com.mxgraph.model.mxICell}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Cells</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Cells</em>' attribute list.
	 * @see easyflow.traversal.TraversalPackage#getTraversalEvent_ParentCells()
	 * @model dataType="easyflow.mxICell" transient="true"
	 * @generated
	 */
	EList<mxICell> getParentCells();

	/**
	 * Returns the value of the '<em><b>Traversal Criterion</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Traversal Criterion</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Traversal Criterion</em>' reference.
	 * @see #setTraversalCriterion(TraversalCriterion)
	 * @see easyflow.traversal.TraversalPackage#getTraversalEvent_TraversalCriterion()
	 * @model
	 * @generated
	 */
	TraversalCriterion getTraversalCriterion();

	/**
	 * Sets the value of the '{@link easyflow.traversal.TraversalEvent#getTraversalCriterion <em>Traversal Criterion</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Traversal Criterion</em>' reference.
	 * @see #getTraversalCriterion()
	 * @generated
	 */
	void setTraversalCriterion(TraversalCriterion value);

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
	 * @see easyflow.traversal.TraversalPackage#getTraversalEvent_Logger()
	 * @model dataType="easyflow.Logger" transient="true"
	 * @generated
	 */
	Logger getLogger();

	/**
	 * Sets the value of the '{@link easyflow.traversal.TraversalEvent#getLogger <em>Logger</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Logger</em>' attribute.
	 * @see #getLogger()
	 * @generated
	 */
	void setLogger(Logger value);

	/**
	 * Returns the value of the '<em><b>Meta Data</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Meta Data</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Meta Data</em>' attribute.
	 * @see #setMetaData(EObject)
	 * @see easyflow.traversal.TraversalPackage#getTraversalEvent_MetaData()
	 * @model dataType="easyflow.EObject" transient="true"
	 * @generated
	 */
	EObject getMetaData();

	/**
	 * Sets the value of the '{@link easyflow.traversal.TraversalEvent#getMetaData <em>Meta Data</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Meta Data</em>' attribute.
	 * @see #getMetaData()
	 * @generated
	 */
	void setMetaData(EObject value);

	/**
	 * Returns the value of the '<em><b>Dependancy</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dependancy</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dependancy</em>' reference.
	 * @see #setDependancy(TraversalDependency)
	 * @see easyflow.traversal.TraversalPackage#getTraversalEvent_Dependancy()
	 * @model
	 * @generated
	 */
	TraversalDependency getDependancy();

	/**
	 * Sets the value of the '{@link easyflow.traversal.TraversalEvent#getDependancy <em>Dependancy</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dependancy</em>' reference.
	 * @see #getDependancy()
	 * @generated
	 */
	void setDependancy(TraversalDependency value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean applyMetadata();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	void readChunks();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean isGrouping();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean isParent(Task parentTask, String traversalChunkName);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	String getType();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	int getDepNum();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void incDep();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void decDep();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean hasDep();

} // TraversalEvent
