package org.threeten.bp.zone;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.Externalizable;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.StreamCorruptedException;
import org.threeten.bp.ZoneOffset;

/* JADX INFO: loaded from: classes6.dex */
final class Ser implements Externalizable {
    static final byte SZR = 1;
    static final byte ZOT = 2;
    static final byte ZOTRULE = 3;
    private static final long serialVersionUID = -8885321777449118786L;
    private Object object;
    private byte type;

    public Ser() {
    }

    Ser(byte r1, Object r2) {
        this.type = r1;
        this.object = r2;
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput r2) throws IOException {
        writeInternal(this.type, this.object, r2);
    }

    static void write(Object r1, DataOutput r2) throws IOException {
        writeInternal((byte) 1, r1, r2);
    }

    private static void writeInternal(byte r1, Object r2, DataOutput r3) throws IOException {
        r3.writeByte(r1);
        if (r1 != 1) goto L5;
        ((StandardZoneRules) r2).writeExternal(r3);
        return;
    L5:
        if (r1 != 2) goto L7;
        ((ZoneOffsetTransition) r2).writeExternal(r3);
        return;
    L7:
        if (r1 != 3) goto L10;
        ((ZoneOffsetTransitionRule) r2).writeExternal(r3);
        return;
    L10:
        throw new InvalidClassException("Unknown serialized type");
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput r2) throws IOException, ClassNotFoundException {
        byte r0 = r2.readByte();
        this.type = r0;
        this.object = readInternal(r0, r2);
    }

    static Object read(DataInput r1) throws IOException, ClassNotFoundException {
        return readInternal(r1.readByte(), r1);
    }

    private static Object readInternal(byte r1, DataInput r2) throws IOException, ClassNotFoundException {
        if (r1 == 1) goto L15;
        if (r1 == 2) goto L13;
        if (r1 != 3) goto L11;
        return ZoneOffsetTransitionRule.readExternal(r2);
    L11:
        throw new StreamCorruptedException("Unknown serialized type");
    L13:
        return ZoneOffsetTransition.readExternal(r2);
    L15:
        return StandardZoneRules.readExternal(r2);
    }

    private Object readResolve() {
        return this.object;
    }

    static void writeOffset(ZoneOffset r2, DataOutput r3) throws IOException {
        int r4 = r2.getTotalSeconds();
        if ((r4 % 900) != 0) goto L5;
        int r0 = r4 / 900;
    L6:
        r3.writeByte(r0);
        if (r0 != 127) goto L10;
        r3.writeInt(r4);
        return;
    L10:
        return;
    L5:
        r0 = 127;
        goto L6
    }

    static ZoneOffset readOffset(DataInput r2) throws IOException {
        byte r0 = r2.readByte();
        if (r0 != 127) goto L6;
        return ZoneOffset.ofTotalSeconds(r2.readInt());
    L6:
        return ZoneOffset.ofTotalSeconds(r0 * 900);
    }

    static void writeEpochSec(long r8, DataOutput r10) throws IOException {
        if (r8 >= (-4575744000L)) goto L5;
    L9:
        r10.writeByte(255);
        r10.writeLong(r8);
        return;
    L5:
        if (r8 >= 10413792000L) goto L9;
        if ((r8 % 900) != 0) goto L9;
        int r9 = (int) ((r8 + 4575744000L) / 900);
        r10.writeByte((r9 >>> 16) & 255);
        r10.writeByte((r9 >>> 8) & 255);
        r10.writeByte(r9 & 255);
    }

    static long readEpochSec(DataInput r4) throws IOException {
        int r0 = r4.readByte() & 255;
        if (r0 == 255) goto L5;
        int r2 = r4.readByte() & 255;
        int r1 = (r0 << 16) + (r2 << 8);
        return (((long) (r1 + (r4.readByte() & 255))) * 900) - 4575744000L;
    L5:
        return r4.readLong();
    }
}
