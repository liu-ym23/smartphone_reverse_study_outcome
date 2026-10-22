package com.obric.oui.material;

import android.util.Log;
import com.bytedance.apm6.consumer.slardar.Constants;
import com.bytedance.tracing.internal.TracingConstants;
import com.obric.oui.color.BlendConfig;
import com.obric.oui.color.StrokeConfig;
import com.obric.oui.res.BlendConfigStateList;
import com.obric.oui.res.StrokeStateList;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: compiled from: MaterialToken.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b_\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u001a\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\n\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010y\u001a\u0004\u0018\u00010\n2\b\u0010z\u001a\u0004\u0018\u00010\nH\u0007J%\u0010{\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u000e\u0010|\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u0007¢\u0006\u0002\u0010}J\u0012\u0010~\u001a\u00020\b2\b\b\u0002\u0010\u007f\u001a\u00020\u0004H\u0007J\"\u0010\u0080\u0001\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\n\u0018\u00010\u00072\t\u0010\u0081\u0001\u001a\u0004\u0018\u00010kH\u0007J\u001f\u0010\u0080\u0001\u001a\u0004\u0018\u00010\n2\t\u0010\u0081\u0001\u001a\u0004\u0018\u00010k2\u0007\u0010\u0082\u0001\u001a\u00020\bH\u0007J(\u0010\u0083\u0001\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0018\u00010\u00072\t\u0010\u0081\u0001\u001a\u0004\u0018\u00010kH\u0007J+\u0010\u0083\u0001\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\t\u0010\u0081\u0001\u001a\u0004\u0018\u00010k2\u0007\u0010\u0082\u0001\u001a\u00020\bH\u0007¢\u0006\u0003\u0010\u0084\u0001J\u001e\u0010\u0085\u0001\u001a\u00030\u0086\u00012\u0007\u0010\u0087\u0001\u001a\u00020\u00012\t\b\u0002\u0010\u0088\u0001\u001a\u00020\bH\u0007J\u001e\u0010\u0089\u0001\u001a\u00030\u0086\u00012\u0007\u0010\u0087\u0001\u001a\u00020\u00012\t\b\u0002\u0010\u0088\u0001\u001a\u00020\bH\u0007J7\u0010\u008a\u0001\u001a\u00030\u0086\u00012 \u0010\u008b\u0001\u001a\u001b\u0012\u0004\u0012\u00020k\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\n0\u00070\u008c\u00012\t\b\u0002\u0010\u0088\u0001\u001a\u00020\bH\u0007J\u001e\u0010\u008d\u0001\u001a\u00030\u0086\u00012\u0007\u0010\u0087\u0001\u001a\u00020\u00012\t\b\u0002\u0010\u0088\u0001\u001a\u00020\bH\u0007J\u001e\u0010\u008e\u0001\u001a\u00030\u0086\u00012\u0007\u0010\u0087\u0001\u001a\u00020\u00012\t\b\u0002\u0010\u0088\u0001\u001a\u00020\bH\u0007J=\u0010\u008f\u0001\u001a\u00030\u0086\u00012&\u0010\u008b\u0001\u001a!\u0012\u0004\u0012\u00020k\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u00070\u008c\u00012\t\b\u0002\u0010\u0088\u0001\u001a\u00020\bH\u0007J1\u0010\u0090\u0001\u001a\u00030\u0086\u00012\u001a\u0010\u008b\u0001\u001a\u0015\u0012\u0004\u0012\u00020k\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u008c\u00012\t\b\u0002\u0010\u0088\u0001\u001a\u00020\bH\u0007J+\u0010\u0091\u0001\u001a\u00030\u0086\u00012\u0014\u0010\u008b\u0001\u001a\u000f\u0012\u0004\u0012\u00020k\u0012\u0004\u0012\u00020\n0\u008c\u00012\t\b\u0002\u0010\u0088\u0001\u001a\u00020\bH\u0007J.\u0010\u0092\u0001\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\t\u0010\u0081\u0001\u001a\u0004\u0018\u00010k2\u0007\u0010\u0082\u0001\u001a\u00020\bH\u0000¢\u0006\u0006\b\u0093\u0001\u0010\u0084\u0001J\r\u0010\u0094\u0001\u001a\u00020\n*\u00020\nH\u0002J\r\u0010\u0095\u0001\u001a\u00020\n*\u00020\nH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\"\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\"\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\rR\u0018\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\rR\u0018\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\rR\"\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\rR\u0010\u0010\u0012\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\rR\u0010\u0010\u0017\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010#\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\rR\"\u0010$\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010%\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\rR\u0010\u0010&\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010*\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\rR\"\u0010+\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010,\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\rR\u0010\u0010-\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u00101\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\rR\"\u00102\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u00103\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\rR\u0018\u00104\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\rR\"\u00105\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u00106\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\rR\u0010\u00107\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u00109\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010;\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\rR(\u0010<\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b=\u0010\u0002R\u001e\u0010>\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u0012\u0004\b?\u0010\u0002R\u0016\u0010@\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\bA\u0010\u0002R\u0016\u0010B\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\bC\u0010\u0002R\u0016\u0010D\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\bE\u0010\u0002R\u0016\u0010F\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\bG\u0010\u0002R\u001e\u0010H\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u0012\u0004\bI\u0010\u0002R\"\u0010J\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010K\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\rR\u0010\u0010L\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010M\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010N\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\n0\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010O\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010P\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010Q\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\rR\"\u0010R\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010S\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\rR\u0010\u0010T\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010U\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010V\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010W\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010X\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\rR\"\u0010Y\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010Z\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\rR\u0010\u0010[\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\\\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010]\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010^\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010_\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\rR\u001c\u0010`\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\n0\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010a\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010b\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010c\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\n0\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010d\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010e\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\n0\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010g\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010h\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R3\u0010i\u001a\u001a\u0012\u0004\u0012\u00020k\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\n0\u00070j8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bn\u0010o\u001a\u0004\bl\u0010mR9\u0010p\u001a \u0012\u0004\u0012\u00020k\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u00070j8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\br\u0010o\u001a\u0004\bq\u0010mR-\u0010s\u001a\u0014\u0012\u0004\u0012\u00020k\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0j8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bu\u0010o\u001a\u0004\bt\u0010mR'\u0010v\u001a\u000e\u0012\u0004\u0012\u00020k\u0012\u0004\u0012\u00020\n0j8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bx\u0010o\u001a\u0004\bw\u0010m¨\u0006\u0096\u0001"}, d2 = {"Lcom/obric/oui/material/MaterialToken;", "", "()V", "MATERIAL_TOKEN_API_LEVEL", "", "MIN_SUPPORTED_MATERIAL_API_LEVEL", "OUI_Bg_Floating", "Lkotlin/Function1;", "", "", "Lcom/obric/oui/material/MaterialConfig;", "OUI_Bg_Floating_Blue", "OUI_Bg_Floating_Blue_Dark", "[Lcom/obric/oui/material/MaterialConfig;", "OUI_Bg_Floating_Blue_Light", "OUI_Bg_Floating_Dark", "OUI_Bg_Floating_Fill", "OUI_Bg_Floating_Fill_Dark", "OUI_Bg_Floating_Fill_Fluid_Dark", "OUI_Bg_Floating_Fill_Fluid_Light", "OUI_Bg_Floating_Fill_Frost_Dark", "OUI_Bg_Floating_Fill_Frost_Light", "OUI_Bg_Floating_Fill_Light", "OUI_Bg_Floating_Fluid_Blue_Dark", "OUI_Bg_Floating_Fluid_Blue_Light", "OUI_Bg_Floating_Fluid_Dark", "OUI_Bg_Floating_Fluid_Light", "OUI_Bg_Floating_Fluid_Tinted_Dark", "OUI_Bg_Floating_Fluid_Tinted_Light", "OUI_Bg_Floating_Frost_Blue_Dark", "OUI_Bg_Floating_Frost_Blue_Light", "OUI_Bg_Floating_Frost_Dark", "OUI_Bg_Floating_Frost_Light", "OUI_Bg_Floating_Frost_Tinted_Dark", "OUI_Bg_Floating_Frost_Tinted_Light", "OUI_Bg_Floating_Light", "OUI_Bg_Floating_OnImage", "OUI_Bg_Floating_OnImage_Dark", "OUI_Bg_Floating_OnImage_Fluid_Dark", "OUI_Bg_Floating_OnImage_Fluid_Light", "OUI_Bg_Floating_OnImage_Frost_Dark", "OUI_Bg_Floating_OnImage_Frost_Light", "OUI_Bg_Floating_OnImage_Light", "OUI_Bg_Floating_Overlay", "OUI_Bg_Floating_Overlay_Dark", "OUI_Bg_Floating_Overlay_Fluid_Dark", "OUI_Bg_Floating_Overlay_Fluid_Light", "OUI_Bg_Floating_Overlay_Frost_Dark", "OUI_Bg_Floating_Overlay_Frost_Light", "OUI_Bg_Floating_Overlay_Light", "OUI_Bg_Floating_Tinted", "OUI_Bg_Floating_Tinted_Dark", "OUI_Bg_Floating_Tinted_Light", "OUI_Bg_Modal", "OUI_Bg_Modal_Dark", "OUI_Bg_Modal_Fluid_Dark", "OUI_Bg_Modal_Fluid_Light", "OUI_Bg_Modal_Frost_Dark", "OUI_Bg_Modal_Frost_Light", "OUI_Bg_Modal_Light", "OUI_Bg_Overlay_Search", "getOUI_Bg_Overlay_Search$annotations", "OUI_Bg_Overlay_Search_Dark", "getOUI_Bg_Overlay_Search_Dark$annotations", "OUI_Bg_Overlay_Search_Fluid_Dark", "getOUI_Bg_Overlay_Search_Fluid_Dark$annotations", "OUI_Bg_Overlay_Search_Fluid_Light", "getOUI_Bg_Overlay_Search_Fluid_Light$annotations", "OUI_Bg_Overlay_Search_Frost_Dark", "getOUI_Bg_Overlay_Search_Frost_Dark$annotations", "OUI_Bg_Overlay_Search_Frost_Light", "getOUI_Bg_Overlay_Search_Frost_Light$annotations", "OUI_Bg_Overlay_Search_Light", "getOUI_Bg_Overlay_Search_Light$annotations", "OUI_Bg_Popup", "OUI_Bg_Popup_Dark", "OUI_Bg_Popup_Fluid_Dark", "OUI_Bg_Popup_Fluid_Light", "OUI_Bg_Popup_Frost", "OUI_Bg_Popup_Frost_Dark", "OUI_Bg_Popup_Frost_Light", "OUI_Bg_Popup_Light", "OUI_Bg_Popup_OnImage", "OUI_Bg_Popup_OnImage_Dark", "OUI_Bg_Popup_OnImage_Fluid_Dark", "OUI_Bg_Popup_OnImage_Fluid_Light", "OUI_Bg_Popup_OnImage_Frost_Dark", "OUI_Bg_Popup_OnImage_Frost_Light", "OUI_Bg_Popup_OnImage_Light", "OUI_Bg_Popup_Overlay", "OUI_Bg_Popup_Overlay_Dark", "OUI_Bg_Popup_Overlay_Fluid_Dark", "OUI_Bg_Popup_Overlay_Fluid_Light", "OUI_Bg_Popup_Overlay_Frost_Dark", "OUI_Bg_Popup_Overlay_Frost_Light", "OUI_Bg_Popup_Overlay_Light", "OUI_Text_Primary", "OUI_Text_Primary_Dark", "OUI_Text_Primary_Light", "OUI_Text_Secondary", "OUI_Text_Secondary_Dark", "OUI_Text_Secondary_Light", "OUI_Text_Tertiary", "OUI_Text_Tertiary_Dark", "OUI_Text_Tertiary_Light", "providers", "Ljava/util/concurrent/ConcurrentHashMap;", "", "getProviders", "()Ljava/util/concurrent/ConcurrentHashMap;", "providers$delegate", "Lkotlin/Lazy;", "setProviders", "getSetProviders", "setProviders$delegate", "tokenSets", "getTokenSets", "tokenSets$delegate", "tokens", "getTokens", "tokens$delegate", "compatibleConfig", "config", "compatibleConfigArray", Constants.KEY_CONFIG, "([Lcom/obric/oui/material/MaterialConfig;)[Lcom/obric/oui/material/MaterialConfig;", "isApiCompatible", "requiredApiLevel", "parse", "name", "isLight", "parseSet", "(Ljava/lang/String;Z)[Lcom/obric/oui/material/MaterialConfig;", "register", "", "customTokenOwner", "overrideExisting", "registerProvider", "registerProviderTokens", "customTokens", "", "registerSet", "registerSetProvider", "registerSetProviderTokens", "registerTokenSets", "registerTokens", "resolveTokenForBuilder", "resolveTokenForBuilder$OUI_standardRelease", "toApi3CompatibleConfig", "toLegacyCompatibleConfig", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MaterialToken {
    public static final MaterialToken INSTANCE = null;
    public static final int MATERIAL_TOKEN_API_LEVEL = 4;
    public static final int MIN_SUPPORTED_MATERIAL_API_LEVEL = 1;
    public static final Function1<Boolean, MaterialConfig[]> OUI_Bg_Floating = null;
    public static final Function1<Boolean, MaterialConfig[]> OUI_Bg_Floating_Blue = null;
    public static final MaterialConfig[] OUI_Bg_Floating_Blue_Dark = null;
    public static final MaterialConfig[] OUI_Bg_Floating_Blue_Light = null;
    public static final MaterialConfig[] OUI_Bg_Floating_Dark = null;
    public static final Function1<Boolean, MaterialConfig[]> OUI_Bg_Floating_Fill = null;
    public static final MaterialConfig[] OUI_Bg_Floating_Fill_Dark = null;
    public static final MaterialConfig OUI_Bg_Floating_Fill_Fluid_Dark = null;
    public static final MaterialConfig OUI_Bg_Floating_Fill_Fluid_Light = null;
    public static final MaterialConfig OUI_Bg_Floating_Fill_Frost_Dark = null;
    public static final MaterialConfig OUI_Bg_Floating_Fill_Frost_Light = null;
    public static final MaterialConfig[] OUI_Bg_Floating_Fill_Light = null;
    public static final MaterialConfig OUI_Bg_Floating_Fluid_Blue_Dark = null;
    public static final MaterialConfig OUI_Bg_Floating_Fluid_Blue_Light = null;
    public static final MaterialConfig OUI_Bg_Floating_Fluid_Dark = null;
    public static final MaterialConfig OUI_Bg_Floating_Fluid_Light = null;
    public static final MaterialConfig OUI_Bg_Floating_Fluid_Tinted_Dark = null;
    public static final MaterialConfig OUI_Bg_Floating_Fluid_Tinted_Light = null;
    public static final MaterialConfig OUI_Bg_Floating_Frost_Blue_Dark = null;
    public static final MaterialConfig OUI_Bg_Floating_Frost_Blue_Light = null;
    public static final MaterialConfig OUI_Bg_Floating_Frost_Dark = null;
    public static final MaterialConfig OUI_Bg_Floating_Frost_Light = null;
    public static final MaterialConfig OUI_Bg_Floating_Frost_Tinted_Dark = null;
    public static final MaterialConfig OUI_Bg_Floating_Frost_Tinted_Light = null;
    public static final MaterialConfig[] OUI_Bg_Floating_Light = null;
    public static final Function1<Boolean, MaterialConfig[]> OUI_Bg_Floating_OnImage = null;
    public static final MaterialConfig[] OUI_Bg_Floating_OnImage_Dark = null;
    public static final MaterialConfig OUI_Bg_Floating_OnImage_Fluid_Dark = null;
    public static final MaterialConfig OUI_Bg_Floating_OnImage_Fluid_Light = null;
    public static final MaterialConfig OUI_Bg_Floating_OnImage_Frost_Dark = null;
    public static final MaterialConfig OUI_Bg_Floating_OnImage_Frost_Light = null;
    public static final MaterialConfig[] OUI_Bg_Floating_OnImage_Light = null;
    public static final Function1<Boolean, MaterialConfig[]> OUI_Bg_Floating_Overlay = null;
    public static final MaterialConfig[] OUI_Bg_Floating_Overlay_Dark = null;
    public static final MaterialConfig OUI_Bg_Floating_Overlay_Fluid_Dark = null;
    public static final MaterialConfig OUI_Bg_Floating_Overlay_Fluid_Light = null;
    public static final MaterialConfig OUI_Bg_Floating_Overlay_Frost_Dark = null;
    public static final MaterialConfig OUI_Bg_Floating_Overlay_Frost_Light = null;
    public static final MaterialConfig[] OUI_Bg_Floating_Overlay_Light = null;
    public static final Function1<Boolean, MaterialConfig[]> OUI_Bg_Floating_Tinted = null;
    public static final MaterialConfig[] OUI_Bg_Floating_Tinted_Dark = null;
    public static final MaterialConfig[] OUI_Bg_Floating_Tinted_Light = null;
    public static final Function1<Boolean, MaterialConfig[]> OUI_Bg_Modal = null;
    public static final MaterialConfig[] OUI_Bg_Modal_Dark = null;
    public static final MaterialConfig OUI_Bg_Modal_Fluid_Dark = null;
    public static final MaterialConfig OUI_Bg_Modal_Fluid_Light = null;
    public static final MaterialConfig OUI_Bg_Modal_Frost_Dark = null;
    public static final MaterialConfig OUI_Bg_Modal_Frost_Light = null;
    public static final MaterialConfig[] OUI_Bg_Modal_Light = null;
    public static final Function1<Boolean, MaterialConfig[]> OUI_Bg_Overlay_Search = null;
    public static final MaterialConfig[] OUI_Bg_Overlay_Search_Dark = null;
    public static final MaterialConfig OUI_Bg_Overlay_Search_Fluid_Dark = null;
    public static final MaterialConfig OUI_Bg_Overlay_Search_Fluid_Light = null;
    public static final MaterialConfig OUI_Bg_Overlay_Search_Frost_Dark = null;
    public static final MaterialConfig OUI_Bg_Overlay_Search_Frost_Light = null;
    public static final MaterialConfig[] OUI_Bg_Overlay_Search_Light = null;
    public static final Function1<Boolean, MaterialConfig[]> OUI_Bg_Popup = null;
    public static final MaterialConfig[] OUI_Bg_Popup_Dark = null;
    public static final MaterialConfig OUI_Bg_Popup_Fluid_Dark = null;
    public static final MaterialConfig OUI_Bg_Popup_Fluid_Light = null;
    public static final Function1<Boolean, MaterialConfig> OUI_Bg_Popup_Frost = null;
    public static final MaterialConfig OUI_Bg_Popup_Frost_Dark = null;
    public static final MaterialConfig OUI_Bg_Popup_Frost_Light = null;
    public static final MaterialConfig[] OUI_Bg_Popup_Light = null;
    public static final Function1<Boolean, MaterialConfig[]> OUI_Bg_Popup_OnImage = null;
    public static final MaterialConfig[] OUI_Bg_Popup_OnImage_Dark = null;
    public static final MaterialConfig OUI_Bg_Popup_OnImage_Fluid_Dark = null;
    public static final MaterialConfig OUI_Bg_Popup_OnImage_Fluid_Light = null;
    public static final MaterialConfig OUI_Bg_Popup_OnImage_Frost_Dark = null;
    public static final MaterialConfig OUI_Bg_Popup_OnImage_Frost_Light = null;
    public static final MaterialConfig[] OUI_Bg_Popup_OnImage_Light = null;
    public static final Function1<Boolean, MaterialConfig[]> OUI_Bg_Popup_Overlay = null;
    public static final MaterialConfig[] OUI_Bg_Popup_Overlay_Dark = null;
    public static final MaterialConfig OUI_Bg_Popup_Overlay_Fluid_Dark = null;
    public static final MaterialConfig OUI_Bg_Popup_Overlay_Fluid_Light = null;
    public static final MaterialConfig OUI_Bg_Popup_Overlay_Frost_Dark = null;
    public static final MaterialConfig OUI_Bg_Popup_Overlay_Frost_Light = null;
    public static final MaterialConfig[] OUI_Bg_Popup_Overlay_Light = null;
    public static final Function1<Boolean, MaterialConfig> OUI_Text_Primary = null;
    public static final MaterialConfig OUI_Text_Primary_Dark = null;
    public static final MaterialConfig OUI_Text_Primary_Light = null;
    public static final Function1<Boolean, MaterialConfig> OUI_Text_Secondary = null;
    public static final MaterialConfig OUI_Text_Secondary_Dark = null;
    public static final MaterialConfig OUI_Text_Secondary_Light = null;
    public static final Function1<Boolean, MaterialConfig> OUI_Text_Tertiary = null;
    public static final MaterialConfig OUI_Text_Tertiary_Dark = null;
    public static final MaterialConfig OUI_Text_Tertiary_Light = null;
    private static final Lazy providers$delegate = null;
    private static final Lazy setProviders$delegate = null;
    private static final Lazy tokenSets$delegate = null;
    private static final Lazy tokens$delegate = null;

    /* JADX INFO: renamed from: com.obric.oui.material.MaterialToken$compatibleConfigArray$1, reason: invalid class name */
    /* JADX INFO: compiled from: MaterialToken.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<MaterialConfig, MaterialConfig> {
        AnonymousClass1(Object r8) {
            super(1, r8, MaterialToken.class, "compatibleConfig", "compatibleConfig(Lcom/obric/oui/material/MaterialConfig;)Lcom/obric/oui/material/MaterialConfig;", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final MaterialConfig invoke2(MaterialConfig r1) {
            return MaterialToken.compatibleConfig(r1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ MaterialConfig invoke(MaterialConfig r1) {
            return invoke2(r1);
        }
    }

    @Deprecated(message = "Use MaterialToken.OUI_Bg_Floating_Overlay instead")
    public static /* synthetic */ void getOUI_Bg_Overlay_Search$annotations() {
    }

    @Deprecated(message = "Use MaterialToken.OUI_Bg_Floating_Overlay_Dark instead")
    public static /* synthetic */ void getOUI_Bg_Overlay_Search_Dark$annotations() {
    }

    @Deprecated(message = "Use MaterialToken.OUI_Bg_Floating_Overlay_Fluid_Dark instead")
    public static /* synthetic */ void getOUI_Bg_Overlay_Search_Fluid_Dark$annotations() {
    }

    @Deprecated(message = "Use MaterialToken.OUI_Bg_Floating_Overlay_Fluid_Light instead")
    public static /* synthetic */ void getOUI_Bg_Overlay_Search_Fluid_Light$annotations() {
    }

    @Deprecated(message = "Use MaterialToken.OUI_Bg_Floating_Overlay_Frost_Dark instead")
    public static /* synthetic */ void getOUI_Bg_Overlay_Search_Frost_Dark$annotations() {
    }

    @Deprecated(message = "Use MaterialToken.OUI_Bg_Floating_Overlay_Frost_Light instead")
    public static /* synthetic */ void getOUI_Bg_Overlay_Search_Frost_Light$annotations() {
    }

    @Deprecated(message = "Use MaterialToken.OUI_Bg_Floating_Overlay_Light instead")
    public static /* synthetic */ void getOUI_Bg_Overlay_Search_Light$annotations() {
    }

    private MaterialToken() {
    }

    static {
        INSTANCE = new MaterialToken();
        tokens$delegate = LazyKt.lazy(MaterialToken$tokens$2.INSTANCE);
        tokenSets$delegate = LazyKt.lazy(MaterialToken$tokenSets$2.INSTANCE);
        providers$delegate = LazyKt.lazy(MaterialToken$providers$2.INSTANCE);
        setProviders$delegate = LazyKt.lazy(MaterialToken$setProviders$2.INSTANCE);
        MaterialConfig r0 = MaterialTokenCore.OUI_Bg_Floating_Frost_Light;
        Intrinsics.checkNotNullExpressionValue(r0, "OUI_Bg_Floating_Frost_Light");
        OUI_Bg_Floating_Frost_Light = r0;
        MaterialConfig r1 = MaterialTokenCore.OUI_Bg_Floating_Frost_Dark;
        Intrinsics.checkNotNullExpressionValue(r1, "OUI_Bg_Floating_Frost_Dark");
        OUI_Bg_Floating_Frost_Dark = r1;
        MaterialConfig r2 = MaterialTokenCore.OUI_Bg_Floating_Fluid_Light;
        Intrinsics.checkNotNullExpressionValue(r2, "OUI_Bg_Floating_Fluid_Light");
        OUI_Bg_Floating_Fluid_Light = r2;
        MaterialConfig r3 = MaterialTokenCore.OUI_Bg_Floating_Fluid_Dark;
        Intrinsics.checkNotNullExpressionValue(r3, "OUI_Bg_Floating_Fluid_Dark");
        OUI_Bg_Floating_Fluid_Dark = r3;
        MaterialConfig[] r4 = MaterialTokenCore.OUI_Bg_Floating_Light;
        Intrinsics.checkNotNullExpressionValue(r4, "OUI_Bg_Floating_Light");
        OUI_Bg_Floating_Light = r4;
        MaterialConfig[] r5 = MaterialTokenCore.OUI_Bg_Floating_Dark;
        Intrinsics.checkNotNullExpressionValue(r5, "OUI_Bg_Floating_Dark");
        OUI_Bg_Floating_Dark = r5;
        OUI_Bg_Floating = MaterialToken$OUI_Bg_Floating$1.INSTANCE;
        MaterialConfig r6 = MaterialTokenCore.OUI_Bg_Floating_OnImage_Frost_Light;
        Intrinsics.checkNotNullExpressionValue(r6, "OUI_Bg_Floating_OnImage_Frost_Light");
        OUI_Bg_Floating_OnImage_Frost_Light = r6;
        MaterialConfig r7 = MaterialTokenCore.OUI_Bg_Floating_OnImage_Frost_Dark;
        Intrinsics.checkNotNullExpressionValue(r7, "OUI_Bg_Floating_OnImage_Frost_Dark");
        OUI_Bg_Floating_OnImage_Frost_Dark = r7;
        MaterialConfig r8 = MaterialTokenCore.OUI_Bg_Floating_OnImage_Fluid_Light;
        Intrinsics.checkNotNullExpressionValue(r8, "OUI_Bg_Floating_OnImage_Fluid_Light");
        OUI_Bg_Floating_OnImage_Fluid_Light = r8;
        MaterialConfig r9 = MaterialTokenCore.OUI_Bg_Floating_OnImage_Fluid_Dark;
        Intrinsics.checkNotNullExpressionValue(r9, "OUI_Bg_Floating_OnImage_Fluid_Dark");
        OUI_Bg_Floating_OnImage_Fluid_Dark = r9;
        MaterialConfig[] r10 = MaterialTokenCore.OUI_Bg_Floating_OnImage_Light;
        Intrinsics.checkNotNullExpressionValue(r10, "OUI_Bg_Floating_OnImage_Light");
        OUI_Bg_Floating_OnImage_Light = r10;
        MaterialConfig[] r11 = MaterialTokenCore.OUI_Bg_Floating_OnImage_Dark;
        Intrinsics.checkNotNullExpressionValue(r11, "OUI_Bg_Floating_OnImage_Dark");
        OUI_Bg_Floating_OnImage_Dark = r11;
        OUI_Bg_Floating_OnImage = MaterialToken$OUI_Bg_Floating_OnImage$1.INSTANCE;
        MaterialConfig r12 = MaterialTokenCore.OUI_Bg_Floating_Fill_Frost_Light;
        Intrinsics.checkNotNullExpressionValue(r12, "OUI_Bg_Floating_Fill_Frost_Light");
        OUI_Bg_Floating_Fill_Frost_Light = r12;
        MaterialConfig r13 = MaterialTokenCore.OUI_Bg_Floating_Fill_Frost_Dark;
        Intrinsics.checkNotNullExpressionValue(r13, "OUI_Bg_Floating_Fill_Frost_Dark");
        OUI_Bg_Floating_Fill_Frost_Dark = r13;
        MaterialConfig r14 = MaterialTokenCore.OUI_Bg_Floating_Fill_Fluid_Light;
        Intrinsics.checkNotNullExpressionValue(r14, "OUI_Bg_Floating_Fill_Fluid_Light");
        OUI_Bg_Floating_Fill_Fluid_Light = r14;
        MaterialConfig r15 = MaterialTokenCore.OUI_Bg_Floating_Fill_Fluid_Dark;
        Intrinsics.checkNotNullExpressionValue(r15, "OUI_Bg_Floating_Fill_Fluid_Dark");
        OUI_Bg_Floating_Fill_Fluid_Dark = r15;
        MaterialConfig[] r16 = MaterialTokenCore.OUI_Bg_Floating_Fill_Light;
        Intrinsics.checkNotNullExpressionValue(r16, "OUI_Bg_Floating_Fill_Light");
        OUI_Bg_Floating_Fill_Light = r16;
        MaterialConfig[] r17 = MaterialTokenCore.OUI_Bg_Floating_Fill_Dark;
        Intrinsics.checkNotNullExpressionValue(r17, "OUI_Bg_Floating_Fill_Dark");
        OUI_Bg_Floating_Fill_Dark = r17;
        OUI_Bg_Floating_Fill = MaterialToken$OUI_Bg_Floating_Fill$1.INSTANCE;
        MaterialConfig r18 = MaterialTokenCore.OUI_Bg_Popup_Frost_Light;
        Intrinsics.checkNotNullExpressionValue(r18, "OUI_Bg_Popup_Frost_Light");
        OUI_Bg_Popup_Frost_Light = r18;
        MaterialConfig r19 = MaterialTokenCore.OUI_Bg_Popup_Frost_Dark;
        Intrinsics.checkNotNullExpressionValue(r19, "OUI_Bg_Popup_Frost_Dark");
        OUI_Bg_Popup_Frost_Dark = r19;
        OUI_Bg_Popup_Frost = MaterialToken$OUI_Bg_Popup_Frost$1.INSTANCE;
        MaterialConfig r20 = MaterialTokenCore.OUI_Bg_Popup_Fluid_Light;
        Intrinsics.checkNotNullExpressionValue(r20, "OUI_Bg_Popup_Fluid_Light");
        OUI_Bg_Popup_Fluid_Light = r20;
        MaterialConfig r21 = MaterialTokenCore.OUI_Bg_Popup_Fluid_Dark;
        Intrinsics.checkNotNullExpressionValue(r21, "OUI_Bg_Popup_Fluid_Dark");
        OUI_Bg_Popup_Fluid_Dark = r21;
        MaterialConfig[] r22 = MaterialTokenCore.OUI_Bg_Popup_Light;
        Intrinsics.checkNotNullExpressionValue(r22, "OUI_Bg_Popup_Light");
        OUI_Bg_Popup_Light = r22;
        MaterialConfig[] r23 = MaterialTokenCore.OUI_Bg_Popup_Dark;
        Intrinsics.checkNotNullExpressionValue(r23, "OUI_Bg_Popup_Dark");
        OUI_Bg_Popup_Dark = r23;
        OUI_Bg_Popup = MaterialToken$OUI_Bg_Popup$1.INSTANCE;
        MaterialConfig r24 = MaterialTokenCore.OUI_Bg_Popup_OnImage_Frost_Light;
        Intrinsics.checkNotNullExpressionValue(r24, "OUI_Bg_Popup_OnImage_Frost_Light");
        OUI_Bg_Popup_OnImage_Frost_Light = r24;
        MaterialConfig r25 = MaterialTokenCore.OUI_Bg_Popup_OnImage_Frost_Dark;
        Intrinsics.checkNotNullExpressionValue(r25, "OUI_Bg_Popup_OnImage_Frost_Dark");
        OUI_Bg_Popup_OnImage_Frost_Dark = r25;
        MaterialConfig r26 = MaterialTokenCore.OUI_Bg_Popup_OnImage_Fluid_Light;
        Intrinsics.checkNotNullExpressionValue(r26, "OUI_Bg_Popup_OnImage_Fluid_Light");
        OUI_Bg_Popup_OnImage_Fluid_Light = r26;
        MaterialConfig r27 = MaterialTokenCore.OUI_Bg_Popup_OnImage_Fluid_Dark;
        Intrinsics.checkNotNullExpressionValue(r27, "OUI_Bg_Popup_OnImage_Fluid_Dark");
        OUI_Bg_Popup_OnImage_Fluid_Dark = r27;
        MaterialConfig[] r28 = MaterialTokenCore.OUI_Bg_Popup_OnImage_Light;
        Intrinsics.checkNotNullExpressionValue(r28, "OUI_Bg_Popup_OnImage_Light");
        OUI_Bg_Popup_OnImage_Light = r28;
        MaterialConfig[] r29 = MaterialTokenCore.OUI_Bg_Popup_OnImage_Dark;
        Intrinsics.checkNotNullExpressionValue(r29, "OUI_Bg_Popup_OnImage_Dark");
        OUI_Bg_Popup_OnImage_Dark = r29;
        OUI_Bg_Popup_OnImage = MaterialToken$OUI_Bg_Popup_OnImage$1.INSTANCE;
        MaterialConfig r30 = MaterialTokenCore.OUI_Bg_Popup_Overlay_Frost_Light;
        Intrinsics.checkNotNullExpressionValue(r30, "OUI_Bg_Popup_Overlay_Frost_Light");
        OUI_Bg_Popup_Overlay_Frost_Light = r30;
        MaterialConfig r31 = MaterialTokenCore.OUI_Bg_Popup_Overlay_Frost_Dark;
        Intrinsics.checkNotNullExpressionValue(r31, "OUI_Bg_Popup_Overlay_Frost_Dark");
        OUI_Bg_Popup_Overlay_Frost_Dark = r31;
        MaterialConfig r32 = MaterialTokenCore.OUI_Bg_Popup_Overlay_Fluid_Light;
        Intrinsics.checkNotNullExpressionValue(r32, "OUI_Bg_Popup_Overlay_Fluid_Light");
        OUI_Bg_Popup_Overlay_Fluid_Light = r32;
        MaterialConfig r33 = MaterialTokenCore.OUI_Bg_Popup_Overlay_Fluid_Dark;
        Intrinsics.checkNotNullExpressionValue(r33, "OUI_Bg_Popup_Overlay_Fluid_Dark");
        OUI_Bg_Popup_Overlay_Fluid_Dark = r33;
        MaterialConfig[] r34 = MaterialTokenCore.OUI_Bg_Popup_Overlay_Light;
        Intrinsics.checkNotNullExpressionValue(r34, "OUI_Bg_Popup_Overlay_Light");
        OUI_Bg_Popup_Overlay_Light = r34;
        MaterialConfig[] r35 = MaterialTokenCore.OUI_Bg_Popup_Overlay_Dark;
        Intrinsics.checkNotNullExpressionValue(r35, "OUI_Bg_Popup_Overlay_Dark");
        OUI_Bg_Popup_Overlay_Dark = r35;
        OUI_Bg_Popup_Overlay = MaterialToken$OUI_Bg_Popup_Overlay$1.INSTANCE;
        MaterialConfig r36 = MaterialTokenCore.OUI_Bg_Modal_Frost_Light;
        Intrinsics.checkNotNullExpressionValue(r36, "OUI_Bg_Modal_Frost_Light");
        OUI_Bg_Modal_Frost_Light = r36;
        MaterialConfig r37 = MaterialTokenCore.OUI_Bg_Modal_Frost_Dark;
        Intrinsics.checkNotNullExpressionValue(r37, "OUI_Bg_Modal_Frost_Dark");
        OUI_Bg_Modal_Frost_Dark = r37;
        MaterialConfig r38 = MaterialTokenCore.OUI_Bg_Modal_Fluid_Light;
        Intrinsics.checkNotNullExpressionValue(r38, "OUI_Bg_Modal_Fluid_Light");
        OUI_Bg_Modal_Fluid_Light = r38;
        MaterialConfig r39 = MaterialTokenCore.OUI_Bg_Modal_Fluid_Dark;
        Intrinsics.checkNotNullExpressionValue(r39, "OUI_Bg_Modal_Fluid_Dark");
        OUI_Bg_Modal_Fluid_Dark = r39;
        MaterialConfig[] r40 = MaterialTokenCore.OUI_Bg_Modal_Light;
        Intrinsics.checkNotNullExpressionValue(r40, "OUI_Bg_Modal_Light");
        OUI_Bg_Modal_Light = r40;
        MaterialConfig[] r41 = MaterialTokenCore.OUI_Bg_Modal_Dark;
        Intrinsics.checkNotNullExpressionValue(r41, "OUI_Bg_Modal_Dark");
        OUI_Bg_Modal_Dark = r41;
        OUI_Bg_Modal = MaterialToken$OUI_Bg_Modal$1.INSTANCE;
        MaterialConfig r42 = MaterialTokenCore.OUI_Bg_Floating_Overlay_Frost_Light;
        Intrinsics.checkNotNullExpressionValue(r42, "OUI_Bg_Floating_Overlay_Frost_Light");
        OUI_Bg_Floating_Overlay_Frost_Light = r42;
        MaterialConfig r43 = MaterialTokenCore.OUI_Bg_Floating_Overlay_Frost_Dark;
        Intrinsics.checkNotNullExpressionValue(r43, "OUI_Bg_Floating_Overlay_Frost_Dark");
        OUI_Bg_Floating_Overlay_Frost_Dark = r43;
        MaterialConfig r44 = MaterialTokenCore.OUI_Bg_Floating_Overlay_Fluid_Light;
        Intrinsics.checkNotNullExpressionValue(r44, "OUI_Bg_Floating_Overlay_Fluid_Light");
        OUI_Bg_Floating_Overlay_Fluid_Light = r44;
        MaterialConfig r45 = MaterialTokenCore.OUI_Bg_Floating_Overlay_Fluid_Dark;
        Intrinsics.checkNotNullExpressionValue(r45, "OUI_Bg_Floating_Overlay_Fluid_Dark");
        OUI_Bg_Floating_Overlay_Fluid_Dark = r45;
        MaterialConfig[] r46 = MaterialTokenCore.OUI_Bg_Floating_Overlay_Light;
        Intrinsics.checkNotNullExpressionValue(r46, "OUI_Bg_Floating_Overlay_Light");
        OUI_Bg_Floating_Overlay_Light = r46;
        MaterialConfig[] r47 = MaterialTokenCore.OUI_Bg_Floating_Overlay_Dark;
        Intrinsics.checkNotNullExpressionValue(r47, "OUI_Bg_Floating_Overlay_Dark");
        OUI_Bg_Floating_Overlay_Dark = r47;
        OUI_Bg_Floating_Overlay = MaterialToken$OUI_Bg_Floating_Overlay$1.INSTANCE;
        MaterialConfig r48 = MaterialTokenCore.OUI_Bg_Overlay_Search_Frost_Light;
        Intrinsics.checkNotNullExpressionValue(r48, "OUI_Bg_Overlay_Search_Frost_Light");
        OUI_Bg_Overlay_Search_Frost_Light = r48;
        MaterialConfig r49 = MaterialTokenCore.OUI_Bg_Overlay_Search_Frost_Dark;
        Intrinsics.checkNotNullExpressionValue(r49, "OUI_Bg_Overlay_Search_Frost_Dark");
        OUI_Bg_Overlay_Search_Frost_Dark = r49;
        MaterialConfig r50 = MaterialTokenCore.OUI_Bg_Overlay_Search_Fluid_Light;
        Intrinsics.checkNotNullExpressionValue(r50, "OUI_Bg_Overlay_Search_Fluid_Light");
        OUI_Bg_Overlay_Search_Fluid_Light = r50;
        MaterialConfig r51 = MaterialTokenCore.OUI_Bg_Overlay_Search_Fluid_Dark;
        Intrinsics.checkNotNullExpressionValue(r51, "OUI_Bg_Overlay_Search_Fluid_Dark");
        OUI_Bg_Overlay_Search_Fluid_Dark = r51;
        MaterialConfig[] r52 = MaterialTokenCore.OUI_Bg_Overlay_Search_Light;
        Intrinsics.checkNotNullExpressionValue(r52, "OUI_Bg_Overlay_Search_Light");
        OUI_Bg_Overlay_Search_Light = r52;
        MaterialConfig[] r53 = MaterialTokenCore.OUI_Bg_Overlay_Search_Dark;
        Intrinsics.checkNotNullExpressionValue(r53, "OUI_Bg_Overlay_Search_Dark");
        OUI_Bg_Overlay_Search_Dark = r53;
        OUI_Bg_Overlay_Search = MaterialToken$OUI_Bg_Overlay_Search$1.INSTANCE;
        MaterialConfig r54 = MaterialTokenCore.OUI_Bg_Floating_Frost_Tinted_Light;
        Intrinsics.checkNotNullExpressionValue(r54, "OUI_Bg_Floating_Frost_Tinted_Light");
        OUI_Bg_Floating_Frost_Tinted_Light = r54;
        MaterialConfig r55 = MaterialTokenCore.OUI_Bg_Floating_Frost_Tinted_Dark;
        Intrinsics.checkNotNullExpressionValue(r55, "OUI_Bg_Floating_Frost_Tinted_Dark");
        OUI_Bg_Floating_Frost_Tinted_Dark = r55;
        MaterialConfig r56 = MaterialTokenCore.OUI_Bg_Floating_Fluid_Tinted_Light;
        Intrinsics.checkNotNullExpressionValue(r56, "OUI_Bg_Floating_Fluid_Tinted_Light");
        OUI_Bg_Floating_Fluid_Tinted_Light = r56;
        MaterialConfig r57 = MaterialTokenCore.OUI_Bg_Floating_Fluid_Tinted_Dark;
        Intrinsics.checkNotNullExpressionValue(r57, "OUI_Bg_Floating_Fluid_Tinted_Dark");
        OUI_Bg_Floating_Fluid_Tinted_Dark = r57;
        MaterialConfig[] r58 = MaterialTokenCore.OUI_Bg_Floating_Tinted_Light;
        Intrinsics.checkNotNullExpressionValue(r58, "OUI_Bg_Floating_Tinted_Light");
        OUI_Bg_Floating_Tinted_Light = r58;
        MaterialConfig[] r59 = MaterialTokenCore.OUI_Bg_Floating_Tinted_Dark;
        Intrinsics.checkNotNullExpressionValue(r59, "OUI_Bg_Floating_Tinted_Dark");
        OUI_Bg_Floating_Tinted_Dark = r59;
        OUI_Bg_Floating_Tinted = MaterialToken$OUI_Bg_Floating_Tinted$1.INSTANCE;
        MaterialConfig r60 = MaterialTokenCore.OUI_Bg_Floating_Frost_Blue_Light;
        Intrinsics.checkNotNullExpressionValue(r60, "OUI_Bg_Floating_Frost_Blue_Light");
        OUI_Bg_Floating_Frost_Blue_Light = r60;
        MaterialConfig r61 = MaterialTokenCore.OUI_Bg_Floating_Frost_Blue_Dark;
        Intrinsics.checkNotNullExpressionValue(r61, "OUI_Bg_Floating_Frost_Blue_Dark");
        OUI_Bg_Floating_Frost_Blue_Dark = r61;
        MaterialConfig r62 = MaterialTokenCore.OUI_Bg_Floating_Fluid_Blue_Light;
        Intrinsics.checkNotNullExpressionValue(r62, "OUI_Bg_Floating_Fluid_Blue_Light");
        OUI_Bg_Floating_Fluid_Blue_Light = r62;
        MaterialConfig r63 = MaterialTokenCore.OUI_Bg_Floating_Fluid_Blue_Dark;
        Intrinsics.checkNotNullExpressionValue(r63, "OUI_Bg_Floating_Fluid_Blue_Dark");
        OUI_Bg_Floating_Fluid_Blue_Dark = r63;
        MaterialConfig[] r64 = MaterialTokenCore.OUI_Bg_Floating_Blue_Light;
        Intrinsics.checkNotNullExpressionValue(r64, "OUI_Bg_Floating_Blue_Light");
        OUI_Bg_Floating_Blue_Light = r64;
        MaterialConfig[] r65 = MaterialTokenCore.OUI_Bg_Floating_Blue_Dark;
        Intrinsics.checkNotNullExpressionValue(r65, "OUI_Bg_Floating_Blue_Dark");
        OUI_Bg_Floating_Blue_Dark = r65;
        OUI_Bg_Floating_Blue = MaterialToken$OUI_Bg_Floating_Blue$1.INSTANCE;
        MaterialConfig r66 = MaterialTokenCore.OUI_Text_Primary_Light;
        Intrinsics.checkNotNullExpressionValue(r66, "OUI_Text_Primary_Light");
        OUI_Text_Primary_Light = r66;
        MaterialConfig r67 = MaterialTokenCore.OUI_Text_Primary_Dark;
        Intrinsics.checkNotNullExpressionValue(r67, "OUI_Text_Primary_Dark");
        OUI_Text_Primary_Dark = r67;
        OUI_Text_Primary = MaterialToken$OUI_Text_Primary$1.INSTANCE;
        MaterialConfig r68 = MaterialTokenCore.OUI_Text_Secondary_Light;
        Intrinsics.checkNotNullExpressionValue(r68, "OUI_Text_Secondary_Light");
        OUI_Text_Secondary_Light = r68;
        MaterialConfig r69 = MaterialTokenCore.OUI_Text_Secondary_Dark;
        Intrinsics.checkNotNullExpressionValue(r69, "OUI_Text_Secondary_Dark");
        OUI_Text_Secondary_Dark = r69;
        OUI_Text_Secondary = MaterialToken$OUI_Text_Secondary$1.INSTANCE;
        MaterialConfig r70 = MaterialTokenCore.OUI_Text_Tertiary_Light;
        Intrinsics.checkNotNullExpressionValue(r70, "OUI_Text_Tertiary_Light");
        OUI_Text_Tertiary_Light = r70;
        MaterialConfig r71 = MaterialTokenCore.OUI_Text_Tertiary_Dark;
        Intrinsics.checkNotNullExpressionValue(r71, "OUI_Text_Tertiary_Dark");
        OUI_Text_Tertiary_Dark = r71;
        OUI_Text_Tertiary = MaterialToken$OUI_Text_Tertiary$1.INSTANCE;
    }

    private final ConcurrentHashMap<String, MaterialConfig> getTokens() {
        return (ConcurrentHashMap) tokens$delegate.getValue();
    }

    private final ConcurrentHashMap<String, MaterialConfig[]> getTokenSets() {
        return (ConcurrentHashMap) tokenSets$delegate.getValue();
    }

    private final ConcurrentHashMap<String, Function1<Boolean, MaterialConfig>> getProviders() {
        return (ConcurrentHashMap) providers$delegate.getValue();
    }

    private final ConcurrentHashMap<String, Function1<Boolean, MaterialConfig[]>> getSetProviders() {
        return (ConcurrentHashMap) setProviders$delegate.getValue();
    }

    public static /* synthetic */ void register$default(Object r0, boolean r1, int r2, Object r3) {
        if ((r2 & 2) == 0) goto L5;
        r1 = true;
    L5:
        register(r0, r1);
    }

    @JvmStatic
    public static final void register(Object r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r11, "customTokenOwner");
        TokenParser r0 = TokenParser.INSTANCE;
        ConcurrentHashMap<String, MaterialConfig> r1 = INSTANCE.getTokens();
        LinkedHashMap r3 = new LinkedHashMap();
        Field[] r4 = r11.getClass().getDeclaredFields();     // Catch: Exception -> L11
        Intrinsics.checkNotNullExpressionValue(r4, TracingConstants.KEY_FIELDS);     // Catch: Exception -> L11
        int r5 = r4.length;     // Catch: Exception -> L11
        int r6 = 0;
    L4:
        if (r6 >= r5) goto L13;
        Field r7 = r4[r6];     // Catch: Exception -> L11
        r6 = r6 + 1;     // Catch: Exception -> L11
        if (MaterialConfig.class.isAssignableFrom(r7.getType()) == false) goto L4;
        r7.setAccessible(true);     // Catch: Exception -> L11
        Object r8 = r7.get(r11);     // Catch: Exception -> L11
        if ((r8 instanceof MaterialConfig) == false) goto L4;
        String r9 = r7.getName();     // Catch: Exception -> L11
        Intrinsics.checkNotNullExpressionValue(r9, "field.name");     // Catch: Exception -> L11
        Locale r10 = Locale.ROOT;     // Catch: Exception -> L11
        Intrinsics.checkNotNullExpressionValue(r10, "ROOT");     // Catch: Exception -> L11
        String r13 = r9.toLowerCase(r10);     // Catch: Exception -> L11
        Intrinsics.checkNotNullExpressionValue(r13, "this as java.lang.String).toLowerCase(locale)");     // Catch: Exception -> L11
        r3.put(r13, r8);     // Catch: Exception -> L11
    L13:
        r0.registerTokens(r1, r3, r12);
        return;
    L11:
        e = move-exception;
        Log.e("TokenParser", Intrinsics.stringPlus("Failed to parse tokens from ", r11.getClass().getSimpleName()), e);
        goto L13
    }

    public static /* synthetic */ void registerSet$default(Object r0, boolean r1, int r2, Object r3) {
        if ((r2 & 2) == 0) goto L5;
        r1 = true;
    L5:
        registerSet(r0, r1);
    }

    @JvmStatic
    public static final void registerSet(Object r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r11, "customTokenOwner");
        TokenParser r0 = TokenParser.INSTANCE;
        ConcurrentHashMap<String, MaterialConfig[]> r1 = INSTANCE.getTokenSets();
        LinkedHashMap r3 = new LinkedHashMap();
        Field[] r4 = r11.getClass().getDeclaredFields();     // Catch: Exception -> L11
        Intrinsics.checkNotNullExpressionValue(r4, TracingConstants.KEY_FIELDS);     // Catch: Exception -> L11
        int r5 = r4.length;     // Catch: Exception -> L11
        int r6 = 0;
    L4:
        if (r6 >= r5) goto L13;
        Field r7 = r4[r6];     // Catch: Exception -> L11
        r6 = r6 + 1;     // Catch: Exception -> L11
        if (MaterialConfig[].class.isAssignableFrom(r7.getType()) == false) goto L4;
        r7.setAccessible(true);     // Catch: Exception -> L11
        Object r8 = r7.get(r11);     // Catch: Exception -> L11
        if ((r8 instanceof MaterialConfig[]) == false) goto L4;
        String r9 = r7.getName();     // Catch: Exception -> L11
        Intrinsics.checkNotNullExpressionValue(r9, "field.name");     // Catch: Exception -> L11
        Locale r10 = Locale.ROOT;     // Catch: Exception -> L11
        Intrinsics.checkNotNullExpressionValue(r10, "ROOT");     // Catch: Exception -> L11
        String r13 = r9.toLowerCase(r10);     // Catch: Exception -> L11
        Intrinsics.checkNotNullExpressionValue(r13, "this as java.lang.String).toLowerCase(locale)");     // Catch: Exception -> L11
        r3.put(r13, r8);     // Catch: Exception -> L11
    L13:
        r0.registerTokens(r1, r3, r12);
        return;
    L11:
        e = move-exception;
        Log.e("TokenParser", Intrinsics.stringPlus("Failed to parse tokens from ", r11.getClass().getSimpleName()), e);
        goto L13
    }

    public static /* synthetic */ void registerTokens$default(Map r0, boolean r1, int r2, Object r3) {
        if ((r2 & 2) == 0) goto L5;
        r1 = true;
    L5:
        registerTokens(r0, r1);
    }

    @JvmStatic
    public static final void registerTokens(Map<String, MaterialConfig> r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "customTokens");
        TokenParser.INSTANCE.registerTokens(INSTANCE.getTokens(), r2, r3);
    }

    public static /* synthetic */ void registerTokenSets$default(Map r0, boolean r1, int r2, Object r3) {
        if ((r2 & 2) == 0) goto L5;
        r1 = true;
    L5:
        registerTokenSets(r0, r1);
    }

    @JvmStatic
    public static final void registerTokenSets(Map<String, MaterialConfig[]> r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "customTokens");
        TokenParser.INSTANCE.registerTokens(INSTANCE.getTokenSets(), r2, r3);
    }

    public static /* synthetic */ void registerProvider$default(Object r0, boolean r1, int r2, Object r3) {
        if ((r2 & 2) == 0) goto L5;
        r1 = true;
    L5:
        registerProvider(r0, r1);
    }

    @JvmStatic
    public static final void registerProvider(Object r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r11, "customTokenOwner");
        TokenParser r0 = TokenParser.INSTANCE;
        ConcurrentHashMap<String, Function1<Boolean, MaterialConfig>> r1 = INSTANCE.getProviders();
        LinkedHashMap r3 = new LinkedHashMap();
        Field[] r4 = r11.getClass().getDeclaredFields();     // Catch: Exception -> L11
        Intrinsics.checkNotNullExpressionValue(r4, TracingConstants.KEY_FIELDS);     // Catch: Exception -> L11
        int r5 = r4.length;     // Catch: Exception -> L11
        int r6 = 0;
    L4:
        if (r6 >= r5) goto L13;
        Field r7 = r4[r6];     // Catch: Exception -> L11
        r6 = r6 + 1;     // Catch: Exception -> L11
        if (Function1.class.isAssignableFrom(r7.getType()) == false) goto L4;
        r7.setAccessible(true);     // Catch: Exception -> L11
        Object r9 = r7.get(r11);     // Catch: Exception -> L11
        if (TypeIntrinsics.isFunctionOfArity(r9, 1) == false) goto L4;
        String r8 = r7.getName();     // Catch: Exception -> L11
        Intrinsics.checkNotNullExpressionValue(r8, "field.name");     // Catch: Exception -> L11
        Locale r10 = Locale.ROOT;     // Catch: Exception -> L11
        Intrinsics.checkNotNullExpressionValue(r10, "ROOT");     // Catch: Exception -> L11
        String r13 = r8.toLowerCase(r10);     // Catch: Exception -> L11
        Intrinsics.checkNotNullExpressionValue(r13, "this as java.lang.String).toLowerCase(locale)");     // Catch: Exception -> L11
        Intrinsics.checkNotNullExpressionValue(r9, "value");     // Catch: Exception -> L11
        r3.put(r13, r9);     // Catch: Exception -> L11
    L13:
        r0.registerTokens(r1, r3, r12);
        return;
    L11:
        e = move-exception;
        Log.e("TokenParser", Intrinsics.stringPlus("Failed to parse tokens from ", r11.getClass().getSimpleName()), e);
        goto L13
    }

    public static /* synthetic */ void registerSetProvider$default(Object r0, boolean r1, int r2, Object r3) {
        if ((r2 & 2) == 0) goto L5;
        r1 = true;
    L5:
        registerSetProvider(r0, r1);
    }

    @JvmStatic
    public static final void registerSetProvider(Object r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r11, "customTokenOwner");
        TokenParser r0 = TokenParser.INSTANCE;
        ConcurrentHashMap<String, Function1<Boolean, MaterialConfig[]>> r1 = INSTANCE.getSetProviders();
        LinkedHashMap r3 = new LinkedHashMap();
        Field[] r4 = r11.getClass().getDeclaredFields();     // Catch: Exception -> L11
        Intrinsics.checkNotNullExpressionValue(r4, TracingConstants.KEY_FIELDS);     // Catch: Exception -> L11
        int r5 = r4.length;     // Catch: Exception -> L11
        int r6 = 0;
    L4:
        if (r6 >= r5) goto L13;
        Field r7 = r4[r6];     // Catch: Exception -> L11
        r6 = r6 + 1;     // Catch: Exception -> L11
        if (Function1.class.isAssignableFrom(r7.getType()) == false) goto L4;
        r7.setAccessible(true);     // Catch: Exception -> L11
        Object r9 = r7.get(r11);     // Catch: Exception -> L11
        if (TypeIntrinsics.isFunctionOfArity(r9, 1) == false) goto L4;
        String r8 = r7.getName();     // Catch: Exception -> L11
        Intrinsics.checkNotNullExpressionValue(r8, "field.name");     // Catch: Exception -> L11
        Locale r10 = Locale.ROOT;     // Catch: Exception -> L11
        Intrinsics.checkNotNullExpressionValue(r10, "ROOT");     // Catch: Exception -> L11
        String r13 = r8.toLowerCase(r10);     // Catch: Exception -> L11
        Intrinsics.checkNotNullExpressionValue(r13, "this as java.lang.String).toLowerCase(locale)");     // Catch: Exception -> L11
        Intrinsics.checkNotNullExpressionValue(r9, "value");     // Catch: Exception -> L11
        r3.put(r13, r9);     // Catch: Exception -> L11
    L13:
        r0.registerTokens(r1, r3, r12);
        return;
    L11:
        e = move-exception;
        Log.e("TokenParser", Intrinsics.stringPlus("Failed to parse tokens from ", r11.getClass().getSimpleName()), e);
        goto L13
    }

    public static /* synthetic */ void registerProviderTokens$default(Map r0, boolean r1, int r2, Object r3) {
        if ((r2 & 2) == 0) goto L5;
        r1 = true;
    L5:
        registerProviderTokens(r0, r1);
    }

    @JvmStatic
    public static final void registerProviderTokens(Map<String, ? extends Function1<? super Boolean, MaterialConfig>> r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "customTokens");
        TokenParser.INSTANCE.registerTokens(INSTANCE.getProviders(), r2, r3);
    }

    public static /* synthetic */ void registerSetProviderTokens$default(Map r0, boolean r1, int r2, Object r3) {
        if ((r2 & 2) == 0) goto L5;
        r1 = true;
    L5:
        registerSetProviderTokens(r0, r1);
    }

    @JvmStatic
    public static final void registerSetProviderTokens(Map<String, ? extends Function1<? super Boolean, MaterialConfig[]>> r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "customTokens");
        TokenParser.INSTANCE.registerTokens(INSTANCE.getSetProviders(), r2, r3);
    }

    @JvmStatic
    public static final Function1<Boolean, MaterialConfig> parse(String r2) {
        final Function1 r3 = (Function1) TokenParser.INSTANCE.parse(r2, INSTANCE.getProviders());
        if (r3 != null) goto L7;
        return null;
    L7:
        return new C02841(r3);
    }

    @JvmStatic
    public static final Function1<Boolean, MaterialConfig[]> parseSet(String r2) {
        final Function1 r3 = (Function1) TokenParser.INSTANCE.parse(r2, INSTANCE.getSetProviders());
        if (r3 != null) goto L7;
        return null;
    L7:
        return new C02851(r3);
    }

    @JvmStatic
    public static final MaterialConfig parse(String r3, boolean r4) {
        TokenParser r0 = TokenParser.INSTANCE;
        MaterialToken r1 = INSTANCE;
        MaterialConfig r2 = (MaterialConfig) r0.parse(r3, r1.getTokens());
        if (r2 != null) goto L10;
        TokenParser r5 = TokenParser.INSTANCE;
        if (r4 == false) goto L7;
        String r6 = "_light";
    L8:
        r2 = (MaterialConfig) r5.parse(Intrinsics.stringPlus(r3, r6), r1.getTokens());
        goto L10
    L7:
        r6 = "_dark";
    L10:
        return compatibleConfig(r2);
    }

    @JvmStatic
    public static final MaterialConfig[] parseSet(String r3, boolean r4) {
        TokenParser r0 = TokenParser.INSTANCE;
        MaterialToken r1 = INSTANCE;
        MaterialConfig[] r2 = (MaterialConfig[]) r0.parse(r3, r1.getTokenSets());
        if (r2 != null) goto L9;
        TokenParser r5 = TokenParser.INSTANCE;
        if (r4 == false) goto L7;
        String r6 = "_light";
    L8:
        r2 = (MaterialConfig[]) r5.parse(Intrinsics.stringPlus(r3, r6), r1.getTokenSets());
        goto L9
    L7:
        r6 = "_dark";
    L9:
        if (r2 != null) goto L14;
        MaterialConfig r7 = parse(r3, r4);
        if (r7 == null) goto L14;
        r2 = new MaterialConfig[]{r7};
    L14:
        return compatibleConfigArray(r2);
    }

    public static /* synthetic */ boolean isApiCompatible$default(int r0, int r1, Object r2) {
        if ((r1 & 1) == 0) goto L6;
        r0 = 4;
    L6:
        return isApiCompatible(r0);
    }

    @JvmStatic
    public static final boolean isApiCompatible(int r1) {
        if (OMaterialHelper.getApiLevel() < r1) goto L5;
        return true;
    L5:
        return false;
    }

    @JvmStatic
    public static final MaterialConfig compatibleConfig(MaterialConfig r4) {
        if (r4 != null) goto L5;
        return null;
    L5:
        int r1 = OMaterialHelper.getApiLevel();
        MaterialToken r2 = INSTANCE;
        if (r1 >= 1) goto L9;
        return null;
    L9:
        if (r1 < 4) goto L12;
        return r4.deepCopy();
    L12:
        if (r1 < 3) goto L15;
        return r2.toApi3CompatibleConfig(r4);
    L15:
        return r2.toLegacyCompatibleConfig(r4);
    }

    @JvmStatic
    public static final MaterialConfig[] compatibleConfigArray(MaterialConfig[] r8) {
        Object[] r0 = null;
        if (r8 != null) goto L5;
        return null;
    L5:
        int r1 = OMaterialHelper.getApiLevel();
        MaterialToken r2 = INSTANCE;
        if (r1 >= 1) goto L8;
        return null;
    L8:
        AnonymousClass1 r3 = new AnonymousClass1(r2);
        ArrayList r4 = new ArrayList();
        int r5 = r8.length;
        boolean r6 = false;
        int r7 = 0;
    L9:
        if (r7 >= r5) goto L14;
        MaterialConfig r9 = r3.invoke(r8[r7]);
        if (r9 == null) goto L13;
        r4.add(r9);
    L13:
        r7 = r7 + 1;
        goto L9
    L14:
        Object[] r10 = r4.toArray(new MaterialConfig[0]);
        if (r10 == null) goto L25;
        if (((MaterialConfig[]) r10).length != 0) goto L20;
        r6 = true;
    L20:
        if ((!r6) == false) goto L23;
        r0 = r10;
    L23:
        return (MaterialConfig[]) r0;
    L25:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    public final MaterialConfig[] resolveTokenForBuilder$OUI_standardRelease(String r7, boolean r8) {
        MaterialConfig[] r0 = (MaterialConfig[]) TokenParser.INSTANCE.parse(r7, getTokenSets());
        String r1 = "_light";
        if (r0 != null) goto L10;
        TokenParser r2 = TokenParser.INSTANCE;
        if (r8 == false) goto L7;
        Object r3 = "_light";
    L8:
        r0 = (MaterialConfig[]) r2.parse(Intrinsics.stringPlus(r7, r3), getTokenSets());
        goto L10
    L7:
        r3 = "_dark";
    L10:
        if (r0 == null) goto L20;
        ArrayList r6 = new ArrayList(r0.length);
        int r9 = r0.length;
        int r10 = 0;
    L12:
        if (r10 >= r9) goto L14;
        r6.add(r0[r10].deepCopy());
        r10 = r10 + 1;
        goto L12
    L14:
        Object[] r11 = r6.toArray(new MaterialConfig[0]);
        if (r11 == null) goto L19;
        return (MaterialConfig[]) r11;
    L19:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    L20:
        Function1 r4 = (Function1) TokenParser.INSTANCE.parse(r7, getSetProviders());
        if (r4 != null) goto L39;
        MaterialConfig r5 = (MaterialConfig) TokenParser.INSTANCE.parse(r7, getTokens());
        if (r5 != null) goto L30;
        TokenParser r12 = TokenParser.INSTANCE;
        if (r8 == true) goto L28;
        r1 = "_dark";
    L28:
        r5 = (MaterialConfig) r12.parse(Intrinsics.stringPlus(r7, r1), getTokens());
    L30:
        if (r5 != null) goto L32;
        Function1 r13 = (Function1) TokenParser.INSTANCE.parse(r7, getProviders());
        if (r13 != null) goto L38;
        return null;
    L38:
        return new MaterialConfig[]{((MaterialConfig) r13.invoke(Boolean.valueOf(r8))).deepCopy()};
    L32:
        return new MaterialConfig[]{r5.deepCopy()};
    L39:
        Object[] r14 = (Object[]) r4.invoke(Boolean.valueOf(r8));
        ArrayList r15 = new ArrayList(r14.length);
        int r16 = r14.length;
        int r17 = 0;
    L40:
        if (r17 >= r16) goto L42;
        r15.add(((MaterialConfig) r14[r17]).deepCopy());
        r17 = r17 + 1;
        goto L40
    L42:
        Object[] r18 = r15.toArray(new MaterialConfig[0]);
        if (r18 == null) goto L47;
        return (MaterialConfig[]) r18;
    L47:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    private final MaterialConfig toLegacyCompatibleConfig(MaterialConfig r2) {
        MaterialConfig r1 = r2.deepCopy();
        BlendConfig[] r3 = r1.getBlendConfig();
        if (r3 != null) goto L8;
        BlendConfigStateList r4 = r1.getBlendConfigStateList();
        if (r4 != null) goto L7;
        r3 = null;
        goto L8
    L7:
        r3 = r4.getDefaultBlendConfig();
    L8:
        r1.setBlendConfig(r3);
        r1.setBlendConfigStateList(null);
        StrokeConfig r5 = r1.getStroke();
        if (r5 != null) goto L14;
        StrokeStateList r6 = r1.getStrokeStateList();
        if (r6 != null) goto L13;
        r5 = null;
        goto L14
    L13:
        r5 = r6.getDefaultStroke();
    L14:
        r1.setStroke(r5);
        r1.setStrokeStateList(null);
        r1.setOverlayBlendConfigStateList(null);
        r1.setFluid(null);
        return r1;
    }

    private final MaterialConfig toApi3CompatibleConfig(MaterialConfig r1) {
        return r1.deepCopy();
    }
}
