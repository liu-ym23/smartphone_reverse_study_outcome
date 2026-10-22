package com.obric.security.secretdata;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class QueryResult {
    private List<SecretData> mDataList;
    private int mResultCode;

    public QueryResult(int resultCode, List<SecretData> dataList) {
        this.mResultCode = resultCode;
        this.mDataList = dataList;
    }

    public int getResultCode() {
        return this.mResultCode;
    }

    public List<SecretData> getDataList() {
        return this.mDataList;
    }
}
