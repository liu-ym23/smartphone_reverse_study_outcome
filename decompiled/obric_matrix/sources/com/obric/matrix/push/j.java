package com.obric.matrix.push;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.obric.matrix.account_api.OAccount;
import com.obric.matrix.push_api.IPush;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000-\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\n\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/obric/matrix/push/RestartMgr;", "", "()V", "DELAY", "", "MSG_CHECK_UNLOCK_STATUE", "", "TAG", "", "handler", "com/obric/matrix/push/RestartMgr$handler$1", "Lcom/obric/matrix/push/RestartMgr$handler$1;", "init", "", "initIfNeed", "push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f9609a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final a f9610b = null;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/matrix/push/RestartMgr$handler$1", "Landroid/os/Handler;", "handleMessage", "", NotificationCompat.CATEGORY_MESSAGE, "Landroid/os/Message;", "push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a extends Handler {
        a(Looper r1) {
            super(r1);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r4) {
            o.f(r4, NotificationCompat.CATEGORY_MESSAGE);
            if (r4.what == 101) goto L5;
            return;
        L5:
            if (com.obric.matrix.r.b.f9910a.d() == false) goto L8;
            j.f9609a.c();
            return;
        L8:
            if (com.obric.matrix.r.e.j.c() == false) goto L13;
            Log.d("RestartMgr", "handleMessage: device is not unlocked");
            sendEmptyMessageDelayed(101, 1000);
            return;
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/matrix/push/RestartMgr$init$1", "Lcom/obric/matrix/base/system/ISystemStateListener;", "onScreenStateChanged", "", "on", "", "push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class b implements com.obric.matrix.q.h.d {
        b() {
        }

        @Override // com.obric.matrix.q.h.d
        public void b(boolean r3) {
            if (r3 == false) goto L5;
            j.a().sendEmptyMessageDelayed(101, 1000);
            return;
        L5:
            j.a().removeMessages(101);
        }
    }

    static {
        f9609a = new j();
        f9610b = new a(Looper.getMainLooper());
    }

    private j() {
    }

    public static final /* synthetic */ a a() {
        return f9610b;
    }

    public final void b() {
        if (com.obric.matrix.r.b.f9910a.f() == false) goto L5;
        return;
    L5:
        f9610b.sendEmptyMessage(101);
        if (((IPush) com.bytedance.news.common.service.manager.d.a(IPush.class)).isLockedWhenStart() == false) goto L9;
        com.obric.matrix.q.h.k.l(new b());
        return;
    }

    public final void c() {
        com.obric.matrix.r.c.c.b("RestartMgr", "rebootAppIfNeed: check reboot");
        if (((IPush) com.bytedance.news.common.service.manager.d.a(IPush.class)).isLockedWhenStart() == true) goto L5;
        return;
    L5:
        if (com.obric.matrix.r.b.f9910a.f() == true) goto L10;
        com.obric.matrix.r.c.c.f("RestartMgr", "rebootAppIfNeed: OAccount init");
        OAccount.INSTANCE.init();
        return;
    }
}
