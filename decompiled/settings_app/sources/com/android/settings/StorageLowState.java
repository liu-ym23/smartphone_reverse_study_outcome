package com.android.settings;

import android.content.Context;
import android.content.IntentFilter;
import com.GlobalProxyLancet;

/* JADX INFO: loaded from: classes2.dex */
public final class StorageLowState {
    private static LowStorageHandler sHandler = null;
    private static boolean sIsStorageLow = false;

    public interface LowStorageHandler {
        void onStorageLow();

        void onStorageOk();
    }

    static {
    }

    private StorageLowState() {
    }

    public static boolean checkStorageLowMode(Context r3) {
        if (GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(r3, null, new IntentFilter("android.intent.action.DEVICE_STORAGE_LOW"), 2) == null) goto L5;
        boolean r4 = true;
    L6:
        setIsStorageLow(r4);
        return sIsStorageLow;
    L5:
        r4 = false;
        goto L6
    }

    public static void setIsStorageLow(boolean r1) {
        if (sIsStorageLow != r1) goto L5;
        return;
    L5:
        sIsStorageLow = r1;
        LowStorageHandler r0 = sHandler;
        if (r0 != null) goto L8;
        return;
    L8:
        if (r1 == false) goto L10;
        r0.onStorageLow();
        return;
    L10:
        r0.onStorageOk();
    }

    public static void registerHandler(LowStorageHandler r1) {
        sHandler = r1;
        if (sIsStorageLow == false) goto L6;
        r1.onStorageLow();
        return;
    }
}
