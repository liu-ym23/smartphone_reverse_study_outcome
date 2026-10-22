package zm;

import ai.j0;
import android.graphics.Canvas;
import android.graphics.Paint;

/* JADX INFO: loaded from: classes2.dex */
public final class n extends a {
    public int f;
    public int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f23505h;

    @Override // zm.a
    public final int a() {
        return this.f;
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas r5, CharSequence r10, int r11, int r12, float r13, int r14, int r15, int r16, Paint r17) {
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint r5, CharSequence r10, int r11, int r12, Paint.FontMetricsInt r13) {
        if (r13 == null) goto L40;
        if (r13.descent != r13.ascent) goto L7;
        r13.ascent = r5.getFontMetricsInt().ascent;
        r13.descent = r5.getFontMetricsInt().descent;
    L7:
        if (this.e == false) goto L17;
        int r14 = this.f23456a;
        if (r14 != 1) goto L13;
        int r15 = this.f23505h;
        if (r15 == 0) goto L13;
        this.f23458c = -r15;
    L27:
        int r16 = r13.ascent;
        int r17 = this.f23458c;
        if (r16 <= r17) goto L30;
        r13.ascent = r17;
    L30:
        int r18 = r13.descent;
        int r19 = r17 + this.f;
        if (r18 >= r19) goto L33;
        r13.descent = r19;
    L33:
        int r20 = r13.top;
        int r21 = r13.ascent;
        if (r20 <= r21) goto L36;
        r13.top = r21;
    L36:
        int r22 = r13.bottom;
        int r23 = r13.descent;
        if (r22 >= r23) goto L40;
        r13.bottom = r23;
    L13:
        float r24 = -this.f;
        c r25 = this.d;
        if (r25 == null) goto L16;
        r24 = r25.c(r14, this.f23457b, r24, 0.0f);
    L16:
        this.f23458c = (int) r24;
        goto L27
    L17:
        int r26 = r13.descent;
        int r27 = r13.ascent;
        int r28 = r26 - r27;
        int r29 = this.f;
        switch(this.f23456a) {
            case 1: goto L25;
            case 2: goto L24;
            case 3: goto L23;
            case 4: goto L26;
            case 5: goto L26;
            case 6: goto L19;
            case 7: goto L22;
            case 8: goto L22;
            case 9: goto L20;
            default: goto L19;
        };
    L19:
        r27 = j0.c(r28, r29, 2, r27);
        goto L26
    L20:
        int r30 = -r29;
        float r31 = this.f23457b;
    L21:
        r27 = r30 - ((int) r31);
        goto L26
    L22:
        r27 = r26 - r29;
        goto L26
    L23:
        r27 = r27 + ((int) (r28 * 0.1f));
        goto L26
    L24:
        r30 = r26 - r29;
        r31 = r28 * 0.1f;
        goto L21
    L25:
        r27 = -r29;
    L26:
        this.f23458c = r27;
    L40:
        return this.g;
    }
}
