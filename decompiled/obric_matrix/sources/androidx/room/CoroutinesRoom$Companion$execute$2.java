package androidx.room;

import h.a.m0;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.k0.d;
import kotlin.k0.i.b;
import kotlin.k0.j.a.f;
import kotlin.k0.j.a.l;
import kotlin.n0.c.p;
import kotlin.n0.d.o;
import kotlin.w;

/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX INFO: loaded from: classes.dex */
@f(c = "androidx.room.CoroutinesRoom$Companion$execute$2", f = "CoroutinesRoom.kt", l = {}, m = "invokeSuspend")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0005\u001a\n \u0002*\u0004\u0018\u00018\u00008\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"R", "Lh/a/m0;", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 1, 15})
final class CoroutinesRoom$Companion$execute$2<R> extends l implements p<m0, d<? super R>, Object> {
    final /* synthetic */ Callable $callable;
    int label;
    private m0 p$;

    CoroutinesRoom$Companion$execute$2(Callable r1, d r2) {
        this.$callable = r1;
        super(2, r2);
    }

    @Override // kotlin.k0.j.a.a
    public final d<f0> create(Object r2, d<?> r3) {
        o.g(r3, "completion");
        CoroutinesRoom$Companion$execute$2 r0 = new CoroutinesRoom$Companion$execute$2(this.$callable, r3);
        r0.p$ = (m0) r2;
        return r0;
    }

    @Override // kotlin.n0.c.p
    public final Object invoke(m0 r1, Object r2) {
        return ((CoroutinesRoom$Companion$execute$2) create(r1, (d) r2)).invokeSuspend(f0.f18324a);
    }

    @Override // kotlin.k0.j.a.a
    public final Object invokeSuspend(Object r2) {
        b.c();
        if (this.label != 0) goto L7;
        w.b(r2);
        return this.$callable.call();
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
