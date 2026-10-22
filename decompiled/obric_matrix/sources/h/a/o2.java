package h.a;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0013\u0010\u0006\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0096\u0002R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lkotlinx/coroutines/ResumeOnCompletion;", "Lkotlinx/coroutines/JobNode;", "continuation", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/coroutines/Continuation;)V", "invoke", "cause", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
final class o2 extends e2 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final kotlin.k0.d<kotlin.f0> f17552j;

    /* JADX WARN: Multi-variable type inference failed */
    public o2(kotlin.k0.d<? super kotlin.f0> r1) {
        this.f17552j = r1;
    }

    @Override // h.a.a0
    public void C(Throwable r1) {
        kotlin.k0.d<kotlin.f0> r0 = this.f17552j;
        kotlin.v.a r2 = kotlin.v.f21457g;
        kotlin.f0 r3 = kotlin.f0.f18324a;
        kotlin.v.b(r3);
        r0.resumeWith(r3);
    }

    @Override // kotlin.n0.c.l
    public /* bridge */ /* synthetic */ kotlin.f0 invoke(Throwable r1) {
        C(r1);
        return kotlin.f0.f18324a;
    }
}
