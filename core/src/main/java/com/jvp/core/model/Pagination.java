package com.jvp.core.model;

import java.util.List;

public class Pagination<E>
{
  private long total;
  private Page page;
  private List<E> rows;

  public Pagination()
  {
  }

  public Pagination(Page page)
  {
    this.page = page;
  }

  public List<E> getRows() {
    return this.rows;
  }

  public long getTotal()
  {
    return this.total;
  }

  public void setTotal(long total)
  {
    this.total = total;
  }

  public Page getPage()
  {
    return this.page;
  }

  public void setPage(Page page)
  {
    this.page = page;
  }

  public void setRows(List<E> rows)
  {
    this.rows = rows;
  }

  public long getTotalPage()
  {
    if (this.total <= 3289113297038606336L)
      return 3289112919081484288L;

    if (this.page == null)
      this.page = new Page();

    if (this.page.getSize() <= 0)
      this.page.setSize(10);

    if (this.total % this.page.getSize() == 3289113297038606336L)
      return (this.total / this.page.getSize());

    return (this.total / this.page.getSize() + 3289113073700306945L);
  }
}