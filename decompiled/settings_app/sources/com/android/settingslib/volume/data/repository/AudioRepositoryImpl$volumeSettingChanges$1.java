package com.android.settingslib.volume.data.repository;

import android.database.ContentObserver;
import android.icu.lang.UCharacter;
import android.net.Uri;
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

/* JADX INFO: compiled from: AudioRepository.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.android.settingslib.volume.data.repository.AudioRepositoryImpl$volumeSettingChanges$1", f = "AudioRepository.kt", i = {}, l = {UCharacter.UnicodeBlock.SHORTHAND_FORMAT_CONTROLS_ID}, m = "invokeSuspend", n = {}, s = {})
final class AudioRepositoryImpl$volumeSettingChanges$1 extends SuspendLambda implements Function2<ProducerScope<? super Unit>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Uri $uri;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AudioRepositoryImpl this$0;

    AudioRepositoryImpl$volumeSettingChanges$1(AudioRepositoryImpl r1, Uri r2, Continuation<? super AudioRepositoryImpl$volumeSettingChanges$1> r3) {
        this.this$0 = r1;
        this.$uri = r2;
        super(2, r3);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        AudioRepositoryImpl$volumeSettingChanges$1 r0 = new AudioRepositoryImpl$volumeSettingChanges$1(this.this$0, this.$uri, r4);
        r0.L$0 = r3;
        return r0;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(ProducerScope<? super Unit> r1, Continuation<? super Unit> r2) {
        return invoke2(r1, r2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(ProducerScope<? super Unit> r1, Continuation<? super Unit> r2) {
        return ((AudioRepositoryImpl$volumeSettingChanges$1) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [com.android.settingslib.volume.data.repository.AudioRepositoryImpl$volumeSettingChanges$1$observer$1] */
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
        final DirectExecutor r2 = DirectExecutor.INSTANCE;
        final ?? r3 = new AudioRepositoryImpl$volumeSettingChanges$1$observer$1(r9, r2);
        AudioRepositoryImpl.access$getContentResolver$p(this.this$0).registerContentObserver(this.$uri, false, (ContentObserver) r3);
        final AudioRepositoryImpl r4 = this.this$0;
        this.label = 1;
        if (ProduceKt.awaitClose(r9, new AnonymousClass1(r4, r3), this) != r0) goto L12;
        return r0;
    }
}
