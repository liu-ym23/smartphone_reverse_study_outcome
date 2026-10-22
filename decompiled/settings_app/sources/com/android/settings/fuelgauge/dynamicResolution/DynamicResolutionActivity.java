package com.android.settings.fuelgauge.dynamicResolution;

import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.LoaderManager;
import android.content.AsyncTaskLoader;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.Loader;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.provider.BaseColumns;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.TextView;
import com.android.settings.NotificationDisplayDetailsActivity;
import com.android.settings.R;
import com.android.settings.applications.ApplicationLabelCache;
import com.android.settings.applications.LabelEntry;
import com.android.settings.base.BaseActivity;
import com.android.settings.teaevent.AppMetricsUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.ListContentItemSwitch;
import obric.widget.SettingItemSwitch;

/* JADX INFO: loaded from: classes2.dex */
public class DynamicResolutionActivity extends BaseActivity implements LoaderManager.LoaderCallbacks<List<DynamicResolutionInfo>> {
    private static final Comparator<DynamicResolutionInfo> ALPHA_COMPARATOR = null;
    private static final String AUTHORITY = "com.bytedanceos.security.dynamicResolution";
    private static final Uri CONTENT_ID_URI_BASE = null;
    private static final Uri CONTENT_URI = null;
    private static final int SHOW_LOADING_VIEW = 1;
    private DynamicResolutionAdapter mAdapter;
    private ActivityManager mAm;
    private CompoundButton.OnCheckedChangeListener mCheckedChangeListener;
    private View mEmptyView;
    private AlertDialog mEnableDialog;
    private View mGameListTitle;
    private Handler mHandler;
    private boolean mHasCallKillAllGames;
    private View mHeaderView;
    private LayoutInflater mInflater;
    private ListView mListView;
    private View mLoadingView;
    private int mMode;
    private Set<Integer> mRunningUids;
    private ExecutorService mSingleTask;
    private int mState;

    private static class AppListLoader extends AsyncTaskLoader<List<DynamicResolutionInfo>> {
        final PackageManager mPm;
        String[] mProjection;
        String mSelection;
        String[] mSelectionArgs;
        String mSortOrder;
        Uri mUri;

        @Override // android.content.AsyncTaskLoader
        public /* bridge */ /* synthetic */ List<DynamicResolutionInfo> loadInBackground() {
            return loadInBackground2();
        }

        AppListLoader(Context r1, Uri r2, String[] r3, String r4, String[] r5, String r6) {
            super(r1);
            this.mPm = r1.getPackageManager();
            this.mUri = r2;
            this.mProjection = r3;
            this.mSelection = r4;
            this.mSelectionArgs = r5;
            this.mSortOrder = r6;
        }

        @Override // android.content.Loader
        protected void onStartLoading() {
            super.onStartLoading();
            forceLoad();
        }

        @Override // android.content.Loader
        protected void onStopLoading() {
            super.onStopLoading();
            cancelLoad();
        }

