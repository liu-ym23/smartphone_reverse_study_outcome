package tmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* JADX INFO: loaded from: classes5.dex */
public final class sg extends JceStruct {
    static ah l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f512a;
    public int b;
    public String c;
    public String d;
    public String e;
    public int f;
    public int g;
    public long h;
    public int i;
    public String j;
    public ah k;

    static {
        l = new ah();
    }

    public sg() {
        this.f512a = 2;
        this.b = 0;
        this.c = "";
        this.d = "";
        this.e = "";
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.i = 0;
        this.j = "";
        this.k = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public JceStruct newInit() {
        return new sg();
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream r5) {
        this.f512a = r5.read(this.f512a, 0, true);
        this.b = r5.read(this.b, 1, true);
        this.c = r5.readString(2, false);
        this.d = r5.readString(3, false);
        this.e = r5.readString(4, false);
        this.f = r5.read(this.f, 5, false);
        this.g = r5.read(this.g, 6, false);
        this.h = r5.read(this.h, 7, false);
        this.i = r5.read(this.i, 8, false);
        this.j = r5.readString(9, false);
        this.k = (ah) r5.read(l, 10, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream r5) {
        r5.write(this.f512a, 0);
        r5.write(this.b, 1);
        String r0 = this.c;
        if (r0 == null) goto L5;
        r5.write(r0, 2);
    L5:
        String r1 = this.d;
        if (r1 == null) goto L8;
        r5.write(r1, 3);
    L8:
        String r2 = this.e;
        if (r2 == null) goto L11;
        r5.write(r2, 4);
    L11:
        int r3 = this.f;
        if (r3 == 0) goto L14;
        r5.write(r3, 5);
    L14:
        int r4 = this.g;
        if (r4 == 0) goto L17;
        r5.write(r4, 6);
    L17:
        long r6 = this.h;
        if (r6 == 0) goto L20;
        r5.write(r6, 7);
    L20:
        int r7 = this.i;
        if (r7 == 0) goto L23;
        r5.write(r7, 8);
    L23:
        String r8 = this.j;
        if (r8 == null) goto L26;
        r5.write(r8, 9);
    L26:
        ah r9 = this.k;
        if (r9 == null) goto L30;
        r5.write(r9, 10);
        return;
    }
}
