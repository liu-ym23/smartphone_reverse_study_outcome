package cz.msebera.android.httpclient.auth;

import cz.msebera.android.httpclient.protocol.HttpContext;

/* JADX INFO: loaded from: classes5.dex */
public interface AuthSchemeProvider {
    AuthScheme create(HttpContext r1);
}
