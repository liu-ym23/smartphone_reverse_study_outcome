package kotlinx.coroutines.flow;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public interface MutableStateFlow<T> extends StateFlow<T>, MutableSharedFlow<T> {
    void setValue(Object r1);
}
