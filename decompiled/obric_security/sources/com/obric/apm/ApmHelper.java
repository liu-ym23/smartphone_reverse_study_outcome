package com.obric.apm;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.bytedance.apm.Apm;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.config.ApmInitConfig;
import com.bytedance.apm.config.ApmStartConfig;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.apm.launch.LaunchInitConfig;
import com.bytedance.apm6.hub.config.internal.ConfigManager;
import com.bytedance.apm6.memory.MemoryCollector;
import com.bytedance.common.utility.reflect.ReflectUtils;
import com.monitor.cloudmessage.CloudMessageWidget;
import com.obric.matrix.platform.sdk.ones.env.EnvUtils;
import com.obric.olog.OLog;
import com.obric.security.BuildConfig;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: ApmHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000eJ&\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0004J\u0010\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0012H\u0007J\u0010\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u001e\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\u0004J\b\u0010\u001c\u001a\u00020\u0010H\u0002J\u0018\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u000eH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/obric/apm/ApmHelper;", "", "()V", "TAG", "", "checkConditionRunnable", "Ljava/lang/Runnable;", "handler", "Landroid/os/Handler;", "hasPrivacyConsent", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isApmStarted", "isCheckingDid", "isScreenReceiverRegistered", "", "init", "", "context", "Landroid/content/Context;", "isDebug", "initAndStartApm", "appId", "did", "onPrivacyApproved", "app", "registerScreenReceiver", "startApm", "", "stopApmMemoryMonitor", "verify2InitApm", "privacyAgreed", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class ApmHelper {
    public static final ApmHelper INSTANCE = null;
    private static final String TAG = null;
    private static Runnable checkConditionRunnable;
    private static Handler handler;
    private static final AtomicBoolean hasPrivacyConsent = null;
    private static final AtomicBoolean isApmStarted = null;
    private static final AtomicBoolean isCheckingDid = null;
    private static boolean isScreenReceiverRegistered;

    /* JADX INFO: renamed from: com.obric.apm.ApmHelper$initAndStartApm$1, reason: invalid class name */
    /* JADX INFO: compiled from: ApmHelper.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.obric.apm.ApmHelper$initAndStartApm$1", f = "ApmHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $appId;
        final /* synthetic */ Context $context;
        final /* synthetic */ String $did;
        final /* synthetic */ boolean $isDebug;
        int label;

        AnonymousClass1(Context r1, boolean r2, String r3, String r4, Continuation r5) {
            this.$context = r1;
            this.$isDebug = r2;
            this.$appId = r3;
            this.$did = r4;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            Intrinsics.checkNotNullParameter(r8, "completion");
            return new AnonymousClass1(this.$context, this.$isDebug, this.$appId, this.$did, r8);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return ((AnonymousClass1) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r3);
            OLog.i(ApmHelper.access$getTAG$p(ApmHelper.INSTANCE), "initAndStartApm");
            ApmHelper.INSTANCE.init(this.$context, this.$isDebug);
            ApmHelper.INSTANCE.startApm(this.$context, Integer.parseInt(this.$appId), this.$did);
            ApmHelper.access$isCheckingDid$p(ApmHelper.INSTANCE).set(false);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        INSTANCE = new ApmHelper();
        TAG = "ApmHelper";
        handler = new Handler(Looper.getMainLooper());
        hasPrivacyConsent = new AtomicBoolean(false);
        isApmStarted = new AtomicBoolean(false);
        isCheckingDid = new AtomicBoolean(false);
    }

    private ApmHelper() {
    }

    public static final /* synthetic */ Handler access$getHandler$p(ApmHelper r0) {
        return handler;
    }

    public static final /* synthetic */ AtomicBoolean access$getHasPrivacyConsent$p(ApmHelper r0) {
        return hasPrivacyConsent;
    }

    public static final /* synthetic */ String access$getTAG$p(ApmHelper r0) {
        return TAG;
    }

    public static final /* synthetic */ AtomicBoolean access$isApmStarted$p(ApmHelper r0) {
        return isApmStarted;
    }

    public static final /* synthetic */ AtomicBoolean access$isCheckingDid$p(ApmHelper r0) {
        return isCheckingDid;
    }

    public static final /* synthetic */ void access$setHandler$p(ApmHelper r0, Handler r1) {
        handler = r1;
    }

    public static final /* synthetic */ void access$stopApmMemoryMonitor(ApmHelper r0) {
        r0.stopApmMemoryMonitor();
    }

    @JvmStatic
    public static final void verify2InitApm(final Context r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "app");
        if (r3 == false) goto L6;
        hasPrivacyConsent.set(true);
    L6:
        if (hasPrivacyConsent.get() == true) goto L8;
        return;
    L8:
        if (isApmStarted.get() == false) goto L10;
        return;
    L10:
        if (isCheckingDid.compareAndSet(false, true) == false) goto L16;
        Runnable r4 = new RunnableC01801(r2);
        checkConditionRunnable = r4;
        Handler r5 = handler;
        Intrinsics.checkNotNull(r4);
        r5.post(r4);
        return;
    }

    @JvmStatic
    public static final void onPrivacyApproved(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "app");
        hasPrivacyConsent.set(true);
        verify2InitApm(r2, true);
    }

    public final void initAndStartApm(Context r12, boolean r13, String r14, String r15) {
        Intrinsics.checkNotNullParameter(r12, "context");
        Intrinsics.checkNotNullParameter(r14, "appId");
        Intrinsics.checkNotNullParameter(r15, "did");
        if (isApmStarted.compareAndSet(false, true) == true) goto L6;
        isCheckingDid.set(false);
        return;
    L6:
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), Dispatchers.getMain(), null, new AnonymousClass1(r12, r13, r14, r15, null), 2, null);
    }

    public final void init(Context r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Apm.getInstance().init(r6, ApmInitConfig.builder().fullFpsTracer(true).launchInitConfig(new LaunchInitConfig.Builder().collectPerfData().collectNetData().collectTimingTrace().collectDeviceInfo().setMaxCollectTimeMs(AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH).build()).reportEvilMethodSwitch(true).evilMethodThresholdMs(1000).debugMode(r7).build());
        ApmContext.setSupportMultiFrameRate(false);
        ApmContext.setStopWhenBackground(true);
    }

    public final void startApm(Context r5, int r6, String r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r7, "did");
        String r0 = EnvUtils.INSTANCE.getCurrChannel();
        OLog.i(TAG, "startApm: " + r0);
        Apm.getInstance().start(ApmStartConfig.builder().aid(r6).appVersion(BuildConfig.VERSION_NAME).channel(r0).deviceId(r7).updateVersionCode(String.valueOf(BuildConfig.VERSION_CODE)).dynamicParams(new C01791()).batteryDetect(true).blockDetect(true).seriousBlockDetect(true).blockThresholdMs(PerfConsts.DEFAULT_BLOCK_INTERVAL_MS).widget(new CloudMessageWidget()).build());
        ConfigManager.getInstance().registerConfigListener(new AnonymousClass2());
        stopApmMemoryMonitor();
        registerScreenReceiver(r5);
    }

    private final void stopApmMemoryMonitor() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        ApmHelper r4 = this;     // Catch: Throwable -> L4
        Result.m774constructorimpl(ReflectUtils.invokeMethod(MemoryCollector.class, "stop", new Object[]{MemoryCollector.getInstance()}));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        Result.m774constructorimpl(ResultKt.createFailure(th));
    }

    private final void registerScreenReceiver(Context r3) {
        if (isScreenReceiverRegistered == false) goto L10;
        return;
    L10:
        IntentFilter r2 = new IntentFilter();     // Catch: Exception -> L7
        r2.addAction("android.intent.action.SCREEN_ON");     // Catch: Exception -> L7
        r2.addAction("android.intent.action.SCREEN_OFF");     // Catch: Exception -> L7
        r3.getApplicationContext().registerReceiver(new C01781(), r2);     // Catch: Exception -> L7
        isScreenReceiverRegistered = true;     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        OLog.e(TAG, "registerScreenReceiver error: " + e.getMessage());
    }
}
