package tmsdkobf;

import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ta {
    private static int a(int r0) {
        int r1 = r0 + 1;
        if (r1 >= 0) goto L6;
        return 0;
    L6:
        return r1;
    }

    public static boolean a(f1 r10, f1 r11) {
        if (r10 != null) goto L7;
        if (r11 != null) goto L7;
        return true;
    L7:
        if (r10 == null) goto L49;
        if (r11 == null) goto L49;
        if (r11.e != r10.e) goto L49;
        if (r11.f193a != r10.f193a) goto L49;
        ArrayList r2 = r11.d;
        if (r2 == null) goto L18;
    L20:
        ArrayList r3 = r10.d;
        if (r2 == r3) goto L26;
        if (r2 == null) goto L24;
        if (r3 != null) goto L26;
    L24:
        return false;
    L26:
        if (r2.size() == r10.d.size()) goto L28;
        return false;
    L28:
        int r4 = r11.d.size();
        int r5 = 0;
    L29:
        if (r5 >= r4) goto L48;
        byte[] r6 = (byte[]) r11.d.get(r5);
        byte[] r7 = (byte[]) r10.d.get(r5);
        if (r6 != null) goto L34;
        if (r7 != null) goto L34;
    L47:
        r5 = r5 + 1;
    L34:
        if (r6 == r7) goto L39;
        if (r6 == null) goto L37;
        if (r7 != null) goto L39;
    L37:
        return false;
    L39:
        if (r6.length != r7.length) goto L40;
        int r8 = r6.length;
        int r9 = 0;
    L42:
        if (r9 >= r8) goto L47;
        if (r6[r9] != r7[r9]) goto L45;
        r9 = r9 + 1;
        goto L42
    L45:
        return false;
    L40:
        return false;
    L48:
        return true;
    L18:
        if (r10.d != null) goto L20;
        return true;
    L49:
        return false;
    }

    public static final f1 a(byte[] r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        return (f1) e3.a(null, r2, new f1());
    }

    public static final void a(String r0, String r1) {
        r8.a(r0, r1);
    }

    public static f1 a(int r4, int r5, ArrayList r6) {
        f1 r0 = new f1();
        r0.f193a = r4;
        r0.e = r5;
        if (r6 != null) goto L5;
        r0.d = null;
    L11:
        if (r5 == 0) goto L16;
        f1 r7 = sa.b().b(r4);
        if (r7 == null) goto L16;
        int r8 = r7.c;
    L17:
        r0.b = r8;
        r0.c = a(r0.b);
        return r0;
    L16:
        r8 = 0;
        goto L17
    L5:
        r0.d = new ArrayList();
        Iterator r9 = r6.iterator();
    L7:
        if (r9.hasNext() == false) goto L11;
        JceStruct r1 = (JceStruct) r9.next();
        if (r1 == null) goto L7;
        r0.d.add(r1.toByteArray("UTF-8"));
        goto L7
    }

    public static final byte[] a(JceStruct r1) {
        if (r1 != null) goto L6;
        return null;
    L6:
        return e3.a(null, r1);
    }
}
