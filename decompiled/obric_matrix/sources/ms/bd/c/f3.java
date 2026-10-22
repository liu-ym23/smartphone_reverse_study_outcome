package ms.bd.c;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
class f3 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ Context f22356f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ g3 f22357g;

    f3(g3 r1, Context r2) {
        this.f22357g = r1;
        this.f22356f = r2;
    }

    @Override // java.lang.Runnable
    public void run() {
    L90:
        int r2 = b.f22318b;     // Catch: Throwable -> L89
        if (((Boolean) m.a(67108868, 0, 0, null, null)).booleanValue() == true) goto L8;
        Thread.sleep(500);     // Catch: Throwable -> L89
        goto L90
    L8:
        if (((String) m.a(16777217, 0, 0, "551837", new byte[]{5, 4, 119, 127})).equals(g3.b(this.f22357g).toUpperCase()) == false) goto L11;
        new d3(this.f22356f).a(g3.e(this.f22357g));     // Catch: Throwable -> L89
    L81:
        String r1 = null;
    L82:
        if (r1 != null) goto L84;
        return;
    L84:
        if (g3.e(this.f22357g) == null) goto L93;
        g3.e(this.f22357g).a(r1);     // Catch: Throwable -> L89
        return;
    L93:
        return;
    L11:
        if (this.f22357g.d() == false) goto L14;
    L80:
        new h3(this.f22356f).a(g3.e(this.f22357g));     // Catch: Throwable -> L89
        goto L81
    L14:
        if (((String) m.a(16777217, 0, 0, "ce1f98", new byte[]{90, 82, 99, 37, 35, 6})).equals(g3.b(this.f22357g).toUpperCase()) == true) goto L80;
        if (((String) m.a(16777217, 0, 0, "458825", new byte[]{13, 30, 101, 99, 59, 3})).equals(g3.b(this.f22357g).toUpperCase()) == true) goto L80;
        if (((String) m.a(16777217, 0, 0, "7e5e6e", new byte[]{14, 72, 104, 62, 59})).equals(g3.b(this.f22357g).toUpperCase()) == false) goto L26;
        new i3(this.f22356f).a(g3.e(this.f22357g));     // Catch: Throwable -> L89
        goto L81
    L26:
        if (((String) m.a(16777217, 0, 0, "0e6a74", new byte[]{14, 87, 117, 58})).equals(g3.b(this.f22357g).toUpperCase()) == false) goto L29;
    L79:
        new m3(this.f22356f).a(g3.e(this.f22357g));     // Catch: Throwable -> L89
        goto L81
    L29:
        if (((String) m.a(16777217, 0, 0, "db56bb", new byte[]{71, 69, 103, 110, 112, 80})).equals(g3.b(this.f22357g).toUpperCase()) == true) goto L79;
        if (((String) m.a(16777217, 0, 0, "b10d4c", new byte[]{92, 29, 102, 32, 39, 65, 82})).equals(g3.b(this.f22357g).toUpperCase()) == true) goto L79;
        if (((String) m.a(16777217, 0, 0, "142bb6", new byte[]{19, 23, 108, 37, 104, 15, 21})).equals(g3.b(this.f22357g).toUpperCase()) == false) goto L41;
        new n3(this.f22356f).a(g3.e(this.f22357g));     // Catch: Throwable -> L89
        goto L81
    L41:
        if (((String) m.a(16777217, 0, 0, "cd6bd1", new byte[]{94, 67, 107, 57, 109, 9})).equals(g3.b(this.f22357g).toUpperCase()) == false) goto L47;
        j3 r3 = new j3(this.f22356f);     // Catch: Throwable -> L89
    L49:
        r3.a(g3.e(this.f22357g));     // Catch: Throwable -> L89
        goto L81
    L47:
        if (((String) m.a(16777217, 0, 0, "fbe797", new byte[]{90, 79, 34, 108, 42, 15, 87, 98})).equals(g3.b(this.f22357g).toUpperCase()) == false) goto L53;
        r3 = new j3(this.f22356f);     // Catch: Throwable -> L89
        goto L49
    L53:
        if (((String) m.a(16777217, 0, 0, "440bda", new byte[]{11, 3, 97, 63, 122})).equals(g3.b(this.f22357g).toUpperCase()) == false) goto L58;
        r1 = new l3(this.f22356f).a();     // Catch: Throwable -> L89
        goto L82
    L58:
        if (((String) m.a(16777217, 0, 0, "4b7592", new byte[]{19, 73, 114, 110})).equals(g3.b(this.f22357g).toUpperCase()) == false) goto L63;
        r1 = new o3(this.f22356f).a();     // Catch: Throwable -> L89
        goto L82
    L63:
        if (((String) m.a(16777217, 0, 0, "4b5bf9", new byte[]{8, 69, 111, 44, 108})).equals(g3.b(this.f22357g).toUpperCase()) == false) goto L66;
        new k3(this.f22356f).b(g3.e(this.f22357g));     // Catch: Throwable -> L89
        goto L81
    L66:
        if (this.f22357g.f() == false) goto L69;
    L78:
        r1 = new p3(this.f22356f).a();     // Catch: Throwable -> L89
        goto L82
    L69:
        if (((String) m.a(16777217, 0, 0, "613926", new byte[]{31, 26, 97, 98, 32, 8})).equals(g3.b(this.f22357g).toUpperCase()) == true) goto L78;
        if (((String) m.a(16777217, 0, 0, "589174", new byte[]{22, 31, 110, 104, 33})).equals(g3.b(this.f22357g).toUpperCase()) == true) goto L78;
        if (((String) m.a(16777217, 0, 0, "843f13", new byte[]{11, 26, 97, 49, 37, 23, 19, 52, 80, 29})).equals(g3.b(this.f22357g).toUpperCase()) == true) goto L78;
        new e3(this.f22356f).a(g3.e(this.f22357g));     // Catch: Throwable -> L89
    }
}
