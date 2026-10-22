package cz.msebera.android.httpclient.client;

import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.client.methods.HttpUriRequest;
import cz.msebera.android.httpclient.conn.ClientConnectionManager;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.protocol.HttpContext;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public interface HttpClient {
    HttpResponse execute(HttpHost r1, HttpRequest r2) throws IOException, ClientProtocolException;

    HttpResponse execute(HttpHost r1, HttpRequest r2, HttpContext r3) throws IOException, ClientProtocolException;

    HttpResponse execute(HttpUriRequest r1) throws IOException, ClientProtocolException;

    HttpResponse execute(HttpUriRequest r1, HttpContext r2) throws IOException, ClientProtocolException;

    <T> T execute(HttpHost r1, HttpRequest r2, ResponseHandler<? extends T> r3) throws IOException, ClientProtocolException;

    <T> T execute(HttpHost r1, HttpRequest r2, ResponseHandler<? extends T> r3, HttpContext r4) throws IOException, ClientProtocolException;

    <T> T execute(HttpUriRequest r1, ResponseHandler<? extends T> r2) throws IOException, ClientProtocolException;

    <T> T execute(HttpUriRequest r1, ResponseHandler<? extends T> r2, HttpContext r3) throws IOException, ClientProtocolException;

    @Deprecated
    ClientConnectionManager getConnectionManager();

    @Deprecated
    HttpParams getParams();
}
