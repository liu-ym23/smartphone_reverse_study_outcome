package d.c.i.i;

import d.c.c.d.i;
import d.c.c.d.n;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f16154a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f16155b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f16156c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f16157d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f16158e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final d.c.c.g.a f16159f;

    public e(d.c.c.g.a r1) {
        i.g(r1);
        this.f16159f = r1;
        this.f16154a = 0;
        this.f16156c = -1;
    }

    private boolean a(InputStream r10) {
        int r0 = this.f16156c;
    L68:
    L65:
        e = move-exception;
        n.a(e);
        throw null;
    L4:
        if (this.f16154a == (-1)) goto L58;
        int r1 = r10.read();     // Catch: IOException -> L65
        if (r1 == (-1)) goto L58;
        int r5 = this.f16155b + 1;     // Catch: IOException -> L65
        this.f16155b = r5;     // Catch: IOException -> L65
        if (this.f16158e == true) goto L9;
        switch(this.f16154a) {
            case 0: goto L29;
            case 1: goto L26;
            case 2: goto L21;
            case 3: goto L18;
            case 4: goto L29;
            case 5: goto L15;
            case 6: goto L29;
            default: goto L68;
        };     // Catch: IOException -> L65
    L15:
        if (r1 == 70) goto L16;
    L17:
        this.f16154a = 0;     // Catch: IOException -> L65
        goto L68
    L16:
        this.f16154a = 6;     // Catch: IOException -> L65
        this.f16157d = r5;     // Catch: IOException -> L65
        this.f16156c++;     // Catch: IOException -> L65
        goto L68
    L18:
        if (r1 != 77) goto L17;
        this.f16154a = 4;     // Catch: IOException -> L65
        goto L68
    L21:
        if (r1 != 73) goto L23;
        this.f16154a = 3;     // Catch: IOException -> L65
        goto L68
    L23:
        if (r1 != 77) goto L17;
        this.f16154a = 5;     // Catch: IOException -> L65
        goto L68
    L26:
        if (r1 != 78) goto L17;
        this.f16154a = 2;     // Catch: IOException -> L65
        goto L68
    L29:
        if (r5 != 13) goto L34;
        if (r1 == 86) goto L34;
    L32:
        this.f16154a = -1;     // Catch: IOException -> L65
    L34:
        if (r5 != 14) goto L39;
        if (r1 != 80) goto L32;
    L39:
        if (r5 != 15) goto L44;
        if (r1 != 56) goto L32;
    L44:
        if (r5 != 16) goto L49;
        if (r1 != 88) goto L32;
    L49:
        if (r5 != 21) goto L54;
        if ((r1 & 2) != 2) goto L32;
    L54:
        if (r1 != 65) goto L68;
        this.f16154a = 1;     // Catch: IOException -> L65
        goto L68
    L9:
        this.f16154a = -1;     // Catch: IOException -> L65
        this.f16158e = false;     // Catch: IOException -> L65
        return false;
    L58:
        if (this.f16154a == (-1)) goto L64;
        int r9 = this.f16156c;
        if (r9 == r0) goto L64;
        if (r9 <= 0) goto L64;
        return true;
    L64:
        return false;
    }

    public int b() {
        return this.f16157d;
    }

    public int c() {
        return this.f16156c;
    }

    public boolean d(d.c.i.l.e r4) {
        if (this.f16154a != (-1)) goto L6;
        return false;
    L6:
        if (r4.X() > this.f16155b) goto L8;
        return false;
    L8:
        d.c.c.g.g r0 = new d.c.c.g.g(r4.O(), this.f16159f.get(16384), this.f16159f);
        d.c.c.k.d.a(r0, this.f16155b);     // Catch: Throwable -> L12 IOException -> L14
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
