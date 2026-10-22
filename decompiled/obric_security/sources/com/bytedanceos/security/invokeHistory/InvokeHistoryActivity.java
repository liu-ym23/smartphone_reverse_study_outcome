package com.bytedanceos.security.invokeHistory;

import android.app.LoaderManager;
import android.content.AsyncTaskLoader;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.UserHandle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.bytedance.framwork.core.sdklib.DBHelper;
import com.bytedanceos.application.ApplicationLabelCache;
import com.bytedanceos.application.LabelEntry;
import com.bytedanceos.security.BaseActivity;
import com.bytedanceos.security.reflect.OpsManagerHelper;
import com.bytedanceos.securitycenter.SharedPreferUtil;
import com.obric.olog.OLog;
import com.obric.oui.bouncelayout.OListView;
import com.obric.security.R;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import obric.widget.ListContentItemSwitch;

/* JADX INFO: loaded from: classes2.dex */
public class InvokeHistoryActivity extends BaseActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, LoaderManager.LoaderCallbacks<List<InvokeRecord>> {
    static final String ALLOW_APP = "ALLOW_APP";
    private static final int DELAY = 250;
    private static final int LOADER_ID = 0;
    private static final String LOG_TAG = null;
    public static final String PREF_FILE = "development";
    public static final String PREF_SHOW = "show";
    private static final int SHOW_EMPTY_VIEW = 1;
    private static final int TAPS_TO_BE_A_DEVELOPER = 7;
    private static final int TODAY = 0;
    public static final SimpleDateFormat Time_Formatter = null;
    protected static HashMap<String, PackageInfo> mInfoMap;
    private InvokeRecordAdapter mAdapter;
    private boolean mAllowApp;
    private boolean mAllowSystem;
    private ListContentItemSwitch mAppSwitcher;
    private boolean mDebug;
    private int mDevHitCountdown;
    private Toast mDevHitToast;
    private Handler mHandler;
    private View mHistoryTitle;
    private LayoutInflater mInflater;
    private OListView mListView;
    private View mLoadingView;
    private int[] mOpsApp;
    private OpsManagerHelper mOpsManagerHelper;
    private int[] mOpsSystem;
    private String mPackageName;
    private ListContentItemSwitch mSystemSwitcher;
    private int mUid;

    private static class AppListLoader extends AsyncTaskLoader<List<InvokeRecord>> {
        static final Uri mUri = null;
        long[] dates;
        int mAllow;
        String mCallee;
        boolean mDebug;
        String mOrder;
        PackageManager mPm;
        String[] mProjection;
        String mSelection;
        String[] mSelectionArgs;
        int mUid;

        @Override // android.content.AsyncTaskLoader
        public /* bridge */ /* synthetic */ List<InvokeRecord> loadInBackground() {
            return loadInBackground2();
        }

        static {
            mUri = InvokeHistoryDataHelp.CONTENT_URI;
        }

