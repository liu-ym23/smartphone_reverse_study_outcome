package tmsdk.common.tcc;

import tmsdk.common.TMSDKContext;
import tmsdkobf.c0;
import tmsdkobf.ed;
import tmsdkobf.l8;

/* JADX INFO: loaded from: classes5.dex */
public class SdcardScannerFactory {
    public static final long FLAG_GET_ALL_FILE = 8;
    public static final long FLAG_NEED_BASIC_INFO = 2;
    public static final long FLAG_NEED_EXTRA_INFO = 4;
    public static final long FLAG_SCAN_WIDE = 16;
    public static final int TYPE_QSCANNER = 1;
    public static boolean isLoadNativeOK = false;

    static {
        isLoadNativeOK = l8.a(TMSDKContext.getApplicaionContext(), "dce-1.1.28-mfr");
    }

    public SdcardScannerFactory() {
    }

    public static DeepCleanEngine getDeepCleanEngine(DeepCleanEngine.Callback r1) {
        return getDeepCleanEngine(r1, 0);
    }

    public static DeepCleanSAFEngine getDeepCleanSAFEngine(DeepCleanEngine.Callback r1) {
        return getDeepCleanSAFEngine(r1, 0);
    }

    public static QSdcardScanner getQSdcardScanner(long r1, c0.a r3, ed r4) {
        QSdcardScanner r2 = (QSdcardScanner) getScanner(1, r1, r4);
        if (r2 != null) goto L6;
        return null;
    L6:
        r2.setListener(r3);
        return r2;
    }

    private static c0 getScanner(int r9, long r10, Object r12) {
        if (r9 == 1) goto L5;
        return null;
    L5:
        long r3 = nativeAllocate(r9, r10);
        if (r3 != 0) goto L9;
        return null;
    L9:
        return new QSdcardScanner(r3, r9, r10, r12);
    }

    private static native long nativeAllocate(int r0, long r1);

    public static DeepCleanEngine getDeepCleanEngine(DeepCleanEngine.Callback r2, int r3) {
        if (isLoadNativeOK == true) goto L5;
        return null;
    L5:
        DeepCleanEngine r0 = new DeepCleanEngine(r2);
        if (r0.init(r3) == false) goto L8;
        return r0;
    L8:
        return null;
    }

    public static DeepCleanSAFEngine getDeepCleanSAFEngine(DeepCleanEngine.Callback r1, int r2) {
        if (isLoadNativeOK == true) goto L5;
        return null;
    L5:
        DeepCleanSAFEngine r3 = new DeepCleanSAFEngine(r1);
        if (r3.init() == false) goto L8;
        return r3;
    L8:
        return null;
    }
}
