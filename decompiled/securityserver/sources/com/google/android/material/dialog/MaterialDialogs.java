package com.google.android.material.dialog;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.google.android.material.R;
import com.google.android.material.internal.ThemeEnforcement;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class MaterialDialogs {
    private MaterialDialogs() {
    }

    @NonNull
    public static Rect getDialogBackgroundInsets(@NonNull Context r7, @AttrRes int r8, int r9) {
        TypedArray r10 = ThemeEnforcement.obtainStyledAttributes(r7, null, R.styleable.MaterialAlertDialog, r8, r9, new int[0]);
        int r11 = r10.getDimensionPixelSize(R.styleable.MaterialAlertDialog_backgroundInsetStart, r7.getResources().getDimensionPixelSize(R.dimen.mtrl_alert_dialog_background_inset_start));
        int r0 = r10.getDimensionPixelSize(R.styleable.MaterialAlertDialog_backgroundInsetTop, r7.getResources().getDimensionPixelSize(R.dimen.mtrl_alert_dialog_background_inset_top));
        int r1 = r10.getDimensionPixelSize(R.styleable.MaterialAlertDialog_backgroundInsetEnd, r7.getResources().getDimensionPixelSize(R.dimen.mtrl_alert_dialog_background_inset_end));
        int r2 = r10.getDimensionPixelSize(R.styleable.MaterialAlertDialog_backgroundInsetBottom, r7.getResources().getDimensionPixelSize(R.dimen.mtrl_alert_dialog_background_inset_bottom));
        r10.recycle();
        if (r7.getResources().getConfiguration().getLayoutDirection() != 1) goto L6;
        r1 = r11;
        r11 = r1;
    L6:
        return new Rect(r11, r0, r1, r2);
    }

    @NonNull
    public static InsetDrawable insetDrawable(@Nullable Drawable r7, @NonNull Rect r8) {
        return new InsetDrawable(r7, r8.left, r8.top, r8.right, r8.bottom);
    }
}
