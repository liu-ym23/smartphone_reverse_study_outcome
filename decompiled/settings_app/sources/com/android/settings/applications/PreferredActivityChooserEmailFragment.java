package com.android.settings.applications;

import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import bytedanceos.api.PackageManagerSmt;
import bytedanceos.util.SettingsUtil;
import com.android.settings.LauncherSettingsFragment;
import com.android.settings.R;
import com.android.settings.SettingsAdapter;
import com.android.settings.applications.api.OnSettingsItemClickListener;
import com.android.settings.applications.utils.OCardListItemUtils;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.HanziToPinyin;
import com.android.settings.widget.SettingItemButton;
import com.obric.olog.OLog;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.util.SectionComparator2;
import settings.PreferredActivityChooseUtils;

/* JADX INFO: loaded from: classes2.dex */
public class PreferredActivityChooserEmailFragment extends BaseFragment {
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
    OnSettingsItemClickListener mItemClickListener;
    private ComponentName mLastPreferredActivity;
    private AlertDialog mLauncherSwitchDialog;
    private ListView mListView;
    private ComponentName mPendingActivity;
    private PackageManager mPm;
    private ComponentName mPreferredActivity;
    private Intent mPreferredIntent;
    private TextView mTextView1;
    private TextView mTextView3;
    private List<ResolveListItem> resolveListItems;

    class PreferredActivityAdapter extends SettingsAdapter {
        private Context mContext;
        private OnSettingsItemClickListener mItemClickListener;
        final /* synthetic */ PreferredActivityChooserEmailFragment this$0;

        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            return false;
        }

        static /* synthetic */ OnSettingsItemClickListener access$600(PreferredActivityAdapter r0) {
            return r0.mItemClickListener;
        }

        public PreferredActivityAdapter(PreferredActivityChooserEmailFragment r1, Context r2, OnSettingsItemClickListener r3) {
            this.this$0 = r1;
            this.mContext = r2;
            this.mItemClickListener = r3;
        }

        @Override // com.android.settings.SettingsAdapter, android.widget.Adapter
        public int getCount() {
            return PreferredActivityChooserEmailFragment.access$300(this.this$0).size();
        }

