package com.bytedance.bdinstall.oaid;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class OaidModel {
    public static final String KEY_HW_ID_VERSION_CODE = "hw_id_version_code";
    public static final String KEY_ID = "id";
    public static final String KEY_IS_TRACK_LIMITED = "is_track_limited";
    public static final String KEY_QUERY_TIMES = "query_times";
    public static final String KEY_REQ_ID = "req_id";
    public static final String KEY_TAKE_MS = "take_ms";
    public static final String KEY_TIME = "time";
    public final Boolean isTrackLimited;
    public final Long mHwIdVersionCode;
    public final String oaid;
    public final Integer queryTimes;
    public final String reqId;
    public final Long takeMs;
    public final Long time;

    OaidModel(String r1, String r2, Boolean r3, Long r4, Long r5, Integer r6, Long r7) {
        this.oaid = r1;
        this.reqId = r2;
        this.isTrackLimited = r3;
        this.takeMs = r4;
        this.time = r5;
        this.queryTimes = r6;
        this.mHwIdVersionCode = r7;
    }

    public String toString() {
        return toJson().toString();
    }

    Map<String, String> toApiMap() {
        HashMap r0 = new HashMap();
        Oaid.safePutNonNullValue(r0, "id", this.oaid);
        Oaid.safePutNonNullValue(r0, "req_id", this.reqId);
        Oaid.safePutNonNullValue(r0, KEY_IS_TRACK_LIMITED, String.valueOf(this.isTrackLimited));
        Oaid.safePutNonNullValue(r0, KEY_TAKE_MS, String.valueOf(this.takeMs));
        Oaid.safePutNonNullValue(r0, "time", String.valueOf(this.time));
        Oaid.safePutNonNullValue(r0, KEY_QUERY_TIMES, String.valueOf(this.queryTimes));
        Oaid.safePutNonNullValue(r0, KEY_HW_ID_VERSION_CODE, String.valueOf(this.mHwIdVersionCode));
        return r0;
    }

    JSONObject toJson() {
        JSONObject r0 = new JSONObject();
        Oaid.safePutNonEmptyValue(r0, "id", this.oaid);
        Oaid.safePutNonEmptyValue(r0, "req_id", this.reqId);
        Oaid.safePutNonEmptyValue(r0, KEY_IS_TRACK_LIMITED, this.isTrackLimited);
        Oaid.safePutNonEmptyValue(r0, KEY_TAKE_MS, this.takeMs);
        Oaid.safePutNonEmptyValue(r0, "time", this.time);
        Oaid.safePutNonEmptyValue(r0, KEY_QUERY_TIMES, this.queryTimes);
        Oaid.safePutNonEmptyValue(r0, KEY_HW_ID_VERSION_CODE, this.mHwIdVersionCode);
        return r0;
    }

    public static OaidModel create(String r15) {
        if (TextUtils.isEmpty(r15) == false) goto L30;
        return null;
    L30:
        JSONObject r5 = new JSONObject(r15);     // Catch: JSONException -> L27
        String r8 = r5.optString("id", null);     // Catch: JSONException -> L27
        String r9 = r5.optString("req_id", null);     // Catch: JSONException -> L27
        if (r5.has(KEY_IS_TRACK_LIMITED) == false) goto L8;
        Boolean r10 = Boolean.valueOf(r5.optBoolean(KEY_IS_TRACK_LIMITED));     // Catch: JSONException -> L27
    L10:
        if (r5.has(KEY_TAKE_MS) == false) goto L12;
        Long r16 = Long.valueOf(r5.optLong(KEY_TAKE_MS, -1));     // Catch: JSONException -> L27
    L14:
        if (r5.has("time") == false) goto L16;
        Long r2 = Long.valueOf(r5.optLong("time", -1));     // Catch: JSONException -> L27
    L18:
        if (r5.has(KEY_QUERY_TIMES) == false) goto L20;
        Integer r13 = Integer.valueOf(r5.optInt(KEY_QUERY_TIMES, -1));     // Catch: JSONException -> L27
    L22:
        if (r5.has(KEY_HW_ID_VERSION_CODE) == false) goto L24;
        Long r14 = Long.valueOf(r5.optLong(KEY_HW_ID_VERSION_CODE, -1));     // Catch: JSONException -> L27
    L25:
        return new OaidModel(r8, r9, r10, r16, r2, r13, r14);
    L24:
        r14 = null;
        goto L25
    L20:
        r13 = null;
        goto L22
    L16:
        r2 = null;
        goto L18
    L12:
        r16 = null;
        goto L14
    L8:
        r10 = null;
    L27:
        e = move-exception;
        e.printStackTrace();
        return null;
    }
}
