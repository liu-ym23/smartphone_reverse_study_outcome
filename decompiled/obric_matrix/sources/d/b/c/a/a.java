package d.b.c.a;

import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Handler;
import androidx.annotation.NonNull;
import com.bytedance.bdlocation.LocationUtil;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.scan.networklistener.NetworkManager;
import com.bytedance.bdlocation.scan.networklistener.WifiChangeListener;
import com.bytedance.bdlocation.thread.ThreadLooperManager;

/* JADX INFO: loaded from: classes.dex */
public class a implements WifiChangeListener {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile a f13074e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static long f13075f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile boolean f13076a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private b f13077b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Handler f13078c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f13079d;

    /* JADX INFO: renamed from: d.b.c.a.a$a, reason: collision with other inner class name */
    static /* synthetic */ class C0347a {
    }

    private class b implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private long f13080f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private volatile boolean f13081g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private long f13082h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private String f13083i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ a f13084j;

        private b(a r3) {
            this.f13084j = r3;
            this.f13080f = 0;
            this.f13081g = true;
            this.f13082h = r3.c();
        }

        /* synthetic */ b(a r1, C0347a r2) {
            this(r1);
        }

        private void e(int r1) {
            LocationUtil.uploadDeviceStatus("bdlocation_upload_internal_polling", r1);
        }

        void b() {
            Logger.d("BDLocation_LocationScheduler_pollupload:onCancel");
            this.f13081g = true;
            a.a(this.f13084j).removeCallbacksAndMessages(null);
        }

        public synchronized void c(String r10) {
            monitor-enter(this);
        L37:
            th = move-exception;
            throw th;
        L4:
            if ((System.currentTimeMillis() - a.f13075f) >= 55000) goto L8;
            Logger.d("BDLocation_UploadScheduleController_pollupload lastUploadTime:" + a.f13075f);     // Catch: Throwable -> L37
            monitor-exit(this);
            return;
        L8:
            a.f13075f = System.currentTimeMillis();     // Catch: Throwable -> L37
            if (BDLocationConfig.isUpload() == true) goto L11;
        L34:
            Logger.d(":---isPollingUpload:" + BDLocationConfig.isPollingUpload());     // Catch: Throwable -> L37
            monitor-exit(this);
            return;
        L11:
            if (BDLocationConfig.isPollingUpload() == false) goto L34;
            if (BDLocationConfig.isRestrictedModeOn() == true) goto L34;
        L30:
            e = move-exception;
            Logger.e("BDLocation_UploadScheduleController_pollupload:" + e.getMessage());     // Catch: Throwable -> L37
        L32:
            monitor-exit(this);
            return;
        L16:
            if (BDLocationConfig.isUploadLocation() == true) goto L20;
            Logger.d("BDLocation_UploadScheduleController_pollupload:uploadDeviceStatus1");     // Catch: Exception -> L30 Throwable -> L37
        L18:
            e(0);     // Catch: Exception -> L30 Throwable -> L37
            goto L32
        L20:
            if (LocationUtil.isLocationEnabled() == true) goto L22;
        L28:
            Logger.d("BDLocation_UploadScheduleController_pollupload:uploadDeviceStatus2 no Permission");     // Catch: Exception -> L30 Throwable -> L37
            goto L18
        L22:
            if (LocationUtil.needLocate() == false) goto L28;
            Logger.d("BDLocation_UploadScheduleController_pollupload:getLocationAsync");     // Catch: Exception -> L30 Throwable -> L37
            if (LocationInfoConst.NETWORK_CHANGE_CERT.equals(r10) == false) goto L26;
            String r11 = LocationInfoConst.NETWORK_CHANGE_CERT;
        L27:
            d.b.c.e.a.d("bdlocation_upload_internal_polling", 1, true, 0, 0, null, BDLocationConfig.getBpeaCert(r11));     // Catch: Exception -> L30 Throwable -> L37
            goto L32
        L26:
            r11 = LocationInfoConst.POLL_CERT;
            goto L27
        }

