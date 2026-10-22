package android.app.sceneperception.parser;

import android.app.Activity;
import android.app.ObricActivityThreadImpl;
import android.app.sceneperception.data.Result;
import android.app.sceneperception.data.ResultWrapper;
import android.app.sceneperception.rule.WebViewRule;
import android.os.Handler;
import android.os.Looper;
import android.util.Slog;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class WebViewParser extends Parser {
    private static final String TAG = "WebViewParser";
    private static final long WEBVIEW_PARSE_TIMEOUT_MS = 3000;

    public WebViewParser(JSONObject rule, String context) {
        super(rule, context);
    }

    @Override // android.app.sceneperception.parser.Parser
    public ResultWrapper parse(Activity activity) throws JSONException {
        JSONObject contextJson = new JSONObject(this.context);
        WebViewRule webViewRule = WebViewRule.fromJson(contextJson);
        List<String> webViewClassNames = webViewRule.webview;
        View webView = locateWebView(activity.getWindow().getDecorView(), webViewClassNames);
        if (webView == null) goto L8;
        Result result = webViewToResult(webView);
        if (result == null) goto L8;
        return new ResultWrapper(null, result);
    L8:
        return null;
    }

    private static boolean checkClass(Object object, String className) {
        Class<?> r0 = object.getClass();
    L3:
        if (r0 == null) goto L9;
        if (r0.getName().equals(className) == true) goto L6;
        r0 = r0.getSuperclass();
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public static View locateWebView(View view, List<String> webViewClassNames) {
        if (view != null) goto L6;
        return null;
    L6:
        if ((view instanceof WebView) == false) goto L8;
        return view;
    L8:
        if (webViewClassNames == null) goto L17;
        Iterator<String> r1 = webViewClassNames.iterator();
    L11:
        if (r1.hasNext() == false) goto L17;
        String className = r1.next();
        if (checkClass(view, className) == false) goto L11;
        return view;
    L17:
        if ((view instanceof ViewGroup) == false) goto L25;
        ViewGroup viewGroup = (ViewGroup) view;
        int i = 0;
    L20:
        if (i >= viewGroup.getChildCount()) goto L25;
        View webViewTmp = locateWebView(viewGroup.getChildAt(i), webViewClassNames);
        if (webViewTmp != null) goto L23;
        i = i + 1;
        goto L20
    L23:
        return webViewTmp;
    L25:
        return null;
    }

    private static Result webViewToResult(final View webView) {
        Callable<Result> task = new WebViewParser$$ExternalSyntheticLambda0(webView);
        FutureTask<Result> futureTask = new FutureTask(task);
        Handler handler = new Handler(Looper.getMainLooper());
        handler.post(futureTask);
        return futureTask.get(WEBVIEW_PARSE_TIMEOUT_MS, TimeUnit.MILLISECONDS);
    L5:
        e = move-exception;
        throw new RuntimeException(e);
    L9:
        Thread.currentThread().interrupt();
        return null;
    L13:
        if (ObricActivityThreadImpl.DEBUG == false) goto L15;
        Slog.e(TAG, "main thread task timeout");
    L15:
        futureTask.cancel(false);
        handler.removeCallbacks(futureTask);
        return null;
    }

    static /* synthetic */ Result lambda$webViewToResult$0(View webView) throws Exception {
        Method getTitleMethod = webView.getClass().getMethod("getTitle", new Class[0]);
        Method getUrlMethod = webView.getClass().getMethod("getUrl", new Class[0]);
        getTitleMethod.setAccessible(true);
        getUrlMethod.setAccessible(true);
        String title = (String) getTitleMethod.invoke(webView, new Object[0]);
        String url = (String) getUrlMethod.invoke(webView, new Object[0]);
        return new Result(null, null, url, title, null);
    }
}
