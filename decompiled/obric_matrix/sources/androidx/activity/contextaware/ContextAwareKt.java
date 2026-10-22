package androidx.activity.contextaware;

import android.content.Context;
import h.a.o;
import kotlin.Metadata;
import kotlin.k0.d;
import kotlin.k0.i.b;
import kotlin.k0.j.a.h;
import kotlin.n0.c.l;
import kotlin.n0.d.n;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a1\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\u0014\b\u0004\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\u00010\u0004H\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007"}, d2 = {"withContextAvailable", "R", "Landroidx/activity/contextaware/ContextAware;", "onContextAvailable", "Lkotlin/Function1;", "Landroid/content/Context;", "(Landroidx/activity/contextaware/ContextAware;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "activity-ktx_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class ContextAwareKt {
    public static final <R> Object withContextAvailable(ContextAware r3, l<? super Context, ? extends R> r4, d<? super R> r5) {
        Context r0 = r3.peekAvailableContext();
        if (r0 != null) goto L5;
        o r1 = new o(b.b(r5), 1);
        r1.A();
        ContextAwareKt$withContextAvailable$2$listener$1 r2 = new ContextAwareKt$withContextAvailable$2$listener$1(r1, r4);
        r3.addOnContextAvailableListener(r2);
        r1.h(new ContextAwareKt$withContextAvailable$2$1(r3, r2));
        Object r6 = r1.x();
        if (r6 != b.c()) goto L9;
        h.c(r5);
    L9:
        return r6;
    L5:
        return r4.invoke(r0);
    }

    private static final <R> Object withContextAvailable$$forInline(ContextAware r3, l<? super Context, ? extends R> r4, d<? super R> r5) {
        Context r0 = r3.peekAvailableContext();
        if (r0 != null) goto L5;
        n.c(0);
        o r1 = new o(b.b(r5), 1);
        r1.A();
        ContextAwareKt$withContextAvailable$2$listener$1 r2 = new ContextAwareKt$withContextAvailable$2$listener$1(r1, r4);
        r3.addOnContextAvailableListener(r2);
        r1.h(new ContextAwareKt$withContextAvailable$2$1(r3, r2));
        Object r6 = r1.x();
        if (r6 != b.c()) goto L9;
        h.c(r5);
    L9:
        n.c(1);
        return r6;
    L5:
        return r4.invoke(r0);
    }
}
