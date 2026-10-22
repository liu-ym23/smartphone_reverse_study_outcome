package com.monitor.cloudmessage.utils;

/* JADX INFO: loaded from: classes4.dex */
public class DecodeUtils {
    public DecodeUtils() {
    }

    public static String decodeData(byte[] r1) {
        return com.bytedance.apm.util.DecodeUtils.decodeCloudData(r1, "");
    }

    public static String decodeData(byte[] r0, String r1) {
        return com.bytedance.apm.util.DecodeUtils.decodeCloudData(r0, r1);
    }
}
