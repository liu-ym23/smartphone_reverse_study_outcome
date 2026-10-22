package org.apache.commons.math3.random;

import com.android.settings.utils.HanziToPinyin;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;
import org.apache.commons.math3.exception.MathInternalError;
import org.apache.commons.math3.exception.MathParseException;
import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class SobolSequenceGenerator implements RandomVectorGenerator {
    private static final int BITS = 52;
    private static final String FILE_CHARSET = "US-ASCII";
    private static final int MAX_DIMENSION = 1000;
    private static final String RESOURCE_NAME = "/assets/org/apache/commons/math3/random/new-joe-kuo-6.1000";
    private static final double SCALE = 0.0d;
    private int count;
    private final int dimension;
    private final long[][] direction;
    private final long[] x;

    static {
        SCALE = FastMath.pow(2.0d, 52);
    }

    public SobolSequenceGenerator(int r6) throws OutOfRangeException {
        this.count = 0;
        if (r6 < 1) goto L22;
        if (r6 > 1000) goto L22;
        InputStream r1 = getClass().getResourceAsStream(RESOURCE_NAME);
        if (r1 == null) goto L20;
        this.dimension = r6;
        this.direction = (long[][]) Array.newInstance(Long.TYPE, new int[]{r6, 53});
        this.x = new long[r6];
        initFromStream(r1);     // Catch: Throwable -> L11 MathParseException -> L13 IOException -> L15
        r1.close();     // Catch: IOException -> L23
        return;
    L31:
        return;
    L11:
        th = move-exception;
        r1.close();     // Catch: IOException -> L24
    L18:
        throw th;
    L16:
        throw new MathInternalError();     // Catch: Throwable -> L11
    L14:
        throw new MathInternalError();     // Catch: Throwable -> L11
    L20:
        throw new MathInternalError();
    L22:
        throw new OutOfRangeException(Integer.valueOf(r6), 1, 1000);
    }

    public SobolSequenceGenerator(int r5, InputStream r6) throws NotStrictlyPositiveException, MathParseException, IOException {
        this.count = 0;
        if (r5 < 1) goto L10;
        this.dimension = r5;
        this.direction = (long[][]) Array.newInstance(Long.TYPE, new int[]{r5, 53});
        this.x = new long[r5];
        int r4 = initFromStream(r6);
        if (r4 < r5) goto L8;
        return;
    L8:
        throw new OutOfRangeException(Integer.valueOf(r5), 1, Integer.valueOf(r4));
    L10:
        throw new NotStrictlyPositiveException(Integer.valueOf(r5));
    }

    private int initFromStream(InputStream r13) throws MathParseException, IOException {
        int r1 = 1;
    L4:
        if (r1 > 52) goto L6;
        this.direction[0][r1] = 1 << (52 - r1);
        r1 = r1 + 1;
        goto L4
    L6:
        BufferedReader r2 = new BufferedReader(new InputStreamReader(r13, Charset.forName("US-ASCII")));
        r2.readLine();     // Catch: Throwable -> L30
        int r3 = -1;
        int r4 = 2;
        int r5 = 1;
    L8:
        String r6 = r2.readLine();     // Catch: Throwable -> L30
        if (r6 == null) goto L28;
        StringTokenizer r7 = new StringTokenizer(r6, HanziToPinyin.Token.SEPARATOR);     // Catch: Throwable -> L30
        int r8 = Integer.parseInt(r7.nextToken());     // Catch: NumberFormatException -> L24 NoSuchElementException -> L26 Throwable -> L30
        if (r8 < 2) goto L20;
        if (r8 > this.dimension) goto L20;
        int r9 = Integer.parseInt(r7.nextToken());     // Catch: NumberFormatException -> L24 NoSuchElementException -> L26 Throwable -> L30
        int r10 = Integer.parseInt(r7.nextToken());     // Catch: NumberFormatException -> L24 NoSuchElementException -> L26 Throwable -> L30
        int[] r11 = new int[r9 + 1];     // Catch: NumberFormatException -> L24 NoSuchElementException -> L26 Throwable -> L30
        int r12 = 1;
    L16:
        if (r12 > r9) goto L18;
        r11[r12] = Integer.parseInt(r7.nextToken());     // Catch: NumberFormatException -> L24 NoSuchElementException -> L26 Throwable -> L30
        r12 = r12 + 1;     // Catch: NumberFormatException -> L24 NoSuchElementException -> L26 Throwable -> L30
        goto L16
    L18:
        initDirectionVector(r5, r10, r11);     // Catch: NumberFormatException -> L24 NoSuchElementException -> L26 Throwable -> L30
        r5 = r5 + 1;     // Catch: NumberFormatException -> L24 NoSuchElementException -> L26 Throwable -> L30
    L20:
        if (r8 > this.dimension) goto L21;
        r4 = r4 + 1;
        r3 = r8;
        goto L8
    L21:
        r2.close();
        return r8;
    L25:
        throw new MathParseException(r6, r4);     // Catch: Throwable -> L30
    L27:
        throw new MathParseException(r6, r4);     // Catch: Throwable -> L30
    L28:
        r2.close();
        return r3;
    L30:
        th = move-exception;
        r2.close();
        throw th;
    }

    private void initDirectionVector(int r12, int r13, int[] r14) {
        int r0 = r14.length - 1;
        int r2 = 1;
    L3:
        if (r2 > r0) goto L5;
        this.direction[r12][r2] = ((long) r14[r2]) << (52 - r2);
        r2 = r2 + 1;
        goto L3
    L5:
        int r15 = r0 + 1;
    L7:
        if (r15 > 52) goto L13;
        long[] r3 = this.direction[r12];
        long r4 = r3[r15 - r0];
        r3[r15] = r4 ^ (r4 >> r0);
        int r5 = 1;
    L9:
        int r6 = r0 - 1;
        if (r5 > r6) goto L12;
        long[] r7 = this.direction[r12];
        r7[r15] = r7[r15] ^ (((long) ((r13 >> (r6 - r5)) & 1)) * r7[r15 - r5]);
        r5 = r5 + 1;
        goto L9
    L12:
        r15 = r15 + 1;
        goto L7
    }

    @Override // org.apache.commons.math3.random.RandomVectorGenerator
    public double[] nextVector() {
        double[] r0 = new double[this.dimension];
        int r1 = this.count;
        if (r1 != 0) goto L6;
        this.count = r1 + 1;
        return r0;
    L6:
        int r2 = r1 - 1;
        int r3 = 1;
    L8:
        if ((r2 & 1) != 1) goto L10;
        r2 = r2 >> 1;
        r3 = r3 + 1;
        goto L8
    L10:
        int r4 = 0;
    L12:
        if (r4 >= this.dimension) goto L14;
        long[] r5 = this.x;
        long r6 = r5[r4] ^ this.direction[r4][r3];
        r5[r4] = r6;
        r0[r4] = r6 / SCALE;
        r4 = r4 + 1;
        goto L12
    L14:
        this.count++;
        return r0;
    }

    public double[] skipTo(int r13) throws NotPositiveException {
        if (r13 != 0) goto L5;
        Arrays.fill(this.x, 0);
    L16:
        this.count = r13;
        return nextVector();
    L5:
        int r2 = r13 - 1;
        long r3 = r2 ^ (r2 >> 1);
        int r4 = 0;
    L7:
        if (r4 >= this.dimension) goto L16;
        int r5 = 1;
        long r6 = 0;
    L10:
        if (r5 > 52) goto L15;
        long r8 = r3 >> (r5 - 1);
        if (r8 == 0) goto L15;
        r6 = r6 ^ ((r8 & 1) * this.direction[r4][r5]);
        r5 = r5 + 1;
    L15:
        this.x[r4] = r6;
        r4 = r4 + 1;
        goto L7
    }

    public int getNextIndex() {
        return this.count;
    }
}
