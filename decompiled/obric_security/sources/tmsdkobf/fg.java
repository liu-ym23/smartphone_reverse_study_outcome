package tmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* JADX INFO: loaded from: classes5.dex */
public final class fg extends JceStruct {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f203a;
    public String b;
    public String c;
    public String d;
    public long e;
    public String f;
    public String g;
    public String h;

    public fg() {
        this.f203a = "";
        this.b = "";
        this.c = "";
        this.d = "";
        this.e = 0;
        this.f = "";
        this.g = "";
        this.h = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public JceStruct newInit() {
        return new fg();
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream r5) {
        this.f203a = r5.readString(0, false);
        this.b = r5.readString(1, false);
        this.c = r5.readString(2, false);
        this.d = r5.readString(3, false);
        this.e = r5.read(this.e, 4, false);
        this.f = r5.readString(5, false);
        this.g = r5.readString(6, false);
        this.h = r5.readString(7, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream r5) {
        String r0 = this.f203a;
        if (r0 == null) goto L5;
        r5.write(r0, 0);
    L5:
        String r1 = this.b;
        if (r1 == null) goto L8;
        r5.write(r1, 1);
    L8:
        String r2 = this.c;
        if (r2 == null) goto L11;
        r5.write(r2, 2);
    L11:
        String r3 = this.d;
        if (r3 == null) goto L14;
        r5.write(r3, 3);
    L14:
        long r4 = this.e;
        if (r4 == 0) goto L17;
        r5.write(r4, 4);
    L17:
        String r6 = this.f;
        if (r6 == null) goto L20;
        r5.write(r6, 5);
    L20:
        String r7 = this.g;
        if (r7 == null) goto L23;
        r5.write(r7, 6);
    L23:
        String r8 = this.h;
        if (r8 == null) goto L27;
        r5.write(r8, 7);
        return;
    }
}
