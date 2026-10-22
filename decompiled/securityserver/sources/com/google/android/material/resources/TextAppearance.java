package com.google.android.material.resources;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.Log;
import androidx.annotation.FontRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class TextAppearance {
    private static final String TAG = "TextAppearance";
    private static final int TYPEFACE_MONOSPACE = 3;
    private static final int TYPEFACE_SANS = 1;
    private static final int TYPEFACE_SERIF = 2;
    private Typeface font;

    @Nullable
    public final String fontFamily;

    @FontRes
    private final int fontFamilyResourceId;
    private boolean fontResolved;

    @Nullable
    public final ColorStateList shadowColor;
    public final float shadowDx;
    public final float shadowDy;
    public final float shadowRadius;
    public final boolean textAllCaps;

    @Nullable
    public final ColorStateList textColor;

    @Nullable
    public final ColorStateList textColorHint;

    @Nullable
    public final ColorStateList textColorLink;
    public final float textSize;
    public final int textStyle;
    public final int typeface;

    public TextAppearance(@NonNull Context r5, @StyleRes int r6) {
        this.fontResolved = false;
        TypedArray r7 = r5.obtainStyledAttributes(r6, R.styleable.TextAppearance);
        this.textSize = r7.getDimension(R.styleable.TextAppearance_android_textSize, 0.0f);
        this.textColor = MaterialResources.getColorStateList(r5, r7, R.styleable.TextAppearance_android_textColor);
        this.textColorHint = MaterialResources.getColorStateList(r5, r7, R.styleable.TextAppearance_android_textColorHint);
        this.textColorLink = MaterialResources.getColorStateList(r5, r7, R.styleable.TextAppearance_android_textColorLink);
        this.textStyle = r7.getInt(R.styleable.TextAppearance_android_textStyle, 0);
        this.typeface = r7.getInt(R.styleable.TextAppearance_android_typeface, 1);
        int r1 = MaterialResources.getIndexWithValue(r7, R.styleable.TextAppearance_fontFamily, R.styleable.TextAppearance_android_fontFamily);
        this.fontFamilyResourceId = r7.getResourceId(r1, 0);
        this.fontFamily = r7.getString(r1);
        this.textAllCaps = r7.getBoolean(R.styleable.TextAppearance_textAllCaps, false);
        this.shadowColor = MaterialResources.getColorStateList(r5, r7, R.styleable.TextAppearance_android_shadowColor);
        this.shadowDx = r7.getFloat(R.styleable.TextAppearance_android_shadowDx, 0.0f);
        this.shadowDy = r7.getFloat(R.styleable.TextAppearance_android_shadowDy, 0.0f);
        this.shadowRadius = r7.getFloat(R.styleable.TextAppearance_android_shadowRadius, 0.0f);
        r7.recycle();
    }

    public static /* synthetic */ Typeface access$000(TextAppearance r0) {
        return r0.font;
    }

    public static /* synthetic */ Typeface access$002(TextAppearance r0, Typeface r1) {
        r0.font = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$102(TextAppearance r0, boolean r1) {
        r0.fontResolved = r1;
        return r1;
    }

    private void createFallbackFont() {
        if (this.font != null) goto L8;
        String r0 = this.fontFamily;
        if (r0 == null) goto L8;
        this.font = Typeface.create(r0, this.textStyle);
    L8:
        if (this.font != null) goto L21;
        int r1 = this.typeface;
        if (r1 != 1) goto L12;
        this.font = Typeface.SANS_SERIF;
    L19:
        this.font = Typeface.create(this.font, this.textStyle);
        return;
    L12:
        if (r1 != 2) goto L14;
        this.font = Typeface.SERIF;
        goto L19
    L14:
        if (r1 == 3) goto L16;
        this.font = Typeface.DEFAULT;
        goto L19
    L16:
        this.font = Typeface.MONOSPACE;
        goto L19
    }

    public Typeface getFallbackFont() {
        createFallbackFont();
        return this.font;
    }

    @NonNull
    @VisibleForTesting
    public Typeface getFont(@NonNull Context r3) {
        if (this.fontResolved == false) goto L7;
        return this.font;
    L7:
        if (r3.isRestricted() == false) goto L17;
    L14:
        createFallbackFont();
        this.fontResolved = true;
        return this.font;
    L17:
        Typeface r4 = ResourcesCompat.getFont(r3, this.fontFamilyResourceId);     // Catch: Exception -> L12 Throwable -> L16
        this.font = r4;     // Catch: Exception -> L12 Throwable -> L16
        if (r4 == null) goto L14;
        this.font = Typeface.create(r4, this.textStyle);     // Catch: Exception -> L12 Throwable -> L16
    L12:
        e = move-exception;
        Log.d(TAG, "Error loading font " + this.fontFamily, e);
        goto L14
    }

    public void getFontAsync(@NonNull Context r5, @NonNull final TextAppearanceFontCallback r6) {
        if (TextAppearanceConfig.shouldLoadFontSynchronously() == false) goto L5;
        getFont(r5);
    L6:
        int r0 = this.fontFamilyResourceId;
        if (r0 != 0) goto L10;
        this.fontResolved = true;
    L10:
        if (this.fontResolved == false) goto L19;
        r6.onFontRetrieved(this.font, true);
        return;
    L19:
        ResourcesCompat.getFont(r5, r0, new AnonymousClass1(this, r6), null);     // Catch: Exception -> L15 Resources.NotFoundException -> L17
    L22:
        return;
    L17:
        this.fontResolved = true;
        r6.onFontRetrievalFailed(1);
        return;
    L15:
        e = move-exception;
        Log.d(TAG, "Error loading font " + this.fontFamily, e);
        this.fontResolved = true;
        r6.onFontRetrievalFailed(-3);
        return;
    L5:
        createFallbackFont();
        goto L6
    }

    public void updateDrawState(@NonNull Context r4, @NonNull TextPaint r5, @NonNull TextAppearanceFontCallback r6) {
        updateMeasureState(r4, r5, r6);
        ColorStateList r7 = this.textColor;
        if (r7 == null) goto L5;
        int r8 = r7.getColorForState(r5.drawableState, r7.getDefaultColor());
    L6:
        r5.setColor(r8);
        float r9 = this.shadowRadius;
        float r10 = this.shadowDx;
        float r0 = this.shadowDy;
        ColorStateList r3 = this.shadowColor;
        if (r3 == null) goto L9;
        int r11 = r3.getColorForState(r5.drawableState, r3.getDefaultColor());
    L10:
        r5.setShadowLayer(r9, r10, r0, r11);
        return;
    L9:
        r11 = 0;
        goto L10
    L5:
        r8 = ViewCompat.MEASURED_STATE_MASK;
        goto L6
    }

    public void updateMeasureState(@NonNull Context r2, @NonNull TextPaint r3, @NonNull TextAppearanceFontCallback r4) {
        if (TextAppearanceConfig.shouldLoadFontSynchronously() == false) goto L5;
        updateTextPaintMeasureState(r3, getFont(r2));
        return;
    L5:
        getFontAsync(r2, r3, r4);
    }

    public void updateTextPaintMeasureState(@NonNull TextPaint r2, @NonNull Typeface r3) {
        r2.setTypeface(r3);
        int r0 = this.textStyle;
        int r4 = (~r3.getStyle()) & r0;
        if ((r4 & 1) == 0) goto L5;
        boolean r1 = true;
    L6:
        r2.setFakeBoldText(r1);
        if ((r4 & 2) == 0) goto L9;
        float r5 = -0.25f;
    L10:
        r2.setTextSkewX(r5);
        r2.setTextSize(this.textSize);
        return;
    L9:
        r5 = 0.0f;
        goto L10
    L5:
        r1 = false;
        goto L6
    }

    public void getFontAsync(@NonNull Context r2, @NonNull final TextPaint r3, @NonNull final TextAppearanceFontCallback r4) {
        updateTextPaintMeasureState(r3, getFallbackFont());
        getFontAsync(r2, new AnonymousClass2(this, r3, r4));
    }
}
