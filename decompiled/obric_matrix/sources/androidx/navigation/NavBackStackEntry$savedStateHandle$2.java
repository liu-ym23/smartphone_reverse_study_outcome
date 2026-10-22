package androidx.navigation;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModelProvider;
import kotlin.Metadata;
import kotlin.n0.d.q;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/lifecycle/SavedStateHandle;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class NavBackStackEntry$savedStateHandle$2 extends q implements kotlin.n0.c.a<SavedStateHandle> {
    final /* synthetic */ NavBackStackEntry this$0;

    NavBackStackEntry$savedStateHandle$2(NavBackStackEntry r1) {
        this.this$0 = r1;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.n0.c.a
    public final SavedStateHandle invoke() {
        if (NavBackStackEntry.access$getSavedStateRegistryAttached$p(this.this$0) == false) goto L14;
        if (NavBackStackEntry.access$getLifecycle$p(this.this$0).getCurrentState() == Lifecycle.State.DESTROYED) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == false) goto L12;
        return ((NavBackStackEntry.SavedStateViewModel) new ViewModelProvider(this.this$0, new NavBackStackEntry.NavResultSavedStateFactory(this.this$0)).get(NavBackStackEntry.SavedStateViewModel.class)).getHandle();
    L12:
        throw new IllegalStateException("You cannot access the NavBackStackEntry's SavedStateHandle after the NavBackStackEntry is destroyed.".toString());
    L7:
        r0 = false;
        goto L8
    L14:
        throw new IllegalStateException("You cannot access the NavBackStackEntry's SavedStateHandle until it is added to the NavController's back stack (i.e., the Lifecycle of the NavBackStackEntry reaches the CREATED state).".toString());
    }

    @Override // kotlin.n0.c.a
    public /* bridge */ /* synthetic */ SavedStateHandle invoke() {
        return invoke();
    }
}
