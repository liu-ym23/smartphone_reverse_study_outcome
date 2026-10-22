package androidx.navigation;

import androidx.annotation.IdRes;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.n0.c.l;
import kotlin.n0.d.o;
import kotlin.n0.d.q;
import kotlin.u0.k;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001f\u0010\"\u001a\u00020#2\u0017\u0010$\u001a\u0013\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020#0%¢\u0006\u0002\b'J\r\u0010(\u001a\u00020)H\u0000¢\u0006\u0002\b*J+\u0010\u000e\u001a\u00020#2\b\b\u0001\u0010+\u001a\u00020\r2\u0019\b\u0002\u0010,\u001a\u0013\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020#0%¢\u0006\u0002\b'J)\u0010\u000e\u001a\u00020#2\u0006\u0010.\u001a\u00020\u00172\u0019\b\u0002\u0010,\u001a\u0013\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020#0%¢\u0006\u0002\b'R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR*\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r8F@GX\u0087\u000e¢\u0006\u0012\u0012\u0004\b\u000f\u0010\u0002\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R&\u0010\u0014\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r8\u0006@@X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R(\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\f\u001a\u0004\u0018\u00010\u0017@BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR&\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\t\"\u0004\b \u0010\u000bR\u000e\u0010!\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Landroidx/navigation/NavOptionsBuilder;", "", "()V", "builder", "Landroidx/navigation/NavOptions$Builder;", "inclusive", "", "launchSingleTop", "getLaunchSingleTop", "()Z", "setLaunchSingleTop", "(Z)V", "value", "", "popUpTo", "getPopUpTo$annotations", "getPopUpTo", "()I", "setPopUpTo", "(I)V", "popUpToId", "getPopUpToId", "setPopUpToId$navigation_common_release", "", "popUpToRoute", "getPopUpToRoute", "()Ljava/lang/String;", "setPopUpToRoute", "(Ljava/lang/String;)V", "<set-?>", "restoreState", "getRestoreState", "setRestoreState", "saveState", "anim", "", "animBuilder", "Lkotlin/Function1;", "Landroidx/navigation/AnimBuilder;", "Lkotlin/ExtensionFunctionType;", "build", "Landroidx/navigation/NavOptions;", "build$navigation_common_release", "id", "popUpToBuilder", "Landroidx/navigation/PopUpToBuilder;", "route", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@NavOptionsDsl
public final class NavOptionsBuilder {
    private final NavOptions.Builder builder;
    private boolean inclusive;
    private boolean launchSingleTop;

    @IdRes
    private int popUpToId;
    private String popUpToRoute;
    private boolean restoreState;
    private boolean saveState;

    /* JADX INFO: renamed from: androidx.navigation.NavOptionsBuilder$popUpTo$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/navigation/PopUpToBuilder;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class AnonymousClass1 extends q implements l<PopUpToBuilder, f0> {
        public static final AnonymousClass1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass1();
        }

        AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ f0 invoke(PopUpToBuilder r1) {
            invoke2(r1);
            return f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(PopUpToBuilder r1) {
            o.f(r1, "$this$null");
        }
    }

    /* JADX INFO: renamed from: androidx.navigation.NavOptionsBuilder$popUpTo$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/navigation/PopUpToBuilder;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class AnonymousClass2 extends q implements l<PopUpToBuilder, f0> {
        public static final AnonymousClass2 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass2();
        }

        AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ f0 invoke(PopUpToBuilder r1) {
            invoke2(r1);
            return f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(PopUpToBuilder r1) {
            o.f(r1, "$this$null");
        }
    }

    public NavOptionsBuilder() {
        this.builder = new NavOptions.Builder();
        this.popUpToId = -1;
    }

    public static /* synthetic */ void getPopUpTo$annotations() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void popUpTo$default(NavOptionsBuilder r0, int r1, l r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = AnonymousClass1.INSTANCE;
    L5:
        r0.popUpTo(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void popUpTo$default(NavOptionsBuilder r0, String r1, l r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = AnonymousClass2.INSTANCE;
    L5:
        r0.popUpTo(r1, r2);
    }

    private final void setPopUpToRoute(String r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if ((!k.q(r2)) == false) goto L7;
        this.popUpToRoute = r2;
        this.inclusive = false;
        return;
    L7:
        throw new IllegalArgumentException("Cannot pop up to an empty route".toString());
    }

    public final void anim(l<? super AnimBuilder, f0> r2) {
        o.f(r2, "animBuilder");
        AnimBuilder r0 = new AnimBuilder();
        r2.invoke(r0);
        this.builder.setEnterAnim(r0.getEnter()).setExitAnim(r0.getExit()).setPopEnterAnim(r0.getPopEnter()).setPopExitAnim(r0.getPopExit());
    }

    public final NavOptions build$navigation_common_release() {
        NavOptions.Builder r0 = this.builder;
        r0.setLaunchSingleTop(this.launchSingleTop);
        r0.setRestoreState(this.restoreState);
        String r1 = this.popUpToRoute;
        if (r1 == null) goto L5;
        r0.setPopUpTo(r1, this.inclusive, this.saveState);
    L7:
        return r0.build();
    L5:
        r0.setPopUpTo(this.popUpToId, this.inclusive, this.saveState);
        goto L7
    }

    public final boolean getLaunchSingleTop() {
        return this.launchSingleTop;
    }

    public final int getPopUpTo() {
        return this.popUpToId;
    }

    public final int getPopUpToId() {
        return this.popUpToId;
    }

    public final String getPopUpToRoute() {
        return this.popUpToRoute;
    }

    public final boolean getRestoreState() {
        return this.restoreState;
    }

    public final void popUpTo(@IdRes int r2, l<? super PopUpToBuilder, f0> r3) {
        o.f(r3, "popUpToBuilder");
        setPopUpToId$navigation_common_release(r2);
        setPopUpToRoute(null);
        PopUpToBuilder r4 = new PopUpToBuilder();
        r3.invoke(r4);
        this.inclusive = r4.getInclusive();
        this.saveState = r4.getSaveState();
    }

    public final void popUpTo(String r2, l<? super PopUpToBuilder, f0> r3) {
        o.f(r2, "route");
        o.f(r3, "popUpToBuilder");
        setPopUpToRoute(r2);
        setPopUpToId$navigation_common_release(-1);
        PopUpToBuilder r4 = new PopUpToBuilder();
        r3.invoke(r4);
        this.inclusive = r4.getInclusive();
        this.saveState = r4.getSaveState();
    }

    public final void setLaunchSingleTop(boolean r1) {
        this.launchSingleTop = r1;
    }

    public final void setPopUpTo(int r3) {
        popUpTo$default(this, r3, null, 2, null);
    }

    public final void setPopUpToId$navigation_common_release(int r1) {
        this.popUpToId = r1;
        this.inclusive = false;
    }

    public final void setRestoreState(boolean r1) {
        this.restoreState = r1;
    }
}
