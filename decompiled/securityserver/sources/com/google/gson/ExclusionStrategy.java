package com.google.gson;

/* JADX INFO: loaded from: classes.dex */
public interface ExclusionStrategy {
    boolean shouldSkipClass(Class<?> r1);

    boolean shouldSkipField(FieldAttributes r1);
}
