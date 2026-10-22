package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.ViewCompat;
import androidx.core.widget.ImageViewCompat;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class AppCompatImageHelper {
    private TintInfo mImageTint;
    private TintInfo mInternalImageTint;
    private TintInfo mTmpInfo;

    @NonNull
    private final ImageView mView;

    public AppCompatImageHelper(@NonNull ImageView r1) {
        this.mView = r1;
    }

    private boolean applyFrameworkTintUsingColorFilter(@NonNull Drawable r4) {
        if (this.mTmpInfo != null) goto L5;
        this.mTmpInfo = new TintInfo();
    L5:
        TintInfo r0 = this.mTmpInfo;
        r0.clear();
        ColorStateList r1 = ImageViewCompat.getImageTintList(this.mView);
        if (r1 == null) goto L8;
        r0.mHasTintList = true;
        r0.mTintList = r1;
    L8:
        PorterDuff.Mode r2 = ImageViewCompat.getImageTintMode(this.mView);
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
        if (this.mInternalImageTint == null) goto L5;
        return true;
    L5:
        return false;
    }

    public void applySupportImageTint() {
        Drawable r0 = this.mView.getDrawable();
        if (r0 == null) goto L5;
        DrawableUtils.fixDrawable(r0);
    L5:
        if (r0 != null) goto L7;
        return;
    L7:
        if (shouldApplyFrameworkTintUsingColorFilter() == true) goto L9;
    L11:
        TintInfo r1 = this.mImageTint;
        if (r1 == null) goto L14;
        AppCompatDrawableManager.tintDrawable(r0, r1, this.mView.getDrawableState());
        return;
    L14:
        TintInfo r2 = this.mInternalImageTint;
        if (r2 == null) goto L20;
        AppCompatDrawableManager.tintDrawable(r0, r2, this.mView.getDrawableState());
        return;
    L20:
        return;
    L9:
        if (applyFrameworkTintUsingColorFilter(r0) == false) goto L11;
    }

    public ColorStateList getSupportImageTintList() {
        TintInfo r0 = this.mImageTint;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.mTintList;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        TintInfo r0 = this.mImageTint;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.mTintMode;
    }

    public boolean hasOverlappingRendering() {
        if ((this.mView.getBackground() instanceof RippleDrawable) == false) goto L6;
        return false;
    L6:
        return true;
    }

    public void loadFromAttributes(AttributeSet r9, int r10) {
        TintTypedArray r0 = TintTypedArray.obtainStyledAttributes(this.mView.getContext(), r9, R.styleable.AppCompatImageView, r10, 0);
        ImageView r1 = this.mView;
        ViewCompat.saveAttributeDataForStyleable(r1, r1.getContext(), R.styleable.AppCompatImageView, r9, r0.getWrappedTypeArray(), r10, 0);
        Drawable r11 = this.mView.getDrawable();     // Catch: Throwable -> L10
        if (r11 != null) goto L12;
        int r2 = r0.getResourceId(R.styleable.AppCompatImageView_srcCompat, -1);     // Catch: Throwable -> L10
        if (r2 == (-1)) goto L12;
        r11 = AppCompatResources.getDrawable(this.mView.getContext(), r2);     // Catch: Throwable -> L10
        if (r11 == null) goto L12;
        this.mView.setImageDrawable(r11);     // Catch: Throwable -> L10
    L12:
        if (r11 == null) goto L15;
        DrawableUtils.fixDrawable(r11);     // Catch: Throwable -> L10
    L15:
        if (r0.hasValue(R.styleable.AppCompatImageView_tint) == false) goto L18;
        ImageViewCompat.setImageTintList(this.mView, r0.getColorStateList(R.styleable.AppCompatImageView_tint));     // Catch: Throwable -> L10
    L18:
        if (r0.hasValue(R.styleable.AppCompatImageView_tintMode) == false) goto L20;
        ImageViewCompat.setImageTintMode(this.mView, DrawableUtils.parseTintMode(r0.getInt(R.styleable.AppCompatImageView_tintMode, -1), null));     // Catch: Throwable -> L10
    L20:
        r0.recycle();
        return;
    L10:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    public void setImageResource(int r2) {
        if (r2 == 0) goto L7;
        Drawable r3 = AppCompatResources.getDrawable(this.mView.getContext(), r2);
        if (r3 == null) goto L6;
        DrawableUtils.fixDrawable(r3);
    L6:
        this.mView.setImageDrawable(r3);
    L8:
        applySupportImageTint();
        return;
    L7:
        this.mView.setImageDrawable(null);
        goto L8
    }

    public void setInternalImageTint(ColorStateList r2) {
        if (r2 != null) goto L4;
        this.mInternalImageTint = null;
    L8:
        applySupportImageTint();
        return;
    L4:
        if (this.mInternalImageTint != null) goto L6;
        this.mInternalImageTint = new TintInfo();
    L6:
        TintInfo r0 = this.mInternalImageTint;
        r0.mTintList = r2;
        r0.mHasTintList = true;
        goto L8
    }

    public void setSupportImageTintList(ColorStateList r2) {
        if (this.mImageTint != null) goto L5;
        this.mImageTint = new TintInfo();
    L5:
        TintInfo r0 = this.mImageTint;
        r0.mTintList = r2;
        r0.mHasTintList = true;
        applySupportImageTint();
    }

    public void setSupportImageTintMode(PorterDuff.Mode r2) {
        if (this.mImageTint != null) goto L5;
        this.mImageTint = new TintInfo();
    L5:
        TintInfo r0 = this.mImageTint;
        r0.mTintMode = r2;
        r0.mHasTintMode = true;
        applySupportImageTint();
    }
}
