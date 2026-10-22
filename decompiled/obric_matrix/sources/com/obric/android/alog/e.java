package com.obric.android.alog;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.os.EnvironmentCompat;

/* JADX INFO: loaded from: classes2.dex */
class e {
    static String a(Context r2) {
        String r3 = r2.getPackageManager().getPackageInfo(r2.getPackageName(), 0).versionName;     // Catch: Exception -> L4
    L6:
        if (TextUtils.isEmpty(r3) == false) goto L11;
        return EnvironmentCompat.MEDIA_UNKNOWN;
    L11:
        return r3;
    L4:
        r3 = null;
        goto L6
    }
}
