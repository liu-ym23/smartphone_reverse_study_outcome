package com.google.crypto.tink.streamingaead;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.Parameters;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public abstract class StreamingAeadKey extends Key {
    @Override // com.google.crypto.tink.Key
    @Nullable
    public final Integer getIdRequirementOrNull() {
        return null;
    }

    @Override // com.google.crypto.tink.Key
    public abstract StreamingAeadParameters getParameters();

    public StreamingAeadKey() {
    }

    @Override // com.google.crypto.tink.Key
    public /* bridge */ /* synthetic */ Parameters getParameters() {
        return getParameters();
    }
}
