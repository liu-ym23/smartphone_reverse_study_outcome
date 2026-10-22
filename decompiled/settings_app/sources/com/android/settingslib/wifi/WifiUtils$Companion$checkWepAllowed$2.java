package com.android.settingslib.wifi;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import com.obric.oui.utils.AnimTokens;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: WifiUtils.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.android.settingslib.wifi.WifiUtils$Companion$checkWepAllowed$2", f = "WifiUtils.kt", i = {}, l = {AnimTokens.OUI_ANIMATION_DURATION_LONG_3}, m = "invokeSuspend", n = {}, s = {})
final class WifiUtils$Companion$checkWepAllowed$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ int $dialogWindowType;
    final /* synthetic */ Function0<Unit> $onAllowed;
    final /* synthetic */ Function1<Intent, Unit> $onStartActivity;
    final /* synthetic */ String $ssid;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    WifiUtils$Companion$checkWepAllowed$2(Context r1, Function0<Unit> r2, Function1<? super Intent, Unit> r3, int r4, String r5, Continuation<? super WifiUtils$Companion$checkWepAllowed$2> r6) {
        this.$context = r1;
        this.$onAllowed = r2;
        this.$onStartActivity = r3;
        this.$dialogWindowType = r4;
        this.$ssid = r5;
        super(2, r6);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new WifiUtils$Companion$checkWepAllowed$2(this.$context, this.$onAllowed, this.$onStartActivity, this.$dialogWindowType, this.$ssid, r9);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return invoke2(r1, r2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r1, Continuation<? super Unit> r2) {
        return ((WifiUtils$Companion$checkWepAllowed$2) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L16:
        if (((Boolean) r6).booleanValue() == false) goto L18;
        this.$onAllowed.invoke();
    L20:
        return Unit.INSTANCE;
    L18:
        Intent r7 = new Intent("android.intent.action.MAIN");
        int r2 = this.$dialogWindowType;
        String r3 = this.$ssid;
        r7.setComponent(new ComponentName("com.android.settings", "com.android.settings.network.WepNetworkDialogActivity"));
        r7.putExtra(WifiUtils.DIALOG_WINDOW_TYPE, r2);
        r7.putExtra("ssid", r3);
        Intent r8 = r7.addFlags(268435456);
        Intrinsics.checkNotNullExpressionValue(r8, "Intent(Intent.ACTION_MAI…t.FLAG_ACTIVITY_NEW_TASK)");
        this.$onStartActivity.invoke(r8);
        goto L20
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        WifiManager r9 = (WifiManager) this.$context.getSystemService(WifiManager.class);
        if (r9 == null) goto L11;
        this.label = 1;
        r6 = WifiUtils.Companion.access$queryWepAllowed(WifiUtils.Companion, r9, this);
        if (r6 != r0) goto L16;
        return r0;
    L11:
        return Unit.INSTANCE;
    }
}
