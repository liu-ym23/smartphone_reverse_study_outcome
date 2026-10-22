package com.ss.android.pushmanager.client;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.utility.collection.ArrayUtils;
import com.bytedance.common.utility.collection.WeakHandler;
import com.ss.android.message.log.PushLog;
import com.ss.android.pushmanager.app.MessageAppHooks;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class MessageLogClient implements WeakHandler.IHandler {
    private static final String LOG_SERVICE = "com.ss.android.message.log.LogService";
    private static MessageLogClient sMessageLogClient;
    private ServiceConnection mConnection;
    private WeakReference<Context> mContextRef;
    private final Handler mHandler;
    private final Messenger mMessenger;
    private Messenger mService;
    private long mStartId;

    static {
    }

    static /* synthetic */ Messenger access$002(MessageLogClient r0, Messenger r1) {
        r0.mService = r1;
        return r1;
    }

    static /* synthetic */ void access$100(MessageLogClient r0) {
        r0.getMessageLog();
    }

    public static void start(Context r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        MessageLogClient r0 = sMessageLogClient;
        if (r0 != null) goto L8;
        sMessageLogClient = new MessageLogClient(r1);
        return;
    L8:
        if (r0.mService != null) goto L12;
        r0.doBindService();
        return;
    }

    public static void end(Context r0) {
        if (r0 != null) goto L4;
        return;
    L4:
        MessageLogClient r1 = sMessageLogClient;
        if (r1 == null) goto L8;
        r1.doUnbindService();
        return;
    }

    private MessageLogClient(Context r3) {
        this.mService = null;
        WeakHandler r0 = new WeakHandler(this);
        this.mHandler = r0;
        this.mMessenger = new Messenger(r0);
        this.mStartId = 0;
        this.mConnection = new AnonymousClass1(this);
        this.mContextRef = new WeakReference(r3.getApplicationContext());
        doBindService();
    }

    private void doBindService() {
        WeakReference<Context> r0 = this.mContextRef;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.get() == null) goto L13;
        Intent r1 = new Intent();     // Catch: Throwable -> L9
        r1.setComponent(new ComponentName(this.mContextRef.get(), LOG_SERVICE));     // Catch: Throwable -> L9
        this.mContextRef.get().bindService(r1, this.mConnection, 1);     // Catch: Throwable -> L9
        return;
    L14:
        return;
    }

    private void doUnbindService() {
        if (this.mService != null) goto L5;
        return;
    L5:
        if (this.mContextRef.get() == null) goto L12;
        this.mContextRef.get().unbindService(this.mConnection);     // Catch: Throwable -> L8
        return;
    L12:
        return;
    }

    private void hanldeEnd() {
        if (Logger.debug() == false) goto L6;
        Logger.d("PushLog", "hanldeEnd");
    L6:
        if (this.mService == null) goto L12;
        doUnbindService();     // Catch: Exception -> L9
        this.mService = null;     // Catch: Exception -> L9
        return;
    L13:
        return;
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message r20) {
    L52:
        th = move-exception;
        th.printStackTrace();
        return;
    L5:
        if (Logger.debug() == false) goto L7;
        Logger.d("PushLog", "msg.what = " + r20.what);     // Catch: Throwable -> L52
    L7:
        int r3 = r20.what;     // Catch: Throwable -> L52
        if (r3 == 0) goto L17;
        if (r3 == 2) goto L13;
        return;
    L13:
        if (Logger.debug() == false) goto L15;
        Logger.d("PushLog", "MSG_END_LOG");     // Catch: Throwable -> L52
    L15:
        hanldeEnd();     // Catch: Throwable -> L52
        return;
    L17:
        if (MessageAppHooks.getPushHook() != null) goto L20;
        Logger.e("PushLog", "PushHook is null");     // Catch: Throwable -> L52
        return;
    L20:
        Bundle r1 = (Bundle) r20.obj;     // Catch: Throwable -> L52
        String r4 = r1.getString("events");     // Catch: Throwable -> L52
        boolean r2 = r1.getBoolean("has_more");     // Catch: Throwable -> L52
        if (Logger.debug() == false) goto L24;
        Logger.d("PushLog", "events = " + r4 + " has_more = " + r2);     // Catch: Throwable -> L52
    L24:
        if (StringUtils.isEmpty(r4) == true) goto L48;
        ArrayList r5 = new ArrayList();     // Catch: Throwable -> L52
        JSONArray r6 = new JSONArray(r4);     // Catch: Throwable -> L52
        int r7 = r6.length();     // Catch: Throwable -> L52
        int r8 = 0;
    L26:
        if (r8 >= r7) goto L46;
        JSONObject r9 = r6.optJSONObject(r8);     // Catch: Throwable -> L52
        if (r9 != null) goto L30;
        r7 = r7;
    L44:
        r8 = r8 + 1;     // Catch: Throwable -> L52
        r7 = r7;
        goto L26
    L30:
        String r11 = r9.optString("category");     // Catch: Throwable -> L52
        String r12 = r9.optString(PushLog.KEY_TAG);     // Catch: Throwable -> L52
        String r13 = r9.optString(PushLog.KEY_LABEL);     // Catch: Throwable -> L52
        long r14 = r9.optLong("value");     // Catch: Throwable -> L52
        long r16 = r9.optLong(PushLog.KEY_EXT_VALUE);     // Catch: Throwable -> L52
        String r10 = r9.optString(PushLog.KEY_EXT_JSON);     // Catch: Throwable -> L52
        if (TextUtils.isEmpty(r10) == false) goto L56;
    L34:
        JSONObject r15 = null;
    L35:
        JSONObject r17 = r15;
        if (Logger.debug() == false) goto L40;
        Logger.d("PushLog", "handleMsg: tag = " + r12 + " label = " + r13 + " ext_json_str = " + r10 + " ext_json = " + r17);     // Catch: Throwable -> L52
    L40:
        MessageAppHooks.getPushHook().onEvent(this.mContextRef.get(), r11, r12, r13, r14, r16, r17);     // Catch: Throwable -> L52
        long r18 = r9.optLong("_id");     // Catch: Throwable -> L52
        if (r18 <= this.mStartId) goto L43;
        this.mStartId = r18;     // Catch: Throwable -> L52
    L43:
        r5.add(Long.valueOf(r18));     // Catch: Throwable -> L52
        goto L44
    L56:
        r15 = new JSONObject(r10);     // Catch: Exception -> L55 Throwable -> L52
    L46:
        if (r5.size() <= 0) goto L48;
        sendHanledMsg(r5);     // Catch: Throwable -> L52
    L48:
        if (r2 == false) goto L50;
        getMessageLog();     // Catch: Throwable -> L52
        return;
    L50:
        hanldeEnd();     // Catch: Throwable -> L52
    }

    private void getMessageLog() {
        Message r1 = Message.obtain(null, 0);     // Catch: Throwable -> L8
        r1.replyTo = this.mMessenger;     // Catch: Throwable -> L8
        Bundle r2 = new Bundle();     // Catch: Throwable -> L8
        r2.putLong("start_id", this.mStartId);     // Catch: Throwable -> L8
        if (Logger.debug() == false) goto L6;
        Logger.d("PushLog", "start_id = " + this.mStartId);     // Catch: Throwable -> L8
    L6:
        r1.obj = r2;     // Catch: Throwable -> L8
        this.mService.send(r1);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        th.printStackTrace();
        hanldeEnd();
    }

    private void sendHanledMsg(List<Long> r6) {
        if (r6 != null) goto L5;
        return;
    L5:
        if (r6.size() > 0) goto L16;
        return;
    L16:
        Message r1 = Message.obtain(null, 1);     // Catch: Throwable -> L13
        r1.replyTo = this.mMessenger;     // Catch: Throwable -> L13
        Bundle r2 = new Bundle();     // Catch: Throwable -> L13
        r2.putLongArray("event_ids", ArrayUtils.toLongArray(r6));     // Catch: Throwable -> L13
        if (Logger.debug() == false) goto L11;
        Logger.d("PushLog", "event_ids = " + r6);     // Catch: Throwable -> L13
    L11:
        r1.obj = r2;     // Catch: Throwable -> L13
        this.mService.send(r1);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        th.printStackTrace();
        hanldeEnd();
    }
}
