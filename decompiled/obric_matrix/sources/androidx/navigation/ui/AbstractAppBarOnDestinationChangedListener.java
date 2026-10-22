package androidx.navigation.ui;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.annotation.StringRes;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable;
import androidx.customview.widget.Openable;
import androidx.navigation.FloatingWindow;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import java.lang.ref.WeakReference;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.a0;
import kotlin.n0.d.o;
import kotlin.u;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\b \u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\"\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u001cH\u0003J\u001c\u0010\u001d\u001a\u00020\u00132\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0001\u0010 \u001a\u00020\u0011H$J\u0012\u0010!\u001a\u00020\u00132\b\u0010\"\u001a\u0004\u0018\u00010#H$R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u0012\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\r0\r\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Landroidx/navigation/ui/AbstractAppBarOnDestinationChangedListener;", "Landroidx/navigation/NavController$OnDestinationChangedListener;", "context", "Landroid/content/Context;", "configuration", "Landroidx/navigation/ui/AppBarConfiguration;", "(Landroid/content/Context;Landroidx/navigation/ui/AppBarConfiguration;)V", "animator", "Landroid/animation/ValueAnimator;", "arrowDrawable", "Landroidx/appcompat/graphics/drawable/DrawerArrowDrawable;", "openableLayoutWeakReference", "Ljava/lang/ref/WeakReference;", "Landroidx/customview/widget/Openable;", "kotlin.jvm.PlatformType", "topLevelDestinations", "", "", "onDestinationChanged", "", "controller", "Landroidx/navigation/NavController;", "destination", "Landroidx/navigation/NavDestination;", "arguments", "Landroid/os/Bundle;", "setActionBarUpIndicator", "showAsDrawerIndicator", "", "setNavigationIcon", "icon", "Landroid/graphics/drawable/Drawable;", "contentDescription", "setTitle", "title", "", "navigation-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class AbstractAppBarOnDestinationChangedListener implements NavController.OnDestinationChangedListener {
    private ValueAnimator animator;
    private DrawerArrowDrawable arrowDrawable;
    private final Context context;
    private final WeakReference<Openable> openableLayoutWeakReference;
    private final Set<Integer> topLevelDestinations;

    public AbstractAppBarOnDestinationChangedListener(Context r2, AppBarConfiguration r3) {
        o.f(r2, "context");
        o.f(r3, "configuration");
        this.context = r2;
        this.topLevelDestinations = r3.getTopLevelDestinations();
        Openable r4 = r3.getOpenableLayout();
        if (r4 == null) goto L5;
        WeakReference<Openable> r5 = new WeakReference(r4);
    L6:
        this.openableLayoutWeakReference = r5;
        return;
    L5:
        r5 = null;
        goto L6
    }

    @SuppressLint({"ObjectAnimatorBinding"})
    private final void setActionBarUpIndicator(boolean r5) {
        DrawerArrowDrawable r0 = this.arrowDrawable;
        if (r0 == null) goto L6;
        u r1 = a0.a(r0, Boolean.TRUE);
        if (r1 == null) goto L6;
    L7:
        DrawerArrowDrawable r2 = (DrawerArrowDrawable) r1.a();
        boolean r3 = ((Boolean) r1.b()).booleanValue();
        if (r5 == false) goto L10;
        int r4 = R.string.nav_app_bar_open_drawer_description;
    L11:
        setNavigationIcon(r2, r4);
        if (r5 == false) goto L14;
        float r6 = 0.0f;
    L15:
        if (r3 == false) goto L20;
        float r7 = r2.getProgress();
        ValueAnimator r8 = this.animator;
        if (r8 == null) goto L19;
        r8.cancel();
    L19:
        ObjectAnimator r9 = ObjectAnimator.ofFloat(r2, "progress", new float[]{r7, r6});
        this.animator = r9;
        Objects.requireNonNull(r9, "null cannot be cast to non-null type android.animation.ObjectAnimator");
        r9.start();
        return;
    L20:
        r2.setProgress(r6);
        return;
    L14:
        r6 = 1.0f;
        goto L15
    L10:
        r4 = R.string.nav_app_bar_navigate_up_description;
    L6:
        DrawerArrowDrawable r10 = new DrawerArrowDrawable(this.context);
        this.arrowDrawable = r10;
        r1 = a0.a(r10, Boolean.FALSE);
        goto L7
    }

    @Override // androidx.navigation.NavController.OnDestinationChangedListener
    public void onDestinationChanged(NavController r8, NavDestination r9, Bundle r10) {
        o.f(r8, "controller");
        o.f(r9, "destination");
        if ((r9 instanceof FloatingWindow) == false) goto L5;
        return;
    L5:
        WeakReference<Openable> r0 = this.openableLayoutWeakReference;
        if (r0 == null) goto L8;
        Openable r1 = r0.get();
    L10:
        if (this.openableLayoutWeakReference == null) goto L14;
        if (r1 != null) goto L14;
        r8.removeOnDestinationChangedListener(this);
        return;
    L14:
        CharSequence r11 = r9.getLabel();
        boolean r2 = true;
        if (r11 == null) goto L27;
        StringBuffer r3 = new StringBuffer();
        Matcher r4 = Pattern.compile("\\{(.+?)\\}").matcher(r11);
    L18:
        if (r4.find() == false) goto L26;
        String r5 = r4.group(1);
        if (r10 == null) goto L25;
        if (r10.containsKey(r5) == false) goto L25;
        r4.appendReplacement(r3, "");
        r3.append(String.valueOf(r10.get(r5)));
    L25:
        throw new IllegalArgumentException("Could not find \"" + r5 + "\" in " + r10 + " to fill label \"" + r11 + '\"');
    L26:
        r4.appendTail(r3);
        setTitle(r3);
    L27:
        boolean r12 = NavigationUI.matchDestinations$navigation_ui_release(r9, this.topLevelDestinations);
        if (r1 != null) goto L31;
        if (r12 == false) goto L31;
        setNavigationIcon(null, 0);
        return;
    L31:
        if (r1 == null) goto L34;
        if (r12 == false) goto L34;
    L35:
        setActionBarUpIndicator(r2);
        return;
    L34:
        r2 = false;
        goto L35
    L8:
        r1 = null;
        goto L10
    }

    protected abstract void setNavigationIcon(Drawable r1, @StringRes int r2);

    protected abstract void setTitle(CharSequence r1);
}
