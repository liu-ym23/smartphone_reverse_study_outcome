package tmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* JADX INFO: loaded from: classes5.dex */
public final class vi extends JceStruct {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f585a;
    public String b;
    public int c;
    public String d;
    public int e;
    public int f;
    public int g;

    public vi() {
        this.f585a = 20;
        this.b = "";
        this.c = 0;
        this.d = "";
        this.e = 0;
        this.f = 0;
        this.g = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public JceStruct newInit() {
        return new vi();
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream r4) {
        this.f585a = r4.read(this.f585a, 0, false);
        this.b = r4.readString(1, false);
        this.c = r4.read(this.c, 2, false);
        this.d = r4.readString(3, false);
        this.e = r4.read(this.e, 4, false);
        this.f = r4.read(this.f, 5, false);
        this.g = r4.read(this.g, 6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream r3) {
        int r0 = this.f585a;
        if (20 == r0) goto L5;
        r3.write(r0, 0);
    L5:
        String r1 = this.b;
        if (r1 == null) goto L8;
        r3.write(r1, 1);
    L8:
        int r2 = this.c;
        if (r2 == 0) goto L11;
        r3.write(r2, 2);
    L11:
        String r4 = this.d;
        if (r4 == null) goto L14;
        r3.write(r4, 3);
    L14:
        r3.write(this.e, 4);
        int r5 = this.f;
        if (r5 == 0) goto L17;
        r3.write(r5, 5);
    L17:
        int r6 = this.g;
        if (r6 == 0) goto L21;
        r3.write(r6, 6);
        return;
    }
}
