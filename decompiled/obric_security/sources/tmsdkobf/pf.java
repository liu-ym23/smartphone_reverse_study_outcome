package tmsdkobf;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* JADX INFO: loaded from: classes5.dex */
public final class pf extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean h = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f420a;
    public String b;
    public int c;
    public int d;
    public String e;
    public int f;
    public g8 g;

    static {
    }

    public pf() {
        this.f420a = "";
        this.b = "";
        this.c = 0;
        this.d = 0;
        this.e = "";
        this.f = 28;
    }

    public String a() {
        return this.f420a;
    }

    public Object clone() {
        return super.clone();
    L5:
        if (h == false) goto L9;
        return null;
    L9:
        throw new AssertionError();
    }

    @Override // com.qq.taf.jce.JceStruct
    public void display(StringBuilder r2, int r3) {
        JceDisplayer r0 = new JceDisplayer(r2, r3);
        r0.display(this.f420a, "url");
        r0.display(this.b, "ext");
        r0.display(this.c, "seq");
        r0.display(this.d, "version");
        r0.display(this.e, "guid");
        r0.display(this.f, "appId");
        r0.display(this.g, "languageInfo");
    }

    @Override // com.qq.taf.jce.JceStruct
    public void displaySimple(StringBuilder r2, int r3) {
        JceDisplayer r0 = new JceDisplayer(r2, r3);
        r0.displaySimple(this.f420a, true);
        r0.displaySimple(this.b, true);
        r0.displaySimple(this.c, true);
        r0.displaySimple(this.d, true);
        r0.displaySimple(this.e, true);
        r0.displaySimple(this.f, false);
        r0.displaySimple(this.g, false);
    }

    public boolean equals(Object r4) {
        if (r4 != null) goto L5;
        return false;
    L5:
        pf r5 = (pf) r4;
        if (a8.a(this.f420a, r5.f420a) == true) goto L8;
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
        if (a8.a(this.g, r5.g) == false) goto L27;
        return true;
    L27:
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
        this.f420a = r4.readString(0, true);
        this.b = r4.readString(1, false);
        this.c = r4.read(this.c, 2, false);
        this.d = r4.read(this.d, 3, false);
        this.e = r4.readString(4, false);
        this.f = r4.read(this.f, 5, false);
        this.g = (g8) r4.read(this.g, 8, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream r3) {
        r3.write(this.f420a, 0);
        String r0 = this.b;
        if (r0 == null) goto L5;
        r3.write(r0, 1);
    L5:
        r3.write(this.c, 2);
        r3.write(this.d, 3);
        String r1 = this.e;
        if (r1 == null) goto L8;
        r3.write(r1, 4);
    L8:
        r3.write(this.f, 5);
        g8 r2 = this.g;
        if (r2 == null) goto L12;
        r3.write(r2, 8);
        return;
    }

    public void a(String r1) {
        this.f420a = r1;
    }
}
