package com.jvp.core.model;

import java.util.HashMap;
import java.util.Map;

public class Page {
	
	public Page () {
	}
	
	public Page(int size, int page) {
		super();
		this.size = size;
		this.page = page;
	}
	
	public Page(Map<String, Object> paramMap) {
		super();
		this.paramMap = paramMap;
	}
	
	public Page(int size, int page, Map<String, Object> paramMap) {
		super();
		this.size = size;
		this.page = page;
		this.paramMap = paramMap;
	}

	private static int MAX_SIZE = 100;
	private static int DEFAULT_SIZE = 20;
	private static int FIRST_PAGE = 1;
	private int size = DEFAULT_SIZE;
	private int page = FIRST_PAGE;
	private Map<String, Object> paramMap = new HashMap<String, Object>();

	public long getFirst() {
		return ((getPage() - 1) * this.size);
	}

	public int getSize() {
		if ((this.size > MAX_SIZE) || (this.size <= 0))
			return DEFAULT_SIZE;

		return this.size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getPage() {
		if (this.page < FIRST_PAGE)
			return FIRST_PAGE;

		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public Map<String, Object> getParamMap() {
		return paramMap;
	}

	public void setParamMap(Map<String, Object> paramMap) {
		this.paramMap = paramMap;
	}

}