package androidx.navigation;

import kotlin.Metadata;
import kotlin.f0;
import kotlin.n0.d.q;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class NavController$NavControllerNavigatorState$pop$1 extends q implements kotlin.n0.c.a<f0> {
    final /* synthetic */ NavBackStackEntry $popUpTo;
    final /* synthetic */ boolean $saveState;
    final /* synthetic */ NavController.NavControllerNavigatorState this$0;

    NavController$NavControllerNavigatorState$pop$1(NavController.NavControllerNavigatorState r1, NavBackStackEntry r2, boolean r3) {
        this.this$0 = r1;
        this.$popUpTo = r2;
        this.$saveState = r3;
        super(0);
    }

    @Override // kotlin.n0.c.a
    public /* bridge */ /* synthetic */ f0 invoke() {
        invoke2();
        return f0.f18324a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        NavController.NavControllerNavigatorState.access$pop$s261051546(this.this$0, this.$popUpTo, this.$saveState);
    }
}
