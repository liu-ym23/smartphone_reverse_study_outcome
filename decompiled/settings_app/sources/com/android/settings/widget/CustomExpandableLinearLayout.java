package com.android.settings.widget;

import android.app.Activity;
import android.app.SmtPCUtils;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.TypedArray;
import android.os.AsyncTask;
import android.os.Handler;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.settings.Constants;
import com.android.settings.PhoneCaseShortcutSettingFragment;
import com.android.settings.R;
import com.android.settings.Utils;
import com.android.settings.applications.ApplicationsState;
import com.obric.olog.OLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import obric.widget.SettingItemCheck;

/* JADX INFO: loaded from: classes.dex */
public class CustomExpandableLinearLayout extends LinearLayout implements View.OnClickListener {
    private static final int EXPAND_TYPE_ASYNC_APP_LIST = 2;
    private static final int EXPAND_TYPE_TOOL = 1;
    private static final int ITEM_COUNT_SHOW_MAX = 5;
    private static final String TAG = "CustomExpandableLinearL";
    private Activity mActivity;
    private AppSessionCallback mAppCallback;
    private Comparator<ApplicationsState.AppEntry> mAppComparator;
    private ApplicationsState mApplicationsState;
    private ArrayList<String> mAppsPackageNames;
    private ClearCheckListener mCheckListener;
    private LinearLayout mDefaultItemContainer;
    private int mExpandType;
    private boolean mIsReleased;
    private View.OnClickListener mItemClickListener;
    private ArrayList<String> mItemEntryList;
    private InnerExpandableLayout mItemExpandableContainer;
    private int mItemIconDefaultHeight;
    private int mItemIconDefaultWidth;
    private TextView mItemMoreOrLess;
    private int mItemShowingCount;
    private ArrayList<String> mItemTitleList;
    private ArrayList<String> mOtherKeyList;
    private PackageManager mPackageManager;
    private String mQueryAppName;
    private String mQueryItemTitle;
    private String mSelectedKey;
    private ApplicationsState.Session mSession;
    private ValueStoreListener mStoreListener;
    private TextView mTitle;

