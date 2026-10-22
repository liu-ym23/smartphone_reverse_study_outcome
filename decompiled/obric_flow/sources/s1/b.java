package s1;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.ai.applet.base.gson.JSONArraySerializer;
import com.bytedance.ai.applet.base.gson.JSONObjectDeserializer;
import com.bytedance.ai.applet.base.gson.JSONObjectSerializer;
import com.google.gson.GsonBuilder;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.functions.Function0;
import org.json.JSONArray;
import org.json.JSONObject;
import v0.e;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class b implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f21807a;

    public /* synthetic */ b(int r5) {
        this.f21807a = r5;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch(this.f21807a) {
            case 0: goto L19;
            case 1: goto L17;
            case 2: goto L15;
            case 3: goto L13;
            case 4: goto L11;
            case 5: goto L9;
            case 6: goto L7;
            default: goto L5;
        };
    L5:
        return new GsonBuilder().registerTypeAdapter(JSONObject.class, new JSONObjectSerializer()).registerTypeAdapter(JSONArray.class, new JSONArraySerializer()).excludeFieldsWithoutExposeAnnotation().create();
    L7:
        return new GsonBuilder().setObjectToNumberStrategy(z0.c.f23359a).registerTypeAdapter(JSONObject.class, new JSONObjectSerializer()).registerTypeAdapter(JSONObject.class, new JSONObjectDeserializer()).registerTypeAdapter(JSONArray.class, new JSONArraySerializer()).create();
    L9:
        return y2.d.j();
    L11:
        return new e();
    L13:
        return new Handler(Looper.getMainLooper());
    L15:
        return new v0.d();
    L17:
        return new ConcurrentHashMap();
    L19:
        return new CopyOnWriteArrayList();
    }
}
