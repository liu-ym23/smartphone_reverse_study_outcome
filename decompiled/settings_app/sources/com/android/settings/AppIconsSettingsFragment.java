package com.android.settings;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.IconManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.UserHandle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.settings.accounts.ManageAccountsSettingsActivity;
import com.android.settings.applications.ApplicationItemIconView;
import com.android.settings.applications.ApplicationLabelCache;
import com.android.settings.applications.ApplicationLabelUtils;
import com.android.settings.applications.ApplicationsState;
import com.android.settings.applications.LabelEntry;
import com.android.settings.base.BaseFragment;
import com.android.settings.stickylistheaders.StickyListHeadersAdapter;
import com.android.settings.stickylistheaders.StickyListHeadersListView;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.io.File;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.ListContentItemText;

/* JADX INFO: loaded from: classes2.dex */
public class AppIconsSettingsFragment extends BaseFragment implements View.OnClickListener, SimpleImageLoader.Callback {
    public static final String EXTRA_ASSET = "asset";
    public static final String EXTRA_IS_PRIMARY_PKG = "is_primary_pkg";
    public static final String EXTRA_REDIRECTED_PATH = "redirected_icon_path";
    public static final int PRIMARY_REDIRECTED = 1;
    public static final int SECONDARY_REDIRECTED = 2;
    private static final String TAG = "AppIconsSettingsFragment";
    public static final int UNREDIRECTED = 3;
    private StickyListHeadersListView listView;
    private ArrayList<Asset> mAssetList;
    private HashMap<Asset, Drawable> mCacheOfficial;
    private HashMap<Asset, Drawable> mCacheUnOfficial;
    private Set<String> mChangedPackages;
    private TextView mEmptyView;
    private View mFooterView;
    private Handler mHandler;
    private IconManager mIconManager;
    private IconSettingsAdapter mIconSettingsAdapter;
    private ImageDownloader mImageDownloader;
    private SimpleImageLoader mImageLoader;
    private PackageManager mPackageManager;
    private BroadcastReceiver mPackageReceiver;
    private int mPrimaryRedirectedCount;
    private ApplicationsState mState;
    private int mUnPrimaryRedirectedCount;

    static class Asset implements Parcelable, Comparable<Asset> {
        public static final Parcelable.Creator<Asset> CREATOR = null;
        Collator mCollator;
        String mLabel;
        LabelEntry mLabelEntry;
        String mRedirectedIconPath;
        int mRedirectedState;
        ResolveInfo mResolveInfo;
        boolean mShowOfficial;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        /* synthetic */ Asset(Parcel r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Asset r1) {
            return compareTo2(r1);
        }

        private Asset(Parcel r2) {
            this.mCollator = Collator.getInstance();
            this.mRedirectedState = r2.readInt();
            this.mResolveInfo = (ResolveInfo) ResolveInfo.CREATOR.createFromParcel(r2);
            if (r2.readInt() == 0) goto L5;
            boolean r3 = true;
        L6:
            this.mShowOfficial = r3;
            ensureLabel(SettingsApplication.getContext());
            ensureLabelEntry(SettingsApplication.getContext());
            return;
        L5:
            r3 = false;
            goto L6
        }

        public Asset(ResolveInfo r2, boolean r3) {
            this(r2, r3, 3);
        }

        public Asset(ResolveInfo r2, boolean r3, int r4) {
            this.mCollator = Collator.getInstance();
            this.mResolveInfo = r2;
            this.mShowOfficial = r3;
            this.mRedirectedState = r4;
            ensureLabel(SettingsApplication.getContext());
            ensureLabelEntry(SettingsApplication.getContext());
        }

        void ensureLabel(Context r3) {
            if (this.mLabel != null) goto L13;
            LabelEntry r0 = ApplicationLabelCache.getInstance().getLabelEntry(r3, getPackageName());
            if (r0 == null) goto L7;
            this.mLabel = r0.label;
            return;
        L7:
            CharSequence r4 = this.mResolveInfo.loadLabel(r3.getPackageManager());
            if (r4 != null) goto L10;
            String r5 = "";
        L11:
            this.mLabel = r5;
            return;
        L10:
            r5 = r4.toString();
            goto L11
        }

        public void ensureLabelEntry(Context r3) {
            LabelEntry r0 = ApplicationLabelCache.getInstance().getLabelEntry(r3, getPackageName());
            this.mLabelEntry = r0;
            if (r0 != null) goto L6;
            this.mLabelEntry = ApplicationLabelUtils.generatorLabelEntry(r3, getPackageName(), this.mLabel);
            return;
        }

