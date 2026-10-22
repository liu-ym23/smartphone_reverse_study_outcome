package com.obric.matrix.r.d;

import android.content.Context;
import androidx.annotation.NonNull;
import com.obric.matrix.r.e.h;
import com.obric.matrix.r.e.j;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final String f9932a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected long f9933b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected Map<String, Object> f9934c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected Map<String, Object> f9935d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected Map<String, Object> f9936e;

    public d(@NonNull String r3) {
        this.f9934c = new HashMap();
        this.f9935d = new HashMap();
        this.f9936e = new HashMap();
        this.f9932a = r3;
        this.f9933b = System.currentTimeMillis();
        l();
    }

    protected void a(long r1) {
        this.f9933b = r1;
    }

    public Map<String, Object> b() {
        return this.f9934c;
    }

    public long c() {
        return this.f9933b;
    }

    public String d() {
        return this.f9932a;
    }

    public Map<String, Object> e() {
        return this.f9936e;
    }

    public Map<String, Object> f() {
        return this.f9935d;
    }

    public void g(@NonNull String r1, @NonNull Object r2) {
        this.f9934c.put(r1, r2);
    }

    public void h(@NonNull String r1, @NonNull Object r2) {
        this.f9936e.put(r1, r2);
    }

    public void i(@NonNull String r1, @NonNull Object r2) {
        this.f9935d.put(r1, r2);
    }

    public void j() {
        a.g().j(this);
    }

    protected abstract void k(@NonNull Context r1);

    protected void l() {
        this.f9934c.put("doze_mode", Boolean.valueOf(j.b()));     // Catch: Exception -> L4
        this.f9934c.put("screen_on", Boolean.valueOf(j.c()));     // Catch: Exception -> L4
        this.f9934c.put("net_available", Boolean.valueOf(h.b()));     // Catch: Exception -> L4
        this.f9934c.put("login_state", Boolean.valueOf(a.g().h()));     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.obric.matrix.r.c.c.g("OApmEvent", "setDefaultCategory: ", e);
    }

    @NonNull
    public String toString() {
        return getClass().getSimpleName() + ", eventName: " + this.f9932a + ", metrics: " + this.f9935d.toString() + ", category: " + this.f9934c.toString() + ", extra: " + this.f9936e.toString();
    }
}
