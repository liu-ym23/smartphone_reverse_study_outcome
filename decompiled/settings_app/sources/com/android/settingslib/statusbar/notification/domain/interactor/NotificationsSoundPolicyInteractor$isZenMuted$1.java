package com.android.settingslib.statusbar.notification.domain.interactor;

import com.android.settingslib.statusbar.notification.data.model.ZenMode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function6;

/* JADX INFO: compiled from: NotificationsSoundPolicyInteractor.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "", "zenMode", "Lcom/android/settingslib/statusbar/notification/data/model/ZenMode;", "areAlarmsAllowed", "isMediaAllowed", "isRingerAllowed", "isSystemAllowed"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.android.settingslib.statusbar.notification.domain.interactor.NotificationsSoundPolicyInteractor$isZenMuted$1", f = "NotificationsSoundPolicyInteractor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class NotificationsSoundPolicyInteractor$isZenMuted$1 extends SuspendLambda implements Function6<ZenMode, Boolean, Boolean, Boolean, Boolean, Continuation<? super Boolean>, Object> {
    final /* synthetic */ int $stream;
    /* synthetic */ int I$0;
    /* synthetic */ boolean Z$0;
    /* synthetic */ boolean Z$1;
    /* synthetic */ boolean Z$2;
    /* synthetic */ boolean Z$3;
    int label;

    NotificationsSoundPolicyInteractor$isZenMuted$1(int r1, Continuation<? super NotificationsSoundPolicyInteractor$isZenMuted$1> r2) {
        this.$stream = r1;
        super(6, r2);
    }

    @Override // kotlin.jvm.functions.Function6
    public /* bridge */ /* synthetic */ Object invoke(ZenMode r8, Boolean r9, Boolean r10, Boolean r11, Boolean r12, Continuation<? super Boolean> r13) {
        return m781invokel8XbQNo(r8.m778unboximpl(), r9.booleanValue(), r10.booleanValue(), r11.booleanValue(), r12.booleanValue(), r13);
    }

    /* JADX INFO: renamed from: invoke-l8XbQNo, reason: not valid java name */
    public final Object m781invokel8XbQNo(int r2, boolean r3, boolean r4, boolean r5, boolean r6, Continuation<? super Boolean> r7) {
        NotificationsSoundPolicyInteractor$isZenMuted$1 r0 = new NotificationsSoundPolicyInteractor$isZenMuted$1(this.$stream, r7);
        r0.I$0 = r2;
        r0.Z$0 = r3;
        r0.Z$1 = r4;
        r0.Z$2 = r5;
        r0.Z$3 = r6;
        return r0.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L39;
        ResultKt.throwOnFailure(r10);
        int r11 = this.I$0;
        boolean r0 = this.Z$0;
        boolean r1 = this.Z$1;
        boolean r2 = this.Z$2;
        boolean r3 = this.Z$3;
        boolean r5 = false;
        if (r11 == 1) goto L18;
        if (r11 == 2) goto L17;
        if (r11 != 3) goto L37;
        int r9 = this.$stream;
        if (r9 == 2) goto L13;
        if (r9 == 5) goto L13;
        if (r9 == 1) goto L13;
    L15:
        return Boxing.boxBoolean(r5);
    L13:
        r5 = true;
    L37:
        return Boxing.boxBoolean(false);
    L17:
        return Boxing.boxBoolean(true);
    L18:
        int r12 = this.$stream;
        if (r12 != 4) goto L23;
        if (r0 == true) goto L23;
        return Boxing.boxBoolean(true);
    L23:
        if (r12 != 3) goto L27;
        if (r1 == true) goto L27;
        return Boxing.boxBoolean(true);
    L27:
        if (r12 != 1) goto L31;
        if (r3 == true) goto L31;
        return Boxing.boxBoolean(true);
    L31:
        if (r12 == 2) goto L33;
        if (r12 != 5) goto L37;
    L33:
        if (r2 == true) goto L37;
        return Boxing.boxBoolean(true);
    L39:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