        public String getResolveInfoIconResName(IconManager r5) {
            int r0 = this.mResolveInfo.getIconResource();
            Resources r6 = r5.getUndirectedResourcesForPackage(getPackageName());
            if (r6 != null) goto L11;
            OLog.e(AppIconsSettingsFragment.TAG, "res is null: " + getPackageName());
            return null;
        L11:
            return r6.getResourceEntryName(r0);
        L8:
            e = move-exception;
            OLog.e(AppIconsSettingsFragment.TAG, "can't find icon resource name for package: " + getPackageName() + " !, this should never happen", e);
            return null;
        }

        public void ensureRedirectedIconPath(IconManager r3) {
            String r4 = getResolveInfoIconResName(r3);
            if (r4 == null) goto L14;
            int r0 = this.mRedirectedState;
            if (r0 != 2) goto L8;
            File r5 = IconManager.getSecondaryFileByName(getPackageName(), r4);
        L11:
            if (r5 == null) goto L15;
            this.mRedirectedIconPath = r5.getAbsolutePath();
            return;
        L15:
            return;
        L8:
            if (r0 != 1) goto L10;
            r5 = IconManager.getPrimaryFileByName(getPackageName(), r4);
            goto L11
        L10:
            r5 = null;
            goto L11
        }

        public String getPackageName() {
            return this.mResolveInfo.activityInfo.packageName;
        }

        public String getActivity() {
            return this.mResolveInfo.activityInfo.name;
        }

        public String getAppName(PackageManager r1) {
            CharSequence r0 = this.mResolveInfo.loadLabel(r1);
            if (r0 != null) goto L6;
            return "";
        L6:
            return r0.toString();
        }

        public String getAppVersionName(PackageManager r3) {
            PackageInfo r4 = r3.getPackageInfo(getPackageName(), 8192);     // Catch: PackageManager.NameNotFoundException -> L6
            if (r4 == null) goto L12;
            return r4.versionName;
        L12:
            return null;
        L6:
            e = move-exception;
            OLog.d(AppIconsSettingsFragment.TAG, "package not found:" + getPackageName() + "\n" + e);
            return null;
        }

        public Drawable getOfficialIcon(IconManager r1) {
            return r1.getUnRedirectedIconForResolve(this.mResolveInfo);
        }

        public String getApkSourceDir() {
            return this.mResolveInfo.activityInfo.applicationInfo.publicSourceDir;
        }

        /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
        public int compareTo2(Asset r3) {
            if (r3 != null) goto L5;
            return 1;
        L5:
            int r0 = this.mRedirectedState;
            int r1 = r3.mRedirectedState;
            if (r0 != r1) goto L16;
            LabelEntry r2 = this.mLabelEntry;
            if (r2 == null) goto L14;
            if (r3.mLabelEntry == null) goto L14;
            return this.mCollator.compare(r2.labelPinyin, r3.mLabelEntry.labelPinyin);
        L14:
            return this.mCollator.compare(this.mLabel, r3.mLabel);
        L16:
            return r0 - r1;
        }

        public String toString() {
            return "Asset{mRedirectedIconPath='" + this.mRedirectedIconPath + "', mRedirectedState=" + this.mRedirectedState + ", mResolveInfo=" + this.mResolveInfo + ", mShowOfficial=" + this.mShowOfficial + '}';
        }

        static {
            CREATOR = new AnonymousClass1();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r2, int r3) {
            r2.writeInt(this.mRedirectedState);
            this.mResolveInfo.writeToParcel(r2, r3);
            r2.writeInt(this.mShowOfficial ? 1 : 0);
        }
    }

    class IconSettingsAdapter extends BaseAdapter implements StickyListHeadersAdapter {
        private LayoutInflater mInflater;
        final /* synthetic */ AppIconsSettingsFragment this$0;

        class HeaderViewHolder {
            TextView headerText;
            View shadowDiv;
            final /* synthetic */ IconSettingsAdapter this$1;

            HeaderViewHolder(IconSettingsAdapter r1) {
                this.this$1 = r1;
            }
        }

        class ViewHolder {
            TextView appName;
            ImageView arrow;
            TextView authorName;
            View itemShadow;
            ListContentItemText layout;
            ApplicationItemIconView officialApplicationItemIconView;
            final /* synthetic */ IconSettingsAdapter this$1;
            ApplicationItemIconView unofficialApplicationItemIconView;

            ViewHolder(IconSettingsAdapter r1) {
                this.this$1 = r1;
            }
        }

        @Override // android.widget.Adapter
        public long getItemId(int r1) {
            return r1;
        }

        public IconSettingsAdapter(AppIconsSettingsFragment r1, Context r2) {
            this.this$0 = r1;
            this.mInflater = LayoutInflater.from(r2);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return AppIconsSettingsFragment.access$000(this.this$0).size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int r1) {
            return AppIconsSettingsFragment.access$000(this.this$0).get(r1);
        }

