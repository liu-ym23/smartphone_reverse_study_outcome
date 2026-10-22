package obric.widget.search;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebBackForwardList;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.settings.ApnEditor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import obric.widget.R;
import obric.widget.search.data.GloableSearchConfig;
import obric.widget.search.data.SearchConfigTypeData;
import smartisanos.util.NameAvatarController;
import smartisanos.util.Utils;

/* JADX INFO: loaded from: classes5.dex */
public class WebSearchViewGroup extends RelativeLayout implements WebSearchAdapter.WebViewListenr, View.OnClickListener {
    private static final String BLANK_PAGE = "about:blank";
    private static final String IS_NEED_LOADURL = "is_need_loadurl";
    private static final String TAG = "WebSearchViewGroup";
    public static final String TYPE_GOOGLE_TRANSLATE = "dictionary_google";
    public static final HashMap<String, String> sSearchEngineResMap = null;
    private WebSearch mAdapter;
    private ImageNavigation mBottomPanel;
    private ImageView mBrowserIcon;
    private int mCheckedIndex;
    private GloableSearchConfig mConfig;
    private Context mContext;
    private boolean mIsAutoFinishAfterGoBrowser;
    private boolean mIsAutoFinishAfterSetting;
    private boolean mIsNeedLoadUrl;
    private boolean mIsRecordCheckedIndex;
    protected NetworkView mNetworkLayout;
    private RadioFrameLayout mRadioFrameLayout;
    protected String mSearchText;
    private ImageNavigation mTopPanel;
    private TrackerCallback mTrackerCallback;
    protected WebView mWebView;

    public static class CallbackWrapper implements TrackerCallback {
        @Override // obric.widget.search.WebSearchViewGroup.TrackerCallback
        public void onBackOnClick() {
        }

        @Override // obric.widget.search.WebSearchViewGroup.TrackerCallback
        public void onBrowserClick() {
        }

        @Override // obric.widget.search.WebSearchViewGroup.TrackerCallback
        public void onLoadUrl(String url) {
        }

        @Override // obric.widget.search.WebSearchViewGroup.TrackerCallback
        public void onPageFinished(String url) {
        }

        @Override // obric.widget.search.WebSearchViewGroup.TrackerCallback
        public void onPageFinishedSuccess() {
        }

        @Override // obric.widget.search.WebSearchViewGroup.TrackerCallback
        public void onPageFirstStart(String url) {
        }

        @Override // obric.widget.search.WebSearchViewGroup.TrackerCallback
        public void onRefreshClick() {
        }

        @Override // obric.widget.search.WebSearchViewGroup.TrackerCallback
        public void onSettingClick() {
        }

        public CallbackWrapper() {
        }
    }

    private interface TrackerCallback {
        void onBackOnClick();

        void onBrowserClick();

        void onLoadUrl(String url);

        void onPageFinished(String url);

        void onPageFinishedSuccess();

        void onPageFirstStart(String url);

        void onRefreshClick();

        void onSettingClick();
    }

    static /* synthetic */ TrackerCallback access$000(WebSearchViewGroup r0) {
        return r0.mTrackerCallback;
    }

    static /* synthetic */ Context access$100(WebSearchViewGroup r0) {
        return r0.mContext;
    }

    static /* synthetic */ boolean access$200(WebSearchViewGroup r0) {
        return r0.mIsAutoFinishAfterSetting;
    }

    static /* synthetic */ void access$300(WebSearchViewGroup r0) {
        r0.performSearch();
    }

    static {
        HashMap<String, String> r0 = new HashMap();
        sSearchEngineResMap = r0;
        r0.put("com.UCMobile", "boom_win_browser_uc");
        r0.put("com.tencent.mtt", "boom_win_browser_qq");
        r0.put("com.baidu.searchbox", "boom_win_browser_baidu");
        r0.put("com.qihoo.browser", "boom_win_browser_360");
        r0.put("com.android.chrome", "boom_win_browser_chrome");
        r0.put("com.oupeng.browser", "boom_win_browser_oupeng");
        r0.put("sogou.mobile.explorer", "boom_win_browser_sogou");
        r0.put("com.ijinshan.browser_fast", "boom_win_browser_liebao");
    }

