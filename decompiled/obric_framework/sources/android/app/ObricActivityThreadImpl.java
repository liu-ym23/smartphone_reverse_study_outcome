package android.app;

import android.app.sceneperception.ScenePerceptionHelper;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.util.Slog;
import android.view.ViewRootImpl;
import android.view.WindowManagerGlobal;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class ObricActivityThreadImpl implements IObricActivityThread {
    public static final boolean DEBUG = false;
    private static final String TAG = "ObricActivityThreadImpl";
    private ActivityThread mBase;
    private boolean mHasCallInit;
    private Method mInitMethod;
    private Object mInstance;
    private ScenePerceptionHelper mScenePerceptionHelper;

    static {
        DEBUG = Build.IS_DEBUGGABLE;
    }

    public ObricActivityThreadImpl(ActivityThread base) {
        this.mInstance = null;
        this.mInitMethod = null;
        this.mHasCallInit = false;
        this.mScenePerceptionHelper = null;
        this.mBase = base;
    }

    public void handleViewRootMovedToDisplay(ActivityThread.ActivityClientRecord r, ViewRootImpl viewRoot, int displayId, Configuration reportedConfig) {
        Log.d(TAG, "handleViewRootMovedToDisplay: displayId=" + displayId);
        ArrayList<ViewRootImpl> viewRoots = WindowManagerGlobal.getInstance().getRootViews(r.token);
        Iterator<ViewRootImpl> r1 = viewRoots.iterator();
    L4:
        if (r1.hasNext() == false) goto L13;
        ViewRootImpl vr = r1.next();
        if (vr == viewRoot) goto L4;
        if (vr.getView() == null) goto L4;
        if (vr.getView().isAttachedToWindow() == false) goto L4;
        vr.onMovedToDisplay(displayId, reportedConfig);
        vr.updateConfiguration(displayId);
        goto L4
    }

    public void doScenePerceptionAction(Activity topActivity, int type, Bundle bundle) {
        if (DEBUG == false) goto L5;
        Slog.i(TAG, "doScenePerceptionAction: type=" + type + ", " + this.mBase.getProcessName());
    L5:
        switch(type) {
            case 1: goto L15;
            default: goto L18;
        };
    L15:
        getScenePerceptionHelper().requestScenePerception(topActivity, bundle);     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        if (DEBUG == false) goto L14;
        Slog.e(TAG, "doScenePerceptionAction: error", e);
        return;
    L14:
        return;
    }

    private ScenePerceptionHelper getScenePerceptionHelper() {
        if (this.mScenePerceptionHelper != null) goto L6;
        this.mScenePerceptionHelper = new ScenePerceptionHelper();
    L6:
        return this.mScenePerceptionHelper;
    }
}
