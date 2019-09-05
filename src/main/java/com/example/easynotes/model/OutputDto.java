/**
 * 
 */
package com.example.easynotes.model;

/**
 * @author WAHID
 *
 */
public class OutputDto {
	
	private String errorMessage;
	
	private Object data;

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "OutputDto [errorMessage=" + errorMessage + ", data=" + data + "]";
	}

	public OutputDto(String errorMessage, Object data) {
		super();
		this.errorMessage = errorMessage;
		this.data = data;
	}
	
	

}
