package tmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* JADX INFO: loaded from: classes5.dex */
public final class bg extends JceStruct {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f119a;
    public String b;
    public String c;
    public long d;
    public long e;
    public int f;

    public bg() {
        this.f119a = "";
        this.b = "";
        this.c = "";
        this.d = 0;
        this.e = 0;
        this.f = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream r5) {
        this.f119a = r5.readString(0, false);
        this.b = r5.readString(1, false);
        this.c = r5.readString(2, false);
        this.d = r5.read(this.d, 3, false);
        this.e = r5.read(this.e, 4, false);
        this.f = r5.read(this.f, 5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream r6) {
        String r0 = this.f119a;
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
        long r4 = this.e;
        if (r4 == 0) goto L17;
        r6.write(r4, 4);
    L17:
        int r5 = this.f;
        if (r5 == 0) goto L21;
        r6.write(r5, 5);
        return;
    }
}
