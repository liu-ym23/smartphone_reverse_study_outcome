package com.android.settings.sim;

import android.content.Context;
import android.os.ParcelUuid;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.telephony.UiccSlotInfo;
import com.android.internal.util.CollectionUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class SubscriptionUtil {
    private static final String TAG = "SubscriptionUtil";
    private static List<SubscriptionInfo> sActiveResultsForTesting;
    private static List<SubscriptionInfo> sAvailableResultsForTesting;

    public SubscriptionUtil() {
    }

    public static void setAvailableSubscriptionsForTesting(List<SubscriptionInfo> r0) {
        sAvailableResultsForTesting = r0;
    }

    public static void setActiveSubscriptionsForTesting(List<SubscriptionInfo> r0) {
        sActiveResultsForTesting = r0;
    }

    public static List<SubscriptionInfo> getActiveSubscriptions(SubscriptionManager r1) {
        List<SubscriptionInfo> r0 = sActiveResultsForTesting;
        if (r0 == null) goto L5;
        return r0;
    L5:
        List<SubscriptionInfo> r2 = r1.getActiveSubscriptionInfoList();
        if (r2 == null) goto L8;
        return r2;
    L8:
        return new ArrayList();
    }

    static boolean isInactiveInsertedPSim(UiccSlotInfo r2) {
        if (r2 != null) goto L6;
        return false;
    L6:
        if (r2.getIsEuicc() == false) goto L8;
        return false;
    L8:
        if (r2.getIsActive() == false) goto L10;
        return false;
    L10:
        if (r2.getCardStateInfo() != 2) goto L15;
        return true;
    L15:
        return false;
    }

    public static List<SubscriptionInfo> getAvailableSubscriptions(Context r1) {
        List<SubscriptionInfo> r0 = sAvailableResultsForTesting;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return new ArrayList(CollectionUtils.emptyIfNull(getSelectableSubscriptionInfoList(r1)));
    }

    private static UiccSlotInfo[] getUiccSlotsInfo(Context r1) {
        return ((TelephonyManager) r1.getSystemService(TelephonyManager.class)).getUiccSlotsInfo();
    }

    private static boolean isPrimarySubscriptionWithinSameUuid(UiccSlotInfo[] r7, ParcelUuid r8, List<SubscriptionInfo> r9, int r10) {
        ArrayList r0 = new ArrayList();
        ArrayList r1 = new ArrayList();
        ArrayList r2 = new ArrayList();
        ArrayList r3 = new ArrayList();
        Iterator<SubscriptionInfo> r11 = r9.iterator();
    L4:
        if (r11.hasNext() == false) goto L18;
        SubscriptionInfo r4 = r11.next();
        if (r8.equals(r4.getGroupUuid()) == false) goto L4;
        if (r4.isEmbedded() == false) goto L9;
        if (r4.isOpportunistic() == true) goto L14;
        r1.add(r4);
    L14:
        if (r4.getSimSlotIndex() != (-1)) goto L15;
        r3.add(r4);
        goto L4
    L15:
        r2.add(r4);
        goto L4
    L9:
        r0.add(r4);
        goto L4
    L18:
        if (r7 == null) goto L36;
        if (r0.size() <= 0) goto L36;
        SubscriptionInfo r12 = searchForSubscriptionId(r0, r10);
        if (r12 != null) goto L24;
        return false;
    L24:
        int r5 = r7.length;
        int r6 = 0;
    L25:
        if (r6 >= r5) goto L34;
        UiccSlotInfo r13 = r7[r6];
        if (r13 == null) goto L33;
        if (r13.getIsEuicc() == true) goto L33;
        if (r13.getLogicalSlotIdx() != r12.getSimSlotIndex()) goto L33;
        return true;
    L33:
        r6 = r6 + 1;
        goto L25
    L34:
        return false;
    L36:
        if (r1.size() <= 0) goto L38;
        Iterator r14 = r1.iterator();
        int r15 = 0;
        boolean r16 = false;
    L54:
        if (r14.hasNext() == false) goto L65;
        SubscriptionInfo r17 = (SubscriptionInfo) r14.next();
        if (r17.getSubscriptionId() != r10) goto L58;
        boolean r18 = true;
    L60:
        if (r17.getSimSlotIndex() != (-1)) goto L61;
        r16 = r16 | r18;
        goto L54
    L61:
        if (r18 == true) goto L62;
        r15 = r15 + 1;
        goto L54
    L62:
        return true;
    L58:
        r18 = false;
        goto L60
    L65:
        if (r15 <= 0) goto L67;
        return false;
    L67:
        return r16;
    L38:
        if (r0.size() <= 0) goto L41;
        return false;
    L41:
        if (r2.size() <= 0) goto L48;
        if (((SubscriptionInfo) r2.get(0)).getSubscriptionId() != r10) goto L46;
        return true;
    L46:
        return false;
    L48:
        if (((SubscriptionInfo) r3.get(0)).getSubscriptionId() != r10) goto L51;
        return true;
    L51:
        return false;
    }

    private static SubscriptionInfo searchForSubscriptionId(List<SubscriptionInfo> r2, int r3) {
        Iterator<SubscriptionInfo> r4 = r2.iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        SubscriptionInfo r0 = r4.next();
        if (r0.getSubscriptionId() != r3) goto L4;
        return r0;
    L8:
        return null;
    }

    public static String getDisplayName(SubscriptionInfo r0) {
        CharSequence r1 = r0.getDisplayName();
        if (r1 != null) goto L5;
        return "";
    L5:
        return r1.toString();
    }

    public static boolean showToggleForPhysicalSim(SubscriptionManager r0) {
        return r0.canDisablePhysicalSubscription();
    }

    public static int getPhoneId(Context r1, int r2) {
        SubscriptionManager r3 = (SubscriptionManager) r1.getSystemService(SubscriptionManager.class);
        if (r3 != null) goto L5;
        return -1;
    L5:
        SubscriptionInfo r4 = r3.getActiveSubscriptionInfo(r2);
        if (r4 != null) goto L9;
        return -1;
    L9:
        return r4.getSimSlotIndex();
    }

    public static List<SubscriptionInfo> getSelectableSubscriptionInfoList(Context r8) {
        SubscriptionManager r0 = (SubscriptionManager) r8.getSystemService(SubscriptionManager.class);
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
        if (isSubscriptionVisible(r0, r8, r5) == false) goto L8;
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

    private static boolean isSubscriptionVisible(SubscriptionManager r3, Context r4, SubscriptionInfo r5) {
        if (r5 != null) goto L6;
        return false;
    L6:
        if (r5.getGroupUuid() != null) goto L8;
    L16:
        return true;
    L8:
        if (r5.isOpportunistic() == false) goto L16;
        if (((TelephonyManager) r4.getSystemService(TelephonyManager.class)).createForSubscriptionId(r5.getSubscriptionId()).hasCarrierPrivileges() == true) goto L15;
        if (r3.canManageSubscription(r5) == true) goto L15;
        return false;
    L15:
        return true;
    }
}
