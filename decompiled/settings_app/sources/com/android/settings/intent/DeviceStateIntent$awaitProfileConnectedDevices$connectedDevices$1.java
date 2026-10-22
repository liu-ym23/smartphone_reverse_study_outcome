package com.android.settings.intent;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import android.content.Context;
import com.obric.olog.OLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: DeviceStateIntent.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "Landroid/bluetooth/BluetoothDevice;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.android.settings.intent.DeviceStateIntent$awaitProfileConnectedDevices$connectedDevices$1", f = "DeviceStateIntent.kt", i = {0}, l = {1252}, m = "invokeSuspend", n = {"$this$withTimeoutOrNull"}, s = {"L$0"})
final class DeviceStateIntent$awaitProfileConnectedDevices$connectedDevices$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends BluetoothDevice>>, Object> {
    final /* synthetic */ BluetoothAdapter $adapter;
    final /* synthetic */ Context $context;
    final /* synthetic */ int $profile;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ DeviceStateIntent this$0;

    DeviceStateIntent$awaitProfileConnectedDevices$connectedDevices$1(int r1, DeviceStateIntent r2, BluetoothAdapter r3, Context r4, Continuation<? super DeviceStateIntent$awaitProfileConnectedDevices$connectedDevices$1> r5) {
        this.$profile = r1;
        this.this$0 = r2;
        this.$adapter = r3;
        this.$context = r4;
        super(2, r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        DeviceStateIntent$awaitProfileConnectedDevices$connectedDevices$1 r6 = new DeviceStateIntent$awaitProfileConnectedDevices$connectedDevices$1(this.$profile, this.this$0, this.$adapter, this.$context, r9);
        r6.L$0 = r8;
        return r6;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super List<? extends BluetoothDevice>> r2) {
        return invoke2(r1, r2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r1, Continuation<? super List<BluetoothDevice>> r2) {
        return ((DeviceStateIntent$awaitProfileConnectedDevices$connectedDevices$1) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        Context r2 = (Context) this.L$3;
        BluetoothAdapter r3 = (BluetoothAdapter) this.L$2;
        DeviceStateIntent r4 = (DeviceStateIntent) this.L$1;
        CoroutineScope r7 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r8);
    L27:
        return r8;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        CoroutineScope r9 = (CoroutineScope) this.L$0;
        int r5 = this.$profile;
        final DeviceStateIntent r6 = this.this$0;
        final BluetoothAdapter r10 = this.$adapter;
        Context r11 = this.$context;
        this.L$0 = r9;
        this.L$1 = r6;
        this.L$2 = r10;
        this.L$3 = r11;
        this.I$0 = r5;
        this.label = 1;
        DeviceStateIntent$awaitProfileConnectedDevices$connectedDevices$1 r12 = this;
        CancellableContinuationImpl r13 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(r12), 1);
        r13.initCancellability();
        final CancellableContinuationImpl r14 = r13;
        BluetoothProfile.ServiceListener r15 = new DeviceStateIntent$awaitProfileConnectedDevices$connectedDevices$1$1$listener$1(r6, r10, r14);
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L11
        Object r17 = Result.m1508constructorimpl(Boxing.boxBoolean(r10.getProfileProxy(r11, r15, r5)));     // Catch: Throwable -> L11
    L13:
        Throwable r18 = Result.m1511exceptionOrNullimpl(r17);
        if (r18 == null) goto L18;
        OLog.e("DeviceStateIntent", "get bluetooth profile proxy failed, profile=" + r5, r18);
        r17 = Boxing.boxBoolean(false);
    L18:
        if (((Boolean) r17).booleanValue() == false) goto L20;
    L22:
        r8 = r13.getResult();
        if (r8 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L25;
        DebugProbesKt.probeCoroutineSuspended(r12);
    L25:
        if (r8 != r0) goto L27;
        return r0;
    L20:
        if (r14.isActive() == false) goto L22;
        OLog.d("DeviceStateIntent", "get bluetooth profile proxy returned false, profile=" + r5);
        Result.Companion r19 = Result.Companion;
        r14.resumeWith(Result.m1508constructorimpl(CollectionsKt.emptyList()));
    L11:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r17 = Result.m1508constructorimpl(ResultKt.createFailure(th));
        goto L13
    }
}
