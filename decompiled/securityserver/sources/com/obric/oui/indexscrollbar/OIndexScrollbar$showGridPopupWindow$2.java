package com.obric.oui.indexscrollbar;

import android.os.Handler;
import android.os.Looper;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class OIndexScrollbar$showGridPopupWindow$2 implements SurnameGridView.OnPressChangeListener {
    @Override // com.obric.oui.indexscrollbar.SurnameGridView.OnPressChangeListener
    public final void a(int r4) {
        if (r4 != (-1)) goto L7;
        new Handler(Looper.getMainLooper()).postDelayed(new OIndexScrollbar$showGridPopupWindow$2$onTouched$1(this), 100);
        return;
    L7:
        throw null;
    }
}
