package d.g.d.b.b;

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
import androidx.annotation.RequiresApi;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(23)
public final class n extends DrawableWrapper implements Animatable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Paint f16803f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Bitmap f16804g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private RectF f16805h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float f16806i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private DisplayMetrics f16807j;

    public n(Drawable r3) {
        kotlin.n0.d.o.f(r3, "bg");
        super(r3);
        Paint r4 = new Paint(1);
        this.f16803f = r4;
        this.f16806i = 16.0f;
        r4.setStyle(Paint.Style.FILL);
        r4.setAntiAlias(true);
    }

    public n(Drawable r2, DisplayMetrics r3) {
        kotlin.n0.d.o.f(r2, "bg");
        kotlin.n0.d.o.f(r3, "displayMetrics");
        this(r2);
        this.f16807j = r3;
    }

    public final void a(float r1) {
        this.f16806i = r1;
    }

    @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public void draw(Canvas r6) {
        kotlin.n0.d.o.f(r6, "canvas");
        int r0 = r6.saveLayer(this.f16805h, this.f16803f);
        super.draw(r6);
        Bitmap r1 = this.f16804g;
        if (r1 == null) goto L5;
        this.f16803f.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        r6.drawBitmap(r1, 0.0f, 0.0f, this.f16803f);
        this.f16803f.setXfermode(null);
    L5:
        r6.restoreToCount(r0);
    }

    @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public void inflate(Resources r6, XmlPullParser r7, AttributeSet r8, Resources.Theme r9) {
        kotlin.n0.d.o.f(r6, "r");
        kotlin.n0.d.o.f(r7, "parser");
        kotlin.n0.d.o.f(r8, "attrs");
        super.inflate(r6, r7, r8, r9);
        int r0 = r7.getDepth();
        this.f16807j = r6.getDisplayMetrics();
        Drawable r1 = null;
    L3:
        int r2 = r7.next();
        if (r2 == 1) goto L15;
        if (r2 != 3) goto L10;
        if (r7.getDepth() <= r0) goto L15;
    L10:
        if (r2 != 2) goto L3;
        if (kotlin.n0.d.o.a(r7.getName(), "corners") == true) goto L13;
        r1 = DrawableWrapper.createFromXmlInner(r6, r7, r8, r9);
        goto L3
    L13:
        this.f16806i = k.d(r6, r9, r8, new int[]{R.attr.radius}).getDimensionPixelSize(0, (int) this.f16806i);
    L15:
        if (r1 == null) goto L27;
        setDrawable(r1);
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

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int r6, int r7, int r8, int r9) {
        super.setBounds(r6, r7, r8, r9);
        RectF r0 = new RectF(r6, r7, r8, r9);
        if ((!kotlin.n0.d.o.a(r0, this.f16805h)) == false) goto L9;
        Bitmap r1 = this.f16804g;
        if (r1 == null) goto L7;
        r1.recycle();
    L7:
        Bitmap r10 = Bitmap.createBitmap(this.f16807j, r8 - r6, r9 - r7, Bitmap.Config.ARGB_8888);
        Canvas r11 = new Canvas(r10);
        float r12 = this.f16806i;
        r11.drawRoundRect(r0, r12, r12, this.f16803f);
        this.f16805h = r0;
        this.f16804g = r10;
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
}
