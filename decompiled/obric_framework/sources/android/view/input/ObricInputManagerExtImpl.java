package android.view.input;

import android.app.ITopActivityAssistDataReceiver;
import android.hardware.input.InputManagerGlobal;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class ObricInputManagerExtImpl implements IObricInputManagerExt {
    private static final String TAG = "ObricInputManagerExtImpl";

    public ObricInputManagerExtImpl() {
    }

    public void registerInjectEventResponseListener(ITopActivityAssistDataReceiver receiver) {
        InputManagerGlobal.getInstance().getInputManagerService().getIObricExt().registerInjectEventResponseListener(receiver);     // Catch: Throwable -> L4
        return;
    L4:
        t = move-exception;
        Log.e(TAG, "registerInjectEventResponseListener failed: ", t);
    }

    public void unregisterInjectEventResponseListener(ITopActivityAssistDataReceiver receiver) {
        InputManagerGlobal.getInstance().getInputManagerService().getIObricExt().unregisterInjectEventResponseListener(receiver);     // Catch: Throwable -> L4
        return;
    L4:
        t = move-exception;
        Log.e(TAG, "unregisterInjectEventResponseListener failed", t);
    }
}
