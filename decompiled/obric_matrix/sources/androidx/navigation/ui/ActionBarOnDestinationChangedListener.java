package androidx.navigation.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001c\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0001\u0010\u000b\u001a\u00020\fH\u0014J\u0012\u0010\r\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Landroidx/navigation/ui/ActionBarOnDestinationChangedListener;", "Landroidx/navigation/ui/AbstractAppBarOnDestinationChangedListener;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "configuration", "Landroidx/navigation/ui/AppBarConfiguration;", "(Landroidx/appcompat/app/AppCompatActivity;Landroidx/navigation/ui/AppBarConfiguration;)V", "setNavigationIcon", "", "icon", "Landroid/graphics/drawable/Drawable;", "contentDescription", "", "setTitle", "title", "", "navigation-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ActionBarOnDestinationChangedListener extends AbstractAppBarOnDestinationChangedListener {
    private final AppCompatActivity activity;

    public ActionBarOnDestinationChangedListener(AppCompatActivity r3, AppBarConfiguration r4) {
        o.f(r3, "activity");
        o.f(r4, "configuration");
        ActionBarDrawerToggle.Delegate r0 = r3.getDrawerToggleDelegate();
        if (r0 == null) goto L7;
        Context r1 = r0.getActionBarThemedContext();
        o.e(r1, "checkNotNull(activity.dr… }.actionBarThemedContext");
        super(r1, r4);
        this.activity = r3;
        return;
    L7:
        throw new IllegalStateException(("Activity " + r3 + " does not have an DrawerToggleDelegate set").toString());
    }

    @Override // androidx.navigation.ui.AbstractAppBarOnDestinationChangedListener
    protected void setNavigationIcon(Drawable r4, @StringRes int r5) {
        ActionBar r0 = this.activity.getSupportActionBar();
        if (r0 == null) goto L15;
        o.e(r0, "checkNotNull(activity.su…ortActionBar()\"\n        }");
        if (r4 == null) goto L7;
        boolean r2 = true;
    L8:
        r0.setDisplayHomeAsUpEnabled(r2);
        ActionBarDrawerToggle.Delegate r1 = this.activity.getDrawerToggleDelegate();
        if (r1 == null) goto L13;
        o.e(r1, "checkNotNull(activity.dr…leDelegate set\"\n        }");
        r1.setActionBarUpIndicator(r4, r5);
        return;
    L13:
        throw new IllegalStateException(("Activity " + this.activity + " does not have an DrawerToggleDelegate set").toString());
    L7:
        r2 = false;
        goto L8
    L15:
        throw new IllegalStateException(("Activity " + this.activity + " does not have an ActionBar set via setSupportActionBar()").toString());
    }

    @Override // androidx.navigation.ui.AbstractAppBarOnDestinationChangedListener
    protected void setTitle(CharSequence r2) {
        ActionBar r0 = this.activity.getSupportActionBar();
        if (r0 == null) goto L7;
        o.e(r0, "checkNotNull(activity.su…ortActionBar()\"\n        }");
        r0.setTitle(r2);
        return;
    L7:
        throw new IllegalStateException(("Activity " + this.activity + " does not have an ActionBar set via setSupportActionBar()").toString());
    }
}
