package com.bytedance.platform.godzilla.anr.sp;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.bytedance.platform.godzilla.utils.FieldUtils;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes.dex */
public final class QueuedWorkProxyAboveOrEqualsAndroid0 {
    private static final String CLASS_NAME = "android.app.QueuedWork";
    private static final String FILE_NAME_FINISHERS = "sFinishers";
    private static final String FILE_NAME_S_WORK = "sWork";
    private static final String METHOD_NAME_GET_HANDLER = "getHandler";
    private static final int MSG_RUN = 1;
    private static final String TAG = "QueuedWkPyAOrEAndroid0";
    private static Handler sHandlerInQueueWork;
    private static LinkedList<Runnable> sWorkWrapper;

    public static void replacesFinishersAndsWork() {
    }

    static /* synthetic */ void access$000() {
        processPendingWork();
    }

    private QueuedWorkProxyAboveOrEqualsAndroid0() {
    }

    public static void reSendMessageToQueueWork() {
        Handler r0 = sHandlerInQueueWork;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.hasMessages(1) == true) goto L7;
        Log.d("LinkedListForWorks", "Handler in QueuedWork has no MSG_RUN message,so we send one.");
        final Message r1 = Message.obtain(sHandlerInQueueWork);
        r1.what = 1;
        new Handler().post(new AnonymousClass1(r1));
        return;
    L7:
        Log.d("LinkedListForWorks", "Handler in QueuedWork has MSG_RUN message,no need to send one.");
    }

    private static void hooksHandlerInQueueWork(Handler r2) {
        if (r2 != null) goto L14;
        return;
    L14:
        Field r0 = FieldUtils.getField(Class.forName(Handler.class.getName()), "mCallback");     // Catch: ClassNotFoundException -> L9 IllegalAccessException -> L11
        if (r0 != null) goto L7;
        return;
    L7:
        r0.setAccessible(true);     // Catch: ClassNotFoundException -> L9 IllegalAccessException -> L11
        r0.set(r2, new AnonymousClass2());     // Catch: ClassNotFoundException -> L9 IllegalAccessException -> L11
    L17:
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
        return;
    L11:
        e = move-exception;
        e.printStackTrace();
    }

    private static void processPendingWork() {
        if (sHandlerInQueueWork == null) goto L13;
        LinkedList<Runnable> r0 = sWorkWrapper;
        if (r0 == null) goto L16;
        LinkedList r1 = (LinkedList) r0.clone();
        sWorkWrapper.clear();
        sHandlerInQueueWork.removeMessages(1);
        if (r1.size() <= 0) goto L15;
        Iterator r2 = r1.iterator();
    L11:
        if (r2.hasNext() == false) goto L17;
        ((Runnable) r2.next()).run();
        goto L11
    L17:
        return;
    L15:
        return;
    L16:
        return;
    }
}
