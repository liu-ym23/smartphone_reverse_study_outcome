package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.R;

/* JADX INFO: loaded from: classes3.dex */
public class ViewUtils {

    public interface OnApplyWindowInsetsListener {
        WindowInsetsCompat onApplyWindowInsets(View r1, WindowInsetsCompat r2, RelativePadding r3);
    }

    public static class RelativePadding {
        public int bottom;
        public int end;
        public int start;
        public int top;

        public RelativePadding(int r1, int r2, int r3, int r4) {
            this.start = r1;
            this.top = r2;
            this.end = r3;
            this.bottom = r4;
        }

        public RelativePadding(RelativePadding r2) {
            this.start = r2.start;
            this.top = r2.top;
            this.end = r2.end;
            this.bottom = r2.bottom;
        }

        public void applyToView(View r4) {
            ViewCompat.setPaddingRelative(r4, this.start, this.top, this.end, this.bottom);
        }
    }

    private ViewUtils() {
    }

    public static PorterDuff.Mode parseTintMode(int r1, PorterDuff.Mode r2) {
        if (r1 == 3) goto L21;
        if (r1 == 5) goto L19;
        if (r1 == 9) goto L17;
        switch(r1) {
            case 14: goto L15;
            case 15: goto L13;
            case 16: goto L11;
            default: goto L9;
        };
    L9:
        return r2;
    L11:
        return PorterDuff.Mode.ADD;
    L13:
        return PorterDuff.Mode.SCREEN;
    L15:
        return PorterDuff.Mode.MULTIPLY;
    L17:
        return PorterDuff.Mode.SRC_ATOP;
    L19:
        return PorterDuff.Mode.SRC_IN;
    L21:
        return PorterDuff.Mode.SRC_OVER;
    }

    public static boolean isLayoutRtl(View r1) {
        if (ViewCompat.getLayoutDirection(r1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static float dpToPx(Context r1, int r2) {
        return TypedValue.applyDimension(1, r2, r1.getResources().getDisplayMetrics());
    }

    public static void requestFocusAndShowKeyboard(final View r1) {
        r1.requestFocus();
        r1.post(new AnonymousClass1(r1));
    }

    public static void doOnApplyWindowInsets(View r1, AttributeSet r2, int r3, int r4) {
        doOnApplyWindowInsets(r1, r2, r3, r4, null);
    }

    public static void doOnApplyWindowInsets(View r2, AttributeSet r3, int r4, int r5, final OnApplyWindowInsetsListener r6) {
        TypedArray r7 = r2.getContext().obtainStyledAttributes(r3, R.styleable.Insets, r4, r5);
        final boolean r8 = r7.getBoolean(R.styleable.Insets_paddingBottomSystemWindowInsets, false);
        final boolean r0 = r7.getBoolean(R.styleable.Insets_paddingLeftSystemWindowInsets, false);
        final boolean r9 = r7.getBoolean(R.styleable.Insets_paddingRightSystemWindowInsets, false);
        r7.recycle();
        doOnApplyWindowInsets(r2, new AnonymousClass2(r8, r0, r9, r6));
    }

    public static void doOnApplyWindowInsets(View r5, final OnApplyWindowInsetsListener r6) {
        final RelativePadding r0 = new RelativePadding(ViewCompat.getPaddingStart(r5), r5.getPaddingTop(), ViewCompat.getPaddingEnd(r5), r5.getPaddingBottom());
        ViewCompat.setOnApplyWindowInsetsListener(r5, new AnonymousClass3(r6, r0));
        requestApplyInsetsWhenAttached(r5);
    }

    public static void requestApplyInsetsWhenAttached(View r1) {
        if (ViewCompat.isAttachedToWindow(r1) == false) goto L5;
        ViewCompat.requestApplyInsets(r1);
        return;
    L5:
        r1.addOnAttachStateChangeListener(new AnonymousClass4());
    }

    public static float getParentAbsoluteElevation(View r2) {
        ViewParent r3 = r2.getParent();
        float r0 = 0.0f;
    L4:
        if ((r3 instanceof View) == false) goto L6;
        r0 = r0 + ViewCompat.getElevation((View) r3);
        r3 = r3.getParent();
        goto L4
    L6:
        return r0;
    }

    public static ViewOverlayImpl getOverlay(View r1) {
        if (r1 != null) goto L6;
        return null;
    L6:
        return new ViewOverlayApi18(r1);
    }

    public static ViewGroup getContentView(View r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        View r1 = r3.getRootView();
        ViewGroup r2 = (ViewGroup) r1.findViewById(android.R.id.content);
        if (r2 == null) goto L8;
        return r2;
    L8:
        if (r1 != r3) goto L10;
    L13:
        return null;
    L10:
        if ((r1 instanceof ViewGroup) == false) goto L13;
        return (ViewGroup) r1;
    }

    public static ViewOverlayImpl getContentViewOverlay(View r0) {
        return getOverlay(getContentView(r0));
    }

    public static void addOnGlobalLayoutListener(View r0, ViewTreeObserver.OnGlobalLayoutListener r1) {
        if (r0 == null) goto L5;
        r0.getViewTreeObserver().addOnGlobalLayoutListener(r1);
        return;
    }

    public static void removeOnGlobalLayoutListener(View r0, ViewTreeObserver.OnGlobalLayoutListener r1) {
        if (r0 == null) goto L5;
        removeOnGlobalLayoutListener(r0.getViewTreeObserver(), r1);
        return;
    }

    public static void removeOnGlobalLayoutListener(ViewTreeObserver r0, ViewTreeObserver.OnGlobalLayoutListener r1) {
        r0.removeOnGlobalLayoutListener(r1);
    }

    public static Integer getBackgroundColor(View r1) {
        if ((r1.getBackground() instanceof ColorDrawable) == true) goto L7;
        return null;
    L7:
        return Integer.valueOf(((ColorDrawable) r1.getBackground()).getColor());
    }
}
