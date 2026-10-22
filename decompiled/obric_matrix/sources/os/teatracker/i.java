package os.teatracker;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.ss.ttuploader.TTVideoUploader;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
class i extends d implements IBdInstall.a {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final Object f22723l = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f22724a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile f f22725b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f22726c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Class f22727d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final c f22728e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List<WeakReference<e.a>> f22729f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ContentObserver f22730g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f22731h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f22732i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f22733j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Boolean f22734k;

    class a extends ContentObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i f22735a;

        a(i r1, Handler r2) {
            this.f22735a = r1;
            super(r2);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean r2, Uri r3) {
            if (r3.equals(g.f22718b) == false) goto L6;
            Log.d("EventHandler", "onChange: startBdInstallRegister, " + r3);
            i.m(this.f22735a);
            return;
        }
    }

    class b extends ContentObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i f22736a;

        b(i r1, Handler r2) {
            this.f22736a = r1;
            super(r2);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean r3, Uri r4) {
            if (r4.equals(g.f22718b) == false) goto L18;
            String r5 = this.f22736a.e();
            String r6 = this.f22736a.f();
            Object r0 = i.n();
            monitor-enter(r0);
            Iterator r2 = i.o(this.f22736a).iterator();     // Catch: Throwable -> L15
        L8:
            if (r2.hasNext() == false) goto L13;
            e.a r1 = (e.a) ((WeakReference) r2.next()).get();     // Catch: Throwable -> L15
            if (r1 == null) goto L8;
            r1.a(r5);     // Catch: Throwable -> L15
            r1.b(r6);     // Catch: Throwable -> L15
            goto L8
        L13:
            monitor-exit(r0);     // Catch: Throwable -> L15
            return;
        L15:
            th = move-exception;
            throw th;
        }
    }

    private static class c extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private volatile Context f22737a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private j f22738b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private List<h> f22739c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final List<h> f22740d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final AtomicBoolean f22741e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private Map<String, Object> f22742f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final j.b f22743g;

        class a implements j.b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ c f22744a;

            a(c r1) {
                this.f22744a = r1;
            }

            @Override // os.teatracker.j.b
            public void a() {
                Log.i(f.f22710g, "Tea service connected...");
                this.f22744a.sendEmptyMessage(3);
            }

            @Override // os.teatracker.j.b
            public void b() {
                Log.i(f.f22710g, "Tea service disconnected...");
            }
        }

        c(Looper r2) {
            super(r2);
            this.f22739c = Collections.synchronizedList(new ArrayList());
            this.f22740d = Collections.synchronizedList(new ArrayList());
            this.f22741e = new AtomicBoolean(false);
            a r3 = new a(this);
            this.f22743g = r3;
            j r0 = j.d(this);
            this.f22738b = r0;
            r0.i(r3);
        }

        private void a(h r3, boolean r4, boolean r5) {
            if (r3 != null) goto L5;
            return;
        L5:
            if (r5 == false) goto L12;
            if (this.f22740d.size() < 100) goto L10;
            if (r4 == true) goto L10;
            this.f22740d.remove(0);
        L10:
            List<h> r2 = this.f22740d;
        L16:
            r2.add(r3);
            return;
        L12:
            if (this.f22739c.size() < 100) goto L15;
            if (r4 == true) goto L15;
            this.f22739c.remove(0);
        L15:
            r2 = this.f22739c;
            goto L16
        }

        private void b(h r4) {
            if (r4 != null) goto L4;
            return;
        L4:
            JSONObject r0 = r4.b();
            if (r0 != null) goto L7;
            r0 = new JSONObject();
        L7:
            Map<String, Object> r1 = this.f22742f;
            if (r1 != null) goto L26;
            return;
        L26:
            if (r1.isEmpty() == true) goto L31;
            Iterator<Map.Entry<String, Object>> r3 = this.f22742f.entrySet().iterator();     // Catch: Throwable -> L17 JSONException -> L19
        L14:
            if (r3.hasNext() == false) goto L21;
            Map.Entry<String, Object> r2 = r3.next();     // Catch: Throwable -> L17 JSONException -> L19
            r0.put(r2.getKey(), r2.getValue());     // Catch: Throwable -> L17 JSONException -> L19
        L21:
            r4.f(r0);
            return;
        L19:
            e = move-exception;
            e.printStackTrace();     // Catch: Throwable -> L17
            goto L21
        L31:
            return;
        L17:
            th = move-exception;
            r4.f(r0);
            throw th;
        }

        private void c(List<h> r6, boolean r7) {
            if (r6 != null) goto L4;
            return;
        L4:
            if (r6.isEmpty() == false) goto L7;
            return;
        L7:
            if (this.f22738b.e() == false) goto L25;
            monitor-enter(r6);
        L27:
        L22:
            th = move-exception;
            throw th;
        L11:
            if (r6.isEmpty() == true) goto L20;
            ArrayList r1 = new ArrayList();     // Catch: Throwable -> L22
            int r2 = Math.min(TTVideoUploader.KeyIsGetTosKey, r6.size());     // Catch: Throwable -> L22
            int r3 = 0;
        L13:
            if (r3 >= r2) goto L16;
            r1.add(r6.get(r3));     // Catch: Throwable -> L22
            r3 = r3 + 1;     // Catch: Throwable -> L22
            goto L13
        L16:
            if (this.f22738b.g(r1, r7) == false) goto L20;
            int r4 = r2 - 1;     // Catch: Throwable -> L22
        L18:
            if (r4 < 0) goto L27;
            r6.remove(r4);     // Catch: Throwable -> L22
            r4 = r4 - 1;     // Catch: Throwable -> L22
        L20:
            monitor-exit(r6);     // Catch: Throwable -> L22
            return;
        L25:
            this.f22738b.b(this.f22737a);
        }

        private void d(h r5, boolean r6) {
            Log.i("EventHandler", "onEvent: " + r5.a());
            if (r5 != null) goto L6;
            return;
        L6:
            if (this.f22741e.get() == true) goto L8;
        L26:
            Log.i(f.f22710g, "onEvent before Init=" + this.f22741e.get());
            a(r5, false, r6);
            return;
        L8:
            if (hasMessages(3) == true) goto L26;
            if (k.e(this.f22737a) == true) goto L14;
            Log.i(f.f22710g, "mermaid app unGranted.");
            f();
            return;
        L14:
            int r0 = r5.c();
            b(r5);
            int r2 = r5.c();
            if (r2 <= 10000) goto L19;
            Log.i(f.f22710g, "onEvent data oversize 10KB, not send, afterMergeParamsSize:" + r0 + "b,  afterMergeParamsSize:" + r2 + "b");
            return;
        L19:
            if (this.f22738b.e() == false) goto L24;
            a(r5, true, r6);
            if (r6 == false) goto L23;
            c(this.f22740d, true);
            return;
        L23:
            c(this.f22739c, false);
            return;
        L24:
            a(r5, false, r6);
            this.f22738b.b(this.f22737a);
        }

        private void e(Map<String, Object> r3) {
            Log.i(f.f22710g, "TeaHandler onInit...");
            if (k.e(this.f22737a) == true) goto L5;
        L7:
            this.f22742f = r3;
            this.f22741e.set(true);
            return;
        L5:
            if (this.f22738b.e() == true) goto L7;
            this.f22738b.b(this.f22737a);
            goto L7
        }

        private void f() {
            Log.i(f.f22710g, "TeaHandler onQuit...");
            List<h> r0 = this.f22739c;
            if (r0 == null) goto L5;
            r0.clear();
            this.f22739c = null;
        L5:
            j r1 = this.f22738b;
            if (r1 == null) goto L8;
            r1.k();
            this.f22738b.i(null);
            this.f22738b = null;
        L8:
            this.f22737a = null;
        }

        private void g() {
            if (this.f22739c.isEmpty() == false) goto L8;
            if (this.f22740d.isEmpty() == false) goto L8;
            return;
        L8:
            if (this.f22738b.e() == false) goto L21;
            Iterator<h> r0 = this.f22739c.iterator();
        L11:
            if (r0.hasNext() == false) goto L13;
            b(r0.next());
            goto L11
        L13:
            Iterator<h> r1 = this.f22740d.iterator();
        L15:
            if (r1.hasNext() == false) goto L17;
            b(r1.next());
            goto L15
        L17:
            c(this.f22739c, false);
            c(this.f22740d, true);
            return;
        }

        private void h(String r2) {
            if (this.f22741e.get() == true) goto L7;
            Log.i(f.f22710g, "setAbSdkVersion before init");
            return;
        L7:
            if (this.f22738b.e() == false) goto L10;
            this.f22738b.h(r2);
            return;
        }

        private void j(boolean r2) {
            if (this.f22741e.get() == true) goto L7;
            Log.i(f.f22710g, "setPrivacyPolicyConfirmed before init");
            return;
        L7:
            if (this.f22738b.e() == false) goto L10;
            this.f22738b.j(r2);
            return;
        }

        @Override // android.os.Handler
        public void handleMessage(Message r2) {
            switch(r2.what) {
                case 1: goto L12;
                case 2: goto L10;
                case 3: goto L9;
                case 4: goto L8;
                case 5: goto L7;
                case 6: goto L6;
                case 7: goto L5;
                default: goto L19;
            };
        L5:
            h r3 = (h) r2.obj;
            boolean r0 = true;
        L11:
            d(r3, r0);
            return;
        L6:
            j(((Boolean) r2.obj).booleanValue());
            return;
        L7:
            h((String) r2.obj);
            return;
        L8:
            f();
            return;
        L9:
            g();
            return;
        L10:
            r3 = (h) r2.obj;
            r0 = false;
            goto L11
        L12:
            e((Map) r2.obj);
            return;
        }

        public void i(Context r1) {
            this.f22737a = r1;
        }
    }

    static {
        f22723l = new Object();
    }

    public i() {
        this.f22727d = null;
        this.f22729f = Collections.synchronizedList(new ArrayList());
        this.f22734k = null;
        HandlerThread r0 = new HandlerThread("Tea Handler");
        r0.start();
        Looper r1 = r0.getLooper();
        Objects.requireNonNull(r1);
        this.f22728e = new c(r1);
    }

    static /* synthetic */ void m(i r0) {
        r0.p();
    }

    static /* synthetic */ Object n() {
        return f22723l;
    }

    static /* synthetic */ List o(i r0) {
        return r0.f22729f;
    }

    private void p() {
        Log.d("EventHandler", "bdInstallRegister: ");
        if (this.f22726c == true) goto L5;
        return;
    L5:
        Bundle r0 = null;
        PackageInfo r1 = this.f22724a.getPackageManager().getPackageInfo(this.f22724a.getPackageName(), 128);     // Catch: Exception -> L12 PackageManager.NameNotFoundException -> L14
        Bundle r2 = r1.applicationInfo.metaData;     // Catch: Exception -> L12 PackageManager.NameNotFoundException -> L14
        if (r2 != null) goto L9;
    L21:
        IBdInstall r3 = (IBdInstall) this.f22727d.newInstance();     // Catch: Throwable -> L18
        Bundle r4 = new Bundle();     // Catch: Throwable -> L18
        r4.putString(IBdInstall.PARAM_APP_ID, this.f22725b.a());     // Catch: Throwable -> L18
        r4.putString(IBdInstall.PARAM_APP_NAME, this.f22725b.b());     // Catch: Throwable -> L18
        r4.putString(IBdInstall.PARAM_APP_CHANNEL, this.f22725b.c());     // Catch: Throwable -> L18
        r4.putBundle(IBdInstall.PARAM_META_DATA, r0);     // Catch: Throwable -> L18
        r3.register(this.f22724a, this.f22728e, r4, this);     // Catch: Throwable -> L18
        return;
    L18:
        e = move-exception;
        e.printStackTrace();
        return;
    L9:
        if (r2.containsKey("teatracker_app_id") == false) goto L21;
        r0 = r1.applicationInfo.metaData;     // Catch: Exception -> L12 PackageManager.NameNotFoundException -> L14
    L14:
        e = move-exception;
        Log.e(f.f22710g, "get package info error!", e);
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L21
    }

    private void q() {
        Log.d("EventHandler", "checkBdInstall");
        this.f22727d = Class.forName("os.teatracker.BdInstallImpl");     // Catch: ClassNotFoundException -> L10
    L5:
        if (this.f22727d == null) goto L7;
        boolean r0 = true;
    L8:
        this.f22726c = r0;
        return;
    L7:
        r0 = false;
        goto L8
    }

    private boolean s(Context r1, String r2) {
        if (r1.getPackageManager().resolveContentProvider(r2, 0) == null) goto L6;
        return true;
    L6:
        return false;
    }

    private /* synthetic */ void t(String r3, String r4) {
        this.f22731h = r3;
        this.f22732i = r4;
        Object r5 = f22723l;
        monitor-enter(r5);
        Iterator<WeakReference<e.a>> r6 = this.f22729f.iterator();     // Catch: Throwable -> L16
    L6:
        if (r6.hasNext() == false) goto L14;
        WeakReference<e.a> r0 = r6.next();     // Catch: Throwable -> L16
        if (r0 == null) goto L6;
        e.a r1 = r0.get();     // Catch: Throwable -> L16
        if (r1 == null) goto L6;
        r1.a(this.f22731h);     // Catch: Throwable -> L16
        r1.b(this.f22732i);     // Catch: Throwable -> L16
        goto L6
    L14:
        monitor-exit(r5);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        throw th;
    }

    @Override // os.teatracker.IBdInstall.a
    public void a(final String r3, final String r4) {
        this.f22728e.post(new os.teatracker.c(this, r3, r4));
    }

    @Override // os.teatracker.d
    public void b(e.a r3) {
        Log.i("EventHandler", "addTeaListener:");
        Object r0 = f22723l;
        monitor-enter(r0);
        if (r3 != null) goto L11;
    L6:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    L11:
        this.f22729f.add(new WeakReference(r3));     // Catch: Throwable -> L8
        goto L6
    }

    @Override // os.teatracker.d
    public String c() {
        return this.f22733j;
    }

    @Override // os.teatracker.d
    Context d() {
        return this.f22724a;
    }

    @Override // os.teatracker.d
    public String e() {
        if (this.f22726c == false) goto L7;
        return this.f22731h;
    L7:
        return r();
    }

    @Override // os.teatracker.d
    public String f() {
        if (this.f22726c == true) goto L5;
        return "INVALID_IID_MISSING_BDINSTALL";
    L5:
        return this.f22732i;
    }

    @Override // os.teatracker.d
    f g() {
        return this.f22725b;
    }

    @Override // os.teatracker.d
    public String i() {
        Bundle r2 = this.f22724a.getContentResolver().acquireUnstableContentProviderClient(g.f22717a).call("getUDID", null, null);     // Catch: Exception -> L7
        if (r2 == null) goto L9;
        return r2.getString("key_client_udid");
    L9:
        return null;
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L9
    }

    @Override // os.teatracker.d
    public void j(Context r8, f r9) {
        Log.i("EventHandler", "init:");
        if (r8 == null) goto L53;
        if (this.f22724a == null) goto L7;
        return;
    L7:
        String r2 = null;
        PackageInfo r4 = r8.getPackageManager().getPackageInfo(r8.getPackageName(), 128);     // Catch: Exception -> L18 PackageManager.NameNotFoundException -> L20
        Bundle r5 = r4.applicationInfo.metaData;     // Catch: Exception -> L18 PackageManager.NameNotFoundException -> L20
        if (r5 != null) goto L11;
    L22:
        if (r9 == null) goto L25;
        if (r2 != null) goto L27;
        r2 = r9.a();
    L27:
        if (TextUtils.isEmpty(r2) == true) goto L51;
        r9.e(r2);
        if (r8.getApplicationContext() == null) goto L32;
        r8 = r8.getApplicationContext();
    L32:
        this.f22724a = r8;
        this.f22725b = r9;
        this.f22728e.i(this.f22724a);
        Message.obtain(this.f22728e, 1, r9.d()).sendToTarget();
        q();
        String r10 = r();
        String r11 = f();
        if (this.f22726c == false) goto L45;
        if (TextUtils.isEmpty(r10) == true) goto L55;
        p();
    L48:
        Log.i("EventHandler", "init: sucess mContext=" + this.f22724a);
        return;
    L55:
    L41:
        e = move-exception;
        e.printStackTrace();
        goto L48
    L37:
        if (s(this.f22724a, g.f22717a.getAuthority()) == false) goto L39;
        this.f22724a.getContentResolver().registerContentObserver(g.f22718b, false, new a(this, this.f22728e));     // Catch: RuntimeException -> L41
    L54:
        goto L48
    L39:
        Log.d("EventHandler", "onChange: bdInstallRegister, did " + r10);     // Catch: RuntimeException -> L41
        p();     // Catch: RuntimeException -> L41
        goto L54
    L45:
        if (TextUtils.isEmpty(r10) == true) goto L47;
        a(r10, r11);
    L47:
        this.f22730g = new b(this, this.f22728e);
        this.f22724a.getContentResolver().registerContentObserver(g.f22718b, false, this.f22730g);
        goto L48
    L51:
        throw new IllegalArgumentException("teatracker_app_id must be declared in manifest as meta data");
    L25:
        r9 = new f();
        goto L27
    L11:
        if (r5.containsKey("teatracker_app_id") == false) goto L22;
        r2 = r4.applicationInfo.metaData.getString("teatracker_app_id", null);     // Catch: Exception -> L18 PackageManager.NameNotFoundException -> L20
        if (TextUtils.isEmpty(r2) == false) goto L22;
        int r0 = r4.applicationInfo.metaData.getInt("teatracker_app_id", 0);     // Catch: Exception -> L18 PackageManager.NameNotFoundException -> L20
        if (r0 == 0) goto L22;
        r2 = String.valueOf(r0);     // Catch: Exception -> L18 PackageManager.NameNotFoundException -> L20
    L20:
        e = move-exception;
        Log.e(f.f22710g, "get package info error!", e);
    L18:
        e = move-exception;
        e.printStackTrace();
        goto L22
    L53:
        throw new IllegalArgumentException("context can't be null when initing Tea tracker.");
    }

    @Override // os.teatracker.d
    public Boolean k() {
        return this.f22734k;
    }

    @Override // os.teatracker.d
    public void l(h r2) {
        Message.obtain(this.f22728e, 2, r2).sendToTarget();
    }

    public String r() {
        Bundle r5 = this.f22724a.getContentResolver().acquireUnstableContentProviderClient(g.f22717a).call("getDeviceId", null, null);     // Catch: Exception -> L9
        if (r5 == null) goto L7;
        Log.d(f.f22710g, "getTeaTrackerDid, " + r5.getString("key_device_info"));     // Catch: Exception -> L9
        return r5.getString("key_device_info");
    L7:
        Log.d(f.f22710g, "getTeaTrackerDid result IS NULL!");     // Catch: Exception -> L9
        return null;
    L9:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public /* synthetic */ void u(String r1, String r2) {
        t(r1, r2);
    }
}
