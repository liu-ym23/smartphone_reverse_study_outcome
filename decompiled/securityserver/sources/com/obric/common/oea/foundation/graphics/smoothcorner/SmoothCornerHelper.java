package com.obric.common.oea.foundation.graphics.smoothcorner;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import com.obric.common.oea.foundation.graphics.smoothcorner.impl.BasicRoundCornerImpl;
import com.obric.common.oea.foundation.graphics.smoothcorner.impl.FigmaSmoothCornerImpl;
import com.obric.common.oea.foundation.graphics.smoothcorner.impl.ISmoothCornerImpl;
import com.obric.common.oea.foundation.graphics.smoothcorner.impl.QuadraticSmoothCornerExImpl;
import com.obric.common.oea.foundation.graphics.smoothcorner.impl.QuadraticSmoothCornerImpl;
import com.obric.common.oea.foundation.graphics.smoothcorner.impl.SketchSmoothCornerImpl;
import com.obric.common.oea.foundation.util.OEALogger;
import com.obric.common.oea.foundation.util.SdkInit;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class SmoothCornerHelper {
    public static final List b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ISmoothCornerImpl f142a;

    @Metadata
    public static final class Companion {

        @Metadata
        public static final enum CurveType extends Enum<CurveType> {
            public static final CurveType b = null;
            public static final CurveType c = null;
            public static final /* synthetic */ CurveType[] e = null;

            static {
                CurveType r0 = new CurveType("QUADRATIC", 0);
                CurveType r1 = new CurveType("SKETCH", 1);
                b = r1;
                CurveType r2 = new CurveType("FIGMA", 2);
                CurveType r3 = new CurveType("BASIC", 3);
                CurveType r4 = new CurveType("QUADRATIC_CAPSULE", 4);
                c = r4;
                e = new CurveType[]{r0, r1, r2, r3, r4};
            }

            public static CurveType valueOf(String r1) {
                return (CurveType) Enum.valueOf(CurveType.class, r1);
            }

            public static CurveType[] values() {
                return (CurveType[]) e.clone();
            }
        }
    }

    @Metadata
    public final /* synthetic */ class WhenMappings {
        static {
            int[] r0 = new int[Companion.CurveType.values().length];
            r0[3] = 1;
            r0[0] = 2;
            r0[1] = 3;
            r0[2] = 4;
            r0[4] = 5;
        }
    }

    static {
        b = CollectionsKt.q(RangesKt.d(new IntRange(8, 48, 1), 2));
    }

    public SmoothCornerHelper() {
        new SdkInit();
        this.f142a = new QuadraticSmoothCornerImpl();
    }

    public final void a(Canvas r8, Paint r9, float r10, float r11, float r12, float r13, float r14) {
        Intrinsics.f(r8, "canvas");
        Intrinsics.f(r9, "paint");
        if (r14 >= 0.0f) goto L5;
        OEALogger.b("invalid radius: " + r14);
        float r6 = 0.0f;
    L7:
        if (r6 <= (Math.min(r12 - r10, r13 - r11) / 2)) goto L9;
        ISmoothCornerImpl r7 = this.f142a;
        r7.getClass();
        RectF r15 = r7.f145a;
        r15.set(r10, r11, r12, r13);
        r8.drawRoundRect(r15, r6, r6, r9);
        return;
    L9:
        ISmoothCornerImpl r1 = this.f142a;
        r1.getClass();
        r8.drawPath(r1.a(r10, r11, r12, r13, r6), r9);
        return;
    L5:
        r6 = r14;
        goto L7
    }

    public final void b(Companion.CurveType r3) {
        OEALogger.a("SmoothCornerHelper", "setCurveType: " + r3);
        int r4 = r3.ordinal();
        if (r4 == 0) goto L19;
        if (r4 != 1) goto L7;
        ISmoothCornerImpl r5 = new SketchSmoothCornerImpl();
    L22:
        this.f142a = r5;
        return;
    L7:
        if (r4 != 2) goto L9;
        r5 = new FigmaSmoothCornerImpl();
        goto L22
    L9:
        if (r4 != 3) goto L11;
        r5 = new BasicRoundCornerImpl();
        goto L22
    L11:
        if (r4 != 4) goto L14;
        r5 = new QuadraticSmoothCornerExImpl();
        goto L22
    L14:
        throw new NoWhenBranchMatchedException();
    L19:
        if ((-1.0f) <= 0) goto L21;
        r5 = new QuadraticSmoothCornerImpl(-1.0f);
        goto L22
    L21:
        r5 = new QuadraticSmoothCornerImpl();
        goto L22
    }
}
