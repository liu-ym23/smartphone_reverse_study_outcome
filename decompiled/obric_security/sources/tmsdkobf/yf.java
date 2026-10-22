package tmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* JADX INFO: loaded from: classes5.dex */
public final class yf extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean f = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f641a;
    public int b;
    public int c;
    public int d;
    public g8 e;

    static {
    }

    public yf() {
        this.f641a = 0;
        this.b = 0;
        this.c = 2;
        this.d = 0;
    }

    public int a() {
        return this.f641a;
    }

    public Object clone() {
        return super.clone();
    L5:
        if (f == false) goto L9;
        return null;
    L9:
        throw new AssertionError();
    }

    public boolean equals(Object r4) {
        if (r4 != null) goto L5;
        return false;
    L5:
        yf r5 = (yf) r4;
        if (a8.a(this.f641a, r5.f641a) == true) goto L8;
        return false;
    L8:
        if (a8.a(this.b, r5.b) == true) goto L10;
        return false;
    L10:
        if (a8.a(this.c, r5.c) == true) goto L12;
        return false;
    L12:
        if (a8.a(this.d, r5.d) == true) goto L14;
        return false;
    L14:
        if (a8.a(this.e, r5.e) == false) goto L34;
        g8 r1 = this.e;
        if (r1 == null) goto L18;
    L19:
        if (r1 == null) goto L35;
        g8 r2 = r5.e;
        if (r2 != null) goto L23;
        return false;
    L23:
        if (a8.a(r1.b, r2.b) == true) goto L25;
        return false;
    L25:
        if (a8.a(this.e.f215a, r5.e.f215a) == true) goto L27;
        return false;
    L27:
        if (a8.a(this.e.c, r5.e.c) == false) goto L39;
    L28:
        return true;
    L39:
        return false;
    L35:
        return false;
    L18:
        if (r5.e == null) goto L28;
    L34:
        return false;
    }

    public int hashCode() {
    L4:
        e = move-exception;
        e.printStackTrace();
        return 0;
    L3:
        throw new Exception("Need define key first!");     // Catch: Exception -> L4
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream r4) {
        this.f641a = r4.read(this.f641a, 0, true);
        this.b = r4.read(this.b, 1, true);
        this.c = r4.read(this.c, 2, false);
        this.d = r4.read(this.d, 3, false);
        this.e = (g8) r4.read(this.e, 6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream r3) {
        r3.write(this.f641a, 0);
        r3.write(this.b, 1);
        r3.write(this.c, 2);
        r3.write(this.d, 3);
        g8 r2 = this.e;
        if (r2 == null) goto L6;
        r3.write(r2, 6);
        return;
    }
}
