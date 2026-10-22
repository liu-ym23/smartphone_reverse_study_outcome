package com.bytedance.framwork.core.sdkmonitor;

import android.content.Context;
import com.bytedance.framwork.core.sdklib.util.ProcessUtils;
import com.bytedance.librarian.LibrarianImpl;

/* JADX INFO: loaded from: classes.dex */
public class MonitorHelper {
    private static String sProcessName;
    private static String sShortProcessName;

    public MonitorHelper() {
    }

    public static String getProcessName(Context r1) {
        if (sProcessName != null) goto L6;
        sProcessName = ProcessUtils.getCurProcessName(r1);
    L6:
        return sProcessName;
    }

    public static String getShortProcessName(Context r2) {
        if (sShortProcessName != null) goto L6;
        String r3 = ProcessUtils.getCurProcessName(r2).replace(r2.getPackageName(), "p").replace(":", "_");
        sShortProcessName = r3;
        sShortProcessName = r3.replace(LibrarianImpl.Constants.DOT, "_");
    L6:
        return sShortProcessName;
    }
}
