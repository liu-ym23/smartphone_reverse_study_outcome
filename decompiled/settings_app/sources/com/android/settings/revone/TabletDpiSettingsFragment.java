package com.android.settings.revone;

import android.app.AlertDialog;
import android.app.SmtPCUtils;
import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.DisplayInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.android.settings.R;
import com.android.settings.Utils;
import com.android.settings.base.BaseFragment;
import com.android.settings.search.Index;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.ListContentItemText;
import obric.widget.SettingItemCheck;

/* JADX INFO: loaded from: classes2.dex */
public class TabletDpiSettingsFragment extends BaseFragment {
    private static final long COUNTDOWN_FUTURE_MS = 11000;
    private static final long COUNTDOWN_INTERVAL = 1000;
    private static final long COUNTDOWN_TIMES = 10;
    private static final int EVENT_COUNTING = 1;
    private static final int EVENT_TIMEOUT = 2;
    private static final String PREF_FILE_TABLET_SUFFIX = "_tablet";
    private static final String TABLET_DPI_SETTINGS_CUSTOM_FLAG = "tablet_dpi_settings_custom_flag";
    private static final String TABLET_DPI_SETTINGS_LAST = "tablet_dpi_settings_last";
    private static final String TAG = "TabletDpiSettings";
    public static final String UNIT = "dp";
    private Handler H;
    private final float TITLE_SIZE_SP;
    private BaseAdapter mAdapter;
    private int mClickCount;
    private ContentResolver mContentResolver;
    private CountDownTimer mCountDownTimer;
    private int mCurrentIndex;
    private String mCustomDpi;
    private ListContentItemText mCustomDpiItem;
    private boolean mDialogConfirmed;
    private String mDpiKeyString;
    private boolean mIsCustomDpi;
    private int mLastIndex;
    private ListView mOptionsList;
    private HashMap<String, String> mResolutionToDpiMap;
    private AlertDialog mRevertDialog;
    private String mSelectedDpi;
    private List<String> mSupportDisplayDpis;
    private List<String> mSupportDpis;
    private AlertDialog mWarningDialog;

    private class OptionsAdapter extends BaseAdapter {
        final /* synthetic */ TabletDpiSettingsFragment this$0;

        @Override // android.widget.Adapter
        public long getItemId(int r1) {
            return r1;
        }

        private OptionsAdapter(TabletDpiSettingsFragment r1) {
            this.this$0 = r1;
        }

        /* synthetic */ OptionsAdapter(TabletDpiSettingsFragment r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return TabletDpiSettingsFragment.access$900(this.this$0).size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int r1) {
            return Integer.valueOf(r1);
        }

        @Override // android.widget.Adapter
        public View getView(int r4, View r5, ViewGroup r6) {
            if (r5 != null) goto L4;
            r5 = View.inflate(this.this$0.getActivity(), R.layout.list_content_item_check, null);
            SettingItemCheck r7 = (SettingItemCheck) r5.findViewById(R.id.item_check);
            r5.setTag(r7);
        L5:
            Utils.setItemBgStyle(r7, getCount(), r4);
            r7.getTitleView().setTextSize(((Integer.valueOf((String) TabletDpiSettingsFragment.access$900(this.this$0).get(r4)).intValue() * 1.0f) / Integer.valueOf(TabletDpiSettingsFragment.access$1700(this.this$0)).intValue()) * 18.0f);
            r7.setTitle(((String) TabletDpiSettingsFragment.access$900(this.this$0).get(r4)) + TabletDpiSettingsFragment.UNIT + ((String) TabletDpiSettingsFragment.access$1800(this.this$0).get(r4)));
            if (r4 != TabletDpiSettingsFragment.access$1000(this.this$0)) goto L8;
            boolean r3 = true;
        L9:
            r7.setChecked(r3);
            return r5;
        L8:
            r3 = false;
            goto L9
        L4:
            r7 = (SettingItemCheck) r5.getTag();
            goto L5
        }
    }

    public void com_android_settings_revone_TabletDpiSettingsFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_revone_TabletDpiSettingsFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_revone_TabletDpiSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_revone_TabletDpiSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public TabletDpiSettingsFragment() {
        this.mLastIndex = -1;
        this.TITLE_SIZE_SP = 18.0f;
        this.mResolutionToDpiMap = new HashMap();
        this.mIsCustomDpi = false;
        this.mSupportDpis = new ArrayList();
        this.mSupportDisplayDpis = new ArrayList();
        this.mClickCount = 0;
        this.H = new AnonymousClass1(this);
    }

