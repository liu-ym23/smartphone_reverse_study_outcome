package com.android.settings.about.status;

import android.os.Bundle;
import android.os.Parcelable;
import android.telephony.PhoneNumberUtils;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.MutableLiveData;
import com.android.settings.MultiSimAdapter;
import com.android.settings.R;
import com.android.settings.SettingsApplication;
import com.android.settings.deviceinfo.DeviceInfoProvider;
import com.android.settings.utils.ResourceUtils;
import com.android.settings.utils.SLog;
import com.obric.olog.OLog;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: SimStatusHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000m\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0003\n\u000f\u0012\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u00105\u001a\u00020\u00042\b\b\u0002\u00106\u001a\u00020\u0015H\u0002J\b\u00107\u001a\u00020\u0004H\u0002J\u0014\u00108\u001a\u0004\u0018\u00010\u00042\b\u00109\u001a\u0004\u0018\u00010:H\u0003J\u0012\u0010;\u001a\u00020\u00042\b\u00109\u001a\u0004\u0018\u00010:H\u0002J\u0017\u0010<\u001a\u00020\u00042\b\u0010=\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0002\u0010>J\u0014\u0010?\u001a\u0004\u0018\u00010\u00042\b\u0010@\u001a\u0004\u0018\u00010AH\u0002J\u0016\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020\u00152\u0006\u0010E\u001a\u00020FJ\u0012\u0010G\u001a\u00020C2\b\u00109\u001a\u0004\u0018\u00010:H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u0019\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u0010\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001c\u0010\u001dR\u000e\u0010 \u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010$\u001a\u00020%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010\u001f\u001a\u0004\b&\u0010'R\u0019\u0010)\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0006¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\bR\u0019\u0010+\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0006¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\bR\u0019\u0010-\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0006¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\bR\u0019\u0010/\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0006¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\bR\u0019\u00101\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0006¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\bR\u0019\u00103\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0006¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\b¨\u0006H"}, d2 = {"Lcom/android/settings/about/status/SimStatusHelper;", "", "()V", "TAG", "", "dataStateLv", "Landroidx/lifecycle/MutableLiveData;", "getDataStateLv", "()Landroidx/lifecycle/MutableLiveData;", "mNetWorkReceiver", "com/android/settings/about/status/SimStatusHelper$mNetWorkReceiver$1", "Lcom/android/settings/about/status/SimStatusHelper$mNetWorkReceiver$1;", "mPhoneInfo", "Landroid/os/Bundle;", "mPhoneStateListener", "com/android/settings/about/status/SimStatusHelper$mPhoneStateListener$1", "Lcom/android/settings/about/status/SimStatusHelper$mPhoneStateListener$1;", "mSimStateChangeReceiver", "com/android/settings/about/status/SimStatusHelper$mSimStateChangeReceiver$1", "Lcom/android/settings/about/status/SimStatusHelper$mSimStateChangeReceiver$1;", "mSlotId", "", "getMSlotId", "()I", "setMSlotId", "(I)V", "mSubManager", "Landroid/telephony/SubscriptionManager;", "getMSubManager", "()Landroid/telephony/SubscriptionManager;", "mSubManager$delegate", "Lkotlin/Lazy;", "mSubscription", "mSummary4G", "mSupport5G", "", "mTelephonyManager", "Landroid/telephony/TelephonyManager;", "getMTelephonyManager", "()Landroid/telephony/TelephonyManager;", "mTelephonyManager$delegate", "networkTypeLv", "getNetworkTypeLv", "numberLv", "getNumberLv", "operatorNameLv", "getOperatorNameLv", "roamingStateLv", "getRoamingStateLv", "serviceStateLv", "getServiceStateLv", "signalStrengthLv", "getSignalStrengthLv", "getDateState", "inState", "getNumber", "getOperatorName", "serviceState", "Landroid/telephony/ServiceState;", "getRoamingState", "getServiceStateString", "state", "(Ljava/lang/Integer;)Ljava/lang/String;", "getSignalStrength", "signalStrength", "Landroid/telephony/SignalStrength;", "init", "", "slotId", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "updateNetworkType", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SimStatusHelper {
    private final String TAG;
    private final MutableLiveData<String> dataStateLv;
    private final SimStatusHelper$mNetWorkReceiver$1 mNetWorkReceiver;
    private Bundle mPhoneInfo;
    private final SimStatusHelper$mPhoneStateListener$1 mPhoneStateListener;
    private final SimStatusHelper$mSimStateChangeReceiver$1 mSimStateChangeReceiver;
    private int mSlotId;
    private final Lazy mSubManager$delegate;
    private int mSubscription;
    private String mSummary4G;
    private boolean mSupport5G;
    private final Lazy mTelephonyManager$delegate;
    private final MutableLiveData<String> networkTypeLv;
    private final MutableLiveData<String> numberLv;
    private final MutableLiveData<String> operatorNameLv;
    private final MutableLiveData<String> roamingStateLv;
    private final MutableLiveData<String> serviceStateLv;
    private final MutableLiveData<String> signalStrengthLv;

    /* JADX WARN: Type inference failed for: r0v14, types: [com.android.settings.about.status.SimStatusHelper$mPhoneStateListener$1] */
    /* JADX WARN: Type inference failed for: r0v15, types: [com.android.settings.about.status.SimStatusHelper$mSimStateChangeReceiver$1] */
    /* JADX WARN: Type inference failed for: r0v17, types: [com.android.settings.about.status.SimStatusHelper$mNetWorkReceiver$1] */
    public SimStatusHelper() {
        this.TAG = "SimStatusHelper";
        this.mTelephonyManager$delegate = LazyKt.lazy(SimStatusHelper$mTelephonyManager$2.INSTANCE);
        this.mSubManager$delegate = LazyKt.lazy(SimStatusHelper$mSubManager$2.INSTANCE);
        this.operatorNameLv = new MutableLiveData();
        this.signalStrengthLv = new MutableLiveData();
        this.networkTypeLv = new MutableLiveData();
        this.serviceStateLv = new MutableLiveData();
        this.roamingStateLv = new MutableLiveData();
        this.dataStateLv = new MutableLiveData();
        this.numberLv = new MutableLiveData();
        this.mPhoneStateListener = new SimStatusHelper$mPhoneStateListener$1(this);
        this.mSimStateChangeReceiver = new SimStatusHelper$mSimStateChangeReceiver$1(this);
        this.mSummary4G = "";
        this.mNetWorkReceiver = new SimStatusHelper$mNetWorkReceiver$1(this);
    }

    public static final /* synthetic */ String access$getDateState(SimStatusHelper r0, int r1) {
        return r0.getDateState(r1);
    }

    public static final /* synthetic */ SimStatusHelper$mNetWorkReceiver$1 access$getMNetWorkReceiver$p(SimStatusHelper r0) {
        return r0.mNetWorkReceiver;
    }

    public static final /* synthetic */ Bundle access$getMPhoneInfo$p(SimStatusHelper r0) {
        return r0.mPhoneInfo;
    }

    public static final /* synthetic */ SimStatusHelper$mPhoneStateListener$1 access$getMPhoneStateListener$p(SimStatusHelper r0) {
        return r0.mPhoneStateListener;
    }

    public static final /* synthetic */ SimStatusHelper$mSimStateChangeReceiver$1 access$getMSimStateChangeReceiver$p(SimStatusHelper r0) {
        return r0.mSimStateChangeReceiver;
    }

    public static final /* synthetic */ int access$getMSubscription$p(SimStatusHelper r0) {
        return r0.mSubscription;
    }

    public static final /* synthetic */ String access$getMSummary4G$p(SimStatusHelper r0) {
        return r0.mSummary4G;
    }

    public static final /* synthetic */ TelephonyManager access$getMTelephonyManager(SimStatusHelper r0) {
        return r0.getMTelephonyManager();
    }

    public static final /* synthetic */ String access$getNumber(SimStatusHelper r0) {
        return r0.getNumber();
    }

    public static final /* synthetic */ String access$getOperatorName(SimStatusHelper r0, ServiceState r1) {
        return r0.getOperatorName(r1);
    }

    public static final /* synthetic */ String access$getRoamingState(SimStatusHelper r0, ServiceState r1) {
        return r0.getRoamingState(r1);
    }

    public static final /* synthetic */ String access$getServiceStateString(SimStatusHelper r0, Integer r1) {
        return r0.getServiceStateString(r1);
    }

    public static final /* synthetic */ String access$getSignalStrength(SimStatusHelper r0, SignalStrength r1) {
        return r0.getSignalStrength(r1);
    }

    public static final /* synthetic */ void access$setMPhoneInfo$p(SimStatusHelper r0, Bundle r1) {
        r0.mPhoneInfo = r1;
    }

    public static final /* synthetic */ void access$setMSupport5G$p(SimStatusHelper r0, boolean r1) {
        r0.mSupport5G = r1;
    }

    public static final /* synthetic */ void access$updateNetworkType(SimStatusHelper r0, ServiceState r1) {
        r0.updateNetworkType(r1);
    }

    public final int getMSlotId() {
        return this.mSlotId;
    }

    public final void setMSlotId(int r1) {
        this.mSlotId = r1;
    }

    private final TelephonyManager getMTelephonyManager() {
        return (TelephonyManager) this.mTelephonyManager$delegate.getValue();
    }

    private final SubscriptionManager getMSubManager() {
        return (SubscriptionManager) this.mSubManager$delegate.getValue();
    }

    public final MutableLiveData<String> getOperatorNameLv() {
        return this.operatorNameLv;
    }

    public final MutableLiveData<String> getSignalStrengthLv() {
        return this.signalStrengthLv;
    }

    public final MutableLiveData<String> getNetworkTypeLv() {
        return this.networkTypeLv;
    }

    public final MutableLiveData<String> getServiceStateLv() {
        return this.serviceStateLv;
    }

    public final MutableLiveData<String> getRoamingStateLv() {
        return this.roamingStateLv;
    }

    public final MutableLiveData<String> getDataStateLv() {
        return this.dataStateLv;
    }

    public final MutableLiveData<String> getNumberLv() {
        return this.numberLv;
    }

    public final void init(final int r6, Lifecycle r7) {
        Intrinsics.checkNotNullParameter(r7, "lifecycle");
        this.mPhoneInfo = SettingsApplication.getContext().getContentResolver().call(DeviceInfoProvider.DEVICE_INFO_PROVIDER_AUTHORITY, DeviceInfoProvider.GET_PHONE_INFO, String.valueOf(r6), null);
        this.mSlotId = r6;
        this.mSubscription = MultiSimAdapter.slot2Sub(r6);
        r7.addObserver(new AnonymousClass1(r6, this));
    }

    private final String getOperatorName(ServiceState r1) {
        if (r1 != null) goto L6;
        return null;
    L6:
        return r1.getOperatorAlphaLong();
    }

    private final String getSignalStrength(SignalStrength r7) {
        SubscriptionManager r0 = SubscriptionManager.from(SettingsApplication.getContext());
        ServiceState r1 = null;
        if (r0 == null) goto L5;
        List<SubscriptionInfo> r2 = r0.getActiveSubscriptionInfoList();
    L6:
        List<SubscriptionInfo> r3 = r2;
        if (r3 != null) goto L9;
    L12:
        boolean r4 = true;
    L14:
        if (r4 == true) goto L16;
        if (r7 == null) goto L19;
        Bundle r6 = this.mPhoneInfo;
        if (r6 == null) goto L44;
        Parcelable r8 = r6.getParcelable(DeviceInfoProvider.SERVICE_STATE);
        if ((r8 instanceof ServiceState) == false) goto L25;
        r1 = (ServiceState) r8;
    L25:
        if (r1 == null) goto L27;
        int r9 = r1.getState();
        if (1 != r9) goto L31;
        return "0";
    L31:
        if (3 == r9) goto L45;
        int r10 = r7.getDbm();
        if (r10 != (-1)) goto L36;
        r10 = 0;
    L36:
        int r11 = r7.getAsuLevel();
        if (r11 != (-1)) goto L39;
        r11 = 0;
    L39:
        StringCompanionObject r5 = StringCompanionObject.INSTANCE;
        String r12 = String.format(Locale.getDefault(), "%d %s %d %s", Arrays.copyOf(new Object[]{Integer.valueOf(r10), ResourceUtils.getString(R.string.radioInfo_display_dbm), Integer.valueOf(r11), ResourceUtils.getString(R.string.radioInfo_display_asu)}, 4));
        Intrinsics.checkNotNullExpressionValue(r12, "format(...)");
        return r12;
    L45:
        return "0";
    L27:
        return ResourceUtils.getString(R.string.status_unavailable);
    L44:
        return ResourceUtils.getString(R.string.status_unavailable);
    L19:
        return ResourceUtils.getString(R.string.status_unavailable);
    L16:
        return ResourceUtils.getString(R.string.status_unavailable);
    L9:
        if (r3.isEmpty() == true) goto L12;
        r4 = false;
        goto L14
    L5:
        r2 = null;
        goto L6
    }

    private final void updateNetworkType(ServiceState r3) {
        OLog.d(this.TAG, "updateNetworkType: ");
        this.networkTypeLv.postValue(SimStatusUtils.INSTANCE.getNetworkTypeName(getMTelephonyManager(), this.mSlotId));
    }

    private final String getServiceStateString(Integer r3) {
        if (r3 != null) goto L5;
    L7:
        boolean r2 = true;
        if (r3 != null) goto L11;
    L13:
        if (r3 != null) goto L16;
    L18:
        r2 = false;
    L19:
        if (r2 == true) goto L29;
        if (r3 == null) goto L27;
        if (r3.intValue() != 3) goto L27;
        return ResourceUtils.getString(R.string.radioInfo_service_off);
    L27:
        return ResourceUtils.getString(R.string.radioInfo_unknown);
    L29:
        return ResourceUtils.getString(R.string.radioInfo_service_out);
    L16:
        if (r3.intValue() != 2) goto L18;
    L11:
        if (r3.intValue() != 1) goto L13;
    L5:
        if (r3.intValue() != 0) goto L7;
        return ResourceUtils.getString(R.string.radioInfo_service_in);
    }

    static /* synthetic */ String getDateState$default(SimStatusHelper r0, int r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = -1;
    L6:
        return r0.getDateState(r1);
    }

    private final String getDateState(int r4) {
        if (this.mSubscription == SubscriptionManager.getDefaultDataSubscriptionId()) goto L6;
        return ResourceUtils.getString(R.string.radioInfo_data_disconnected);
    L6:
        if (r4 != (-1)) goto L8;
        r4 = getMTelephonyManager().getDataState();
    L8:
        if (r4 == 0) goto L20;
        if (r4 == 1) goto L25;
        if (r4 == 2) goto L24;
        if (r4 == 3) goto L23;
        return ResourceUtils.getString(R.string.radioInfo_unknown);
    L23:
        return ResourceUtils.getString(R.string.radioInfo_data_suspended);
    L24:
        return ResourceUtils.getString(R.string.radioInfo_data_connected);
    L25:
        return ResourceUtils.getString(R.string.radioInfo_data_connecting);
    L20:
        return ResourceUtils.getString(R.string.radioInfo_data_disconnected);
    }

    private final String getNumber() {
        Bundle r0 = this.mPhoneInfo;
        String r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.getString(DeviceInfoProvider.LINE_1_NUMBER);
    L6:
        String r4 = this.TAG;
        StringBuilder r3 = new StringBuilder("getNumber: xxx");
        if (r2 == null) goto L9;
        r1 = StringsKt.takeLast(r2, 2);
    L9:
        SLog.d(r4, r3.append(r1).toString());
        String r5 = r2;
        if (r5 != null) goto L12;
    L15:
        boolean r6 = true;
    L16:
        if (r6 == true) goto L20;
        String r7 = PhoneNumberUtils.formatNumber(r2);
        Intrinsics.checkNotNull(r7);
        return r7;
    L20:
        return ResourceUtils.getString(R.string.unknown_number);
    L12:
        if (r5.length() == 0) goto L15;
        r6 = false;
        goto L16
    L5:
        r2 = null;
        goto L6
    }

    private final String getRoamingState(ServiceState r2) {
        boolean r1 = false;
        if (r2 != null) goto L5;
    L7:
        if (r1 == false) goto L10;
        return ResourceUtils.getString(R.string.radioInfo_roaming_in);
    L10:
        return ResourceUtils.getString(R.string.radioInfo_roaming_not);
    L5:
        if (r2.getRoaming() != true) goto L7;
        r1 = true;
        goto L7
    }
}
