package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.bouncelayout.OListView;
import com.obric.oui.bouncelayout.OScrollView;
import obric.widget.ListContentItemSwitch;
import obric.widget.ListContentItemText;
import obric.widget.SettingItemText;

/* JADX INFO: loaded from: classes2.dex */
public final class DataUsageLayoutBinding implements ViewBinding {
    public final SettingItemText cardInfoBranch;
    public final SettingItemText cardInfoCarry;
    public final SettingItemText cardInfoCity;
    public final SettingItemText cardInfoProvince;
    public final ListContentItemSwitch dataUsageAlarmStub;
    public final OScrollView dataUsageHeaderScrollview;
    public final LinearLayout dataUsageHeaderView;
    public final ListContentItemText dataUsageLimitStub;
    public final TextView dataUsageLimitTipsStub;
    public final View div;
    public final LoadingViewBinding emptyView;
    public final OListView list;
    private final LinearLayout rootView;
    public final LinearLayout simGuideLayoutStub;
    public final ImageView simGuideStub;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private DataUsageLayoutBinding(LinearLayout r1, SettingItemText r2, SettingItemText r3, SettingItemText r4, SettingItemText r5, ListContentItemSwitch r6, OScrollView r7, LinearLayout r8, ListContentItemText r9, TextView r10, View r11, LoadingViewBinding r12, OListView r13, LinearLayout r14, ImageView r15) {
        this.rootView = r1;
        this.cardInfoBranch = r2;
        this.cardInfoCarry = r3;
        this.cardInfoCity = r4;
        this.cardInfoProvince = r5;
        this.dataUsageAlarmStub = r6;
        this.dataUsageHeaderScrollview = r7;
        this.dataUsageHeaderView = r8;
        this.dataUsageLimitStub = r9;
        this.dataUsageLimitTipsStub = r10;
        this.div = r11;
        this.emptyView = r12;
        this.list = r13;
        this.simGuideLayoutStub = r14;
        this.simGuideStub = r15;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static DataUsageLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static DataUsageLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.data_usage_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static DataUsageLayoutBinding bind(View r19) {
        int r1 = R.id.card_info_branch;
        SettingItemText r5 = (SettingItemText) ViewBindings.findChildViewById(r19, R.id.card_info_branch);
        if (r5 == null) goto L33;
        r1 = R.id.card_info_carry;
        SettingItemText r6 = (SettingItemText) ViewBindings.findChildViewById(r19, R.id.card_info_carry);
        if (r6 == null) goto L33;
        r1 = R.id.card_info_city;
        SettingItemText r7 = (SettingItemText) ViewBindings.findChildViewById(r19, R.id.card_info_city);
        if (r7 == null) goto L33;
        r1 = R.id.card_info_province;
        SettingItemText r8 = (SettingItemText) ViewBindings.findChildViewById(r19, R.id.card_info_province);
        if (r8 == null) goto L33;
        r1 = R.id.data_usage_alarm_stub;
        ListContentItemSwitch r9 = (ListContentItemSwitch) ViewBindings.findChildViewById(r19, R.id.data_usage_alarm_stub);
        if (r9 == null) goto L33;
        r1 = R.id.data_usage_header_scrollview;
        OScrollView r10 = (OScrollView) ViewBindings.findChildViewById(r19, R.id.data_usage_header_scrollview);
        if (r10 == null) goto L33;
        r1 = R.id.data_usage_header_view;
        LinearLayout r11 = (LinearLayout) ViewBindings.findChildViewById(r19, R.id.data_usage_header_view);
        if (r11 == null) goto L33;
        r1 = R.id.data_usage_limit_stub;
        ListContentItemText r12 = (ListContentItemText) ViewBindings.findChildViewById(r19, R.id.data_usage_limit_stub);
        if (r12 == null) goto L33;
        r1 = R.id.data_usage_limit_tips_stub;
        TextView r13 = (TextView) ViewBindings.findChildViewById(r19, R.id.data_usage_limit_tips_stub);
        if (r13 == null) goto L33;
        r1 = R.id.div;
        View r14 = ViewBindings.findChildViewById(r19, R.id.div);
        if (r14 == null) goto L33;
        r1 = R.id.empty_view;
        View r2 = ViewBindings.findChildViewById(r19, R.id.empty_view);
        if (r2 == null) goto L33;
        LoadingViewBinding r15 = LoadingViewBinding.bind(r2);
        r1 = android.R.id.list;
        OListView r16 = (OListView) ViewBindings.findChildViewById(r19, android.R.id.list);
        if (r16 == null) goto L33;
        r1 = R.id.sim_guide_layout_stub;
        LinearLayout r17 = (LinearLayout) ViewBindings.findChildViewById(r19, R.id.sim_guide_layout_stub);
        if (r17 == null) goto L33;
        r1 = R.id.sim_guide_stub;
        ImageView r18 = (ImageView) ViewBindings.findChildViewById(r19, R.id.sim_guide_stub);
        if (r18 == null) goto L33;
        return new DataUsageLayoutBinding((LinearLayout) r19, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18);
    L33:
        throw new NullPointerException("Missing required view with ID: ".concat(r19.getResources().getResourceName(r1)));
    }
}
