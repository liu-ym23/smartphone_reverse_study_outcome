package android.app.sceneperception.data;

import android.app.sceneperception.rule.Const;
import android.app.sceneperception.utils.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class Result {
    public String content;
    public String deeplink;
    public String id;
    public String title;
    public String url;

    public Result() {
    }

    public Result(String id, String deeplink, String url, String title, String content) {
        this.id = id;
        this.deeplink = deeplink;
        this.url = url;
        this.title = title;
        this.content = content;
    }

    public boolean isEmpty() {
        if (StringUtils.isEmpty(this.id) == true) goto L5;
    L13:
        return false;
    L5:
        if (StringUtils.isEmpty(this.deeplink) == false) goto L13;
        if (StringUtils.isEmpty(this.url) == false) goto L13;
        if (StringUtils.isEmpty(this.title) == false) goto L13;
        if (StringUtils.isEmpty(this.content) == false) goto L13;
        return true;
    }

    public static String toJson(Result result) throws JSONException {
        if (result != null) goto L5;
        return "{}";
    L5:
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(Const.TARGET_ID, result.id);
        jsonObject.put(Const.TARGET_DEEPLINK, result.deeplink);
        jsonObject.put(Const.TARGET_URL, result.url);
        jsonObject.put(Const.TARGET_TITLE, result.title);
        jsonObject.put(Const.TARGET_CONTENT, result.content);
        return jsonObject.toString();
    }
}
