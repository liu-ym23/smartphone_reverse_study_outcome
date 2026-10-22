package com.obric.matrix.p;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.obric.matrix.q.h.k;
import h.a.b1;
import h.a.h;
import h.a.m0;
import h.a.n0;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.k0.j.a.f;
import kotlin.k0.j.a.l;
import kotlin.n0.c.p;
import kotlin.n0.d.o;
import kotlin.w;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ&\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004J\u001e\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u0004J\u000e\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/obric/matrix/apm/ApmHelper;", "", "()V", "TAG", "", "checkConditionRunnable", "Ljava/lang/Runnable;", "handler", "Landroid/os/Handler;", "init", "", "context", "Landroid/content/Context;", "isDebug", "", "initAndStartApm", "appId", "did", "startApm", "", "verify2InitApm", "app", "app_matrix_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f9466a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f9467b = "ApmHelper";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Handler f9468c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Runnable f9469d;

    /* JADX INFO: renamed from: com.obric.matrix.p.a$a, reason: collision with other inner class name */
    @f(c = "com.obric.matrix.apm.ApmHelper$initAndStartApm$1", f = "ApmHelper.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class C0255a extends l implements p<m0, kotlin.k0.d<? super f0>, Object> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f9470f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ Context f9471g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ boolean f9472h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f9473i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ String f9474j;

        C0255a(Context r1, boolean r2, String r3, String r4, kotlin.k0.d<? super C0255a> r5) {
            this.f9471g = r1;
            this.f9472h = r2;
            this.f9473i = r3;
            this.f9474j = r4;
            super(2, r5);
        }

        @Override // kotlin.k0.j.a.a
        public final kotlin.k0.d<f0> create(Object r7, kotlin.k0.d<?> r8) {
            return new C0255a(this.f9471g, this.f9472h, this.f9473i, this.f9474j, r8);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(m0 r1, kotlin.k0.d<? super f0> r2) {
            return ((C0255a) create(r1, r2)).invokeSuspend(f0.f18324a);
        }

        @Override // kotlin.n0.c.p
        public /* bridge */ /* synthetic */ Object invoke(m0 r1, kotlin.k0.d<? super f0> r2) {
            return invoke2(r1, r2);
        }

        @Override // kotlin.k0.j.a.a
        public final Object invokeSuspend(Object r3) {
            kotlin.k0.i.b.c();
            if (this.f9470f != 0) goto L7;
            w.b(r3);
            com.obric.matrix.r.c.c.j(a.b(), "initAndStartApm");
            a r4 = a.f9466a;
            r4.c(this.f9471g, this.f9472h);
            r4.e(this.f9471g, Integer.parseInt(this.f9473i), this.f9474j);
            return f0.f18324a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/obric/matrix/apm/ApmHelper$startApm$1", "Lcom/bytedance/apm/core/IDynamicParams;", "getCommonParams", "", "", "getSessionId", "getUid", "", "app_matrix_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class b implements com.bytedance.apm.core.b {
        b() {
        }

        @Override // com.bytedance.apm.core.b
        public Map<String, String> getCommonParams() {
            HashMap r2 = new HashMap();
            r2.put("region", "CN");
            com.obric.matrix.r.c.c.j(a.b(), "getCommonParams ");
            return r2;
        }

        @Override // com.bytedance.apm.core.b
        public String getSessionId() {
            com.obric.matrix.r.c.c.j(a.b(), "getSessionId ");
            return "";
        }

        @Override // com.bytedance.apm.core.b
        public long getUid() {
            com.obric.matrix.r.c.c.j(a.b(), "getUid ");
            return 0;
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/matrix/apm/ApmHelper$startApm$2", "Lcom/obric/matrix/base/system/ISystemStateListener;", "onScreenStateChanged", "", "on", "", "app_matrix_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class c implements com.obric.matrix.q.h.d {
        c() {
        }

        @Override // com.obric.matrix.q.h.d
        public void b(boolean r1) {
            com.bytedance.apm.b r0 = com.bytedance.apm.b.a();
            if (r1 == false) goto L5;
            r0.d();
            return;
        L5:
            r0.c();
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/obric/matrix/apm/ApmHelper$verify2InitApm$1", "Ljava/lang/Runnable;", "run", "", "app_matrix_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class d implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Context f9475f;

        d(Context r1) {
            this.f9475f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.obric.matrix.r.c.c.j(a.b(), "checkConditionRunnable getDid1");
            String r0 = com.obric.matrix.ostracker_api.b.c();
            Log.i(a.b(), "checkConditionRunnable getDid2");
            if (r0 == null) goto L30;
            boolean r2 = true;
            int r1 = r0.length() - 1;
            int r4 = 0;
            boolean r5 = false;
        L5:
            if (r4 > r1) goto L21;
            if (r5 == true) goto L8;
            int r6 = r4;
        L10:
            if (o.h(r0.charAt(r6), 32) > 0) goto L12;
            boolean r7 = true;
        L13:
            if (r5 == false) goto L14;
            if (r7 == false) goto L21;
            r1 = r1 - 1;
            goto L5
        L14:
            if (r7 == false) goto L15;
            r4 = r4 + 1;
            goto L5
        L15:
            r5 = true;
            goto L5
        L12:
            r7 = false;
            goto L13
        L8:
            r6 = r1;
        L21:
            if (r0.subSequence(r4, r1 + 1).toString().length() == 0) goto L24;
            r2 = false;
        L24:
            if (r2 == true) goto L30;
            if (o.a(r0, BDLocationException.ERROR_TIMEOUT) == true) goto L30;
            if (o.a(r0, "-1") == true) goto L30;
            a.f9466a.d(this.f9475f, false, "508474", r0);
            return;
        L30:
            a.a().postDelayed(this, 2000);
        }
    }

    static {
        f9466a = new a();
        f9468c = new Handler(Looper.getMainLooper());
    }

    private a() {
    }

    public static final /* synthetic */ Handler a() {
        return f9468c;
    }

    public static final /* synthetic */ String b() {
        return f9467b;
    }

    public final void c(Context r2, boolean r3) {
        o.f(r2, "context");
        com.bytedance.apm.b r1 = com.bytedance.apm.b.a();
        com.bytedance.apm.config.b.C0042b r0 = com.bytedance.apm.config.b.a();
        r0.F(r3);
        r1.b(r2, r0.E());
        com.bytedance.apm.d.i0(true);
    }

    public final void d(Context r9, boolean r10, String r11, String r12) {
        o.f(r9, "context");
        o.f(r11, "appId");
        o.f(r12, "did");
        h.b(n0.b(), b1.c(), null, new C0255a(r9, r10, r11, r12, null), 2, null);
    }

    public final void e(Context r3, int r4, String r5) {
        o.f(r3, "context");
        o.f(r5, "did");
        String r2 = com.obric.matrix.l.f9107a.a();
        com.obric.matrix.r.c.c.j(f9467b, "startApm channel: " + r2);
        com.bytedance.apm.b r6 = com.bytedance.apm.b.a();
        com.bytedance.apm.config.c.b r0 = com.bytedance.apm.config.c.a();
        r0.a(r4);
        r0.b("6.8.8");
        r0.d(r2);
        r0.e(r5);
        r0.i("600808520");
        r0.f(new b());
        r6.e(r0.c());
        k.l(new c());
    }

    public final void f(Context r1) {
        o.f(r1, "app");
        d r0 = new d(r1);
        f9469d = r0;
        Handler r2 = f9468c;
        if (r0 == null) goto L6;
        r2.post(r0);
        return;
    L6:
        o.v("checkConditionRunnable");
        throw null;
    }
}
