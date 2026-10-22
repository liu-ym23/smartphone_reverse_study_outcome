package tmsdkobf;

import com.bytedance.librarian.LibrarianImpl;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tmsdk.common.OfflineVideo;

/* JADX INFO: loaded from: classes5.dex */
public class ib extends v9 {
    public ib() {
    }

    private String a(OfflineVideo r8) {
        String[] r7 = new File(r8.mPath).list();
        if (r7 == null) goto L14;
        int r0 = r7.length;
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L20;
        String r2 = r7[r1];
        if (r2.endsWith(".f4v") == false) goto L9;
    L10:
        String r3 = r8.mPath + LibrarianImpl.Constants.SEPARATOR + r2;
        if (new File(r3).length() <= 1048576) goto L13;
        return r3;
    L13:
        r1 = r1 + 1;
        goto L5
    L9:
        if (r2.endsWith(".mp4") == false) goto L13;
    L20:
        return null;
    L14:
        return null;
    }

    private OfflineVideo a(String r7) {
        String r0 = ac.c(r7);
        OfflineVideo r1 = new OfflineVideo();
        r1.mPath = r7;
        long r2 = y9.d(r7);
        r1.mSize = r2;
        if (r2 >= 1048576) goto L6;
        return null;
    L6:
        List r8 = y9.e(r7 + LibrarianImpl.Constants.SEPARATOR + r0 + ".qiyicfg");
        if (r8 != null) goto L9;
    L32:
        String r6 = a(r1);
        r1.mThumnbailPath = r6;
        r1.mTitle = ac.d(r6);
        return r1;
    L9:
        if (r8.size() == 0) goto L32;
        Iterator r9 = r8.iterator();
    L13:
        if (r9.hasNext() == false) goto L29;
        String r3 = (String) r9.next();
        if (r3.startsWith("progress=") == true) goto L34;
        if (r3.startsWith("text=") == true) goto L22;
        if (r3.startsWith("imgUrl=") == false) goto L13;
        r1.mThumnbailPath = r1.mPath.replaceFirst("files/.*", "cache/images/default/" + y9.c(r3.substring(7).replaceAll("\\\\", "")) + ".r");
        if (new File(r1.mThumnbailPath).exists() == true) goto L13;
        r1.mThumnbailPath = a(r1);
        goto L13
    L22:
        r1.mTitle = y9.a(r3.substring(5));
        goto L13
    L34:
        r1.mDownProgress = (int) Float.parseFloat(r3.substring(9));     // Catch: Exception -> L19
    L19:
        r1.mDownProgress = -1;
        goto L13
    L29:
        if (r1.mThumnbailPath != null) goto L31;
        r1.mThumnbailPath = a(r1);
    L31:
        return r1;
    }

    @Override // tmsdkobf.v9
    public List a(w9 r3) {
        List r4 = y9.b(r3.b);
        if (r4 != null) goto L5;
        return null;
    L5:
        if (r4.size() == 0) goto L21;
        ArrayList r0 = new ArrayList();
        Iterator r5 = r4.iterator();
    L9:
        if (r5.hasNext() == false) goto L13;
        OfflineVideo r1 = a((String) r5.next());
        if (r1 == null) goto L9;
        r0.add(r1);
        goto L9
    L13:
        return r0;
    L21:
        return null;
    }
}
