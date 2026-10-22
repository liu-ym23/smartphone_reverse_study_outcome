package obric.tablet;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.android.settings.R;
import com.android.settings.utils.UIUtils;
import obric.tablet.widget.SearchBar;

/* JADX INFO: loaded from: classes5.dex */
public class TabletLayout extends LinearLayout {
    public static final int COLUMNS_MASK = 3;
    public static final int FEATURE_COMPLEX_SETTINGS_BAR = 16;
    public static final int FEATURE_HAS_TITLE = 4;
    public static final int FEATURE_SIMPLE_SETTINGS_BAR = 8;
    public static final int FEATURE_THREE_COLUMN = 2;
    public static final int FEATURE_TWO_COLUMN = 1;
    public static final int SETTINGS_BAR_MASK = 24;
    private View fakeStatusBar;
    private Context mContext;
    private View mCustomSettingsBar;
    private int mFeatureFlags;
    private ViewGroup mFirstColumn;
    private ImageView mFirstColumnShadow;
    private LayoutInflater mInflater;
    private int mMinHeight;
    private int mMinWidth;
    private ListView mNavigationListView;
    private SearchBar mSearchView;
    private ViewGroup mSecondColumn;
    private View mSettingsBar;
    private SettingsBarListener mSettingsBarListener;
    private ViewGroup mThirdColumn;
    private boolean mViewInited;

    public interface SettingsBarListener {
        void onAddItemClicked();

        void onDeleteItemClicked();

        void onMoreBtnClicked();

        void onSettingBtnClicked(View r1);
    }

    public int getFirstColumnLayoutId() {
        return R.id.first_column;
    }

    static /* synthetic */ SettingsBarListener access$000(TabletLayout r0) {
        return r0.mSettingsBarListener;
    }

    public TabletLayout(Context r2) {
        this(r2, null);
    }

