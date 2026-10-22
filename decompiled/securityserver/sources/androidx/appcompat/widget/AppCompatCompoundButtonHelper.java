package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
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

    public AppCompatCompoundButtonHelper(@NonNull CompoundButton r2) {
        this.mButtonTintList = null;
        this.mButtonTintMode = null;
        this.mHasButtonTint = false;
        this.mHasButtonTintMode = false;
        this.mView = r2;
    }

    public void applyButtonTint() {
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

    public int getCompoundPaddingLeft(int r1) {
        return r1;
    }

    public ColorStateList getSupportButtonTintList() {
        return this.mButtonTintList;
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        return this.mButtonTintMode;
    }

    public void loadFromAttributes(@Nullable AttributeSet r11, int r12) {
        TintTypedArray r0 = TintTypedArray.obtainStyledAttributes(this.mView.getContext(), r11, R.styleable.CompoundButton, r12, 0);
        CompoundButton r3 = this.mView;
        ViewCompat.saveAttributeDataForStyleable(r3, r3.getContext(), R.styleable.CompoundButton, r11, r0.getWrappedTypeArray(), r12, 0);
    L9:
        th = move-exception;
        r0.recycle();
        throw th;
    L4:
        if (r0.hasValue(R.styleable.CompoundButton_buttonCompat) == false) goto L12;
        int r13 = r0.getResourceId(R.styleable.CompoundButton_buttonCompat, 0);     // Catch: Throwable -> L9
        if (r13 == 0) goto L12;
        CompoundButton r14 = this.mView;     // Catch: Throwable -> L9 Resources.NotFoundException -> L26
        r14.setButtonDrawable(AppCompatResources.getDrawable(r14.getContext(), r13));     // Catch: Throwable -> L9 Resources.NotFoundException -> L26
    L17:
        if (r0.hasValue(R.styleable.CompoundButton_buttonTint) == false) goto L20;
        CompoundButtonCompat.setButtonTintList(this.mView, r0.getColorStateList(R.styleable.CompoundButton_buttonTint));     // Catch: Throwable -> L9
    L20:
        if (r0.hasValue(R.styleable.CompoundButton_buttonTintMode) == false) goto L22;
        CompoundButtonCompat.setButtonTintMode(this.mView, DrawableUtils.parseTintMode(r0.getInt(R.styleable.CompoundButton_buttonTintMode, -1), null));     // Catch: Throwable -> L9
    L22:
        r0.recycle();
        return;
    L12:
        if (r0.hasValue(R.styleable.CompoundButton_android_button) == false) goto L17;
        int r15 = r0.getResourceId(R.styleable.CompoundButton_android_button, 0);     // Catch: Throwable -> L9
        if (r15 == 0) goto L17;
        CompoundButton r16 = this.mView;     // Catch: Throwable -> L9
        r16.setButtonDrawable(AppCompatResources.getDrawable(r16.getContext(), r15));     // Catch: Throwable -> L9
        goto L17
    }

    public void onSetButtonDrawable() {
        if (this.mSkipNextApply == false) goto L6;
        this.mSkipNextApply = false;
        return;
    L6:
        this.mSkipNextApply = true;
        applyButtonTint();
    }

    public void setSupportButtonTintList(ColorStateList r1) {
        this.mButtonTintList = r1;
        this.mHasButtonTint = true;
        applyButtonTint();
    }

    public void setSupportButtonTintMode(@Nullable PorterDuff.Mode r1) {
        this.mButtonTintMode = r1;
        this.mHasButtonTintMode = true;
        applyButtonTint();
    }
}
