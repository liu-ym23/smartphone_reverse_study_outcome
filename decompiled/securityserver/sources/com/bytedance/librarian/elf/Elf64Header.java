package com.bytedance.librarian.elf;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes.dex */
public class Elf64Header extends Elf.Header {
    private final ElfParser parser;

    public Elf64Header(boolean r4, ElfParser r5) {
        this.bigEndian = r4;
        this.parser = r5;
        ByteBuffer r0 = ByteBuffer.allocate(8);
        if (r4 == false) goto L5;
        ByteOrder r6 = ByteOrder.BIG_ENDIAN;
    L6:
        r0.order(r6);
        this.type = r5.readHalf(r0, 16);
        this.phoff = r5.readLong(r0, 32);
        this.shoff = r5.readLong(r0, 40);
        this.phentsize = r5.readHalf(r0, 54);
        this.phnum = r5.readHalf(r0, 56);
        this.shentsize = r5.readHalf(r0, 58);
        this.shnum = r5.readHalf(r0, 60);
        this.shstrndx = r5.readHalf(r0, 62);
        return;
    L5:
        r6 = ByteOrder.LITTLE_ENDIAN;
        goto L6
    }

    @Override // com.bytedance.librarian.elf.Elf.Header
    public Elf.DynamicStructure getDynamicStructure(long r8, int r10) {
        return new Dynamic64Structure(this.parser, this, r8, r10);
    }

    @Override // com.bytedance.librarian.elf.Elf.Header
    public Elf.ProgramHeader getProgramHeader(long r3) {
        return new Program64Header(this.parser, this, r3);
    }

    @Override // com.bytedance.librarian.elf.Elf.Header
    public Elf.SectionHeader getSectionHeader(int r3) {
        return new Section64Header(this.parser, this, r3);
    }
}
