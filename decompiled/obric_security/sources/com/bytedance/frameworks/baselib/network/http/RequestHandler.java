package com.bytedance.frameworks.baselib.network.http;

import java.net.URI;

/* JADX INFO: loaded from: classes.dex */
public interface RequestHandler {
    void abort();

    URI getURI();
}