        void d(long r2, String r4) {
            this.f13083i = r4;
            this.f13082h = r2;
            Logger.d("BDLocation_LocationScheduler_pollupload resetIntervalMs intervalMs：" + r2);
            a.a(this.f13084j).removeCallbacksAndMessages(null);
            a.a(this.f13084j).postDelayed(this, r2);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (BDLocationConfig.isRestrictedModeOn() == false) goto L5;
        L15:
            Logger.i("BDLocation_LocationScheduler_pollupload:ControllerTask is return");
            b();
            return;
        L5:
            if (BDLocationConfig.isBackground() == true) goto L15;
            long r0 = System.currentTimeMillis();
            Logger.d("BDLocation_LocationScheduler_pollupload:ControllerTask intervalMs:" + this.f13082h + "---currentTimeMs:" + r0 + "---lastScheduleTimeMs:" + this.f13080f);
            if ((r0 - this.f13080f) >= this.f13082h) goto L11;
            Logger.d("BDLocation_LocationScheduler_pollupload:ControllerTask is exception");
            a.a(this.f13084j).removeCallbacksAndMessages(null);
        L11:
            if (this.f13081g == true) goto L13;
            c(this.f13083i);
            this.f13083i = "";
            this.f13080f = r0;
        L13:
            this.f13081g = false;
            this.f13082h = this.f13084j.c();
            a.a(this.f13084j).postDelayed(this, this.f13082h);
        }
    }

    static {
    }

    public a() {
        this.f13076a = false;
        this.f13079d = 0;
        this.f13078c = new Handler(ThreadLooperManager.getPollUploadWorker());
        NetworkManager.getInstance().setListener(this);
    }

    static /* synthetic */ Handler a(a r0) {
        return r0.f13078c;
    }

    public static a b() {
        if (f13074e != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f13074e != null) goto L9;
        f13074e = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f13074e;
    }

    private void f(long r1, String r3) {
        b r0 = this.f13077b;
        if (r0 == null) goto L6;
        r0.d(r1, r3);
        return;
    }

    private void i(long r3) {
        if (r3 >= 0) goto L5;
        return;
    L5:
        this.f13079d = r3;
    }

    public long c() {
        if (this.f13079d != 0) goto L6;
        this.f13079d = BDLocationConfig.getUploadInterval();
    L6:
        return this.f13079d;
    }

    public synchronized boolean d() {
        monitor-enter(this);
        boolean r0 = this.f13076a;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void e(long r2) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.f13076a == true) goto L9;
        i(r2);     // Catch: Throwable -> L11
        if (this.f13077b != null) goto L8;
        this.f13077b = new b(this, null);     // Catch: Throwable -> L11
    L8:
        this.f13078c.post(this.f13077b);     // Catch: Throwable -> L11
        this.f13076a = true;     // Catch: Throwable -> L11
    L9:
        monitor-exit(this);
    }

    public void g(long r4) {
        if (this.f13076a == true) goto L5;
        return;
    L5:
        Logger.d("BDLocation_UploadScheduleController_pollupload resetPollUploadSchedule:" + c());
        f(r4, LocationInfoConst.POLL_CERT);
        i(r4);
    }

    public void h() {
        if (c() != BDLocationConfig.getNetworkStatusChangeUploadInterval()) goto L5;
        return;
    L5:
        if (this.f13076a == false) goto L14;
        i(BDLocationConfig.getUploadInterval());
        long r0 = System.currentTimeMillis() - f13075f;
        if (r0 < BDLocationConfig.getNetworkStatusChangeUploadInterval()) goto L10;
        Logger.d("BDLocation_UploadScheduleController_pollupload resetPollUploadScheduleNetWorkChange:onStart" + c());
        f(100, LocationInfoConst.NETWORK_CHANGE_CERT);
        return;
    L10:
        Logger.d("BDLocation_UploadScheduleController_pollupload resetPollUploadScheduleNetWorkChange:resetControllerIntervalMs" + c());
        f(BDLocationConfig.getNetworkStatusChangeUploadInterval() - r0, LocationInfoConst.NETWORK_CHANGE_CERT);
        return;
    }

    public synchronized void j() {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (this.f13077b != null) goto L6;
    L11:
        monitor-exit(this);
        return;
    L6:
        if (this.f13076a == false) goto L11;
        i(BDLocationConfig.getUploadInterval());     // Catch: Throwable -> L13
        this.f13077b.b();     // Catch: Throwable -> L13
        this.f13076a = false;     // Catch: Throwable -> L13
        monitor-exit(this);
    }

    @Override // com.bytedance.bdlocation.scan.networklistener.WifiChangeListener
    public void notifyWifiChanged(@NonNull Network r2, @NonNull NetworkCapabilities r3) {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return;
    L5:
        if (r3.hasCapability(16) == false) goto L9;
        Logger.d("UploadScheduleController notifyWifiChanged");
        h();
        return;
    }

    @Override // com.bytedance.bdlocation.scan.networklistener.WifiChangeListener
    public void notifyWifiChangedTwo(NetworkInfo r1) {
        if (r1 != null) goto L5;
        return;
    L5:
        if (r1.isAvailable() == false) goto L8;
        Logger.d("UploadScheduleController notifyWifiChanged two");
        h();
        return;
    }
}
