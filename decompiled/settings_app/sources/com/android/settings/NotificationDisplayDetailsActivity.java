package com.android.settings;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.UserHandle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.android.internal.widget.LockPatternUtils;
import com.android.settings.base.BaseActivity;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.NotificationHelper;
import com.android.settings.utils.NullSafe;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.common.oea.style.scene.transition.TransitionAnimHelper;
import com.obric.common.oea.style.scene.transition.TransitionAnimStyle;
import com.obric.olog.OLog;
import com.obric.oui.lisitem.OListItemCheck;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class NotificationDisplayDetailsActivity extends BaseActivity {
    public static final String EXTRA_APP_UID = "appUid";
    public static final String EXTRA_PACKAGE_NAME = "packageName";
    public static final String FROM = "notification";
    private boolean hasLockScreenPassword;
    private BaseAdapter mAdapter;
    private int mAppUid;
    private int mCurrentIndex;
    private LockPatternUtils mLockPatternUtils;
    private String[] mOptions;
    private ListView mOptionsList;
    private String mPackageName;
    private Integer[] mValues;

    private class NotificationDetailAdapter extends BaseAdapter {
        private Context mContext;
        final /* synthetic */ NotificationDisplayDetailsActivity this$0;

        @Override // android.widget.Adapter
        public long getItemId(int r1) {
            return r1;
        }

        public NotificationDetailAdapter(NotificationDisplayDetailsActivity r1, Context r2) {
            this.this$0 = r1;
            this.mContext = r2;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return NotificationDisplayDetailsActivity.access$100(this.this$0).length;
        }

        @Override // android.widget.Adapter
        public Object getItem(int r1) {
            return Integer.valueOf(r1);
        }

        @Override // android.widget.Adapter
        public View getView(int r3, View r4, ViewGroup r5) {
            if (r4 != null) goto L4;
            r4 = View.inflate(this.mContext, R.layout.olist_content_item_check, null);
            OListItemCheck r6 = (OListItemCheck) NullSafe.nonNull(r4.findViewById(R.id.item_check));
            r4.setTag(r6);
        L5:
            r6.setTitle(NotificationDisplayDetailsActivity.access$700(this.this$0)[r3]);
            r6.setTrailingImageView(this.mContext.getDrawable(R.drawable.icon_check_confirm_rounded));
            if (r3 != NotificationDisplayDetailsActivity.access$200(this.this$0)) goto L8;
            boolean r0 = true;
        L9:
            r6.setChecked(r0);
            if (NotificationDisplayDetailsActivity.access$100(this.this$0)[r3].intValue() != 0) goto L12;
            r6.setEnabled(NotificationDisplayDetailsActivity.access$300(this.this$0));
        L12:
            return r4;
        L8:
            r0 = false;
            goto L9
        L4:
            r6 = (OListItemCheck) r4.getTag();
            goto L5
        }
    }

    public void com_android_settings_NotificationDisplayDetailsActivity__onPause$___twin___() {
        super.onPause();
    }

    public void com_android_settings_NotificationDisplayDetailsActivity__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_NotificationDisplayDetailsActivity__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // com.android.settings.base.BaseActivity, android.app.Activity
    public void finish() {
        com_android_settings_NotificationDisplayDetailsActivity_com_obric_hook_lancet_PrivacyHook_finish(this);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_settings_NotificationDisplayDetailsActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com_android_settings_NotificationDisplayDetailsActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        com_android_settings_NotificationDisplayDetailsActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_settings_NotificationDisplayDetailsActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_NotificationDisplayDetailsActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public NotificationDisplayDetailsActivity() {
    }

    static /* synthetic */ ListView access$000(NotificationDisplayDetailsActivity r0) {
        return r0.mOptionsList;
    }

    static /* synthetic */ Integer[] access$100(NotificationDisplayDetailsActivity r0) {
        return r0.mValues;
    }

    static /* synthetic */ int access$200(NotificationDisplayDetailsActivity r0) {
        return r0.mCurrentIndex;
    }

    static /* synthetic */ int access$202(NotificationDisplayDetailsActivity r0, int r1) {
        r0.mCurrentIndex = r1;
        return r1;
    }

    static /* synthetic */ boolean access$300(NotificationDisplayDetailsActivity r0) {
        return r0.hasLockScreenPassword;
    }

    static /* synthetic */ BaseAdapter access$400(NotificationDisplayDetailsActivity r0) {
        return r0.mAdapter;
    }

    static /* synthetic */ String access$500(NotificationDisplayDetailsActivity r0) {
        return r0.mPackageName;
    }

    static /* synthetic */ int access$600(NotificationDisplayDetailsActivity r0) {
        return r0.mAppUid;
    }

    static /* synthetic */ String[] access$700(NotificationDisplayDetailsActivity r0) {
        return r0.mOptions;
    }

    public void com_android_settings_NotificationDisplayDetailsActivity__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
        setContentView(R.layout.options_layout);
        parseIntent();
        initView();
        setupBackBtnOnTitle();
    }

    private void initView() {
        ((OFloatingTitleBar) NullSafe.nonNull(findViewById(R.id.view_title))).setCenterTitle(R.string.notification_detail);
        this.mOptionsList = (ListView) NullSafe.nonNull(findViewById(R.id.options_list));
        this.mOptions = getResources().getStringArray(R.array.notification_display_details);
        this.mValues = new Integer[]{1, 0};
        this.mOptionsList.addHeaderView(Utils.inflateListTransparentHeader(this, this.mOptionsList, false));
        View r0 = Utils.inflateGapView(this.mOptionsList);
        ViewGroup.LayoutParams r2 = r0.getLayoutParams();
        r2.height = getResources().getDimensionPixelSize(R.dimen.mid_container_top_bottom_padding);
        r0.setLayoutParams(r2);
        this.mOptionsList.addFooterView(r0);
        TextView r1 = new TextView(this, null, R.style.ListContentItemSummaryStyle);
        r1.setText(R.string.notification_show_detail_tips);
        this.mOptionsList.addFooterView(r1);
        NotificationDetailAdapter r3 = new NotificationDetailAdapter(this, this);
        this.mAdapter = r3;
        this.mOptionsList.setAdapter(r3);
        this.mLockPatternUtils = new ChooseLockSettingsHelper(this).utils();
        this.mOptionsList.setOnItemClickListener(new AnonymousClass1(this));
        Utils.setListViewIgnoreAccessibilityItemCount(this.mOptionsList, 1);
    }

    public void com_android_settings_NotificationDisplayDetailsActivity__onResume$___twin___() {
        super.onResume();
        int r1 = 0;
        if (this.mLockPatternUtils.isSecure(UserHandle.myUserId()) == false) goto L5;
    L8:
        boolean r0 = true;
    L9:
        this.hasLockScreenPassword = r0;
        int r2 = NotificationHelper.getInstance().getNotificationsVisibilityForPackage(this.mPackageName, this.mAppUid);
    L10:
        Integer[] r3 = this.mValues;
        if (r1 >= r3.length) goto L16;
        if (r3[r1].intValue() != r2) goto L15;
        this.mCurrentIndex = r1;
    L15:
        r1 = r1 + 1;
        goto L10
    L16:
        this.mAdapter.notifyDataSetChanged();
        return;
    L5:
        if (this.mLockPatternUtils.isLockScreenDisabled(UserHandle.myUserId()) == true) goto L8;
        r0 = false;
        goto L9
    }

    private void parseIntent() {
        Intent r0 = getIntent();
        if (r0 != null) goto L5;
        return;
    L5:
        this.mPackageName = r0.getStringExtra(EXTRA_PACKAGE_NAME);
        this.mAppUid = r0.getIntExtra(EXTRA_APP_UID, 0);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int r2, int r3, Intent r4) {
        super.onActivityResult(r2, r3, r4);
        if (r2 == 200) goto L5;
        return;
    L5:
        if (r3 != (-1)) goto L19;
        int r0 = 0;
        NotificationHelper.getInstance().setNotificationsVisibilityForPackage(this.mPackageName, this.mAppUid, 0);
    L7:
        Integer[] r5 = this.mValues;
        if (r0 >= r5.length) goto L13;
        if (r5[r0].intValue() != 0) goto L12;
        this.mCurrentIndex = r0;
    L12:
        r0 = r0 + 1;
        goto L7
    L13:
        this.mAdapter.notifyDataSetChanged();
        return;
    }

    public void com_android_settings_NotificationDisplayDetailsActivity__finish$___twin___() {
        super.finish();
        TransitionAnimHelper.overrideExitAnim(this, TransitionAnimStyle.Standard);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_NotificationDisplayDetailsActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(NotificationDisplayDetailsActivity r1) {
        com_android_settings_NotificationDisplayDetailsActivity_com_obric_hook_lancet_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_NotificationDisplayDetailsActivity_com_obric_hook_lancet_PrivacyHook_onCreate(NotificationDisplayDetailsActivity r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        NotificationDisplayDetailsActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_NotificationDisplayDetailsActivity__onCreate$___twin___(r4);
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_NotificationDisplayDetailsActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(NotificationDisplayDetailsActivity r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_NotificationDisplayDetailsActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_NotificationDisplayDetailsActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(NotificationDisplayDetailsActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_NotificationDisplayDetailsActivity_com_obric_hook_lancet_PrivacyHook_onResume(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        NotificationDisplayDetailsActivity r5 = r4;
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
    public static void com_android_settings_NotificationDisplayDetailsActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(NotificationDisplayDetailsActivity r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_NotificationDisplayDetailsActivity__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_NotificationDisplayDetailsActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(NotificationDisplayDetailsActivity r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_NotificationDisplayDetailsActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @Insert("onResume")
    public static void com_android_settings_NotificationDisplayDetailsActivity_com_obric_hook_lancet_PrivacyHook_onResume(NotificationDisplayDetailsActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        NotificationDisplayDetailsActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_NotificationDisplayDetailsActivity__onResume$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_NotificationDisplayDetailsActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(NotificationDisplayDetailsActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_NotificationDisplayDetailsActivity_com_obric_hook_lancet_PrivacyHook_onPause(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @Insert("onPause")
    public static void com_android_settings_NotificationDisplayDetailsActivity_com_obric_hook_lancet_PrivacyHook_onPause(NotificationDisplayDetailsActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        NotificationDisplayDetailsActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_NotificationDisplayDetailsActivity__onPause$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_NotificationDisplayDetailsActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(NotificationDisplayDetailsActivity r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        com_android_settings_NotificationDisplayDetailsActivity_com_obric_hook_lancet_PrivacyHook_onCreate(r3, r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        NotificationDisplayDetailsActivity r5 = r3;
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
    public static void com_android_settings_NotificationDisplayDetailsActivity_com_obric_hook_lancet_PrivacyHook_onStop(NotificationDisplayDetailsActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        NotificationDisplayDetailsActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_NotificationDisplayDetailsActivity__onStop$___twin___();
    }

    @Insert("finish")
    public static void com_android_settings_NotificationDisplayDetailsActivity_com_obric_hook_lancet_PrivacyHook_finish(NotificationDisplayDetailsActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        NotificationDisplayDetailsActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.superFinish();
        return;
    L6:
        r3.com_android_settings_NotificationDisplayDetailsActivity__finish$___twin___();
    }
}
