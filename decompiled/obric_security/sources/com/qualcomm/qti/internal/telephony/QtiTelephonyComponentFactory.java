package com.qualcomm.qti.internal.telephony;

import android.content.Context;
import android.net.NetworkAgentConfig;
import android.net.NetworkProvider;
import android.net.NetworkScore;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.telephony.Rlog;
import android.util.SparseArray;
import com.android.internal.telephony.CarrierInfoManager;
import com.android.internal.telephony.CommandsInterface;
import com.android.internal.telephony.GsmCdmaCallTracker;
import com.android.internal.telephony.GsmCdmaPhone;
import com.android.internal.telephony.IccPhoneBookInterfaceManager;
import com.android.internal.telephony.InboundSmsTracker;
import com.android.internal.telephony.Phone;
import com.android.internal.telephony.PhoneFactory;
import com.android.internal.telephony.PhoneNotifier;
import com.android.internal.telephony.RIL;
import com.android.internal.telephony.ServiceStateTracker;
import com.android.internal.telephony.SmsDispatchersController;
import com.android.internal.telephony.SmsStorageMonitor;
import com.android.internal.telephony.SmsUsageMonitor;
import com.android.internal.telephony.SubscriptionController;
import com.android.internal.telephony.SubscriptionInfoUpdater;
import com.android.internal.telephony.TelephonyComponentFactory;
import com.android.internal.telephony.WspTypeDecoder;
import com.android.internal.telephony.cdma.CdmaSubscriptionSourceManager;
import com.android.internal.telephony.cdma.EriManager;
import com.android.internal.telephony.data.DataConfigManager;
import com.android.internal.telephony.data.DataNetwork;
import com.android.internal.telephony.data.DataNetworkController;
import com.android.internal.telephony.data.DataProfileManager;
import com.android.internal.telephony.data.DataRetryManager;
import com.android.internal.telephony.data.DataServiceManager;
import com.android.internal.telephony.data.DataSettingsManager;
import com.android.internal.telephony.data.PhoneSwitcher;
import com.android.internal.telephony.data.TelephonyNetworkAgent;
import com.android.internal.telephony.dataconnection.DcTracker;
import com.android.internal.telephony.imsphone.ImsPhone;
import com.android.internal.telephony.imsphone.ImsPhoneCallTracker;
import com.qualcomm.qti.internal.nrNetworkService.MainServiceImpl;
import com.qualcomm.qti.internal.telephony.data.QtiDataConfigManager;
import com.qualcomm.qti.internal.telephony.data.QtiDataNetworkController;
import com.qualcomm.qti.internal.telephony.data.QtiDataProfileManager;
import com.qualcomm.qti.internal.telephony.data.QtiDataRetryManager;
import com.qualcomm.qti.internal.telephony.data.QtiDataServiceManager;
import com.qualcomm.qti.internal.telephony.data.QtiDataSettingsManager;
import com.qualcomm.qti.internal.telephony.data.QtiTelephonyNetworkAgent;
import com.qualcomm.qti.internal.telephony.dataconnection.QtiDcTracker;

/* JADX INFO: loaded from: classes4.dex */
public class QtiTelephonyComponentFactory extends TelephonyComponentFactory {
    private static String LOG_TAG = "QtiTelephonyComponentFactory";
    private static QtiTelephonyComponentFactory sInstance;
    private QtiRIL[] mRil;

    static {
    }

    public QtiTelephonyComponentFactory() {
        this.mRil = new QtiRIL[]{null, null};
        sInstance = this;
    }

    public static QtiTelephonyComponentFactory getInstance() {
        return sInstance;
    }

    public GsmCdmaCallTracker makeGsmCdmaCallTracker(GsmCdmaPhone r3) {
        Rlog.d(LOG_TAG, "makeGsmCdmaCallTracker");
        return super.makeGsmCdmaCallTracker(r3);
    }

    public SmsStorageMonitor makeSmsStorageMonitor(Phone r3) {
        Rlog.d(LOG_TAG, "makeSmsStorageMonitor");
        return super.makeSmsStorageMonitor(r3);
    }

    public SmsUsageMonitor makeSmsUsageMonitor(Context r3) {
        Rlog.d(LOG_TAG, "makeSmsUsageMonitor");
        return super.makeSmsUsageMonitor(r3);
    }

