package com.jvp.core.model;

import java.util.ArrayList;
import java.util.List;

public class Detail<E> {
	
	private Integer total;
	private List<E> rows = new ArrayList<E>();

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public List<E> getRows() {
		return rows;
	}

	public void setRows(List<E> rows) {
		this.rows = rows;
	}

}