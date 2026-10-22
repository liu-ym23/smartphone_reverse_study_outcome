package com.bytedanceos.preventdisturb;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.widget.Toast;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes2.dex */
public class ToastUtils {
    private static final long TOAST_TIME = 2100;
    private static ConcurrentLinkedQueue<CharSequence> mTextQueue;
    private static Context sContext;
    private static ToastHandler sHandler;
    private static Toast sToast;

    private static class ToastHandler extends Handler {
        static final int MSG_SHOW_TOAST = 2016;
        static final int MSG_TOAST_TIMEOUT = 2017;

        public ToastHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            int r3 = msg.what;
            if (r3 == MSG_SHOW_TOAST) goto L8;
            if (r3 != MSG_TOAST_TIMEOUT) goto L16;
            ToastUtils.access$100().sendEmptyMessage(MSG_SHOW_TOAST);
            return;
        L16:
            return;
        L8:
            if (hasMessages(MSG_TOAST_TIMEOUT) == true) goto L14;
            CharSequence r4 = (CharSequence) ToastUtils.access$000().poll();
            if (TextUtils.isEmpty(r4) == true) goto L15;
            showInternal(r4);
            return;
        L15:
            return;
        }

        private void showInternal(CharSequence text) {
            ToastUtils.access$200().setText(text);
            ToastUtils.access$200().show();
            removeMessages(MSG_TOAST_TIMEOUT);
            sendEmptyMessageDelayed(MSG_TOAST_TIMEOUT, ToastUtils.TOAST_TIME);
        }
    }

    public ToastUtils() {
    }

    static /* synthetic */ ConcurrentLinkedQueue access$000() {
        return mTextQueue;
    }

    static /* synthetic */ ToastHandler access$100() {
        return sHandler;
    }

    static /* synthetic */ Toast access$200() {
        return sToast;
    }

    public static void init(Context context) {
        sContext = context.getApplicationContext();
        sHandler = new ToastHandler(Looper.getMainLooper());
        sToast = Toast.makeText(sContext, "", 0);
        mTextQueue = new ConcurrentLinkedQueue();
    }

    public static void show(int resId) {
        show(sContext.getText(resId));
    }

    public static void show(final CharSequence text) {
        if (TextUtils.isEmpty(text) == false) goto L6;
        return;
    L6:
        if (TextUtils.equals(text, mTextQueue.peek()) == true) goto L9;
        mTextQueue.add(text);
        sHandler.sendEmptyMessage(2016);
        return;
    }
}
