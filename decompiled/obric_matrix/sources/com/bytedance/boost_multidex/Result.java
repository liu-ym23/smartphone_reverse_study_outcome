package com.bytedance.boost_multidex;

import android.util.Log;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class Result {
    private static Result result;
    public File dataDir;
    public File dexDir;
    public List<String> dexInfoList;
    public Throwable fatalThrowable;
    public long freeSpaceAfter;
    public long freeSpaceBefore;
    public boolean isYunOS;
    public boolean modified;
    public File optDexDir;
    public File rootDir;
    public boolean supportFastLoadDex;
    public List<Throwable> unFatalThrowable;
    public String vmLibName;
    public File zipDir;

    static {
        result = new Result();
    }

    private Result() {
        this.unFatalThrowable = new ArrayList();
        this.dexInfoList = new ArrayList();
    }

    public static Result get() {
        Result r0 = result;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Log.w(Constants.TAG, "Avoid npe, but return a invalid tmp result");
        return new Result();
    }

    public void addDexInfo(String r1) {
        this.dexInfoList.add(r1);
    }

    public void addUnFatalThrowable(Throwable r1) {
        this.unFatalThrowable.add(r1);
    }

    public void setDirs(File r1, File r2, File r3, File r4, File r5) {
        this.dataDir = r1;
        this.rootDir = r2;
        this.dexDir = r3;
        this.optDexDir = r4;
        this.zipDir = r5;
    }

    public void setFatalThrowable(Throwable r1) {
        this.fatalThrowable = r1;
    }
}
