package com.obric.matrix.location;

import android.app.Application;
import android.location.LocationManager;
import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;

/* JADX INFO: loaded from: classes2.dex */
public class h {
    public static boolean a(BDLocation r0) {
        if (r0 != null) goto L4;
        return false;
    L4:
        return r0.hasAddress();
    }

    public static boolean b(BDLocation r5) {
        if (r5 != null) goto L5;
        return false;
    L5:
        if (Double.compare(r5.getLatitude(), 0.0d) == 0) goto L7;
    L8:
        return true;
    L7:
        if (Double.compare(r5.getLongitude(), 0.0d) != 0) goto L8;
        return false;
    }

    public static boolean c() {
        Application r0 = com.bytedance.mpaas.app.a.b();
        if (r0 != null) goto L5;
        return false;
    L5:
        LocationManager r1 = (LocationManager) r0.getSystemService(LocationMonitorConst.LOCATION);
        if (r1 != null) goto L8;
    L11:
        return false;
    L8:
        if (r1.isLocationEnabled() == false) goto L11;
        return true;
    }
}
