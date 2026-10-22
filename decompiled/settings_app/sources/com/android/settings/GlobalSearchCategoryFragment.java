package com.android.settings;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SectionIndexer;
import android.widget.TextView;
import bytedanceos.app.settings.search.GloableSearchConfig;
import bytedanceos.app.settings.search.SearchConfigType;
import bytedanceos.app.settings.search.SearchConfigTypeData;
import com.android.settings.base.BaseFragment;
import com.android.settings.gloableconfig.GloableSearchConfigTool;
import com.android.settings.stickylistheaders.StickyListHeadersAdapter;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.widget.SettingsBottomExtraView;
import com.obric.olog.OLog;
import com.obric.oui.lisitem.OListItemSettings;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: loaded from: classes2.dex */
public class GlobalSearchCategoryFragment extends BaseFragment {
    private static int LANGUAGE_CN = 1;
    private static int LANGUAGE_OTHER = 0;
    private static int LANGUAGE_TW = 2;
    private static final Map<String, Integer> mIconMap = null;
    private static final Map<String, Integer> mSectionMap = null;
    private OptionsAdapter mAdapter;
    private List<BigBangItem> mBigBangItemList;
    private int mIconWidth;
    private ListView mOptionsList;
    private Map<String, String> mUserSet;

    private class BigBangItem {
        public int category;
        public String categoryName;
        public int icon;
        public Drawable iconDrawable;
        public String imgUrl;
        public String settingsValue;
        final /* synthetic */ GlobalSearchCategoryFragment this$0;
        public String title;

        private BigBangItem(GlobalSearchCategoryFragment r1) {
            this.this$0 = r1;
        }

        /* synthetic */ BigBangItem(GlobalSearchCategoryFragment r1, AnonymousClass1 r2) {
            this(r1);
        }
    }

    class OptionsAdapter extends BaseAdapter implements StickyListHeadersAdapter, SectionIndexer {
        private LayoutInflater mLayoutInflater;
        final /* synthetic */ GlobalSearchCategoryFragment this$0;

        @Override // android.widget.Adapter
        public long getItemId(int r1) {
            return r1;
        }

        @Override // android.widget.SectionIndexer
        public Object[] getSections() {
            return null;
        }

        @Override // android.widget.Adapter
        public /* bridge */ /* synthetic */ Object getItem(int r1) {
            return getItem(r1);
        }

        public OptionsAdapter(GlobalSearchCategoryFragment r1, Context r2) {
            this.this$0 = r1;
            this.mLayoutInflater = LayoutInflater.from(r2);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return GlobalSearchCategoryFragment.access$200(this.this$0).size();
        }

        @Override // android.widget.Adapter
        public BigBangItem getItem(int r1) {
            return (BigBangItem) GlobalSearchCategoryFragment.access$200(this.this$0).get(r1);
        }

