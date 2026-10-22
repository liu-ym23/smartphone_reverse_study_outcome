package androidx.navigation;

import kotlin.Metadata;
import kotlin.f0;
import kotlin.n0.c.l;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\b\b¨\u0006\t"}, d2 = {"navArgument", "Landroidx/navigation/NamedNavArgument;", "name", "", "builder", "Lkotlin/Function1;", "Landroidx/navigation/NavArgumentBuilder;", "", "Lkotlin/ExtensionFunctionType;", "navigation-common_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class NamedNavArgumentKt {
    public static final NamedNavArgument navArgument(String r2, l<? super NavArgumentBuilder, f0> r3) {
        o.f(r2, "name");
        o.f(r3, "builder");
        NavArgumentBuilder r1 = new NavArgumentBuilder();
        r3.invoke(r1);
        return new NamedNavArgument(r2, r1.build());
    }
}
