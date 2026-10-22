package org.chromium;

import a.a;
import com.ttnet.org.chromium.net.CronetException;
import com.ttnet.org.chromium.net.NetworkException;
import com.ttnet.org.chromium.net.impl.NetworkExceptionImpl;
import java.io.IOException;
import java.net.ConnectException;
import java.net.NoRouteToHostException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.conn.ConnectTimeoutException;

/* JADX INFO: loaded from: classes2.dex */
public class Utils {
    public Utils() {
    }

    public static CronetException createCronetException(int r2, int r3, String r4) {
        int r5 = mapUrlRequestErrorToApiErrorCode(r2);
        return new NetworkExceptionImpl(a.A("Exception in CronetUrlRequest: ", r4), r5, r3);
    }

    public static List getAllInterfaces(Class r6) {
        if (r6 != null) goto L5;
        return null;
    L5:
        ArrayList r0 = new ArrayList();
    L6:
        if (r6 == null) goto L21;
        Class<?>[] r1 = r6.getInterfaces();
        int r2 = 0;
    L9:
        if (r2 >= r1.length) goto L20;
        if (r0.contains(r1[r2]) == true) goto L13;
        r0.add(r1[r2]);
    L13:
        Iterator r3 = getAllInterfaces(r1[r2]).iterator();
    L15:
        if (r3.hasNext() == false) goto L19;
        Class r4 = (Class) r3.next();
        if (r0.contains(r4) == true) goto L15;
        r0.add(r4);
        goto L15
    L19:
        r2 = r2 + 1;
        goto L9
    L20:
        r6 = r6.getSuperclass();
        goto L6
    L21:
        return r0;
    }

    public static int mapUrlRequestErrorToApiErrorCode(int r3) {
        switch(r3) {
            case 1: goto L27;
            case 2: goto L25;
            case 3: goto L23;
            case 4: goto L21;
            case 5: goto L19;
            case 6: goto L17;
            case 7: goto L15;
            case 8: goto L13;
            case 9: goto L11;
            case 10: goto L9;
            case 11: goto L7;
            default: goto L4;
        };
    L7:
        return 11;
    L9:
        return 10;
    L11:
        return 9;
    L13:
        return 8;
    L15:
        return 7;
    L17:
        return 6;
    L19:
        return 5;
    L21:
        return 4;
    L23:
        return 3;
    L25:
        return 2;
    L27:
        return 1;
    L4:
        if (CronetDependManager.inst().loggerDebug() == false) goto L6;
        CronetDependManager.inst().loggerD("monitor", "Unknown error code: " + r3);
    L6:
        return r3;
    }

    public static IOException tryConvertCronetException(CronetException r3) {
        if ((r3 instanceof NetworkException) == true) goto L6;
        return r3;
    L6:
        switch(((NetworkException) r3).getErrorCode()) {
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L14;
            case 4: goto L13;
            case 5: goto L12;
            case 6: goto L11;
            case 7: goto L12;
            case 8: goto L10;
            case 9: goto L8;
            default: goto L17;
        };
    L8:
        IOException r0 = new NoRouteToHostException(r3.getMessage());
    L16:
        return r0;
    L10:
        r0 = new SocketException("reset by peer " + r3.getMessage());
        goto L16
    L11:
        r0 = new ConnectTimeoutException(r3.getMessage());
        goto L16
    L12:
        r0 = new ConnectException(r3.getMessage());
        goto L16
    L13:
        r0 = new SocketTimeoutException(r3.getMessage());
        goto L16
    L14:
        r0 = new ConnectException(r3.getMessage());
        goto L16
    L15:
        r0 = new UnknownHostException(r3.getMessage());
        goto L16
    L17:
        return r3;
    }
}
