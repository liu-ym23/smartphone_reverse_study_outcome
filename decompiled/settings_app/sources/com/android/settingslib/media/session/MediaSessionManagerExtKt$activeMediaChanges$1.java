package com.android.settingslib.media.session;

import android.media.session.MediaController;
import android.media.session.MediaSessionManager;
import android.os.UserHandle;
import androidx.concurrent.futures.DirectExecutor;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;

/* JADX INFO: compiled from: MediaSessionManagerExt.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \u0010\u0000\u001a\u00020\u0001*.\u0012*\u0012(\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u0001 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00060\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", "", "Landroid/media/session/MediaController;", "kotlin.jvm.PlatformType", ""}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.android.settingslib.media.session.MediaSessionManagerExtKt$activeMediaChanges$1", f = "MediaSessionManagerExt.kt", i = {}, l = {43}, m = "invokeSuspend", n = {}, s = {})
final class MediaSessionManagerExtKt$activeMediaChanges$1 extends SuspendLambda implements Function2<ProducerScope<? super List<MediaController>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ MediaSessionManager $this_activeMediaChanges;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: renamed from: $r8$lambda$k2kwHn-XWQbQOIysNqABc5r8blA, reason: not valid java name */
    public static /* synthetic */ void m769$r8$lambda$k2kwHnXWQbQOIysNqABc5r8blA(ProducerScope r0, List r1) {
        invokeSuspend$lambda$0(r0, r1);
    }

    MediaSessionManagerExtKt$activeMediaChanges$1(MediaSessionManager r1, Continuation<? super MediaSessionManagerExtKt$activeMediaChanges$1> r2) {
        this.$this_activeMediaChanges = r1;
        super(2, r2);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        MediaSessionManagerExtKt$activeMediaChanges$1 r0 = new MediaSessionManagerExtKt$activeMediaChanges$1(this.$this_activeMediaChanges, r3);
        r0.L$0 = r2;
        return r0;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(ProducerScope<? super List<MediaController>> r1, Continuation<? super Unit> r2) {
        return invoke2(r1, r2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(ProducerScope<? super List<MediaController>> r1, Continuation<? super Unit> r2) {
        return ((MediaSessionManagerExtKt$activeMediaChanges$1) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
    }

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
        final MediaSessionManager.OnActiveSessionsChangedListener r2 = new MediaSessionManagerExtKt$activeMediaChanges$1$$ExternalSyntheticLambda0(r9);
        this.$this_activeMediaChanges.addOnActiveSessionsChangedListener(null, UserHandle.of(UserHandle.myUserId()), DirectExecutor.INSTANCE, r2);
        final MediaSessionManager r4 = this.$this_activeMediaChanges;
        this.label = 1;
        if (ProduceKt.awaitClose(r9, new AnonymousClass1(r4, r2), this) != r0) goto L12;
        return r0;
    }

    private static final void invokeSuspend$lambda$0(ProducerScope r6, List r7) {
        BuildersKt.launch$default(r6, null, null, new MediaSessionManagerExtKt$activeMediaChanges$1$listener$1$1(r6, r7, null), 3, null);
    }
}
