package com.android.settings.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import bytedanceos.util.NavigationBarHelper;
import com.android.settings.R;
import com.obric.olog.OLog;

/* JADX INFO: loaded from: classes.dex */
public class SettingsBottomExtraView extends LinearLayout {
    public static final int NAVBAR_GESTURE_MODE = 1;
    public static final int NAVBAR_KEY_NORMAL_MODE = 0;
    public static final int NAVBAR_VIRTUAL_KEY_MODE = 2;
    private static final String TAG = "SettingsBottomExtraView";
    private int mAddPadding;
    private boolean mListParent;

    static /* synthetic */ int access$000(SettingsBottomExtraView r0) {
        return r0.mAddPadding;
    }

    public SettingsBottomExtraView(Context r2) {
        this(r2, null);
    }

    public SettingsBottomExtraView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public SettingsBottomExtraView(Context r2, AttributeSet r3, int r4) {
        super(r2, r3, r4);
        this.mListParent = false;
        init(r2, r3, r4);
    }

    private void init(Context r3, AttributeSet r4, int r5) {
        TypedArray r6 = r3.obtainStyledAttributes(r4, R.styleable.BottomExtraView, r5, 0);
        this.mListParent = r6.getBoolean(0, false);
        r6.recycle();
        this.mAddPadding = r3.getResources().getDimensionPixelOffset(R.dimen.setting_bottom_extra_view_add_padding_height);
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
        if ((r1 instanceof ScrollView) == true) goto L18;
        if ((r1 instanceof ListView) == true) goto L18;
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
        setBottomPaddingWhenNavigationBarStatusChange(r1);
        return;
    L29:
        if (r0.getPaddingBottom() < this.mAddPadding) goto L31;
        return;
    L31:
        setBottomPaddingWhenNavigationBarStatusChange(r0);
        return;
    }

    public void setBottomPaddingWhenNavigationBarStatusChange(final ViewGroup r3) {
        final int r0 = r3.getPaddingBottom();
        NavigationBarHelper.setAutoAdapterNavigationBarEnabled(r3, new AnonymousClass1(this, r0, r3), true);
    }
}
