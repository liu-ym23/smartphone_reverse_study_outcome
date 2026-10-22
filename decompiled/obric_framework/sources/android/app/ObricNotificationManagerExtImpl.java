package android.app;

import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Slog;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class ObricNotificationManagerExtImpl implements IObricNotificationManagerExt {
    private static final String TAG = "ObricNotificationManagerExtImpl";
    private static final Handler mHandler = null;
    private final IObricToastShowListener mToastShowListener;
    private final ArrayList<ObricNotificationManager.OnToastShowListener> mToastShowListeners;

    /* JADX INFO: renamed from: android.app.ObricNotificationManagerExtImpl$1, reason: invalid class name */
    class AnonymousClass1 extends IObricToastShowListener.Stub {
        final /* synthetic */ ObricNotificationManagerExtImpl this$0;

        /* JADX INFO: renamed from: $r8$lambda$sKLk7ClAuwT589x-31iEeCS_CNA, reason: not valid java name */
        public static /* synthetic */ void m3$r8$lambda$sKLk7ClAuwT589x31iEeCS_CNA(AnonymousClass1 r0, TransientUI r1) {
            r0.lambda$onToastShow$0(r1);
        }

        AnonymousClass1(ObricNotificationManagerExtImpl this$0) {
            this.this$0 = this$0;
        }

        public void onToastShow(final TransientUI transientUI) {
            ObricNotificationManagerExtImpl.m2$$Nest$sfgetmHandler().post(new ObricNotificationManagerExtImpl$1$$ExternalSyntheticLambda0(this, transientUI));
        }

        private /* synthetic */ void lambda$onToastShow$0(TransientUI transientUI) {
            ObricNotificationManagerExtImpl.m1$$Nest$mreportToastShow(this.this$0, transientUI);
        }
    }

    /* JADX INFO: renamed from: -$$Nest$mreportToastShow, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1$$Nest$mreportToastShow(ObricNotificationManagerExtImpl r0, TransientUI r1) {
        r0.reportToastShow(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m2$$Nest$sfgetmHandler() {
        return mHandler;
    }

    public ObricNotificationManagerExtImpl() {
        this.mToastShowListeners = new ArrayList();
        this.mToastShowListener = new AnonymousClass1(this);
    }

    static {
        mHandler = new Handler(Looper.getMainLooper());
    }

    public boolean registerNotificationListener(IObricNotificationListener listener) {
        return NotificationManager.getService().getIObricExt().registerNotificationListener(listener);
    L5:
        return false;
    }

    public boolean unregisterNotificationListener(IObricNotificationListener listener) {
        return NotificationManager.getService().getIObricExt().unregisterNotificationListener(listener);
    L5:
        return false;
    }

    public boolean isPanelShown() {
        return NotificationManager.getService().getIObricExt().isPanelShown();
    L4:
        e = move-exception;
        Slog.e(TAG, "isPanelShown: RemoteException", e);
        return false;
    }

    public void unregisterToastShowListener(ObricNotificationManager.OnToastShowListener listener) {
        ArrayList<ObricNotificationManager.OnToastShowListener> r0 = this.mToastShowListeners;
        monitor-enter(r0);
        this.mToastShowListeners.remove(listener);     // Catch: Throwable -> L13
        if (this.mToastShowListeners.isEmpty() == true) goto L17;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L17:
        NotificationManager.getService().getIObricExt().unregisterToastShowListener(this.mToastShowListener);     // Catch: RemoteException -> L8 Throwable -> L13
    L8:
        e = move-exception;
        throw e.rethrowFromSystemServer();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    public void registerToastShowListener(ObricNotificationManager.OnToastShowListener listener) {
        ArrayList<ObricNotificationManager.OnToastShowListener> r0 = this.mToastShowListeners;
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.mToastShowListeners.isEmpty() == true) goto L18;
    L11:
        this.mToastShowListeners.add(listener);     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L18:
        NotificationManager.getService().getIObricExt().registerToastShowListener(this.mToastShowListener);     // Catch: RemoteException -> L8 Throwable -> L14
    L8:
        e = move-exception;
        throw e.rethrowFromSystemServer();     // Catch: Throwable -> L14
    }

    private void reportToastShow(TransientUI transientUI) {
        ArrayList<ObricNotificationManager.OnToastShowListener> r0 = this.mToastShowListeners;
        monitor-enter(r0);
        int N = this.mToastShowListeners.size();     // Catch: Throwable -> L15
        if (N > 0) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L15
        return;
    L8:
        Object[] listeners = this.mToastShowListeners.toArray();     // Catch: Throwable -> L15
        monitor-exit(r0);     // Catch: Throwable -> L15
        int i = 0;
    L12:
        if (i >= listeners.length) goto L14;
        ((ObricNotificationManager.OnToastShowListener) listeners[i]).onToastShow(transientUI);
        i = i + 1;
        goto L12
    L14:
        return;
    L15:
        th = move-exception;
        throw th;
    }
}
