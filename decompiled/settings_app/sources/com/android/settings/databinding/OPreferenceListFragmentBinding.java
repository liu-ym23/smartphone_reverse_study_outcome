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
import com.obric.oui.bouncelayout.OListView;

/* JADX INFO: loaded from: classes2.dex */
public final class OPreferenceListFragmentBinding implements ViewBinding {
    public final Button backButton;
    public final RelativeLayout buttonBar;
    public final TextView empty;
    public final OListView list;
    public final FrameLayout listContainer;
    public final Button nextButton;
    private final LinearLayout rootView;
    public final Button skipButton;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private OPreferenceListFragmentBinding(LinearLayout r1, Button r2, RelativeLayout r3, TextView r4, OListView r5, FrameLayout r6, Button r7, Button r8) {
        this.rootView = r1;
        this.backButton = r2;
        this.buttonBar = r3;
        this.empty = r4;
        this.list = r5;
        this.listContainer = r6;
        this.nextButton = r7;
        this.skipButton = r8;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static OPreferenceListFragmentBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static OPreferenceListFragmentBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.o_preference_list_fragment, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static OPreferenceListFragmentBinding bind(View r11) {
        int r0 = R.id.back_button;
        Button r4 = (Button) ViewBindings.findChildViewById(r11, R.id.back_button);
        if (r4 == null) goto L19;
        r0 = R.id.button_bar;
        RelativeLayout r5 = (RelativeLayout) ViewBindings.findChildViewById(r11, R.id.button_bar);
        if (r5 == null) goto L19;
        r0 = android.R.id.empty;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r11, android.R.id.empty);
        if (r6 == null) goto L19;
        r0 = android.R.id.list;
        OListView r7 = (OListView) ViewBindings.findChildViewById(r11, android.R.id.list);
        if (r7 == null) goto L19;
        r0 = android.R.id.list_container;
        FrameLayout r8 = (FrameLayout) ViewBindings.findChildViewById(r11, android.R.id.list_container);
        if (r8 == null) goto L19;
        r0 = R.id.next_button;
        Button r9 = (Button) ViewBindings.findChildViewById(r11, R.id.next_button);
        if (r9 == null) goto L19;
        r0 = R.id.skip_button;
        Button r10 = (Button) ViewBindings.findChildViewById(r11, R.id.skip_button);
        if (r10 == null) goto L19;
        return new OPreferenceListFragmentBinding((LinearLayout) r11, r4, r5, r6, r7, r8, r9, r10);
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r0)));
    }
}
