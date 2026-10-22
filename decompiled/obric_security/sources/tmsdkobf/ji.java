package tmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public final class ji extends JceStruct {
    static ArrayList h;
    static Map i;
    static ArrayList j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f293a;
    public ArrayList b;
    public int c;
    public boolean d;
    public int e;
    public Map f;
    public ArrayList g;

    static {
        ArrayList r0 = new ArrayList();
        h = r0;
        r0.add("");
        HashMap r1 = new HashMap();
        i = r1;
        r1.put("", "");
        ArrayList r2 = new ArrayList();
        j = r2;
        r2.add("");
    }

    public ji() {
        this.f293a = 0;
        this.b = null;
        this.c = 0;
        this.d = false;
        this.e = 0;
        this.f = null;
        this.g = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public JceStruct newInit() {
        return new ji();
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream r5) {
        this.f293a = r5.read(this.f293a, 0, true);
        this.b = (ArrayList) r5.read(h, 1, true);
        this.c = r5.read(this.c, 2, true);
        this.d = r5.read(this.d, 3, false);
        this.e = r5.read(this.e, 4, false);
        this.f = (Map) r5.read(i, 5, false);
        this.g = (ArrayList) r5.read(j, 6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream r3) {
        r3.write(this.f293a, 0);
        r3.write(this.b, 1);
        r3.write(this.c, 2);
        r3.write(this.d, 3);
        r3.write(this.e, 4);
        Map r0 = this.f;
        if (r0 == null) goto L5;
        r3.write(r0, 5);
    L5:
        ArrayList r2 = this.g;
        if (r2 == null) goto L9;
        r3.write(r2, 6);
        return;
    }
}
