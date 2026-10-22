package androidx.navigation;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import androidx.annotation.CallSuper;
import androidx.annotation.RestrictTo;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.content.ContextCompat;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.n0.d.g;
import kotlin.n0.d.o;
import kotlin.r0.e;
import kotlin.u0.k;

/* JADX INFO: loaded from: classes.dex */
@Navigator.Name("activity")
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0017\u0018\u0000 \u00162\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0016\u0017\u0018B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\n\u001a\u00020\u0002H\u0016J0\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u0013\u0010\u0003\u001a\u00020\u00048\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Landroidx/navigation/ActivityNavigator;", "Landroidx/navigation/Navigator;", "Landroidx/navigation/ActivityNavigator$Destination;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "hostActivity", "Landroid/app/Activity;", "createDestination", "navigate", "Landroidx/navigation/NavDestination;", "destination", "args", "Landroid/os/Bundle;", "navOptions", "Landroidx/navigation/NavOptions;", "navigatorExtras", "Landroidx/navigation/Navigator$Extras;", "popBackStack", "", "Companion", "Destination", "Extras", "navigation-runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class ActivityNavigator extends Navigator<Destination> {
    public static final Companion Companion = null;
    private static final String EXTRA_NAV_CURRENT = "android-support-navigation:ActivityNavigator:current";
    private static final String EXTRA_NAV_SOURCE = "android-support-navigation:ActivityNavigator:source";
    private static final String EXTRA_POP_ENTER_ANIM = "android-support-navigation:ActivityNavigator:popEnterAnim";
    private static final String EXTRA_POP_EXIT_ANIM = "android-support-navigation:ActivityNavigator:popExitAnim";
    private static final String LOG_TAG = "ActivityNavigator";
    private final Context context;
    private final Activity hostActivity;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Landroidx/navigation/ActivityNavigator$Companion;", "", "()V", "EXTRA_NAV_CURRENT", "", "EXTRA_NAV_SOURCE", "EXTRA_POP_ENTER_ANIM", "EXTRA_POP_EXIT_ANIM", "LOG_TAG", "applyPopAnimationsToPendingTransition", "", "activity", "Landroid/app/Activity;", "navigation-runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g r1) {
            this();
        }

        public final void applyPopAnimationsToPendingTransition(Activity r4) {
            o.f(r4, "activity");
            Intent r3 = r4.getIntent();
            if (r3 != null) goto L5;
            return;
        L5:
            int r0 = r3.getIntExtra(ActivityNavigator.EXTRA_POP_ENTER_ANIM, -1);
            int r5 = r3.getIntExtra(ActivityNavigator.EXTRA_POP_EXIT_ANIM, -1);
            if (r0 != (-1)) goto L9;
            if (r5 != (-1)) goto L9;
            return;
        L9:
            if (r0 != (-1)) goto L12;
            r0 = 0;
        L12:
            if (r5 != (-1)) goto L15;
            r5 = 0;
        L15:
            r4.overridePendingTransition(r0, r5);
        }
    }

    @Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0017\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0015\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00000\u0006¢\u0006\u0002\u0010\u0007J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0096\u0002J\b\u0010!\u001a\u00020\"H\u0016J\u0018\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0017J\u0010\u0010)\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\tJ\u0010\u0010*\u001a\u00020\u00002\b\u0010+\u001a\u0004\u0018\u00010\rJ\u0010\u0010,\u001a\u00020\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011J\u0010\u0010-\u001a\u00020\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\tJ\u0010\u0010.\u001a\u00020\u00002\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017J\u0010\u0010/\u001a\u00020\u00002\b\u00100\u001a\u0004\u0018\u00010\tJ\b\u00101\u001a\u00020\u001eH\u0017J\b\u00102\u001a\u00020\tH\u0016R$\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\t8F@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR$\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\b\u001a\u0004\u0018\u00010\r8F@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R$\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\b\u001a\u0004\u0018\u00010\u00118F@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\"\u0010\u0015\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\t@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\fR\"\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\b\u001a\u0004\u0018\u00010\u0017@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR$\u0010\u001b\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\t8F@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\f¨\u00063"}, d2 = {"Landroidx/navigation/ActivityNavigator$Destination;", "Landroidx/navigation/NavDestination;", "navigatorProvider", "Landroidx/navigation/NavigatorProvider;", "(Landroidx/navigation/NavigatorProvider;)V", "activityNavigator", "Landroidx/navigation/Navigator;", "(Landroidx/navigation/Navigator;)V", "<set-?>", "", "action", "getAction", "()Ljava/lang/String;", "Landroid/content/ComponentName;", "component", "getComponent", "()Landroid/content/ComponentName;", "Landroid/net/Uri;", "data", "getData", "()Landroid/net/Uri;", "dataPattern", "getDataPattern", "Landroid/content/Intent;", "intent", "getIntent", "()Landroid/content/Intent;", "targetPackage", "getTargetPackage", "equals", "", "other", "", "hashCode", "", "onInflate", "", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "setAction", "setComponentName", "name", "setData", "setDataPattern", "setIntent", "setTargetPackage", "packageName", "supportsActions", "toString", "navigation-runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @NavDestination.ClassType(Activity.class)
    public static class Destination extends NavDestination {
        private String action;
        private ComponentName component;
        private Uri data;
        private String dataPattern;
        private Intent intent;
        private String targetPackage;

        public Destination(Navigator<? extends Destination> r2) {
            o.f(r2, "activityNavigator");
            super(r2);
        }

        public Destination(NavigatorProvider r2) {
            o.f(r2, "navigatorProvider");
            this(r2.getNavigator(ActivityNavigator.class));
        }

        @Override // androidx.navigation.NavDestination
        public boolean equals(Object r5) {
            if (r5 != null) goto L5;
            return false;
        L5:
            if ((r5 instanceof Destination) == true) goto L8;
            return false;
        L8:
            if (super.equals(r5) == false) goto L22;
            Intent r1 = this.intent;
            if (r1 == null) goto L13;
            boolean r2 = r1.filterEquals(((Destination) r5).intent);
        L16:
            if (r2 == true) goto L18;
            return false;
        L18:
            if (o.a(this.dataPattern, ((Destination) r5).dataPattern) == true) goto L20;
            return false;
        L20:
            return true;
        L13:
            if (((Destination) r5).intent != null) goto L15;
            r2 = true;
            goto L16
        L15:
            r2 = false;
            goto L16
        L22:
            return false;
        }

        public final String getAction() {
            Intent r0 = this.intent;
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.getAction();
        }

        public final ComponentName getComponent() {
            Intent r0 = this.intent;
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.getComponent();
        }

        public final Uri getData() {
            Intent r0 = this.intent;
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.getData();
        }

        public final String getDataPattern() {
            return this.dataPattern;
        }

        public final Intent getIntent() {
            return this.intent;
        }

        public final String getTargetPackage() {
            Intent r0 = this.intent;
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.getPackage();
        }

        @Override // androidx.navigation.NavDestination
        public int hashCode() {
            int r0 = super.hashCode() * 31;
            Intent r1 = this.intent;
            int r2 = 0;
            if (r1 == null) goto L5;
            int r3 = r1.filterHashCode();
        L6:
            int r4 = (r0 + r3) * 31;
            String r5 = this.dataPattern;
            if (r5 == null) goto L10;
            r2 = r5.hashCode();
        L10:
            return r4 + r2;
        L5:
            r3 = 0;
            goto L6
        }

        @Override // androidx.navigation.NavDestination
        @CallSuper
        public void onInflate(Context r8, AttributeSet r9) {
            o.f(r8, "context");
            o.f(r9, "attrs");
            super.onInflate(r8, r9);
            TypedArray r10 = r8.getResources().obtainAttributes(r9, R.styleable.ActivityNavigator);
            o.e(r10, "context.resources.obtain…tyNavigator\n            )");
            String r1 = r10.getString(R.styleable.ActivityNavigator_targetPackage);
            if (r1 == null) goto L5;
            String r3 = r8.getPackageName();
            o.e(r3, "context.packageName");
            r1 = k.w(r1, NavInflater.APPLICATION_ID_PLACEHOLDER, r3, false, 4, null);
        L5:
            setTargetPackage(r1);
            String r0 = r10.getString(R.styleable.ActivityNavigator_android_name);
            if (r0 != null) goto L8;
        L11:
            setAction(r10.getString(R.styleable.ActivityNavigator_action));
            String r11 = r10.getString(R.styleable.ActivityNavigator_data);
            if (r11 == null) goto L14;
            setData(Uri.parse(r11));
        L14:
            setDataPattern(r10.getString(R.styleable.ActivityNavigator_dataPattern));
            r10.recycle();
            return;
        L8:
            if (r0.charAt(0) != '.') goto L10;
            r0 = r8.getPackageName() + r0;
        L10:
            setComponentName(new ComponentName(r8, r0));
            goto L11
        }

        public final Destination setAction(String r2) {
            if (this.intent != null) goto L5;
            this.intent = new Intent();
        L5:
            Intent r0 = this.intent;
            o.c(r0);
            r0.setAction(r2);
            return this;
        }

        public final Destination setComponentName(ComponentName r2) {
            if (this.intent != null) goto L5;
            this.intent = new Intent();
        L5:
            Intent r0 = this.intent;
            o.c(r0);
            r0.setComponent(r2);
            return this;
        }

        public final Destination setData(Uri r2) {
            if (this.intent != null) goto L5;
            this.intent = new Intent();
        L5:
            Intent r0 = this.intent;
            o.c(r0);
            r0.setData(r2);
            return this;
        }

        public final Destination setDataPattern(String r1) {
            this.dataPattern = r1;
            return this;
        }

        public final Destination setIntent(Intent r1) {
            this.intent = r1;
            return this;
        }

        public final Destination setTargetPackage(String r2) {
            if (this.intent != null) goto L5;
            this.intent = new Intent();
        L5:
            Intent r0 = this.intent;
            o.c(r0);
            r0.setPackage(r2);
            return this;
        }

        @Override // androidx.navigation.NavDestination
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public boolean supportsActions() {
            return false;
        }

        @Override // androidx.navigation.NavDestination
        public String toString() {
            ComponentName r0 = getComponent();
            StringBuilder r1 = new StringBuilder();
            r1.append(super.toString());
            if (r0 == null) goto L6;
            r1.append(" class=");
            String r3 = r0.getClassName();
        L5:
            r1.append(r3);
        L9:
            String r4 = r1.toString();
            o.e(r4, "sb.toString()");
            return r4;
        L6:
            r3 = getAction();
            if (r3 == null) goto L9;
            r1.append(" action=");
            goto L5
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u000bB\u0019\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Landroidx/navigation/ActivityNavigator$Extras;", "Landroidx/navigation/Navigator$Extras;", "flags", "", "activityOptions", "Landroidx/core/app/ActivityOptionsCompat;", "(ILandroidx/core/app/ActivityOptionsCompat;)V", "getActivityOptions", "()Landroidx/core/app/ActivityOptionsCompat;", "getFlags", "()I", "Builder", "navigation-runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Extras implements Navigator.Extras {
        private final ActivityOptionsCompat activityOptions;
        private final int flags;

        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Landroidx/navigation/ActivityNavigator$Extras$Builder;", "", "()V", "activityOptions", "Landroidx/core/app/ActivityOptionsCompat;", "flags", "", "addFlags", "build", "Landroidx/navigation/ActivityNavigator$Extras;", "setActivityOptions", "navigation-runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class Builder {
            private ActivityOptionsCompat activityOptions;
            private int flags;

            public Builder() {
            }

            public final Builder addFlags(int r2) {
                this.flags = r2 | this.flags;
                return this;
            }

            public final Extras build() {
                return new Extras(this.flags, this.activityOptions);
            }

            public final Builder setActivityOptions(ActivityOptionsCompat r2) {
                o.f(r2, "activityOptions");
                this.activityOptions = r2;
                return this;
            }
        }

        public Extras(int r1, ActivityOptionsCompat r2) {
            this.flags = r1;
            this.activityOptions = r2;
        }

        public final ActivityOptionsCompat getActivityOptions() {
            return this.activityOptions;
        }

        public final int getFlags() {
            return this.flags;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public ActivityNavigator(Context r3) {
        o.f(r3, "context");
        this.context = r3;
        Iterator r4 = kotlin.t0.k.h(r3, ActivityNavigator$hostActivity$1.INSTANCE).iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        Object r0 = r4.next();
        if ((((Context) r0) instanceof Activity) == false) goto L4;
    L9:
        this.hostActivity = (Activity) r0;
        return;
    L8:
        r0 = null;
        goto L9
    }

    public static final void applyPopAnimationsToPendingTransition(Activity r1) {
        Companion.applyPopAnimationsToPendingTransition(r1);
    }

    @Override // androidx.navigation.Navigator
    public Destination createDestination() {
        return new Destination(this);
    }

    @Override // androidx.navigation.Navigator
    public /* bridge */ /* synthetic */ NavDestination createDestination() {
        return createDestination();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final Context getContext() {
        return this.context;
    }

    public NavDestination navigate(Destination r10, Bundle r11, NavOptions r12, Navigator.Extras r13) {
        o.f(r10, "destination");
        if (r10.getIntent() == null) goto L73;
        Intent r0 = new Intent(r10.getIntent());
        if (r11 == null) goto L23;
        r0.putExtras(r11);
        String r2 = r10.getDataPattern();
        if (r2 != null) goto L9;
    L12:
        boolean r4 = true;
    L13:
        if (r4 == true) goto L23;
        StringBuffer r5 = new StringBuffer();
        Matcher r6 = Pattern.compile("\\{(.+?)\\}").matcher(r2);
    L16:
        if (r6.find() == false) goto L22;
        String r7 = r6.group(1);
        if (r11.containsKey(r7) == false) goto L21;
        r6.appendReplacement(r5, "");
        r5.append(Uri.encode(String.valueOf(r11.get(r7))));
        goto L16
    L21:
        throw new IllegalArgumentException("Could not find " + r7 + " in " + r11 + " to fill data pattern " + r2);
    L22:
        r6.appendTail(r5);
        r0.setData(Uri.parse(r5.toString()));
        goto L23
    L9:
        if (r2.length() == 0) goto L12;
        r4 = false;
    L23:
        boolean r14 = r13 instanceof Extras;
        if (r14 == false) goto L27;
        r0.addFlags(((Extras) r13).getFlags());
    L27:
        if (this.hostActivity != null) goto L29;
        r0.addFlags(268435456);
    L29:
        if (r12 != null) goto L31;
    L33:
        Activity r3 = this.hostActivity;
        if (r3 == null) goto L40;
        Intent r8 = r3.getIntent();
        if (r8 == null) goto L40;
        int r9 = r8.getIntExtra(EXTRA_NAV_CURRENT, 0);
        if (r9 == 0) goto L40;
        r0.putExtra(EXTRA_NAV_SOURCE, r9);
    L40:
        r0.putExtra(EXTRA_NAV_CURRENT, r10.getId());
        Resources r15 = this.context.getResources();
        if (r12 == null) goto L51;
        int r16 = r12.getPopEnterAnim();
        int r17 = r12.getPopExitAnim();
        if (r16 > 0) goto L45;
    L46:
        if (r17 > 0) goto L48;
    L50:
        r0.putExtra(EXTRA_POP_ENTER_ANIM, r16);
        r0.putExtra(EXTRA_POP_EXIT_ANIM, r17);
        goto L51
    L48:
        if (o.a(r15.getResourceTypeName(r17), "animator") == false) goto L50;
    L49:
        Log.w(LOG_TAG, "Activity destinations do not support Animator resource. Ignoring popEnter resource " + r15.getResourceName(r16) + " and popExit resource " + r15.getResourceName(r17) + " when launching " + r10);
        goto L51
    L45:
        if (o.a(r15.getResourceTypeName(r16), "animator") == true) goto L49;
    L51:
        if (r14 == false) goto L55;
        ActivityOptionsCompat r18 = ((Extras) r13).getActivityOptions();
        if (r18 == null) goto L55;
        ContextCompat.startActivity(this.context, r0, r18.toBundle());
    L56:
        if (r12 != null) goto L58;
        return null;
    L58:
        if (this.hostActivity == null) goto L77;
        int r19 = r12.getEnterAnim();
        int r110 = r12.getExitAnim();
        if (r19 > 0) goto L62;
    L63:
        if (r110 > 0) goto L65;
    L67:
        if (r19 >= 0) goto L69;
        if (r110 >= 0) goto L69;
        return null;
    L69:
        this.hostActivity.overridePendingTransition(e.c(r19, 0), e.c(r110, 0));
        return null;
    L65:
        if (o.a(r15.getResourceTypeName(r110), "animator") == false) goto L67;
    L66:
        Log.w(LOG_TAG, "Activity destinations do not support Animator resource. Ignoring enter resource " + r15.getResourceName(r19) + " and exit resource " + r15.getResourceName(r110) + "when launching " + r10);
        return null;
    L62:
        if (o.a(r15.getResourceTypeName(r19), "animator") == true) goto L66;
    L77:
        return null;
    L55:
        this.context.startActivity(r0);
        goto L56
    L31:
        if (r12.shouldLaunchSingleTop() == false) goto L33;
        r0.addFlags(536870912);
        goto L33
    L73:
        throw new IllegalStateException(("Destination " + r10.getId() + " does not have an Intent set.").toString());
    }

    @Override // androidx.navigation.Navigator
    public /* bridge */ /* synthetic */ NavDestination navigate(NavDestination r1, Bundle r2, NavOptions r3, Navigator.Extras r4) {
        return navigate((Destination) r1, r2, r3, r4);
    }

    @Override // androidx.navigation.Navigator
    public boolean popBackStack() {
        Activity r0 = this.hostActivity;
        if (r0 == null) goto L6;
        r0.finish();
        return true;
    L6:
        return false;
    }
}
