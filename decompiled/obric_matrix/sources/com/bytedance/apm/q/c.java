package com.bytedance.apm.q;

import android.app.Activity;
import android.os.Build;
import com.bytedance.apm.core.ActivityLifeObserver;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c extends com.bytedance.apm.a0.a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static int f1707h = 10;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f1708g;

    static {
    }

    public c() {
        this.f1122e = "battery";
    }

    @Override // com.bytedance.apm.a0.a
    protected void c(JSONObject r5) {
        boolean r1 = true;
        if (Build.VERSION.SDK_INT >= 21) goto L5;
    L7:
        r1 = false;
    L8:
        this.f1708g = r1;
        return;
    L5:
        if (r5.optInt("energy_enable", 0) != 1) goto L7;
        goto L7
    }

    @Override // com.bytedance.apm.a0.a
    protected boolean f() {
        return this.f1708g;
    }

    @Override // com.bytedance.apm.a0.a
    protected void i() {
        super.i();
        if (this.f1708g == true) goto L5;
        return;
    L5:
        if (e() == false) goto L8;
        return;
    L8:
        if (com.bytedance.apm.q.k.a.f(com.bytedance.apm.d.h()) == false) goto L10;
        return;
    L10:
        float r0 = d.i.c.c.b(com.bytedance.apm.d.h());
        if (r0 >= f1707h) goto L16;
        return;
    L16:
        JSONObject r5 = new JSONObject();     // Catch: JSONException -> L15
        r5.put("timing_current", r0);     // Catch: JSONException -> L15
        JSONObject r6 = new JSONObject();     // Catch: JSONException -> L15
        r6.put("scene", ActivityLifeObserver.getInstance().getTopActivityClassName());     // Catch: JSONException -> L15
        k(new com.bytedance.apm.t.d.e("battery", "", r5, r6, null));     // Catch: JSONException -> L15
        return;
    }

    @Override // com.bytedance.apm.a0.a
    protected long n() {
        return 300000;
    }

    @Override // com.bytedance.apm.a0.a, com.bytedance.services.apm.api.IActivityLifeObserver
    public void onBackground(Activity r1) {
        super.onBackground(r1);
        com.bytedance.apm.f0.b.f().m(this);
    }

    @Override // com.bytedance.apm.a0.a, com.bytedance.services.apm.api.IActivityLifeObserver
    public void onFront(Activity r1) {
        super.onFront(r1);
        if (this.f1708g == false) goto L6;
        com.bytedance.apm.f0.b.f().c(this);
        return;
    }
}
