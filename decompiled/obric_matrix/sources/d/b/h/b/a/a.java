package d.b.h.b.a;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.frameworks.encryptor.EncryptorUtil;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static InterfaceC0365a f13816a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f13817b = false;

    /* JADX INFO: renamed from: d.b.h.b.a.a$a, reason: collision with other inner class name */
    public interface InterfaceC0365a {
        boolean c();

        boolean d();

        boolean k();
    }

    static {
    }

    private static Uri a(String r1, String r2, int r3, String r4, String r5, String r6) {
        StringBuilder r0 = new StringBuilder();
        if (r2 == null) goto L9;
        if (r1 == null) goto L6;
        r0.append(r1);
        r0.append("://");
    L6:
        r0.append(r2);
        if (r3 <= 0) goto L9;
        r0.append(':');
        r0.append(r3);
    L9:
        if (r4 != null) goto L11;
    L12:
        r0.append('/');
    L13:
        if (r4 == null) goto L15;
        r0.append(r4);
    L15:
        if (r5 == null) goto L17;
        r0.append('?');
        r0.append(r5);
    L17:
        if (r6 == null) goto L20;
        r0.append('#');
        r0.append(r6);
    L20:
        return Uri.parse(r0.toString());
    L11:
        if (r4.startsWith("/") == true) goto L13;
        goto L12
    }

    private static String b(String r0, String r1) {
        if (r1 != null) goto L10;
        r1 = "ISO-8859-1";
    L10:
        return URLEncoder.encode(r0, r1);
    L7:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    private static String c(List<Pair<String, List<String>>> r5, boolean r6, String r7) {
        StringBuilder r0 = new StringBuilder();
        Iterator<Pair<String, List<String>>> r8 = r5.iterator();
    L4:
        if (r8.hasNext() == false) goto L25;
        Pair<String, List<String>> r1 = r8.next();
        Object r2 = r1.first;
        String r3 = (String) r2;
        if (r6 == false) goto L8;
        r3 = b((String) r2, r7);
    L8:
        List r4 = (List) r1.second;
        if (r4 == null) goto L4;
        if (r4.size() <= 0) goto L4;
        Iterator r9 = r4.iterator();
    L14:
        if (r9.hasNext() == false) goto L4;
        String r10 = (String) r9.next();
        if (r6 == false) goto L21;
        if (r10 == null) goto L19;
        r10 = b(r10, r7);
        goto L21
    L19:
        r10 = "";
    L21:
        if (r0.length() <= 0) goto L23;
        r0.append("&");
    L23:
        r0.append(r3);
        r0.append("=");
        r0.append(r10);
        goto L14
    L25:
        return r0.toString();
    }

    public static void d(Uri r9, Map<String, List<String>> r10) {
        if (r9 == null) goto L26;
        if (r10 != null) goto L27;
        return;
    L27:
        String r11 = r9.getEncodedQuery();     // Catch: Throwable -> L21
        if (r11 == null) goto L32;
        String[] r12 = r11.split("&");     // Catch: Throwable -> L21
        int r1 = r12.length;     // Catch: Throwable -> L21
        int r3 = 0;
    L8:
        if (r3 >= r1) goto L33;
        String r4 = r12[r3];     // Catch: Throwable -> L21
        int r5 = r4.indexOf("=");     // Catch: Throwable -> L21
        if (r5 < 0) goto L16;
        String r7 = URLDecoder.decode(r4.substring(0, r5), "UTF-8");     // Catch: Throwable -> L21
        List<String> r8 = r10.get(r7);     // Catch: Throwable -> L21
        if (r8 != null) goto L15;
        r8 = new LinkedList();     // Catch: Throwable -> L21
    L15:
        r8.add(URLDecoder.decode(r4.substring(r5 + 1), "UTF-8"));     // Catch: Throwable -> L21
        r10.put(r7, r8);     // Catch: Throwable -> L21
    L20:
        r3 = r3 + 1;
        goto L8
    L16:
        String r6 = URLDecoder.decode(r4, "UTF-8");     // Catch: Throwable -> L21
        List<String> r13 = r10.get(r6);     // Catch: Throwable -> L21
        if (r13 != null) goto L19;
        r13 = new LinkedList();     // Catch: Throwable -> L21
    L19:
        r13.add("");     // Catch: Throwable -> L21
        r10.put(r6, r13);     // Catch: Throwable -> L21
        goto L20
    L33:
        return;
    L32:
        return;
    L21:
        th = move-exception;
        th.printStackTrace();
        throw new IOException("parseUrl url is null !!!");
    L26:
        throw new IOException("parseUrl url is null !!!");
    }

    public static void e(InterfaceC0365a r0) {
        f13816a = r0;
    }

    private static boolean f(Map<String, List<String>> r2, List<Pair<String, List<String>>> r3, String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L5;
        return false;
    L5:
        if (r3 != null) goto L8;
        return false;
    L8:
        if (r2.containsKey(r4) == false) goto L14;
        r3.add(new Pair(r4, r2.get(r4)));
        if (f13816a.d() == true) goto L15;
        r2.remove(r4);
        return true;
    L15:
        return true;
    L14:
        return false;
    }

    public static String g(String r11, List<Pair<String, String>> r12) {
        if (TextUtils.isEmpty(r11) == false) goto L6;
        return r11;
    L6:
        if (f13816a != null) goto L9;
        return r11;
    L9:
        if (f13817b == false) goto L11;
        return r11;
    L11:
        LinkedHashMap r1 = new LinkedHashMap();
        Uri r2 = Uri.parse(r11);     // Catch: Throwable -> L36
        d(r2, r1);     // Catch: Throwable -> L36
        LinkedList r3 = new LinkedList();     // Catch: Throwable -> L36
        f(r1, r3, WsConstants.KEY_DEVICE_ID);     // Catch: Throwable -> L36
        f(r1, r3, "device_type");     // Catch: Throwable -> L36
        f(r1, r3, "device_brand");     // Catch: Throwable -> L36
        f(r1, r3, "uuid");     // Catch: Throwable -> L36
        f(r1, r3, "openudid");     // Catch: Throwable -> L36
        String r4 = c(r3, false, "UTF-8");     // Catch: Throwable -> L36
        if (TextUtils.isEmpty(r4) == false) goto L15;
        return r11;
    L15:
        byte[] r5 = r4.getBytes();     // Catch: Throwable -> L36
        byte[] r6 = EncryptorUtil.a(r5, r5.length);     // Catch: Throwable -> L36
        if (r6 != null) goto L18;
        return r11;
    L18:
        String r7 = Base64.encodeToString(r6, 2);     // Catch: Throwable -> L36
        LinkedList r8 = new LinkedList();     // Catch: Throwable -> L36
        if (f13816a.k() == false) goto L22;
        LinkedList r9 = new LinkedList();     // Catch: Throwable -> L36
        r9.add(r7);     // Catch: Throwable -> L36
        r8.add(new Pair("ss_queries", r9));     // Catch: Throwable -> L36
    L22:
        if (f13816a.c() == false) goto L26;
        if (r12 == null) goto L26;
        r12.add(new Pair("X-SS-QUERIES", b(r7, "UTF-8")));     // Catch: Throwable -> L36
    L26:
        if (r1.isEmpty() == true) goto L34;
        Iterator r13 = r1.entrySet().iterator();     // Catch: Throwable -> L36
    L29:
        if (r13.hasNext() == false) goto L34;
        Map.Entry r10 = (Map.Entry) r13.next();     // Catch: Throwable -> L36
        if (r10 == null) goto L29;
        r8.add(new Pair(r10.getKey(), r10.getValue()));     // Catch: Throwable -> L36
    L34:
        String r14 = c(r8, true, "UTF-8");     // Catch: Throwable -> L36
        return a(r2.getScheme(), r2.getHost(), r2.getPort(), r2.getPath(), r14, r2.getFragment()).toString();
    L36:
        th = move-exception;
        th.printStackTrace();
        return r11;
    }
}
