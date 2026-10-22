package androidx.navigation.ui;

import kotlin.Metadata;
import kotlin.n0.d.j;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {1, 6, 0}, xi = 176)
public final class AppBarConfigurationKt$sam$i$androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener$0 implements AppBarConfiguration.OnNavigateUpListener, j {
    private final /* synthetic */ kotlin.n0.c.a function;

    public AppBarConfigurationKt$sam$i$androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener$0(kotlin.n0.c.a r1) {
        this.function = r1;
    }

    public final boolean equals(Object r3) {
        if ((r3 instanceof AppBarConfiguration.OnNavigateUpListener) == true) goto L5;
        return false;
    L5:
        if ((r3 instanceof j) == true) goto L7;
        return false;
    L7:
        return o.a(getFunctionDelegate(), ((j) r3).getFunctionDelegate());
    }

    @Override // kotlin.n0.d.j
    public final kotlin.c<?> getFunctionDelegate() {
        return this.function;
    }

    public final int hashCode() {
        return getFunctionDelegate().hashCode();
    }

    @Override // androidx.navigation.ui.AppBarConfiguration.OnNavigateUpListener
    public final /* synthetic */ boolean onNavigateUp() {
        return ((Boolean) this.function.invoke()).booleanValue();
    }
}
