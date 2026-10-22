package com.bytedance.blockframework.interaction;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.blockframework.interaction.Event;
import kotlin.Metadata;

/* JADX INFO: compiled from: EventManager.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003J\u0015\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/blockframework/interaction/IObserver;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/blockframework/interaction/Event;", "", "onEvent", "", "event", "(Lcom/bytedance/blockframework/interaction/Event;)Z", "blockframework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface IObserver<T extends Event> {
    boolean onEvent(T r1);
}
