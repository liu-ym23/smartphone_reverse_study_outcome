package tmsdkobf;

import android.text.TextUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public abstract class c2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f123a = null;
    public static final byte[] b = null;
    public static final byte[] c = null;
    public static final byte[] d = null;
    public static final byte[] e = null;
    public static final byte[] f = null;
    public static final byte[] g = null;
    public static final byte[] h = null;
    public static final byte[] i = null;

    static {
        f123a = new byte[]{47, 65, 110, 100, 114, 111, 105, 100, 47, 100, 97, 116, 97, 47, 99, 111, 109, 46, 116, 101, 110, 99, 101, 110, 116, 46, 109, 109};
        b = new byte[]{47, 65, 110, 100, 114, 111, 105, 100, 47, 100, 97, 116, 97, 47, 99, 111, 109, 46, 115, 109, 105, 108, 101, 46, 103, 105, 102, 109, 97, 107, 101, 114};
        c = new byte[]{47, 65, 110, 100, 114, 111, 105, 100, 47, 100, 97, 116, 97, 47, 99, 111, 109, 46, 116, 101, 110, 99, 101, 110, 116, 46, 109, 111, 98, 105, 108, 101, 113, 113};
        d = new byte[]{47, 65, 110, 100, 114, 111, 105, 100, 47, 100, 97, 116, 97, 47, 99, 111, 109, 46, 116, 101, 110, 99, 101, 110, 116, 46, 119, 101, 119, 111, 114, 107};
        e = new byte[]{47, 99, 111, 109, 46, 116, 101, 110, 99, 101, 110, 116, 46, 109, 109, 47, 77, 105, 99, 114, 111, 77, 115, 103};
        f = new byte[]{99, 111, 109, 46, 116, 101, 110, 99, 101, 110, 116, 46, 109, 109};
        g = new byte[]{99, 111, 109, 46, 116, 101, 110, 99, 101, 110, 116, 46, 109, 111, 98, 105, 108, 101, 113, 113};
        h = new byte[]{94, 47, 112, 105, 99, 116, 117, 114, 101, 115, 47, 40, 63, 33, 119, 101, 105, 120, 105, 110, 40, 47, 124, 36, 41, 124, 113, 113, 40, 47, 124, 36, 41, 41, 46, 42, 36, 124, 94, 47, 112, 105, 99, 116, 117, 114, 101, 115, 36};
        i = new byte[]{94, 47, 100, 111, 119, 110, 108, 111, 97, 100, 47, 40, 63, 33, 119, 101, 105, 120, 105, 110, 40, 47, 124, 36, 41, 124, 113, 113, 40, 47, 124, 36, 41, 41, 46, 42, 36, 124, 94, 47, 100, 111, 119, 110, 108, 111, 97, 100, 36};
    }

    public static String a(boolean r3, Map r4) {
        if (r4 != null) goto L6;
        return "";
    L6:
        if (r3 == false) goto L13;
        String r5 = (String) r4.get(17);
        if (TextUtils.isEmpty(r5) == false) goto L11;
        r5 = (String) r4.get(6);
    L11:
        if (TextUtils.isEmpty(r5) == false) goto L22;
        int r6 = 24;
    L20:
        r5 = (String) r4.get(r6);
    L22:
        if (TextUtils.isEmpty(r5) == false) goto L25;
        return "NoAppName";
    L25:
        return r5;
    L13:
        r5 = (String) r4.get(24);
        if (TextUtils.isEmpty(r5) == false) goto L22;
        if (tb.d() == false) goto L19;
        r5 = (String) r4.get(17);
        if (TextUtils.isEmpty(r5) == false) goto L22;
    L19:
        r6 = 6;
        goto L20
    }

    public static String b(boolean r3, Map r4) {
        if (r4 != null) goto L6;
        return "";
    L6:
        if (r3 == false) goto L13;
        String r5 = (String) r4.get(18);
        if (TextUtils.isEmpty(r5) == false) goto L11;
        r5 = (String) r4.get(8);
    L11:
        if (TextUtils.isEmpty(r5) == false) goto L22;
        int r6 = 25;
    L20:
        r5 = (String) r4.get(r6);
    L22:
        if (TextUtils.isEmpty(r5) == false) goto L25;
        return "Data Cache";
    L25:
        return r5;
    L13:
        r5 = (String) r4.get(25);
        if (TextUtils.isEmpty(r5) == false) goto L22;
        if (tb.d() == false) goto L19;
        r5 = (String) r4.get(18);
        if (TextUtils.isEmpty(r5) == false) goto L22;
    L19:
        r6 = 8;
        goto L20
    }
}
