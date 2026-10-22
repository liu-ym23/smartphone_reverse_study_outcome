package com.bytedance.frameworks.baselib.network.http.util;

import a.a;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.common.utility.StringUtils;
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
public class UrlUtils {
    public static final String CONTENT_TYPE = "Content-Type";
    public static final int CR = 13;
    public static final String DEFAULT_CONTENT_CHARSET = "ISO-8859-1";
    private static final String DOMAIN_NAME_STR = "(([a-zA-Z0-9[ -\ud7ff豈-﷏ﷰ-\uffef𐀀-\u1fffd𠀀-\u2fffd𰀀-\u3fffd\u40000-\u4fffd\u50000-\u5fffd\u60000-\u6fffd\u70000-\u7fffd\u80000-\u8fffd\u90000-\u9fffd\ua0000-\uafffd\ub0000-\ubfffd\uc0000-\ucfffd\ud0000-\udfffd\ue1000-\uefffd&&[^ [\u2000-\u200a]\u2028\u2029 \u3000]]](?:[a-zA-Z0-9[ -\ud7ff豈-﷏ﷰ-\uffef𐀀-\u1fffd𠀀-\u2fffd𰀀-\u3fffd\u40000-\u4fffd\u50000-\u5fffd\u60000-\u6fffd\u70000-\u7fffd\u80000-\u8fffd\u90000-\u9fffd\ua0000-\uafffd\ub0000-\ubfffd\uc0000-\ucfffd\ud0000-\udfffd\ue1000-\uefffd&&[^ [\u2000-\u200a]\u2028\u2029 \u3000]]_\\-]{0,61}[a-zA-Z0-9[ -\ud7ff豈-﷏ﷰ-\uffef𐀀-\u1fffd𠀀-\u2fffd𰀀-\u3fffd\u40000-\u4fffd\u50000-\u5fffd\u60000-\u6fffd\u70000-\u7fffd\u80000-\u8fffd\u90000-\u9fffd\ua0000-\uafffd\ub0000-\ubfffd\uc0000-\ucfffd\ud0000-\udfffd\ue1000-\uefffd&&[^ [\u2000-\u200a]\u2028\u2029 \u3000]]]){0,1}\\.)+(xn\\-\\-[\\w\\-]{0,58}\\w|[a-zA-Z[ -\ud7ff豈-﷏ﷰ-\uffef𐀀-\u1fffd𠀀-\u2fffd𰀀-\u3fffd\u40000-\u4fffd\u50000-\u5fffd\u60000-\u6fffd\u70000-\u7fffd\u80000-\u8fffd\u90000-\u9fffd\ua0000-\uafffd\ub0000-\ubfffd\uc0000-\ucfffd\ud0000-\udfffd\ue1000-\uefffd&&[^ [\u2000-\u200a]\u2028\u2029 \u3000]]]{2,63})|((25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9])\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[0-9])))";
    private static final String HOST_NAME = "([a-zA-Z0-9[ -\ud7ff豈-﷏ﷰ-\uffef𐀀-\u1fffd𠀀-\u2fffd𰀀-\u3fffd\u40000-\u4fffd\u50000-\u5fffd\u60000-\u6fffd\u70000-\u7fffd\u80000-\u8fffd\u90000-\u9fffd\ua0000-\uafffd\ub0000-\ubfffd\uc0000-\ucfffd\ud0000-\udfffd\ue1000-\uefffd&&[^ [\u2000-\u200a]\u2028\u2029 \u3000]]](?:[a-zA-Z0-9[ -\ud7ff豈-﷏ﷰ-\uffef𐀀-\u1fffd𠀀-\u2fffd𰀀-\u3fffd\u40000-\u4fffd\u50000-\u5fffd\u60000-\u6fffd\u70000-\u7fffd\u80000-\u8fffd\u90000-\u9fffd\ua0000-\uafffd\ub0000-\ubfffd\uc0000-\ucfffd\ud0000-\udfffd\ue1000-\uefffd&&[^ [\u2000-\u200a]\u2028\u2029 \u3000]]_\\-]{0,61}[a-zA-Z0-9[ -\ud7ff豈-﷏ﷰ-\uffef𐀀-\u1fffd𠀀-\u2fffd𰀀-\u3fffd\u40000-\u4fffd\u50000-\u5fffd\u60000-\u6fffd\u70000-\u7fffd\u80000-\u8fffd\u90000-\u9fffd\ua0000-\uafffd\ub0000-\ubfffd\uc0000-\ucfffd\ud0000-\udfffd\ue1000-\uefffd&&[^ [\u2000-\u200a]\u2028\u2029 \u3000]]]){0,1}\\.)+(xn\\-\\-[\\w\\-]{0,58}\\w|[a-zA-Z[ -\ud7ff豈-﷏ﷰ-\uffef𐀀-\u1fffd𠀀-\u2fffd𰀀-\u3fffd\u40000-\u4fffd\u50000-\u5fffd\u60000-\u6fffd\u70000-\u7fffd\u80000-\u8fffd\u90000-\u9fffd\ua0000-\uafffd\ub0000-\ubfffd\uc0000-\ucfffd\ud0000-\udfffd\ue1000-\uefffd&&[^ [\u2000-\u200a]\u2028\u2029 \u3000]]]{2,63})";
    public static final int HT = 9;
    private static final String IP_ADDRESS_STRING = "((25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9])\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[0-9]))";
    private static final String IRI_LABEL = "[a-zA-Z0-9[ -\ud7ff豈-﷏ﷰ-\uffef𐀀-\u1fffd𠀀-\u2fffd𰀀-\u3fffd\u40000-\u4fffd\u50000-\u5fffd\u60000-\u6fffd\u70000-\u7fffd\u80000-\u8fffd\u90000-\u9fffd\ua0000-\uafffd\ub0000-\ubfffd\uc0000-\ucfffd\ud0000-\udfffd\ue1000-\uefffd&&[^ [\u2000-\u200a]\u2028\u2029 \u3000]]](?:[a-zA-Z0-9[ -\ud7ff豈-﷏ﷰ-\uffef𐀀-\u1fffd𠀀-\u2fffd𰀀-\u3fffd\u40000-\u4fffd\u50000-\u5fffd\u60000-\u6fffd\u70000-\u7fffd\u80000-\u8fffd\u90000-\u9fffd\ua0000-\uafffd\ub0000-\ubfffd\uc0000-\ucfffd\ud0000-\udfffd\ue1000-\uefffd&&[^ [\u2000-\u200a]\u2028\u2029 \u3000]]_\\-]{0,61}[a-zA-Z0-9[ -\ud7ff豈-﷏ﷰ-\uffef𐀀-\u1fffd𠀀-\u2fffd𰀀-\u3fffd\u40000-\u4fffd\u50000-\u5fffd\u60000-\u6fffd\u70000-\u7fffd\u80000-\u8fffd\u90000-\u9fffd\ua0000-\uafffd\ub0000-\ubfffd\uc0000-\ucfffd\ud0000-\udfffd\ue1000-\uefffd&&[^ [\u2000-\u200a]\u2028\u2029 \u3000]]]){0,1}";
    private static final String LABEL_CHAR = "a-zA-Z0-9[ -\ud7ff豈-﷏ﷰ-\uffef𐀀-\u1fffd𠀀-\u2fffd𰀀-\u3fffd\u40000-\u4fffd\u50000-\u5fffd\u60000-\u6fffd\u70000-\u7fffd\u80000-\u8fffd\u90000-\u9fffd\ua0000-\uafffd\ub0000-\ubfffd\uc0000-\ucfffd\ud0000-\udfffd\ue1000-\uefffd&&[^ [\u2000-\u200a]\u2028\u2029 \u3000]]";
    public static final int LF = 10;
    private static final String NAME_VALUE_SEPARATOR = "=";
    private static final String PARAMETER_SEPARATOR = "&";
    private static final String PATH_AND_QUERY = "[/\\?](?:(?:[a-zA-Z0-9[ -\ud7ff豈-﷏ﷰ-\uffef𐀀-\u1fffd𠀀-\u2fffd𰀀-\u3fffd\u40000-\u4fffd\u50000-\u5fffd\u60000-\u6fffd\u70000-\u7fffd\u80000-\u8fffd\u90000-\u9fffd\ua0000-\uafffd\ub0000-\ubfffd\uc0000-\ucfffd\ud0000-\udfffd\ue1000-\uefffd&&[^ [\u2000-\u200a]\u2028\u2029 \u3000]];/\\?:@&=#~\\-\\.\\+!\\*'\\(\\),_\\$])|(?:%[a-fA-F0-9]{2}))*";
    private static final String PORT_NUMBER = "\\:\\d{1,5}";
    private static final String PROTOCOL = "(?i:http|https|rtsp|ws|wss)://";
    private static final String PUNYCODE_TLD = "xn\\-\\-[\\w\\-]{0,58}\\w";
    public static final int SP = 32;
    private static final String TLD = "(xn\\-\\-[\\w\\-]{0,58}\\w|[a-zA-Z[ -\ud7ff豈-﷏ﷰ-\uffef𐀀-\u1fffd𠀀-\u2fffd𰀀-\u3fffd\u40000-\u4fffd\u50000-\u5fffd\u60000-\u6fffd\u70000-\u7fffd\u80000-\u8fffd\u90000-\u9fffd\ua0000-\uafffd\ub0000-\ubfffd\uc0000-\ucfffd\ud0000-\udfffd\ue1000-\uefffd&&[^ [\u2000-\u200a]\u2028\u2029 \u3000]]]{2,63})";
    private static final String TLD_CHAR = "a-zA-Z[ -\ud7ff豈-﷏ﷰ-\uffef𐀀-\u1fffd𠀀-\u2fffd𰀀-\u3fffd\u40000-\u4fffd\u50000-\u5fffd\u60000-\u6fffd\u70000-\u7fffd\u80000-\u8fffd\u90000-\u9fffd\ua0000-\uafffd\ub0000-\ubfffd\uc0000-\ucfffd\ud0000-\udfffd\ue1000-\uefffd&&[^ [\u2000-\u200a]\u2028\u2029 \u3000]]";
    private static final String UCS_CHAR = "[ -\ud7ff豈-﷏ﷰ-\uffef𐀀-\u1fffd𠀀-\u2fffd𰀀-\u3fffd\u40000-\u4fffd\u50000-\u5fffd\u60000-\u6fffd\u70000-\u7fffd\u80000-\u8fffd\u90000-\u9fffd\ua0000-\uafffd\ub0000-\ubfffd\uc0000-\ucfffd\ud0000-\udfffd\ue1000-\uefffd&&[^ [\u2000-\u200a]\u2028\u2029 \u3000]]";
    public static final String USER_AGENT = "User-Agent";
    private static final String USER_INFO = "(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,64}(?:\\:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,25})?\\@";
    public static final String UTF_8 = "UTF-8";
    public static final Pattern WEB_URL = null;
    private static final String WORD_BOUNDARY = "(?:\\b|$|^)";

