package wn;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.facebook.common.references.CloseableReference;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f22886a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f22887b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f22888c;
    public Matrix d;
    public final Matrix e;
    public final b f;
    public String g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f22889h;

    public e(b r5, f r10) {
        this.f22887b = 0;
        this.f22888c = 0;
        this.e = new Matrix();
        this.f = r5;
        this.f22886a = r10;
    }

    public final void a() {
        Rect r5 = getBounds();
        int r10 = r5.width();
        int r11 = r5.height();
        b r12 = this.f;
        boolean r13 = r12.d;
        Drawable r14 = r12.f22876c;
        Bitmap r15 = r12.f22874a;
        if (r13 == false) goto L5;
        int r16 = r15.getWidth();
    L6:
        this.f22887b = r16;
        if (r12.d == false) goto L9;
        int r17 = r15.getHeight();
    L10:
        this.f22888c = r17;
        if (r16 <= 0) goto L24;
        if (r17 <= 0) goto L24;
        if (r16 != r10) goto L18;
        if (r17 != r11) goto L18;
        r12.a(r5.left, r5.top, r5.right, r5.bottom);
        this.d = null;
        return;
    L18:
        g r18 = g.f22893h;
        f r19 = this.f22886a;
        if (r19 != r18) goto L22;
        r12.a(r5.left, r5.top, r5.right, r5.bottom);
        this.d = null;
        return;
    L22:
        r12.a(0, 0, r16, r17);
        Matrix r20 = this.e;
        r19.getClass();
        r19.b(r20, r5.width(), r5.height(), r16, r17, r5.left, r5.top);
        this.d = r20;
        return;
    L24:
        r12.a(r5.left, r5.top, r5.right, r5.bottom);
        this.d = null;
        return;
    L9:
        r17 = r14.getIntrinsicHeight();
        goto L10
    L5:
        r16 = r14.getIntrinsicWidth();
        goto L6
    }

    public final void b() {
        b r5 = this.f;
        if (r5 == null) goto L8;
        CloseableReference r10 = (CloseableReference) r5.f22875b.f17502b;
        if (r10 == null) goto L9;
        r10.close();
        return;
    L9:
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r14) {
        b r5 = this.f;
        if (r5 == null) goto L47;
        int r10 = this.f22887b;
        Drawable r11 = r5.f22876c;
        Bitmap r12 = r5.f22874a;
        boolean r13 = r5.d;
        if (r13 == false) goto L7;
        int r15 = r12.getWidth();
    L8:
        if (r10 != r15) goto L14;
        int r16 = this.f22888c;
        if (r13 == false) goto L12;
        int r17 = r12.getHeight();
    L13:
        if (r16 != r17) goto L14;
    L16:
        if (TextUtils.isEmpty(this.g) == true) goto L34;
        Bitmap r18 = null;
        if (r13 == false) goto L21;
        Bitmap r19 = r12;
    L24:
        if (r19 == null) goto L34;
        int r20 = getBounds().width();
        int r21 = getBounds().height();
        int r22 = r19.getWidth();
        int r23 = r19.getHeight();
        String r110 = this.g;
        String r111 = this.f22889h;
        if (r13 == false) goto L29;
        Bitmap r112 = r12;
    L32:
        com.bytedance.ies.bullet.base.utils.b.j(r20, r21, r22, r23, this.f22886a, r110, r111, r14, r112);
        return;
    L29:
        if ((r11 instanceof BitmapDrawable) == false) goto L31;
        r18 = ((BitmapDrawable) r11).getBitmap();
    L31:
        r112 = r18;
        goto L32
    L21:
        if ((r11 instanceof BitmapDrawable) == false) goto L23;
        r19 = ((BitmapDrawable) r11).getBitmap();
        goto L24
    L23:
        r19 = null;
    L34:
        Matrix r24 = this.d;
        Rect r25 = r5.f22880k;
        Paint r26 = r5.f22879j;
        if (r24 == null) goto L42;
        int r27 = r14.save();
        r14.clipRect(getBounds());
        r14.concat(this.d);
        if (r13 == false) goto L39;
        r14.drawBitmap(r12, r25, r5.f22881l, r26);
    L40:
        r14.restoreToCount(r27);
        return;
    L39:
        r11.draw(r14);
        goto L40
    L42:
        if (r13 == false) goto L45;
        r14.drawBitmap(r12, r25, r5.f22881l, r26);
        return;
    L45:
        r11.draw(r14);
        return;
    L12:
        r17 = r11.getIntrinsicHeight();
    L14:
        a();
        goto L16
    L7:
        r15 = r11.getIntrinsicWidth();
        goto L8
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        b r5 = this.f;
        if (r5 != null) goto L7;
        return 0;
    L7:
        if (r5.d == false) goto L20;
        Bitmap r10 = r5.f22874a;
        if (r10 != null) goto L11;
        return -3;
    L11:
        if (r10.hasAlpha() == false) goto L13;
        return -3;
    L13:
        if (r5.f22879j.getAlpha() < 255) goto L22;
        return -1;
    L22:
        return -3;
    L20:
        return r5.f22876c.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect r5) {
        if (this.f == null) goto L6;
        a();
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r5) {
        b r10 = this.f;
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.d == false) goto L10;
        float r11 = r5;
        if (r10.e == r11) goto L13;
        r10.e = r11;
        r10.f22879j.setAlpha(r5);
        return;
    L13:
        return;
    L10:
        r10.f22876c.setAlpha(r5);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r5) {
        b r10 = this.f;
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.d == false) goto L8;
        r10.f22879j.setColorFilter(r5);
        return;
    L8:
        r10.f22876c.setColorFilter(r5);
    }
}
