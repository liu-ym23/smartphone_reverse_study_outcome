package com.android.settings.applications;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import bytedanceos.api.PackageManagerSmt;
import bytedanceos.util.SettingsUtil;
import com.android.settings.LauncherSettingsFragment;
import com.android.settings.R;
import com.android.settings.SettingsAdapter;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.HanziToPinyin;
import com.android.settings.widget.SettingItemButton;
import com.obric.olog.OLog;
import com.obric.oui.dialog.v2.alert.OAlertDialog;
import com.obric.oui.dialog.v2.alert.OAlertDialogBuilder;
import com.obric.oui.lisitem.OListItemSettings;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import settings.PreferredActivityChooseUtils;

/* JADX INFO: loaded from: classes2.dex */
public class PreferredActivityChooserFragment extends BaseFragment {
    private static final String EXTRA_DISABLE_FINGER_PRINT = "disable_finger_print";
    public static final int REQ_VERIFY_LAUNCHER_PASSWORD = 10;
    private PreferredActivityAdapter mAdapter;
    private PreferredActivityChooseUtils mChooseUtils;
    private SettingItemButton mClearPreferredSettings;
    ComponentName[] mComponentSet;
    private boolean mDialogConfirmOk;
    private List<ResolveInfo> mFullResolveInfoList;
    private final Handler mHandler;
    private IntentFilter mIntentFilter;
    private boolean mIsHomeCategory;
    AdapterView.OnItemClickListener mItemClickListener;
    private ComponentName mLastPreferredActivity;
    private OAlertDialog mLauncherSwitchDialog;
    private ListView mListView;
    private ComponentName mPendingActivity;
    private PackageManager mPm;
    private ComponentName mPreferredActivity;
    private Intent mPreferredIntent;
    private List<ResolveInfo> mResolveInfoList;
    private TextView mTextView1;
    private TextView mTextView3;

    class PreferredActivityAdapter extends SettingsAdapter {
        private Context mContext;
        final /* synthetic */ PreferredActivityChooserFragment this$0;

        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            return false;
        }

        public PreferredActivityAdapter(PreferredActivityChooserFragment r1, Context r2) {
            this.this$0 = r1;
            this.mContext = r2;
        }

        @Override // com.android.settings.SettingsAdapter, android.widget.Adapter
        public int getCount() {
            return PreferredActivityChooserFragment.access$200(this.this$0).size();
        }

