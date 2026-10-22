package com.obric.oui.swipeaction.util;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: RubberBandHelper.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/obric/oui/swipeaction/util/RubberBandHelper;", "", "()V", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RubberBandHelper {
    public static final Companion Companion = null;
    private static final float coeff = 0.0f;

    /* JADX INFO: compiled from: RubberBandHelper.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/oui/swipeaction/util/RubberBandHelper$Companion;", "", "()V", "coeff", "", "getRealValue", "start", "target", "cur", "new", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final float getRealValue(float r4, float r5, float r6, float r7) {
            boolean r0 = true;
            if (r6 != r7) goto L5;
            boolean r3 = true;
        L6:
            if (r3 == false) goto L8;
        L31:
            return r6;
        L8:
            if (r6 != r5) goto L10;
            boolean r8 = true;
        L11:
            if (r8 == true) goto L31;
            if (r4 >= r5) goto L19;
            if (r7 >= r4) goto L19;
            return r7;
        L19:
            if (r4 > r5) goto L21;
        L23:
            float r9 = r5 - r4;
            float r10 = ((RubberBandHelper.access$getCoeff$cp() * (r7 - r4)) / r9) + 1.0f;
            if (r10 == 0.0f) goto L27;
            r0 = false;
        L27:
            if (r0 == false) goto L30;
            return 0.0f;
        L30:
            return r4 + ((1.0f - (1.0f / r10)) * r9);
        L21:
            if (r7 <= r4) goto L23;
            return r7;
        L10:
            r8 = false;
            goto L11
        L5:
            r3 = false;
            goto L6
        }
    }

    public RubberBandHelper() {
    }

    public static final /* synthetic */ float access$getCoeff$cp() {
        return coeff;
    }

    static {
        Companion = new Companion(null);
        coeff = 1.0f;
    }
}