    public ServiceStateTracker makeServiceStateTracker(GsmCdmaPhone r2, CommandsInterface r3) {
        Rlog.d(LOG_TAG, "makeQtiServiceStateTracker");
        return new QtiServiceStateTracker(r2, r3);
    }

    public DcTracker makeDcTracker(Phone r2, int r3) {
        Rlog.d(LOG_TAG, "makeQtiDcTracker");
        return new QtiDcTracker(r2, r3);
    }

    public IccPhoneBookInterfaceManager makeIccPhoneBookInterfaceManager(Phone r3) {
        if (r3 != null) goto L4;
    L7:
        Rlog.d(LOG_TAG, "makeQtiIccPhoneBookInterfaceManager");
        return new QtiIccPhoneBookInterfaceManager(r3);
    L4:
        if (r3.getHalVersion().greaterOrEqual(RIL.RADIO_HAL_VERSION_1_6) == false) goto L7;
        Rlog.d(LOG_TAG, "makeIccPhoneBookInterfaceManager");
        return super.makeIccPhoneBookInterfaceManager(r3);
    }

    public SmsDispatchersController makeSmsDispatchersController(Phone r3) {
        Rlog.d(LOG_TAG, "makeQtiSmsDispatchersController");
        return new QtiSmsDispatchersController(r3, r3.mSmsStorageMonitor, r3.mSmsUsageMonitor);
    }

    public EriManager makeEriManager(Phone r3, int r4) {
        Rlog.d(LOG_TAG, "makeEriManager");
        return super.makeEriManager(r3, r4);
    }

    public WspTypeDecoder makeWspTypeDecoder(byte[] r3) {
        Rlog.d(LOG_TAG, "makeWspTypeDecoder");
        return super.makeWspTypeDecoder(r3);
    }

    public InboundSmsTracker makeInboundSmsTracker(Context r3, byte[] r4, long r5, int r7, boolean r8, boolean r9, String r10, String r11, String r12, boolean r13, int r14, int r15) {
        Rlog.d(LOG_TAG, "makeInboundSmsTracker");
        return super.makeInboundSmsTracker(r3, r4, r5, r7, r8, r9, r10, r11, r12, r13, r14, r15);
    }

    public InboundSmsTracker makeInboundSmsTracker(Context r3, byte[] r4, long r5, int r7, boolean r8, String r9, String r10, int r11, int r12, int r13, boolean r14, String r15, boolean r16, int r17, int r18) {
        Rlog.d(LOG_TAG, "makeInboundSmsTracker");
        return super.makeInboundSmsTracker(r3, r4, r5, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18);
    }

    public ImsPhoneCallTracker makeImsPhoneCallTracker(ImsPhone r3) {
        Rlog.d(LOG_TAG, "makeImsPhoneCallTracker");
        return super.makeImsPhoneCallTracker(r3);
    }

    public CdmaSubscriptionSourceManager getCdmaSubscriptionSourceManagerInstance(Context r3, CommandsInterface r4, Handler r5, int r6, Object r7) {
        Rlog.d(LOG_TAG, "getCdmaSubscriptionSourceManagerInstance");
        return super.getCdmaSubscriptionSourceManagerInstance(r3, r4, r5, r6, r7);
    }

    public Phone makePhone(Context r9, CommandsInterface r10, PhoneNotifier r11, int r12, int r13, TelephonyComponentFactory r14) {
        Rlog.d(LOG_TAG, "makePhone");
        return new QtiGsmCdmaPhone(r9, r10, r11, r12, r13, r14);
    }

    public SubscriptionController initSubscriptionController(Context r2) {
        Rlog.d(LOG_TAG, "initSubscriptionController");
        return QtiSubscriptionController.init(r2);
    }

    public SubscriptionInfoUpdater makeSubscriptionInfoUpdater(Looper r3, Context r4, SubscriptionController r5) {
        Rlog.d(LOG_TAG, "makeSubscriptionInfoUpdater");
        if (PhoneFactory.getPhone(0).getHalVersion().less(RIL.RADIO_HAL_VERSION_1_5) == false) goto L7;
        return QtiSubscriptionInfoUpdater.init(r3, r4, r5);
    L7:
        return super.makeSubscriptionInfoUpdater(r3, r4, r5);
    }