        @Override // android.content.AsyncTaskLoader
        /* JADX INFO: renamed from: loadInBackground, reason: avoid collision after fix types in other method */
        public List<DynamicResolutionInfo> loadInBackground2() {
            ArrayList r0 = new ArrayList();
            Cursor r1 = null;
            Cursor r2 = getContext().getContentResolver().query(this.mUri, this.mProjection, this.mSelection, this.mSelectionArgs, this.mSortOrder);     // Catch: Throwable -> L23 Exception -> L25
            if (r2 != null) goto L10;
            List<DynamicResolutionInfo> r11 = Collections.EMPTY_LIST;     // Catch: Throwable -> L23 Exception -> L25
            if (r2 == null) goto L8;
            r2.close();
        L8:
            return r11;
        L10:
            if (r2.moveToNext() == false) goto L19;
            int r5 = r2.getInt(0);     // Catch: Throwable -> L23 Exception -> L25
            String r3 = r2.getString(1);     // Catch: Throwable -> L23 Exception -> L25
            final PackageInfo r10 = this.mPm.getPackageInfo(r3, 8192);     // Catch: PackageManager.NameNotFoundException -> L17 Throwable -> L23 Exception -> L25
            LabelEntry r4 = ApplicationLabelCache.getInstance().getLabelEntry(getContext(), r3);     // Catch: PackageManager.NameNotFoundException -> L17 Throwable -> L23 Exception -> L25
            if (r4 != null) goto L15;
            r4 = ApplicationLabelCache.getInstance().getLabelEntryForApplication(getContext(), r10.applicationInfo);     // Catch: PackageManager.NameNotFoundException -> L17 Throwable -> L23 Exception -> L25
        L15:
            final DynamicResolutionInfo r6 = new DynamicResolutionInfo(r10, r5, r4, null, r2.getInt(2), r2.getString(3));     // Catch: PackageManager.NameNotFoundException -> L17 Throwable -> L23 Exception -> L25
            AsyncTask.execute(new AnonymousClass1(this, r6, r10));     // Catch: PackageManager.NameNotFoundException -> L17 Throwable -> L23 Exception -> L25
            r0.add(r6);     // Catch: PackageManager.NameNotFoundException -> L17 Throwable -> L23 Exception -> L25
        L17:
            e = move-exception;
            e.printStackTrace();     // Catch: Throwable -> L23 Exception -> L25
            goto L10
        L19:
            Collections.sort(r0, DynamicResolutionActivity.access$1300());     // Catch: Throwable -> L23 Exception -> L25
            if (r2 == null) goto L22;
            r2.close();
        L22:
            return r0;
        L25:
            e = move-exception;
            e.printStackTrace();     // Catch: Throwable -> L23
            if (0 == 0) goto L29;
            r1.close();
        L29:
            return r0;
        L23:
            th = move-exception;
            if (0 == 0) goto L32;
            r1.close();
        L32:
            throw th;
        }

        @Override // android.content.Loader
        protected void onReset() {
            cancelLoad();
        }
    }

    private class DynamicResolutionAdapter extends ArrayAdapter<DynamicResolutionInfo> {
        final PackageManager mPm;
        final /* synthetic */ DynamicResolutionActivity this$0;

        DynamicResolutionAdapter(DynamicResolutionActivity r1, Context r2) {
            this.this$0 = r1;
            super(r2, R.layout.dynamic_resolution_item);
            this.mPm = r2.getPackageManager();
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int r6, View r7, ViewGroup r8) {
            boolean r0 = false;
            if (r7 != null) goto L5;
            r7 = DynamicResolutionActivity.access$1400(this.this$0).inflate(R.layout.dynamic_resolution_item, r8, false);
            ViewHolder r9 = new ViewHolder(r7);
            r7.setTag(r9);
        L6:
            DynamicResolutionInfo r1 = getItem(r6);
            if (r1.icon == null) goto L9;
            r9.itemSwitch.setIcon(r1.icon);
        L10:
            r9.itemSwitch.getSwitch().setTag(r1);
            r9.itemSwitch.setTitle(r1.mLabelEntry.label);
            if (getCount() != 1) goto L13;
            int r10 = 1;
        L19:
            r9.itemSwitch.setBackgroundStyle(r10);
            ListContentItemSwitch r11 = r9.itemSwitch;
            if (DynamicResolutionActivity.access$600(this.this$0) == (-1)) goto L22;
            boolean r2 = true;
        L23:
            r11.setEnabled(r2);
            r9.itemSwitch.setOnCheckedChangeListener(null);
            ListContentItemSwitch r12 = r9.itemSwitch;
            if (r1.enable != 1) goto L26;
            r0 = true;
        L26:
            r12.setChecked(r0);
            r9.itemSwitch.setOnCheckedChangeListener(DynamicResolutionActivity.access$1500(this.this$0));
            return r7;
        L22:
            r2 = false;
            goto L23
        L13:
            if (r6 != 0) goto L16;
            r10 = 2;
            goto L19
        L16:
            if (r6 != (getCount() - 1)) goto L18;
            r10 = 4;
            goto L19
        L18:
            r10 = 3;
            goto L19
        L9:
            r1.icon = r1.mPackageInfo.applicationInfo.loadIcon(this.mPm);
            r9.itemSwitch.setIcon(r1.icon);
            goto L10
        L5:
            r9 = (ViewHolder) r7.getTag();
            goto L6
        }
    }

    static class DynamicResolutionInfo {
        int enable;
        Drawable icon;
        int id;
        LabelEntry mLabelEntry;
        PackageInfo mPackageInfo;
        String version;

        DynamicResolutionInfo(PackageInfo r1, int r2, LabelEntry r3, Drawable r4, int r5, String r6) {
            this.mPackageInfo = r1;
            this.id = r2;
            this.mLabelEntry = r3;
            this.icon = r4;
            this.enable = r5;
            this.version = r6;
        }
    }

