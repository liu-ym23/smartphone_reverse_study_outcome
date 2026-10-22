package com.bytedance.common.wschannel.app;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.common.wschannel.m;

/* JADX INFO: loaded from: classes.dex */
public abstract class a extends Service implements WeakHandler.IHandler {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Messenger f3361f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected WeakHandler f3362g;

    /* JADX INFO: renamed from: com.bytedance.common.wschannel.app.a$a, reason: collision with other inner class name */
    class RunnableC0094a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ a f3363f;

        RunnableC0094a(a r1) {
            this.f3363f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.a(this.f3363f);
        }
    }

    public a() {
    }

    static /* synthetic */ void a(a r0) {
        r0.b();
    }

    private void b() {
        m.j(getApplication(), null);
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message r1) {
    }

    @Override // android.app.Service
    public IBinder onBind(Intent r2) {
        Logger.d("AbsMessengerService", "onBind " + this);
        return this.f3361f.getBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        com.bytedance.common.utility.m.c.c(new RunnableC0094a(this));
        Logger.d("AbsMessengerService", "onCreate " + this);
        this.f3362g = new WeakHandler(this);
        this.f3361f = new Messenger(this.f3362g);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent r3) {
        Logger.d("AbsMessengerService", "onUnBind " + this);
        return super.onUnbind(r3);
    }
}
