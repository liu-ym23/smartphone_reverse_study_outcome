package com.bytedance.sysoptimizer;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import cz.msebera.android.httpclient.message.TokenParser;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public class ArtOptimizer {
    private static String[] DEVICE_BLOCK_LIST = null;
    private static String TAG = "SYSOPTIMIZER";
    private static boolean mOptimized = false;

    private static native boolean increaseSuspendTime();

    private static boolean loadOptimizerOnNeed(Context r0) {
        return false;
    }

    static {
        DEVICE_BLOCK_LIST = new String[]{"WIKO RAINBOW JAM", "Android J7", "HighScreen Power Rage", "GiONEE P5W", "GiONEE M5 mini", "GiONEE P2M", "GiONEE P5 mini", "condor PGN518", "condor PGN513", "condor PGN517", "condor PGN521", "condor PGN409", "condor TGW801G", "Orbis orbis", "Fly FS504", "QMobile S2", "QMobile i6i", "QMobile M350", "QMobile W80", "Turbo C5", "alps X8 Pro", "alps Atlantis 1010A", "TECNO DP7CPRO", "OPPO 1201", "WIKO LENNY2", "Masstel N600", "lmkj Modern S10", "Icherry iCherry C121", "iris X1 Selfie", "Iris Fuel F1", "digiland DL1008M", "Reeder P9C", "HUAWEI Mate 9 pro", "Micromax Q338", "inovo I615", "NIPDA Hurricane", "elink mobell tab 7s", "SPC P6", "G6", "lmkj PLAY 2", "Kata Tmini3", "U732", "ITJ C9", "ORRO H860p", "samsung SM-G930F", "lmkj Silver1", "alps TB-603G", "vivo Y15S", "ragentek Infinix X510", "Konnect Plus", "magnus bravo Z40", "GIONEE M5 mini", "ORALE X1", "digiland DL718M", "WALTON Primo RM2 mini", "TECHMADE TechPad10QC", "alps PCD PH701T", "GiONEE P3S", "TELEFUNKEN TEL-1013GIQA", "PIXUS play three v3.1", "Gini S4", "SLTDVD9220", "E1031H1C TPC-XTE10D", "TECNO DP7CPro-SGA1", "lmkj i9", "Nomi i504", "Texet TM-1067", "ALLVIEW V2_Viper_I_TM", "vivo Y31", "CloudFone ExciteC", "asus ASUS_Z00VD", "Coolpad A110", "inovo I612", "MITO A33", "Masstel N560", "Massgo bird6580_weg_b_l", "ASTON Thunder", "HOPO P9", "Massgo_Vi5", "Xphone X8610", "lmkj P8", "inovo I515", "samsung SM-A9000", "Android R8", "Android C7", "G6"};
    }

    private ArtOptimizer() {
    }

    private static boolean filterOutDevice() {
        String r0 = Build.BRAND;
        String r1 = Build.MODEL;
        if (r1 == null) goto L11;
        if (r0 != null) goto L7;
    L9:
        r0 = r1;
        goto L11
    L7:
        if (r1.contains(r0) == true) goto L9;
        r0 = r0 + TokenParser.SP + r1;
    L11:
        if (r0 != null) goto L14;
        return false;
    L14:
        if (Arrays.asList(DEVICE_BLOCK_LIST).contains(r0) == false) goto L17;
        return true;
    L17:
        return false;
    }

    public static synchronized boolean optSuspendTimeout(Context r4) {
        monitor-enter(ArtOptimizer.class);
    L21:
        th = move-exception;
        throw th;
    L5:
        if (mOptimized == false) goto L11;
        monitor-exit(ArtOptimizer.class);
        return true;
    L11:
        if (loadOptimizerOnNeed(r4) == true) goto L25;
        monitor-exit(ArtOptimizer.class);
        return false;
    L25:
        boolean r5 = increaseSuspendTime();     // Catch: UnsatisfiedLinkError -> L15 Throwable -> L21
        mOptimized = r5;     // Catch: UnsatisfiedLinkError -> L15 Throwable -> L21
        monitor-exit(ArtOptimizer.class);
        return r5;
    L15:
        e = move-exception;
        Log.e(TAG, "UnsatisfiedLinkError", e);     // Catch: Throwable -> L21
        return false;
    }
}
