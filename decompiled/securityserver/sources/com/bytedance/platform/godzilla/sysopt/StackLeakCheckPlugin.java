package com.bytedance.platform.godzilla.sysopt;

import android.content.Context;
import com.bytedance.platform.godzilla.plugin.BasePlugin;
import com.bytedance.sysoptimizer.StackLeakChecker;

/* JADX INFO: loaded from: classes.dex */
public class StackLeakCheckPlugin extends BasePlugin {
    private Context mContext;
    private long mInterval;
    private StackLeakChecker.StackLeakListener mListener;
    private int mThreshold;
    private String[] mWhiteList;

    public StackLeakCheckPlugin(Context r1, int r2, long r3, String[] r5, StackLeakChecker.StackLeakListener r6) {
        this.mContext = r1;
        this.mThreshold = r2;
        this.mInterval = r3;
        this.mWhiteList = r5;
        this.mListener = r6;
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public String getName() {
        return "StackCheckPlugin";
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public void start() {
        super.start();
        StackLeakChecker.registerStackLeakListener(this.mListener);
        StackLeakChecker.setInterval(this.mThreshold, this.mInterval);
        StackLeakChecker.enableChecker(this.mContext, this.mWhiteList);
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public void stop() {
        super.stop();
        StackLeakChecker.disableChecker();
    }
}
