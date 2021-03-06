/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package easyflow.core.impl;

import easyflow.core.Condition;
import easyflow.core.CorePackage;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Condition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link easyflow.core.impl.ConditionImpl#getForbidden <em>Forbidden</em>}</li>
 *   <li>{@link easyflow.core.impl.ConditionImpl#getCircumventingParents <em>Circumventing Parents</em>}</li>
 *   <li>{@link easyflow.core.impl.ConditionImpl#getLogger <em>Logger</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConditionImpl extends MinimalEObjectImpl.Container implements Condition {
	/**
	 * The cached value of the '{@link #getForbidden() <em>Forbidden</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getForbidden()
	 * @generated
	 * @ordered
	 */
	protected EList<String> forbidden;

	/**
	 * The cached value of the '{@link #getCircumventingParents() <em>Circumventing Parents</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCircumventingParents()
	 * @generated
	 * @ordered
	 */
	protected EList<String> circumventingParents;

	/**
	 * The default value of the '{@link #getLogger() <em>Logger</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLogger()
	 * @generated
	 * @ordered
	 */
	protected static final Logger LOGGER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLogger() <em>Logger</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLogger()
	 * @generated
	 * @ordered
	 */
	protected Logger logger = LOGGER_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConditionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CorePackage.Literals.CONDITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getForbidden() {
		if (forbidden == null) {
			forbidden = new EDataTypeUniqueEList<String>(String.class, this, CorePackage.CONDITION__FORBIDDEN);
		}
		return forbidden;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getCircumventingParents() {
		if (circumventingParents == null) {
			circumventingParents = new EDataTypeUniqueEList<String>(String.class, this, CorePackage.CONDITION__CIRCUMVENTING_PARENTS);
		}
		return circumventingParents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Logger getLogger() {
		return logger;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	public boolean isUnconditional() {
		return (getForbidden() == null || getForbidden().isEmpty());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CorePackage.CONDITION__FORBIDDEN:
				return getForbidden();
			case CorePackage.CONDITION__CIRCUMVENTING_PARENTS:
				return getCircumventingParents();
			case CorePackage.CONDITION__LOGGER:
				return getLogger();
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
			case CorePackage.CONDITION__FORBIDDEN:
				getForbidden().clear();
				getForbidden().addAll((Collection<? extends String>)newValue);
				return;
			case CorePackage.CONDITION__CIRCUMVENTING_PARENTS:
				getCircumventingParents().clear();
				getCircumventingParents().addAll((Collection<? extends String>)newValue);
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
			case CorePackage.CONDITION__FORBIDDEN:
				getForbidden().clear();
				return;
			case CorePackage.CONDITION__CIRCUMVENTING_PARENTS:
				getCircumventingParents().clear();
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
			case CorePackage.CONDITION__FORBIDDEN:
				return forbidden != null && !forbidden.isEmpty();
			case CorePackage.CONDITION__CIRCUMVENTING_PARENTS:
				return circumventingParents != null && !circumventingParents.isEmpty();
			case CorePackage.CONDITION__LOGGER:
				return LOGGER_EDEFAULT == null ? logger != null : !LOGGER_EDEFAULT.equals(logger);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case CorePackage.CONDITION___IS_UNCONDITIONAL:
				return isUnconditional();
		}
		return super.eInvoke(operationID, arguments);
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
		result.append(" (forbidden: ");
		result.append(forbidden);
		result.append(", circumventingParents: ");
		result.append(circumventingParents);
		result.append(", logger: ");
		result.append(logger);
		result.append(')');
		return result.toString();
	}

} //ConditionImpl
