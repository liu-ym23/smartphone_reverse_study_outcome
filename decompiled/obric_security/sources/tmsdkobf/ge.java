package tmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* JADX INFO: loaded from: classes5.dex */
public final class ge extends JceStruct {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f218a;
    public String b;
    public String c;
    public long d;
    public boolean e;
    public String f;
    public String g;
    public long h;
    public String i;
    public long j;

    public ge() {
        this.f218a = "";
        this.b = "";
        this.c = "";
        this.d = 0;
        this.e = true;
        this.f = "";
        this.g = "";
        this.h = 0;
        this.i = "";
        this.j = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public JceStruct newInit() {
        return new ge();
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream r5) {
        this.f218a = r5.readString(0, false);
        this.b = r5.readString(1, false);
        this.c = r5.readString(2, false);
        this.d = r5.read(this.d, 3, false);
        this.e = r5.read(this.e, 4, false);
        this.f = r5.readString(5, false);
        this.g = r5.readString(6, false);
        this.h = r5.read(this.h, 7, false);
        this.i = r5.readString(8, false);
        this.j = r5.read(this.j, 9, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream r6) {
        String r0 = this.f218a;
        if (r0 == null) goto L5;
        r6.write(r0, 0);
    L5:
        String r1 = this.b;
        if (r1 == null) goto L8;
        r6.write(r1, 1);
    L8:
        String r2 = this.c;
        if (r2 == null) goto L11;
        r6.write(r2, 2);
    L11:
        long r3 = this.d;
        if (r3 == 0) goto L14;
        r6.write(r3, 3);
    L14:
        r6.write(this.e, 4);
        String r4 = this.f;
        if (r4 == null) goto L17;
        r6.write(r4, 5);
    L17:
        String r5 = this.g;
        if (r5 == null) goto L20;
        r6.write(r5, 6);
    L20:
        long r7 = this.h;
        if (r7 == 0) goto L23;
        r6.write(r7, 7);
    L23:
        String r8 = this.i;
        if (r8 == null) goto L26;
        r6.write(r8, 8);
    L26:
        long r9 = this.j;
        if (r9 == 0) goto L30;
        r6.write(r9, 9);
        return;
    }
}
