package com.android.settings.cover;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.PowerManager;
import android.os.SystemProperties;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import bytedanceos.util.DeviceType;
import com.android.settings.Utils;
import com.android.settings.activate.DefaultHostNameVerify;
import com.android.settings.utils.GeoTrustManager;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.obric.olog.OLog;
import cz.msebera.android.httpclient.client.cache.HeaderConstants;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class CornerCoverService extends Service {
    private static final String CORNER_URL = "";
    private static final boolean DEBUG = false;
    private static final int MAX_REPORT_TIME = 3;
    public static final int MSG_REPORT_NETWORK = 1;
    private static final int READ_TIMEOUT = 10000;
    private static final int SEND_TIMEOUT = 60000;
    private static final String TAG = "CornerCover";
    private static int mReportedTime;
    private static final SimpleDateFormat sFormatter = null;
    private String mCover;
    private Handler mReportHandler;
    private ReportThread mReportThread;

    class ReportThread extends Thread {
        private Context mContext;
        final /* synthetic */ CornerCoverService this$0;

        static /* synthetic */ void access$000(ReportThread r0) {
            r0.quit();
        }

        public ReportThread(CornerCoverService r1, Context r2) {
            this.this$0 = r1;
            super("Report");
            this.mContext = r2;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Looper.prepare();
            CornerCoverService.access$102(this.this$0, new AnonymousClass1(this));
            CornerCoverService.access$202(0);
            CornerCoverService.access$100(this.this$0).sendEmptyMessage(1);
            Looper.loop();
        }

        private void quit() {
            if (CornerCoverService.access$100(this.this$0) == null) goto L6;
            CornerCoverService.access$100(this.this$0).getLooper().quit();
            CornerCoverService.access$102(this.this$0, null);
            return;
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent r1) {
        return null;
    }

    public CornerCoverService() {
        this.mCover = "";
    }

    static /* synthetic */ Handler access$100(CornerCoverService r0) {
        return r0.mReportHandler;
    }

    static /* synthetic */ Handler access$102(CornerCoverService r0, Handler r1) {
        r0.mReportHandler = r1;
        return r1;
    }

    static /* synthetic */ int access$200() {
        return mReportedTime;
    }

    static /* synthetic */ int access$202(int r0) {
        mReportedTime = r0;
        return r0;
    }

    static /* synthetic */ int access$208() {
        int r0 = mReportedTime;
        mReportedTime = r0 + 1;
        return r0;
    }

    static /* synthetic */ boolean access$300(CornerCoverService r0) {
        return r0.send();
    }

    static /* synthetic */ String access$400(CornerCoverService r0) {
        return r0.mCover;
    }

    static {
        boolean r2 = true;
        if (SystemProperties.getInt("ro.debuggable", 0) == 1) goto L6;
        r2 = false;
    L6:
        DEBUG = r2;
        mReportedTime = 0;
        sFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (DeviceType.is(DeviceType.OSCAR) == false) goto L5;
        startReportThread();
        return;
    L5:
        stopSelf();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent r1, int r2, int r3) {
        return super.onStartCommand(r1, r2, r3);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        if (DeviceType.is(DeviceType.OSCAR) == false) goto L6;
        stopReportThread();
        return;
    }

    private void startReportThread() {
        if (this.mReportThread != null) goto L6;
        ReportThread r0 = new ReportThread(this, this);
        this.mReportThread = r0;
        r0.start();
        return;
    }

    private void stopReportThread() {
        ReportThread r0 = this.mReportThread;
        if (r0 == null) goto L6;
        ReportThread.access$000(r0);
        this.mReportThread = null;
        return;
    }

    public static String getImei(Context r2) {
        String r3 = Utils.getDeviceIMEI();
        if (DEBUG == false) goto L6;
        OLog.w(TAG, "getDeviceId imei= " + r3);
    L6:
        if (TextUtils.isEmpty(r3) == false) goto L8;
    L9:
        return "000000000000000";
    L8:
        if (Pattern.matches("0+", r3) == true) goto L9;
        return r3;
    }

    private String getUploadMessage() {
        String r2 = "imei=" + getImei(this);
        if (DEBUG == false) goto L5;
        OLog.w(TAG, "uploadMsg: " + r2);
    L5:
        return r2;
    }

    public synchronized SSLContext getSSLContext() throws Exception {
        monitor-enter(this);
        SSLContext r0 = SSLContext.getInstance("TLS");     // Catch: Throwable -> L6
        r0.init(null, new TrustManager[]{new GeoTrustManager()}, new SecureRandom());     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    private boolean send() {
        OLog.i(TAG, "send...");
        boolean r4 = true;
        PowerManager.WakeLock r1 = ((PowerManager) getSystemService(BatteryTypeInf.BATTERY_POWER_LOCK)).newWakeLock(1, "WifiConnectService");
        r1.acquire(61000);
        System.setProperty("http.keepAlive", "false");
        String r3 = getUploadMessage();
        boolean r5 = false;
        OutputStream r6 = null;
        BufferedReader r7 = null;
        r6 = null;
        HttpsURLConnection r8 = (HttpsURLConnection) new URL("").openConnection();     // Catch: Throwable -> L43 Exception -> L45
        HttpsURLConnection r9 = r8;     // Catch: Throwable -> L43 Exception -> L45
        r8.setHostnameVerifier(new DefaultHostNameVerify());     // Catch: Throwable -> L43 Exception -> L45
        HttpsURLConnection r10 = r8;     // Catch: Throwable -> L43 Exception -> L45
        r8.setSSLSocketFactory(getSSLContext().getSocketFactory());     // Catch: Throwable -> L43 Exception -> L45
        r8.setInstanceFollowRedirects(false);     // Catch: Throwable -> L43 Exception -> L45
        r8.setDoInput(true);     // Catch: Throwable -> L43 Exception -> L45
        r8.setRequestMethod("POST");     // Catch: Throwable -> L43 Exception -> L45
        r8.setRequestProperty("Cache-Control", HeaderConstants.CACHE_CONTROL_NO_CACHE);     // Catch: Throwable -> L43 Exception -> L45
        r8.setRequestProperty("Connection", "close");     // Catch: Throwable -> L43 Exception -> L45
        r8.setUseCaches(false);     // Catch: Throwable -> L43 Exception -> L45
        r8.setConnectTimeout(60000);     // Catch: Throwable -> L43 Exception -> L45
        r8.setReadTimeout(10000);     // Catch: Throwable -> L43 Exception -> L45
        r8.connect();     // Catch: Throwable -> L43 Exception -> L45
        OutputStream r11 = r8.getOutputStream();     // Catch: Throwable -> L43 Exception -> L45
    L90:
        r11.write(r3.getBytes());     // Catch: Throwable -> L37 Exception -> L40
        int r12 = r8.getResponseCode();     // Catch: Throwable -> L37 Exception -> L40
        if (r12 != 200) goto L28;
        BufferedReader r0 = new BufferedReader(new InputStreamReader(r8.getInputStream()), 2048);     // Catch: Throwable -> L37 Exception -> L40
        StringBuffer r13 = new StringBuffer();     // Catch: Throwable -> L24 Exception -> L26
    L8:
        String r14 = r0.readLine();     // Catch: Throwable -> L24 Exception -> L26
        if (r14 == null) goto L11;
        r13.append(r14);     // Catch: Throwable -> L24 Exception -> L26
        goto L8
    L11:
        r0.close();     // Catch: Throwable -> L24 Exception -> L26
        JSONObject r15 = new JSONObject(r13.toString());     // Catch: Throwable -> L24 Exception -> L26
        if (DEBUG == false) goto L14;
        OLog.w(TAG, "json return " + r15);     // Catch: Throwable -> L24 Exception -> L26
    L14:
        String r16 = r15.getString("data");     // Catch: Throwable -> L24 Exception -> L26
        String r17 = r15.getString(NotificationCompat.CATEGORY_MESSAGE);     // Catch: Throwable -> L24 Exception -> L26
        if (r17 == null) goto L22;
        if (r17.equals("success") == false) goto L22;
        this.mCover = r16;     // Catch: Exception -> L20 Throwable -> L24
    L23:
        r7 = r0;
        r5 = r4;
    L29:
        if (r11 != null) goto L84;
    L33:
        if (r7 == null) goto L61;
        r7.close();     // Catch: IOException -> L31
    L31:
        e = move-exception;
        e.printStackTrace();
    L61:
        if (r1.isHeld() == false) goto L64;
        r1.release();
    L64:
        if (DEBUG == false) goto L66;
        OLog.w(TAG, "finish result success=" + r5 + " at " + sFormatter.format(new Date(System.currentTimeMillis())));
    L66:
        return r5;
    L84:
        r11.close();     // Catch: IOException -> L31
        goto L33
    L20:
        e = e;
    L42:
        r6 = r11;
    L86:
    L67:
        th = th;
    L68:
        if (r6 != null) goto L79;
    L72:
        if (r0 == null) goto L76;
        r0.close();     // Catch: IOException -> L70
    L70:
        e = move-exception;
        e.printStackTrace();
    L76:
        throw th;
    L79:
        r6.close();     // Catch: IOException -> L70
        goto L72
    L48:
        if (DEBUG == false) goto L50;
        OLog.e(TAG, "corner cover catch Exception: ", e);     // Catch: Throwable -> L67
    L51:
        if (r6 != null) goto L77;
    L55:
        if (r0 == null) goto L59;
        r0.close();     // Catch: IOException -> L53
    L53:
        e = move-exception;
        e.printStackTrace();
    L59:
        r5 = r4;
        goto L61
    L77:
        r6.close();     // Catch: IOException -> L53
        goto L55
    L50:
        OLog.e(TAG, "corner cover exception" + e.getMessage());     // Catch: Throwable -> L67
    L22:
        r4 = false;
    L26:
        e = e;
        r4 = false;
    L24:
        th = th;
    L39:
        r6 = r11;
        goto L68
    L28:
        OLog.e(TAG, "execute error, code=" + r12);     // Catch: Throwable -> L37 Exception -> L40
    L40:
        e = e;
        r4 = false;
        r0 = null;
    L37:
        th = th;
        r0 = null;
    L45:
        e = e;
        r4 = false;
        r0 = null;
    L43:
        th = th;
        r0 = null;
        goto L68
    }
}
