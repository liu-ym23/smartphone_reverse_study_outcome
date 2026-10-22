package com.obric.apm;

import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.GlobalProxyLancet;
import com.android.settings.BuildConfig;
import com.bytedance.apm.Apm;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.config.ApmInitConfig;
import com.bytedance.apm.config.ApmStartConfig;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.bytedance.apm.launch.LaunchInitConfig;
import com.bytedance.sremlib.LibUtil;
import com.obric.olog.OLog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: ApmHelper.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\nJ&\u0010\u0010\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004J\u0010\u0010\u0013\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u001e\u0010\u0014\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u0004J\u000e\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0018R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/obric/apm/ApmHelper;", "", "()V", "TAG", "", "checkConditionRunnable", "Ljava/lang/Runnable;", "handler", "Landroid/os/Handler;", "isScreenReceiverRegistered", "", "init", "", "context", "Landroid/content/Context;", "isDebug", "initAndStartApm", "appId", "did", "registerScreenReceiver", "startApm", "", "verify2InitApm", LibUtil.EXCEPTION_APPLICATION, "Landroid/app/Application;", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ApmHelper {
    public static final ApmHelper INSTANCE = null;
    private static final String TAG = null;
    private static Runnable checkConditionRunnable;
    private static Handler handler;
    private static boolean isScreenReceiverRegistered;

    /* JADX INFO: renamed from: com.obric.apm.ApmHelper$initAndStartApm$1, reason: invalid class name */
    /* JADX INFO: compiled from: ApmHelper.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.apm.ApmHelper$initAndStartApm$1", f = "ApmHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $appId;
        final /* synthetic */ Context $context;
        final /* synthetic */ String $did;
        int label;

        AnonymousClass1(Context r1, String r2, String r3, Continuation<? super AnonymousClass1> r4) {
            this.$context = r1;
            this.$appId = r2;
            this.$did = r3;
            super(2, r4);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.$context, this.$appId, this.$did, r4);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return invoke2(r1, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r1, Continuation<? super Unit> r2) {
            return ((AnonymousClass1) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r3);
            OLog.i(ApmHelper.access$getTAG$p(), "initAndStartApm");
            ApmHelper.INSTANCE.startApm(this.$context, Integer.parseInt(this.$appId), this.$did);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private ApmHelper() {
    }

    public static final /* synthetic */ Handler access$getHandler$p() {
        return handler;
    }

    public static final /* synthetic */ String access$getTAG$p() {
        return TAG;
    }

    static {
        INSTANCE = new ApmHelper();
        TAG = "ApmHelper";
        handler = new Handler(Looper.getMainLooper());
    }

    public final void verify2InitApm(final Application r3) {
        Intrinsics.checkNotNullParameter(r3, LibUtil.EXCEPTION_APPLICATION);
        init(r3, false);
        Runnable r2 = new RunnableC01831(r3);
        checkConditionRunnable = r2;
        handler.post(r2);
    }

    public final void initAndStartApm(Context r7, boolean r8, String r9, String r10) {
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r9, "appId");
        Intrinsics.checkNotNullParameter(r10, "did");
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), Dispatchers.getMain(), null, new AnonymousClass1(r7, r9, r10, null), 2, null);
    }

    public final void init(Context r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Apm.getInstance().init(r6, ApmInitConfig.builder().fullFpsTracer(true).launchInitConfig(new LaunchInitConfig.Builder().collectPerfData().collectNetData().collectTimingTrace().collectDeviceInfo().setMaxCollectTimeMs(TraceStatsConsts.PAGE_LOAD_MAX_LIMIT_MS).build()).reportEvilMethodSwitch(true).evilMethodThresholdMs(1000).debugMode(r7).build());
        ApmContext.setSupportMultiFrameRate(false);
        ApmContext.setStopWhenBackground(true);
    }

    public final void startApm(Context r4, int r5, String r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r6, "did");
        Apm.getInstance().start(ApmStartConfig.builder().aid(r5).appVersion(BuildConfig.VERSION_NAME).channel("release").deviceId(r6).updateVersionCode("800203546").dynamicParams(new C01821()).batteryDetect(true).blockDetect(true).seriousBlockDetect(true).blockThresholdMs(2500).build());
        registerScreenReceiver(r4);
    }

    private final void registerScreenReceiver(Context r3) {
        if (isScreenReceiverRegistered == false) goto L10;
        return;
    L10:
        IntentFilter r2 = new IntentFilter();     // Catch: Exception -> L7
        r2.addAction("android.intent.action.SCREEN_ON");     // Catch: Exception -> L7
        r2.addAction("android.intent.action.SCREEN_OFF");     // Catch: Exception -> L7
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(r3.getApplicationContext(), new C01811(), r2);     // Catch: Exception -> L7
        isScreenReceiverRegistered = true;     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        Log.e(TAG, "registerScreenReceiver error: " + e.getMessage());
    }
}
