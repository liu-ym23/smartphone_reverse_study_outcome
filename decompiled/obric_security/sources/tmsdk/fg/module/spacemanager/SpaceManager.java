package tmsdk.fg.module.spacemanager;

import android.content.Context;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import tmsdk.fg.creator.BaseManagerF;
import tmsdkobf.ac;
import tmsdkobf.ae;
import tmsdkobf.b0;
import tmsdkobf.f;
import tmsdkobf.le;
import tmsdkobf.q8;

/* JADX INFO: loaded from: classes5.dex */
public class SpaceManager extends BaseManagerF {
    public static final int CODE_OK = 1;
    public static final int ERROR_CODE_CANCEL_SCAN = -258;
    public static final int ERROR_CODE_COLOR_FORMAT_ERROR = -55;
    public static final int ERROR_CODE_CONCURRENCY = -4097;
    public static final int ERROR_CODE_EXPIRED = -4096;
    public static final int ERROR_CODE_FILE_NOT_EXIST = -59;
    public static final int ERROR_CODE_FORMAT_NOT_SUPPORT = -54;
    public static final int ERROR_CODE_IMG_NOT_FOUND = -257;
    public static final int ERROR_CODE_OK = 0;
    public static final int ERROR_CODE_PARAM = -1;
    public static final int ERROR_CODE_PATH_EMPTY = -51;
    public static final int ERROR_CODE_STOP_ERROR = -259;
    public static final int ERROR_CODE_THRESHOLD_EXCEEDED = -53;
    public static final int ERROR_CODE_UNKNOW = -256;
    public static final int EXPIRED_LICENCE = 2;
    public static final int INIT_COMMERCIAL_FAILED = -5;
    public static final int INIT_FAILED = -1;
    public static final int INVALID_LICENCE = 3;
    public static final int NO_REGISTER_SN = 1;
    public static final int NO_TASK = 4;
    public static final String TAG = "TMSDK_SpaceManager";
    le b;

    public SpaceManager() {
    }

    public void appendCustomSdcardRoots(String r1) {
        ac.a(r1);
    }

    public void appendWhitePath(String r1) {
        ac.b(r1);
    }

    public int bigFileScan(ArrayList<String> r3, Set<String> r4, FileScanSizeRange r5, ISpaceScanListener r6) {
        q8.c(TAG, "bigFileScan");
        f.e(1310034);
        if (b0.a() == false) goto L6;
        Log.e(b0.TAG_INIT, "TMS onCreate failed, missing check Licence SafeState !");
        f.a(1310035, "2");
        return 2;
    L6:
        le r2 = this.b;
        if (r2 != null) goto L10;
        f.a(1310035, "-1");
        return -1;
    L10:
        int r7 = r2.a(r3, r4, r5, r6);
        if (r7 == 0) goto L13;
        f.a(1310035, "" + r7);
    L13:
        return r7;
    }

    public void clearCustomSdcardRoots() {
        ac.a();
    }

    public long compressPhoto(String r2) {
        if (b0.a() == false) goto L6;
        Log.e(b0.TAG_INIT, "TMS onCreate failed, missing check Licence SafeState !");
        return 2;
    L6:
        le r1 = this.b;
        if (r1 != null) goto L11;
        return -1;
    L11:
        return r1.compressPhoto(r2);
    }

    public double detectBlur(String r2) {
        if (b0.a() == false) goto L6;
        Log.e(b0.TAG_INIT, "TMS onCreate failed, missing check Licence SafeState !");
        return 2.0d;
    L6:
        le r1 = this.b;
        if (r1 != null) goto L11;
        return -1.0d;
    L11:
        return r1.detectBlur(r2);
    }

    public List<String> getSdcardRoots() {
        return new ArrayList(ac.e());
    }

    @Override // tmsdkobf.b0
    public void onCreate(Context r2) {
        if (b0.a() == false) goto L6;
        Log.e(b0.TAG_INIT, "TMS onCreate failed, missing check Licence SafeState !");
        return;
    L6:
        le r0 = new le();
        this.b = r0;
        r0.onCreate(r2);
        a(this.b);
    }

    public void onDestory() {
        le r0 = this.b;
        if (r0 == null) goto L6;
        r0.onDestory();
        return;
    }

    public int photoBlurCategorise(List<PhotoScanResult.PhotoItem> r7, double r8, int r10, ISpaceScanListener r11) {
        if (b0.a() == false) goto L6;
        Log.e(b0.TAG_INIT, "TMS onCreate failed, missing check Licence SafeState !");
        return 2;
    L6:
        le r0 = this.b;
        if (r0 != null) goto L11;
        return -1;
    L11:
        return r0.photoBlurCategorise(r7, r8, r10, r11);
    }

    public int photoCompressCategorise(ISpaceScanListener r2, List<PhotoScanResult.PhotoItem> r3) {
        if (b0.a() == false) goto L6;
        Log.e(b0.TAG_INIT, "TMS onCreate failed, missing check Licence SafeState !");
        return 2;
    L6:
        le r1 = this.b;
        if (r1 != null) goto L11;
        return -1;
    L11:
        return r1.photoCompressCategorise(r2, r3);
    }

