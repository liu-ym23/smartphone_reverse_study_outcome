package com.bd.mpaas.base;

import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u000f\u001a\u00020\rJ\u0006\u0010\u0010\u001a\u00020\rJ\u0006\u0010\u0011\u001a\u00020\rJ\b\u0010\u0012\u001a\u00020\rH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/bd/mpaas/base/AppStartMonitor;", "", "()V", "TAG", "", "app_start_time", "", "attachBaseContextEndTime", "attachBaseContextStartTime", "onCreateEndTime", "onCreateStartTime", "onSuperCreateEndTime", "attachBaseContextEnd", "", "attachBaseContextStart", "onCreateEnd", "onCreateStart", "onSuperCreateEnd", "uploadStartEvent", "app_matrix_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f548a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static long f549b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static long f550c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static long f551d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static long f552e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static long f553f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static long f554g;

    static {
        f548a = new d();
        f549b = System.currentTimeMillis();
        f550c = System.currentTimeMillis();
        f551d = System.currentTimeMillis();
        f552e = System.currentTimeMillis();
        f553f = System.currentTimeMillis();
        f554g = System.currentTimeMillis();
    }

    private d() {
    }

    private final void f() {
        JSONObject r4 = new JSONObject();
        r4.put("all_duration", f554g - f549b);
        r4.put("attach_ctx_use_time", f551d - f550c);
        r4.put("attach_to_create", f552e - f551d);
        r4.put("create_use_time", f554g - f552e);
        r4.put("super_create_use_time", f553f - f552e);
        r4.put("self_create_use_time", f554g - f553f);
        com.obric.matrix.r.c.c.b("AppStartMonitor", "uploadStartEvent: " + r4);
        com.obric.matrix.ostracker_api.b.g("matrix_app_start_use_time", r4);
    }

    public final void a() {
        f551d = System.currentTimeMillis();
    }

    public final void b() {
        f550c = System.currentTimeMillis();
    }

    public final void c() {
        f554g = System.currentTimeMillis();
        f();
    }

    public final void d() {
        f552e = System.currentTimeMillis();
    }

    public final void e() {
        f553f = System.currentTimeMillis();
    }
}
