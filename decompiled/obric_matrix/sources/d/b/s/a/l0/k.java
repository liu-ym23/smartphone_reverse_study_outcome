package d.b.s.a.l0;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.text.TextUtils;
import java.io.IOException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.Locale;
import javax.net.ssl.SSLPeerUnverifiedException;
import org.apache.http.conn.ConnectTimeoutException;

/* JADX INFO: loaded from: classes.dex */
public final class k {
    public static int a(Context r6, Throwable r7) {
        d.b.s.a.i r0 = com.ss.android.i.j.k().d();
        if (r0 == null) goto L8;
        int r1 = r0.f(r6, r7);
        if (r1 >= 0) goto L8;
        return r1;
    L8:
        if ((r7 instanceof ConnectTimeoutException) == false) goto L11;
        int r8 = -13;
    L25:
        if (r6 == null) goto L32;
        if (r8 == (-15)) goto L29;
        if (r8 == (-14)) goto L29;
        return r8;
    L29:
        if (c(r6) == true) goto L34;
        return -12;
    L34:
        return r8;
    L32:
        return r8;
    L11:
        if ((r7 instanceof SocketTimeoutException) == false) goto L14;
        r8 = -14;
        goto L25
    L14:
        if ((r7 instanceof SocketException) == false) goto L18;
        StringBuilder r2 = new StringBuilder();
        String r4 = "api socket exception: ";
    L16:
        r2.append(r4);
        r2.append(r7);
        d.b.s.a.a0.a.g("NetUtils", r2.toString());
        r8 = -15;
        goto L25
    L18:
        if ((r7 instanceof SSLPeerUnverifiedException) == false) goto L22;
        int r3 = -21;
        d.b.s.a.a0.a.g("NetUtils", "api ssl exception: " + r7);
    L20:
        r8 = r3;
        goto L25
    L22:
        if ((r7 instanceof IOException) == false) goto L24;
        r2 = new StringBuilder();
        r4 = "api io exception: ";
        goto L16
    L24:
        r3 = -18;
        d.b.s.a.a0.a.h("NetUtils", "api exception: " + r7);
        goto L20
    }

    public static String b(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return null;
    L5:
        Uri r3 = Uri.parse(r2);
        if (r3 == null) goto L11;
        String r1 = r3.getPath();
        if (TextUtils.isEmpty(r1) == false) goto L10;
        return r1;
    L10:
        return r1.toLowerCase(Locale.getDefault());
    L11:
        return null;
    }

    public static boolean c(Context r2) {
        NetworkInfo r3 = ((ConnectivityManager) r2.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Exception -> L9
        if (r3 == null) goto L12;
        if (r3.isAvailable() == false) goto L13;
        return true;
    L13:
        return false;
    L12:
        return false;
    L14:
        return false;
    }
}
