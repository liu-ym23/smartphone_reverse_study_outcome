package it.sephiroth.android.library.imagezoom.b;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes2.dex */
public class a extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Bitmap f17635a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected Paint f17636b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected int f17637c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected int f17638d;

    public a(Bitmap r2) {
        this.f17635a = r2;
        if (r2 == null) goto L5;
        this.f17637c = r2.getWidth();
        int r3 = this.f17635a.getHeight();
    L6:
        this.f17638d = r3;
        Paint r4 = new Paint();
        this.f17636b = r4;
        r4.setDither(true);
        this.f17636b.setFilterBitmap(true);
        return;
    L5:
        r3 = 0;
        this.f17637c = 0;
        goto L6
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r3) {
        Bitmap r0 = this.f17635a;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isRecycled() == true) goto L9;
        r3.drawBitmap(this.f17635a, 0.0f, 0.0f, this.f17636b);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f17638d;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f17637c;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return this.f17638d;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return this.f17637c;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r1) {
        this.f17636b.setAlpha(r1);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r1) {
        this.f17636b.setColorFilter(r1);
    }
}
