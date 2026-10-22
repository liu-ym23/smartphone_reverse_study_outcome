package com.obric.common.oea.style.scene.drag;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: RubberBandHelper.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/obric/common/oea/style/scene/drag/RubberBandHelper;", "", "()V", "Companion", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class RubberBandHelper {
    public static final Companion Companion = null;
    private static final float coeff = 0.0f;

    /* JADX INFO: compiled from: RubberBandHelper.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/common/oea/style/scene/drag/RubberBandHelper$Companion;", "", "()V", "coeff", "", "getRealValue", "start", "target", "cur", "new", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final float getRealValue(float r2, float r3, float r4, float r5) {
            if (r4 != r5) goto L5;
        L22:
            return r4;
        L5:
            if (r4 == r3) goto L22;
            if (r2 >= r3) goto L13;
            if (r5 >= r2) goto L13;
            return r5;
        L13:
            if (r2 > r3) goto L15;
        L17:
            float r6 = r3 - r2;
            float r1 = RubberBandHelper.access$getCoeff$cp();
            float r7 = ((r1 * (r5 - r2)) / r6) + 1.0f;
            if (r7 != 0.0f) goto L21;
            return 0.0f;
        L21:
            return r2 + ((1.0f - (1.0f / r7)) * r6);
        L15:
            if (r5 <= r2) goto L17;
            return r5;
        }
    }

    public RubberBandHelper() {
    }

    public static final /* synthetic */ float access$getCoeff$cp() {
        return coeff;
    }

    static {
        Companion = new Companion(null);
        coeff = 0.55f;
    }
}
