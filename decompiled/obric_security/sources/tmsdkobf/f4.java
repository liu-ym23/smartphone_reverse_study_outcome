package tmsdkobf;

import android.content.Context;
import java.util.List;
import java.util.Set;
import tmsdk.fg.module.spacemanager.FileScanSizeRange;
import tmsdk.fg.module.spacemanager.impl.duplicatefile.IDuplicateFileScanListener;

/* JADX INFO: loaded from: classes5.dex */
public class f4 extends b0 {
    private final g4 b;

    public f4() {
        this.b = new g4();
    }

    public void addFileTypes(List r1) {
        this.b.a(r1);
    }

    public void addScanFileSizeRange(FileScanSizeRange r1) {
        this.b.a(r1);
    }

    public void cancelScan() {
        this.b.a();
    }

    @Override // tmsdkobf.b0
    public void onCreate(Context r1) {
    }

    public int scanDuplicateFileInfo(String r3, Set r4, IDuplicateFileScanListener r5) {
        if (r3 != null) goto L5;
    L11:
        return -1;
    L5:
        if (r3.trim().isEmpty() == true) goto L11;
        if (r5 != null) goto L10;
        return -1;
    L10:
        return this.b.a(r3, r4, r5);
    }
}
