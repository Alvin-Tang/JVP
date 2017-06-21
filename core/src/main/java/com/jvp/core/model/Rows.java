package com.jvp.core.model;


public class Rows
{
  private String name;
  private Object value;
  private String group;
  private Object editor;
  private String title;
  private Integer sort;
  private boolean hidden;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Object getValue() {
	return value;
}
public void setValue(Object value) {
	this.value = value;
}
public String getGroup() {
	return group;
}
public void setGroup(String group) {
	this.group = group;
}
public Object getEditor() {
	return editor;
}
public void setEditor(Object editor) {
	this.editor = editor;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public Integer getSort() {
	return sort;
}
public void setSort(Integer sort) {
	this.sort = sort;
}
public boolean isHidden() {
	return hidden;
}
public void setHidden(boolean hidden) {
	this.hidden = hidden;
}

  
}