package cz.msebera.android.httpclient.impl.execchain;

import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.client.methods.CloseableHttpResponse;
import cz.msebera.android.httpclient.client.methods.HttpExecutionAware;
import cz.msebera.android.httpclient.client.methods.HttpRequestWrapper;
import cz.msebera.android.httpclient.client.protocol.HttpClientContext;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public interface ClientExecChain {
    CloseableHttpResponse execute(HttpRoute r1, HttpRequestWrapper r2, HttpClientContext r3, HttpExecutionAware r4) throws IOException, HttpException;
}
