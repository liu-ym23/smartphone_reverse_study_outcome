package s8;

import android.content.Context;
import android.content.Intent;
import android.os.DeadObjectException;
import android.os.Message;
import android.os.Messenger;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import ym.p;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f21842a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Messenger f21843b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinkedBlockingDeque f21844c;
    public m8.c d;
    public boolean e;
    public final Object f;
    public final c g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final c f21845h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AtomicInteger f21846i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ p f21847j;

    public d(p r5, Context r10) {
        this.f21847j = r5;
        this.f21844c = new LinkedBlockingDeque();
        this.e = false;
        this.f = new Object();
        this.g = new c(this, 0);
        this.f21845h = new c(this, 1);
        this.f21846i = new AtomicInteger(0);
        this.f21842a = r10;
    }

    @Override // s8.b
    /* JADX INFO: renamed from: a */
    public final void mo1705a() {
        if (this.f21844c.size() > 0) goto L5;
        return;
    L5:
        if (this.f21843b != null) goto L22;
        Logger.d("WsChannelSdk", "tryResendMsg try reconnect");
        Object r5 = this.f;
        monitor-enter(r5);
    L13:
        th = move-exception;
        throw th;
    L9:
        if (this.f21844c.size() > 0) goto L11;
    L15:
        monitor-exit(r5);     // Catch: Throwable -> L13
        return;
    L11:
        if (this.f21843b != null) goto L15;
        b();     // Catch: Throwable -> L13
        goto L15
    }

    public final void b() {
        p r5 = this.f21847j;
        Context r10 = this.f21842a;
        if (Logger.debug() == false) goto L14;
        Logger.d("WsChannelSdk", "doBindService");
    L14:
        r10.startService(new Intent(r10, (Class) r5.f23313c));     // Catch: Throwable -> L11
    L12:
        this.d = new m8.c(this, 1);     // Catch: Throwable -> L8
        r10.bindService(new Intent(r10, (Class) r5.f23313c), this.d, 1);     // Catch: Throwable -> L8
        f();     // Catch: Throwable -> L8
        g8.d.a().getClass();     // Catch: Throwable -> L8
        g8.d.f17065b.postDelayed(this.g, TimeUnit.SECONDS.toMillis(7));     // Catch: Throwable -> L8
        this.e = true;     // Catch: Throwable -> L8
        Logger.d("WsChannelSdk", "doBindService, set mBinding = true");     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        f();
        this.e = false;
        Logger.d("WsChannelSdk", "doBindService error, set Unbind = false");
        th.printStackTrace();
    }

    public final void c(Intent r5) {
        if (Logger.debug() == false) goto L5;
        Logger.d("WsChannelSdk", "sendMsg msg = " + r5);
    L5:
        Messenger r10 = this.f21843b;
        Message r11 = new Message();
        r11.what = WsConstants.MSG_INTENT;
        r11.getData().putParcelable(WsConstants.DATA_INTENT, r5);
        if (r10 != null) goto L8;
        return;
    L8:
        r10.send(r11);
    }

    @Override // s8.b
    public final void d(Intent r5) {
        if (Logger.debug() == false) goto L5;
        r5.putExtra(WsConstants.MSG_COUNT, this.f21846i.addAndGet(1));
    L5:
        Object r10 = this.f;
        monitor-enter(r10);
        g();     // Catch: Throwable -> L13
        this.f21844c.offer(r5);     // Catch: Throwable -> L13
        if (this.f21843b == null) goto L10;
        e();     // Catch: Throwable -> L13
    L17:
        monitor-exit(r10);     // Catch: Throwable -> L13
        return;
    L10:
        if (this.e == false) goto L15;
        monitor-exit(r10);     // Catch: Throwable -> L13
        return;
    L15:
        b();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    public final void e() {
    L25:
    L11:
        th = move-exception;
        th.printStackTrace();
        return;
    L3:
        if (this.f21844c.peek() == null) goto L14;
        Intent r5 = (Intent) this.f21844c.poll();     // Catch: Throwable -> L11
        if (r5 == null) goto L34;
        c(r5);     // Catch: Throwable -> L9 DeadObjectException -> L13
    L13:
        Logger.d("WsChannelSdk", "onServiceConnected DeadObjectException");     // Catch: Throwable -> L11
        this.f21843b = null;     // Catch: Throwable -> L11
        this.f21844c.offerFirst(r5);     // Catch: Throwable -> L11
    L9:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L11
        goto L25
    L34:
        return;
    L14:
        monitor-enter(this);     // Catch: Throwable -> L11
        g();     // Catch: Throwable -> L18
        g8.d.a().getClass();     // Catch: Throwable -> L18
        g8.d.f17065b.postDelayed(this.f21845h, TimeUnit.SECONDS.toMillis(10));     // Catch: Throwable -> L18
        monitor-exit(this);     // Catch: Throwable -> L11
        return;
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L11
    }

    public final void f() {
        g8.d.a().getClass();
        g8.d.f17065b.removeCallbacks(this.g);
    }

    public final void g() {
        g8.d.a().getClass();     // Catch: Exception -> L4
        g8.d.f17065b.removeCallbacks(this.f21845h);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }
}
