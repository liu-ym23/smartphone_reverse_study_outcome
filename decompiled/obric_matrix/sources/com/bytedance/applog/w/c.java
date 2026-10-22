package com.bytedance.applog.w;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c extends a {
    long A;
    public String v;
    public String w;
    public String x;
    public String y;
    public long z;

    c() {
    }

    @Override // com.bytedance.applog.w.a
    protected JSONObject B() {
        if (TextUtils.isEmpty(this.y) == true) goto L5;
        JSONObject r0 = new JSONObject(this.y);
    L6:
        if (r0 != null) goto L8;
        r0 = new JSONObject();
    L8:
        r0.put("local_time_ms", this.f2444g);
        r0.put("tea_event_index", this.f2445h);
        r0.put("session_id", this.f2446i);
        d(r0);
        if (this.n == com.bytedance.common.utility.i.a.f3283g.a()) goto L12;
        r0.put("nt", this.n);
    L12:
        if (TextUtils.isEmpty(this.f2449l) == true) goto L14;
        r0.put("user_unique_id", this.f2449l);
    L14:
        r0.put("category", this.v);
        r0.put(LocationMonitorConst.TAG, this.w);
        r0.put("value", this.z);
        r0.put("ext_value", this.A);
        r0.put("label", this.x);
        r0.put("datetime", this.r);
        if (TextUtils.isEmpty(this.m) == true) goto L17;
        r0.put("ab_sdk_version", this.m);
    L17:
        return r0;
    L5:
        r0 = null;
        goto L6
    }

    @Override // com.bytedance.applog.w.a
    protected List<String> h() {
        List<String> r14 = super.h();
        ArrayList r0 = new ArrayList(r14.size());
        r0.addAll(r14);
        r0.addAll(Arrays.asList(new String[]{"category", "varchar", LocationMonitorConst.TAG, "varchar", "value", TypedValues.Custom.S_INT, "ext_value", TypedValues.Custom.S_INT, "params", "varchar", "label", "varchar"}));
        return r0;
    }

    @Override // com.bytedance.applog.w.a
    protected String i() {
        return this.y;
    }

    @Override // com.bytedance.applog.w.a
    protected String j() {
        return "" + this.w + ", " + this.x;
    }

    @Override // com.bytedance.applog.w.a
    @NonNull
    String n() {
        return NotificationCompat.CATEGORY_EVENT;
    }

    @Override // com.bytedance.applog.w.a
    public int o(@NonNull Cursor r5) {
        int r0 = super.o(r5);
        int r1 = r0 + 1;
        this.v = r5.getString(r0);
        int r2 = r1 + 1;
        this.w = r5.getString(r1);
        int r3 = r2 + 1;
        this.z = r5.getLong(r2);
        int r4 = r3 + 1;
        this.A = r5.getLong(r3);
        int r6 = r4 + 1;
        this.y = r5.getString(r4);
        int r7 = r6 + 1;
        this.x = r5.getString(r6);
        return r7;
    }

    @Override // com.bytedance.applog.w.a
    protected a p(@NonNull JSONObject r7) {
        super.p(r7);
        this.f2445h = r7.optLong("tea_event_index", 0);
        this.v = r7.optString("category", null);
        this.w = r7.optString(LocationMonitorConst.TAG, null);
        this.z = r7.optLong("value", 0);
        this.A = r7.optLong("ext_value", 0);
        this.y = r7.optString("params", null);
        this.x = r7.optString("label", null);
        return this;
    }

    @Override // com.bytedance.applog.w.a
    protected void y(@NonNull ContentValues r3) {
        super.y(r3);
        r3.put("category", this.v);
        r3.put(LocationMonitorConst.TAG, this.w);
        r3.put("value", Long.valueOf(this.z));
        r3.put("ext_value", Long.valueOf(this.A));
        r3.put("params", this.y);
        r3.put("label", this.x);
    }

    @Override // com.bytedance.applog.w.a
    protected void z(@NonNull JSONObject r4) {
        super.z(r4);
        r4.put("tea_event_index", this.f2445h);
        r4.put("category", this.v);
        r4.put(LocationMonitorConst.TAG, this.w);
        r4.put("value", this.z);
        r4.put("ext_value", this.A);
        r4.put("params", this.y);
        r4.put("label", this.x);
    }
}
