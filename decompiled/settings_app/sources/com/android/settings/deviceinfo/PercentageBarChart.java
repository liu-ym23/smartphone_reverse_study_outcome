package com.android.settings.deviceinfo;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.android.settings.R;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class PercentageBarChart extends View {
    private final Paint mEmptyPaint;
    private Collection<Entry> mEntries;
    private int mMinTickWidth;

    public static class Entry implements Comparable<Entry> {
        public final int order;
        public final Paint paint;
        public final float percentage;

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Entry r1) {
            return compareTo2(r1);
        }

        protected Entry(int r1, float r2, Paint r3) {
            this.order = r1;
            this.percentage = r2;
            this.paint = r3;
        }

        /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
        public int compareTo2(Entry r1) {
            return this.order - r1.order;
        }
    }

    public PercentageBarChart(Context r4, AttributeSet r5) {
        super(r4, r5);
        Paint r0 = new Paint();
        this.mEmptyPaint = r0;
        this.mMinTickWidth = 1;
        TypedArray r6 = r4.obtainStyledAttributes(r5, R.styleable.PercentageBarChart);
        this.mMinTickWidth = r6.getDimensionPixelSize(1, 1);
        int r3 = r6.getColor(0, -16777216);
        r6.recycle();
        r0.setColor(r3);
        r0.setStyle(Paint.Style.FILL);
    }

    @Override // android.view.View
    protected void onDraw(Canvas r25) {
        super.onDraw(r25);
        int r1 = getPaddingLeft();
        int r2 = getWidth() - getPaddingRight();
        int r3 = getPaddingTop();
        int r4 = getHeight() - getPaddingBottom();
        int r5 = r2 - r1;
        float r7 = 0.0f;
        if (isLayoutRtl() == false) goto L21;
        float r6 = r2;
        Collection<Entry> r8 = this.mEntries;
        if (r8 == null) goto L19;
        Iterator<Entry> r9 = r8.iterator();
        float r11 = r6;
    L8:
        if (r9.hasNext() == false) goto L18;
        Entry r10 = r9.next();
        if (r10.percentage != 0.0f) goto L12;
        float r12 = 0.0f;
    L13:
        float r14 = r11 - r12;
        float r13 = r1;
        if (r14 < r13) goto L15;
        r25.drawRect(r14, r3, r11, r4, r10.paint);
        r11 = r14;
        goto L8
    L15:
        r25.drawRect(r13, r3, r11, r4, r10.paint);
        return;
    L12:
        r12 = Math.max(this.mMinTickWidth, r5 * r10.percentage);
        goto L13
    L18:
        float r18 = r11;
    L20:
        r25.drawRect(r1, r3, r18, r4, this.mEmptyPaint);
        return;
    L19:
        r18 = r6;
        goto L20
    L21:
        float r15 = r1;
        Collection<Entry> r16 = this.mEntries;
        if (r16 == null) goto L49;
        Iterator<Entry> r17 = r16.iterator();
        boolean r19 = false;
        float r20 = 0.0f;
        int r110 = 0;
    L25:
        if (r17.hasNext() == false) goto L29;
        Entry r111 = r17.next();
        float r112 = r5;
        float r113 = r111.percentage * r112;
        int r114 = this.mMinTickWidth;
        if (r113 >= r114) goto L25;
        r20 = r20 + (r114 - (r111.percentage * r112));
        r110 = r110 + 1;
        goto L25
    L29:
        Iterator<Entry> r21 = this.mEntries.iterator();
        float r115 = r15;
    L31:
        if (r21.hasNext() == false) goto L48;
        Entry r22 = r21.next();
        if (r22.percentage != r7) goto L35;
        float r116 = r7;
    L36:
        if (r19 == true) goto L42;
        if (r110 <= 0) goto L42;
        if (r116 < (((double) r5) * 0.3d)) goto L42;
        r116 = r116 - r20;
        r19 = true;
    L43:
        float r23 = r115 + r116;
        float r117 = r2;
        if (r23 > r117) goto L45;
        r25.drawRect(r115, r3, r23, r4, r22.paint);
        r115 = r23;
        r7 = 0.0f;
        goto L31
    L45:
        r25.drawRect(r115, r3, r117, r4, r22.paint);
        return;
    L42:
        r19 = r19;
        goto L43
    L35:
        r116 = Math.max(this.mMinTickWidth, r5 * r22.percentage);
        goto L36
    L48:
        float r118 = r115;
    L50:
        r25.drawRect(r118, r3, r2, r4, this.mEmptyPaint);
        return;
    L49:
        r118 = r15;
        goto L50
    }

    @Override // android.view.View
    public void setBackgroundColor(int r1) {
        this.mEmptyPaint.setColor(r1);
    }

    public static Entry createEntry(int r1, float r2, int r3) {
        Paint r0 = new Paint();
        r0.setColor(r3);
        r0.setStyle(Paint.Style.FILL);
        return new Entry(r1, r2, r0);
    }

    public void setEntries(Collection<Entry> r1) {
        this.mEntries = r1;
    }
}
