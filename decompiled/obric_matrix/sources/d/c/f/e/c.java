package d.c.f.e;

import android.annotation.SuppressLint;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f15619a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f15620b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ColorFilter f15621c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f15622d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f15623e;

    public c() {
        this.f15619a = -1;
        this.f15620b = false;
        this.f15621c = null;
        this.f15622d = -1;
        this.f15623e = -1;
    }

    @SuppressLint({"Range"})
    public void a(Drawable r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        int r0 = this.f15619a;
        if (r0 == (-1)) goto L8;
        r5.setAlpha(r0);
    L8:
        if (this.f15620b == false) goto L10;
        r5.setColorFilter(this.f15621c);
    L10:
        int r1 = this.f15622d;
        boolean r2 = true;
        if (r1 == (-1)) goto L16;
        if (r1 == 0) goto L14;
        boolean r3 = true;
    L15:
        r5.setDither(r3);
        goto L16
    L14:
        r3 = false;
    L16:
        int r4 = this.f15623e;
        if (r4 == (-1)) goto L23;
        if (r4 != 0) goto L21;
        r2 = false;
    L21:
        r5.setFilterBitmap(r2);
        return;
    }

    public void b(int r1) {
        this.f15619a = r1;
    }

    public void c(ColorFilter r1) {
        this.f15621c = r1;
        this.f15620b = true;
    }

    public void d(boolean r1) {
        this.f15622d = r1 ? 1 : 0;
    }

    public void e(boolean r1) {
        this.f15623e = r1 ? 1 : 0;
    }
}