        AppListLoader(Context r9, Bundle r10) {
            super(r9);
            this.mPm = r9.getPackageManager();
            this.mCallee = r10.getString("packageName");
            this.mUid = r10.getInt("uid");
            this.mAllow = r10.getBoolean(InvokeHistoryActivity.ALLOW_APP) ? 1 : 0;
            this.mDebug = r10.getBoolean(InvokeHistoryActivity.PREF_SHOW);
            this.mSelection = "time<? and time>? and callee=?";
            this.mSelection += " group by caller, allow";
            this.mSelectionArgs = new String[]{"", "", this.mCallee};
            this.mProjection = new String[]{"*", "sum(number)"};
            this.mOrder = " _id ASC LIMIT 10000";
            long r4 = InvokeHistoryUtils.getBeginOfToday();
            this.dates = new long[]{Long.MAX_VALUE, r4, r4 - 86400000, r4 - 172800000, r4 - 259200000, r4 - 345600000, r4 - 432000000, r4 - 518400000};
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
        public List<InvokeRecord> loadInBackground2() {
            ArrayList r1 = new ArrayList();
            ArrayList r2 = new ArrayList();
            boolean r5 = false;
            Integer r6 = null;
            Integer r7 = null;
            Integer r8 = null;
            Integer r9 = null;
            Integer r10 = null;
            Integer r11 = null;
            Integer r12 = null;
            Integer r13 = null;
            Integer r14 = null;
            int r15 = 0;
        L4:
            if (r15 >= (this.dates.length - 1)) goto L61;
            Integer r16 = r6;
            Integer r17 = r7;
            this.mSelectionArgs[0] = this.dates[r15] + "";
            int r21 = r15 + 1;
            Integer r18 = r8;
            this.mSelectionArgs[1] = this.dates[r21] + "";
            Cursor r3 = getContext().getContentResolver().query(mUri, this.mProjection, this.mSelection, this.mSelectionArgs, this.mOrder);
            if (r3 != null) goto L8;
            ArrayList r4 = r1;
            r6 = r16;
            r7 = r17;
            r8 = r18;
        L60:
            r1 = r4;
            r15 = r21;
            goto L4
        L8:
            boolean r19 = r3.moveToFirst();
            r6 = r16;
            r7 = r17;
            r8 = r18;
        L9:
            if (r19 == false) goto L59;
            boolean r110 = r5;
            Integer r111 = r7;
            Integer r112 = r8;
            Integer r113 = r9;
            Integer r22 = r10;
            Integer r23 = r11;
            Integer r24 = r12;
            Integer r25 = r13;
            if (r6 != null) goto L13;
            Integer r20 = Integer.valueOf(r3.getColumnIndex("calleeUid"));
            Integer r114 = Integer.valueOf(r3.getColumnIndex("caller"));
            Integer r115 = Integer.valueOf(r3.getColumnIndex("callerUid"));
            Integer r116 = Integer.valueOf(r3.getColumnIndex("type"));
            Integer r117 = Integer.valueOf(r3.getColumnIndex("className"));
            Integer r26 = Integer.valueOf(r3.getColumnIndex("action"));
            Integer r27 = r117;
            Integer r28 = r26;
            Integer r29 = Integer.valueOf(r3.getColumnIndex(DBHelper.COL_TIME));
            Integer r210 = Integer.valueOf(r3.getColumnIndex("allow"));
            Integer r30 = Integer.valueOf(r3.getColumnIndex("number") + 1);
            Integer r211 = r20;
            Integer r212 = r114;
            Integer r213 = r115;
            Integer r214 = r116;
        L14:
            int r118 = r3.getInt(r211.intValue());
            String r31 = r3.getString(r212.intValue());
            int r32 = r15;
            int r119 = r3.getInt(r213.intValue());
            ArrayList r33 = r1;
            if (r31 != null) goto L17;
            String r120 = r31;
            String r34 = "uid" + r119;
        L18:
            String r35 = r3.getString(r214.intValue());
            ArrayList r36 = r2;
            String r37 = r3.getString(r27.intValue());
            String r38 = r3.getString(r28.intValue());
            long r121 = r3.getLong(r29.intValue());
            int r39 = r3.getInt(r210.intValue());
            int r40 = r3.getInt(r30.intValue());
            Cursor r310 = r3;
            if (r40 <= 1) goto L21;
            boolean r311 = true;
        L22:
            ContentValues r41 = new ContentValues();
            r41.put("callee", this.mCallee);
            r41.put("calleeUid", Integer.valueOf(r118));
            r41.put("caller", r34);
            r41.put("callerUid", Integer.valueOf(r119));
            r41.put("type", r35);
            r41.put("className", r37);
            r41.put("action", r38);
            r41.put(DBHelper.COL_TIME, Long.valueOf(r121));
            r41.put("allow", Integer.valueOf(r39));
            r41.put("number", Integer.valueOf(r40));
            r36.add(r41);
            if (r39 == this.mAllow) goto L25;
        L56:
            r2 = r36;
            int r42 = r32;
        L57:
            ArrayList r43 = r33;
        L58:
            r15 = r42;
            r6 = r211;
            r7 = r212;
            r8 = r213;
            r9 = r214;
            r10 = r27;
            r11 = r28;
            r12 = r29;
            r13 = r210;
            r14 = r30;
            r5 = r311;
            r19 = r310.moveToNext();
            r1 = r43;
            r3 = r310;
            goto L9
        L25:
            if (this.mDebug == false) goto L27;
        L28:
            if (r120 == null) goto L33;
            PackageInfo r44 = InvokeHistoryActivity.getByCaller(r120);
            if (r44 == null) goto L72;
        L34:
            LabelEntry r45 = ApplicationLabelCache.getInstance().getLabelEntry(this.mPm, r34);
            if (r45 != null) goto L38;
            if (r44 == null) goto L38;
            r45 = ApplicationLabelCache.getInstance().getLabelEntryForApplication(r44.applicationInfo);
        L38:
            if (r45 != null) goto L40;
            r45 = new LabelEntry(r34);
        L40:
            r2 = r36;
            r42 = r32;
            InvokeRecord r122 = new InvokeRecord(this.mCallee, r118, r34, r119, r35, r37, r38, r121, r39, r40, r42, r45, null);
            if (r44 == null) goto L52;
            r122.mCallerIcon = r44.applicationInfo.loadIcon(this.mPm);
            if (UserHandle.getUserId(this.mUid) != 10) goto L52;
            if (r122.mCallerIcon == null) goto L52;
            if ((r122.mCallerIcon instanceof BitmapDrawable) == false) goto L49;
        L50:
            r122.mCallerIcon = this.mPm.getUserBadgedIcon(r122.mCallerIcon, new UserHandle(10));
            goto L52
        L49:
            if (r122.mCallerIcon.getClass().getSimpleName().equals("AdaptiveIconDrawable") == true) goto L50;
        L52:
            if (this.mDebug == false) goto L54;
        L55:
            r43 = r33;
            r43.add(r122);
            goto L58
        L54:
            if (InvokeHistoryActivity.access$200(r44) == false) goto L57;
        L72:
            String r46 = r120;
            r44 = this.mPm.getPackageInfo(r46, 8192);     // Catch: PackageManager.NameNotFoundException -> L71
            InvokeHistoryActivity.putCaller(r46, r44);     // Catch: PackageManager.NameNotFoundException -> L71
            goto L34
        L33:
            r44 = null;
            goto L34
        L27:
            if (r119 < 10000) goto L56;
        L21:
            r311 = r110;
            goto L22
        L17:
            r120 = r31;
            r34 = r120;
            goto L18
        L13:
            r30 = r14;
            r27 = r22;
            r28 = r23;
            r29 = r24;
            r210 = r25;
            r211 = r6;
            r212 = r111;
            r213 = r112;
            r214 = r113;
            goto L14
        L59:
            Cursor r312 = r3;
            r4 = r1;
            r312.close();
            goto L60
        L61:
            ArrayList r47 = r1;
            if (r5 == false) goto L64;
            ContentResolver r48 = getContext().getContentResolver();
            Uri r49 = mUri;
            r48.delete(r49, "callee=?", new String[]{this.mCallee});
            ContentValues[] r50 = new ContentValues[r2.size()];
            r2.toArray(r50);
            getContext().getContentResolver().bulkInsert(r49, r50);
        L64:
            Collections.sort(r47, InvokeHistoryUtils.TIME_COMPARATOR);
            if (this.mDebug == false) goto L70;
            Iterator r0 = r47.iterator();
        L68:
            if (r0.hasNext() == false) goto L70;
            OLog.i(InvokeHistoryActivity.access$300(), ((InvokeRecord) r0.next()).toString());
        L70:
            return r47;
        }

        @Override // android.content.Loader
        protected void onReset() {
            cancelLoad();
        }
    }

