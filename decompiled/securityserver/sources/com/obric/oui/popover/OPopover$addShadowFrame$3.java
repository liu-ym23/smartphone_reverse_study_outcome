package com.obric.oui.popover;

import android.view.MotionEvent;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class OPopover$addShadowFrame$3 implements View.OnTouchListener {
    public final /* synthetic */ OPopover b;

    public OPopover$addShadowFrame$3(OPopover r1) {
        this.b = r1;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r1, MotionEvent r2) {
        Intrinsics.e(r2, "event");
        if (r2.getAction() == 0) goto L5;
        return false;
    L5:
        this.b.getClass();
        Intrinsics.m("mOBubbleLayout");
        throw null;
    }
}
