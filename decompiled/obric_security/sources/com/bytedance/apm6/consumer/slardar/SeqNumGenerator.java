package com.bytedance.apm6.consumer.slardar;

import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.util.log.Logger;
import com.bytedance.librarian.LibrarianImpl;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/* JADX INFO: loaded from: classes.dex */
public class SeqNumGenerator {
    private MappedByteBuffer byteBuffer;
    private long seqNum;

    private static class InnerHolder {
        private static final SeqNumGenerator instance = null;

        private InnerHolder() {
        }

        static /* synthetic */ SeqNumGenerator access$000() {
            return instance;
        }

        static {
            instance = new SeqNumGenerator();
        }
    }

    public SeqNumGenerator() {
        this.seqNum = 0;
    }

    public static SeqNumGenerator getInstance() {
        return InnerHolder.access$000();
    }

    public long next() {
        if (this.byteBuffer == null) goto L19;
    L13:
        MappedByteBuffer r0 = this.byteBuffer;
        if (r0 == null) goto L17;
        long r4 = r0.getLong(0) + 1;
        this.seqNum = r4;
        this.byteBuffer.putLong(0, r4);
        return this.seqNum;
    L17:
        long r1 = this.seqNum;
        this.seqNum = 1 + r1;
        return r1;
    L19:
        File r2 = new File(DiskEnvironmentHelper.getWorkingDirectory(), ApmContext.getCurrentProcessName().replace(LibrarianImpl.Constants.DOT, "_").replace(":", "-") + "_seq_num.txt");     // Catch: Throwable -> L11
        boolean r3 = r2.exists();     // Catch: Throwable -> L11
        if (r3 == true) goto L7;
        r2.createNewFile();     // Catch: Throwable -> L11
    L7:
        MappedByteBuffer r5 = new RandomAccessFile(r2, "rw").getChannel().map(FileChannel.MapMode.READ_WRITE, 0, 8);     // Catch: Throwable -> L11
        this.byteBuffer = r5;     // Catch: Throwable -> L11
        if (r3 == true) goto L13;
        r5.putLong(0, 0);     // Catch: Throwable -> L11
        return 0;
    L11:
        th = move-exception;
        Logger.e(Constants.TAG, "prepare seq_number fail.", th);
        goto L13
    }
}
