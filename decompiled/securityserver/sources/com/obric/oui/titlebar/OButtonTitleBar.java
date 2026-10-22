package com.obric.oui.titlebar;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import com.bytedance.securityserver.R;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.common.util.ViewExtensionsKt;
import com.obric.oui.titlebar.listener.OnTitleBarClickListener;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class OButtonTitleBar extends OTitleBar implements View.OnClickListener {
    public OnTitleBarClickListener c;

    public TextView getEndBtn() {
        return null;
    }

    public int getEndButtonType() {
        return 0;
    }

    public ImageView getStartBtn() {
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getStartBtn() == null) goto L6;
        ViewExtensionsKt.b(getStartBtn(), OUnitExtensionKt.a(44), OUnitExtensionKt.a(44), false);
    L6:
        if (getEndBtn() == null) goto L9;
        ViewExtensionsKt.b(getEndBtn(), OUnitExtensionKt.a(44), OUnitExtensionKt.a(44), false);
        return;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        if (this.c != null) goto L5;
        return;
    L5:
        if (r3.getId() != R.id.back_btn) goto L8;
        this.c.b();
        return;
    L8:
        if (r3.getId() != R.id.right_btn) goto L13;
        this.c.a();
        return;
    }

    @Override // com.obric.oui.titlebar.OTitleBar
    public void setDividerLineBackground(@ColorInt int r1) {
        throw null;
    }

    public void setOnTitleBarClickListener(OnTitleBarClickListener r1) {
        this.c = r1;
    }
}
