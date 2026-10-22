package cz.msebera.android.httpclient.cookie;

import cz.msebera.android.httpclient.impl.cookie.BasicClientCookie;
import java.util.Comparator;
import java.util.Date;

/* JADX INFO: loaded from: classes5.dex */
public class CookiePriorityComparator implements Comparator<Cookie> {
    public static final CookiePriorityComparator INSTANCE = null;

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(Cookie r1, Cookie r2) {
        return compare2(r1, r2);
    }

    public CookiePriorityComparator() {
    }

    static {
        INSTANCE = new CookiePriorityComparator();
    }

    private int getPathLength(Cookie r1) {
        String r0 = r1.getPath();
        if (r0 != null) goto L7;
        return 1;
    L7:
        return r0.length();
    }

    /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
    public int compare2(Cookie r3, Cookie r4) {
        int r0 = getPathLength(r3);
        int r2 = getPathLength(r4) - r0;
        if (r2 == 0) goto L5;
        return r2;
    L5:
        if ((r3 instanceof BasicClientCookie) == true) goto L7;
        return r2;
    L7:
        if ((r4 instanceof BasicClientCookie) == false) goto L15;
        Date r5 = ((BasicClientCookie) r3).getCreationDate();
        Date r6 = ((BasicClientCookie) r4).getCreationDate();
        if (r5 == null) goto L16;
        if (r6 != null) goto L12;
        return r2;
    L12:
        return (int) (r5.getTime() - r6.getTime());
    L16:
        return r2;
    L15:
        return r2;
    }
}
