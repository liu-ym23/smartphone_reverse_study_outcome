package org.apache.commons.math3.transform;

import com.android.vcard.VCardConfig;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.lang.reflect.Array;
import java.util.Arrays;
import org.apache.commons.math3.complex.Complex;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;

/* JADX INFO: loaded from: classes6.dex */
public class TransformUtils {
    private static final int[] POWERS_OF_TWO = null;

    static {
        POWERS_OF_TWO = new int[]{1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 131072, 262144, 524288, 1048576, 2097152, 4194304, 8388608, 16777216, VCardConfig.FLAG_REFRAIN_PHONE_NUMBER_FORMATTING, VCardConfig.FLAG_APPEND_TYPE_PARAM, VCardConfig.FLAG_CONVERT_PHONETIC_NAME_STRINGS, 268435456, SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING, 1073741824};
    }

    private TransformUtils() {
    }

    public static double[] scaleArray(double[] r3, double r4) {
        int r0 = 0;
    L4:
        if (r0 >= r3.length) goto L6;
        r3[r0] = r3[r0] * r4;
        r0 = r0 + 1;
        goto L4
    L6:
        return r3;
    }

    public static Complex[] scaleArray(Complex[] r6, double r7) {
        int r0 = 0;
    L4:
        if (r0 >= r6.length) goto L6;
        r6[r0] = new Complex(r6[r0].getReal() * r7, r6[r0].getImaginary() * r7);
        r0 = r0 + 1;
        goto L4
    L6:
        return r6;
    }

    public static double[][] createRealImaginaryArray(Complex[] r7) {
        int r0 = 0;
        double[][] r1 = (double[][]) Array.newInstance(Double.TYPE, new int[]{2, r7.length});
        double[] r2 = r1[0];
        double[] r3 = r1[1];
    L4:
        if (r0 >= r7.length) goto L6;
        Complex r4 = r7[r0];
        r2[r0] = r4.getReal();
        r3[r0] = r4.getImaginary();
        r0 = r0 + 1;
        goto L4
    L6:
        return r1;
    }

    public static Complex[] createComplexArray(double[][] r9) throws DimensionMismatchException {
        if (r9.length != 2) goto L13;
        int r0 = 0;
        double[] r1 = r9[0];
        double[] r10 = r9[1];
        if (r1.length != r10.length) goto L11;
        int r2 = r1.length;
        Complex[] r3 = new Complex[r2];
    L7:
        if (r0 >= r2) goto L9;
        r3[r0] = new Complex(r1[r0], r10[r0]);
        r0 = r0 + 1;
        goto L7
    L9:
        return r3;
    L11:
        throw new DimensionMismatchException(r10.length, r1.length);
    L13:
        throw new DimensionMismatchException(r9.length, 2);
    }

    public static int exactLog2(int r4) throws MathIllegalArgumentException {
        int r0 = Arrays.binarySearch(POWERS_OF_TWO, r4);
        if (r0 < 0) goto L6;
        return r0;
    L6:
        throw new MathIllegalArgumentException(LocalizedFormats.NOT_POWER_OF_TWO_CONSIDER_PADDING, new Object[]{Integer.valueOf(r4)});
    }
}
