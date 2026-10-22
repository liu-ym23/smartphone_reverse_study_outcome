package com.bytedance.retrofit2;

import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Response;
import com.bytedance.retrofit2.mime.TypedInput;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class SsResponse<T> {
    private final T body;
    private final TypedInput errorBody;
    private final Response rawResponse;
    private RetrofitMetrics retrofitMetrics;

    public static <T> SsResponse<T> success(T r2, Response r3) {
        if (r3 == null) goto L10;
        if (r3.isSuccessful() == false) goto L8;
        return new SsResponse(r3, r2, null);
    L8:
        throw new IllegalArgumentException("rawResponse must be successful response");
    L10:
        throw new NullPointerException("rawResponse == null");
    }

    public static <T> SsResponse<T> error(TypedInput r2, Response r3) {
        if (r2 == null) goto L13;
        if (r3 == null) goto L11;
        if (r3.isSuccessful() == true) goto L9;
        return new SsResponse(r3, null, r2);
    L9:
        throw new IllegalArgumentException("rawResponse should not be successful response");
    L11:
        throw new NullPointerException("rawResponse == null");
    L13:
        throw new NullPointerException("body == null");
    }

    private SsResponse(Response r1, T r2, TypedInput r3) {
        this.rawResponse = r1;
        this.body = r2;
        this.errorBody = r3;
    }

    public RetrofitMetrics getRetrofitMetrics() {
        return this.retrofitMetrics;
    }

    public void setRetrofitMetrics(RetrofitMetrics r1) {
        this.retrofitMetrics = r1;
    }

    public Response raw() {
        return this.rawResponse;
    }

    public int code() {
        return this.rawResponse.getStatus();
    }

    public List<Header> headers() {
        return this.rawResponse.getHeaders();
    }

    public boolean isSuccessful() {
        return this.rawResponse.isSuccessful();
    }

    public T body() {
        return this.body;
    }

    public TypedInput errorBody() {
        return this.errorBody;
    }

    public String message() {
        return this.rawResponse.message();
    }
}
