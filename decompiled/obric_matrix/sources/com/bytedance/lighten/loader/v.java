package com.bytedance.lighten.loader;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public class v extends w {
    private Drawable A;
    private Canvas B;
    private volatile boolean C;
    private int D;
    private boolean E;
    private Paint y;
    private Bitmap z;

    class a extends d.b.k.a.y.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ v f4982a;

        a(v r1) {
            this.f4982a = r1;
        }

        @Override // d.b.k.a.y.f
        public void d(Uri r1, @Nullable View r2, @Nullable Throwable r3) {
        }

        @Override // d.b.k.a.y.f
        public void f(Uri r1, @Nullable View r2, @Nullable d.b.k.a.n r3, @Nullable Animatable r4) {
            v.t(this.f4982a, true);
        }
    }

    class b implements d.b.k.a.y.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d.b.k.a.y.f f4983a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ v f4984b;

        b(v r1, d.b.k.a.y.f r2) {
            this.f4984b = r1;
            this.f4983a = r2;
        }

        @Override // d.b.k.a.y.f
        public void a(Uri r1, @Nullable d.b.k.a.n r2) {
            this.f4983a.a(r1, r2);
        }

        @Override // d.b.k.a.y.f
        public void b(Uri r1, @Nullable View r2) {
            this.f4983a.b(r1, r2);
        }

        @Override // d.b.k.a.y.f
        public void c(Uri r1) {
            this.f4983a.c(r1);
        }

        @Override // d.b.k.a.y.f
        public void d(Uri r1, @Nullable View r2, @Nullable Throwable r3) {
            this.f4983a.d(r1, r2, r3);
        }

        @Override // d.b.k.a.y.f
        public void e(Uri r1, Throwable r2) {
            this.f4983a.e(r1, r2);
        }

        @Override // d.b.k.a.y.f
        public void f(Uri r3, @Nullable View r4, @Nullable d.b.k.a.n r5, @Nullable Animatable r6) {
            v.t(this.f4984b, true);
            this.f4983a.f(r3, r4, r5, r6);
        }
    }

    static /* synthetic */ boolean t(v r0, boolean r1) {
        r0.C = r1;
        return r1;
    }

    private void u() {
        if (this.E == true) goto L5;
        return;
    L5:
        Drawable r0 = getDrawable();
        this.A = r0;
        if (r0 != null) goto L9;
        return;
    L9:
        if (getWidth() > 0) goto L11;
        return;
    L11:
        if (getHeight() > 0) goto L14;
        return;
    L14:
        if (this.A.getOpacity() == (-1)) goto L16;
        Bitmap.Config r1 = Bitmap.Config.ARGB_8888;
    L17:
        int r2 = this.A.getIntrinsicWidth();
        int r3 = this.A.getIntrinsicHeight();
        if (r2 > 0) goto L20;
        r2 = getWidth();
    L20:
        if (r3 > 0) goto L22;
        r3 = getHeight();
    L22:
        Bitmap r4 = this.z;
        if (r4 != null) goto L25;
    L36:
        this.D = r2 / 2;
        this.z = Bitmap.createBitmap(r2, r3, r1);
        Canvas r5 = new Canvas(this.z);
        this.B = r5;
        this.A.setBounds(0, 0, r5.getWidth(), this.B.getHeight());
        Bitmap r6 = this.z;
        Shader.TileMode r7 = Shader.TileMode.CLAMP;
        BitmapShader r8 = new BitmapShader(r6, r7, r7);
        this.y.setAntiAlias(true);
        this.y.setShader(r8);
        return;
    L25:
        if (r2 != r4.getWidth()) goto L34;
        if (r3 != this.z.getHeight()) goto L34;
        Canvas r9 = this.B;
        if (r9 == null) goto L38;
        r9.drawColor(0, PorterDuff.Mode.CLEAR);
        return;
    L38:
        return;
    L34:
        if (this.z.isRecycled() == true) goto L36;
        this.z.recycle();
        goto L36
    L16:
        r1 = Bitmap.Config.RGB_565;
        goto L17
    }

    private void v(d.b.k.a.s r3) {
        if (this.E == false) goto L9;
        d.b.k.a.y.f r0 = r3.q();
        if (r0 != null) goto L7;
        r3.L(new a(this));
        return;
    L7:
        r3.L(new b(this, r0));
        return;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas r4) {
        if (this.E == true) goto L5;
        super.onDraw(r4);
        return;
    L5:
        if (this.C == false) goto L7;
        u();
        this.C = false;
    L7:
        Drawable r0 = this.A;
        if (r0 == null) goto L12;
        Canvas r1 = this.B;
        if (r1 == null) goto L12;
        r0.draw(r1);
    L12:
        r4.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, this.D, this.y);
    }

    @Override // android.view.View
    protected void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        u();
    }

    @Override // com.bytedance.lighten.loader.w
    public void q(d.b.k.a.s r2) {
        this.E = r2.I();
        v(r2);
        super.q(r2);
    }

    @Override // d.c.f.i.c
    public void setController(@Nullable d.c.f.h.a r2) {
        if (this.E == false) goto L5;
        this.C = true;
        setImageDrawable(null);
    L5:
        super.setController(r2);
    }
}
