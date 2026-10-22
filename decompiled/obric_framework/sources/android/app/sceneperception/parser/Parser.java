package android.app.sceneperception.parser;

import android.app.Activity;
import android.app.sceneperception.data.ResultWrapper;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class Parser {
    protected String context;
    protected JSONObject rule;

    public abstract ResultWrapper parse(Activity r1) throws Exception;

    protected Parser(JSONObject rule, String context) {
        this.rule = rule;
        this.context = context;
    }
}
