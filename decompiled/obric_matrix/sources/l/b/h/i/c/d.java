package l.b.h.i.c;

import java.io.BufferedWriter;
import java.io.Writer;
import java.util.Iterator;
import l.b.h.g;

/* JADX INFO: loaded from: classes2.dex */
public class d extends BufferedWriter {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private char[] f22311f;

    public d(Writer r1) {
        super(r1);
        this.f22311f = new char[64];
        String r0 = g.d();
        if (r0 == null) goto L6;
        r0.length();
        return;
    }

    private void a(byte[] r7) {
        byte[] r8 = l.b.h.h.a.a(r7);
        int r1 = 0;
    L4:
        if (r1 >= r8.length) goto L13;
        int r2 = 0;
    L6:
        char[] r3 = this.f22311f;
        if (r2 == r3.length) goto L12;
        int r4 = r1 + r2;
        if (r4 >= r8.length) goto L12;
        r3[r2] = (char) r8[r4];
        r2 = r2 + 1;
    L12:
        write(r3, 0, r2);
        newLine();
        r1 = r1 + this.f22311f.length;
        goto L4
    }

    private void g(String r3) {
        write("-----END " + r3 + "-----");
        newLine();
    }

    private void l(String r3) {
        write("-----BEGIN " + r3 + "-----");
        newLine();
    }

    public void b(c r4) {
        b r5 = r4.a();
        l(r5.d());
        if (r5.c().isEmpty() == true) goto L9;
        Iterator r0 = r5.c().iterator();
    L6:
        if (r0.hasNext() == false) goto L8;
        a r1 = (a) r0.next();
        write(r1.b());
        write(": ");
        write(r1.c());
        newLine();
        goto L6
    L8:
        newLine();
    L9:
        a(r5.b());
        g(r5.d());
    }
}
