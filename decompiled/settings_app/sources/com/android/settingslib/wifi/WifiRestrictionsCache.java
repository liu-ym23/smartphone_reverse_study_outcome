package com.android.settingslib.wifi;

import android.content.Context;
import android.os.Bundle;
import android.os.UserManager;
import android.util.SparseArray;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class WifiRestrictionsCache {
    private static final String TAG = "WifiResCache";
    protected static final SparseArray<WifiRestrictionsCache> sInstances = null;
    protected final Map<String, Boolean> mRestrictions;
    protected UserManager mUserManager;
    protected Bundle mUserRestrictions;

    static {
        sInstances = new SparseArray();
    }

    public static WifiRestrictionsCache getInstance(Context r3) {
        int r0 = r3.getUserId();
        SparseArray<WifiRestrictionsCache> r1 = sInstances;
        monitor-enter(r1);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (r1.indexOfKey(r0) < 0) goto L9;
        WifiRestrictionsCache r4 = r1.get(r0);     // Catch: Throwable -> L12
        monitor-exit(r1);     // Catch: Throwable -> L12
        return r4;
    L9:
        WifiRestrictionsCache r2 = new WifiRestrictionsCache(r3);     // Catch: Throwable -> L12
        r1.put(r3.getUserId(), r2);     // Catch: Throwable -> L12
        monitor-exit(r1);     // Catch: Throwable -> L12
        return r2;
    }

    public static void clearInstance() {
        SparseArray<WifiRestrictionsCache> r0 = sInstances;
        monitor-enter(r0);
        int r1 = 0;
    L14:
        SparseArray<WifiRestrictionsCache> r2 = sInstances;     // Catch: Throwable -> L11
        if (r1 >= r2.size()) goto L8;
        int r3 = r2.keyAt(r1);     // Catch: Throwable -> L11
        r2.get(r3).clearRestrictions();     // Catch: Throwable -> L11
        r2.remove(r3);     // Catch: Throwable -> L11
        r1 = r1 + 1;     // Catch: Throwable -> L11
        goto L14
    L8:
        r2.clear();     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    protected WifiRestrictionsCache(Context r2) {
        this.mRestrictions = new HashMap();
        UserManager r3 = (UserManager) r2.getSystemService(UserManager.class);
        this.mUserManager = r3;
        if (r3 == null) goto L6;
        this.mUserRestrictions = r3.getUserRestrictions();
        return;
    }

    public Boolean getRestriction(String r3) {
        if (this.mUserRestrictions == null) goto L5;
        Map<String, Boolean> r0 = this.mRestrictions;
        monitor-enter(r0);
    L16:
        th = move-exception;
        throw th;
    L9:
        if (this.mRestrictions.containsKey(r3) == false) goto L13;
        Boolean r2 = this.mRestrictions.get(r3);     // Catch: Throwable -> L16
        monitor-exit(r0);     // Catch: Throwable -> L16
        return r2;
    L13:
        Boolean r1 = Boolean.valueOf(this.mUserRestrictions.getBoolean(r3));     // Catch: Throwable -> L16
        this.mRestrictions.put(r3, r1);     // Catch: Throwable -> L16
        monitor-exit(r0);     // Catch: Throwable -> L16
        return r1;
    L5:
        return false;
    }

    public void clearRestrictions() {
        Map<String, Boolean> r0 = this.mRestrictions;
        monitor-enter(r0);
        this.mRestrictions.clear();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public Boolean isConfigWifiAllowed() {
        return Boolean.valueOf(!getRestriction("no_config_wifi").booleanValue());
    }
}
