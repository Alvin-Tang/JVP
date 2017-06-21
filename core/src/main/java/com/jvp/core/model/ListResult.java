package com.jvp.core.model;

import java.util.List;

public class ListResult<T> extends Result {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<T> list;

	public ListResult() {

	}

	public ListResult(List<T> list) {
		this(true, list);
	}

	public ListResult(boolean success, List<T> list) {
		this(true, null, list);
	}

	public ListResult(boolean success, Message error, List<T> list) {
		super(success, error);
		this.list = list;
	}

	public List<T> getList() {
		return this.list;
	}
}