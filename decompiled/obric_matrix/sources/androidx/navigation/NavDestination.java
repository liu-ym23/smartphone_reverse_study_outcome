package androidx.navigation;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import androidx.annotation.CallSuper;
import androidx.annotation.IdRes;
import androidx.annotation.RestrictTo;
import androidx.collection.SparseArrayCompat;
import androidx.collection.SparseArrayKt;
import com.bytedance.boost_multidex.Constants;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.i0.m0;
import kotlin.i0.r;
import kotlin.n0.d.g;
import kotlin.n0.d.j0;
import kotlin.n0.d.o;
import kotlin.t0.h;
import kotlin.t0.k;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0016\u0018\u0000 X2\u00020\u0001:\u0003WXYB\u0017\b\u0016\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00000\u0003¢\u0006\u0002\u0010\u0004B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0016\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u00062\u0006\u00103\u001a\u00020\nJ\u000e\u00104\u001a\u0002012\u0006\u00105\u001a\u00020\u0014J\u000e\u00104\u001a\u0002012\u0006\u00106\u001a\u00020\u0006J\u0014\u00107\u001a\u0004\u0018\u0001082\b\u00109\u001a\u0004\u0018\u000108H\u0007J\u0014\u0010:\u001a\u00020;2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u0000H\u0007J\u0013\u0010=\u001a\u00020>2\b\u0010?\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0012\u0010@\u001a\u0004\u0018\u00010\r2\b\b\u0001\u0010\u0018\u001a\u00020\u0019J\u0010\u0010A\u001a\u00020>2\u0006\u0010B\u001a\u00020CH\u0016J\u0010\u0010A\u001a\u00020>2\u0006\u0010D\u001a\u00020EH\u0016J\b\u0010F\u001a\u00020\u0019H\u0016J\u0012\u0010G\u001a\u0004\u0018\u00010H2\u0006\u0010I\u001a\u00020EH\u0017J\u0018\u0010J\u001a\u0002012\u0006\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020NH\u0017J\u0018\u0010O\u001a\u0002012\b\b\u0001\u0010P\u001a\u00020\u00192\u0006\u0010Q\u001a\u00020\rJ\u001a\u0010O\u001a\u0002012\b\b\u0001\u0010P\u001a\u00020\u00192\b\b\u0001\u0010R\u001a\u00020\u0019J\u0010\u0010S\u001a\u0002012\b\b\u0001\u0010P\u001a\u00020\u0019J\u000e\u0010T\u001a\u0002012\u0006\u00102\u001a\u00020\u0006J\b\u0010U\u001a\u00020>H\u0017J\b\u0010V\u001a\u00020\u0006H\u0016R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u00020\u00068WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R(\u0010\u0018\u001a\u00020\u00192\b\b\u0001\u0010\u0018\u001a\u00020\u00198G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0017R(\u0010(\u001a\u0004\u0018\u00010'2\b\u0010&\u001a\u0004\u0018\u00010'@GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R(\u0010-\u001a\u0004\u0018\u00010\u00062\b\u0010-\u001a\u0004\u0018\u00010\u0006@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0017\"\u0004\b/\u0010\u0007¨\u0006Z"}, d2 = {"Landroidx/navigation/NavDestination;", "", "navigator", "Landroidx/navigation/Navigator;", "(Landroidx/navigation/Navigator;)V", "navigatorName", "", "(Ljava/lang/String;)V", "_arguments", "", "Landroidx/navigation/NavArgument;", "actions", "Landroidx/collection/SparseArrayCompat;", "Landroidx/navigation/NavAction;", "arguments", "", "getArguments", "()Ljava/util/Map;", "deepLinks", "", "Landroidx/navigation/NavDeepLink;", "displayName", "getDisplayName", "()Ljava/lang/String;", "id", "", "getId", "()I", "setId", "(I)V", "idName", "label", "", "getLabel", "()Ljava/lang/CharSequence;", "setLabel", "(Ljava/lang/CharSequence;)V", "getNavigatorName", "<set-?>", "Landroidx/navigation/NavGraph;", "parent", "getParent", "()Landroidx/navigation/NavGraph;", "setParent", "(Landroidx/navigation/NavGraph;)V", "route", "getRoute", "setRoute", "addArgument", "", "argumentName", "argument", "addDeepLink", "navDeepLink", "uriPattern", "addInDefaultArgs", "Landroid/os/Bundle;", "args", "buildDeepLinkIds", "", "previousDestination", "equals", "", "other", "getAction", "hasDeepLink", "deepLink", "Landroid/net/Uri;", "deepLinkRequest", "Landroidx/navigation/NavDeepLinkRequest;", "hashCode", "matchDeepLink", "Landroidx/navigation/NavDestination$DeepLinkMatch;", "navDeepLinkRequest", "onInflate", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "putAction", "actionId", "action", "destId", "removeAction", "removeArgument", "supportsActions", "toString", "ClassType", "Companion", "DeepLinkMatch", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class NavDestination {
    public static final Companion Companion = null;
    private static final Map<String, Class<?>> classes = null;
    private Map<String, NavArgument> _arguments;
    private final SparseArrayCompat<NavAction> actions;
    private final List<NavDeepLink> deepLinks;
    private int id;
    private String idName;
    private CharSequence label;
    private final String navigatorName;
    private NavGraph parent;
    private String route;

    @Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\u0002\u0018\u00002\u00020\u0001B\f\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003R\u0013\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Landroidx/navigation/NavDestination$ClassType;", "", "value", "Lkotlin/reflect/KClass;", "()Ljava/lang/Class;", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Retention(RetentionPolicy.CLASS)
    public @interface ClassType {
        Class<?> value();
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u0007J\u0018\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J:\u0010\u0015\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u0001H\u00160\u0006\"\u0004\b\u0000\u0010\u00162\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00052\u0010\u0010\u0018\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u0001H\u00160\u0006H\u0005J:\u0010\u0019\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u0001H\u00160\u0006\"\u0004\b\u0000\u0010\u00162\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00052\u0010\u0010\u0018\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u0001H\u00160\u0006H\u0007R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b*\u00020\t8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u001a"}, d2 = {"Landroidx/navigation/NavDestination$Companion;", "", "()V", Constants.DEX_PREFIX, "", "", "Ljava/lang/Class;", "hierarchy", "Lkotlin/sequences/Sequence;", "Landroidx/navigation/NavDestination;", "getHierarchy$annotations", "(Landroidx/navigation/NavDestination;)V", "getHierarchy", "(Landroidx/navigation/NavDestination;)Lkotlin/sequences/Sequence;", "createRoute", "route", "getDisplayName", "context", "Landroid/content/Context;", "id", "", "parseClassFromName", "C", "name", "expectedClassType", "parseClassFromNameInternal", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g r1) {
            this();
        }

        public static /* synthetic */ void getHierarchy$annotations(NavDestination r0) {
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public final String createRoute(String r2) {
            if (r2 != null) goto L6;
            return "";
        L6:
            return "android-app://androidx.navigation/" + r2;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public final String getDisplayName(Context r1, int r2) {
            o.f(r1, "context");
            if (r2 <= 16777215) goto L12;
            String r0 = r1.getResources().getResourceName(r2);     // Catch: Resources.NotFoundException -> L7
        L8:
            o.e(r0, "try {\n                co….toString()\n            }");
            return r0;
        L7:
            r0 = String.valueOf(r2);
            goto L8
        L12:
            return String.valueOf(r2);
        }

        public final h<NavDestination> getHierarchy(NavDestination r1) {
            o.f(r1, "<this>");
            return k.h(r1, NavDestination$Companion$hierarchy$1.INSTANCE);
        }

        protected final <C> Class<? extends C> parseClassFromName(Context r2, String r3, Class<? extends C> r4) {
            o.f(r2, "context");
            o.f(r3, "name");
            o.f(r4, "expectedClassType");
            if (r3.charAt(0) != '.') goto L5;
            String r1 = r2.getPackageName() + r3;
        L6:
            Class<? extends C> r0 = (Class) NavDestination.access$getClasses$cp().get(r1);
            if (r0 == null) goto L19;
        L14:
            o.c(r0);
            if (r4.isAssignableFrom(r0) == false) goto L18;
            return r0;
        L18:
            throw new IllegalArgumentException((r1 + " must be a subclass of " + r4).toString());
        L19:
            r0 = (Class<? extends C>) Class.forName(r1, true, r2.getClassLoader());
            NavDestination.access$getClasses$cp().put(r3, r0);     // Catch: ClassNotFoundException -> L11
        L11:
            e = move-exception;
            throw new IllegalArgumentException(e);
        L5:
            r1 = r3;
            goto L6
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public final <C> Class<? extends C> parseClassFromNameInternal(Context r1, String r2, Class<? extends C> r3) {
            o.f(r1, "context");
            o.f(r2, "name");
            o.f(r3, "expectedClassType");
            return NavDestination.parseClassFromName(r1, r2, r3);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0011\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0000H\u0096\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Landroidx/navigation/NavDestination$DeepLinkMatch;", "", "destination", "Landroidx/navigation/NavDestination;", "matchingArgs", "Landroid/os/Bundle;", "isExactDeepLink", "", "hasMatchingAction", "mimeTypeMatchLevel", "", "(Landroidx/navigation/NavDestination;Landroid/os/Bundle;ZZI)V", "getDestination", "()Landroidx/navigation/NavDestination;", "getMatchingArgs", "()Landroid/os/Bundle;", "compareTo", "other", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final class DeepLinkMatch implements Comparable<DeepLinkMatch> {
        private final NavDestination destination;
        private final boolean hasMatchingAction;
        private final boolean isExactDeepLink;
        private final Bundle matchingArgs;
        private final int mimeTypeMatchLevel;

        public DeepLinkMatch(NavDestination r2, Bundle r3, boolean r4, boolean r5, int r6) {
            o.f(r2, "destination");
            this.destination = r2;
            this.matchingArgs = r3;
            this.isExactDeepLink = r4;
            this.hasMatchingAction = r5;
            this.mimeTypeMatchLevel = r6;
        }

        /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
        public int compareTo2(DeepLinkMatch r5) {
            o.f(r5, "other");
            boolean r0 = this.isExactDeepLink;
            if (r0 == false) goto L8;
            if (r5.isExactDeepLink == true) goto L8;
            return 1;
        L8:
            if (r0 == false) goto L10;
        L12:
            Bundle r1 = this.matchingArgs;
            if (r1 != null) goto L15;
        L17:
            if (r1 == null) goto L19;
        L21:
            if (r1 == null) goto L27;
            int r2 = r1.size();
            Bundle r3 = r5.matchingArgs;
            o.c(r3);
            int r4 = r2 - r3.size();
            if (r4 <= 0) goto L25;
            return 1;
        L25:
            if (r4 >= 0) goto L27;
            return -1;
        L27:
            boolean r6 = this.hasMatchingAction;
            if (r6 == true) goto L30;
        L32:
            if (r6 == true) goto L37;
            if (r5.hasMatchingAction == false) goto L37;
            return -1;
        L37:
            return this.mimeTypeMatchLevel - r5.mimeTypeMatchLevel;
        L30:
            if (r5.hasMatchingAction == true) goto L32;
            return 1;
        L19:
            if (r5.matchingArgs == null) goto L21;
            return -1;
        L15:
            if (r5.matchingArgs != null) goto L17;
            return 1;
        L10:
            if (r5.isExactDeepLink == false) goto L12;
            return -1;
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(DeepLinkMatch r1) {
            return compareTo2(r1);
        }

        public final NavDestination getDestination() {
            return this.destination;
        }

        public final Bundle getMatchingArgs() {
            return this.matchingArgs;
        }
    }

    static {
        Companion = new Companion(null);
        classes = new LinkedHashMap();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public NavDestination(Navigator<? extends NavDestination> r2) {
        o.f(r2, "navigator");
        this(NavigatorProvider.Companion.getNameForNavigator$navigation_common_release(r2.getClass()));
    }

    public NavDestination(String r2) {
        o.f(r2, "navigatorName");
        this.navigatorName = r2;
        this.deepLinks = new ArrayList();
        this.actions = new SparseArrayCompat();
        this._arguments = new LinkedHashMap();
    }

    public static final /* synthetic */ Map access$getClasses$cp() {
        return classes;
    }

    public static /* synthetic */ int[] buildDeepLinkIds$default(NavDestination r0, NavDestination r1, int r2, Object r3) {
        if (r3 != null) goto L9;
        if ((r2 & 1) == 0) goto L7;
        r1 = null;
    L7:
        return r0.buildDeepLinkIds(r1);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: buildDeepLinkIds");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final String getDisplayName(Context r1, int r2) {
        return Companion.getDisplayName(r1, r2);
    }

    public static final h<NavDestination> getHierarchy(NavDestination r1) {
        return Companion.getHierarchy(r1);
    }

    protected static final <C> Class<? extends C> parseClassFromName(Context r1, String r2, Class<? extends C> r3) {
        return Companion.parseClassFromName(r1, r2, r3);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final <C> Class<? extends C> parseClassFromNameInternal(Context r1, String r2, Class<? extends C> r3) {
        return Companion.parseClassFromNameInternal(r1, r2, r3);
    }

    public final void addArgument(String r2, NavArgument r3) {
        o.f(r2, "argumentName");
        o.f(r3, "argument");
        this._arguments.put(r2, r3);
    }

    public final void addDeepLink(NavDeepLink r7) {
        o.f(r7, "navDeepLink");
        Map<String, NavArgument> r0 = getArguments();
        LinkedHashMap r1 = new LinkedHashMap();
        Iterator<Map.Entry<String, NavArgument>> r2 = r0.entrySet().iterator();
    L3:
        boolean r3 = true;
        if (r2.hasNext() == false) goto L13;
        Map.Entry<String, NavArgument> r4 = r2.next();
        NavArgument r5 = r4.getValue();
        if (r5.isNullable() == false) goto L8;
    L10:
        r3 = false;
    L11:
        if (r3 == false) goto L3;
        r1.put(r4.getKey(), r4.getValue());
        goto L3
    L8:
        if (r5.isDefaultValuePresent() == true) goto L10;
    L13:
        Set r6 = r1.keySet();
        ArrayList r8 = new ArrayList();
        Iterator r9 = r6.iterator();
    L15:
        if (r9.hasNext() == false) goto L20;
        Object r10 = r9.next();
        if ((!r7.getArgumentsNames$navigation_common_release().contains((String) r10)) == false) goto L15;
        r8.add(r10);
        goto L15
    L20:
        if (r8.isEmpty() == false) goto L24;
        this.deepLinks.add(r7);
        return;
    L24:
        throw new IllegalArgumentException(("Deep link " + r7.getUriPattern() + " can't be used to open destination " + this + ".\nFollowing required arguments are missing: " + r8).toString());
    }

    public final void addDeepLink(String r2) {
        o.f(r2, "uriPattern");
        addDeepLink(new NavDeepLink.Builder().setUriPattern(r2).build());
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final Bundle addInDefaultArgs(Bundle r5) {
        if (r5 != null) goto L13;
        Map<String, NavArgument> r0 = this._arguments;
        if (r0 != null) goto L6;
    L9:
        boolean r1 = true;
    L10:
        if (r1 == false) goto L13;
        return null;
    L6:
        if (r0.isEmpty() == true) goto L9;
        r1 = false;
    L13:
        Bundle r2 = new Bundle();
        Iterator<Map.Entry<String, NavArgument>> r3 = this._arguments.entrySet().iterator();
    L15:
        if (r3.hasNext() == false) goto L17;
        Map.Entry<String, NavArgument> r4 = r3.next();
        r4.getValue().putDefaultValue(r4.getKey(), r2);
        goto L15
    L17:
        if (r5 == null) goto L26;
        r2.putAll(r5);
        Iterator<Map.Entry<String, NavArgument>> r6 = this._arguments.entrySet().iterator();
    L20:
        if (r6.hasNext() == false) goto L26;
        Map.Entry<String, NavArgument> r7 = r6.next();
        String r8 = r7.getKey();
        NavArgument r9 = r7.getValue();
        if (r9.verify(r8, r2) == true) goto L20;
        throw new IllegalArgumentException(("Wrong argument type for '" + r8 + "' in argument bundle. " + r9.getType().getName() + " expected.").toString());
    L26:
        return r2;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final int[] buildDeepLinkIds() {
        return buildDeepLinkIds$default(this, null, 1, null);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final int[] buildDeepLinkIds(NavDestination r5) {
        kotlin.i0.h r0 = new kotlin.i0.h();
    L3:
        o.c(this);
        NavGraph r1 = this.parent;
        if (r5 == null) goto L6;
        NavGraph r2 = r5.parent;
    L7:
        if (r2 == null) goto L11;
        NavGraph r3 = r5.parent;
        o.c(r3);
        if (r3.findNode(this.id) != this) goto L11;
        r0.addFirst(this);
    L19:
        List r4 = r.z0(r0);
        ArrayList r6 = new ArrayList(r.q(r4, 10));
        Iterator r7 = r4.iterator();
    L21:
        if (r7.hasNext() == false) goto L24;
        r6.add(Integer.valueOf(((NavDestination) r7.next()).id));
        goto L21
    L24:
        return r.y0(r6);
    L11:
        if (r1 != null) goto L13;
    L14:
        r0.addFirst(this);
    L16:
        if (o.a(r1, r5) == true) goto L19;
        if (r1 == null) goto L19;
        NavDestination this = r1;
        goto L3
    L13:
        if (r1.getStartDestinationId() == this.id) goto L16;
    L6:
        r2 = null;
        goto L7
    }

    public boolean equals(Object r9) {
        if (r9 != null) goto L5;
        return false;
    L5:
        if ((r9 instanceof NavDestination) == false) goto L92;
        NavDestination r10 = (NavDestination) r9;
        if (r.V(this.deepLinks, r10.deepLinks).size() != this.deepLinks.size()) goto L10;
        boolean r1 = true;
    L12:
        if (this.actions.size() != r10.actions.size()) goto L30;
        Iterator r2 = k.c(SparseArrayKt.valueIterator(this.actions)).iterator();
    L15:
        if (r2.hasNext() == false) goto L19;
        if (r10.actions.containsValue((NavAction) r2.next()) == true) goto L15;
        boolean r3 = false;
    L20:
        if (r3 == false) goto L30;
        Iterator r4 = k.c(SparseArrayKt.valueIterator(r10.actions)).iterator();
    L23:
        if (r4.hasNext() == false) goto L27;
        if (this.actions.containsValue((NavAction) r4.next()) == true) goto L23;
        boolean r5 = false;
    L28:
        if (r5 == false) goto L30;
        boolean r6 = true;
    L32:
        if (getArguments().size() != r10.getArguments().size()) goto L60;
        Iterator r7 = m0.v(getArguments()).iterator();
    L35:
        if (r7.hasNext() == false) goto L44;
        Map.Entry r8 = (Map.Entry) r7.next();
        if (r10.getArguments().containsKey(r8.getKey()) == true) goto L39;
    L41:
        boolean r11 = false;
    L42:
        if (r11 == true) goto L35;
        boolean r12 = false;
    L45:
        if (r12 == false) goto L60;
        Iterator r13 = m0.v(r10.getArguments()).iterator();
    L48:
        if (r13.hasNext() == false) goto L57;
        Map.Entry r14 = (Map.Entry) r13.next();
        if (getArguments().containsKey(r14.getKey()) == true) goto L52;
    L54:
        boolean r15 = false;
    L55:
        if (r15 == true) goto L48;
        boolean r16 = false;
    L58:
        if (r16 == false) goto L60;
        boolean r17 = true;
    L62:
        if (this.id == r10.id) goto L64;
        return false;
    L64:
        if (o.a(this.route, r10.route) == false) goto L88;
        if (r1 == false) goto L89;
        if (r6 == false) goto L90;
        if (r17 == true) goto L69;
        return false;
    L69:
        return true;
    L90:
        return false;
    L89:
        return false;
    L88:
        return false;
    L52:
        if (o.a(getArguments().get(r14.getKey()), r14.getValue()) == false) goto L54;
        r15 = true;
        goto L55
    L57:
        r16 = true;
        goto L58
    L39:
        if (o.a(r10.getArguments().get(r8.getKey()), r8.getValue()) == false) goto L41;
        r11 = true;
        goto L42
    L44:
        r12 = true;
    L60:
        r17 = false;
        goto L62
    L27:
        r5 = true;
        goto L28
    L19:
        r3 = true;
    L30:
        r6 = false;
        goto L32
    L10:
        r1 = false;
        goto L12
    L92:
        return false;
    }

    public final NavAction getAction(@IdRes int r3) {
        if (this.actions.isEmpty() == false) goto L5;
        NavAction r0 = null;
    L6:
        if (r0 != null) goto L11;
        NavGraph r2 = this.parent;
        if (r2 != null) goto L13;
        return null;
    L13:
        return r2.getAction(r3);
    L11:
        return r0;
    L5:
        r0 = this.actions.get(r3);
        goto L6
    }

    public final Map<String, NavArgument> getArguments() {
        return m0.s(this._arguments);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public String getDisplayName() {
        String r0 = this.idName;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return String.valueOf(this.id);
    }

    @IdRes
    public final int getId() {
        return this.id;
    }

    public final CharSequence getLabel() {
        return this.label;
    }

    public final String getNavigatorName() {
        return this.navigatorName;
    }

    public final NavGraph getParent() {
        return this.parent;
    }

    public final String getRoute() {
        return this.route;
    }

    public boolean hasDeepLink(Uri r3) {
        o.f(r3, "deepLink");
        return hasDeepLink(new NavDeepLinkRequest(r3, null, null));
    }

    public boolean hasDeepLink(NavDeepLinkRequest r2) {
        o.f(r2, "deepLinkRequest");
        if (matchDeepLink(r2) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public int hashCode() {
        int r0 = this.id * 31;
        String r1 = this.route;
        if (r1 == null) goto L5;
        int r2 = r1.hashCode();
    L6:
        int r3 = r0 + r2;
        Iterator<T> r4 = this.deepLinks.iterator();
    L8:
        if (r4.hasNext() == false) goto L22;
        NavDeepLink r5 = (NavDeepLink) r4.next();
        int r6 = r3 * 31;
        String r7 = r5.getUriPattern();
        if (r7 == null) goto L12;
        int r8 = r7.hashCode();
    L13:
        int r9 = (r6 + r8) * 31;
        String r10 = r5.getAction();
        if (r10 == null) goto L16;
        int r11 = r10.hashCode();
    L17:
        int r12 = (r9 + r11) * 31;
        String r13 = r5.getMimeType();
        if (r13 == null) goto L20;
        int r14 = r13.hashCode();
    L21:
        r3 = r12 + r14;
        goto L8
    L20:
        r14 = 0;
        goto L21
    L16:
        r11 = 0;
        goto L17
    L12:
        r8 = 0;
        goto L13
    L22:
        Iterator r15 = SparseArrayKt.valueIterator(this.actions);
    L24:
        if (r15.hasNext() == false) goto L41;
        NavAction r16 = (NavAction) r15.next();
        int r17 = ((r3 * 31) + r16.getDestinationId()) * 31;
        NavOptions r18 = r16.getNavOptions();
        if (r18 == null) goto L28;
        int r19 = r18.hashCode();
    L29:
        r3 = r17 + r19;
        Bundle r20 = r16.getDefaultArguments();
        if (r20 == null) goto L24;
        Set<String> r21 = r20.keySet();
        if (r21 == null) goto L24;
        o.e(r21, "keySet()");
        Iterator<T> r22 = r21.iterator();
    L35:
        if (r22.hasNext() == false) goto L24;
        String r23 = (String) r22.next();
        int r24 = r3 * 31;
        Bundle r25 = r16.getDefaultArguments();
        o.c(r25);
        Object r26 = r25.get(r23);
        if (r26 == null) goto L39;
        int r27 = r26.hashCode();
    L40:
        r3 = r24 + r27;
        goto L35
    L39:
        r27 = 0;
        goto L40
    L28:
        r19 = 0;
        goto L29
    L41:
        Iterator<T> r28 = getArguments().keySet().iterator();
    L43:
        if (r28.hasNext() == false) goto L49;
        String r29 = (String) r28.next();
        int r30 = ((r3 * 31) + r29.hashCode()) * 31;
        NavArgument r31 = getArguments().get(r29);
        if (r31 == null) goto L47;
        int r32 = r31.hashCode();
    L48:
        r3 = r30 + r32;
        goto L43
    L47:
        r32 = 0;
        goto L48
    L49:
        return r3;
    L5:
        r2 = 0;
        goto L6
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public DeepLinkMatch matchDeepLink(NavDeepLinkRequest r12) {
        o.f(r12, "navDeepLinkRequest");
        if (this.deepLinks.isEmpty() == false) goto L5;
        return null;
    L5:
        Iterator<NavDeepLink> r0 = this.deepLinks.iterator();
        DeepLinkMatch r2 = null;
    L7:
        if (r0.hasNext() == false) goto L30;
        NavDeepLink r3 = r0.next();
        Uri r4 = r12.getUri();
        if (r4 == null) goto L11;
        Bundle r7 = r3.getMatchingArguments(r4, getArguments());
    L12:
        String r5 = r12.getAction();
        if (r5 != null) goto L15;
    L17:
        boolean r6 = false;
    L18:
        boolean r9 = r6;
        String r8 = r12.getMimeType();
        if (r8 == null) goto L21;
        int r10 = r3.getMimeTypeMatchRating(r8);
    L22:
        if (r7 != null) goto L25;
        if (r9 == true) goto L25;
        if (r10 <= (-1)) goto L7;
    L25:
        DeepLinkMatch r11 = new DeepLinkMatch(this, r7, r3.isExactDeepLink(), r9, r10);
        if (r2 == null) goto L29;
        if (r11.compareTo2(r2) <= 0) goto L7;
    L29:
        r2 = r11;
        goto L7
    L21:
        r10 = -1;
        goto L22
    L15:
        if (o.a(r5, r3.getAction()) == false) goto L17;
        r6 = true;
        goto L18
    L11:
        r7 = null;
        goto L12
    L30:
        return r2;
    }

    @CallSuper
    public void onInflate(Context r3, AttributeSet r4) {
        o.f(r3, "context");
        o.f(r4, "attrs");
        TypedArray r5 = r3.getResources().obtainAttributes(r4, androidx.navigation.common.R.styleable.Navigator);
        o.e(r5, "context.resources.obtain…s, R.styleable.Navigator)");
        setRoute(r5.getString(androidx.navigation.common.R.styleable.Navigator_route));
        int r0 = androidx.navigation.common.R.styleable.Navigator_android_id;
        if (r5.hasValue(r0) == false) goto L5;
        setId(r5.getResourceId(r0, 0));
        this.idName = Companion.getDisplayName(r3, this.id);
    L5:
        this.label = r5.getText(androidx.navigation.common.R.styleable.Navigator_android_label);
        f0 r2 = f0.f18324a;
        r5.recycle();
    }

    public final void putAction(@IdRes int r8, @IdRes int r9) {
        putAction(r8, new NavAction(r9, null, null, 6, null));
    }

    public final void putAction(@IdRes int r3, NavAction r4) {
        o.f(r4, "action");
        if (supportsActions() == false) goto L13;
        if (r3 == 0) goto L6;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L11;
        this.actions.put(r3, r4);
        return;
    L11:
        throw new IllegalArgumentException("Cannot have an action with actionId 0".toString());
    L6:
        r0 = false;
        goto L7
    L13:
        throw new UnsupportedOperationException("Cannot add action " + r3 + " to " + this + " as it does not support actions, indicating that it is a terminal destination in your navigation graph and will never trigger actions.");
    }

    public final void removeAction(@IdRes int r1) {
        this.actions.remove(r1);
    }

    public final void removeArgument(String r2) {
        o.f(r2, "argumentName");
        this._arguments.remove(r2);
    }

    public final void setId(@IdRes int r1) {
        this.id = r1;
        this.idName = null;
    }

    public final void setLabel(CharSequence r1) {
        this.label = r1;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void setParent(NavGraph r1) {
        this.parent = r1;
    }

    public final void setRoute(String r7) {
        if (r7 != null) goto L5;
        setId(0);
    L7:
        List<NavDeepLink> r0 = this.deepLinks;
        Iterator<T> r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L13;
        Object r2 = r1.next();
        if (o.a(((NavDeepLink) r2).getUriPattern(), Companion.createRoute(this.route)) == false) goto L9;
    L14:
        j0.a(r0).remove(r2);
        this.route = r7;
        return;
    L13:
        r2 = null;
        goto L14
    L5:
        if ((!kotlin.u0.k.q(r7)) == false) goto L17;
        String r3 = Companion.createRoute(r7);
        setId(r3.hashCode());
        addDeepLink(r3);
        goto L7
    L17:
        throw new IllegalArgumentException("Cannot have an empty route".toString());
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean supportsActions() {
        return true;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append(getClass().getSimpleName());
        r0.append("(");
        String r1 = this.idName;
        if (r1 != null) goto L5;
        r0.append("0x");
        r1 = Integer.toHexString(this.id);
    L5:
        r0.append(r1);
        r0.append(")");
        String r2 = this.route;
        if (r2 != null) goto L8;
    L11:
        boolean r3 = true;
    L12:
        if (r3 == true) goto L15;
        r0.append(" route=");
        r0.append(this.route);
    L15:
        if (this.label == null) goto L17;
        r0.append(" label=");
        r0.append(this.label);
    L17:
        String r4 = r0.toString();
        o.e(r4, "sb.toString()");
        return r4;
    L8:
        if (kotlin.u0.k.q(r2) == true) goto L11;
        r3 = false;
        goto L12
    }
}
