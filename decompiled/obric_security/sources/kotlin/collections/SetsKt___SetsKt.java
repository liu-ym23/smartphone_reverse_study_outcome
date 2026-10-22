package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

/* JADX INFO: compiled from: _Sets.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a,\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0003\u001a\u0002H\u0002H\u0086\u0002¢\u0006\u0002\u0010\u0004\u001a4\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0006H\u0086\u0002¢\u0006\u0002\u0010\u0007\u001a-\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\bH\u0086\u0002\u001a-\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\tH\u0086\u0002\u001a,\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0003\u001a\u0002H\u0002H\u0087\b¢\u0006\u0002\u0010\u0004\u001a,\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0003\u001a\u0002H\u0002H\u0086\u0002¢\u0006\u0002\u0010\u0004\u001a4\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0006H\u0086\u0002¢\u0006\u0002\u0010\u0007\u001a-\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\bH\u0086\u0002\u001a-\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\tH\u0086\u0002\u001a,\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0003\u001a\u0002H\u0002H\u0087\b¢\u0006\u0002\u0010\u0004¨\u0006\r"}, d2 = {"minus", "", ExifInterface.GPS_DIRECTION_TRUE, "element", "(Ljava/util/Set;Ljava/lang/Object;)Ljava/util/Set;", "elements", "", "(Ljava/util/Set;[Ljava/lang/Object;)Ljava/util/Set;", "", "Lkotlin/sequences/Sequence;", "minusElement", "plus", "plusElement", "kotlin-stdlib"}, k = 5, mv = {1, 8, 0}, xi = 49, xs = "kotlin/collections/SetsKt")
class SetsKt___SetsKt extends SetsKt__SetsKt {
    public SetsKt___SetsKt() {
    }

    public static final <T> Set<T> minus(Set<? extends T> r6, T r7) {
        Intrinsics.checkNotNullParameter(r6, "<this>");
        LinkedHashSet r0 = new LinkedHashSet(MapsKt.mapCapacity(r6.size()));
        Iterator<T> r8 = r6.iterator();
        boolean r2 = false;
    L4:
        if (r8.hasNext() == false) goto L13;
        T r3 = r8.next();
        boolean r4 = true;
        if (r2 == false) goto L8;
    L10:
        if (r4 == false) goto L4;
        r0.add(r3);
        goto L4
    L8:
        if (Intrinsics.areEqual(r3, r7) == false) goto L10;
        r2 = true;
        r4 = false;
        goto L10
    L13:
        return r0;
    }

    public static final <T> Set<T> minus(Set<? extends T> r1, T[] r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "elements");
        LinkedHashSet r0 = new LinkedHashSet(r1);
        CollectionsKt.removeAll(r0, r2);
        return r0;
    }

    public static final <T> Set<T> minus(Set<? extends T> r3, Iterable<? extends T> r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "elements");
        Collection<?> r5 = CollectionsKt.convertToListIfNotCollection(r4);
        if (r5.isEmpty() == false) goto L7;
        return CollectionsKt.toSet(r3);
    L7:
        if ((r5 instanceof Set) == false) goto L16;
        LinkedHashSet r0 = new LinkedHashSet();
        Iterator<T> r6 = r3.iterator();
    L10:
        if (r6.hasNext() == false) goto L15;
        T r1 = r6.next();
        if (r5.contains(r1) == true) goto L10;
        r0.add(r1);
        goto L10
    L15:
        return r0;
    L16:
        LinkedHashSet r2 = new LinkedHashSet(r3);
        r2.removeAll(r5);
        return r2;
    }

    public static final <T> Set<T> minus(Set<? extends T> r1, Sequence<? extends T> r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "elements");
        LinkedHashSet r0 = new LinkedHashSet(r1);
        CollectionsKt.removeAll(r0, r2);
        return r0;
    }

    private static final <T> Set<T> minusElement(Set<? extends T> r1, T r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return SetsKt.minus(r1, r2);
    }

    public static final <T> Set<T> plus(Set<? extends T> r2, T r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        LinkedHashSet r0 = new LinkedHashSet(MapsKt.mapCapacity(r2.size() + 1));
        r0.addAll(r2);
        r0.add(r3);
        return r0;
    }

    public static final <T> Set<T> plus(Set<? extends T> r3, T[] r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "elements");
        LinkedHashSet r0 = new LinkedHashSet(MapsKt.mapCapacity(r3.size() + r4.length));
        r0.addAll(r3);
        CollectionsKt.addAll(r0, r4);
        return r0;
    }

    public static final <T> Set<T> plus(Set<? extends T> r2, Iterable<? extends T> r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "elements");
        Integer r0 = CollectionsKt.collectionSizeOrNull(r3);
        if (r0 == null) goto L5;
        int r1 = r0.intValue();
        int r4 = r2.size() + r1;
    L6:
        LinkedHashSet r5 = new LinkedHashSet(MapsKt.mapCapacity(r4));
        r5.addAll(r2);
        CollectionsKt.addAll(r5, r3);
        return r5;
    L5:
        r4 = r2.size() * 2;
        goto L6
    }

    public static final <T> Set<T> plus(Set<? extends T> r2, Sequence<? extends T> r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "elements");
        LinkedHashSet r0 = new LinkedHashSet(MapsKt.mapCapacity(r2.size() * 2));
        r0.addAll(r2);
        CollectionsKt.addAll(r0, r3);
        return r0;
    }

    private static final <T> Set<T> plusElement(Set<? extends T> r1, T r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return SetsKt.plus(r1, r2);
    }
}
