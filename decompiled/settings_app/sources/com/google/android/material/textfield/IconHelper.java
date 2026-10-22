package com.google.android.material.textfield;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.internal.CheckableImageButton;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
class IconHelper {
    private IconHelper() {
    }

    static void setIconOnClickListener(CheckableImageButton r0, View.OnClickListener r1, View.OnLongClickListener r2) {
        r0.setOnClickListener(r1);
        setIconClickable(r0, r2);
    }

    static void setIconOnLongClickListener(CheckableImageButton r0, View.OnLongClickListener r1) {
        r0.setOnLongClickListener(r1);
        setIconClickable(r0, r1);
    }

    private static void setIconClickable(CheckableImageButton r3, View.OnLongClickListener r4) {
        boolean r0 = ViewCompat.hasOnClickListeners(r3);
        boolean r1 = false;
        int r2 = 1;
        if (r4 == null) goto L5;
        boolean r5 = true;
    L6:
        if (r0 == true) goto L8;
        if (r5 == true) goto L8;
    L9:
        r3.setFocusable(r1);
        r3.setClickable(r0);
        r3.setPressable(r0);
        r3.setLongClickable(r5);
        if (r1 == true) goto L13;
        r2 = 2;
    L13:
        ViewCompat.setImportantForAccessibility(r3, r2);
        return;
    L8:
        r1 = true;
        goto L9
    L5:
        r5 = false;
        goto L6
    }

    static void applyIconTint(TextInputLayout r2, CheckableImageButton r3, ColorStateList r4, PorterDuff.Mode r5) {
        Drawable r0 = r3.getDrawable();
        if (r0 == null) goto L13;
        r0 = DrawableCompat.wrap(r0).mutate();
        if (r4 != null) goto L7;
    L9:
        DrawableCompat.setTintList(r0, r4);
    L10:
        if (r5 == null) goto L13;
        DrawableCompat.setTintMode(r0, r5);
        goto L13
    L7:
        if (r4.isStateful() == false) goto L9;
        DrawableCompat.setTintList(r0, ColorStateList.valueOf(r4.getColorForState(mergeIconState(r2, r3), r4.getDefaultColor())));
    L13:
        if (r3.getDrawable() == r0) goto L16;
        r3.setImageDrawable(r0);
        return;
    }

    static void refreshIconDrawableState(TextInputLayout r2, CheckableImageButton r3, ColorStateList r4) {
        Drawable r0 = r3.getDrawable();
        if (r3.getDrawable() == null) goto L10;
        if (r4 != null) goto L6;
        return;
    L6:
        if (r4.isStateful() == false) goto L12;
        int r5 = r4.getColorForState(mergeIconState(r2, r3), r4.getDefaultColor());
        Drawable r6 = DrawableCompat.wrap(r0).mutate();
        DrawableCompat.setTintList(r6, ColorStateList.valueOf(r5));
        r3.setImageDrawable(r6);
        return;
    L12:
        return;
    }

    private static int[] mergeIconState(TextInputLayout r3, CheckableImageButton r4) {
        int[] r5 = r3.getDrawableState();
        int[] r6 = r4.getDrawableState();
        int r0 = r5.length;
        int[] r7 = Arrays.copyOf(r5, r5.length + r6.length);
        System.arraycopy(r6, 0, r7, r0, r6.length);
        return r7;
    }
}
