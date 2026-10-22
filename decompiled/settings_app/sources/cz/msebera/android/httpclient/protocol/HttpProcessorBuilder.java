package cz.msebera.android.httpclient.protocol;

import cz.msebera.android.httpclient.HttpRequestInterceptor;
import cz.msebera.android.httpclient.HttpResponseInterceptor;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes5.dex */
public class HttpProcessorBuilder {
    private ChainBuilder<HttpRequestInterceptor> requestChainBuilder;
    private ChainBuilder<HttpResponseInterceptor> responseChainBuilder;

    public static HttpProcessorBuilder create() {
        return new HttpProcessorBuilder();
    }

    HttpProcessorBuilder() {
    }

    private ChainBuilder<HttpRequestInterceptor> getRequestChainBuilder() {
        if (this.requestChainBuilder != null) goto L6;
        this.requestChainBuilder = new ChainBuilder();
    L6:
        return this.requestChainBuilder;
    }

    private ChainBuilder<HttpResponseInterceptor> getResponseChainBuilder() {
        if (this.responseChainBuilder != null) goto L6;
        this.responseChainBuilder = new ChainBuilder();
    L6:
        return this.responseChainBuilder;
    }

    public HttpProcessorBuilder addFirst(HttpRequestInterceptor r2) {
        if (r2 != null) goto L4;
        return this;
    L4:
        getRequestChainBuilder().addFirst(r2);
        return this;
    }

    public HttpProcessorBuilder addLast(HttpRequestInterceptor r2) {
        if (r2 != null) goto L4;
        return this;
    L4:
        getRequestChainBuilder().addLast(r2);
        return this;
    }

    public HttpProcessorBuilder add(HttpRequestInterceptor r1) {
        return addLast(r1);
    }

    public HttpProcessorBuilder addAllFirst(HttpRequestInterceptor... r2) {
        if (r2 != null) goto L4;
        return this;
    L4:
        getRequestChainBuilder().addAllFirst(r2);
        return this;
    }

    public HttpProcessorBuilder addAllLast(HttpRequestInterceptor... r2) {
        if (r2 != null) goto L4;
        return this;
    L4:
        getRequestChainBuilder().addAllLast(r2);
        return this;
    }

    public HttpProcessorBuilder addAll(HttpRequestInterceptor... r1) {
        return addAllLast(r1);
    }

    public HttpProcessorBuilder addFirst(HttpResponseInterceptor r2) {
        if (r2 != null) goto L4;
        return this;
    L4:
        getResponseChainBuilder().addFirst(r2);
        return this;
    }

    public HttpProcessorBuilder addLast(HttpResponseInterceptor r2) {
        if (r2 != null) goto L4;
        return this;
    L4:
        getResponseChainBuilder().addLast(r2);
        return this;
    }

    public HttpProcessorBuilder add(HttpResponseInterceptor r1) {
        return addLast(r1);
    }

    public HttpProcessorBuilder addAllFirst(HttpResponseInterceptor... r2) {
        if (r2 != null) goto L4;
        return this;
    L4:
        getResponseChainBuilder().addAllFirst(r2);
        return this;
    }

    public HttpProcessorBuilder addAllLast(HttpResponseInterceptor... r2) {
        if (r2 != null) goto L4;
        return this;
    L4:
        getResponseChainBuilder().addAllLast(r2);
        return this;
    }

    public HttpProcessorBuilder addAll(HttpResponseInterceptor... r1) {
        return addAllLast(r1);
    }

    public HttpProcessor build() {
        ChainBuilder<HttpRequestInterceptor> r1 = this.requestChainBuilder;
        LinkedList<HttpResponseInterceptor> r2 = null;
        if (r1 == null) goto L5;
        LinkedList<HttpRequestInterceptor> r3 = r1.build();
    L6:
        ChainBuilder<HttpResponseInterceptor> r4 = this.responseChainBuilder;
        if (r4 == null) goto L10;
        r2 = r4.build();
    L10:
        return new ImmutableHttpProcessor(r3, r2);
    L5:
        r3 = null;
        goto L6
    }
}
