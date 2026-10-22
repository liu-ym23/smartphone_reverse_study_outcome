package com.bumptech.glide.request.transition;

import com.bumptech.glide.load.DataSource;

/* JADX INFO: loaded from: classes3.dex */
public interface TransitionFactory<R> {
    Transition<R> build(DataSource r1, boolean r2);
}
