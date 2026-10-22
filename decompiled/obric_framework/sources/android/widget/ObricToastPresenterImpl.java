package android.widget;

import android.app.INotificationManager;
import android.os.IBinder;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class ObricToastPresenterImpl implements IObricToastPresenter {
    public ObricToastPresenterImpl() {
    }

    public ObricToastPresenterImpl(ToastPresenter toastPresenter) {
    }

    public void notifyToastShow(String packageName, IBinder token, INotificationManager notificationManager, View view) {
        if (view != null) goto L15;
        return;
    L15:
        CharSequence text = view.getObricExt().dumpTextFromView();     // Catch: Exception -> L12
        if (text != null) goto L7;
        return;
    L7:
        if (text.length() <= 0) goto L17;
        notificationManager.getIObricExt().onToastShow(packageName, token, text);     // Catch: Exception -> L12
        return;
    L17:
        return;
    L12:
        e = move-exception;
        e.printStackTrace();
    }
}