        @Override // android.widget.Adapter
        public View getView(int r7, View r8, ViewGroup r9) {
            if (r8 != null) goto L5;
            r8 = this.mLayoutInflater.inflate(R.layout.list_content_item_check_oui_with_icon, r9, false);
            OListItemSettings r10 = (OListItemSettings) r8.findViewById(R.id.item_check);
            r8.setTag(r10);
        L6:
            BigBangItem r1 = (BigBangItem) GlobalSearchCategoryFragment.access$200(this.this$0).get(r7);
            r10.setTitleString(r1.title);
            r10.contentImgBackground.setVisibility(4);
            if (r1.iconDrawable == null) goto L9;
            r10.mIvContent.setImageDrawable(r1.iconDrawable);
        L10:
            ImageView r2 = new ImageView(this.this$0.mContext);
            r2.setImageResource(R.drawable.icon_check_confirm_rounded);
            if (TextUtils.equals((CharSequence) GlobalSearchCategoryFragment.access$400(this.this$0).get(r1.categoryName), r1.settingsValue) == false) goto L13;
            r10.setTrailingView(r2);
            r10.mTrailingElement.setVisibility(0);
        L14:
            TextView r11 = (TextView) r8.findViewById(R.id.section);
            if (isFirstOfSection(r7) == false) goto L17;
            r11.setText(((Integer) GlobalSearchCategoryFragment.access$700().get(r1.categoryName)).intValue());
            r11.setVisibility(0);
        L19:
            if (isFirstOfSection(r7) == false) goto L24;
            if (isLastOfSection(r7) == false) goto L24;
            int r6 = this.this$0.getResources().getDimensionPixelSize(R.dimen.preference_list_padding);
        L27:
            r8.setPadding(0, 0, 0, r6);
            return r8;
        L24:
            if (isLastOfSection(r7) == false) goto L26;
            r6 = this.this$0.getResources().getDimensionPixelSize(R.dimen.preference_list_padding);
            goto L27
        L26:
            r6 = 0;
            goto L27
        L17:
            r11.setVisibility(8);
            goto L19
        L13:
            r10.mTrailingElement.setVisibility(4);
            goto L14
        L9:
            r10.mIvContent.setImageResource(r1.icon);
            goto L10
        L5:
            r10 = (OListItemSettings) r8.getTag();
            goto L6
        }

        private boolean isFirstOfSection(int r2) {
            if (r2 != getPositionForSection(getSectionForPosition(r2))) goto L5;
            return true;
        L5:
            return false;
        }

        private boolean isLastOfSection(int r3) {
            int r0 = getPositionForSection(getSectionForPosition(r3) + 1);
            int r4 = r3 + 1;
            if (r4 != r0) goto L5;
            return true;
        L5:
            if (r4 == getCount()) goto L10;
            return false;
        L10:
            return true;
        }

        @Override // android.widget.SectionIndexer
        public int getPositionForSection(int r4) {
            int r1 = 0;
        L4:
            if (r1 >= GlobalSearchCategoryFragment.access$200(this.this$0).size()) goto L9;
            if (((BigBangItem) GlobalSearchCategoryFragment.access$200(this.this$0).get(r1)).category == r4) goto L7;
            r1 = r1 + 1;
            goto L4
        L7:
            return r1;
        L9:
            return 0;
        }

        @Override // android.widget.SectionIndexer
        public int getSectionForPosition(int r1) {
            return ((BigBangItem) GlobalSearchCategoryFragment.access$200(this.this$0).get(r1)).category;
        }

        @Override // com.android.settings.stickylistheaders.StickyListHeadersAdapter
        public View getHeaderView(int r2, View r3, ViewGroup r4) {
            if (r3 != null) goto L4;
        L5:
            r3 = this.mLayoutInflater.inflate(R.layout.header_text_layout, null);
            r3.setTag((TextView) r3.findViewById(R.id.header_text));
        L6:
            TextView r5 = (TextView) r3.getTag();
            getSectionForPosition(r2);
            r5.setText(0);
            return r3;
        L4:
            if (r3.getTag() != null) goto L6;
            goto L5
        }

        @Override // com.android.settings.stickylistheaders.StickyListHeadersAdapter
        public long getHeaderId(int r1) {
            return ((BigBangItem) GlobalSearchCategoryFragment.access$200(this.this$0).get(r1)).category;
        }
    }

    public void com_android_settings_GlobalSearchCategoryFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_GlobalSearchCategoryFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_GlobalSearchCategoryFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public GlobalSearchCategoryFragment() {
        this.mBigBangItemList = new ArrayList();
        this.mUserSet = new HashMap();
    }

    static /* synthetic */ ListView access$000(GlobalSearchCategoryFragment r0) {
        return r0.mOptionsList;
    }

    static /* synthetic */ String access$100(GlobalSearchCategoryFragment r0) {
        return r0.TAG;
    }

    static /* synthetic */ List access$200(GlobalSearchCategoryFragment r0) {
        return r0.mBigBangItemList;
    }

    static /* synthetic */ String access$300(GlobalSearchCategoryFragment r0) {
        return r0.TAG;
    }

