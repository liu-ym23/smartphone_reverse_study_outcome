package zm;

import android.graphics.Paint;
import android.graphics.Rect;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.LineHeightSpan;

/* JADX INFO: loaded from: classes2.dex */
public final class f implements LineHeightSpan.WithDensity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f23479a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f23480b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f23481c;
    public final boolean d;

    public f(int r5, float r10, boolean r11, boolean r12) {
        if (r10 != 1.0E21f) goto L5;
        this.f23479a = 0;
    L6:
        this.f23480b = r11;
        this.f23481c = r5;
        this.d = r12;
        return;
    L5:
        this.f23479a = (int) Math.ceil(r10);
        goto L6
    }

    @Override // android.text.style.LineHeightSpan
    public final void chooseHeight(CharSequence r5, int r10, int r11, int r12, int r13, Paint.FontMetricsInt r14) {
    }

    public final boolean equals(Object r5) {
        if ((r5 instanceof f) == true) goto L5;
    L8:
        return false;
    L5:
        if (this.f23479a != ((f) r5).f23479a) goto L8;
        return true;
    }

    public final int hashCode() {
        return this.f23479a + 31;
    }

    @Override // android.text.style.LineHeightSpan.WithDensity
    public final void chooseHeight(CharSequence r5, int r10, int r11, int r12, int r13, Paint.FontMetricsInt r14, TextPaint r15) {
        boolean r16 = this.f23480b;
        int r17 = this.f23479a;
        int r18 = 0;
        if (r16 == false) goto L44;
        int r19 = this.f23481c;
        if (r19 != 0) goto L7;
    L11:
        Rect r20 = null;
    L12:
        if (r17 == 0) goto L29;
        if (r20 != null) goto L29;
        t.a(r17, r14, false);
        a[] r21 = (a[]) ((SpannableStringBuilder) r5).getSpans(r10, r11, a.class);
        int r22 = r21.length;
    L15:
        if (r18 >= r22) goto L69;
        a r23 = r21[r18];
        r23.getClass();
        int r24 = r14.ascent;
        int r25 = r23.f23458c;
        if (r24 <= r25) goto L20;
        r14.ascent = r25;
    L20:
        if (r14.top <= r25) goto L22;
        r14.top = r25;
    L22:
        int r26 = r23.a() + r25;
        if (r14.descent >= r26) goto L26;
        r14.descent = r26;
    L26:
        if (r14.bottom >= r26) goto L28;
        r14.bottom = r26;
    L28:
        r18 = r18 + 1;
        goto L15
    L69:
        return;
    L29:
        if (r20 == null) goto L66;
        if (r17 != 0) goto L33;
        r17 = r14.bottom - r14.top;
    L33:
        if (r19 != 4) goto L37;
        int r27 = r20.top;
        r14.ascent = r27;
        r14.top = r27;
        int r28 = r17 + r27;
        r14.descent = r28;
        r14.bottom = r28;
        return;
    L37:
        if (r19 != 7) goto L41;
        int r29 = r20.bottom;
        r14.descent = r29;
        r14.bottom = r29;
        int r30 = r29 - r17;
        r14.ascent = r30;
        r14.top = r30;
        return;
    L41:
        if (r19 != 11) goto L67;
        int r31 = r20.top - ((r17 - r20.height()) / 2);
        r14.top = r31;
        r14.ascent = r31;
        int r32 = r31 + r17;
        r14.bottom = r32;
        r14.descent = r32;
        return;
    L67:
        return;
    L66:
        return;
    L7:
        if (r5.length() != (r11 - r10)) goto L9;
    L10:
        r20 = new Rect();
        r15.getTextBounds(r5, 0, r5.toString().length(), r20);
        goto L12
    L9:
        if (this.d == false) goto L11;
    L44:
        if (r17 == 0) goto L68;
        int r33 = r14.descent;
        if (r33 <= r17) goto L49;
        int r34 = Math.min(r17, r33);
        r14.descent = r34;
        r14.bottom = r34;
        r14.ascent = 0;
        r14.top = 0;
        return;
    L49:
        int r35 = r14.ascent;
        int r36 = -r35;
        if ((r36 + r33) <= r17) goto L53;
        r14.bottom = r33;
        int r37 = (-r17) + r33;
        r14.ascent = r37;
        r14.top = r37;
        return;
    L53:
        int r38 = r14.bottom;
        if ((r36 + r38) <= r17) goto L57;
        r14.top = r35;
        r14.bottom = r35 + r17;
        return;
    L57:
        int r39 = (-r14.top) + r38;
        if (r39 <= r17) goto L61;
        r14.top = r38 - r17;
        return;
    L61:
        int r40 = Math.round((r17 - r39) / 2.0f);
        int r41 = Math.round((r17 - (r14.descent - r14.ascent)) / 2.0f);
        r14.top -= r40;
        r14.bottom += r40;
        r14.ascent -= r41;
        r14.descent += r41;
        return;
    }
}
