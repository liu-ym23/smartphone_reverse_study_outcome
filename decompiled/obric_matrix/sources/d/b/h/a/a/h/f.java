package d.b.h.a.a.h;

import com.bytedance.common.utility.Logger;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a f13384a;

    public interface a {
        b a(String r1, Map<String, String> r2, List<String> r3);

        c b(String r1, Map<String, List<String>> r2, int r3);
    }

    public static class b {
        public String a() {
            throw null;
        }
    }

    public static class c {
        public String a() {
            throw null;
        }
    }

    public static String a(String r2, Map<String, String> r3, List<String> r4) {
        if (f13384a != null) goto L5;
        return null;
    L5:
        Logger.debug();
        b r5 = f13384a.a(r2, r3, r4);
        if (r5 != null) goto L8;
        return null;
    L8:
        r5.a();
        throw null;
    }

    public static String b(String r2, Map<String, List<String>> r3, int r4) {
        if (f13384a != null) goto L5;
        return null;
    L5:
        Logger.debug();
        c r5 = f13384a.b(r2, r3, r4);
        if (r5 != null) goto L8;
        return null;
    L8:
        r5.a();
        throw null;
    }
}
