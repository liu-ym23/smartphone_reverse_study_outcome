package com.bytedance.bdinstall;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.bdinstall.util.LocalConstants;
import java.util.UUID;

/* JADX INFO: loaded from: classes3.dex */
public final class Cdid {
    public static final String KEY_CDID = "cdid";
    private static final String KEY_MIGRATE = "cdid_migrate";
    private static volatile String cdid;

    static {
    }

    static /* synthetic */ String access$002(String r0) {
        cdid = r0;
        return r0;
    }

    private Cdid() {
    }

    public static String get(Context r3) {
        if (cdid != null) goto L18;
        monitor-enter(Cdid.class);
    L14:
        th = move-exception;
        throw th;
    L7:
        if (cdid == null) goto L9;
    L12:
        monitor-exit(Cdid.class);     // Catch: Throwable -> L14
        goto L18
    L9:
        if (Utils.isMainProcess(r3) == false) goto L11;
        cdid = getCdidLocked(r3);     // Catch: Throwable -> L14
        SubpSyncManager.inst(r3).sendSubpEvent(KEY_CDID, cdid);     // Catch: Throwable -> L14
        goto L12
    L11:
        cdid = getCdidWithChildProcess(r3);     // Catch: Throwable -> L14
    L18:
        return cdid;
    }

    private static String getCdidWithChildProcess(Context r2) {
        SubpSyncManager.inst(r2).observer(KEY_CDID, new AnonymousClass1());
        return cdid;
    }

    private static String getCdidLocked(Context r5) {
        SharedPreferences r0 = LocalConstants.getCommonSp(r5);
        String r3 = r0.getString(KEY_CDID, null);
        if (TextUtils.isEmpty(r3) == false) goto L9;
        SharedPreferences r6 = r5.getSharedPreferences(LocalConstants.getOldSpName(), 0);
        String r2 = r6.getString(KEY_CDID, null);
        if (TextUtils.isEmpty(r2) == false) goto L7;
        r2 = UUID.randomUUID().toString();
    L7:
        String r4 = r2;
        r6.edit().putString(KEY_CDID, r4).apply();
        r0.edit().putString(KEY_CDID, r4).putBoolean(KEY_MIGRATE, true).apply();
        return r4;
    L9:
        return r3;
    }

    public static void clearCdid(Context r3) {
        cdid = null;
        LocalConstants.getCommonSp(r3).edit().remove(KEY_CDID).apply();
        SharedPreferences r4 = r3.getSharedPreferences(LocalConstants.getOldSpName(), 0);
        if (r4.contains(KEY_CDID) == false) goto L6;
        r4.edit().remove(KEY_CDID).apply();
        return;
    }
}
