package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.k0.j.a.d;
import kotlin.k0.j.a.f;

/* JADX INFO: loaded from: classes.dex */
@f(c = "androidx.lifecycle.CoroutineLiveData", f = "CoroutineLiveData.kt", l = {234}, m = "clearSource$lifecycle_livedata_ktx_release")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\"\u0004\b\u0000\u0010\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0080@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"T", "Lkotlin/k0/d;", "Lkotlin/f0;", "continuation", "", "clearSource", "(Lkotlin/k0/d;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 15})
final class CoroutineLiveData$clearSource$1 extends d {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CoroutineLiveData this$0;

    CoroutineLiveData$clearSource$1(CoroutineLiveData r1, kotlin.k0.d r2) {
        this.this$0 = r1;
        super(r2);
    }

    @Override // kotlin.k0.j.a.a
    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.clearSource$lifecycle_livedata_ktx_release(this);
    }
}