        @Override // android.widget.Adapter
        public View getView(int r10, View r11, ViewGroup r12) {
            if (r11 != null) goto L4;
            r11 = this.mInflater.inflate(R.layout.app_icon_settings_item_layout, null);
            ViewHolder r13 = new ViewHolder(this);
            r13.layout = (ListContentItemText) r11.findViewById(R.id.icon_chooser_layout);
            r13.officialApplicationItemIconView = (ApplicationItemIconView) r11.findViewById(R.id.official_icon_layout);
            r13.unofficialApplicationItemIconView = (ApplicationItemIconView) r11.findViewById(R.id.unofficial_icon_layout);
            r13.appName = (TextView) r11.findViewById(R.id.app_name);
            r13.authorName = (TextView) r11.findViewById(R.id.icon_author_name);
            r13.arrow = (ImageView) r11.findViewById(R.id.arrow);
            r13.itemShadow = r11.findViewById(R.id.item_shadow_layout);
            r11.setTag(r13);
        L5:
            Resources r0 = this.this$0.getResources();
            int r2 = r0.getDimensionPixelSize(R.dimen.icon_layout_padding_default);
            int r1 = r0.getDimensionPixelSize(R.dimen.icon_layout_padding_default);
            int r3 = r0.getDimensionPixelSize(R.dimen.icon_layout_padding_for_top_bottom_item);
            if (r10 >= AppIconsSettingsFragment.access$1000(this.this$0)) goto L15;
            if (AppIconsSettingsFragment.access$1000(this.this$0) <= 1) goto L23;
            if (r10 != 0) goto L12;
        L18:
            r2 = r3;
            int r4 = 2;
        L24:
            r13.layout.setBackgroundStyle(r4);
            r13.layout.setImportantForAccessibility(2);
            r13.layout.setArrowVisible(false);
            r13.officialApplicationItemIconView.setPadding(0, r2, 0, r1);
            r13.unofficialApplicationItemIconView.setPadding(0, r2, 0, r1);
            Asset r5 = (Asset) getItem(r10);
            if (r5.mShowOfficial == false) goto L33;
            r13.officialApplicationItemIconView.setVisible(true);
            r13.unofficialApplicationItemIconView.setVisible(false);
            int r6 = r5.mRedirectedState;
            if (r6 == 1) goto L32;
            if (r6 == 2) goto L31;
            if (r6 == 3) goto L31;
        L40:
            if (r4 == 4) goto L44;
            if (r4 == 1) goto L44;
            r13.itemShadow.setVisibility(8);
        L45:
            r13.officialApplicationItemIconView.setIcon((Drawable) AppIconsSettingsFragment.access$100(this.this$0).get(r5));
            if (r5.mRedirectedState != 1) goto L48;
            r13.unofficialApplicationItemIconView.setIcon((Drawable) AppIconsSettingsFragment.access$200(this.this$0).get(r5));
            r13.unofficialApplicationItemIconView.setBg(R.drawable.icon_frame_background);
        L52:
            r13.officialApplicationItemIconView.setContentDescription(r5.getAppName(AppIconsSettingsFragment.access$1300(this.this$0)));
            r13.unofficialApplicationItemIconView.setContentDescription(this.this$0.mContext.getString(R.string.unofficial_icon));
            r13.officialApplicationItemIconView.setTag(Integer.valueOf(r10));
            r13.unofficialApplicationItemIconView.setTag(Integer.valueOf(r10));
            r13.officialApplicationItemIconView.setOnClickListener(this.this$0);
            r13.unofficialApplicationItemIconView.setOnClickListener(this.this$0);
            r13.appName.setText(r5.getAppName(AppIconsSettingsFragment.access$1300(this.this$0)));
            return r11;
        L48:
            AppIconsSettingsFragment.access$1200(this.this$0).download(r5.mRedirectedIconPath, r13.unofficialApplicationItemIconView.getIcon());
            if (TextUtils.isEmpty(r5.mRedirectedIconPath) == false) goto L51;
            r13.unofficialApplicationItemIconView.setBg(R.drawable.add_icon);
            goto L52
        L51:
            r13.unofficialApplicationItemIconView.setBg(R.drawable.icon_frame_background);
        L44:
            r13.itemShadow.setVisibility(0);
        L31:
            r13.authorName.setText(R.string.icon_picker_common_icon_replacable);
            goto L40
        L32:
            r13.authorName.setText(R.string.official_icon);
            goto L40
        L33:
            r13.officialApplicationItemIconView.setVisible(false);
            r13.unofficialApplicationItemIconView.setVisible(true);
            int r7 = r5.mRedirectedState;
            if (r7 == 1) goto L39;
            if (r7 == 2) goto L38;
            if (r7 != 3) goto L40;
        L38:
            r13.authorName.setText(R.string.icon_picker_common_icon_replaced);
            goto L40
        L39:
            r13.authorName.setText(R.string.unofficial_icon);
            goto L40
        L12:
            if (r10 == (AppIconsSettingsFragment.access$1000(this.this$0) - 1)) goto L21;
        L22:
            r4 = 3;
        L21:
            r1 = r3;
            r4 = 4;
        L23:
            r1 = r3;
            r2 = r1;
            r4 = 1;
            goto L24
        L15:
            if (AppIconsSettingsFragment.access$1100(this.this$0) <= 1) goto L23;
            if (r10 == AppIconsSettingsFragment.access$1000(this.this$0)) goto L18;
            if (r10 != (getCount() - 1)) goto L22;
        L4:
            r13 = (ViewHolder) r11.getTag();
            goto L5
        }

