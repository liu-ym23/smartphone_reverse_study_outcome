package com.ss.android.message.log;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.ArrayUtils;
import com.bytedance.common.utility.collection.WeakHandler;
import com.ss.android.pushmanager.app.MessageAppHooks;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes4.dex */
public class LogService extends Service implements WeakHandler.IHandler {
    public static final int MSG_END_LOG = 2;
    public static final int MSG_GET_LOG = 0;
    public static final int MSG_LOG_HANDLED = 1;
    public static final int PAGE_COUNT = 5;
    private DBHelper mDBHelper;
    private HandlerThread mHandlerThread;
    private Messenger mMessenger;

    public LogService() {
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent r3) {
        Logger.d("PushLog", "onUnBind " + this);
        return super.onUnbind(r3);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent r2) {
        Logger.d("PushLog", "onBind " + this);
        return this.mMessenger.getBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        Logger.d("PushLog", "onCreate " + this);
        MessageAppHooks.InitHook r0 = MessageAppHooks.getInitHook();     // Catch: Throwable -> L9
        if (r0 == null) goto L6;
        r0.tryInit(this);     // Catch: Throwable -> L9
    L6:
        HandlerThread r1 = new HandlerThread("LogService");
        this.mHandlerThread = r1;
        r1.start();
        this.mMessenger = new Messenger(new WeakHandler(this.mHandlerThread.getLooper(), this));
        this.mDBHelper = DBHelper.getInstance(this);     // Catch: Throwable -> L10
        return;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        DBHelper.closeDB();
        HandlerThread r0 = this.mHandlerThread;
        if (r0 == null) goto L6;
        r0.quit();
        return;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent r1, int r2, int r3) {
        return super.onStartCommand(r1, r2, r3);
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message r12) {
        Logger.d("PushLog", "handleMsg msg.what = " + r12.what);     // Catch: Throwable -> L35
        int r4 = r12.what;     // Catch: Throwable -> L35
        int r5 = 0;
        if (r4 == 0) goto L19;
        if (r4 == 1) goto L8;
        return;
    L8:
        if (r12.replyTo == null) goto L41;
        Messenger r0 = r12.replyTo;     // Catch: Throwable -> L35
        long[] r13 = ((Bundle) r12.obj).getLongArray("event_ids");     // Catch: Throwable -> L35
        if (r13 == null) goto L42;
        Logger.d("PushLog", "event_ids = " + ArrayUtils.toList(r13));     // Catch: Throwable -> L35
        if (this.mDBHelper != null) goto L15;
        r0.send(Message.obtain(null, 2));     // Catch: Throwable -> L35
        return;
    L15:
        int r1 = r13.length;     // Catch: Throwable -> L35
    L16:
        if (r5 >= r1) goto L45;
        this.mDBHelper.deleteEvent(r13[r5]);     // Catch: Throwable -> L35
        r5 = r5 + 1;     // Catch: Throwable -> L35
        goto L16
    L45:
        return;
    L42:
        return;
    L41:
        return;
    L19:
        if (r12.replyTo == null) goto L43;
        Messenger r3 = r12.replyTo;     // Catch: Throwable -> L35
        long r9 = ((Bundle) r12.obj).getLong("start_id", 0);     // Catch: Throwable -> L35
        DBHelper r11 = this.mDBHelper;     // Catch: Throwable -> L35
        if (r11 != null) goto L24;
        r3.send(Message.obtain(null, 2));     // Catch: Throwable -> L35
        return;
    L24:
        JSONArray r14 = r11.getEvents(r9, 5);     // Catch: Throwable -> L35
        if (r14 != null) goto L28;
        r3.send(Message.obtain(null, 2));     // Catch: Throwable -> L35
        return;
    L28:
        Message r6 = Message.obtain(null, 0);     // Catch: Throwable -> L35
        Bundle r7 = new Bundle();     // Catch: Throwable -> L35
        r7.putString("events", r14.toString());     // Catch: Throwable -> L35
        if (r14.length() < 5) goto L32;
        r7.putBoolean("has_more", true);     // Catch: Throwable -> L35
    L33:
        Logger.d("PushLog", "events = " + r7.get("events") + " has_more = " + r7.get("has_more"));     // Catch: Throwable -> L35
        r6.obj = r7;     // Catch: Throwable -> L35
        r3.send(r6);     // Catch: Throwable -> L35
        return;
    L32:
        r7.putBoolean("has_more", false);     // Catch: Throwable -> L35
        goto L33
    L43:
        return;
    L35:
        th = move-exception;
        th.printStackTrace();
    }
}
