package com.bytedanceos.securitycenter;

import android.content.SharedPreferences;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes2.dex */
public class SharedPreferUtil {
    public SharedPreferUtil() {
    }

    public static void commitAsynchronously(final SharedPreferences.Editor editor) {
        if (editor != null) goto L4;
        return;
    L4:
        ExecutorService r0 = SecurityCenterApplication.getApplication().getSharedPrefExecutorService();
        if (r0 == null) goto L8;
        r0.submit(new AnonymousClass1(editor));
        return;
    }
}
