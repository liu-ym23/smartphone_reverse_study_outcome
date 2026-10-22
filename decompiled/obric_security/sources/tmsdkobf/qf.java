package tmsdkobf;

import com.obric.securitycenter.nodisturb.ProviderConstants;
import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* JADX INFO: loaded from: classes5.dex */
public final class qf extends JceStruct implements Cloneable {
    static int l = 0;
    static int m = 0;
    static final /* synthetic */ boolean n = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f443a;
    public int b;
    public int c;
    public int d;
    public String e;
    public int f;
    public String g;
    public String h;
    public int i;
    public int j;
    public int k;

    static {
    }

    public qf() {
        this.f443a = "";
        rf r1 = rf.d;
        this.b = r1.a();
        this.c = r1.a();
        this.d = 0;
        this.e = "";
        this.f = 0;
        this.g = "";
        this.h = "";
        this.i = 0;
        this.j = 0;
        this.k = 0;
    }

    public int a() {
        return this.k;
    }

    public int b() {
        return this.i;
    }

    public int c() {
        return this.j;
    }

    public Object clone() {
        return super.clone();
    L5:
        if (n == false) goto L9;
        return null;
    L9:
        throw new AssertionError();
    }

    public String d() {
        return this.f443a;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void display(StringBuilder r2, int r3) {
        JceDisplayer r0 = new JceDisplayer(r2, r3);
        r0.display(this.f443a, "url");
        r0.display(this.b, "mainHarmId");
        r0.display(this.c, "subHarmId");
        r0.display(this.d, "seq");
        r0.display(this.e, "desc");
        r0.display(this.f, "UrlType");
        r0.display(this.g, "title");
        r0.display(this.h, ProviderConstants.Sms.BODY);
        r0.display(this.i, "evilclass");
        r0.display(this.j, "eviltag");
        r0.display(this.k, "block_level");
    }

    @Override // com.qq.taf.jce.JceStruct
    public void displaySimple(StringBuilder r2, int r3) {
        JceDisplayer r0 = new JceDisplayer(r2, r3);
        r0.displaySimple(this.f443a, true);
        r0.displaySimple(this.b, true);
        r0.displaySimple(this.c, true);
        r0.displaySimple(this.d, true);
        r0.displaySimple(this.e, true);
        r0.displaySimple(this.f, true);
        r0.displaySimple(this.g, true);
        r0.displaySimple(this.h, true);
        r0.displaySimple(this.i, false);
        r0.displaySimple(this.j, false);
        r0.displaySimple(this.k, false);
    }

    public boolean equals(Object r4) {
        if (r4 != null) goto L5;
        return false;
    L5:
        qf r5 = (qf) r4;
        if (a8.a(this.f443a, r5.f443a) == true) goto L8;
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
        if (a8.a(this.h, r5.h) == true) goto L22;
        return false;
    L22:
        if (a8.a(this.i, r5.i) == true) goto L24;
        return false;
    L24:
        if (a8.a(this.j, r5.j) == true) goto L26;
        return false;
    L26:
        if (a8.a(this.k, r5.k) == false) goto L39;
        return true;
    L39:
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
        this.f443a = r4.readString(0, true);
        this.b = r4.read(this.b, 1, true);
        this.c = r4.read(this.c, 2, false);
        this.d = r4.read(this.d, 3, false);
        this.e = r4.readString(4, false);
        this.f = r4.read(this.f, 5, false);
        this.g = r4.readString(6, false);
        this.h = r4.readString(7, false);
        this.i = r4.read(this.i, 8, false);
        this.j = r4.read(this.j, 9, false);
        this.k = r4.read(this.k, 10, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream r3) {
        r3.write(this.f443a, 0);
        r3.write(this.b, 1);
        r3.write(this.c, 2);
        r3.write(this.d, 3);
        String r0 = this.e;
        if (r0 == null) goto L5;
        r3.write(r0, 4);
    L5:
        r3.write(this.f, 5);
        String r1 = this.g;
        if (r1 == null) goto L8;
        r3.write(r1, 6);
    L8:
        String r2 = this.h;
        if (r2 == null) goto L11;
        r3.write(r2, 7);
    L11:
        r3.write(this.i, 8);
        r3.write(this.j, 9);
        r3.write(this.k, 10);
    }

    public void a(String r1) {
        this.f443a = r1;
    }
}
