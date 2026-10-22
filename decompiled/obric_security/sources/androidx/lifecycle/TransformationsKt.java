package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Transformations.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001f\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0087\b\u001a>\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0014\b\u0004\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00040\u0006H\u0087\bø\u0001\u0000\u001aF\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u001c\b\u0004\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u0002H\u0002\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\u0004\u0018\u00010\u00010\u0006H\u0087\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\b"}, d2 = {"distinctUntilChanged", "Landroidx/lifecycle/LiveData;", "X", "map", "Y", "transform", "Lkotlin/Function1;", "switchMap", "lifecycle-livedata-ktx_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class TransformationsKt {
    public static final <X, Y> LiveData<Y> map(LiveData<X> r1, final Function1<? super X, ? extends Y> r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "transform");
        LiveData<Y> r3 = Transformations.map(r1, new AnonymousClass1(r2));
        Intrinsics.checkNotNullExpressionValue(r3, "crossinline transform: (…p(this) { transform(it) }");
        return r3;
    }

    public static final <X, Y> LiveData<Y> switchMap(LiveData<X> r1, final Function1<? super X, ? extends LiveData<Y>> r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "transform");
        LiveData<Y> r3 = Transformations.switchMap(r1, new C01261(r2));
        Intrinsics.checkNotNullExpressionValue(r3, "crossinline transform: (…p(this) { transform(it) }");
        return r3;
    }

    public static final <X> LiveData<X> distinctUntilChanged(LiveData<X> r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        LiveData<X> r2 = Transformations.distinctUntilChanged(r1);
        Intrinsics.checkNotNullExpressionValue(r2, "distinctUntilChanged(this)");
        return r2;
    }
}
