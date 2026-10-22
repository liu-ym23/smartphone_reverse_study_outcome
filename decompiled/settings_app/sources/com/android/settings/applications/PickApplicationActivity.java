package com.android.settings.applications;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.UserHandle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.android.settings.ExecutorManager;
import com.android.settings.R;
import com.android.settings.Utils;
import com.android.settings.base.BaseActivity;
import com.android.settings.teaevent.AppMetricsUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.app.BytedanceProgressDialog;
import obric.widget.SettingItemCheck;

/* JADX INFO: loaded from: classes2.dex */
public class PickApplicationActivity extends BaseActivity {
    public static final String EXTRA_ACTIVITY_NAME = "activity_name";
    public static final String EXTRA_ALLOW_NONE = "extra_allow_none";
    public static final String EXTRA_APP_NAME = "app_name";
    public static final String EXTRA_PACKAGE_NAME = "package_name";
    public static final String EXTRA_USER = "user";
    private static final int INTRINSIC_WIDTH = 96;
    private ActivitiesAdapter mActivitiesAdapter;
    private boolean mAllowNone;
    private LinearLayout mHeaderView;
    private ListView mListView;
    private String mSelectedActivity;
    private String mSelectedPkg;
    private int mSelectedUserId;

    private class ActivitiesAdapter extends BaseAdapter {
        private ArrayList<ActivityEntry> mEntries;
        private LayoutInflater mLayoutInflater;
        final /* synthetic */ PickApplicationActivity this$0;

        private class ViewHolder {
            ImageView checkedView;
            ImageView iconView;
            final /* synthetic */ ActivitiesAdapter this$1;
            TextView titleView;

            private ViewHolder(ActivitiesAdapter r1) {
                this.this$1 = r1;
            }

            /* synthetic */ ViewHolder(ActivitiesAdapter r1, AnonymousClass1 r2) {
                this(r1);
            }
        }

        @Override // android.widget.Adapter
        public long getItemId(int r1) {
            return r1;
        }

        public ActivitiesAdapter(PickApplicationActivity r1, Context r2, ArrayList<ActivityEntry> r3) {
            this.this$0 = r1;
            this.mLayoutInflater = LayoutInflater.from(r2);
            this.mEntries = r3;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            ArrayList<ActivityEntry> r0 = this.mEntries;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int r1) {
            return this.mEntries.get(r1);
        }

        @Override // android.widget.Adapter
        public View getView(int r5, View r6, ViewGroup r7) {
            if (r6 != null) goto L5;
        L8:
            r6 = this.mLayoutInflater.inflate(R.layout.application_item_layout, null, false);
            ViewHolder r0 = new ViewHolder(this, null);
            r0.iconView = (ImageView) r6.findViewById(R.id.item_icon);
            r0.titleView = (TextView) r6.findViewById(R.id.item_title);
            r0.checkedView = (ImageView) r6.findViewById(R.id.item_check);
            r6.setTag(r0);
        L9:
            ActivityEntry r1 = this.mEntries.get(r5);
            monitor-enter(r1);
            r0.titleView.setText(r1.label);     // Catch: Throwable -> L35
            r0.iconView.setImageDrawable(r1.icon);     // Catch: Throwable -> L35
            if (TextUtils.isEmpty(PickApplicationActivity.access$000(this.this$0)) == false) goto L14;
        L22:
            r0.checkedView.setVisibility(4);     // Catch: Throwable -> L35
        L23:
            monitor-exit(r1);     // Catch: Throwable -> L35
            if (this.mEntries.size() != 1) goto L27;
            int r4 = R.drawable.selector_setting_sub_item_bg_single;
        L33:
            r6.setBackgroundResource(r4);
            return r6;
        L27:
            if (r5 != 0) goto L30;
            r4 = R.drawable.selector_setting_sub_item_bg_top;
            goto L33
        L30:
            if (r5 != (this.mEntries.size() - 1)) goto L32;
            r4 = R.drawable.selector_setting_sub_item_bg_bottom;
            goto L33
        L32:
            r4 = R.drawable.selector_setting_sub_item_bg_middle;
            goto L33
        L14:
            if (TextUtils.isEmpty(PickApplicationActivity.access$100(this.this$0)) == true) goto L22;
            if (PickApplicationActivity.access$000(this.this$0).equals(r1.packageName) == false) goto L22;
            if (PickApplicationActivity.access$100(this.this$0).equals(r1.activityName) == false) goto L22;
            if (PickApplicationActivity.access$200(this.this$0) != r1.userId) goto L22;
            r0.checkedView.setVisibility(0);     // Catch: Throwable -> L35
        L35:
            th = move-exception;
            throw th;
        L5:
            if (r6.getTag() == null) goto L8;
            r0 = (ViewHolder) r6.getTag();
            goto L9
        }
    }

