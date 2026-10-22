package com.bytedance.bdinstall.util;

/* JADX INFO: loaded from: classes3.dex */
public class RequestIdGenerator {
    private static Singleton<String> requestIdSingleTon;

    public RequestIdGenerator() {
    }

    static {
        requestIdSingleTon = createReqIdSingleton();
    }

    private static Singleton<String> createReqIdSingleton() {
        return new AnonymousClass1();
    }

    public static String getRequestId() {
        return requestIdSingleTon.get(new Object[0]);
    }

    public static void clearReqId() {
        requestIdSingleTon = createReqIdSingleton();
    }
}
