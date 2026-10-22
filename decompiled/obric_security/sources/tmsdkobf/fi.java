package tmsdkobf;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public final class fi extends i3 implements Cloneable {
    public static Map h = null;
    public static Map i = null;
    public static Map j = null;
    public static final /* synthetic */ boolean k = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f205a;
    public boolean b;
    public long c;
    public Map d;
    public Map e;
    public long f;
    public Map g;

    public fi() {
        this.f205a = 0;
        this.b = true;
        this.c = 0;
        this.d = null;
        this.e = null;
        this.f = 0;
        this.g = null;
    }

    @Override // tmsdkobf.i3
    public void a(i2 r4) {
        r4.a(this.f205a, 0);
        r4.a(this.b ? 1 : 0, 1);
        r4.a(this.c, 2);
        r4.a(this.d, 3);
        r4.a(this.e, 4);
        r4.a(this.f, 5);
        Map r3 = this.g;
        if (r3 == null) goto L6;
        r4.a(r3, 6);
        return;
    }

    public Object clone() {
        return super.clone();
    L5:
        if (k == false) goto L9;
        return null;
    L9:
        throw new AssertionError();
    }

    public boolean equals(Object r6) {
        if (r6 != null) goto L5;
        return false;
    L5:
        fi r7 = (fi) r6;
        if (n3.a(this.f205a, r7.f205a) == true) goto L8;
        return false;
    L8:
        if (this.b == r7.b) goto L10;
        return false;
    L10:
        if (n3.a(this.c, r7.c) == true) goto L12;
        return false;
    L12:
        if (this.d.equals(r7.d) == true) goto L14;
        return false;
    L14:
        if (this.e.equals(r7.e) == true) goto L16;
        return false;
    L16:
        if (n3.a(this.f, r7.f) == true) goto L18;
        return false;
    L18:
        if (this.g.equals(r7.g) == false) goto L27;
        return true;
    L27:
        return false;
    }

    public int hashCode() {
    L4:
        e = move-exception;
        e.printStackTrace();
        return 0;
    L3:
        throw new Exception("");     // Catch: Exception -> L4
    }

    @Override // tmsdkobf.i3
    public void a(y1 r6) {
        this.f205a = r6.a(this.f205a, 0, true);
        this.b = r6.a(this.b, 1, true);
        this.c = r6.a(this.c, 2, true);
        this.d = (Map) r6.a(h, 3, true);
        this.e = (Map) r6.a(i, 4, true);
        this.f = r6.a(this.f, 5, true);
        this.g = (Map) r6.a(j, 6, false);
    }

    static {
        HashMap r0 = new HashMap();
        h = r0;
        r0.put("", "");
        i = new HashMap();
        i.put(0, 0);
        HashMap r1 = new HashMap();
        j = r1;
        r1.put("", "");
    }
}
