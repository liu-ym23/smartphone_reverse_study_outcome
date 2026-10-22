package tmsdk.common.tcc;

import tmsdk.common.TMSDKContext;

/* JADX INFO: loaded from: classes5.dex */
public class TccDiff {
    static final int BSPatchFlagCheckNewFileMd5 = 2;
    static final int BSPatchFlagCheckOldFileMd5 = 1;

    static {
        TMSDKContext.registerNatives(9, TccDiff.class);
    }

    public TccDiff() {
    }

    public static native int bsPatch(String r0, String r1, String r2, int r3);

    public static native String fileMd5(String r0);

    public static native String getByteMd5(byte[] r0);
}
