package com.github.mikephil.charting.buffer;

import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

/* JADX INFO: loaded from: classes2.dex */
public class HorizontalBarBuffer extends BarBuffer {
    @Override // com.github.mikephil.charting.buffer.BarBuffer, com.github.mikephil.charting.buffer.AbstractBuffer
    public /* bridge */ /* synthetic */ void feed(IBarDataSet r1) {
        feed(r1);
    }

    public HorizontalBarBuffer(int r1, int r2, boolean r3) {
        super(r1, r2, r3);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.buffer.BarBuffer
    public void feed(IBarDataSet r19) {
        float r1 = r19.getEntryCount() * this.phaseX;
        float r2 = this.mBarWidth / 2.0f;
        int r4 = 0;
    L4:
        if (r4 >= r1) goto L64;
        BarEntry r6 = (BarEntry) r19.getEntryForIndex(r4);
        if (r6 == null) goto L63;
        float r7 = r6.getX();
        float r8 = r6.getY();
        float[] r9 = r6.getYVals();
        if (this.mContainsStacks == false) goto L39;
        if (r9 == null) goto L39;
        float r10 = -r6.getNegativeSum();
        float r11 = 0.0f;
        int r12 = 0;
    L14:
        if (r12 >= r9.length) goto L63;
        float r13 = r9[r12];
        if (r13 < 0.0f) goto L18;
        float r14 = r13 + r11;
        float r15 = r10;
        r10 = r11;
        r11 = r14;
    L19:
        float r16 = r7 - r2;
        float r17 = r7 + r2;
        if (this.mInverted == false) goto L30;
        if (r10 < r14) goto L24;
        float r3 = r10;
    L26:
        if (r10 <= r14) goto L38;
        r10 = r14;
    L38:
        addBar(r3 * this.phaseY, r17, r10 * this.phaseY, r16);
        r12 = r12 + 1;
        r10 = r15;
        goto L14
    L24:
        r3 = r14;
        goto L26
    L30:
        if (r10 < r14) goto L32;
        float r5 = r10;
    L34:
        if (r10 <= r14) goto L37;
        r10 = r14;
    L37:
        float r18 = r10;
        r10 = r5;
        r3 = r18;
        goto L38
    L32:
        r5 = r14;
        goto L34
    L18:
        r14 = Math.abs(r13) + r10;
        r15 = Math.abs(r13) + r10;
    L39:
        float r20 = r7 - r2;
        float r21 = r7 + r2;
        if (this.mInverted == false) goto L50;
        if (r8 < 0.0f) goto L44;
        float r22 = r8;
    L46:
        if (r8 <= 0.0f) goto L59;
        r8 = 0.0f;
    L59:
        if (r8 <= 0.0f) goto L61;
        r8 = r8 * this.phaseY;
    L62:
        addBar(r22, r21, r8, r20);
        goto L63
    L61:
        r22 = r22 * this.phaseY;
        goto L62
    L44:
        r22 = 0.0f;
        goto L46
    L50:
        if (r8 < 0.0f) goto L52;
        float r23 = r8;
    L54:
        if (r8 <= 0.0f) goto L57;
        r8 = 0.0f;
    L57:
        float r110 = r8;
        r8 = r23;
        r22 = r110;
        goto L59
    L52:
        r23 = 0.0f;
    L63:
        r4 = r4 + 1;
        goto L4
    L64:
        reset();
    }
}
