package androidx.fragment.app;

import androidx.lifecycle.ViewModelStoreOwner;
import kotlin.Metadata;
import kotlin.n0.d.q;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelStoreOwner;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 176)
public final class FragmentViewModelLazyKt$viewModels$owner$2 extends q implements kotlin.n0.c.a<ViewModelStoreOwner> {
    final /* synthetic */ kotlin.n0.c.a<ViewModelStoreOwner> $ownerProducer;

    /* JADX WARN: Multi-variable type inference failed */
    public FragmentViewModelLazyKt$viewModels$owner$2(kotlin.n0.c.a<? extends ViewModelStoreOwner> r1) {
        this.$ownerProducer = r1;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.n0.c.a
    public final ViewModelStoreOwner invoke() {
        return this.$ownerProducer.invoke();
    }

    @Override // kotlin.n0.c.a
    public /* bridge */ /* synthetic */ ViewModelStoreOwner invoke() {
        return invoke();
    }
}
