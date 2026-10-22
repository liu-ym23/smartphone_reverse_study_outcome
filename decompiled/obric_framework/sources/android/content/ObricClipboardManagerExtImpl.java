package android.content;

import android.os.Handler;
import android.os.Looper;
import android.os.PersistableBundle;
import android.os.RemoteException;
import android.util.Singleton;
import android.view.IObricWindowManagerExt;
import com.obric.utils.ObricImplFactory;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class ObricClipboardManagerExtImpl implements IObricClipboardManagerExt {
    public static final String OBRIC_CLIP_DESCRIPTION_EXTRA_KEY = "com.obric.clipboard.clip_description_tag";
    public static final String OBRIC_CLIP_DESCRIPTION_EXTRA_VALUE_OAUTO_DISPLAY = "oauto_display";
    private static IClipboard clipboardService;
    private static final Handler mHandler = null;
    private static final ArrayList<WeakReference<ClipboardManager.OnPrimaryClipChangedListener>> mPrimaryClipChangedListeners = null;
    private static final IOnPrimaryClipChangedListener.Stub mPrimaryClipChangedServiceListener = null;
    private static final Singleton<IObricClipboardManager> sObricClipboardManagerSingleton = null;

    /* JADX INFO: renamed from: android.content.ObricClipboardManagerExtImpl$1, reason: invalid class name */
    class AnonymousClass1 extends IOnPrimaryClipChangedListener.Stub {
        AnonymousClass1() {
        }

        public void dispatchPrimaryClipChanged() {
            ObricClipboardManagerExtImpl.m39$$Nest$sfgetmHandler().post(new ObricClipboardManagerExtImpl$1$$ExternalSyntheticLambda0());
        }

        static /* synthetic */ void lambda$dispatchPrimaryClipChanged$0() {
            ObricClipboardManagerExtImpl.m41$$Nest$smreportPrimaryClipChanged();
        }
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetclipboardService, reason: not valid java name */
    static /* bridge */ /* synthetic */ IClipboard m38$$Nest$sfgetclipboardService() {
        return clipboardService;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m39$$Nest$sfgetmHandler() {
        return mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$sfputclipboardService, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m40$$Nest$sfputclipboardService(IClipboard r0) {
        clipboardService = r0;
    }

    /* JADX INFO: renamed from: -$$Nest$smreportPrimaryClipChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m41$$Nest$smreportPrimaryClipChanged() {
        reportPrimaryClipChanged();
    }

    public ObricClipboardManagerExtImpl() {
    }

    static {
        mPrimaryClipChangedListeners = new ArrayList();
        mHandler = new Handler(Looper.getMainLooper());
        clipboardService = null;
        mPrimaryClipChangedServiceListener = new AnonymousClass1();
        sObricClipboardManagerSingleton = new AnonymousClass2();
    }

    private static IObricClipboardManager getObricService() {
        return (IObricClipboardManager) sObricClipboardManagerSingleton.get();
    }

    public ClipData getOautoPrimaryClip(Context context) {
    L8:
        e = move-exception;
        throw e.rethrowFromSystemServer();
    L3:
        if (clipboardService != null) goto L6;
        return null;
    L6:
        clipboardService.getIObricExt().setClipboardIsolated();     // Catch: RemoteException -> L8
        return clipboardService.getPrimaryClip(context.getOpPackageName(), context.getAttributionTag(), context.getUserId(), context.getDeviceId());
    }

    public void setOautoClipdataToUser(Context context) {
        int userId = context.getUserId();
        int deviceId = context.getDeviceId();
        getObricService().setOautoClipdataToUser(userId, deviceId);     // Catch: RemoteException -> L5
        return;
    L5:
        e = move-exception;
        throw e.rethrowFromSystemServer();
    }

    public void setUserClipdataToOauto(Context context) {
        int userId = context.getUserId();
        int deviceId = context.getDeviceId();
        getObricService().setUserClipdataToOauto(userId, deviceId);     // Catch: RemoteException -> L5
        return;
    L5:
        e = move-exception;
        throw e.rethrowFromSystemServer();
    }

    public void addOautoPrimaryClipChangedListener(Context context, ClipboardManager.OnPrimaryClipChangedListener listener) {
        ArrayList<WeakReference<ClipboardManager.OnPrimaryClipChangedListener>> r1 = mPrimaryClipChangedListeners;
        monitor-enter(r1);
        mPrimaryClipChangedListeners.removeIf(new ObricClipboardManagerExtImpl$$ExternalSyntheticLambda1());     // Catch: Throwable -> L14
        if (mPrimaryClipChangedListeners.isEmpty() == true) goto L18;
    L11:
        mPrimaryClipChangedListeners.add(new WeakReference(listener));     // Catch: Throwable -> L14
        monitor-exit(r1);     // Catch: Throwable -> L14
        return;
    L18:
        getObricService().addOautoPrimaryClipChangedListener(mPrimaryClipChangedServiceListener, context.getOpPackageName(), context.getAttributionTag(), context.getUserId(), context.getDeviceId());     // Catch: RemoteException -> L8 Throwable -> L14
    L8:
        e = move-exception;
        throw e.rethrowFromSystemServer();     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    static /* synthetic */ boolean lambda$addOautoPrimaryClipChangedListener$0(WeakReference ref) {
        if (ref != null) goto L4;
    L7:
        return true;
    L4:
        if (ref.get() == null) goto L7;
        return false;
    }

    public void removeOautoPrimaryClipChangedListener(Context context, final ClipboardManager.OnPrimaryClipChangedListener listener) {
        ArrayList<WeakReference<ClipboardManager.OnPrimaryClipChangedListener>> r1 = mPrimaryClipChangedListeners;
        monitor-enter(r1);
        mPrimaryClipChangedListeners.removeIf(new ObricClipboardManagerExtImpl$$ExternalSyntheticLambda0(listener));     // Catch: Throwable -> L13
        if (mPrimaryClipChangedListeners.isEmpty() == true) goto L16;
    L11:
        monitor-exit(r1);     // Catch: Throwable -> L13
        return;
    L16:
        getObricService().removeOautoPrimaryClipChangedListener(mPrimaryClipChangedServiceListener, context.getOpPackageName(), context.getAttributionTag(), context.getUserId(), context.getDeviceId());     // Catch: RemoteException -> L8 Throwable -> L13
    L8:
        e = move-exception;
        throw e.rethrowFromSystemServer();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    static /* synthetic */ boolean lambda$removeOautoPrimaryClipChangedListener$1(ClipboardManager.OnPrimaryClipChangedListener listener, WeakReference ref) {
        if (ref != null) goto L4;
    L9:
        return true;
    L4:
        if (ref.get() == null) goto L9;
        if (ref.get() == listener) goto L9;
        return false;
    }

    public void clearOautoPrimaryClip(Context context) {
        int userId = context.getUserId();
        int deviceId = context.getDeviceId();
        getObricService().clearOautoPrimaryClip(userId, deviceId);     // Catch: RemoteException -> L5
        return;
    L5:
        e = move-exception;
        throw e.rethrowFromSystemServer();
    }

    public boolean needClipBoardIsolate() {
        IObricWindowManagerExt windowManagerExt = ObricImplFactory.getImpl(IObricWindowManagerExt.class, new Object[0]);
        int autoDisplayId = windowManagerExt.getAutoDisplayId();
        int launchDisplayId = windowManagerExt.getCallingFocusedDisplayId();
        if (autoDisplayId == 0) goto L7;
        if (launchDisplayId != autoDisplayId) goto L8;
        return true;
    L8:
        return false;
    L7:
        return false;
    }

    public void setOautoClipboardDescriptionIfNeed(ClipData clip) {
        if (needClipBoardIsolate() == true) goto L5;
        return;
    L5:
        ClipDescription description = clip.getDescription();
        if (description != null) goto L9;
        return;
    L9:
        if (description.getExtras() == null) goto L11;
        PersistableBundle extras = new PersistableBundle(description.getExtras());
    L12:
        extras.putString(OBRIC_CLIP_DESCRIPTION_EXTRA_KEY, OBRIC_CLIP_DESCRIPTION_EXTRA_VALUE_OAUTO_DISPLAY);
        description.setExtras(extras);
        return;
    L11:
        extras = new PersistableBundle();
        goto L12
    }

    private static void reportPrimaryClipChanged() {
        ArrayList<WeakReference<ClipboardManager.OnPrimaryClipChangedListener>> r0 = mPrimaryClipChangedListeners;
        monitor-enter(r0);
        int N = mPrimaryClipChangedListeners.size();     // Catch: Throwable -> L20
        if (N > 0) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L20
        return;
    L8:
        Object[] listeners = mPrimaryClipChangedListeners.toArray();     // Catch: Throwable -> L20
        monitor-exit(r0);     // Catch: Throwable -> L20
        int i = 0;
    L12:
        if (i >= listeners.length) goto L19;
        WeakReference<ClipboardManager.OnPrimaryClipChangedListener> ref = (WeakReference) listeners[i];
        if (ref == null) goto L18;
        if (ref.get() == null) goto L18;
        ClipboardManager.OnPrimaryClipChangedListener listener = ref.get();
        listener.onPrimaryClipChanged();
    L18:
        i = i + 1;
        goto L12
    L19:
        return;
    L20:
        th = move-exception;
        throw th;
    }
}
