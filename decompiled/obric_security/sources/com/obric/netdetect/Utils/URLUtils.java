package com.obric.netdetect.Utils;

import java.net.URL;

/* JADX INFO: loaded from: classes3.dex */
public class URLUtils {
    private static final String TAG = "URLUtils";

    public URLUtils() {
    }

    public static URL makeURL(String r2) {
        if (r2 == null) goto L10;
        return new URL(r2);
    L5:
        NetDetectLog.e(TAG, "Bad URL: " + r2);
        return null;
    L10:
        return null;
    }
}
