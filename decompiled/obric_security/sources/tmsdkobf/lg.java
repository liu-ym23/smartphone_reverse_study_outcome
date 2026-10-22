package tmsdkobf;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes5.dex */
public abstract class lg {
    public static String a(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L7;
        return "";
    L7:
        if (r3.length() > 1) goto L9;
        return r3;
    L9:
        if (r3.charAt(0) == '\"') goto L11;
        return r3;
    L11:
        if (r3.charAt(r3.length() - 1) == '\"') goto L13;
        return r3;
    L13:
        return r3.substring(1, r3.length() - 1);
    }
}
