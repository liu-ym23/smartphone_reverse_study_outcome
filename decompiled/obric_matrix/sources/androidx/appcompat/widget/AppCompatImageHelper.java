package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
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
    private int mLevel;
    private TintInfo mTmpInfo;

    @NonNull
    private final ImageView mView;

    public AppCompatImageHelper(@NonNull ImageView r2) {
        this.mLevel = 0;
        this.mView = r2;
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
        int r0 = Build.VERSION.SDK_INT;
        if (r0 > 21) goto L5;
        if (r0 != 21) goto L11;
        return true;
    L11:
        return false;
    L5:
        if (this.mInternalImageTint == null) goto L8;
        return true;
    L8:
        return false;
    }

    void applyImageLevel() {
        if (this.mView.getDrawable() == null) goto L6;
        this.mView.getDrawable().setLevel(this.mLevel);
        return;
    }

    void applySupportImageTint() {
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

    ColorStateList getSupportImageTintList() {
        TintInfo r0 = this.mImageTint;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.mTintList;
    }

    PorterDuff.Mode getSupportImageTintMode() {
        TintInfo r0 = this.mImageTint;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.mTintMode;
    }

    boolean hasOverlappingRendering() {
        Drawable r2 = this.mView.getBackground();
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return true;
    L5:
        if ((r2 instanceof RippleDrawable) == false) goto L10;
        return false;
    L10:
        return true;
    }

    public void loadFromAttributes(AttributeSet r9, int r10) {
        Context r0 = this.mView.getContext();
        int[] r3 = R.styleable.AppCompatImageView;
        TintTypedArray r1 = TintTypedArray.obtainStyledAttributes(r0, r9, r3, r10, 0);
        ImageView r2 = this.mView;
        ViewCompat.saveAttributeDataForStyleable(r2, r2.getContext(), r3, r9, r1.getWrappedTypeArray(), r10, 0);
        Drawable r11 = this.mView.getDrawable();     // Catch: Throwable -> L20
        if (r11 != null) goto L10;
        int r4 = r1.getResourceId(R.styleable.AppCompatImageView_srcCompat, -1);     // Catch: Throwable -> L20
        if (r4 == (-1)) goto L10;
        r11 = AppCompatResources.getDrawable(this.mView.getContext(), r4);     // Catch: Throwable -> L20
        if (r11 == null) goto L10;
        this.mView.setImageDrawable(r11);     // Catch: Throwable -> L20
    L10:
        if (r11 == null) goto L12;
        DrawableUtils.fixDrawable(r11);     // Catch: Throwable -> L20
    L12:
        int r12 = R.styleable.AppCompatImageView_tint;     // Catch: Throwable -> L20
        if (r1.hasValue(r12) == false) goto L15;
        ImageViewCompat.setImageTintList(this.mView, r1.getColorStateList(r12));     // Catch: Throwable -> L20
    L15:
        int r13 = R.styleable.AppCompatImageView_tintMode;     // Catch: Throwable -> L20
        if (r1.hasValue(r13) == false) goto L18;
        ImageViewCompat.setImageTintMode(this.mView, DrawableUtils.parseTintMode(r1.getInt(r13, -1), null));     // Catch: Throwable -> L20
    L18:
        r1.recycle();
        return;
    L20:
        th = move-exception;
        r1.recycle();
        throw th;
    }

    void obtainLevelFromDrawable(@NonNull Drawable r1) {
        this.mLevel = r1.getLevel();
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

    void setInternalImageTint(ColorStateList r2) {
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

    void setSupportImageTintList(ColorStateList r2) {
        if (this.mImageTint != null) goto L5;
        this.mImageTint = new TintInfo();
    L5:
        TintInfo r0 = this.mImageTint;
        r0.mTintList = r2;
        r0.mHasTintList = true;
        applySupportImageTint();
    }

    void setSupportImageTintMode(PorterDuff.Mode r2) {
        if (this.mImageTint != null) goto L5;
        this.mImageTint = new TintInfo();
    L5:
        TintInfo r0 = this.mImageTint;
        r0.mTintMode = r2;
        r0.mHasTintMode = true;
        applySupportImageTint();
    }
}
