package tmsdk.fg.module.spacemanager.impl.duplicatefile;

import android.content.Context;
import android.util.Log;
import java.util.List;
import java.util.Set;
import tmsdk.fg.creator.BaseManagerF;
import tmsdk.fg.module.spacemanager.FileScanSizeRange;
import tmsdkobf.b0;
import tmsdkobf.f4;

/* JADX INFO: loaded from: classes5.dex */
public class DuplicateFileScannerManager extends BaseManagerF {
    public static final int ERROR_CODE_CANCEL_SCAN = -2;
    public static final int ERROR_CODE_CONCURRENCY = -3;
    public static final int ERROR_CODE_OK = 0;
    public static final int ERROR_CODE_PARAM = -1;
    private f4 b;

    public DuplicateFileScannerManager() {
    }

    public void addFileTypes(List<String> r2) {
        if (b0.a() == false) goto L6;
        Log.e(b0.TAG_INIT, "TMS onCreate failed, missing check Licence SafeState !");
        return;
    L6:
        f4 r1 = this.b;
        if (r1 == null) goto L10;
        r1.addFileTypes(r2);
        return;
    }

    public void addScanFileSizeRange(FileScanSizeRange r2) {
        if (b0.a() == false) goto L6;
        Log.e(b0.TAG_INIT, "TMS onCreate failed, missing check Licence SafeState !");
        return;
    L6:
        f4 r1 = this.b;
        if (r1 == null) goto L10;
        r1.addScanFileSizeRange(r2);
        return;
    }

    public void cancelScan() {
        f4 r0 = this.b;
        if (r0 == null) goto L6;
        r0.cancelScan();
        return;
    }

    @Override // tmsdkobf.b0
    public int getSingletonType() {
        return 1;
    }

    @Override // tmsdkobf.b0
    public void onCreate(Context r2) {
        if (b0.a() == false) goto L6;
        Log.e(b0.TAG_INIT, "TMS onCreate failed, missing check Licence SafeState !");
        return;
    L6:
        f4 r0 = new f4();
        this.b = r0;
        r0.onCreate(r2);
        a(this.b);
    }

    public int scanDuplicateFileInfo(String r3, Set<String> r4, IDuplicateFileScanListener r5) {
        if (b0.a() == false) goto L7;
        Log.e(b0.TAG_INIT, "TMS onCreate failed, missing check Licence SafeState !");
        return 2;
    L7:
        if (r3 != null) goto L9;
    L17:
        return -1;
    L9:
        if (r3.trim().isEmpty() == true) goto L17;
        f4 r2 = this.b;
        if (r2 == null) goto L17;
        if (r5 != null) goto L16;
        return -1;
    L16:
        return r2.scanDuplicateFileInfo(r3, r4, r5);
    }

    public int scanDuplicateFileInfo(String r2, IDuplicateFileScanListener r3) {
        return scanDuplicateFileInfo(r2, null, r3);
    }
}
