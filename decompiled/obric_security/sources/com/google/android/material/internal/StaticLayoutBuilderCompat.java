package com.google.android.material.internal;

import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import java.lang.reflect.Constructor;

/* JADX INFO: loaded from: classes2.dex */
final class StaticLayoutBuilderCompat {
    private static final String TEXT_DIRS_CLASS = "android.text.TextDirectionHeuristics";
    private static final String TEXT_DIR_CLASS = "android.text.TextDirectionHeuristic";
    private static final String TEXT_DIR_CLASS_LTR = "LTR";
    private static final String TEXT_DIR_CLASS_RTL = "RTL";
    private static Constructor<StaticLayout> constructor;
    private static boolean initialized;
    private static Object textDirection;
    private Layout.Alignment alignment;
    private TextUtils.TruncateAt ellipsize;
    private int end;
    private boolean includePad;
    private boolean isRtl;
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

    private StaticLayoutBuilderCompat(CharSequence r1, TextPaint r2, int r3) {
        this.source = r1;
        this.paint = r2;
        this.width = r3;
        this.start = 0;
        this.end = r1.length();
        this.alignment = Layout.Alignment.ALIGN_NORMAL;
        this.maxLines = Integer.MAX_VALUE;
        this.includePad = true;
        this.ellipsize = null;
    }

    public static StaticLayoutBuilderCompat obtain(CharSequence r1, TextPaint r2, int r3) {
        return new StaticLayoutBuilderCompat(r1, r2, r3);
    }

    public StaticLayoutBuilderCompat setAlignment(Layout.Alignment r1) {
        this.alignment = r1;
        return this;
    }

    public StaticLayoutBuilderCompat setIncludePad(boolean r1) {
        this.includePad = r1;
        return this;
    }

    public StaticLayoutBuilderCompat setStart(int r1) {
        this.start = r1;
        return this;
    }

    public StaticLayoutBuilderCompat setEnd(int r1) {
        this.end = r1;
        return this;
    }

    public StaticLayoutBuilderCompat setMaxLines(int r1) {
        this.maxLines = r1;
        return this;
    }

    public StaticLayoutBuilderCompat setEllipsize(TextUtils.TruncateAt r1) {
        this.ellipsize = r1;
        return this;
    }

    public StaticLayout build() throws StaticLayoutBuilderCompatException {
        if (this.source != null) goto L5;
        this.source = "";
    L5:
        int r0 = Math.max(0, this.width);
        CharSequence r1 = this.source;
        if (this.maxLines != 1) goto L8;
        r1 = TextUtils.ellipsize(r1, this.paint, r0, this.ellipsize);
    L8:
        this.end = Math.min(r1.length(), this.end);
        if (this.isRtl == false) goto L11;
        this.alignment = Layout.Alignment.ALIGN_OPPOSITE;
    L11:
        StaticLayout.Builder r2 = StaticLayout.Builder.obtain(r1, this.start, this.end, this.paint, r0);
        r2.setAlignment(this.alignment);
        r2.setIncludePad(this.includePad);
        if (this.isRtl == false) goto L14;
        TextDirectionHeuristic r3 = TextDirectionHeuristics.RTL;
    L15:
        r2.setTextDirection(r3);
        TextUtils.TruncateAt r4 = this.ellipsize;
        if (r4 == null) goto L18;
        r2.setEllipsize(r4);
    L18:
        r2.setMaxLines(this.maxLines);
        return r2.build();
    L14:
        r3 = TextDirectionHeuristics.LTR;
        goto L15
    }

    private void createConstructorWithReflection() throws StaticLayoutBuilderCompatException {
        if (initialized == false) goto L18;
        return;
    L18:
    L15:
        e = move-exception;
        throw new StaticLayoutBuilderCompatException(e);
    L6:
        if (this.isRtl == false) goto L8;
        boolean r4 = true;
    L10:
        if (r4 == false) goto L12;
        TextDirectionHeuristic r5 = TextDirectionHeuristics.RTL;     // Catch: Exception -> L15
    L13:
        textDirection = r5;     // Catch: Exception -> L15
        Constructor<StaticLayout> r6 = StaticLayout.class.getDeclaredConstructor(new Class[]{CharSequence.class, Integer.TYPE, Integer.TYPE, TextPaint.class, Integer.TYPE, Layout.Alignment.class, TextDirectionHeuristic.class, Float.TYPE, Float.TYPE, Boolean.TYPE, TextUtils.TruncateAt.class, Integer.TYPE, Integer.TYPE});     // Catch: Exception -> L15
        constructor = r6;     // Catch: Exception -> L15
        r6.setAccessible(true);     // Catch: Exception -> L15
        initialized = true;     // Catch: Exception -> L15
        return;
    L12:
        r5 = TextDirectionHeuristics.LTR;     // Catch: Exception -> L15
        goto L13
    L8:
        r4 = false;
        goto L10
    }

    public StaticLayoutBuilderCompat setIsRtl(boolean r1) {
        this.isRtl = r1;
        return this;
    }
}
