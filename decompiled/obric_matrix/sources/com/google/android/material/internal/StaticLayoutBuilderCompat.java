package com.google.android.material.internal;

import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;
import java.lang.reflect.Constructor;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
final class StaticLayoutBuilderCompat {
    static final int DEFAULT_HYPHENATION_FREQUENCY = 0;
    static final float DEFAULT_LINE_SPACING_ADD = 0.0f;
    static final float DEFAULT_LINE_SPACING_MULTIPLIER = 1.0f;
    private static final String TEXT_DIRS_CLASS = "android.text.TextDirectionHeuristics";
    private static final String TEXT_DIR_CLASS = "android.text.TextDirectionHeuristic";
    private static final String TEXT_DIR_CLASS_LTR = "LTR";
    private static final String TEXT_DIR_CLASS_RTL = "RTL";

    @Nullable
    private static Constructor<StaticLayout> constructor;
    private static boolean initialized;

    @Nullable
    private static Object textDirection;
    private Layout.Alignment alignment;

    @Nullable
    private TextUtils.TruncateAt ellipsize;
    private int end;
    private int hyphenationFrequency;
    private boolean includePad;
    private boolean isRtl;
    private float lineSpacingAdd;
    private float lineSpacingMultiplier;
    private int maxLines;
    private final TextPaint paint;
    private CharSequence source;
    private int start;
    private final int width;

    static class StaticLayoutBuilderCompatException extends Exception {
        StaticLayoutBuilderCompatException(Throwable r3) {
            super("Error thrown initializing StaticLayout " + r3.getMessage(), r3);
        }
    }

    static {
        if (Build.VERSION.SDK_INT < 23) goto L5;
        int r0 = 1;
    L6:
        DEFAULT_HYPHENATION_FREQUENCY = r0;
        return;
    L5:
        r0 = 0;
        goto L6
    }

    private StaticLayoutBuilderCompat(CharSequence r1, TextPaint r2, int r3) {
        this.source = r1;
        this.paint = r2;
        this.width = r3;
        this.start = 0;
        this.end = r1.length();
        this.alignment = Layout.Alignment.ALIGN_NORMAL;
        this.maxLines = Integer.MAX_VALUE;
        this.lineSpacingAdd = 0.0f;
        this.lineSpacingMultiplier = 1.0f;
        this.hyphenationFrequency = DEFAULT_HYPHENATION_FREQUENCY;
        this.includePad = true;
        this.ellipsize = null;
    }

    private void createConstructorWithReflection() {
        int r0 = Build.VERSION.SDK_INT;
        if (initialized == false) goto L28;
        return;
    L28:
    L25:
        e = move-exception;
        throw new StaticLayoutBuilderCompatException(e);
    L6:
        if (this.isRtl == true) goto L8;
    L10:
        boolean r1 = false;
    L12:
        if (r0 < 18) goto L18;
        Class<?> r5 = TextDirectionHeuristic.class;
        if (r1 == false) goto L16;
        TextDirectionHeuristic r2 = TextDirectionHeuristics.RTL;     // Catch: Exception -> L25
    L17:
        textDirection = r2;     // Catch: Exception -> L25
    L23:
        Class r3 = Integer.TYPE;     // Catch: Exception -> L25
        Class r4 = Float.TYPE;     // Catch: Exception -> L25
        Constructor<StaticLayout> r6 = StaticLayout.class.getDeclaredConstructor(new Class[]{CharSequence.class, r3, r3, TextPaint.class, r3, Layout.Alignment.class, r5, r4, r4, Boolean.TYPE, TextUtils.TruncateAt.class, r3, r3});     // Catch: Exception -> L25
        constructor = r6;     // Catch: Exception -> L25
        r6.setAccessible(true);     // Catch: Exception -> L25
        initialized = true;     // Catch: Exception -> L25
        return;
    L16:
        r2 = TextDirectionHeuristics.LTR;     // Catch: Exception -> L25
        goto L17
    L18:
        ClassLoader r7 = StaticLayoutBuilderCompat.class.getClassLoader();     // Catch: Exception -> L25
        if (this.isRtl == false) goto L21;
        String r8 = TEXT_DIR_CLASS_RTL;
    L22:
        Class<?> r9 = r7.loadClass(TEXT_DIR_CLASS);     // Catch: Exception -> L25
        Class<?> r10 = r7.loadClass(TEXT_DIRS_CLASS);     // Catch: Exception -> L25
        textDirection = r10.getField(r8).get(r10);     // Catch: Exception -> L25
        r5 = r9;
        goto L23
    L21:
        r8 = TEXT_DIR_CLASS_LTR;
        goto L22
    L8:
        if (r0 < 23) goto L10;
        r1 = true;
        goto L12
    }

