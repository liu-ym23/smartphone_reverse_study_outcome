package d.b.s.a.l0;

import android.text.TextUtils;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, String> f14864a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f14865b;

    public q(String r2) {
        this.f14864a = new LinkedHashMap();
        this.f14865b = r2;
    }

    private static String d(String r0, String r1) {
        if (r1 != null) goto L10;
        r1 = "ISO-8859-1";
    L10:
        return URLEncoder.encode(r0, r1);
    L7:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    public static String e(Map<String, String> r5, String r6) {
        StringBuilder r0 = new StringBuilder();
        Iterator<Map.Entry<String, String>> r7 = r5.entrySet().iterator();
    L4:
        if (r7.hasNext() == false) goto L17;
        Map.Entry<String, String> r1 = r7.next();
        String r2 = d(r1.getKey(), r6);
        String r3 = r1.getValue();
        if (r3 == null) goto L8;
        String r4 = d(r3, r6);
    L10:
        if (TextUtils.isEmpty(r4) == true) goto L13;
        r4 = r4.replace("+", "%20");
    L13:
        if (r0.length() <= 0) goto L15;
        r0.append("&");
    L15:
        r0.append(r2);
        r0.append("=");
        r0.append(r4);
        goto L4
    L8:
        r4 = "";
        goto L10
    L17:
        return r0.toString();
    }

    public void a(String r1, int r2) {
        this.f14864a.put(r1, String.valueOf(r2));
    }

    public void b(String r1, String r2) {
        this.f14864a.put(r1, r2);
    }

    public String c() {
        if (this.f14864a.isEmpty() == true) goto L5;
        String r0 = e(this.f14864a, "UTF-8");
        String r1 = this.f14865b;
        if (r1 != null) goto L9;
    L17:
        return r0;
    L9:
        if (r1.length() == 0) goto L17;
        if (this.f14865b.indexOf(63) < 0) goto L16;
        StringBuilder r2 = new StringBuilder();
        r2.append(this.f14865b);
        String r3 = "&";
    L14:
        r2.append(r3);
        r2.append(r0);
        return r2.toString();
    L16:
        r2 = new StringBuilder();
        r2.append(this.f14865b);
        r3 = "?";
        goto L14
    L5:
        return this.f14865b;
    }

    public String toString() {
        return c();
    }
}