    static class ItemColumns implements BaseColumns {
        static final int DISABLED = 0;
        static final String ENABLE = "enable";
        static final int ENABLED = 1;
        static final String INSTALL = "installed";
        static final int INSTALLED = 1;
        static final String PACKAGE_NAME = "packageName";
        static final String PARAM = "param";
        static final String SM_VERSION = "smversion";
        static final String SUPPORT_PRODUCT = "support_product";
        static final int UNINSTALLED = 0;
        static final String VERSION = "version";

        ItemColumns() {
        }
    }

    private static class ViewHolder {
        public ListContentItemSwitch itemSwitch;

        public ViewHolder(View r2) {
            this.itemSwitch = (ListContentItemSwitch) r2.findViewById(R.id.dynamic_resolution_switcher);
        }
    }

    public void com_android_settings_fuelgauge_dynamicResolution_DynamicResolutionActivity__onPause$___twin___() {
        super.onPause();
    }

    public void com_android_settings_fuelgauge_dynamicResolution_DynamicResolutionActivity__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // com.android.settings.base.BaseActivity, android.app.Activity
    public void finish() {
        com_android_settings_fuelgauge_dynamicResolution_DynamicResolutionActivity_com_obric_hook_lancet_PrivacyHook_finish(this);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r1) {
        com_android_settings_fuelgauge_dynamicResolution_DynamicResolutionActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com_android_settings_fuelgauge_dynamicResolution_DynamicResolutionActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        com_android_settings_fuelgauge_dynamicResolution_DynamicResolutionActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        com_android_settings_fuelgauge_dynamicResolution_DynamicResolutionActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_fuelgauge_dynamicResolution_DynamicResolutionActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public DynamicResolutionActivity() {
        this.mHasCallKillAllGames = false;
        this.mHandler = new AnonymousClass1(this);
        this.mSingleTask = Executors.newSingleThreadExecutor();
        this.mCheckedChangeListener = new AnonymousClass2(this);
    }

    static /* synthetic */ View access$000(DynamicResolutionActivity r0) {
        return r0.mLoadingView;
    }

    static /* synthetic */ void access$100(DynamicResolutionActivity r0, DynamicResolutionInfo r1) {
        r0.showEnableDialog(r1);
    }

    static /* synthetic */ void access$1000(DynamicResolutionActivity r0) {
        r0.updateAllDynamicGameSettings();
    }

    static /* synthetic */ void access$1100(DynamicResolutionActivity r0) {
        r0.killAllDynamicGame();
    }

    static /* synthetic */ Uri access$1200() {
        return CONTENT_URI;
    }

    static /* synthetic */ Comparator access$1300() {
        return ALPHA_COMPARATOR;
    }

    static /* synthetic */ LayoutInflater access$1400(DynamicResolutionActivity r0) {
        return r0.mInflater;
    }

    static /* synthetic */ CompoundButton.OnCheckedChangeListener access$1500(DynamicResolutionActivity r0) {
        return r0.mCheckedChangeListener;
    }

    static /* synthetic */ AlertDialog access$1602(DynamicResolutionActivity r0, AlertDialog r1) {
        r0.mEnableDialog = r1;
        return r1;
    }

    static /* synthetic */ void access$200(DynamicResolutionActivity r0, DynamicResolutionInfo r1, int r2) {
        r0.updateDynamicResolution(r1, r2);
    }

    static /* synthetic */ Uri access$300() {
        return CONTENT_ID_URI_BASE;
    }

    static /* synthetic */ Set access$400(DynamicResolutionActivity r0) {
        return r0.mRunningUids;
    }

    static /* synthetic */ ActivityManager access$500(DynamicResolutionActivity r0) {
        return r0.mAm;
    }

    static /* synthetic */ int access$600(DynamicResolutionActivity r0) {
        return r0.mState;
    }

    static /* synthetic */ int access$602(DynamicResolutionActivity r0, int r1) {
        r0.mState = r1;
        return r1;
    }

    static /* synthetic */ int access$700(DynamicResolutionActivity r0) {
        return r0.mMode;
    }

    static /* synthetic */ int access$702(DynamicResolutionActivity r0, int r1) {
        r0.mMode = r1;
        return r1;
    }

    static /* synthetic */ void access$800(DynamicResolutionActivity r0, ListContentItemSwitch r1, View r2, View r3) {
        r0.updateHeaderView(r1, r2, r3);
    }

    static /* synthetic */ DynamicResolutionAdapter access$900(DynamicResolutionActivity r0) {
        return r0.mAdapter;
    }

    @Override // android.app.LoaderManager.LoaderCallbacks
    public /* bridge */ /* synthetic */ void onLoadFinished(Loader<List<DynamicResolutionInfo>> r1, List<DynamicResolutionInfo> r2) {
        onLoadFinished2(r1, r2);
    }

    static {
        CONTENT_URI = Uri.parse("content://com.bytedanceos.security.dynamicResolution/dynamicResolution");
        CONTENT_ID_URI_BASE = Uri.parse("content://com.bytedanceos.security.dynamicResolution/dynamicResolution/");
        ALPHA_COMPARATOR = new AnonymousClass8();
    }

    private void updateDynamicResolution(final DynamicResolutionInfo r3, final int r4) {
        r3.enable = r4;
        this.mAdapter.notifyDataSetChanged();
        this.mSingleTask.execute(new AnonymousClass3(this, r3, r4));
    }

    public void com_android_settings_fuelgauge_dynamicResolution_DynamicResolutionActivity__onCreate$___twin___(Bundle r3) {
        super.onCreate(r3);
        getLoaderManager().initLoader(0, null, this);
        setContentView(R.layout.dynamic_resolution_layout);
        this.mAm = (ActivityManager) getSystemService("activity");
        this.mInflater = LayoutInflater.from(this);
        this.mListView = (ListView) findViewById(R.id.view_list);
        this.mLoadingView = findViewById(R.id.loading_container);
        this.mAdapter = new DynamicResolutionAdapter(this, getBaseContext());
        initHeaderView();
        this.mListView.addHeaderView(this.mHeaderView);
        this.mListView.setAdapter(this.mAdapter);
        setupBackBtnOnTitle(false);
        this.mListView.setVisibility(4);
        this.mHandler.sendEmptyMessageDelayed(1, 250);
    }

    public void com_android_settings_fuelgauge_dynamicResolution_DynamicResolutionActivity__onResume$___twin___() {
        super.onResume();
        List<ActivityManager.RunningAppProcessInfo> r0 = this.mAm.getRunningAppProcesses();
        Set<Integer> r1 = this.mRunningUids;
        if (r1 != null) goto L5;
        this.mRunningUids = new HashSet();
    L6:
        Iterator<ActivityManager.RunningAppProcessInfo> r2 = r0.iterator();
    L8:
        if (r2.hasNext() == false) goto L12;
        ActivityManager.RunningAppProcessInfo r3 = r2.next();
        if (r3.uid <= 10000) goto L8;
        this.mRunningUids.add(Integer.valueOf(r3.uid));
        goto L8
    L12:
        this.mHasCallKillAllGames = false;
        return;
    L5:
        r1.clear();
        goto L6
    }

    public void com_android_settings_fuelgauge_dynamicResolution_DynamicResolutionActivity__onStop$___twin___() {
        super.onStop();
        AlertDialog r0 = this.mEnableDialog;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isShowing() == false) goto L9;
        this.mEnableDialog.dismiss();
        return;
    }

