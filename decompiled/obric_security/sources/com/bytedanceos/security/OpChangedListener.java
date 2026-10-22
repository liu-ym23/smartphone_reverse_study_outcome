package com.bytedanceos.security;

import android.app.SmtOpsManager;
import com.bytedanceos.security.reflect.OpsManagerHelper;
import com.bytedanceos.security.reflect.ReflectHelper;

/* JADX INFO: loaded from: classes2.dex */
public class OpChangedListener implements SmtOpsManager.OnOpChangedListener {
    public void onOpChanged(String op, String packageName) {
    }

    public OpChangedListener() {
    }

    public void startWatchingMode(int code, String packageName) {
        Class<?> r0 = OpsManagerHelper.getInstance().findOpChangedListener();
        if (r0 != null) goto L5;
        return;
    L5:
        ReflectHelper.invokeProxyMethod("android.app.SmtOpsManager", "startWatchingMode", OpsManagerHelper.getInstance().getManager(), new Class[]{Integer.TYPE, String.class, r0}, new Object[]{Integer.valueOf(code), packageName, this});
    }

    public void stopWatchingMode() {
        Class<?> r0 = OpsManagerHelper.getInstance().findOpChangedListener();
        if (r0 != null) goto L5;
        return;
    L5:
        ReflectHelper.invokeProxyMethod("android.app.SmtOpsManager", "stopWatchingMode", OpsManagerHelper.getInstance().getManager(), new Class[]{r0}, new Object[]{this});
    }
}
