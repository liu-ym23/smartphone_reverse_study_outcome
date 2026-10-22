package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import com.bytedanceos.security.Utils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: compiled from: Deprecated.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u001f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aJ\u0010\u0000\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001j\u0002`\u00072\u001a\u0010\b\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\n0\t\"\u0006\u0012\u0002\b\u00030\nH\u0001¢\u0006\u0002\u0010\u000b\u001a!\u0010\f\u001a\u00020\r\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\nH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a1\u0010\u0010\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001j\u0002`\u0007*\u0006\u0012\u0002\b\u00030\nH\u0001\u001a!\u0010\u0011\u001a\u00020\u0012\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\nH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a\u001e\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u000e0\n\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\nH\u0007\u001aZ\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u000e0\n\"\u0004\b\u0000\u0010\u000e\"\u0004\b\u0001\u0010\u0015*\b\u0012\u0004\u0012\u0002H\u000e0\n2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\"\u0010\u0018\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00150\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0019H\u0001ø\u0001\u0000¢\u0006\u0002\u0010\u001c\u001a0\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u000e0\n\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\n2\u0006\u0010\u001e\u001a\u00020\u00122\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0007\u001aT\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\n\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\n2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\"\u0010 \u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0019H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u001c\u001a)\u0010!\u001a\u0002H\u000e\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\n2\u0006\u0010\"\u001a\u00020\u0012H\u0087@ø\u0001\u0000¢\u0006\u0002\u0010#\u001a+\u0010$\u001a\u0004\u0018\u0001H\u000e\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\n2\u0006\u0010\"\u001a\u00020\u0012H\u0087@ø\u0001\u0000¢\u0006\u0002\u0010#\u001aT\u0010%\u001a\b\u0012\u0004\u0012\u0002H\u000e0\n\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\n2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\"\u0010 \u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0019H\u0001ø\u0001\u0000¢\u0006\u0002\u0010\u001c\u001ai\u0010&\u001a\b\u0012\u0004\u0012\u0002H\u000e0\n\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\n2\b\b\u0002\u0010\u0016\u001a\u00020\u001727\u0010 \u001a3\b\u0001\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\"\u0012\u0004\u0012\u0002H\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0'H\u0007ø\u0001\u0000¢\u0006\u0002\u0010(\u001aT\u0010)\u001a\b\u0012\u0004\u0012\u0002H\u000e0\n\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\n2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\"\u0010 \u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0019H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u001c\u001a$\u0010*\u001a\b\u0012\u0004\u0012\u0002H\u000e0\n\"\b\b\u0000\u0010\u000e*\u00020\u001b*\n\u0012\u0006\u0012\u0004\u0018\u0001H\u000e0\nH\u0001\u001aA\u0010+\u001a\u0002H,\"\b\b\u0000\u0010\u000e*\u00020\u001b\"\u0010\b\u0001\u0010,*\n\u0012\u0006\b\u0000\u0012\u0002H\u000e0-*\n\u0012\u0006\u0012\u0004\u0018\u0001H\u000e0\n2\u0006\u0010.\u001a\u0002H,H\u0087@ø\u0001\u0000¢\u0006\u0002\u0010/\u001a?\u0010+\u001a\u0002H,\"\b\b\u0000\u0010\u000e*\u00020\u001b\"\u000e\b\u0001\u0010,*\b\u0012\u0004\u0012\u0002H\u000e00*\n\u0012\u0006\u0012\u0004\u0018\u0001H\u000e0\n2\u0006\u0010.\u001a\u0002H,H\u0087@ø\u0001\u0000¢\u0006\u0002\u00101\u001a!\u00102\u001a\u0002H\u000e\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\nH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a#\u00103\u001a\u0004\u0018\u0001H\u000e\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\nH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a`\u00104\u001a\b\u0012\u0004\u0012\u0002H50\n\"\u0004\b\u0000\u0010\u000e\"\u0004\b\u0001\u00105*\b\u0012\u0004\u0012\u0002H\u000e0\n2\b\b\u0002\u0010\u0016\u001a\u00020\u00172(\u00106\u001a$\b\u0001\u0012\u0004\u0012\u0002H\u000e\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H50\n0\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0019H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u001c\u001a)\u00107\u001a\u00020\u0012\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\n2\u0006\u00108\u001a\u0002H\u000eH\u0087@ø\u0001\u0000¢\u0006\u0002\u00109\u001a!\u0010:\u001a\u0002H\u000e\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\nH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a)\u0010;\u001a\u00020\u0012\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\n2\u0006\u00108\u001a\u0002H\u000eH\u0087@ø\u0001\u0000¢\u0006\u0002\u00109\u001a#\u0010<\u001a\u0004\u0018\u0001H\u000e\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\nH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001aZ\u0010=\u001a\b\u0012\u0004\u0012\u0002H50\n\"\u0004\b\u0000\u0010\u000e\"\u0004\b\u0001\u00105*\b\u0012\u0004\u0012\u0002H\u000e0\n2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\"\u00106\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H50\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0019H\u0001ø\u0001\u0000¢\u0006\u0002\u0010\u001c\u001ao\u0010>\u001a\b\u0012\u0004\u0012\u0002H50\n\"\u0004\b\u0000\u0010\u000e\"\u0004\b\u0001\u00105*\b\u0012\u0004\u0012\u0002H\u000e0\n2\b\b\u0002\u0010\u0016\u001a\u00020\u001727\u00106\u001a3\b\u0001\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\"\u0012\u0004\u0012\u0002H\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H50\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0'H\u0001ø\u0001\u0000¢\u0006\u0002\u0010(\u001au\u0010?\u001a\b\u0012\u0004\u0012\u0002H50\n\"\u0004\b\u0000\u0010\u000e\"\b\b\u0001\u00105*\u00020\u001b*\b\u0012\u0004\u0012\u0002H\u000e0\n2\b\b\u0002\u0010\u0016\u001a\u00020\u001729\u00106\u001a5\b\u0001\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\"\u0012\u0004\u0012\u0002H\u000e\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u0001H50\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0'H\u0007ø\u0001\u0000¢\u0006\u0002\u0010(\u001a`\u0010@\u001a\b\u0012\u0004\u0012\u0002H50\n\"\u0004\b\u0000\u0010\u000e\"\b\b\u0001\u00105*\u00020\u001b*\b\u0012\u0004\u0012\u0002H\u000e0\n2\b\b\u0002\u0010\u0016\u001a\u00020\u00172$\u00106\u001a \b\u0001\u0012\u0004\u0012\u0002H\u000e\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u0001H50\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0019H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u001c\u001a?\u0010A\u001a\u0004\u0018\u0001H\u000e\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\n2\u001a\u0010B\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u000e0Cj\n\u0012\u0006\b\u0000\u0012\u0002H\u000e`DH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010E\u001a?\u0010F\u001a\u0004\u0018\u0001H\u000e\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\n2\u001a\u0010B\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u000e0Cj\n\u0012\u0006\b\u0000\u0012\u0002H\u000e`DH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010E\u001a!\u0010G\u001a\u00020\r\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\nH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a$\u0010H\u001a\b\u0012\u0004\u0012\u0002H\u000e0\n\"\b\b\u0000\u0010\u000e*\u00020\u001b*\n\u0012\u0006\u0012\u0004\u0018\u0001H\u000e0\nH\u0007\u001a!\u0010I\u001a\u0002H\u000e\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\nH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a#\u0010J\u001a\u0004\u0018\u0001H\u000e\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\nH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a0\u0010K\u001a\b\u0012\u0004\u0012\u0002H\u000e0\n\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\n2\u0006\u0010\u001e\u001a\u00020\u00122\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0007\u001aT\u0010L\u001a\b\u0012\u0004\u0012\u0002H\u000e0\n\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\n2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\"\u0010 \u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0019H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u001c\u001a9\u0010M\u001a\u0002H,\"\u0004\b\u0000\u0010\u000e\"\u000e\b\u0001\u0010,*\b\u0012\u0004\u0012\u0002H\u000e00*\b\u0012\u0004\u0012\u0002H\u000e0\n2\u0006\u0010.\u001a\u0002H,H\u0081@ø\u0001\u0000¢\u0006\u0002\u00101\u001a;\u0010N\u001a\u0002H,\"\u0004\b\u0000\u0010\u000e\"\u0010\b\u0001\u0010,*\n\u0012\u0006\b\u0000\u0012\u0002H\u000e0-*\b\u0012\u0004\u0012\u0002H\u000e0\n2\u0006\u0010.\u001a\u0002H,H\u0081@ø\u0001\u0000¢\u0006\u0002\u0010/\u001a?\u0010O\u001a\u000e\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002HQ0P\"\u0004\b\u0000\u0010\u0015\"\u0004\b\u0001\u0010Q*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002HQ0R0\nH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001aU\u0010O\u001a\u0002HS\"\u0004\b\u0000\u0010\u0015\"\u0004\b\u0001\u0010Q\"\u0018\b\u0002\u0010S*\u0012\u0012\u0006\b\u0000\u0012\u0002H\u0015\u0012\u0006\b\u0000\u0012\u0002HQ0T*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002HQ0R0\n2\u0006\u0010.\u001a\u0002HSH\u0081@ø\u0001\u0000¢\u0006\u0002\u0010U\u001a'\u0010V\u001a\b\u0012\u0004\u0012\u0002H\u000e0W\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\nH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a'\u0010X\u001a\b\u0012\u0004\u0012\u0002H\u000e0Y\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\nH\u0081@ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a'\u0010Z\u001a\b\u0012\u0004\u0012\u0002H\u000e0[\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\nH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a.\u0010\\\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000e0]0\n\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\n2\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0007\u001a?\u0010^\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H50R0\n\"\u0004\b\u0000\u0010\u000e\"\u0004\b\u0001\u00105*\b\u0012\u0004\u0012\u0002H\u000e0\n2\f\u0010_\u001a\b\u0012\u0004\u0012\u0002H50\nH\u0087\u0004\u001az\u0010^\u001a\b\u0012\u0004\u0012\u0002HQ0\n\"\u0004\b\u0000\u0010\u000e\"\u0004\b\u0001\u00105\"\u0004\b\u0002\u0010Q*\b\u0012\u0004\u0012\u0002H\u000e0\n2\f\u0010_\u001a\b\u0012\u0004\u0012\u0002H50\n2\b\b\u0002\u0010\u0016\u001a\u00020\u001726\u00106\u001a2\u0012\u0013\u0012\u0011H\u000e¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(`\u0012\u0013\u0012\u0011H5¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(a\u0012\u0004\u0012\u0002HQ0\u0019H\u0001\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006b"}, d2 = {"consumesAll", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "Lkotlinx/coroutines/CompletionHandler;", "channels", "", "Lkotlinx/coroutines/channels/ReceiveChannel;", "([Lkotlinx/coroutines/channels/ReceiveChannel;)Lkotlin/jvm/functions/Function1;", "any", "", ExifInterface.LONGITUDE_EAST, "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "consumes", "count", "", "distinct", "distinctBy", "K", "context", "Lkotlin/coroutines/CoroutineContext;", "selector", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/channels/ReceiveChannel;", "drop", "n", "dropWhile", "predicate", "elementAt", Utils.INTENT_KEY_INDEX, "(Lkotlinx/coroutines/channels/ReceiveChannel;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "elementAtOrNull", "filter", "filterIndexed", "Lkotlin/Function3;", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/channels/ReceiveChannel;", "filterNot", "filterNotNull", "filterNotNullTo", "C", "", "destination", "(Lkotlinx/coroutines/channels/ReceiveChannel;Ljava/util/Collection;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/SendChannel;", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlinx/coroutines/channels/SendChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "first", "firstOrNull", "flatMap", "R", "transform", "indexOf", "element", "(Lkotlinx/coroutines/channels/ReceiveChannel;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "last", "lastIndexOf", "lastOrNull", "map", "mapIndexed", "mapIndexedNotNull", "mapNotNull", "maxWith", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "(Lkotlinx/coroutines/channels/ReceiveChannel;Ljava/util/Comparator;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "minWith", "none", "requireNoNulls", "single", "singleOrNull", "take", "takeWhile", "toChannel", "toCollection", "toMap", "", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/Pair;", "M", "", "(Lkotlinx/coroutines/channels/ReceiveChannel;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toMutableList", "", "toMutableSet", "", "toSet", "", "withIndex", "Lkotlin/collections/IndexedValue;", "zip", "other", "a", "b", "kotlinx-coroutines-core"}, k = 5, mv = {1, 6, 0}, xi = 48, xs = "kotlinx/coroutines/channels/ChannelsKt")
final /* synthetic */ class ChannelsKt__DeprecatedKt {

    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$any$1, reason: invalid class name */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0}, l = {404}, m = "any", n = {"$this$consume$iv"}, s = {"L$0"})
    static final class AnonymousClass1<E> extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> r1) {
            super(r1);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return ChannelsKt.any(null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$count$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0}, l = {487}, m = "count", n = {"count", "$this$consume$iv$iv"}, s = {"L$0", "L$1"})
    static final class C04471<E> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C04471(Continuation<? super C04471> r1) {
            super(r1);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return ChannelsKt.count(null, this);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$distinct$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(d1 = {"\u0000\u0004\n\u0002\b\u0003\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u0002H\u0001H\u008a@"}, d2 = {"<anonymous>", ExifInterface.LONGITUDE_EAST, "it"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$distinct$1", f = "Deprecated.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C04481<E> extends SuspendLambda implements Function2<E, Continuation<? super E>, Object> {
        /* synthetic */ Object L$0;
        int label;

        C04481(Continuation<? super C04481> r2) {
            super(2, r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            C04481 r0 = new C04481(r2);
            r0.L$0 = r1;
            return r0;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke(r1, (Continuation) r2);
        }

        public final Object invoke(E r1, Continuation<? super E> r2) {
            return ((C04481) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            return this.L$0;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$distinctBy$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.LONGITUDE_EAST, "K", "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$distinctBy$1", f = "Deprecated.kt", i = {0, 0, 1, 1, 1, 2, 2, 2}, l = {387, 388, 390}, m = "invokeSuspend", n = {"$this$produce", "keys", "$this$produce", "keys", "e", "$this$produce", "keys", "k"}, s = {"L$0", "L$1", "L$0", "L$1", "L$3", "L$0", "L$1", "L$3"})
    static final class C04491<E> extends SuspendLambda implements Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<E, Continuation<? super K>, Object> $selector;
        final /* synthetic */ ReceiveChannel<E> $this_distinctBy;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        C04491(ReceiveChannel<? extends E> r1, Function2<? super E, ? super Continuation<? super K>, ? extends Object> r2, Continuation<? super C04491> r3) {
            this.$this_distinctBy = r1;
            this.$selector = r2;
            super(2, r3);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            C04491 r0 = new C04491(this.$this_distinctBy, this.$selector, r4);
            r0.L$0 = r3;
            return r0;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object r1, Continuation<? super Unit> r2) {
            return invoke((ProducerScope) r1, r2);
        }

        public final Object invoke(ProducerScope<? super E> r1, Continuation<? super Unit> r2) {
            return ((C04491) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r11v13, types: [java.util.Collection] */
        /* JADX WARN: Type inference failed for: r6v0 */
        /* JADX WARN: Type inference failed for: r6v14 */
        /* JADX WARN: Type inference failed for: r6v15 */
        /* JADX WARN: Type inference failed for: r6v2, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r6v4, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r6v6 */
        /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.Object, kotlinx.coroutines.channels.ProducerScope] */
        /* JADX WARN: Type inference failed for: r7v11 */
        /* JADX WARN: Type inference failed for: r7v12 */
        /* JADX WARN: Type inference failed for: r7v13 */
        /* JADX WARN: Type inference failed for: r7v14 */
        /* JADX WARN: Type inference failed for: r7v15 */
        /* JADX WARN: Type inference failed for: r7v3 */
        /* JADX WARN: Type inference failed for: r7v5 */
        /* JADX WARN: Type inference failed for: r7v6 */
        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x00a4 -> B:29:0x00c3). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x00ba -> B:28:0x00bc). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$distinctBy$1<E> for r10v3 'this'  java.lang.Object
            	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
            	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
            	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
            	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
            	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r11) {
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = r10.label;
            if (r1 == 0) goto L12;
            if (r1 == 1) goto L11;
            if (r1 == 2) goto L10;
            if (r1 != 3) goto L8;
            java.lang.Object r1 = r10.L$3;
            java.lang.Object r5 = r10.L$2;
            kotlinx.coroutines.channels.ChannelIterator<E> r5 = (kotlinx.coroutines.channels.ChannelIterator) r5;
            java.lang.Object r6 = r10.L$1;
            java.util.HashSet r6 = (java.util.HashSet) r6;
            java.lang.Object r7 = r10.L$0;
            kotlinx.coroutines.channels.ProducerScope r7 = (kotlinx.coroutines.channels.ProducerScope) r7;
            kotlin.ResultKt.throwOnFailure(r11);
            ?? r7 = r7;
        L28:
            java.util.HashSet r11 = r6;
            java.util.HashSet r11 = r11;
            r11.add(r1);
            kotlinx.coroutines.channels.ChannelIterator<E> r1 = r5;
            ?? r7 = r7;
        L29:
            java.util.HashSet r5 = r6;
            ?? r6 = r7;
        L13:
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.C04491<E> r11 = r10;
            r10.L$0 = r6;
            r10.L$1 = r5;
            r10.L$2 = r1;
            r10.L$3 = null;
            r10.label = 1;
            r11 = r1.hasNext(r11);
            ?? r6 = r6;
            if (r11 != r0) goto L16;
            return r0;
        L16:
            java.lang.Boolean r11 = (java.lang.Boolean) r11;
            boolean r11 = r11.booleanValue();
            if (r11 == false) goto L30;
            E r11 = r1.next();
            kotlin.jvm.functions.Function2 r7 = r10.$selector;
            r10.L$0 = r6;
            r10.L$1 = r5;
            r10.L$2 = r1;
            r10.L$3 = r11;
            r10.label = 2;
            java.lang.Object r10 = (kotlin.coroutines.Continuation<? super K>) r10;
            java.lang.Object r7 = r7.invoke(r11, r10);
            if (r7 != r0) goto L21;
            return r0;
        L21:
            java.util.HashSet r9 = r5;
            java.lang.Object r5 = r11;
            r11 = r7;
            ?? r7 = r6;
            r6 = r9;
        L22:
            boolean r8 = r6.contains(r11);
            r7 = r7;
            if (r8 == true) goto L29;
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.C04491<E> r8 = (kotlin.coroutines.Continuation) r10;
            r10.L$0 = r7;
            r10.L$1 = r6;
            r10.L$2 = r1;
            r10.L$3 = r11;
            r10.label = 3;
            java.lang.Object r5 = r7.send(r5, r8);
            if (r5 != r0) goto L27;
            return r0;
        L27:
            r5 = r1;
            r1 = r11;
            r7 = r7;
            goto L28
        L30:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE;
            return r10;
        L8:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            throw r10;
        L10:
            java.lang.Object r1 = r10.L$3;
            java.lang.Object r5 = r10.L$2;
            kotlinx.coroutines.channels.ChannelIterator<E> r5 = (kotlinx.coroutines.channels.ChannelIterator) r5;
            java.lang.Object r6 = r10.L$1;
            r6 = (java.util.HashSet) r6;
            java.lang.Object r7 = r10.L$0;
            kotlinx.coroutines.channels.ProducerScope r7 = (kotlinx.coroutines.channels.ProducerScope) r7;
            kotlin.ResultKt.throwOnFailure(r11);
            r5 = r1;
            r1 = r5;
            r7 = r7;
            goto L22
        L11:
            java.lang.Object r1 = r10.L$2;
            r1 = (kotlinx.coroutines.channels.ChannelIterator) r1;
            java.lang.Object r5 = r10.L$1;
            r5 = (java.util.HashSet) r5;
            java.lang.Object r6 = r10.L$0;
            kotlinx.coroutines.channels.ProducerScope r6 = (kotlinx.coroutines.channels.ProducerScope) r6;
            kotlin.ResultKt.throwOnFailure(r11);
            r6 = r6;
            goto L16
        L12:
            kotlin.ResultKt.throwOnFailure(r11);
            java.lang.Object r11 = r10.L$0;
            kotlinx.coroutines.channels.ProducerScope r11 = (kotlinx.coroutines.channels.ProducerScope) r11;
            java.util.HashSet r1 = new java.util.HashSet();
            kotlinx.coroutines.channels.ReceiveChannel<E> r5 = r10.$this_distinctBy;
            kotlinx.coroutines.channels.ChannelIterator<E> r5 = r5.iterator();
            r6 = r11;
            r5 = r1;
            r1 = r5;
            goto L13
        }
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$drop$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$drop$1", f = "Deprecated.kt", i = {0, 0, 1, 2}, l = {164, 169, 170}, m = "invokeSuspend", n = {"$this$produce", "remaining", "$this$produce", "$this$produce"}, s = {"L$0", "I$0", "L$0", "L$0"})
    static final class C04501<E> extends SuspendLambda implements Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $n;
        final /* synthetic */ ReceiveChannel<E> $this_drop;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        C04501(int r1, ReceiveChannel<? extends E> r2, Continuation<? super C04501> r3) {
            this.$n = r1;
            this.$this_drop = r2;
            super(2, r3);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            C04501 r0 = new C04501(this.$n, this.$this_drop, r4);
            r0.L$0 = r3;
            return r0;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object r1, Continuation<? super Unit> r2) {
            return invoke((ProducerScope) r1, r2);
        }

        public final Object invoke(ProducerScope<? super E> r1, Continuation<? super Unit> r2) {
            return ((C04501) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0068 -> B:23:0x006b). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x00ad -> B:8:0x001c). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r9) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L13;
            if (r1 == 1) goto L12;
            if (r1 == 2) goto L11;
            if (r1 != 3) goto L10;
            ChannelIterator<E> r2 = (ChannelIterator) this.L$1;
            ProducerScope r4 = (ProducerScope) this.L$0;
            ResultKt.throwOnFailure(r9);
        L8:
            ProducerScope r10 = r4;
        L29:
            this.L$0 = r10;
            this.L$1 = r2;
            this.label = 2;
            Object r5 = r2.hasNext(this);
            if (r5 != r0) goto L32;
            return r0;
        L32:
            r4 = r10;
            r9 = r5;
        L34:
            if (((Boolean) r9).booleanValue() == false) goto L39;
            this.L$0 = r4;
            this.L$1 = r2;
            this.label = 3;
            if (r4.send(r2.next(), this) != r0) goto L8;
            return r0;
        L39:
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            r2 = (ChannelIterator) this.L$1;
            r4 = (ProducerScope) this.L$0;
            ResultKt.throwOnFailure(r9);
            goto L34
        L12:
            int r3 = this.I$0;
            ChannelIterator<E> r6 = (ChannelIterator) this.L$1;
            ProducerScope r7 = (ProducerScope) this.L$0;
            ResultKt.throwOnFailure(r9);
        L24:
            if (((Boolean) r9).booleanValue() == false) goto L27;
            r6.next();
            r3 = r3 - 1;
            if (r3 == 0) goto L27;
        L20:
            this.L$0 = r7;
            this.L$1 = r6;
            this.I$0 = r3;
            this.label = 1;
            r9 = r6.hasNext(this);
            if (r9 != r0) goto L24;
            return r0;
        L27:
            r10 = r7;
        L28:
            r2 = this.$this_drop.iterator();
            goto L29
        L13:
            ResultKt.throwOnFailure(r9);
            r10 = (ProducerScope) this.L$0;
            r3 = this.$n;
            if (r3 < 0) goto L16;
            boolean r8 = true;
        L17:
            if (r8 == false) goto L41;
            if (r3 <= 0) goto L28;
            r6 = this.$this_drop.iterator();
            r7 = r10;
            goto L20
        L41:
            throw new IllegalArgumentException(("Requested element count " + r3 + " is less than zero.").toString());
        L16:
            r8 = false;
            goto L17
        }
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$dropWhile$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$dropWhile$1", f = "Deprecated.kt", i = {0, 1, 1, 2, 3, 4}, l = {181, 182, 183, 187, 188}, m = "invokeSuspend", n = {"$this$produce", "$this$produce", "e", "$this$produce", "$this$produce", "$this$produce"}, s = {"L$0", "L$0", "L$2", "L$0", "L$0", "L$0"})
    static final class C04511<E> extends SuspendLambda implements Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<E, Continuation<? super Boolean>, Object> $predicate;
        final /* synthetic */ ReceiveChannel<E> $this_dropWhile;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        C04511(ReceiveChannel<? extends E> r1, Function2<? super E, ? super Continuation<? super Boolean>, ? extends Object> r2, Continuation<? super C04511> r3) {
            this.$this_dropWhile = r1;
            this.$predicate = r2;
            super(2, r3);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            C04511 r0 = new C04511(this.$this_dropWhile, this.$predicate, r4);
            r0.L$0 = r3;
            return r0;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object r1, Continuation<? super Unit> r2) {
            return invoke((ProducerScope) r1, r2);
        }

        public final Object invoke(ProducerScope<? super E> r1, Continuation<? super Unit> r2) {
            return ((C04511) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r10v0 */
        /* JADX WARN: Type inference failed for: r10v3 */
        /* JADX WARN: Type inference failed for: r1v10, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r1v13 */
        /* JADX WARN: Type inference failed for: r1v23 */
        /* JADX WARN: Type inference failed for: r1v24 */
        /* JADX WARN: Type inference failed for: r1v25 */
        /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r1v7 */
        /* JADX WARN: Type inference failed for: r1v8 */
        /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object, kotlinx.coroutines.channels.ProducerScope] */
        /* JADX WARN: Type inference failed for: r4v11 */
        /* JADX WARN: Type inference failed for: r4v12 */
        /* JADX WARN: Type inference failed for: r4v13 */
        /* JADX WARN: Type inference failed for: r4v5 */
        /* JADX WARN: Type inference failed for: r4v6 */
        /* JADX WARN: Type inference failed for: r8v0 */
        /* JADX WARN: Type inference failed for: r8v1 */
        /* JADX WARN: Type inference failed for: r8v12 */
        /* JADX WARN: Type inference failed for: r8v13 */
        /* JADX WARN: Type inference failed for: r8v4, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r8v6 */
        /* JADX WARN: Type inference failed for: r9v2 */
        /* JADX WARN: Type inference failed for: r9v3, types: [java.lang.Object, kotlinx.coroutines.channels.ProducerScope] */
        /* JADX WARN: Type inference failed for: r9v6 */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x00a2 -> B:16:0x0054). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x00f8 -> B:10:0x0023). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r12) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L19;
            if (r1 == 1) goto L17;
            if (r1 == 2) goto L15;
            if (r1 == 3) goto L14;
            if (r1 == 4) goto L13;
            if (r1 != 5) goto L12;
            ChannelIterator<E> r2 = (ChannelIterator) this.L$1;
            ProducerScope r4 = (ProducerScope) this.L$0;
            ResultKt.throwOnFailure(r12);
            ?? r5 = r4;
        L10:
            ChannelIterator<E> r13 = r2;
            ?? r3 = r5;
        L37:
            this.L$0 = r3;
            this.L$1 = r13;
            this.label = 4;
            Object r6 = r13.hasNext(this);
            if (r6 != r0) goto L40;
            return r0;
        L40:
            ?? r10 = r3;
            r2 = r13;
            r12 = r6;
            ?? r7 = r10;
        L42:
            if (((Boolean) r12).booleanValue() == false) goto L47;
            this.L$0 = r7;
            this.L$1 = r2;
            this.label = 5;
            Object r14 = r7.send(r2.next(), this);
            r5 = r7;
            if (r14 != r0) goto L10;
            return r0;
        L47:
            return Unit.INSTANCE;
        L12:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L13:
            r2 = (ChannelIterator) this.L$1;
            ProducerScope r8 = (ProducerScope) this.L$0;
            ResultKt.throwOnFailure(r12);
            r7 = r8;
            goto L42
        L14:
            ProducerScope r9 = (ProducerScope) this.L$0;
            ResultKt.throwOnFailure(r12);
            ?? r11 = r9;
        L36:
            r13 = this.$this_dropWhile.iterator();
            r3 = r11;
            goto L37
        L15:
            Object r15 = this.L$2;
            ChannelIterator<E> r16 = (ChannelIterator) this.L$1;
            ProducerScope r17 = (ProducerScope) this.L$0;
            ResultKt.throwOnFailure(r12);
            ChannelIterator<E> r18 = r16;
            Object r19 = r15;
            ?? r20 = r17;
        L16:
            ChannelIterator<E> r21 = r18;
            if (((Boolean) r12).booleanValue() == true) goto L35;
            this.L$0 = r20;
            this.L$1 = null;
            this.L$2 = null;
            this.label = 3;
            if (r20.send(r19, this) != r0) goto L34;
            return r0;
        L34:
            r11 = r20;
            goto L36
        L35:
            ?? r22 = r20;
        L20:
            this.L$0 = r22;
            this.L$1 = r21;
            this.L$2 = null;
            this.label = 1;
            r12 = r21.hasNext(this);
            ?? r23 = r22;
            if (r12 == r0) goto L22;
        L18:
            ?? r110 = r23;
            ChannelIterator<E> r24 = r21;
            ?? r25 = r110;
            r11 = r25;
            if (((Boolean) r12).booleanValue() == false) goto L36;
            E r111 = r24.next();
            Function2<E, Continuation<? super Boolean>, Object> r26 = this.$predicate;
            this.L$0 = r25;
            this.L$1 = r24;
            this.L$2 = r111;
            this.label = 2;
            Object r27 = r26.invoke(r111, this);
            if (r27 != r0) goto L28;
            return r0;
        L28:
            r18 = r24;
            r19 = r111;
            r12 = r27;
            r20 = r25;
            goto L16
        L22:
            return r0;
        L17:
            r21 = (ChannelIterator) this.L$1;
            ProducerScope r28 = (ProducerScope) this.L$0;
            ResultKt.throwOnFailure(r12);
            r23 = r28;
            goto L18
        L19:
            ResultKt.throwOnFailure(r12);
            ProducerScope r112 = (ProducerScope) this.L$0;
            r21 = this.$this_dropWhile.iterator();
            r22 = r112;
            goto L20
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$elementAt$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 0}, l = {38}, m = "elementAt", n = {"$this$consume$iv", Utils.INTENT_KEY_INDEX, "count"}, s = {"L$0", "I$0", "I$1"})
    static final class C04521<E> extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C04521(Continuation<? super C04521> r1) {
            super(r1);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return ChannelsKt.elementAt(null, 0, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$elementAtOrNull$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 0}, l = {53}, m = "elementAtOrNull", n = {"$this$consume$iv", Utils.INTENT_KEY_INDEX, "count"}, s = {"L$0", "I$0", "I$1"})
    static final class C04531<E> extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C04531(Continuation<? super C04531> r1) {
            super(r1);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return ChannelsKt.elementAtOrNull(null, 0, this);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filter$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filter$1", f = "Deprecated.kt", i = {0, 1, 1, 2}, l = {198, 199, 199}, m = "invokeSuspend", n = {"$this$produce", "$this$produce", "e", "$this$produce"}, s = {"L$0", "L$0", "L$2", "L$0"})
    static final class C04541<E> extends SuspendLambda implements Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<E, Continuation<? super Boolean>, Object> $predicate;
        final /* synthetic */ ReceiveChannel<E> $this_filter;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        C04541(ReceiveChannel<? extends E> r1, Function2<? super E, ? super Continuation<? super Boolean>, ? extends Object> r2, Continuation<? super C04541> r3) {
            this.$this_filter = r1;
            this.$predicate = r2;
            super(2, r3);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            C04541 r0 = new C04541(this.$this_filter, this.$predicate, r4);
            r0.L$0 = r3;
            return r0;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object r1, Continuation<? super Unit> r2) {
            return invoke((ProducerScope) r1, r2);
        }

        public final Object invoke(ProducerScope<? super E> r1, Continuation<? super Unit> r2) {
            return ((C04541) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v0 */
        /* JADX WARN: Type inference failed for: r6v13, types: [kotlinx.coroutines.channels.ProducerScope] */
        /* JADX WARN: Type inference failed for: r6v14 */
        /* JADX WARN: Type inference failed for: r6v15 */
        /* JADX WARN: Type inference failed for: r6v2 */
        /* JADX WARN: Type inference failed for: r6v3 */
        /* JADX WARN: Type inference failed for: r6v4, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r6v6, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.Object, kotlinx.coroutines.channels.ProducerScope] */
        /* JADX WARN: Type inference failed for: r7v3 */
        /* JADX WARN: Type inference failed for: r7v6 */
        /* JADX WARN: Type inference failed for: r8v0 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L12;
            if (r1 == 1) goto L11;
            if (r1 == 2) goto L10;
            if (r1 != 3) goto L9;
            ChannelIterator<E> r2 = (ChannelIterator) this.L$1;
            ?? r6 = (ProducerScope) this.L$0;
            ResultKt.throwOnFailure(r10);
        L13:
            this.L$0 = r6;
            this.L$1 = r2;
            this.L$2 = null;
            this.label = 1;
            r10 = r2.hasNext(this);
            ?? r7 = r6;
            if (r10 != r0) goto L17;
            return r0;
        L17:
            if (((Boolean) r10).booleanValue() == false) goto L29;
            E r11 = r2.next();
            Function2<E, Continuation<? super Boolean>, Object> r8 = this.$predicate;
            this.L$0 = r7;
            this.L$1 = r2;
            this.L$2 = r11;
            this.label = 2;
            Object r9 = r8.invoke(r11, this);
            if (r9 != r0) goto L21;
            return r0;
        L21:
            ?? r12 = r7;
            Object r13 = r11;
            r10 = r9;
            ?? r14 = r12;
        L23:
            if (((Boolean) r10).booleanValue() == false) goto L27;
            this.L$0 = r14;
            this.L$1 = r2;
            this.L$2 = null;
            this.label = 3;
            if (r14.send(r13, this) != r0) goto L27;
            return r0;
        L27:
            r6 = r14;
            goto L13
        L30:
            r6 = r14;
            goto L13
        L29:
            return Unit.INSTANCE;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            Object r3 = this.L$2;
            ChannelIterator<E> r15 = (ChannelIterator) this.L$1;
            ProducerScope r16 = (ProducerScope) this.L$0;
            ResultKt.throwOnFailure(r10);
            r13 = r3;
            r2 = r15;
            r14 = r16;
            goto L23
        L11:
            r2 = (ChannelIterator) this.L$1;
            ProducerScope r17 = (ProducerScope) this.L$0;
            ResultKt.throwOnFailure(r10);
            r7 = r17;
            goto L17
        L12:
            ResultKt.throwOnFailure(r10);
            ProducerScope r18 = (ProducerScope) this.L$0;
            r2 = this.$this_filter.iterator();
            r6 = r18;
            goto L13
        }
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterIndexed$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterIndexed$1", f = "Deprecated.kt", i = {0, 0, 1, 1, 1, 2, 2}, l = {211, 212, 212}, m = "invokeSuspend", n = {"$this$produce", Utils.INTENT_KEY_INDEX, "$this$produce", "e", Utils.INTENT_KEY_INDEX, "$this$produce", Utils.INTENT_KEY_INDEX}, s = {"L$0", "I$0", "L$0", "L$2", "I$0", "L$0", "I$0"})
    static final class C04551<E> extends SuspendLambda implements Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function3<Integer, E, Continuation<? super Boolean>, Object> $predicate;
        final /* synthetic */ ReceiveChannel<E> $this_filterIndexed;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        C04551(ReceiveChannel<? extends E> r1, Function3<? super Integer, ? super E, ? super Continuation<? super Boolean>, ? extends Object> r2, Continuation<? super C04551> r3) {
            this.$this_filterIndexed = r1;
            this.$predicate = r2;
            super(2, r3);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            C04551 r0 = new C04551(this.$this_filterIndexed, this.$predicate, r4);
            r0.L$0 = r3;
            return r0;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object r1, Continuation<? super Unit> r2) {
            return invoke((ProducerScope) r1, r2);
        }

        public final Object invoke(ProducerScope<? super E> r1, Continuation<? super Unit> r2) {
            return ((C04551) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r7v0 */
        /* JADX WARN: Type inference failed for: r7v13, types: [kotlinx.coroutines.channels.ProducerScope] */
        /* JADX WARN: Type inference failed for: r7v14 */
        /* JADX WARN: Type inference failed for: r7v15 */
        /* JADX WARN: Type inference failed for: r7v2 */
        /* JADX WARN: Type inference failed for: r7v3 */
        /* JADX WARN: Type inference failed for: r7v4, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r7v6, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r8v0, types: [java.lang.Object, kotlinx.coroutines.channels.ProducerScope] */
        /* JADX WARN: Type inference failed for: r8v2 */
        /* JADX WARN: Type inference failed for: r8v5 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r12) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L12;
            if (r1 == 1) goto L11;
            if (r1 == 2) goto L10;
            if (r1 != 3) goto L9;
            int r2 = this.I$0;
            ChannelIterator<E> r6 = (ChannelIterator) this.L$1;
            ?? r7 = (ProducerScope) this.L$0;
            ResultKt.throwOnFailure(r12);
        L13:
            this.L$0 = r7;
            this.L$1 = r6;
            this.L$2 = null;
            this.I$0 = r2;
            this.label = 1;
            r12 = r6.hasNext(this);
            ?? r8 = r7;
            if (r12 != r0) goto L17;
            return r0;
        L17:
            if (((Boolean) r12).booleanValue() == false) goto L29;
            E r13 = r6.next();
            Function3<Integer, E, Continuation<? super Boolean>, Object> r9 = this.$predicate;
            int r10 = r2 + 1;
            Integer r3 = Boxing.boxInt(r2);
            this.L$0 = r8;
            this.L$1 = r6;
            this.L$2 = r13;
            this.I$0 = r10;
            this.label = 2;
            Object r4 = r9.invoke(r3, r13, this);
            if (r4 != r0) goto L21;
            return r0;
        L21:
            ?? r11 = r8;
            Object r14 = r13;
            r12 = r4;
            r2 = r10;
        L23:
            if (((Boolean) r12).booleanValue() == false) goto L27;
            this.L$0 = r11;
            this.L$1 = r6;
            this.L$2 = null;
            this.I$0 = r2;
            this.label = 3;
            if (r11.send(r14, this) != r0) goto L27;
            return r0;
        L27:
            r7 = r11;
            goto L13
        L30:
            r7 = r11;
            goto L13
        L29:
            return Unit.INSTANCE;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            r2 = this.I$0;
            Object r15 = this.L$2;
            ChannelIterator<E> r16 = (ChannelIterator) this.L$1;
            ProducerScope r17 = (ProducerScope) this.L$0;
            ResultKt.throwOnFailure(r12);
            r14 = r15;
            r6 = r16;
            r11 = r17;
            goto L23
        L11:
            r2 = this.I$0;
            r6 = (ChannelIterator) this.L$1;
            ProducerScope r18 = (ProducerScope) this.L$0;
            ResultKt.throwOnFailure(r12);
            r8 = r18;
            goto L17
        L12:
            ResultKt.throwOnFailure(r12);
            r7 = (ProducerScope) this.L$0;
            r6 = this.$this_filterIndexed.iterator();
            r2 = 0;
            goto L13
        }
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterNot$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.LONGITUDE_EAST, "it"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterNot$1", f = "Deprecated.kt", i = {}, l = {222}, m = "invokeSuspend", n = {}, s = {})
    static final class C04561<E> extends SuspendLambda implements Function2<E, Continuation<? super Boolean>, Object> {
        final /* synthetic */ Function2<E, Continuation<? super Boolean>, Object> $predicate;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        C04561(Function2<? super E, ? super Continuation<? super Boolean>, ? extends Object> r1, Continuation<? super C04561> r2) {
            this.$predicate = r1;
            super(2, r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            C04561 r0 = new C04561(this.$predicate, r3);
            r0.L$0 = r2;
            return r0;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object r1, Continuation<? super Boolean> r2) {
            return invoke2(r1, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(E r1, Continuation<? super Boolean> r2) {
            return ((C04561) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterNot$1<E> for r3v5 'this'  java.lang.Object
            	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
            	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
            	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
            	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
            	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r4) {
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = r3.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            kotlin.ResultKt.throwOnFailure(r4);
        L11:
            java.lang.Boolean r4 = (java.lang.Boolean) r4;
            boolean r3 = r4.booleanValue();
            boolean r3 = r3 ^ true;
            java.lang.Boolean r3 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3);
            return r3;
        L6:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            throw r3;
        L8:
            kotlin.ResultKt.throwOnFailure(r4);
            java.lang.Object r4 = r3.L$0;
            kotlin.jvm.functions.Function2<E, kotlin.coroutines.Continuation<? super java.lang.Boolean>, java.lang.Object> r1 = r3.$predicate;
            r3.label = 1;
            E r4 = (E) r4;
            java.lang.Object r3 = (kotlin.coroutines.Continuation<? super java.lang.Boolean>) r3;
            r4 = r1.invoke(r4, r3);
            if (r4 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterNotNull$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u0001H\u0002H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.LONGITUDE_EAST, "", "it"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterNotNull$1", f = "Deprecated.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C04571<E> extends SuspendLambda implements Function2<E, Continuation<? super Boolean>, Object> {
        /* synthetic */ Object L$0;
        int label;

        C04571(Continuation<? super C04571> r2) {
            super(2, r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            C04571 r0 = new C04571(r2);
            r0.L$0 = r1;
            return r0;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object r1, Continuation<? super Boolean> r2) {
            return invoke2(r1, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(E r1, Continuation<? super Boolean> r2) {
            return ((C04571) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L11;
            ResultKt.throwOnFailure(r2);
            if (this.L$0 == null) goto L7;
            boolean r1 = true;
        L9:
            return Boxing.boxBoolean(r1);
        L7:
            r1 = false;
            goto L9
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterNotNullTo$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0}, l = {487}, m = "filterNotNullTo", n = {"destination", "$this$consume$iv$iv"}, s = {"L$0", "L$1"})
    static final class C04581<E, C extends Collection<? super E>> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C04581(Continuation<? super C04581> r1) {
            super(r1);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return ChannelsKt.filterNotNullTo(null, null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterNotNullTo$3, reason: invalid class name */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 1, 1}, l = {487, 242}, m = "filterNotNullTo", n = {"destination", "$this$consume$iv$iv", "destination", "$this$consume$iv$iv"}, s = {"L$0", "L$1", "L$0", "L$1"})
    static final class AnonymousClass3<E, C extends SendChannel<? super E>> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        AnonymousClass3(Continuation<? super AnonymousClass3> r1) {
            super(r1);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return ChannelsKt.filterNotNullTo(null, null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$first$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0}, l = {65}, m = "first", n = {"$this$consume$iv", "iterator"}, s = {"L$0", "L$1"})
    static final class C04591<E> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C04591(Continuation<? super C04591> r1) {
            super(r1);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return ChannelsKt.first(null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$firstOrNull$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0}, l = {75}, m = "firstOrNull", n = {"$this$consume$iv", "iterator"}, s = {"L$0", "L$1"})
    static final class C04601<E> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C04601(Continuation<? super C04601> r1) {
            super(r1);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return ChannelsKt.firstOrNull(null, this);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$flatMap$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u0004H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.LONGITUDE_EAST, "R", "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$flatMap$1", f = "Deprecated.kt", i = {0, 1, 2}, l = {321, 322, 322}, m = "invokeSuspend", n = {"$this$produce", "$this$produce", "$this$produce"}, s = {"L$0", "L$0", "L$0"})
    static final class C04611<R> extends SuspendLambda implements Function2<ProducerScope<? super R>, Continuation<? super Unit>, Object> {
        final /* synthetic */ ReceiveChannel<E> $this_flatMap;
        final /* synthetic */ Function2<E, Continuation<? super ReceiveChannel<? extends R>>, Object> $transform;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        C04611(ReceiveChannel<? extends E> r1, Function2<? super E, ? super Continuation<? super ReceiveChannel<? extends R>>, ? extends Object> r2, Continuation<? super C04611> r3) {
            this.$this_flatMap = r1;
            this.$transform = r2;
            super(2, r3);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            C04611 r0 = new C04611(this.$this_flatMap, this.$transform, r4);
            r0.L$0 = r3;
            return r0;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object r1, Continuation<? super Unit> r2) {
            return invoke((ProducerScope) r1, r2);
        }

        public final Object invoke(ProducerScope<? super R> r1, Continuation<? super Unit> r2) {
            return ((C04611) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0088 -> B:13:0x004b). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$flatMap$1<R> for r8v3 'this'  java.lang.Object
            	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
            	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
            	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
            	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
            	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = r8.label;
            if (r1 == 0) goto L12;
            if (r1 == 1) goto L11;
            if (r1 == 2) goto L10;
            if (r1 != 3) goto L8;
            java.lang.Object r1 = r8.L$1;
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1;
            java.lang.Object r5 = r8.L$0;
            kotlinx.coroutines.channels.ProducerScope r5 = (kotlinx.coroutines.channels.ProducerScope) r5;
            kotlin.ResultKt.throwOnFailure(r9);
        L13:
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.C04611<R> r9 = r8;
            r8.L$0 = r5;
            r8.L$1 = r1;
            r8.label = 1;
            r9 = r1.hasNext(r9);
            if (r9 != r0) goto L16;
            return r0;
        L16:
            java.lang.Boolean r9 = (java.lang.Boolean) r9;
            boolean r9 = r9.booleanValue();
            if (r9 == false) goto L24;
            java.lang.Object r9 = r1.next();
            kotlin.jvm.functions.Function2<E, kotlin.coroutines.Continuation<? super kotlinx.coroutines.channels.ReceiveChannel<? extends R>>, java.lang.Object> r6 = r8.$transform;
            r8.L$0 = r5;
            r8.L$1 = r1;
            r8.label = 2;
            E r9 = (E) r9;
            java.lang.Object r8 = (kotlin.coroutines.Continuation<? super kotlinx.coroutines.channels.ReceiveChannel<? extends R>>) r8;
            r9 = r6.invoke(r9, r8);
            if (r9 != r0) goto L21;
            return r0;
        L21:
            kotlinx.coroutines.channels.ReceiveChannel r9 = (kotlinx.coroutines.channels.ReceiveChannel) r9;
            kotlinx.coroutines.channels.ProducerScope r6 = r5;
            kotlinx.coroutines.channels.ProducerScope r6 = (kotlinx.coroutines.channels.SendChannel) r6;
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.C04611<R> r7 = (kotlin.coroutines.Continuation) r8;
            r8.L$0 = r5;
            r8.L$1 = r1;
            r8.label = 3;
            java.lang.Object r9 = kotlinx.coroutines.channels.ChannelsKt.toChannel(r9, r6, r7);
            if (r9 != r0) goto L13;
            return r0;
        L24:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE;
            return r8;
        L8:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            throw r8;
        L10:
            java.lang.Object r1 = r8.L$1;
            r1 = (kotlinx.coroutines.channels.ChannelIterator) r1;
            java.lang.Object r5 = r8.L$0;
            r5 = (kotlinx.coroutines.channels.ProducerScope) r5;
            kotlin.ResultKt.throwOnFailure(r9);
            goto L21
        L11:
            java.lang.Object r1 = r8.L$1;
            r1 = (kotlinx.coroutines.channels.ChannelIterator) r1;
            java.lang.Object r5 = r8.L$0;
            r5 = (kotlinx.coroutines.channels.ProducerScope) r5;
            kotlin.ResultKt.throwOnFailure(r9);
            goto L16
        L12:
            kotlin.ResultKt.throwOnFailure(r9);
            java.lang.Object r9 = r8.L$0;
            kotlinx.coroutines.channels.ProducerScope r9 = (kotlinx.coroutines.channels.ProducerScope) r9;
            kotlinx.coroutines.channels.ReceiveChannel<E> r1 = r8.$this_flatMap;
            r1 = r1.iterator();
            r5 = r9;
            goto L13
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$indexOf$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 0}, l = {487}, m = "indexOf", n = {"element", Utils.INTENT_KEY_INDEX, "$this$consume$iv$iv"}, s = {"L$0", "L$1", "L$2"})
    static final class C04621<E> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C04621(Continuation<? super C04621> r1) {
            super(r1);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return ChannelsKt.indexOf(null, null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$last$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 1, 1, 1}, l = {97, 100}, m = "last", n = {"$this$consume$iv", "iterator", "$this$consume$iv", "iterator", "last"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2"})
    static final class C04631<E> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C04631(Continuation<? super C04631> r1) {
            super(r1);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return ChannelsKt.last(null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$lastIndexOf$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 0, 0}, l = {487}, m = "lastIndexOf", n = {"element", "lastIndex", Utils.INTENT_KEY_INDEX, "$this$consume$iv$iv"}, s = {"L$0", "L$1", "L$2", "L$3"})
    static final class C04641<E> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C04641(Continuation<? super C04641> r1) {
            super(r1);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return ChannelsKt.lastIndexOf(null, null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$lastOrNull$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 1, 1, 1}, l = {123, 126}, m = "lastOrNull", n = {"$this$consume$iv", "iterator", "$this$consume$iv", "iterator", "last"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2"})
    static final class C04651<E> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C04651(Continuation<? super C04651> r1) {
            super(r1);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return ChannelsKt.lastOrNull(null, this);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$map$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u0004H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.LONGITUDE_EAST, "R", "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$map$1", f = "Deprecated.kt", i = {0, 0, 1, 1, 2, 2}, l = {487, 333, 333}, m = "invokeSuspend", n = {"$this$produce", "$this$consume$iv$iv", "$this$produce", "$this$consume$iv$iv", "$this$produce", "$this$consume$iv$iv"}, s = {"L$0", "L$2", "L$0", "L$2", "L$0", "L$2"})
    static final class C04661<R> extends SuspendLambda implements Function2<ProducerScope<? super R>, Continuation<? super Unit>, Object> {
        final /* synthetic */ ReceiveChannel<E> $this_map;
        final /* synthetic */ Function2<E, Continuation<? super R>, Object> $transform;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        C04661(ReceiveChannel<? extends E> r1, Function2<? super E, ? super Continuation<? super R>, ? extends Object> r2, Continuation<? super C04661> r3) {
            this.$this_map = r1;
            this.$transform = r2;
            super(2, r3);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            C04661 r0 = new C04661(this.$this_map, this.$transform, r4);
            r0.L$0 = r3;
            return r0;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object r1, Continuation<? super Unit> r2) {
            return invoke((ProducerScope) r1, r2);
        }

        public final Object invoke(ProducerScope<? super R> r1, Continuation<? super Unit> r2) {
            return ((C04661) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x00bd -> B:22:0x0072). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r12) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L20;
            if (r1 == 1) goto L17;
            if (r1 == 2) goto L12;
            if (r1 != 3) goto L11;
            ChannelIterator r2 = (ChannelIterator) this.L$3;
            ReceiveChannel r6 = (ReceiveChannel) this.L$2;
            Function2 r7 = (Function2) this.L$1;
            ProducerScope r8 = (ProducerScope) this.L$0;
            ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L39
            ProducerScope r13 = r8;
        L22:
            this.L$0 = r13;     // Catch: Throwable -> L39
            this.L$1 = r7;     // Catch: Throwable -> L39
            this.L$2 = r6;     // Catch: Throwable -> L39
            this.L$3 = r2;     // Catch: Throwable -> L39
            this.label = 1;     // Catch: Throwable -> L39
            Object r9 = r2.hasNext(this);     // Catch: Throwable -> L39
            if (r9 != r0) goto L25;
            return r0;
        L25:
            ProducerScope r10 = r13;
            r12 = r9;
        L27:
            if (((Boolean) r12).booleanValue() == false) goto L36;
            Object r14 = r2.next();     // Catch: Throwable -> L39
            this.L$0 = r10;     // Catch: Throwable -> L39
            this.L$1 = r7;     // Catch: Throwable -> L39
            this.L$2 = r6;     // Catch: Throwable -> L39
            this.L$3 = r2;     // Catch: Throwable -> L39
            this.L$4 = r10;     // Catch: Throwable -> L39
            this.label = 2;     // Catch: Throwable -> L39
            r12 = r7.invoke(r14, this);     // Catch: Throwable -> L39
            if (r12 != r0) goto L31;
            return r0;
        L31:
            ProducerScope r11 = r10;
            Function2 r15 = r7;
            ReceiveChannel r16 = r6;
            ChannelIterator r17 = r2;
            ProducerScope r3 = r11;
        L32:
            this.L$0 = r11;     // Catch: Throwable -> L15
            this.L$1 = r15;     // Catch: Throwable -> L15
            this.L$2 = r16;     // Catch: Throwable -> L15
            this.L$3 = r17;     // Catch: Throwable -> L15
            this.L$4 = null;     // Catch: Throwable -> L15
            this.label = 3;     // Catch: Throwable -> L15
            if (r3.send(r12, this) != r0) goto L35;
            return r0;
        L35:
            r2 = r17;
            r6 = r16;
            r7 = r15;
            r13 = r11;
        L15:
            th = th;
            r6 = r16;
        L48:
            throw th;     // Catch: Throwable -> L41
        L41:
            th = move-exception;
            ChannelsKt.cancelConsumed(r6, th);
            throw th;
        L36:
            Unit r18 = Unit.INSTANCE;     // Catch: Throwable -> L39
            ChannelsKt.cancelConsumed(r6, null);
            return Unit.INSTANCE;
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L12:
            r3 = (ProducerScope) this.L$4;
            r17 = (ChannelIterator) this.L$3;
            r16 = (ReceiveChannel) this.L$2;
            r15 = (Function2) this.L$1;
            r11 = (ProducerScope) this.L$0;
            ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L15
            goto L32
        L17:
            r2 = (ChannelIterator) this.L$3;
            r6 = (ReceiveChannel) this.L$2;
            r7 = (Function2) this.L$1;
            r10 = (ProducerScope) this.L$0;
            ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L39
            goto L27
        L20:
            ResultKt.throwOnFailure(r12);
            r13 = (ProducerScope) this.L$0;
            r6 = this.$this_map;
            Function2 r4 = this.$transform;
            r7 = r4;
            r2 = r6.iterator();     // Catch: Throwable -> L39
        L39:
            th = th;
            goto L48
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$mapIndexed$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u0004H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.LONGITUDE_EAST, "R", "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$mapIndexed$1", f = "Deprecated.kt", i = {0, 0, 1, 1, 2, 2}, l = {344, 345, 345}, m = "invokeSuspend", n = {"$this$produce", Utils.INTENT_KEY_INDEX, "$this$produce", Utils.INTENT_KEY_INDEX, "$this$produce", Utils.INTENT_KEY_INDEX}, s = {"L$0", "I$0", "L$0", "I$0", "L$0", "I$0"})
    static final class C04671<R> extends SuspendLambda implements Function2<ProducerScope<? super R>, Continuation<? super Unit>, Object> {
        final /* synthetic */ ReceiveChannel<E> $this_mapIndexed;
        final /* synthetic */ Function3<Integer, E, Continuation<? super R>, Object> $transform;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        C04671(ReceiveChannel<? extends E> r1, Function3<? super Integer, ? super E, ? super Continuation<? super R>, ? extends Object> r2, Continuation<? super C04671> r3) {
            this.$this_mapIndexed = r1;
            this.$transform = r2;
            super(2, r3);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            C04671 r0 = new C04671(this.$this_mapIndexed, this.$transform, r4);
            r0.L$0 = r3;
            return r0;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object r1, Continuation<? super Unit> r2) {
            return invoke((ProducerScope) r1, r2);
        }

        public final Object invoke(ProducerScope<? super R> r1, Continuation<? super Unit> r2) {
            return ((C04671) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00ac -> B:13:0x0059). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$mapIndexed$1<R> for r11v3 'this'  java.lang.Object
            	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
            	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
            	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
            	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
            	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r12) {
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = r11.label;
            if (r1 == 0) goto L12;
            if (r1 == 1) goto L11;
            if (r1 == 2) goto L10;
            if (r1 != 3) goto L8;
            int r1 = r11.I$0;
            java.lang.Object r5 = r11.L$1;
            kotlinx.coroutines.channels.ChannelIterator r5 = (kotlinx.coroutines.channels.ChannelIterator) r5;
            java.lang.Object r6 = r11.L$0;
            kotlinx.coroutines.channels.ProducerScope r6 = (kotlinx.coroutines.channels.ProducerScope) r6;
            kotlin.ResultKt.throwOnFailure(r12);
            kotlinx.coroutines.channels.ProducerScope r12 = r6;
        L13:
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.C04671<R> r6 = r11;
            r11.L$0 = r12;
            r11.L$1 = r5;
            r11.I$0 = r1;
            r11.label = 1;
            java.lang.Object r6 = r5.hasNext(r6);
            if (r6 != r0) goto L16;
            return r0;
        L16:
            kotlinx.coroutines.channels.ProducerScope r6 = r12;
            r12 = r6;
        L17:
            java.lang.Boolean r12 = (java.lang.Boolean) r12;
            boolean r12 = r12.booleanValue();
            if (r12 == false) goto L27;
            java.lang.Object r12 = r5.next();
            kotlin.jvm.functions.Function3<java.lang.Integer, E, kotlin.coroutines.Continuation<? super R>, java.lang.Object> r7 = r11.$transform;
            int r8 = r1 + 1;
            java.lang.Integer r1 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r1);
            r11.L$0 = r6;
            r11.L$1 = r5;
            r11.L$2 = r6;
            r11.I$0 = r8;
            r11.label = 2;
            E r12 = (E) r12;
            java.lang.Object r11 = (kotlin.coroutines.Continuation<? super R>) r11;
            r12 = r7.invoke(r1, r12, r11);
            if (r12 != r0) goto L22;
            return r0;
        L22:
            kotlinx.coroutines.channels.ProducerScope r7 = r6;
            r1 = r8;
            kotlinx.coroutines.channels.ChannelIterator r6 = r5;
            kotlinx.coroutines.channels.ProducerScope r5 = r7;
        L23:
            kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.C04671<R> r8 = (kotlin.coroutines.Continuation) r11;
            r11.L$0 = r7;
            r11.L$1 = r6;
            r11.L$2 = null;
            r11.I$0 = r1;
            r11.label = 3;
            java.lang.Object r12 = r5.send(r12, r8);
            if (r12 != r0) goto L26;
            return r0;
        L26:
            r5 = r6;
            r12 = r7;
            goto L13
        L27:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE;
            return r11;
        L8:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            throw r11;
        L10:
            r1 = r11.I$0;
            java.lang.Object r5 = r11.L$2;
            r5 = (kotlinx.coroutines.channels.ProducerScope) r5;
            java.lang.Object r6 = r11.L$1;
            r6 = (kotlinx.coroutines.channels.ChannelIterator) r6;
            java.lang.Object r7 = r11.L$0;
            r7 = (kotlinx.coroutines.channels.ProducerScope) r7;
            kotlin.ResultKt.throwOnFailure(r12);
            goto L23
        L11:
            r1 = r11.I$0;
            java.lang.Object r5 = r11.L$1;
            r5 = (kotlinx.coroutines.channels.ChannelIterator) r5;
            java.lang.Object r6 = r11.L$0;
            r6 = (kotlinx.coroutines.channels.ProducerScope) r6;
            kotlin.ResultKt.throwOnFailure(r12);
            goto L17
        L12:
            kotlin.ResultKt.throwOnFailure(r12);
            java.lang.Object r12 = r11.L$0;
            r12 = (kotlinx.coroutines.channels.ProducerScope) r12;
            kotlinx.coroutines.channels.ReceiveChannel<E> r1 = r11.$this_mapIndexed;
            kotlinx.coroutines.channels.ChannelIterator r1 = r1.iterator();
            r5 = r1;
            r1 = 0;
            goto L13
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$maxWith$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 0, 1, 1, 1, 1}, l = {420, 422}, m = "maxWith", n = {"comparator", "$this$consume$iv", "iterator", "comparator", "$this$consume$iv", "iterator", "max"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3"})
    static final class C04681<E> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C04681(Continuation<? super C04681> r1) {
            super(r1);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return ChannelsKt.maxWith(null, null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$minWith$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 0, 1, 1, 1, 1}, l = {434, 436}, m = "minWith", n = {"comparator", "$this$consume$iv", "iterator", "comparator", "$this$consume$iv", "iterator", "min"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3"})
    static final class C04691<E> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C04691(Continuation<? super C04691> r1) {
            super(r1);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return ChannelsKt.minWith(null, null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$none$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0}, l = {447}, m = "none", n = {"$this$consume$iv"}, s = {"L$0"})
    static final class C04701<E> extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C04701(Continuation<? super C04701> r1) {
            super(r1);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return ChannelsKt.none(null, this);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$requireNoNulls$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u0001H\u0001H\u008a@"}, d2 = {"<anonymous>", ExifInterface.LONGITUDE_EAST, "", "it"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$requireNoNulls$1", f = "Deprecated.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C04711<E> extends SuspendLambda implements Function2<E, Continuation<? super E>, Object> {
        final /* synthetic */ ReceiveChannel<E> $this_requireNoNulls;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        C04711(ReceiveChannel<? extends E> r1, Continuation<? super C04711> r2) {
            this.$this_requireNoNulls = r1;
            super(2, r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            C04711 r0 = new C04711(this.$this_requireNoNulls, r3);
            r0.L$0 = r2;
            return r0;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke(r1, (Continuation) r2);
        }

        public final Object invoke(E r1, Continuation<? super E> r2) {
            return ((C04711) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L10;
            ResultKt.throwOnFailure(r3);
            Object r4 = this.L$0;
            if (r4 == null) goto L8;
            return r4;
        L8:
            throw new IllegalArgumentException("null element found in " + this.$this_requireNoNulls + '.');
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$single$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 1, 1}, l = {136, 139}, m = "single", n = {"$this$consume$iv", "iterator", "$this$consume$iv", "single"}, s = {"L$0", "L$1", "L$0", "L$1"})
    static final class C04721<E> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C04721(Continuation<? super C04721> r1) {
            super(r1);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return ChannelsKt.single(null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$singleOrNull$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 1, 1}, l = {149, 152}, m = "singleOrNull", n = {"$this$consume$iv", "iterator", "$this$consume$iv", "single"}, s = {"L$0", "L$1", "L$0", "L$1"})
    static final class C04731<E> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C04731(Continuation<? super C04731> r1) {
            super(r1);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return ChannelsKt.singleOrNull(null, this);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$take$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$take$1", f = "Deprecated.kt", i = {0, 0, 1, 1}, l = {254, 255}, m = "invokeSuspend", n = {"$this$produce", "remaining", "$this$produce", "remaining"}, s = {"L$0", "I$0", "L$0", "I$0"})
    static final class C04741<E> extends SuspendLambda implements Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $n;
        final /* synthetic */ ReceiveChannel<E> $this_take;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        C04741(int r1, ReceiveChannel<? extends E> r2, Continuation<? super C04741> r3) {
            this.$n = r1;
            this.$this_take = r2;
            super(2, r3);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            C04741 r0 = new C04741(this.$n, this.$this_take, r4);
            r0.L$0 = r3;
            return r0;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object r1, Continuation<? super Unit> r2) {
            return invoke((ProducerScope) r1, r2);
        }

        public final Object invoke(ProducerScope<? super E> r1, Continuation<? super Unit> r2) {
            return ((C04741) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x007e -> B:7:0x001b). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r9) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L11;
            if (r1 == 1) goto L10;
            if (r1 != 2) goto L9;
            int r2 = this.I$0;
            ChannelIterator<E> r4 = (ChannelIterator) this.L$1;
            ProducerScope r5 = (ProducerScope) this.L$0;
            ResultKt.throwOnFailure(r9);
        L7:
            ProducerScope r10 = r5;
            r2 = r2 - 1;
            if (r2 == 0) goto L32;
        L20:
            this.L$0 = r10;
            this.L$1 = r4;
            this.I$0 = r2;
            this.label = 1;
            Object r6 = r4.hasNext(this);
            if (r6 != r0) goto L23;
            return r0;
        L23:
            r5 = r10;
            r9 = r6;
        L25:
            if (((Boolean) r9).booleanValue() == false) goto L34;
            this.L$0 = r5;
            this.L$1 = r4;
            this.I$0 = r2;
            this.label = 2;
            if (r5.send(r4.next(), this) != r0) goto L7;
            return r0;
        L34:
            return Unit.INSTANCE;
        L32:
            return Unit.INSTANCE;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            r2 = this.I$0;
            r4 = (ChannelIterator) this.L$1;
            r5 = (ProducerScope) this.L$0;
            ResultKt.throwOnFailure(r9);
            goto L25
        L11:
            ResultKt.throwOnFailure(r9);
            r10 = (ProducerScope) this.L$0;
            r2 = this.$n;
            if (r2 == 0) goto L14;
            if (r2 < 0) goto L17;
            boolean r7 = true;
        L18:
            if (r7 == false) goto L36;
            r4 = this.$this_take.iterator();
            goto L20
        L36:
            throw new IllegalArgumentException(("Requested element count " + r2 + " is less than zero.").toString());
        L17:
            r7 = false;
            goto L18
        L14:
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$takeWhile$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$takeWhile$1", f = "Deprecated.kt", i = {0, 1, 1, 2}, l = {269, 270, 271}, m = "invokeSuspend", n = {"$this$produce", "$this$produce", "e", "$this$produce"}, s = {"L$0", "L$0", "L$2", "L$0"})
    static final class C04751<E> extends SuspendLambda implements Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<E, Continuation<? super Boolean>, Object> $predicate;
        final /* synthetic */ ReceiveChannel<E> $this_takeWhile;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        C04751(ReceiveChannel<? extends E> r1, Function2<? super E, ? super Continuation<? super Boolean>, ? extends Object> r2, Continuation<? super C04751> r3) {
            this.$this_takeWhile = r1;
            this.$predicate = r2;
            super(2, r3);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            C04751 r0 = new C04751(this.$this_takeWhile, this.$predicate, r4);
            r0.L$0 = r3;
            return r0;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object r1, Continuation<? super Unit> r2) {
            return invoke((ProducerScope) r1, r2);
        }

        public final Object invoke(ProducerScope<? super E> r1, Continuation<? super Unit> r2) {
            return ((C04751) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v0 */
        /* JADX WARN: Type inference failed for: r5v12 */
        /* JADX WARN: Type inference failed for: r5v13 */
        /* JADX WARN: Type inference failed for: r5v14 */
        /* JADX WARN: Type inference failed for: r5v2 */
        /* JADX WARN: Type inference failed for: r5v3, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r5v5, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.Object, kotlinx.coroutines.channels.ProducerScope] */
        /* JADX WARN: Type inference failed for: r6v3 */
        /* JADX WARN: Type inference failed for: r6v6 */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x009d -> B:13:0x004d). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L12;
            if (r1 == 1) goto L11;
            if (r1 == 2) goto L10;
            if (r1 != 3) goto L9;
            ChannelIterator<E> r2 = (ChannelIterator) this.L$1;
            ProducerScope r5 = (ProducerScope) this.L$0;
            ResultKt.throwOnFailure(r10);
            ?? r6 = r5;
        L13:
            this.L$0 = r6;
            this.L$1 = r2;
            this.label = 1;
            r10 = r2.hasNext(this);
            ?? r7 = r6;
            if (r10 != r0) goto L17;
            return r0;
        L17:
            if (((Boolean) r10).booleanValue() == false) goto L31;
            E r11 = r2.next();
            Function2<E, Continuation<? super Boolean>, Object> r8 = this.$predicate;
            this.L$0 = r7;
            this.L$1 = r2;
            this.L$2 = r11;
            this.label = 2;
            Object r9 = r8.invoke(r11, this);
            if (r9 != r0) goto L21;
            return r0;
        L21:
            ChannelIterator<E> r12 = r2;
            Object r3 = r11;
            r10 = r9;
            ?? r13 = r7;
            ChannelIterator<E> r14 = r12;
        L23:
            if (((Boolean) r10).booleanValue() == false) goto L25;
            this.L$0 = r13;
            this.L$1 = r14;
            this.L$2 = null;
            this.label = 3;
            if (r13.send(r3, this) != r0) goto L29;
            return r0;
        L29:
            r2 = r14;
            r6 = r13;
            goto L13
        L25:
            return Unit.INSTANCE;
        L31:
            return Unit.INSTANCE;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            r3 = this.L$2;
            r14 = (ChannelIterator) this.L$1;
            ProducerScope r15 = (ProducerScope) this.L$0;
            ResultKt.throwOnFailure(r10);
            r13 = r15;
            goto L23
        L11:
            r2 = (ChannelIterator) this.L$1;
            ProducerScope r16 = (ProducerScope) this.L$0;
            ResultKt.throwOnFailure(r10);
            r7 = r16;
            goto L17
        L12:
            ResultKt.throwOnFailure(r10);
            ProducerScope r17 = (ProducerScope) this.L$0;
            r2 = this.$this_takeWhile.iterator();
            r6 = r17;
            goto L13
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$toChannel$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 1, 1}, l = {487, 278}, m = "toChannel", n = {"destination", "$this$consume$iv$iv", "destination", "$this$consume$iv$iv"}, s = {"L$0", "L$1", "L$0", "L$1"})
    static final class C04761<E, C extends SendChannel<? super E>> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C04761(Continuation<? super C04761> r1) {
            super(r1);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return ChannelsKt.toChannel(null, null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$toCollection$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0}, l = {487}, m = "toCollection", n = {"destination", "$this$consume$iv$iv"}, s = {"L$0", "L$1"})
    static final class C04771<E, C extends Collection<? super E>> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C04771(Continuation<? super C04771> r1) {
            super(r1);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return ChannelsKt.toCollection(null, null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$toMap$2, reason: invalid class name */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0}, l = {487}, m = "toMap", n = {"destination", "$this$consume$iv$iv"}, s = {"L$0", "L$1"})
    static final class AnonymousClass2<K, V, M extends Map<? super K, ? super V>> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        AnonymousClass2(Continuation<? super AnonymousClass2> r1) {
            super(r1);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return ChannelsKt.toMap(null, null, this);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$withIndex$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00040\u0003H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/ProducerScope;", "Lkotlin/collections/IndexedValue;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$withIndex$1", f = "Deprecated.kt", i = {0, 0, 1, 1}, l = {370, 371}, m = "invokeSuspend", n = {"$this$produce", Utils.INTENT_KEY_INDEX, "$this$produce", Utils.INTENT_KEY_INDEX}, s = {"L$0", "I$0", "L$0", "I$0"})
    static final class C04781<E> extends SuspendLambda implements Function2<ProducerScope<? super IndexedValue<? extends E>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ ReceiveChannel<E> $this_withIndex;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        C04781(ReceiveChannel<? extends E> r1, Continuation<? super C04781> r2) {
            this.$this_withIndex = r1;
            super(2, r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            C04781 r0 = new C04781(this.$this_withIndex, r3);
            r0.L$0 = r2;
            return r0;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object r1, Continuation<? super Unit> r2) {
            return invoke((ProducerScope) r1, r2);
        }

        public final Object invoke(ProducerScope<? super IndexedValue<? extends E>> r1, Continuation<? super Unit> r2) {
            return ((C04781) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0081 -> B:11:0x0044). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r11) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            int r2 = this.I$0;
            ChannelIterator<E> r4 = (ChannelIterator) this.L$1;
            ProducerScope r5 = (ProducerScope) this.L$0;
            ResultKt.throwOnFailure(r11);
            ProducerScope r12 = r5;
            int r6 = r2;
            ChannelIterator<E> r3 = r4;
        L11:
            this.L$0 = r12;
            this.L$1 = r3;
            this.I$0 = r6;
            this.label = 1;
            Object r7 = r3.hasNext(this);
            if (r7 != r0) goto L14;
            return r0;
        L14:
            ProducerScope r8 = r12;
            r11 = r7;
            int r9 = r6;
            ChannelIterator<E> r10 = r3;
            int r13 = r9;
        L16:
            if (((Boolean) r11).booleanValue() == false) goto L22;
            int r14 = r13 + 1;
            this.L$0 = r8;
            this.L$1 = r10;
            this.I$0 = r14;
            this.label = 2;
            if (r8.send(new IndexedValue(r13, r10.next()), this) != r0) goto L20;
            return r0;
        L20:
            r3 = r10;
            r12 = r8;
            r6 = r14;
            goto L11
        L22:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            r13 = this.I$0;
            r10 = (ChannelIterator) this.L$1;
            r8 = (ProducerScope) this.L$0;
            ResultKt.throwOnFailure(r11);
            goto L16
        L10:
            ResultKt.throwOnFailure(r11);
            r12 = (ProducerScope) this.L$0;
            r3 = this.$this_withIndex.iterator();
            r6 = 0;
            goto L11
        }
    }

    /* JADX INFO: Add missing generic type declarations: [V] */
    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$zip$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u0005H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.LONGITUDE_EAST, "R", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$zip$2", f = "Deprecated.kt", i = {0, 0, 0, 1, 1, 1, 1, 2, 2, 2}, l = {487, 469, 471}, m = "invokeSuspend", n = {"$this$produce", "otherIterator", "$this$consume$iv$iv", "$this$produce", "otherIterator", "$this$consume$iv$iv", "element1", "$this$produce", "otherIterator", "$this$consume$iv$iv"}, s = {"L$0", "L$1", "L$3", "L$0", "L$1", "L$3", "L$5", "L$0", "L$1", "L$3"})
    static final class C04802<V> extends SuspendLambda implements Function2<ProducerScope<? super V>, Continuation<? super Unit>, Object> {
        final /* synthetic */ ReceiveChannel<R> $other;
        final /* synthetic */ ReceiveChannel<E> $this_zip;
        final /* synthetic */ Function2<E, R, V> $transform;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        C04802(ReceiveChannel<? extends R> r1, ReceiveChannel<? extends E> r2, Function2<? super E, ? super R, ? extends V> r3, Continuation<? super C04802> r4) {
            this.$other = r1;
            this.$this_zip = r2;
            this.$transform = r3;
            super(2, r4);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            C04802 r0 = new C04802(this.$other, this.$this_zip, this.$transform, r5);
            r0.L$0 = r4;
            return r0;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object r1, Continuation<? super Unit> r2) {
            return invoke((ProducerScope) r1, r2);
        }

        public final Object invoke(ProducerScope<? super V> r1, Continuation<? super Unit> r2) {
            return ((C04802) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r13) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L20;
            if (r1 == 1) goto L17;
            if (r1 == 2) goto L12;
            if (r1 != 3) goto L11;
            ChannelIterator r2 = (ChannelIterator) this.L$4;
            ReceiveChannel r6 = (ReceiveChannel) this.L$3;
            Function2 r7 = (Function2) this.L$2;
            ChannelIterator r8 = (ChannelIterator) this.L$1;
            ProducerScope r9 = (ProducerScope) this.L$0;
            ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L40
        L22:
            this.L$0 = r9;     // Catch: Throwable -> L40
            this.L$1 = r8;     // Catch: Throwable -> L40
            this.L$2 = r7;     // Catch: Throwable -> L40
            this.L$3 = r6;     // Catch: Throwable -> L40
            this.L$4 = r2;     // Catch: Throwable -> L40
            this.L$5 = null;     // Catch: Throwable -> L40
            this.label = 1;     // Catch: Throwable -> L40
            r13 = r2.hasNext(this);     // Catch: Throwable -> L40
            if (r13 != r0) goto L26;
            return r0;
        L26:
            if (((Boolean) r13).booleanValue() == false) goto L37;
            Object r14 = r2.next();     // Catch: Throwable -> L40
            this.L$0 = r9;     // Catch: Throwable -> L40
            this.L$1 = r8;     // Catch: Throwable -> L40
            this.L$2 = r7;     // Catch: Throwable -> L40
            this.L$3 = r6;     // Catch: Throwable -> L40
            this.L$4 = r2;     // Catch: Throwable -> L40
            this.L$5 = r14;     // Catch: Throwable -> L40
            this.label = 2;     // Catch: Throwable -> L40
            Object r10 = r8.hasNext(this);     // Catch: Throwable -> L40
            if (r10 != r0) goto L30;
            return r0;
        L30:
            ReceiveChannel r11 = r6;
            Object r12 = r14;
            r13 = r10;
            ProducerScope r15 = r9;
            ChannelIterator r16 = r8;
            Function2 r17 = r7;
            ReceiveChannel r18 = r11;
        L31:
            if (((Boolean) r13).booleanValue() == false) goto L36;
            Object r19 = r17.invoke(r12, r16.next());     // Catch: Throwable -> L15
            this.L$0 = r15;     // Catch: Throwable -> L15
            this.L$1 = r16;     // Catch: Throwable -> L15
            this.L$2 = r17;     // Catch: Throwable -> L15
            this.L$3 = r18;     // Catch: Throwable -> L15
            this.L$4 = r2;     // Catch: Throwable -> L15
            this.L$5 = null;     // Catch: Throwable -> L15
            this.label = 3;     // Catch: Throwable -> L15
            if (r15.send(r19, this) != r0) goto L36;
            return r0;
        L36:
            r6 = r18;
            r7 = r17;
            r8 = r16;
            r9 = r15;
            goto L22
        L51:
            r6 = r18;
            r7 = r17;
            r8 = r16;
            r9 = r15;
        L15:
            th = th;
            r6 = r18;
        L49:
            throw th;     // Catch: Throwable -> L42
        L42:
            th = move-exception;
            ChannelsKt.cancelConsumed(r6, th);
            throw th;
        L37:
            Unit r110 = Unit.INSTANCE;     // Catch: Throwable -> L40
            ChannelsKt.cancelConsumed(r6, null);
            return Unit.INSTANCE;
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L12:
            Object r3 = this.L$5;
            ChannelIterator r20 = (ChannelIterator) this.L$4;
            r18 = (ReceiveChannel) this.L$3;
            r17 = (Function2) this.L$2;
            r16 = (ChannelIterator) this.L$1;
            r15 = (ProducerScope) this.L$0;
            ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L15
            r12 = r3;
            r2 = r20;
            goto L31
        L17:
            r2 = (ChannelIterator) this.L$4;
            r6 = (ReceiveChannel) this.L$3;
            r7 = (Function2) this.L$2;
            r8 = (ChannelIterator) this.L$1;
            r9 = (ProducerScope) this.L$0;
            ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L40
            goto L26
        L20:
            ResultKt.throwOnFailure(r13);
            ProducerScope r111 = (ProducerScope) this.L$0;
            ChannelIterator r4 = this.$other.iterator();
            r6 = this.$this_zip;
            r7 = this.$transform;
            r9 = r111;
            r8 = r4;
            r2 = r6.iterator();     // Catch: Throwable -> L40
        L40:
            th = th;
            goto L49
        }
    }

    public static final Function1<Throwable, Unit> consumesAll(final ReceiveChannel<?>... r1) {
        return new C04461(r1);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0060 -> B:25:0x0065). Please report as a decompilation issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object elementAt(ReceiveChannel r9, int r10, Continuation r11) {
        if ((r11 instanceof C04521) == false) goto L7;
        C04521 r0 = (C04521) r11;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L18;
        if (r2 != 1) goto L17;
        int r13 = r0.I$1;
        r10 = r0.I$0;
        ChannelIterator r3 = (ChannelIterator) r0.L$1;
        ReceiveChannel r6 = (ReceiveChannel) r0.L$0;
        ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L14
    L26:
        if (((Boolean) r12).booleanValue() == false) goto L34;
        Object r14 = r3.next();     // Catch: Throwable -> L14
        int r7 = r13 + 1;
        if (r10 != r13) goto L32;
        ChannelsKt.cancelConsumed(r6, null);
        return r14;
    L32:
        ChannelIterator r15 = r3;
        r9 = r6;
        int r4 = r7;
    L21:
        r0.L$0 = r9;     // Catch: Throwable -> L35
        r0.L$1 = r15;     // Catch: Throwable -> L35
        r0.I$0 = r10;     // Catch: Throwable -> L35
        r0.I$1 = r4;     // Catch: Throwable -> L35
        r0.label = 1;     // Catch: Throwable -> L35
        Object r8 = r15.hasNext(r0);     // Catch: Throwable -> L35
        if (r8 != r1) goto L24;
        return r1;
    L24:
        r6 = r9;
        r13 = r4;
        r3 = r15;
        r12 = r8;
        goto L26
    L34:
        throw new IndexOutOfBoundsException("ReceiveChannel doesn't contain element at index " + r10 + '.');     // Catch: Throwable -> L14
    L14:
        Throwable th = th;
    L43:
        throw th;     // Catch: Throwable -> L40
    L40:
        th = move-exception;
        ChannelsKt.cancelConsumed(r6, th);
        throw th;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r12);
        if (r10 < 0) goto L38;
        r15 = r9.iterator();     // Catch: Throwable -> L35
        r4 = 0;
        goto L21
    L38:
        throw new IndexOutOfBoundsException("ReceiveChannel doesn't contain element at index " + r10 + '.');     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        r6 = r9;
        th = th;
    L7:
        r0 = new C04521(r11);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0066 -> B:27:0x006b). Please report as a decompilation issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object elementAtOrNull(ReceiveChannel r8, int r9, Continuation r10) {
        if ((r10 instanceof C04531) == false) goto L7;
        C04531 r0 = (C04531) r10;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L18;
        if (r2 != 1) goto L17;
        int r12 = r0.I$1;
        r9 = r0.I$0;
        ChannelIterator r3 = (ChannelIterator) r0.L$1;
        ReceiveChannel r5 = (ReceiveChannel) r0.L$0;
        ResultKt.throwOnFailure(r11);     // Catch: Throwable -> L14
        int r4 = r12;
        r8 = r5;
        Object r6 = r1;
        C04531 r7 = r0;
        ChannelIterator r13 = r3;
    L27:
        if (((Boolean) r11).booleanValue() == false) goto L35;
        Object r14 = r13.next();     // Catch: Throwable -> L37
        int r15 = r4 + 1;
        if (r9 != r4) goto L34;
        ChannelsKt.cancelConsumed(r8, null);
        return r14;
    L34:
        ChannelIterator r16 = r13;
        r0 = r7;
        r1 = r6;
        r4 = r15;
    L23:
        r0.L$0 = r8;     // Catch: Throwable -> L37
        r0.L$1 = r16;     // Catch: Throwable -> L37
        r0.I$0 = r9;     // Catch: Throwable -> L37
        r0.I$1 = r4;     // Catch: Throwable -> L37
        r0.label = 1;     // Catch: Throwable -> L37
        Object r17 = r16.hasNext(r0);     // Catch: Throwable -> L37
        if (r17 != r1) goto L26;
        return r1;
    L26:
        C04531 r18 = r0;
        r13 = r16;
        r11 = r17;
        r6 = r1;
        r7 = r18;
        goto L27
    L35:
        ChannelsKt.cancelConsumed(r8, null);
        return null;
    L37:
        th = move-exception;
        r5 = r8;
        Throwable th = th;
    L45:
        throw th;     // Catch: Throwable -> L40
    L40:
        th = move-exception;
        ChannelsKt.cancelConsumed(r5, th);
        throw th;
    L14:
        th = th;
        goto L45
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r11);
        if (r9 >= 0) goto L43;
        ChannelsKt.cancelConsumed(r8, null);
        return null;
    L43:
        r16 = r8.iterator();     // Catch: Throwable -> L37
        r4 = 0;
    L7:
        r0 = new C04531(r10);
        goto L8
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object first(ReceiveChannel r5, Continuation r6) {
        if ((r6 instanceof C04591) == false) goto L7;
        C04591 r0 = (C04591) r6;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L18;
        if (r2 != 1) goto L17;
        ChannelIterator r8 = (ChannelIterator) r0.L$1;
        ReceiveChannel r3 = (ReceiveChannel) r0.L$0;
        ResultKt.throwOnFailure(r7);     // Catch: Throwable -> L14
    L24:
        if (((Boolean) r7).booleanValue() == false) goto L29;
        Object r9 = r8.next();     // Catch: Throwable -> L14
        ChannelsKt.cancelConsumed(r3, null);
        return r9;
    L29:
        throw new NoSuchElementException("ReceiveChannel is empty.");     // Catch: Throwable -> L14
    L14:
        Throwable th = th;
    L36:
        throw th;     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        ChannelsKt.cancelConsumed(r3, th);
        throw th;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r7);
        ChannelIterator r10 = r5.iterator();     // Catch: Throwable -> L30
        r0.L$0 = r5;     // Catch: Throwable -> L30
        r0.L$1 = r10;     // Catch: Throwable -> L30
        r0.label = 1;     // Catch: Throwable -> L30
        Object r4 = r10.hasNext(r0);     // Catch: Throwable -> L30
        if (r4 != r1) goto L22;
        return r1;
    L22:
        r3 = r5;
        r8 = r10;
        r7 = r4;
    L30:
        th = move-exception;
        r3 = r5;
        th = th;
    L7:
        r0 = new C04591(r6);
        goto L8
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object firstOrNull(ReceiveChannel r5, Continuation r6) {
        if ((r6 instanceof C04601) == false) goto L7;
        C04601 r0 = (C04601) r6;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L18;
        if (r2 != 1) goto L17;
        ChannelIterator r8 = (ChannelIterator) r0.L$1;
        ReceiveChannel r3 = (ReceiveChannel) r0.L$0;
        ResultKt.throwOnFailure(r7);     // Catch: Throwable -> L14
    L25:
        if (((Boolean) r7).booleanValue() == true) goto L28;
        ChannelsKt.cancelConsumed(r3, null);
        return null;
    L28:
        Object r9 = r8.next();     // Catch: Throwable -> L14
        ChannelsKt.cancelConsumed(r3, null);
        return r9;
    L14:
        Throwable th = th;
    L41:
        throw th;     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        ChannelsKt.cancelConsumed(r3, th);
        throw th;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r7);
        ChannelIterator r10 = r5.iterator();     // Catch: Throwable -> L31
        r0.L$0 = r5;     // Catch: Throwable -> L31
        r0.L$1 = r10;     // Catch: Throwable -> L31
        r0.label = 1;     // Catch: Throwable -> L31
        Object r4 = r10.hasNext(r0);     // Catch: Throwable -> L31
        if (r4 != r1) goto L22;
        return r1;
    L22:
        r3 = r5;
        r8 = r10;
        r7 = r4;
    L31:
        th = move-exception;
        r3 = r5;
        th = th;
    L7:
        r0 = new C04601(r6);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0065 -> B:25:0x0068). Please report as a decompilation issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object indexOf(ReceiveChannel r7, Object r8, Continuation r9) {
        if ((r9 instanceof C04621) == false) goto L7;
        C04621 r0 = (C04621) r9;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L18;
        if (r2 != 1) goto L17;
        ChannelIterator r11 = (ChannelIterator) r0.L$3;
        ReceiveChannel r12 = (ReceiveChannel) r0.L$2;
        Ref.IntRef r3 = (Ref.IntRef) r0.L$1;
        Object r4 = r0.L$0;
        ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L14
    L26:
        if (((Boolean) r10).booleanValue() == true) goto L28;
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L14
        ChannelsKt.cancelConsumed(r12, null);
        return Boxing.boxInt(-1);
    L28:
        if (Intrinsics.areEqual(r4, r11.next()) == false) goto L32;
        Integer r14 = Boxing.boxInt(r3.element);     // Catch: Throwable -> L14
        ChannelsKt.cancelConsumed(r12, null);
        return r14;
    L32:
        r3.element++;     // Catch: Throwable -> L14
        Object r15 = r4;
    L21:
        r0.L$0 = r15;     // Catch: Throwable -> L14
        r0.L$1 = r3;     // Catch: Throwable -> L14
        r0.L$2 = r12;     // Catch: Throwable -> L14
        r0.L$3 = r11;     // Catch: Throwable -> L14
        r0.label = 1;     // Catch: Throwable -> L14
        Object r5 = r11.hasNext(r0);     // Catch: Throwable -> L14
        if (r5 != r1) goto L24;
        return r1;
    L24:
        r4 = r15;
        r10 = r5;
    L14:
        Throwable th = th;
    L45:
        throw th;     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        ChannelsKt.cancelConsumed(r12, th);
        throw th;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r10);
        Ref.IntRef r16 = new Ref.IntRef();
        r12 = r7;
        r11 = r7.iterator();     // Catch: Throwable -> L36
        r3 = r16;
        r15 = r8;
    L36:
        th = move-exception;
        r12 = r7;
        th = th;
    L7:
        r0 = new C04621(r9);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x0087 -> B:37:0x008b). Please report as a decompilation issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object last(ReceiveChannel r6, Continuation r7) {
        if ((r7 instanceof C04631) == false) goto L7;
        C04631 r0 = (C04631) r7;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L24;
        if (r2 == 1) goto L19;
        if (r2 != 2) goto L18;
        Object r9 = r0.L$2;
        ChannelIterator r3 = (ChannelIterator) r0.L$1;
        ReceiveChannel r4 = (ReceiveChannel) r0.L$0;
        ResultKt.throwOnFailure(r8);     // Catch: Throwable -> L15
    L37:
        if (((Boolean) r8).booleanValue() == false) goto L41;
        Object r10 = r3.next();     // Catch: Throwable -> L15
        r6 = r4;
    L33:
        r0.L$0 = r6;     // Catch: Throwable -> L45
        r0.L$1 = r3;     // Catch: Throwable -> L45
        r0.L$2 = r10;     // Catch: Throwable -> L45
        r0.label = 2;     // Catch: Throwable -> L45
        Object r5 = r3.hasNext(r0);     // Catch: Throwable -> L45
        if (r5 != r1) goto L36;
        return r1;
    L36:
        r4 = r6;
        r9 = r10;
        r8 = r5;
    L45:
        th = move-exception;
        ReceiveChannel r11 = r6;
        th = th;
    L55:
        throw th;     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        ChannelsKt.cancelConsumed(r11, th);
        throw th;
    L41:
        ChannelsKt.cancelConsumed(r4, null);
        return r9;
    L15:
        th = th;
        r11 = r4;
        goto L55
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        ChannelIterator r12 = (ChannelIterator) r0.L$1;
        r11 = (ReceiveChannel) r0.L$0;
        ResultKt.throwOnFailure(r8);     // Catch: Throwable -> L22
    L30:
        if (((Boolean) r8).booleanValue() == false) goto L44;
        r10 = r12.next();     // Catch: Throwable -> L22
        ReceiveChannel r13 = r11;
        r3 = r12;
        r6 = r13;
        goto L33
    L44:
        throw new NoSuchElementException("ReceiveChannel is empty.");     // Catch: Throwable -> L22
    L22:
        th = th;
        goto L55
    L24:
        ResultKt.throwOnFailure(r8);
        ChannelIterator r14 = r6.iterator();     // Catch: Throwable -> L45
        r0.L$0 = r6;     // Catch: Throwable -> L45
        r0.L$1 = r14;     // Catch: Throwable -> L45
        r0.label = 1;     // Catch: Throwable -> L45
        Object r15 = r14.hasNext(r0);     // Catch: Throwable -> L45
        if (r15 != r1) goto L28;
        return r1;
    L28:
        r11 = r6;
        r12 = r14;
        r8 = r15;
    L7:
        r0 = new C04631(r7);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0073 -> B:25:0x0076). Please report as a decompilation issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object lastIndexOf(ReceiveChannel r7, Object r8, Continuation r9) {
        if ((r9 instanceof C04641) == false) goto L7;
        C04641 r0 = (C04641) r9;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L18;
        if (r2 != 1) goto L17;
        ChannelIterator r11 = (ChannelIterator) r0.L$4;
        ReceiveChannel r12 = (ReceiveChannel) r0.L$3;
        Ref.IntRef r3 = (Ref.IntRef) r0.L$2;
        Ref.IntRef r4 = (Ref.IntRef) r0.L$1;
        Object r5 = r0.L$0;
        ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L14
    L26:
        if (((Boolean) r10).booleanValue() == true) goto L28;
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L14
        ChannelsKt.cancelConsumed(r12, null);
        return Boxing.boxInt(r4.element);
    L28:
        if (Intrinsics.areEqual(r5, r11.next()) == false) goto L30;
        r4.element = r3.element;     // Catch: Throwable -> L14
    L30:
        r3.element++;     // Catch: Throwable -> L14
        Object r14 = r5;
    L21:
        r0.L$0 = r14;     // Catch: Throwable -> L14
        r0.L$1 = r4;     // Catch: Throwable -> L14
        r0.L$2 = r3;     // Catch: Throwable -> L14
        r0.L$3 = r12;     // Catch: Throwable -> L14
        r0.L$4 = r11;     // Catch: Throwable -> L14
        r0.label = 1;     // Catch: Throwable -> L14
        Object r6 = r11.hasNext(r0);     // Catch: Throwable -> L14
        if (r6 != r1) goto L24;
        return r1;
    L24:
        r5 = r14;
        r10 = r6;
    L14:
        Throwable th = th;
    L42:
        throw th;     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        ChannelsKt.cancelConsumed(r12, th);
        throw th;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r10);
        Ref.IntRef r15 = new Ref.IntRef();
        r15.element = -1;
        r3 = new Ref.IntRef();
        r12 = r7;
        r11 = r7.iterator();     // Catch: Throwable -> L34
        r4 = r15;
        r14 = r8;
    L34:
        th = move-exception;
        r12 = r7;
        th = th;
    L7:
        r0 = new C04641(r9);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x008c -> B:39:0x0090). Please report as a decompilation issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object lastOrNull(ReceiveChannel r7, Continuation r8) {
        if ((r8 instanceof C04651) == false) goto L7;
        C04651 r0 = (C04651) r8;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L24;
        if (r2 == 1) goto L19;
        if (r2 != 2) goto L18;
        Object r10 = r0.L$2;
        ChannelIterator r3 = (ChannelIterator) r0.L$1;
        ReceiveChannel r4 = (ReceiveChannel) r0.L$0;
        ResultKt.throwOnFailure(r9);     // Catch: Throwable -> L15
    L39:
        if (((Boolean) r9).booleanValue() == false) goto L43;
        Object r11 = r3.next();     // Catch: Throwable -> L15
        r7 = r4;
    L35:
        r0.L$0 = r7;     // Catch: Throwable -> L45
        r0.L$1 = r3;     // Catch: Throwable -> L45
        r0.L$2 = r11;     // Catch: Throwable -> L45
        r0.label = 2;     // Catch: Throwable -> L45
        Object r5 = r3.hasNext(r0);     // Catch: Throwable -> L45
        if (r5 != r1) goto L38;
        return r1;
    L38:
        r4 = r7;
        r10 = r11;
        r9 = r5;
    L45:
        th = move-exception;
        ReceiveChannel r6 = r7;
        th = th;
    L55:
        throw th;     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        ChannelsKt.cancelConsumed(r6, th);
        throw th;
    L43:
        ChannelsKt.cancelConsumed(r4, null);
        return r10;
    L15:
        th = th;
        r6 = r4;
        goto L55
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        ChannelIterator r12 = (ChannelIterator) r0.L$1;
        r6 = (ReceiveChannel) r0.L$0;
        ResultKt.throwOnFailure(r9);     // Catch: Throwable -> L22
    L30:
        if (((Boolean) r9).booleanValue() == true) goto L33;
        ChannelsKt.cancelConsumed(r6, null);
        return null;
    L33:
        r11 = r12.next();     // Catch: Throwable -> L22
        ReceiveChannel r13 = r6;
        r3 = r12;
        r7 = r13;
    L22:
        th = th;
        goto L55
    L24:
        ResultKt.throwOnFailure(r9);
        ChannelIterator r14 = r7.iterator();     // Catch: Throwable -> L45
        r0.L$0 = r7;     // Catch: Throwable -> L45
        r0.L$1 = r14;     // Catch: Throwable -> L45
        r0.label = 1;     // Catch: Throwable -> L45
        Object r15 = r14.hasNext(r0);     // Catch: Throwable -> L45
        if (r15 != r1) goto L28;
        return r1;
    L28:
        r6 = r7;
        r12 = r14;
        r9 = r15;
    L7:
        r0 = new C04651(r8);
        goto L8
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object single(ReceiveChannel r6, Continuation r7) {
        if ((r7 instanceof C04721) == false) goto L7;
        C04721 r0 = (C04721) r7;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L24;
        if (r2 == 1) goto L19;
        if (r2 != 2) goto L18;
        Object r9 = r0.L$1;
        ReceiveChannel r3 = (ReceiveChannel) r0.L$0;
        ResultKt.throwOnFailure(r8);     // Catch: Throwable -> L15
    L36:
        if (((Boolean) r8).booleanValue() == true) goto L40;
        ChannelsKt.cancelConsumed(r3, null);
        return r9;
    L40:
        throw new IllegalArgumentException("ReceiveChannel has more than one element.");     // Catch: Throwable -> L15
    L15:
        Throwable th = th;
        ReceiveChannel r4 = r3;
    L49:
        throw th;     // Catch: Throwable -> L46
    L46:
        th = move-exception;
        ChannelsKt.cancelConsumed(r4, th);
        throw th;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        ChannelIterator r10 = (ChannelIterator) r0.L$1;
        r4 = (ReceiveChannel) r0.L$0;
        ResultKt.throwOnFailure(r8);     // Catch: Throwable -> L22
    L30:
        if (((Boolean) r8).booleanValue() == false) goto L42;
        Object r11 = r10.next();     // Catch: Throwable -> L22
        r0.L$0 = r4;     // Catch: Throwable -> L22
        r0.L$1 = r11;     // Catch: Throwable -> L22
        r0.label = 2;     // Catch: Throwable -> L22
        Object r12 = r10.hasNext(r0);     // Catch: Throwable -> L22
        if (r12 != r1) goto L34;
        return r1;
    L34:
        r3 = r4;
        r8 = r12;
        r9 = r11;
        goto L36
    L42:
        throw new NoSuchElementException("ReceiveChannel is empty.");     // Catch: Throwable -> L22
    L22:
        th = th;
        goto L49
    L24:
        ResultKt.throwOnFailure(r8);
        ChannelIterator r13 = r6.iterator();     // Catch: Throwable -> L43
        r0.L$0 = r6;     // Catch: Throwable -> L43
        r0.L$1 = r13;     // Catch: Throwable -> L43
        r0.label = 1;     // Catch: Throwable -> L43
        Object r5 = r13.hasNext(r0);     // Catch: Throwable -> L43
        if (r5 != r1) goto L28;
        return r1;
    L28:
        r4 = r6;
        r10 = r13;
        r8 = r5;
    L43:
        th = move-exception;
        r4 = r6;
        th = th;
    L7:
        r0 = new C04721(r7);
        goto L8
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object singleOrNull(ReceiveChannel r7, Continuation r8) {
        if ((r8 instanceof C04731) == false) goto L7;
        C04731 r0 = (C04731) r8;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L24;
        if (r2 == 1) goto L19;
        if (r2 != 2) goto L18;
        Object r10 = r0.L$1;
        ReceiveChannel r3 = (ReceiveChannel) r0.L$0;
        ResultKt.throwOnFailure(r9);     // Catch: Throwable -> L15
    L37:
        if (((Boolean) r9).booleanValue() == false) goto L41;
        ChannelsKt.cancelConsumed(r3, null);
        return null;
    L41:
        ChannelsKt.cancelConsumed(r3, null);
        return r10;
    L15:
        Throwable th = th;
        ReceiveChannel r4 = r3;
    L53:
        throw th;     // Catch: Throwable -> L46
    L46:
        th = move-exception;
        ChannelsKt.cancelConsumed(r4, th);
        throw th;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        ChannelIterator r11 = (ChannelIterator) r0.L$1;
        r4 = (ReceiveChannel) r0.L$0;
        ResultKt.throwOnFailure(r9);     // Catch: Throwable -> L22
    L30:
        if (((Boolean) r9).booleanValue() == true) goto L33;
        ChannelsKt.cancelConsumed(r4, null);
        return null;
    L33:
        Object r12 = r11.next();     // Catch: Throwable -> L22
        r0.L$0 = r4;     // Catch: Throwable -> L22
        r0.L$1 = r12;     // Catch: Throwable -> L22
        r0.label = 2;     // Catch: Throwable -> L22
        Object r13 = r11.hasNext(r0);     // Catch: Throwable -> L22
        if (r13 != r1) goto L36;
        return r1;
    L36:
        r3 = r4;
        r9 = r13;
        r10 = r12;
    L22:
        th = th;
        goto L53
    L24:
        ResultKt.throwOnFailure(r9);
        ChannelIterator r14 = r7.iterator();     // Catch: Throwable -> L43
        r0.L$0 = r7;     // Catch: Throwable -> L43
        r0.L$1 = r14;     // Catch: Throwable -> L43
        r0.label = 1;     // Catch: Throwable -> L43
        Object r5 = r14.hasNext(r0);     // Catch: Throwable -> L43
        if (r5 != r1) goto L28;
        return r1;
    L28:
        r4 = r7;
        r11 = r14;
        r9 = r5;
    L43:
        th = move-exception;
        r4 = r7;
        th = th;
    L7:
        r0 = new C04731(r8);
        goto L8
    }

    public static /* synthetic */ ReceiveChannel drop$default(ReceiveChannel r0, int r1, CoroutineDispatcher r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = Dispatchers.getUnconfined();
    L6:
        return ChannelsKt.drop(r0, r1, r2);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ ReceiveChannel drop(ReceiveChannel r9, int r10, CoroutineContext r11) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, r11, 0, null, ChannelsKt.consumes(r9), new C04501(r10, r9, null), 6, null);
    }

    public static /* synthetic */ ReceiveChannel dropWhile$default(ReceiveChannel r0, CoroutineDispatcher r1, Function2 r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = Dispatchers.getUnconfined();
    L6:
        return ChannelsKt.dropWhile(r0, r1, r2);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ ReceiveChannel dropWhile(ReceiveChannel r9, CoroutineContext r10, Function2 r11) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, r10, 0, null, ChannelsKt.consumes(r9), new C04511(r9, r11, null), 6, null);
    }

    public static /* synthetic */ ReceiveChannel filter$default(ReceiveChannel r0, CoroutineDispatcher r1, Function2 r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = Dispatchers.getUnconfined();
    L6:
        return ChannelsKt.filter(r0, r1, r2);
    }

    public static final <E> ReceiveChannel<E> filter(ReceiveChannel<? extends E> r9, CoroutineContext r10, Function2<? super E, ? super Continuation<? super Boolean>, ? extends Object> r11) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, r10, 0, null, ChannelsKt.consumes(r9), new C04541(r9, r11, null), 6, null);
    }

    public static /* synthetic */ ReceiveChannel filterIndexed$default(ReceiveChannel r0, CoroutineDispatcher r1, Function3 r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = Dispatchers.getUnconfined();
    L6:
        return ChannelsKt.filterIndexed(r0, r1, r2);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ ReceiveChannel filterIndexed(ReceiveChannel r9, CoroutineContext r10, Function3 r11) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, r10, 0, null, ChannelsKt.consumes(r9), new C04551(r9, r11, null), 6, null);
    }

    public static /* synthetic */ ReceiveChannel filterNot$default(ReceiveChannel r0, CoroutineDispatcher r1, Function2 r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = Dispatchers.getUnconfined();
    L6:
        return ChannelsKt.filterNot(r0, r1, r2);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ ReceiveChannel filterNot(ReceiveChannel r2, CoroutineContext r3, Function2 r4) {
        return ChannelsKt.filter(r2, r3, new C04561(r4, null));
    }

    public static final <E> ReceiveChannel<E> filterNotNull(ReceiveChannel<? extends E> r3) {
        return ChannelsKt.filter$default(r3, null, new C04571(null), 1, null);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x005a -> B:25:0x005d). Please report as a decompilation issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object filterNotNullTo(ReceiveChannel r5, Collection r6, Continuation r7) {
        if ((r7 instanceof C04581) == false) goto L7;
        C04581 r0 = (C04581) r7;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L18;
        if (r2 != 1) goto L17;
        ChannelIterator r9 = (ChannelIterator) r0.L$2;
        ReceiveChannel r10 = (ReceiveChannel) r0.L$1;
        Collection r3 = (Collection) r0.L$0;
        ResultKt.throwOnFailure(r8);     // Catch: Throwable -> L14
    L26:
        if (((Boolean) r8).booleanValue() == false) goto L31;
        Object r11 = r9.next();     // Catch: Throwable -> L14
        if (r11 == null) goto L30;
        r3.add(r11);     // Catch: Throwable -> L14
    L30:
        Collection r12 = r3;
    L21:
        r0.L$0 = r12;     // Catch: Throwable -> L14
        r0.L$1 = r10;     // Catch: Throwable -> L14
        r0.L$2 = r9;     // Catch: Throwable -> L14
        r0.label = 1;     // Catch: Throwable -> L14
        Object r4 = r9.hasNext(r0);     // Catch: Throwable -> L14
        if (r4 != r1) goto L24;
        return r1;
    L24:
        r3 = r12;
        r8 = r4;
        goto L26
    L31:
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L14
        ChannelsKt.cancelConsumed(r10, null);
        return r3;
    L14:
        Throwable th = th;
    L44:
        throw th;     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        ChannelsKt.cancelConsumed(r10, th);
        throw th;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r8);
        r10 = r5;
        r9 = r5.iterator();     // Catch: Throwable -> L34
        r12 = r6;
    L34:
        th = move-exception;
        r10 = r5;
        th = th;
    L7:
        r0 = new C04581(r7);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [kotlinx.coroutines.channels.SendChannel] */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11, types: [java.lang.Object, kotlinx.coroutines.channels.SendChannel] */
    /* JADX WARN: Type inference failed for: r7v12, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8, types: [kotlinx.coroutines.channels.ReceiveChannel] */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object filterNotNullTo(ReceiveChannel r6, SendChannel r7, Continuation r8) {
        if ((r8 instanceof AnonymousClass3) == false) goto L7;
        AnonymousClass3 r0 = (AnonymousClass3) r8;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 != 0) goto L48;
        ResultKt.throwOnFailure(r9);
        ChannelIterator r10 = r6.iterator();     // Catch: Throwable -> L40
    L25:
        r0.L$0 = r7;     // Catch: Throwable -> L40
        r0.L$1 = r6;     // Catch: Throwable -> L40
        r0.L$2 = r10;     // Catch: Throwable -> L40
        r0.label = 1;     // Catch: Throwable -> L40
        Object r3 = r10.hasNext(r0);     // Catch: Throwable -> L40
        if (r3 != r1) goto L28;
        return r1;
    L28:
        AnonymousClass3 r5 = r0;
        ChannelIterator r4 = r10;
        r9 = r3;
        r7 = r7;
    L20:
        Object r11 = r1;
        AnonymousClass3 r12 = r5;
        if (((Boolean) r9).booleanValue() == false) goto L37;
        Object r13 = r4.next();     // Catch: Throwable -> L40
        if (r13 == null) goto L36;
        r12.L$0 = r7;     // Catch: Throwable -> L40
        r12.L$1 = r6;     // Catch: Throwable -> L40
        r12.L$2 = r4;     // Catch: Throwable -> L40
        r12.label = 2;     // Catch: Throwable -> L40
        if (r7.send(r13, r12) != r11) goto L36;
        return r11;
    L36:
        r10 = r4;
        r0 = r12;
        r1 = r11;
        goto L25
    L51:
        r10 = r4;
        r0 = r12;
        r1 = r11;
        goto L25
    L37:
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L40
        ChannelsKt.cancelConsumed(r6, null);
        return r7;
    L40:
        th = move-exception;
        r7 = r6;
        th = th;
    L46:
        throw th;     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        ChannelsKt.cancelConsumed(r7, th);
        throw th;
    L48:
        if (r2 == 1) goto L17;
        if (r2 != 2) goto L16;
        ChannelIterator r15 = (ChannelIterator) r0.L$2;
        ReceiveChannel r16 = (ReceiveChannel) r0.L$1;
        SendChannel r17 = (SendChannel) r0.L$0;
        ResultKt.throwOnFailure(r9);     // Catch: Throwable -> L21
        r10 = r15;
        r6 = r16;
        r7 = r17;
        goto L25
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ChannelIterator r18 = (ChannelIterator) r0.L$2;
        ReceiveChannel r19 = (ReceiveChannel) r0.L$1;
        SendChannel r20 = (SendChannel) r0.L$0;
        ResultKt.throwOnFailure(r9);     // Catch: Throwable -> L21
        r5 = r0;
        r4 = r18;
        r6 = r19;
        r7 = r20;
    L21:
        th = th;
    L7:
        r0 = new AnonymousClass3(r8);
        goto L8
    }

    public static /* synthetic */ ReceiveChannel take$default(ReceiveChannel r0, int r1, CoroutineDispatcher r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = Dispatchers.getUnconfined();
    L6:
        return ChannelsKt.take(r0, r1, r2);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ ReceiveChannel take(ReceiveChannel r9, int r10, CoroutineContext r11) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, r11, 0, null, ChannelsKt.consumes(r9), new C04741(r10, r9, null), 6, null);
    }

    public static /* synthetic */ ReceiveChannel takeWhile$default(ReceiveChannel r0, CoroutineDispatcher r1, Function2 r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = Dispatchers.getUnconfined();
    L6:
        return ChannelsKt.takeWhile(r0, r1, r2);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ ReceiveChannel takeWhile(ReceiveChannel r9, CoroutineContext r10, Function2 r11) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, r10, 0, null, ChannelsKt.consumes(r9), new C04751(r9, r11, null), 6, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object, kotlinx.coroutines.channels.SendChannel] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r7v0, types: [C extends kotlinx.coroutines.channels.SendChannel<? super E>] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v18 */
    /* JADX WARN: Type inference failed for: r7v2, types: [kotlinx.coroutines.channels.ReceiveChannel] */
    /* JADX WARN: Type inference failed for: r7v21 */
    /* JADX WARN: Type inference failed for: r7v22 */
    /* JADX WARN: Type inference failed for: r7v23 */
    /* JADX WARN: Type inference failed for: r7v24 */
    /* JADX WARN: Type inference failed for: r7v25 */
    /* JADX WARN: Type inference failed for: r7v26 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.lang.Object, kotlinx.coroutines.channels.ReceiveChannel] */
    /* JADX WARN: Type inference failed for: r7v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x0089 -> B:14:0x0038). Please report as a decompilation issue!!! */
    public static final <E, C extends SendChannel<? super E>> Object toChannel(ReceiveChannel<? extends E> r6, C r7, Continuation<? super C> r8) {
        if ((r8 instanceof C04761) == false) goto L7;
        C04761 r0 = (C04761) r8;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L22;
        if (r2 == 1) goto L17;
        if (r2 != 2) goto L16;
        ChannelIterator<? extends E> r10 = (ChannelIterator) r0.L$2;
        boolean r11 = (C) ((ReceiveChannel) r0.L$1);
        SendChannel r3 = (SendChannel) r0.L$0;
        ResultKt.throwOnFailure(r9);     // Catch: Throwable -> L20
        ?? r4 = r3;
        ?? r12 = r11;
    L14:
        ChannelIterator<? extends E> r13 = r10;
        r6 = (ReceiveChannel<? extends E>) r12;
        ?? r14 = (C) r4;
    L24:
        r0.L$0 = r14;     // Catch: Throwable -> L36
        r0.L$1 = r6;     // Catch: Throwable -> L36
        r0.L$2 = r13;     // Catch: Throwable -> L36
        r0.label = 1;     // Catch: Throwable -> L36
        Object r5 = r13.hasNext(r0);     // Catch: Throwable -> L36
        if (r5 != r1) goto L27;
        return r1;
    L27:
        ?? r15 = r14;
        boolean r16 = (C) r6;
        r10 = r13;
        r9 = r5;
        ?? r17 = r15;
        r7 = r16;
    L29:
        if (((Boolean) r9).booleanValue() == false) goto L33;
        E r18 = r10.next();     // Catch: Throwable -> L20
        r0.L$0 = r17;     // Catch: Throwable -> L20
        r0.L$1 = (Object) r7;     // Catch: Throwable -> L20
        r0.L$2 = r10;     // Catch: Throwable -> L20
        r0.label = 2;     // Catch: Throwable -> L20
        Object r19 = r17.send(r18, r0);     // Catch: Throwable -> L20
        r4 = r17;
        r12 = r7;
        if (r19 != r1) goto L14;
        return r1;
    L33:
        Unit r20 = Unit.INSTANCE;     // Catch: Throwable -> L20
        ChannelsKt.cancelConsumed((ReceiveChannel) r7, null);
        return r17;
    L36:
        th = move-exception;
        r7 = r6;
        th = th;
    L46:
        throw th;     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        ChannelsKt.cancelConsumed(r7, th);
        throw th;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        r10 = (ChannelIterator) r0.L$2;
        boolean r21 = (C) ((ReceiveChannel) r0.L$1);
        SendChannel r22 = (SendChannel) r0.L$0;
        ResultKt.throwOnFailure(r9);     // Catch: Throwable -> L20
        r17 = r22;
        r7 = r21;
        goto L29
    L22:
        ResultKt.throwOnFailure(r9);
        r13 = r6.iterator();     // Catch: Throwable -> L36
        r14 = r7;
    L20:
        th = th;
    L7:
        r0 = new C04761(r8);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object, java.util.Collection] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.lang.Object] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x005a -> B:25:0x005d). Please report as a decompilation issue!!! */
    public static final <E, C extends Collection<? super E>> Object toCollection(ReceiveChannel<? extends E> r5, C r6, Continuation<? super C> r7) {
        if ((r7 instanceof C04771) == false) goto L7;
        C04771 r0 = (C04771) r7;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L18;
        if (r2 != 1) goto L17;
        ChannelIterator r9 = (ChannelIterator) r0.L$2;
        ReceiveChannel<? extends E> r10 = (ReceiveChannel) r0.L$1;
        Collection r3 = (Collection) r0.L$0;
        ResultKt.throwOnFailure(r8);     // Catch: Throwable -> L14
        ?? r4 = r3;
    L26:
        if (((Boolean) r8).booleanValue() == false) goto L28;
        r4.add(r9.next());     // Catch: Throwable -> L14
        ?? r11 = r4;
    L21:
        r0.L$0 = r11;     // Catch: Throwable -> L14
        r0.L$1 = r10;     // Catch: Throwable -> L14
        r0.L$2 = r9;     // Catch: Throwable -> L14
        r0.label = 1;     // Catch: Throwable -> L14
        Object r12 = r9.hasNext(r0);     // Catch: Throwable -> L14
        if (r12 != r1) goto L24;
        return r1;
    L24:
        r4 = r11;
        r8 = r12;
        goto L26
    L28:
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L14
        ChannelsKt.cancelConsumed(r10, null);
        return r4;
    L14:
        Throwable th = th;
    L41:
        throw th;     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        ChannelsKt.cancelConsumed(r10, th);
        throw th;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r8);
        r10 = r5;
        r9 = r5.iterator();     // Catch: Throwable -> L31
        r11 = r6;
    L31:
        th = move-exception;
        r10 = r5;
        th = th;
    L7:
        r0 = new C04771(r7);
        goto L8
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object toMap(ReceiveChannel r1, Continuation r2) {
        return ChannelsKt.toMap(r1, new LinkedHashMap(), r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v5, types: [java.lang.Object] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x005a -> B:25:0x005d). Please report as a decompilation issue!!! */
    public static final <K, V, M extends Map<? super K, ? super V>> Object toMap(ReceiveChannel<? extends Pair<? extends K, ? extends V>> r6, M r7, Continuation<? super M> r8) {
        if ((r8 instanceof AnonymousClass2) == false) goto L7;
        AnonymousClass2 r0 = (AnonymousClass2) r8;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L18;
        if (r2 != 1) goto L17;
        ChannelIterator r10 = (ChannelIterator) r0.L$2;
        ReceiveChannel<? extends Pair<? extends K, ? extends V>> r11 = (ReceiveChannel) r0.L$1;
        Map r3 = (Map) r0.L$0;
        ResultKt.throwOnFailure(r9);     // Catch: Throwable -> L14
        ?? r4 = r3;
    L26:
        if (((Boolean) r9).booleanValue() == false) goto L28;
        Pair r12 = (Pair) r10.next();     // Catch: Throwable -> L14
        r4.put(r12.getFirst(), r12.getSecond());     // Catch: Throwable -> L14
        ?? r13 = r4;
    L21:
        r0.L$0 = r13;     // Catch: Throwable -> L14
        r0.L$1 = r11;     // Catch: Throwable -> L14
        r0.L$2 = r10;     // Catch: Throwable -> L14
        r0.label = 1;     // Catch: Throwable -> L14
        Object r5 = r10.hasNext(r0);     // Catch: Throwable -> L14
        if (r5 != r1) goto L24;
        return r1;
    L24:
        r4 = r13;
        r9 = r5;
        goto L26
    L28:
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L14
        ChannelsKt.cancelConsumed(r11, null);
        return r4;
    L14:
        Throwable th = th;
    L37:
        throw th;     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        ChannelsKt.cancelConsumed(r11, th);
        throw th;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r9);
        r11 = r6;
        r10 = r6.iterator();     // Catch: Throwable -> L31
        r13 = r7;
    L31:
        th = move-exception;
        r11 = r6;
        th = th;
    L7:
        r0 = new AnonymousClass2(r8);
        goto L8
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object toMutableList(ReceiveChannel r1, Continuation r2) {
        return ChannelsKt.toCollection(r1, new ArrayList(), r2);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object toSet(ReceiveChannel r0, Continuation r1) {
        return ChannelsKt.toMutableSet(r0, r1);
    }

    public static /* synthetic */ ReceiveChannel flatMap$default(ReceiveChannel r0, CoroutineDispatcher r1, Function2 r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = Dispatchers.getUnconfined();
    L6:
        return ChannelsKt.flatMap(r0, r1, r2);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ ReceiveChannel flatMap(ReceiveChannel r9, CoroutineContext r10, Function2 r11) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, r10, 0, null, ChannelsKt.consumes(r9), new C04611(r9, r11, null), 6, null);
    }

    public static /* synthetic */ ReceiveChannel map$default(ReceiveChannel r0, CoroutineDispatcher r1, Function2 r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = Dispatchers.getUnconfined();
    L6:
        return ChannelsKt.map(r0, r1, r2);
    }

    public static final <E, R> ReceiveChannel<R> map(ReceiveChannel<? extends E> r9, CoroutineContext r10, Function2<? super E, ? super Continuation<? super R>, ? extends Object> r11) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, r10, 0, null, ChannelsKt.consumes(r9), new C04661(r9, r11, null), 6, null);
    }

    public static /* synthetic */ ReceiveChannel mapIndexed$default(ReceiveChannel r0, CoroutineDispatcher r1, Function3 r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = Dispatchers.getUnconfined();
    L6:
        return ChannelsKt.mapIndexed(r0, r1, r2);
    }

    public static final <E, R> ReceiveChannel<R> mapIndexed(ReceiveChannel<? extends E> r9, CoroutineContext r10, Function3<? super Integer, ? super E, ? super Continuation<? super R>, ? extends Object> r11) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, r10, 0, null, ChannelsKt.consumes(r9), new C04671(r9, r11, null), 6, null);
    }

    public static /* synthetic */ ReceiveChannel mapIndexedNotNull$default(ReceiveChannel r0, CoroutineDispatcher r1, Function3 r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = Dispatchers.getUnconfined();
    L6:
        return ChannelsKt.mapIndexedNotNull(r0, r1, r2);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ ReceiveChannel mapIndexedNotNull(ReceiveChannel r0, CoroutineContext r1, Function3 r2) {
        return ChannelsKt.filterNotNull(ChannelsKt.mapIndexed(r0, r1, r2));
    }

    public static /* synthetic */ ReceiveChannel mapNotNull$default(ReceiveChannel r0, CoroutineDispatcher r1, Function2 r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = Dispatchers.getUnconfined();
    L6:
        return ChannelsKt.mapNotNull(r0, r1, r2);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ ReceiveChannel mapNotNull(ReceiveChannel r0, CoroutineContext r1, Function2 r2) {
        return ChannelsKt.filterNotNull(ChannelsKt.map(r0, r1, r2));
    }

    public static /* synthetic */ ReceiveChannel withIndex$default(ReceiveChannel r0, CoroutineDispatcher r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = Dispatchers.getUnconfined();
    L6:
        return ChannelsKt.withIndex(r0, r1);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ ReceiveChannel withIndex(ReceiveChannel r9, CoroutineContext r10) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, r10, 0, null, ChannelsKt.consumes(r9), new C04781(r9, null), 6, null);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ ReceiveChannel distinct(ReceiveChannel r3) {
        return ChannelsKt.distinctBy$default(r3, null, new C04481(null), 1, null);
    }

    public static /* synthetic */ ReceiveChannel distinctBy$default(ReceiveChannel r0, CoroutineDispatcher r1, Function2 r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = Dispatchers.getUnconfined();
    L6:
        return ChannelsKt.distinctBy(r0, r1, r2);
    }

    public static final <E, K> ReceiveChannel<E> distinctBy(ReceiveChannel<? extends E> r9, CoroutineContext r10, Function2<? super E, ? super Continuation<? super K>, ? extends Object> r11) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, r10, 0, null, ChannelsKt.consumes(r9), new C04491(r9, r11, null), 6, null);
    }

    public static final <E> Object toMutableSet(ReceiveChannel<? extends E> r1, Continuation<? super Set<E>> r2) {
        return ChannelsKt.toCollection(r1, new LinkedHashSet(), r2);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object any(ReceiveChannel r4, Continuation r5) {
        if ((r5 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) r5;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r6 = r0.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L16;
        if (r2 != 1) goto L15;
        r4 = (ReceiveChannel) r0.L$0;
        ResultKt.throwOnFailure(r6);     // Catch: Throwable -> L22
    L20:
        ChannelsKt.cancelConsumed(r4, null);
        return r6;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r6);
        ChannelIterator r7 = r4.iterator();     // Catch: Throwable -> L22
        r0.L$0 = r4;     // Catch: Throwable -> L22
        r0.label = 1;     // Catch: Throwable -> L22
        r6 = r7.hasNext(r0);     // Catch: Throwable -> L22
        if (r6 != r1) goto L20;
        return r1;
    L22:
        th = move-exception;
        throw th;     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        ChannelsKt.cancelConsumed(r4, th);
        throw th;
    L7:
        r0 = new AnonymousClass1(r5);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x005e -> B:25:0x0061). Please report as a decompilation issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object count(ReceiveChannel r6, Continuation r7) {
        if ((r7 instanceof C04471) == false) goto L7;
        C04471 r0 = (C04471) r7;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L18;
        if (r2 != 1) goto L17;
        ChannelIterator r9 = (ChannelIterator) r0.L$2;
        ReceiveChannel r3 = (ReceiveChannel) r0.L$1;
        Ref.IntRef r4 = (Ref.IntRef) r0.L$0;
        ResultKt.throwOnFailure(r8);     // Catch: Throwable -> L14
    L26:
        if (((Boolean) r8).booleanValue() == false) goto L28;
        r9.next();     // Catch: Throwable -> L14
        r4.element++;     // Catch: Throwable -> L14
        ReceiveChannel r10 = r3;
    L39:
        r0.L$0 = r4;     // Catch: Throwable -> L31
        r0.L$1 = r10;     // Catch: Throwable -> L31
        r0.L$2 = r9;     // Catch: Throwable -> L31
        r0.label = 1;     // Catch: Throwable -> L31
        Object r5 = r9.hasNext(r0);     // Catch: Throwable -> L31
        if (r5 != r1) goto L24;
        return r1;
    L24:
        r3 = r10;
        r8 = r5;
    L31:
        Throwable th = th;
        r3 = r10;
    L45:
        throw th;     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        ChannelsKt.cancelConsumed(r3, th);
        throw th;
    L28:
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L14
        ChannelsKt.cancelConsumed(r3, null);
        return Boxing.boxInt(r4.element);
    L14:
        th = th;
        goto L45
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r8);
        r4 = new Ref.IntRef();
        r10 = r6;
        r9 = r6.iterator();     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        r3 = r6;
        th = th;
    L7:
        r0 = new C04471(r7);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x00a1 -> B:15:0x003e). Please report as a decompilation issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object maxWith(ReceiveChannel r8, Comparator r9, Continuation r10) {
        if ((r10 instanceof C04681) == false) goto L7;
        C04681 r0 = (C04681) r10;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L25;
        if (r2 == 1) goto L20;
        if (r2 != 2) goto L19;
        Object r12 = r0.L$3;
        ChannelIterator r13 = (ChannelIterator) r0.L$2;
        ReceiveChannel r3 = (ReceiveChannel) r0.L$1;
        Comparator r4 = (Comparator) r0.L$0;
        ResultKt.throwOnFailure(r11);     // Catch: Throwable -> L16
        C04681 r7 = r0;
        Object r5 = r12;
        r8 = r3;
    L15:
        Object r6 = r1;
        C04681 r14 = r7;
        if (((Boolean) r11).booleanValue() == false) goto L47;
        Object r15 = r13.next();     // Catch: Throwable -> L49
        if (r4.compare(r5, r15) < 0) goto L46;
        r15 = r5;
    L46:
        r0 = r14;
        r1 = r6;
    L36:
        r0.L$0 = r4;     // Catch: Throwable -> L49
        r0.L$1 = r8;     // Catch: Throwable -> L49
        r0.L$2 = r13;     // Catch: Throwable -> L49
        r0.L$3 = r15;     // Catch: Throwable -> L49
        r0.label = 2;     // Catch: Throwable -> L49
        Object r16 = r13.hasNext(r0);     // Catch: Throwable -> L49
        if (r16 != r1) goto L39;
        return r1;
    L39:
        r7 = r0;
        r5 = r15;
        r11 = r16;
        goto L15
    L47:
        ChannelsKt.cancelConsumed(r8, null);
        return r5;
    L49:
        th = move-exception;
        ReceiveChannel r17 = r8;
        th = th;
    L59:
        throw th;     // Catch: Throwable -> L52
    L52:
        th = move-exception;
        ChannelsKt.cancelConsumed(r17, th);
        throw th;
    L16:
        th = th;
        r17 = r3;
        goto L59
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        ChannelIterator r18 = (ChannelIterator) r0.L$2;
        r17 = (ReceiveChannel) r0.L$1;
        Comparator r19 = (Comparator) r0.L$0;
        ResultKt.throwOnFailure(r11);     // Catch: Throwable -> L23
    L31:
        if (((Boolean) r11).booleanValue() == true) goto L34;
        ChannelsKt.cancelConsumed(r17, null);
        return null;
    L34:
        r15 = r18.next();     // Catch: Throwable -> L23
        r4 = r19;
        ReceiveChannel r20 = r17;
        r13 = r18;
        r8 = r20;
    L23:
        th = th;
        goto L59
    L25:
        ResultKt.throwOnFailure(r11);
        ChannelIterator r110 = r8.iterator();     // Catch: Throwable -> L49
        r0.L$0 = r9;     // Catch: Throwable -> L49
        r0.L$1 = r8;     // Catch: Throwable -> L49
        r0.L$2 = r110;     // Catch: Throwable -> L49
        r0.label = 1;     // Catch: Throwable -> L49
        Object r21 = r110.hasNext(r0);     // Catch: Throwable -> L49
        if (r21 != r1) goto L29;
        return r1;
    L29:
        r17 = r8;
        r18 = r110;
        r11 = r21;
        r19 = r9;
    L7:
        r0 = new C04681(r10);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x00a1 -> B:15:0x003e). Please report as a decompilation issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object minWith(ReceiveChannel r8, Comparator r9, Continuation r10) {
        if ((r10 instanceof C04691) == false) goto L7;
        C04691 r0 = (C04691) r10;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L25;
        if (r2 == 1) goto L20;
        if (r2 != 2) goto L19;
        Object r12 = r0.L$3;
        ChannelIterator r13 = (ChannelIterator) r0.L$2;
        ReceiveChannel r3 = (ReceiveChannel) r0.L$1;
        Comparator r4 = (Comparator) r0.L$0;
        ResultKt.throwOnFailure(r11);     // Catch: Throwable -> L16
        C04691 r7 = r0;
        Object r5 = r12;
        r8 = r3;
    L15:
        Object r6 = r1;
        C04691 r14 = r7;
        if (((Boolean) r11).booleanValue() == false) goto L47;
        Object r15 = r13.next();     // Catch: Throwable -> L49
        if (r4.compare(r5, r15) > 0) goto L46;
        r15 = r5;
    L46:
        r0 = r14;
        r1 = r6;
    L36:
        r0.L$0 = r4;     // Catch: Throwable -> L49
        r0.L$1 = r8;     // Catch: Throwable -> L49
        r0.L$2 = r13;     // Catch: Throwable -> L49
        r0.L$3 = r15;     // Catch: Throwable -> L49
        r0.label = 2;     // Catch: Throwable -> L49
        Object r16 = r13.hasNext(r0);     // Catch: Throwable -> L49
        if (r16 != r1) goto L39;
        return r1;
    L39:
        r7 = r0;
        r5 = r15;
        r11 = r16;
        goto L15
    L47:
        ChannelsKt.cancelConsumed(r8, null);
        return r5;
    L49:
        th = move-exception;
        ReceiveChannel r17 = r8;
        th = th;
    L59:
        throw th;     // Catch: Throwable -> L52
    L52:
        th = move-exception;
        ChannelsKt.cancelConsumed(r17, th);
        throw th;
    L16:
        th = th;
        r17 = r3;
        goto L59
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        ChannelIterator r18 = (ChannelIterator) r0.L$2;
        r17 = (ReceiveChannel) r0.L$1;
        Comparator r19 = (Comparator) r0.L$0;
        ResultKt.throwOnFailure(r11);     // Catch: Throwable -> L23
    L31:
        if (((Boolean) r11).booleanValue() == true) goto L34;
        ChannelsKt.cancelConsumed(r17, null);
        return null;
    L34:
        r15 = r18.next();     // Catch: Throwable -> L23
        r4 = r19;
        ReceiveChannel r20 = r17;
        r13 = r18;
        r8 = r20;
    L23:
        th = th;
        goto L59
    L25:
        ResultKt.throwOnFailure(r11);
        ChannelIterator r110 = r8.iterator();     // Catch: Throwable -> L49
        r0.L$0 = r9;     // Catch: Throwable -> L49
        r0.L$1 = r8;     // Catch: Throwable -> L49
        r0.L$2 = r110;     // Catch: Throwable -> L49
        r0.label = 1;     // Catch: Throwable -> L49
        Object r21 = r110.hasNext(r0);     // Catch: Throwable -> L49
        if (r21 != r1) goto L29;
        return r1;
    L29:
        r17 = r8;
        r18 = r110;
        r11 = r21;
        r19 = r9;
    L7:
        r0 = new C04691(r10);
        goto L8
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object none(ReceiveChannel r4, Continuation r5) {
        if ((r5 instanceof C04701) == false) goto L7;
        C04701 r0 = (C04701) r5;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r6 = r0.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        boolean r3 = true;
        if (r2 == 0) goto L16;
        if (r2 != 1) goto L15;
        r4 = (ReceiveChannel) r0.L$0;
        ResultKt.throwOnFailure(r6);     // Catch: Throwable -> L27
    L21:
        if (((Boolean) r6).booleanValue() == false) goto L24;
        r3 = false;
    L24:
        Boolean r7 = Boxing.boxBoolean(r3);     // Catch: Throwable -> L27
        ChannelsKt.cancelConsumed(r4, null);
        return r7;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r6);
        ChannelIterator r8 = r4.iterator();     // Catch: Throwable -> L27
        r0.L$0 = r4;     // Catch: Throwable -> L27
        r0.label = 1;     // Catch: Throwable -> L27
        r6 = r8.hasNext(r0);     // Catch: Throwable -> L27
        if (r6 != r1) goto L21;
        return r1;
    L27:
        th = move-exception;
        throw th;     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        ChannelsKt.cancelConsumed(r4, th);
        throw th;
    L7:
        r0 = new C04701(r5);
        goto L8
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Left for binary compatibility")
    public static final /* synthetic */ ReceiveChannel requireNoNulls(ReceiveChannel r3) {
        return ChannelsKt.map$default(r3, null, new C04711(r3, null), 1, null);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ ReceiveChannel zip(ReceiveChannel r6, ReceiveChannel r7) {
        return ChannelsKt.zip$default(r6, r7, null, C04791.INSTANCE, 2, null);
    }

    public static /* synthetic */ ReceiveChannel zip$default(ReceiveChannel r0, ReceiveChannel r1, CoroutineDispatcher r2, Function2 r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = Dispatchers.getUnconfined();
    L6:
        return ChannelsKt.zip(r0, r1, r2, r3);
    }

    public static final <E, R, V> ReceiveChannel<V> zip(ReceiveChannel<? extends E> r9, ReceiveChannel<? extends R> r10, CoroutineContext r11, Function2<? super E, ? super R, ? extends V> r12) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, r11, 0, null, ChannelsKt.consumesAll(new ReceiveChannel[]{r9, r10}), new C04802(r10, r9, r12, null), 6, null);
    }

    public static final Function1<Throwable, Unit> consumes(final ReceiveChannel<?> r1) {
        return new C04451(r1);
    }
}