        @Override // com.android.settings.stickylistheaders.StickyListHeadersAdapter
        public View getHeaderView(int r3, View r4, ViewGroup r5) {
            if (r4 != null) goto L4;
        L7:
            HeaderViewHolder r6 = new HeaderViewHolder(this);
            r4 = this.mInflater.inflate(R.layout.icon_settings_sticky_list_header_view, null);
            r6.headerText = (TextView) r4.findViewById(R.id.sticky_header);
            r6.shadowDiv = r4.findViewById(R.id.shadow);
            r4.setTag(r6);
        L8:
            int r0 = 0;
            boolean r1 = true;
            if (((Asset) AppIconsSettingsFragment.access$000(this.this$0).get(r3)).mRedirectedState == 1) goto L12;
            r1 = false;
        L12:
            if (r1 == false) goto L14;
            String r2 = this.this$0.getString(R.string.icon_picker_redesigned_icons);
        L15:
            r6.headerText.setText(r2);
            View r7 = r6.shadowDiv;
            if (r1 == false) goto L18;
            r0 = 8;
        L18:
            r7.setVisibility(r0);
            return r4;
        L14:
            r2 = this.this$0.getString(R.string.icon_picker_unredesigned_icons);
            goto L15
        L4:
            if ((r4.getTag() instanceof HeaderViewHolder) == false) goto L7;
            r6 = (HeaderViewHolder) r4.getTag();
            goto L8
        }

        @Override // com.android.settings.stickylistheaders.StickyListHeadersAdapter
        public long getHeaderId(int r1) {
            if (((Asset) AppIconsSettingsFragment.access$000(this.this$0).get(r1)).mRedirectedState != 1) goto L5;
            return 1;
        L5:
            return 0;
        }
    }

    public void com_android_settings_AppIconsSettingsFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_AppIconsSettingsFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_AppIconsSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.SimpleImageLoader.Callback
    public void onLoadFailed() {
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_AppIconsSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public AppIconsSettingsFragment() {
        this.mAssetList = new ArrayList();
        this.mCacheOfficial = new HashMap();
        this.mCacheUnOfficial = new HashMap();
        this.mChangedPackages = new HashSet();
        this.mHandler = new AnonymousClass1(this);
        this.mPackageReceiver = new AnonymousClass4(this);
    }

    static /* synthetic */ ArrayList access$000(AppIconsSettingsFragment r0) {
        return r0.mAssetList;
    }

    static /* synthetic */ ArrayList access$002(AppIconsSettingsFragment r0, ArrayList r1) {
        r0.mAssetList = r1;
        return r1;
    }

    static /* synthetic */ HashMap access$100(AppIconsSettingsFragment r0) {
        return r0.mCacheOfficial;
    }

    static /* synthetic */ int access$1000(AppIconsSettingsFragment r0) {
        return r0.mPrimaryRedirectedCount;
    }

    static /* synthetic */ int access$1100(AppIconsSettingsFragment r0) {
        return r0.mUnPrimaryRedirectedCount;
    }

    static /* synthetic */ ImageDownloader access$1200(AppIconsSettingsFragment r0) {
        return r0.mImageDownloader;
    }

    static /* synthetic */ PackageManager access$1300(AppIconsSettingsFragment r0) {
        return r0.mPackageManager;
    }

    static /* synthetic */ HashMap access$200(AppIconsSettingsFragment r0) {
        return r0.mCacheUnOfficial;
    }

    static /* synthetic */ IconSettingsAdapter access$300(AppIconsSettingsFragment r0) {
        return r0.mIconSettingsAdapter;
    }

    static /* synthetic */ ArrayList access$400(AppIconsSettingsFragment r0) {
        return r0.initApplicationList();
    }

    static /* synthetic */ void access$500(AppIconsSettingsFragment r0, boolean r1) {
        r0.updateEmptyView(r1);
    }

    static /* synthetic */ void access$600(AppIconsSettingsFragment r0) {
        r0.setFooterView();
    }

    static /* synthetic */ void access$700(AppIconsSettingsFragment r0) {
        r0.initImageLoaderAndStartLoad();
    }

    static /* synthetic */ void access$800(AppIconsSettingsFragment r0, Asset r1) {
        r0.pickIconForAsset(r1);
    }

    static /* synthetic */ void access$900(AppIconsSettingsFragment r0, String r1) {
        r0.updatePackage(r1);
    }

    /* JADX WARN: Type inference failed for: r2v8, types: [com.android.settings.AppIconsSettingsFragment$2] */
    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        this.mRootView = r2.inflate(R.layout.app_icon_settings_layout, r3, false);
        this.mTitleResId = Integer.valueOf(R.string.icon_setting_text);
        this.mIconManager = (IconManager) getSystemService("icon");
        this.mPackageManager = getPackageManager();
        new AnonymousClass2(this).execute(new Void[0]);
        this.listView = (StickyListHeadersListView) findViewByIdNullable(R.id.icons_list_view);
        this.mEmptyView = (TextView) findViewByIdNullable(R.id.empty_view);
        updateEmptyView(true);
        this.listView.setEmptyView(this.mEmptyView);
        this.listView.addHeaderView(Utils.inflateListTransparentHeader(this._mActivity, null, false));
        IconSettingsAdapter r5 = new IconSettingsAdapter(this, this._mActivity);
        this.mIconSettingsAdapter = r5;
        this.listView.setAdapter(r5);
        this.listView.setAreHeadersSticky(false);
        this.listView.setOnItemClickListener(new AnonymousClass3(this));
        registerPackageReceiver();
        this.mState = ApplicationsState.getInstance(getApplication(), false);
        this.mImageDownloader = ImageDownloader.getInstance(getApplicationContext());
        return this.mRootView;
    }

