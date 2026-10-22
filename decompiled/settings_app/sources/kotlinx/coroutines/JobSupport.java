package kotlinx.coroutines;

import android.security.bytedance.guard.BDSecurityGuardStub;
import androidx.exifinterface.media.ExifInterface;
import com.android.settingslib.mobile.dataservice.DataServiceUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.OpDescriptor;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.selects.SelectClause0;
import kotlinx.coroutines.selects.SelectClause0Impl;
import kotlinx.coroutines.selects.SelectClause1;
import kotlinx.coroutines.selects.SelectClause1Impl;
import kotlinx.coroutines.selects.SelectInstance;

/* JADX INFO: compiled from: JobSupport.kt */
/* JADX INFO: loaded from: classes5.dex */
@Deprecated(level = DeprecationLevel.ERROR, message = "This is internal API and may be removed in the future releases")
@Metadata(d1 = {"\u0000â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0001\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\b\u0017\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\n²\u0001³\u0001´\u0001µ\u0001¶\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J \u0010A\u001a\u00020\u00052\u0006\u0010B\u001a\u00020\u000b2\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020FH\u0002J\u001e\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020\u00112\f\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00110KH\u0002J\u0012\u0010L\u001a\u00020H2\b\u00108\u001a\u0004\u0018\u00010\u000bH\u0014J\u000e\u0010M\u001a\u00020\t2\u0006\u0010N\u001a\u00020\u0002J\u0013\u0010O\u001a\u0004\u0018\u00010\u000bH\u0084@ø\u0001\u0000¢\u0006\u0002\u0010PJ\u0013\u0010Q\u001a\u0004\u0018\u00010\u000bH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010PJ\u0012\u0010R\u001a\u00020\u00052\b\u0010S\u001a\u0004\u0018\u00010\u0011H\u0017J\u0018\u0010R\u001a\u00020H2\u000e\u0010S\u001a\n\u0018\u00010Tj\u0004\u0018\u0001`UH\u0016J\u0010\u0010V\u001a\u00020\u00052\b\u0010S\u001a\u0004\u0018\u00010\u0011J\u0017\u0010W\u001a\u00020\u00052\b\u0010S\u001a\u0004\u0018\u00010\u000bH\u0000¢\u0006\u0002\bXJ\u0010\u0010Y\u001a\u00020H2\u0006\u0010S\u001a\u00020\u0011H\u0016J\u0014\u0010Z\u001a\u0004\u0018\u00010\u000b2\b\u0010S\u001a\u0004\u0018\u00010\u000bH\u0002J\u0010\u0010[\u001a\u00020\u00052\u0006\u0010S\u001a\u00020\u0011H\u0002J\b\u0010\\\u001a\u00020]H\u0014J\u0010\u0010^\u001a\u00020\u00052\u0006\u0010S\u001a\u00020\u0011H\u0016J\u001a\u0010_\u001a\u00020H2\u0006\u00108\u001a\u00020?2\b\u0010`\u001a\u0004\u0018\u00010\u000bH\u0002J\"\u0010a\u001a\u00020H2\u0006\u00108\u001a\u00020b2\u0006\u0010c\u001a\u00020d2\b\u0010e\u001a\u0004\u0018\u00010\u000bH\u0002J\u0012\u0010f\u001a\u00020\u00112\b\u0010S\u001a\u0004\u0018\u00010\u000bH\u0002J&\u0010g\u001a\u00020h2\n\b\u0002\u0010i\u001a\u0004\u0018\u00010]2\n\b\u0002\u0010S\u001a\u0004\u0018\u00010\u0011H\u0080\b¢\u0006\u0002\bjJ\u001c\u0010k\u001a\u0004\u0018\u00010\u000b2\u0006\u00108\u001a\u00020b2\b\u0010e\u001a\u0004\u0018\u00010\u000bH\u0002J\u0012\u0010l\u001a\u0004\u0018\u00010d2\u0006\u00108\u001a\u00020?H\u0002J\n\u0010m\u001a\u00060Tj\u0002`UJ\f\u0010n\u001a\u00060Tj\u0002`UH\u0016J\u000f\u0010o\u001a\u0004\u0018\u00010\u000bH\u0000¢\u0006\u0002\bpJ\b\u0010q\u001a\u0004\u0018\u00010\u0011J \u0010r\u001a\u0004\u0018\u00010\u00112\u0006\u00108\u001a\u00020b2\f\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00110KH\u0002J\u0012\u0010s\u001a\u0004\u0018\u00010D2\u0006\u00108\u001a\u00020?H\u0002J\u0010\u0010t\u001a\u00020\u00052\u0006\u0010u\u001a\u00020\u0011H\u0014J\u0015\u0010v\u001a\u00020H2\u0006\u0010u\u001a\u00020\u0011H\u0010¢\u0006\u0002\bwJ\u0012\u0010x\u001a\u00020H2\b\u0010/\u001a\u0004\u0018\u00010\u0001H\u0004JA\u0010y\u001a\u00020z2\u0006\u0010{\u001a\u00020\u00052\u0006\u0010|\u001a\u00020\u00052)\u0010}\u001a%\u0012\u0016\u0012\u0014\u0018\u00010\u0011¢\u0006\r\b\u007f\u0012\t\b\u0080\u0001\u0012\u0004\b\b(S\u0012\u0004\u0012\u00020H0~j\u0003`\u0081\u0001J1\u0010y\u001a\u00020z2)\u0010}\u001a%\u0012\u0016\u0012\u0014\u0018\u00010\u0011¢\u0006\r\b\u007f\u0012\t\b\u0080\u0001\u0012\u0004\b\b(S\u0012\u0004\u0012\u00020H0~j\u0003`\u0081\u0001J\u0012\u0010\u0082\u0001\u001a\u00020HH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010PJ\t\u0010\u0083\u0001\u001a\u00020\u0005H\u0002J\u0012\u0010\u0084\u0001\u001a\u00020HH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010PJ\"\u0010\u0085\u0001\u001a\u00030\u0086\u00012\u0015\u0010\u0087\u0001\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020H0~H\u0082\bJ\u0015\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u000b2\b\u0010S\u001a\u0004\u0018\u00010\u000bH\u0002J\u0019\u0010\u0089\u0001\u001a\u00020\u00052\b\u0010e\u001a\u0004\u0018\u00010\u000bH\u0000¢\u0006\u0003\b\u008a\u0001J\u001b\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u000b2\b\u0010e\u001a\u0004\u0018\u00010\u000bH\u0000¢\u0006\u0003\b\u008c\u0001J<\u0010\u008d\u0001\u001a\u00020F2)\u0010}\u001a%\u0012\u0016\u0012\u0014\u0018\u00010\u0011¢\u0006\r\b\u007f\u0012\t\b\u0080\u0001\u0012\u0004\b\b(S\u0012\u0004\u0012\u00020H0~j\u0003`\u0081\u00012\u0006\u0010{\u001a\u00020\u0005H\u0002J\u000f\u0010\u008e\u0001\u001a\u00020]H\u0010¢\u0006\u0003\b\u008f\u0001J\u0019\u0010\u0090\u0001\u001a\u00020H2\u0006\u0010C\u001a\u00020D2\u0006\u0010S\u001a\u00020\u0011H\u0002J)\u0010\u0091\u0001\u001a\u00020H\"\u000b\b\u0000\u0010\u0092\u0001\u0018\u0001*\u00020F2\u0006\u0010C\u001a\u00020D2\b\u0010S\u001a\u0004\u0018\u00010\u0011H\u0082\bJ!\u0010\u0093\u0001\u001a\u0004\u0018\u00010\u000b2\t\u0010\u0094\u0001\u001a\u0004\u0018\u00010\u000b2\t\u0010\u0095\u0001\u001a\u0004\u0018\u00010\u000bH\u0002J\"\u0010\u0096\u0001\u001a\u00020H2\f\u0010\u0097\u0001\u001a\u0007\u0012\u0002\b\u00030\u0098\u00012\t\u0010\u0094\u0001\u001a\u0004\u0018\u00010\u000bH\u0002J\u0012\u0010{\u001a\u00020H2\b\u0010S\u001a\u0004\u0018\u00010\u0011H\u0014J\u0013\u0010\u0099\u0001\u001a\u00020H2\b\u00108\u001a\u0004\u0018\u00010\u000bH\u0014J\t\u0010\u009a\u0001\u001a\u00020HH\u0014J\u0010\u0010\u009b\u0001\u001a\u00020H2\u0007\u0010\u009c\u0001\u001a\u00020\u0003J\u0012\u0010\u009d\u0001\u001a\u00020H2\u0007\u00108\u001a\u00030\u009e\u0001H\u0002J\u0011\u0010\u009f\u0001\u001a\u00020H2\u0006\u00108\u001a\u00020FH\u0002J\"\u0010 \u0001\u001a\u00020H2\f\u0010\u0097\u0001\u001a\u0007\u0012\u0002\b\u00030\u0098\u00012\t\u0010\u0094\u0001\u001a\u0004\u0018\u00010\u000bH\u0002J\u0017\u0010¡\u0001\u001a\u00020H2\u0006\u0010E\u001a\u00020FH\u0000¢\u0006\u0003\b¢\u0001J\u0007\u0010£\u0001\u001a\u00020\u0005J\u0014\u0010¤\u0001\u001a\u00030¥\u00012\b\u00108\u001a\u0004\u0018\u00010\u000bH\u0002J\u0013\u0010¦\u0001\u001a\u00020]2\b\u00108\u001a\u0004\u0018\u00010\u000bH\u0002J\t\u0010§\u0001\u001a\u00020]H\u0007J\t\u0010¨\u0001\u001a\u00020]H\u0016J\u001b\u0010©\u0001\u001a\u00020\u00052\u0006\u00108\u001a\u00020?2\b\u0010`\u001a\u0004\u0018\u00010\u000bH\u0002J\u0019\u0010ª\u0001\u001a\u00020\u00052\u0006\u00108\u001a\u00020?2\u0006\u0010I\u001a\u00020\u0011H\u0002J\u001f\u0010«\u0001\u001a\u0004\u0018\u00010\u000b2\b\u00108\u001a\u0004\u0018\u00010\u000b2\b\u0010e\u001a\u0004\u0018\u00010\u000bH\u0002J\u001d\u0010¬\u0001\u001a\u0004\u0018\u00010\u000b2\u0006\u00108\u001a\u00020?2\b\u0010e\u001a\u0004\u0018\u00010\u000bH\u0002J$\u0010\u00ad\u0001\u001a\u00020\u00052\u0006\u00108\u001a\u00020b2\u0006\u0010N\u001a\u00020d2\b\u0010e\u001a\u0004\u0018\u00010\u000bH\u0082\u0010J\u0010\u0010®\u0001\u001a\u0004\u0018\u00010d*\u00030¯\u0001H\u0002J\u0017\u0010°\u0001\u001a\u00020H*\u00020D2\b\u0010S\u001a\u0004\u0018\u00010\u0011H\u0002J\u001d\u0010±\u0001\u001a\u00060Tj\u0002`U*\u00020\u00112\n\b\u0002\u0010i\u001a\u0004\u0018\u00010]H\u0004R\u0011\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bX\u0082\u0004R\u0011\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\bX\u0082\u0004R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u00118DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00058DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00058PX\u0090\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0016R\u0011\u0010\u001a\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0016R\u0011\u0010\u001b\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0016R\u0011\u0010\u001c\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0016R\u0014\u0010\u001d\u001a\u00020\u00058TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0016R\u0015\u0010\u001e\u001a\u0006\u0012\u0002\b\u00030\u001f8F¢\u0006\u0006\u001a\u0004\b \u0010!R\u001e\u0010\"\u001a\u0006\u0012\u0002\b\u00030#8DX\u0084\u0004¢\u0006\f\u0012\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0014\u0010(\u001a\u00020\u00058PX\u0090\u0004¢\u0006\u0006\u001a\u0004\b)\u0010\u0016R\u0017\u0010*\u001a\u00020+8F¢\u0006\f\u0012\u0004\b,\u0010%\u001a\u0004\b-\u0010.R\u0016\u0010/\u001a\u0004\u0018\u00010\u00018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R(\u00103\u001a\u0004\u0018\u00010\t2\b\u00102\u001a\u0004\u0018\u00010\t8@@@X\u0080\u000e¢\u0006\f\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u0016\u00108\u001a\u0004\u0018\u00010\u000b8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b9\u0010:R\u001c\u0010;\u001a\u0004\u0018\u00010\u0011*\u0004\u0018\u00010\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b<\u0010=R\u0018\u0010>\u001a\u00020\u0005*\u00020?8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b>\u0010@\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006·\u0001"}, d2 = {"Lkotlinx/coroutines/JobSupport;", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/ChildJob;", "Lkotlinx/coroutines/ParentJob;", "active", "", "(Z)V", "_parentHandle", "Lkotlinx/atomicfu/AtomicRef;", "Lkotlinx/coroutines/ChildHandle;", "_state", "", "children", "Lkotlin/sequences/Sequence;", "getChildren", "()Lkotlin/sequences/Sequence;", "completionCause", "", "getCompletionCause", "()Ljava/lang/Throwable;", "completionCauseHandled", "getCompletionCauseHandled", "()Z", "handlesException", "getHandlesException$kotlinx_coroutines_core", DataServiceUtils.UiccInfoData.COLUMN_IS_ACTIVE, "isCancelled", "isCompleted", "isCompletedExceptionally", "isScopedCoroutine", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "onAwaitInternal", "Lkotlinx/coroutines/selects/SelectClause1;", "getOnAwaitInternal$annotations", "()V", "getOnAwaitInternal", "()Lkotlinx/coroutines/selects/SelectClause1;", "onCancelComplete", "getOnCancelComplete$kotlinx_coroutines_core", "onJoin", "Lkotlinx/coroutines/selects/SelectClause0;", "getOnJoin$annotations", "getOnJoin", "()Lkotlinx/coroutines/selects/SelectClause0;", "parent", "getParent", "()Lkotlinx/coroutines/Job;", "value", "parentHandle", "getParentHandle$kotlinx_coroutines_core", "()Lkotlinx/coroutines/ChildHandle;", "setParentHandle$kotlinx_coroutines_core", "(Lkotlinx/coroutines/ChildHandle;)V", "state", "getState$kotlinx_coroutines_core", "()Ljava/lang/Object;", "exceptionOrNull", "getExceptionOrNull", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "isCancelling", "Lkotlinx/coroutines/Incomplete;", "(Lkotlinx/coroutines/Incomplete;)Z", "addLastAtomic", "expect", "list", "Lkotlinx/coroutines/NodeList;", "node", "Lkotlinx/coroutines/JobNode;", "addSuppressedExceptions", "", "rootCause", "exceptions", "", "afterCompletion", "attachChild", "child", "awaitInternal", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitSuspend", BDSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CANCEL, "cause", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "cancelCoroutine", "cancelImpl", "cancelImpl$kotlinx_coroutines_core", "cancelInternal", "cancelMakeCompleting", "cancelParent", "cancellationExceptionMessage", "", "childCancelled", "completeStateFinalization", "update", "continueCompleting", "Lkotlinx/coroutines/JobSupport$Finishing;", "lastChild", "Lkotlinx/coroutines/ChildHandleNode;", "proposedUpdate", "createCauseException", "defaultCancellationException", "Lkotlinx/coroutines/JobCancellationException;", "message", "defaultCancellationException$kotlinx_coroutines_core", "finalizeFinishingState", "firstChild", "getCancellationException", "getChildJobCancellationCause", "getCompletedInternal", "getCompletedInternal$kotlinx_coroutines_core", "getCompletionExceptionOrNull", "getFinalRootCause", "getOrPromoteCancellingList", "handleJobException", "exception", "handleOnCompletionException", "handleOnCompletionException$kotlinx_coroutines_core", "initParentJob", "invokeOnCompletion", "Lkotlinx/coroutines/DisposableHandle;", "onCancelling", "invokeImmediately", "handler", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "join", "joinInternal", "joinSuspend", "loopOnState", "", "block", "makeCancelling", "makeCompleting", "makeCompleting$kotlinx_coroutines_core", "makeCompletingOnce", "makeCompletingOnce$kotlinx_coroutines_core", "makeNode", "nameString", "nameString$kotlinx_coroutines_core", "notifyCancelling", "notifyHandlers", ExifInterface.GPS_DIRECTION_TRUE, "onAwaitInternalProcessResFunc", "ignoredParam", "result", "onAwaitInternalRegFunc", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "onCompletionInternal", "onStart", "parentCancelled", "parentJob", "promoteEmptyToNodeList", "Lkotlinx/coroutines/Empty;", "promoteSingleToNodeList", "registerSelectForOnJoin", "removeNode", "removeNode$kotlinx_coroutines_core", "start", "startInternal", "", "stateString", "toDebugString", "toString", "tryFinalizeSimpleState", "tryMakeCancelling", "tryMakeCompleting", "tryMakeCompletingSlowPath", "tryWaitForChild", "nextChild", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "notifyCompletion", "toCancellationException", "AwaitContinuation", "ChildCompletion", "Finishing", "SelectOnAwaitCompletionHandler", "SelectOnJoinCompletionHandler", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class JobSupport implements Job, ChildJob, ParentJob {
    private static final AtomicReferenceFieldUpdater _parentHandle$FU = null;
    private static final AtomicReferenceFieldUpdater _state$FU = null;

    @Volatile
    private volatile Object _parentHandle;

    @Volatile
    private volatile Object _state;

    /* JADX INFO: compiled from: JobSupport.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001b\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/JobSupport$AwaitContinuation;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CancellableContinuationImpl;", "delegate", "Lkotlin/coroutines/Continuation;", "job", "Lkotlinx/coroutines/JobSupport;", "(Lkotlin/coroutines/Continuation;Lkotlinx/coroutines/JobSupport;)V", "getContinuationCancellationCause", "", "parent", "Lkotlinx/coroutines/Job;", "nameString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class AwaitContinuation<T> extends CancellableContinuationImpl<T> {
        private final JobSupport job;

        @Override // kotlinx.coroutines.CancellableContinuationImpl
        protected String nameString() {
            return "AwaitContinuation";
        }

        public AwaitContinuation(Continuation<? super T> r2, JobSupport r3) {
            super(r2, 1);
            this.job = r3;
        }

        @Override // kotlinx.coroutines.CancellableContinuationImpl
        public Throwable getContinuationCancellationCause(Job r2) {
            Object r1 = this.job.getState$kotlinx_coroutines_core();
            if ((r1 instanceof Finishing) == false) goto L8;
            Throwable r0 = ((Finishing) r1).getRootCause();
            if (r0 == null) goto L8;
            return r0;
        L8:
            if ((r1 instanceof CompletedExceptionally) == false) goto L12;
            return ((CompletedExceptionally) r1).cause;
        L12:
            return r2.getCancellationException();
        }
    }

    /* JADX INFO: compiled from: JobSupport.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\b\u0002\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0096\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lkotlinx/coroutines/JobSupport$ChildCompletion;", "Lkotlinx/coroutines/JobNode;", "parent", "Lkotlinx/coroutines/JobSupport;", "state", "Lkotlinx/coroutines/JobSupport$Finishing;", "child", "Lkotlinx/coroutines/ChildHandleNode;", "proposedUpdate", "", "(Lkotlinx/coroutines/JobSupport;Lkotlinx/coroutines/JobSupport$Finishing;Lkotlinx/coroutines/ChildHandleNode;Ljava/lang/Object;)V", "invoke", "", "cause", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class ChildCompletion extends JobNode {
        private final ChildHandleNode child;
        private final JobSupport parent;
        private final Object proposedUpdate;
        private final Finishing state;

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable r1) {
            invoke2(r1);
            return Unit.INSTANCE;
        }

        public ChildCompletion(JobSupport r1, Finishing r2, ChildHandleNode r3, Object r4) {
            this.parent = r1;
            this.state = r2;
            this.child = r3;
            this.proposedUpdate = r4;
        }

        @Override // kotlinx.coroutines.CompletionHandlerBase
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public void invoke2(Throwable r3) {
            JobSupport.access$continueCompleting(this.parent, this.state, this.child, this.proposedUpdate);
        }
    }

    /* JADX INFO: compiled from: JobSupport.kt */
    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u00022\u00020\u0003B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u000e\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\tJ\u0018\u0010%\u001a\u0012\u0012\u0004\u0012\u00020\t0&j\b\u0012\u0004\u0012\u00020\t`'H\u0002J\u0016\u0010(\u001a\b\u0012\u0004\u0012\u00020\t0)2\b\u0010*\u001a\u0004\u0018\u00010\tJ\b\u0010+\u001a\u00020,H\u0016R\u0011\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\fX\u0082\u0004R\t\u0010\r\u001a\u00020\u000eX\u0082\u0004R\u0011\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\fX\u0082\u0004R(\u0010\u0011\u001a\u0004\u0018\u00010\u00012\b\u0010\u0010\u001a\u0004\u0018\u00010\u00018B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0017R$\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0006\u0010\u0017\"\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0017R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR(\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\t8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006-"}, d2 = {"Lkotlinx/coroutines/JobSupport$Finishing;", "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "Lkotlinx/coroutines/Incomplete;", "list", "Lkotlinx/coroutines/NodeList;", "isCompleting", "", "rootCause", "", "(Lkotlinx/coroutines/NodeList;ZLjava/lang/Throwable;)V", "_exceptionsHolder", "Lkotlinx/atomicfu/AtomicRef;", "_isCompleting", "Lkotlinx/atomicfu/AtomicBoolean;", "_rootCause", "value", "exceptionsHolder", "getExceptionsHolder", "()Ljava/lang/Object;", "setExceptionsHolder", "(Ljava/lang/Object;)V", DataServiceUtils.UiccInfoData.COLUMN_IS_ACTIVE, "()Z", "isCancelling", "setCompleting", "(Z)V", "isSealed", "getList", "()Lkotlinx/coroutines/NodeList;", "getRootCause", "()Ljava/lang/Throwable;", "setRootCause", "(Ljava/lang/Throwable;)V", "addExceptionLocked", "", "exception", "allocateList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "sealLocked", "", "proposedException", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class Finishing implements Incomplete {
        private static final AtomicReferenceFieldUpdater _exceptionsHolder$FU = null;
        private static final AtomicIntegerFieldUpdater _isCompleting$FU = null;
        private static final AtomicReferenceFieldUpdater _rootCause$FU = null;

        @Volatile
        private volatile Object _exceptionsHolder;

        @Volatile
        private volatile int _isCompleting;

        @Volatile
        private volatile Object _rootCause;
        private final NodeList list;

        static {
            _isCompleting$FU = AtomicIntegerFieldUpdater.newUpdater(Finishing.class, "_isCompleting");
            _rootCause$FU = AtomicReferenceFieldUpdater.newUpdater(Finishing.class, Object.class, "_rootCause");
            _exceptionsHolder$FU = AtomicReferenceFieldUpdater.newUpdater(Finishing.class, Object.class, "_exceptionsHolder");
        }

        @Override // kotlinx.coroutines.Incomplete
        public NodeList getList() {
            return this.list;
        }

        public Finishing(NodeList r1, boolean r2, Throwable r3) {
            this.list = r1;
            this._isCompleting = r2 ? 1 : 0;
            this._rootCause = r3;
        }

        public final boolean isCompleting() {
            if (_isCompleting$FU.get(this) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public final void setCompleting(boolean r2) {
            _isCompleting$FU.set(this, r2 ? 1 : 0);
        }

        public final Throwable getRootCause() {
            return (Throwable) _rootCause$FU.get(this);
        }

        public final void setRootCause(Throwable r2) {
            _rootCause$FU.set(this, r2);
        }

        private final Object getExceptionsHolder() {
            return _exceptionsHolder$FU.get(this);
        }

        private final void setExceptionsHolder(Object r2) {
            _exceptionsHolder$FU.set(this, r2);
        }

        public final boolean isSealed() {
            if (getExceptionsHolder() != JobSupportKt.access$getSEALED$p()) goto L5;
            return true;
        L5:
            return false;
        }

        public final boolean isCancelling() {
            if (getRootCause() == null) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // kotlinx.coroutines.Incomplete
        public boolean isActive() {
            if (getRootCause() != null) goto L5;
            return true;
        L5:
            return false;
        }

        public final List<Throwable> sealLocked(Throwable r4) {
            Object r0 = getExceptionsHolder();
            if (r0 != null) goto L6;
            ArrayList<Throwable> r1 = allocateList();
        L11:
            Throwable r2 = getRootCause();
            if (r2 == null) goto L14;
            r1.add(0, r2);
        L14:
            if (r4 != null) goto L16;
        L18:
            setExceptionsHolder(JobSupportKt.access$getSEALED$p());
            return r1;
        L16:
            if (Intrinsics.areEqual(r4, r2) == true) goto L18;
            r1.add(r4);
            goto L18
        L6:
            if ((r0 instanceof Throwable) == false) goto L9;
            ArrayList<Throwable> r3 = allocateList();
            r3.add(r0);
            r1 = r3;
            goto L11
        L9:
            if ((r0 instanceof ArrayList) == false) goto L21;
            r1 = (ArrayList) r0;
            goto L11
        L21:
            throw new IllegalStateException(("State is " + r0).toString());
        }

        public final void addExceptionLocked(Throwable r3) {
            Throwable r0 = getRootCause();
            if (r0 != null) goto L6;
            setRootCause(r3);
            return;
        L6:
            if (r3 != r0) goto L8;
            return;
        L8:
            Object r1 = getExceptionsHolder();
            if (r1 != null) goto L12;
            setExceptionsHolder(r3);
            return;
        L12:
            if ((r1 instanceof Throwable) == false) goto L17;
            if (r3 != r1) goto L15;
            return;
        L15:
            ArrayList<Throwable> r2 = allocateList();
            r2.add(r1);
            r2.add(r3);
            setExceptionsHolder(r2);
            return;
        L17:
            if ((r1 instanceof ArrayList) == false) goto L21;
            ((ArrayList) r1).add(r3);
            return;
        L21:
            throw new IllegalStateException(("State is " + r1).toString());
        }

        private final ArrayList<Throwable> allocateList() {
            return new ArrayList(4);
        }

        public String toString() {
            return "Finishing[cancelling=" + isCancelling() + ", completing=" + isCompleting() + ", rootCause=" + getRootCause() + ", exceptions=" + getExceptionsHolder() + ", list=" + getList() + ']';
        }
    }

    /* JADX INFO: compiled from: JobSupport.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0096\u0002R\u0012\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lkotlinx/coroutines/JobSupport$SelectOnAwaitCompletionHandler;", "Lkotlinx/coroutines/JobNode;", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "(Lkotlinx/coroutines/JobSupport;Lkotlinx/coroutines/selects/SelectInstance;)V", "invoke", "", "cause", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private final class SelectOnAwaitCompletionHandler extends JobNode {
        private final SelectInstance<?> select;
        final /* synthetic */ JobSupport this$0;

        public SelectOnAwaitCompletionHandler(JobSupport r1, SelectInstance<?> r2) {
            this.this$0 = r1;
            this.select = r2;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable r1) {
            invoke2(r1);
            return Unit.INSTANCE;
        }

        @Override // kotlinx.coroutines.CompletionHandlerBase
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public void invoke2(Throwable r2) {
            Object r3 = this.this$0.getState$kotlinx_coroutines_core();
            if ((r3 instanceof CompletedExceptionally) == true) goto L6;
            r3 = JobSupportKt.unboxState(r3);
        L6:
            this.select.trySelect(this.this$0, r3);
        }
    }

    /* JADX INFO: compiled from: JobSupport.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0096\u0002R\u0012\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lkotlinx/coroutines/JobSupport$SelectOnJoinCompletionHandler;", "Lkotlinx/coroutines/JobNode;", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "(Lkotlinx/coroutines/JobSupport;Lkotlinx/coroutines/selects/SelectInstance;)V", "invoke", "", "cause", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private final class SelectOnJoinCompletionHandler extends JobNode {
        private final SelectInstance<?> select;
        final /* synthetic */ JobSupport this$0;

        public SelectOnJoinCompletionHandler(JobSupport r1, SelectInstance<?> r2) {
            this.this$0 = r1;
            this.select = r2;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable r1) {
            invoke2(r1);
            return Unit.INSTANCE;
        }

        @Override // kotlinx.coroutines.CompletionHandlerBase
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public void invoke2(Throwable r2) {
            this.select.trySelect(this.this$0, Unit.INSTANCE);
        }
    }

    static {
        _state$FU = AtomicReferenceFieldUpdater.newUpdater(JobSupport.class, Object.class, "_state");
        _parentHandle$FU = AtomicReferenceFieldUpdater.newUpdater(JobSupport.class, Object.class, "_parentHandle");
    }

    protected static /* synthetic */ void getOnAwaitInternal$annotations() {
    }

    public static /* synthetic */ void getOnJoin$annotations() {
    }

    private final void loop$atomicfu(AtomicReferenceFieldUpdater r1, Function1<Object, Unit> r2, Object r3) {
    L2:
        r2.invoke(r1.get(r3));
        goto L2
    }

    protected void afterCompletion(Object r1) {
    }

    protected String cancellationExceptionMessage() {
        return "Job was cancelled";
    }

    public boolean getHandlesException$kotlinx_coroutines_core() {
        return true;
    }

    public boolean getOnCancelComplete$kotlinx_coroutines_core() {
        return false;
    }

    protected boolean handleJobException(Throwable r1) {
        return false;
    }

    protected boolean isScopedCoroutine() {
        return false;
    }

    protected void onCancelling(Throwable r1) {
    }

    protected void onCompletionInternal(Object r1) {
    }

    protected void onStart() {
    }

    public JobSupport(boolean r1) {
        if (r1 == false) goto L5;
        Empty r2 = JobSupportKt.access$getEMPTY_ACTIVE$p();
    L6:
        this._state = r2;
        return;
    L5:
        r2 = JobSupportKt.access$getEMPTY_NEW$p();
        goto L6
    }

    public static final /* synthetic */ Object access$awaitSuspend(JobSupport r0, Continuation r1) {
        return r0.awaitSuspend(r1);
    }

    public static final /* synthetic */ String access$cancellationExceptionMessage(JobSupport r0) {
        return r0.cancellationExceptionMessage();
    }

    public static final /* synthetic */ void access$continueCompleting(JobSupport r0, Finishing r1, ChildHandleNode r2, Object r3) {
        r0.continueCompleting(r1, r2, r3);
    }

    public static final /* synthetic */ Object access$joinSuspend(JobSupport r0, Continuation r1) {
        return r0.joinSuspend(r1);
    }

    public static final /* synthetic */ Object access$onAwaitInternalProcessResFunc(JobSupport r0, Object r1, Object r2) {
        return r0.onAwaitInternalProcessResFunc(r1, r2);
    }

    public static final /* synthetic */ void access$onAwaitInternalRegFunc(JobSupport r0, SelectInstance r1, Object r2) {
        r0.onAwaitInternalRegFunc(r1, r2);
    }

    public static final /* synthetic */ void access$registerSelectForOnJoin(JobSupport r0, SelectInstance r1, Object r2) {
        r0.registerSelectForOnJoin(r1, r2);
    }

    @Override // kotlinx.coroutines.Job
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public /* synthetic */ void cancel() {
        Job.DefaultImpls.cancel(this);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public <R> R fold(R r1, Function2<? super R, ? super CoroutineContext.Element, ? extends R> r2) {
        return (R) Job.DefaultImpls.fold(this, r1, r2);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> r1) {
        return (E) Job.DefaultImpls.get(this, r1);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.Key<?> r1) {
        return Job.DefaultImpls.minusKey(this, r1);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext plus(CoroutineContext r1) {
        return Job.DefaultImpls.plus(this, r1);
    }

    @Override // kotlinx.coroutines.Job
    @Deprecated(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
    public Job plus(Job r1) {
        return Job.DefaultImpls.plus(this, r1);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element
    public final CoroutineContext.Key<?> getKey() {
        return Job.Key;
    }

    public final ChildHandle getParentHandle$kotlinx_coroutines_core() {
        return (ChildHandle) _parentHandle$FU.get(this);
    }

    public final void setParentHandle$kotlinx_coroutines_core(ChildHandle r2) {
        _parentHandle$FU.set(this, r2);
    }

    @Override // kotlinx.coroutines.Job
    public Job getParent() {
        ChildHandle r0 = getParentHandle$kotlinx_coroutines_core();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getParent();
    }

    protected final void initParentJob(Job r2) {
        if (DebugKt.getASSERTIONS_ENABLED() == true) goto L5;
    L12:
        if (r2 != null) goto L15;
        setParentHandle$kotlinx_coroutines_core(NonDisposableHandle.INSTANCE);
        return;
    L15:
        r2.start();
        ChildHandle r3 = r2.attachChild(this);
        setParentHandle$kotlinx_coroutines_core(r3);
        if (isCompleted() == false) goto L19;
        r3.dispose();
        setParentHandle$kotlinx_coroutines_core(NonDisposableHandle.INSTANCE);
        return;
    L19:
        return;
    L5:
        if (getParentHandle$kotlinx_coroutines_core() != null) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == true) goto L12;
        throw new AssertionError();
    L7:
        r0 = false;
        goto L8
    }

    public final Object getState$kotlinx_coroutines_core() {
        AtomicReferenceFieldUpdater r0 = _state$FU;
    L3:
        Object r1 = r0.get(this);
        if ((r1 instanceof OpDescriptor) == false) goto L5;
        ((OpDescriptor) r1).perform(this);
        goto L3
    L5:
        return r1;
    }

    private final Void loopOnState(Function1<Object, Unit> r2) {
    L2:
        r2.invoke(getState$kotlinx_coroutines_core());
        goto L2
    }

    @Override // kotlinx.coroutines.Job
    public boolean isActive() {
        Object r1 = getState$kotlinx_coroutines_core();
        if ((r1 instanceof Incomplete) == true) goto L5;
    L7:
        return false;
    L5:
        if (((Incomplete) r1).isActive() == false) goto L7;
        return true;
    }

    @Override // kotlinx.coroutines.Job
    public final boolean isCompleted() {
        return !(getState$kotlinx_coroutines_core() instanceof Incomplete);
    }

    @Override // kotlinx.coroutines.Job
    public final boolean isCancelled() {
        Object r1 = getState$kotlinx_coroutines_core();
        if ((r1 instanceof CompletedExceptionally) == false) goto L5;
    L10:
        return true;
    L5:
        if ((r1 instanceof Finishing) == true) goto L7;
    L9:
        return false;
    L7:
        if (((Finishing) r1).isCancelling() == false) goto L9;
        goto L9
    }

    private final Object finalizeFinishingState(Finishing r8, Object r9) {
        boolean r1 = true;
        boolean r2 = false;
        if (DebugKt.getASSERTIONS_ENABLED() == false) goto L13;
        if (getState$kotlinx_coroutines_core() != r8) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == true) goto L13;
        throw new AssertionError();
    L7:
        r0 = false;
    L13:
        if (DebugKt.getASSERTIONS_ENABLED() == false) goto L20;
        if ((!r8.isSealed()) == true) goto L20;
        throw new AssertionError();
    L20:
        if (DebugKt.getASSERTIONS_ENABLED() == true) goto L22;
    L26:
        DefaultConstructorMarker r3 = null;
        if ((r9 instanceof CompletedExceptionally) == false) goto L29;
        CompletedExceptionally r4 = (CompletedExceptionally) r9;
    L30:
        if (r4 == null) goto L32;
        Throwable r5 = r4.cause;
    L33:
        monitor-enter(r8);
        boolean r6 = r8.isCancelling();     // Catch: Throwable -> L62
        List<Throwable> r7 = r8.sealLocked(r5);     // Catch: Throwable -> L62
        Throwable r10 = getFinalRootCause(r8, r7);     // Catch: Throwable -> L62
        if (r10 == null) goto L37;
        addSuppressedExceptions(r10, r7);     // Catch: Throwable -> L62
    L37:
        monitor-exit(r8);
        if (r10 == null) goto L43;
        if (r10 == r5) goto L43;
        r9 = new CompletedExceptionally(r10, r2, 2, r3);
    L43:
        if (r10 != null) goto L45;
    L52:
        if (r6 == true) goto L54;
        onCancelling(r10);
    L54:
        onCompletionInternal(r9);
        boolean r11 = _state$FU.compareAndSet(this, r8, JobSupportKt.boxIncomplete(r9));
        if (DebugKt.getASSERTIONS_ENABLED() == false) goto L60;
        if (r11 == true) goto L60;
        throw new AssertionError();
    L60:
        completeStateFinalization(r8, r9);
        return r9;
    L45:
        if (cancelParent(r10) == false) goto L47;
    L50:
        if (r1 == false) goto L52;
        Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
        ((CompletedExceptionally) r9).makeHandled();
        goto L52
    L47:
        if (handleJobException(r10) == true) goto L50;
        r1 = false;
    L62:
        th = move-exception;
        throw th;
    L32:
        r5 = null;
        goto L33
    L29:
        r4 = null;
        goto L30
    L22:
        if (r8.isCompleting() == true) goto L26;
        throw new AssertionError();
    }

    private final Throwable getFinalRootCause(Finishing r5, List<? extends Throwable> r6) {
        Object r1 = null;
        if (r6.isEmpty() == true) goto L5;
        List<? extends Throwable> r4 = r6;
        Iterator<T> r7 = r4.iterator();
    L11:
        if (r7.hasNext() == false) goto L15;
        Object r0 = r7.next();
        if ((!(((Throwable) r0) instanceof CancellationException)) == false) goto L11;
    L16:
        Throwable r2 = (Throwable) r0;
        if (r2 == null) goto L19;
        return r2;
    L19:
        Throwable r8 = r6.get(0);
        if ((r8 instanceof TimeoutCancellationException) == false) goto L35;
        Iterator<T> r9 = r4.iterator();
    L23:
        if (r9.hasNext() == false) goto L32;
        Object r3 = r9.next();
        Throwable r10 = (Throwable) r3;
        if (r10 != r8) goto L27;
    L29:
        boolean r11 = false;
    L30:
        if (r11 == false) goto L23;
        r1 = r3;
        goto L32
    L27:
        if ((r10 instanceof TimeoutCancellationException) == false) goto L29;
        r11 = true;
    L32:
        Throwable r12 = (Throwable) r1;
        if (r12 == null) goto L35;
        return r12;
    L35:
        return r8;
    L15:
        r0 = null;
        goto L16
    L5:
        if (r5.isCancelling() == true) goto L7;
        return null;
    L7:
        return new JobCancellationException(access$cancellationExceptionMessage(this), null, this);
    }

    private final void addSuppressedExceptions(Throwable r4, List<? extends Throwable> r5) {
        if (r5.size() > 1) goto L5;
        return;
    L5:
        Set r3 = Collections.newSetFromMap(new IdentityHashMap(r5.size()));
        if (DebugKt.getRECOVER_STACK_TRACES() == true) goto L8;
        Throwable r0 = r4;
    L9:
        Iterator<? extends Throwable> r6 = r5.iterator();
    L11:
        if (r6.hasNext() == false) goto L23;
        Throwable r1 = r6.next();
        if (DebugKt.getRECOVER_STACK_TRACES() == false) goto L16;
        r1 = StackTraceRecoveryKt.unwrapImpl(r1);
    L16:
        if (r1 == r4) goto L11;
        if (r1 == r0) goto L11;
        if ((r1 instanceof CancellationException) == true) goto L11;
        if (r3.add(r1) == false) goto L11;
        kotlin.ExceptionsKt.addSuppressed(r4, r1);
        goto L11
    L23:
        return;
    L8:
        r0 = StackTraceRecoveryKt.unwrapImpl(r4);
        goto L9
    }

    private final boolean tryFinalizeSimpleState(Incomplete r5, Object r6) {
        if (DebugKt.getASSERTIONS_ENABLED() == false) goto L16;
        if ((r5 instanceof Empty) == false) goto L7;
    L10:
        boolean r0 = true;
    L11:
        if (r0 == true) goto L16;
        throw new AssertionError();
    L7:
        if ((r5 instanceof JobNode) == true) goto L10;
        r0 = false;
    L16:
        if (DebugKt.getASSERTIONS_ENABLED() == false) goto L23;
        if ((!(r6 instanceof CompletedExceptionally)) == true) goto L23;
        throw new AssertionError();
    L23:
        if (_state$FU.compareAndSet(this, r5, JobSupportKt.boxIncomplete(r6)) == true) goto L25;
        return false;
    L25:
        onCancelling(null);
        onCompletionInternal(r6);
        completeStateFinalization(r5, r6);
        return true;
    }

    private final void completeStateFinalization(Incomplete r4, Object r5) {
        ChildHandle r0 = getParentHandle$kotlinx_coroutines_core();
        if (r0 == null) goto L5;
        r0.dispose();
        setParentHandle$kotlinx_coroutines_core(NonDisposableHandle.INSTANCE);
    L5:
        Throwable r1 = null;
        if ((r5 instanceof CompletedExceptionally) == false) goto L8;
        CompletedExceptionally r6 = (CompletedExceptionally) r5;
    L9:
        if (r6 == null) goto L12;
        r1 = r6.cause;
    L12:
        if ((r4 instanceof JobNode) == true) goto L21;
        NodeList r7 = r4.getList();
        if (r7 == null) goto L24;
        notifyCompletion(r7, r1);
        return;
    L24:
        return;
    L21:
        ((JobNode) r4).invoke(r1);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        handleOnCompletionException$kotlinx_coroutines_core(new CompletionHandlerException("Exception in completion handler " + r4 + " for " + this, th));
        return;
    L8:
        r6 = null;
        goto L9
    }

    private final void notifyCancelling(NodeList r7, Throwable r8) {
        onCancelling(r8);
        NodeList r9 = r7;
        Object r0 = r9.getNext();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        LockFreeLinkedListNode r1 = (LockFreeLinkedListNode) r0;
        CompletionHandlerException r2 = null;
    L4:
        if (Intrinsics.areEqual(r1, r9) == true) goto L17;
        if ((r1 instanceof JobCancellingNode) == false) goto L16;
        JobNode r3 = (JobNode) r1;
        r3.invoke(r8);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        CompletionHandlerException r4 = r2;
        if (r4 == null) goto L15;
        kotlin.ExceptionsKt.addSuppressed(r4, th);
        if (r4 != null) goto L16;
    L15:
        r2 = new CompletionHandlerException("Exception in completion handler " + r3 + " for " + this, th);
        Unit r5 = Unit.INSTANCE;
    L16:
        r1 = r1.getNextNode();
        goto L4
    L17:
        CompletionHandlerException r6 = r2;
        if (r6 == null) goto L20;
        handleOnCompletionException$kotlinx_coroutines_core(r6);
    L20:
        cancelParent(r8);
    }

    private final boolean cancelParent(Throwable r4) {
        if (isScopedCoroutine() == false) goto L5;
        return true;
    L5:
        boolean r0 = r4 instanceof CancellationException;
        ChildHandle r3 = getParentHandle$kotlinx_coroutines_core();
        if (r3 != null) goto L8;
    L16:
        return r0;
    L8:
        if (r3 == NonDisposableHandle.INSTANCE) goto L16;
        if (r3.childCancelled(r4) == true) goto L17;
        if (r0 == true) goto L18;
        return false;
    L18:
        return true;
    L17:
        return true;
    }

    private final /* synthetic */ <T extends JobNode> void notifyHandlers(NodeList r7, Throwable r8) {
        NodeList r9 = r7;
        Object r0 = r9.getNext();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        LockFreeLinkedListNode r1 = (LockFreeLinkedListNode) r0;
        CompletionHandlerException r2 = null;
    L4:
        if (Intrinsics.areEqual(r1, r9) == true) goto L17;
        Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
        if ((r1 instanceof LockFreeLinkedListNode) == false) goto L16;
        JobNode r3 = (JobNode) r1;
        r3.invoke(r8);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        CompletionHandlerException r4 = r2;
        if (r4 == null) goto L15;
        kotlin.ExceptionsKt.addSuppressed(r4, th);
        if (r4 != null) goto L16;
    L15:
        r2 = new CompletionHandlerException("Exception in completion handler " + r3 + " for " + this, th);
        Unit r5 = Unit.INSTANCE;
    L16:
        r1 = r1.getNextNode();
        goto L4
    L17:
        CompletionHandlerException r6 = r2;
        if (r6 == null) goto L28;
        handleOnCompletionException$kotlinx_coroutines_core(r6);
        return;
    }

    private final int startInternal(Object r5) {
        if ((r5 instanceof Empty) == false) goto L13;
        if (((Empty) r5).isActive() == false) goto L8;
        return 0;
    L8:
        if (_state$FU.compareAndSet(this, r5, JobSupportKt.access$getEMPTY_ACTIVE$p()) == true) goto L10;
        return -1;
    L10:
        onStart();
        return 1;
    L13:
        if ((r5 instanceof InactiveNodeList) == true) goto L15;
        return 0;
    L15:
        if (_state$FU.compareAndSet(this, r5, ((InactiveNodeList) r5).getList()) == true) goto L17;
        return -1;
    L17:
        onStart();
        return 1;
    }

    @Override // kotlinx.coroutines.Job
    public final CancellationException getCancellationException() {
        Object r0 = getState$kotlinx_coroutines_core();
        if ((r0 instanceof Finishing) == false) goto L12;
        Throwable r1 = ((Finishing) r0).getRootCause();
        if (r1 == null) goto L10;
        CancellationException r2 = toCancellationException(r1, DebugStringsKt.getClassSimpleName(this) + " is cancelling");
        if (r2 == null) goto L10;
        return r2;
    L10:
        throw new IllegalStateException(("Job is still new or active: " + this).toString());
    L12:
        if ((r0 instanceof Incomplete) == true) goto L19;
        if ((r0 instanceof CompletedExceptionally) == false) goto L17;
        return toCancellationException$default(this, ((CompletedExceptionally) r0).cause, null, 1, null);
    L17:
        return new JobCancellationException(DebugStringsKt.getClassSimpleName(this) + " has completed normally", null, this);
    L19:
        throw new IllegalStateException(("Job is still new or active: " + this).toString());
    }

    public static /* synthetic */ CancellationException toCancellationException$default(JobSupport r0, Throwable r1, String r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 1) == 0) goto L7;
        r2 = null;
    L7:
        return r0.toCancellationException(r1, r2);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toCancellationException");
    }

    protected final CancellationException toCancellationException(Throwable r2, String r3) {
        if ((r2 instanceof CancellationException) == false) goto L5;
        CancellationException r0 = (CancellationException) r2;
    L6:
        if (r0 == null) goto L8;
        return r0;
    L8:
        if (r3 != null) goto L11;
        r3 = access$cancellationExceptionMessage(this);
    L11:
        return new JobCancellationException(r3, r2, this);
    L5:
        r0 = null;
        goto L6
    }

    protected final Throwable getCompletionCause() {
        Object r0 = getState$kotlinx_coroutines_core();
        if ((r0 instanceof Finishing) == false) goto L10;
        Throwable r1 = ((Finishing) r0).getRootCause();
        if (r1 == null) goto L8;
        return r1;
    L8:
        throw new IllegalStateException(("Job is still new or active: " + this).toString());
    L10:
        if ((r0 instanceof Incomplete) == true) goto L17;
        if ((r0 instanceof CompletedExceptionally) == true) goto L18;
        return null;
    L18:
        return ((CompletedExceptionally) r0).cause;
    L17:
        throw new IllegalStateException(("Job is still new or active: " + this).toString());
    }

    protected final boolean getCompletionCauseHandled() {
        Object r1 = getState$kotlinx_coroutines_core();
        if ((r1 instanceof CompletedExceptionally) == true) goto L5;
    L7:
        return false;
    L5:
        if (((CompletedExceptionally) r1).getHandled() == false) goto L7;
        return true;
    }

    @Override // kotlinx.coroutines.Job
    public final DisposableHandle invokeOnCompletion(Function1<? super Throwable, Unit> r3) {
        return invokeOnCompletion(false, true, r3);
    }

    @Override // kotlinx.coroutines.Job
    public final DisposableHandle invokeOnCompletion(boolean r7, boolean r8, Function1<? super Throwable, Unit> r9) {
        JobNode r0 = makeNode(r9, r7);
    L3:
        Object r1 = getState$kotlinx_coroutines_core();
        if ((r1 instanceof Empty) == true) goto L5;
        Throwable r3 = null;
        if ((r1 instanceof Incomplete) == false) goto L52;
        NodeList r2 = ((Incomplete) r1).getList();
        if (r2 == null) goto L16;
        DisposableHandle r4 = NonDisposableHandle.INSTANCE;
        if (r7 == false) goto L43;
        if ((r1 instanceof Finishing) == false) goto L43;
        monitor-enter(r1);
        r3 = ((Finishing) r1).getRootCause();     // Catch: Throwable -> L40
        if (r3 == null) goto L29;
        if ((r9 instanceof ChildHandleNode) == false) goto L37;
        if (((Finishing) r1).isCompleting() == false) goto L29;
    L37:
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L40
        monitor-exit(r1);
    L29:
        if (addLastAtomic(r1, r2, r0) == false) goto L30;
        if (r3 == null) goto L33;
        r4 = r0;
        goto L37
    L33:
        JobNode r6 = r0;     // Catch: Throwable -> L40
        monitor-exit(r1);
        return r6;
    L30:
        monitor-exit(r1);
    L40:
        th = move-exception;
        throw th;
    L43:
        if (r3 != null) goto L44;
        if (addLastAtomic(r1, r2, r0) == false) goto L3;
        return r0;
    L44:
        if (r8 == false) goto L47;
        r9.invoke(r3);
    L47:
        return r4;
    L16:
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type kotlinx.coroutines.JobNode");
        promoteSingleToNodeList((JobNode) r1);
        goto L3
    L52:
        if (r8 == false) goto L61;
        if ((r1 instanceof CompletedExceptionally) == false) goto L56;
        CompletedExceptionally r10 = (CompletedExceptionally) r1;
    L57:
        if (r10 == null) goto L59;
        r3 = r10.cause;
    L59:
        r9.invoke(r3);
        goto L61
    L56:
        r10 = null;
    L61:
        return NonDisposableHandle.INSTANCE;
    L5:
        Empty r11 = (Empty) r1;
        if (r11.isActive() == true) goto L8;
        promoteEmptyToNodeList(r11);
        goto L3
    L8:
        if (_state$FU.compareAndSet(this, r1, r0) == false) goto L3;
        return r0;
    }

    private final JobNode makeNode(Function1<? super Throwable, Unit> r2, boolean r3) {
        InvokeOnCompletion r0 = null;
        if (r3 == false) goto L11;
        if ((r2 instanceof JobCancellingNode) == false) goto L7;
        r0 = (JobCancellingNode) r2;
    L7:
        if (r0 != null) goto L9;
        r0 = new InvokeOnCancelling(r2);
    L9:
        r0 = r0;
    L22:
        r0.setJob(this);
        return r0;
    L11:
        if ((r2 instanceof JobNode) == false) goto L13;
        r0 = (JobNode) r2;
    L13:
        if (r0 != null) goto L15;
        r0 = new InvokeOnCompletion(r2);
        goto L22
    L15:
        if (DebugKt.getASSERTIONS_ENABLED() == false) goto L22;
        if ((!(r0 instanceof JobCancellingNode)) == true) goto L22;
        throw new AssertionError();
    }

    private final boolean addLastAtomic(final Object r2, NodeList r3, JobNode r4) {
        NodeList r5 = r3;
        final JobNode r6 = r4;
        LockFreeLinkedListNode.CondAddOp r0 = new JobSupport$addLastAtomic$$inlined$addLastIf$1(r6, this, r2);
    L3:
        int r1 = r5.getPrevNode().tryCondAddNext(r6, r5, r0);
        if (r1 == 1) goto L13;
        if (r1 != 2) goto L3;
        return false;
    L13:
        return true;
    }

    private final void promoteEmptyToNodeList(Empty r3) {
        NodeList r0 = new NodeList();
        if (r3.isActive() == false) goto L5;
        Incomplete r1 = r0;
    L6:
        _state$FU.compareAndSet(this, r3, r1);
        return;
    L5:
        r1 = new InactiveNodeList(r0);
        goto L6
    }

    private final void promoteSingleToNodeList(JobNode r3) {
        r3.addOneIfEmpty(new NodeList());
        LockFreeLinkedListNode r0 = r3.getNextNode();
        _state$FU.compareAndSet(this, r3, r0);
    }

    @Override // kotlinx.coroutines.Job
    public final Object join(Continuation<? super Unit> r2) {
        if (joinInternal() == true) goto L6;
        JobKt.ensureActive(r2.getContext());
        return Unit.INSTANCE;
    L6:
        Object r1 = joinSuspend(r2);
        if (r1 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        return r1;
    L10:
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.Job
    public final SelectClause0 getOnJoin() {
        JobSupport$onJoin$1 r0 = JobSupport$onJoin$1.INSTANCE;
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        return new SelectClause0Impl(this, (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r0, 3), null, 4, null);
    }

    private final void registerSelectForOnJoin(SelectInstance<?> r1, Object r2) {
        if (joinInternal() == true) goto L6;
        r1.selectInRegistrationPhase(Unit.INSTANCE);
        return;
    L6:
        r1.disposeOnCompletion(invokeOnCompletion(new SelectOnJoinCompletionHandler(this, r1)));
    }

    @Override // kotlinx.coroutines.Job
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Added since 1.2.0 for binary compatibility with versions <= 1.1.x")
    public /* synthetic */ boolean cancel(Throwable r5) {
        if (r5 == null) goto L6;
        JobCancellationException r6 = toCancellationException$default(this, r5, null, 1, null);
        if (r6 == null) goto L6;
    L7:
        cancelInternal(r6);
        return true;
    L6:
        r6 = new JobCancellationException(access$cancellationExceptionMessage(this), null, this);
        goto L7
    }

    public void cancelInternal(Throwable r1) {
        cancelImpl$kotlinx_coroutines_core(r1);
    }

    @Override // kotlinx.coroutines.ChildJob
    public final void parentCancelled(ParentJob r1) {
        cancelImpl$kotlinx_coroutines_core(r1);
    }

    public boolean childCancelled(Throwable r3) {
        if ((r3 instanceof CancellationException) == false) goto L6;
        return true;
    L6:
        if (cancelImpl$kotlinx_coroutines_core(r3) == true) goto L8;
    L10:
        return false;
    L8:
        if (getHandlesException$kotlinx_coroutines_core() == false) goto L10;
        return true;
    }

    public final boolean cancelCoroutine(Throwable r1) {
        return cancelImpl$kotlinx_coroutines_core(r1);
    }

    public final boolean cancelImpl$kotlinx_coroutines_core(Object r4) {
        Object r0 = JobSupportKt.access$getCOMPLETING_ALREADY$p();
        if (getOnCancelComplete$kotlinx_coroutines_core() == false) goto L8;
        r0 = cancelMakeCompleting(r4);
        if (r0 != JobSupportKt.COMPLETING_WAITING_CHILDREN) goto L8;
        return true;
    L8:
        if (r0 != JobSupportKt.access$getCOMPLETING_ALREADY$p()) goto L11;
        r0 = makeCancelling(r4);
    L11:
        if (r0 != JobSupportKt.access$getCOMPLETING_ALREADY$p()) goto L14;
        return true;
    L14:
        if (r0 != JobSupportKt.COMPLETING_WAITING_CHILDREN) goto L17;
        return true;
    L17:
        if (r0 != JobSupportKt.access$getTOO_LATE_TO_CANCEL$p()) goto L19;
        return false;
    L19:
        afterCompletion(r0);
        return true;
    }

    public static /* synthetic */ JobCancellationException defaultCancellationException$kotlinx_coroutines_core$default(JobSupport r1, String r2, Throwable r3, int r4, Object r5) {
        if (r5 != null) goto L15;
        if ((r4 & 1) == 0) goto L7;
        r2 = null;
    L7:
        if ((r4 & 2) == 0) goto L10;
        r3 = null;
    L10:
        if (r2 != null) goto L13;
        r2 = access$cancellationExceptionMessage(r1);
    L13:
        return new JobCancellationException(r2, r3, r1);
    L15:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: defaultCancellationException");
    }

    public final JobCancellationException defaultCancellationException$kotlinx_coroutines_core(String r2, Throwable r3) {
        if (r2 != null) goto L6;
        r2 = access$cancellationExceptionMessage(this);
    L6:
        return new JobCancellationException(r2, r3, this);
    }

    @Override // kotlinx.coroutines.ParentJob
    public CancellationException getChildJobCancellationCause() {
        Object r0 = getState$kotlinx_coroutines_core();
        CancellationException r2 = null;
        if ((r0 instanceof Finishing) == false) goto L6;
        Throwable r1 = ((Finishing) r0).getRootCause();
    L12:
        if ((r1 instanceof CancellationException) == false) goto L14;
        r2 = (CancellationException) r1;
    L14:
        if (r2 == null) goto L16;
        return r2;
    L16:
        return new JobCancellationException("Parent job is " + stateString(r0), r1, this);
    L6:
        if ((r0 instanceof CompletedExceptionally) == false) goto L9;
        r1 = ((CompletedExceptionally) r0).cause;
        goto L12
    L9:
        if ((r0 instanceof Incomplete) == true) goto L18;
        r1 = null;
        goto L12
    L18:
        throw new IllegalStateException(("Cannot be cancelling child in this state: " + r0).toString());
    }

    private final Throwable createCauseException(Object r3) {
        if (r3 != null) goto L4;
        boolean r0 = true;
    L5:
        if (r0 == false) goto L9;
        Throwable r4 = (Throwable) r3;
        if (r4 == null) goto L12;
        return r4;
    L12:
        return new JobCancellationException(access$cancellationExceptionMessage(this), null, this);
    L9:
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
        return ((ParentJob) r3).getChildJobCancellationCause();
    L4:
        r0 = r3 instanceof Throwable;
        goto L5
    }

    private final NodeList getOrPromoteCancellingList(Incomplete r3) {
        NodeList r0 = r3.getList();
        if (r0 == null) goto L5;
        return r0;
    L5:
        if ((r3 instanceof Empty) == false) goto L8;
        return new NodeList();
    L8:
        if ((r3 instanceof JobNode) == false) goto L11;
        promoteSingleToNodeList((JobNode) r3);
        return null;
    L11:
        throw new IllegalStateException(("State should have list: " + r3).toString());
    }

    private final boolean tryMakeCancelling(Incomplete r6, Throwable r7) {
        if (DebugKt.getASSERTIONS_ENABLED() == false) goto L10;
        if ((!(r6 instanceof Finishing)) == true) goto L10;
        throw new AssertionError();
    L10:
        if (DebugKt.getASSERTIONS_ENABLED() == true) goto L12;
    L16:
        NodeList r0 = getOrPromoteCancellingList(r6);
        if (r0 != null) goto L20;
        return false;
    L20:
        if (_state$FU.compareAndSet(this, r6, new Finishing(r0, false, r7)) == true) goto L22;
        return false;
    L22:
        notifyCancelling(r0, r7);
        return true;
    L12:
        if (r6.isActive() == true) goto L16;
        throw new AssertionError();
    }

    private final Object tryMakeCompleting(Object r2, Object r3) {
        if ((r2 instanceof Incomplete) == true) goto L7;
        return JobSupportKt.access$getCOMPLETING_ALREADY$p();
    L7:
        if ((r2 instanceof Empty) == true) goto L11;
        if ((r2 instanceof JobNode) == true) goto L11;
    L20:
        return tryMakeCompletingSlowPath((Incomplete) r2, r3);
    L11:
        if ((r2 instanceof ChildHandleNode) == true) goto L20;
        if ((r3 instanceof CompletedExceptionally) == true) goto L20;
        if (tryFinalizeSimpleState((Incomplete) r2, r3) == false) goto L18;
        return r3;
    L18:
        return JobSupportKt.access$getCOMPLETING_RETRY$p();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Object tryMakeCompletingSlowPath(Incomplete r9, Object r10) {
        NodeList r0 = getOrPromoteCancellingList(r9);
        if (r0 == null) goto L5;
        T r2 = 0;
        if ((r9 instanceof Finishing) == false) goto L9;
        Finishing r1 = (Finishing) r9;
    L10:
        boolean r3 = false;
        if (r1 != null) goto L13;
        r1 = new Finishing(r0, false, null);
    L13:
        Ref.ObjectRef r4 = new Ref.ObjectRef();
        monitor-enter(r1);
    L60:
        th = move-exception;
        throw th;
    L16:
        if (r1.isCompleting() == false) goto L21;
        Symbol r8 = JobSupportKt.access$getCOMPLETING_ALREADY$p();     // Catch: Throwable -> L60
        monitor-exit(r1);
        return r8;
    L21:
        r1.setCompleting(true);     // Catch: Throwable -> L60
        if (r1 == r9) goto L29;
        if (_state$FU.compareAndSet(this, r9, r1) == true) goto L29;
        Symbol r11 = JobSupportKt.access$getCOMPLETING_RETRY$p();     // Catch: Throwable -> L60
        monitor-exit(r1);
        return r11;
    L29:
        if (DebugKt.getASSERTIONS_ENABLED() == true) goto L31;
    L35:
        boolean r6 = r1.isCancelling();     // Catch: Throwable -> L60
        if ((r10 instanceof CompletedExceptionally) == false) goto L38;
        CompletedExceptionally r7 = (CompletedExceptionally) r10;     // Catch: Throwable -> L60
    L39:
        if (r7 == null) goto L41;
        r1.addExceptionLocked(r7.cause);     // Catch: Throwable -> L60
    L41:
        Throwable r12 = r1.getRootCause();     // Catch: Throwable -> L60
        if (r6 == true) goto L45;
        r3 = true;
    L45:
        if (Boolean.valueOf(r3).booleanValue() == false) goto L47;
        r2 = r12;
    L47:
        r4.element = r2;     // Catch: Throwable -> L60
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L60
        monitor-exit(r1);
        Throwable r13 = (Throwable) r4.element;
        if (r13 == null) goto L52;
        notifyCancelling(r0, r13);
    L52:
        ChildHandleNode r14 = firstChild(r9);
        if (r14 == null) goto L59;
        if (tryWaitForChild(r1, r14, r10) == false) goto L59;
        return JobSupportKt.COMPLETING_WAITING_CHILDREN;
    L59:
        return finalizeFinishingState(r1, r10);
    L38:
        r7 = null;
        goto L39
    L31:
        if ((!r1.isSealed()) == true) goto L35;
        throw new AssertionError();     // Catch: Throwable -> L60
    L9:
        r1 = null;
        goto L10
    L5:
        return JobSupportKt.access$getCOMPLETING_RETRY$p();
    }

    private final Throwable getExceptionOrNull(Object r2) {
        if ((r2 instanceof CompletedExceptionally) == false) goto L5;
        CompletedExceptionally r3 = (CompletedExceptionally) r2;
    L6:
        if (r3 != null) goto L8;
        return null;
    L8:
        return r3.cause;
    L5:
        r3 = null;
        goto L6
    }

    private final ChildHandleNode firstChild(Incomplete r3) {
        if ((r3 instanceof ChildHandleNode) == false) goto L5;
        ChildHandleNode r0 = (ChildHandleNode) r3;
    L6:
        if (r0 != null) goto L11;
        NodeList r4 = r3.getList();
        if (r4 != null) goto L13;
        return null;
    L13:
        return nextChild(r4);
    L11:
        return r0;
    L5:
        r0 = null;
        goto L6
    }

    private final boolean tryWaitForChild(Finishing r8, ChildHandleNode r9, Object r10) {
    L3:
        if (Job.DefaultImpls.invokeOnCompletion$default(r9.childJob, false, false, new ChildCompletion(this, r8, r9, r10), 1, null) != NonDisposableHandle.INSTANCE) goto L4;
        r9 = nextChild(r9);
        if (r9 != null) goto L3;
        return false;
    L4:
        return true;
    }

    private final void continueCompleting(Finishing r2, ChildHandleNode r3, Object r4) {
        if (DebugKt.getASSERTIONS_ENABLED() == true) goto L5;
    L12:
        ChildHandleNode r5 = nextChild(r3);
        if (r5 != null) goto L15;
    L17:
        afterCompletion(finalizeFinishingState(r2, r4));
        return;
    L15:
        if (tryWaitForChild(r2, r5, r4) == false) goto L17;
        return;
    L5:
        if (getState$kotlinx_coroutines_core() != r2) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == true) goto L12;
        throw new AssertionError();
    L7:
        r0 = false;
        goto L8
    }

    private final ChildHandleNode nextChild(LockFreeLinkedListNode r1) {
    L3:
        if (r1.isRemoved() == false) goto L5;
        r1 = r1.getPrevNode();
    L5:
        r1 = r1.getNextNode();
        if (r1.isRemoved() == true) goto L5;
        if ((r1 instanceof ChildHandleNode) == true) goto L10;
        if ((r1 instanceof NodeList) == false) goto L5;
        return null;
    L10:
        return (ChildHandleNode) r1;
    }

    @Override // kotlinx.coroutines.Job
    public final Sequence<Job> getChildren() {
        return SequencesKt.sequence(new JobSupport$children$1(this, null));
    }

    @Override // kotlinx.coroutines.Job
    public final ChildHandle attachChild(ChildJob r7) {
        DisposableHandle r6 = Job.DefaultImpls.invokeOnCompletion$default(this, true, false, new ChildHandleNode(r7), 2, null);
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type kotlinx.coroutines.ChildHandle");
        return (ChildHandle) r6;
    }

    public void handleOnCompletionException$kotlinx_coroutines_core(Throwable r1) {
        throw r1;
    }

    public String toString() {
        return toDebugString() + '@' + DebugStringsKt.getHexAddress(this);
    }

    public final String toDebugString() {
        return nameString$kotlinx_coroutines_core() + '{' + stateString(getState$kotlinx_coroutines_core()) + '}';
    }

    public String nameString$kotlinx_coroutines_core() {
        return DebugStringsKt.getClassSimpleName(this);
    }

    private final String stateString(Object r2) {
        if ((r2 instanceof Finishing) == false) goto L11;
        Finishing r3 = (Finishing) r2;
        if (r3.isCancelling() == false) goto L8;
        return "Cancelling";
    L8:
        if (r3.isCompleting() == false) goto L22;
        return "Completing";
    L22:
        return "Active";
    L11:
        if ((r2 instanceof Incomplete) == false) goto L17;
        if (((Incomplete) r2).isActive() == true) goto L26;
        return "New";
    L26:
        return "Active";
    L17:
        if ((r2 instanceof CompletedExceptionally) == false) goto L19;
        return "Cancelled";
    L19:
        return "Completed";
    }

    private final boolean isCancelling(Incomplete r1) {
        if ((r1 instanceof Finishing) == true) goto L5;
    L7:
        return false;
    L5:
        if (((Finishing) r1).isCancelling() == false) goto L7;
        return true;
    }

    public final boolean isCompletedExceptionally() {
        return getState$kotlinx_coroutines_core() instanceof CompletedExceptionally;
    }

    public final Throwable getCompletionExceptionOrNull() {
        Object r0 = getState$kotlinx_coroutines_core();
        if ((!(r0 instanceof Incomplete)) == false) goto L7;
        return getExceptionOrNull(r0);
    L7:
        throw new IllegalStateException("This job has not completed yet".toString());
    }

    public final Object getCompletedInternal$kotlinx_coroutines_core() {
        Object r1 = getState$kotlinx_coroutines_core();
        if ((!(r1 instanceof Incomplete)) == false) goto L11;
        if ((r1 instanceof CompletedExceptionally) == true) goto L9;
        return JobSupportKt.unboxState(r1);
    L9:
        throw ((CompletedExceptionally) r1).cause;
    L11:
        throw new IllegalStateException("This job has not completed yet".toString());
    }

    protected final Object awaitInternal(Continuation<Object> r3) {
    L2:
        Object r0 = getState$kotlinx_coroutines_core();
        if ((r0 instanceof Incomplete) == false) goto L5;
        if (startInternal(r0) < 0) goto L2;
        return awaitSuspend(r3);
    L5:
        if ((r0 instanceof CompletedExceptionally) == false) goto L15;
        Throwable r2 = ((CompletedExceptionally) r0).cause;
        if (DebugKt.getRECOVER_STACK_TRACES() == true) goto L9;
        throw r2;
    L9:
        if ((r3 instanceof CoroutineStackFrame) == true) goto L12;
        throw r2;
    L12:
        throw StackTraceRecoveryKt.access$recoverFromStackFrame(r2, (CoroutineStackFrame) r3);
    L15:
        return JobSupportKt.unboxState(r0);
    }

    private final Object awaitSuspend(Continuation<Object> r5) {
        AwaitContinuation r0 = new AwaitContinuation(IntrinsicsKt.intercepted(r5), this);
        r0.initCancellability();
        CancellableContinuationKt.disposeOnCancellation(r0, invokeOnCompletion(new ResumeAwaitOnCompletion(r0)));
        Object r4 = r0.getResult();
        if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r5);
    L5:
        return r4;
    }

    protected final SelectClause1<?> getOnAwaitInternal() {
        JobSupport$onAwaitInternal$1 r0 = JobSupport$onAwaitInternal$1.INSTANCE;
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        Function3 r2 = (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r0, 3);
        JobSupport$onAwaitInternal$2 r1 = JobSupport$onAwaitInternal$2.INSTANCE;
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new SelectClause1Impl(this, r2, (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r1, 3), null, 8, null);
    }

    private final void onAwaitInternalRegFunc(SelectInstance<?> r2, Object r3) {
    L2:
        Object r4 = getState$kotlinx_coroutines_core();
        if ((r4 instanceof Incomplete) == false) goto L5;
        if (startInternal(r4) < 0) goto L2;
        r2.disposeOnCompletion(invokeOnCompletion(new SelectOnAwaitCompletionHandler(this, r2)));
        return;
    L5:
        if ((r4 instanceof CompletedExceptionally) == true) goto L8;
        r4 = JobSupportKt.unboxState(r4);
    L8:
        r2.selectInRegistrationPhase(r4);
    }

    private final Object onAwaitInternalProcessResFunc(Object r1, Object r2) {
        if ((r2 instanceof CompletedExceptionally) == true) goto L6;
        return r2;
    L6:
        throw ((CompletedExceptionally) r2).cause;
    }

    private final void notifyCompletion(NodeList r7, Throwable r8) {
        NodeList r9 = r7;
        Object r0 = r9.getNext();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        LockFreeLinkedListNode r1 = (LockFreeLinkedListNode) r0;
        CompletionHandlerException r2 = null;
    L4:
        if (Intrinsics.areEqual(r1, r9) == true) goto L17;
        if ((r1 instanceof JobNode) == false) goto L16;
        JobNode r3 = (JobNode) r1;
        r3.invoke(r8);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        CompletionHandlerException r4 = r2;
        if (r4 == null) goto L15;
        kotlin.ExceptionsKt.addSuppressed(r4, th);
        if (r4 != null) goto L16;
    L15:
        r2 = new CompletionHandlerException("Exception in completion handler " + r3 + " for " + this, th);
        Unit r5 = Unit.INSTANCE;
    L16:
        r1 = r1.getNextNode();
        goto L4
    L17:
        CompletionHandlerException r6 = r2;
        if (r6 == null) goto L28;
        handleOnCompletionException$kotlinx_coroutines_core(r6);
        return;
    }

    @Override // kotlinx.coroutines.Job
    public final boolean start() {
    L2:
        int r0 = startInternal(getState$kotlinx_coroutines_core());
        if (r0 == 0) goto L8;
        if (r0 != 1) goto L2;
        return true;
    L8:
        return false;
    }

    private final boolean joinInternal() {
    L2:
        Object r0 = getState$kotlinx_coroutines_core();
        if ((r0 instanceof Incomplete) == false) goto L4;
        if (startInternal(r0) < 0) goto L2;
        return true;
    L4:
        return false;
    }

    private final Object joinSuspend(Continuation<? super Unit> r5) {
        CancellableContinuationImpl r0 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(r5), 1);
        r0.initCancellability();
        CancellableContinuationImpl r1 = r0;
        CancellableContinuationKt.disposeOnCancellation(r1, invokeOnCompletion(new ResumeOnCompletion(r1)));
        Object r4 = r0.getResult();
        if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        DebugProbesKt.probeCoroutineSuspended(r5);
    L6:
        if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L9;
        return r4;
    L9:
        return Unit.INSTANCE;
    }

    public final void removeNode$kotlinx_coroutines_core(JobNode r4) {
    L2:
        Object r0 = getState$kotlinx_coroutines_core();
        if ((r0 instanceof JobNode) == false) goto L10;
        if (r0 != r4) goto L5;
        if (_state$FU.compareAndSet(this, r0, JobSupportKt.access$getEMPTY_ACTIVE$p()) == false) goto L2;
        return;
    L5:
        return;
    L10:
        if ((r0 instanceof Incomplete) == true) goto L12;
        return;
    L12:
        if (((Incomplete) r0).getList() == null) goto L20;
        r4.mo3066remove();
        return;
    }

    @Override // kotlinx.coroutines.Job
    public void cancel(JobCancellationException r4) {
        if (r4 != null) goto L4;
        r4 = new JobCancellationException(access$cancellationExceptionMessage(this), null, this);
    L4:
        cancelInternal(r4);
    }

    private final Object cancelMakeCompleting(Object r7) {
    L2:
        Object r0 = getState$kotlinx_coroutines_core();
        if ((r0 instanceof Incomplete) == false) goto L13;
        if ((r0 instanceof Finishing) == true) goto L7;
    L9:
        boolean r5 = false;
        Object r1 = tryMakeCompleting(r0, new CompletedExceptionally(createCauseException(r7), r5, 2, null));
        if (r1 == JobSupportKt.access$getCOMPLETING_RETRY$p()) goto L2;
        return r1;
    L7:
        if (((Finishing) r0).isCompleting() == false) goto L9;
    L13:
        return JobSupportKt.access$getCOMPLETING_ALREADY$p();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Object makeCancelling(Object r7) {
        Throwable r0 = null;
        Object[] r1 = 0;
        Throwable r2 = null;
    L3:
        Object r3 = getState$kotlinx_coroutines_core();
        if ((r3 instanceof Finishing) == true) goto L5;
        if ((r3 instanceof Incomplete) == false) goto L47;
        if (r2 != null) goto L33;
        r2 = createCauseException(r7);
    L33:
        Incomplete r4 = (Incomplete) r3;
        if (r4.isActive() == true) goto L36;
        Object r5 = tryMakeCompleting(r3, new CompletedExceptionally(r2, false, 2, r1 == true ? 1 : 0));
        if (r5 == JobSupportKt.access$getCOMPLETING_ALREADY$p()) goto L45;
        if (r5 == JobSupportKt.access$getCOMPLETING_RETRY$p()) goto L3;
        return r5;
    L45:
        throw new IllegalStateException(("Cannot happen in " + r3).toString());
    L36:
        if (tryMakeCancelling(r4, r2) == false) goto L3;
        return JobSupportKt.access$getCOMPLETING_ALREADY$p();
    L47:
        return JobSupportKt.access$getTOO_LATE_TO_CANCEL$p();
    L5:
        monitor-enter(r3);
    L26:
        th = move-exception;
        throw th;
    L7:
        if (((Finishing) r3).isSealed() == false) goto L11;
        Symbol r6 = JobSupportKt.access$getTOO_LATE_TO_CANCEL$p();     // Catch: Throwable -> L26
        monitor-exit(r3);
        return r6;
    L11:
        boolean r8 = ((Finishing) r3).isCancelling();     // Catch: Throwable -> L26
        if (r7 != null) goto L14;
        if (r8 == false) goto L14;
    L17:
        Throwable r9 = ((Finishing) r3).getRootCause();     // Catch: Throwable -> L26
        if ((!r8) == false) goto L21;
        r0 = r9;
    L21:
        monitor-exit(r3);
        if (r0 == null) goto L25;
        notifyCancelling(((Finishing) r3).getList(), r0);
    L25:
        return JobSupportKt.access$getCOMPLETING_ALREADY$p();
    L14:
        if (r2 != null) goto L16;
        r2 = createCauseException(r7);     // Catch: Throwable -> L26
    L16:
        ((Finishing) r3).addExceptionLocked(r2);     // Catch: Throwable -> L26
        goto L17
    }

    public final boolean makeCompleting$kotlinx_coroutines_core(Object r4) {
    L2:
        Object r0 = tryMakeCompleting(getState$kotlinx_coroutines_core(), r4);
        if (r0 == JobSupportKt.access$getCOMPLETING_ALREADY$p()) goto L4;
        if (r0 == JobSupportKt.COMPLETING_WAITING_CHILDREN) goto L8;
        if (r0 == JobSupportKt.access$getCOMPLETING_RETRY$p()) goto L2;
        afterCompletion(r0);
        return true;
    L8:
        return true;
    L4:
        return false;
    }

    public final Object makeCompletingOnce$kotlinx_coroutines_core(Object r4) {
    L2:
        Object r0 = tryMakeCompleting(getState$kotlinx_coroutines_core(), r4);
        if (r0 == JobSupportKt.access$getCOMPLETING_ALREADY$p()) goto L8;
        if (r0 == JobSupportKt.access$getCOMPLETING_RETRY$p()) goto L2;
        return r0;
    L8:
        throw new IllegalStateException("Job " + this + " is already complete or completing, but is being completed with " + r4, getExceptionOrNull(r4));
    }
}
