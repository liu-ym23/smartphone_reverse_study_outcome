package tmsdkobf;

import android.text.TextUtils;
import com.bytedance.platform.godzilla.common.Constant;

/* JADX INFO: loaded from: classes5.dex */
public abstract class uj {
    public static String a(String r0) {
        if (r0 != null) goto L5;
        return "";
    L5:
        return r0;
    }

    public static byte[] b(String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L6;
        return null;
    L6:
        int r0 = r5.length() / 2;
        byte[] r1 = new byte[r0];
        char[] r6 = r5.toUpperCase().toCharArray();
        int r2 = 0;
    L7:
        if (r2 >= r0) goto L9;
        int r3 = r2 * 2;
        int r4 = a(r6[r3]) << 4;
        r1[r2] = (byte) (a(r6[r3 + 1]) | r4);
        r2 = r2 + 1;
        goto L7
    L9:
        return r1;
    }

    public static byte[] c(String r1) {
        if (r1 != null) goto L6;
        return null;
    L6:
        return r1.getBytes(Constant.CHARSET_UTF_8);
    }

    public static String a(byte[] r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        return new String(r2, Constant.CHARSET_UTF_8);
    }

    private static byte a(char r1) {
        return (byte) "0123456789ABCDEF".indexOf(r1);
    }
}
