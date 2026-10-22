package androidx.navigation;

import androidx.annotation.AnimRes;
import androidx.annotation.AnimatorRes;
import androidx.annotation.IdRes;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0019\u0018\u00002\u00020\u0001:\u0001\"BQ\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\n¢\u0006\u0002\u0010\u000eBY\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\b\u0001\u0010\t\u001a\u00020\n\u0012\b\b\u0001\u0010\u000b\u001a\u00020\n\u0012\b\b\u0001\u0010\f\u001a\u00020\n\u0012\b\b\u0001\u0010\r\u001a\u00020\n¢\u0006\u0002\u0010\u0010J\u0013\u0010\u001a\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001c\u001a\u00020\nH\u0007J\b\u0010\u001d\u001a\u00020\nH\u0016J\u0006\u0010\u001e\u001a\u00020\u0003J\u0006\u0010\u001f\u001a\u00020\u0003J\u0006\u0010 \u001a\u00020\u0003J\u0006\u0010!\u001a\u00020\u0003R\u0013\u0010\t\u001a\u00020\n8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u000b\u001a\u00020\n8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0013\u0010\f\u001a\u00020\n8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0013\u0010\r\u001a\u00020\n8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0014\u0010\u000f\u001a\u00020\nX\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0006@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Landroidx/navigation/NavOptions;", "", "singleTop", "", "restoreState", "popUpToRoute", "", "popUpToInclusive", "popUpToSaveState", "enterAnim", "", "exitAnim", "popEnterAnim", "popExitAnim", "(ZZLjava/lang/String;ZZIIII)V", "popUpToId", "(ZZIZZIIII)V", "getEnterAnim", "()I", "getExitAnim", "getPopEnterAnim", "getPopExitAnim", "getPopUpToId", "<set-?>", "getPopUpToRoute", "()Ljava/lang/String;", "equals", "other", "getPopUpTo", "hashCode", "isPopUpToInclusive", "shouldLaunchSingleTop", "shouldPopUpToSaveState", "shouldRestoreState", "Builder", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NavOptions {
    private final int enterAnim;
    private final int exitAnim;
    private final int popEnterAnim;
    private final int popExitAnim;

    @IdRes
    private final int popUpToId;
    private final boolean popUpToInclusive;
    private String popUpToRoute;
    private final boolean popUpToSaveState;
    private final boolean restoreState;
    private final boolean singleTop;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0010\u001a\u00020\u0011J\u0010\u0010\u0012\u001a\u00020\u00002\b\b\u0001\u0010\u0003\u001a\u00020\u0004J\u0010\u0010\u0013\u001a\u00020\u00002\b\b\u0001\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\nJ\u0010\u0010\u0015\u001a\u00020\u00002\b\b\u0001\u0010\u0006\u001a\u00020\u0004J\u0010\u0010\u0016\u001a\u00020\u00002\b\b\u0001\u0010\u0007\u001a\u00020\u0004J$\u0010\u0017\u001a\u00020\u00002\b\b\u0001\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\n2\b\b\u0002\u0010\u001a\u001a\u00020\nH\u0007J$\u0010\u0017\u001a\u00020\u00002\b\u0010\u001b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0019\u001a\u00020\n2\b\b\u0002\u0010\u001a\u001a\u00020\nH\u0007J\u000e\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\nR\u0012\u0010\u0003\u001a\u00020\u00048\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00048\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00048\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00048\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Landroidx/navigation/NavOptions$Builder;", "", "()V", "enterAnim", "", "exitAnim", "popEnterAnim", "popExitAnim", "popUpToId", "popUpToInclusive", "", "popUpToRoute", "", "popUpToSaveState", "restoreState", "singleTop", "build", "Landroidx/navigation/NavOptions;", "setEnterAnim", "setExitAnim", "setLaunchSingleTop", "setPopEnterAnim", "setPopExitAnim", "setPopUpTo", "destinationId", "inclusive", "saveState", "route", "setRestoreState", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Builder {

        @AnimRes
        @AnimatorRes
        private int enterAnim;

        @AnimRes
        @AnimatorRes
        private int exitAnim;

        @AnimRes
        @AnimatorRes
        private int popEnterAnim;

        @AnimRes
        @AnimatorRes
        private int popExitAnim;

        @IdRes
        private int popUpToId;
        private boolean popUpToInclusive;
        private String popUpToRoute;
        private boolean popUpToSaveState;
        private boolean restoreState;
        private boolean singleTop;

        public Builder() {
            this.popUpToId = -1;
            this.enterAnim = -1;
            this.exitAnim = -1;
            this.popEnterAnim = -1;
            this.popExitAnim = -1;
        }

        public static /* synthetic */ Builder setPopUpTo$default(Builder r0, int r1, boolean r2, boolean r3, int r4, Object r5) {
            if ((r4 & 4) == 0) goto L6;
            r3 = false;
        L6:
            return r0.setPopUpTo(r1, r2, r3);
        }

        public static /* synthetic */ Builder setPopUpTo$default(Builder r0, String r1, boolean r2, boolean r3, int r4, Object r5) {
            if ((r4 & 4) == 0) goto L6;
            r3 = false;
        L6:
            return r0.setPopUpTo(r1, r2, r3);
        }

        public final NavOptions build() {
            String r3 = this.popUpToRoute;
            if (r3 == null) goto L5;
            NavOptions r10 = new NavOptions(this.singleTop, this.restoreState, r3, this.popUpToInclusive, this.popUpToSaveState, this.enterAnim, this.exitAnim, this.popEnterAnim, this.popExitAnim);
        L6:
            return r10;
        L5:
            r10 = new NavOptions(this.singleTop, this.restoreState, this.popUpToId, this.popUpToInclusive, this.popUpToSaveState, this.enterAnim, this.exitAnim, this.popEnterAnim, this.popExitAnim);
            goto L6
        }

        public final Builder setEnterAnim(@AnimRes @AnimatorRes int r1) {
            this.enterAnim = r1;
            return this;
        }

        public final Builder setExitAnim(@AnimRes @AnimatorRes int r1) {
            this.exitAnim = r1;
            return this;
        }

        public final Builder setLaunchSingleTop(boolean r1) {
            this.singleTop = r1;
            return this;
        }

        public final Builder setPopEnterAnim(@AnimRes @AnimatorRes int r1) {
            this.popEnterAnim = r1;
            return this;
        }

        public final Builder setPopExitAnim(@AnimRes @AnimatorRes int r1) {
            this.popExitAnim = r1;
            return this;
        }

        public final Builder setPopUpTo(@IdRes int r7, boolean r8) {
            return setPopUpTo$default(this, r7, r8, false, 4, null);
        }

        public final Builder setPopUpTo(@IdRes int r1, boolean r2, boolean r3) {
            this.popUpToId = r1;
            this.popUpToRoute = null;
            this.popUpToInclusive = r2;
            this.popUpToSaveState = r3;
            return this;
        }

        public final Builder setPopUpTo(String r7, boolean r8) {
            return setPopUpTo$default(this, r7, r8, false, 4, null);
        }

        public final Builder setPopUpTo(String r1, boolean r2, boolean r3) {
            this.popUpToRoute = r1;
            this.popUpToId = -1;
            this.popUpToInclusive = r2;
            this.popUpToSaveState = r3;
            return this;
        }

        public final Builder setRestoreState(boolean r1) {
            this.restoreState = r1;
            return this;
        }
    }

    public NavOptions(boolean r1, boolean r2, @IdRes int r3, boolean r4, boolean r5, @AnimRes @AnimatorRes int r6, @AnimRes @AnimatorRes int r7, @AnimRes @AnimatorRes int r8, @AnimRes @AnimatorRes int r9) {
        this.singleTop = r1;
        this.restoreState = r2;
        this.popUpToId = r3;
        this.popUpToInclusive = r4;
        this.popUpToSaveState = r5;
        this.enterAnim = r6;
        this.exitAnim = r7;
        this.popEnterAnim = r8;
        this.popExitAnim = r9;
    }

    public NavOptions(boolean r13, boolean r14, String r15, boolean r16, boolean r17, int r18, int r19, int r20, int r21) {
        this(r13, r14, NavDestination.Companion.createRoute(r15).hashCode(), r16, r17, r18, r19, r20, r21);
        this.popUpToRoute = r15;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L33:
        return false;
    L8:
        if (o.a(NavOptions.class, r5.getClass()) == false) goto L33;
        NavOptions r6 = (NavOptions) r5;
        if (this.singleTop != r6.singleTop) goto L32;
        if (this.restoreState != r6.restoreState) goto L32;
        if (this.popUpToId != r6.popUpToId) goto L32;
        if (o.a(this.popUpToRoute, r6.popUpToRoute) == false) goto L32;
        if (this.popUpToInclusive != r6.popUpToInclusive) goto L32;
        if (this.popUpToSaveState != r6.popUpToSaveState) goto L32;
        if (this.enterAnim != r6.enterAnim) goto L32;
        if (this.exitAnim != r6.exitAnim) goto L32;
        if (this.popEnterAnim != r6.popEnterAnim) goto L32;
        if (this.popExitAnim != r6.popExitAnim) goto L32;
        return true;
    L32:
        return false;
    }

    @AnimRes
    @AnimatorRes
    public final int getEnterAnim() {
        return this.enterAnim;
    }

    @AnimRes
    @AnimatorRes
    public final int getExitAnim() {
        return this.exitAnim;
    }

    @AnimRes
    @AnimatorRes
    public final int getPopEnterAnim() {
        return this.popEnterAnim;
    }

    @AnimRes
    @AnimatorRes
    public final int getPopExitAnim() {
        return this.popExitAnim;
    }

    @IdRes
    public final int getPopUpTo() {
        return this.popUpToId;
    }

    @IdRes
    public final int getPopUpToId() {
        return this.popUpToId;
    }

    public final String getPopUpToRoute() {
        return this.popUpToRoute;
    }

    public int hashCode() {
        int r0 = (((((shouldLaunchSingleTop() ? 1 : 0) * 31) + (shouldRestoreState() ? 1 : 0)) * 31) + this.popUpToId) * 31;
        String r1 = this.popUpToRoute;
        if (r1 == null) goto L5;
        int r2 = r1.hashCode();
    L7:
        return ((((((((((((r0 + r2) * 31) + (isPopUpToInclusive() ? 1 : 0)) * 31) + (shouldPopUpToSaveState() ? 1 : 0)) * 31) + this.enterAnim) * 31) + this.exitAnim) * 31) + this.popEnterAnim) * 31) + this.popExitAnim;
    L5:
        r2 = 0;
        goto L7
    }

    public final boolean isPopUpToInclusive() {
        return this.popUpToInclusive;
    }

    public final boolean shouldLaunchSingleTop() {
        return this.singleTop;
    }

    public final boolean shouldPopUpToSaveState() {
        return this.popUpToSaveState;
    }

    public final boolean shouldRestoreState() {
        return this.restoreState;
    }
}
