package com.android.setupwizardlib.util;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class DrawableLayoutDirectionHelper {
    public DrawableLayoutDirectionHelper() {
    }

    public static InsetDrawable createRelativeInsetDrawable(Drawable r7, int r8, int r9, int r10, int r11, View r12) {
        boolean r0 = true;
        if (r12.getLayoutDirection() == 1) goto L7;
        r0 = false;
    L7:
        return createRelativeInsetDrawable(r7, r8, r9, r10, r11, r0);
    }

    public static InsetDrawable createRelativeInsetDrawable(Drawable r7, int r8, int r9, int r10, int r11, Context r12) {
        boolean r0 = true;
        if (r12.getResources().getConfiguration().getLayoutDirection() == 1) goto L7;
        r0 = false;
    L7:
        return createRelativeInsetDrawable(r7, r8, r9, r10, r11, r0);
    }

    public static InsetDrawable createRelativeInsetDrawable(Drawable r7, int r8, int r9, int r10, int r11, int r12) {
        boolean r0 = true;
        if (r12 == 1) goto L7;
        r0 = false;
    L7:
        return createRelativeInsetDrawable(r7, r8, r9, r10, r11, r0);
    }

    private static InsetDrawable createRelativeInsetDrawable(Drawable r6, int r7, int r8, int r9, int r10, boolean r11) {
        if (r11 == false) goto L6;
        return new InsetDrawable(r6, r9, r8, r7, r10);
    L6:
        return new InsetDrawable(r6, r7, r8, r9, r10);
    }
}
