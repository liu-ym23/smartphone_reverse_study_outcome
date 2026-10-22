package tmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* JADX INFO: loaded from: classes5.dex */
public final class cd extends JceStruct {
    static fg g;
    static k h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f129a;
    public int b;
    public int c;
    public int d;
    public fg e;
    public k f;

    static {
        g = new fg();
        h = new k();
    }

    public cd() {
        this.f129a = "";
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = null;
        this.f = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public JceStruct newInit() {
        return new cd();
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream r5) {
        this.f129a = r5.readString(0, true);
        this.b = r5.read(this.b, 1, true);
        this.c = r5.read(this.c, 2, true);
        this.d = r5.read(this.d, 3, false);
        this.e = (fg) r5.read(g, 4, false);
        this.f = (k) r5.read(h, 5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream r3) {
        r3.write(this.f129a, 0);
        r3.write(this.b, 1);
        r3.write(this.c, 2);
        r3.write(this.d, 3);
        fg r0 = this.e;
        if (r0 == null) goto L5;
        r3.write(r0, 4);
    L5:
        k r2 = this.f;
        if (r2 == null) goto L9;
        r3.write(r2, 5);
        return;
    }
}
