package com.obric.oui.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.style.ReplacementSpan;
import android.widget.TextClock;
import android.widget.TextView;

/* JADX INFO: loaded from: classes2.dex */
public class OTextClock extends TextClock {
    public volatile CharSequence b;

    /* JADX INFO: renamed from: com.obric.oui.text.OTextClock$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f297a = null;

        static {
            int[] r0 = new int[Layout.Alignment.values().length];
            f297a = r0;
            r0[Layout.Alignment.ALIGN_CENTER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f297a[Layout.Alignment.ALIGN_OPPOSITE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f297a[Layout.Alignment.ALIGN_NORMAL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public static class CustomCharacterSpan extends ReplacementSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f298a;

        @Override // android.text.style.ReplacementSpan
        public final void draw(Canvas r10, CharSequence r11, int r12, int r13, float r14, int r15, int r16, int r17, Paint r18) {
            if (this.f298a >= 0.0f) goto L6;
            this.f298a = r18.measureText(r11, r12, r13);
        L6:
            float r0 = this.f298a;
            float r2 = 0.0f * r0;
            int r3 = AnonymousClass1.f297a[Layout.Alignment.ALIGN_CENTER.ordinal()];
            if (r3 != 1) goto L9;
            float r1 = (r0 - r2) / 2.0f;
        L13:
            float r6 = r14 - r1;
        L15:
            r10.drawText(r11, r12, r13, r6, r16, r18);
            return;
        L9:
            if (r3 == 2) goto L12;
            r6 = r14;
            goto L15
        L12:
            r1 = r0 - r2;
            goto L13
        }

        @Override // android.text.style.ReplacementSpan
        public final int getSize(Paint r2, CharSequence r3, int r4, int r5, Paint.FontMetricsInt r6) {
            if (this.f298a >= 0.0f) goto L6;
            this.f298a = r2.measureText(r3, r4, r5);
        L6:
            return (int) (this.f298a * 0.0f);
        }
    }

    public final void a() {
        if (this.b != null) goto L5;
        return;
    L5:
        if (this.b.length() > 0) goto L8;
        return;
    L8:
        throw null;
    }

    @Override // android.widget.TextView
    public final void setLineSpacing(float r1, float r2) {
        super.setLineSpacing(r1, r2);
        a();
    }

    public void setRatio(float r1) {
        a();
    }

    public void setTargetCharacters(char[] r1) {
        throw null;
    }

    @Override // android.widget.TextView
    public final void setText(CharSequence r1, TextView.BufferType r2) {
        this.b = r1;
        a();
    }

    @Override // android.widget.TextView
    public void setTextSize(float r1) {
        super.setTextSize(r1);
        a();
    }

    @Override // android.widget.TextView
    public void setTypeface(Typeface r1) {
        super.setTypeface(r1);
        a();
    }

    @Override // android.widget.TextView
    public final void setTextSize(int r1, float r2) {
        super.setTextSize(r1, r2);
        a();
    }

    @Override // android.widget.TextView
    public final void setTypeface(Typeface r1, int r2) {
        super.setTypeface(r1, r2);
        a();
    }
}
