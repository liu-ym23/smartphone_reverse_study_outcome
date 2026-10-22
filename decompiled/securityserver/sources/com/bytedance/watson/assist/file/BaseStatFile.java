package com.bytedance.watson.assist.file;

import com.bytedance.watson.assist.utils.DebugLog;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseStatFile {
    private File mFile;
    protected FileStatInfo mLastInfo;
    private String mPath;

    public BaseStatFile(String r2) {
        this.mLastInfo = null;
        this.mFile = null;
        this.mPath = r2;
    }

    public FileStatInfo doRead(File r1) {
        return null;
    }

    public FileStatInfo getInfo() {
        return this.mLastInfo;
    }

    public FileStatInfo refresh() {
        if (this.mPath != null) goto L7;
        DebugLog.w("refresh and path null");
        return null;
    L7:
        if (this.mFile != null) goto L9;
        this.mFile = new File(this.mPath);
    L9:
        FileStatInfo r0 = doRead(this.mFile);
        this.mLastInfo = r0;
        return r0;
    }

    public String toString() {
        return "BaseStatFile{mPath='" + this.mPath + "', mFile=" + this.mFile + ", mLastInfo=" + this.mLastInfo + '}';
    }
}
