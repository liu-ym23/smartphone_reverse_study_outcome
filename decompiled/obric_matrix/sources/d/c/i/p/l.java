package d.c.i.p;

import android.net.Uri;
import android.util.Base64;
import java.io.ByteArrayInputStream;

/* JADX INFO: loaded from: classes2.dex */
public class l extends a0 {
    public l(d.c.c.g.i r2) {
        super(d.c.c.b.b.a(), r2);
    }

    static byte[] g(String r4) {
        d.c.c.d.i.b(r4.substring(0, 5).equals("data:"));
        int r1 = r4.indexOf(44);
        String r2 = r4.substring(r1 + 1, r4.length());
        if (h(r4.substring(0, r1)) == false) goto L7;
        return Base64.decode(r2, 0);
    L7:
        return Uri.decode(r2).getBytes();
    }

    static boolean h(String r2) {
        if (r2.contains(";") == true) goto L6;
        return false;
    L6:
        String[] r3 = r2.split(";");
        return r3[r3.length - 1].equals("base64");
    }

    @Override // d.c.i.p.a0
    protected d.c.i.l.e d(d.c.i.q.b r2) {
        byte[] r3 = g(r2.v().toString());
        return c(new ByteArrayInputStream(r3), r3.length);
    }

    @Override // d.c.i.p.a0
    protected String f() {
        return "DataFetchProducer";
    }
}
