package com.bytedance.librarian.elf;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes.dex */
public class Program64Header extends Elf.ProgramHeader {
    public Program64Header(ElfParser r6, Elf.Header r7, long r8) {
        ByteBuffer r0 = ByteBuffer.allocate(8);
        if (r7.bigEndian == false) goto L5;
        ByteOrder r1 = ByteOrder.BIG_ENDIAN;
    L6:
        r0.order(r1);
        long r2 = r7.phoff;
        long r9 = (r8 * ((long) r7.phentsize)) + r2;
        this.type = r6.readWord(r0, r9);
        this.offset = r6.readLong(r0, 8 + r9);
        this.vaddr = r6.readLong(r0, 16 + r9);
        this.memsz = r6.readLong(r0, r9 + 40);
        return;
    L5:
        r1 = ByteOrder.LITTLE_ENDIAN;
        goto L6
    }
}
