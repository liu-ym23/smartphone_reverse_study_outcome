package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
final class WrappedDrawableState extends Drawable.ConstantState {
    int mChangingConfigurations;
    Drawable.ConstantState mDrawableState;
    ColorStateList mTint;
    PorterDuff.Mode mTintMode;

    public WrappedDrawableState(@Nullable WrappedDrawableState r2) {
        this.mTint = null;
        this.mTintMode = WrappedDrawableApi14.DEFAULT_TINT_MODE;
        if (r2 == null) goto L6;
        this.mChangingConfigurations = r2.mChangingConfigurations;
        this.mDrawableState = r2.mDrawableState;
        this.mTint = r2.mTint;
        this.mTintMode = r2.mTintMode;
        return;
    }

    public boolean canConstantState() {
        if (this.mDrawableState == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public int getChangingConfigurations() {
        int r0 = this.mChangingConfigurations;
        Drawable.ConstantState r1 = this.mDrawableState;
        if (r1 == null) goto L5;
        int r2 = r1.getChangingConfigurations();
    L7:
        return r2 | r0;
    L5:
        r2 = 0;
        goto L7
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    @NonNull
    public Drawable newDrawable() {
        return newDrawable(null);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    @NonNull
    public Drawable newDrawable(@Nullable Resources r2) {
        return new WrappedDrawableApi21(this, r2);
    }
}
