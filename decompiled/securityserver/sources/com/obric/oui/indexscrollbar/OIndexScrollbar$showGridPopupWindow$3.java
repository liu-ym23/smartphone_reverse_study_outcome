package com.obric.oui.indexscrollbar;

import android.view.View;
import android.widget.AdapterView;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class OIndexScrollbar$showGridPopupWindow$3 implements AdapterView.OnItemClickListener {
    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView r1, View r2, int r3, long r4) {
        Object r0 = r1.getItemAtPosition(r3);
        if (r0 == null) goto L7;
        String r5 = (String) r0;
        throw null;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }
}
