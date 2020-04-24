/**
 * @file: Page
 * @author: michael
 * @date: 2020/4/22 17:02
 * @copyright: 南京凯盛
 */
package org.kisen.cloud.mms.common.controller.page;

import java.io.Serializable;
import java.util.List;

/**
 *
 *
 * @author michael
 * @version 1.0 Created on 2020/4/22 17:02
 */

public class Page<T> implements Serializable {

    private static final long serialVersionUID = 6219256683129892228L;

    private List<T> list;
    private int pageNumber = 1;
    private int pageSize = 20;
    private int totalPage;
    private int totalRow;

    public Page(List<T> list, int pageNumber, int pageSize, int totalPage, int totalRow) {
        this.list = list;
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.totalPage = totalPage;
        this.totalRow = totalRow;
    }

    public Page() {
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalRow() {
        return totalRow;
    }

    public void setTotalRow(int totalRow) {
        this.totalPage = (totalRow + this.pageSize - 1) / this.pageSize;
        this.totalRow = totalRow;
    }

    public boolean isFirstPage() {
        return this.pageNumber == 1;
    }

    public boolean isLastPage() {
        return this.pageNumber >= this.totalPage;
    }

    public String toString() {
        StringBuilder msg = new StringBuilder();
        msg.append("pageNumber : ").append(this.pageNumber);
        msg.append("\npageSize : ").append(this.pageSize);
        msg.append("\ntotalPage : ").append(this.totalPage);
        msg.append("\ntotalRow : ").append(this.totalRow);
        return msg.toString();
    }
}
