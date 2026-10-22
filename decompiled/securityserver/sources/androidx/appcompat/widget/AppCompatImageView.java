package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.TintableBackgroundView;
import androidx.core.widget.TintableImageSourceView;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatImageView extends ImageView implements TintableBackgroundView, TintableImageSourceView {
    private final AppCompatBackgroundHelper mBackgroundTintHelper;
    private final AppCompatImageHelper mImageHelper;

    public AppCompatImageView(@NonNull Context r2) {
        this(r2, null);
    }

    @Override // android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        AppCompatBackgroundHelper r0 = this.mBackgroundTintHelper;
        if (r0 == null) goto L5;
        r0.applySupportBackgroundTint();
    L5:
        AppCompatImageHelper r1 = this.mImageHelper;
        if (r1 == null) goto L9;
        r1.applySupportImageTint();
        return;
    }

    @Override // androidx.core.view.TintableBackgroundView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public ColorStateList getSupportBackgroundTintList() {
        AppCompatBackgroundHelper r0 = this.mBackgroundTintHelper;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getSupportBackgroundTintList();
    }

    @Override // androidx.core.view.TintableBackgroundView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        AppCompatBackgroundHelper r0 = this.mBackgroundTintHelper;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getSupportBackgroundTintMode();
    }

    @Override // androidx.core.widget.TintableImageSourceView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public ColorStateList getSupportImageTintList() {
        AppCompatImageHelper r0 = this.mImageHelper;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getSupportImageTintList();
    }

    @Override // androidx.core.widget.TintableImageSourceView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PorterDuff.Mode getSupportImageTintMode() {
        AppCompatImageHelper r0 = this.mImageHelper;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getSupportImageTintMode();
    }

    @Override // android.widget.ImageView, android.view.View
    public boolean hasOverlappingRendering() {
        if (this.mImageHelper.hasOverlappingRendering() == true) goto L5;
    L7:
        return false;
    L5:
        if (super.hasOverlappingRendering() == false) goto L7;
        return true;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable r1) {
        super.setBackgroundDrawable(r1);
        AppCompatBackgroundHelper r0 = this.mBackgroundTintHelper;
        if (r0 == null) goto L6;
        r0.onSetBackgroundDrawable(r1);
        return;
    }

    @Override // android.view.View
    public void setBackgroundResource(@DrawableRes int r1) {
        super.setBackgroundResource(r1);
        AppCompatBackgroundHelper r0 = this.mBackgroundTintHelper;
        if (r0 == null) goto L6;
        r0.onSetBackgroundResource(r1);
        return;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap r1) {
        super.setImageBitmap(r1);
        AppCompatImageHelper r0 = this.mImageHelper;
        if (r0 == null) goto L6;
        r0.applySupportImageTint();
        return;
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(@Nullable Drawable r1) {
        super.setImageDrawable(r1);
        AppCompatImageHelper r0 = this.mImageHelper;
        if (r0 == null) goto L6;
        r0.applySupportImageTint();
        return;
    }

    @Override // android.widget.ImageView
    public void setImageResource(@DrawableRes int r1) {
        AppCompatImageHelper r0 = this.mImageHelper;
        if (r0 == null) goto L6;
        r0.setImageResource(r1);
        return;
    }

    @Override // android.widget.ImageView
    public void setImageURI(@Nullable Uri r1) {
        super.setImageURI(r1);
        AppCompatImageHelper r0 = this.mImageHelper;
        if (r0 == null) goto L6;
        r0.applySupportImageTint();
        return;
    }

    @Override // androidx.core.view.TintableBackgroundView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportBackgroundTintList(@Nullable ColorStateList r1) {
        AppCompatBackgroundHelper r0 = this.mBackgroundTintHelper;
        if (r0 == null) goto L6;
        r0.setSupportBackgroundTintList(r1);
        return;
    }

    @Override // androidx.core.view.TintableBackgroundView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode r1) {
        AppCompatBackgroundHelper r0 = this.mBackgroundTintHelper;
        if (r0 == null) goto L6;
        r0.setSupportBackgroundTintMode(r1);
        return;
    }

    @Override // androidx.core.widget.TintableImageSourceView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportImageTintList(@Nullable ColorStateList r1) {
        AppCompatImageHelper r0 = this.mImageHelper;
        if (r0 == null) goto L6;
        r0.setSupportImageTintList(r1);
        return;
    }

    @Override // androidx.core.widget.TintableImageSourceView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportImageTintMode(@Nullable PorterDuff.Mode r1) {
        AppCompatImageHelper r0 = this.mImageHelper;
        if (r0 == null) goto L6;
        r0.setSupportImageTintMode(r1);
        return;
    }

    public AppCompatImageView(@NonNull Context r2, @Nullable AttributeSet r3) {
        this(r2, r3, 0);
    }

    public AppCompatImageView(@NonNull Context r1, @Nullable AttributeSet r2, int r3) {
        super(TintContextWrapper.wrap(r1), r2, r3);
        ThemeUtils.checkAppCompatTheme(this, getContext());
        AppCompatBackgroundHelper r4 = new AppCompatBackgroundHelper(this);
        this.mBackgroundTintHelper = r4;
        r4.loadFromAttributes(r2, r3);
        AppCompatImageHelper r5 = new AppCompatImageHelper(this);
        this.mImageHelper = r5;
        r5.loadFromAttributes(r2, r3);
    }
}
