package com.squareup.wire;

import com.squareup.wire.Message;
import com.squareup.wire.Message.Builder;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.io.StreamCorruptedException;

/* JADX INFO: loaded from: classes5.dex */
final class MessageSerializedForm<M extends Message<M, B>, B extends Message.Builder<M, B>> implements Serializable {
    private static final long serialVersionUID = 0;
    private final byte[] bytes;
    private final Class<M> messageClass;

    public MessageSerializedForm(byte[] r1, Class<M> r2) {
        this.bytes = r1;
        this.messageClass = r2;
    }

    Object readResolve() throws ObjectStreamException {
        ProtoAdapter r0 = ProtoAdapter.get(this.messageClass);
        return r0.decode(this.bytes);
    L5:
        e = move-exception;
        throw new StreamCorruptedException(e.getMessage());
    }
}
