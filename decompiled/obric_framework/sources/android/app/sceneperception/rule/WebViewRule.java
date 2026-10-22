package android.app.sceneperception.rule;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class WebViewRule {
    public List<String> webview;

    public WebViewRule() {
    }

    public static WebViewRule fromJson(JSONObject jsonObject) throws JSONException {
        WebViewRule rule = new WebViewRule();
        if (jsonObject != null) goto L5;
    L11:
        return rule;
    L5:
        if (jsonObject.has("webview") == false) goto L11;
        JSONArray jsonArray = jsonObject.getJSONArray("webview");
        List<String> webViewList = new ArrayList();
        int i = 0;
    L8:
        if (i >= jsonArray.length()) goto L10;
        webViewList.add(jsonArray.getString(i));
        i = i + 1;
        goto L8
    L10:
        rule.webview = webViewList;
        goto L11
    }
}
