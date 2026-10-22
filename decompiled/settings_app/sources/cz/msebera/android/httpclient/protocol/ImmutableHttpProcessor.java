package cz.msebera.android.httpclient.protocol;

import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpRequestInterceptor;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.HttpResponseInterceptor;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public final class ImmutableHttpProcessor implements HttpProcessor {
    private final HttpRequestInterceptor[] requestInterceptors;
    private final HttpResponseInterceptor[] responseInterceptors;

    public ImmutableHttpProcessor(HttpRequestInterceptor[] r4, HttpResponseInterceptor[] r5) {
        if (r4 == null) goto L5;
        int r1 = r4.length;
        HttpRequestInterceptor[] r2 = new HttpRequestInterceptor[r1];
        this.requestInterceptors = r2;
        System.arraycopy(r4, 0, r2, 0, r1);
    L6:
        if (r5 == null) goto L8;
        int r6 = r5.length;
        HttpResponseInterceptor[] r3 = new HttpResponseInterceptor[r6];
        this.responseInterceptors = r3;
        System.arraycopy(r5, 0, r3, 0, r6);
        return;
    L8:
        this.responseInterceptors = new HttpResponseInterceptor[0];
        return;
    L5:
        this.requestInterceptors = new HttpRequestInterceptor[0];
        goto L6
    }

    public ImmutableHttpProcessor(List<HttpRequestInterceptor> r3, List<HttpResponseInterceptor> r4) {
        if (r3 == null) goto L5;
        this.requestInterceptors = (HttpRequestInterceptor[]) r3.toArray(new HttpRequestInterceptor[r3.size()]);
    L6:
        if (r4 == null) goto L8;
        this.responseInterceptors = (HttpResponseInterceptor[]) r4.toArray(new HttpResponseInterceptor[r4.size()]);
        return;
    L8:
        this.responseInterceptors = new HttpResponseInterceptor[0];
        return;
    L5:
        this.requestInterceptors = new HttpRequestInterceptor[0];
        goto L6
    }

    @Deprecated
    public ImmutableHttpProcessor(HttpRequestInterceptorList r6, HttpResponseInterceptorList r7) {
        int r0 = 0;
        if (r6 == null) goto L7;
        int r1 = r6.getRequestInterceptorCount();
        this.requestInterceptors = new HttpRequestInterceptor[r1];
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L8;
        this.requestInterceptors[r2] = r6.getRequestInterceptor(r2);
        r2 = r2 + 1;
    L8:
        if (r7 == null) goto L12;
        int r8 = r7.getResponseInterceptorCount();
        this.responseInterceptors = new HttpResponseInterceptor[r8];
    L10:
        if (r0 >= r8) goto L16;
        this.responseInterceptors[r0] = r7.getResponseInterceptor(r0);
        r0 = r0 + 1;
        goto L10
    L16:
        return;
    L12:
        this.responseInterceptors = new HttpResponseInterceptor[0];
        return;
    L7:
        this.requestInterceptors = new HttpRequestInterceptor[0];
        goto L8
    }

    public ImmutableHttpProcessor(HttpRequestInterceptor... r2) {
        this(r2, null);
    }

    public ImmutableHttpProcessor(HttpResponseInterceptor... r2) {
        this(null, r2);
    }

    @Override // cz.msebera.android.httpclient.HttpRequestInterceptor
    public void process(HttpRequest r4, HttpContext r5) throws IOException, HttpException {
        HttpRequestInterceptor[] r3 = this.requestInterceptors;
        int r0 = r3.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r3[r1].process(r4, r5);
        r1 = r1 + 1;
        goto L3
    }

    @Override // cz.msebera.android.httpclient.HttpResponseInterceptor
    public void process(HttpResponse r4, HttpContext r5) throws IOException, HttpException {
        HttpResponseInterceptor[] r3 = this.responseInterceptors;
        int r0 = r3.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r3[r1].process(r4, r5);
        r1 = r1 + 1;
        goto L3
    }
}
