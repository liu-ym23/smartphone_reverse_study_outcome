package com.qualcomm.qti.internal.telephony;

import android.content.Context;
import android.os.PersistableBundle;
import android.os.SystemProperties;
import android.telephony.CarrierConfigManager;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.android.internal.telephony.Call;
import com.android.internal.telephony.Phone;
import com.android.internal.telephony.PhoneConstants;
import com.android.internal.telephony.PhoneFactory;

/* JADX INFO: loaded from: classes4.dex */
public class QtiEmergencyCallHelper {
    private static final String ALLOW_ECALL_ENHANCEMENT_PROPERTY = "persist.vendor.radio.enhance_ecall";
    private static final int INVALID = -1;
    private static final String LOG_TAG = "QtiEmergencyCallHelper";
    private static final int PRIMARY_STACK_MODEMID = 0;
    private static final int PROVISIONED = 1;
    private static QtiEmergencyCallHelper sInstance;

    static {
    }

    public QtiEmergencyCallHelper() {
    }

    public static int getPhoneIdForECall(Context r16) {
        QtiSubscriptionController r1 = QtiSubscriptionController.getInstance();
        int r2 = r1.getPhoneId(r1.getDefaultVoiceSubId());
        TelephonyManager r3 = (TelephonyManager) r16.getSystemService("phone");
        int r4 = r3.getPhoneCount();
        int r8 = -1;
        if (isDeviceInSingleStandby(r16) == false) goto L5;
        int r11 = -1;
    L33:
        CarrierConfigManager r5 = (CarrierConfigManager) r16.getSystemService("carrier_config");
        if (r5 != null) goto L36;
    L55:
        int r6 = r1.getPhoneId(r1.getDefaultDataSubId());
        boolean r7 = false;
        int r9 = 0;
        boolean r10 = false;
    L57:
        if (r9 >= r4) goto L72;
        if (PhoneFactory.getPhone(r9).getServiceState().getState() != 0) goto L71;
        if (isInScbm(r9) == true) goto L62;
        if (r2 == (-1)) goto L68;
        if (r9 != r2) goto L70;
        r11 = r9;
        r10 = true;
    L70:
        r11 = r9;
        goto L71
    L68:
        if (r9 != r6) goto L70;
        r11 = r9;
        r7 = true;
        goto L71
    L62:
        Log.i(LOG_TAG, "In Sms Callback Mode on phoneId: " + r9);
        return r9;
    L71:
        r9 = r9 + 1;
        goto L57
    L72:
        if (r10 == false) goto L74;
        r6 = r2;
    L77:
        Log.d(LOG_TAG, "Voice phoneId in service = " + r6);
        int r12 = -1;
        if (r6 != (-1)) goto L94;
        int r13 = 0;
    L80:
        if (r13 >= r4) goto L91;
        Phone r14 = PhoneFactory.getPhone(r13);
        r14.getServiceState().getState();
        if (r14.getServiceState().isEmergencyOnly() == false) goto L90;
        if (isInScbm(r13) == true) goto L85;
        r6 = r13;
        if (r13 != r2) goto L90;
        r10 = true;
        goto L90
    L85:
        Log.i(LOG_TAG, "In Sms Callback Mode on phoneId: " + r13);
        return r13;
    L90:
        r13 = r13 + 1;
        goto L80
    L91:
        if (r10 == false) goto L93;
        r6 = r2;
    L93:
        Log.d(LOG_TAG, "Voice phoneId in Limited service = " + r6);
        r12 = -1;
    L94:
        if (r6 != r12) goto L112;
        r6 = getPrimaryStackPhoneId(r16);
        int r15 = 0;
    L96:
        if (r15 >= r4) goto L110;
        PhoneFactory.getPhone(r15);
        QtiPhoneUtils r0 = QtiPhoneUtils.getInstance();
        if (r3.getSimState(r15) != 5) goto L109;
        if (r0.getCurrentUiccCardProvisioningStatus(r15) != 1) goto L109;
        if (isInScbm(r15) == true) goto L103;
        r6 = r15;
        if (r15 != r2) goto L109;
        r10 = true;
        goto L109
    L103:
        Log.i(LOG_TAG, "In Sms Callback Mode on phoneId: " + r15);
        return r15;
    L109:
        r15 = r15 + 1;
        goto L96
    L110:
        if (r10 == false) goto L112;
        r6 = r2;
    L112:
        Log.d(LOG_TAG, "Voice phoneId in service = " + r6 + " preferred phoneId = " + r2 + " hasUserSetDefaultVoiceSub = " + r10 + " hasUserSetDefaultDataSub = " + r7);
        return r6;
    L74:
        if (r7 == true) goto L77;
        r6 = r11;
        goto L77
    L36:
        if (isPrivateNetworkSimInserted(r5) == false) goto L55;
        Phone[] r17 = PhoneFactory.getPhones();
        int r18 = r17.length;
        int r19 = -1;
        int r110 = 0;
    L38:
        if (r110 >= r18) goto L53;
        Phone r20 = r17[r110];
        int r21 = r20.getPhoneId();
        if (isPrivateNetwork(r5, r20) == true) goto L48;
        QtiPhoneUtils r22 = QtiPhoneUtils.getInstance();
        if (r3.getSimState(r21) == 5) goto L44;
    L47:
        int r23 = -1;
    L51:
        r110 = r110 + 1;
        r8 = r23;
        goto L38
    L44:
        if (r22.getCurrentUiccCardProvisioningStatus(r21) != 1) goto L47;
        Log.d(LOG_TAG, "public network sim is ready/PROVISIONED");
        return r21;
    L48:
        r23 = -1;
        if (r19 != (-1)) goto L51;
        r19 = r21;
        goto L51
    L53:
        if (r19 == r8) goto L55;
        return r19;
    L5:
        if (TelephonyManager.isConcurrentCallsPossible() == false) goto L24;
        Phone[] r24 = PhoneFactory.getPhones();
        int r25 = r24.length;
        r11 = -1;
        int r111 = 0;
    L7:
        if (r111 >= r25) goto L22;
        Phone r112 = r24[r111];
        if (r112.getState() != PhoneConstants.State.OFFHOOK) goto L21;
        Phone r113 = r112.getImsPhone();
        if (r113 != null) goto L14;
        Log.w(LOG_TAG, "ImsPhone should not be null");
        goto L21
    L14:
        if (r113.getForegroundCall().getState() == Call.State.ACTIVE) goto L16;
        if (r113.getBackgroundCall().getState() != Call.State.HOLDING) goto L21;
        if (r11 != (-1)) goto L21;
        r11 = r112.getPhoneId();
        goto L21
    L16:
        return r112.getPhoneId();
    L21:
        r111 = r111 + 1;
        goto L7
    L22:
        if (r11 == (-1)) goto L25;
        return r11;
    L25:
        Phone[] r26 = PhoneFactory.getPhones();
        int r27 = r26.length;
        int r114 = 0;
    L26:
        if (r114 >= r27) goto L33;
        Phone r115 = r26[r114];
        if (r115.getState() == PhoneConstants.State.OFFHOOK) goto L29;
        r114 = r114 + 1;
        goto L26
    L29:
        Log.d(LOG_TAG, "Call already active on phoneId: " + r115.getPhoneId());
        return r115.getPhoneId();
    L24:
        r11 = -1;
        goto L25
    }

