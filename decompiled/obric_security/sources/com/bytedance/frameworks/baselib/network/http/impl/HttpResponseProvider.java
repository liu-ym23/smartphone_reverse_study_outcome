package com.bytedance.frameworks.baselib.network.http.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface HttpResponseProvider {
    long contentLength();

    String contentType();

    InputStream errorStream();

    boolean fromCache();

    InputStream inputStream() throws IOException;

    boolean isGzip();

    int responseCode();

    String responseHeaderValue(String r1);

    Map<String, List<String>> responseHeaders();

    String responseMessage() throws IOException;

    void safeClose();
}
