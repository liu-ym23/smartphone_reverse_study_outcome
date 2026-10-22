package cz.msebera.android.httpclient.conn.routing;

import cz.msebera.android.httpclient.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public class BasicRouteDirector implements HttpRouteDirector {
    public BasicRouteDirector() {
    }

    @Override // cz.msebera.android.httpclient.conn.routing.HttpRouteDirector
    public int nextStep(RouteInfo r3, RouteInfo r4) {
        Args.notNull(r3, "Planned route");
        if (r4 == null) goto L12;
        if (r4.getHopCount() < 1) goto L12;
        if (r3.getHopCount() <= 1) goto L14;
        return proxiedStep(r3, r4);
    L14:
        return directStep(r3, r4);
    L12:
        return firstStep(r3);
    }

    protected int firstStep(RouteInfo r1) {
        if (r1.getHopCount() <= 1) goto L6;
        return 2;
    L6:
        return 1;
    }

    protected int directStep(RouteInfo r3, RouteInfo r4) {
        if (r4.getHopCount() <= 1) goto L6;
        return -1;
    L6:
        if (r3.getTargetHost().equals(r4.getTargetHost()) == true) goto L9;
        return -1;
    L9:
        if (r3.isSecure() == r4.isSecure()) goto L12;
        return -1;
    L12:
        if (r3.getLocalAddress() != null) goto L14;
        return 0;
    L14:
        if (r3.getLocalAddress().equals(r4.getLocalAddress()) == true) goto L18;
        return -1;
    L18:
        return 0;
    }

    protected int proxiedStep(RouteInfo r7, RouteInfo r8) {
        if (r8.getHopCount() > 1) goto L6;
        return -1;
    L6:
        if (r7.getTargetHost().equals(r8.getTargetHost()) == true) goto L8;
        return -1;
    L8:
        int r6 = r7.getHopCount();
        int r0 = r8.getHopCount();
        if (r6 >= r0) goto L11;
        return -1;
    L11:
        int r3 = 0;
    L13:
        if (r3 >= (r0 - 1)) goto L18;
        if (r7.getHopTarget(r3).equals(r8.getHopTarget(r3)) == false) goto L16;
        r3 = r3 + 1;
        goto L13
    L16:
        return -1;
    L18:
        if (r6 <= r0) goto L22;
        return 4;
    L22:
        if (r8.isTunnelled() == false) goto L26;
        if (r7.isTunnelled() == true) goto L26;
    L29:
        return -1;
    L26:
        if (r8.isLayered() == false) goto L31;
        if (r7.isLayered() == false) goto L29;
    L31:
        if (r7.isTunnelled() == false) goto L37;
        if (r8.isTunnelled() == true) goto L37;
        return 3;
    L37:
        if (r7.isLayered() == false) goto L43;
        if (r8.isLayered() == true) goto L43;
        return 5;
    L43:
        if (r7.isSecure() == r8.isSecure()) goto L45;
        return -1;
    L45:
        return 0;
    }
}
