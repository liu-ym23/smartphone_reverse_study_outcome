package com.google.common.primitives;

import com.google.common.base.Converter;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public final class Floats extends FloatsMethodsForWeb {
    public static final int BYTES = 4;

    private static class FloatArrayAsList extends AbstractList<Float> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;
        final float[] array;
        final int end;
        final int start;

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ Object get(int r1) {
            return get(r1);
        }

        @Override // java.util.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ Object set(int r1, Object r2) {
            return set(r1, (Float) r2);
        }

        FloatArrayAsList(float[] r3) {
            this(r3, 0, r3.length);
        }

        FloatArrayAsList(float[] r1, int r2, int r3) {
            this.array = r1;
            this.start = r2;
            this.end = r3;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.end - this.start;
        }

        @Override // java.util.AbstractList, java.util.List
        public Float get(int r2) {
            Preconditions.checkElementIndex(r2, size());
            return Float.valueOf(this.array[this.start + r2]);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(@CheckForNull Object r3) {
            if ((r3 instanceof Float) == true) goto L5;
        L7:
            return false;
        L5:
            if (Floats.access$000(this.array, ((Float) r3).floatValue(), this.start, this.end) == (-1)) goto L7;
            return true;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(@CheckForNull Object r4) {
            if ((r4 instanceof Float) == false) goto L8;
            int r5 = Floats.access$000(this.array, ((Float) r4).floatValue(), this.start, this.end);
            if (r5 >= 0) goto L7;
            return -1;
        L7:
            return r5 - this.start;
        L8:
            return -1;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(@CheckForNull Object r4) {
            if ((r4 instanceof Float) == false) goto L8;
            int r5 = Floats.access$100(this.array, ((Float) r4).floatValue(), this.start, this.end);
            if (r5 >= 0) goto L7;
            return -1;
        L7:
            return r5 - this.start;
        L8:
            return -1;
        }

        public Float set(int r3, Float r4) {
            Preconditions.checkElementIndex(r3, size());
            float[] r0 = this.array;
            int r2 = this.start;
            float r1 = r0[r2 + r3];
            r0[r2 + r3] = ((Float) Preconditions.checkNotNull(r4)).floatValue();
            return Float.valueOf(r1);
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Float> subList(int r3, int r4) {
            Preconditions.checkPositionIndexes(r3, r4, size());
            if (r3 == r4) goto L5;
            float[] r1 = this.array;
            int r2 = this.start;
            return new FloatArrayAsList(r1, r3 + r2, r2 + r4);
        L5:
            return Collections.emptyList();
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(@CheckForNull Object r8) {
            if (r8 != this) goto L6;
            return true;
        L6:
            if ((r8 instanceof FloatArrayAsList) == false) goto L18;
            FloatArrayAsList r9 = (FloatArrayAsList) r8;
            int r1 = size();
            if (r9.size() == r1) goto L10;
            return false;
        L10:
            int r2 = 0;
        L11:
            if (r2 >= r1) goto L16;
            if (this.array[this.start + r2] != r9.array[r9.start + r2]) goto L14;
            r2 = r2 + 1;
            goto L11
        L14:
            return false;
        L16:
            return true;
        L18:
            return super.equals(r8);
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            int r0 = this.start;
            int r1 = 1;
        L4:
            if (r0 >= this.end) goto L6;
            r1 = (r1 * 31) + Floats.hashCode(this.array[r0]);
            r0 = r0 + 1;
            goto L4
        L6:
            return r1;
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder r0 = new StringBuilder(size() * 12);
            r0.append('[').append(this.array[this.start]);
            int r1 = this.start;
        L3:
            r1 = r1 + 1;
            if (r1 >= this.end) goto L7;
            r0.append(", ").append(this.array[r1]);
            goto L3
        L7:
            return r0.append(']').toString();
        }

        float[] toFloatArray() {
            return Arrays.copyOfRange(this.array, this.start, this.end);
        }
    }

    private static final class FloatConverter extends Converter<String, Float> implements Serializable {
        static final FloatConverter INSTANCE = null;
        private static final long serialVersionUID = 1;

        public String toString() {
            return "Floats.stringConverter()";
        }

        private FloatConverter() {
        }

        @Override // com.google.common.base.Converter
        protected /* bridge */ /* synthetic */ String doBackward(Float r1) {
            return doBackward2(r1);
        }

        @Override // com.google.common.base.Converter
        protected /* bridge */ /* synthetic */ Float doForward(String r1) {
            return doForward2(r1);
        }

        static {
            INSTANCE = new FloatConverter();
        }

        /* JADX INFO: renamed from: doForward, reason: avoid collision after fix types in other method */
        protected Float doForward2(String r1) {
            return Float.valueOf(r1);
        }

        /* JADX INFO: renamed from: doBackward, reason: avoid collision after fix types in other method */
        protected String doBackward2(Float r1) {
            return r1.toString();
        }

        private Object readResolve() {
            return INSTANCE;
        }
    }

    private static final enum LexicographicalComparator extends Enum<LexicographicalComparator> implements Comparator<float[]> {
        private static final /* synthetic */ LexicographicalComparator[] $VALUES = null;
        public static final LexicographicalComparator INSTANCE = null;

        @Override // java.lang.Enum
        public String toString() {
            return "Floats.lexicographicalComparator()";
        }

        private static /* synthetic */ LexicographicalComparator[] $values() {
            return new LexicographicalComparator[]{INSTANCE};
        }

        private LexicographicalComparator(String r1, int r2) {
            super(r1, r2);
        }

        public static LexicographicalComparator valueOf(String r1) {
            return (LexicographicalComparator) Enum.valueOf(LexicographicalComparator.class, r1);
        }

        public static LexicographicalComparator[] values() {
            return (LexicographicalComparator[]) $VALUES.clone();
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(float[] r1, float[] r2) {
            return compare2(r1, r2);
        }

        static {
            INSTANCE = new LexicographicalComparator("INSTANCE", 0);
            $VALUES = $values();
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(float[] r4, float[] r5) {
            int r3 = Math.min(r4.length, r5.length);
            int r0 = 0;
        L3:
            if (r0 >= r3) goto L9;
            int r1 = Float.compare(r4[r0], r5[r0]);
            if (r1 != 0) goto L6;
            r0 = r0 + 1;
            goto L3
        L6:
            return r1;
        L9:
            return r4.length - r5.length;
        }
    }

    public static boolean isFinite(float r1) {
        if (Float.NEGATIVE_INFINITY < r1) goto L5;
    L7:
        return false;
    L5:
        if (r1 >= Float.POSITIVE_INFINITY) goto L7;
        return true;
    }

    static /* synthetic */ int access$000(float[] r0, float r1, int r2, int r3) {
        return indexOf(r0, r1, r2, r3);
    }

    static /* synthetic */ int access$100(float[] r0, float r1, int r2, int r3) {
        return lastIndexOf(r0, r1, r2, r3);
    }

    private Floats() {
    }

    public static int hashCode(float r0) {
        return Float.valueOf(r0).hashCode();
    }

    public static int compare(float r0, float r1) {
        return Float.compare(r0, r1);
    }

    public static boolean contains(float[] r4, float r5) {
        int r0 = r4.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        if (r4[r2] == r5) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public static int indexOf(float[] r2, float r3) {
        return indexOf(r2, r3, 0, r2.length);
    }

    private static int indexOf(float[] r1, float r2, int r3, int r4) {
    L2:
        if (r3 >= r4) goto L7;
        if (r1[r3] == r2) goto L5;
        r3 = r3 + 1;
        goto L2
    L5:
        return r3;
    L7:
        return -1;
    }

    public static int indexOf(float[] r5, float[] r6) {
        Preconditions.checkNotNull(r5, "array");
        Preconditions.checkNotNull(r6, "target");
        if (r6.length != 0) goto L5;
        return 0;
    L5:
        int r0 = 0;
    L7:
        if (r0 >= ((r5.length - r6.length) + 1)) goto L16;
        int r2 = 0;
    L10:
        if (r2 >= r6.length) goto L15;
        if (r5[r0 + r2] != r6[r2]) goto L13;
        r2 = r2 + 1;
        goto L10
    L13:
        r0 = r0 + 1;
        goto L7
    L15:
        return r0;
    L16:
        return -1;
    }

    public static int lastIndexOf(float[] r2, float r3) {
        return lastIndexOf(r2, r3, 0, r2.length);
    }

    private static int lastIndexOf(float[] r1, float r2, int r3, int r4) {
        int r5 = r4 - 1;
    L3:
        if (r5 < r3) goto L8;
        if (r1[r5] == r2) goto L6;
        r5 = r5 - 1;
        goto L3
    L6:
        return r5;
    L8:
        return -1;
    }

    public static float min(float... r3) {
        int r2 = 1;
        if (r3.length <= 0) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0);
        float r1 = r3[0];
    L8:
        if (r2 >= r3.length) goto L10;
        r1 = Math.min(r1, r3[r2]);
        r2 = r2 + 1;
        goto L8
    L10:
        return r1;
    L5:
        r0 = false;
        goto L6
    }

    public static float max(float... r3) {
        int r2 = 1;
        if (r3.length <= 0) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0);
        float r1 = r3[0];
    L8:
        if (r2 >= r3.length) goto L10;
        r1 = Math.max(r1, r3[r2]);
        r2 = r2 + 1;
        goto L8
    L10:
        return r1;
    L5:
        r0 = false;
        goto L6
    }

    public static float constrainToRange(float r2, float r3, float r4) {
        if (r3 > r4) goto L7;
        return Math.min(Math.max(r2, r3), r4);
    L7:
        throw new IllegalArgumentException(Strings.lenientFormat("min (%s) must be less than or equal to max (%s)", new Object[]{Float.valueOf(r3), Float.valueOf(r4)}));
    }

    public static float[] concat(float[]... r7) {
        int r0 = r7.length;
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r2 >= r0) goto L5;
        r3 = r3 + r7[r2].length;
        r2 = r2 + 1;
        goto L3
    L5:
        float[] r1 = new float[r3];
        int r4 = r7.length;
        int r5 = 0;
        int r6 = 0;
    L6:
        if (r5 >= r4) goto L8;
        float[] r8 = r7[r5];
        System.arraycopy(r8, 0, r1, r6, r8.length);
        r6 = r6 + r8.length;
        r5 = r5 + 1;
        goto L6
    L8:
        return r1;
    }

    public static Converter<String, Float> stringConverter() {
        return FloatConverter.INSTANCE;
    }

    public static float[] ensureCapacity(float[] r4, int r5, int r6) {
        boolean r0 = true;
        if (r5 < 0) goto L5;
        boolean r2 = true;
    L6:
        Preconditions.checkArgument(r2, "Invalid minLength: %s", r5);
        if (r6 >= 0) goto L10;
        r0 = false;
    L10:
        Preconditions.checkArgument(r0, "Invalid padding: %s", r6);
        if (r4.length < r5) goto L13;
        return r4;
    L13:
        return Arrays.copyOf(r4, r5 + r6);
    L5:
        r2 = false;
        goto L6
    }

    public static String join(String r4, float... r5) {
        Preconditions.checkNotNull(r4);
        if (r5.length != 0) goto L6;
        return "";
    L6:
        StringBuilder r0 = new StringBuilder(r5.length * 12);
        r0.append(r5[0]);
        int r1 = 1;
    L8:
        if (r1 >= r5.length) goto L11;
        r0.append(r4).append(r5[r1]);
        r1 = r1 + 1;
        goto L8
    L11:
        return r0.toString();
    }

    public static Comparator<float[]> lexicographicalComparator() {
        return LexicographicalComparator.INSTANCE;
    }

    public static void sortDescending(float[] r2) {
        Preconditions.checkNotNull(r2);
        sortDescending(r2, 0, r2.length);
    }

    public static void sortDescending(float[] r1, int r2, int r3) {
        Preconditions.checkNotNull(r1);
        Preconditions.checkPositionIndexes(r2, r3, r1.length);
        Arrays.sort(r1, r2, r3);
        reverse(r1, r2, r3);
    }

    public static void reverse(float[] r2) {
        Preconditions.checkNotNull(r2);
        reverse(r2, 0, r2.length);
    }

    public static void reverse(float[] r2, int r3, int r4) {
        Preconditions.checkNotNull(r2);
        Preconditions.checkPositionIndexes(r3, r4, r2.length);
        int r5 = r4 - 1;
    L3:
        if (r3 >= r5) goto L5;
        float r0 = r2[r3];
        r2[r3] = r2[r5];
        r2[r5] = r0;
        r3 = r3 + 1;
        r5 = r5 - 1;
        goto L3
    }

    public static float[] toArray(Collection<? extends Number> r4) {
        if ((r4 instanceof FloatArrayAsList) == true) goto L5;
        Object[] r5 = r4.toArray();
        int r0 = r5.length;
        float[] r1 = new float[r0];
        int r2 = 0;
    L7:
        if (r2 >= r0) goto L9;
        r1[r2] = ((Number) Preconditions.checkNotNull(r5[r2])).floatValue();
        r2 = r2 + 1;
        goto L7
    L9:
        return r1;
    L5:
        return ((FloatArrayAsList) r4).toFloatArray();
    }

    public static List<Float> asList(float... r1) {
        if (r1.length != 0) goto L7;
        return Collections.emptyList();
    L7:
        return new FloatArrayAsList(r1);
    }

    @CheckForNull
    public static Float tryParse(String r1) {
        if (Doubles.FLOATING_POINT_PATTERN.matcher(r1).matches() == true) goto L9;
        return null;
    L9:
        return Float.valueOf(Float.parseFloat(r1));
    L11:
        return null;
    }
}