        @Override // com.android.settings.SettingsAdapter, android.widget.Adapter
        public View getView(final int r9, View r10, ViewGroup r11) {
            String r12 = null;
            if (r10 != null) goto L5;
            r10 = View.inflate(this.this$0.getActivity(), R.layout.settings_oui_card_list_item_with_icon, null);
            final OCardListItem r0 = (OCardListItem) r10.findViewById(R.id.card_list_item);
            r10.setTag(r0);
        L6:
            OCardListItemUtils.initCardItemInAdapter(this, r0, r9);
            ResolveListItem r1 = (ResolveListItem) PreferredActivityChooserEmailFragment.access$300(this.this$0).get(r9);
            ResolveInfo r2 = r1.resolveInfo;
            String r3 = r1.title;
            String r4 = r1.summary;
            if (PreferredActivityChooserEmailFragment.access$400(this.this$0) == false) goto L12;
            String r5 = r2.activityInfo.packageName;
            r5.hashCode();
            if (r5.equals("com.bytedanceos.launcher") == true) goto L11;
            OCardListItemUtils.setTitle(r0, r3);
            OCardListItemUtils.setIcon(r0, r1.icon);
        L13:
            if (r4 == null) goto L16;
            r12 = r4.toString().replaceAll("\\p{C}", "").replaceAll("\\p{Z}", HanziToPinyin.Token.SEPARATOR).trim();
        L16:
            if (r3.equals(r12) == true) goto L19;
            OCardListItemUtils.setTitle(r0, r12);
        L19:
            if (new ComponentName(r2.activityInfo.packageName, r2.activityInfo.name).equals(PreferredActivityChooserEmailFragment.access$500(this.this$0)) == false) goto L21;
            r0.showCustomEnd(true);
        L22:
            r0.setOnContentClickListener(new AnonymousClass1(this, r0, r9));
            return r10;
        L21:
            r0.showCustomEnd(false);
            goto L22
        L11:
            OCardListItemUtils.setTitle(r0, this.this$0.getString(R.string.bytedance_desktop_title));
            OCardListItemUtils.setIcon(r0, this.mContext.getDrawable(R.drawable.bytedance_home));
            r0.setEnabled(!SettingsUtil.isAccessibilityEnabled(this.mContext));
            goto L13
        L12:
            OCardListItemUtils.setTitle(r0, r3);
            OCardListItemUtils.setIcon(r0, r1.icon);
            goto L13
        L5:
            r0 = (OCardListItem) r10.getTag();
            goto L6
        }

        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
        public boolean isEnabled(int r4) {
            ResolveInfo r0 = ((ResolveListItem) PreferredActivityChooserEmailFragment.access$300(this.this$0).get(r4)).resolveInfo;
            boolean r1 = SettingsUtil.isAccessibilityEnabled(this.mContext);
            if (r0.activityInfo.packageName.equals("com.bytedanceos.launcher") == false) goto L8;
            if (r1 == false) goto L8;
            return false;
        L8:
            return super.isEnabled(r4);
        }
    }

    private static class ResolveListItem {
        public Drawable icon;
        public ResolveInfo resolveInfo;
        public String summary;
        public String title;
        public String titlePinyin;

        private ResolveListItem() {
        }

        /* synthetic */ ResolveListItem(AnonymousClass1 r1) {
            this();
        }

        public String getTitle() {
            return this.titlePinyin;
        }
    }

    public void com_android_settings_applications_PreferredActivityChooserEmailFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_applications_PreferredActivityChooserEmailFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_applications_PreferredActivityChooserEmailFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_applications_PreferredActivityChooserEmailFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    @Override // com.android.settings.base.BaseFragment
    protected boolean shouldMonitorExtDisplayStatus() {
        return true;
    }

    public PreferredActivityChooserEmailFragment() {
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mFullResolveInfoList = new ArrayList();
        this.resolveListItems = new ArrayList();
        this.mItemClickListener = new AnonymousClass2(this);
    }

    static /* synthetic */ Intent access$000(PreferredActivityChooserEmailFragment r0) {
        return r0.mPreferredIntent;
    }

    static /* synthetic */ void access$100(PreferredActivityChooserEmailFragment r0, Intent r1) {
        r0.clearPreferredActivities(r1);
    }

    static /* synthetic */ PackageManager access$1000(PreferredActivityChooserEmailFragment r0) {
        return r0.mPm;
    }

    static /* synthetic */ void access$1100(PreferredActivityChooserEmailFragment r0) {
        r0.showSwitchDialog();
    }

    static /* synthetic */ PreferredActivityAdapter access$1200(PreferredActivityChooserEmailFragment r0) {
        return r0.mAdapter;
    }

    static /* synthetic */ SettingItemButton access$1300(PreferredActivityChooserEmailFragment r0) {
        return r0.mClearPreferredSettings;
    }

    static /* synthetic */ AlertDialog access$1402(PreferredActivityChooserEmailFragment r0, AlertDialog r1) {
        r0.mLauncherSwitchDialog = r1;
        return r1;
    }

    static /* synthetic */ boolean access$1500(PreferredActivityChooserEmailFragment r0) {
        return r0.mDialogConfirmOk;
    }

    static /* synthetic */ boolean access$1502(PreferredActivityChooserEmailFragment r0, boolean r1) {
        r0.mDialogConfirmOk = r1;
        return r1;
    }

    static /* synthetic */ ComponentName access$1600(PreferredActivityChooserEmailFragment r0) {
        return r0.mLastPreferredActivity;
    }

    static /* synthetic */ PreferredActivityChooseUtils access$1700(PreferredActivityChooserEmailFragment r0) {
        return r0.mChooseUtils;
    }

    static /* synthetic */ void access$1800(PreferredActivityChooserEmailFragment r0) {
        r0.launchNewLauncherAndFinish();
    }

    static /* synthetic */ List access$300(PreferredActivityChooserEmailFragment r0) {
        return r0.resolveListItems;
    }

    static /* synthetic */ boolean access$400(PreferredActivityChooserEmailFragment r0) {
        return r0.mIsHomeCategory;
    }

    static /* synthetic */ ComponentName access$500(PreferredActivityChooserEmailFragment r0) {
        return r0.mPreferredActivity;
    }

    static /* synthetic */ ComponentName access$502(PreferredActivityChooserEmailFragment r0, ComponentName r1) {
        r0.mPreferredActivity = r1;
        return r1;
    }

    static /* synthetic */ ListView access$700(PreferredActivityChooserEmailFragment r0) {
        return r0.mListView;
    }

    static /* synthetic */ List access$800(PreferredActivityChooserEmailFragment r0) {
        return r0.mFullResolveInfoList;
    }

    static /* synthetic */ IntentFilter access$900(PreferredActivityChooserEmailFragment r0) {
        return r0.mIntentFilter;
    }

    @Override // com.android.settings.base.BaseFragment
    protected void onExtDisplayChanged(boolean r1) {
        if (r1 == false) goto L5;
        finish();
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        this.mRootView = r2.inflate(R.layout.manage_applications_layout, r3, false);
        this.mListView = (ListView) findViewByIdNullable(R.id.listView);
        View r5 = LayoutInflater.from(getActivity()).inflate(R.layout.preferred_activity_details_footer, null);
        this.mIsHomeCategory = false;
        this.mTextView3 = (TextView) r5.findViewById(R.id.textView3);
        this.mTextView1 = (TextView) r5.findViewById(R.id.textView1);
        this.mListView.addFooterView(r5);
        SettingItemButton r6 = (SettingItemButton) r5.findViewById(R.id.textView2);
        this.mClearPreferredSettings = r6;
        r6.setOnClickListener(new AnonymousClass1(this));
        PreferredActivityAdapter r7 = new PreferredActivityAdapter(this, this.mContext, this.mItemClickListener);
        this.mAdapter = r7;
        this.mListView.setAdapter(r7);
        this.mPm = getPackageManager();
        this.mChooseUtils = new PreferredActivityChooseUtils(this.mContext);
        Bundle r8 = getArguments();
        this.mIntentFilter = (IntentFilter) r8.getParcelable("filter");
        if (r8.getInt("position", -1) != 1) goto L5;
        IntentFilter r9 = new IntentFilter("android.intent.action.SENDTO");
        this.mIntentFilter = r9;
        r9.addDataScheme("mailto");
        this.mIntentFilter.addCategory("android.intent.category.DEFAULT");
    L5:
        this.mPreferredIntent = makeIntentByFilter(this.mIntentFilter);
        this.mClearPreferredSettings.setVisibility(8);
        this.mTextView3.setVisibility(8);
        this.mTextView1.setText(getString(R.string.preferred_app_list_tips));
        this.mTextView3.setText(getString(R.string.preferred_clear_tips));
        return this.mRootView;
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r1, Bundle r2) {
        super.onViewCreated(r1, r2);
        initList();
    }

    public static Intent makeIntentByFilter(IntentFilter r0) {
        return PreferredActivityChooseUtils.makeIntentByFilter(r0);
    }

    private void initList() {
        ResolveInfo r0 = this.mPm.resolveActivity(this.mPreferredIntent, 65536);
        if (r0 == null) goto L5;
        this.mPreferredActivity = new ComponentName(r0.activityInfo.packageName, r0.activityInfo.name);
    L5:
        this.mLastPreferredActivity = this.mPreferredActivity;
        this.mChooseUtils.generateData(this.mPreferredIntent, this.mIsHomeCategory);
        List<ResolveInfo> r1 = this.mChooseUtils.getResolveInfoList();
        int r2 = r1.size();
        int r4 = 0;
    L6:
        if (r4 >= r2) goto L11;
        ResolveListItem r5 = new ResolveListItem(null);
        ResolveInfo r6 = r1.get(r4);
        r5.resolveInfo = r6;
        r5.title = r6.activityInfo.applicationInfo.loadLabel(this.mPm).toString();
        r5.titlePinyin = ApplicationLabelUtils.loadLabelPinyin(this.mContext, r5.title);
        CharSequence r7 = r6.loadLabel(this.mPm);
        if (r7 == null) goto L10;
        r5.summary = r7.toString().replaceAll("\\p{C}", "").replaceAll("\\p{Z}", HanziToPinyin.Token.SEPARATOR).trim();
    L10:
        r5.icon = r6.activityInfo.applicationInfo.loadIcon(this.mPm);
        this.resolveListItems.add(r5);
        r4 = r4 + 1;
        goto L6
    L11:
        final SectionComparator2 r3 = new SectionComparator2();
        this.resolveListItems.sort(new PreferredActivityChooserEmailFragment$$ExternalSyntheticLambda0(r3));
        this.mFullResolveInfoList = this.mChooseUtils.getFullResolveInfoList();
        this.mAdapter.notifyDataSetChanged();
        if (shouldDisableClear(r0) == false) goto L14;
    L17:
        this.mClearPreferredSettings.setEnabled(false);
        return;
    L14:
        if (this.mAdapter.getCount() == 1) goto L17;
        this.mClearPreferredSettings.setEnabled(true);
    }

    static /* synthetic */ int lambda$initList$0(Comparator r0, ResolveListItem r1, ResolveListItem r2) {
        return r0.compare(r1.getTitle(), r2.getTitle());
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
        this.mLauncherSwitchDialog = new AlertDialog.Builder(r0).setTitle(getString(R.string.dlg_switch_launcher_title)).setMessage(getString(R.string.dlg_switch_launcher_msg)).setNegativeButton(R.string.dlg_cancel, null).setPositiveButton(R.string.dlg_ok, new AnonymousClass4(this)).setOnDismissListener(new AnonymousClass3(this)).create();
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
        this.mHandler.postDelayed(new AnonymousClass5(this), 200);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        AlertDialog r0 = this.mLauncherSwitchDialog;
        if (r0 == null) goto L6;
        r0.dismiss();
        return;
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        AlertDialog r0 = this.mLauncherSwitchDialog;
        if (r0 == null) goto L6;
        r0.dismiss();
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_applications_PreferredActivityChooserEmailFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(PreferredActivityChooserEmailFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_applications_PreferredActivityChooserEmailFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_applications_PreferredActivityChooserEmailFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(PreferredActivityChooserEmailFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_applications_PreferredActivityChooserEmailFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_applications_PreferredActivityChooserEmailFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(PreferredActivityChooserEmailFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_applications_PreferredActivityChooserEmailFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
