package com.obric.oui.sheet.v2;

import android.view.View;
import android.widget.LinearLayout;
import com.obric.oui.button.OButton;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class OSheetFooterBtnContainer extends LinearLayout {
    public OButton b;
    public OButton c;
    public View e;

    @Nullable
    public final OButton getBtnNegative() {
        return this.b;
    }

    @Nullable
    public final OButton getBtnPositive() {
        return this.c;
    }

    @Nullable
    public final View getHorizontal_space() {
        return this.e;
    }

    public final void setBtnNegative(@Nullable OButton r1) {
        this.b = r1;
    }

    public final void setBtnPositive(@Nullable OButton r1) {
        this.c = r1;
    }

    public final void setHorizontal_space(@Nullable View r1) {
        this.e = r1;
    }
}