    private void pickIconForAsset(Asset r5) {
        CommonIconPickerFragment r0 = new CommonIconPickerFragment();
        Bundle r1 = new Bundle();
        r1.putParcelable(EXTRA_ASSET, r5);
        r1.putString(EXTRA_REDIRECTED_PATH, r5.mRedirectedIconPath);
        boolean r2 = true;
        if (r5.mRedirectedState == 1) goto L6;
        r2 = false;
    L6:
        r1.putBoolean(EXTRA_IS_PRIMARY_PKG, r2);
        r0.setArguments(r1);
        start(r0);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.mCacheOfficial.clear();
        this.mCacheUnOfficial.clear();
        super.onDestroyView();
        unregisterPackageReceiver();
    }

    private void initImageLoaderAndStartLoad() {
        SimpleImageLoader r0 = new SimpleImageLoader(this._mActivity, 0, this);
        this.mImageLoader = r0;
        r0.setAssetList(this.mAssetList);
        this.mImageLoader.setHandler(this.mHandler);
        this.mImageLoader.execute(new HashMap[]{this.mCacheOfficial, this.mCacheUnOfficial});
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.mChangedPackages.isEmpty() == true) goto L20;
        this.mIconManager.persistentIconBlockingInfo();
        this.mIconManager.notifyIconUpdate(this.mChangedPackages);
        Iterator<String> r0 = this.mChangedPackages.iterator();
    L6:
        if (r0.hasNext() == false) goto L13;
        String r1 = r0.next();
        ApplicationsState.AppEntry r2 = this.mState.getEntryByUserId(r1, UserHandle.myUserId());
        if (r2 == null) goto L10;
        r2.setDirty(true);
    L10:
        ApplicationsState.AppEntry r3 = this.mState.getEntryByUserId(r1, 10);
        if (r3 == null) goto L6;
        r3.setDirty(true);
        goto L6
    L13:
        this.mChangedPackages.clear();
        return;
    }

    private void updateEmptyView(boolean r3) {
        if (r3 == false) goto L5;
        this.mEmptyView.setText(R.string.application_manager_empty_view_text);
        this.mEmptyView.setTextColor(getResources().getColor(R.color.setting_item_tips_color));
        this.mEmptyView.setTextAppearance(this.mContext, R.style.SettingItemTextShadowStyle);
        this.mEmptyView.setTextSize(2, 15.0f);
        return;
    L5:
        if (this.mAssetList.isEmpty() == false) goto L9;
        this.mEmptyView.setText(R.string.icon_setting_empty_tip);
        this.mEmptyView.setTextColor(getResources().getColor(R.color.list_empty_view_text_color));
        this.mEmptyView.setTextAppearance(this.mContext, android.R.style.TextAppearance.Medium);
        return;
    }

    private void registerPackageReceiver() {
        IntentFilter r0 = new IntentFilter();
        r0.addAction("android.intent.action.PACKAGE_ADDED");
        r0.addAction("android.intent.action.PACKAGE_REMOVED");
        r0.addDataScheme("package");
        registerReceiver(this.mPackageReceiver, r0);
        IntentFilter r1 = new IntentFilter();
        r1.addAction("com.bytedanceos.launcher.update_icon");
        registerReceiver(this.mPackageReceiver, r1);
    }

    private void unregisterPackageReceiver() {
        unregisterReceiver(this.mPackageReceiver);
    }

    private int getOriginalIndexInAssetList(ArrayList<Asset> r7, ArrayList<Integer> r8, Asset r9) {
        int r6 = -1;
        if (r9 == null) goto L22;
        if (r7 == null) goto L22;
        if (r7.size() <= 0) goto L22;
        int r0 = 0;
        int r1 = -1;
    L9:
        if (r0 >= r7.size()) goto L23;
        Asset r2 = r7.get(r0);
        if (r9.getActivity().equals(r2.getActivity()) == false) goto L21;
        if (r9.mRedirectedState != 1) goto L17;
        if (r9.mRedirectedState != r2.mRedirectedState) goto L17;
    L20:
        r1 = r0;
    L17:
        if (r2.mRedirectedState == 1) goto L21;
        if (r9.mRedirectedState != 1) goto L20;
    L21:
        r0 = r0 + 1;
    L23:
        OLog.d(TAG, "indexInRemovedList:" + r1 + " asset:" + r9);
        if (r1 == (-1)) goto L26;
        r6 = r8.get(r1).intValue();
    L26:
        OLog.d(TAG, "originalIndexInAssetList:" + r6);
        return r6;
    L22:
        r1 = -1;
        goto L23
    }

    private void updatePackage(String r12) {
        if (shouldIgnore(r12, 0) == false) goto L5;
        return;
    L5:
        if (this.mAssetList.isEmpty() == true) goto L88;
        ArrayList<Integer> r1 = getPackageIndexInDataList(r12);
        ArrayList<Asset> r2 = removePackageInDataList(r12);
        OLog.d(TAG, "pkg:" + r12 + " removedAsset:" + r2 + " index:" + r1);
        Iterator<Asset> r3 = r2.iterator();
    L8:
        boolean r6 = true;
        if (r3.hasNext() == false) goto L63;
        Asset r5 = r3.next();
        if (r5 == null) goto L8;
        if (r5.mRedirectedState == 1) goto L14;
        int r7 = this.mUnPrimaryRedirectedCount - 1;
        this.mUnPrimaryRedirectedCount = r7;
        if (r7 != 0) goto L8;
        setFooterView();
        goto L8
    L14:
        this.mPrimaryRedirectedCount--;
        goto L8
    L63:
        ApplicationInfo r4 = this.mPackageManager.getApplicationInfo(r12, 8192);     // Catch: PackageManager.NameNotFoundException -> L20
    L21:
        if (r4 != null) goto L23;
        this.mChangedPackages.remove(r12);
    L59:
        if (r6 == false) goto L61;
        Collections.sort(this.mAssetList);
    L61:
        this.mIconSettingsAdapter.notifyDataSetChanged();
        updateEmptyView(false);
        return;
    L23:
        List r13 = this.mIconManager.getIconRedirectedPrimarilyResolvesForPackage(r4);
        OLog.d(TAG, "size:" + r13.size());
        if (r13 == null) goto L33;
        Iterator r14 = r13.iterator();
        boolean r8 = true;
    L27:
        if (r14.hasNext() == false) goto L34;
        Asset r9 = getAssetForResolveInfo((ResolveInfo) r14.next(), 1);
        r9.ensureRedirectedIconPath(this.mIconManager);
        this.mCacheUnOfficial.put(r9, loadUnOfficialIcon(r9));
        this.mCacheOfficial.put(r9, loadOfficialIcon(r9));
        int r10 = getOriginalIndexInAssetList(r2, r1, r9);
        if (r10 < 0) goto L31;
        this.mAssetList.add(r10, r9);
        r8 = false;
    L32:
        this.mPrimaryRedirectedCount++;
        goto L27
    L31:
        this.mAssetList.add(this.mPrimaryRedirectedCount, r9);
    L34:
        List r15 = this.mIconManager.getIconRedirectedSecondarilyResolvesForPackage(r4);
        if (r15 == null) goto L46;
        Iterator r16 = r15.iterator();
    L38:
        if (r16.hasNext() == false) goto L46;
        Asset r11 = getAssetForResolveInfo((ResolveInfo) r16.next(), 2);
        r11.ensureRedirectedIconPath(this.mIconManager);
        this.mCacheOfficial.put(r11, loadOfficialIcon(r11));
        this.mImageDownloader.removeBitmapFromCache(r11.mRedirectedIconPath);
        this.mImageDownloader.updateBitmap(r11.mRedirectedIconPath);
        int r17 = getOriginalIndexInAssetList(r2, r1, r11);
        if (r17 < 0) goto L42;
        this.mAssetList.add(r17, r11);
        r8 = false;
    L43:
        int r18 = this.mUnPrimaryRedirectedCount + 1;
        this.mUnPrimaryRedirectedCount = r18;
        if (r18 != 1) goto L38;
        setFooterView();
        goto L38
    L42:
        this.mAssetList.add(this.mPrimaryRedirectedCount + 1, r11);
    L46:
        List r19 = this.mIconManager.getIconUnRedirectedResolvesForPackage(r4);
        if (r19 == null) goto L58;
        OLog.d(TAG, "size:" + r19.size());
        Iterator r110 = r19.iterator();
    L50:
        if (r110.hasNext() == false) goto L58;
        Asset r20 = getAssetForResolveInfo((ResolveInfo) r110.next(), 3);
        this.mCacheOfficial.put(r20, loadOfficialIcon(r20));
        int r21 = getOriginalIndexInAssetList(r2, r1, r20);
        if (r21 < 0) goto L54;
        this.mAssetList.add(r21, r20);
        r8 = false;
    L55:
        int r22 = this.mUnPrimaryRedirectedCount + 1;
        this.mUnPrimaryRedirectedCount = r22;
        if (r22 != 1) goto L50;
        setFooterView();
        goto L50
    L54:
        ArrayList<Asset> r23 = this.mAssetList;
        r23.add(r23.size(), r20);
    L58:
        r6 = r8;
        goto L59
    L33:
        r8 = true;
    L20:
        r4 = null;
        goto L21
    }

    private boolean isPackageBlocked(String r1) {
        return this.mIconManager.isIconBlockedForPackage(r1);
    }

    private Asset getAssetForResolveInfo(ResolveInfo r3, int r4) {
        boolean r2 = isPackageBlocked(r3.activityInfo.packageName);
        if (r4 != 3) goto L6;
        r2 = true;
    L6:
        return new Asset(r3, r2, r4);
    }

    private ArrayList<Asset> initApplicationList() {
        ArrayList<Asset> r0 = new ArrayList();
        Iterator r1 = this.mIconManager.getIconPrimarilyRedirectedResolveInfo().iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        ResolveInfo r2 = (ResolveInfo) r1.next();
        if (shouldIgnore(r2.activityInfo.packageName, r2.activityInfo.applicationInfo.uid) == true) goto L4;
        Asset r5 = new Asset(r2, isPackageBlocked(r2.activityInfo.packageName), 1);
        r5.ensureRedirectedIconPath(this.mIconManager);
        r0.add(r5);
        goto L4
    L9:
        this.mPrimaryRedirectedCount = r0.size();
        Iterator r3 = this.mIconManager.getIconSecondarilyRedirectedResolveInfo().iterator();
    L11:
        if (r3.hasNext() == false) goto L16;
        ResolveInfo r4 = (ResolveInfo) r3.next();
        if (shouldIgnore(r4.activityInfo.packageName, r4.activityInfo.applicationInfo.uid) == true) goto L11;
        Asset r6 = new Asset(r4, isPackageBlocked(r4.activityInfo.packageName), 2);
        r6.ensureRedirectedIconPath(this.mIconManager);
        r0.add(r6);
        goto L11
    L16:
        Iterator r7 = this.mIconManager.getIconUnRedirectedResolveInfo().iterator();
    L18:
        if (r7.hasNext() == false) goto L23;
        ResolveInfo r8 = (ResolveInfo) r7.next();
        if (shouldIgnore(r8.activityInfo.packageName, r8.activityInfo.applicationInfo.uid) == true) goto L18;
        r0.add(new Asset(r8, true, 3));
        goto L18
    L23:
        this.mUnPrimaryRedirectedCount = r0.size() - this.mPrimaryRedirectedCount;
        Collections.sort(r0);
        return r0;
    }

    private boolean shouldIgnore(String r5, int r6) {
        if (r5 != null) goto L5;
        return true;
    L5:
        if (r6 <= 0) goto L7;
        int r7 = UserHandle.myUserId();
    L8:
        boolean r1 = Utils.isPackageInstalledAndIsSystemApp(this.mContext, r5);
        if (r5.contains("com.google") == false) goto L11;
    L14:
        boolean r2 = true;
    L15:
        if (r1 == false) goto L18;
        if (r2 == true) goto L18;
        return true;
    L18:
        if (r5.startsWith(ManageAccountsSettingsActivity.BYTEDANCE_ACCOUNT_TYPE) == false) goto L20;
        return true;
    L20:
        if (Utils.isPackageLocked(this.mContext.getPackageManager(), r5, r7) == false) goto L22;
        return true;
    L22:
        if (r5.equals(Constants.PKG_BULLET_SMS) == false) goto L24;
        return true;
    L24:
        if (r5.equals("com.lbt.gms") == false) goto L26;
        return true;
    L26:
        if (r5.equals("com.google.android.gms") == false) goto L29;
        return true;
    L29:
        return false;
    L11:
        if (r5.equals("com.android.vending") == true) goto L14;
        r2 = false;
        goto L15
    L7:
        r7 = UserHandle.getUserId(r6);
        goto L8
    }

    private void setFooterView() {
        if (this.listView.getFooterViewsCount() <= 0) goto L8;
        View r0 = this.mFooterView;
        if (r0 == null) goto L8;
        this.listView.removeFooterView(r0);
    L8:
        if (this.mUnPrimaryRedirectedCount <= 0) goto L10;
        View r1 = LayoutInflater.from(this._mActivity).inflate(R.layout.tips_layout, null);
        this.mFooterView = r1;
        r1.findViewById(R.id.item_shadow).setVisibility(8);
        TextView r2 = (TextView) this.mFooterView.findViewById(R.id.tips);
        r2.setText(R.string.icon_picker_common_icon_settings_tips);
        int r3 = getResources().getDimensionPixelSize(R.dimen.settings_item_tips_margin_bottom);
        View r4 = this.mFooterView;
        r4.setPadding(r4.getPaddingLeft(), 0, this.mFooterView.getPaddingRight(), r3);
        RelativeLayout.LayoutParams r5 = (RelativeLayout.LayoutParams) r2.getLayoutParams();
        r5.topMargin = -getResources().getDimensionPixelSize(R.dimen.app_icon_tip_margin_top);
        r2.setLayoutParams(r5);
    L11:
        this.listView.addFooterView(this.mFooterView);
        return;
    L10:
        this.mFooterView = Utils.inflateListTransparentHeader(this._mActivity, null, false);
        goto L11
    }

    private ArrayList<Asset> removePackageInDataList(String r4) {
        ArrayList<Asset> r0 = new ArrayList();
        Iterator<Asset> r3 = this.mAssetList.iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        Asset r1 = r3.next();
        if (r1.getPackageName().equals(r4) == false) goto L4;
        r3.remove();
        r0.add(r1);
        goto L4
    L8:
        r0.trimToSize();
        OLog.d(TAG, "result asset:" + r0);
        return r0;
    }

    private ArrayList<Integer> getPackageIndexInDataList(String r4) {
        ArrayList<Integer> r0 = new ArrayList();
        int r1 = 0;
    L4:
        if (r1 >= this.mAssetList.size()) goto L9;
        if (this.mAssetList.get(r1).getPackageName().equals(r4) == false) goto L8;
        r0.add(Integer.valueOf(r1));
    L8:
        r1 = r1 + 1;
        goto L4
    L9:
        r0.trimToSize();
        OLog.d(TAG, "result index:" + r0);
        return r0;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r6) {
        int r0 = r6.getId();
        if (r0 != R.id.official_icon_layout) goto L5;
    L7:
        int r1 = ((Integer) r6.getTag()).intValue();
        if (r6.getId() != R.id.official_icon_layout) goto L10;
        boolean r7 = true;
    L11:
        Asset r2 = this.mAssetList.get(r1);
        if (r2.mRedirectedState != 3) goto L16;
        pickIconForAsset(r2);
        return;
    L16:
        if (r2.mShowOfficial == r7) goto L23;
        if (this.mChangedPackages.contains(r2.getPackageName()) == false) goto L20;
        this.mChangedPackages.remove(r2.getPackageName());
    L21:
        r2.mShowOfficial = r7;
        this.mIconManager.setIconBlockedForPackage(r2.getPackageName(), r7);
        this.mIconSettingsAdapter.notifyDataSetChanged();
        goto L23
    L20:
        this.mChangedPackages.add(r2.getPackageName());
    L23:
        if (Utils.isDesktop(this._mActivity) == false) goto L26;
        this.mIconManager.persistentIconBlockingInfo();
        this.mIconManager.notifyIconUpdate(Arrays.asList(new String[]{r2.getPackageName()}));
        return;
    L26:
        return;
    L10:
        r7 = false;
        goto L11
    L5:
        if (r0 == R.id.unofficial_icon_layout) goto L7;
    }

    public static Drawable loadUnOfficialIcon(Asset r2) {
        return ((IconManager) SettingsApplication.getContext().getSystemService("icon")).getRedirectedIconForResolve(r2.mResolveInfo);
    }

    public static Drawable loadOfficialIcon(Asset r2) {
        return ((IconManager) SettingsApplication.getContext().getSystemService("icon")).getUnRedirectedIconForResolve(r2.mResolveInfo);
    }

    @Override // com.android.settings.SimpleImageLoader.Callback
    public void onLoadFinished() {
        this.mIconSettingsAdapter.notifyDataSetChanged();
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_AppIconsSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(AppIconsSettingsFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_AppIconsSettingsFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_AppIconsSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(AppIconsSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_AppIconsSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_AppIconsSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(AppIconsSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_AppIconsSettingsFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
