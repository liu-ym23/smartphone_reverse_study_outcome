package com.bumptech.glide.load.model;

/* JADX INFO: loaded from: classes.dex */
public interface ModelLoaderFactory<T, Y> {
    ModelLoader<T, Y> build(MultiModelLoaderFactory r1);

    void teardown();
}