    static class InvokeRecord {
        String mAction;
        int mAllow;
        String mCallee;
        int mCalleeUid;
        String mCaller;
        Drawable mCallerIcon;
        LabelEntry mCallerLabelEntry;
        int mCallerUid;
        String mClassName;
        int mDateType;
        int mNumber;
        long mTime;
        String mType;

        InvokeRecord(String callee, int calleeUid, String caller, int callerUid, String type, String className, String action, long time, int allow, int number, int dateType, LabelEntry callerEntry, Drawable icon) {
            this.mCallee = callee;
            this.mCalleeUid = calleeUid;
            this.mCaller = caller;
            this.mCallerUid = callerUid;
            this.mType = type;
            this.mClassName = className;
            this.mAction = action;
            this.mTime = time;
            this.mAllow = allow;
            this.mNumber = number;
            this.mDateType = dateType;
            this.mCallerLabelEntry = callerEntry;
            this.mCallerIcon = icon;
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder();
            if (this.mAllow != 1) goto L5;
            String r1 = "allow ";
        L7:
            return r0.append(r1).append(this.mCaller).append(" ==> ").append(this.mCallee).append(" by ").append(this.mClassName).append(", type:").append(this.mType).append(", number:").append(this.mNumber).append(", action:").append(this.mAction).toString();
        L5:
            r1 = "not allow ";
            goto L7
        }
    }

