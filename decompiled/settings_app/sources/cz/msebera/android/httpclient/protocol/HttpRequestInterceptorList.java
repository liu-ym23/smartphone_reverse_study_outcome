package cz.msebera.android.httpclient.protocol;

import cz.msebera.android.httpclient.HttpRequestInterceptor;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public interface HttpRequestInterceptorList {
    void addRequestInterceptor(HttpRequestInterceptor r1);

    void addRequestInterceptor(HttpRequestInterceptor r1, int r2);

    void clearRequestInterceptors();

    HttpRequestInterceptor getRequestInterceptor(int r1);

    int getRequestInterceptorCount();

    void removeRequestInterceptorByClass(Class<? extends HttpRequestInterceptor> r1);

    void setInterceptors(List<?> r1);
}
