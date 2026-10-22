package wt;

import ai.j0;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.CancellationException;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.time.DurationKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.l;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.t0;
import kotlinx.coroutines.v1;
import s8.h;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends MainCoroutineDispatcher implements o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f22904a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f22905b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f22906c;
    public final d d;

    public d(Handler r5, String r10, boolean r11) {
        this.f22904a = r5;
        this.f22905b = r10;
        this.f22906c = r11;
        if (r11 == false) goto L5;
        d r12 = this;
    L6:
        this.d = r12;
        return;
    L5:
        r12 = new d(r5, r10, true);
        goto L6
    }

    @Override // kotlinx.coroutines.z
    public final void dispatch(CoroutineContext r5, Runnable r10) {
        if (this.f22904a.post(r10) == true) goto L6;
        g(r5, r10);
        return;
    }

    @Override // kotlinx.coroutines.o0
    public final t0 e(long r5, final Runnable r10, CoroutineContext r11) {
        long r12 = RangesKt.coerceAtMost(r5, DurationKt.MAX_MILLIS);
        if (this.f22904a.postDelayed(r10, r12) == true) goto L5;
        g(r11, r10);
        return v1.f19027a;
    L5:
        return new c(this, r10);
    }

    public final boolean equals(Object r5) {
        if ((r5 instanceof d) == false) goto L9;
        d r10 = (d) r5;
        if (r10.f22904a != this.f22904a) goto L9;
        if (r10.f22906c != this.f22906c) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // kotlinx.coroutines.o0
    public final void f(long r5, l r10) {
        h r11 = new h(6, r10, false, this);
        long r12 = RangesKt.coerceAtMost(r5, DurationKt.MAX_MILLIS);
        if (this.f22904a.postDelayed(r11, r12) == false) goto L5;
        r10.y(new com.bytedance.ai.model.widgets.d(16, this, r11));
        return;
    L5:
        g(r10.e, r11);
    }

    public final void g(CoroutineContext r5, Runnable r10) {
        CancellationException r11 = new CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed");
        Job r12 = (Job) r5.get(Job.Key);
        if (r12 == null) goto L5;
        r12.cancel(r11);
    L5:
        Dispatchers.getIO().dispatch(r5, r10);
    }

    @Override // kotlinx.coroutines.MainCoroutineDispatcher
    public final MainCoroutineDispatcher getImmediate() {
        return this.d;
    }

    public final int hashCode() {
        int r5 = System.identityHashCode(this.f22904a);
        if (this.f22906c == false) goto L5;
        int r10 = 1231;
    L7:
        return r10 ^ r5;
    L5:
        r10 = 1237;
        goto L7
    }

    @Override // kotlinx.coroutines.z
    public final boolean isDispatchNeeded(CoroutineContext r5) {
        if (this.f22906c == true) goto L5;
    L8:
        return true;
    L5:
        if (Intrinsics.areEqual(Looper.myLooper(), this.f22904a.getLooper()) == false) goto L8;
        return false;
    }

    @Override // kotlinx.coroutines.MainCoroutineDispatcher, kotlinx.coroutines.z
    public final String toString() {
        String r5 = toStringInternalImpl();
        if (r5 != null) goto L11;
        String r10 = this.f22905b;
        if (r10 != null) goto L8;
        r10 = this.f22904a.toString();
    L8:
        if (this.f22906c == true) goto L10;
        return r10;
    L10:
        return j0.j(r10, ".immediate");
    L11:
        return r5;
    }

    public d(Handler r5) {
        this(r5, null, false);
    }
}
