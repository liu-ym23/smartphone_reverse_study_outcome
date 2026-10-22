package org.chromium;

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

/* JADX INFO: loaded from: classes6.dex */
public class Utils {
    public Utils() {
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
            case 1: goto L26;
            case 2: goto L24;
            case 3: goto L22;
            case 4: goto L20;
            case 5: goto L18;
            case 6: goto L16;
            case 7: goto L14;
            case 8: goto L12;
            case 9: goto L10;
            case 10: goto L8;
            case 11: goto L6;
            default: goto L4;
        };
    L6:
        return 11;
    L8:
        return 10;
    L10:
        return 9;
    L12:
        return 8;
    L14:
        return 7;
    L16:
        return 6;
    L18:
        return 5;
    L20:
        return 4;
    L22:
        return 3;
    L24:
        return 2;
    L26:
        return 1;
    L4:
        if (CronetDependManager.inst().loggerDebug() == false) goto L28;
        CronetDependManager.inst().loggerD("monitor", "Unknown error code: " + r3);
        return r3;
    L28:
        return r3;
    }

    public static CronetException createCronetException(int r3, int r4, String r5) {
        return new NetworkExceptionImpl("Exception in CronetUrlRequest: " + r5, mapUrlRequestErrorToApiErrorCode(r3), r4);
    }

    public static IOException tryConvertCronetException(CronetException r3) {
        if ((r3 instanceof NetworkException) == true) goto L6;
        return r3;
    L6:
        switch(((NetworkException) r3).getErrorCode()) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L11;
            case 8: goto L9;
            case 9: goto L8;
            default: goto L17;
        };
    L8:
        IOException r0 = new NoRouteToHostException(r3.getMessage());
    L16:
        return r0;
    L9:
        r0 = new SocketException("reset by peer " + r3.getMessage());
        goto L16
    L10:
        r0 = new ConnectTimeoutException(r3.getMessage());
        goto L16
    L11:
        r0 = new ConnectException(r3.getMessage());
        goto L16
    L12:
        r0 = new SocketTimeoutException(r3.getMessage());
        goto L16
    L13:
        r0 = new ConnectException(r3.getMessage());
        goto L16
    L14:
        r0 = new UnknownHostException(r3.getMessage());
        goto L16
    L17:
        return r3;
    }
}