    static /* synthetic */ int access$000(TabletDpiSettingsFragment r0) {
        return r0.mClickCount;
    }

    static /* synthetic */ int access$002(TabletDpiSettingsFragment r0, int r1) {
        r0.mClickCount = r1;
        return r1;
    }

    static /* synthetic */ int access$008(TabletDpiSettingsFragment r2) {
        int r0 = r2.mClickCount;
        r2.mClickCount = r0 + 1;
        return r0;
    }

    static /* synthetic */ ListContentItemText access$100(TabletDpiSettingsFragment r0) {
        return r0.mCustomDpiItem;
    }

    static /* synthetic */ int access$1000(TabletDpiSettingsFragment r0) {
        return r0.mCurrentIndex;
    }

    static /* synthetic */ int access$1002(TabletDpiSettingsFragment r0, int r1) {
        r0.mCurrentIndex = r1;
        return r1;
    }

    static /* synthetic */ int access$1100(TabletDpiSettingsFragment r0) {
        return r0.mLastIndex;
    }

    static /* synthetic */ int access$1102(TabletDpiSettingsFragment r0, int r1) {
        r0.mLastIndex = r1;
        return r1;
    }

    static /* synthetic */ BaseAdapter access$1200(TabletDpiSettingsFragment r0) {
        return r0.mAdapter;
    }

    static /* synthetic */ boolean access$1300(TabletDpiSettingsFragment r0) {
        return r0.mDialogConfirmed;
    }

    static /* synthetic */ boolean access$1302(TabletDpiSettingsFragment r0, boolean r1) {
        r0.mDialogConfirmed = r1;
        return r1;
    }

    static /* synthetic */ String access$1400(HashMap r0) {
        return combineResolutionDpi(r0);
    }

    static /* synthetic */ ContentResolver access$1500(TabletDpiSettingsFragment r0) {
        return r0.mContentResolver;
    }

    static /* synthetic */ AlertDialog access$1602(TabletDpiSettingsFragment r0, AlertDialog r1) {
        r0.mWarningDialog = r1;
        return r1;
    }

    static /* synthetic */ String access$1700(TabletDpiSettingsFragment r0) {
        return r0.mSelectedDpi;
    }

    static /* synthetic */ List access$1800(TabletDpiSettingsFragment r0) {
        return r0.mSupportDisplayDpis;
    }

    static /* synthetic */ boolean access$200(TabletDpiSettingsFragment r0) {
        return r0.mIsCustomDpi;
    }

    static /* synthetic */ boolean access$202(TabletDpiSettingsFragment r0, boolean r1) {
        r0.mIsCustomDpi = r1;
        return r1;
    }

    static /* synthetic */ String access$300(TabletDpiSettingsFragment r0) {
        return r0.mCustomDpi;
    }

    static /* synthetic */ String access$302(TabletDpiSettingsFragment r0, String r1) {
        r0.mCustomDpi = r1;
        return r1;
    }

    static /* synthetic */ void access$400(TabletDpiSettingsFragment r0) {
        r0.updateCustomDpiItem();
    }

    static /* synthetic */ String access$500(TabletDpiSettingsFragment r0) {
        return r0.mDpiKeyString;
    }

    static /* synthetic */ HashMap access$600(TabletDpiSettingsFragment r0) {
        return r0.mResolutionToDpiMap;
    }

    static /* synthetic */ void access$700(TabletDpiSettingsFragment r0, boolean r1) {
        r0.showWarningDialog(r1);
    }