    public void com_android_settings_fuelgauge_dynamicResolution_DynamicResolutionActivity__finish$___twin___() {
        Intent r0 = getIntent();
        r0.putExtra("extra_index", this.mState);
        setResult(-1, r0);
        super.finish();
    }

    private void initHeaderView() {
        View r0 = this.mInflater.inflate(R.layout.dynamic_resolution_header, null);
        this.mHeaderView = r0;
        this.mEmptyView = r0.findViewById(R.id.empty_view);
        final ListContentItemSwitch r1 = (ListContentItemSwitch) this.mHeaderView.findViewById(R.id.dynamic_resolution_enabled);
        final View r2 = this.mHeaderView.findViewById(R.id.dynamic_resolution_smart);
        final View r3 = this.mHeaderView.findViewById(R.id.dynamic_resolution_always);
        this.mGameListTitle = this.mHeaderView.findViewById(R.id.dynamic_resolution_game_list_title);
        View.OnClickListener r4 = new AnonymousClass4(this, r1, r2, r3);
        this.mState = getIntent().getIntExtra("extra_index", -1);
        if (getIntent().getBooleanExtra("from_search", false) == false) goto L5;
        this.mState = Settings.Global.getInt(getContentResolver(), "dynamic_resolution_state", -1);
    L5:
        this.mMode = Settings.Global.getInt(getContentResolver(), DynamicResolutionConfig.DYNAMIC_RES_ENABLED_MODE, 0);
        updateHeaderView(r1, r2, r3);
        r1.setOnCheckedChangeListener(new AnonymousClass5(this, r1, r2, r3));
        r3.setOnClickListener(r4);
        r2.setOnClickListener(r4);
    }

