package com.bytedanceos.datausage;

import android.content.Context;
import android.content.pm.IPackageManager;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.ParcelUuid;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.SystemProperties;
import android.os.UserHandle;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.widget.TextView;
import bytedanceos.api.TextViewSmt;
import bytedanceos.util.Features;
import com.android.internal.telephony.ITelephony;
import com.android.internal.util.CollectionUtils;
import com.obric.olog.OLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import org.codeaurora.internal.IExtTelephony;

/* JADX INFO: loaded from: classes2.dex */
public class DatausageUtils {
    public static final String PKG_PHONE_CHARGE = "com.bytedanceos.recharge";
    private static final int PROVISIONED = 1;
    public static final int SDK_VERSION_R = 30;
    private static final String SOFT_SIM_APP_PKG_NAME = "com.redteamobile.global.roaming";
    private static final String TAG = "SIMUtils";

    public DatausageUtils() {
    }

    public static boolean isSubActive(int slotId) {
        ITelephony r0 = ITelephony.Stub.asInterface(ServiceManager.checkService("phone"));
        if (r0 == null) goto L13;
        if (r0.getISmtEx().getCurrentUiccCardProvisioningStatus(slotId) == 1) goto L15;
        return false;
    L15:
        return true;
    L8:
        e = move-exception;
        e.printStackTrace();
        return false;
    L13:
        return false;
    }

    public static boolean isSubActive(Context context, int simIndex) {
        return isSubActiveR(context, simIndex);
    }

    private static boolean isSubscriptionVisible(SubscriptionManager subscriptionManager, Context context, SubscriptionInfo info) {
        if (info != null) goto L6;
        return false;
    L6:
        if (info.getGroupUuid() != null) goto L8;
    L16:
        return true;
    L8:
        if (info.isOpportunistic() == false) goto L16;
        if (((TelephonyManager) context.getSystemService(TelephonyManager.class)).createForSubscriptionId(info.getSubscriptionId()).hasCarrierPrivileges() == true) goto L15;
        if (subscriptionManager.canManageSubscription(info) == true) goto L15;
        return false;
    L15:
        return true;
    }

    public static List<SubscriptionInfo> getSelectableSubscriptionInfoList(Context context) {
        SubscriptionManager r0 = (SubscriptionManager) context.getSystemService(SubscriptionManager.class);
        List r1 = r0.getAvailableSubscriptionInfoList();
        if (r1 != null) goto L6;
        return null;
    L6:
        ArrayList r2 = new ArrayList();
        HashMap r3 = new HashMap();
        Iterator r4 = r1.iterator();
    L8:
        if (r4.hasNext() == false) goto L22;
        SubscriptionInfo r5 = (SubscriptionInfo) r4.next();
        if (isSubscriptionVisible(r0, context, r5) == false) goto L8;
        ParcelUuid r6 = r5.getGroupUuid();
        if (r6 == null) goto L14;
        if (r3.containsKey(r6) == false) goto L21;
        if (((SubscriptionInfo) r3.get(r6)).getSimSlotIndex() != (-1)) goto L8;
        if (r5.getSimSlotIndex() == (-1)) goto L8;
    L21:
        r2.remove(r3.get(r6));
        r2.add(r5);
        r3.put(r6, r5);
        goto L8
    L14:
        r2.add(r5);
        goto L8
    L22:
        return r2;
    }

    public static List<SubscriptionInfo> getAvailableSubscriptions(Context context) {
        return new ArrayList(CollectionUtils.emptyIfNull(getSelectableSubscriptionInfoList(context)));
    }

