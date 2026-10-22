package tmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* JADX INFO: loaded from: classes5.dex */
public final class cg extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean i = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f132a;
    public boolean b;
    public int c;
    public int d;
    public String e;
    public String f;
    public String g;
    public int h;

    static {
    }

    public cg() {
        this.f132a = "";
        this.b = true;
        this.c = 0;
        this.d = 0;
        this.e = "";
        this.f = "";
        this.g = "";
        this.h = 2;
        c("");
        a(this.b);
        c(this.c);
        b(this.d);
        d(this.e);
        b(this.f);
        a(this.g);
        a(this.h);
    }

    public boolean a() {
        return this.b;
    }

    public void b(String r1) {
        this.f = r1;
    }

    public void c(String r1) {
        this.f132a = r1;
    }

    public Object clone() {
        return super.clone();
    L5:
        if (i == false) goto L9;
        return null;
    L9:
        throw new AssertionError();
    }

    public void d(String r1) {
        this.e = r1;
    }

    public boolean equals(Object r4) {
        if (r4 != null) goto L5;
        return false;
    L5:
        cg r5 = (cg) r4;
        if (a8.a(this.f132a, r5.f132a) == true) goto L8;
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
        if (a8.a(this.e, r5.e) == true) goto L16;
        return false;
    L16:
        if (a8.a(this.f, r5.f) == true) goto L18;
        return false;
    L18:
        if (a8.a(this.g, r5.g) == true) goto L20;
        return false;
    L20:
        if (a8.a(this.h, r5.h) == false) goto L30;
        return true;
    L30:
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
    public void readFrom(JceInputStream r5) {
        c(r5.readString(0, true));
        a(r5.read(this.b, 1, true));
        c(r5.read(this.c, 2, true));
        b(r5.read(this.d, 3, true));
        d(r5.readString(4, true));
        b(r5.readString(5, true));
        a(r5.readString(6, true));
        a(r5.read(this.h, 7, false));
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream r3) {
        r3.write(this.f132a, 0);
        r3.write(this.b, 1);
        r3.write(this.c, 2);
        r3.write(this.d, 3);
        r3.write(this.e, 4);
        r3.write(this.f, 5);
        r3.write(this.g, 6);
        r3.write(this.h, 7);
    }

    public void a(String r1) {
        this.g = r1;
    }

    public void b(int r1) {
        this.d = r1;
    }

    public void c(int r1) {
        this.c = r1;
    }

    public void a(boolean r1) {
        this.b = r1;
    }

    public void a(int r1) {
        this.h = r1;
    }
}
