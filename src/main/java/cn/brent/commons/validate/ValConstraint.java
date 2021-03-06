package cn.brent.commons.validate;

import java.io.Serializable;
import java.util.Map;

public class ValConstraint implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private final String field;

	/** 异常码  */
	private final String errorCode;

	/** 异常消息 */
	private final String message;

	/** 异常消息模板 */
	private final String messageTemplate;

	/** 消息模板变量 */
	private final Map<String, ? extends Serializable> messageVariables;

	/** 严重程度*/
	private final int severity;

	/** 无效值*/
	private transient Object invalidValue;

	/** 校验对象属性值*/
	private transient Object validatedObject;

	public ValConstraint(Check check, String message, Object validatedObject, Object invalidValue) {
		this.field=check.getField().getName();
		this.errorCode = check.getErrorCode();
		this.message = message;
		this.severity = check.getSeverity();
		this.messageTemplate = check.getMessage();
		this.messageVariables = check.getMessageVariables();
		this.invalidValue = invalidValue;
		this.validatedObject = validatedObject;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getMessage() {
		return message;
	}

	public String getMessageTemplate() {
		return messageTemplate;
	}

	public Map<String, ? extends Serializable> getMessageVariables() {
		return messageVariables;
	}

	public int getSeverity() {
		return severity;
	}

	public Object getInvalidValue() {
		return invalidValue;
	}

	public Object getValidatedObject() {
		return validatedObject;
	}
	
	public String getField() {
		return field;
	}
	
	@Override
	public String toString() {
		return new StringBuffer("(").append(field).append(")").append(message).append("[").append(errorCode).append("]").toString();
	}

}
