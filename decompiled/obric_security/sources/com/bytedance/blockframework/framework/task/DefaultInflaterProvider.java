package com.bytedance.blockframework.framework.task;

import kotlin.Metadata;

/* JADX INFO: compiled from: BlockLayoutInflater.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/bytedance/blockframework/framework/task/DefaultInflaterProvider;", "Lcom/bytedance/blockframework/framework/task/BlockInflaterProvider;", "()V", "getInflater", "Lcom/bytedance/blockframework/framework/task/BlockInflater;", "blockframework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class DefaultInflaterProvider implements BlockInflaterProvider {
    public static final DefaultInflaterProvider INSTANCE = null;

    static {
        INSTANCE = new DefaultInflaterProvider();
    }

    private DefaultInflaterProvider() {
    }

    @Override // com.bytedance.blockframework.framework.task.BlockInflaterProvider
    public BlockInflater getInflater() {
        return DefaultLayoutInflater.INSTANCE;
    }
}
