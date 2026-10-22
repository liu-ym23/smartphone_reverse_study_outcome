package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.R;

/* JADX INFO: loaded from: classes2.dex */
public class Snackbar extends BaseTransientBottomBar<Snackbar> {
    private static final int[] SNACKBAR_BUTTON_STYLE_ATTR = null;
    private static final int[] SNACKBAR_CONTENT_STYLE_ATTRS = null;
    private final AccessibilityManager accessibilityManager;
    private BaseTransientBottomBar.BaseCallback<Snackbar> callback;
    private boolean hasAction;

    public static class Callback extends BaseTransientBottomBar.BaseCallback<Snackbar> {
        public static final int DISMISS_EVENT_ACTION = 1;
        public static final int DISMISS_EVENT_CONSECUTIVE = 4;
        public static final int DISMISS_EVENT_MANUAL = 3;
        public static final int DISMISS_EVENT_SWIPE = 0;
        public static final int DISMISS_EVENT_TIMEOUT = 2;

        /* JADX INFO: renamed from: onDismissed, reason: avoid collision after fix types in other method */
        public void onDismissed2(Snackbar r1, int r2) {
        }

        /* JADX INFO: renamed from: onShown, reason: avoid collision after fix types in other method */
        public void onShown2(Snackbar r1) {
        }

