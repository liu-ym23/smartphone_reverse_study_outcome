package kotlin.collections;

import android.icu.text.PluralRules;
import androidx.exifinterface.media.ExifInterface;
import com.android.settings.fuelgauge.PowerUsageDetail;
import com.bytedance.apm.constant.PerfConsts;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.apache.commons.math3.geometry.VectorFormat;

/* JADX INFO: compiled from: AbstractMap.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010&\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\b'\u0018\u0000 )*\u0004\b\u0000\u0010\u0001*\u0006\b\u0001\u0010\u0002 \u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003:\u0001)B\u0007\b\u0004¢\u0006\u0002\u0010\u0004J\u001f\u0010\u0013\u001a\u00020\u00142\u0010\u0010\u0015\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u0016H\u0000¢\u0006\u0002\b\u0017J\u0015\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001aJ\u0015\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001d\u001a\u00020\u00142\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0096\u0002J\u0018\u0010 \u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0019\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010!J\b\u0010\"\u001a\u00020\rH\u0016J#\u0010#\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00162\u0006\u0010\u0019\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010$J\b\u0010%\u001a\u00020\u0014H\u0016J\b\u0010&\u001a\u00020'H\u0016J\u0012\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u001fH\u0002J\u001c\u0010&\u001a\u00020'2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0016H\bR\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\bX\u0088\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00010\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006*"}, d2 = {"Lkotlin/collections/AbstractMap;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "()V", "_keys", "", "_values", "", "keys", "getKeys", "()Ljava/util/Set;", PerfConsts.PERF_DISK_FILE_SIZE, "", "getSize", "()I", PowerUsageDetail.EXTRA_DETAIL_VALUES, "getValues", "()Ljava/util/Collection;", "containsEntry", "", "entry", "", "containsEntry$kotlin_stdlib", "containsKey", "key", "(Ljava/lang/Object;)Z", "containsValue", "value", "equals", PluralRules.KEYWORD_OTHER, "", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "hashCode", "implFindEntry", "(Ljava/lang/Object;)Ljava/util/Map$Entry;", "isEmpty", "toString", "", "o", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class AbstractMap<K, V> implements Map<K, V>, KMappedMarker {
    public static final Companion Companion = null;
    private volatile Set<? extends K> _keys;
    private volatile Collection<? extends V> _values;

    /* JADX INFO: compiled from: AbstractMap.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010&\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J'\u0010\u0003\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001H\u0000¢\u0006\u0002\b\bJ\u001d\u0010\t\u001a\u00020\n2\u000e\u0010\u0005\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0006H\u0000¢\u0006\u0002\b\u000bJ\u001d\u0010\f\u001a\u00020\r2\u000e\u0010\u0005\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0006H\u0000¢\u0006\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lkotlin/collections/AbstractMap$Companion;", "", "()V", "entryEquals", "", "e", "", PluralRules.KEYWORD_OTHER, "entryEquals$kotlin_stdlib", "entryHashCode", "", "entryHashCode$kotlin_stdlib", "entryToString", "", "entryToString$kotlin_stdlib", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final int entryHashCode$kotlin_stdlib(Map.Entry<?, ?> r2) {
            Intrinsics.checkNotNullParameter(r2, "e");
            Object r1 = r2.getKey();
            int r0 = 0;
            if (r1 == null) goto L5;
            int r3 = r1.hashCode();
        L6:
            Object r4 = r2.getValue();
            if (r4 == null) goto L10;
            r0 = r4.hashCode();
        L10:
            return r3 ^ r0;
        L5:
            r3 = 0;
            goto L6
        }

        public final String entryToString$kotlin_stdlib(Map.Entry<?, ?> r2) {
            Intrinsics.checkNotNullParameter(r2, "e");
            return new StringBuilder().append(r2.getKey()).append('=').append(r2.getValue()).toString();
        }

        public final boolean entryEquals$kotlin_stdlib(Map.Entry<?, ?> r3, Object r4) {
            Intrinsics.checkNotNullParameter(r3, "e");
            if ((r4 instanceof Map.Entry) == true) goto L5;
            return false;
        L5:
            Map.Entry r5 = (Map.Entry) r4;
            if (Intrinsics.areEqual(r3.getKey(), r5.getKey()) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(r3.getValue(), r5.getValue()) == false) goto L12;
            return true;
        L12:
            return false;
        }
    }

    static {
        Companion = new Companion(null);
    }

    @Override // java.util.Map
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public abstract Set getEntries();

    @Override // java.util.Map
    public V put(K r1, V r2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> r1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public V remove(Object r1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    protected AbstractMap() {
    }

    public static final /* synthetic */ String access$toString(AbstractMap r0, Map.Entry r1) {
        return r0.toString(r1);
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return getEntries();
    }

    @Override // java.util.Map
    public final /* bridge */ Set<K> keySet() {
        return getKeys();
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<V> values() {
        return getValues();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public boolean containsKey(Object r1) {
        if (implFindEntry(r1) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Map
    public boolean containsValue(Object r3) {
        Set<Map.Entry<K, V>> r2 = entrySet();
        if ((r2 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r4 = r2.iterator();
    L9:
        if (r4.hasNext() == false) goto L18;
        if (Intrinsics.areEqual(((Map.Entry) r4.next()).getValue(), r3) == false) goto L9;
        return true;
    L18:
        return false;
    L5:
        if (r2.isEmpty() == false) goto L7;
        return false;
    }

    public final boolean containsEntry$kotlin_stdlib(Map.Entry<?, ?> r4) {
        if (r4 != null) goto L5;
        return false;
    L5:
        Object r1 = r4.getKey();
        Object r5 = r4.getValue();
        AbstractMap<K, V> r3 = this;
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.get, V of kotlin.collections.MapsKt__MapsKt.get>");
        V r2 = r3.get(r1);
        if (Intrinsics.areEqual(r5, r2) == true) goto L8;
        return false;
    L8:
        if (r2 != null) goto L12;
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.containsKey, *>");
        if (r3.containsKey(r1) == true) goto L14;
        return false;
    L14:
        return true;
    L12:
        return true;
    }

    @Override // java.util.Map
    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof Map) == true) goto L8;
        return false;
    L8:
        Map r6 = (Map) r5;
        if (size() == r6.size()) goto L11;
        return false;
    L11:
        Set<Map.Entry<K, V>> r7 = r6.entrySet();
        if ((r7 instanceof Collection) == true) goto L14;
    L16:
        Iterator<T> r8 = r7.iterator();
    L18:
        if (r8.hasNext() == false) goto L27;
        if (containsEntry$kotlin_stdlib((Map.Entry) r8.next()) == true) goto L18;
        return false;
    L27:
        return true;
    L14:
        if (r7.isEmpty() == false) goto L16;
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public V get(Object r1) {
        Map.Entry<K, V> r0 = implFindEntry(r1);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getValue();
    }

    @Override // java.util.Map
    public int hashCode() {
        return entrySet().hashCode();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        if (size() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public int getSize() {
        return entrySet().size();
    }

    public Set<K> getKeys() {
        if (this._keys != null) goto L5;
        this._keys = new AbstractMap$keys$1(this);
    L5:
        Set<? extends K> r1 = this._keys;
        Intrinsics.checkNotNull(r1);
        return r1;
    }

    public String toString() {
        return CollectionsKt.joinToString$default(entrySet(), ", ", VectorFormat.DEFAULT_PREFIX, VectorFormat.DEFAULT_SUFFIX, 0, null, new AnonymousClass1(this), 24, null);
    }

    private final String toString(Map.Entry<? extends K, ? extends V> r3) {
        return toString(r3.getKey()) + '=' + toString(r3.getValue());
    }

    private final String toString(Object r1) {
        if (r1 != this) goto L5;
        return "(this Map)";
    L5:
        return String.valueOf(r1);
    }

    public Collection<V> getValues() {
        if (this._values != null) goto L5;
        this._values = new C03251(this);
    L5:
        Collection<? extends V> r1 = this._values;
        Intrinsics.checkNotNull(r1);
        return r1;
    }

    private final Map.Entry<K, V> implFindEntry(K r3) {
        Iterator<T> r2 = entrySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        Object r0 = r2.next();
        if (Intrinsics.areEqual(((Map.Entry) r0).getKey(), r3) == false) goto L4;
    L10:
        return (Map.Entry) r0;
    L8:
        r0 = null;
        goto L10
    }
}
