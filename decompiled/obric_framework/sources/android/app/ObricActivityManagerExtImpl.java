package android.app;

import android.os.Bundle;
import android.os.RemoteException;
import android.util.Singleton;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ObricActivityManagerExtImpl implements IObricActivityManagerExt {
    private static final String OBRIC_ASSIST_PACKAGE_NAME = "com.larus.nova";
    private static final String TAG = "ObricActivityManagerExtImpl";
    private static final Singleton<IObricActivityManager> sObricActivityManagerSingleton = null;

    public ObricActivityManagerExtImpl() {
    }

    static {
        sObricActivityManagerSingleton = new AnonymousClass1();
    }

    private static IObricActivityManager getObricService() {
        return (IObricActivityManager) sObricActivityManagerSingleton.get();
    }

    public int getAutoDisplayId() {
        return getObricService().getAutoDisplayId();
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public ActivityManager.RunningTaskInfo getCurrentTaskInfo(int displayId) {
        return getObricService().getCurrentTaskInfo(displayId);
    L4:
        e = move-exception;
        throw e.rethrowFromSystemServer();
    }

    public boolean isPackageVisibleOnDisplay(String pakcageName, int displayId) {
        return getObricService().isPackageVisibleOnDisplay(pakcageName, displayId);
    L4:
        e = move-exception;
        throw e.rethrowFromSystemServer();
    }

    public boolean registerTaskStackListenerEx(ObricTaskStackListener listenerEx) {
        return getObricService().registerTaskStackListenerEx(listenerEx);
    L4:
        e = move-exception;
        throw e.rethrowFromSystemServer();
    }

    public boolean unregisterTaskStackListenerEx(ObricTaskStackListener listenerEx) {
        return getObricService().unregisterTaskStackListenerEx(listenerEx);
    L4:
        e = move-exception;
        throw e.rethrowFromSystemServer();
    }

    public boolean moveTaskToDisplay(int taskId, int displayId, boolean isTop) {
        return getObricService().moveTaskToDisplay(taskId, displayId, isTop);
    L4:
        e = move-exception;
        throw e.rethrowFromSystemServer();
    }

    public void tryToMute(boolean shouldMute) {
        getObricService().tryToMute(shouldMute);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public void enableCallUser(boolean enable) {
        getObricService().enableCallUser(enable);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public void addDisablePackage(String[] packageName) {
        getObricService().addDisablePackage(packageName);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public boolean registerObricDisplayInfoCallback(ObricDisplayInfoCallback listener) {
        return getObricService().registerObricDisplayInfoCallback(listener);
    L4:
        e = move-exception;
        throw e.rethrowFromSystemServer();
    }

    public boolean unregisterObricDisplayInfoCallback(ObricDisplayInfoCallback listener) {
        return getObricService().unregisterObricDisplayInfoCallback(listener);
    L4:
        e = move-exception;
        throw e.rethrowFromSystemServer();
    }

    public boolean registerBackNavigationInVirtualDisplayListenerEx(IObricBackNavigationListener listener) {
        return getObricService().registerBackNavigationInVirtualDisplayListenerEx(listener);
    L4:
        e = move-exception;
        throw e.rethrowFromSystemServer();
    }

    public boolean unregisterBackNavigationInVirtualDisplayListenerEx(IObricBackNavigationListener listener) {
        return getObricService().unregisterBackNavigationInVirtualDisplayListenerEx(listener);
    L4:
        e = move-exception;
        throw e.rethrowFromSystemServer();
    }

    public boolean registerBackNavigationListener(IObricBackNavigationListener listener) {
        return getObricService().registerBackNavigationListener(listener);
    L4:
        e = move-exception;
        throw e.rethrowFromSystemServer();
    }

    public boolean unregisterBackNavigationListener(IObricBackNavigationListener listener) {
        return getObricService().unregisterBackNavigationListener(listener);
    L4:
        e = move-exception;
        throw e.rethrowFromSystemServer();
    }

    public boolean requestTopActivityAssistData(int requestId, int displayId, ITopActivityAssistDataReceiver receiver) {
        return getObricService().requestTopActivityAssistData(requestId, displayId, receiver);
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public String getObricAssistPackageName() {
        return OBRIC_ASSIST_PACKAGE_NAME;
    }

    public boolean isAutoAction(String packageName) {
        return OBRIC_ASSIST_PACKAGE_NAME.equals(packageName);
    }

    public void setMuteWhitelist(List<String> whitelist) {
        getObricService().setMuteWhitelist(whitelist);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public void reportScenePerceptionEvent(int type, Bundle bundle) {
        getObricService().reportScenePerceptionEvent(type, bundle);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }
}
