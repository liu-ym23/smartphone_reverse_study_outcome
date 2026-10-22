package com.qualcomm.qti.internal.telephony;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.PersistableBundle;
import android.os.Registrant;
import android.os.RegistrantList;
import android.os.SystemProperties;
import android.telephony.CarrierConfigManager;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.android.ims.FeatureConnector;
import com.android.ims.FeatureUpdates;
import com.android.ims.ImsException;
import com.android.ims.ImsManager;
import com.android.internal.telephony.Phone;
import com.android.internal.telephony.PhoneFactory;
import org.codeaurora.ims.QtiImsException;
import org.codeaurora.ims.QtiImsExtConnector;
import org.codeaurora.ims.QtiImsExtListenerBaseImpl;
import org.codeaurora.ims.QtiImsExtManager;

/* JADX INFO: loaded from: classes4.dex */
public class ScbmHandler extends Handler {
    public static final int CANCEL_SCM_TIMER = 1;
    private static final String LOG_TAG = "ScbmHandler";
    public static final int RESTART_SCM_TIMER = 0;
    private static ScbmHandler sScbmHandler;
    private final String ACTION_SMS_CALLBACK_MODE;
    private final String EXTRA_SMS_CALLBACK_MODE;
    private final String EXTRA_SMS_PERMISSION;
    private QtiImsExtListenerBaseImpl imsInterfaceListener;
    private Context mContext;
    private boolean mIsExitScbmFeatureRetrieved;
    private boolean mIsExitScbmFeatureSupported;
    private boolean mIsPhoneInScbmState;
    private QtiImsExtConnector mQtiImsExtConnector;
    private QtiImsExtManager mQtiImsExtManager;
    private Registrant mScbmExitRespRegistrant;
    private int mScbmPhoneId;
    private final BroadcastReceiver mScbmReceiver;
    private boolean mScmCanceledForEmergency;
    private final RegistrantList mScmTimerResetRegistrants;
    private SubscriptionManager mSubscriptionManager;

    private class ImsFeatureConnector implements FeatureConnector.Listener<ImsManager> {
        private static final int CONNECTOR_RETRY_DELAY_MS = 5000;
        private FeatureConnector<ImsManager> mFeatureConnector;
        private Runnable mFeatureConnectorRunnable;
        final /* synthetic */ ScbmHandler this$0;

        /* JADX INFO: renamed from: -$$Nest$fgetmFeatureConnector, reason: not valid java name */
        static /* bridge */ /* synthetic */ FeatureConnector m711$$Nest$fgetmFeatureConnector(ImsFeatureConnector r0) {
            return r0.mFeatureConnector;
        }

        public /* bridge */ /* synthetic */ void connectionReady(FeatureUpdates r1, int r2) throws ImsException {
            connectionReady((ImsManager) r1, r2);
        }

        public ImsFeatureConnector(ScbmHandler r3, int r4) {
            this.this$0 = r3;
            this.mFeatureConnectorRunnable = new AnonymousClass1(this);
            FeatureConnector<ImsManager> r5 = ImsManager.getConnector(ScbmHandler.m696$$Nest$fgetmContext(r3), r4, ScbmHandler.LOG_TAG, this, ScbmHandler.m696$$Nest$fgetmContext(r3).getMainExecutor());
            this.mFeatureConnector = r5;
            r5.connect();
        }

        public void connectionReady(ImsManager r1, int r2) throws ImsException {
            Log.d(ScbmHandler.LOG_TAG, "connectionReady");
            if (ScbmHandler.m699$$Nest$fgetmQtiImsExtConnector(this.this$0) != null) goto L6;
            Log.d(ScbmHandler.LOG_TAG, "connectionReady createQtiImsExtConnector");
            ScbmHandler r3 = this.this$0;
            ScbmHandler.m704$$Nest$mcreateQtiImsExtConnector(r3, ScbmHandler.m696$$Nest$fgetmContext(r3));
            ScbmHandler.m699$$Nest$fgetmQtiImsExtConnector(this.this$0).connect();
            return;
        }

