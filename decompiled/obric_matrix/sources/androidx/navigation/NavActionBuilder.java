package androidx.navigation;

import android.os.Bundle;
import androidx.core.os.BundleKt;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.i0.m0;
import kotlin.n0.c.l;
import kotlin.n0.d.o;
import kotlin.u;

/* JADX INFO: loaded from: classes.dex */
@NavDestinationDsl
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\r\u0010\u0010\u001a\u00020\u0011H\u0000¢\u0006\u0002\b\u0012J\u001f\u0010\u000e\u001a\u00020\u00132\u0017\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00130\u0015¢\u0006\u0002\b\u0017R\u001f\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Landroidx/navigation/NavActionBuilder;", "", "()V", "defaultArguments", "", "", "getDefaultArguments", "()Ljava/util/Map;", "destinationId", "", "getDestinationId", "()I", "setDestinationId", "(I)V", "navOptions", "Landroidx/navigation/NavOptions;", "build", "Landroidx/navigation/NavAction;", "build$navigation_common_release", "", "optionsBuilder", "Lkotlin/Function1;", "Landroidx/navigation/NavOptionsBuilder;", "Lkotlin/ExtensionFunctionType;", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NavActionBuilder {
    private final Map<String, Object> defaultArguments;
    private int destinationId;
    private NavOptions navOptions;

    public NavActionBuilder() {
        this.defaultArguments = new LinkedHashMap();
    }

    public final NavAction build$navigation_common_release() {
        int r1 = this.destinationId;
        NavOptions r2 = this.navOptions;
        if (this.defaultArguments.isEmpty() == false) goto L5;
        Bundle r4 = null;
    L7:
        return new NavAction(r1, r2, r4);
    L5:
        Object[] r5 = m0.w(this.defaultArguments).toArray(new u[0]);
        Objects.requireNonNull(r5, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        u[] r6 = (u[]) r5;
        r4 = BundleKt.bundleOf((u[]) Arrays.copyOf(r6, r6.length));
        goto L7
    }

    public final Map<String, Object> getDefaultArguments() {
        return this.defaultArguments;
    }

    public final int getDestinationId() {
        return this.destinationId;
    }

    public final void navOptions(l<? super NavOptionsBuilder, f0> r2) {
        o.f(r2, "optionsBuilder");
        NavOptionsBuilder r0 = new NavOptionsBuilder();
        r2.invoke(r0);
        this.navOptions = r0.build$navigation_common_release();
    }

    public final void setDestinationId(int r1) {
        this.destinationId = r1;
    }
}
