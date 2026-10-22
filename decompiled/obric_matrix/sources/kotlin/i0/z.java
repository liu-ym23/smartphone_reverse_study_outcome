package kotlin.i0;

import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001\u001a#\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0007¢\u0006\u0002\b\u0004\u001a\u001d\u0010\u0005\u001a\u00020\u0006*\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0002\b\b\u001a\u001d\u0010\t\u001a\u00020\u0006*\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0002\b\n¨\u0006\u000b"}, d2 = {"asReversed", "", "T", "", "asReversedMutable", "reverseElementIndex", "", "index", "reverseElementIndex$CollectionsKt__ReversedViewsKt", "reversePositionIndex", "reversePositionIndex$CollectionsKt__ReversedViewsKt", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xi = 49, xs = "kotlin/collections/CollectionsKt")
class z extends y {
    public static final /* synthetic */ int B(List r0, int r1) {
        return E(r0, r1);
    }

    public static final /* synthetic */ int C(List r0, int r1) {
        return F(r0, r1);
    }

    public static <T> List<T> D(List<T> r1) {
        kotlin.n0.d.o.f(r1, "<this>");
        return new s0(r1);
    }

    private static final int E(List<?> r4, int r5) {
        if (new kotlin.r0.d(0, r.i(r4)).m(r5) == false) goto L7;
        return r.i(r4) - r5;
    L7:
        throw new IndexOutOfBoundsException("Element index " + r5 + " must be in range [" + new kotlin.r0.d(0, r.i(r4)) + "].");
    }

    private static final int F(List<?> r4, int r5) {
        if (new kotlin.r0.d(0, r4.size()).m(r5) == false) goto L7;
        return r4.size() - r5;
    L7:
        throw new IndexOutOfBoundsException("Position index " + r5 + " must be in range [" + new kotlin.r0.d(0, r4.size()) + "].");
    }
}
