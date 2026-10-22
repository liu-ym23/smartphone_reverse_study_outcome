package com.bytedance.platform.godzilla.crash.deadsystemexception;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.bytedance.platform.godzilla.common.DoubleReflectHelper;
import com.bytedance.platform.godzilla.common.Logger;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public class ViewRootImplHandlerHook implements Application.ActivityLifecycleCallbacks {
    private Field mAttachInfoField;
    private Field mHandlerField;

    public static class PreventHandlerCallback implements Handler.Callback {
        private Handler mTargetHandler;

        public PreventHandlerCallback(Handler r1) {
            this.mTargetHandler = r1;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message r4) {
            Logger.e("ViewRootImplHandlerHook", "Handle message " + r4);     // Catch: Throwable -> L6
            this.mTargetHandler.handleMessage(r4);     // Catch: Throwable -> L6
            return true;
        L9:
            return true;
        }
    }

    public ViewRootImplHandlerHook() {
    }

    public static /* synthetic */ Field access$000(ViewRootImplHandlerHook r0) {
        return r0.mAttachInfoField;
    }

    public static /* synthetic */ Field access$100(ViewRootImplHandlerHook r0) {
        return r0.mHandlerField;
    }

    public static /* synthetic */ Field access$102(ViewRootImplHandlerHook r0, Field r1) {
        r0.mHandlerField = r1;
        return r1;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity r1, Bundle r2) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity r1) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity r1) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity r1) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity r1, Bundle r2) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity r3) {
        Logger.e("ViewRootImplHandlerHook", "onActivityStarted！");
        if (this.mAttachInfoField != null) goto L8;
        return;
    L8:
        final View r4 = r3.getWindow().getDecorView();     // Catch: Throwable -> L7
        r4.addOnAttachStateChangeListener(new AnonymousClass1(this, r4));     // Catch: Throwable -> L7
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity r1) {
    }

    public void onHook(Application r3) {
        Field r0 = DoubleReflectHelper.getField(View.class, "mAttachInfo");     // Catch: Throwable -> L6
        this.mAttachInfoField = r0;     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        r0.setAccessible(true);     // Catch: Throwable -> L6
        r3.registerActivityLifecycleCallbacks(this);     // Catch: Throwable -> L6
        Logger.e("ViewRootImplHandlerHook", "Hook success ");     // Catch: Throwable -> L6
        return;
    L9:
        return;
    }
}
