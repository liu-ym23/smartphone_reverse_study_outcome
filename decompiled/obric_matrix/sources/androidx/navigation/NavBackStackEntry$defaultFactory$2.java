package androidx.navigation;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.SavedStateViewModelFactory;
import kotlin.Metadata;
import kotlin.n0.d.q;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/lifecycle/SavedStateViewModelFactory;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class NavBackStackEntry$defaultFactory$2 extends q implements kotlin.n0.c.a<SavedStateViewModelFactory> {
    final /* synthetic */ NavBackStackEntry this$0;

    NavBackStackEntry$defaultFactory$2(NavBackStackEntry r1) {
        this.this$0 = r1;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.n0.c.a
    public final SavedStateViewModelFactory invoke() {
        Context r1 = NavBackStackEntry.access$getContext$p(this.this$0);
        Application r2 = null;
        if (r1 == null) goto L5;
        Context r3 = r1.getApplicationContext();
    L7:
        if ((r3 instanceof Application) == false) goto L9;
        r2 = (Application) r3;
    L9:
        NavBackStackEntry r4 = this.this$0;
        return new SavedStateViewModelFactory(r2, r4, r4.getArguments());
    L5:
        r3 = null;
        goto L7
    }

    @Override // kotlin.n0.c.a
    public /* bridge */ /* synthetic */ SavedStateViewModelFactory invoke() {
        return invoke();
    }
}