    private void updateHeaderView(ListContentItemSwitch r9, View r10, View r11) {
        View r0 = r10.findViewById(R.id.dynamic_resolution_smart_image);
        View r1 = r11.findViewById(R.id.dynamic_resolution_always_image);
        TextView r2 = (TextView) r10.findViewById(R.id.dynamic_resolution_smart_text);
        TextView r3 = (TextView) r11.findViewById(R.id.dynamic_resolution_always_text);
        int r7 = 0;
        if (this.mState != (-1)) goto L5;
        r9.setChecked(false);
        r11.setEnabled(false);
        r1.setEnabled(false);
        r3.setEnabled(false);
        r10.setEnabled(false);
        r0.setEnabled(false);
        r2.setEnabled(false);
    L7:
        if (this.mMode != 0) goto L9;
        int r12 = 0;
    L10:
        r0.setVisibility(r12);
        if (this.mMode == 1) goto L14;
        r7 = 8;
    L14:
        r1.setVisibility(r7);
        return;
    L9:
        r12 = 8;
        goto L10
    L5:
        r9.setChecked(true);
        r11.setEnabled(true);
        r1.setEnabled(true);
        r3.setEnabled(true);
        r10.setEnabled(true);
        r0.setEnabled(true);
        r2.setEnabled(true);
        goto L7
    }

    @Override // android.app.LoaderManager.LoaderCallbacks
    public Loader<List<DynamicResolutionInfo>> onCreateLoader(int r8, Bundle r9) {
        AsyncTask.setDefaultExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        return new AppListLoader(this, CONTENT_URI, new String[]{"_id", NotificationDisplayDetailsActivity.EXTRA_PACKAGE_NAME, "enable", "smversion"}, "installed=?", new String[]{"1"}, null);
    }

    /* JADX INFO: renamed from: onLoadFinished, reason: avoid collision after fix types in other method */
    public void onLoadFinished2(Loader<List<DynamicResolutionInfo>> r3, List<DynamicResolutionInfo> r4) {
        this.mHandler.removeMessages(1);
        this.mLoadingView.setVisibility(8);
        this.mListView.setVisibility(0);
        this.mAdapter.clear();
        if (r4.size() <= 0) goto L5;
        this.mGameListTitle.setVisibility(0);
        this.mEmptyView.setVisibility(8);
    L6:
        this.mAdapter.addAll(r4);
        this.mAdapter.notifyDataSetChanged();
        return;
    L5:
        this.mGameListTitle.setVisibility(8);
        this.mEmptyView.setVisibility(0);
        goto L6
    }

    private void setHeaderEnabled(boolean r6) {
        SettingItemSwitch r0 = (SettingItemSwitch) this.mHeaderView.findViewById(R.id.dynamic_resolution_enabled);
        View r1 = this.mHeaderView.findViewById(R.id.dynamic_resolution_smart);
        View r5 = this.mHeaderView.findViewById(R.id.dynamic_resolution_always);
        r0.setEnabled(r6);
        View r2 = r1.findViewById(R.id.dynamic_resolution_smart_image);
        View r3 = r5.findViewById(R.id.dynamic_resolution_always_image);
        TextView r4 = (TextView) r1.findViewById(R.id.dynamic_resolution_smart_text);
        TextView r7 = (TextView) r5.findViewById(R.id.dynamic_resolution_always_text);
        r1.setEnabled(r6);
        r2.setEnabled(r6);
        r4.setEnabled(r6);
        r5.setEnabled(false);
        r3.setEnabled(r6);
        r7.setEnabled(r6);
    }

    private void updateAllDynamicGameSettings() {
        this.mSingleTask.execute(new AnonymousClass6(this));
    }

    private void killAllDynamicGame() {
        if (this.mHasCallKillAllGames == false) goto L5;
        return;
    L5:
        this.mHasCallKillAllGames = true;
        this.mSingleTask.execute(new AnonymousClass7(this));
    }

