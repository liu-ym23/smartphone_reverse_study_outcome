package com.obric.matrix.dataanalysis;

import android.app.Service;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Binder;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.provider.Settings;
import com.bytedance.common.wschannel.WsConstants;
import h.a.m0;
import h.a.n0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.i0.r;
import kotlin.k0.j.a.l;
import kotlin.n0.c.p;
import kotlin.n0.d.o;
import kotlin.n0.d.q;
import kotlin.w;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f*\u0002\u0006\u0017\u0018\u0000 92\u00020\u0001:\u00029:B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0013H\u0002J\n\u0010\"\u001a\u0004\u0018\u00010\nH\u0002J\n\u0010#\u001a\u0004\u0018\u00010\nH\u0002J\u0010\u0010$\u001a\u00020 2\u0006\u0010%\u001a\u00020&H\u0002J\b\u0010'\u001a\u00020 H\u0002J\b\u0010(\u001a\u00020\u000fH\u0002J\u0014\u0010)\u001a\u0004\u0018\u00010*2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\b\u0010-\u001a\u00020 H\u0016J\b\u0010.\u001a\u00020 H\u0016J\b\u0010/\u001a\u00020 H\u0002J\b\u00100\u001a\u00020 H\u0002J\u001c\u00101\u001a\u00020 2\b\u00102\u001a\u0004\u0018\u00010\n2\b\u00103\u001a\u0004\u0018\u00010\nH\u0002J\b\u00104\u001a\u00020 H\u0002J\u0012\u00105\u001a\u00020 2\b\u00106\u001a\u0004\u0018\u00010\nH\u0002J\u0012\u00107\u001a\u00020 2\b\u00108\u001a\u0004\u0018\u00010\nH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0018R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lcom/obric/matrix/dataanalysis/DataService;", "Landroid/app/Service;", "()V", "backgroundHandler", "Landroid/os/Handler;", "binder", "com/obric/matrix/dataanalysis/DataService$binder$1", "Lcom/obric/matrix/dataanalysis/DataService$binder$1;", "blackList", "", "", "handlerThread", "Landroid/os/HandlerThread;", "isInitDeviceId", "Ljava/util/concurrent/atomic/AtomicReference;", "", "isUserSetupCompleted", "mCallbacks", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/obric/matrix/platform/sdk/ones/dataanalysis/IDeviceInfoCallback;", "myDid", "myInstallId", "observer", "com/obric/matrix/dataanalysis/DataService$observer$1", "Lcom/obric/matrix/dataanalysis/DataService$observer$1;", "pendingEvents", "", "Lcom/obric/matrix/dataanalysis/DataService$EventData;", "settingsObserver", "Landroid/database/ContentObserver;", "settingsObserver2", "dispatchCurrentDeviceInfo", "", "callback", "getMyDeviceId", "getMyInstallId", "handleSettingsChange", "uri", "Landroid/net/Uri;", "initDeviceIdGet", "isProvisionLicenseAgree", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onCreate", "onDestroy", "reTryInit", "registerSettingsObserverIfNeeded", "report", "eventName", "jsonString", "retryGetDeviceId", "updateMyDid", "newDid", "updateMyInstallid", "newInstallId", "Companion", "EventData", "dataanalysis_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DataService extends Service {
    public static final a Companion = null;
    private static final String DEVICE_PROVISIONED = "device_provisioned";
    private static final String DEVICE_PROVISIONED_LICENSE_AGREE = "provision_license_agree";
    public static final String TAG = "MatrixDeviceIdService";
    private Handler backgroundHandler;
    private final c binder;
    private final List<String> blackList;
    private HandlerThread handlerThread;
    private final AtomicReference<Boolean> isInitDeviceId;
    private volatile boolean isUserSetupCompleted;
    private final CopyOnWriteArrayList<com.obric.matrix.platform.d.a.b.b> mCallbacks;
    private final AtomicReference<String> myDid;
    private final AtomicReference<String> myInstallId;
    private final e observer;
    private final List<b> pendingEvents;
    private ContentObserver settingsObserver;
    private ContentObserver settingsObserver2;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/matrix/dataanalysis/DataService$Companion;", "", "()V", "DEVICE_PROVISIONED", "", "DEVICE_PROVISIONED_LICENSE_AGREE", "TAG", "dataanalysis_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.n0.d.g r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/obric/matrix/dataanalysis/DataService$EventData;", "", "eventName", "", "eventContent", "(Ljava/lang/String;Ljava/lang/String;)V", "getEventContent", "()Ljava/lang/String;", "getEventName", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "dataanalysis_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f9017a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f9018b;

        public b(String r1, String r2) {
            this.f9017a = r1;
            this.f9018b = r2;
        }

        public final String a() {
            return this.f9017a;
        }

        public final String b() {
            return this.f9018b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (o.a(this.f9017a, r6.f9017a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f9018b, r6.f9018b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            String r0 = this.f9017a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            String r4 = this.f9018b;
            if (r4 == null) goto L11;
            r1 = r4.hashCode();
        L11:
            return r3 + r1;
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public String toString() {
            return "EventData(eventName=" + this.f9017a + ", eventContent=" + this.f9018b + ')';
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u001c\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010\t\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\f\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\r"}, d2 = {"com/obric/matrix/dataanalysis/DataService$binder$1", "Lcom/obric/matrix/platform/sdk/ones/dataanalysis/IDataService$Stub;", "getDeviceId", "", "getInstallId", "onEvent", "", "eventName", "jsonString", "registerDeviceInfoListener", "callback", "Lcom/obric/matrix/platform/sdk/ones/dataanalysis/IDeviceInfoCallback;", "unregisterDeviceInfoListener", "dataanalysis_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class c extends com.obric.matrix.platform.d.a.b.a.AbstractBinderC0258a {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ DataService f9019f;

        @kotlin.k0.j.a.f(c = "com.obric.matrix.dataanalysis.DataService$binder$1$onEvent$1", f = "DataService.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
        static final class a extends l implements p<m0, kotlin.k0.d<? super f0>, Object> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            int f9020f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ DataService f9021g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ String f9022h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            final /* synthetic */ String f9023i;

            a(DataService r1, String r2, String r3, kotlin.k0.d<? super a> r4) {
                this.f9021g = r1;
                this.f9022h = r2;
                this.f9023i = r3;
                super(2, r4);
            }

            @Override // kotlin.k0.j.a.a
            public final kotlin.k0.d<f0> create(Object r3, kotlin.k0.d<?> r4) {
                return new a(this.f9021g, this.f9022h, this.f9023i, r4);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(m0 r1, kotlin.k0.d<? super f0> r2) {
                return ((a) create(r1, r2)).invokeSuspend(f0.f18324a);
            }

            @Override // kotlin.n0.c.p
            public /* bridge */ /* synthetic */ Object invoke(m0 r1, kotlin.k0.d<? super f0> r2) {
                return invoke2(r1, r2);
            }

            @Override // kotlin.k0.j.a.a
            public final Object invokeSuspend(Object r4) {
                kotlin.k0.i.b.c();
                if (this.f9020f != 0) goto L11;
                w.b(r4);
                if (DataService.access$isUserSetupCompleted$p(this.f9021g) == false) goto L7;
                DataService.access$report(this.f9021g, this.f9022h, this.f9023i);
            L9:
                return f0.f18324a;
            L7:
                DataService.access$getPendingEvents$p(this.f9021g).add(new b(this.f9022h, this.f9023i));
                com.obric.matrix.r.c.c.j(DataService.TAG, "onEvent 用户未完成设置，暂存事件: " + this.f9022h + "，当前暂存数量: " + DataService.access$getPendingEvents$p(this.f9021g).size());
                goto L9
            L11:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
        static final class b extends q implements kotlin.n0.c.a<f0> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ int f9024f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ int f9025g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ DataService f9026h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            final /* synthetic */ com.obric.matrix.platform.d.a.b.b f9027i;

            b(int r1, int r2, DataService r3, com.obric.matrix.platform.d.a.b.b r4) {
                this.f9024f = r1;
                this.f9025g = r2;
                this.f9026h = r3;
                this.f9027i = r4;
                super(0);
            }

            @Override // kotlin.n0.c.a
            public /* bridge */ /* synthetic */ f0 invoke() {
                invoke2();
                return f0.f18324a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                com.obric.matrix.r.c.c.s(DataService.TAG, "客户端进程死亡，自动清理 mCallbacks 中的 stale callback, uid=" + this.f9024f + ", pid=" + this.f9025g);
                DataService.access$getMCallbacks$p(this.f9026h).remove(this.f9027i);
            }
        }

        c(DataService r1) {
            this.f9019f = r1;
        }

        public static /* synthetic */ void k(DataService r0, com.obric.matrix.platform.d.a.b.b r1) {
            m(r0, r1);
        }

        private static final void m(DataService r1, com.obric.matrix.platform.d.a.b.b r2) {
            o.f(r1, "this$0");
            o.f(r2, "$it");
            DataService.access$dispatchCurrentDeviceInfo(r1, r2);
        }

        @Override // com.obric.matrix.platform.d.a.b.a
        public void Y(final com.obric.matrix.platform.d.a.b.b r10) {
            f0 r0 = null;
            if (r10 == null) goto L21;
            final DataService r9 = this.f9019f;
            int r5 = Binder.getCallingPid();
            int r4 = Binder.getCallingUid();
            String[] r2 = r9.getPackageManager().getPackagesForUid(r4);
            if (r2 == null) goto L8;
            o.e(r2, "getPackagesForUid(uid)");
            String r3 = (String) kotlin.i0.i.x(r2);
            if (r3 == null) goto L8;
        L9:
            String r6 = r3;
            com.obric.matrix.dataanalysis.k.c r7 = com.obric.matrix.dataanalysis.k.c.f9078a;
            if (r7.a(r5) == false) goto L13;
            com.obric.matrix.r.c.c.f(DataService.TAG, "registerDeviceInfoListener: Rejected due to excessive callbacks from PID " + r5 + ", UID " + r4 + " ,pkgName = " + r6);
            return;
        L13:
            IBinder r8 = r10.asBinder();
            o.e(r8, "it.asBinder()");
            r7.e(r8, r4, r5, r6, "registerDeviceInfoListener", new b(r4, r5, r9, r10));
            if (DataService.access$getMCallbacks$p(r9).contains(r10) == true) goto L16;
            DataService.access$getMCallbacks$p(r9).add(r10);
            com.obric.matrix.r.c.c.j(DataService.TAG, "registerDeviceInfoListener添加callback, " + r10 + " , sizes=" + DataService.access$getMCallbacks$p(r9).size());
        L16:
            Handler r11 = DataService.access$getBackgroundHandler$p(r9);
            if (r11 == null) goto L19;
            r11.post(new com.obric.matrix.dataanalysis.d(r9, r10));
            com.obric.matrix.r.c.c.j(DataService.TAG, "registerDeviceInfoListener 11111");
            r0 = f0.f18324a;
            goto L21
        L19:
            o.v("backgroundHandler");
            throw null;
        L8:
            r3 = "uid:" + r4;
        L21:
            if (r0 != null) goto L24;
            com.obric.matrix.r.c.c.j(DataService.TAG, "registerDeviceInfoListener失败，callback为空");
            return;
        }

        @Override // com.obric.matrix.platform.d.a.b.a
        public void a0(com.obric.matrix.platform.d.a.b.b r5) {
            if (r5 == null) goto L5;
            DataService r4 = this.f9019f;
            com.obric.matrix.dataanalysis.k.c r1 = com.obric.matrix.dataanalysis.k.c.f9078a;
            IBinder r2 = r5.asBinder();
            o.e(r2, "it.asBinder()");
            r1.h(r2);
            DataService.access$getMCallbacks$p(r4).remove(r5);
            com.obric.matrix.r.c.c.j(DataService.TAG, "unregisterDeviceInfoListener");
            f0 r6 = f0.f18324a;
        L6:
            if (r6 != null) goto L9;
            com.obric.matrix.r.c.c.j(DataService.TAG, "unregisterDeviceInfoListener失败，callback为空");
            return;
        L9:
            return;
        L5:
            r6 = null;
            goto L6
        }

        @Override // com.obric.matrix.platform.d.a.b.a
        public String getDeviceId() {
            String r0 = DataService.access$getMyDeviceId(this.f9019f);
            if (r0 != null) goto L6;
            return "";
        L6:
            return r0;
        }

        @Override // com.obric.matrix.platform.d.a.b.a
        public String getInstallId() {
            String r0 = DataService.access$getMyInstallId(this.f9019f);
            if (r0 != null) goto L6;
            return "";
        L6:
            return r0;
        }

        @Override // com.obric.matrix.platform.d.a.b.a
        public void onEvent(String r7, String r8) {
            if (r8 != null) goto L21;
        L11:
            int r1 = 0;
        L13:
            if (r1 <= 204800) goto L17;
            com.obric.matrix.r.c.c.f(DataService.TAG, "事件 " + r7 + " 数据大小 " + r1 + " 字节超过200KB限制，已丢弃");
            return;
        L17:
            if (DataService.access$isUserSetupCompleted$p(this.f9019f) == false) goto L19;
            DataService.access$report(this.f9019f, r7, r8);
            return;
        L19:
            h.a.h.b(n0.b(), null, null, new a(this.f9019f, r7, r8, null), 3, null);
            return;
        L21:
            byte[] r2 = r8.getBytes(kotlin.u0.d.f21429a);     // Catch: Throwable -> L8
            o.e(r2, "this as java.lang.String).getBytes(charset)");     // Catch: Throwable -> L8
            if (r2 == null) goto L11;
            r1 = r2.length;     // Catch: Throwable -> L8
        L8:
            th = move-exception;
            com.obric.matrix.r.c.c.g(DataService.TAG, "计算事件大小失败，已丢弃事件 " + r7, th);
        }
    }

    @kotlin.k0.j.a.f(c = "com.obric.matrix.dataanalysis.DataService$handleSettingsChange$1", f = "DataService.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class d extends l implements p<m0, kotlin.k0.d<? super f0>, Object> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f9028f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f9029g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ DataService f9030h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ Uri f9031i;

        d(String r1, DataService r2, Uri r3, kotlin.k0.d<? super d> r4) {
            this.f9029g = r1;
            this.f9030h = r2;
            this.f9031i = r3;
            super(2, r4);
        }

        @Override // kotlin.k0.j.a.a
        public final kotlin.k0.d<f0> create(Object r3, kotlin.k0.d<?> r4) {
            return new d(this.f9029g, this.f9030h, this.f9031i, r4);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(m0 r1, kotlin.k0.d<? super f0> r2) {
            return ((d) create(r1, r2)).invokeSuspend(f0.f18324a);
        }

        @Override // kotlin.n0.c.p
        public /* bridge */ /* synthetic */ Object invoke(m0 r1, kotlin.k0.d<? super f0> r2) {
            return invoke2(r1, r2);
        }

        @Override // kotlin.k0.j.a.a
        public final Object invokeSuspend(Object r6) {
            kotlin.k0.i.b.c();
            if (this.f9028f != 0) goto L23;
            w.b(r6);
            if (o.a(this.f9029g, DataService.DEVICE_PROVISIONED) == false) goto L7;
        L8:
            int r7 = Settings.Global.getInt(this.f9030h.getContentResolver(), this.f9029g);
            DataService r0 = this.f9030h;
            if (r7 == 0) goto L11;
            boolean r1 = true;
        L12:
            DataService.access$setUserSetupCompleted$p(r0, r1);
            if (DataService.access$isUserSetupCompleted$p(this.f9030h) == false) goto L19;
            com.obric.matrix.r.c.c.j(DataService.TAG, "handleSettingsChange, isUserSetupCompleted: " + DataService.access$isUserSetupCompleted$p(this.f9030h));
            List r2 = DataService.access$getPendingEvents$p(this.f9030h);
            DataService r3 = this.f9030h;
            Iterator r4 = r2.iterator();
        L16:
            if (r4.hasNext() == false) goto L18;
            b r5 = (b) r4.next();
            DataService.access$report(r3, r5.a(), r5.b());
            goto L16
        L18:
            DataService.access$getPendingEvents$p(this.f9030h).clear();
        L19:
            com.obric.matrix.r.c.c.j(DataService.TAG, "handleSettingsChange, uri: " + this.f9031i + ", key: " + this.f9029g + ", value: " + r7);
        L21:
            return f0.f18324a;
        L11:
            r1 = false;
            goto L12
        L7:
            if (o.a(this.f9029g, DataService.DEVICE_PROVISIONED_LICENSE_AGREE) == false) goto L21;
        L23:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J&\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0016J\u001a\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010\u0010\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000fH\u0016JL\u0010\u0012\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0019"}, d2 = {"com/obric/matrix/dataanalysis/DataService$observer$1", "Lcom/bytedance/applog/IDataObserver;", "onAbVidsChange", "", "vids", "", "extVids", "onIdLoaded", "did", WsConstants.KEY_INSTALL_ID, "ssid", "onRemoteAbConfigGet", "changed", "", "abConfig", "Lorg/json/JSONObject;", "onRemoteConfigGet", "config", "onRemoteIdGet", "oldDid", "newDid", "oldIid", "newIid", "oldSsid", "newSsid", "dataanalysis_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class e implements com.bytedance.applog.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ DataService f9032a;

        e(DataService r1) {
            this.f9032a = r1;
        }

        @Override // com.bytedance.applog.e
        public void a(boolean r1, String r2, String r3, String r4, String r5, String r6, String r7) {
            if (i.a(r3) == false) goto L6;
            com.obric.matrix.r.c.c.j(DataService.TAG, "observer onRemoteIdGet oldDid = " + r2 + ", newDid is   = " + r3);
            DataService.access$updateMyDid(this.f9032a, r3);
        L6:
            if (i.a(r5) == false) goto L9;
            com.obric.matrix.r.c.c.j(DataService.TAG, "observer onRemoteIdGet oldIid = " + r4 + ", newIid is   = " + r5);
            DataService.access$updateMyInstallid(this.f9032a, r5);
            return;
        }

        @Override // com.bytedance.applog.e
        public void b(String r4, String r5, String r6) {
            com.obric.matrix.r.c.c.j(DataService.TAG, "observer onIdLoaded  did = " + r4 + ", iid = " + r5 + ", ssid = " + r6);
            if (i.a(r4) == false) goto L6;
            com.obric.matrix.r.c.c.j(DataService.TAG, "observer onIdLoaded  did = " + r4);
            DataService.access$updateMyDid(this.f9032a, r4);
        L6:
            if (i.a(r5) == false) goto L9;
            com.obric.matrix.r.c.c.j(DataService.TAG, "observer onIdLoaded  iid = " + r5);
            DataService.access$updateMyInstallid(this.f9032a, r5);
            return;
        }

        @Override // com.bytedance.applog.e
        public void c(boolean r1, JSONObject r2) {
        }

        @Override // com.bytedance.applog.e
        public void d(String r1, String r2) {
        }

        @Override // com.bytedance.applog.e
        public void e(boolean r1, JSONObject r2) {
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/obric/matrix/dataanalysis/DataService$registerSettingsObserverIfNeeded$1", "Landroid/database/ContentObserver;", "onChange", "", "selfChange", "", "uri", "Landroid/net/Uri;", "dataanalysis_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class f extends ContentObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ DataService f9033a;

        f(DataService r1, Handler r2) {
            this.f9033a = r1;
            super(r2);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean r3, Uri r4) {
            super.onChange(r3, r4);
            com.obric.matrix.r.c.c.b(DataService.TAG, "onChange, selfChange: " + r3 + ", uri: " + r4);
            if (r4 == null) goto L6;
            DataService.access$handleSettingsChange(this.f9033a, r4);
            return;
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/obric/matrix/dataanalysis/DataService$registerSettingsObserverIfNeeded$3", "Landroid/database/ContentObserver;", "onChange", "", "selfChange", "", "uri", "Landroid/net/Uri;", "dataanalysis_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class g extends ContentObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ DataService f9034a;

        g(DataService r1, Handler r2) {
            this.f9034a = r1;
            super(r2);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean r3, Uri r4) {
            super.onChange(r3, r4);
            com.obric.matrix.r.c.c.b(DataService.TAG, "onChange, selfChange: " + r3 + ", uri: " + r4);
            if (r4 == null) goto L6;
            DataService.access$handleSettingsChange(this.f9034a, r4);
            return;
        }
    }

    static {
        Companion = new a(null);
    }

    public DataService() {
        this.pendingEvents = new ArrayList();
        this.mCallbacks = new CopyOnWriteArrayList();
        this.myDid = new AtomicReference(null);
        this.myInstallId = new AtomicReference(null);
        this.isInitDeviceId = new AtomicReference(Boolean.FALSE);
        this.observer = new e(this);
        this.binder = new c(this);
        this.blackList = r.j(new String[]{"apm_event_fps", "cloudservice_kvsync_cdn_node_info", "matrix_ws_channel_try_connect", "matrix_ws_channel_try_connect_error"});
    }

    public static /* synthetic */ void a(DataService r0) {
        m58retryGetDeviceId$lambda8(r0);
    }

    public static final /* synthetic */ void access$dispatchCurrentDeviceInfo(DataService r0, com.obric.matrix.platform.d.a.b.b r1) {
        r0.dispatchCurrentDeviceInfo(r1);
    }

    public static final /* synthetic */ Handler access$getBackgroundHandler$p(DataService r0) {
        return r0.backgroundHandler;
    }

    public static final /* synthetic */ CopyOnWriteArrayList access$getMCallbacks$p(DataService r0) {
        return r0.mCallbacks;
    }

    public static final /* synthetic */ String access$getMyDeviceId(DataService r0) {
        return r0.getMyDeviceId();
    }

    public static final /* synthetic */ String access$getMyInstallId(DataService r0) {
        return r0.getMyInstallId();
    }

    public static final /* synthetic */ List access$getPendingEvents$p(DataService r0) {
        return r0.pendingEvents;
    }

    public static final /* synthetic */ void access$handleSettingsChange(DataService r0, Uri r1) {
        r0.handleSettingsChange(r1);
    }

    public static final /* synthetic */ boolean access$isUserSetupCompleted$p(DataService r0) {
        return r0.isUserSetupCompleted;
    }

    public static final /* synthetic */ void access$report(DataService r0, String r1, String r2) {
        r0.report(r1, r2);
    }

    public static final /* synthetic */ void access$setUserSetupCompleted$p(DataService r0, boolean r1) {
        r0.isUserSetupCompleted = r1;
    }

    public static final /* synthetic */ void access$updateMyDid(DataService r0, String r1) {
        r0.updateMyDid(r1);
    }

    public static final /* synthetic */ void access$updateMyInstallid(DataService r0, String r1) {
        r0.updateMyInstallid(r1);
    }

    public static /* synthetic */ void b(DataService r0) {
        m57reTryInit$lambda7(r0);
    }

    public static /* synthetic */ void c(DataService r0) {
        m56onBind$lambda6$lambda5(r0);
    }

    public static /* synthetic */ void d(DataService r0) {
        m55onBind$lambda6(r0);
    }

    private final void dispatchCurrentDeviceInfo(com.obric.matrix.platform.d.a.b.b r5) {
        String r0 = getMyDeviceId();
        com.obric.matrix.r.c.c.j(TAG, "registerDeviceInfoListener时，currentDid = " + r0);
        if (i.a(r0) == true) goto L15;
    L8:
        String r4 = getMyInstallId();
        com.obric.matrix.r.c.c.j(TAG, "registerDeviceInfoListener时，currentInstallId = " + r4);
        if (i.a(r4) == false) goto L19;
        r5.Q(r4);     // Catch: Exception -> L12
        com.obric.matrix.r.c.c.j(TAG, "registerDeviceInfoListener:currentInstallId合法 立即回调 installId = " + r4);     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        com.obric.matrix.r.c.c.g(TAG, "dispatchCurrentDeviceInfo 回调onInstallId异常", e);
        return;
    L19:
        return;
    L15:
        r5.l(r0);     // Catch: Exception -> L6
        com.obric.matrix.r.c.c.j(TAG, "registerDeviceInfoListener:currentDid合法 立即回调 DID = " + r0);     // Catch: Exception -> L6
    L6:
        e = move-exception;
        com.obric.matrix.r.c.c.g(TAG, "dispatchCurrentDeviceInfo 回调onDeviceId异常", e);
        goto L8
    }

    private final String getMyDeviceId() {
        String r0 = this.myDid.get();
        if (i.a(r0) == false) goto L6;
        com.obric.matrix.r.c.c.j(TAG, "getMyDeviceId时,myDid.get()的值合法，立即回调 " + r0);
        return r0;
    L6:
        String r1 = com.bytedance.applog.a.k();
        boolean r2 = i.a(r1);
        AtomicReference<String> r3 = this.myDid;
        if (r2 == false) goto L10;
        r3.set(r1);
        com.obric.matrix.r.c.c.j(TAG, "getMyDeviceId时，AppLog.getDid()有值，立即回调 " + r1);
        DeviceIdUtil r4 = DeviceIdUtil.INSTANCE;
        o.e(r1, "newDid");
        r4.setDeviceId(r1);
        return r1;
    L10:
        String r5 = r3.get();
        if (r5 != null) goto L14;
        return "";
    L14:
        return r5;
    }

    private final String getMyInstallId() {
        String r0 = this.myInstallId.get();
        if (i.a(r0) == false) goto L6;
        com.obric.matrix.r.c.c.j(TAG, "getMyInstallId时,myInstallId.get()的值合法，立即回调 " + r0);
        return r0;
    L6:
        String r1 = com.bytedance.applog.a.r();
        boolean r2 = i.a(r1);
        AtomicReference<String> r3 = this.myInstallId;
        if (r2 == false) goto L10;
        r3.set(r1);
        com.obric.matrix.r.c.c.j(TAG, "getMyInstallId时，AppLog.getIid()有值，立即回调 " + r1);
        DeviceIdUtil r4 = DeviceIdUtil.INSTANCE;
        o.e(r1, "newIid");
        r4.setInstallId(r1);
        return r1;
    L10:
        String r5 = r3.get();
        if (r5 != null) goto L14;
        return "";
    L14:
        return r5;
    }

    private final void handleSettingsChange(Uri r8) {
        String r0 = r8.getLastPathSegment();
        h.a.h.b(n0.b(), null, null, new d(r0, this, r8, null), 3, null);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        com.obric.matrix.r.c.c.f(TAG, "handleSettingsChange, key: " + r0 + ", error: " + e.getMessage());
    }

    private final void initDeviceIdGet() {
        Boolean r0 = this.isInitDeviceId.get();
        o.e(r0, "isInitDeviceId.get()");
        if (r0.booleanValue() == false) goto L6;
        com.obric.matrix.r.c.c.j(TAG, "initDeviceIdGet 已被调用，无需重复调用");
        return;
    L6:
        com.obric.matrix.r.c.c.j(TAG, "initDeviceIdGet start");
        this.isInitDeviceId.set(Boolean.TRUE);
        com.obric.matrix.server.t.a.c.f10010a.e(this, this.observer, "508474");
        retryGetDeviceId();
    }

    private final boolean isProvisionLicenseAgree() {
        if (Settings.Global.getInt(getContentResolver(), DEVICE_PROVISIONED_LICENSE_AGREE, 0) == 1) goto L7;
        if (Settings.Global.getInt(getContentResolver(), DEVICE_PROVISIONED, 0) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    /* JADX INFO: renamed from: onBind$lambda-6, reason: not valid java name */
    private static final void m55onBind$lambda6(final DataService r5) {
        o.f(r5, "this$0");
        String r0 = r5.getMyDeviceId();
        String r1 = r5.getMyInstallId();
        if (i.a(r0) == true) goto L5;
    L8:
        com.obric.matrix.r.c.c.j(TAG, "curDid 或 installId不合法，走forceGet逻辑, curDid = " + r0 + ", curInstallId = " + r1);
        if (r5.isProvisionLicenseAgree() == false) goto L11;
        r5.initDeviceIdGet();
        return;
    L11:
        com.obric.matrix.r.c.c.j(TAG, "provision_license_agree 为false，2s后重试");
        Handler r2 = r5.backgroundHandler;
        if (r2 == null) goto L15;
        r2.postDelayed(new com.obric.matrix.dataanalysis.c(r5), 2000);
        return;
    L15:
        o.v("backgroundHandler");
        throw null;
    L5:
        if (i.a(r1) == false) goto L8;
        com.obric.matrix.r.c.c.j(TAG, "curDid 和 installId合法，不需要走forceGet逻辑, did = " + r0 + ", installId = " + r1);
    }

    /* JADX INFO: renamed from: onBind$lambda-6$lambda-5, reason: not valid java name */
    private static final void m56onBind$lambda6$lambda5(DataService r1) {
        o.f(r1, "this$0");
        r1.reTryInit();
    }

    private final void reTryInit() {
        if (this.isInitDeviceId.get().booleanValue() == false) goto L5;
        return;
    L5:
        if (isProvisionLicenseAgree() == false) goto L7;
        initDeviceIdGet();
        return;
    L7:
        com.obric.matrix.r.c.c.j(TAG, "provision_license_agree 为false，继续重试");
        Handler r0 = this.backgroundHandler;
        if (r0 == null) goto L10;
        r0.postDelayed(new com.obric.matrix.dataanalysis.b(this), 2000);
        return;
    L10:
        o.v("backgroundHandler");
        throw null;
    }

    /* JADX INFO: renamed from: reTryInit$lambda-7, reason: not valid java name */
    private static final void m57reTryInit$lambda7(DataService r1) {
        o.f(r1, "this$0");
        r1.reTryInit();
    }

    private final void registerSettingsObserverIfNeeded() {
        int r3 = Settings.Global.getInt(getContentResolver(), DEVICE_PROVISIONED, 0);     // Catch: Exception -> L13
        int r5 = Settings.Global.getInt(getContentResolver(), DEVICE_PROVISIONED_LICENSE_AGREE, 0);     // Catch: Exception -> L13
        this.isUserSetupCompleted = isProvisionLicenseAgree();     // Catch: Exception -> L13
        com.obric.matrix.r.c.c.j(TAG, "registerSettingsObserverIfNeeded, isUserSetupComplete: " + r3 + ", isLicenseAgree: " + r5);     // Catch: Exception -> L13
        if (this.isUserSetupCompleted == true) goto L18;
        this.settingsObserver = new f(this, new Handler(Looper.getMainLooper()));     // Catch: Exception -> L13
        Uri r1 = Settings.Global.getUriFor(DEVICE_PROVISIONED);     // Catch: Exception -> L13
        if (r1 == null) goto L9;
        ContentResolver r6 = getContentResolver();     // Catch: Exception -> L13
        ContentObserver r7 = this.settingsObserver;     // Catch: Exception -> L13
        o.c(r7);     // Catch: Exception -> L13
        r6.registerContentObserver(r1, false, r7);     // Catch: Exception -> L13
        com.obric.matrix.r.c.c.b(TAG, "registerSettingsObserverIfNeeded, uri: " + r1);     // Catch: Exception -> L13
    L9:
        this.settingsObserver2 = new g(this, new Handler(Looper.getMainLooper()));     // Catch: Exception -> L13
        Uri r0 = Settings.Global.getUriFor(DEVICE_PROVISIONED_LICENSE_AGREE);     // Catch: Exception -> L13
        if (r0 == null) goto L19;
        ContentResolver r2 = getContentResolver();     // Catch: Exception -> L13
        ContentObserver r8 = this.settingsObserver2;     // Catch: Exception -> L13
        o.c(r8);     // Catch: Exception -> L13
        r2.registerContentObserver(r0, false, r8);     // Catch: Exception -> L13
        com.obric.matrix.r.c.c.b(TAG, "registerSettingsObserverIfNeeded, uri: " + r0);     // Catch: Exception -> L13
        return;
    L19:
        return;
    L18:
        return;
    L13:
        e = move-exception;
        com.obric.matrix.r.c.c.f(TAG, "registerSettingsObserverIfNeeded, error: " + e.getMessage());
    }

    private final void report(String r6, String r7) {
        f0 r1 = null;
        if (r6 != null) goto L22;
    L19:
        if (r1 != null) goto L25;
        com.obric.matrix.r.c.c.j(TAG, "report失败，eventName为空");
        return;
    L25:
        return;
    L22:
        Map<String, Object> r2 = com.obric.matrix.dataanalysis.g.f9042l.a(this).j(null);     // Catch: Exception -> L16
        if (r7 != null) goto L7;
        String r3 = "{}";
    L8:
        JSONObject r4 = new JSONObject(r3);     // Catch: Exception -> L16
        Iterator<Map.Entry<String, Object>> r5 = r2.entrySet().iterator();     // Catch: Exception -> L16
    L10:
        if (r5.hasNext() == false) goto L12;
        Map.Entry<String, Object> r8 = r5.next();     // Catch: Exception -> L16
        r4.put(r8.getKey(), r8.getValue());     // Catch: Exception -> L16
        goto L10
    L12:
        com.obric.matrix.ostracker_api.b.g(r6, r4);     // Catch: Exception -> L16
        if (this.blackList.contains(r6) == true) goto L18;
        com.obric.matrix.r.c.d.a("", "action:" + r6 + " jo:" + r7);     // Catch: Exception -> L16
    L18:
        r1 = f0.f18324a;
        goto L19
    L7:
        r3 = r7;
    L16:
        e = move-exception;
        com.obric.matrix.r.c.c.g(TAG, "report, eventName: " + r6 + " error", e);
        goto L18
    }

    private final void retryGetDeviceId() {
        String r0 = getMyDeviceId();
        String r1 = getMyInstallId();
        com.obric.matrix.r.c.c.j(TAG, "retryGetDeviceId， did = " + r0 + ", installId = " + r1);
        if (i.a(r0) == true) goto L5;
    L8:
        com.bytedance.applog.a.a(this.observer);
        if (com.obric.matrix.r.e.h.f9941a.c() == false) goto L11;
        com.obric.matrix.r.c.c.j(TAG, "网络可用，resetAndReInstall 执行,observer = " + this.observer);
        com.bytedance.bdinstall.i.s(this, com.bytedance.bdinstall.i.i(), 30000, null);
    L12:
        Handler r2 = this.backgroundHandler;
        if (r2 == null) goto L16;
        r2.postDelayed(new com.obric.matrix.dataanalysis.a(this), WsConstants.EXIT_DELAY_TIME);
        return;
    L16:
        o.v("backgroundHandler");
        throw null;
    L11:
        com.obric.matrix.r.c.c.j(TAG, "网络不可用，本次不执行resetAndReInstall");
        goto L12
    L5:
        if (i.a(r1) == false) goto L8;
        com.obric.matrix.r.c.c.j(TAG, "retryGetDeviceId， did和installId均合法，取消轮循逻辑, did = " + r0 + ", installId = " + r1);
        com.bytedance.applog.a.H(this.observer);
    }

    /* JADX INFO: renamed from: retryGetDeviceId$lambda-8, reason: not valid java name */
    private static final void m58retryGetDeviceId$lambda8(DataService r1) {
        o.f(r1, "this$0");
        r1.retryGetDeviceId();
    }

    private final void updateMyDid(String r5) {
        com.obric.matrix.r.c.c.j(TAG, "updateMyDid被调用, newDid=" + r5);
        if (i.a(r5) == false) goto L16;
        this.myDid.set(r5);
        DeviceIdUtil r0 = DeviceIdUtil.INSTANCE;
        if (r5 != null) goto L7;
        String r2 = "";
    L8:
        r0.setDeviceId(r2);
        com.obric.matrix.r.c.c.j(TAG, "updateMyDid时 mCallbacks的大小 = " + this.mCallbacks.size());
        Iterator<T> r4 = this.mCallbacks.iterator();
    L10:
        if (r4.hasNext() == false) goto L23;
        com.obric.matrix.platform.d.a.b.b r1 = (com.obric.matrix.platform.d.a.b.b) r4.next();
        com.obric.matrix.r.c.c.j(TAG, "通过mCallbacks遍历回调onDeviceId " + r5);     // Catch: Exception -> L14
        r1.l(r5);     // Catch: Exception -> L14
    L14:
        e = move-exception;
        com.obric.matrix.r.c.c.g(TAG, "updateMyDid 回调onDeviceId异常", e);
        goto L10
    L23:
        return;
    L7:
        r2 = r5;
        goto L8
    }

    private final void updateMyInstallid(String r5) {
        com.obric.matrix.r.c.c.j(TAG, "updateMyInstallid被调用, newInstallId=" + r5);
        if (i.a(r5) == false) goto L12;
        this.myInstallId.set(r5);
        com.obric.matrix.r.c.c.j(TAG, "updateMyInstallid时 mCallbacks的大小 = " + this.mCallbacks.size());
        Iterator<T> r4 = this.mCallbacks.iterator();
    L6:
        if (r4.hasNext() == false) goto L19;
        com.obric.matrix.platform.d.a.b.b r0 = (com.obric.matrix.platform.d.a.b.b) r4.next();
        com.obric.matrix.r.c.c.j(TAG, "通过mCallbacks遍历回调onInstallId " + r5);     // Catch: Exception -> L10
        r0.Q(r5);     // Catch: Exception -> L10
    L10:
        e = move-exception;
        com.obric.matrix.r.c.c.g(TAG, "updateMyInstallid 回调onInstallId异常", e);
        goto L6
    L19:
        return;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent r2) {
        com.obric.matrix.r.c.c.j(TAG, "onBind被调用了 ~~~~~~");
        Handler r3 = this.backgroundHandler;
        if (r3 == null) goto L6;
        r3.post(new com.obric.matrix.dataanalysis.e(this));
        return this.binder;
    L6:
        o.v("backgroundHandler");
        throw null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        registerSettingsObserverIfNeeded();
        HandlerThread r0 = new HandlerThread("DownloadHandlerThread");
        r0.start();
        this.handlerThread = r0;
        HandlerThread r1 = this.handlerThread;
        if (r1 == null) goto L6;
        this.backgroundHandler = new Handler(r1.getLooper());
        return;
    L6:
        o.v("handlerThread");
        throw null;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        ContentObserver r0 = this.settingsObserver;
        if (r0 == null) goto L5;
        getContentResolver().unregisterContentObserver(r0);
    L5:
        ContentObserver r1 = this.settingsObserver2;
        if (r1 == null) goto L9;
        getContentResolver().unregisterContentObserver(r1);
        return;
    }
}
