package com.obric.oui.forms;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.obric.oui.common.util.j;
import com.obric.oui.divider.ODivider;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0019\u0018\u00002\u00020\u0001:\u0006\u008d\u0001\u008e\u0001\u008f\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\u00042\b\b\u0002\u0010\u0016\u001a\u00020\u0002¢\u0006\u0004\b\u0017\u0010\u0006J\u0015\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010!\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b!\u0010\"J\u0015\u0010%\u001a\u00020\u00042\u0006\u0010$\u001a\u00020#¢\u0006\u0004\b%\u0010&J\u0017\u0010)\u001a\u00020\u00042\b\u0010(\u001a\u0004\u0018\u00010'¢\u0006\u0004\b)\u0010*R\"\u00102\u001a\u00020+8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u0019\u00108\u001a\u0002038\u0006@\u0006¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u0019\u0010>\u001a\u0002098\u0006@\u0006¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\u0019\u0010D\u001a\u00020?8\u0006@\u0006¢\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010CR\u0016\u0010G\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u0019\u0010J\u001a\u0002098\u0006@\u0006¢\u0006\f\n\u0004\bH\u0010;\u001a\u0004\bI\u0010=R\u0019\u0010P\u001a\u00020K8\u0006@\u0006¢\u0006\f\n\u0004\bL\u0010M\u001a\u0004\bN\u0010OR\u0019\u0010V\u001a\u00020Q8\u0006@\u0006¢\u0006\f\n\u0004\bR\u0010S\u001a\u0004\bT\u0010UR\u0019\u0010Y\u001a\u0002098\u0006@\u0006¢\u0006\f\n\u0004\bW\u0010;\u001a\u0004\bX\u0010=R\u0019\u0010\\\u001a\u0002098\u0006@\u0006¢\u0006\f\n\u0004\bZ\u0010;\u001a\u0004\b[\u0010=R\u0018\u0010_\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b]\u0010^R$\u0010g\u001a\u0004\u0018\u00010`8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\ba\u0010b\u001a\u0004\bc\u0010d\"\u0004\be\u0010fR\u0019\u0010m\u001a\u00020h8\u0006@\u0006¢\u0006\f\n\u0004\bi\u0010j\u001a\u0004\bk\u0010lR\u0019\u0010p\u001a\u00020h8\u0006@\u0006¢\u0006\f\n\u0004\bn\u0010j\u001a\u0004\bo\u0010lR\u0019\u0010s\u001a\u0002098\u0006@\u0006¢\u0006\f\n\u0004\bq\u0010;\u001a\u0004\br\u0010=R\u0019\u0010v\u001a\u00020Q8\u0006@\u0006¢\u0006\f\n\u0004\bt\u0010S\u001a\u0004\bu\u0010UR\u0019\u0010|\u001a\u00020w8\u0006@\u0006¢\u0006\f\n\u0004\bx\u0010y\u001a\u0004\bz\u0010{R\u0019\u0010\u007f\u001a\u00020?8\u0006@\u0006¢\u0006\f\n\u0004\b}\u0010A\u001a\u0004\b~\u0010CR(\u0010\u0083\u0001\u001a\u0004\u0018\u00010`8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0080\u0001\u0010b\u001a\u0005\b\u0081\u0001\u0010d\"\u0005\b\u0082\u0001\u0010fR\u001c\u0010\u0086\u0001\u001a\u0002038\u0006@\u0006¢\u0006\u000e\n\u0005\b\u0084\u0001\u00105\u001a\u0005\b\u0085\u0001\u00107R\u001c\u0010\u0089\u0001\u001a\u00020Q8\u0006@\u0006¢\u0006\u000e\n\u0005\b\u0087\u0001\u0010S\u001a\u0005\b\u0088\u0001\u0010UR\u001c\u0010\u008c\u0001\u001a\u00020?8\u0006@\u0006¢\u0006\u000e\n\u0005\b\u008a\u0001\u0010A\u001a\u0005\b\u008b\u0001\u0010C¨\u0006\u0090\u0001"}, d2 = {"Lcom/obric/oui/forms/OLineInputView;", "Lcom/obric/oui/forms/AbsOForm;", "", "enabled", "Lkotlin/f0;", "setEnabled", "(Z)V", "onAttachedToWindow", "()V", "Landroid/graphics/drawable/Drawable;", "drawable", "setInputContainerBackground", "(Landroid/graphics/drawable/Drawable;)V", "", "getText", "()Ljava/lang/String;", "text", "setText", "(Ljava/lang/String;)V", "Lcom/obric/oui/forms/OLineInputView$a;", "getConfig", "()Lcom/obric/oui/forms/OLineInputView$a;", "flag", "setAutoHideClearWhenTextEmpty", "Landroid/view/View$OnFocusChangeListener;", "listener", "setEditTextOnFocusChangeListener", "(Landroid/view/View$OnFocusChangeListener;)V", "Landroid/widget/EditText;", "getInterEditText", "()Landroid/widget/EditText;", "Lcom/obric/oui/forms/OLineInputView$c;", "textExceedLengthListener", "setTextExceedLengthListener", "(Lcom/obric/oui/forms/OLineInputView$c;)V", "Lcom/obric/oui/forms/OLineInputView$b;", "textClearedListener", "setTextClearedListener", "(Lcom/obric/oui/forms/OLineInputView$b;)V", "Landroid/text/TextWatcher;", "textWatcher", "setTextWatcher", "(Landroid/text/TextWatcher;)V", "", "E", "I", "getArrangeDirection", "()I", "setArrangeDirection", "(I)V", "arrangeDirection", "Landroid/widget/RelativeLayout;", "t", "Landroid/widget/RelativeLayout;", "getPrefixContainer", "()Landroid/widget/RelativeLayout;", "prefixContainer", "Landroid/widget/TextView;", "l", "Landroid/widget/TextView;", "getTvErrorTips", "()Landroid/widget/TextView;", "tvErrorTips", "Landroid/view/ViewGroup;", "y", "Landroid/view/ViewGroup;", "getInputContainer", "()Landroid/view/ViewGroup;", "inputContainer", "C", "Lcom/obric/oui/forms/OLineInputView$a;", "config", "j", "getTvTitle", "tvTitle", "Lcom/obric/oui/forms/OFormEditText;", "k", "Lcom/obric/oui/forms/OFormEditText;", "getEditText", "()Lcom/obric/oui/forms/OFormEditText;", "editText", "Landroid/widget/ImageView;", "q", "Landroid/widget/ImageView;", "getIvAction", "()Landroid/widget/ImageView;", "ivAction", "m", "getTvCounter", "tvCounter", "w", "getTvInputTips", "tvInputTips", "D", "Landroid/text/TextWatcher;", "counterTextWatcher", "Landroidx/constraintlayout/widget/ConstraintLayout;", "A", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getActiveBorderView", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "setActiveBorderView", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "activeBorderView", "Landroid/widget/LinearLayout;", "p", "Landroid/widget/LinearLayout;", "getIvClearContainer", "()Landroid/widget/LinearLayout;", "ivClearContainer", "r", "getIvActionContainer", "ivActionContainer", "n", "getTvAction", "tvAction", "o", "getIvClear", "ivClear", "Lcom/obric/oui/divider/ODivider;", "s", "Lcom/obric/oui/divider/ODivider;", "getDivider", "()Lcom/obric/oui/divider/ODivider;", "divider", "z", "getActionContainer", "actionContainer", "B", "getLeftContainer", "setLeftContainer", "leftContainer", "u", "getSuffixContainer", "suffixContainer", BaseSwitches.V, "getIvTitleIcon", "ivTitleIcon", "x", "getTitleContainer", "titleContainer", "a", "b", "c", "OUI_standardRelease"}, k = 1, mv = {1, 1, 15})
public final class OLineInputView extends AbsOForm {
    private ConstraintLayout A;
    private ConstraintLayout B;
    private a C;
    private TextWatcher D;
    private int E;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final TextView f11058j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final OFormEditText f11059k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final TextView f11060l;
    private final TextView m;
    private final TextView n;
    private final ImageView o;
    private final LinearLayout p;
    private final ImageView q;
    private final LinearLayout r;
    private final ODivider s;
    private final RelativeLayout t;
    private final RelativeLayout u;
    private final ImageView v;
    private final TextView w;
    private final ViewGroup x;
    private final ViewGroup y;
    private final ViewGroup z;

    public static final class a {
        public final void a(boolean r1) {
            throw null;
        }

        public final void b(b r1) {
            throw null;
        }

        public final void c(c r1) {
            throw null;
        }

        public final void d(TextWatcher r1) {
            throw null;
        }
    }

    public interface b {
    }

    public interface c {
    }

    static {
    }

    public final ViewGroup getActionContainer() {
        return this.z;
    }

    public final ConstraintLayout getActiveBorderView() {
        return this.A;
    }

    public final int getArrangeDirection() {
        return this.E;
    }

    public final a getConfig() {
        return this.C;
    }

    public final ODivider getDivider() {
        return this.s;
    }

    public final OFormEditText getEditText() {
        return this.f11059k;
    }

    public final ViewGroup getInputContainer() {
        return this.y;
    }

    @Override // com.obric.oui.forms.AbsOForm
    public EditText getInterEditText() {
        return this.f11059k;
    }

    public final ImageView getIvAction() {
        return this.q;
    }

    public final LinearLayout getIvActionContainer() {
        return this.r;
    }

    public final ImageView getIvClear() {
        return this.o;
    }

    public final LinearLayout getIvClearContainer() {
        return this.p;
    }

    public final ImageView getIvTitleIcon() {
        return this.v;
    }

    public final ConstraintLayout getLeftContainer() {
        return this.B;
    }

    public final RelativeLayout getPrefixContainer() {
        return this.t;
    }

    public final RelativeLayout getSuffixContainer() {
        return this.u;
    }

    public final String getText() {
        return String.valueOf(this.f11059k.getText());
    }

    public final ViewGroup getTitleContainer() {
        return this.x;
    }

    public final TextView getTvAction() {
        return this.n;
    }

    public final TextView getTvCounter() {
        return this.m;
    }

    public final TextView getTvErrorTips() {
        return this.f11060l;
    }

    public final TextView getTvInputTips() {
        return this.w;
    }

    public final TextView getTvTitle() {
        return this.f11058j;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        float r0 = 44;
        Resources r1 = Resources.getSystem();
        o.e(r1, "Resources.getSystem()");
        int r2 = kotlin.o0.a.a(TypedValue.applyDimension(1, r0, r1.getDisplayMetrics()));
        ViewGroup r4 = this.z;
        Resources r5 = Resources.getSystem();
        o.e(r5, "Resources.getSystem()");
        j.a(r4, kotlin.o0.a.a(TypedValue.applyDimension(1, r0, r5.getDisplayMetrics())));
        j.d(this.z, r2, r2, new View[]{this.n, this.q});
    }

    public final void setActiveBorderView(ConstraintLayout r1) {
        this.A = r1;
    }

    public final void setArrangeDirection(int r1) {
        this.E = r1;
    }

    public final void setAutoHideClearWhenTextEmpty(boolean r1) {
        getConfig().a(r1);
        throw null;
    }

    public final void setEditTextOnFocusChangeListener(View.OnFocusChangeListener r2) {
        o.f(r2, "listener");
        this.f11059k.setOnFocusChangeListener(r2);
    }

    @Override // android.view.View
    public void setEnabled(boolean r2) {
        this.f11059k.setEnabled(r2);
        super.setEnabled(r2);
    }

    public final void setInputContainerBackground(Drawable r2) {
        o.f(r2, "drawable");
        this.y.setBackground(r2);
    }

    public final void setLeftContainer(ConstraintLayout r1) {
        this.B = r1;
    }

    public final void setText(String r3) {
        if (r3 == null) goto L7;
        this.f11059k.setText(r3);
        TextWatcher r2 = this.D;
        if (r2 == null) goto L8;
        r2.onTextChanged(r3, 0, 0, r3.length());
        return;
    L8:
        return;
    }

    public final void setTextClearedListener(b r2) {
        o.f(r2, "textClearedListener");
        this.C.b(r2);
        throw null;
    }

    public final void setTextExceedLengthListener(c r2) {
        o.f(r2, "textExceedLengthListener");
        this.C.c(r2);
        throw null;
    }

    public final void setTextWatcher(TextWatcher r1) {
        this.C.d(r1);
        throw null;
    }
}
