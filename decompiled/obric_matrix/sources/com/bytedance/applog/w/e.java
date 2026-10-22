package com.bytedance.applog.w;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import com.bytedance.applog.util.n;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class e extends a {
    protected String v;
    private boolean w;
    protected String x;
    protected String y;

    public e(String r1, boolean r2, String r3) {
        this.x = r1;
        this.w = r2;
        this.v = r3;
        if (com.bytedance.applog.a.l() == null) goto L6;
        this.y = String.valueOf(com.bytedance.applog.a.l());
        return;
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
        r0.put(NotificationCompat.CATEGORY_EVENT, this.x);
        if (this.w == false) goto L9;
        r0.put("is_bav", 1);
    L9:
        if (TextUtils.isEmpty(this.v) == true) goto L12;
        r0.put("params", new JSONObject(this.v));
    L12:
        if (this.n == com.bytedance.common.utility.i.a.f3283g.a()) goto L14;
        r0.put("nt", this.n);
    L14:
        r0.put("datetime", this.r);
        if (TextUtils.isEmpty(this.m) == true) goto L18;
        r0.put("ab_sdk_version", this.m);
    L18:
        if (TextUtils.isEmpty(this.y) == true) goto L20;
        r0.put("disable_personalization", Integer.valueOf(this.y));
    L20:
        return r0;
    }

    protected void C() {
    }

    public String D() {
        return this.x;
    }

    public void E(com.bytedance.applog.s.a r3) {
        if (r3 == null) goto L5;
        this.s = r3.c(this.x, this.v);
        return;
    }

    @Override // com.bytedance.applog.w.a
    protected List<String> h() {
        List<String> r10 = super.h();
        ArrayList r0 = new ArrayList(r10.size());
        r0.addAll(r10);
        r0.addAll(Arrays.asList(new String[]{NotificationCompat.CATEGORY_EVENT, "varchar", "params", "varchar", "is_bav", TypedValues.Custom.S_INT, "disable_personalization", "varchar"}));
        return r0;
    }

    @Override // com.bytedance.applog.w.a
    public String i() {
        return this.v;
    }

    @Override // com.bytedance.applog.w.a
    protected String j() {
        return this.x;
    }

    @Override // com.bytedance.applog.w.a
    @NonNull
    String n() {
        return "eventv3";
    }

    @Override // com.bytedance.applog.w.a
    public int o(@NonNull Cursor r4) {
        int r0 = super.o(r4);
        int r1 = r0 + 1;
        this.x = r4.getString(r0);
        int r2 = r1 + 1;
        this.v = r4.getString(r1);
        int r3 = r2 + 1;
        boolean r5 = true;
        if (r4.getInt(r2) == 1) goto L6;
        r5 = false;
    L6:
        this.w = r5;
        int r6 = r3 + 1;
        this.y = r4.getString(r3);
        return r6;
    }

    @Override // com.bytedance.applog.w.a
    protected a p(@NonNull JSONObject r4) {
        super.p(r4);
        this.x = r4.optString(NotificationCompat.CATEGORY_EVENT, null);
        this.v = r4.optString("params", null);
        this.w = r4.optBoolean("is_bav", false);
        this.y = r4.optString("disable_personalization", null);
        return this;
    }

    @Override // com.bytedance.applog.w.a
    protected void y(@NonNull ContentValues r3) {
        super.y(r3);
        r3.put(NotificationCompat.CATEGORY_EVENT, this.x);
        if (this.w == true) goto L5;
    L10:
        r3.put("params", this.v);
        r3.put("is_bav", Integer.valueOf(this.w ? 1 : 0));
        r3.put("disable_personalization", this.y);
        return;
    L5:
        if (this.v != null) goto L10;
        C();     // Catch: JSONException -> L8
    L8:
        e = move-exception;
        n.i(e);
        goto L10
    }

    @Override // com.bytedance.applog.w.a
    protected void z(@NonNull JSONObject r3) {
        super.z(r3);
        r3.put(NotificationCompat.CATEGORY_EVENT, this.x);
        if (this.w == true) goto L5;
    L7:
        r3.put("params", this.v);
        r3.put("is_bav", this.w);
        r3.put("disable_personalization", this.y);
        return;
    L5:
        if (this.v != null) goto L7;
        C();
        goto L7
    }
}
