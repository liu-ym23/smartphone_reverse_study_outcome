package com.obric.oui.indexscrollbar;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class OIndexPopupWindowLayout extends LinearLayout {
    public PopupWindow b;
    public TextView c;
    public ImageView e;

    public final void a() {
        PopupWindow r0 = this.b;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isShowing() != true) goto L11;
        PopupWindow r2 = this.b;
        if (r2 == null) goto L12;
        r2.dismiss();
        return;
    L12:
        return;
    }

    @Nullable
    public final PopupWindow getPopupWindow() {
        return this.b;
    }

    public final void setPopupWindow(@Nullable PopupWindow r1) {
        this.b = r1;
    }
}
