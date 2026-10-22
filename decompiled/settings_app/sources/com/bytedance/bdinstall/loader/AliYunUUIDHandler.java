package com.bytedance.bdinstall.loader;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes3.dex */
public class AliYunUUIDHandler {
    private static volatile AliYunUUIDHandler sAliYunUUIDHandler;
    private String mCloudUUID;

    static {
    }

    private AliYunUUIDHandler() {
        if (isAliYunOs() == false) goto L8;
        String r0 = getCommonCloudUUID();
        this.mCloudUUID = r0;
        if (TextUtils.isEmpty(r0) == false) goto L9;
        this.mCloudUUID = getMeiZuCloudUUID();
        return;
    L9:
        return;
    }

    public static AliYunUUIDHandler inst() {
        if (sAliYunUUIDHandler != null) goto L15;
        monitor-enter(AliYunUUIDHandler.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sAliYunUUIDHandler != null) goto L9;
        sAliYunUUIDHandler = new AliYunUUIDHandler();     // Catch: Throwable -> L11
    L9:
        monitor-exit(AliYunUUIDHandler.class);     // Catch: Throwable -> L11
    L15:
        return sAliYunUUIDHandler;
    }

    public String getCloudUUID() {
        return this.mCloudUUID;
    }

    private static String getCommonCloudUUID() {
        return getSystemProperty("ro.aliyun.clouduuid", "false");
    }

    private static String getMeiZuCloudUUID() {
        return getSystemProperty("ro.sys.aliyun.clouduuid", "false");
    }

    private static String getSystemProperty(String r7, String r8) {
        return (String) Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class, String.class}).invoke(null, new Object[]{r7, r8});
    L4:
        return r8;
    }

    private static boolean isAliYunOs() {
        if (System.getProperty("java.vm.name") != null) goto L6;
    L7:
        if (System.getProperty("ro.yunos.version") != null) goto L16;
        return false;
    L16:
        return true;
    L6:
        if (System.getProperty("java.vm.name").toLowerCase().contains("lemur") == false) goto L7;
        return true;
    L17:
        return false;
    }
}
