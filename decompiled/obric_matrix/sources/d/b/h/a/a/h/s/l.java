package d.b.h.a.a.h.s;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import java.io.IOException;
import java.net.URI;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f13767a = null;

    static {
        f13767a = Pattern.compile("(((?:(?i:http|https|rtsp|ws|wss)://(?:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,64}(?:\\:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,25})?\\@)?)?(?:(([a-zA-Z0-9[ -\ud7ff豈-﷏ﷰ-\uffef𐀀-\u1fffd𠀀-\u2fffd𰀀-\u3fffd\u40000-\u4fffd\u50000-\u5fffd\u60000-\u6fffd\u70000-\u7fffd\u80000-\u8fffd\u90000-\u9fffd\ua0000-\uafffd\ub0000-\ubfffd\uc0000-\ucfffd\ud0000-\udfffd\ue1000-\uefffd&&[^ [\u2000-\u200a]\u2028\u2029 \u3000]]](?:[a-zA-Z0-9[ -\ud7ff豈-﷏ﷰ-\uffef𐀀-\u1fffd𠀀-\u2fffd𰀀-\u3fffd\u40000-\u4fffd\u50000-\u5fffd\u60000-\u6fffd\u70000-\u7fffd\u80000-\u8fffd\u90000-\u9fffd\ua0000-\uafffd\ub0000-\ubfffd\uc0000-\ucfffd\ud0000-\udfffd\ue1000-\uefffd&&[^ [\u2000-\u200a]\u2028\u2029 \u3000]]_\\-]{0,61}[a-zA-Z0-9[ -\ud7ff豈-﷏ﷰ-\uffef𐀀-\u1fffd𠀀-\u2fffd𰀀-\u3fffd\u40000-\u4fffd\u50000-\u5fffd\u60000-\u6fffd\u70000-\u7fffd\u80000-\u8fffd\u90000-\u9fffd\ua0000-\uafffd\ub0000-\ubfffd\uc0000-\ucfffd\ud0000-\udfffd\ue1000-\uefffd&&[^ [\u2000-\u200a]\u2028\u2029 \u3000]]]){0,1}\\.)+(xn\\-\\-[\\w\\-]{0,58}\\w|[a-zA-Z[ -\ud7ff豈-﷏ﷰ-\uffef𐀀-\u1fffd𠀀-\u2fffd𰀀-\u3fffd\u40000-\u4fffd\u50000-\u5fffd\u60000-\u6fffd\u70000-\u7fffd\u80000-\u8fffd\u90000-\u9fffd\ua0000-\uafffd\ub0000-\ubfffd\uc0000-\ucfffd\ud0000-\udfffd\ue1000-\uefffd&&[^ [\u2000-\u200a]\u2028\u2029 \u3000]]]{2,63})|((25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9])\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[0-9]))))(?:\\:\\d{1,5})?)([/\\?](?:(?:[a-zA-Z0-9[ -\ud7ff豈-﷏ﷰ-\uffef𐀀-\u1fffd𠀀-\u2fffd𰀀-\u3fffd\u40000-\u4fffd\u50000-\u5fffd\u60000-\u6fffd\u70000-\u7fffd\u80000-\u8fffd\u90000-\u9fffd\ua0000-\uafffd\ub0000-\ubfffd\uc0000-\ucfffd\ud0000-\udfffd\ue1000-\uefffd&&[^ [\u2000-\u200a]\u2028\u2029 \u3000]];/\\?:@&=#~\\-\\.\\+!\\*'\\(\\),_\\$])|(?:%[a-fA-F0-9]{2}))*)?(?:\\b|$|^))");
    }

    private static URI a(String r2) {
        if (r2 != null) goto L4;
        return null;
    L4:
        if (r2.isEmpty() == true) goto L18;
        int r0 = r2.indexOf("?");     // Catch: Exception -> L11
        if (r0 <= 0) goto L9;
        r2 = r2.substring(0, r0);     // Catch: Exception -> L11
    L9:
        return URI.create(r2);
    L11:
        e = move-exception;
        throw new RuntimeException(e);
    L18:
        return null;
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

    public static String c(Map<String, List<String>> r5, String r6) {
        StringBuilder r0 = new StringBuilder();
        Iterator<Map.Entry<String, List<String>>> r7 = r5.entrySet().iterator();
    L4:
        if (r7.hasNext() == false) goto L23;
        Map.Entry<String, List<String>> r1 = r7.next();
        String r2 = b(r1.getKey(), r6);
        List<String> r3 = r1.getValue();
        if (r3 == null) goto L4;
        if (r3.size() <= 0) goto L4;
        Iterator<String> r4 = r3.iterator();
    L11:
        if (r4.hasNext() == false) goto L4;
        String r8 = r4.next();
        if (r8 == null) goto L15;
        String r9 = b(r8, r6);
    L17:
        if (r0.length() <= 0) goto L19;
        r0.append("&");
    L19:
        r0.append(r2);
        if (r9.isEmpty() == true) goto L11;
        r0.append("=");
        r0.append(r9);
        goto L11
    L15:
        r9 = "";
        goto L17
    L23:
        return r0.toString();
    }

    private static boolean d(String r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        if (r3.length() > 6) goto L7;
        return false;
    L7:
        if (r3.substring(0, 7).equalsIgnoreCase("http://") == false) goto L12;
        return true;
    L12:
        return false;
    }

    private static boolean e(String r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        if (r3.length() > 7) goto L7;
        return false;
    L7:
        if (r3.substring(0, 8).equalsIgnoreCase("https://") == false) goto L12;
        return true;
    L12:
        return false;
    }

    public static boolean f(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L6;
        return false;
    L6:
        if (e(r2) == true) goto L18;
        if (d(r2) == true) goto L18;
        if (h(r2) == true) goto L18;
        if (g(r2) == true) goto L18;
        return false;
    L18:
        return f13767a.matcher(r2).matches();
    L20:
        return false;
    }

    private static boolean g(String r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        if (r3.length() > 4) goto L7;
        return false;
    L7:
        if (r3.substring(0, 5).equalsIgnoreCase("ws://") == false) goto L12;
        return true;
    L12:
        return false;
    }

    private static boolean h(String r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        if (r3.length() > 5) goto L7;
        return false;
    L7:
        if (r3.substring(0, 6).equalsIgnoreCase("wss://") == false) goto L12;
        return true;
    L12:
        return false;
    }

    public static boolean i(String r12, String r13) {
        if (r12 == null) goto L29;
        if (r13 == null) goto L29;
        int r1 = r12.length();
        int r2 = r13.length();
        int r4 = 0;
        int r5 = 0;
        int r6 = -1;
        int r7 = -1;
    L8:
        if (r4 >= r1) goto L22;
        if (r5 >= r2) goto L15;
        if (r13.charAt(r5) == '?') goto L14;
        if (r13.charAt(r5) != r12.charAt(r4)) goto L15;
    L14:
        r4 = r4 + 1;
        r5 = r5 + 1;
    L15:
        if (r5 >= r2) goto L19;
        if (r13.charAt(r5) != '*') goto L19;
        r7 = r4;
        r6 = r5;
        r5 = r5 + 1;
    L19:
        if (r6 == (-1)) goto L20;
        r5 = r6 + 1;
        r7 = r7 + 1;
        r4 = r7;
        goto L8
    L20:
        return false;
    L22:
        if (r5 >= r2) goto L27;
        if (r13.charAt(r5) != '*') goto L25;
        r5 = r5 + 1;
        goto L22
    L25:
        return false;
    L27:
        return true;
    L29:
        return false;
    }

    @Deprecated
    public static Pair<String, String> j(String r9, Map<String, String> r10) {
        if (com.bytedance.common.utility.k.c(r9) == true) goto L28;
        Uri r11 = Uri.parse(r9);     // Catch: Throwable -> L25
        StringBuilder r0 = new StringBuilder();     // Catch: Throwable -> L25
        String r1 = r11.getScheme();     // Catch: Throwable -> L25
        String r2 = r11.getHost();     // Catch: Throwable -> L25
        int r3 = r11.getPort();     // Catch: Throwable -> L25
        if (r2 == null) goto L11;
        if (r1 == null) goto L8;
        r0.append(r1);     // Catch: Throwable -> L25
        r0.append("://");     // Catch: Throwable -> L25
    L8:
        r0.append(r2);     // Catch: Throwable -> L25
        if (r3 <= 0) goto L11;
        r0.append(':');     // Catch: Throwable -> L25
        r0.append(r3);     // Catch: Throwable -> L25
    L11:
        String r4 = r0.toString();     // Catch: Throwable -> L25
        String r5 = r11.getEncodedPath();     // Catch: Throwable -> L25
        if (r10 == null) goto L23;
        String r12 = r11.getEncodedQuery();     // Catch: Throwable -> L25
        if (r12 == null) goto L23;
        String[] r13 = r12.split("&");     // Catch: Throwable -> L25
        int r6 = r13.length;     // Catch: Throwable -> L25
        int r7 = 0;
    L16:
        if (r7 >= r6) goto L23;
        String r8 = r13[r7];     // Catch: Throwable -> L25
        int r14 = r8.indexOf("=");     // Catch: Throwable -> L25
        if (r14 < 0) goto L21;
        r10.put(URLDecoder.decode(r8.substring(0, r14), "UTF-8"), URLDecoder.decode(r8.substring(r14 + 1), "UTF-8"));     // Catch: Throwable -> L25
    L22:
        r7 = r7 + 1;     // Catch: Throwable -> L25
        goto L16
    L21:
        r10.put(URLDecoder.decode(r8, "UTF-8"), "");     // Catch: Throwable -> L25
    L23:
        return new Pair(r4, r5);
    L26:
        throw new IOException("parseUrl url is fail !!!");
    L28:
        throw new IOException("parseUrl url is null !!!");
    }

    public static Pair<String, String> k(String r10, Map<String, List<String>> r11) {
        if (com.bytedance.common.utility.k.c(r10) == true) goto L34;
        Uri r12 = Uri.parse(r10);     // Catch: Throwable -> L31
        StringBuilder r0 = new StringBuilder();     // Catch: Throwable -> L31
        String r1 = r12.getScheme();     // Catch: Throwable -> L31
        String r2 = r12.getHost();     // Catch: Throwable -> L31
        int r3 = r12.getPort();     // Catch: Throwable -> L31
        if (r2 == null) goto L11;
        if (r1 == null) goto L8;
        r0.append(r1);     // Catch: Throwable -> L31
        r0.append("://");     // Catch: Throwable -> L31
    L8:
        r0.append(r2);     // Catch: Throwable -> L31
        if (r3 <= 0) goto L11;
        r0.append(':');     // Catch: Throwable -> L31
        r0.append(r3);     // Catch: Throwable -> L31
    L11:
        String r4 = r0.toString();     // Catch: Throwable -> L31
        String r5 = r12.getEncodedPath();     // Catch: Throwable -> L31
        if (r11 == null) goto L29;
        String r13 = r12.getEncodedQuery();     // Catch: Throwable -> L31
        if (r13 == null) goto L29;
        String[] r14 = r13.split("&");     // Catch: Throwable -> L31
        int r6 = r14.length;     // Catch: Throwable -> L31
        int r7 = 0;
    L16:
        if (r7 >= r6) goto L29;
        String r8 = r14[r7];     // Catch: Throwable -> L31
        int r9 = r8.indexOf("=");     // Catch: Throwable -> L31
        if (r9 < 0) goto L24;
        String r15 = URLDecoder.decode(r8.substring(0, r9), "UTF-8");     // Catch: Throwable -> L31
        List<String> r16 = r11.get(r15);     // Catch: Throwable -> L31
        if (r16 != null) goto L23;
        r16 = new LinkedList();     // Catch: Throwable -> L31
    L23:
        r16.add(URLDecoder.decode(r8.substring(r9 + 1), "UTF-8"));     // Catch: Throwable -> L31
        r11.put(r15, r16);     // Catch: Throwable -> L31
    L28:
        r7 = r7 + 1;     // Catch: Throwable -> L31
        goto L16
    L24:
        String r17 = URLDecoder.decode(r8, "UTF-8");     // Catch: Throwable -> L31
        List<String> r18 = r11.get(r17);     // Catch: Throwable -> L31
        if (r18 != null) goto L27;
        r18 = new LinkedList();     // Catch: Throwable -> L31
    L27:
        r18.add("");     // Catch: Throwable -> L31
        r11.put(r17, r18);     // Catch: Throwable -> L31
    L29:
        return new Pair(r4, r5);
    L32:
        throw new IOException("parseUrl url is fail !!!");
    L34:
        throw new IOException("parseUrl url is null !!!");
    }

    public static URI l(String r2) {
        if (r2 != null) goto L4;
        return null;
    L4:
        if (r2.isEmpty() == true) goto L17;
        return new URI(r2);
    L8:
        return URI.create(r2.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
    L11:
        return a(r2);
    L17:
        return null;
    }
}
