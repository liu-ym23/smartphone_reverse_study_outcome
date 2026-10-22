package d.b.b.o;

import android.text.TextUtils;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static int f13053a = 1;

    static {
    }

    public static String a(String r7, Map<String, String> r8) {
        if (TextUtils.isDigitsOnly(r7) == true) goto L29;
        if (r8 == null) goto L29;
        if (r8.isEmpty() == true) goto L29;
        if (r7.indexOf("?") >= 0) goto L12;
        r7 = r7 + "?";
    L12:
        if (r7.endsWith("?") == false) goto L14;
        StringBuilder r1 = new StringBuilder();
        r1.append(r7);
    L15:
        r1.append(b("sdk_version", "UTF-8"));
        r1.append("=");
        r1.append(b(String.valueOf(f13053a), "UTF-8"));
        r7 = r1.toString();
        if (r8 == null) goto L29;
        if (r8.size() <= 0) goto L29;
        Iterator<Map.Entry<String, String>> r2 = r8.entrySet().iterator();
    L21:
        if (r2.hasNext() == false) goto L29;
        Map.Entry<String, String> r3 = r2.next();
        if (r8.get(r3.getKey()) == null) goto L21;
        if (r7.endsWith("?") == false) goto L27;
        StringBuilder r6 = new StringBuilder();
        r6.append(r7);
    L28:
        r6.append(b(r3.getKey().toString(), "UTF-8"));
        r6.append("=");
        r6.append(b(r8.get(r3.getKey()).toString(), "UTF-8"));
        r7 = r6.toString();
        goto L21
    L27:
        r6 = new StringBuilder();
        r6.append(r7);
        r6.append("&");
        goto L28
    L14:
        r1 = new StringBuilder();
        r1.append(r7);
        r1.append("&");
    L29:
        return r7;
    }

    private static String b(String r0, String r1) {
        if (r1 != null) goto L10;
        r1 = "UTF-8";
    L10:
        return URLEncoder.encode(r0, r1);
    L7:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }
}
