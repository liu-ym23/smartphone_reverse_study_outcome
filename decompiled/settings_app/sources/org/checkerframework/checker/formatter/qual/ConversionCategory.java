package org.checkerframework.checker.formatter.qual;

import com.android.settings.utils.HanziToPinyin;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.StringJoiner;
import org.checkerframework.dataflow.qual.Pure;

/* JADX INFO: loaded from: classes6.dex */
public final enum ConversionCategory extends Enum<ConversionCategory> {
    private static final /* synthetic */ ConversionCategory[] $VALUES = null;
    public static final ConversionCategory CHAR = null;
    public static final ConversionCategory CHAR_AND_INT = null;
    public static final ConversionCategory FLOAT = null;
    public static final ConversionCategory GENERAL = null;
    public static final ConversionCategory INT = null;
    public static final ConversionCategory INT_AND_TIME = null;
    public static final ConversionCategory NULL = null;
    public static final ConversionCategory TIME = null;
    public static final ConversionCategory UNUSED = null;
    public final String chars;
    public final Class<?>[] types;

    public static ConversionCategory valueOf(String r1) {
        return (ConversionCategory) Enum.valueOf(ConversionCategory.class, r1);
    }

    public static ConversionCategory[] values() {
        return (ConversionCategory[]) $VALUES.clone();
    }

    static {
        Class[] r2 = (Class[]) null;
        ConversionCategory r0 = new ConversionCategory("GENERAL", 0, "bBhHsS", null);
        GENERAL = r0;
        ConversionCategory r3 = new ConversionCategory("CHAR", 1, "cC", new Class[]{Character.class, Byte.class, Short.class, Integer.class});
        CHAR = r3;
        ConversionCategory r5 = new ConversionCategory("INT", 2, "doxX", new Class[]{Byte.class, Short.class, Integer.class, Long.class, BigInteger.class});
        INT = r5;
        ConversionCategory r10 = new ConversionCategory("FLOAT", 3, "eEfgGaA", new Class[]{Float.class, Double.class, BigDecimal.class});
        FLOAT = r10;
        ConversionCategory r11 = new ConversionCategory("TIME", 4, "tT", new Class[]{Long.class, Calendar.class, Date.class});
        TIME = r11;
        ConversionCategory r12 = new ConversionCategory("CHAR_AND_INT", 5, null, new Class[]{Byte.class, Short.class, Integer.class});
        CHAR_AND_INT = r12;
        ConversionCategory r13 = new ConversionCategory("INT_AND_TIME", 6, null, new Class[]{Long.class});
        INT_AND_TIME = r13;
        ConversionCategory r14 = new ConversionCategory("NULL", 7, null, new Class[0]);
        NULL = r14;
        ConversionCategory r6 = new ConversionCategory("UNUSED", 8, null, null);
        UNUSED = r6;
        $VALUES = new ConversionCategory[]{r0, r3, r5, r10, r11, r12, r13, r14, r6};
    }

    private ConversionCategory(String r2, int r3, String r4, Class... r5) {
        super(r2, r3);
        this.chars = r4;
        if (r5 != null) goto L5;
        this.types = r5;
        return;
    L5:
        ArrayList r6 = new ArrayList(r5.length);
        int r7 = r5.length;
        int r8 = 0;
    L6:
        if (r8 >= r7) goto L11;
        Class r0 = r5[r8];
        r6.add(r0);
        Class<? extends Object> r1 = unwrapPrimitive(r0);
        if (r1 == null) goto L10;
        r6.add(r1);
    L10:
        r8 = r8 + 1;
        goto L6
    L11:
        this.types = (Class[]) r6.toArray(new Class[r6.size()]);
    }

    private static Class<? extends Object> unwrapPrimitive(Class<?> r1) {
        if (r1 != Byte.class) goto L7;
        return Byte.TYPE;
    L7:
        if (r1 != Character.class) goto L11;
        return Character.TYPE;
    L11:
        if (r1 != Short.class) goto L15;
        return Short.TYPE;
    L15:
        if (r1 != Integer.class) goto L19;
        return Integer.TYPE;
    L19:
        if (r1 != Long.class) goto L23;
        return Long.TYPE;
    L23:
        if (r1 != Float.class) goto L27;
        return Float.TYPE;
    L27:
        if (r1 != Double.class) goto L31;
        return Double.TYPE;
    L31:
        if (r1 == Boolean.class) goto L33;
        return null;
    L33:
        return Boolean.TYPE;
    }

