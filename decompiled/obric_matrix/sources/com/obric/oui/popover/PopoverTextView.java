package com.obric.oui.popover;

import androidx.appcompat.widget.AppCompatTextView;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/popover/PopoverTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "", "pressed", "Lkotlin/f0;", "setPressed", "(Z)V", "OUI_standardRelease"}, k = 1, mv = {1, 1, 15})
public final class PopoverTextView extends AppCompatTextView {
    @Override // android.view.View
    public void setPressed(boolean r1) {
        super.setPressed(r1);
        if (r1 == false) goto L5;
        float r2 = 0.66f;
    L6:
        setAlpha(r2);
        return;
    L5:
        r2 = 1.0f;
        goto L6
    }
}
