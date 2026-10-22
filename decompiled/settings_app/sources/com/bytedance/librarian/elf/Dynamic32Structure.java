package com.bytedance.librarian.elf;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes3.dex */
public class Dynamic32Structure extends Elf.DynamicStructure {
    public Dynamic32Structure(ElfParser r4, Elf.Header r5, long r6, int r8) throws IOException {
        ByteBuffer r0 = ByteBuffer.allocate(4);
        if (r5.bigEndian == false) goto L5;
        ByteOrder r7 = ByteOrder.BIG_ENDIAN;
    L6:
        r0.order(r7);
        long r9 = r6 + ((long) (r8 * 8));
        this.tag = r4.readWord(r0, r9);
        this.val = r4.readWord(r0, r9 + 4);
        return;
    L5:
        r7 = ByteOrder.LITTLE_ENDIAN;
        goto L6
    }
}
