package tmsdkobf;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes5.dex */
public class nd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile int f372a;
    public volatile String b;
    public volatile String c;

    public nd() {
    }

    public static nd a(nd r2) {
        nd r0 = new nd();
        r0.f372a = r2.f372a;
        r0.b = r2.b;
        r0.c = r2.c;
        return r0;
    }

    public static boolean b(nd r2) {
        if (r2 != null) goto L6;
        return false;
    L6:
        if (TextUtils.isEmpty(r2.b) == false) goto L8;
        return false;
    L8:
        if (TextUtils.isEmpty(r2.c) == true) goto L12;
        return true;
    L12:
        return false;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder(" symmetricAlgo: ");
        r0.append(this.f372a);
        r0.append(" randomKey: ").append(this.b);
        r0.append(" sessionId: ").append(this.c);
        return r0.toString();
    }
}
