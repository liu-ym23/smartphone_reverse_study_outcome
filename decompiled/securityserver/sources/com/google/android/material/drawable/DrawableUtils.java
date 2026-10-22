package com.google.android.material.drawable;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Xml;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.XmlRes;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class DrawableUtils {
    private DrawableUtils() {
    }

    @NonNull
    public static AttributeSet parseDrawableXml(@NonNull Context r3, @XmlRes int r4, @NonNull CharSequence r5) {
        XmlResourceParser r6 = r3.getResources().getXml(r4);     // Catch: Throwable -> L12
    L3:
        int r0 = r6.next();     // Catch: Throwable -> L12
        if (r0 == 2) goto L7;
        if (r0 != 1) goto L3;
    L7:
        if (r0 != 2) goto L17;
        if (TextUtils.equals(r6.getName(), r5) == false) goto L15;
        return Xml.asAttributeSet(r6);
    L15:
        throw new XmlPullParserException("Must have a <" + r5 + "> start tag");     // Catch: Throwable -> L12
    L17:
        throw new XmlPullParserException("No start tag found");     // Catch: Throwable -> L12
    L12:
        e = move-exception;
        Resources.NotFoundException r7 = new Resources.NotFoundException("Can't load badge resource ID #0x" + Integer.toHexString(r4));
        r7.initCause(e);
        throw r7;
    }

    @TargetApi(21)
    public static void setRippleDrawableRadius(@Nullable RippleDrawable r0, int r1) {
        r0.setRadius(r1);
    }

    @Nullable
    public static PorterDuffColorFilter updateTintFilter(@NonNull Drawable r1, @Nullable ColorStateList r2, @Nullable PorterDuff.Mode r3) {
        if (r2 == null) goto L7;
        if (r3 != null) goto L6;
        return null;
    L6:
        return new PorterDuffColorFilter(r2.getColorForState(r1.getState(), 0), r3);
    L7:
        return null;
    }
}
