package com.obric.oui.panel.header;

import android.view.View;
import com.obric.oui.panel.BottomSheetBehavior;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class ExpandableDefaultHeaderCallback extends BottomSheetBehavior.BottomSheetCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f256a;

    @Override // com.obric.oui.panel.BottomSheetBehavior.BottomSheetCallback
    public final void a(View r2, float r3) {
        if (this.f256a >= 0) goto L7;
        this.f256a = r3;
        return;
    L7:
        throw null;
    }

    @Override // com.obric.oui.panel.BottomSheetBehavior.BottomSheetCallback
    public final void b(View r1, int r2) {
        Intrinsics.f(r1, "bottomSheet");
    }
}
