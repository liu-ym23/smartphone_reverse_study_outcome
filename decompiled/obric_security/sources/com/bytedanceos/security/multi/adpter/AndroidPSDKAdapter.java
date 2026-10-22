package com.bytedanceos.security.multi.adpter;

import android.app.AppOpsManager;
import com.bytedanceos.security.reflect.OpsManagerHelper;
import com.bytedanceos.security.reflect.ReflectHelper;

/* JADX INFO: loaded from: classes2.dex */
public class AndroidPSDKAdapter extends SDKAdapter {
    public static final String TAG = "AndroidPSDKAdapter";

    public AndroidPSDKAdapter() {
    }

    public static int checkAppOp(AppOpsManager appOpsManager, String op, int uid, String packageName) {
        int r0 = OpsManagerHelper.get_MODE_INVALID();
        if (appOpsManager != null) goto L5;
        return r0;
    L5:
        Object r7 = ReflectHelper.invokeMethod(appOpsManager, "unsafeCheckOpRaw", new Class[]{String.class, Integer.TYPE, String.class}, new Object[]{op, Integer.valueOf(uid), packageName});
        if (r7 != null) goto L8;
        return r0;
    L8:
        return ((Integer) r7).intValue();
    }
}
