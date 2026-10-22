package com.bumptech.glide.load.data;

import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class ParcelFileDescriptorRewinder implements DataRewinder<ParcelFileDescriptor> {
    private final InternalRewinder rewinder;

    public static final class Factory implements DataRewinder.Factory<ParcelFileDescriptor> {
        @Override // com.bumptech.glide.load.data.DataRewinder.Factory
        public /* bridge */ /* synthetic */ DataRewinder<ParcelFileDescriptor> build(ParcelFileDescriptor r1) {
            return build2(r1);
        }

        public Factory() {
        }

        /* JADX INFO: renamed from: build, reason: avoid collision after fix types in other method */
        public DataRewinder<ParcelFileDescriptor> build2(ParcelFileDescriptor r1) {
            return new ParcelFileDescriptorRewinder(r1);
        }

        @Override // com.bumptech.glide.load.data.DataRewinder.Factory
        public Class<ParcelFileDescriptor> getDataClass() {
            return ParcelFileDescriptor.class;
        }
    }

    private static final class InternalRewinder {
        private final ParcelFileDescriptor parcelFileDescriptor;

        InternalRewinder(ParcelFileDescriptor r1) {
            this.parcelFileDescriptor = r1;
        }

        ParcelFileDescriptor rewind() throws IOException {
            Os.lseek(this.parcelFileDescriptor.getFileDescriptor(), 0, OsConstants.SEEK_SET);     // Catch: ErrnoException -> L5
            return this.parcelFileDescriptor;
        L5:
            e = move-exception;
            throw new IOException(e);
        }
    }

    @Override // com.bumptech.glide.load.data.DataRewinder
    public void cleanup() {
    }

    @Override // com.bumptech.glide.load.data.DataRewinder
    public /* bridge */ /* synthetic */ ParcelFileDescriptor rewindAndGet() throws IOException {
        return rewindAndGet();
    }

    public static boolean isSupported() {
        if ("robolectric".equals(Build.FINGERPRINT) == true) goto L5;
        return true;
    L5:
        return false;
    }

    public ParcelFileDescriptorRewinder(ParcelFileDescriptor r2) {
        this.rewinder = new InternalRewinder(r2);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.load.data.DataRewinder
    public ParcelFileDescriptor rewindAndGet() throws IOException {
        return this.rewinder.rewind();
    }
}
