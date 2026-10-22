package com.bytedance.bdinstall.oaid;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.bytedance.bdinstall.DrLog;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes3.dex */
final class ServiceBlockBinder<SERVICE, RESULT> {
    private final CountDownLatch latch;
    private final Context mContext;
    private final Intent mIntent;
    private final ServiceBindedListener<SERVICE, RESULT> mListener;

    class Conn implements ServiceConnection {
        private final CountDownLatch latch;
        private final ServiceBindedListener<SERVICE, RESULT> mListener;
        SERVICE service;
        final /* synthetic */ ServiceBlockBinder this$0;

        @Override // android.content.ServiceConnection
        public void onBindingDied(ComponentName r1) {
        }

        @Override // android.content.ServiceConnection
        public void onNullBinding(ComponentName r1) {
        }

        Conn(ServiceBlockBinder r1, CountDownLatch r2, ServiceBindedListener<SERVICE, RESULT> r3) {
            this.this$0 = r1;
            this.latch = r2;
            this.mListener = r3;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName r4, IBinder r5) {
            DrLog.d("Oaid#ServiceBlockBinder#onServiceConnected " + r4);
            this.service = this.mListener.asInterface(r5);     // Catch: Throwable -> L8
            this.latch.countDown();     // Catch: Exception -> L6
        L24:
            return;
        L8:
            th = move-exception;
            th.printStackTrace();     // Catch: Throwable -> L12
            DrLog.d("Oaid#ServiceBlockBinder#onServiceConnected #Throwable " + th);     // Catch: Throwable -> L12
            this.latch.countDown();     // Catch: Exception -> L6
        L12:
            th = move-exception;
            this.latch.countDown();     // Catch: Exception -> L15
        L17:
            throw th;
        L15:
            e = move-exception;
            e.printStackTrace();
        L6:
            e = move-exception;
            e.printStackTrace();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName r3) {
            DrLog.d("Oaid#ServiceBlockBinder#onServiceDisconnected" + r3);
            this.latch.countDown();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            e.printStackTrace();
        }
    }

    interface ServiceBindedListener<T, RESULT> {
        T asInterface(IBinder r1);

        RESULT fetchResult(T r1) throws Exception;
    }

    ServiceBlockBinder(Context r1, Intent r2, ServiceBindedListener<SERVICE, RESULT> r3) {
        this.mContext = r1;
        this.mIntent = r2;
        this.mListener = r3;
        this.latch = new CountDownLatch(1);
    }

    RESULT blockFetchResult() {
        ServiceBlockBinder<SERVICE, RESULT>.Conn r1 = new Conn(this, this.latch, this.mListener);     // Catch: Throwable -> L12
        if (this.mContext.bindService(this.mIntent, r1, 1) == false) goto L11;
        this.latch.await();     // Catch: Throwable -> L12
        RESULT r0 = this.mListener.fetchResult(r1.service);     // Catch: Throwable -> L9
        release(r1);
        return r0;
    L9:
        th = th;
    L20:
        th.printStackTrace();     // Catch: Throwable -> L17
        release(r1);
    L16:
        return null;
    L17:
        th = move-exception;
        release(r1);
        throw th;
    L11:
        release(null);
    L12:
        th = th;
        r1 = null;
        goto L20
    }

    private void release(ServiceBlockBinder<SERVICE, RESULT>.Conn r1) {
        if (r1 == null) goto L10;
        this.mContext.unbindService(r1);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
        return;
    }
}
