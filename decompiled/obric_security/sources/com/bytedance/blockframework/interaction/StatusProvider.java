package com.bytedance.blockframework.interaction;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.blockframework.interaction.State;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: State.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0002\u0010\u0006R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058F¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/blockframework/interaction/StatusProvider;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/blockframework/interaction/State;", "Lcom/bytedance/blockframework/interaction/IStatusProvider;", "_stateClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "stateClass", "getStateClass", "()Ljava/lang/Class;", "blockframework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class StatusProvider<T extends State> implements IStatusProvider<T> {
    private final Class<T> _stateClass;

    public StatusProvider(Class<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "_stateClass");
        this._stateClass = r2;
    }

    @Override // com.bytedance.blockframework.interaction.IStatusProvider
    public final Class<T> getStateClass() {
        return this._stateClass;
    }
}
