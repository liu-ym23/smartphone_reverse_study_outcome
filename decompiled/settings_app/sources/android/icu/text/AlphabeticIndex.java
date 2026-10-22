package android.icu.text;

import android.icu.util.ULocale;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class AlphabeticIndex<V> implements Iterable<Bucket<V>> {

    public static class Bucket<V> implements Iterable<Record<V>> {

        public static final enum LabelType extends Enum<LabelType> {
            private static final /* synthetic */ LabelType[] $VALUES = null;
            public static final LabelType INFLOW = null;
            public static final LabelType NORMAL = null;
            public static final LabelType OVERFLOW = null;
            public static final LabelType UNDERFLOW = null;

            public static LabelType valueOf(String r1) {
                return (LabelType) Enum.valueOf(LabelType.class, r1);
            }

            public static LabelType[] values() {
                return (LabelType[]) $VALUES.clone();
            }

            private LabelType(String r1, int r2) {
                super(r1, r2);
            }

            static {
                LabelType r0 = new LabelType("NORMAL", 0);
                NORMAL = r0;
                LabelType r1 = new LabelType("UNDERFLOW", 1);
                UNDERFLOW = r1;
                LabelType r3 = new LabelType("INFLOW", 2);
                INFLOW = r3;
                LabelType r5 = new LabelType("OVERFLOW", 3);
                OVERFLOW = r5;
                $VALUES = new LabelType[]{r0, r1, r3, r5};
            }
        }

        private Bucket() {
            throw new RuntimeException("Stub!");
        }

        public String getLabel() {
            throw new RuntimeException("Stub!");
        }

        public LabelType getLabelType() {
            throw new RuntimeException("Stub!");
        }

        public int size() {
            throw new RuntimeException("Stub!");
        }

        @Override // java.lang.Iterable
        public Iterator<Record<V>> iterator() {
            throw new RuntimeException("Stub!");
        }

        public String toString() {
            throw new RuntimeException("Stub!");
        }
    }

    public static final class ImmutableIndex<V> implements Iterable<Bucket<V>> {
        private ImmutableIndex() {
            throw new RuntimeException("Stub!");
        }

        public int getBucketCount() {
            throw new RuntimeException("Stub!");
        }

        public int getBucketIndex(CharSequence r1) {
            throw new RuntimeException("Stub!");
        }

        public Bucket<V> getBucket(int r1) {
            throw new RuntimeException("Stub!");
        }

        @Override // java.lang.Iterable
        public Iterator<Bucket<V>> iterator() {
            throw new RuntimeException("Stub!");
        }
    }

    public static class Record<V> {
        private Record() {
            throw new RuntimeException("Stub!");
        }

        public CharSequence getName() {
            throw new RuntimeException("Stub!");
        }

        public V getData() {
            throw new RuntimeException("Stub!");
        }

        public String toString() {
            throw new RuntimeException("Stub!");
        }
    }

    public AlphabeticIndex(ULocale r1) {
        throw new RuntimeException("Stub!");
    }

    public AlphabeticIndex(Locale r1) {
        throw new RuntimeException("Stub!");
    }

    public AlphabeticIndex(RuleBasedCollator r1) {
        throw new RuntimeException("Stub!");
    }

    public AlphabeticIndex<V> addLabels(UnicodeSet r1) {
        throw new RuntimeException("Stub!");
    }

    public AlphabeticIndex<V> addLabels(ULocale... r1) {
        throw new RuntimeException("Stub!");
    }

    public AlphabeticIndex<V> addLabels(Locale... r1) {
        throw new RuntimeException("Stub!");
    }

    public AlphabeticIndex<V> setOverflowLabel(String r1) {
        throw new RuntimeException("Stub!");
    }

    public String getUnderflowLabel() {
        throw new RuntimeException("Stub!");
    }

    public AlphabeticIndex<V> setUnderflowLabel(String r1) {
        throw new RuntimeException("Stub!");
    }

    public String getOverflowLabel() {
        throw new RuntimeException("Stub!");
    }

    public AlphabeticIndex<V> setInflowLabel(String r1) {
        throw new RuntimeException("Stub!");
    }

    public String getInflowLabel() {
        throw new RuntimeException("Stub!");
    }

    public int getMaxLabelCount() {
        throw new RuntimeException("Stub!");
    }

    public AlphabeticIndex<V> setMaxLabelCount(int r1) {
        throw new RuntimeException("Stub!");
    }

    public ImmutableIndex<V> buildImmutableIndex() {
        throw new RuntimeException("Stub!");
    }

    public List<String> getBucketLabels() {
        throw new RuntimeException("Stub!");
    }

    public RuleBasedCollator getCollator() {
        throw new RuntimeException("Stub!");
    }

    public AlphabeticIndex<V> addRecord(CharSequence r1, V r2) {
        throw new RuntimeException("Stub!");
    }

    public int getBucketIndex(CharSequence r1) {
        throw new RuntimeException("Stub!");
    }

    public AlphabeticIndex<V> clearRecords() {
        throw new RuntimeException("Stub!");
    }

    public int getBucketCount() {
        throw new RuntimeException("Stub!");
    }

    public int getRecordCount() {
        throw new RuntimeException("Stub!");
    }

    @Override // java.lang.Iterable
    public Iterator<Bucket<V>> iterator() {
        throw new RuntimeException("Stub!");
    }
}
