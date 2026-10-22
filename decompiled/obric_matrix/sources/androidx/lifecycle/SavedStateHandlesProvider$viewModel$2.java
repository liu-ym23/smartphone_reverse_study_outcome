package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.n0.d.q;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/lifecycle/SavedStateHandlesVM;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class SavedStateHandlesProvider$viewModel$2 extends q implements kotlin.n0.c.a<SavedStateHandlesVM> {
    final /* synthetic */ ViewModelStoreOwner $viewModelStoreOwner;

    SavedStateHandlesProvider$viewModel$2(ViewModelStoreOwner r1) {
        this.$viewModelStoreOwner = r1;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.n0.c.a
    public final SavedStateHandlesVM invoke() {
        return SavedStateHandleSupport.getSavedStateHandlesVM(this.$viewModelStoreOwner);
    }

    @Override // kotlin.n0.c.a
    public /* bridge */ /* synthetic */ SavedStateHandlesVM invoke() {
        return invoke();
    }
}
