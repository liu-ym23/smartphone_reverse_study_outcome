package com.bytedance.apm.block;

import android.app.Activity;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.FluencySwitchListener;
import com.bytedance.apm.FluencySwitchManager;
import com.bytedance.apm.block.trace.MainThreadMonitor;
import com.bytedance.apm.config.FluencyConfig;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm.listener.IBlockListener;
import com.bytedance.apm.logging.Logger;
import com.bytedance.services.apm.api.IActivityLifeObserver;

/* JADX INFO: loaded from: classes3.dex */
public class BlockDetector extends AbsLooperObserver implements IActivityLifeObserver, FluencySwitchListener {
    private static final String TAG = "BlockDetector";
    private boolean mInited;
    private StackThread mStackThread;
    private boolean mStarted;

    @Override // com.bytedance.services.apm.api.IActivityLifeObserver
    public void onActivityCreated(Activity r1, Bundle r2) {
    }

    @Override // com.bytedance.services.apm.api.IActivityLifeObserver
    public void onActivityPause(Activity r1) {
    }

    @Override // com.bytedance.services.apm.api.IActivityLifeObserver
    public void onActivityResume(Activity r1) {
    }

    @Override // com.bytedance.services.apm.api.IActivityLifeObserver
    public void onActivityStarted(Activity r1) {
    }

    @Override // com.bytedance.services.apm.api.IActivityLifeObserver
    public void onChange(Activity r1, Fragment r2) {
    }

    public BlockDetector() {
        this.mStackThread = StackThread.getInstance();
    }

    public void init() {
        ActivityLifeObserver.getInstance().register(this);
        FluencySwitchManager.addListener(this);
        this.mStackThread.init();
        MainThreadMonitor.getMonitor().addObserver(this);
        MainThreadMonitor.getMonitor().setBlockDetectorAdded();
        this.mInited = true;
        if (ApmContext.isDebugMode() == false) goto L6;
        Logger.d(TAG, new String[]{"BlockDetector init: "});
        return;
    }

    public void setSliverEnable(boolean r1) {
        this.mStackThread.setSliverDump(r1);
    }

    @Override // com.bytedance.apm.FluencySwitchListener
    public void onRefresh(FluencyConfig r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        long r0 = r8.getBlockThreshold();
        long r2 = r8.getSeriousBlockThreshold();
        boolean r4 = r8.isEnableGfxMonitor();
        boolean r5 = r8.isBlockDumpStackEnable();
        this.mStackThread.setEnableGfxMonitor(r4);
        this.mStackThread.setBlockInterval(r0);
        this.mStackThread.setSeriousBlockInterval(r2);
        this.mStackThread.setEnableDumpStack(r5);
        this.mStackThread.setNeedMonitorBlock(r8.isBlockEnableUpload());
        StackThread r7 = this.mStackThread;
        if (ApmContext.isNeedSalvage() == false) goto L7;
    L10:
        boolean r9 = true;
    L11:
        r7.setNeedMonitorSeriousBlock(r9);
        return;
    L7:
        if (r8.isSeriousBlockEnableUpload() == true) goto L10;
        r9 = false;
        goto L11
    }

    public void start() {
        if (this.mInited == true) goto L5;
        return;
    L5:
        if (this.mStarted == true) goto L13;
        this.mStarted = true;
        if (ApmContext.isDebugMode() == false) goto L12;
        Logger.d(TAG, new String[]{"BlockDetector start: "});
        return;
    L12:
        return;
    }

    public void stop() {
        if (this.mStarted == true) goto L5;
        return;
    L5:
        this.mStarted = false;
        this.mStackThread.printEnd(false);
        if (ApmContext.isDebugMode() == false) goto L9;
        Logger.d(TAG, new String[]{"BlockDetector stop: "});
        return;
    }

    @Override // com.bytedance.apm.block.AbsLooperObserver
    public void dispatchEnd(long r1, long r3, long r5, long r7, boolean r9) {
        super.dispatchEnd(r1, r3, r5, r7, r9);
        if (this.mStarted == false) goto L6;
        this.mStackThread.printEnd(r9);
        return;
    }

    @Override // com.bytedance.apm.block.AbsLooperObserver
    public void dispatchBegin(String r2) {
        super.dispatchBegin(r2);
        if (this.mStarted == false) goto L6;
        this.mStackThread.printStart(r2);
        return;
    }

    @Override // com.bytedance.services.apm.api.IActivityLifeObserver
    public void onBackground(Activity r1) {
        stop();
    }

    @Override // com.bytedance.services.apm.api.IActivityLifeObserver
    public void onFront(Activity r1) {
        start();
    }

    public void setBlockThresholdMs(long r1) {
        this.mStackThread.setBlockInterval(r1);
    }

    public void setWithSeriousBlockDetect(boolean r1) {
        this.mStackThread.setWithSeriousBlock(r1);
    }

    public void setIgnoreInvalidStack(boolean r1) {
        this.mStackThread.setIgnoreInvalidStack(r1);
    }

    public void setBlockListener(IBlockListener r1) {
        this.mStackThread.setBlockListener(r1);
    }
}
