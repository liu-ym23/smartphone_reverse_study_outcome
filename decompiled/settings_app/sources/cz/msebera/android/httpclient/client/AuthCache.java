package cz.msebera.android.httpclient.client;

import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.auth.AuthScheme;

/* JADX INFO: loaded from: classes5.dex */
public interface AuthCache {
    void clear();

    AuthScheme get(HttpHost r1);

    void put(HttpHost r1, AuthScheme r2);

    void remove(HttpHost r1);
}
