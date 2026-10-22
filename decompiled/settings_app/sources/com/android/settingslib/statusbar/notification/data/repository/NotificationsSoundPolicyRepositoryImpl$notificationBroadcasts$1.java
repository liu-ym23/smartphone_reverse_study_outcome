package com.android.settingslib.statusbar.notification.data.repository;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import com.GlobalProxyLancet;
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

/* JADX INFO: compiled from: NotificationsSoundPolicyRepository.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", ""}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.android.settingslib.statusbar.notification.data.repository.NotificationsSoundPolicyRepositoryImpl$notificationBroadcasts$1", f = "NotificationsSoundPolicyRepository.kt", i = {}, l = {73}, m = "invokeSuspend", n = {}, s = {})
final class NotificationsSoundPolicyRepositoryImpl$notificationBroadcasts$1 extends SuspendLambda implements Function2<ProducerScope<? super String>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ NotificationsSoundPolicyRepositoryImpl this$0;

    NotificationsSoundPolicyRepositoryImpl$notificationBroadcasts$1(NotificationsSoundPolicyRepositoryImpl r1, Continuation<? super NotificationsSoundPolicyRepositoryImpl$notificationBroadcasts$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        NotificationsSoundPolicyRepositoryImpl$notificationBroadcasts$1 r0 = new NotificationsSoundPolicyRepositoryImpl$notificationBroadcasts$1(this.this$0, r3);
        r0.L$0 = r2;
        return r0;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(ProducerScope<? super String> r1, Continuation<? super Unit> r2) {
        return invoke2(r1, r2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(ProducerScope<? super String> r1, Continuation<? super Unit> r2) {
        return ((NotificationsSoundPolicyRepositoryImpl$notificationBroadcasts$1) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.android.settingslib.statusbar.notification.data.repository.NotificationsSoundPolicyRepositoryImpl$notificationBroadcasts$1$receiver$1] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r8);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        final ProducerScope r9 = (ProducerScope) this.L$0;
        final ?? r2 = new NotificationsSoundPolicyRepositoryImpl$notificationBroadcasts$1$receiver$1(r9);
        IntentFilter r5 = new IntentFilter();
        r5.addAction("android.app.action.INTERRUPTION_FILTER_CHANGED");
        r5.addAction("android.app.action.NOTIFICATION_POLICY_CHANGED");
        Unit r6 = Unit.INSTANCE;
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(NotificationsSoundPolicyRepositoryImpl.access$getContext$p(this.this$0), (BroadcastReceiver) r2, r5);
        final NotificationsSoundPolicyRepositoryImpl r4 = this.this$0;
        this.label = 1;
        if (ProduceKt.awaitClose(r9, new AnonymousClass2(r4, r2), this) != r0) goto L12;
        return r0;
    }
}
