package com.ss.android.message.log;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.common.utility.StringUtils;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class PushLog {
    public static final String EVENT_LABEL_TEST = "click_headline";
    public static final String EVENT_SIGN = "_event_v3";
    public static final String EVENT_TAG_TEST1 = "go_detail";
    public static final String EVENT_TAG_TEST2 = "video_play";
    public static final String EVENT_V3_CATEGORY = "event_v3";
    public static final String KEY_CATEGORY = "category";
    public static final String KEY_EXT_JSON = "ext_json";
    public static final String KEY_EXT_VALUE = "ext_value";
    public static final String KEY_LABEL = "label";
    public static final String KEY_TAG = "tag";
    public static final String KEY_VALUE = "value";
    public static final String UMENG_CATEGORY = "umeng";

    public PushLog() {
    }

    public static void onEvent(final Context r11, final String r12, final String r13, final String r14, final long r15, final long r17, final JSONObject r19) {
        if (StringUtils.isEmpty(r12) == false) goto L5;
        return;
    L5:
        if (StringUtils.isEmpty(r13) == true) goto L10;
        new AnonymousClass1(r12, r13, r14, r15, r17, r19, r11).start();
        return;
    }

    public static void onEvent(Context r9, String r10, String r11, String r12, long r13, long r15) {
        onEvent(r9, r10, r11, r12, r13, r15, null);
    }

    public static void onEvent(Context r20, String r21, String r22, JSONObject... r23) {
        if (r23 != null) goto L5;
    L7:
        onEvent(r20, UMENG_CATEGORY, r21, r22, 0, 0, null);
        return;
    L5:
        if (r23.length <= 0) goto L7;
        onEvent(r20, UMENG_CATEGORY, r21, r22, 0, 0, r23[0]);
    }

    public static void onEvent(Context r20, String r21, JSONObject... r22) {
        if (r22 != null) goto L5;
    L7:
        onEvent(r20, UMENG_CATEGORY, r21, null, 0, 0, null);
        return;
    L5:
        if (r22.length <= 0) goto L7;
        onEvent(r20, UMENG_CATEGORY, r21, null, 0, 0, r22[0]);
    }

    public static void onEventV3(String r9, JSONObject r10) {
        if (StringUtils.isEmpty(r9) == false) goto L5;
        return;
    L5:
        if (r10 != null) goto L7;
        r10 = new JSONObject();
    L7:
        JSONObject r8 = r10;
        r8.put(EVENT_SIGN, 1);     // Catch: JSONException -> L10
    L12:
        onEvent(null, EVENT_V3_CATEGORY, r9, null, 0, 0, r8);
        return;
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L12
    }

    public static void onEventV3Bundle(String r10, Bundle r11) {
        if (StringUtils.isEmpty(r10) == false) goto L5;
        return;
    L5:
        JSONObject r9 = new JSONObject();
        r9.put(EVENT_SIGN, 1);     // Catch: Throwable -> L13
        if (r11 == null) goto L15;
        Iterator<String> r0 = r11.keySet().iterator();     // Catch: Throwable -> L13
    L10:
        if (r0.hasNext() == false) goto L15;
        String r1 = r0.next();     // Catch: Throwable -> L13
        r9.put(r1, r11.get(r1));     // Catch: Throwable -> L13
    L15:
        onEvent(null, EVENT_V3_CATEGORY, r10, null, 0, 0, r9);
        return;
    L13:
        th = move-exception;
        th.printStackTrace();
        goto L15
    }

    public static void onEventV3Bundle(Context r10, String r11, Bundle r12) {
        if (StringUtils.isEmpty(r11) == false) goto L5;
        return;
    L5:
        JSONObject r9 = new JSONObject();
        r9.put(EVENT_SIGN, 1);     // Catch: Throwable -> L13
        if (r12 == null) goto L15;
        Iterator<String> r0 = r12.keySet().iterator();     // Catch: Throwable -> L13
    L10:
        if (r0.hasNext() == false) goto L15;
        String r1 = r0.next();     // Catch: Throwable -> L13
        r9.put(r1, r12.get(r1));     // Catch: Throwable -> L13
    L15:
        onEvent(r10, EVENT_V3_CATEGORY, r11, null, 0, 0, r9);
        return;
    L13:
        th = move-exception;
        th.printStackTrace();
        goto L15
    }
}