    static /* synthetic */ List access$900(TabletDpiSettingsFragment r0) {
        return r0.mSupportDpis;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        this.mRootView = r2.inflate(R.layout.revone_dpi_settings_layout, r3, false);
        this.mContentResolver = getContentResolver();
        DisplayInfo r5 = new DisplayInfo();
        Display r6 = SmtPCUtils.getExtDisplay(this.mContext);
        if (r6 == null) goto L5;
        r6.getDisplayInfo(r5);
        this.mDpiKeyString = r5.largestNominalAppWidth + "_" + r5.smallestNominalAppWidth;
        this.mResolutionToDpiMap = parseResolutionDpi(Settings.Global.getString(this.mContentResolver, "tablet_dpi_settings"));
        OLog.d(TAG, "mResolutionToDpiMap=" + this.mResolutionToDpiMap);
    L5:
        initDpiValue();
        ListContentItemText r7 = (ListContentItemText) findViewByIdNullable(R.id.view_dpi_custom);
        this.mCustomDpiItem = r7;
        r7.setOnClickListener(new AnonymousClass2(this));
        updateCustomDpiItem();
        this.mOptionsList = (ListView) findViewByIdNullable(R.id.options_list);
        this.mOptionsList.addHeaderView(Utils.inflateListTransparentHeader(getActivity(), this.mOptionsList, false));
        addFooterView();
        OptionsAdapter r8 = new OptionsAdapter(this, null);
        this.mAdapter = r8;
        this.mOptionsList.setAdapter(r8);
        this.mOptionsList.setOnItemClickListener(new AnonymousClass3(this));
        Utils.setListViewIgnoreAccessibilityItemCount(this.mOptionsList, 1);
        return this.mRootView;
    }

    private void initDpiValue() {
        Point r0 = new Point();
        if (SmtPCUtils.getExtDisplay(this.mContext) != null) goto L6;
        OLog.e(TAG, "ext display is Null! Current activity = " + getActivity());
        return;
    L6:
        String r1 = String.valueOf(SmtPCUtils.getDefaultAndSupportedDpiForResolution(r0.x, r0.y, this.mSupportDpis));
        DisplayInfo r2 = SmtPCUtils.getExtDisplayInfo(this.mContext);
        if (r2 == null) goto L9;
        this.mSelectedDpi = String.valueOf(r2.logicalDensityDpi);
    L12:
        List<String> r3 = DpiUtils.getDpiDisplayList(this.mContext.getApplicationContext(), r1, this.mSupportDpis);
        this.mSupportDisplayDpis = r3;
        if (r3.size() == this.mSupportDpis.size()) goto L15;
        this.mSupportDisplayDpis = this.mSupportDpis;
    L15:
        OLog.d(TAG, "recommend dpi: " + r1);
        OLog.i(TAG, this.mSupportDpis.toString());
        OLog.i(TAG, this.mSupportDisplayDpis.toString());
        int r4 = getCurrentDpiIndex();
        this.mCurrentIndex = r4;
        if (r4 != (-1)) goto L19;
        this.mIsCustomDpi = true;
        this.mCustomDpi = this.mResolutionToDpiMap.get(this.mDpiKeyString);
        return;
    L19:
        return;
    L9:
        DisplayMetrics r5 = this.mContext.getResources().getDisplayMetrics();
        if (r5 == null) goto L12;
        this.mSelectedDpi = String.valueOf(r5.densityDpi);
        goto L12
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        AlertDialog r0 = this.mWarningDialog;
        if (r0 == null) goto L6;
        r0.dismiss();
        return;
    }

    private int getCurrentDpiIndex() {
        int r0 = 0;
    L4:
        if (r0 >= this.mSupportDpis.size()) goto L9;
        if (this.mSupportDpis.get(r0).equals(this.mSelectedDpi) == true) goto L7;
        r0 = r0 + 1;
        goto L4
    L7:
        return r0;
    L9:
        return -1;
    }

    private void addFooterView() {
        TextView r0 = new TextView(this.mContext);
        r0.setTextAppearance(R.style.SettingItemTipsStyle);
        Resources r1 = this.mContext.getResources();
        r0.setPadding(r1.getDimensionPixelSize(R.dimen.settings_item_title_left_margin), r1.getDimensionPixelSize(R.dimen.settings_item_tips_margin_top), r1.getDimensionPixelSize(R.dimen.settings_item_title_left_margin), r1.getDimensionPixelSize(R.dimen.settings_item_tips_margin_bottom));
        r0.setText(R.string.dpi_settings_tips);
        r0.setOnClickListener(new TabletDpiSettingsFragment$$ExternalSyntheticLambda0(this));
        this.mOptionsList.addFooterView(r0);
    }

    /* JADX INFO: renamed from: lambda$addFooterView$0$com-android-settings-revone-TabletDpiSettingsFragment, reason: not valid java name */
    /* synthetic */ void m560x7f2a17ac(View r4) {
        this.H.removeMessages(2);
        this.H.sendEmptyMessageDelayed(2, 2000);
        this.H.sendEmptyMessage(1);
    }

