package com.android.settingslib.volume.shared;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.GlobalProxyLancet;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;

/* JADX INFO: compiled from: AudioManagerEventsReceiver.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", "Landroid/content/Intent;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.android.settingslib.volume.shared.AudioManagerEventsReceiverImpl$events$1", f = "AudioManagerEventsReceiver.kt", i = {}, l = {77}, m = "invokeSuspend", n = {}, s = {})
final class AudioManagerEventsReceiverImpl$events$1 extends SuspendLambda implements Function2<ProducerScope<? super Intent>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AudioManagerEventsReceiverImpl this$0;

    AudioManagerEventsReceiverImpl$events$1(AudioManagerEventsReceiverImpl r1, Continuation<? super AudioManagerEventsReceiverImpl$events$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        AudioManagerEventsReceiverImpl$events$1 r0 = new AudioManagerEventsReceiverImpl$events$1(this.this$0, r3);
        r0.L$0 = r2;
        return r0;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(ProducerScope<? super Intent> r1, Continuation<? super Unit> r2) {
        return invoke2(r1, r2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(ProducerScope<? super Intent> r1, Continuation<? super Unit> r2) {
        return ((AudioManagerEventsReceiverImpl$events$1) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.android.settingslib.volume.shared.AudioManagerEventsReceiverImpl$events$1$receiver$1] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r9);
    L16:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r9);
        final ProducerScope r10 = (ProducerScope) this.L$0;
        final ?? r2 = new AudioManagerEventsReceiverImpl$events$1$receiver$1(r10);
        Context r3 = AudioManagerEventsReceiverImpl.access$getContext$p(this.this$0);
        BroadcastReceiver r4 = (BroadcastReceiver) r2;
        IntentFilter r5 = new IntentFilter();
        Iterator r6 = AudioManagerEventsReceiverImpl.access$getAllActions(this.this$0).iterator();
    L10:
        if (r6.hasNext() == false) goto L12;
        r5.addAction((String) r6.next());
        goto L10
    L12:
        Unit r7 = Unit.INSTANCE;
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(r3, r4, r5);
        final AudioManagerEventsReceiverImpl r8 = this.this$0;
        this.label = 1;
        if (ProduceKt.awaitClose(r10, new AnonymousClass2(r8, r2), this) != r0) goto L16;
        return r0;
    }
}
