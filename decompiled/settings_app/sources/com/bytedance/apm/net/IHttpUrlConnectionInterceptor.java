package com.bytedance.apm.net;

import java.io.IOException;
import java.net.HttpURLConnection;

/* JADX INFO: loaded from: classes3.dex */
public interface IHttpUrlConnectionInterceptor {
    HttpURLConnection getUrlConnection(String r1) throws IOException;
}