    private void showWarningDialog(final boolean r7) {
        AlertDialog r0 = this.mWarningDialog;
        if (r0 != null) goto L5;
    L7:
        final FragmentActivity r1 = getActivity();
        if (r1 != null) goto L11;
        OLog.e(TAG, "showWarningDialog, activity is null, return");
        return;
    L11:
        this.mDialogConfirmed = false;
        AlertDialog.Builder r2 = new AlertDialog.Builder(r1);
        r2.setTitle(R.string.dpi_dlg_title_notice).setMessage(R.string.dpi_dlg_tips).setNegativeButton(android.R.string.cancel, null).setPositiveButton(android.R.string.ok, new AnonymousClass5(this)).setOnDismissListener(new AnonymousClass4(this, r7, r1)).setCancelable(false);
        AlertDialog r8 = r2.create();
        this.mWarningDialog = r8;
        r8.show();
        return;
    L5:
        if (r0.isShowing() == false) goto L7;
    }

    private void updateCustomDpiItem() {
        ListContentItemText r0 = this.mCustomDpiItem;
        if (this.mIsCustomDpi == false) goto L5;
        String r2 = this.mCustomDpi;
    L6:
        r0.setSubtitle(r2);
        return;
    L5:
        r2 = "";
        goto L6
    }

    private static String combineResolutionDpi(HashMap<String, String> r4) {
        if (r4 != null) goto L4;
        return null;
    L4:
        if (r4.isEmpty() == true) goto L20;
        StringBuilder r0 = new StringBuilder();
        Iterator<Map.Entry<String, String>> r5 = r4.entrySet().iterator();
        boolean r1 = true;
    L8:
        if (r5.hasNext() == false) goto L14;
        if (r1 == false) goto L11;
        r1 = false;
    L12:
        Map.Entry<String, String> r2 = r5.next();
        r0.append(r2.getKey());
        r0.append("@");
        r0.append(r2.getValue());
        goto L8
    L11:
        r0.append(Index.ENTRIES_SEPARATOR);
        goto L12
    L14:
        return r0.toString();
    L20:
        return null;
    }

    private static HashMap<String, String> parseResolutionDpi(String r3) {
        HashMap<String, String> r0 = new HashMap();
        if (r3 != null) goto L5;
    L15:
        return r0;
    L5:
        if (r3.isEmpty() == true) goto L15;
        int r1 = 0;
    L8:
        if (r1 < 0) goto L15;
        int r2 = r3.indexOf(124, r1);
        if (r2 >= 0) goto L12;
        parseDpi(r3.substring(r1), r0);
    L14:
        r1 = r2;
        goto L8
    L12:
        if (r2 <= r1) goto L14;
        parseDpi(r3.substring(r1, r2), r0);
        r2 = r2 + 1;
        goto L14
    }

    private static void parseDpi(String r2, HashMap<String, String> r3) {
        if (r2.isEmpty() == false) goto L5;
        return;
    L5:
        int r0 = r2.indexOf(64);
        if (r0 <= 0) goto L9;
        r3.put(r2.substring(0, r0), r2.substring(r0 + 1));
        return;
    }

    public static boolean getCustomDpiFlag(Context r2) {
        return r2.getSharedPreferences(r2.getPackageName() + PREF_FILE_TABLET_SUFFIX, 0).getBoolean(TABLET_DPI_SETTINGS_CUSTOM_FLAG, false);
    }

    public static void setCustomDpiFlag(Context r2, boolean r3) {
        SharedPreferences.Editor r4 = r2.getSharedPreferences(r2.getPackageName() + PREF_FILE_TABLET_SUFFIX, 0).edit();
        r4.putBoolean(TABLET_DPI_SETTINGS_CUSTOM_FLAG, r3);
        r4.apply();
    }

    public static void storeLastResolutionDpi(Context r2, String r3) {
        SharedPreferences.Editor r4 = r2.getSharedPreferences(r2.getPackageName() + PREF_FILE_TABLET_SUFFIX, 0).edit();
        r4.putString(TABLET_DPI_SETTINGS_LAST, r3);
        r4.apply();
    }

    public static String getResolutionDpiInSp(Context r2) {
        return r2.getSharedPreferences(r2.getPackageName() + PREF_FILE_TABLET_SUFFIX, 0).getString(TABLET_DPI_SETTINGS_LAST, "");
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_revone_TabletDpiSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(TabletDpiSettingsFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_revone_TabletDpiSettingsFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_revone_TabletDpiSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(TabletDpiSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_revone_TabletDpiSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_revone_TabletDpiSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(TabletDpiSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_revone_TabletDpiSettingsFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
