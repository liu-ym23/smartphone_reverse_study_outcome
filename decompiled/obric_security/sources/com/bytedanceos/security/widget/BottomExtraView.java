package com.bytedanceos.security.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.bytedanceos.security.reflect.ReflectHelper;
import com.obric.olog.OLog;
import com.obric.oui.bouncelayout.OListView;
import com.obric.oui.bouncelayout.OScrollView;
import com.obric.security.R;

/* JADX INFO: loaded from: classes2.dex */
public class BottomExtraView extends LinearLayout {
    public static final int NAVBAR_GESTURE_MODE = 1;
    public static final int NAVBAR_KEY_NORMAL_MODE = 0;
    public static final int NAVBAR_VIRTUAL_KEY_MODE = 2;
    private static final String TAG = "BottomExtraView";
    private int mAddPadding;
    private boolean mListParent;

    public BottomExtraView(Context context) {
        this(context, null);
    }

    public BottomExtraView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BottomExtraView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mListParent = false;
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        TypedArray r4 = context.obtainStyledAttributes(attrs, R.styleable.BottomExtraView, defStyleAttr, 0);
        this.mListParent = r4.getBoolean(0, false);
        r4.recycle();
        this.mAddPadding = context.getResources().getDimensionPixelOffset(R.dimen.bottom_extra_view_add_padding_height);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewGroup r0 = (ViewGroup) getParent();
        if (r0 != null) goto L5;
        return;
    L5:
        if ((r0 instanceof ViewGroup) == false) goto L42;
        ViewGroup r1 = r0;
    L7:
        if (r1 == null) goto L29;
        if ((r1 instanceof OScrollView) == true) goto L18;
        if ((r1 instanceof OListView) == true) goto L18;
        if ((r1.getParent() instanceof ViewGroup) == true) goto L15;
        r1 = null;
        goto L7
    L15:
        r1 = (ViewGroup) r1.getParent();
    L18:
        if (this.mListParent == false) goto L20;
        r1 = (ViewGroup) r1.getParent();
    L20:
        if (r1 != null) goto L24;
        OLog.d(TAG, "list parent is null , can't be set padding");
        return;
    L24:
        if (r1.getPaddingBottom() < this.mAddPadding) goto L26;
        return;
    L26:
        setBottomPaddingWhenNavigationBarStatusChangeByProxy(r1);
        return;
    L29:
        if (r0.getPaddingBottom() < this.mAddPadding) goto L31;
        return;
    L31:
        setBottomPaddingWhenNavigationBarStatusChangeByProxy(r0);
        return;
    }

    public static void setBottomPaddingWhenNavigationBarStatusChangeByProxy(final ViewGroup viewGroup) {
    L8:
        e = move-exception;
        OLog.e(TAG, " setBottomPaddingWhenNavigationBarStatusChangeByProxy exception =" + e);
        return;
    L4:
        if (Class.forName("bytedanceos.util.NavigationBarHelper") != null) goto L6;
        return;
    L6:
        viewGroup.setClipToPadding(false);     // Catch: Exception -> L8
        viewGroup.setClipChildren(false);     // Catch: Exception -> L8
        ReflectHelper.invokeMethod("bytedanceos.util.NavigationBarHelper", "setBottomPaddingWhenNavigationBarStatusChange", new Class[]{View.class}, new Object[]{viewGroup});     // Catch: Exception -> L8
    }
}
