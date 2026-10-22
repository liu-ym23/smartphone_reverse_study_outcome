package com.bumptech.glide.gifdecoder;

import android.util.Log;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class GifHeaderParser {
    static final int DEFAULT_FRAME_DELAY = 10;
    private static final int DESCRIPTOR_MASK_INTERLACE_FLAG = 64;
    private static final int DESCRIPTOR_MASK_LCT_FLAG = 128;
    private static final int DESCRIPTOR_MASK_LCT_SIZE = 7;
    private static final int EXTENSION_INTRODUCER = 33;
    private static final int GCE_DISPOSAL_METHOD_SHIFT = 2;
    private static final int GCE_MASK_DISPOSAL_METHOD = 28;
    private static final int GCE_MASK_TRANSPARENT_COLOR_FLAG = 1;
    private static final int IMAGE_SEPARATOR = 44;
    private static final int LABEL_APPLICATION_EXTENSION = 255;
    private static final int LABEL_COMMENT_EXTENSION = 254;
    private static final int LABEL_GRAPHIC_CONTROL_EXTENSION = 249;
    private static final int LABEL_PLAIN_TEXT_EXTENSION = 1;
    private static final int LSD_MASK_GCT_FLAG = 128;
    private static final int LSD_MASK_GCT_SIZE = 7;
    private static final int MASK_INT_LOWEST_BYTE = 255;
    private static final int MAX_BLOCK_SIZE = 256;
    static final int MIN_FRAME_DELAY = 2;
    private static final String TAG = "GifHeaderParser";
    private static final int TRAILER = 59;
    private final byte[] block;
    private int blockSize;
    private GifHeader header;
    private ByteBuffer rawData;

    public GifHeaderParser() {
        this.block = new byte[256];
        this.blockSize = 0;
    }

    public GifHeaderParser setData(ByteBuffer r2) {
        reset();
        ByteBuffer r3 = r2.asReadOnlyBuffer();
        this.rawData = r3;
        r3.position(0);
        this.rawData.order(ByteOrder.LITTLE_ENDIAN);
        return this;
    }

    public GifHeaderParser setData(byte[] r2) {
        if (r2 == null) goto L4;
        setData(ByteBuffer.wrap(r2));
    L5:
        return this;
    L4:
        this.rawData = null;
        this.header.status = 2;
        goto L5
    }

    public void clear() {
        this.rawData = null;
        this.header = null;
    }

    private void reset() {
        this.rawData = null;
        Arrays.fill(this.block, (byte) 0);
        this.header = new GifHeader();
        this.blockSize = 0;
    }

    public GifHeader parseHeader() {
        if (this.rawData == null) goto L16;
        if (err() == true) goto L7;
        readHeader();
        if (err() == true) goto L14;
        readContents();
        if (this.header.frameCount >= 0) goto L14;
        this.header.status = 1;
    L14:
        return this.header;
    L7:
        return this.header;
    L16:
        throw new IllegalStateException("You must call setData() before parseHeader()");
    }

    public boolean isAnimated() {
        readHeader();
        if (err() == true) goto L6;
        readContents(2);
    L6:
        if (this.header.frameCount > 1) goto L10;
        return false;
    L10:
        return true;
    }

    private void readContents() {
        readContents(Integer.MAX_VALUE);
    }

    private void readContents(int r6) {
        boolean r1 = false;
    L3:
        if (r1 == true) goto L40;
        if (err() == true) goto L71;
        if (this.header.frameCount > r6) goto L72;
        int r2 = read();
        if (r2 != 33) goto L11;
        int r3 = read();
        if (r3 != 1) goto L23;
        skip();
        goto L3
    L23:
        if (r3 != 249) goto L25;
        this.header.currentFrame = new GifFrame();
        readGraphicControlExt();
        goto L3
    L25:
        if (r3 != 254) goto L27;
        skip();
        goto L3
    L27:
        if (r3 != 255) goto L28;
        readBlock();
        StringBuilder r4 = new StringBuilder();
        int r5 = 0;
    L31:
        if (r5 >= 11) goto L34;
        r4.append((char) this.block[r5]);
        r5 = r5 + 1;
        goto L31
    L34:
        if (r4.toString().equals("NETSCAPE2.0") == true) goto L35;
        skip();
        goto L3
    L35:
        readNetscapeExt();
        goto L3
    L28:
        skip();
        goto L3
    L11:
        if (r2 != 44) goto L13;
        if (this.header.currentFrame != null) goto L19;
        this.header.currentFrame = new GifFrame();
    L19:
        readBitmap();
        goto L3
    L13:
        if (r2 != 59) goto L14;
        r1 = true;
        goto L3
    L14:
        this.header.status = 1;
        goto L3
    L72:
        return;
    L71:
        return;
    }

    private void readGraphicControlExt() {
        read();
        int r0 = read();
        this.header.currentFrame.dispose = (r0 & 28) >> 2;
        boolean r2 = true;
        if (this.header.currentFrame.dispose != 0) goto L5;
        this.header.currentFrame.dispose = 1;
    L5:
        GifFrame r1 = this.header.currentFrame;
        if ((r0 & 1) != 0) goto L9;
        r2 = false;
    L9:
        r1.transparency = r2;
        int r3 = readShort();
        if (r3 >= 2) goto L12;
        r3 = 10;
    L12:
        this.header.currentFrame.delay = r3 * 10;
        this.header.currentFrame.transIndex = read();
        read();
    }

    private void readBitmap() {
        this.header.currentFrame.ix = readShort();
        this.header.currentFrame.iy = readShort();
        this.header.currentFrame.iw = readShort();
        this.header.currentFrame.ih = readShort();
        int r0 = read();
        boolean r2 = false;
        if ((r0 & 128) == 0) goto L5;
        boolean r1 = true;
    L6:
        int r4 = (int) Math.pow(2.0d, (r0 & 7) + 1);
        GifFrame r5 = this.header.currentFrame;
        if ((r0 & 64) == 0) goto L9;
        r2 = true;
    L9:
        r5.interlace = r2;
        if (r1 == false) goto L12;
        this.header.currentFrame.lct = readColorTable(r4);
    L13:
        this.header.currentFrame.bufferFrameStart = this.rawData.position();
        skipImageData();
        if (err() == false) goto L16;
        return;
    L16:
        this.header.frameCount++;
        this.header.frames.add(this.header.currentFrame);
        return;
    L12:
        this.header.currentFrame.lct = null;
        goto L13
    L5:
        r1 = false;
        goto L6
    }

    private void readNetscapeExt() {
    L2:
        readBlock();
        byte[] r0 = this.block;
        if (r0[0] != 1) goto L6;
        int r1 = r0[1] & 255;
        int r2 = r0[2] & 255;
        int r3 = (r2 << 8) | r1;
        this.header.loopCount = r3;
    L6:
        if (this.blockSize <= 0) goto L9;
        if (err() == false) goto L2;
        return;
    }

    private void readHeader() {
        StringBuilder r0 = new StringBuilder();
        int r1 = 0;
    L4:
        if (r1 >= 6) goto L7;
        r0.append((char) read());
        r1 = r1 + 1;
        goto L4
    L7:
        if (r0.toString().startsWith("GIF") == true) goto L10;
        this.header.status = 1;
        return;
    L10:
        readLSD();
        if (this.header.gctFlag == true) goto L13;
        return;
    L13:
        if (err() == true) goto L18;
        GifHeader r2 = this.header;
        r2.gct = readColorTable(r2.gctSize);
        GifHeader r3 = this.header;
        r3.bgColor = r3.gct[this.header.bgIndex];
        return;
    }

    private void readLSD() {
        this.header.width = readShort();
        this.header.height = readShort();
        int r0 = read();
        GifHeader r1 = this.header;
        if ((r0 & 128) == 0) goto L5;
        boolean r2 = true;
    L6:
        r1.gctFlag = r2;
        this.header.gctSize = (int) Math.pow(2.0d, (r0 & 7) + 1);
        this.header.bgIndex = read();
        this.header.pixelAspect = read();
        return;
    L5:
        r2 = false;
        goto L6
    }

    private int[] readColorTable(int r10) {
        byte[] r0 = new byte[r10 * 3];
        int[] r1 = null;
        this.rawData.get(r0);     // Catch: BufferUnderflowException -> L7
        r1 = new int[256];     // Catch: BufferUnderflowException -> L7
        int r2 = 0;
        int r3 = 0;
    L4:
        if (r2 >= r10) goto L12;
        int r4 = r3 + 1;     // Catch: BufferUnderflowException -> L7
        int r5 = r4 + 1;     // Catch: BufferUnderflowException -> L7
        int r6 = r5 + 1;     // Catch: BufferUnderflowException -> L7
        int r7 = r2 + 1;     // Catch: BufferUnderflowException -> L7
        r1[r2] = ((((r0[r3] & 255) << 16) | (-16777216)) | ((r0[r4] & 255) << 8)) | (r0[r5] & 255);     // Catch: BufferUnderflowException -> L7
        r3 = r6;
        r2 = r7;
    L12:
        return r1;
    L7:
        e = move-exception;
        if (Log.isLoggable(TAG, 3) == false) goto L11;
        Log.d(TAG, "Format Error Reading Color Table", e);
    L11:
        this.header.status = 1;
        goto L12
    }

    private void skipImageData() {
        read();
        skip();
    }

    private void skip() {
    L2:
        int r0 = read();
        int r1 = Math.min(this.rawData.position() + r0, this.rawData.limit());
        this.rawData.position(r1);
        if (r0 > 0) goto L2;
    }

    private void readBlock() {
        int r0 = read();
        this.blockSize = r0;
        if (r0 <= 0) goto L18;
        int r1 = 0;
        int r2 = 0;
    L15:
        int r3 = this.blockSize;     // Catch: Exception -> L9
        if (r1 >= r3) goto L19;
        r2 = r3 - r1;     // Catch: Exception -> L9
        this.rawData.get(this.block, r1, r2);     // Catch: Exception -> L9
        r1 = r1 + r2;
        goto L15
    L19:
        return;
    L9:
        e = move-exception;
        if (Log.isLoggable(TAG, 3) == false) goto L13;
        Log.d(TAG, "Error Reading Block n: " + r1 + " count: " + r2 + " blockSize: " + this.blockSize, e);
    L13:
        this.header.status = 1;
        return;
    }

    private int read() {
        return this.rawData.get() & 255;
    L4:
        this.header.status = 1;
        return 0;
    }

    private int readShort() {
        return this.rawData.getShort();
    }

    private boolean err() {
        if (this.header.status == 0) goto L5;
        return true;
    L5:
        return false;
    }
}