    public void makeExtTelephonyClasses(Context r3, Phone[] r4, CommandsInterface[] r5) {
        Rlog.d(LOG_TAG, " makeExtTelephonyClasses ");
        String r2 = Settings.Global.getString(r3.getContentResolver(), "settings_network_and_internet_v2");
        if (r2 != null) goto L5;
    L6:
        Settings.Global.putString(r3.getContentResolver(), "settings_network_and_internet_v2", "false");
    L7:
        QtiPhoneUtils.init(r3);
        if (r4[0].getHalVersion().less(RIL.RADIO_HAL_VERSION_1_5) == false) goto L10;
        QtiUiccCardProvisioner.make(r3, r5);
    L10:
        ScbmHandler.init(r3);
        MainServiceImpl.init(r3);     // Catch: NoClassDefFoundError -> L13
        ExtTelephonyServiceImpl.init(r3);     // Catch: NoClassDefFoundError -> L13
        return;
    L13:
        e = move-exception;
        e.printStackTrace();
        Rlog.e(LOG_TAG, "Error creating ExtTelephonyServiceImpl");
        return;
    L5:
        if (r2.equals("false") == true) goto L7;
        goto L6
    }

    public PhoneSwitcher makePhoneSwitcher(int r2, Context r3, Looper r4) {
        Rlog.d(LOG_TAG, "makeQtiPhoneSwitcher");
        return QtiPhoneSwitcher.make(r2, r3, r4);
    }

    public RIL makeRIL(Context r4, int r5, int r6, Integer r7) {
        Rlog.d(LOG_TAG, "makeQtiRIL");
        int r0 = r7.intValue();
        QtiRIL[] r1 = this.mRil;
        if (r0 >= r1.length) goto L7;
        r1[r7.intValue()] = new QtiRIL(r4, r5, r6, r7);
        return this.mRil[r7.intValue()];
    L7:
        throw new RuntimeException("RilInstance = " + r7 + " not allowed!");
    }

    public CarrierInfoManager makeCarrierInfoManager(Phone r2) {
        Rlog.d(LOG_TAG, "makeCarrierInfoManager");
        return new QtiCarrierInfoManager(r2);
    }

    public DataNetworkController makeDataNetworkController(Phone r1, Looper r2) {
        return new QtiDataNetworkController(r1, r2);
    }

    public DataServiceManager makeDataServiceManager(Phone r2, Looper r3, int r4) {
        Rlog.d(LOG_TAG, "makeDataServiceManager");
        return new QtiDataServiceManager(r2, r3, r4);
    }

    public DataConfigManager makeDataConfigManager(Phone r1, Looper r2) {
        return new QtiDataConfigManager(r1, r2);
    }

    public DataProfileManager makeDataProfileManager(Phone r7, DataNetworkController r8, DataServiceManager r9, Looper r10, DataProfileManager.DataProfileManagerCallback r11) {
        return new QtiDataProfileManager(r7, r8, r9, r10, r11);
    }

    public DataRetryManager makeDataRetryManager(Phone r7, DataNetworkController r8, SparseArray<DataServiceManager> r9, Looper r10, DataRetryManager.DataRetryManagerCallback r11) {
        return new QtiDataRetryManager(r7, r8, r9, r10, r11);
    }

    public TelephonyNetworkAgent makeTelephonyNetworkAgent(Phone r9, Looper r10, DataNetwork r11, NetworkScore r12, NetworkAgentConfig r13, NetworkProvider r14, TelephonyNetworkAgent.TelephonyNetworkAgentCallback r15) {
        return new QtiTelephonyNetworkAgent(r9, r10, r11, r12, r13, r14, r15);
    }

    public DataSettingsManager makeDataSettingsManager(Phone r1, DataNetworkController r2, Looper r3, DataSettingsManager.DataSettingsManagerCallback r4) {
        return new QtiDataSettingsManager(r1, r2, r3, r4);
    }

    public QtiRIL getRil(int r2) {
        QtiRIL[] r1 = this.mRil;
        if (r2 < r1.length) goto L5;
        return null;
    L5:
        return r1[r2];
    }
}
