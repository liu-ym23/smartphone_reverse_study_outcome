package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CheckedTextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.CheckedTextViewCompat;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
class AppCompatCheckedTextViewHelper {
    private ColorStateList mCheckMarkTintList;
    private PorterDuff.Mode mCheckMarkTintMode;
    private boolean mHasCheckMarkTint;
    private boolean mHasCheckMarkTintMode;
    private boolean mSkipNextApply;

    @NonNull
    private final CheckedTextView mView;

    AppCompatCheckedTextViewHelper(@NonNull CheckedTextView r2) {
        this.mCheckMarkTintList = null;
        this.mCheckMarkTintMode = null;
        this.mHasCheckMarkTint = false;
        this.mHasCheckMarkTintMode = false;
        this.mView = r2;
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

    ColorStateList getSupportCheckMarkTintList() {
        return this.mCheckMarkTintList;
    }

    PorterDuff.Mode getSupportCheckMarkTintMode() {
        return this.mCheckMarkTintMode;
    }

    void loadFromAttributes(@Nullable AttributeSet r10, int r11) {
        Context r0 = this.mView.getContext();
        int[] r3 = R.styleable.CheckedTextView;
        TintTypedArray r1 = TintTypedArray.obtainStyledAttributes(r0, r10, r3, r11, 0);
        CheckedTextView r2 = this.mView;
        ViewCompat.saveAttributeDataForStyleable(r2, r2.getContext(), r3, r10, r1.getWrappedTypeArray(), r11, 0);
        int r12 = R.styleable.CheckedTextView_checkMarkCompat;     // Catch: Throwable -> L24
        if (r1.hasValue(r12) == false) goto L9;
        int r13 = r1.getResourceId(r12, 0);     // Catch: Throwable -> L24
        if (r13 == 0) goto L9;
        CheckedTextView r14 = this.mView;     // Catch: Resources.NotFoundException -> L27 Throwable -> L24
        r14.setCheckMarkDrawable(AppCompatResources.getDrawable(r14.getContext(), r13));     // Catch: Resources.NotFoundException -> L27 Throwable -> L24
        boolean r15 = true;
    L10:
        if (r15 == true) goto L16;
        int r16 = R.styleable.CheckedTextView_android_checkMark;     // Catch: Throwable -> L24
        if (r1.hasValue(r16) == false) goto L16;
        int r17 = r1.getResourceId(r16, 0);     // Catch: Throwable -> L24
        if (r17 == 0) goto L16;
        CheckedTextView r18 = this.mView;     // Catch: Throwable -> L24
        r18.setCheckMarkDrawable(AppCompatResources.getDrawable(r18.getContext(), r17));     // Catch: Throwable -> L24
    L16:
        int r19 = R.styleable.CheckedTextView_checkMarkTint;     // Catch: Throwable -> L24
        if (r1.hasValue(r19) == false) goto L19;
        CheckedTextViewCompat.setCheckMarkTintList(this.mView, r1.getColorStateList(r19));     // Catch: Throwable -> L24
    L19:
        int r110 = R.styleable.CheckedTextView_checkMarkTintMode;     // Catch: Throwable -> L24
        if (r1.hasValue(r110) == false) goto L22;
        CheckedTextViewCompat.setCheckMarkTintMode(this.mView, DrawableUtils.parseTintMode(r1.getInt(r110, -1), null));     // Catch: Throwable -> L24
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

    void onSetCheckMarkDrawable() {
        if (this.mSkipNextApply == false) goto L6;
        this.mSkipNextApply = false;
        return;
    L6:
        this.mSkipNextApply = true;
        applyCheckMarkTint();
    }

    void setSupportCheckMarkTintList(ColorStateList r1) {
        this.mCheckMarkTintList = r1;
        this.mHasCheckMarkTint = true;
        applyCheckMarkTint();
    }

    void setSupportCheckMarkTintMode(@Nullable PorterDuff.Mode r1) {
        this.mCheckMarkTintMode = r1;
        this.mHasCheckMarkTintMode = true;
        applyCheckMarkTint();
    }
}
