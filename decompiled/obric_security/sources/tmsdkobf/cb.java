package tmsdkobf;

import com.bytedance.librarian.LibrarianImpl;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tmsdk.common.OfflineVideo;

/* JADX INFO: loaded from: classes5.dex */
public class cb extends v9 {
    public cb() {
    }

    private String a(String r8) {
        String[] r0 = new File(r8).list();     // Catch: Error -> L21
        if (r0 == null) goto L19;
        int r1 = r0.length;     // Catch: Error -> L21
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L31;
        String r3 = r0[r2];     // Catch: Error -> L21
        File r4 = new File(r8 + LibrarianImpl.Constants.SEPARATOR + r3);     // Catch: Error -> L21
        if (r4.isDirectory() == false) goto L12;
        String r5 = a(r4.getAbsolutePath());     // Catch: Error -> L21
        if (r5 == null) goto L16;
        return r5;
    L16:
        r2 = r2 + 1;     // Catch: Error -> L21
        goto L5
    L12:
        if (r3.endsWith(".db") == true) goto L17;
        if (r3.endsWith("tmv") == false) goto L16;
    L17:
        return r4.getAbsolutePath();
    L31:
        return null;
    L19:
        return null;
    L30:
        return null;
    }

    private OfflineVideo b(String r5) {
        long r0 = y9.d(r5);
        if (r0 != 0) goto L6;
        return null;
    L6:
        OfflineVideo r2 = new OfflineVideo();
        r2.mPath = r5;
        r2.mSize = r0;
        r2.mTitle = ac.c(r5);
        r2.mThumnbailPath = a(r5);
        return r2;
    }

    @Override // tmsdkobf.v9
    public List a(w9 r4) {
        List r5 = y9.b(r4.b);
        if (r5 != null) goto L5;
        return null;
    L5:
        if (r5.size() == 0) goto L24;
        ArrayList r1 = new ArrayList();
        Iterator r6 = r5.iterator();
    L9:
        if (r6.hasNext() == false) goto L14;
        OfflineVideo r2 = b((String) r6.next());
        if (r2 == null) goto L9;
        r1.add(r2);
        goto L9
    L14:
        if (r1.size() != 0) goto L17;
        return null;
    L17:
        return r1;
    L24:
        return null;
    }
}
