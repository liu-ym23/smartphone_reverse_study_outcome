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
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.R;

/* JADX INFO: loaded from: classes.dex */
public class Snackbar extends BaseTransientBottomBar<Snackbar> {
    private static final int[] SNACKBAR_BUTTON_STYLE_ATTR = null;
    private static final int[] SNACKBAR_CONTENT_STYLE_ATTRS = null;

    @Nullable
    private final AccessibilityManager accessibilityManager;

    @Nullable
    private BaseTransientBottomBar.BaseCallback<Snackbar> callback;
    private boolean hasAction;

    public static class Callback extends BaseTransientBottomBar.BaseCallback<Snackbar> {
        public static final int DISMISS_EVENT_ACTION = 1;
        public static final int DISMISS_EVENT_CONSECUTIVE = 4;
        public static final int DISMISS_EVENT_MANUAL = 3;
        public static final int DISMISS_EVENT_SWIPE = 0;
        public static final int DISMISS_EVENT_TIMEOUT = 2;

        public Callback() {
        }

        /* JADX INFO: renamed from: onDismissed, reason: avoid collision after fix types in other method */
        public void onDismissed2(Snackbar r1, int r2) {
        }

        /* JADX INFO: renamed from: onShown, reason: avoid collision after fix types in other method */
        public void onShown2(Snackbar r1) {
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

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final class SnackbarLayout extends BaseTransientBottomBar.SnackbarBaseLayout {
        public SnackbarLayout(Context r1) {
            super(r1);
        }

        @Override // android.widget.FrameLayout, android.view.View
        public void onMeasure(int r6, int r7) {
            super.onMeasure(r6, r7);
            int r8 = getChildCount();
            int r9 = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            int r0 = 0;
        L3:
            if (r0 >= r8) goto L8;
            View r1 = getChildAt(r0);
            if (r1.getLayoutParams().width != (-1)) goto L7;
            r1.measure(View.MeasureSpec.makeMeasureSpec(r9, BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(r1.getMeasuredHeight(), BasicMeasure.EXACTLY));
        L7:
            r0 = r0 + 1;
            goto L3
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setBackground(@Nullable Drawable r1) {
            super.setBackground(r1);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setBackgroundDrawable(@Nullable Drawable r1) {
            super.setBackgroundDrawable(r1);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setBackgroundTintList(@Nullable ColorStateList r1) {
            super.setBackgroundTintList(r1);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setBackgroundTintMode(@Nullable PorterDuff.Mode r1) {
            super.setBackgroundTintMode(r1);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setOnClickListener(@Nullable View.OnClickListener r1) {
            super.setOnClickListener(r1);
        }

        public SnackbarLayout(Context r1, AttributeSet r2) {
            super(r1, r2);
        }
    }

    static {
        int r0 = R.attr.snackbarButtonStyle;
        SNACKBAR_BUTTON_STYLE_ATTR = new int[]{r0};
        SNACKBAR_CONTENT_STYLE_ATTRS = new int[]{r0, R.attr.snackbarTextViewStyle};
    }

    private Snackbar(@NonNull ViewGroup r1, @NonNull View r2, @NonNull ContentViewCallback r3) {
        super(r1, r2, r3);
        this.accessibilityManager = (AccessibilityManager) r1.getContext().getSystemService("accessibility");
    }

    @Nullable
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

    @Deprecated
    public static boolean hasSnackbarButtonStyleAttr(@NonNull Context r3) {
        TypedArray r4 = r3.obtainStyledAttributes(SNACKBAR_BUTTON_STYLE_ATTR);
        int r2 = r4.getResourceId(0, -1);
        r4.recycle();
        if (r2 == (-1)) goto L6;
        return true;
    L6:
        return false;
    }

    private static boolean hasSnackbarContentStyleAttrs(@NonNull Context r5) {
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

    @NonNull
    public static Snackbar make(@NonNull View r3, @NonNull CharSequence r4, int r5) {
        ViewGroup r6 = findSuitableParent(r3);
        if (r6 == null) goto L11;
        LayoutInflater r0 = LayoutInflater.from(r6.getContext());
        if (hasSnackbarContentStyleAttrs(r6.getContext()) == false) goto L7;
        int r1 = R.layout.mtrl_layout_snackbar_include;
    L8:
        SnackbarContentLayout r2 = (SnackbarContentLayout) r0.inflate(r1, r6, false);
        Snackbar r7 = new Snackbar(r6, r2, r2);
        r7.setText(r4);
        r7.setDuration(r5);
        return r7;
    L7:
        r1 = R.layout.design_layout_snackbar_include;
        goto L8
    L11:
        throw new IllegalArgumentException("No suitable parent found from the given view. Please provide a valid view.");
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public void dismiss() {
        super.dismiss();
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
        return this.accessibilityManager.getRecommendedTimeoutMillis(r0, r1 | 3);
    L8:
        r1 = 0;
        goto L10
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public boolean isShown() {
        return super.isShown();
    }

    @NonNull
    public Snackbar setAction(@StringRes int r2, View.OnClickListener r3) {
        return setAction(getContext().getText(r2), r3);
    }

    @NonNull
    public Snackbar setActionTextColor(ColorStateList r3) {
        ((SnackbarContentLayout) this.view.getChildAt(0)).getActionView().setTextColor(r3);
        return this;
    }

    @NonNull
    public Snackbar setBackgroundTint(@ColorInt int r1) {
        return setBackgroundTintList(ColorStateList.valueOf(r1));
    }

    @NonNull
    public Snackbar setBackgroundTintList(@Nullable ColorStateList r2) {
        this.view.setBackgroundTintList(r2);
        return this;
    }

    @NonNull
    public Snackbar setBackgroundTintMode(@Nullable PorterDuff.Mode r2) {
        this.view.setBackgroundTintMode(r2);
        return this;
    }

    @NonNull
    @Deprecated
    public Snackbar setCallback(@Nullable Callback r2) {
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

    @NonNull
    public Snackbar setMaxInlineActionWidth(@Dimension int r3) {
        ((SnackbarContentLayout) this.view.getChildAt(0)).setMaxInlineActionWidth(r3);
        return this;
    }

    @NonNull
    public Snackbar setText(@NonNull CharSequence r3) {
        ((SnackbarContentLayout) this.view.getChildAt(0)).getMessageView().setText(r3);
        return this;
    }

    @NonNull
    public Snackbar setTextColor(ColorStateList r3) {
        ((SnackbarContentLayout) this.view.getChildAt(0)).getMessageView().setTextColor(r3);
        return this;
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public void show() {
        super.show();
    }

    @NonNull
    public Snackbar setAction(@Nullable CharSequence r4, @Nullable final View.OnClickListener r5) {
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

    @NonNull
    public Snackbar setActionTextColor(@ColorInt int r3) {
        ((SnackbarContentLayout) this.view.getChildAt(0)).getActionView().setTextColor(r3);
        return this;
    }

    @NonNull
    public Snackbar setText(@StringRes int r2) {
        return setText(getContext().getText(r2));
    }

    @NonNull
    public Snackbar setTextColor(@ColorInt int r3) {
        ((SnackbarContentLayout) this.view.getChildAt(0)).getMessageView().setTextColor(r3);
        return this;
    }

    @NonNull
    public static Snackbar make(@NonNull View r1, @StringRes int r2, int r3) {
        return make(r1, r1.getResources().getText(r2), r3);
    }
}
