package com.obric.netdetect.Utils;

/* JADX INFO: loaded from: classes3.dex */
public class WifiUtils {
    private static final int BAND_24_GHZ_END_FREQ_MHZ = 2484;
    private static final int BAND_24_GHZ_START_FREQ_MHZ = 2412;
    private static final int BAND_5_GHZ_END_FREQ_MHZ = 5885;
    private static final int BAND_5_GHZ_START_FREQ_MHZ = 5160;
    public static final int BAND_6_GHZ_END_FREQ_MHZ = 7115;
    public static final int BAND_6_GHZ_OP_CLASS_136_CH_2_FREQ_MHZ = 5935;
    public static final int BAND_6_GHZ_START_FREQ_MHZ = 5955;

    private static boolean is24GHz(int r1) {
        if (r1 >= BAND_24_GHZ_START_FREQ_MHZ) goto L5;
    L7:
        return false;
    L5:
        if (r1 > BAND_24_GHZ_END_FREQ_MHZ) goto L7;
        return true;
    }

    public static boolean is5GHz(int r1) {
        if (r1 >= BAND_5_GHZ_START_FREQ_MHZ) goto L5;
    L7:
        return false;
    L5:
        if (r1 > BAND_5_GHZ_END_FREQ_MHZ) goto L7;
        return true;
    }

    public static boolean is6GHz(int r2) {
        if (r2 != 5935) goto L6;
        return true;
    L6:
        if (r2 >= 5955) goto L8;
    L10:
        return false;
    L8:
        if (r2 > 7115) goto L10;
        return true;
    }

    public WifiUtils() {
    }

    public static int getBand(int r1) {
        if (is24GHz(r1) == false) goto L7;
        return 1;
    L7:
        if (is5GHz(r1) == false) goto L11;
        return 2;
    L11:
        if (is6GHz(r1) == false) goto L14;
        return 3;
    L14:
        return 0;
    }
}
