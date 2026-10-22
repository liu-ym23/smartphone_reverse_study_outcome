package androidx.activity.result;

import androidx.core.app.ActivityOptionsCompat;
import com.obric.matrix.platform.sdk.ones.safecushion.SafeCushionConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ActivityResultLauncher.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u001a#\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0007¢\u0006\u0002\b\u0006¨\u0006\u0007"}, d2 = {SafeCushionConstant.LAUNCH_CRASH, "", "Landroidx/activity/result/ActivityResultLauncher;", "Ljava/lang/Void;", "options", "Landroidx/core/app/ActivityOptionsCompat;", "launchUnit", "activity-ktx_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class ActivityResultLauncherKt {
    public static /* synthetic */ void launch$default(ActivityResultLauncher r0, ActivityOptionsCompat r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        launch(r0, r1);
    }

    public static final void launch(ActivityResultLauncher<Void> r1, ActivityOptionsCompat r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        r1.launch(null, r2);
    }

    public static /* synthetic */ void launchUnit$default(ActivityResultLauncher r0, ActivityOptionsCompat r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        launchUnit(r0, r1);
    }

    public static final void launchUnit(ActivityResultLauncher<Unit> r1, ActivityOptionsCompat r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        r1.launch(Unit.INSTANCE, r2);
    }
}
