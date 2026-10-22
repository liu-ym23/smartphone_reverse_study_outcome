package com.android.settings.sim;

import android.content.Context;
import android.os.ServiceManager;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.android.settings.MultiSimAdapter;
import com.android.settings.MultiSimSelectSubscription;
import com.obric.olog.OLog;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import org.codeaurora.internal.IExtTelephony;

/* JADX INFO: loaded from: classes2.dex */
public class SIMUtils {
    public static final String COUNTRY_CN = "cn";
    public static final String MTK_SIM_ACTIVE_STATE_CHANGE_ACTION = "";
    private static final int NOT_PROVISIONED = 0;
    private static final int PROVISIONED = 1;
    public static final int SDK_VERSION_R = 30;
    private static final String TAG = "SIMUtils";

    public SIMUtils() {
    }

    private static IExtTelephony getExtTelephony() {
        IExtTelephony r0 = IExtTelephony.Stub.asInterface(ServiceManager.getService("extphone"));
        if (r0 != null) goto L5;
        OLog.e(TAG, "getExtTelephony() return null ");
    L5:
        return r0;
    }

    public static void activateSIMSlot(Context r0, int r1) {
        activateSIMSlotR(r0, r1);
    }

    public static void activateSIMSlotR(Context r4, int r5) {
        List<SubscriptionInfo> r0 = SubscriptionUtil.getAvailableSubscriptions(r4);
        int r6 = MultiSimAdapter.slot2Sub(r5);
        Iterator<SubscriptionInfo> r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        SubscriptionInfo r2 = r1.next();
        if (Objects.equals(Integer.valueOf(r2.getSimSlotIndex()), Integer.valueOf(r6)) == false) goto L4;
        ((SubscriptionManager) r4.getSystemService(SubscriptionManager.class)).setSubscriptionEnabled(r2.getSubscriptionId(), true);
        goto L4
    }

    public static void deactivateSIMSlot(Context r0, int r1, int r2) {
        deactivateSIMSlotR(r0, r1, r2);
    }

    public static void deactivateSIMSlotR(Context r6, int r7, int r8) {
        List<SubscriptionInfo> r0 = SubscriptionUtil.getAvailableSubscriptions(r6);
        int r1 = MultiSimAdapter.slot2Sub(r7);
        Iterator<SubscriptionInfo> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L12;
        SubscriptionInfo r3 = r2.next();
        if (Objects.equals(Integer.valueOf(r3.getSubscriptionId()), Integer.valueOf(r1)) == false) goto L4;
        SubscriptionManager r4 = (SubscriptionManager) r6.getSystemService(SubscriptionManager.class);
        int r5 = r3.getSubscriptionId();
        if (isSIMForDataChecked(r4, r7) == false) goto L11;
        setDataEnabled(r6, r8, false);
    L11:
        r4.setSubscriptionEnabled(r5, false);
        goto L4
    }

    public static void setDataEnabled(Context r1, int r2, boolean r3) {
        int r4 = MultiSimAdapter.slot2Sub(r2);
        TelephonyManager r5 = (TelephonyManager) r1.getSystemService(MultiSimAdapter.PHONE_KEY);
        if (r5 == null) goto L6;
        r5.setDataEnabled(r4, r3);
        return;
    }

    public static boolean isSIMForDataChecked(SubscriptionManager r1, int r2) {
        if (MultiSimSelectSubscription.getPhoneIdFor(r1, 2) != r2) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isSubActive(Context r0, int r1) {
        return isSubActiveR(r0, r1);
    }

    public static boolean isSubActiveR(Context r5, int r6) {
        List<SubscriptionInfo> r0 = SubscriptionUtil.getAvailableSubscriptions(r5);
        int r7 = MultiSimAdapter.slot2Sub(r6);
        Iterator<SubscriptionInfo> r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L23;
        SubscriptionInfo r2 = r1.next();
        if (Objects.equals(Integer.valueOf(r2.getSubscriptionId()), Integer.valueOf(r7)) == false) goto L4;
        SubscriptionManager r8 = (SubscriptionManager) r5.getSystemService(SubscriptionManager.class);
        int r9 = r2.getSubscriptionId();
        if (r2.isEmbedded() == true) goto L11;
        int r3 = SubscriptionManager.getPhoneId(r9);
        if (r8.isActiveSubscriptionId(r9) == true) goto L15;
        return false;
    L15:
        if (TelephonyManager.getSimStateForSlotIndex(r3) == 6) goto L22;
        return true;
    L22:
        return false;
    L11:
        return r8.isActiveSubscriptionId(r9);
    L23:
        return false;
    }

    public static boolean isShowCbsSettings(Context r5) {
        if (r5 != null) goto L5;
        return false;
    L5:
        TelephonyManager r6 = (TelephonyManager) r5.getSystemService(MultiSimAdapter.PHONE_KEY);
        int r1 = r6.getPhoneCount();
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L14;
        String r3 = r6.getNetworkCountryIsoForPhone(r2);
        if (TextUtils.isEmpty(r3) == true) goto L13;
        if ("cn".equals(r3) == true) goto L13;
        return true;
    L13:
        r2 = r2 + 1;
        goto L6
    L14:
        return false;
    }
}
