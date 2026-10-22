package com.obric.common.oea.foundation.graphics.smoothcorner;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.obric.common.oea.foundation.R;
import com.obric.common.oea.foundation.graphics.smoothcorner.impl.BasicRoundCornerImpl;
import com.obric.common.oea.foundation.graphics.smoothcorner.impl.FigmaSmoothCornerImpl;
import com.obric.common.oea.foundation.graphics.smoothcorner.impl.ISmoothCornerImpl;
import com.obric.common.oea.foundation.graphics.smoothcorner.impl.Point;
import com.obric.common.oea.foundation.graphics.smoothcorner.impl.QuadraticSmoothCornerExImpl;
import com.obric.common.oea.foundation.graphics.smoothcorner.impl.QuadraticSmoothCornerImpl;
import com.obric.common.oea.foundation.graphics.smoothcorner.impl.SketchSmoothCornerImpl;
import com.obric.common.oea.foundation.util.OEALogger;
import com.obric.common.oea.foundation.util.SdkInit;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: SmoothCornerHelper.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 42\u00020\u0001:\u00014B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0004J\u0016\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u0004J.\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0004J\u0016\u0010\"\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u0004J\u0016\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)J>\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0004J&\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010\u001a\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010(\u001a\u00020)J\u0018\u0010*\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0002J(\u0010+\u001a\u00020,2\u0006\u0010 \u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u0004H\u0002J\u000e\u0010-\u001a\u00020%2\u0006\u0010.\u001a\u00020/J\u0016\u0010-\u001a\u00020%2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u0004J\u0016\u00101\u001a\u00020%2\u0006\u00102\u001a\u00020\u00042\u0006\u00103\u001a\u00020\u0004R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u000e\u0010\u0012\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/obric/common/oea/foundation/graphics/smoothcorner/SmoothCornerHelper;", "", "()V", "rectHeight", "", "getRectHeight", "()F", "setRectHeight", "(F)V", "rectWidth", "getRectWidth", "setRectWidth", "roundBl", "", "roundBr", "roundRadius", "getRoundRadius", "setRoundRadius", "roundTl", "roundTr", "sdkInit", "Lcom/obric/common/oea/foundation/util/SdkInit;", "smoothCornerImpl", "Lcom/obric/common/oea/foundation/graphics/smoothcorner/impl/ISmoothCornerImpl;", "buildPath", "Landroid/graphics/Path;", "rect", "Landroid/graphics/Rect;", "radius", "Landroid/graphics/RectF;", "left", "top", "right", "bottom", "canDraw", "minDimension", "drawRoundRect", "", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "drawRoundRectInternal", "getPosXY", "Lcom/obric/common/oea/foundation/graphics/smoothcorner/impl/Point;", "setCurveType", "curveType", "Lcom/obric/common/oea/foundation/graphics/smoothcorner/SmoothCornerHelper$Companion$CurveType;", "safeRadiusFactor", "updateRectSize", "w", "h", "Companion", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class SmoothCornerHelper {
    public static final Companion Companion = null;
    private static final String TAG = "SmoothCornerHelper";
    private static final List<Integer> validSmoothCornerRadius = null;
    private float rectHeight;
    private float rectWidth;
    private boolean roundBl;
    private boolean roundBr;
    private float roundRadius;
    private boolean roundTl;
    private boolean roundTr;
    private final SdkInit sdkInit;
    private ISmoothCornerImpl smoothCornerImpl;

    /* JADX INFO: compiled from: SmoothCornerHelper.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0015B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J#\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0001¢\u0006\u0002\b\rJ\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0007H\u0007J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0007H\u0007J\u0014\u0010\u0011\u001a\u00020\u0012*\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0007H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/obric/common/oea/foundation/graphics/smoothcorner/SmoothCornerHelper$Companion;", "", "()V", "TAG", "", "validSmoothCornerRadius", "", "", "getValidSmoothCornerRadius", "()Ljava/util/List;", "findClosestValue", "target", "arr", "findClosestValue$foundation_standardRelease", "getDrawableRes", "cornerRadius", "getHorizontalCapsuleDrawableRes", "fillWithColor", "", "Landroid/graphics/drawable/Drawable;", "color", "CurveType", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {

        /* JADX INFO: compiled from: SmoothCornerHelper.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/obric/common/oea/foundation/graphics/smoothcorner/SmoothCornerHelper$Companion$CurveType;", "", "(Ljava/lang/String;I)V", "QUADRATIC", "SKETCH", "FIGMA", "BASIC", "QUADRATIC_CAPSULE", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
        public static final enum CurveType extends Enum<CurveType> {
            private static final /* synthetic */ CurveType[] $VALUES = null;
            public static final CurveType BASIC = null;
            public static final CurveType FIGMA = null;
            public static final CurveType QUADRATIC = null;
            public static final CurveType QUADRATIC_CAPSULE = null;
            public static final CurveType SKETCH = null;

            static {
                CurveType r1 = new CurveType("QUADRATIC", 0);
                QUADRATIC = r1;
                CurveType r2 = new CurveType("SKETCH", 1);
                SKETCH = r2;
                CurveType r3 = new CurveType("FIGMA", 2);
                FIGMA = r3;
                CurveType r4 = new CurveType("BASIC", 3);
                BASIC = r4;
                CurveType r5 = new CurveType("QUADRATIC_CAPSULE", 4);
                QUADRATIC_CAPSULE = r5;
                $VALUES = new CurveType[]{r1, r2, r3, r4, r5};
            }

            public static CurveType valueOf(String r1) {
                return (CurveType) Enum.valueOf(CurveType.class, r1);
            }

            public static CurveType[] values() {
                return (CurveType[]) $VALUES.clone();
            }

            private CurveType(String r1, int r2) {
                super(r1, r2);
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final List<Integer> getValidSmoothCornerRadius() {
            return SmoothCornerHelper.access$getValidSmoothCornerRadius$cp();
        }

        @JvmStatic
        public final int getDrawableRes(int r7) {
            int r6 = findClosestValue$foundation_standardRelease(r7, getValidSmoothCornerRadius());
            if (r6 == r7) goto L5;
            OEALogger.e$default(OEALogger.INSTANCE, SmoothCornerHelper.TAG, "getDrawableRes, invalid cornerRadius: " + r7 + ", use " + r6 + " instead", null, 4, null);
        L5:
            switch(r6) {
                case 8: goto L29;
                case 9: goto L7;
                case 10: goto L49;
                case 11: goto L7;
                case 12: goto L48;
                case 13: goto L7;
                case 14: goto L47;
                case 15: goto L7;
                case 16: goto L46;
                case 17: goto L7;
                case 18: goto L45;
                case 19: goto L7;
                case 20: goto L44;
                case 21: goto L7;
                case 22: goto L43;
                case 23: goto L7;
                case 24: goto L42;
                case 25: goto L7;
                case 26: goto L41;
                case 27: goto L7;
                case 28: goto L40;
                case 29: goto L7;
                case 30: goto L39;
                case 31: goto L7;
                case 32: goto L38;
                case 33: goto L7;
                case 34: goto L37;
                case 35: goto L7;
                case 36: goto L36;
                case 37: goto L7;
                case 38: goto L35;
                case 39: goto L7;
                case 40: goto L34;
                case 41: goto L7;
                case 42: goto L33;
                case 43: goto L7;
                case 44: goto L32;
                case 45: goto L7;
                case 46: goto L31;
                case 47: goto L7;
                case 48: goto L30;
                default: goto L7;
            };
        L7:
            throw new IllegalArgumentException("invalid cornerRadius: " + r7);
        L30:
            return R.drawable.ic_smoothcorner_rect_48;
        L31:
            return R.drawable.ic_smoothcorner_rect_46;
        L32:
            return R.drawable.ic_smoothcorner_rect_44;
        L33:
            return R.drawable.ic_smoothcorner_rect_42;
        L34:
            return R.drawable.ic_smoothcorner_rect_40;
        L35:
            return R.drawable.ic_smoothcorner_rect_38;
        L36:
            return R.drawable.ic_smoothcorner_rect_36;
        L37:
            return R.drawable.ic_smoothcorner_rect_34;
        L38:
            return R.drawable.ic_smoothcorner_rect_32;
        L39:
            return R.drawable.ic_smoothcorner_rect_30;
        L40:
            return R.drawable.ic_smoothcorner_rect_28;
        L41:
            return R.drawable.ic_smoothcorner_rect_26;
        L42:
            return R.drawable.ic_smoothcorner_rect_24;
        L43:
            return R.drawable.ic_smoothcorner_rect_22;
        L44:
            return R.drawable.ic_smoothcorner_rect_20;
        L45:
            return R.drawable.ic_smoothcorner_rect_18;
        L46:
            return R.drawable.ic_smoothcorner_rect_16;
        L47:
            return R.drawable.ic_smoothcorner_rect_14;
        L48:
            return R.drawable.ic_smoothcorner_rect_12;
        L49:
            return R.drawable.ic_smoothcorner_rect_10;
        L29:
            return R.drawable.ic_smoothcorner_rect_8;
        }

        @JvmStatic
        public final int getHorizontalCapsuleDrawableRes(int r7) {
            int r6 = findClosestValue$foundation_standardRelease(r7, getValidSmoothCornerRadius());
            if (r6 == r7) goto L5;
            OEALogger.e$default(OEALogger.INSTANCE, SmoothCornerHelper.TAG, "getHorizontalCapsuleDrawableRes, invalid cornerRadius: " + r7 + ", use " + r6 + " instead", null, 4, null);
        L5:
            switch(r6) {
                case 8: goto L29;
                case 9: goto L7;
                case 10: goto L49;
                case 11: goto L7;
                case 12: goto L48;
                case 13: goto L7;
                case 14: goto L47;
                case 15: goto L7;
                case 16: goto L46;
                case 17: goto L7;
                case 18: goto L45;
                case 19: goto L7;
                case 20: goto L44;
                case 21: goto L7;
                case 22: goto L43;
                case 23: goto L7;
                case 24: goto L42;
                case 25: goto L7;
                case 26: goto L41;
                case 27: goto L7;
                case 28: goto L40;
                case 29: goto L7;
                case 30: goto L39;
                case 31: goto L7;
                case 32: goto L38;
                case 33: goto L7;
                case 34: goto L37;
                case 35: goto L7;
                case 36: goto L36;
                case 37: goto L7;
                case 38: goto L35;
                case 39: goto L7;
                case 40: goto L34;
                case 41: goto L7;
                case 42: goto L33;
                case 43: goto L7;
                case 44: goto L32;
                case 45: goto L7;
                case 46: goto L31;
                case 47: goto L7;
                case 48: goto L30;
                default: goto L7;
            };
        L7:
            throw new IllegalArgumentException("invalid cornerRadius: " + r7);
        L30:
            return R.drawable.ic_smoothcorner_capsule_48;
        L31:
            return R.drawable.ic_smoothcorner_capsule_46;
        L32:
            return R.drawable.ic_smoothcorner_capsule_44;
        L33:
            return R.drawable.ic_smoothcorner_capsule_42;
        L34:
            return R.drawable.ic_smoothcorner_capsule_40;
        L35:
            return R.drawable.ic_smoothcorner_capsule_38;
        L36:
            return R.drawable.ic_smoothcorner_capsule_36;
        L37:
            return R.drawable.ic_smoothcorner_capsule_34;
        L38:
            return R.drawable.ic_smoothcorner_capsule_32;
        L39:
            return R.drawable.ic_smoothcorner_capsule_30;
        L40:
            return R.drawable.ic_smoothcorner_capsule_28;
        L41:
            return R.drawable.ic_smoothcorner_capsule_26;
        L42:
            return R.drawable.ic_smoothcorner_capsule_24;
        L43:
            return R.drawable.ic_smoothcorner_capsule_22;
        L44:
            return R.drawable.ic_smoothcorner_capsule_20;
        L45:
            return R.drawable.ic_smoothcorner_capsule_18;
        L46:
            return R.drawable.ic_smoothcorner_capsule_16;
        L47:
            return R.drawable.ic_smoothcorner_capsule_14;
        L48:
            return R.drawable.ic_smoothcorner_capsule_12;
        L49:
            return R.drawable.ic_smoothcorner_capsule_10;
        L29:
            return R.drawable.ic_smoothcorner_capsule_8;
        }

        @JvmStatic
        public final void fillWithColor(Drawable r1, int r2) {
            Intrinsics.checkNotNullParameter(r1, "$this$fillWithColor");
            r1.mutate();
            r1.setColorFilter(r2, PorterDuff.Mode.SRC_IN);
        }

        @JvmStatic
        public final int findClosestValue$foundation_standardRelease(int r4, List<Integer> r5) {
            Intrinsics.checkNotNullParameter(r5, "arr");
            if (r5.contains(Integer.valueOf(r4)) == false) goto L5;
            return r4;
        L5:
            int r0 = r5.get(0).intValue();
            int r3 = Math.abs(r4 - r5.get(0).intValue());
            Iterator<Integer> r6 = r5.iterator();
        L7:
            if (r6.hasNext() == false) goto L11;
            int r1 = r6.next().intValue();
            int r2 = Math.abs(r4 - r1);
            if (r2 >= r3) goto L7;
            r0 = r1;
            r3 = r2;
            goto L7
        L11:
            return r0;
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[Companion.CurveType.values().length];
            $EnumSwitchMapping$0 = r0;
            r0[Companion.CurveType.BASIC.ordinal()] = 1;
            r0[Companion.CurveType.QUADRATIC.ordinal()] = 2;
            r0[Companion.CurveType.SKETCH.ordinal()] = 3;
            r0[Companion.CurveType.FIGMA.ordinal()] = 4;
            r0[Companion.CurveType.QUADRATIC_CAPSULE.ordinal()] = 5;
        }
    }

    @JvmStatic
    public static final void fillWithColor(Drawable r1, int r2) {
        Companion.fillWithColor(r1, r2);
    }

    @JvmStatic
    public static final int findClosestValue$foundation_standardRelease(int r1, List<Integer> r2) {
        return Companion.findClosestValue$foundation_standardRelease(r1, r2);
    }

    @JvmStatic
    public static final int getDrawableRes(int r1) {
        return Companion.getDrawableRes(r1);
    }

    @JvmStatic
    public static final int getHorizontalCapsuleDrawableRes(int r1) {
        return Companion.getHorizontalCapsuleDrawableRes(r1);
    }

    public SmoothCornerHelper() {
        this.sdkInit = new SdkInit();
        this.smoothCornerImpl = new QuadraticSmoothCornerImpl(0.0f, 1, null);
        this.rectWidth = -1.0f;
        this.rectHeight = -1.0f;
        this.roundRadius = -1.0f;
        this.roundTl = true;
        this.roundTr = true;
        this.roundBl = true;
        this.roundBr = true;
    }

    public static final /* synthetic */ List access$getValidSmoothCornerRadius$cp() {
        return validSmoothCornerRadius;
    }

    public final float getRectWidth() {
        return this.rectWidth;
    }

    public final void setRectWidth(float r1) {
        this.rectWidth = r1;
    }

    public final float getRectHeight() {
        return this.rectHeight;
    }

    public final void setRectHeight(float r1) {
        this.rectHeight = r1;
    }

    public final float getRoundRadius() {
        return this.roundRadius;
    }

    public final void setRoundRadius(float r1) {
        this.roundRadius = r1;
    }

    public final void updateRectSize(float r1, float r2) {
        this.rectWidth = r1;
        this.rectHeight = r2;
    }

    public final void setCurveType(Companion.CurveType r2) {
        Intrinsics.checkNotNullParameter(r2, "curveType");
        setCurveType(r2, -1.0f);
    }

    public final void setCurveType(Companion.CurveType r4, float r5) {
        Intrinsics.checkNotNullParameter(r4, "curveType");
        OEALogger.INSTANCE.d(TAG, "setCurveType: " + r4);
        int r6 = WhenMappings.$EnumSwitchMapping$0[r4.ordinal()];
        if (r6 != 1) goto L5;
        BasicRoundCornerImpl r7 = new BasicRoundCornerImpl();
    L25:
        this.smoothCornerImpl = r7;
        return;
    L5:
        if (r6 == 2) goto L18;
        if (r6 != 3) goto L9;
        r7 = new SketchSmoothCornerImpl();
        goto L25
    L9:
        if (r6 != 4) goto L11;
        r7 = new FigmaSmoothCornerImpl();
        goto L25
    L11:
        if (r6 != 5) goto L14;
        r7 = new QuadraticSmoothCornerExImpl();
        goto L25
    L14:
        throw new NoWhenBranchMatchedException();
    L18:
        if (r5 > 0) goto L20;
    L22:
        QuadraticSmoothCornerImpl r8 = new QuadraticSmoothCornerImpl(0.0f, 1, null);
    L23:
        r7 = r8;
        goto L25
    L20:
        if (r5 > 0.5f) goto L22;
        r8 = new QuadraticSmoothCornerImpl(r5);
        goto L23
    }

    public final void drawRoundRect(Canvas r2, Paint r3) {
        Intrinsics.checkNotNullParameter(r2, "canvas");
        Intrinsics.checkNotNullParameter(r3, "paint");
        drawRoundRectInternal(r2, r3);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        OEALogger.INSTANCE.e(TAG, "drawRoundRectInternal failed", e);
    }

    private final void drawRoundRectInternal(Canvas r16, Paint r17) {
        float r9 = this.roundRadius;
        boolean r10 = this.roundTl;
        boolean r11 = this.roundTr;
        boolean r12 = this.roundBl;
        boolean r13 = this.roundBr;
        float r7 = this.rectWidth;
        float r8 = this.rectHeight;
        float r2 = r7 / 2.0f;
        float r1 = r8 / 2.0f;
        boolean r3 = false;
        float r4 = 0;
        if (r9 < r4) goto L5;
        boolean r5 = true;
    L6:
        if (r5 == false) goto L40;
        if (r7 < r4) goto L10;
        boolean r6 = true;
    L11:
        if (r6 == false) goto L38;
        if (r8 < r4) goto L15;
        boolean r14 = true;
    L16:
        if (r14 == false) goto L36;
        if (r2 < r4) goto L20;
        boolean r15 = true;
    L21:
        if (r15 == false) goto L34;
        if (r1 < r4) goto L25;
        r3 = true;
    L25:
        if (r3 == false) goto L32;
        float r18 = 2;
        float r19 = r2 - (r7 / r18);
        float r110 = r1 - (r8 / r18);
        if (r9 <= (Math.min(r7, r8) / r18)) goto L29;
        this.smoothCornerImpl.drawAndroidRoundRect(r16, r17, r19, r110, 0.0f, 0.0f, r7, r8, r9, r10, r11, r12, r13);
        return;
    L29:
        this.smoothCornerImpl.drawSmoothCornerRect(r16, r17, 0.0f, 0.0f, r7, r8, r9);
        return;
    L32:
        throw new IllegalArgumentException(("invalid _centerY: " + r1).toString());
    L34:
        throw new IllegalArgumentException(("invalid _centerX: " + r2).toString());
    L20:
        r15 = false;
        goto L21
    L36:
        throw new IllegalArgumentException(("invalid _height: " + r8).toString());
    L15:
        r14 = false;
        goto L16
    L38:
        throw new IllegalArgumentException(("invalid _width: " + r7).toString());
    L10:
        r6 = false;
        goto L11
    L40:
        throw new IllegalArgumentException(("invalid _radius: " + r9).toString());
    L5:
        r5 = false;
        goto L6
    }

    public final void drawRoundRect(Canvas r11, RectF r12, float r13, Paint r14) {
        Intrinsics.checkNotNullParameter(r11, "canvas");
        Intrinsics.checkNotNullParameter(r12, "rect");
        Intrinsics.checkNotNullParameter(r14, "paint");
        if (r12.isEmpty() == false) goto L6;
        OEALogger.e$default(OEALogger.INSTANCE, TAG, "empty rect: " + r12, null, 4, null);
        return;
    L6:
        drawRoundRect(r11, r14, r12.left, r12.top, r12.right, r12.bottom, r13);
    }

    public final void drawRoundRect(Canvas r19, Paint r20, float r21, float r22, float r23, float r24, float r25) {
        Intrinsics.checkNotNullParameter(r19, "canvas");
        Intrinsics.checkNotNullParameter(r20, "paint");
        if (r25 >= 0.0f) goto L5;
        OEALogger.e$default(OEALogger.INSTANCE, TAG, "invalid radius: " + r25, null, 4, null);
        float r9 = 0.0f;
    L6:
        Point r1 = getPosXY(r23, r21, r24, r22);
        float r10 = r1.component1();
        float r11 = r1.component2();
        if (r9 <= (Math.min(r23 - r21, r24 - r22) / 2)) goto L9;
        ISmoothCornerImpl.drawAndroidRoundRect$default(this.smoothCornerImpl, r19, r20, r10, r11, r21, r22, r23, r24, r9, false, false, false, false, 7680, null);
        return;
    L9:
        this.smoothCornerImpl.drawSmoothCornerRect(r19, r20, r21, r22, r23, r24, r9);
        return;
    L5:
        r9 = r25;
        goto L6
    }

    public final Path buildPath(Rect r8, float r9) {
        Intrinsics.checkNotNullParameter(r8, "rect");
        return buildPath(r8.left, r8.top, r8.right, r8.bottom, r9);
    }

    public final Path buildPath(RectF r8, float r9) {
        Intrinsics.checkNotNullParameter(r8, "rect");
        return buildPath(r8.left, r8.top, r8.right, r8.bottom, r9);
    }

    public final Path buildPath(float r7, float r8, float r9, float r10, float r11) {
        return this.smoothCornerImpl.buildPath(r7, r8, r9, r10, r11);
    }

    public final boolean canDraw(float r1, float r2) {
        return this.smoothCornerImpl.canDraw(r1, r2);
    }

    private final Point getPosXY(float r2, float r3, float r4, float r5) {
        float r1 = r2 - r3;
        float r0 = r4 - r5;
        return new Point(((r3 + r2) / 2.0f) - (r1 / 2.0f), ((r5 + r4) / 2.0f) - (r0 / 2.0f));
    }

    static {
        Companion = new Companion(null);
        validSmoothCornerRadius = CollectionsKt.toList(RangesKt.step(new IntRange(8, 48), 2));
    }
}
