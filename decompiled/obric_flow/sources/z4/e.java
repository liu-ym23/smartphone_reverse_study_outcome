package z4;

import com.bytedance.android.monitorV2.hybridSetting.Switches;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap f23395a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f23396b;

    static {
        f23395a = new ConcurrentHashMap();
        f23396b = 0;
    }

    public static String a() {
        StringBuilder r5 = new StringBuilder();
        Iterator r10 = f23395a.entrySet().iterator();
    L4:
        if (r10.hasNext() == false) goto L7;
        Map.Entry r11 = (Map.Entry) r10.next();
        Integer r12 = (Integer) r11.getKey();
        Switches r13 = (Switches) r11.getValue();
        r5.append(r12.toString());
        r5.append(":");
        r5.append(r13.name());
        r5.append("=");
        r5.append(r13.f3600a);
        r5.append(' ');
        goto L4
    L7:
        return r5.toString();
    }
}
