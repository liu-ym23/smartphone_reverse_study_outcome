package com.bumptech.glide.manager;

/* JADX INFO: loaded from: classes3.dex */
class ApplicationLifecycle implements Lifecycle {
    @Override // com.bumptech.glide.manager.Lifecycle
    public void removeListener(LifecycleListener r1) {
    }

    ApplicationLifecycle() {
    }

    @Override // com.bumptech.glide.manager.Lifecycle
    public void addListener(LifecycleListener r1) {
        r1.onStart();
    }
}
