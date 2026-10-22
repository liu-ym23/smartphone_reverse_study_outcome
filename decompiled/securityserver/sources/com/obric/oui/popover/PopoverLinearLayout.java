package com.obric.oui.popover;

import android.widget.LinearLayout;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public class PopoverLinearLayout extends LinearLayout {
    @Override // android.view.View
    public void setPressed(boolean r1) {
        super.setPressed(r1);
        if (r1 == false) goto L5;
        setAlpha(0.66f);
        return;
    L5:
        setAlpha(1.0f);
    }
}
