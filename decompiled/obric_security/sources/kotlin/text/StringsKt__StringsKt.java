package kotlin.text;

import com.bytedance.apm.constant.TraceStatsConsts;
import com.bytedanceos.datausage.DataUsageDetailActivity;
import com.bytedanceos.security.Utils;
import com.bytedanceos.utils.Constants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CharIterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import org.apache.commons.io.IOUtils;

/* JADX INFO: compiled from: Strings.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0019\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b!\u001a\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006H\u0000\u001a\u001c\u0010\f\u001a\u00020\r*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a\u001c\u0010\u0011\u001a\u00020\r*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a\u001f\u0010\u0012\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0086\u0002\u001a\u001f\u0010\u0012\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0086\u0002\u001a\u0015\u0010\u0012\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0016H\u0087\n\u001a\u0018\u0010\u0017\u001a\u00020\u0010*\u0004\u0018\u00010\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0000\u001a\u0018\u0010\u0018\u001a\u00020\u0010*\u0004\u0018\u00010\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0000\u001a\u001c\u0010\u0019\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a\u001c\u0010\u0019\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a:\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r\u0018\u00010\u001c*\u00020\u00022\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\r0\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001aE\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r\u0018\u00010\u001c*\u00020\u00022\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\r0\u001e2\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u0010H\u0002¢\u0006\u0002\b!\u001a:\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r\u0018\u00010\u001c*\u00020\u00022\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\r0\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a\u0012\u0010#\u001a\u00020\u0010*\u00020\u00022\u0006\u0010$\u001a\u00020\u0006\u001a7\u0010%\u001a\u0002H&\"\f\b\u0000\u0010'*\u00020\u0002*\u0002H&\"\u0004\b\u0001\u0010&*\u0002H'2\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H&0)H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010*\u001a7\u0010+\u001a\u0002H&\"\f\b\u0000\u0010'*\u00020\u0002*\u0002H&\"\u0004\b\u0001\u0010&*\u0002H'2\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H&0)H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010*\u001a&\u0010,\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a;\u0010,\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010 \u001a\u00020\u0010H\u0002¢\u0006\u0002\b.\u001a&\u0010,\u001a\u00020\u0006*\u00020\u00022\u0006\u0010/\u001a\u00020\r2\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a&\u00100\u001a\u00020\u0006*\u00020\u00022\u0006\u00101\u001a\u0002022\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a,\u00100\u001a\u00020\u0006*\u00020\u00022\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\r0\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a\r\u00103\u001a\u00020\u0010*\u00020\u0002H\u0087\b\u001a\r\u00104\u001a\u00020\u0010*\u00020\u0002H\u0087\b\u001a\r\u00105\u001a\u00020\u0010*\u00020\u0002H\u0087\b\u001a \u00106\u001a\u00020\u0010*\u0004\u0018\u00010\u0002H\u0087\b\u0082\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000\u001a \u00107\u001a\u00020\u0010*\u0004\u0018\u00010\u0002H\u0087\b\u0082\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000\u001a\r\u00108\u001a\u000209*\u00020\u0002H\u0086\u0002\u001a&\u0010:\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a&\u0010:\u001a\u00020\u0006*\u00020\u00022\u0006\u0010/\u001a\u00020\r2\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a&\u0010;\u001a\u00020\u0006*\u00020\u00022\u0006\u00101\u001a\u0002022\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a,\u0010;\u001a\u00020\u0006*\u00020\u00022\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\r0\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a\u0010\u0010<\u001a\b\u0012\u0004\u0012\u00020\r0=*\u00020\u0002\u001a\u0010\u0010>\u001a\b\u0012\u0004\u0012\u00020\r0?*\u00020\u0002\u001a\u0015\u0010@\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0016H\u0087\f\u001a\u000f\u0010A\u001a\u00020\r*\u0004\u0018\u00010\rH\u0087\b\u001a\u001c\u0010B\u001a\u00020\u0002*\u00020\u00022\u0006\u0010C\u001a\u00020\u00062\b\b\u0002\u0010D\u001a\u00020\u0014\u001a\u001c\u0010B\u001a\u00020\r*\u00020\r2\u0006\u0010C\u001a\u00020\u00062\b\b\u0002\u0010D\u001a\u00020\u0014\u001a\u001c\u0010E\u001a\u00020\u0002*\u00020\u00022\u0006\u0010C\u001a\u00020\u00062\b\b\u0002\u0010D\u001a\u00020\u0014\u001a\u001c\u0010E\u001a\u00020\r*\u00020\r2\u0006\u0010C\u001a\u00020\u00062\b\b\u0002\u0010D\u001a\u00020\u0014\u001aG\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00010=*\u00020\u00022\u000e\u0010G\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0H2\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u000b\u001a\u00020\u0006H\u0002¢\u0006\u0004\bI\u0010J\u001a=\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00010=*\u00020\u00022\u0006\u0010G\u001a\u0002022\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u000b\u001a\u00020\u0006H\u0002¢\u0006\u0002\bI\u001a4\u0010K\u001a\u00020\u0010*\u00020\u00022\u0006\u0010L\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010M\u001a\u00020\u00062\u0006\u0010C\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0000\u001a\u0012\u0010N\u001a\u00020\u0002*\u00020\u00022\u0006\u0010O\u001a\u00020\u0002\u001a\u0012\u0010N\u001a\u00020\r*\u00020\r2\u0006\u0010O\u001a\u00020\u0002\u001a\u001a\u0010P\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u0006\u001a\u0012\u0010P\u001a\u00020\u0002*\u00020\u00022\u0006\u0010Q\u001a\u00020\u0001\u001a\u001d\u0010P\u001a\u00020\r*\u00020\r2\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u0006H\u0087\b\u001a\u0015\u0010P\u001a\u00020\r*\u00020\r2\u0006\u0010Q\u001a\u00020\u0001H\u0087\b\u001a\u0012\u0010R\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002\u001a\u0012\u0010R\u001a\u00020\r*\u00020\r2\u0006\u0010\u001a\u001a\u00020\u0002\u001a\u0012\u0010S\u001a\u00020\u0002*\u00020\u00022\u0006\u0010T\u001a\u00020\u0002\u001a\u001a\u0010S\u001a\u00020\u0002*\u00020\u00022\u0006\u0010O\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002\u001a\u0012\u0010S\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\u0002\u001a\u001a\u0010S\u001a\u00020\r*\u00020\r2\u0006\u0010O\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002\u001a.\u0010U\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0014\b\b\u0010V\u001a\u000e\u0012\u0004\u0012\u00020X\u0012\u0004\u0012\u00020\u00020WH\u0087\bø\u0001\u0000\u001a\u001d\u0010U\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010Y\u001a\u00020\rH\u0087\b\u001a$\u0010Z\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\u00142\u0006\u0010Y\u001a\u00020\r2\b\b\u0002\u0010[\u001a\u00020\r\u001a$\u0010Z\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\r2\u0006\u0010Y\u001a\u00020\r2\b\b\u0002\u0010[\u001a\u00020\r\u001a$\u0010\\\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\u00142\u0006\u0010Y\u001a\u00020\r2\b\b\u0002\u0010[\u001a\u00020\r\u001a$\u0010\\\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\r2\u0006\u0010Y\u001a\u00020\r2\b\b\u0002\u0010[\u001a\u00020\r\u001a$\u0010]\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\u00142\u0006\u0010Y\u001a\u00020\r2\b\b\u0002\u0010[\u001a\u00020\r\u001a$\u0010]\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\r2\u0006\u0010Y\u001a\u00020\r2\b\b\u0002\u0010[\u001a\u00020\r\u001a$\u0010^\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\u00142\u0006\u0010Y\u001a\u00020\r2\b\b\u0002\u0010[\u001a\u00020\r\u001a$\u0010^\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\r2\u0006\u0010Y\u001a\u00020\r2\b\b\u0002\u0010[\u001a\u00020\r\u001a\u001d\u0010_\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010Y\u001a\u00020\rH\u0087\b\u001a)\u0010`\u001a\u00020\r*\u00020\r2\u0012\u0010V\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00140WH\u0087\bø\u0001\u0000¢\u0006\u0002\ba\u001a)\u0010`\u001a\u00020\r*\u00020\r2\u0012\u0010V\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00020WH\u0087\bø\u0001\u0000¢\u0006\u0002\bb\u001a\"\u0010c\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00062\u0006\u0010Y\u001a\u00020\u0002\u001a\u001a\u0010c\u001a\u00020\u0002*\u00020\u00022\u0006\u0010Q\u001a\u00020\u00012\u0006\u0010Y\u001a\u00020\u0002\u001a%\u0010c\u001a\u00020\r*\u00020\r2\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00062\u0006\u0010Y\u001a\u00020\u0002H\u0087\b\u001a\u001d\u0010c\u001a\u00020\r*\u00020\r2\u0006\u0010Q\u001a\u00020\u00012\u0006\u0010Y\u001a\u00020\u0002H\u0087\b\u001a=\u0010d\u001a\b\u0012\u0004\u0012\u00020\r0?*\u00020\u00022\u0012\u0010G\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0H\"\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u000b\u001a\u00020\u0006¢\u0006\u0002\u0010e\u001a0\u0010d\u001a\b\u0012\u0004\u0012\u00020\r0?*\u00020\u00022\n\u0010G\u001a\u000202\"\u00020\u00142\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u001a/\u0010d\u001a\b\u0012\u0004\u0012\u00020\r0?*\u00020\u00022\u0006\u0010T\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\u0006H\u0002¢\u0006\u0002\bf\u001a%\u0010d\u001a\b\u0012\u0004\u0012\u00020\r0?*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u000b\u001a\u00020\u0006H\u0087\b\u001a=\u0010g\u001a\b\u0012\u0004\u0012\u00020\r0=*\u00020\u00022\u0012\u0010G\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0H\"\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u000b\u001a\u00020\u0006¢\u0006\u0002\u0010h\u001a0\u0010g\u001a\b\u0012\u0004\u0012\u00020\r0=*\u00020\u00022\n\u0010G\u001a\u000202\"\u00020\u00142\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u001a%\u0010g\u001a\b\u0012\u0004\u0012\u00020\r0=*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u000b\u001a\u00020\u0006H\u0087\b\u001a\u001c\u0010i\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a\u001c\u0010i\u001a\u00020\u0010*\u00020\u00022\u0006\u0010O\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a$\u0010i\u001a\u00020\u0010*\u00020\u00022\u0006\u0010O\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a\u0012\u0010j\u001a\u00020\u0002*\u00020\u00022\u0006\u0010Q\u001a\u00020\u0001\u001a\u001d\u0010j\u001a\u00020\u0002*\u00020\r2\u0006\u0010k\u001a\u00020\u00062\u0006\u0010l\u001a\u00020\u0006H\u0087\b\u001a\u001f\u0010m\u001a\u00020\r*\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010-\u001a\u00020\u0006H\u0087\b\u001a\u0012\u0010m\u001a\u00020\r*\u00020\u00022\u0006\u0010Q\u001a\u00020\u0001\u001a\u0012\u0010m\u001a\u00020\r*\u00020\r2\u0006\u0010Q\u001a\u00020\u0001\u001a\u001c\u0010n\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\u00142\b\b\u0002\u0010[\u001a\u00020\r\u001a\u001c\u0010n\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\r2\b\b\u0002\u0010[\u001a\u00020\r\u001a\u001c\u0010o\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\u00142\b\b\u0002\u0010[\u001a\u00020\r\u001a\u001c\u0010o\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\r2\b\b\u0002\u0010[\u001a\u00020\r\u001a\u001c\u0010p\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\u00142\b\b\u0002\u0010[\u001a\u00020\r\u001a\u001c\u0010p\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\r2\b\b\u0002\u0010[\u001a\u00020\r\u001a\u001c\u0010q\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\u00142\b\b\u0002\u0010[\u001a\u00020\r\u001a\u001c\u0010q\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\r2\b\b\u0002\u0010[\u001a\u00020\r\u001a\f\u0010r\u001a\u00020\u0010*\u00020\rH\u0007\u001a\u0013\u0010s\u001a\u0004\u0018\u00010\u0010*\u00020\rH\u0007¢\u0006\u0002\u0010t\u001a\n\u0010u\u001a\u00020\u0002*\u00020\u0002\u001a$\u0010u\u001a\u00020\u0002*\u00020\u00022\u0012\u0010v\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00100WH\u0086\bø\u0001\u0000\u001a\u0016\u0010u\u001a\u00020\u0002*\u00020\u00022\n\u00101\u001a\u000202\"\u00020\u0014\u001a\r\u0010u\u001a\u00020\r*\u00020\rH\u0087\b\u001a$\u0010u\u001a\u00020\r*\u00020\r2\u0012\u0010v\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00100WH\u0086\bø\u0001\u0000\u001a\u0016\u0010u\u001a\u00020\r*\u00020\r2\n\u00101\u001a\u000202\"\u00020\u0014\u001a\n\u0010w\u001a\u00020\u0002*\u00020\u0002\u001a$\u0010w\u001a\u00020\u0002*\u00020\u00022\u0012\u0010v\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00100WH\u0086\bø\u0001\u0000\u001a\u0016\u0010w\u001a\u00020\u0002*\u00020\u00022\n\u00101\u001a\u000202\"\u00020\u0014\u001a\r\u0010w\u001a\u00020\r*\u00020\rH\u0087\b\u001a$\u0010w\u001a\u00020\r*\u00020\r2\u0012\u0010v\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00100WH\u0086\bø\u0001\u0000\u001a\u0016\u0010w\u001a\u00020\r*\u00020\r2\n\u00101\u001a\u000202\"\u00020\u0014\u001a\n\u0010x\u001a\u00020\u0002*\u00020\u0002\u001a$\u0010x\u001a\u00020\u0002*\u00020\u00022\u0012\u0010v\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00100WH\u0086\bø\u0001\u0000\u001a\u0016\u0010x\u001a\u00020\u0002*\u00020\u00022\n\u00101\u001a\u000202\"\u00020\u0014\u001a\r\u0010x\u001a\u00020\r*\u00020\rH\u0087\b\u001a$\u0010x\u001a\u00020\r*\u00020\r2\u0012\u0010v\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00100WH\u0086\bø\u0001\u0000\u001a\u0016\u0010x\u001a\u00020\r*\u00020\r2\n\u00101\u001a\u000202\"\u00020\u0014\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006y"}, d2 = {"indices", "Lkotlin/ranges/IntRange;", "", "getIndices", "(Ljava/lang/CharSequence;)Lkotlin/ranges/IntRange;", "lastIndex", "", "getLastIndex", "(Ljava/lang/CharSequence;)I", "requireNonNegativeLimit", "", DataUsageDetailActivity.INTENT_EXTRA_LIMIT, "commonPrefixWith", "", "other", "ignoreCase", "", "commonSuffixWith", "contains", "char", "", "regex", "Lkotlin/text/Regex;", "contentEqualsIgnoreCaseImpl", "contentEqualsImpl", "endsWith", "suffix", "findAnyOf", "Lkotlin/Pair;", "strings", "", "startIndex", "last", "findAnyOf$StringsKt__StringsKt", "findLastAnyOf", "hasSurrogatePairAt", Utils.INTENT_KEY_INDEX, "ifBlank", "R", "C", "defaultValue", "Lkotlin/Function0;", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "ifEmpty", "indexOf", "endIndex", "indexOf$StringsKt__StringsKt", "string", "indexOfAny", "chars", "", "isEmpty", "isNotBlank", "isNotEmpty", "isNullOrBlank", "isNullOrEmpty", "iterator", "Lkotlin/collections/CharIterator;", "lastIndexOf", "lastIndexOfAny", "lineSequence", "Lkotlin/sequences/Sequence;", "lines", "", "matches", "orEmpty", "padEnd", "length", "padChar", "padStart", "rangesDelimitedBy", "delimiters", "", "rangesDelimitedBy$StringsKt__StringsKt", "(Ljava/lang/CharSequence;[Ljava/lang/String;IZI)Lkotlin/sequences/Sequence;", "regionMatchesImpl", "thisOffset", "otherOffset", "removePrefix", "prefix", "removeRange", "range", "removeSuffix", "removeSurrounding", "delimiter", "replace", "transform", "Lkotlin/Function1;", "Lkotlin/text/MatchResult;", "replacement", "replaceAfter", "missingDelimiterValue", "replaceAfterLast", "replaceBefore", "replaceBeforeLast", "replaceFirst", "replaceFirstChar", "replaceFirstCharWithChar", "replaceFirstCharWithCharSequence", "replaceRange", "split", "(Ljava/lang/CharSequence;[Ljava/lang/String;ZI)Ljava/util/List;", "split$StringsKt__StringsKt", "splitToSequence", "(Ljava/lang/CharSequence;[Ljava/lang/String;ZI)Lkotlin/sequences/Sequence;", "startsWith", "subSequence", "start", TraceStatsConsts.STATS_KEY_END, "substring", "substringAfter", "substringAfterLast", "substringBefore", "substringBeforeLast", "toBooleanStrict", "toBooleanStrictOrNull", "(Ljava/lang/String;)Ljava/lang/Boolean;", "trim", "predicate", "trimEnd", "trimStart", "kotlin-stdlib"}, k = 5, mv = {1, 8, 0}, xi = 49, xs = "kotlin/text/StringsKt")
class StringsKt__StringsKt extends StringsKt__StringsJVMKt {
    public StringsKt__StringsKt() {
    }

    public static final /* synthetic */ Pair access$findAnyOf(CharSequence r0, Collection r1, int r2, boolean r3, boolean r4) {
        return findAnyOf$StringsKt__StringsKt(r0, r1, r2, r3, r4);
    }

    private static final String orEmpty(String r0) {
        if (r0 != null) goto L5;
        return "";
    L5:
        return r0;
    }

    public static final CharSequence trim(CharSequence r5, Function1<? super Character, Boolean> r6) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r6, "predicate");
        int r0 = r5.length() - 1;
        int r2 = 0;
        boolean r3 = false;
    L3:
        if (r2 > r0) goto L16;
        if (r3 == true) goto L6;
        int r4 = r2;
    L7:
        boolean r7 = r6.invoke(Character.valueOf(r5.charAt(r4))).booleanValue();
        if (r3 == false) goto L9;
        if (r7 == false) goto L16;
        r0 = r0 - 1;
        goto L3
    L9:
        if (r7 == false) goto L10;
        r2 = r2 + 1;
        goto L3
    L10:
        r3 = true;
        goto L3
    L6:
        r4 = r0;
    L16:
        return r5.subSequence(r2, r0 + 1);
    }

    public static final String trim(String r5, Function1<? super Character, Boolean> r6) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r6, "predicate");
        String r7 = r5;
        int r0 = r7.length() - 1;
        int r2 = 0;
        boolean r3 = false;
    L3:
        if (r2 > r0) goto L16;
        if (r3 == true) goto L6;
        int r4 = r2;
    L7:
        boolean r8 = r6.invoke(Character.valueOf(r7.charAt(r4))).booleanValue();
        if (r3 == false) goto L9;
        if (r8 == false) goto L16;
        r0 = r0 - 1;
        goto L3
    L9:
        if (r8 == false) goto L10;
        r2 = r2 + 1;
        goto L3
    L10:
        r3 = true;
        goto L3
    L6:
        r4 = r0;
    L16:
        return r7.subSequence(r2, r0 + 1).toString();
    }

    public static final CharSequence trimStart(CharSequence r3, Function1<? super Character, Boolean> r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "predicate");
        int r0 = r3.length();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L10;
        if (r4.invoke(Character.valueOf(r3.charAt(r1))).booleanValue() == false) goto L7;
        r1 = r1 + 1;
        goto L3
    L7:
        return r3.subSequence(r1, r3.length());
    L10:
        return "";
    }

    public static final String trimStart(String r3, Function1<? super Character, Boolean> r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "predicate");
        String r5 = r3;
        int r0 = r5.length();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        if (r4.invoke(Character.valueOf(r5.charAt(r1))).booleanValue() == false) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        String r6 = r5.subSequence(r1, r5.length());
    L10:
        return r6.toString();
    L8:
        goto L10
    }

    public static final CharSequence trimEnd(CharSequence r3, Function1<? super Character, Boolean> r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "predicate");
        int r0 = r3.length() - 1;
        if (r0 < 0) goto L12;
    L4:
        int r1 = r0 - 1;
        if (r4.invoke(Character.valueOf(r3.charAt(r0))).booleanValue() == false) goto L7;
        if (r1 < 0) goto L12;
        r0 = r1;
        goto L4
    L7:
        return r3.subSequence(0, r0 + 1);
    L12:
        return "";
    }

    public static final String trimEnd(String r3, Function1<? super Character, Boolean> r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "predicate");
        String r5 = r3;
        int r0 = r5.length() - 1;
        if (r0 < 0) goto L10;
    L4:
        int r1 = r0 - 1;
        if (r4.invoke(Character.valueOf(r5.charAt(r0))).booleanValue() == false) goto L6;
        if (r1 < 0) goto L10;
        r0 = r1;
        goto L4
    L6:
        String r6 = r5.subSequence(0, r0 + 1);
    L12:
        return r6.toString();
    L10:
        goto L12
    }

    private static final String trim(String r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return StringsKt.trim(r1).toString();
    }

    private static final String trimStart(String r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return StringsKt.trimStart(r1).toString();
    }

    private static final String trimEnd(String r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return StringsKt.trimEnd(r1).toString();
    }

    public static /* synthetic */ CharSequence padStart$default(CharSequence r0, int r1, char r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = ' ';
    L6:
        return StringsKt.padStart(r0, r1, r2);
    }

    /* JADX WARN: Type inference failed for: r4v5, types: [kotlin.collections.IntIterator] */
    public static final CharSequence padStart(CharSequence r3, int r4, char r5) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        if (r4 < 0) goto L15;
        if (r4 <= r3.length()) goto L7;
        StringBuilder r0 = new StringBuilder(r4);
        ?? r6 = new IntRange(1, r4 - r3.length()).iterator();
    L10:
        if (r6.hasNext() == false) goto L12;
        r6.nextInt();
        r0.append(r5);
        goto L10
    L12:
        r0.append(r3);
        return r0;
    L7:
        return r3.subSequence(0, r3.length());
    L15:
        throw new IllegalArgumentException("Desired length " + r4 + " is less than zero.");
    }

    public static /* synthetic */ String padStart$default(String r0, int r1, char r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = ' ';
    L6:
        return StringsKt.padStart(r0, r1, r2);
    }

    public static final String padStart(String r1, int r2, char r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return StringsKt.padStart(r1, r2, r3).toString();
    }

    public static /* synthetic */ CharSequence padEnd$default(CharSequence r0, int r1, char r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = ' ';
    L6:
        return StringsKt.padEnd(r0, r1, r2);
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [kotlin.collections.IntIterator] */
    public static final CharSequence padEnd(CharSequence r2, int r3, char r4) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (r3 < 0) goto L15;
        if (r3 <= r2.length()) goto L7;
        StringBuilder r0 = new StringBuilder(r3);
        r0.append(r2);
        ?? r5 = new IntRange(1, r3 - r2.length()).iterator();
    L10:
        if (r5.hasNext() == false) goto L13;
        r5.nextInt();
        r0.append(r4);
        goto L10
    L13:
        return r0;
    L7:
        return r2.subSequence(0, r2.length());
    L15:
        throw new IllegalArgumentException("Desired length " + r3 + " is less than zero.");
    }

    public static /* synthetic */ String padEnd$default(String r0, int r1, char r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = ' ';
    L6:
        return StringsKt.padEnd(r0, r1, r2);
    }

    public static final String padEnd(String r1, int r2, char r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return StringsKt.padEnd(r1, r2, r3).toString();
    }

    private static final boolean isNullOrEmpty(CharSequence r0) {
        if (r0 != null) goto L4;
    L7:
        return true;
    L4:
        if (r0.length() == 0) goto L7;
        return false;
    }

    private static final boolean isEmpty(CharSequence r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r1.length() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    private static final boolean isNotEmpty(CharSequence r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r1.length() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    private static final boolean isNotBlank(CharSequence r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return !StringsKt.isBlank(r1);
    }

    private static final boolean isNullOrBlank(CharSequence r0) {
        if (r0 != null) goto L4;
    L7:
        return true;
    L4:
        if (StringsKt.isBlank(r0) == true) goto L7;
        return false;
    }

    public static final CharIterator iterator(final CharSequence r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return new AnonymousClass1(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <C extends CharSequence & R, R> R ifEmpty(C r1, Function0<? extends R> r2) {
        Intrinsics.checkNotNullParameter(r2, "defaultValue");
        if (r1.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        return r1;
    L8:
        return r2.invoke();
    L5:
        r0 = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <C extends CharSequence & R, R> R ifBlank(C r1, Function0<? extends R> r2) {
        Intrinsics.checkNotNullParameter(r2, "defaultValue");
        if (StringsKt.isBlank(r1) == true) goto L5;
        return r1;
    L5:
        return r2.invoke();
    }

    public static final IntRange getIndices(CharSequence r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return new IntRange(0, r2.length() - 1);
    }

    public static final int getLastIndex(CharSequence r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return r1.length() - 1;
    }

    public static final boolean hasSurrogatePairAt(CharSequence r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        if (new IntRange(0, r3.length() - 2).contains(r4) == true) goto L5;
        return false;
    L5:
        if (Character.isHighSurrogate(r3.charAt(r4)) == true) goto L7;
        return false;
    L7:
        if (Character.isLowSurrogate(r3.charAt(r4 + 1)) == true) goto L9;
        return false;
    L9:
        return true;
    }

    public static final String substring(String r1, IntRange r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "range");
        String r3 = r1.substring(r2.getStart().intValue(), r2.getEndInclusive().intValue() + 1);
        Intrinsics.checkNotNullExpressionValue(r3, "this as java.lang.String…ing(startIndex, endIndex)");
        return r3;
    }

    public static final CharSequence subSequence(CharSequence r1, IntRange r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "range");
        return r1.subSequence(r2.getStart().intValue(), r2.getEndInclusive().intValue() + 1);
    }

    @Deprecated(message = "Use parameters named startIndex and endIndex.", replaceWith = @ReplaceWith(expression = "subSequence(startIndex = start, endIndex = end)", imports = {}))
    private static final CharSequence subSequence(String r1, int r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return r1.subSequence(r2, r3);
    }

    private static final String substring(CharSequence r1, int r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return r1.subSequence(r2, r3).toString();
    }

    static /* synthetic */ String substring$default(CharSequence r0, int r1, int r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = r0.length();
    L5:
        Intrinsics.checkNotNullParameter(r0, "<this>");
        return r0.subSequence(r1, r2).toString();
    }

    public static final String substring(CharSequence r1, IntRange r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "range");
        return r1.subSequence(r2.getStart().intValue(), r2.getEndInclusive().intValue() + 1).toString();
    }

    public static /* synthetic */ String substringBefore$default(String r0, char r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = r0;
    L6:
        return StringsKt.substringBefore(r0, r1, r2);
    }

    public static final String substringBefore(String r7, char r8, String r9) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r9, "missingDelimiterValue");
        int r10 = StringsKt.indexOf$default(r7, r8, 0, false, 6, null);
        if (r10 == (-1)) goto L7;
        String r11 = r7.substring(0, r10);
        Intrinsics.checkNotNullExpressionValue(r11, "this as java.lang.String…ing(startIndex, endIndex)");
        return r11;
    L7:
        return r9;
    }

    public static /* synthetic */ String substringBefore$default(String r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = r0;
    L6:
        return StringsKt.substringBefore(r0, r1, r2);
    }

    public static final String substringBefore(String r7, String r8, String r9) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r8, "delimiter");
        Intrinsics.checkNotNullParameter(r9, "missingDelimiterValue");
        int r10 = StringsKt.indexOf$default(r7, r8, 0, false, 6, null);
        if (r10 == (-1)) goto L7;
        String r11 = r7.substring(0, r10);
        Intrinsics.checkNotNullExpressionValue(r11, "this as java.lang.String…ing(startIndex, endIndex)");
        return r11;
    L7:
        return r9;
    }

    public static /* synthetic */ String substringAfter$default(String r0, char r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = r0;
    L6:
        return StringsKt.substringAfter(r0, r1, r2);
    }

    public static final String substringAfter(String r7, char r8, String r9) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r9, "missingDelimiterValue");
        int r10 = StringsKt.indexOf$default(r7, r8, 0, false, 6, null);
        if (r10 == (-1)) goto L7;
        String r11 = r7.substring(r10 + 1, r7.length());
        Intrinsics.checkNotNullExpressionValue(r11, "this as java.lang.String…ing(startIndex, endIndex)");
        return r11;
    L7:
        return r9;
    }

    public static /* synthetic */ String substringAfter$default(String r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = r0;
    L6:
        return StringsKt.substringAfter(r0, r1, r2);
    }

    public static final String substringAfter(String r7, String r8, String r9) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r8, "delimiter");
        Intrinsics.checkNotNullParameter(r9, "missingDelimiterValue");
        int r0 = StringsKt.indexOf$default(r7, r8, 0, false, 6, null);
        if (r0 == (-1)) goto L7;
        String r10 = r7.substring(r0 + r8.length(), r7.length());
        Intrinsics.checkNotNullExpressionValue(r10, "this as java.lang.String…ing(startIndex, endIndex)");
        return r10;
    L7:
        return r9;
    }

    public static /* synthetic */ String substringBeforeLast$default(String r0, char r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = r0;
    L6:
        return StringsKt.substringBeforeLast(r0, r1, r2);
    }

    public static final String substringBeforeLast(String r7, char r8, String r9) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r9, "missingDelimiterValue");
        int r10 = StringsKt.lastIndexOf$default(r7, r8, 0, false, 6, null);
        if (r10 == (-1)) goto L7;
        String r11 = r7.substring(0, r10);
        Intrinsics.checkNotNullExpressionValue(r11, "this as java.lang.String…ing(startIndex, endIndex)");
        return r11;
    L7:
        return r9;
    }

    public static /* synthetic */ String substringBeforeLast$default(String r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = r0;
    L6:
        return StringsKt.substringBeforeLast(r0, r1, r2);
    }

    public static final String substringBeforeLast(String r7, String r8, String r9) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r8, "delimiter");
        Intrinsics.checkNotNullParameter(r9, "missingDelimiterValue");
        int r10 = StringsKt.lastIndexOf$default(r7, r8, 0, false, 6, null);
        if (r10 == (-1)) goto L7;
        String r11 = r7.substring(0, r10);
        Intrinsics.checkNotNullExpressionValue(r11, "this as java.lang.String…ing(startIndex, endIndex)");
        return r11;
    L7:
        return r9;
    }

    public static /* synthetic */ String substringAfterLast$default(String r0, char r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = r0;
    L6:
        return StringsKt.substringAfterLast(r0, r1, r2);
    }

    public static final String substringAfterLast(String r7, char r8, String r9) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r9, "missingDelimiterValue");
        int r10 = StringsKt.lastIndexOf$default(r7, r8, 0, false, 6, null);
        if (r10 == (-1)) goto L7;
        String r11 = r7.substring(r10 + 1, r7.length());
        Intrinsics.checkNotNullExpressionValue(r11, "this as java.lang.String…ing(startIndex, endIndex)");
        return r11;
    L7:
        return r9;
    }

    public static /* synthetic */ String substringAfterLast$default(String r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = r0;
    L6:
        return StringsKt.substringAfterLast(r0, r1, r2);
    }

    public static final String substringAfterLast(String r7, String r8, String r9) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r8, "delimiter");
        Intrinsics.checkNotNullParameter(r9, "missingDelimiterValue");
        int r0 = StringsKt.lastIndexOf$default(r7, r8, 0, false, 6, null);
        if (r0 == (-1)) goto L7;
        String r10 = r7.substring(r0 + r8.length(), r7.length());
        Intrinsics.checkNotNullExpressionValue(r10, "this as java.lang.String…ing(startIndex, endIndex)");
        return r10;
    L7:
        return r9;
    }

    public static final CharSequence replaceRange(CharSequence r2, int r3, int r4, CharSequence r5) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r5, "replacement");
        if (r4 < r3) goto L7;
        StringBuilder r0 = new StringBuilder();
        Intrinsics.checkNotNullExpressionValue(r0.append(r2, 0, r3), "this.append(value, startIndex, endIndex)");
        r0.append(r5);
        Intrinsics.checkNotNullExpressionValue(r0.append(r2, r4, r2.length()), "this.append(value, startIndex, endIndex)");
        return r0;
    L7:
        throw new IndexOutOfBoundsException("End index (" + r4 + ") is less than start index (" + r3 + ").");
    }

    private static final String replaceRange(String r1, int r2, int r3, CharSequence r4) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r4, "replacement");
        return StringsKt.replaceRange(r1, r2, r3, r4).toString();
    }

    public static final CharSequence replaceRange(CharSequence r1, IntRange r2, CharSequence r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "range");
        Intrinsics.checkNotNullParameter(r3, "replacement");
        return StringsKt.replaceRange(r1, r2.getStart().intValue(), r2.getEndInclusive().intValue() + 1, r3);
    }

    private static final String replaceRange(String r1, IntRange r2, CharSequence r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "range");
        Intrinsics.checkNotNullParameter(r3, "replacement");
        return StringsKt.replaceRange(r1, r2, r3).toString();
    }

    public static final CharSequence removeRange(CharSequence r4, int r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        if (r6 < r5) goto L11;
        if (r6 == r5) goto L7;
        StringBuilder r1 = new StringBuilder(r4.length() - (r6 - r5));
        Intrinsics.checkNotNullExpressionValue(r1.append(r4, 0, r5), "this.append(value, startIndex, endIndex)");
        Intrinsics.checkNotNullExpressionValue(r1.append(r4, r6, r4.length()), "this.append(value, startIndex, endIndex)");
        return r1;
    L7:
        return r4.subSequence(0, r4.length());
    L11:
        throw new IndexOutOfBoundsException("End index (" + r6 + ") is less than start index (" + r5 + ").");
    }

    private static final String removeRange(String r1, int r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return StringsKt.removeRange(r1, r2, r3).toString();
    }

    public static final CharSequence removeRange(CharSequence r1, IntRange r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "range");
        return StringsKt.removeRange(r1, r2.getStart().intValue(), r2.getEndInclusive().intValue() + 1);
    }

    private static final String removeRange(String r1, IntRange r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "range");
        return StringsKt.removeRange(r1, r2).toString();
    }

    public static final CharSequence removePrefix(CharSequence r3, CharSequence r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "prefix");
        if (StringsKt.startsWith$default(r3, r4, false, 2, null) == false) goto L7;
        return r3.subSequence(r4.length(), r3.length());
    L7:
        return r3.subSequence(0, r3.length());
    }

    public static final String removePrefix(String r4, CharSequence r5) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, "prefix");
        if (StringsKt.startsWith$default(r4, r5, false, 2, null) == false) goto L6;
        String r6 = r4.substring(r5.length());
        Intrinsics.checkNotNullExpressionValue(r6, "this as java.lang.String).substring(startIndex)");
        return r6;
    L6:
        return r4;
    }

    public static final CharSequence removeSuffix(CharSequence r3, CharSequence r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "suffix");
        if (StringsKt.endsWith$default(r3, r4, false, 2, null) == false) goto L7;
        return r3.subSequence(0, r3.length() - r4.length());
    L7:
        return r3.subSequence(0, r3.length());
    }

    public static final String removeSuffix(String r4, CharSequence r5) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, "suffix");
        if (StringsKt.endsWith$default(r4, r5, false, 2, null) == false) goto L6;
        String r6 = r4.substring(0, r4.length() - r5.length());
        Intrinsics.checkNotNullExpressionValue(r6, "this as java.lang.String…ing(startIndex, endIndex)");
        return r6;
    L6:
        return r4;
    }

    public static final CharSequence removeSurrounding(CharSequence r4, CharSequence r5, CharSequence r6) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, "prefix");
        Intrinsics.checkNotNullParameter(r6, "suffix");
        if (r4.length() < (r5.length() + r6.length())) goto L11;
        if (StringsKt.startsWith$default(r4, r5, false, 2, null) == false) goto L11;
        if (StringsKt.endsWith$default(r4, r6, false, 2, null) == false) goto L11;
        return r4.subSequence(r5.length(), r4.length() - r6.length());
    L11:
        return r4.subSequence(0, r4.length());
    }

    public static final String removeSurrounding(String r5, CharSequence r6, CharSequence r7) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r6, "prefix");
        Intrinsics.checkNotNullParameter(r7, "suffix");
        if (r5.length() < (r6.length() + r7.length())) goto L10;
        String r0 = r5;
        if (StringsKt.startsWith$default(r0, r6, false, 2, null) == true) goto L7;
        return r5;
    L7:
        if (StringsKt.endsWith$default(r0, r7, false, 2, null) == false) goto L12;
        String r8 = r5.substring(r6.length(), r5.length() - r7.length());
        Intrinsics.checkNotNullExpressionValue(r8, "this as java.lang.String…ing(startIndex, endIndex)");
        return r8;
    L12:
        return r5;
    L10:
        return r5;
    }

    public static final CharSequence removeSurrounding(CharSequence r1, CharSequence r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "delimiter");
        return StringsKt.removeSurrounding(r1, r2, r2);
    }

    public static final String removeSurrounding(String r1, CharSequence r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "delimiter");
        return StringsKt.removeSurrounding(r1, r2, r2);
    }

    public static /* synthetic */ String replaceBefore$default(String r0, char r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r3 = r0;
    L6:
        return StringsKt.replaceBefore(r0, r1, r2, r3);
    }

    public static final String replaceBefore(String r7, char r8, String r9, String r10) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r9, "replacement");
        Intrinsics.checkNotNullParameter(r10, "missingDelimiterValue");
        String r11 = r7;
        int r12 = StringsKt.indexOf$default(r11, r8, 0, false, 6, null);
        if (r12 != (-1)) goto L6;
        return r10;
    L6:
        return StringsKt.replaceRange(r11, 0, r12, r9).toString();
    }

    public static /* synthetic */ String replaceBefore$default(String r0, String r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r3 = r0;
    L6:
        return StringsKt.replaceBefore(r0, r1, r2, r3);
    }

    public static final String replaceBefore(String r7, String r8, String r9, String r10) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r8, "delimiter");
        Intrinsics.checkNotNullParameter(r9, "replacement");
        Intrinsics.checkNotNullParameter(r10, "missingDelimiterValue");
        String r11 = r7;
        int r12 = StringsKt.indexOf$default(r11, r8, 0, false, 6, null);
        if (r12 != (-1)) goto L6;
        return r10;
    L6:
        return StringsKt.replaceRange(r11, 0, r12, r9).toString();
    }

    public static /* synthetic */ String replaceAfter$default(String r0, char r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r3 = r0;
    L6:
        return StringsKt.replaceAfter(r0, r1, r2, r3);
    }

    public static final String replaceAfter(String r7, char r8, String r9, String r10) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r9, "replacement");
        Intrinsics.checkNotNullParameter(r10, "missingDelimiterValue");
        String r0 = r7;
        int r11 = StringsKt.indexOf$default(r0, r8, 0, false, 6, null);
        if (r11 != (-1)) goto L6;
        return r10;
    L6:
        return StringsKt.replaceRange(r0, r11 + 1, r7.length(), r9).toString();
    }

    public static /* synthetic */ String replaceAfter$default(String r0, String r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r3 = r0;
    L6:
        return StringsKt.replaceAfter(r0, r1, r2, r3);
    }

    public static final String replaceAfter(String r7, String r8, String r9, String r10) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r8, "delimiter");
        Intrinsics.checkNotNullParameter(r9, "replacement");
        Intrinsics.checkNotNullParameter(r10, "missingDelimiterValue");
        String r0 = r7;
        int r1 = StringsKt.indexOf$default(r0, r8, 0, false, 6, null);
        if (r1 != (-1)) goto L6;
        return r10;
    L6:
        return StringsKt.replaceRange(r0, r1 + r8.length(), r7.length(), r9).toString();
    }

    public static /* synthetic */ String replaceAfterLast$default(String r0, String r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r3 = r0;
    L6:
        return StringsKt.replaceAfterLast(r0, r1, r2, r3);
    }

    public static final String replaceAfterLast(String r7, String r8, String r9, String r10) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r8, "delimiter");
        Intrinsics.checkNotNullParameter(r9, "replacement");
        Intrinsics.checkNotNullParameter(r10, "missingDelimiterValue");
        String r0 = r7;
        int r1 = StringsKt.lastIndexOf$default(r0, r8, 0, false, 6, null);
        if (r1 != (-1)) goto L6;
        return r10;
    L6:
        return StringsKt.replaceRange(r0, r1 + r8.length(), r7.length(), r9).toString();
    }

    public static /* synthetic */ String replaceAfterLast$default(String r0, char r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r3 = r0;
    L6:
        return StringsKt.replaceAfterLast(r0, r1, r2, r3);
    }

    public static final String replaceAfterLast(String r7, char r8, String r9, String r10) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r9, "replacement");
        Intrinsics.checkNotNullParameter(r10, "missingDelimiterValue");
        String r0 = r7;
        int r11 = StringsKt.lastIndexOf$default(r0, r8, 0, false, 6, null);
        if (r11 != (-1)) goto L6;
        return r10;
    L6:
        return StringsKt.replaceRange(r0, r11 + 1, r7.length(), r9).toString();
    }

    public static /* synthetic */ String replaceBeforeLast$default(String r0, char r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r3 = r0;
    L6:
        return StringsKt.replaceBeforeLast(r0, r1, r2, r3);
    }

    public static final String replaceBeforeLast(String r7, char r8, String r9, String r10) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r9, "replacement");
        Intrinsics.checkNotNullParameter(r10, "missingDelimiterValue");
        String r11 = r7;
        int r12 = StringsKt.lastIndexOf$default(r11, r8, 0, false, 6, null);
        if (r12 != (-1)) goto L6;
        return r10;
    L6:
        return StringsKt.replaceRange(r11, 0, r12, r9).toString();
    }

    public static /* synthetic */ String replaceBeforeLast$default(String r0, String r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r3 = r0;
    L6:
        return StringsKt.replaceBeforeLast(r0, r1, r2, r3);
    }

    public static final String replaceBeforeLast(String r7, String r8, String r9, String r10) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r8, "delimiter");
        Intrinsics.checkNotNullParameter(r9, "replacement");
        Intrinsics.checkNotNullParameter(r10, "missingDelimiterValue");
        String r11 = r7;
        int r12 = StringsKt.lastIndexOf$default(r11, r8, 0, false, 6, null);
        if (r12 != (-1)) goto L6;
        return r10;
    L6:
        return StringsKt.replaceRange(r11, 0, r12, r9).toString();
    }

    private static final String replace(CharSequence r1, Regex r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "regex");
        Intrinsics.checkNotNullParameter(r3, "replacement");
        return r2.replace(r1, r3);
    }

    private static final String replace(CharSequence r1, Regex r2, Function1<? super MatchResult, ? extends CharSequence> r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "regex");
        Intrinsics.checkNotNullParameter(r3, "transform");
        return r2.replace(r1, r3);
    }

    private static final String replaceFirst(CharSequence r1, Regex r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "regex");
        Intrinsics.checkNotNullParameter(r3, "replacement");
        return r2.replaceFirst(r1, r3);
    }

    private static final String replaceFirstCharWithChar(String r3, Function1<? super Character, Character> r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "transform");
        if (r3.length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        char r5 = r4.invoke(Character.valueOf(r3.charAt(0))).charValue();
        String r6 = r3.substring(1);
        Intrinsics.checkNotNullExpressionValue(r6, "this as java.lang.String).substring(startIndex)");
        return r5 + r6;
    L9:
        return r3;
    L5:
        r0 = false;
        goto L6
    }

    private static final String replaceFirstCharWithCharSequence(String r3, Function1<? super Character, ? extends CharSequence> r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "transform");
        if (r3.length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        StringBuilder r5 = new StringBuilder().append(r4.invoke(Character.valueOf(r3.charAt(0))));
        String r6 = r3.substring(1);
        Intrinsics.checkNotNullExpressionValue(r6, "this as java.lang.String).substring(startIndex)");
        return r5.append(r6).toString();
    L9:
        return r3;
    L5:
        r0 = false;
        goto L6
    }

    private static final boolean matches(CharSequence r1, Regex r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "regex");
        return r2.matches(r1);
    }

    public static final boolean regionMatchesImpl(CharSequence r4, int r5, CharSequence r6, int r7, int r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r6, "other");
        if (r7 < 0) goto L18;
        if (r5 < 0) goto L18;
        if (r5 > (r4.length() - r8)) goto L18;
        if (r7 > (r6.length() - r8)) goto L18;
        int r1 = 0;
    L11:
        if (r1 >= r8) goto L16;
        if (CharsKt.equals(r4.charAt(r5 + r1), r6.charAt(r7 + r1), r9) == false) goto L14;
        r1 = r1 + 1;
        goto L11
    L14:
        return false;
    L16:
        return true;
    L18:
        return false;
    }

    public static /* synthetic */ boolean startsWith$default(CharSequence r0, char r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = false;
    L6:
        return StringsKt.startsWith(r0, r1, r2);
    }

    public static final boolean startsWith(CharSequence r2, char r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (r2.length() > 0) goto L5;
        return false;
    L5:
        if (CharsKt.equals(r2.charAt(0), r3, r4) == false) goto L9;
        return true;
    L9:
        return false;
    }

    public static /* synthetic */ boolean endsWith$default(CharSequence r0, char r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = false;
    L6:
        return StringsKt.endsWith(r0, r1, r2);
    }

    public static final boolean endsWith(CharSequence r1, char r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r1.length() > 0) goto L5;
    L7:
        return false;
    L5:
        if (CharsKt.equals(r1.charAt(StringsKt.getLastIndex(r1)), r2, r3) == false) goto L7;
        return true;
    }

    public static /* synthetic */ boolean startsWith$default(CharSequence r0, CharSequence r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = false;
    L6:
        return StringsKt.startsWith(r0, r1, r2);
    }

    public static final boolean startsWith(CharSequence r6, CharSequence r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r7, "prefix");
        if (r8 == true) goto L11;
        if ((r6 instanceof String) == false) goto L11;
        if ((r7 instanceof String) == false) goto L11;
        return StringsKt.startsWith$default((String) r6, (String) r7, false, 2, null);
    L11:
        return StringsKt.regionMatchesImpl(r6, 0, r7, 0, r7.length(), r8);
    }

    public static /* synthetic */ boolean startsWith$default(CharSequence r0, CharSequence r1, int r2, boolean r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r3 = false;
    L6:
        return StringsKt.startsWith(r0, r1, r2, r3);
    }

    public static final boolean startsWith(CharSequence r7, CharSequence r8, int r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r8, "prefix");
        if (r10 == true) goto L11;
        if ((r7 instanceof String) == false) goto L11;
        if ((r8 instanceof String) == false) goto L11;
        return StringsKt.startsWith$default((String) r7, (String) r8, r9, false, 4, null);
    L11:
        return StringsKt.regionMatchesImpl(r7, r9, r8, 0, r8.length(), r10);
    }

    public static /* synthetic */ boolean endsWith$default(CharSequence r0, CharSequence r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = false;
    L6:
        return StringsKt.endsWith(r0, r1, r2);
    }

    public static final boolean endsWith(CharSequence r8, CharSequence r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r8, "<this>");
        Intrinsics.checkNotNullParameter(r9, "suffix");
        if (r10 == true) goto L11;
        if ((r8 instanceof String) == false) goto L11;
        if ((r9 instanceof String) == false) goto L11;
        return StringsKt.endsWith$default((String) r8, (String) r9, false, 2, null);
    L11:
        return StringsKt.regionMatchesImpl(r8, r8.length() - r9.length(), r9, 0, r9.length(), r10);
    }

    public static /* synthetic */ String commonPrefixWith$default(CharSequence r0, CharSequence r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = false;
    L6:
        return StringsKt.commonPrefixWith(r0, r1, r2);
    }

    public static final String commonPrefixWith(CharSequence r5, CharSequence r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r6, "other");
        int r0 = Math.min(r5.length(), r6.length());
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L7;
        if (CharsKt.equals(r5.charAt(r2), r6.charAt(r2), r7) == false) goto L7;
        r2 = r2 + 1;
    L7:
        int r8 = r2 - 1;
        if (StringsKt.hasSurrogatePairAt(r5, r8) == false) goto L10;
    L11:
        r2 = r2 - 1;
    L13:
        return r5.subSequence(0, r2).toString();
    L10:
        if (StringsKt.hasSurrogatePairAt(r6, r8) == false) goto L13;
        goto L11
    }

    public static /* synthetic */ String commonSuffixWith$default(CharSequence r0, CharSequence r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = false;
    L6:
        return StringsKt.commonSuffixWith(r0, r1, r2);
    }

    public static final String commonSuffixWith(CharSequence r6, CharSequence r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r7, "other");
        int r0 = r6.length();
        int r1 = r7.length();
        int r2 = Math.min(r0, r1);
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L8;
        if (CharsKt.equals(r6.charAt((r0 - r3) - 1), r7.charAt((r1 - r3) - 1), r8) == false) goto L8;
        r3 = r3 + 1;
    L8:
        if (StringsKt.hasSurrogatePairAt(r6, (r0 - r3) - 1) == false) goto L10;
    L11:
        r3 = r3 - 1;
    L13:
        return r6.subSequence(r0 - r3, r0).toString();
    L10:
        if (StringsKt.hasSurrogatePairAt(r7, (r1 - r3) - 1) == false) goto L13;
        goto L11
    }

    public static /* synthetic */ int indexOfAny$default(CharSequence r1, char[] r2, int r3, boolean r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r3 = 0;
    L6:
        if ((r5 & 4) == 0) goto L9;
        r4 = false;
    L9:
        return StringsKt.indexOfAny(r1, r2, r3, r4);
    }

    /* JADX WARN: Type inference failed for: r9v2, types: [kotlin.collections.IntIterator] */
    public static final int indexOfAny(CharSequence r7, char[] r8, int r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r8, "chars");
        if (r10 == false) goto L5;
    L10:
        ?? r11 = new IntRange(RangesKt.coerceAtLeast(r9, 0), StringsKt.getLastIndex(r7)).iterator();
    L12:
        if (r11.hasNext() == false) goto L22;
        int r1 = r11.nextInt();
        char r3 = r7.charAt(r1);
        int r4 = r8.length;
        int r5 = 0;
    L14:
        if (r5 >= r4) goto L19;
        if (CharsKt.equals(r8[r5], r3, r10) == true) goto L17;
        r5 = r5 + 1;
        goto L14
    L17:
        boolean r6 = true;
    L20:
        if (r6 == false) goto L12;
        return r1;
    L19:
        r6 = false;
        goto L20
    L22:
        return -1;
    L5:
        if (r8.length != 1) goto L10;
        if ((r7 instanceof String) == false) goto L10;
        return ((String) r7).indexOf(ArraysKt.single(r8), r9);
    }

    public static /* synthetic */ int lastIndexOfAny$default(CharSequence r0, char[] r1, int r2, boolean r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = StringsKt.getLastIndex(r0);
    L6:
        if ((r4 & 4) == 0) goto L9;
        r3 = false;
    L9:
        return StringsKt.lastIndexOfAny(r0, r1, r2, r3);
    }

    public static final int lastIndexOfAny(CharSequence r6, char[] r7, int r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r7, "chars");
        if (r9 == false) goto L5;
    L10:
        int r10 = RangesKt.coerceAtMost(r8, StringsKt.getLastIndex(r6));
    L12:
        if ((-1) >= r10) goto L22;
        char r1 = r6.charAt(r10);
        int r2 = r7.length;
        boolean r3 = false;
        int r4 = 0;
    L14:
        if (r4 >= r2) goto L19;
        if (CharsKt.equals(r7[r4], r1, r9) == true) goto L17;
        r4 = r4 + 1;
        goto L14
    L17:
        r3 = true;
    L19:
        if (r3 == true) goto L20;
        r10 = r10 - 1;
        goto L12
    L20:
        return r10;
    L22:
        return -1;
    L5:
        if (r7.length != 1) goto L10;
        if ((r6 instanceof String) == false) goto L10;
        return ((String) r6).lastIndexOf(ArraysKt.single(r7), r8);
    }

    static /* synthetic */ int indexOf$StringsKt__StringsKt$default(CharSequence r6, CharSequence r7, int r8, int r9, boolean r10, boolean r11, int r12, Object r13) {
        if ((r12 & 16) == 0) goto L6;
        r11 = false;
    L6:
        return indexOf$StringsKt__StringsKt(r6, r7, r8, r9, r10, r11);
    }

    private static final int indexOf$StringsKt__StringsKt(CharSequence r6, CharSequence r7, int r8, int r9, boolean r10, boolean r11) {
        if (r11 == true) goto L5;
        IntRange r12 = new IntRange(RangesKt.coerceAtLeast(r8, 0), RangesKt.coerceAtMost(r9, r6.length()));
    L7:
        if ((r6 instanceof String) == true) goto L9;
    L20:
        int r13 = r12.getFirst();
        int r14 = r12.getLast();
        int r15 = r12.getStep();
        if (r15 <= 0) goto L23;
        if (r13 > r14) goto L23;
    L25:
        int r3 = r13;
        if (StringsKt.regionMatchesImpl(r7, 0, r6, r3, r7.length(), r10) == true) goto L27;
        if (r13 == r14) goto L42;
        r13 = r13 + r15;
        goto L25
    L42:
        return -1;
    L27:
        return r13;
    L23:
        if (r15 >= 0) goto L39;
        if (r14 <= r13) goto L25;
        return -1;
    L39:
        return -1;
    L9:
        if ((r7 instanceof String) == false) goto L20;
        int r16 = r12.getFirst();
        int r17 = r12.getLast();
        int r18 = r12.getStep();
        if (r18 <= 0) goto L13;
        if (r16 > r17) goto L13;
    L15:
        int r4 = r16;
        if (StringsKt.regionMatches((String) r7, 0, (String) r6, r4, r7.length(), r10) == true) goto L17;
        if (r16 == r17) goto L41;
        r16 = r16 + r18;
        goto L15
    L41:
        return -1;
    L17:
        return r16;
    L13:
        if (r18 >= 0) goto L30;
        if (r17 <= r16) goto L15;
        return -1;
    L30:
        return -1;
    L5:
        r12 = RangesKt.downTo(RangesKt.coerceAtMost(r8, StringsKt.getLastIndex(r6)), RangesKt.coerceAtLeast(r9, 0));
        goto L7
    }

    private static final Pair<Integer, String> findAnyOf$StringsKt__StringsKt(CharSequence r10, Collection<String> r11, int r12, boolean r13, boolean r14) {
        if (r13 == true) goto L15;
        if (r11.size() != 1) goto L15;
        String r15 = (String) CollectionsKt.single(r11);
        if (r14 == true) goto L9;
        int r16 = StringsKt.indexOf$default(r10, r15, r12, false, 4, null);
    L10:
        if (r16 >= 0) goto L13;
        return null;
    L13:
        return TuplesKt.to(Integer.valueOf(r16), r15);
    L9:
        r16 = StringsKt.lastIndexOf$default(r10, r15, r12, false, 4, null);
    L15:
        if (r14 == true) goto L17;
        IntRange r17 = new IntRange(RangesKt.coerceAtLeast(r12, 0), r10.length());
    L19:
        if ((r10 instanceof String) == false) goto L38;
        int r18 = r17.getFirst();
        int r1 = r17.getLast();
        int r19 = r17.getStep();
        if (r19 <= 0) goto L23;
        if (r18 > r1) goto L23;
    L25:
        Iterator<T> r8 = r11.iterator();
    L27:
        if (r8.hasNext() == false) goto L31;
        Object r9 = r8.next();
        String r2 = (String) r9;
        if (StringsKt.regionMatches(r2, 0, (String) r10, r18, r2.length(), r13) == false) goto L27;
    L32:
        String r20 = (String) r9;
        if (r20 != null) goto L35;
        if (r18 == r1) goto L56;
        r18 = r18 + r19;
    L56:
        return null;
    L35:
        return TuplesKt.to(Integer.valueOf(r18), r20);
    L31:
        r9 = null;
    L23:
        if (r19 >= 0) goto L56;
        if (r1 > r18) goto L56;
    L38:
        int r110 = r17.getFirst();
        int r3 = r17.getLast();
        int r111 = r17.getStep();
        if (r111 <= 0) goto L41;
        if (r110 > r3) goto L41;
    L43:
        Iterator<T> r21 = r11.iterator();
    L45:
        if (r21.hasNext() == false) goto L49;
        Object r22 = r21.next();
        String r4 = (String) r22;
        if (StringsKt.regionMatchesImpl(r4, 0, r10, r110, r4.length(), r13) == false) goto L45;
    L50:
        String r23 = (String) r22;
        if (r23 != null) goto L53;
        if (r110 == r3) goto L56;
        r110 = r110 + r111;
        goto L43
    L53:
        return TuplesKt.to(Integer.valueOf(r110), r23);
    L49:
        r22 = null;
    L41:
        if (r111 >= 0) goto L56;
        if (r3 > r110) goto L56;
    L17:
        r17 = RangesKt.downTo(RangesKt.coerceAtMost(r12, StringsKt.getLastIndex(r10)), 0);
        goto L19
    }

    public static /* synthetic */ Pair findAnyOf$default(CharSequence r1, Collection r2, int r3, boolean r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r3 = 0;
    L6:
        if ((r5 & 4) == 0) goto L9;
        r4 = false;
    L9:
        return StringsKt.findAnyOf(r1, r2, r3, r4);
    }

    public static final Pair<Integer, String> findAnyOf(CharSequence r1, Collection<String> r2, int r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "strings");
        return findAnyOf$StringsKt__StringsKt(r1, r2, r3, r4, false);
    }

    public static /* synthetic */ Pair findLastAnyOf$default(CharSequence r0, Collection r1, int r2, boolean r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = StringsKt.getLastIndex(r0);
    L6:
        if ((r4 & 4) == 0) goto L9;
        r3 = false;
    L9:
        return StringsKt.findLastAnyOf(r0, r1, r2, r3);
    }

    public static final Pair<Integer, String> findLastAnyOf(CharSequence r1, Collection<String> r2, int r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "strings");
        return findAnyOf$StringsKt__StringsKt(r1, r2, r3, r4, true);
    }

    public static /* synthetic */ int indexOfAny$default(CharSequence r1, Collection r2, int r3, boolean r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r3 = 0;
    L6:
        if ((r5 & 4) == 0) goto L9;
        r4 = false;
    L9:
        return StringsKt.indexOfAny(r1, r2, r3, r4);
    }

    public static final int indexOfAny(CharSequence r1, Collection<String> r2, int r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "strings");
        Pair<Integer, String> r5 = findAnyOf$StringsKt__StringsKt(r1, r2, r3, r4, false);
        if (r5 != null) goto L7;
        return -1;
    L7:
        return r5.getFirst().intValue();
    }

    public static /* synthetic */ int lastIndexOfAny$default(CharSequence r0, Collection r1, int r2, boolean r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = StringsKt.getLastIndex(r0);
    L6:
        if ((r4 & 4) == 0) goto L9;
        r3 = false;
    L9:
        return StringsKt.lastIndexOfAny(r0, r1, r2, r3);
    }

    public static final int lastIndexOfAny(CharSequence r1, Collection<String> r2, int r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "strings");
        Pair<Integer, String> r5 = findAnyOf$StringsKt__StringsKt(r1, r2, r3, r4, true);
        if (r5 != null) goto L7;
        return -1;
    L7:
        return r5.getFirst().intValue();
    }

    public static /* synthetic */ int indexOf$default(CharSequence r1, char r2, int r3, boolean r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r3 = 0;
    L6:
        if ((r5 & 4) == 0) goto L9;
        r4 = false;
    L9:
        return StringsKt.indexOf(r1, r2, r3, r4);
    }

    public static final int indexOf(CharSequence r2, char r3, int r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (r5 == true) goto L9;
        if ((r2 instanceof String) == false) goto L9;
        return ((String) r2).indexOf(r3, r4);
    L9:
        return StringsKt.indexOfAny(r2, new char[]{r3}, r4, r5);
    }

    public static /* synthetic */ int indexOf$default(CharSequence r1, String r2, int r3, boolean r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r3 = 0;
    L6:
        if ((r5 & 4) == 0) goto L9;
        r4 = false;
    L9:
        return StringsKt.indexOf(r1, r2, r3, r4);
    }

    public static final int indexOf(CharSequence r8, String r9, int r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r8, "<this>");
        Intrinsics.checkNotNullParameter(r9, "string");
        if (r11 == true) goto L9;
        if ((r8 instanceof String) == false) goto L9;
        return ((String) r8).indexOf(r9, r10);
    L9:
        return indexOf$StringsKt__StringsKt$default(r8, r9, r10, r8.length(), r11, false, 16, null);
    }

    public static /* synthetic */ int lastIndexOf$default(CharSequence r0, char r1, int r2, boolean r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = StringsKt.getLastIndex(r0);
    L6:
        if ((r4 & 4) == 0) goto L9;
        r3 = false;
    L9:
        return StringsKt.lastIndexOf(r0, r1, r2, r3);
    }

    public static final int lastIndexOf(CharSequence r2, char r3, int r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (r5 == true) goto L9;
        if ((r2 instanceof String) == false) goto L9;
        return ((String) r2).lastIndexOf(r3, r4);
    L9:
        return StringsKt.lastIndexOfAny(r2, new char[]{r3}, r4, r5);
    }

    public static /* synthetic */ int lastIndexOf$default(CharSequence r0, String r1, int r2, boolean r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = StringsKt.getLastIndex(r0);
    L6:
        if ((r4 & 4) == 0) goto L9;
        r3 = false;
    L9:
        return StringsKt.lastIndexOf(r0, r1, r2, r3);
    }

    public static final int lastIndexOf(CharSequence r6, String r7, int r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r7, "string");
        if (r9 == true) goto L9;
        if ((r6 instanceof String) == false) goto L9;
        return ((String) r6).lastIndexOf(r7, r8);
    L9:
        return indexOf$StringsKt__StringsKt(r6, r7, r8, 0, r9, true);
    }

    public static /* synthetic */ boolean contains$default(CharSequence r0, CharSequence r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = false;
    L6:
        return StringsKt.contains(r0, r1, r2);
    }

    public static final boolean contains(CharSequence r11, CharSequence r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r11, "<this>");
        Intrinsics.checkNotNullParameter(r12, "other");
        if ((r12 instanceof String) == false) goto L8;
        if (StringsKt.indexOf$default(r11, (String) r12, 0, r13, 2, null) < 0) goto L11;
        return true;
    L11:
        return false;
    L8:
        if (indexOf$StringsKt__StringsKt$default(r11, r12, 0, r11.length(), r13, false, 16, null) < 0) goto L11;
        return true;
    }

    public static /* synthetic */ boolean contains$default(CharSequence r0, char r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = false;
    L6:
        return StringsKt.contains(r0, r1, r2);
    }

    public static final boolean contains(CharSequence r7, char r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        if (StringsKt.indexOf$default(r7, r8, 0, r9, 2, null) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    private static final boolean contains(CharSequence r1, Regex r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "regex");
        return r2.containsMatchIn(r1);
    }

    static /* synthetic */ Sequence rangesDelimitedBy$StringsKt__StringsKt$default(CharSequence r1, char[] r2, int r3, boolean r4, int r5, int r6, Object r7) {
        if ((r6 & 2) == 0) goto L6;
        r3 = 0;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = false;
    L9:
        if ((r6 & 8) == 0) goto L12;
        r5 = 0;
    L12:
        return rangesDelimitedBy$StringsKt__StringsKt(r1, r2, r3, r4, r5);
    }

    private static final Sequence<IntRange> rangesDelimitedBy$StringsKt__StringsKt(CharSequence r2, final char[] r3, int r4, final boolean r5, int r6) {
        StringsKt.requireNonNegativeLimit(r6);
        return new DelimitedRangesSequence(r2, r4, r6, new StringsKt__StringsKt$rangesDelimitedBy$1(r3, r5));
    }

    static /* synthetic */ Sequence rangesDelimitedBy$StringsKt__StringsKt$default(CharSequence r1, String[] r2, int r3, boolean r4, int r5, int r6, Object r7) {
        if ((r6 & 2) == 0) goto L6;
        r3 = 0;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = false;
    L9:
        if ((r6 & 8) == 0) goto L12;
        r5 = 0;
    L12:
        return rangesDelimitedBy$StringsKt__StringsKt(r1, r2, r3, r4, r5);
    }

    private static final Sequence<IntRange> rangesDelimitedBy$StringsKt__StringsKt(CharSequence r2, String[] r3, int r4, final boolean r5, int r6) {
        StringsKt.requireNonNegativeLimit(r6);
        final List r7 = ArraysKt.asList(r3);
        return new DelimitedRangesSequence(r2, r4, r6, new StringsKt__StringsKt$rangesDelimitedBy$2(r7, r5));
    }

    public static final void requireNonNegativeLimit(int r2) {
        if (r2 < 0) goto L4;
        boolean r0 = true;
    L5:
        if (r0 == false) goto L8;
        return;
    L8:
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + r2).toString());
    L4:
        r0 = false;
        goto L5
    }

    public static /* synthetic */ Sequence splitToSequence$default(CharSequence r1, String[] r2, boolean r3, int r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r3 = false;
    L6:
        if ((r5 & 4) == 0) goto L9;
        r4 = 0;
    L9:
        return StringsKt.splitToSequence(r1, r2, r3, r4);
    }

    public static final Sequence<String> splitToSequence(final CharSequence r8, String[] r9, boolean r10, int r11) {
        Intrinsics.checkNotNullParameter(r8, "<this>");
        Intrinsics.checkNotNullParameter(r9, "delimiters");
        return SequencesKt.map(rangesDelimitedBy$StringsKt__StringsKt$default(r8, r9, 0, r10, r11, 2, null), new C04381(r8));
    }

    public static /* synthetic */ List split$default(CharSequence r1, String[] r2, boolean r3, int r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r3 = false;
    L6:
        if ((r5 & 4) == 0) goto L9;
        r4 = 0;
    L9:
        return StringsKt.split(r1, r2, r3, r4);
    }

    public static final List<String> split(CharSequence r7, String[] r8, boolean r9, int r10) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r8, "delimiters");
        boolean r1 = true;
        if (r8.length != 1) goto L11;
        String r2 = r8[0];
        if (r2.length() == 0) goto L8;
        r1 = false;
    L8:
        if (r1 == true) goto L11;
        return split$StringsKt__StringsKt(r7, r2, r9, r10);
    L11:
        Iterable r11 = SequencesKt.asIterable(rangesDelimitedBy$StringsKt__StringsKt$default(r7, r8, 0, r9, r10, 2, null));
        ArrayList r12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10));
        Iterator r13 = r11.iterator();
    L13:
        if (r13.hasNext() == false) goto L16;
        r12.add(StringsKt.substring(r7, (IntRange) r13.next()));
        goto L13
    L16:
        return r12;
    }

    public static /* synthetic */ Sequence splitToSequence$default(CharSequence r1, char[] r2, boolean r3, int r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r3 = false;
    L6:
        if ((r5 & 4) == 0) goto L9;
        r4 = 0;
    L9:
        return StringsKt.splitToSequence(r1, r2, r3, r4);
    }

    public static final Sequence<String> splitToSequence(final CharSequence r8, char[] r9, boolean r10, int r11) {
        Intrinsics.checkNotNullParameter(r8, "<this>");
        Intrinsics.checkNotNullParameter(r9, "delimiters");
        return SequencesKt.map(rangesDelimitedBy$StringsKt__StringsKt$default(r8, r9, 0, r10, r11, 2, null), new AnonymousClass2(r8));
    }

    public static /* synthetic */ List split$default(CharSequence r1, char[] r2, boolean r3, int r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r3 = false;
    L6:
        if ((r5 & 4) == 0) goto L9;
        r4 = 0;
    L9:
        return StringsKt.split(r1, r2, r3, r4);
    }

    public static final List<String> split(CharSequence r7, char[] r8, boolean r9, int r10) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r8, "delimiters");
        if (r8.length == 1) goto L5;
        Iterable r11 = SequencesKt.asIterable(rangesDelimitedBy$StringsKt__StringsKt$default(r7, r8, 0, r9, r10, 2, null));
        ArrayList r12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10));
        Iterator r13 = r11.iterator();
    L8:
        if (r13.hasNext() == false) goto L11;
        r12.add(StringsKt.substring(r7, (IntRange) r13.next()));
        goto L8
    L11:
        return r12;
    L5:
        return split$StringsKt__StringsKt(r7, String.valueOf(r8[0]), r9, r10);
    }

    private static final List<String> split$StringsKt__StringsKt(CharSequence r7, String r8, boolean r9, int r10) {
        StringsKt.requireNonNegativeLimit(r10);
        int r0 = 0;
        int r1 = StringsKt.indexOf(r7, r8, 0, r9);
        if (r1 == (-1)) goto L23;
        if (r10 == 1) goto L23;
        if (r10 <= 0) goto L9;
        boolean r4 = true;
    L10:
        int r6 = 10;
        if (r4 == false) goto L13;
        r6 = RangesKt.coerceAtMost(r10, 10);
    L13:
        ArrayList r5 = new ArrayList(r6);
    L14:
        r5.add(r7.subSequence(r0, r1).toString());
        r0 = r8.length() + r1;
        if (r4 == true) goto L17;
    L18:
        r1 = StringsKt.indexOf(r7, r8, r0, r9);
        if (r1 != (-1)) goto L14;
    L20:
        r5.add(r7.subSequence(r0, r7.length()).toString());
        return r5;
    L17:
        if (r5.size() == (r10 - 1)) goto L20;
    L9:
        r4 = false;
    L23:
        return CollectionsKt.listOf(r7.toString());
    }

    private static final List<String> split(CharSequence r1, Regex r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "regex");
        return r2.split(r1, r3);
    }

    static /* synthetic */ List split$default(CharSequence r0, Regex r1, int r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = 0;
    L5:
        Intrinsics.checkNotNullParameter(r0, "<this>");
        Intrinsics.checkNotNullParameter(r1, "regex");
        return r1.split(r0, r2);
    }

    private static final Sequence<String> splitToSequence(CharSequence r1, Regex r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "regex");
        return r2.splitToSequence(r1, r3);
    }

    static /* synthetic */ Sequence splitToSequence$default(CharSequence r0, Regex r1, int r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = 0;
    L5:
        Intrinsics.checkNotNullParameter(r0, "<this>");
        Intrinsics.checkNotNullParameter(r1, "regex");
        return r1.splitToSequence(r0, r2);
    }

    public static final Sequence<String> lineSequence(CharSequence r9) {
        Intrinsics.checkNotNullParameter(r9, "<this>");
        return StringsKt.splitToSequence$default(r9, new String[]{IOUtils.LINE_SEPARATOR_WINDOWS, IOUtils.LINE_SEPARATOR_UNIX, "\r"}, false, 0, 6, null);
    }

    public static final List<String> lines(CharSequence r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return SequencesKt.toList(StringsKt.lineSequence(r1));
    }

    public static final boolean contentEqualsIgnoreCaseImpl(CharSequence r6, CharSequence r7) {
        if ((r6 instanceof String) == true) goto L5;
    L8:
        if (r6 != r7) goto L11;
        return true;
    L11:
        if (r6 == null) goto L23;
        if (r7 == null) goto L23;
        if (r6.length() != r7.length()) goto L23;
        int r2 = r6.length();
        int r3 = 0;
    L17:
        if (r3 >= r2) goto L22;
        if (CharsKt.equals(r6.charAt(r3), r7.charAt(r3), true) == false) goto L20;
        r3 = r3 + 1;
        goto L17
    L20:
        return false;
    L22:
        return true;
    L23:
        return false;
    L5:
        if ((r7 instanceof String) == false) goto L8;
        return StringsKt.equals((String) r6, (String) r7, true);
    }

    public static final boolean contentEqualsImpl(CharSequence r6, CharSequence r7) {
        if ((r6 instanceof String) == false) goto L9;
        if ((r7 instanceof String) == false) goto L9;
        return Intrinsics.areEqual(r6, r7);
    L9:
        if (r6 != r7) goto L12;
        return true;
    L12:
        if (r6 == null) goto L24;
        if (r7 == null) goto L24;
        if (r6.length() != r7.length()) goto L24;
        int r2 = r6.length();
        int r3 = 0;
    L18:
        if (r3 >= r2) goto L23;
        if (r6.charAt(r3) != r7.charAt(r3)) goto L21;
        r3 = r3 + 1;
        goto L18
    L21:
        return false;
    L23:
        return true;
    L24:
        return false;
    }

    public static final boolean toBooleanStrict(String r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        if (Intrinsics.areEqual(r3, Constants.IS_SET) == false) goto L6;
        return true;
    L6:
        if (Intrinsics.areEqual(r3, "false") == false) goto L10;
        return false;
    L10:
        throw new IllegalArgumentException("The string doesn't represent a boolean value: " + r3);
    }

    public static final Boolean toBooleanStrictOrNull(String r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (Intrinsics.areEqual(r1, Constants.IS_SET) == false) goto L6;
        return true;
    L6:
        if (Intrinsics.areEqual(r1, "false") == true) goto L11;
        return null;
    L11:
        return false;
    }

    public static final CharSequence trim(CharSequence r5, char... r6) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r6, "chars");
        int r0 = r5.length() - 1;
        int r2 = 0;
        boolean r3 = false;
    L3:
        if (r2 > r0) goto L16;
        if (r3 == true) goto L6;
        int r4 = r2;
    L7:
        boolean r7 = ArraysKt.contains(r6, r5.charAt(r4));
        if (r3 == false) goto L9;
        if (r7 == false) goto L16;
        r0 = r0 - 1;
        goto L3
    L9:
        if (r7 == false) goto L10;
        r2 = r2 + 1;
        goto L3
    L10:
        r3 = true;
        goto L3
    L6:
        r4 = r0;
    L16:
        return r5.subSequence(r2, r0 + 1);
    }

    public static final String trim(String r5, char... r6) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r6, "chars");
        String r7 = r5;
        int r0 = r7.length() - 1;
        int r2 = 0;
        boolean r3 = false;
    L3:
        if (r2 > r0) goto L16;
        if (r3 == true) goto L6;
        int r4 = r2;
    L7:
        boolean r8 = ArraysKt.contains(r6, r7.charAt(r4));
        if (r3 == false) goto L9;
        if (r8 == false) goto L16;
        r0 = r0 - 1;
        goto L3
    L9:
        if (r8 == false) goto L10;
        r2 = r2 + 1;
        goto L3
    L10:
        r3 = true;
        goto L3
    L6:
        r4 = r0;
    L16:
        return r7.subSequence(r2, r0 + 1).toString();
    }

    public static final CharSequence trimStart(CharSequence r3, char... r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "chars");
        int r0 = r3.length();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L9;
        if (ArraysKt.contains(r4, r3.charAt(r1)) == false) goto L12;
        r1 = r1 + 1;
        goto L3
    L12:
        return r3.subSequence(r1, r3.length());
    L9:
        return "";
    }

    public static final String trimStart(String r3, char... r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "chars");
        String r5 = r3;
        int r0 = r5.length();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        if (ArraysKt.contains(r4, r5.charAt(r1)) == false) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        String r6 = r5.subSequence(r1, r5.length());
    L10:
        return r6.toString();
    L8:
        goto L10
    }

    public static final CharSequence trimEnd(CharSequence r3, char... r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "chars");
        int r0 = r3.length() - 1;
        if (r0 < 0) goto L11;
    L4:
        int r1 = r0 - 1;
        if (ArraysKt.contains(r4, r3.charAt(r0)) == false) goto L14;
        if (r1 < 0) goto L11;
        r0 = r1;
        goto L4
    L14:
        return r3.subSequence(0, r0 + 1);
    L11:
        return "";
    }

    public static final String trimEnd(String r3, char... r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "chars");
        String r5 = r3;
        int r0 = r5.length() - 1;
        if (r0 < 0) goto L10;
    L4:
        int r1 = r0 - 1;
        if (ArraysKt.contains(r4, r5.charAt(r0)) == false) goto L6;
        if (r1 < 0) goto L10;
        r0 = r1;
        goto L4
    L6:
        String r6 = r5.subSequence(0, r0 + 1);
    L12:
        return r6.toString();
    L10:
        goto L12
    }

    public static final CharSequence trim(CharSequence r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        int r0 = r5.length() - 1;
        int r2 = 0;
        boolean r3 = false;
    L3:
        if (r2 > r0) goto L16;
        if (r3 == true) goto L6;
        int r4 = r2;
    L7:
        boolean r6 = CharsKt.isWhitespace(r5.charAt(r4));
        if (r3 == false) goto L9;
        if (r6 == false) goto L16;
        r0 = r0 - 1;
        goto L3
    L9:
        if (r6 == false) goto L10;
        r2 = r2 + 1;
        goto L3
    L10:
        r3 = true;
        goto L3
    L6:
        r4 = r0;
    L16:
        return r5.subSequence(r2, r0 + 1);
    }

    public static final CharSequence trimStart(CharSequence r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        int r0 = r3.length();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L9;
        if (CharsKt.isWhitespace(r3.charAt(r1)) == false) goto L12;
        r1 = r1 + 1;
        goto L3
    L12:
        return r3.subSequence(r1, r3.length());
    L9:
        return "";
    }

    public static final CharSequence trimEnd(CharSequence r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        int r0 = r3.length() - 1;
        if (r0 < 0) goto L11;
    L4:
        int r1 = r0 - 1;
        if (CharsKt.isWhitespace(r3.charAt(r0)) == false) goto L14;
        if (r1 < 0) goto L11;
        r0 = r1;
        goto L4
    L14:
        return r3.subSequence(0, r0 + 1);
    L11:
        return "";
    }
}
