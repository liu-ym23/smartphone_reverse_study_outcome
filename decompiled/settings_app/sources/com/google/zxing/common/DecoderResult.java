package com.google.zxing.common;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class DecoderResult {
    private final List<byte[]> byteSegments;
    private final String ecLevel;
    private Integer erasures;
    private Integer errorsCorrected;
    private int numBits;
    private Object other;
    private final byte[] rawBytes;
    private final int structuredAppendParity;
    private final int structuredAppendSequenceNumber;
    private final String text;

    public DecoderResult(byte[] r8, String r9, List<byte[]> r10, String r11) {
        this(r8, r9, r10, r11, -1, -1);
    }

    public DecoderResult(byte[] r1, String r2, List<byte[]> r3, String r4, int r5, int r6) {
        this.rawBytes = r1;
        if (r1 != null) goto L5;
        int r7 = 0;
    L6:
        this.numBits = r7;
        this.text = r2;
        this.byteSegments = r3;
        this.ecLevel = r4;
        this.structuredAppendParity = r6;
        this.structuredAppendSequenceNumber = r5;
        return;
    L5:
        r7 = r1.length * 8;
        goto L6
    }

    public byte[] getRawBytes() {
        return this.rawBytes;
    }

    public int getNumBits() {
        return this.numBits;
    }

    public void setNumBits(int r1) {
        this.numBits = r1;
    }

    public String getText() {
        return this.text;
    }

    public List<byte[]> getByteSegments() {
        return this.byteSegments;
    }

    public String getECLevel() {
        return this.ecLevel;
    }

    public Integer getErrorsCorrected() {
        return this.errorsCorrected;
    }

    public void setErrorsCorrected(Integer r1) {
        this.errorsCorrected = r1;
    }

    public Integer getErasures() {
        return this.erasures;
    }

    public void setErasures(Integer r1) {
        this.erasures = r1;
    }

    public Object getOther() {
        return this.other;
    }

    public void setOther(Object r1) {
        this.other = r1;
    }

    public boolean hasStructuredAppend() {
        if (this.structuredAppendParity >= 0) goto L5;
        return false;
    L5:
        if (this.structuredAppendSequenceNumber < 0) goto L10;
        return true;
    L10:
        return false;
    }

    public int getStructuredAppendParity() {
        return this.structuredAppendParity;
    }

    public int getStructuredAppendSequenceNumber() {
        return this.structuredAppendSequenceNumber;
    }
}
