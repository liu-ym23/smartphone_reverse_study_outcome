package com.android.settings.about.status;

import android.content.Context;
import android.telephony.ServiceState;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyDisplayInfo;
import android.telephony.TelephonyManager;
import com.android.settings.SettingsApplication;
import com.android.settingslib.SignalIcon;
import com.android.settingslib.mobile.MobileMappings;
import com.android.settingslib.mobile.dataservice.DataServiceUtils;
import com.bytedance.networkstackapplib.NetworkStackConstant;
import com.obric.olog.OLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SimStatusUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J*\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0016\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u000eJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0012\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/android/settings/about/status/SimStatusUtils;", "", "()V", "TAG", "", "getMappingConfig", "Lcom/android/settingslib/mobile/MobileMappings$Config;", "context", "Landroid/content/Context;", "getMappingNetworkType", "config", "telephonyDisplayInfo", "Landroid/telephony/TelephonyDisplayInfo;", DataServiceUtils.MobileNetworkInfoData.COLUMN_ID, "", "getNetworkTypeName", "telephonyManager", "Landroid/telephony/TelephonyManager;", "slotId", "type", "getPhoneSubscriptionInfo", "Landroid/telephony/SubscriptionInfo;", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SimStatusUtils {
    public static final SimStatusUtils INSTANCE = null;
    public static final String TAG = "SimStatusUtils";

    static {
        INSTANCE = new SimStatusUtils();
    }

    public final String getNetworkTypeName(int r1) {
        switch(r1) {
            case 1: goto L22;
            case 2: goto L21;
            case 3: goto L20;
            case 4: goto L19;
            case 5: goto L18;
            case 6: goto L17;
            case 7: goto L16;
            case 8: goto L15;
            case 9: goto L14;
            case 10: goto L13;
            case 11: goto L12;
            case 12: goto L11;
            case 13: goto L10;
            case 14: goto L9;
            case 15: goto L8;
            case 16: goto L7;
            case 17: goto L6;
            case 18: goto L5;
            case 19: goto L3;
            case 20: goto L4;
            default: goto L3;
        };
    L3:
        return NetworkStackConstant.UNKNOWN_TYPE;
    L4:
        return "5G_SA";
    L5:
        return "IWLAN";
    L6:
        return "TD_SCDMA";
    L7:
        return "GSM";
    L8:
        return "HSPA+";
    L9:
        return "CDMA - eHRPD";
    L10:
        return "LTE";
    L11:
        return "CDMA - EvDo rev. B";
    L12:
        return "iDEN";
    L13:
        return "HSPA";
    L14:
        return "HSUPA";
    L15:
        return "HSDPA";
    L16:
        return "CDMA - 1xRTT";
    L17:
        return "CDMA - EvDo rev. A";
    L18:
        return "CDMA - EvDo rev. 0";
    L19:
        return "CDMA";
    L20:
        return "UMTS";
    L21:
        return "EDGE";
    L22:
        return "GPRS";
    }

    private SimStatusUtils() {
    }

    public final SubscriptionInfo getPhoneSubscriptionInfo(int r1) {
        return SubscriptionManager.from(SettingsApplication.getContext()).getActiveSubscriptionInfoForSimSlotIndex(r1);
    }

    public final String getNetworkTypeName(TelephonyManager r11, int r12) {
        Intrinsics.checkNotNullParameter(r11, "telephonyManager");
        SubscriptionInfo r13 = getPhoneSubscriptionInfo(r12);
        boolean r0 = false;
        if (r13 == null) goto L5;
        int r14 = r13.getSubscriptionId();
        int r1 = r11.getDataNetworkType(r14);
        int r2 = r11.getVoiceNetworkType(r14);
        String r3 = null;
        if (r1 == 0) goto L9;
        String r4 = getNetworkTypeName(r1);
    L10:
        if (r2 == 0) goto L12;
        String r5 = getNetworkTypeName(r2);
    L14:
        if (13 != r2) goto L16;
        boolean r6 = true;
    L17:
        if (13 != r1) goto L19;
        boolean r7 = true;
    L20:
        if (r6 == true) goto L22;
        if (r7 == true) goto L22;
    L43:
        OLog.d(TAG, "getNetworkTypeName: dataNetworkTypeName = " + r4 + ", voiceNetworkTypeName = " + r5);
        if (r4 != null) goto L49;
        if (r5 != null) goto L48;
        return "";
    L48:
        return r5;
    L49:
        return r4;
    L22:
        Context r8 = SettingsApplication.getContext();
        Intrinsics.checkNotNullExpressionValue(r8, "getContext(...)");
        MobileMappings.Config r10 = getMappingConfig(r8);
        if (r11.getServiceState() == null) goto L31;
        ServiceState r15 = r11.getServiceState();
        if (r15 != null) goto L27;
    L29:
        int r16 = 0;
    L30:
        TelephonyDisplayInfo r9 = new TelephonyDisplayInfo(13, r16);
    L32:
        if (r9 == null) goto L34;
        SimStatusUtils r17 = INSTANCE;
        Context r18 = SettingsApplication.getContext();
        Intrinsics.checkNotNullExpressionValue(r18, "getContext(...)");
        r3 = r17.getMappingNetworkType(r18, r10, r9, r14);
    L34:
        if (r3 == null) goto L43;
        if (r3.length() != 0) goto L38;
        r0 = true;
    L38:
        if (r0 == true) goto L43;
        if (r6 == false) goto L41;
        r5 = r3;
    L41:
        if (r7 == false) goto L43;
        r4 = r3;
        goto L43
    L27:
        if (r15.isUsingCarrierAggregation() != true) goto L29;
        r16 = 1;
        goto L30
    L31:
        r9 = null;
        goto L32
    L19:
        r7 = false;
        goto L20
    L16:
        r6 = false;
        goto L17
    L12:
        r5 = null;
        goto L14
    L9:
        r4 = null;
        goto L10
    L5:
        return getNetworkTypeName(0);
    }

    private final String getMappingNetworkType(Context r1, MobileMappings.Config r2, TelephonyDisplayInfo r3, int r4) {
        String r0 = MobileMappings.getIconKey(r3);
        SignalIcon.MobileIconGroup r5 = MobileMappings.mapIconSets(r2).get(r0);
        if (r5 != null) goto L7;
        OLog.d(TAG, "Can not get the network's icon and description.");
        return null;
    L7:
        return MobileIconGroupExtKt.getSummaryForSub(r5, r1, r4);
    }

    private final MobileMappings.Config getMappingConfig(Context r1) {
        MobileMappings.Config r0 = MobileMappings.Config.readConfig(r1);
        Intrinsics.checkNotNullExpressionValue(r0, "readConfig(...)");
        return r0;
    }
}
