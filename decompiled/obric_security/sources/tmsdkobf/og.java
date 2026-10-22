package tmsdkobf;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import tmsdk.common.OfflineVideo;

/* JADX INFO: loaded from: classes5.dex */
public class og extends v9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Pattern f398a;
    Pattern b;
    Pattern c;
    Pattern d;

    public og() {
        this.f398a = Pattern.compile("\"progress\":([0-9]{1,3})");
        this.b = Pattern.compile("\"title\":\"([^\"]*)\"");
        this.c = Pattern.compile("\"seconds\":([0-9]{1,3})");
        this.d = Pattern.compile("\"playTime\":([0-9]{1,3})");
    }

    private OfflineVideo a(String r5) {
        OfflineVideo r0 = new OfflineVideo();
        r0.mPath = r5;
        if (new File(r5 + "/1.png").exists() == false) goto L5;
        r0.mThumnbailPath = r5 + "/1.png";
    L5:
        List r1 = y9.e(r5 + "/info");
        if (r1 != null) goto L8;
        return null;
    L8:
        if (r1.size() == 0) goto L18;
        String r2 = (String) r1.get(0);
        r0.mTitle = y9.b(r2, this.b);
        r0.mDownProgress = y9.a(r2, this.f398a);
        int r3 = y9.a(r2, this.d);
        int r4 = y9.a(r2, this.c);
        if (r4 <= 0) goto L13;
        int r6 = (r3 * 100) / r4;
    L14:
        r0.mPlayProgress = r6;
        r0.mSize = y9.d(r5);
        return r0;
    L13:
        r6 = -1;
        goto L14
    L18:
        return null;
    }

    @Override // tmsdkobf.v9
    public List a(w9 r3) {
        String r4 = r3.b;
        if (r4 != null) goto L6;
        return null;
    L6:
        List r5 = y9.b(r4);
        ArrayList r0 = new ArrayList();
        Iterator r6 = r5.iterator();
    L8:
        if (r6.hasNext() == false) goto L12;
        OfflineVideo r1 = a((String) r6.next());
        if (r1 == null) goto L8;
        r0.add(r1);
        goto L8
    L12:
        return r0;
    }
}
