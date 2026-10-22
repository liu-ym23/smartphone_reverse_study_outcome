package com.bytedance.apm.listener;

import androidx.annotation.Nullable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface IStorageCheckListener {
    void onDetectException(long r1, long r3, @Nullable List<String> r5, @Nullable List<String> r6, @Nullable List<String> r7);
}