    static /* synthetic */ Map access$400(GlobalSearchCategoryFragment r0) {
        return r0.mUserSet;
    }

    static /* synthetic */ OptionsAdapter access$500(GlobalSearchCategoryFragment r0) {
        return r0.mAdapter;
    }

    static /* synthetic */ Map access$700() {
        return mSectionMap;
    }

    static {
        mIconMap = new HashMap();
        mSectionMap = new HashMap();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        EventBus.getDefault().register(this);
        this.mRootView = r2.inflate(R.layout.options_layout, r3, false);
        this.mTitleResId = Integer.valueOf(R.string.global_search_category_title);
        this.mOptionsList = (ListView) findViewByIdNullable(R.id.options_list);
        this.mIconWidth = getResources().getDimensionPixelOffset(R.dimen.gloable_search_icon_width);
        initIcon();
        initSection();
        initData();
        addHeaderFooterView();
        OptionsAdapter r5 = new OptionsAdapter(this, this._mActivity);
        this.mAdapter = r5;
        this.mOptionsList.setAdapter(r5);
        this.mOptionsList.setOnItemClickListener(new AnonymousClass1(this));
        return this.mRootView;
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r4, Bundle r5) {
        super.onViewCreated(r4, r5);
        Iterator<String> r6 = this.mUserSet.keySet().iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        String r7 = r6.next();
        this.mUserSet.put(r7, PreferenceMgr.getInstance(this.mContext).getString(r7, this.mUserSet.get(r7)));
        goto L4
    L6:
        this.mAdapter.notifyDataSetChanged();
    }

    private void initIcon() {
        Map<String, Integer> r2 = mIconMap;
        r2.put("search_sogou", Integer.valueOf(R.drawable.o_icon_search_sogou));
        r2.put("search_baidu", Integer.valueOf(R.drawable.o_icon_search_baidu));
        r2.put("search_google", Integer.valueOf(R.drawable.o_icon_search_google));
        Integer r0 = Integer.valueOf(R.drawable.loading);
        r2.put("search_bing", r0);
        r2.put("search_360so", r0);
        r2.put("search_toutiao", Integer.valueOf(R.drawable.o_icon_search_toutiao));
        r2.put("dictionary_youdao", Integer.valueOf(R.drawable.o_icon_dictionary_youdao));
        r2.put("dictionary_bing", Integer.valueOf(R.drawable.o_icon_dictionary_bing));
        r2.put("dictionary_iciba", Integer.valueOf(R.drawable.o_icon_dictionary_iciba));
        r2.put("dictionary_google", Integer.valueOf(R.drawable.o_icon_dictionary_google));
        r2.put("baike_baidu", Integer.valueOf(R.drawable.o_icon_baike_baidu));
        r2.put("baike_hudong", Integer.valueOf(R.drawable.o_icon_baike_hudong));
        Integer r1 = Integer.valueOf(R.drawable.o_icon_baike_wikien);
        r2.put("baike_wikiEN", r1);
        r2.put("baike_wikiCN", r1);
        r2.put("third_sogou", Integer.valueOf(R.drawable.o_icon_third_sogou));
        r2.put("third_weibo", Integer.valueOf(R.drawable.o_icon_third_weibo));
        r2.put("third_zhihu", Integer.valueOf(R.drawable.o_icon_third_zhihu));
    }

    private void initSection() {
        Map<String, Integer> r2 = mSectionMap;
        r2.put("config_search", Integer.valueOf(R.string.config_search));
        r2.put("config_dictionary", Integer.valueOf(R.string.config_dictionary));
        r2.put("config_baike", Integer.valueOf(R.string.config_baike));
        r2.put("config_third_search", Integer.valueOf(R.string.config_third_search));
    }

