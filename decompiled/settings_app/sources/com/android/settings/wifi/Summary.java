package com.android.settings.wifi;

import android.content.Context;
import android.content.res.Resources;
import android.net.NetworkInfo;
import com.android.settings.R;

/* JADX INFO: loaded from: classes.dex */
public class Summary {
    public Summary() {
    }

    static String get(Context r1, String r2, NetworkInfo.DetailedState r3) {
        Resources r4 = r1.getResources();
        if (r2 != null) goto L5;
        int r0 = R.array.wifi_status;
    L6:
        String[] r5 = r4.getStringArray(r0);
        int r6 = r3.ordinal();
        if (r6 < r5.length) goto L9;
        return null;
    L9:
        if (r5[r6].length() != 0) goto L12;
        return null;
    L12:
        return String.format(r5[r6], new Object[]{r2});
    L5:
        r0 = R.array.wifi_status_with_ssid;
        goto L6
    }

    public static String get(Context r1, NetworkInfo.DetailedState r2) {
        return get(r1, null, r2);
    }
}
