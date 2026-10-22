package com.obric.oui.dialog.input;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.EditText;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import com.obric.common.oui.R;
import com.obric.oui.common.util.ViewExtensionsKt;
import com.obric.oui.dialog.alert.OAlertDialog;
import com.obric.oui.dialog.alert.StyleController;
import com.obric.oui.text.OTextView;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InputBodyController.kt */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated(message = "已废弃")
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0018\u0010\u001f\u001a\u00020\u001c2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010 \u001a\u00020!H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\""}, d2 = {"Lcom/obric/oui/dialog/input/InputBodyController;", "Lcom/obric/oui/dialog/alert/StyleController;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "inputClear", "Landroidx/appcompat/widget/AppCompatImageView;", "getInputClear", "()Landroidx/appcompat/widget/AppCompatImageView;", "inputErrorHint", "Lcom/obric/oui/text/OTextView;", "getInputErrorHint", "()Lcom/obric/oui/text/OTextView;", "setInputErrorHint", "(Lcom/obric/oui/text/OTextView;)V", "inputText", "Landroid/widget/EditText;", "getInputText", "()Landroid/widget/EditText;", "setInputText", "(Landroid/widget/EditText;)V", "rootView", "Landroid/view/View;", "getRootView", "()Landroid/view/View;", "setRootView", "(Landroid/view/View;)V", "attachToDialog", "", "dialog", "Lcom/obric/oui/dialog/alert/OAlertDialog;", "attachToParent", "parent", "Landroid/widget/FrameLayout;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class InputBodyController implements StyleController {
    private final AppCompatImageView inputClear;
    private OTextView inputErrorHint;
    private EditText inputText;
    private View rootView;

    public static /* synthetic */ void $r8$lambda$zdtjBkrRN8dnuLiIp1dTXelpKh0(InputBodyController r0, View r1) {
        m284_init_$lambda0(r0, r1);
    }

    public InputBodyController(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        View r5 = LayoutInflater.from(r4).inflate(R.layout.o_dialog_body_input, null, false);
        Intrinsics.checkNotNullExpressionValue(r5, "from(context).inflate(R.…_body_input, null, false)");
        this.rootView = r5;
        View r6 = r5.findViewById(R.id.input_text);
        Intrinsics.checkNotNullExpressionValue(r6, "rootView.findViewById(R.id.input_text)");
        this.inputText = (EditText) r6;
        View r7 = this.rootView.findViewById(R.id.textinput_error);
        Intrinsics.checkNotNullExpressionValue(r7, "rootView.findViewById(R.id.textinput_error)");
        this.inputErrorHint = (OTextView) r7;
        View r8 = this.rootView.findViewById(R.id.input_clear);
        Intrinsics.checkNotNullExpressionValue(r8, "rootView.findViewById(R.id.input_clear)");
        AppCompatImageView r9 = (AppCompatImageView) r8;
        this.inputClear = r9;
        r9.setOnClickListener(new InputBodyController$$ExternalSyntheticLambda0(this));
        ViewExtensionsKt.setButtonAccessibilityDelegate(r9, "清除");
        this.inputText.addTextChangedListener(new InputBodyController$special$$inlined$addTextChangedListener$default$1(this));
    }

    public final EditText getInputText() {
        return this.inputText;
    }

    public final void setInputText(EditText r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.inputText = r2;
    }

    public final OTextView getInputErrorHint() {
        return this.inputErrorHint;
    }

    public final void setInputErrorHint(OTextView r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.inputErrorHint = r2;
    }

    public final View getRootView() {
        return this.rootView;
    }

    public final void setRootView(View r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.rootView = r2;
    }

    public final AppCompatImageView getInputClear() {
        return this.inputClear;
    }

    /* JADX INFO: renamed from: _init_$lambda-0, reason: not valid java name */
    private static final void m284_init_$lambda0(InputBodyController r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.inputText.setText("");
    }

    @Override // com.obric.oui.dialog.alert.StyleController
    public void attachToParent(Context r3, FrameLayout r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "parent");
        FrameLayout.LayoutParams r5 = new FrameLayout.LayoutParams(-1, -2);
        ViewParent r0 = this.rootView.getParent();
        if ((r0 instanceof ViewGroup) == false) goto L5;
        ((ViewGroup) r0).removeView(this.rootView);
    L5:
        r4.addView(this.rootView, r5);
    }

    @Override // com.obric.oui.dialog.alert.StyleController
    public void attachToDialog(OAlertDialog r1) {
        Intrinsics.checkNotNullParameter(r1, "dialog");
        r1.setAutoDismiss(false);
    }
}
