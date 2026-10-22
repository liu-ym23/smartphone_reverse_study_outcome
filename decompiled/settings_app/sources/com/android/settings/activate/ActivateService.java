package com.android.settings.activate;

import android.app.Service;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkRequest;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.PowerManager;
import android.os.SystemProperties;
import android.text.TextUtils;
import bytedanceos.util.DeviceType;
import com.android.settings.Utils;
import com.android.settings.utils.GeoTrustManager;
import com.android.settings.utils.HanziToPinyin;
import com.bytedance.apm.alog.AlogMonitor;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.bytedance.networkstackapplib.NetworkStackConstant;
import com.obric.olog.OLog;
import com.zte.faceverify.FaceVerifyManager;
import cz.msebera.android.httpclient.client.cache.HeaderConstants;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import org.apache.commons.math3.geometry.VectorFormat;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ActivateService extends Service {
    public static final String ACCESS_PROVISION_PERMISSION = "com.android.settings.ACCESS_PROVISION_PERMISSION";
    public static final String ACTION_ACTIVATE_FINISHED = "com.bytedanceos.ACTIVATE_FINISHED";
    public static final String ACTIVATE_NUMBER = "106900325512";
    public static final String ACTIVATE_SMS_TYPE = "x1";
    public static final int ACTIVATE_SMS_VERSION = 1;
    private static final String ACTIVATE_URL = "";
    private static final String ACTIVATE_URL_V2 = "";
    private static final boolean DEBUG = false;
    public static final String HOST = "127.0.0.1";
    public static final long INVAILD_TIMEOUT = 86400000;
    private static final int MAX_REPORT_TIME = 3;
    public static final int MSG_REPORT_NETWORK = 1;
    public static final int MSG_REPORT_SMS = 2;
    public static final int MSG_REQUEST_TOKEN = 4;
    public static final int MSG_SEND_SMS = 3;
    public static final int PORT = 54321;
    private static final int READ_TIMEOUT = 10000;
    private static final int SEND_TIMEOUT = 60000;
    private static final String SMS_GATEWAY_URL = "";
    public static final int SOCKET_TIMEOUT = 10000;
    private static final String TAG = "Activation";
    private static final String TOKEN_URL = "";
    private static int mGateWayIndex;
    public static ArrayList<String> mGateWays;
    private static int mReportedTime;
    Handler mCheckLocationHandler;
    private Location mLocation;
    private LocationListener mLocationListener;
    private LocationManager mLocationManager;
    private int mMsg;
    private int mOriginalMsg;
    private Handler mReportHandler;
    private ReportThread mReportThread;
    private String mSecret;
    private int mTimeStamp;
    private final SimpleDateFormat sFormatter;
    private boolean useAct2;

    class ReportThread extends Thread {
        private Context mContext;
        final /* synthetic */ ActivateService this$0;

        static /* synthetic */ void access$000(ReportThread r0) {
            r0.quit();
        }

        static /* synthetic */ Context access$400(ReportThread r0) {
            return r0.mContext;
        }

        public ReportThread(ActivateService r1, Context r2) {
            this.this$0 = r1;
            super("Report");
            this.mContext = r2;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Looper.prepare();
            ActivateService.access$102(this.this$0, new AnonymousClass1(this));
            ActivateService.access$202(0);
            ActivateService.access$100(this.this$0).sendEmptyMessage(ActivateService.access$1100(this.this$0));
            Looper.loop();
        }

        private void quit() {
            if (ActivateService.access$100(this.this$0) == null) goto L6;
            ActivateService.access$100(this.this$0).getLooper().quit();
            ActivateService.access$102(this.this$0, null);
            return;
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent r1) {
        return null;
    }

    public ActivateService() {
        this.mMsg = 1;
        this.mOriginalMsg = 0;
        this.sFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.mSecret = "";
        this.mTimeStamp = 0;
        this.mCheckLocationHandler = new AnonymousClass2(this);
        this.mLocationListener = new AnonymousClass3(this);
    }

    static /* synthetic */ Handler access$100(ActivateService r0) {
        return r0.mReportHandler;
    }

    static /* synthetic */ boolean access$1000(ActivateService r0) {
        return r0.getToken();
    }

    static /* synthetic */ Handler access$102(ActivateService r0, Handler r1) {
        r0.mReportHandler = r1;
        return r1;
    }

    static /* synthetic */ int access$1100(ActivateService r0) {
        return r0.mMsg;
    }

    static /* synthetic */ int access$1102(ActivateService r0, int r1) {
        r0.mMsg = r1;
        return r1;
    }

    static /* synthetic */ void access$1200(ActivateService r0) {
        r0.startReportThread();
    }

    static /* synthetic */ Location access$1300(ActivateService r0) {
        return r0.mLocation;
    }

    static /* synthetic */ Location access$1302(ActivateService r0, Location r1) {
        r0.mLocation = r1;
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

    static /* synthetic */ Bundle access$300(ActivateService r0) {
        return r0.activate();
    }

    static /* synthetic */ void access$500(ActivateService r0, Context r1, Bundle r2) {
        r0.sendResultAndFinish(r1, r2);
    }

    static /* synthetic */ void access$600(ActivateService r0) {
        r0.getSmsGateway();
    }

    static /* synthetic */ boolean access$700() {
        return DEBUG;
    }

    static /* synthetic */ int access$800() {
        return mGateWayIndex;
    }

    static /* synthetic */ int access$808() {
        int r0 = mGateWayIndex;
        mGateWayIndex = r0 + 1;
        return r0;
    }

    static /* synthetic */ String access$900(ActivateService r0) {
        return r0.getUploadMessage();
    }

    static {
        boolean r2 = true;
        if (SystemProperties.getInt("ro.debuggable", 0) == 1) goto L6;
        r2 = false;
    L6:
        DEBUG = r2;
        mReportedTime = 0;
        mGateWays = new ArrayList();
        mGateWayIndex = 0;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        updateLocation();
        this.useAct2 = true;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent r4, int r5, int r6) {
        if (r4 == null) goto L4;
        int r0 = r4.getIntExtra("flag", 0);
        this.mMsg = r0;
        this.mOriginalMsg = r0;
        if (r0 == 0) goto L19;
        if (r0 == 1) goto L15;
        if (r0 != 3) goto L22;
        Handler r1 = this.mReportHandler;
        if (r1 == null) goto L22;
        r1.sendEmptyMessage(r0);
    L22:
        OLog.d(TAG, "onStartCommand mOriginalMsg:" + this.mOriginalMsg + ", mMsg:" + this.mMsg);
        return super.onStartCommand(r4, r5, r6);
    L15:
        if (this.useAct2 == false) goto L17;
        this.mMsg = 4;
    L17:
        forceSwitchToCellular();
        goto L22
    L19:
        if (this.useAct2 == false) goto L21;
        this.mMsg = 4;
        goto L22
    L21:
        this.mMsg = 1;
        goto L22
    L4:
        return super.onStartCommand(r4, r5, r6);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        mGateWayIndex = 0;
        stopReportThread();
        this.mCheckLocationHandler.removeCallbacksAndMessages(null);
        LocationManager r0 = this.mLocationManager;
        if (r0 == null) goto L6;
        r0.removeUpdates(this.mLocationListener);
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

    private void forceSwitchToCellular() {
        ConnectivityManager r0 = ConnectivityManager.from(getApplicationContext());
        NetworkRequest.Builder r1 = new NetworkRequest.Builder();
        r1.addTransportType(0);
        r1.addCapability(12);
        r0.requestNetwork(r1.build(), new AnonymousClass1(this));
    }

    private void sendResultAndFinish(Context r3, Bundle r4) {
        resetToWifiIfNeed();
        Intent r0 = new Intent(ACTION_ACTIVATE_FINISHED);
        r0.putExtra("result", r4);
        r3.sendBroadcast(r0, ACCESS_PROVISION_PERMISSION);
        stopSelf();
    }

    private void resetToWifiIfNeed() {
        if (this.mOriginalMsg == 1) goto L5;
        return;
    L5:
        ConnectivityManager.setProcessDefaultNetwork(null);
        OLog.d(TAG, "reset to wifi done.");
    }

    public static String getImei() {
        String r0 = Utils.getDeviceIMEI();
        OLog.d(TAG, "getDeviceId imei= " + r0);
        if (TextUtils.isEmpty(r0) == false) goto L5;
    L6:
        return "000000000000000";
    L5:
        if (Pattern.matches("0+", r0) == true) goto L6;
        return r0;
    }

    private String getBtMac() {
        String r0 = BluetoothAdapter.getDefaultAdapter().getAddress();
        if (r0 != null) goto L6;
        return "00:00:00:00:00:00";
    L6:
        return r0;
    }

    private String getWifiMac() {
        WifiInfo r1 = ((WifiManager) getSystemService("wifi")).getConnectionInfo();
        if (r1 == null) goto L5;
        String r2 = r1.getMacAddress();
    L7:
        if (r2 != null) goto L9;
        r2 = SystemProperties.get("persist.sys.wifi.mac", "00:00:00:00:00:00");
    L9:
        if (r2 != null) goto L12;
        return "00:00:00:00:00:00";
    L12:
        return r2;
    L5:
        r2 = null;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v13, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.io.PrintWriter] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.io.PrintWriter] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x007e -> B:66:0x00ae). Please report as a decompilation issue!!! */
    private String getHardwareInfo(String r8, String r9) {
        String r7 = "";
        ?? r0 = 0;
        r0 = 0;
        r0 = 0;
        r0 = 0;
        r0 = 0;
        r0 = 0;
        r0 = 0;
        r0 = 0;
        Socket r1 = new Socket(HOST, PORT);     // Catch: Throwable -> L35 Exception -> L37
    L82:
        r1.setSoTimeout(10000);     // Catch: Throwable -> L31 Exception -> L33
        BufferedReader r2 = new BufferedReader(new InputStreamReader(r1.getInputStream()));     // Catch: Throwable -> L31 Exception -> L33
        PrintWriter r3 = new PrintWriter(new BufferedWriter(new OutputStreamWriter(r1.getOutputStream())), true);     // Catch: Exception -> L29 Throwable -> L50
        r3.println(r8);     // Catch: Throwable -> L25 Exception -> L27
        r3.flush();     // Catch: Throwable -> L25 Exception -> L27
    L8:
        String r10 = r2.readLine();     // Catch: Throwable -> L25 Exception -> L27
        if (r10 == null) goto L16;
        if (r9 == null) goto L14;
        r0 = r10.contains(r9);     // Catch: Throwable -> L25 Exception -> L27
        if (r0 != 0) goto L16;
    L14:
        r7 = (r7 + r10) + "\n";     // Catch: Throwable -> L25 Exception -> L27
        r0 = "\n";
    L16:
        r3.close();
        r2.close();     // Catch: IOException -> L19
    L21:
        r1.close();     // Catch: IOException -> L23
    L66:
        return r7;
    L19:
        e = move-exception;
        e.printStackTrace();
        goto L21
    L27:
        e = e;
        r0 = r3;
    L39:
        e.printStackTrace();     // Catch: Throwable -> L50
        if (r0 == 0) goto L42;
        r0.close();
    L42:
        if (r2 != null) goto L69;
    L47:
        if (r1 == null) goto L66;
        r1.close();     // Catch: IOException -> L23
        goto L66
    L69:
        r2.close();     // Catch: IOException -> L45
    L45:
        e = move-exception;
        e.printStackTrace();
    L25:
        th = th;
        r0 = r3;
    L51:
        if (r0 == 0) goto L53;
        r0.close();
    L53:
        if (r2 != null) goto L78;
    L58:
        if (r1 == null) goto L89;
        r1.close();     // Catch: IOException -> L61
        throw th;
    L61:
        e = move-exception;
        e.printStackTrace();
        throw th;
    L89:
        throw th;
    L78:
        r2.close();     // Catch: IOException -> L56
    L56:
        e = move-exception;
        e.printStackTrace();
    L29:
        e = e;
        goto L39
    L33:
        e = e;
        r2 = null;
    L31:
        th = th;
        r2 = null;
    L50:
        th = th;
    L37:
        e = e;
        r1 = null;
        r2 = null;
    L35:
        th = th;
        r1 = null;
        r2 = null;
    L23:
        e = move-exception;
        e.printStackTrace();
        goto L66
    }

    private String getModVersion() {
        String r1 = SystemProperties.get("ro.os.ota.version");
        if (r1 != null) goto L5;
    L6:
        return "Unknown";
    L5:
        if (r1.length() == 0) goto L6;
        return r1;
    }

    private String getPSN() {
        String r2 = getHardwareInfo("current-test-psn", "done").trim();
        if (r2 != null) goto L5;
    L6:
        return NetworkStackConstant.UNKNOWN_TYPE;
    L5:
        if (r2.length() == 0) goto L6;
        return r2;
    }

    private String getEMMC() {
        String r2 = getHardwareInfo("e_read-pversion", "done").trim();
        if (r2 != null) goto L5;
    L9:
        String r3 = null;
    L10:
        if (r3 != null) goto L12;
    L13:
        return NetworkStackConstant.UNKNOWN_TYPE;
    L12:
        if (r3.length() == 0) goto L13;
        return r3;
    L5:
        if (r2.length() <= 0) goto L9;
        int r0 = r2.indexOf("emmc_capacity=");
        int r1 = r2.indexOf("emmc_menufacture_id");
        if (r1 <= r0) goto L9;
        r3 = r2.substring(r0 + 14, r1).trim();
        goto L10
    }

    private String getPSNMTK() {
        String r1 = readProcFile("productid");
        if (r1 != null) goto L5;
    L6:
        return NetworkStackConstant.UNKNOWN_TYPE;
    L5:
        if (r1.length() == 0) goto L6;
        return r1;
    }

    private String getEMMCMTK() {
        String r1 = readProcFile("emmcinfo");
        if (r1 != null) goto L5;
    L6:
        return NetworkStackConstant.UNKNOWN_TYPE;
    L5:
        if (r1.length() == 0) goto L6;
        return r1;
    }

    private String readProcFile(String r4) {
        String r3 = "";
        File r0 = new File("/proc/" + r4);
        FileInputStream r5 = null;
        FileInputStream r1 = new FileInputStream(r0);     // Catch: Throwable -> L17 IOException -> L30
        byte[] r6 = new byte[50];     // Catch: Throwable -> L14 IOException -> L29
        r1.read(r6);     // Catch: Throwable -> L14 IOException -> L29
        String r2 = new String(r6, "UTF-8");     // Catch: Throwable -> L14 IOException -> L29
    L13:
        r3 = r2;
        goto L16
    L7:
        if (TextUtils.isEmpty(r2) == true) goto L32;
        int r7 = r2.indexOf("\n");     // Catch: IOException -> L13 Throwable -> L14
        if (r7 == (-1)) goto L32;
        r2 = r2.substring(0, r7);     // Catch: IOException -> L13 Throwable -> L14
    L32:
        r1.close();     // Catch: IOException -> L27
        return r2;
    L46:
        return r2;
    L14:
        th = th;
        r5 = r1;
    L24:
        if (r5 != null) goto L42;
    L26:
        throw th;
    L42:
        r5.close();     // Catch: IOException -> L28
    L16:
        r5 = r1;
    L17:
        th = th;
    L19:
        OLog.d(TAG, "read profile failed");     // Catch: Throwable -> L17
        if (r5 == null) goto L23;
        r5.close();     // Catch: IOException -> L31
    L23:
        return r3;
    }

    private String getUploadMessage() {
        if (this.mMsg == 1) goto L5;
        getLocationInfo().equals("\"UNKNOWN\"");
        String r0 = ("x1,1," + getImei() + "," + getWifiMac() + "," + getBtMac()).replaceAll(":", "");
        if (DEBUG == false) goto L20;
        OLog.d(TAG, "uploadMsg: " + r0);
    L21:
        return r0;
    L20:
        OLog.d(TAG, "uploadMsg normal");
        goto L21
    L5:
        if (DeviceType.is(DeviceType.BONO) == false) goto L7;
        String r1 = getPSNMTK();
        String r2 = getEMMCMTK();
    L9:
        if (this.useAct2 == false) goto L11;
        String r8 = getImei();
        String r7 = getBtMac();
        String r6 = getWifiMac();
        String r5 = getModVersion();
        String r16 = getLocationInfo();
        String r3 = "{\"imei\":\"" + r8 + "\",\"btmac\":\"" + r7 + "\",\"wifimac\":\"" + r6 + "\",\"sw-version\":\"" + r5 + "\",\"psn\":\"" + r1 + "\",\"mem_size\":\"" + r2 + "\",\"factory\":" + getFactoryMode() + ",\"timestamp\":" + this.mTimeStamp + ",\"signature\":\"" + Keys.decrypt(r8, r7, r6, r5, r1, r2, r16, "" + this.mTimeStamp, this.mSecret, 0) + "\"}";
    L13:
        if (DEBUG == false) goto L15;
        OLog.d(TAG, "uploadMsg: uploadMsg  ========================= " + r3);
    L16:
        return r3;
    L15:
        OLog.d(TAG, "uploadMsg: uploadMsg  ========================= useAct2");
        goto L16
    L11:
        r3 = "{\"imei\":\"" + getImei() + "\",\"btmac\":\"" + getBtMac() + "\",\"wifimac\":\"" + getWifiMac() + "\",\"sw-version\":\"" + getModVersion() + "\",\"psn\":\"" + r1 + "\",\"mem_size\":\"" + r2 + "\",\"factory\":" + getFactoryMode() + VectorFormat.DEFAULT_SUFFIX;
        goto L13
    L7:
        r1 = getPSN();
        r2 = getEMMC();
        goto L9
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

    private Bundle activate() {
        OLog.d(TAG, "send...");
        Bundle r2 = new Bundle();
        boolean r6 = true;
        PowerManager.WakeLock r4 = ((PowerManager) getSystemService(BatteryTypeInf.BATTERY_POWER_LOCK)).newWakeLock(1, "WifiConnectService");
        r4.acquire(61000);
        System.setProperty("http.keepAlive", "false");
        String r5 = getUploadMessage();
        boolean r7 = false;
        OutputStream r8 = null;
        BufferedReader r9 = null;
        r8 = null;
        HttpsURLConnection r0 = (HttpsURLConnection) new URL("").openConnection();     // Catch: Throwable -> L45 Exception -> L47
        HttpsURLConnection r10 = r0;     // Catch: Throwable -> L45 Exception -> L47
        r0.setHostnameVerifier(new DefaultHostNameVerify());     // Catch: Throwable -> L45 Exception -> L47
        HttpsURLConnection r11 = r0;     // Catch: Throwable -> L45 Exception -> L47
        r0.setSSLSocketFactory(getSSLContext().getSocketFactory());     // Catch: Throwable -> L45 Exception -> L47
        r0.setInstanceFollowRedirects(false);     // Catch: Throwable -> L45 Exception -> L47
        r0.setDoInput(true);     // Catch: Throwable -> L45 Exception -> L47
        r0.setRequestMethod("POST");     // Catch: Throwable -> L45 Exception -> L47
        r0.setRequestProperty("Cache-Control", HeaderConstants.CACHE_CONTROL_NO_CACHE);     // Catch: Throwable -> L45 Exception -> L47
        r0.setRequestProperty("Connection", "close");     // Catch: Throwable -> L45 Exception -> L47
        r0.setUseCaches(false);     // Catch: Throwable -> L45 Exception -> L47
        r0.setConnectTimeout(60000);     // Catch: Throwable -> L45 Exception -> L47
        r0.setReadTimeout(10000);     // Catch: Throwable -> L45 Exception -> L47
        r0.connect();     // Catch: Throwable -> L45 Exception -> L47
        OutputStream r12 = r0.getOutputStream();     // Catch: Throwable -> L45 Exception -> L47
    L88:
        r12.write(r5.getBytes());     // Catch: Throwable -> L39 Exception -> L42
        int r13 = r0.getResponseCode();     // Catch: Throwable -> L39 Exception -> L42
        if (r13 != 200) goto L30;
        BufferedReader r1 = new BufferedReader(new InputStreamReader(r0.getInputStream()), 2048);     // Catch: Throwable -> L39 Exception -> L42
        StringBuffer r3 = new StringBuffer();     // Catch: Throwable -> L26 Exception -> L28
    L8:
        String r14 = r1.readLine();     // Catch: Throwable -> L26 Exception -> L28
        if (r14 == null) goto L11;
        r3.append(r14);     // Catch: Throwable -> L26 Exception -> L28
        goto L8
    L11:
        r1.close();     // Catch: Throwable -> L26 Exception -> L28
        JSONObject r15 = new JSONObject(r3.toString());     // Catch: Throwable -> L26 Exception -> L28
        r15.getString("data");     // Catch: Throwable -> L26 Exception -> L28
        int r16 = r15.getInt(AlogMonitor.ALOG_RESULT_CODE);     // Catch: Throwable -> L26 Exception -> L28
        r15.getJSONArray("errInfo");     // Catch: Throwable -> L26 Exception -> L28
        JSONObject r17 = r15.getJSONObject("extra");     // Catch: Throwable -> L26 Exception -> L28
        if (DEBUG == false) goto L14;
        OLog.d(TAG, "json return " + r15);     // Catch: Throwable -> L26 Exception -> L28
    L16:
        if (r16 != 0) goto L22;
        r2.putInt("result", 0);     // Catch: Exception -> L19 Throwable -> L26
    L24:
        long r18 = r17.getLong("bind_uid");     // Catch: Exception -> L19 Throwable -> L26
        String r19 = r17.getString("bind_cellphone");     // Catch: Exception -> L19 Throwable -> L26
        r2.putLong("uid", r18);     // Catch: Exception -> L19 Throwable -> L26
        r2.putString("account", r19);     // Catch: Exception -> L19 Throwable -> L26
        r9 = r1;
        r7 = r6;
    L31:
        if (r12 != null) goto L80;
    L35:
        if (r9 == null) goto L60;
        r9.close();     // Catch: IOException -> L33
    L33:
        e = move-exception;
        e.printStackTrace();
    L60:
        if (r4.isHeld() == false) goto L62;
        r4.release();
    L62:
        OLog.d(TAG, "finish result success=" + r7 + " at " + this.sFormatter.format(new Date(System.currentTimeMillis())));
        return r2;
    L80:
        r12.close();     // Catch: IOException -> L33
        goto L35
    L19:
        e = e;
    L44:
        r8 = r12;
    L78:
        e.printStackTrace();     // Catch: Throwable -> L64
        OLog.e(TAG, "activate catch Exception: ", e);     // Catch: Throwable -> L64
        if (r8 != null) goto L76;
    L54:
        if (r1 == null) goto L58;
        r1.close();     // Catch: IOException -> L52
    L52:
        e = move-exception;
        e.printStackTrace();
    L58:
        r7 = r6;
        goto L60
    L76:
        r8.close();     // Catch: IOException -> L52
    L64:
        th = th;
    L65:
        if (r8 != null) goto L83;
    L69:
        if (r1 == null) goto L73;
        r1.close();     // Catch: IOException -> L67
    L67:
        e = move-exception;
        e.printStackTrace();
    L73:
        throw th;
    L83:
        r8.close();     // Catch: IOException -> L67
        goto L69
    L22:
        r2.putInt("result", -1);     // Catch: Throwable -> L26 Exception -> L28
        r6 = false;
        goto L24
    L14:
        OLog.d(TAG, "json return code " + r16);     // Catch: Throwable -> L26 Exception -> L28
    L26:
        th = th;
    L41:
        r8 = r12;
    L28:
        e = e;
        r6 = false;
        goto L44
    L30:
        OLog.e(TAG, "execute error, code=" + r13);     // Catch: Throwable -> L39 Exception -> L42
    L42:
        e = e;
        r6 = false;
        r1 = null;
    L39:
        th = th;
        r1 = null;
    L47:
        e = e;
        r6 = false;
        r1 = null;
    L45:
        th = th;
        r1 = null;
        goto L65
    }

    private boolean getToken() {
        OLog.d(TAG, "getToken.........");
        boolean r4 = true;
        PowerManager.WakeLock r1 = ((PowerManager) getSystemService(BatteryTypeInf.BATTERY_POWER_LOCK)).newWakeLock(1, "WifiConnectService");
        r1.acquire(61000);
        System.setProperty("http.keepAlive", "false");
        String r3 = getTokenMessage();
        if (DEBUG == false) goto L5;
        OLog.d(TAG, "getToken uploadMsg........." + r3);
    L6:
        boolean r5 = false;
        OutputStream r6 = null;
        BufferedReader r7 = null;
        r6 = null;
        HttpsURLConnection r8 = (HttpsURLConnection) new URL("").openConnection();     // Catch: Throwable -> L44 Exception -> L46
        HttpsURLConnection r9 = r8;     // Catch: Throwable -> L44 Exception -> L46
        r8.setHostnameVerifier(new DefaultHostNameVerify());     // Catch: Throwable -> L44 Exception -> L46
        HttpsURLConnection r10 = r8;     // Catch: Throwable -> L44 Exception -> L46
        r8.setSSLSocketFactory(getSSLContext().getSocketFactory());     // Catch: Throwable -> L44 Exception -> L46
        r8.setInstanceFollowRedirects(false);     // Catch: Throwable -> L44 Exception -> L46
        r8.setDoInput(true);     // Catch: Throwable -> L44 Exception -> L46
        r8.setRequestMethod("POST");     // Catch: Throwable -> L44 Exception -> L46
        r8.setRequestProperty("Cache-Control", HeaderConstants.CACHE_CONTROL_NO_CACHE);     // Catch: Throwable -> L44 Exception -> L46
        r8.setRequestProperty("Connection", "close");     // Catch: Throwable -> L44 Exception -> L46
        r8.setUseCaches(false);     // Catch: Throwable -> L44 Exception -> L46
        r8.setConnectTimeout(60000);     // Catch: Throwable -> L44 Exception -> L46
        r8.setReadTimeout(10000);     // Catch: Throwable -> L44 Exception -> L46
        r8.connect();     // Catch: Throwable -> L44 Exception -> L46
        OutputStream r11 = r8.getOutputStream();     // Catch: Throwable -> L44 Exception -> L46
        r11.write(r3.getBytes());     // Catch: Throwable -> L38 Exception -> L41
        int r12 = r8.getResponseCode();     // Catch: Throwable -> L38 Exception -> L41
        if (r12 != 200) goto L29;
        BufferedReader r0 = new BufferedReader(new InputStreamReader(r8.getInputStream()), 2048);     // Catch: Throwable -> L38 Exception -> L41
        StringBuffer r13 = new StringBuffer();     // Catch: Throwable -> L25 Exception -> L27
    L12:
        String r14 = r0.readLine();     // Catch: Throwable -> L25 Exception -> L27
        if (r14 == null) goto L15;
        r13.append(r14);     // Catch: Throwable -> L25 Exception -> L27
        goto L12
    L15:
        r0.close();     // Catch: Throwable -> L25 Exception -> L27
        JSONObject r15 = new JSONObject(r13.toString());     // Catch: Throwable -> L25 Exception -> L27
        int r16 = r15.getInt(AlogMonitor.ALOG_RESULT_CODE);     // Catch: Throwable -> L25 Exception -> L27
        if (DEBUG == false) goto L18;
        OLog.d(TAG, "json return " + r15);     // Catch: Throwable -> L25 Exception -> L27
    L19:
        r15.getJSONArray("errInfo");     // Catch: Throwable -> L25 Exception -> L27
        if (r16 != 0) goto L23;
        JSONObject r17 = r15.getJSONObject("data");     // Catch: Throwable -> L25 Exception -> L27
        this.mSecret = r17.getString(FaceVerifyManager.PATH_SECRET);     // Catch: Throwable -> L25 Exception -> L27
        this.mTimeStamp = r17.getInt("timestamp");     // Catch: Throwable -> L25 Exception -> L27
        OLog.d(TAG, "json mSecret " + this.mSecret);     // Catch: Throwable -> L25 Exception -> L27
        OLog.d(TAG, "json mTimeStamp " + this.mTimeStamp);     // Catch: Throwable -> L25 Exception -> L27
    L24:
        r7 = r0;
        r5 = r4;
    L30:
        if (r11 == null) goto L34;
        r11.close();     // Catch: IOException -> L32
    L34:
        if (r7 == null) goto L54;
        r7.close();     // Catch: IOException -> L32
    L54:
        if (r1.isHeld() == false) goto L56;
        r1.release();
    L56:
        OLog.d(TAG, "finish result success=" + r5 + " at " + this.sFormatter.format(new Date(System.currentTimeMillis())));
        return r5;
    L23:
        r4 = false;
        goto L24
    L18:
        OLog.d(TAG, "json return code " + r16);     // Catch: Throwable -> L25 Exception -> L27
    L27:
        e = e;
    L43:
        r6 = r11;
    L71:
        e.printStackTrace();     // Catch: Throwable -> L58
        OLog.e(TAG, "activate catch Exception: ", e);     // Catch: Throwable -> L58
        if (r6 == null) goto L51;
        r6.close();     // Catch: IOException -> L32
    L51:
        if (r0 == null) goto L54;
        r0.close();     // Catch: IOException -> L32
    L58:
        th = th;
    L59:
        if (r6 != null) goto L69;
    L63:
        if (r0 == null) goto L67;
        r0.close();     // Catch: IOException -> L61
    L61:
        e = move-exception;
        e.printStackTrace();
    L67:
        throw th;
    L69:
        r6.close();     // Catch: IOException -> L61
    L25:
        th = th;
    L40:
        r6 = r11;
        goto L59
    L29:
        OLog.e(TAG, "execute error, code=" + r12);     // Catch: Throwable -> L38 Exception -> L41
    L41:
        e = e;
        r0 = null;
    L38:
        th = th;
        r0 = null;
        goto L40
    L32:
        e = move-exception;
        e.printStackTrace();
    L46:
        e = e;
        r0 = null;
    L44:
        th = th;
        r0 = null;
        goto L59
    L5:
        OLog.d(TAG, "getToken uploadMsg.........");
        goto L6
    }

    private String getTokenMessage() {
        String r0 = getImei();
        String r1 = getWifiMac();
        String r4 = getBtMac();
        String r5 = "{\"imei\":\"" + r0 + "\",\"btmac\":\"" + r4 + "\",\"wifimac\":\"" + r1 + "\",\"signature\":\"" + Keys.encrypt(r0, r1, r4, 1) + "\"}";
        OLog.d(TAG, "getTokenMessage: " + r5);
        return r5;
    }

    private void updateLocation() {
        LocationManager r1 = (LocationManager) getSystemService("location");     // Catch: IllegalArgumentException -> L4
        this.mLocationManager = r1;     // Catch: IllegalArgumentException -> L4
        r1.requestLocationUpdates("network", 6000, 1.0f, this.mLocationListener);     // Catch: IllegalArgumentException -> L4
        this.mLocationManager.requestLocationUpdates("gps", 6000, 1.0f, this.mLocationListener);     // Catch: IllegalArgumentException -> L4
    L6:
        Runnable r0 = new AnonymousClass4(this);
        this.mCheckLocationHandler.postDelayed(r0, 2000);
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
        goto L6
    }

    private String getLocationInfo() {
        if (this.mLocation != null) goto L21;
        OLog.e(TAG, "get location failed !");
        return "\"UNKNOWN\"";
    L21:
        List<Address> r2 = new Geocoder(this, Locale.SIMPLIFIED_CHINESE).getFromLocation(this.mLocation.getLatitude(), this.mLocation.getLongitude(), 1);     // Catch: Exception -> L18
        if (r2 != null) goto L10;
    L17:
        return "\"UNKNOWN\"";
    L10:
        if (r2.size() <= 0) goto L17;
        Address r3 = r2.get(0);     // Catch: Exception -> L18
        if (this.mMsg != 1) goto L16;
        return "{\"countryName\":\"" + r3.getCountryName() + "\",\"admin\":\"" + r3.getAdminArea() + "\",\"locality\":\"" + r3.getLocality() + "\"}";
    L16:
        return r3.getCountryName() + "," + r3.getAdminArea() + "," + r3.getLocality();
    L18:
        e = move-exception;
        e.printStackTrace();
        return "\"UNKNOWN\"";
    }

    private String getFactoryMode() {
        if (SystemProperties.getBoolean("persist.bytedance.factory_mode", false) == false) goto L5;
        return "1";
    L5:
        return "0";
    }

    private void getSmsGateway() {
        PowerManager.WakeLock r3 = ((PowerManager) getSystemService(BatteryTypeInf.BATTERY_POWER_LOCK)).newWakeLock(1, "SmsConnectService");
        r3.acquire(61000);
        System.setProperty("http.keepAlive", "false");
        BufferedReader r6 = null;
        HttpURLConnection r7 = (HttpURLConnection) new URL("").openConnection();     // Catch: Throwable -> L36 Exception -> L38
        int r8 = 0;
        r7.setInstanceFollowRedirects(false);     // Catch: Throwable -> L36 Exception -> L38
        r7.setDoInput(true);     // Catch: Throwable -> L36 Exception -> L38
        r7.setRequestMethod("POST");     // Catch: Throwable -> L36 Exception -> L38
        r7.setRequestProperty("Cache-Control", HeaderConstants.CACHE_CONTROL_NO_CACHE);     // Catch: Throwable -> L36 Exception -> L38
        r7.setRequestProperty("Connection", "close");     // Catch: Throwable -> L36 Exception -> L38
        r7.setUseCaches(false);     // Catch: Throwable -> L36 Exception -> L38
        r7.setConnectTimeout(60000);     // Catch: Throwable -> L36 Exception -> L38
        r7.setReadTimeout(10000);     // Catch: Throwable -> L36 Exception -> L38
        r7.connect();     // Catch: Throwable -> L36 Exception -> L38
        int r5 = r7.getResponseCode();     // Catch: Throwable -> L36 Exception -> L38
        if (r5 != 200) goto L24;
        BufferedReader r2 = new BufferedReader(new InputStreamReader(r7.getInputStream()), 2048);     // Catch: Throwable -> L36 Exception -> L38
        StringBuffer r9 = new StringBuffer();     // Catch: Throwable -> L20 Exception -> L22
    L7:
        String r10 = r2.readLine();     // Catch: Throwable -> L20 Exception -> L22
        if (r10 == null) goto L10;
        r9.append(r10);     // Catch: Throwable -> L20 Exception -> L22
        goto L7
    L10:
        r2.close();     // Catch: Throwable -> L20 Exception -> L22
        String r11 = r9.toString();     // Catch: Throwable -> L20 Exception -> L22
        OLog.e(TAG, "responseResult=" + r11);     // Catch: Throwable -> L20 Exception -> L22
        String[] r12 = new JSONObject(r11).getString("sms_gate").split(",");     // Catch: Throwable -> L20 Exception -> L22
    L11:
        if (r8 >= r12.length) goto L19;
        String r13 = r12[r8];     // Catch: Throwable -> L20 Exception -> L22
        if (TextUtils.isEmpty(r13) == true) goto L18;
        if (mGateWays.contains(r13) == true) goto L18;
        OLog.d(TAG, "mGateWays" + r8 + HanziToPinyin.Token.SEPARATOR + r13);     // Catch: Throwable -> L20 Exception -> L22
        mGateWays.add(r13);     // Catch: Throwable -> L20 Exception -> L22
    L18:
        r8 = r8 + 1;
        goto L11
    L19:
        r6 = r2;
    L25:
        if (r6 == null) goto L31;
        r6.close();     // Catch: IOException -> L28
    L28:
        e = move-exception;
        e.printStackTrace();
    L31:
        if (mGateWays.contains(ACTIVATE_NUMBER) == true) goto L33;
        mGateWays.add(ACTIVATE_NUMBER);
    L33:
        Handler r1 = this.mReportHandler;
        if (r1 == null) goto L52;
    L50:
        r1.sendEmptyMessage(3);
    L52:
        if (r3.isHeld() == false) goto L55;
        r3.release();
    L55:
        if (DEBUG == false) goto L84;
        OLog.i(TAG, "getSmsGateway finish result at " + this.sFormatter.format(new Date(System.currentTimeMillis())));
        return;
    L84:
        return;
    L22:
        e = e;
        r6 = r2;
    L39:
        e.printStackTrace();     // Catch: Throwable -> L36
        if (r6 == null) goto L46;
        r6.close();     // Catch: IOException -> L43
    L43:
        e = move-exception;
        e.printStackTrace();
    L46:
        if (mGateWays.contains(ACTIVATE_NUMBER) == true) goto L48;
        mGateWays.add(ACTIVATE_NUMBER);
    L48:
        r1 = this.mReportHandler;
        if (r1 == null) goto L52;
    L20:
        th = th;
        r6 = r2;
    L58:
        if (r6 == null) goto L64;
        r6.close();     // Catch: IOException -> L61
    L61:
        e = move-exception;
        e.printStackTrace();
    L64:
        if (mGateWays.contains(ACTIVATE_NUMBER) == true) goto L66;
        mGateWays.add(ACTIVATE_NUMBER);
    L66:
        Handler r14 = this.mReportHandler;
        if (r14 == null) goto L85;
        r14.sendEmptyMessage(3);
        throw th;
    L85:
        throw th;
    L24:
        OLog.e(TAG, "execute error, code=" + r5);     // Catch: Throwable -> L36 Exception -> L38
    L36:
        th = th;
    L38:
        e = e;
        goto L39
    }

    public static String GetSendingGateway() {
        if (mGateWays.size() != 0) goto L6;
        return ACTIVATE_NUMBER;
    L6:
        int r0 = mGateWays.size();
        int r1 = mGateWayIndex;
        if (r0 < r1) goto L13;
        if (r1 >= 1) goto L12;
        return mGateWays.get(0);
    L12:
        return mGateWays.get(r1 - 1);
    L13:
        ArrayList<String> r2 = mGateWays;
        return r2.get(r2.size() - 1);
    }

    public static void sendUploadIMEI(final Context r2) {
        new Thread(new AnonymousClass5(r2)).start();
    }
}
