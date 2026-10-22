package tmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public final class sb extends JceStruct {
    static byte[] i;
    static byte[] j;
    static Map k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f508a;
    public byte[] b;
    public String c;
    public byte[] d;
    public long e;
    public Map f;
    public int g;
    public int h;

    static {
        i = new byte[]{0};
        j = new byte[]{0};
        k = new HashMap();
        ArrayList r3 = new ArrayList();
        r3.add(new byte[]{0});
        k.put(0, r3);
    }

    public sb() {
        this.f508a = 0;
        this.b = null;
        this.c = "";
        this.d = null;
        this.e = 0;
        this.f = null;
        this.g = 0;
        this.h = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public JceStruct newInit() {
        return new sb();
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream r5) {
        this.f508a = r5.read(this.f508a, 0, true);
        this.b = r5.read(i, 1, false);
        this.c = r5.readString(2, false);
        this.d = r5.read(j, 3, false);
        this.e = r5.read(this.e, 4, false);
        this.f = (Map) r5.read(k, 5, false);
        this.g = r5.read(this.g, 6, false);
        this.h = r5.read(this.h, 7, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream r5) {
        r5.write(this.f508a, 0);
        byte[] r0 = this.b;
        if (r0 == null) goto L5;
        r5.write(r0, 1);
    L5:
        String r1 = this.c;
        if (r1 == null) goto L8;
        r5.write(r1, 2);
    L8:
        byte[] r2 = this.d;
        if (r2 == null) goto L11;
        r5.write(r2, 3);
    L11:
        long r3 = this.e;
        if (r3 == 0) goto L14;
        r5.write(r3, 4);
    L14:
        Map r4 = this.f;
        if (r4 == null) goto L17;
        r5.write(r4, 5);
    L17:
        int r6 = this.g;
        if (r6 == 0) goto L20;
        r5.write(r6, 6);
    L20:
        int r7 = this.h;
        if (r7 == 0) goto L24;
        r5.write(r7, 7);
        return;
    }
}
