package com.example.pacman;

public class ValidationError {

	private final Object data;
	private final int errorCode;

	public ValidationError(Object data, int errorCode) {
		this.data = data;
		this.errorCode = errorCode;
	}

	public Object getData() {
		return data;
	}

	public int getErrorCode() {
		return errorCode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + errorCode;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ValidationError other = (ValidationError) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (errorCode != other.errorCode)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ValidationError [data=" + data + ", errorCode=" + errorCode
				+ "]";
	}

}
