package xm;

import com.lynx.tasm.LynxView;
import com.lynx.tasm.behavior.ui.LynxUI;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f23174a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WeakHashMap f23175b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final WeakHashMap f23176c;
    public final WeakHashMap d;
    public final WeakHashMap e;
    public final WeakHashMap f;
    public volatile boolean g;

    public i() {
        this.f23174a = new ConcurrentHashMap();
        this.f23175b = new WeakHashMap();
        this.f23176c = new WeakHashMap();
        this.d = new WeakHashMap();
        this.e = new WeakHashMap();
        this.f = new WeakHashMap();
        this.g = true;
    }

    public static void a(WeakHashMap r5, LynxView r10) {
        Iterator r11 = r5.entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L10;
        LynxUI r12 = (LynxUI) ((Map.Entry) r11.next()).getKey();
        if (r12 == null) goto L4;
        if (r12.getLynxContext().f10145m.f10385a != r10) goto L4;
        r11.remove();
        goto L4
    }
}
