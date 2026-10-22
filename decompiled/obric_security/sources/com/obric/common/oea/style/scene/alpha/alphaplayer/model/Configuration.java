package com.obric.common.oea.style.scene.alpha.alphaplayer.model;

import android.content.Context;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Configuration.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/obric/common/oea/style/scene/alpha/alphaplayer/model/Configuration;", "", "context", "Landroid/content/Context;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "(Landroid/content/Context;Landroidx/lifecycle/LifecycleOwner;)V", "alphaVideoViewType", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/model/AlphaVideoViewType;", "getAlphaVideoViewType", "()Lcom/obric/common/oea/style/scene/alpha/alphaplayer/model/AlphaVideoViewType;", "setAlphaVideoViewType", "(Lcom/obric/common/oea/style/scene/alpha/alphaplayer/model/AlphaVideoViewType;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "getLifecycleOwner", "()Landroidx/lifecycle/LifecycleOwner;", "setLifecycleOwner", "(Landroidx/lifecycle/LifecycleOwner;)V", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class Configuration {
    private AlphaVideoViewType alphaVideoViewType;
    private Context context;
    private LifecycleOwner lifecycleOwner;

    public Configuration(Context r2, LifecycleOwner r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "lifecycleOwner");
        this.context = r2;
        this.lifecycleOwner = r3;
        this.alphaVideoViewType = AlphaVideoViewType.GL_SURFACE_VIEW;
    }

    public final Context getContext() {
        return this.context;
    }

    public final void setContext(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.context = r2;
    }

    public final LifecycleOwner getLifecycleOwner() {
        return this.lifecycleOwner;
    }

    public final void setLifecycleOwner(LifecycleOwner r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.lifecycleOwner = r2;
    }

    public final AlphaVideoViewType getAlphaVideoViewType() {
        return this.alphaVideoViewType;
    }

    public final void setAlphaVideoViewType(AlphaVideoViewType r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.alphaVideoViewType = r2;
    }
}
