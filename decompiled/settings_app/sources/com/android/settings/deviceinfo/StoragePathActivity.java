package com.android.settings.deviceinfo;

import android.app.SmtPCUtils;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.GlobalProxyLancet;
import com.android.settings.Constants;
import com.android.settings.R;
import com.android.settings.SettingsAdapter;
import com.android.settings.SettingsFeature;
import com.android.settings.Utils;
import com.android.settings.base.BaseActivity;
import com.android.settings.stickylistheaders.StickyListHeadersAdapter;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.widget.SlideListView;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.app.OMenuDialog;
import obric.app.OMenuDialogListAdapter;

/* JADX INFO: loaded from: classes2.dex */
public class StoragePathActivity extends BaseActivity implements AdapterView.OnItemClickListener, SlideListView.Listener, View.OnClickListener {
    private PreferredCategoryAdapter mAdapter;
    private View mBottomBarView;
    private View mChooseExternal;
    private View mChooseInternal;
    private OMenuDialog mChooseLockTypeDialog;
    private boolean mIsEditMode;
    private SlideListView mListView;
    private String[] mPreferredCategoryTitle;
    private HashSet<Integer> mSelectedIndexSet;
    private String[] mStorageTypePackages;

    class PreferredCategoryAdapter extends SettingsAdapter implements StickyListHeadersAdapter {
        private Context mContext;
        private LayoutInflater mLayoutInflater;
        final /* synthetic */ StoragePathActivity this$0;

        class ViewHolder {
            CheckBox checkBox;
            ImageView iconView;
            TextView subTitleView;
            final /* synthetic */ PreferredCategoryAdapter this$1;
            TextView titleView;

            ViewHolder(PreferredCategoryAdapter r1) {
                this.this$1 = r1;
            }
        }

        @Override // com.android.settings.stickylistheaders.StickyListHeadersAdapter
        public long getHeaderId(int r1) {
            return r1;
        }

        public PreferredCategoryAdapter(StoragePathActivity r1, Context r2) {
            this.this$0 = r1;
            this.mContext = r2;
            this.mLayoutInflater = LayoutInflater.from(r2);
        }

        @Override // com.android.settings.SettingsAdapter, android.widget.Adapter
        public int getCount() {
            return StoragePathActivity.access$300(this.this$0).length;
        }

        @Override // com.android.settings.SettingsAdapter, android.widget.Adapter
        public View getView(int r4, View r5, ViewGroup r6) {
            if (r5 != null) goto L4;
        L7:
            r5 = this.mLayoutInflater.inflate(R.layout.file_storeage_path_item, null);
            ViewHolder r7 = new ViewHolder(this);
            r7.checkBox = (CheckBox) r5.findViewById(R.id.item_checkbox);
            r7.iconView = (ImageView) r5.findViewById(R.id.item_icon);
            r7.titleView = (TextView) r5.findViewById(R.id.item_title);
            r7.subTitleView = (TextView) r5.findViewById(R.id.item_subtitle);
            r5.setTag(r7);
        L8:
            CheckBox r0 = r7.checkBox;
            if (StoragePathActivity.access$400(this.this$0) == false) goto L11;
            int r1 = 0;
        L12:
            r0.setVisibility(r1);
            r7.checkBox.setChecked(this.this$0.isChecked(r4));
            String r2 = StoragePathActivity.access$500(this.this$0)[r4];
            r2.hashCode();
            if (r2.equals("screenshot") == false) goto L15;
            r7.iconView.setImageResource(R.drawable.ic_screenshot);
        L19:
            r7.titleView.setText(StoragePathActivity.access$300(this.this$0)[r4]);
            if (StorageUtils.getStoragePathValue(this.mContext, r4) != 0) goto L22;
            r7.subTitleView.setText(R.string.path_internal_storage);
        L23:
            r5.setBackgroundResource(R.drawable.app_list_item_bg_selector);
            return r5;
        L22:
            r7.subTitleView.setText(R.string.path_external_storage);
            goto L23
        L15:
            if (r2.equals(Constants.PKG_BACKUP) == true) goto L17;
            ImageView r3 = r7.iconView;
            StoragePathActivity r8 = this.this$0;
            r3.setImageDrawable(StoragePathActivity.access$600(r8, StoragePathActivity.access$500(r8)[r4]));
            goto L19
        L17:
            r7.iconView.setImageResource(R.drawable.back_up_icon);
            goto L19
        L11:
            r1 = 8;
            goto L12
        L4:
            if (r5.getTag() == null) goto L7;
            r7 = (ViewHolder) r5.getTag();
            goto L8
        }

