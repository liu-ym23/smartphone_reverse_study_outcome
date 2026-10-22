package obric.widget.search;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import com.bytedance.librarian.LibrarianImpl;
import java.lang.ref.SoftReference;
import java.net.URLDecoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import obric.widget.search.data.SearchConfigTypeData;

/* JADX INFO: loaded from: classes5.dex */
public class WebSearchAdapter implements WebSearch {
    public static final String CONFIG_BAIKE = "config_baike";
    public static final String CONFIG_DICTIONARY = "config_dictionary";
    public static final String CONFIG_SEARCH = "config_search";
    public static final String CONFIG_THIRD_SEARCH = "config_third_search";
    private static final int MSG_WHAT_TIME_OUT = 0;
    private static final int REQUEST_SELECT_FILE = 100;
    private static final String TAG = "WebSearchAdapter";
    private static final int TIME_OUT_DURATION = 10000;
    public static final String TYPE_360SO = "search_360so";
    public static final String TYPE_BAIDU = "search_baidu";
    public static final String TYPE_BAIDU_BAIKE = "baike_baidu";
    public static final String TYPE_BING = "search_bing";
    public static final String TYPE_BINGDICT = "dictionary_bing";
    public static final String TYPE_GOOGLE = "search_google";
    public static final String TYPE_GOOGLE_TRANSLATE = "dictionary_google";
    public static final String TYPE_HUDONG_BAIKE = "baike_hudong";
    public static final String TYPE_KINGSOFT = "dictionary_iciba";
    public static final String TYPE_SOGOU = "search_sogou";
    public static final String TYPE_WECHAT = "third_sogou";
    public static final String TYPE_WEIBO = "third_weibo";
    public static final String TYPE_WIKI_CN = "baike_wikiCN";
    public static final String TYPE_WIKI_EN = "baike_wikiEN";
    public static final String TYPE_YOUDAO = "dictionary_youdao";
    public static final String TYPE_ZHIHU = "third_zhihu";
    private boolean isFirstStarted;
    private ImageView mBackView;
    private Context mContext;
    private DownloadListener mDownloadListener;
    private boolean mFirstPage;
    boolean mOverrideUrl;
    private TimeoutHandler mTimeoutHandler;
    ValueCallback<Uri[]> mUploadMessage;
    private WebChromeClient mWebChromeClient;
    private WebSearchViewGroup mWebSearchViewGroup;
    private WebView mWebView;
    private WebViewClient mWebViewClient;
    private WebViewListenr mWebViewListenr;

    private static class TimeoutHandler extends Handler {
        private SoftReference<WebSearchViewGroup> mReference;

