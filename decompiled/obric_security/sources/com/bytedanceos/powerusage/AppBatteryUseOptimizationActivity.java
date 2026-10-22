package com.bytedanceos.powerusage;

import android.app.ActivityManager;
import android.app.LoaderManager;
import android.content.AsyncTaskLoader;
import android.content.Context;
import android.content.Loader;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.UserHandle;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import com.bytedanceos.application.ApplicationLabelCache;
import com.bytedanceos.application.LabelEntry;
import com.bytedanceos.security.BaseActivity;
import com.bytedanceos.security.Utils;
import com.bytedanceos.utils.Constants;
import com.obric.oui.OuiWidgetUtils;
import com.obric.oui.bouncelayout.OListView;
import com.obric.oui.lisitem.OListItemSwitch;
import com.obric.oui.simplified.ORoundedListItemSwitch;
import com.obric.security.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class AppBatteryUseOptimizationActivity extends BaseActivity implements LoaderManager.LoaderCallbacks<List<OptimizationInfo>> {
    private static final Comparator<OptimizationInfo> ALPHA_COMPARATOR = null;
    private static final int SHOW_LOADING_VIEW = 1;
    private AppBatteryUseAdapter mAdapter;
    private CompoundButton.OnCheckedChangeListener mCheckedChangeListener;
    private boolean mEnableOptimization;
    private Handler mHandler;
    private LayoutInflater mInflater;
    private OListView mListView;
    private View mLoadingView;

    private class AppBatteryUseAdapter extends ArrayAdapter<OptimizationInfo> {
        final PackageManager mPm;
        final /* synthetic */ AppBatteryUseOptimizationActivity this$0;

        AppBatteryUseAdapter(final AppBatteryUseOptimizationActivity this$0, Context context) {
            this.this$0 = this$0;
            super(context, R.layout.app_battery_use_optimzation_item);
            this.mPm = context.getPackageManager();
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int position, View convertView, ViewGroup parent) {
            boolean r0 = false;
            if (convertView != null) goto L5;
            convertView = AppBatteryUseOptimizationActivity.access$500(this.this$0).inflate(R.layout.app_battery_use_optimzation_item, parent, false);
            ViewHolder r6 = new ViewHolder(convertView);
            convertView.setTag(r6);
        L6:
            OptimizationInfo r4 = getItem(position);
            if (r4.icon != null) goto L10;
            r4.icon = r4.mPackageInfo.applicationInfo.loadIcon(this.mPm);
        L10:
            if (UserHandle.getUserId(r4.mPackageInfo.applicationInfo.uid) != 10) goto L12;
            r0 = true;
        L12:
            r4.icon = OuiWidgetUtils.applyDopplegangerBadge(getContext(), r4.icon, r0);
            r6.switchEx.setContentImage(r4.icon);
            r6.switchEx.setTitleString(r4.mLabelEntry.label);
            r6.switchEx.setOnCheckedChangeListener(null);
            r6.switchEx.setChecked(r4.optimization);
            r6.switchEx.getSwitch().setTag(r4);
            r6.switchEx.setOnCheckedChangeListener(AppBatteryUseOptimizationActivity.access$600(this.this$0));
            r6.switchEx.setEnabled(AppBatteryUseOptimizationActivity.access$100(this.this$0));
            return convertView;
        L5:
            r6 = (ViewHolder) convertView.getTag();
            goto L6
        }
    }

    private static class AppListLoader extends AsyncTaskLoader<List<OptimizationInfo>> {
        Context mContext;
        final PackageManager mPm;

        @Override // android.content.AsyncTaskLoader
        public /* bridge */ /* synthetic */ List<OptimizationInfo> loadInBackground() {
            return loadInBackground2();
        }

        AppListLoader(Context context) {
            super(context);
            this.mContext = context;
            this.mPm = context.getPackageManager();
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

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.content.AsyncTaskLoader
        /* JADX INFO: renamed from: loadInBackground, reason: avoid collision after fix types in other method */
        public List<OptimizationInfo> loadInBackground2() {
            int r2 = 0;
            List<PackageInfo> r1 = this.mPm.getInstalledPackages(0);
            if (r1 != null) goto L6;
            return null;
        L6:
            Cursor r3 = this.mContext.getContentResolver().query(OptimizationHelper.CONTENT_URI, new String[]{"_id", "packageName", "enable", "uid"}, null, null, null);
            ArrayList r4 = new ArrayList();
            ApplicationLabelCache r5 = ApplicationLabelCache.getInstance();
            Iterator<PackageInfo> r6 = r1.iterator();
        L7:
            int r9 = -1;
            boolean r10 = true;
            if (r6.hasNext() == false) goto L34;
            PackageInfo r7 = r6.next();
            ApplicationInfo r11 = r7.applicationInfo;
            if (r11.uid < 10000) goto L7;
            if ((r11.flags & 1) != 0) goto L7;
            if (AppBatteryUseOptimizationActivity.access$300(r11.packageName) == true) goto L7;
            LabelEntry r12 = r5.getLabelEntry(this.mPm, r11.packageName);
            if (r12 != null) goto L19;
            r12 = r5.getLabelEntryForApplication(r7.applicationInfo);
        L19:
            LabelEntry r13 = r12;
            if (r3 == null) goto L32;
            r3.moveToFirst();
        L23:
            if (r3.getString(1).equals(r11.packageName) == false) goto L31;
            if (r3.getInt(3) != r11.uid) goto L31;
            r9 = r3.getInt(0);
            if (r3.getInt(2) == 1) goto L32;
            r10 = false;
        L31:
            if (r3.moveToNext() == true) goto L23;
        L32:
            OptimizationInfo r8 = new OptimizationInfo(r7, r13, null, r9, r10);
            r8.icon = r7.applicationInfo.loadIcon(this.mPm);
            r4.add(r8);
            goto L7
        L34:
            if (ActivityManager.getCurrentUser() != 0) goto L65;
            Iterator r14 = this.mPm.getInstalledPackagesAsUser(0, 10).iterator();
        L37:
            if (r14.hasNext() == false) goto L65;
            PackageInfo r15 = (PackageInfo) r14.next();
            if ((r15.applicationInfo.flags & 1) != 0) goto L64;
            if (AppBatteryUseOptimizationActivity.access$300(r15.packageName) == true) goto L37;
            if (Utils.isPackageInstalled(this.mContext, r15.applicationInfo.packageName) == false) goto L64;
            LabelEntry r16 = r5.getLabelEntry(this.mPm, r15.packageName);
            if (r16 != null) goto L48;
            r16 = r5.getLabelEntryForApplication(r15.applicationInfo);
        L48:
            LabelEntry r17 = r16;
            if (r3 == null) goto L62;
            r3.moveToFirst();
        L52:
            if (r3.getString(1).equals(r15.packageName) == false) goto L61;
            if (r3.getInt(3) != r15.applicationInfo.uid) goto L61;
            int r18 = r3.getInt(r2);
            if (r3.getInt(2) != 1) goto L58;
            int r19 = 1;
        L59:
            int r110 = r18;
            boolean r111 = r19;
        L63:
            OptimizationInfo r112 = new OptimizationInfo(r15, r17, null, r110, r111);
            r112.icon = OuiWidgetUtils.applyDopplegangerBadge(this.mContext, r15.applicationInfo.loadIcon(this.mPm), true);
            r4.add(r112);
            goto L64
        L58:
            r19 = r2;
        L61:
            if (r3.moveToNext() == true) goto L52;
        L62:
            r110 = -1;
            r111 = 1;
        L64:
            r2 = 0;
        L65:
            if (r3 == null) goto L67;
            r3.close();
        L67:
            Collections.sort(r4, AppBatteryUseOptimizationActivity.access$400());
            return r4;
        }

        @Override // android.content.Loader
        protected void onReset() {
            cancelLoad();
        }
    }

    static class OptimizationInfo {
        Drawable icon;
        int id;
        LabelEntry mLabelEntry;
        PackageInfo mPackageInfo;
        boolean optimization;

        OptimizationInfo(PackageInfo packageInfo, LabelEntry entry, Drawable icon, int id, boolean optimization) {
            this.mPackageInfo = packageInfo;
            this.mLabelEntry = entry;
            this.icon = icon;
            this.id = id;
            this.optimization = optimization;
        }
    }

    private static class ViewHolder {
        public ORoundedListItemSwitch switchEx;

        public ViewHolder(View v) {
            this.switchEx = (ORoundedListItemSwitch) v.findViewById(R.id.switcher);
        }
    }

    public AppBatteryUseOptimizationActivity() {
        this.mHandler = new AnonymousClass1(this);
        this.mCheckedChangeListener = new AnonymousClass4(this);
    }

    static /* synthetic */ View access$000(AppBatteryUseOptimizationActivity r0) {
        return r0.mLoadingView;
    }

    static /* synthetic */ boolean access$100(AppBatteryUseOptimizationActivity r0) {
        return r0.mEnableOptimization;
    }

    static /* synthetic */ boolean access$102(AppBatteryUseOptimizationActivity r0, boolean r1) {
        r0.mEnableOptimization = r1;
        return r1;
    }

    static /* synthetic */ AppBatteryUseAdapter access$200(AppBatteryUseOptimizationActivity r0) {
        return r0.mAdapter;
    }

    static /* synthetic */ boolean access$300(String r0) {
        return isHiddenApp(r0);
    }

    static /* synthetic */ Comparator access$400() {
        return ALPHA_COMPARATOR;
    }

    static /* synthetic */ LayoutInflater access$500(AppBatteryUseOptimizationActivity r0) {
        return r0.mInflater;
    }

    static /* synthetic */ CompoundButton.OnCheckedChangeListener access$600(AppBatteryUseOptimizationActivity r0) {
        return r0.mCheckedChangeListener;
    }

    @Override // android.app.LoaderManager.LoaderCallbacks
    public /* bridge */ /* synthetic */ void onLoadFinished(Loader<List<OptimizationInfo>> loader, List<OptimizationInfo> data) {
        onLoadFinished2(loader, data);
    }

    @Override // com.bytedanceos.security.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_battery_use_optimzation_activity);
        getLoaderManager().initLoader(0, null, this);
        this.mInflater = LayoutInflater.from(this);
        this.mListView = (OListView) findViewById(R.id.view_list);
        View r7 = LayoutInflater.from(this).inflate(R.layout.app_battery_use_optimzation_header, null);
        OListItemSwitch r2 = (OListItemSwitch) r7.findViewById(R.id.optimzation_header_switch);
        LinearLayout r3 = (LinearLayout) r7.findViewById(R.id.ll_container);
        boolean r5 = true;
        if (Settings.Global.getInt(getContentResolver(), Constants.OPTIMIZATION_APPS, 1) == 1) goto L6;
        r5 = false;
    L6:
        this.mEnableOptimization = r5;
        r2.setChecked(r5);
        r2.setOnCheckedChangeListener(new AnonymousClass2(this));
        View r4 = new View(this);
        r4.setLayoutParams(new AbsListView.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.settings_item_top_bottom_margin)));
        this.mLoadingView = findViewById(R.id.loading_container);
        AppBatteryUseAdapter r6 = new AppBatteryUseAdapter(this, getBaseContext());
        this.mAdapter = r6;
        OListView r8 = this.mListView;
        if (r8 == null) goto L9;
        r8.setAdapter(r6);
        this.mListView.setVisibility(4);
        this.mListView.addHeaderView(r7);
        this.mListView.addFooterView(r4, null, false);
    L9:
        initTitleBar(false);
    }

    @Override // com.bytedanceos.security.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (Utils.isNeedSetWidth(getApplicationContext()) == false) goto L6;
        this.mListView.setVerticalScrollBarEnabled(false);
        return;
    }

    @Override // android.app.LoaderManager.LoaderCallbacks
    public Loader<List<OptimizationInfo>> onCreateLoader(int id, Bundle args) {
        AsyncTask.setDefaultExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        return new AppListLoader(this);
    }

    /* JADX INFO: renamed from: onLoadFinished, reason: avoid collision after fix types in other method */
    public void onLoadFinished2(Loader<List<OptimizationInfo>> loader, List<OptimizationInfo> data) {
        this.mHandler.removeMessages(1);
        this.mLoadingView.setVisibility(8);
        this.mListView.setVisibility(0);
        this.mAdapter.clear();
        this.mAdapter.addAll(data);
        if (data != null) goto L5;
    L7:
        this.mListView.setVerticalScrollBarEnabled(false);
    L8:
        this.mAdapter.notifyDataSetChanged();
        return;
    L5:
        if (data.size() < 30) goto L7;
        this.mListView.setVerticalScrollBarEnabled(true);
        goto L8
    }

    @Override // android.app.LoaderManager.LoaderCallbacks
    public void onLoaderReset(Loader<List<OptimizationInfo>> loader) {
        this.mAdapter.clear();
    }

    static {
        ALPHA_COMPARATOR = new AnonymousClass3();
    }

    private static boolean isHiddenApp(String packageName) {
        if (packageName != null) goto L4;
    L14:
        return false;
    L4:
        if (packageName.startsWith("com.bytedanceos.theme") == false) goto L6;
    L13:
        return true;
    L6:
        if (packageName.startsWith("com.bytedanceos.launcher.theme") == true) goto L13;
        if (packageName.equals("com.bytedanceos.smartfolder.aoa") == true) goto L13;
        if (packageName.equals("com.bytedanceos.payment") == true) goto L13;
        if (packageName.startsWith("com.mediatek") == false) goto L14;
        goto L13
    }
}
