package com.bytedanceos.utils;

import android.os.Build;
import com.bytedance.networkstackapplib.NetworkStackConstant;
import com.bytedanceos.security.SmtDevice;
import com.obric.matrix.platform.sdk.ones.producttype.ProductTypeUtils;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final enum DeviceType extends Enum<DeviceType> {
    private static final /* synthetic */ DeviceType[] $VALUES = null;
    public static final DeviceType A1 = null;
    public static final DeviceType ATOLL = null;
    public static final DeviceType BONO = null;
    public static final DeviceType DARWIN = null;
    public static final DeviceType DELTA = null;
    public static final DeviceType M1 = null;
    public static final DeviceType M1L = null;
    public static final DeviceType OCEAN = null;
    public static final DeviceType ODIN = null;
    public static final DeviceType OSBORN = null;
    public static final DeviceType OSCAR = null;
    private static Set<DeviceType> SMARTKEY_DEVICE;
    public static final DeviceType T1 = null;
    public static final DeviceType T2 = null;
    public static final DeviceType THIS = null;
    public static final DeviceType TRIDENT = null;
    public static final DeviceType U1 = null;
    public static final DeviceType UNKNOWN = null;

    private static /* synthetic */ DeviceType[] $values() {
        return new DeviceType[]{T1, T2, U1, M1, M1L, A1, BONO, ODIN, OSBORN, OSCAR, TRIDENT, OCEAN, DELTA, ATOLL, DARWIN, UNKNOWN};
    }

    public static DeviceType valueOf(String name) {
        return (DeviceType) Enum.valueOf(DeviceType.class, name);
    }

    public static DeviceType[] values() {
        return (DeviceType[]) $VALUES.clone();
    }

    static {
        T1 = new DeviceType("T1", 0);
        T2 = new DeviceType("T2", 1);
        U1 = new DeviceType("U1", 2);
        M1 = new DeviceType("M1", 3);
        M1L = new DeviceType("M1L", 4);
        A1 = new DeviceType("A1", 5);
        BONO = new DeviceType("BONO", 6);
        ODIN = new DeviceType("ODIN", 7);
        DeviceType r0 = new DeviceType("OSBORN", 8);
        OSBORN = r0;
        DeviceType r1 = new DeviceType("OSCAR", 9);
        OSCAR = r1;
        DeviceType r2 = new DeviceType("TRIDENT", 10);
        TRIDENT = r2;
        DeviceType r3 = new DeviceType("OCEAN", 11);
        OCEAN = r3;
        DeviceType r4 = new DeviceType(SmtDevice.DELTA, 12);
        DELTA = r4;
        DeviceType r5 = new DeviceType("ATOLL", 13);
        ATOLL = r5;
        DeviceType r6 = new DeviceType(SmtDevice.DARWIN, 14);
        DARWIN = r6;
        UNKNOWN = new DeviceType(NetworkStackConstant.UNKNOWN_TYPE, 15);
        $VALUES = $values();
        HashSet r7 = new HashSet();
        SMARTKEY_DEVICE = r7;
        r7.add(r0);
        SMARTKEY_DEVICE.add(r1);
        SMARTKEY_DEVICE.add(r2);
        SMARTKEY_DEVICE.add(r3);
        SMARTKEY_DEVICE.add(r4);
        SMARTKEY_DEVICE.add(r5);
        SMARTKEY_DEVICE.add(r6);
        THIS = getDeviceType();
    }

    private DeviceType(String $enum$name, int $enum$ordinal) {
        super($enum$name, $enum$ordinal);
    }

    public static boolean is(DeviceType target) {
        if (THIS != target) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isOneOf(DeviceType... deviceList) {
        if (deviceList != null) goto L5;
    L13:
        return false;
    L5:
        if (deviceList.length == 0) goto L13;
        int r1 = deviceList.length;
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L13;
        if (is(deviceList[r2]) == true) goto L10;
        r2 = r2 + 1;
        goto L7
    L10:
        return true;
    }

    private static DeviceType getDeviceType() {
        String r0 = Build.BOARD.toLowerCase();
        String r1 = Build.DEVICE.toLowerCase();
        if ("msm8974".equals(r0) == false) goto L6;
        return T1;
    L6:
        if ("msm8916".equals(r0) == false) goto L9;
        return U1;
    L9:
        if ("msm8992".equals(r0) == false) goto L12;
        return T2;
    L12:
        if ("msm8996".equals(r0) == false) goto L18;
        if ("colombo".equals(r1) == false) goto L63;
        return M1L;
    L63:
        return M1;
    L18:
        if ("msm8952".equals(r0) == false) goto L21;
        return A1;
    L21:
        if ("mt6797".equals(r0) == true) goto L58;
        if ("s10".equals(r1) == true) goto L58;
        if (r1.contains("oscar") == false) goto L28;
        return OSCAR;
    L28:
        if (r1.contains("ocean") == true) goto L73;
        if (r1.contains("aries") == true) goto L73;
        if ("sdm710".equals(r0) == true) goto L73;
        if ("sdm660".equals(r0) == true) goto L72;
        if ("osborn".equals(r1) == true) goto L72;
        if ("msm8953".equals(r0) == true) goto L71;
        if ("odin".equals(r1) == true) goto L71;
        if (r1.contains("trident") == false) goto L45;
        return TRIDENT;
    L45:
        if (r1.contains("delta") == false) goto L48;
        return DELTA;
    L48:
        if (r1.contains("atoll") == false) goto L51;
        return ATOLL;
    L51:
        if (r1.contains("darwin") == false) goto L70;
        return DARWIN;
    L70:
        return UNKNOWN;
    L71:
        return ODIN;
    L72:
        return OSBORN;
    L73:
        return OCEAN;
    L58:
        return BONO;
    }

    public static boolean isN1() {
        return ProductTypeUtils.INSTANCE.isNerida();
    }

    public static boolean isPike() {
        return ProductTypeUtils.INSTANCE.isPike();
    }

    public static boolean isPacific() {
        return ProductTypeUtils.INSTANCE.isPacific();
    }

    public static boolean isSmartKeyProduct() {
        return SMARTKEY_DEVICE.contains(THIS);
    }
}
