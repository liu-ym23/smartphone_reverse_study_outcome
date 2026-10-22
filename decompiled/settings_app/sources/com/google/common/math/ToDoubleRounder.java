package com.google.common.math;

import com.google.common.base.Preconditions;
import com.obric.oui.material.MaterialConfigFormatNames;
import java.lang.Comparable;
import java.lang.Number;
import java.math.RoundingMode;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
abstract class ToDoubleRounder<X extends Number & Comparable<X>> {

    /* JADX INFO: renamed from: com.google.common.math.ToDoubleRounder$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$java$math$RoundingMode = null;

        static {
            int[] r0 = new int[RoundingMode.values().length];
            $SwitchMap$java$math$RoundingMode = r0;
            r0[RoundingMode.DOWN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L20:
            $SwitchMap$java$math$RoundingMode[RoundingMode.HALF_EVEN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L24:
            $SwitchMap$java$math$RoundingMode[RoundingMode.HALF_DOWN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L34:
            $SwitchMap$java$math$RoundingMode[RoundingMode.HALF_UP.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L22:
            $SwitchMap$java$math$RoundingMode[RoundingMode.FLOOR.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L26:
            $SwitchMap$java$math$RoundingMode[RoundingMode.CEILING.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L28:
            $SwitchMap$java$math$RoundingMode[RoundingMode.UP.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L30:
            $SwitchMap$java$math$RoundingMode[RoundingMode.UNNECESSARY.ordinal()] = 8;     // Catch: NoSuchFieldError -> L19
            return;
        }
    }

    abstract X minus(X r1, X r2);

    abstract double roundToDoubleArbitrarily(X r1);

    abstract int sign(X r1);

    abstract X toX(double r1, RoundingMode r3);

    ToDoubleRounder() {
    }

    final double roundToDouble(X r13, RoundingMode r14) {
        Preconditions.checkNotNull(r13, MaterialConfigFormatNames.X);
        Preconditions.checkNotNull(r14, "mode");
        double r0 = roundToDoubleArbitrarily(r13);
        if (Double.isInfinite(r0) == true) goto L5;
    L21:
        Number r2 = toX(r0, RoundingMode.UNNECESSARY);
        int r7 = ((Comparable) r13).compareTo(r2);
        switch(AnonymousClass1.$SwitchMap$java$math$RoundingMode[r14.ordinal()]) {
            case 1: goto L85;
            case 2: goto L48;
            case 3: goto L48;
            case 4: goto L48;
            case 5: goto L44;
            case 6: goto L40;
            case 7: goto L31;
            case 8: goto L25;
            default: goto L24;
        };
    L25:
        if (r7 != 0) goto L27;
        boolean r12 = true;
    L28:
        MathPreconditions.checkRoundingUnnecessary(r12);
        return r0;
    L27:
        r12 = false;
        goto L28
    L40:
        if (r7 > 0) goto L43;
        return r0;
    L43:
        return Math.nextUp(r0);
    L44:
        if (r7 < 0) goto L47;
        return r0;
    L47:
        return DoubleUtils.nextDown(r0);
    L48:
        if (r7 < 0) goto L53;
        double r3 = Math.nextUp(r0);
        if (r3 != Double.POSITIVE_INFINITY) goto L52;
        return r0;
    L52:
        Number r5 = toX(r3, RoundingMode.CEILING);
    L57:
        Object r4 = minus(r13, r2);
        Comparable r6 = (Comparable) r4;
        int r8 = r6.compareTo(minus(r5, r13));
        if (r8 >= 0) goto L60;
        return r0;
    L60:
        if (r8 <= 0) goto L62;
        return r3;
    L62:
        int r15 = AnonymousClass1.$SwitchMap$java$math$RoundingMode[r14.ordinal()];
        if (r15 == 2) goto L80;
        if (r15 == 3) goto L75;
        if (r15 != 4) goto L73;
        if (sign(r13) >= 0) goto L71;
        return r0;
    L71:
        return r3;
    L73:
        throw new AssertionError("impossible");
    L75:
        if (sign(r13) < 0) goto L78;
        return r0;
    L78:
        return r3;
    L80:
        if ((Double.doubleToRawLongBits(r0) & 1) != 0) goto L83;
        return r0;
    L83:
        return r3;
    L53:
        double r9 = DoubleUtils.nextDown(r0);
        if (r9 != Double.NEGATIVE_INFINITY) goto L56;
        return r0;
    L56:
        Number r10 = toX(r9, RoundingMode.FLOOR);
        r5 = r2;
        r2 = r10;
        r3 = r0;
        r0 = r9;
        goto L57
    L24:
        throw new AssertionError("impossible");
    L31:
        if (sign(r13) < 0) goto L36;
        if (r7 > 0) goto L35;
        return r0;
    L35:
        return Math.nextUp(r0);
    L36:
        if (r7 < 0) goto L39;
        return r0;
    L39:
        return DoubleUtils.nextDown(r0);
    L85:
        if (sign(r13) < 0) goto L90;
        if (r7 < 0) goto L89;
        return r0;
    L89:
        return DoubleUtils.nextDown(r0);
    L90:
        if (r7 > 0) goto L93;
        return r0;
    L93:
        return Math.nextUp(r0);
    L5:
        switch(AnonymousClass1.$SwitchMap$java$math$RoundingMode[r14.ordinal()]) {
            case 1: goto L20;
            case 2: goto L20;
            case 3: goto L20;
            case 4: goto L20;
            case 5: goto L16;
            case 6: goto L11;
            case 7: goto L9;
            case 8: goto L7;
            default: goto L21;
        };
    L7:
        String r16 = String.valueOf(r13);
        throw new ArithmeticException(new StringBuilder(String.valueOf(r16).length() + 44).append(r16).append(" cannot be represented precisely as a double").toString());
    L9:
        return r0;
    L11:
        if (r0 == Double.POSITIVE_INFINITY) goto L94;
        return -1.7976931348623157E308d;
    L94:
        return Double.POSITIVE_INFINITY;
    L16:
        if (r0 == Double.POSITIVE_INFINITY) goto L18;
        return Double.NEGATIVE_INFINITY;
    L18:
        return Double.MAX_VALUE;
    L20:
        return ((double) sign(r13)) * Double.MAX_VALUE;
    }
}
