package com.bytedance.frameworks.baselib.network.http.cronet;

/* JADX INFO: loaded from: classes.dex */
public interface ICronetDepend {
    String getSsCookieKey();

    void loggerD(String r1, String r2);

    boolean loggerDebug();

    void setAdapter(ICronetDepend r1);
}
