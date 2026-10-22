package obric.widget.search.data;

import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class GloableSearchConfigTool {
    private static final String TAG = "GloableSearchConfigTool";

    public GloableSearchConfigTool() {
    }

    public static GloableSearchConfig getConfigByJson(String json) {
        JSONObject r1 = new JSONObject(json);     // Catch: Exception -> L8
        GloableSearchConfig r4 = new GloableSearchConfig();     // Catch: Exception -> L8
        r4.setVersion(r1.getInt("version"));     // Catch: Exception -> L6
        r4.setConfigTypes(parseConfigTypes(r1.getJSONArray("types")));     // Catch: Exception -> L6
    L11:
        return r4;
    L6:
        Exception e = e;
    L10:
        Log.w(TAG, "parse config exception :" + e.getMessage());
    L8:
        e = move-exception;
        e = e;
        r4 = null;
        goto L10
    }

    private static List<SearchConfigType> parseConfigTypes(JSONArray datas) {
        if (datas != null) goto L5;
        return null;
    L5:
        ArrayList r0 = new ArrayList();
        int r1 = datas.length();     // Catch: Exception -> L14
        int r3 = 0;
    L7:
        if (r3 >= r1) goto L16;
        JSONObject r4 = datas.getJSONObject(r3);     // Catch: Exception -> L14
        SearchConfigType r5 = new SearchConfigType();     // Catch: Exception -> L14
        r5.setType(r4.getString("type"));     // Catch: Exception -> L14
        r5.setMode(r4.getInt("mode"));     // Catch: Exception -> L14
        r5.setOrder(r4.getInt("order"));     // Catch: Exception -> L14
        r5.setDatas(parseTypeDatas(r4.getJSONArray("datas")));     // Catch: Exception -> L14
        if (r3 != 0) goto L11;
        boolean r6 = true;
    L12:
        r5.setChecked(r6);     // Catch: Exception -> L14
        r0.add(r5);     // Catch: Exception -> L14
        r3 = r3 + 1;
        goto L7
    L11:
        r6 = false;
    L16:
        return r0;
    L14:
        e = move-exception;
        Log.w(TAG, "parse config type exception :" + e.getMessage());
        goto L16
    }

    private static List<SearchConfigTypeData> parseTypeDatas(JSONArray datas) {
        if (datas != null) goto L5;
        return null;
    L5:
        ArrayList r0 = new ArrayList();
        int r1 = datas.length();     // Catch: Exception -> L10
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L12;
        JSONObject r3 = datas.getJSONObject(r2);     // Catch: Exception -> L10
        SearchConfigTypeData r4 = new SearchConfigTypeData();     // Catch: Exception -> L10
        r4.setIdentifier(r3.getString("identifier"));     // Catch: Exception -> L10
        r4.setName(r3.getString("name"));     // Catch: Exception -> L10
        r4.setEnName(r3.getString("enName"));     // Catch: Exception -> L10
        r4.setTwName(r3.getString("twName"));     // Catch: Exception -> L10
        r4.setClickUrl(r3.getString("clickUrl"));     // Catch: Exception -> L10
        r4.setImgUrl(r3.getString("imgUrl"));     // Catch: Exception -> L10
        r4.setOrder(r3.getInt("order"));     // Catch: Exception -> L10
        r4.setDefault(r3.getBoolean("default"));     // Catch: Exception -> L10
        r0.add(r4);     // Catch: Exception -> L10
        r2 = r2 + 1;
    L12:
        return r0;
    L10:
        e = move-exception;
        Log.w(TAG, "parse config type data exception :" + e.getMessage());
        goto L12
    }
}
