package zm;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Spannable;
import android.text.style.ReplacementSpan;
import com.lynx.tasm.behavior.shadow.text.BackgroundColorSpan;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends ReplacementSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f23472a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f23473b;

    public d(float r5, int r10) {
        this.f23472a = r10;
        this.f23473b = r5;
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas r15, CharSequence r16, int r17, int r18, float r19, int r20, int r21, int r22, Paint r23) {
        Paint.FontMetrics r10 = r23.getFontMetrics();
        boolean r11 = r16 instanceof Spannable;
        float r12 = this.f23473b;
        if (r11 == false) goto L10;
        Spannable r13 = (Spannable) r16;
        BackgroundColorSpan[] r14 = (BackgroundColorSpan[]) r13.getSpans(r17, r18, BackgroundColorSpan.class);
        if (r14 == null) goto L10;
        if (r14.length == 0) goto L10;
        Paint r110 = new Paint();
        r110.setStyle(Paint.Style.FILL);
        r110.setColor(r14[0].getBackgroundColor());
        Rect r111 = new Rect(Math.round(r19), r20, Math.round(r19 + r23.measureText(r13, r17, r18)), r22);
        r111.offset(0, Math.round(r12));
        r15.drawRect(r111, r110);
    L10:
        int r5 = this.f23472a;
        if (r5 != 0) goto L14;
        int r24 = -Math.round(r10.top);
    L25:
        r15.drawText(r16, r17, r18, r19, r24, r23);
        return;
    L14:
        if (r5 != 2) goto L17;
        r24 = r22 - Math.round(r10.leading);
        goto L25
    L17:
        if (r5 != 1) goto L22;
        r24 = (int) ((Math.round(Math.abs(r10.ascent)) + r20) + (((r22 - r20) - (r10.descent - r10.ascent)) / 2.0f));
        if (r10.leading != 0.0f) goto L25;
        r24 = (int) (((r10.descent / 2.0f) - r23.getStrokeMiter()) + r24);
        goto L25
    L22:
        if (r5 != 3) goto L24;
        r24 = (int) (r21 + r12);
        goto L25
    L24:
        r24 = r21;
        goto L25
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint r5, CharSequence r10, int r11, int r12, Paint.FontMetricsInt r13) {
        return Math.round(r5.measureText(r10, r11, r12));
    }
}
