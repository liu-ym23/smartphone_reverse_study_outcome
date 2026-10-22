package cz.msebera.android.httpclient.client;

import cz.msebera.android.httpclient.conn.routing.HttpRoute;

/* JADX INFO: loaded from: classes5.dex */
public interface BackoffManager {
    void backOff(HttpRoute r1);

    void probe(HttpRoute r1);
}
