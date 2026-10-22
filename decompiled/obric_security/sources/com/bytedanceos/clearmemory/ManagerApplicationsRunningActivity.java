package com.bytedanceos.clearmemory;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import com.android.calendar.privacy.GrantUtil;
import com.bytedanceos.cloud.PreferenceMgr;
import com.bytedanceos.security.BaseActivity;
import com.obric.security.R;
import com.obric.security.cleanerpage.ApplicationsRunningViewModel;

/* JADX INFO: loaded from: classes2.dex */
public class ManagerApplicationsRunningActivity extends BaseActivity {
    private boolean isPause;
    private View mLoading;
    private PreferenceMgr mPreferenceMgr;
    final Runnable mRunningProcessesAvail;
    private RunningProcessesView mRunningProcessesView;
    private ApplicationsRunningViewModel viewModel;

    @Override // com.bytedanceos.security.BaseActivity
    public String scene() {
        return "memory_clean_page";
    }

    public ManagerApplicationsRunningActivity() {
        this.isPause = false;
        this.mRunningProcessesAvail = new AnonymousClass2(this);
    }

    static /* synthetic */ RunningProcessesView access$000(ManagerApplicationsRunningActivity r0) {
        return r0.mRunningProcessesView;
    }

    @Override // com.bytedanceos.security.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manage_applications_running);
        this.viewModel = ApplicationsRunningViewModel.Companion.getManagerApplicationsRunningActivity(this);
        RunningProcessesView r4 = (RunningProcessesView) findViewById(R.id.running_processes);
        this.mRunningProcessesView = r4;
        updateViewWidth(r4);
        if (getIntent().getStringExtra("from") == null) goto L5;
        String r5 = getIntent().getStringExtra("from");
    L6:
        Boolean r0 = Boolean.valueOf(getIntent().getBooleanExtra("force_show_privacy_dialog", false));
        View r1 = findViewById(R.id.loading_container);
        this.mLoading = r1;
        if (r1 == null) goto L9;
        r1.setVisibility(0);
    L9:
        initTitleBar(false, false);
        this.mPreferenceMgr = PreferenceMgr.getInstance(this);
        initObserve();
        this.viewModel.popPermissionDialogIfNeeded(this, this.mPreferenceMgr.isAllowed(), r5, r0.booleanValue());
        getWindow();
        return;
    L5:
        r5 = "";
        goto L6
    }

    private void initObserve() {
        this.viewModel.getAgreeGrant().observe(this, new ManagerApplicationsRunningActivity$$ExternalSyntheticLambda0(this));
    }

    /* JADX INFO: renamed from: lambda$initObserve$0$com-bytedanceos-clearmemory-ManagerApplicationsRunningActivity, reason: not valid java name */
    /* synthetic */ void m86x585e6610(Boolean r1) {
        if (r1.booleanValue() == false) goto L5;
        this.mRunningProcessesView.doCreate();
        doResume();
        return;
    L5:
        finish();
    }

    @Override // com.bytedanceos.security.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (this.mPreferenceMgr.isAllowed() == true) goto L7;
        if (this.mPreferenceMgr.getIsAllowedFromUid(GrantUtil.securitymanager) == true) goto L7;
    L9:
        this.isPause = false;
        return;
    L7:
        if (this.isPause == false) goto L9;
        doResume();
        goto L9
    }

    private void doResume() {
        this.mRunningProcessesView.postDelayed(new AnonymousClass1(this), 200);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        if (this.mPreferenceMgr.isAllowed() == false) goto L5;
    L6:
        RunningProcessesView r0 = this.mRunningProcessesView;
        if (r0 == null) goto L9;
        r0.doPause();
    L9:
        this.isPause = true;
        return;
    L5:
        if (this.mPreferenceMgr.getIsAllowedFromUid(GrantUtil.securitymanager) == false) goto L9;
        goto L6
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
    }

    @Override // com.bytedanceos.security.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (this.mPreferenceMgr.isAllowed() == false) goto L5;
    L6:
        RunningProcessesView r2 = this.mRunningProcessesView;
        if (r2 == null) goto L11;
        r2.doDestroy();
        return;
    L11:
        return;
    L5:
        if (this.mPreferenceMgr.getIsAllowedFromUid(GrantUtil.securitymanager) == true) goto L6;
    }

    @Override // android.app.Activity
    protected void onChildTitleChanged(Activity childActivity, CharSequence title) {
        super.onChildTitleChanged(childActivity, title);
    }

    @Override // com.bytedanceos.security.BaseActivity, android.app.Activity
    public void finish() {
        Intent r0 = new Intent();
        r0.putExtra("hasClean", this.mRunningProcessesView.hasClean());
        setResult(-1, r0);
        super.finish();
    }

    void handleRunningProcessesAvail() {
        this.mRunningProcessesView.setVisibility(0);
        this.mLoading.setVisibility(8);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        updateViewWidth(this.mRunningProcessesView);
    }
}
