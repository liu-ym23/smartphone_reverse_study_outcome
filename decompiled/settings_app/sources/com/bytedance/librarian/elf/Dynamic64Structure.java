package com.bytedance.librarian.elf;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes3.dex */
public class Dynamic64Structure extends Elf.DynamicStructure {
    public Dynamic64Structure(ElfParser r4, Elf.Header r5, long r6, int r8) throws IOException {
        ByteBuffer r0 = ByteBuffer.allocate(8);
        if (r5.bigEndian == false) goto L5;
        ByteOrder r7 = ByteOrder.BIG_ENDIAN;
    L6:
        r0.order(r7);
        long r9 = r6 + ((long) (r8 * 16));
        this.tag = r4.readLong(r0, r9);
        this.val = r4.readLong(r0, r9 + 8);
        return;
    L5:
        r7 = ByteOrder.LITTLE_ENDIAN;
        goto L6
    }
}
