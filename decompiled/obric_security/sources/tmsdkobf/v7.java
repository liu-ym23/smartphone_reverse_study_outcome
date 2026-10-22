package tmsdkobf;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import tmsdk.common.TMServiceFactory;

/* JADX INFO: loaded from: classes5.dex */
public class v7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f570a;
    private gf b;

    public v7() {
        this.f570a = false;
        this.b = TMServiceFactory.getSystemInfoService();
    }

    public String a(String r2) {
        m r1 = this.b.getAppInfo(r2, 1);
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.b();
    }

    public int b(List r8) {
        int r7 = -1;
        if (r8 != null) goto L5;
        return -1;
    L5:
        Map r0 = bc.a().b();
        Iterator r9 = r8.iterator();
        int r1 = 0;
        long r2 = -1;
    L7:
        if (r9.hasNext() == false) goto L16;
        Long r4 = (Long) r0.get((String) r9.next());
        if (r4 == null) goto L11;
        long r5 = r4.longValue();
    L13:
        if (r5 <= r2) goto L15;
        r7 = r1;
        r2 = r5;
    L15:
        r1 = r1 + 1;
        goto L7
    L11:
        r5 = 0;
        goto L13
    L16:
        return r7;
    }

    public String a(List r4) {
        if (r4 != null) goto L5;
        return null;
    L5:
        Iterator r5 = r4.iterator();
    L7:
        if (r5.hasNext() == false) goto L11;
        String r1 = (String) r5.next();
        if (b(r1) == false) goto L7;
        return r1;
    L11:
        return null;
    }

    public boolean b(String r1) {
        if (r1 != null) goto L6;
        return false;
    L6:
        return this.b.isPackageInstalled(r1);
    }

    public void a() {
        this.f570a = true;
    }
}
