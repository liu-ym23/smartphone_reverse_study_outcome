package com.bytedance.apm.block.trace;

import android.app.Activity;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.bytedance.apm.block.AbsLooperObserver;
import com.bytedance.apm6.foundation.ActivityLifeManager;
import com.bytedance.apm6.service.ServiceManager;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbsTracer extends AbsLooperObserver implements ITracer {
    private static final String TAG = "Matrix.AbsTracer";
    private volatile boolean isAlive;

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

    protected void onAlive() {
    }

    @Override // com.bytedance.services.apm.api.IActivityLifeObserver
    public void onBackground(Activity r1) {
    }

    @Override // com.bytedance.services.apm.api.IActivityLifeObserver
    public void onChange(Activity r1, Fragment r2) {
    }

    protected void onDead() {
    }

    @Override // com.bytedance.services.apm.api.IActivityLifeObserver
    public void onFront(Activity r1) {
    }

    public AbsTracer() {
        this.isAlive = false;
    }

    @Override // com.bytedance.apm.block.trace.ITracer
    public final synchronized void onStartTrace() {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.isAlive == true) goto L6;
        this.isAlive = true;     // Catch: Throwable -> L8
        onAlive();     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
    }

    @Override // com.bytedance.apm.block.trace.ITracer
    public final synchronized void onCloseTrace() {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.isAlive == false) goto L6;
        this.isAlive = false;     // Catch: Throwable -> L8
        onDead();     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
    }

    @Override // com.bytedance.apm.block.trace.ITracer
    public boolean isAlive() {
        return this.isAlive;
    }

    public boolean isForeground() {
        return ((ActivityLifeManager) ServiceManager.getService(ActivityLifeManager.class)).isForeground();
    }
}
