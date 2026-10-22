package com.slardaros.client;

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
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import androidx.core.view.PointerIconCompat;
import com.obric.olog.OLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
class l implements ServiceConnection {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Context f11694f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Messenger f11695g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private AtomicBoolean f11696h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private AtomicInteger f11697i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private b f11698j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f11699k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Handler f11700l;

    class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ l f11701f;

        a(l r1) {
            this.f11701f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            l.a(this.f11701f);
        }
    }

    interface b {
        void a();

        void b();
    }

    private static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final l f11702a = null;

        static {
            f11702a = new l(null);
        }
    }

    private l() {
        this.f11696h = new AtomicBoolean(false);
        this.f11697i = new AtomicInteger(0);
        this.f11699k = false;
    }

    /* synthetic */ l(a r1) {
        this();
    }

    static /* synthetic */ boolean a(l r0) {
        return r0.c();
    }

    private boolean c() {
        Intent r0 = new Intent("com.bytedance.os.slardar.ACTION_SLARDAR_SERVICE");
        Context r1 = this.f11694f;
        if (r1 == null) goto L5;
        PackageManager r2 = r1.getPackageManager();
    L7:
        if (r2 != null) goto L11;
        String r6 = "Can not resolve slardarosclient app! packageManager is null ";
    L9:
        OLog.d("Slardaros_Agent", r6);
        return false;
    L11:
        List<ResolveInfo> r3 = r2.queryIntentServices(r0, 0);
        if (r3 != null) goto L15;
        return false;
    L15:
        if (r3.isEmpty() == false) goto L18;
        r6 = "Can not resolve slardarosclient app! We got empty list!";
        goto L9
    L18:
        if (r3.size() <= 1) goto L20;
        r6 = "can not resolve slardarosclient app! We got several results!";
        goto L9
    L20:
        r0.setPackage(r3.get(0).serviceInfo.packageName);
        return this.f11694f.bindService(r0, this, 1);
    L5:
        r2 = null;
        goto L7
    }

    public static l d(Handler r3) {
        l r0 = c.f11702a;
        if (r0.f11700l != null) goto L10;
        if (r3 == null) goto L9;
        if (r3.getLooper() == Looper.getMainLooper()) goto L9;
        r0.f11700l = r3;
    L9:
        throw new RuntimeException("A handler needed by SlardarServiceProxy and handler should runs in the non-main thread");
    L10:
        return r0;
    }

    private void f(boolean r1) {
        b r0 = this.f11698j;
        if (r0 == null) goto L8;
        if (r1 == false) goto L6;
        r0.a();
        return;
    L6:
        r0.b();
        return;
    }

    public boolean b(Context r4) {
        if (r4 != null) goto L5;
        return false;
    L5:
        this.f11694f = r4;
        if (this.f11696h.get() == false) goto L12;
        if (this.f11695g == null) goto L12;
        f(true);
        return true;
    L12:
        if (c() == false) goto L15;
        OLog.e("Slardaros_Agent", "Connecting slardar service");
        return true;
    L15:
        OLog.e("Slardaros_Agent", "Can't connect to slardar service");
        k();
        return false;
    }

    public boolean e() {
        if (this.f11696h.get() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f11695g == null) goto L7;
        return true;
    }

    public void g(Bundle r2) {
    L8:
        e = move-exception;
        OLog.d("Slardaros_Agent", "SlardarServiceProxy onAbResult ex: " + e);
        return;
    L3:
        if (e() == false) goto L13;
        Message r0 = new Message();     // Catch: Exception -> L8
        r0.setData(r2);     // Catch: Exception -> L8
        Messenger r1 = this.f11695g;     // Catch: Exception -> L8
        if (r1 == null) goto L14;
        r0.what = PointerIconCompat.TYPE_CELL;     // Catch: Exception -> L8
        r1.send(r0);     // Catch: Exception -> L8
        return;
    L14:
        return;
    }

    public boolean h(List<d> r17) {
    L48:
        e = move-exception;
        OLog.d("Slardaros_Agent", "SlardarServiceProxy onEvent ex: " + e);
        return false;
    L4:
        if (e() == false) goto L69;
        Message r2 = new Message();     // Catch: Exception -> L48
        Bundle r3 = new Bundle();     // Catch: Exception -> L48
        r2.setData(r3);     // Catch: Exception -> L48
        ArrayList<? extends Parcelable> r4 = new ArrayList();     // Catch: Exception -> L48
        ArrayList<? extends Parcelable> r5 = new ArrayList();     // Catch: Exception -> L48
        ArrayList<? extends Parcelable> r6 = new ArrayList();     // Catch: Exception -> L48
        ArrayList<? extends Parcelable> r7 = new ArrayList();     // Catch: Exception -> L48
        Iterator<d> r8 = r17.iterator();     // Catch: Exception -> L48
    L7:
        if (r8.hasNext() == false) goto L30;
        d r9 = r8.next();     // Catch: Exception -> L48
        String r11 = null;
        if ((r9 instanceof j) == true) goto L11;
        if ((r9 instanceof f) == true) goto L18;
        if ((r9 instanceof g) == true) goto L21;
        if ((r9 instanceof h) == false) goto L7;
        OLog.c("SlardarAgent", "MetricEvent");     // Catch: Exception -> L48
        h r10 = (h) r9;     // Catch: Exception -> L48
        Bundle r12 = new Bundle();     // Catch: Exception -> L48
        r12.putString("key_event", r10.a());     // Catch: Exception -> L48
        if (r10.b() == null) goto L28;
        r11 = r10.b().toString();     // Catch: Exception -> L48
    L28:
        r12.putString("key_params", r11);     // Catch: Exception -> L48
        r7.add(r12);     // Catch: Exception -> L48
        goto L7
    L21:
        OLog.c("SlardarAgent", "InfoEvent");     // Catch: Exception -> L48
        g r13 = (g) r9;     // Catch: Exception -> L48
        Bundle r14 = new Bundle();     // Catch: Exception -> L48
        r14.putString("key_info_logid", r13.a());     // Catch: Exception -> L48
        r14.putString("key_info_logtype", r13.c());     // Catch: Exception -> L48
        r14.putString("key_info_logpath", r13.b());     // Catch: Exception -> L48
        r14.putBoolean("key_info_isdelete", r13.d());     // Catch: Exception -> L48
        r6.add(r14);     // Catch: Exception -> L48
        goto L7
    L18:
        OLog.c("SlardarAgent", "ErrorEvent");     // Catch: Exception -> L48
        f r15 = (f) r9;     // Catch: Exception -> L48
        Bundle r16 = new Bundle();     // Catch: Exception -> L48
        r16.putString("key_error_tag", r15.d());     // Catch: Exception -> L48
        r16.putString("key_error_type", r15.e());     // Catch: Exception -> L48
        r16.putString("key_error_summary", r15.c());     // Catch: Exception -> L48
        r16.putString("key_error_logpath", r15.a());     // Catch: Exception -> L48
        r16.putBoolean("key_error_isdelete", r15.g());     // Catch: Exception -> L48
        r16.putString("key_error_package", r15.b());     // Catch: Exception -> L48
        r16.putLong("key_error_boottime", System.currentTimeMillis() - SystemClock.elapsedRealtime());     // Catch: Exception -> L48
        r16.putLong("key_error_timestamp", System.currentTimeMillis());     // Catch: Exception -> L48
        r16.putBoolean("key_error_catchlog", r15.f());     // Catch: Exception -> L48
        r5.add(r16);     // Catch: Exception -> L48
        goto L7
    L11:
        OLog.c("SlardarAgent", "SlardarEvent");     // Catch: Exception -> L48
        j r18 = (j) r9;     // Catch: Exception -> L48
        Bundle r19 = new Bundle();     // Catch: Exception -> L48
        r19.putString("key_event", r18.a());     // Catch: Exception -> L48
        if (r18.b() == null) goto L15;
        r11 = r18.b().toString();     // Catch: Exception -> L48
    L15:
        r19.putString("key_params", r11);     // Catch: Exception -> L48
        r19.putBoolean("key_instant", r18.d());     // Catch: Exception -> L48
        r19.putLong("key_timestamp", r18.c());     // Catch: Exception -> L48
        r4.add(r19);     // Catch: Exception -> L48
        goto L7
    L30:
        if (this.f11695g != null) goto L34;
        e.a().d(r17);     // Catch: Exception -> L48
        return true;
    L34:
        if (r4.size() <= 0) goto L38;
        r2.what = 1001;     // Catch: Exception -> L48
        r3.putParcelableArrayList("key_data", r4);     // Catch: Exception -> L48
        this.f11695g.send(r2);     // Catch: Exception -> L48
    L38:
        if (r5.size() <= 0) goto L41;
        OLog.c("Slardaros_Agent", "errorBundlers : " + r5.toString());     // Catch: Exception -> L48
        r2.what = 1002;     // Catch: Exception -> L48
        r3.putParcelableArrayList("key_data", r5);     // Catch: Exception -> L48
        r2.setData(r3);     // Catch: Exception -> L48
        this.f11695g.send(r2);     // Catch: Exception -> L48
    L41:
        if (r6.size() <= 0) goto L44;
        r2.what = 1003;     // Catch: Exception -> L48
        r3.putParcelableArrayList("key_data", r6);     // Catch: Exception -> L48
        this.f11695g.send(r2);     // Catch: Exception -> L48
    L44:
        if (r7.size() <= 0) goto L68;
        r2.what = PointerIconCompat.TYPE_CROSSHAIR;     // Catch: Exception -> L48
        r3.putParcelableArrayList("key_data", r7);     // Catch: Exception -> L48
        this.f11695g.send(r2);     // Catch: Exception -> L48
        return true;
    L68:
        return true;
    L69:
        return false;
    }

    public void i(AppProfile r6, Messenger r7) {
    L8:
        e = move-exception;
        OLog.d("Slardaros_Agent", "SlardarServiceProxy onProfile ex: " + e);
        return;
    L3:
        if (e() == false) goto L13;
        Message r0 = new Message();     // Catch: Exception -> L8
        Bundle r1 = new Bundle();     // Catch: Exception -> L8
        r0.setData(r1);     // Catch: Exception -> L8
        if (this.f11695g == null) goto L14;
        r0.what = 1004;     // Catch: Exception -> L8
        Parcel r2 = Parcel.obtain();     // Catch: Exception -> L8
        OLog.c("SlardarAgent_profle", r6.toString());     // Catch: Exception -> L8
        r6.writeToParcel(r2, 0);     // Catch: Exception -> L8
        r2.setDataPosition(0);     // Catch: Exception -> L8
        r1.putByteArray("key_data", r2.marshall());     // Catch: Exception -> L8
        r0.replyTo = r7;     // Catch: Exception -> L8
        this.f11695g.send(r0);     // Catch: Exception -> L8
        return;
    L14:
        return;
    }

    public void j(b r1) {
        this.f11698j = r1;
    }

    public void k() {
        this.f11699k = true;
        if (e() == false) goto L11;
        this.f11694f.unbindService(this);     // Catch: Exception -> L6
        this.f11696h.set(false);     // Catch: Exception -> L6
        this.f11695g = null;     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        OLog.d("Slardaros_Agent", "SlardarServiceProxy unbind ex: " + e.getMessage());
        return;
    }

    @Override // android.content.ServiceConnection
    public void onBindingDied(ComponentName r1) {
        onServiceDisconnected(r1);
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName r2, IBinder r3) {
        this.f11697i.set(0);
        this.f11695g = new Messenger(r3);
        f(true);
        this.f11696h.set(true);
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName r4) {
        this.f11696h.set(false);
        this.f11695g = null;
        OLog.c("Slardaros_Agent", "onServiceDisconnected");
        if (this.f11699k == true) goto L9;
        OLog.e("Slardaros_Agent", "SlardarServiceProxy retry times: " + this.f11697i.get());
        if (this.f11697i.getAndIncrement() >= 0) goto L7;
        this.f11700l.postDelayed(new a(this), 1000);
        return;
    L7:
        OLog.d("Slardaros_Agent", "SlardarServiceProxy connected to slardar service error with " + this.f11697i.get() + " times retry.");
        return;
    }
}
