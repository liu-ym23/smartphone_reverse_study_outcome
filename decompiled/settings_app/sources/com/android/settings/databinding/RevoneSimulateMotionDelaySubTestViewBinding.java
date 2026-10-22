package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.android.settings.widget.SimulateMotionDelaySubTestView;
import com.obric.oui.button.OButton;

/* JADX INFO: loaded from: classes2.dex */
public final class RevoneSimulateMotionDelaySubTestViewBinding implements ViewBinding {
    public final SimulateMotionDelaySubTestView.SubListView badCaseList;
    public final OButton btnSubResultConfirm;
    public final SimulateMotionDelaySubTestView.SubListView overallFeelList;
    private final SimulateMotionDelaySubTestView rootView;
    public final LinearLayout subTestResult;
    public final TextView subTestTips;
    public final TextView subTestTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private RevoneSimulateMotionDelaySubTestViewBinding(SimulateMotionDelaySubTestView r1, SimulateMotionDelaySubTestView.SubListView r2, OButton r3, SimulateMotionDelaySubTestView.SubListView r4, LinearLayout r5, TextView r6, TextView r7) {
        this.rootView = r1;
        this.badCaseList = r2;
        this.btnSubResultConfirm = r3;
        this.overallFeelList = r4;
        this.subTestResult = r5;
        this.subTestTips = r6;
        this.subTestTitle = r7;
    }

    @Override // androidx.viewbinding.ViewBinding
    public SimulateMotionDelaySubTestView getRoot() {
        return this.rootView;
    }

    public static RevoneSimulateMotionDelaySubTestViewBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static RevoneSimulateMotionDelaySubTestViewBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.revone_simulate_motion_delay_sub_test_view, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static RevoneSimulateMotionDelaySubTestViewBinding bind(View r10) {
        int r0 = R.id.bad_case_list;
        SimulateMotionDelaySubTestView.SubListView r4 = (SimulateMotionDelaySubTestView.SubListView) ViewBindings.findChildViewById(r10, R.id.bad_case_list);
        if (r4 == null) goto L17;
        r0 = R.id.btn_sub_result_confirm;
        OButton r5 = (OButton) ViewBindings.findChildViewById(r10, R.id.btn_sub_result_confirm);
        if (r5 == null) goto L17;
        r0 = R.id.overall_feel_list;
        SimulateMotionDelaySubTestView.SubListView r6 = (SimulateMotionDelaySubTestView.SubListView) ViewBindings.findChildViewById(r10, R.id.overall_feel_list);
        if (r6 == null) goto L17;
        r0 = R.id.sub_test_result;
        LinearLayout r7 = (LinearLayout) ViewBindings.findChildViewById(r10, R.id.sub_test_result);
        if (r7 == null) goto L17;
        r0 = R.id.sub_test_tips;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r10, R.id.sub_test_tips);
        if (r8 == null) goto L17;
        r0 = R.id.sub_test_title;
        TextView r9 = (TextView) ViewBindings.findChildViewById(r10, R.id.sub_test_title);
        if (r9 == null) goto L17;
        return new RevoneSimulateMotionDelaySubTestViewBinding((SimulateMotionDelaySubTestView) r10, r4, r5, r6, r7, r8, r9);
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r0)));
    }
}
