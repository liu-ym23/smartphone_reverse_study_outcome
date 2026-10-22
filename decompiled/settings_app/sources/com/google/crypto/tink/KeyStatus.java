package com.google.crypto.tink;

import com.google.errorprone.annotations.Immutable;

/* JADX INFO: loaded from: classes4.dex */
@Immutable
public final class KeyStatus {
    public static final KeyStatus DESTROYED = null;
    public static final KeyStatus DISABLED = null;
    public static final KeyStatus ENABLED = null;
    private final String name;

    static {
        ENABLED = new KeyStatus("ENABLED");
        DISABLED = new KeyStatus("DISABLED");
        DESTROYED = new KeyStatus("DESTROYED");
    }

    private KeyStatus(String name) {
        this.name = name;
    }

    public String toString() {
        return this.name;
    }
}
