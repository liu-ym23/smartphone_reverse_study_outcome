package com.android.settingslib.volume.data.repository;

import android.media.session.MediaController;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: MediaControllerRepository.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u0016\u0012\u0012\u0012\u0010\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u00040\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "", "Landroid/media/session/MediaController;", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.android.settingslib.volume.data.repository.MediaControllerRepositoryImpl$activeSessions$4", f = "MediaControllerRepository.kt", i = {}, l = {74}, m = "invokeSuspend", n = {}, s = {})
final class MediaControllerRepositoryImpl$activeSessions$4 extends SuspendLambda implements Function2<FlowCollector<? super List<? extends MediaController>>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MediaControllerRepositoryImpl this$0;

    MediaControllerRepositoryImpl$activeSessions$4(MediaControllerRepositoryImpl r1, Continuation<? super MediaControllerRepositoryImpl$activeSessions$4> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        MediaControllerRepositoryImpl$activeSessions$4 r0 = new MediaControllerRepositoryImpl$activeSessions$4(this.this$0, r3);
        r0.L$0 = r2;
        return r0;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super List<? extends MediaController>> r1, Continuation<? super Unit> r2) {
        return invoke2(r1, r2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(FlowCollector<? super List<MediaController>> r1, Continuation<? super Unit> r2) {
        return ((MediaControllerRepositoryImpl$activeSessions$4) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        FlowCollector r6 = (FlowCollector) this.L$0;
        List<MediaController> r2 = MediaControllerRepositoryImpl.access$getMediaSessionManager$p(this.this$0).getActiveSessions(null);
        Intrinsics.checkNotNullExpressionValue(r2, "mediaSessionManager.getActiveSessions(null)");
        this.label = 1;
        if (r6.emit(r2, this) != r0) goto L12;
        return r0;
    }
}