    private class InvokeRecordAdapter extends ArrayAdapter<InvokeRecord> {
        final PackageManager mPm;
        final /* synthetic */ InvokeHistoryActivity this$0;

        InvokeRecordAdapter(final InvokeHistoryActivity this$0, Context context) {
            this.this$0 = this$0;
            super(context, R.layout.invoke_record_item);
            this.mPm = context.getPackageManager();
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView != null) goto L5;
            convertView = InvokeHistoryActivity.access$400(this.this$0).inflate(R.layout.invoke_record_item, parent, false);
            ViewHolder r10 = new ViewHolder(convertView);
            convertView.setTag(r10);
        L6:
            InvokeRecord r1 = getItem(position);
            r10.icon.setImageDrawable(r1.mCallerIcon);
            if (r1.mCallerLabelEntry != null) goto L9;
            String r2 = r1.mCaller;
        L10:
            r10.description.setText(this.this$0.getString(R.string.launched_by, new Object[]{r2}));
            if (InvokeHistoryActivity.access$500(this.this$0) == false) goto L13;
            r10.invokeCount.setText(this.this$0.getString(R.string.launch_number, new Object[]{Integer.valueOf(r1.mNumber)}));
        L15:
            if (r1.mDateType != 0) goto L17;
            InvokeHistoryActivity.access$500(this.this$0);
            r10.invokeTime.setVisibility(0);
            r10.invokeDate.setText(R.string.today);
        L19:
            if (getCount() != 1) goto L21;
            int r7 = R.drawable.item_bg_single;
        L27:
            convertView.setBackgroundResource(r7);
            return convertView;
        L21:
            if (position != 0) goto L24;
            r7 = R.drawable.item_bg_top;
            goto L27
        L24:
            if (position != (getCount() - 1)) goto L26;
            r7 = R.drawable.item_bg_bottom;
            goto L27
        L26:
            r7 = R.drawable.item_bg_middle;
            goto L27
        L17:
            r10.invokeTime.setVisibility(8);
            r10.invokeDate.setText(r10.dateFormatter.format(new Date(r1.mTime)));
            goto L19
        L13:
            r10.invokeCount.setText(this.this$0.getString(R.string.block_number, new Object[]{Integer.valueOf(r1.mNumber)}));
            goto L15
        L9:
            r2 = r1.mCallerLabelEntry.label;
            goto L10
        L5:
            r10 = (ViewHolder) convertView.getTag();
            goto L6
        }
    }

    private static class ViewHolder {
        public SimpleDateFormat dateFormatter;
        public TextView description;
        public ImageView icon;
        public TextView invokeCount;
        public TextView invokeDate;
        public TextView invokeTime;

        public ViewHolder(View v) {
            this.dateFormatter = new SimpleDateFormat("MM-dd");
            this.icon = (ImageView) v.findViewById(R.id.callee_icon);
            this.description = (TextView) v.findViewById(R.id.invoke_description);
            this.invokeDate = (TextView) v.findViewById(R.id.invoke_date);
            this.invokeCount = (TextView) v.findViewById(R.id.invoke_count);
            this.invokeTime = (TextView) v.findViewById(R.id.invoke_time);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }

    public InvokeHistoryActivity() {
        this.mOpsSystem = new int[]{OpsManagerHelper.get_OP_BOOT_COMPLETED()};
        this.mOpsApp = new int[]{OpsManagerHelper.get_OP_THIRD_PARTY_BOOTABLE()};
        this.mOpsManagerHelper = null;
        this.mDevHitCountdown = 7;
        this.mHandler = new AnonymousClass1(this);
    }

    static /* synthetic */ View access$000(InvokeHistoryActivity r0) {
        return r0.mLoadingView;
    }

    static /* synthetic */ void access$100(InvokeHistoryActivity r0) {
        r0.toggleDebugMode();
    }

    static /* synthetic */ boolean access$200(PackageInfo r0) {
        return isUserApp(r0);
    }

    static /* synthetic */ String access$300() {
        return LOG_TAG;
    }

    static /* synthetic */ LayoutInflater access$400(InvokeHistoryActivity r0) {
        return r0.mInflater;
    }

    static /* synthetic */ boolean access$500(InvokeHistoryActivity r0) {
        return r0.mAllowApp;
    }

