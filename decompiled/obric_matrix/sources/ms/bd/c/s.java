package ms.bd.c;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes2.dex */
public abstract class s extends b.a {
    public s() {
    }

    @Override // ms.bd.c.b.a
    public Object a(int r10, int r11, long r12, String r14, Object r15) {
        if (e0.f(new String[]{(String) m.a(16777217, 0, 0, "b9bb68", new byte[]{114, 53, 21, 4, 6, 38, 101, 86, 35, 55, 97, 54, 24, 5, 26, 38, 110, 22, 125, 27, 93, 15, 52, 36, 39, 10, 85})}) == true) goto L6;
        return null;
    L6:
        switch(r10) {
            case 196609: goto L13;
            case 196610: goto L11;
            case 196611: goto L9;
            default: goto L8;
        };
    L9:
        Object[] r16 = (Object[]) r15;
        return e(r14, (String) r16[0], (String) r16[1]);
    L11:
        Object[] r17 = (Object[]) r15;
        return g(r14, (String) r17[0], (String) r17[1]);
    L13:
        Object[] r18 = (Object[]) r15;
        return f(r14, (byte[]) r18[0], (String) r18[1], (String) r18[2]);
    L8:
        return super.a(r10, r11, r12, r14, r15);
    }

    protected void c(InputStream r7) {
        if (r7 == null) goto L9;
        r7.close();     // Catch: IOException -> L5
        return;
    L5:
        String r6 = (String) m.a(16777217, 0, 0, "6768b6", new byte[]{42, 54, 122, 79, 84});
        return;
    }

    protected void d(OutputStream r7) {
        if (r7 == null) goto L9;
        r7.close();     // Catch: IOException -> L5
        return;
    L5:
        String r6 = (String) m.a(16777217, 0, 0, "14763b", new byte[]{45, 53, 123, 65, 3});
        return;
    }

    public abstract Object[] e(String r1, String r2, String r3);

    public abstract Object[] f(String r1, byte[] r2, String r3, String r4);

    public abstract Object[] g(String r1, String r2, String r3);
}
