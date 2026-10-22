package com.bytedance.bdinstall.a1;

import android.text.TextUtils;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2652a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2653b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Boolean f2654c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Long f2655d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Long f2656e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Integer f2657f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Long f2658g;

    e(String r1, String r2, Boolean r3, Long r4, Long r5, Integer r6, Long r7) {
        this.f2652a = r1;
        this.f2653b = r2;
        this.f2654c = r3;
        this.f2655d = r4;
        this.f2656e = r5;
        this.f2657f = r6;
        this.f2658g = r7;
    }

    @Nullable
    @AnyThread
    public static e a(@Nullable String r15) {
        if (TextUtils.isEmpty(r15) == false) goto L30;
        return null;
    L30:
        JSONObject r5 = new JSONObject(r15);     // Catch: JSONException -> L27
        String r8 = r5.optString("id", null);     // Catch: JSONException -> L27
        String r9 = r5.optString("req_id", null);     // Catch: JSONException -> L27
        if (r5.has("is_track_limited") == false) goto L8;
        Boolean r10 = Boolean.valueOf(r5.optBoolean("is_track_limited"));     // Catch: JSONException -> L27
    L10:
        if (r5.has("take_ms") == false) goto L12;
        Long r16 = Long.valueOf(r5.optLong("take_ms", -1));     // Catch: JSONException -> L27
    L14:
        if (r5.has("time") == false) goto L16;
        Long r2 = Long.valueOf(r5.optLong("time", -1));     // Catch: JSONException -> L27
    L18:
        if (r5.has("query_times") == false) goto L20;
        Integer r13 = Integer.valueOf(r5.optInt("query_times", -1));     // Catch: JSONException -> L27
    L22:
        if (r5.has("hw_id_version_code") == false) goto L24;
        Long r14 = Long.valueOf(r5.optLong("hw_id_version_code", -1));     // Catch: JSONException -> L27
    L25:
        return new e(r8, r9, r10, r16, r2, r13, r14);
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

    @NonNull
    Map<String, String> b() {
        HashMap r0 = new HashMap();
        b.p(r0, "id", this.f2652a);
        b.p(r0, "req_id", this.f2653b);
        b.p(r0, "is_track_limited", String.valueOf(this.f2654c));
        b.p(r0, "take_ms", String.valueOf(this.f2655d));
        b.p(r0, "time", String.valueOf(this.f2656e));
        b.p(r0, "query_times", String.valueOf(this.f2657f));
        b.p(r0, "hw_id_version_code", String.valueOf(this.f2658g));
        return r0;
    }

    @NonNull
    JSONObject c() {
        JSONObject r0 = new JSONObject();
        b.o(r0, "id", this.f2652a);
        b.o(r0, "req_id", this.f2653b);
        b.o(r0, "is_track_limited", this.f2654c);
        b.o(r0, "take_ms", this.f2655d);
        b.o(r0, "time", this.f2656e);
        b.o(r0, "query_times", this.f2657f);
        b.o(r0, "hw_id_version_code", this.f2658g);
        return r0;
    }

    public String toString() {
        return c().toString();
    }
}
