package tmsdkobf;

import android.telephony.PhoneNumberUtils;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ma {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final String[] f349a = null;

    static {
        f349a = new String[]{"-", "+86", "0086", "12593", "17909", "17951", "17911", "10193", "12583", "12520", "96688"};
    }

    public static String a(String r0) {
        return b(c(r0));
    }

    public static String b(String r5) {
        if (r5 != null) goto L4;
        return r5;
    L4:
        if (r5.length() <= 2) goto L14;
        String[] r0 = f349a;
        int r1 = r0.length;
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L16;
        String r3 = r0[r2];
        if (r5.startsWith(r3) == true) goto L15;
        r2 = r2 + 1;
        goto L6
    L15:
        return r5.substring(r3.length());
    L16:
        return r5;
    L14:
        return r5;
    }

    public static String c(String r2) {
        if (r2 != null) goto L4;
        return r2;
    L4:
        return PhoneNumberUtils.stripSeparators(r2).replace("-", "").replace(" ", "").trim();
    }
}