    public static ConversionCategory fromConversionChar(char r6) {
        int r3 = 0;
        ConversionCategory[] r1 = {GENERAL, CHAR, INT, FLOAT, TIME};
    L3:
        if (r3 >= 5) goto L9;
        ConversionCategory r2 = r1[r3];
        if (r2.chars.contains(String.valueOf(r6)) == true) goto L6;
        r3 = r3 + 1;
        goto L3
    L6:
        return r2;
    L9:
        throw new IllegalArgumentException("Bad conversion character " + r6);
    }

    private static <E> Set<E> arrayToSet(E[] r1) {
        return new HashSet(Arrays.asList(r1));
    }

    public static boolean isSubsetOf(ConversionCategory r0, ConversionCategory r1) {
        if (intersect(r0, r1) != r0) goto L5;
        return true;
    L5:
        return false;
    }

    public static ConversionCategory intersect(ConversionCategory r4, ConversionCategory r5) {
        ConversionCategory r0 = UNUSED;
        if (r4 != r0) goto L5;
        return r5;
    L5:
        if (r5 != r0) goto L7;
        return r4;
    L7:
        ConversionCategory r1 = GENERAL;
        if (r4 != r1) goto L10;
        return r5;
    L10:
        if (r5 != r1) goto L12;
        return r4;
    L12:
        Set r6 = arrayToSet(r4.types);
        r6.retainAll(arrayToSet(r5.types));
        int r2 = 0;
        ConversionCategory[] r3 = {CHAR, INT, FLOAT, TIME, CHAR_AND_INT, INT_AND_TIME, NULL};
    L13:
        if (r2 >= 7) goto L19;
        ConversionCategory r7 = r3[r2];
        if (arrayToSet(r7.types).equals(r6) == true) goto L16;
        r2 = r2 + 1;
        goto L13
    L16:
        return r7;
    L19:
        throw new RuntimeException();
    }

    public static ConversionCategory union(ConversionCategory r5, ConversionCategory r6) {
        ConversionCategory r0 = UNUSED;
        if (r5 == r0) goto L27;
        if (r6 == r0) goto L27;
        r0 = GENERAL;
        if (r5 == r0) goto L27;
        if (r6 == r0) goto L27;
        ConversionCategory r1 = CHAR_AND_INT;
        if (r5 == r1) goto L13;
    L14:
        ConversionCategory r2 = INT_AND_TIME;
        if (r5 != r2) goto L19;
        if (r6 != r1) goto L19;
    L18:
        return INT;
    L19:
        Set r7 = arrayToSet(r5.types);
        r7.addAll(arrayToSet(r6.types));
        int r4 = 0;
        ConversionCategory[] r3 = {NULL, r1, r2, CHAR, INT, FLOAT, TIME};
    L20:
        if (r4 >= 7) goto L26;
        ConversionCategory r8 = r3[r4];
        if (arrayToSet(r8.types).equals(r7) == true) goto L23;
        r4 = r4 + 1;
        goto L20
    L23:
        return r8;
    L26:
        return GENERAL;
    L13:
        if (r6 == INT_AND_TIME) goto L18;
    L27:
        return r0;
    }

    public boolean isAssignableFrom(Class<?> r6) {
        if (this.types != null) goto L6;
        return true;
    L6:
        if (r6 != Void.TYPE) goto L8;
        return true;
    L8:
        Class<?>[] r5 = this.types;
        int r0 = r5.length;
        int r3 = 0;
    L9:
        if (r3 >= r0) goto L14;
        if (r5[r3].isAssignableFrom(r6) == true) goto L12;
        r3 = r3 + 1;
        goto L9
    L12:
        return true;
    L14:
        return false;
    }

    @Override // java.lang.Enum
    @Pure
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append(name());
        r0.append(" conversion category");
        Class<?>[] r1 = this.types;
        if (r1 == null) goto L13;
        if (r1.length == 0) goto L13;
        StringJoiner r2 = new StringJoiner(", ", "(one of: ", ")");
        Class<?>[] r5 = this.types;
        int r3 = r5.length;
        int r4 = 0;
    L8:
        if (r4 >= r3) goto L10;
        r2.add(r5[r4].getSimpleName());
        r4 = r4 + 1;
        goto L8
    L10:
        r0.append(HanziToPinyin.Token.SEPARATOR);
        r0.append(r2);
        return r0.toString();
    L13:
        return r0.toString();
    }
}
