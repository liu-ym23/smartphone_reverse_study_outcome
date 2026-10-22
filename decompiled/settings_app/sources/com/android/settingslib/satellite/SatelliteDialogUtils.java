package com.android.settingslib.satellite;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.telephony.satellite.SatelliteManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.GlobalProxyLancet;
import com.android.settingslib.wifi.WifiUtils;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: SatelliteDialogUtils.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JC\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00072!\u0010\u0012\u001a\u001d\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00180\u0013H\u0007JC\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0011\u001a\u00020\u00072!\u0010\u0012\u001a\u001d\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00180\u0013H\u0007J\u0019\u0010\u001b\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u000eH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u001cJ\u0018\u0010\u001d\u001a\u00020\u00182\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0007H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001e"}, d2 = {"Lcom/android/settingslib/satellite/SatelliteDialogUtils;", "", "()V", "EXTRA_TYPE_OF_SATELLITE_WARNING_DIALOG", "", "TAG", "TYPE_IS_AIRPLANE_MODE", "", "TYPE_IS_BLUETOOTH", "TYPE_IS_UNKNOWN", "TYPE_IS_WIFI", "mayStartSatelliteWarningDialog", "Lkotlinx/coroutines/Job;", "context", "Landroid/content/Context;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "type", "allowClick", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isAllowed", "", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "requestIsEnabled", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startSatelliteWarningDialog", "app_debug"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SatelliteDialogUtils {
    public static final String EXTRA_TYPE_OF_SATELLITE_WARNING_DIALOG = "extra_type_of_satellite_warning_dialog";
    public static final SatelliteDialogUtils INSTANCE = null;
    public static final String TAG = "SatelliteDialogUtils";
    public static final int TYPE_IS_AIRPLANE_MODE = 2;
    public static final int TYPE_IS_BLUETOOTH = 1;
    public static final int TYPE_IS_UNKNOWN = -1;
    public static final int TYPE_IS_WIFI = 0;

    /* JADX INFO: renamed from: com.android.settingslib.satellite.SatelliteDialogUtils$mayStartSatelliteWarningDialog$1, reason: invalid class name */
    /* JADX INFO: compiled from: SatelliteDialogUtils.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.android.settingslib.satellite.SatelliteDialogUtils$mayStartSatelliteWarningDialog$1", f = "SatelliteDialogUtils.kt", i = {0}, l = {73, 85}, m = "invokeSuspend", n = {"isSatelliteModeOn"}, s = {"L$0"})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Boolean, Unit> $allowClick;
        final /* synthetic */ Context $context;
        final /* synthetic */ int $type;
        Object L$0;
        Object L$1;
        int label;

        /* JADX INFO: renamed from: com.android.settingslib.satellite.SatelliteDialogUtils$mayStartSatelliteWarningDialog$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: SatelliteDialogUtils.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
        @DebugMetadata(c = "com.android.settingslib.satellite.SatelliteDialogUtils$mayStartSatelliteWarningDialog$1$1", f = "SatelliteDialogUtils.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C00411 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function1<Boolean, Unit> $allowClick;
            final /* synthetic */ Ref.BooleanRef $isSatelliteModeOn;
            int label;

            /* JADX WARN: Multi-variable type inference failed */
            C00411(Function1<? super Boolean, Unit> r1, Ref.BooleanRef r2, Continuation<? super C00411> r3) {
                this.$allowClick = r1;
                this.$isSatelliteModeOn = r2;
                super(2, r3);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                return new C00411(this.$allowClick, this.$isSatelliteModeOn, r3);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return invoke2(r1, r2);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(CoroutineScope r1, Continuation<? super Unit> r2) {
                return ((C00411) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r2) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L7;
                ResultKt.throwOnFailure(r2);
                this.$allowClick.invoke(Boxing.boxBoolean(!this.$isSatelliteModeOn.element));
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Context r1, int r2, Function1<? super Boolean, Unit> r3, Continuation<? super AnonymousClass1> r4) {
            this.$context = r1;
            this.$type = r2;
            this.$allowClick = r3;
            super(2, r4);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.$context, this.$type, this.$allowClick, r4);
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
        public final Object invokeSuspend(Object r9) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L18;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r9);
        L41:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            Ref.BooleanRef r2 = (Ref.BooleanRef) this.L$1;
            Ref.BooleanRef r3 = (Ref.BooleanRef) this.L$0;
            ResultKt.throwOnFailure(r9);     // Catch: TimeoutException -> L12 ExecutionException -> L14 InterruptedException -> L16
        L23:
            r2.element = ((Boolean) r9).booleanValue();     // Catch: TimeoutException -> L12 ExecutionException -> L14 InterruptedException -> L16
        L35:
            if (r3.element == false) goto L37;
            SatelliteDialogUtils.access$startSatelliteWarningDialog(SatelliteDialogUtils.INSTANCE, this.$context, this.$type);
        L37:
            this.L$0 = null;
            this.L$1 = null;
            this.label = 2;
            if (BuildersKt.withContext(Dispatchers.getMain(), new C00411(this.$allowClick, r3, null), this) != r0) goto L41;
            return r0;
        L16:
            e = e;
        L33:
            GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(SatelliteDialogUtils.TAG, "Error to get satellite status : " + e);
        L14:
            e = e;
        L30:
            GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(SatelliteDialogUtils.TAG, "Error to get satellite status : " + e);
        L12:
            e = e;
        L27:
            GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(SatelliteDialogUtils.TAG, "Error to get satellite status : " + e);
            goto L35
        L18:
            ResultKt.throwOnFailure(r9);
            r2 = new Ref.BooleanRef();
            this.L$0 = r2;     // Catch: TimeoutException -> L25 ExecutionException -> L28 InterruptedException -> L31
            this.L$1 = r2;     // Catch: TimeoutException -> L25 ExecutionException -> L28 InterruptedException -> L31
            this.label = 1;     // Catch: TimeoutException -> L25 ExecutionException -> L28 InterruptedException -> L31
            r9 = SatelliteDialogUtils.access$requestIsEnabled(SatelliteDialogUtils.INSTANCE, this.$context, this);     // Catch: TimeoutException -> L25 ExecutionException -> L28 InterruptedException -> L31
            if (r9 != r0) goto L22;
            return r0;
        L22:
            r3 = r2;
            goto L23
        L31:
            e = e;
            r3 = r2;
        L28:
            e = e;
            r3 = r2;
        L25:
            e = e;
            r3 = r2;
            goto L27
        }
    }

    /* JADX INFO: renamed from: com.android.settingslib.satellite.SatelliteDialogUtils$requestIsEnabled$2, reason: invalid class name */
    /* JADX INFO: compiled from: SatelliteDialogUtils.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.android.settingslib.satellite.SatelliteDialogUtils$requestIsEnabled$2", f = "SatelliteDialogUtils.kt", i = {0}, l = {146}, m = "invokeSuspend", n = {"satelliteManager"}, s = {"L$0"})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        final /* synthetic */ Context $context;
        Object L$0;
        int label;

        AnonymousClass2(Context r1, Continuation<? super AnonymousClass2> r2) {
            this.$context = r1;
            super(2, r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new AnonymousClass2(this.$context, r2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
            return invoke2(r1, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r1, Continuation<? super Boolean> r2) {
            return ((AnonymousClass2) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            SatelliteManager r5 = (SatelliteManager) this.L$0;
            ResultKt.throwOnFailure(r6);
        L17:
            return r6;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            SatelliteManager r7 = (SatelliteManager) this.$context.getSystemService(SatelliteManager.class);
            if (r7 != null) goto L12;
            GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(SatelliteDialogUtils.TAG, "SatelliteManager is null");
            return Boxing.boxBoolean(false);
        L12:
            this.L$0 = r7;
            this.label = 1;
            AnonymousClass2 r8 = this;
            CancellableContinuationImpl r2 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(r8), 1);
            r2.initCancellability();
            final CancellableContinuationImpl r3 = r2;
            r7.requestIsEnabled(ExecutorsKt.asExecutor(Dispatchers.getDefault()), new SatelliteDialogUtils$requestIsEnabled$2$1$1(r3));
            r6 = r2.getResult();
            if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L15;
            DebugProbesKt.probeCoroutineSuspended(r8);
        L15:
            if (r6 != r0) goto L17;
            return r0;
        }
    }

    static {
        INSTANCE = new SatelliteDialogUtils();
    }

    private SatelliteDialogUtils() {
    }

    public static final /* synthetic */ Object access$requestIsEnabled(SatelliteDialogUtils r0, Context r1, Continuation r2) {
        return r0.requestIsEnabled(r1, r2);
    }

    public static final /* synthetic */ void access$startSatelliteWarningDialog(SatelliteDialogUtils r0, Context r1, int r2) {
        r0.startSatelliteWarningDialog(r1, r2);
    }

    @JvmStatic
    public static final Job mayStartSatelliteWarningDialog(Context r1, LifecycleOwner r2, int r3, Function1<? super Boolean, Unit> r4) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r4, "allowClick");
        return mayStartSatelliteWarningDialog(r1, LifecycleOwnerKt.getLifecycleScope(r2), r3, r4);
    }

    @JvmStatic
    public static final Job mayStartSatelliteWarningDialog(Context r7, CoroutineScope r8, int r9, Function1<? super Boolean, Unit> r10) {
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r8, "coroutineScope");
        Intrinsics.checkNotNullParameter(r10, "allowClick");
        return BuildersKt.launch$default(r8, null, null, new AnonymousClass1(r7, r9, r10, null), 3, null);
    }

    private final void startSatelliteWarningDialog(Context r4, int r5) {
        Intent r3 = new Intent("android.intent.action.MAIN");
        r3.setComponent(new ComponentName("com.android.settings", "com.android.settings.network.SatelliteWarningDialogActivity"));
        r3.putExtra(WifiUtils.DIALOG_WINDOW_TYPE, 2009);
        r3.putExtra(EXTRA_TYPE_OF_SATELLITE_WARNING_DIALOG, r5);
        r3.addFlags(805306368);
        r4.startActivity(r3);
    }

    private final Object requestIsEnabled(Context r3, Continuation<? super Boolean> r4) {
        return BuildersKt.withContext(Dispatchers.getDefault(), new AnonymousClass2(r3, null), r4);
    }
}
