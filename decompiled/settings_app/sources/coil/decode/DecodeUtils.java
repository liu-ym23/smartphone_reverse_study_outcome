package coil.decode;

import coil.size.Scale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: DecodeUtils.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J8\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0006\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u00042\b\b\u0001\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0007J8\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\u0005\u001a\u00020\f2\b\b\u0001\u0010\u0006\u001a\u00020\f2\b\b\u0001\u0010\u0007\u001a\u00020\f2\b\b\u0001\u0010\b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nH\u0007J8\u0010\u000b\u001a\u00020\r2\b\b\u0001\u0010\u0005\u001a\u00020\r2\b\b\u0001\u0010\u0006\u001a\u00020\r2\b\b\u0001\u0010\u0007\u001a\u00020\r2\b\b\u0001\u0010\b\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\nH\u0007J8\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0006\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u00042\b\b\u0001\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0007¨\u0006\u000e"}, d2 = {"Lcoil/decode/DecodeUtils;", "", "()V", "calculateInSampleSize", "", "srcWidth", "srcHeight", "dstWidth", "dstHeight", "scale", "Lcoil/size/Scale;", "computeSizeMultiplier", "", "", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DecodeUtils {
    public static final DecodeUtils INSTANCE = null;

    /* JADX INFO: compiled from: DecodeUtils.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[Scale.values().length];
            r0[Scale.FILL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[Scale.FIT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            $EnumSwitchMapping$0 = r0;
        }
    }

    static {
        INSTANCE = new DecodeUtils();
    }

    private DecodeUtils() {
    }

    @JvmStatic
    public static final int calculateInSampleSize(int r0, int r1, int r2, int r3, Scale r4) {
        int r5 = Integer.highestOneBit(r0 / r2);
        int r6 = Integer.highestOneBit(r1 / r3);
        int r7 = WhenMappings.$EnumSwitchMapping$0[r4.ordinal()];
        if (r7 != 1) goto L5;
        int r8 = Math.min(r5, r6);
    L11:
        return RangesKt.coerceAtLeast(r8, 1);
    L5:
        if (r7 != 2) goto L8;
        r8 = Math.max(r5, r6);
        goto L11
    L8:
        throw new NoWhenBranchMatchedException();
    }

    @JvmStatic
    public static final double computeSizeMultiplier(int r4, int r5, int r6, int r7, Scale r8) {
        double r0 = ((double) r6) / ((double) r4);
        double r9 = ((double) r7) / ((double) r5);
        int r10 = WhenMappings.$EnumSwitchMapping$0[r8.ordinal()];
        if (r10 == 1) goto L10;
        if (r10 != 2) goto L8;
        return Math.min(r0, r9);
    L8:
        throw new NoWhenBranchMatchedException();
    L10:
        return Math.max(r0, r9);
    }

    @JvmStatic
    public static final float computeSizeMultiplier(float r0, float r1, float r2, float r3, Scale r4) {
        float r5 = r2 / r0;
        float r6 = r3 / r1;
        int r7 = WhenMappings.$EnumSwitchMapping$0[r4.ordinal()];
        if (r7 == 1) goto L10;
        if (r7 != 2) goto L8;
        return Math.min(r5, r6);
    L8:
        throw new NoWhenBranchMatchedException();
    L10:
        return Math.max(r5, r6);
    }

    @JvmStatic
    public static final double computeSizeMultiplier(double r0, double r2, double r4, double r6, Scale r8) {
        double r5 = r4 / r0;
        double r7 = r6 / r2;
        int r1 = WhenMappings.$EnumSwitchMapping$0[r8.ordinal()];
        if (r1 == 1) goto L10;
        if (r1 != 2) goto L8;
        return Math.min(r5, r7);
    L8:
        throw new NoWhenBranchMatchedException();
    L10:
        return Math.max(r5, r7);
    }
}