    public int photoScan(ISpaceScanListener r3) {
        q8.c(TAG, "photoScan");
        f.e(1310023);
        if (b0.a() == false) goto L6;
        Log.e(b0.TAG_INIT, "TMS onCreate failed, missing check Licence SafeState !");
        f.a(1310025, "2");
        return 2;
    L6:
        le r2 = this.b;
        if (r2 != null) goto L10;
        f.a(1310025, "-1");
        return -1;
    L10:
        int r4 = r2.a(r3, null);
        if (r4 == 0) goto L14;
        f.a(1310025, "" + r4);
    L16:
        return r4;
    L14:
        if ((-4097) != r4) goto L16;
        return ERROR_CODE_CONCURRENCY;
    }

    public int photoSimilarCategorise(List<PhotoScanResult.PhotoItem> r3, int r4, ISpaceScanListener r5) {
        if (b0.a() == false) goto L6;
        Log.e(b0.TAG_INIT, "TMS onCreate failed, missing check Licence SafeState !");
        f.a(1310037, "2");
        return 2;
    L6:
        le r2 = this.b;
        if (r2 != null) goto L10;
        f.a(1310037, "-1");
        return -1;
    L10:
        int r6 = r2.photoSimilarCategorise(r3, r4, r5);
        if (r6 == 0) goto L14;
    L16:
        return r6;
    L14:
        if ((-4097) != r6) goto L16;
        return ERROR_CODE_CONCURRENCY;
    }

    public void resetState() {
        le r0 = this.b;
        if (r0 == null) goto L6;
        r0.c();
        return;
    }

    public void setIgnoredSdcardRoots(List<String> r1) {
        ac.c(r1);
    }

    public void shutDownPhotoISpaceScanListener() {
        le r0 = this.b;
        if (r0 == null) goto L6;
        r0.b();
        return;
    }

    public boolean stopBigFileScan() {
        if (b0.a() == false) goto L6;
        Log.e(b0.TAG_INIT, "TMS onCreate failed, missing check Licence SafeState !");
        return false;
    L6:
        le r1 = this.b;
        if (r1 == null) goto L11;
        r1.d();
        return true;
    L11:
        return true;
    }

    public int stopPhotoBlurCategorise() {
        le r0 = this.b;
        if (r0 != null) goto L7;
        return -1;
    L7:
        return r0.stopPhotoBlurCategorise();
    }

    public int stopPhotoCompressCategorise() {
        le r0 = this.b;
        if (r0 != null) goto L7;
        return -1;
    L7:
        return r0.stopPhotoCompressCategorise();
    }

    public int stopPhotoScan() {
        le r0 = this.b;
        if (r0 != null) goto L7;
        return -1;
    L7:
        return r0.stopPhotoScan();
    }

    public int stopPhotoSimilarCategorise() {
        le r0 = this.b;
        if (r0 != null) goto L7;
        return -1;
    L7:
        return r0.stopPhotoSimilarCategorise();
    }

    public int bigFileScan(ArrayList<String> r2, Set<String> r3, ISpaceScanListener r4) {
        return bigFileScan(r2, r3, null, r4);
    }

    public long compressPhoto(String r2, int r3) {
        if (b0.a() == false) goto L6;
        Log.e(b0.TAG_INIT, "TMS onCreate failed, missing check Licence SafeState !");
        return 2;
    L6:
        le r1 = this.b;
        if (r1 != null) goto L11;
        return -1;
    L11:
        return r1.compressPhoto(r2, r3);
    }

    public int photoBlurCategorise(List<PhotoScanResult.PhotoItem> r2, double r3, ISpaceScanListener r5) {
        if (b0.a() == false) goto L6;
        Log.e(b0.TAG_INIT, "TMS onCreate failed, missing check Licence SafeState !");
        return 2;
    L6:
        le r1 = this.b;
        if (r1 != null) goto L11;
        return -1;
    L11:
        return r1.photoBlurCategorise(r2, r3, r5);
    }

    public int photoSimilarCategorise(List<PhotoScanResult.PhotoItem> r2, ISpaceScanListener r3) {
        return photoSimilarCategorise(r2, ae.c, r3);
    }

    public int bigFileScan(ArrayList<String> r2, ISpaceScanListener r3) {
        return bigFileScan(r2, null, null, r3);
    }

    public long compressPhoto(String r2, int r3, String r4) {
        if (b0.a() == false) goto L6;
        Log.e(b0.TAG_INIT, "TMS onCreate failed, missing check Licence SafeState !");
        return 2;
    L6:
        le r1 = this.b;
        if (r1 != null) goto L11;
        return -1;
    L11:
        return r1.compressPhoto(r2, r3, r4);
    }

    public int photoBlurCategorise(List<PhotoScanResult.PhotoItem> r2, int r3, ISpaceScanListener r4) {
        if (b0.a() == false) goto L6;
        Log.e(b0.TAG_INIT, "TMS onCreate failed, missing check Licence SafeState !");
        return 2;
    L6:
        le r1 = this.b;
        if (r1 != null) goto L11;
        return -1;
    L11:
        return r1.photoBlurCategorise(r2, r3, r4);
    }

    public int bigFileScan(Set<String> r2, ISpaceScanListener r3) {
        return bigFileScan(null, r2, null, r3);
    }

    public int photoBlurCategorise(List<PhotoScanResult.PhotoItem> r2, ISpaceScanListener r3) {
        if (b0.a() == false) goto L6;
        Log.e(b0.TAG_INIT, "TMS onCreate failed, missing check Licence SafeState !");
        return 2;
    L6:
        le r1 = this.b;
        if (r1 != null) goto L11;
        return -1;
    L11:
        return r1.a(r3, r2);
    }

    public int bigFileScan(ISpaceScanListener r2) {
        return bigFileScan(null, null, null, r2);
    }
}