        @Override // com.android.settings.SettingsAdapter, android.widget.Adapter
        public View getView(int r6, View r7, ViewGroup r8) {
            if (r7 != null) goto L5;
            r7 = View.inflate(this.mContext, R.layout.list_content_item_check_oui_with_icon, null);
            OListItemSettings r0 = (OListItemSettings) r7.findViewById(R.id.item_check);
            r7.setTag(r0);
        L6:
            ResolveInfo r9 = (ResolveInfo) PreferredActivityChooserFragment.access$200(this.this$0).get(r6);
            CharSequence r1 = r9.activityInfo.applicationInfo.loadLabel(PreferredActivityChooserFragment.access$300(this.this$0));
            CharSequence r2 = r9.loadLabel(PreferredActivityChooserFragment.access$300(this.this$0));
            if (PreferredActivityChooserFragment.access$400(this.this$0) == false) goto L12;
            String r3 = r9.activityInfo.packageName;
            r3.hashCode();
            if (r3.equals("com.bytedanceos.launcher") == true) goto L11;
            r0.setTitleString(r1);
            r0.mIvContent.setImageDrawable(r9.loadIcon(PreferredActivityChooserFragment.access$300(this.this$0)));
        L13:
            if (r2 == null) goto L15;
            String r4 = r2.toString().replaceAll("\\p{C}", "").replaceAll("\\p{Z}", HanziToPinyin.Token.SEPARATOR).trim();
        L17:
            if (r1.equals(r4) == true) goto L19;
            r0.setSubTitleString(r4);
        L20:
            ComponentName r10 = new ComponentName(r9.activityInfo.packageName, r9.activityInfo.name);
            ImageView r11 = new ImageView(this.mContext);
            r11.setImageResource(R.drawable.icon_check_confirm_rounded);
            r0.setTrailingView(r11);
            if (r10.equals(PreferredActivityChooserFragment.access$500(this.this$0)) == false) goto L23;
            r0.mTrailingElement.setVisibility(0);
        L24:
            return r7;
        L23:
            r0.mTrailingElement.setVisibility(4);
            goto L24
        L19:
            r0.setSubTitleString(null);
            goto L20
        L15:
            r4 = null;
            goto L17
        L11:
            r0.setTitleString(this.mContext.getString(R.string.bytedance_desktop_title));
            r0.mIvContent.setImageResource(R.drawable.bytedance_home);
            r0.setEnabled(!SettingsUtil.isAccessibilityEnabled(this.mContext));
            goto L13
        L12:
            r0.setTitleString(r1);
            r0.mIvContent.setImageDrawable(r9.loadIcon(PreferredActivityChooserFragment.access$300(this.this$0)));
            goto L13
        L5:
            r0 = (OListItemSettings) r7.getTag();
            goto L6
        }

        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
        public boolean isEnabled(int r4) {
            ResolveInfo r0 = (ResolveInfo) PreferredActivityChooserFragment.access$200(this.this$0).get(r4);
            boolean r1 = SettingsUtil.isAccessibilityEnabled(this.mContext);
            if (r0.activityInfo.packageName.equals("com.bytedanceos.launcher") == false) goto L8;
            if (r1 == false) goto L8;
            return false;
        L8:
            return super.isEnabled(r4);
        }
    }

    public void com_android_settings_applications_PreferredActivityChooserFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_applications_PreferredActivityChooserFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_applications_PreferredActivityChooserFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_applications_PreferredActivityChooserFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    @Override // com.android.settings.base.BaseFragment
    protected boolean shouldMonitorExtDisplayStatus() {
        return true;
    }

    public PreferredActivityChooserFragment() {
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mResolveInfoList = new ArrayList();
        this.mFullResolveInfoList = new ArrayList();
        this.mItemClickListener = new AnonymousClass2(this);
    }

    static /* synthetic */ Intent access$000(PreferredActivityChooserFragment r0) {
        return r0.mPreferredIntent;
    }

    static /* synthetic */ void access$100(PreferredActivityChooserFragment r0, Intent r1) {
        r0.clearPreferredActivities(r1);
    }

    static /* synthetic */ PreferredActivityAdapter access$1000(PreferredActivityChooserFragment r0) {
        return r0.mAdapter;
    }

    static /* synthetic */ SettingItemButton access$1100(PreferredActivityChooserFragment r0) {
        return r0.mClearPreferredSettings;
    }

    static /* synthetic */ boolean access$1200(PreferredActivityChooserFragment r0) {
        return r0.mDialogConfirmOk;
    }

    static /* synthetic */ boolean access$1202(PreferredActivityChooserFragment r0, boolean r1) {
        r0.mDialogConfirmOk = r1;
        return r1;
    }

    static /* synthetic */ ComponentName access$1300(PreferredActivityChooserFragment r0) {
        return r0.mLastPreferredActivity;
    }

    static /* synthetic */ PreferredActivityChooseUtils access$1400(PreferredActivityChooserFragment r0) {
        return r0.mChooseUtils;
    }

    static /* synthetic */ void access$1500(PreferredActivityChooserFragment r0) {
        r0.launchNewLauncherAndFinish();
    }

    static /* synthetic */ OAlertDialog access$1602(PreferredActivityChooserFragment r0, OAlertDialog r1) {
        r0.mLauncherSwitchDialog = r1;
        return r1;
    }

    static /* synthetic */ List access$200(PreferredActivityChooserFragment r0) {
        return r0.mResolveInfoList;
    }

    static /* synthetic */ PackageManager access$300(PreferredActivityChooserFragment r0) {
        return r0.mPm;
    }

    static /* synthetic */ boolean access$400(PreferredActivityChooserFragment r0) {
        return r0.mIsHomeCategory;
    }

    static /* synthetic */ ComponentName access$500(PreferredActivityChooserFragment r0) {
        return r0.mPreferredActivity;
    }

    static /* synthetic */ ComponentName access$502(PreferredActivityChooserFragment r0, ComponentName r1) {
        r0.mPreferredActivity = r1;
        return r1;
    }

    static /* synthetic */ ListView access$600(PreferredActivityChooserFragment r0) {
        return r0.mListView;
    }

    static /* synthetic */ List access$700(PreferredActivityChooserFragment r0) {
        return r0.mFullResolveInfoList;
    }

    static /* synthetic */ IntentFilter access$800(PreferredActivityChooserFragment r0) {
        return r0.mIntentFilter;
    }

    static /* synthetic */ void access$900(PreferredActivityChooserFragment r0) {
        r0.showSwitchDialog();
    }

    @Override // com.android.settings.base.BaseFragment
    protected void onExtDisplayChanged(boolean r1) {
        if (r1 == false) goto L5;
        finish();
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        this.mRootView = r3.inflate(R.layout.manage_applications_layout, r4, false);
        this.mListView = (ListView) findViewByIdNullable(R.id.listView);
        View r6 = LayoutInflater.from(this.mContext).inflate(R.layout.preferred_activity_details_footer, null);
        this.mIsHomeCategory = false;
        this.mTextView3 = (TextView) r6.findViewById(R.id.textView3);
        this.mTextView1 = (TextView) r6.findViewById(R.id.textView1);
        this.mListView.addFooterView(r6);
        SettingItemButton r7 = (SettingItemButton) r6.findViewById(R.id.textView2);
        this.mClearPreferredSettings = r7;
        r7.setOnClickListener(new AnonymousClass1(this));
        PreferredActivityAdapter r8 = new PreferredActivityAdapter(this, this.mContext);
        this.mAdapter = r8;
        this.mListView.setAdapter(r8);
        this.mListView.setOnItemClickListener(this.mItemClickListener);
        this.mPm = getPackageManager();
        this.mChooseUtils = new PreferredActivityChooseUtils(this.mContext);
        Bundle r9 = getArguments();
        this.mIntentFilter = (IntentFilter) r9.getParcelable("filter");
        int r10 = r9.getInt("position", -1);
        if (this.mIsExtDisplaying == false) goto L6;
        r10 = r10 + 1;
    L6:
        if (r10 != 0) goto L9;
        this.mIsHomeCategory = true;
        IntentFilter r11 = new IntentFilter("android.intent.action.MAIN");
        this.mIntentFilter = r11;
        r11.addCategory("android.intent.category.HOME");
        this.mIntentFilter.addCategory("android.intent.category.DEFAULT");
        this.mClearPreferredSettings.setVisibility(8);
        this.mTextView3.setVisibility(8);
    L9:
        if (this.mIntentFilter != null) goto L11;
        IntentFilter r12 = new IntentFilter("android.intent.action.MAIN");
        this.mIntentFilter = r12;
        r12.addCategory("android.intent.category.HOME");
        this.mIntentFilter.addCategory("android.intent.category.DEFAULT");
    L11:
        this.mPreferredIntent = makeIntentByFilter(this.mIntentFilter);
        this.mTextView1.setText(getString(R.string.preferred_app_list_tips));
        this.mTextView3.setText(getString(R.string.preferred_clear_tips));
        return this.mRootView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r1) {
        super.onViewStateRestored(r1);
        updateViews();
    }

    public static Intent makeIntentByFilter(IntentFilter r0) {
        return PreferredActivityChooseUtils.makeIntentByFilter(r0);
    }

    public void updateViews() {
        this.mChooseUtils.generateData(this.mPreferredIntent, this.mIsHomeCategory);
        this.mResolveInfoList = this.mChooseUtils.getResolveInfoList();
        this.mFullResolveInfoList = this.mChooseUtils.getFullResolveInfoList();
        ResolveInfo r0 = this.mPm.resolveActivity(this.mPreferredIntent, 65536);
        if (r0 == null) goto L5;
        this.mPreferredActivity = new ComponentName(r0.activityInfo.packageName, r0.activityInfo.name);
    L5:
        this.mLastPreferredActivity = this.mPreferredActivity;
        this.mAdapter.notifyDataSetChanged();
        if (shouldDisableClear(r0) == false) goto L8;
    L11:
        this.mClearPreferredSettings.setEnabled(false);
        return;
    L8:
        if (this.mAdapter.getCount() == 1) goto L11;
        this.mClearPreferredSettings.setEnabled(true);
    }

    @Override // com.android.settings.base.BaseFragment
    public void onResumeNonInitial() {
        super.onResumeNonInitial();
        updateViews();
    }

    private boolean shouldDisableClear(ResolveInfo r3) {
        if (r3 != null) goto L6;
        return false;
    L6:
        if (PreferredSettingsUtils.COMPONENT_RESOLVERACTIVITY.equals(r3.activityInfo.name) == false) goto L8;
    L9:
        return true;
    L8:
        if (PreferredSettingsUtils.COMPONENT_RESOLVERACTIVITY_ANDROID.equals(r3.activityInfo.name) == true) goto L9;
        return false;
    }

    private void clearPreferredActivities(Intent r2) {
        PackageManagerSmt.getInstance().clearPreferredActivities(this.mPm, r2);
    }

    private void showSwitchDialog() {
        FragmentActivity r0 = getActivity();
        if (r0 != null) goto L7;
        OLog.e(this.TAG, "showSwitchDialog, activity is null, return");
        return;
    L7:
        if (this.mLauncherSwitchDialog != null) goto L10;
        this.mDialogConfirmOk = false;
        OAlertDialog r1 = new OAlertDialogBuilder(r0).autoDismiss(true).horizontalButton().title(R.string.dlg_switch_launcher_title).message(R.string.dlg_switch_launcher_msg).positiveButton(R.string.dlg_ok, new AnonymousClass4(this)).negativeButton(R.string.dlg_cancel, new AnonymousClass3(this)).build();
        this.mLauncherSwitchDialog = r1;
        r1.setOnDismissListener(new AnonymousClass5(this));
    L10:
        if (this.mLauncherSwitchDialog.isShowing() == true) goto L13;
        this.mLauncherSwitchDialog.show();
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int r2, int r3, Intent r4) {
        super.onActivityResult(r2, r3, r4);
        if (r2 == 10) goto L5;
        return;
    L5:
        if (r3 != RESULT_OK) goto L9;
        this.mChooseUtils.switchLauncher(this.mPreferredActivity, this.mComponentSet, this.mLastPreferredActivity);
        launchNewLauncherAndFinish();
        return;
    }

    private void launchNewLauncherAndFinish() {
        LauncherSettingsFragment.launchNewLauncherDelay(this);
        finishDelay();
    }

    private void finishDelay() {
        this.mHandler.postDelayed(new AnonymousClass6(this), 200);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        OAlertDialog r0 = this.mLauncherSwitchDialog;
        if (r0 == null) goto L6;
        r0.dismiss();
        return;
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        OAlertDialog r0 = this.mLauncherSwitchDialog;
        if (r0 == null) goto L6;
        r0.dismiss();
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_applications_PreferredActivityChooserFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(PreferredActivityChooserFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_applications_PreferredActivityChooserFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_applications_PreferredActivityChooserFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(PreferredActivityChooserFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_applications_PreferredActivityChooserFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_applications_PreferredActivityChooserFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(PreferredActivityChooserFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_applications_PreferredActivityChooserFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
