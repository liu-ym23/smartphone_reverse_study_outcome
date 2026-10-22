package com.bytedance.common.wschannel.server;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.SocketHandler;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.client.AbsWsClientService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class ClientMsgSender {
    private final ISender mSender;
    private final Class<? extends AbsWsClientService> mTargetServiceClass;

    /* JADX INFO: renamed from: com.bytedance.common.wschannel.server.ClientMsgSender$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public class DefaultSender implements ISender {
        private final Context mContext;
        final /* synthetic */ ClientMsgSender this$0;

        public DefaultSender(ClientMsgSender r1, Context r2) {
            this.this$0 = r1;
            this.mContext = r2;
        }

        @Override // com.bytedance.common.wschannel.server.ClientMsgSender.ISender
        public void sendMsg(Intent r4) {
            r4.setComponent(new ComponentName(this.mContext, ClientMsgSender.access$000(this.this$0)));     // Catch: Throwable -> L4
            this.mContext.startService(r4);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            th.printStackTrace();
        }

        @Override // com.bytedance.common.wschannel.server.ClientMsgSender.ISender
        public void tryResendMsg() {
        }
    }

    public interface ISender {
        void sendMsg(Intent r1);

        void tryResendMsg();
    }

    public class OSender implements ISender {
        private final Runnable mBindServiceTimeoutRunnable;
        private boolean mBinding;
        private final Context mContext;
        private final Runnable mDisconnectRunnable;
        private final Object mLock;
        final AtomicInteger mMsgCount;
        private final LinkedBlockingDeque<Intent> mServiceHolderQueue;
        private Messenger service;
        private ServiceConnection serviceConnection;
        final /* synthetic */ ClientMsgSender this$0;

        public class MessengerServiceConnection implements ServiceConnection {
            final /* synthetic */ OSender this$1;

            private MessengerServiceConnection(OSender r1) {
                this.this$1 = r1;
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName r4, IBinder r5) {
                if (Logger.debug() == false) goto L5;
                Logger.d("WsChannelSdk", "onServiceConnected name = " + r4.toString());
            L5:
                Object r0 = OSender.access$100(this.this$1);
                monitor-enter(r0);
                OSender.access$800(this.this$1);     // Catch: Throwable -> L18
                if (r4 == null) goto L20;
                if (r5 == null) goto L20;
                OSender.access$502(this.this$1, new Messenger(r5));     // Catch: Throwable -> L13
                Logger.d("WsChannelSdk", "onServiceConnected set service");     // Catch: Throwable -> L13
                OSender.access$900(this.this$1);     // Catch: Throwable -> L13
            L15:
                Logger.d("WsChannelSdk", "onServiceConnected, set Unbind = false");     // Catch: Throwable -> L18
                OSender.access$202(this.this$1, false);     // Catch: Throwable -> L18
                monitor-exit(r0);     // Catch: Throwable -> L18
                return;
            L13:
                th = move-exception;
                th.printStackTrace();     // Catch: Throwable -> L18
            L20:
                monitor-exit(r0);     // Catch: Throwable -> L18
                return;
            L18:
                th = move-exception;
                throw th;
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName r4) {
                if (Logger.debug() == false) goto L5;
                Logger.d("WsChannelSdk", "onServiceDisconnected name = " + r4.toString());
            L5:
                Object r0 = OSender.access$100(this.this$1);
                monitor-enter(r0);
                if (r4 != null) goto L12;
                monitor-exit(r0);     // Catch: Throwable -> L10
                return;
            L12:
                Logger.d("WsChannelSdk", "onServiceDisconnected set service = null");     // Catch: Throwable -> L10
                OSender.access$502(this.this$1, null);     // Catch: Throwable -> L10
                OSender.access$302(this.this$1, null);     // Catch: Throwable -> L10
                Logger.d("WsChannelSdk", "onServiceDisconnected, set Unbind = false");     // Catch: Throwable -> L10
                OSender.access$202(this.this$1, false);     // Catch: Throwable -> L10
                OSender.access$700(this.this$1);     // Catch: Throwable -> L10
                OSender.access$800(this.this$1);     // Catch: Throwable -> L10
                monitor-exit(r0);     // Catch: Throwable -> L10
                return;
            L10:
                th = move-exception;
                throw th;
            }

            public /* synthetic */ MessengerServiceConnection(OSender r1, AnonymousClass1 r2) {
                this(r1);
            }
        }

        public OSender(ClientMsgSender r2, Context r3) {
            this.this$0 = r2;
            this.mServiceHolderQueue = new LinkedBlockingDeque();
            this.mBinding = false;
            this.mLock = new Object();
            this.mBindServiceTimeoutRunnable = new AnonymousClass1(this);
            this.mDisconnectRunnable = new AnonymousClass2(this);
            this.mMsgCount = new AtomicInteger(0);
            this.mContext = r3;
        }

        public static /* synthetic */ Object access$100(OSender r0) {
            return r0.mLock;
        }

        public static /* synthetic */ boolean access$200(OSender r0) {
            return r0.mBinding;
        }

        public static /* synthetic */ boolean access$202(OSender r0, boolean r1) {
            r0.mBinding = r1;
            return r1;
        }

        public static /* synthetic */ ServiceConnection access$300(OSender r0) {
            return r0.serviceConnection;
        }

        public static /* synthetic */ ServiceConnection access$302(OSender r0, ServiceConnection r1) {
            r0.serviceConnection = r1;
            return r1;
        }

        public static /* synthetic */ Context access$400(OSender r0) {
            return r0.mContext;
        }

        public static /* synthetic */ Messenger access$502(OSender r0, Messenger r1) {
            r0.service = r1;
            return r1;
        }

        public static /* synthetic */ void access$700(OSender r0) {
            r0.removeTimeout();
        }

        public static /* synthetic */ void access$800(OSender r0) {
            r0.removeSendBindServiceTimeout();
        }

        public static /* synthetic */ void access$900(OSender r0) {
            r0.onServiceConnected();
        }

        private void doBindService() {
            if (Logger.debug() == false) goto L14;
            Logger.d("WsChannelSdk", "doBindService");
        L14:
            this.mContext.startService(new Intent(this.mContext, ClientMsgSender.access$000(this.this$0)));     // Catch: Throwable -> L11
        L12:
            this.serviceConnection = new MessengerServiceConnection(this, null);     // Catch: Throwable -> L8
            this.mContext.bindService(new Intent(this.mContext, ClientMsgSender.access$000(this.this$0)), this.serviceConnection, 1);     // Catch: Throwable -> L8
            sendBindServiceTimeout();     // Catch: Throwable -> L8
            this.mBinding = true;     // Catch: Throwable -> L8
            Logger.d("WsChannelSdk", "doBindService, set mBinding = true");     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            removeSendBindServiceTimeout();
            this.mBinding = false;
            Logger.d("WsChannelSdk", "doBindService error, set Unbind = false");
            th.printStackTrace();
        }

        private void onServiceConnected() {
        L18:
        L11:
            th = move-exception;
            th.printStackTrace();
            return;
        L3:
            if (this.mServiceHolderQueue.peek() == null) goto L14;
            Intent r0 = this.mServiceHolderQueue.poll();     // Catch: Throwable -> L11
            if (r0 == null) goto L6;
            send(r0);     // Catch: Throwable -> L9 DeadObjectException -> L13
        L13:
            Logger.d("WsChannelSdk", "onServiceConnected DeadObjectException");     // Catch: Throwable -> L11
            this.service = null;     // Catch: Throwable -> L11
            this.mServiceHolderQueue.offerFirst(r0);     // Catch: Throwable -> L11
        L9:
            th = move-exception;
            th.printStackTrace();     // Catch: Throwable -> L11
            goto L18
        L6:
            return;
        L14:
            sendTimeout();     // Catch: Throwable -> L11
        }

        private void removeSendBindServiceTimeout() {
            SocketHandler.inst().getHandler().removeCallbacks(this.mBindServiceTimeoutRunnable);
        }

        private void removeTimeout() {
            SocketHandler.inst().getHandler().removeCallbacks(this.mDisconnectRunnable);     // Catch: Exception -> L4
            return;
        L4:
            e = move-exception;
            e.printStackTrace();
        }

        private void send(Intent r4) {
            if (r4 != null) goto L5;
            return;
        L5:
            if (Logger.debug() == false) goto L7;
            Logger.d("WsChannelSdk", "sendMsg msg = " + r4);
        L7:
            Messenger r3 = this.service;
            Message r0 = new Message();
            r0.what = WsConstants.MSG_INTENT;
            r0.getData().putParcelable(WsConstants.DATA_INTENT, r4);
            if (r3 != null) goto L10;
            return;
        L10:
            r3.send(r0);
        }

        private void sendBindServiceTimeout() {
            removeSendBindServiceTimeout();
            SocketHandler.inst().getHandler().postDelayed(this.mBindServiceTimeoutRunnable, TimeUnit.SECONDS.toMillis(7));
        }

        private synchronized void sendTimeout() {
            monitor-enter(this);
            removeTimeout();     // Catch: Throwable -> L6
            SocketHandler.inst().getHandler().postDelayed(this.mDisconnectRunnable, TimeUnit.SECONDS.toMillis(10));     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        @Override // com.bytedance.common.wschannel.server.ClientMsgSender.ISender
        public void sendMsg(Intent r4) {
            if (r4 != null) goto L5;
            return;
        L5:
            if (Logger.debug() == false) goto L7;
            r4.putExtra(WsConstants.MSG_COUNT, this.mMsgCount.addAndGet(1));
        L7:
            Object r0 = this.mLock;
            monitor-enter(r0);
            removeTimeout();     // Catch: Throwable -> L15
            this.mServiceHolderQueue.offer(r4);     // Catch: Throwable -> L15
            if (this.service == null) goto L12;
            onServiceConnected();     // Catch: Throwable -> L15
        L19:
            monitor-exit(r0);     // Catch: Throwable -> L15
            return;
        L12:
            if (this.mBinding == false) goto L17;
            monitor-exit(r0);     // Catch: Throwable -> L15
            return;
        L17:
            doBindService();     // Catch: Throwable -> L15
        L15:
            th = move-exception;
            throw th;
        }

        @Override // com.bytedance.common.wschannel.server.ClientMsgSender.ISender
        public void tryResendMsg() {
            if (this.mServiceHolderQueue.size() > 0) goto L5;
            return;
        L5:
            if (this.service != null) goto L22;
            Logger.d("WsChannelSdk", "tryResendMsg try reconnect");
            Object r0 = this.mLock;
            monitor-enter(r0);
        L13:
            th = move-exception;
            throw th;
        L9:
            if (this.mServiceHolderQueue.size() > 0) goto L11;
        L15:
            monitor-exit(r0);     // Catch: Throwable -> L13
            return;
        L11:
            if (this.service != null) goto L15;
            doBindService();     // Catch: Throwable -> L13
            goto L15
        }
    }

    public ClientMsgSender(Context r3, Class<? extends AbsWsClientService> r4) {
        if (r3.getApplicationInfo().targetSdkVersion < 26) goto L5;
        this.mSender = new OSender(this, r3);
    L6:
        this.mTargetServiceClass = r4;
        return;
    L5:
        this.mSender = new DefaultSender(this, r3);
        goto L6
    }

    public static /* synthetic */ Class access$000(ClientMsgSender r0) {
        return r0.mTargetServiceClass;
    }

    public void sendMsg(Intent r1) {
        this.mSender.sendMsg(r1);
    }

    public void tryResendMsg() {
        this.mSender.tryResendMsg();
    }
}
