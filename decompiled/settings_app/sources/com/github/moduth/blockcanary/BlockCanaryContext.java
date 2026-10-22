package com.github.moduth.blockcanary;

import android.content.Context;
import com.bytedance.networkstackapplib.NetworkStackConstant;
import com.github.moduth.blockcanary.internal.BlockInfo;
import java.io.File;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class BlockCanaryContext {
    private static Context sApplicationContext;
    private static BlockCanaryContext sInstance;

    static {
    }

    public List<String> concernPackages() {
        return null;
    }

    public boolean deleteFilesInWhiteList() {
        return false;
    }

    public boolean displayNotification() {
        return false;
    }

    public boolean filterNonConcernStack() {
        return false;
    }

    public void onBlock(Context r1, BlockInfo r2) {
    }

    public int provideBlockThreshold() {
        return 1000;
    }

    public int provideMonitorDuration() {
        return 99999;
    }

    public String provideNetworkType() {
        return NetworkStackConstant.UNKNOWN_TYPE;
    }

    public String providePath() {
        return "/blockcanary/";
    }

    public String provideQualifier() {
        return "Unspecified";
    }

    public String provideUid() {
        return "0";
    }

    public List<String> provideWhiteList() {
        return null;
    }

    public boolean stopWhenDebugging() {
        return true;
    }

    public boolean zip(File[] r1, File r2) {
        return false;
    }

    public BlockCanaryContext() {
    }

    static void init(Context r0, BlockCanaryContext r1) {
        sApplicationContext = r0;
        sInstance = r1;
    }

    public static BlockCanaryContext get() {
        BlockCanaryContext r0 = sInstance;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new RuntimeException("BlockCanaryContext not init");
    }

    public Context provideContext() {
        return sApplicationContext;
    }

    public int provideDumpInterval() {
        return provideBlockThreshold();
    }

    public void upload(File r1) {
        throw new UnsupportedOperationException();
    }
}
