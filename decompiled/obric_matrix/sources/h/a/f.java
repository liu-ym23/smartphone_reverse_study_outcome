package h.a;

import androidx.core.location.LocationRequestCompat;
import com.bytedance.common.wschannel.WsConstants;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014J\u000b\u0010\u0011\u001a\u00028\u0000¢\u0006\u0002\u0010\u0012R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000b8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\f¨\u0006\u0013"}, d2 = {"Lkotlinx/coroutines/BlockingCoroutine;", "T", "Lkotlinx/coroutines/AbstractCoroutine;", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "blockedThread", "Ljava/lang/Thread;", "eventLoop", "Lkotlinx/coroutines/EventLoop;", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Thread;Lkotlinx/coroutines/EventLoop;)V", "isScopedCoroutine", "", "()Z", "afterCompletion", "", WsConstants.KEY_CONNECTION_STATE, "", "joinBlocking", "()Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
final class f<T> extends a<T> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Thread f17342h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final h1 f17343i;

    public f(kotlin.k0.g r2, Thread r3, h1 r4) {
        super(r2, true, true);
        this.f17342h = r3;
        this.f17343i = r4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final T P0() {
        b r0 = c.a();
        if (r0 == null) goto L55;
        r0.c();
    L55:
        h1 r1 = this.f17343i;     // Catch: Throwable -> L47
        y r3 = null;
        if (r1 == null) goto L53;
        h1.n0(r1, false, 1, null);     // Catch: Throwable -> L47
    L53:
    L41:
        th = move-exception;
        h1 r6 = this.f17343i;     // Catch: Throwable -> L47
        if (r6 == null) goto L46;
        h1.i0(r6, false, 1, null);     // Catch: Throwable -> L47
    L46:
        throw th;     // Catch: Throwable -> L47
    L11:
        if (Thread.interrupted() == true) goto L39;
        h1 r2 = this.f17343i;     // Catch: Throwable -> L41
        if (r2 != null) goto L15;
        long r4 = LocationRequestCompat.PASSIVE_INTERVAL;
    L17:
        if (j0() == true) goto L18;
        b r5 = c.a();     // Catch: Throwable -> L41
        if (r5 != null) goto L36;
        kotlin.f0 r7 = null;
    L37:
        if (r7 != null) goto L53;
        LockSupport.parkNanos(this, r4);     // Catch: Throwable -> L41
        goto L53
    L36:
        r5.b(this, r4);     // Catch: Throwable -> L41
        r7 = kotlin.f0.f18324a;     // Catch: Throwable -> L41
        goto L37
    L18:
        h1 r8 = this.f17343i;     // Catch: Throwable -> L47
        if (r8 == null) goto L22;
        h1.i0(r8, false, 1, null);     // Catch: Throwable -> L47
    L22:
        b r9 = c.a();
        if (r9 == null) goto L26;
        r9.g();
    L26:
        T r10 = (T) g2.h(c0());
        if ((r10 instanceof y) == false) goto L29;
        r3 = (y) r10;
    L29:
        if (r3 != null) goto L32;
        return r10;
    L32:
        throw r3.f17588a;
    L15:
        r4 = r2.q0();     // Catch: Throwable -> L41
        goto L17
    L39:
        InterruptedException r11 = new InterruptedException();     // Catch: Throwable -> L41
        y(r11);     // Catch: Throwable -> L41
        throw r11;     // Catch: Throwable -> L41
    L47:
        th = move-exception;
        b r12 = c.a();
        if (r12 == null) goto L52;
        r12.g();
    L52:
        throw th;
    }

    @Override // h.a.f2
    protected boolean k0() {
        return true;
    }

    @Override // h.a.f2
    protected void w(Object r2) {
        if (kotlin.n0.d.o.a(Thread.currentThread(), this.f17342h) == true) goto L11;
        Thread r1 = this.f17342h;
        b r3 = c.a();
        if (r3 != null) goto L7;
        kotlin.f0 r4 = null;
    L8:
        if (r4 != null) goto L12;
        LockSupport.unpark(r1);
        return;
    L12:
        return;
    L7:
        r3.f(r1);
        r4 = kotlin.f0.f18324a;
        goto L8
    }
}
