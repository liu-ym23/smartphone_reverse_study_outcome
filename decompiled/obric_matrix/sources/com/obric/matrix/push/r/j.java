package com.obric.matrix.push.r;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.n0.d.o;
import kotlin.n0.d.q;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0017J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00182\b\b\u0002\u0010\u0016\u001a\u00020\u0017J\u0014\u0010\u0019\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0015J\u000e\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0018J\u0014\u0010\u001a\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0015J\u000e\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0018R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR#\u0010\u000e\u001a\n \u000f*\u0004\u0018\u00010\u00040\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\b\u001a\u0004\b\u0010\u0010\u0006¨\u0006\u001b"}, d2 = {"Lcom/obric/matrix/push/utils/ThreadPlus;", "", "()V", "mExecutorService", "Ljava/util/concurrent/ExecutorService;", "getMExecutorService", "()Ljava/util/concurrent/ExecutorService;", "mExecutorService$delegate", "Lkotlin/Lazy;", "mScheduledThreadPool", "Ljava/util/concurrent/ScheduledExecutorService;", "getMScheduledThreadPool", "()Ljava/util/concurrent/ScheduledExecutorService;", "mScheduledThreadPool$delegate", "mSingleExecutorService", "kotlin.jvm.PlatformType", "getMSingleExecutorService", "mSingleExecutorService$delegate", "schedule", "", "runnable", "Lkotlin/Function0;", "delay", "", "Ljava/lang/Runnable;", LocationMonitorConst.SUBMIT, "submitWithOrder", "push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f9798a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final kotlin.h f9799b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final kotlin.h f9800c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final kotlin.h f9801d = null;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class a extends q implements kotlin.n0.c.a<ExecutorService> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f9802f = null;

        static {
            f9802f = new a();
        }

        a() {
            super(0);
        }

        public final ExecutorService a() {
            return com.bytedance.common.utility.m.a.b();
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ ExecutorService invoke() {
            return a();
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Ljava/util/concurrent/ScheduledExecutorService;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class b extends q implements kotlin.n0.c.a<ScheduledExecutorService> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final b f9803f = null;

        static {
            f9803f = new b();
        }

        b() {
            super(0);
        }

        public final ScheduledExecutorService a() {
            return com.bytedance.common.utility.m.a.d();
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ ScheduledExecutorService invoke() {
            return a();
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class c extends q implements kotlin.n0.c.a<ExecutorService> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final c f9804f = null;

        static {
            f9804f = new c();
        }

        c() {
            super(0);
        }

        public final ExecutorService a() {
            return Executors.newSingleThreadExecutor();
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ ExecutorService invoke() {
            return a();
        }
    }

    static {
        f9798a = new j();
        f9799b = kotlin.i.b(a.f9802f);
        f9800c = kotlin.i.b(b.f9803f);
        f9801d = kotlin.i.b(c.f9804f);
    }

    private j() {
    }

    private final ExecutorService a() {
        Object r1 = f9799b.getValue();
        o.e(r1, "<get-mExecutorService>(...)");
        return (ExecutorService) r1;
    }

    private final ScheduledExecutorService b() {
        Object r1 = f9800c.getValue();
        o.e(r1, "<get-mScheduledThreadPool>(...)");
        return (ScheduledExecutorService) r1;
    }

    private final ExecutorService c() {
        return (ExecutorService) f9801d.getValue();
    }

    public static /* synthetic */ void d(kotlin.n0.c.a r0) {
        k(r0);
    }

    public static /* synthetic */ void e(kotlin.n0.c.a r0) {
        m(r0);
    }

    public static /* synthetic */ void f(kotlin.n0.c.a r0) {
        i(r0);
    }

    private static final void i(kotlin.n0.c.a r1) {
        o.f(r1, "$tmp0");
        r1.invoke();
    }

    private static final void k(kotlin.n0.c.a r1) {
        o.f(r1, "$runnable");
        r1.invoke();
    }

    private static final void m(kotlin.n0.c.a r1) {
        o.f(r1, "$runnable");
        r1.invoke();
    }

    public final void g(Runnable r2, long r3) {
        o.f(r2, "runnable");
        b().schedule(r2, r3, TimeUnit.SECONDS);
    }

    public final void h(final kotlin.n0.c.a<f0> r2, long r3) {
        o.f(r2, "runnable");
        b().schedule(new com.obric.matrix.push.r.c(r2), r3, TimeUnit.SECONDS);
    }

    public final void j(final kotlin.n0.c.a<f0> r2) {
        o.f(r2, "runnable");
        a().submit(new com.obric.matrix.push.r.a(r2));
    }

    public final void l(final kotlin.n0.c.a<f0> r2) {
        o.f(r2, "runnable");
        c().submit(new com.obric.matrix.push.r.b(r2));
    }
}
