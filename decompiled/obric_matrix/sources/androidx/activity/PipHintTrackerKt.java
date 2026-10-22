package androidx.activity;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import androidx.annotation.RequiresApi;
import kotlin.Metadata;
import kotlin.f0;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001d\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006"}, d2 = {"trackPipAnimationHintView", "", "Landroid/app/Activity;", "view", "Landroid/view/View;", "(Landroid/app/Activity;Landroid/view/View;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "activity-ktx_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class PipHintTrackerKt {
    public static final /* synthetic */ Rect access$trackPipAnimationHintView$positionInWindow(View r0) {
        return trackPipAnimationHintView$positionInWindow(r0);
    }

    @RequiresApi(26)
    public static final Object trackPipAnimationHintView(final Activity r2, View r3, kotlin.k0.d<? super f0> r4) {
        Object r5 = h.a.e3.g.c(new PipHintTrackerKt$trackPipAnimationHintView$flow$1(r3, null)).collect(new AnonymousClass2(r2), r4);
        if (r5 != kotlin.k0.i.b.c()) goto L6;
        return r5;
    L6:
        return f0.f18324a;
    }

    private static final Rect trackPipAnimationHintView$positionInWindow(View r1) {
        Rect r0 = new Rect();
        r1.getGlobalVisibleRect(r0);
        return r0;
    }
}
