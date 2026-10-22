package okio;

import android.icu.text.DateFormat;
import android.icu.text.PluralRules;
import com.android.settings.DataUsageFragment;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.bytedance.sysoptimizer.StackLeakChecker;
import com.google.common.base.Ascii;
import com.obric.capabilitykit.common.Ext;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import okhttp3.internal.connection.RealConnection;
import okio.internal._BufferKt;

/* JADX INFO: compiled from: Buffer.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002\u0090\u0001B\u0005¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0000H\u0016J\u0006\u0010\u0011\u001a\u00020\u0012J\b\u0010\u0013\u001a\u00020\u0000H\u0016J\b\u0010\u0014\u001a\u00020\u0012H\u0016J\u0006\u0010\u0015\u001a\u00020\fJ\u0006\u0010\u0016\u001a\u00020\u0000J$\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\f2\b\b\u0002\u0010\u001b\u001a\u00020\fH\u0007J\u0018\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u001a\u001a\u00020\fJ \u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\fJ\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010 \u001a\u00020\u0000H\u0016J\b\u0010!\u001a\u00020\u0000H\u0016J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0096\u0002J\b\u0010&\u001a\u00020#H\u0016J\b\u0010'\u001a\u00020\u0012H\u0016J\u0016\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\fH\u0087\u0002¢\u0006\u0002\b+J\u0015\u0010+\u001a\u00020)2\u0006\u0010,\u001a\u00020\fH\u0007¢\u0006\u0002\b-J\b\u0010.\u001a\u00020/H\u0016J\u0018\u00100\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u00101\u001a\u00020\u001dH\u0002J\u000e\u00102\u001a\u00020\u001d2\u0006\u00101\u001a\u00020\u001dJ\u000e\u00103\u001a\u00020\u001d2\u0006\u00101\u001a\u00020\u001dJ\u000e\u00104\u001a\u00020\u001d2\u0006\u00101\u001a\u00020\u001dJ\u0010\u00105\u001a\u00020\f2\u0006\u00106\u001a\u00020)H\u0016J\u0018\u00105\u001a\u00020\f2\u0006\u00106\u001a\u00020)2\u0006\u00107\u001a\u00020\fH\u0016J \u00105\u001a\u00020\f2\u0006\u00106\u001a\u00020)2\u0006\u00107\u001a\u00020\f2\u0006\u00108\u001a\u00020\fH\u0016J\u0010\u00105\u001a\u00020\f2\u0006\u00109\u001a\u00020\u001dH\u0016J\u0018\u00105\u001a\u00020\f2\u0006\u00109\u001a\u00020\u001d2\u0006\u00107\u001a\u00020\fH\u0016J\u0010\u0010:\u001a\u00020\f2\u0006\u0010;\u001a\u00020\u001dH\u0016J\u0018\u0010:\u001a\u00020\f2\u0006\u0010;\u001a\u00020\u001d2\u0006\u00107\u001a\u00020\fH\u0016J\b\u0010<\u001a\u00020=H\u0016J\b\u0010>\u001a\u00020#H\u0016J\u0006\u0010?\u001a\u00020\u001dJ\b\u0010@\u001a\u00020\u0019H\u0016J\b\u0010A\u001a\u00020\u0001H\u0016J\u0018\u0010B\u001a\u00020#2\u0006\u0010\u001a\u001a\u00020\f2\u0006\u00109\u001a\u00020\u001dH\u0016J(\u0010B\u001a\u00020#2\u0006\u0010\u001a\u001a\u00020\f2\u0006\u00109\u001a\u00020\u001d2\u0006\u0010C\u001a\u00020/2\u0006\u0010\u001b\u001a\u00020/H\u0016J\u0010\u0010D\u001a\u00020/2\u0006\u0010E\u001a\u00020FH\u0016J\u0010\u0010D\u001a\u00020/2\u0006\u0010E\u001a\u00020GH\u0016J \u0010D\u001a\u00020/2\u0006\u0010E\u001a\u00020G2\u0006\u0010\u001a\u001a\u00020/2\u0006\u0010\u001b\u001a\u00020/H\u0016J\u0018\u0010D\u001a\u00020\f2\u0006\u0010E\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\fH\u0016J\u0010\u0010H\u001a\u00020\f2\u0006\u0010E\u001a\u00020IH\u0016J\u0012\u0010J\u001a\u00020K2\b\b\u0002\u0010L\u001a\u00020KH\u0007J\b\u0010M\u001a\u00020)H\u0016J\b\u0010N\u001a\u00020GH\u0016J\u0010\u0010N\u001a\u00020G2\u0006\u0010\u001b\u001a\u00020\fH\u0016J\b\u0010O\u001a\u00020\u001dH\u0016J\u0010\u0010O\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\fH\u0016J\b\u0010P\u001a\u00020\fH\u0016J\u000e\u0010Q\u001a\u00020\u00002\u0006\u0010R\u001a\u00020=J\u0016\u0010Q\u001a\u00020\u00002\u0006\u0010R\u001a\u00020=2\u0006\u0010\u001b\u001a\u00020\fJ \u0010Q\u001a\u00020\u00122\u0006\u0010R\u001a\u00020=2\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010S\u001a\u00020#H\u0002J\u0010\u0010T\u001a\u00020\u00122\u0006\u0010E\u001a\u00020GH\u0016J\u0018\u0010T\u001a\u00020\u00122\u0006\u0010E\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\fH\u0016J\b\u0010U\u001a\u00020\fH\u0016J\b\u0010V\u001a\u00020/H\u0016J\b\u0010W\u001a\u00020/H\u0016J\b\u0010X\u001a\u00020\fH\u0016J\b\u0010Y\u001a\u00020\fH\u0016J\b\u0010Z\u001a\u00020[H\u0016J\b\u0010\\\u001a\u00020[H\u0016J\u0010\u0010]\u001a\u00020\u001f2\u0006\u0010^\u001a\u00020_H\u0016J\u0018\u0010]\u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010^\u001a\u00020_H\u0016J\u0012\u0010`\u001a\u00020K2\b\b\u0002\u0010L\u001a\u00020KH\u0007J\b\u0010a\u001a\u00020\u001fH\u0016J\u0010\u0010a\u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\fH\u0016J\b\u0010b\u001a\u00020/H\u0016J\n\u0010c\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010d\u001a\u00020\u001fH\u0016J\u0010\u0010d\u001a\u00020\u001f2\u0006\u0010e\u001a\u00020\fH\u0016J\u0010\u0010f\u001a\u00020#2\u0006\u0010\u001b\u001a\u00020\fH\u0016J\u0010\u0010g\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\fH\u0016J\u0010\u0010h\u001a\u00020/2\u0006\u0010i\u001a\u00020jH\u0016J\u0006\u0010k\u001a\u00020\u001dJ\u0006\u0010l\u001a\u00020\u001dJ\u0006\u0010m\u001a\u00020\u001dJ\r\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0002\bnJ\u0010\u0010o\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\fH\u0016J\u0006\u0010p\u001a\u00020\u001dJ\u000e\u0010p\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020/J\b\u0010q\u001a\u00020rH\u0016J\b\u0010s\u001a\u00020\u001fH\u0016J\u0015\u0010t\u001a\u00020\n2\u0006\u0010u\u001a\u00020/H\u0000¢\u0006\u0002\bvJ\u0010\u0010w\u001a\u00020/2\u0006\u0010x\u001a\u00020FH\u0016J\u0010\u0010w\u001a\u00020\u00002\u0006\u0010x\u001a\u00020GH\u0016J \u0010w\u001a\u00020\u00002\u0006\u0010x\u001a\u00020G2\u0006\u0010\u001a\u001a\u00020/2\u0006\u0010\u001b\u001a\u00020/H\u0016J\u0018\u0010w\u001a\u00020\u00122\u0006\u0010x\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\fH\u0016J\u0010\u0010w\u001a\u00020\u00002\u0006\u0010y\u001a\u00020\u001dH\u0016J \u0010w\u001a\u00020\u00002\u0006\u0010y\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020/2\u0006\u0010\u001b\u001a\u00020/H\u0016J\u0018\u0010w\u001a\u00020\u00002\u0006\u0010x\u001a\u00020z2\u0006\u0010\u001b\u001a\u00020\fH\u0016J\u0010\u0010{\u001a\u00020\f2\u0006\u0010x\u001a\u00020zH\u0016J\u0010\u0010|\u001a\u00020\u00002\u0006\u00106\u001a\u00020/H\u0016J\u0010\u0010}\u001a\u00020\u00002\u0006\u0010~\u001a\u00020\fH\u0016J\u0010\u0010\u007f\u001a\u00020\u00002\u0006\u0010~\u001a\u00020\fH\u0016J\u0012\u0010\u0080\u0001\u001a\u00020\u00002\u0007\u0010\u0081\u0001\u001a\u00020/H\u0016J\u0012\u0010\u0082\u0001\u001a\u00020\u00002\u0007\u0010\u0081\u0001\u001a\u00020/H\u0016J\u0011\u0010\u0083\u0001\u001a\u00020\u00002\u0006\u0010~\u001a\u00020\fH\u0016J\u0011\u0010\u0084\u0001\u001a\u00020\u00002\u0006\u0010~\u001a\u00020\fH\u0016J\u0012\u0010\u0085\u0001\u001a\u00020\u00002\u0007\u0010\u0086\u0001\u001a\u00020/H\u0016J\u0012\u0010\u0087\u0001\u001a\u00020\u00002\u0007\u0010\u0086\u0001\u001a\u00020/H\u0016J\u001a\u0010\u0088\u0001\u001a\u00020\u00002\u0007\u0010\u0089\u0001\u001a\u00020\u001f2\u0006\u0010^\u001a\u00020_H\u0016J,\u0010\u0088\u0001\u001a\u00020\u00002\u0007\u0010\u0089\u0001\u001a\u00020\u001f2\u0007\u0010\u008a\u0001\u001a\u00020/2\u0007\u0010\u008b\u0001\u001a\u00020/2\u0006\u0010^\u001a\u00020_H\u0016J\u001b\u0010\u008c\u0001\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\fH\u0007J\u0012\u0010\u008d\u0001\u001a\u00020\u00002\u0007\u0010\u0089\u0001\u001a\u00020\u001fH\u0016J$\u0010\u008d\u0001\u001a\u00020\u00002\u0007\u0010\u0089\u0001\u001a\u00020\u001f2\u0007\u0010\u008a\u0001\u001a\u00020/2\u0007\u0010\u008b\u0001\u001a\u00020/H\u0016J\u0012\u0010\u008e\u0001\u001a\u00020\u00002\u0007\u0010\u008f\u0001\u001a\u00020/H\u0016R\u0014\u0010\u0006\u001a\u00020\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u0004\u0018\u00010\n8\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000R&\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f8G@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0091\u0001"}, d2 = {"Lokio/Buffer;", "Lokio/BufferedSource;", "Lokio/BufferedSink;", "", "Ljava/nio/channels/ByteChannel;", "()V", "buffer", "getBuffer", "()Lokio/Buffer;", "head", "Lokio/Segment;", "<set-?>", "", PerfConsts.PERF_DISK_FILE_SIZE, "()J", "setSize$okio", "(J)V", "clear", "", "clone", "close", "completeSegmentByteCount", "copy", "copyTo", "out", "Ljava/io/OutputStream;", "offset", "byteCount", "digest", "Lokio/ByteString;", "algorithm", "", "emit", "emitCompleteSegments", "equals", "", PluralRules.KEYWORD_OTHER, "", "exhausted", "flush", "get", "", "pos", "getByte", "index", "-deprecated_getByte", "hashCode", "", "hmac", "key", "hmacSha1", "hmacSha256", "hmacSha512", "indexOf", "b", "fromIndex", "toIndex", "bytes", "indexOfElement", "targetBytes", "inputStream", "Ljava/io/InputStream;", "isOpen", "md5", "outputStream", "peek", "rangeEquals", "bytesOffset", "read", "sink", "Ljava/nio/ByteBuffer;", "", "readAll", "Lokio/Sink;", "readAndWriteUnsafe", "Lokio/Buffer$UnsafeCursor;", "unsafeCursor", "readByte", "readByteArray", "readByteString", "readDecimalLong", "readFrom", "input", "forever", "readFully", "readHexadecimalUnsignedLong", "readInt", "readIntLe", "readLong", "readLongLe", "readShort", "", "readShortLe", "readString", "charset", "Ljava/nio/charset/Charset;", "readUnsafe", "readUtf8", "readUtf8CodePoint", "readUtf8Line", "readUtf8LineStrict", DataUsageFragment.INTENT_EXTRA_LIMIT, Ext.KEY_REQUEST, "require", "select", "options", "Lokio/Options;", "sha1", "sha256", "sha512", "-deprecated_size", "skip", "snapshot", "timeout", "Lokio/Timeout;", "toString", "writableSegment", "minimumCapacity", "writableSegment$okio", "write", "source", "byteString", "Lokio/Source;", "writeAll", "writeByte", "writeDecimalLong", "v", "writeHexadecimalUnsignedLong", "writeInt", "i", "writeIntLe", "writeLong", "writeLongLe", "writeShort", DateFormat.SECOND, "writeShortLe", "writeString", "string", "beginIndex", "endIndex", "writeTo", "writeUtf8", "writeUtf8CodePoint", "codePoint", "UnsafeCursor", "okio"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Buffer implements BufferedSource, BufferedSink, Cloneable, ByteChannel {
    public Segment head;
    private long size;

    /* JADX INFO: compiled from: Buffer.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u000e\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\bJ\u0006\u0010\u0018\u001a\u00020\bJ\u000e\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\nJ\u000e\u0010\u001b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0012\u0010\u0013\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lokio/Buffer$UnsafeCursor;", "Ljava/io/Closeable;", "()V", "buffer", "Lokio/Buffer;", "data", "", TraceStatsConsts.STATS_KEY_END, "", "offset", "", "readWrite", "", "segment", "Lokio/Segment;", "getSegment$okio", "()Lokio/Segment;", "setSegment$okio", "(Lokio/Segment;)V", "start", "close", "", "expandBuffer", "minByteCount", "next", "resizeBuffer", "newSize", "seek", "okio"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class UnsafeCursor implements Closeable {
        public Buffer buffer;
        public byte[] data;
        public int end;
        public long offset;
        public boolean readWrite;
        private Segment segment;
        public int start;

        public UnsafeCursor() {
            this.offset = -1;
            this.start = -1;
            this.end = -1;
        }

        public final Segment getSegment$okio() {
            return this.segment;
        }

        public final void setSegment$okio(Segment r1) {
            this.segment = r1;
        }

        public final int next() {
            long r0 = this.offset;
            Buffer r2 = this.buffer;
            Intrinsics.checkNotNull(r2);
            if (r0 == r2.size()) goto L5;
            boolean r1 = true;
        L6:
            if (r1 == false) goto L14;
            long r3 = this.offset;
            if (r3 != (-1)) goto L10;
            long r4 = 0;
        L12:
            return seek(r4);
        L10:
            r4 = r3 + ((long) (this.end - this.start));
            goto L12
        L14:
            throw new IllegalStateException("no more bytes".toString());
        L5:
            r1 = false;
            goto L6
        }

        public final int seek(long r13) {
            Buffer r0 = this.buffer;
            if (r0 == null) goto L41;
            if (r13 < (-1)) goto L39;
            if (r13 > r0.size()) goto L39;
            if (r13 != (-1)) goto L10;
        L36:
            setSegment$okio(null);
            this.offset = r13;
            this.data = null;
            this.start = -1;
            this.end = -1;
            return -1;
        L10:
            if (r13 == r0.size()) goto L36;
            long r1 = r0.size();
            Segment r3 = r0.head;
            Segment r4 = r0.head;
            long r6 = 0;
            if (getSegment$okio() == null) goto L19;
            long r8 = this.offset;
            int r5 = this.start;
            Segment r10 = getSegment$okio();
            Intrinsics.checkNotNull(r10);
            long r9 = r8 - ((long) (r5 - r10.pos));
            if (r9 <= r13) goto L17;
            r4 = getSegment$okio();
            r1 = r9;
            goto L19
        L17:
            r3 = getSegment$okio();
            r6 = r9;
        L19:
            if ((r1 - r13) <= (r13 - r6)) goto L24;
        L20:
            Intrinsics.checkNotNull(r3);
            if (r13 < (((long) (r3.limit - r3.pos)) + r6)) goto L28;
            r6 = r6 + ((long) (r3.limit - r3.pos));
            r3 = r3.next;
        L28:
            if (this.readWrite == false) goto L35;
            Intrinsics.checkNotNull(r3);
            if (r3.shared == false) goto L35;
            Segment r2 = r3.unsharedCopy();
            if (r0.head != r3) goto L34;
            r0.head = r2;
        L34:
            r3 = r3.push(r2);
            Segment r7 = r3.prev;
            Intrinsics.checkNotNull(r7);
            r7.pop();
        L35:
            setSegment$okio(r3);
            this.offset = r13;
            Intrinsics.checkNotNull(r3);
            this.data = r3.data;
            this.start = r3.pos + ((int) (r13 - r6));
            int r14 = r3.limit;
            this.end = r14;
            return r14 - this.start;
        L24:
            if (r1 <= r13) goto L26;
            Intrinsics.checkNotNull(r4);
            r4 = r4.prev;
            Intrinsics.checkNotNull(r4);
            r1 = r1 - ((long) (r4.limit - r4.pos));
            goto L24
        L26:
            r6 = r1;
            r3 = r4;
        L39:
            throw new ArrayIndexOutOfBoundsException("offset=" + r13 + " > size=" + r0.size());
        L41:
            throw new IllegalStateException("not attached to a buffer".toString());
        }

        public final long resizeBuffer(long r17) {
            Buffer r3 = this.buffer;
            if (r3 == null) goto L36;
            if (this.readWrite == false) goto L34;
            long r4 = r3.size();
            int r8 = 1;
            if (r17 <= r4) goto L9;
            if (r17 <= r4) goto L31;
            long r11 = r17 - r4;
            boolean r6 = true;
        L26:
            if (r11 <= 0) goto L31;
            Segment r13 = r3.writableSegment$okio(r8);
            int r14 = (int) Math.min(r11, 8192 - r13.limit);
            r13.limit += r14;
            r11 = r11 - ((long) r14);
            if (r6 == false) goto L30;
            setSegment$okio(r13);
            this.offset = r4;
            this.data = r13.data;
            this.start = r13.limit - r14;
            this.end = r13.limit;
            r6 = false;
        L30:
            r8 = 1;
        L31:
            r3.setSize$okio(r17);
            return r4;
        L9:
            if (r17 < 0) goto L11;
            boolean r7 = true;
        L12:
            if (r7 == false) goto L22;
            long r9 = r4 - r17;
        L15:
            if (r9 <= 0) goto L20;
            Segment r10 = r3.head;
            Intrinsics.checkNotNull(r10);
            Segment r12 = r10.prev;
            Intrinsics.checkNotNull(r12);
            long r15 = r12.limit - r12.pos;
            if (r15 > r9) goto L19;
            r3.head = r12.pop();
            SegmentPool.recycle(r12);
            r9 = r9 - r15;
            goto L15
        L19:
            r12.limit -= (int) r9;
        L20:
            setSegment$okio(null);
            this.offset = r17;
            this.data = null;
            this.start = -1;
            this.end = -1;
            goto L31
        L22:
            throw new IllegalArgumentException(("newSize < 0: " + r17).toString());
        L11:
            r7 = false;
            goto L12
        L34:
            throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers".toString());
        L36:
            throw new IllegalStateException("not attached to a buffer".toString());
        }

        public final long expandBuffer(int r10) {
            boolean r0 = true;
            if (r10 <= 0) goto L5;
            boolean r2 = true;
        L6:
            if (r2 == false) goto L25;
            if (r10 <= 8192) goto L11;
            r0 = false;
        L11:
            if (r0 == false) goto L23;
            Buffer r1 = this.buffer;
            if (r1 == null) goto L21;
            if (this.readWrite == false) goto L19;
            long r3 = r1.size();
            Segment r11 = r1.writableSegment$okio(r10);
            int r4 = 8192 - r11.limit;
            r11.limit = 8192;
            long r5 = r4;
            r1.setSize$okio(r3 + r5);
            setSegment$okio(r11);
            this.offset = r3;
            this.data = r11.data;
            this.start = 8192 - r4;
            this.end = 8192;
            return r5;
        L19:
            throw new IllegalStateException("expandBuffer() only permitted for read/write buffers".toString());
        L21:
            throw new IllegalStateException("not attached to a buffer".toString());
        L23:
            throw new IllegalArgumentException(("minByteCount > Segment.SIZE: " + r10).toString());
        L25:
            throw new IllegalArgumentException(("minByteCount <= 0: " + r10).toString());
        L5:
            r2 = false;
            goto L6
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.buffer == null) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == false) goto L10;
            this.buffer = null;
            setSegment$okio(null);
            this.offset = -1;
            this.data = null;
            this.start = -1;
            this.end = -1;
            return;
        L10:
            throw new IllegalStateException("not attached to a buffer".toString());
        L5:
            r0 = false;
            goto L6
        }
    }

    @Override // okio.BufferedSource, okio.BufferedSink
    public Buffer buffer() {
        return this;
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public final Buffer copyTo(OutputStream r10) throws IOException {
        Intrinsics.checkNotNullParameter(r10, "out");
        return copyTo$default(this, r10, 0, 0, 6, null);
    }

    public final Buffer copyTo(OutputStream r10, long r11) throws IOException {
        Intrinsics.checkNotNullParameter(r10, "out");
        return copyTo$default(this, r10, r11, 0, 4, null);
    }

    @Override // okio.BufferedSink
    public Buffer emit() {
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer emitCompleteSegments() {
        return this;
    }

    @Override // okio.BufferedSink, okio.Sink, java.io.Flushable
    public void flush() {
    }

    @Override // okio.BufferedSource, okio.BufferedSink
    public Buffer getBuffer() {
        return this;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    public final UnsafeCursor readAndWriteUnsafe() {
        return readAndWriteUnsafe$default(this, null, 1, null);
    }

    public final UnsafeCursor readUnsafe() {
        return readUnsafe$default(this, null, 1, null);
    }

    public final Buffer writeTo(OutputStream r8) throws IOException {
        Intrinsics.checkNotNullParameter(r8, "out");
        return writeTo$default(this, r8, 0, 2, null);
    }

    public Buffer() {
    }

    public /* bridge */ /* synthetic */ Object clone() {
        return m3226clone();
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink emit() {
        return emit();
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink emitCompleteSegments() {
        return emitCompleteSegments();
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink write(ByteString r1) {
        return write(r1);
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink write(ByteString r1, int r2, int r3) {
        return write(r1, r2, r3);
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink write(Source r1, long r2) {
        return write(r1, r2);
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink write(byte[] r1) {
        return write(r1);
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink write(byte[] r1, int r2, int r3) {
        return write(r1, r2, r3);
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink writeByte(int r1) {
        return writeByte(r1);
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink writeDecimalLong(long r1) {
        return writeDecimalLong(r1);
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink writeHexadecimalUnsignedLong(long r1) {
        return writeHexadecimalUnsignedLong(r1);
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink writeInt(int r1) {
        return writeInt(r1);
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink writeIntLe(int r1) {
        return writeIntLe(r1);
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink writeLong(long r1) {
        return writeLong(r1);
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink writeLongLe(long r1) {
        return writeLongLe(r1);
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink writeShort(int r1) {
        return writeShort(r1);
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink writeShortLe(int r1) {
        return writeShortLe(r1);
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink writeString(String r1, int r2, int r3, Charset r4) {
        return writeString(r1, r2, r3, r4);
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink writeString(String r1, Charset r2) {
        return writeString(r1, r2);
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink writeUtf8(String r1) {
        return writeUtf8(r1);
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink writeUtf8(String r1, int r2, int r3) {
        return writeUtf8(r1, r2, r3);
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink writeUtf8CodePoint(int r1) {
        return writeUtf8CodePoint(r1);
    }

    public final long size() {
        return this.size;
    }

    public final void setSize$okio(long r1) {
        this.size = r1;
    }

    @Override // okio.BufferedSink
    public OutputStream outputStream() {
        return new C04351(this);
    }

    @Override // okio.BufferedSource
    public boolean exhausted() {
        if (this.size != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // okio.BufferedSource
    public void require(long r3) throws EOFException {
        if (this.size < r3) goto L6;
        return;
    L6:
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    public boolean request(long r3) {
        if (this.size < r3) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // okio.BufferedSource
    public BufferedSource peek() {
        return Okio.buffer(new PeekSource(this));
    }

    @Override // okio.BufferedSource
    public InputStream inputStream() {
        return new AnonymousClass1(this);
    }

    public static /* synthetic */ UnsafeCursor readUnsafe$default(Buffer r0, UnsafeCursor r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = _UtilKt.getDEFAULT__new_UnsafeCursor();
    L6:
        return r0.readUnsafe(r1);
    }

    public static /* synthetic */ UnsafeCursor readAndWriteUnsafe$default(Buffer r0, UnsafeCursor r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = _UtilKt.getDEFAULT__new_UnsafeCursor();
    L6:
        return r0.readAndWriteUnsafe(r1);
    }

    public static /* synthetic */ Buffer copyTo$default(Buffer r6, OutputStream r7, long r8, long r10, int r12, Object r13) throws IOException {
        if ((r12 & 2) == 0) goto L5;
        r8 = 0;
    L5:
        long r2 = r8;
        if ((r12 & 4) == 0) goto L9;
        r10 = r6.size - r2;
    L9:
        return r6.copyTo(r7, r2, r10);
    }

    public final Buffer copyTo(OutputStream r8, long r9, long r11) throws IOException {
        Intrinsics.checkNotNullParameter(r8, "out");
        _UtilKt.checkOffsetAndCount(this.size, r9, r11);
        if (r11 != 0) goto L5;
        return this;
    L5:
        Segment r2 = this.head;
    L6:
        Intrinsics.checkNotNull(r2);
        if (r9 < (r2.limit - r2.pos)) goto L10;
        r9 = r9 - ((long) (r2.limit - r2.pos));
        r2 = r2.next;
    L10:
        if (r11 <= 0) goto L12;
        Intrinsics.checkNotNull(r2);
        int r10 = (int) (((long) r2.pos) + r9);
        int r12 = (int) Math.min(r2.limit - r10, r11);
        r8.write(r2.data, r10, r12);
        r11 = r11 - ((long) r12);
        r2 = r2.next;
        r9 = 0;
        goto L10
    L12:
        return this;
    }

    public static /* synthetic */ Buffer copyTo$default(Buffer r6, Buffer r7, long r8, long r10, int r12, Object r13) {
        if ((r12 & 2) == 0) goto L6;
        r8 = 0;
    L6:
        return r6.copyTo(r7, r8, r10);
    }

    public static /* synthetic */ Buffer copyTo$default(Buffer r0, Buffer r1, long r2, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = 0;
    L6:
        return r0.copyTo(r1, r2);
    }

    public final Buffer copyTo(Buffer r9, long r10) {
        Intrinsics.checkNotNullParameter(r9, "out");
        return copyTo(r9, r10, this.size - r10);
    }

    public static /* synthetic */ Buffer writeTo$default(Buffer r0, OutputStream r1, long r2, int r4, Object r5) throws IOException {
        if ((r4 & 2) == 0) goto L6;
        r2 = r0.size;
    L6:
        return r0.writeTo(r1, r2);
    }

    public final Buffer writeTo(OutputStream r8, long r9) throws IOException {
        Intrinsics.checkNotNullParameter(r8, "out");
        _UtilKt.checkOffsetAndCount(this.size, 0, r9);
        Segment r0 = this.head;
    L4:
        if (r9 <= 0) goto L8;
        Intrinsics.checkNotNull(r0);
        int r1 = (int) Math.min(r9, r0.limit - r0.pos);
        r8.write(r0.data, r0.pos, r1);
        r0.pos += r1;
        long r4 = r1;
        this.size -= r4;
        r9 = r9 - r4;
        if (r0.pos != r0.limit) goto L4;
        Segment r2 = r0.pop();
        this.head = r2;
        SegmentPool.recycle(r0);
        r0 = r2;
        goto L4
    L8:
        return this;
    }

    public final Buffer readFrom(InputStream r4) throws IOException {
        Intrinsics.checkNotNullParameter(r4, "input");
        readFrom(r4, Long.MAX_VALUE, true);
        return this;
    }

    public final Buffer readFrom(InputStream r3, long r4) throws IOException {
        Intrinsics.checkNotNullParameter(r3, "input");
        if (r4 < 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        readFrom(r3, r4, false);
        return this;
    L10:
        throw new IllegalArgumentException(("byteCount < 0: " + r4).toString());
    L5:
        r0 = false;
        goto L6
    }

    private final void readFrom(InputStream r5, long r6, boolean r8) throws IOException {
    L3:
        if (r6 > 0) goto L7;
        if (r8 == true) goto L7;
        return;
    L7:
        Segment r0 = writableSegment$okio(1);
        int r1 = r5.read(r0.data, r0.limit, (int) Math.min(r6, 8192 - r0.limit));
        if (r1 == (-1)) goto L10;
        r0.limit += r1;
        long r2 = r1;
        this.size += r2;
        r6 = r6 - r2;
        goto L3
    L10:
        if (r0.pos != r0.limit) goto L12;
        this.head = r0.pop();
        SegmentPool.recycle(r0);
    L12:
        if (r8 == false) goto L15;
        return;
    L15:
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    public short readShortLe() throws EOFException {
        return _UtilKt.reverseBytes(readShort());
    }

    @Override // okio.BufferedSource
    public int readIntLe() throws EOFException {
        return _UtilKt.reverseBytes(readInt());
    }

    @Override // okio.BufferedSource
    public long readLongLe() throws EOFException {
        return _UtilKt.reverseBytes(readLong());
    }

    @Override // okio.BufferedSource
    public String readUtf8() {
        return readString(this.size, Charsets.UTF_8);
    }

    @Override // okio.BufferedSource
    public String readUtf8(long r2) throws EOFException {
        return readString(r2, Charsets.UTF_8);
    }

    @Override // okio.BufferedSource
    public String readString(Charset r3) {
        Intrinsics.checkNotNullParameter(r3, "charset");
        return readString(this.size, r3);
    }

    @Override // okio.BufferedSource
    public String readString(long r6, Charset r8) throws EOFException {
        Intrinsics.checkNotNullParameter(r8, "charset");
        if (r6 >= 0) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L25;
        if (this.size < r6) goto L23;
        if (r6 != 0) goto L14;
        return "";
    L14:
        Segment r0 = this.head;
        Intrinsics.checkNotNull(r0);
        if ((((long) r0.pos) + r6) > r0.limit) goto L17;
        int r4 = (int) r6;
        String r2 = new String(r0.data, r0.pos, r4, r8);
        r0.pos += r4;
        this.size -= r6;
        if (r0.pos != r0.limit) goto L21;
        this.head = r0.pop();
        SegmentPool.recycle(r0);
    L21:
        return r2;
    L17:
        return new String(readByteArray(r6), r8);
    L23:
        throw new EOFException();
    L25:
        throw new IllegalArgumentException(("byteCount: " + r6).toString());
    L5:
        if (r6 > 2147483647L) goto L7;
        r1 = true;
        goto L8
    }

    @Override // okio.BufferedSource
    public String readUtf8LineStrict() throws EOFException {
        return readUtf8LineStrict(Long.MAX_VALUE);
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer r7) throws IOException {
        Intrinsics.checkNotNullParameter(r7, "sink");
        Segment r0 = this.head;
        if (r0 != null) goto L6;
        return -1;
    L6:
        int r1 = Math.min(r7.remaining(), r0.limit - r0.pos);
        r7.put(r0.data, r0.pos, r1);
        r0.pos += r1;
        this.size -= (long) r1;
        if (r0.pos != r0.limit) goto L9;
        this.head = r0.pop();
        SegmentPool.recycle(r0);
    L9:
        return r1;
    }

    @Override // okio.BufferedSink
    public Buffer writeUtf8(String r3) {
        Intrinsics.checkNotNullParameter(r3, "string");
        return writeUtf8(r3, 0, r3.length());
    }

    @Override // okio.BufferedSink
    public Buffer writeString(String r3, Charset r4) {
        Intrinsics.checkNotNullParameter(r3, "string");
        Intrinsics.checkNotNullParameter(r4, "charset");
        return writeString(r3, 0, r3.length(), r4);
    }

    @Override // okio.BufferedSink
    public Buffer writeString(String r4, int r5, int r6, Charset r7) {
        Intrinsics.checkNotNullParameter(r4, "string");
        Intrinsics.checkNotNullParameter(r7, "charset");
        boolean r0 = true;
        if (r5 < 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L27;
        if (r6 < r5) goto L9;
        boolean r3 = true;
    L10:
        if (r3 == false) goto L25;
        if (r6 <= r4.length()) goto L15;
        r0 = false;
    L15:
        if (r0 == false) goto L23;
        if (Intrinsics.areEqual(r7, Charsets.UTF_8) == true) goto L19;
        String r8 = r4.substring(r5, r6);
        Intrinsics.checkNotNullExpressionValue(r8, "this as java.lang.String…ing(startIndex, endIndex)");
        byte[] r9 = r8.getBytes(r7);
        Intrinsics.checkNotNullExpressionValue(r9, "this as java.lang.String).getBytes(charset)");
        return write(r9, 0, r9.length);
    L19:
        return writeUtf8(r4, r5, r6);
    L23:
        throw new IllegalArgumentException(("endIndex > string.length: " + r6 + " > " + r4.length()).toString());
    L25:
        throw new IllegalArgumentException(("endIndex < beginIndex: " + r6 + " < " + r5).toString());
    L9:
        r3 = false;
        goto L10
    L27:
        throw new IllegalArgumentException(("beginIndex < 0: " + r5).toString());
    L5:
        r2 = false;
        goto L6
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer r7) throws IOException {
        Intrinsics.checkNotNullParameter(r7, "source");
        int r0 = r7.remaining();
        int r1 = r0;
    L3:
        if (r1 <= 0) goto L5;
        Segment r2 = writableSegment$okio(1);
        int r3 = Math.min(r1, 8192 - r2.limit);
        r7.get(r2.data, r2.limit, r3);
        r1 = r1 - r3;
        r2.limit += r3;
        goto L3
    L5:
        this.size += (long) r0;
        return r0;
    }

    @Override // okio.BufferedSink
    public Buffer writeShortLe(int r1) {
        return writeShort(_UtilKt.reverseBytes((short) r1));
    }

    @Override // okio.BufferedSink
    public Buffer writeIntLe(int r1) {
        return writeInt(_UtilKt.reverseBytes(r1));
    }

    @Override // okio.BufferedSink
    public Buffer writeLongLe(long r1) {
        return writeLong(_UtilKt.reverseBytes(r1));
    }

    @Override // okio.BufferedSource
    public long indexOf(byte r7) {
        return indexOf(r7, 0, Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public long indexOf(byte r7, long r8) {
        return indexOf(r7, r8, Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public long indexOf(ByteString r3) throws IOException {
        Intrinsics.checkNotNullParameter(r3, "bytes");
        return indexOf(r3, 0);
    }

    @Override // okio.BufferedSource
    public long indexOfElement(ByteString r3) {
        Intrinsics.checkNotNullParameter(r3, "targetBytes");
        return indexOfElement(r3, 0);
    }

    @Override // okio.BufferedSource
    public boolean rangeEquals(long r8, ByteString r10) {
        Intrinsics.checkNotNullParameter(r10, "bytes");
        return rangeEquals(r8, r10, 0, r10.size());
    }

    @Override // okio.Source
    public Timeout timeout() {
        return Timeout.NONE;
    }

    public final ByteString md5() {
        return digest("MD5");
    }

    public final ByteString sha1() {
        return digest("SHA-1");
    }

    public final ByteString sha256() {
        return digest("SHA-256");
    }

    public final ByteString sha512() {
        return digest("SHA-512");
    }

    private final ByteString digest(String r6) {
        MessageDigest r7 = MessageDigest.getInstance(r6);
        Segment r5 = this.head;
        if (r5 == null) goto L7;
        r7.update(r5.data, r5.pos, r5.limit - r5.pos);
        Segment r0 = r5.next;
        Intrinsics.checkNotNull(r0);
    L5:
        if (r0 == r5) goto L7;
        r7.update(r0.data, r0.pos, r0.limit - r0.pos);
        r0 = r0.next;
        Intrinsics.checkNotNull(r0);
    L7:
        byte[] r8 = r7.digest();
        Intrinsics.checkNotNullExpressionValue(r8, "messageDigest.digest()");
        return new ByteString(r8);
    }

    public final ByteString hmacSha1(ByteString r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        return hmac("HmacSHA1", r2);
    }

    public final ByteString hmacSha256(ByteString r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        return hmac("HmacSHA256", r2);
    }

    public final ByteString hmacSha512(ByteString r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        return hmac("HmacSHA512", r2);
    }

    private final ByteString hmac(String r5, ByteString r6) {
        Mac r0 = Mac.getInstance(r5);     // Catch: InvalidKeyException -> L9
        r0.init(new SecretKeySpec(r6.internalArray$okio(), r5));     // Catch: InvalidKeyException -> L9
        Segment r4 = this.head;     // Catch: InvalidKeyException -> L9
        if (r4 == null) goto L7;
        r0.update(r4.data, r4.pos, r4.limit - r4.pos);     // Catch: InvalidKeyException -> L9
        Segment r7 = r4.next;     // Catch: InvalidKeyException -> L9
        Intrinsics.checkNotNull(r7);     // Catch: InvalidKeyException -> L9
    L5:
        if (r7 == r4) goto L7;
        r0.update(r7.data, r7.pos, r7.limit - r7.pos);     // Catch: InvalidKeyException -> L9
        r7 = r7.next;     // Catch: InvalidKeyException -> L9
        Intrinsics.checkNotNull(r7);     // Catch: InvalidKeyException -> L9
    L7:
        byte[] r8 = r0.doFinal();     // Catch: InvalidKeyException -> L9
        Intrinsics.checkNotNullExpressionValue(r8, "mac.doFinal()");     // Catch: InvalidKeyException -> L9
        return new ByteString(r8);
    L9:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    public String toString() {
        return snapshot().toString();
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public Buffer m3226clone() {
        return copy();
    }

    public final UnsafeCursor readUnsafe(UnsafeCursor r2) {
        Intrinsics.checkNotNullParameter(r2, "unsafeCursor");
        return _BufferKt.commonReadUnsafe(this, r2);
    }

    public final UnsafeCursor readAndWriteUnsafe(UnsafeCursor r2) {
        Intrinsics.checkNotNullParameter(r2, "unsafeCursor");
        return _BufferKt.commonReadAndWriteUnsafe(this, r2);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to operator function", replaceWith = @ReplaceWith(expression = "this[index]", imports = {}))
    /* JADX INFO: renamed from: -deprecated_getByte, reason: not valid java name */
    public final byte m3224deprecated_getByte(long r1) {
        return getByte(r1);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = PerfConsts.PERF_DISK_FILE_SIZE, imports = {}))
    /* JADX INFO: renamed from: -deprecated_size, reason: not valid java name */
    public final long m3225deprecated_size() {
        return this.size;
    }

    public final Buffer copyTo(Buffer r8, long r9, long r11) {
        Intrinsics.checkNotNullParameter(r8, "out");
        _UtilKt.checkOffsetAndCount(size(), r9, r11);
        if (r11 == 0) goto L16;
        r8.setSize$okio(r8.size() + r11);
        Segment r2 = this.head;
    L6:
        Intrinsics.checkNotNull(r2);
        if (r9 < (r2.limit - r2.pos)) goto L10;
        r9 = r9 - ((long) (r2.limit - r2.pos));
        r2 = r2.next;
    L10:
        if (r11 <= 0) goto L16;
        Intrinsics.checkNotNull(r2);
        Segment r3 = r2.sharedCopy();
        r3.pos += (int) r9;
        r3.limit = Math.min(r3.pos + ((int) r11), r3.limit);
        Segment r10 = r8.head;
        if (r10 != null) goto L14;
        r3.prev = r3;
        r3.next = r3.prev;
        r8.head = r3.next;
    L15:
        r11 = r11 - ((long) (r3.limit - r3.pos));
        r2 = r2.next;
        r9 = 0;
        goto L10
    L14:
        Intrinsics.checkNotNull(r10);
        Segment r12 = r10.prev;
        Intrinsics.checkNotNull(r12);
        r12.push(r3);
    L16:
        return this;
    }

    public final long completeSegmentByteCount() {
        long r0 = size();
        if (r0 == 0) goto L12;
        Segment r5 = this.head;
        Intrinsics.checkNotNull(r5);
        Segment r6 = r5.prev;
        Intrinsics.checkNotNull(r6);
        if (r6.limit >= 8192) goto L11;
        if (r6.owner == false) goto L11;
        r0 = r0 - ((long) (r6.limit - r6.pos));
    L11:
        return r0;
    L12:
        return 0;
    }

    @Override // okio.BufferedSource
    public byte readByte() throws EOFException {
        if (size() == 0) goto L10;
        Segment r0 = this.head;
        Intrinsics.checkNotNull(r0);
        int r1 = r0.pos;
        int r2 = r0.limit;
        int r4 = r1 + 1;
        byte r3 = r0.data[r1];
        setSize$okio(size() - 1);
        if (r4 != r2) goto L7;
        this.head = r0.pop();
        SegmentPool.recycle(r0);
    L8:
        return r3;
    L7:
        r0.pos = r4;
        goto L8
    L10:
        throw new EOFException();
    }

    public final byte getByte(long r7) {
        _UtilKt.checkOffsetAndCount(size(), r7, 1);
        Segment r0 = this.head;
        if (r0 != null) goto L5;
        Segment r6 = null;
        Intrinsics.checkNotNull(null);
        byte[] r8 = r6.data;
        throw null;
    L5:
        if ((size() - r7) >= r7) goto L11;
        long r1 = size();
    L8:
        if (r1 <= r7) goto L10;
        r0 = r0.prev;
        Intrinsics.checkNotNull(r0);
        r1 = r1 - ((long) (r0.limit - r0.pos));
        goto L8
    L10:
        Intrinsics.checkNotNull(r0);
        return r0.data[(int) ((((long) r0.pos) + r7) - r1)];
    L11:
        long r2 = 0;
    L12:
        long r3 = ((long) (r0.limit - r0.pos)) + r2;
        if (r3 > r7) goto L15;
        r0 = r0.next;
        Intrinsics.checkNotNull(r0);
        r2 = r3;
        goto L12
    L15:
        Intrinsics.checkNotNull(r0);
        return r0.data[(int) ((((long) r0.pos) + r7) - r2)];
    }

    @Override // okio.BufferedSource
    public short readShort() throws EOFException {
        if (size() < 2) goto L14;
        Segment r0 = this.head;
        Intrinsics.checkNotNull(r0);
        int r1 = r0.pos;
        int r4 = r0.limit;
        if ((r4 - r1) >= 2) goto L7;
        int r2 = (readByte() & 255) << 8;
        return (short) ((readByte() & 255) | r2);
    L7:
        byte[] r5 = r0.data;
        int r6 = r1 + 1;
        int r7 = r6 + 1;
        int r3 = ((r5[r1] & 255) << 8) | (r5[r6] & 255);
        setSize$okio(size() - 2);
        if (r7 != r4) goto L10;
        this.head = r0.pop();
        SegmentPool.recycle(r0);
    L12:
        return (short) r3;
    L10:
        r0.pos = r7;
        goto L12
    L14:
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    public int readInt() throws EOFException {
        if (size() < 4) goto L14;
        Segment r0 = this.head;
        Intrinsics.checkNotNull(r0);
        int r1 = r0.pos;
        int r4 = r0.limit;
        if ((r4 - r1) < 4) goto L15;
        byte[] r5 = r0.data;
        int r6 = r1 + 1;
        int r7 = r6 + 1;
        int r2 = ((r5[r1] & 255) << 24) | ((r5[r6] & 255) << 16);
        int r8 = r7 + 1;
        int r3 = r2 | ((r5[r7] & 255) << 8);
        int r9 = r8 + 1;
        int r10 = r3 | (r5[r8] & 255);
        setSize$okio(size() - 4);
        if (r9 != r4) goto L10;
        this.head = r0.pop();
        SegmentPool.recycle(r0);
    L12:
        return r10;
    L10:
        r0.pos = r9;
        goto L12
    L15:
        return (readByte() & 255) | ((((readByte() & 255) << 24) | ((readByte() & 255) << 16)) | ((readByte() & 255) << 8));
    L14:
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    public long readLong() throws EOFException {
        if (size() < 8) goto L14;
        Segment r0 = this.head;
        Intrinsics.checkNotNull(r0);
        int r1 = r0.pos;
        int r4 = r0.limit;
        if ((r4 - r1) < 8) goto L15;
        byte[] r5 = r0.data;
        int r7 = r1 + 1;
        long r8 = (((long) r5[r1]) & 255) << 56;
        int r2 = r7 + 1;
        int r9 = r2 + 1;
        long r10 = (r8 | ((((long) r5[r7]) & 255) << 48)) | ((((long) r5[r2]) & 255) << 40);
        int r3 = r9 + 1;
        int r11 = r3 + 1;
        long r6 = (r10 | ((((long) r5[r9]) & 255) << 32)) | ((((long) r5[r3]) & 255) << 24);
        int r12 = r11 + 1;
        long r13 = r6 | ((((long) r5[r11]) & 255) << 16);
        int r14 = r12 + 1;
        long r15 = r13 | ((((long) r5[r12]) & 255) << 8);
        int r16 = r14 + 1;
        long r17 = r15 | (((long) r5[r14]) & 255);
        setSize$okio(size() - 8);
        if (r16 != r4) goto L10;
        this.head = r0.pop();
        SegmentPool.recycle(r0);
    L12:
        return r17;
    L10:
        r0.pos = r16;
        goto L12
    L15:
        return ((((long) readInt()) & 4294967295L) << 32) | (4294967295L & ((long) readInt()));
    L14:
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    public long readDecimalLong() throws EOFException {
        if (size() == 0) goto L56;
        int r1 = 0;
        boolean r2 = false;
        long r8 = 0;
        long r6 = -7;
        boolean r5 = false;
    L5:
        Segment r10 = this.head;
        Intrinsics.checkNotNull(r10);
        byte[] r11 = r10.data;
        int r12 = r10.pos;
        int r13 = r10.limit;
    L6:
        if (r12 >= r13) goto L29;
        byte r15 = r11[r12];
        if (r15 < 48) goto L24;
        if (r15 > 57) goto L24;
        int r14 = 48 - r15;
        if (r8 < _BufferKt.OVERFLOW_ZONE) goto L18;
        if (r8 == _BufferKt.OVERFLOW_ZONE) goto L15;
    L17:
        r8 = (r8 * 10) + ((long) r14);
    L27:
        r12 = r12 + 1;
        r1 = r1 + 1;
        goto L6
    L15:
        if (r14 >= r6) goto L17;
    L18:
        Buffer r0 = new Buffer().writeDecimalLong(r8).writeByte(r15);
        if (r2 == true) goto L22;
        r0.readByte();
    L22:
        throw new NumberFormatException("Number too large: " + r0.readUtf8());
    L24:
        if (r15 != 45) goto L28;
        if (r1 != 0) goto L28;
        r6 = r6 - 1;
        r2 = true;
    L28:
        r5 = true;
    L29:
        if (r12 != r13) goto L31;
        this.head = r10.pop();
        SegmentPool.recycle(r10);
    L32:
        if (r5 == true) goto L37;
        if (this.head != null) goto L5;
    L37:
        setSize$okio(size() - ((long) r1));
        if (r2 == false) goto L40;
        int r16 = 2;
    L41:
        if (r1 < r16) goto L43;
        if (r2 == false) goto L54;
        return r8;
    L54:
        return -r8;
    L43:
        if (size() == 0) goto L50;
        if (r2 == false) goto L46;
        String r3 = "Expected a digit";
    L48:
        throw new NumberFormatException(r3 + " but was 0x" + _UtilKt.toHexString(getByte(0)));
    L46:
        r3 = "Expected a digit or '-'";
        goto L48
    L50:
        throw new EOFException();
    L40:
        r16 = 1;
        goto L41
    L31:
        r10.pos = r12;
        goto L32
    L56:
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    public long readHexadecimalUnsignedLong() throws EOFException {
        if (size() == 0) goto L41;
        int r0 = 0;
        boolean r1 = false;
        long r4 = 0;
    L5:
        Segment r6 = this.head;
        Intrinsics.checkNotNull(r6);
        byte[] r7 = r6.data;
        int r8 = r6.pos;
        int r9 = r6.limit;
    L6:
        if (r8 >= r9) goto L32;
        byte r10 = r7[r8];
        if (r10 < 48) goto L13;
        if (r10 > 57) goto L13;
        int r11 = r10 - 48;
    L24:
        if (((-1152921504606846976L) & r4) != 0) goto L27;
        r4 = (r4 << 4) | ((long) r11);
        r8 = r8 + 1;
        r0 = r0 + 1;
        goto L6
    L27:
        throw new NumberFormatException("Number too large: " + new Buffer().writeHexadecimalUnsignedLong(r4).writeByte(r10).readUtf8());
    L13:
        if (r10 < 97) goto L19;
        if (r10 > 102) goto L19;
        int r12 = r10 - 97;
    L17:
        r11 = r12 + 10;
    L19:
        if (r10 < 65) goto L28;
        if (r10 > 70) goto L28;
        r12 = r10 - 65;
    L28:
        if (r0 == 0) goto L31;
        r1 = true;
        goto L32
    L31:
        throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x" + _UtilKt.toHexString(r10));
    L32:
        if (r8 != r9) goto L34;
        this.head = r6.pop();
        SegmentPool.recycle(r6);
    L35:
        if (r1 == true) goto L38;
        if (this.head != null) goto L5;
    L38:
        setSize$okio(size() - ((long) r0));
        return r4;
    L34:
        r6.pos = r8;
        goto L35
    L41:
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    public ByteString readByteString() {
        return readByteString(size());
    }

    @Override // okio.BufferedSource
    public ByteString readByteString(long r3) throws EOFException {
        if (r3 >= 0) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == false) goto L19;
        if (size() < r3) goto L17;
        if (r3 < 4096) goto L15;
        ByteString r1 = snapshot((int) r3);
        skip(r3);
        return r1;
    L15:
        return new ByteString(readByteArray(r3));
    L17:
        throw new EOFException();
    L19:
        throw new IllegalArgumentException(("byteCount: " + r3).toString());
    L5:
        if (r3 > 2147483647L) goto L7;
        r0 = true;
        goto L8
    }

    @Override // okio.BufferedSource
    public int select(Options r4) {
        Intrinsics.checkNotNullParameter(r4, "options");
        int r0 = _BufferKt.selectPrefix$default(this, r4, false, 2, null);
        if (r0 == (-1)) goto L7;
        skip(r4.getByteStrings$okio()[r0].size());
        return r0;
    L7:
        return -1;
    }

    @Override // okio.BufferedSource
    public void readFully(Buffer r3, long r4) throws EOFException {
        Intrinsics.checkNotNullParameter(r3, "sink");
        if (size() < r4) goto L6;
        r3.write(this, r4);
        return;
    L6:
        r3.write(this, size());
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    public long readAll(Sink r5) throws IOException {
        Intrinsics.checkNotNullParameter(r5, "sink");
        long r0 = size();
        if (r0 <= 0) goto L5;
        r5.write(this, r0);
    L5:
        return r0;
    }

    @Override // okio.BufferedSource
    public String readUtf8Line() throws EOFException {
        long r0 = indexOf((byte) 10);
        if (r0 == (-1)) goto L6;
        return _BufferKt.readUtf8Line(this, r0);
    L6:
        if (size() != 0) goto L11;
        return null;
    L11:
        return readUtf8(size());
    }

    @Override // okio.BufferedSource
    public String readUtf8LineStrict(long r12) throws EOFException {
        if (r12 < 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L25;
        long r1 = Long.MAX_VALUE;
        if (r12 == Long.MAX_VALUE) goto L11;
        r1 = r12 + 1;
    L11:
        long r5 = indexOf((byte) 10, 0, r1);
        if (r5 == (-1)) goto L15;
        return _BufferKt.readUtf8Line(this, r5);
    L15:
        if (r1 < size()) goto L17;
    L22:
        Buffer r6 = new Buffer();
        copyTo(r6, 0, Math.min(32, size()));
        throw new EOFException("\\n not found: limit=" + Math.min(size(), r12) + " content=" + r6.readByteString().hex() + 8230);
    L17:
        if (getByte(r1 - 1) != 13) goto L22;
        if (getByte(r1) != 10) goto L22;
        return _BufferKt.readUtf8Line(this, r1);
    L25:
        throw new IllegalArgumentException(("limit < 0: " + r12).toString());
    L5:
        r0 = false;
        goto L6
    }

    @Override // okio.BufferedSource
    public int readUtf8CodePoint() throws EOFException {
        if (size() == 0) goto L42;
        byte r0 = getByte(0);
        boolean r2 = false;
        if ((r0 & 128) != 0) goto L8;
        int r1 = r0 & 127;
        int r7 = 0;
        int r6 = 1;
    L16:
        long r10 = r6;
        if (size() < r10) goto L38;
        int r3 = 1;
    L19:
        if (r3 >= r6) goto L24;
        long r8 = r3;
        byte r12 = getByte(r8);
        if ((r12 & 192) != 128) goto L23;
        r1 = (r1 << 6) | (r12 & Utf8.REPLACEMENT_BYTE);
        r3 = r3 + 1;
        goto L19
    L23:
        skip(r8);
        return 65533;
    L24:
        skip(r10);
        if (r1 <= 1114111) goto L28;
        return 65533;
    L28:
        if (55296 <= r1) goto L30;
    L32:
        if (r2 == true) goto L48;
        if (r1 >= r7) goto L46;
        return 65533;
    L46:
        return r1;
    L48:
        return 65533;
    L30:
        if (r1 >= 57344) goto L32;
        r2 = true;
        goto L32
    L38:
        throw new EOFException("size < " + r6 + ": " + size() + " (to read code point prefixed 0x" + _UtilKt.toHexString(r0) + ')');
    L8:
        if ((r0 & 224) != 192) goto L11;
        r1 = r0 & Ascii.US;
        r6 = 2;
        r7 = 128;
        goto L16
    L11:
        if ((r0 & 240) != 224) goto L14;
        r1 = r0 & 15;
        r6 = 3;
        r7 = 2048;
        goto L16
    L14:
        if ((r0 & 248) != 240) goto L39;
        r1 = r0 & 7;
        r6 = 4;
        r7 = 65536;
        goto L16
    L39:
        skip(1);
        return 65533;
    L42:
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    public byte[] readByteArray() {
        return readByteArray(size());
    }

    @Override // okio.BufferedSource
    public byte[] readByteArray(long r3) throws EOFException {
        if (r3 >= 0) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == false) goto L16;
        if (size() < r3) goto L14;
        byte[] r4 = new byte[(int) r3];
        readFully(r4);
        return r4;
    L14:
        throw new EOFException();
    L16:
        throw new IllegalArgumentException(("byteCount: " + r3).toString());
    L5:
        if (r3 > 2147483647L) goto L7;
        r0 = true;
        goto L8
    }

    @Override // okio.BufferedSource
    public int read(byte[] r3) {
        Intrinsics.checkNotNullParameter(r3, "sink");
        return read(r3, 0, r3.length);
    }

    @Override // okio.BufferedSource
    public void readFully(byte[] r4) throws EOFException {
        Intrinsics.checkNotNullParameter(r4, "sink");
        int r0 = 0;
    L4:
        if (r0 >= r4.length) goto L10;
        int r1 = read(r4, r0, r4.length - r0);
        if (r1 == (-1)) goto L9;
        r0 = r0 + r1;
        goto L4
    L9:
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    public int read(byte[] r8, int r9, int r10) {
        Intrinsics.checkNotNullParameter(r8, "sink");
        _UtilKt.checkOffsetAndCount(r8.length, r9, r10);
        Segment r0 = this.head;
        if (r0 != null) goto L5;
        return -1;
    L5:
        int r11 = Math.min(r10, r0.limit - r0.pos);
        ArraysKt.copyInto(r0.data, r8, r9, r0.pos, r0.pos + r11);
        r0.pos += r11;
        setSize$okio(size() - ((long) r11));
        if (r0.pos != r0.limit) goto L9;
        this.head = r0.pop();
        SegmentPool.recycle(r0);
    L9:
        return r11;
    }

    public final void clear() {
        skip(size());
    }

    @Override // okio.BufferedSource
    public void skip(long r7) throws EOFException {
    L3:
        if (r7 <= 0) goto L11;
        Segment r0 = this.head;
        if (r0 == null) goto L10;
        int r1 = (int) Math.min(r7, r0.limit - r0.pos);
        long r4 = r1;
        setSize$okio(size() - r4);
        r7 = r7 - r4;
        r0.pos += r1;
        if (r0.pos != r0.limit) goto L3;
        this.head = r0.pop();
        SegmentPool.recycle(r0);
        goto L3
    L10:
        throw new EOFException();
    }

    @Override // okio.BufferedSink
    public Buffer write(ByteString r3) {
        Intrinsics.checkNotNullParameter(r3, "byteString");
        r3.write$okio(this, 0, r3.size());
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer write(ByteString r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "byteString");
        r2.write$okio(this, r3, r4);
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeUtf8(String r13, int r14, int r15) {
        Intrinsics.checkNotNullParameter(r13, "string");
        if (r14 < 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L58;
        if (r15 < r14) goto L9;
        boolean r3 = true;
    L10:
        if (r3 == false) goto L56;
        if (r15 > r13.length()) goto L14;
        boolean r4 = true;
    L15:
        if (r4 == false) goto L54;
    L16:
        if (r14 >= r15) goto L52;
        char r5 = r13.charAt(r14);
        if (r5 < 128) goto L19;
        if (r5 < 2048) goto L28;
        if (r5 < 55296) goto L51;
        if (r5 > 57343) goto L51;
        int r6 = r14 + 1;
        if (r6 >= r15) goto L38;
        char r8 = r13.charAt(r6);
    L40:
        if (r5 > 56319) goto L50;
        if (56320 <= r8) goto L44;
    L46:
        boolean r9 = false;
    L47:
        if (r9 == false) goto L50;
        int r7 = (((r5 & 1023) << 10) | (r8 & 1023)) + 65536;
        Segment r10 = writableSegment$okio(4);
        r10.data[r10.limit] = (byte) ((r7 >> 18) | 240);
        r10.data[r10.limit + 1] = (byte) (((r7 >> 12) & 63) | 128);
        r10.data[r10.limit + 2] = (byte) (((r7 >> 6) & 63) | 128);
        r10.data[r10.limit + 3] = (byte) ((r7 & 63) | 128);
        r10.limit += 4;
        setSize$okio(size() + 4);
        r14 = r14 + 2;
        goto L16
    L44:
        if (r8 >= 57344) goto L46;
        r9 = true;
    L50:
        writeByte(63);
        r14 = r6;
        goto L16
    L38:
        r8 = 0;
    L51:
        Segment r11 = writableSegment$okio(3);
        r11.data[r11.limit] = (byte) ((r5 >> '\f') | 224);
        r11.data[r11.limit + 1] = (byte) ((63 & (r5 >> 6)) | 128);
        r11.data[r11.limit + 2] = (byte) ((r5 & '?') | 128);
        r11.limit += 3;
        setSize$okio(size() + 3);
    L29:
        r14 = r14 + 1;
        goto L16
    L28:
        Segment r12 = writableSegment$okio(2);
        r12.data[r12.limit] = (byte) ((r5 >> 6) | 192);
        r12.data[r12.limit + 1] = (byte) ((r5 & '?') | 128);
        r12.limit += 2;
        setSize$okio(size() + 2);
        goto L29
    L19:
        Segment r16 = writableSegment$okio(1);
        byte[] r17 = r16.data;
        int r18 = r16.limit - r14;
        int r19 = Math.min(r15, 8192 - r18);
        int r20 = r14 + 1;
        r17[r14 + r18] = (byte) r5;
    L20:
        r14 = r20;
        if (r14 >= r19) goto L25;
        char r21 = r13.charAt(r14);
        if (r21 >= 128) goto L25;
        r20 = r14 + 1;
        r17[r14 + r18] = (byte) r21;
    L25:
        int r22 = (r18 + r14) - r16.limit;
        r16.limit += r22;
        setSize$okio(size() + ((long) r22));
        goto L16
    L52:
        return this;
    L54:
        throw new IllegalArgumentException(("endIndex > string.length: " + r15 + " > " + r13.length()).toString());
    L14:
        r4 = false;
        goto L15
    L56:
        throw new IllegalArgumentException(("endIndex < beginIndex: " + r15 + " < " + r14).toString());
    L9:
        r3 = false;
        goto L10
    L58:
        throw new IllegalArgumentException(("beginIndex < 0: " + r14).toString());
    L5:
        r2 = false;
        goto L6
    }

    @Override // okio.BufferedSink
    public Buffer writeUtf8CodePoint(int r11) {
        if (r11 >= 128) goto L6;
        writeByte(r11);
    L21:
        return this;
    L6:
        if (r11 >= 2048) goto L8;
        Segment r1 = writableSegment$okio(2);
        r1.data[r1.limit] = (byte) ((r11 >> 6) | 192);
        r1.data[r1.limit + 1] = (byte) ((r11 & 63) | 128);
        r1.limit += 2;
        setSize$okio(size() + 2);
        goto L21
    L8:
        boolean r5 = false;
        if (55296 <= r11) goto L11;
    L13:
        if (r5 == false) goto L16;
        writeByte(63);
        goto L21
    L16:
        if (r11 >= 65536) goto L19;
        Segment r2 = writableSegment$okio(3);
        r2.data[r2.limit] = (byte) ((r11 >> 12) | 224);
        r2.data[r2.limit + 1] = (byte) (((r11 >> 6) & 63) | 128);
        r2.data[r2.limit + 2] = (byte) ((r11 & 63) | 128);
        r2.limit += 3;
        setSize$okio(size() + 3);
        goto L21
    L19:
        if (r11 > 1114111) goto L23;
        Segment r6 = writableSegment$okio(4);
        r6.data[r6.limit] = (byte) ((r11 >> 18) | 240);
        r6.data[r6.limit + 1] = (byte) (((r11 >> 12) & 63) | 128);
        r6.data[r6.limit + 2] = (byte) (((r11 >> 6) & 63) | 128);
        r6.data[r6.limit + 3] = (byte) ((r11 & 63) | 128);
        r6.limit += 4;
        setSize$okio(size() + 4);
        goto L21
    L23:
        throw new IllegalArgumentException("Unexpected code point: 0x" + _UtilKt.toHexString(r11));
    L11:
        if (r11 >= 57344) goto L13;
        r5 = true;
        goto L13
    }

    @Override // okio.BufferedSink
    public Buffer write(byte[] r3) {
        Intrinsics.checkNotNullParameter(r3, "source");
        return write(r3, 0, r3.length);
    }

    @Override // okio.BufferedSink
    public Buffer write(byte[] r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "source");
        long r7 = r12;
        _UtilKt.checkOffsetAndCount(r10.length, r11, r7);
        int r13 = r12 + r11;
    L3:
        if (r11 >= r13) goto L5;
        Segment r0 = writableSegment$okio(1);
        int r1 = Math.min(r13 - r11, 8192 - r0.limit);
        int r4 = r11 + r1;
        ArraysKt.copyInto(r10, r0.data, r0.limit, r11, r4);
        r0.limit += r1;
        r11 = r4;
        goto L3
    L5:
        setSize$okio(size() + r7);
        return this;
    }

    @Override // okio.BufferedSink
    public long writeAll(Source r7) throws IOException {
        Intrinsics.checkNotNullParameter(r7, "source");
        long r0 = 0;
    L3:
        long r2 = r7.read(this, 8192);
        if (r2 == (-1)) goto L6;
        r0 = r0 + r2;
        goto L3
    L6:
        return r0;
    }

    @Override // okio.BufferedSink
    public Buffer write(Source r5, long r6) throws IOException {
        Intrinsics.checkNotNullParameter(r5, "source");
    L4:
        if (r6 <= 0) goto L10;
        long r0 = r5.read(this, r6);
        if (r0 == (-1)) goto L9;
        r6 = r6 - r0;
        goto L4
    L9:
        throw new EOFException();
    L10:
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeByte(int r5) {
        Segment r0 = writableSegment$okio(1);
        byte[] r1 = r0.data;
        int r2 = r0.limit;
        r0.limit = r2 + 1;
        r1[r2] = (byte) r5;
        setSize$okio(size() + 1);
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeShort(int r6) {
        Segment r0 = writableSegment$okio(2);
        byte[] r1 = r0.data;
        int r2 = r0.limit;
        int r3 = r2 + 1;
        r1[r2] = (byte) ((r6 >>> 8) & 255);
        r1[r3] = (byte) (r6 & 255);
        r0.limit = r3 + 1;
        setSize$okio(size() + 2);
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeInt(int r6) {
        Segment r0 = writableSegment$okio(4);
        byte[] r1 = r0.data;
        int r2 = r0.limit;
        int r3 = r2 + 1;
        r1[r2] = (byte) ((r6 >>> 24) & 255);
        int r4 = r3 + 1;
        r1[r3] = (byte) ((r6 >>> 16) & 255);
        int r5 = r4 + 1;
        r1[r4] = (byte) ((r6 >>> 8) & 255);
        r1[r5] = (byte) (r6 & 255);
        r0.limit = r5 + 1;
        setSize$okio(size() + 4);
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeLong(long r10) {
        Segment r1 = writableSegment$okio(8);
        byte[] r2 = r1.data;
        int r3 = r1.limit;
        int r4 = r3 + 1;
        r2[r3] = (byte) ((r10 >>> 56) & 255);
        int r5 = r4 + 1;
        r2[r4] = (byte) ((r10 >>> 48) & 255);
        int r6 = r5 + 1;
        r2[r5] = (byte) ((r10 >>> 40) & 255);
        int r7 = r6 + 1;
        r2[r6] = (byte) ((r10 >>> 32) & 255);
        int r8 = r7 + 1;
        r2[r7] = (byte) ((r10 >>> 24) & 255);
        int r9 = r8 + 1;
        r2[r8] = (byte) ((r10 >>> 16) & 255);
        int r11 = r9 + 1;
        r2[r9] = (byte) ((r10 >>> 8) & 255);
        r2[r11] = (byte) (r10 & 255);
        r1.limit = r11 + 1;
        setSize$okio(size() + 8);
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeDecimalLong(long r13) {
        if (r13 == 0) goto L78;
        int r3 = 1;
        if (r13 >= 0) goto L11;
        r13 = -r13;
        if (r13 < 0) goto L79;
        boolean r2 = true;
    L13:
        if (r13 >= 100000000) goto L37;
        if (r13 >= 10000) goto L27;
        if (r13 >= 100) goto L23;
        if (r13 < 10) goto L67;
        r3 = 2;
    L67:
        if (r2 == false) goto L69;
        r3 = r3 + 1;
    L69:
        Segment r4 = writableSegment$okio(r3);
        byte[] r6 = r4.data;
        int r7 = r4.limit + r3;
    L71:
        if (r13 == 0) goto L73;
        long r8 = 10;
        r7 = r7 - 1;
        r6[r7] = _BufferKt.getHEX_DIGIT_BYTES()[(int) (r13 % r8)];
        r13 = r13 / r8;
        goto L71
    L73:
        if (r2 == false) goto L75;
        r6[r7 - 1] = 45;
    L75:
        r4.limit += r3;
        setSize$okio(size() + ((long) r3));
        return this;
    L23:
        if (r13 >= 1000) goto L25;
        r3 = 3;
        goto L67
    L25:
        r3 = 4;
        goto L67
    L27:
        if (r13 >= 1000000) goto L33;
        if (r13 >= 100000) goto L31;
        r3 = 5;
        goto L67
    L31:
        r3 = 6;
        goto L67
    L33:
        if (r13 >= StackLeakChecker.CHECK_INTERVAL_10_SEC) goto L35;
        r3 = 7;
        goto L67
    L35:
        r3 = 8;
        goto L67
    L37:
        if (r13 >= 1000000000000L) goto L49;
        if (r13 >= RealConnection.IDLE_CONNECTION_HEALTHY_NS) goto L45;
        if (r13 >= 1000000000) goto L43;
        r3 = 9;
        goto L67
    L43:
        r3 = 10;
        goto L67
    L45:
        if (r13 >= 100000000000L) goto L47;
        r3 = 11;
        goto L67
    L47:
        r3 = 12;
        goto L67
    L49:
        if (r13 >= 1000000000000000L) goto L58;
        if (r13 >= 10000000000000L) goto L54;
        r3 = 13;
        goto L67
    L54:
        if (r13 >= 100000000000000L) goto L56;
        r3 = 14;
        goto L67
    L56:
        r3 = 15;
        goto L67
    L58:
        if (r13 >= 100000000000000000L) goto L64;
        if (r13 >= 10000000000000000L) goto L62;
        r3 = 16;
        goto L67
    L62:
        r3 = 17;
        goto L67
    L64:
        if (r13 >= 1000000000000000000L) goto L66;
        r3 = 18;
        goto L67
    L66:
        r3 = 19;
        goto L67
    L79:
        return writeUtf8("-9223372036854775808");
    L11:
        r2 = false;
        goto L13
    L78:
        return writeByte(48);
    }

    @Override // okio.BufferedSink
    public Buffer writeHexadecimalUnsignedLong(long r13) {
        if (r13 == 0) goto L11;
        long r1 = (r13 >>> 1) | r13;
        long r2 = r1 | (r1 >>> 2);
        long r3 = r2 | (r2 >>> 4);
        long r4 = r3 | (r3 >>> 8);
        long r5 = r4 | (r4 >>> 16);
        long r6 = r5 | (r5 >>> 32);
        long r7 = r6 - ((r6 >>> 1) & 6148914691236517205L);
        long r8 = ((r7 >>> 2) & 3689348814741910323L) + (r7 & 3689348814741910323L);
        long r9 = ((r8 >>> 4) + r8) & 1085102592571150095L;
        long r10 = r9 + (r9 >>> 8);
        long r11 = r10 + (r10 >>> 16);
        int r12 = (int) ((((r11 & 63) + ((r11 >>> 32) & 63)) + ((long) 3)) / ((long) 4));
        Segment r14 = writableSegment$okio(r12);
        byte[] r15 = r14.data;
        int r16 = (r14.limit + r12) - 1;
        int r0 = r14.limit;
    L6:
        if (r16 < r0) goto L8;
        r15[r16] = _BufferKt.getHEX_DIGIT_BYTES()[(int) (15 & r13)];
        r13 = r13 >>> 4;
        r16 = r16 - 1;
        goto L6
    L8:
        r14.limit += r12;
        setSize$okio(size() + ((long) r12));
        return this;
    L11:
        return writeByte(48);
    }

    public final Segment writableSegment$okio(int r3) {
        boolean r1 = true;
        if (r3 < 1) goto L6;
        if (r3 > 8192) goto L6;
    L7:
        if (r1 == false) goto L19;
        Segment r2 = this.head;
        if (r2 != null) goto L11;
        Segment r4 = SegmentPool.take();
        this.head = r4;
        r4.prev = r4;
        r4.next = r4;
        return r4;
    L11:
        Intrinsics.checkNotNull(r2);
        Segment r5 = r2.prev;
        Intrinsics.checkNotNull(r5);
        if ((r5.limit + r3) <= 8192) goto L14;
    L15:
        r5 = r5.push(SegmentPool.take());
    L17:
        return r5;
    L14:
        if (r5.owner == true) goto L17;
    L19:
        throw new IllegalArgumentException("unexpected capacity".toString());
    L6:
        r1 = false;
        goto L7
    }

    @Override // okio.Sink
    public void write(Buffer r9, long r10) {
        Intrinsics.checkNotNullParameter(r9, "source");
        if (r9 == this) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L34;
        _UtilKt.checkOffsetAndCount(r9.size(), 0, r10);
    L9:
        if (r10 <= 0) goto L39;
        Segment r2 = r9.head;
        Intrinsics.checkNotNull(r2);
        int r3 = r2.limit;
        Segment r4 = r9.head;
        Intrinsics.checkNotNull(r4);
        if (r10 >= (r3 - r4.pos)) goto L27;
        Segment r5 = this.head;
        if (r5 == null) goto L15;
        Intrinsics.checkNotNull(r5);
        Segment r6 = r5.prev;
    L16:
        if (r6 != null) goto L18;
    L26:
        Segment r7 = r9.head;
        Intrinsics.checkNotNull(r7);
        r9.head = r7.split((int) r10);
        goto L27
    L18:
        if (r6.owner == false) goto L26;
        long r8 = ((long) r6.limit) + r10;
        if (r6.shared == false) goto L22;
        int r11 = 0;
    L24:
        if ((r8 - ((long) r11)) > 8192) goto L26;
        Segment r0 = r9.head;
        Intrinsics.checkNotNull(r0);
        r0.writeTo(r6, (int) r10);
        r9.setSize$okio(r9.size() - r10);
        setSize$okio(size() + r10);
        return;
    L22:
        r11 = r6.pos;
        goto L24
    L15:
        r6 = null;
    L27:
        Segment r12 = r9.head;
        Intrinsics.checkNotNull(r12);
        long r13 = r12.limit - r12.pos;
        r9.head = r12.pop();
        Segment r14 = this.head;
        if (r14 != null) goto L30;
        this.head = r12;
        r12.prev = r12;
        r12.next = r12.prev;
    L31:
        r9.setSize$okio(r9.size() - r13);
        setSize$okio(size() + r13);
        r10 = r10 - r13;
        goto L9
    L30:
        Intrinsics.checkNotNull(r14);
        Segment r15 = r14.prev;
        Intrinsics.checkNotNull(r15);
        r15.push(r12).compact();
        goto L31
    L39:
        return;
    L34:
        throw new IllegalArgumentException("source == this".toString());
    L5:
        r1 = false;
        goto L6
    }

    @Override // okio.Source
    public long read(Buffer r5, long r6) {
        Intrinsics.checkNotNullParameter(r5, "sink");
        if (r6 < 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L16;
        if (size() != 0) goto L11;
        return -1;
    L11:
        if (r6 <= size()) goto L13;
        r6 = size();
    L13:
        r5.write(this, r6);
        return r6;
    L16:
        throw new IllegalArgumentException(("byteCount < 0: " + r6).toString());
    L5:
        r2 = false;
        goto L6
    }

    @Override // okio.BufferedSource
    public long indexOf(byte r10, long r11, long r13) {
        long r0 = 0;
        boolean r3 = false;
        if (0 <= r11) goto L5;
    L7:
        if (r3 == false) goto L50;
        if (r13 <= size()) goto L12;
        r13 = size();
    L12:
        if (r11 == r13) goto L59;
        Segment r2 = this.head;
        if (r2 != null) goto L18;
        return -1;
    L18:
        if ((size() - r11) >= r11) goto L34;
        r0 = size();
    L21:
        if (r0 <= r11) goto L23;
        r2 = r2.prev;
        Intrinsics.checkNotNull(r2);
        r0 = r0 - ((long) (r2.limit - r2.pos));
        goto L21
    L23:
        if (r2 != null) goto L26;
        return -1;
    L26:
        if (r0 >= r13) goto L63;
        byte[] r9 = r2.data;
        int r5 = (int) Math.min(r2.limit, (((long) r2.pos) + r13) - r0);
        int r12 = (int) ((((long) r2.pos) + r11) - r0);
    L28:
        if (r12 >= r5) goto L33;
        if (r9[r12] == r10) goto L48;
        r12 = r12 + 1;
    L48:
        return ((long) (r12 - r2.pos)) + r0;
    L33:
        r0 = r0 + ((long) (r2.limit - r2.pos));
        r2 = r2.next;
        Intrinsics.checkNotNull(r2);
        r11 = r0;
        goto L26
    L63:
        return -1;
    L34:
        long r6 = ((long) (r2.limit - r2.pos)) + r0;
        if (r6 > r11) goto L37;
        r2 = r2.next;
        Intrinsics.checkNotNull(r2);
        r0 = r6;
        goto L34
    L37:
        if (r2 != null) goto L40;
        return -1;
    L40:
        if (r0 >= r13) goto L64;
        byte[] r14 = r2.data;
        int r7 = (int) Math.min(r2.limit, (((long) r2.pos) + r13) - r0);
        r12 = (int) ((((long) r2.pos) + r11) - r0);
    L42:
        if (r12 >= r7) goto L47;
        if (r14[r12] == r10) goto L48;
        r12 = r12 + 1;
        goto L42
    L47:
        r0 = r0 + ((long) (r2.limit - r2.pos));
        r2 = r2.next;
        Intrinsics.checkNotNull(r2);
        r11 = r0;
        goto L40
    L64:
        return -1;
    L59:
        return -1;
    L50:
        throw new IllegalArgumentException(("size=" + size() + " fromIndex=" + r11 + " toIndex=" + r13).toString());
    L5:
        if (r11 > r13) goto L7;
        r3 = true;
        goto L7
    }

    @Override // okio.BufferedSource
    public long indexOf(ByteString r17, long r18) throws IOException {
        long r0 = r18;
        Intrinsics.checkNotNullParameter(r17, "bytes");
        if (r17.size() <= 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L57;
        long r6 = 0;
        if (r0 < 0) goto L10;
        boolean r3 = true;
    L11:
        if (r3 == false) goto L55;
        Segment r8 = this.head;
        if (r8 != null) goto L16;
    L14:
        return -1;
    L16:
        if ((size() - r0) >= r0) goto L35;
        long r7 = size();
    L19:
        if (r7 <= r0) goto L21;
        r8 = r8.prev;
        Intrinsics.checkNotNull(r8);
        r7 = r7 - ((long) (r8.limit - r8.pos));
        goto L19
    L21:
        if (r8 == null) goto L14;
        byte[] r11 = r17.internalArray$okio();
        byte r4 = r11[0];
        int r5 = r17.size();
        long r14 = (size() - ((long) r5)) + 1;
    L25:
        if (r7 >= r14) goto L14;
        byte[] r9 = r8.data;
        int r10 = (int) Math.min(r8.limit, (((long) r8.pos) + r14) - r7);
        int r1 = (int) ((((long) r8.pos) + r0) - r7);
    L27:
        if (r1 >= r10) goto L34;
        if (r9[r1] != r4) goto L33;
        if (_BufferKt.rangeEquals(r8, r1 + 1, r11, 1, r5) == false) goto L33;
        return ((long) (r1 - r8.pos)) + r7;
    L33:
        r1 = r1 + 1;
        goto L27
    L34:
        r7 = r7 + ((long) (r8.limit - r8.pos));
        r8 = r8.next;
        Intrinsics.checkNotNull(r8);
        r0 = r7;
    L35:
        long r12 = ((long) (r8.limit - r8.pos)) + r6;
        if (r12 > r0) goto L38;
        r8 = r8.next;
        Intrinsics.checkNotNull(r8);
        r6 = r12;
        goto L35
    L38:
        if (r8 == null) goto L14;
        byte[] r13 = r17.internalArray$okio();
        byte r15 = r13[0];
        int r16 = r17.size();
        long r19 = (size() - ((long) r16)) + 1;
    L42:
        if (r6 >= r19) goto L14;
        byte[] r20 = r8.data;
        long r110 = r6;
        int r21 = (int) Math.min(r8.limit, (((long) r8.pos) + r19) - r6);
        int r22 = (int) ((((long) r8.pos) + r0) - r110);
    L44:
        if (r22 >= r21) goto L52;
        if (r20[r22] != r15) goto L51;
        if (_BufferKt.rangeEquals(r8, r22 + 1, r13, 1, r16) == false) goto L51;
        return ((long) (r22 - r8.pos)) + r110;
    L51:
        r22 = r22 + 1;
        goto L44
    L52:
        r6 = r110 + ((long) (r8.limit - r8.pos));
        r8 = r8.next;
        Intrinsics.checkNotNull(r8);
        r0 = r6;
        goto L42
    L55:
        throw new IllegalArgumentException(("fromIndex < 0: " + r0).toString());
    L10:
        r3 = false;
        goto L11
    L57:
        throw new IllegalArgumentException("bytes is empty".toString());
    L5:
        r2 = false;
        goto L6
    }

    @Override // okio.BufferedSource
    public long indexOfElement(ByteString r12, long r13) {
        Intrinsics.checkNotNullParameter(r12, "targetBytes");
        long r0 = 0;
        if (r13 < 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L79;
        Segment r3 = this.head;
        if (r3 != null) goto L11;
        return -1;
    L11:
        if ((size() - r13) >= r13) goto L44;
        r0 = size();
    L14:
        if (r0 <= r13) goto L16;
        r3 = r3.prev;
        Intrinsics.checkNotNull(r3);
        r0 = r0 - ((long) (r3.limit - r3.pos));
        goto L14
    L16:
        if (r3 != null) goto L19;
        return -1;
    L19:
        if (r12.size() != 2) goto L31;
        byte r4 = r12.getByte(0);
        byte r14 = r12.getByte(1);
    L22:
        if (r0 >= size()) goto L101;
        byte[] r5 = r3.data;
        int r15 = (int) ((((long) r3.pos) + r13) - r0);
        int r16 = r3.limit;
    L24:
        if (r15 >= r16) goto L30;
        byte r7 = r5[r15];
        if (r7 == r4) goto L61;
        if (r7 == r14) goto L61;
        r15 = r15 + 1;
    L61:
        int r11 = r3.pos;
    L77:
        return ((long) (r15 - r11)) + r0;
    L30:
        r0 = r0 + ((long) (r3.limit - r3.pos));
        r3 = r3.next;
        Intrinsics.checkNotNull(r3);
        r13 = r0;
        goto L22
    L101:
        return -1;
    L31:
        byte[] r17 = r12.internalArray$okio();
    L33:
        if (r0 >= size()) goto L102;
        byte[] r6 = r3.data;
        r15 = (int) ((((long) r3.pos) + r13) - r0);
        int r18 = r3.limit;
    L35:
        if (r15 >= r18) goto L43;
        byte r8 = r6[r15];
        int r9 = r17.length;
        int r10 = 0;
    L37:
        if (r10 >= r9) goto L42;
        if (r8 == r17[r10]) goto L73;
        r10 = r10 + 1;
    L73:
        r11 = r3.pos;
        goto L77
    L42:
        r15 = r15 + 1;
        goto L35
    L43:
        r0 = r0 + ((long) (r3.limit - r3.pos));
        r3 = r3.next;
        Intrinsics.checkNotNull(r3);
        r13 = r0;
        goto L33
    L102:
        return -1;
    L44:
        long r19 = ((long) (r3.limit - r3.pos)) + r0;
        if (r19 > r13) goto L47;
        r3 = r3.next;
        Intrinsics.checkNotNull(r3);
        r0 = r19;
        goto L44
    L47:
        if (r3 != null) goto L50;
        return -1;
    L50:
        if (r12.size() != 2) goto L64;
        byte r20 = r12.getByte(0);
        byte r110 = r12.getByte(1);
    L53:
        if (r0 >= size()) goto L103;
        byte[] r21 = r3.data;
        r15 = (int) ((((long) r3.pos) + r13) - r0);
        int r111 = r3.limit;
    L55:
        if (r15 >= r111) goto L63;
        byte r22 = r21[r15];
        if (r22 == r20) goto L61;
        if (r22 == r110) goto L61;
        r15 = r15 + 1;
        goto L55
    L63:
        r0 = r0 + ((long) (r3.limit - r3.pos));
        r3 = r3.next;
        Intrinsics.checkNotNull(r3);
        r13 = r0;
        goto L53
    L103:
        return -1;
    L64:
        byte[] r112 = r12.internalArray$okio();
    L66:
        if (r0 >= size()) goto L104;
        byte[] r23 = r3.data;
        r15 = (int) ((((long) r3.pos) + r13) - r0);
        int r113 = r3.limit;
    L68:
        if (r15 >= r113) goto L76;
        byte r24 = r23[r15];
        int r25 = r112.length;
        int r26 = 0;
    L70:
        if (r26 >= r25) goto L75;
        if (r24 == r112[r26]) goto L73;
        r26 = r26 + 1;
        goto L70
    L75:
        r15 = r15 + 1;
        goto L68
    L76:
        r0 = r0 + ((long) (r3.limit - r3.pos));
        r3 = r3.next;
        Intrinsics.checkNotNull(r3);
        r13 = r0;
        goto L66
    L104:
        return -1;
    L79:
        throw new IllegalArgumentException(("fromIndex < 0: " + r13).toString());
    L5:
        r2 = false;
        goto L6
    }

    @Override // okio.BufferedSource
    public boolean rangeEquals(long r7, ByteString r9, int r10, int r11) {
        Intrinsics.checkNotNullParameter(r9, "bytes");
        if (r7 < 0) goto L21;
        if (r10 < 0) goto L22;
        if (r11 >= 0) goto L7;
        return false;
    L7:
        if ((size() - r7) >= r11) goto L9;
        return false;
    L9:
        if ((r9.size() - r10) < r11) goto L25;
        int r0 = 0;
    L12:
        if (r0 >= r11) goto L17;
        if (getByte(((long) r0) + r7) != r9.getByte(r10 + r0)) goto L26;
        r0 = r0 + 1;
        goto L12
    L26:
        return false;
    L17:
        return true;
    L25:
        return false;
    L22:
        return false;
    L21:
        return false;
    }

    public boolean equals(Object r19) {
        if (this != r19) goto L6;
        return true;
    L6:
        if ((r19 instanceof Buffer) == false) goto L31;
        Buffer r1 = (Buffer) r19;
        if (size() != r1.size()) goto L31;
        if (size() == 0) goto L38;
        Segment r3 = this.head;
        Intrinsics.checkNotNull(r3);
        Segment r2 = r1.head;
        Intrinsics.checkNotNull(r2);
        int r5 = r3.pos;
        int r6 = r2.pos;
        long r9 = 0;
    L16:
        if (r9 >= size()) goto L39;
        long r11 = Math.min(r3.limit - r5, r2.limit - r6);
        long r13 = 0;
    L19:
        if (r13 >= r11) goto L25;
        int r16 = r5 + 1;
        int r17 = r6 + 1;
        if (r3.data[r5] != r2.data[r6]) goto L31;
        r13 = r13 + 1;
        r5 = r16;
        r6 = r17;
        goto L19
    L25:
        if (r5 != r3.limit) goto L28;
        r3 = r3.next;
        Intrinsics.checkNotNull(r3);
        r5 = r3.pos;
    L28:
        if (r6 != r2.limit) goto L30;
        r2 = r2.next;
        Intrinsics.checkNotNull(r2);
        r6 = r2.pos;
    L30:
        r9 = r9 + r11;
        goto L16
    L39:
        return true;
    L38:
        return true;
    L31:
        return false;
    }

    public int hashCode() {
        Segment r0 = this.head;
        if (r0 != null) goto L5;
        return 0;
    L5:
        int r1 = 1;
    L6:
        int r2 = r0.pos;
        int r3 = r0.limit;
    L7:
        if (r2 >= r3) goto L9;
        r1 = (r1 * 31) + r0.data[r2];
        r2 = r2 + 1;
        goto L7
    L9:
        r0 = r0.next;
        Intrinsics.checkNotNull(r0);
        if (r0 != this.head) goto L6;
        return r1;
    }

    public final Buffer copy() {
        Buffer r0 = new Buffer();
        if (size() == 0) goto L9;
        Segment r1 = this.head;
        Intrinsics.checkNotNull(r1);
        Segment r2 = r1.sharedCopy();
        r0.head = r2;
        r2.prev = r2;
        r2.next = r2.prev;
        Segment r3 = r1.next;
    L6:
        if (r3 == r1) goto L8;
        Segment r4 = r2.prev;
        Intrinsics.checkNotNull(r4);
        Intrinsics.checkNotNull(r3);
        r4.push(r3.sharedCopy());
        r3 = r3.next;
        goto L6
    L8:
        r0.setSize$okio(size());
    L9:
        return r0;
    }

    public final ByteString snapshot() {
        if (size() > 2147483647L) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        return snapshot((int) size());
    L10:
        throw new IllegalStateException(("size > Int.MAX_VALUE: " + size()).toString());
    L5:
        r0 = false;
        goto L6
    }

    public final ByteString snapshot(int r7) {
        if (r7 == 0) goto L19;
        _UtilKt.checkOffsetAndCount(size(), 0, r7);
        Segment r0 = this.head;
        int r1 = 0;
        int r2 = 0;
        int r3 = 0;
    L5:
        if (r2 >= r7) goto L11;
        Intrinsics.checkNotNull(r0);
        if (r0.limit == r0.pos) goto L10;
        r2 = r2 + (r0.limit - r0.pos);
        r3 = r3 + 1;
        r0 = r0.next;
        goto L5
    L10:
        throw new AssertionError("s.limit == s.pos");
    L11:
        byte[][] r4 = new byte[r3][];
        int[] r5 = new int[r3 * 2];
        Segment r6 = this.head;
        int r8 = 0;
    L12:
        if (r1 >= r7) goto L15;
        Intrinsics.checkNotNull(r6);
        r4[r8] = r6.data;
        r1 = r1 + (r6.limit - r6.pos);
        r5[r8] = Math.min(r1, r7);
        r5[r4.length + r8] = r6.pos;
        r6.shared = true;
        r8 = r8 + 1;
        r6 = r6.next;
        goto L12
    L15:
        return new SegmentedByteString(r4, r5);
    L19:
        return ByteString.EMPTY;
    }
}
