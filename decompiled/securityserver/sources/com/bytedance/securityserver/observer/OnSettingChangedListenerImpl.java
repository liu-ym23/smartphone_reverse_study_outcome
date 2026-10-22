package com.bytedance.securityserver.observer;

import android.text.TextUtils;
import android.util.Log;
import com.bytedance.securityserver.sdid.OAIDManager;

/* JADX INFO: loaded from: classes.dex */
public class OnSettingChangedListenerImpl implements OnSettingChangedListener {
    @Override // com.bytedance.securityserver.observer.OnSettingChangedListener
    public final void a(String r4, String r5) {
        if (r4.equals("device_name") == false) goto L6;
        return;
    L6:
        if (r4.equals("enable_oaid") == true) goto L8;
        return;
    L8:
        if (TextUtils.equals(r5, "0") == false) goto L11;
    L9:
        boolean r3 = true;
    L14:
        OAIDManager r6 = OAIDManager.b();
        monitor-enter(r6);
    L21:
        th = move-exception;
        throw th;
    L17:
        if (r6.b != r3) goto L23;
        r6.f61a = true;     // Catch: Throwable -> L21
        Log.i("SecurityServer-OAIDManager", "OAID enabled state unchanged: " + r3);     // Catch: Throwable -> L21
        monitor-exit(r6);
    L29:
        return;
    L23:
        r6.b = r3;     // Catch: Throwable -> L21
        r6.f61a = true;     // Catch: Throwable -> L21
        Log.i("SecurityServer-OAIDManager", "OAID enabled state updated: " + r3);     // Catch: Throwable -> L21
        monitor-exit(r6);
        goto L29
    L11:
        if (TextUtils.equals(r5, "1") == false) goto L13;
        r3 = false;
        goto L14
    L13:
        Log.e("SecurityServer-OnSettingChangedListenerImpl", "Unknown OAID setting value: " + r5 + ", defaulting to enabled");
        goto L9
    }
}
