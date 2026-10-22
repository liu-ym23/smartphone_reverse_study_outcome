package com.android.settingslib.media.session;

import android.media.session.MediaSession;
import android.media.session.MediaSessionManager;
import androidx.concurrent.futures.DirectExecutor;
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

/* JADX INFO: compiled from: MediaSessionManagerExt.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", "Landroid/media/session/MediaSession$Token;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.android.settingslib.media.session.MediaSessionManagerExtKt$defaultRemoteSessionChanged$1", f = "MediaSessionManagerExt.kt", i = {}, l = {63}, m = "invokeSuspend", n = {}, s = {})
final class MediaSessionManagerExtKt$defaultRemoteSessionChanged$1 extends SuspendLambda implements Function2<ProducerScope<? super MediaSession.Token>, Continuation<? super Unit>, Object> {
    final /* synthetic */ MediaSessionManager $this_defaultRemoteSessionChanged;
    private /* synthetic */ Object L$0;
    int label;

    MediaSessionManagerExtKt$defaultRemoteSessionChanged$1(MediaSessionManager r1, Continuation<? super MediaSessionManagerExtKt$defaultRemoteSessionChanged$1> r2) {
        this.$this_defaultRemoteSessionChanged = r1;
        super(2, r2);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        MediaSessionManagerExtKt$defaultRemoteSessionChanged$1 r0 = new MediaSessionManagerExtKt$defaultRemoteSessionChanged$1(this.$this_defaultRemoteSessionChanged, r3);
        r0.L$0 = r2;
        return r0;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(ProducerScope<? super MediaSession.Token> r1, Continuation<? super Unit> r2) {
        return invoke2(r1, r2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(ProducerScope<? super MediaSession.Token> r1, Continuation<? super Unit> r2) {
        return ((MediaSessionManagerExtKt$defaultRemoteSessionChanged$1) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.android.settingslib.media.session.MediaSessionManagerExtKt$defaultRemoteSessionChanged$1$callback$1] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        final ProducerScope r8 = (ProducerScope) this.L$0;
        final ?? r2 = new MediaSessionManagerExtKt$defaultRemoteSessionChanged$1$callback$1(r8);
        this.$this_defaultRemoteSessionChanged.registerRemoteSessionCallback(DirectExecutor.INSTANCE, (MediaSessionManager.RemoteSessionCallback) r2);
        final MediaSessionManager r4 = this.$this_defaultRemoteSessionChanged;
        this.label = 1;
        if (ProduceKt.awaitClose(r8, new AnonymousClass1(r4, r2), this) != r0) goto L12;
        return r0;
    }
}
