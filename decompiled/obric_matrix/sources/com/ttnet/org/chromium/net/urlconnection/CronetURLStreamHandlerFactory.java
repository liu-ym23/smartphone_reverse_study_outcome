package com.ttnet.org.chromium.net.urlconnection;

import com.bytedance.bdlocation.client.LocationInfoConst;
import com.ttnet.org.chromium.net.ExperimentalCronetEngine;
import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class CronetURLStreamHandlerFactory implements URLStreamHandlerFactory {
    private final ExperimentalCronetEngine mCronetEngine;

    public CronetURLStreamHandlerFactory(ExperimentalCronetEngine r2) {
        Objects.requireNonNull(r2, "CronetEngine is null.");
        this.mCronetEngine = r2;
    }

    @Override // java.net.URLStreamHandlerFactory
    public URLStreamHandler createURLStreamHandler(String r2) {
        if ("http".equals(r2) == true) goto L10;
        if (LocationInfoConst.HTTPS.equals(r2) == true) goto L10;
        return null;
    L10:
        return new CronetHttpURLStreamHandler(this.mCronetEngine);
    }
}
