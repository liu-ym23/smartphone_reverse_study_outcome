package androidx.navigation;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import androidx.annotation.NavigationRes;
import androidx.annotation.RestrictTo;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.n0.d.g;
import kotlin.n0.d.o;
import kotlin.u0.k;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J(\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0012\u0010\u0007\u001a\u00020\u00112\b\b\u0001\u0010\u000f\u001a\u00020\u0010H\u0007J0\u0010\u0012\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J \u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J(\u0010\u0019\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J(\u0010\u001c\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J \u0010\u001d\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Landroidx/navigation/NavInflater;", "", "context", "Landroid/content/Context;", "navigatorProvider", "Landroidx/navigation/NavigatorProvider;", "(Landroid/content/Context;Landroidx/navigation/NavigatorProvider;)V", "inflate", "Landroidx/navigation/NavDestination;", "res", "Landroid/content/res/Resources;", "parser", "Landroid/content/res/XmlResourceParser;", "attrs", "Landroid/util/AttributeSet;", "graphResId", "", "Landroidx/navigation/NavGraph;", "inflateAction", "", "dest", "inflateArgument", "Landroidx/navigation/NavArgument;", "a", "Landroid/content/res/TypedArray;", "inflateArgumentForBundle", "bundle", "Landroid/os/Bundle;", "inflateArgumentForDestination", "inflateDeepLink", "Companion", "navigation-runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NavInflater {

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final String APPLICATION_ID_PLACEHOLDER = "${applicationId}";
    public static final Companion Companion = null;
    private static final String TAG_ACTION = "action";
    private static final String TAG_ARGUMENT = "argument";
    private static final String TAG_DEEP_LINK = "deepLink";
    private static final String TAG_INCLUDE = "include";
    private static final ThreadLocal<TypedValue> sTmpValue = null;
    private final Context context;
    private final NavigatorProvider navigatorProvider;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JE\u0010\f\u001a\u0006\u0012\u0002\b\u00030\r2\u0006\u0010\u000e\u001a\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\r2\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0012\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\u0013R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Landroidx/navigation/NavInflater$Companion;", "", "()V", "APPLICATION_ID_PLACEHOLDER", "", "TAG_ACTION", "TAG_ARGUMENT", "TAG_DEEP_LINK", "TAG_INCLUDE", "sTmpValue", "Ljava/lang/ThreadLocal;", "Landroid/util/TypedValue;", "checkNavType", "Landroidx/navigation/NavType;", "value", "navType", "expectedNavType", "argType", "foundType", "checkNavType$navigation_runtime_release", "navigation-runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g r1) {
            this();
        }

        public final NavType<?> checkNavType$navigation_runtime_release(TypedValue r1, NavType<?> r2, NavType<?> r3, String r4, String r5) {
            o.f(r1, "value");
            o.f(r3, "expectedNavType");
            o.f(r5, "foundType");
            if (r2 == null) goto L8;
            if (r2 == r3) goto L8;
            throw new XmlPullParserException("Type is " + r4 + " but found " + r5 + ": " + r1.data);
        L8:
            if (r2 == null) goto L10;
            return r2;
        L10:
            return r3;
        }
    }

    static {
        Companion = new Companion(null);
        sTmpValue = new ThreadLocal();
    }

    public NavInflater(Context r2, NavigatorProvider r3) {
        o.f(r2, "context");
        o.f(r3, "navigatorProvider");
        this.context = r2;
        this.navigatorProvider = r3;
    }

    private final NavDestination inflate(Resources r10, XmlResourceParser r11, AttributeSet r12, int r13) {
        NavigatorProvider r0 = this.navigatorProvider;
        String r1 = r11.getName();
        o.e(r1, "parser.name");
        NavDestination r2 = r0.getNavigator(r1).createDestination();
        r2.onInflate(this.context, r12);
        int r8 = r11.getDepth() + 1;
    L3:
        int r3 = r11.next();
        if (r3 == 1) goto L31;
        int r4 = r11.getDepth();
        if (r4 >= r8) goto L10;
        if (r3 == 3) goto L31;
    L10:
        if (r3 != 2) goto L3;
        if (r4 > r8) goto L3;
        String r5 = r11.getName();
        if (o.a(TAG_ARGUMENT, r5) == true) goto L16;
        if (o.a(TAG_DEEP_LINK, r5) == true) goto L19;
        if (o.a(TAG_ACTION, r5) == true) goto L22;
        if (o.a(TAG_INCLUDE, r5) == false) goto L29;
        if ((r2 instanceof NavGraph) == false) goto L29;
        TypedArray r6 = r10.obtainAttributes(r12, R.styleable.NavInclude);
        o.e(r6, "res.obtainAttributes(att…n.R.styleable.NavInclude)");
        ((NavGraph) r2).addDestination(inflate(r6.getResourceId(R.styleable.NavInclude_graph, 0)));
        f0 r7 = f0.f18324a;
        r6.recycle();
    L29:
        if ((r2 instanceof NavGraph) == false) goto L3;
        ((NavGraph) r2).addDestination(inflate(r10, r11, r12, r13));
        goto L3
    L22:
        inflateAction(r10, r2, r12, r11, r13);
        goto L3
    L19:
        inflateDeepLink(r10, r2, r12);
        goto L3
    L16:
        inflateArgumentForDestination(r10, r2, r12, r13);
    L31:
        return r2;
    }

    private final void inflateAction(Resources r11, NavDestination r12, AttributeSet r13, XmlResourceParser r14, int r15) {
        Context r0 = this.context;
        int[] r1 = androidx.navigation.common.R.styleable.NavAction;
        o.e(r1, "NavAction");
        TypedArray r2 = r0.obtainStyledAttributes(r13, r1, 0, 0);
        int r3 = r2.getResourceId(androidx.navigation.common.R.styleable.NavAction_android_id, 0);
        NavAction r4 = new NavAction(r2.getResourceId(androidx.navigation.common.R.styleable.NavAction_destination, 0), null, null, 6, null);
        NavOptions.Builder r5 = new NavOptions.Builder();
        r5.setLaunchSingleTop(r2.getBoolean(androidx.navigation.common.R.styleable.NavAction_launchSingleTop, false));
        r5.setRestoreState(r2.getBoolean(androidx.navigation.common.R.styleable.NavAction_restoreState, false));
        r5.setPopUpTo(r2.getResourceId(androidx.navigation.common.R.styleable.NavAction_popUpTo, -1), r2.getBoolean(androidx.navigation.common.R.styleable.NavAction_popUpToInclusive, false), r2.getBoolean(androidx.navigation.common.R.styleable.NavAction_popUpToSaveState, false));
        r5.setEnterAnim(r2.getResourceId(androidx.navigation.common.R.styleable.NavAction_enterAnim, -1));
        r5.setExitAnim(r2.getResourceId(androidx.navigation.common.R.styleable.NavAction_exitAnim, -1));
        r5.setPopEnterAnim(r2.getResourceId(androidx.navigation.common.R.styleable.NavAction_popEnterAnim, -1));
        r5.setPopExitAnim(r2.getResourceId(androidx.navigation.common.R.styleable.NavAction_popExitAnim, -1));
        r4.setNavOptions(r5.build());
        Bundle r6 = new Bundle();
        int r7 = r14.getDepth() + 1;
    L3:
        int r8 = r14.next();
        if (r8 == 1) goto L18;
        int r9 = r14.getDepth();
        if (r9 >= r7) goto L10;
        if (r8 == 3) goto L18;
    L10:
        if (r8 != 2) goto L3;
        if (r9 > r7) goto L3;
        if (o.a(TAG_ARGUMENT, r14.getName()) == false) goto L3;
        inflateArgumentForBundle(r11, r6, r13, r15);
    L18:
        if (r6.isEmpty() == true) goto L20;
        r4.setDefaultArguments(r6);
    L20:
        r12.putAction(r3, r4);
        r2.recycle();
    }

    private final NavArgument inflateArgument(TypedArray r10, Resources r11, int r12) {
        NavArgument.Builder r9 = new NavArgument.Builder();
        boolean r1 = false;
        int r2 = 0;
        r9.setIsNullable(r10.getBoolean(androidx.navigation.common.R.styleable.NavArgument_nullable, false));
        ThreadLocal<TypedValue> r0 = sTmpValue;
        TypedValue r3 = r0.get();
        if (r3 != null) goto L5;
        r3 = new TypedValue();
        r0.set(r3);
    L5:
        String r7 = r10.getString(androidx.navigation.common.R.styleable.NavArgument_argType);
        Object r4 = null;
        if (r7 == null) goto L8;
        NavType<Object> r5 = NavType.Companion.fromArgType(r7, r11.getResourcePackageName(r12));
    L9:
        int r13 = androidx.navigation.common.R.styleable.NavArgument_android_defaultValue;
        if (r10.getValue(r13, r3) == false) goto L61;
        NavType<Object> r6 = NavType.ReferenceType;
        if (r5 != r6) goto L23;
        int r14 = r3.resourceId;
        if (r14 == 0) goto L17;
        r2 = r14;
    L20:
        r4 = Integer.valueOf(r2);
        goto L61
    L17:
        if (r3.type != 16) goto L22;
        if (r3.data == 0) goto L20;
    L22:
        throw new XmlPullParserException("unsupported value '" + r3.string + "' for " + r5.getName() + ". Must be a reference to a resource.");
    L23:
        int r8 = r3.resourceId;
        if (r8 == 0) goto L30;
        if (r5 != null) goto L28;
        r5 = r6;
        r4 = Integer.valueOf(r8);
        goto L61
    L28:
        throw new XmlPullParserException("unsupported value '" + r3.string + "' for " + r5.getName() + ". You must use a \"" + r6.getName() + "\" type to reference other resources.");
    L30:
        if (r5 != NavType.StringType) goto L32;
        r4 = r10.getString(r13);
        goto L61
    L32:
        int r15 = r3.type;
        if (r15 != 3) goto L35;
        String r16 = r3.string.toString();
        if (r5 != null) goto L60;
        r5 = NavType.Companion.inferFromValue(r16);
    L60:
        r4 = r5.parseValue(r16);
        goto L61
    L35:
        if (r15 != 4) goto L37;
        r5 = Companion.checkNavType$navigation_runtime_release(r3, r5, NavType.FloatType, r7, TypedValues.Custom.S_FLOAT);
        float r17 = r3.getFloat();
    L56:
        r4 = Float.valueOf(r17);
        goto L61
    L37:
        if (r15 != 5) goto L39;
        r5 = Companion.checkNavType$navigation_runtime_release(r3, r5, NavType.IntType, r7, TypedValues.Custom.S_DIMENSION);
        int r18 = (int) r3.getDimension(r11.getDisplayMetrics());
    L54:
        r4 = Integer.valueOf(r18);
        goto L61
    L39:
        if (r15 == 18) goto L49;
        if (r15 < 16) goto L48;
        if (r15 > 31) goto L48;
        NavType<Object> r19 = NavType.FloatType;
        Companion r20 = Companion;
        if (r5 != r19) goto L46;
        r5 = r20.checkNavType$navigation_runtime_release(r3, r5, r19, r7, TypedValues.Custom.S_FLOAT);
        r17 = r3.data;
        goto L56
    L46:
        r5 = r20.checkNavType$navigation_runtime_release(r3, r5, NavType.IntType, r7, TypedValues.Custom.S_INT);
        r18 = r3.data;
    L48:
        throw new XmlPullParserException("unsupported argument type " + r3.type);
    L49:
        r5 = Companion.checkNavType$navigation_runtime_release(r3, r5, NavType.BoolType, r7, TypedValues.Custom.S_BOOLEAN);
        if (r3.data == 0) goto L52;
        r1 = true;
    L52:
        r4 = Boolean.valueOf(r1);
    L61:
        if (r4 == null) goto L63;
        r9.setDefaultValue(r4);
    L63:
        if (r5 == null) goto L66;
        r9.setType(r5);
    L66:
        return r9.build();
    L8:
        r5 = null;
        goto L9
    }

    private final void inflateArgumentForBundle(Resources r3, Bundle r4, AttributeSet r5, int r6) {
        TypedArray r7 = r3.obtainAttributes(r5, androidx.navigation.common.R.styleable.NavArgument);
        o.e(r7, "res.obtainAttributes(att… R.styleable.NavArgument)");
        String r0 = r7.getString(androidx.navigation.common.R.styleable.NavArgument_android_name);
        if (r0 == null) goto L10;
        o.e(r0, "array.getString(R.stylea…uments must have a name\")");
        NavArgument r2 = inflateArgument(r7, r3, r6);
        if (r2.isDefaultValuePresent() == false) goto L7;
        r2.putDefaultValue(r0, r4);
    L7:
        f0 r8 = f0.f18324a;
        r7.recycle();
        return;
    L10:
        throw new XmlPullParserException("Arguments must have a name");
    }

    private final void inflateArgumentForDestination(Resources r3, NavDestination r4, AttributeSet r5, int r6) {
        TypedArray r7 = r3.obtainAttributes(r5, androidx.navigation.common.R.styleable.NavArgument);
        o.e(r7, "res.obtainAttributes(att… R.styleable.NavArgument)");
        String r0 = r7.getString(androidx.navigation.common.R.styleable.NavArgument_android_name);
        if (r0 == null) goto L7;
        o.e(r0, "array.getString(R.stylea…uments must have a name\")");
        r4.addArgument(r0, inflateArgument(r7, r3, r6));
        f0 r2 = f0.f18324a;
        r7.recycle();
        return;
    L7:
        throw new XmlPullParserException("Arguments must have a name");
    }

    private final void inflateDeepLink(Resources r12, NavDestination r13, AttributeSet r14) {
        TypedArray r15 = r12.obtainAttributes(r14, androidx.navigation.common.R.styleable.NavDeepLink);
        o.e(r15, "res.obtainAttributes(att… R.styleable.NavDeepLink)");
        String r0 = r15.getString(androidx.navigation.common.R.styleable.NavDeepLink_uri);
        String r16 = r15.getString(androidx.navigation.common.R.styleable.NavDeepLink_action);
        String r7 = r15.getString(androidx.navigation.common.R.styleable.NavDeepLink_mimeType);
        boolean r6 = false;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L27;
        if (r16 != null) goto L12;
    L15:
        boolean r2 = true;
    L16:
        if (r2 == false) goto L27;
        if (r7 != null) goto L19;
    L22:
        boolean r3 = true;
    L23:
        if (r3 == false) goto L27;
        throw new XmlPullParserException("Every <deepLink> must include at least one of app:uri, app:action, or app:mimeType");
    L19:
        if (r7.length() == 0) goto L22;
        r3 = false;
        goto L23
    L12:
        if (r16.length() == 0) goto L15;
        r2 = false;
    L27:
        NavDeepLink.Builder r9 = new NavDeepLink.Builder();
        if (r0 == null) goto L30;
        String r4 = this.context.getPackageName();
        o.e(r4, "context.packageName");
        r9.setUriPattern(k.w(r0, APPLICATION_ID_PLACEHOLDER, r4, false, 4, null));
    L30:
        if (r16 != null) goto L32;
    L33:
        r6 = true;
    L34:
        if (r6 == true) goto L36;
        String r5 = this.context.getPackageName();
        o.e(r5, "context.packageName");
        r9.setAction(k.w(r16, APPLICATION_ID_PLACEHOLDER, r5, false, 4, null));
    L36:
        if (r7 == null) goto L38;
        String r8 = this.context.getPackageName();
        o.e(r8, "context.packageName");
        r9.setMimeType(k.w(r7, APPLICATION_ID_PLACEHOLDER, r8, false, 4, null));
    L38:
        r13.addDeepLink(r9.build());
        f0 r11 = f0.f18324a;
        r15.recycle();
        return;
    L32:
        if (r16.length() != 0) goto L34;
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    @SuppressLint({"ResourceType"})
    public final NavGraph inflate(@NavigationRes int r7) {
        Resources r0 = this.context.getResources();
        XmlResourceParser r1 = r0.getXml(r7);
        o.e(r1, "res.getXml(graphResId)");
        AttributeSet r2 = Xml.asAttributeSet(r1);
    L24:
        int r3 = r1.next();     // Catch: Throwable -> L17 Exception -> L19
        if (r3 == 2) goto L7;
        if (r3 != 1) goto L24;
    L7:
        if (r3 != 2) goto L16;
        String r4 = r1.getName();     // Catch: Throwable -> L17 Exception -> L19
        o.e(r0, "res");     // Catch: Throwable -> L17 Exception -> L19
        o.e(r2, "attrs");     // Catch: Throwable -> L17 Exception -> L19
        NavDestination r6 = inflate(r0, r1, r2, r7);     // Catch: Throwable -> L17 Exception -> L19
        if ((r6 instanceof NavGraph) == false) goto L14;
        NavGraph r8 = (NavGraph) r6;     // Catch: Throwable -> L17 Exception -> L19
        r1.close();
        return r8;
    L14:
        throw new IllegalArgumentException(("Root element <" + r4 + "> did not inflate into a NavGraph").toString());     // Catch: Throwable -> L17 Exception -> L19
    L16:
        throw new XmlPullParserException("No start tag found");     // Catch: Throwable -> L17 Exception -> L19
    L17:
        th = move-exception;
        r1.close();
        throw th;
    L19:
        e = move-exception;
        throw new RuntimeException("Exception inflating " + r0.getResourceName(r7) + " line " + r1.getLineNumber(), e);     // Catch: Throwable -> L17
    }
}
