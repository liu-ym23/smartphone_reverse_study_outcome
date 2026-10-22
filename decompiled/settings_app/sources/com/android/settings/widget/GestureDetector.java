package com.android.settings.widget;

import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import com.obric.olog.OLog;

/* JADX INFO: loaded from: classes.dex */
public abstract class GestureDetector {
    private static final long LONG_PRESS_TIMEOUT = 5000;
    private static final int MSG_TRIGGER_DOUBLE_LONG_PRESS_EVENT = 1;
    private static final String TAG = "GestureDetector";
    private Handler mHandler;

    public abstract void onDoublePointLongPress();

    public GestureDetector() {
        final Looper r1 = Looper.getMainLooper();
        this.mHandler = new AnonymousClass1(this, r1);
    }

    public boolean dispatchTouchEvent(MotionEvent r6) {
        if (r6.getAction() == 2) goto L5;
        OLog.d(TAG, "event.getAction() " + r6.getAction());
        OLog.d(TAG, "event.getActionMasked() " + r6.getActionMasked());
        OLog.d(TAG, "event.getActionIndex() " + r6.getActionIndex());
    L5:
        int r0 = r6.getActionMasked();
        boolean r3 = false;
        if (r0 != 1) goto L8;
    L20:
        OLog.d(TAG, "cancel long press event delay");
        this.mHandler.removeMessages(1);
    L22:
        return false;
    L8:
        if (r0 == 3) goto L20;
        if (r0 == 5) goto L15;
        if (r0 != 6) goto L22;
        return true;
    L15:
        if (r6.getActionIndex() != 1) goto L17;
        r3 = true;
    L17:
        if (r3 == false) goto L19;
        OLog.d(TAG, "send long press event delay");
        this.mHandler.sendEmptyMessageDelayed(1, 5000);
        return true;
    L19:
        this.mHandler.removeMessages(1);
        return true;
    }
}
