package androidx.fragment.app;

import androidx.lifecycle.ViewModelProvider;
import kotlin.Metadata;
import kotlin.n0.d.o;
import kotlin.n0.d.q;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelProvider$Factory;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class FragmentViewModelLazyKt$createViewModelLazy$factoryPromise$1 extends q implements kotlin.n0.c.a<ViewModelProvider.Factory> {
    final /* synthetic */ Fragment $this_createViewModelLazy;

    FragmentViewModelLazyKt$createViewModelLazy$factoryPromise$1(Fragment r1) {
        this.$this_createViewModelLazy = r1;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.n0.c.a
    public final ViewModelProvider.Factory invoke() {
        ViewModelProvider.Factory r1 = this.$this_createViewModelLazy.getDefaultViewModelProviderFactory();
        o.e(r1, "defaultViewModelProviderFactory");
        return r1;
    }

    @Override // kotlin.n0.c.a
    public /* bridge */ /* synthetic */ ViewModelProvider.Factory invoke() {
        return invoke();
    }
}
