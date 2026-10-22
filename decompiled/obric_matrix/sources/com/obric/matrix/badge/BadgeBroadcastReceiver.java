package com.obric.matrix.badge;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.obric.matrix.r.c.c;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\n"}, d2 = {"Lcom/obric/matrix/badge/BadgeBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "Companion", "badge_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BadgeBroadcastReceiver extends BroadcastReceiver {
    static {
    }

    public BadgeBroadcastReceiver() {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r9, Intent r10) {
        if (r10 == null) goto L11;
        String r3 = r10.getStringExtra("badge_count_package_name");     // Catch: Exception -> L6
        String r1 = r10.getStringExtra("badge_count_class_name");     // Catch: Exception -> L6
        int r4 = r10.getIntExtra("badge_count", 0);     // Catch: Exception -> L6
        int r5 = getSendingUserId();     // Catch: Exception -> L6
        c.j("BadgeBroadcastReceiver", "onReceive:" + r1 + ' ' + r3 + " :" + r4 + ' ' + this + " userId:" + r5);     // Catch: Exception -> L6
        MessageBadgeProvider.c(r9, r3, r4, r5, -1, "BadgeBroadcastReceiver");     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        c.f("BadgeBroadcastReceiver", "onReceive error:" + e);
        return;
    }
}
