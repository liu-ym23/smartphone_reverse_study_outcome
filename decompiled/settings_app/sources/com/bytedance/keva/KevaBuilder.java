package com.bytedance.keva;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public class KevaBuilder {
    private static KevaBuilder mInstance;
    Context mContext;
    Executor mExecutor;
    KevaMonitor mMonitor;
    String mPortedRepoName;
    File mWorkDir;

    public KevaBuilder() {
    }

    static {
        mInstance = new KevaBuilder();
    }

    public static KevaBuilder getInstance() {
        KevaBuilder r0 = mInstance;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Log.w(KevaConstants.TAG, "have already did init, builder is invalid now!");
        return new KevaBuilder();
    }

    static void clearInstance() {
        mInstance = null;
    }

    public KevaBuilder setContext(Context r1) {
        this.mContext = r1;
        return this;
    }

    public KevaBuilder setMonitor(KevaMonitor r1) {
        this.mMonitor = r1;
        return this;
    }

    public KevaBuilder setExecutor(Executor r1) {
        this.mExecutor = r1;
        return this;
    }

    public KevaBuilder setWorkDir(File r3) {
        if (r3.exists() == true) goto L8;
        Log.i(KevaConstants.TAG, "work dir does not exist! try to create " + r3.getPath());
        if (r3.mkdirs() == true) goto L8;
        Log.w(KevaConstants.TAG, "work dir fail to create!");
        return this;
    L8:
        this.mWorkDir = r3;
        return this;
    }

    public KevaBuilder setPortedRepoName(String r1) {
        this.mPortedRepoName = r1;
        return this;
    }
}
