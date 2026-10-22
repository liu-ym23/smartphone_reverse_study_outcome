package com.obric.common.oea.foundation.graphics.smoothcorner;

import kotlin.Metadata;

/* JADX INFO: compiled from: SmoothCornerAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u0014\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002¨\u0006\u0003"}, d2 = {"isAllSameValue", "", "", "foundation_standardRelease"}, k = 2, mv = {1, 4, 3})
public final class SmoothCornerAdapterKt {
    public static final /* synthetic */ boolean access$isAllSameValue(float[] r0) {
        return isAllSameValue(r0);
    }

    private static final boolean isAllSameValue(float[] r6) {
        if (r6.length != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return true;
    L8:
        float r1 = r6[0];
        int r3 = r6.length;
        int r4 = 0;
    L9:
        if (r4 >= r3) goto L22;
        float r5 = r6[r4];
        r4 = r4 + 1;
        if (r5 == r1) goto L13;
        boolean r7 = true;
    L14:
        if (r7 == false) goto L9;
        return false;
    L13:
        r7 = false;
        goto L14
    L22:
        return true;
    L5:
        r0 = false;
        goto L6
    }
}
