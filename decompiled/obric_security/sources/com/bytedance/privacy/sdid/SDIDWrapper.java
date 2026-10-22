package com.bytedance.privacy.sdid;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public class SDIDWrapper {
    private static final String KEY_CODE = "errCode";
    private static final String KEY_MSG = "errMsg";
    private static final String KEY_OAID = "oaid";
    private static final String KEY_UDID = "udid";
    private static final String METHOD_GET_OAID = "get_oaid";
    private static final String METHOD_GET_UDID = "get_udid";
    private static final Uri OAID_URI = null;
    private static final String TAG = "SDIDWrapper";
    private static final Uri UDID_URI = null;

    public SDIDWrapper() {
    }

    static {
        OAID_URI = Uri.parse("content://com.bytedance.securityserver.oaidprovider");
        UDID_URI = Uri.parse("content://com.bytedance.securityserver.udidprovider");
    }

    public static String getOAID(Context r4) throws SDIDException {
        Bundle r5 = callProvider(r4, OAID_URI, METHOD_GET_OAID);
        int r0 = r5.getInt(KEY_CODE, -1000);
        if (r0 != 0) goto L7;
        return r5.getString("oaid", "");
    L7:
        throw new SDIDException(r0, r5.getString(KEY_MSG, "Unknown error"));
    }

    public static String getUDID(Context r4) throws SDIDException {
        Bundle r5 = callProvider(r4, UDID_URI, METHOD_GET_UDID);
        int r0 = r5.getInt(KEY_CODE, -1000);
        if (r0 != 0) goto L7;
        return r5.getString(KEY_UDID, "");
    L7:
        throw new SDIDException(r0, r5.getString(KEY_MSG, "Unknown error"));
    }

    private static Bundle callProvider(Context r1, Uri r2, String r3) throws SDIDException {
        Bundle r4 = r1.getContentResolver().call(r2, r3, null, null);     // Catch: Exception -> L7 SecurityException -> L10
        if (r4 == null) goto L6;
        return r4;
    L6:
        throw new SDIDException(-100, "Provider returned null");     // Catch: Exception -> L7 SecurityException -> L10
    L10:
        e = move-exception;
        throw new SDIDException(-1, "Permission denied: " + e.getMessage());
    L7:
        e = move-exception;
        throw new SDIDException(-1000, "Unexpected error: " + e.getMessage());
    }
}
