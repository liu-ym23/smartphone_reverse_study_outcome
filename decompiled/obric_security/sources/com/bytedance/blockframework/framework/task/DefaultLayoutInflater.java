package com.bytedance.blockframework.framework.task;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.apm.constant.SlardarConfigConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BlockLayoutInflater.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/bytedance/blockframework/framework/task/DefaultLayoutInflater;", "Lcom/bytedance/blockframework/framework/task/BlockInflater;", "()V", "getView", "Landroid/view/View;", SlardarConfigConsts.CONFIG_ID, "", "context", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "blockframework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class DefaultLayoutInflater implements BlockInflater {
    public static final DefaultLayoutInflater INSTANCE = null;

    static {
        INSTANCE = new DefaultLayoutInflater();
    }

    private DefaultLayoutInflater() {
    }

    @Override // com.bytedance.blockframework.framework.task.BlockInflater
    public View getView(int r1, Context r2, ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "parent");
        View r0 = LayoutInflater.from(r2).inflate(r1, r3, false);
        Intrinsics.checkNotNullExpressionValue(r0, "from(context).inflate(id, parent, false)");
        return r0;
    }
}
