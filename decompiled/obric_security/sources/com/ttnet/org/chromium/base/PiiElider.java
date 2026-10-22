package com.ttnet.org.chromium.base;

import android.text.TextUtils;
import android.util.Patterns;
import com.bytedance.librarian.LibrarianImpl;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: classes4.dex */
public class PiiElider {
    private static final String[] APP_NAMESPACE = null;
    private static final String CONSOLE_ELISION = "[ELIDED:CONSOLE(0)] ELIDED CONSOLE MESSAGE";
    private static final Pattern CONSOLE_MSG = null;
    private static final String DOMAIN_NAME = "(([a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef]([a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef-]{0,61}[a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef]){0,1}\\.)+[a-zA-Z -\ud7ff豈-﷏ﷰ-\uffef]{2,63}|((25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9])\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[0-9])))";
    private static final String EMAIL_ELISION = "XXX@EMAIL.ELIDED";
    private static final String GOOD_GTLD_CHAR = "a-zA-Z -\ud7ff豈-﷏ﷰ-\uffef";
    private static final String GOOD_IRI_CHAR = "a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef";
    private static final String GTLD = "[a-zA-Z -\ud7ff豈-﷏ﷰ-\uffef]{2,63}";
    private static final String HOST_NAME = "([a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef]([a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef-]{0,61}[a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef]){0,1}\\.)+[a-zA-Z -\ud7ff豈-﷏ﷰ-\uffef]{2,63}";
    private static final String INTENT = "([a-zA-Z][a-zA-Z0-9+.-]+://((([a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef;/?:@&=#~.+!*'(),_-])|(%[a-fA-F0-9]{2}))+))";
    private static final String INTENT_SCHEME = "[a-zA-Z][a-zA-Z0-9+.-]+://";
    private static final String IP_ADDRESS = "((25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9])\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[0-9]))";
    private static final String IP_ELISION = "1.2.3.4";
    private static final String IRI = "[a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef]([a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef-]{0,61}[a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef]){0,1}";
    private static final Pattern LIKELY_EXCEPTION_LOG = null;
    private static final Pattern MAC_ADDRESS = null;
    private static final String MAC_ELISION = "01:23:45:67:89:AB";
    private static final String PATH_CHAR = "(([a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef;/?:@&=#~.+!*'(),_-])|(%[a-fA-F0-9]{2}))";
    private static final String PATH_COMPONENT = "((([a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef;/?:@&=#~.+!*'(),_-])|(%[a-fA-F0-9]{2}))+)";
    private static final String PORT = "(:\\d{1,5})";
    private static final String[] SYSTEM_NAMESPACE = null;
    private static final String URI_CHAR = "([a-zA-Z0-9$_.+!*'(),;?&=-]|(%[a-fA-F0-9]{2}))";
    private static final String URI_ENCODED_CHAR = "(%[a-fA-F0-9]{2})";
    private static final String URI_SCHEME = "((http|https|Http|Https|rtsp|Rtsp)://(([a-zA-Z0-9$_.+!*'(),;?&=-]|(%[a-fA-F0-9]{2})){1,64}(:([a-zA-Z0-9$_.+!*'(),;?&=-]|(%[a-fA-F0-9]{2})){1,25})?@)?)";
    private static final String URL_ELISION = "HTTP://WEBADDRESS.ELIDED";
    private static final String URL_OR_INTENT = "((((http|https|Http|Https|rtsp|Rtsp)://(([a-zA-Z0-9$_.+!*'(),;?&=-]|(%[a-fA-F0-9]{2})){1,64}(:([a-zA-Z0-9$_.+!*'(),;?&=-]|(%[a-fA-F0-9]{2})){1,25})?@)?)?(([a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef]([a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef-]{0,61}[a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef]){0,1}\\.)+[a-zA-Z -\ud7ff豈-﷏ﷰ-\uffef]{2,63}|((25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9])\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[0-9])))(:\\d{1,5})?)|([a-zA-Z][a-zA-Z0-9+.-]+://((([a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef;/?:@&=#~.+!*'(),_-])|(%[a-fA-F0-9]{2}))+)))";
    private static final String URL_WITH_OPTIONAL_SCHEME_AND_PORT = "(((http|https|Http|Https|rtsp|Rtsp)://(([a-zA-Z0-9$_.+!*'(),;?&=-]|(%[a-fA-F0-9]{2})){1,64}(:([a-zA-Z0-9$_.+!*'(),;?&=-]|(%[a-fA-F0-9]{2})){1,25})?@)?)?(([a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef]([a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef-]{0,61}[a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef]){0,1}\\.)+[a-zA-Z -\ud7ff豈-﷏ﷰ-\uffef]{2,63}|((25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9])\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[0-9])))(:\\d{1,5})?)";
    private static final Pattern WEB_URL = null;

    public PiiElider() {
    }

