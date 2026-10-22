package com.obric.oui.common.style;

import android.R;
import android.content.res.Resources;
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
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: compiled from: RoundCornerDrawable.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\b\u0016¢\u0006\u0002\u0010\u0003B\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0017\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J.\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\f\u0010\"\u001a\b\u0018\u00010#R\u00020\u001dH\u0016J\b\u0010$\u001a\u00020%H\u0016J(\u0010&\u001a\u00020\u00182\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020(2\u0006\u0010+\u001a\u00020(H\u0016J\b\u0010,\u001a\u00020\u0018H\u0016J\b\u0010-\u001a\u00020\u0018H\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006."}, d2 = {"Lcom/obric/oui/common/style/RoundCornerDrawable;", "Landroid/graphics/drawable/DrawableWrapper;", "Landroid/graphics/drawable/Animatable;", "()V", "bg", "Landroid/graphics/drawable/Drawable;", "(Landroid/graphics/drawable/Drawable;)V", "displayMetrics", "Landroid/util/DisplayMetrics;", "(Landroid/graphics/drawable/Drawable;Landroid/util/DisplayMetrics;)V", "clipPaint", "Landroid/graphics/Paint;", "clipRect", "Landroid/graphics/RectF;", "dm", "maskBitmap", "Landroid/graphics/Bitmap;", "radius", "", "getRadius", "()F", "setRadius", "(F)V", "draw", "", "canvas", "Landroid/graphics/Canvas;", "inflate", "r", "Landroid/content/res/Resources;", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "attrs", "Landroid/util/AttributeSet;", "theme", "Landroid/content/res/Resources$Theme;", "isRunning", "", "setBounds", "left", "", "top", "right", "bottom", "start", "stop", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RoundCornerDrawable extends DrawableWrapper implements Animatable {
    private final Paint clipPaint;
    private RectF clipRect;
    private DisplayMetrics dm;
    private Bitmap maskBitmap;
    private float radius;

    public final float getRadius() {
        return this.radius;
    }

    public final void setRadius(float r1) {
        this.radius = r1;
    }

    public RoundCornerDrawable() {
        super(null);
        Paint r0 = new Paint(1);
        this.clipPaint = r0;
        this.radius = 16.0f;
        r0.setStyle(Paint.Style.FILL);
        r0.setAntiAlias(true);
    }

    public RoundCornerDrawable(Drawable r3) {
        Intrinsics.checkNotNullParameter(r3, "bg");
        super(r3);
        Paint r4 = new Paint(1);
        this.clipPaint = r4;
        this.radius = 16.0f;
        r4.setStyle(Paint.Style.FILL);
        r4.setAntiAlias(true);
    }

    public RoundCornerDrawable(Drawable r2, DisplayMetrics r3) {
        Intrinsics.checkNotNullParameter(r2, "bg");
        Intrinsics.checkNotNullParameter(r3, "displayMetrics");
        this(r2);
        this.dm = r3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int r6, int r7, int r8, int r9) {
        super.setBounds(r6, r7, r8, r9);
        RectF r0 = new RectF(r6, r7, r8, r9);
        if (Intrinsics.areEqual(r0, this.clipRect) == true) goto L10;
        Bitmap r1 = this.maskBitmap;
        if (r1 == null) goto L8;
        r1.recycle();
    L8:
        Bitmap r10 = Bitmap.createBitmap(this.dm, r8 - r6, r9 - r7, Bitmap.Config.ARGB_8888);
        Canvas r11 = new Canvas(r10);
        float r12 = this.radius;
        r11.drawRoundRect(r0, r12, r12, this.clipPaint);
        this.clipRect = r0;
        this.maskBitmap = r10;
        return;
    }

    @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public void draw(Canvas r6) {
        Intrinsics.checkNotNullParameter(r6, "canvas");
        int r0 = r6.saveLayer(this.clipRect, this.clipPaint);
        super.draw(r6);
        Bitmap r1 = this.maskBitmap;
        if (r1 == null) goto L6;
        this.clipPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        r6.drawBitmap(r1, 0.0f, 0.0f, this.clipPaint);
        this.clipPaint.setXfermode(null);
    L6:
        r6.restoreToCount(r0);
    }

    @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public void inflate(Resources r6, XmlPullParser r7, AttributeSet r8, Resources.Theme r9) {
        Intrinsics.checkNotNullParameter(r6, "r");
        Intrinsics.checkNotNullParameter(r7, "parser");
        Intrinsics.checkNotNullParameter(r8, "attrs");
        super.inflate(r6, r7, r8, r9);
        int r0 = r7.getDepth();
        this.dm = r6.getDisplayMetrics();
        Drawable r1 = null;
    L3:
        int r2 = r7.next();
        if (r2 == 1) goto L15;
        if (r2 != 3) goto L10;
        if (r7.getDepth() <= r0) goto L15;
    L10:
        if (r2 != 2) goto L3;
        if (Intrinsics.areEqual(r7.getName(), "corners") == true) goto L13;
        r1 = DrawableWrapper.createFromXmlInner(r6, r7, r8, r9);
        goto L3
    L13:
        this.radius = OUIResHelper.obtainAttributes(r6, r9, r8, new int[]{R.attr.radius}).getDimensionPixelSize(0, (int) this.radius);
    L15:
        if (r1 == null) goto L27;
        setDrawable(r1);
        return;
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        Drawable r1 = getDrawable();
        if ((r1 instanceof AnimationDrawable) == false) goto L6;
        ((AnimationDrawable) r1).start();
        return;
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        Drawable r1 = getDrawable();
        if ((r1 instanceof AnimationDrawable) == false) goto L6;
        ((AnimationDrawable) r1).stop();
        return;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        Drawable r1 = getDrawable();
        if ((r1 instanceof AnimationDrawable) == true) goto L5;
        return false;
    L5:
        return ((AnimationDrawable) r1).isRunning();
    }
}
