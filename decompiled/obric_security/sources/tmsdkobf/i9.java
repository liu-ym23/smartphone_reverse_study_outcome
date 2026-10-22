package tmsdkobf;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes5.dex */
public class i9 extends g0 {
    private static i9 d;
    private static Object e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f267a;
    private NetworkInfo.State b;
    private LinkedList c;

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i9 f268a;

        a(i9 r1) {
            this.f268a = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            LinkedList r0 = i9.m2389$$Nest$fgetc(this.f268a);
            monitor-enter(r0);
            LinkedList r1 = (LinkedList) i9.m2389$$Nest$fgetc(this.f268a).clone();     // Catch: Throwable -> L12
            monitor-exit(r0);     // Catch: Throwable -> L12
            if (r1 == null) goto L11;
            Iterator r2 = r1.iterator();
        L9:
            if (r2.hasNext() == false) goto L18;
            ((c) r2.next()).b();
            goto L9
        L18:
            return;
        L11:
            return;
        L12:
            th = move-exception;
            throw th;
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i9 f269a;

        b(i9 r1) {
            this.f269a = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            LinkedList r0 = i9.m2389$$Nest$fgetc(this.f269a);
            monitor-enter(r0);
            LinkedList r1 = (LinkedList) i9.m2389$$Nest$fgetc(this.f269a).clone();     // Catch: Throwable -> L12
            monitor-exit(r0);     // Catch: Throwable -> L12
            if (r1 == null) goto L11;
            Iterator r2 = r1.iterator();
        L9:
            if (r2.hasNext() == false) goto L18;
            ((c) r2.next()).a();
            goto L9
        L18:
            return;
        L11:
            return;
        L12:
            th = move-exception;
            throw th;
        }
    }

    public interface c {
        void a();

        void b();
    }

    /* JADX INFO: renamed from: -$$Nest$fgetc, reason: not valid java name */
    static /* bridge */ /* synthetic */ LinkedList m2389$$Nest$fgetc(i9 r0) {
        return r0.c;
    }

    static {
        e = new Object();
    }

    private i9() {
        this.b = NetworkInfo.State.DISCONNECTED;
        this.c = new LinkedList();
    }

    private void b(Context r2) {
        if (mb.g() == false) goto L5;
        return;
    L5:
        c(r2);
    }

    private synchronized void c(Context r5) {
        monitor-enter(this);
    L21:
        th = move-exception;
        throw th;
    L5:
        if (this.f267a == false) goto L28;
    L19:
        monitor-exit(this);
        return;
    L28:
        NetworkInfo r1 = ((ConnectivityManager) r5.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Exception -> L12 Throwable -> L21
        if (r1 == null) goto L9;
        q8.c("NetworkBroadcastReceiver", "network type:" + r1.getType());     // Catch: Exception -> L12 Throwable -> L21
        NetworkInfo.State r0 = r1.getState();     // Catch: Exception -> L12 Throwable -> L21
    L10:
        this.b = r0;     // Catch: Exception -> L12 Throwable -> L21
    L14:
        IntentFilter r2 = new IntentFilter();     // Catch: Throwable -> L21
        r2.addAction("android.net.conn.CONNECTIVITY_CHANGE");     // Catch: Throwable -> L21
        r2.setPriority(Integer.MAX_VALUE);     // Catch: Throwable -> L21
        r5.registerReceiver(this, r2);     // Catch: Throwable -> L17
        this.f267a = true;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        q8.b("NetworkBroadcastReceiver", th);     // Catch: Throwable -> L21
        goto L19
    L9:
        r0 = NetworkInfo.State.DISCONNECTED;     // Catch: Exception -> L12 Throwable -> L21
    L12:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L21
        goto L14
    }

    public void a(c r2) {
        LinkedList r0 = this.c;
        monitor-enter(r0);
        this.c.add(r2);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // tmsdkobf.g0
    public void a(Context r3, Intent r4) {
        String r5 = r4.getAction();
        Bundle r6 = r4.getExtras();
        q8.c("NetworkBroadcastReceiver", r5);
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(r5) == false) goto L17;
        NetworkInfo.State r7 = ((NetworkInfo) r6.getParcelable("networkInfo")).getState();
        NetworkInfo.State r8 = NetworkInfo.State.CONNECTED;
        if (r7 != r8) goto L11;
        if (this.b.compareTo(NetworkInfo.State.DISCONNECTED) != 0) goto L15;
        we r9 = ve.f();
        Runnable r0 = new a(this);
        String r1 = "monitor_toConnected";
    L9:
        r9.b(r0, r1);
    L15:
        this.b = r7;
        return;
    L11:
        if (r7 == NetworkInfo.State.DISCONNECTED) goto L13;
        return;
    L13:
        if (this.b.compareTo(r8) != 0) goto L15;
        r9 = ve.f();
        r0 = new b(this);
        r1 = "monitor_toDisconnected";
        goto L9
    }

    public static i9 a(Context r2) {
        if (d != null) goto L19;
        Object r0 = e;
        monitor-enter(r0);
    L15:
        th = move-exception;
        throw th;
    L7:
        if (d != null) goto L13;
        if (r2 != null) goto L12;
        monitor-exit(r0);     // Catch: Throwable -> L15
        return null;
    L12:
        i9 r1 = new i9();     // Catch: Throwable -> L15
        d = r1;     // Catch: Throwable -> L15
        r1.b(r2);     // Catch: Throwable -> L15
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L15
    L19:
        return d;
    }
}
