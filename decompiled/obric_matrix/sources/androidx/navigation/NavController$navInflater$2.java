package androidx.navigation;

import kotlin.Metadata;
import kotlin.n0.d.q;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/navigation/NavInflater;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class NavController$navInflater$2 extends q implements kotlin.n0.c.a<NavInflater> {
    final /* synthetic */ NavController this$0;

    NavController$navInflater$2(NavController r1) {
        this.this$0 = r1;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.n0.c.a
    public final NavInflater invoke() {
        NavInflater r0 = NavController.access$getInflater$p(this.this$0);
        if (r0 == null) goto L5;
        return r0;
    L5:
        return new NavInflater(this.this$0.getContext(), NavController.access$get_navigatorProvider$p(this.this$0));
    }

    @Override // kotlin.n0.c.a
    public /* bridge */ /* synthetic */ NavInflater invoke() {
        return invoke();
    }
}
