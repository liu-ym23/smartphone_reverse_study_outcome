package kotlin.u0;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a0;
import kotlin.i0.j0;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0019\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b!\u001a\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006H\u0000\u001a\u001c\u0010\f\u001a\u00020\r*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a\u001c\u0010\u0011\u001a\u00020\r*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a\u001f\u0010\u0012\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0086\u0002\u001a\u001f\u0010\u0012\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0086\u0002\u001a\u0015\u0010\u0012\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0016H\u0087\n\u001a\u0018\u0010\u0017\u001a\u00020\u0010*\u0004\u0018\u00010\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0000\u001a\u0018\u0010\u0018\u001a\u00020\u0010*\u0004\u0018\u00010\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0000\u001a\u001c\u0010\u0019\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a\u001c\u0010\u0019\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a:\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r\u0018\u00010\u001c*\u00020\u00022\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\r0\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001aE\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r\u0018\u00010\u001c*\u00020\u00022\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\r0\u001e2\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u0010H\u0002¢\u0006\u0002\b!\u001a:\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r\u0018\u00010\u001c*\u00020\u00022\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\r0\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a\u0012\u0010#\u001a\u00020\u0010*\u00020\u00022\u0006\u0010$\u001a\u00020\u0006\u001a7\u0010%\u001a\u0002H&\"\f\b\u0000\u0010'*\u00020\u0002*\u0002H&\"\u0004\b\u0001\u0010&*\u0002H'2\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H&0)H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010*\u001a7\u0010+\u001a\u0002H&\"\f\b\u0000\u0010'*\u00020\u0002*\u0002H&\"\u0004\b\u0001\u0010&*\u0002H'2\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H&0)H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010*\u001a&\u0010,\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a;\u0010,\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010 \u001a\u00020\u0010H\u0002¢\u0006\u0002\b.\u001a&\u0010,\u001a\u00020\u0006*\u00020\u00022\u0006\u0010/\u001a\u00020\r2\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a&\u00100\u001a\u00020\u0006*\u00020\u00022\u0006\u00101\u001a\u0002022\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a,\u00100\u001a\u00020\u0006*\u00020\u00022\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\r0\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a\r\u00103\u001a\u00020\u0010*\u00020\u0002H\u0087\b\u001a\r\u00104\u001a\u00020\u0010*\u00020\u0002H\u0087\b\u001a\r\u00105\u001a\u00020\u0010*\u00020\u0002H\u0087\b\u001a \u00106\u001a\u00020\u0010*\u0004\u0018\u00010\u0002H\u0087\b\u0082\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000\u001a \u00107\u001a\u00020\u0010*\u0004\u0018\u00010\u0002H\u0087\b\u0082\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000\u001a\r\u00108\u001a\u000209*\u00020\u0002H\u0086\u0002\u001a&\u0010:\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a&\u0010:\u001a\u00020\u0006*\u00020\u00022\u0006\u0010/\u001a\u00020\r2\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a&\u0010;\u001a\u00020\u0006*\u00020\u00022\u0006\u00101\u001a\u0002022\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a,\u0010;\u001a\u00020\u0006*\u00020\u00022\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\r0\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a\u0010\u0010<\u001a\b\u0012\u0004\u0012\u00020\r0=*\u00020\u0002\u001a\u0010\u0010>\u001a\b\u0012\u0004\u0012\u00020\r0?*\u00020\u0002\u001a\u0015\u0010@\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0016H\u0087\f\u001a\u000f\u0010A\u001a\u00020\r*\u0004\u0018\u00010\rH\u0087\b\u001a\u001c\u0010B\u001a\u00020\u0002*\u00020\u00022\u0006\u0010C\u001a\u00020\u00062\b\b\u0002\u0010D\u001a\u00020\u0014\u001a\u001c\u0010B\u001a\u00020\r*\u00020\r2\u0006\u0010C\u001a\u00020\u00062\b\b\u0002\u0010D\u001a\u00020\u0014\u001a\u001c\u0010E\u001a\u00020\u0002*\u00020\u00022\u0006\u0010C\u001a\u00020\u00062\b\b\u0002\u0010D\u001a\u00020\u0014\u001a\u001c\u0010E\u001a\u00020\r*\u00020\r2\u0006\u0010C\u001a\u00020\u00062\b\b\u0002\u0010D\u001a\u00020\u0014\u001aG\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00010=*\u00020\u00022\u000e\u0010G\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0H2\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u000b\u001a\u00020\u0006H\u0002¢\u0006\u0004\bI\u0010J\u001a=\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00010=*\u00020\u00022\u0006\u0010G\u001a\u0002022\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u000b\u001a\u00020\u0006H\u0002¢\u0006\u0002\bI\u001a4\u0010K\u001a\u00020\u0010*\u00020\u00022\u0006\u0010L\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010M\u001a\u00020\u00062\u0006\u0010C\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0000\u001a\u0012\u0010N\u001a\u00020\u0002*\u00020\u00022\u0006\u0010O\u001a\u00020\u0002\u001a\u0012\u0010N\u001a\u00020\r*\u00020\r2\u0006\u0010O\u001a\u00020\u0002\u001a\u001a\u0010P\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u0006\u001a\u0012\u0010P\u001a\u00020\u0002*\u00020\u00022\u0006\u0010Q\u001a\u00020\u0001\u001a\u001d\u0010P\u001a\u00020\r*\u00020\r2\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u0006H\u0087\b\u001a\u0015\u0010P\u001a\u00020\r*\u00020\r2\u0006\u0010Q\u001a\u00020\u0001H\u0087\b\u001a\u0012\u0010R\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002\u001a\u0012\u0010R\u001a\u00020\r*\u00020\r2\u0006\u0010\u001a\u001a\u00020\u0002\u001a\u0012\u0010S\u001a\u00020\u0002*\u00020\u00022\u0006\u0010T\u001a\u00020\u0002\u001a\u001a\u0010S\u001a\u00020\u0002*\u00020\u00022\u0006\u0010O\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002\u001a\u0012\u0010S\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\u0002\u001a\u001a\u0010S\u001a\u00020\r*\u00020\r2\u0006\u0010O\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002\u001a.\u0010U\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0014\b\b\u0010V\u001a\u000e\u0012\u0004\u0012\u00020X\u0012\u0004\u0012\u00020\u00020WH\u0087\bø\u0001\u0000\u001a\u001d\u0010U\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010Y\u001a\u00020\rH\u0087\b\u001a$\u0010Z\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\u00142\u0006\u0010Y\u001a\u00020\r2\b\b\u0002\u0010[\u001a\u00020\r\u001a$\u0010Z\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\r2\u0006\u0010Y\u001a\u00020\r2\b\b\u0002\u0010[\u001a\u00020\r\u001a$\u0010\\\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\u00142\u0006\u0010Y\u001a\u00020\r2\b\b\u0002\u0010[\u001a\u00020\r\u001a$\u0010\\\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\r2\u0006\u0010Y\u001a\u00020\r2\b\b\u0002\u0010[\u001a\u00020\r\u001a$\u0010]\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\u00142\u0006\u0010Y\u001a\u00020\r2\b\b\u0002\u0010[\u001a\u00020\r\u001a$\u0010]\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\r2\u0006\u0010Y\u001a\u00020\r2\b\b\u0002\u0010[\u001a\u00020\r\u001a$\u0010^\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\u00142\u0006\u0010Y\u001a\u00020\r2\b\b\u0002\u0010[\u001a\u00020\r\u001a$\u0010^\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\r2\u0006\u0010Y\u001a\u00020\r2\b\b\u0002\u0010[\u001a\u00020\r\u001a\u001d\u0010_\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010Y\u001a\u00020\rH\u0087\b\u001a)\u0010`\u001a\u00020\r*\u00020\r2\u0012\u0010V\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00140WH\u0087\bø\u0001\u0000¢\u0006\u0002\ba\u001a)\u0010`\u001a\u00020\r*\u00020\r2\u0012\u0010V\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00020WH\u0087\bø\u0001\u0000¢\u0006\u0002\bb\u001a\"\u0010c\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00062\u0006\u0010Y\u001a\u00020\u0002\u001a\u001a\u0010c\u001a\u00020\u0002*\u00020\u00022\u0006\u0010Q\u001a\u00020\u00012\u0006\u0010Y\u001a\u00020\u0002\u001a%\u0010c\u001a\u00020\r*\u00020\r2\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00062\u0006\u0010Y\u001a\u00020\u0002H\u0087\b\u001a\u001d\u0010c\u001a\u00020\r*\u00020\r2\u0006\u0010Q\u001a\u00020\u00012\u0006\u0010Y\u001a\u00020\u0002H\u0087\b\u001a=\u0010d\u001a\b\u0012\u0004\u0012\u00020\r0?*\u00020\u00022\u0012\u0010G\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0H\"\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u000b\u001a\u00020\u0006¢\u0006\u0002\u0010e\u001a0\u0010d\u001a\b\u0012\u0004\u0012\u00020\r0?*\u00020\u00022\n\u0010G\u001a\u000202\"\u00020\u00142\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u001a/\u0010d\u001a\b\u0012\u0004\u0012\u00020\r0?*\u00020\u00022\u0006\u0010T\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\u0006H\u0002¢\u0006\u0002\bf\u001a%\u0010d\u001a\b\u0012\u0004\u0012\u00020\r0?*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u000b\u001a\u00020\u0006H\u0087\b\u001a=\u0010g\u001a\b\u0012\u0004\u0012\u00020\r0=*\u00020\u00022\u0012\u0010G\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0H\"\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u000b\u001a\u00020\u0006¢\u0006\u0002\u0010h\u001a0\u0010g\u001a\b\u0012\u0004\u0012\u00020\r0=*\u00020\u00022\n\u0010G\u001a\u000202\"\u00020\u00142\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u001a%\u0010g\u001a\b\u0012\u0004\u0012\u00020\r0=*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u000b\u001a\u00020\u0006H\u0087\b\u001a\u001c\u0010i\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a\u001c\u0010i\u001a\u00020\u0010*\u00020\u00022\u0006\u0010O\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a$\u0010i\u001a\u00020\u0010*\u00020\u00022\u0006\u0010O\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a\u0012\u0010j\u001a\u00020\u0002*\u00020\u00022\u0006\u0010Q\u001a\u00020\u0001\u001a\u001d\u0010j\u001a\u00020\u0002*\u00020\r2\u0006\u0010k\u001a\u00020\u00062\u0006\u0010l\u001a\u00020\u0006H\u0087\b\u001a\u001f\u0010m\u001a\u00020\r*\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010-\u001a\u00020\u0006H\u0087\b\u001a\u0012\u0010m\u001a\u00020\r*\u00020\u00022\u0006\u0010Q\u001a\u00020\u0001\u001a\u0012\u0010m\u001a\u00020\r*\u00020\r2\u0006\u0010Q\u001a\u00020\u0001\u001a\u001c\u0010n\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\u00142\b\b\u0002\u0010[\u001a\u00020\r\u001a\u001c\u0010n\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\r2\b\b\u0002\u0010[\u001a\u00020\r\u001a\u001c\u0010o\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\u00142\b\b\u0002\u0010[\u001a\u00020\r\u001a\u001c\u0010o\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\r2\b\b\u0002\u0010[\u001a\u00020\r\u001a\u001c\u0010p\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\u00142\b\b\u0002\u0010[\u001a\u00020\r\u001a\u001c\u0010p\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\r2\b\b\u0002\u0010[\u001a\u00020\r\u001a\u001c\u0010q\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\u00142\b\b\u0002\u0010[\u001a\u00020\r\u001a\u001c\u0010q\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\r2\b\b\u0002\u0010[\u001a\u00020\r\u001a\f\u0010r\u001a\u00020\u0010*\u00020\rH\u0007\u001a\u0013\u0010s\u001a\u0004\u0018\u00010\u0010*\u00020\rH\u0007¢\u0006\u0002\u0010t\u001a\n\u0010u\u001a\u00020\u0002*\u00020\u0002\u001a$\u0010u\u001a\u00020\u0002*\u00020\u00022\u0012\u0010v\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00100WH\u0086\bø\u0001\u0000\u001a\u0016\u0010u\u001a\u00020\u0002*\u00020\u00022\n\u00101\u001a\u000202\"\u00020\u0014\u001a\r\u0010u\u001a\u00020\r*\u00020\rH\u0087\b\u001a$\u0010u\u001a\u00020\r*\u00020\r2\u0012\u0010v\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00100WH\u0086\bø\u0001\u0000\u001a\u0016\u0010u\u001a\u00020\r*\u00020\r2\n\u00101\u001a\u000202\"\u00020\u0014\u001a\n\u0010w\u001a\u00020\u0002*\u00020\u0002\u001a$\u0010w\u001a\u00020\u0002*\u00020\u00022\u0012\u0010v\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00100WH\u0086\bø\u0001\u0000\u001a\u0016\u0010w\u001a\u00020\u0002*\u00020\u00022\n\u00101\u001a\u000202\"\u00020\u0014\u001a\r\u0010w\u001a\u00020\r*\u00020\rH\u0087\b\u001a$\u0010w\u001a\u00020\r*\u00020\r2\u0012\u0010v\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00100WH\u0086\bø\u0001\u0000\u001a\u0016\u0010w\u001a\u00020\r*\u00020\r2\n\u00101\u001a\u000202\"\u00020\u0014\u001a\n\u0010x\u001a\u00020\u0002*\u00020\u0002\u001a$\u0010x\u001a\u00020\u0002*\u00020\u00022\u0012\u0010v\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00100WH\u0086\bø\u0001\u0000\u001a\u0016\u0010x\u001a\u00020\u0002*\u00020\u00022\n\u00101\u001a\u000202\"\u00020\u0014\u001a\r\u0010x\u001a\u00020\r*\u00020\rH\u0087\b\u001a$\u0010x\u001a\u00020\r*\u00020\r2\u0012\u0010v\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00100WH\u0086\bø\u0001\u0000\u001a\u0016\u0010x\u001a\u00020\r*\u00020\r2\n\u00101\u001a\u000202\"\u00020\u0014\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006y"}, d2 = {"indices", "Lkotlin/ranges/IntRange;", "", "getIndices", "(Ljava/lang/CharSequence;)Lkotlin/ranges/IntRange;", "lastIndex", "", "getLastIndex", "(Ljava/lang/CharSequence;)I", "requireNonNegativeLimit", "", "limit", "commonPrefixWith", "", "other", "ignoreCase", "", "commonSuffixWith", "contains", "char", "", "regex", "Lkotlin/text/Regex;", "contentEqualsIgnoreCaseImpl", "contentEqualsImpl", "endsWith", "suffix", "findAnyOf", "Lkotlin/Pair;", "strings", "", "startIndex", "last", "findAnyOf$StringsKt__StringsKt", "findLastAnyOf", "hasSurrogatePairAt", "index", "ifBlank", "R", "C", "defaultValue", "Lkotlin/Function0;", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "ifEmpty", "indexOf", "endIndex", "indexOf$StringsKt__StringsKt", TypedValues.Custom.S_STRING, "indexOfAny", "chars", "", "isEmpty", "isNotBlank", "isNotEmpty", "isNullOrBlank", "isNullOrEmpty", "iterator", "Lkotlin/collections/CharIterator;", "lastIndexOf", "lastIndexOfAny", "lineSequence", "Lkotlin/sequences/Sequence;", "lines", "", "matches", "orEmpty", "padEnd", "length", "padChar", "padStart", "rangesDelimitedBy", "delimiters", "", "rangesDelimitedBy$StringsKt__StringsKt", "(Ljava/lang/CharSequence;[Ljava/lang/String;IZI)Lkotlin/sequences/Sequence;", "regionMatchesImpl", "thisOffset", "otherOffset", "removePrefix", "prefix", "removeRange", "range", "removeSuffix", "removeSurrounding", "delimiter", "replace", "transform", "Lkotlin/Function1;", "Lkotlin/text/MatchResult;", "replacement", "replaceAfter", "missingDelimiterValue", "replaceAfterLast", "replaceBefore", "replaceBeforeLast", "replaceFirst", "replaceFirstChar", "replaceFirstCharWithChar", "replaceFirstCharWithCharSequence", "replaceRange", "split", "(Ljava/lang/CharSequence;[Ljava/lang/String;ZI)Ljava/util/List;", "split$StringsKt__StringsKt", "splitToSequence", "(Ljava/lang/CharSequence;[Ljava/lang/String;ZI)Lkotlin/sequences/Sequence;", "startsWith", "subSequence", "start", "end", "substring", "substringAfter", "substringAfterLast", "substringBefore", "substringBeforeLast", "toBooleanStrict", "toBooleanStrictOrNull", "(Ljava/lang/String;)Ljava/lang/Boolean;", "trim", "predicate", "trimEnd", "trimStart", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xi = 49, xs = "kotlin/text/StringsKt")
class u extends t {

    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\r\n\u0002\b\u0002\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0002H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "", "", "currentIndex", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    static final class a extends kotlin.n0.d.q implements kotlin.n0.c.p<CharSequence, Integer, kotlin.u<? extends Integer, ? extends Integer>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ char[] f21451f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ boolean f21452g;

