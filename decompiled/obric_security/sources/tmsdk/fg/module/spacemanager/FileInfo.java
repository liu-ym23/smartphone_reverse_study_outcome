package tmsdk.fg.module.spacemanager;

import android.text.TextUtils;
import java.io.File;
import tmsdk.common.tcc.QFile;

/* JADX INFO: loaded from: classes5.dex */
public class FileInfo {
    public static final int TYPE_BIGFILE = 3;
    public static final int TYPE_RADIO = 1;
    public static final int TYPE_VIDEO = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f74a;
    private long b;
    private long c;
    public String mPath;
    public long mSize;
    public String mSrcName;
    public int type;

    public FileInfo() {
        this.type = 3;
        this.f74a = -1;
        this.b = -1;
        this.c = -1;
    }

    public boolean delFile() {
        if (TextUtils.isEmpty(this.mPath) == false) goto L7;
        return false;
    L7:
        return new QFile(this.mPath).deleteSelf();
    }

    public String getFileName() {
        if (TextUtils.isEmpty(this.mPath) == false) goto L5;
        return null;
    L5:
        String r0 = this.mPath;
        String r2 = File.separator;
        if (r0.endsWith(r2) == false) goto L8;
        return null;
    L8:
        String r1 = this.mPath;
        return r1.substring(r1.lastIndexOf(r2) + 1, this.mPath.length());
    }

    public long getmAccessTime() {
        if ((-1) != this.c) goto L9;
        if (TextUtils.isEmpty(this.mPath) == false) goto L7;
        return -1;
    L7:
        QFile r0 = new QFile(this.mPath);
        r0.fillExtraInfo();
        this.f74a = r0.createTime;
        this.b = r0.modifyTime;
        this.c = r0.accessTime;
    L9:
        return this.c;
    }

    public long getmCreateTime() {
        if (TextUtils.isEmpty(this.mPath) == false) goto L6;
        return -1;
    L6:
        if ((-1) != this.f74a) goto L9;
        QFile r0 = new QFile(this.mPath);
        r0.fillExtraInfo();
        this.f74a = r0.createTime;
        this.b = r0.modifyTime;
        this.c = r0.accessTime;
    L9:
        return this.f74a;
    }

    public long getmModifyTime() {
        if ((-1) != this.b) goto L9;
        if (TextUtils.isEmpty(this.mPath) == false) goto L7;
        return -1;
    L7:
        QFile r0 = new QFile(this.mPath);
        r0.fillExtraInfo();
        this.f74a = r0.createTime;
        this.b = r0.modifyTime;
        this.c = r0.accessTime;
    L9:
        return this.b;
    }

    public String toString() {
        return this.mPath + " :: " + this.mSize + " :: " + this.mSrcName;
    }
}
