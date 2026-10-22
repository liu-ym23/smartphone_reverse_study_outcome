package androidx.navigation;

import android.annotation.SuppressLint;
import androidx.annotation.CallSuper;
import androidx.annotation.RestrictTo;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.i0.m0;
import kotlin.n0.d.g;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0002J \u0010\f\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0007\u0018\u00010\u00062\u000e\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006J*\u0010\f\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0007\u0018\u00010\u00062\u0006\u0010\u000e\u001a\u00020\u00052\u000e\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006H\u0017J'\u0010\u000f\u001a\u0002H\u0010\"\f\b\u0000\u0010\u0010*\u0006\u0012\u0002\b\u00030\u00062\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0012¢\u0006\u0002\u0010\u0013J#\u0010\u000f\u001a\u0002H\u0010\"\f\b\u0000\u0010\u0010*\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\u000e\u001a\u00020\u0005H\u0017¢\u0006\u0002\u0010\u0014R\"\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R%\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u00060\t8G¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Landroidx/navigation/NavigatorProvider;", "", "()V", "_navigators", "", "", "Landroidx/navigation/Navigator;", "Landroidx/navigation/NavDestination;", "navigators", "", "getNavigators", "()Ljava/util/Map;", "addNavigator", "navigator", "name", "getNavigator", "T", "navigatorClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/navigation/Navigator;", "(Ljava/lang/String;)Landroidx/navigation/Navigator;", "Companion", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@SuppressLint({"TypeParameterUnusedInFormals"})
public class NavigatorProvider {
    public static final Companion Companion = null;
    private static final Map<Class<?>, String> annotationNames = null;
    private final Map<String, Navigator<? extends NavDestination>> _navigators;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J!\u0010\u0007\u001a\u00020\u00062\u0012\u0010\b\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\t0\u0005H\u0001¢\u0006\u0002\b\nJ\u0017\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0000¢\u0006\u0002\b\u000eR \u0010\u0003\u001a\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Landroidx/navigation/NavigatorProvider$Companion;", "", "()V", "annotationNames", "", "Ljava/lang/Class;", "", "getNameForNavigator", "navigatorClass", "Landroidx/navigation/Navigator;", "getNameForNavigator$navigation_common_release", "validateName", "", "name", "validateName$navigation_common_release", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g r1) {
            this();
        }

        public final String getNameForNavigator$navigation_common_release(Class<? extends Navigator<?>> r2) {
            o.f(r2, "navigatorClass");
            String r0 = (String) NavigatorProvider.access$getAnnotationNames$cp().get(r2);
            if (r0 != null) goto L13;
            Navigator.Name r1 = (Navigator.Name) r2.getAnnotation(Navigator.Name.class);
            if (r1 == null) goto L7;
            r0 = r1.value();
        L9:
            if (validateName$navigation_common_release(r0) == false) goto L12;
            NavigatorProvider.access$getAnnotationNames$cp().put(r2, r0);
            goto L13
        L12:
            throw new IllegalArgumentException(("No @Navigator.Name annotation found for " + r2.getSimpleName()).toString());
        L7:
            r0 = null;
        L13:
            o.c(r0);
            return r0;
        }

        public final boolean validateName$navigation_common_release(String r2) {
            if (r2 == null) goto L11;
            if (r2.length() <= 0) goto L7;
            boolean r3 = true;
        L8:
            if (r3 == false) goto L11;
            return true;
        L7:
            r3 = false;
        L11:
            return false;
        }
    }

    static {
        Companion = new Companion(null);
        annotationNames = new LinkedHashMap();
    }

    public NavigatorProvider() {
        this._navigators = new LinkedHashMap();
    }

    public static final /* synthetic */ Map access$getAnnotationNames$cp() {
        return annotationNames;
    }

    public static final String getNameForNavigator$navigation_common_release(Class<? extends Navigator<?>> r1) {
        return Companion.getNameForNavigator$navigation_common_release(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Navigator<? extends NavDestination> addNavigator(Navigator<? extends NavDestination> r3) {
        o.f(r3, "navigator");
        return addNavigator(Companion.getNameForNavigator$navigation_common_release(r3.getClass()), r3);
    }

    @CallSuper
    public Navigator<? extends NavDestination> addNavigator(String r5, Navigator<? extends NavDestination> r6) {
        o.f(r5, "name");
        o.f(r6, "navigator");
        if (Companion.validateName$navigation_common_release(r5) == false) goto L23;
        Navigator<? extends NavDestination> r0 = this._navigators.get(r5);
        if (o.a(r0, r6) == false) goto L7;
        return r6;
    L7:
        boolean r1 = false;
        if (r0 == null) goto L13;
        if (r0.isAttached() != true) goto L13;
        r1 = true;
    L13:
        if ((!r1) == false) goto L21;
        if ((!r6.isAttached()) == false) goto L19;
        return this._navigators.put(r5, r6);
    L19:
        throw new IllegalStateException(("Navigator " + r6 + " is already attached to another NavController").toString());
    L21:
        throw new IllegalStateException(("Navigator " + r6 + " is replacing an already attached " + r0).toString());
    L23:
        throw new IllegalArgumentException("navigator name cannot be an empty string".toString());
    }

    public final <T extends Navigator<?>> T getNavigator(Class<T> r2) {
        o.f(r2, "navigatorClass");
        return (T) getNavigator(Companion.getNameForNavigator$navigation_common_release(r2));
    }

    @CallSuper
    public <T extends Navigator<?>> T getNavigator(String r3) {
        o.f(r3, "name");
        if (Companion.validateName$navigation_common_release(r3) == false) goto L10;
        Navigator<? extends NavDestination> r2 = this._navigators.get(r3);
        if (r2 == null) goto L8;
        return r2;
    L8:
        throw new IllegalStateException("Could not find Navigator with name \"" + r3 + "\". You must call NavController.addNavigator() for each navigation type.");
    L10:
        throw new IllegalArgumentException("navigator name cannot be an empty string".toString());
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final Map<String, Navigator<? extends NavDestination>> getNavigators() {
        return m0.s(this._navigators);
    }
}
