package com.bytedance.applog.w;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class h extends a {
    public long v;
    public String w;
    public String x;
    public int y;
    public String z;

    public h() {
    }

    private JSONObject C() {
        JSONObject r0 = new JSONObject();
        r0.put("page_key", this.x);
        r0.put("refer_page_key", this.w);
        r0.put("is_back", this.y);
        r0.put(TypedValues.TransitionType.S_DURATION, this.v);
        return r0;
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
        r0.put(NotificationCompat.CATEGORY_EVENT, "bav2b_page");
        r0.put("is_bav", 1);
        r0.put("params", C());
        r0.put("datetime", this.r);
        return r0;
    }

    public boolean D() {
        return this.x.contains(":");
    }

    public boolean E() {
        if (this.v != (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.applog.w.a
    protected List<String> h() {
        List<String> r12 = super.h();
        ArrayList r0 = new ArrayList(r12.size());
        r0.addAll(r12);
        r0.addAll(Arrays.asList(new String[]{"page_key", "varchar", "refer_page_key", "varchar", TypedValues.TransitionType.S_DURATION, TypedValues.Custom.S_INT, "is_back", TypedValues.Custom.S_INT, "last_session", "varchar"}));
        return r0;
    }

    @Override // com.bytedance.applog.w.a
    protected String j() {
        return this.x + ", " + this.v;
    }

    @Override // com.bytedance.applog.w.a
    @NonNull
    String n() {
        return "page";
    }

    @Override // com.bytedance.applog.w.a
    public int o(@NonNull Cursor r5) {
        int r0 = super.o(r5);
        int r1 = r0 + 1;
        this.x = r5.getString(r0);
        int r2 = r1 + 1;
        this.w = r5.getString(r1);
        int r3 = r2 + 1;
        this.v = r5.getLong(r2);
        int r4 = r3 + 1;
        this.y = r5.getInt(r3);
        int r6 = r4 + 1;
        this.z = r5.getString(r4);
        return r6;
    }

    @Override // com.bytedance.applog.w.a
    protected a p(@NonNull JSONObject r4) {
        super.p(r4);
        this.x = r4.optString("page_key", null);
        this.w = r4.optString("refer_page_key", null);
        this.v = r4.optLong(TypedValues.TransitionType.S_DURATION, 0);
        this.y = r4.optInt("is_back", 0);
        return this;
    }

    @Override // com.bytedance.applog.w.a
    protected void y(@NonNull ContentValues r3) {
        super.y(r3);
        r3.put("page_key", this.x);
        r3.put("refer_page_key", this.w);
        r3.put(TypedValues.TransitionType.S_DURATION, Long.valueOf(this.v));
        r3.put("is_back", Integer.valueOf(this.y));
        r3.put("last_session", this.z);
    }

    @Override // com.bytedance.applog.w.a
    protected void z(@NonNull JSONObject r4) {
        super.z(r4);
        r4.put("page_key", this.x);
        r4.put("refer_page_key", this.w);
        r4.put(TypedValues.TransitionType.S_DURATION, this.v);
        r4.put("is_back", this.y);
    }
}
