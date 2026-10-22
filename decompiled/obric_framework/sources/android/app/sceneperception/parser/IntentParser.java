package android.app.sceneperception.parser;

import android.app.Activity;
import android.app.sceneperception.data.Result;
import android.app.sceneperception.data.ResultWrapper;
import android.app.sceneperception.rule.Const;
import android.app.sceneperception.rule.IntentRule;
import android.app.sceneperception.utils.CollectionUtils;
import android.app.sceneperception.utils.StringUtils;
import android.content.Intent;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class IntentParser extends Parser {

    @FunctionalInterface
    private interface FieldExtractor<T> {
        String extract(Intent r1, T r2);
    }

    @FunctionalInterface
    private interface TargetGetter<T> {
        String getTarget(T r1);
    }

    public static /* synthetic */ String $r8$lambda$DtDc0Gywchhu7sJ2bweCAC5RhaI(IntentParser r0, Intent r1, IntentRule.Data r2) {
        return r0.extractFromData(r1, r2);
    }

    public static /* synthetic */ String $r8$lambda$hnRr3A2MQlfaJD4zXsUzVr1yc_I(IntentParser r0, Intent r1, IntentRule.Extra r2) {
        return r0.extractFromExtras(r1, r2);
    }

    public IntentParser(JSONObject rule, String context) {
        super(rule, context);
    }

    @Override // android.app.sceneperception.parser.Parser
    public ResultWrapper parse(Activity activity) throws JSONException {
        Intent intent = activity.getIntent();
        if (intent != null) goto L5;
        return null;
    L5:
        IntentRule intentRule = IntentRule.fromJson(this.rule);
        Result result = new Result();
        handleIntentData(result, intentRule, intent);
        handleIntentExtras(result, intentRule, intent);
        return new ResultWrapper(null, result);
    }

    private void handleIntentData(Result result, IntentRule intentRule, Intent intent) {
        handleIntent(result, intentRule, intent, new IntentParser$$ExternalSyntheticLambda2(), new IntentParser$$ExternalSyntheticLambda3(this), new IntentParser$$ExternalSyntheticLambda4());
    }

    static /* synthetic */ List lambda$handleIntentData$0(IntentRule.Intent _intent) {
        return _intent.data;
    }

    static /* synthetic */ String lambda$handleIntentData$1(IntentRule.Data data) {
        return data.target;
    }

    private void handleIntentExtras(Result result, IntentRule intentRule, Intent intent) {
        handleIntent(result, intentRule, intent, new IntentParser$$ExternalSyntheticLambda5(), new IntentParser$$ExternalSyntheticLambda6(this), new IntentParser$$ExternalSyntheticLambda7());
    }

    static /* synthetic */ List lambda$handleIntentExtras$2(IntentRule.Intent _intent) {
        return _intent.extras;
    }

    static /* synthetic */ String lambda$handleIntentExtras$3(IntentRule.Extra extra) {
        return extra.target;
    }

    private <T> void handleIntent(Result result, IntentRule intentRule, Intent intent, Function<IntentRule.Intent, List<T>> listGetter, FieldExtractor<T> extractor, TargetGetter<T> targetGetter) {
        if (isValidIntent(intent, intentRule) == true) goto L5;
        return;
    L5:
        List<T> items = getItemsSafely(intentRule, listGetter);
        if (CollectionUtils.isEmpty(items) == false) goto L8;
        return;
    L8:
        Map<String, String> fieldsMap = extractFields(result, intent, items, extractor, targetGetter);
        processTemplates(result, intentRule, fieldsMap);
    }

    private <T> List<T> getItemsSafely(IntentRule intentRule, Function<IntentRule.Intent, List<T>> listGetter) {
        return (List) Optional.ofNullable(intentRule).map(new IntentParser$$ExternalSyntheticLambda0()).map(new IntentParser$$ExternalSyntheticLambda1()).map(listGetter).orElse(Collections.emptyList());
    }

    static /* synthetic */ IntentRule.Rules lambda$getItemsSafely$4(IntentRule rule) {
        return rule.rules;
    }

    static /* synthetic */ IntentRule.Intent lambda$getItemsSafely$5(IntentRule.Rules rules) {
        return rules.intent;
    }

    private boolean isValidIntent(Intent intent, IntentRule intentRule) {
        if (intent == null) goto L5;
        if (intentRule == null) goto L5;
        return true;
    L5:
        return false;
    }

    private String extractFromData(Intent intent, IntentRule.Data item) {
        if (StringUtils.isNotBlank(item.target) == true) goto L7;
        return null;
    L7:
        return BundlePathUtil.applyPattern(intent.getDataString(), item.pattern);
    }

    private String extractFromExtras(Intent intent, IntentRule.Extra item) {
        if (StringUtils.isNotBlank(item.target) == true) goto L7;
        return null;
    L7:
        return BundlePathUtil.getStringFromPath(intent.getExtras(), item.configs);
    }

    private <T> Map<String, String> extractFields(Result result, Intent intent, List<T> items, FieldExtractor<T> extractor, TargetGetter<T> targetGetter) {
        Map<String, String> fieldsMap = new HashMap();
        Iterator<T> r1 = items.iterator();
    L4:
        if (r1.hasNext() == false) goto L11;
        T item = r1.next();
        String target = targetGetter.getTarget(item);
        if (StringUtils.isNotBlank(target) == false) goto L4;
        String matchContent = extractor.extract(intent, item);
        if (StringUtils.isNotBlank(matchContent) == false) goto L4;
        fillResult(result, target, matchContent);
        fieldsMap.put(target.toLowerCase(), matchContent);
        goto L4
    L11:
        return fieldsMap;
    }

    private void processTemplates(Result result, IntentRule intentRule, Map<String, String> fieldsMap) {
        if (CollectionUtils.isEmpty(intentRule.templates) == false) goto L5;
        return;
    L5:
        if (fieldsMap.isEmpty() == true) goto L21;
        Iterator<IntentRule.Template> r0 = intentRule.templates.iterator();
    L9:
        if (r0.hasNext() == false) goto L14;
        IntentRule.Template template = r0.next();
        String content = replaceTemplateContent(template.template, fieldsMap);
        if (content == null) goto L9;
        fillResult(result, template.target, content);
        goto L9
    L14:
        return;
    }

    private String replaceTemplateContent(String template, Map<String, String> fieldsMap) {
        if (template != null) goto L5;
        return null;
    L5:
        String result = template;
        boolean hasReplacement = false;
        Iterator<Map.Entry<String, String>> r3 = fieldsMap.entrySet().iterator();
    L7:
        if (r3.hasNext() == false) goto L12;
        Map.Entry<String, String> entry = r3.next();
        String placeholder = "<" + entry.getKey() + ">";
        if (result.contains(placeholder) == false) goto L7;
        result = result.replace(placeholder, entry.getValue());
        hasReplacement = true;
        goto L7
    L12:
        if (hasReplacement == true) goto L14;
        return null;
    L14:
        return result;
    }

    private void fillResult(Result result, String target, String content) {
        if (StringUtils.equalsIgnoreCase(target, Const.TARGET_ID) == false) goto L8;
        if (content.length() < 3) goto L20;
        result.id = content;
        return;
    L20:
        return;
    L8:
        if (StringUtils.equalsIgnoreCase(target, Const.TARGET_DEEPLINK) == false) goto L11;
        result.deeplink = content;
        return;
    L11:
        if (StringUtils.equalsIgnoreCase(target, Const.TARGET_URL) == false) goto L14;
        result.url = content;
        return;
    L14:
        if (StringUtils.equalsIgnoreCase(target, Const.TARGET_TITLE) == false) goto L17;
        result.title = content;
        return;
    L17:
        if (StringUtils.equalsIgnoreCase(target, Const.TARGET_CONTENT) == false) goto L25;
        result.content = content;
        return;
    }
}
