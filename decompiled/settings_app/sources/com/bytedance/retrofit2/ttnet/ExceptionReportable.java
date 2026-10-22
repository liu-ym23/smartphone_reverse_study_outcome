package com.bytedance.retrofit2.ttnet;

/* JADX INFO: loaded from: classes3.dex */
public interface ExceptionReportable {
    default boolean shouldReport() {
        return false;
    }
}
