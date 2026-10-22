package com.obric.matrix.ostracker;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.bytedance.bdinstall.m0;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.mpaas.applog.IBdtrackerService;
import com.obric.matrix.dataanalysis.h;
import com.obric.matrix.dataanalysis.i;
import com.obric.matrix.ostracker_api.IOSTracker;
import h.a.b1;
import h.a.n0;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.k0.d;
import kotlin.k0.j.a.f;
import kotlin.k0.j.a.l;
import kotlin.n0.c.p;
import kotlin.n0.d.g;
import kotlin.n0.d.o;
import kotlin.w;
import org.json.JSONObject;
import os.teatracker.BdInstallImpl;
import os.teatracker.e;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000  2\u00020\u0001:\u0001 B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0007H\u0016J\n\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u000f\u001a\u00020\tH\u0016J\u001a\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J6\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00162\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0012\u0010\u001c\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u0019H\u0016J\b\u0010\u001f\u001a\u00020\u0019H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/obric/matrix/ostracker/TeaTrackerImpl;", "Lcom/obric/matrix/ostracker_api/IOSTracker;", "()V", "initialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mTeaTrackerListeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/obric/matrix/ostracker_api/IOSTrackerListener;", "addTeaTrackerListener", "", "listener", "getDeviceId", "", "getInstallId", "getUDID", "init", "onEvent", NotificationCompat.CATEGORY_EVENT, "params", "Lorg/json/JSONObject;", "putCommonParams", "context", "Landroid/content/Context;", "", "isApi", "", "level", "", "removeTeaTrackerListener", "setBoe", "isBoe", "useBdTracker", "Companion", "ostracker_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TeaTrackerImpl implements IOSTracker {
    public static final a Companion = null;
    private static final String TAG = "TeaTrackerImpl";
    private static String sDid;
    private static String sInstallId;
    private final AtomicBoolean initialized;
    private final CopyOnWriteArrayList<com.obric.matrix.ostracker_api.a> mTeaTrackerListeners;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\f\u0010\r\u001a\u00020\u000e*\u00020\u000fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/obric/matrix/ostracker/TeaTrackerImpl$Companion;", "", "()V", "TAG", "", "sDid", "getSDid", "()Ljava/lang/String;", "setSDid", "(Ljava/lang/String;)V", "sInstallId", "getSInstallId", "setSInstallId", "mapLevel", "Lcom/bytedance/bdinstall/Level;", "", "ostracker_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g r1) {
            this();
        }

        public static final /* synthetic */ m0 a(a r0, int r1) {
            return r0.b(r1);
        }

        private final m0 b(int r1) {
            if (r1 == 0) goto L9;
            if (r1 != 1) goto L7;
            return m0.f2843g;
        L7:
            throw new IllegalArgumentException("level must be 0 or 1");
        L9:
            return m0.f2842f;
        }

        public final void c(String r1) {
            TeaTrackerImpl.access$setSDid$cp(r1);
        }

        public final void d(String r1) {
            TeaTrackerImpl.access$setSInstallId$cp(r1);
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¨\u0006\b"}, d2 = {"com/obric/matrix/ostracker/TeaTrackerImpl$init$1", "Lcom/obric/matrix/base/env/IEnvSwitchListener;", "onBoeSwitched", "", "isBoe", "", "onPpeSwitched", "isPpe", "ostracker_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class b implements com.obric.matrix.base.env.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ TeaTrackerImpl f9455a;

        b(TeaTrackerImpl r1) {
            this.f9455a = r1;
        }

        @Override // com.obric.matrix.base.env.g
        public void a(boolean r1) {
        }

        @Override // com.obric.matrix.base.env.g
        public void b(boolean r1) {
            this.f9455a.setBoe(r1);
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¨\u0006\b"}, d2 = {"com/obric/matrix/ostracker/TeaTrackerImpl$init$2", "Lcom/obric/matrix/dataanalysis/DeviceIdManager$DeviceIdListener;", "onDeviceIdReady", "", "did", "", "onInstallIdReady", "installId", "ostracker_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class c implements h.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ TeaTrackerImpl f9456a;

        @f(c = "com.obric.matrix.ostracker.TeaTrackerImpl$init$2$onDeviceIdReady$1$1$1", f = "TeaTrackerImpl.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
        static final class a extends l implements p<h.a.m0, d<? super f0>, Object> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            int f9457f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ String f9458g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ com.obric.matrix.ostracker_api.a f9459h;

            a(String r1, com.obric.matrix.ostracker_api.a r2, d<? super a> r3) {
                this.f9458g = r1;
                this.f9459h = r2;
                super(2, r3);
            }

            @Override // kotlin.k0.j.a.a
            public final d<f0> create(Object r2, d<?> r3) {
                return new a(this.f9458g, this.f9459h, r3);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(h.a.m0 r1, d<? super f0> r2) {
                return ((a) create(r1, r2)).invokeSuspend(f0.f18324a);
            }

            @Override // kotlin.n0.c.p
            public /* bridge */ /* synthetic */ Object invoke(h.a.m0 r1, d<? super f0> r2) {
                return invoke2(r1, r2);
            }

            @Override // kotlin.k0.j.a.a
            public final Object invokeSuspend(Object r3) {
                kotlin.k0.i.b.c();
                if (this.f9457f != 0) goto L14;
                w.b(r3);
                com.obric.matrix.r.c.c.b(TeaTrackerImpl.TAG, "DeviceIdManager.onDeviceIdReady 通知各listener们did获取到了,did=" + this.f9458g + ", listener = " + this.f9459h);     // Catch: Throwable -> L9
                com.obric.matrix.ostracker_api.a r4 = this.f9459h;     // Catch: Throwable -> L9
                if (r4 == null) goto L12;
                r4.a(this.f9458g);     // Catch: Throwable -> L9
            L12:
                return f0.f18324a;
            L9:
                th = move-exception;
                com.obric.matrix.r.c.c.g(TeaTrackerImpl.TAG, "DeviceIdManager.onDeviceIdReady通知各listener们did获取到了出错了", th);
                goto L12
            L14:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        @f(c = "com.obric.matrix.ostracker.TeaTrackerImpl$init$2$onInstallIdReady$1$1$1", f = "TeaTrackerImpl.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
        static final class b extends l implements p<h.a.m0, d<? super f0>, Object> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            int f9460f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ String f9461g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ com.obric.matrix.ostracker_api.a f9462h;

            b(String r1, com.obric.matrix.ostracker_api.a r2, d<? super b> r3) {
                this.f9461g = r1;
                this.f9462h = r2;
                super(2, r3);
            }

            @Override // kotlin.k0.j.a.a
            public final d<f0> create(Object r2, d<?> r3) {
                return new b(this.f9461g, this.f9462h, r3);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(h.a.m0 r1, d<? super f0> r2) {
                return ((b) create(r1, r2)).invokeSuspend(f0.f18324a);
            }

            @Override // kotlin.n0.c.p
            public /* bridge */ /* synthetic */ Object invoke(h.a.m0 r1, d<? super f0> r2) {
                return invoke2(r1, r2);
            }

            @Override // kotlin.k0.j.a.a
            public final Object invokeSuspend(Object r3) {
                kotlin.k0.i.b.c();
                if (this.f9460f != 0) goto L14;
                w.b(r3);
                com.obric.matrix.r.c.c.b(TeaTrackerImpl.TAG, "DeviceIdManager.onInstallIdReady 通知各listener们installId获取到了,installId=" + this.f9461g + ", listener = " + this.f9462h);     // Catch: Throwable -> L9
                com.obric.matrix.ostracker_api.a r4 = this.f9462h;     // Catch: Throwable -> L9
                if (r4 == null) goto L12;
                r4.b(this.f9461g);     // Catch: Throwable -> L9
            L12:
                return f0.f18324a;
            L9:
                th = move-exception;
                com.obric.matrix.r.c.c.g(TeaTrackerImpl.TAG, "DeviceIdManager.onInstallIdReady通知各listener们installId获取到了出错了", th);
                goto L12
            L14:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        c(TeaTrackerImpl r1) {
            this.f9456a = r1;
        }

        @Override // com.obric.matrix.dataanalysis.h.b
        public void a(String r9) {
            o.f(r9, "installId");
            com.obric.matrix.r.c.c.b(TeaTrackerImpl.TAG, "DeviceIdManager.onInstallIdReady called with: installId = " + r9);
            if (r9.length() != 0) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == false) goto L9;
            return;
        L9:
            if (o.a(r9, BDLocationException.ERROR_TIMEOUT) == false) goto L11;
            return;
        L11:
            if (o.a(r9, "-1") == true) goto L29;
            com.obric.matrix.r.c.c.b(TeaTrackerImpl.TAG, "DeviceIdManager.onInstallIdReady 回调的值合法，设置给sInstallId, installId = " + r9);
            TeaTrackerImpl.Companion.d(r9);
            CopyOnWriteArrayList r1 = TeaTrackerImpl.access$getMTeaTrackerListeners$p(this.f9456a);
            TeaTrackerImpl r8 = this.f9456a;
            monitor-enter(r1);
            Iterator r10 = TeaTrackerImpl.access$getMTeaTrackerListeners$p(r8).iterator();     // Catch: Throwable -> L22
        L17:
            if (r10.hasNext() == false) goto L19;
            h.a.h.b(n0.b(), b1.a(), null, new b(r9, (com.obric.matrix.ostracker_api.a) r10.next(), null), 2, null);     // Catch: Throwable -> L22
            goto L17
        L19:
            f0 r11 = f0.f18324a;     // Catch: Throwable -> L22
            monitor-exit(r1);
            return;
        L22:
            th = move-exception;
            throw th;
        L29:
            return;
        L5:
            r0 = false;
            goto L6
        }

        @Override // com.obric.matrix.dataanalysis.h.b
        public void b(String r9) {
            o.f(r9, "did");
            com.obric.matrix.r.c.c.b(TeaTrackerImpl.TAG, "DeviceIdManager.onDeviceIdReady called with: did = " + r9);
            if (r9.length() != 0) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == false) goto L9;
            return;
        L9:
            if (o.a(r9, BDLocationException.ERROR_TIMEOUT) == false) goto L11;
            return;
        L11:
            if (o.a(r9, "-1") == true) goto L29;
            com.obric.matrix.r.c.c.b(TeaTrackerImpl.TAG, "DeviceIdManager.onDeviceIdReady 回调的值合法，设置给sDid, did = " + r9);
            TeaTrackerImpl.Companion.c(r9);
            CopyOnWriteArrayList r1 = TeaTrackerImpl.access$getMTeaTrackerListeners$p(this.f9456a);
            TeaTrackerImpl r8 = this.f9456a;
            monitor-enter(r1);
            Iterator r10 = TeaTrackerImpl.access$getMTeaTrackerListeners$p(r8).iterator();     // Catch: Throwable -> L22
        L17:
            if (r10.hasNext() == false) goto L19;
            h.a.h.b(n0.b(), b1.a(), null, new a(r9, (com.obric.matrix.ostracker_api.a) r10.next(), null), 2, null);     // Catch: Throwable -> L22
            goto L17
        L19:
            f0 r11 = f0.f18324a;     // Catch: Throwable -> L22
            monitor-exit(r1);
            return;
        L22:
            th = move-exception;
            throw th;
        L29:
            return;
        L5:
            r0 = false;
            goto L6
        }
    }

    static {
        Companion = new a(null);
    }

    public TeaTrackerImpl() {
        this.initialized = new AtomicBoolean(false);
        this.mTeaTrackerListeners = new CopyOnWriteArrayList();
    }

    public static final /* synthetic */ CopyOnWriteArrayList access$getMTeaTrackerListeners$p(TeaTrackerImpl r0) {
        return r0.mTeaTrackerListeners;
    }

    public static final /* synthetic */ String access$getSDid$cp() {
        return sDid;
    }

    public static final /* synthetic */ String access$getSInstallId$cp() {
        return sInstallId;
    }

    public static final /* synthetic */ void access$setSDid$cp(String r0) {
        sDid = r0;
    }

    public static final /* synthetic */ void access$setSInstallId$cp(String r0) {
        sInstallId = r0;
    }

    private final boolean useBdTracker() {
        return false;
    }

    @Override // com.obric.matrix.ostracker_api.IOSTracker
    public void addTeaTrackerListener(com.obric.matrix.ostracker_api.a r3) {
        if (useBdTracker() == false) goto L5;
        return;
    L5:
        if (r3 == null) goto L13;
        this.mTeaTrackerListeners.add(r3);
        if (i.a(sDid) == false) goto L10;
        com.obric.matrix.r.c.c.b(TAG, "addTeaTrackerListener时，sDid有值，立即回调 DID = " + sDid);
        r3.a(sDid);
    L10:
        if (i.a(sInstallId) == false) goto L14;
        com.obric.matrix.r.c.c.b(TAG, "addTeaTrackerListener时，sInstallId有值，立即回调 installId = " + sInstallId);
        r3.b(sInstallId);
        return;
    L14:
        return;
    }

    @Override // com.obric.matrix.ostracker_api.IOSTracker
    public String getDeviceId() {
        if (useBdTracker() == false) goto L11;
        IBdtrackerService r3 = (IBdtrackerService) com.bytedance.news.common.service.manager.d.a(IBdtrackerService.class);
        if (r3 == null) goto L8;
        String r4 = r3.getDeviceId();
        if (r4 == null) goto L8;
        return r4;
    L8:
        return "";
    L11:
        if (i.a(sDid) == false) goto L14;
        com.obric.matrix.r.c.c.j(TAG, "getDeviceId()被调用，且数据合法，直接返回, sDid = " + sDid);
        return sDid;
    L14:
        String r5 = h.f9059i.a().p();
        com.obric.matrix.r.c.c.j(TAG, "getDeviceId()被调用，但数据不合法，从DeviceIdManager获取, did = " + r5);
        return r5;
    }

    @Override // com.obric.matrix.ostracker_api.IOSTracker
    public String getInstallId() {
        if (useBdTracker() == false) goto L11;
        IBdtrackerService r3 = (IBdtrackerService) com.bytedance.news.common.service.manager.d.a(IBdtrackerService.class);
        if (r3 == null) goto L8;
        String r4 = r3.getInstallId();
        if (r4 == null) goto L8;
        return r4;
    L8:
        return "";
    L11:
        if (i.a(sInstallId) == false) goto L14;
        com.obric.matrix.r.c.c.j(TAG, "getInstallId()被调用，且数据合法，直接返回, sInstallId = " + sInstallId);
        return sInstallId;
    L14:
        String r5 = h.f9059i.a().q();
        com.obric.matrix.r.c.c.j(TAG, "getInstallId()被调用，但数据不合法，从DeviceIdManager获取, installId = " + r5);
        return r5;
    }

    @Override // com.obric.matrix.ostracker_api.IOSTracker
    public String getUDID() {
        if (useBdTracker() == false) goto L10;
        IBdtrackerService r0 = (IBdtrackerService) com.bytedance.news.common.service.manager.d.a(IBdtrackerService.class);
        if (r0 != null) goto L11;
        return null;
    L11:
        return r0.getClientUdid();
    L10:
        return e.e();
    }

    @Override // com.obric.matrix.ostracker_api.IOSTracker
    public void init() {
        com.obric.matrix.r.c.c.b(TAG, "init() called");
        h.a r1 = h.f9059i;
        sDid = r1.a().p();
        sInstallId = r1.a().q();
        if (this.initialized.compareAndSet(false, true) == false) goto L5;
        com.obric.matrix.base.env.d.f8838a.a(TAG, new b(this));
    L5:
        r1.a().l(new c(this));
    }

    @Override // com.obric.matrix.ostracker_api.IOSTracker
    public void onEvent(String r2, JSONObject r3) {
        o.f(r2, NotificationCompat.CATEGORY_EVENT);
        if (useBdTracker() == false) goto L8;
        IBdtrackerService r1 = (IBdtrackerService) com.bytedance.news.common.service.manager.d.a(IBdtrackerService.class);
        if (r1 == null) goto L11;
        r1.onEventV3(r2, r3);
        return;
    L11:
        return;
    L8:
        if (this.initialized.get() == false) goto L13;
        e.g(r2, r3);
        return;
    }

    @Override // com.obric.matrix.ostracker_api.IOSTracker
    public void putCommonParams(Context r1, Map<String, String> r2, boolean r3, int r4) {
        o.f(r1, "context");
        com.bytedance.bdinstall.i.p(r1, r2, true, a.a(Companion, r4));
    }

    @Override // com.obric.matrix.ostracker_api.IOSTracker
    public void removeTeaTrackerListener(com.obric.matrix.ostracker_api.a r1) {
        if (r1 == null) goto L5;
        this.mTeaTrackerListeners.remove(r1);
        return;
    }

    @Override // com.obric.matrix.ostracker_api.IOSTracker
    public void setBoe(boolean r1) {
        BdInstallImpl.setUseBoeEnv(r1);
    }
}