    static {
        WEB_URL = Pattern.compile("(\\b|^)(((((http|https|Http|Https|rtsp|Rtsp)://(([a-zA-Z0-9$_.+!*'(),;?&=-]|(%[a-fA-F0-9]{2})){1,64}(:([a-zA-Z0-9$_.+!*'(),;?&=-]|(%[a-fA-F0-9]{2})){1,25})?@)?)?(([a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef]([a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef-]{0,61}[a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef]){0,1}\\.)+[a-zA-Z -\ud7ff豈-﷏ﷰ-\uffef]{2,63}|((25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9])\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[0-9])))(:\\d{1,5})?)|([a-zA-Z][a-zA-Z0-9+.-]+://((([a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef;/?:@&=#~.+!*'(),_-])|(%[a-fA-F0-9]{2}))+))))(/(([a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef;/?:@&=#~.+!*'(),_-])|(%[a-fA-F0-9]{2}))*)?(\\b|$)");
        LIKELY_EXCEPTION_LOG = Pattern.compile("\\sat\\sorg\\.chromium\\.[^ ]+.|Caused by: java.lang.(ClassNotFoundException|NoClassDefFoundError):");
        MAC_ADDRESS = Pattern.compile("([0-9a-fA-F]{2}[-:]+){5}[0-9a-fA-F]{2}");
        CONSOLE_MSG = Pattern.compile("\\[\\w*:CONSOLE.*\\].*");
        APP_NAMESPACE = new String[]{"com.ttnet.org.chromium.", "com.google.", "com.chrome."};
        SYSTEM_NAMESPACE = new String[]{"android.", "com.android.", "dalvik.", "java.", "javax.", "org.apache.", "org.json.", "org.w3c.dom.", "org.xml.", "org.xmlpull."};
    }

    public static String elideEmail(String r1) {
        return Patterns.EMAIL_ADDRESS.matcher(r1).replaceAll(EMAIL_ELISION);
    L4:
        return "";
    }

    public static String elideUrl(String r5) {
    L18:
        return "";
    L3:
        if (LIKELY_EXCEPTION_LOG.matcher(r5).find() == false) goto L5;
        return r5;
    L5:
        StringBuilder r0 = new StringBuilder(r5);     // Catch: IllegalArgumentException -> L18
        Matcher r6 = WEB_URL.matcher(r0);     // Catch: IllegalArgumentException -> L18
        int r1 = 0;
    L7:
        if (r6.find(r1) == false) goto L16;
        int r2 = r6.start();     // Catch: IllegalArgumentException -> L18
        int r3 = r6.end();     // Catch: IllegalArgumentException -> L18
        String r4 = r0.substring(r2, r3);     // Catch: IllegalArgumentException -> L18
        if (likelyToBeAppNamespace(r4) == true) goto L15;
        if (likelyToBeSystemNamespace(r4) == true) goto L15;
        if (likelyToBeClassOrMethodName(r4) == true) goto L15;
        r0.replace(r2, r3, URL_ELISION);     // Catch: IllegalArgumentException -> L18
        r1 = r2 + 24;     // Catch: IllegalArgumentException -> L18
        r6 = WEB_URL.matcher(r0);     // Catch: IllegalArgumentException -> L18
    L15:
        r1 = r3;
        goto L7
    L16:
        return r0.toString();
    }

    private static boolean likelyToBeClassOrMethodName(String r3) {
        if (isClassName(r3) == false) goto L6;
        return true;
    L6:
        int r0 = r3.lastIndexOf(LibrarianImpl.Constants.DOT);
        if (r0 != (-1)) goto L10;
        return false;
    L10:
        return isClassName(r3.substring(0, r0));
    }

    private static boolean isClassName(String r2) {
        Class.forName(r2, false, ContextUtils.getApplicationContext().getClassLoader());     // Catch: Throwable -> L6
        return true;
    L6:
        return false;
    }

    private static boolean likelyToBeAppNamespace(String r5) {
        String[] r0 = APP_NAMESPACE;
        int r1 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L9;
        if (r5.startsWith(r0[r3]) == true) goto L6;
        r3 = r3 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    private static boolean likelyToBeSystemNamespace(String r5) {
        String[] r0 = SYSTEM_NAMESPACE;
        int r1 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L9;
        if (r5.startsWith(r0[r3]) == true) goto L6;
        r3 = r3 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public static String elideIp(String r1) {
        return Patterns.IP_ADDRESS.matcher(r1).replaceAll(IP_ELISION);
    L4:
        return "";
    }

    public static String elideMac(String r1) {
        return MAC_ADDRESS.matcher(r1).replaceAll(MAC_ELISION);
    L4:
        return "";
    }

    public static String elideConsole(String r1) {
        return CONSOLE_MSG.matcher(r1).replaceAll(CONSOLE_ELISION);
    L4:
        return "";
    }

    public static String sanitizeStacktrace(String r3) {
        String[] r4 = r3.split("\\n");
        r4[0] = elideUrl(r4[0]);
        int r0 = 1;
    L4:
        if (r0 >= r4.length) goto L10;
        if (r4[r0].startsWith("Caused by:") == false) goto L8;
        r4[r0] = elideUrl(r4[r0]);
    L8:
        r0 = r0 + 1;
        goto L4
    L10:
        return TextUtils.join(IOUtils.LINE_SEPARATOR_UNIX, r4);
    }
}
