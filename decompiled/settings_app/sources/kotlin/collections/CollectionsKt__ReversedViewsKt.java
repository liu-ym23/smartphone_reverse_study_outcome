package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: compiled from: ReversedViews.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001\u001a#\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0007¢\u0006\u0002\b\u0004\u001a\u001d\u0010\u0005\u001a\u00020\u0006*\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0002\b\b\u001a\u001d\u0010\t\u001a\u00020\u0006*\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0002\b\n\u001a\u001d\u0010\u000b\u001a\u00020\u0006*\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0002\b\f¨\u0006\r"}, d2 = {"asReversed", "", ExifInterface.GPS_DIRECTION_TRUE, "", "asReversedMutable", "reverseElementIndex", "", "index", "reverseElementIndex$CollectionsKt__ReversedViewsKt", "reverseIteratorIndex", "reverseIteratorIndex$CollectionsKt__ReversedViewsKt", "reversePositionIndex", "reversePositionIndex$CollectionsKt__ReversedViewsKt", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/collections/CollectionsKt")
class CollectionsKt__ReversedViewsKt extends CollectionsKt__MutableCollectionsKt {
    public CollectionsKt__ReversedViewsKt() {
    }

    public static final /* synthetic */ int access$reverseElementIndex(List r0, int r1) {
        return reverseElementIndex$CollectionsKt__ReversedViewsKt(r0, r1);
    }

    public static final /* synthetic */ int access$reverseIteratorIndex(List r0, int r1) {
        return reverseIteratorIndex$CollectionsKt__ReversedViewsKt(r0, r1);
    }

    public static final /* synthetic */ int access$reversePositionIndex(List r0, int r1) {
        return reversePositionIndex$CollectionsKt__ReversedViewsKt(r0, r1);
    }

    private static final int reverseElementIndex$CollectionsKt__ReversedViewsKt(List<?> r4, int r5) {
        if (new IntRange(0, CollectionsKt.getLastIndex(r4)).contains(r5) == false) goto L7;
        return CollectionsKt.getLastIndex(r4) - r5;
    L7:
        throw new IndexOutOfBoundsException("Element index " + r5 + " must be in range [" + new IntRange(0, CollectionsKt.getLastIndex(r4)) + "].");
    }

    private static final int reversePositionIndex$CollectionsKt__ReversedViewsKt(List<?> r4, int r5) {
        if (new IntRange(0, r4.size()).contains(r5) == false) goto L7;
        return r4.size() - r5;
    L7:
        throw new IndexOutOfBoundsException("Position index " + r5 + " must be in range [" + new IntRange(0, r4.size()) + "].");
    }

    private static final int reverseIteratorIndex$CollectionsKt__ReversedViewsKt(List<?> r0, int r1) {
        return CollectionsKt.getLastIndex(r0) - r1;
    }

    public static final <T> List<T> asReversed(List<? extends T> r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return new ReversedListReadOnly(r1);
    }

    public static final <T> List<T> asReversedMutable(List<T> r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return new ReversedList(r1);
    }
}
