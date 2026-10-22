package tmsdk.common.tcc;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import tmsdkobf.ed;

/* JADX INFO: loaded from: classes5.dex */
public class QFile {
    public static final long SIZE_NOT_KNOW = -1;
    public static final long TIME_NOT_KNOW = -1;
    public static final int TYPE_DIR = 4;
    public static final int TYPE_NORMAL = 1;
    public static final int TYPE_NOT_KNOW = 0;
    public long accessTime;
    public long createTime;
    public String filePath;
    public DeletedCallback mDeletedCallback;
    public long modifyTime;
    public long size;
    public int type;

    public interface DeletedCallback {
        void onDeleteProgress(long r1);
    }

    static {
        System.loadLibrary("dce-1.1.28-mfr");
    }

    public QFile(String r3) {
        this.type = 0;
        this.size = -1;
        this.modifyTime = -1;
        this.accessTime = -1;
        this.createTime = -1;
        this.filePath = r3;
    }

    private native int nativeDeleteAllChildren(String r1);

    private native int nativeDeleteAllChildrenByDay(String r1, int r2);

    private native void nativeFillExtraInfo(String r1);

    private native QFile[] nativeList(String r1);

    private native void nativeRemoveEmptyDir(String r1);

    public int deleteAllChildren() {
        return nativeDeleteAllChildren(this.filePath);
    }

    public int deleteAllChildrenByDiffDay(int r2) {
        return nativeDeleteAllChildrenByDay(this.filePath, r2);
    }

    public boolean deleteSelf() {
        return toFile().delete();
    }

    public void fillExtraInfo() {
        nativeFillExtraInfo(this.filePath);     // Catch: UnsatisfiedLinkError -> L4
        return;
    }

    public QFile[] list() {
        return nativeList(this.filePath);
    }

    public List<QFile> listAll(long r3, ed r5) {
        final ArrayList r0 = new ArrayList();
        QSdcardScanner r4 = SdcardScannerFactory.getQSdcardScanner(r3, new AnonymousClass1(this, r0), r5);
        if (r4 == null) goto L5;
        r4.startScan(this.filePath);
        r4.release();
    L5:
        return r0;
    }

    public void onDeleteProgress(long r1) {
        DeletedCallback r0 = this.mDeletedCallback;
        if (r0 == null) goto L6;
        r0.onDeleteProgress(r1);
        return;
    }

    public File toFile() {
        return new File(this.filePath);
    }

    public QFile(String r3, int r4) {
        this.size = -1;
        this.modifyTime = -1;
        this.accessTime = -1;
        this.createTime = -1;
        this.filePath = r3;
        this.type = r4;
    }
}