    @Override // android.app.LoaderManager.LoaderCallbacks
    public /* bridge */ /* synthetic */ void onLoadFinished(Loader<List<InvokeRecord>> loader, List<InvokeRecord> data) {
        onLoadFinished2(loader, data);
    }

    static {
        Time_Formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        mInfoMap = new HashMap();
        LOG_TAG = "InvokeHistoryActivity";
    }

    @Override // com.bytedanceos.security.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.invoke_history_layout);
        getWindow().setBackgroundDrawable(null);
        initViewsCommon(getIntent());
        this.mInflater = LayoutInflater.from(this);
        this.mLoadingView = findViewById(R.id.loading_container);
        this.mAdapter = new InvokeRecordAdapter(this, getBaseContext());
        OListView r4 = (OListView) findViewById(R.id.history_of_invoke);
        this.mListView = r4;
        if (r4 == null) goto L5;
        r4.setAdapter(this.mAdapter);
        this.mListView.addHeaderView(initHeaderView());
        this.mListView.setOnItemClickListener(new AnonymousClass2(this));
    L5:
        this.mHandler.sendEmptyMessageDelayed(1, 250);
        this.mOpsManagerHelper = OpsManagerHelper.getInstance();
        if (getIntent() == null) goto L9;
        init(getIntent().getExtras(), false);
        return;
    }

    private View initHeaderView() {
        View r0 = this.mInflater.inflate(R.layout.invoke_history_header, null);
        this.mSystemSwitcher = (ListContentItemSwitch) r0.findViewById(R.id.system_switcher);
        this.mAppSwitcher = (ListContentItemSwitch) r0.findViewById(R.id.app_switcher);
        this.mHistoryTitle = r0.findViewById(R.id.invoke_history_title);
        return r0;
    }

