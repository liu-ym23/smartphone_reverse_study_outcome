package cz.msebera.android.httpclient.protocol;

import cz.msebera.android.httpclient.HttpResponseInterceptor;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public interface HttpResponseInterceptorList {
    void addResponseInterceptor(HttpResponseInterceptor r1);

    void addResponseInterceptor(HttpResponseInterceptor r1, int r2);

    void clearResponseInterceptors();

    HttpResponseInterceptor getResponseInterceptor(int r1);

    int getResponseInterceptorCount();

    void removeResponseInterceptorByClass(Class<? extends HttpResponseInterceptor> r1);

    void setInterceptors(List<?> r1);
}
