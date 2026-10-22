package com.obric.oui.searchbar;

import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.obric.oui.button.OButton;
import com.obric.oui.common.util.j;
import com.obric.oui.forms.OInputView;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0007¢\u0006\u0004\b\u000e\u0010\nJ\u0015\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u001a\u0010\u0019J\u001f\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001bH\u0014¢\u0006\u0004\b\u001e\u0010\u001fJ7\u0010%\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020\u001bH\u0014¢\u0006\u0004\b%\u0010&R\u0019\u0010,\u001a\u00020'8\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00102\u001a\u00020-8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u0010/R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105¨\u00067"}, d2 = {"Lcom/obric/oui/searchbar/OSearchBar;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "enabled", "Lkotlin/f0;", "setEnabled", "(Z)V", "", "text", "setText", "(Ljava/lang/String;)V", "getText", "()Ljava/lang/String;", "searchActionText", "setSearchActionText", "Landroid/view/View$OnClickListener;", "click", "setSearchAction", "(Landroid/view/View$OnClickListener;)V", "Landroid/view/View$OnFocusChangeListener;", "onFocusChangeListener", "setOnInputFocusChange", "(Landroid/view/View$OnFocusChangeListener;)V", "Landroid/view/View;", "getPrefixView", "()Landroid/view/View;", "getPostfixView", "", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "changed", "left", "top", "right", "bottom", "onLayout", "(ZIIII)V", "Lcom/obric/oui/forms/OInputView;", "f", "Lcom/obric/oui/forms/OInputView;", "getInputView", "()Lcom/obric/oui/forms/OInputView;", "inputView", "Landroid/widget/FrameLayout;", "h", "Landroid/widget/FrameLayout;", "rightContainer", "g", "leftContainer", "Lcom/obric/oui/button/OButton;", "i", "Lcom/obric/oui/button/OButton;", "searchAction", "OUI_standardRelease"}, k = 1, mv = {1, 1, 15})
public class OSearchBar extends ConstraintLayout {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final OInputView f11344f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final FrameLayout f11345g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private FrameLayout f11346h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final OButton f11347i;

    static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ OSearchBar f11348f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ View.OnClickListener f11349g;

        a(OSearchBar r1, View.OnClickListener r2) {
            this.f11348f = r1;
            this.f11349g = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            d.g.d.d.a.b(this.f11348f.getContext(), 1);
            this.f11349g.onClick(r3);
        }
    }

    public final OInputView getInputView() {
        return this.f11344f;
    }

    public final View getPostfixView() {
        FrameLayout r2 = this.f11346h;
        if (r2 != null) goto L5;
        return null;
    L5:
        if (r2.getChildCount() > 0) goto L7;
        return null;
    L7:
        return r2.getChildAt(0);
    }

    public final View getPrefixView() {
        if (this.f11345g.getChildCount() > 0) goto L7;
        return null;
    L7:
        return this.f11345g.getChildAt(0);
    }

    public final String getText() {
        String r0 = this.f11344f.getText();
        if (r0 != null) goto L7;
        return "";
    L7:
        return r0;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    protected void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
    }

    @Override // android.view.View
    public void setEnabled(boolean r2) {
        this.f11344f.setEnabled(r2);
        super.setEnabled(r2);
    }

    public final void setOnInputFocusChange(View.OnFocusChangeListener r2) {
        o.f(r2, "onFocusChangeListener");
        this.f11344f.setOnFocusChangeListener(r2);
    }

    public final void setSearchAction(View.OnClickListener r3) {
        o.f(r3, "click");
        this.f11347i.setOnClickListener(new a(this, r3));
    }

    public final void setSearchActionText(String r2) {
        o.f(r2, "searchActionText");
        if (r2.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        j.e(this.f11347i);
        return;
    L8:
        this.f11347i.setText(r2);
        j.g(this.f11347i);
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void setText(String r2) {
        o.f(r2, "text");
        this.f11344f.setText(r2);
    }
}
