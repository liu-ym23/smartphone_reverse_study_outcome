package android.app.sceneperception.rule;

import android.app.clickviewtree.ClickViewTreeConstants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class IntentRule {
    public Rules rules;
    public List<Template> templates;

    public static class Data {
        public String pattern;
        public String target;

        public Data() {
        }
    }

    public static class Extra {
        public List<PathConfig> configs;
        public String target;

        public Extra() {
        }
    }

    public static class Intent {
        public List<Data> data;
        public List<Extra> extras;

        public Intent() {
        }
    }

    public static class PathConfig {
        public String path;
        public String pattern;
        public String type;

        public PathConfig() {
        }
    }

    public static class Rules {
        public Intent intent;

        public Rules() {
        }
    }

    public static class Template {
        public String target;
        public String template;

        public Template() {
        }
    }

    public IntentRule() {
    }

    public static IntentRule fromJson(JSONObject jsonObject) throws JSONException {
        IntentRule rule = new IntentRule();
        rule.rules = new Rules();
        rule.templates = new ArrayList();
        if (jsonObject != null) goto L5;
    L80:
        return rule;
    L5:
        if (jsonObject.has("intent") == false) goto L80;
        if (jsonObject.isNull("intent") == true) goto L80;
        JSONObject intentObj = jsonObject.getJSONObject("intent");
        Rules r2 = rule.rules;
        r2.intent = new Intent();
        if (intentObj.has("data") == false) goto L27;
        if (intentObj.isNull("data") == true) goto L27;
        JSONArray dataArray = intentObj.getJSONArray("data");
        Intent r3 = rule.rules.intent;
        r3.data = new ArrayList();
        int i = 0;
    L14:
        if (i >= dataArray.length()) goto L27;
        JSONObject dataObj = dataArray.getJSONObject(i);
        Data data = new Data();
        if (dataObj.has("target") == false) goto L21;
        if (dataObj.isNull("target") == true) goto L21;
        data.target = dataObj.getString("target");
    L21:
        if (dataObj.has("pattern") == false) goto L25;
        if (dataObj.isNull("pattern") == true) goto L25;
        data.pattern = dataObj.getString("pattern");
    L25:
        rule.rules.intent.data.add(data);
        i = i + 1;
    L27:
        if (intentObj.has("extras") == false) goto L63;
        if (intentObj.isNull("extras") == true) goto L63;
        JSONArray extrasArray = intentObj.getJSONArray("extras");
        Intent r4 = rule.rules.intent;
        r4.extras = new ArrayList();
        int i2 = 0;
    L32:
        if (i2 >= extrasArray.length()) goto L63;
        JSONObject extraObj = extrasArray.getJSONObject(i2);
        Extra extra = new Extra();
        if (extraObj.has("target") == true) goto L36;
    L38:
        extra.configs = new ArrayList();
        if (extraObj.has("paths") == false) goto L61;
        if (extraObj.isNull("paths") == true) goto L61;
        JSONArray paths = extraObj.getJSONArray("paths");
        int j = 0;
    L44:
        if (j >= paths.length()) goto L61;
        JSONObject pathObj = paths.getJSONObject(j);
        PathConfig config = new PathConfig();
        if (pathObj.has(ClickViewTreeConstants.KEY_ASSIST_STRUCTURE_TYPE) == false) goto L51;
        if (pathObj.isNull(ClickViewTreeConstants.KEY_ASSIST_STRUCTURE_TYPE) == true) goto L51;
        config.type = pathObj.getString(ClickViewTreeConstants.KEY_ASSIST_STRUCTURE_TYPE);
    L51:
        if (pathObj.has("path") == false) goto L56;
        if (pathObj.isNull("path") == true) goto L56;
        config.path = pathObj.getString("path");
    L56:
        if (pathObj.has("pattern") == false) goto L60;
        if (pathObj.isNull("pattern") == true) goto L60;
        config.pattern = pathObj.getString("pattern");
    L60:
        extra.configs.add(config);
        j = j + 1;
    L61:
        rule.rules.intent.extras.add(extra);
        i2 = i2 + 1;
        goto L32
    L36:
        if (extraObj.isNull("target") == true) goto L38;
        extra.target = extraObj.getString("target");
    L63:
        if (intentObj.has("templates") == false) goto L80;
        if (intentObj.isNull("templates") == true) goto L80;
        JSONArray templatesArray = intentObj.getJSONArray("templates");
        int i3 = 0;
    L68:
        if (i3 >= templatesArray.length()) goto L80;
        JSONObject templateObj = templatesArray.getJSONObject(i3);
        Template template = new Template();
        if (templateObj.has("target") == false) goto L75;
        if (templateObj.isNull("target") == true) goto L75;
        template.target = templateObj.getString("target");
    L75:
        if (templateObj.has("template") == false) goto L79;
        if (templateObj.isNull("template") == true) goto L79;
        template.template = templateObj.getString("template");
    L79:
        rule.templates.add(template);
        i3 = i3 + 1;
        goto L68
    }
}
