package com.bytedance.applog.w;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.applog.util.n;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class i extends a {
    public String A;
    public String B;
    public Integer C;
    public long v;
    public long w;
    public String x;
    public Integer y;
    public Boolean z;

    public i() {
    }

    @Override // com.bytedance.applog.w.a
    protected JSONObject B() {
        JSONObject r0 = new JSONObject();
        r0.put("local_time_ms", this.f2444g);
        r0.put("tea_event_index", this.f2445h);
        r0.put("session_id", this.f2446i);
        r0.put("stop_timestamp", this.w / 1000);
        r0.put(TypedValues.TransitionType.S_DURATION, this.v / 1000);
        r0.put("datetime", this.r);
        d(r0);
        if (TextUtils.isEmpty(this.f2449l) == true) goto L6;
        r0.put("user_unique_id", this.f2449l);
    L6:
        if (TextUtils.isEmpty(this.m) == true) goto L9;
        r0.put("ab_sdk_version", this.m);
    L9:
        if (TextUtils.isEmpty(this.x) == true) goto L13;
        r0.put("uuid_changed", true);
        if (TextUtils.equals(this.x, this.f2446i) == true) goto L13;
        r0.put("original_session_id", this.x);
    L13:
        Integer r1 = this.y;
        if (r1 == null) goto L16;
        r0.put("session_type", r1);
    L16:
        Boolean r2 = this.z;
        if (r2 == null) goto L20;
        r0.put("is_background", r2);
    L20:
        if (TextUtils.isEmpty(this.B) == true) goto L23;
        r0.put("from_session", this.B);
    L23:
        if (TextUtils.isEmpty(this.A) == true) goto L25;
        r0.put("to_session", this.A);
    L25:
        Integer r6 = this.C;
        if (r6 == null) goto L28;
        r0.put("bg_session", r6);
    L28:
        return r0;
    }

    @Override // com.bytedance.applog.w.a
    protected List<String> h() {
        return null;
    }

    @Override // com.bytedance.applog.w.a
    protected String j() {
        return String.valueOf(this.v);
    }

    @Override // com.bytedance.applog.w.a
    @NonNull
    String n() {
        return "terminate";
    }

    @Override // com.bytedance.applog.w.a
    public int o(@NonNull Cursor r1) {
        n.i(null);
        return 0;
    }

    @Override // com.bytedance.applog.w.a
    protected a p(@NonNull JSONObject r1) {
        n.i(null);
        return this;
    }

    @Override // com.bytedance.applog.w.a
    protected void y(@NonNull ContentValues r1) {
        n.i(null);
    }

    @Override // com.bytedance.applog.w.a
    protected void z(@NonNull JSONObject r1) {
        n.i(null);
    }
}
