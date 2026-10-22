package com.bytedanceos.security.reflect;

/* JADX INFO: loaded from: classes2.dex */
public class MSimHelper {
    public MSimHelper() {
    }

    public static boolean has2Card() {
        Object r2 = ReflectHelper.getStaticVariable("com.android.internal.telephony.PhoneConstants", "SUB1");
        if (r2 != null) goto L10;
        Object r1 = ReflectHelper.getStaticVariable("com.android.internal.telephony.MSimConstants", "SUB1");
        Object r4 = ReflectHelper.getStaticVariable("android.telephony.MSimTelephonyManager", "sInstance");
        Object r3 = ReflectHelper.invokeProxyMethod("android.telephony.MSimTelephonyManager", "hasIccCard", r4, new Class[]{Integer.TYPE}, new Object[]{r1});
        Object r0 = ReflectHelper.getStaticVariable("com.android.internal.telephony.MSimConstants", "SUB2");
        Object r5 = ReflectHelper.invokeProxyMethod("android.telephony.MSimTelephonyManager", "hasIccCard", r4, new Class[]{Integer.TYPE}, new Object[]{r0});
        if (((Boolean) r3).booleanValue() == true) goto L7;
        return false;
    L7:
        if (((Boolean) r5).booleanValue() == true) goto L9;
        return false;
    L9:
        return true;
    L10:
        Object r6 = ReflectHelper.getStaticVariable("android.telephony.TelephonyManager", "sInstance");
        Object r7 = ReflectHelper.invokeProxyMethod("android.telephony.TelephonyManager", "hasIccCard", r6, new Class[]{Integer.TYPE}, new Object[]{r2});
        Object r8 = ReflectHelper.getStaticVariable("com.android.internal.telephony.PhoneConstants", "SUB2");
        Object r9 = ReflectHelper.invokeProxyMethod("android.telephony.TelephonyManager", "hasIccCard", r6, new Class[]{Integer.TYPE}, new Object[]{r8});
        if (((Boolean) r7).booleanValue() == true) goto L13;
        return false;
    L13:
        if (((Boolean) r9).booleanValue() == true) goto L15;
        return false;
    L15:
        return true;
    }
}
