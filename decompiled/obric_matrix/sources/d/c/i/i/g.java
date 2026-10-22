package d.c.i.i;

import d.c.c.d.i;
import d.c.c.d.n;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f16160a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f16161b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f16162c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f16163d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f16164e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f16165f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f16166g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final d.c.c.g.a f16167h;

    public g(d.c.c.g.a r1) {
        i.g(r1);
        this.f16167h = r1;
        this.f16162c = 0;
        this.f16161b = 0;
        this.f16163d = 0;
        this.f16165f = 0;
        this.f16164e = 0;
        this.f16160a = 0;
    }

    private boolean a(InputStream r11) {
        int r0 = this.f16164e;
    L57:
        int r3 = 1;
        int r4 = 6;
        if (this.f16160a == 6) goto L49;
        int r1 = r11.read();     // Catch: IOException -> L54
        if (r1 == (-1)) goto L49;
        int r5 = this.f16162c + 1;     // Catch: IOException -> L54
        this.f16162c = r5;     // Catch: IOException -> L54
        if (this.f16166g == true) goto L9;
        int r6 = this.f16160a;     // Catch: IOException -> L54
        if (r6 != 0) goto L14;
        if (r1 == 255) goto L25;
    L27:
        this.f16160a = r4;     // Catch: IOException -> L54
    L46:
        this.f16161b = r1;     // Catch: IOException -> L54
    L25:
        this.f16160a = r3;     // Catch: IOException -> L54
        goto L46
    L14:
        if (r6 == 1) goto L42;
        r4 = 3;
        if (r6 != 2) goto L18;
        if (r1 != 255) goto L46;
    L18:
        if (r6 == 3) goto L26;
        r3 = 5;
        if (r6 == 4) goto L25;
        if (r6 == 5) goto L23;
        i.i(false);     // Catch: IOException -> L54
        goto L46
    L23:
        int r2 = ((this.f16161b << 8) + r1) - 2;     // Catch: IOException -> L54
        d.c.c.k.d.a(r11, r2);     // Catch: IOException -> L54
        this.f16162c += r2;     // Catch: IOException -> L54
    L24:
        this.f16160a = 2;     // Catch: IOException -> L54
        goto L46
    L26:
        if (r1 == 255) goto L27;
        if (r1 == 0) goto L24;
        if (r1 != 217) goto L34;
        this.f16166g = true;     // Catch: IOException -> L54
        f(r5 - 2);     // Catch: IOException -> L54
        goto L24
    L34:
        if (r1 != 218) goto L37;
        f(r5 - 2);     // Catch: IOException -> L54
    L37:
        if (b(r1) == false) goto L24;
        this.f16160a = 4;     // Catch: IOException -> L54
        goto L46
    L42:
        if (r1 != 216) goto L27;
    L9:
        this.f16160a = 6;     // Catch: IOException -> L54
        this.f16166g = false;     // Catch: IOException -> L54
        return false;
    L49:
        if (this.f16160a != 6) goto L51;
        return false;
    L51:
        if (this.f16164e != r0) goto L53;
        return false;
    L53:
        return true;
    L54:
        e = move-exception;
        n.a(e);
        throw null;
    }

    private static boolean b(int r3) {
        if (r3 != 1) goto L6;
        return false;
    L6:
        if (r3 < 208) goto L11;
        if (r3 > 215) goto L11;
        return false;
    L11:
        if (r3 == 217) goto L16;
        if (r3 == 216) goto L16;
        return true;
    L16:
        return false;
    }

    private void f(int r2) {
        int r0 = this.f16163d;
        if (r0 <= 0) goto L5;
        this.f16165f = r2;
    L5:
        this.f16163d = r0 + 1;
        this.f16164e = r0;
    }

    public int c() {
        return this.f16165f;
    }

    public int d() {
        return this.f16164e;
    }

    public boolean e() {
        return this.f16166g;
    }

    public boolean g(d.c.i.l.e r4) {
        if (this.f16160a != 6) goto L6;
        return false;
    L6:
        if (r4.X() > this.f16162c) goto L8;
        return false;
    L8:
        d.c.c.g.g r0 = new d.c.c.g.g(r4.O(), this.f16167h.get(16384), this.f16167h);
        d.c.c.k.d.a(r0, this.f16162c);     // Catch: Throwable -> L12 IOException -> L14
        boolean r3 = a(r0);     // Catch: Throwable -> L12 IOException -> L14
        d.c.c.d.b.b(r0);
        return r3;
    L12:
        th = move-exception;
        d.c.c.d.b.b(r0);
        throw th;
    L14:
        e = move-exception;
        n.a(e);     // Catch: Throwable -> L12
        throw null;
    }
}
