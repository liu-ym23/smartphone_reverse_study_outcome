package android.app.sceneperception.parser;

import android.app.Activity;
import android.app.ObricActivityThreadImpl;
import android.app.assist.AssistContent;
import android.app.sceneperception.data.Result;
import android.app.sceneperception.data.ResultWrapper;
import android.app.sceneperception.rule.Const;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.util.Slog;
import java.lang.reflect.Field;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class WebsiteEntityParser extends Parser {
    private static final String TAG = "WebsiteEntityParser";
    private static final long WEBSITE_ENTITY_PARSE_TIMEOUT_MS = 3000;

    public WebsiteEntityParser(JSONObject rule, String context) {
        super(rule, context);
    }

    @Override // android.app.sceneperception.parser.Parser
    public ResultWrapper parse(Activity activity) throws NoSuchFieldException, IllegalAccessException {
        AssistContent outContent = new AssistContent();
        if (runOnProvideAssistContent(activity, outContent) == true) goto L5;
        return null;
    L5:
        Bundle bundle = outContent.getExtras();
        if (bundle != null) goto L8;
        return null;
    L8:
        List<Parcelable> entityList = outContent.getExtras().getParcelableArrayList("entities");
        if (entityList != null) goto L11;
    L18:
        return null;
    L11:
        if (entityList.isEmpty() == true) goto L18;
        Object entity = entityList.get(0);
        Result result = entityToResult(entity);
        if (result != null) goto L16;
        return null;
    L16:
        return new ResultWrapper(null, result);
    }

    private static boolean runOnProvideAssistContent(final Activity activity, final AssistContent outContent) {
        Callable<Result> task = new WebsiteEntityParser$$ExternalSyntheticLambda0(activity, outContent);
        FutureTask<Result> futureTask = new FutureTask(task);
        Handler handler = new Handler(Looper.getMainLooper());
        handler.post(futureTask);
        futureTask.get(WEBSITE_ENTITY_PARSE_TIMEOUT_MS, TimeUnit.MILLISECONDS);     // Catch: Exception -> L6 InterruptedException -> L8 TimeoutException -> L11
        return true;
    L9:
        Thread.currentThread().interrupt();
        return false;
    L13:
        if (ObricActivityThreadImpl.DEBUG == false) goto L15;
        Slog.e(TAG, "main thread task timeout");
    L15:
        futureTask.cancel(false);
        handler.removeCallbacks(futureTask);
        return false;
    L7:
        return false;
    }

    static /* synthetic */ Result lambda$runOnProvideAssistContent$0(Activity activity, AssistContent outContent) throws Exception {
        activity.onProvideAssistContent(outContent);
        return null;
    }

    private static Result entityToResult(Object entity) throws NoSuchFieldException, IllegalAccessException {
        if (entity == null) goto L5;
        Field webUrlField = entity.getClass().getDeclaredField("webUrl");
        webUrlField.setAccessible(true);
        String url = (String) webUrlField.get(entity);
        Field titleField = entity.getClass().getDeclaredField(Const.TARGET_TITLE);
        titleField.setAccessible(true);
        String title = (String) titleField.get(entity);
        return new Result(null, null, url, title, null);
    L5:
        return null;
    }
}
