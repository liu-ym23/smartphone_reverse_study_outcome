package d.c.f.e;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class e extends a {
    private final Drawable[] n;
    int o;
    int p;
    long q;
    int[] r;
    int[] s;
    int t;
    boolean[] u;
    int v;

    public e(Drawable[] r4) {
        super(r4);
        boolean r2 = true;
        if (r4.length >= 1) goto L6;
        r2 = false;
    L6:
        d.c.c.d.i.j(r2, "At least one layer required!");
        this.n = r4;
        this.r = new int[r4.length];
        this.s = new int[r4.length];
        this.t = 255;
        this.u = new boolean[r4.length];
        this.v = 0;
        q();
    }

    private void j(Canvas r2, Drawable r3, int r4) {
        if (r3 == null) goto L6;
        if (r4 <= 0) goto L7;
        this.v++;
        r3.mutate().setAlpha(r4);
        this.v--;
        r3.draw(r2);
        return;
    L7:
        return;
    }

    private void q() {
        this.o = 2;
        Arrays.fill(this.r, 0);
        this.r[0] = 255;
        Arrays.fill(this.s, 0);
        this.s[0] = 255;
        Arrays.fill(this.u, false);
        this.u[0] = true;
    }

    private boolean s(float r10) {
        boolean r3 = true;
        int r2 = 0;
    L4:
        if (r2 >= this.n.length) goto L26;
        boolean[] r4 = this.u;
        if (r4[r2] == false) goto L8;
        int r5 = 1;
    L9:
        int[] r6 = this.s;
        r6[r2] = (int) (this.r[r2] + ((r5 * 255) * r10));
        if (r6[r2] >= 0) goto L13;
        r6[r2] = 0;
    L13:
        if (r6[r2] <= 255) goto L16;
        r6[r2] = 255;
    L16:
        if (r4[r2] == false) goto L21;
        if (r6[r2] >= 255) goto L21;
        r3 = false;
    L21:
        if (r4[r2] == true) goto L25;
        if (r6[r2] <= 0) goto L25;
        r3 = false;
    L25:
        r2 = r2 + 1;
        goto L4
    L8:
        r5 = -1;
        goto L9
    L26:
        return r3;
    }

    @Override // d.c.f.e.a, android.graphics.drawable.Drawable
    public void draw(Canvas r9) {
        int r0 = this.o;
        int r1 = 2;
        int r2 = 0;
        boolean r3 = true;
        if (r0 == 0) goto L13;
        if (r0 != 1) goto L22;
        if (this.p <= 0) goto L9;
        boolean r4 = true;
    L10:
        d.c.c.d.i.i(r4);
        boolean r5 = s((p() - this.q) / this.p);
        if (r5 == true) goto L21;
    L20:
        r1 = 1;
    L21:
        this.o = r1;
        r3 = r5;
        goto L22
    L9:
        r4 = false;
    L22:
        Drawable[] r6 = this.n;
        if (r2 >= r6.length) goto L25;
        j(r9, r6[r2], (this.s[r2] * this.t) / 255);
        r2 = r2 + 1;
        goto L22
    L25:
        if (r3 == true) goto L30;
        invalidateSelf();
        return;
    L30:
        return;
    L13:
        System.arraycopy(this.s, 0, this.r, 0, this.n.length);
        this.q = p();
        if (this.p != 0) goto L16;
        float r7 = 1.0f;
    L17:
        r5 = s(r7);
        if (r5 == false) goto L20;
    L16:
        r7 = 0.0f;
        goto L17
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.t;
    }

    public void i() {
        this.v++;
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.v != 0) goto L6;
        super.invalidateSelf();
        return;
    }

    public void k() {
        this.v--;
        invalidateSelf();
    }

    public void l() {
        this.o = 0;
        Arrays.fill(this.u, true);
        invalidateSelf();
    }

    public void m(int r3) {
        this.o = 0;
        this.u[r3] = true;
        invalidateSelf();
    }

    public void n(int r3) {
        this.o = 0;
        this.u[r3] = false;
        invalidateSelf();
    }

    public void o() {
        this.o = 2;
        int r1 = 0;
    L4:
        if (r1 >= this.n.length) goto L10;
        int[] r2 = this.s;
        if (this.u[r1] == false) goto L8;
        int r3 = 255;
    L9:
        r2[r1] = r3;
        r1 = r1 + 1;
        goto L4
    L8:
        r3 = 0;
        goto L9
    L10:
        invalidateSelf();
    }

    protected long p() {
        return SystemClock.uptimeMillis();
    }

    public void r(int r2) {
        this.p = r2;
        if (this.o != 1) goto L6;
        this.o = 0;
        return;
    }

    @Override // d.c.f.e.a, android.graphics.drawable.Drawable
    public void setAlpha(int r2) {
        if (this.t == r2) goto L6;
        this.t = r2;
        invalidateSelf();
        return;
    }
}
