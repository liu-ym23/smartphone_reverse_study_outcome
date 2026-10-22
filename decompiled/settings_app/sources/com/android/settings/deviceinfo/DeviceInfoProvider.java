package com.android.settings.deviceinfo;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemProperties;
import android.text.TextUtils;
import com.android.internal.telephony.Phone;
import com.android.internal.telephony.PhoneFactory;
import com.android.settings.MultiSimAdapter;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import org.codeaurora.internal.Client;
import org.codeaurora.internal.INetworkCallback;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceInfoProvider extends ContentProvider {
    public static final String ACTION_ON_NR_ICON_TYPE = "com.android.settings.deviceinfo.deviceinfoprovider.action.onNrIconType";
    public static final String CDMA_MIN = "cdma_min";
    public static final String CDMA_PRL_VERSION = "cdma_prl_version";
    public static final String CLIENT = "client";
    public static final String DEVICE_ID = "device_id";
    public static final String DEVICE_INFO_PROVIDER_AUTHORITY = "com.android.settings.deviceinfo.deviceinfoprovider";
    public static final String GET_DATA_USAGE = "getDataUsage";
    public static final String GET_PHONE_INFO = "getPhoneInfo";
    public static final String GET_PHONE_NUM = "getPhoneNum";
    public static final String ICC_SERIAL_NUMBER = "icc_serial_number";
    public static final String IMEI = "imei";
    public static final String LINE_1_NUMBER = "line_1_number";
    public static final String LTE_ON_CDMA_MODE = "lte_on_cdma_mode";
    public static final String MEID = "meid";
    public static final String NR_ICON_TYPE = "nr_icon_type";
    public static final String PHONE_NAME = "phone_name";
    public static final String REGISTER_5G_STATUS = "register5gStatus";
    public static final String SERVICE_STATE = "service_state";
    public static final String SET_SIM_SUBSCRIPTION_FOR_DATA = "setSIMSubscriptionForDATA";
    public static final String SET_SIM_SUBSCRIPTION_FOR_DIAL = "setSIMSubscriptionForDIAL";
    public static final String SET_SIM_SUBSCRIPTION_FOR_SMS = "setSIMSubscriptionForSMS";
    public static final String SIGNAL_STRENGTH = "signal_strength";
    public static final String SLOT_ID = "slot_id";
    private Client mClient;
    private Context mContext;
    private INetworkCallback mNetWorkCallback;
    MSimInfoHelper mSimInfoHelper;

    public void com_android_settings_deviceinfo_DeviceInfoProvider__onCreate$___twin___() {
        super.onCreate();
    }

    @Override // android.content.ContentProvider
    public int delete(Uri r1, String r2, String[] r3) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r1) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r1, ContentValues r2) {
        return null;
    }

    @Override // android.content.ContentProvider
    public void onCreate() {
        com_android_settings_deviceinfo_DeviceInfoProvider_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Provider(this);
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r1, String[] r2, String r3, String[] r4, String r5) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri r1, ContentValues r2, String r3, String[] r4) {
        return 0;
    }

    public DeviceInfoProvider() {
        this.mSimInfoHelper = null;
        this.mNetWorkCallback = new AnonymousClass1(this);
    }

    static /* synthetic */ Context access$000(DeviceInfoProvider r0) {
        return r0.mContext;
    }

    @Override // android.content.ContentProvider
    public Bundle call(String r4, String r5, Bundle r6) {
        if (GET_PHONE_NUM.equals(r4) == false) goto L9;
        Bundle r7 = new Bundle();
        if (this.mSimInfoHelper != null) goto L7;
        this.mSimInfoHelper = new MSimInfoHelper(getContext());
    L7:
        r7.putString(String.valueOf(0), this.mSimInfoHelper.getPhoneNumber(0));
        r7.putString(String.valueOf(1), this.mSimInfoHelper.getPhoneNumber(1));
        return r7;
    L9:
        if (GET_PHONE_INFO.equals(r4) == false) goto L19;
        int r3 = MultiSimAdapter.getDefaultSlot();
        if (TextUtils.isEmpty(r5) == true) goto L15;
        r3 = Integer.parseInt(r5);
        if (r3 >= 0) goto L15;
        r3 = MultiSimAdapter.getDefaultSlot();
    L15:
        Phone r8 = PhoneFactory.getPhone(r3);
        if (r8 == null) goto L43;
        Bundle r9 = new Bundle();
        r9.putString(PHONE_NAME, r8.getPhoneName());
        r9.putInt(LTE_ON_CDMA_MODE, 0);
        r9.putString("device_id", r8.getDeviceId());
        r9.putString(IMEI, r8.getImei());
        r9.putString(MEID, r8.getMeid());
        r9.putString(CDMA_MIN, r8.getCdmaMin());
        r9.putString(CDMA_PRL_VERSION, r8.getCdmaPrlVersion());
        r9.putString(ICC_SERIAL_NUMBER, r8.getIccSerialNumber());
        r9.putString(LINE_1_NUMBER, r8.getLine1Number());
        r9.putParcelable(SIGNAL_STRENGTH, r8.getSignalStrength());
        r9.putParcelable(SERVICE_STATE, r8.getServiceState());
        return r9;
    L43:
        return null;
    L19:
        if (REGISTER_5G_STATUS.equals(r4) == false) goto L22;
        return new Bundle();
    L22:
        if (GET_DATA_USAGE.equals(r4) == false) goto L28;
        Bundle r10 = new Bundle();
        if (this.mSimInfoHelper != null) goto L26;
        this.mSimInfoHelper = new MSimInfoHelper(getContext());
    L26:
        String r11 = this.mSimInfoHelper.getDataUsage(0);
        String r12 = this.mSimInfoHelper.getDataUsage(1);
        r10.putString(String.valueOf(0), r11);
        r10.putString(String.valueOf(1), r12);
        return r10;
    L28:
        if (SET_SIM_SUBSCRIPTION_FOR_DATA.equals(r4) == false) goto L33;
        if (TextUtils.isEmpty(r5) == true) goto L43;
        SystemProperties.set("persist.radio.user.data.sub", r5);
        goto L43
    L33:
        if (SET_SIM_SUBSCRIPTION_FOR_SMS.equals(r4) == false) goto L38;
        if (TextUtils.isEmpty(r5) == true) goto L43;
        SystemProperties.set("persist.radio.user.sms.sub", r5);
        goto L43
    L38:
        if (SET_SIM_SUBSCRIPTION_FOR_DIAL.equals(r4) == false) goto L43;
        if (TextUtils.isEmpty(r5) == true) goto L43;
        SystemProperties.set("persist.radio.user.voice.sub", r5);
        goto L43
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        this.mContext = getContext();
        return false;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.content.ContentProvider")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_deviceinfo_DeviceInfoProvider_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Provider(DeviceInfoProvider r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_deviceinfo_DeviceInfoProvider__onCreate$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportColdStartProvider(r0);
    L5:
        AppMetricsUtils.INSTANCE.setColdStartTime(0);
    }
}
