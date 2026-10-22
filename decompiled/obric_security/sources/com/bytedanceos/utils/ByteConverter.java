package com.bytedanceos.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

/* JADX INFO: loaded from: classes2.dex */
public class ByteConverter {
    public static final int BASE_1000 = 1000;
    public static final int BASE_1024 = 1024;
    private static final String[] UNITS = null;

    public ByteConverter() {
    }

    static {
        UNITS = new String[]{"B", "KB", "MB", "GB", "TB"};
    }

    public static ByteUnitPair convertGB(double bytes, int base, int scale) {
        if (bytes == 0.0d) goto L5;
        double r2 = base;
        return new ByteUnitPair(BigDecimal.valueOf(((bytes / r2) / r2) / r2).setScale(scale, RoundingMode.HALF_UP).stripTrailingZeros().toPlainString(), " GB");
    L5:
        return new ByteUnitPair("0", " GB");
    }

    public static ByteUnitPair convert(double bytes, String minUnit, int base) {
        return convert(bytes, "B", minUnit, base, -1);
    }

    public static ByteUnitPair convert(double bytes, String fromUnit, String minUnit, int base, int forceScale) {
        int r11 = getUnitIndex(fromUnit);
        int r0 = getUnitIndex(minUnit);
        if (bytes != 0.0d) goto L11;
        if (minUnit.equals("B") == false) goto L9;
        return new ByteUnitPair("0", " B");
    L9:
        return new ByteUnitPair("0", " " + minUnit);
    L11:
        if (r11 >= (UNITS.length - 1)) goto L15;
        double r4 = base;
        if (bytes < r4) goto L15;
        bytes = bytes / r4;
        r11 = r11 + 1;
    L15:
        if (r0 <= r11) goto L17;
        bytes = bytes / ((double) base);
        r11 = r11 + 1;
        goto L15
    L17:
        if (r11 != 0) goto L19;
        int r1 = 0;
    L20:
        if (forceScale < 0) goto L22;
        r1 = forceScale;
    L22:
        BigDecimal r9 = BigDecimal.valueOf(bytes).setScale(r1, RoundingMode.HALF_UP);
        if (r9.doubleValue() < base) goto L29;
        String[] r10 = UNITS;
        if (r11 >= (r10.length - 1)) goto L29;
        return convert(r9.doubleValue(), r10[r11], minUnit, base, forceScale);
    L29:
        return new ByteUnitPair(r9.stripTrailingZeros().toPlainString(), " " + UNITS[r11]);
    L19:
        r1 = 1;
        goto L20
    }

    private static int getUnitIndex(String unit) {
        int r0 = 0;
    L3:
        String[] r1 = UNITS;
        if (r0 >= r1.length) goto L10;
        if (r1[r0].equals(unit) == true) goto L7;
        r0 = r0 + 1;
        goto L3
    L7:
        return r0;
    L10:
        throw new IllegalArgumentException("Invalid unit: " + unit);
    }
}
