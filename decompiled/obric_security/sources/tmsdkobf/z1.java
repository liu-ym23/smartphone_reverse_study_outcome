package tmsdkobf;

import android.text.TextUtils;
import java.security.SecureRandom;
import java.util.Locale;
import kotlin.UByte;

/* JADX INFO: loaded from: classes5.dex */
public abstract class z1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f651a = 0;

    static {
        new SecureRandom();
    }

    public static String a(byte[] r6) {
        StringBuffer r0 = new StringBuffer(r6.length);
        int r2 = 0;
    L4:
        if (r2 >= r6.length) goto L10;
        String r3 = Integer.toHexString(r6[r2] & UByte.MAX_VALUE);
        if (r3.length() >= 2) goto L8;
        r0.append(0);
    L8:
        r0.append(r3.toUpperCase(Locale.getDefault()));
        r2 = r2 + 1;
        goto L4
    L10:
        return r0.toString();
    }

    public static String a(String r1, String r2, String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return r3;
    L5:
        return r3.replace(r1, r2);
    }

    public static String a(byte[] r1, String r2) {
        if (r2 != null) goto L6;
        return new String(r1);
    L6:
        return new String(r1, r2);
    L7:
        return null;
    }
}
