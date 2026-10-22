package com.obric.cae.libs.useraware;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.SharedMemory;
import android.system.OsConstants;
import android.util.Log;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class HarShmPacketsReader {
    public ByteBuffer a;
    public SharedMemory b;

    public HarShmPacketsReader() {
    }

    public static int getSingleBufferSize() {
        return 65536;
    }

    public void closeShm() {
        ByteBuffer r0 = this.a;
        if (r0 == null) goto L5;
        SharedMemory.unmap(r0);
        this.a = null;
    L5:
        SharedMemory r1 = this.b;
        if (r1 == null) goto L9;
        r1.close();
        this.b = null;
        return;
    }

    public ByteBuffer getHarShmMappedBuffer() {
        return this.a;
    }

    public boolean openShm(ParcelFileDescriptor r4) {
        this.b = SharedMemory.fromFileDescriptor(r4);     // Catch: Throwable -> L6
        r4.close();     // Catch: Throwable -> L6
        SharedMemory r5 = this.b;     // Catch: Throwable -> L6
        this.a = r5.map(OsConstants.PROT_READ, 0, r5.getSize());     // Catch: Throwable -> L6
        return true;
    L6:
        e = move-exception;
        this.a = null;
        e.printStackTrace();
        return false;
    }

    public List<UnifiedDataPacket> processDataBatch(ByteBuffer r8, int r9, int r10) {
        int r11 = r9 * 65536;
        ArrayList r0 = new ArrayList();
        int r2 = 0;
    L3:
        if (r2 >= r10) goto L24;
        r8.position(r11 + r2);
        if (r8.remaining() < 4) goto L6;
        int r3 = r8.getInt();
        if (r3 <= 0) goto L23;
        if (r3 > 65536) goto L23;
        if (r8.remaining() < r3) goto L13;
        byte[] r4 = new byte[r3];
        r8.get(r4);
        Parcelable.Creator<UnifiedDataPacket> r5 = UnifiedDataPacket.CREATOR;
        Parcel r6 = Parcel.obtain();
        r6.unmarshall(r4, 0, r3);     // Catch: Throwable -> L20
        r6.setDataPosition(0);     // Catch: Throwable -> L20
        UnifiedDataPacket r7 = r5.createFromParcel(r6);     // Catch: Throwable -> L20
        r6.recycle();
        UnifiedDataPacket r12 = r7;
        if (r12 == null) goto L19;
        r0.add(r12);
    L19:
        r2 = r2 + (r3 + 4);
    L20:
        th = move-exception;
        r6.recycle();
        throw th;
    L13:
        Log.e("HarShmPacketsReader", "Buffer underflow when reading packet data. Declared length: " + r3);
    L23:
        Log.e("HarShmPacketsReader", "Invalid packet length detected: " + r3);
        goto L24
    L6:
        Log.e("HarShmPacketsReader", "Buffer underflow when reading packet length.");
    L24:
        return r0;
    }
}
