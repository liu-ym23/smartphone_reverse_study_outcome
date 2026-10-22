package tmsdkobf;

import com.bytedance.librarian.LibrarianImpl;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tmsdk.common.OfflineVideo;

/* JADX INFO: loaded from: classes5.dex */
public class ie extends v9 {
    public ie() {
    }

    private OfflineVideo a(String r8) {
        String r7 = ac.c(r8);
        if (r7 != null) goto L5;
        return null;
    L5:
        long r1 = y9.d(r8);
        if (r1 > 0) goto L8;
        return null;
    L8:
        OfflineVideo r0 = new OfflineVideo();
        r0.mPath = r8;
        r0.mSize = r1;
        r0.mTitle = r7;
        String[] r2 = new File(r8).list();
        if (r2 == null) goto L16;
        int r3 = r2.length;
        int r4 = 0;
    L11:
        if (r4 >= r3) goto L16;
        String r5 = r2[r4];
        if (r5.startsWith(r7 + "_") == true) goto L14;
        r4 = r4 + 1;
        goto L11
    L14:
        r0.mThumnbailPath = r8 + LibrarianImpl.Constants.SEPARATOR + r5;
    L16:
        return r0;
    }

    @Override // tmsdkobf.v9
    public List a(w9 r3) {
        List r4 = y9.b(r3.b);
        ArrayList r0 = new ArrayList();
        Iterator r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        OfflineVideo r1 = a((String) r5.next());
        if (r1 == null) goto L4;
        r0.add(r1);
        goto L4
    L8:
        return r0;
    }
}
