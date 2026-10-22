package tj;

import com.bytedance.common.utility.Logger;
import java.util.HashMap;
import java.util.Observable;

/* JADX INFO: loaded from: classes2.dex */
public final class p extends Observable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile p f22137a;

    public static p a() {
        if (f22137a != null) goto L16;
        monitor-enter(p.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f22137a != null) goto L11;
        f22137a = new p();     // Catch: Throwable -> L9
    L11:
        monitor-exit(p.class);     // Catch: Throwable -> L9
    L16:
        return f22137a;
    }

    public void b(String r5, String r10, String r11) {
        StringBuilder r12 = androidx.constraintlayout.motion.widget.a.y("onStoreIdcChanged idc: ", r5, " region: ", r10, " source: ");
        r12.append(r11);
        Logger.d("CronetDataStorageAccess", r12.toString());
        HashMap r13 = new HashMap();
        r13.put("store_idc", r5);
        r13.put("store_region", r10);
        r13.put("region_source", r11);
        setChanged();
        notifyObservers(r13);
    }
}
