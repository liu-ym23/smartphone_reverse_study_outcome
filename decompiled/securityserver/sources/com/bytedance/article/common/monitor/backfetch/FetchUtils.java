package com.bytedance.article.common.monitor.backfetch;

import android.content.Context;
import android.text.TextUtils;
import com.ttnet.org.chromium.base.TimeUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class FetchUtils {
    public FetchUtils() {
    }

    public static void activeUploadLegacyLog(Context r0, long r1, long r3, boolean r5) {
    }

    public static void activeUploadRecentLog(Context r10, boolean r11) {
        activeUploadLegacyLog(r10, System.currentTimeMillis() - 21600000, System.currentTimeMillis(), r11);
    }

    public static boolean checkFetchInterval(long r1, long r3) {
        if (r1 < r3) goto L5;
        return false;
    L5:
        if ((((r3 - r1) / 1000) / TimeUtils.SECONDS_PER_HOUR) <= 1) goto L10;
        return true;
    L10:
        return false;
    }

    public static void fetchAllData() {
    }

    public static String getVersionName(JSONObject r2) {
        if (r2 != null) goto L4;
    L7:
        if (r2 != null) goto L9;
        return "";
    L9:
        if (TextUtils.isEmpty(r2.optString("app_version")) == false) goto L11;
        return "";
    L11:
        return r2.optString("app_version");
    L4:
        if (TextUtils.isEmpty(r2.optString("update_version_code")) == true) goto L7;
        return r2.optString("update_version_code");
    }
}
