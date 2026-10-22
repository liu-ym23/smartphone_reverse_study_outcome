package com.google.android.material.textfield;

import a.a;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.graphics.Rect;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import com.google.android.material.R;
import com.google.android.material.internal.ManufacturerUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

/* JADX INFO: loaded from: classes.dex */
public class TextInputEditText extends AppCompatEditText {
    private final Rect parentRect;
    private boolean textInputLayoutFocusedRectEnabled;

    public TextInputEditText(@NonNull Context r2) {
        this(r2, null);
    }

    @NonNull
    private String getAccessibilityNodeInfoText(@NonNull TextInputLayout r9) {
        Editable r8 = getText();
        CharSequence r0 = r9.getHint();
        CharSequence r1 = r9.getHelperText();
        CharSequence r10 = r9.getError();
        boolean r2 = !TextUtils.isEmpty(r8);
        boolean r3 = !TextUtils.isEmpty(r0);
        boolean r4 = !TextUtils.isEmpty(r1);
        boolean r5 = !TextUtils.isEmpty(r10);
        String r6 = "";
        if (r3 == false) goto L5;
        String r7 = r0.toString();
    L6:
        StringBuilder r11 = a.q(r7);
        if (r5 == true) goto L10;
        if (r4 == true) goto L10;
    L12:
        String r12 = "";
    L13:
        r11.append(r12);
        StringBuilder r13 = a.q(r11.toString());
        if (r5 == false) goto L16;
        r1 = r10;
    L19:
        r13.append(r1);
        String r14 = r13.toString();
        if (r2 == false) goto L27;
        StringBuilder r15 = new StringBuilder();
        r15.append(r8);
        if (TextUtils.isEmpty(r14) == true) goto L24;
        r6 = a.A(", ", r14);
    L24:
        r15.append(r6);
        return r15.toString();
    L27:
        if (TextUtils.isEmpty(r14) == true) goto L29;
        return r14;
    L29:
        return "";
    L16:
        if (r4 == true) goto L19;
        r1 = "";
    L10:
        if (TextUtils.isEmpty(r7) == true) goto L12;
        r12 = ", ";
        goto L13
    L5:
        r7 = "";
        goto L6
    }

    @Nullable
    private CharSequence getHintFromLayout() {
        TextInputLayout r0 = getTextInputLayout();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getHint();
    }

    @Nullable
    private TextInputLayout getTextInputLayout() {
        ViewParent r1 = getParent();
    L4:
        if ((r1 instanceof View) == false) goto L10;
        if ((r1 instanceof TextInputLayout) == true) goto L8;
        r1 = r1.getParent();
        goto L4
    L8:
        return (TextInputLayout) r1;
    L10:
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public void getFocusedRect(@Nullable Rect r3) {
        super.getFocusedRect(r3);
        TextInputLayout r0 = getTextInputLayout();
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.textInputLayoutFocusedRectEnabled == false) goto L10;
        if (r3 == null) goto L11;
        r0.getFocusedRect(this.parentRect);
        r3.bottom = this.parentRect.bottom;
        return;
    L11:
        return;
    }

    @Override // android.view.View
    public boolean getGlobalVisibleRect(@Nullable Rect r4, @Nullable Point r5) {
        boolean r0 = super.getGlobalVisibleRect(r4, r5);
        TextInputLayout r1 = getTextInputLayout();
        if (r1 != null) goto L5;
    L8:
        return r0;
    L5:
        if (this.textInputLayoutFocusedRectEnabled == false) goto L8;
        if (r4 == null) goto L8;
        r1.getGlobalVisibleRect(this.parentRect, r5);
        r4.bottom = this.parentRect.bottom;
        goto L8
    }

    @Override // android.widget.TextView
    @Nullable
    public CharSequence getHint() {
        TextInputLayout r0 = getTextInputLayout();
        if (r0 == null) goto L9;
        if (r0.isProvidingHint() == false) goto L9;
        return r0.getHint();
    L9:
        return super.getHint();
    }

    public boolean isTextInputLayoutFocusedRectEnabled() {
        return this.textInputLayoutFocusedRectEnabled;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextInputLayout r0 = getTextInputLayout();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isProvidingHint() == true) goto L7;
        return;
    L7:
        if (super.getHint() == null) goto L9;
        return;
    L9:
        if (ManufacturerUtils.isMeizuDevice() == false) goto L15;
        setHint("");
        return;
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.TextView, android.view.View
    @Nullable
    public InputConnection onCreateInputConnection(@NonNull EditorInfo r3) {
        InputConnection r0 = super.onCreateInputConnection(r3);
        if (r0 != null) goto L5;
    L7:
        return r0;
    L5:
        if (r3.hintText != null) goto L7;
        r3.hintText = getHintFromLayout();
        goto L7
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo r1) {
        super.onInitializeAccessibilityNodeInfo(r1);
        getTextInputLayout();
    }

    @Override // android.view.View
    public boolean requestRectangleOnScreen(@Nullable Rect r7) {
        boolean r8 = super.requestRectangleOnScreen(r7);
        TextInputLayout r0 = getTextInputLayout();
        if (r0 != null) goto L5;
    L7:
        return r8;
    L5:
        if (this.textInputLayoutFocusedRectEnabled == false) goto L7;
        this.parentRect.set(0, r0.getHeight() - getResources().getDimensionPixelOffset(R.dimen.mtrl_edittext_rectangle_top_offset), r0.getWidth(), r0.getHeight());
        r0.requestRectangleOnScreen(this.parentRect, true);
        goto L7
    }

    public void setTextInputLayoutFocusedRectEnabled(boolean r1) {
        this.textInputLayoutFocusedRectEnabled = r1;
    }

    public TextInputEditText(@NonNull Context r2, @Nullable AttributeSet r3) {
        this(r2, r3, R.attr.editTextStyle);
    }

    public TextInputEditText(@NonNull Context r9, @Nullable AttributeSet r10, int r11) {
        super(MaterialThemeOverlay.wrap(r9, r10, r11, 0), r10, r11);
        this.parentRect = new Rect();
        TypedArray r12 = ThemeEnforcement.obtainStyledAttributes(r9, r10, R.styleable.TextInputEditText, r11, R.style.Widget_Design_TextInputEditText, new int[0]);
        setTextInputLayoutFocusedRectEnabled(r12.getBoolean(R.styleable.TextInputEditText_textInputLayoutFocusedRectEnabled, false));
        r12.recycle();
    }
}
