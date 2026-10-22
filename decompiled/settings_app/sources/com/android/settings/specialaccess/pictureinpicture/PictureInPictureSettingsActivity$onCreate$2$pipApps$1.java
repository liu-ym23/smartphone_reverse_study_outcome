package com.android.settings.specialaccess.pictureinpicture;

import android.content.pm.ApplicationInfo;
import android.os.UserHandle;
import android.util.Pair;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: PictureInPictureSettingsActivity.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001j\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002`\u0005*\u00020\u0006H\u008a@"}, d2 = {"<anonymous>", "Ljava/util/ArrayList;", "Landroid/util/Pair;", "Landroid/content/pm/ApplicationInfo;", "", "Lkotlin/collections/ArrayList;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.android.settings.specialaccess.pictureinpicture.PictureInPictureSettingsActivity$onCreate$2$pipApps$1", f = "PictureInPictureSettingsActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class PictureInPictureSettingsActivity$onCreate$2$pipApps$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ArrayList<Pair<ApplicationInfo, Integer>>>, Object> {
    int label;
    final /* synthetic */ PictureInPictureSettingsActivity this$0;

    PictureInPictureSettingsActivity$onCreate$2$pipApps$1(PictureInPictureSettingsActivity r1, Continuation<? super PictureInPictureSettingsActivity$onCreate$2$pipApps$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new PictureInPictureSettingsActivity$onCreate$2$pipApps$1(this.this$0, r2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super ArrayList<Pair<ApplicationInfo, Integer>>> r2) {
        return invoke2(r1, r2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r1, Continuation<? super ArrayList<Pair<ApplicationInfo, Integer>>> r2) {
        return ((PictureInPictureSettingsActivity$onCreate$2$pipApps$1) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r2);
        return this.this$0.collectPipApps(UserHandle.myUserId());
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
