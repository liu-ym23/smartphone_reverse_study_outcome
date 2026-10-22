package va;

import android.os.Looper;
import com.google.common.reflect.w;
import df.c;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap f22564a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap f22565b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap f22566c = null;
    public static final w d = null;

    static {
        f22564a = new ConcurrentHashMap();
        f22565b = new ConcurrentHashMap();
        f22566c = new ConcurrentHashMap();
        d = new w("meta-timer-task", 1);
        Looper.getMainLooper();
    }

    public static boolean a(String r10) {
        ConcurrentHashMap r5 = f22565b;
        if (((File) r5.get(r10)) == null) goto L5;
        return true;
    L5:
        StringBuilder r11 = new StringBuilder();
        r11.append((String) c.d.get(r10));
        String r12 = File.separator;
        File r13 = new File(androidx.constraintlayout.motion.widget.a.u(r11, r12, r10, r12, "metaDataNew.json"));
        if (r13.exists() == false) goto L9;
        r5.put(r10, r13);
        return true;
    L9:
        return false;
    }

    public static void b(String r5) {
        StringBuilder r10 = new StringBuilder();
        r10.append((String) c.d.get(r5));
        String r11 = File.separator;
        File r12 = new File(androidx.constraintlayout.motion.widget.a.u(r10, r11, r5, r11, "metaDataNew.json"));
        File r13 = r12.getParentFile();
        if (r13.exists() == true) goto L5;
        r13.mkdirs();
    L5:
        r12.createNewFile();
        f22565b.put(r5, r12);
    }
}
