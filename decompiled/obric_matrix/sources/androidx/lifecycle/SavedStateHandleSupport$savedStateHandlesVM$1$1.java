package androidx.lifecycle;

import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.Metadata;
import kotlin.n0.c.l;
import kotlin.n0.d.o;
import kotlin.n0.d.q;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroidx/lifecycle/SavedStateHandlesVM;", "Landroidx/lifecycle/viewmodel/CreationExtras;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class SavedStateHandleSupport$savedStateHandlesVM$1$1 extends q implements l<CreationExtras, SavedStateHandlesVM> {
    public static final SavedStateHandleSupport$savedStateHandlesVM$1$1 INSTANCE = null;

    static {
        INSTANCE = new SavedStateHandleSupport$savedStateHandlesVM$1$1();
    }

    SavedStateHandleSupport$savedStateHandlesVM$1$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final SavedStateHandlesVM invoke2(CreationExtras r1) {
        o.f(r1, "$this$initializer");
        return new SavedStateHandlesVM();
    }

    @Override // kotlin.n0.c.l
    public /* bridge */ /* synthetic */ SavedStateHandlesVM invoke(CreationExtras r1) {
        return invoke2(r1);
    }
}
