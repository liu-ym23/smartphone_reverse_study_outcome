package tf;

import com.bytedance.ai.ex.widget.WidgetView;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap f22130a = null;

    static {
        ConcurrentHashMap r5 = new ConcurrentHashMap();
        a r10 = a.f22129a;
        r5.put("default", r10);
        r5.put(WidgetView.UI_MODE_LIGHT, r10);
        f22130a = r5;
    }
}
