package com.github.mikephil.charting.buffer;

import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

/* JADX INFO: loaded from: classes2.dex */
public class BarBuffer extends AbstractBuffer<IBarDataSet> {
    protected float mBarWidth;
    protected boolean mContainsStacks;
    protected int mDataSetCount;
    protected int mDataSetIndex;
    protected boolean mInverted;

    @Override // com.github.mikephil.charting.buffer.AbstractBuffer
    public /* bridge */ /* synthetic */ void feed(IBarDataSet r1) {
        feed2(r1);
    }

    public BarBuffer(int r1, int r2, boolean r3) {
        super(r1);
        this.mDataSetIndex = 0;
        this.mInverted = false;
        this.mBarWidth = 1.0f;
        this.mDataSetCount = r2;
        this.mContainsStacks = r3;
    }

    public void setBarWidth(float r1) {
        this.mBarWidth = r1;
    }

    public void setDataSet(int r1) {
        this.mDataSetIndex = r1;
    }

    public void setInverted(boolean r1) {
        this.mInverted = r1;
    }

    protected void addBar(float r4, float r5, float r6, float r7) {
        float[] r0 = this.buffer;
        int r1 = this.index;
        this.index = r1 + 1;
        r0[r1] = r4;
        float[] r8 = this.buffer;
        int r2 = this.index;
        this.index = r2 + 1;
        r8[r2] = r5;
        float[] r9 = this.buffer;
        int r10 = this.index;
        this.index = r10 + 1;
        r9[r10] = r6;
        float[] r11 = this.buffer;
        int r12 = this.index;
        this.index = r12 + 1;
        r11[r12] = r7;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: feed, reason: avoid collision after fix types in other method */
    public void feed2(IBarDataSet r19) {
        float r1 = r19.getEntryCount() * this.phaseX;
        float r2 = this.mBarWidth / 2.0f;
        int r4 = 0;
    L4:
        if (r4 >= r1) goto L70;
        BarEntry r6 = (BarEntry) r19.getEntryForIndex(r4);
        if (r6 == null) goto L69;
        float r7 = r6.getX();
        float r8 = r6.getY();
        float[] r9 = r6.getYVals();
        if (this.mContainsStacks == false) goto L45;
        if (r9 == null) goto L45;
        float r10 = -r6.getNegativeSum();
        float r11 = 0.0f;
        int r12 = 0;
    L14:
        if (r12 >= r9.length) goto L69;
        float r13 = r9[r12];
        if (r13 == 0.0f) goto L18;
    L22:
        if (r13 < 0.0f) goto L24;
        float r14 = r13 + r11;
        float r15 = r10;
        r10 = r11;
        r11 = r14;
    L25:
        float r16 = r7 - r2;
        float r17 = r7 + r2;
        if (this.mInverted == false) goto L36;
        if (r10 < r14) goto L30;
        float r3 = r10;
    L32:
        if (r10 <= r14) goto L44;
        r10 = r14;
    L44:
        addBar(r16, r10 * this.phaseY, r17, r3 * this.phaseY);
        r12 = r12 + 1;
        r10 = r15;
        goto L14
    L30:
        r3 = r14;
        goto L32
    L36:
        if (r10 < r14) goto L38;
        float r5 = r10;
    L40:
        if (r10 <= r14) goto L43;
        r10 = r14;
    L43:
        float r18 = r10;
        r10 = r5;
        r3 = r18;
        goto L44
    L38:
        r5 = r14;
        goto L40
    L24:
        r14 = Math.abs(r13) + r10;
        r15 = Math.abs(r13) + r10;
        goto L25
    L18:
        if (r11 != 0.0f) goto L20;
    L21:
        r14 = r13;
        r15 = r10;
        r10 = r14;
        goto L25
    L20:
        if (r10 != 0.0f) goto L22;
    L45:
        float r20 = r7 - r2;
        float r21 = r7 + r2;
        if (this.mInverted == false) goto L56;
        if (r8 < 0.0f) goto L50;
        float r22 = r8;
    L52:
        if (r8 <= 0.0f) goto L65;
        r8 = 0.0f;
    L65:
        if (r8 <= 0.0f) goto L67;
        r8 = r8 * this.phaseY;
    L68:
        addBar(r20, r8, r21, r22);
        goto L69
    L67:
        r22 = r22 * this.phaseY;
        goto L68
    L50:
        r22 = 0.0f;
        goto L52
    L56:
        if (r8 < 0.0f) goto L58;
        float r23 = r8;
    L60:
        if (r8 <= 0.0f) goto L63;
        r8 = 0.0f;
    L63:
        float r110 = r8;
        r8 = r23;
        r22 = r110;
        goto L65
    L58:
        r23 = 0.0f;
    L69:
        r4 = r4 + 1;
        goto L4
    L70:
        reset();
    }
}
