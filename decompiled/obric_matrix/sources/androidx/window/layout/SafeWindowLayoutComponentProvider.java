package androidx.window.layout;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.window.extensions.layout.WindowLayoutComponent;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.function.Consumer;
import kotlin.Metadata;
import kotlin.h;
import kotlin.i;
import kotlin.n0.d.e0;
import kotlin.n0.d.o;
import kotlin.n0.d.q;
import kotlin.s0.d;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J \u0010\u0010\u001a\u0012\u0012\u0002\b\u0003 \u0012*\b\u0012\u0002\b\u0003\u0018\u00010\u00110\u00112\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0013\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0014\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0003J\u0010\u0010\u0016\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0016\u0010\u0017\u001a\u00020\n2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u0019H\u0002J \u0010\u001a\u001a\u0012\u0012\u0002\b\u0003 \u0012*\b\u0012\u0002\b\u0003\u0018\u00010\u00110\u00112\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J \u0010\u001b\u001a\u0012\u0012\u0002\b\u0003 \u0012*\b\u0012\u0002\b\u0003\u0018\u00010\u00110\u00112\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J \u0010\u001c\u001a\u0012\u0012\u0002\b\u0003 \u0012*\b\u0012\u0002\b\u0003\u0018\u00010\u00110\u00112\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0018\u0010\u001d\u001a\u00020\n*\u00020\u000b2\n\u0010\u001e\u001a\u0006\u0012\u0002\b\u00030\u0011H\u0002J\u0018\u0010\u001d\u001a\u00020\n*\u00020\u000b2\n\u0010\u001e\u001a\u0006\u0012\u0002\b\u00030\u001fH\u0002R\u001d\u0010\u0003\u001a\u0004\u0018\u00010\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\t\u001a\u00020\n*\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\f¨\u0006 "}, d2 = {"Landroidx/window/layout/SafeWindowLayoutComponentProvider;", "", "()V", "windowLayoutComponent", "Landroidx/window/extensions/layout/WindowLayoutComponent;", "getWindowLayoutComponent", "()Landroidx/window/extensions/layout/WindowLayoutComponent;", "windowLayoutComponent$delegate", "Lkotlin/Lazy;", "isPublic", "", "Ljava/lang/reflect/Method;", "(Ljava/lang/reflect/Method;)Z", "canUseWindowLayoutComponent", "classLoader", "Ljava/lang/ClassLoader;", "foldingFeatureClass", "Ljava/lang/Class;", "kotlin.jvm.PlatformType", "isFoldingFeatureValid", "isWindowExtensionsValid", "isWindowLayoutComponentValid", "isWindowLayoutProviderValid", "validate", "block", "Lkotlin/Function0;", "windowExtensionsClass", "windowExtensionsProviderClass", "windowLayoutComponentClass", "doesReturn", "clazz", "Lkotlin/reflect/KClass;", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SafeWindowLayoutComponentProvider {
    public static final SafeWindowLayoutComponentProvider INSTANCE = null;
    private static final h windowLayoutComponent$delegate = null;

    /* JADX INFO: renamed from: androidx.window.layout.SafeWindowLayoutComponentProvider$isFoldingFeatureValid$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class AnonymousClass1 extends q implements kotlin.n0.c.a<Boolean> {
        final /* synthetic */ ClassLoader $classLoader;

        AnonymousClass1(ClassLoader r1) {
            this.$classLoader = r1;
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.n0.c.a
        public final Boolean invoke() {
            SafeWindowLayoutComponentProvider r0 = SafeWindowLayoutComponentProvider.INSTANCE;
            Class r6 = SafeWindowLayoutComponentProvider.access$foldingFeatureClass(r0, this.$classLoader);
            boolean r1 = false;
            Method r2 = r6.getMethod("getBounds", new Class[0]);
            Method r3 = r6.getMethod("getType", new Class[0]);
            Method r7 = r6.getMethod("getState", new Class[0]);
            o.e(r2, "getBoundsMethod");
            if (SafeWindowLayoutComponentProvider.access$doesReturn(r0, r2, e0.b(Rect.class)) == false) goto L16;
            if (SafeWindowLayoutComponentProvider.access$isPublic(r0, r2) == false) goto L16;
            o.e(r3, "getTypeMethod");
            Class r4 = Integer.TYPE;
            if (SafeWindowLayoutComponentProvider.access$doesReturn(r0, r3, e0.b(r4)) == false) goto L16;
            if (SafeWindowLayoutComponentProvider.access$isPublic(r0, r3) == false) goto L16;
            o.e(r7, "getStateMethod");
            if (SafeWindowLayoutComponentProvider.access$doesReturn(r0, r7, e0.b(r4)) == false) goto L16;
            if (SafeWindowLayoutComponentProvider.access$isPublic(r0, r7) == false) goto L16;
            r1 = true;
        L16:
            return Boolean.valueOf(r1);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ Boolean invoke() {
            return invoke();
        }
    }

    /* JADX INFO: renamed from: androidx.window.layout.SafeWindowLayoutComponentProvider$isWindowExtensionsValid$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class C06391 extends q implements kotlin.n0.c.a<Boolean> {
        final /* synthetic */ ClassLoader $classLoader;

        C06391(ClassLoader r1) {
            this.$classLoader = r1;
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.n0.c.a
        public final Boolean invoke() {
            SafeWindowLayoutComponentProvider r0 = SafeWindowLayoutComponentProvider.INSTANCE;
            boolean r2 = false;
            Method r1 = SafeWindowLayoutComponentProvider.access$windowExtensionsClass(r0, this.$classLoader).getMethod("getWindowLayoutComponent", new Class[0]);
            Class r5 = SafeWindowLayoutComponentProvider.access$windowLayoutComponentClass(r0, this.$classLoader);
            o.e(r1, "getWindowLayoutComponentMethod");
            if (SafeWindowLayoutComponentProvider.access$isPublic(r0, r1) == false) goto L8;
            o.e(r5, "windowLayoutComponentClass");
            if (SafeWindowLayoutComponentProvider.access$doesReturn(r0, r1, r5) == false) goto L8;
            r2 = true;
        L8:
            return Boolean.valueOf(r2);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ Boolean invoke() {
            return invoke();
        }
    }

    /* JADX INFO: renamed from: androidx.window.layout.SafeWindowLayoutComponentProvider$isWindowLayoutComponentValid$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class C06401 extends q implements kotlin.n0.c.a<Boolean> {
        final /* synthetic */ ClassLoader $classLoader;

        C06401(ClassLoader r1) {
            this.$classLoader = r1;
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.n0.c.a
        public final Boolean invoke() {
            SafeWindowLayoutComponentProvider r0 = SafeWindowLayoutComponentProvider.INSTANCE;
            Class r6 = SafeWindowLayoutComponentProvider.access$windowLayoutComponentClass(r0, this.$classLoader);
            boolean r3 = false;
            Method r1 = r6.getMethod("addWindowLayoutInfoListener", new Class[]{Activity.class, Consumer.class});
            Method r7 = r6.getMethod("removeWindowLayoutInfoListener", new Class[]{Consumer.class});
            o.e(r1, "addListenerMethod");
            if (SafeWindowLayoutComponentProvider.access$isPublic(r0, r1) == false) goto L8;
            o.e(r7, "removeListenerMethod");
            if (SafeWindowLayoutComponentProvider.access$isPublic(r0, r7) == false) goto L8;
            r3 = true;
        L8:
            return Boolean.valueOf(r3);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ Boolean invoke() {
            return invoke();
        }
    }

    /* JADX INFO: renamed from: androidx.window.layout.SafeWindowLayoutComponentProvider$isWindowLayoutProviderValid$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class C06411 extends q implements kotlin.n0.c.a<Boolean> {
        final /* synthetic */ ClassLoader $classLoader;

        C06411(ClassLoader r1) {
            this.$classLoader = r1;
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.n0.c.a
        public final Boolean invoke() {
            SafeWindowLayoutComponentProvider r0 = SafeWindowLayoutComponentProvider.INSTANCE;
            boolean r2 = false;
            Method r1 = SafeWindowLayoutComponentProvider.access$windowExtensionsProviderClass(r0, this.$classLoader).getDeclaredMethod("getWindowExtensions", new Class[0]);
            Class r5 = SafeWindowLayoutComponentProvider.access$windowExtensionsClass(r0, this.$classLoader);
            o.e(r1, "getWindowExtensionsMethod");
            o.e(r5, "windowExtensionsClass");
            if (SafeWindowLayoutComponentProvider.access$doesReturn(r0, r1, r5) == false) goto L8;
            if (SafeWindowLayoutComponentProvider.access$isPublic(r0, r1) == false) goto L8;
            r2 = true;
        L8:
            return Boolean.valueOf(r2);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ Boolean invoke() {
            return invoke();
        }
    }

    static {
        INSTANCE = new SafeWindowLayoutComponentProvider();
        windowLayoutComponent$delegate = i.b(SafeWindowLayoutComponentProvider$windowLayoutComponent$2.INSTANCE);
    }

    private SafeWindowLayoutComponentProvider() {
    }

    public static final /* synthetic */ boolean access$canUseWindowLayoutComponent(SafeWindowLayoutComponentProvider r0, ClassLoader r1) {
        return r0.canUseWindowLayoutComponent(r1);
    }

    public static final /* synthetic */ boolean access$doesReturn(SafeWindowLayoutComponentProvider r0, Method r1, Class r2) {
        return r0.doesReturn(r1, r2);
    }

    public static final /* synthetic */ boolean access$doesReturn(SafeWindowLayoutComponentProvider r0, Method r1, d r2) {
        return r0.doesReturn(r1, r2);
    }

    public static final /* synthetic */ Class access$foldingFeatureClass(SafeWindowLayoutComponentProvider r0, ClassLoader r1) {
        return r0.foldingFeatureClass(r1);
    }

    public static final /* synthetic */ boolean access$isPublic(SafeWindowLayoutComponentProvider r0, Method r1) {
        return r0.isPublic(r1);
    }

    public static final /* synthetic */ Class access$windowExtensionsClass(SafeWindowLayoutComponentProvider r0, ClassLoader r1) {
        return r0.windowExtensionsClass(r1);
    }

    public static final /* synthetic */ Class access$windowExtensionsProviderClass(SafeWindowLayoutComponentProvider r0, ClassLoader r1) {
        return r0.windowExtensionsProviderClass(r1);
    }

    public static final /* synthetic */ Class access$windowLayoutComponentClass(SafeWindowLayoutComponentProvider r0, ClassLoader r1) {
        return r0.windowLayoutComponentClass(r1);
    }

    private final boolean canUseWindowLayoutComponent(ClassLoader r4) {
        if (Build.VERSION.SDK_INT >= 24) goto L5;
        return false;
    L5:
        if (isWindowLayoutProviderValid(r4) == true) goto L7;
        return false;
    L7:
        if (isWindowExtensionsValid(r4) == true) goto L9;
        return false;
    L9:
        if (isWindowLayoutComponentValid(r4) == true) goto L11;
        return false;
    L11:
        if (isFoldingFeatureValid(r4) == false) goto L18;
        return true;
    L18:
        return false;
    }

    private final boolean doesReturn(Method r1, Class<?> r2) {
        return r1.getReturnType().equals(r2);
    }

    private final boolean doesReturn(Method r1, d<?> r2) {
        return doesReturn(r1, kotlin.n0.a.b(r2));
    }

    private final Class<?> foldingFeatureClass(ClassLoader r1) {
        return r1.loadClass("androidx.window.extensions.layout.FoldingFeature");
    }

    private final boolean isFoldingFeatureValid(ClassLoader r2) {
        return validate(new AnonymousClass1(r2));
    }

    private final boolean isPublic(Method r1) {
        return Modifier.isPublic(r1.getModifiers());
    }

    private final boolean isWindowExtensionsValid(ClassLoader r2) {
        return validate(new C06391(r2));
    }

    @RequiresApi(24)
    private final boolean isWindowLayoutComponentValid(ClassLoader r2) {
        return validate(new C06401(r2));
    }

    private final boolean isWindowLayoutProviderValid(ClassLoader r2) {
        return validate(new C06411(r2));
    }

    private final boolean validate(kotlin.n0.c.a<Boolean> r1) {
        return r1.invoke().booleanValue();
    L8:
        return false;
    }

    private final Class<?> windowExtensionsClass(ClassLoader r1) {
        return r1.loadClass("androidx.window.extensions.WindowExtensions");
    }

    private final Class<?> windowExtensionsProviderClass(ClassLoader r1) {
        return r1.loadClass("androidx.window.extensions.WindowExtensionsProvider");
    }

    private final Class<?> windowLayoutComponentClass(ClassLoader r1) {
        return r1.loadClass("androidx.window.extensions.layout.WindowLayoutComponent");
    }

    public final WindowLayoutComponent getWindowLayoutComponent() {
        return (WindowLayoutComponent) windowLayoutComponent$delegate.getValue();
    }
}
