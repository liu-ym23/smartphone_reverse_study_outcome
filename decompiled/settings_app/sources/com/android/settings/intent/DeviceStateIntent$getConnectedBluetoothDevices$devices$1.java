package com.android.settings.intent;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: DeviceStateIntent.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", "Landroid/bluetooth/BluetoothDevice;", "profile", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.android.settings.intent.DeviceStateIntent$getConnectedBluetoothDevices$devices$1", f = "DeviceStateIntent.kt", i = {}, l = {120}, m = "invokeSuspend", n = {}, s = {})
final class DeviceStateIntent$getConnectedBluetoothDevices$devices$1 extends SuspendLambda implements Function2<Integer, Continuation<? super Collection<? extends BluetoothDevice>>, Object> {
    final /* synthetic */ BluetoothAdapter $adapter;
    final /* synthetic */ Context $context;
    /* synthetic */ int I$0;
    int label;
    final /* synthetic */ DeviceStateIntent this$0;

    DeviceStateIntent$getConnectedBluetoothDevices$devices$1(DeviceStateIntent r1, Context r2, BluetoothAdapter r3, Continuation<? super DeviceStateIntent$getConnectedBluetoothDevices$devices$1> r4) {
        this.this$0 = r1;
        this.$context = r2;
        this.$adapter = r3;
        super(2, r4);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        DeviceStateIntent$getConnectedBluetoothDevices$devices$1 r0 = new DeviceStateIntent$getConnectedBluetoothDevices$devices$1(this.this$0, this.$context, this.$adapter, r5);
        r0.I$0 = ((Number) r4).intValue();
        return r0;
    }

    public final Object invoke(int r1, Continuation<? super Collection<BluetoothDevice>> r2) {
        return ((DeviceStateIntent$getConnectedBluetoothDevices$devices$1) create(Integer.valueOf(r1), r2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Integer r1, Continuation<? super Collection<? extends BluetoothDevice>> r2) {
        return invoke(r1.intValue(), r2);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L11:
        return r7;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        int r8 = this.I$0;
        this.label = 1;
        r7 = DeviceStateIntent.access$awaitProfileConnectedDevices(this.this$0, this.$context, this.$adapter, r8, this);
        if (r7 != r0) goto L11;
        return r0;
    }
}
