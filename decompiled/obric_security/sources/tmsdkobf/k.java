package tmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes5.dex */
public final class k extends JceStruct {
    static ArrayList r;
    static ArrayList s;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f296a;
    public String b;
    public String c;
    public int d;
    public String e;
    public long f;
    public int g;
    public String h;
    public String i;
    public boolean j;
    public String k;
    public ArrayList l;
    public int m;
    public String n;
    public ArrayList o;
    public String p;
    public String q;

    static {
        ArrayList r0 = new ArrayList();
        r = r0;
        r0.add("");
        ArrayList r1 = new ArrayList();
        s = r1;
        r1.add("");
    }

    public k() {
        this.f296a = "";
        this.b = "";
        this.c = "";
        this.d = 0;
        this.e = "";
        this.f = 0;
        this.g = 0;
        this.h = "";
        this.i = "";
        this.j = true;
        this.k = "";
        this.l = null;
        this.m = 0;
        this.n = "";
        this.o = null;
        this.p = "";
        this.q = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public JceStruct newInit() {
        return new k();
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream r5) {
        this.f296a = r5.readString(0, false);
        this.b = r5.readString(1, false);
        this.c = r5.readString(2, false);
        this.d = r5.read(this.d, 3, false);
        this.e = r5.readString(4, false);
        this.f = r5.read(this.f, 5, false);
        this.g = r5.read(this.g, 6, false);
        this.h = r5.readString(7, false);
        this.i = r5.readString(8, false);
        this.j = r5.read(this.j, 9, false);
        this.k = r5.readString(10, false);
        this.l = (ArrayList) r5.read(r, 11, false);
        this.m = r5.read(this.m, 12, false);
        this.n = r5.readString(13, false);
        this.o = (ArrayList) r5.read(s, 14, false);
        this.p = r5.readString(15, false);
        this.q = r5.readString(16, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream r7) {
        String r0 = this.f296a;
        if (r0 == null) goto L5;
        r7.write(r0, 0);
    L5:
        String r1 = this.b;
        if (r1 == null) goto L8;
        r7.write(r1, 1);
    L8:
        String r2 = this.c;
        if (r2 == null) goto L11;
        r7.write(r2, 2);
    L11:
        int r3 = this.d;
        if (r3 == 0) goto L14;
        r7.write(r3, 3);
    L14:
        String r4 = this.e;
        if (r4 == null) goto L17;
        r7.write(r4, 4);
    L17:
        long r5 = this.f;
        if (r5 == 0) goto L20;
        r7.write(r5, 5);
    L20:
        int r6 = this.g;
        if (r6 == 0) goto L23;
        r7.write(r6, 6);
    L23:
        String r8 = this.h;
        if (r8 == null) goto L26;
        r7.write(r8, 7);
    L26:
        String r9 = this.i;
        if (r9 == null) goto L29;
        r7.write(r9, 8);
    L29:
        boolean r10 = this.j;
        if (r10 == true) goto L32;
        r7.write(r10, 9);
    L32:
        String r11 = this.k;
        if (r11 == null) goto L35;
        r7.write(r11, 10);
    L35:
        ArrayList r12 = this.l;
        if (r12 == null) goto L38;
        r7.write(r12, 11);
    L38:
        int r13 = this.m;
        if (r13 == 0) goto L41;
        r7.write(r13, 12);
    L41:
        String r14 = this.n;
        if (r14 == null) goto L44;
        r7.write(r14, 13);
    L44:
        ArrayList r15 = this.o;
        if (r15 == null) goto L47;
        r7.write(r15, 14);
    L47:
        String r16 = this.p;
        if (r16 == null) goto L50;
        r7.write(r16, 15);
    L50:
        String r17 = this.q;
        if (r17 == null) goto L54;
        r7.write(r17, 16);
        return;
    }
}