    @Override // android.app.LoaderManager.LoaderCallbacks
    public void onLoaderReset(Loader<List<DynamicResolutionInfo>> r1) {
        this.mAdapter.clear();
    }

    private void showEnableDialog(final DynamicResolutionInfo r3) {
        DialogInterface.OnClickListener r0 = new AnonymousClass9(this, r3);
        AlertDialog r4 = new AlertDialog.Builder(this).setTitle(R.string.dlg_dynamic_resolution_tip).setMessage(getString(R.string.dlg_dynamic_resolution_message)).setPositiveButton(getString(R.string.dlg_dynamic_resolution_okay), r0).setNegativeButton(R.string.cancel, r0).create();
        this.mEnableDialog = r4;
        r4.show();
        this.mEnableDialog.getButton(-1).setSingleLine();
        this.mEnableDialog.getButton(-1).setEllipsize(TextUtils.TruncateAt.END);
        this.mEnableDialog.setOnDismissListener(new AnonymousClass10(this));
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_fuelgauge_dynamicResolution_DynamicResolutionActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(DynamicResolutionActivity r1) {
        com_android_settings_fuelgauge_dynamicResolution_DynamicResolutionActivity_com_obric_hook_lancet_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_fuelgauge_dynamicResolution_DynamicResolutionActivity_com_obric_hook_lancet_PrivacyHook_onCreate(DynamicResolutionActivity r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        DynamicResolutionActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_fuelgauge_dynamicResolution_DynamicResolutionActivity__onCreate$___twin___(r4);
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_fuelgauge_dynamicResolution_DynamicResolutionActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(DynamicResolutionActivity r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_fuelgauge_dynamicResolution_DynamicResolutionActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_fuelgauge_dynamicResolution_DynamicResolutionActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(DynamicResolutionActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_fuelgauge_dynamicResolution_DynamicResolutionActivity_com_obric_hook_lancet_PrivacyHook_onResume(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        DynamicResolutionActivity r5 = r4;
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
    public static void com_android_settings_fuelgauge_dynamicResolution_DynamicResolutionActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(DynamicResolutionActivity r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_fuelgauge_dynamicResolution_DynamicResolutionActivity__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_fuelgauge_dynamicResolution_DynamicResolutionActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(DynamicResolutionActivity r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_fuelgauge_dynamicResolution_DynamicResolutionActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @Insert("onResume")
    public static void com_android_settings_fuelgauge_dynamicResolution_DynamicResolutionActivity_com_obric_hook_lancet_PrivacyHook_onResume(DynamicResolutionActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        DynamicResolutionActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_fuelgauge_dynamicResolution_DynamicResolutionActivity__onResume$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_fuelgauge_dynamicResolution_DynamicResolutionActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(DynamicResolutionActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_fuelgauge_dynamicResolution_DynamicResolutionActivity_com_obric_hook_lancet_PrivacyHook_onPause(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @Insert("onPause")
    public static void com_android_settings_fuelgauge_dynamicResolution_DynamicResolutionActivity_com_obric_hook_lancet_PrivacyHook_onPause(DynamicResolutionActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        DynamicResolutionActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_fuelgauge_dynamicResolution_DynamicResolutionActivity__onPause$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_fuelgauge_dynamicResolution_DynamicResolutionActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(DynamicResolutionActivity r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        com_android_settings_fuelgauge_dynamicResolution_DynamicResolutionActivity_com_obric_hook_lancet_PrivacyHook_onCreate(r3, r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        DynamicResolutionActivity r5 = r3;
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
    public static void com_android_settings_fuelgauge_dynamicResolution_DynamicResolutionActivity_com_obric_hook_lancet_PrivacyHook_onStop(DynamicResolutionActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        DynamicResolutionActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_fuelgauge_dynamicResolution_DynamicResolutionActivity__onStop$___twin___();
    }

    @Insert("finish")
    public static void com_android_settings_fuelgauge_dynamicResolution_DynamicResolutionActivity_com_obric_hook_lancet_PrivacyHook_finish(DynamicResolutionActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        DynamicResolutionActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.superFinish();
        return;
    L6:
        r3.com_android_settings_fuelgauge_dynamicResolution_DynamicResolutionActivity__finish$___twin___();
    }
}
