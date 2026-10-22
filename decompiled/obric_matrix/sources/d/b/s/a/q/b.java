package d.b.s.a.q;

import android.text.TextUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f14879a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f14880b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f14881c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f14882d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Map<String, String> f14883e;

    public b(int r1) {
        this.f14879a = r1;
    }

    public static int a(String r6) {
        if (TextUtils.isEmpty(r6) == false) goto L5;
        return 0;
    L5:
        r6.hashCode();
        byte r0 = -1;
        switch(r6.hashCode()) {
            case -2085722047: goto L21;
            case -1242784755: goto L17;
            case -355378050: goto L13;
            case 90865289: goto L9;
            default: goto L24;
        };
    L24:
        switch(r0) {
            case 0: goto L29;
            case 1: goto L27;
            case 2: goto L30;
            case 3: goto L32;
            default: goto L31;
        };
    L27:
        return 4;
    L30:
        return 0;
    L31:
        return 3;
    L32:
        return 1;
    L29:
        return 2;
    L9:
        if (r6.equals("sdk_expired_logout") == false) goto L24;
        r0 = 3;
        goto L24
    L13:
        if (r6.equals("user_logout") == false) goto L24;
        r0 = 2;
        goto L24
    L17:
        if (r6.equals("frontier") == false) goto L24;
        r0 = 1;
        goto L24
    L21:
        if (r6.equals("cancel_account_logout") == false) goto L24;
        r0 = 0;
        goto L24
    }
}
