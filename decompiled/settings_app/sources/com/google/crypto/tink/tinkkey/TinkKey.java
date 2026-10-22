package com.google.crypto.tink.tinkkey;

import com.google.crypto.tink.KeyTemplate;
import com.google.errorprone.annotations.Immutable;

/* JADX INFO: loaded from: classes4.dex */
@Immutable
public interface TinkKey {
    KeyTemplate getKeyTemplate();

    boolean hasSecret();
}
