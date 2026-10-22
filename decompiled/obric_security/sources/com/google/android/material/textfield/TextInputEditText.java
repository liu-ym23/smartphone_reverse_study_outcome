package com.google.android.material.textfield;

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
import androidx.appcompat.widget.AppCompatEditText;
import com.google.android.material.R;
import com.google.android.material.internal.ManufacturerUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

/* JADX INFO: loaded from: classes2.dex */
public class TextInputEditText extends AppCompatEditText {
    private final Rect parentRect;
    private boolean textInputLayoutFocusedRectEnabled;

    public TextInputEditText(Context r2) {
        this(r2, null);
    }

    public TextInputEditText(Context r2, AttributeSet r3) {
        this(r2, r3, R.attr.editTextStyle);
    }

    public TextInputEditText(Context r9, AttributeSet r10, int r11) {
        super(MaterialThemeOverlay.wrap(r9, r10, r11, 0), r10, r11);
        this.parentRect = new Rect();
        TypedArray r12 = ThemeEnforcement.obtainStyledAttributes(r9, r10, R.styleable.TextInputEditText, r11, R.style.Widget_Design_TextInputEditText, new int[0]);
        setTextInputLayoutFocusedRectEnabled(r12.getBoolean(R.styleable.TextInputEditText_textInputLayoutFocusedRectEnabled, false));
        r12.recycle();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
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

    @Override // android.widget.TextView
    public CharSequence getHint() {
        TextInputLayout r0 = getTextInputLayout();
        if (r0 == null) goto L9;
        if (r0.isProvidingHint() == false) goto L9;
        return r0.getHint();
    L9:
        return super.getHint();
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo r3) {
        InputConnection r0 = super.onCreateInputConnection(r3);
        if (r0 != null) goto L5;
    L7:
        return r0;
    L5:
        if (r3.hintText != null) goto L7;
        r3.hintText = getHintFromLayout();
        goto L7
    }

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

    private CharSequence getHintFromLayout() {
        TextInputLayout r0 = getTextInputLayout();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getHint();
    }

    public void setTextInputLayoutFocusedRectEnabled(boolean r1) {
        this.textInputLayoutFocusedRectEnabled = r1;
    }

    public boolean isTextInputLayoutFocusedRectEnabled() {
        return this.textInputLayoutFocusedRectEnabled;
    }

    @Override // android.widget.TextView, android.view.View
    public void getFocusedRect(Rect r3) {
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
    public boolean getGlobalVisibleRect(Rect r4, Point r5) {
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

    @Override // android.view.View
    public boolean requestRectangleOnScreen(Rect r7) {
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

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r1) {
        super.onInitializeAccessibilityNodeInfo(r1);
        getTextInputLayout();
    }

    private String getAccessibilityNodeInfoText(TextInputLayout r5) {
        Editable r0 = getText();
        CharSequence r6 = r5.getHint();
        boolean r1 = !TextUtils.isEmpty(r0);
        boolean r2 = !TextUtils.isEmpty(r6);
        setLabelFor(R.id.textinput_helper_text);
        String r4 = "";
        if (r2 == false) goto L5;
        String r7 = r6.toString();
    L6:
        if (r1 == false) goto L13;
        StringBuilder r3 = new StringBuilder().append(r0);
        if (TextUtils.isEmpty(r7) == true) goto L11;
        r4 = ", " + r7;
    L11:
        return r3.append(r4).toString();
    L13:
        if (TextUtils.isEmpty(r7) == true) goto L15;
        return r7;
    L15:
        return "";
    L5:
        r7 = "";
        goto L6
    }
}
