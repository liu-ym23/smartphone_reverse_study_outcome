package com.android.settings.nfc;

import android.nfc.NfcAdapter;
import com.obric.olog.OLog;

/* JADX INFO: loaded from: classes2.dex */
public class NfcSettingsAdapterExt {
    public static final String TAG = "NfcSettingsAdapterExt";
    static NfcSettingsAdapterExt sInstance;
    static final Object sLock = null;
    private final NfcAdapter mNfcAdapter;

    static {
        sLock = new Object();
    }

    public static NfcSettingsAdapterExt getInstance(NfcAdapter r2) {
        Object r0 = sLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sInstance != null) goto L7;
        sInstance = new NfcSettingsAdapterExt(r2);     // Catch: Throwable -> L10
    L7:
        NfcSettingsAdapterExt r3 = sInstance;     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    }

    public NfcSettingsAdapterExt(NfcAdapter r1) {
        this.mNfcAdapter = r1;
    }

    public boolean setDefaultSEOption(int r7) {
        NfcAdapter r0 = this.mNfcAdapter;
        if (r0 != null) goto L10;
        return false;
    L10:
        r0.getClass().getMethod("setDefaultSEOption", new Class[]{Integer.TYPE}).invoke(this.mNfcAdapter, new Object[]{Integer.valueOf(r7)});     // Catch: Exception -> L7
        return true;
    L7:
        e = move-exception;
        OLog.e(TAG, "setDefaultSEOption Exception: ", e);
        return false;
    }

    public boolean isSimSupportNfc(int r7) {
        NfcAdapter r0 = this.mNfcAdapter;
        if (r0 != null) goto L10;
        return false;
    L10:
        return ((Boolean) r0.getClass().getMethod("isSimSupportsNfc", new Class[]{Integer.TYPE}).invoke(this.mNfcAdapter, new Object[]{Integer.valueOf(r7)})).booleanValue();
    L7:
        e = move-exception;
        OLog.e(TAG, "isSimSupportNfc Exception: ", e);
        return false;
    }

    public int getDefaultSEOption() {
        NfcAdapter r0 = this.mNfcAdapter;
        if (r0 != null) goto L10;
        return 0;
    L10:
        return ((Integer) r0.getClass().getMethod("getDefaultSEOption", new Class[0]).invoke(this.mNfcAdapter, new Object[0])).intValue();
    L7:
        e = move-exception;
        OLog.e(TAG, "getDefaultSEOption Exception: ", e);
        return 0;
    }
}
