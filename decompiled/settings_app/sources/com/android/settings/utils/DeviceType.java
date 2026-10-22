package com.android.settings.utils;

import android.os.Build;
import com.android.settings.ProductFlavor;
import com.bytedance.networkstackapplib.NetworkStackConstant;
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
    public static final DeviceType PACIFIC = null;
    private static Set<DeviceType> SMARTKEY_DEVICE;
    public static final DeviceType T1 = null;
    public static final DeviceType T2 = null;
    public static final DeviceType THIS = null;
    public static final DeviceType TRIDENT = null;
    public static final DeviceType U1 = null;
    public static final DeviceType UNKNOWN = null;

    private static /* synthetic */ DeviceType[] $values() {
        return new DeviceType[]{T1, T2, U1, M1, M1L, A1, BONO, ODIN, OSBORN, OSCAR, TRIDENT, OCEAN, DELTA, ATOLL, DARWIN, PACIFIC, UNKNOWN};
    }

    public static DeviceType valueOf(String r1) {
        return (DeviceType) Enum.valueOf(DeviceType.class, r1);
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
        DeviceType r4 = new DeviceType("DELTA", 12);
        DELTA = r4;
        DeviceType r5 = new DeviceType("ATOLL", 13);
        ATOLL = r5;
        DeviceType r6 = new DeviceType("DARWIN", 14);
        DARWIN = r6;
        PACIFIC = new DeviceType("PACIFIC", 15);
        UNKNOWN = new DeviceType(NetworkStackConstant.UNKNOWN_TYPE, 16);
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

    private DeviceType(String r1, int r2) {
        super(r1, r2);
    }

    public static boolean is(DeviceType r1) {
        if (THIS != r1) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isOneOf(DeviceType... r4) {
        if (r4 != null) goto L5;
    L13:
        return false;
    L5:
        if (r4.length == 0) goto L13;
        int r1 = r4.length;
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L13;
        if (is(r4[r2]) == true) goto L10;
        r2 = r2 + 1;
        goto L7
    L10:
        return true;
    }

    private static DeviceType getDeviceType() {
        String r0 = Build.BOARD.toLowerCase();
        String r1 = Build.DEVICE.toLowerCase();
        if (r0.equals("sun") == false) goto L8;
        if (r1.equals(ProductFlavor.PRODUCT_PACIFIC) == false) goto L8;
        return PACIFIC;
    L8:
        return UNKNOWN;
    }

    public static boolean isSmartKeyProduct() {
        return SMARTKEY_DEVICE.contains(THIS);
    }
}