    static {
        WEB_URL = Pattern.compile("(((?:(?i:http|https|rtsp|ws|wss)://(?:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,64}(?:\\:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,25})?\\@)?)?(?:(([a-zA-Z0-9[ -\ud7ff豈-﷏ﷰ-\uffef𐀀-\u1fffd𠀀-\u2fffd𰀀-\u3fffd\u40000-\u4fffd\u50000-\u5fffd\u60000-\u6fffd\u70000-\u7fffd\u80000-\u8fffd\u90000-\u9fffd\ua0000-\uafffd\ub0000-\ubfffd\uc0000-\ucfffd\ud0000-\udfffd\ue1000-\uefffd&&[^ [\u2000-\u200a]\u2028\u2029 \u3000]]](?:[a-zA-Z0-9[ -\ud7ff豈-﷏ﷰ-\uffef𐀀-\u1fffd𠀀-\u2fffd𰀀-\u3fffd\u40000-\u4fffd\u50000-\u5fffd\u60000-\u6fffd\u70000-\u7fffd\u80000-\u8fffd\u90000-\u9fffd\ua0000-\uafffd\ub0000-\ubfffd\uc0000-\ucfffd\ud0000-\udfffd\ue1000-\uefffd&&[^ [\u2000-\u200a]\u2028\u2029 \u3000]]_\\-]{0,61}[a-zA-Z0-9[ -\ud7ff豈-﷏ﷰ-\uffef𐀀-\u1fffd𠀀-\u2fffd𰀀-\u3fffd\u40000-\u4fffd\u50000-\u5fffd\u60000-\u6fffd\u70000-\u7fffd\u80000-\u8fffd\u90000-\u9fffd\ua0000-\uafffd\ub0000-\ubfffd\uc0000-\ucfffd\ud0000-\udfffd\ue1000-\uefffd&&[^ [\u2000-\u200a]\u2028\u2029 \u3000]]]){0,1}\\.)+(xn\\-\\-[\\w\\-]{0,58}\\w|[a-zA-Z[ -\ud7ff豈-﷏ﷰ-\uffef𐀀-\u1fffd𠀀-\u2fffd𰀀-\u3fffd\u40000-\u4fffd\u50000-\u5fffd\u60000-\u6fffd\u70000-\u7fffd\u80000-\u8fffd\u90000-\u9fffd\ua0000-\uafffd\ub0000-\ubfffd\uc0000-\ucfffd\ud0000-\udfffd\ue1000-\uefffd&&[^ [\u2000-\u200a]\u2028\u2029 \u3000]]]{2,63})|((25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9])\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[0-9]))))(?:\\:\\d{1,5})?)([/\\?](?:(?:[a-zA-Z0-9[ -\ud7ff豈-﷏ﷰ-\uffef𐀀-\u1fffd𠀀-\u2fffd𰀀-\u3fffd\u40000-\u4fffd\u50000-\u5fffd\u60000-\u6fffd\u70000-\u7fffd\u80000-\u8fffd\u90000-\u9fffd\ua0000-\uafffd\ub0000-\ubfffd\uc0000-\ucfffd\ud0000-\udfffd\ue1000-\uefffd&&[^ [\u2000-\u200a]\u2028\u2029 \u3000]];/\\?:@&=#~\\-\\.\\+!\\*'\\(\\),_\\$])|(?:%[a-fA-F0-9]{2}))*)?(?:\\b|$|^))");
    }

