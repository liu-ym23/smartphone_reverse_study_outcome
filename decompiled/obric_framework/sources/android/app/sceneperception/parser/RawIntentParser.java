package android.app.sceneperception.parser;

import android.app.Activity;
import android.app.sceneperception.data.ResultWrapper;
import android.content.Intent;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class RawIntentParser extends Parser {
    public RawIntentParser(JSONObject rule, String context) {
        super(rule, context);
    }

    @Override // android.app.sceneperception.parser.Parser
    public ResultWrapper parse(Activity activity) {
        Intent intent = activity.getIntent();
        return new ResultWrapper(intent, null);
    }
}
