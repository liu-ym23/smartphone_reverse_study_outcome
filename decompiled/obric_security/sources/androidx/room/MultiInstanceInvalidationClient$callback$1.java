package androidx.room;

import java.util.Arrays;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MultiInstanceInvalidationClient.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001d\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005H\u0016¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"androidx/room/MultiInstanceInvalidationClient$callback$1", "Landroidx/room/IMultiInstanceInvalidationCallback$Stub;", "onInvalidation", "", "tables", "", "", "([Ljava/lang/String;)V", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class MultiInstanceInvalidationClient$callback$1 extends IMultiInstanceInvalidationCallback.Stub {
    final /* synthetic */ MultiInstanceInvalidationClient this$0;

    /* JADX INFO: renamed from: $r8$lambda$YbA_oLvwgwIT6Ag339-3Mj03vfc, reason: not valid java name */
    public static /* synthetic */ void m50$r8$lambda$YbA_oLvwgwIT6Ag3393Mj03vfc(MultiInstanceInvalidationClient r0, String[] r1) {
        onInvalidation$lambda$0(r0, r1);
    }

    MultiInstanceInvalidationClient$callback$1(MultiInstanceInvalidationClient r1) {
        this.this$0 = r1;
    }

    private static final void onInvalidation$lambda$0(MultiInstanceInvalidationClient r1, String[] r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Intrinsics.checkNotNullParameter(r2, "$tables");
        r1.getInvalidationTracker().notifyObserversByTableNames((String[]) Arrays.copyOf(r2, r2.length));
    }

    @Override // androidx.room.IMultiInstanceInvalidationCallback
    public void onInvalidation(final String[] r3) {
        Intrinsics.checkNotNullParameter(r3, "tables");
        Executor r0 = this.this$0.getExecutor();
        final MultiInstanceInvalidationClient r2 = this.this$0;
        r0.execute(new MultiInstanceInvalidationClient$callback$1$$ExternalSyntheticLambda0(r2, r3));
    }
}