        @Override // com.android.settings.stickylistheaders.StickyListHeadersAdapter
        public View getHeaderView(int r1, View r2, ViewGroup r3) {
            if (r2 != null) goto L4;
            r2 = new View(this.mContext);
        L4:
            r2.setVisibility(8);
            return r2;
        }
    }

    public void com_android_settings_deviceinfo_StoragePathActivity__onPause$___twin___() {
        super.onPause();
    }

    public void com_android_settings_deviceinfo_StoragePathActivity__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_deviceinfo_StoragePathActivity__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_settings_deviceinfo_StoragePathActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        com_android_settings_deviceinfo_StoragePathActivity_com_obric_hook_lancet_PrivacyHook_onDestroy(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com_android_settings_deviceinfo_StoragePathActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        com_android_settings_deviceinfo_StoragePathActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_settings_deviceinfo_StoragePathActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_deviceinfo_StoragePathActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public StoragePathActivity() {
        this.mSelectedIndexSet = new HashSet();
    }

    static /* synthetic */ void access$000(StoragePathActivity r0) {
        r0.toggleEditMode();
    }

    static /* synthetic */ OMenuDialog access$102(StoragePathActivity r0, OMenuDialog r1) {
        r0.mChooseLockTypeDialog = r1;
        return r1;
    }

    static /* synthetic */ PreferredCategoryAdapter access$200(StoragePathActivity r0) {
        return r0.mAdapter;
    }

    static /* synthetic */ String[] access$300(StoragePathActivity r0) {
        return r0.mPreferredCategoryTitle;
    }

    static /* synthetic */ boolean access$400(StoragePathActivity r0) {
        return r0.mIsEditMode;
    }

    static /* synthetic */ String[] access$500(StoragePathActivity r0) {
        return r0.mStorageTypePackages;
    }

    static /* synthetic */ Drawable access$600(StoragePathActivity r0, String r1) {
        return r0.getAppIcon(r1);
    }

    public void com_android_settings_deviceinfo_StoragePathActivity__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
        if (SettingsFeature.isSdMounted() == true) goto L5;
        finish();
    L5:
        setContentView(R.layout.storage_path_layout);
        initView();
        registerUnmountReceiver();
    }

    public void initView() {
        this.mPreferredCategoryTitle = getResources().getStringArray(R.array.preferred_storage_path);
        this.mStorageTypePackages = getResources().getStringArray(R.array.storage_type_packages);
        SlideListView r0 = (SlideListView) findViewById(R.id.listView);
        this.mListView = r0;
        r0.setAreHeadersSticky(false);
        this.mListView.setSlideListener(this);
        PreferredCategoryAdapter r1 = new PreferredCategoryAdapter(this, this);
        this.mAdapter = r1;
        this.mListView.setAdapter(r1);
        View r2 = Utils.inflateListViewHeaderTitle(this, R.string.choose_prefer_storage_path_tips);
        this.mListView.addHeaderView(r2);
        SlideListView r3 = this.mListView;
        r3.addHeaderView(Utils.inflateGapView(r3));
        this.mListView.setOnItemClickListener(this);
        this.mBottomBarView = findViewById(R.id.id_bottom_bar);
        View r4 = findViewById(R.id.id_internal);
        this.mChooseInternal = r4;
        r4.setOnClickListener(this);
        View r5 = findViewById(R.id.id_external);
        this.mChooseExternal = r5;
        r5.setOnClickListener(this);
        this.mTitle = setupBackBtnOnTitle(false);
        this.mRightBtn = this.mTitle.addEndAction(R.string.batch_edit, -1, null);
        this.mRightBtn.setOnClickListener(new AnonymousClass1(this));
    }

    public void com_android_settings_deviceinfo_StoragePathActivity__onResume$___twin___() {
        super.onResume();
        PreferredCategoryAdapter r0 = this.mAdapter;
        if (r0 == null) goto L6;
        r0.notifyDataSetChanged();
        return;
    }

    @Override // com.android.settings.widget.SlideListView.Listener
    public void setChecked(int r1, boolean r2) {
        onCheckedChanged(r1, r2);
    }

