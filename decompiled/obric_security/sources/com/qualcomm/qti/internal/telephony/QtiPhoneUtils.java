package com.qualcomm.qti.internal.telephony;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Message;
import android.os.RemoteException;
import android.provider.Settings;
import android.telephony.ImsiEncryptionInfo;
import android.telephony.NetworkScanRequest;
import android.telephony.Rlog;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import com.android.internal.telephony.OperatorInfo;
import com.android.internal.telephony.Phone;
import com.android.internal.telephony.PhoneFactory;
import com.android.internal.telephony.RIL;
import com.qti.extphone.Client;
import com.qti.extphone.ExtTelephonyManager;
import com.qti.extphone.IExtPhoneCallback;
import com.qti.extphone.QtiSetNetworkSelectionMode;
import com.qti.extphone.ServiceCallback;
import com.qti.extphone.Token;
import com.qualcomm.qti.internal.telephony.data.QtiDataServiceManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class QtiPhoneUtils {
    private static final String TAG = "QtiPhoneUtils";
    private static QtiPhoneUtils sInstance;
    private static List<OnQtiPhoneReadyListener> sReadyListeners;
    private final HashMap<Integer, QtiDataServiceManager.QtiCellularDataServiceCallback> mCellularDataServiceCallbacks;
    private Client mClient;
    private Context mContext;
    protected IExtPhoneCallback mExtPhoneCallback;
    private ServiceCallback mExtTelManagerServiceCallback;
    private ExtTelephonyManager mExtTelephonyManager;
    private final HashMap<Integer, Message> mPendingRequests;
    private QtiCarrierInfoManager.QtiCarrierInfoResponse mQtiCarrierInfoResponse;

    public interface OnQtiPhoneReadyListener {
        void onQtiPhoneReady();
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCellularDataServiceCallbacks, reason: not valid java name */
    static /* bridge */ /* synthetic */ HashMap m669$$Nest$fgetmCellularDataServiceCallbacks(QtiPhoneUtils r0) {
        return r0.mCellularDataServiceCallbacks;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmClient, reason: not valid java name */
    static /* bridge */ /* synthetic */ Client m670$$Nest$fgetmClient(QtiPhoneUtils r0) {
        return r0.mClient;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m671$$Nest$fgetmContext(QtiPhoneUtils r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmExtTelephonyManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ ExtTelephonyManager m672$$Nest$fgetmExtTelephonyManager(QtiPhoneUtils r0) {
        return r0.mExtTelephonyManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPendingRequests, reason: not valid java name */
    static /* bridge */ /* synthetic */ HashMap m673$$Nest$fgetmPendingRequests(QtiPhoneUtils r0) {
        return r0.mPendingRequests;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmQtiCarrierInfoResponse, reason: not valid java name */
    static /* bridge */ /* synthetic */ QtiCarrierInfoManager.QtiCarrierInfoResponse m674$$Nest$fgetmQtiCarrierInfoResponse(QtiPhoneUtils r0) {
        return r0.mQtiCarrierInfoResponse;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmClient, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m675$$Nest$fputmClient(QtiPhoneUtils r0, Client r1) {
        r0.mClient = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetsReadyListeners, reason: not valid java name */
    static /* bridge */ /* synthetic */ List m676$$Nest$sfgetsReadyListeners() {
        return sReadyListeners;
    }

    static {
        sReadyListeners = new ArrayList();
    }

    static QtiPhoneUtils init(Context r2) {
        monitor-enter(QtiPhoneUtils.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sInstance != null) goto L7;
        sInstance = new QtiPhoneUtils(r2);     // Catch: Throwable -> L10
    L7:
        monitor-exit(QtiPhoneUtils.class);     // Catch: Throwable -> L10
        return sInstance;
    }

    public static QtiPhoneUtils getInstance() {
        monitor-enter(QtiPhoneUtils.class);
        QtiPhoneUtils r1 = sInstance;     // Catch: Throwable -> L10
        if (r1 == null) goto L9;
        monitor-exit(QtiPhoneUtils.class);     // Catch: Throwable -> L10
        return r1;
    L9:
        throw new RuntimeException("QtiPhoneUtils was not initialized!");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    private QtiPhoneUtils(Context r2) {
        this.mPendingRequests = new HashMap();
        this.mCellularDataServiceCallbacks = new HashMap();
        this.mExtTelManagerServiceCallback = new AnonymousClass1(this);
        this.mExtPhoneCallback = new AnonymousClass2(this);
        this.mContext = r2;
        ExtTelephonyManager r3 = ExtTelephonyManager.getInstance(r2);
        this.mExtTelephonyManager = r3;
        r3.connectService(this.mExtTelManagerServiceCallback);
    }

    public static void addOnQtiPhoneReadyListener(OnQtiPhoneReadyListener r1) {
        sReadyListeners.add(r1);
    }

    public void registerDataServiceCallbackForQos(int r3, QtiDataServiceManager.QtiCellularDataServiceCallback r4) {
        Rlog.d(TAG, "registerDataServiceCallbackForQos, phoneId: " + r3);
        this.mCellularDataServiceCallbacks.put(Integer.valueOf(r3), r4);
    }

    public boolean getPropertyValueBool(String r1, boolean r2) {
        return this.mExtTelephonyManager.getPropertyValueBool(r1, r2);
    }

    boolean sendCdmaSms(int r5, byte[] r6, Message r7, boolean r8) {
        int r1 = 0;
        if (this.mExtTelephonyManager.isServiceConnected() == true) goto L5;
        return false;
    L5:
        Rlog.d(TAG, "sendCdmaSms, expectMore=" + r8);
        r1 = this.mExtTelephonyManager.sendCdmaSms(r5, r6, r8, this.mClient).get();     // Catch: RuntimeException -> L8
    L10:
        HashMap<Integer, Message> r9 = this.mPendingRequests;
        monitor-enter(r9);
        this.mPendingRequests.put(Integer.valueOf(r1), r7);     // Catch: Throwable -> L16
        monitor-exit(r9);     // Catch: Throwable -> L16
        return true;
    L16:
        th = move-exception;
        throw th;
    L8:
        e = move-exception;
        Rlog.e(TAG, "Exception sendCdmaSms " + e);
        goto L10
    }

    boolean startNetworkScan(int r4, NetworkScanRequest r5, Message r6) {
        int r1 = 0;
        if (this.mExtTelephonyManager.isServiceConnected() == true) goto L18;
        return false;
    L18:
        r1 = this.mExtTelephonyManager.startNetworkScan(r4, r5, this.mClient).get();     // Catch: RuntimeException -> L7
    L9:
        HashMap<Integer, Message> r7 = this.mPendingRequests;
        monitor-enter(r7);
        this.mPendingRequests.put(Integer.valueOf(r1), r6);     // Catch: Throwable -> L15
        monitor-exit(r7);     // Catch: Throwable -> L15
        return true;
    L15:
        th = move-exception;
        throw th;
    L7:
        e = move-exception;
        Rlog.e(TAG, "Exception startNetworkScan " + e);
        goto L9
    }

    boolean stopNetworkScan(int r5, Message r6) {
        int r1 = 0;
        if (this.mExtTelephonyManager.isServiceConnected() == true) goto L18;
        return false;
    L18:
        r1 = this.mExtTelephonyManager.stopNetworkScan(r5, this.mClient).get();     // Catch: RuntimeException -> L7
    L9:
        HashMap<Integer, Message> r7 = this.mPendingRequests;
        monitor-enter(r7);
        this.mPendingRequests.put(Integer.valueOf(r1), r6);     // Catch: Throwable -> L15
        monitor-exit(r7);     // Catch: Throwable -> L15
        return true;
    L15:
        th = move-exception;
        throw th;
    L7:
        e = move-exception;
        Rlog.e(TAG, "Exception stopNetworkScan " + e);
        goto L9
    }

    boolean setNetworkSelectionModeManual(int r12, OperatorInfo r13, Message r14) {
        int r1 = 0;
        if (this.mExtTelephonyManager.isServiceConnected() == true) goto L6;
        return false;
    L6:
        if (r13.getCagInfo() == null) goto L8;
        long r2 = r13.getCagInfo().getCagId();
    L9:
        long r8 = r2;
        if (r13.getSnpnInfo() == null) goto L12;
        byte[] r0 = r13.getSnpnInfo().getNid();
    L29:
        r1 = this.mExtTelephonyManager.setNetworkSelectionModeManual(r12, new QtiSetNetworkSelectionMode(r13.getOperatorNumeric(), r13.getRan(), r13.getAccessMode(), r8, r0), this.mClient).get();     // Catch: RuntimeException -> L16
    L18:
        HashMap<Integer, Message> r15 = this.mPendingRequests;
        monitor-enter(r15);
        this.mPendingRequests.put(Integer.valueOf(r1), r14);     // Catch: Throwable -> L24
        monitor-exit(r15);     // Catch: Throwable -> L24
        return true;
    L24:
        th = move-exception;
        throw th;
    L16:
        e = move-exception;
        Rlog.e(TAG, "Exception setNetworkSelectionModeManual " + e);
        goto L18
    L12:
        r0 = null;
        goto L29
    L8:
        r2 = -1;
        goto L9
    }

    boolean setNetworkSelectionModeAutomatic(int r4, int r5, Message r6) {
        int r1 = 0;
        if (this.mExtTelephonyManager.isServiceConnected() == true) goto L18;
        return false;
    L18:
        r1 = this.mExtTelephonyManager.setNetworkSelectionModeAutomatic(r4, r5, this.mClient).get();     // Catch: RuntimeException -> L7
    L9:
        HashMap<Integer, Message> r7 = this.mPendingRequests;
        monitor-enter(r7);
        this.mPendingRequests.put(Integer.valueOf(r1), r6);     // Catch: Throwable -> L15
        monitor-exit(r7);     // Catch: Throwable -> L15
        return true;
    L15:
        th = move-exception;
        throw th;
    L7:
        e = move-exception;
        Rlog.e(TAG, "Exception setNetworkSelectionModeAutomatic " + e);
        goto L9
    }

    boolean getQtiRadioCapability(int r4, Message r5) throws RemoteException {
        if (this.mExtTelephonyManager.isServiceConnected() == true) goto L6;
        return false;
    L6:
        Rlog.d(TAG, "getQtiRadioCapability, response=" + r5);
        int r6 = this.mExtTelephonyManager.getQtiRadioCapability(r4, this.mClient).get();
        HashMap<Integer, Message> r0 = this.mPendingRequests;
        monitor-enter(r0);
        this.mPendingRequests.put(Integer.valueOf(r6), r5);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return true;
    L12:
        th = move-exception;
        throw th;
    }

    void setCarrierInfoForImsiEncryption(int r3, ImsiEncryptionInfo r4, QtiCarrierInfoManager.QtiCarrierInfoResponse r5) {
        if (this.mExtTelephonyManager.isServiceConnected() == true) goto L5;
        return;
    L5:
        this.mQtiCarrierInfoResponse = r5;
        Rlog.d(TAG, "setCarrierInfoForImsiEncryption, phoneId=" + r3);
        int r6 = this.mExtTelephonyManager.setCarrierInfoForImsiEncryption(r3, r4, this.mClient).get();     // Catch: RuntimeException -> L8
    L10:
        HashMap<Integer, Message> r7 = this.mPendingRequests;
        monitor-enter(r7);
        this.mPendingRequests.put(Integer.valueOf(r6), new Message());     // Catch: Throwable -> L15
        monitor-exit(r7);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        throw th;
    L8:
        e = move-exception;
        Rlog.e(TAG, "Exception setCarrierInfoForImsiEncryption " + e);
        r6 = 0;
        goto L10
    }

    public int getPhoneCount() {
        return ((TelephonyManager) this.mContext.getSystemService("phone")).getPhoneCount();
    }

    public boolean isValidPhoneId(int r1) {
        if (r1 >= 0) goto L4;
    L6:
        return false;
    L4:
        if (r1 >= getPhoneCount()) goto L6;
        return true;
    }

    public static boolean putIntAtIndex(ContentResolver r7, String r8, int r9, int r10) {
        String r0 = Settings.Global.getString(r7, r8);
        if (r9 == Integer.MAX_VALUE) goto L27;
        if (r9 < 0) goto L25;
        if (r0 == null) goto L8;
        String[] r1 = r0.split(",");
    L9:
        int r3 = 0;
        String r4 = "";
    L10:
        if (r3 >= r9) goto L17;
        if (r1 != null) goto L13;
    L15:
        String r5 = "";
    L16:
        r4 = r4 + r5 + ",";
        r3 = r3 + 1;
        goto L10
    L13:
        if (r3 >= r1.length) goto L15;
        r5 = r1[r3];
        goto L16
    L17:
        String r11 = r4 + r10;
        if (r1 == null) goto L23;
    L19:
        r9 = r9 + 1;
        if (r9 >= r1.length) goto L23;
        r11 = r11 + "," + r1[r9];
    L23:
        return Settings.Global.putString(r7, r8, r11);
    L8:
        r1 = null;
        goto L9
    L25:
        throw new IllegalArgumentException("putIntAtIndex index < 0 index=" + r9);
    L27:
        throw new IllegalArgumentException("putIntAtIndex index == MAX_VALUE index=" + r9);
    }

    public static int getIntAtIndex(ContentResolver r1, String r2, int r3) throws Settings.SettingNotFoundException {
        String r4 = Settings.Global.getString(r1, r2);
        if (r4 == null) goto L13;
        String[] r5 = r4.split(",");
        if (r3 < 0) goto L13;
        if (r3 >= r5.length) goto L13;
        String r6 = r5[r3];
        if (r6 == null) goto L13;
        return Integer.parseInt(r6);
    L13:
        throw new Settings.SettingNotFoundException(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.StringBuilder] */
    public int getCurrentUiccCardProvisioningStatus(int r3) {
        if (isValidPhoneId(r3) == true) goto L5;
        return -1;
    L5:
        Phone r0 = PhoneFactory.getPhone(r3);
        if (r0 != null) goto L9;
        return -1;
    L9:
        if (r0.getHalVersion().greaterOrEqual(RIL.RADIO_HAL_VERSION_1_5) == false) goto L16;
        int[] r1 = QtiSubscriptionController.getInstance().getSubId(r3);
        if (r1 != null) goto L13;
    L15:
        ?? r2 = -2;
    L17:
        Rlog.d(TAG, " getCurrentUiccCardProvisioningStatus, state[" + r3 + "] = " + r2);
        return r2;
    L13:
        if (r1.length == 0) goto L15;
        r2 = ((SubscriptionManager) this.mContext.getSystemService("telephony_subscription_service")).getActiveSubscriptionInfo(r1[0]).areUiccApplicationsEnabled();
        goto L17
    L16:
        r2 = QtiUiccCardProvisioner.getInstance().getCurrentUiccCardProvisioningStatus(r3);
        goto L17
    }

    public void getQosParameters(int r4, int r5, Message r6) throws RemoteException {
        if (this.mExtTelephonyManager.isServiceConnected() == true) goto L5;
        return;
    L5:
        Rlog.d(TAG, "getQosParameters, phoneId: " + r4 + ", cid: " + r5 + ", response: " + r6);
        Token r7 = this.mExtTelephonyManager.getQosParameters(r4, r5, this.mClient);     // Catch: Exception -> L8
    L10:
        if (r7 == null) goto L20;
        int r8 = r7.get();
        HashMap<Integer, Message> r9 = this.mPendingRequests;
        monitor-enter(r9);
        this.mPendingRequests.put(Integer.valueOf(r8), r6);     // Catch: Throwable -> L16
        monitor-exit(r9);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        throw th;
    L20:
        throw new RuntimeException("API is not available");
    L8:
        e = move-exception;
        Rlog.d(TAG, "getQosParameters, caught exception", e);
        r7 = null;
        goto L10
    }
}
