package com.obric.oui.selection;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import com.bytedance.securityserver.R;
import com.obric.oui.checkbox.OCheckBox;
import com.obric.oui.common.util.ViewExtensionsKt;
import com.obric.oui.layout.OUIConstraintLayout;
import com.obric.oui.radio.ORadio;
import com.obric.oui.text.OTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class OSelectionPanelItemView extends OUIConstraintLayout {
    public final ImageView k;
    public final OTextView l;
    public final ORadio m;
    public final OCheckBox n;
    public final View o;
    public boolean p;
    public boolean q;
    public boolean r;

    public OSelectionPanelItemView(Context r4) {
        super(r4, null, 0);
        this.q = false;
        this.r = false;
        this.p = true;
        View.inflate(r4, R.layout.o_view_selection_item, this);
        setMinHeight((int) getResources().getDimension(R.dimen.oui_h_l2));
        View r5 = findViewById(R.id.iv_icon);
        Intrinsics.e(r5, "findViewById(R.id.iv_icon)");
        this.k = (ImageView) r5;
        View r6 = findViewById(R.id.tv_text);
        Intrinsics.e(r6, "findViewById(R.id.tv_text)");
        this.l = (OTextView) r6;
        View r7 = findViewById(R.id.radio);
        Intrinsics.e(r7, "findViewById(R.id.radio)");
        this.m = (ORadio) r7;
        View r8 = findViewById(R.id.checkbox);
        Intrinsics.e(r8, "findViewById(R.id.checkbox)");
        OCheckBox r9 = (OCheckBox) r8;
        this.n = r9;
        View r0 = findViewById(R.id.divider);
        Intrinsics.e(r0, "findViewById(R.id.divider)");
        this.o = r0;
        r9.setClickable(false);
        setRadius((int) getResources().getDimension(R.dimen.oui_r_l3_rect));
        setSelectMode(this.q);
        setDividerMode(this.r);
        setPadding(getResources().getDimensionPixelSize(R.dimen.oui_p_list_item_2), getPaddingTop(), getResources().getDimensionPixelSize(R.dimen.oui_p_list_item_2), getPaddingBottom());
        ViewCompat.setAccessibilityDelegate(this, new OSelectionPanelItemView$addAccessibilityCompat$1(this));
    }

    private final void setDividerMode(boolean r1) {
        View r0 = this.o;
        if (r1 == false) goto L5;
        ViewExtensionsKt.e(r0);
        return;
    L5:
        ViewExtensionsKt.d(r0);
    }

    public final boolean g() {
        if (this.q == false) goto L6;
        return this.n.isChecked();
    L6:
        return this.m.isChecked();
    }

    @NotNull
    public final OCheckBox getCheckBox() {
        return this.n;
    }

    @NotNull
    public final ImageView getIconView() {
        return this.k;
    }

    @NotNull
    public final ORadio getRadioView() {
        return this.m;
    }

    public final boolean getShowDivider() {
        return this.r;
    }

    @NotNull
    public final OTextView getTextView() {
        return this.l;
    }

    public final void setItemSelected(boolean r3) {
        boolean r0 = this.q;
        ORadio r1 = this.m;
        if (r0 == false) goto L5;
        this.n.setChecked(r3);
    L7:
        if (this.p == true) goto L10;
        Intrinsics.f(r1, "$this$makeInvisible");
        r1.setVisibility(4);
        return;
    L10:
        return;
    L5:
        r1.setChecked(r3);
        goto L7
    }

    public final void setMultiSelect(boolean r1) {
        this.q = r1;
    }

    public final void setSelectMode(boolean r3) {
        this.q = r3;
        ORadio r0 = this.m;
        OCheckBox r1 = this.n;
        if (r3 == false) goto L5;
        ViewExtensionsKt.e(r1);
        ViewExtensionsKt.d(r0);
    L6:
        setItemSelected(g());
        return;
    L5:
        ViewExtensionsKt.d(r1);
        ViewExtensionsKt.e(r0);
        goto L6
    }

    public final void setShowDivider(boolean r1) {
        this.r = r1;
    }
}
