package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes.dex */
class AppCompatBackgroundHelper {
    private int mBackgroundResId;
    private TintInfo mBackgroundTint;
    private final AppCompatDrawableManager mDrawableManager;
    private TintInfo mInternalBackgroundTint;
    private TintInfo mTmpInfo;

    @NonNull
    private final View mView;

    AppCompatBackgroundHelper(@NonNull View r2) {
        this.mBackgroundResId = -1;
        this.mView = r2;
        this.mDrawableManager = AppCompatDrawableManager.get();
    }

    private boolean applyFrameworkTintUsingColorFilter(@NonNull Drawable r4) {
        if (this.mTmpInfo != null) goto L5;
        this.mTmpInfo = new TintInfo();
    L5:
        TintInfo r0 = this.mTmpInfo;
        r0.clear();
        ColorStateList r1 = ViewCompat.getBackgroundTintList(this.mView);
        if (r1 == null) goto L8;
        r0.mHasTintList = true;
        r0.mTintList = r1;
    L8:
        PorterDuff.Mode r2 = ViewCompat.getBackgroundTintMode(this.mView);
        if (r2 == null) goto L12;
        r0.mHasTintMode = true;
        r0.mTintMode = r2;
    L12:
        if (r0.mHasTintList == false) goto L14;
    L18:
        AppCompatDrawableManager.tintDrawable(r4, r0, this.mView.getDrawableState());
        return true;
    L14:
        if (r0.mHasTintMode == true) goto L18;
        return false;
    }

    private boolean shouldApplyFrameworkTintUsingColorFilter() {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 > 21) goto L5;
        if (r0 != 21) goto L11;
        return true;
    L11:
        return false;
    L5:
        if (this.mInternalBackgroundTint == null) goto L8;
        return true;
    L8:
        return false;
    }

    void applySupportBackgroundTint() {
        Drawable r0 = this.mView.getBackground();
        if (r0 != null) goto L5;
        return;
    L5:
        if (shouldApplyFrameworkTintUsingColorFilter() == true) goto L7;
    L9:
        TintInfo r1 = this.mBackgroundTint;
        if (r1 == null) goto L12;
        AppCompatDrawableManager.tintDrawable(r0, r1, this.mView.getDrawableState());
        return;
    L12:
        TintInfo r2 = this.mInternalBackgroundTint;
        if (r2 == null) goto L18;
        AppCompatDrawableManager.tintDrawable(r0, r2, this.mView.getDrawableState());
        return;
    L18:
        return;
    L7:
        if (applyFrameworkTintUsingColorFilter(r0) == false) goto L9;
    }

    ColorStateList getSupportBackgroundTintList() {
        TintInfo r0 = this.mBackgroundTint;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.mTintList;
    }

    PorterDuff.Mode getSupportBackgroundTintMode() {
        TintInfo r0 = this.mBackgroundTint;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.mTintMode;
    }

    void loadFromAttributes(@Nullable AttributeSet r9, int r10) {
        Context r0 = this.mView.getContext();
        int[] r3 = R.styleable.ViewBackgroundHelper;
        TintTypedArray r1 = TintTypedArray.obtainStyledAttributes(r0, r9, r3, r10, 0);
        View r2 = this.mView;
        ViewCompat.saveAttributeDataForStyleable(r2, r2.getContext(), r3, r9, r1.getWrappedTypeArray(), r10, 0);
        int r11 = R.styleable.ViewBackgroundHelper_android_background;     // Catch: Throwable -> L16
        if (r1.hasValue(r11) == false) goto L8;
        this.mBackgroundResId = r1.getResourceId(r11, -1);     // Catch: Throwable -> L16
        ColorStateList r12 = this.mDrawableManager.getTintList(this.mView.getContext(), this.mBackgroundResId);     // Catch: Throwable -> L16
        if (r12 == null) goto L8;
        setInternalBackgroundTint(r12);     // Catch: Throwable -> L16
    L8:
        int r13 = R.styleable.ViewBackgroundHelper_backgroundTint;     // Catch: Throwable -> L16
        if (r1.hasValue(r13) == false) goto L11;
        ViewCompat.setBackgroundTintList(this.mView, r1.getColorStateList(r13));     // Catch: Throwable -> L16
    L11:
        int r14 = R.styleable.ViewBackgroundHelper_backgroundTintMode;     // Catch: Throwable -> L16
        if (r1.hasValue(r14) == false) goto L14;
        ViewCompat.setBackgroundTintMode(this.mView, DrawableUtils.parseTintMode(r1.getInt(r14, -1), null));     // Catch: Throwable -> L16
    L14:
        r1.recycle();
        return;
    L16:
        th = move-exception;
        r1.recycle();
        throw th;
    }

    void onSetBackgroundDrawable(Drawable r1) {
        this.mBackgroundResId = -1;
        setInternalBackgroundTint(null);
        applySupportBackgroundTint();
    }

    void onSetBackgroundResource(int r3) {
        this.mBackgroundResId = r3;
        AppCompatDrawableManager r0 = this.mDrawableManager;
        if (r0 == null) goto L5;
        ColorStateList r4 = r0.getTintList(this.mView.getContext(), r3);
    L6:
        setInternalBackgroundTint(r4);
        applySupportBackgroundTint();
        return;
    L5:
        r4 = null;
        goto L6
    }

    void setInternalBackgroundTint(ColorStateList r2) {
        if (r2 != null) goto L4;
        this.mInternalBackgroundTint = null;
    L8:
        applySupportBackgroundTint();
        return;
    L4:
        if (this.mInternalBackgroundTint != null) goto L6;
        this.mInternalBackgroundTint = new TintInfo();
    L6:
        TintInfo r0 = this.mInternalBackgroundTint;
        r0.mTintList = r2;
        r0.mHasTintList = true;
        goto L8
    }

    void setSupportBackgroundTintList(ColorStateList r2) {
        if (this.mBackgroundTint != null) goto L5;
        this.mBackgroundTint = new TintInfo();
    L5:
        TintInfo r0 = this.mBackgroundTint;
        r0.mTintList = r2;
        r0.mHasTintList = true;
        applySupportBackgroundTint();
    }

    void setSupportBackgroundTintMode(PorterDuff.Mode r2) {
        if (this.mBackgroundTint != null) goto L5;
        this.mBackgroundTint = new TintInfo();
    L5:
        TintInfo r0 = this.mBackgroundTint;
        r0.mTintMode = r2;
        r0.mHasTintMode = true;
        applySupportBackgroundTint();
    }
}
