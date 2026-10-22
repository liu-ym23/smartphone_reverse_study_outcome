package androidx.lifecycle;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class ViewModelStore {
    private final HashMap<String, ViewModel> mMap;

    public ViewModelStore() {
        this.mMap = new HashMap();
    }

    public final void clear() {
        Iterator<ViewModel> r0 = this.mMap.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().clear();
        goto L4
    L6:
        this.mMap.clear();
    }

    final ViewModel get(String r1) {
        return this.mMap.get(r1);
    }

    Set<String> keys() {
        return new HashSet(this.mMap.keySet());
    }

    final void put(String r1, ViewModel r2) {
        ViewModel r0 = this.mMap.put(r1, r2);
        if (r0 == null) goto L6;
        r0.onCleared();
        return;
    }
}
