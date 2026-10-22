package com.obric.oui.window.listener;

import android.app.Activity;
import android.content.res.Configuration;
import android.util.Log;
import androidx.fragment.app.FragmentActivity;
import com.obric.oui.window.model.AdaptedWindowSize;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: WindowConfigChangeListener.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.obric.oui.window.listener.WindowConfigChangeListener$Companion$setConfig$1", f = "WindowConfigChangeListener.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class WindowConfigChangeListener$Companion$setConfig$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Configuration $config;
    final /* synthetic */ Activity $context;
    final /* synthetic */ int $currentWindowHeight;
    final /* synthetic */ int $currentWindowWidth;
    int label;

    WindowConfigChangeListener$Companion$setConfig$1(Activity r1, Configuration r2, int r3, int r4, Continuation<? super WindowConfigChangeListener$Companion$setConfig$1> r5) {
        this.$context = r1;
        this.$config = r2;
        this.$currentWindowWidth = r3;
        this.$currentWindowHeight = r4;
        super(2, r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new WindowConfigChangeListener$Companion$setConfig$1(this.$context, this.$config, this.$currentWindowWidth, this.$currentWindowHeight, r8);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return invoke2(r1, r2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r1, Continuation<? super Unit> r2) {
        return ((WindowConfigChangeListener$Companion$setConfig$1) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r18) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L36;
        ResultKt.throwOnFailure(r18);
        int r1 = this.$context.hashCode();
        Pair r2 = (Pair) WindowConfigChangeListener.access$getMConfigDiffMap$cp().get(Boxing.boxInt(r1));
        if (r2 != null) goto L7;
        WindowConfigChangeListener.Companion.setConfigInternal$default(WindowConfigChangeListener.Companion, (FragmentActivity) this.$context, this.$config, this.$currentWindowWidth, this.$currentWindowHeight, false, 16, null);
    L34:
        return Unit.INSTANCE;
    L7:
        int r3 = this.$config.diff((Configuration) r2.getFirst());
        if ((r3 & 128) == 0) goto L10;
    L32:
        WindowConfigChangeListener.Companion.setConfigInternal$default(WindowConfigChangeListener.Companion, (FragmentActivity) this.$context, this.$config, this.$currentWindowWidth, this.$currentWindowHeight, false, 16, null);
        goto L34
    L10:
        if ((r3 & 256) != 0) goto L32;
        if ((r3 & 1024) != 0) goto L32;
        if ((r3 & 2048) != 0) goto L32;
        if ((r3 & 4096) != 0) goto L32;
        if ((r3 & 16384) != 0) goto L32;
        if ((r3 & 512) != 0) goto L32;
        Pair r4 = (Pair) WindowConfigChangeListener.access$getMConfigDiffMap$cp().get(Boxing.boxInt(r1));
        boolean r5 = false;
        if (r4 != null) goto L26;
    L28:
        if (r5 == true) goto L30;
    L31:
        Log.e("Window", "setConfigInternal due to window width diff");
        WindowConfigChangeListener.Companion.access$setConfigInternal(WindowConfigChangeListener.Companion, (FragmentActivity) this.$context, this.$config, this.$currentWindowWidth, this.$currentWindowHeight, true);
        goto L34
    L30:
        if (AdaptedWindowSize.INSTANCE.getCurrentPageSize().getWidthInPx() == this.$currentWindowWidth) goto L34;
    L26:
        if (((Number) r4.getSecond()).intValue() != this.$currentWindowWidth) goto L28;
        r5 = true;
        goto L28
    L36:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
