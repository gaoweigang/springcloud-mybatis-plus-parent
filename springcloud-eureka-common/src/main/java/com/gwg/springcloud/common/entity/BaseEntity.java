package com.gwg.springcloud.common.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.toolkit.IdWorker;

public abstract class BaseEntity {

    @TableId("id")
	protected String id;

	/**
	 * 添加之前执行方法，需要手动调用
	 */
	public void preInsert(){
		this.setId(String.valueOf(IdWorker.getId()));
	}

	@TableField(exist=false)
	protected Long offset;
	@TableField(exist=false)
	protected Long rowNum;//在grid上显示记录条数，这个参数是要被传递到后台
	@TableField(exist=false)
	protected Long total;//总页数、不是总纪录数
	@TableField(exist=false)
	protected Long page;//当前页
	@TableField(exist=false)
	protected Long records;
	@TableField(exist=false)
	protected Long rows;
	
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	public Long getPage() {
		return page;
	}
	public void setPage(Long page) {
		this.page = page;
	}

	public Long getOffset() {
		return offset;
	}
	public void setOffset(Long offset) {
		this.offset = offset;
	}
	public Long getRowNum() {
		return rowNum;
	}
	public void setRowNum(Long rowNum) {
		this.rowNum = rowNum;
	}
	public Long getRecords() {
		return records;
	}
	public void setRecords(Long records) {
		this.records = records;
	}
	public Long getRows() {
		return rows;
	}
	public void setRows(Long rows) {
		this.rows = rows;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
}
