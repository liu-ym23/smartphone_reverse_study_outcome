package com.bumptech.glide.manager;

import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.util.Util;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class TargetTracker implements LifecycleListener {
    private final Set<Target<?>> targets;

    public TargetTracker() {
        this.targets = Collections.newSetFromMap(new WeakHashMap());
    }

    public void track(Target<?> r1) {
        this.targets.add(r1);
    }

    public void untrack(Target<?> r1) {
        this.targets.remove(r1);
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStart() {
        Iterator r1 = Util.getSnapshot(this.targets).iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        ((Target) r1.next()).onStart();
        goto L4
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStop() {
        Iterator r1 = Util.getSnapshot(this.targets).iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        ((Target) r1.next()).onStop();
        goto L4
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onDestroy() {
        Iterator r1 = Util.getSnapshot(this.targets).iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        ((Target) r1.next()).onDestroy();
        goto L4
    }

    public List<Target<?>> getAll() {
        return Util.getSnapshot(this.targets);
    }

    public void clear() {
        this.targets.clear();
    }
}
