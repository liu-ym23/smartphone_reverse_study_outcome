package kotlinx.coroutines.channels;

import android.icu.text.DateFormat;
import android.security.bytedance.guard.BDSecurityGuardStub;
import com.android.settings.ApnEditor;
import com.android.settingslib.SliceBroadcastRelay;
import com.bytedance.apm.constant.CommonKey;
import com.bytedance.apm.constant.PerfConsts;
import com.google.common.primitives.Longs;
import com.obric.aikernel.sdk.autotest.AutoTestConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import kotlin.time.DurationKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.internal.ConcurrentLinkedListKt;
import kotlinx.coroutines.internal.ConcurrentLinkedListNode;
import kotlinx.coroutines.internal.InlineList;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.SegmentOrClosed;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.selects.SelectClause1;
import kotlinx.coroutines.selects.SelectClause1Impl;
import kotlinx.coroutines.selects.SelectClause2;
import kotlinx.coroutines.selects.SelectClause2Impl;
import kotlinx.coroutines.selects.SelectImplementation;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.TrySelectDetailedResult;
import obric.tablet.widget.BytedanceJustifyTextView;

/* JADX INFO: compiled from: BufferedChannel.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\"\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0004Þ\u0001ß\u0001B1\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\"\b\u0002\u0010\u0005\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\b¢\u0006\u0002\u0010\tJ\u0010\u0010P\u001a\u00020\u001c2\u0006\u0010Q\u001a\u00020\u0010H\u0002J\u0006\u0010R\u001a\u00020\u0007J\u0010\u0010R\u001a\u00020\u001c2\b\u0010S\u001a\u0004\u0018\u00010\u0016J\u0016\u0010R\u001a\u00020\u00072\u000e\u0010S\u001a\n\u0018\u00010Tj\u0004\u0018\u0001`UJ\u0017\u0010V\u001a\u00020\u001c2\b\u0010S\u001a\u0004\u0018\u00010\u0016H\u0010¢\u0006\u0002\bWJ\u001e\u0010X\u001a\u00020\u00072\f\u0010Y\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010K\u001a\u00020\u0010H\u0002J\u0006\u0010Z\u001a\u00020\u0007J\u0012\u0010[\u001a\u00020\u001c2\b\u0010S\u001a\u0004\u0018\u00010\u0016H\u0016J\u000e\u0010\\\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0002J\u001a\u0010]\u001a\u00020\u001c2\b\u0010S\u001a\u0004\u0018\u00010\u00162\u0006\u0010R\u001a\u00020\u001cH\u0014J\u0010\u0010^\u001a\u00020\u00072\u0006\u0010_\u001a\u00020\u0010H\u0002J\u0016\u0010`\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010_\u001a\u00020\u0010H\u0002J\b\u0010a\u001a\u00020\u0007H\u0002J\u0010\u0010b\u001a\u00020\u00072\u0006\u0010c\u001a\u00020\u0010H\u0004J\b\u0010d\u001a\u00020\u0007H\u0002J.\u0010e\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00142\u0006\u0010f\u001a\u00020\u00102\f\u0010g\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010h\u001a\u00020\u0010H\u0002J&\u0010i\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00142\u0006\u0010f\u001a\u00020\u00102\f\u0010g\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0002J&\u0010j\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00142\u0006\u0010f\u001a\u00020\u00102\f\u0010g\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0002J\r\u0010k\u001a\u00020\u001cH\u0000¢\u0006\u0002\blJ\u0012\u0010m\u001a\u00020\u00072\b\b\u0002\u0010n\u001a\u00020\u0010H\u0002J\b\u0010o\u001a\u00020\u0007H\u0002J-\u0010p\u001a\u00020\u00072#\u0010q\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0016¢\u0006\f\b:\u0012\b\b;\u0012\u0004\b\b(S\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J&\u0010r\u001a\u00020\u001c2\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0006\u0010u\u001a\u00020\u0010H\u0002J\u0018\u0010v\u001a\u00020\u001c2\u0006\u0010w\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u000f\u0010x\u001a\b\u0012\u0004\u0012\u00028\u00000yH\u0096\u0002J\u0016\u0010z\u001a\u00020\u00102\f\u0010Y\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0002J\b\u0010{\u001a\u00020\u0007H\u0002J\b\u0010|\u001a\u00020\u0007H\u0002J\b\u0010}\u001a\u00020\u0007H\u0002J\u001e\u0010~\u001a\u00020\u00072\u0006\u0010f\u001a\u00020\u00102\f\u0010g\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0002J\b\u0010\u007f\u001a\u00020\u0007H\u0014J\"\u0010\u0080\u0001\u001a\u00020\u00072\u0014\u0010\u0081\u0001\u001a\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000,0\u0082\u0001H\u0002ø\u0001\u0000J\u0019\u0010\u0083\u0001\u001a\u00020\u00072\u000e\u0010\u0081\u0001\u001a\t\u0012\u0004\u0012\u00028\u00000\u0082\u0001H\u0002J\u0015\u0010\u0084\u0001\u001a\u00020\u00072\n\u0010<\u001a\u0006\u0012\u0002\b\u000309H\u0002J$\u0010\u0085\u0001\u001a\u00020\u00072\u0007\u0010\u0086\u0001\u001a\u00028\u00002\n\u0010<\u001a\u0006\u0012\u0002\b\u000309H\u0002¢\u0006\u0003\u0010\u0087\u0001J\u001c\u0010\u0088\u0001\u001a\u00020\u00072\u0007\u0010\u0086\u0001\u001a\u00028\u0000H\u0082@ø\u0001\u0000¢\u0006\u0003\u0010\u0089\u0001J(\u0010\u008a\u0001\u001a\u00020\u00072\u0007\u0010\u0086\u0001\u001a\u00028\u00002\u000e\u0010\u0081\u0001\u001a\t\u0012\u0004\u0012\u00020\u00070\u0082\u0001H\u0002¢\u0006\u0003\u0010\u008b\u0001J\t\u0010\u008c\u0001\u001a\u00020\u0007H\u0014J\t\u0010\u008d\u0001\u001a\u00020\u0007H\u0014J!\u0010\u008e\u0001\u001a\u0004\u0018\u00010\f2\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010\f2\t\u0010\u0090\u0001\u001a\u0004\u0018\u00010\fH\u0002J!\u0010\u0091\u0001\u001a\u0004\u0018\u00010\f2\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010\f2\t\u0010\u0090\u0001\u001a\u0004\u0018\u00010\fH\u0002J!\u0010\u0092\u0001\u001a\u0004\u0018\u00010\f2\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010\f2\t\u0010\u0090\u0001\u001a\u0004\u0018\u00010\fH\u0002J!\u0010\u0093\u0001\u001a\u0004\u0018\u00010\f2\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010\f2\t\u0010\u0090\u0001\u001a\u0004\u0018\u00010\fH\u0002J\u0013\u0010\u0094\u0001\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0003\u0010\u0095\u0001J%\u0010\u0096\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000,H\u0096@ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000ø\u0001\u0000¢\u0006\u0006\b\u0097\u0001\u0010\u0095\u0001JD\u0010\u0098\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000,2\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0007\u0010\u0099\u0001\u001a\u00020\u0010H\u0082@ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000ø\u0001\u0000¢\u0006\u0006\b\u009a\u0001\u0010\u009b\u0001J\u008c\u0002\u0010\u009c\u0001\u001a\u0003H\u009d\u0001\"\u0005\b\u0001\u0010\u009d\u00012\t\u0010\u009e\u0001\u001a\u0004\u0018\u00010\f2$\u0010\u009f\u0001\u001a\u001f\u0012\u0014\u0012\u00128\u0000¢\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(\u0086\u0001\u0012\u0005\u0012\u0003H\u009d\u00010\u00062V\u0010 \u0001\u001aQ\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00028\u00000\u0014¢\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(¡\u0001\u0012\u0014\u0012\u00120\u0004¢\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(¢\u0001\u0012\u0014\u0012\u00120\u0010¢\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(\u0099\u0001\u0012\u0005\u0012\u0003H\u009d\u0001082\u000f\u0010£\u0001\u001a\n\u0012\u0005\u0012\u0003H\u009d\u00010¤\u00012X\b\u0002\u0010¥\u0001\u001aQ\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00028\u00000\u0014¢\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(¡\u0001\u0012\u0014\u0012\u00120\u0004¢\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(¢\u0001\u0012\u0014\u0012\u00120\u0010¢\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(\u0099\u0001\u0012\u0005\u0012\u0003H\u009d\u000108H\u0082\b¢\u0006\u0003\u0010¦\u0001Jh\u0010§\u0001\u001a\u00020\u00072\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0007\u0010\u0099\u0001\u001a\u00020\u00102\b\u0010\u009e\u0001\u001a\u00030¨\u00012#\u0010\u009f\u0001\u001a\u001e\u0012\u0014\u0012\u00128\u0000¢\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(\u0086\u0001\u0012\u0004\u0012\u00020\u00070\u00062\u000e\u0010£\u0001\u001a\t\u0012\u0004\u0012\u00020\u00070¤\u0001H\u0082\bJ2\u0010©\u0001\u001a\u00028\u00002\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0007\u0010\u0099\u0001\u001a\u00020\u0010H\u0082@ø\u0001\u0000¢\u0006\u0003\u0010\u009b\u0001J \u0010ª\u0001\u001a\u00020\u00072\n\u0010<\u001a\u0006\u0012\u0002\b\u0003092\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010\fH\u0002J \u0010«\u0001\u001a\u00020\u00072\n\u0010<\u001a\u0006\u0012\u0002\b\u0003092\t\u0010\u0086\u0001\u001a\u0004\u0018\u00010\fH\u0014J\u0017\u0010¬\u0001\u001a\u00020\u00072\f\u0010Y\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0002J\u001c\u0010\u00ad\u0001\u001a\u00020\u00072\u0007\u0010\u0086\u0001\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0003\u0010\u0089\u0001J\u001f\u0010®\u0001\u001a\u00020\u001c2\u0007\u0010\u0086\u0001\u001a\u00028\u0000H\u0090@ø\u0001\u0000¢\u0006\u0006\b¯\u0001\u0010\u0089\u0001J\u0082\u0002\u0010°\u0001\u001a\u0003H\u009d\u0001\"\u0005\b\u0001\u0010\u009d\u00012\u0007\u0010\u0086\u0001\u001a\u00028\u00002\t\u0010\u009e\u0001\u001a\u0004\u0018\u00010\f2\u000f\u0010±\u0001\u001a\n\u0012\u0005\u0012\u0003H\u009d\u00010¤\u00012A\u0010 \u0001\u001a<\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00028\u00000\u0014¢\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(¡\u0001\u0012\u0014\u0012\u00120\u0004¢\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(¢\u0001\u0012\u0005\u0012\u0003H\u009d\u00010²\u00012\u000f\u0010£\u0001\u001a\n\u0012\u0005\u0012\u0003H\u009d\u00010¤\u00012o\b\u0002\u0010¥\u0001\u001ah\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00028\u00000\u0014¢\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(¡\u0001\u0012\u0014\u0012\u00120\u0004¢\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(¢\u0001\u0012\u0014\u0012\u00128\u0000¢\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(\u0086\u0001\u0012\u0014\u0012\u00120\u0010¢\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(´\u0001\u0012\u0005\u0012\u0003H\u009d\u00010³\u0001H\u0084\b¢\u0006\u0003\u0010µ\u0001Jb\u0010¶\u0001\u001a\u00020\u00072\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0007\u0010\u0086\u0001\u001a\u00028\u00002\u0007\u0010´\u0001\u001a\u00020\u00102\b\u0010\u009e\u0001\u001a\u00030¨\u00012\u000e\u0010±\u0001\u001a\t\u0012\u0004\u0012\u00020\u00070¤\u00012\u000e\u0010£\u0001\u001a\t\u0012\u0004\u0012\u00020\u00070¤\u0001H\u0082\b¢\u0006\u0003\u0010·\u0001J;\u0010¸\u0001\u001a\u00020\u00072\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0007\u0010\u0086\u0001\u001a\u00028\u00002\u0007\u0010´\u0001\u001a\u00020\u0010H\u0082@ø\u0001\u0000¢\u0006\u0003\u0010¹\u0001J\u000f\u0010º\u0001\u001a\u00020\u001cH\u0010¢\u0006\u0003\b»\u0001J\u0012\u0010º\u0001\u001a\u00020\u001c2\u0007\u0010¼\u0001\u001a\u00020\u0010H\u0003J\n\u0010½\u0001\u001a\u00030¾\u0001H\u0016J\u0010\u0010¿\u0001\u001a\u00030¾\u0001H\u0000¢\u0006\u0003\bÀ\u0001J!\u0010Á\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000,H\u0016ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0006\bÂ\u0001\u0010Ã\u0001J*\u0010Ä\u0001\u001a\b\u0012\u0004\u0012\u00020\u00070,2\u0007\u0010\u0086\u0001\u001a\u00028\u0000H\u0016ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0006\bÅ\u0001\u0010Æ\u0001J(\u0010Ç\u0001\u001a\u00020\u001c2\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0007\u0010È\u0001\u001a\u00020\u0010H\u0002J(\u0010É\u0001\u001a\u00020\u001c2\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0007\u0010È\u0001\u001a\u00020\u0010H\u0002J5\u0010Ê\u0001\u001a\u0004\u0018\u00010\f2\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0007\u0010\u0099\u0001\u001a\u00020\u00102\t\u0010\u009e\u0001\u001a\u0004\u0018\u00010\fH\u0002J5\u0010Ë\u0001\u001a\u0004\u0018\u00010\f2\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0007\u0010\u0099\u0001\u001a\u00020\u00102\t\u0010\u009e\u0001\u001a\u0004\u0018\u00010\fH\u0002JK\u0010Ì\u0001\u001a\u00020\u00042\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0007\u0010\u0086\u0001\u001a\u00028\u00002\u0007\u0010´\u0001\u001a\u00020\u00102\t\u0010\u009e\u0001\u001a\u0004\u0018\u00010\f2\u0007\u0010Í\u0001\u001a\u00020\u001cH\u0002¢\u0006\u0003\u0010Î\u0001JK\u0010Ï\u0001\u001a\u00020\u00042\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0007\u0010\u0086\u0001\u001a\u00028\u00002\u0007\u0010´\u0001\u001a\u00020\u00102\t\u0010\u009e\u0001\u001a\u0004\u0018\u00010\f2\u0007\u0010Í\u0001\u001a\u00020\u001cH\u0002¢\u0006\u0003\u0010Î\u0001J\u0012\u0010Ð\u0001\u001a\u00020\u00072\u0007\u0010Ñ\u0001\u001a\u00020\u0010H\u0002J\u0012\u0010Ò\u0001\u001a\u00020\u00072\u0007\u0010Ñ\u0001\u001a\u00020\u0010H\u0002J\u0017\u0010Ó\u0001\u001a\u00020\u00072\u0006\u0010u\u001a\u00020\u0010H\u0000¢\u0006\u0003\bÔ\u0001J$\u0010Õ\u0001\u001a\u00020\u0007*\u00030¨\u00012\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u0004H\u0002J$\u0010Ö\u0001\u001a\u00020\u0007*\u00030¨\u00012\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u0004H\u0002J\u000e\u0010×\u0001\u001a\u00020\u0007*\u00030¨\u0001H\u0002J\u000e\u0010Ø\u0001\u001a\u00020\u0007*\u00030¨\u0001H\u0002J\u0017\u0010Ù\u0001\u001a\u00020\u0007*\u00030¨\u00012\u0007\u0010Ú\u0001\u001a\u00020\u001cH\u0002J\u001c\u0010Û\u0001\u001a\u00020\u001c*\u00020\f2\u0007\u0010\u0086\u0001\u001a\u00028\u0000H\u0002¢\u0006\u0003\u0010Ü\u0001J#\u0010Ý\u0001\u001a\u00020\u001c*\u00020\f2\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u0004H\u0002R\u0011\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bX\u0082\u0004R\t\u0010\r\u001a\u00020\u000eX\u0082\u0004R\u0014\u0010\u000f\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00140\u000bX\u0082\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00168DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bX\u0082\u0004R\t\u0010\u001a\u001a\u00020\u000eX\u0082\u0004R\u001a\u0010\u001b\u001a\u00020\u001c8VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001fR\u001a\u0010 \u001a\u00020\u001c8VX\u0097\u0004¢\u0006\f\u0012\u0004\b!\u0010\u001e\u001a\u0004\b \u0010\u001fR\u0014\u0010\"\u001a\u00020\u001c8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\u001fR\u001a\u0010#\u001a\u00020\u001c8VX\u0097\u0004¢\u0006\f\u0012\u0004\b$\u0010\u001e\u001a\u0004\b#\u0010\u001fR\u0014\u0010%\u001a\u00020\u001c8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\u001fR \u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000'8VX\u0096\u0004¢\u0006\f\u0012\u0004\b(\u0010\u001e\u001a\u0004\b)\u0010*R)\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000,0'8VX\u0096\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b-\u0010\u001e\u001a\u0004\b.\u0010*R\"\u0010/\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000'8VX\u0096\u0004¢\u0006\f\u0012\u0004\b0\u0010\u001e\u001a\u0004\b1\u0010*R,\u00102\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0000038VX\u0096\u0004¢\u0006\f\u0012\u0004\b4\u0010\u001e\u001a\u0004\b5\u00106R*\u0010\u0005\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\b8\u0000X\u0081\u0004¢\u0006\u0002\n\u0000Ru\u00107\u001ac\u0012\u0017\u0012\u0015\u0012\u0002\b\u000309¢\u0006\f\b:\u0012\b\b;\u0012\u0004\b\b(<\u0012\u0015\u0012\u0013\u0018\u00010\f¢\u0006\f\b:\u0012\b\b;\u0012\u0004\b\b(=\u0012\u0015\u0012\u0013\u0018\u00010\f¢\u0006\f\b:\u0012\b\b;\u0012\u0004\b\b(>\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00070\u0006\u0018\u000108j\u0004\u0018\u0001`?X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b@\u0010\u001eR\u0014\u0010A\u001a\u00020\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bB\u0010\u0018R\u0015\u0010C\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00140\u000bX\u0082\u0004R\t\u0010D\u001a\u00020\u000eX\u0082\u0004R\u0014\u0010E\u001a\u00020\u00108@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bF\u0010\u0012R\u0014\u0010G\u001a\u00020\u00168DX\u0084\u0004¢\u0006\u0006\u001a\u0004\bH\u0010\u0018R\u0015\u0010I\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00140\u000bX\u0082\u0004R\t\u0010J\u001a\u00020\u000eX\u0082\u0004R\u0014\u0010K\u001a\u00020\u00108@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bL\u0010\u0012R\u0018\u0010M\u001a\u00020\u001c*\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bM\u0010NR\u0018\u0010O\u001a\u00020\u001c*\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bO\u0010N\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006à\u0001"}, d2 = {"Lkotlinx/coroutines/channels/BufferedChannel;", "E", "Lkotlinx/coroutines/channels/Channel;", PerfConsts.KEY_CURRENT_CAPACITY, "", "onUndeliveredElement", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "(ILkotlin/jvm/functions/Function1;)V", "_closeCause", "Lkotlinx/atomicfu/AtomicRef;", "", "bufferEnd", "Lkotlinx/atomicfu/AtomicLong;", "bufferEndCounter", "", "getBufferEndCounter", "()J", "bufferEndSegment", "Lkotlinx/coroutines/channels/ChannelSegment;", "closeCause", "", "getCloseCause", "()Ljava/lang/Throwable;", "closeHandler", "completedExpandBuffersAndPauseFlag", "isClosedForReceive", "", "isClosedForReceive$annotations", "()V", "()Z", "isClosedForSend", "isClosedForSend$annotations", "isConflatedDropOldest", "isEmpty", "isEmpty$annotations", "isRendezvousOrUnlimited", "onReceive", "Lkotlinx/coroutines/selects/SelectClause1;", "getOnReceive$annotations", "getOnReceive", "()Lkotlinx/coroutines/selects/SelectClause1;", "onReceiveCatching", "Lkotlinx/coroutines/channels/ChannelResult;", "getOnReceiveCatching$annotations", "getOnReceiveCatching", "onReceiveOrNull", "getOnReceiveOrNull$annotations", "getOnReceiveOrNull", "onSend", "Lkotlinx/coroutines/selects/SelectClause2;", "getOnSend$annotations", "getOnSend", "()Lkotlinx/coroutines/selects/SelectClause2;", "onUndeliveredElementReceiveCancellationConstructor", "Lkotlin/Function3;", "Lkotlinx/coroutines/selects/SelectInstance;", "Lkotlin/ParameterName;", "name", "select", AutoTestConstant.PARAM, "internalResult", "Lkotlinx/coroutines/selects/OnCancellationConstructor;", "getOnUndeliveredElementReceiveCancellationConstructor$annotations", "receiveException", "getReceiveException", "receiveSegment", "receivers", "receiversCounter", "getReceiversCounter$kotlinx_coroutines_core", "sendException", "getSendException", "sendSegment", "sendersAndCloseStatus", "sendersCounter", "getSendersCounter$kotlinx_coroutines_core", "isClosedForReceive0", "(J)Z", "isClosedForSend0", "bufferOrRendezvousSend", "curSenders", BDSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CANCEL, "cause", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "cancelImpl", "cancelImpl$kotlinx_coroutines_core", "cancelSuspendedReceiveRequests", "lastSegment", "checkSegmentStructureInvariants", "close", "closeLinkedList", "closeOrCancelImpl", "completeCancel", "sendersCur", "completeClose", "completeCloseOrCancel", "dropFirstElementUntilTheSpecifiedCellIsInTheBuffer", "globalCellIndex", "expandBuffer", "findSegmentBufferEnd", "id", "startFrom", "currentBufferEndCounter", "findSegmentReceive", "findSegmentSend", "hasElements", "hasElements$kotlinx_coroutines_core", "incCompletedExpandBufferAttempts", "nAttempts", "invokeCloseHandler", "invokeOnClose", "handler", "isCellNonEmpty", "segment", "index", "globalIndex", "isClosed", "sendersAndCloseStatusCur", "iterator", "Lkotlinx/coroutines/channels/ChannelIterator;", "markAllEmptyCellsAsClosed", "markCancellationStarted", "markCancelled", "markClosed", "moveSegmentBufferEndToSpecifiedOrLast", "onClosedIdempotent", "onClosedReceiveCatchingOnNoWaiterSuspend", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "onClosedReceiveOnNoWaiterSuspend", "onClosedSelectOnReceive", "onClosedSelectOnSend", "element", "(Ljava/lang/Object;Lkotlinx/coroutines/selects/SelectInstance;)V", "onClosedSend", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onClosedSendOnNoWaiterSuspend", "(Ljava/lang/Object;Lkotlinx/coroutines/CancellableContinuation;)V", "onReceiveDequeued", "onReceiveEnqueued", "processResultSelectReceive", "ignoredParam", "selectResult", "processResultSelectReceiveCatching", "processResultSelectReceiveOrNull", "processResultSelectSend", "receive", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "receiveCatching", "receiveCatching-JP2dKIU", "receiveCatchingOnNoWaiterSuspend", "r", "receiveCatchingOnNoWaiterSuspend-GKJJFZk", "(Lkotlinx/coroutines/channels/ChannelSegment;IJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "receiveImpl", "R", "waiter", "onElementRetrieved", "onSuspend", "segm", "i", "onClosed", "Lkotlin/Function0;", "onNoWaiterSuspend", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "receiveImplOnNoWaiter", "Lkotlinx/coroutines/Waiter;", "receiveOnNoWaiterSuspend", "registerSelectForReceive", "registerSelectForSend", "removeUnprocessedElements", CommonKey.KEY_SEND, "sendBroadcast", "sendBroadcast$kotlinx_coroutines_core", "sendImpl", "onRendezvousOrBuffered", "Lkotlin/Function2;", "Lkotlin/Function4;", DateFormat.SECOND, "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function4;)Ljava/lang/Object;", "sendImplOnNoWaiter", "(Lkotlinx/coroutines/channels/ChannelSegment;ILjava/lang/Object;JLkotlinx/coroutines/Waiter;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "sendOnNoWaiterSuspend", "(Lkotlinx/coroutines/channels/ChannelSegment;ILjava/lang/Object;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shouldSendSuspend", "shouldSendSuspend$kotlinx_coroutines_core", "curSendersAndCloseStatus", "toString", "", "toStringDebug", "toStringDebug$kotlinx_coroutines_core", "tryReceive", "tryReceive-PtdJZtk", "()Ljava/lang/Object;", "trySend", "trySend-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "updateCellExpandBuffer", "b", "updateCellExpandBufferSlow", "updateCellReceive", "updateCellReceiveSlow", "updateCellSend", "closed", "(Lkotlinx/coroutines/channels/ChannelSegment;ILjava/lang/Object;JLjava/lang/Object;Z)I", "updateCellSendSlow", "updateReceiversCounterIfLower", "value", "updateSendersCounterIfLower", "waitExpandBufferCompletion", "waitExpandBufferCompletion$kotlinx_coroutines_core", "prepareReceiverForSuspension", "prepareSenderForSuspension", "resumeReceiverOnClosedChannel", "resumeSenderOnCancelledChannel", "resumeWaiterOnClosedChannel", SliceBroadcastRelay.EXTRA_RECEIVER, "tryResumeReceiver", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "tryResumeSender", "BufferedChannelIterator", "SendBroadcast", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class BufferedChannel<E> implements Channel<E> {
    private static final AtomicReferenceFieldUpdater _closeCause$FU = null;
    private static final AtomicLongFieldUpdater bufferEnd$FU = null;
    private static final AtomicReferenceFieldUpdater bufferEndSegment$FU = null;
    private static final AtomicReferenceFieldUpdater closeHandler$FU = null;
    private static final AtomicLongFieldUpdater completedExpandBuffersAndPauseFlag$FU = null;
    private static final AtomicReferenceFieldUpdater receiveSegment$FU = null;
    private static final AtomicLongFieldUpdater receivers$FU = null;
    private static final AtomicReferenceFieldUpdater sendSegment$FU = null;
    private static final AtomicLongFieldUpdater sendersAndCloseStatus$FU = null;

    @Volatile
    private volatile Object _closeCause;

    @Volatile
    private volatile long bufferEnd;

    @Volatile
    private volatile Object bufferEndSegment;
    private final int capacity;

    @Volatile
    private volatile Object closeHandler;

    @Volatile
    private volatile long completedExpandBuffersAndPauseFlag;
    public final Function1<E, Unit> onUndeliveredElement;
    private final Function3<SelectInstance<?>, Object, Object, Function1<Throwable, Unit>> onUndeliveredElementReceiveCancellationConstructor;

    @Volatile
    private volatile Object receiveSegment;

    @Volatile
    private volatile long receivers;

    @Volatile
    private volatile Object sendSegment;

    @Volatile
    private volatile long sendersAndCloseStatus;

    /* JADX INFO: compiled from: BufferedChannel.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0011\u0010\t\u001a\u00020\u0006H\u0096Bø\u0001\u0000¢\u0006\u0002\u0010\nJ/\u0010\u000b\u001a\u00020\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0012J\u001c\u0010\u0013\u001a\u00020\u00142\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u00152\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u000e\u0010\u0016\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0017J\b\u0010\u0018\u001a\u00020\u0006H\u0002J\b\u0010\u0019\u001a\u00020\u0014H\u0002J\u0013\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00028\u0000¢\u0006\u0002\u0010\u001cJ\u0006\u0010\u001d\u001a\u00020\u0014R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001e"}, d2 = {"Lkotlinx/coroutines/channels/BufferedChannel$BufferedChannelIterator;", "Lkotlinx/coroutines/channels/ChannelIterator;", "Lkotlinx/coroutines/Waiter;", "(Lkotlinx/coroutines/channels/BufferedChannel;)V", "continuation", "Lkotlinx/coroutines/CancellableContinuationImpl;", "", "receiveResult", "", "hasNext", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hasNextOnNoWaiterSuspend", "segment", "Lkotlinx/coroutines/channels/ChannelSegment;", "index", "", "r", "", "(Lkotlinx/coroutines/channels/ChannelSegment;IJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invokeOnCancellation", "", "Lkotlinx/coroutines/internal/Segment;", "next", "()Ljava/lang/Object;", "onClosedHasNext", "onClosedHasNextNoWaiterSuspend", "tryResumeHasNext", "element", "(Ljava/lang/Object;)Z", "tryResumeHasNextOnClosedChannel", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private final class BufferedChannelIterator implements ChannelIterator<E>, Waiter {
        private CancellableContinuationImpl<? super Boolean> continuation;
        private Object receiveResult;
        final /* synthetic */ BufferedChannel<E> this$0;

        public BufferedChannelIterator(BufferedChannel r1) {
            this.this$0 = r1;
            this.receiveResult = BufferedChannelKt.access$getNO_RECEIVE_RESULT$p();
        }

        public static final /* synthetic */ Object access$hasNextOnNoWaiterSuspend(BufferedChannelIterator r0, ChannelSegment r1, int r2, long r3, Continuation r5) {
            return r0.hasNextOnNoWaiterSuspend(r1, r2, r3, r5);
        }

        public static final /* synthetic */ void access$onClosedHasNextNoWaiterSuspend(BufferedChannelIterator r0) {
            r0.onClosedHasNextNoWaiterSuspend();
        }

        public static final /* synthetic */ void access$setContinuation$p(BufferedChannelIterator r0, CancellableContinuationImpl r1) {
            r0.continuation = r1;
        }

        public static final /* synthetic */ void access$setReceiveResult$p(BufferedChannelIterator r0, Object r1) {
            r0.receiveResult = r1;
        }

        @Override // kotlinx.coroutines.channels.ChannelIterator
        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.3.0, binary compatibility with versions <= 1.2.x")
        public /* synthetic */ Object next(Continuation r1) {
            return ChannelIterator.DefaultImpls.next(this, r1);
        }

        @Override // kotlinx.coroutines.channels.ChannelIterator
        public Object hasNext(Continuation<? super Boolean> r15) {
            BufferedChannel<E> r6 = this.this$0;
            ChannelSegment<E> r0 = (ChannelSegment) BufferedChannel.access$getReceiveSegment$FU$p().get(r6);
        L4:
            if (r6.isClosedForReceive() == true) goto L37;
            long r11 = BufferedChannel.access$getReceivers$FU$p().getAndIncrement(r6);
            long r1 = r11 / ((long) BufferedChannelKt.SEGMENT_SIZE);
            int r10 = (int) (r11 % ((long) BufferedChannelKt.SEGMENT_SIZE));
            if (r0.id == r1) goto L12;
            ChannelSegment<E> r2 = BufferedChannel.access$findSegmentReceive(r6, r1, r0);
            if (r2 == null) goto L4;
            ChannelSegment<E> r9 = r2;
        L13:
            Object r3 = BufferedChannel.access$updateCellReceive(r6, r9, r10, r11, null);
            if (r3 == BufferedChannelKt.access$getSUSPEND$p()) goto L28;
            if (r3 != BufferedChannelKt.access$getFAILED$p()) goto L22;
            if (r11 >= r6.getSendersCounter$kotlinx_coroutines_core()) goto L20;
            r9.cleanPrev();
        L20:
            r0 = r9;
            goto L4
        L22:
            if (r3 == BufferedChannelKt.access$getSUSPEND_NO_WAITER$p()) goto L24;
            r9.cleanPrev();
            this.receiveResult = r3;
            return Boxing.boxBoolean(true);
        L24:
            return hasNextOnNoWaiterSuspend(r9, r10, r11, r15);
        L28:
            throw new IllegalStateException("unreachable".toString());
        L12:
            r9 = r0;
            goto L13
        L37:
            return Boxing.boxBoolean(onClosedHasNext());
        }

        private final boolean onClosedHasNext() {
            this.receiveResult = BufferedChannelKt.getCHANNEL_CLOSED();
            Throwable r1 = this.this$0.getCloseCause();
            if (r1 != null) goto L7;
            return false;
        L7:
            throw StackTraceRecoveryKt.recoverStackTrace(r1);
        }

        private final Object hasNextOnNoWaiterSuspend(ChannelSegment<E> r11, int r12, long r13, Continuation<? super Boolean> r15) {
            BufferedChannel<E> r6 = this.this$0;
            CancellableContinuationImpl r7 = CancellableContinuationKt.getOrCreateCancellableContinuation(IntrinsicsKt.intercepted(r15));
            access$setContinuation$p(this, r7);     // Catch: Throwable -> L49
            Object r0 = BufferedChannel.access$updateCellReceive(r6, r11, r12, r13, this);     // Catch: Throwable -> L49
            if (r0 != BufferedChannelKt.access$getSUSPEND$p()) goto L6;
            BufferedChannel.access$prepareReceiverForSuspension(r6, this, r11, r12);     // Catch: Throwable -> L49
        L45:
            Object r10 = r7.getResult();
            if (r10 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L48;
            DebugProbesKt.probeCoroutineSuspended(r15);
        L48:
            return r10;
        L6:
            Function1<Throwable, Unit> r9 = null;
            r9 = null;
            BufferedChannelIterator r14 = null;
            if (r0 == BufferedChannelKt.access$getFAILED$p()) goto L9;
            r11.cleanPrev();     // Catch: Throwable -> L49
            access$setReceiveResult$p(this, r0);     // Catch: Throwable -> L49
            access$setContinuation$p(this, null);     // Catch: Throwable -> L49
            Boolean r16 = Boxing.boxBoolean(true);     // Catch: Throwable -> L49
            Function1<E, Unit> r17 = r6.onUndeliveredElement;     // Catch: Throwable -> L49
            if (r17 != null) goto L43;
        L38:
            r7.resume(r16, r9);     // Catch: Throwable -> L49
            goto L45
        L43:
            r9 = OnUndeliveredElementKt.bindCancellationFun(r17, r0, r7.getContext());     // Catch: Throwable -> L49
            goto L38
        L9:
            if (r13 >= r6.getSendersCounter$kotlinx_coroutines_core()) goto L11;
            r11.cleanPrev();     // Catch: Throwable -> L49
        L11:
            ChannelSegment r18 = (ChannelSegment) BufferedChannel.access$getReceiveSegment$FU$p().get(r6);     // Catch: Throwable -> L49
        L13:
            if (r6.isClosedForReceive() == true) goto L14;
            long r19 = BufferedChannel.access$getReceivers$FU$p().getAndIncrement(r6);     // Catch: Throwable -> L49
            long r1 = r19 / ((long) BufferedChannelKt.SEGMENT_SIZE);     // Catch: Throwable -> L49
            int r110 = (int) (r19 % ((long) BufferedChannelKt.SEGMENT_SIZE));     // Catch: Throwable -> L49
            if (r18.id == r1) goto L21;
            ChannelSegment r2 = BufferedChannel.access$findSegmentReceive(r6, r1, r18);     // Catch: Throwable -> L49
            if (r2 == null) goto L13;
            r18 = r2;
        L21:
            ChannelSegment r3 = r18;
            Object r4 = BufferedChannel.access$updateCellReceive(r6, r3, r110, r19, this);     // Catch: Throwable -> L49
            if (r4 == BufferedChannelKt.access$getSUSPEND$p()) goto L24;
            if (r4 != BufferedChannelKt.access$getFAILED$p()) goto L34;
            if (r19 >= r6.getSendersCounter$kotlinx_coroutines_core()) goto L13;
            r18.cleanPrev();     // Catch: Throwable -> L49
            goto L13
        L34:
            if (r4 == BufferedChannelKt.access$getSUSPEND_NO_WAITER$p()) goto L40;
            r18.cleanPrev();     // Catch: Throwable -> L49
            access$setReceiveResult$p(this, r4);     // Catch: Throwable -> L49
            access$setContinuation$p(this, null);     // Catch: Throwable -> L49
            r16 = Boxing.boxBoolean(true);     // Catch: Throwable -> L49
            Function1<E, Unit> r111 = r6.onUndeliveredElement;     // Catch: Throwable -> L49
            if (r111 == null) goto L38;
            r9 = OnUndeliveredElementKt.bindCancellationFun(r111, r4, r7.getContext());     // Catch: Throwable -> L49
            goto L38
        L40:
            throw new IllegalStateException("unexpected".toString());     // Catch: Throwable -> L49
        L24:
            if ((this instanceof Waiter) == false) goto L26;
            r14 = this;     // Catch: Throwable -> L49
        L26:
            if (r14 == null) goto L45;
            BufferedChannel.access$prepareReceiverForSuspension(r6, r14, r18, r110);     // Catch: Throwable -> L49
            goto L45
        L14:
            access$onClosedHasNextNoWaiterSuspend(this);     // Catch: Throwable -> L49
        L49:
            th = move-exception;
            r7.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
            throw th;
        }

        @Override // kotlinx.coroutines.Waiter
        public void invokeOnCancellation(Segment<?> r1, int r2) {
            CancellableContinuationImpl<? super Boolean> r0 = this.continuation;
            if (r0 == null) goto L6;
            r0.invokeOnCancellation(r1, r2);
            return;
        }

        private final void onClosedHasNextNoWaiterSuspend() {
            CancellableContinuationImpl<? super Boolean> r0 = this.continuation;
            Intrinsics.checkNotNull(r0);
            this.continuation = null;
            this.receiveResult = BufferedChannelKt.getCHANNEL_CLOSED();
            Throwable r2 = this.this$0.getCloseCause();
            if (r2 != null) goto L5;
            Result.Companion r3 = Result.Companion;
            r0.resumeWith(Result.m1508constructorimpl(false));
            return;
        L5:
            CancellableContinuationImpl<? super Boolean> r1 = r0;
            if (DebugKt.getRECOVER_STACK_TRACES() == true) goto L8;
        L11:
            Result.Companion r4 = Result.Companion;
            r1.resumeWith(Result.m1508constructorimpl(ResultKt.createFailure(r2)));
            return;
        L8:
            if ((r1 instanceof CoroutineStackFrame) == false) goto L11;
            r2 = StackTraceRecoveryKt.access$recoverFromStackFrame(r2, r1);
            goto L11
        }

        @Override // kotlinx.coroutines.channels.ChannelIterator
        public E next() {
            E r0 = (E) this.receiveResult;
            if (r0 == BufferedChannelKt.access$getNO_RECEIVE_RESULT$p()) goto L5;
            boolean r1 = true;
        L6:
            if (r1 == false) goto L13;
            this.receiveResult = BufferedChannelKt.access$getNO_RECEIVE_RESULT$p();
            if (r0 == BufferedChannelKt.getCHANNEL_CLOSED()) goto L11;
            return r0;
        L11:
            throw StackTraceRecoveryKt.recoverStackTrace(BufferedChannel.access$getReceiveException(this.this$0));
        L13:
            throw new IllegalStateException("`hasNext()` has not been invoked".toString());
        L5:
            r1 = false;
            goto L6
        }

        public final boolean tryResumeHasNext(E r5) {
            CancellableContinuationImpl<? super Boolean> r0 = this.continuation;
            Intrinsics.checkNotNull(r0);
            Function1<Throwable, Unit> r1 = null;
            this.continuation = null;
            this.receiveResult = r5;
            CancellableContinuationImpl<? super Boolean> r2 = r0;
            Function1<E, Unit> r4 = this.this$0.onUndeliveredElement;
            if (r4 == null) goto L6;
            r1 = OnUndeliveredElementKt.bindCancellationFun(r4, r5, r0.getContext());
        L6:
            return BufferedChannelKt.access$tryResume0(r2, true, r1);
        }

        public final void tryResumeHasNextOnClosedChannel() {
            CancellableContinuationImpl<? super Boolean> r0 = this.continuation;
            Intrinsics.checkNotNull(r0);
            this.continuation = null;
            this.receiveResult = BufferedChannelKt.getCHANNEL_CLOSED();
            Throwable r2 = this.this$0.getCloseCause();
            if (r2 != null) goto L5;
            Result.Companion r3 = Result.Companion;
            r0.resumeWith(Result.m1508constructorimpl(false));
            return;
        L5:
            CancellableContinuationImpl<? super Boolean> r1 = r0;
            if (DebugKt.getRECOVER_STACK_TRACES() == true) goto L8;
        L11:
            Result.Companion r4 = Result.Companion;
            r1.resumeWith(Result.m1508constructorimpl(ResultKt.createFailure(r2)));
            return;
        L8:
            if ((r1 instanceof CoroutineStackFrame) == false) goto L11;
            r2 = StackTraceRecoveryKt.access$recoverFromStackFrame(r2, r1);
            goto L11
        }
    }

    /* JADX INFO: compiled from: BufferedChannel.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u001d\u0010\b\u001a\u00020\t2\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010\f\u001a\u00020\rH\u0096\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/channels/BufferedChannel$SendBroadcast;", "Lkotlinx/coroutines/Waiter;", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "", "(Lkotlinx/coroutines/CancellableContinuation;)V", "getCont", "()Lkotlinx/coroutines/CancellableContinuation;", "invokeOnCancellation", "", "segment", "Lkotlinx/coroutines/internal/Segment;", "index", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class SendBroadcast implements Waiter {
        private final /* synthetic */ CancellableContinuationImpl<Boolean> $$delegate_0;
        private final CancellableContinuation<Boolean> cont;

        @Override // kotlinx.coroutines.Waiter
        public void invokeOnCancellation(Segment<?> r1, int r2) {
            this.$$delegate_0.invokeOnCancellation(r1, r2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public SendBroadcast(CancellableContinuation<? super Boolean> r2) {
            this.cont = r2;
            Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuationImpl<kotlin.Boolean>");
            this.$$delegate_0 = (CancellableContinuationImpl) r2;
        }

        public final CancellableContinuation<Boolean> getCont() {
            return this.cont;
        }
    }

    static {
        sendersAndCloseStatus$FU = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "sendersAndCloseStatus");
        receivers$FU = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "receivers");
        bufferEnd$FU = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "bufferEnd");
        completedExpandBuffersAndPauseFlag$FU = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "completedExpandBuffersAndPauseFlag");
        sendSegment$FU = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "sendSegment");
        receiveSegment$FU = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "receiveSegment");
        bufferEndSegment$FU = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "bufferEndSegment");
        _closeCause$FU = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "_closeCause");
        closeHandler$FU = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "closeHandler");
    }

    private final Object getAndUpdate$atomicfu(AtomicReferenceFieldUpdater r2, Function1<Object, ? extends Object> r3, Object r4) {
    L2:
        Object r1 = r2.get(r4);
        if (r2.compareAndSet(r4, r1, r3.invoke(r1)) == false) goto L2;
        return r1;
    }

    public static /* synthetic */ void getOnReceive$annotations() {
    }

    public static /* synthetic */ void getOnReceiveCatching$annotations() {
    }

    public static /* synthetic */ void getOnReceiveOrNull$annotations() {
    }

    public static /* synthetic */ void getOnSend$annotations() {
    }

    private static /* synthetic */ void getOnUndeliveredElementReceiveCancellationConstructor$annotations() {
    }

    public static /* synthetic */ void isClosedForReceive$annotations() {
    }

    public static /* synthetic */ void isClosedForSend$annotations() {
    }

    public static /* synthetic */ void isEmpty$annotations() {
    }

    private final void loop$atomicfu(AtomicLongFieldUpdater r3, Function1<? super Long, Unit> r4, Object r5) {
    L2:
        r4.invoke(Long.valueOf(r3.get(r5)));
        goto L2
    }

    private final void loop$atomicfu(AtomicReferenceFieldUpdater r1, Function1<Object, Unit> r2, Object r3) {
    L2:
        r2.invoke(r1.get(r3));
        goto L2
    }

    private final void update$atomicfu(AtomicLongFieldUpdater r7, Function1<? super Long, Long> r8, Object r9) {
    L2:
        long r2 = r7.get(r9);
        if (r7.compareAndSet(r9, r2, r8.invoke(Long.valueOf(r2)).longValue()) == false) goto L2;
    }

    protected boolean isConflatedDropOldest() {
        return false;
    }

    protected void onClosedIdempotent() {
    }

    protected void onReceiveDequeued() {
    }

    protected void onReceiveEnqueued() {
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public Object receive(Continuation<? super E> r1) {
        return receive$suspendImpl(this, r1);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    /* JADX INFO: renamed from: receiveCatching-JP2dKIU, reason: not valid java name */
    public Object mo3016receiveCatchingJP2dKIU(Continuation<? super ChannelResult<? extends E>> r1) {
        return m3014receiveCatchingJP2dKIU$suspendImpl(this, r1);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public Object send(E r1, Continuation<? super Unit> r2) {
        return send$suspendImpl(this, r1, r2);
    }

    public Object sendBroadcast$kotlinx_coroutines_core(E r1, Continuation<? super Boolean> r2) {
        return sendBroadcast$suspendImpl(this, r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BufferedChannel(int r9, Function1<? super E, Unit> r10) {
        this.capacity = r9;
        this.onUndeliveredElement = r10;
        if (r9 < 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L17;
        this.bufferEnd = BufferedChannelKt.access$initialBufferEnd(r9);
        this.completedExpandBuffersAndPauseFlag = getBufferEndCounter();
        ChannelSegment r11 = new ChannelSegment(0, null, this, 3);
        this.sendSegment = r11;
        this.receiveSegment = r11;
        if (isRendezvousOrUnlimited() == false) goto L10;
        r11 = BufferedChannelKt.access$getNULL_SEGMENT$p();
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type kotlinx.coroutines.channels.ChannelSegment<E of kotlinx.coroutines.channels.BufferedChannel>");
    L10:
        this.bufferEndSegment = r11;
        if (r10 == 0) goto L13;
        Function3<SelectInstance<?>, Object, Object, Function1<Throwable, Unit>> r12 = (Function3) new BufferedChannel$onUndeliveredElementReceiveCancellationConstructor$1$1(this);
    L14:
        this.onUndeliveredElementReceiveCancellationConstructor = r12;
        this._closeCause = BufferedChannelKt.access$getNO_CLOSE_CAUSE$p();
        return;
    L13:
        r12 = null;
        goto L14
    L17:
        throw new IllegalArgumentException(("Invalid channel capacity: " + r9 + ", should be >=0").toString());
    L5:
        r0 = false;
        goto L6
    }

    public /* synthetic */ BufferedChannel(int r1, Function1 r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }

    public static final /* synthetic */ ChannelSegment access$findSegmentReceive(BufferedChannel r0, long r1, ChannelSegment r3) {
        return r0.findSegmentReceive(r1, r3);
    }

    public static final /* synthetic */ ChannelSegment access$findSegmentSend(BufferedChannel r0, long r1, ChannelSegment r3) {
        return r0.findSegmentSend(r1, r3);
    }

    public static final /* synthetic */ Throwable access$getReceiveException(BufferedChannel r0) {
        return r0.getReceiveException();
    }

    public static final /* synthetic */ AtomicReferenceFieldUpdater access$getReceiveSegment$FU$p() {
        return receiveSegment$FU;
    }

    public static final /* synthetic */ AtomicLongFieldUpdater access$getReceivers$FU$p() {
        return receivers$FU;
    }

    public static final /* synthetic */ AtomicReferenceFieldUpdater access$getSendSegment$FU$p() {
        return sendSegment$FU;
    }

    public static final /* synthetic */ AtomicLongFieldUpdater access$getSendersAndCloseStatus$FU$p() {
        return sendersAndCloseStatus$FU;
    }

    public static final /* synthetic */ boolean access$isClosedForSend0(BufferedChannel r0, long r1) {
        return r0.isClosedForSend0(r1);
    }

    public static final /* synthetic */ void access$onClosedReceiveCatchingOnNoWaiterSuspend(BufferedChannel r0, CancellableContinuation r1) {
        r0.onClosedReceiveCatchingOnNoWaiterSuspend(r1);
    }

    public static final /* synthetic */ void access$onClosedReceiveOnNoWaiterSuspend(BufferedChannel r0, CancellableContinuation r1) {
        r0.onClosedReceiveOnNoWaiterSuspend(r1);
    }

    public static final /* synthetic */ Object access$onClosedSend(BufferedChannel r0, Object r1, Continuation r2) {
        return r0.onClosedSend(r1, r2);
    }

    public static final /* synthetic */ void access$onClosedSendOnNoWaiterSuspend(BufferedChannel r0, Object r1, CancellableContinuation r2) {
        r0.onClosedSendOnNoWaiterSuspend(r1, r2);
    }

    public static final /* synthetic */ void access$prepareReceiverForSuspension(BufferedChannel r0, Waiter r1, ChannelSegment r2, int r3) {
        r0.prepareReceiverForSuspension(r1, r2, r3);
    }

    public static final /* synthetic */ void access$prepareSenderForSuspension(BufferedChannel r0, Waiter r1, ChannelSegment r2, int r3) {
        r0.prepareSenderForSuspension(r1, r2, r3);
    }

    public static final /* synthetic */ Object access$processResultSelectReceive(BufferedChannel r0, Object r1, Object r2) {
        return r0.processResultSelectReceive(r1, r2);
    }

    public static final /* synthetic */ Object access$processResultSelectReceiveCatching(BufferedChannel r0, Object r1, Object r2) {
        return r0.processResultSelectReceiveCatching(r1, r2);
    }

    public static final /* synthetic */ Object access$processResultSelectReceiveOrNull(BufferedChannel r0, Object r1, Object r2) {
        return r0.processResultSelectReceiveOrNull(r1, r2);
    }

    public static final /* synthetic */ Object access$processResultSelectSend(BufferedChannel r0, Object r1, Object r2) {
        return r0.processResultSelectSend(r1, r2);
    }

    /* JADX INFO: renamed from: access$receiveCatchingOnNoWaiterSuspend-GKJJFZk, reason: not valid java name */
    public static final /* synthetic */ Object m3013access$receiveCatchingOnNoWaiterSuspendGKJJFZk(BufferedChannel r0, ChannelSegment r1, int r2, long r3, Continuation r5) {
        return r0.m3015receiveCatchingOnNoWaiterSuspendGKJJFZk(r1, r2, r3, r5);
    }

    public static final /* synthetic */ Object access$receiveOnNoWaiterSuspend(BufferedChannel r0, ChannelSegment r1, int r2, long r3, Continuation r5) {
        return r0.receiveOnNoWaiterSuspend(r1, r2, r3, r5);
    }

    public static final /* synthetic */ void access$registerSelectForReceive(BufferedChannel r0, SelectInstance r1, Object r2) {
        r0.registerSelectForReceive(r1, r2);
    }

    public static final /* synthetic */ Object access$sendOnNoWaiterSuspend(BufferedChannel r0, ChannelSegment r1, int r2, Object r3, long r4, Continuation r6) {
        return r0.sendOnNoWaiterSuspend(r1, r2, r3, r4, r6);
    }

    public static final /* synthetic */ Object access$updateCellReceive(BufferedChannel r0, ChannelSegment r1, int r2, long r3, Object r5) {
        return r0.updateCellReceive(r1, r2, r3, r5);
    }

    public static final /* synthetic */ int access$updateCellSend(BufferedChannel r0, ChannelSegment r1, int r2, Object r3, long r4, Object r6, boolean r7) {
        return r0.updateCellSend(r1, r2, r3, r4, r6, r7);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'trySend' method", replaceWith = @ReplaceWith(expression = "trySend(element).isSuccess", imports = {}))
    public boolean offer(E r1) {
        return Channel.DefaultImpls.offer(this, r1);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'tryReceive'. Please note that the provided replacement does not rethrow channel's close cause as 'poll' did, for the precise replacement please refer to the 'poll' documentation", replaceWith = @ReplaceWith(expression = "tryReceive().getOrNull()", imports = {}))
    public E poll() {
        return (E) Channel.DefaultImpls.poll(this);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in favor of 'receiveCatching'. Please note that the provided replacement does not rethrow channel's close cause as 'receiveOrNull' did, for the detailed replacement please refer to the 'receiveOrNull' documentation", replaceWith = @ReplaceWith(expression = "receiveCatching().getOrNull()", imports = {}))
    public Object receiveOrNull(Continuation<? super E> r1) {
        return Channel.DefaultImpls.receiveOrNull(this, r1);
    }

    public final long getSendersCounter$kotlinx_coroutines_core() {
        return sendersAndCloseStatus$FU.get(this) & 1152921504606846975L;
    }

    public final long getReceiversCounter$kotlinx_coroutines_core() {
        return receivers$FU.get(this);
    }

    private final long getBufferEndCounter() {
        return bufferEnd$FU.get(this);
    }

    private final boolean isRendezvousOrUnlimited() {
        long r0 = getBufferEndCounter();
        if (r0 != 0) goto L5;
    L8:
        return true;
    L5:
        if (r0 == Long.MAX_VALUE) goto L8;
        return false;
    }

    static /* synthetic */ <E> Object send$suspendImpl(BufferedChannel<E> r15, E r16, Continuation<? super Unit> r17) {
        ChannelSegment<E> r0 = (ChannelSegment) access$getSendSegment$FU$p().get(r15);
    L3:
        long r1 = access$getSendersAndCloseStatus$FU$p().getAndIncrement(r15);
        long r10 = r1 & 1152921504606846975L;
        boolean r12 = access$isClosedForSend0(r15, r1);
        long r2 = r10 / ((long) BufferedChannelKt.SEGMENT_SIZE);
        int r13 = (int) (r10 % ((long) BufferedChannelKt.SEGMENT_SIZE));
        if (r0.id == r2) goto L12;
        ChannelSegment<E> r3 = access$findSegmentSend(r15, r2, r0);
        if (r3 == null) goto L7;
        ChannelSegment<E> r14 = r3;
    L13:
        int r4 = access$updateCellSend(r15, r14, r13, r16, r10, null, r12);
        if (r4 == 0) goto L46;
        if (r4 == 1) goto L48;
        if (r4 == 2) goto L37;
        if (r4 == 3) goto L34;
        if (r4 == 4) goto L29;
        if (r4 != 5) goto L27;
        r14.cleanPrev();
    L27:
        r0 = r14;
        goto L3
    L29:
        if (r10 >= r15.getReceiversCounter$kotlinx_coroutines_core()) goto L31;
        r14.cleanPrev();
    L31:
        Object r5 = r15.onClosedSend(r16, r17);
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L48;
        return r5;
    L34:
        Object r6 = r15.sendOnNoWaiterSuspend(r14, r13, r16, r10, r17);
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L48;
        return r6;
    L37:
        if (r12 == false) goto L42;
        r14.onSlotCleaned();
        Object r7 = r15.onClosedSend(r16, r17);
        if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L48;
        return r7;
    L42:
        if (DebugKt.getASSERTIONS_ENABLED() == false) goto L48;
        throw new AssertionError();
    L48:
        return Unit.INSTANCE;
    L46:
        r14.cleanPrev();
        goto L48
    L7:
        if (r12 == false) goto L3;
        Object r8 = r15.onClosedSend(r16, r17);
        if (r8 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L48;
        return r8;
    L12:
        r14 = r0;
        goto L13
    }

    private final void prepareSenderForSuspension(Waiter r1, ChannelSegment<E> r2, int r3) {
        r1.invokeOnCancellation(r2, r3 + BufferedChannelKt.SEGMENT_SIZE);
    }

    private final void onClosedSendOnNoWaiterSuspend(E r3, CancellableContinuation<? super Unit> r4) {
        Function1<E, Unit> r0 = this.onUndeliveredElement;
        if (r0 == null) goto L5;
        OnUndeliveredElementKt.callUndeliveredElement(r0, r3, r4.getContext());
    L5:
        CancellableContinuation<? super Unit> r5 = r4;
        Throwable r2 = getSendException();
        if (DebugKt.getRECOVER_STACK_TRACES() == true) goto L8;
    L11:
        Result.Companion r6 = Result.Companion;
        r5.resumeWith(Result.m1508constructorimpl(ResultKt.createFailure(r2)));
        return;
    L8:
        if ((r5 instanceof CoroutineStackFrame) == false) goto L11;
        r2 = StackTraceRecoveryKt.access$recoverFromStackFrame(r2, (CoroutineStackFrame) r5);
        goto L11
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    /* JADX INFO: renamed from: trySend-JP2dKIU */
    public Object mo3012trySendJP2dKIU(E r15) {
        if (shouldSendSuspend(sendersAndCloseStatus$FU.get(this)) == true) goto L5;
        Object r8 = BufferedChannelKt.access$getINTERRUPTED_SEND$p();
        ChannelSegment r0 = (ChannelSegment) access$getSendSegment$FU$p().get(this);
    L7:
        long r1 = access$getSendersAndCloseStatus$FU$p().getAndIncrement(this);
        long r9 = r1 & 1152921504606846975L;
        boolean r11 = access$isClosedForSend0(this, r1);
        long r2 = r9 / ((long) BufferedChannelKt.SEGMENT_SIZE);
        int r12 = (int) (r9 % ((long) BufferedChannelKt.SEGMENT_SIZE));
        if (r0.id == r2) goto L14;
        ChannelSegment r3 = access$findSegmentSend(this, r2, r0);
        if (r3 == null) goto L11;
        ChannelSegment r13 = r3;
    L15:
        int r4 = access$updateCellSend(this, r13, r12, r15, r9, r8, r11);
        if (r4 == 0) goto L45;
        if (r4 == 1) goto L47;
        if (r4 == 2) goto L35;
        if (r4 == 3) goto L34;
        if (r4 == 4) goto L31;
        if (r4 != 5) goto L29;
        r13.cleanPrev();
    L29:
        r0 = r13;
        goto L7
    L31:
        if (r9 >= getReceiversCounter$kotlinx_coroutines_core()) goto L60;
        r13.cleanPrev();
    L60:
        return ChannelResult.Companion.m3035closedJP2dKIU(getSendException());
    L34:
        throw new IllegalStateException("unexpected".toString());
    L35:
        if (r11 == false) goto L39;
        r13.onSlotCleaned();
        goto L60
    L39:
        if ((r8 instanceof Waiter) == false) goto L41;
        Waiter r10 = (Waiter) r8;
    L42:
        if (r10 == null) goto L44;
        access$prepareSenderForSuspension(this, r10, r13, r12);
    L44:
        r13.onSlotCleaned();
        return ChannelResult.Companion.m3036failurePtdJZtk();
    L41:
        r10 = null;
    L47:
        return ChannelResult.Companion.m3037successJP2dKIU(Unit.INSTANCE);
    L45:
        r13.cleanPrev();
        goto L47
    L11:
        if (r11 == false) goto L7;
    L14:
        r13 = r0;
        goto L15
    L5:
        return ChannelResult.Companion.m3036failurePtdJZtk();
    }

    public static /* synthetic */ Object sendImpl$default(BufferedChannel r16, Object r17, Object r18, Function0 r19, Function2 r20, Function0 r21, Function4 r22, int r23, Object r24) {
        if (r24 != null) goto L56;
        if ((r23 & 32) == 0) goto L7;
        Function4 r10 = C03721.INSTANCE;
    L8:
        ChannelSegment r0 = (ChannelSegment) access$getSendSegment$FU$p().get(r16);
    L9:
        long r1 = access$getSendersAndCloseStatus$FU$p().getAndIncrement(r16);
        long r11 = r1 & 1152921504606846975L;
        boolean r13 = access$isClosedForSend0(r16, r1);
        long r2 = r11 / ((long) BufferedChannelKt.SEGMENT_SIZE);
        int r14 = (int) (r11 % ((long) BufferedChannelKt.SEGMENT_SIZE));
        if (r0.id == r2) goto L17;
        ChannelSegment r3 = access$findSegmentSend(r16, r2, r0);
        if (r3 == null) goto L13;
        ChannelSegment r15 = r3;
    L18:
        int r4 = access$updateCellSend(r16, r15, r14, r17, r11, r18, r13);
        if (r4 == 0) goto L53;
        if (r4 == 1) goto L52;
        if (r4 == 2) goto L40;
        if (r4 == 3) goto L39;
        if (r4 == 4) goto L34;
        if (r4 != 5) goto L32;
        r15.cleanPrev();
    L32:
        r0 = r15;
        goto L9
    L34:
        if (r11 >= r16.getReceiversCounter$kotlinx_coroutines_core()) goto L37;
        r15.cleanPrev();
    L37:
        return r21.invoke();
    L39:
        return r10.invoke(r15, Integer.valueOf(r14), r17, Long.valueOf(r11));
    L40:
        if (r13 == false) goto L44;
        r15.onSlotCleaned();
        return r21.invoke();
    L44:
        if ((r18 instanceof Waiter) == false) goto L46;
        Waiter r5 = (Waiter) r18;
    L47:
        if (r5 == null) goto L50;
        access$prepareSenderForSuspension(r16, r5, r15, r14);
    L50:
        return r20.invoke(r15, Integer.valueOf(r14));
    L46:
        r5 = null;
        goto L47
    L52:
        return r19.invoke();
    L53:
        r15.cleanPrev();
        return r19.invoke();
    L13:
        if (r13 == false) goto L9;
        return r21.invoke();
    L17:
        r15 = r0;
        goto L18
    L7:
        r10 = r22;
        goto L8
    L56:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendImpl");
    }

    protected final <R> R sendImpl(E r16, Object r17, Function0<? extends R> r18, Function2<? super ChannelSegment<E>, ? super Integer, ? extends R> r19, Function0<? extends R> r20, Function4<? super ChannelSegment<E>, ? super Integer, ? super E, ? super Long, ? extends R> r21) {
        ChannelSegment r0 = (ChannelSegment) access$getSendSegment$FU$p().get(this);
    L3:
        long r1 = access$getSendersAndCloseStatus$FU$p().getAndIncrement(this);
        long r10 = r1 & 1152921504606846975L;
        boolean r12 = access$isClosedForSend0(this, r1);
        long r2 = r10 / ((long) BufferedChannelKt.SEGMENT_SIZE);
        int r13 = (int) (r10 % ((long) BufferedChannelKt.SEGMENT_SIZE));
        if (r0.id == r2) goto L11;
        ChannelSegment r3 = access$findSegmentSend(this, r2, r0);
        if (r3 == null) goto L7;
        ChannelSegment r14 = r3;
    L12:
        int r4 = access$updateCellSend(this, r14, r13, r16, r10, r17, r12);
        if (r4 == 0) goto L47;
        if (r4 == 1) goto L46;
        if (r4 == 2) goto L34;
        if (r4 == 3) goto L33;
        if (r4 == 4) goto L28;
        if (r4 != 5) goto L26;
        r14.cleanPrev();
    L26:
        r0 = r14;
        goto L3
    L28:
        if (r10 >= getReceiversCounter$kotlinx_coroutines_core()) goto L31;
        r14.cleanPrev();
    L31:
        return r20.invoke();
    L33:
        return r21.invoke(r14, Integer.valueOf(r13), r16, Long.valueOf(r10));
    L34:
        if (r12 == false) goto L38;
        r14.onSlotCleaned();
        return r20.invoke();
    L38:
        if ((r17 instanceof Waiter) == false) goto L40;
        Waiter r5 = (Waiter) r17;
    L41:
        if (r5 == null) goto L44;
        access$prepareSenderForSuspension(this, r5, r14, r13);
    L44:
        return r19.invoke(r14, Integer.valueOf(r13));
    L40:
        r5 = null;
        goto L41
    L46:
        return r18.invoke();
    L47:
        r14.cleanPrev();
        return r18.invoke();
    L7:
        if (r12 == false) goto L3;
        return r20.invoke();
    L11:
        r14 = r0;
        goto L12
    }

    private final void sendImplOnNoWaiter(ChannelSegment<E> r20, int r21, E r22, long r23, Waiter r25, Function0<Unit> r26, Function0<Unit> r27) {
        Waiter r9 = r25;
        int r0 = access$updateCellSend(this, r20, r21, r22, r23, r25, false);
        if (r0 != 0) goto L5;
        r20.cleanPrev();
        r26.invoke();
        return;
    L5:
        if (r0 != 1) goto L7;
        r26.invoke();
        return;
    L7:
        if (r0 != 2) goto L9;
        access$prepareSenderForSuspension(this, r9, r20, r21);
        return;
    L9:
        if (r0 == 4) goto L52;
        if (r0 != 5) goto L50;
        r20.cleanPrev();
        ChannelSegment r1 = (ChannelSegment) access$getSendSegment$FU$p().get(this);
    L13:
        long r2 = access$getSendersAndCloseStatus$FU$p().getAndIncrement(this);
        long r15 = r2 & 1152921504606846975L;
        boolean r17 = access$isClosedForSend0(this, r2);
        long r3 = r15 / ((long) BufferedChannelKt.SEGMENT_SIZE);
        int r7 = (int) (r15 % ((long) BufferedChannelKt.SEGMENT_SIZE));
        if (r1.id == r3) goto L20;
        ChannelSegment r4 = access$findSegmentSend(this, r3, r1);
        if (r4 == null) goto L17;
        ChannelSegment r6 = r4;
    L21:
        ChannelSegment r24 = r6;
        int r5 = access$updateCellSend(this, r6, r7, r22, r15, r25, r17);
        if (r5 == 0) goto L48;
        if (r5 == 1) goto L47;
        if (r5 == 2) goto L38;
        if (r5 == 3) goto L37;
        if (r5 == 4) goto L33;
        if (r5 != 5) goto L31;
        r24.cleanPrev();
    L31:
        r1 = r24;
        goto L13
    L33:
        if (r15 >= getReceiversCounter$kotlinx_coroutines_core()) goto L35;
        r24.cleanPrev();
    L35:
        r27.invoke();
        return;
    L37:
        throw new IllegalStateException("unexpected".toString());
    L38:
        if (r17 == false) goto L41;
        r24.onSlotCleaned();
        r27.invoke();
        return;
    L41:
        if ((r9 instanceof Waiter) == true) goto L44;
        r9 = null;
    L44:
        if (r9 == null) goto L46;
        access$prepareSenderForSuspension(this, r9, r24, r7);
    L46:
        Unit r8 = Unit.INSTANCE;
        return;
    L47:
        r26.invoke();
        return;
    L48:
        r24.cleanPrev();
        r26.invoke();
        return;
    L17:
        if (r17 == false) goto L13;
        r27.invoke();
        return;
    L20:
        r6 = r1;
        goto L21
    L50:
        throw new IllegalStateException("unexpected".toString());
    L52:
        if (r23 >= getReceiversCounter$kotlinx_coroutines_core()) goto L54;
        r20.cleanPrev();
    L54:
        r27.invoke();
    }

    private final int updateCellSend(ChannelSegment<E> r4, int r5, E r6, long r7, Object r9, boolean r10) {
        r4.storeElement$kotlinx_coroutines_core(r5, r6);
        if (r10 == true) goto L5;
        Object r0 = r4.getState$kotlinx_coroutines_core(r5);
        if (r0 != null) goto L21;
        if (bufferOrRendezvousSend(r7) == true) goto L11;
        if (r9 != null) goto L17;
        return 3;
    L17:
        if (r4.casState$kotlinx_coroutines_core(r5, null, r9) == false) goto L31;
        return 2;
    L31:
        return updateCellSendSlow(r4, r5, r6, r7, r9, r10);
    L11:
        if (r4.casState$kotlinx_coroutines_core(r5, null, BufferedChannelKt.BUFFERED) == false) goto L31;
        return 1;
    L21:
        if ((r0 instanceof Waiter) == false) goto L31;
        r4.cleanElement$kotlinx_coroutines_core(r5);
        if (tryResumeReceiver(r0, r6) == false) goto L26;
        r4.setState$kotlinx_coroutines_core(r5, BufferedChannelKt.access$getDONE_RCV$p());
        onReceiveDequeued();
        return 0;
    L26:
        if (r4.getAndSetState$kotlinx_coroutines_core(r5, BufferedChannelKt.access$getINTERRUPTED_RCV$p()) == BufferedChannelKt.access$getINTERRUPTED_RCV$p()) goto L28;
        r4.onCancelledRequest(r5, true);
    L28:
        return 5;
    L5:
        return updateCellSendSlow(r4, r5, r6, r7, r9, r10);
    }

    private final int updateCellSendSlow(ChannelSegment<E> r6, int r7, E r8, long r9, Object r11, boolean r12) {
    L2:
        Object r0 = r6.getState$kotlinx_coroutines_core(r7);
        if (r0 == null) goto L5;
        if (r0 != BufferedChannelKt.access$getIN_BUFFER$p()) goto L28;
        if (r6.casState$kotlinx_coroutines_core(r7, r0, BufferedChannelKt.BUFFERED) == false) goto L2;
        return 1;
    L28:
        if (r0 != BufferedChannelKt.access$getINTERRUPTED_RCV$p()) goto L32;
        r6.cleanElement$kotlinx_coroutines_core(r7);
        return 5;
    L32:
        if (r0 != BufferedChannelKt.access$getPOISONED$p()) goto L36;
        r6.cleanElement$kotlinx_coroutines_core(r7);
        return 5;
    L36:
        if (r0 != BufferedChannelKt.getCHANNEL_CLOSED()) goto L40;
        r6.cleanElement$kotlinx_coroutines_core(r7);
        completeCloseOrCancel();
        return 4;
    L40:
        if (DebugKt.getASSERTIONS_ENABLED() == true) goto L42;
    L52:
        r6.cleanElement$kotlinx_coroutines_core(r7);
        if ((r0 instanceof WaiterEB) == false) goto L56;
        r0 = ((WaiterEB) r0).waiter;
    L56:
        if (tryResumeReceiver(r0, r8) == false) goto L59;
        r6.setState$kotlinx_coroutines_core(r7, BufferedChannelKt.access$getDONE_RCV$p());
        onReceiveDequeued();
        return 0;
    L59:
        if (r6.getAndSetState$kotlinx_coroutines_core(r7, BufferedChannelKt.access$getINTERRUPTED_RCV$p()) == BufferedChannelKt.access$getINTERRUPTED_RCV$p()) goto L62;
        r6.onCancelledRequest(r7, true);
    L62:
        return 5;
    L42:
        if ((r0 instanceof Waiter) == false) goto L44;
    L47:
        boolean r10 = true;
    L48:
        if (r10 == true) goto L52;
        throw new AssertionError();
    L44:
        if ((r0 instanceof WaiterEB) == true) goto L47;
        r10 = false;
        goto L48
    L5:
        if (bufferOrRendezvousSend(r9) == false) goto L10;
        if (r12 == true) goto L10;
        if (r6.casState$kotlinx_coroutines_core(r7, null, BufferedChannelKt.BUFFERED) == false) goto L2;
        return 1;
    L10:
        if (r12 == true) goto L12;
        if (r11 == null) goto L16;
        if (r6.casState$kotlinx_coroutines_core(r7, null, r11) == false) goto L2;
        return 2;
    L16:
        return 3;
    L12:
        if (r6.casState$kotlinx_coroutines_core(r7, null, BufferedChannelKt.access$getINTERRUPTED_SEND$p()) == false) goto L2;
        r6.onCancelledRequest(r7, false);
        return 4;
    }

    private final boolean shouldSendSuspend(long r3) {
        if (isClosedForSend0(r3) == false) goto L7;
        return false;
    L7:
        return !bufferOrRendezvousSend(r3 & 1152921504606846975L);
    }

    private final boolean bufferOrRendezvousSend(long r5) {
        if (r5 >= getBufferEndCounter()) goto L5;
    L8:
        return true;
    L5:
        if (r5 < (getReceiversCounter$kotlinx_coroutines_core() + ((long) this.capacity))) goto L8;
        return false;
    }

    public boolean shouldSendSuspend$kotlinx_coroutines_core() {
        return shouldSendSuspend(sendersAndCloseStatus$FU.get(this));
    }

    private final boolean tryResumeReceiver(Object r4, E r5) {
        if ((r4 instanceof SelectInstance) == true) goto L23;
        Function1<Throwable, Unit> r1 = null;
        if ((r4 instanceof ReceiveCatching) == false) goto L12;
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveCatching<E of kotlinx.coroutines.channels.BufferedChannel>");
        ReceiveCatching r6 = (ReceiveCatching) r4;
        CancellableContinuationImpl<ChannelResult<? extends E>> r0 = r6.cont;
        ChannelResult r2 = ChannelResult.m3022boximpl(ChannelResult.Companion.m3037successJP2dKIU(r5));
        Function1<E, Unit> r3 = this.onUndeliveredElement;
        if (r3 == null) goto L24;
        r1 = OnUndeliveredElementKt.bindCancellationFun(r3, r5, r6.cont.getContext());
    L24:
        return BufferedChannelKt.access$tryResume0(r0, r2, r1);
    L12:
        if ((r4 instanceof BufferedChannelIterator) == false) goto L15;
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type kotlinx.coroutines.channels.BufferedChannel.BufferedChannelIterator<E of kotlinx.coroutines.channels.BufferedChannel>");
        return ((BufferedChannelIterator) r4).tryResumeHasNext(r5);
    L15:
        if ((r4 instanceof CancellableContinuation) == false) goto L22;
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<E of kotlinx.coroutines.channels.BufferedChannel>");
        CancellableContinuation r7 = (CancellableContinuation) r4;
        Function1<E, Unit> r8 = this.onUndeliveredElement;
        if (r8 == null) goto L20;
        r1 = OnUndeliveredElementKt.bindCancellationFun(r8, r5, r7.getContext());
    L20:
        return BufferedChannelKt.access$tryResume0(r7, r5, r1);
    L22:
        throw new IllegalStateException(("Unexpected receiver type: " + r4).toString());
    L23:
        return ((SelectInstance) r4).trySelect(this, r5);
    }

    static /* synthetic */ <E> Object receive$suspendImpl(BufferedChannel<E> r13, Continuation<? super E> r14) {
        ChannelSegment<E> r0 = (ChannelSegment) access$getReceiveSegment$FU$p().get(r13);
    L4:
        if (r13.isClosedForReceive() == true) goto L29;
        long r10 = access$getReceivers$FU$p().getAndIncrement(r13);
        long r1 = r10 / ((long) BufferedChannelKt.SEGMENT_SIZE);
        int r9 = (int) (r10 % ((long) BufferedChannelKt.SEGMENT_SIZE));
        if (r0.id == r1) goto L11;
        ChannelSegment<E> r2 = access$findSegmentReceive(r13, r1, r0);
        if (r2 == null) goto L4;
        ChannelSegment<E> r8 = r2;
    L12:
        Object r3 = access$updateCellReceive(r13, r8, r9, r10, null);
        if (r3 == BufferedChannelKt.access$getSUSPEND$p()) goto L27;
        if (r3 != BufferedChannelKt.access$getFAILED$p()) goto L21;
        if (r10 >= r13.getSendersCounter$kotlinx_coroutines_core()) goto L19;
        r8.cleanPrev();
    L19:
        r0 = r8;
        goto L4
    L21:
        if (r3 == BufferedChannelKt.access$getSUSPEND_NO_WAITER$p()) goto L23;
        r8.cleanPrev();
        return r3;
    L23:
        return r13.receiveOnNoWaiterSuspend(r8, r9, r10, r14);
    L27:
        throw new IllegalStateException("unexpected".toString());
    L11:
        r8 = r0;
        goto L12
    L29:
        throw StackTraceRecoveryKt.recoverStackTrace(r13.getReceiveException());
    }

    private final void prepareReceiverForSuspension(Waiter r1, ChannelSegment<E> r2, int r3) {
        onReceiveEnqueued();
        r1.invokeOnCancellation(r2, r3);
    }

    private final void onClosedReceiveOnNoWaiterSuspend(CancellableContinuation<? super E> r2) {
        Result.Companion r0 = Result.Companion;
        r2.resumeWith(Result.m1508constructorimpl(ResultKt.createFailure(getReceiveException())));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: receiveCatching-JP2dKIU$suspendImpl, reason: not valid java name */
    static /* synthetic */ <E> Object m3014receiveCatchingJP2dKIU$suspendImpl(BufferedChannel<E> r14, Continuation<? super ChannelResult<? extends E>> r15) {
        if ((r15 instanceof BufferedChannel$receiveCatching$1) == false) goto L7;
        BufferedChannel$receiveCatching$1 r0 = (BufferedChannel$receiveCatching$1) r15;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        BufferedChannel$receiveCatching$1 r6 = r0;
        Object r16 = r6.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r6.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        ResultKt.throwOnFailure(r16);
        return ((ChannelResult) r16).m3034unboximpl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r16);
        ChannelSegment<E> r3 = (ChannelSegment) access$getReceiveSegment$FU$p().get(r14);
    L16:
        if (r14.isClosedForReceive() == true) goto L51;
        long r4 = access$getReceivers$FU$p().getAndIncrement(r14);
        long r7 = r4 / ((long) BufferedChannelKt.SEGMENT_SIZE);
        int r5 = (int) (r4 % ((long) BufferedChannelKt.SEGMENT_SIZE));
        if (r3.id == r7) goto L24;
        ChannelSegment<E> r8 = access$findSegmentReceive(r14, r7, r3);
        if (r8 == null) goto L16;
        ChannelSegment<E> r13 = r8;
    L25:
        Object r9 = access$updateCellReceive(r14, r13, r5, r4, null);
        if (r9 == BufferedChannelKt.access$getSUSPEND$p()) goto L41;
        if (r9 != BufferedChannelKt.access$getFAILED$p()) goto L34;
        if (r4 >= r14.getSendersCounter$kotlinx_coroutines_core()) goto L32;
        r13.cleanPrev();
    L32:
        r3 = r13;
        goto L16
    L34:
        if (r9 != BufferedChannelKt.access$getSUSPEND_NO_WAITER$p()) goto L38;
        r6.label = 1;
        Object r17 = r14.m3015receiveCatchingOnNoWaiterSuspendGKJJFZk(r13, r5, r4, r6);
        if (r17 != r1) goto L52;
        return r1;
    L52:
        return r17;
    L38:
        r13.cleanPrev();
        return ChannelResult.Companion.m3037successJP2dKIU(r9);
    L41:
        throw new IllegalStateException("unexpected".toString());
    L24:
        r13 = r3;
        goto L25
    L51:
        return ChannelResult.Companion.m3035closedJP2dKIU(r14.getCloseCause());
    L7:
        r0 = new BufferedChannel$receiveCatching$1(r14, r15);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: receiveCatchingOnNoWaiterSuspend-GKJJFZk, reason: not valid java name */
    private final Object m3015receiveCatchingOnNoWaiterSuspendGKJJFZk(ChannelSegment<E> r17, int r18, long r19, Continuation<? super ChannelResult<? extends E>> r21) {
        if ((r21 instanceof BufferedChannel$receiveCatchingOnNoWaiterSuspend$1) == false) goto L7;
        BufferedChannel$receiveCatchingOnNoWaiterSuspend$1 r2 = (BufferedChannel$receiveCatchingOnNoWaiterSuspend$1) r21;
        if ((r2.label & Integer.MIN_VALUE) == 0) goto L7;
        r2.label -= Integer.MIN_VALUE;
    L8:
        Object r1 = r2.result;
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r2.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        long r4 = r2.J$0;
        int r0 = r2.I$0;
        ChannelSegment r5 = (ChannelSegment) r2.L$1;
        BufferedChannel r6 = (BufferedChannel) r2.L$0;
        ResultKt.throwOnFailure(r1);
    L65:
        return ((ChannelResult) r1).m3034unboximpl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r1);
        r2.L$0 = this;
        r2.L$1 = r17;
        r2.I$0 = r18;
        r2.J$0 = r19;
        r2.label = 1;
        BufferedChannel$receiveCatchingOnNoWaiterSuspend$1 r12 = r2;
        CancellableContinuationImpl r13 = CancellableContinuationKt.getOrCreateCancellableContinuation(IntrinsicsKt.intercepted(r12));
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuationImpl<kotlinx.coroutines.channels.ChannelResult<E of kotlinx.coroutines.channels.BufferedChannel.receiveCatchingOnNoWaiterSuspend_GKJJFZk$lambda$35>>");     // Catch: Throwable -> L66
        ReceiveCatching r14 = new ReceiveCatching(r13);     // Catch: Throwable -> L66
        Object r7 = access$updateCellReceive(this, r17, r18, r19, r14);     // Catch: Throwable -> L66
        if (r7 != BufferedChannelKt.access$getSUSPEND$p()) goto L18;
        access$prepareReceiverForSuspension(this, r14, r17, r18);     // Catch: Throwable -> L66
    L59:
        r1 = r13.getResult();
        if (r1 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L62;
        DebugProbesKt.probeCoroutineSuspended(r12);
    L62:
        if (r1 != r11) goto L65;
        return r11;
    L18:
        Function1<Throwable, Unit> r8 = null;
        r8 = null;
        ReceiveCatching r9 = null;
        if (r7 == BufferedChannelKt.access$getFAILED$p()) goto L21;
        r17.cleanPrev();     // Catch: Throwable -> L66
        ChannelResult r10 = ChannelResult.m3022boximpl(ChannelResult.Companion.m3037successJP2dKIU(r7));     // Catch: Throwable -> L66
        Function1<E, Unit> r15 = this.onUndeliveredElement;     // Catch: Throwable -> L66
        if (r15 != null) goto L57;
    L52:
        r13.resume(r10, r8);     // Catch: Throwable -> L66
        goto L59
    L57:
        r8 = OnUndeliveredElementKt.bindCancellationFun(r15, r7, r13.getContext());     // Catch: Throwable -> L66
        goto L52
    L21:
        if (r19 >= getSendersCounter$kotlinx_coroutines_core()) goto L23;
        r17.cleanPrev();     // Catch: Throwable -> L66
    L23:
        ChannelSegment r16 = (ChannelSegment) access$getReceiveSegment$FU$p().get(this);     // Catch: Throwable -> L66
    L25:
        if (isClosedForReceive() == true) goto L26;
        long r20 = access$getReceivers$FU$p().getAndIncrement(this);     // Catch: Throwable -> L66
        long r22 = r20 / ((long) BufferedChannelKt.SEGMENT_SIZE);     // Catch: Throwable -> L66
        int r23 = (int) (r20 % ((long) BufferedChannelKt.SEGMENT_SIZE));     // Catch: Throwable -> L66
        if (r16.id == r22) goto L33;
        ChannelSegment r24 = access$findSegmentReceive(this, r22, r16);     // Catch: Throwable -> L66
        if (r24 == null) goto L25;
        ChannelSegment r110 = r24;
    L34:
        Object r25 = access$updateCellReceive(this, r110, r23, r20, r14);     // Catch: Throwable -> L66
        if (r25 == BufferedChannelKt.access$getSUSPEND$p()) goto L37;
        if (r25 != BufferedChannelKt.access$getFAILED$p()) goto L48;
        if (r20 >= getSendersCounter$kotlinx_coroutines_core()) goto L46;
        r110.cleanPrev();     // Catch: Throwable -> L66
    L46:
        r16 = r110;
        goto L25
    L48:
        if (r25 == BufferedChannelKt.access$getSUSPEND_NO_WAITER$p()) goto L54;
        r110.cleanPrev();     // Catch: Throwable -> L66
        r10 = ChannelResult.m3022boximpl(ChannelResult.Companion.m3037successJP2dKIU(r25));     // Catch: Throwable -> L66
        Function1<E, Unit> r26 = this.onUndeliveredElement;     // Catch: Throwable -> L66
        if (r26 == null) goto L52;
        r8 = OnUndeliveredElementKt.bindCancellationFun(r26, r25, r13.getContext());     // Catch: Throwable -> L66
        goto L52
    L54:
        throw new IllegalStateException("unexpected".toString());     // Catch: Throwable -> L66
    L37:
        if ((r14 instanceof Waiter) == false) goto L39;
        r9 = r14;     // Catch: Throwable -> L66
    L39:
        if (r9 == null) goto L59;
        access$prepareReceiverForSuspension(this, r9, r110, r23);     // Catch: Throwable -> L66
        goto L59
    L33:
        r110 = r16;
        goto L34
    L26:
        access$onClosedReceiveCatchingOnNoWaiterSuspend(this, r13);     // Catch: Throwable -> L66
    L66:
        th = move-exception;
        r13.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
        throw th;
    L7:
        r2 = new BufferedChannel$receiveCatchingOnNoWaiterSuspend$1(this, r21);
        goto L8
    }

    private final void onClosedReceiveCatchingOnNoWaiterSuspend(CancellableContinuation<? super ChannelResult<? extends E>> r2) {
        Result.Companion r0 = Result.Companion;
        r2.resumeWith(Result.m1508constructorimpl(ChannelResult.m3022boximpl(ChannelResult.Companion.m3035closedJP2dKIU(getCloseCause()))));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.channels.ReceiveChannel
    /* JADX INFO: renamed from: tryReceive-PtdJZtk, reason: not valid java name */
    public Object mo3017tryReceivePtdJZtk() {
        long r0 = receivers$FU.get(this);
        long r2 = sendersAndCloseStatus$FU.get(this);
        if (isClosedForReceive0(r2) == false) goto L7;
        return ChannelResult.Companion.m3035closedJP2dKIU(getCloseCause());
    L7:
        if (r0 >= (r2 & 1152921504606846975L)) goto L9;
        Object r6 = BufferedChannelKt.access$getINTERRUPTED_RCV$p();
        ChannelSegment r1 = (ChannelSegment) access$getReceiveSegment$FU$p().get(this);
    L12:
        if (isClosedForReceive() == true) goto L50;
        long r7 = access$getReceivers$FU$p().getAndIncrement(this);
        long r3 = r7 / ((long) BufferedChannelKt.SEGMENT_SIZE);
        int r9 = (int) (r7 % ((long) BufferedChannelKt.SEGMENT_SIZE));
        if (r1.id == r3) goto L20;
        ChannelSegment r4 = access$findSegmentReceive(this, r3, r1);
        if (r4 == null) goto L12;
        ChannelSegment r10 = r4;
    L21:
        Object r5 = access$updateCellReceive(this, r10, r9, r7, r6);
        if (r5 == BufferedChannelKt.access$getSUSPEND$p()) goto L24;
        if (r5 != BufferedChannelKt.access$getFAILED$p()) goto L37;
        if (r7 >= getSendersCounter$kotlinx_coroutines_core()) goto L35;
        r10.cleanPrev();
    L35:
        r1 = r10;
        goto L12
    L37:
        if (r5 == BufferedChannelKt.access$getSUSPEND_NO_WAITER$p()) goto L41;
        r10.cleanPrev();
        return ChannelResult.Companion.m3037successJP2dKIU(r5);
    L41:
        throw new IllegalStateException("unexpected".toString());
    L24:
        if ((r6 instanceof Waiter) == false) goto L26;
        Waiter r8 = (Waiter) r6;
    L27:
        if (r8 == null) goto L29;
        access$prepareReceiverForSuspension(this, r8, r10, r9);
    L29:
        waitExpandBufferCompletion$kotlinx_coroutines_core(r7);
        r10.onSlotCleaned();
        return ChannelResult.Companion.m3036failurePtdJZtk();
    L26:
        r8 = null;
        goto L27
    L20:
        r10 = r1;
        goto L21
    L50:
        return ChannelResult.Companion.m3035closedJP2dKIU(getCloseCause());
    L9:
        return ChannelResult.Companion.m3036failurePtdJZtk();
    }

    protected final void dropFirstElementUntilTheSpecifiedCellIsInTheBuffer(long r11) {
        if (DebugKt.getASSERTIONS_ENABLED() == true) goto L5;
    L9:
        ChannelSegment<E> r0 = (ChannelSegment) receiveSegment$FU.get(this);
    L10:
        AtomicLongFieldUpdater r1 = receivers$FU;
        long r8 = r1.get(this);
        if (r11 < Math.max(((long) this.capacity) + r8, getBufferEndCounter())) goto L12;
        if (r1.compareAndSet(this, r8, r8 + 1) == false) goto L10;
        long r2 = r8 / ((long) BufferedChannelKt.SEGMENT_SIZE);
        int r4 = (int) (r8 % ((long) BufferedChannelKt.SEGMENT_SIZE));
        if (r0.id == r2) goto L21;
        ChannelSegment<E> r3 = findSegmentReceive(r2, r0);
        if (r3 == null) goto L10;
        r0 = r3;
    L21:
        Object r5 = updateCellReceive(r0, r4, r8, null);
        if (r5 == BufferedChannelKt.access$getFAILED$p()) goto L24;
        r0.cleanPrev();
        Function1<E, Unit> r6 = this.onUndeliveredElement;
        if (r6 == null) goto L10;
        UndeliveredElementException r7 = OnUndeliveredElementKt.callUndeliveredElementCatchingException$default(r6, r5, null, 2, null);
        if (r7 == null) goto L10;
        throw r7;
    L24:
        if (r8 >= getSendersCounter$kotlinx_coroutines_core()) goto L10;
        r0.cleanPrev();
        goto L10
    L12:
        return;
    L5:
        if (isConflatedDropOldest() == true) goto L9;
        throw new AssertionError();
    }

    static /* synthetic */ Object receiveImpl$default(BufferedChannel r8, Object r9, Function1 r10, Function3 r11, Function0 r12, AnonymousClass1 r13, int r14, Object r15) {
        if (r15 != null) goto L37;
        if ((r14 & 16) == 0) goto L6;
        r13 = AnonymousClass1.INSTANCE;
    L6:
        ChannelSegment r16 = (ChannelSegment) access$getReceiveSegment$FU$p().get(r8);
    L8:
        if (r8.isClosedForReceive() == true) goto L10;
        long r6 = access$getReceivers$FU$p().getAndIncrement(r8);
        long r0 = r6 / ((long) BufferedChannelKt.SEGMENT_SIZE);
        int r17 = (int) (r6 % ((long) BufferedChannelKt.SEGMENT_SIZE));
        if (r16.id == r0) goto L17;
        ChannelSegment r1 = access$findSegmentReceive(r8, r0, r16);
        if (r1 == null) goto L8;
        r16 = r1;
    L17:
        Object r2 = access$updateCellReceive(r8, r16, r17, r6, r9);
        if (r2 == BufferedChannelKt.access$getSUSPEND$p()) goto L20;
        if (r2 != BufferedChannelKt.access$getFAILED$p()) goto L32;
        if (r6 >= r8.getSendersCounter$kotlinx_coroutines_core()) goto L8;
        r16.cleanPrev();
        goto L8
    L32:
        if (r2 == BufferedChannelKt.access$getSUSPEND_NO_WAITER$p()) goto L49;
        r16.cleanPrev();
        return r10.invoke(r2);
    L49:
        return r13.invoke(r16, Integer.valueOf(r17), Long.valueOf(r6));
    L20:
        if ((r9 instanceof Waiter) == false) goto L22;
        Waiter r18 = (Waiter) r9;
    L23:
        if (r18 == null) goto L48;
        access$prepareReceiverForSuspension(r8, r18, r16, r17);
    L48:
        return r11.invoke(r16, Integer.valueOf(r17), Long.valueOf(r6));
    L22:
        r18 = null;
        goto L23
    L10:
        return r12.invoke();
    L37:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: receiveImpl");
    }

    private final <R> R receiveImpl(Object r13, Function1<? super E, ? extends R> r14, Function3<? super ChannelSegment<E>, ? super Integer, ? super Long, ? extends R> r15, Function0<? extends R> r16, Function3<? super ChannelSegment<E>, ? super Integer, ? super Long, ? extends R> r17) {
        ChannelSegment r0 = (ChannelSegment) access$getReceiveSegment$FU$p().get(this);
    L4:
        if (isClosedForReceive() == true) goto L6;
        long r8 = access$getReceivers$FU$p().getAndIncrement(this);
        long r1 = r8 / ((long) BufferedChannelKt.SEGMENT_SIZE);
        int r10 = (int) (r8 % ((long) BufferedChannelKt.SEGMENT_SIZE));
        if (r0.id == r1) goto L13;
        ChannelSegment r2 = access$findSegmentReceive(this, r1, r0);
        if (r2 == null) goto L4;
        ChannelSegment r11 = r2;
    L14:
        Symbol r3 = (Object) access$updateCellReceive(this, r11, r10, r8, r13);
        if (r3 == BufferedChannelKt.access$getSUSPEND$p()) goto L17;
        if (r3 != BufferedChannelKt.access$getFAILED$p()) goto L30;
        if (r8 >= getSendersCounter$kotlinx_coroutines_core()) goto L28;
        r11.cleanPrev();
    L28:
        r0 = r11;
        goto L4
    L30:
        if (r3 == BufferedChannelKt.access$getSUSPEND_NO_WAITER$p()) goto L43;
        r11.cleanPrev();
        return r14.invoke(r3);
    L43:
        return r17.invoke(r11, Integer.valueOf(r10), Long.valueOf(r8));
    L17:
        if ((r13 instanceof Waiter) == false) goto L19;
        Waiter r4 = (Waiter) r13;
    L20:
        if (r4 == null) goto L42;
        access$prepareReceiverForSuspension(this, r4, r11, r10);
    L42:
        return r15.invoke(r11, Integer.valueOf(r10), Long.valueOf(r8));
    L19:
        r4 = null;
        goto L20
    L13:
        r11 = r0;
        goto L14
    L6:
        return r16.invoke();
    }

    private final void receiveImplOnNoWaiter(ChannelSegment<E> r7, int r8, long r9, Waiter r11, Function1<? super E, Unit> r12, Function0<Unit> r13) {
        Symbol r0 = (Object) access$updateCellReceive(this, r7, r8, r9, r11);
        if (r0 != BufferedChannelKt.access$getSUSPEND$p()) goto L6;
        access$prepareReceiverForSuspension(this, r11, r7, r8);
        return;
    L6:
        if (r0 == BufferedChannelKt.access$getFAILED$p()) goto L8;
        r7.cleanPrev();
        r12.invoke(r0);
        return;
    L8:
        if (r9 >= getSendersCounter$kotlinx_coroutines_core()) goto L10;
        r7.cleanPrev();
    L10:
        ChannelSegment r10 = (ChannelSegment) access$getReceiveSegment$FU$p().get(this);
    L12:
        if (isClosedForReceive() == true) goto L13;
        long r14 = access$getReceivers$FU$p().getAndIncrement(this);
        long r1 = r14 / ((long) BufferedChannelKt.SEGMENT_SIZE);
        int r15 = (int) (r14 % ((long) BufferedChannelKt.SEGMENT_SIZE));
        if (r10.id == r1) goto L20;
        ChannelSegment r2 = access$findSegmentReceive(this, r1, r10);
        if (r2 == null) goto L12;
        r10 = r2;
    L20:
        Symbol r3 = (Object) access$updateCellReceive(this, r10, r15, r14, r11);
        if (r3 == BufferedChannelKt.access$getSUSPEND$p()) goto L23;
        if (r3 != BufferedChannelKt.access$getFAILED$p()) goto L35;
        if (r14 >= getSendersCounter$kotlinx_coroutines_core()) goto L12;
        r10.cleanPrev();
        goto L12
    L35:
        if (r3 == BufferedChannelKt.access$getSUSPEND_NO_WAITER$p()) goto L38;
        r10.cleanPrev();
        r12.invoke(r3);
        return;
    L38:
        throw new IllegalStateException("unexpected".toString());
    L23:
        if ((r11 instanceof Waiter) == true) goto L26;
        r11 = null;
    L26:
        if (r11 == null) goto L28;
        access$prepareReceiverForSuspension(this, r11, r10, r15);
    L28:
        Unit r6 = Unit.INSTANCE;
        return;
    L13:
        r13.invoke();
    }

    private final Object updateCellReceive(ChannelSegment<E> r6, int r7, long r8, Object r10) {
        Object r0 = r6.getState$kotlinx_coroutines_core(r7);
        if (r0 != null) goto L14;
        if (r8 < (sendersAndCloseStatus$FU.get(this) & 1152921504606846975L)) goto L20;
        if (r10 != null) goto L10;
        return BufferedChannelKt.access$getSUSPEND_NO_WAITER$p();
    L10:
        if (r6.casState$kotlinx_coroutines_core(r7, r0, r10) == false) goto L20;
        expandBuffer();
        return BufferedChannelKt.access$getSUSPEND$p();
    L20:
        return updateCellReceiveSlow(r6, r7, r8, r10);
    L14:
        if (r0 != BufferedChannelKt.BUFFERED) goto L20;
        if (r6.casState$kotlinx_coroutines_core(r7, r0, BufferedChannelKt.access$getDONE_RCV$p()) == false) goto L20;
        expandBuffer();
        return r6.retrieveElement$kotlinx_coroutines_core(r7);
    }

    private final Object updateCellReceiveSlow(ChannelSegment<E> r6, int r7, long r8, Object r10) {
    L2:
        Object r0 = r6.getState$kotlinx_coroutines_core(r7);
        if (r0 == null) goto L41;
        if (r0 == BufferedChannelKt.access$getIN_BUFFER$p()) goto L41;
        if (r0 == BufferedChannelKt.BUFFERED) goto L10;
        if (r0 == BufferedChannelKt.access$getINTERRUPTED_SEND$p()) goto L16;
        if (r0 == BufferedChannelKt.access$getPOISONED$p()) goto L20;
        if (r0 == BufferedChannelKt.getCHANNEL_CLOSED()) goto L23;
        if (r0 == BufferedChannelKt.access$getRESUMING_BY_EB$p()) goto L2;
        if (r6.casState$kotlinx_coroutines_core(r7, r0, BufferedChannelKt.access$getRESUMING_BY_RCV$p()) == false) goto L2;
        boolean r9 = r0 instanceof WaiterEB;
        if (r9 == false) goto L33;
        r0 = ((WaiterEB) r0).waiter;
    L33:
        if (tryResumeSender(r0, r6, r7) == false) goto L35;
        r6.setState$kotlinx_coroutines_core(r7, BufferedChannelKt.access$getDONE_RCV$p());
        expandBuffer();
        return r6.retrieveElement$kotlinx_coroutines_core(r7);
    L35:
        r6.setState$kotlinx_coroutines_core(r7, BufferedChannelKt.access$getINTERRUPTED_SEND$p());
        r6.onCancelledRequest(r7, false);
        if (r9 == false) goto L39;
        expandBuffer();
    L39:
        return BufferedChannelKt.access$getFAILED$p();
    L23:
        expandBuffer();
        return BufferedChannelKt.access$getFAILED$p();
    L20:
        return BufferedChannelKt.access$getFAILED$p();
    L16:
        return BufferedChannelKt.access$getFAILED$p();
    L10:
        if (r6.casState$kotlinx_coroutines_core(r7, r0, BufferedChannelKt.access$getDONE_RCV$p()) == false) goto L2;
        expandBuffer();
        return r6.retrieveElement$kotlinx_coroutines_core(r7);
    L41:
        if (r8 < (sendersAndCloseStatus$FU.get(this) & 1152921504606846975L)) goto L43;
        if (r10 == null) goto L48;
        if (r6.casState$kotlinx_coroutines_core(r7, r0, r10) == false) goto L2;
        expandBuffer();
        return BufferedChannelKt.access$getSUSPEND$p();
    L48:
        return BufferedChannelKt.access$getSUSPEND_NO_WAITER$p();
    L43:
        if (r6.casState$kotlinx_coroutines_core(r7, r0, BufferedChannelKt.access$getPOISONED$p()) == false) goto L2;
        expandBuffer();
        return BufferedChannelKt.access$getFAILED$p();
    }

    private final boolean tryResumeSender(Object r5, ChannelSegment<E> r6, int r7) {
        if ((r5 instanceof CancellableContinuation) == false) goto L6;
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
        return BufferedChannelKt.tryResume0$default((CancellableContinuation) r5, Unit.INSTANCE, null, 2, null);
    L6:
        if ((r5 instanceof SelectInstance) == false) goto L15;
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation<*>");
        TrySelectDetailedResult r4 = ((SelectImplementation) r5).trySelectDetailed(this, Unit.INSTANCE);
        if (r4 != TrySelectDetailedResult.REREGISTER) goto L11;
        r6.cleanElement$kotlinx_coroutines_core(r7);
    L11:
        if (r4 == TrySelectDetailedResult.SUCCESSFUL) goto L21;
        return false;
    L21:
        return true;
    L15:
        if ((r5 instanceof SendBroadcast) == false) goto L19;
        return BufferedChannelKt.tryResume0$default(((SendBroadcast) r5).getCont(), true, null, 2, null);
    L19:
        throw new IllegalStateException(("Unexpected waiter: " + r5).toString());
    }

    private final void expandBuffer() {
        if (isRendezvousOrUnlimited() == false) goto L5;
        return;
    L5:
        ChannelSegment<E> r0 = (ChannelSegment) bufferEndSegment$FU.get(this);
    L6:
        long r7 = bufferEnd$FU.getAndIncrement(this);
        long r2 = r7 / ((long) BufferedChannelKt.SEGMENT_SIZE);
        if (getSendersCounter$kotlinx_coroutines_core() <= r7) goto L9;
        if (r0.id == r2) goto L22;
        ChannelSegment<E> r1 = findSegmentBufferEnd(r2, r0, r7);
        if (r1 == null) goto L6;
        r0 = r1;
    L22:
        if (updateCellExpandBuffer(r0, (int) (r7 % ((long) BufferedChannelKt.SEGMENT_SIZE)), r7) == true) goto L23;
        incCompletedExpandBufferAttempts$default(this, 0, 1, null);
        goto L6
    L23:
        incCompletedExpandBufferAttempts$default(this, 0, 1, null);
        return;
    L9:
        if (r0.id < r2) goto L11;
    L13:
        incCompletedExpandBufferAttempts$default(this, 0, 1, null);
        return;
    L11:
        if (r0.getNext() == 0) goto L13;
        moveSegmentBufferEndToSpecifiedOrLast(r2, r0);
        goto L13
    }

    private final boolean updateCellExpandBuffer(ChannelSegment<E> r4, int r5, long r6) {
        Object r0 = r4.getState$kotlinx_coroutines_core(r5);
        if ((r0 instanceof Waiter) == false) goto L14;
        if (r6 < receivers$FU.get(this)) goto L14;
        if (r4.casState$kotlinx_coroutines_core(r5, r0, BufferedChannelKt.access$getRESUMING_BY_EB$p()) == false) goto L14;
        if (tryResumeSender(r0, r4, r5) == false) goto L11;
        r4.setState$kotlinx_coroutines_core(r5, BufferedChannelKt.BUFFERED);
        return true;
    L11:
        r4.setState$kotlinx_coroutines_core(r5, BufferedChannelKt.access$getINTERRUPTED_SEND$p());
        r4.onCancelledRequest(r5, false);
        return false;
    L14:
        return updateCellExpandBufferSlow(r4, r5, r6);
    }

    private final boolean updateCellExpandBufferSlow(ChannelSegment<E> r7, int r8, long r9) {
    L2:
        Object r0 = r7.getState$kotlinx_coroutines_core(r8);
        if ((r0 instanceof Waiter) == true) goto L5;
        if (r0 == BufferedChannelKt.access$getINTERRUPTED_SEND$p()) goto L18;
        if (r0 == null) goto L21;
        if (r0 == BufferedChannelKt.BUFFERED) goto L25;
        if (r0 == BufferedChannelKt.access$getPOISONED$p()) goto L41;
        if (r0 == BufferedChannelKt.access$getDONE_RCV$p()) goto L41;
        if (r0 == BufferedChannelKt.access$getINTERRUPTED_RCV$p()) goto L41;
        if (r0 == BufferedChannelKt.getCHANNEL_CLOSED()) goto L35;
        if (r0 == BufferedChannelKt.access$getRESUMING_BY_RCV$p()) goto L2;
        throw new IllegalStateException(("Unexpected cell state: " + r0).toString());
    L35:
        return true;
    L41:
        return true;
    L25:
        return true;
    L21:
        if (r7.casState$kotlinx_coroutines_core(r8, r0, BufferedChannelKt.access$getIN_BUFFER$p()) == false) goto L2;
        return true;
    L18:
        return false;
    L5:
        if (r9 < receivers$FU.get(this)) goto L7;
        if (r7.casState$kotlinx_coroutines_core(r8, r0, BufferedChannelKt.access$getRESUMING_BY_EB$p()) == false) goto L2;
        if (tryResumeSender(r0, r7, r8) == false) goto L14;
        r7.setState$kotlinx_coroutines_core(r8, BufferedChannelKt.BUFFERED);
        return true;
    L14:
        r7.setState$kotlinx_coroutines_core(r8, BufferedChannelKt.access$getINTERRUPTED_SEND$p());
        r7.onCancelledRequest(r8, false);
        return false;
    L7:
        if (r7.casState$kotlinx_coroutines_core(r8, r0, new WaiterEB((Waiter) r0)) == false) goto L2;
        return true;
    }

    static /* synthetic */ void incCompletedExpandBufferAttempts$default(BufferedChannel r0, long r1, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 1) == 0) goto L6;
        r1 = 1;
    L6:
        r0.incCompletedExpandBufferAttempts(r1);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incCompletedExpandBufferAttempts");
    }

    private final void incCompletedExpandBufferAttempts(long r8) {
        if ((completedExpandBuffersAndPauseFlag$FU.addAndGet(this, r8) & Longs.MAX_POWER_OF_TWO) == 0) goto L5;
        boolean r9 = true;
    L6:
        if (r9 == true) goto L8;
        return;
    L8:
        if ((completedExpandBuffersAndPauseFlag$FU.get(this) & Longs.MAX_POWER_OF_TWO) == 0) goto L10;
        boolean r10 = true;
    L11:
        if (r10 == true) goto L8;
        return;
    L10:
        r10 = false;
        goto L11
    L5:
        r9 = false;
        goto L6
    }

    public final void waitExpandBufferCompletion$kotlinx_coroutines_core(long r14) {
        if (isRendezvousOrUnlimited() == false) goto L6;
        return;
    L6:
        if (getBufferEndCounter() <= r14) goto L6;
        int r15 = BufferedChannelKt.access$getEXPAND_BUFFER_COMPLETION_WAIT_ITERATIONS$p();
        int r16 = 0;
    L9:
        if (r16 >= r15) goto L16;
        long r3 = getBufferEndCounter();
        if (r3 != (DurationKt.MAX_MILLIS & completedExpandBuffersAndPauseFlag$FU.get(this))) goto L15;
        if (r3 != getBufferEndCounter()) goto L15;
        return;
    L15:
        r16 = r16 + 1;
        goto L9
    L16:
        AtomicLongFieldUpdater r9 = completedExpandBuffersAndPauseFlag$FU;
    L17:
        long r5 = r9.get(this);
        if (r9.compareAndSet(this, r5, BufferedChannelKt.access$constructEBCompletedAndPauseFlag(r5 & DurationKt.MAX_MILLIS, true)) == false) goto L17;
    L19:
        long r17 = getBufferEndCounter();
        AtomicLongFieldUpdater r10 = completedExpandBuffersAndPauseFlag$FU;
        long r6 = r10.get(this);
        long r4 = r6 & DurationKt.MAX_MILLIS;
        if ((Longs.MAX_POWER_OF_TWO & r6) == 0) goto L22;
        boolean r7 = true;
    L24:
        if (r17 == r4) goto L26;
    L30:
        if (r7 == true) goto L19;
        r10.compareAndSet(this, r6, BufferedChannelKt.access$constructEBCompletedAndPauseFlag(r4, true));
        goto L19
    L26:
        if (r17 != getBufferEndCounter()) goto L30;
    L27:
        long r8 = r10.get(this);
        if (r10.compareAndSet(this, r8, BufferedChannelKt.access$constructEBCompletedAndPauseFlag(r8 & DurationKt.MAX_MILLIS, false)) == false) goto L27;
        return;
    L22:
        r7 = false;
        goto L24
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public SelectClause2<E, BufferedChannel<E>> getOnSend() {
        BufferedChannel$onSend$1 r0 = BufferedChannel$onSend$1.INSTANCE;
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        Function3 r2 = (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r0, 3);
        BufferedChannel$onSend$2 r1 = BufferedChannel$onSend$2.INSTANCE;
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new SelectClause2Impl(this, r2, (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r1, 3), null, 8, null);
    }

    private final void onClosedSelectOnSend(E r2, SelectInstance<?> r3) {
        Function1<E, Unit> r1 = this.onUndeliveredElement;
        if (r1 == null) goto L5;
        OnUndeliveredElementKt.callUndeliveredElement(r1, r2, r3.getContext());
    L5:
        r3.selectInRegistrationPhase(BufferedChannelKt.getCHANNEL_CLOSED());
    }

    private final Object processResultSelectSend(Object r1, Object r2) {
        if (r2 == BufferedChannelKt.getCHANNEL_CLOSED()) goto L6;
        return this;
    L6:
        throw getSendException();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public SelectClause1<E> getOnReceive() {
        BufferedChannel$onReceive$1 r1 = BufferedChannel$onReceive$1.INSTANCE;
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        Function3 r2 = (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r1, 3);
        BufferedChannel$onReceive$2 r3 = BufferedChannel$onReceive$2.INSTANCE;
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new SelectClause1Impl(this, r2, (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r3, 3), this.onUndeliveredElementReceiveCancellationConstructor);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public SelectClause1<ChannelResult<E>> getOnReceiveCatching() {
        BufferedChannel$onReceiveCatching$1 r1 = BufferedChannel$onReceiveCatching$1.INSTANCE;
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        Function3 r2 = (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r1, 3);
        BufferedChannel$onReceiveCatching$2 r3 = BufferedChannel$onReceiveCatching$2.INSTANCE;
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new SelectClause1Impl(this, r2, (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r3, 3), this.onUndeliveredElementReceiveCancellationConstructor);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public SelectClause1<E> getOnReceiveOrNull() {
        BufferedChannel$onReceiveOrNull$1 r1 = BufferedChannel$onReceiveOrNull$1.INSTANCE;
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        Function3 r2 = (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r1, 3);
        BufferedChannel$onReceiveOrNull$2 r3 = BufferedChannel$onReceiveOrNull$2.INSTANCE;
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new SelectClause1Impl(this, r2, (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r3, 3), this.onUndeliveredElementReceiveCancellationConstructor);
    }

    private final void onClosedSelectOnReceive(SelectInstance<?> r1) {
        r1.selectInRegistrationPhase(BufferedChannelKt.getCHANNEL_CLOSED());
    }

    private final Object processResultSelectReceive(Object r1, Object r2) {
        if (r2 == BufferedChannelKt.getCHANNEL_CLOSED()) goto L6;
        return r2;
    L6:
        throw getReceiveException();
    }

    private final Object processResultSelectReceiveOrNull(Object r1, Object r2) {
        if (r2 == BufferedChannelKt.getCHANNEL_CLOSED()) goto L5;
        return r2;
    L5:
        if (getCloseCause() != null) goto L8;
        return null;
    L8:
        throw getReceiveException();
    }

    private final Object processResultSelectReceiveCatching(Object r1, Object r2) {
        if (r2 != BufferedChannelKt.getCHANNEL_CLOSED()) goto L5;
        Object r0 = ChannelResult.Companion.m3035closedJP2dKIU(getCloseCause());
    L7:
        return ChannelResult.m3022boximpl(r0);
    L5:
        r0 = ChannelResult.Companion.m3037successJP2dKIU(r2);
        goto L7
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public ChannelIterator<E> iterator() {
        return new BufferedChannelIterator(this);
    }

    protected final Throwable getCloseCause() {
        return (Throwable) _closeCause$FU.get(this);
    }

    protected final Throwable getSendException() {
        Throwable r1 = getCloseCause();
        if (r1 == null) goto L5;
        return r1;
    L5:
        return new ClosedSendChannelException(ChannelsKt.DEFAULT_CLOSE_MESSAGE);
    }

    private final Throwable getReceiveException() {
        Throwable r1 = getCloseCause();
        if (r1 == null) goto L5;
        return r1;
    L5:
        return new ClosedReceiveChannelException(ChannelsKt.DEFAULT_CLOSE_MESSAGE);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean close(Throwable r2) {
        return closeOrCancelImpl(r2, false);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final boolean cancel(Throwable r1) {
        return cancelImpl$kotlinx_coroutines_core(r1);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final void cancel() {
        cancelImpl$kotlinx_coroutines_core(null);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final void cancel(CancellationException r1) {
        cancelImpl$kotlinx_coroutines_core(r1);
    }

    public boolean cancelImpl$kotlinx_coroutines_core(CancellationException r2) {
        if (r2 != null) goto L5;
        r2 = new CancellationException("Channel was cancelled");
    L5:
        return closeOrCancelImpl(r2, true);
    }

    protected boolean closeOrCancelImpl(Throwable r3, boolean r4) {
        if (r4 == false) goto L4;
        markCancellationStarted();
    L4:
        boolean r5 = _closeCause$FU.compareAndSet(this, BufferedChannelKt.access$getNO_CLOSE_CAUSE$p(), r3);
        if (r4 == false) goto L7;
        markCancelled();
    L8:
        completeCloseOrCancel();
        onClosedIdempotent();
        if (r5 == false) goto L11;
        invokeCloseHandler();
    L11:
        return r5;
    L7:
        markClosed();
        goto L8
    }

    private final void invokeCloseHandler() {
        AtomicReferenceFieldUpdater r0 = closeHandler$FU;
    L3:
        Object r1 = r0.get(this);
        if (r1 != null) goto L6;
        Symbol r2 = BufferedChannelKt.access$getCLOSE_HANDLER_CLOSED$p();
    L8:
        if (r0.compareAndSet(this, r1, r2) == false) goto L3;
        if (r1 != null) goto L11;
        return;
    L11:
        Function1 r3 = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r1, 1);
        ((Function1) r1).invoke(getCloseCause());
        return;
    L6:
        r2 = BufferedChannelKt.access$getCLOSE_HANDLER_INVOKED$p();
        goto L8
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public void invokeOnClose(Function1<? super Throwable, Unit> r5) {
        AtomicReferenceFieldUpdater r0 = closeHandler$FU;
        if (r0.compareAndSet(this, null, r5) == false) goto L5;
        return;
    L5:
        Object r1 = r0.get(this);
        if (r1 != BufferedChannelKt.access$getCLOSE_HANDLER_CLOSED$p()) goto L12;
        if (closeHandler$FU.compareAndSet(this, BufferedChannelKt.access$getCLOSE_HANDLER_CLOSED$p(), BufferedChannelKt.access$getCLOSE_HANDLER_INVOKED$p()) == false) goto L5;
        r5.invoke(getCloseCause());
        return;
    L12:
        if (r1 != BufferedChannelKt.access$getCLOSE_HANDLER_INVOKED$p()) goto L16;
        throw new IllegalStateException("Another handler was already registered and successfully invoked".toString());
    L16:
        throw new IllegalStateException(("Another handler is already registered: " + r1).toString());
    }

    private final void markClosed() {
        AtomicLongFieldUpdater r6 = sendersAndCloseStatus$FU;
    L3:
        long r2 = r6.get(this);
        int r0 = (int) (r2 >> 60);
        if (r0 != 0) goto L6;
        long r1 = BufferedChannelKt.access$constructSendersAndCloseStatus(r2 & 1152921504606846975L, 2);
    L11:
        if (r6.compareAndSet(this, r2, r1) == false) goto L3;
        return;
    L6:
        if (r0 != 1) goto L7;
        r1 = BufferedChannelKt.access$constructSendersAndCloseStatus(r2 & 1152921504606846975L, 3);
        goto L11
    }

    private final void markCancelled() {
        AtomicLongFieldUpdater r6 = sendersAndCloseStatus$FU;
    L3:
        long r2 = r6.get(this);
        if (r6.compareAndSet(this, r2, BufferedChannelKt.access$constructSendersAndCloseStatus(1152921504606846975L & r2, 3)) == false) goto L3;
    }

    private final void markCancellationStarted() {
        AtomicLongFieldUpdater r6 = sendersAndCloseStatus$FU;
    L3:
        long r2 = r6.get(this);
        if (((int) (r2 >> 60)) != 0) goto L7;
        if (r6.compareAndSet(this, r2, BufferedChannelKt.access$constructSendersAndCloseStatus(1152921504606846975L & r2, 1)) == false) goto L3;
        return;
    }

    private final void completeCloseOrCancel() {
        isClosedForSend();
    }

    private final ChannelSegment<E> completeClose(long r6) {
        ChannelSegment<E> r0 = closeLinkedList();
        if (isConflatedDropOldest() == false) goto L7;
        long r1 = markAllEmptyCellsAsClosed(r0);
        if (r1 == (-1)) goto L7;
        dropFirstElementUntilTheSpecifiedCellIsInTheBuffer(r1);
    L7:
        cancelSuspendedReceiveRequests(r0, r6);
        return r0;
    }

    private final void completeCancel(long r1) {
        removeUnprocessedElements(completeClose(r1));
    }

    private final ChannelSegment<E> closeLinkedList() {
        Object r0 = bufferEndSegment$FU.get(this);
        ChannelSegment r1 = (ChannelSegment) sendSegment$FU.get(this);
        if (r1.id <= ((ChannelSegment) r0).id) goto L5;
        r0 = r1;
    L5:
        ChannelSegment r6 = (ChannelSegment) receiveSegment$FU.get(this);
        if (r6.id <= ((ChannelSegment) r0).id) goto L9;
        r0 = r6;
    L9:
        return (ChannelSegment) ConcurrentLinkedListKt.close((ConcurrentLinkedListNode) r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final long markAllEmptyCellsAsClosed(ChannelSegment<E> r8) {
    L2:
        int r0 = BufferedChannelKt.SEGMENT_SIZE;
    L3:
        r0 = r0 - 1;
        if ((-1) >= r0) goto L20;
        long r3 = (r8.id * ((long) BufferedChannelKt.SEGMENT_SIZE)) + ((long) r0);
        if (r3 < getReceiversCounter$kotlinx_coroutines_core()) goto L7;
    L8:
        Object r1 = r8.getState$kotlinx_coroutines_core(r0);
        if (r1 == null) goto L17;
        if (r1 == BufferedChannelKt.access$getIN_BUFFER$p()) goto L17;
        if (r1 != BufferedChannelKt.BUFFERED) goto L3;
        return r3;
    L17:
        if (r8.casState$kotlinx_coroutines_core(r0, r1, BufferedChannelKt.getCHANNEL_CLOSED()) == false) goto L8;
        r8.onSlotCleaned();
        goto L3
    L7:
        return -1;
    L20:
        r8 = (ChannelSegment) r8.getPrev();
        if (r8 != null) goto L2;
        return -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void removeUnprocessedElements(ChannelSegment<E> r12) {
        Function1<E, Unit> r0 = this.onUndeliveredElement;
        UndeliveredElementException r1 = null;
        Object r3 = InlineList.m3058constructorimpl$default(null, 1, null);
    L3:
        int r4 = BufferedChannelKt.SEGMENT_SIZE - 1;
    L5:
        if ((-1) >= r4) goto L50;
        long r6 = (r12.id * ((long) BufferedChannelKt.SEGMENT_SIZE)) + ((long) r4);
    L7:
        Object r8 = r12.getState$kotlinx_coroutines_core(r4);
        if (r8 == BufferedChannelKt.access$getDONE_RCV$p()) goto L52;
        if (r8 == BufferedChannelKt.BUFFERED) goto L12;
        if (r8 == BufferedChannelKt.access$getIN_BUFFER$p()) goto L47;
        if (r8 == null) goto L47;
        if ((r8 instanceof Waiter) == true) goto L36;
        if ((r8 instanceof WaiterEB) == true) goto L36;
        if (r8 == BufferedChannelKt.access$getRESUMING_BY_EB$p()) goto L52;
        if (r8 == BufferedChannelKt.access$getRESUMING_BY_RCV$p()) goto L52;
        if (r8 == BufferedChannelKt.access$getRESUMING_BY_EB$p()) goto L7;
    L49:
        r4 = r4 - 1;
    L36:
        if (r6 < getReceiversCounter$kotlinx_coroutines_core()) goto L52;
        if ((r8 instanceof WaiterEB) == false) goto L40;
        Waiter r9 = ((WaiterEB) r8).waiter;
    L42:
        if (r12.casState$kotlinx_coroutines_core(r4, r8, BufferedChannelKt.getCHANNEL_CLOSED()) == false) goto L7;
        if (r0 == null) goto L45;
        r1 = OnUndeliveredElementKt.callUndeliveredElementCatchingException(r0, r12.getElement$kotlinx_coroutines_core(r4), r1);
    L45:
        r3 = InlineList.m3063plusFjFbRPM(r3, r9);
        r12.cleanElement$kotlinx_coroutines_core(r4);
        r12.onSlotCleaned();
        goto L49
    L40:
        r9 = (Waiter) r8;
    L47:
        if (r12.casState$kotlinx_coroutines_core(r4, r8, BufferedChannelKt.getCHANNEL_CLOSED()) == false) goto L7;
        r12.onSlotCleaned();
        goto L49
    L12:
        if (r6 < getReceiversCounter$kotlinx_coroutines_core()) goto L52;
        if (r12.casState$kotlinx_coroutines_core(r4, r8, BufferedChannelKt.getCHANNEL_CLOSED()) == false) goto L7;
        if (r0 == null) goto L17;
        r1 = OnUndeliveredElementKt.callUndeliveredElementCatchingException(r0, r12.getElement$kotlinx_coroutines_core(r4), r1);
    L17:
        r12.cleanElement$kotlinx_coroutines_core(r4);
        r12.onSlotCleaned();
    L52:
        if (r3 != null) goto L54;
    L59:
        if (r1 != null) goto L61;
        return;
    L61:
        throw r1;
    L54:
        if ((r3 instanceof ArrayList) == true) goto L56;
        resumeSenderOnCancelledChannel((Waiter) r3);
        goto L59
    L56:
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
        ArrayList r5 = (ArrayList) r3;
        int r13 = r5.size() - 1;
    L57:
        if ((-1) >= r13) goto L59;
        resumeSenderOnCancelledChannel((Waiter) r5.get(r13));
        r13 = r13 - 1;
        goto L57
    L50:
        r12 = (ChannelSegment) r12.getPrev();
        if (r12 != null) goto L3;
        goto L52
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void cancelSuspendedReceiveRequests(ChannelSegment<E> r9, long r10) {
        Object r0 = InlineList.m3058constructorimpl$default(null, 1, null);
    L4:
        if (r9 == null) goto L29;
        int r3 = BufferedChannelKt.SEGMENT_SIZE - 1;
    L6:
        if ((-1) >= r3) goto L28;
        if (((r9.id * ((long) BufferedChannelKt.SEGMENT_SIZE)) + ((long) r3)) < r10) goto L29;
    L9:
        Object r4 = r9.getState$kotlinx_coroutines_core(r3);
        if (r4 == null) goto L25;
        if (r4 == BufferedChannelKt.access$getIN_BUFFER$p()) goto L25;
        if ((r4 instanceof WaiterEB) == true) goto L17;
        if ((r4 instanceof Waiter) == false) goto L27;
        if (r9.casState$kotlinx_coroutines_core(r3, r4, BufferedChannelKt.getCHANNEL_CLOSED()) == false) goto L9;
        r0 = InlineList.m3063plusFjFbRPM(r0, r4);
        r9.onCancelledRequest(r3, true);
    L27:
        r3 = r3 - 1;
        goto L6
    L17:
        if (r9.casState$kotlinx_coroutines_core(r3, r4, BufferedChannelKt.getCHANNEL_CLOSED()) == false) goto L9;
        r0 = InlineList.m3063plusFjFbRPM(r0, ((WaiterEB) r4).waiter);
        r9.onCancelledRequest(r3, true);
    L25:
        if (r9.casState$kotlinx_coroutines_core(r3, r4, BufferedChannelKt.getCHANNEL_CLOSED()) == false) goto L9;
        r9.onSlotCleaned();
        goto L27
    L28:
        r9 = (ChannelSegment) r9.getPrev();
    L29:
        if (r0 != null) goto L31;
        return;
    L31:
        if ((r0 instanceof ArrayList) == true) goto L33;
        resumeReceiverOnClosedChannel((Waiter) r0);
        return;
    L33:
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
        ArrayList r1 = (ArrayList) r0;
        int r11 = r1.size() - 1;
    L34:
        if ((-1) >= r11) goto L58;
        resumeReceiverOnClosedChannel((Waiter) r1.get(r11));
        r11 = r11 - 1;
        goto L34
    }

    private final void resumeReceiverOnClosedChannel(Waiter r2) {
        resumeWaiterOnClosedChannel(r2, true);
    }

    private final void resumeSenderOnCancelledChannel(Waiter r2) {
        resumeWaiterOnClosedChannel(r2, false);
    }

    private final void resumeWaiterOnClosedChannel(Waiter r2, boolean r3) {
        if ((r2 instanceof SendBroadcast) == false) goto L6;
        CancellableContinuation<Boolean> r1 = ((SendBroadcast) r2).getCont();
        Result.Companion r4 = Result.Companion;
        r1.resumeWith(Result.m1508constructorimpl(false));
        return;
    L6:
        if ((r2 instanceof CancellableContinuation) == false) goto L13;
        Continuation r5 = (Continuation) r2;
        Result.Companion r0 = Result.Companion;
        if (r3 == false) goto L10;
        Throwable r6 = getReceiveException();
    L11:
        r5.resumeWith(Result.m1508constructorimpl(ResultKt.createFailure(r6)));
        return;
    L10:
        r6 = getSendException();
        goto L11
    L13:
        if ((r2 instanceof ReceiveCatching) == false) goto L16;
        CancellableContinuationImpl<ChannelResult<? extends E>> r7 = ((ReceiveCatching) r2).cont;
        Result.Companion r8 = Result.Companion;
        r7.resumeWith(Result.m1508constructorimpl(ChannelResult.m3022boximpl(ChannelResult.Companion.m3035closedJP2dKIU(getCloseCause()))));
        return;
    L16:
        if ((r2 instanceof BufferedChannelIterator) == false) goto L19;
        ((BufferedChannelIterator) r2).tryResumeHasNextOnClosedChannel();
        return;
    L19:
        if ((r2 instanceof SelectInstance) == false) goto L23;
        ((SelectInstance) r2).trySelect(this, BufferedChannelKt.getCHANNEL_CLOSED());
        return;
    L23:
        throw new IllegalStateException(("Unexpected waiter: " + r2).toString());
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean isClosedForSend() {
        return isClosedForSend0(sendersAndCloseStatus$FU.get(this));
    }

    private final boolean isClosedForSend0(long r2) {
        return isClosed(r2, false);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public boolean isClosedForReceive() {
        return isClosedForReceive0(sendersAndCloseStatus$FU.get(this));
    }

    private final boolean isClosedForReceive0(long r2) {
        return isClosed(r2, true);
    }

    private final boolean isClosed(long r7, boolean r9) {
        int r0 = (int) (r7 >> 60);
        if (r0 != 0) goto L5;
        return false;
    L5:
        if (r0 != 1) goto L7;
        return false;
    L7:
        if (r0 != 2) goto L9;
        completeClose(r7 & 1152921504606846975L);
        if (r9 == true) goto L17;
    L21:
        return true;
    L17:
        if (hasElements$kotlinx_coroutines_core() == false) goto L21;
        return false;
    L9:
        if (r0 != 3) goto L13;
        completeCancel(r7 & 1152921504606846975L);
        goto L21
    L13:
        throw new IllegalStateException(("unexpected close status: " + r0).toString());
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public boolean isEmpty() {
        if (isClosedForReceive() == false) goto L6;
        return false;
    L6:
        if (hasElements$kotlinx_coroutines_core() == false) goto L9;
        return false;
    L9:
        return !isClosedForReceive();
    }

    public final boolean hasElements$kotlinx_coroutines_core() {
    L2:
        AtomicReferenceFieldUpdater r0 = receiveSegment$FU;
        ChannelSegment<E> r1 = (ChannelSegment) r0.get(this);
        long r4 = getReceiversCounter$kotlinx_coroutines_core();
        if (getSendersCounter$kotlinx_coroutines_core() <= r4) goto L4;
        long r6 = r4 / ((long) BufferedChannelKt.SEGMENT_SIZE);
        if (r1.id == r6) goto L12;
        r1 = findSegmentReceive(r6, r1);
        if (r1 != null) goto L12;
        if (((ChannelSegment) r0.get(this)).id >= r6) goto L2;
        return false;
    L12:
        r1.cleanPrev();
        if (isCellNonEmpty(r1, (int) (r4 % ((long) BufferedChannelKt.SEGMENT_SIZE)), r4) == true) goto L14;
        receivers$FU.compareAndSet(this, r4, r4 + 1);
        goto L2
    L14:
        return true;
    L4:
        return false;
    }

    private final boolean isCellNonEmpty(ChannelSegment<E> r4, int r5, long r6) {
    L2:
        Object r0 = r4.getState$kotlinx_coroutines_core(r5);
        if (r0 == null) goto L33;
        if (r0 == BufferedChannelKt.access$getIN_BUFFER$p()) goto L33;
        if (r0 != BufferedChannelKt.BUFFERED) goto L11;
        return true;
    L11:
        if (r0 != BufferedChannelKt.access$getINTERRUPTED_SEND$p()) goto L14;
        return false;
    L14:
        if (r0 != BufferedChannelKt.getCHANNEL_CLOSED()) goto L17;
        return false;
    L17:
        if (r0 != BufferedChannelKt.access$getDONE_RCV$p()) goto L20;
        return false;
    L20:
        if (r0 != BufferedChannelKt.access$getPOISONED$p()) goto L23;
        return false;
    L23:
        if (r0 != BufferedChannelKt.access$getRESUMING_BY_EB$p()) goto L26;
        return true;
    L26:
        if (r0 != BufferedChannelKt.access$getRESUMING_BY_RCV$p()) goto L29;
        return false;
    L29:
        if (r6 == getReceiversCounter$kotlinx_coroutines_core()) goto L31;
        return false;
    L31:
        return true;
    L33:
        if (r4.casState$kotlinx_coroutines_core(r5, r0, BufferedChannelKt.access$getPOISONED$p()) == false) goto L2;
        expandBuffer();
        return false;
    }

    private final ChannelSegment<E> findSegmentSend(long r12, ChannelSegment<E> r14) {
        AtomicReferenceFieldUpdater r0 = sendSegment$FU;
        Function2 r1 = (Function2) BufferedChannelKt.createSegmentFunction();
    L3:
        Object r2 = ConcurrentLinkedListKt.findSegmentInternal(r14, r12, r1);
        boolean r4 = false;
        if (SegmentOrClosed.m3075isClosedimpl(r2) == true) goto L23;
        Segment r3 = SegmentOrClosed.m3073getSegmentimpl(r2);
    L6:
        Segment r6 = (Segment) r0.get(this);
        if (r6.id >= r3.id) goto L8;
        if (r3.tryIncPointers$kotlinx_coroutines_core() == false) goto L11;
        if (r0.compareAndSet(this, r6, r3) == true) goto L15;
        if (r3.decPointers$kotlinx_coroutines_core() == false) goto L6;
        r3.remove();
        goto L6
    L15:
        if (r6.decPointers$kotlinx_coroutines_core() == false) goto L8;
        r6.remove();
        goto L8
    L11:
        boolean r5 = false;
    L17:
        if (r5 == false) goto L3;
    L8:
        r5 = true;
    L23:
        if (SegmentOrClosed.m3075isClosedimpl(r2) == false) goto L27;
        completeCloseOrCancel();
        if ((r14.id * ((long) BufferedChannelKt.SEGMENT_SIZE)) >= getReceiversCounter$kotlinx_coroutines_core()) goto L55;
        r14.cleanPrev();
        return null;
    L55:
        return null;
    L27:
        ChannelSegment<E> r15 = (ChannelSegment) SegmentOrClosed.m3073getSegmentimpl(r2);
        if (r15.id <= r12) goto L33;
        updateSendersCounterIfLower(r15.id * ((long) BufferedChannelKt.SEGMENT_SIZE));
        if ((r15.id * ((long) BufferedChannelKt.SEGMENT_SIZE)) >= getReceiversCounter$kotlinx_coroutines_core()) goto L57;
        r15.cleanPrev();
        return null;
    L57:
        return null;
    L33:
        if (DebugKt.getASSERTIONS_ENABLED() == false) goto L42;
        if (r15.id != r12) goto L37;
        r4 = true;
    L37:
        if (r4 == true) goto L42;
        throw new AssertionError();
    L42:
        return r15;
    }

    private final ChannelSegment<E> findSegmentReceive(long r12, ChannelSegment<E> r14) {
        AtomicReferenceFieldUpdater r0 = receiveSegment$FU;
        Function2 r1 = (Function2) BufferedChannelKt.createSegmentFunction();
    L3:
        Object r2 = ConcurrentLinkedListKt.findSegmentInternal(r14, r12, r1);
        boolean r4 = false;
        if (SegmentOrClosed.m3075isClosedimpl(r2) == true) goto L23;
        Segment r3 = SegmentOrClosed.m3073getSegmentimpl(r2);
    L6:
        Segment r6 = (Segment) r0.get(this);
        if (r6.id >= r3.id) goto L8;
        if (r3.tryIncPointers$kotlinx_coroutines_core() == false) goto L11;
        if (r0.compareAndSet(this, r6, r3) == true) goto L15;
        if (r3.decPointers$kotlinx_coroutines_core() == false) goto L6;
        r3.remove();
        goto L6
    L15:
        if (r6.decPointers$kotlinx_coroutines_core() == false) goto L8;
        r6.remove();
        goto L8
    L11:
        boolean r5 = false;
    L17:
        if (r5 == false) goto L3;
    L8:
        r5 = true;
    L23:
        if (SegmentOrClosed.m3075isClosedimpl(r2) == false) goto L27;
        completeCloseOrCancel();
        if ((r14.id * ((long) BufferedChannelKt.SEGMENT_SIZE)) >= getSendersCounter$kotlinx_coroutines_core()) goto L79;
        r14.cleanPrev();
        return null;
    L79:
        return null;
    L27:
        ChannelSegment<E> r15 = (ChannelSegment) SegmentOrClosed.m3073getSegmentimpl(r2);
        if (isRendezvousOrUnlimited() == true) goto L45;
        if (r12 > (getBufferEndCounter() / ((long) BufferedChannelKt.SEGMENT_SIZE))) goto L45;
        AtomicReferenceFieldUpdater r7 = bufferEndSegment$FU;
    L32:
        Segment r8 = (Segment) r7.get(this);
        ChannelSegment<E> r9 = r15;
        if (r8.id >= r9.id) goto L45;
        if (r9.tryIncPointers$kotlinx_coroutines_core() == false) goto L45;
        if (r7.compareAndSet(this, r8, r9) == true) goto L39;
        if (r9.decPointers$kotlinx_coroutines_core() == false) goto L32;
        r9.remove();
        goto L32
    L39:
        if (r8.decPointers$kotlinx_coroutines_core() == false) goto L45;
        r8.remove();
    L45:
        if (r15.id <= r12) goto L50;
        updateReceiversCounterIfLower(r15.id * ((long) BufferedChannelKt.SEGMENT_SIZE));
        if ((r15.id * ((long) BufferedChannelKt.SEGMENT_SIZE)) >= getSendersCounter$kotlinx_coroutines_core()) goto L81;
        r15.cleanPrev();
        return null;
    L81:
        return null;
    L50:
        if (DebugKt.getASSERTIONS_ENABLED() == false) goto L59;
        if (r15.id != r12) goto L54;
        r4 = true;
    L54:
        if (r4 == true) goto L59;
        throw new AssertionError();
    L59:
        return r15;
    }

    private final ChannelSegment<E> findSegmentBufferEnd(long r16, ChannelSegment<E> r18, long r19) {
        AtomicReferenceFieldUpdater r2 = bufferEndSegment$FU;
        Function2 r3 = (Function2) BufferedChannelKt.createSegmentFunction();
    L3:
        Object r4 = ConcurrentLinkedListKt.findSegmentInternal(r18, r16, r3);
        boolean r7 = false;
        if (SegmentOrClosed.m3075isClosedimpl(r4) == true) goto L23;
        Segment r5 = SegmentOrClosed.m3073getSegmentimpl(r4);
    L6:
        Segment r9 = (Segment) r2.get(this);
        if (r9.id >= r5.id) goto L8;
        if (r5.tryIncPointers$kotlinx_coroutines_core() == false) goto L11;
        if (r2.compareAndSet(this, r9, r5) == true) goto L15;
        if (r5.decPointers$kotlinx_coroutines_core() == false) goto L6;
        r5.remove();
        goto L6
    L15:
        if (r9.decPointers$kotlinx_coroutines_core() == false) goto L8;
        r9.remove();
        goto L8
    L11:
        boolean r6 = false;
    L17:
        if (r6 == false) goto L3;
    L8:
        r6 = true;
    L23:
        if (SegmentOrClosed.m3075isClosedimpl(r4) == false) goto L25;
        completeCloseOrCancel();
        moveSegmentBufferEndToSpecifiedOrLast(r16, r18);
        incCompletedExpandBufferAttempts$default(this, 0, 1, null);
        return null;
    L25:
        ChannelSegment<E> r12 = (ChannelSegment) SegmentOrClosed.m3073getSegmentimpl(r4);
        if (r12.id <= r16) goto L32;
        if (bufferEnd$FU.compareAndSet(this, r19 + 1, r12.id * ((long) BufferedChannelKt.SEGMENT_SIZE)) == false) goto L30;
        incCompletedExpandBufferAttempts((r12.id * ((long) BufferedChannelKt.SEGMENT_SIZE)) - r19);
        return null;
    L30:
        incCompletedExpandBufferAttempts$default(this, 0, 1, null);
        return null;
    L32:
        if (DebugKt.getASSERTIONS_ENABLED() == false) goto L41;
        if (r12.id != r16) goto L36;
        r7 = true;
    L36:
        if (r7 == true) goto L41;
        throw new AssertionError();
    L41:
        return r12;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void moveSegmentBufferEndToSpecifiedOrLast(long r6, ChannelSegment<E> r8) {
    L3:
        if (r8.id >= r6) goto L9;
        ChannelSegment<E> r0 = (ChannelSegment) r8.getNext();
        if (r0 == null) goto L9;
        r8 = r0;
    L9:
        if (r8.isRemoved() == false) goto L14;
        ChannelSegment<E> r7 = (ChannelSegment) r8.getNext();
        if (r7 == null) goto L14;
        r8 = r7;
    L14:
        AtomicReferenceFieldUpdater r9 = bufferEndSegment$FU;
    L15:
        Segment r10 = (Segment) r9.get(this);
        ChannelSegment<E> r2 = r8;
        boolean r1 = true;
        if (r10.id >= r2.id) goto L26;
        if (r2.tryIncPointers$kotlinx_coroutines_core() == false) goto L20;
        if (r9.compareAndSet(this, r10, r2) == true) goto L24;
        if (r2.decPointers$kotlinx_coroutines_core() == false) goto L15;
        r2.remove();
        goto L15
    L24:
        if (r10.decPointers$kotlinx_coroutines_core() == false) goto L26;
        r10.remove();
        goto L26
    L20:
        r1 = false;
    L26:
        if (r1 == false) goto L9;
    }

    private final void updateSendersCounterIfLower(long r8) {
        AtomicLongFieldUpdater r0 = sendersAndCloseStatus$FU;
    L3:
        long r3 = r0.get(this);
        long r1 = 1152921504606846975L & r3;
        if (r1 >= r8) goto L5;
        long r5 = BufferedChannelKt.access$constructSendersAndCloseStatus(r1, (int) (r3 >> 60));
        if (sendersAndCloseStatus$FU.compareAndSet(this, r3, r5) == false) goto L3;
        return;
    }

    private final void updateReceiversCounterIfLower(long r8) {
        AtomicLongFieldUpdater r0 = receivers$FU;
    L3:
        long r3 = r0.get(this);
        if (r3 >= r8) goto L5;
        if (receivers$FU.compareAndSet(this, r3, r8) == false) goto L3;
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String toString() {
        StringBuilder r1 = new StringBuilder();
        int r2 = (int) (sendersAndCloseStatus$FU.get(this) >> 60);
        if (r2 == 2) goto L7;
        if (r2 != 3) goto L8;
        r1.append("cancelled,");
    L8:
        r1.append("capacity=" + this.capacity + ',');
        r1.append("data=[");
        int r6 = 0;
        List r3 = CollectionsKt.listOf(new ChannelSegment[]{receiveSegment$FU.get(this), sendSegment$FU.get(this), bufferEndSegment$FU.get(this)});
        ArrayList r4 = new ArrayList();
        Iterator r5 = r3.iterator();
    L10:
        if (r5.hasNext() == false) goto L17;
        Object r7 = r5.next();
        if (((ChannelSegment) r7) == BufferedChannelKt.access$getNULL_SEGMENT$p()) goto L14;
        boolean r8 = true;
    L15:
        if (r8 == false) goto L10;
        r4.add(r7);
        goto L10
    L14:
        r8 = false;
        goto L15
    L17:
        Iterator r9 = r4.iterator();
        if (r9.hasNext() == false) goto L103;
        Object r10 = r9.next();
        if (r9.hasNext() == false) goto L28;
        long r11 = ((ChannelSegment) r10).id;
    L23:
        Object r12 = r9.next();
        long r13 = ((ChannelSegment) r12).id;
        if (r11 <= r13) goto L27;
        r10 = r12;
        r11 = r13;
    L27:
        if (r9.hasNext() == true) goto L23;
    L28:
        ChannelSegment r14 = (ChannelSegment) r10;
        long r15 = getReceiversCounter$kotlinx_coroutines_core();
        long r16 = getSendersCounter$kotlinx_coroutines_core();
    L29:
        int r0 = BufferedChannelKt.SEGMENT_SIZE;
        int r17 = r6;
    L30:
        if (r17 >= r0) goto L94;
        long r18 = (r14.id * ((long) BufferedChannelKt.SEGMENT_SIZE)) + ((long) r17);
        if (r18 >= r16) goto L34;
    L35:
        Object r19 = r14.getState$kotlinx_coroutines_core(r17);
        Object r110 = r14.getElement$kotlinx_coroutines_core(r17);
        if ((r19 instanceof CancellableContinuation) == false) goto L46;
        if (r18 >= r15) goto L41;
        if (r18 < r16) goto L41;
        String r20 = "receive";
    L90:
        if (r110 == null) goto L92;
        r1.append("(" + r20 + ',' + r110 + "),");
    L93:
        r17 = r17 + 1;
        goto L30
    L92:
        r1.append(r20 + ',');
    L41:
        if (r18 >= r16) goto L44;
        if (r18 < r15) goto L44;
        r20 = CommonKey.KEY_SEND;
    L44:
        r20 = "cont";
        goto L90
    L46:
        if ((r19 instanceof SelectInstance) == false) goto L56;
        if (r18 >= r15) goto L51;
        if (r18 < r16) goto L51;
        r20 = "onReceive";
    L51:
        if (r18 >= r16) goto L54;
        if (r18 < r15) goto L54;
        r20 = "onSend";
    L54:
        r20 = "select";
        goto L90
    L56:
        if ((r19 instanceof ReceiveCatching) == false) goto L59;
        r20 = "receiveCatching";
        goto L90
    L59:
        if ((r19 instanceof SendBroadcast) == false) goto L62;
        r20 = "sendBroadcast";
        goto L90
    L62:
        if ((r19 instanceof WaiterEB) == false) goto L65;
        r20 = "EB(" + r19 + ')';
        goto L90
    L65:
        if (Intrinsics.areEqual(r19, BufferedChannelKt.access$getRESUMING_BY_RCV$p()) == false) goto L67;
        boolean r21 = true;
    L68:
        if (r21 == false) goto L70;
        r20 = "resuming_sender";
        goto L90
    L70:
        if (r19 != null) goto L72;
        boolean r22 = true;
    L73:
        if (r22 == false) goto L75;
        boolean r23 = true;
    L76:
        if (r23 == false) goto L78;
        boolean r24 = true;
    L79:
        if (r24 == false) goto L81;
        boolean r25 = true;
    L82:
        if (r25 == false) goto L84;
        boolean r26 = true;
    L85:
        if (r26 == false) goto L87;
        boolean r27 = true;
    L88:
        if (r27 == true) goto L93;
        r20 = r19.toString();
        goto L90
    L87:
        r27 = Intrinsics.areEqual(r19, BufferedChannelKt.getCHANNEL_CLOSED());
        goto L88
    L84:
        r26 = Intrinsics.areEqual(r19, BufferedChannelKt.access$getINTERRUPTED_SEND$p());
        goto L85
    L81:
        r25 = Intrinsics.areEqual(r19, BufferedChannelKt.access$getINTERRUPTED_RCV$p());
        goto L82
    L78:
        r24 = Intrinsics.areEqual(r19, BufferedChannelKt.access$getPOISONED$p());
        goto L79
    L75:
        r23 = Intrinsics.areEqual(r19, BufferedChannelKt.access$getDONE_RCV$p());
        goto L76
    L72:
        r22 = Intrinsics.areEqual(r19, BufferedChannelKt.access$getIN_BUFFER$p());
        goto L73
    L67:
        r21 = Intrinsics.areEqual(r19, BufferedChannelKt.access$getRESUMING_BY_EB$p());
        goto L68
    L34:
        if (r18 < r15) goto L35;
    L97:
        if (StringsKt.last(r1) != ',') goto L99;
        Intrinsics.checkNotNullExpressionValue(r1.deleteCharAt(r1.length() - 1), "this.deleteCharAt(index)");
    L99:
        r1.append("]");
        return r1.toString();
    L94:
        r14 = (ChannelSegment) r14.getNext();
        if (r14 == null) goto L97;
        r6 = 0;
        goto L29
    L103:
        throw new NoSuchElementException();
    L7:
        r1.append("closed,");
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String toStringDebug$kotlinx_coroutines_core() {
        StringBuilder r0 = new StringBuilder();
        StringBuilder r1 = new StringBuilder("S=").append(getSendersCounter$kotlinx_coroutines_core()).append(",R=").append(getReceiversCounter$kotlinx_coroutines_core()).append(",B=").append(getBufferEndCounter()).append(",B'=").append(completedExpandBuffersAndPauseFlag$FU.get(this)).append(",C=");
        AtomicLongFieldUpdater r2 = sendersAndCloseStatus$FU;
        r0.append(r1.append((int) (r2.get(this) >> 60)).append(',').toString());
        int r3 = (int) (r2.get(this) >> 60);
        if (r3 == 1) goto L9;
        if (r3 == 2) goto L8;
        if (r3 != 3) goto L10;
        r0.append("CANCELLED,");
    L10:
        StringBuilder r4 = new StringBuilder("SEND_SEGM=");
        AtomicReferenceFieldUpdater r6 = sendSegment$FU;
        StringBuilder r5 = r4.append(DebugStringsKt.getHexAddress(r6.get(this))).append(",RCV_SEGM=");
        AtomicReferenceFieldUpdater r7 = receiveSegment$FU;
        r0.append(r5.append(DebugStringsKt.getHexAddress(r7.get(this))).toString());
        if (isRendezvousOrUnlimited() == true) goto L13;
        r0.append(",EB_SEGM=" + DebugStringsKt.getHexAddress(bufferEndSegment$FU.get(this)));
    L13:
        r0.append(BytedanceJustifyTextView.TWO_BLANK);
        List r10 = CollectionsKt.listOf(new ChannelSegment[]{r7.get(this), r6.get(this), bufferEndSegment$FU.get(this)});
        ArrayList r8 = new ArrayList();
        Iterator r11 = r10.iterator();
    L15:
        if (r11.hasNext() == false) goto L22;
        Object r9 = r11.next();
        if (((ChannelSegment) r9) == BufferedChannelKt.access$getNULL_SEGMENT$p()) goto L19;
        boolean r12 = true;
    L20:
        if (r12 == false) goto L15;
        r8.add(r9);
        goto L15
    L19:
        r12 = false;
        goto L20
    L22:
        Iterator r13 = r8.iterator();
        if (r13.hasNext() == false) goto L69;
        Object r14 = r13.next();
        if (r13.hasNext() == false) goto L33;
        long r15 = ((ChannelSegment) r14).id;
    L28:
        Object r16 = r13.next();
        long r17 = ((ChannelSegment) r16).id;
        if (r15 <= r17) goto L32;
        r14 = r16;
        r15 = r17;
    L32:
        if (r13.hasNext() == true) goto L28;
    L33:
        ChannelSegment r18 = (ChannelSegment) r14;
    L34:
        StringBuilder r19 = new StringBuilder().append(DebugStringsKt.getHexAddress(r18)).append("=[");
        if (r18.isRemoved() == false) goto L37;
        String r20 = ApnEditor.APN_TYPE_ALL;
    L38:
        StringBuilder r110 = r19.append(r20).append(r18.id).append(",prev=");
        ChannelSegment r21 = (ChannelSegment) r18.getPrev();
        String r22 = null;
        if (r21 == null) goto L41;
        String r23 = DebugStringsKt.getHexAddress(r21);
    L42:
        r0.append(r110.append(r23).append(',').toString());
        int r111 = BufferedChannelKt.SEGMENT_SIZE;
        int r24 = 0;
    L43:
        if (r24 >= r111) goto L61;
        Object r25 = r18.getState$kotlinx_coroutines_core(r24);
        Object r26 = r18.getElement$kotlinx_coroutines_core(r24);
        if ((r25 instanceof CancellableContinuation) == false) goto L48;
        String r27 = "cont";
    L60:
        r0.append("[" + r24 + "]=(" + r27 + ',' + r26 + "),");
        r24 = r24 + 1;
        goto L43
    L48:
        if ((r25 instanceof SelectInstance) == false) goto L51;
        r27 = "select";
        goto L60
    L51:
        if ((r25 instanceof ReceiveCatching) == false) goto L54;
        r27 = "receiveCatching";
        goto L60
    L54:
        if ((r25 instanceof SendBroadcast) == false) goto L57;
        r27 = "send(broadcast)";
        goto L60
    L57:
        if ((r25 instanceof WaiterEB) == false) goto L59;
        r27 = "EB(" + r25 + ')';
        goto L60
    L59:
        r27 = String.valueOf(r25);
        goto L60
    L61:
        StringBuilder r112 = new StringBuilder("next=");
        ChannelSegment r28 = (ChannelSegment) r18.getNext();
        if (r28 == null) goto L64;
        r22 = DebugStringsKt.getHexAddress(r28);
    L64:
        r0.append(r112.append(r22).append("]  ").toString());
        r18 = (ChannelSegment) r18.getNext();
        if (r18 != null) goto L34;
        return r0.toString();
    L41:
        r23 = null;
        goto L42
    L37:
        r20 = "";
        goto L38
    L69:
        throw new NoSuchElementException();
    L8:
        r0.append("CLOSED,");
        goto L10
    L9:
        r0.append("CANCELLATION_STARTED,");
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void checkSegmentStructureInvariants() {
        if (isRendezvousOrUnlimited() == false) goto L13;
        if (bufferEndSegment$FU.get(this) != BufferedChannelKt.access$getNULL_SEGMENT$p()) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == false) goto L11;
    L17:
        List r1 = CollectionsKt.listOf(new ChannelSegment[]{receiveSegment$FU.get(this), sendSegment$FU.get(this), bufferEndSegment$FU.get(this)});
        ArrayList r3 = new ArrayList();
        Iterator r2 = r1.iterator();
    L19:
        if (r2.hasNext() == false) goto L26;
        Object r4 = r2.next();
        if (((ChannelSegment) r4) == BufferedChannelKt.access$getNULL_SEGMENT$p()) goto L23;
        boolean r5 = true;
    L24:
        if (r5 == false) goto L19;
        r3.add(r4);
        goto L19
    L23:
        r5 = false;
        goto L24
    L26:
        Iterator r6 = r3.iterator();
        if (r6.hasNext() == false) goto L113;
        Object r7 = r6.next();
        if (r6.hasNext() == false) goto L37;
        long r8 = ((ChannelSegment) r7).id;
    L32:
        Object r9 = r6.next();
        long r10 = ((ChannelSegment) r9).id;
        if (r8 <= r10) goto L36;
        r7 = r9;
        r8 = r10;
    L36:
        if (r6.hasNext() == true) goto L32;
    L37:
        ChannelSegment r11 = (ChannelSegment) r7;
        if (r11.getPrev() != 0) goto L40;
        boolean r12 = true;
    L41:
        if (r12 == false) goto L111;
    L43:
        if (r11.getNext() == 0) goto L109;
        S r13 = r11.getNext();
        Intrinsics.checkNotNull(r13);
        if (((ChannelSegment) r13).getPrev() == 0) goto L50;
        S r14 = r11.getNext();
        Intrinsics.checkNotNull(r14);
        if (((ChannelSegment) r14).getPrev() == r11) goto L50;
        boolean r15 = false;
    L51:
        if (r15 == false) goto L108;
        int r16 = BufferedChannelKt.SEGMENT_SIZE;
        int r17 = 0;
        int r18 = 0;
    L53:
        if (r17 >= r16) goto L92;
        Object r19 = r11.getState$kotlinx_coroutines_core(r17);
        if (Intrinsics.areEqual(r19, BufferedChannelKt.BUFFERED) == true) goto L90;
        if ((r19 instanceof Waiter) == true) goto L90;
        if (Intrinsics.areEqual(r19, BufferedChannelKt.access$getINTERRUPTED_RCV$p()) == false) goto L61;
        boolean r20 = true;
    L62:
        if (r20 == false) goto L64;
        boolean r21 = true;
    L66:
        if (r21 == false) goto L76;
        if (r11.getElement$kotlinx_coroutines_core(r17) != null) goto L70;
        boolean r22 = true;
    L71:
        if (r22 == false) goto L74;
        r18 = r18 + 1;
        goto L90
    L74:
        throw new IllegalStateException("Check failed.".toString());
    L70:
        r22 = false;
        goto L71
    L76:
        if (Intrinsics.areEqual(r19, BufferedChannelKt.access$getPOISONED$p()) == false) goto L78;
        boolean r23 = true;
    L79:
        if (r23 == false) goto L89;
        if (r11.getElement$kotlinx_coroutines_core(r17) != null) goto L83;
        boolean r24 = true;
    L84:
        if (r24 == true) goto L90;
        throw new IllegalStateException("Check failed.".toString());
    L83:
        r24 = false;
        goto L84
    L89:
        throw new IllegalStateException(("Unexpected segment cell state: " + r19 + ".\nChannel state: " + this).toString());
    L78:
        r23 = Intrinsics.areEqual(r19, BufferedChannelKt.access$getDONE_RCV$p());
        goto L79
    L64:
        r21 = Intrinsics.areEqual(r19, BufferedChannelKt.getCHANNEL_CLOSED());
        goto L66
    L61:
        r20 = Intrinsics.areEqual(r19, BufferedChannelKt.access$getINTERRUPTED_SEND$p());
    L90:
        r17 = r17 + 1;
        goto L53
    L92:
        if (r18 != BufferedChannelKt.SEGMENT_SIZE) goto L106;
        if (r11 != receiveSegment$FU.get(this)) goto L96;
    L101:
        boolean r25 = true;
    L102:
        if (r25 == true) goto L106;
        throw new IllegalStateException(("Logically removed segment is reachable.\nChannel state: " + this).toString());
    L96:
        if (r11 == sendSegment$FU.get(this)) goto L101;
        if (r11 == bufferEndSegment$FU.get(this)) goto L101;
        r25 = false;
    L106:
        S r26 = r11.getNext();
        Intrinsics.checkNotNull(r26);
        r11 = (ChannelSegment) r26;
        goto L43
    L108:
        throw new IllegalStateException(("The `segment.next.prev === segment` invariant is violated.\nChannel state: " + this).toString());
    L50:
        r15 = true;
        goto L51
    L109:
        return;
    L111:
        throw new IllegalStateException(("All processed segments should be unreachable from the data structure, but the `prev` link of the leftmost segment is non-null.\nChannel state: " + this).toString());
    L40:
        r12 = false;
        goto L41
    L113:
        throw new NoSuchElementException();
    L11:
        throw new IllegalStateException(("bufferEndSegment must be NULL_SEGMENT for rendezvous and unlimited channels; they do not manipulate it.\nChannel state: " + this).toString());
    L7:
        r0 = false;
        goto L8
    L13:
        if (((ChannelSegment) receiveSegment$FU.get(this)).id > ((ChannelSegment) bufferEndSegment$FU.get(this)).id) goto L15;
        boolean r27 = true;
    L16:
        if (r27 == true) goto L17;
        throw new IllegalStateException(("bufferEndSegment should not have lower id than receiveSegment.\nChannel state: " + this).toString());
    L15:
        r27 = false;
        goto L16
    }

    private final Object onClosedSend(E r6, Continuation<? super Unit> r7) {
        CancellableContinuationImpl r0 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(r7), 1);
        r0.initCancellability();
        CancellableContinuationImpl r1 = r0;
        Function1<E, Unit> r2 = this.onUndeliveredElement;
        if (r2 == null) goto L13;
        UndeliveredElementException r8 = OnUndeliveredElementKt.callUndeliveredElementCatchingException$default(r2, r6, null, 2, null);
        if (r8 == null) goto L13;
        UndeliveredElementException r9 = r8;
        ExceptionsKt.addSuppressed(r9, getSendException());
        CancellableContinuationImpl r3 = r1;
        Result.Companion r5 = Result.Companion;
        if (DebugKt.getRECOVER_STACK_TRACES() == true) goto L9;
    L12:
        r3.resumeWith(Result.m1508constructorimpl(ResultKt.createFailure(r9)));
    L20:
        Object r10 = r0.getResult();
        if (r10 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L24;
        DebugProbesKt.probeCoroutineSuspended(r7);
    L24:
        if (r10 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L27;
        return r10;
    L27:
        return Unit.INSTANCE;
    L9:
        if ((r3 instanceof CoroutineStackFrame) == false) goto L12;
        r9 = StackTraceRecoveryKt.access$recoverFromStackFrame(r9, r3);
    L13:
        CancellableContinuationImpl r4 = r1;
        Throwable r11 = getSendException();
        Result.Companion r12 = Result.Companion;
        if (DebugKt.getRECOVER_STACK_TRACES() == true) goto L16;
    L19:
        r4.resumeWith(Result.m1508constructorimpl(ResultKt.createFailure(r11)));
        goto L20
    L16:
        if ((r4 instanceof CoroutineStackFrame) == false) goto L19;
        r11 = StackTraceRecoveryKt.access$recoverFromStackFrame(r11, r4);
        goto L19
    }

    private final Object sendOnNoWaiterSuspend(ChannelSegment<E> r22, int r23, E r24, long r25, Continuation<? super Unit> r27) {
        CancellableContinuationImpl r10 = CancellableContinuationKt.getOrCreateCancellableContinuation(IntrinsicsKt.intercepted(r27));
        int r1 = access$updateCellSend(this, r22, r23, r24, r25, r10, false);     // Catch: Throwable -> L69
        if (r1 != 0) goto L6;
        r22.cleanPrev();     // Catch: Throwable -> L69
        CancellableContinuationImpl r0 = r10;     // Catch: Throwable -> L69
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L69
        Object r3 = Result.m1508constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L69
    L49:
        r0.resumeWith(r3);     // Catch: Throwable -> L69
    L61:
        Object r4 = r10.getResult();
        if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L65;
        DebugProbesKt.probeCoroutineSuspended(r27);
    L65:
        if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L68;
        return r4;
    L68:
        return Unit.INSTANCE;
    L6:
        if (r1 != 1) goto L8;
        r0 = r10;     // Catch: Throwable -> L69
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L69
        r3 = Result.m1508constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L69
        goto L49
    L8:
        if (r1 != 2) goto L10;
        access$prepareSenderForSuspension(this, r10, r22, r23);     // Catch: Throwable -> L69
        goto L61
    L10:
        if (r1 == 4) goto L54;
        if (r1 != 5) goto L52;
        r22.cleanPrev();     // Catch: Throwable -> L69
        ChannelSegment r6 = (ChannelSegment) access$getSendSegment$FU$p().get(this);     // Catch: Throwable -> L69
    L14:
        long r7 = access$getSendersAndCloseStatus$FU$p().getAndIncrement(this);     // Catch: Throwable -> L69
        long r16 = r7 & 1152921504606846975L;     // Catch: Throwable -> L69
        boolean r18 = access$isClosedForSend0(this, r7);     // Catch: Throwable -> L69
        long r8 = r16 / ((long) BufferedChannelKt.SEGMENT_SIZE);     // Catch: Throwable -> L69
        int r9 = (int) (r16 % ((long) BufferedChannelKt.SEGMENT_SIZE));     // Catch: Throwable -> L69
        if (r6.id == r8) goto L22;
        ChannelSegment r11 = access$findSegmentSend(this, r8, r6);     // Catch: Throwable -> L69
        if (r11 == null) goto L18;
        ChannelSegment r12 = r11;
    L23:
        ChannelSegment r13 = r12;
        ChannelSegment r26 = r12;
        int r14 = access$updateCellSend(this, r13, r9, r24, r16, r10, r18);     // Catch: Throwable -> L69
        if (r14 == 0) goto L50;
        if (r14 == 1) goto L48;
        if (r14 == 2) goto L40;
        if (r14 == 3) goto L39;
        if (r14 == 4) goto L35;
        if (r14 != 5) goto L33;
        r26.cleanPrev();     // Catch: Throwable -> L69
    L33:
        r6 = r26;
        goto L14
    L35:
        if (r16 >= getReceiversCounter$kotlinx_coroutines_core()) goto L37;
        r26.cleanPrev();     // Catch: Throwable -> L69
    L37:
        CancellableContinuationImpl r15 = r10;     // Catch: Throwable -> L69
    L20:
        access$onClosedSendOnNoWaiterSuspend(this, r24, r15);     // Catch: Throwable -> L69
        goto L61
    L39:
        throw new IllegalStateException("unexpected".toString());     // Catch: Throwable -> L69
    L40:
        if (r18 == false) goto L43;
        r26.onSlotCleaned();     // Catch: Throwable -> L69
        r15 = r10;     // Catch: Throwable -> L69
        goto L20
    L43:
        if ((r10 instanceof Waiter) == false) goto L45;
        CancellableContinuationImpl r17 = r10;     // Catch: Throwable -> L69
    L46:
        if (r17 == null) goto L61;
        access$prepareSenderForSuspension(this, r17, r26, r9);     // Catch: Throwable -> L69
        goto L61
    L45:
        r17 = null;
        goto L46
    L48:
        r0 = r10;     // Catch: Throwable -> L69
        Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L69
        r3 = Result.m1508constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L69
        goto L49
    L50:
        r26.cleanPrev();     // Catch: Throwable -> L69
        r0 = r10;     // Catch: Throwable -> L69
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L69
        r3 = Result.m1508constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L69
        goto L49
    L18:
        if (r18 == false) goto L14;
        r15 = r10;     // Catch: Throwable -> L69
        goto L20
    L22:
        r12 = r6;
        goto L23
    L52:
        throw new IllegalStateException("unexpected".toString());     // Catch: Throwable -> L69
    L54:
        if (r25 >= getReceiversCounter$kotlinx_coroutines_core()) goto L56;
        r22.cleanPrev();     // Catch: Throwable -> L69
    L56:
        r15 = r10;     // Catch: Throwable -> L69
    L69:
        th = move-exception;
        r10.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
        throw th;
    }

    static /* synthetic */ <E> Object sendBroadcast$suspendImpl(BufferedChannel<E> r19, E r20, Continuation<? super Boolean> r21) {
        CancellableContinuationImpl r9 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(r21), 1);
        r9.initCancellability();
        CancellableContinuationImpl r11 = r9;
        if (r19.onUndeliveredElement != null) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L51;
        SendBroadcast r13 = new SendBroadcast(r11);
        ChannelSegment r1 = (ChannelSegment) access$getSendSegment$FU$p().get(r19);
    L8:
        long r2 = access$getSendersAndCloseStatus$FU$p().getAndIncrement(r19);
        long r14 = r2 & 1152921504606846975L;
        boolean r16 = access$isClosedForSend0(r19, r2);
        long r3 = r14 / ((long) BufferedChannelKt.SEGMENT_SIZE);
        int r7 = (int) (r14 % ((long) BufferedChannelKt.SEGMENT_SIZE));
        if (r1.id == r3) goto L15;
        ChannelSegment r4 = access$findSegmentSend(r19, r3, r1);
        if (r4 == null) goto L12;
        ChannelSegment r6 = r4;
    L16:
        ChannelSegment r17 = r6;
        int r5 = access$updateCellSend(r19, r6, r7, r20, r14, r13, r16);
        if (r5 == 0) goto L44;
        if (r5 == 1) goto L45;
        if (r5 == 2) goto L35;
        if (r5 == 3) goto L34;
        if (r5 == 4) goto L31;
        if (r5 != 5) goto L29;
        r17.cleanPrev();
    L29:
        r1 = r17;
        goto L8
    L31:
        if (r14 >= r19.getReceiversCounter$kotlinx_coroutines_core()) goto L37;
        r17.cleanPrev();
    L37:
        Result.Companion r8 = Result.Companion;
        r11.resumeWith(Result.m1508constructorimpl(Boxing.boxBoolean(false)));
    L46:
        Object r10 = r9.getResult();
        if (r10 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L49;
        DebugProbesKt.probeCoroutineSuspended(r21);
    L49:
        return r10;
    L34:
        throw new IllegalStateException("unexpected".toString());
    L35:
        if (r16 == false) goto L39;
        r17.onSlotCleaned();
        goto L37
    L39:
        if ((r13 instanceof Waiter) == false) goto L41;
        SendBroadcast r15 = r13;
    L42:
        if (r15 == null) goto L46;
        access$prepareSenderForSuspension(r19, r15, r17, r7);
        goto L46
    L41:
        r15 = null;
    L45:
        Result.Companion r12 = Result.Companion;
        r11.resumeWith(Result.m1508constructorimpl(Boxing.boxBoolean(true)));
        goto L46
    L44:
        r17.cleanPrev();
        goto L45
    L12:
        if (r16 == false) goto L8;
    L15:
        r6 = r1;
        goto L16
    L51:
        throw new IllegalStateException("the `onUndeliveredElement` feature is unsupported for `sendBroadcast(e)`".toString());
    L5:
        r0 = false;
        goto L6
    }

    private final Object receiveOnNoWaiterSuspend(ChannelSegment<E> r10, int r11, long r12, Continuation<? super E> r14) {
        CancellableContinuationImpl r0 = CancellableContinuationKt.getOrCreateCancellableContinuation(IntrinsicsKt.intercepted(r14));
        Object r1 = access$updateCellReceive(this, r10, r11, r12, r0);     // Catch: Throwable -> L49
        if (r1 != BufferedChannelKt.access$getSUSPEND$p()) goto L6;
        access$prepareReceiverForSuspension(this, r0, r10, r11);     // Catch: Throwable -> L49
    L45:
        Object r9 = r0.getResult();
        if (r9 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L48;
        DebugProbesKt.probeCoroutineSuspended(r14);
    L48:
        return r9;
    L6:
        Function1<Throwable, Unit> r2 = null;
        r2 = null;
        CancellableContinuationImpl r3 = null;
        if (r1 == BufferedChannelKt.access$getFAILED$p()) goto L9;
        r10.cleanPrev();     // Catch: Throwable -> L49
        Function1<E, Unit> r13 = this.onUndeliveredElement;     // Catch: Throwable -> L49
        if (r13 != null) goto L43;
    L38:
        r0.resume(r1, r2);     // Catch: Throwable -> L49
        goto L45
    L43:
        r2 = OnUndeliveredElementKt.bindCancellationFun(r13, r1, r0.getContext());     // Catch: Throwable -> L49
        goto L38
    L9:
        if (r12 >= getSendersCounter$kotlinx_coroutines_core()) goto L11;
        r10.cleanPrev();     // Catch: Throwable -> L49
    L11:
        ChannelSegment r15 = (ChannelSegment) access$getReceiveSegment$FU$p().get(this);     // Catch: Throwable -> L49
    L13:
        if (isClosedForReceive() == true) goto L14;
        long r16 = access$getReceivers$FU$p().getAndIncrement(this);     // Catch: Throwable -> L49
        long r4 = r16 / ((long) BufferedChannelKt.SEGMENT_SIZE);     // Catch: Throwable -> L49
        int r17 = (int) (r16 % ((long) BufferedChannelKt.SEGMENT_SIZE));     // Catch: Throwable -> L49
        if (r15.id == r4) goto L21;
        ChannelSegment r5 = access$findSegmentReceive(this, r4, r15);     // Catch: Throwable -> L49
        if (r5 == null) goto L13;
        r15 = r5;
    L21:
        ChannelSegment r6 = r15;
        r1 = access$updateCellReceive(this, r6, r17, r16, r0);     // Catch: Throwable -> L49
        if (r1 == BufferedChannelKt.access$getSUSPEND$p()) goto L24;
        if (r1 != BufferedChannelKt.access$getFAILED$p()) goto L34;
        if (r16 >= getSendersCounter$kotlinx_coroutines_core()) goto L13;
        r15.cleanPrev();     // Catch: Throwable -> L49
        goto L13
    L34:
        if (r1 == BufferedChannelKt.access$getSUSPEND_NO_WAITER$p()) goto L40;
        r15.cleanPrev();     // Catch: Throwable -> L49
        Function1<E, Unit> r18 = this.onUndeliveredElement;     // Catch: Throwable -> L49
        if (r18 == null) goto L38;
        r2 = OnUndeliveredElementKt.bindCancellationFun(r18, r1, r0.getContext());     // Catch: Throwable -> L49
        goto L38
    L40:
        throw new IllegalStateException("unexpected".toString());     // Catch: Throwable -> L49
    L24:
        if ((r0 instanceof Waiter) == false) goto L26;
        r3 = r0;     // Catch: Throwable -> L49
    L26:
        if (r3 == null) goto L45;
        access$prepareReceiverForSuspension(this, r3, r15, r17);     // Catch: Throwable -> L49
        goto L45
    L14:
        access$onClosedReceiveOnNoWaiterSuspend(this, r0);     // Catch: Throwable -> L49
    L49:
        th = move-exception;
        r0.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void registerSelectForSend(SelectInstance<?> r14, Object r15) {
        ChannelSegment r0 = (ChannelSegment) access$getSendSegment$FU$p().get(this);
    L3:
        long r1 = access$getSendersAndCloseStatus$FU$p().getAndIncrement(this);
        long r3 = 1152921504606846975L & r1;
        boolean r2 = access$isClosedForSend0(this, r1);
        long r5 = r3 / ((long) BufferedChannelKt.SEGMENT_SIZE);
        int r4 = (int) (r3 % ((long) BufferedChannelKt.SEGMENT_SIZE));
        if (r0.id == r5) goto L10;
        ChannelSegment r6 = access$findSegmentSend(this, r5, r0);
        if (r6 == null) goto L7;
        r0 = r6;
        goto L10
    L7:
        if (r2 == false) goto L3;
    L31:
        onClosedSelectOnSend(r15, r14);
        return;
    L10:
        int r7 = access$updateCellSend(this, r0, r4, r15, r3, r14, r2);
        if (r7 == 0) goto L38;
        if (r7 == 1) goto L39;
        if (r7 == 2) goto L29;
        if (r7 == 3) goto L28;
        if (r7 == 4) goto L25;
        if (r7 != 5) goto L3;
        r0.cleanPrev();
        goto L3
    L25:
        if (r3 >= getReceiversCounter$kotlinx_coroutines_core()) goto L31;
        r0.cleanPrev();
        goto L31
    L28:
        throw new IllegalStateException("unexpected".toString());
    L29:
        if (r2 == false) goto L33;
        r0.onSlotCleaned();
        goto L31
    L33:
        if ((r14 instanceof Waiter) == false) goto L35;
        Waiter r16 = (Waiter) r14;
    L36:
        if (r16 == null) goto L56;
        access$prepareSenderForSuspension(this, r16, r0, r4);
        return;
    L56:
        return;
    L35:
        r16 = null;
    L39:
        r14.selectInRegistrationPhase(Unit.INSTANCE);
        return;
    L38:
        r0.cleanPrev();
        goto L39
    }

    private final void registerSelectForReceive(SelectInstance<?> r11, Object r12) {
        ChannelSegment r13 = (ChannelSegment) access$getReceiveSegment$FU$p().get(this);
    L4:
        if (isClosedForReceive() == true) goto L5;
        long r7 = access$getReceivers$FU$p().getAndIncrement(this);
        long r0 = r7 / ((long) BufferedChannelKt.SEGMENT_SIZE);
        int r9 = (int) (r7 % ((long) BufferedChannelKt.SEGMENT_SIZE));
        if (r13.id == r0) goto L12;
        ChannelSegment r1 = access$findSegmentReceive(this, r0, r13);
        if (r1 == null) goto L4;
        r13 = r1;
    L12:
        Object r2 = access$updateCellReceive(this, r13, r9, r7, r11);
        if (r2 == BufferedChannelKt.access$getSUSPEND$p()) goto L15;
        if (r2 != BufferedChannelKt.access$getFAILED$p()) goto L26;
        if (r7 >= getSendersCounter$kotlinx_coroutines_core()) goto L4;
        r13.cleanPrev();
        goto L4
    L26:
        if (r2 == BufferedChannelKt.access$getSUSPEND_NO_WAITER$p()) goto L30;
        r13.cleanPrev();
        r11.selectInRegistrationPhase(r2);
        return;
    L30:
        throw new IllegalStateException("unexpected".toString());
    L15:
        if ((r11 instanceof Waiter) == false) goto L17;
        Waiter r14 = (Waiter) r11;
    L18:
        if (r14 == null) goto L42;
        access$prepareReceiverForSuspension(this, r14, r13, r9);
        return;
    L42:
        return;
    L17:
        r14 = null;
        goto L18
    L5:
        onClosedSelectOnReceive(r11);
    }
}
