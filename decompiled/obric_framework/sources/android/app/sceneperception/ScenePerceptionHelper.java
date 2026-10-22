package android.app.sceneperception;

import android.app.Activity;
import android.app.ObricActivityManager;
import android.app.ObricActivityThreadImpl;
import android.app.sceneperception.data.Result;
import android.app.sceneperception.data.ResultWrapper;
import android.app.sceneperception.parser.IntentParser;
import android.app.sceneperception.parser.Parser;
import android.app.sceneperception.parser.RawIntentParser;
import android.app.sceneperception.parser.WebViewParser;
import android.app.sceneperception.parser.WebsiteEntityParser;
import android.app.sceneperception.rule.Const;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Slog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ScenePerceptionHelper {
    private static final String KEY_SESSION_CONTEXT = "context";
    private static final String KEY_SESSION_ID = "sessionId";
    private static final String KEY_SESSION_INTENT = "intent";
    private static final String KEY_SESSION_RESULT = "result";
    private static final String KEY_SESSION_RULE = "rule";
    private static final String KEY_SESSION_STATE = "state";
    private static final String TAG = "ScenePerceptionHelper";
    private static final int VALUE_FAILURE = 2;
    private static final int VALUE_SECURE = 4;
    private static final int VALUE_SUCCESS = 1;
    private static final int VALUE_TIMEOUT = 3;
    private ThreadPoolExecutor mExecutor;

    public static /* synthetic */ void $r8$lambda$8l1uWgrxIQ4_lhb7zVrpIGlaAso(ScenePerceptionHelper r0, WeakReference r1, Bundle r2) {
        r0.lambda$requestScenePerception$1(r1, r2);
    }

    public ScenePerceptionHelper() {
    }

    public ThreadPoolExecutor getExecutor() {
        if (this.mExecutor != null) goto L5;
    L6:
        this.mExecutor = new ThreadPoolExecutor(1, 4, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(10), Executors.defaultThreadFactory(), new ScenePerceptionHelper$$ExternalSyntheticLambda0());
        this.mExecutor.allowCoreThreadTimeOut(true);
    L8:
        return this.mExecutor;
    L5:
        if (this.mExecutor.isShutdown() == false) goto L8;
        goto L6
    }

    static /* synthetic */ void lambda$getExecutor$0(Runnable runnable, ThreadPoolExecutor pool) {
        pool.getQueue().poll();
        if (ObricActivityThreadImpl.DEBUG == false) goto L5;
        Slog.i(TAG, "executor pool is full, discard old task, current queue size: " + pool.getQueue().size());
    L5:
        pool.execute(runnable);
    }

    public void requestScenePerception(Activity topActivity, final Bundle bundle) {
        if (topActivity != null) goto L4;
        return;
    L4:
        if (topActivity.getComponentName() == null) goto L24;
        if (bundle != null) goto L8;
        return;
    L8:
        if (topActivity.getWindow() == null) goto L19;
        if (topActivity.getWindow().getAttributes() == null) goto L19;
        if ((topActivity.getWindow().getAttributes().flags & 8192) == 0) goto L19;
        if (ObricActivityThreadImpl.DEBUG == false) goto L16;
        Slog.i(TAG, "requestScenePerception fail: isSecure");
    L16:
        String sessionId = bundle.getString(KEY_SESSION_ID);
        Bundle resultBundle = new Bundle();
        resultBundle.putString(KEY_SESSION_ID, sessionId);
        resultBundle.putInt(KEY_SESSION_STATE, 4);
        ObricActivityManager.reportScenePerceptionEvent(1, resultBundle);
        return;
    L19:
        if (ObricActivityThreadImpl.DEBUG == false) goto L21;
        Slog.i(TAG, "requestScenePerception, topActivity: " + topActivity.getComponentName().getClassName());
    L21:
        final WeakReference<Activity> activityRef = new WeakReference(topActivity);
        getExecutor().execute(new ScenePerceptionHelper$$ExternalSyntheticLambda1(this, activityRef, bundle));
        return;
    }

    private /* synthetic */ void lambda$requestScenePerception$1(WeakReference activityRef, Bundle bundle) {
        runScenePerception(activityRef, bundle);
    }

    private void runScenePerception(WeakReference<Activity> activityRef, Bundle inputBundle) {
        if (activityRef == null) goto L5;
        Activity activity = activityRef.get();
    L6:
        if (activity != null) goto L8;
        return;
    L8:
        if (activity.getComponentName() == null) goto L97;
        if (inputBundle != null) goto L12;
        return;
    L12:
        if (activity.isFinishing() == true) goto L78;
        if (activity.isDestroyed() == true) goto L78;
        String sessionId = inputBundle.getString(KEY_SESSION_ID);     // Catch: Exception -> L72
        Bundle resultBundle = new Bundle();     // Catch: Exception -> L72
        resultBundle.putString(KEY_SESSION_ID, sessionId);     // Catch: Exception -> L72
        int sessionState = 2;
        String rule = inputBundle.getString(KEY_SESSION_RULE);     // Catch: Throwable -> L62 Exception -> L64
        String ruleContext = inputBundle.getString(KEY_SESSION_CONTEXT);     // Catch: Throwable -> L62 Exception -> L64
        if (ObricActivityThreadImpl.DEBUG == false) goto L21;
        Slog.i(TAG, "rule: " + rule);     // Catch: Throwable -> L62 Exception -> L64
    L21:
        List<Parser> parserList = getParser(rule, ruleContext);     // Catch: Throwable -> L62 Exception -> L64
        if (ObricActivityThreadImpl.DEBUG == false) goto L25;
        Slog.i(TAG, "parserList size: " + parserList.size());     // Catch: Throwable -> L62 Exception -> L64
    L25:
        if (parserList.isEmpty() == true) goto L60;
        Iterator<Parser> r11 = parserList.iterator();     // Catch: Throwable -> L62 Exception -> L64
    L28:
        if (r11.hasNext() == false) goto L60;
        Parser parser = r11.next();     // Catch: Throwable -> L62 Exception -> L64
        if (ObricActivityThreadImpl.DEBUG == false) goto L32;
        Slog.i(TAG, "parser name: " + parser.getClass().getSimpleName());     // Catch: Throwable -> L62 Exception -> L64
    L32:
        ResultWrapper resultWrapper = parser.parse(activity);     // Catch: Throwable -> L62 Exception -> L64
        if (resultWrapper == null) goto L28;
        String resultJson = null;
        if (resultWrapper.result == null) goto L47;
        if (resultWrapper.result.isEmpty() == true) goto L47;
        resultJson = Result.toJson(resultWrapper.result);     // Catch: Throwable -> L62 Exception -> L64
        resultBundle.putString(KEY_SESSION_RESULT, resultJson);     // Catch: Throwable -> L62 Exception -> L64
        if (TextUtils.isEmpty(resultWrapper.result.deeplink) == false) goto L43;
        if (TextUtils.isEmpty(resultWrapper.result.url) == true) goto L47;
    L43:
        sessionState = 1;
        if (ObricActivityThreadImpl.DEBUG == false) goto L60;
        Slog.i(TAG, "parse result: " + resultJson);     // Catch: Throwable -> L62 Exception -> L64
    L47:
        if (ObricActivityThreadImpl.DEBUG == false) goto L50;
        Slog.i(TAG, "parse result: " + resultJson);     // Catch: Throwable -> L62 Exception -> L64
    L50:
        if (resultWrapper.intent == null) goto L53;
        resultBundle.putParcelable(KEY_SESSION_INTENT, resultWrapper.intent);     // Catch: Throwable -> L62 Exception -> L64
        sessionState = 1;
    L53:
        if (ObricActivityThreadImpl.DEBUG == false) goto L28;
        StringBuilder r8 = new StringBuilder().append("parse intent: ");     // Catch: Throwable -> L62 Exception -> L64
        if (resultWrapper.intent == null) goto L57;
        boolean r15 = true;
    L58:
        Slog.i(TAG, r8.append(r15).toString());     // Catch: Throwable -> L62 Exception -> L64
        goto L28
    L57:
        r15 = false;
    L60:
        resultBundle.putInt(KEY_SESSION_STATE, sessionState);     // Catch: Exception -> L72
    L69:
        ObricActivityManager.reportScenePerceptionEvent(1, resultBundle);     // Catch: Exception -> L72
        return;
    L62:
        th = move-exception;
        resultBundle.putInt(KEY_SESSION_STATE, sessionState);     // Catch: Exception -> L72
        ObricActivityManager.reportScenePerceptionEvent(1, resultBundle);     // Catch: Exception -> L72
        throw th;     // Catch: Exception -> L72
    L64:
        e = move-exception;
        if (ObricActivityThreadImpl.DEBUG == false) goto L68;
        Slog.e(TAG, "Error processing rule", e);     // Catch: Throwable -> L62
    L68:
        resultBundle.putInt(KEY_SESSION_STATE, sessionState);     // Catch: Exception -> L72
    L72:
        e = move-exception;
        if (ObricActivityThreadImpl.DEBUG == false) goto L95;
        Slog.e(TAG, "Error processing setting change", e);
        return;
    L95:
        return;
    L78:
        if (ObricActivityThreadImpl.DEBUG == false) goto L96;
        Slog.i(TAG, "runScenePerception skip: activity is finishing or destroyed");
        return;
    L96:
        return;
    L97:
        return;
    L5:
        activity = null;
        goto L6
    }

    private static List<Parser> getParser(String rule, String ruleContext) throws JSONException {
        List<Parser> parserList = new ArrayList();
        if (TextUtils.isEmpty(rule) == true) goto L16;
        JSONObject jsonObject = new JSONObject(rule);
        if (jsonObject.has(KEY_SESSION_INTENT) == false) goto L8;
        parserList.add(new IntentParser(jsonObject, ruleContext));
    L14:
        if (jsonObject.has("rawIntent") == false) goto L16;
        parserList.add(new RawIntentParser(jsonObject, ruleContext));
        goto L16
    L8:
        if (jsonObject.has(Const.RULE_DONATED) == false) goto L11;
        parserList.add(new WebsiteEntityParser(jsonObject, ruleContext));
        goto L14
    L11:
        if (jsonObject.has("webview") == false) goto L14;
        parserList.add(new WebViewParser(jsonObject, ruleContext));
    L16:
        return parserList;
    }
}
