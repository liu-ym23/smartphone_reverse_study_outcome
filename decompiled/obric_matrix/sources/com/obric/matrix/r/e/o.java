package com.obric.matrix.r.e;

import android.os.Handler;
import android.os.Looper;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.n0.d.q;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u001e\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0007J\u0018\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u0014\u0010\u0014\u001a\u00020\r2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fR\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0015"}, d2 = {"Lcom/obric/matrix/common_utils/utils/UiHandler;", "", "()V", "uiHandler", "Landroid/os/Handler;", "getUiHandler", "()Landroid/os/Handler;", "uiHandler$delegate", "Lkotlin/Lazy;", "post", "", "block", "Lkotlin/Function0;", "", "r", "Ljava/lang/Runnable;", "postDelay", "delay", "", "remove", "submitOnMainLooper", "common_utils_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o f9947a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final kotlin.h f9948b = null;

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/os/Handler;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class a extends q implements kotlin.n0.c.a<Handler> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f9949f = null;

        static {
            f9949f = new a();
        }

        a() {
            super(0);
        }

        public final Handler a() {
            return new Handler(Looper.getMainLooper());
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ Handler invoke() {
            return a();
        }
    }

    static {
        f9947a = new o();
        f9948b = kotlin.i.b(a.f9949f);
    }

    private o() {
    }

    private final Handler a() {
        return (Handler) f9948b.getValue();
    }

    public static /* synthetic */ void b(kotlin.n0.c.a r0) {
        d(r0);
    }

    public static final boolean c(final kotlin.n0.c.a<f0> r2) {
        kotlin.n0.d.o.f(r2, "block");
        return f9947a.a().post(new com.obric.matrix.r.e.a(r2));
    }

    private static final void d(kotlin.n0.c.a r1) {
        kotlin.n0.d.o.f(r1, "$tmp0");
        r1.invoke();
    }

    public static final boolean e(long r1, Runnable r3) {
        kotlin.n0.d.o.f(r3, "r");
        return f9947a.a().postDelayed(r3, r1);
    }

    public static final void f(Runnable r1) {
        kotlin.n0.d.o.f(r1, "r");
        f9947a.a().removeCallbacks(r1);
    }
}
