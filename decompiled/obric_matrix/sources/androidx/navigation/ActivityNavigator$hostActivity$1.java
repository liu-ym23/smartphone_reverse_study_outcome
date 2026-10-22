package androidx.navigation;

import android.content.Context;
import android.content.ContextWrapper;
import kotlin.Metadata;
import kotlin.n0.c.l;
import kotlin.n0.d.o;
import kotlin.n0.d.q;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroid/content/Context;", "it", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class ActivityNavigator$hostActivity$1 extends q implements l<Context, Context> {
    public static final ActivityNavigator$hostActivity$1 INSTANCE = null;

    static {
        INSTANCE = new ActivityNavigator$hostActivity$1();
    }

    ActivityNavigator$hostActivity$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Context invoke2(Context r1) {
        o.f(r1, "it");
        if ((r1 instanceof ContextWrapper) == true) goto L7;
        return null;
    L7:
        return ((ContextWrapper) r1).getBaseContext();
    }

    @Override // kotlin.n0.c.l
    public /* bridge */ /* synthetic */ Context invoke(Context r1) {
        return invoke2(r1);
    }
}
