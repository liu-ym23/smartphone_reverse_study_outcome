package com.ttnet.org.chromium.net;

import java.io.IOException;
import java.io.InputStream;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;

/* JADX INFO: loaded from: classes3.dex */
public final class ChromiumNetworkAdapter {
    private ChromiumNetworkAdapter() {
    }

    public static URLConnection openConnection(URL r0, NetworkTrafficAnnotationTag r1) throws IOException {
        return r0.openConnection();
    }

    public static URLConnection openConnection(URL r0, Proxy r1, NetworkTrafficAnnotationTag r2) throws IOException {
        return r0.openConnection(r1);
    }

    public static InputStream openStream(URL r0, NetworkTrafficAnnotationTag r1) throws IOException {
        return r0.openStream();
    }
}