        public TimeoutHandler(WebSearchViewGroup webSearchViewGroup) {
            this.mReference = new SoftReference(webSearchViewGroup);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what != 0) goto L10;
            SoftReference<WebSearchViewGroup> r1 = this.mReference;
            if (r1 != null) goto L7;
            return;
        L7:
            if (r1.get() == null) goto L12;
            this.mReference.get().showNetworkView(0);
            return;
        L12:
            return;
        }
    }

    public interface WebViewListenr {
        void onPageFinished(String url);

        void onPageFinishedSuccess();

        void onPageFirstStart(String url);
    }

    static /* synthetic */ Context access$000(WebSearchAdapter r0) {
        return r0.mContext;
    }

    static /* synthetic */ boolean access$100(WebSearchAdapter r0) {
        return r0.isFirstStarted;
    }

    static /* synthetic */ boolean access$102(WebSearchAdapter r0, boolean r1) {
        r0.isFirstStarted = r1;
        return r1;
    }

    static /* synthetic */ WebViewListenr access$200(WebSearchAdapter r0) {
        return r0.mWebViewListenr;
    }

    static /* synthetic */ boolean access$300(WebSearchAdapter r0) {
        return r0.mFirstPage;
    }

    static /* synthetic */ boolean access$302(WebSearchAdapter r0, boolean r1) {
        r0.mFirstPage = r1;
        return r1;
    }

    static /* synthetic */ ImageView access$400(WebSearchAdapter r0) {
        return r0.mBackView;
    }

    static /* synthetic */ WebView access$500(WebSearchAdapter r0) {
        return r0.mWebView;
    }

    static /* synthetic */ TimeoutHandler access$600(WebSearchAdapter r0) {
        return r0.mTimeoutHandler;
    }

    static /* synthetic */ WebSearchViewGroup access$700(WebSearchAdapter r0) {
        return r0.mWebSearchViewGroup;
    }

    static /* synthetic */ String access$800(WebSearchAdapter r0, String r1) {
        return r0.parseTitleFromUrl(r1);
    }

    public WebSearchAdapter(WebSearchViewGroup webSearchViewGroup, Context context) {
        this.isFirstStarted = true;
        this.mWebSearchViewGroup = webSearchViewGroup;
        this.mContext = context;
        this.mBackView = webSearchViewGroup.getBackImageView();
        this.mWebView = this.mWebSearchViewGroup.getWebView();
        initListenerAndClient();
        this.mTimeoutHandler = new TimeoutHandler(webSearchViewGroup);
    }

    private void initListenerAndClient() {
        this.mDownloadListener = new AnonymousClass1(this);
        this.mWebViewClient = new AnonymousClass2(this);
        this.mWebChromeClient = new AnonymousClass3(this);
    }

    private String parseTitleFromUrl(String url) {
        if (this.mFirstPage == true) goto L18;
        SearchConfigTypeData r0 = this.mWebSearchViewGroup.getSearchTypeData();     // Catch: Exception -> L12
        if (r0 != null) goto L7;
        String r1 = "";
    L8:
        String r2 = parseSearchText(url, r1);     // Catch: Exception -> L12
        if (TextUtils.isEmpty(r2) == true) goto L19;
        return URLDecoder.decode(r2, "UTF-8");
    L19:
        return null;
    L7:
        r1 = r0.getIdentifier();     // Catch: Exception -> L12
    L12:
        e = move-exception;
        e.printStackTrace();
        return null;
    L18:
        return null;
    }

    private String parseSearchText(String url, String type) {
        type.hashCode();
        byte r2 = -1;
        switch(type.hashCode()) {
            case -591304756: goto L54;
            case -539770761: goto L50;
            case -392144311: goto L46;
            case 401991666: goto L42;
            case 442667993: goto L38;
            case 446065680: goto L34;
            case 448925808: goto L30;
            case 462847834: goto L26;
            case 734709285: goto L22;
            case 1120061616: goto L18;
            case 1255159298: goto L14;
            case 1360266496: goto L10;
            case 1770659548: goto L6;
            default: goto L58;
        };
    L6:
        if (type.equals("dictionary_youdao") == false) goto L58;
        r2 = 12;
        goto L58
    L10:
        if (type.equals("baike_baidu") == false) goto L58;
        r2 = 11;
        goto L58
    L14:
        if (type.equals("dictionary_google") == false) goto L58;
        r2 = 10;
        goto L58
    L18:
        if (type.equals("search_google") == false) goto L58;
        r2 = 9;
        goto L58
    L22:
        if (type.equals("dictionary_iciba") == false) goto L58;
        r2 = 8;
        goto L58
    L26:
        if (type.equals("search_sogou") == false) goto L58;
        r2 = 7;
        goto L58
    L30:
        if (type.equals("third_zhihu") == false) goto L58;
        r2 = 6;
        goto L58
    L34:
        if (type.equals("third_weibo") == false) goto L58;
        r2 = 5;
        goto L58
    L38:
        if (type.equals("third_sogou") == false) goto L58;
        r2 = 4;
        goto L58
    L42:
        if (type.equals("search_360so") == false) goto L58;
        r2 = 3;
        goto L58
    L46:
        if (type.equals("dictionary_bing") == false) goto L58;
        r2 = 2;
        goto L58
    L50:
        if (type.equals("search_bing") == false) goto L58;
        r2 = 1;
        goto L58
    L54:
        if (type.equals("baike_hudong") == false) goto L58;
        r2 = 0;
    L58:
        switch(r2) {
            case 0: goto L71;
            case 1: goto L70;
            case 2: goto L70;
            case 3: goto L70;
            case 4: goto L69;
            case 5: goto L64;
            case 6: goto L69;
            case 7: goto L63;
            case 8: goto L64;
            case 9: goto L70;
            case 10: goto L64;
            case 11: goto L60;
            case 12: goto L70;
            default: goto L59;
        };
    L59:
        String r4 = matcherSearchText(url, "w(or)?d=", "&");
    L73:
        if (TextUtils.isEmpty(r4) == false) goto L75;
    L84:
        return null;
    L75:
        if (r4.contains(LibrarianImpl.Constants.SEPARATOR) == true) goto L84;
        if (r4.contains("?") == true) goto L84;
        if (r4.contains("#") == true) goto L84;
        if (r4.contains("=") == true) goto L84;
        return r4;
    L60:
        String r1 = matcherSearchText(url, "/item/", LibrarianImpl.Constants.SEPARATOR);
        if (TextUtils.isEmpty(r1) == true) goto L69;
        r4 = r1;
        goto L73
    L63:
        r4 = matcherSearchText(url, "keyword=", "&");
        goto L73
    L64:
        r4 = url.substring(url.lastIndexOf(LibrarianImpl.Constants.SEPARATOR) + 1);
        if (TextUtils.isEmpty(r4) == true) goto L73;
        if (r4.contains(".html") == false) goto L73;
        return null;
    L69:
        r4 = matcherSearchText(url, "query=", "&");
        goto L73
    L70:
        r4 = matcherSearchText(url, "q=", "&");
        goto L73
    L71:
        r4 = matcherSearchText(url, "(wiki|doc)/", "&");
        goto L73
    }

    private String matcherSearchText(String url, String prevkey, String nextKey) {
        Matcher r0 = Pattern.compile(prevkey).matcher(url);
        if (r0.find() == false) goto L7;
        String r1 = url.substring(r0.end(0));
        Matcher r2 = Pattern.compile(nextKey).matcher(r1);
        if (r2.find() == true) goto L10;
        return r1;
    L10:
        return r1.substring(0, r2.start(0));
    L7:
        return null;
    }

    @Override // obric.widget.search.WebSearch
    public WebViewClient getWebViewClient() {
        return this.mWebViewClient;
    }

    @Override // obric.widget.search.WebSearch
    public WebChromeClient getWebChromeClient() {
        return this.mWebChromeClient;
    }

    @Override // obric.widget.search.WebSearch
    public DownloadListener getDownloadListener() {
        return this.mDownloadListener;
    }

    @Override // obric.widget.search.WebSearch
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode != 100) goto L9;
        ValueCallback<Uri[]> r2 = this.mUploadMessage;
        if (r2 != null) goto L7;
        return;
    L7:
        r2.onReceiveValue(WebChromeClient.FileChooserParams.parseResult(resultCode, data));
        this.mUploadMessage = null;
        return;
    }

    @Override // obric.widget.search.WebSearch
    public void performSearch(String url) {
        this.mFirstPage = true;
        this.isFirstStarted = true;
    }

    public void setWebViewListenr(WebViewListenr listenr) {
        this.mWebViewListenr = listenr;
    }
}