    public WebSearchViewGroup(Context context) {
        this(context, null);
    }

    public WebSearchViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mIsNeedLoadUrl = true;
        this.mSearchText = "";
        this.mCheckedIndex = 0;
        this.mIsRecordCheckedIndex = false;
        this.mIsAutoFinishAfterSetting = true;
        this.mIsAutoFinishAfterGoBrowser = true;
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.web_search_view_group, this, true);
        this.mTopPanel = (ImageNavigation) findViewById(R.id.top_panel);
        this.mBottomPanel = (ImageNavigation) findViewById(R.id.bottom_panel);
        this.mWebView = (WebView) findViewById(R.id.search_webview);
        NetworkView r2 = (NetworkView) findViewById(R.id.network_view);
        this.mNetworkLayout = r2;
        r2.getRefreshBtn().setOnClickListener(this);
        ImageView r3 = (ImageView) this.mTopPanel.findViewById(R.id.goto_browser);
        this.mBrowserIcon = r3;
        r3.setOnClickListener(this);
        int r4 = getResources().getDimensionPixelSize(R.dimen.web_search_browser_icon_size);
        this.mTopPanel.setRightImageWidthAndHeight(r4, r4);
        this.mTopPanel.setTitleText(getResources().getString(R.string.web_search_title));
        this.mBottomPanel.setLeftImageViewRes(R.drawable.boom_win_go_back);
        this.mBottomPanel.setRightImageViewRes(R.drawable.boom_win_setting);
        this.mBottomPanel.setLeftImageViewClickLisener(new AnonymousClass1(this));
        this.mBottomPanel.setRightImageViewClickLisener(new AnonymousClass2(this));
        initWebView();
    }

    private void initWebView() {
        WebSettings r0 = this.mWebView.getSettings();
        r0.setJavaScriptEnabled(true);
        r0.setBlockNetworkImage(false);
        r0.setDomStorageEnabled(true);
        r0.setMixedContentMode(2);
        r0.supportZoom();
        r0.setUseWideViewPort(true);
        r0.setLoadWithOverviewMode(true);
        r0.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.TEXT_AUTOSIZING);
        WebSearchAdapter r1 = new WebSearchAdapter(this, this.mContext);
        this.mAdapter = r1;
        r1.setWebViewListenr(this);
        setupWebView();
    }

    private void setupWebView() {
        WebSearch r0 = this.mAdapter;
        if (r0 == null) goto L6;
        this.mWebView.setWebViewClient(r0.getWebViewClient());
        this.mWebView.setWebChromeClient(this.mAdapter.getWebChromeClient());
        this.mWebView.setDownloadListener(this.mAdapter.getDownloadListener());
        return;
    }

    public void setAdapter(WebSearchAdapter adapter) {
        this.mAdapter = adapter;
        setupWebView();
    }

    public void setData(Parcelable config) {
        if ((config instanceof GloableSearchConfig) == false) goto L8;
        this.mConfig = (GloableSearchConfig) config;
        reset();
        setupRadioFrameView();
        if (this.mIsRecordCheckedIndex == false) goto L9;
        setCheckedIndex(this.mCheckedIndex);
        return;
    L9:
        return;
    }

    public void setSearchText(String searchText, String searchType) {
        setSearchTextTitle(searchText);
        RadioFrameLayout r0 = this.mRadioFrameLayout;
        if (r0 == null) goto L6;
        r0.setCheckedWithSearchType(searchType);
        return;
    }

    public void setSearchText(String searchText) {
        setSearchTextTitle(searchText);
        RadioFrameLayout r0 = this.mRadioFrameLayout;
        if (r0 == null) goto L6;
        r0.setChecked();
        return;
    }

    public void setCheckedIndex(int index) {
        RadioFrameLayout r0 = this.mRadioFrameLayout;
        if (r0 == null) goto L6;
        r0.setCheckedIndex(index);
        return;
    }

    public int getCheckedIndex() {
        RadioFrameLayout r0 = this.mRadioFrameLayout;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.getCheckedIndex();
    }

    public void setAutoFinishAfterSetting(boolean finish) {
        this.mIsAutoFinishAfterSetting = finish;
    }

    public boolean isAutoFinishAfterSetting() {
        return this.mIsAutoFinishAfterSetting;
    }

    public void setAutoFinishAfterGoBrowser(boolean finish) {
        this.mIsAutoFinishAfterGoBrowser = finish;
    }

    public boolean isAutoFinishAfterGoBrowser() {
        return this.mIsAutoFinishAfterGoBrowser;
    }

    public void setRecordCheckedIndex(boolean record) {
        this.mIsRecordCheckedIndex = record;
    }

    public boolean isRecordCheckedIndex() {
        return this.mIsRecordCheckedIndex;
    }

    public void setSearchTextTitle(String searchTextTitle) {
        if (TextUtils.isEmpty(searchTextTitle) == false) goto L5;
        searchTextTitle = "";
    L5:
        this.mSearchText = searchTextTitle;
    }

    private void setupRadioFrameView() {
        RadioFrameLayout r0 = new RadioFrameLayout(this.mContext);
        this.mRadioFrameLayout = r0;
        r0.init(this.mConfig);
        this.mRadioFrameLayout.setOnCheckedChangedListener(new AnonymousClass3(this));
        this.mBottomPanel.setView(this.mRadioFrameLayout);
    }

    private void performSearch() {
        if (this.mIsNeedLoadUrl == false) goto L10;
        WebView r0 = this.mWebView;
        if (r0 == null) goto L11;
        r0.clearHistory();
        String r1 = getOriUrl();
        this.mAdapter.performSearch(r1);
        this.mWebView.loadUrl(r1);
        TrackerCallback r2 = this.mTrackerCallback;
        if (r2 == null) goto L12;
        r2.onLoadUrl(r1);
        return;
    L12:
        return;
    L11:
        return;
    }

    private String getOriUrl() {
        if (this.mRadioFrameLayout != null) goto L6;
        return null;
    L6:
        String r0 = Uri.encode(this.mSearchText);
        SearchConfigTypeData r5 = this.mRadioFrameLayout.getSearchTypeData();
        if (r5 == null) goto L15;
        if (TextUtils.equals("dictionary_google", r5.getIdentifier()) == false) goto L13;
        return String.format(r5.getClickUrl(), new Object[]{"zh-CN/" + r0});
    L13:
        return String.format(r5.getClickUrl(), new Object[]{r0});
    L15:
        return "http://m.baidu.com/s?word=" + r0 + "&from=1013377a";
    }

    private void gotoBrowser() {
        Context r0 = this.mContext;
        if ((r0 instanceof Activity) == true) goto L5;
    L7:
        String r1 = this.mWebView.getUrl();
        if (TextUtils.isEmpty(r1) == false) goto L12;
        r1 = this.mWebView.getOriginalUrl();
        if (TextUtils.isEmpty(r1) == false) goto L12;
        r1 = getOriUrl();
    L12:
        if (r1 != null) goto L14;
        return;
    L14:
        Uri r2 = Uri.parse(r1);
        Intent r3 = new Intent();
        r3.setAction("android.intent.action.VIEW");
        r3.setPackage("com.android.browser");
        r3.setData(r2);
        WebBackForwardList r4 = this.mWebView.copyBackForwardList();
        int r5 = 0;
        if (r4 != null) goto L17;
        int r6 = 0;
    L19:
        if (r6 <= 1) goto L37;
        ArrayList<String> r7 = new ArrayList();
    L21:
        if (r5 >= r6) goto L28;
        String r8 = r4.getItemAtIndex(r5).getUrl();
        if (BLANK_PAGE.equals(r8) == true) goto L27;
        if (r2.toString().equals(r8) == true) goto L27;
        r7.add(r8);
    L27:
        r5 = r5 + 1;
        goto L21
    L28:
        r3.putExtra("currentItemIndex", r4.getCurrentIndex());
        r3.putStringArrayListExtra("shareHistory", r7);
    L37:
        this.mContext.startActivity(r3);     // Catch: ActivityNotFoundException -> L31
    L33:
        TrackerCallback r9 = this.mTrackerCallback;
        if (r9 == null) goto L43;
        r9.onBrowserClick();
        return;
    L43:
        return;
    L31:
        e = move-exception;
        e.printStackTrace();
        goto L33
    L17:
        r6 = r4.getSize();
        goto L19
    L5:
        if (this.mIsAutoFinishAfterGoBrowser == false) goto L7;
        ((Activity) r0).finish();
        goto L7
    }

    private void updateBrowserIcon() {
        PackageManager r0 = this.mContext.getPackageManager();
        Intent r1 = new Intent("android.intent.action.VIEW");
        r1.setData(new Uri.Builder().scheme("http").authority(ApnEditor.APN_TYPE_ALL).build());
        String r2 = r0.resolveActivity(r1, 65536).activityInfo.packageName;
    L20:
        e = move-exception;
        e.printStackTrace();
        return;
    L4:
        if (TextUtils.equals("smartisanos", r2) == false) goto L7;
        this.mBrowserIcon.setBackgroundResource(R.drawable.boom_win_browser_obric);     // Catch: Exception -> L20
        return;
    L7:
        Iterator<Map.Entry<String, String>> r3 = sSearchEngineResMap.entrySet().iterator();     // Catch: Exception -> L20
    L9:
        if (r3.hasNext() == false) goto L16;
        Map.Entry<String, String> r4 = r3.next();     // Catch: Exception -> L20
        if (TextUtils.equals(r4.getKey(), r2) == false) goto L9;
        int r5 = getResources().getIdentifier(r4.getValue(), "drawable", this.mContext.getPackageName());     // Catch: Exception -> L20
        if (r5 <= 0) goto L27;
        Bitmap r6 = NameAvatarController.getCircleBitmap(BitmapFactory.decodeResource(getResources(), r5), true);     // Catch: Exception -> L20
        this.mBrowserIcon.setBackground(new BitmapDrawable(getResources(), r6));     // Catch: Exception -> L20
        return;
    L27:
        return;
    L16:
        BitmapDrawable r7 = (BitmapDrawable) r0.getApplicationInfo(r2, 0).loadIcon(r0);     // Catch: Exception -> L20
        if (r7 == null) goto L28;
        Bitmap r8 = NameAvatarController.getCircleBitmap(r7.getBitmap(), true);     // Catch: Exception -> L20
        this.mBrowserIcon.setBackground(new BitmapDrawable(getResources(), r8));     // Catch: Exception -> L20
        return;
    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {
        this.mIsNeedLoadUrl = savedInstanceState.getBoolean(IS_NEED_LOADURL);
        WebView r1 = this.mWebView;
        if (r1 == null) goto L6;
        r1.restoreState(savedInstanceState);
        return;
    }

    public void onSaveInstanceState(Bundle outState) {
        outState.putBoolean(IS_NEED_LOADURL, false);
        WebView r2 = this.mWebView;
        if (r2 == null) goto L6;
        r2.saveState(outState);
        return;
    }

    public void onResume() {
        this.mWebView.onResume();
        this.mWebView.resumeTimers();
        checkNetwork();
    }

    public void checkNetwork() {
        if (Utils.isConnected(getContext()) == true) goto L5;
        showNetworkView(0);
        return;
    L5:
        if (needReloadUrl() == false) goto L9;
        showNetworkView(1);
        this.mWebView.loadUrl(getOriUrl());
        return;
    }

    public void hideNetworkView() {
        this.mWebView.setVisibility(0);
        this.mNetworkLayout.setVisibility(8);
    }

    public void showNetworkView(int status) {
        WebView r0 = this.mWebView;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.mNetworkLayout == null) goto L10;
        r0.setVisibility(8);
        this.mNetworkLayout.setVisibility(0);
        this.mNetworkLayout.setStatus(status);
        return;
    }

    public void onPause() {
        this.mWebView.onPause();
        this.mWebView.pauseTimers();
        this.mCheckedIndex = getCheckedIndex();
    }

    public void onDestroy() {
        WebView r0 = this.mWebView;
        if (r0 != null) goto L5;
        return;
    L5:
        removeView(r0);
        this.mWebView.stopLoading();
        this.mWebView.getSettings().setJavaScriptEnabled(false);
        this.mWebView.clearHistory();
        this.mWebView.clearView();
        this.mWebView.removeAllViews();
        this.mWebView.destroy();
        this.mWebView = null;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        this.mAdapter.onActivityResult(requestCode, resultCode, data);
    }

    public ImageView getBackImageView() {
        return this.mBottomPanel.getLeftImageView();
    }

    public TextView getTitle() {
        return (TextView) this.mTopPanel.getMidView();
    }

    public WebView getWebView() {
        return this.mWebView;
    }

    public void setProgressValue(int progressValue) {
        RadioFrameLayout r0 = this.mRadioFrameLayout;
        if (r0 == null) goto L6;
        r0.setProgressValue(progressValue);
        return;
    }

    public String getSearchText() {
        return this.mSearchText;
    }

    public SearchConfigTypeData getSearchTypeData() {
        RadioFrameLayout r0 = this.mRadioFrameLayout;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.getSearchTypeData();
    }

    public List<SearchConfigTypeData> getSearchTypeDataList() {
        RadioFrameLayout r0 = this.mRadioFrameLayout;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.getTypeDataList();
    }

    public void reset() {
        this.mIsNeedLoadUrl = true;
        RadioFrameLayout r1 = this.mRadioFrameLayout;
        if (r1 == null) goto L6;
        r1.reset();
        return;
    }

    public void setTrackerCallBack(TrackerCallback callBack) {
        this.mTrackerCallback = callBack;
    }

    @Override // obric.widget.search.WebSearchAdapter.WebViewListenr
    public void onPageFinishedSuccess() {
        TrackerCallback r0 = this.mTrackerCallback;
        if (r0 == null) goto L6;
        r0.onPageFinishedSuccess();
        return;
    }

    @Override // obric.widget.search.WebSearchAdapter.WebViewListenr
    public void onPageFirstStart(String url) {
        TrackerCallback r0 = this.mTrackerCallback;
        if (r0 == null) goto L6;
        r0.onPageFirstStart(url);
        return;
    }

    @Override // obric.widget.search.WebSearchAdapter.WebViewListenr
    public void onPageFinished(String url) {
        TrackerCallback r0 = this.mTrackerCallback;
        if (r0 == null) goto L6;
        r0.onPageFinished(url);
        return;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != this.mNetworkLayout.getRefreshBtn()) goto L9;
        TrackerCallback r2 = this.mTrackerCallback;
        if (r2 == null) goto L7;
        r2.onRefreshClick();
    L7:
        checkNetwork();
        return;
    L9:
        if (view != this.mBrowserIcon) goto L13;
        gotoBrowser();
        return;
    }

    private boolean needReloadUrl() {
        WebSearch r1 = this.mAdapter;
        if ((r1 instanceof WebSearchAdapter) == true) goto L5;
    L8:
        return true;
    L5:
        if (((WebSearchAdapter) r1).mOverrideUrl == false) goto L8;
        return false;
    }
}
