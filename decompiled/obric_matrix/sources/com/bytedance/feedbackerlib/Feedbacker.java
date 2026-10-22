package com.bytedance.feedbackerlib;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.feedbackerlib.m.p;
import com.bytedance.feedbackerlib.m.q;
import com.bytedance.feedbackerlib.m.t;
import com.bytedance.feedbackerlib.model.FeedbackCommonInfo;
import com.bytedance.feedbackerlib.provider.FeedbackerContentProvider;
import com.bytedance.feedbackerlib.service.FloatWindowService;
import d.b.k.a.r;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public class Feedbacker {
    private static final long DELAY_POLLING_CHECK = 300;
    private static final String KEY_FORCE_SSO = "com.bytedance.feedbackerlib.forceSSO";
    private static final String KEY_LARK_SCHEME = "com.bytedance.feedbackerlib.larkScheme";
    private static final Set<m> LARK_SSO_CALLBACK_SET = null;
    private static final Handler MAIN_HANDLER = null;
    private static final String TAG = "Feedbacker";
    private static final int WHAT_POLLING_CHECK = 0;
    private static String default_wrong_did;
    private static volatile boolean enableFeedbackFunction;
    private static volatile Application sApplication;
    private static volatile FeedbackCommonInfo sFeedbackCommonInfo;
    private static volatile String sForceSSOToken;
    private static boolean sIsApplicationForeground;
    private static volatile boolean sIsBypassDebug;
    private static volatile boolean sIsFirstLaunchAfterUpgrade;
    private static volatile boolean sIsFloatWindowEnable;
    private static boolean sIsProcessForeground;
    private static volatile boolean sIsToutiaoLiteLoading;
    private static volatile boolean sIsToutiaoLoading;
    private static volatile boolean sIsXiguaLoading;
    private static volatile String sLarkScheme;
    private static l sLifeCycleObserver;
    private static volatile long sVersionCode;
    private static volatile String sVersionName;

    public interface IFeedbackCommonInfo {
        @Nullable
        String getALogFilesDir();

        int getAid();

        @NonNull
        String getAppId();

        @NonNull
        String getChannel();

        @NonNull
        String getDid();

        @Nullable
        n getOnFeedbackClickListener();

        @Nullable
        o getOnMediasUploadFailedListener();

        @NonNull
        String getUpdateVersionCode();

        @Nullable
        String getUserId();
    }

    static class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.feedbackerlib.m.c.b(Feedbacker.TAG, "onApplicationCameToForeground executed!");
            Feedbacker.access$502(true);
            String r1 = com.bytedance.feedbackerlib.m.n.a(Feedbacker.access$400());
            if (r1 == null) goto L6;
            FloatWindowService.O(Feedbacker.access$400(), r1);
            return;
        }
    }

    static class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.feedbackerlib.m.c.b(Feedbacker.TAG, "onApplicationCameToBackground executed");
            Feedbacker.access$502(false);
            String r1 = com.bytedance.feedbackerlib.m.n.a(Feedbacker.access$400());
            if (r1 == null) goto L6;
            FloatWindowService.N(Feedbacker.access$400(), r1);
            return;
        }
    }

    static class c extends Handler {
        c(Looper r1) {
            super(r1);
        }

        @Override // android.os.Handler
        @RequiresApi(api = 17)
        public void handleMessage(Message r1) {
            if (r1.what != 0) goto L7;
            Feedbacker.access$000();
            return;
        }
    }

    static class d implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Application f3827f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ boolean f3828g;

        d(Application r1, boolean r2) {
            this.f3827f = r1;
            this.f3828g = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Feedbacker.access$100(this.f3827f, this.f3828g);
        }
    }

    static class e implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ IFeedbackCommonInfo f3829f;

        e(IFeedbackCommonInfo r1) {
            this.f3829f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (Feedbacker.isBypassDebug() == false) goto L6;
            return;
        L6:
            if (this.f3829f != null) goto L8;
            Feedbacker.access$302(null);
            FloatWindowService.V(Feedbacker.access$400(), null);
            return;
        L8:
            Feedbacker.access$302(new FeedbackCommonInfo(this.f3829f));
            FloatWindowService.V(Feedbacker.access$400(), Feedbacker.access$300());
        }
    }

    static class f implements Runnable {
        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FloatWindowService.X(Feedbacker.access$400());
        }
    }

    static class g implements Runnable {
        g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FloatWindowService.G(Feedbacker.access$400());
        }
    }

    static class h implements Runnable {
        h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FloatWindowService.c0(Feedbacker.access$400());
        }
    }

    static class i implements Runnable {
        i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FloatWindowService.d0(Feedbacker.access$400());
        }
    }

    static class j implements n {
        j() {
        }

        @Override // com.bytedance.feedbackerlib.Feedbacker.n
        public void b() {
            Feedbacker.access$300().b();     // Catch: Throwable -> L4
            return;
        }
    }

    static class k implements o {
        k() {
        }

        @Override // com.bytedance.feedbackerlib.Feedbacker.o
        public void f() {
            Feedbacker.tryInitUpload();     // Catch: Throwable -> L4
            Feedbacker.access$300().f();     // Catch: Throwable -> L4
            return;
        }
    }

    private static class l implements Application.ActivityLifecycleCallbacks {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private List<Activity> f3830a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private List<Activity> f3831b;

        private l() {
            this.f3830a = new ArrayList();
            this.f3831b = new ArrayList();
        }

        /* synthetic */ l(c r1) {
            this();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(@NonNull Activity r1, @Nullable Bundle r2) {
            this.f3831b.add(r1);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(@NonNull Activity r1) {
            this.f3831b.remove(r1);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(@NonNull Activity r1) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(@NonNull Activity r1) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(@NonNull Activity r1, @NonNull Bundle r2) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(@NonNull Activity r1) {
            this.f3830a.add(r1);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(@NonNull Activity r1) {
            this.f3830a.remove(r1);
        }
    }

    public interface m {
        void a();

        void b(@NonNull String r1);

        void c();
    }

    public interface n {
        void b();
    }

    public interface o {
        void f();
    }

    static {
        LARK_SSO_CALLBACK_SET = new HashSet();
        MAIN_HANDLER = new c(Looper.getMainLooper());
        sVersionName = null;
        sVersionCode = 0;
        sLarkScheme = null;
        sForceSSOToken = null;
        sApplication = null;
        sFeedbackCommonInfo = null;
        sIsProcessForeground = false;
        sIsApplicationForeground = false;
        sIsToutiaoLoading = false;
        sIsXiguaLoading = false;
        sIsToutiaoLiteLoading = false;
        sIsBypassDebug = false;
        sIsFirstLaunchAfterUpgrade = false;
        sIsFloatWindowEnable = true;
        default_wrong_did = "000000000";
        enableFeedbackFunction = true;
    }

    public Feedbacker() {
    }

    @Proxy("getApplicationContext")
    @TargetClass(scope = Scope.ALL, value = "android.content.Context")
    public static Context INVOKEVIRTUAL_com_bytedance_feedbackerlib_Feedbacker_com_obric_matrix_SPLancet_hookGetApplicationContext(Application r2) {
        return r2.getApplicationContext();
    L4:
        e = move-exception;
        com.obric.matrix.r.c.c.g("hookGetApplicationContext", "getApplicationContext error", e);
        return com.bytedance.mpaas.app.a.a();
    }

    static /* synthetic */ void access$000() {
        handlePollingCheck();
    }

    static /* synthetic */ void access$100(Application r0, boolean r1) {
        initInner(r0, r1);
    }

    static /* synthetic */ FeedbackCommonInfo access$300() {
        return sFeedbackCommonInfo;
    }

    static /* synthetic */ FeedbackCommonInfo access$302(FeedbackCommonInfo r0) {
        sFeedbackCommonInfo = r0;
        return r0;
    }

    static /* synthetic */ Application access$400() {
        return sApplication;
    }

    static /* synthetic */ boolean access$502(boolean r0) {
        sIsProcessForeground = r0;
        return r0;
    }

    private static void cancelPollingCheck() {
        MAIN_HANDLER.removeMessages(0);
    }

    private static boolean checkAndroidSystemVersion() {
        if (Build.VERSION.SDK_INT < 21) goto L5;
        return true;
    L5:
        return false;
    }

    public static void clearSSOCache() {
        if (sApplication == null) goto L6;
        FeedbackerContentProvider.a(sApplication);
        return;
    }

    public static void closeFeedbackFunction() {
        enableFeedbackFunction = false;
    }

    private static void commonInitOperation(@NonNull Application r0) {
        sApplication = r0;
        q.c(sApplication);
        com.bytedance.feedbackerlib.l.a.i(sApplication);
    }

    public static void forceInitFresco(@NonNull Context r2) {
        r.b r3 = r.s(r2.getApplicationContext());
        r3.u(true);
        r3.s(Bitmap.Config.RGB_565);
        r3.v(1);
        d.b.k.a.q.d(r3.t());
    }

    public static Integer getAid() {
        if (sFeedbackCommonInfo == null) goto L11;
        return Integer.valueOf(sFeedbackCommonInfo.getAid());
    L11:
        return null;
    L12:
        return null;
    }

    @Nullable
    public static String getAlogFilesDir() {
        if (sFeedbackCommonInfo != null) goto L6;
        return null;
    L6:
        return sFeedbackCommonInfo.getALogFilesDir();
    }

    public static String getAppId() {
        String r0 = sLarkScheme;
        if (TextUtils.isEmpty(r0) == true) goto L12;
        return r0;
    L12:
        if (sFeedbackCommonInfo == null) goto L14;
        return sFeedbackCommonInfo.getAppId();
    L14:
        return null;
    L15:
        return null;
    }

    public static Context getApplicationContext() {
        if (sApplication != null) goto L7;
        return null;
    L7:
        return INVOKEVIRTUAL_com_bytedance_feedbackerlib_Feedbacker_com_obric_matrix_SPLancet_hookGetApplicationContext(sApplication);
    }

    @Nullable
    public static String getChannel() {
        if (sFeedbackCommonInfo == null) goto L11;
        return sFeedbackCommonInfo.getChannel();
    L11:
        return null;
    L12:
        return null;
    }

    public static Object getDid() {
    L11:
        return null;
    L3:
        if (sFeedbackCommonInfo == null) goto L10;
        if (TextUtils.isEmpty(sFeedbackCommonInfo.getDid()) == true) goto L10;
        return sFeedbackCommonInfo.getDid();
    L10:
        return default_wrong_did;
    }

    @Nullable
    public static int getEmployeeId() {
        String r0 = FeedbackerContentProvider.g(sApplication);
        if (TextUtils.isEmpty(r0) == true) goto L10;
        return Integer.valueOf(r0).intValue();
    L10:
        return -1;
    L11:
        return -1;
    }

    public static n getFeedbackClickListener() {
        if (sFeedbackCommonInfo != null) goto L6;
        return null;
    L6:
        return new j();
    }

    public static String getForceSSOToken() {
        return sForceSSOToken;
    }

    @Nullable
    public static String getLarkSSOEmail() {
        return FeedbackerContentProvider.f(sApplication);
    }

    public static o getMediasUploadFailedListener() {
        if (sFeedbackCommonInfo != null) goto L6;
        return null;
    L6:
        return new k();
    }

    @Nullable
    public static String getUpdateVersionCode() {
        if (sFeedbackCommonInfo == null) goto L11;
        return sFeedbackCommonInfo.getUpdateVersionCode();
    L11:
        return null;
    L12:
        return null;
    }

    @Nullable
    public static String getUserAccessToken() {
        return FeedbackerContentProvider.h(sApplication);
    }

    public static String getUserId() {
        if (sFeedbackCommonInfo != null) goto L6;
        return null;
    L6:
        return sFeedbackCommonInfo.getUserId();
    }

    public static long getVersionCode() {
        return sVersionCode;
    }

    @NonNull
    public static String getVersionName() {
        return sVersionName;
    }

    @RequiresApi(api = 17)
    private static void handlePollingCheck() {
        boolean r0 = com.bytedance.feedbackerlib.m.n.b(sApplication);
        if (r0 == true) goto L5;
    L7:
        if (r0 == false) goto L9;
    L11:
        MAIN_HANDLER.sendEmptyMessageDelayed(0, DELAY_POLLING_CHECK);
        return;
    L9:
        if (sIsProcessForeground == false) goto L11;
        onProcessCameToBackground();
        goto L11
    L5:
        if (sIsProcessForeground == true) goto L7;
        onProcessCameToForeground();
        goto L11
    }

    public static void hideFeedbackFloatWindow() {
        t.b(new g(), sApplication);
    }

    public static void init(@NonNull Application r1) {
        init(r1, true);
    }

    public static void init(@NonNull Application r2, boolean r3) {
        com.bytedance.feedbackerlib.m.c.b(TAG, "Feedbacker.init executed in thread: " + Thread.currentThread().getName());
        d r0 = new d(r2, r3);
        if (Looper.getMainLooper() != Looper.myLooper()) goto L5;
        r0.run();
        return;
    L5:
        MAIN_HANDLER.post(r0);
    }

    private static void initApplicationVersionInfo() {
        PackageInfo r0 = sApplication.getPackageManager().getPackageInfo(sApplication.getPackageName(), 0);     // Catch: PackageManager.NameNotFoundException -> L5
        sVersionCode = r0.versionCode;     // Catch: PackageManager.NameNotFoundException -> L5
        sVersionName = r0.versionName;     // Catch: PackageManager.NameNotFoundException -> L5
    L6:
        q.c r1 = q.c.f4309i;
        long r4 = r1.a(-1);
        if (r4 != (-1)) goto L11;
        r1.b(sVersionCode);
        return;
    L11:
        if (sVersionCode <= r4) goto L16;
        r1.b(sVersionCode);
        q.a.f4298i.b(false);
        sIsFirstLaunchAfterUpgrade = true;
        return;
    L16:
        return;
    L5:
        sVersionName = BDLocationException.ERROR_TIMEOUT;
        sVersionCode = 0;
        goto L6
    }

    private static void initIfInFeedbackerProcess() {
        initApplicationVersionInfo();
        forceInitFresco(sApplication);
        tryInitUpload();
        readMeteDataFromManifest();
        sLifeCycleObserver = new l(null);
        sApplication.registerActivityLifecycleCallbacks(sLifeCycleObserver);
    }

    private static void initIfNotInFeedbackerProcess() {
        startPollingCheck();
    }

    private static void initInner(@NonNull Application r1, boolean r2) {
        if (sApplication == null) goto L5;
        return;
    L5:
        if (r2 == true) goto L7;
    L9:
        boolean r3 = false;
    L10:
        sIsBypassDebug = r3;
        commonInitOperation(r1);
        if (checkAndroidSystemVersion() == true) goto L14;
        com.bytedance.feedbackerlib.m.c.a(TAG, "feedbacker only supports Android 5.0 and above", null);
        return;
    L14:
        String r4 = com.bytedance.feedbackerlib.m.n.a(r1);
        if (r4 != null) goto L17;
    L19:
        initIfNotInFeedbackerProcess();
        return;
    L17:
        if (r4.endsWith(":feedbacker") == false) goto L19;
        initIfInFeedbackerProcess();
        return;
    L7:
        if (com.bytedance.feedbackerlib.m.e.c(r1) == false) goto L9;
        r3 = true;
        goto L10
    }

    public static boolean isApplicationForegroundLogic() {
        return sIsApplicationForeground;
    }

    public static boolean isBypassDebug() {
        return sIsBypassDebug;
    }

    public static boolean isFeedbackCommonInfoSetted() {
        if (sFeedbackCommonInfo == null) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isFeedbackFunctionEnabled() {
        return enableFeedbackFunction;
    }

    public static boolean isFirstLaunchAfterUpgrade() {
        return sIsFirstLaunchAfterUpgrade;
    }

    public static boolean isFloatWindowEnable() {
        return sIsFloatWindowEnable;
    }

    private static void larkSSO() {
        FloatWindowService.k(sApplication, "init_lark_sso->" + System.currentTimeMillis());
    }

    private static synchronized void notifyLarkSSOBypassed() {
        monitor-enter(Feedbacker.class);
        Iterator<m> r1 = LARK_SSO_CALLBACK_SET.iterator();     // Catch: Throwable -> L14
    L6:
        if (r1.hasNext() == false) goto L12;
        m r2 = r1.next();     // Catch: Throwable -> L14
        if (r2 == null) goto L6;
        r2.a();     // Catch: Throwable -> L14
        goto L6
    L12:
        monitor-exit(Feedbacker.class);
        return;
    L14:
        th = move-exception;
        throw th;
    }

    private static synchronized void notifyLarkSSOFailed() {
        monitor-enter(Feedbacker.class);
        Iterator<m> r1 = LARK_SSO_CALLBACK_SET.iterator();     // Catch: Throwable -> L14
    L6:
        if (r1.hasNext() == false) goto L12;
        m r2 = r1.next();     // Catch: Throwable -> L14
        if (r2 == null) goto L6;
        r2.c();     // Catch: Throwable -> L14
        goto L6
    L12:
        monitor-exit(Feedbacker.class);
        return;
    L14:
        th = move-exception;
        throw th;
    }

    private static synchronized void notifyLarkSSOSuccess() {
        monitor-enter(Feedbacker.class);
        String r1 = getLarkSSOEmail();     // Catch: Throwable -> L18
        if (TextUtils.isEmpty(r1) == false) goto L8;
        monitor-exit(Feedbacker.class);
        return;
    L8:
        Iterator<m> r2 = LARK_SSO_CALLBACK_SET.iterator();     // Catch: Throwable -> L18
    L10:
        if (r2.hasNext() == false) goto L16;
        m r3 = r2.next();     // Catch: Throwable -> L18
        if (r3 == null) goto L10;
        r3.b(r1);     // Catch: Throwable -> L18
        goto L10
    L16:
        monitor-exit(Feedbacker.class);
        return;
    L18:
        th = move-exception;
        throw th;
    }

    private static void onProcessCameToBackground() {
        t.b(new b(), sApplication);
    }

    private static void onProcessCameToForeground() {
        t.b(new a(), sApplication);
    }

    private static void readMeteDataFromManifest() {
        Application r0 = sApplication;
        if (r0 != null) goto L5;
        return;
    L5:
        PackageManager r1 = r0.getPackageManager();
        if (r1 != null) goto L8;
        return;
    L8:
        ApplicationInfo r2 = null;
        r2 = r1.getPackageInfo(r0.getPackageName(), 128).applicationInfo;     // Catch: Throwable -> L17
    L10:
        if (r2 != null) goto L12;
        return;
    L12:
        Bundle r3 = r2.metaData;
        if (r3 != null) goto L15;
        return;
    L15:
        sLarkScheme = r3.getString(KEY_LARK_SCHEME);
        sForceSSOToken = r3.getString(KEY_FORCE_SSO);
    }

    public static synchronized void registerLarkSSOCallback(@NonNull m r2) {
        monitor-enter(Feedbacker.class);
        LARK_SSO_CALLBACK_SET.add(r2);     // Catch: Throwable -> L7
        monitor-exit(Feedbacker.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static void setApplicationForegroundLogic(boolean r0) {
        sIsApplicationForeground = r0;
    }

    public static void setFeedbackCommonInfo(@Nullable FeedbackCommonInfo r3) {
        sFeedbackCommonInfo = r3;
        if (sFeedbackCommonInfo == null) goto L6;
        p.b(getApplicationContext(), getAid() + "", getChannel(), getDid() + "");
        larkSSO();
        return;
    }

    public static void setFloatWindowEnable(boolean r0) {
        sIsFloatWindowEnable = r0;
        if (r0 == false) goto L5;
        FloatWindowService.X(sApplication);
        return;
    L5:
        FloatWindowService.G(sApplication);
    }

    public static void setIFeedbackCommonInfo(@Nullable IFeedbackCommonInfo r1) {
        t.b(new e(r1), sApplication);
    }

    public static void showFeedbackFloatWindow() {
        t.b(new f(), sApplication);
    }

    private static void startPollingCheck() {
        MAIN_HANDLER.sendEmptyMessage(0);
    }

    public static void startSSOIfNecessary() {
        Application r0 = sApplication;
    }

    public static void switchToBoeDomain() {
        t.b(new h(), sApplication);
    }

    public static void switchToOnlineDomain() {
        t.b(new i(), sApplication);
    }

    public static synchronized void tryInitUpload() {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
            	at java.base/java.util.Objects.checkIndex(Objects.java:365)
            	at java.base/java.util.ArrayList.get(ArrayList.java:428)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            Method dump skipped, instruction units count: 408
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.feedbackerlib.Feedbacker.tryInitUpload():void");
    }

    public static synchronized void unregisterLarkSSOCallback(@NonNull m r2) {
        monitor-enter(Feedbacker.class);
        LARK_SSO_CALLBACK_SET.remove(r2);     // Catch: Throwable -> L7
        monitor-exit(Feedbacker.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
