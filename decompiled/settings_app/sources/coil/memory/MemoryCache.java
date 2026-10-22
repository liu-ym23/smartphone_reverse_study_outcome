package coil.memory;

import android.content.Context;
import android.graphics.Bitmap;
import android.icu.text.PluralRules;
import android.os.Parcel;
import android.os.Parcelable;
import coil.util.Utils;
import com.android.launcher3.icons.cache.BaseIconCache;
import com.android.settings.fuelgauge.PowerUsageDetail;
import com.android.settings.search.IndexDatabaseHelper;
import com.bytedance.apm.constant.PerfConsts;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MemoryCache.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\bf\u0018\u00002\u00020\u0001:\u0003\u0018\u0019\u001aJ\b\u0010\r\u001a\u00020\u000eH&J\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0004H¦\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u0004H&J\u0019\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0010H¦\u0002J\u0010\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\bH&R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0012\u0010\u000b\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\nø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001bÀ\u0006\u0001"}, d2 = {"Lcoil/memory/MemoryCache;", "", "keys", "", "Lcoil/memory/MemoryCache$Key;", "getKeys", "()Ljava/util/Set;", "maxSize", "", "getMaxSize", "()I", PerfConsts.PERF_DISK_FILE_SIZE, "getSize", "clear", "", "get", "Lcoil/memory/MemoryCache$Value;", "key", "remove", "", "set", "value", "trimMemory", "level", "Builder", "Key", "Value", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface MemoryCache {

    /* JADX INFO: compiled from: MemoryCache.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0006J\u0010\u0010\u0007\u001a\u00020\u00002\b\b\u0001\u0010\u000f\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcoil/memory/MemoryCache$Builder;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "maxSizeBytes", "", "maxSizePercent", "", "strongReferencesEnabled", "", "weakReferencesEnabled", IndexDatabaseHelper.MetaColumns.BUILD, "Lcoil/memory/MemoryCache;", PerfConsts.PERF_DISK_FILE_SIZE, PowerUsageDetail.EXTRA_PERCENT, "enable", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Builder {
        private final Context context;
        private int maxSizeBytes;
        private double maxSizePercent;
        private boolean strongReferencesEnabled;
        private boolean weakReferencesEnabled;

        public Builder(Context r3) {
            this.context = r3;
            this.maxSizePercent = Utils.defaultMemoryCacheSizePercent(r3);
            this.strongReferencesEnabled = true;
            this.weakReferencesEnabled = true;
        }

        public final Builder maxSizePercent(double r5) {
            if (0.0d <= r5) goto L5;
        L7:
            boolean r0 = false;
        L8:
            if (r0 == false) goto L12;
            this.maxSizeBytes = 0;
            this.maxSizePercent = r5;
            return this;
        L12:
            throw new IllegalArgumentException("size must be in the range [0.0, 1.0].".toString());
        L5:
            if (r5 > 1.0d) goto L7;
            r0 = true;
            goto L8
        }

        public final Builder maxSizeBytes(int r3) {
            if (r3 < 0) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == false) goto L10;
            this.maxSizePercent = 0.0d;
            this.maxSizeBytes = r3;
            return this;
        L10:
            throw new IllegalArgumentException("size must be >= 0.".toString());
        L5:
            r0 = false;
            goto L6
        }

        public final Builder strongReferencesEnabled(boolean r2) {
            this.strongReferencesEnabled = r2;
            return this;
        }

        public final Builder weakReferencesEnabled(boolean r2) {
            this.weakReferencesEnabled = r2;
            return this;
        }

        public final MemoryCache build() {
            if (this.weakReferencesEnabled == false) goto L5;
            EmptyWeakMemoryCache r0 = new RealWeakMemoryCache();
        L7:
            if (this.strongReferencesEnabled == false) goto L15;
            double r1 = this.maxSizePercent;
            if (r1 <= 0.0d) goto L11;
            int r5 = Utils.calculateMemoryCacheSize(this.context, r1);
        L12:
            if (r5 <= 0) goto L14;
            EmptyStrongMemoryCache r2 = new RealStrongMemoryCache(r5, r0);
        L17:
            return new RealMemoryCache(r2, r0);
        L14:
            r2 = new EmptyStrongMemoryCache(r0);
            goto L17
        L11:
            r5 = this.maxSizeBytes;
            goto L12
        L15:
            r2 = new EmptyStrongMemoryCache(r0);
            goto L17
        L5:
            r0 = new EmptyWeakMemoryCache();
            goto L7
        }
    }

    /* JADX INFO: compiled from: MemoryCache.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u0006J&\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005J\b\u0010\f\u001a\u00020\rH\u0016J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0002J\b\u0010\u0012\u001a\u00020\rH\u0016J\b\u0010\u0013\u001a\u00020\u0003H\u0016J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\rH\u0016R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001a"}, d2 = {"Lcoil/memory/MemoryCache$Key;", "Landroid/os/Parcelable;", "key", "", "extras", "", "(Ljava/lang/String;Ljava/util/Map;)V", "getExtras", "()Ljava/util/Map;", "getKey", "()Ljava/lang/String;", "copy", "describeContents", "", "equals", "", PluralRules.KEYWORD_OTHER, "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", BaseIconCache.IconDB.COLUMN_FLAGS, "Companion", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Key implements Parcelable {

        @Deprecated
        public static final Parcelable.Creator<Key> CREATOR = null;
        private static final Companion Companion = null;
        private final Map<String, String> extras;
        private final String key;

        /* JADX INFO: compiled from: MemoryCache.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcoil/memory/MemoryCache$Key$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcoil/memory/MemoryCache$Key;", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        private static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker r1) {
                this();
            }

            private Companion() {
            }
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public Key(String r1, Map<String, String> r2) {
            this.key = r1;
            this.extras = r2;
        }

        public final String getKey() {
            return this.key;
        }

        public /* synthetic */ Key(String r1, Map r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = MapsKt.emptyMap();
        L5:
            this(r1, r2);
        }

        public final Map<String, String> getExtras() {
            return this.extras;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Key copy$default(Key r0, String r1, Map r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.key;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.extras;
        L9:
            return r0.copy(r1, r2);
        }

        public final Key copy(String r1, Map<String, String> r2) {
            return new Key(r1, r2);
        }

        public boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof Key) == false) goto L12;
            Key r5 = (Key) r4;
            if (Intrinsics.areEqual(this.key, r5.key) == false) goto L12;
            if (Intrinsics.areEqual(this.extras, r5.extras) == false) goto L12;
            return true;
        L12:
            return false;
        }

        public int hashCode() {
            return (this.key.hashCode() * 31) + this.extras.hashCode();
        }

        public String toString() {
            return "Key(key=" + this.key + ", extras=" + this.extras + ')';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r2, int r3) {
            r2.writeString(this.key);
            r2.writeInt(this.extras.size());
            Iterator<Map.Entry<String, String>> r1 = this.extras.entrySet().iterator();
        L4:
            if (r1.hasNext() == false) goto L6;
            Map.Entry<String, String> r4 = r1.next();
            String r0 = r4.getKey();
            String r5 = r4.getValue();
            r2.writeString(r0);
            r2.writeString(r5);
            goto L4
        }

        static {
            Companion = new Companion(null);
            CREATOR = new MemoryCache$Key$Companion$CREATOR$1();
        }
    }

    /* JADX INFO: compiled from: MemoryCache.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\u0010\u0007J&\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0006H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0013"}, d2 = {"Lcoil/memory/MemoryCache$Value;", "", "bitmap", "Landroid/graphics/Bitmap;", "extras", "", "", "(Landroid/graphics/Bitmap;Ljava/util/Map;)V", "getBitmap", "()Landroid/graphics/Bitmap;", "getExtras", "()Ljava/util/Map;", "copy", "equals", "", PluralRules.KEYWORD_OTHER, "hashCode", "", "toString", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Value {
        private final Bitmap bitmap;
        private final Map<String, Object> extras;

        public Value(Bitmap r1, Map<String, ? extends Object> r2) {
            this.bitmap = r1;
            this.extras = r2;
        }

        public final Bitmap getBitmap() {
            return this.bitmap;
        }

        public /* synthetic */ Value(Bitmap r1, Map r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = MapsKt.emptyMap();
        L5:
            this(r1, r2);
        }

        public final Map<String, Object> getExtras() {
            return this.extras;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Value copy$default(Value r0, Bitmap r1, Map r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.bitmap;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.extras;
        L9:
            return r0.copy(r1, r2);
        }

        public final Value copy(Bitmap r1, Map<String, ? extends Object> r2) {
            return new Value(r1, r2);
        }

        public boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof Value) == false) goto L12;
            Value r5 = (Value) r4;
            if (Intrinsics.areEqual(this.bitmap, r5.bitmap) == false) goto L12;
            if (Intrinsics.areEqual(this.extras, r5.extras) == false) goto L12;
            return true;
        L12:
            return false;
        }

        public int hashCode() {
            return (this.bitmap.hashCode() * 31) + this.extras.hashCode();
        }

        public String toString() {
            return "Value(bitmap=" + this.bitmap + ", extras=" + this.extras + ')';
        }
    }

    void clear();

    Value get(Key r1);

    Set<Key> getKeys();

    int getMaxSize();

    int getSize();

    boolean remove(Key r1);

    void set(Key r1, Value r2);

    void trimMemory(int r1);
}
