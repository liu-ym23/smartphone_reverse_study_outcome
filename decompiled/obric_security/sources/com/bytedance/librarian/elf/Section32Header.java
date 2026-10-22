package com.bytedance.librarian.elf;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes.dex */
public class Section32Header extends Elf.SectionHeader {
    public Section32Header(ElfParser r4, Elf.Header r5, int r6) throws IOException {
        ByteBuffer r0 = ByteBuffer.allocate(4);
        if (r5.bigEndian == false) goto L5;
        ByteOrder r1 = ByteOrder.BIG_ENDIAN;
    L6:
        r0.order(r1);
        this.info = r4.readWord(r0, (r5.shoff + ((long) (r6 * r5.shentsize))) + 28);
        return;
    L5:
        r1 = ByteOrder.LITTLE_ENDIAN;
        goto L6
    }
}
