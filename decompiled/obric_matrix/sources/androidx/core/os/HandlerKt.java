package androidx.core.os;

import android.os.Handler;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.n0.c.a;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a4\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u000e\b\u0004\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0086\bø\u0001\u0000\u001a4\u0010\n\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u000e\b\u0004\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\f"}, d2 = {"postAtTime", "Ljava/lang/Runnable;", "Landroid/os/Handler;", "uptimeMillis", "", "token", "", "action", "Lkotlin/Function0;", "", "postDelayed", "delayInMillis", "core-ktx_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class HandlerKt {
    public static final Runnable postAtTime(Handler r1, long r2, Object r4, a<f0> r5) {
        o.f(r1, "<this>");
        o.f(r5, "action");
        HandlerKt$postAtTime$runnable$1 r0 = new HandlerKt$postAtTime$runnable$1(r5);
        r1.postAtTime(r0, r4, r2);
        return r0;
    }

    public static /* synthetic */ Runnable postAtTime$default(Handler r0, long r1, Object r3, a r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L5;
        r3 = null;
    L5:
        o.f(r0, "<this>");
        o.f(r4, "action");
        HandlerKt$postAtTime$runnable$1 r7 = new HandlerKt$postAtTime$runnable$1(r4);
        r0.postAtTime(r7, r3, r1);
        return r7;
    }

    public static final Runnable postDelayed(Handler r1, long r2, Object r4, a<f0> r5) {
        o.f(r1, "<this>");
        o.f(r5, "action");
        HandlerKt$postDelayed$runnable$1 r0 = new HandlerKt$postDelayed$runnable$1(r5);
        if (r4 != null) goto L5;
        r1.postDelayed(r0, r2);
    L6:
        return r0;
    L5:
        HandlerCompat.postDelayed(r1, r0, r4, r2);
        goto L6
    }

    public static /* synthetic */ Runnable postDelayed$default(Handler r0, long r1, Object r3, a r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L5;
        r3 = null;
    L5:
        o.f(r0, "<this>");
        o.f(r4, "action");
        HandlerKt$postDelayed$runnable$1 r7 = new HandlerKt$postDelayed$runnable$1(r4);
        if (r3 != null) goto L8;
        r0.postDelayed(r7, r1);
    L9:
        return r7;
    L8:
        HandlerCompat.postDelayed(r0, r7, r3, r1);
        goto L9
    }
}