    public UrlUtils() {
    }

    private static URI createUriWithOutQuery(String r2) {
        if (r2 != null) goto L4;
        return null;
    L4:
        if (r2.isEmpty() == true) goto L19;
        int r0 = r2.indexOf("?");     // Catch: Exception -> L9
        if (r0 <= 0) goto L11;
        r2 = r2.substring(0, r0);     // Catch: Exception -> L9
    L11:
        return URI.create(r2);
    L9:
        e = move-exception;
        throw new RuntimeException(e);
    L19:
        return null;
    }

    private static String encode(String r0, String r1) {
        if (r1 != null) goto L10;
        r1 = "ISO-8859-1";
    L10:
        return URLEncoder.encode(r0, r1);
    L7:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    public static String format(Map<String, List<String>> r5, String r6) {
        StringBuilder r0 = new StringBuilder();
        Iterator<Map.Entry<String, List<String>>> r7 = r5.entrySet().iterator();
    L4:
        if (r7.hasNext() == false) goto L23;
        Map.Entry<String, List<String>> r1 = r7.next();
        String r2 = encode(r1.getKey(), r6);
        List<String> r3 = r1.getValue();
        if (r3 == null) goto L4;
        if (r3.size() <= 0) goto L4;
        Iterator<String> r4 = r3.iterator();
    L11:
        if (r4.hasNext() == false) goto L4;
        String r8 = r4.next();
        if (r8 == null) goto L15;
        String r9 = encode(r8, r6);
    L17:
        if (r0.length() <= 0) goto L19;
        r0.append(PARAMETER_SEPARATOR);
    L19:
        r0.append(r2);
        if (r9.isEmpty() == true) goto L11;
        r0.append(NAME_VALUE_SEPARATOR);
        r0.append(r9);
        goto L11
    L15:
        r9 = "";
        goto L17
    L23:
        return r0.toString();
    }

    private static boolean isHttpUrl(String r3) {
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

    private static boolean isHttpsUrl(String r3) {
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

    public static boolean isValidUrl(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L6;
        return false;
    L6:
        if (isHttpsUrl(r2) == true) goto L18;
        if (isHttpUrl(r2) == true) goto L18;
        if (isWssUrl(r2) == true) goto L18;
        if (isWsUrl(r2) == true) goto L18;
        return false;
    L18:
        return WEB_URL.matcher(r2).matches();
    L20:
        return false;
    }

    public static boolean isWhitespace(char r1) {
        if (r1 != ' ') goto L5;
    L12:
        return true;
    L5:
        if (r1 == '\t') goto L12;
        if (r1 == '\r') goto L12;
        if (r1 == '\n') goto L12;
        return false;
    }

    private static boolean isWsUrl(String r3) {
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

    private static boolean isWssUrl(String r3) {
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

    public static boolean matchPattern(String r12, String r13) {
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
    public static Pair<String, String> parseUrl(String r9, Map<String, String> r10) {
        if (StringUtils.isEmpty(r9) == true) goto L30;
        Uri r11 = Uri.parse(r9);     // Catch: Throwable -> L8
        StringBuilder r0 = new StringBuilder();     // Catch: Throwable -> L8
        String r1 = r11.getScheme();     // Catch: Throwable -> L8
        String r2 = r11.getHost();     // Catch: Throwable -> L8
        int r3 = r11.getPort();     // Catch: Throwable -> L8
        if (r2 == null) goto L13;
        if (r1 == null) goto L10;
        r0.append(r1);     // Catch: Throwable -> L8
        r0.append("://");     // Catch: Throwable -> L8
    L10:
        r0.append(r2);     // Catch: Throwable -> L8
        if (r3 <= 0) goto L13;
        r0.append(':');     // Catch: Throwable -> L8
        r0.append(r3);     // Catch: Throwable -> L8
    L13:
        String r4 = r0.toString();     // Catch: Throwable -> L8
        String r5 = r11.getEncodedPath();     // Catch: Throwable -> L8
        if (r10 == null) goto L25;
        String r12 = r11.getEncodedQuery();     // Catch: Throwable -> L8
        if (r12 == null) goto L25;
        String[] r13 = r12.split(PARAMETER_SEPARATOR);     // Catch: Throwable -> L8
        int r6 = r13.length;     // Catch: Throwable -> L8
        int r7 = 0;
    L18:
        if (r7 >= r6) goto L25;
        String r8 = r13[r7];     // Catch: Throwable -> L8
        int r14 = r8.indexOf(NAME_VALUE_SEPARATOR);     // Catch: Throwable -> L8
        if (r14 < 0) goto L23;
        r10.put(URLDecoder.decode(r8.substring(0, r14), "UTF-8"), URLDecoder.decode(r8.substring(r14 + 1), "UTF-8"));     // Catch: Throwable -> L8
    L24:
        r7 = r7 + 1;     // Catch: Throwable -> L8
        goto L18
    L23:
        r10.put(URLDecoder.decode(r8, "UTF-8"), "");     // Catch: Throwable -> L8
    L25:
        return new Pair(r4, r5);
    L8:
        th = move-exception;
        th.printStackTrace();
        throw new IOException("parseUrl url is fail !!!");
    L30:
        throw new IOException("parseUrl url is null !!!");
    }

    public static Pair<String, String> parseUrlWithValueList(String r10, Map<String, List<String>> r11) {
        if (StringUtils.isEmpty(r10) == true) goto L36;
        Uri r12 = Uri.parse(r10);     // Catch: Throwable -> L8
        StringBuilder r0 = new StringBuilder();     // Catch: Throwable -> L8
        String r1 = r12.getScheme();     // Catch: Throwable -> L8
        String r2 = r12.getHost();     // Catch: Throwable -> L8
        int r3 = r12.getPort();     // Catch: Throwable -> L8
        if (r2 == null) goto L13;
        if (r1 == null) goto L10;
        r0.append(r1);     // Catch: Throwable -> L8
        r0.append("://");     // Catch: Throwable -> L8
    L10:
        r0.append(r2);     // Catch: Throwable -> L8
        if (r3 <= 0) goto L13;
        r0.append(':');     // Catch: Throwable -> L8
        r0.append(r3);     // Catch: Throwable -> L8
    L13:
        String r4 = r0.toString();     // Catch: Throwable -> L8
        String r5 = r12.getEncodedPath();     // Catch: Throwable -> L8
        if (r11 == null) goto L31;
        String r13 = r12.getEncodedQuery();     // Catch: Throwable -> L8
        if (r13 == null) goto L31;
        String[] r14 = r13.split(PARAMETER_SEPARATOR);     // Catch: Throwable -> L8
        int r6 = r14.length;     // Catch: Throwable -> L8
        int r7 = 0;
    L18:
        if (r7 >= r6) goto L31;
        String r8 = r14[r7];     // Catch: Throwable -> L8
        int r9 = r8.indexOf(NAME_VALUE_SEPARATOR);     // Catch: Throwable -> L8
        if (r9 < 0) goto L26;
        String r15 = URLDecoder.decode(r8.substring(0, r9), "UTF-8");     // Catch: Throwable -> L8
        List<String> r16 = r11.get(r15);     // Catch: Throwable -> L8
        if (r16 != null) goto L25;
        r16 = new LinkedList();     // Catch: Throwable -> L8
    L25:
        r16.add(URLDecoder.decode(r8.substring(r9 + 1), "UTF-8"));     // Catch: Throwable -> L8
        r11.put(r15, r16);     // Catch: Throwable -> L8
    L30:
        r7 = r7 + 1;     // Catch: Throwable -> L8
        goto L18
    L26:
        String r17 = URLDecoder.decode(r8, "UTF-8");     // Catch: Throwable -> L8
        List<String> r18 = r11.get(r17);     // Catch: Throwable -> L8
        if (r18 != null) goto L29;
        r18 = new LinkedList();     // Catch: Throwable -> L8
    L29:
        r18.add("");     // Catch: Throwable -> L8
        r11.put(r17, r18);     // Catch: Throwable -> L8
    L31:
        return new Pair(r4, r5);
    L8:
        th = move-exception;
        th.printStackTrace();
        throw new IOException("parseUrl url is fail !!!");
    L36:
        throw new IOException("parseUrl url is null !!!");
    }

    public static String replacePlusInEncodeUrl(String r3) {
        int r0 = r3.indexOf("?");
        if (r0 > 0) goto L5;
        return r3;
    L5:
        return a.j(r3.substring(0, r0), r3.substring(r0).replaceAll("\\+", "%20"));
    }

    public static URI safeCreateUri(String r2) {
        if (r2 != null) goto L4;
        return null;
    L4:
        if (r2.isEmpty() == true) goto L17;
        return new URI(r2);
    L8:
        return URI.create(r2.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
    L11:
        return createUriWithOutQuery(r2);
    L17:
        return null;
    }
}
