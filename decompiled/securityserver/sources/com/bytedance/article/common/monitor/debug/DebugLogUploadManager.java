package com.bytedance.article.common.monitor.debug;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class DebugLogUploadManager {
    public DebugLogUploadManager() {
    }

    public static String formatLog(String r0) {
        return null;
    }

    public static IDebugLogUploadCallBack getFileUploadModuleForType(String r0) {
        return new AnonymousClass1();
    }

    public static boolean registerModule(String r0, IDebugLogUploadCallBack r1) {
        return true;
    }

    public static boolean unRegisterUploadContentModule(String r0) {
        return true;
    }
}
