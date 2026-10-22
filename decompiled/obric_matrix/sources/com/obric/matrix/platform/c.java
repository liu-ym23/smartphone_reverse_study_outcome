package com.obric.matrix.platform;

import kotlin.Metadata;
import kotlin.f0;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\u000b\u001a\u00020\tJ\u0006\u0010\f\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/obric/matrix/platform/ThirdAppStartMonitor;", "", "()V", "javaInitEndTime", "", "javaInitStartTime", "loaderEndTime", "loaderStartTime", "onLoaderEnd", "", "onLoaderStart", "onThirdJavInitEnd", "onThirdJavInitStart", "sdk_platform_server_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f9489a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static long f9490b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static long f9491c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static long f9492d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static long f9493e;

    static {
        f9489a = new c();
    }

    private c() {
    }

    public final void a() {
        f9491c = System.currentTimeMillis();
    }

    public final void b() {
        f9490b = System.currentTimeMillis();
    }

    public final void c() {
        f9493e = System.currentTimeMillis();
        com.obric.matrix.server.t.a.c r5 = com.obric.matrix.server.t.a.c.f10010a;
        JSONObject r0 = new JSONObject();
        r0.put("load_init_time", f9491c - f9490b);
        r0.put("loader_end_to_java_init", f9492d - f9491c);
        r0.put("java_init_time", f9493e - f9492d);
        r0.put("all_duration", f9493e - f9490b);
        f0 r1 = f0.f18324a;
        r5.m("third_app_start_time", r0);
    }

    public final void d() {
        f9492d = System.currentTimeMillis();
    }
}
