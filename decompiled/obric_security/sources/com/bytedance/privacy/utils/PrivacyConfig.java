package com.bytedance.privacy.utils;

/* JADX INFO: loaded from: classes.dex */
public class PrivacyConfig {
    private static final boolean DEBUG_SWITCH = false;
    private static volatile boolean FORCE_FETCH_ID_ATTEST = false;
    private static volatile boolean FORCE_FETCH_PSEUDO_ID = false;
    public static final int idAttestation = 2;
    public static final int pseudoId = 1;

    static {
    }

    public static boolean isDebug() {
        return false;
    }

    public PrivacyConfig() {
    }

    public static void setForceFetchFromCloud(int r1, boolean r2) {
        if (r1 != 1) goto L5;
        FORCE_FETCH_PSEUDO_ID = r2;
        return;
    L5:
        if (r1 != 2) goto L11;
        FORCE_FETCH_ID_ATTEST = r2;
        return;
    }

    public static boolean isForceFetchFromCloud(int r1) {
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L9;
        return false;
    L9:
        return FORCE_FETCH_ID_ATTEST;
    L11:
        return FORCE_FETCH_PSEUDO_ID;
    }
}
