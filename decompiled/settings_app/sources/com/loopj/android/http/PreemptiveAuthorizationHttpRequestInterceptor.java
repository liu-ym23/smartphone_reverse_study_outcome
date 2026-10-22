package com.loopj.android.http;

import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpRequestInterceptor;
import cz.msebera.android.httpclient.auth.AuthScope;
import cz.msebera.android.httpclient.auth.AuthState;
import cz.msebera.android.httpclient.auth.Credentials;
import cz.msebera.android.httpclient.client.CredentialsProvider;
import cz.msebera.android.httpclient.impl.auth.BasicScheme;
import cz.msebera.android.httpclient.protocol.HttpContext;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public class PreemptiveAuthorizationHttpRequestInterceptor implements HttpRequestInterceptor {
    public PreemptiveAuthorizationHttpRequestInterceptor() {
    }

    @Override // cz.msebera.android.httpclient.HttpRequestInterceptor
    public void process(HttpRequest r3, HttpContext r4) throws HttpException, IOException {
        AuthState r2 = (AuthState) r4.getAttribute("http.auth.target-scope");
        CredentialsProvider r5 = (CredentialsProvider) r4.getAttribute("http.auth.credentials-provider");
        HttpHost r6 = (HttpHost) r4.getAttribute("http.target_host");
        if (r2.getAuthScheme() != null) goto L8;
        Credentials r7 = r5.getCredentials(new AuthScope(r6.getHostName(), r6.getPort()));
        if (r7 == null) goto L9;
        r2.setAuthScheme(new BasicScheme());
        r2.setCredentials(r7);
        return;
    L9:
        return;
    }
}
