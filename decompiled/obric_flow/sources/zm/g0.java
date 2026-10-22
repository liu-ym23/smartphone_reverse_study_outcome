package zm;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.text.TextUtils;
import com.lynx.base.log.LynxLog;
import com.lynx.tasm.behavior.LynxContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public abstract class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap f23485a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final HashMap f23486b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String[] f23487c = null;
    public static final String[] d = null;
    public static final ConcurrentHashMap e = null;
    public static final ArrayList f = null;

    static {
        f23485a = new HashMap();
        f23486b = new HashMap();
        f23487c = new String[]{"", "_bold", "_italic", "_bold_italic"};
        d = new String[]{".ttf", ".otf"};
        e = new ConcurrentHashMap();
        f = new ArrayList();
    }

    public static synchronized Typeface a(int r5, String r10) {
        monitor-enter(g0.class);
        Typeface[] r11 = (Typeface[]) f23485a.get(r10);     // Catch: Throwable -> L10
        if (r11 == null) goto L12;
        Typeface r12 = r11[r5];     // Catch: Throwable -> L10
        if (r12 == null) goto L12;
        monitor-exit(g0.class);
        return r12;
    L12:
        Iterator r13 = f.iterator();     // Catch: Throwable -> L10
    L14:
        if (r13.hasNext() == false) goto L33;
        com.bytedance.ies.bullet.lynx.init.g r14 = (com.bytedance.ies.bullet.lynx.init.g) r13.next();     // Catch: Throwable -> L10
        if (r14 == null) goto L14;
        Typeface r15 = r14.a(r5, r10);     // Catch: Throwable -> L10
        if (r15 == null) goto L14;
        monitor-enter(g0.class);     // Catch: Throwable -> L10
        HashMap r16 = f23485a;     // Catch: Throwable -> L25
        Typeface[] r17 = (Typeface[]) r16.get(r10);     // Catch: Throwable -> L25
        if (r17 != null) goto L27;
        r17 = new Typeface[4];     // Catch: Throwable -> L25
        r16.put(r10, r17);     // Catch: Throwable -> L25
    L27:
        r17[r5] = r15;     // Catch: Throwable -> L25
        f23486b.put(r15, r17);     // Catch: Throwable -> L25
        monitor-exit(g0.class);     // Catch: Throwable -> L10
        monitor-exit(g0.class);
        return r15;
    L25:
        th = move-exception;
        throw th;     // Catch: Throwable -> L10
    L33:
        monitor-exit(g0.class);
        return null;
    L10:
        th = move-exception;
        throw th;
    }

    public static Typeface b(AssetManager r10, String r11, int r12) {
        String r5 = r11 + "font/" + r12;
        ConcurrentHashMap r13 = e;
        if (r13.containsKey(r5) == true) goto L5;
        String r14 = f23487c[r12];
        StringBuilder r15 = new StringBuilder(32);
        r15.append("font/");
        r15.append(r11);
        r15.append(r14);
        int r16 = r15.length();
        String[] r17 = d;
        int r18 = r17.length;
        int r19 = 0;
    L7:
        if (r19 >= r18) goto L15;
        String r20 = r17[r19];
        String r21 = r15.toString();
        if (r21.endsWith(r20) == true) goto L17;
        r15.append(r20);
        r21 = r15.toString();
    L17:
        Typeface r22 = Typeface.createFromAsset(r10, r21);     // Catch: RuntimeException -> L13
        r13.put(r5, new e0(r22));     // Catch: RuntimeException -> L13
        return r22;
    L13:
        e = move-exception;
        LynxLog.b(3, "TypefaceCache", "Exception happens whe cacheTypefaceFromAssets with message " + e.getMessage());
        r15.setLength(r16);
        r19 = r19 + 1;
        goto L7
    L15:
        r13.put(r5, new e0(null));
        return null;
    L5:
        return ((e0) r13.get(r5)).f23478a;
    }

    public static synchronized Typeface c(LynxContext r10, String r11, int r12) {
        monitor-enter(g0.class);
        String[] r5 = r11.split(",");     // Catch: Throwable -> L17
        int r13 = r5.length;     // Catch: Throwable -> L17
        int r14 = 0;
    L6:
        if (r14 >= r13) goto L20;
        String r15 = com.lynx.tasm.utils.b.h(r5[r14]);     // Catch: Throwable -> L17
        if (TextUtils.isEmpty(r15) == true) goto L19;
        Typeface r16 = a(r12, r15);     // Catch: Throwable -> L17
        if (r16 != null) goto L11;
        Typeface r17 = com.lynx.tasm.fontface.f.f10866a.a(r10, r15, r12, null);     // Catch: Throwable -> L17
        if (r17 == null) goto L19;
        monitor-exit(g0.class);
        return r17;
    L11:
        monitor-exit(g0.class);
        return r16;
    L19:
        r14 = r14 + 1;
        goto L6
    L20:
        LynxLog.b(0, "TypefaceCache", "Can't not find typeface for fontFamily: " + r11 + " in lynx.");     // Catch: Throwable -> L17
        monitor-exit(g0.class);
        return null;
    L17:
        th = move-exception;
        throw th;
    }
}
