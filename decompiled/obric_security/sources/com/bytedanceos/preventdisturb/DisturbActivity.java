package com.bytedanceos.preventdisturb;

import android.app.FragmentManager;
import android.content.ComponentName;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import bytedanceos.util.LogTag;
import com.android.calendar.privacy.GrantUtil;
import com.bytedance.tracing.internal.TracingConstants;
import com.bytedanceos.cloud.PreferenceMgr;
import com.bytedanceos.security.BaseActivity;
import com.bytedanceos.security.Utils;
import com.bytedanceos.utils.Constants;
import com.obric.oui.button.OIconButton;
import com.obric.oui.segmentedtab.OTabSegmentedLayout;
import com.obric.security.R;
import com.obric.security.cleanerpage.DisturbViewModel;
import com.obric.security.monitor.PerformanceScenes;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class DisturbActivity extends BaseActivity implements BlackCallLogList.BlackListCallItemClickListener, SpamConversationList.ConversationListItemClickListener {
    public static final String CALL_PHONE_NUMBER = "call_phone_number";
    public static final String KEY_BLACK_ID = "blackid";
    public static final String TAG = "DisturbActivity";
    private int animInLeft;
    private int animInRight;
    private int animOutLeft;
    private int animOutRight;
    private BlackCallLogList mCallFragment;
    private OTabSegmentedLayout mCycleView;
    private FragmentManager mFragmentManager;
    private boolean mHasSmsTab;
    private SpamConversationList mSmsFragment;
    private ImageView mTitlebarRightImg;
    private DisturbViewModel viewModel;

    @Override // com.bytedanceos.security.BaseActivity
    protected boolean enablePerformanceActivityResumePeriod() {
        return true;
    }

    @Override // com.bytedanceos.security.BaseActivity
    protected String performancePageScene() {
        return PerformanceScenes.PAGE_PERMISSION_DISTURB;
    }

    public DisturbActivity() {
    }

    static /* synthetic */ FragmentManager access$000(DisturbActivity r0) {
        return r0.mFragmentManager;
    }

    static /* synthetic */ SpamConversationList access$100(DisturbActivity r0) {
        return r0.mSmsFragment;
    }

    static /* synthetic */ SpamConversationList access$102(DisturbActivity r0, SpamConversationList r1) {
        r0.mSmsFragment = r1;
        return r1;
    }

    static /* synthetic */ BlackCallLogList access$200(DisturbActivity r0) {
        return r0.mCallFragment;
    }

    static /* synthetic */ BlackCallLogList access$202(DisturbActivity r0, BlackCallLogList r1) {
        r0.mCallFragment = r1;
        return r1;
    }

    @Override // com.bytedanceos.security.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.disturb_layout);
        this.mCycleView = (OTabSegmentedLayout) findViewById(R.id.cycle_view);
        boolean r6 = getResources().getBoolean(R.bool.disturb_has_sms_tab);
        this.mHasSmsTab = r6;
        if (r6 == true) goto L9;
        OTabSegmentedLayout r7 = this.mCycleView;
        if (r7 == null) goto L9;
        r7.setVisibility(8);
        View r8 = findViewById(R.id.id_fragment_disturb);
        if (r8 == null) goto L9;
        RelativeLayout.LayoutParams r1 = (RelativeLayout.LayoutParams) r8.getLayoutParams();
        r1.addRule(3, R.id.title_bar);
        r8.setLayoutParams(r1);
    L9:
        this.viewModel = DisturbViewModel.Companion.getDisturbViewModel(this);
        initObserve();
        String r9 = getIntent().getStringExtra("from");
        if (r9 != null) goto L13;
        r9 = "";
    L13:
        if (GrantUtil.INSTANCE.isAllowed(this, r9, false) == true) goto L15;
        this.viewModel.popPermissionDialogIfNeeded(this, PreferenceMgr.getInstance(this).isAllowed(), r9);
    L15:
        BlackCallLogList r10 = new BlackCallLogList();
        this.mCallFragment = r10;
        r10.resetListView();
        this.mCallFragment.setListener(this);
        if (this.mHasSmsTab == false) goto L18;
        SpamConversationList r11 = new SpamConversationList();
        this.mSmsFragment = r11;
        r11.resetListView();
        this.mSmsFragment.setListener(this);
    L18:
        this.mFragmentManager = getFragmentManager();
        if (PreferenceMgr.getInstance(this).isAllowed() == true) goto L23;
        if (PreferenceMgr.getInstance(this).getIsAllowedFromUid(GrantUtil.securitymanager) == true) goto L23;
    L30:
        this.animInLeft = Utils.getSMTResouceId(this, "bytedanceos", "slide_in_from_left", "anim", R.anim.slide_in_from_left);
        this.animInRight = Utils.getSMTResouceId(this, "bytedanceos", "slide_in_from_right", "anim", R.anim.slide_in_from_right);
        this.animOutLeft = Utils.getSMTResouceId(this, "bytedanceos", "slide_out_to_left", "anim", R.anim.slide_out_to_left);
        this.animOutRight = Utils.getSMTResouceId(this, "bytedanceos", "slide_out_to_right", "anim", R.anim.slide_out_to_right);
        initTitleBar(false);
        int r12 = getResources().getDimensionPixelSize(R.dimen.dimen_44);
        int r0 = getResources().getDimensionPixelSize(R.dimen.dimen_32);
        this.mTitlebarRightImg = (OIconButton) getLayoutInflater().inflate(R.layout.f_oic_icon_button, this.mTitle, false);
        LinearLayout.LayoutParams r2 = new LinearLayout.LayoutParams(r12, r0);
        this.mTitlebarRightImg.setLayoutParams(r2);
        this.mTitlebarRightImg.setImageResource(R.drawable.oic_disturb_settings);
        this.mTitle.addEndAction(R.drawable.oic_disturb_settings, -1, new AnonymousClass1(this));
        return;
    L23:
        if (this.mHasSmsTab == true) goto L25;
    L29:
        this.mFragmentManager.beginTransaction().replace(R.id.id_fragment_disturb, this.mCallFragment).commitAllowingStateLoss();
        goto L30
    L25:
        if (this.mSmsFragment == null) goto L29;
        this.mFragmentManager.beginTransaction().replace(R.id.id_fragment_disturb, this.mSmsFragment).show(this.mSmsFragment).commitAllowingStateLoss();
        OTabSegmentedLayout r13 = this.mCycleView;
        if (r13 == null) goto L30;
        addButtonTab(r13);
        goto L30
    }

    private void initObserve() {
        this.viewModel.getAgreeGrant().observe(this, new DisturbActivity$$ExternalSyntheticLambda0(this));
    }

    /* JADX INFO: renamed from: lambda$initObserve$0$com-bytedanceos-preventdisturb-DisturbActivity, reason: not valid java name */
    /* synthetic */ void m116x2841965b(Boolean r3) {
        if (r3.booleanValue() == true) goto L5;
        finish();
        return;
    L5:
        if (this.mHasSmsTab == true) goto L7;
        this.mFragmentManager.beginTransaction().replace(R.id.id_fragment_disturb, this.mCallFragment).commitAllowingStateLoss();
        return;
    L7:
        if (this.mSmsFragment != null) goto L9;
        SpamConversationList r4 = new SpamConversationList();
        this.mSmsFragment = r4;
        r4.setListener(this);
    L9:
        this.mFragmentManager.beginTransaction().replace(R.id.id_fragment_disturb, this.mSmsFragment).show(this.mSmsFragment).commitAllowingStateLoss();
        OTabSegmentedLayout r5 = this.mCycleView;
        if (r5 == null) goto L15;
        addButtonTab(r5);
        return;
    }

    private void addButtonTab(OTabSegmentedLayout bar) {
        String[] r0 = createButtonTabGroup();
        if (r0 != null) goto L5;
        return;
    L5:
        bar.setTabTitleAndDrawable(r0, null);
        bar.setOnTabSelectListener(new AnonymousClass2(this));
        bar.setCurrentTab(0);
    }

    private String[] createButtonTabGroup() {
        ArrayList r0 = new ArrayList();
        r0.add(getResources().getString(R.string.mms_tab_title));
        r0.add(getResources().getString(R.string.call_tab_title));
        if (r0.isEmpty() == false) goto L6;
        return null;
    L6:
        String[] r3 = new String[r0.size()];
        int r1 = 0;
    L8:
        if (r1 >= r0.size()) goto L10;
        r3[r1] = (String) r0.get(r1);
        r1 = r1 + 1;
        goto L8
    L10:
        return r3;
    }

    @Override // com.bytedanceos.security.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != (-1)) goto L6;
        finish();
        return;
    }

    @Override // com.bytedanceos.preventdisturb.BlackCallLogList.BlackListCallItemClickListener
    public void onCallListItemClick(int key) {
        LogTag.d(TAG, "onCallListItemClick is called key " + key);
        ComponentName r0 = new ComponentName("com.obric.security", "com.obric.securitycenter.nodisturb.InterceptDetailActivity");
        Intent r1 = new Intent();
        r1.setComponent(r0);
        r1.putExtra("blackid", key);
        r1.putExtra(Utils.INTENT_KEY_FROM_CENTER, isFromSecurityCenter());
        r1.putExtra(Constants.EXTRA_BYTEDANCE_ANIM_RESOURCE_ID, new int[]{this.animInLeft, this.animOutRight});
        startActivity(r1);
    }

    @Override // com.bytedanceos.preventdisturb.SpamConversationList.ConversationListItemClickListener
    public void onConversationListItemClick(long key, String activityName) {
        Intent r0 = new Intent();
        r0.setComponent(new ComponentName("com.android.mms", activityName));
        r0.putExtra(TracingConstants.KEY_THREAD_NAME, key);
        r0.putExtra(Utils.INTENT_KEY_FROM_CENTER, isFromSecurityCenter());
        r0.putExtra(Constants.EXTRA_BYTEDANCE_ANIM_RESOURCE_ID, new int[]{this.animInLeft, this.animOutRight});
        startActivity(r0);
    }

    @Override // com.bytedanceos.security.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        BlackCallLogList r0 = this.mCallFragment;
        if (r0 == null) goto L5;
        r0.setListener(null);
    L5:
        SpamConversationList r2 = this.mSmsFragment;
        if (r2 == null) goto L9;
        r2.setListener(null);
        return;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        Contact.invalidateCache();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override // com.bytedanceos.security.BaseActivity, android.app.Activity
    public void finish() {
        super.finish();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
    }
}
