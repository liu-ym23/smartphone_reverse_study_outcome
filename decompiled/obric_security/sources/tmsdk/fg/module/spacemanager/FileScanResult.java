package tmsdk.fg.module.spacemanager;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class FileScanResult {
    public List<FileInfo> mBigFiles;
    public List<FileMedia> mRadioFiles;
    public List<FileMedia> mVideoFiles;

    public FileScanResult() {
        this.mVideoFiles = new ArrayList();
        this.mRadioFiles = new ArrayList();
        this.mBigFiles = new ArrayList();
    }

    public long getBigFileSize() {
        Iterator<FileInfo> r4 = this.mBigFiles.iterator();
        long r0 = 0;
    L4:
        if (r4.hasNext() == false) goto L6;
        r0 = r0 + r4.next().mSize;
        goto L4
    L6:
        return r0;
    }

    public long getRadioSize() {
        Iterator<FileMedia> r4 = this.mRadioFiles.iterator();
        long r0 = 0;
    L4:
        if (r4.hasNext() == false) goto L6;
        r0 = r0 + r4.next().mSize;
        goto L4
    L6:
        return r0;
    }

    public long getVideoSize() {
        Iterator<FileMedia> r4 = this.mVideoFiles.iterator();
        long r0 = 0;
    L4:
        if (r4.hasNext() == false) goto L6;
        r0 = r0 + r4.next().mSize;
        goto L4
    L6:
        return r0;
    }
}
