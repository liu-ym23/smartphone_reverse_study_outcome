package com.bytedance.common.wschannel.server;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.utils.DiskStorageUtils;
import com.bytedance.common.wschannel.utils.Utils;
import com.bytedance.common.wschannel.utils.WsAsyncIOTaskManager;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class FrontierPersistentBuffer {
    private static final int BYTEBUFFER_CREATED_FAILED = 5;
    private static final int BYTEBUFFER_INIT_SUCCESS = 4;
    private static final int DATA_ITEM_SIZE = 40;
    public static final short FILE_VERSION = 1;
    private static final int HEADER_SIZE = 12;
    public static final short MAGIC_NUMBER = 2114;
    private static final int MAX_DATA_SIZE = 262144;
    private static final int MESSAGE_DROP_SUCCESS = 0;
    private static final int MESSAGE_ID_LENGTH = 32;
    private static final int MESSAGE_PERSISTENT_ERROR = 1;
    private static final int REMOVE_EXPIRED_CACHE = 2;
    private static final int REMOVE_EXPIRED_CACHE_INTERVAL_MS = 3600000;
    private static final int REMOVE_TOTAL_COUNT_AVAILABLE = 3;
    private static final String TAG = "FrontierPersistentBuffer";
    private static final int TIMESTAMP_LENGTH = 8;
    private static final int TOTAL_BYTES_THRESHOLD = 262104;
    private static final int TOTAL_COUNT_AVAILABLE = 1092;
    private static final int TOTAL_COUNT_THRESHOLD = 6553;
    private PriorityQueue<Integer> mAvailableOffsetQueue;
    private MappedByteBuffer mByteBuffer;
    private final AtomicBoolean mFrontierBufferInitFailed;
    private ConcurrentHashMap<String, MessageContent> mMessageIdStorageMap;
    private byte[] sNullData;

    static class MessageContent {
        private int mOffset;
        private long mTimeStamp;

        public MessageContent(long r1, int r3) {
            this.mTimeStamp = r1;
            this.mOffset = r3;
        }

        public long getTimeStamp() {
            return this.mTimeStamp;
        }

        public int getOffset() {
            return this.mOffset;
        }

        public void setOffset(int r1) {
            this.mOffset = r1;
        }
    }

    static {
    }

    static /* synthetic */ AtomicBoolean access$000(FrontierPersistentBuffer r0) {
        return r0.mFrontierBufferInitFailed;
    }

    static /* synthetic */ void access$100(FrontierPersistentBuffer r0) {
        r0.removeExpiredCachedData();
    }

    static /* synthetic */ void access$200(FrontierPersistentBuffer r0, String r1, int r2, long r3) {
        r0.reportPersistentBufferLog(r1, r2, r3);
    }

    static /* synthetic */ int access$300(FrontierPersistentBuffer r0, String r1, long r2) {
        return r0.mapToFile(r1, r2);
    }

    static /* synthetic */ ConcurrentHashMap access$400(FrontierPersistentBuffer r0) {
        return r0.mMessageIdStorageMap;
    }

    static /* synthetic */ String access$500() {
        return TAG;
    }

    static /* synthetic */ void access$600(FrontierPersistentBuffer r0, int r1) {
        r0.removeMessageFromFileByOffset(r1);
    }

    static /* synthetic */ void access$700(FrontierPersistentBuffer r0) {
        r0.flush();
    }

    public FrontierPersistentBuffer(Context r13) {
        this.sNullData = new byte[40];
        this.mAvailableOffsetQueue = new PriorityQueue();
        this.mMessageIdStorageMap = new ConcurrentHashMap();
        this.mFrontierBufferInitFailed = new AtomicBoolean(false);
        FileLock r1 = null;
        long r2 = System.currentTimeMillis();     // Catch: Throwable -> L23
        FileChannel r14 = new RandomAccessFile(DiskStorageUtils.getPersistentFile(r13), "rw").getChannel();     // Catch: Throwable -> L23
        FileLock r4 = r14.tryLock();     // Catch: Throwable -> L21
        this.mByteBuffer = r14.map(FileChannel.MapMode.READ_WRITE, 0, 262144);     // Catch: Throwable -> L19
        if (Logger.debug() == false) goto L9;
        Logger.d(TAG, "magic number: " + getMagicNumber() + " file version: " + getFileVersion() + " total count: " + getTotalCount() + " total bytes: " + getTotalBytes());     // Catch: Throwable -> L19
    L9:
        if (getMagicNumber() == 2114) goto L11;
    L16:
        reset();     // Catch: Throwable -> L19
    L17:
        final long r7 = 3600000;
        final long r9 = 3600000;
        WsAsyncIOTaskManager.getInstance().postTask(new AnonymousClass1(this, r7, r9));     // Catch: Throwable -> L19
        reportPersistentBufferLog(null, 4, System.currentTimeMillis() - r2);     // Catch: Throwable -> L19
        return;
    L11:
        if (getTotalBytes() <= 0) goto L16;
        if (getTotalCount() <= 0) goto L16;
        initPersistentBuffer();     // Catch: Throwable -> L19
    L19:
        th = th;
        r1 = r4;
    L25:
        Logger.e(TAG, "create MappedByteBuffer failed: ", th);
        this.mFrontierBufferInitFailed.set(true);
        reportByteBufferCreatedError(5, th);
        if (r1 != null) goto L32;
    L28:
        if (r14 == null) goto L40;
        r14.close();     // Catch: IOException -> L31
        return;
    L42:
        return;
    L40:
        return;
    L32:
        r1.release();     // Catch: IOException -> L31
    L21:
        th = th;
    L23:
        th = th;
        r14 = null;
        goto L25
    }

    public void initFinished() {
        FrontierMessageManager.setPersistentBufferInitFinished();
    }

    private void initPersistentBuffer() {
        this.mByteBuffer.position(12);
        long r0 = System.currentTimeMillis();
        int r2 = getTotalBytes() / 40;
        int r3 = 0;
        boolean r4 = false;
    L3:
        if (r3 >= r2) goto L19;
        byte[] r5 = new byte[32];
        this.mByteBuffer.get(r5);
        long r6 = this.mByteBuffer.getLong();
        if (isEmptyData(r5) == false) goto L11;
        if (Logger.debug() == false) goto L9;
        Logger.d(TAG, "Data is empty, bypass remove offset:" + r3);
    L9:
        this.mAvailableOffsetQueue.add(Integer.valueOf(r3));
    L18:
        r3 = r3 + 1;
        goto L3
    L11:
        if (r6 >= r0) goto L15;
        removeMessageFromFileByOffset(r3);
        if (r4 == true) goto L18;
        r4 = true;
        goto L18
    L15:
        String r8 = new String(r5, StandardCharsets.UTF_8);
        MessageContent r9 = new MessageContent(r6, r3);
        this.mMessageIdStorageMap.put(r8, r9);
        if (Logger.debug() == false) goto L18;
        Logger.d(TAG, "initPersistentBuffer item: " + new String(r5) + "&" + r9.getTimeStamp() + "_" + r9.getOffset());
        goto L18
    L19:
        if (r4 == false) goto L22;
        flush();
    L22:
        if (Logger.debug() == false) goto L31;
        Logger.d(TAG, "map size:" + this.mMessageIdStorageMap.size() + " total count:" + getTotalCount() + " data size:" + r2 + " total bytes:" + getTotalBytes());
        return;
    }

    private boolean isEmptyData(byte[] r4) {
        if (r4 != null) goto L5;
    L14:
        return true;
    L5:
        if (r4.length == 0) goto L14;
        int r1 = 0;
    L9:
        if (r1 >= r4.length) goto L14;
        if (r4[r1] != 0) goto L12;
        r1 = r1 + 1;
        goto L9
    L12:
        return false;
    }

    private short getMagicNumber() {
        return this.mByteBuffer.getShort(0);
    }

    private long getFileVersion() {
        return this.mByteBuffer.getShort(2);
    }

    private int getTotalCount() {
        return this.mByteBuffer.getInt(4);
    }

    private void setTotalCount(int r2) {
        this.mByteBuffer.putInt(4, r2);
    }

    private int getTotalBytes() {
        return this.mByteBuffer.getInt(8);
    }

    private void setTotalBytes(int r2) {
        this.mByteBuffer.putInt(8, r2);
    }

    private void reset() {
        Logger.i(TAG, "reset");
        this.mByteBuffer.clear();
        this.mByteBuffer.putShort(MAGIC_NUMBER);
        this.mByteBuffer.putShort(1);
        this.mByteBuffer.putInt(0);
        this.mByteBuffer.putInt(0);
    }

    private void reportByteBufferCreatedError(int r2, Throwable r3) {
        JSONObject r1 = new JSONObject();
        r1.put("action", r2);     // Catch: JSONException -> L10
        String r4 = Utils.outputThrowableStackTrace(r3);     // Catch: JSONException -> L10
        if (TextUtils.isEmpty(r4) == false) goto L6;
    L8:
        r1.put("exception", r4);     // Catch: JSONException -> L10
    L12:
        FrontierMessageManager.reportFrontierMessageLog(r1);
        return;
    L6:
        if (r4.length() <= 2048) goto L8;
        r4 = r4.substring(0, 2048);     // Catch: JSONException -> L10
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L12
    }

    private void reportPersistentBufferLog(String r7, int r8, long r9) {
        int r0 = this.mMessageIdStorageMap.size();
        int r1 = this.mAvailableOffsetQueue.size();
        int r2 = getTotalCount();
        int r6 = getTotalBytes();
        JSONObject r3 = new JSONObject();
    L11:
        e = move-exception;
        e.printStackTrace();
    L13:
        FrontierMessageManager.reportFrontierMessageLog(r3);
        return;
    L4:
        if (TextUtils.isEmpty(r7) == true) goto L7;
        r3.put("messageId", r7);     // Catch: JSONException -> L11
    L7:
        if (r9 < 0) goto L9;
        r3.put("duration", r9);     // Catch: JSONException -> L11
    L9:
        r3.put("action", r8);     // Catch: JSONException -> L11
        r3.put("mapSize", r0);     // Catch: JSONException -> L11
        r3.put("queueSize", r1);     // Catch: JSONException -> L11
        r3.put("totalCount", r2);     // Catch: JSONException -> L11
        r3.put("totalBytes", r6);     // Catch: JSONException -> L11
        goto L13
    }

    public boolean shouldDropMessageAndUpdateFile(final String r5, long r6) {
        if (this.mFrontierBufferInitFailed.get() == false) goto L6;
        return false;
    L6:
        if (this.mMessageIdStorageMap.containsKey(r5) == false) goto L9;
        Logger.i(TAG, "Drop existed messageId:" + r5);
        WsAsyncIOTaskManager.getInstance().postTask(new AnonymousClass2(this, r5));
        return true;
    L9:
        final long r2 = System.currentTimeMillis() + r6;
        this.mMessageIdStorageMap.put(r5, new MessageContent(r2, -1));
        WsAsyncIOTaskManager.getInstance().postTask(new AnonymousClass3(this, r5, r2));
        return false;
    }

    public void ackMessage(String[] r7) {
        if (Logger.debug() == false) goto L6;
        Logger.d(TAG, "ack message id: " + Arrays.toString(r7));
    L6:
        if (this.mFrontierBufferInitFailed.get() == true) goto L36;
        if (r7 != null) goto L9;
        return;
    L9:
        if (r7.length == 0) goto L38;
        final ArrayList r0 = new ArrayList();
        int r1 = r7.length;
        int r2 = 0;
    L12:
        if (r2 >= r1) goto L25;
        String r3 = r7[r2];
        if (TextUtils.isEmpty(r3) == true) goto L23;
    L21:
        e = move-exception;
        e.printStackTrace();
        goto L23
    L17:
        if (r3.getBytes("UTF-8").length != 32) goto L23;
        r0.add(r3);     // Catch: UnsupportedEncodingException -> L21
    L23:
        r2 = r2 + 1;
        goto L12
    L25:
        if (r0.isEmpty() == false) goto L27;
        return;
    L27:
        WsAsyncIOTaskManager.getInstance().postTask(new AnonymousClass4(this, r0));
        return;
    L38:
        return;
    }

    private void removeMessageFromFileByOffset(int r4) {
        if (r4 >= 0) goto L4;
        return;
    L4:
        this.mByteBuffer.position((r4 * 40) + 12);
        this.mByteBuffer.put(this.sNullData);
        setTotalCount(getTotalCount() - 1);
        this.mAvailableOffsetQueue.add(Integer.valueOf(r4));
        if (Logger.debug() == false) goto L8;
        Logger.d(TAG, String.format("remove success: offset=%s, totalCount=%s, totalBytes=%s", new Object[]{Integer.valueOf(r4), Integer.valueOf(getTotalCount()), Integer.valueOf(getTotalBytes())}));
        return;
    }

    private int pushMessageInAvailableSlot(byte[] r4, long r5) {
        if (this.mAvailableOffsetQueue.isEmpty() == false) goto L6;
        return -1;
    L6:
        int r0 = this.mAvailableOffsetQueue.poll().intValue();
        this.mByteBuffer.position((r0 * 40) + 12);
        this.mByteBuffer.put(r4);
        this.mByteBuffer.putLong(r5);
        setTotalCount(getTotalCount() + 1);
        if (Logger.debug() == false) goto L9;
        Logger.d(TAG, String.format("push success in queue: offset=%s, totalCount=%s, totalBytes=%s, logItem=%s", new Object[]{Integer.valueOf(r0), Integer.valueOf(getTotalCount()), Integer.valueOf(getTotalBytes()), new String(r4)}));
    L9:
        return r0;
    }

    private int mapToFile(String r7, long r8) {
        byte[] r0 = r7.getBytes();
        if (r0 != null) goto L5;
    L27:
        return -1;
    L5:
        if (r0.length != 32) goto L27;
        int r2 = pushMessageInAvailableSlot(r0, r8);
        if (r2 < 0) goto L11;
        return r2;
    L11:
        if (this.mByteBuffer.remaining() >= 40) goto L13;
    L22:
        String r3 = TAG;
        Logger.i(r3, "remaining:" + this.mByteBuffer.remaining() + " total count:" + getTotalCount() + " threshold:6553 total bytes:" + getTotalBytes() + " threshold:262104");
        reportPersistentBufferLog(r7, 3, -1);
        removeDataForAvailableStorage();
        int r6 = pushMessageInAvailableSlot(r0, r8);
        if (r6 >= 0) goto L26;
        Logger.e(r3, "Push data failed, removeDataForAvailableStorage is not working.");
        return -1;
    L26:
        return r6;
    L13:
        if (getTotalCount() >= TOTAL_COUNT_THRESHOLD) goto L22;
        if (getTotalBytes() >= TOTAL_BYTES_THRESHOLD) goto L22;
        this.mByteBuffer.position(getTotalBytes() + 12);
        this.mByteBuffer.put(r0);
        this.mByteBuffer.putLong(r8);
        int r9 = getTotalCount();
        setTotalCount(r9 + 1);
        setTotalBytes(getTotalBytes() + 40);
        if (Logger.debug() == false) goto L20;
        Logger.d(TAG, String.format("push success in file: offset=%s, totalCount=%s, totalBytes=%s, logItem=%s", new Object[]{Integer.valueOf(r9), Integer.valueOf(getTotalCount()), Integer.valueOf(getTotalBytes()), r7}));
    L20:
        flush();
        return r9;
    }

    private void removeDataForAvailableStorage() {
        Logger.i(TAG, "available:1092 queue:" + this.mAvailableOffsetQueue.size());
        Iterator<Map.Entry<String, MessageContent>> r0 = this.mMessageIdStorageMap.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        MessageContent r1 = r0.next().getValue();
        if (r1.getOffset() >= TOTAL_COUNT_AVAILABLE) goto L4;
        removeMessageFromFileByOffset(r1.getOffset());
        r0.remove();
        goto L4
    }

    private void removeExpiredCachedData() {
        if (Logger.debug() == false) goto L5;
        Logger.d(TAG, "removeExpiredCachedData");
    L5:
        Iterator<Map.Entry<String, MessageContent>> r0 = this.mMessageIdStorageMap.entrySet().iterator();
        long r1 = System.currentTimeMillis();
        boolean r3 = false;
    L7:
        if (r0.hasNext() == false) goto L13;
        MessageContent r4 = r0.next().getValue();
        if (r4.getTimeStamp() >= r1) goto L7;
        removeMessageFromFileByOffset(r4.getOffset());
        r0.remove();
        if (r3 == true) goto L7;
        r3 = true;
        goto L7
    L13:
        if (r3 == false) goto L23;
        flush();
        return;
    }

    private void flush() {
        this.mByteBuffer.force();
    }
}
