package com.google.android.material.textfield;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.Filterable;
import android.widget.ListAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.appcompat.widget.ListPopupWindow;
import com.google.android.material.R;
import com.google.android.material.internal.ManufacturerUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

/* JADX INFO: loaded from: classes2.dex */
public class MaterialAutoCompleteTextView extends AppCompatAutoCompleteTextView {
    private static final int MAX_ITEMS_MEASURED = 15;

    @Nullable
    private final AccessibilityManager accessibilityManager;

    @NonNull
    private final ListPopupWindow modalListPopup;

    @NonNull
    private final Rect tempRect;

    public MaterialAutoCompleteTextView(@NonNull Context r2) {
        this(r2, null);
    }

    public MaterialAutoCompleteTextView(@NonNull Context r2, @Nullable AttributeSet r3) {
        this(r2, r3, R.attr.autoCompleteTextViewStyle);
    }

    public MaterialAutoCompleteTextView(@NonNull Context r8, @Nullable AttributeSet r9, int r10) {
        super(MaterialThemeOverlay.wrap(r8, r9, r10, 0), r9, r10);
        this.tempRect = new Rect();
        Context r11 = getContext();
        TypedArray r12 = ThemeEnforcement.obtainStyledAttributes(r11, r9, R.styleable.MaterialAutoCompleteTextView, r10, R.style.Widget_AppCompat_AutoCompleteTextView, new int[0]);
        int r13 = R.styleable.MaterialAutoCompleteTextView_android_inputType;
        if (r12.hasValue(r13) == true) goto L5;
    L7:
        this.accessibilityManager = (AccessibilityManager) r11.getSystemService("accessibility");
        ListPopupWindow r14 = new ListPopupWindow(r11);
        this.modalListPopup = r14;
        r14.setModal(true);
        r14.setAnchorView(this);
        r14.setInputMethodMode(2);
        r14.setAdapter(getAdapter());
        r14.setOnItemClickListener(new AnonymousClass1(this));
        r12.recycle();
        return;
    L5:
        if (r12.getInt(r13, 0) != 0) goto L7;
        setKeyListener(null);
        goto L7
    }

    static /* synthetic */ ListPopupWindow access$000(MaterialAutoCompleteTextView r0) {
        return r0.modalListPopup;
    }

    static /* synthetic */ void access$100(MaterialAutoCompleteTextView r0, Object r1) {
        r0.updateText(r1);
    }

    @Nullable
    private TextInputLayout findTextInputLayoutAncestor() {
        ViewParent r1 = getParent();
    L3:
        if (r1 == null) goto L9;
        if ((r1 instanceof TextInputLayout) == true) goto L7;
        r1 = r1.getParent();
        goto L3
    L7:
        return (TextInputLayout) r1;
    L9:
        return null;
    }

    private int measureContentWidth() {
        ListAdapter r0 = getAdapter();
        TextInputLayout r1 = findTextInputLayoutAncestor();
        int r2 = 0;
        if (r0 == null) goto L20;
        if (r1 == null) goto L20;
        int r3 = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int r4 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int r5 = Math.min(r0.getCount(), Math.max(0, this.modalListPopup.getSelectedItemPosition()) + 15);
        int r8 = Math.max(0, r5 - 15);
        View r9 = null;
        int r6 = 0;
    L7:
        if (r8 >= r5) goto L15;
        int r10 = r0.getItemViewType(r8);
        if (r10 == r2) goto L11;
        r9 = null;
        r2 = r10;
    L11:
        r9 = r0.getView(r8, r9, r1);
        if (r9.getLayoutParams() != null) goto L14;
        r9.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    L14:
        r9.measure(r3, r4);
        r6 = Math.max(r6, r9.getMeasuredWidth());
        r8 = r8 + 1;
        goto L7
    L15:
        Drawable r7 = this.modalListPopup.getBackground();
        if (r7 == null) goto L19;
        r7.getPadding(this.tempRect);
        Rect r12 = this.tempRect;
        r6 = r6 + (r12.left + r12.right);
    L19:
        return r6 + r1.getEndIconView().getMeasuredWidth();
    L20:
        return 0;
    }

    private <T extends ListAdapter & Filterable> void updateText(Object r3) {
        if (Build.VERSION.SDK_INT < 17) goto L5;
        setText(convertSelectionToString(r3), false);
        return;
    L5:
        ListAdapter r0 = getAdapter();
        setAdapter(null);
        setText(convertSelectionToString(r3));
        setAdapter(r0);
    }

    @Override // android.widget.TextView
    @Nullable
    public CharSequence getHint() {
        TextInputLayout r0 = findTextInputLayoutAncestor();
        if (r0 == null) goto L9;
        if (r0.isProvidingHint() == false) goto L9;
        return r0.getHint();
    L9:
        return super.getHint();
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextInputLayout r0 = findTextInputLayoutAncestor();
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

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int r2, int r3) {
        super.onMeasure(r2, r3);
        if (View.MeasureSpec.getMode(r2) != Integer.MIN_VALUE) goto L6;
        setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), measureContentWidth()), View.MeasureSpec.getSize(r2)), getMeasuredHeight());
        return;
    }

    @Override // android.widget.AutoCompleteTextView
    public <T extends ListAdapter & Filterable> void setAdapter(@Nullable T r1) {
        super.setAdapter(r1);
        this.modalListPopup.setAdapter(getAdapter());
    }

    @Override // android.widget.AutoCompleteTextView
    public void showDropDown() {
        AccessibilityManager r0 = this.accessibilityManager;
        if (r0 != null) goto L5;
    L7:
        super.showDropDown();
        return;
    L5:
        if (r0.isTouchExplorationEnabled() == false) goto L7;
        this.modalListPopup.show();
    }
}
