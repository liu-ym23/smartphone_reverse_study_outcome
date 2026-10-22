package zm;

import android.graphics.Paint;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import java.text.DecimalFormat;

/* JADX INFO: loaded from: classes2.dex */
public final class j extends MetricAffectingSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f23494a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f23495b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f23496c;
    public boolean d;

    public j(int r5) {
        this.d = false;
        this.f23494a = r5;
    }

    public final boolean equals(Object r5) {
        if ((r5 instanceof j) == true) goto L5;
    L8:
        return false;
    L5:
        if (this.f23494a != ((j) r5).f23494a) goto L8;
        return true;
    }

    public final int hashCode() {
        return this.f23494a + 31;
    }

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r5) {
        boolean r10 = this.d;
        int r11 = this.f23495b;
        float r12 = this.f23496c;
        DecimalFormat r13 = t.f23539a;
        if (r10 == false) goto L6;
        r5.setStyle(Paint.Style.STROKE);
        r5.setStrokeWidth(r12);
        r5.setColor(r11);
        r5.bgColor = 0;
        return;
    L6:
        r5.setStyle(Paint.Style.FILL);
        r5.setColor(this.f23494a);
    }

    @Override // android.text.style.MetricAffectingSpan
    public final void updateMeasureState(TextPaint r5) {
    }
}
