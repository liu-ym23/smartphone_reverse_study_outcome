package com.bytedance.blockframework.interaction;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.blockframework.interaction.State;
import kotlin.Metadata;

/* JADX INFO: compiled from: State.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003R\u0012\u0010\u0004\u001a\u00028\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/blockframework/interaction/IStatusProvider;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/blockframework/interaction/State;", "", "state", "getState", "()Lcom/bytedance/blockframework/interaction/State;", "stateClass", "Ljava/lang/Class;", "getStateClass", "()Ljava/lang/Class;", "blockframework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface IStatusProvider<T extends State> {
    T getState();

    Class<T> getStateClass();
}
