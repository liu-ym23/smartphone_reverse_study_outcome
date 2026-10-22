package com.obric.oui.forms;

import android.content.res.Resources;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000f\u0018\u00002\u00020\u0001:\u0001MJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\n\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0019\u0010\u001e\u001a\u00020\u00198\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\"\u0010#\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u001b\u001a\u0004\b \u0010\u001d\"\u0004\b!\u0010\"R\u0019\u0010)\u001a\u00020$8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u0019\u0010/\u001a\u00020*8\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u0019\u00102\u001a\u00020$8\u0006@\u0006¢\u0006\f\n\u0004\b0\u0010&\u001a\u0004\b1\u0010(R\u0016\u00105\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0019\u00108\u001a\u00020$8\u0006@\u0006¢\u0006\f\n\u0004\b6\u0010&\u001a\u0004\b7\u0010(R\u0019\u0010>\u001a\u0002098\u0006@\u0006¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\"\u0010F\u001a\u00020?8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u0019\u0010I\u001a\u00020\u00198\u0006@\u0006¢\u0006\f\n\u0004\bG\u0010\u001b\u001a\u0004\bH\u0010\u001dR\u0018\u0010L\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010K¨\u0006N"}, d2 = {"Lcom/obric/oui/forms/OBoxInputView;", "Lcom/obric/oui/forms/AbsOForm;", "Landroid/view/View;", "view", "Lkotlin/f0;", "setPrefixView", "(Landroid/view/View;)V", "f", "()V", "", "getText", "()Ljava/lang/String;", "text", "setText", "(Ljava/lang/String;)V", "Lcom/obric/oui/forms/OBoxInputView$a;", "getConfig", "()Lcom/obric/oui/forms/OBoxInputView$a;", "Landroid/text/TextWatcher;", "textWatcher", "setTextWatcher", "(Landroid/text/TextWatcher;)V", "Landroid/widget/EditText;", "getInterEditText", "()Landroid/widget/EditText;", "Landroid/view/ViewGroup;", "o", "Landroid/view/ViewGroup;", "getInputContainer", "()Landroid/view/ViewGroup;", "inputContainer", "q", "getTitleContainer", "setTitleContainer", "(Landroid/view/ViewGroup;)V", "titleContainer", "Landroid/widget/TextView;", "l", "Landroid/widget/TextView;", "getTvErrorTips", "()Landroid/widget/TextView;", "tvErrorTips", "Landroidx/appcompat/widget/AppCompatEditText;", "k", "Landroidx/appcompat/widget/AppCompatEditText;", "getEditText", "()Landroidx/appcompat/widget/AppCompatEditText;", "editText", "j", "getTvTitle", "tvTitle", "r", "Lcom/obric/oui/forms/OBoxInputView$a;", "config", "m", "getTvCounter", "tvCounter", "Landroid/widget/ImageView;", "n", "Landroid/widget/ImageView;", "getIvTitleIcon", "()Landroid/widget/ImageView;", "ivTitleIcon", "", "t", "I", "getArrangeDirection", "()I", "setArrangeDirection", "(I)V", "arrangeDirection", "p", "getPrefixContainer", "prefixContainer", "s", "Landroid/text/TextWatcher;", "counterTextWatcher", "a", "OUI_standardRelease"}, k = 1, mv = {1, 1, 15})
public final class OBoxInputView extends AbsOForm {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final TextView f11000j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final AppCompatEditText f11001k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final TextView f11002l;
    private final TextView m;
    private final ImageView n;
    private final ViewGroup o;
    private final ViewGroup p;
    private ViewGroup q;
    private a r;
    private TextWatcher s;
    private int t;

    public static final class a {
    }

    static {
        Resources r1 = Resources.getSystem();
        o.e(r1, "Resources.getSystem()");
        kotlin.o0.a.a(TypedValue.applyDimension(1, 144, r1.getDisplayMetrics()));
    }

    private final void f() {
        Iterator<WeakReference<TextWatcher>> r0 = getTextWatchers().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        WeakReference<TextWatcher> r1 = r0.next();
        this.f11001k.removeTextChangedListener(r1.get());
        goto L4
    }

    private final void setPrefixView(View r3) {
        if (r3 == null) goto L5;
        this.p.removeAllViews();
        this.p.addView(r3, new ConstraintLayout.LayoutParams(-2, -2));
        return;
    }

    public final int getArrangeDirection() {
        return this.t;
    }

    public final a getConfig() {
        return this.r;
    }

    public final AppCompatEditText getEditText() {
        return this.f11001k;
    }

    public final ViewGroup getInputContainer() {
        return this.o;
    }

    @Override // com.obric.oui.forms.AbsOForm
    public EditText getInterEditText() {
        return this.f11001k;
    }

    public final ImageView getIvTitleIcon() {
        return this.n;
    }

    public final ViewGroup getPrefixContainer() {
        return this.p;
    }

    public final String getText() {
        return String.valueOf(this.f11001k.getText());
    }

    public final ViewGroup getTitleContainer() {
        return this.q;
    }

    public final TextView getTvCounter() {
        return this.m;
    }

    public final TextView getTvErrorTips() {
        return this.f11002l;
    }

    public final TextView getTvTitle() {
        return this.f11000j;
    }

    public final void setArrangeDirection(int r1) {
        this.t = r1;
    }

    public final void setText(String r3) {
        if (r3 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L14;
        this.f11001k.setText(r3);
        TextWatcher r2 = this.s;
        if (r2 == null) goto L15;
        o.c(r3);
        r2.onTextChanged(r3, 0, 0, r3.length());
        return;
    L15:
        return;
    L14:
        return;
    L5:
        if (r3.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public final void setTextWatcher(TextWatcher r3) {
        o.f(r3, "textWatcher");
        f();
        getTextWatchers().add(new WeakReference(r3));
        this.f11001k.addTextChangedListener(r3);
    }

    public final void setTitleContainer(ViewGroup r2) {
        o.f(r2, "<set-?>");
        this.q = r2;
    }
}