        public void connectionUnavailable(int r3) {
            Log.d(ScbmHandler.LOG_TAG, "connectionUnavailable");
            if (r3 == 3) goto L5;
            return;
        L5:
            if (ScbmHandler.m699$$Nest$fgetmQtiImsExtConnector(this.this$0) != null) goto L9;
            this.this$0.removeCallbacks(this.mFeatureConnectorRunnable);
            this.this$0.postDelayed(this.mFeatureConnectorRunnable, 5000);
            return;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m696$$Nest$fgetmContext(ScbmHandler r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmIsExitScbmFeatureRetrieved, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m697$$Nest$fgetmIsExitScbmFeatureRetrieved(ScbmHandler r0) {
        return r0.mIsExitScbmFeatureRetrieved;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmIsExitScbmFeatureSupported, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m698$$Nest$fgetmIsExitScbmFeatureSupported(ScbmHandler r0) {
        return r0.mIsExitScbmFeatureSupported;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmQtiImsExtConnector, reason: not valid java name */
    static /* bridge */ /* synthetic */ QtiImsExtConnector m699$$Nest$fgetmQtiImsExtConnector(ScbmHandler r0) {
        return r0.mQtiImsExtConnector;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmQtiImsExtManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ QtiImsExtManager m700$$Nest$fgetmQtiImsExtManager(ScbmHandler r0) {
        return r0.mQtiImsExtManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmIsExitScbmFeatureRetrieved, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m701$$Nest$fputmIsExitScbmFeatureRetrieved(ScbmHandler r0, boolean r1) {
        r0.mIsExitScbmFeatureRetrieved = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmIsExitScbmFeatureSupported, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m702$$Nest$fputmIsExitScbmFeatureSupported(ScbmHandler r0, boolean r1) {
        r0.mIsExitScbmFeatureSupported = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmQtiImsExtManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m703$$Nest$fputmQtiImsExtManager(ScbmHandler r0, QtiImsExtManager r1) {
        r0.mQtiImsExtManager = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mcreateQtiImsExtConnector, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m704$$Nest$mcreateQtiImsExtConnector(ScbmHandler r0, Context r1) {
        r0.createQtiImsExtConnector(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetScbmPhoneId, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m705$$Nest$mgetScbmPhoneId(ScbmHandler r0) {
        return r0.getScbmPhoneId();
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleEnterScbm, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m706$$Nest$mhandleEnterScbm(ScbmHandler r0) {
        r0.handleEnterScbm();
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleExitScbm, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m707$$Nest$mhandleExitScbm(ScbmHandler r0) {
        r0.handleExitScbm();
    }

    /* JADX INFO: renamed from: -$$Nest$misCarrierConfigEnabledScbm, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m708$$Nest$misCarrierConfigEnabledScbm(ScbmHandler r0, int r1) {
        return r0.isCarrierConfigEnabledScbm(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$msetIsInScbm, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m709$$Nest$msetIsInScbm(ScbmHandler r0, int r1, boolean r2) {
        r0.setIsInScbm(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$msetScbmPhoneId, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m710$$Nest$msetScbmPhoneId(ScbmHandler r0, int r1) {
        r0.setScbmPhoneId(r1);
    }

    static {
    }

    private ScbmHandler(Context r6) {
        this.mScmTimerResetRegistrants = new RegistrantList();
        this.ACTION_SMS_CALLBACK_MODE = "org.codeaurora.intent.action.SMS_CALLBACK_MODE";
        this.EXTRA_SMS_CALLBACK_MODE = "sms_callback_mode";
        this.EXTRA_SMS_PERMISSION = "com.qti.permission.RECEIVE_SMS_CALLBACK_MODE";
        this.mScbmPhoneId = -1;
        int r2 = 0;
        this.mIsPhoneInScbmState = false;
        this.mScmCanceledForEmergency = false;
        this.mIsExitScbmFeatureRetrieved = false;
        this.mIsExitScbmFeatureSupported = false;
        BroadcastReceiver r3 = new AnonymousClass1(this);
        this.mScbmReceiver = r3;
        this.imsInterfaceListener = new AnonymousClass2(this);
        this.mContext = r6;
        r6.registerReceiver(r3, new IntentFilter("org.codeaurora.intent.action.SMS_CALLBACK_MODE"), "com.qti.permission.RECEIVE_SMS_CALLBACK_MODE", null);
        this.mSubscriptionManager = (SubscriptionManager) this.mContext.getSystemService("telephony_subscription_service");
        if (SystemProperties.getBoolean("ril.inscbm", false) == false) goto L6;
        setIsInScbm(0, false);
        handleExitScbm();
    L6:
        if (ImsManager.isImsSupportedOnDevice(this.mContext) == false) goto L10;
        int r7 = ((TelephonyManager) this.mContext.getSystemService("phone")).getActiveModemCount();
    L8:
        if (r2 >= r7) goto L12;
        new ImsFeatureConnector(this, r2);
        r2 = r2 + 1;
        goto L8
    L12:
        return;
    }

    private boolean isCarrierConfigEnabledScbm(int r2) {
        CarrierConfigManager r1 = (CarrierConfigManager) this.mContext.getSystemService("carrier_config");
        if (r1 != null) goto L5;
        return false;
    L5:
        PersistableBundle r3 = r1.getConfigForSubId(r2);
        if (r3 != null) goto L8;
        return false;
    L8:
        if (r3.getBoolean("use_sms_callback_mode_bool") == false) goto L12;
        return true;
    L12:
        return false;
    }

    private void handleEnterScbm() {
        Log.i(LOG_TAG, "handleEnterScbm");
        sendSmsCallbackModeChange();
    }

    private void sendSmsCallbackModeChange() {
        Intent r0 = new Intent("org.codeaurora.intent.action.SMS_CALLBACK_MODE_CHANGED");
        r0.putExtra("org.codeaurora.extra.PHONE_IN_SCM_STATE", isInScbm());
        SubscriptionManager.putPhoneIdAndSubIdExtra(r0, getScbmPhoneId());
        ActivityManager.broadcastStickyIntent(r0, -1);
        Log.i(LOG_TAG, "sendSmsCallbackModeChange");
    }

    private void handleExitScbm() {
        Registrant r0 = this.mScbmExitRespRegistrant;
        if (r0 == null) goto L5;
        r0.notifyRegistrant();
    L5:
        Log.i(LOG_TAG, "handleExitScbm");
        sendSmsCallbackModeChange();
        setScbmPhoneId(-1);
    }

    public boolean isInScbm() {
        monitor-enter(this);
        boolean r0 = this.mIsPhoneInScbmState;     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public boolean isInScbm(int r2) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.mIsPhoneInScbmState == true) goto L6;
    L8:
        boolean r3 = false;
    L9:
        monitor-exit(this);     // Catch: Throwable -> L11
        return r3;
    L6:
        if (this.mScbmPhoneId != r2) goto L8;
        r3 = true;
        goto L9
    }

    private void setIsInScbm(int r3, boolean r4) {
        SystemProperties.set("ril.inscbm", String.valueOf(r4));
        monitor-enter(this);
        this.mIsPhoneInScbmState = r4;     // Catch: Throwable -> L7
        this.mScbmPhoneId = r3;     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void setScbmPhoneId(int r1) {
        monitor-enter(this);
        this.mScbmPhoneId = r1;     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private int getScbmPhoneId() {
        monitor-enter(this);
        int r0 = this.mScbmPhoneId;     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public static void init(Context r2) {
        if (sScbmHandler == null) goto L6;
        Log.d(LOG_TAG, "Scbm Handler already initialized.");
        return;
    L6:
        sScbmHandler = new ScbmHandler(r2);
        Log.i(LOG_TAG, "init(): ScbmHandler initialized.");
    }

    public static ScbmHandler getInstance() {
        ScbmHandler r0 = sScbmHandler;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new RuntimeException("ScbmHandler was not initialized!");
    }

    public void setOnScbmExitResponse(Handler r2, int r3, Object r4) {
        this.mScbmExitRespRegistrant = new Registrant(r2, r3, r4);
    }

    public void unsetOnScbmExitResponse(Handler r1) {
        this.mScbmExitRespRegistrant.clear();
    }

    private void createQtiImsExtConnector(Context r3) {
        this.mQtiImsExtConnector = new QtiImsExtConnector(r3, new AnonymousClass3(this));     // Catch: QtiImsException -> L4
        return;
    L4:
        Log.e("createQtiImsExtConnector", "Unable to create QtiImsExtConnector");
    }

    public void exitScbm() {
        if (this.mQtiImsExtManager != null) goto L5;
    L12:
        Log.d(LOG_TAG, "mQtiImsExtManager is null or SCBM phoneId invalid.");
        return;
    L5:
        if (getScbmPhoneId() == (-1)) goto L12;
        this.mQtiImsExtManager.exitScbm(getScbmPhoneId(), this.imsInterfaceListener);     // Catch: QtiImsException -> L9
        return;
    L9:
        e = move-exception;
        Log.w(LOG_TAG, "exitScbm exception!" + e);
    }

    public void handleModemReset() {
        if (isInScbm() == false) goto L6;
        setIsInScbm(getScbmPhoneId(), false);
        handleExitScbm();
        return;
    }

    public void registerForScbmTimerReset(Handler r1, int r2, Object r3) {
        this.mScmTimerResetRegistrants.addUnique(r1, r2, r3);
    }

    public void unregisterForScbmTimerReset(Handler r1) {
        this.mScmTimerResetRegistrants.remove(r1);
    }

    public boolean isExitScbmFeatureSupported() {
        monitor-enter(this);
    L20:
        th = move-exception;
        throw th;
    L5:
        if (this.mIsExitScbmFeatureRetrieved == false) goto L9;
        boolean r0 = this.mIsExitScbmFeatureSupported;     // Catch: Throwable -> L20
        monitor-exit(this);     // Catch: Throwable -> L20
        return r0;
    L9:
        monitor-exit(this);     // Catch: Throwable -> L20
        Phone r1 = PhoneFactory.getPhone(getScbmPhoneId());
        if (r1 == null) goto L26;
        QtiImsExtManager r2 = this.mQtiImsExtManager;
        if (r2 == null) goto L27;
        this.mIsExitScbmFeatureSupported = r2.isExitScbmFeatureSupported(r1.getPhoneId());     // Catch: QtiImsException -> L16
        Log.e(LOG_TAG, "isExitScbmFeatureSupported: " + this.mIsExitScbmFeatureSupported);     // Catch: QtiImsException -> L16
        this.mIsExitScbmFeatureRetrieved = true;     // Catch: QtiImsException -> L16
        return this.mIsExitScbmFeatureSupported;
    L16:
        e = move-exception;
        Log.w(LOG_TAG, "isExitScbmFeatureSupported exception!" + e);
        return false;
    L27:
        return false;
    L26:
        return false;
    }

    public boolean isScbmTimerCanceledForEmergency() {
        return this.mScmCanceledForEmergency;
    }

    private void setScbmTimerCanceledForEmergency(boolean r1) {
        this.mScmCanceledForEmergency = r1;
    }
}
