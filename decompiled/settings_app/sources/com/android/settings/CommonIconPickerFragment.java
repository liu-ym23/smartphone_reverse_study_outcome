package com.android.settings;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.res.IconManager;
import android.os.Bundle;
import android.os.UserHandle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.settings.applications.ApplicationsState;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.NullSafe;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.ListContentItemCustom;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class CommonIconPickerFragment extends BaseFragment implements View.OnClickListener {
    private static final int ICON_TYPE_GROUP_HEADER = 2;
    private static final int ICON_TYPE_GROUP_TAIL = 3;
    private static final int ICON_TYPE_NONE = 0;
    private static final int ICON_TYPE_NORMAL = 1;
    private static final int NUM_COLUMNS = 3;
    private static final String TAG = "CommonIconPicker";
    private IconAdapter mAdapter;
    private AppIconsSettingsFragment.Asset mAsset;
    private ArrayList<CategoryInfo> mCats;
    private RelativeLayout mEmptyView;
    private ArrayList<IconEntry> mIconEntries;
    private IconManager mIconManager;
    private ImageDownloader mImageDownloader;
    private IconEntry mInvalidIconEntry;
    private boolean mIsPrimaryPkg;
    private ListView mListView;
    private Locale mLocale;
    private String mOldMd5;
    private BroadcastReceiver mPackageReceiver;
    private PackageManager mPm;
    private int mPrimaryEntryCount;
    private IconEntry mSelectedIcon;

    class CategoryInfo {
        HashMap<String, String> namesMap;
        final /* synthetic */ CommonIconPickerFragment this$0;

        CategoryInfo(CommonIconPickerFragment r1) {
            this.this$0 = r1;
        }
    }

    class IconAdapter extends BaseAdapter {
        LayoutInflater mInflater;
        final /* synthetic */ CommonIconPickerFragment this$0;

        class ViewHolder {
            LinearLayout bottomDivider;
            TextView catName;
            ImageView icon1;
            ImageView icon1Bg;
            ImageView icon1Selected;
            ImageView icon2;
            ImageView icon2Bg;
            ImageView icon2Selected;
            ImageView icon3;
            ImageView icon3Bg;
            ImageView icon3Selected;
            LinearLayout iconLayout;
            FrameLayout layout1;
            FrameLayout layout2;
            FrameLayout layout3;
            ListContentItemCustom pickerLayout;
            LinearLayout primaryPartGap;
            final /* synthetic */ IconAdapter this$1;
            LinearLayout topDivider;

            ViewHolder(IconAdapter r1) {
                this.this$1 = r1;
            }
        }

        @Override // android.widget.Adapter
        public long getItemId(int r1) {
            return r1;
        }

        public IconAdapter(CommonIconPickerFragment r1, Context r2) {
            this.this$0 = r1;
            this.mInflater = LayoutInflater.from(r2);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return CommonIconPickerFragment.access$100(this.this$0).size() / 3;
        }

        @Override // android.widget.Adapter
        public Object getItem(int r1) {
            return Integer.valueOf(r1);
        }

        @Override // android.widget.Adapter
        public View getView(int r11, View r12, ViewGroup r13) {
            if (r12 != null) goto L4;
            ViewHolder r14 = new ViewHolder(this);
            View r15 = this.mInflater.inflate(R.layout.common_icon_picker_adapter_item, null);
            r14.catName = (TextView) r15.findViewById(R.id.cat_name);
            r14.icon1 = (ImageView) r15.findViewById(R.id.icon_1);
            r14.icon2 = (ImageView) r15.findViewById(R.id.icon_2);
            r14.icon3 = (ImageView) r15.findViewById(R.id.icon_3);
            r14.icon1Bg = (ImageView) r15.findViewById(R.id.icon_1_bg);
            r14.icon2Bg = (ImageView) r15.findViewById(R.id.icon_2_bg);
            r14.icon3Bg = (ImageView) r15.findViewById(R.id.icon_3_bg);
            r14.icon1Selected = (ImageView) r15.findViewById(R.id.icon_1_selected);
            r14.icon2Selected = (ImageView) r15.findViewById(R.id.icon_2_selected);
            r14.icon3Selected = (ImageView) r15.findViewById(R.id.icon_3_selected);
            r14.layout1 = (FrameLayout) r15.findViewById(R.id.icon_1_layout);
            r14.layout2 = (FrameLayout) r15.findViewById(R.id.icon_2_layout);
            r14.layout3 = (FrameLayout) r15.findViewById(R.id.icon_3_layout);
            r14.pickerLayout = (ListContentItemCustom) r15.findViewById(R.id.list_item);
            r14.topDivider = (LinearLayout) r15.findViewById(R.id.top_div);
            r14.bottomDivider = (LinearLayout) r15.findViewById(R.id.bottom_div);
            r14.iconLayout = (LinearLayout) r15.findViewById(R.id.icon_layout);
            r14.primaryPartGap = (LinearLayout) NullSafe.nonNull(r15.findViewById(R.id.primary_part_gap));
            r15.setTag(r14);
        L5:
            int r0 = r11 * 3;
            setupIconEntry(r0, r14);
            int r1 = r0 + 1;
            setupIconEntry(r1, r14);
            int r2 = r0 + 2;
            setupIconEntry(r2, r14);
            r14.layout1.setTag(Integer.valueOf(r0));
            r14.layout2.setTag(Integer.valueOf(r1));
            r14.layout3.setTag(Integer.valueOf(r2));
            r14.layout1.setOnClickListener(this.this$0);
            r14.layout2.setOnClickListener(this.this$0);
            r14.layout3.setOnClickListener(this.this$0);
            int r3 = this.this$0.getResources().getDimensionPixelSize(R.dimen.common_icon_picker_top_bottom_padding);
            int r4 = getCount();
            int r5 = 3;
            int r10 = CommonIconPickerFragment.access$200(this.this$0) / 3;
            int r6 = r4 - r10;
            if (r10 != 1) goto L9;
            if (r11 != 0) goto L18;
            r14.topDivider.setPadding(0, r3, 0, 0);
            r14.bottomDivider.setPadding(0, 0, 0, r3);
            int r8 = 1;
        L19:
            if (r6 != 1) goto L22;
            if (r11 != r10) goto L31;
            r14.topDivider.setPadding(0, r3, 0, 0);
            r14.bottomDivider.setPadding(0, 0, 0, r3);
            r5 = 1;
        L32:
            r14.pickerLayout.setBackgroundStyle(r5);
            return r15;
        L31:
            r5 = r8;
            goto L32
        L22:
            if (r6 <= 1) goto L31;
            if (r11 != r10) goto L25;
            r14.topDivider.setPadding(0, r3, 0, 0);
            r14.bottomDivider.setPadding(0, 0, 0, 0);
            r5 = 2;
            goto L32
        L25:
            int r7 = r4 - 1;
            if (r11 != r7) goto L28;
            r14.topDivider.setPadding(0, 0, 0, 0);
            r14.bottomDivider.setPadding(0, 0, 0, r3);
            r5 = 4;
            goto L32
        L28:
            if (r11 <= r10) goto L31;
            if (r11 >= r7) goto L31;
            r14.topDivider.setPadding(0, 0, 0, 0);
            r14.bottomDivider.setPadding(0, 0, 0, 0);
        L18:
            r8 = 3;
            goto L19
        L9:
            if (r10 <= 1) goto L18;
            if (r11 != 0) goto L12;
            r14.topDivider.setPadding(0, r3, 0, 0);
            r14.bottomDivider.setPadding(0, 0, 0, 0);
            r8 = 2;
            goto L19
        L12:
            int r9 = r10 - 1;
            if (r11 != r9) goto L15;
            r14.topDivider.setPadding(0, 0, 0, 0);
            r14.bottomDivider.setPadding(0, 0, 0, r3);
            r8 = 4;
            goto L19
        L15:
            if (r11 <= 0) goto L18;
            if (r11 >= r9) goto L18;
            r14.topDivider.setPadding(0, 0, 0, 0);
            r14.bottomDivider.setPadding(0, 0, 0, 0);
            goto L18
        L4:
            r15 = r12;
            r14 = (ViewHolder) r12.getTag();
            goto L5
        }

        private void setupIconEntry(int r8, ViewHolder r9) {
            if (this.this$0.isAdded() == true) goto L5;
            return;
        L5:
            IconEntry r0 = (IconEntry) CommonIconPickerFragment.access$100(this.this$0).get(r8);
            int r1 = r8 % 3;
            if (r1 != 0) goto L8;
            CommonIconPickerFragment.access$300(this.this$0).download(r0.mFilePath, r9.icon1);
            if (r0.mFileMd5 != null) goto L55;
        L57:
            r9.icon1Selected.setVisibility(8);
        L58:
            CategoryInfo r2 = (CategoryInfo) CommonIconPickerFragment.access$500(this.this$0).get(r0.mCatIndex);
            if (r2 != null) goto L61;
        L65:
            String r5 = null;
        L67:
            if (TextUtils.isEmpty(r5) == true) goto L69;
        L73:
            r9.catName.setText(r5);
            if (r0.mType != 2) goto L76;
            r9.catName.setVisibility(0);
            return;
        L76:
            r9.catName.setVisibility(8);
            return;
        L69:
            if (CommonIconPickerFragment.access$700(this.this$0) == false) goto L72;
            if (r8 != 0) goto L72;
            r5 = this.this$0.getString(R.string.icon_category_historical);
        L72:
            r5 = this.this$0.getString(R.string.icon_category_other);
            goto L73
        L61:
            if (r2.namesMap == null) goto L65;
            r5 = r2.namesMap.get(CommonIconPickerFragment.access$600(this.this$0).toString());
            if (TextUtils.isEmpty(r5) == false) goto L67;
            r5 = r2.namesMap.get(Constants.APP_LABELS_OF_EN_US);
            goto L67
        L55:
            if (r0.mFileMd5.equals(CommonIconPickerFragment.access$400(this.this$0).mFileMd5) == false) goto L57;
            r9.icon1Selected.setVisibility(0);
            goto L58
        L8:
            if (r1 == 1) goto L44;
            if (r1 == 2) goto L12;
            return;
        L12:
            if (r0.mType != 0) goto L24;
            r9.icon3Bg.setVisibility(4);
            r9.icon3Selected.setVisibility(8);
            r9.icon3.setVisibility(8);
            r9.primaryPartGap.setVisibility(8);
            if (CommonIconPickerFragment.access$500(this.this$0).size() > 1) goto L16;
        L23:
            r9.bottomDivider.setVisibility(8);
            return;
        L16:
            if (r8 == (CommonIconPickerFragment.access$100(this.this$0).size() - 1)) goto L23;
            if (r8 >= CommonIconPickerFragment.access$200(this.this$0)) goto L22;
            r9.bottomDivider.setVisibility(8);
            if (CommonIconPickerFragment.access$200(this.this$0) <= 0) goto L78;
            r9.primaryPartGap.setVisibility(0);
            return;
        L78:
            return;
        L22:
            r9.bottomDivider.setVisibility(8);
            return;
        L24:
            r9.icon3.setVisibility(0);
            r9.icon3Bg.setVisibility(0);
            r9.primaryPartGap.setVisibility(8);
            CommonIconPickerFragment.access$300(this.this$0).download(r0.mFilePath, r9.icon3);
            if (r0.mFileMd5 != null) goto L27;
        L29:
            r9.icon3Selected.setVisibility(8);
        L31:
            if (CommonIconPickerFragment.access$500(this.this$0).size() > 1) goto L33;
        L42:
            r9.bottomDivider.setVisibility(8);
            return;
        L33:
            if (r8 == (CommonIconPickerFragment.access$100(this.this$0).size() - 1)) goto L42;
            if (r0.mType != 3) goto L42;
            if (r8 >= CommonIconPickerFragment.access$200(this.this$0)) goto L41;
            r9.bottomDivider.setVisibility(8);
            if (CommonIconPickerFragment.access$200(this.this$0) <= 0) goto L82;
            r9.primaryPartGap.setVisibility(0);
            return;
        L82:
            return;
        L41:
            r9.bottomDivider.setVisibility(8);
            return;
        L27:
            if (r0.mFileMd5.equals(CommonIconPickerFragment.access$400(this.this$0).mFileMd5) == false) goto L29;
            r9.icon3Selected.setVisibility(0);
            goto L31
        L44:
            if (r0.mType != 0) goto L46;
            r9.icon2Bg.setVisibility(4);
            r9.icon2Selected.setVisibility(8);
            r9.icon2.setVisibility(8);
            return;
        L46:
            r9.icon2.setVisibility(0);
            r9.icon2Bg.setVisibility(0);
            CommonIconPickerFragment.access$300(this.this$0).download(r0.mFilePath, r9.icon2);
            if (r0.mFileMd5 != null) goto L49;
        L51:
            r9.icon2Selected.setVisibility(8);
            return;
        L49:
            if (r0.mFileMd5.equals(CommonIconPickerFragment.access$400(this.this$0).mFileMd5) == false) goto L51;
            r9.icon2Selected.setVisibility(0);
        }
    }

    class IconEntry {
        int mCatIndex;
        String mFileMd5;
        String mFilePath;
        int mType;
        final /* synthetic */ CommonIconPickerFragment this$0;

        public IconEntry(CommonIconPickerFragment r1) {
            this.this$0 = r1;
        }

        public IconEntry(CommonIconPickerFragment r1, int r2, String r3, int r4) {
            this.this$0 = r1;
            this.mType = r2;
            this.mCatIndex = r4;
            this.mFilePath = r3;
            if (r3 == null) goto L6;
            this.mFileMd5 = Utils.getFileMD5(r3);
            return;
        }

        public String toString() {
            return "IconEntry{mType=" + this.mType + ", mFilePath='" + this.mFilePath + "', mFileMd5='" + this.mFileMd5 + "'}";
        }
    }

    public void com_android_settings_CommonIconPickerFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_CommonIconPickerFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_CommonIconPickerFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public CommonIconPickerFragment() {
        this.mInvalidIconEntry = new IconEntry(this, 0, null, -1);
        this.mSelectedIcon = new IconEntry(this);
        this.mIconEntries = new ArrayList();
        this.mPackageReceiver = new AnonymousClass1(this);
    }

    static /* synthetic */ AppIconsSettingsFragment.Asset access$000(CommonIconPickerFragment r0) {
        return r0.mAsset;
    }

    static /* synthetic */ ArrayList access$100(CommonIconPickerFragment r0) {
        return r0.mIconEntries;
    }

    static /* synthetic */ int access$200(CommonIconPickerFragment r0) {
        return r0.mPrimaryEntryCount;
    }

    static /* synthetic */ ImageDownloader access$300(CommonIconPickerFragment r0) {
        return r0.mImageDownloader;
    }

    static /* synthetic */ IconEntry access$400(CommonIconPickerFragment r0) {
        return r0.mSelectedIcon;
    }

    static /* synthetic */ ArrayList access$500(CommonIconPickerFragment r0) {
        return r0.mCats;
    }

    static /* synthetic */ Locale access$600(CommonIconPickerFragment r0) {
        return r0.mLocale;
    }

    static /* synthetic */ boolean access$700(CommonIconPickerFragment r0) {
        return r0.mIsPrimaryPkg;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        this.mRootView = r3.inflate(R.layout.common_icon_picker_layout, r4, false);
        this.mLocale = getResources().getConfiguration().locale;
        this.mImageDownloader = ImageDownloader.getInstance(this.mContext);
        Bundle r6 = getArguments();
        this.mAsset = (AppIconsSettingsFragment.Asset) r6.getParcelable(AppIconsSettingsFragment.EXTRA_ASSET);
        String r7 = r6.getString(AppIconsSettingsFragment.EXTRA_REDIRECTED_PATH);
        if (r7 == null) goto L5;
        this.mOldMd5 = Utils.getFileMD5(r7);
        OLog.d(TAG, "old md5:" + this.mOldMd5);
        this.mSelectedIcon.mFileMd5 = this.mOldMd5;
    L5:
        this.mIsPrimaryPkg = r6.getBoolean(AppIconsSettingsFragment.EXTRA_IS_PRIMARY_PKG, false);
        OLog.d(TAG, "mIsPrimaryPkg:" + this.mIsPrimaryPkg + " pkg:" + this.mAsset.getPackageName());
        this.mIconManager = (IconManager) this.mContext.getSystemService("icon");
        this.mPm = getPackageManager();
        ListView r8 = (ListView) findViewByIdNullable(R.id.icons_list_view);
        this.mListView = r8;
        r8.addHeaderView(initAppInfo());
        this.mListView.addFooterView(Utils.inflateListTransparentFooterWithExtra(getActivity(), this.mListView, false));
        IconAdapter r9 = new IconAdapter(this, getActivity());
        this.mAdapter = r9;
        this.mListView.setAdapter(r9);
        getAvailableIconsPath();
        registerPackageReceiver();
        if (this.mAsset != null) goto L9;
        finish();
    L9:
        return this.mRootView;
    }

    private void handlePrimaryPkgHasNoMultiIcon(int r6) {
        this.mIconEntries.add(new IconEntry(this, 2, getArguments().getString(AppIconsSettingsFragment.EXTRA_REDIRECTED_PATH), r6));
        int r1 = 0;
    L3:
        if (r1 >= 2) goto L5;
        this.mIconEntries.add(new IconEntry(this, 0, null, r6));
        r1 = r1 + 1;
        goto L3
    }

    private void getAvailableIconsPath() {
        this.mCats = new ArrayList();
        if (this.mIsPrimaryPkg == false) goto L16;
        String r1 = this.mIconManager.getAllIconForPackage(this.mAsset.getPackageName());
        OLog.d(TAG, "allIcon:" + r1 + " for pkg:" + this.mAsset.getPackageName());
        if (TextUtils.isEmpty(r1) == true) goto L16;
        JSONObject r4 = new JSONObject(r1);     // Catch: JSONException -> L14
        this.mCats.add(new CategoryInfo(this));     // Catch: JSONException -> L14
        if (r4.has("logo") == true) goto L9;
    L11:
        getCategoryIcons(r4, 0);     // Catch: JSONException -> L14
    L12:
        this.mPrimaryEntryCount = this.mIconEntries.size();     // Catch: JSONException -> L14
        int r0 = 1;
    L17:
        List r2 = this.mIconManager.getIconInfoForAllCategory();
        if (r2 == null) goto L35;
        Iterator r3 = r2.iterator();
    L21:
        if (r3.hasNext() == false) goto L35;
        String r5 = (String) r3.next();
        OLog.d(TAG, "cat:" + r5);
        if (TextUtils.isEmpty(r5) == true) goto L21;
        JSONObject r6 = new JSONObject(r5);     // Catch: JSONException -> L31
        this.mCats.add(getCategoryNames(r6));     // Catch: JSONException -> L31
        int r7 = r0 + 1;
        getCategoryIcons(r6, r0);     // Catch: JSONException -> L29
    L34:
        r0 = r7;
    L29:
        JSONException e = e;
    L33:
        e.printStackTrace();
    L31:
        e = move-exception;
        r7 = r0;
        e = e;
    L35:
        String r8 = this.mIconManager.getCommonIconPath();
        OLog.d(TAG, "" + r8);
        if (r8 != null) goto L49;
    L41:
        this.mCats.trimToSize();
        if (this.mIconEntries.size() == 0) goto L44;
        return;
    L44:
        if (Utils.isNetworkAvailable(this.mContext) == true) goto L60;
        this.mEmptyView.setVisibility(0);
        return;
    L60:
        return;
    L49:
        JSONObject r9 = new JSONObject(r8);     // Catch: JSONException -> L39
        this.mCats.add(getCategoryNames(r9));     // Catch: JSONException -> L39
        getCategoryIcons(r9, r0);     // Catch: JSONException -> L39
    L39:
        e = move-exception;
        e.printStackTrace();
        goto L41
    L9:
        if (r4.getJSONArray("logo").length() != 0) goto L11;
        handlePrimaryPkgHasNoMultiIcon(0);     // Catch: JSONException -> L14
    L14:
        e = move-exception;
        e.printStackTrace();
    L16:
        r0 = 0;
        goto L17
    }

    private CategoryInfo getCategoryNames(JSONObject r7) throws JSONException {
        if (r7 != null) goto L5;
        OLog.w(TAG, "params should not be null!");
        return null;
    L5:
        CategoryInfo r0 = new CategoryInfo(this);
        JSONObject r6 = r7.getJSONObject("name");
        JSONArray r8 = r6.names();
        int r1 = r8.length();
        r0.namesMap = new HashMap(r1);
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L8;
        String r3 = r8.getString(r2);
        String r4 = r6.getString(r3);
        r0.namesMap.put(r3, r4);
        r2 = r2 + 1;
        goto L6
    L8:
        return r0;
    }

    private void getCategoryIcons(JSONObject r7, int r8) throws JSONException {
        if (r7 != null) goto L5;
        OLog.w(TAG, "params should not be null!");
        return;
    L5:
        JSONArray r9 = r7.getJSONArray("logo");
        int r0 = r9.length();
        int r2 = 0;
    L6:
        int r3 = 3;
        if (r2 >= r0) goto L15;
        if (r2 != 0) goto L11;
        r3 = 2;
    L14:
        this.mIconEntries.add(new IconEntry(this, r3, r9.getString(r2), r8));
        r2 = r2 + 1;
        goto L6
    L11:
        if (r2 == (r0 - 1)) goto L14;
        r3 = 1;
        goto L14
    L15:
        int r1 = r0 % 3;
        if (r1 <= 0) goto L21;
        int r10 = 0;
    L19:
        if (r10 >= (3 - r1)) goto L27;
        this.mIconEntries.add(new IconEntry(this, 0, null, r8));
        r10 = r10 + 1;
        goto L19
    L27:
        return;
    }

    private void registerPackageReceiver() {
        IntentFilter r0 = new IntentFilter();
        r0.addAction("android.intent.action.PACKAGE_REMOVED");
        r0.addDataScheme("package");
        registerReceiver(this.mPackageReceiver, r0);
    }

    private void unregisterPackageReceiver() {
        unregisterReceiver(this.mPackageReceiver);
    }

    private View initAppInfo() {
        View r0 = LayoutInflater.from(getActivity()).inflate(R.layout.common_icon_app_info, null);
        ImageView r1 = (ImageView) r0.findViewById(R.id.app_icon);
        TextView r2 = (TextView) r0.findViewById(R.id.app_name);
        TextView r3 = (TextView) r0.findViewById(R.id.app_version);
        r1.setImageDrawable(this.mAsset.getOfficialIcon(this.mIconManager));
        r2.setText(this.mAsset.getAppName(this.mPm));
        r3.setText(this.mAsset.getAppVersionName(this.mPm));
        this.mEmptyView = (RelativeLayout) r0.findViewById(R.id.empty_view);
        return r0;
    }

    public void com_android_settings_CommonIconPickerFragment__onResume$___twin___() {
        super.onResume();
        this.mLocale = getResources().getConfiguration().locale;
        OLog.d(TAG, "locale:" + this.mLocale);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        unregisterPackageReceiver();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        setRedirectedIcon();
    }

    private void setRedirectedIcon() {
        if (this.mInvalidIconEntry.equals(this.mSelectedIcon) == true) goto L5;
        IconEntry r0 = this.mSelectedIcon;
        if (r0 != null) goto L11;
        return;
    L11:
        if (r0.mFileMd5 != null) goto L13;
        return;
    L13:
        if (this.mSelectedIcon.mFileMd5.equals(this.mOldMd5) == true) goto L28;
        String r1 = this.mAsset.getPackageName();
        String r3 = this.mAsset.getResolveInfoIconResName(this.mIconManager);
        OLog.d(TAG, "setRedirectedIcon   pkg:" + r1 + " resName:" + r3 + " path:" + this.mSelectedIcon.mFilePath);
        this.mIconManager.setIconBlockedForPackage(r1, false);
        if (this.mIsPrimaryPkg == false) goto L17;
        this.mIconManager.setPrimaryIcon(r1, r3, this.mSelectedIcon.mFilePath);
        OLog.d(TAG, "setPrimaryIcon for " + r1 + " path:" + this.mSelectedIcon.mFilePath);
    L18:
        this.mOldMd5 = this.mSelectedIcon.mFileMd5;
        ApplicationsState r7 = ApplicationsState.getInstance(requireActivity().getApplication(), false);
        ApplicationsState.AppEntry r2 = r7.getEntryByUserId(r1, UserHandle.myUserId());
        if (r2 == null) goto L21;
        r2.setDirty(true);
    L21:
        ApplicationsState.AppEntry r8 = r7.getEntryByUserId(r1, 10);
        if (r8 == null) goto L29;
        r8.setDirty(true);
        return;
    L29:
        return;
    L17:
        this.mIconManager.setSecondaryIcon(r1, r3, this.mSelectedIcon.mFilePath);
        goto L18
    L28:
        return;
    L5:
        if (this.mIsPrimaryPkg == true) goto L25;
        String r4 = this.mAsset.getPackageName();
        String r5 = this.mAsset.getResolveInfoIconResName(this.mIconManager);
        OLog.d(TAG, "remove secondary icon:" + this.mIconManager.removeSecondaryIcon(r4, r5) + " pkg:" + r4 + " resName:" + r5);
        return;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r3) {
        IconEntry r4 = this.mIconEntries.get(((Integer) r3.getTag()).intValue());
        if (r4.mType != 0) goto L6;
        return;
    L6:
        if (r4.mFileMd5.equals(this.mSelectedIcon.mFileMd5) == true) goto L8;
        this.mSelectedIcon = r4;
    L12:
        OLog.d(TAG, "selected icon:" + this.mSelectedIcon);
        this.mAdapter.notifyDataSetChanged();
        setRedirectedIcon();
        return;
    L8:
        if (this.mIsPrimaryPkg == false) goto L10;
        return;
    L10:
        this.mSelectedIcon = this.mInvalidIconEntry;
        goto L12
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_CommonIconPickerFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(CommonIconPickerFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_CommonIconPickerFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_CommonIconPickerFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(CommonIconPickerFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_CommonIconPickerFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_CommonIconPickerFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(CommonIconPickerFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_CommonIconPickerFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
