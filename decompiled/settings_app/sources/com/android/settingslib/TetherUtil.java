package com.android.settingslib;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.UserHandle;

/* JADX INFO: loaded from: classes.dex */
public class TetherUtil {
    public TetherUtil() {
    }

    public static boolean isTetherAvailable(Context r6) {
        ConnectivityManager r0 = (ConnectivityManager) r6.getSystemService(ConnectivityManager.class);
        if (RestrictedLockUtilsInternal.checkIfRestrictionEnforced(r6, "no_config_tethering", UserHandle.myUserId()) == null) goto L5;
        boolean r1 = true;
    L6:
        boolean r7 = RestrictedLockUtilsInternal.hasBaseUserRestriction(r6, "no_config_tethering", UserHandle.myUserId());
        if (r0.isTetheringSupported() == true) goto L9;
        if (r1 == true) goto L9;
    L12:
        return false;
    L9:
        if (r7 == true) goto L12;
        return true;
    L5:
        r1 = false;
        goto L6
    }
}
