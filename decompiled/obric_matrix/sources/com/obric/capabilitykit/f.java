package com.obric.capabilitykit;

import android.app.Application;
import androidx.core.app.NotificationCompat;
import com.obric.capabilitykit.common.IMAppAction;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.n0.c.l;
import kotlin.n0.d.o;
import kotlin.n0.d.q;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u000223B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000fH\u0002J\u001c\u0010\u0015\u001a\u00020\u00132\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00130\u0017H\u0002J\b\u0010\u0018\u001a\u00020\tH\u0002J\b\u0010\u0019\u001a\u00020\u0013H\u0002J\b\u0010\u001a\u001a\u00020\u0011H\u0002J\u0010\u0010\u001b\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\tH\u0007J\r\u0010\u001c\u001a\u00020\u0013H\u0000¢\u0006\u0002\b\u001dJ\u001a\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0007J\u001a\u0010#\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010$H\u0007J\u000e\u0010%\u001a\u00020\u00132\u0006\u0010&\u001a\u00020'J\u0015\u0010(\u001a\u00020\u00132\u0006\u0010)\u001a\u00020*H\u0000¢\u0006\u0002\b+J\u0010\u0010,\u001a\u00020\u00132\u0006\u0010-\u001a\u00020.H\u0007J\u001a\u0010/\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0007J\u001a\u00100\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010$H\u0007J\u000e\u00101\u001a\u00020\u00132\u0006\u0010&\u001a\u00020'R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/obric/capabilitykit/AtomicCapabilitySdk;", "", "()V", "ERROR_INVALID_ACTION_NAME", "", "ERROR_NO_ERROR", "TAG", "", "_config", "Lcom/obric/capabilitykit/AtomicCapabilitySdk$InitConfig;", "config", "getConfig", "()Lcom/obric/capabilitykit/AtomicCapabilitySdk$InitConfig;", "mPendingCals", "", "Lcom/obric/capabilitykit/AtomicCapabilitySdk$ApiCall;", "mSendResultApi", "Lcom/obric/capabilitykit/AbstractCapabilityManager;", "addPendingCall", "", NotificationCompat.CATEGORY_CALL, "callOrAddPendingCall", "func", "Lkotlin/Function1;", "checkInit", "execPendingCalls", "getApi", "init", "onApiInitComplete", "onApiInitComplete$capabilitykit_release", "registerFunction", "function", "Lcom/obric/capabilitykit/common/BaseFunction;", "meta", "Lcom/obric/capabilitykit/common/FunctionMeta;", "registerFunctionV2", "Lcom/obric/capabilitykit/common/FunctionMetaV2;", "registerResultCallback", "listener", "Lcom/obric/capabilitykit/ErrorCodeCallback;", "sendActionExecuteResult", "result", "Lcom/obric/capabilitykit/common/IMAppAction;", "sendActionExecuteResult$capabilitykit_release", "setLogger", "logger", "Lcom/obric/capabilitykit/logger/ILogger;", "unregisterFunction", "unregisterFunctionV2", "unregisterResultCallback", "ApiCall", "InitConfig", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f8133a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final List<a> f8134b = null;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bb\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/obric/capabilitykit/AtomicCapabilitySdk$ApiCall;", "", NotificationCompat.CATEGORY_CALL, "", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    private interface a {
        void call();
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/obric/capabilitykit/AtomicCapabilitySdk$InitConfig;", "", "app", "Landroid/app/Application;", "(Landroid/app/Application;)V", "getApp", "()Landroid/app/Application;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Application f8135a;

        public b(Application r2) {
            o.f(r2, "app");
            this.f8135a = r2;
        }

        public final Application a() {
            return this.f8135a;
        }

        public boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof b) == true) goto L9;
            return false;
        L9:
            if (o.a(this.f8135a, ((b) r4).f8135a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f8135a.hashCode();
        }

        public String toString() {
            return "InitConfig(app=" + this.f8135a + ')';
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/obric/capabilitykit/AtomicCapabilitySdk$callOrAddPendingCall$1", "Lcom/obric/capabilitykit/AtomicCapabilitySdk$ApiCall;", NotificationCompat.CATEGORY_CALL, "", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class c implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ l<com.obric.capabilitykit.b, f0> f8136a;

        /* JADX WARN: Multi-variable type inference failed */
        c(l<? super com.obric.capabilitykit.b, f0> r1) {
            this.f8136a = r1;
        }

        @Override // com.obric.capabilitykit.f.a
        public void call() {
            this.f8136a.invoke(f.a(f.f8133a));
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/obric/capabilitykit/AbstractCapabilityManager;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    static final class d extends q implements l<com.obric.capabilitykit.b, f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ IMAppAction f8137f;

        d(IMAppAction r1) {
            this.f8137f = r1;
            super(1);
        }

        public final void a(com.obric.capabilitykit.b r2) {
            o.f(r2, "it");
            f.a(f.f8133a).a(this.f8137f);
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ f0 invoke(com.obric.capabilitykit.b r1) {
            a(r1);
            return f0.f18324a;
        }
    }

    static {
        f8133a = new f();
        f8134b = new ArrayList();
    }

    private f() {
    }

    public static final /* synthetic */ com.obric.capabilitykit.b a(f r0) {
        return r0.e();
    }

    private final void b(a r3) {
        com.obric.capabilitykit.k.c.f8155a.a("AtomicCapabilitySdk", "addPendingCall");
        List<a> r2 = f8134b;
        monitor-enter(r2);
        r2.add(r3);     // Catch: Throwable -> L7
        monitor-exit(r2);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private final void c(l<? super com.obric.capabilitykit.b, f0> r3) {
        com.obric.capabilitykit.b r0 = e();
        if (o.a(r0, h.f8139a) == true) goto L5;
        r3.invoke(r0);
        return;
    L5:
        b(new c(r3));
    }

    private final void d() {
        com.obric.capabilitykit.k.c.f8155a.a("AtomicCapabilitySdk", "execPendingCalls");
        List<a> r5 = f8134b;
        monitor-enter(r5);
        Iterator<T> r0 = r5.iterator();     // Catch: Throwable -> L11
    L6:
        if (r0.hasNext() == false) goto L8;
        a r1 = (a) r0.next();     // Catch: Throwable -> L11
        com.obric.capabilitykit.k.c.f8155a.a("AtomicCapabilitySdk", "exec foreach call");     // Catch: Throwable -> L11
        r1.call();     // Catch: Throwable -> L11
        goto L6
    L8:
        f8134b.clear();     // Catch: Throwable -> L11
        f0 r2 = f0.f18324a;     // Catch: Throwable -> L11
        monitor-exit(r5);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    private final com.obric.capabilitykit.b e() {
        return e.f8124f.a();
    }

    public static final void f(b r3) {
        o.f(r3, "config");
        com.obric.capabilitykit.k.c.f8155a.b("AtomicCapabilitySdk", "AtomicCapabilitySdk init");
        com.obric.capabilitykit.j.c.f8150a.c(new com.obric.capabilitykit.j.d(r3.a()));
    }

    public final void g() {
        d();
    }

    public final void h(IMAppAction r2) {
        o.f(r2, "result");
        c(new d(r2));
    }
}
