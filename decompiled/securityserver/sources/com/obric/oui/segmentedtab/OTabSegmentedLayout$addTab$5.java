package com.obric.oui.segmentedtab;

import android.view.MotionEvent;
import android.view.View;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class OTabSegmentedLayout$addTab$5 implements View.OnTouchListener {
    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r1, MotionEvent r2) {
        Intrinsics.e(r2, "event");
        int r0 = r2.getAction();
        if (r0 != 0) goto L5;
        Intrinsics.e(r1, BaseSwitches.V);
        Object r3 = r1.getTag();
        if (r3 == null) goto L14;
        Integer r4 = (Integer) r3;
        throw null;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L5:
        if (r0 != 1) goto L7;
        throw null;
    L7:
        if (r0 == 3) goto L17;
        return false;
    L17:
        throw null;
    }
}