    private void initData() {
        GloableSearchConfig r0 = GloableSearchConfigTool.getInstance(this.mContext).getCacheConfig();
        if (r0 != null) goto L5;
        return;
    L5:
        this.mBigBangItemList.clear();
        List r1 = r0.getConfigTypes();
        if (r1 != null) goto L8;
        return;
    L8:
        int r2 = getLanguageType();
        boolean r3 = true;
        if (r2 != LANGUAGE_CN) goto L11;
        boolean r4 = true;
    L13:
        if (r2 == LANGUAGE_TW) goto L16;
        r3 = false;
    L16:
        Iterator r5 = r1.iterator();
    L18:
        if (r5.hasNext() == false) goto L40;
        SearchConfigType r6 = (SearchConfigType) r5.next();
        List r7 = r6.getDatas();
        if (r7 == null) goto L18;
        Iterator r8 = r7.iterator();
    L23:
        AnonymousClass1 r9 = null;
        if (r8.hasNext() == false) goto L34;
        SearchConfigTypeData r10 = (SearchConfigTypeData) r8.next();
        BigBangItem r11 = new BigBangItem(this, r9);
        r11.category = r6.getOrder();
        r11.categoryName = r6.getType();
        String r12 = r10.getEnName();
        if (r4 == false) goto L28;
        r12 = r10.getName();
    L33:
        r11.title = r12;
        r11.imgUrl = r10.getImgUrl();
        r11.icon = mIconMap.get(r10.getIdentifier()).intValue();
        r11.settingsValue = r10.getIdentifier();
        this.mBigBangItemList.add(r11);
        goto L23
    L28:
        if (r3 == false) goto L33;
        if (r10.getTwName() != null) goto L32;
        r12 = r10.getName();
        goto L33
    L32:
        r12 = r10.getTwName();
        goto L33
    L34:
        String r13 = PreferenceMgr.getInstance(this.mContext).getString(r6.getType(), null);
        if (r13 == null) goto L37;
    L39:
        this.mUserSet.put(r6.getType(), r13);
        goto L18
    L37:
        if (r6.getDefaultData() == null) goto L39;
        r13 = r6.getDefaultData().getIdentifier();
        goto L39
    L40:
        return;
    L11:
        r4 = false;
        goto L13
    }

    private void addHeaderFooterView() {
        this.mOptionsList.addHeaderView(Utils.inflateListTransparentHeader(this._mActivity));
        this.mOptionsList.addFooterView(new SettingsBottomExtraView(getActivity()));
    }

    public void com_android_settings_GlobalSearchCategoryFragment__onResume$___twin___() {
        super.onResume();
        Iterator<String> r0 = this.mUserSet.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        String r1 = r0.next();
        this.mUserSet.put(r1, PreferenceMgr.getInstance(this.mContext).getString(r1, this.mUserSet.get(r1)));
        goto L4
    L6:
        this.mAdapter.notifyDataSetChanged();
    }

    public int getLanguageType() {
        Locale r2 = this.mContext.getResources().getConfiguration().locale;
        String r0 = r2.getLanguage().toLowerCase();
        String r3 = r2.getCountry().toLowerCase();
        if (r0.endsWith("zh") == false) goto L11;
        if ("tw".equals(r3) == false) goto L9;
        return LANGUAGE_TW;
    L9:
        return LANGUAGE_CN;
    L11:
        return LANGUAGE_OTHER;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(GloableSearchConfigTool.GlobalSearchConfigEvent r1) {
        onConfigLoad();
    }

    private void onConfigLoad() {
        initData();
        Iterator<String> r0 = this.mUserSet.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        String r1 = r0.next();
        this.mUserSet.put(r1, PreferenceMgr.getInstance(this.mContext).getString(r1, this.mUserSet.get(r1)));
        goto L4
    L6:
        this.mAdapter.notifyDataSetChanged();
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_GlobalSearchCategoryFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(GlobalSearchCategoryFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_GlobalSearchCategoryFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_GlobalSearchCategoryFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(GlobalSearchCategoryFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_GlobalSearchCategoryFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_GlobalSearchCategoryFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(GlobalSearchCategoryFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_GlobalSearchCategoryFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
