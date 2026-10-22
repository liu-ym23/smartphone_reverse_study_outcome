package ms.bd.c;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import com.bytedance.bdlocation.exception.BDLocationException;
import java.util.Iterator;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
public class b3 {
    public static String a() {
        String r0 = "null";
        e0.e();     // Catch: Throwable -> L22
        String r3 = r4.a(null);
        String r4 = r4.a(null);
        String r2 = r4.a(null);
        StringBuilder r5 = new StringBuilder();
        if (r4 != null) goto L7;
    L10:
        String r6 = "null";
    L11:
        r5.append(r6);
        r5.append("[<!>]");
        if (r3 != null) goto L14;
    L17:
        r5.append(r0);
        r5.append("[<!>]");
        if (r2 != null) goto L20;
    L41:
        String r1 = BDLocationException.ERROR_TIMEOUT;
    L42:
        r5.append(r1);
        r5.append("[<!>]");
        return r5.toString().trim();
    L20:
        if (r2.length() <= 0) goto L41;
    L40:
        r1 = r2.trim();
        goto L42
    L14:
        if (r3.length() <= 0) goto L17;
        r0 = r3.trim();
        goto L17
    L7:
        if (r4.length() <= 0) goto L10;
        r6 = r4.trim();
    L22:
        String r7 = r4.a(null);
        String r8 = r4.a(null);
        r2 = r4.a(null);
        r5 = new StringBuilder();
        if (r8 != null) goto L25;
    L28:
        String r9 = "null";
    L29:
        r5.append(r9);
        r5.append("[<!>]");
        if (r7 != null) goto L32;
    L35:
        r5.append(r0);
        r5.append("[<!>]");
        if (r2 == null) goto L41;
        if (r2.length() > 0) goto L40;
    L32:
        if (r7.length() <= 0) goto L35;
        r0 = r7.trim();
        goto L35
    L25:
        if (r8.length() <= 0) goto L28;
        r9 = r8.trim();
        goto L29
    }

    public static String b(Context r1) {
        JSONArray r0 = new JSONArray();
        if (r1 == null) goto L5;
        if (e0.e() == false) goto L10;
        return r0.toString();
    L10:
        return "[]";
    L15:
        return "[]";
    L5:
        return r0.toString();
    }

    private static String c(Context r3) {
        String r4 = Settings.Secure.getString(r3.getContentResolver(), "default_input_method");     // Catch: Throwable -> L9
        if (TextUtils.isEmpty(r4) == false) goto L6;
        return "null_";
    L6:
        if (r4.contains("/") == false) goto L18;
        r4 = r4.split("/")[0];     // Catch: Throwable -> L9
    L18:
        return r4;
    L9:
        th = move-exception;
        r4 = "null_" + th.getMessage();     // Catch: Throwable -> L13
    L19:
        return "null_";
    }

    public static String d(Context r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        StringBuilder r0 = new StringBuilder(c(r3));
        Iterator<InputMethodInfo> r4 = ((InputMethodManager) r3.getSystemService("input_method")).getInputMethodList().iterator();     // Catch: Throwable -> L17
    L8:
        if (r4.hasNext() == false) goto L16;
        String r1 = r4.next().getPackageName();     // Catch: Throwable -> L17
        if (TextUtils.isEmpty(r1) == true) goto L8;
        if (r0.indexOf(r1) >= 0) goto L8;
        r0.append("[<!>]");     // Catch: Throwable -> L17
        r0.append(r1);     // Catch: Throwable -> L17
    L16:
        return r0.toString();
    }

    public static String e(Context r1) {
        if (r1 != null) goto L6;
        return null;
    L6:
        return new StringBuilder(c(r1)).toString();
    }
}
