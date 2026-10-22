package kotlinx.coroutines.debug.internal;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.alog.AlogMonitor;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.KotlinVersion;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.concurrent.ThreadsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineId;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.internal.ScopeCoroutine;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;

/* JADX INFO: compiled from: DebugProbesImpl.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000Ö\u0001\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\bÀ\u0002\u0018\u00002\u00020\u0014:\u0002\u0095\u0001B\t\b\u0002¢\u0006\u0004\b\u0001\u0010\u0002J3\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u0013\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\u0004\b\u0015\u0010\u0016J@\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f\"\b\b\u0000\u0010\u0017*\u00020\u00142\u001e\b\u0004\u0010\u001b\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0019\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00028\u00000\u0018H\u0082\b¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001e\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001e\u0010\u000eJ\u0013\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u000f¢\u0006\u0004\b \u0010\u0012J)\u0010$\u001a\b\u0012\u0004\u0012\u00020\"0\u000f2\u0006\u0010!\u001a\u00020\u00102\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0\u000f¢\u0006\u0004\b$\u0010%J\u0015\u0010'\u001a\u00020&2\u0006\u0010!\u001a\u00020\u0010¢\u0006\u0004\b'\u0010(J5\u0010,\u001a\b\u0012\u0004\u0012\u00020\"0\u000f2\u0006\u0010)\u001a\u00020&2\b\u0010+\u001a\u0004\u0018\u00010*2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0\u000fH\u0002¢\u0006\u0004\b,\u0010-J?\u00102\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020.012\u0006\u0010/\u001a\u00020.2\f\u00100\u001a\b\u0012\u0004\u0012\u00020\"0\u00132\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0\u000fH\u0002¢\u0006\u0004\b2\u00103J3\u00105\u001a\u00020.2\u0006\u00104\u001a\u00020.2\f\u00100\u001a\b\u0012\u0004\u0012\u00020\"0\u00132\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0\u000fH\u0002¢\u0006\u0004\b5\u00106J\u001d\u00109\u001a\u0010\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020\f\u0018\u000107H\u0002¢\u0006\u0004\b9\u0010:J\u0015\u0010=\u001a\u00020&2\u0006\u0010<\u001a\u00020;¢\u0006\u0004\b=\u0010>J\r\u0010?\u001a\u00020\f¢\u0006\u0004\b?\u0010\u0002J%\u0010A\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n2\f\u0010@\u001a\b\u0012\u0004\u0012\u00020\"0\u000fH\u0002¢\u0006\u0004\bA\u0010BJ\u001b\u0010D\u001a\u00020\f2\n\u0010C\u001a\u0006\u0012\u0002\b\u00030\u0019H\u0002¢\u0006\u0004\bD\u0010EJ)\u0010H\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0000¢\u0006\u0004\bF\u0010GJ\u001b\u0010K\u001a\u00020\f2\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0000¢\u0006\u0004\bI\u0010JJ\u001b\u0010M\u001a\u00020\f2\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0000¢\u0006\u0004\bL\u0010JJ'\u0010P\u001a\b\u0012\u0004\u0012\u00020\"0\u000f\"\b\b\u0000\u0010\u0003*\u00020N2\u0006\u0010O\u001a\u00028\u0000H\u0002¢\u0006\u0004\bP\u0010QJ\u000f\u0010R\u001a\u00020\fH\u0002¢\u0006\u0004\bR\u0010\u0002J\u000f\u0010S\u001a\u00020\fH\u0002¢\u0006\u0004\bS\u0010\u0002J\r\u0010T\u001a\u00020\f¢\u0006\u0004\bT\u0010\u0002J\u001f\u0010V\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020U2\u0006\u0010)\u001a\u00020&H\u0002¢\u0006\u0004\bV\u0010WJ#\u0010X\u001a\u00020\f2\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010)\u001a\u00020&H\u0002¢\u0006\u0004\bX\u0010YJ/\u0010X\u001a\u00020\f2\n\u0010C\u001a\u0006\u0012\u0002\b\u00030\u00192\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010)\u001a\u00020&H\u0002¢\u0006\u0004\bX\u0010ZJ;\u0010b\u001a\u00020\f*\u00020;2\u0012\u0010]\u001a\u000e\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020\\0[2\n\u0010`\u001a\u00060^j\u0002`_2\u0006\u0010a\u001a\u00020&H\u0002¢\u0006\u0004\bb\u0010cJ\u0017\u0010d\u001a\u000208*\u0006\u0012\u0002\b\u00030\u0019H\u0002¢\u0006\u0004\bd\u0010eJ\u001d\u0010C\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0019*\u0006\u0012\u0002\b\u00030\u0004H\u0002¢\u0006\u0004\bC\u0010fJ\u001a\u0010C\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0019*\u00020UH\u0082\u0010¢\u0006\u0004\bC\u0010gJ\u0016\u0010h\u001a\u0004\u0018\u00010U*\u00020UH\u0082\u0010¢\u0006\u0004\bh\u0010iJ\u001b\u0010j\u001a\u0004\u0018\u00010\u0006*\b\u0012\u0004\u0012\u00020\"0\u000fH\u0002¢\u0006\u0004\bj\u0010kJ\u0013\u0010l\u001a\u00020&*\u00020\u0014H\u0002¢\u0006\u0004\bl\u0010mR\u0014\u0010n\u001a\u00020&8\u0002X\u0082T¢\u0006\u0006\n\u0004\bn\u0010oR \u0010q\u001a\u000e\u0012\u0004\u0012\u00020U\u0012\u0004\u0012\u00020\\0p8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bq\u0010rR\u001e\u0010v\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00190s8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bt\u0010uR$\u0010w\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0019\u0012\u0004\u0012\u0002080p8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bw\u0010rR\u0014\u0010y\u001a\u00020x8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\by\u0010zR\u0014\u0010|\u001a\u00020{8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b|\u0010}R\"\u0010~\u001a\u0010\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020\f\u0018\u0001078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b~\u0010\u007fR)\u0010\u0080\u0001\u001a\u0002088\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0080\u0001\u0010\u0081\u0001\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001\"\u0006\b\u0084\u0001\u0010\u0085\u0001R\u0019\u0010\u0086\u0001\u001a\u00020.8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0086\u0001\u0010\u0087\u0001R\u0017\u0010\u0089\u0001\u001a\u0002088@X\u0080\u0004¢\u0006\b\u001a\u0006\b\u0088\u0001\u0010\u0083\u0001R)\u0010\u008a\u0001\u001a\u0002088\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u008a\u0001\u0010\u0081\u0001\u001a\u0006\b\u008b\u0001\u0010\u0083\u0001\"\u0006\b\u008c\u0001\u0010\u0085\u0001R\u001b\u0010\u008d\u0001\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008d\u0001\u0010\u008e\u0001R\"\u0010\u0092\u0001\u001a\u00020&*\u00020;8BX\u0082\u0004¢\u0006\u000f\u0012\u0006\b\u0090\u0001\u0010\u0091\u0001\u001a\u0005\b\u008f\u0001\u0010>R\u001b\u0010\u0093\u0001\u001a\u000208*\u00020\"8BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u0093\u0001\u0010\u0094\u0001¨\u0006\u0096\u0001"}, d2 = {"Lkotlinx/coroutines/debug/internal/DebugProbesImpl;", "<init>", "()V", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/coroutines/Continuation;", "completion", "Lkotlinx/coroutines/debug/internal/StackTraceFrame;", "frame", "createOwner", "(Lkotlin/coroutines/Continuation;Lkotlinx/coroutines/debug/internal/StackTraceFrame;)Lkotlin/coroutines/Continuation;", "Ljava/io/PrintStream;", "out", "", "dumpCoroutines", "(Ljava/io/PrintStream;)V", "", "Lkotlinx/coroutines/debug/internal/DebugCoroutineInfo;", "dumpCoroutinesInfo", "()Ljava/util/List;", "", "", "dumpCoroutinesInfoAsJsonAndReferences", "()[Ljava/lang/Object;", "R", "Lkotlin/Function2;", "Lkotlinx/coroutines/debug/internal/DebugProbesImpl$CoroutineOwner;", "Lkotlin/coroutines/CoroutineContext;", "create", "dumpCoroutinesInfoImpl", "(Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "dumpCoroutinesSynchronized", "Lkotlinx/coroutines/debug/internal/DebuggerInfo;", "dumpDebuggerInfo", AlogMonitor.ALOG_RESULT_INFO, "Ljava/lang/StackTraceElement;", "coroutineTrace", "enhanceStackTraceWithThreadDump", "(Lkotlinx/coroutines/debug/internal/DebugCoroutineInfo;Ljava/util/List;)Ljava/util/List;", "", "enhanceStackTraceWithThreadDumpAsJson", "(Lkotlinx/coroutines/debug/internal/DebugCoroutineInfo;)Ljava/lang/String;", "state", "Ljava/lang/Thread;", "thread", "enhanceStackTraceWithThreadDumpImpl", "(Ljava/lang/String;Ljava/lang/Thread;Ljava/util/List;)Ljava/util/List;", "", "indexOfResumeWith", "actualTrace", "Lkotlin/Pair;", "findContinuationStartIndex", "(I[Ljava/lang/StackTraceElement;Ljava/util/List;)Lkotlin/Pair;", "frameIndex", "findIndexOfFrame", "(I[Ljava/lang/StackTraceElement;Ljava/util/List;)I", "Lkotlin/Function1;", "", "getDynamicAttach", "()Lkotlin/jvm/functions/Function1;", "Lkotlinx/coroutines/Job;", "job", "hierarchyToString", "(Lkotlinx/coroutines/Job;)Ljava/lang/String;", "install", "frames", "printStackTrace", "(Ljava/io/PrintStream;Ljava/util/List;)V", "owner", "probeCoroutineCompleted", "(Lkotlinx/coroutines/debug/internal/DebugProbesImpl$CoroutineOwner;)V", "probeCoroutineCreated$kotlinx_coroutines_core", "(Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "probeCoroutineCreated", "probeCoroutineResumed$kotlinx_coroutines_core", "(Lkotlin/coroutines/Continuation;)V", "probeCoroutineResumed", "probeCoroutineSuspended$kotlinx_coroutines_core", "probeCoroutineSuspended", "", "throwable", "sanitizeStackTrace", "(Ljava/lang/Throwable;)Ljava/util/List;", "startWeakRefCleanerThread", "stopWeakRefCleanerThread", "uninstall", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "updateRunningState", "(Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;Ljava/lang/String;)V", "updateState", "(Lkotlin/coroutines/Continuation;Ljava/lang/String;)V", "(Lkotlinx/coroutines/debug/internal/DebugProbesImpl$CoroutineOwner;Lkotlin/coroutines/Continuation;Ljava/lang/String;)V", "", "Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;", "map", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "builder", "indent", "build", "(Lkotlinx/coroutines/Job;Ljava/util/Map;Ljava/lang/StringBuilder;Ljava/lang/String;)V", "isFinished", "(Lkotlinx/coroutines/debug/internal/DebugProbesImpl$CoroutineOwner;)Z", "(Lkotlin/coroutines/Continuation;)Lkotlinx/coroutines/debug/internal/DebugProbesImpl$CoroutineOwner;", "(Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;)Lkotlinx/coroutines/debug/internal/DebugProbesImpl$CoroutineOwner;", "realCaller", "(Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;)Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "toStackTraceFrame", "(Ljava/util/List;)Lkotlinx/coroutines/debug/internal/StackTraceFrame;", "toStringWithQuotes", "(Ljava/lang/Object;)Ljava/lang/String;", "ARTIFICIAL_FRAME_MESSAGE", "Ljava/lang/String;", "Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap;", "callerInfoCache", "Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap;", "", "getCapturedCoroutines", "()Ljava/util/Set;", "capturedCoroutines", "capturedCoroutinesMap", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "coroutineStateLock", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "Ljava/text/SimpleDateFormat;", "dateFormat", "Ljava/text/SimpleDateFormat;", "dynamicAttach", "Lkotlin/jvm/functions/Function1;", "enableCreationStackTraces", "Z", "getEnableCreationStackTraces", "()Z", "setEnableCreationStackTraces", "(Z)V", "installations", "I", "isInstalled$kotlinx_coroutines_core", "isInstalled", "sanitizeStackTraces", "getSanitizeStackTraces", "setSanitizeStackTraces", "weakRefCleanerThread", "Ljava/lang/Thread;", "getDebugString", "getDebugString$annotations", "(Lkotlinx/coroutines/Job;)V", "debugString", "isInternalMethod", "(Ljava/lang/StackTraceElement;)Z", "CoroutineOwner", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DebugProbesImpl {
    private static final String ARTIFICIAL_FRAME_MESSAGE = "Coroutine creation stacktrace";
    public static final DebugProbesImpl INSTANCE = null;
    private static final ConcurrentWeakMap<CoroutineStackFrame, DebugCoroutineInfoImpl> callerInfoCache = null;
    private static final ConcurrentWeakMap<CoroutineOwner<?>, Boolean> capturedCoroutinesMap = null;
    private static final ReentrantReadWriteLock coroutineStateLock = null;
    private static final SimpleDateFormat dateFormat = null;
    private static final /* synthetic */ SequenceNumberRefVolatile debugProbesImpl$SequenceNumberRefVolatile = null;
    private static final Function1<Boolean, Unit> dynamicAttach = null;
    private static boolean enableCreationStackTraces;
    private static volatile int installations;
    private static boolean sanitizeStackTraces;
    private static final /* synthetic */ AtomicLongFieldUpdater sequenceNumber$FU = null;
    private static Thread weakRefCleanerThread;

    /* JADX INFO: compiled from: DebugProbesImpl.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003B%\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\n\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u001e\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015H\u0016ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\rX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0019"}, d2 = {"Lkotlinx/coroutines/debug/internal/DebugProbesImpl$CoroutineOwner;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/coroutines/Continuation;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "delegate", AlogMonitor.ALOG_RESULT_INFO, "Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;", "frame", "(Lkotlin/coroutines/Continuation;Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;)V", "callerFrame", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "getStackTraceElement", "Ljava/lang/StackTraceElement;", "resumeWith", "", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class CoroutineOwner<T> implements Continuation<T>, CoroutineStackFrame {
        public final Continuation<T> delegate;
        private final CoroutineStackFrame frame;
        public final DebugCoroutineInfoImpl info;

        @Override // kotlin.coroutines.Continuation
        public CoroutineContext getContext() {
            return this.delegate.getContext();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public CoroutineOwner(Continuation<? super T> r1, DebugCoroutineInfoImpl r2, CoroutineStackFrame r3) {
            this.delegate = r1;
            this.info = r2;
            this.frame = r3;
        }

        @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
        public CoroutineStackFrame getCallerFrame() {
            CoroutineStackFrame r0 = this.frame;
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.getCallerFrame();
        }

        @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
        public StackTraceElement getStackTraceElement() {
            CoroutineStackFrame r0 = this.frame;
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.getStackTraceElement();
        }

        @Override // kotlin.coroutines.Continuation
        public void resumeWith(Object r2) {
            DebugProbesImpl.access$probeCoroutineCompleted(DebugProbesImpl.INSTANCE, this);
            this.delegate.resumeWith(r2);
        }

        public String toString() {
            return this.delegate.toString();
        }
    }

    private static /* synthetic */ void getDebugString$annotations(Job r0) {
    }

    private DebugProbesImpl() {
    }

    public static final /* synthetic */ ConcurrentWeakMap access$getCallerInfoCache$p() {
        return callerInfoCache;
    }

    public static final /* synthetic */ boolean access$isFinished(DebugProbesImpl r0, CoroutineOwner r1) {
        return r0.isFinished(r1);
    }

    public static final /* synthetic */ void access$probeCoroutineCompleted(DebugProbesImpl r0, CoroutineOwner r1) {
        r0.probeCoroutineCompleted(r1);
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [kotlinx.coroutines.debug.internal.DebugProbesImpl$SequenceNumberRefVolatile] */
    static {
        DebugProbesImpl r0 = new DebugProbesImpl();
        INSTANCE = r0;
        dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        capturedCoroutinesMap = new ConcurrentWeakMap(false, 1, null);
        final long r2 = 0;
        debugProbesImpl$SequenceNumberRefVolatile = new SequenceNumberRefVolatile(r2);
        coroutineStateLock = new ReentrantReadWriteLock();
        sanitizeStackTraces = true;
        enableCreationStackTraces = true;
        dynamicAttach = r0.getDynamicAttach();
        callerInfoCache = new ConcurrentWeakMap(true);
        sequenceNumber$FU = AtomicLongFieldUpdater.newUpdater(SequenceNumberRefVolatile.class, "sequenceNumber");
    }

    private final Set<CoroutineOwner<?>> getCapturedCoroutines() {
        return capturedCoroutinesMap.keySet();
    }

    public final boolean isInstalled$kotlinx_coroutines_core() {
        if (installations <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean getSanitizeStackTraces() {
        return sanitizeStackTraces;
    }

    public final void setSanitizeStackTraces(boolean r1) {
        sanitizeStackTraces = r1;
    }

    public final boolean getEnableCreationStackTraces() {
        return enableCreationStackTraces;
    }

    public final void setEnableCreationStackTraces(boolean r1) {
        enableCreationStackTraces = r1;
    }

    private final Function1<Boolean, Unit> getDynamicAttach() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L7
        DebugProbesImpl r1 = this;     // Catch: Throwable -> L7
        Object r2 = Class.forName("kotlinx.coroutines.debug.internal.ByteBuddyDynamicAttach").getConstructors()[0].newInstance(new Object[0]);     // Catch: Throwable -> L7
        if (r2 == null) goto L6;
        Object r3 = Result.m774constructorimpl((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r2, 1));     // Catch: Throwable -> L7
    L10:
        if (Result.m780isFailureimpl(r3) == false) goto L13;
        r3 = null;
    L13:
        return (Function1) r3;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Function1<kotlin.Boolean, kotlin.Unit>");     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r3 = Result.m774constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    public final void install() {
        ReentrantReadWriteLock r6 = coroutineStateLock;
        ReentrantReadWriteLock.ReadLock r0 = r6.readLock();
        int r2 = 0;
        if (r6.getWriteHoldCount() != 0) goto L5;
        int r1 = r6.getReadHoldCount();
    L6:
        int r3 = 0;
    L7:
        if (r3 >= r1) goto L9;
        r0.unlock();
        r3 = r3 + 1;
        goto L7
    L9:
        ReentrantReadWriteLock.WriteLock r7 = r6.writeLock();
        r7.lock();
        DebugProbesImpl r4 = INSTANCE;     // Catch: Throwable -> L30
        installations++;     // Catch: Throwable -> L30
        if (installations <= 1) goto L16;
    L12:
        if (r2 >= r1) goto L14;
        r0.lock();
        r2 = r2 + 1;
        goto L12
    L14:
        r7.unlock();
        return;
    L16:
        r4.startWeakRefCleanerThread();     // Catch: Throwable -> L30
        if (AgentInstallationType.INSTANCE.isInstalledStatically$kotlinx_coroutines_core() == false) goto L22;
    L18:
        if (r2 >= r1) goto L20;
        r0.lock();
        r2 = r2 + 1;
        goto L18
    L20:
        r7.unlock();
        return;
    L22:
        Function1<Boolean, Unit> r5 = dynamicAttach;     // Catch: Throwable -> L30
        if (r5 == null) goto L25;
        r5.invoke(true);     // Catch: Throwable -> L30
    L25:
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L30
    L26:
        if (r2 >= r1) goto L28;
        r0.lock();
        r2 = r2 + 1;
        goto L26
    L28:
        r7.unlock();
        return;
    L30:
        th = move-exception;
    L31:
        if (r2 >= r1) goto L33;
        r0.lock();
        r2 = r2 + 1;
        goto L31
    L33:
        r7.unlock();
        throw th;
    L5:
        r1 = 0;
        goto L6
    }

    public final void uninstall() {
        ReentrantReadWriteLock r5 = coroutineStateLock;
        ReentrantReadWriteLock.ReadLock r0 = r5.readLock();
        int r2 = 0;
        if (r5.getWriteHoldCount() != 0) goto L5;
        int r1 = r5.getReadHoldCount();
    L6:
        int r3 = 0;
    L7:
        if (r3 >= r1) goto L9;
        r0.unlock();
        r3 = r3 + 1;
        goto L7
    L9:
        ReentrantReadWriteLock.WriteLock r6 = r5.writeLock();
        r6.lock();
        DebugProbesImpl r4 = INSTANCE;     // Catch: Throwable -> L34
        if (r4.isInstalled$kotlinx_coroutines_core() == false) goto L33;
        installations--;     // Catch: Throwable -> L34
        if (installations == 0) goto L18;
    L14:
        if (r2 >= r1) goto L16;
        r0.lock();
        r2 = r2 + 1;
        goto L14
    L16:
        r6.unlock();
        return;
    L18:
        r4.stopWeakRefCleanerThread();     // Catch: Throwable -> L34
        capturedCoroutinesMap.clear();     // Catch: Throwable -> L34
        callerInfoCache.clear();     // Catch: Throwable -> L34
        if (AgentInstallationType.INSTANCE.isInstalledStatically$kotlinx_coroutines_core() == false) goto L24;
    L20:
        if (r2 >= r1) goto L22;
        r0.lock();
        r2 = r2 + 1;
        goto L20
    L22:
        r6.unlock();
        return;
    L24:
        Function1<Boolean, Unit> r7 = dynamicAttach;     // Catch: Throwable -> L34
        if (r7 == null) goto L27;
        r7.invoke(false);     // Catch: Throwable -> L34
    L27:
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L34
    L28:
        if (r2 >= r1) goto L30;
        r0.lock();
        r2 = r2 + 1;
        goto L28
    L30:
        r6.unlock();
        return;
    L33:
        throw new IllegalStateException("Agent was not installed".toString());     // Catch: Throwable -> L34
    L34:
        th = move-exception;
    L35:
        if (r2 >= r1) goto L37;
        r0.lock();
        r2 = r2 + 1;
        goto L35
    L37:
        r6.unlock();
        throw th;
    L5:
        r1 = 0;
        goto L6
    }

    private final void startWeakRefCleanerThread() {
        weakRefCleanerThread = ThreadsKt.thread$default(false, true, null, "Coroutines Debugger Cleaner", 0, AnonymousClass1.INSTANCE, 21, null);
    }

    private final void stopWeakRefCleanerThread() {
        Thread r1 = weakRefCleanerThread;
        if (r1 != null) goto L5;
        return;
    L5:
        weakRefCleanerThread = null;
        r1.interrupt();
        r1.join();
    }

    public final String hierarchyToString(Job r9) {
        ReentrantReadWriteLock r8 = coroutineStateLock;
        ReentrantReadWriteLock.ReadLock r0 = r8.readLock();
        int r2 = 0;
        if (r8.getWriteHoldCount() != 0) goto L5;
        int r1 = r8.getReadHoldCount();
    L6:
        int r3 = 0;
    L7:
        if (r3 >= r1) goto L9;
        r0.unlock();
        r3 = r3 + 1;
        goto L7
    L9:
        ReentrantReadWriteLock.WriteLock r10 = r8.writeLock();
        r10.lock();
        DebugProbesImpl r4 = INSTANCE;     // Catch: Throwable -> L32
        if (r4.isInstalled$kotlinx_coroutines_core() == false) goto L31;
        Set<CoroutineOwner<?>> r5 = r4.getCapturedCoroutines();     // Catch: Throwable -> L32
        ArrayList r6 = new ArrayList();     // Catch: Throwable -> L32
        Iterator<T> r7 = r5.iterator();     // Catch: Throwable -> L32
    L14:
        if (r7.hasNext() == false) goto L21;
        Object r11 = r7.next();     // Catch: Throwable -> L32
        if (((CoroutineOwner) r11).delegate.getContext().get(Job.Key) == null) goto L18;
        boolean r12 = true;
    L19:
        if (r12 == false) goto L14;
        r6.add(r11);     // Catch: Throwable -> L32
        goto L14
    L18:
        r12 = false;
        goto L19
    L21:
        ArrayList r13 = r6;     // Catch: Throwable -> L32
        LinkedHashMap r14 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r13, 10)), 16));     // Catch: Throwable -> L32
        Iterator r15 = r13.iterator();     // Catch: Throwable -> L32
    L23:
        if (r15.hasNext() == false) goto L25;
        Object r16 = r15.next();     // Catch: Throwable -> L32
        r14.put(JobKt.getJob(((CoroutineOwner) r16).delegate.getContext()), ((CoroutineOwner) r16).info);     // Catch: Throwable -> L32
        goto L23
    L25:
        StringBuilder r17 = new StringBuilder();     // Catch: Throwable -> L32
        INSTANCE.build(r9, r14, r17, "");     // Catch: Throwable -> L32
        String r18 = r17.toString();     // Catch: Throwable -> L32
        Intrinsics.checkNotNullExpressionValue(r18, "StringBuilder().apply(builderAction).toString()");     // Catch: Throwable -> L32
    L26:
        if (r2 >= r1) goto L28;
        r0.lock();
        r2 = r2 + 1;
        goto L26
    L28:
        r10.unlock();
        return r18;
    L31:
        throw new IllegalStateException("Debug probes are not installed".toString());     // Catch: Throwable -> L32
    L32:
        th = move-exception;
    L33:
        if (r2 >= r1) goto L35;
        r0.lock();
        r2 = r2 + 1;
        goto L33
    L35:
        r10.unlock();
        throw th;
    L5:
        r1 = 0;
        goto L6
    }

    private final void build(Job r7, Map<Job, DebugCoroutineInfoImpl> r8, StringBuilder r9, String r10) {
        DebugCoroutineInfoImpl r0 = r8.get(r7);
        if (r0 == null) goto L5;
        StackTraceElement r3 = (StackTraceElement) CollectionsKt.firstOrNull(r0.lastObservedStackTrace());
        r9.append(r10 + getDebugString(r7) + ", continuation is " + r0.getState() + " at line " + r3 + '\n');
        r10 = r10 + '\t';
    L8:
        Iterator<Job> r11 = r7.getChildren().iterator();
    L10:
        if (r11.hasNext() == false) goto L12;
        build(r11.next(), r8, r9, r10);
        goto L10
    L12:
        return;
    L5:
        if ((r7 instanceof ScopeCoroutine) == true) goto L8;
        r9.append(r10 + getDebugString(r7) + '\n');
        r10 = r10 + '\t';
        goto L8
    }

    private final String getDebugString(Job r1) {
        if ((r1 instanceof JobSupport) == false) goto L6;
        return ((JobSupport) r1).toDebugString();
    L6:
        return r1.toString();
    }

    private final <R> List<R> dumpCoroutinesInfoImpl(final Function2<? super CoroutineOwner<?>, ? super CoroutineContext, ? extends R> r7) {
        ReentrantReadWriteLock r6 = coroutineStateLock;
        ReentrantReadWriteLock.ReadLock r0 = r6.readLock();
        int r2 = 0;
        if (r6.getWriteHoldCount() != 0) goto L5;
        int r1 = r6.getReadHoldCount();
    L6:
        int r3 = 0;
    L7:
        if (r3 >= r1) goto L9;
        r0.unlock();
        r3 = r3 + 1;
        goto L7
    L9:
        ReentrantReadWriteLock.WriteLock r8 = r6.writeLock();
        r8.lock();
        DebugProbesImpl r4 = INSTANCE;     // Catch: Throwable -> L20
        if (r4.isInstalled$kotlinx_coroutines_core() == false) goto L19;
        List<R> r9 = SequencesKt.toList(SequencesKt.mapNotNull(SequencesKt.sortedWith(CollectionsKt.asSequence(r4.getCapturedCoroutines()), new DebugProbesImpl$dumpCoroutinesInfoImpl$lambda12$$inlined$sortedBy$1()), new DebugProbesImpl$dumpCoroutinesInfoImpl$1$3(r7)));     // Catch: Throwable -> L20
        InlineMarker.finallyStart(1);
    L14:
        if (r2 >= r1) goto L16;
        r0.lock();
        r2 = r2 + 1;
        goto L14
    L16:
        r8.unlock();
        InlineMarker.finallyEnd(1);
        return r9;
    L19:
        throw new IllegalStateException("Debug probes are not installed".toString());     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        InlineMarker.finallyStart(1);
    L22:
        if (r2 >= r1) goto L24;
        r0.lock();
        r2 = r2 + 1;
        goto L22
    L24:
        r8.unlock();
        InlineMarker.finallyEnd(1);
        throw th;
    L5:
        r1 = 0;
        goto L6
    }

    public final Object[] dumpCoroutinesInfoAsJsonAndReferences() {
        List<DebugCoroutineInfo> r0 = dumpCoroutinesInfo();
        int r1 = r0.size();
        ArrayList r2 = new ArrayList(r1);
        ArrayList r3 = new ArrayList(r1);
        ArrayList r4 = new ArrayList(r1);
        Iterator<DebugCoroutineInfo> r5 = r0.iterator();
    L4:
        if (r5.hasNext() == false) goto L19;
        DebugCoroutineInfo r6 = r5.next();
        CoroutineContext r7 = r6.getContext();
        CoroutineName r8 = (CoroutineName) r7.get(CoroutineName.Key);
        Long r9 = null;
        if (r8 == null) goto L10;
        String r10 = r8.getName();
        if (r10 == null) goto L10;
        String r11 = toStringWithQuotes(r10);
    L11:
        CoroutineDispatcher r12 = (CoroutineDispatcher) r7.get(CoroutineDispatcher.Key);
        if (r12 == null) goto L14;
        String r13 = toStringWithQuotes(r12);
    L15:
        StringBuilder r14 = new StringBuilder("\n                {\n                    \"name\": ").append(r11).append(",\n                    \"id\": ");
        CoroutineId r15 = (CoroutineId) r7.get(CoroutineId.Key);
        if (r15 == null) goto L18;
        r9 = Long.valueOf(r15.getId());
    L18:
        r4.add(StringsKt.trimIndent(r14.append(r9).append(",\n                    \"dispatcher\": ").append(r13).append(",\n                    \"sequenceNumber\": ").append(r6.getSequenceNumber()).append(",\n                    \"state\": \"").append(r6.getState()).append("\"\n                } \n                ").toString()));
        r3.add(r6.getLastObservedFrame());
        r2.add(r6.getLastObservedThread());
        goto L4
    L14:
        r13 = null;
    L10:
        r11 = null;
        goto L11
    L19:
        Object[] r16 = new Object[4];
        r16[0] = "[" + CollectionsKt.joinToString$default(r4, null, null, null, 0, null, null, 63, null) + ']';
        Object[] r17 = r2.toArray(new Thread[0]);
        if (r17 == null) goto L32;
        r16[1] = r17;
        Object[] r18 = r3.toArray(new CoroutineStackFrame[0]);
        if (r18 == null) goto L30;
        r16[2] = r18;
        Object[] r19 = r0.toArray(new DebugCoroutineInfo[0]);
        if (r19 == null) goto L28;
        r16[3] = r19;
        return r16;
    L28:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    L30:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    L32:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    public final String enhanceStackTraceWithThreadDumpAsJson(DebugCoroutineInfo r11) {
        List<StackTraceElement> r12 = enhanceStackTraceWithThreadDump(r11, r11.lastObservedStackTrace());
        ArrayList r0 = new ArrayList();
        Iterator<StackTraceElement> r13 = r12.iterator();
    L4:
        if (r13.hasNext() == false) goto L11;
        StackTraceElement r1 = r13.next();
        StringBuilder r2 = new StringBuilder("\n                {\n                    \"declaringClass\": \"").append(r1.getClassName()).append("\",\n                    \"methodName\": \"").append(r1.getMethodName()).append("\",\n                    \"fileName\": ");
        String r3 = r1.getFileName();
        if (r3 == null) goto L8;
        String r4 = toStringWithQuotes(r3);
    L9:
        r0.add(StringsKt.trimIndent(r2.append(r4).append(",\n                    \"lineNumber\": ").append(r1.getLineNumber()).append("\n                }\n                ").toString()));
        goto L4
    L8:
        r4 = null;
        goto L9
    L11:
        return "[" + CollectionsKt.joinToString$default(r0, null, null, null, 0, null, null, 63, null) + ']';
    }

    private final String toStringWithQuotes(Object r2) {
        return "\"" + r2 + Typography.quote;
    }

    public final void dumpCoroutines(PrintStream r1) {
        monitor-enter(r1);
        INSTANCE.dumpCoroutinesSynchronized(r1);     // Catch: Throwable -> L6
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L6
        monitor-exit(r1);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private final boolean isFinished(CoroutineOwner<?> r3) {
        CoroutineContext r2 = r3.info.getContext();
        if (r2 == null) goto L12;
        Job r4 = (Job) r2.get(Job.Key);
        if (r4 == null) goto L12;
        if (r4.isCompleted() == true) goto L10;
        return false;
    L10:
        capturedCoroutinesMap.remove(r3);
        return true;
    L12:
        return false;
    }

    private final void dumpCoroutinesSynchronized(PrintStream r13) {
        ReentrantReadWriteLock r12 = coroutineStateLock;
        ReentrantReadWriteLock.ReadLock r0 = r12.readLock();
        int r2 = 0;
        if (r12.getWriteHoldCount() != 0) goto L5;
        int r1 = r12.getReadHoldCount();
    L6:
        int r3 = 0;
    L7:
        if (r3 >= r1) goto L9;
        r0.unlock();
        r3 = r3 + 1;
        goto L7
    L9:
        ReentrantReadWriteLock.WriteLock r14 = r12.writeLock();
        r14.lock();
        DebugProbesImpl r4 = INSTANCE;     // Catch: Throwable -> L31
        if (r4.isInstalled$kotlinx_coroutines_core() == false) goto L30;
        r13.print("Coroutines dump " + dateFormat.format(Long.valueOf(System.currentTimeMillis())));     // Catch: Throwable -> L31
        Iterator r5 = SequencesKt.sortedWith(SequencesKt.filter(CollectionsKt.asSequence(r4.getCapturedCoroutines()), DebugProbesImpl$dumpCoroutinesSynchronized$1$2.INSTANCE), new DebugProbesImpl$dumpCoroutinesSynchronized$lambda19$$inlined$sortedBy$1()).iterator();     // Catch: Throwable -> L31
    L14:
        if (r5.hasNext() == false) goto L24;
        CoroutineOwner r6 = (CoroutineOwner) r5.next();     // Catch: Throwable -> L31
        DebugCoroutineInfoImpl r7 = r6.info;     // Catch: Throwable -> L31
        List<StackTraceElement> r8 = r7.lastObservedStackTrace();     // Catch: Throwable -> L31
        DebugProbesImpl r9 = INSTANCE;     // Catch: Throwable -> L31
        List<StackTraceElement> r10 = r9.enhanceStackTraceWithThreadDumpImpl(r7.getState(), r7.lastObservedThread, r8);     // Catch: Throwable -> L31
        if (Intrinsics.areEqual(r7.getState(), DebugCoroutineInfoImplKt.RUNNING) == false) goto L19;
        if (r10 != r8) goto L19;
        String r11 = r7.getState() + " (Last suspension stacktrace, not an actual stacktrace)";     // Catch: Throwable -> L31
    L20:
        r13.print("\n\nCoroutine " + r6.delegate + ", state: " + r11);     // Catch: Throwable -> L31
        if (r8.isEmpty() == true) goto L22;
        r9.printStackTrace(r13, r10);     // Catch: Throwable -> L31
        goto L14
    L22:
        r13.print("\n\tat " + StackTraceRecoveryKt.artificialFrame(ARTIFICIAL_FRAME_MESSAGE));     // Catch: Throwable -> L31
        r9.printStackTrace(r13, r7.getCreationStackTrace());     // Catch: Throwable -> L31
    L19:
        r11 = r7.getState();     // Catch: Throwable -> L31
        goto L20
    L24:
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L31
    L25:
        if (r2 >= r1) goto L27;
        r0.lock();
        r2 = r2 + 1;
        goto L25
    L27:
        r14.unlock();
        return;
    L30:
        throw new IllegalStateException("Debug probes are not installed".toString());     // Catch: Throwable -> L31
    L31:
        th = move-exception;
    L32:
        if (r2 >= r1) goto L34;
        r0.lock();
        r2 = r2 + 1;
        goto L32
    L34:
        r14.unlock();
        throw th;
    L5:
        r1 = 0;
        goto L6
    }

    private final void printStackTrace(PrintStream r3, List<StackTraceElement> r4) {
        Iterator<T> r2 = r4.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r3.print("\n\tat " + ((StackTraceElement) r2.next()));
        goto L4
    }

    public final List<StackTraceElement> enhanceStackTraceWithThreadDump(DebugCoroutineInfo r2, List<StackTraceElement> r3) {
        return enhanceStackTraceWithThreadDumpImpl(r2.getState(), r2.getLastObservedThread(), r3);
    }

    private final List<StackTraceElement> enhanceStackTraceWithThreadDumpImpl(String r8, Thread r9, List<StackTraceElement> r10) {
        if (Intrinsics.areEqual(r8, DebugCoroutineInfoImplKt.RUNNING) == false) goto L42;
        if (r9 == null) goto L42;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L8
        DebugProbesImpl r12 = this;     // Catch: Throwable -> L8
        Object r13 = Result.m774constructorimpl(r9.getStackTrace());     // Catch: Throwable -> L8
    L11:
        if (Result.m780isFailureimpl(r13) == false) goto L13;
        r13 = null;
    L13:
        StackTraceElement[] r14 = (StackTraceElement[]) r13;
        if (r14 != null) goto L16;
        return r10;
    L16:
        int r15 = r14.length;
        int r0 = 0;
        int r1 = 0;
    L18:
        if (r1 >= r15) goto L30;
        StackTraceElement r4 = r14[r1];
        if (Intrinsics.areEqual(r4.getClassName(), "kotlin.coroutines.jvm.internal.BaseContinuationImpl") == true) goto L22;
    L26:
        boolean r5 = false;
    L27:
        if (r5 == true) goto L31;
        r1 = r1 + 1;
    L31:
        Pair<Integer, Integer> r7 = findContinuationStartIndex(r1, r14, r10);
        int r16 = r7.component1().intValue();
        int r17 = r7.component2().intValue();
        if (r16 != (-1)) goto L34;
        return r10;
    L34:
        ArrayList r6 = new ArrayList((((r10.size() + r1) - r16) - 1) - r17);
        int r2 = r1 - r17;
    L35:
        if (r0 >= r2) goto L37;
        r6.add(r14[r0]);
        r0 = r0 + 1;
        goto L35
    L37:
        int r18 = r16 + 1;
        int r19 = r10.size();
    L38:
        if (r18 >= r19) goto L41;
        r6.add(r10.get(r18));
        r18 = r18 + 1;
        goto L38
    L41:
        return r6;
    L22:
        if (Intrinsics.areEqual(r4.getMethodName(), "resumeWith") == false) goto L26;
        if (Intrinsics.areEqual(r4.getFileName(), "ContinuationImpl.kt") == false) goto L26;
        r5 = true;
        goto L27
    L30:
        r1 = -1;
    L8:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r13 = Result.m774constructorimpl(ResultKt.createFailure(th));
    L42:
        return r10;
    }

    private final Pair<Integer, Integer> findContinuationStartIndex(int r5, StackTraceElement[] r6, List<StackTraceElement> r7) {
        int r0 = 0;
    L4:
        if (r0 >= 3) goto L11;
        int r2 = INSTANCE.findIndexOfFrame((r5 - 1) - r0, r6, r7);
        if (r2 != (-1)) goto L8;
        r0 = r0 + 1;
        goto L4
    L8:
        return TuplesKt.to(Integer.valueOf(r2), Integer.valueOf(r0));
    L11:
        return TuplesKt.to(-1, 0);
    }

    private final int findIndexOfFrame(int r5, StackTraceElement[] r6, List<StackTraceElement> r7) {
        StackTraceElement r4 = (StackTraceElement) ArraysKt.getOrNull(r6, r5);
        if (r4 != null) goto L5;
        return -1;
    L5:
        Iterator<StackTraceElement> r8 = r7.iterator();
        int r0 = 0;
    L7:
        if (r8.hasNext() == false) goto L22;
        StackTraceElement r1 = r8.next();
        if (Intrinsics.areEqual(r1.getFileName(), r4.getFileName()) == true) goto L11;
    L15:
        boolean r2 = false;
    L16:
        if (r2 == true) goto L19;
        r0 = r0 + 1;
        goto L7
    L19:
        return r0;
    L11:
        if (Intrinsics.areEqual(r1.getClassName(), r4.getClassName()) == false) goto L15;
        if (Intrinsics.areEqual(r1.getMethodName(), r4.getMethodName()) == false) goto L15;
        r2 = true;
        goto L16
    L22:
        return -1;
    }

    public final void probeCoroutineResumed$kotlinx_coroutines_core(Continuation<?> r2) {
        updateState(r2, DebugCoroutineInfoImplKt.RUNNING);
    }

    public final void probeCoroutineSuspended$kotlinx_coroutines_core(Continuation<?> r2) {
        updateState(r2, DebugCoroutineInfoImplKt.SUSPENDED);
    }

    private final void updateState(Continuation<?> r5, String r6) {
        if (isInstalled$kotlinx_coroutines_core() == true) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(r6, DebugCoroutineInfoImplKt.RUNNING) == true) goto L8;
    L17:
        CoroutineOwner<?> r0 = owner(r5);
        if (r0 != null) goto L20;
        return;
    L20:
        updateState(r0, r5, r6);
        return;
    L8:
        if (KotlinVersion.CURRENT.isAtLeast(1, 3, 30) == false) goto L17;
        if ((r5 instanceof CoroutineStackFrame) == false) goto L12;
        CoroutineStackFrame r7 = (CoroutineStackFrame) r5;
    L13:
        if (r7 != null) goto L15;
        return;
    L15:
        updateRunningState(r7, r6);
        return;
    L12:
        r7 = null;
        goto L13
    }

    private final void updateRunningState(CoroutineStackFrame r5, String r6) {
        ReentrantReadWriteLock.ReadLock r4 = coroutineStateLock.readLock();
        r4.lock();
        DebugProbesImpl r0 = INSTANCE;     // Catch: Throwable -> L30
        if (r0.isInstalled$kotlinx_coroutines_core() == true) goto L7;
        r4.unlock();
        return;
    L7:
        ConcurrentWeakMap<CoroutineStackFrame, DebugCoroutineInfoImpl> r1 = callerInfoCache;     // Catch: Throwable -> L30
        DebugCoroutineInfoImpl r2 = r1.remove(r5);     // Catch: Throwable -> L30
        if (r2 != null) goto L21;
        CoroutineOwner<?> r3 = r0.owner(r5);     // Catch: Throwable -> L30
        if (r3 == null) goto L28;
        r2 = r3.info;     // Catch: Throwable -> L30
        if (r2 == null) goto L28;
        CoroutineStackFrame r7 = r2.getLastObservedFrame$kotlinx_coroutines_core();     // Catch: Throwable -> L30
        if (r7 == null) goto L18;
        CoroutineStackFrame r8 = r0.realCaller(r7);     // Catch: Throwable -> L30
    L19:
        if (r8 == null) goto L21;
        r1.remove(r8);     // Catch: Throwable -> L30
        goto L21
    L18:
        r8 = null;
    L28:
        r4.unlock();
        return;
    L21:
        r2.updateState$kotlinx_coroutines_core(r6, (Continuation) r5);     // Catch: Throwable -> L30
        CoroutineStackFrame r9 = r0.realCaller(r5);     // Catch: Throwable -> L30
        if (r9 != null) goto L25;
        r4.unlock();
        return;
    L25:
        r1.put(r9, r2);     // Catch: Throwable -> L30
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L30
        r4.unlock();
        return;
    L30:
        th = move-exception;
        r4.unlock();
        throw th;
    }

    private final CoroutineStackFrame realCaller(CoroutineStackFrame r1) {
    L2:
        r1 = r1.getCallerFrame();
        if (r1 == null) goto L4;
        if (r1.getStackTraceElement() == null) goto L2;
        return r1;
    L4:
        return null;
    }

    private final void updateState(CoroutineOwner<?> r2, Continuation<?> r3, String r4) {
        ReentrantReadWriteLock.ReadLock r1 = coroutineStateLock.readLock();
        r1.lock();
    L10:
        th = move-exception;
        r1.unlock();
        throw th;
    L4:
        if (INSTANCE.isInstalled$kotlinx_coroutines_core() == true) goto L7;
        r1.unlock();
        return;
    L7:
        r2.info.updateState$kotlinx_coroutines_core(r4, r3);     // Catch: Throwable -> L10
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L10
        r1.unlock();
    }

    private final CoroutineOwner<?> owner(Continuation<?> r3) {
        if ((r3 instanceof CoroutineStackFrame) == false) goto L5;
        CoroutineStackFrame r4 = (CoroutineStackFrame) r3;
    L6:
        if (r4 != null) goto L8;
        return null;
    L8:
        return owner(r4);
    L5:
        r4 = null;
        goto L6
    }

    private final CoroutineOwner<?> owner(CoroutineStackFrame r1) {
    L3:
        if ((r1 instanceof CoroutineOwner) == true) goto L13;
        r1 = r1.getCallerFrame();
        if (r1 != null) goto L3;
        return null;
    L13:
        return (CoroutineOwner) r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> Continuation<T> probeCoroutineCreated$kotlinx_coroutines_core(Continuation<? super T> r3) {
        if (isInstalled$kotlinx_coroutines_core() == true) goto L6;
        return r3;
    L6:
        if (owner(r3) == null) goto L9;
        return r3;
    L9:
        if (enableCreationStackTraces == false) goto L11;
        StackTraceFrame r0 = toStackTraceFrame(sanitizeStackTrace(new Exception()));
    L13:
        return createOwner(r3, r0);
    L11:
        r0 = null;
        StackTraceFrame r1 = (StackTraceFrame) null;
        goto L13
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final <T> Continuation<T> createOwner(Continuation<? super T> r5, StackTraceFrame r6) {
        if (isInstalled$kotlinx_coroutines_core() == true) goto L5;
        return r5;
    L5:
        CoroutineOwner<?> r1 = new CoroutineOwner(r5, new DebugCoroutineInfoImpl(r5.getContext(), r6, sequenceNumber$FU.incrementAndGet(debugProbesImpl$SequenceNumberRefVolatile)), r6);
        ConcurrentWeakMap<CoroutineOwner<?>, Boolean> r7 = capturedCoroutinesMap;
        r7.put(r1, true);
        if (isInstalled$kotlinx_coroutines_core() == true) goto L9;
        r7.clear();
    L9:
        return r1;
    }

    private final void probeCoroutineCompleted(CoroutineOwner<?> r2) {
        capturedCoroutinesMap.remove(r2);
        CoroutineStackFrame r3 = r2.info.getLastObservedFrame$kotlinx_coroutines_core();
        if (r3 == null) goto L9;
        CoroutineStackFrame r1 = realCaller(r3);
        if (r1 == null) goto L10;
        callerInfoCache.remove(r1);
        return;
    L10:
        return;
    }

    private final <T extends Throwable> List<StackTraceElement> sanitizeStackTrace(T r9) {
        StackTraceElement[] r10 = r9.getStackTrace();
        int r0 = r10.length;
        int r2 = -1;
        int r1 = r10.length - 1;
        if (r1 < 0) goto L11;
    L4:
        int r3 = r1 - 1;
        if (Intrinsics.areEqual(r10[r1].getClassName(), "kotlin.coroutines.jvm.internal.DebugProbesKt") == true) goto L6;
        if (r3 < 0) goto L11;
        r1 = r3;
        goto L4
    L6:
        r2 = r1;
    L11:
        if (sanitizeStackTraces == true) goto L20;
        int r4 = r0 - r2;
        ArrayList r8 = new ArrayList(r4);
        int r5 = 0;
    L13:
        if (r5 >= r4) goto L19;
        if (r5 != 0) goto L16;
        StackTraceElement r6 = StackTraceRecoveryKt.artificialFrame(ARTIFICIAL_FRAME_MESSAGE);
    L17:
        r8.add(r6);
        r5 = r5 + 1;
        goto L13
    L16:
        r6 = r10[r5 + r2];
        goto L17
    L19:
        return r8;
    L20:
        ArrayList r7 = new ArrayList((r0 - r2) + 1);
        ArrayList r11 = r7;
        r11.add(StackTraceRecoveryKt.artificialFrame(ARTIFICIAL_FRAME_MESSAGE));
    L21:
        r2 = r2 + 1;
    L22:
        if (r2 >= r0) goto L41;
        if (isInternalMethod(r10[r2]) == false) goto L39;
        r11.add(r10[r2]);
        int r12 = r2 + 1;
    L26:
        if (r12 >= r0) goto L30;
        if (isInternalMethod(r10[r12]) == false) goto L30;
        r12 = r12 + 1;
    L30:
        int r13 = r12 - 1;
        int r14 = r13;
    L31:
        if (r14 <= r2) goto L35;
        if (r10[r14].getFileName() != null) goto L35;
        r14 = r14 - 1;
    L35:
        if (r14 <= r2) goto L38;
        if (r14 >= r13) goto L38;
        r11.add(r10[r14]);
    L38:
        r11.add(r10[r13]);
        r2 = r12;
        goto L22
    L39:
        r11.add(r10[r2]);
        goto L21
    L41:
        return r7;
    }

    private final boolean isInternalMethod(StackTraceElement r4) {
        return StringsKt.startsWith$default(r4.getClassName(), "kotlinx.coroutines", false, 2, null);
    }

    public final List<DebugCoroutineInfo> dumpCoroutinesInfo() {
        ReentrantReadWriteLock r5 = coroutineStateLock;
        ReentrantReadWriteLock.ReadLock r0 = r5.readLock();
        int r2 = 0;
        if (r5.getWriteHoldCount() != 0) goto L5;
        int r1 = r5.getReadHoldCount();
    L6:
        int r3 = 0;
    L7:
        if (r3 >= r1) goto L9;
        r0.unlock();
        r3 = r3 + 1;
        goto L7
    L9:
        ReentrantReadWriteLock.WriteLock r6 = r5.writeLock();
        r6.lock();
        DebugProbesImpl r4 = INSTANCE;     // Catch: Throwable -> L19
        if (r4.isInstalled$kotlinx_coroutines_core() == false) goto L18;
        List<DebugCoroutineInfo> r7 = SequencesKt.toList(SequencesKt.mapNotNull(SequencesKt.sortedWith(CollectionsKt.asSequence(r4.getCapturedCoroutines()), new DebugProbesImpl$dumpCoroutinesInfoImpl$lambda12$$inlined$sortedBy$1()), new DebugProbesImpl$dumpCoroutinesInfo$$inlined$dumpCoroutinesInfoImpl$1()));     // Catch: Throwable -> L19
    L13:
        if (r2 >= r1) goto L15;
        r0.lock();
        r2 = r2 + 1;
        goto L13
    L15:
        r6.unlock();
        return r7;
    L18:
        throw new IllegalStateException("Debug probes are not installed".toString());     // Catch: Throwable -> L19
    L19:
        th = move-exception;
    L20:
        if (r2 >= r1) goto L22;
        r0.lock();
        r2 = r2 + 1;
        goto L20
    L22:
        r6.unlock();
        throw th;
    L5:
        r1 = 0;
        goto L6
    }

    public final List<DebuggerInfo> dumpDebuggerInfo() {
        ReentrantReadWriteLock r5 = coroutineStateLock;
        ReentrantReadWriteLock.ReadLock r0 = r5.readLock();
        int r2 = 0;
        if (r5.getWriteHoldCount() != 0) goto L5;
        int r1 = r5.getReadHoldCount();
    L6:
        int r3 = 0;
    L7:
        if (r3 >= r1) goto L9;
        r0.unlock();
        r3 = r3 + 1;
        goto L7
    L9:
        ReentrantReadWriteLock.WriteLock r6 = r5.writeLock();
        r6.lock();
        DebugProbesImpl r4 = INSTANCE;     // Catch: Throwable -> L19
        if (r4.isInstalled$kotlinx_coroutines_core() == false) goto L18;
        List<DebuggerInfo> r7 = SequencesKt.toList(SequencesKt.mapNotNull(SequencesKt.sortedWith(CollectionsKt.asSequence(r4.getCapturedCoroutines()), new DebugProbesImpl$dumpCoroutinesInfoImpl$lambda12$$inlined$sortedBy$1()), new DebugProbesImpl$dumpDebuggerInfo$$inlined$dumpCoroutinesInfoImpl$1()));     // Catch: Throwable -> L19
    L13:
        if (r2 >= r1) goto L15;
        r0.lock();
        r2 = r2 + 1;
        goto L13
    L15:
        r6.unlock();
        return r7;
    L18:
        throw new IllegalStateException("Debug probes are not installed".toString());     // Catch: Throwable -> L19
    L19:
        th = move-exception;
    L20:
        if (r2 >= r1) goto L22;
        r0.lock();
        r2 = r2 + 1;
        goto L20
    L22:
        r6.unlock();
        throw th;
    L5:
        r1 = 0;
        goto L6
    }

    private final StackTraceFrame toStackTraceFrame(List<StackTraceElement> r3) {
        StackTraceFrame r0 = null;
        if (r3.isEmpty() == true) goto L8;
        ListIterator<StackTraceElement> r2 = r3.listIterator(r3.size());
    L6:
        if (r2.hasPrevious() == false) goto L8;
        StackTraceFrame r1 = r0;
        r0 = new StackTraceFrame(r1, r2.previous());
    L8:
        return r0;
    }
}
