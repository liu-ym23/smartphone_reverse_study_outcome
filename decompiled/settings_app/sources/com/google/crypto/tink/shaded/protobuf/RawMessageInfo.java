package com.google.crypto.tink.shaded.protobuf;

/* JADX INFO: loaded from: classes4.dex */
@CheckReturnValue
final class RawMessageInfo implements MessageInfo {
    private static final int IS_PROTO2_BIT = 1;
    private final MessageLite defaultInstance;
    private final int flags;
    private final String info;
    private final Object[] objects;

    RawMessageInfo(MessageLite defaultInstance, String info, Object[] objects) {
        this.defaultInstance = defaultInstance;
        this.info = info;
        this.objects = objects;
        char r4 = info.charAt(0);
        if (r4 >= 55296) goto L5;
        this.flags = r4;
        return;
    L5:
        int r5 = r4 & 8191;
        int r0 = 13;
        int r1 = 1;
    L6:
        int r2 = r1 + 1;
        char r3 = info.charAt(r1);
        if (r3 < 55296) goto L9;
        r5 = r5 | ((r3 & 8191) << r0);
        r0 = r0 + 13;
        r1 = r2;
        goto L6
    L9:
        this.flags = r5 | (r3 << r0);
    }

    String getStringInfo() {
        return this.info;
    }

    Object[] getObjects() {
        return this.objects;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MessageInfo
    public MessageLite getDefaultInstance() {
        return this.defaultInstance;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MessageInfo
    public ProtoSyntax getSyntax() {
        if ((this.flags & 1) == 0) goto L7;
        return ProtoSyntax.PROTO2;
    L7:
        return ProtoSyntax.PROTO3;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MessageInfo
    public boolean isMessageSetWireFormat() {
        if ((this.flags & 2) != 2) goto L5;
        return true;
    L5:
        return false;
    }
}
