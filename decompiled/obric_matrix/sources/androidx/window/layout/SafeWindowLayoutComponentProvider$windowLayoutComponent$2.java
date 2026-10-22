package androidx.window.layout;

import androidx.window.extensions.WindowExtensionsProvider;
import androidx.window.extensions.layout.WindowLayoutComponent;
import kotlin.Metadata;
import kotlin.n0.d.q;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/window/extensions/layout/WindowLayoutComponent;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class SafeWindowLayoutComponentProvider$windowLayoutComponent$2 extends q implements kotlin.n0.c.a<WindowLayoutComponent> {
    public static final SafeWindowLayoutComponentProvider$windowLayoutComponent$2 INSTANCE = null;

    static {
        INSTANCE = new SafeWindowLayoutComponentProvider$windowLayoutComponent$2();
    }

    SafeWindowLayoutComponentProvider$windowLayoutComponent$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.n0.c.a
    public final WindowLayoutComponent invoke() {
        ClassLoader r2 = SafeWindowLayoutComponentProvider.class.getClassLoader();
        if (r2 == null) goto L9;
        if (SafeWindowLayoutComponentProvider.access$canUseWindowLayoutComponent(SafeWindowLayoutComponentProvider.INSTANCE, r2) == false) goto L9;
        return WindowExtensionsProvider.getWindowExtensions().getWindowLayoutComponent();
    L9:
        return (WindowLayoutComponent) null;
    }

    @Override // kotlin.n0.c.a
    public /* bridge */ /* synthetic */ WindowLayoutComponent invoke() {
        return invoke();
    }
}
