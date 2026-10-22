package com.obric.oui.popover;

import androidx.appcompat.widget.AppCompatTextView;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class PopoverTextView extends AppCompatTextView {
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