    public static boolean isSubActiveR(Context context, int simIndex) {
        List<SubscriptionInfo> r0 = getAvailableSubscriptions(context);
        int r6 = bytedanceos.util.MultiSimAdapter.slot2Sub(simIndex);
        Iterator<SubscriptionInfo> r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L23;
        SubscriptionInfo r2 = r1.next();
        if (Objects.equals(Integer.valueOf(r2.getSubscriptionId()), Integer.valueOf(r6)) == false) goto L4;
        SubscriptionManager r5 = (SubscriptionManager) context.getSystemService(SubscriptionManager.class);
        int r7 = r2.getSubscriptionId();
        if (r2.isEmbedded() == true) goto L11;
        int r3 = SubscriptionManager.getPhoneId(r7);
        if (r5.isActiveSubscriptionId(r7) == true) goto L15;
        return false;
    L15:
        if (TelephonyManager.getSimStateForSlotIndex(r3) == 6) goto L22;
        return true;
    L22:
        return false;
    L11:
        return r5.isActiveSubscriptionId(r7);
    L23:
        return false;
    }

    private static IExtTelephony getExtTelephony() {
        IExtTelephony r0 = IExtTelephony.Stub.asInterface(ServiceManager.getService("extphone"));
        if (r0 != null) goto L5;
        OLog.e(TAG, "getExtTelephony() return null ");
    L5:
        return r0;
    }

    public static boolean isMultiSimSupport() {
        if (bytedanceos.util.MultiSimAdapter.getPhoneCount() > 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static boolean hasMultiSimInDevice() {
        if (bytedanceos.util.MultiSimAdapter.isMultiSimEnabled() == true) goto L5;
        return false;
    L5:
        if (bytedanceos.util.MultiSimAdapter.hasIccCard(0) == true) goto L7;
        return false;
    L7:
        if (bytedanceos.util.MultiSimAdapter.hasIccCard(1) == true) goto L9;
        return false;
    L9:
        return true;
    }

    public static void setMaxTextSizeForTextView(TextView target, float maxSize) {
        if (target == null) goto L5;
        TextViewSmt.getInstance().setMaxTextSize(target, maxSize);
        return;
    }

    public static boolean isPhoneChargeSupport(Context context) {
        if (isFeatureDomestic(context) == true) goto L5;
    L7:
        return false;
    L5:
        if (isCtaTestModeOn() == true) goto L7;
        return true;
    }

    public static boolean isPhoneChargeInstalled(Context context) {
        return isPackageInstalled(context, PKG_PHONE_CHARGE);
    }

    public static boolean isRoamingChargeInstalled(Context context) {
        return isPackageInstalled(context, SOFT_SIM_APP_PKG_NAME);
    }

    public static boolean isCtaTestModeOn() {
        if (SystemProperties.getInt("persist.radio.cta.test.mode", 0) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    public static final boolean isFeatureDomestic(Context context) {
        if ("oscar_oversea".equalsIgnoreCase(Build.DEVICE) == false) goto L7;
        return false;
    L7:
        return Features.isFeatureDomestic(context);
    }

    public static boolean isPackageInstalled(Context context, String pkg) {
        if (pkg != null) goto L14;
        return false;
    L14:
        PackageManager r2 = context.getPackageManager();     // Catch: PackageManager.NameNotFoundException -> L10
        if (r2 != null) goto L8;
        return false;
    L8:
        PackageInfo r3 = r2.getPackageInfo(pkg, 0);     // Catch: PackageManager.NameNotFoundException -> L10
    L11:
        if (r3 == null) goto L16;
        return true;
    L16:
        return false;
    L10:
        OLog.w(TAG, "pkg:" + pkg + " not installed");
        r3 = null;
        goto L11
    }

    public static boolean doppelgangerAppExist(IPackageManager ipm, int uid) {
        String[] r1 = ipm.getPackagesForUid(uid);     // Catch: RemoteException -> L13
        if (r1 != null) goto L6;
    L8:
        String r2 = null;
    L9:
        if (ipm.getApplicationInfo(r2, 0, UserHandle.getUserId(uid)) == null) goto L15;
        return true;
    L15:
        return false;
    L6:
        if (r1.length <= 0) goto L8;
        r2 = r1[0];     // Catch: RemoteException -> L13
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L15
    }
}
