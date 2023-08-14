package ua.com.alevel.dto.datatable;

import java.util.List;

public class DatatableResponse<RESPONSE> {

    private int pageSize;
    private int currentPage;
    private String sort;
    private String orderBy;
    private List<RESPONSE> items;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public List<RESPONSE> getItems() {
        return items;
    }

    public void setItems(List<RESPONSE> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "DatatableResponse{" +
                "pageSize=" + pageSize +
                ", currentPage=" + currentPage +
                ", sort='" + sort + '\'' +
                ", orderBy='" + orderBy + '\'' +
                ", items=" + items +
                '}';
    }
}
