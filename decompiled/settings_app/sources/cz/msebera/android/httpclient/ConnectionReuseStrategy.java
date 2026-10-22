package cz.msebera.android.httpclient;

import cz.msebera.android.httpclient.protocol.HttpContext;

/* JADX INFO: loaded from: classes5.dex */
public interface ConnectionReuseStrategy {
    boolean keepAlive(HttpResponse r1, HttpContext r2);
}
