package com.google.zxing.datamatrix.encoder;

import com.google.zxing.Dimension;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes4.dex */
final class EncoderContext {
    private final StringBuilder codewords;
    private Dimension maxSize;
    private Dimension minSize;
    private final String msg;
    private int newEncoding;
    int pos;
    private SymbolShapeHint shape;
    private int skipAtEnd;
    private SymbolInfo symbolInfo;

    EncoderContext(String r8) {
        byte[] r0 = r8.getBytes(StandardCharsets.ISO_8859_1);
        StringBuilder r1 = new StringBuilder(r0.length);
        int r2 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L12;
        char r4 = (char) (r0[r3] & 255);
        if (r4 != '?') goto L11;
        if (r8.charAt(r3) == '?') goto L11;
        throw new IllegalArgumentException("Message contains characters outside ISO-8859-1 encoding.");
    L11:
        r1.append(r4);
        r3 = r3 + 1;
        goto L3
    L12:
        this.msg = r1.toString();
        this.shape = SymbolShapeHint.FORCE_NONE;
        this.codewords = new StringBuilder(r8.length());
        this.newEncoding = -1;
    }

    public void setSymbolShape(SymbolShapeHint r1) {
        this.shape = r1;
    }

    public void setSizeConstraints(Dimension r1, Dimension r2) {
        this.minSize = r1;
        this.maxSize = r2;
    }

    public String getMessage() {
        return this.msg;
    }

    public void setSkipAtEnd(int r1) {
        this.skipAtEnd = r1;
    }

    public char getCurrentChar() {
        return this.msg.charAt(this.pos);
    }

    public char getCurrent() {
        return this.msg.charAt(this.pos);
    }

    public StringBuilder getCodewords() {
        return this.codewords;
    }

    public void writeCodewords(String r1) {
        this.codewords.append(r1);
    }

    public void writeCodeword(char r1) {
        this.codewords.append(r1);
    }

    public int getCodewordCount() {
        return this.codewords.length();
    }

    public int getNewEncoding() {
        return this.newEncoding;
    }

    public void signalEncoderChange(int r1) {
        this.newEncoding = r1;
    }

    public void resetEncoderSignal() {
        this.newEncoding = -1;
    }

    public boolean hasMoreCharacters() {
        if (this.pos >= getTotalMessageCharCount()) goto L6;
        return true;
    L6:
        return false;
    }

    private int getTotalMessageCharCount() {
        return this.msg.length() - this.skipAtEnd;
    }

    public int getRemainingCharacters() {
        return getTotalMessageCharCount() - this.pos;
    }

    public SymbolInfo getSymbolInfo() {
        return this.symbolInfo;
    }

    public void updateSymbolInfo() {
        updateSymbolInfo(getCodewordCount());
    }

    public void updateSymbolInfo(int r5) {
        SymbolInfo r0 = this.symbolInfo;
        if (r0 != null) goto L5;
    L6:
        this.symbolInfo = SymbolInfo.lookup(r5, this.shape, this.minSize, this.maxSize, true);
        return;
    L5:
        if (r5 > r0.getDataCapacity()) goto L6;
    }

    public void resetSymbolInfo() {
        this.symbolInfo = null;
    }
}
