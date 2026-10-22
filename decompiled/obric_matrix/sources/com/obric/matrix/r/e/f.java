package com.obric.matrix.r.e;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.f0;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u001f\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J9\u0010\u0003\u001a\u0002H\u0004\"\u0004\b\u0000\u0010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u000e\b\u0004\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00040\tH\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\nJI\u0010\u000b\u001a\u0002H\u0004\"\u0004\b\u0000\u0010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u001e\b\u0004\u0010\b\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\fH\u0086Hø\u0001\u0001¢\u0006\u0002\u0010\u000eJ%\u0010\u000f\u001a\u00020\u0010\"\u0004\b\u0000\u0010\u0004*\n\u0012\u0004\u0012\u0002H\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u0002H\u0004¢\u0006\u0002\u0010\u0013J\u001e\u0010\u0014\u001a\u0004\u0018\u0001H\u0004\"\u0006\b\u0000\u0010\u0004\u0018\u0001*\u0004\u0018\u00010\u0001H\u0086\b¢\u0006\u0002\u0010\u0015J,\u0010\u0016\u001a\u00020\u0010\"\u0004\b\u0000\u0010\u0004*\n\u0012\u0004\u0012\u0002H\u0004\u0018\u00010\u00172\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u00020\u00100\f\u0082\u0002\u000b\n\u0005\b\u009920\u0001\n\u0002\b\u0019¨\u0006\u0019"}, d2 = {"Lcom/obric/matrix/common_utils/utils/KtExt;", "", "()V", "statTimeCost", "T", LocationMonitorConst.TAG, "", "signature", "block", "Lkotlin/Function0;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "statTimeCostSuspend", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addIfAbsent", "", "", "item", "(Ljava/util/Collection;Ljava/lang/Object;)V", "safeCastTo", "(Ljava/lang/Object;)Ljava/lang/Object;", "traverseSafely", "", "action", "common_utils_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f9940a = null;

    static {
        f9940a = new f();
    }

    private f() {
    }

    public final <T> void a(Collection<T> r1, T r2) {
        if (r1 != null) goto L5;
        return;
    L5:
        if (r1.contains(r2) == true) goto L8;
        r1.add(r2);
        return;
    }

    public final <T> void b(Collection<? extends T> r2, kotlin.n0.c.l<? super T, f0> r3) {
        kotlin.n0.d.o.f(r3, "action");
        if (r2 != null) goto L5;
        return;
    L5:
        Iterator<? extends T> r1 = r2.iterator();
    L7:
        if (r1.hasNext() == false) goto L14;
        T r4 = r1.next();
        if (r4 == null) goto L7;
        r3.invoke(r4);     // Catch: Exception -> L12
    L12:
        e = move-exception;
        com.obric.matrix.r.c.c.h("traverse action invoke error", e);
        goto L7
    }
}
