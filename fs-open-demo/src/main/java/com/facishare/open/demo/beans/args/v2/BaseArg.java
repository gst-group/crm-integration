package com.facishare.open.demo.beans.args.v2;

import com.facishare.open.demo.beans.args.Arg;
import com.google.common.base.MoreObjects;

public class BaseArg extends com.facishare.open.demo.beans.args.BaseArg implements Arg{

    private static final long serialVersionUID = -6899653224372546750L;

    private String currentOpenUserId;

    public String getCurrentOpenUserId() {
        return currentOpenUserId;
    }

    public void setCurrentOpenUserId(String currentOpenUserId) {
        this.currentOpenUserId = currentOpenUserId;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("currentOpenUserId", currentOpenUserId)
                .toString();
    }
}
