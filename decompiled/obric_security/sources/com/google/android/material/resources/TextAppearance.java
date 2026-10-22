package com.google.android.material.resources;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.Log;
import androidx.core.content.res.ResourcesCompat;
import com.google.android.material.R;

/* JADX INFO: loaded from: classes2.dex */
public class TextAppearance {
    private static final String TAG = "TextAppearance";
    private static final int TYPEFACE_MONOSPACE = 3;
    private static final int TYPEFACE_SANS = 1;
    private static final int TYPEFACE_SERIF = 2;
    private Typeface font;
    public final String fontFamily;
    private final int fontFamilyResourceId;
    private boolean fontResolved;
    public final boolean hasLetterSpacing;
    public final float letterSpacing;
    public final ColorStateList shadowColor;
    public final float shadowDx;
    public final float shadowDy;
    public final float shadowRadius;
    public final boolean textAllCaps;
    public final ColorStateList textColor;
    public final ColorStateList textColorHint;
    public final ColorStateList textColorLink;
    public float textSize;
    public final int textStyle;
    public final int typeface;

    static /* synthetic */ Typeface access$000(TextAppearance r0) {
        return r0.font;
    }

    static /* synthetic */ Typeface access$002(TextAppearance r0, Typeface r1) {
        r0.font = r1;
        return r1;
    }

    static /* synthetic */ boolean access$102(TextAppearance r0, boolean r1) {
        r0.fontResolved = r1;
        return r1;
    }

    public TextAppearance(Context r6, int r7) {
        this.fontResolved = false;
        TypedArray r1 = r6.obtainStyledAttributes(r7, R.styleable.TextAppearance);
        this.textSize = r1.getDimension(R.styleable.TextAppearance_android_textSize, 0.0f);
        this.textColor = MaterialResources.getColorStateList(r6, r1, R.styleable.TextAppearance_android_textColor);
        this.textColorHint = MaterialResources.getColorStateList(r6, r1, R.styleable.TextAppearance_android_textColorHint);
        this.textColorLink = MaterialResources.getColorStateList(r6, r1, R.styleable.TextAppearance_android_textColorLink);
        this.textStyle = r1.getInt(R.styleable.TextAppearance_android_textStyle, 0);
        this.typeface = r1.getInt(R.styleable.TextAppearance_android_typeface, 1);
        int r2 = MaterialResources.getIndexWithValue(r1, R.styleable.TextAppearance_fontFamily, R.styleable.TextAppearance_android_fontFamily);
        this.fontFamilyResourceId = r1.getResourceId(r2, 0);
        this.fontFamily = r1.getString(r2);
        this.textAllCaps = r1.getBoolean(R.styleable.TextAppearance_textAllCaps, false);
        this.shadowColor = MaterialResources.getColorStateList(r6, r1, R.styleable.TextAppearance_android_shadowColor);
        this.shadowDx = r1.getFloat(R.styleable.TextAppearance_android_shadowDx, 0.0f);
        this.shadowDy = r1.getFloat(R.styleable.TextAppearance_android_shadowDy, 0.0f);
        this.shadowRadius = r1.getFloat(R.styleable.TextAppearance_android_shadowRadius, 0.0f);
        r1.recycle();
        TypedArray r8 = r6.obtainStyledAttributes(r7, R.styleable.MaterialTextAppearance);
        this.hasLetterSpacing = r8.hasValue(R.styleable.MaterialTextAppearance_android_letterSpacing);
        this.letterSpacing = r8.getFloat(R.styleable.MaterialTextAppearance_android_letterSpacing, 0.0f);
        r8.recycle();
    }

    public Typeface getFont(Context r3) {
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

    public void getFontAsync(Context r5, final TextAppearanceFontCallback r6) {
        if (shouldLoadFontSynchronously(r5) == false) goto L5;
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

    public void getFontAsync(Context r2, final TextPaint r3, final TextAppearanceFontCallback r4) {
        updateTextPaintMeasureState(r3, getFallbackFont());
        getFontAsync(r2, new AnonymousClass2(this, r3, r4));
    }

    public Typeface getFallbackFont() {
        createFallbackFont();
        return this.font;
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

    public void updateDrawState(Context r4, TextPaint r5, TextAppearanceFontCallback r6) {
        updateMeasureState(r4, r5, r6);
        ColorStateList r7 = this.textColor;
        if (r7 == null) goto L5;
        int r8 = r7.getColorForState(r5.drawableState, this.textColor.getDefaultColor());
    L6:
        r5.setColor(r8);
        float r9 = this.shadowRadius;
        float r10 = this.shadowDx;
        float r0 = this.shadowDy;
        ColorStateList r1 = this.shadowColor;
        if (r1 == null) goto L9;
        int r3 = r1.getColorForState(r5.drawableState, this.shadowColor.getDefaultColor());
    L10:
        r5.setShadowLayer(r9, r10, r0, r3);
        return;
    L9:
        r3 = 0;
        goto L10
    L5:
        r8 = -16777216;
        goto L6
    }

    public void updateMeasureState(Context r2, TextPaint r3, TextAppearanceFontCallback r4) {
        if (shouldLoadFontSynchronously(r2) == false) goto L5;
        updateTextPaintMeasureState(r3, getFont(r2));
        return;
    L5:
        getFontAsync(r2, r3, r4);
    }

    public void updateTextPaintMeasureState(TextPaint r2, Typeface r3) {
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
        if (this.hasLetterSpacing == false) goto L14;
        r2.setLetterSpacing(this.letterSpacing);
        return;
    L14:
        return;
    L9:
        r5 = 0.0f;
        goto L10
    L5:
        r1 = false;
        goto L6
    }

    private boolean shouldLoadFontSynchronously(Context r1) {
        return TextAppearanceConfig.shouldLoadFontSynchronously();
    }
}