        a(char[] r1, boolean r2) {
            this.f21451f = r1;
            this.f21452g = r2;
            super(2);
        }

        public final kotlin.u<Integer, Integer> a(CharSequence r2, int r3) {
            kotlin.n0.d.o.f(r2, "$this$$receiver");
            int r1 = u.R(r2, this.f21451f, r3, this.f21452g);
            if (r1 >= 0) goto L6;
            return null;
        L6:
            return a0.a(Integer.valueOf(r1), 1);
        }

        @Override // kotlin.n0.c.p
        public /* bridge */ /* synthetic */ kotlin.u<? extends Integer, ? extends Integer> invoke(CharSequence r1, Integer r2) {
            return a(r1, r2.intValue());
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\r\n\u0002\b\u0002\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0002H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "", "", "currentIndex", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    static final class b extends kotlin.n0.d.q implements kotlin.n0.c.p<CharSequence, Integer, kotlin.u<? extends Integer, ? extends Integer>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ List<String> f21453f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ boolean f21454g;

        b(List<String> r1, boolean r2) {
            this.f21453f = r1;
            this.f21454g = r2;
            super(2);
        }

        public final kotlin.u<Integer, Integer> a(CharSequence r3, int r4) {
            kotlin.n0.d.o.f(r3, "$this$$receiver");
            kotlin.u r2 = u.B(r3, this.f21453f, r4, this.f21454g, false);
            if (r2 != null) goto L7;
            return null;
        L7:
            return a0.a(r2.c(), Integer.valueOf(((String) r2.d()).length()));
        }

        @Override // kotlin.n0.c.p
        public /* bridge */ /* synthetic */ kotlin.u<? extends Integer, ? extends Integer> invoke(CharSequence r1, Integer r2) {
            return a(r1, r2.intValue());
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lkotlin/ranges/IntRange;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    static final class c extends kotlin.n0.d.q implements kotlin.n0.c.l<kotlin.r0.d, String> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ CharSequence f21455f;

        c(CharSequence r1) {
            this.f21455f = r1;
            super(1);
        }

        public final String a(kotlin.r0.d r2) {
            kotlin.n0.d.o.f(r2, "it");
            return u.u0(this.f21455f, r2);
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ String invoke(kotlin.r0.d r1) {
            return a(r1);
        }
    }

    public static /* synthetic */ String A0(String r0, char r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = r0;
    L6:
        return z0(r0, r1, r2);
    }

    public static final /* synthetic */ kotlin.u B(CharSequence r0, Collection r1, int r2, boolean r3, boolean r4) {
        return I(r0, r1, r2, r3, r4);
    }

    public static final String B0(String r7, char r8, String r9) {
        kotlin.n0.d.o.f(r7, "<this>");
        kotlin.n0.d.o.f(r9, "missingDelimiterValue");
        int r10 = k.P(r7, r8, 0, false, 6, null);
        if (r10 == (-1)) goto L7;
        String r11 = r7.substring(0, r10);
        kotlin.n0.d.o.e(r11, "this as java.lang.String…ing(startIndex, endIndex)");
        return r11;
    L7:
        return r9;
    }

    public static final boolean C(CharSequence r7, char r8, boolean r9) {
        kotlin.n0.d.o.f(r7, "<this>");
        if (k.P(r7, r8, 0, r9, 2, null) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final String C0(String r7, String r8, String r9) {
        kotlin.n0.d.o.f(r7, "<this>");
        kotlin.n0.d.o.f(r8, "delimiter");
        kotlin.n0.d.o.f(r9, "missingDelimiterValue");
        int r10 = k.Q(r7, r8, 0, false, 6, null);
        if (r10 == (-1)) goto L7;
        String r11 = r7.substring(0, r10);
        kotlin.n0.d.o.e(r11, "this as java.lang.String…ing(startIndex, endIndex)");
        return r11;
    L7:
        return r9;
    }

    public static boolean D(CharSequence r11, CharSequence r12, boolean r13) {
        kotlin.n0.d.o.f(r11, "<this>");
        kotlin.n0.d.o.f(r12, "other");
        if ((r12 instanceof String) == false) goto L8;
        if (k.Q(r11, (String) r12, 0, r13, 2, null) < 0) goto L11;
        return true;
    L11:
        return false;
    L8:
        if (O(r11, r12, 0, r11.length(), r13, false, 16, null) < 0) goto L11;
        return true;
    }

    public static /* synthetic */ String D0(String r0, char r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = r0;
    L6:
        return B0(r0, r1, r2);
    }

    public static /* synthetic */ boolean E(CharSequence r0, char r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = false;
    L6:
        return C(r0, r1, r2);
    }

    public static /* synthetic */ String E0(String r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = r0;
    L6:
        return C0(r0, r1, r2);
    }

    public static /* synthetic */ boolean F(CharSequence r0, CharSequence r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = false;
    L6:
        return k.D(r0, r1, r2);
    }

    public static String F0(String r7, String r8, String r9) {
        kotlin.n0.d.o.f(r7, "<this>");
        kotlin.n0.d.o.f(r8, "delimiter");
        kotlin.n0.d.o.f(r9, "missingDelimiterValue");
        int r10 = k.V(r7, r8, 0, false, 6, null);
        if (r10 == (-1)) goto L7;
        String r11 = r7.substring(0, r10);
        kotlin.n0.d.o.e(r11, "this as java.lang.String…ing(startIndex, endIndex)");
        return r11;
    L7:
        return r9;
    }

    public static final boolean G(CharSequence r1, char r2, boolean r3) {
        kotlin.n0.d.o.f(r1, "<this>");
        if (r1.length() > 0) goto L5;
    L7:
        return false;
    L5:
        if (kotlin.u0.c.d(r1.charAt(k.K(r1)), r2, r3) == false) goto L7;
        return true;
    }

    public static CharSequence G0(CharSequence r5) {
        kotlin.n0.d.o.f(r5, "<this>");
        int r0 = r5.length() - 1;
        int r2 = 0;
        boolean r3 = false;
    L3:
        if (r2 > r0) goto L16;
        if (r3 == true) goto L6;
        int r4 = r2;
    L7:
        boolean r6 = kotlin.u0.a.c(r5.charAt(r4));
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

    public static /* synthetic */ boolean H(CharSequence r0, char r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = false;
    L6:
        return G(r0, r1, r2);
    }

    private static final kotlin.u<Integer, String> I(CharSequence r10, Collection<String> r11, int r12, boolean r13, boolean r14) {
        if (r13 == true) goto L15;
        if (r11.size() != 1) goto L15;
        String r15 = (String) kotlin.i0.r.n0(r11);
        if (r14 == true) goto L9;
        int r16 = k.Q(r10, r15, r12, false, 4, null);
    L10:
        if (r16 >= 0) goto L13;
        return null;
    L13:
        return a0.a(Integer.valueOf(r16), r15);
    L9:
        r16 = k.V(r10, r15, r12, false, 4, null);
    L15:
        if (r14 == true) goto L17;
        kotlin.r0.b r17 = new kotlin.r0.d(kotlin.r0.e.c(r12, 0), r10.length());
    L19:
        if ((r10 instanceof String) == false) goto L38;
        int r18 = r17.a();
        int r1 = r17.b();
        int r19 = r17.c();
        if (r19 <= 0) goto L23;
        if (r18 > r1) goto L23;
    L25:
        Iterator<T> r8 = r11.iterator();
    L27:
        if (r8.hasNext() == false) goto L31;
        Object r9 = r8.next();
        String r2 = (String) r9;
        if (t.r(r2, 0, (String) r10, r18, r2.length(), r13) == false) goto L27;
    L32:
        String r20 = (String) r9;
        if (r20 != null) goto L35;
        if (r18 == r1) goto L55;
        r18 = r18 + r19;
    L55:
        return null;
    L35:
        return a0.a(Integer.valueOf(r18), r20);
    L31:
        r9 = null;
    L23:
        if (r19 >= 0) goto L55;
        if (r1 > r18) goto L55;
    L38:
        r18 = r17.a();
        int r3 = r17.b();
        int r110 = r17.c();
        if (r110 <= 0) goto L41;
        if (r18 > r3) goto L41;
    L43:
        Iterator<T> r21 = r11.iterator();
    L45:
        if (r21.hasNext() == false) goto L49;
        Object r22 = r21.next();
        String r4 = (String) r22;
        if (f0(r4, 0, r10, r18, r4.length(), r13) == false) goto L45;
    L50:
        r20 = (String) r22;
        if (r20 != null) goto L35;
        if (r18 == r3) goto L55;
        r18 = r18 + r110;
        goto L43
    L49:
        r22 = null;
    L41:
        if (r110 >= 0) goto L55;
        if (r3 > r18) goto L55;
    L17:
        r17 = kotlin.r0.e.j(kotlin.r0.e.f(r12, k.K(r10)), 0);
        goto L19
    }

    public static kotlin.r0.d J(CharSequence r2) {
        kotlin.n0.d.o.f(r2, "<this>");
        return new kotlin.r0.d(0, r2.length() - 1);
    }

    public static int K(CharSequence r1) {
        kotlin.n0.d.o.f(r1, "<this>");
        return r1.length() - 1;
    }

    public static final int L(CharSequence r2, char r3, int r4, boolean r5) {
        kotlin.n0.d.o.f(r2, "<this>");
        if (r5 == true) goto L9;
        if ((r2 instanceof String) == false) goto L9;
        return ((String) r2).indexOf(r3, r4);
    L9:
        return R(r2, new char[]{r3}, r4, r5);
    }

    public static final int M(CharSequence r8, String r9, int r10, boolean r11) {
        kotlin.n0.d.o.f(r8, "<this>");
        kotlin.n0.d.o.f(r9, TypedValues.Custom.S_STRING);
        if (r11 == true) goto L9;
        if ((r8 instanceof String) == false) goto L9;
        return ((String) r8).indexOf(r9, r10);
    L9:
        return O(r8, r9, r10, r8.length(), r11, false, 16, null);
    }

    private static final int N(CharSequence r6, CharSequence r7, int r8, int r9, boolean r10, boolean r11) {
        if (r11 == true) goto L5;
        kotlin.r0.b r12 = new kotlin.r0.d(kotlin.r0.e.c(r8, 0), kotlin.r0.e.f(r9, r6.length()));
    L7:
        if ((r6 instanceof String) == true) goto L9;
    L20:
        int r13 = r12.a();
        int r14 = r12.b();
        int r15 = r12.c();
        if (r15 <= 0) goto L23;
        if (r13 > r14) goto L23;
    L25:
        int r3 = r13;
        if (f0(r7, 0, r6, r3, r7.length(), r10) == true) goto L27;
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
        int r16 = r12.a();
        int r17 = r12.b();
        int r18 = r12.c();
        if (r18 <= 0) goto L13;
        if (r16 > r17) goto L13;
    L15:
        int r4 = r16;
        if (t.r((String) r7, 0, (String) r6, r4, r7.length(), r10) == true) goto L17;
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
        r12 = kotlin.r0.e.j(kotlin.r0.e.f(r8, k.K(r6)), kotlin.r0.e.c(r9, 0));
        goto L7
    }

    static /* synthetic */ int O(CharSequence r6, CharSequence r7, int r8, int r9, boolean r10, boolean r11, int r12, Object r13) {
        if ((r12 & 16) == 0) goto L6;
        r11 = false;
    L6:
        return N(r6, r7, r8, r9, r10, r11);
    }

    public static /* synthetic */ int P(CharSequence r1, char r2, int r3, boolean r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r3 = 0;
    L6:
        if ((r5 & 4) == 0) goto L9;
        r4 = false;
    L9:
        return L(r1, r2, r3, r4);
    }

    public static /* synthetic */ int Q(CharSequence r1, String r2, int r3, boolean r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r3 = 0;
    L6:
        if ((r5 & 4) == 0) goto L9;
        r4 = false;
    L9:
        return M(r1, r2, r3, r4);
    }

    public static final int R(CharSequence r7, char[] r8, int r9, boolean r10) {
        kotlin.n0.d.o.f(r7, "<this>");
        kotlin.n0.d.o.f(r8, "chars");
        if (r10 == false) goto L5;
    L10:
        j0 r11 = new kotlin.r0.d(kotlin.r0.e.c(r9, 0), k.K(r7)).g();
    L12:
        if (r11.hasNext() == false) goto L22;
        int r1 = r11.nextInt();
        char r3 = r7.charAt(r1);
        int r4 = r8.length;
        int r5 = 0;
    L14:
        if (r5 >= r4) goto L19;
        if (kotlin.u0.c.d(r8[r5], r3, r10) == true) goto L17;
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
        return ((String) r7).indexOf(kotlin.i0.i.R(r8), r9);
    }

    public static final int S(CharSequence r2, char r3, int r4, boolean r5) {
        kotlin.n0.d.o.f(r2, "<this>");
        if (r5 == true) goto L9;
        if ((r2 instanceof String) == false) goto L9;
        return ((String) r2).lastIndexOf(r3, r4);
    L9:
        return W(r2, new char[]{r3}, r4, r5);
    }

    public static final int T(CharSequence r6, String r7, int r8, boolean r9) {
        kotlin.n0.d.o.f(r6, "<this>");
        kotlin.n0.d.o.f(r7, TypedValues.Custom.S_STRING);
        if (r9 == true) goto L9;
        if ((r6 instanceof String) == false) goto L9;
        return ((String) r6).lastIndexOf(r7, r8);
    L9:
        return N(r6, r7, r8, 0, r9, true);
    }

    public static /* synthetic */ int U(CharSequence r0, char r1, int r2, boolean r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = k.K(r0);
    L6:
        if ((r4 & 4) == 0) goto L9;
        r3 = false;
    L9:
        return S(r0, r1, r2, r3);
    }

    public static /* synthetic */ int V(CharSequence r0, String r1, int r2, boolean r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = k.K(r0);
    L6:
        if ((r4 & 4) == 0) goto L9;
        r3 = false;
    L9:
        return T(r0, r1, r2, r3);
    }

    public static final int W(CharSequence r6, char[] r7, int r8, boolean r9) {
        kotlin.n0.d.o.f(r6, "<this>");
        kotlin.n0.d.o.f(r7, "chars");
        if (r9 == false) goto L5;
    L10:
        int r10 = kotlin.r0.e.f(r8, k.K(r6));
    L12:
        if ((-1) >= r10) goto L22;
        char r1 = r6.charAt(r10);
        int r2 = r7.length;
        boolean r3 = false;
        int r4 = 0;
    L14:
        if (r4 >= r2) goto L19;
        if (kotlin.u0.c.d(r7[r4], r1, r9) == true) goto L17;
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
        return ((String) r6).lastIndexOf(kotlin.i0.i.R(r7), r8);
    }

    public static final kotlin.t0.h<String> X(CharSequence r9) {
        kotlin.n0.d.o.f(r9, "<this>");
        return p0(r9, new String[]{"\r\n", "\n", "\r"}, false, 0, 6, null);
    }

    public static final List<String> Y(CharSequence r1) {
        kotlin.n0.d.o.f(r1, "<this>");
        return kotlin.t0.k.z(X(r1));
    }

    public static final CharSequence Z(CharSequence r4, int r5, char r6) {
        kotlin.n0.d.o.f(r4, "<this>");
        if (r5 < 0) goto L15;
        if (r5 <= r4.length()) goto L7;
        StringBuilder r0 = new StringBuilder(r5);
        j0 r7 = new kotlin.r0.d(1, r5 - r4.length()).g();
    L10:
        if (r7.hasNext() == false) goto L12;
        r7.nextInt();
        r0.append(r6);
        goto L10
    L12:
        r0.append(r4);
        return r0;
    L7:
        return r4.subSequence(0, r4.length());
    L15:
        throw new IllegalArgumentException("Desired length " + r5 + " is less than zero.");
    }

    public static String a0(String r1, int r2, char r3) {
        kotlin.n0.d.o.f(r1, "<this>");
        return Z(r1, r2, r3).toString();
    }

    private static final kotlin.t0.h<kotlin.r0.d> b0(CharSequence r2, char[] r3, int r4, boolean r5, int r6) {
        i0(r6);
        return new e(r2, r4, r6, new a(r3, r5));
    }

    private static final kotlin.t0.h<kotlin.r0.d> c0(CharSequence r2, String[] r3, int r4, boolean r5, int r6) {
        i0(r6);
        return new e(r2, r4, r6, new b(kotlin.i0.i.d(r3), r5));
    }

    static /* synthetic */ kotlin.t0.h d0(CharSequence r1, char[] r2, int r3, boolean r4, int r5, int r6, Object r7) {
        if ((r6 & 2) == 0) goto L6;
        r3 = 0;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = false;
    L9:
        if ((r6 & 8) == 0) goto L12;
        r5 = 0;
    L12:
        return b0(r1, r2, r3, r4, r5);
    }

    static /* synthetic */ kotlin.t0.h e0(CharSequence r1, String[] r2, int r3, boolean r4, int r5, int r6, Object r7) {
        if ((r6 & 2) == 0) goto L6;
        r3 = 0;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = false;
    L9:
        if ((r6 & 8) == 0) goto L12;
        r5 = 0;
    L12:
        return c0(r1, r2, r3, r4, r5);
    }

    public static final boolean f0(CharSequence r4, int r5, CharSequence r6, int r7, int r8, boolean r9) {
        kotlin.n0.d.o.f(r4, "<this>");
        kotlin.n0.d.o.f(r6, "other");
        if (r7 < 0) goto L18;
        if (r5 < 0) goto L18;
        if (r5 > (r4.length() - r8)) goto L18;
        if (r7 > (r6.length() - r8)) goto L18;
        int r1 = 0;
    L11:
        if (r1 >= r8) goto L16;
        if (kotlin.u0.c.d(r4.charAt(r5 + r1), r6.charAt(r7 + r1), r9) == false) goto L14;
        r1 = r1 + 1;
        goto L11
    L14:
        return false;
    L16:
        return true;
    L18:
        return false;
    }

    public static String g0(String r3, CharSequence r4) {
        kotlin.n0.d.o.f(r3, "<this>");
        kotlin.n0.d.o.f(r4, "prefix");
        if (t0(r3, r4, false, 2, null) == false) goto L6;
        String r5 = r3.substring(r4.length());
        kotlin.n0.d.o.e(r5, "this as java.lang.String).substring(startIndex)");
        return r5;
    L6:
        return r3;
    }

    public static final CharSequence h0(CharSequence r2, int r3, int r4, CharSequence r5) {
        kotlin.n0.d.o.f(r2, "<this>");
        kotlin.n0.d.o.f(r5, "replacement");
        if (r4 < r3) goto L7;
        StringBuilder r0 = new StringBuilder();
        r0.append(r2, 0, r3);
        kotlin.n0.d.o.e(r0, "this.append(value, startIndex, endIndex)");
        r0.append(r5);
        r0.append(r2, r4, r2.length());
        kotlin.n0.d.o.e(r0, "this.append(value, startIndex, endIndex)");
        return r0;
    L7:
        throw new IndexOutOfBoundsException("End index (" + r4 + ") is less than start index (" + r3 + ").");
    }

    public static final void i0(int r2) {
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

    public static final List<String> j0(CharSequence r7, char[] r8, boolean r9, int r10) {
        kotlin.n0.d.o.f(r7, "<this>");
        kotlin.n0.d.o.f(r8, "delimiters");
        if (r8.length == 1) goto L5;
        Iterable r11 = kotlin.t0.k.k(d0(r7, r8, 0, r9, r10, 2, null));
        ArrayList r12 = new ArrayList(kotlin.i0.r.q(r11, 10));
        Iterator r13 = r11.iterator();
    L8:
        if (r13.hasNext() == false) goto L10;
        r12.add(u0(r7, (kotlin.r0.d) r13.next()));
        goto L8
    L10:
        return r12;
    L5:
        return l0(r7, String.valueOf(r8[0]), r9, r10);
    }

    public static final List<String> k0(CharSequence r7, String[] r8, boolean r9, int r10) {
        kotlin.n0.d.o.f(r7, "<this>");
        kotlin.n0.d.o.f(r8, "delimiters");
        boolean r1 = true;
        if (r8.length != 1) goto L11;
        String r2 = r8[0];
        if (r2.length() == 0) goto L8;
        r1 = false;
    L8:
        if (r1 == true) goto L11;
        return l0(r7, r2, r9, r10);
    L11:
        Iterable r11 = kotlin.t0.k.k(e0(r7, r8, 0, r9, r10, 2, null));
        ArrayList r12 = new ArrayList(kotlin.i0.r.q(r11, 10));
        Iterator r13 = r11.iterator();
    L13:
        if (r13.hasNext() == false) goto L15;
        r12.add(u0(r7, (kotlin.r0.d) r13.next()));
        goto L13
    L15:
        return r12;
    }

    private static final List<String> l0(CharSequence r7, String r8, boolean r9, int r10) {
        i0(r10);
        int r0 = 0;
        int r1 = M(r7, r8, 0, r9);
        if (r1 == (-1)) goto L23;
        if (r10 == 1) goto L23;
        if (r10 <= 0) goto L9;
        boolean r4 = true;
    L10:
        int r6 = 10;
        if (r4 == false) goto L13;
        r6 = kotlin.r0.e.f(r10, 10);
    L13:
        ArrayList r5 = new ArrayList(r6);
    L14:
        r5.add(r7.subSequence(r0, r1).toString());
        r0 = r8.length() + r1;
        if (r4 == true) goto L17;
    L18:
        r1 = M(r7, r8, r0, r9);
        if (r1 != (-1)) goto L14;
    L20:
        r5.add(r7.subSequence(r0, r7.length()).toString());
        return r5;
    L17:
        if (r5.size() == (r10 - 1)) goto L20;
    L9:
        r4 = false;
    L23:
        return kotlin.i0.r.d(r7.toString());
    }

    public static /* synthetic */ List m0(CharSequence r1, char[] r2, boolean r3, int r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r3 = false;
    L6:
        if ((r5 & 4) == 0) goto L9;
        r4 = 0;
    L9:
        return j0(r1, r2, r3, r4);
    }

    public static /* synthetic */ List n0(CharSequence r1, String[] r2, boolean r3, int r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r3 = false;
    L6:
        if ((r5 & 4) == 0) goto L9;
        r4 = 0;
    L9:
        return k0(r1, r2, r3, r4);
    }

    public static final kotlin.t0.h<String> o0(CharSequence r8, String[] r9, boolean r10, int r11) {
        kotlin.n0.d.o.f(r8, "<this>");
        kotlin.n0.d.o.f(r9, "delimiters");
        return kotlin.t0.k.t(e0(r8, r9, 0, r10, r11, 2, null), new c(r8));
    }

    public static /* synthetic */ kotlin.t0.h p0(CharSequence r1, String[] r2, boolean r3, int r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r3 = false;
    L6:
        if ((r5 & 4) == 0) goto L9;
        r4 = 0;
    L9:
        return o0(r1, r2, r3, r4);
    }

    public static final boolean q0(CharSequence r2, char r3, boolean r4) {
        kotlin.n0.d.o.f(r2, "<this>");
        if (r2.length() > 0) goto L5;
        return false;
    L5:
        if (kotlin.u0.c.d(r2.charAt(0), r3, r4) == false) goto L9;
        return true;
    L9:
        return false;
    }

    public static final boolean r0(CharSequence r6, CharSequence r7, boolean r8) {
        kotlin.n0.d.o.f(r6, "<this>");
        kotlin.n0.d.o.f(r7, "prefix");
        if (r8 == true) goto L11;
        if ((r6 instanceof String) == false) goto L11;
        if ((r7 instanceof String) == false) goto L11;
        return k.A((String) r6, (String) r7, false, 2, null);
    L11:
        return f0(r6, 0, r7, 0, r7.length(), r8);
    }

    public static /* synthetic */ boolean s0(CharSequence r0, char r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = false;
    L6:
        return q0(r0, r1, r2);
    }

    public static /* synthetic */ boolean t0(CharSequence r0, CharSequence r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = false;
    L6:
        return r0(r0, r1, r2);
    }

    public static final String u0(CharSequence r1, kotlin.r0.d r2) {
        kotlin.n0.d.o.f(r1, "<this>");
        kotlin.n0.d.o.f(r2, "range");
        return r1.subSequence(r2.o().intValue(), r2.n().intValue() + 1).toString();
    }

    public static final String v0(String r7, char r8, String r9) {
        kotlin.n0.d.o.f(r7, "<this>");
        kotlin.n0.d.o.f(r9, "missingDelimiterValue");
        int r10 = k.P(r7, r8, 0, false, 6, null);
        if (r10 == (-1)) goto L7;
        String r11 = r7.substring(r10 + 1, r7.length());
        kotlin.n0.d.o.e(r11, "this as java.lang.String…ing(startIndex, endIndex)");
        return r11;
    L7:
        return r9;
    }

    public static String w0(String r7, String r8, String r9) {
        kotlin.n0.d.o.f(r7, "<this>");
        kotlin.n0.d.o.f(r8, "delimiter");
        kotlin.n0.d.o.f(r9, "missingDelimiterValue");
        int r0 = k.Q(r7, r8, 0, false, 6, null);
        if (r0 == (-1)) goto L7;
        String r10 = r7.substring(r0 + r8.length(), r7.length());
        kotlin.n0.d.o.e(r10, "this as java.lang.String…ing(startIndex, endIndex)");
        return r10;
    L7:
        return r9;
    }

    public static /* synthetic */ String x0(String r0, char r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = r0;
    L6:
        return v0(r0, r1, r2);
    }

    public static /* synthetic */ String y0(String r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = r0;
    L6:
        return k.w0(r0, r1, r2);
    }

    public static final String z0(String r7, char r8, String r9) {
        kotlin.n0.d.o.f(r7, "<this>");
        kotlin.n0.d.o.f(r9, "missingDelimiterValue");
        int r10 = k.U(r7, r8, 0, false, 6, null);
        if (r10 == (-1)) goto L7;
        String r11 = r7.substring(r10 + 1, r7.length());
        kotlin.n0.d.o.e(r11, "this as java.lang.String…ing(startIndex, endIndex)");
        return r11;
    L7:
        return r9;
    }
}
