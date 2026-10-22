package obric.time;

import android.text.TextUtils;
import com.android.settings.ApnEditor;
import java.security.cert.X509Certificate;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/* JADX INFO: loaded from: classes5.dex */
public class DefaultHostNameVerify implements HostnameVerifier {
    public DefaultHostNameVerify() {
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String r2, SSLSession r3) {
        return verifyHostName(r2, ((X509Certificate) r3.getPeerCertificates()[0]).getSubjectDN().getName().split(",")[0].substring(3));
    L5:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public static boolean verifyHostName(String r5, String r6) {
        if (TextUtils.isEmpty(r5) == false) goto L5;
    L26:
        return false;
    L5:
        if (TextUtils.isEmpty(r6) == true) goto L26;
        String r7 = r6.toLowerCase(Locale.US);
        if (r7.contains(ApnEditor.APN_TYPE_ALL) == true) goto L12;
        return r5.equals(r7);
    L12:
        if (r7.startsWith("*.") == true) goto L14;
    L16:
        int r0 = r7.indexOf(42);
        if (r0 <= r7.indexOf(46)) goto L20;
        return false;
    L20:
        if (r5.regionMatches(0, r7, 0, r0) == true) goto L22;
        return false;
    L22:
        int r1 = r0 + 1;
        int r3 = r7.length() - r1;
        if (r5.regionMatches(r5.length() - r3, r7, r1, r3) == true) goto L25;
        return false;
    L25:
        return true;
    L14:
        if (r5.regionMatches(0, r7, 2, r7.length() - 2) == false) goto L16;
        return true;
    }
}
