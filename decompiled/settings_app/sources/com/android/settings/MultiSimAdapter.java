package com.android.settings;

import android.content.Context;
import android.content.Intent;
import android.os.ServiceManager;
import android.os.SystemProperties;
import android.telephony.PhoneStateListener;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.android.internal.telephony.ISub;
import com.android.internal.telephony.ITelephony;
import com.obric.olog.OLog;

/* JADX INFO: loaded from: classes2.dex */
public class MultiSimAdapter {
    public static final int CARD_FEATURE_CSIM = 8;
    public static final int CARD_FEATURE_ISIM = 16;
    public static final int CARD_FEATURE_RUIM = 4;
    public static final int CARD_FEATURE_SIM = 1;
    public static final int CARD_FEATURE_UNKOWN = 0;
    public static final int CARD_FEATURE_USIM = 2;
    private static final boolean DBG = false;
    public static final int INVALID_SLOT_ID = -1;
    public static final int INVALID_SUB_ID = -1;
    public static final String PHONE_KEY = "phone";
    public static final int SLOT1 = 0;
    public static final int SLOT2 = 1;
    public static final String SLOT_KEY = "slot";
    public static final int SUB1 = 0;
    public static final int SUB2 = 1;
    public static final String SUBSCRIPTION_KEY = "subscription";
    private static final String TAG = "MultiSimAdapter";
    public static final int mPhoneCount = 0;

    public static int getRealDataNetworkType(int r0) {
        return 0;
    }

