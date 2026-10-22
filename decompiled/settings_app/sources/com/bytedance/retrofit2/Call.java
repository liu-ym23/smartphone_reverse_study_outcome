package com.bytedance.retrofit2;

import com.bytedance.retrofit2.client.Request;

/* JADX INFO: loaded from: classes3.dex */
public interface Call<T> extends Cloneable {
    void cancel();

    Call<T> clone();

    void enqueue(Callback<T> r1);

    SsResponse<T> execute() throws Exception;

    boolean isCanceled();

    boolean isExecuted();

    Request request();
}
