package tmsdkobf;

import com.bytedance.platform.godzilla.common.Constant;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public abstract class xi {
    public static s a(i r5, URL r6, Map r7) {
        BufferedInputStream r0 = null;
        HttpURLConnection r1 = (HttpURLConnection) r6.openConnection();     // Catch: Throwable -> L33
        r1.setRequestProperty("User-Agent", "Turing");     // Catch: Throwable -> L31
        r1.setRequestProperty("Accept-Charset", Constant.CHARSET_UTF_8);     // Catch: Throwable -> L31
        if (r7.isEmpty() == true) goto L10;
        Iterator r8 = r7.entrySet().iterator();     // Catch: Throwable -> L31
    L8:
        if (r8.hasNext() == false) goto L10;
        Map.Entry r2 = (Map.Entry) r8.next();     // Catch: Throwable -> L31
        r1.setRequestProperty((String) r2.getKey(), (String) r2.getValue());     // Catch: Throwable -> L31
    L10:
        r1.setRequestMethod(r5.c);     // Catch: Throwable -> L31
        r1.setUseCaches(false);     // Catch: Throwable -> L31
        r1.setConnectTimeout(r5.e);     // Catch: Throwable -> L31
        r1.setReadTimeout(r5.f);     // Catch: Throwable -> L31
        r1.setInstanceFollowRedirects(r5.g);     // Catch: Throwable -> L31
        s.a r9 = new s.a();     // Catch: Throwable -> L31
        int r10 = r1.getResponseCode();     // Catch: Throwable -> L31
        if (r10 != 200) goto L13;
        BufferedInputStream r11 = new BufferedInputStream(r1.getInputStream());     // Catch: Throwable -> L31
        ByteArrayOutputStream r3 = new ByteArrayOutputStream();     // Catch: Throwable -> L29
        j.a(r11, r3);     // Catch: Throwable -> L29
        URL r4 = r1.getURL();     // Catch: Throwable -> L29
        if (r6.getHost().equals(r4.getHost()) == true) goto L25;
        r9.d = true;     // Catch: Throwable -> L29
        r9.c = r4.toString();     // Catch: Throwable -> L29
    L25:
        r9.b = r3.toByteArray();     // Catch: Throwable -> L29
        s r12 = new s(r9);     // Catch: Throwable -> L29
        j.a(r11);
        r1.disconnect();     // Catch: Throwable -> L41
    L28:
        return r12;
    L29:
        th = th;
        r0 = r11;
    L35:
        j.a(r0);
        if (r1 != null) goto L45;
    L38:
        throw th;
    L45:
        r1.disconnect();     // Catch: Throwable -> L42
        goto L38
    L13:
        if (r10 == 305) goto L18;
        switch(r10) {
            case 300: goto L18;
            case 301: goto L18;
            case 302: goto L18;
            case 303: goto L18;
            default: goto L15;
        };     // Catch: Throwable -> L31
    L15:
        r9.f494a = r10;     // Catch: Throwable -> L31
        s r13 = new s(r9);     // Catch: Throwable -> L31
        r1.disconnect();     // Catch: Throwable -> L39
    L17:
        return r13;
    L18:
        r9.f494a = r10;     // Catch: Throwable -> L31
        r9.d = true;     // Catch: Throwable -> L31
        r9.c = r1.getHeaderField("Location");     // Catch: Throwable -> L31
        s r14 = new s(r9);     // Catch: Throwable -> L31
        r1.disconnect();     // Catch: Throwable -> L40
    L20:
        return r14;
    L31:
        th = th;
    L33:
        th = th;
        r1 = null;
        goto L35
    }
}
