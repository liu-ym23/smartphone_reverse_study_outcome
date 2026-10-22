package com.bytedance.applog.w;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.applog.util.n;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class f extends a {
    public long v;
    public String w;
    public boolean x;
    public String y;

    public f() {
    }

    @Override // com.bytedance.applog.w.a
    protected JSONObject B() {
        JSONObject r0 = new JSONObject();
        r0.put("local_time_ms", this.f2444g);
        r0.put("tea_event_index", this.f2445h);
        r0.put("session_id", this.f2446i);
        d(r0);
        if (TextUtils.isEmpty(this.f2449l) == true) goto L5;
        r0.put("user_unique_id", this.f2449l);
    L5:
        boolean r1 = this.x;
        if (r1 == false) goto L8;
        r0.put("is_background", r1);
    L8:
        r0.put("datetime", this.r);
        if (TextUtils.isEmpty(this.m) == true) goto L12;
        r0.put("ab_sdk_version", this.m);
    L12:
        if (TextUtils.isEmpty(this.y) == true) goto L14;
        r0.put("uuid_changed", true);
        r0.put("original_session_id", this.y);
    L14:
        return r0;
    }

    @Override // com.bytedance.applog.w.a
    protected List<String> h() {
        List<String> r8 = super.h();
        ArrayList r0 = new ArrayList(r8.size());
        r0.addAll(r8);
        r0.addAll(Arrays.asList(new String[]{"ver_name", "varchar", "ver_code", TypedValues.Custom.S_INT, "last_session", "varchar"}));
        return r0;
    }

    @Override // com.bytedance.applog.w.a
    protected String j() {
        if (this.x == false) goto L5;
        return "bg";
    L5:
        return "fg";
    }

    @Override // com.bytedance.applog.w.a
    @NonNull
    String n() {
        return "launch";
    }

    @Override // com.bytedance.applog.w.a
    public int o(@NonNull Cursor r4) {
        int r0 = super.o(r4);
        int r1 = r0 + 1;
        this.w = r4.getString(r0);
        int r2 = r1 + 1;
        this.v = r4.getLong(r1);
        int r3 = r2 + 1;
        this.y = r4.getString(r2);
        return r3;
    }

    @Override // com.bytedance.applog.w.a
    protected a p(@NonNull JSONObject r1) {
        n.i(null);
        return null;
    }

    @Override // com.bytedance.applog.w.a
    protected void y(@NonNull ContentValues r3) {
        super.y(r3);
        r3.put("ver_name", this.w);
        r3.put("ver_code", Long.valueOf(this.v));
        r3.put("last_session", this.y);
    }

    @Override // com.bytedance.applog.w.a
    protected void z(@NonNull JSONObject r1) {
        n.i(null);
    }
}