    private static class ActivityEntry {
        String activityName;
        Drawable icon;
        CharSequence label;
        String packageName;
        int userId;

        private ActivityEntry() {
            this.userId = UserHandle.myUserId();
        }

        /* synthetic */ ActivityEntry(AnonymousClass1 r1) {
            this();
        }

        static ActivityEntry clone(ActivityEntry r1, int r2, Resources r3) {
            ActivityEntry r4 = new ActivityEntry();
            r4.activityName = r1.activityName;
            r4.packageName = r1.packageName;
            r4.label = r1.label;
            r4.userId = r2;
            Drawable r5 = r1.icon;
            if ((r5 instanceof BitmapDrawable) == true) goto L6;
            r4.icon = r5;
        L6:
            return r4;
        }
    }

    public class AppInfoView extends LinearLayout {
        ImageView checkedView;
        ImageView iconView;
        View rootView;
        final /* synthetic */ PickApplicationActivity this$0;
        TextView titleView;

        public AppInfoView(PickApplicationActivity r2, Context r3) {
            this(r2, r3, null);
        }

        public AppInfoView(PickApplicationActivity r2, Context r3, AttributeSet r4) {
            this(r2, r3, r4, 0);
        }

        public AppInfoView(PickApplicationActivity r1, Context r2, AttributeSet r3, int r4) {
            this.this$0 = r1;
            super(r2, r3, r4);
            View r5 = LayoutInflater.from(r2).inflate(R.layout.application_item_layout, this, true);
            this.rootView = r5;
            this.iconView = (ImageView) r5.findViewById(R.id.item_icon);
            this.titleView = (TextView) this.rootView.findViewById(R.id.item_title);
            this.checkedView = (ImageView) this.rootView.findViewById(R.id.item_check);
        }

        public void setIcon(int r1) {
            this.iconView.setImageResource(r1);
        }

        public void setTitle(int r1) {
            this.titleView.setText(r1);
        }

        public void setTitle(CharSequence r1) {
            this.titleView.setText(r1);
        }

        public void setChecked(boolean r1) {
            ImageView r0 = this.checkedView;
            if (r1 == false) goto L5;
            int r2 = 0;
        L6:
            r0.setVisibility(r2);
            return;
        L5:
            r2 = 4;
            goto L6
        }
    }

    public void com_android_settings_applications_PickApplicationActivity__onPause$___twin___() {
        super.onPause();
    }

