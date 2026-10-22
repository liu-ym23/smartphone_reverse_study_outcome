package com.obric.safecheck.riskcontrol.observer;

import android.app.ActivityManager;
import android.app.IProcessObserver;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.UserHandle;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import androidx.collection.LruCache;
import androidx.core.content.ContextCompat;
import com.obric.matrix.platform.sdk.ones.account.AccountInfoBundleKey;
import com.obric.oui.dialog.v2.alert.OAlertDialog;
import com.obric.oui.dialog.v2.alert.OAlertDialogBuilder;
import com.obric.safecheck.R;
import com.obric.safecheck.provider.ApkVirusCheckProvider;
import com.obric.safecheck.riskcontrol.api.model.RiskAppControlRecord;
import com.obric.safecheck.riskcontrol.api.model.RiskControlFlags;
import com.obric.safecheck.riskcontrol.api.model.RiskControlStatus;
import com.obric.safecheck.riskcontrol.ui.RiskControlRuntimeDependencies;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import obric.view.WindowManagerHelper;

/* JADX INFO: compiled from: RiskProcessObserverManager.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0017\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002DEB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010$\u001a\u00020\u00112\u0006\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00020\u0004H\u0002J&\u0010'\u001a\u00020\u00112\u0006\u0010(\u001a\u00020\u00102\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\n0*2\u0006\u0010&\u001a\u00020\u0004H\u0002J6\u0010+\u001a\u00020\u00112\u0006\u0010(\u001a\u00020\u00102\u0006\u0010,\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u00042\u0014\b\u0002\u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0*0/H\u0002J3\u00100\u001a\u00020\u00112\u0006\u0010(\u001a\u00020\u00102\u0006\u0010,\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u00042\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\n0*H\u0000¢\u0006\u0002\b1J#\u00102\u001a\u00020\u00112\u0006\u0010(\u001a\u00020\u00102\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\n0*H\u0000¢\u0006\u0002\b3J\"\u00104\u001a\u00020\u00112\u0006\u0010,\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u00042\b\u0010%\u001a\u0004\u0018\u00010\nH\u0002J'\u00105\u001a\u00020\u00112\u0006\u0010,\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u00042\b\u0010%\u001a\u0004\u0018\u00010\nH\u0000¢\u0006\u0002\b6J \u00107\u001a\u00020\u00112\u0006\u0010(\u001a\u00020\u00102\u0006\u00108\u001a\u00020\n2\u0006\u0010&\u001a\u00020\u0004H\u0002J\u0018\u00109\u001a\u00020\n2\u0006\u00108\u001a\u00020\n2\u0006\u0010&\u001a\u00020\u0004H\u0002J\u0018\u0010:\u001a\u00020\u00112\u0006\u0010(\u001a\u00020\u00102\b\b\u0002\u0010;\u001a\u00020\u0018J\u000e\u0010<\u001a\u00020\u00112\u0006\u0010=\u001a\u00020\rJ\r\u0010>\u001a\u00020\u0011H\u0000¢\u0006\u0002\b?J \u0010@\u001a\u00020\u00112\u0006\u0010(\u001a\u00020\u00102\u0006\u00108\u001a\u00020\n2\u0006\u0010&\u001a\u00020\u0004H\u0002J\u0006\u0010A\u001a\u00020\u0011J\u000e\u0010B\u001a\u00020\u00112\u0006\u0010=\u001a\u00020\rJ\u0010\u0010C\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R2\u0010\u000e\u001a\u001a\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00110\u000fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00070\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020#0\u0017X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006F"}, d2 = {"Lcom/obric/safecheck/riskcontrol/observer/RiskProcessObserverManager;", "", "()V", "DEFAULT_USER_ID", "", "NOTICE_DEDUPE_LRU_SIZE", "NOTICE_DEDUPE_WINDOW_MS", "", "PROCESS_START_VALID_WINDOW_MS", "TAG", "", "coldStartCallbacks", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Lcom/obric/safecheck/riskcontrol/observer/RiskProcessObserverManager$ColdStartCallback;", "coldStartNoticeShower", "Lkotlin/Function3;", "Landroid/content/Context;", "", "getColdStartNoticeShower$safecheck_neridaCnRelease", "()Lkotlin/jvm/functions/Function3;", "setColdStartNoticeShower$safecheck_neridaCnRelease", "(Lkotlin/jvm/functions/Function3;)V", "foregroundSeenProcesses", "Ljava/util/concurrent/ConcurrentHashMap;", "", "<set-?>", "isRegistered", "()Z", "lastNoticeShownAt", "Landroidx/collection/LruCache;", "mainHandler", "Landroid/os/Handler;", "observer", "Landroid/app/IProcessObserver;", "startedProcesses", "Lcom/obric/safecheck/riskcontrol/observer/RiskProcessObserverManager$StartedProcess;", "dispatchColdStart", "packageName", AccountInfoBundleKey.USER_ID, "handleForegroundPackages", "context", "packages", "", "handleForegroundPackagesForProcess", "pid", "uid", "packagesProvider", "Lkotlin/Function0;", "handleForegroundPackagesForProcessForTest", "handleForegroundPackagesForProcessForTest$safecheck_neridaCnRelease", "handleForegroundPackagesForTest", "handleForegroundPackagesForTest$safecheck_neridaCnRelease", "handleProcessStarted", "handleProcessStartedForTest", "handleProcessStartedForTest$safecheck_neridaCnRelease", "maybeShowColdStartNotice", ApkVirusCheckProvider.KEY_PKG, "noticeKey", "register", "force", "registerColdStartCallback", "callback", "resetForTest", "resetForTest$safecheck_neridaCnRelease", "showColdStartNoticeDialog", "unregister", "unregisterColdStartCallback", "userIdFromUid", "ColdStartCallback", "StartedProcess", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class RiskProcessObserverManager {
    private static final int DEFAULT_USER_ID = 0;
    public static final RiskProcessObserverManager INSTANCE = null;
    private static final int NOTICE_DEDUPE_LRU_SIZE = 256;
    private static final long NOTICE_DEDUPE_WINDOW_MS = 3000;
    private static final long PROCESS_START_VALID_WINDOW_MS = 10000;
    private static final String TAG = "RiskProcessObserver";
    private static final CopyOnWriteArraySet<ColdStartCallback> coldStartCallbacks = null;
    private static Function3<? super Context, ? super String, ? super Integer, Unit> coldStartNoticeShower;
    private static final ConcurrentHashMap<Integer, Boolean> foregroundSeenProcesses = null;
    private static boolean isRegistered;
    private static final LruCache<String, Long> lastNoticeShownAt = null;
    private static final Handler mainHandler = null;
    private static IProcessObserver observer;
    private static final ConcurrentHashMap<Integer, StartedProcess> startedProcesses = null;

    /* JADX INFO: compiled from: RiskProcessObserverManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/obric/safecheck/riskcontrol/observer/RiskProcessObserverManager$ColdStartCallback;", "", "onAppColdStart", "", "packageName", "", AccountInfoBundleKey.USER_ID, "", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    public interface ColdStartCallback {
        void onAppColdStart(String r1, int r2);
    }

    /* JADX INFO: compiled from: RiskProcessObserverManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/obric/safecheck/riskcontrol/observer/RiskProcessObserverManager$StartedProcess;", "", "uid", "", "packageName", "", "startedAt", "", "(ILjava/lang/String;J)V", "getPackageName", "()Ljava/lang/String;", "getStartedAt", "()J", "getUid", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    private static final class StartedProcess {
        private final String packageName;
        private final long startedAt;
        private final int uid;

        public static /* synthetic */ StartedProcess copy$default(StartedProcess r0, int r1, String r2, long r3, int r5, Object r6) {
            if ((r5 & 1) == 0) goto L6;
            r1 = r0.uid;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r2 = r0.packageName;
        L9:
            if ((r5 & 4) == 0) goto L12;
            r3 = r0.startedAt;
        L12:
            return r0.copy(r1, r2, r3);
        }

        public final int component1() {
            return this.uid;
        }

        public final String component2() {
            return this.packageName;
        }

        public final long component3() {
            return this.startedAt;
        }

        public final StartedProcess copy(int r1, String r2, long r3) {
            Intrinsics.checkNotNullParameter(r2, "packageName");
            return new StartedProcess(r1, r2, r3);
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof StartedProcess) == false) goto L12;
            StartedProcess r4 = (StartedProcess) r3;
            if (this.uid == r4.uid) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.packageName, r4.packageName) == true) goto L10;
            return false;
        L10:
            if (this.startedAt == r4.startedAt) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public int hashCode() {
            int r0 = Integer.hashCode(this.uid) * 31;
            String r1 = this.packageName;
            if (r1 == null) goto L5;
            int r2 = r1.hashCode();
        L7:
            return ((r0 + r2) * 31) + Long.hashCode(this.startedAt);
        L5:
            r2 = 0;
            goto L7
        }

        public String toString() {
            return "StartedProcess(uid=" + this.uid + ", packageName=" + this.packageName + ", startedAt=" + this.startedAt + ")";
        }

        public StartedProcess(int r2, String r3, long r4) {
            Intrinsics.checkNotNullParameter(r3, "packageName");
            this.uid = r2;
            this.packageName = r3;
            this.startedAt = r4;
        }

        public final int getUid() {
            return this.uid;
        }

        public final String getPackageName() {
            return this.packageName;
        }

        public final long getStartedAt() {
            return this.startedAt;
        }
    }

    static {
        RiskProcessObserverManager r0 = new RiskProcessObserverManager();
        INSTANCE = r0;
        mainHandler = new Handler(Looper.getMainLooper());
        lastNoticeShownAt = new LruCache(256);
        startedProcesses = new ConcurrentHashMap();
        foregroundSeenProcesses = new ConcurrentHashMap();
        coldStartCallbacks = new CopyOnWriteArraySet();
        coldStartNoticeShower = new RiskProcessObserverManager$coldStartNoticeShower$1(r0);
    }

    private RiskProcessObserverManager() {
    }

    public static final /* synthetic */ CopyOnWriteArraySet access$getColdStartCallbacks$p(RiskProcessObserverManager r0) {
        return coldStartCallbacks;
    }

    public static final /* synthetic */ ConcurrentHashMap access$getForegroundSeenProcesses$p(RiskProcessObserverManager r0) {
        return foregroundSeenProcesses;
    }

    public static final /* synthetic */ ConcurrentHashMap access$getStartedProcesses$p(RiskProcessObserverManager r0) {
        return startedProcesses;
    }

    public static final /* synthetic */ void access$handleProcessStarted(RiskProcessObserverManager r0, int r1, int r2, String r3) {
        r0.handleProcessStarted(r1, r2, r3);
    }

    public static final /* synthetic */ void access$showColdStartNoticeDialog(RiskProcessObserverManager r0, Context r1, String r2, int r3) {
        r0.showColdStartNoticeDialog(r1, r2, r3);
    }

    public final boolean isRegistered() {
        return isRegistered;
    }

    public final Function3<Context, String, Integer, Unit> getColdStartNoticeShower$safecheck_neridaCnRelease() {
        return coldStartNoticeShower;
    }

    public final void setColdStartNoticeShower$safecheck_neridaCnRelease(Function3<? super Context, ? super String, ? super Integer, Unit> r1) {
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        coldStartNoticeShower = r1;
    }

    public final void registerColdStartCallback(ColdStartCallback r1) {
        Intrinsics.checkNotNullParameter(r1, "callback");
        coldStartCallbacks.add(r1);
    }

    public final void unregisterColdStartCallback(ColdStartCallback r1) {
        Intrinsics.checkNotNullParameter(r1, "callback");
        coldStartCallbacks.remove(r1);
    }

    private final void dispatchColdStart(final String r2, final int r3) {
        Log.e("RiskProcessObserverManager", "dispatchColdStart：" + r2);
        if (coldStartCallbacks.isEmpty() == false) goto L5;
        return;
    L5:
        mainHandler.post(new AnonymousClass1(r2, r3));
    }

    public static /* synthetic */ void register$default(RiskProcessObserverManager r0, Context r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = false;
    L5:
        r0.register(r1, r2);
    }

    public final void register(Context r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        if (isRegistered == false) goto L6;
        if (r3 == true) goto L6;
        return;
    L6:
        registerColdStartCallback(new GxbAntiFraudAppColdStartHandler());
        final Context r1 = r2.getApplicationContext();
        RiskControlRuntimeDependencies r4 = RiskControlRuntimeDependencies.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(r1, "appContext");
        r4.ensureInitialized(r1);
        IProcessObserver.Stub r5 = new RiskProcessObserverManager$register$processObserver$1(r1);     // Catch: Throwable -> L16
        IProcessObserver r6 = observer;     // Catch: Throwable -> L16
        if (r6 != null) goto L19;
    L14:
        ActivityManager.getService().registerProcessObserver(r5);     // Catch: Throwable -> L16
        observer = r5;     // Catch: Throwable -> L16
        isRegistered = true;     // Catch: Throwable -> L16
        return;
    L19:
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L11
        ActivityManager.getService().unregisterProcessObserver(r6);     // Catch: Throwable -> L11
        Object r8 = Result.m774constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L13:
        Result.m773boximpl(r8);     // Catch: Throwable -> L16
        goto L14
    L11:
        th = move-exception;
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L16
        r8 = Result.m774constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        Log.e(TAG, "Failed to register IProcessObserver", th);
    }

    public final void unregister() {
        IProcessObserver r2 = observer;
        if (r2 != null) goto L10;
        return;
    L10:
        ActivityManager.getService().unregisterProcessObserver(r2);     // Catch: Throwable -> L7
        startedProcesses.clear();     // Catch: Throwable -> L7
        foregroundSeenProcesses.clear();     // Catch: Throwable -> L7
        lastNoticeShownAt.evictAll();     // Catch: Throwable -> L7
        IProcessObserver r0 = (IProcessObserver) null;     // Catch: Throwable -> L7
        observer = null;     // Catch: Throwable -> L7
        isRegistered = false;     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        Log.e(TAG, "Failed to unregister IProcessObserver", th);
    }

    public final void handleForegroundPackagesForTest$safecheck_neridaCnRelease(Context r2, List<String> r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "packages");
        Context r4 = r2.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(r4, "context.applicationContext");
        handleForegroundPackages(r4, r3, 0);
    }

    public final void handleProcessStartedForTest$safecheck_neridaCnRelease(int r1, int r2, String r3) {
        handleProcessStarted(r1, r2, r3);
    }

    public final void handleForegroundPackagesForProcessForTest$safecheck_neridaCnRelease(Context r2, int r3, int r4, final List<String> r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r5, "packages");
        Context r6 = r2.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(r6, "context.applicationContext");
        handleForegroundPackagesForProcess(r6, r3, r4, new RiskProcessObserverManager$handleForegroundPackagesForProcessForTest$1(r5));
    }

    public final void resetForTest$safecheck_neridaCnRelease() {
        lastNoticeShownAt.evictAll();
        startedProcesses.clear();
        foregroundSeenProcesses.clear();
        coldStartNoticeShower = new RiskProcessObserverManager$resetForTest$1(this);
    }

    private final void handleProcessStarted(int r4, int r5, String r6) {
        foregroundSeenProcesses.remove(Integer.valueOf(r4));
        ConcurrentHashMap<Integer, StartedProcess> r3 = startedProcesses;
        Integer r7 = Integer.valueOf(r4);
        if (r6 != null) goto L5;
        r6 = "";
    L5:
        r3.put(r7, new StartedProcess(r5, r6, RiskControlRuntimeDependencies.INSTANCE.getClock().invoke().longValue()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void handleForegroundPackagesForProcess$default(RiskProcessObserverManager r0, final Context r1, int r2, final int r3, Function0 r4, int r5, Object r6) {
        if ((r5 & 8) == 0) goto L5;
        r4 = new C03191(r1, r3);
    L5:
        r0.handleForegroundPackagesForProcess(r1, r2, r3, r4);
    }

    private final void handleForegroundPackagesForProcess(Context r7, int r8, int r9, Function0<? extends List<String>> r10) {
        boolean r2 = true;
        if (foregroundSeenProcesses.putIfAbsent(Integer.valueOf(r8), true) == null) goto L5;
        return;
    L5:
        StartedProcess r11 = startedProcesses.remove(Integer.valueOf(r8));
        if (r11 != null) goto L9;
        handleForegroundPackages(r7, r10.invoke(), userIdFromUid(r9));
        return;
    L9:
        long r0 = RiskControlRuntimeDependencies.INSTANCE.getClock().invoke().longValue();
        if (r11.getUid() == r9) goto L12;
        return;
    L12:
        if ((r0 - r11.getStartedAt()) > 10000) goto L30;
        String r12 = r11.getPackageName();
        String r1 = r12;
        if ((!StringsKt.isBlank(r1)) == true) goto L17;
    L19:
        r2 = false;
    L20:
        if (r2 == true) goto L23;
        r12 = null;
    L23:
        if (r12 == null) goto L26;
        List<String> r13 = CollectionsKt.listOf(r12);
        if (r13 == null) goto L26;
    L27:
        handleForegroundPackages(r7, r13, userIdFromUid(r9));
        return;
    L26:
        r13 = r10.invoke();
        goto L27
    L17:
        if (StringsKt.contains$default(r1, ':', false, 2, null) == true) goto L19;
    }

    private final void handleForegroundPackages(final Context r2, List<String> r3, int r4) {
        if (r3.isEmpty() == false) goto L5;
        return;
    L5:
        Iterator r1 = SequencesKt.distinct(SequencesKt.filter(SequencesKt.filter(CollectionsKt.asSequence(r3), C03181.INSTANCE), new AnonymousClass2(r2))).iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        String r5 = (String) r1.next();
        INSTANCE.maybeShowColdStartNotice(r2, r5, r4);
        goto L7
    }

    private final void maybeShowColdStartNotice(final Context r8, final String r9, final int r10) {
        dispatchColdStart(r9, r10);
        long r0 = RiskControlRuntimeDependencies.INSTANCE.getClock().invoke().longValue();
        String r7 = noticeKey(r9, r10);
        LruCache<String, Long> r2 = lastNoticeShownAt;
        Long r3 = r2.get(r7);
        if (r3 != null) goto L5;
    L21:
        RiskControlRuntimeDependencies.INSTANCE.ensureInitialized(r8);     // Catch: Throwable -> L18
        RiskAppControlRecord r4 = RiskControlRuntimeDependencies.INSTANCE.getRepositoryFactory().invoke(r8).get(r9, r10);     // Catch: Throwable -> L18
        if (r4 != null) goto L11;
        return;
    L11:
        if (r4.getControlStatus() == RiskControlStatus.CONTROLLED) goto L13;
        return;
    L13:
        if (RiskControlFlags.hasReleasedControl(r4.getControlFlags()) == true) goto L23;
        r2.put(r7, Long.valueOf(r0));     // Catch: Throwable -> L18
        mainHandler.post(new RunnableC03201(r8, r9, r10));     // Catch: Throwable -> L18
        return;
    L23:
        return;
    L18:
        th = move-exception;
        Log.e(TAG, "Failed to show foreground notice for " + r9, th);
        return;
    L5:
        if ((r0 - r3.longValue()) >= 3000) goto L21;
    }

    private final void showColdStartNoticeDialog(final Context r19, final String r20, final int r21) {
        ContextThemeWrapper r3 = new ContextThemeWrapper(r19, R.style.GxbAntiFraudDialogTheme);     // Catch: Throwable -> L14
        OAlertDialogBuilder r6 = new OAlertDialogBuilder(r3).title(r3.getString(R.string.risk_control_cold_start_dialog_title), false).horizontalButton(true);     // Catch: Throwable -> L14
        String r4 = r3.getString(R.string.risk_control_view_details);     // Catch: Throwable -> L14
        Intrinsics.checkNotNullExpressionValue(r4, "themedContext.getString(…isk_control_view_details)");     // Catch: Throwable -> L14
        OAlertDialogBuilder r12 = OAlertDialogBuilder.positiveButton$default(r6, r4, new RiskProcessObserverManager$showColdStartNoticeDialog$builder$1(r19, r20, r21), null, 4, null);     // Catch: Throwable -> L14
        String r0 = r3.getString(R.string.risk_control_known);     // Catch: Throwable -> L14
        Intrinsics.checkNotNullExpressionValue(r0, "themedContext.getString(…tring.risk_control_known)");     // Catch: Throwable -> L14
        OAlertDialog r1 = OAlertDialogBuilder.negativeButton$default(r12, r0, RiskProcessObserverManager$showColdStartNoticeDialog$builder$2.INSTANCE, null, 4, null).build();     // Catch: Throwable -> L14
        View r5 = r1.getPositiveButton();     // Catch: Throwable -> L14
        if ((r5 instanceof TextView) == true) goto L6;
        r5 = null;
    L6:
        TextView r7 = (TextView) r5;     // Catch: Throwable -> L14
        if (r7 == null) goto L9;
        r7.setTextColor(ContextCompat.getColor(r3, R.color.oui_accent_6_bg));     // Catch: Throwable -> L14
    L9:
        Window r8 = r1.getWindow();     // Catch: Throwable -> L14
        if (r8 == null) goto L12;
        r8.setType(WindowManagerHelper.LayoutParamsSmt.TYPE_APPLICATION_OVERLAY);     // Catch: Throwable -> L14
    L12:
        r1.show();     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        Log.e(TAG, "Failed to show cold start notice dialog, pkg=" + r20 + ", userId=" + r21, th);
    }

    private final int userIdFromUid(int r1) {
        return UserHandle.getUserId(r1);
    }

    private final String noticeKey(String r1, int r2) {
        return r1 + "#" + r2;
    }
}
