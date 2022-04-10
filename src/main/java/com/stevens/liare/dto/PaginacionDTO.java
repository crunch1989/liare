package com.stevens.liare.dto;


public class PaginacionDTO {
    private Integer sEcho;
    private Integer iColumns;
    private Integer iDisplayStart;
    private Integer iDisplayLength;
    private Integer iSortCol_0;
    private String sSortDir_0;     
  

    public Integer getsEcho() {
        return sEcho;
    }

    public Integer getiColumns() {
        return iColumns;
    }

    public Integer getiDisplayStart() {
        return iDisplayStart;
    }

    public Integer getiDisplayLength() {
        return iDisplayLength;
    }

    public Integer getiSortCol_0() {
        return iSortCol_0;
    }

    public String getsSortDir_0() {
        return sSortDir_0;
    }

    public void setsEcho(Integer sEcho) {
        this.sEcho = sEcho;
    }

    public void setiColumns(Integer iColumns) {
        this.iColumns = iColumns;
    }

    public void setiDisplayStart(Integer iDisplayStart) {
        this.iDisplayStart = iDisplayStart;
    }

    public void setiDisplayLength(Integer iDisplayLength) {
        this.iDisplayLength = iDisplayLength;
    }

    public void setiSortCol_0(Integer iSortCol_0) {
        this.iSortCol_0 = iSortCol_0;
    }

    public void setsSortDir_0(String sSortDir_0) {
        this.sSortDir_0 = sSortDir_0;
    }   
    

}
