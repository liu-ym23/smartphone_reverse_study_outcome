package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CompoundButton;
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
    private final CompoundButton mView;

    int getCompoundPaddingLeft(int r1) {
        return r1;
    }

    AppCompatCompoundButtonHelper(CompoundButton r2) {
        this.mButtonTintList = null;
        this.mButtonTintMode = null;
        this.mHasButtonTint = false;
        this.mHasButtonTintMode = false;
        this.mView = r2;
    }

    void loadFromAttributes(AttributeSet r11, int r12) {
        TintTypedArray r0 = TintTypedArray.obtainStyledAttributes(this.mView.getContext(), r11, R.styleable.CompoundButton, r12, 0);
        CompoundButton r3 = this.mView;
        ViewCompat.saveAttributeDataForStyleable(r3, r3.getContext(), R.styleable.CompoundButton, r11, r0.getWrappedTypeArray(), r12, 0);
    L24:
        th = move-exception;
        r0.recycle();
        throw th;
    L4:
        if (r0.hasValue(R.styleable.CompoundButton_buttonCompat) == false) goto L9;
        int r13 = r0.getResourceId(R.styleable.CompoundButton_buttonCompat, 0);     // Catch: Throwable -> L24
        if (r13 == 0) goto L9;
        CompoundButton r14 = this.mView;     // Catch: Resources.NotFoundException -> L27 Throwable -> L24
        r14.setButtonDrawable(AppCompatResources.getDrawable(r14.getContext(), r13));     // Catch: Resources.NotFoundException -> L27 Throwable -> L24
        boolean r15 = true;
    L10:
        if (r15 == true) goto L17;
        if (r0.hasValue(R.styleable.CompoundButton_android_button) == false) goto L17;
        int r16 = r0.getResourceId(R.styleable.CompoundButton_android_button, 0);     // Catch: Throwable -> L24
        if (r16 == 0) goto L17;
        CompoundButton r17 = this.mView;     // Catch: Throwable -> L24
        r17.setButtonDrawable(AppCompatResources.getDrawable(r17.getContext(), r16));     // Catch: Throwable -> L24
    L17:
        if (r0.hasValue(R.styleable.CompoundButton_buttonTint) == false) goto L20;
        CompoundButtonCompat.setButtonTintList(this.mView, r0.getColorStateList(R.styleable.CompoundButton_buttonTint));     // Catch: Throwable -> L24
    L20:
        if (r0.hasValue(R.styleable.CompoundButton_buttonTintMode) == false) goto L22;
        CompoundButtonCompat.setButtonTintMode(this.mView, DrawableUtils.parseTintMode(r0.getInt(R.styleable.CompoundButton_buttonTintMode, -1), null));     // Catch: Throwable -> L24
    L22:
        r0.recycle();
        return;
    L9:
        r15 = false;
        goto L10
    }

    void setSupportButtonTintList(ColorStateList r1) {
        this.mButtonTintList = r1;
        this.mHasButtonTint = true;
        applyButtonTint();
    }

    ColorStateList getSupportButtonTintList() {
        return this.mButtonTintList;
    }

    void setSupportButtonTintMode(PorterDuff.Mode r1) {
        this.mButtonTintMode = r1;
        this.mHasButtonTintMode = true;
        applyButtonTint();
    }

    PorterDuff.Mode getSupportButtonTintMode() {
        return this.mButtonTintMode;
    }

    void onSetButtonDrawable() {
        if (this.mSkipNextApply == false) goto L6;
        this.mSkipNextApply = false;
        return;
    L6:
        this.mSkipNextApply = true;
        applyButtonTint();
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
}
