package com.google.crypto.tink.internal;

import com.google.crypto.tink.proto.KeyStatusType;
import com.google.crypto.tink.tinkkey.KeyHandle;

/* JADX INFO: loaded from: classes4.dex */
public final class KeyStatusTypeProtoConverter {

    /* JADX INFO: renamed from: com.google.crypto.tink.internal.KeyStatusTypeProtoConverter$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$proto$KeyStatusType = null;
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$tinkkey$KeyHandle$KeyStatusType = null;

        static {
            int[] r0 = new int[KeyHandle.KeyStatusType.values().length];
            $SwitchMap$com$google$crypto$tink$tinkkey$KeyHandle$KeyStatusType = r0;
            r0[KeyHandle.KeyStatusType.ENABLED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L21:
            $SwitchMap$com$google$crypto$tink$tinkkey$KeyHandle$KeyStatusType[KeyHandle.KeyStatusType.DISABLED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L23:
            $SwitchMap$com$google$crypto$tink$tinkkey$KeyHandle$KeyStatusType[KeyHandle.KeyStatusType.DESTROYED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L8:
            int[] r3 = new int[KeyStatusType.values().length];
            $SwitchMap$com$google$crypto$tink$proto$KeyStatusType = r3;
            r3[KeyStatusType.ENABLED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L16
        L29:
            $SwitchMap$com$google$crypto$tink$proto$KeyStatusType[KeyStatusType.DISABLED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L17
        L19:
            $SwitchMap$com$google$crypto$tink$proto$KeyStatusType[KeyStatusType.DESTROYED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L18
            return;
        }
    }

    public static KeyHandle.KeyStatusType fromProto(KeyStatusType keyStatusTypeProto) {
        int r1 = AnonymousClass1.$SwitchMap$com$google$crypto$tink$proto$KeyStatusType[keyStatusTypeProto.ordinal()];
        if (r1 == 1) goto L15;
        if (r1 == 2) goto L13;
        if (r1 != 3) goto L11;
        return KeyHandle.KeyStatusType.DESTROYED;
    L11:
        throw new IllegalArgumentException("Unknown key status type.");
    L13:
        return KeyHandle.KeyStatusType.DISABLED;
    L15:
        return KeyHandle.KeyStatusType.ENABLED;
    }

    public static KeyStatusType toProto(KeyHandle.KeyStatusType status) {
        int r1 = AnonymousClass1.$SwitchMap$com$google$crypto$tink$tinkkey$KeyHandle$KeyStatusType[status.ordinal()];
        if (r1 == 1) goto L15;
        if (r1 == 2) goto L13;
        if (r1 != 3) goto L11;
        return KeyStatusType.DESTROYED;
    L11:
        throw new IllegalArgumentException("Unknown key status type.");
    L13:
        return KeyStatusType.DISABLED;
    L15:
        return KeyStatusType.ENABLED;
    }

    private KeyStatusTypeProtoConverter() {
    }
}
