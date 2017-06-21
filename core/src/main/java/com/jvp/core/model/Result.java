package com.jvp.core.model;

import java.io.Serializable;

public class Result implements Serializable
{
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private boolean success;
  private Serializable sid;
  private Message message;

  public Result()
  {
    this(true, null);
  }

  public Result(boolean success) {
    this(success, null);
  }

  public Result(boolean success, Message message) {
    this.success = success;
    this.message = message;
  }

  public boolean isSuccess()
  {
    return this.success;
  }

  public void setSuccess(boolean success)
  {
    this.success = success;
  }

  public String getMessageDesc()
  {
    if (this.message == null)
      return null;

    return this.message.getMessage();
  }

  public Integer getMessageCode()
  {
    if (this.message == null)
      return null;

    return Integer.valueOf(this.message.getCode());
  }

  public Serializable getSid()
  {
    return this.sid;
  }

  public void setSid(Serializable sid)
  {
    this.sid = sid;
  }
}