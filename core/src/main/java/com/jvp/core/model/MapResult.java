package com.jvp.core.model;

import java.util.HashMap;
import java.util.Map;


public class MapResult extends Result
{
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private Map<String, Object> attributes;

  public MapResult()
  {
    this(true);
  }

  public MapResult(boolean success) {
    this(success, null);
  }

  public MapResult(boolean success, Message error) {
    super(success, error);

    this.attributes = new HashMap<String, Object>();
  }

  public Map<String, Object> getAttributes()
  {
    return this.attributes;
  }

  public void addAttribute(String attribute, Object value)
  {
    this.attributes.put(attribute, value);
  }

  public Object getAttribute(String attribute)
  {
    return this.attributes.get(attribute);
  }
}