    @NonNull
    public static StaticLayoutBuilderCompat obtain(@NonNull CharSequence r1, @NonNull TextPaint r2, @IntRange(from = 0) int r3) {
        return new StaticLayoutBuilderCompat(r1, r2, r3);
    }

    public StaticLayout build() {
        if (this.source != null) goto L5;
        this.source = "";
    L5:
        int r0 = Math.max(0, this.width);
        CharSequence r2 = this.source;
        if (this.maxLines != 1) goto L8;
        r2 = TextUtils.ellipsize(r2, this.paint, r0, this.ellipsize);
    L8:
        int r3 = Math.min(r2.length(), this.end);
        this.end = r3;
        if (Build.VERSION.SDK_INT >= 23) goto L11;
        createConstructorWithReflection();
        return (StaticLayout) ((Constructor) Preconditions.checkNotNull(constructor)).newInstance(new Object[]{r2, Integer.valueOf(this.start), Integer.valueOf(this.end), this.paint, Integer.valueOf(r0), this.alignment, Preconditions.checkNotNull(textDirection), Float.valueOf(1.0f), Float.valueOf(0.0f), Boolean.valueOf(this.includePad), null, Integer.valueOf(r0), Integer.valueOf(this.maxLines)});
    L35:
        e = move-exception;
        throw new StaticLayoutBuilderCompatException(e);
    L11:
        if (this.isRtl == true) goto L13;
    L15:
        StaticLayout.Builder r1 = StaticLayout.Builder.obtain(r2, this.start, r3, this.paint, r0);
        r1.setAlignment(this.alignment);
        r1.setIncludePad(this.includePad);
        if (this.isRtl == false) goto L18;
        TextDirectionHeuristic r4 = TextDirectionHeuristics.RTL;
    L19:
        r1.setTextDirection(r4);
        TextUtils.TruncateAt r5 = this.ellipsize;
        if (r5 == null) goto L22;
        r1.setEllipsize(r5);
    L22:
        r1.setMaxLines(this.maxLines);
        float r6 = this.lineSpacingAdd;
        if (r6 == 0.0f) goto L25;
    L26:
        r1.setLineSpacing(r6, this.lineSpacingMultiplier);
    L28:
        if (this.maxLines <= 1) goto L31;
        r1.setHyphenationFrequency(this.hyphenationFrequency);
    L31:
        return r1.build();
    L25:
        if (this.lineSpacingMultiplier == 1.0f) goto L28;
    L18:
        r4 = TextDirectionHeuristics.LTR;
        goto L19
    L13:
        if (this.maxLines != 1) goto L15;
        this.alignment = Layout.Alignment.ALIGN_OPPOSITE;
        goto L15
    }

    @NonNull
    public StaticLayoutBuilderCompat setAlignment(@NonNull Layout.Alignment r1) {
        this.alignment = r1;
        return this;
    }

    @NonNull
    public StaticLayoutBuilderCompat setEllipsize(@Nullable TextUtils.TruncateAt r1) {
        this.ellipsize = r1;
        return this;
    }

    @NonNull
    public StaticLayoutBuilderCompat setEnd(@IntRange(from = 0) int r1) {
        this.end = r1;
        return this;
    }

    @NonNull
    public StaticLayoutBuilderCompat setHyphenationFrequency(int r1) {
        this.hyphenationFrequency = r1;
        return this;
    }

    @NonNull
    public StaticLayoutBuilderCompat setIncludePad(boolean r1) {
        this.includePad = r1;
        return this;
    }

    public StaticLayoutBuilderCompat setIsRtl(boolean r1) {
        this.isRtl = r1;
        return this;
    }

    @NonNull
    public StaticLayoutBuilderCompat setLineSpacing(float r1, float r2) {
        this.lineSpacingAdd = r1;
        this.lineSpacingMultiplier = r2;
        return this;
    }

    @NonNull
    public StaticLayoutBuilderCompat setMaxLines(@IntRange(from = 0) int r1) {
        this.maxLines = r1;
        return this;
    }

    @NonNull
    public StaticLayoutBuilderCompat setStart(@IntRange(from = 0) int r1) {
        this.start = r1;
        return this;
    }
}