    public TabletLayout(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public TabletLayout(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.mFeatureFlags = 0;
        init(r1);
    }

    private void init(Context r1) {
        this.mContext = r1;
        this.mInflater = LayoutInflater.from(r1);
    }

    public void initTabletView() {
        setMinimumHeight(this.mMinHeight);
        setMinimumWidth(this.mMinWidth);
        setOrientation(0);
        View r1 = this.mInflater.inflate(R.layout.tablet_columns_layout, this, true);
        this.mSearchView = (SearchBar) r1.findViewById(R.id.search_bar);
        this.mNavigationListView = (ListView) r1.findViewById(R.id.navigation_list);
        this.mFirstColumnShadow = (ImageView) r1.findViewById(R.id.first_column_shadow_iv);
        this.mFirstColumn = (ViewGroup) r1.findViewById(R.id.first_column);
        this.mSecondColumn = (ViewGroup) r1.findViewById(R.id.second_column);
        this.mThirdColumn = (ViewGroup) r1.findViewById(R.id.third_column);
        this.fakeStatusBar = r1.findViewById(R.id.fake_status_bar);
        initColumns();
        if ((this.mFeatureFlags & 24) == 0) goto L6;
        initSettingsBar();
    L6:
        if ((this.mFeatureFlags & 4) != 4) goto L8;
        initTitleBar();
    L8:
        this.mViewInited = true;
        setFirstColumnShadowVisible(false);
        UIUtils.setUpFakeStatusBarOnApplyWindowInsets(this.fakeStatusBar);
    }

    private void initColumns() {
        if ((this.mFeatureFlags & 2) != 2) goto L5;
        LinearLayout.LayoutParams r0 = (LinearLayout.LayoutParams) this.mSecondColumn.getLayoutParams();
        r0.weight = 0.0f;
        r0.width = (int) getResources().getDimension(R.dimen.tablet_second_column_width);
        this.mSecondColumn.setLayoutParams(r0);
        findViewById(R.id.second_divider).setVisibility(0);
        this.mThirdColumn.setVisibility(0);
        return;
    L5:
        LinearLayout.LayoutParams r1 = (LinearLayout.LayoutParams) this.mSecondColumn.getLayoutParams();
        r1.width = -1;
        this.mSecondColumn.setLayoutParams(r1);
        findViewById(R.id.second_divider).setVisibility(8);
        this.mThirdColumn.setVisibility(8);
    }

    public void setListAdapter(BaseAdapter r1) {
        this.mNavigationListView.setAdapter(r1);
    }

    public void setSearchBarListener(obric.widget.SearchBar.ListenerAdapter r1) {
        this.mSearchView.setListener(r1);
    }

    public void setSettingsBarListener(SettingsBarListener r1) {
        this.mSettingsBarListener = r1;
    }

    public void requestFeature(int r2) {
        this.mFeatureFlags = r2 | this.mFeatureFlags;
    }

    public void requestColumnsFeature(int r3) {
        if ((this.mFeatureFlags & r3) != 0) goto L5;
        boolean r0 = true;
    L6:
        setFeatureFlags(r3, 3);
        if (this.mViewInited == true) goto L9;
        return;
    L9:
        if (r0 == false) goto L12;
        initColumns();
        return;
    L12:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public void requestTitleFeature() {
        this.mFeatureFlags |= 4;
    }

    private void initTitleBar() {
        this.mInflater.inflate(R.layout.tablet_second_col_with_title_layout, this.mSecondColumn, true);
        if ((this.mFeatureFlags & 2) != 2) goto L6;
        this.mInflater.inflate(R.layout.tablet_third_col_with_title_layout, this.mThirdColumn, true);
        return;
    }

    public void requestSettingBarFeature() {
        requestSettingBarFeature(8);
    }

    public void requestSettingBarFeature(int r3) {
        if ((this.mFeatureFlags & r3) != 0) goto L5;
        boolean r0 = true;
    L6:
        setFeatureFlags(r3, 24);
        if (this.mViewInited == true) goto L10;
        return;
    L10:
        if (this.mSettingsBar != null) goto L12;
        initSettingsBar();
        return;
    L12:
        if (r0 == false) goto L16;
        changeSettingsBarStyle();
        return;
    L16:
        return;
    L5:
        r0 = false;
        goto L6
    }

    private void initSettingsBar() {
        if (this.mSettingsBar != null) goto L5;
        this.mSettingsBar = ((ViewStub) findViewById(R.id.setting_bar_stub)).inflate();
        ((RelativeLayout.LayoutParams) this.mNavigationListView.getLayoutParams()).addRule(2, this.mSettingsBar.getId());
    L5:
        this.mSettingsBar.findViewById(R.id.setting_btn).setOnClickListener(new AnonymousClass1(this));
        if ((this.mFeatureFlags & 16) != 16) goto L9;
        showMoreBtnsInSettingsBar();
        return;
    }

    public void setCustomSettingBar(View r4) {
        if (this.mCustomSettingsBar != null) goto L5;
        this.mCustomSettingsBar = findViewById(R.id.setting_bar_stub);
    L5:
        ViewParent r0 = this.mCustomSettingsBar.getParent();
        if (r0 != null) goto L8;
        return;
    L8:
        if ((r0 instanceof ViewGroup) == false) goto L19;
        ViewGroup r1 = (ViewGroup) r0;
        int r2 = r1.indexOfChild(this.mCustomSettingsBar);
        r1.removeViewInLayout(this.mCustomSettingsBar);
        ViewGroup.LayoutParams r3 = this.mCustomSettingsBar.getLayoutParams();
        if (r3 == null) goto L12;
        r1.addView(r4, r2, r3);
    L13:
        this.mCustomSettingsBar = r4;
        if (r4.getId() != (-1)) goto L16;
        this.mCustomSettingsBar.setId(R.id.settings_bar);
    L16:
        ((RelativeLayout.LayoutParams) this.mNavigationListView.getLayoutParams()).addRule(2, this.mCustomSettingsBar.getId());
        return;
    L12:
        r1.addView(r4, r2);
        goto L13
    }

    public void setCustomSettingBar(int r4) {
        if (this.mCustomSettingsBar != null) goto L5;
        this.mCustomSettingsBar = findViewById(R.id.setting_bar_stub);
    L5:
        ViewParent r0 = this.mCustomSettingsBar.getParent();
        setCustomSettingBar(this.mInflater.inflate(r4, (ViewGroup) r0, false));
    }

    public View getSettingBar() {
        return this.mSettingsBar;
    }

    private void showMoreBtnsInSettingsBar() {
        View r0 = this.mSettingsBar.findViewById(R.id.setting_btns_layout);
        r0.setVisibility(0);
        RelativeLayout.LayoutParams r1 = (RelativeLayout.LayoutParams) this.mSettingsBar.findViewById(R.id.setting_btn).getLayoutParams();
        r1.removeRule(13);
        r1.addRule(21);
        r1.addRule(15);
        r0.findViewById(R.id.add_btn).setOnClickListener(new AnonymousClass2(this));
        r0.findViewById(R.id.delete_btn).setOnClickListener(new AnonymousClass3(this));
        r0.findViewById(R.id.more_btn).setOnClickListener(new AnonymousClass4(this));
    }

    private void changeSettingsBarStyle() {
        if ((this.mFeatureFlags & 16) != 16) goto L5;
        showMoreBtnsInSettingsBar();
        return;
    L5:
        this.mSettingsBar.findViewById(R.id.setting_btns_layout).setVisibility(8);
        RelativeLayout.LayoutParams r2 = (RelativeLayout.LayoutParams) this.mSettingsBar.findViewById(R.id.setting_btn).getLayoutParams();
        r2.removeRule(21);
        r2.addRule(13);
    }

    public void setFeatureFlags(int r3, int r4) {
        int r5 = r3 & r4;
        this.mFeatureFlags = r5 | (this.mFeatureFlags & (~r4));
    }

    public int getSecondColumnLayoutId() {
        if ((this.mFeatureFlags & 4) != 4) goto L6;
        return R.id.second_content_parent;
    L6:
        return R.id.fragment_container_view;
    }

    public int getThirdColumnLayoutId() {
        if ((this.mFeatureFlags & 4) != 4) goto L6;
        return R.id.third_content_parent;
    L6:
        return R.id.third_column;
    }

    public ListView getNavigationListView() {
        return this.mNavigationListView;
    }

    public SearchBar getSearchBarView() {
        return this.mSearchView;
    }

    public ViewGroup getSecondColumnLayout() {
        if ((this.mFeatureFlags & 4) != 4) goto L7;
        return (ViewGroup) this.mSecondColumn.findViewById(R.id.second_content_parent);
    L7:
        return this.mSecondColumn;
    }

    public ViewGroup getThirdColumnLayout() {
        if ((this.mFeatureFlags & 4) != 4) goto L7;
        return (ViewGroup) this.mThirdColumn.findViewById(R.id.third_content_parent);
    L7:
        return this.mThirdColumn;
    }

    public void setFirstColumnBgColor(int r1) {
        this.mFirstColumn.setBackgroundColor(r1);
    }

    public void setFirstColumnBgColorResId(int r1) {
        this.mFirstColumn.setBackgroundResource(r1);
    }

    public void setSettingsBarBgColor(int r1) {
        View r0 = this.mSettingsBar;
        if (r0 == null) goto L6;
        r0.setBackgroundColor(r1);
        return;
    }

    public void setSettingsBarBgColorResId(int r1) {
        View r0 = this.mSettingsBar;
        if (r0 == null) goto L6;
        r0.setBackgroundResource(r1);
        return;
    }

    public void setDividerColor(int r2) {
        findViewById(R.id.first_divider).setBackgroundColor(r2);
        findViewById(R.id.second_divider).setBackgroundColor(r2);
    }

    public void setDividerBackground(Drawable r2) {
        findViewById(R.id.first_divider).setBackground(r2);
        findViewById(R.id.second_divider).setBackground(r2);
    }

    public void setFirstColumnShadowVisible(boolean r3) {
        ImageView r0 = this.mFirstColumnShadow;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.mSearchView == null) goto L16;
        if (r3 == false) goto L8;
        int r1 = 0;
    L9:
        r0.setVisibility(r1);
        SearchBar r2 = this.mSearchView;
        if (r3 == false) goto L12;
        int r4 = R.drawable.search_bar_background_no_bottom_line;
    L13:
        r2.setBackgroundResource(r4);
        return;
    L12:
        r4 = R.drawable.search_bar_background;
        goto L13
    L8:
        r1 = 8;
        goto L9
    }
}
