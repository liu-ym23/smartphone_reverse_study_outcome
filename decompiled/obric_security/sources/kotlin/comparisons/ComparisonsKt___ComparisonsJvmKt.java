package kotlin.comparisons;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: _ComparisonsJvm.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000F\n\u0002\b\u0002\n\u0002\u0010\u000f\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0005\n\u0002\u0010\u0012\n\u0002\u0010\u0006\n\u0002\u0010\u0013\n\u0002\u0010\u0007\n\u0002\u0010\u0014\n\u0002\u0010\b\n\u0002\u0010\u0015\n\u0002\u0010\t\n\u0002\u0010\u0016\n\u0002\u0010\n\n\u0002\u0010\u0017\n\u0002\b\u0002\u001a-\u0010\u0000\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001a\u0002H\u00012\u0006\u0010\u0004\u001a\u0002H\u0001H\u0007¢\u0006\u0002\u0010\u0005\u001a5\u0010\u0000\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001a\u0002H\u00012\u0006\u0010\u0004\u001a\u0002H\u00012\u0006\u0010\u0006\u001a\u0002H\u0001H\u0007¢\u0006\u0002\u0010\u0007\u001a9\u0010\u0000\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001a\u0002H\u00012\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00010\t\"\u0002H\u0001H\u0007¢\u0006\u0002\u0010\n\u001a\u0019\u0010\u0000\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u000bH\u0087\b\u001a!\u0010\u0000\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u000bH\u0087\b\u001a\u001c\u0010\u0000\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b2\n\u0010\b\u001a\u00020\f\"\u00020\u000bH\u0007\u001a\u0019\u0010\u0000\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\rH\u0087\b\u001a!\u0010\u0000\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\rH\u0087\b\u001a\u001c\u0010\u0000\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\n\u0010\b\u001a\u00020\u000e\"\u00020\rH\u0007\u001a\u0019\u0010\u0000\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u000fH\u0087\b\u001a!\u0010\u0000\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u000fH\u0087\b\u001a\u001c\u0010\u0000\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000f2\n\u0010\b\u001a\u00020\u0010\"\u00020\u000fH\u0007\u001a\u0019\u0010\u0000\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u0011H\u0087\b\u001a!\u0010\u0000\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u0011H\u0087\b\u001a\u001c\u0010\u0000\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00112\n\u0010\b\u001a\u00020\u0012\"\u00020\u0011H\u0007\u001a\u0019\u0010\u0000\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u0013H\u0087\b\u001a!\u0010\u0000\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u0013H\u0087\b\u001a\u001c\u0010\u0000\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00132\n\u0010\b\u001a\u00020\u0014\"\u00020\u0013H\u0007\u001a\u0019\u0010\u0000\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u0015H\u0087\b\u001a!\u0010\u0000\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u0015H\u0087\b\u001a\u001c\u0010\u0000\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00152\n\u0010\b\u001a\u00020\u0016\"\u00020\u0015H\u0007\u001a-\u0010\u0017\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001a\u0002H\u00012\u0006\u0010\u0004\u001a\u0002H\u0001H\u0007¢\u0006\u0002\u0010\u0005\u001a5\u0010\u0017\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001a\u0002H\u00012\u0006\u0010\u0004\u001a\u0002H\u00012\u0006\u0010\u0006\u001a\u0002H\u0001H\u0007¢\u0006\u0002\u0010\u0007\u001a9\u0010\u0017\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001a\u0002H\u00012\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00010\t\"\u0002H\u0001H\u0007¢\u0006\u0002\u0010\n\u001a\u0019\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u000bH\u0087\b\u001a!\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u000bH\u0087\b\u001a\u001c\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b2\n\u0010\b\u001a\u00020\f\"\u00020\u000bH\u0007\u001a\u0019\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\rH\u0087\b\u001a!\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\rH\u0087\b\u001a\u001c\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\n\u0010\b\u001a\u00020\u000e\"\u00020\rH\u0007\u001a\u0019\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u000fH\u0087\b\u001a!\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u000fH\u0087\b\u001a\u001c\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000f2\n\u0010\b\u001a\u00020\u0010\"\u00020\u000fH\u0007\u001a\u0019\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u0011H\u0087\b\u001a!\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u0011H\u0087\b\u001a\u001c\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00112\n\u0010\b\u001a\u00020\u0012\"\u00020\u0011H\u0007\u001a\u0019\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u0013H\u0087\b\u001a!\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u0013H\u0087\b\u001a\u001c\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00132\n\u0010\b\u001a\u00020\u0014\"\u00020\u0013H\u0007\u001a\u0019\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u0015H\u0087\b\u001a!\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u0015H\u0087\b\u001a\u001c\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00152\n\u0010\b\u001a\u00020\u0016\"\u00020\u0015H\u0007¨\u0006\u0018"}, d2 = {"maxOf", ExifInterface.GPS_DIRECTION_TRUE, "", "a", "b", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Ljava/lang/Comparable;", "c", "(Ljava/lang/Comparable;Ljava/lang/Comparable;Ljava/lang/Comparable;)Ljava/lang/Comparable;", "other", "", "(Ljava/lang/Comparable;[Ljava/lang/Comparable;)Ljava/lang/Comparable;", "", "", "", "", "", "", "", "", "", "", "", "", "minOf", "kotlin-stdlib"}, k = 5, mv = {1, 8, 0}, xi = 49, xs = "kotlin/comparisons/ComparisonsKt")
class ComparisonsKt___ComparisonsJvmKt extends ComparisonsKt__ComparisonsKt {
    public ComparisonsKt___ComparisonsJvmKt() {
    }

    public static final <T extends Comparable<? super T>> T maxOf(T r1, T r2) {
        Intrinsics.checkNotNullParameter(r1, "a");
        Intrinsics.checkNotNullParameter(r2, "b");
        if (r1.compareTo(r2) < 0) goto L6;
        return r1;
    L6:
        return r2;
    }

    private static final byte maxOf(byte r0, byte r1) {
        return (byte) Math.max(r0, r1);
    }

    private static final short maxOf(short r0, short r1) {
        return (short) Math.max(r0, r1);
    }

    private static final int maxOf(int r0, int r1) {
        return Math.max(r0, r1);
    }

    private static final long maxOf(long r0, long r2) {
        return Math.max(r0, r2);
    }

    private static final float maxOf(float r0, float r1) {
        return Math.max(r0, r1);
    }

    private static final double maxOf(double r0, double r2) {
        return Math.max(r0, r2);
    }

    public static final <T extends Comparable<? super T>> T maxOf(T r1, T r2, T r3) {
        Intrinsics.checkNotNullParameter(r1, "a");
        Intrinsics.checkNotNullParameter(r2, "b");
        Intrinsics.checkNotNullParameter(r3, "c");
        return (T) ComparisonsKt.maxOf(r1, ComparisonsKt.maxOf(r2, r3));
    }

    private static final byte maxOf(byte r0, byte r1, byte r2) {
        return (byte) Math.max(r0, Math.max(r1, r2));
    }

    private static final short maxOf(short r0, short r1, short r2) {
        return (short) Math.max(r0, Math.max(r1, r2));
    }

    private static final int maxOf(int r0, int r1, int r2) {
        return Math.max(r0, Math.max(r1, r2));
    }

    private static final long maxOf(long r0, long r2, long r4) {
        return Math.max(r0, Math.max(r2, r4));
    }

    private static final float maxOf(float r0, float r1, float r2) {
        return Math.max(r0, Math.max(r1, r2));
    }

    private static final double maxOf(double r0, double r2, double r4) {
        return Math.max(r0, Math.max(r2, r4));
    }

    public static final <T extends Comparable<? super T>> T maxOf(T r3, T... r4) {
        Intrinsics.checkNotNullParameter(r3, "a");
        Intrinsics.checkNotNullParameter(r4, "other");
        int r0 = r4.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        T r5 = r3;
        r3 = (T) ComparisonsKt.maxOf(r5, r4[r1]);
        r1 = r1 + 1;
        goto L3
    L5:
        return r3;
    }

    public static final byte maxOf(byte r3, byte... r4) {
        Intrinsics.checkNotNullParameter(r4, "other");
        int r0 = r4.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r3 = (byte) Math.max(r3, r4[r1]);
        r1 = r1 + 1;
        goto L3
    L5:
        return r3;
    }

    public static final short maxOf(short r3, short... r4) {
        Intrinsics.checkNotNullParameter(r4, "other");
        int r0 = r4.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r3 = (short) Math.max(r3, r4[r1]);
        r1 = r1 + 1;
        goto L3
    L5:
        return r3;
    }

    public static final int maxOf(int r3, int... r4) {
        Intrinsics.checkNotNullParameter(r4, "other");
        int r0 = r4.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r3 = Math.max(r3, r4[r1]);
        r1 = r1 + 1;
        goto L3
    L5:
        return r3;
    }

    public static final long maxOf(long r4, long... r6) {
        Intrinsics.checkNotNullParameter(r6, "other");
        int r0 = r6.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r4 = Math.max(r4, r6[r1]);
        r1 = r1 + 1;
        goto L3
    L5:
        return r4;
    }

    public static final float maxOf(float r3, float... r4) {
        Intrinsics.checkNotNullParameter(r4, "other");
        int r0 = r4.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r3 = Math.max(r3, r4[r1]);
        r1 = r1 + 1;
        goto L3
    L5:
        return r3;
    }

    public static final double maxOf(double r4, double... r6) {
        Intrinsics.checkNotNullParameter(r6, "other");
        int r0 = r6.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r4 = Math.max(r4, r6[r1]);
        r1 = r1 + 1;
        goto L3
    L5:
        return r4;
    }

    public static final <T extends Comparable<? super T>> T minOf(T r1, T r2) {
        Intrinsics.checkNotNullParameter(r1, "a");
        Intrinsics.checkNotNullParameter(r2, "b");
        if (r1.compareTo(r2) > 0) goto L6;
        return r1;
    L6:
        return r2;
    }

    private static final byte minOf(byte r0, byte r1) {
        return (byte) Math.min(r0, r1);
    }

    private static final short minOf(short r0, short r1) {
        return (short) Math.min(r0, r1);
    }

    private static final int minOf(int r0, int r1) {
        return Math.min(r0, r1);
    }

    private static final long minOf(long r0, long r2) {
        return Math.min(r0, r2);
    }

    private static final float minOf(float r0, float r1) {
        return Math.min(r0, r1);
    }

    private static final double minOf(double r0, double r2) {
        return Math.min(r0, r2);
    }

    public static final <T extends Comparable<? super T>> T minOf(T r1, T r2, T r3) {
        Intrinsics.checkNotNullParameter(r1, "a");
        Intrinsics.checkNotNullParameter(r2, "b");
        Intrinsics.checkNotNullParameter(r3, "c");
        return (T) ComparisonsKt.minOf(r1, ComparisonsKt.minOf(r2, r3));
    }

    private static final byte minOf(byte r0, byte r1, byte r2) {
        return (byte) Math.min(r0, Math.min(r1, r2));
    }

    private static final short minOf(short r0, short r1, short r2) {
        return (short) Math.min(r0, Math.min(r1, r2));
    }

    private static final int minOf(int r0, int r1, int r2) {
        return Math.min(r0, Math.min(r1, r2));
    }

    private static final long minOf(long r0, long r2, long r4) {
        return Math.min(r0, Math.min(r2, r4));
    }

    private static final float minOf(float r0, float r1, float r2) {
        return Math.min(r0, Math.min(r1, r2));
    }

    private static final double minOf(double r0, double r2, double r4) {
        return Math.min(r0, Math.min(r2, r4));
    }

    public static final <T extends Comparable<? super T>> T minOf(T r3, T... r4) {
        Intrinsics.checkNotNullParameter(r3, "a");
        Intrinsics.checkNotNullParameter(r4, "other");
        int r0 = r4.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        T r5 = r3;
        r3 = (T) ComparisonsKt.minOf(r5, r4[r1]);
        r1 = r1 + 1;
        goto L3
    L5:
        return r3;
    }

    public static final byte minOf(byte r3, byte... r4) {
        Intrinsics.checkNotNullParameter(r4, "other");
        int r0 = r4.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r3 = (byte) Math.min(r3, r4[r1]);
        r1 = r1 + 1;
        goto L3
    L5:
        return r3;
    }

    public static final short minOf(short r3, short... r4) {
        Intrinsics.checkNotNullParameter(r4, "other");
        int r0 = r4.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r3 = (short) Math.min(r3, r4[r1]);
        r1 = r1 + 1;
        goto L3
    L5:
        return r3;
    }

    public static final int minOf(int r3, int... r4) {
        Intrinsics.checkNotNullParameter(r4, "other");
        int r0 = r4.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r3 = Math.min(r3, r4[r1]);
        r1 = r1 + 1;
        goto L3
    L5:
        return r3;
    }

    public static final long minOf(long r4, long... r6) {
        Intrinsics.checkNotNullParameter(r6, "other");
        int r0 = r6.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r4 = Math.min(r4, r6[r1]);
        r1 = r1 + 1;
        goto L3
    L5:
        return r4;
    }

    public static final float minOf(float r3, float... r4) {
        Intrinsics.checkNotNullParameter(r4, "other");
        int r0 = r4.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r3 = Math.min(r3, r4[r1]);
        r1 = r1 + 1;
        goto L3
    L5:
        return r3;
    }

    public static final double minOf(double r4, double... r6) {
        Intrinsics.checkNotNullParameter(r6, "other");
        int r0 = r6.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r4 = Math.min(r4, r6[r1]);
        r1 = r1 + 1;
        goto L3
    L5:
        return r4;
    }
}
