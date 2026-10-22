package com.obric.oui.progress;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.obric.common.oui.R;

/* JADX INFO: loaded from: classes2.dex */
public class OProgressView extends View {
    public Paint b;
    public final Path c;
    public RectF e;
    public RectF f;
    public float i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;

    /* JADX INFO: renamed from: com.obric.oui.progress.OProgressView$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        public int b;
        public int c;
        public int e;
        public int f;
        public int i;

        /* JADX INFO: renamed from: com.obric.oui.progress.OProgressView$SavedState$1, reason: invalid class name */
        public class AnonymousClass1 implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            public final SavedState createFromParcel(Parcel r2) {
                SavedState r1 = new SavedState(r2);
                r1.b = r2.readInt();
                r1.c = r2.readInt();
                r1.e = r2.readInt();
                r1.f = r2.readInt();
                r1.i = r2.readInt();
                return r1;
            }

            @Override // android.os.Parcelable.Creator
            public final SavedState[] newArray(int r1) {
                return new SavedState[r1];
            }
        }

        static {
            CREATOR = new AnonymousClass1();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel r1, int r2) {
            super.writeToParcel(r1, r2);
            r1.writeInt(this.b);
            r1.writeInt(this.c);
            r1.writeInt(this.e);
            r1.writeInt(this.f);
            r1.writeInt(this.i);
        }
    }

    public OProgressView(Context r3, AttributeSet r4) {
        super(r3, r4, 0, 0);
        this.c = new Path();
        this.m = 0;
        this.n = 0;
        TypedArray r5 = r3.obtainStyledAttributes(r4, R.styleable.n, 0, 0);
        this.j = r5.getInt(2, 0);
        this.m = r5.getResourceId(3, com.bytedance.securityserver.R.color.oui_fill_highlighted);
        this.n = r5.getResourceId(0, com.bytedance.securityserver.R.color.oui_line_2);
        setProgressBackgroundHeight(r5.getDimensionPixelSize(1, (int) (6.0f * Resources.getSystem().getDisplayMetrics().density)));
        a();
        r5.recycle();
    }

    public final void a() {
        if (this.m == 0) goto L6;
        this.k = ContextCompat.getColor(getContext(), this.m);
    L6:
        if (this.n == 0) goto L8;
        this.l = ContextCompat.getColor(getContext(), this.n);
    L8:
        invalidate();
    }

    public int getBackgroundColor() {
        return this.l;
    }

    public int getProgress() {
        return this.j;
    }

    public int getProgressColor() {
        return this.k;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r1) {
        super.onConfigurationChanged(r1);
        a();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r6) {
        super.onDraw(r6);
        if (this.b != null) goto L5;
        this.b = new Paint();
    L5:
        this.b.reset();
        this.b.setStyle(Paint.Style.FILL);
        this.b.setAntiAlias(true);
        float r0 = getHeight();
        float r1 = (r0 - this.i) / 2.0f;
        if (this.e != null) goto L8;
        this.e = new RectF();
    L8:
        float r2 = r0 - r1;
        this.e.set(0.0f, r1, getWidth(), r2);
        if (this.f != null) goto L11;
        this.f = new RectF();
    L11:
        this.f.set(0.0f, r1, (getProgress() * getWidth()) / 100.0f, r2);
        r6.save();
        Path r3 = this.c;
        r3.reset();
        RectF r4 = this.e;
        float r5 = this.i;
        r3.addRoundRect(r4, r5, r5, Path.Direction.CW);
        r6.clipPath(r3);
        this.b.setColor(this.l);
        r6.drawRect(this.e, this.b);
        this.b.setColor(this.k);
        r6.drawRect(this.f, this.b);
        r6.restore();
    }

    @Override // android.view.View
    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }

    @Override // android.view.View
    public final void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable r2) {
        SavedState r3 = (SavedState) r2;
        super.onRestoreInstanceState(r3.getSuperState());
        setProgress(r3.b);
        this.m = r3.c;
        this.n = r3.e;
        this.k = r3.f;
        this.l = r3.i;
        a();
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState r1 = new SavedState(super.onSaveInstanceState());
        r1.b = this.j;
        r1.c = this.m;
        r1.e = this.n;
        r1.f = this.k;
        r1.i = this.l;
        return r1;
    }

    @Override // android.view.View
    public void setBackgroundColor(int r2) {
        this.n = 0;
        this.l = r2;
        invalidate();
    }

    public void setProgress(int r2) {
        if (this.j != r2) goto L5;
        return;
    L5:
        if (r2 > 0) goto L8;
        r2 = 0;
    L10:
        this.j = r2;
        invalidate();
        return;
    L8:
        if (r2 < 100) goto L10;
        r2 = 100;
        goto L10
    }

    public void setProgressBackgroundHeight(float r1) {
        this.i = r1;
    }

    public void setProgressColor(int r2) {
        this.m = 0;
        this.k = r2;
        invalidate();
    }
}
