package coil.util;

import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: renamed from: coil.util.-Collections, reason: invalid class name */
/* JADX INFO: compiled from: Collections.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000H\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0010&\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a<\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u00010\u0005H\u0080\b¢\u0006\u0002\u0010\u0006\u001aF\u0010\u0007\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0001\"\u0004\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00010\u00032\u0006\u0010\b\u001a\u0002H\u00022\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\nH\u0080\b¢\u0006\u0002\u0010\u000b\u001a3\u0010\f\u001a\u00020\r\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00032\u0018\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\r0\nH\u0080\b\u001a-\u0010\u0010\u001a\u00020\r\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00032\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\r0\u0005H\u0080\b\u001a]\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u00020\u0012\"\u0004\b\u0000\u0010\u0013\"\u0004\b\u0001\u0010\u0014\"\b\b\u0002\u0010\u0002*\u00020\u0015*\u000e\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u00140\u00122 \u0010\u0004\u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u00140\u0016\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0005H\u0080\b\u001a-\u0010\u0017\u001a\u00020\r\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00182\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u001a0\u0005H\u0080\b\u001a\u001e\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0003\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0003H\u0000\u001a0\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u00140\u0012\"\u0004\b\u0000\u0010\u0013\"\u0004\b\u0001\u0010\u0014*\u000e\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u00140\u0012H\u0000¨\u0006\u001d"}, d2 = {"firstNotNullOfOrNullIndices", ExifInterface.GPS_DIRECTION_TRUE, "R", "", "transform", "Lkotlin/Function1;", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "foldIndices", "initial", "operation", "Lkotlin/Function2;", "(Ljava/util/List;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "forEachIndexedIndices", "", "action", "", "forEachIndices", "mapNotNullValues", "", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "", "removeIfIndices", "", "predicate", "", "toImmutableList", "toImmutableMap", "coil-base_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class Collections {
    public static final <T> void forEachIndices(List<? extends T> r3, Function1<? super T, Unit> r4) {
        int r0 = r3.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r4.invoke(r3.get(r1));
        r1 = r1 + 1;
        goto L3
    }

    public static final <T> void forEachIndexedIndices(List<? extends T> r4, Function2<? super Integer, ? super T, Unit> r5) {
        int r0 = r4.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r5.invoke(Integer.valueOf(r1), r4.get(r1));
        r1 = r1 + 1;
        goto L3
    }

    public static final <T, R> R foldIndices(List<? extends T> r3, R r4, Function2<? super R, ? super T, ? extends R> r5) {
        int r0 = r3.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        R r6 = r4;
        r4 = r5.invoke(r6, r3.get(r1));
        r1 = r1 + 1;
        goto L3
    L5:
        return r4;
    }

    public static final <R, T> T firstNotNullOfOrNullIndices(List<? extends R> r3, Function1<? super R, ? extends T> r4) {
        int r0 = r3.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        T r2 = r4.invoke(r3.get(r1));
        if (r2 != null) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return r2;
    L8:
        return null;
    }

    public static final <T> void removeIfIndices(List<T> r5, Function1<? super T, Boolean> r6) {
        int r0 = r5.size();
        int r1 = 0;
        int r2 = 0;
    L3:
        if (r1 >= r0) goto L8;
        int r3 = r1 - r2;
        if (r6.invoke(r5.get(r3)).booleanValue() == false) goto L7;
        r5.remove(r3);
        r2 = r2 + 1;
    L7:
        r1 = r1 + 1;
        goto L3
    }

    public static final <K, V, R> Map<K, R> mapNotNullValues(Map<K, ? extends V> r3, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> r4) {
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator<Map.Entry<K, ? extends V>> r5 = r3.entrySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        Map.Entry<K, ? extends V> r1 = r5.next();
        R r2 = r4.invoke(r1);
        if (r2 == null) goto L4;
        r0.put(r1.getKey(), r2);
        goto L4
    L8:
        return r0;
    }

    public static final <K, V> Map<K, V> toImmutableMap(Map<K, ? extends V> r2) {
        int r0 = r2.size();
        if (r0 == 0) goto L9;
        if (r0 != 1) goto L10;
        Map.Entry r3 = (Map.Entry) CollectionsKt.first(r2.entrySet());
        return java.util.Collections.singletonMap(r3.getKey(), r3.getValue());
    L10:
        return java.util.Collections.unmodifiableMap(new LinkedHashMap(r2));
    L9:
        return MapsKt.emptyMap();
    }

    public static final <T> List<T> toImmutableList(List<? extends T> r2) {
        int r0 = r2.size();
        if (r0 == 0) goto L9;
        if (r0 == 1) goto L11;
        return java.util.Collections.unmodifiableList(new ArrayList(r2));
    L11:
        return java.util.Collections.singletonList(CollectionsKt.first(r2));
    L9:
        return CollectionsKt.emptyList();
    }
}
