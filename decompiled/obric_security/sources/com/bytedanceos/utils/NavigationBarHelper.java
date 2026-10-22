package com.bytedanceos.utils;

import android.R;
import android.content.Context;
import android.provider.Settings;
import android.view.View;
import com.obric.oui.bouncelayout.OListView;
import com.obric.oui.bouncelayout.OScrollView;
import obric.widget.letters.QuickBarEx;

/* JADX INFO: loaded from: classes2.dex */
public class NavigationBarHelper {
    private static int mNavigationBarHeight;

    public interface NavigationBarStatusListener {
        void onApplyNavigationBarStatusChange(boolean show);
    }

    public NavigationBarHelper() {
    }

    public static void setBottomPaddingWhenNavigationBarStatusChange(final View view) {
        if ((view instanceof QuickBarEx) == false) goto L6;
        view = ((QuickBarEx) view).getLetterBar();
    L6:
        if ((view instanceof OListView) == false) goto L8;
    L11:
        final boolean r0 = true;
    L12:
        final int r2 = view.getPaddingBottom();
        setAutoAdapterNavigationBarEnabled(view, new AnonymousClass1(r2, view, r0), true);
        return;
    L8:
        if ((view instanceof OScrollView) == true) goto L11;
        r0 = false;
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void setAutoAdapterNavigationBarEnabled(View view, boolean enabled) {
        if ((view instanceof NavigationBarStatusListener) == false) goto L6;
        setAutoAdapterNavigationBarEnabled(view, (NavigationBarStatusListener) view, enabled);
        return;
    }

    public static void setAutoAdapterNavigationBarEnabled(final View view, final NavigationBarStatusListener listener, boolean enabled) {
        if (view != null) goto L4;
        return;
    L4:
        Context r0 = view.getContext();
        boolean r1 = needAutoAdapter(r0);
        if (listener == null) goto L7;
        boolean r2 = true;
    L8:
        if (enabled == false) goto L12;
        if (r1 == false) goto L12;
        if (r2 == false) goto L12;
        view.setOnSystemUiVisibilityChangeListener(new AnonymousClass2(view, listener));
        listener.onApplyNavigationBarStatusChange(isNavigationBarShown(r0));
        return;
    L12:
        view.setOnSystemUiVisibilityChangeListener(null);
        if (r1 == false) goto L18;
        if (r2 == false) goto L19;
        listener.onApplyNavigationBarStatusChange(isNavigationBarShown(r0));
        return;
    L19:
        return;
    L18:
        return;
    L7:
        r2 = false;
        goto L8
    }

    public static boolean needAutoAdapter(Context context) {
        if (context.getResources().getConfiguration().orientation != 1) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == true) goto L8;
        return false;
    L8:
        return true;
    L5:
        r2 = false;
        goto L6
    }

    public static boolean isNavigationBarShown(Context context) {
        if (Settings.Global.getInt(context.getContentResolver(), "navigation_bar_mode", 0) == 0) goto L5;
        return false;
    L5:
        if (Settings.Global.getInt(context.getContentResolver(), "nav_fixed_mode", 0) == 0) goto L7;
        return false;
    L7:
        return true;
    }

    public static int getNavigationBarHeight(Context context) {
        if (mNavigationBarHeight != 0) goto L6;
        mNavigationBarHeight = context.getResources().getDimensionPixelSize(R.dimen.timepicker_time_label_size);
    L6:
        return mNavigationBarHeight;
    }

    public static void navigationBarStatusChanged(View view, NavigationBarStatusListener listener, int flag) {
        view.getWindowInsetsController().getState();
        listener.onApplyNavigationBarStatusChange(false);
    }

    public static void navigationBarStatusChanged(NavigationBarStatusListener listener, int flag) {
        if (flag != 2) goto L5;
        listener.onApplyNavigationBarStatusChange(false);
        return;
    L5:
        if (flag != 0) goto L9;
        listener.onApplyNavigationBarStatusChange(true);
        return;
    }
}
