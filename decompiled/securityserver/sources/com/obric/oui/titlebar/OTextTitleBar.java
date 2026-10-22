package com.obric.oui.titlebar;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.StringRes;
import com.bytedance.securityserver.R;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.titlebar.listener.OnTitleBarClickListener;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class OTextTitleBar extends OTitleBar implements View.OnClickListener {
    public OnTitleBarClickListener c;
    public boolean e;
    public boolean f;

    public ImageView getBackBtn() {
        return null;
    }

    public int getEndButtonType() {
        return 0;
    }

    public TextView getEndText() {
        return null;
    }

    public TextView getStartText() {
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        if (this.c != null) goto L5;
        return;
    L5:
        if (r3.getId() != R.id.back_btn) goto L7;
    L12:
        this.c.b();
        return;
    L7:
        if (r3.getId() == R.id.text_left) goto L12;
        if (r3.getId() != R.id.text_right) goto L15;
        this.c.a();
        return;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        OUnitExtensionKt.c(getContext());
        throw null;
    }

    @Override // com.obric.oui.titlebar.OTitleBar
    public void setDividerLineBackground(@ColorInt int r1) {
        throw null;
    }

    public void setEndText(CharSequence r1) {
        throw null;
    }

    public void setEndTextColor(@ColorInt int r1) {
        throw null;
    }

    public void setEndTextSize(float r1) {
        throw null;
    }

    public void setLineBackground(@ColorInt int r1) {
        throw null;
    }

    public void setOnTitleBarClickListener(OnTitleBarClickListener r1) {
        this.c = r1;
    }

    public void setStartText(CharSequence r1) {
        throw null;
    }

    public void setStartTextColor(@ColorInt int r1) {
        throw null;
    }

    public void setStartTextSize(float r1) {
        throw null;
    }

    public void setUseBackIcon(boolean r2) {
        if (this.e != r2) goto L5;
        return;
    L5:
        this.e = r2;
        throw null;
    }

    public void setUseCloseIcon(boolean r2) {
        if (this.f != r2) goto L5;
        return;
    L5:
        this.f = r2;
        throw null;
    }

    public void setEndText(@StringRes int r1) {
        throw null;
    }

    public void setStartText(@StringRes int r1) {
        throw null;
    }
}
