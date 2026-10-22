package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.android.settings.widget.FloatingActionButton;
import com.obric.oui.bouncelayout.OListView;

/* JADX INFO: loaded from: classes2.dex */
public final class PreferenceListFragmentBinding implements ViewBinding {
    public final Button backButton;
    public final OListView backupList;
    public final RelativeLayout buttonBar;
    public final LinearLayout containerMaterial;
    public final TextView empty;
    public final FloatingActionButton fab;
    public final FrameLayout listContainer;
    public final Button nextButton;
    public final FrameLayout pinnedHeader;
    private final LinearLayout rootView;
    public final Button skipButton;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private PreferenceListFragmentBinding(LinearLayout r1, Button r2, OListView r3, RelativeLayout r4, LinearLayout r5, TextView r6, FloatingActionButton r7, FrameLayout r8, Button r9, FrameLayout r10, Button r11) {
        this.rootView = r1;
        this.backButton = r2;
        this.backupList = r3;
        this.buttonBar = r4;
        this.containerMaterial = r5;
        this.empty = r6;
        this.fab = r7;
        this.listContainer = r8;
        this.nextButton = r9;
        this.pinnedHeader = r10;
        this.skipButton = r11;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static PreferenceListFragmentBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static PreferenceListFragmentBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.preference_list_fragment, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static PreferenceListFragmentBinding bind(View r14) {
        int r0 = R.id.back_button;
        Button r4 = (Button) ViewBindings.findChildViewById(r14, R.id.back_button);
        if (r4 == null) goto L23;
        r0 = R.id.backup_list;
        OListView r5 = (OListView) ViewBindings.findChildViewById(r14, R.id.backup_list);
        if (r5 == null) goto L23;
        r0 = R.id.button_bar;
        RelativeLayout r6 = (RelativeLayout) ViewBindings.findChildViewById(r14, R.id.button_bar);
        if (r6 == null) goto L23;
        LinearLayout r7 = (LinearLayout) r14;
        r0 = android.R.id.empty;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r14, android.R.id.empty);
        if (r8 == null) goto L23;
        r0 = R.id.fab;
        FloatingActionButton r9 = (FloatingActionButton) ViewBindings.findChildViewById(r14, R.id.fab);
        if (r9 == null) goto L23;
        r0 = android.R.id.list_container;
        FrameLayout r10 = (FrameLayout) ViewBindings.findChildViewById(r14, android.R.id.list_container);
        if (r10 == null) goto L23;
        r0 = R.id.next_button;
        Button r11 = (Button) ViewBindings.findChildViewById(r14, R.id.next_button);
        if (r11 == null) goto L23;
        r0 = R.id.pinned_header;
        FrameLayout r12 = (FrameLayout) ViewBindings.findChildViewById(r14, R.id.pinned_header);
        if (r12 == null) goto L23;
        r0 = R.id.skip_button;
        Button r13 = (Button) ViewBindings.findChildViewById(r14, R.id.skip_button);
        if (r13 == null) goto L23;
        return new PreferenceListFragmentBinding(r7, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13);
    L23:
        throw new NullPointerException("Missing required view with ID: ".concat(r14.getResources().getResourceName(r0)));
    }
}
