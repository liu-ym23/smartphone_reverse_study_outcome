package tmsdkobf;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public final class q extends i3 {
    public static byte[] k = null;
    public static Map l = null;
    public static final /* synthetic */ boolean m = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public short f425a;
    public byte b;
    public int c;
    public int d;
    public String e;
    public String f;
    public byte[] g;
    public int h;
    public Map i;
    public Map j;

    static {
    }

    public q() {
        this.f425a = 0;
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = null;
        this.f = null;
        this.h = 0;
    }

    @Override // tmsdkobf.i3
    public void a(i2 r3) {
        r3.a(this.f425a, 1);
        r3.a(this.b, 2);
        r3.a(this.c, 3);
        r3.a(this.d, 4);
        r3.a(this.e, 5);
        r3.a(this.f, 6);
        r3.a(this.g, 7);
        r3.a(this.h, 8);
        r3.a(this.i, 9);
        r3.a(this.j, 10);
    }

    public Object clone() {
        return super.clone();
    L5:
        if (m == false) goto L9;
        return null;
    L9:
        throw new AssertionError();
    }

    public boolean equals(Object r3) {
        q r4 = (q) r3;
        Integer r1 = 1;
        if (n3.a(1, r4.f425a) == true) goto L5;
    L23:
        return false;
    L5:
        if (n3.a(1, r4.b) == false) goto L23;
        if (n3.a(1, r4.c) == false) goto L23;
        if (n3.a(1, r4.d) == false) goto L23;
        if (r1.equals(r4.e) == false) goto L23;
        if (r1.equals(r4.f) == false) goto L23;
        if (r1.equals(r4.g) == false) goto L23;
        if (n3.a(1, r4.h) == false) goto L23;
        if (r1.equals(r4.i) == false) goto L23;
        if (r1.equals(r4.j) == false) goto L23;
        return true;
    }

    @Override // tmsdkobf.i3
    public void a(y1 r11) {
        int r1 = 0;
        this.f425a = r11.a(this.f425a, 1, true);     // Catch: Exception -> L15
        this.b = r11.a(this.b, 2, true);     // Catch: Exception -> L15
        this.c = r11.a(this.c, 3, true);     // Catch: Exception -> L15
        this.d = r11.a(this.d, 4, true);     // Catch: Exception -> L15
        this.e = r11.b(5, true);     // Catch: Exception -> L15
        this.f = r11.b(6, true);     // Catch: Exception -> L15
        if (k != null) goto L6;
        k = new byte[]{0};     // Catch: Exception -> L15
    L6:
        this.g = r11.a(7, true);     // Catch: Exception -> L15
        this.h = r11.a(this.h, 8, true);     // Catch: Exception -> L15
        if (l != null) goto L10;
        HashMap r3 = new HashMap();     // Catch: Exception -> L15
        l = r3;     // Catch: Exception -> L15
        r3.put("", "");     // Catch: Exception -> L15
    L10:
        this.i = (Map) r11.a(l, 9, true);     // Catch: Exception -> L15
        if (l != null) goto L13;
        HashMap r4 = new HashMap();     // Catch: Exception -> L15
        l = r4;     // Catch: Exception -> L15
        r4.put("", "");     // Catch: Exception -> L15
    L13:
        this.j = (Map) r11.a(l, 10, true);     // Catch: Exception -> L15
        return;
    L15:
        e = move-exception;
        e.printStackTrace();
        PrintStream r5 = System.out;
        StringBuilder r6 = p.a("RequestPacket decode error ");
        byte[] r10 = this.g;
        if (r10 != null) goto L19;
    L25:
        String r12 = null;
    L26:
        r5.println(r6.append(r12).toString());
        throw new RuntimeException(e);
    L19:
        if (r10.length == 0) goto L25;
        char[] r2 = new char[r10.length * 2];
    L22:
        if (r1 >= r10.length) goto L24;
        byte r7 = r10[r1];
        int r8 = r1 * 2;
        char[] r9 = u8.f550a;
        r2[r8 + 1] = r9[r7 & 15];
        r2[r8] = r9[((byte) (r7 >>> 4)) & 15];
        r1 = r1 + 1;
        goto L22
    L24:
        r12 = new String(r2);
        goto L26
    }
}
