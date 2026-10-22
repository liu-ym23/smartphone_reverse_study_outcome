package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
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

    public AppCompatBackgroundHelper(@NonNull View r2) {
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
        if (this.mInternalBackgroundTint == null) goto L5;
        return true;
    L5:
        return false;
    }

    public void applySupportBackgroundTint() {
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

    public ColorStateList getSupportBackgroundTintList() {
        TintInfo r0 = this.mBackgroundTint;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.mTintList;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        TintInfo r0 = this.mBackgroundTint;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.mTintMode;
    }

    public void loadFromAttributes(@Nullable AttributeSet r9, int r10) {
        TintTypedArray r0 = TintTypedArray.obtainStyledAttributes(this.mView.getContext(), r9, R.styleable.ViewBackgroundHelper, r10, 0);
        View r1 = this.mView;
        ViewCompat.saveAttributeDataForStyleable(r1, r1.getContext(), R.styleable.ViewBackgroundHelper, r9, r0.getWrappedTypeArray(), r10, 0);
    L8:
        th = move-exception;
        r0.recycle();
        throw th;
    L4:
        if (r0.hasValue(R.styleable.ViewBackgroundHelper_android_background) == false) goto L11;
        this.mBackgroundResId = r0.getResourceId(R.styleable.ViewBackgroundHelper_android_background, -1);     // Catch: Throwable -> L8
        ColorStateList r11 = this.mDrawableManager.getTintList(this.mView.getContext(), this.mBackgroundResId);     // Catch: Throwable -> L8
        if (r11 == null) goto L11;
        setInternalBackgroundTint(r11);     // Catch: Throwable -> L8
    L11:
        if (r0.hasValue(R.styleable.ViewBackgroundHelper_backgroundTint) == false) goto L14;
        ViewCompat.setBackgroundTintList(this.mView, r0.getColorStateList(R.styleable.ViewBackgroundHelper_backgroundTint));     // Catch: Throwable -> L8
    L14:
        if (r0.hasValue(R.styleable.ViewBackgroundHelper_backgroundTintMode) == false) goto L16;
        ViewCompat.setBackgroundTintMode(this.mView, DrawableUtils.parseTintMode(r0.getInt(R.styleable.ViewBackgroundHelper_backgroundTintMode, -1), null));     // Catch: Throwable -> L8
    L16:
        r0.recycle();
    }

    public void onSetBackgroundDrawable(Drawable r1) {
        this.mBackgroundResId = -1;
        setInternalBackgroundTint(null);
        applySupportBackgroundTint();
    }

    public void onSetBackgroundResource(int r3) {
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

    public void setInternalBackgroundTint(ColorStateList r2) {
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

    public void setSupportBackgroundTintList(ColorStateList r2) {
        if (this.mBackgroundTint != null) goto L5;
        this.mBackgroundTint = new TintInfo();
    L5:
        TintInfo r0 = this.mBackgroundTint;
        r0.mTintList = r2;
        r0.mHasTintList = true;
        applySupportBackgroundTint();
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode r2) {
        if (this.mBackgroundTint != null) goto L5;
        this.mBackgroundTint = new TintInfo();
    L5:
        TintInfo r0 = this.mBackgroundTint;
        r0.mTintMode = r2;
        r0.mHasTintMode = true;
        applySupportBackgroundTint();
    }
}
