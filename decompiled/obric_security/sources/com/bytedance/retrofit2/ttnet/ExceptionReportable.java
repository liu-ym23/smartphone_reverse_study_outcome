package com.bytedance.retrofit2.ttnet;

/* JADX INFO: loaded from: classes.dex */
public interface ExceptionReportable {
    default boolean shouldReport() {
        return false;
    }
}
