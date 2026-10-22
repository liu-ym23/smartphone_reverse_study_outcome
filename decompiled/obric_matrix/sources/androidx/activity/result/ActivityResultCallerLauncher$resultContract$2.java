package androidx.activity.result;

import kotlin.Metadata;
import kotlin.n0.d.q;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\t\n\u0000\n\u0002\b\u0005*\u0001\u0001\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "androidx/activity/result/ActivityResultCallerLauncher$resultContract$2$1", "I", "O", "invoke", "()Landroidx/activity/result/ActivityResultCallerLauncher$resultContract$2$1;"}, k = 3, mv = {1, 7, 1}, xi = 48)
final class ActivityResultCallerLauncher$resultContract$2 extends q implements kotlin.n0.c.a<AnonymousClass1> {
    final /* synthetic */ ActivityResultCallerLauncher<I, O> this$0;

    ActivityResultCallerLauncher$resultContract$2(ActivityResultCallerLauncher<I, O> r1) {
        this.this$0 = r1;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.activity.result.ActivityResultCallerLauncher$resultContract$2$1] */
    @Override // kotlin.n0.c.a
    public final AnonymousClass1 invoke() {
        final ActivityResultCallerLauncher<I, O> r1 = this.this$0;
        return new AnonymousClass1(r1);
    }

    @Override // kotlin.n0.c.a
    public /* bridge */ /* synthetic */ AnonymousClass1 invoke() {
        return invoke();
    }
}
