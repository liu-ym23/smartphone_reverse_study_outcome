package com.obric.oui.common.style;

import android.R;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableWrapper;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import androidx.annotation.RequiresApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(23)
@Metadata
public final class RoundCornerDrawable extends DrawableWrapper implements Animatable {
    public final Paint b;
    public Bitmap c;
    public RectF e;
    public float f;
    public DisplayMetrics i;

    public RoundCornerDrawable(Drawable r3, DisplayMetrics r4) {
        Intrinsics.f(r4, "displayMetrics");
        super(r3);
        Paint r5 = new Paint(1);
        this.b = r5;
        this.f = 16.0f;
        r5.setStyle(Paint.Style.FILL);
        r5.setAntiAlias(true);
        this.i = r4;
    }

    @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public final void draw(Canvas r5) {
        Intrinsics.f(r5, "canvas");
        RectF r0 = this.e;
        Paint r1 = this.b;
        int r2 = r5.saveLayer(r0, r1);
        super.draw(r5);
        Bitmap r4 = this.c;
        if (r4 == null) goto L5;
        r1.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        r5.drawBitmap(r4, 0.0f, 0.0f, r1);
        r1.setXfermode(null);
    L5:
        r5.restoreToCount(r2);
    }

    @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public final void inflate(Resources r6, XmlPullParser r7, AttributeSet r8, Resources.Theme r9) {
        Intrinsics.f(r6, "r");
        Intrinsics.f(r7, "parser");
        Intrinsics.f(r8, "attrs");
        super.inflate(r6, r7, r8, r9);
        int r0 = r7.getDepth();
        this.i = r6.getDisplayMetrics();
        Drawable r1 = null;
    L3:
        int r2 = r7.next();
        if (r2 == 1) goto L19;
        if (r2 != 3) goto L10;
        if (r7.getDepth() <= r0) goto L19;
    L10:
        if (r2 != 2) goto L3;
        if (Intrinsics.a(r7.getName(), "corners") == true) goto L13;
        r1 = Drawable.createFromXmlInner(r6, r7, r8, r9);
        goto L3
    L13:
        int[] r3 = {R.attr.radius};
        if (r9 != null) goto L16;
        TypedArray r4 = r6.obtainAttributes(r8, r3);
    L17:
        this.f = r4.getDimensionPixelSize(0, (int) this.f);
        goto L3
    L16:
        r4 = r9.obtainStyledAttributes(r8, r3, 0, 0);
    L19:
        if (r1 == null) goto L31;
        setDrawable(r1);
        return;
    }

    @Override // android.graphics.drawable.Animatable
    public final boolean isRunning() {
        Drawable r1 = getDrawable();
        if ((r1 instanceof AnimationDrawable) == true) goto L5;
        return false;
    L5:
        return ((AnimationDrawable) r1).isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setBounds(int r6, int r7, int r8, int r9) {
        super.setBounds(r6, r7, r8, r9);
        RectF r0 = new RectF(r6, r7, r8, r9);
        if ((!r0.equals(this.e)) == false) goto L9;
        Bitmap r1 = this.c;
        if (r1 == null) goto L7;
        r1.recycle();
    L7:
        Bitmap r10 = Bitmap.createBitmap(this.i, r8 - r6, r9 - r7, Bitmap.Config.ARGB_8888);
        Canvas r11 = new Canvas(r10);
        float r12 = this.f;
        r11.drawRoundRect(r0, r12, r12, this.b);
        this.e = r0;
        this.c = r10;
        return;
    }

    @Override // android.graphics.drawable.Animatable
    public final void start() {
        Drawable r1 = getDrawable();
        if ((r1 instanceof AnimationDrawable) == false) goto L6;
        ((AnimationDrawable) r1).start();
        return;
    }

    @Override // android.graphics.drawable.Animatable
    public final void stop() {
        Drawable r1 = getDrawable();
        if ((r1 instanceof AnimationDrawable) == false) goto L6;
        ((AnimationDrawable) r1).stop();
        return;
    }
}
