package com.obric.oui.popover.v2;

import android.view.MotionEvent;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class OPopover$addShadowFrame$3 implements View.OnTouchListener {
    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r1, MotionEvent r2) {
        Intrinsics.e(r2, "event");
        if (r2.getAction() == 0) goto L6;
        return false;
    L6:
        int r0 = OPopover.f268a;
        throw null;
    }
}
