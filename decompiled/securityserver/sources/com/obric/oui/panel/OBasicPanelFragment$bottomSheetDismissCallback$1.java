package com.obric.oui.panel;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class OBasicPanelFragment$bottomSheetDismissCallback$1 extends BottomSheetBehavior.BottomSheetCallback {
    @Override // com.obric.oui.panel.BottomSheetBehavior.BottomSheetCallback
    public final void a(View r1, float r2) {
    }

    @Override // com.obric.oui.panel.BottomSheetBehavior.BottomSheetCallback
    public final void b(View r1, int r2) {
        Intrinsics.f(r1, "bottomSheet");
        if (r2 == 5) goto L6;
        return;
    L6:
        throw null;
    }
}
