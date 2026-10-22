package d.b.c.e;

import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.LocationUtil;
import com.bytedance.bdlocation.callback.BDLocationCallback;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.client.LocationOption;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.store.LocationCache;
import d.b.c.d.h;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: d.b.c.e.a$a, reason: collision with other inner class name */
    static class C0349a implements BDLocationCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ BDLocationCallback f13184a;

        C0349a(BDLocationCallback r1) {
            this.f13184a = r1;
        }

        @Override // com.bytedance.bdlocation.callback.BDLocationCallback
        public void onError(@Nullable BDLocationException r1) {
            BDLocationCallback r0 = this.f13184a;
            if (r0 == null) goto L6;
            r0.onError(r1);
            return;
        }

        @Override // com.bytedance.bdlocation.callback.BDLocationCallback
        public void onLocationChanged(@Nullable BDLocation r1) {
            BDLocationCallback r0 = this.f13184a;
            if (r0 == null) goto L6;
            r0.onLocationChanged(r1);
            return;
        }
    }

    private static boolean a() {
        LocationCache r0 = h.F().D();
        long r1 = System.currentTimeMillis();
        long r4 = r0.getLongValue("firstUploadTime");
        if (r4 != 0) goto L5;
        r0.setLongValue("firstUploadTime", r1);
        r4 = r1;
    L5:
        long r6 = r0.getLongValue("last_upload_interval");
        int r9 = r0.getIntValue("uploadCount");
        Logger.d("BDRegionLocation upload: time", "UploadScheduleController--requestUploadLocation:--lastuploadTime:" + r6 + "--thisTIme:" + r1 + "-interval:" + (BDLocationConfig.getOverseaUploadInterval() / 1000));
        if ((r1 - r4) <= BDLocationConfig.getOverseaUploadMaxDuration()) goto L8;
        r0.setLongValue("firstUploadTime", r1);
        r0.setIntValue("uploadCount", 0);
        r9 = 0;
    L8:
        Logger.d("BDRegionLocation uploadCount:", "---" + r9 + "--MaxuploadCount:" + BDLocationConfig.getOverseaUploadMaxCount());
        if (r9 < BDLocationConfig.getOverseaUploadMaxCount()) goto L13;
        Logger.d("BDRegionLocation upload: count", "Over max times");
        return false;
    L13:
        if ((r1 - r6) >= BDLocationConfig.getOverseaUploadInterval()) goto L16;
        Logger.d("BDRegionLocation upload: time", "Not yet reported time");
        return false;
    L16:
        return true;
    }

    @WorkerThread
    public static BDLocation b(LocationOption r1) {
        return h.F().A(r1);
    }

    public static void c(LocationOption r2, BDLocationCallback r3) {
        h.F().Y(new C0349a(r3), r2);
    }

    public static void d(String r1, int r2, boolean r3, long r4, long r6, BDLocationCallback r8, Object r9) {
        LocationOption r0 = new LocationOption();
        r0.setUploadSource(r1);
        r0.setMaxCacheTime(r6);
        r0.setTriggerType(r2);
        r0.setUpload(r3);
        r0.setLocationTimeOutMs(r4);
        r0.setLocateType(BDLocationConfig.getLocateType());
        r0.setBpeaCert(r9);
        r0.setBpeaAction("getLocation");
        c(r0, r8);
    }

    @WorkerThread
    public static void e(String r10, int r11, boolean r12, long r13, long r15) {
        if (a() == true) goto L5;
        return;
    L5:
        if (LocationInfoConst.ALLOW_USE_LOCATION.equals(LocationUtil.allowUseLocation(true)) == false) goto L7;
        d(r10, r11, r12, r13, r15, null, null);
        return;
    L7:
        LocationUtil.uploadDeviceStatus(r10, r11);
    }
}
