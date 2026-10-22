package com.bytedance.frameworks.baselib.network.http.impl;

import java.io.InputStream;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public interface HttpResponseProvider {
    long contentLength();

    @Nullable
    String contentType();

    @Nullable
    InputStream errorStream();

    boolean fromCache();

    @Nullable
    InputStream inputStream();

    boolean isGzip();

    int responseCode();

    @Nullable
    String responseHeaderValue(String r1);

    @Nullable
    Map<String, List<String>> responseHeaders();

    String responseMessage();

    void safeClose();
}
