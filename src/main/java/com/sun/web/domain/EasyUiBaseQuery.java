package com.sun.web.domain;


public class EasyUiBaseQuery{

    private Integer page=1;

    private Integer rows=2;

    private String type;

    private String name;

    private String singername;

    private Integer free;

    private Boolean globalstatus;

    private Boolean submit;
    
    public Integer getFree() {
        return free;
    }

    public void setFree(Integer free) {
        this.free = free;
    }

    public Boolean getGlobalstatus() {
        return globalstatus;
    }

    public void setGlobalstatus(Boolean globalstatus) {
        this.globalstatus = globalstatus;
    }

    public Boolean getSubmit() {
        return submit;
    }

    public void setSubmit(Boolean submit) {
        this.submit = submit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSingername() {
        return singername;
    }

    public void setSingername(String singername) {
        this.singername = singername;
    }

    @Override
	public String toString() {
		return "EasyUiBaseQuery [page=" + page + ", rows=" + rows + ", type=" + type + ", name=" + name + ", globalstatus=" + globalstatus + ", submit="
				+ submit + "]";
	}
    
}
