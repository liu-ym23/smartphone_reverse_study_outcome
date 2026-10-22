package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.n0.c.l;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001aB\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0014\b\u0004\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003H\u0086\b¢\u0006\u0004\b\u0005\u0010\u0006\u001aH\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\u001a\b\u0004\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00020\u0003H\u0086\b¢\u0006\u0004\b\u0007\u0010\u0006\u001a&\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0086\b¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"X", "Y", "Landroidx/lifecycle/LiveData;", "Lkotlin/Function1;", "transform", "map", "(Landroidx/lifecycle/LiveData;Lkotlin/n0/c/l;)Landroidx/lifecycle/LiveData;", "switchMap", "distinctUntilChanged", "(Landroidx/lifecycle/LiveData;)Landroidx/lifecycle/LiveData;", "lifecycle-livedata-ktx_release"}, k = 2, mv = {1, 1, 15})
public final class TransformationsKt {
    public static final <X> LiveData<X> distinctUntilChanged(LiveData<X> r1) {
        o.g(r1, "$this$distinctUntilChanged");
        LiveData<X> r2 = Transformations.distinctUntilChanged(r1);
        o.b(r2, "Transformations.distinctUntilChanged(this)");
        return r2;
    }

    public static final <X, Y> LiveData<Y> map(LiveData<X> r1, final l<? super X, ? extends Y> r2) {
        o.g(r1, "$this$map");
        o.g(r2, "transform");
        LiveData<Y> r3 = Transformations.map(r1, new AnonymousClass1(r2));
        o.b(r3, "Transformations.map(this) { transform(it) }");
        return r3;
    }

    public static final <X, Y> LiveData<Y> switchMap(LiveData<X> r1, final l<? super X, ? extends LiveData<Y>> r2) {
        o.g(r1, "$this$switchMap");
        o.g(r2, "transform");
        LiveData<Y> r3 = Transformations.switchMap(r1, new C06301(r2));
        o.b(r3, "Transformations.switchMap(this) { transform(it) }");
        return r3;
    }
}
