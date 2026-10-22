package com.bytedance.article.common.monitor.file;

import android.text.TextUtils;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class FileUploadManager {
    private static ConcurrentHashMap<String, IFileUploadCallBack> sAllFileUploadCallBack;

    static {
        sAllFileUploadCallBack = new ConcurrentHashMap();
    }

    public FileUploadManager() {
    }

    public static IFileUploadCallBack getFileCallBackForType(String r1) {
        if (TextUtils.isEmpty(r1) == true) goto L7;
        return sAllFileUploadCallBack.get(r1);
    L7:
        throw new IllegalArgumentException("type must not be null");
    }

    public static void registerFileCallBack(String r1, IFileUploadCallBack r2) {
        if (TextUtils.isEmpty(r1) == true) goto L10;
        if (r2 == null) goto L10;
        if (sAllFileUploadCallBack.containsKey(r1) == true) goto L11;
        sAllFileUploadCallBack.put(r1, r2);
        return;
    L11:
        return;
    L10:
        throw new IllegalArgumentException("type not be null or callback not be null");
    }

    public static void unRegisterFileCallBack(String r1) {
        if (TextUtils.isEmpty(r1) == true) goto L7;
        sAllFileUploadCallBack.remove(r1);
        return;
    L7:
        throw new IllegalArgumentException("type must not be null");
    }

    public static void registerFileCallBack(String r0, IFileUploadConfigCallback r1) {
        registerFileCallBack(r0, r1);
    }
}
