package com.bytedance.ttnet.cronet;

import com.bytedance.common.utility.Logger;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

/* JADX INFO: loaded from: classes.dex */
public class CronetDataStorageAccess extends Observable {
    public static final String LOGID = "logid";
    public static final String REGION_LEGACY_USER = "region_legacy_user";
    public static final String REGION_SOURCE = "region_source";
    public static final String SEC_UID = "sec_uid";
    public static final String STORE_IDC = "store_idc";
    public static final String STORE_REGION = "store_region";
    private static final String TAG = "CronetDataStorageAccess";
    private static volatile CronetDataStorageAccess sInstance = null;
    private static volatile String sRegionLegacyUser = "";
    private static volatile String sRegionSource = "";
    private static volatile String sSecUid = "";
    private static volatile String sUserIdc = "";
    private static volatile String sUserRegion = "";

    public CronetDataStorageAccess() {
    }

    public static String getRegionLegacyUser() {
        return sRegionLegacyUser;
    }

    public static String getRegionSource() {
        return sRegionSource;
    }

    public static String getSecUid() {
        return sSecUid;
    }

    public static String getUserIdc() {
        return sUserIdc;
    }

    public static String getUserRegion() {
        return sUserRegion;
    }

    public static CronetDataStorageAccess inst() {
        if (sInstance != null) goto L16;
        monitor-enter(CronetDataStorageAccess.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L11;
        sInstance = new CronetDataStorageAccess();     // Catch: Throwable -> L9
    L11:
        monitor-exit(CronetDataStorageAccess.class);     // Catch: Throwable -> L9
    L16:
        return sInstance;
    }

    private void notifyCronetDataObservers(Map<String, Object> r1) {
        setChanged();
        notifyObservers(r1);
    }

    public void onStoreIdcChanged(String r3, String r4, String r5, String r6, String r7, String r8) {
        if (Logger.debug() == false) goto L5;
        Logger.d(TAG, "onStoreIdcChanged idc: " + r3 + " region: " + r4 + " source: " + r5 + " sec_uid:" + r7 + " logid:" + r8);
    L5:
        sUserIdc = r3;
        sUserRegion = r4;
        sRegionSource = r5;
        sRegionLegacyUser = r6;
        sSecUid = r7;
        HashMap r0 = new HashMap();
        r0.put(STORE_IDC, r3);
        r0.put(STORE_REGION, r4);
        r0.put(REGION_SOURCE, r5);
        r0.put(REGION_LEGACY_USER, r6);
        r0.put(SEC_UID, r7);
        r0.put(LOGID, r8);
        notifyCronetDataObservers(r0);
    }
}
