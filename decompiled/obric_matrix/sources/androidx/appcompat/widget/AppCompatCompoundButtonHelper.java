package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.CompoundButtonCompat;

/* JADX INFO: loaded from: classes.dex */
class AppCompatCompoundButtonHelper {
    private ColorStateList mButtonTintList;
    private PorterDuff.Mode mButtonTintMode;
    private boolean mHasButtonTint;
    private boolean mHasButtonTintMode;
    private boolean mSkipNextApply;

    @NonNull
    private final CompoundButton mView;

    AppCompatCompoundButtonHelper(@NonNull CompoundButton r2) {
        this.mButtonTintList = null;
        this.mButtonTintMode = null;
        this.mHasButtonTint = false;
        this.mHasButtonTintMode = false;
        this.mView = r2;
    }

    void applyButtonTint() {
        Drawable r0 = CompoundButtonCompat.getButtonDrawable(this.mView);
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.mHasButtonTint == false) goto L7;
    L8:
        Drawable r1 = DrawableCompat.wrap(r0).mutate();
        if (this.mHasButtonTint == false) goto L12;
        DrawableCompat.setTintList(r1, this.mButtonTintList);
    L12:
        if (this.mHasButtonTintMode == false) goto L15;
        DrawableCompat.setTintMode(r1, this.mButtonTintMode);
    L15:
        if (r1.isStateful() == false) goto L17;
        r1.setState(this.mView.getDrawableState());
    L17:
        this.mView.setButtonDrawable(r1);
        return;
    L7:
        if (this.mHasButtonTintMode == true) goto L8;
    }

    int getCompoundPaddingLeft(int r3) {
        if (Build.VERSION.SDK_INT >= 17) goto L8;
        Drawable r2 = CompoundButtonCompat.getButtonDrawable(this.mView);
        if (r2 != null) goto L7;
        return r3;
    L7:
        return r3 + r2.getIntrinsicWidth();
    L8:
        return r3;
    }

    ColorStateList getSupportButtonTintList() {
        return this.mButtonTintList;
    }

    PorterDuff.Mode getSupportButtonTintMode() {
        return this.mButtonTintMode;
    }

    void loadFromAttributes(@Nullable AttributeSet r10, int r11) {
        Context r0 = this.mView.getContext();
        int[] r3 = R.styleable.CompoundButton;
        TintTypedArray r1 = TintTypedArray.obtainStyledAttributes(r0, r10, r3, r11, 0);
        CompoundButton r2 = this.mView;
        ViewCompat.saveAttributeDataForStyleable(r2, r2.getContext(), r3, r10, r1.getWrappedTypeArray(), r11, 0);
        int r12 = R.styleable.CompoundButton_buttonCompat;     // Catch: Throwable -> L24
        if (r1.hasValue(r12) == false) goto L9;
        int r13 = r1.getResourceId(r12, 0);     // Catch: Throwable -> L24
        if (r13 == 0) goto L9;
        CompoundButton r14 = this.mView;     // Catch: Resources.NotFoundException -> L27 Throwable -> L24
        r14.setButtonDrawable(AppCompatResources.getDrawable(r14.getContext(), r13));     // Catch: Resources.NotFoundException -> L27 Throwable -> L24
        boolean r15 = true;
    L10:
        if (r15 == true) goto L16;
        int r16 = R.styleable.CompoundButton_android_button;     // Catch: Throwable -> L24
        if (r1.hasValue(r16) == false) goto L16;
        int r17 = r1.getResourceId(r16, 0);     // Catch: Throwable -> L24
        if (r17 == 0) goto L16;
        CompoundButton r18 = this.mView;     // Catch: Throwable -> L24
        r18.setButtonDrawable(AppCompatResources.getDrawable(r18.getContext(), r17));     // Catch: Throwable -> L24
    L16:
        int r19 = R.styleable.CompoundButton_buttonTint;     // Catch: Throwable -> L24
        if (r1.hasValue(r19) == false) goto L19;
        CompoundButtonCompat.setButtonTintList(this.mView, r1.getColorStateList(r19));     // Catch: Throwable -> L24
    L19:
        int r110 = R.styleable.CompoundButton_buttonTintMode;     // Catch: Throwable -> L24
        if (r1.hasValue(r110) == false) goto L22;
        CompoundButtonCompat.setButtonTintMode(this.mView, DrawableUtils.parseTintMode(r1.getInt(r110, -1), null));     // Catch: Throwable -> L24
    L22:
        r1.recycle();
        return;
    L9:
        r15 = false;
    L24:
        th = move-exception;
        r1.recycle();
        throw th;
    }

    void onSetButtonDrawable() {
        if (this.mSkipNextApply == false) goto L6;
        this.mSkipNextApply = false;
        return;
    L6:
        this.mSkipNextApply = true;
        applyButtonTint();
    }

    void setSupportButtonTintList(ColorStateList r1) {
        this.mButtonTintList = r1;
        this.mHasButtonTint = true;
        applyButtonTint();
    }

    void setSupportButtonTintMode(@Nullable PorterDuff.Mode r1) {
        this.mButtonTintMode = r1;
        this.mHasButtonTintMode = true;
        applyButtonTint();
    }
}