    private void onCheckedChanged(int r1, boolean r2) {
        if (r2 == false) goto L4;
        this.mSelectedIndexSet.add(Integer.valueOf(r1));
    L5:
        updateBottomBarViews();
        this.mAdapter.notifyDataSetChanged();
        return;
    L4:
        this.mSelectedIndexSet.remove(Integer.valueOf(r1));
        goto L5
    }

    private void updateBottomBarViews() {
        if (this.mSelectedIndexSet.isEmpty() == false) goto L5;
        this.mChooseInternal.setEnabled(false);
        this.mChooseExternal.setEnabled(false);
        this.mChooseInternal.setAlpha(0.5f);
        this.mChooseExternal.setAlpha(0.5f);
        return;
    L5:
        this.mChooseInternal.setEnabled(true);
        this.mChooseExternal.setEnabled(true);
        this.mChooseInternal.setAlpha(1.0f);
        this.mChooseExternal.setAlpha(1.0f);
    }

    @Override // com.android.settings.widget.SlideListView.Listener
    public boolean isChecked(int r1) {
        return this.mSelectedIndexSet.contains(Integer.valueOf(r1));
    }

    @Override // com.android.settings.base.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.mIsEditMode == false) goto L5;
        toggleEditMode();
        return;
    L5:
        super.onBackPressed();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> r1, View r2, int r3, long r4) {
        int r5 = r3 - this.mListView.getHeaderViewsCount();
        if (r5 >= 0) goto L5;
        return;
    L5:
        if (r5 < this.mAdapter.getCount()) goto L8;
        return;
    L8:
        if (this.mIsEditMode == false) goto L10;
        onCheckedChanged(r5, !isChecked(r5));
        return;
    L10:
        showChooseMenuDialog(r5);
    }

    private void toggleEditMode() {
        this.mIsEditMode = !this.mIsEditMode;
        this.mSelectedIndexSet.clear();
        View r0 = this.mBottomBarView;
        if (this.mIsEditMode == false) goto L5;
        int r1 = 0;
    L6:
        r0.setVisibility(r1);
        updateBottomBarViews();
        this.mAdapter.notifyDataSetChanged();
        return;
    L5:
        r1 = 8;
        goto L6
    }

    private void showChooseMenuDialog(int r6) {
        if (this.mChooseLockTypeDialog != null) goto L13;
        this.mChooseLockTypeDialog = new OMenuDialog(this);
        String r0 = this.mStorageTypePackages[r6];
        r0.hashCode();
        if (r0.equals(SmtPCUtils.PKG_CAMERA_2) == false) goto L7;
        this.mChooseLockTypeDialog.setTitle(R.string.choose_camera_storage_path_title);
    L11:
        ArrayList r1 = new ArrayList();
        ArrayList r2 = new ArrayList();
        r1.add(getString(R.string.path_internal_storage));
        r2.add(createSelectStorageListener(r6, 0));
        r1.add(getString(R.string.path_external_storage));
        r2.add(createSelectStorageListener(r6, 1));
        this.mChooseLockTypeDialog.setAdapter(new OMenuDialogListAdapter(this, r1, r2));
        this.mChooseLockTypeDialog.setOnDismissListener(new AnonymousClass2(this));
        goto L13
    L7:
        if (r0.equals(Constants.PKG_MUSIC) == true) goto L9;
        this.mChooseLockTypeDialog.setTitle(getString(R.string.choose_storage_path_title, new Object[]{this.mPreferredCategoryTitle[r6]}));
        goto L11
    L9:
        this.mChooseLockTypeDialog.setTitle(R.string.choose_music_storage_path_title);
    L13:
        if (this.mChooseLockTypeDialog.isShowing() == true) goto L16;
        this.mChooseLockTypeDialog.show();
        return;
    }

    private View.OnClickListener createSelectStorageListener(final int r2, final int r3) {
        return new AnonymousClass3(this, r2, r3);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r5) {
        if (r5 == this.mChooseInternal) goto L7;
        if (r5 == this.mChooseExternal) goto L7;
        return;
    L7:
        if (r5 != this.mChooseExternal) goto L9;
        int r6 = 1;
    L10:
        Iterator<Integer> r0 = this.mSelectedIndexSet.iterator();
    L12:
        if (r0.hasNext() == false) goto L14;
        StorageUtils.putStoragePathValue(this.mContext, r0.next().intValue(), r6, true);
        goto L12
    L14:
        toggleEditMode();
        return;
    L9:
        r6 = 0;
        goto L10
    }

    private void registerUnmountReceiver() {
        IntentFilter r0 = new IntentFilter("android.intent.action.MEDIA_UNMOUNTED");
        r0.addDataScheme("file");
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this, this.sdUnmountReceiver, r0);
    }

    public void com_android_settings_deviceinfo_StoragePathActivity__onDestroy$___twin___() {
        super.onDestroy();
        unregisterReceiver(this.sdUnmountReceiver);
    }

    private Drawable getAppIcon(String r2) {
        PackageManager r1 = getPackageManager();
        return r1.getPackageInfo(r2, 0).applicationInfo.loadIcon(r1);
    L5:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_deviceinfo_StoragePathActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(StoragePathActivity r1) {
        com_android_settings_deviceinfo_StoragePathActivity_com_obric_hook_lancet_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_deviceinfo_StoragePathActivity_com_obric_hook_lancet_PrivacyHook_onCreate(StoragePathActivity r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        StoragePathActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_deviceinfo_StoragePathActivity__onCreate$___twin___(r4);
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_deviceinfo_StoragePathActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(StoragePathActivity r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_deviceinfo_StoragePathActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_deviceinfo_StoragePathActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(StoragePathActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_deviceinfo_StoragePathActivity_com_obric_hook_lancet_PrivacyHook_onResume(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        StoragePathActivity r5 = r4;
        String r2 = r5.getCallingPackage();
        if (r2 != null) goto L9;
        OLog.e("BaseActivity", "isDeviceSetupComplete callingPkg is null, try getReferrer");
        Uri r6 = r5.getReferrer();
        if (r6 == null) goto L9;
        r2 = r6.toString();
    L9:
        OLog.i("TeaEventReportUtil", "callingPkg=" + r2);
        if (r2 != null) goto L12;
        r2 = "null";
    L12:
        AppMetricsUtils.INSTANCE.reportColdStartActivity(r2, r0);
    L13:
        AppMetricsUtils.INSTANCE.setColdStartTime(0);
    }

    @Insert(mayCreateSuper = true, value = "startActivityForResult")
    public static void com_android_settings_deviceinfo_StoragePathActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(StoragePathActivity r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_deviceinfo_StoragePathActivity__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_deviceinfo_StoragePathActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(StoragePathActivity r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_deviceinfo_StoragePathActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @Insert("onResume")
    public static void com_android_settings_deviceinfo_StoragePathActivity_com_obric_hook_lancet_PrivacyHook_onResume(StoragePathActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        StoragePathActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_deviceinfo_StoragePathActivity__onResume$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_deviceinfo_StoragePathActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(StoragePathActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_deviceinfo_StoragePathActivity_com_obric_hook_lancet_PrivacyHook_onPause(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @Insert("onPause")
    public static void com_android_settings_deviceinfo_StoragePathActivity_com_obric_hook_lancet_PrivacyHook_onPause(StoragePathActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        StoragePathActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_deviceinfo_StoragePathActivity__onPause$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_deviceinfo_StoragePathActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(StoragePathActivity r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        com_android_settings_deviceinfo_StoragePathActivity_com_obric_hook_lancet_PrivacyHook_onCreate(r3, r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        StoragePathActivity r5 = r3;
        String r6 = r5.getCallingPackage();
        if (r6 != null) goto L9;
        OLog.e("AppLifecycle", "isDeviceSetupComplete callingPkg is null, try getReferrer");
        Uri r7 = r5.getReferrer();
        if (r7 == null) goto L9;
        r6 = r7.toString();
    L9:
        OLog.i("AppLifecycle", "TeaEventReportUtil callingPkg=" + r6);
        if (r6 != null) goto L12;
        r6 = "null";
    L12:
        AppMetricsUtils r8 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r8.callingPackageEvent(r6, r0, false);
        return;
    }

    @Insert("onStop")
    public static void com_android_settings_deviceinfo_StoragePathActivity_com_obric_hook_lancet_PrivacyHook_onStop(StoragePathActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        StoragePathActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_deviceinfo_StoragePathActivity__onStop$___twin___();
    }

    @Insert("onDestroy")
    public static void com_android_settings_deviceinfo_StoragePathActivity_com_obric_hook_lancet_PrivacyHook_onDestroy(StoragePathActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        StoragePathActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperDestroy();
        return;
    L6:
        r3.com_android_settings_deviceinfo_StoragePathActivity__onDestroy$___twin___();
    }
}
