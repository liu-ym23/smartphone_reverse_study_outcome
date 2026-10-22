package androidx.navigation;

import androidx.lifecycle.ViewModelStore;
import kotlin.Metadata;
import kotlin.h;
import kotlin.n0.d.q;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelStore;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 176)
public final class NavGraphViewModelLazyKt$navGraphViewModels$storeProducer$1 extends q implements kotlin.n0.c.a<ViewModelStore> {
    final /* synthetic */ h<NavBackStackEntry> $backStackEntry$delegate;

    public NavGraphViewModelLazyKt$navGraphViewModels$storeProducer$1(h<NavBackStackEntry> r1) {
        this.$backStackEntry$delegate = r1;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.n0.c.a
    public final ViewModelStore invoke() {
        return NavGraphViewModelLazyKt.m24access$navGraphViewModels$lambda0(this.$backStackEntry$delegate).getViewModelStore();
    }

    @Override // kotlin.n0.c.a
    public /* bridge */ /* synthetic */ ViewModelStore invoke() {
        return invoke();
    }
}
