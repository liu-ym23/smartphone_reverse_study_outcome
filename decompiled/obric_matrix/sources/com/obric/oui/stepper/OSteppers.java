package com.obric.oui.stepper;

import android.widget.EditText;
import android.widget.TextView;
import com.obric.oui.button.OButton;
import com.obric.oui.layout.OUIConstraintLayout;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001>J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\r\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\tJ\u0015\u0010\u000e\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000e\u0010\fJ\r\u0010\u000f\u001a\u00020\u0007¢\u0006\u0004\b\u000f\u0010\tJ\u0015\u0010\u0010\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u0010\u0010\fJ\u0015\u0010\u0011\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u0011\u0010\fJ\u000f\u0010\u0012\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0004J\u001f\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\u0015\u0010\u0016J7\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\u001d\u0010\u001eR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R$\u0010&\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00078\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b#\u0010$\"\u0004\b%\u0010\fR$\u0010)\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00078\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b'\u0010$\"\u0004\b(\u0010\fR$\u0010,\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00078\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b*\u0010$\"\u0004\b+\u0010\fR$\u00104\u001a\u0004\u0018\u00010-8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0016\u00106\u001a\u00020\u001f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u0010!R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00109R$\u0010=\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00078\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b;\u0010$\"\u0004\b<\u0010\f¨\u0006?"}, d2 = {"Lcom/obric/oui/stepper/OSteppers;", "Lcom/obric/oui/layout/OUIConstraintLayout;", "Lkotlin/f0;", "i", "()V", "g", "h", "", "getValue", "()I", "value", "setValue", "(I)V", "getMinValue", "setMinValue", "getMaxValue", "setMaxValue", "setStepValue", "clearFocus", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "", "changed", "left", "top", "right", "bottom", "onLayout", "(ZIIII)V", "Lcom/obric/oui/button/OButton;", "m", "Lcom/obric/oui/button/OButton;", "tvAdd", "q", "I", "setMMinValue", "mMinValue", "r", "setMMaxValue", "mMaxValue", "s", "setMStepValue", "mStepValue", "Lcom/obric/oui/stepper/OSteppers$a;", "l", "Lcom/obric/oui/stepper/OSteppers$a;", "getOnValueChangeListener", "()Lcom/obric/oui/stepper/OSteppers$a;", "setOnValueChangeListener", "(Lcom/obric/oui/stepper/OSteppers$a;)V", "onValueChangeListener", "n", "tvDec", "Landroid/widget/EditText;", "o", "Landroid/widget/EditText;", "etCounter", "p", "setMValue", "mValue", "a", "OUI_standardRelease"}, k = 1, mv = {1, 1, 15})
public final class OSteppers extends OUIConstraintLayout {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private a f11432l;
    private final OButton m;
    private final OButton n;
    private final EditText o;
    private int p;
    private int q;
    private int r;
    private int s;

    public interface a {
        void a(int r1);

        void b(int r1, int r2);
    }

    static final class b implements com.obric.oui.stepper.a.InterfaceC0299a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OSteppers f11433a;

        b(OSteppers r1) {
            this.f11433a = r1;
        }

        @Override // com.obric.oui.stepper.a.InterfaceC0299a
        public final void a(int r1) {
            a r0 = this.f11433a.getOnValueChangeListener();
            if (r0 == null) goto L6;
            r0.a(r1);
            return;
        }
    }

    static {
    }

    private final void g() {
        OButton r0 = this.m;
        boolean r3 = true;
        if (getValue() >= this.r) goto L5;
        boolean r1 = true;
    L6:
        r0.setEnabled(r1);
        OButton r2 = this.m;
        if (getValue() >= this.r) goto L9;
        boolean r4 = true;
    L10:
        r2.setClickable(r4);
        OButton r5 = this.n;
        if (getValue() <= this.q) goto L13;
        boolean r6 = true;
    L14:
        r5.setEnabled(r6);
        OButton r7 = this.n;
        if (getValue() > this.q) goto L18;
        r3 = false;
    L18:
        r7.setClickable(r3);
        return;
    L13:
        r6 = false;
        goto L14
    L9:
        r4 = false;
        goto L10
    L5:
        r1 = false;
        goto L6
    }

    private final void h() {
        this.o.setText(String.valueOf(this.p), TextView.BufferType.EDITABLE);
        g();
    }

    private final void i() {
        this.o.setFilters(new com.obric.oui.stepper.a[]{new com.obric.oui.stepper.a(this.q, this.r, new b(this))});
    }

    private final void setMMaxValue(int r1) {
        this.r = r1;
        i();
        h();
    }

    private final void setMMinValue(int r1) {
        this.q = r1;
        i();
        h();
    }

    private final void setMStepValue(int r1) {
        this.s = r1;
        h();
    }

    private final void setMValue(int r2) {
        if (this.p != r2) goto L5;
        return;
    L5:
        this.p = r2;
        a r0 = this.f11432l;
        if (r0 == null) goto L8;
        r0.b(r2, r2);
    L8:
        h();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void clearFocus() {
        super.clearFocus();
        this.o.clearFocus();
    }

    public final int getMaxValue() {
        return this.r;
    }

    public final int getMinValue() {
        return this.q;
    }

    public final a getOnValueChangeListener() {
        return this.f11432l;
    }

    public final int getValue() {
        return this.p;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }

    @Override // com.obric.oui.layout.OUIConstraintLayout, androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    protected void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
    }

    public final void setMaxValue(int r2) {
        setMMaxValue(r2);
        setMValue(Math.min(r2, this.p));
    }

    public final void setMinValue(int r2) {
        setMMinValue(r2);
        setMValue(Math.max(r2, this.p));
    }

    public final void setOnValueChangeListener(a r1) {
        this.f11432l = r1;
    }

    public final void setStepValue(int r2) {
        if (this.s <= 0) goto L7;
        setMStepValue(r2);
        return;
    L7:
        throw new IllegalArgumentException("step value should be a positive integer");
    }

    public final void setValue(int r3) {
        if (r3 < this.q) goto L9;
        if (r3 > this.r) goto L9;
        setMValue(r3);
        return;
    L9:
        throw new IllegalArgumentException(r3 + " is not in [" + this.q + ", " + this.r + "].");
    }
}
