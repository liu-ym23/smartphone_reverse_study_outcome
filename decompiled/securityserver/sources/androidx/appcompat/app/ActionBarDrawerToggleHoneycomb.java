package androidx.appcompat.app;

import android.R;
import android.app.Activity;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
class ActionBarDrawerToggleHoneycomb {
    private static final String TAG = "ActionBarDrawerToggleHC";
    private static final int[] THEME_ATTRS = null;

    public static class SetIndicatorInfo {
        public Method setHomeActionContentDescription;
        public Method setHomeAsUpIndicator;
        public ImageView upIndicatorView;

        public SetIndicatorInfo(Activity r4) {
            this.setHomeAsUpIndicator = android.app.ActionBar.class.getDeclaredMethod("setHomeAsUpIndicator", new Class[]{Drawable.class});     // Catch: NoSuchMethodException -> L5
            this.setHomeActionContentDescription = android.app.ActionBar.class.getDeclaredMethod("setHomeActionContentDescription", new Class[]{Integer.TYPE});     // Catch: NoSuchMethodException -> L5
            return;
        L5:
            View r5 = r4.findViewById(R.id.home);
            if (r5 != null) goto L8;
            return;
        L8:
            ViewGroup r6 = (ViewGroup) r5.getParent();
            if (r6.getChildCount() == 2) goto L11;
            return;
        L11:
            View r1 = r6.getChildAt(0);
            View r7 = r6.getChildAt(1);
            if (r1.getId() != 16908332) goto L15;
            r1 = r7;
        L15:
            if ((r1 instanceof ImageView) == false) goto L20;
            this.upIndicatorView = (ImageView) r1;
            return;
        }
    }

    static {
        THEME_ATTRS = new int[]{R.attr.homeAsUpIndicator};
    }

    private ActionBarDrawerToggleHoneycomb() {
    }

    public static Drawable getThemeUpIndicator(Activity r1) {
        TypedArray r2 = r1.obtainStyledAttributes(THEME_ATTRS);
        Drawable r0 = r2.getDrawable(0);
        r2.recycle();
        return r0;
    }

    public static SetIndicatorInfo setActionBarDescription(SetIndicatorInfo r1, Activity r2, int r3) {
        if (r1 != null) goto L5;
        r1 = new SetIndicatorInfo(r2);
    L5:
        if (r1.setHomeAsUpIndicator != null) goto L11;
    L10:
        return r1;
    L11:
        android.app.ActionBar r4 = r2.getActionBar();     // Catch: Exception -> L8
        r1.setHomeActionContentDescription.invoke(r4, new Object[]{Integer.valueOf(r3)});     // Catch: Exception -> L8
    L8:
        e = move-exception;
        Log.w(TAG, "Couldn't set content description via JB-MR2 API", e);
        goto L10
    }

    public static SetIndicatorInfo setActionBarUpIndicator(Activity r3, Drawable r4, int r5) {
        SetIndicatorInfo r0 = new SetIndicatorInfo(r3);
        if (r0.setHomeAsUpIndicator != null) goto L13;
        ImageView r6 = r0.upIndicatorView;
        if (r6 == null) goto L11;
        r6.setImageDrawable(r4);
    L12:
        return r0;
    L11:
        Log.w(TAG, "Couldn't set home-as-up indicator");
        goto L12
    L13:
        android.app.ActionBar r7 = r3.getActionBar();     // Catch: Exception -> L6
        r0.setHomeAsUpIndicator.invoke(r7, new Object[]{r4});     // Catch: Exception -> L6
        r0.setHomeActionContentDescription.invoke(r7, new Object[]{Integer.valueOf(r5)});     // Catch: Exception -> L6
    L6:
        e = move-exception;
        Log.w(TAG, "Couldn't set home-as-up indicator via JB-MR2 API", e);
        goto L12
    }
}
