package com.bytedance.retrofit2;

/* JADX INFO: loaded from: classes.dex */
public interface ExpandCallback<T> extends Callback<T> {
    void onAsyncPreRequest(RequestBuilder r1);

    void onAsyncResponse(Call<T> r1, SsResponse<T> r2);
}
