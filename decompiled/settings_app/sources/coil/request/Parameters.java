package coil.request;

import android.icu.text.PluralRules;
import androidx.exifinterface.media.ExifInterface;
import coil.util.Collections;
import com.android.settings.fuelgauge.PowerUsageDetail;
import com.android.settings.search.IndexDatabaseHelper;
import com.bytedance.apm.constant.PerfConsts;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: compiled from: Parameters.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010(\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000  2\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001:\u0003\u001f !B\u0007\b\u0016¢\u0006\u0002\u0010\u0005B\u001b\b\u0002\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\u0003J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0002J\b\u0010\u0012\u001a\u00020\nH\u0016J\u0006\u0010\u0013\u001a\u00020\u000fJ\u001b\u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0015H\u0096\u0002J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u00032\u0006\u0010\r\u001a\u00020\u0003J\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007J\u0006\u0010\u0018\u001a\u00020\u0019J\b\u0010\u001a\u001a\u00020\u0003H\u0016J\u001f\u0010\u001b\u001a\u0004\u0018\u0001H\u001c\"\b\b\u0000\u0010\u001c*\u00020\u00112\u0006\u0010\r\u001a\u00020\u0003¢\u0006\u0002\u0010\u001dJ\u0014\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0007R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n8G¢\u0006\u0006\u001a\u0004\b\t\u0010\u000b¨\u0006\""}, d2 = {"Lcoil/request/Parameters;", "", "Lkotlin/Pair;", "", "Lcoil/request/Parameters$Entry;", "()V", "entries", "", "(Ljava/util/Map;)V", PerfConsts.PERF_DISK_FILE_SIZE, "", "()I", "entry", "key", "equals", "", PluralRules.KEYWORD_OTHER, "", "hashCode", "isEmpty", "iterator", "", "memoryCacheKey", "memoryCacheKeys", "newBuilder", "Lcoil/request/Parameters$Builder;", "toString", "value", ExifInterface.GPS_DIRECTION_TRUE, "(Ljava/lang/String;)Ljava/lang/Object;", PowerUsageDetail.EXTRA_DETAIL_VALUES, "Builder", "Companion", "Entry", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Parameters implements Iterable<Pair<? extends String, ? extends Entry>>, KMappedMarker {
    public static final Companion Companion = null;
    public static final Parameters EMPTY = null;
    private final Map<String, Entry> entries;

    /* JADX INFO: compiled from: Parameters.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010\n\u001a\u00020\u0004J\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\bJ&\u0010\r\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\bH\u0007R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcoil/request/Parameters$Builder;", "", "()V", "parameters", "Lcoil/request/Parameters;", "(Lcoil/request/Parameters;)V", "entries", "", "", "Lcoil/request/Parameters$Entry;", IndexDatabaseHelper.MetaColumns.BUILD, "remove", "key", "set", "value", "memoryCacheKey", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Builder {
        private final Map<String, Entry> entries;

        public final Builder set(String r7, Object r8) {
            return set$default(this, r7, r8, null, 4, null);
        }

        public Builder() {
            this.entries = new LinkedHashMap();
        }

        public Builder(Parameters r1) {
            this.entries = MapsKt.toMutableMap(Parameters.access$getEntries$p(r1));
        }

        public static /* synthetic */ Builder set$default(Builder r0, String r1, Object r2, String r3, int r4, Object r5) {
            if ((r4 & 4) == 0) goto L8;
            if (r2 == null) goto L6;
            r3 = r2.toString();
            goto L8
        L6:
            r3 = null;
        L8:
            return r0.set(r1, r2, r3);
        }

        public final Builder set(String r3, Object r4, String r5) {
            this.entries.put(r3, new Entry(r4, r5));
            return this;
        }

        public final Builder remove(String r2) {
            this.entries.remove(r2);
            return this;
        }

        public final Parameters build() {
            return new Parameters(Collections.toImmutableMap(this.entries), null);
        }
    }

    /* JADX INFO: compiled from: Parameters.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcoil/request/Parameters$Companion;", "", "()V", "EMPTY", "Lcoil/request/Parameters;", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: Parameters.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0016R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0010"}, d2 = {"Lcoil/request/Parameters$Entry;", "", "value", "memoryCacheKey", "", "(Ljava/lang/Object;Ljava/lang/String;)V", "getMemoryCacheKey", "()Ljava/lang/String;", "getValue", "()Ljava/lang/Object;", "equals", "", PluralRules.KEYWORD_OTHER, "hashCode", "", "toString", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Entry {
        private final String memoryCacheKey;
        private final Object value;

        public Entry(Object r1, String r2) {
            this.value = r1;
            this.memoryCacheKey = r2;
        }

        public final Object getValue() {
            return this.value;
        }

        public final String getMemoryCacheKey() {
            return this.memoryCacheKey;
        }

        public boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof Entry) == false) goto L12;
            Entry r5 = (Entry) r4;
            if (Intrinsics.areEqual(this.value, r5.value) == false) goto L12;
            if (Intrinsics.areEqual(this.memoryCacheKey, r5.memoryCacheKey) == false) goto L12;
            return true;
        L12:
            return false;
        }

        public int hashCode() {
            Object r0 = this.value;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            String r4 = this.memoryCacheKey;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            return r3 + r1;
        L5:
            r2 = 0;
            goto L6
        }

        public String toString() {
            return "Entry(value=" + this.value + ", memoryCacheKey=" + this.memoryCacheKey + ')';
        }
    }

    public /* synthetic */ Parameters(Map r1, DefaultConstructorMarker r2) {
        this(r1);
    }

    private Parameters(Map<String, Entry> r1) {
        this.entries = r1;
    }

    public static final /* synthetic */ Map access$getEntries$p(Parameters r0) {
        return r0.entries;
    }

    public Parameters() {
        this(MapsKt.emptyMap());
    }

    public final int size() {
        return this.entries.size();
    }

    public final <T> T value(String r1) {
        Entry r0 = this.entries.get(r1);
        if (r0 != null) goto L7;
        return null;
    L7:
        return (T) r0.getValue();
    }

    public final String memoryCacheKey(String r1) {
        Entry r0 = this.entries.get(r1);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getMemoryCacheKey();
    }

    public final Entry entry(String r1) {
        return this.entries.get(r1);
    }

    public final boolean isEmpty() {
        return this.entries.isEmpty();
    }

    public final Map<String, Object> values() {
        if (isEmpty() == true) goto L12;
        Map<String, Entry> r3 = this.entries;
        LinkedHashMap r0 = new LinkedHashMap(MapsKt.mapCapacity(r3.size()));
        Iterator<T> r4 = r3.entrySet().iterator();
    L7:
        if (r4.hasNext() == false) goto L10;
        Map.Entry r1 = (Map.Entry) r4.next();
        r0.put(r1.getKey(), ((Entry) r1.getValue()).getValue());
        goto L7
    L10:
        return r0;
    L12:
        return MapsKt.emptyMap();
    }

    public final Map<String, String> memoryCacheKeys() {
        if (isEmpty() == true) goto L18;
        Map<String, Entry> r3 = this.entries;
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator<Map.Entry<String, Entry>> r4 = r3.entrySet().iterator();
    L7:
        if (r4.hasNext() == false) goto L12;
        Map.Entry<String, Entry> r1 = r4.next();
        String r2 = r1.getValue().getMemoryCacheKey();
        if (r2 == null) goto L7;
        r0.put(r1.getKey(), r2);
        goto L7
    L12:
        return r0;
    L18:
        return MapsKt.emptyMap();
    }

    @Override // java.lang.Iterable
    public Iterator<Pair<? extends String, ? extends Entry>> iterator() {
        Map<String, Entry> r3 = this.entries;
        ArrayList r0 = new ArrayList(r3.size());
        Iterator<Map.Entry<String, Entry>> r4 = r3.entrySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L7;
        Map.Entry<String, Entry> r1 = r4.next();
        r0.add(TuplesKt.to(r1.getKey(), r1.getValue()));
        goto L4
    L7:
        return r0.iterator();
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L6;
        return true;
    L6:
        if ((r3 instanceof Parameters) == true) goto L8;
    L10:
        return false;
    L8:
        if (Intrinsics.areEqual(this.entries, ((Parameters) r3).entries) == false) goto L10;
        return true;
    }

    public int hashCode() {
        return this.entries.hashCode();
    }

    public String toString() {
        return "Parameters(entries=" + this.entries + ')';
    }

    public final Builder newBuilder() {
        return new Builder(this);
    }

    static {
        Companion = new Companion(null);
        EMPTY = new Parameters();
    }
}
