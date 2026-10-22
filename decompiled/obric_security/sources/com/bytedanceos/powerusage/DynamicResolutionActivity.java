package com.bytedanceos.powerusage;

import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.LoaderManager;
import android.content.AsyncTaskLoader;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Loader;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.UserHandle;
import android.provider.BaseColumns;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.bytedanceos.application.ApplicationLabelCache;
import com.bytedanceos.application.LabelEntry;
import com.bytedanceos.security.BaseActivity;
import com.bytedanceos.security.Utils;
import com.obric.oui.OuiWidgetUtils;
import com.obric.oui.bouncelayout.OListView;
import com.obric.security.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import obric.widget.ListContentItemSwitch;

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
    private TextView mGameListTitle;
    private Handler mHandler;
    private boolean mHasCallKillAllGames;
    private View mHeaderView;
    private LayoutInflater mInflater;
    private int mLinAnim;
    private OListView mListView;
    private View mLoadingView;
    private int mLoutAnim;
    private int mMode;
    private int mRinAnim;
    private int mRoutAnim;
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

        AppListLoader(Context context, Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
            super(context);
            this.mPm = context.getPackageManager();
            this.mUri = uri;
            this.mProjection = projection;
            this.mSelection = selection;
            this.mSelectionArgs = selectionArgs;
            this.mSortOrder = sortOrder;
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
            Cursor r0 = getContext().getContentResolver().query(this.mUri, this.mProjection, this.mSelection, this.mSelectionArgs, this.mSortOrder);
            if (r0 == null) goto L5;
            ArrayList r1 = new ArrayList(r0.getCount());
        L8:
            if (r0.moveToNext() == false) goto L20;
            int r5 = r0.getInt(0);
            String r2 = r0.getString(1);
            final PackageInfo r10 = this.mPm.getPackageInfo(r2, 8192);     // Catch: PackageManager.NameNotFoundException -> L18
            if (r10 == null) goto L8;
            LabelEntry r3 = ApplicationLabelCache.getInstance().getLabelEntry(this.mPm, r2);     // Catch: PackageManager.NameNotFoundException -> L18
            if (r3 != null) goto L16;
            r3 = ApplicationLabelCache.getInstance().getLabelEntryForApplication(r10.applicationInfo);     // Catch: PackageManager.NameNotFoundException -> L18
        L16:
            final DynamicResolutionInfo r4 = new DynamicResolutionInfo(r10, r5, r3, null, r0.getInt(2), r0.getString(3));     // Catch: PackageManager.NameNotFoundException -> L18
            AsyncTask.execute(new AnonymousClass1(this, r4, r10));     // Catch: PackageManager.NameNotFoundException -> L18
            r1.add(r4);     // Catch: PackageManager.NameNotFoundException -> L18
        L18:
            e = move-exception;
            e.printStackTrace();
            goto L8
        L20:
            r0.close();
            Collections.sort(r1, DynamicResolutionActivity.access$1300());
            return r1;
        L5:
            return Collections.EMPTY_LIST;
        }

        @Override // android.content.Loader
        protected void onReset() {
            cancelLoad();
        }
    }

    private class DynamicResolutionAdapter extends ArrayAdapter<DynamicResolutionInfo> {
        final PackageManager mPm;
        final /* synthetic */ DynamicResolutionActivity this$0;

        DynamicResolutionAdapter(final DynamicResolutionActivity this$0, Context context) {
            this.this$0 = this$0;
            super(context, R.layout.dynamic_resolution_item);
            this.mPm = context.getPackageManager();
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView != null) goto L5;
            convertView = DynamicResolutionActivity.access$1400(this.this$0).inflate(R.layout.dynamic_resolution_item, parent, false);
            ViewHolder r1 = new ViewHolder(convertView);
            convertView.setTag(r1);
        L6:
            final DynamicResolutionInfo r2 = getItem(position);
            if (r2.icon != null) goto L9;
            r2.icon = r2.mPackageInfo.applicationInfo.loadIcon(this.mPm);
        L9:
            boolean r5 = true;
            if (UserHandle.getUserId(r2.mPackageInfo.applicationInfo.uid) != 10) goto L12;
            boolean r3 = true;
        L13:
            r2.icon = OuiWidgetUtils.applyDopplegangerBadge(getContext(), r2.icon, r3);
            r1.itemSwitch.setIcon(r2.icon);
            r1.itemSwitch.getSwitch().setTag(r2);
            r1.itemSwitch.setTitle(r2.mLabelEntry.label);
            if (getCount() != 1) goto L16;
            int r8 = 1;
        L22:
            r1.itemSwitch.setBackgroundStyle(r8);
            ListContentItemSwitch r9 = r1.itemSwitch;
            if (DynamicResolutionActivity.access$600(this.this$0) == (-1)) goto L25;
            boolean r4 = true;
        L26:
            r9.setEnabled(r4);
            r1.itemSwitch.setOnCheckedChangeListener(null);
            ListContentItemSwitch r10 = r1.itemSwitch;
            if (r2.enable == 1) goto L30;
            r5 = false;
        L30:
            r10.setChecked(r5);
            r1.itemSwitch.setOnCheckedChangeListener(DynamicResolutionActivity.access$1500(this.this$0));
            r1.itemSwitch.setRightExpandView(DynamicResolutionActivity.access$1400(this.this$0).inflate(R.layout.list_item_switch_enter_layout, parent, false));
            r1.itemSwitch.setOnClickListener(new AnonymousClass1(this, r2));
            return convertView;
        L25:
            r4 = false;
            goto L26
        L16:
            if (position != 0) goto L19;
            r8 = 2;
            goto L22
        L19:
            if (position != (getCount() - 1)) goto L21;
            r8 = 4;
            goto L22
        L21:
            r8 = 3;
            goto L22
        L12:
            r3 = false;
            goto L13
        L5:
            r1 = (ViewHolder) convertView.getTag();
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

        DynamicResolutionInfo(PackageInfo packageInfo, int id, LabelEntry entry, Drawable icon, int enable, String version) {
            this.mPackageInfo = packageInfo;
            this.id = id;
            this.mLabelEntry = entry;
            this.icon = icon;
            this.enable = enable;
            this.version = version;
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

        public ViewHolder(View v) {
            this.itemSwitch = (ListContentItemSwitch) v.findViewById(R.id.dynamic_resolution_switcher);
        }
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

    static /* synthetic */ int access$1600(DynamicResolutionActivity r0) {
        return r0.mLinAnim;
    }

    static /* synthetic */ int access$1700(DynamicResolutionActivity r0) {
        return r0.mRoutAnim;
    }

    static /* synthetic */ AlertDialog access$1802(DynamicResolutionActivity r0, AlertDialog r1) {
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
    public /* bridge */ /* synthetic */ void onLoadFinished(Loader<List<DynamicResolutionInfo>> loader, List<DynamicResolutionInfo> data) {
        onLoadFinished2(loader, data);
    }

    static {
        CONTENT_URI = Uri.parse("content://com.bytedanceos.security.dynamicResolution/dynamicResolution");
        CONTENT_ID_URI_BASE = Uri.parse("content://com.bytedanceos.security.dynamicResolution/dynamicResolution/");
        ALPHA_COMPARATOR = new AnonymousClass8();
    }

    private void updateDynamicResolution(final DynamicResolutionInfo info, final int enable) {
        info.enable = enable;
        this.mAdapter.notifyDataSetChanged();
        this.mSingleTask.execute(new AnonymousClass3(this, info, enable));
    }

    @Override // com.bytedanceos.security.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLoaderManager().initLoader(0, null, this);
        setContentView(R.layout.dynamic_resolution_layout);
        this.mAm = (ActivityManager) getSystemService("activity");
        this.mInflater = LayoutInflater.from(this);
        this.mListView = (OListView) findViewById(R.id.view_list);
        this.mLoadingView = findViewById(R.id.loading_container);
        this.mAdapter = new DynamicResolutionAdapter(this, getBaseContext());
        initHeaderView();
        OListView r5 = this.mListView;
        if (r5 == null) goto L5;
        r5.addHeaderView(this.mHeaderView);
        this.mListView.setAdapter(this.mAdapter);
        this.mListView.setVisibility(4);
    L5:
        this.mHandler.sendEmptyMessageDelayed(1, 250);
        initTitleBar(false);
        this.mRinAnim = Utils.getSMTResouceId(this, "bytedanceos", "slide_in_from_right", "anim", R.anim.slide_in_from_right);
        this.mLoutAnim = Utils.getSMTResouceId(this, "bytedanceos", "slide_out_to_left", "anim", R.anim.slide_out_to_left);
        this.mLinAnim = Utils.getSMTResouceId(this, "bytedanceos", "slide_in_from_left", "anim", R.anim.slide_in_from_left);
        this.mRoutAnim = Utils.getSMTResouceId(this, "bytedanceos", "slide_out_to_right", "anim", R.anim.slide_out_to_right);
        updateViewWidth(this.mListView);
    }

    @Override // com.bytedanceos.security.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
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

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        AlertDialog r0 = this.mEnableDialog;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isShowing() == false) goto L9;
        this.mEnableDialog.dismiss();
        return;
    }

    @Override // com.bytedanceos.security.BaseActivity, android.app.Activity
    public void finish() {
        setResult(-1, getIntent());
        super.finish();
    }

    private void initHeaderView() {
        View r0 = this.mInflater.inflate(R.layout.dynamic_resolution_header, null);
        this.mHeaderView = r0;
        this.mEmptyView = r0.findViewById(R.id.empty_view);
        final ListContentItemSwitch r1 = (ListContentItemSwitch) this.mHeaderView.findViewById(R.id.dynamic_resolution_enabled);
        final View r2 = this.mHeaderView.findViewById(R.id.dynamic_resolution_smart);
        final View r3 = this.mHeaderView.findViewById(R.id.dynamic_resolution_always);
        this.mGameListTitle = (TextView) this.mHeaderView.findViewById(R.id.dynamic_resolution_game_list_title);
        View.OnClickListener r4 = new AnonymousClass4(this, r1, r2, r3);
        this.mState = Settings.Global.getInt(getContentResolver(), DynamicResolutionConfig.DYNAMIC_RES_STATE, -1);
        this.mMode = Settings.Global.getInt(getContentResolver(), DynamicResolutionConfig.DYNAMIC_RES_ENABLED_MODE, 0);
        updateHeaderView(r1, r2, r3);
        r1.setOnCheckedChangeListener(new AnonymousClass5(this, r1, r2, r3));
        if (r3 == null) goto L5;
        r3.setOnClickListener(r4);
    L5:
        if (r2 == null) goto L8;
        r2.setOnClickListener(r4);
        return;
    }

    private void updateHeaderView(ListContentItemSwitch settingItemSwitch, View smart, View always) {
        if (smart == null) goto L41;
        if (always == null) goto L43;
        View r0 = smart.findViewById(R.id.dynamic_resolution_smart_image);
        View r1 = always.findViewById(R.id.dynamic_resolution_always_image);
        TextView r2 = (TextView) smart.findViewById(R.id.dynamic_resolution_smart_text);
        TextView r3 = (TextView) always.findViewById(R.id.dynamic_resolution_always_text);
        int r7 = 0;
        if (this.mState != (-1)) goto L17;
        settingItemSwitch.setChecked(false);
        always.setEnabled(false);
        if (r1 == null) goto L10;
        r1.setEnabled(false);
    L10:
        if (r3 == null) goto L12;
        r3.setEnabled(false);
    L12:
        smart.setEnabled(false);
        if (r0 == null) goto L15;
        r0.setEnabled(false);
    L15:
        if (r2 == null) goto L28;
        r2.setEnabled(false);
    L28:
        if (r0 != null) goto L30;
    L34:
        if (r1 != null) goto L36;
        return;
    L36:
        if (this.mMode == 1) goto L39;
        r7 = 8;
    L39:
        r1.setVisibility(r7);
        return;
    L30:
        if (this.mMode != 0) goto L32;
        int r10 = 0;
    L33:
        r0.setVisibility(r10);
        goto L34
    L32:
        r10 = 8;
        goto L33
    L17:
        settingItemSwitch.setChecked(true);
        always.setEnabled(true);
        if (r1 == null) goto L20;
        r1.setEnabled(true);
    L20:
        if (r3 == null) goto L22;
        r3.setEnabled(true);
    L22:
        smart.setEnabled(true);
        if (r0 == null) goto L25;
        r0.setEnabled(true);
    L25:
        if (r2 == null) goto L28;
        r2.setEnabled(true);
        goto L28
    L43:
        return;
    }

    @Override // android.app.LoaderManager.LoaderCallbacks
    public Loader<List<DynamicResolutionInfo>> onCreateLoader(int id, Bundle args) {
        AsyncTask.setDefaultExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        return new AppListLoader(this, CONTENT_URI, new String[]{"_id", "packageName", "enable", "smversion"}, "installed=?", new String[]{"1"}, null);
    }

    /* JADX INFO: renamed from: onLoadFinished, reason: avoid collision after fix types in other method */
    public void onLoadFinished2(Loader<List<DynamicResolutionInfo>> loader, List<DynamicResolutionInfo> data) {
        this.mHandler.removeMessages(1);
        this.mLoadingView.setVisibility(8);
        this.mListView.setVisibility(0);
        this.mAdapter.clear();
        if (data.size() <= 0) goto L5;
        this.mGameListTitle.setVisibility(0);
        this.mEmptyView.setVisibility(8);
    L6:
        this.mAdapter.addAll(data);
        this.mAdapter.notifyDataSetChanged();
        return;
    L5:
        this.mGameListTitle.setVisibility(8);
        this.mEmptyView.setVisibility(0);
        goto L6
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
    public void onLoaderReset(Loader<List<DynamicResolutionInfo>> loader) {
        this.mAdapter.clear();
    }

    private void showEnableDialog(final DynamicResolutionInfo info) {
        DialogInterface.OnClickListener r0 = new AnonymousClass9(this, info);
        AlertDialog r3 = new AlertDialog.Builder(this).setTitle(R.string.dlg_dynamic_resolution_tip).setMessage(getString(R.string.dlg_dynamic_resolution_message)).setPositiveButton(getString(R.string.dlg_dynamic_resolution_okay), r0).setNegativeButton(R.string.cancel, r0).create();
        this.mEnableDialog = r3;
        r3.show();
        this.mEnableDialog.getButton(-1).setSingleLine();
        this.mEnableDialog.getButton(-1).setEllipsize(TextUtils.TruncateAt.END);
        this.mEnableDialog.setOnDismissListener(new AnonymousClass10(this));
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        updateViewWidth(this.mListView);
    }
}
