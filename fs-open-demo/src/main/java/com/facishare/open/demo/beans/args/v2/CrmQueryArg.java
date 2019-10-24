package com.facishare.open.demo.beans.args.v2;

import com.google.common.base.MoreObjects;

import java.util.Arrays;
import java.util.List;

/**
 * Query Arg
 * Created by zhongcy on 2017/1/6.
 */
public class CrmQueryArg extends BaseArg{

    private static final long serialVersionUID = -6119269380581225350L;


    private QueryData data;

    public QueryData getData() {
        return data;
    }

    public void setData(QueryData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("data", data)
                .toString();
    }


}

