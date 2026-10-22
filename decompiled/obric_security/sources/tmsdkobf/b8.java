package tmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* JADX INFO: loaded from: classes5.dex */
public final class b8 extends JceStruct {
    static byte[] i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f113a;
    public int b;
    public int c;
    public long d;
    public String e;
    public byte[] f;
    public boolean g;
    public short h;

    static {
        i = new byte[]{0};
    }

    public b8() {
        this.f113a = 0;
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = "";
        this.f = null;
        this.g = false;
        this.h = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public JceStruct newInit() {
        return new b8();
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream r5) {
        this.f113a = r5.read(this.f113a, 0, false);
        this.b = r5.read(this.b, 1, false);
        this.c = r5.read(this.c, 2, false);
        this.d = r5.read(this.d, 3, false);
        this.e = r5.readString(4, false);
        this.f = r5.read(i, 5, false);
        this.g = r5.read(this.g, 6, false);
        this.h = r5.read(this.h, 7, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream r5) {
        int r0 = this.f113a;
        if (r0 == 0) goto L5;
        r5.write(r0, 0);
    L5:
        int r1 = this.b;
        if (r1 == 0) goto L8;
        r5.write(r1, 1);
    L8:
        int r2 = this.c;
        if (r2 == 0) goto L11;
        r5.write(r2, 2);
    L11:
        long r3 = this.d;
        if (r3 == 0) goto L14;
        r5.write(r3, 3);
    L14:
        String r4 = this.e;
        if (r4 == null) goto L17;
        r5.write(r4, 4);
    L17:
        byte[] r6 = this.f;
        if (r6 == null) goto L20;
        r5.write(r6, 5);
    L20:
        boolean r7 = this.g;
        if (r7 == false) goto L23;
        r5.write(r7, 6);
    L23:
        short r8 = this.h;
        if (r8 == 0) goto L27;
        r5.write(r8, 7);
        return;
    }
}
