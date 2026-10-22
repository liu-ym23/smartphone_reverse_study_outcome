package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.constant.AgentConstants;
import com.obric.security.health.score.HealthModuleIds;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.OpDescriptor;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.intrinsics.CancellableKt;
import kotlinx.coroutines.intrinsics.UndispatchedKt;
import kotlinx.coroutines.selects.SelectClause0;
import kotlinx.coroutines.selects.SelectInstance;
import tmsdkobf.b0$$ExternalSyntheticBackport0;

/* JADX INFO: compiled from: JobSupport.kt */
/* JADX INFO: loaded from: classes5.dex */
@Deprecated(level = DeprecationLevel.ERROR, message = "This is internal API and may be removed in the future releases")
@Metadata(d1 = {"\u0000è\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0001\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0017\u0018\u00002\u00020X2\u00020\u00172\u00020\u007f2\u00030Ã\u0001:\u0006Ò\u0001Ó\u0001Ô\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J'\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ%\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0015\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005H\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001e\u001a\u0004\u0018\u00010\u0005H\u0080@ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u001f\u001a\u0004\u0018\u00010\u0005H\u0082@ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010\u001dJ\u0019\u0010!\u001a\u00020\u00012\b\u0010 \u001a\u0004\u0018\u00010\rH\u0017¢\u0006\u0004\b!\u0010\"J\u001f\u0010!\u001a\u00020\u00112\u000e\u0010 \u001a\n\u0018\u00010#j\u0004\u0018\u0001`$H\u0016¢\u0006\u0004\b!\u0010%J\u0017\u0010&\u001a\u00020\u00012\b\u0010 \u001a\u0004\u0018\u00010\r¢\u0006\u0004\b&\u0010\"J\u0019\u0010)\u001a\u00020\u00012\b\u0010 \u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0004\b'\u0010(J\u0017\u0010*\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\rH\u0016¢\u0006\u0004\b*\u0010+J\u001b\u0010,\u001a\u0004\u0018\u00010\u00052\b\u0010 \u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b,\u0010-J\u0017\u0010.\u001a\u00020\u00012\u0006\u0010 \u001a\u00020\rH\u0002¢\u0006\u0004\b.\u0010\"J\u000f\u00100\u001a\u00020/H\u0014¢\u0006\u0004\b0\u00101J\u0017\u00102\u001a\u00020\u00012\u0006\u0010 \u001a\u00020\rH\u0016¢\u0006\u0004\b2\u0010\"J!\u00105\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u0002032\b\u00104\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b5\u00106J)\u0010;\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u0002072\u0006\u00109\u001a\u0002082\b\u0010:\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b;\u0010<J\u0019\u0010=\u001a\u00020\r2\b\u0010 \u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b=\u0010>J(\u0010C\u001a\u00020@2\n\b\u0002\u0010?\u001a\u0004\u0018\u00010/2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\rH\u0080\b¢\u0006\u0004\bA\u0010BJ#\u0010D\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0014\u001a\u0002072\b\u0010:\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\bD\u0010EJ\u0019\u0010F\u001a\u0004\u0018\u0001082\u0006\u0010\u0014\u001a\u000203H\u0002¢\u0006\u0004\bF\u0010GJ\u0011\u0010H\u001a\u00060#j\u0002`$¢\u0006\u0004\bH\u0010IJ\u0013\u0010J\u001a\u00060#j\u0002`$H\u0016¢\u0006\u0004\bJ\u0010IJ\u0011\u0010M\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0004\bK\u0010LJ\u000f\u0010N\u001a\u0004\u0018\u00010\r¢\u0006\u0004\bN\u0010OJ'\u0010P\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0014\u001a\u0002072\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u000fH\u0002¢\u0006\u0004\bP\u0010QJ\u0019\u0010R\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0014\u001a\u000203H\u0002¢\u0006\u0004\bR\u0010SJ\u0017\u0010U\u001a\u00020\u00012\u0006\u0010T\u001a\u00020\rH\u0014¢\u0006\u0004\bU\u0010\"J\u0017\u0010W\u001a\u00020\u00112\u0006\u0010T\u001a\u00020\rH\u0010¢\u0006\u0004\bV\u0010+J\u0019\u0010Z\u001a\u00020\u00112\b\u0010Y\u001a\u0004\u0018\u00010XH\u0004¢\u0006\u0004\bZ\u0010[JF\u0010d\u001a\u00020c2\u0006\u0010\\\u001a\u00020\u00012\u0006\u0010]\u001a\u00020\u00012'\u0010b\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\r¢\u0006\f\b_\u0012\b\b`\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00110^j\u0002`a¢\u0006\u0004\bd\u0010eJ6\u0010d\u001a\u00020c2'\u0010b\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\r¢\u0006\f\b_\u0012\b\b`\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00110^j\u0002`a¢\u0006\u0004\bd\u0010fJ\u0013\u0010g\u001a\u00020\u0011H\u0086@ø\u0001\u0000¢\u0006\u0004\bg\u0010\u001dJ\u000f\u0010h\u001a\u00020\u0001H\u0002¢\u0006\u0004\bh\u0010iJ\u0013\u0010j\u001a\u00020\u0011H\u0082@ø\u0001\u0000¢\u0006\u0004\bj\u0010\u001dJ&\u0010m\u001a\u00020l2\u0014\u0010k\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00110^H\u0082\b¢\u0006\u0004\bm\u0010nJ\u001b\u0010o\u001a\u0004\u0018\u00010\u00052\b\u0010 \u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\bo\u0010-J\u0019\u0010q\u001a\u00020\u00012\b\u0010:\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0004\bp\u0010(J\u001b\u0010s\u001a\u0004\u0018\u00010\u00052\b\u0010:\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0004\br\u0010-J@\u0010t\u001a\u00020\t2'\u0010b\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\r¢\u0006\f\b_\u0012\b\b`\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00110^j\u0002`a2\u0006\u0010\\\u001a\u00020\u0001H\u0002¢\u0006\u0004\bt\u0010uJ\u000f\u0010w\u001a\u00020/H\u0010¢\u0006\u0004\bv\u00101J\u001f\u0010x\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\rH\u0002¢\u0006\u0004\bx\u0010yJ.\u0010{\u001a\u00020\u0011\"\n\b\u0000\u0010z\u0018\u0001*\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\b\u0010 \u001a\u0004\u0018\u00010\rH\u0082\b¢\u0006\u0004\b{\u0010yJ\u0019\u0010\\\u001a\u00020\u00112\b\u0010 \u001a\u0004\u0018\u00010\rH\u0014¢\u0006\u0004\b\\\u0010+J\u0019\u0010|\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005H\u0014¢\u0006\u0004\b|\u0010\u0016J\u000f\u0010}\u001a\u00020\u0011H\u0014¢\u0006\u0004\b}\u0010~J\u0019\u0010\u0081\u0001\u001a\u00020\u00112\u0007\u0010\u0080\u0001\u001a\u00020\u007f¢\u0006\u0006\b\u0081\u0001\u0010\u0082\u0001J\u001b\u0010\u0084\u0001\u001a\u00020\u00112\u0007\u0010\u0014\u001a\u00030\u0083\u0001H\u0002¢\u0006\u0006\b\u0084\u0001\u0010\u0085\u0001J\u001a\u0010\u0086\u0001\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\tH\u0002¢\u0006\u0006\b\u0086\u0001\u0010\u0087\u0001JI\u0010\u008c\u0001\u001a\u00020\u0011\"\u0005\b\u0000\u0010\u0088\u00012\u000e\u0010\u008a\u0001\u001a\t\u0012\u0004\u0012\u00028\u00000\u0089\u00012\u001d\u0010k\u001a\u0019\b\u0001\u0012\u000b\u0012\t\u0012\u0004\u0012\u00028\u00000\u008b\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00050^ø\u0001\u0000¢\u0006\u0006\b\u008c\u0001\u0010\u008d\u0001JX\u0010\u0091\u0001\u001a\u00020\u0011\"\u0004\b\u0000\u0010z\"\u0005\b\u0001\u0010\u0088\u00012\u000e\u0010\u008a\u0001\u001a\t\u0012\u0004\u0012\u00028\u00010\u0089\u00012$\u0010k\u001a \b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u000b\u0012\t\u0012\u0004\u0012\u00028\u00010\u008b\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u008e\u0001H\u0000ø\u0001\u0000¢\u0006\u0006\b\u008f\u0001\u0010\u0090\u0001J\u001a\u0010\u0093\u0001\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\tH\u0000¢\u0006\u0006\b\u0092\u0001\u0010\u0087\u0001JX\u0010\u0095\u0001\u001a\u00020\u0011\"\u0004\b\u0000\u0010z\"\u0005\b\u0001\u0010\u0088\u00012\u000e\u0010\u008a\u0001\u001a\t\u0012\u0004\u0012\u00028\u00010\u0089\u00012$\u0010k\u001a \b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u000b\u0012\t\u0012\u0004\u0012\u00028\u00010\u008b\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u008e\u0001H\u0000ø\u0001\u0000¢\u0006\u0006\b\u0094\u0001\u0010\u0090\u0001J\u000f\u0010\u0096\u0001\u001a\u00020\u0001¢\u0006\u0005\b\u0096\u0001\u0010iJ\u001d\u0010\u0098\u0001\u001a\u00030\u0097\u00012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0006\b\u0098\u0001\u0010\u0099\u0001J\u001c\u0010\u009a\u0001\u001a\u00020/2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0006\b\u009a\u0001\u0010\u009b\u0001J\u0011\u0010\u009c\u0001\u001a\u00020/H\u0007¢\u0006\u0005\b\u009c\u0001\u00101J\u0011\u0010\u009d\u0001\u001a\u00020/H\u0016¢\u0006\u0005\b\u009d\u0001\u00101J$\u0010\u009e\u0001\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u0002032\b\u00104\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0006\b\u009e\u0001\u0010\u009f\u0001J\"\u0010 \u0001\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u0002032\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0006\b \u0001\u0010¡\u0001J(\u0010¢\u0001\u001a\u0004\u0018\u00010\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u00052\b\u0010:\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0006\b¢\u0001\u0010£\u0001J&\u0010¤\u0001\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0014\u001a\u0002032\b\u0010:\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0006\b¤\u0001\u0010¥\u0001J-\u0010¦\u0001\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u0002072\u0006\u0010\u0018\u001a\u0002082\b\u0010:\u001a\u0004\u0018\u00010\u0005H\u0082\u0010¢\u0006\u0006\b¦\u0001\u0010§\u0001J\u0019\u0010©\u0001\u001a\u0004\u0018\u000108*\u00030¨\u0001H\u0002¢\u0006\u0006\b©\u0001\u0010ª\u0001J\u001f\u0010«\u0001\u001a\u00020\u0011*\u00020\u00072\b\u0010 \u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0005\b«\u0001\u0010yJ&\u0010¬\u0001\u001a\u00060#j\u0002`$*\u00020\r2\n\b\u0002\u0010?\u001a\u0004\u0018\u00010/H\u0004¢\u0006\u0006\b¬\u0001\u0010\u00ad\u0001R\u001b\u0010±\u0001\u001a\t\u0012\u0004\u0012\u00020X0®\u00018F¢\u0006\b\u001a\u0006\b¯\u0001\u0010°\u0001R\u0018\u0010³\u0001\u001a\u0004\u0018\u00010\r8DX\u0084\u0004¢\u0006\u0007\u001a\u0005\b²\u0001\u0010OR\u0016\u0010µ\u0001\u001a\u00020\u00018DX\u0084\u0004¢\u0006\u0007\u001a\u0005\b´\u0001\u0010iR\u0016\u0010·\u0001\u001a\u00020\u00018PX\u0090\u0004¢\u0006\u0007\u001a\u0005\b¶\u0001\u0010iR\u0016\u0010¸\u0001\u001a\u00020\u00018VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b¸\u0001\u0010iR\u0013\u0010¹\u0001\u001a\u00020\u00018F¢\u0006\u0007\u001a\u0005\b¹\u0001\u0010iR\u0013\u0010º\u0001\u001a\u00020\u00018F¢\u0006\u0007\u001a\u0005\bº\u0001\u0010iR\u0013\u0010»\u0001\u001a\u00020\u00018F¢\u0006\u0007\u001a\u0005\b»\u0001\u0010iR\u0016\u0010¼\u0001\u001a\u00020\u00018TX\u0094\u0004¢\u0006\u0007\u001a\u0005\b¼\u0001\u0010iR\u0019\u0010À\u0001\u001a\u0007\u0012\u0002\b\u00030½\u00018F¢\u0006\b\u001a\u0006\b¾\u0001\u0010¿\u0001R\u0016\u0010Â\u0001\u001a\u00020\u00018PX\u0090\u0004¢\u0006\u0007\u001a\u0005\bÁ\u0001\u0010iR\u0015\u0010Æ\u0001\u001a\u00030Ã\u00018F¢\u0006\b\u001a\u0006\bÄ\u0001\u0010Å\u0001R.\u0010Ì\u0001\u001a\u0004\u0018\u00010\u00192\t\u0010Ç\u0001\u001a\u0004\u0018\u00010\u00198@@@X\u0080\u000e¢\u0006\u0010\u001a\u0006\bÈ\u0001\u0010É\u0001\"\u0006\bÊ\u0001\u0010Ë\u0001R\u0017\u0010\u0014\u001a\u0004\u0018\u00010\u00058@X\u0080\u0004¢\u0006\u0007\u001a\u0005\bÍ\u0001\u0010LR\u001e\u0010Ï\u0001\u001a\u0004\u0018\u00010\r*\u0004\u0018\u00010\u00058BX\u0082\u0004¢\u0006\u0007\u001a\u0005\bÎ\u0001\u0010>R\u001b\u0010Ð\u0001\u001a\u00020\u0001*\u0002038BX\u0082\u0004¢\u0006\b\u001a\u0006\bÐ\u0001\u0010Ñ\u0001\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006Õ\u0001"}, d2 = {"Lkotlinx/coroutines/JobSupport;", "", "active", "<init>", "(Z)V", "", "expect", "Lkotlinx/coroutines/NodeList;", "list", "Lkotlinx/coroutines/JobNode;", "node", "addLastAtomic", "(Ljava/lang/Object;Lkotlinx/coroutines/NodeList;Lkotlinx/coroutines/JobNode;)Z", "", "rootCause", "", "exceptions", "", "addSuppressedExceptions", "(Ljava/lang/Throwable;Ljava/util/List;)V", "state", "afterCompletion", "(Ljava/lang/Object;)V", "Lkotlinx/coroutines/ChildJob;", "child", "Lkotlinx/coroutines/ChildHandle;", "attachChild", "(Lkotlinx/coroutines/ChildJob;)Lkotlinx/coroutines/ChildHandle;", "awaitInternal$kotlinx_coroutines_core", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitInternal", "awaitSuspend", "cause", "cancel", "(Ljava/lang/Throwable;)Z", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "(Ljava/util/concurrent/CancellationException;)V", "cancelCoroutine", "cancelImpl$kotlinx_coroutines_core", "(Ljava/lang/Object;)Z", "cancelImpl", "cancelInternal", "(Ljava/lang/Throwable;)V", "cancelMakeCompleting", "(Ljava/lang/Object;)Ljava/lang/Object;", "cancelParent", "", "cancellationExceptionMessage", "()Ljava/lang/String;", "childCancelled", "Lkotlinx/coroutines/Incomplete;", HealthModuleIds.UPDATE, "completeStateFinalization", "(Lkotlinx/coroutines/Incomplete;Ljava/lang/Object;)V", "Lkotlinx/coroutines/JobSupport$Finishing;", "Lkotlinx/coroutines/ChildHandleNode;", "lastChild", "proposedUpdate", "continueCompleting", "(Lkotlinx/coroutines/JobSupport$Finishing;Lkotlinx/coroutines/ChildHandleNode;Ljava/lang/Object;)V", "createCauseException", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "message", "Lkotlinx/coroutines/JobCancellationException;", "defaultCancellationException$kotlinx_coroutines_core", "(Ljava/lang/String;Ljava/lang/Throwable;)Lkotlinx/coroutines/JobCancellationException;", "defaultCancellationException", "finalizeFinishingState", "(Lkotlinx/coroutines/JobSupport$Finishing;Ljava/lang/Object;)Ljava/lang/Object;", "firstChild", "(Lkotlinx/coroutines/Incomplete;)Lkotlinx/coroutines/ChildHandleNode;", "getCancellationException", "()Ljava/util/concurrent/CancellationException;", "getChildJobCancellationCause", "getCompletedInternal$kotlinx_coroutines_core", "()Ljava/lang/Object;", "getCompletedInternal", "getCompletionExceptionOrNull", "()Ljava/lang/Throwable;", "getFinalRootCause", "(Lkotlinx/coroutines/JobSupport$Finishing;Ljava/util/List;)Ljava/lang/Throwable;", "getOrPromoteCancellingList", "(Lkotlinx/coroutines/Incomplete;)Lkotlinx/coroutines/NodeList;", "exception", "handleJobException", "handleOnCompletionException$kotlinx_coroutines_core", "handleOnCompletionException", "Lkotlinx/coroutines/Job;", "parent", "initParentJob", "(Lkotlinx/coroutines/Job;)V", "onCancelling", "invokeImmediately", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "handler", "Lkotlinx/coroutines/DisposableHandle;", "invokeOnCompletion", "(ZZLkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/DisposableHandle;", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/DisposableHandle;", "join", "joinInternal", "()Z", "joinSuspend", "block", "", "loopOnState", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Void;", "makeCancelling", "makeCompleting$kotlinx_coroutines_core", "makeCompleting", "makeCompletingOnce$kotlinx_coroutines_core", "makeCompletingOnce", "makeNode", "(Lkotlin/jvm/functions/Function1;Z)Lkotlinx/coroutines/JobNode;", "nameString$kotlinx_coroutines_core", "nameString", "notifyCancelling", "(Lkotlinx/coroutines/NodeList;Ljava/lang/Throwable;)V", ExifInterface.GPS_DIRECTION_TRUE, "notifyHandlers", "onCompletionInternal", AgentConstants.ON_START, "()V", "Lkotlinx/coroutines/ParentJob;", "parentJob", "parentCancelled", "(Lkotlinx/coroutines/ParentJob;)V", "Lkotlinx/coroutines/Empty;", "promoteEmptyToNodeList", "(Lkotlinx/coroutines/Empty;)V", "promoteSingleToNodeList", "(Lkotlinx/coroutines/JobNode;)V", "R", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "Lkotlin/coroutines/Continuation;", "registerSelectClause0", "(Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function1;)V", "Lkotlin/Function2;", "registerSelectClause1Internal$kotlinx_coroutines_core", "(Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function2;)V", "registerSelectClause1Internal", "removeNode$kotlinx_coroutines_core", "removeNode", "selectAwaitCompletion$kotlinx_coroutines_core", "selectAwaitCompletion", "start", "", "startInternal", "(Ljava/lang/Object;)I", "stateString", "(Ljava/lang/Object;)Ljava/lang/String;", "toDebugString", "toString", "tryFinalizeSimpleState", "(Lkotlinx/coroutines/Incomplete;Ljava/lang/Object;)Z", "tryMakeCancelling", "(Lkotlinx/coroutines/Incomplete;Ljava/lang/Throwable;)Z", "tryMakeCompleting", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "tryMakeCompletingSlowPath", "(Lkotlinx/coroutines/Incomplete;Ljava/lang/Object;)Ljava/lang/Object;", "tryWaitForChild", "(Lkotlinx/coroutines/JobSupport$Finishing;Lkotlinx/coroutines/ChildHandleNode;Ljava/lang/Object;)Z", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "nextChild", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Lkotlinx/coroutines/ChildHandleNode;", "notifyCompletion", "toCancellationException", "(Ljava/lang/Throwable;Ljava/lang/String;)Ljava/util/concurrent/CancellationException;", "Lkotlin/sequences/Sequence;", "getChildren", "()Lkotlin/sequences/Sequence;", "children", "getCompletionCause", "completionCause", "getCompletionCauseHandled", "completionCauseHandled", "getHandlesException$kotlinx_coroutines_core", "handlesException", "isActive", "isCancelled", "isCompleted", "isCompletedExceptionally", "isScopedCoroutine", "Lkotlin/coroutines/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "key", "getOnCancelComplete$kotlinx_coroutines_core", "onCancelComplete", "Lkotlinx/coroutines/selects/SelectClause0;", "getOnJoin", "()Lkotlinx/coroutines/selects/SelectClause0;", "onJoin", "value", "getParentHandle$kotlinx_coroutines_core", "()Lkotlinx/coroutines/ChildHandle;", "setParentHandle$kotlinx_coroutines_core", "(Lkotlinx/coroutines/ChildHandle;)V", "parentHandle", "getState$kotlinx_coroutines_core", "getExceptionOrNull", "exceptionOrNull", "isCancelling", "(Lkotlinx/coroutines/Incomplete;)Z", "AwaitContinuation", "ChildCompletion", "Finishing", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class JobSupport implements Job, ChildJob, ParentJob, SelectClause0 {
    private static final /* synthetic */ AtomicReferenceFieldUpdater _state$FU = null;
    private volatile /* synthetic */ Object _parentHandle;
    private volatile /* synthetic */ Object _state;

    /* JADX INFO: compiled from: JobSupport.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001b\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/JobSupport$AwaitContinuation;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CancellableContinuationImpl;", "delegate", "Lkotlin/coroutines/Continuation;", "job", "Lkotlinx/coroutines/JobSupport;", "(Lkotlin/coroutines/Continuation;Lkotlinx/coroutines/JobSupport;)V", "getContinuationCancellationCause", "", "parent", "Lkotlinx/coroutines/Job;", "nameString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
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
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\b\u0002\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0096\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lkotlinx/coroutines/JobSupport$ChildCompletion;", "Lkotlinx/coroutines/JobNode;", "parent", "Lkotlinx/coroutines/JobSupport;", "state", "Lkotlinx/coroutines/JobSupport$Finishing;", "child", "Lkotlinx/coroutines/ChildHandleNode;", "proposedUpdate", "", "(Lkotlinx/coroutines/JobSupport;Lkotlinx/coroutines/JobSupport$Finishing;Lkotlinx/coroutines/ChildHandleNode;Ljava/lang/Object;)V", "invoke", "", "cause", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
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
    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b\u0002\u0018\u00002\u00060\u0018j\u0002`,2\u00020-B!\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00050\rj\b\u0012\u0004\u0012\u00020\u0005`\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R(\u0010\u001e\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u00188B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0011\u0010!\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b!\u0010 R$\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u00038F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010 \"\u0004\b\"\u0010#R\u0011\u0010$\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b$\u0010 R\u001a\u0010\u0002\u001a\u00020\u00018\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0002\u0010%\u001a\u0004\b&\u0010'R(\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b(\u0010)\"\u0004\b*\u0010\f¨\u0006+"}, d2 = {"Lkotlinx/coroutines/JobSupport$Finishing;", "Lkotlinx/coroutines/NodeList;", "list", "", "isCompleting", "", "rootCause", "<init>", "(Lkotlinx/coroutines/NodeList;ZLjava/lang/Throwable;)V", "exception", "", "addExceptionLocked", "(Ljava/lang/Throwable;)V", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "allocateList", "()Ljava/util/ArrayList;", "proposedException", "", "sealLocked", "(Ljava/lang/Throwable;)Ljava/util/List;", "", "toString", "()Ljava/lang/String;", "", "value", "getExceptionsHolder", "()Ljava/lang/Object;", "setExceptionsHolder", "(Ljava/lang/Object;)V", "exceptionsHolder", "isActive", "()Z", "isCancelling", "setCompleting", "(Z)V", "isSealed", "Lkotlinx/coroutines/NodeList;", "getList", "()Lkotlinx/coroutines/NodeList;", "getRootCause", "()Ljava/lang/Throwable;", "setRootCause", "kotlinx-coroutines-core", "Lkotlinx/coroutines/internal/SynchronizedObject;", "Lkotlinx/coroutines/Incomplete;"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class Finishing implements Incomplete {
        private volatile /* synthetic */ Object _exceptionsHolder;
        private volatile /* synthetic */ int _isCompleting;
        private volatile /* synthetic */ Object _rootCause;
        private final NodeList list;

        @Override // kotlinx.coroutines.Incomplete
        public NodeList getList() {
            return this.list;
        }

        public Finishing(NodeList r1, boolean r2, Throwable r3) {
            this.list = r1;
            this._isCompleting = r2 ? 1 : 0;
            this._rootCause = r3;
            this._exceptionsHolder = null;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [boolean, int] */
        public final boolean isCompleting() {
            return this._isCompleting;
        }

        public final void setCompleting(boolean r1) {
            this._isCompleting = r1 ? 1 : 0;
        }

        public final Throwable getRootCause() {
            return (Throwable) this._rootCause;
        }

        public final void setRootCause(Throwable r1) {
            this._rootCause = r1;
        }

        private final Object getExceptionsHolder() {
            return this._exceptionsHolder;
        }

        private final void setExceptionsHolder(Object r1) {
            this._exceptionsHolder = r1;
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

    static {
        _state$FU = AtomicReferenceFieldUpdater.newUpdater(JobSupport.class, Object.class, "_state");
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
        this._parentHandle = null;
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
        return (ChildHandle) this._parentHandle;
    }

    public final void setParentHandle$kotlinx_coroutines_core(ChildHandle r1) {
        this._parentHandle = r1;
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
        if (DebugKt.getASSERTIONS_ENABLED() == false) goto L27;
        if (r8.isCompleting() == true) goto L27;
        throw new AssertionError();
    L27:
        if ((r9 instanceof CompletedExceptionally) == false) goto L29;
        CompletedExceptionally r2 = (CompletedExceptionally) r9;
    L30:
        if (r2 == null) goto L32;
        Throwable r3 = r2.cause;
    L33:
        monitor-enter(r8);
        boolean r4 = r8.isCancelling();     // Catch: Throwable -> L65
        List<Throwable> r5 = r8.sealLocked(r3);     // Catch: Throwable -> L65
        Throwable r6 = getFinalRootCause(r8, r5);     // Catch: Throwable -> L65
        if (r6 == null) goto L37;
        addSuppressedExceptions(r6, r5);     // Catch: Throwable -> L65
    L37:
        monitor-exit(r8);
        if (r6 == null) goto L43;
        if (r6 == r3) goto L43;
        r9 = new CompletedExceptionally(r6, false, 2, null);
    L43:
        if (r6 != null) goto L45;
    L55:
        if (r4 == true) goto L57;
        onCancelling(r6);
    L57:
        onCompletionInternal(r9);
        boolean r7 = b0$$ExternalSyntheticBackport0.m(_state$FU, this, r8, JobSupportKt.boxIncomplete(r9));
        if (DebugKt.getASSERTIONS_ENABLED() == false) goto L63;
        if (r7 == true) goto L63;
        throw new AssertionError();
    L63:
        completeStateFinalization(r8, r9);
        return r9;
    L45:
        if (cancelParent(r6) == false) goto L47;
    L50:
        if (r1 == false) goto L55;
        if (r9 == null) goto L54;
        ((CompletedExceptionally) r9).makeHandled();
        goto L55
    L54:
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
    L47:
        if (handleJobException(r6) == true) goto L50;
        r1 = false;
    L65:
        th = move-exception;
        throw th;
    L32:
        r3 = null;
        goto L33
    L29:
        r2 = null;
        goto L30
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
        if (b0$$ExternalSyntheticBackport0.m(_state$FU, this, r5, JobSupportKt.boxIncomplete(r6)) == true) goto L25;
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
        LockFreeLinkedListNode r0 = (LockFreeLinkedListNode) r9.getNext();
        CompletionHandlerException r1 = null;
    L4:
        if (Intrinsics.areEqual(r0, r9) == true) goto L17;
        if ((r0 instanceof JobCancellingNode) == false) goto L16;
        JobNode r2 = (JobNode) r0;
        r2.invoke(r8);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        CompletionHandlerException r4 = r1;
        if (r4 == null) goto L15;
        kotlin.ExceptionsKt.addSuppressed(r4, th);
        if (r4 != null) goto L16;
    L15:
        r1 = new CompletionHandlerException("Exception in completion handler " + r2 + " for " + this, th);
        Unit r3 = Unit.INSTANCE;
    L16:
        r0 = r0.getNextNode();
        goto L4
    L17:
        CompletionHandlerException r5 = r1;
        if (r5 == null) goto L20;
        handleOnCompletionException$kotlinx_coroutines_core(r5);
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
        LockFreeLinkedListNode r0 = (LockFreeLinkedListNode) r9.getNext();
        CompletionHandlerException r1 = null;
    L4:
        if (Intrinsics.areEqual(r0, r9) == true) goto L17;
        Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
        if ((r0 instanceof LockFreeLinkedListNode) == false) goto L16;
        JobNode r2 = (JobNode) r0;
        r2.invoke(r8);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        CompletionHandlerException r4 = r1;
        if (r4 == null) goto L15;
        kotlin.ExceptionsKt.addSuppressed(r4, th);
        if (r4 != null) goto L16;
    L15:
        r1 = new CompletionHandlerException("Exception in completion handler " + r2 + " for " + this, th);
        Unit r3 = Unit.INSTANCE;
    L16:
        r0 = r0.getNextNode();
        goto L4
    L17:
        CompletionHandlerException r5 = r1;
        if (r5 == null) goto L28;
        handleOnCompletionException$kotlinx_coroutines_core(r5);
        return;
    }

    private final int startInternal(Object r5) {
        if ((r5 instanceof Empty) == false) goto L13;
        if (((Empty) r5).isActive() == false) goto L8;
        return 0;
    L8:
        if (b0$$ExternalSyntheticBackport0.m(_state$FU, this, r5, JobSupportKt.access$getEMPTY_ACTIVE$p()) == true) goto L10;
        return -1;
    L10:
        onStart();
        return 1;
    L13:
        if ((r5 instanceof InactiveNodeList) == true) goto L15;
        return 0;
    L15:
        if (b0$$ExternalSyntheticBackport0.m(_state$FU, this, r5, ((InactiveNodeList) r5).getList()) == true) goto L17;
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
        if ((r1 instanceof Incomplete) == false) goto L55;
        NodeList r2 = ((Incomplete) r1).getList();
        if (r2 == null) goto L16;
        DisposableHandle r4 = NonDisposableHandle.INSTANCE;
        if (r7 == false) goto L46;
        if ((r1 instanceof Finishing) == false) goto L46;
        monitor-enter(r1);
        r3 = ((Finishing) r1).getRootCause();     // Catch: Throwable -> L43
        if (r3 == null) goto L32;
        if ((r9 instanceof ChildHandleNode) == false) goto L40;
        if (((Finishing) r1).isCompleting() == false) goto L32;
    L40:
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L43
        monitor-exit(r1);
    L32:
        if (addLastAtomic(r1, r2, r0) == false) goto L33;
        if (r3 == null) goto L36;
        r4 = r0;
        goto L40
    L36:
        JobNode r6 = r0;     // Catch: Throwable -> L43
        monitor-exit(r1);
        return r6;
    L33:
        monitor-exit(r1);
    L43:
        th = move-exception;
        throw th;
    L46:
        if (r3 != null) goto L47;
        if (addLastAtomic(r1, r2, r0) == false) goto L3;
        return r0;
    L47:
        if (r8 == false) goto L50;
        r9.invoke(r3);
    L50:
        return r4;
    L16:
        if (r1 == null) goto L19;
        promoteSingleToNodeList((JobNode) r1);
        goto L3
    L19:
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.JobNode");
    L55:
        if (r8 == false) goto L64;
        if ((r1 instanceof CompletedExceptionally) == false) goto L59;
        CompletedExceptionally r10 = (CompletedExceptionally) r1;
    L60:
        if (r10 == null) goto L62;
        r3 = r10.cause;
    L62:
        r9.invoke(r3);
        goto L64
    L59:
        r10 = null;
    L64:
        return NonDisposableHandle.INSTANCE;
    L5:
        Empty r11 = (Empty) r1;
        if (r11.isActive() == true) goto L8;
        promoteEmptyToNodeList(r11);
        goto L3
    L8:
        if (b0$$ExternalSyntheticBackport0.m(_state$FU, this, r1, r0) == false) goto L3;
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
        InactiveNodeList r1 = r0;
    L6:
        b0$$ExternalSyntheticBackport0.m(_state$FU, this, r3, r1);
        return;
    L5:
        r1 = new InactiveNodeList(r0);
        goto L6
    }

    private final void promoteSingleToNodeList(JobNode r3) {
        r3.addOneIfEmpty(new NodeList());
        LockFreeLinkedListNode r0 = r3.getNextNode();
        b0$$ExternalSyntheticBackport0.m(_state$FU, this, r3, r0);
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
        return this;
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
        if (r4 == null) goto L15;
        return r4;
    L15:
        return new JobCancellationException(access$cancellationExceptionMessage(this), null, this);
    L9:
        if (r3 == null) goto L13;
        return ((ParentJob) r3).getChildJobCancellationCause();
    L13:
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
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
        NodeList r2 = (NodeList) null;
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
        if (b0$$ExternalSyntheticBackport0.m(_state$FU, this, r6, new Finishing(r0, false, r7)) == true) goto L22;
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
        if (b0$$ExternalSyntheticBackport0.m(_state$FU, this, r9, r1) == true) goto L29;
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
        return (ChildHandle) Job.DefaultImpls.invokeOnCompletion$default(this, true, false, new ChildHandleNode(r7), 2, null);
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

    public final Object awaitInternal$kotlinx_coroutines_core(Continuation<Object> r3) {
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

    public final <T, R> void selectAwaitCompletion$kotlinx_coroutines_core(SelectInstance<? super R> r7, Function2<? super T, ? super Continuation<? super R>, ? extends Object> r8) {
        Object r6 = getState$kotlinx_coroutines_core();
        if ((r6 instanceof CompletedExceptionally) == false) goto L5;
        r7.resumeSelectWithException(((CompletedExceptionally) r6).cause);
        return;
    L5:
        CancellableKt.startCoroutineCancellable$default(r8, JobSupportKt.unboxState(r6), r7.getCompletion(), null, 4, null);
    }

    public final Object getState$kotlinx_coroutines_core() {
    L2:
        Object r0 = this._state;
        if ((r0 instanceof OpDescriptor) == false) goto L4;
        ((OpDescriptor) r0).perform(this);
        goto L2
    L4:
        return r0;
    }

    private final void notifyCompletion(NodeList r7, Throwable r8) {
        NodeList r9 = r7;
        LockFreeLinkedListNode r0 = (LockFreeLinkedListNode) r9.getNext();
        CompletionHandlerException r1 = null;
    L4:
        if (Intrinsics.areEqual(r0, r9) == true) goto L17;
        if ((r0 instanceof JobNode) == false) goto L16;
        JobNode r2 = (JobNode) r0;
        r2.invoke(r8);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        CompletionHandlerException r4 = r1;
        if (r4 == null) goto L15;
        kotlin.ExceptionsKt.addSuppressed(r4, th);
        if (r4 != null) goto L16;
    L15:
        r1 = new CompletionHandlerException("Exception in completion handler " + r2 + " for " + this, th);
        Unit r3 = Unit.INSTANCE;
    L16:
        r0 = r0.getNextNode();
        goto L4
    L17:
        CompletionHandlerException r5 = r1;
        if (r5 == null) goto L28;
        handleOnCompletionException$kotlinx_coroutines_core(r5);
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

    @Override // kotlinx.coroutines.selects.SelectClause0
    public final <R> void registerSelectClause0(SelectInstance<? super R> r3, Function1<? super Continuation<? super R>, ? extends Object> r4) {
    L2:
        Object r0 = getState$kotlinx_coroutines_core();
        if (r3.isSelected() == true) goto L4;
        if ((r0 instanceof Incomplete) == false) goto L8;
        if (startInternal(r0) != 0) goto L2;
        r3.disposeOnSelect(invokeOnCompletion(new SelectJoinOnCompletion(r3, r4)));
        return;
    L8:
        if (r3.trySelect() == false) goto L19;
        UndispatchedKt.startCoroutineUnintercepted(r4, r3.getCompletion());
        return;
    L19:
        return;
    }

    public final void removeNode$kotlinx_coroutines_core(JobNode r4) {
    L2:
        Object r0 = getState$kotlinx_coroutines_core();
        if ((r0 instanceof JobNode) == false) goto L10;
        if (r0 != r4) goto L5;
        if (b0$$ExternalSyntheticBackport0.m(_state$FU, this, r0, JobSupportKt.access$getEMPTY_ACTIVE$p()) == false) goto L2;
        return;
    L5:
        return;
    L10:
        if ((r0 instanceof Incomplete) == true) goto L12;
        return;
    L12:
        if (((Incomplete) r0).getList() == null) goto L20;
        r4.mo2325remove();
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
        Object r1 = tryMakeCompleting(r0, new CompletedExceptionally(createCauseException(r7), false, 2, null));
        if (r1 == JobSupportKt.access$getCOMPLETING_RETRY$p()) goto L2;
        return r1;
    L7:
        if (((Finishing) r0).isCompleting() == false) goto L9;
    L13:
        return JobSupportKt.access$getCOMPLETING_ALREADY$p();
    }

    private final Object makeCancelling(Object r7) {
        Throwable r0 = null;
        Throwable r1 = null;
    L3:
        Object r2 = getState$kotlinx_coroutines_core();
        if ((r2 instanceof Finishing) == true) goto L5;
        if ((r2 instanceof Incomplete) == false) goto L47;
        if (r1 != null) goto L33;
        r1 = createCauseException(r7);
    L33:
        Incomplete r3 = (Incomplete) r2;
        if (r3.isActive() == true) goto L36;
        Object r4 = tryMakeCompleting(r2, new CompletedExceptionally(r1, false, 2, null));
        if (r4 == JobSupportKt.access$getCOMPLETING_ALREADY$p()) goto L45;
        if (r4 == JobSupportKt.access$getCOMPLETING_RETRY$p()) goto L3;
        return r4;
    L45:
        throw new IllegalStateException(("Cannot happen in " + r2).toString());
    L36:
        if (tryMakeCancelling(r3, r1) == false) goto L3;
        return JobSupportKt.access$getCOMPLETING_ALREADY$p();
    L47:
        return JobSupportKt.access$getTOO_LATE_TO_CANCEL$p();
    L5:
        monitor-enter(r2);
    L26:
        th = move-exception;
        throw th;
    L7:
        if (((Finishing) r2).isSealed() == false) goto L11;
        Symbol r6 = JobSupportKt.access$getTOO_LATE_TO_CANCEL$p();     // Catch: Throwable -> L26
        monitor-exit(r2);
        return r6;
    L11:
        boolean r5 = ((Finishing) r2).isCancelling();     // Catch: Throwable -> L26
        if (r7 != null) goto L14;
        if (r5 == false) goto L14;
    L17:
        Throwable r8 = ((Finishing) r2).getRootCause();     // Catch: Throwable -> L26
        if ((!r5) == false) goto L21;
        r0 = r8;
    L21:
        monitor-exit(r2);
        if (r0 == null) goto L25;
        notifyCancelling(((Finishing) r2).getList(), r0);
    L25:
        return JobSupportKt.access$getCOMPLETING_ALREADY$p();
    L14:
        if (r1 != null) goto L16;
        r1 = createCauseException(r7);     // Catch: Throwable -> L26
    L16:
        ((Finishing) r2).addExceptionLocked(r1);     // Catch: Throwable -> L26
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

    public final <T, R> void registerSelectClause1Internal$kotlinx_coroutines_core(SelectInstance<? super R> r3, Function2<? super T, ? super Continuation<? super R>, ? extends Object> r4) {
    L2:
        Object r0 = getState$kotlinx_coroutines_core();
        if (r3.isSelected() == true) goto L4;
        if ((r0 instanceof Incomplete) == false) goto L8;
        if (startInternal(r0) != 0) goto L2;
        r3.disposeOnSelect(invokeOnCompletion(new SelectAwaitOnCompletion(r3, r4)));
        return;
    L8:
        if (r3.trySelect() == true) goto L10;
        return;
    L10:
        if ((r0 instanceof CompletedExceptionally) == false) goto L12;
        r3.resumeSelectWithException(((CompletedExceptionally) r0).cause);
        return;
    L12:
        UndispatchedKt.startCoroutineUnintercepted(r4, JobSupportKt.unboxState(r0), r3.getCompletion());
        return;
    }
}
