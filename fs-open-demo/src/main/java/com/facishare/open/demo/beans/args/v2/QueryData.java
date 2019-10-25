package com.facishare.open.demo.beans.args.v2;

import com.google.common.base.MoreObjects;

import java.util.Arrays;
import java.util.List;

/**
 * Query Arg
 * Created by zhongcy on 2017/1/6.
 */
public class QueryData{

    private static final long serialVersionUID = -6119269380581225350L;
    private String dataObjectApiName;

    private SearchQuery search_query_info;

    public String getDataObjectApiName() {
        return dataObjectApiName;
    }

    public void setDataObjectApiName(String dataObjectApiName) {
        this.dataObjectApiName = dataObjectApiName;
    }

    public SearchQuery getSearchQuery() {
        return search_query_info;
    }

    public void setSearchQuery(SearchQuery search_query_info) {
        this.search_query_info = search_query_info;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("dataObjectApiName", dataObjectApiName)
                .add("search_query_info", search_query_info)
                .toString();
    }

    public static class SearchQuery{
        //偏移量
        private int offset = 0;

        //获取数据条数，取最大值1000
        private int limit = 20;

        private DataProjection fieldProjection;

        private List<Filter> filters;

        private List<Order> orders;

        public int getOffset() {
            return offset;
        }

        public void setOffset(int offset) {
            this.offset = offset;
        }

        public int getLimit() {
            return limit;
        }

        public void setLimit(int limit) {
            this.limit = limit;
        }

        public DataProjection getFieldProjection() {
            return fieldProjection;
        }

        public void setFieldProjection(DataProjection fieldProjection) {
            this.fieldProjection = fieldProjection;
        }

        public List<Filter> getFilters() {
            return filters;
        }

        public void setFilters(List<Filter> filters) {
            this.filters = filters;
        }

        public List<Order> getOrders() {
            return orders;
        }

        public void setOrders(List<Order> orders) {
            this.orders = orders;
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("offset", offset)
                    .add("limit", limit)
                    .add("fieldProjection", fieldProjection)
                    .add("filters", filters)
                    .add("orders", orders)
                    .toString();
        }
    }
    public static class DataProjection{
        private List<String> fieldNames = Arrays.asList("_id","name","last_modified_time");

        public List<String> getFieldNames() {
            return fieldNames;
        }

        public void setFieldNames(List<String> fieldNames) {
            this.fieldNames = fieldNames;
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("fieldNames", fieldNames)
                    .toString();
        }
    }

    public static class Filter{
        private String fieldName = "last_modified_time";

        private Long from;

        //默认不包含最低值
        private boolean includeLower = false;

        private Long to = 4102358400000L;

        private boolean includeUpper = false;


        public String getFieldName() {
            return fieldName;
        }

        public void setFieldName(String fieldName) {
            this.fieldName = fieldName;
        }

        public Long getFrom() {
            return from;
        }

        public void setFrom(Long from) {
            this.from = from;
        }

        public boolean isIncludeLower() {
            return includeLower;
        }

        public void setIncludeLower(boolean includeLower) {
            this.includeLower = includeLower;
        }

        public Long getTo() {
            return to;
        }

        public void setTo(Long to) {
            this.to = to;
        }

        public boolean isIncludeUpper() {
            return includeUpper;
        }

        public void setIncludeUpper(boolean includeUpper) {
            this.includeUpper = includeUpper;
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("fieldName", fieldName)
                    .add("from", from)
                    .add("includeLower", includeLower)
                    .add("to", to)
                    .add("includeUpper", includeUpper)
                    .toString();
        }
    }

    public static class Order{
        //降序
        private boolean isAsc = false;

        //字段,默认按照最后更新时间排序
        private String fieldName = "last_modified_time";

        public boolean getIsAsc() {
            return isAsc;
        }

        public void setIsAsc(boolean isAsc) {
            this.isAsc = isAsc;
        }

        public String getFieldName() {
            return fieldName;
        }

        public void setFieldName(String fieldName) {
            this.fieldName = fieldName;
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("isAsc", isAsc)
                    .add("fieldName", fieldName)
                    .toString();
        }
    }

}