    private class AppQueryTask extends AsyncTask<Void, Void, ArrayList<ApplicationsState.AppEntry>> {
        final List<String> hiddenApps;
        final /* synthetic */ CustomExpandableLinearLayout this$0;

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ ArrayList<ApplicationsState.AppEntry> doInBackground(Void[] r1) {
            return doInBackground2(r1);
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ void onPostExecute(ArrayList<ApplicationsState.AppEntry> r1) {
            onPostExecute2(r1);
        }

        public AppQueryTask(CustomExpandableLinearLayout r5, ApplicationsState r6) {
            this.this$0 = r5;
            this.hiddenApps = Arrays.asList(new String[]{"com.bytedanceos.sara", "com.bytedanceos.sidebar", SmtPCUtils.PKG_CALCULATOR, Constants.PKG_BULLET_SMS});
            if (CustomExpandableLinearLayout.access$800(r5) == null) goto L5;
            CustomExpandableLinearLayout.access$800(r5).resume(true);
            return;
        L5:
            CustomExpandableLinearLayout.access$802(r5, r6.newSession(CustomExpandableLinearLayout.access$900(r5)));
            CustomExpandableLinearLayout.access$800(r5).resume(true);
        }

        /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
        protected ArrayList<ApplicationsState.AppEntry> doInBackground2(Void... r2) {
            return CustomExpandableLinearLayout.access$800(this.this$0).rebuild(null, CustomExpandableLinearLayout.access$1000(this.this$0));
        }

        /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
        protected void onPostExecute2(ArrayList<ApplicationsState.AppEntry> r6) {
            if (r6 != null) goto L4;
        L21:
            OLog.i(CustomExpandableLinearLayout.TAG, "AppQueryTask return, isRelease ?" + CustomExpandableLinearLayout.access$1100(this.this$0));
            return;
        L4:
            if (CustomExpandableLinearLayout.access$1100(this.this$0) == true) goto L21;
            ArrayList r0 = new ArrayList();
            CustomExpandableLinearLayout.access$1200(this.this$0).clear();
            String[] r1 = this.this$0.getResources().getStringArray(R.array.common_white_app_list);
            Iterator<ApplicationsState.AppEntry> r7 = r6.iterator();
        L8:
            if (r7.hasNext() == false) goto L19;
            ApplicationsState.AppEntry r2 = r7.next();
            if (Utils.isPackageInLockedBlock(CustomExpandableLinearLayout.access$1300(this.this$0), r2.info.packageName) == true) goto L8;
            if (this.hiddenApps.contains(r2.info.packageName) == true) goto L8;
            if (isBlackListApp(r2.info.packageName, r1) == true) goto L8;
            CustomExpandableLinearLayout.access$1200(this.this$0).add(r2.label);
            r0.add(r2.info.packageName);
            goto L8
        L19:
            new LauncherIntentBuildTask(this.this$0, r0).execute(new Void[0]);
        }

        private boolean isBlackListApp(String r4, String[] r5) {
            if (Utils.APP_STORE_PACKAGE.equals(r4) == false) goto L8;
            if (Utils.isCmccVersion(CustomExpandableLinearLayout.access$1400(this.this$0)) == false) goto L8;
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
    }

    private class AppSessionCallback implements ApplicationsState.Callbacks {
        final /* synthetic */ CustomExpandableLinearLayout this$0;

        @Override // com.android.settings.applications.ApplicationsState.Callbacks
        public void onPackageIconChanged() {
        }

        @Override // com.android.settings.applications.ApplicationsState.Callbacks
        public void onPackageSizeChanged(String r1) {
        }

        private AppSessionCallback(CustomExpandableLinearLayout r1) {
            this.this$0 = r1;
        }

        /* synthetic */ AppSessionCallback(CustomExpandableLinearLayout r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.android.settings.applications.ApplicationsState.Callbacks
        public void onRunningStateChanged(boolean r2) {
            OLog.d(CustomExpandableLinearLayout.TAG, "onRunningStateChanged: running?" + r2);
        }

        @Override // com.android.settings.applications.ApplicationsState.Callbacks
        public void onPackageListChanged() {
            OLog.d(CustomExpandableLinearLayout.TAG, "onPackageListChanged: ");
        }

        @Override // com.android.settings.applications.ApplicationsState.Callbacks
        public void onRebuildComplete(ArrayList<ApplicationsState.AppEntry> r1) {
            OLog.d(CustomExpandableLinearLayout.TAG, "onRebuildComplete: ");
        }

        @Override // com.android.settings.applications.ApplicationsState.Callbacks
        public void onAllSizesComputed() {
            OLog.d(CustomExpandableLinearLayout.TAG, "onAllSizesComputed: ");
            this.this$0.rebuild();
        }
    }

    public interface ClearCheckListener {
        void clearChecks();
    }

    private class LauncherIntentBuildTask extends AsyncTask<Void, Void, ArrayList<Intent>> {
        private ArrayList<String> appsItemTitles;
        private ArrayList<String> appsPackageNames;
        final /* synthetic */ CustomExpandableLinearLayout this$0;

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ ArrayList<Intent> doInBackground(Void[] r1) {
            return doInBackground2(r1);
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ void onPostExecute(ArrayList<Intent> r1) {
            onPostExecute2(r1);
        }

        public LauncherIntentBuildTask(CustomExpandableLinearLayout r1, ArrayList<String> r2) {
            this.this$0 = r1;
            this.appsPackageNames = r2;
            this.appsItemTitles = new ArrayList(CustomExpandableLinearLayout.access$1200(r1));
        }

        /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
        protected ArrayList<Intent> doInBackground2(Void... r4) {
            ArrayList<Intent> r5 = new ArrayList();
            Iterator<String> r0 = this.appsPackageNames.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            r5.add(CustomExpandableLinearLayout.access$1300(this.this$0).getLaunchIntentForPackage(r0.next()));
            goto L4
        L6:
            OLog.d(CustomExpandableLinearLayout.TAG, "doInBackground: intent size=" + r5.size());
            return r5;
        }

        /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
        protected void onPostExecute2(ArrayList<Intent> r8) {
            if (CustomExpandableLinearLayout.access$1100(this.this$0) == false) goto L6;
            OLog.i(CustomExpandableLinearLayout.TAG, "host is released");
            return;
        L6:
            ArrayList r0 = new ArrayList();
            OLog.d(CustomExpandableLinearLayout.TAG, "onPostExecute: intents:" + r8.size());
            Iterator<Intent> r2 = r8.iterator();
            int r4 = 0;
        L8:
            if (r2.hasNext() == false) goto L13;
            if (r2.next() == null) goto L11;
            r4 = r4 + 1;
            goto L8
        L11:
            r2.remove();
            this.appsPackageNames.remove(r4);
            this.appsItemTitles.remove(r4);
            goto L8
        L13:
            Iterator<Intent> r9 = r8.iterator();
            int r3 = 0;
        L15:
            if (r9.hasNext() == false) goto L17;
            r0.add(PhoneCaseShortcutSettingFragment.createActivityJson(r9.next(), this.appsPackageNames.get(r3), 0));
            r3 = r3 + 1;
            goto L15
        L17:
            CustomExpandableLinearLayout.access$1502(this.this$0, this.appsPackageNames);
            CustomExpandableLinearLayout.access$1202(this.this$0, this.appsItemTitles);
            CustomExpandableLinearLayout.access$1602(this.this$0, r0);
            OLog.d(CustomExpandableLinearLayout.TAG, "onPostExecute: mItemTitle:" + CustomExpandableLinearLayout.access$1200(this.this$0).size() + " itemEntry:" + r0.size());
            CustomExpandableLinearLayout.access$1700(this.this$0, r0.size());
            CustomExpandableLinearLayout.access$1800(this.this$0).update();
        }
    }

    public interface ValueStoreListener {
        void onSave(CustomExpandableLinearLayout r1, String r2, String r3, String r4, String r5, int r6);
    }

    static /* synthetic */ Comparator access$1000(CustomExpandableLinearLayout r0) {
        return r0.mAppComparator;
    }

    static /* synthetic */ String access$102(CustomExpandableLinearLayout r0, String r1) {
        r0.mQueryAppName = r1;
        return r1;
    }

    static /* synthetic */ boolean access$1100(CustomExpandableLinearLayout r0) {
        return r0.mIsReleased;
    }

    static /* synthetic */ ArrayList access$1200(CustomExpandableLinearLayout r0) {
        return r0.mItemTitleList;
    }

    static /* synthetic */ ArrayList access$1202(CustomExpandableLinearLayout r0, ArrayList r1) {
        r0.mItemTitleList = r1;
        return r1;
    }

    static /* synthetic */ PackageManager access$1300(CustomExpandableLinearLayout r0) {
        return r0.mPackageManager;
    }

    static /* synthetic */ Context access$1400(CustomExpandableLinearLayout r0) {
        return r0.mContext;
    }

    static /* synthetic */ ArrayList access$1502(CustomExpandableLinearLayout r0, ArrayList r1) {
        r0.mAppsPackageNames = r1;
        return r1;
    }

    static /* synthetic */ ArrayList access$1602(CustomExpandableLinearLayout r0, ArrayList r1) {
        r0.mItemEntryList = r1;
        return r1;
    }

    static /* synthetic */ void access$1700(CustomExpandableLinearLayout r0, int r1) {
        r0.initDefaultItems(r1);
    }

    static /* synthetic */ InnerExpandableLayout access$1800(CustomExpandableLinearLayout r0) {
        return r0.mItemExpandableContainer;
    }

    static /* synthetic */ String access$202(CustomExpandableLinearLayout r0, String r1) {
        r0.mQueryItemTitle = r1;
        return r1;
    }

    static /* synthetic */ Context access$300(CustomExpandableLinearLayout r0) {
        return r0.mContext;
    }

    static /* synthetic */ Context access$400(CustomExpandableLinearLayout r0) {
        return r0.mContext;
    }

    static /* synthetic */ ClearCheckListener access$500(CustomExpandableLinearLayout r0) {
        return r0.mCheckListener;
    }

    static /* synthetic */ void access$600(CustomExpandableLinearLayout r0, int r1) {
        r0.saveSelectedValue(r1);
    }

    static /* synthetic */ ApplicationsState access$700(CustomExpandableLinearLayout r0) {
        return r0.mApplicationsState;
    }

    static /* synthetic */ ApplicationsState.Session access$800(CustomExpandableLinearLayout r0) {
        return r0.mSession;
    }

    static /* synthetic */ ApplicationsState.Session access$802(CustomExpandableLinearLayout r0, ApplicationsState.Session r1) {
        r0.mSession = r1;
        return r1;
    }

    static /* synthetic */ AppSessionCallback access$900(CustomExpandableLinearLayout r0) {
        return r0.mAppCallback;
    }

    public CustomExpandableLinearLayout(Context r2) {
        this(r2, null);
    }

    public CustomExpandableLinearLayout(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public CustomExpandableLinearLayout(Context r4, AttributeSet r5, int r6) {
        super(r4, r5, r6);
        this.mItemTitleList = new ArrayList();
        this.mItemEntryList = new ArrayList();
        this.mOtherKeyList = new ArrayList();
        this.mItemIconDefaultWidth = 0;
        this.mItemIconDefaultHeight = 0;
        this.mItemClickListener = new AnonymousClass2(this);
        setOrientation(1);
        setBackgroundResource(R.drawable.background);
        if ((r4 instanceof Activity) == false) goto L5;
        this.mActivity = (Activity) r4;
    L5:
        TypedArray r7 = r4.obtainStyledAttributes(r5, R.styleable.CustomExpandableLinearLayout, r6, 0);
        String r8 = r7.getString(1);
        int r0 = r7.getInteger(0, 0);
        r7.recycle();
        LayoutInflater.from(r4).inflate(R.layout.custom_expand_linear_layout, this, true);
        this.mDefaultItemContainer = (LinearLayout) findViewById(R.id.ll_default_item_container);
        this.mItemExpandableContainer = (InnerExpandableLayout) findViewById(R.id.ll_expand_layout_container);
        this.mItemMoreOrLess = (TextView) findViewById(R.id.tv_phone_case_category_expandable);
        this.mTitle = (TextView) findViewById(R.id.tv_navbar_mode_setting_title);
        this.mItemMoreOrLess.setOnClickListener(this);
        this.mExpandType = r0;
        this.mPackageManager = this.mContext.getPackageManager();
        if (TextUtils.isEmpty(r8) == true) goto L9;
        this.mTitle.setText(r8);
    L9:
        if (this.mExpandType != 2) goto L12;
        this.mAppsPackageNames = new ArrayList();
        this.mAppCallback = new AppSessionCallback(this, null);
        this.mAppComparator = ApplicationsState.ALPHA_COMPARATOR;
        return;
    }

    public void updateView(int r2, String r3) {
        String[] r4 = getResources().getStringArray(r2);
        ArrayList<String> r0 = new ArrayList();
        r0.addAll(Arrays.asList(r4));
        if (TextUtils.isEmpty(r3) == false) goto L5;
    L7:
        updateView(r0);
        return;
    L5:
        if (r3.equals(this.mQueryAppName) == false) goto L7;
        saveSelectedValue(r0.indexOf(this.mQueryItemTitle));
        goto L7
    }

    public void updateView(ArrayList<String> r3) {
        int r0 = this.mExpandType;
        if (r0 != 1) goto L5;
        initDefaultItems(r3);
        return;
    L5:
        if (r0 != 2) goto L11;
        rebuild();
        return;
    }

    public void initViews(int r2, int r3) {
        initViews(getResources().getStringArray(r2), getResources().getStringArray(r3));
    }

    private void initViews(String[] r2, String[] r3) {
        this.mItemTitleList.addAll(Arrays.asList(r2));
        this.mItemEntryList.addAll(Arrays.asList(r3));
        initViews(this.mItemTitleList, this.mItemEntryList);
    }

    public void initViews(String[] r2, ArrayList<String> r3) {
        this.mItemTitleList.addAll(Arrays.asList(r2));
        this.mItemEntryList = r3;
        initViews(this.mItemTitleList, r3);
    }

    public void initViews(ArrayList<String> r3, ArrayList<String> r4) {
        if (r3.size() == r4.size()) goto L7;
        OLog.e(TAG, "initViews: length: " + r3.size() + " vs " + r4.size());
        return;
    L7:
        if (this.mExpandType != 2) goto L11;
        Activity r5 = this.mActivity;
        if (r5 == null) goto L11;
        this.mApplicationsState = ApplicationsState.getInstance(r5.getApplication(), true);
        new AppQueryTask(this, this.mApplicationsState).execute(new Void[0]);
        return;
    L11:
        initDefaultItems(r3);
    }

    private void initDefaultItems(ArrayList<String> r4) {
        int r0 = 0;
        this.mItemShowingCount = 0;
        this.mDefaultItemContainer.removeAllViews();
        this.mItemExpandableContainer.removeAllViews();
        this.mItemTitleList = r4;
        int r5 = r4.size();
    L4:
        if (r0 >= 5) goto L7;
        if (r0 >= r5) goto L7;
        SettingItemCheck r1 = new SettingItemCheck(this.mContext);
        initValueForItems(r1, r0);
        this.mDefaultItemContainer.addView(r1, r0);
        this.mItemShowingCount++;
        r0 = r0 + 1;
    L7:
        int r2 = this.mItemShowingCount;
    L8:
        if (r2 >= r5) goto L10;
        SettingItemCheck r3 = new SettingItemCheck(this.mContext);
        initValueForItems(r3, r2);
        this.mItemExpandableContainer.addView(r3);
        r2 = r2 + 1;
        goto L8
    }

    private void initValueForItems(SettingItemCheck r9, int r10) {
        String r0 = this.mItemTitleList.get(r10);
        LinearLayout.LayoutParams r1 = new LinearLayout.LayoutParams(-1, -2);
        r1.gravity = 16;
        r9.setTitle(r0);
        r9.setId(r10);
        r9.setTag(Integer.valueOf(r10));
        setItemsBackground(r9, r10);
        if (isItemSelectByCurrentKey(r10) == false) goto L5;
        r9.setChecked(true);
    L5:
        boolean r2 = isItemSelectByOther(r10);
        boolean r4 = false;
        if (r2 == false) goto L9;
        r9.setTitle(r0 + getResources().getString(R.string.phone_case_shortcut_set_done));
        r9.setEnabled(false);
    L9:
        if (this.mExpandType != 1) goto L11;
        r4 = handleToolItems(r9, getAppName(r10), r0, r2);
    L11:
        r9.setLayoutParams(r1);
        if (r4 == true) goto L15;
        r9.setOnClickListener(this.mItemClickListener);
        return;
    }

    private String getAppName(int r2) {
        String[] r1 = getResources().getStringArray(R.array.phone_case_quick_tools_app_pkg);
        switch(r2) {
            case 0: goto L12;
            case 1: goto L12;
            case 2: goto L19;
            case 3: goto L18;
            case 4: goto L18;
            case 5: goto L4;
            case 6: goto L17;
            case 7: goto L17;
            case 8: goto L16;
            case 9: goto L15;
            case 10: goto L14;
            default: goto L4;
        };
    L4:
        return null;
    L14:
        return r1[6];
    L15:
        return r1[5];
    L16:
        return r1[4];
    L17:
        return r1[3];
    L18:
        return r1[2];
    L19:
        return r1[1];
    L12:
        return r1[0];
    }

    private void setItemsBackground(View r1, int r2) {
        if (r2 != 0) goto L4;
        r1.setBackgroundResource(R.drawable.selector_setting_sub_item_bg_top);
        return;
    L4:
        r1.setBackgroundResource(R.drawable.selector_setting_sub_item_bg_middle);
    }

    private boolean handleToolItems(SettingItemCheck r7, String r8, String r9, boolean r10) {
        String r0 = null;
        boolean r1 = true;
        if (r8 == null) goto L7;
        boolean r3 = Utils.isAppInstalled(this.mContext, r8);
        if (r3 == true) goto L8;
        r0 = r9 + getResources().getString(R.string.phone_case_shortcut_app_notfond);
        r7.setTitle(r0);
        likeDisable(r7, false, r8, r9);
        boolean r4 = true;
    L9:
        if (r3 == false) goto L17;
        if (r8 == null) goto L14;
        if (r10 == false) goto L14;
        r1 = false;
    L14:
        r7.setEnabled(r1);
        if (r10 == false) goto L18;
        r7.setEnabled(false);
        r9 = r9 + getResources().getString(R.string.phone_case_shortcut_set_done);
    L18:
        r7.setTitle(r9);
        return r4;
    L17:
        r9 = r0;
    L8:
        r4 = false;
        goto L9
    L7:
        r3 = true;
        goto L8
    }

    private void likeDisable(SettingItemCheck r5, boolean r6, final String r7, final String r8) {
        r5.setCheckedIconLight(!r6);
        TextView r0 = r5.getTitleView();
        float r1 = 1.0f;
        if (r6 == false) goto L5;
        float r3 = 1.0f;
    L6:
        r0.setAlpha(r3);
        r5.getIcon().setEnabled(r6);
        ImageView r2 = r5.getIcon();
        if (r6 == true) goto L10;
        r1 = 0.3f;
    L10:
        r2.setAlpha(r1);
        r5.setOnClickListener(new AnonymousClass1(this, r7, r8));
        return;
    L5:
        r3 = 0.3f;
        goto L6
    }

    public void setTitle(int r1) {
        this.mTitle.setText(r1);
    }

    public boolean hasExtra() {
        if (this.mItemShowingCount >= this.mItemEntryList.size()) goto L5;
        return true;
    L5:
        return false;
    }

    public void setSmartKey(String r1, ArrayList<String> r2) {
        this.mSelectedKey = r1;
        this.mOtherKeyList.addAll(r2);
        this.mOtherKeyList.remove(this.mSelectedKey);
    }

    public void setCheckListener(ClearCheckListener r1) {
        this.mCheckListener = r1;
    }

    public void setStoreListener(ValueStoreListener r1) {
        this.mStoreListener = r1;
    }

    public void clearChecks() {
        int r1 = 0;
    L4:
        if (r1 >= this.mDefaultItemContainer.getChildCount()) goto L9;
        SettingItemCheck r2 = (SettingItemCheck) this.mDefaultItemContainer.getChildAt(r1);
        if (r2 == null) goto L8;
        r2.setChecked(false);
    L8:
        r1 = r1 + 1;
        goto L4
    L9:
        int r3 = 0;
    L11:
        if (r3 >= this.mItemExpandableContainer.getChildCount()) goto L16;
        SettingItemCheck r4 = (SettingItemCheck) this.mItemExpandableContainer.getChildAt(r3);
        if (r4 == null) goto L15;
        r4.setChecked(false);
    L15:
        r3 = r3 + 1;
        goto L11
    }

    private void showListExtras() {
        if (hasExtra() == true) goto L5;
        return;
    L5:
        if (this.mItemExpandableContainer.isAnimating() == false) goto L8;
        return;
    L8:
        if (this.mItemExpandableContainer.isExpand() == false) goto L10;
        showItemsDefault();
        return;
    L10:
        showItemsAll();
    }

    private void showItemsDefault() {
        this.mItemMoreOrLess.setText(R.string.phone_case_view_more_short_item);
        this.mItemExpandableContainer.doCollapse();
    }

    private void showItemsAll() {
        this.mItemMoreOrLess.setText(R.string.phone_case_view_less_short_item);
        this.mItemExpandableContainer.doExpand();
    }

    private boolean isItemSelectByCurrentKey(int r3) {
        String r0 = Settings.Global.getString(this.mContext.getContentResolver(), this.mSelectedKey);
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.equals(this.mItemEntryList.get(r3)) == false) goto L7;
        return true;
    }

    private boolean isItemSelectByOther(int r4) {
        Iterator<String> r0 = this.mOtherKeyList.iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        String r1 = r0.next();
        String r2 = Settings.Global.getString(this.mContext.getContentResolver(), r1);
        if (r2 == null) goto L4;
        if (r2.equals(this.mItemEntryList.get(r4)) == false) goto L4;
        return true;
    L11:
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r2) {
        if (r2.getId() != R.id.tv_phone_case_category_expandable) goto L7;
        showListExtras();
        return;
    }

    private void saveSelectedValue(int r9) {
        String r5 = this.mItemEntryList.get(r9);
        OLog.d(TAG, "save: intentString:" + r5);
        if (this.mStoreListener != null) goto L5;
        return;
    L5:
        if (this.mExpandType != 2) goto L7;
        String r0 = this.mAppsPackageNames.get(r9);
    L8:
        this.mStoreListener.onSave(this, this.mSelectedKey, this.mItemTitleList.get(r9), r5, r0, r9);
        return;
    L7:
        r0 = null;
        goto L8
    }

    public void release() {
        ApplicationsState.Session r0 = this.mSession;
        if (r0 == null) goto L5;
        r0.release();
    L5:
        this.mIsReleased = true;
    }

    public void rebuild() {
        if (this.mItemExpandableContainer.isAnimating() == true) goto L5;
        new AppQueryTask(this, this.mApplicationsState).execute(new Void[0]);
        return;
    L5:
        new Handler().postDelayed(new AnonymousClass3(this), 300);
    }

    private void initDefaultItems(int r5) {
        this.mDefaultItemContainer.removeAllViews();
        this.mItemExpandableContainer.removeAllViews();
        int r0 = 0;
        int r1 = 0;
    L4:
        if (r0 >= 5) goto L7;
        if (r0 >= r5) goto L7;
        SettingItemCheck r2 = new SettingItemCheck(this.mContext);
        initValueForItems(r2, r0);
        this.mDefaultItemContainer.addView(r2, r0);
        r1 = r1 + 1;
        r0 = r0 + 1;
    L7:
        this.mItemShowingCount = r1;
    L8:
        if (r1 >= r5) goto L10;
        SettingItemCheck r3 = new SettingItemCheck(this.mContext);
        initValueForItems(r3, r1);
        this.mItemExpandableContainer.addView(r3);
        r1 = r1 + 1;
        goto L8
    }
}
