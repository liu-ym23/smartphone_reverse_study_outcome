package com.obric.security.cleaner.bigfile;

import android.os.Environment;
import android.text.TextUtils;
import bytedanceos.api.StorageManagerSmt;
import com.bytedanceos.cleaner.IProgress;
import com.obric.olog.OLog;
import java.io.File;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class ScanBigFileTrashTask {
    private static final String[] WHITE_LIST_PATH = null;
    private long mScannedFileSize;
    private List<BigFileScanResultItem> mTrash;

    private static class ProgressOfBigFileScan implements IProgress {
        private String fileName;
        private long fileSize;
        private ItemCache item;
        private long totalSize;

        @Override // com.bytedanceos.cleaner.IProgress
        public long getItemRemainsize() {
            return 0;
        }

        @Override // com.bytedanceos.cleaner.IProgress
        public int getPassedPercent() {
            return 0;
        }

        @Override // com.bytedanceos.cleaner.IProgress
        public long getProcessedSize() {
            return 0;
        }

        @Override // com.bytedanceos.cleaner.IProgress
        public boolean isFinal() {
            return false;
        }

        @Override // com.bytedanceos.cleaner.IProgress
        public void setItemRemainSize(long size) {
        }

        @Override // com.bytedanceos.cleaner.IProgress
        public void setProcessedSize(long size) {
        }

        ProgressOfBigFileScan(String fileName, long size, long totalSize, ItemCache item) {
            this.fileName = fileName;
            this.fileSize = size;
            this.totalSize = totalSize;
            this.item = item;
        }

        @Override // com.bytedanceos.cleaner.IProgress
        public String getDescription() {
            return this.fileName;
        }

        @Override // com.bytedanceos.cleaner.IProgress
        public long getPassedSize() {
            return this.totalSize;
        }

        @Override // com.bytedanceos.cleaner.IProgress
        public long getCurrentItemSize() {
            return this.fileSize;
        }
    }

    static {
        WHITE_LIST_PATH = new String[]{"/Android/data/com.android.gallery3d/cache", "/storage/emulated/0/./Pictures/.Recyclebin", "/storage/emulated/0/./Download/bytedance/update"};
    }

    public ScanBigFileTrashTask() {
        this.mScannedFileSize = 0;
        this.mTrash = new ArrayList();
    }

    protected List<BigFileScanResultItem> runTask() {
        this.mScannedFileSize = 0;
        return findBigFiles();
    }

    public ArrayList<BigFileScanResultItem> findBigFiles() {
        ArrayList<BigFileScanResultItem> r0 = new ArrayList();
        String r1 = Environment.getExternalStorageDirectory().getAbsolutePath();
        OLog.e("ScanBigFileTrashTask", "basePath = " + r1);
        File r2 = new File(r1 + File.separator);
        this.mTrash.clear();
        getBigFilesInDirectory(r2);
        r0.addAll(this.mTrash);
        File r3 = new File(CleanerGlobals.USER10_BASE_PATH + File.separator);
        this.mTrash.clear();
        getBigFilesInDirectory(r3);
        r0.addAll(this.mTrash);
        String r4 = StorageManagerSmt.getExternalSdcardPath();
        OLog.e("ScanBigFileTrashTask", "basePath2 = " + r4);
        if (TextUtils.isEmpty(r4) == true) goto L5;
        File r5 = new File(r4 + File.separator);
        this.mTrash.clear();
        getBigFilesInDirectory(r5);
        r0.addAll(this.mTrash);
    L5:
        Collections.sort(r0, new OrderComparator());
        return r0;
    }

    private void getBigFilesInDirectory(File file) {
        if (file != null) goto L37;
        return;
    L37:
    L32:
        th = move-exception;
        th.printStackTrace();
        return;
    L6:
        if (file.exists() == true) goto L8;
        return;
    L8:
        if (isWhiteListBigDirectory(file) == false) goto L11;
        return;
    L11:
        if (file.isDirectory() == false) goto L29;
        DirectoryStream<Path> r7 = Files.newDirectoryStream(file.toPath());     // Catch: Throwable -> L32
        Iterator<Path> r0 = r7.iterator();     // Catch: Throwable -> L21
    L15:
        if (r0.hasNext() == false) goto L18;
        getBigFilesInDirectory(r0.next().toFile());     // Catch: Throwable -> L21
    L18:
        if (r7 == null) goto L43;
        r7.close();     // Catch: Throwable -> L32
        return;
    L43:
        return;
    L21:
        th = move-exception;
        if (r7 != null) goto L35;
    L27:
        throw th;     // Catch: Throwable -> L32
    L35:
        r7.close();     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L32
        goto L27
    L29:
        if (file.length() < CleanerGlobals.BIG_FILE_MIN_SIZE) goto L44;
        BigFileScanResultItem r2 = new BigFileScanResultItem(this.mTrash.size(), file.getAbsolutePath(), file.length());     // Catch: Throwable -> L32
        OLog.e("ScanBigFileTrashTask", "file.getAbsolutePath() = " + file.getAbsolutePath());     // Catch: Throwable -> L32
        this.mScannedFileSize += r2.getSize();     // Catch: Throwable -> L32
        this.mTrash.add(r2);     // Catch: Throwable -> L32
        return;
    }

    private boolean isWhiteListBigDirectory(File file) {
        if (file != null) goto L5;
    L13:
        return false;
    L5:
        if (file.isDirectory() == false) goto L13;
        String r5 = file.getAbsolutePath();
        String[] r0 = WHITE_LIST_PATH;
        int r1 = r0.length;
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L13;
        if (r5.contains(r0[r2]) == true) goto L10;
        r2 = r2 + 1;
        goto L7
    L10:
        return true;
    }
}
