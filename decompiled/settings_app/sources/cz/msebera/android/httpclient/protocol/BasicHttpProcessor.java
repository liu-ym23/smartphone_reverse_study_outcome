package cz.msebera.android.httpclient.protocol;

import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpRequestInterceptor;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.HttpResponseInterceptor;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public final class BasicHttpProcessor implements HttpProcessor, HttpRequestInterceptorList, HttpResponseInterceptorList, Cloneable {
    protected final List<HttpRequestInterceptor> requestInterceptors;
    protected final List<HttpResponseInterceptor> responseInterceptors;

    public BasicHttpProcessor() {
        this.requestInterceptors = new ArrayList();
        this.responseInterceptors = new ArrayList();
    }

    @Override // cz.msebera.android.httpclient.protocol.HttpRequestInterceptorList
    public void addRequestInterceptor(HttpRequestInterceptor r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        this.requestInterceptors.add(r1);
    }

    @Override // cz.msebera.android.httpclient.protocol.HttpRequestInterceptorList
    public void addRequestInterceptor(HttpRequestInterceptor r1, int r2) {
        if (r1 != null) goto L4;
        return;
    L4:
        this.requestInterceptors.add(r2, r1);
    }

    @Override // cz.msebera.android.httpclient.protocol.HttpResponseInterceptorList
    public void addResponseInterceptor(HttpResponseInterceptor r1, int r2) {
        if (r1 != null) goto L4;
        return;
    L4:
        this.responseInterceptors.add(r2, r1);
    }

    @Override // cz.msebera.android.httpclient.protocol.HttpRequestInterceptorList
    public void removeRequestInterceptorByClass(Class<? extends HttpRequestInterceptor> r2) {
        Iterator<HttpRequestInterceptor> r1 = this.requestInterceptors.iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        if (r1.next().getClass().equals(r2) == false) goto L4;
        r1.remove();
        goto L4
    }

    @Override // cz.msebera.android.httpclient.protocol.HttpResponseInterceptorList
    public void removeResponseInterceptorByClass(Class<? extends HttpResponseInterceptor> r2) {
        Iterator<HttpResponseInterceptor> r1 = this.responseInterceptors.iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        if (r1.next().getClass().equals(r2) == false) goto L4;
        r1.remove();
        goto L4
    }

    public final void addInterceptor(HttpRequestInterceptor r1) {
        addRequestInterceptor(r1);
    }

    public final void addInterceptor(HttpRequestInterceptor r1, int r2) {
        addRequestInterceptor(r1, r2);
    }

    @Override // cz.msebera.android.httpclient.protocol.HttpRequestInterceptorList
    public int getRequestInterceptorCount() {
        return this.requestInterceptors.size();
    }

    @Override // cz.msebera.android.httpclient.protocol.HttpRequestInterceptorList
    public HttpRequestInterceptor getRequestInterceptor(int r2) {
        if (r2 >= 0) goto L4;
        return null;
    L4:
        if (r2 < this.requestInterceptors.size()) goto L7;
        return null;
    L7:
        return this.requestInterceptors.get(r2);
    }

    @Override // cz.msebera.android.httpclient.protocol.HttpRequestInterceptorList
    public void clearRequestInterceptors() {
        this.requestInterceptors.clear();
    }

    @Override // cz.msebera.android.httpclient.protocol.HttpResponseInterceptorList
    public void addResponseInterceptor(HttpResponseInterceptor r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        this.responseInterceptors.add(r1);
    }

    public final void addInterceptor(HttpResponseInterceptor r1) {
        addResponseInterceptor(r1);
    }

    public final void addInterceptor(HttpResponseInterceptor r1, int r2) {
        addResponseInterceptor(r1, r2);
    }

    @Override // cz.msebera.android.httpclient.protocol.HttpResponseInterceptorList
    public int getResponseInterceptorCount() {
        return this.responseInterceptors.size();
    }

    @Override // cz.msebera.android.httpclient.protocol.HttpResponseInterceptorList
    public HttpResponseInterceptor getResponseInterceptor(int r2) {
        if (r2 >= 0) goto L4;
        return null;
    L4:
        if (r2 < this.responseInterceptors.size()) goto L7;
        return null;
    L7:
        return this.responseInterceptors.get(r2);
    }

    @Override // cz.msebera.android.httpclient.protocol.HttpResponseInterceptorList
    public void clearResponseInterceptors() {
        this.responseInterceptors.clear();
    }

    @Override // cz.msebera.android.httpclient.protocol.HttpRequestInterceptorList, cz.msebera.android.httpclient.protocol.HttpResponseInterceptorList
    public void setInterceptors(List<?> r3) {
        Args.notNull(r3, "Inteceptor list");
        this.requestInterceptors.clear();
        this.responseInterceptors.clear();
        Iterator<?> r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L11;
        Object r0 = r4.next();
        if ((r0 instanceof HttpRequestInterceptor) == false) goto L9;
        addInterceptor((HttpRequestInterceptor) r0);
    L9:
        if ((r0 instanceof HttpResponseInterceptor) == false) goto L4;
        addInterceptor((HttpResponseInterceptor) r0);
        goto L4
    }

    public void clearInterceptors() {
        clearRequestInterceptors();
        clearResponseInterceptors();
    }

    @Override // cz.msebera.android.httpclient.HttpRequestInterceptor
    public void process(HttpRequest r2, HttpContext r3) throws IOException, HttpException {
        Iterator<HttpRequestInterceptor> r1 = this.requestInterceptors.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().process(r2, r3);
        goto L4
    }

    @Override // cz.msebera.android.httpclient.HttpResponseInterceptor
    public void process(HttpResponse r2, HttpContext r3) throws IOException, HttpException {
        Iterator<HttpResponseInterceptor> r1 = this.responseInterceptors.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().process(r2, r3);
        goto L4
    }

    protected void copyInterceptors(BasicHttpProcessor r3) {
        r3.requestInterceptors.clear();
        r3.requestInterceptors.addAll(this.requestInterceptors);
        r3.responseInterceptors.clear();
        r3.responseInterceptors.addAll(this.responseInterceptors);
    }

    public BasicHttpProcessor copy() {
        BasicHttpProcessor r0 = new BasicHttpProcessor();
        copyInterceptors(r0);
        return r0;
    }

    public Object clone() throws CloneNotSupportedException {
        BasicHttpProcessor r0 = (BasicHttpProcessor) super.clone();
        copyInterceptors(r0);
        return r0;
    }
}
