package com.android.settings.intent;

import androidx.exifinterface.media.ExifInterface;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: DeviceStateIntent.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.android.settings.intent.DeviceStateIntentBluetoothFields$awaitProfileResultsConcurrently$2$1$1", f = "DeviceStateIntent.kt", i = {}, l = {919}, m = "invokeSuspend", n = {}, s = {})
final class DeviceStateIntentBluetoothFields$awaitProfileResultsConcurrently$2$1$1<T> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Collection<? extends T>>, Object> {
    final /* synthetic */ Function2<Integer, Continuation<? super Collection<? extends T>>, Object> $loader;
    final /* synthetic */ int $profile;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    DeviceStateIntentBluetoothFields$awaitProfileResultsConcurrently$2$1$1(Function2<? super Integer, ? super Continuation<? super Collection<? extends T>>, ? extends Object> r1, int r2, Continuation<? super DeviceStateIntentBluetoothFields$awaitProfileResultsConcurrently$2$1$1> r3) {
        this.$loader = r1;
        this.$profile = r2;
        super(2, r3);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DeviceStateIntentBluetoothFields$awaitProfileResultsConcurrently$2$1$1(this.$loader, this.$profile, r3);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Object r2) {
        return invoke(r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Collection<? extends T>> r2) {
        return ((DeviceStateIntentBluetoothFields$awaitProfileResultsConcurrently$2$1$1) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L11:
        return r4;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        Function2<Integer, Continuation<? super Collection<? extends T>>, Object> r5 = this.$loader;
        Integer r2 = Boxing.boxInt(this.$profile);
        this.label = 1;
        r4 = r5.invoke(r2, this);
        if (r4 != r0) goto L11;
        return r0;
    }
}
