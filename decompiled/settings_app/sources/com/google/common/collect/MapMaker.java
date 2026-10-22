package com.google.common.collect;

import com.android.vcard.VCardConstants;
import com.google.common.base.Ascii;
import com.google.common.base.Equivalence;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public final class MapMaker {
    private static final int DEFAULT_CONCURRENCY_LEVEL = 4;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    static final int UNSET_INT = -1;
    int concurrencyLevel;
    int initialCapacity;

    @CheckForNull
    Equivalence<Object> keyEquivalence;

    @CheckForNull
    MapMakerInternalMap.Strength keyStrength;
    boolean useCustomMap;

    @CheckForNull
    MapMakerInternalMap.Strength valueStrength;

    static final enum Dummy extends Enum<Dummy> {
        private static final /* synthetic */ Dummy[] $VALUES = null;
        public static final Dummy VALUE = null;

        private static /* synthetic */ Dummy[] $values() {
            return new Dummy[]{VALUE};
        }

        private Dummy(String r1, int r2) {
            super(r1, r2);
        }

        public static Dummy valueOf(String r1) {
            return (Dummy) Enum.valueOf(Dummy.class, r1);
        }

        public static Dummy[] values() {
            return (Dummy[]) $VALUES.clone();
        }

        static {
            VALUE = new Dummy(VCardConstants.PARAM_VALUE, 0);
            $VALUES = $values();
        }
    }

    public MapMaker() {
        this.initialCapacity = -1;
        this.concurrencyLevel = -1;
    }

    MapMaker keyEquivalence(Equivalence<Object> r5) {
        Equivalence<Object> r0 = this.keyEquivalence;
        if (r0 != null) goto L5;
        boolean r2 = true;
    L6:
        Preconditions.checkState(r2, "key equivalence was already set to %s", r0);
        this.keyEquivalence = (Equivalence) Preconditions.checkNotNull(r5);
        this.useCustomMap = true;
        return this;
    L5:
        r2 = false;
        goto L6
    }

    Equivalence<Object> getKeyEquivalence() {
        return (Equivalence) MoreObjects.firstNonNull(this.keyEquivalence, getKeyStrength().defaultEquivalence());
    }

    public MapMaker initialCapacity(int r6) {
        int r0 = this.initialCapacity;
        boolean r2 = true;
        if (r0 != (-1)) goto L5;
        boolean r1 = true;
    L6:
        Preconditions.checkState(r1, "initial capacity was already set to %s", r0);
        if (r6 >= 0) goto L10;
        r2 = false;
    L10:
        Preconditions.checkArgument(r2);
        this.initialCapacity = r6;
        return this;
    L5:
        r1 = false;
        goto L6
    }

    int getInitialCapacity() {
        int r1 = this.initialCapacity;
        if (r1 != (-1)) goto L6;
        return 16;
    L6:
        return r1;
    }

    public MapMaker concurrencyLevel(int r6) {
        int r0 = this.concurrencyLevel;
        boolean r2 = true;
        if (r0 != (-1)) goto L5;
        boolean r1 = true;
    L6:
        Preconditions.checkState(r1, "concurrency level was already set to %s", r0);
        if (r6 > 0) goto L10;
        r2 = false;
    L10:
        Preconditions.checkArgument(r2);
        this.concurrencyLevel = r6;
        return this;
    L5:
        r1 = false;
        goto L6
    }

    int getConcurrencyLevel() {
        int r1 = this.concurrencyLevel;
        if (r1 != (-1)) goto L6;
        return 4;
    L6:
        return r1;
    }

    public MapMaker weakKeys() {
        return setKeyStrength(MapMakerInternalMap.Strength.WEAK);
    }

    MapMaker setKeyStrength(MapMakerInternalMap.Strength r5) {
        MapMakerInternalMap.Strength r0 = this.keyStrength;
        if (r0 != null) goto L5;
        boolean r2 = true;
    L6:
        Preconditions.checkState(r2, "Key strength was already set to %s", r0);
        this.keyStrength = (MapMakerInternalMap.Strength) Preconditions.checkNotNull(r5);
        if (r5 == MapMakerInternalMap.Strength.STRONG) goto L9;
        this.useCustomMap = true;
    L9:
        return this;
    L5:
        r2 = false;
        goto L6
    }

    MapMakerInternalMap.Strength getKeyStrength() {
        return (MapMakerInternalMap.Strength) MoreObjects.firstNonNull(this.keyStrength, MapMakerInternalMap.Strength.STRONG);
    }

    public MapMaker weakValues() {
        return setValueStrength(MapMakerInternalMap.Strength.WEAK);
    }

    MapMaker setValueStrength(MapMakerInternalMap.Strength r5) {
        MapMakerInternalMap.Strength r0 = this.valueStrength;
        if (r0 != null) goto L5;
        boolean r2 = true;
    L6:
        Preconditions.checkState(r2, "Value strength was already set to %s", r0);
        this.valueStrength = (MapMakerInternalMap.Strength) Preconditions.checkNotNull(r5);
        if (r5 == MapMakerInternalMap.Strength.STRONG) goto L9;
        this.useCustomMap = true;
    L9:
        return this;
    L5:
        r2 = false;
        goto L6
    }

    MapMakerInternalMap.Strength getValueStrength() {
        return (MapMakerInternalMap.Strength) MoreObjects.firstNonNull(this.valueStrength, MapMakerInternalMap.Strength.STRONG);
    }

    public <K, V> ConcurrentMap<K, V> makeMap() {
        if (this.useCustomMap == true) goto L7;
        return new ConcurrentHashMap(getInitialCapacity(), 0.75f, getConcurrencyLevel());
    L7:
        return MapMakerInternalMap.create(this);
    }

    public String toString() {
        MoreObjects.ToStringHelper r0 = MoreObjects.toStringHelper(this);
        int r1 = this.initialCapacity;
        if (r1 == (-1)) goto L5;
        r0.add("initialCapacity", r1);
    L5:
        int r2 = this.concurrencyLevel;
        if (r2 == (-1)) goto L8;
        r0.add("concurrencyLevel", r2);
    L8:
        MapMakerInternalMap.Strength r3 = this.keyStrength;
        if (r3 == null) goto L11;
        r0.add("keyStrength", Ascii.toLowerCase(r3.toString()));
    L11:
        MapMakerInternalMap.Strength r4 = this.valueStrength;
        if (r4 == null) goto L15;
        r0.add("valueStrength", Ascii.toLowerCase(r4.toString()));
    L15:
        if (this.keyEquivalence == null) goto L18;
        r0.addValue("keyEquivalence");
    L18:
        return r0.toString();
    }
}
