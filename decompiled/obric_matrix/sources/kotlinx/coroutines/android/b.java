package kotlinx.coroutines.android;

import android.os.Handler;
import android.os.Looper;
import h.a.b1;
import h.a.b2;
import h.a.d1;
import h.a.i2;
import h.a.k2;
import h.a.n;
import h.a.u0;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.n0.c.l;
import kotlin.n0.d.g;
import kotlin.n0.d.o;
import kotlin.n0.d.q;
import kotlin.r0.e;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001c\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\n\u0010\u0013\u001a\u00060\u0014j\u0002`\u0015H\u0002J\u001c\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\n\u0010\u0013\u001a\u00060\u0014j\u0002`\u0015H\u0016J\u0013\u0010\u0017\u001a\u00020\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0096\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0016J$\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\n\u0010\u0013\u001a\u00060\u0014j\u0002`\u00152\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010 \u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u001e\u0010!\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u001f2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00100#H\u0016J\b\u0010$\u001a\u00020\u0006H\u0016R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\u0000X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lkotlinx/coroutines/android/HandlerContext;", "Lkotlinx/coroutines/android/HandlerDispatcher;", "Lkotlinx/coroutines/Delay;", "handler", "Landroid/os/Handler;", "name", "", "(Landroid/os/Handler;Ljava/lang/String;)V", "invokeImmediately", "", "(Landroid/os/Handler;Ljava/lang/String;Z)V", "_immediate", "immediate", "getImmediate", "()Lkotlinx/coroutines/android/HandlerContext;", "cancelOnRejection", "", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "dispatch", "equals", "other", "", "hashCode", "", "invokeOnTimeout", "Lkotlinx/coroutines/DisposableHandle;", "timeMillis", "", "isDispatchNeeded", "scheduleResumeAfterDelay", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "toString", "kotlinx-coroutines-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class b extends c implements u0 {
    private volatile b _immediate;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Handler f21471f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f21472g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f21473h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final b f21474i;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "run", "kotlinx/coroutines/RunnableKt$Runnable$1"}, k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ n f21475f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ b f21476g;

        public a(n r1, b r2) {
            this.f21475f = r1;
            this.f21476g = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f21475f.m(this.f21476g, f0.f18324a);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.android.b$b, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class C0591b extends q implements l<Throwable, f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ b f21477f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ Runnable f21478g;

        C0591b(b r1, Runnable r2) {
            this.f21477f = r1;
            this.f21478g = r2;
            super(1);
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ f0 invoke(Throwable r1) {
            invoke2(r1);
            return f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable r1) {
            b.j0(this.f21477f).removeCallbacks(this.f21478g);
        }
    }

    public b(Handler r2, String r3) {
        this(r2, r3, false);
    }

    public /* synthetic */ b(Handler r1, String r2, int r3, g r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private b(Handler r2, String r3, boolean r4) {
        b r0 = null;
        super(0 == true ? 1 : 0);
        this.f21471f = r2;
        this.f21472g = r3;
        this.f21473h = r4;
        if (r4 == false) goto L5;
        r0 = this;
    L5:
        this._immediate = r0;
        b r5 = this._immediate;
        if (r5 != null) goto L8;
        r5 = new b(r2, r3, true);
        this._immediate = r5;
    L8:
        this.f21474i = r5;
    }

    public static final /* synthetic */ Handler j0(b r0) {
        return r0.f21471f;
    }

    private final void k0(kotlin.k0.g r4, Runnable r5) {
        b2.c(r4, new CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed"));
        b1.b().dispatch(r4, r5);
    }

    private static final void m0(b r0, Runnable r1) {
        r0.f21471f.removeCallbacks(r1);
    }

    public static /* synthetic */ void n0(b r0, Runnable r1) {
        m0(r0, r1);
    }

    @Override // kotlinx.coroutines.android.c, h.a.u0
    public d1 M(long r4, final Runnable r6, kotlin.k0.g r7) {
        if (this.f21471f.postDelayed(r6, e.g(r4, 4611686018427387903L)) == true) goto L5;
        k0(r7, r6);
        return k2.f17534f;
    L5:
        return new kotlinx.coroutines.android.a(this, r6);
    }

    @Override // h.a.g0
    public void dispatch(kotlin.k0.g r2, Runnable r3) {
        if (this.f21471f.post(r3) == true) goto L6;
        k0(r2, r3);
        return;
    }

    public boolean equals(Object r2) {
        if ((r2 instanceof b) == true) goto L5;
    L7:
        return false;
    L5:
        if (((b) r2).f21471f != this.f21471f) goto L7;
        return true;
    }

    @Override // h.a.i2
    public /* bridge */ /* synthetic */ i2 h0() {
        return l0();
    }

    public int hashCode() {
        return System.identityHashCode(this.f21471f);
    }

    @Override // h.a.g0
    public boolean isDispatchNeeded(kotlin.k0.g r1) {
        if (this.f21473h == true) goto L5;
    L8:
        return true;
    L5:
        if (o.a(Looper.myLooper(), this.f21471f.getLooper()) == false) goto L8;
        return false;
    }

    @Override // h.a.u0
    public void l(long r5, n<? super f0> r7) {
        a r0 = new a(r7, this);
        if (this.f21471f.postDelayed(r0, e.g(r5, 4611686018427387903L)) == false) goto L5;
        r7.h(new C0591b(this, r0));
        return;
    L5:
        k0(r7.getContext(), r0);
    }

    public b l0() {
        return this.f21474i;
    }

    @Override // h.a.i2, h.a.g0
    public String toString() {
        String r0 = i0();
        if (r0 != null) goto L11;
        String r1 = this.f21472g;
        if (r1 != null) goto L8;
        r1 = this.f21471f.toString();
    L8:
        if (this.f21473h == true) goto L10;
        return r1;
    L10:
        return o.m(r1, ".immediate");
    L11:
        return r0;
    }
}