    private static boolean isInScbm(int r1) {
        return ScbmHandler.getInstance().isInScbm(r1);
    }

    public static int getPrimaryStackPhoneId(Context r7) {
        int r8 = ((TelephonyManager) r7.getSystemService("phone")).getPhoneCount();
        int r1 = 0;
    L4:
        if (r1 >= r8) goto L19;
        Phone r4 = PhoneFactory.getPhone(r1);
        if (r4 == null) goto L18;
        Log.d(LOG_TAG, "Logical Modem id: " + r4.getModemUuId() + " phoneId: " + r1);
        String r5 = r4.getModemUuId();
        if (r5 == null) goto L18;
        if (r5.length() <= 0) goto L18;
        if (r5.isEmpty() == true) goto L18;
        if (Integer.parseInt(r5) != 0) goto L18;
        Log.d(LOG_TAG, "Primay Stack phone id: " + r1 + " selected");
    L20:
        if (r1 != (-1)) goto L23;
        Log.d(LOG_TAG, "Returning default phone id");
        return 0;
    L23:
        return r1;
    L18:
        r1 = r1 + 1;
        goto L4
    L19:
        r1 = -1;
        goto L20
    }

    public static boolean isDeviceInSingleStandby(Context r8) {
        if (SystemProperties.getBoolean(ALLOW_ECALL_ENHANCEMENT_PROPERTY, true) == true) goto L6;
        Log.d(LOG_TAG, "persist.vendor.radio.enhance_ecall not enabled");
        return false;
    L6:
        TelephonyManager r9 = (TelephonyManager) r8.getSystemService("phone");
        int r0 = r9.getPhoneCount();
        if (r0 != 1) goto L9;
        return true;
    L9:
        int r4 = 0;
    L10:
        if (r4 >= r0) goto L19;
        QtiPhoneUtils r5 = QtiPhoneUtils.getInstance();
        if (r9.getSimState(r4) != 5) goto L17;
        if (r5.getCurrentUiccCardProvisioningStatus(r4) != 1) goto L17;
        r4 = r4 + 1;
    L17:
        Log.d(LOG_TAG, "modem is in single standby mode");
        return true;
    L19:
        Log.d(LOG_TAG, "modem is in dual standby mode");
        return false;
    }

    private static boolean isPrivateNetworkSimInserted(CarrierConfigManager r5) {
        Phone[] r0 = PhoneFactory.getPhones();
        int r1 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L9;
        if (isPrivateNetwork(r5, r0[r3]) == true) goto L6;
        r3 = r3 + 1;
        goto L3
    L6:
        Log.d(LOG_TAG, "Private network sim is inserted");
        return true;
    L9:
        return false;
    }

    private static boolean isPrivateNetwork(CarrierConfigManager r0, Phone r1) {
        PersistableBundle r2 = r0.getConfigForSubId(r1.getSubId());
        if (r2 != null) goto L5;
    L7:
        return false;
    L5:
        if (r2.getBoolean("is_private_network") == false) goto L7;
        return true;
    }
}
