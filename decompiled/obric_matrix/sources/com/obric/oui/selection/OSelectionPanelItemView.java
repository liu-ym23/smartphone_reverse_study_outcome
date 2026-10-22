package com.obric.oui.selection;

import android.view.View;
import android.widget.ImageView;
import com.obric.oui.checkbox.OCheckBox;
import com.obric.oui.common.util.j;
import com.obric.oui.layout.OUIConstraintLayout;
import com.obric.oui.radio.ORadio;
import com.obric.oui.text.OTextView;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\u0006J\r\u0010\n\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\r\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R$\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u00028F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u0006R\u0016\u0010\"\u001a\u00020\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010%\u001a\u00020\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010(\u001a\u00020\u00128\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010\u0019\u001a\u0004\b*\u0010\u001d\"\u0004\b+\u0010\u0006R\"\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010\u0019\u001a\u0004\b-\u0010\u001d\"\u0004\b.\u0010\u0006R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101¨\u00063"}, d2 = {"Lcom/obric/oui/selection/OSelectionPanelItemView;", "Lcom/obric/oui/layout/OUIConstraintLayout;", "", "showDivider", "Lkotlin/f0;", "setDividerMode", "(Z)V", "isMultiSelect", "setSelectMode", "Landroid/widget/ImageView;", "getIconView", "()Landroid/widget/ImageView;", "Lcom/obric/oui/text/OTextView;", "getTextView", "()Lcom/obric/oui/text/OTextView;", "Lcom/obric/oui/radio/ORadio;", "getRadioView", "()Lcom/obric/oui/radio/ORadio;", "Lcom/obric/oui/checkbox/OCheckBox;", "getCheckBox", "()Lcom/obric/oui/checkbox/OCheckBox;", "n", "Lcom/obric/oui/radio/ORadio;", "radio", "q", "Z", "showSelectLabel", "value", "g", "()Z", "setItemSelected", "isItemSelected", "l", "Landroid/widget/ImageView;", "ivIcon", "m", "Lcom/obric/oui/text/OTextView;", "tvText", "o", "Lcom/obric/oui/checkbox/OCheckBox;", "checkbox", "s", "getShowDivider", "setShowDivider", "r", "h", "setMultiSelect", "Landroid/view/View;", "p", "Landroid/view/View;", "divider", "OUI_standardRelease"}, k = 1, mv = {1, 1, 15})
public final class OSelectionPanelItemView extends OUIConstraintLayout {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final ImageView f11369l;
    private final OTextView m;
    private final ORadio n;
    private final OCheckBox o;
    private final View p;
    private boolean q;
    private boolean r;
    private boolean s;

    private final void setDividerMode(boolean r1) {
        View r0 = this.p;
        if (r1 == false) goto L5;
        j.g(r0);
        return;
    L5:
        j.e(r0);
    }

    public final boolean g() {
        if (this.r == false) goto L6;
        return this.o.isChecked();
    L6:
        return this.n.isChecked();
    }

    public final OCheckBox getCheckBox() {
        return this.o;
    }

    public final ImageView getIconView() {
        return this.f11369l;
    }

    public final ORadio getRadioView() {
        return this.n;
    }

    public final boolean getShowDivider() {
        return this.s;
    }

    public final OTextView getTextView() {
        return this.m;
    }

    public final boolean h() {
        return this.r;
    }

    public final void setItemSelected(boolean r2) {
        if (this.r == false) goto L5;
        this.o.setChecked(r2);
    L7:
        if (this.q == true) goto L10;
        j.f(this.n);
        return;
    L10:
        return;
    L5:
        this.n.setChecked(r2);
        goto L7
    }

    public final void setMultiSelect(boolean r1) {
        this.r = r1;
    }

    public final void setSelectMode(boolean r1) {
        this.r = r1;
        if (r1 == false) goto L5;
        j.g(this.o);
        j.e(this.n);
    L6:
        setItemSelected(g());
        return;
    L5:
        j.e(this.o);
        j.g(this.n);
        goto L6
    }

    public final void setShowDivider(boolean r1) {
        this.s = r1;
    }
}
