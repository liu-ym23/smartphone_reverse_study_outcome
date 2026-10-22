package androidx.navigation.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.annotation.StringRes;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.transition.TransitionManager;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\"\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u001c\u0010\u0014\u001a\u00020\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\b\u0001\u0010\u0017\u001a\u00020\u0018H\u0014J\u0012\u0010\u0019\u001a\u00020\r2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0014R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Landroidx/navigation/ui/CollapsingToolbarOnDestinationChangedListener;", "Landroidx/navigation/ui/AbstractAppBarOnDestinationChangedListener;", "collapsingToolbarLayout", "Lcom/google/android/material/appbar/CollapsingToolbarLayout;", "toolbar", "Landroidx/appcompat/widget/Toolbar;", "configuration", "Landroidx/navigation/ui/AppBarConfiguration;", "(Lcom/google/android/material/appbar/CollapsingToolbarLayout;Landroidx/appcompat/widget/Toolbar;Landroidx/navigation/ui/AppBarConfiguration;)V", "mCollapsingToolbarLayoutWeakReference", "Ljava/lang/ref/WeakReference;", "mToolbarWeakReference", "onDestinationChanged", "", "controller", "Landroidx/navigation/NavController;", "destination", "Landroidx/navigation/NavDestination;", "arguments", "Landroid/os/Bundle;", "setNavigationIcon", "icon", "Landroid/graphics/drawable/Drawable;", "contentDescription", "", "setTitle", "title", "", "navigation-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CollapsingToolbarOnDestinationChangedListener extends AbstractAppBarOnDestinationChangedListener {
    private final WeakReference<CollapsingToolbarLayout> mCollapsingToolbarLayoutWeakReference;
    private final WeakReference<Toolbar> mToolbarWeakReference;

    public CollapsingToolbarOnDestinationChangedListener(CollapsingToolbarLayout r3, Toolbar r4, AppBarConfiguration r5) {
        o.f(r3, "collapsingToolbarLayout");
        o.f(r4, "toolbar");
        o.f(r5, "configuration");
        Context r0 = r3.getContext();
        o.e(r0, "collapsingToolbarLayout.context");
        super(r0, r5);
        this.mCollapsingToolbarLayoutWeakReference = new WeakReference(r3);
        this.mToolbarWeakReference = new WeakReference(r4);
    }

    @Override // androidx.navigation.ui.AbstractAppBarOnDestinationChangedListener, androidx.navigation.NavController.OnDestinationChangedListener
    public void onDestinationChanged(NavController r3, NavDestination r4, Bundle r5) {
        o.f(r3, "controller");
        o.f(r4, "destination");
        CollapsingToolbarLayout r0 = this.mCollapsingToolbarLayoutWeakReference.get();
        Toolbar r1 = this.mToolbarWeakReference.get();
        if (r0 == null) goto L8;
        if (r1 == null) goto L8;
        super.onDestinationChanged(r3, r4, r5);
        return;
    L8:
        r3.removeOnDestinationChangedListener(this);
    }

    @Override // androidx.navigation.ui.AbstractAppBarOnDestinationChangedListener
    protected void setNavigationIcon(Drawable r2, @StringRes int r3) {
        Toolbar r1 = this.mToolbarWeakReference.get();
        if (r1 == null) goto L13;
        if (r2 == null) goto L6;
    L8:
        boolean r0 = false;
    L9:
        r1.setNavigationIcon(r2);
        r1.setNavigationContentDescription(r3);
        if (r0 == false) goto L14;
        TransitionManager.beginDelayedTransition(r1);
        return;
    L14:
        return;
    L6:
        if (r1.getNavigationIcon() == null) goto L8;
        r0 = true;
        goto L9
    }

    @Override // androidx.navigation.ui.AbstractAppBarOnDestinationChangedListener
    protected void setTitle(CharSequence r1) {
        CollapsingToolbarLayout r0 = this.mCollapsingToolbarLayoutWeakReference.get();
        if (r0 == null) goto L6;
        r0.setTitle(r1);
        return;
    }
}
