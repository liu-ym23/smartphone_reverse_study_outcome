package com.bytedance.apm6.perf.base.model;

import d.b.b.l.b;
import d.b.b.m.a.c;
import d.b.b.o.e;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private JSONObject f2197a;

    public a() {
    }

    @Override // d.b.b.l.b
    public String a() {
        return "performance_monitor";
    }

    @Override // d.b.b.l.b
    public JSONObject c() {
    L16:
        return null;
    L3:
        if (this.f2197a != null) goto L5;
        this.f2197a = d();     // Catch: JSONException -> L16
    L5:
        this.f2197a.put("log_type", "performance_monitor");     // Catch: JSONException -> L16
        this.f2197a.put("service", h());     // Catch: JSONException -> L16
        JSONObject r0 = f();     // Catch: JSONException -> L16
        if (e.d(r0) == true) goto L8;
        this.f2197a.put("extra_values", r0);     // Catch: JSONException -> L16
    L8:
        JSONObject r1 = e();     // Catch: JSONException -> L16
        if (e.d(r1) == true) goto L11;
        this.f2197a.put("extra_status", r1);     // Catch: JSONException -> L16
    L11:
        JSONObject r2 = g();     // Catch: JSONException -> L16
        if (e.d(r2) == true) goto L14;
        this.f2197a.put("filters", r2);     // Catch: JSONException -> L16
    L14:
        return this.f2197a;
    }

    protected JSONObject d() {
        return new JSONObject();
    }

    protected JSONObject e() {
        JSONObject r2 = new JSONObject();     // Catch: Throwable -> L4
        r2.put("scene", c.a().e());     // Catch: Throwable -> L4
        r2.put("process_name", d.b.b.i.c.a.m());     // Catch: Throwable -> L4
        r2.put("is_main_process", d.b.b.i.c.a.A());     // Catch: Throwable -> L4
        return r2;
    L4:
        return null;
    }

    protected abstract JSONObject f();

    protected abstract JSONObject g();

    protected abstract String h();
}
