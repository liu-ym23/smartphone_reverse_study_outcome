package com.obric.safecheck.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.obric.safecheck.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ActivityGxbAntiFraudRulesBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final TextView tvGxbRulesContent;
    public final TextView tvGxbRulesSummary;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ActivityGxbAntiFraudRulesBinding(LinearLayout rootView, TextView tvGxbRulesContent, TextView tvGxbRulesSummary) {
        this.rootView = rootView;
        this.tvGxbRulesContent = tvGxbRulesContent;
        this.tvGxbRulesSummary = tvGxbRulesSummary;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityGxbAntiFraudRulesBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityGxbAntiFraudRulesBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View r2 = inflater.inflate(R.layout.activity_gxb_anti_fraud_rules, parent, false);
        if (attachToParent == false) goto L6;
        parent.addView(r2);
    L6:
        return bind(r2);
    }

    public static ActivityGxbAntiFraudRulesBinding bind(View rootView) {
        int r0 = R.id.tv_gxb_rules_content;
        TextView r1 = (TextView) ViewBindings.findChildViewById(rootView, r0);
        if (r1 == null) goto L9;
        r0 = R.id.tv_gxb_rules_summary;
        TextView r2 = (TextView) ViewBindings.findChildViewById(rootView, r0);
        if (r2 == null) goto L9;
        return new ActivityGxbAntiFraudRulesBinding((LinearLayout) rootView, r1, r2);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(r0)));
    }
}