    public static boolean isValidSubId(int r1) {
        if (r1 <= (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public MultiSimAdapter() {
    }

    static {
        boolean r1 = false;
        if (SystemProperties.getInt("ro.debuggable", 0) != 1) goto L5;
        r1 = true;
    L5:
        DBG = r1;
        mPhoneCount = TelephonyManager.getDefault().getPhoneCount();
    }

    public static boolean isMultiSimEnabled() {
        if (mPhoneCount > 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static int getPhoneCount() {
        return mPhoneCount;
    }

    public static Intent putSlotIdToIntent(Intent r1, int r2) {
        if (r1 == null) goto L4;
        r1.putExtra("slot", r2);
    L4:
        return r1;
    }

    public static Intent putSubIdToIntent(Intent r1, int r2) {
        if (r1 == null) goto L4;
        r1.putExtra("subscription", r2);
    L4:
        return r1;
    }

    public static int getSlotIdFromIntent(Intent r3, int r4) {
        int r0 = -1;
        if (r3 == null) goto L13;
        int r1 = r3.getIntExtra("slot", -1);
        if (isValidSlotId(r1) == true) goto L11;
        r1 = r3.getIntExtra(PHONE_KEY, -1);
        if (isValidSlotId(r1) == true) goto L11;
        int r5 = r3.getIntExtra("subscription", -1);
        if (isValidSubId(r5) == false) goto L11;
        r0 = sub2Slot(r5);
    L11:
        r0 = r1;
    L13:
        if (isValidSlotId(r0) == false) goto L15;
        return r0;
    L15:
        return r4;
    }

    public static int getSubIdFromIntent(Intent r3, int r4) {
        int r0 = -1;
        if (r3 == null) goto L11;
        int r1 = r3.getIntExtra("subscription", -1);
        if (isValidSubId(r1) == true) goto L9;
        int r5 = getSlotIdFromIntent(r3, -1);
        if (isValidSlotId(r5) == false) goto L9;
        r0 = slot2Sub(r5);
    L9:
        r0 = r1;
    L11:
        if (isValidSubId(r0) == false) goto L13;
        return r0;
    L13:
        return r4;
    }

    public static boolean isValidSlotId(int r1) {
        if (r1 >= 0) goto L4;
    L6:
        return false;
    L4:
        if (r1 >= mPhoneCount) goto L6;
        return true;
    }

    public static int slot2Sub(int r3) {
        int[] r0 = SubscriptionManager.getSubId(r3);
        if (r0 != null) goto L6;
        loge("slot2Sub(), slotId=" + r3 + ", subId=null");
        return -1;
    L6:
        if (r0.length != 0) goto L9;
        loge("slot2Sub(), slotId=" + r3 + ", subId.length=0");
        return -1;
    L9:
        if (isValidSubId(r0[0]) == true) goto L11;
        return -1;
    L11:
        return r0[0];
    }

    public static int sub2Slot(int r1) {
        if (isMultiSimEnabled() == true) goto L5;
        return 0;
    L5:
        return SubscriptionManager.getSlotIndex(r1);
    }

    public static int getDefaultSlot() {
        if (isMultiSimEnabled() == false) goto L9;
        int r0 = SubscriptionManager.getSlotIndex(SubscriptionManager.getDefaultSubscriptionId());
        if (isValidSlotId(r0) == true) goto L8;
        return 0;
    L8:
        return r0;
    L9:
        return 0;
    }

    public static int getDataSlot() {
        return getDefaultDataSlot();
    }

    public static int getDefaultDataSlot() {
        if (isMultiSimEnabled() == false) goto L9;
        int r0 = SubscriptionManager.getPhoneId(SubscriptionManager.getDefaultDataSubscriptionId());
        if (isValidSlotId(r0) == true) goto L8;
        return 0;
    L8:
        return r0;
    L9:
        return 0;
    }

    public static int getSimState(int r2) {
        if (isValidSlotId(r2) == false) goto L12;
        return TelephonyManager.getDefault().getSimState(r2);
    L6:
        e = move-exception;
        loge("getSimState(), ex=" + e);
        return 0;
    L12:
        return 0;
    }

    public static int[] supplyPinReportResult(String r1, int r2) {
        int r3 = slot2Sub(r2);
        if (isValidSubId(r3) == false) goto L9;
        return getTelephony().supplyPinReportResultForSubscriber(r3, r1);
    L6:
        e = move-exception;
        loge("supplyPinReportResult(), ex=" + e);
    L9:
        return new int[]{2, 0};
    }

    public static int[] supplyPukReportResult(String r1, String r2, int r3) {
        int r4 = slot2Sub(r3);
        if (isValidSubId(r4) == false) goto L9;
        return getTelephony().supplyPukReportResultForSubscriber(r4, r1, r2);
    L6:
        e = move-exception;
        loge("supplyPukReportResult(), ex=" + e);
    L9:
        return new int[]{2, 0};
    }

    @Deprecated
    public static String getSimSerialNumber(int r2) {
        int r3 = slot2Sub(r2);
        if (isValidSubId(r3) == false) goto L12;
        return TelephonyManager.getDefault().getSimSerialNumber(r3);
    L6:
        e = move-exception;
        loge("getSimSerialNumber(), ex=" + e);
        return null;
    L12:
        return null;
    }

    public static String getSimSerialNumber(Context r1, int r2) {
        int r3 = slot2Sub(r2);
        if (isValidSubId(r3) == false) goto L12;
        return TelephonyManager.from(r1).getSimSerialNumber(r3);
    L6:
        e = move-exception;
        loge("getSimSerialNumber(), ex=" + e);
        return null;
    L12:
        return null;
    }

    @Deprecated
    public static int getSlotIdForSimId(String r6) {
        if (TextUtils.isEmpty(r6) == false) goto L5;
        return -1;
    L5:
        String r2 = getSimSerialNumber(0);
        String r4 = getSimSerialNumber(1);
        if (TextUtils.isEmpty(r2) == true) goto L14;
        if (TextUtils.isEmpty(r4) == true) goto L14;
        if (r2.equals(r4) == false) goto L14;
        return -2;
    L14:
        if (r6.equals(r2) == false) goto L17;
        return 0;
    L17:
        if (r6.equals(r4) == false) goto L19;
        return 1;
    L19:
        return -1;
    }

    public static int getSlotIdForSimId(Context r5, String r6) {
        if (TextUtils.isEmpty(r6) == false) goto L5;
        return -1;
    L5:
        String r2 = getSimSerialNumber(r5, 0);
        String r7 = getSimSerialNumber(r5, 1);
        if (TextUtils.isEmpty(r2) == true) goto L14;
        if (TextUtils.isEmpty(r7) == true) goto L14;
        if (r2.equals(r7) == false) goto L14;
        return -2;
    L14:
        if (r6.equals(r2) == false) goto L17;
        return 0;
    L17:
        if (r6.equals(r7) == false) goto L19;
        return 1;
    L19:
        return -1;
    }

    @Deprecated
    public static int[] getSlotIdForSimId(String[] r9) {
        if (r9 != null) goto L5;
        return null;
    L5:
        int r1 = r9.length;
        if (r1 > 0) goto L8;
        return null;
    L8:
        int[] r0 = new int[r1];
        String[] r2 = {getSimSerialNumber(0), getSimSerialNumber(1)};
        int r5 = 0;
    L9:
        if (r5 >= r1) goto L21;
        if (TextUtils.isEmpty(r9[r5]) == false) goto L13;
        r0[r5] = -1;
    L20:
        r5 = r5 + 1;
        goto L9
    L13:
        if (r9[r5].equals(r2[0]) == false) goto L16;
        r0[r5] = 0;
        goto L20
    L16:
        if (r9[r5].equals(r2[1]) == false) goto L18;
        r0[r5] = 1;
        goto L20
    L18:
        r0[r5] = -1;
        goto L20
    L21:
        return r0;
    }

    public static int[] getSlotIdForSimId(Context r8, String[] r9) {
        if (r9 != null) goto L5;
        return null;
    L5:
        int r1 = r9.length;
        if (r1 > 0) goto L8;
        return null;
    L8:
        int[] r0 = new int[r1];
        String[] r2 = {getSimSerialNumber(r8, 0), getSimSerialNumber(r8, 1)};
        int r10 = 0;
    L9:
        if (r10 >= r1) goto L21;
        if (TextUtils.isEmpty(r9[r10]) == false) goto L13;
        r0[r10] = -1;
    L20:
        r10 = r10 + 1;
        goto L9
    L13:
        if (r9[r10].equals(r2[0]) == false) goto L16;
        r0[r10] = 0;
        goto L20
    L16:
        if (r9[r10].equals(r2[1]) == false) goto L18;
        r0[r10] = 1;
        goto L20
    L18:
        r0[r10] = -1;
        goto L20
    L21:
        return r0;
    }

    public static String getSimOperator(int r2) {
        if (isValidSlotId(r2) == false) goto L12;
        return TelephonyManager.getDefault().getSimOperatorNumericForPhone(r2);
    L6:
        e = move-exception;
        loge("getSimOperator(), ex=" + e);
        return "";
    L12:
        return "";
    }

    public static String getSimOperatorName(int r2) {
        if (isValidSlotId(r2) == false) goto L12;
        return TelephonyManager.getDefault().getSimOperatorNameForPhone(r2);
    L6:
        e = move-exception;
        loge("getSimOperatorName(), ex=" + e);
        return "";
    L12:
        return "";
    }

    public static boolean hasIccCard(int r2) {
        return TelephonyManager.getDefault().hasIccCard(r2);
    L4:
        e = move-exception;
        loge("hasIccCard(), ex=" + e);
        return false;
    }

    public static String getVoiceMailNumber(int r2) {
        int r3 = slot2Sub(r2);
        if (isValidSubId(r3) == false) goto L12;
        return TelephonyManager.getDefault().getVoiceMailNumber(r3);
    L6:
        e = move-exception;
        loge("getVoiceMailNumber(), ex=" + e);
        return null;
    L12:
        return null;
    }

    public static String getDeviceId(int r2) {
        if (isValidSlotId(r2) == false) goto L12;
        return TelephonyManager.getDefault().getDeviceId(r2);
    L6:
        e = move-exception;
        loge("getDeviceId(), ex=" + e);
        return null;
    L12:
        return null;
    }

    public static String getLine1Number(int r2) {
        int r3 = slot2Sub(r2);
        if (isValidSubId(r3) == false) goto L12;
        return TelephonyManager.getDefault().getLine1Number(r3);
    L6:
        e = move-exception;
        loge("getLine1Number(), ex=" + e);
        return null;
    L12:
        return null;
    }

    public static void listen(PhoneStateListener r1, int r2) {
        TelephonyManager.getDefault().listen(r1, r2);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        loge("listen(), ex=" + e);
    }

    public static int getCallState(int r2) {
        int r3 = slot2Sub(r2);
        if (isValidSubId(r3) == false) goto L12;
        return TelephonyManager.getDefault().getCallState(r3);
    L6:
        e = move-exception;
        loge("getCallState(), ex=" + e);
        return -1;
    L12:
        return -1;
    }

    private static ITelephony getTelephony() {
        return ITelephony.Stub.asInterface(ServiceManager.checkService(PHONE_KEY));
    }

    private static ISub getSub() {
        return ISub.Stub.asInterface(ServiceManager.getService("isub"));
    }

    private static void loge(String r1) {
        OLog.e(TAG, r1);
    }
}
