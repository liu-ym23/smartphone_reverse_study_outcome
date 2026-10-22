package com.obric.matrix.badge;

import android.content.Context;
import android.content.IntentFilter;
import android.os.UserHandle;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/matrix/badge/LauncherBadgeManager;", "", "()V", "USER_DOPPELGANGER", "", "init", "", "context", "Landroid/content/Context;", "registerDataClearedReceiver", "badge_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8833a = null;

    static {
        f8833a = new a();
    }

    private a() {
    }

    private final void b(Context r8) {
        r8.registerReceiverAsUser(new BadgeBroadcastReceiver(), UserHandle.of(10), new IntentFilter("android.intent.action.BADGE_COUNT_UPDATE"), null, null, 2);
    }

    public final void a(Context r2) {
        o.f(r2, "context");
        Context r3 = r2.getApplicationContext();
        o.e(r3, "context.applicationContext");
        b(r3);
    }
}
