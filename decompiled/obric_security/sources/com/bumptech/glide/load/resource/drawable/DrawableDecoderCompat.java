package com.bumptech.glide.load.resource.drawable;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

/* JADX INFO: loaded from: classes.dex */
public final class DrawableDecoderCompat {
    private static volatile boolean shouldCallAppCompatResources = true;

    static {
    }

    private DrawableDecoderCompat() {
    }

    public static Drawable getDrawable(Context r1, Context r2, int r3) {
        return getDrawable(r1, r2, r3, null);
    }

    public static Drawable getDrawable(Context r0, int r1, Resources.Theme r2) {
        return getDrawable(r0, r0, r1, r2);
    }

    private static Drawable getDrawable(Context r1, Context r2, int r3, Resources.Theme r4) {
    L6:
        e = move-exception;
        if (r1.getPackageName().equals(r2.getPackageName()) == false) goto L10;
        throw e;
    L10:
        return ContextCompat.getDrawable(r2, r3);
    L12:
        shouldCallAppCompatResources = false;
        goto L13
    L3:
        if (shouldCallAppCompatResources == false) goto L13;
        return loadDrawableV7(r2, r3, r4);
    L13:
        if (r4 != null) goto L17;
        r4 = r2.getTheme();
    L17:
        return loadDrawableV4(r2, r3, r4);
    }

    private static Drawable loadDrawableV7(Context r1, int r2, Resources.Theme r3) {
        if (r3 == null) goto L5;
        ContextThemeWrapper r0 = new ContextThemeWrapper(r1, r3);
        r0.applyOverrideConfiguration(r3.getResources().getConfiguration());
        r1 = r0;
    L5:
        return AppCompatResources.getDrawable(r1, r2);
    }

    private static Drawable loadDrawableV4(Context r0, int r1, Resources.Theme r2) {
        return ResourcesCompat.getDrawable(r0.getResources(), r1, r2);
    }
}
