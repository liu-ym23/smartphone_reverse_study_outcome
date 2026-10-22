package d.b.j.e;

import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class i implements Closeable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final FileChannel f13975f;

    public i(File r2) {
        if (r2 == null) goto L9;
        if (r2.exists() == false) goto L9;
        this.f13975f = new FileInputStream(r2).getChannel();
        return;
    L9:
        throw new IllegalArgumentException("File is null or does not exist");
    }

    private long a(d r9, long r10, long r12) {
        long r0 = 0;
    L4:
        if (r0 >= r10) goto L15;
        e r8 = r9.b(r0);
        if (r8.f13968a != 1) goto L13;
        long r2 = r8.f13970c;
        if (r2 > r12) goto L13;
        if (r12 > (r8.f13971d + r2)) goto L13;
        return (r12 - r2) + r8.f13969b;
    L13:
        r0 = r0 + 1;
        goto L4
    L15:
        throw new IllegalStateException("Could not map vma to file offset!");
    }

    protected long A(ByteBuffer r2, long r3) {
        l(r2, r3, 8);
        return r2.getLong();
    }

    protected String C(ByteBuffer r4, long r5) {
        StringBuilder r0 = new StringBuilder();
    L3:
        long r1 = 1 + r5;
        short r6 = s(r4, r5);
        if (r6 == 0) goto L7;
        r0.append((char) r6);
        r5 = r1;
        goto L3
    L7:
        return r0.toString();
    }

    protected long E(ByteBuffer r2, long r3) {
        l(r2, r3, 4);
        return ((long) r2.getInt()) & 4294967295L;
    }

    public d b() {
        this.f13975f.position(0);
        ByteBuffer r0 = ByteBuffer.allocate(8);
        r0.order(ByteOrder.LITTLE_ENDIAN);
        if (E(r0, 0) != 1179403647) goto L17;
        short r1 = s(r0, 4);
        if (s(r0, 5) != 2) goto L7;
        boolean r2 = true;
    L8:
        if (r1 == 1) goto L10;
        if (r1 != 2) goto L15;
        return new h(r2, this);
    L15:
        throw new IllegalStateException("Invalid class type!");
    L10:
        return new g(r2, this);
    L7:
        r2 = false;
        goto L8
    L17:
        throw new IllegalArgumentException("Invalid ELF Magic!");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f13975f.close();
    }

    public List<String> g() {
        this.f13975f.position(0);
        ArrayList r7 = new ArrayList();
        d r3 = b();
        ByteBuffer r8 = ByteBuffer.allocate(8);
        if (r3.f13962a == false) goto L5;
        ByteOrder r0 = ByteOrder.BIG_ENDIAN;
    L6:
        r8.order(r0);
        long r4 = r3.f13966e;
        int r9 = 0;
        if (r4 != 65535) goto L9;
        r4 = r3.c(0).f13972a;
    L9:
        long r10 = 0;
    L11:
        if (r10 >= r4) goto L16;
        e r1 = r3.b(r10);
        if (r1.f13968a == 2) goto L14;
        r10 = r10 + 1;
        goto L11
    L14:
        long r11 = r1.f13969b;
    L18:
        if (r11 == 0) goto L20;
        ArrayList r14 = new ArrayList();
        long r15 = 0;
    L22:
        c r2 = r3.a(r11, r9);
        long r5 = r2.f13960a;
        if (r5 != 1) goto L26;
        r14.add(Long.valueOf(r2.f13961b));
    L28:
        r9 = r9 + 1;
        if (r2.f13960a != 0) goto L22;
        if (r15 == 0) goto L38;
        long r6 = a(r3, r4, r15);
        Iterator r12 = r14.iterator();
    L34:
        if (r12.hasNext() == false) goto L36;
        r7.add(C(r8, ((Long) r12.next()).longValue() + r6));
        goto L34
    L36:
        return r7;
    L38:
        throw new IllegalStateException("String table offset not found!");
    L26:
        if (r5 != 5) goto L28;
        r15 = r2.f13961b;
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

    protected void l(ByteBuffer r7, long r8, int r10) {
        r7.position(0);
        r7.limit(r10);
        long r1 = 0;
    L4:
        if (r1 >= r10) goto L10;
        int r3 = this.f13975f.read(r7, r8 + r1);
        if (r3 == (-1)) goto L9;
        r1 = r1 + ((long) r3);
        goto L4
    L9:
        throw new EOFException();
    L10:
        r7.position(0);
    }

    protected short s(ByteBuffer r2, long r3) {
        l(r2, r3, 1);
        return (short) (r2.get() & 255);
    }

    protected int x(ByteBuffer r2, long r3) {
        l(r2, r3, 2);
        return r2.getShort() & 65535;
    }
}
