package tmsdkobf;

import android.text.TextUtils;
import com.bytedance.librarian.LibrarianImpl;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tmsdk.common.OfflineVideo;

/* JADX INFO: loaded from: classes5.dex */
public class pe extends v9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final boolean f419a;

    public pe(boolean r1) {
        this.f419a = r1;
    }

    private void a(String r4, List r5) {
        String r3 = ac.c(r4);
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return;
    L5:
        OfflineVideo r0 = new OfflineVideo();
        r0.mPath = r4;
        r0.mSize = y9.d(r4);
        r0.mTitle = r3;
        r5.add(r0);
    }

    @Override // tmsdkobf.v9
    public List a(w9 r10) {
        ArrayList r0 = new ArrayList();
        ArrayList r1 = new ArrayList();
        if (TextUtils.isEmpty(r10.b) == false) goto L5;
        return r1;
    L5:
        Iterator r2 = ac.c().iterator();
    L7:
        if (r2.hasNext() == false) goto L22;
        File r4 = new File(((String) r2.next()) + LibrarianImpl.Constants.SEPARATOR + r10.b);
        if (r4.exists() == false) goto L7;
        if (r4.isDirectory() == false) goto L7;
        File[] r3 = r4.listFiles();
        if (r3 == null) goto L7;
        int r5 = r3.length;
        int r6 = 0;
    L16:
        if (r6 >= r5) goto L7;
        File r7 = r3[r6];
        if (r7.getName().equals("media_list") == true) goto L20;
        r0.add(r7.getAbsolutePath());
    L20:
        r6 = r6 + 1;
        goto L16
    L22:
        if (r0.isEmpty() == false) goto L25;
        return null;
    L25:
        Iterator r11 = r0.iterator();
    L27:
        if (r11.hasNext() == false) goto L29;
        a((String) r11.next(), r1);
        goto L27
    L29:
        return r1;
    }
}
