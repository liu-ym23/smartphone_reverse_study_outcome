package com.bytedance.applog.w;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bytedance.applog.util.n;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d extends a {

    @NonNull
    private String v;

    @NonNull
    private String w;

    public d(@NonNull String r1, @NonNull JSONObject r2) {
        this.w = r1;
        this.v = r2.toString();
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
        r0.put("log_type", this.w);
        JSONObject r1 = new JSONObject(this.v);     // Catch: Exception -> L14
        Iterator<String> r6 = r1.keys();     // Catch: Exception -> L14
    L7:
        if (r6.hasNext() == false) goto L16;
        String r2 = r6.next();     // Catch: Exception -> L14
        Object r3 = r1.get(r2);     // Catch: Exception -> L14
        if (r0.opt(r2) == null) goto L12;
        n.h("misc事件存在重复的key", null);     // Catch: Exception -> L14
    L12:
        r0.put(r2, r3);     // Catch: Exception -> L14
    L16:
        return r0;
    L14:
        e = move-exception;
        n.c("解析 event misc 失败", e);
        goto L16
    }

    public String C() {
        return this.w;
    }

    @Override // com.bytedance.applog.w.a
    protected List<String> h() {
        List<String> r3 = super.h();
        ArrayList r0 = new ArrayList(r3.size());
        r0.addAll(r3);
        r0.addAll(Arrays.asList(new String[]{"params", "varchar", "log_type", "varchar"}));
        return r0;
    }

    @Override // com.bytedance.applog.w.a
    public String i() {
        return this.v;
    }

    @Override // com.bytedance.applog.w.a
    protected String j() {
        return "param:" + this.v + " logType:" + this.w;
    }

    @Override // com.bytedance.applog.w.a
    @NonNull
    String n() {
        return "event_misc";
    }

    @Override // com.bytedance.applog.w.a
    public int o(@NonNull Cursor r3) {
        int r0 = super.o(r3);
        int r1 = r0 + 1;
        this.v = r3.getString(r0);
        int r2 = r1 + 1;
        this.w = r3.getString(r1);
        return r2;
    }

    @Override // com.bytedance.applog.w.a
    protected a p(@NonNull JSONObject r3) {
        super.p(r3);
        this.v = r3.optString("params", null);
        this.w = r3.optString("log_type", null);
        return this;
    }

    @Override // com.bytedance.applog.w.a
    protected void y(@NonNull ContentValues r3) {
        super.y(r3);
        r3.put("params", this.v);
        r3.put("log_type", this.w);
    }

    @Override // com.bytedance.applog.w.a
    protected void z(@NonNull JSONObject r3) {
        super.z(r3);
        r3.put("params", this.v);
        r3.put("log_type", this.w);
    }
}
