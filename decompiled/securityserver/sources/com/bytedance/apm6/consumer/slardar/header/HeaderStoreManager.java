package com.bytedance.apm6.consumer.slardar.header;

import a.a;
import android.util.Log;
import com.bytedance.apm6.consumer.slardar.DiskEnvironmentHelper;
import com.bytedance.apm6.util.FileUtils;
import com.bytedance.apm6.util.IOUtils;
import com.bytedance.apm6.util.log.Logger;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class HeaderStoreManager {
    private static final long MAX_EXPIRE_TIME = 604800000;
    private static final String SUFFIX = ".bin";
    private File directory;
    private volatile boolean initialized;

    public static class InnerHolder {
        private static final HeaderStoreManager instance = null;

        static {
            instance = new HeaderStoreManager();
        }

        private InnerHolder() {
        }

        public static /* synthetic */ HeaderStoreManager access$000() {
            return instance;
        }
    }

    public HeaderStoreManager() {
    }

    private String getFileName(String r1) {
        return a.j(r1, SUFFIX);
    }

    public static HeaderStoreManager getInstance() {
        return InnerHolder.access$000();
    }

    private synchronized void initialize() {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (this.initialized == false) goto L20;
        monitor-exit(this);
        return;
    L20:
        File r1 = new File(DiskEnvironmentHelper.getWorkingDirectory(), "header");     // Catch: Throwable -> L12
        this.directory = r1;     // Catch: Throwable -> L12
        if (r1.exists() == true) goto L14;
        this.directory.mkdirs();     // Catch: Throwable -> L12
    L14:
        this.initialized = true;     // Catch: Throwable -> L17
        monitor-exit(this);
        return;
    L12:
        th = move-exception;
        Logger.e("APM", "header store init error " + th.toString());     // Catch: Throwable -> L17
        goto L14
    }

    public void deleteExpireFile() {
        initialize();
        File r0 = this.directory;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.listFiles(new AnonymousClass1(this));
    }

    public HeaderInfo getHeaderInfo(String r4) {
        initialize();
        if (this.directory != null) goto L5;
        return null;
    L5:
        byte[] r3 = FileUtils.readFileToByteArray(new File(this.directory, getFileName(r4)));
        if (r3 != null) goto L8;
        return null;
    L8:
        return HeaderUtils.deserialize(r3);
    }

    public void saveHeaderInfo(String r4, HeaderInfo r5) {
        initialize();
        if (this.directory != null) goto L5;
        return;
    L5:
        JSONObject r6 = HeaderUtils.serialize(r5);
        if (r6 != null) goto L8;
        return;
    L8:
        File r1 = new File(this.directory, getFileName(r4));
        FileChannel r3 = null;
        r3 = new FileOutputStream(r1).getChannel();     // Catch: Throwable -> L11
        r3.write(ByteBuffer.wrap(r6.toString().getBytes()));     // Catch: Throwable -> L11
    L10:
        IOUtils.closeQuietly(r3);
        return;
    L11:
        th = move-exception;
        Log.e("APM", "header couldn't write file" + th.getMessage());     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        IOUtils.closeQuietly(r3);
        throw th;
    }
}
