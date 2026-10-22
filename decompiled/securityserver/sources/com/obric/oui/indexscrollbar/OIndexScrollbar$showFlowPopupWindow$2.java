package com.obric.oui.indexscrollbar;

import android.view.View;
import android.widget.TextView;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class OIndexScrollbar$showFlowPopupWindow$2 implements View.OnClickListener {
    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        if (r1 == null) goto L6;
        ((TextView) r1).getText().toString();
        throw null;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    }
}
