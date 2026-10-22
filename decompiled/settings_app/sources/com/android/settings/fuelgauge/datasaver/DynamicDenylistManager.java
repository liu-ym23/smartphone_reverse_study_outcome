package com.android.settings.fuelgauge.datasaver;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.NetworkPolicyManager;
import android.util.ArraySet;
import com.obric.olog.OLog;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class DynamicDenylistManager {
    private static final String PREF_KEY_DYNAMIC_DENY = "dynamic_denylist_preference";
    private static final String PREF_KEY_MANUAL_DENY = "manual_denylist_preference";
    static final String PREF_KEY_MANUAL_DENYLIST_SYNCED = "manual_denylist_synced";
    private static final String TAG = "DynamicDenylistManager";
    public static DynamicDenylistManager sInstance;
    private final Context mContext;
    private final Object mLock;
    private final NetworkPolicyManager mNetworkPolicyManager;

    static {
    }

    public static DynamicDenylistManager getInstance(Context r3) {
        monitor-enter(DynamicDenylistManager.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sInstance != null) goto L7;
        sInstance = new DynamicDenylistManager(r3, NetworkPolicyManager.from(r3));     // Catch: Throwable -> L10
    L7:
        DynamicDenylistManager r4 = sInstance;     // Catch: Throwable -> L10
        monitor-exit(DynamicDenylistManager.class);     // Catch: Throwable -> L10
        return r4;
    }

    DynamicDenylistManager(Context r2, NetworkPolicyManager r3) {
        this.mLock = new Object();
        this.mContext = r2.getApplicationContext();
        this.mNetworkPolicyManager = r3;
        syncPolicyIfNeeded();
    }

    private void syncPolicyIfNeeded() {
        if (getManualDenylistPref().contains(PREF_KEY_MANUAL_DENYLIST_SYNCED) == false) goto L6;
        OLog.i(TAG, "syncPolicyIfNeeded() ignore synced manual denylist");
        return;
    L6:
        SharedPreferences.Editor r0 = getManualDenylistPref().edit();
        int[] r7 = this.mNetworkPolicyManager.getUidsWithPolicy(1);
        if (r7 != null) goto L9;
    L13:
        r0.putInt(PREF_KEY_MANUAL_DENYLIST_SYNCED, 0).apply();
        return;
    L9:
        if (r7.length == 0) goto L13;
        int r4 = r7.length;
        int r5 = 0;
    L11:
        if (r5 >= r4) goto L13;
        r0.putInt(String.valueOf(r7[r5]), 1);
        r5 = r5 + 1;
        goto L11
    }

    public void setUidPolicyLocked(int r4, int r5) {
        OLog.i(TAG, "setUidPolicyLocked: uid=" + r4 + " policy=" + r5);
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mNetworkPolicyManager.setUidPolicy(r4, r5);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        updateDenylistPref(r4, r5);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void setDenylist(Set<Integer> r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        r10.removeAll(getDenylistAllUids(getManualDenylistPref()));
        Set<Integer> r0 = getDenylistAllUids(getDynamicDenylistPref());
        if (r0.equals(r10) == false) goto L8;
        OLog.i(TAG, "setDenylist() ignore the same denylist with size: " + r0.size());
        return;
    L8:
        final ArraySet r1 = new ArraySet();
        Object r2 = this.mLock;
        monitor-enter(r2);
        Iterator<Integer> r3 = r10.iterator();     // Catch: Throwable -> L34
    L12:
        if (r3.hasNext() == false) goto L22;
        Integer r4 = r3.next();     // Catch: Throwable -> L34
        if (r4 == null) goto L12;
        int r5 = r4.intValue();     // Catch: Throwable -> L34
        if (r0.contains(Integer.valueOf(r5)) == true) goto L12;
        this.mNetworkPolicyManager.setUidPolicy(r5, 1);     // Catch: Exception -> L20 Throwable -> L34
    L20:
        e = move-exception;
        OLog.e(TAG, "failed to setUidPolicy(REJECT) for " + r5, e);     // Catch: Throwable -> L34
        r1.add(Integer.valueOf(r5));     // Catch: Throwable -> L34
        goto L12
    L22:
        Iterator<Integer> r6 = r0.iterator();     // Catch: Throwable -> L34
    L24:
        if (r6.hasNext() == false) goto L31;
        int r7 = r6.next().intValue();     // Catch: Throwable -> L34
        if (r10.contains(Integer.valueOf(r7)) == true) goto L24;
        this.mNetworkPolicyManager.setUidPolicy(r7, 0);     // Catch: Exception -> L29 Throwable -> L34
    L29:
        e = move-exception;
        OLog.e(TAG, "failed to setUidPolicy(NONE) for " + r7, e);     // Catch: Throwable -> L34
        goto L24
    L31:
        monitor-exit(r2);     // Catch: Throwable -> L34
        final SharedPreferences.Editor r9 = getDynamicDenylistPref().edit();
        r9.clear();
        r10.forEach(new DynamicDenylistManager$$ExternalSyntheticLambda2(r1, r9));
        r9.apply();
        return;
    L34:
        th = move-exception;
        throw th;
    }

    static /* synthetic */ void lambda$setDenylist$0(ArraySet r0, SharedPreferences.Editor r1, Integer r2) {
        if (r0.contains(r2) == true) goto L6;
        r1.putInt(String.valueOf(r2), 1);
        return;
    }

    public boolean isInManualDenylist(int r1) {
        return getManualDenylistPref().contains(String.valueOf(r1));
    }

    public void resetDenylistIfNeeded(String r7, boolean r8) {
        if (r8 == false) goto L5;
    L8:
        Object r9 = this.mLock;
        monitor-enter(r9);
        int[] r10 = this.mNetworkPolicyManager.getUidsWithPolicy(1);     // Catch: Throwable -> L24
        if (r10 != null) goto L13;
    L20:
        OLog.w(TAG, "resetDenylistIfNeeded: there is no valid UIDs");     // Catch: Throwable -> L24
    L21:
        monitor-exit(r9);     // Catch: Throwable -> L24
        clearSharedPreferences();
        return;
    L13:
        if (r10.length == 0) goto L20;
        OLog.i(TAG, "resetDenylistIfNeeded: " + Arrays.toString(r10));     // Catch: Throwable -> L24
        int r0 = r10.length;     // Catch: Throwable -> L24
        int r2 = 0;
    L15:
        if (r2 >= r0) goto L21;
        int r3 = r10[r2];     // Catch: Throwable -> L24
        if (getDenylistAllUids(getManualDenylistPref()).contains(Integer.valueOf(r3)) == true) goto L19;
        this.mNetworkPolicyManager.setUidPolicy(r3, 0);     // Catch: Throwable -> L24
    L19:
        r2 = r2 + 1;     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        throw th;
    L5:
        if ("com.android.settings".equals(r7) == true) goto L8;
        OLog.w(TAG, "resetDenylistIfNeeded: invalid conditions");
    }

    public void onBootComplete() {
        resetDenylistIfNeeded(null, true);
        syncPolicyIfNeeded();
    }

    public void dump(final PrintWriter r3) {
        r3.println("Dump of DynamicDenylistManager:");
        List<String> r0 = getPackageNames(this.mContext, getDenylistAllUids(getManualDenylistPref()));
        r3.println("\tManualDenylist:");
        if (r0 == null) goto L5;
        r0.forEach(new DynamicDenylistManager$$ExternalSyntheticLambda0(r3));
        r3.flush();
    L5:
        List<String> r2 = getPackageNames(this.mContext, getDenylistAllUids(getDynamicDenylistPref()));
        r3.println("\tDynamicDenylist:");
        if (r2 == null) goto L9;
        r2.forEach(new DynamicDenylistManager$$ExternalSyntheticLambda1(r3));
        r3.flush();
        return;
    }

    static /* synthetic */ void lambda$dump$1(PrintWriter r2, String r3) {
        r2.println("\t\t" + r3);
    }

    static /* synthetic */ void lambda$dump$2(PrintWriter r2, String r3) {
        r2.println("\t\t" + r3);
    }

    private Set<Integer> getDenylistAllUids(SharedPreferences r4) {
        ArraySet r3 = new ArraySet();
        Iterator<String> r5 = r4.getAll().keySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L11;
        String r0 = r5.next();
        if (PREF_KEY_MANUAL_DENYLIST_SYNCED.equals(r0) == true) goto L4;
        r3.add(Integer.valueOf(Integer.parseInt(r0)));     // Catch: NumberFormatException -> L10
    L10:
        OLog.e(TAG, "getDenylistAllUids() unexpected format for " + r0);
        goto L4
    L11:
        return r3;
    }

    void updateDenylistPref(int r2, int r3) {
        String r4 = String.valueOf(r2);
        if (r3 == 1) goto L5;
        getManualDenylistPref().edit().remove(r4).apply();
    L6:
        getDynamicDenylistPref().edit().remove(r4).apply();
        return;
    L5:
        getManualDenylistPref().edit().putInt(r4, r3).apply();
        goto L6
    }

    void clearSharedPreferences() {
        OLog.i(TAG, "clearSharedPreferences()");
        getManualDenylistPref().edit().clear().apply();
        getDynamicDenylistPref().edit().clear().apply();
    }

    SharedPreferences getManualDenylistPref() {
        return this.mContext.getSharedPreferences(PREF_KEY_MANUAL_DENY, 0);
    }

    SharedPreferences getDynamicDenylistPref() {
        return this.mContext.getSharedPreferences(PREF_KEY_DYNAMIC_DENY, 0);
    }

    private static List<String> getPackageNames(Context r2, Set<Integer> r3) {
        if (r3 != null) goto L4;
        return null;
    L4:
        if (r3.isEmpty() == true) goto L10;
        final PackageManager r4 = r2.getPackageManager();
        final ArrayList r0 = new ArrayList(r3.size());
        r3.forEach(new DynamicDenylistManager$$ExternalSyntheticLambda3(r0, r4));
        return r0;
    L10:
        return null;
    }

    static /* synthetic */ void lambda$getPackageNames$3(List r0, PackageManager r1, Integer r2) {
        r0.add(r1.getNameForUid(r2.intValue()));
    }
}
