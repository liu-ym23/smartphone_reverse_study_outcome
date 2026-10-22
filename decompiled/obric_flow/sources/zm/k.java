package zm;

import android.graphics.Paint;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class k extends MetricAffectingSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f23497a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f23498b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f23499c;
    public c d;
    public float e;

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r11) {
        Paint.FontMetricsInt r5 = r11.getFontMetricsInt();
        if (this.e == 1.0E21f) goto L13;
        if (r5 == null) goto L13;
        c r10 = this.d;
        if (r10 == null) goto L13;
        float r12 = ((Float) ((List) r10.f23470b).get(1)).floatValue() - ((Float) ((List) this.d.f23470b).get(0)).floatValue();
        int r13 = this.f23497a;
        if (r13 != 4) goto L11;
        this.f23499c = -((int) ((((Math.ceil(this.e) - ((double) r12)) / 2.0d) + ((double) r5.ascent)) - ((double) ((Float) ((List) this.d.f23470b).get(0)).floatValue())));
        goto L13
    L11:
        if (r13 != 7) goto L13;
        this.f23499c = (int) (((Math.ceil(this.e) - ((double) r12)) / 2.0d) + ((double) (((Float) ((List) this.d.f23470b).get(1)).floatValue() + (-r5.descent))));
    L13:
        r11.baselineShift = this.f23499c;
    }

    @Override // android.text.style.MetricAffectingSpan
    public final void updateMeasureState(TextPaint r10) {
        Paint.FontMetricsInt r5 = r10.getFontMetricsInt();
        if (r5 == null) goto L8;
        c r11 = this.d;
        if (r11 == null) goto L9;
        int r12 = ((int) r11.c(this.f23497a, this.f23498b, r5.ascent, r5.descent)) - r5.ascent;
        this.f23499c = r12;
        r10.baselineShift = r12;
        return;
    L9:
        return;
    }
}
