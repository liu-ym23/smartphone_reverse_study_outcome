package d.b.u.d0;

import android.text.TextUtils;
import com.bytedance.bdlocation.exception.BDLocationException;

/* JADX INFO: loaded from: classes.dex */
public class b {
    private static boolean a(String r1) {
        if (TextUtils.isEmpty(r1) == false) goto L5;
    L8:
        return true;
    L5:
        if (TextUtils.equals(r1, BDLocationException.ERROR_TIMEOUT) == true) goto L8;
        return false;
    }

    public static boolean b(String r2, String r3) {
        if (TextUtils.equals(r2, r3) == false) goto L6;
        return true;
    L6:
        if (a(r2) == true) goto L8;
    L10:
        return false;
    L8:
        if (a(r3) == false) goto L10;
        return true;
    }
}
