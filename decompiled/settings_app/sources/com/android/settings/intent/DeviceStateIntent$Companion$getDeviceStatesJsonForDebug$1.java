package com.android.settings.intent;

import android.content.Context;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: DeviceStateIntent.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.android.settings.intent.DeviceStateIntent$Companion$getDeviceStatesJsonForDebug$1", f = "DeviceStateIntent.kt", i = {}, l = {884}, m = "invokeSuspend", n = {}, s = {})
final class DeviceStateIntent$Companion$getDeviceStatesJsonForDebug$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ Context $context;
    int label;

    DeviceStateIntent$Companion$getDeviceStatesJsonForDebug$1(Context r1, Continuation<? super DeviceStateIntent$Companion$getDeviceStatesJsonForDebug$1> r2) {
        this.$context = r1;
        super(2, r2);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new DeviceStateIntent$Companion$getDeviceStatesJsonForDebug$1(this.$context, r2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super String> r2) {
        return invoke2(r1, r2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r1, Continuation<? super String> r2) {
        return ((DeviceStateIntent$Companion$getDeviceStatesJsonForDebug$1) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L14:
        return r5;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        DeviceStateIntent r6 = new DeviceStateIntent();
        Context r2 = this.$context.getApplicationContext();
        if (r2 != null) goto L11;
        r2 = this.$context;
    L11:
        this.label = 1;
        r5 = DeviceStateIntent.access$getDeviceStatesJson(r6, r2, this);
        if (r5 != r0) goto L14;
        return r0;
    }
}
