package com.google.android.material.internal;

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
import androidx.appcompat.widget.ActivityChooserView;
import java.lang.reflect.Constructor;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
final class StaticLayoutBuilderCompat {
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
    private boolean includePad;
    private boolean isRtl;
    private int maxLines;
    private final TextPaint paint;
    private CharSequence source;
    private int start;
    private final int width;

    public static class StaticLayoutBuilderCompatException extends Exception {
        public StaticLayoutBuilderCompatException(Throwable r3) {
            super("Error thrown initializing StaticLayout " + r3.getMessage(), r3);
        }
    }

    private StaticLayoutBuilderCompat(CharSequence r1, TextPaint r2, int r3) {
        this.source = r1;
        this.paint = r2;
        this.width = r3;
        this.start = 0;
        this.end = r1.length();
        this.alignment = Layout.Alignment.ALIGN_NORMAL;
        this.maxLines = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.includePad = true;
        this.ellipsize = null;
    }

    private void createConstructorWithReflection() {
        if (initialized == false) goto L15;
        return;
    L15:
    L8:
        e = move-exception;
        throw new StaticLayoutBuilderCompatException(e);
    L6:
        if (this.isRtl == false) goto L10;
        TextDirectionHeuristic r14 = TextDirectionHeuristics.RTL;     // Catch: Exception -> L8
    L11:
        textDirection = r14;     // Catch: Exception -> L8
        Class r13 = Integer.TYPE;     // Catch: Exception -> L8
        Class r9 = Float.TYPE;     // Catch: Exception -> L8
        Constructor<StaticLayout> r15 = StaticLayout.class.getDeclaredConstructor(new Class[]{CharSequence.class, r13, r13, TextPaint.class, r13, Layout.Alignment.class, TextDirectionHeuristic.class, r9, r9, Boolean.TYPE, TextUtils.TruncateAt.class, r13, r13});     // Catch: Exception -> L8
        constructor = r15;     // Catch: Exception -> L8
        r15.setAccessible(true);     // Catch: Exception -> L8
        initialized = true;     // Catch: Exception -> L8
        return;
    L10:
        r14 = TextDirectionHeuristics.LTR;     // Catch: Exception -> L8
        goto L11
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
        CharSequence r1 = this.source;
        if (this.maxLines != 1) goto L8;
        r1 = TextUtils.ellipsize(r1, this.paint, r0, this.ellipsize);
    L8:
        int r2 = Math.min(r1.length(), this.end);
        this.end = r2;
        if (this.isRtl == false) goto L11;
        this.alignment = Layout.Alignment.ALIGN_OPPOSITE;
    L11:
        StaticLayout.Builder r3 = StaticLayout.Builder.obtain(r1, this.start, r2, this.paint, r0);
        r3.setAlignment(this.alignment);
        r3.setIncludePad(this.includePad);
        if (this.isRtl == false) goto L14;
        TextDirectionHeuristic r4 = TextDirectionHeuristics.RTL;
    L15:
        r3.setTextDirection(r4);
        TextUtils.TruncateAt r5 = this.ellipsize;
        if (r5 == null) goto L18;
        r3.setEllipsize(r5);
    L18:
        r3.setMaxLines(this.maxLines);
        return r3.build();
    L14:
        r4 = TextDirectionHeuristics.LTR;
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
    public StaticLayoutBuilderCompat setIncludePad(boolean r1) {
        this.includePad = r1;
        return this;
    }

    public StaticLayoutBuilderCompat setIsRtl(boolean r1) {
        this.isRtl = r1;
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