    private void init(Bundle args, boolean restart) {
        if (args != null) goto L4;
        return;
    L4:
        if (args.getString("packageName") != null) goto L7;
        return;
    L7:
        if (this.mPackageName != null) goto L9;
        this.mPackageName = args.getString("packageName");
    L9:
        int r0 = args.getInt("uid");
        this.mUid = r0;
        boolean r2 = true;
        if (this.mOpsManagerHelper.getMode(r0, this.mPackageName, this.mOpsSystem) != OpsManagerHelper.get_MODE_ALLOWED()) goto L12;
        boolean r1 = true;
    L13:
        this.mAllowSystem = r1;
        if (this.mOpsManagerHelper.getMode(this.mUid, this.mPackageName, this.mOpsApp) == OpsManagerHelper.get_MODE_ALLOWED()) goto L17;
        r2 = false;
    L17:
        this.mAllowApp = r2;
        this.mSystemSwitcher.setOnCheckedChangeListener(null);
        this.mSystemSwitcher.setChecked(this.mAllowSystem);
        this.mSystemSwitcher.setOnCheckedChangeListener(this);
        this.mAppSwitcher.setOnCheckedChangeListener(null);
        this.mAppSwitcher.setChecked(this.mAllowApp);
        this.mAppSwitcher.setOnCheckedChangeListener(this);
        args.putBoolean(ALLOW_APP, this.mAllowApp);
        boolean r3 = getSharedPreferences(PREF_FILE, 0).getBoolean(PREF_SHOW, false);
        this.mDebug = r3;
        args.putBoolean(PREF_SHOW, r3);
        if (restart == false) goto L20;
        getLoaderManager().restartLoader(0, args, this);
        return;
    L20:
        getLoaderManager().initLoader(0, args, this);
        return;
    L12:
        r1 = false;
        goto L13
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState == null) goto L5;
        super.onRestoreInstanceState(savedInstanceState);
        init(savedInstanceState, true);
        return;
    }

    @Override // com.bytedanceos.security.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        getLoaderManager().destroyLoader(0);
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton btn, boolean checked) {
        if (checked == false) goto L4;
        int r4 = OpsManagerHelper.get_MODE_ALLOWED();
    L6:
        if (btn != this.mSystemSwitcher.getSwitch()) goto L9;
        this.mOpsManagerHelper.setMode(this.mOpsSystem[0], this.mUid, this.mPackageName, r4);
        return;
    L9:
        if (btn != this.mAppSwitcher.getSwitch()) goto L13;
        this.mOpsManagerHelper.setMode(this.mOpsApp[0], this.mUid, this.mPackageName, r4);
        return;
    L13:
        return;
    L4:
        r4 = OpsManagerHelper.get_MODE_IGNORED();
        goto L6
    }

    private void initViewsCommon(Intent intent) {
        initTitleBar(false);
        this.mPackageName = intent.getStringExtra("packageName");     // Catch: PackageManager.NameNotFoundException -> L11
        PackageManager r3 = getPackageManager();     // Catch: PackageManager.NameNotFoundException -> L11
        if (r3 != null) goto L6;
        return;
    L6:
        PackageInfo r0 = r3.getPackageInfo(this.mPackageName, 8192);     // Catch: PackageManager.NameNotFoundException -> L11
        if (r0 != null) goto L9;
        return;
    L9:
        this.mTitle.setCenterTitle(r0.applicationInfo.loadLabel(r3).toString());     // Catch: PackageManager.NameNotFoundException -> L11
        return;
    L11:
        this.mTitle.setCenterTitle(this.mPackageName);
    }

    private void toggleDebugMode() {
        int r0 = this.mDevHitCountdown;
        if (r0 <= 0) goto L10;
        int r1 = r0 - 1;
        this.mDevHitCountdown = r1;
        if (r1 != 0) goto L18;
        this.mDebug = true;
        SharedPreferUtil.commitAsynchronously(getSharedPreferences(PREF_FILE, 0).edit().putBoolean(PREF_SHOW, this.mDebug));
        Toast r2 = this.mDevHitToast;
        if (r2 == null) goto L9;
        r2.cancel();
    L9:
        Toast r3 = Toast.makeText(this, "已处于debug模式，请勿报bug", 1);
        this.mDevHitToast = r3;
        r3.show();
        return;
    L18:
        return;
    L10:
        if (r0 > 0) goto L20;
        int r4 = r0 - 1;
        this.mDevHitCountdown = r4;
        if (r4 >= (-7)) goto L21;
        this.mDevHitCountdown = 7;
        this.mDebug = false;
        SharedPreferUtil.commitAsynchronously(getSharedPreferences(PREF_FILE, 0).edit().putBoolean(PREF_SHOW, this.mDebug));
        Toast r5 = this.mDevHitToast;
        if (r5 == null) goto L16;
        r5.cancel();
    L16:
        Toast r6 = Toast.makeText(this, "已退出debug模式，请勿报bug", 1);
        this.mDevHitToast = r6;
        r6.show();
        return;
    L21:
        return;
    }

    @Override // android.app.LoaderManager.LoaderCallbacks
    public Loader<List<InvokeRecord>> onCreateLoader(int id, Bundle args) {
        AsyncTask.setDefaultExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        return new AppListLoader(this, args);
    }

    /* JADX INFO: renamed from: onLoadFinished, reason: avoid collision after fix types in other method */
    public void onLoadFinished2(Loader<List<InvokeRecord>> loader, List<InvokeRecord> data) {
        this.mHandler.removeMessages(1);
        this.mLoadingView.setVisibility(8);
        if (data.isEmpty() == false) goto L5;
        this.mHistoryTitle.setVisibility(8);
        return;
    L5:
        this.mAdapter.clear();
        this.mAdapter.addAll(data);
        this.mAdapter.notifyDataSetChanged();
        this.mHistoryTitle.setVisibility(0);
    }

    @Override // android.app.LoaderManager.LoaderCallbacks
    public void onLoaderReset(Loader<List<InvokeRecord>> loader) {
        this.mAdapter.clear();
    }

    protected static PackageInfo getByCaller(String caller) {
        if (caller != null) goto L6;
        return null;
    L6:
        return mInfoMap.get(caller);
    }

    protected static void putCaller(String caller, PackageInfo info) {
        if (caller == null) goto L7;
        if (info == null) goto L8;
        mInfoMap.put(caller, info);
        return;
    L8:
        return;
    }

    private static boolean isSystemApp(PackageInfo pInfo) {
        if ((pInfo.applicationInfo.flags & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    private static boolean isSystemUpdateApp(PackageInfo pInfo) {
        if ((pInfo.applicationInfo.flags & 128) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private static boolean isUserApp(PackageInfo pInfo) {
        if (pInfo != null) goto L6;
        return false;
    L6:
        if (isSystemApp(pInfo) == false) goto L8;
        return false;
    L8:
        if (isSystemUpdateApp(pInfo) == true) goto L12;
        return true;
    L12:
        return false;
    }
}
