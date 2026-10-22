package com.obric.oui.color;

import android.util.Log;
import com.bytedance.tracing.internal.TracingConstants;
import com.obric.oui.graphic.BlendMode;
import com.obric.oui.material.TokenParser;
import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: compiled from: BlendToken.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000=\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0003\b¢\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J)\u0010³\u0001\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0018\u00010\u00042\n\u0010´\u0001\u001a\u0005\u0018\u00010«\u0001H\u0007J,\u0010³\u0001\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\n\u0010´\u0001\u001a\u0005\u0018\u00010«\u00012\u0007\u0010µ\u0001\u001a\u00020\u0005H\u0007¢\u0006\u0003\u0010¶\u0001J\u001e\u0010·\u0001\u001a\u00030¸\u00012\u0007\u0010¹\u0001\u001a\u00020\u00012\t\b\u0002\u0010º\u0001\u001a\u00020\u0005H\u0007J\u001e\u0010»\u0001\u001a\u00030¸\u00012\u0007\u0010¹\u0001\u001a\u00020\u00012\t\b\u0002\u0010º\u0001\u001a\u00020\u0005H\u0007J>\u0010¼\u0001\u001a\u00030¸\u00012'\u0010½\u0001\u001a\"\u0012\u0005\u0012\u00030«\u0001\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00040¾\u00012\t\b\u0002\u0010º\u0001\u001a\u00020\u0005H\u0007J2\u0010¿\u0001\u001a\u00030¸\u00012\u001b\u0010½\u0001\u001a\u0016\u0012\u0005\u0012\u00030«\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060¾\u00012\t\b\u0002\u0010º\u0001\u001a\u00020\u0005H\u0007R.\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\b\u0010\u0002\u001a\u0004\b\t\u0010\nR\u0018\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0018\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR.\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0002\u001a\u0004\b\u0010\u0010\nR\u0018\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0018\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR.\u0010\u0013\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0002\u001a\u0004\b\u0015\u0010\nR\u0018\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0018\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR.\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u0002\u001a\u0004\b\u001a\u0010\nR\u0018\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0018\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR.\u0010\u001d\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u0002\u001a\u0004\b\u001f\u0010\nR\u0018\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0018\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR.\u0010\"\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b#\u0010\u0002\u001a\u0004\b$\u0010\nR\u0018\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0018\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR.\u0010'\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b(\u0010\u0002\u001a\u0004\b)\u0010\nR\u0018\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0018\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR.\u0010,\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b-\u0010\u0002\u001a\u0004\b.\u0010\nR\u0018\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0018\u00100\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR.\u00101\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b2\u0010\u0002\u001a\u0004\b3\u0010\nR\u0018\u00104\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0018\u00105\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR.\u00106\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b7\u0010\u0002\u001a\u0004\b8\u0010\nR\u0018\u00109\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0018\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR.\u0010;\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b<\u0010\u0002\u001a\u0004\b=\u0010\nR\u0018\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0018\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR.\u0010@\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bA\u0010\u0002\u001a\u0004\bB\u0010\nR\u0018\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0018\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR.\u0010E\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bF\u0010\u0002\u001a\u0004\bG\u0010\nR\u0018\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0018\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR.\u0010J\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bK\u0010\u0002\u001a\u0004\bL\u0010\nR\u0018\u0010M\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0018\u0010N\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0018\u0010O\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0018\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR.\u0010Q\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bR\u0010\u0002\u001a\u0004\bS\u0010\nR\u0018\u0010T\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0018\u0010U\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR.\u0010V\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bW\u0010\u0002\u001a\u0004\bX\u0010\nR\u0018\u0010Y\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0018\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR.\u0010[\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\\\u0010\u0002\u001a\u0004\b]\u0010\nR\u0018\u0010^\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0018\u0010_\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR.\u0010`\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\ba\u0010\u0002\u001a\u0004\bb\u0010\nR\u0018\u0010c\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0018\u0010d\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR.\u0010e\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bf\u0010\u0002\u001a\u0004\bg\u0010\nR\u0018\u0010h\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0018\u0010i\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0018\u0010j\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0018\u0010k\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR.\u0010l\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bm\u0010\u0002\u001a\u0004\bn\u0010\nR\u0018\u0010o\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0018\u0010p\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR.\u0010q\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\br\u0010\u0002\u001a\u0004\bs\u0010\nR\u0018\u0010t\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0018\u0010u\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR.\u0010v\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bw\u0010\u0002\u001a\u0004\bx\u0010\nR\u0018\u0010y\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0018\u0010z\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR.\u0010{\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b|\u0010\u0002\u001a\u0004\b}\u0010\nR\u0018\u0010~\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0018\u0010\u007f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR1\u0010\u0080\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00048\u0006X\u0087\u0004¢\u0006\u0010\n\u0000\u0012\u0005\b\u0081\u0001\u0010\u0002\u001a\u0005\b\u0082\u0001\u0010\nR\u0019\u0010\u0083\u0001\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0019\u0010\u0084\u0001\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR1\u0010\u0085\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00048\u0006X\u0087\u0004¢\u0006\u0010\n\u0000\u0012\u0005\b\u0086\u0001\u0010\u0002\u001a\u0005\b\u0087\u0001\u0010\nR\u0019\u0010\u0088\u0001\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0019\u0010\u0089\u0001\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR1\u0010\u008a\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00048\u0006X\u0087\u0004¢\u0006\u0010\n\u0000\u0012\u0005\b\u008b\u0001\u0010\u0002\u001a\u0005\b\u008c\u0001\u0010\nR\u0019\u0010\u008d\u0001\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0019\u0010\u008e\u0001\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR1\u0010\u008f\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00048\u0006X\u0087\u0004¢\u0006\u0010\n\u0000\u0012\u0005\b\u0090\u0001\u0010\u0002\u001a\u0005\b\u0091\u0001\u0010\nR\u0019\u0010\u0092\u0001\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0019\u0010\u0093\u0001\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR1\u0010\u0094\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00048\u0006X\u0087\u0004¢\u0006\u0010\n\u0000\u0012\u0005\b\u0095\u0001\u0010\u0002\u001a\u0005\b\u0096\u0001\u0010\nR\u0019\u0010\u0097\u0001\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0019\u0010\u0098\u0001\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR1\u0010\u0099\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00048\u0006X\u0087\u0004¢\u0006\u0010\n\u0000\u0012\u0005\b\u009a\u0001\u0010\u0002\u001a\u0005\b\u009b\u0001\u0010\nR\u0019\u0010\u009c\u0001\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0019\u0010\u009d\u0001\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR1\u0010\u009e\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00048\u0006X\u0087\u0004¢\u0006\u0010\n\u0000\u0012\u0005\b\u009f\u0001\u0010\u0002\u001a\u0005\b \u0001\u0010\nR\u0019\u0010¡\u0001\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0019\u0010¢\u0001\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0019\u0010£\u0001\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0019\u0010¤\u0001\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0011\u0010¥\u0001\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0011\u0010¦\u0001\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0011\u0010§\u0001\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0011\u0010¨\u0001\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R@\u0010©\u0001\u001a\"\u0012\u0005\u0012\u00030«\u0001\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00040ª\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b®\u0001\u0010¯\u0001\u001a\u0006\b¬\u0001\u0010\u00ad\u0001R4\u0010°\u0001\u001a\u0016\u0012\u0005\u0012\u00030«\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060ª\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b²\u0001\u0010¯\u0001\u001a\u0006\b±\u0001\u0010\u00ad\u0001¨\u0006À\u0001"}, d2 = {"Lcom/obric/oui/color/BlendToken;", "", "()V", "Blend_Base_Regular", "Lkotlin/Function1;", "", "", "Lcom/obric/oui/color/BlendConfig;", "getBlend_Base_Regular$annotations", "getBlend_Base_Regular", "()Lkotlin/jvm/functions/Function1;", "Blend_Base_Regular_Dark", "[Lcom/obric/oui/color/BlendConfig;", "Blend_Base_Regular_Light", "Blend_Base_Thick", "getBlend_Base_Thick$annotations", "getBlend_Base_Thick", "Blend_Base_Thick_Dark", "Blend_Base_Thick_Light", "Blend_Blue_4", "getBlend_Blue_4$annotations", "getBlend_Blue_4", "Blend_Blue_4_Dark", "Blend_Blue_4_Light", "Blend_Blue_6", "getBlend_Blue_6$annotations", "getBlend_Blue_6", "Blend_Blue_6_Dark", "Blend_Blue_6_Light", "Blend_Fill_Element_2", "getBlend_Fill_Element_2$annotations", "getBlend_Fill_Element_2", "Blend_Fill_Element_2_Dark", "Blend_Fill_Element_2_Light", "Blend_Fluid_Thin", "getBlend_Fluid_Thin$annotations", "getBlend_Fluid_Thin", "Blend_Fluid_Thin_Dark", "Blend_Fluid_Thin_Light", "Blend_Green_4", "getBlend_Green_4$annotations", "getBlend_Green_4", "Blend_Green_4_Dark", "Blend_Green_4_Light", "Blend_Green_6", "getBlend_Green_6$annotations", "getBlend_Green_6", "Blend_Green_6_Dark", "Blend_Green_6_Light", "Blend_Red_4", "getBlend_Red_4$annotations", "getBlend_Red_4", "Blend_Red_4_Dark", "Blend_Red_4_Light", "Blend_Red_6", "getBlend_Red_6$annotations", "getBlend_Red_6", "Blend_Red_6_Dark", "Blend_Red_6_Light", "Blend_Yellow_4", "getBlend_Yellow_4$annotations", "getBlend_Yellow_4", "Blend_Yellow_4_Dark", "Blend_Yellow_4_Light", "Blend_Yellow_6", "getBlend_Yellow_6$annotations", "getBlend_Yellow_6", "Blend_Yellow_6_Dark", "Blend_Yellow_6_Light", "OUI_Color_Blend_Blue_Regular", "getOUI_Color_Blend_Blue_Regular$annotations", "getOUI_Color_Blend_Blue_Regular", "OUI_Color_Blend_Blue_Regular_Dark", "OUI_Color_Blend_Blue_Regular_Light", "OUI_Color_Blend_Blue_Thin", "getOUI_Color_Blend_Blue_Thin$annotations", "getOUI_Color_Blend_Blue_Thin", "OUI_Color_Blend_Blue_Thin_Dark", "OUI_Color_Blend_Blue_Thin_Light", "OUI_Color_Blend_Fill_Tinted_Dark", "OUI_Color_Blend_Fill_Tinted_Light", "OUI_Color_Blend_Fluid_Regular", "getOUI_Color_Blend_Fluid_Regular$annotations", "getOUI_Color_Blend_Fluid_Regular", "OUI_Color_Blend_Fluid_Regular_Dark", "OUI_Color_Blend_Fluid_Regular_Light", "OUI_Color_Blend_Fluid_Thick", "getOUI_Color_Blend_Fluid_Thick$annotations", "getOUI_Color_Blend_Fluid_Thick", "OUI_Color_Blend_Fluid_Thick_Dark", "OUI_Color_Blend_Fluid_Thick_Light", "OUI_Color_Blend_Fluid_Thin", "getOUI_Color_Blend_Fluid_Thin$annotations", "getOUI_Color_Blend_Fluid_Thin", "OUI_Color_Blend_Fluid_Thin_Dark", "OUI_Color_Blend_Fluid_Thin_Light", "OUI_Color_Blend_Fluid_UltraThin", "getOUI_Color_Blend_Fluid_UltraThin$annotations", "getOUI_Color_Blend_Fluid_UltraThin", "OUI_Color_Blend_Fluid_UltraThin_Dark", "OUI_Color_Blend_Fluid_UltraThin_Light", "OUI_Color_Blend_Frost_Regular", "getOUI_Color_Blend_Frost_Regular$annotations", "getOUI_Color_Blend_Frost_Regular", "OUI_Color_Blend_Frost_Regular_Dark", "OUI_Color_Blend_Frost_Regular_Light", "OUI_Color_Blend_Frost_Thick_Dark", "OUI_Color_Blend_Frost_Thick_Light", "OUI_Color_Blend_Frost_Thin", "getOUI_Color_Blend_Frost_Thin$annotations", "getOUI_Color_Blend_Frost_Thin", "OUI_Color_Blend_Frost_Thin_Dark", "OUI_Color_Blend_Frost_Thin_Light", "OUI_Color_Blend_Frost_UltraThin", "getOUI_Color_Blend_Frost_UltraThin$annotations", "getOUI_Color_Blend_Frost_UltraThin", "OUI_Color_Blend_Frost_UltraThin_Dark", "OUI_Color_Blend_Frost_UltraThin_Light", "OUI_Color_Blend_Green_Regular", "getOUI_Color_Blend_Green_Regular$annotations", "getOUI_Color_Blend_Green_Regular", "OUI_Color_Blend_Green_Regular_Dark", "OUI_Color_Blend_Green_Regular_Light", "OUI_Color_Blend_Green_Thin", "getOUI_Color_Blend_Green_Thin$annotations", "getOUI_Color_Blend_Green_Thin", "OUI_Color_Blend_Green_Thin_Dark", "OUI_Color_Blend_Green_Thin_Light", "OUI_Color_Blend_Red_Regular", "getOUI_Color_Blend_Red_Regular$annotations", "getOUI_Color_Blend_Red_Regular", "OUI_Color_Blend_Red_Regular_Dark", "OUI_Color_Blend_Red_Regular_Light", "OUI_Color_Blend_Red_Thin", "getOUI_Color_Blend_Red_Thin$annotations", "getOUI_Color_Blend_Red_Thin", "OUI_Color_Blend_Red_Thin_Dark", "OUI_Color_Blend_Red_Thin_Light", "OUI_Color_Blend_Text_Primary", "getOUI_Color_Blend_Text_Primary$annotations", "getOUI_Color_Blend_Text_Primary", "OUI_Color_Blend_Text_Primary_Dark", "OUI_Color_Blend_Text_Primary_Light", "OUI_Color_Blend_Text_Secondary", "getOUI_Color_Blend_Text_Secondary$annotations", "getOUI_Color_Blend_Text_Secondary", "OUI_Color_Blend_Text_Secondary_Dark", "OUI_Color_Blend_Text_Secondary_Light", "OUI_Color_Blend_Text_Tertiary", "getOUI_Color_Blend_Text_Tertiary$annotations", "getOUI_Color_Blend_Text_Tertiary", "OUI_Color_Blend_Text_Tertiary_Dark", "OUI_Color_Blend_Text_Tertiary_Light", "OUI_Color_Blend_Yellow_Regular", "getOUI_Color_Blend_Yellow_Regular$annotations", "getOUI_Color_Blend_Yellow_Regular", "OUI_Color_Blend_Yellow_Regular_Dark", "OUI_Color_Blend_Yellow_Regular_Light", "OUI_Color_Blend_Yellow_Thin", "getOUI_Color_Blend_Yellow_Thin$annotations", "getOUI_Color_Blend_Yellow_Thin", "OUI_Color_Blend_Yellow_Thin_Dark", "OUI_Color_Blend_Yellow_Thin_Light", "OUI_Color_Fills_Thick_Dark", "OUI_Color_Fills_Thick_Light", "OUI_Color_State_Active_Dark", "OUI_Color_State_Active_Light", "OUI_Color_State_Press_Dark", "OUI_Color_State_Press_Light", "providers", "Ljava/util/concurrent/ConcurrentHashMap;", "", "getProviders", "()Ljava/util/concurrent/ConcurrentHashMap;", "providers$delegate", "Lkotlin/Lazy;", "tokens", "getTokens", "tokens$delegate", "parse", "name", "isLight", "(Ljava/lang/String;Z)[Lcom/obric/oui/color/BlendConfig;", "register", "", "customTokenOwner", "overrideExisting", "registerProvider", "registerProviderTokens", "customTokens", "", "registerTokens", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BlendToken {
    private static final kotlin.jvm.functions.Function1<Boolean, BlendConfig[]> Blend_Base_Regular = null;
    public static final BlendConfig[] Blend_Base_Regular_Dark = null;
    public static final BlendConfig[] Blend_Base_Regular_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, BlendConfig[]> Blend_Base_Thick = null;
    public static final BlendConfig[] Blend_Base_Thick_Dark = null;
    public static final BlendConfig[] Blend_Base_Thick_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, BlendConfig[]> Blend_Blue_4 = null;
    public static final BlendConfig[] Blend_Blue_4_Dark = null;
    public static final BlendConfig[] Blend_Blue_4_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, BlendConfig[]> Blend_Blue_6 = null;
    public static final BlendConfig[] Blend_Blue_6_Dark = null;
    public static final BlendConfig[] Blend_Blue_6_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, BlendConfig[]> Blend_Fill_Element_2 = null;
    public static final BlendConfig[] Blend_Fill_Element_2_Dark = null;
    public static final BlendConfig[] Blend_Fill_Element_2_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, BlendConfig[]> Blend_Fluid_Thin = null;
    public static final BlendConfig[] Blend_Fluid_Thin_Dark = null;
    public static final BlendConfig[] Blend_Fluid_Thin_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, BlendConfig[]> Blend_Green_4 = null;
    public static final BlendConfig[] Blend_Green_4_Dark = null;
    public static final BlendConfig[] Blend_Green_4_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, BlendConfig[]> Blend_Green_6 = null;
    public static final BlendConfig[] Blend_Green_6_Dark = null;
    public static final BlendConfig[] Blend_Green_6_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, BlendConfig[]> Blend_Red_4 = null;
    public static final BlendConfig[] Blend_Red_4_Dark = null;
    public static final BlendConfig[] Blend_Red_4_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, BlendConfig[]> Blend_Red_6 = null;
    public static final BlendConfig[] Blend_Red_6_Dark = null;
    public static final BlendConfig[] Blend_Red_6_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, BlendConfig[]> Blend_Yellow_4 = null;
    public static final BlendConfig[] Blend_Yellow_4_Dark = null;
    public static final BlendConfig[] Blend_Yellow_4_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, BlendConfig[]> Blend_Yellow_6 = null;
    public static final BlendConfig[] Blend_Yellow_6_Dark = null;
    public static final BlendConfig[] Blend_Yellow_6_Light = null;
    public static final BlendToken INSTANCE = null;
    private static final kotlin.jvm.functions.Function1<Boolean, BlendConfig[]> OUI_Color_Blend_Blue_Regular = null;
    public static final BlendConfig[] OUI_Color_Blend_Blue_Regular_Dark = null;
    public static final BlendConfig[] OUI_Color_Blend_Blue_Regular_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, BlendConfig[]> OUI_Color_Blend_Blue_Thin = null;
    public static final BlendConfig[] OUI_Color_Blend_Blue_Thin_Dark = null;
    public static final BlendConfig[] OUI_Color_Blend_Blue_Thin_Light = null;
    public static final BlendConfig[] OUI_Color_Blend_Fill_Tinted_Dark = null;
    public static final BlendConfig[] OUI_Color_Blend_Fill_Tinted_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, BlendConfig[]> OUI_Color_Blend_Fluid_Regular = null;
    public static final BlendConfig[] OUI_Color_Blend_Fluid_Regular_Dark = null;
    public static final BlendConfig[] OUI_Color_Blend_Fluid_Regular_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, BlendConfig[]> OUI_Color_Blend_Fluid_Thick = null;
    public static final BlendConfig[] OUI_Color_Blend_Fluid_Thick_Dark = null;
    public static final BlendConfig[] OUI_Color_Blend_Fluid_Thick_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, BlendConfig[]> OUI_Color_Blend_Fluid_Thin = null;
    public static final BlendConfig[] OUI_Color_Blend_Fluid_Thin_Dark = null;
    public static final BlendConfig[] OUI_Color_Blend_Fluid_Thin_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, BlendConfig[]> OUI_Color_Blend_Fluid_UltraThin = null;
    public static final BlendConfig[] OUI_Color_Blend_Fluid_UltraThin_Dark = null;
    public static final BlendConfig[] OUI_Color_Blend_Fluid_UltraThin_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, BlendConfig[]> OUI_Color_Blend_Frost_Regular = null;
    public static final BlendConfig[] OUI_Color_Blend_Frost_Regular_Dark = null;
    public static final BlendConfig[] OUI_Color_Blend_Frost_Regular_Light = null;
    public static final BlendConfig[] OUI_Color_Blend_Frost_Thick_Dark = null;
    public static final BlendConfig[] OUI_Color_Blend_Frost_Thick_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, BlendConfig[]> OUI_Color_Blend_Frost_Thin = null;
    public static final BlendConfig[] OUI_Color_Blend_Frost_Thin_Dark = null;
    public static final BlendConfig[] OUI_Color_Blend_Frost_Thin_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, BlendConfig[]> OUI_Color_Blend_Frost_UltraThin = null;
    public static final BlendConfig[] OUI_Color_Blend_Frost_UltraThin_Dark = null;
    public static final BlendConfig[] OUI_Color_Blend_Frost_UltraThin_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, BlendConfig[]> OUI_Color_Blend_Green_Regular = null;
    public static final BlendConfig[] OUI_Color_Blend_Green_Regular_Dark = null;
    public static final BlendConfig[] OUI_Color_Blend_Green_Regular_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, BlendConfig[]> OUI_Color_Blend_Green_Thin = null;
    public static final BlendConfig[] OUI_Color_Blend_Green_Thin_Dark = null;
    public static final BlendConfig[] OUI_Color_Blend_Green_Thin_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, BlendConfig[]> OUI_Color_Blend_Red_Regular = null;
    public static final BlendConfig[] OUI_Color_Blend_Red_Regular_Dark = null;
    public static final BlendConfig[] OUI_Color_Blend_Red_Regular_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, BlendConfig[]> OUI_Color_Blend_Red_Thin = null;
    public static final BlendConfig[] OUI_Color_Blend_Red_Thin_Dark = null;
    public static final BlendConfig[] OUI_Color_Blend_Red_Thin_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, BlendConfig[]> OUI_Color_Blend_Text_Primary = null;
    public static final BlendConfig[] OUI_Color_Blend_Text_Primary_Dark = null;
    public static final BlendConfig[] OUI_Color_Blend_Text_Primary_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, BlendConfig[]> OUI_Color_Blend_Text_Secondary = null;
    public static final BlendConfig[] OUI_Color_Blend_Text_Secondary_Dark = null;
    public static final BlendConfig[] OUI_Color_Blend_Text_Secondary_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, BlendConfig[]> OUI_Color_Blend_Text_Tertiary = null;
    public static final BlendConfig[] OUI_Color_Blend_Text_Tertiary_Dark = null;
    public static final BlendConfig[] OUI_Color_Blend_Text_Tertiary_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, BlendConfig[]> OUI_Color_Blend_Yellow_Regular = null;
    public static final BlendConfig[] OUI_Color_Blend_Yellow_Regular_Dark = null;
    public static final BlendConfig[] OUI_Color_Blend_Yellow_Regular_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, BlendConfig[]> OUI_Color_Blend_Yellow_Thin = null;
    public static final BlendConfig[] OUI_Color_Blend_Yellow_Thin_Dark = null;
    public static final BlendConfig[] OUI_Color_Blend_Yellow_Thin_Light = null;
    public static final BlendConfig[] OUI_Color_Fills_Thick_Dark = null;
    public static final BlendConfig[] OUI_Color_Fills_Thick_Light = null;
    public static final BlendConfig OUI_Color_State_Active_Dark = null;
    public static final BlendConfig OUI_Color_State_Active_Light = null;
    public static final BlendConfig OUI_Color_State_Press_Dark = null;
    public static final BlendConfig OUI_Color_State_Press_Light = null;
    private static final Lazy providers$delegate = null;
    private static final Lazy tokens$delegate = null;

    @JvmStatic
    public static /* synthetic */ void getBlend_Base_Regular$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getBlend_Base_Thick$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getBlend_Blue_4$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getBlend_Blue_6$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getBlend_Fill_Element_2$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getBlend_Fluid_Thin$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getBlend_Green_4$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getBlend_Green_6$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getBlend_Red_4$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getBlend_Red_6$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getBlend_Yellow_4$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getBlend_Yellow_6$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Color_Blend_Blue_Regular$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Color_Blend_Blue_Thin$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Color_Blend_Fluid_Regular$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Color_Blend_Fluid_Thick$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Color_Blend_Fluid_Thin$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Color_Blend_Fluid_UltraThin$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Color_Blend_Frost_Regular$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Color_Blend_Frost_Thin$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Color_Blend_Frost_UltraThin$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Color_Blend_Green_Regular$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Color_Blend_Green_Thin$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Color_Blend_Red_Regular$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Color_Blend_Red_Thin$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Color_Blend_Text_Primary$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Color_Blend_Text_Secondary$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Color_Blend_Text_Tertiary$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Color_Blend_Yellow_Regular$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Color_Blend_Yellow_Thin$annotations() {
    }

    private BlendToken() {
    }

    static {
        INSTANCE = new BlendToken();
        tokens$delegate = LazyKt.lazy(BlendToken$tokens$2.INSTANCE);
        providers$delegate = LazyKt.lazy(BlendToken$providers$2.INSTANCE);
        Blend_Base_Thick_Light = new BlendConfig[]{new BlendConfig(-1726013665, BlendMode.COLOR_DODGE), new BlendConfig(-604571914, BlendMode.SRC_OVER)};
        Blend_Base_Thick_Dark = new BlendConfig[]{new BlendConfig(-3355444, BlendMode.COLOR_BURN), new BlendConfig(-618388444, BlendMode.SRC_OVER)};
        Blend_Base_Thick = BlendToken$Blend_Base_Thick$1.INSTANCE;
        Blend_Base_Regular_Light = new BlendConfig[]{new BlendConfig(-14737633, BlendMode.COLOR_DODGE), new BlendConfig(-855638017, BlendMode.SRC_OVER)};
        Blend_Base_Regular_Dark = new BlendConfig[]{new BlendConfig(-3355444, BlendMode.COLOR_BURN), new BlendConfig(-666746302, BlendMode.SRC_OVER)};
        Blend_Base_Regular = BlendToken$Blend_Base_Regular$1.INSTANCE;
        OUI_Color_Blend_Frost_Regular_Light = new BlendConfig[]{new BlendConfig(-14737633, BlendMode.COLOR_DODGE), new BlendConfig(-855638017, BlendMode.SRC_OVER)};
        OUI_Color_Blend_Frost_Regular_Dark = new BlendConfig[]{new BlendConfig(-3355444, BlendMode.COLOR_BURN), new BlendConfig(-868072894, BlendMode.SRC_OVER)};
        OUI_Color_Blend_Frost_Regular = BlendToken$OUI_Color_Blend_Frost_Regular$1.INSTANCE;
        OUI_Color_Blend_Fluid_Regular_Light = new BlendConfig[]{new BlendConfig(1722987186, BlendMode.LUMINOSITY), new BlendConfig(-13421773, BlendMode.COLOR_DODGE), new BlendConfig(872415231, BlendMode.SRC_OVER)};
        OUI_Color_Blend_Fluid_Regular_Dark = new BlendConfig[]{new BlendConfig(-2137483112, BlendMode.LUMINOSITY), new BlendConfig(-1716210508, BlendMode.COLOR_BURN), new BlendConfig(352321535, BlendMode.SRC_OVER)};
        OUI_Color_Blend_Fluid_Regular = BlendToken$OUI_Color_Blend_Fluid_Regular$1.INSTANCE;
        OUI_Color_Blend_Frost_UltraThin_Light = new BlendConfig[]{new BlendConfig(-14737633, BlendMode.PLUS_LIGHTER)};
        OUI_Color_Blend_Frost_UltraThin_Dark = new BlendConfig[]{new BlendConfig(-14737633, BlendMode.PLUS_LIGHTER)};
        OUI_Color_Blend_Frost_UltraThin = BlendToken$OUI_Color_Blend_Frost_UltraThin$1.INSTANCE;
        OUI_Color_Blend_Fluid_UltraThin_Light = new BlendConfig[]{new BlendConfig(-15461356, BlendMode.PLUS_LIGHTER)};
        OUI_Color_Blend_Fluid_UltraThin_Dark = new BlendConfig[]{new BlendConfig(-15461356, BlendMode.PLUS_LIGHTER)};
        OUI_Color_Blend_Fluid_UltraThin = BlendToken$OUI_Color_Blend_Fluid_UltraThin$1.INSTANCE;
        OUI_Color_Blend_Frost_Thin_Light = new BlendConfig[]{new BlendConfig(1722329256, BlendMode.LUMINOSITY), new BlendConfig(-13421773, BlendMode.COLOR_DODGE), new BlendConfig(-1711276033, BlendMode.SRC_OVER)};
        OUI_Color_Blend_Frost_Thin_Dark = new BlendConfig[]{new BlendConfig(-2137417319, BlendMode.LUMINOSITY)};
        OUI_Color_Blend_Frost_Thin = BlendToken$OUI_Color_Blend_Frost_Thin$1.INSTANCE;
        OUI_Color_Blend_Fluid_Thin_Light = new BlendConfig[]{new BlendConfig(869059788, BlendMode.LUMINOSITY), new BlendConfig(-1724697805, BlendMode.COLOR_DODGE), new BlendConfig(352321535, BlendMode.SRC_OVER)};
        OUI_Color_Blend_Fluid_Thin_Dark = new BlendConfig[]{new BlendConfig(1721342361, BlendMode.LUMINOSITY)};
        OUI_Color_Blend_Fluid_Thin = BlendToken$OUI_Color_Blend_Fluid_Thin$1.INSTANCE;
        OUI_Color_Blend_Frost_Thick_Light = new BlendConfig[]{new BlendConfig(-1726013665, BlendMode.COLOR_DODGE), new BlendConfig(-604506121, BlendMode.SRC_OVER)};
        OUI_Color_Blend_Frost_Thick_Dark = new BlendConfig[]{new BlendConfig(-3355444, BlendMode.COLOR_BURN), new BlendConfig(-618059479, BlendMode.SRC_OVER)};
        OUI_Color_Blend_Fluid_Thick_Light = new BlendConfig[]{new BlendConfig(-1726013665, BlendMode.COLOR_DODGE), new BlendConfig(-604506121, BlendMode.SRC_OVER)};
        OUI_Color_Blend_Fluid_Thick_Dark = new BlendConfig[]{new BlendConfig(-858993460, BlendMode.COLOR_BURN), new BlendConfig(-869717719, BlendMode.SRC_OVER)};
        OUI_Color_Blend_Fluid_Thick = BlendToken$OUI_Color_Blend_Fluid_Thick$1.INSTANCE;
        OUI_Color_Fills_Thick_Light = new BlendConfig[]{new BlendConfig(251658240, BlendMode.SRC_OVER)};
        OUI_Color_Fills_Thick_Dark = new BlendConfig[]{new BlendConfig(620756991, BlendMode.SRC_OVER)};
        OUI_Color_Blend_Text_Primary_Light = new BlendConfig[]{new BlendConfig(-13421773, BlendMode.PLUS_DARKER)};
        OUI_Color_Blend_Text_Primary_Dark = new BlendConfig[]{new BlendConfig(-2500135, BlendMode.PLUS_LIGHTER)};
        OUI_Color_Blend_Text_Primary = BlendToken$OUI_Color_Blend_Text_Primary$1.INSTANCE;
        OUI_Color_Blend_Text_Secondary_Light = new BlendConfig[]{new BlendConfig(-6710887, BlendMode.PLUS_DARKER)};
        OUI_Color_Blend_Text_Secondary_Dark = new BlendConfig[]{new BlendConfig(-9211021, BlendMode.PLUS_LIGHTER)};
        OUI_Color_Blend_Text_Secondary = BlendToken$OUI_Color_Blend_Text_Secondary$1.INSTANCE;
        OUI_Color_Blend_Text_Tertiary_Light = new BlendConfig[]{new BlendConfig(-4342339, BlendMode.PLUS_DARKER)};
        OUI_Color_Blend_Text_Tertiary_Dark = new BlendConfig[]{new BlendConfig(-10921639, BlendMode.PLUS_LIGHTER)};
        OUI_Color_Blend_Text_Tertiary = BlendToken$OUI_Color_Blend_Text_Tertiary$1.INSTANCE;
        OUI_Color_Blend_Fill_Tinted_Light = new BlendConfig[]{new BlendConfig(-2130706433, BlendMode.SRC_OVER), new BlendConfig(-3355444, BlendMode.OVERLAY), new BlendConfig(-1, BlendMode.PLUS_DARKER)};
        OUI_Color_Blend_Fill_Tinted_Dark = new BlendConfig[]{new BlendConfig(-2130706433, BlendMode.SRC_OVER), new BlendConfig(-3355444, BlendMode.OVERLAY), new BlendConfig(-16777216, BlendMode.PLUS_DARKER)};
        OUI_Color_Blend_Blue_Thin_Light = new BlendConfig[]{new BlendConfig(-2130706433, BlendMode.SRC_OVER), new BlendConfig(-3355444, BlendMode.OVERLAY), new BlendConfig(-10049793, BlendMode.PLUS_DARKER)};
        OUI_Color_Blend_Blue_Thin_Dark = new BlendConfig[]{new BlendConfig(-2130706433, BlendMode.SRC_OVER), new BlendConfig(-3355444, BlendMode.OVERLAY), new BlendConfig(-10049793, BlendMode.PLUS_DARKER)};
        OUI_Color_Blend_Blue_Thin = BlendToken$OUI_Color_Blend_Blue_Thin$1.INSTANCE;
        OUI_Color_Blend_Blue_Regular_Light = new BlendConfig[]{new BlendConfig(-2130706433, BlendMode.SRC_OVER), new BlendConfig(-3355444, BlendMode.OVERLAY), new BlendConfig(-14253569, BlendMode.PLUS_DARKER)};
        OUI_Color_Blend_Blue_Regular_Dark = new BlendConfig[]{new BlendConfig(-2130706433, BlendMode.SRC_OVER), new BlendConfig(-3355444, BlendMode.OVERLAY), new BlendConfig(-14253569, BlendMode.PLUS_DARKER)};
        OUI_Color_Blend_Blue_Regular = BlendToken$OUI_Color_Blend_Blue_Regular$1.INSTANCE;
        OUI_Color_Blend_Red_Thin_Light = new BlendConfig[]{new BlendConfig(-2130706433, BlendMode.SRC_OVER), new BlendConfig(-3355444, BlendMode.OVERLAY), new BlendConfig(-30841, BlendMode.PLUS_DARKER)};
        OUI_Color_Blend_Red_Thin_Dark = new BlendConfig[]{new BlendConfig(-2130706433, BlendMode.SRC_OVER), new BlendConfig(-3355444, BlendMode.OVERLAY), new BlendConfig(-30841, BlendMode.PLUS_DARKER)};
        OUI_Color_Blend_Red_Thin = BlendToken$OUI_Color_Blend_Red_Thin$1.INSTANCE;
        OUI_Color_Blend_Red_Regular_Light = new BlendConfig[]{new BlendConfig(-2130706433, BlendMode.SRC_OVER), new BlendConfig(-3355444, BlendMode.OVERLAY), new BlendConfig(-45747, BlendMode.PLUS_DARKER)};
        OUI_Color_Blend_Red_Regular_Dark = new BlendConfig[]{new BlendConfig(-2130706433, BlendMode.SRC_OVER), new BlendConfig(-3355444, BlendMode.OVERLAY), new BlendConfig(-45747, BlendMode.PLUS_DARKER)};
        OUI_Color_Blend_Red_Regular = BlendToken$OUI_Color_Blend_Red_Regular$1.INSTANCE;
        OUI_Color_Blend_Green_Thin_Light = new BlendConfig[]{new BlendConfig(-2130706433, BlendMode.SRC_OVER), new BlendConfig(-3355444, BlendMode.OVERLAY), new BlendConfig(-8917601, BlendMode.PLUS_DARKER)};
        OUI_Color_Blend_Green_Thin_Dark = new BlendConfig[]{new BlendConfig(-2130706433, BlendMode.SRC_OVER), new BlendConfig(-3355444, BlendMode.OVERLAY), new BlendConfig(-8917601, BlendMode.PLUS_DARKER)};
        OUI_Color_Blend_Green_Thin = BlendToken$OUI_Color_Blend_Green_Thin$1.INSTANCE;
        OUI_Color_Blend_Green_Regular_Light = new BlendConfig[]{new BlendConfig(-2130706433, BlendMode.SRC_OVER), new BlendConfig(-3355444, BlendMode.OVERLAY), new BlendConfig(-15415472, BlendMode.PLUS_DARKER)};
        OUI_Color_Blend_Green_Regular_Dark = new BlendConfig[]{new BlendConfig(-2130706433, BlendMode.SRC_OVER), new BlendConfig(-3355444, BlendMode.OVERLAY), new BlendConfig(-15415472, BlendMode.PLUS_DARKER)};
        OUI_Color_Blend_Green_Regular = BlendToken$OUI_Color_Blend_Green_Regular$1.INSTANCE;
        OUI_Color_Blend_Yellow_Thin_Light = new BlendConfig[]{new BlendConfig(-2130706433, BlendMode.SRC_OVER), new BlendConfig(-3355444, BlendMode.OVERLAY), new BlendConfig(-11671, BlendMode.PLUS_DARKER)};
        OUI_Color_Blend_Yellow_Thin_Dark = new BlendConfig[]{new BlendConfig(-2130706433, BlendMode.SRC_OVER), new BlendConfig(-3355444, BlendMode.OVERLAY), new BlendConfig(-11671, BlendMode.PLUS_DARKER)};
        OUI_Color_Blend_Yellow_Thin = BlendToken$OUI_Color_Blend_Yellow_Thin$1.INSTANCE;
        OUI_Color_Blend_Yellow_Regular_Light = new BlendConfig[]{new BlendConfig(-2130706433, BlendMode.SRC_OVER), new BlendConfig(-3355444, BlendMode.OVERLAY), new BlendConfig(-15078, BlendMode.PLUS_DARKER)};
        OUI_Color_Blend_Yellow_Regular_Dark = new BlendConfig[]{new BlendConfig(-2130706433, BlendMode.SRC_OVER), new BlendConfig(-3355444, BlendMode.OVERLAY), new BlendConfig(-15078, BlendMode.PLUS_DARKER)};
        OUI_Color_Blend_Yellow_Regular = BlendToken$OUI_Color_Blend_Yellow_Regular$1.INSTANCE;
        OUI_Color_State_Press_Light = new BlendConfig(-13421773, BlendMode.PLUS_LIGHTER);
        OUI_Color_State_Press_Dark = new BlendConfig(-1724697805, BlendMode.PLUS_LIGHTER);
        OUI_Color_State_Active_Light = new BlendConfig(-6710887, BlendMode.PLUS_LIGHTER);
        OUI_Color_State_Active_Dark = new BlendConfig(-6710887, BlendMode.PLUS_LIGHTER);
        Blend_Blue_6_Light = new BlendConfig[]{new BlendConfig(-2130706433, BlendMode.SRC_OVER), new BlendConfig(-3355444, BlendMode.OVERLAY), new BlendConfig(-15042049, BlendMode.PLUS_DARKER)};
        Blend_Blue_6_Dark = new BlendConfig[]{new BlendConfig(-2130706433, BlendMode.SRC_OVER), new BlendConfig(-3355444, BlendMode.OVERLAY), new BlendConfig(-15042049, BlendMode.PLUS_DARKER)};
        Blend_Blue_6 = BlendToken$Blend_Blue_6$1.INSTANCE;
        Blend_Blue_4_Light = new BlendConfig[]{new BlendConfig(-2130706433, BlendMode.SRC_OVER), new BlendConfig(-3355444, BlendMode.OVERLAY), new BlendConfig(-10049793, BlendMode.PLUS_DARKER)};
        Blend_Blue_4_Dark = new BlendConfig[]{new BlendConfig(-2130706433, BlendMode.SRC_OVER), new BlendConfig(-3355444, BlendMode.OVERLAY), new BlendConfig(-10049793, BlendMode.PLUS_DARKER)};
        Blend_Blue_4 = BlendToken$Blend_Blue_4$1.INSTANCE;
        Blend_Yellow_6_Light = new BlendConfig[]{new BlendConfig(-2130706433, BlendMode.SRC_OVER), new BlendConfig(-3355444, BlendMode.OVERLAY), new BlendConfig(-873984, BlendMode.PLUS_DARKER)};
        Blend_Yellow_6_Dark = new BlendConfig[]{new BlendConfig(-2130706433, BlendMode.SRC_OVER), new BlendConfig(-3355444, BlendMode.OVERLAY), new BlendConfig(-873984, BlendMode.PLUS_DARKER)};
        Blend_Yellow_6 = BlendToken$Blend_Yellow_6$1.INSTANCE;
        Blend_Yellow_4_Light = new BlendConfig[]{new BlendConfig(-2130706433, BlendMode.SRC_OVER), new BlendConfig(-3355444, BlendMode.OVERLAY), new BlendConfig(-11671, BlendMode.PLUS_DARKER)};
        Blend_Yellow_4_Dark = new BlendConfig[]{new BlendConfig(-2130706433, BlendMode.SRC_OVER), new BlendConfig(-3355444, BlendMode.OVERLAY), new BlendConfig(-11671, BlendMode.PLUS_DARKER)};
        Blend_Yellow_4 = BlendToken$Blend_Yellow_4$1.INSTANCE;
        Blend_Green_6_Light = new BlendConfig[]{new BlendConfig(-2130706433, BlendMode.SRC_OVER), new BlendConfig(-3355444, BlendMode.OVERLAY), new BlendConfig(-16722873, BlendMode.PLUS_DARKER)};
        Blend_Green_6_Dark = new BlendConfig[]{new BlendConfig(-2130706433, BlendMode.SRC_OVER), new BlendConfig(-3355444, BlendMode.OVERLAY), new BlendConfig(-16722873, BlendMode.PLUS_DARKER)};
        Blend_Green_6 = BlendToken$Blend_Green_6$1.INSTANCE;
        Blend_Green_4_Light = new BlendConfig[]{new BlendConfig(-2130706433, BlendMode.SRC_OVER), new BlendConfig(-3355444, BlendMode.OVERLAY), new BlendConfig(-8917601, BlendMode.PLUS_DARKER)};
        Blend_Green_4_Dark = new BlendConfig[]{new BlendConfig(-2130706433, BlendMode.SRC_OVER), new BlendConfig(-3355444, BlendMode.OVERLAY), new BlendConfig(-8917601, BlendMode.PLUS_DARKER)};
        Blend_Green_4 = BlendToken$Blend_Green_4$1.INSTANCE;
        Blend_Red_6_Light = new BlendConfig[]{new BlendConfig(-2130706433, BlendMode.SRC_OVER), new BlendConfig(-3355444, BlendMode.OVERLAY), new BlendConfig(-53971, BlendMode.PLUS_DARKER)};
        Blend_Red_6_Dark = new BlendConfig[]{new BlendConfig(-2130706433, BlendMode.SRC_OVER), new BlendConfig(-3355444, BlendMode.OVERLAY), new BlendConfig(-53971, BlendMode.PLUS_DARKER)};
        Blend_Red_6 = BlendToken$Blend_Red_6$1.INSTANCE;
        Blend_Red_4_Light = new BlendConfig[]{new BlendConfig(-2130706433, BlendMode.SRC_OVER), new BlendConfig(-3355444, BlendMode.OVERLAY), new BlendConfig(-30841, BlendMode.PLUS_DARKER)};
        Blend_Red_4_Dark = new BlendConfig[]{new BlendConfig(-2130706433, BlendMode.SRC_OVER), new BlendConfig(-3355444, BlendMode.OVERLAY), new BlendConfig(-30841, BlendMode.PLUS_DARKER)};
        Blend_Red_4 = BlendToken$Blend_Red_4$1.INSTANCE;
        Blend_Fill_Element_2_Light = new BlendConfig[]{new BlendConfig(167772160, BlendMode.SRC_OVER)};
        Blend_Fill_Element_2_Dark = new BlendConfig[]{new BlendConfig(536870911, BlendMode.SRC_OVER)};
        Blend_Fill_Element_2 = BlendToken$Blend_Fill_Element_2$1.INSTANCE;
        Blend_Fluid_Thin_Light = new BlendConfig[]{new BlendConfig(-13421773, BlendMode.COLOR_DODGE), new BlendConfig(1088018905, BlendMode.SRC_OVER)};
        Blend_Fluid_Thin_Dark = new BlendConfig[]{new BlendConfig(-13421773, BlendMode.COLOR_DODGE), new BlendConfig(1088018905, BlendMode.SRC_OVER)};
        Blend_Fluid_Thin = BlendToken$Blend_Fluid_Thin$1.INSTANCE;
    }

    private final ConcurrentHashMap<String, BlendConfig[]> getTokens() {
        return (ConcurrentHashMap) tokens$delegate.getValue();
    }

    private final ConcurrentHashMap<String, kotlin.jvm.functions.Function1<Boolean, BlendConfig[]>> getProviders() {
        return (ConcurrentHashMap) providers$delegate.getValue();
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
        ConcurrentHashMap<String, BlendConfig[]> r1 = INSTANCE.getTokens();
        LinkedHashMap r3 = new LinkedHashMap();
        Field[] r4 = r11.getClass().getDeclaredFields();     // Catch: Exception -> L11
        Intrinsics.checkNotNullExpressionValue(r4, TracingConstants.KEY_FIELDS);     // Catch: Exception -> L11
        int r5 = r4.length;     // Catch: Exception -> L11
        int r6 = 0;
    L4:
        if (r6 >= r5) goto L13;
        Field r7 = r4[r6];     // Catch: Exception -> L11
        r6 = r6 + 1;     // Catch: Exception -> L11
        if (BlendConfig[].class.isAssignableFrom(r7.getType()) == false) goto L4;
        r7.setAccessible(true);     // Catch: Exception -> L11
        Object r8 = r7.get(r11);     // Catch: Exception -> L11
        if ((r8 instanceof BlendConfig[]) == false) goto L4;
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
    public static final void registerTokens(Map<String, BlendConfig[]> r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "customTokens");
        TokenParser.INSTANCE.registerTokens(INSTANCE.getTokens(), r2, r3);
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
        ConcurrentHashMap<String, kotlin.jvm.functions.Function1<Boolean, BlendConfig[]>> r1 = INSTANCE.getProviders();
        LinkedHashMap r3 = new LinkedHashMap();
        Field[] r4 = r11.getClass().getDeclaredFields();     // Catch: Exception -> L11
        Intrinsics.checkNotNullExpressionValue(r4, TracingConstants.KEY_FIELDS);     // Catch: Exception -> L11
        int r5 = r4.length;     // Catch: Exception -> L11
        int r6 = 0;
    L4:
        if (r6 >= r5) goto L13;
        Field r7 = r4[r6];     // Catch: Exception -> L11
        r6 = r6 + 1;     // Catch: Exception -> L11
        if (kotlin.jvm.functions.Function1.class.isAssignableFrom(r7.getType()) == false) goto L4;
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
    public static final void registerProviderTokens(Map<String, ? extends kotlin.jvm.functions.Function1<? super Boolean, BlendConfig[]>> r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "customTokens");
        TokenParser.INSTANCE.registerTokens(INSTANCE.getProviders(), r2, r3);
    }

    @JvmStatic
    public static final kotlin.jvm.functions.Function1<Boolean, BlendConfig[]> parse(String r2) {
        return (kotlin.jvm.functions.Function1) TokenParser.INSTANCE.parse(r2, INSTANCE.getProviders());
    }

    @JvmStatic
    public static final BlendConfig[] parse(String r3, boolean r4) {
        TokenParser r0 = TokenParser.INSTANCE;
        BlendToken r1 = INSTANCE;
        if (((BlendConfig[]) r0.parse(r3, r1.getTokens())) != null) goto L10;
        TokenParser r2 = TokenParser.INSTANCE;
        if (r4 == false) goto L7;
        String r5 = "_light";
    L8:
        BlendConfig[] r6 = (BlendConfig[]) r2.parse(Intrinsics.stringPlus(r3, r5), r1.getTokens());
        goto L10
    L7:
        r5 = "_dark";
    L10:
        return (BlendConfig[]) TokenParser.INSTANCE.parse(r3, r1.getTokens());
    }

    public static final kotlin.jvm.functions.Function1<Boolean, BlendConfig[]> getBlend_Base_Thick() {
        return Blend_Base_Thick;
    }

    public static final kotlin.jvm.functions.Function1<Boolean, BlendConfig[]> getBlend_Base_Regular() {
        return Blend_Base_Regular;
    }

    public static final kotlin.jvm.functions.Function1<Boolean, BlendConfig[]> getOUI_Color_Blend_Frost_Regular() {
        return OUI_Color_Blend_Frost_Regular;
    }

    public static final kotlin.jvm.functions.Function1<Boolean, BlendConfig[]> getOUI_Color_Blend_Fluid_Regular() {
        return OUI_Color_Blend_Fluid_Regular;
    }

    public static final kotlin.jvm.functions.Function1<Boolean, BlendConfig[]> getOUI_Color_Blend_Frost_UltraThin() {
        return OUI_Color_Blend_Frost_UltraThin;
    }

    public static final kotlin.jvm.functions.Function1<Boolean, BlendConfig[]> getOUI_Color_Blend_Fluid_UltraThin() {
        return OUI_Color_Blend_Fluid_UltraThin;
    }

    public static final kotlin.jvm.functions.Function1<Boolean, BlendConfig[]> getOUI_Color_Blend_Frost_Thin() {
        return OUI_Color_Blend_Frost_Thin;
    }

    public static final kotlin.jvm.functions.Function1<Boolean, BlendConfig[]> getOUI_Color_Blend_Fluid_Thin() {
        return OUI_Color_Blend_Fluid_Thin;
    }

    public static final kotlin.jvm.functions.Function1<Boolean, BlendConfig[]> getOUI_Color_Blend_Fluid_Thick() {
        return OUI_Color_Blend_Fluid_Thick;
    }

    public static final kotlin.jvm.functions.Function1<Boolean, BlendConfig[]> getOUI_Color_Blend_Text_Primary() {
        return OUI_Color_Blend_Text_Primary;
    }

    public static final kotlin.jvm.functions.Function1<Boolean, BlendConfig[]> getOUI_Color_Blend_Text_Secondary() {
        return OUI_Color_Blend_Text_Secondary;
    }

    public static final kotlin.jvm.functions.Function1<Boolean, BlendConfig[]> getOUI_Color_Blend_Text_Tertiary() {
        return OUI_Color_Blend_Text_Tertiary;
    }

    public static final kotlin.jvm.functions.Function1<Boolean, BlendConfig[]> getOUI_Color_Blend_Blue_Thin() {
        return OUI_Color_Blend_Blue_Thin;
    }

    public static final kotlin.jvm.functions.Function1<Boolean, BlendConfig[]> getOUI_Color_Blend_Blue_Regular() {
        return OUI_Color_Blend_Blue_Regular;
    }

    public static final kotlin.jvm.functions.Function1<Boolean, BlendConfig[]> getOUI_Color_Blend_Red_Thin() {
        return OUI_Color_Blend_Red_Thin;
    }

    public static final kotlin.jvm.functions.Function1<Boolean, BlendConfig[]> getOUI_Color_Blend_Red_Regular() {
        return OUI_Color_Blend_Red_Regular;
    }

    public static final kotlin.jvm.functions.Function1<Boolean, BlendConfig[]> getOUI_Color_Blend_Green_Thin() {
        return OUI_Color_Blend_Green_Thin;
    }

    public static final kotlin.jvm.functions.Function1<Boolean, BlendConfig[]> getOUI_Color_Blend_Green_Regular() {
        return OUI_Color_Blend_Green_Regular;
    }

    public static final kotlin.jvm.functions.Function1<Boolean, BlendConfig[]> getOUI_Color_Blend_Yellow_Thin() {
        return OUI_Color_Blend_Yellow_Thin;
    }

    public static final kotlin.jvm.functions.Function1<Boolean, BlendConfig[]> getOUI_Color_Blend_Yellow_Regular() {
        return OUI_Color_Blend_Yellow_Regular;
    }

    public static final kotlin.jvm.functions.Function1<Boolean, BlendConfig[]> getBlend_Blue_6() {
        return Blend_Blue_6;
    }

    public static final kotlin.jvm.functions.Function1<Boolean, BlendConfig[]> getBlend_Blue_4() {
        return Blend_Blue_4;
    }

    public static final kotlin.jvm.functions.Function1<Boolean, BlendConfig[]> getBlend_Yellow_6() {
        return Blend_Yellow_6;
    }

    public static final kotlin.jvm.functions.Function1<Boolean, BlendConfig[]> getBlend_Yellow_4() {
        return Blend_Yellow_4;
    }

    public static final kotlin.jvm.functions.Function1<Boolean, BlendConfig[]> getBlend_Green_6() {
        return Blend_Green_6;
    }

    public static final kotlin.jvm.functions.Function1<Boolean, BlendConfig[]> getBlend_Green_4() {
        return Blend_Green_4;
    }

    public static final kotlin.jvm.functions.Function1<Boolean, BlendConfig[]> getBlend_Red_6() {
        return Blend_Red_6;
    }

    public static final kotlin.jvm.functions.Function1<Boolean, BlendConfig[]> getBlend_Red_4() {
        return Blend_Red_4;
    }

    public static final kotlin.jvm.functions.Function1<Boolean, BlendConfig[]> getBlend_Fill_Element_2() {
        return Blend_Fill_Element_2;
    }

    public static final kotlin.jvm.functions.Function1<Boolean, BlendConfig[]> getBlend_Fluid_Thin() {
        return Blend_Fluid_Thin;
    }
}
