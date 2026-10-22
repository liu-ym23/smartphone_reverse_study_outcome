package com.bytedance.librarian.elf;

import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.UByte;
import kotlin.UShort;

/* JADX INFO: loaded from: classes.dex */
public class ElfParser implements Closeable, Elf {
    private final int MAGIC;
    private final FileChannel channel;

    public ElfParser(File r2) throws FileNotFoundException {
        this.MAGIC = 1179403647;
        if (r2 == null) goto L9;
        if (r2.exists() == false) goto L9;
        this.channel = new FileInputStream(r2).getChannel();
        return;
    L9:
        throw new IllegalArgumentException("File is null or does not exist");
    }

    public Elf.Header parseHeader() throws IOException {
        this.channel.position(0);
        ByteBuffer r0 = ByteBuffer.allocate(8);
        r0.order(ByteOrder.LITTLE_ENDIAN);
        if (readWord(r0, 0) != 1179403647) goto L17;
        short r1 = readByte(r0, 4);
        if (readByte(r0, 5) != 2) goto L7;
        boolean r2 = true;
    L8:
        if (r1 == 1) goto L10;
        if (r1 != 2) goto L15;
        return new Elf64Header(r2, this);
    L15:
        throw new IllegalStateException("Invalid class type!");
    L10:
        return new Elf32Header(r2, this);
    L7:
        r2 = false;
        goto L8
    L17:
        throw new IllegalArgumentException("Invalid ELF Magic!");
    }

    public List<String> parseNeededDependencies() throws IOException {
        this.channel.position(0);
        ArrayList r7 = new ArrayList();
        Elf.Header r3 = parseHeader();
        ByteBuffer r8 = ByteBuffer.allocate(8);
        if (r3.bigEndian == false) goto L5;
        ByteOrder r0 = ByteOrder.BIG_ENDIAN;
    L6:
        r8.order(r0);
        long r4 = r3.phnum;
        int r9 = 0;
        if (r4 != 65535) goto L9;
        r4 = r3.getSectionHeader(0).info;
    L9:
        long r10 = 0;
    L11:
        if (r10 >= r4) goto L16;
        Elf.ProgramHeader r1 = r3.getProgramHeader(r10);
        if (r1.type == 2) goto L14;
        r10 = r10 + 1;
        goto L11
    L14:
        long r11 = r1.offset;
    L18:
        if (r11 == 0) goto L20;
        ArrayList r14 = new ArrayList();
        long r15 = 0;
    L22:
        Elf.DynamicStructure r2 = r3.getDynamicStructure(r11, r9);
        if (r2.tag != 1) goto L26;
        r14.add(Long.valueOf(r2.val));
    L28:
        r9 = r9 + 1;
        if (r2.tag != 0) goto L22;
        if (r15 == 0) goto L38;
        long r5 = offsetFromVma(r3, r4, r15);
        Iterator r6 = r14.iterator();
    L34:
        if (r6.hasNext() == false) goto L36;
        r7.add(readString(r8, ((Long) r6.next()).longValue() + r5));
        goto L34
    L36:
        return r7;
    L38:
        throw new IllegalStateException("String table offset not found!");
    L26:
        if (r2.tag != 5) goto L28;
        r15 = r2.val;
        goto L28
    L20:
        return Collections.unmodifiableList(r7);
    L16:
        r11 = 0;
        goto L18
    L5:
        r0 = ByteOrder.LITTLE_ENDIAN;
        goto L6
    }

    private long offsetFromVma(Elf.Header r9, long r10, long r12) throws IOException {
        long r0 = 0;
    L4:
        if (r0 >= r10) goto L15;
        Elf.ProgramHeader r8 = r9.getProgramHeader(r0);
        if (r8.type != 1) goto L13;
        if (r8.vaddr > r12) goto L13;
        if (r12 > (r8.vaddr + r8.memsz)) goto L13;
        return (r12 - r8.vaddr) + r8.offset;
    L13:
        r0 = r0 + 1;
        goto L4
    L15:
        throw new IllegalStateException("Could not map vma to file offset!");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.channel.close();
    }

    protected String readString(ByteBuffer r4, long r5) throws IOException {
        StringBuilder r0 = new StringBuilder();
    L3:
        long r1 = 1 + r5;
        short r6 = readByte(r4, r5);
        if (r6 == 0) goto L7;
        r0.append((char) r6);
        r5 = r1;
        goto L3
    L7:
        return r0.toString();
    }

    protected long readLong(ByteBuffer r2, long r3) throws IOException {
        read(r2, r3, 8);
        return r2.getLong();
    }

    protected long readWord(ByteBuffer r2, long r3) throws IOException {
        read(r2, r3, 4);
        return ((long) r2.getInt()) & 4294967295L;
    }

    protected int readHalf(ByteBuffer r2, long r3) throws IOException {
        read(r2, r3, 2);
        return r2.getShort() & UShort.MAX_VALUE;
    }

    protected short readByte(ByteBuffer r2, long r3) throws IOException {
        read(r2, r3, 1);
        return (short) (r2.get() & UByte.MAX_VALUE);
    }

    protected void read(ByteBuffer r7, long r8, int r10) throws IOException {
        r7.position(0);
        r7.limit(r10);
        long r1 = 0;
    L4:
        if (r1 >= r10) goto L10;
        int r3 = this.channel.read(r7, r8 + r1);
        if (r3 == (-1)) goto L9;
        r1 = r1 + ((long) r3);
        goto L4
    L9:
        throw new EOFException();
    L10:
        r7.position(0);
    }
}
