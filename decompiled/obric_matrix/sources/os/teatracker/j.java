package os.teatracker;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.TransactionTooLargeException;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
class j implements ServiceConnection {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Context f22745f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Messenger f22746g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final AtomicBoolean f22747h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final AtomicInteger f22748i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private b f22749j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f22750k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Handler f22751l;

    class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ j f22752f;

        a(j r1) {
            this.f22752f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            j.a(this.f22752f);
        }
    }

    interface b {
        void a();

        void b();
    }

    private static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final j f22753a = null;

        static {
            f22753a = new j(null);
        }
    }

    private j() {
        this.f22747h = new AtomicBoolean(false);
        this.f22748i = new AtomicInteger(0);
        this.f22750k = false;
    }

    /* synthetic */ j(a r1) {
        this();
    }

    static /* synthetic */ boolean a(j r0) {
        return r0.c();
    }

    private boolean c() {
        Intent r0 = new Intent("os.teatracker.ACTION_TEA_TRACKER_SERVICE");
        PackageManager r1 = this.f22745f.getPackageManager();
        if (r1 != null) goto L7;
        String r5 = f.f22710g;
        String r2 = "Can not resolve app! packageManager is null ";
    L5:
        Log.e(r5, r2);
        return false;
    L7:
        List<ResolveInfo> r3 = r1.queryIntentServices(r0, 0);
        if (r3 != null) goto L11;
        return false;
    L11:
        if (r3.isEmpty() == false) goto L14;
        r5 = f.f22710g;
        r2 = "Can not resolve app! We got empty list!";
        goto L5
    L14:
        if (r3.size() <= 1) goto L16;
        r5 = f.f22710g;
        r2 = "can not resolve app! We got several results!";
        goto L5
    L16:
        r0.setPackage(r3.get(0).serviceInfo.packageName);
        return this.f22745f.bindService(r0, this, 1);
    }

    public static j d(Handler r3) {
        j r0 = c.f22753a;
        if (r0.f22751l != null) goto L10;
        if (r3 == null) goto L9;
        if (r3.getLooper() == Looper.getMainLooper()) goto L9;
        r0.f22751l = r3;
    L9:
        throw new RuntimeException("A handler needed by ServiceProxy and handler should runs in the non-main thread");
    L10:
        return r0;
    }

    private void f(boolean r1) {
        b r0 = this.f22749j;
        if (r0 == null) goto L8;
        if (r1 == false) goto L6;
        r0.a();
        return;
    L6:
        r0.b();
        return;
    }

    public boolean b(Context r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        this.f22745f = r3;
        if (this.f22747h.get() == false) goto L12;
        if (this.f22746g == null) goto L12;
        f(true);
        return true;
    L12:
        if (c() == false) goto L14;
        return true;
    L14:
        Log.i(f.f22710g, "Can't connect to service");
        k();
        return false;
    }

    public boolean e() {
        if (this.f22747h.get() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f22746g == null) goto L7;
        return true;
    }

    public boolean g(List<h> r10, boolean r11) {
    L23:
        e = move-exception;
        Log.e(f.f22710g, "ServiceProxy onEvent ex: " + e);
        if ((e instanceof TransactionTooLargeException) == false) goto L27;
        return true;
    L27:
        return false;
    L4:
        if (e() == false) goto L27;
        Message r2 = new Message();     // Catch: RemoteException -> L23
        r2.what = 101;     // Catch: RemoteException -> L23
        Bundle r3 = new Bundle();     // Catch: RemoteException -> L23
        r2.setData(r3);     // Catch: RemoteException -> L23
        f r4 = d.h().g();     // Catch: RemoteException -> L23
        if (r11 == false) goto L8;
        String r12 = "568726";
    L9:
        r3.putString("key_app_id", r12);     // Catch: RemoteException -> L23
        ArrayList<? extends Parcelable> r13 = new ArrayList(r10.size());     // Catch: RemoteException -> L23
        Iterator<h> r14 = r10.iterator();     // Catch: RemoteException -> L23
    L11:
        if (r14.hasNext() == false) goto L17;
        h r5 = r14.next();     // Catch: RemoteException -> L23
        Bundle r6 = new Bundle();     // Catch: RemoteException -> L23
        r6.putString("key_event", r5.a());     // Catch: RemoteException -> L23
        if (r5.b() != null) goto L15;
        String r7 = null;
    L16:
        r6.putString("key_params", r7);     // Catch: RemoteException -> L23
        r6.putBoolean("key_instant", r5.e());     // Catch: RemoteException -> L23
        r6.putLong("key_timestamp", r5.d());     // Catch: RemoteException -> L23
        r13.add(r6);     // Catch: RemoteException -> L23
        goto L11
    L15:
        r7 = r5.b().toString();     // Catch: RemoteException -> L23
        goto L16
    L17:
        r3.putParcelableArrayList("key_data", r13);     // Catch: RemoteException -> L23
        Messenger r9 = this.f22746g;     // Catch: RemoteException -> L23
        if (r9 != null) goto L21;
        r3.clear();     // Catch: RemoteException -> L23
        r2.recycle();     // Catch: RemoteException -> L23
        return false;
    L21:
        r9.send(r2);     // Catch: RemoteException -> L23
        return true;
    L8:
        r12 = r4.a();     // Catch: RemoteException -> L23
        goto L9
    }

    public void h(String r5) {
        Message r0 = new Message();     // Catch: RemoteException -> L4
        r0.what = 102;     // Catch: RemoteException -> L4
        Bundle r1 = new Bundle();     // Catch: RemoteException -> L4
        r1.putString("key_app_id", d.h().g().a());     // Catch: RemoteException -> L4
        r1.putString("key_ab_sdk_version", r5);     // Catch: RemoteException -> L4
        r0.setData(r1);     // Catch: RemoteException -> L4
        this.f22746g.send(r0);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        Log.e(f.f22710g, "ServiceProxy setAbSdkVersion ex: " + e);
    }

    public void i(b r1) {
        this.f22749j = r1;
    }

    public void j(boolean r5) {
        Message r0 = new Message();     // Catch: RemoteException -> L4
        r0.what = 103;     // Catch: RemoteException -> L4
        Bundle r1 = new Bundle();     // Catch: RemoteException -> L4
        r1.putString("key_app_id", d.h().g().a());     // Catch: RemoteException -> L4
        r1.putBoolean("key_privacy_confirmed", r5);     // Catch: RemoteException -> L4
        r0.setData(r1);     // Catch: RemoteException -> L4
        this.f22746g.send(r0);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        Log.e(f.f22710g, "ServiceProxy setPrivacyPolicyConfirmed ex: " + e);
    }

    public void k() {
        this.f22750k = true;
        if (e() == false) goto L5;
        this.f22745f.unbindService(this);
    L5:
        this.f22745f = null;
    }

    @Override // android.content.ServiceConnection
    public void onBindingDied(ComponentName r1) {
        onServiceDisconnected(r1);
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName r2, IBinder r3) {
        this.f22748i.set(0);
        this.f22746g = new Messenger(r3);
        h(d.h().c());
        Boolean r4 = d.h().k();
        if (r4 == null) goto L5;
        j(r4.booleanValue());
    L5:
        f(true);
        this.f22747h.set(true);
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName r4) {
        this.f22747h.set(false);
        this.f22746g = null;
        if (this.f22750k == true) goto L9;
        Log.i(f.f22710g, "ServiceProxy retry times: " + this.f22748i.get());
        if (this.f22748i.getAndIncrement() >= 10) goto L7;
        this.f22751l.postDelayed(new a(this), 1000);
        return;
    L7:
        Log.e(f.f22710g, "ServiceProxy connted to tea service error with " + this.f22748i.get() + " times retry.");
        return;
    }
}
