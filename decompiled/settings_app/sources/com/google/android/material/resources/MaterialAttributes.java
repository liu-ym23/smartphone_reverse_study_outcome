package com.google.android.material.resources;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import com.google.android.material.R;

/* JADX INFO: loaded from: classes3.dex */
public class MaterialAttributes {
    public MaterialAttributes() {
    }

    public static TypedValue resolve(Context r2, int r3) {
        TypedValue r0 = new TypedValue();
        if (r2.getTheme().resolveAttribute(r3, r0, true) == false) goto L5;
        return r0;
    L5:
        return null;
    }

    public static int resolveOrThrow(Context r3, int r4, String r5) {
        TypedValue r0 = resolve(r3, r4);
        if (r0 == null) goto L7;
        return r0.data;
    L7:
        throw new IllegalArgumentException(String.format("%1$s requires a value for the %2$s attribute to be set in your app theme. You can either set the attribute in your theme or update your theme to inherit from Theme.MaterialComponents (or a descendant).", new Object[]{r5, r3.getResources().getResourceName(r4)}));
    }

    public static int resolveOrThrow(View r1, int r2) {
        return resolveOrThrow(r1.getContext(), r2, r1.getClass().getCanonicalName());
    }

    public static boolean resolveBooleanOrThrow(Context r0, int r1, String r2) {
        if (resolveOrThrow(r0, r1, r2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean resolveBoolean(Context r1, int r2, boolean r3) {
        TypedValue r4 = resolve(r1, r2);
        if (r4 != null) goto L5;
        return r3;
    L5:
        if (r4.type == 18) goto L7;
        return r3;
    L7:
        if (r4.data == 0) goto L9;
        return true;
    L9:
        return false;
    }

    public static int resolveInteger(Context r1, int r2, int r3) {
        TypedValue r4 = resolve(r1, r2);
        if (r4 != null) goto L5;
        return r3;
    L5:
        if (r4.type == 16) goto L7;
        return r3;
    L7:
        return r4.data;
    }

    public static int resolveMinimumAccessibleTouchTarget(Context r2) {
        return resolveDimension(r2, R.attr.minTouchTargetSize, R.dimen.mtrl_min_touch_target_size);
    }

    public static int resolveDimension(Context r2, int r3, int r4) {
        TypedValue r5 = resolve(r2, r3);
        if (r5 != null) goto L5;
    L10:
        float r6 = r2.getResources().getDimension(r4);
    L9:
        return (int) r6;
    L5:
        if (r5.type != 5) goto L10;
        r6 = r5.getDimension(r2.getResources().getDisplayMetrics());
        goto L9
    }
}
