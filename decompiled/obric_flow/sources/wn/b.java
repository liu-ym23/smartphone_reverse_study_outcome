package wn;

import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bitmap f22874a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i4.a f22875b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Drawable f22876c;
    public final boolean d;
    public float e;
    public int f;
    public int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f22877h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f22878i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Paint f22879j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Rect f22880k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Rect f22881l;

    public b(i4.a r5) {
        this.e = 1.0f;
        this.f22875b = r5;
        Bitmap r10 = (Bitmap) r5.f17503c;
        if (r10 == null) goto L6;
        this.f22874a = r10;
        this.d = true;
        Paint r11 = new Paint();
        this.f22879j = r11;
        r11.setAntiAlias(true);
        this.f22880k = new Rect(0, 0, r10.getWidth(), r10.getHeight());
        return;
    L6:
        Drawable r12 = (Drawable) r5.d;
        if (r12 == null) goto L10;
        this.f22876c = r12;
        return;
    }

    public final void a(int r5, int r10, int r11, int r12) {
        if (this.d == true) goto L5;
        this.f22876c.setBounds(r5, r10, r11, r12);
        return;
    L5:
        if (this.f22881l != null) goto L8;
        this.f22881l = new Rect();
    L8:
        if (this.f == r5) goto L10;
    L15:
        this.f22881l.set(r5, r10, r11, r12);
    L16:
        this.f = r5;
        this.g = r10;
        this.f22878i = r11;
        this.f22877h = r12;
        return;
    L10:
        if (this.f22878i != r11) goto L15;
        if (this.g != r10) goto L15;
        if (this.f22877h == r12) goto L16;
        goto L15
    }
}
