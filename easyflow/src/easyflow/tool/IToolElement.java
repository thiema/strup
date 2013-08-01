/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package easyflow.tool;

import org.eclipse.emf.ecore.EObject;

import org.w3c.dom.Element;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ITool Element</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see easyflow.tool.ToolPackage#getIToolElement()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface IToolElement extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model elementDataType="easyflow.Element"
	 * @generated
	 */
	void readImplementation(Element element);

} // IToolElement