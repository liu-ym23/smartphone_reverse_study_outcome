package tmsdkobf;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public abstract class fa {
    public static List a(String r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        ArrayList r1 = new ArrayList();
        String[] r6 = r5.split("\\|");
        int r2 = r6.length;
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L12;
        r1.add(Integer.valueOf(r6[r3]));     // Catch: Exception -> L10
    L11:
        r3 = r3 + 1;
    L10:
        r1 = null;
        goto L11
    L12:
        return r1;
    }

    public static float b(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L8;
        return 0.0f;
    L8:
        return Float.parseFloat(r2);
    L10:
        return 0.0f;
    }

    public static int c(String r2) {
        if (TextUtils.isEmpty(r2) == true) goto L13;
        int r3 = Integer.valueOf(r2).intValue();     // Catch: NumberFormatException -> L6
    L7:
        if (r3 >= 0) goto L10;
        return 0;
    L10:
        return r3;
    L6:
        r3 = 0;
        goto L7
    L13:
        return 0;
    }
}
