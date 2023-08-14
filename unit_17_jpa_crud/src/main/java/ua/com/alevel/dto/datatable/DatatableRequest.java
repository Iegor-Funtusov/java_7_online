package ua.com.alevel.dto.datatable;

public record DatatableRequest(int pageSize, int currentPage, String sort, String orderBy) { }
