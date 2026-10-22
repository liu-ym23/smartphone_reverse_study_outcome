package d.b.c.c;

import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.callback.LocationSubmitNotification;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.client.LocationOption;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.network.response.LocInfoRspData;
import com.bytedance.bdlocation.settings.LocationSettingUtil;
import com.bytedance.bdlocation.store.LocationCache;
import d.b.c.d.g;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class a {
    private static void a(LocInfoRspData r4, LocationOption r5) {
        if (r4 == null) goto L9;
        long r0 = r4.nextBleScanInterval;
        BDLocationConfig.setUploadBleImmediately(r4.submitBleNow);
        BDLocationConfig.setDisableUuidList(r4.disableUuidList);
        if (r0 <= 0) goto L7;
    L5:
        BDLocationConfig.setScanBleInterval(r0);
        goto L9
    L7:
        if (LocationSettingUtil.getLocationConfig() == null) goto L9;
        r0 = LocationSettingUtil.getLocationConfig().scanBleInterval;
    L9:
        g.k().p(r5);
    }

    public static boolean b(LocInfoRspData r1, BDLocation r2, LocationOption r3) {
        if (r1 != null) goto L11;
        return false;
    L11:
        f(r1);     // Catch: Exception -> L8
        g(r1, r2);     // Catch: Exception -> L8
        a(r1, r3);     // Catch: Exception -> L8
        e(r1);     // Catch: Exception -> L8
        d();     // Catch: Exception -> L8
        return true;
    L8:
        e = move-exception;
        e.printStackTrace();
        Logger.e("The exception was occurred when the response data was convert to LocInfoRspData ");
        return false;
    }

    public static boolean c(String r5) {
    L7:
        e = move-exception;
        e.printStackTrace();
        Logger.e("The exception was occurred when the response data was convert to LocInfoRspData:" + e.toString());
        return false;
    L4:
        if ("bdlocation_upload_cold_start ".equals(r5) == false) goto L6;
        LocationCache r6 = LocationCache.getInstance();     // Catch: Exception -> L7
        r6.setLongValue("last_upload_interval", System.currentTimeMillis());     // Catch: Exception -> L7
        r6.setIntValue("uploadCount", r6.getIntValue("uploadCount") + 1);     // Catch: Exception -> L7
    L6:
        return true;
    }

    private static void d() {
        BDLocationConfig.setFirstRequestLocation(false);
    }

    private static void e(LocInfoRspData r3) {
        if (r3 != null) goto L6;
        long r0 = 0;
    L4:
        BDLocationConfig.setGpsScanInterval(r0);
        return;
    L6:
        Logger.i("ResponseExecutor: setNextGpsScanInterval and interval:" + r3.nextGPSScanInterval);
        r0 = r3.nextGPSScanInterval;
        goto L4
    }

    private static void f(LocInfoRspData r4) {
        if (r4 == null) goto L7;
        d.b.c.a.a.f13075f = System.currentTimeMillis();
        long r0 = r4.nextPollingUploadInterval * 1000;
        if (r0 != 0) goto L6;
        r0 = BDLocationConfig.getUploadInterval();
    L6:
        d.b.c.a.a r5 = d.b.c.a.a.b();
    L8:
        r5.g(r0);
        return;
    L7:
        r5 = d.b.c.a.a.b();
        r0 = BDLocationConfig.getUploadInterval();
        goto L8
    }

    private static void g(LocInfoRspData r1, BDLocation r2) {
        if (r1 != null) goto L19;
        return;
    L19:
    L16:
        e = move-exception;
        Logger.i("submitCallback error:" + e.toString());
        return;
    L5:
        if (BDLocationConfig.getSubmitNotification() != null) goto L7;
        return;
    L7:
        if (BDLocationConfig.getSubmitNotification().size() <= 0) goto L27;
        if (r2 == null) goto L28;
        BDLocation r0 = new BDLocation(r2);     // Catch: Exception -> L16
        r0.setSubmitLogId(r1.submitLogId);     // Catch: Exception -> L16
        Iterator<LocationSubmitNotification> r3 = BDLocationConfig.getSubmitNotification().iterator();     // Catch: Exception -> L16
    L11:
        if (r3.hasNext() == false) goto L29;
        LocationSubmitNotification r4 = r3.next();     // Catch: Exception -> L16
        if (r4 == null) goto L11;
        r4.onSubmitListener(r0);     // Catch: Exception -> L16
        goto L11
    L29:
        return;
    L28:
        return;
    }
}
