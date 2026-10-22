package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CheckedTextView;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.CheckedTextViewCompat;

/* JADX INFO: loaded from: classes.dex */
class AppCompatCheckedTextViewHelper {
    private ColorStateList mCheckMarkTintList;
    private PorterDuff.Mode mCheckMarkTintMode;
    private boolean mHasCheckMarkTint;
    private boolean mHasCheckMarkTintMode;
    private boolean mSkipNextApply;
    private final CheckedTextView mView;

    AppCompatCheckedTextViewHelper(CheckedTextView r2) {
        this.mCheckMarkTintList = null;
        this.mCheckMarkTintMode = null;
        this.mHasCheckMarkTint = false;
        this.mHasCheckMarkTintMode = false;
        this.mView = r2;
    }

    void loadFromAttributes(AttributeSet r11, int r12) {
        TintTypedArray r0 = TintTypedArray.obtainStyledAttributes(this.mView.getContext(), r11, R.styleable.CheckedTextView, r12, 0);
        CheckedTextView r3 = this.mView;
        ViewCompat.saveAttributeDataForStyleable(r3, r3.getContext(), R.styleable.CheckedTextView, r11, r0.getWrappedTypeArray(), r12, 0);
    L24:
        th = move-exception;
        r0.recycle();
        throw th;
    L4:
        if (r0.hasValue(R.styleable.CheckedTextView_checkMarkCompat) == false) goto L9;
        int r13 = r0.getResourceId(R.styleable.CheckedTextView_checkMarkCompat, 0);     // Catch: Throwable -> L24
        if (r13 == 0) goto L9;
        CheckedTextView r14 = this.mView;     // Catch: Resources.NotFoundException -> L27 Throwable -> L24
        r14.setCheckMarkDrawable(AppCompatResources.getDrawable(r14.getContext(), r13));     // Catch: Resources.NotFoundException -> L27 Throwable -> L24
        boolean r15 = true;
    L10:
        if (r15 == true) goto L17;
        if (r0.hasValue(R.styleable.CheckedTextView_android_checkMark) == false) goto L17;
        int r16 = r0.getResourceId(R.styleable.CheckedTextView_android_checkMark, 0);     // Catch: Throwable -> L24
        if (r16 == 0) goto L17;
        CheckedTextView r17 = this.mView;     // Catch: Throwable -> L24
        r17.setCheckMarkDrawable(AppCompatResources.getDrawable(r17.getContext(), r16));     // Catch: Throwable -> L24
    L17:
        if (r0.hasValue(R.styleable.CheckedTextView_checkMarkTint) == false) goto L20;
        CheckedTextViewCompat.setCheckMarkTintList(this.mView, r0.getColorStateList(R.styleable.CheckedTextView_checkMarkTint));     // Catch: Throwable -> L24
    L20:
        if (r0.hasValue(R.styleable.CheckedTextView_checkMarkTintMode) == false) goto L22;
        CheckedTextViewCompat.setCheckMarkTintMode(this.mView, DrawableUtils.parseTintMode(r0.getInt(R.styleable.CheckedTextView_checkMarkTintMode, -1), null));     // Catch: Throwable -> L24
    L22:
        r0.recycle();
        return;
    L9:
        r15 = false;
        goto L10
    }

    void setSupportCheckMarkTintList(ColorStateList r1) {
        this.mCheckMarkTintList = r1;
        this.mHasCheckMarkTint = true;
        applyCheckMarkTint();
    }

    ColorStateList getSupportCheckMarkTintList() {
        return this.mCheckMarkTintList;
    }

    void setSupportCheckMarkTintMode(PorterDuff.Mode r1) {
        this.mCheckMarkTintMode = r1;
        this.mHasCheckMarkTintMode = true;
        applyCheckMarkTint();
    }

    PorterDuff.Mode getSupportCheckMarkTintMode() {
        return this.mCheckMarkTintMode;
    }

    void onSetCheckMarkDrawable() {
        if (this.mSkipNextApply == false) goto L6;
        this.mSkipNextApply = false;
        return;
    L6:
        this.mSkipNextApply = true;
        applyCheckMarkTint();
    }

    void applyCheckMarkTint() {
        Drawable r0 = CheckedTextViewCompat.getCheckMarkDrawable(this.mView);
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.mHasCheckMarkTint == false) goto L7;
    L8:
        Drawable r1 = DrawableCompat.wrap(r0).mutate();
        if (this.mHasCheckMarkTint == false) goto L12;
        DrawableCompat.setTintList(r1, this.mCheckMarkTintList);
    L12:
        if (this.mHasCheckMarkTintMode == false) goto L15;
        DrawableCompat.setTintMode(r1, this.mCheckMarkTintMode);
    L15:
        if (r1.isStateful() == false) goto L17;
        r1.setState(this.mView.getDrawableState());
    L17:
        this.mView.setCheckMarkDrawable(r1);
        return;
    L7:
        if (this.mHasCheckMarkTintMode == true) goto L8;
    }
}
