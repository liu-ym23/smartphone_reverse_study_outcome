package androidx.core.net;

import android.net.Uri;
import com.bytedance.frameworks.baselib.network.http.util.HttpHost;
import com.bytedanceos.preventdisturb.Contact;

/* JADX INFO: loaded from: classes.dex */
public final class UriCompat {
    private UriCompat() {
    }

    public static String toSafeString(Uri r7) {
        String r0 = r7.getScheme();
        String r1 = r7.getSchemeSpecificPart();
        if (r0 != null) goto L5;
    L49:
        StringBuilder r8 = new StringBuilder(64);
        if (r0 == null) goto L52;
        r8.append(r0);
        r8.append(':');
    L52:
        if (r1 == null) goto L55;
        r8.append(r1);
    L55:
        return r8.toString();
    L5:
        if (r0.equalsIgnoreCase(Contact.TEL_SCHEME) == false) goto L7;
    L33:
        StringBuilder r9 = new StringBuilder(64);
        r9.append(r0);
        r9.append(':');
        if (r1 == null) goto L48;
        int r2 = 0;
    L37:
        if (r2 >= r1.length()) goto L48;
        char r3 = r1.charAt(r2);
        if (r3 == '-') goto L45;
        if (r3 == '@') goto L45;
        if (r3 == '.') goto L45;
        r9.append('x');
    L46:
        r2 = r2 + 1;
    L45:
        r9.append(r3);
    L48:
        return r9.toString();
    L7:
        if (r0.equalsIgnoreCase("sip") == true) goto L33;
        if (r0.equalsIgnoreCase("sms") == true) goto L33;
        if (r0.equalsIgnoreCase("smsto") == true) goto L33;
        if (r0.equalsIgnoreCase("mailto") == true) goto L33;
        if (r0.equalsIgnoreCase("nfc") == true) goto L33;
        if (r0.equalsIgnoreCase(HttpHost.DEFAULT_SCHEME_NAME) == false) goto L20;
    L25:
        StringBuilder r4 = new StringBuilder("//");
        String r5 = "";
        if (r7.getHost() == null) goto L28;
        String r6 = r7.getHost();
    L29:
        StringBuilder r10 = r4.append(r6);
        if (r7.getPort() == (-1)) goto L32;
        r5 = ":" + r7.getPort();
    L32:
        r1 = r10.append(r5).append("/...").toString();
        goto L49
    L28:
        r6 = "";
        goto L29
    L20:
        if (r0.equalsIgnoreCase("https") == true) goto L25;
        if (r0.equalsIgnoreCase("ftp") == true) goto L25;
        if (r0.equalsIgnoreCase("rtsp") == false) goto L49;
        goto L25
    }
}