    public void com_android_settings_applications_PickApplicationActivity__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_applications_PickApplicationActivity__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_settings_applications_PickApplicationActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        com_android_settings_applications_PickApplicationActivity_com_obric_hook_lancet_PrivacyHook_onDestroy(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com_android_settings_applications_PickApplicationActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        com_android_settings_applications_PickApplicationActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_settings_applications_PickApplicationActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_applications_PickApplicationActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public PickApplicationActivity() {
    }

    static /* synthetic */ String access$000(PickApplicationActivity r0) {
        return r0.mSelectedPkg;
    }

    static /* synthetic */ String access$002(PickApplicationActivity r0, String r1) {
        r0.mSelectedPkg = r1;
        return r1;
    }

    static /* synthetic */ String access$100(PickApplicationActivity r0) {
        return r0.mSelectedActivity;
    }

    static /* synthetic */ String access$102(PickApplicationActivity r0, String r1) {
        r0.mSelectedActivity = r1;
        return r1;
    }

    static /* synthetic */ int access$200(PickApplicationActivity r0) {
        return r0.mSelectedUserId;
    }

    static /* synthetic */ int access$202(PickApplicationActivity r0, int r1) {
        r0.mSelectedUserId = r1;
        return r1;
    }

    static /* synthetic */ ActivitiesAdapter access$300(PickApplicationActivity r0) {
        return r0.mActivitiesAdapter;
    }

    static /* synthetic */ ActivitiesAdapter access$302(PickApplicationActivity r0, ActivitiesAdapter r1) {
        r0.mActivitiesAdapter = r1;
        return r1;
    }

    static /* synthetic */ ArrayList access$400(PickApplicationActivity r0) {
        return r0.getActivityEntries();
    }

    static /* synthetic */ ListView access$500(PickApplicationActivity r0) {
        return r0.mListView;
    }

    public void com_android_settings_applications_PickApplicationActivity__onCreate$___twin___(Bundle r5) {
        super.onCreate(r5);
        setContentView(R.layout.manage_applications_layout);
        Intent r6 = getIntent();
        this.mSelectedPkg = r6.getStringExtra("package_name");
        this.mAllowNone = r6.getBooleanExtra(EXTRA_ALLOW_NONE, false);
        this.mSelectedActivity = r6.getStringExtra(EXTRA_ACTIVITY_NAME);
        this.mSelectedUserId = r6.getIntExtra(EXTRA_USER, UserHandle.myUserId());
        this.mTitle = (OFloatingTitleBar) findViewById(R.id.view_title);
        this.mTitle.setCenterTitle(getString(R.string.choose_app));
        this.mTitle.addStartAction(R.drawable.o_floating_title_bar_icon_back, -1, null).setOnClickListener(new AnonymousClass1(this));
        this.mListView = (ListView) findViewById(R.id.listView);
        View r7 = Utils.inflateListTransparentHeader(this);
        this.mListView.addFooterView(r7);
        this.mListView.setOnItemClickListener(new AnonymousClass2(this));
        final Handler r8 = new Handler();
        final BytedanceProgressDialog r0 = new BytedanceProgressDialog(this);
        r0.setMessage(getText(R.string.application_manager_empty_view_text));
        final Runnable r1 = new AnonymousClass3(this, r0);
        r8.postDelayed(r1, 1000);
        ExecutorManager.execute(new AnonymousClass4(this, r8, r1, r0));
    }

    public void com_android_settings_applications_PickApplicationActivity__onResume$___twin___() {
        super.onResume();
        updateHeaderViews();
    }

    private void updateHeaderViews() {
        LinearLayout r0 = this.mHeaderView;
        if (r0 == null) goto L5;
        this.mListView.removeHeaderView(r0);
        this.mHeaderView.removeAllViews();
        this.mHeaderView = null;
    L5:
        LinearLayout r1 = new LinearLayout(this);
        this.mHeaderView = r1;
        r1.setOrientation(1);
        AbsListView.LayoutParams r2 = new AbsListView.LayoutParams(-1, -2);
        this.mHeaderView.setLayoutParams(r2);
        this.mHeaderView.addView(Utils.inflateListTransparentHeader(this));
        if (this.mAllowNone == false) goto L8;
        this.mHeaderView.addView(initNoneSettingsItem());
        LinearLayout r3 = this.mHeaderView;
        r3.addView(Utils.inflateGapView(r3));
    L8:
        this.mListView.addHeaderView(this.mHeaderView);
    }

    private View initNoneSettingsItem() {
        SettingItemCheck r0 = new SettingItemCheck(this);
        r0.setTitle(getString(R.string.undefined));
        r0.setBackgroundResource(R.drawable.selector_setting_sub_item_bg_single);
        r0.setChecked(TextUtils.isEmpty(this.mSelectedPkg));
        r0.setOnClickListener(new AnonymousClass5(this));
        return r0;
    }

    private ArrayList<ActivityEntry> getActivityEntries() {
        PackageManager r0 = getPackageManager();
        if (r0 == null) goto L5;
        AnonymousClass1 r3 = null;
        Intent r1 = new Intent("android.intent.action.MAIN", null);
        r1.addCategory("android.intent.category.LAUNCHER");
        List<ResolveInfo> r2 = r0.queryIntentActivities(r1, 0);
        if (UserHandle.myUserId() != 0) goto L16;
        List r4 = r0.getInstalledPackagesAsUser(0, 10);
        if (r4 == null) goto L16;
        if (r4.size() <= 0) goto L16;
        HashSet r6 = new HashSet(r4.size());
        Iterator r5 = r4.iterator();
    L14:
        if (r5.hasNext() == false) goto L17;
        r6.add(((PackageInfo) r5.next()).packageName);
    L17:
        ArrayList<ActivityEntry> r7 = new ArrayList();
        String[] r8 = getResources().getStringArray(R.array.common_white_app_list);
        if (r2 != null) goto L20;
        return r7;
    L20:
        int r9 = 0;
    L22:
        if (r9 >= r2.size()) goto L46;
        ResolveInfo r10 = r2.get(r9);
        if (isBlackListApp(r10.activityInfo.packageName, r8) == true) goto L45;
        ActivityEntry r11 = new ActivityEntry(r3);     // Catch: PackageManager.NameNotFoundException -> L43
        r11.icon = r10.loadIcon(r0);     // Catch: PackageManager.NameNotFoundException -> L43
        if (r11.icon.getIntrinsicWidth() <= 96) goto L32;
        Drawable r12 = r10.loadIcon(r0);     // Catch: PackageManager.NameNotFoundException -> L43
        if (r12 == null) goto L45;
        r11.icon = new BitmapDrawable(null, Utils.resizeAppIcon(((BitmapDrawable) r12).getBitmap()));     // Catch: PackageManager.NameNotFoundException -> L43
    L32:
        r11.activityName = r10.activityInfo.name;     // Catch: PackageManager.NameNotFoundException -> L43
        r11.packageName = r10.activityInfo.packageName;     // Catch: PackageManager.NameNotFoundException -> L43
        r11.label = r10.loadLabel(r0);     // Catch: PackageManager.NameNotFoundException -> L43
        if (TextUtils.isEmpty(r11.label) == false) goto L37;
        ApplicationInfo r13 = r0.getApplicationInfo(r11.packageName, 0);     // Catch: PackageManager.NameNotFoundException -> L43
        if (r13 == null) goto L37;
        r11.label = r13.loadLabel(r0);     // Catch: PackageManager.NameNotFoundException -> L43
    L37:
        r7.add(r11);     // Catch: PackageManager.NameNotFoundException -> L43
        if (r6 == null) goto L45;
        if (r6.contains(r11.packageName) == false) goto L45;
        r7.add(ActivityEntry.clone(r11, 10, getResources()));     // Catch: PackageManager.NameNotFoundException -> L43
    L43:
        e = move-exception;
        e.printStackTrace();
    L45:
        r9 = r9 + 1;
        goto L22
    L46:
        r2.clear();
        Collections.sort(r7, new AnonymousClass6(this));
        return r7;
    L16:
        r6 = null;
        goto L17
    L5:
        return new ArrayList();
    }

    private boolean isBlackListApp(String r4, String[] r5) {
        if (Utils.APP_STORE_PACKAGE.equals(r4) == false) goto L8;
        if (Utils.isCmccVersion(this) == false) goto L8;
        return true;
    L8:
        if ("com.bytedanceos.sidebar".equals(r4) == false) goto L10;
        return true;
    L10:
        int r0 = 0;
    L12:
        if (r0 >= r5.length) goto L17;
        if (r5[r0].equals(r4) == true) goto L15;
        r0 = r0 + 1;
        goto L12
    L15:
        return true;
    L17:
        return false;
    }

    public void com_android_settings_applications_PickApplicationActivity__onDestroy$___twin___() {
        super.onDestroy();
        if (this.mActivitiesAdapter == null) goto L6;
        this.mActivitiesAdapter = null;
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_applications_PickApplicationActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(PickApplicationActivity r1) {
        com_android_settings_applications_PickApplicationActivity_com_obric_hook_lancet_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_applications_PickApplicationActivity_com_obric_hook_lancet_PrivacyHook_onCreate(PickApplicationActivity r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        PickApplicationActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_applications_PickApplicationActivity__onCreate$___twin___(r4);
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_applications_PickApplicationActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(PickApplicationActivity r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_applications_PickApplicationActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_applications_PickApplicationActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(PickApplicationActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_applications_PickApplicationActivity_com_obric_hook_lancet_PrivacyHook_onResume(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        PickApplicationActivity r5 = r4;
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
    public static void com_android_settings_applications_PickApplicationActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(PickApplicationActivity r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_applications_PickApplicationActivity__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_applications_PickApplicationActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(PickApplicationActivity r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_applications_PickApplicationActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @Insert("onResume")
    public static void com_android_settings_applications_PickApplicationActivity_com_obric_hook_lancet_PrivacyHook_onResume(PickApplicationActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        PickApplicationActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_applications_PickApplicationActivity__onResume$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_applications_PickApplicationActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(PickApplicationActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_applications_PickApplicationActivity_com_obric_hook_lancet_PrivacyHook_onPause(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @Insert("onPause")
    public static void com_android_settings_applications_PickApplicationActivity_com_obric_hook_lancet_PrivacyHook_onPause(PickApplicationActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        PickApplicationActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_applications_PickApplicationActivity__onPause$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_applications_PickApplicationActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(PickApplicationActivity r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        com_android_settings_applications_PickApplicationActivity_com_obric_hook_lancet_PrivacyHook_onCreate(r3, r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        PickApplicationActivity r5 = r3;
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
    public static void com_android_settings_applications_PickApplicationActivity_com_obric_hook_lancet_PrivacyHook_onStop(PickApplicationActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        PickApplicationActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_applications_PickApplicationActivity__onStop$___twin___();
    }

    @Insert("onDestroy")
    public static void com_android_settings_applications_PickApplicationActivity_com_obric_hook_lancet_PrivacyHook_onDestroy(PickApplicationActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        PickApplicationActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperDestroy();
        return;
    L6:
        r3.com_android_settings_applications_PickApplicationActivity__onDestroy$___twin___();
    }
}
