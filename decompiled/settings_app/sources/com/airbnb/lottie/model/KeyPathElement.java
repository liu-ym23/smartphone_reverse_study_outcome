package com.airbnb.lottie.model;

import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface KeyPathElement {
    <T> void addValueCallback(T r1, LottieValueCallback<T> r2);

    void resolveKeyPath(KeyPath r1, int r2, List<KeyPath> r3, KeyPath r4);
}
