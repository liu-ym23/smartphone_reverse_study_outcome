package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Space;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.android.settings.graph.UsageGraph;

/* JADX INFO: loaded from: classes2.dex */
public final class UsageViewBinding implements ViewBinding {
    public final LinearLayout bottomLabelGroup;
    public final Space bottomLabelSpace;
    public final LinearLayout graphLabelGroup;
    public final UsageSideLabelBinding labelBottom;
    public final UsageSideLabelBinding labelEnd;
    public final LinearLayout labelGroup;
    public final UsageSideLabelBinding labelMiddle;
    public final UsageSideLabelBinding labelStart;
    public final UsageSideLabelBinding labelTop;
    private final LinearLayout rootView;
    public final Space space1;
    public final Space space2;
    public final Space spacer;
    public final UsageGraph usageGraph;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private UsageViewBinding(LinearLayout r1, LinearLayout r2, Space r3, LinearLayout r4, UsageSideLabelBinding r5, UsageSideLabelBinding r6, LinearLayout r7, UsageSideLabelBinding r8, UsageSideLabelBinding r9, UsageSideLabelBinding r10, Space r11, Space r12, Space r13, UsageGraph r14) {
        this.rootView = r1;
        this.bottomLabelGroup = r2;
        this.bottomLabelSpace = r3;
        this.graphLabelGroup = r4;
        this.labelBottom = r5;
        this.labelEnd = r6;
        this.labelGroup = r7;
        this.labelMiddle = r8;
        this.labelStart = r9;
        this.labelTop = r10;
        this.space1 = r11;
        this.space2 = r12;
        this.spacer = r13;
        this.usageGraph = r14;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static UsageViewBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static UsageViewBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.usage_view, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static UsageViewBinding bind(View r18) {
        int r1 = R.id.bottom_label_group;
        LinearLayout r5 = (LinearLayout) ViewBindings.findChildViewById(r18, R.id.bottom_label_group);
        if (r5 == null) goto L31;
        r1 = R.id.bottom_label_space;
        Space r6 = (Space) ViewBindings.findChildViewById(r18, R.id.bottom_label_space);
        if (r6 == null) goto L31;
        r1 = R.id.graph_label_group;
        LinearLayout r7 = (LinearLayout) ViewBindings.findChildViewById(r18, R.id.graph_label_group);
        if (r7 == null) goto L31;
        r1 = R.id.label_bottom;
        View r2 = ViewBindings.findChildViewById(r18, R.id.label_bottom);
        if (r2 == null) goto L31;
        UsageSideLabelBinding r8 = UsageSideLabelBinding.bind(r2);
        r1 = R.id.label_end;
        View r3 = ViewBindings.findChildViewById(r18, R.id.label_end);
        if (r3 == null) goto L31;
        UsageSideLabelBinding r9 = UsageSideLabelBinding.bind(r3);
        r1 = R.id.label_group;
        LinearLayout r10 = (LinearLayout) ViewBindings.findChildViewById(r18, R.id.label_group);
        if (r10 == null) goto L31;
        r1 = R.id.label_middle;
        View r4 = ViewBindings.findChildViewById(r18, R.id.label_middle);
        if (r4 == null) goto L31;
        UsageSideLabelBinding r11 = UsageSideLabelBinding.bind(r4);
        r1 = R.id.label_start;
        View r12 = ViewBindings.findChildViewById(r18, R.id.label_start);
        if (r12 == null) goto L31;
        UsageSideLabelBinding r13 = UsageSideLabelBinding.bind(r12);
        r1 = R.id.label_top;
        View r14 = ViewBindings.findChildViewById(r18, R.id.label_top);
        if (r14 == null) goto L31;
        UsageSideLabelBinding r15 = UsageSideLabelBinding.bind(r14);
        r1 = R.id.space1;
        Space r16 = (Space) ViewBindings.findChildViewById(r18, R.id.space1);
        if (r16 == null) goto L31;
        r1 = R.id.space2;
        Space r17 = (Space) ViewBindings.findChildViewById(r18, R.id.space2);
        if (r17 == null) goto L31;
        r1 = R.id.spacer;
        Space r19 = (Space) ViewBindings.findChildViewById(r18, R.id.spacer);
        if (r19 == null) goto L31;
        r1 = R.id.usage_graph;
        UsageGraph r110 = (UsageGraph) ViewBindings.findChildViewById(r18, R.id.usage_graph);
        if (r110 == null) goto L31;
        return new UsageViewBinding((LinearLayout) r18, r5, r6, r7, r8, r9, r10, r11, r13, r15, r16, r17, r19, r110);
    L31:
        throw new NullPointerException("Missing required view with ID: ".concat(r18.getResources().getResourceName(r1)));
    }
}
