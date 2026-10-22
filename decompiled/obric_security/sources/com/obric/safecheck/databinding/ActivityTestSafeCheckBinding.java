package com.obric.safecheck.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.obric.safecheck.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ActivityTestSafeCheckBinding implements ViewBinding {
    public final EditText apkBlackPath;
    public final EditText apkInfoPath;
    public final EditText apkPath;
    public final EditText apkRisk;
    public final EditText apkTime;
    public final EditText blackPhoneTv;
    public final Button btnCheckApk;
    public final Button btnCheckApkWithInfo;
    public final Button btnCheckPhone;
    public final Button btnCheckUrl;
    public final Button btnCopyApkInfo;
    public final Button btnDumpGxbRules;
    public final Button btnGxbInsertRule;
    public final Button btnGxbInstallable;
    public final Button btnShowApkInfo;
    public final Button delete;
    public final EditText deleteTime;
    public final Button endTime;
    public final Button fetch;
    public final EditText fetchTime;
    public final EditText gxbInsertApkPath;
    public final EditText gxbInsertRuleNo;
    public final EditText gxbInsertRuleType;
    public final EditText gxbInstallableAppMd5;
    public final EditText gxbInstallablePkg;
    public final EditText gxbInstallableSignMd5;
    public final EditText gxbInstallableSignSha1;
    public final EditText gxbInstallableSignSha256;
    public final Button insertApkDb;
    public final Button insertPhoneDb;
    public final Button insertUrlDb;
    public final EditText phoneTime;
    public final EditText phoneTv;
    private final ScrollView rootView;
    public final EditText testApkPath;
    public final EditText testApkPkg;
    public final EditText testPhoneInput;
    public final EditText testUrlInput;
    public final TextView tvApkInfoResult;
    public final TextView tvTestResult;
    public final EditText urlBlackPath;
    public final EditText urlPath;
    public final EditText urlRisk;
    public final EditText urlTime;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ActivityTestSafeCheckBinding(ScrollView rootView, EditText apkBlackPath, EditText apkInfoPath, EditText apkPath, EditText apkRisk, EditText apkTime, EditText blackPhoneTv, Button btnCheckApk, Button btnCheckApkWithInfo, Button btnCheckPhone, Button btnCheckUrl, Button btnCopyApkInfo, Button btnDumpGxbRules, Button btnGxbInsertRule, Button btnGxbInstallable, Button btnShowApkInfo, Button delete, EditText deleteTime, Button endTime, Button fetch, EditText fetchTime, EditText gxbInsertApkPath, EditText gxbInsertRuleNo, EditText gxbInsertRuleType, EditText gxbInstallableAppMd5, EditText gxbInstallablePkg, EditText gxbInstallableSignMd5, EditText gxbInstallableSignSha1, EditText gxbInstallableSignSha256, Button insertApkDb, Button insertPhoneDb, Button insertUrlDb, EditText phoneTime, EditText phoneTv, EditText testApkPath, EditText testApkPkg, EditText testPhoneInput, EditText testUrlInput, TextView tvApkInfoResult, TextView tvTestResult, EditText urlBlackPath, EditText urlPath, EditText urlRisk, EditText urlTime) {
        this.rootView = rootView;
        this.apkBlackPath = apkBlackPath;
        this.apkInfoPath = apkInfoPath;
        this.apkPath = apkPath;
        this.apkRisk = apkRisk;
        this.apkTime = apkTime;
        this.blackPhoneTv = blackPhoneTv;
        this.btnCheckApk = btnCheckApk;
        this.btnCheckApkWithInfo = btnCheckApkWithInfo;
        this.btnCheckPhone = btnCheckPhone;
        this.btnCheckUrl = btnCheckUrl;
        this.btnCopyApkInfo = btnCopyApkInfo;
        this.btnDumpGxbRules = btnDumpGxbRules;
        this.btnGxbInsertRule = btnGxbInsertRule;
        this.btnGxbInstallable = btnGxbInstallable;
        this.btnShowApkInfo = btnShowApkInfo;
        this.delete = delete;
        this.deleteTime = deleteTime;
        this.endTime = endTime;
        this.fetch = fetch;
        this.fetchTime = fetchTime;
        this.gxbInsertApkPath = gxbInsertApkPath;
        this.gxbInsertRuleNo = gxbInsertRuleNo;
        this.gxbInsertRuleType = gxbInsertRuleType;
        this.gxbInstallableAppMd5 = gxbInstallableAppMd5;
        this.gxbInstallablePkg = gxbInstallablePkg;
        this.gxbInstallableSignMd5 = gxbInstallableSignMd5;
        this.gxbInstallableSignSha1 = gxbInstallableSignSha1;
        this.gxbInstallableSignSha256 = gxbInstallableSignSha256;
        this.insertApkDb = insertApkDb;
        this.insertPhoneDb = insertPhoneDb;
        this.insertUrlDb = insertUrlDb;
        this.phoneTime = phoneTime;
        this.phoneTv = phoneTv;
        this.testApkPath = testApkPath;
        this.testApkPkg = testApkPkg;
        this.testPhoneInput = testPhoneInput;
        this.testUrlInput = testUrlInput;
        this.tvApkInfoResult = tvApkInfoResult;
        this.tvTestResult = tvTestResult;
        this.urlBlackPath = urlBlackPath;
        this.urlPath = urlPath;
        this.urlRisk = urlRisk;
        this.urlTime = urlTime;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ScrollView getRoot() {
        return this.rootView;
    }

    public static ActivityTestSafeCheckBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityTestSafeCheckBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View r2 = inflater.inflate(R.layout.activity_test_safe_check, parent, false);
        if (attachToParent == false) goto L6;
        parent.addView(r2);
    L6:
        return bind(r2);
    }

    public static ActivityTestSafeCheckBinding bind(View rootView) {
        int r1 = R.id.apk_black_path;
        EditText r5 = (EditText) ViewBindings.findChildViewById(rootView, r1);
        if (r5 == null) goto L91;
        r1 = R.id.apk_info_path;
        EditText r6 = (EditText) ViewBindings.findChildViewById(rootView, r1);
        if (r6 == null) goto L91;
        r1 = R.id.apk_path;
        EditText r7 = (EditText) ViewBindings.findChildViewById(rootView, r1);
        if (r7 == null) goto L91;
        r1 = R.id.apk_risk;
        EditText r8 = (EditText) ViewBindings.findChildViewById(rootView, r1);
        if (r8 == null) goto L91;
        r1 = R.id.apk_time;
        EditText r9 = (EditText) ViewBindings.findChildViewById(rootView, r1);
        if (r9 == null) goto L91;
        r1 = R.id.black_phone_tv;
        EditText r10 = (EditText) ViewBindings.findChildViewById(rootView, r1);
        if (r10 == null) goto L91;
        r1 = R.id.btn_check_apk;
        Button r11 = (Button) ViewBindings.findChildViewById(rootView, r1);
        if (r11 == null) goto L91;
        r1 = R.id.btn_check_apk_with_info;
        Button r12 = (Button) ViewBindings.findChildViewById(rootView, r1);
        if (r12 == null) goto L91;
        r1 = R.id.btn_check_phone;
        Button r13 = (Button) ViewBindings.findChildViewById(rootView, r1);
        if (r13 == null) goto L91;
        r1 = R.id.btn_check_url;
        Button r14 = (Button) ViewBindings.findChildViewById(rootView, r1);
        if (r14 == null) goto L91;
        r1 = R.id.btn_copy_apk_info;
        Button r15 = (Button) ViewBindings.findChildViewById(rootView, r1);
        if (r15 == null) goto L91;
        r1 = R.id.btn_dump_gxb_rules;
        Button r16 = (Button) ViewBindings.findChildViewById(rootView, r1);
        if (r16 == null) goto L91;
        r1 = R.id.btn_gxb_insert_rule;
        Button r17 = (Button) ViewBindings.findChildViewById(rootView, r1);
        if (r17 == null) goto L91;
        r1 = R.id.btn_gxb_installable;
        Button r18 = (Button) ViewBindings.findChildViewById(rootView, r1);
        if (r18 == null) goto L91;
        r1 = R.id.btn_show_apk_info;
        Button r19 = (Button) ViewBindings.findChildViewById(rootView, r1);
        if (r19 == null) goto L91;
        r1 = R.id.delete;
        Button r20 = (Button) ViewBindings.findChildViewById(rootView, r1);
        if (r20 == null) goto L91;
        r1 = R.id.delete_time;
        EditText r21 = (EditText) ViewBindings.findChildViewById(rootView, r1);
        if (r21 == null) goto L91;
        r1 = R.id.end_time;
        Button r22 = (Button) ViewBindings.findChildViewById(rootView, r1);
        if (r22 == null) goto L91;
        r1 = R.id.fetch;
        Button r23 = (Button) ViewBindings.findChildViewById(rootView, r1);
        if (r23 == null) goto L91;
        r1 = R.id.fetch_time;
        EditText r24 = (EditText) ViewBindings.findChildViewById(rootView, r1);
        if (r24 == null) goto L91;
        r1 = R.id.gxb_insert_apk_path;
        EditText r25 = (EditText) ViewBindings.findChildViewById(rootView, r1);
        if (r25 == null) goto L91;
        r1 = R.id.gxb_insert_rule_no;
        EditText r26 = (EditText) ViewBindings.findChildViewById(rootView, r1);
        if (r26 == null) goto L91;
        r1 = R.id.gxb_insert_rule_type;
        EditText r27 = (EditText) ViewBindings.findChildViewById(rootView, r1);
        if (r27 == null) goto L91;
        r1 = R.id.gxb_installable_app_md5;
        EditText r28 = (EditText) ViewBindings.findChildViewById(rootView, r1);
        if (r28 == null) goto L91;
        r1 = R.id.gxb_installable_pkg;
        EditText r29 = (EditText) ViewBindings.findChildViewById(rootView, r1);
        if (r29 == null) goto L91;
        r1 = R.id.gxb_installable_sign_md5;
        EditText r30 = (EditText) ViewBindings.findChildViewById(rootView, r1);
        if (r30 == null) goto L91;
        r1 = R.id.gxb_installable_sign_sha1;
        EditText r31 = (EditText) ViewBindings.findChildViewById(rootView, r1);
        if (r31 == null) goto L91;
        r1 = R.id.gxb_installable_sign_sha256;
        EditText r32 = (EditText) ViewBindings.findChildViewById(rootView, r1);
        if (r32 == null) goto L91;
        r1 = R.id.insert_apk_db;
        Button r33 = (Button) ViewBindings.findChildViewById(rootView, r1);
        if (r33 == null) goto L91;
        r1 = R.id.insert_phone_db;
        Button r34 = (Button) ViewBindings.findChildViewById(rootView, r1);
        if (r34 == null) goto L91;
        r1 = R.id.insert_url_db;
        Button r35 = (Button) ViewBindings.findChildViewById(rootView, r1);
        if (r35 == null) goto L91;
        r1 = R.id.phone_time;
        EditText r36 = (EditText) ViewBindings.findChildViewById(rootView, r1);
        if (r36 == null) goto L91;
        r1 = R.id.phone_tv;
        EditText r37 = (EditText) ViewBindings.findChildViewById(rootView, r1);
        if (r37 == null) goto L91;
        r1 = R.id.test_apk_path;
        EditText r38 = (EditText) ViewBindings.findChildViewById(rootView, r1);
        if (r38 == null) goto L91;
        r1 = R.id.test_apk_pkg;
        EditText r39 = (EditText) ViewBindings.findChildViewById(rootView, r1);
        if (r39 == null) goto L91;
        r1 = R.id.test_phone_input;
        EditText r40 = (EditText) ViewBindings.findChildViewById(rootView, r1);
        if (r40 == null) goto L91;
        r1 = R.id.test_url_input;
        EditText r41 = (EditText) ViewBindings.findChildViewById(rootView, r1);
        if (r41 == null) goto L91;
        r1 = R.id.tv_apk_info_result;
        TextView r42 = (TextView) ViewBindings.findChildViewById(rootView, r1);
        if (r42 == null) goto L91;
        r1 = R.id.tv_test_result;
        TextView r43 = (TextView) ViewBindings.findChildViewById(rootView, r1);
        if (r43 == null) goto L91;
        r1 = R.id.url_black_path;
        EditText r44 = (EditText) ViewBindings.findChildViewById(rootView, r1);
        if (r44 == null) goto L91;
        r1 = R.id.url_path;
        EditText r45 = (EditText) ViewBindings.findChildViewById(rootView, r1);
        if (r45 == null) goto L91;
        r1 = R.id.url_risk;
        EditText r46 = (EditText) ViewBindings.findChildViewById(rootView, r1);
        if (r46 == null) goto L91;
        r1 = R.id.url_time;
        EditText r47 = (EditText) ViewBindings.findChildViewById(rootView, r1);
        if (r47 == null) goto L91;
        return new ActivityTestSafeCheckBinding((ScrollView) rootView, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47);
    L91:
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(r1)));
    }
}