        public Callback() {
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.BaseCallback
        public /* bridge */ /* synthetic */ void onDismissed(Snackbar r1, int r2) {
            onDismissed2(r1, r2);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.BaseCallback
        public /* bridge */ /* synthetic */ void onShown(Snackbar r1) {
            onShown2(r1);
        }
    }

    public static final class SnackbarLayout extends BaseTransientBottomBar.SnackbarBaseLayout {
        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setBackground(Drawable r1) {
            super.setBackground(r1);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setBackgroundDrawable(Drawable r1) {
            super.setBackgroundDrawable(r1);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setBackgroundTintList(ColorStateList r1) {
            super.setBackgroundTintList(r1);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setBackgroundTintMode(PorterDuff.Mode r1) {
            super.setBackgroundTintMode(r1);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setOnClickListener(View.OnClickListener r1) {
            super.setOnClickListener(r1);
        }

        public SnackbarLayout(Context r1) {
            super(r1);
        }

        public SnackbarLayout(Context r1, AttributeSet r2) {
            super(r1, r2);
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int r6, int r7) {
            super.onMeasure(r6, r7);
            int r8 = getChildCount();
            int r9 = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            int r0 = 0;
        L3:
            if (r0 >= r8) goto L8;
            View r1 = getChildAt(r0);
            if (r1.getLayoutParams().width != (-1)) goto L7;
            r1.measure(View.MeasureSpec.makeMeasureSpec(r9, 1073741824), View.MeasureSpec.makeMeasureSpec(r1.getMeasuredHeight(), 1073741824));
        L7:
            r0 = r0 + 1;
            goto L3
        }
    }

    static {
        SNACKBAR_BUTTON_STYLE_ATTR = new int[]{R.attr.snackbarButtonStyle};
        SNACKBAR_CONTENT_STYLE_ATTRS = new int[]{R.attr.snackbarButtonStyle, R.attr.snackbarTextViewStyle};
    }

    private Snackbar(Context r1, ViewGroup r2, View r3, ContentViewCallback r4) {
        super(r1, r2, r3, r4);
        this.accessibilityManager = (AccessibilityManager) r2.getContext().getSystemService("accessibility");
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public void show() {
        super.show();
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public void dismiss() {
        super.dismiss();
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public boolean isShown() {
        return super.isShown();
    }

    public static Snackbar make(View r1, CharSequence r2, int r3) {
        return makeInternal(null, r1, r2, r3);
    }

    public static Snackbar make(Context r0, View r1, CharSequence r2, int r3) {
        return makeInternal(r0, r1, r2, r3);
    }

    private static Snackbar makeInternal(Context r3, View r4, CharSequence r5, int r6) {
        ViewGroup r7 = findSuitableParent(r4);
        if (r7 == null) goto L13;
        if (r3 != null) goto L6;
        r3 = r7.getContext();
    L6:
        LayoutInflater r0 = LayoutInflater.from(r3);
        if (hasSnackbarContentStyleAttrs(r3) == false) goto L9;
        int r1 = R.layout.mtrl_layout_snackbar_include;
    L10:
        SnackbarContentLayout r2 = (SnackbarContentLayout) r0.inflate(r1, r7, false);
        Snackbar r8 = new Snackbar(r3, r7, r2, r2);
        r8.setText(r5);
        r8.setDuration(r6);
        return r8;
    L9:
        r1 = R.layout.design_layout_snackbar_include;
        goto L10
    L13:
        throw new IllegalArgumentException("No suitable parent found from the given view. Please provide a valid view.");
    }

    @Deprecated
    protected static boolean hasSnackbarButtonStyleAttr(Context r3) {
        TypedArray r4 = r3.obtainStyledAttributes(SNACKBAR_BUTTON_STYLE_ATTR);
        int r2 = r4.getResourceId(0, -1);
        r4.recycle();
        if (r2 == (-1)) goto L6;
        return true;
    L6:
        return false;
    }

    private static boolean hasSnackbarContentStyleAttrs(Context r5) {
        TypedArray r6 = r5.obtainStyledAttributes(SNACKBAR_CONTENT_STYLE_ATTRS);
        int r2 = r6.getResourceId(0, -1);
        int r4 = r6.getResourceId(1, -1);
        r6.recycle();
        if (r2 == (-1)) goto L7;
        if (r4 != (-1)) goto L6;
        return false;
    L6:
        return true;
    L7:
        return false;
    }

    public static Snackbar make(View r1, int r2, int r3) {
        return make(r1, r1.getResources().getText(r2), r3);
    }

    private static ViewGroup findSuitableParent(View r3) {
        ViewGroup r1 = null;
    L4:
        if ((r3 instanceof CoordinatorLayout) == true) goto L6;
        if ((r3 instanceof FrameLayout) == true) goto L10;
    L14:
        if (r3 == null) goto L19;
        Object r4 = r3.getParent();
        if ((r4 instanceof View) == false) goto L18;
        r3 = (View) r4;
        goto L19
    L18:
        r3 = null;
    L19:
        if (r3 != null) goto L4;
        return r1;
    L10:
        if (r3.getId() == 16908290) goto L12;
        r1 = (ViewGroup) r3;
        goto L14
    L12:
        return (ViewGroup) r3;
    L6:
        return (ViewGroup) r3;
    }

    public Snackbar setText(CharSequence r3) {
        ((SnackbarContentLayout) this.view.getChildAt(0)).getMessageView().setText(r3);
        return this;
    }

    public Snackbar setText(int r2) {
        return setText(getContext().getText(r2));
    }

    public Snackbar setAction(int r2, View.OnClickListener r3) {
        return setAction(getContext().getText(r2), r3);
    }

    public Snackbar setAction(CharSequence r4, final View.OnClickListener r5) {
        Button r0 = ((SnackbarContentLayout) this.view.getChildAt(0)).getActionView();
        if (TextUtils.isEmpty(r4) == true) goto L7;
        if (r5 == null) goto L7;
        this.hasAction = true;
        r0.setVisibility(0);
        r0.setText(r4);
        r0.setOnClickListener(new AnonymousClass1(this, r5));
    L8:
        return this;
    L7:
        r0.setVisibility(8);
        r0.setOnClickListener(null);
        this.hasAction = false;
        goto L8
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public int getDuration() {
        int r0 = super.getDuration();
        if (r0 != (-2)) goto L6;
        return -2;
    L6:
        if (this.hasAction == false) goto L8;
        int r1 = 4;
    L10:
        return this.accessibilityManager.getRecommendedTimeoutMillis(r0, (r1 | 1) | 2);
    L8:
        r1 = 0;
        goto L10
    }

    public Snackbar setTextColor(ColorStateList r3) {
        ((SnackbarContentLayout) this.view.getChildAt(0)).getMessageView().setTextColor(r3);
        return this;
    }

    public Snackbar setTextColor(int r3) {
        ((SnackbarContentLayout) this.view.getChildAt(0)).getMessageView().setTextColor(r3);
        return this;
    }

    public Snackbar setActionTextColor(ColorStateList r3) {
        ((SnackbarContentLayout) this.view.getChildAt(0)).getActionView().setTextColor(r3);
        return this;
    }

    public Snackbar setMaxInlineActionWidth(int r3) {
        ((SnackbarContentLayout) this.view.getChildAt(0)).setMaxInlineActionWidth(r3);
        return this;
    }

    public Snackbar setActionTextColor(int r3) {
        ((SnackbarContentLayout) this.view.getChildAt(0)).getActionView().setTextColor(r3);
        return this;
    }

    public Snackbar setBackgroundTint(int r1) {
        return setBackgroundTintList(ColorStateList.valueOf(r1));
    }

    public Snackbar setBackgroundTintList(ColorStateList r2) {
        this.view.setBackgroundTintList(r2);
        return this;
    }

    public Snackbar setBackgroundTintMode(PorterDuff.Mode r2) {
        this.view.setBackgroundTintMode(r2);
        return this;
    }

    @Deprecated
    public Snackbar setCallback(Callback r2) {
        BaseTransientBottomBar.BaseCallback<Snackbar> r0 = this.callback;
        if (r0 == null) goto L5;
        removeCallback(r0);
    L5:
        if (r2 == null) goto L7;
        addCallback(r2);
    L7:
        this.callback = r2;
        return this;
    }
}
