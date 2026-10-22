package com.bytedance.apm.util;

import android.text.TextUtils;
import com.bytedance.apm.entity.LocalVersionInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class MonitorVersionUtils {
    public MonitorVersionUtils() {
    }

    public static JSONObject assembleVersionInfo(JSONObject r2, LocalVersionInfo r3) {
        if (r3 != null) goto L5;
        return r2;
    L5:
        if (TextUtils.isEmpty(r3.versionCode) == true) goto L8;
        r2.put("version_code", r3.versionCode);
    L8:
        if (TextUtils.isEmpty(r3.versionName) == true) goto L11;
        r2.put("version_name", r3.versionName);
    L11:
        if (TextUtils.isEmpty(r3.manifestVersionCode) == true) goto L14;
        r2.put("manifest_version_code", r3.manifestVersionCode);
    L14:
        if (TextUtils.isEmpty(r3.updateVersionCode) == true) goto L17;
        r2.put("update_version_code", r3.updateVersionCode);
    L17:
        if (TextUtils.isEmpty(r3.appVersion) == true) goto L19;
        r2.put("app_version", r3.appVersion);
    L19:
        return r2;
    }
}
