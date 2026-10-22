package androidx.navigation;

import androidx.annotation.IdRes;
import androidx.navigation.NavDestination;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.n0.c.l;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
@NavDestinationDsl
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u00022\u00020\u0003B!\b\u0017\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB!\b\u0016\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bB+\b\u0000\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\fJ)\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00072\u0017\u0010$\u001a\u0013\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\"0%¢\u0006\u0002\b'H\u0007J'\u0010(\u001a\u00020\"2\u0006\u0010)\u001a\u00020\n2\u0017\u0010*\u001a\u0013\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\"0%¢\u0006\u0002\b'J\r\u0010,\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010-J\u001f\u0010.\u001a\u00020\"2\u0017\u0010/\u001a\u0013\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\"0%¢\u0006\u0002\b'J\u000e\u0010.\u001a\u00020\"2\u0006\u00101\u001a\u00020\nR\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00110\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0005X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 ¨\u00062"}, d2 = {"Landroidx/navigation/NavDestinationBuilder;", "D", "Landroidx/navigation/NavDestination;", "", "navigator", "Landroidx/navigation/Navigator;", "id", "", "(Landroidx/navigation/Navigator;I)V", "route", "", "(Landroidx/navigation/Navigator;Ljava/lang/String;)V", "(Landroidx/navigation/Navigator;ILjava/lang/String;)V", "actions", "", "Landroidx/navigation/NavAction;", "arguments", "Landroidx/navigation/NavArgument;", "deepLinks", "", "Landroidx/navigation/NavDeepLink;", "getId", "()I", "label", "", "getLabel", "()Ljava/lang/CharSequence;", "setLabel", "(Ljava/lang/CharSequence;)V", "getNavigator", "()Landroidx/navigation/Navigator;", "getRoute", "()Ljava/lang/String;", "action", "", "actionId", "actionBuilder", "Lkotlin/Function1;", "Landroidx/navigation/NavActionBuilder;", "Lkotlin/ExtensionFunctionType;", "argument", "name", "argumentBuilder", "Landroidx/navigation/NavArgumentBuilder;", "build", "()Landroidx/navigation/NavDestination;", "deepLink", "navDeepLink", "Landroidx/navigation/NavDeepLinkDslBuilder;", "uriPattern", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class NavDestinationBuilder<D extends NavDestination> {
    private Map<Integer, NavAction> actions;
    private Map<String, NavArgument> arguments;
    private List<NavDeepLink> deepLinks;
    private final int id;
    private CharSequence label;
    private final Navigator<? extends D> navigator;
    private final String route;

    public NavDestinationBuilder(Navigator<? extends D> r2, @IdRes int r3) {
        o.f(r2, "navigator");
        this(r2, r3, null);
    }

    public NavDestinationBuilder(Navigator<? extends D> r2, @IdRes int r3, String r4) {
        o.f(r2, "navigator");
        this.navigator = r2;
        this.id = r3;
        this.route = r4;
        this.arguments = new LinkedHashMap();
        this.deepLinks = new ArrayList();
        this.actions = new LinkedHashMap();
    }

    public NavDestinationBuilder(Navigator<? extends D> r2, String r3) {
        o.f(r2, "navigator");
        this(r2, -1, r3);
    }

    public final void action(int r2, l<? super NavActionBuilder, f0> r3) {
        o.f(r3, "actionBuilder");
        Map<Integer, NavAction> r1 = this.actions;
        Integer r4 = Integer.valueOf(r2);
        NavActionBuilder r0 = new NavActionBuilder();
        r3.invoke(r0);
        r1.put(r4, r0.build$navigation_common_release());
    }

    public final void argument(String r2, l<? super NavArgumentBuilder, f0> r3) {
        o.f(r2, "name");
        o.f(r3, "argumentBuilder");
        Map<String, NavArgument> r1 = this.arguments;
        NavArgumentBuilder r0 = new NavArgumentBuilder();
        r3.invoke(r0);
        r1.put(r2, r0.build());
    }

    public D build() {
        D r0 = (D) this.navigator.createDestination();
        String r1 = this.route;
        if (r1 == null) goto L5;
        r0.setRoute(r1);
    L5:
        int r2 = this.id;
        if (r2 == (-1)) goto L8;
        r0.setId(r2);
    L8:
        r0.setLabel(this.label);
        Iterator<Map.Entry<String, NavArgument>> r3 = this.arguments.entrySet().iterator();
    L10:
        if (r3.hasNext() == false) goto L12;
        Map.Entry<String, NavArgument> r4 = r3.next();
        r0.addArgument(r4.getKey(), r4.getValue());
        goto L10
    L12:
        Iterator<T> r5 = this.deepLinks.iterator();
    L14:
        if (r5.hasNext() == false) goto L16;
        r0.addDeepLink((NavDeepLink) r5.next());
        goto L14
    L16:
        Iterator<Map.Entry<Integer, NavAction>> r6 = this.actions.entrySet().iterator();
    L18:
        if (r6.hasNext() == false) goto L20;
        Map.Entry<Integer, NavAction> r7 = r6.next();
        r0.putAction(r7.getKey().intValue(), r7.getValue());
        goto L18
    L20:
        return r0;
    }

    public final void deepLink(String r2) {
        o.f(r2, "uriPattern");
        this.deepLinks.add(new NavDeepLink(r2));
    }

    public final void deepLink(l<? super NavDeepLinkDslBuilder, f0> r2) {
        o.f(r2, "navDeepLink");
        List<NavDeepLink> r1 = this.deepLinks;
        NavDeepLinkDslBuilder r0 = new NavDeepLinkDslBuilder();
        r2.invoke(r0);
        r1.add(r0.build$navigation_common_release());
    }

    public final int getId() {
        return this.id;
    }

    public final CharSequence getLabel() {
        return this.label;
    }

    protected final Navigator<? extends D> getNavigator() {
        return this.navigator;
    }

    public final String getRoute() {
        return this.route;
    }

    public final void setLabel(CharSequence r1) {
        this.label = r1;
    }
}
