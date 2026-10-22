package com.google.common.hash;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public interface Hasher extends PrimitiveSink {
    HashCode hash();

    @Deprecated
    int hashCode();

    @Override // com.google.common.hash.PrimitiveSink
    Hasher putBoolean(boolean r1);

    @Override // com.google.common.hash.PrimitiveSink
    Hasher putByte(byte r1);

    @Override // com.google.common.hash.PrimitiveSink
    Hasher putBytes(ByteBuffer r1);

    @Override // com.google.common.hash.PrimitiveSink
    Hasher putBytes(byte[] r1);

    @Override // com.google.common.hash.PrimitiveSink
    Hasher putBytes(byte[] r1, int r2, int r3);

    @Override // com.google.common.hash.PrimitiveSink
    Hasher putChar(char r1);

    @Override // com.google.common.hash.PrimitiveSink
    Hasher putDouble(double r1);

    @Override // com.google.common.hash.PrimitiveSink
    Hasher putFloat(float r1);

    @Override // com.google.common.hash.PrimitiveSink
    Hasher putInt(int r1);

    @Override // com.google.common.hash.PrimitiveSink
    Hasher putLong(long r1);

    <T> Hasher putObject(@ParametricNullness T r1, Funnel<? super T> r2);

    @Override // com.google.common.hash.PrimitiveSink
    Hasher putShort(short r1);

    @Override // com.google.common.hash.PrimitiveSink
    Hasher putString(CharSequence r1, Charset r2);

    @Override // com.google.common.hash.PrimitiveSink
    Hasher putUnencodedChars(CharSequence r1);

    @Override // com.google.common.hash.PrimitiveSink
    /* bridge */ /* synthetic */ default PrimitiveSink putBoolean(boolean r1) {
        return putBoolean(r1);
    }

    @Override // com.google.common.hash.PrimitiveSink
    /* bridge */ /* synthetic */ default PrimitiveSink putByte(byte r1) {
        return putByte(r1);
    }

    @Override // com.google.common.hash.PrimitiveSink
    /* bridge */ /* synthetic */ default PrimitiveSink putBytes(ByteBuffer r1) {
        return putBytes(r1);
    }

    @Override // com.google.common.hash.PrimitiveSink
    /* bridge */ /* synthetic */ default PrimitiveSink putBytes(byte[] r1) {
        return putBytes(r1);
    }

    @Override // com.google.common.hash.PrimitiveSink
    /* bridge */ /* synthetic */ default PrimitiveSink putBytes(byte[] r1, int r2, int r3) {
        return putBytes(r1, r2, r3);
    }

    @Override // com.google.common.hash.PrimitiveSink
    /* bridge */ /* synthetic */ default PrimitiveSink putChar(char r1) {
        return putChar(r1);
    }

    @Override // com.google.common.hash.PrimitiveSink
    /* bridge */ /* synthetic */ default PrimitiveSink putDouble(double r1) {
        return putDouble(r1);
    }

    @Override // com.google.common.hash.PrimitiveSink
    /* bridge */ /* synthetic */ default PrimitiveSink putFloat(float r1) {
        return putFloat(r1);
    }

    @Override // com.google.common.hash.PrimitiveSink
    /* bridge */ /* synthetic */ default PrimitiveSink putInt(int r1) {
        return putInt(r1);
    }

    @Override // com.google.common.hash.PrimitiveSink
    /* bridge */ /* synthetic */ default PrimitiveSink putLong(long r1) {
        return putLong(r1);
    }

    @Override // com.google.common.hash.PrimitiveSink
    /* bridge */ /* synthetic */ default PrimitiveSink putShort(short r1) {
        return putShort(r1);
    }

    @Override // com.google.common.hash.PrimitiveSink
    /* bridge */ /* synthetic */ default PrimitiveSink putString(CharSequence r1, Charset r2) {
        return putString(r1, r2);
    }

    @Override // com.google.common.hash.PrimitiveSink
    /* bridge */ /* synthetic */ default PrimitiveSink putUnencodedChars(CharSequence r1) {
        return putUnencodedChars(r1);
    }
}
