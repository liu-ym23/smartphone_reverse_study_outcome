package h.a;

import com.bytedance.common.wschannel.WsConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000è\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0001\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0017\u0018\u00002\u00020X2\u00020\u00172\u00020\u007f2\u00030Ã\u0001:\u0006Ò\u0001Ó\u0001Ô\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J'\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ%\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0015\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005H\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001e\u001a\u0004\u0018\u00010\u0005H\u0080@ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u001f\u001a\u0004\u0018\u00010\u0005H\u0082@ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010\u001dJ\u0019\u0010!\u001a\u00020\u00012\b\u0010 \u001a\u0004\u0018\u00010\rH\u0017¢\u0006\u0004\b!\u0010\"J\u001f\u0010!\u001a\u00020\u00112\u000e\u0010 \u001a\n\u0018\u00010#j\u0004\u0018\u0001`$H\u0016¢\u0006\u0004\b!\u0010%J\u0017\u0010&\u001a\u00020\u00012\b\u0010 \u001a\u0004\u0018\u00010\r¢\u0006\u0004\b&\u0010\"J\u0019\u0010)\u001a\u00020\u00012\b\u0010 \u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0004\b'\u0010(J\u0017\u0010*\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\rH\u0016¢\u0006\u0004\b*\u0010+J\u001b\u0010,\u001a\u0004\u0018\u00010\u00052\b\u0010 \u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b,\u0010-J\u0017\u0010.\u001a\u00020\u00012\u0006\u0010 \u001a\u00020\rH\u0002¢\u0006\u0004\b.\u0010\"J\u000f\u00100\u001a\u00020/H\u0014¢\u0006\u0004\b0\u00101J\u0017\u00102\u001a\u00020\u00012\u0006\u0010 \u001a\u00020\rH\u0016¢\u0006\u0004\b2\u0010\"J!\u00105\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u0002032\b\u00104\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b5\u00106J)\u0010;\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u0002072\u0006\u00109\u001a\u0002082\b\u0010:\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b;\u0010<J\u0019\u0010=\u001a\u00020\r2\b\u0010 \u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b=\u0010>J(\u0010C\u001a\u00020@2\n\b\u0002\u0010?\u001a\u0004\u0018\u00010/2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\rH\u0080\b¢\u0006\u0004\bA\u0010BJ#\u0010D\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0014\u001a\u0002072\b\u0010:\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\bD\u0010EJ\u0019\u0010F\u001a\u0004\u0018\u0001082\u0006\u0010\u0014\u001a\u000203H\u0002¢\u0006\u0004\bF\u0010GJ\u0011\u0010H\u001a\u00060#j\u0002`$¢\u0006\u0004\bH\u0010IJ\u0013\u0010J\u001a\u00060#j\u0002`$H\u0016¢\u0006\u0004\bJ\u0010IJ\u0011\u0010M\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0004\bK\u0010LJ\u000f\u0010N\u001a\u0004\u0018\u00010\r¢\u0006\u0004\bN\u0010OJ'\u0010P\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0014\u001a\u0002072\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u000fH\u0002¢\u0006\u0004\bP\u0010QJ\u0019\u0010R\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0014\u001a\u000203H\u0002¢\u0006\u0004\bR\u0010SJ\u0017\u0010U\u001a\u00020\u00012\u0006\u0010T\u001a\u00020\rH\u0014¢\u0006\u0004\bU\u0010\"J\u0017\u0010W\u001a\u00020\u00112\u0006\u0010T\u001a\u00020\rH\u0010¢\u0006\u0004\bV\u0010+J\u0019\u0010Z\u001a\u00020\u00112\b\u0010Y\u001a\u0004\u0018\u00010XH\u0004¢\u0006\u0004\bZ\u0010[JF\u0010d\u001a\u00020c2\u0006\u0010\\\u001a\u00020\u00012\u0006\u0010]\u001a\u00020\u00012'\u0010b\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\r¢\u0006\f\b_\u0012\b\b`\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00110^j\u0002`a¢\u0006\u0004\bd\u0010eJ6\u0010d\u001a\u00020c2'\u0010b\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\r¢\u0006\f\b_\u0012\b\b`\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00110^j\u0002`a¢\u0006\u0004\bd\u0010fJ\u0013\u0010g\u001a\u00020\u0011H\u0086@ø\u0001\u0000¢\u0006\u0004\bg\u0010\u001dJ\u000f\u0010h\u001a\u00020\u0001H\u0002¢\u0006\u0004\bh\u0010iJ\u0013\u0010j\u001a\u00020\u0011H\u0082@ø\u0001\u0000¢\u0006\u0004\bj\u0010\u001dJ&\u0010m\u001a\u00020l2\u0014\u0010k\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00110^H\u0082\b¢\u0006\u0004\bm\u0010nJ\u001b\u0010o\u001a\u0004\u0018\u00010\u00052\b\u0010 \u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\bo\u0010-J\u0019\u0010q\u001a\u00020\u00012\b\u0010:\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0004\bp\u0010(J\u001b\u0010s\u001a\u0004\u0018\u00010\u00052\b\u0010:\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0004\br\u0010-J@\u0010t\u001a\u00020\t2'\u0010b\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\r¢\u0006\f\b_\u0012\b\b`\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00110^j\u0002`a2\u0006\u0010\\\u001a\u00020\u0001H\u0002¢\u0006\u0004\bt\u0010uJ\u000f\u0010w\u001a\u00020/H\u0010¢\u0006\u0004\bv\u00101J\u001f\u0010x\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\rH\u0002¢\u0006\u0004\bx\u0010yJ.\u0010{\u001a\u00020\u0011\"\n\b\u0000\u0010z\u0018\u0001*\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\b\u0010 \u001a\u0004\u0018\u00010\rH\u0082\b¢\u0006\u0004\b{\u0010yJ\u0019\u0010\\\u001a\u00020\u00112\b\u0010 \u001a\u0004\u0018\u00010\rH\u0014¢\u0006\u0004\b\\\u0010+J\u0019\u0010|\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005H\u0014¢\u0006\u0004\b|\u0010\u0016J\u000f\u0010}\u001a\u00020\u0011H\u0014¢\u0006\u0004\b}\u0010~J\u0019\u0010\u0081\u0001\u001a\u00020\u00112\u0007\u0010\u0080\u0001\u001a\u00020\u007f¢\u0006\u0006\b\u0081\u0001\u0010\u0082\u0001J\u001b\u0010\u0084\u0001\u001a\u00020\u00112\u0007\u0010\u0014\u001a\u00030\u0083\u0001H\u0002¢\u0006\u0006\b\u0084\u0001\u0010\u0085\u0001J\u001a\u0010\u0086\u0001\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\tH\u0002¢\u0006\u0006\b\u0086\u0001\u0010\u0087\u0001JI\u0010\u008c\u0001\u001a\u00020\u0011\"\u0005\b\u0000\u0010\u0088\u00012\u000e\u0010\u008a\u0001\u001a\t\u0012\u0004\u0012\u00028\u00000\u0089\u00012\u001d\u0010k\u001a\u0019\b\u0001\u0012\u000b\u0012\t\u0012\u0004\u0012\u00028\u00000\u008b\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00050^ø\u0001\u0000¢\u0006\u0006\b\u008c\u0001\u0010\u008d\u0001JX\u0010\u0091\u0001\u001a\u00020\u0011\"\u0004\b\u0000\u0010z\"\u0005\b\u0001\u0010\u0088\u00012\u000e\u0010\u008a\u0001\u001a\t\u0012\u0004\u0012\u00028\u00010\u0089\u00012$\u0010k\u001a \b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u000b\u0012\t\u0012\u0004\u0012\u00028\u00010\u008b\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u008e\u0001H\u0000ø\u0001\u0000¢\u0006\u0006\b\u008f\u0001\u0010\u0090\u0001J\u001a\u0010\u0093\u0001\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\tH\u0000¢\u0006\u0006\b\u0092\u0001\u0010\u0087\u0001JX\u0010\u0095\u0001\u001a\u00020\u0011\"\u0004\b\u0000\u0010z\"\u0005\b\u0001\u0010\u0088\u00012\u000e\u0010\u008a\u0001\u001a\t\u0012\u0004\u0012\u00028\u00010\u0089\u00012$\u0010k\u001a \b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u000b\u0012\t\u0012\u0004\u0012\u00028\u00010\u008b\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u008e\u0001H\u0000ø\u0001\u0000¢\u0006\u0006\b\u0094\u0001\u0010\u0090\u0001J\u000f\u0010\u0096\u0001\u001a\u00020\u0001¢\u0006\u0005\b\u0096\u0001\u0010iJ\u001d\u0010\u0098\u0001\u001a\u00030\u0097\u00012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0006\b\u0098\u0001\u0010\u0099\u0001J\u001c\u0010\u009a\u0001\u001a\u00020/2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0006\b\u009a\u0001\u0010\u009b\u0001J\u0011\u0010\u009c\u0001\u001a\u00020/H\u0007¢\u0006\u0005\b\u009c\u0001\u00101J\u0011\u0010\u009d\u0001\u001a\u00020/H\u0016¢\u0006\u0005\b\u009d\u0001\u00101J$\u0010\u009e\u0001\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u0002032\b\u00104\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0006\b\u009e\u0001\u0010\u009f\u0001J\"\u0010 \u0001\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u0002032\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0006\b \u0001\u0010¡\u0001J(\u0010¢\u0001\u001a\u0004\u0018\u00010\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u00052\b\u0010:\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0006\b¢\u0001\u0010£\u0001J&\u0010¤\u0001\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0014\u001a\u0002032\b\u0010:\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0006\b¤\u0001\u0010¥\u0001J-\u0010¦\u0001\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u0002072\u0006\u0010\u0018\u001a\u0002082\b\u0010:\u001a\u0004\u0018\u00010\u0005H\u0082\u0010¢\u0006\u0006\b¦\u0001\u0010§\u0001J\u0019\u0010©\u0001\u001a\u0004\u0018\u000108*\u00030¨\u0001H\u0002¢\u0006\u0006\b©\u0001\u0010ª\u0001J\u001f\u0010«\u0001\u001a\u00020\u0011*\u00020\u00072\b\u0010 \u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0005\b«\u0001\u0010yJ&\u0010¬\u0001\u001a\u00060#j\u0002`$*\u00020\r2\n\b\u0002\u0010?\u001a\u0004\u0018\u00010/H\u0004¢\u0006\u0006\b¬\u0001\u0010\u00ad\u0001R\u001b\u0010±\u0001\u001a\t\u0012\u0004\u0012\u00020X0®\u00018F¢\u0006\b\u001a\u0006\b¯\u0001\u0010°\u0001R\u0018\u0010³\u0001\u001a\u0004\u0018\u00010\r8DX\u0084\u0004¢\u0006\u0007\u001a\u0005\b²\u0001\u0010OR\u0016\u0010µ\u0001\u001a\u00020\u00018DX\u0084\u0004¢\u0006\u0007\u001a\u0005\b´\u0001\u0010iR\u0016\u0010·\u0001\u001a\u00020\u00018PX\u0090\u0004¢\u0006\u0007\u001a\u0005\b¶\u0001\u0010iR\u0016\u0010¸\u0001\u001a\u00020\u00018VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b¸\u0001\u0010iR\u0013\u0010¹\u0001\u001a\u00020\u00018F¢\u0006\u0007\u001a\u0005\b¹\u0001\u0010iR\u0013\u0010º\u0001\u001a\u00020\u00018F¢\u0006\u0007\u001a\u0005\bº\u0001\u0010iR\u0013\u0010»\u0001\u001a\u00020\u00018F¢\u0006\u0007\u001a\u0005\b»\u0001\u0010iR\u0016\u0010¼\u0001\u001a\u00020\u00018TX\u0094\u0004¢\u0006\u0007\u001a\u0005\b¼\u0001\u0010iR\u0019\u0010À\u0001\u001a\u0007\u0012\u0002\b\u00030½\u00018F¢\u0006\b\u001a\u0006\b¾\u0001\u0010¿\u0001R\u0016\u0010Â\u0001\u001a\u00020\u00018PX\u0090\u0004¢\u0006\u0007\u001a\u0005\bÁ\u0001\u0010iR\u0015\u0010Æ\u0001\u001a\u00030Ã\u00018F¢\u0006\b\u001a\u0006\bÄ\u0001\u0010Å\u0001R.\u0010Ì\u0001\u001a\u0004\u0018\u00010\u00192\t\u0010Ç\u0001\u001a\u0004\u0018\u00010\u00198@@@X\u0080\u000e¢\u0006\u0010\u001a\u0006\bÈ\u0001\u0010É\u0001\"\u0006\bÊ\u0001\u0010Ë\u0001R\u0017\u0010\u0014\u001a\u0004\u0018\u00010\u00058@X\u0080\u0004¢\u0006\u0007\u001a\u0005\bÍ\u0001\u0010LR\u001e\u0010Ï\u0001\u001a\u0004\u0018\u00010\r*\u0004\u0018\u00010\u00058BX\u0082\u0004¢\u0006\u0007\u001a\u0005\bÎ\u0001\u0010>R\u001b\u0010Ð\u0001\u001a\u00020\u0001*\u0002038BX\u0082\u0004¢\u0006\b\u001a\u0006\bÐ\u0001\u0010Ñ\u0001\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006Õ\u0001"}, d2 = {"Lkotlinx/coroutines/JobSupport;", "", "active", "<init>", "(Z)V", "", "expect", "Lkotlinx/coroutines/NodeList;", "list", "Lkotlinx/coroutines/JobNode;", "node", "addLastAtomic", "(Ljava/lang/Object;Lkotlinx/coroutines/NodeList;Lkotlinx/coroutines/JobNode;)Z", "", "rootCause", "", "exceptions", "", "addSuppressedExceptions", "(Ljava/lang/Throwable;Ljava/util/List;)V", WsConstants.KEY_CONNECTION_STATE, "afterCompletion", "(Ljava/lang/Object;)V", "Lkotlinx/coroutines/ChildJob;", "child", "Lkotlinx/coroutines/ChildHandle;", "attachChild", "(Lkotlinx/coroutines/ChildJob;)Lkotlinx/coroutines/ChildHandle;", "awaitInternal$kotlinx_coroutines_core", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitInternal", "awaitSuspend", "cause", "cancel", "(Ljava/lang/Throwable;)Z", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "(Ljava/util/concurrent/CancellationException;)V", "cancelCoroutine", "cancelImpl$kotlinx_coroutines_core", "(Ljava/lang/Object;)Z", "cancelImpl", "cancelInternal", "(Ljava/lang/Throwable;)V", "cancelMakeCompleting", "(Ljava/lang/Object;)Ljava/lang/Object;", "cancelParent", "", "cancellationExceptionMessage", "()Ljava/lang/String;", "childCancelled", "Lkotlinx/coroutines/Incomplete;", "update", "completeStateFinalization", "(Lkotlinx/coroutines/Incomplete;Ljava/lang/Object;)V", "Lkotlinx/coroutines/JobSupport$Finishing;", "Lkotlinx/coroutines/ChildHandleNode;", "lastChild", "proposedUpdate", "continueCompleting", "(Lkotlinx/coroutines/JobSupport$Finishing;Lkotlinx/coroutines/ChildHandleNode;Ljava/lang/Object;)V", "createCauseException", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "message", "Lkotlinx/coroutines/JobCancellationException;", "defaultCancellationException$kotlinx_coroutines_core", "(Ljava/lang/String;Ljava/lang/Throwable;)Lkotlinx/coroutines/JobCancellationException;", "defaultCancellationException", "finalizeFinishingState", "(Lkotlinx/coroutines/JobSupport$Finishing;Ljava/lang/Object;)Ljava/lang/Object;", "firstChild", "(Lkotlinx/coroutines/Incomplete;)Lkotlinx/coroutines/ChildHandleNode;", "getCancellationException", "()Ljava/util/concurrent/CancellationException;", "getChildJobCancellationCause", "getCompletedInternal$kotlinx_coroutines_core", "()Ljava/lang/Object;", "getCompletedInternal", "getCompletionExceptionOrNull", "()Ljava/lang/Throwable;", "getFinalRootCause", "(Lkotlinx/coroutines/JobSupport$Finishing;Ljava/util/List;)Ljava/lang/Throwable;", "getOrPromoteCancellingList", "(Lkotlinx/coroutines/Incomplete;)Lkotlinx/coroutines/NodeList;", "exception", "handleJobException", "handleOnCompletionException$kotlinx_coroutines_core", "handleOnCompletionException", "Lkotlinx/coroutines/Job;", "parent", "initParentJob", "(Lkotlinx/coroutines/Job;)V", "onCancelling", "invokeImmediately", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "handler", "Lkotlinx/coroutines/DisposableHandle;", "invokeOnCompletion", "(ZZLkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/DisposableHandle;", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/DisposableHandle;", "join", "joinInternal", "()Z", "joinSuspend", "block", "", "loopOnState", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Void;", "makeCancelling", "makeCompleting$kotlinx_coroutines_core", "makeCompleting", "makeCompletingOnce$kotlinx_coroutines_core", "makeCompletingOnce", "makeNode", "(Lkotlin/jvm/functions/Function1;Z)Lkotlinx/coroutines/JobNode;", "nameString$kotlinx_coroutines_core", "nameString", "notifyCancelling", "(Lkotlinx/coroutines/NodeList;Ljava/lang/Throwable;)V", "T", "notifyHandlers", "onCompletionInternal", "onStart", "()V", "Lkotlinx/coroutines/ParentJob;", "parentJob", "parentCancelled", "(Lkotlinx/coroutines/ParentJob;)V", "Lkotlinx/coroutines/Empty;", "promoteEmptyToNodeList", "(Lkotlinx/coroutines/Empty;)V", "promoteSingleToNodeList", "(Lkotlinx/coroutines/JobNode;)V", "R", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "Lkotlin/coroutines/Continuation;", "registerSelectClause0", "(Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function1;)V", "Lkotlin/Function2;", "registerSelectClause1Internal$kotlinx_coroutines_core", "(Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function2;)V", "registerSelectClause1Internal", "removeNode$kotlinx_coroutines_core", "removeNode", "selectAwaitCompletion$kotlinx_coroutines_core", "selectAwaitCompletion", "start", "", "startInternal", "(Ljava/lang/Object;)I", "stateString", "(Ljava/lang/Object;)Ljava/lang/String;", "toDebugString", "toString", "tryFinalizeSimpleState", "(Lkotlinx/coroutines/Incomplete;Ljava/lang/Object;)Z", "tryMakeCancelling", "(Lkotlinx/coroutines/Incomplete;Ljava/lang/Throwable;)Z", "tryMakeCompleting", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "tryMakeCompletingSlowPath", "(Lkotlinx/coroutines/Incomplete;Ljava/lang/Object;)Ljava/lang/Object;", "tryWaitForChild", "(Lkotlinx/coroutines/JobSupport$Finishing;Lkotlinx/coroutines/ChildHandleNode;Ljava/lang/Object;)Z", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "nextChild", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Lkotlinx/coroutines/ChildHandleNode;", "notifyCompletion", "toCancellationException", "(Ljava/lang/Throwable;Ljava/lang/String;)Ljava/util/concurrent/CancellationException;", "Lkotlin/sequences/Sequence;", "getChildren", "()Lkotlin/sequences/Sequence;", "children", "getCompletionCause", "completionCause", "getCompletionCauseHandled", "completionCauseHandled", "getHandlesException$kotlinx_coroutines_core", "handlesException", "isActive", "isCancelled", "isCompleted", "isCompletedExceptionally", "isScopedCoroutine", "Lkotlin/coroutines/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "key", "getOnCancelComplete$kotlinx_coroutines_core", "onCancelComplete", "Lkotlinx/coroutines/selects/SelectClause0;", "getOnJoin", "()Lkotlinx/coroutines/selects/SelectClause0;", "onJoin", "value", "getParentHandle$kotlinx_coroutines_core", "()Lkotlinx/coroutines/ChildHandle;", "setParentHandle$kotlinx_coroutines_core", "(Lkotlinx/coroutines/ChildHandle;)V", "parentHandle", "getState$kotlinx_coroutines_core", "getExceptionOrNull", "exceptionOrNull", "isCancelling", "(Lkotlinx/coroutines/Incomplete;)Z", "AwaitContinuation", "ChildCompletion", "Finishing", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class f2 implements x1, v, m2 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f17349f = null;
    private volatile /* synthetic */ Object _parentHandle;
    private volatile /* synthetic */ Object _state;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\b\u0002\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0096\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lkotlinx/coroutines/JobSupport$ChildCompletion;", "Lkotlinx/coroutines/JobNode;", "parent", "Lkotlinx/coroutines/JobSupport;", WsConstants.KEY_CONNECTION_STATE, "Lkotlinx/coroutines/JobSupport$Finishing;", "child", "Lkotlinx/coroutines/ChildHandleNode;", "proposedUpdate", "", "(Lkotlinx/coroutines/JobSupport;Lkotlinx/coroutines/JobSupport$Finishing;Lkotlinx/coroutines/ChildHandleNode;Ljava/lang/Object;)V", "invoke", "", "cause", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class a extends e2 {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final f2 f17350j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final b f17351k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private final u f17352l;
        private final Object m;

        public a(f2 r1, b r2, u r3, Object r4) {
            this.f17350j = r1;
            this.f17351k = r2;
            this.f17352l = r3;
            this.m = r4;
        }

        @Override // h.a.a0
        public void C(Throwable r3) {
            f2.t(this.f17350j, this.f17351k, this.f17352l, this.m);
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ kotlin.f0 invoke(Throwable r1) {
            C(r1);
            return kotlin.f0.f18324a;
        }
    }

    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b\u0002\u0018\u00002\u00060\u0018j\u0002`,2\u00020-B!\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00050\rj\b\u0012\u0004\u0012\u00020\u0005`\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R(\u0010\u001e\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u00188B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0011\u0010!\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b!\u0010 R$\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u00038F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010 \"\u0004\b\"\u0010#R\u0011\u0010$\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b$\u0010 R\u001a\u0010\u0002\u001a\u00020\u00018\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0002\u0010%\u001a\u0004\b&\u0010'R(\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b(\u0010)\"\u0004\b*\u0010\f¨\u0006+"}, d2 = {"Lkotlinx/coroutines/JobSupport$Finishing;", "Lkotlinx/coroutines/NodeList;", "list", "", "isCompleting", "", "rootCause", "<init>", "(Lkotlinx/coroutines/NodeList;ZLjava/lang/Throwable;)V", "exception", "", "addExceptionLocked", "(Ljava/lang/Throwable;)V", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "allocateList", "()Ljava/util/ArrayList;", "proposedException", "", "sealLocked", "(Ljava/lang/Throwable;)Ljava/util/List;", "", "toString", "()Ljava/lang/String;", "", "value", "getExceptionsHolder", "()Ljava/lang/Object;", "setExceptionsHolder", "(Ljava/lang/Object;)V", "exceptionsHolder", "isActive", "()Z", "isCancelling", "setCompleting", "(Z)V", "isSealed", "Lkotlinx/coroutines/NodeList;", "getList", "()Lkotlinx/coroutines/NodeList;", "getRootCause", "()Ljava/lang/Throwable;", "setRootCause", "kotlinx-coroutines-core", "Lkotlinx/coroutines/internal/SynchronizedObject;", "Lkotlinx/coroutines/Incomplete;"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class b implements s1 {
        private volatile /* synthetic */ Object _exceptionsHolder;
        private volatile /* synthetic */ int _isCompleting;
        private volatile /* synthetic */ Object _rootCause;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final j2 f17353f;

        public b(j2 r1, boolean r2, Throwable r3) {
            this.f17353f = r1;
            this._isCompleting = r2 ? 1 : 0;
            this._rootCause = r3;
            this._exceptionsHolder = null;
        }

        private final ArrayList<Throwable> c() {
            return new ArrayList(4);
        }

        private final Object e() {
            return this._exceptionsHolder;
        }

        private final void l(Object r1) {
            this._exceptionsHolder = r1;
        }

        public final void a(Throwable r3) {
            Throwable r0 = f();
            if (r0 != null) goto L6;
            m(r3);
            return;
        L6:
            if (r3 != r0) goto L8;
            return;
        L8:
            Object r1 = e();
            if (r1 != null) goto L12;
            l(r3);
            return;
        L12:
            if ((r1 instanceof Throwable) == false) goto L17;
            if (r3 != r1) goto L15;
            return;
        L15:
            ArrayList<Throwable> r2 = c();
            r2.add(r1);
            r2.add(r3);
            l(r2);
            return;
        L17:
            if ((r1 instanceof ArrayList) == false) goto L21;
            ((ArrayList) r1).add(r3);
            return;
        L21:
            throw new IllegalStateException(kotlin.n0.d.o.m("State is ", r1).toString());
        }

        @Override // h.a.s1
        public boolean b() {
            if (f() != null) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // h.a.s1
        public j2 d() {
            return this.f17353f;
        }

        public final Throwable f() {
            return (Throwable) this._rootCause;
        }

        public final boolean g() {
            if (f() == null) goto L5;
            return true;
        L5:
            return false;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [boolean, int] */
        public final boolean h() {
            return this._isCompleting;
        }

        public final boolean i() {
            if (e() != g2.e()) goto L5;
            return true;
        L5:
            return false;
        }

        public final List<Throwable> j(Throwable r4) {
            Object r0 = e();
            if (r0 != null) goto L6;
            ArrayList<Throwable> r1 = c();
        L11:
            Throwable r2 = f();
            if (r2 == null) goto L15;
            r1.add(0, r2);
        L15:
            if (r4 != null) goto L17;
        L19:
            l(g2.e());
            return r1;
        L17:
            if (kotlin.n0.d.o.a(r4, r2) == true) goto L19;
            r1.add(r4);
            goto L19
        L6:
            if ((r0 instanceof Throwable) == false) goto L9;
            ArrayList<Throwable> r3 = c();
            r3.add(r0);
            r1 = r3;
            goto L11
        L9:
            if ((r0 instanceof ArrayList) == false) goto L22;
            r1 = (ArrayList) r0;
            goto L11
        L22:
            throw new IllegalStateException(kotlin.n0.d.o.m("State is ", r0).toString());
        }

        public final void k(boolean r1) {
            this._isCompleting = r1 ? 1 : 0;
        }

        public final void m(Throwable r1) {
            this._rootCause = r1;
        }

        public String toString() {
            return "Finishing[cancelling=" + g() + ", completing=" + h() + ", rootCause=" + f() + ", exceptions=" + e() + ", list=" + d() + ']';
        }
    }

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006H\u0016¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/internal/LockFreeLinkedListNode$makeCondAddOp$1", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "prepare", "", "affected", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class c extends h.a.f3.s.b {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ f2 f17354d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ Object f17355e;

        public c(h.a.f3.s r1, f2 r2, Object r3) {
            this.f17354d = r2;
            this.f17355e = r3;
            super(r1);
        }

        @Override // h.a.f3.d
        public /* bridge */ /* synthetic */ Object g(h.a.f3.s r1) {
            return i(r1);
        }

        public Object i(h.a.f3.s r1) {
            if (this.f17354d.c0() != this.f17355e) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == false) goto L9;
            return null;
        L9:
            return h.a.f3.r.a();
        L5:
            r0 = false;
            goto L6
        }
    }

    static {
        f17349f = AtomicReferenceFieldUpdater.newUpdater(f2.class, Object.class, "_state");
    }

    public f2(boolean r1) {
        if (r1 == false) goto L5;
        g1 r2 = g2.c();
    L6:
        this._state = r2;
        this._parentHandle = null;
        return;
    L5:
        r2 = g2.d();
        goto L6
    }

    private final int B0(Object r5) {
        if ((r5 instanceof g1) == false) goto L13;
        if (((g1) r5).b() == false) goto L8;
        return 0;
    L8:
        if (f17349f.compareAndSet(this, r5, g2.c()) == true) goto L10;
        return -1;
    L10:
        w0();
        return 1;
    L13:
        if ((r5 instanceof r1) == true) goto L15;
        return 0;
    L15:
        if (f17349f.compareAndSet(this, r5, ((r1) r5).d()) == true) goto L17;
        return -1;
    L17:
        w0();
        return 1;
    }

    private final String C0(Object r2) {
        if ((r2 instanceof b) == false) goto L11;
        b r3 = (b) r2;
        if (r3.g() == false) goto L8;
        return "Cancelling";
    L8:
        if (r3.h() == false) goto L22;
        return "Completing";
    L22:
        return "Active";
    L11:
        if ((r2 instanceof s1) == false) goto L17;
        if (((s1) r2).b() == true) goto L26;
        return "New";
    L26:
        return "Active";
    L17:
        if ((r2 instanceof y) == false) goto L19;
        return "Cancelled";
    L19:
        return "Completed";
    }

    private final Object D(Object r7) {
    L2:
        Object r0 = c0();
        if ((r0 instanceof s1) == false) goto L13;
        if ((r0 instanceof b) == true) goto L7;
    L9:
        Object r1 = I0(r0, new y(M(r7), false, 2, null));
        if (r1 == g2.b()) goto L2;
        return r1;
    L7:
        if (((b) r0).h() == false) goto L9;
    L13:
        return g2.a();
    }

    public static /* synthetic */ CancellationException E0(f2 r0, Throwable r1, String r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 1) == 0) goto L7;
        r2 = null;
    L7:
        return r0.D0(r1, r2);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toCancellationException");
    }

    private final boolean G(Throwable r4) {
        if (k0() == false) goto L5;
        return true;
    L5:
        boolean r0 = r4 instanceof CancellationException;
        t r3 = b0();
        if (r3 != null) goto L8;
    L16:
        return r0;
    L8:
        if (r3 == k2.f17534f) goto L16;
        if (r3.c(r4) == true) goto L17;
        if (r0 == true) goto L18;
        return false;
    L18:
        return true;
    L17:
        return true;
    }

    private final boolean G0(s1 r5, Object r6) {
        if (q0.a() == false) goto L16;
        if ((r5 instanceof g1) == false) goto L7;
    L10:
        boolean r0 = true;
    L11:
        if (r0 == true) goto L16;
        throw new AssertionError();
    L7:
        if ((r5 instanceof e2) == true) goto L10;
        r0 = false;
    L16:
        if (q0.a() == false) goto L23;
        if ((!(r6 instanceof y)) == true) goto L23;
        throw new AssertionError();
    L23:
        if (f17349f.compareAndSet(this, r5, g2.g(r6)) == true) goto L25;
        return false;
    L25:
        u0(null);
        v0(r6);
        J(r5, r6);
        return true;
    }

    private final boolean H0(s1 r6, Throwable r7) {
        if (q0.a() == false) goto L10;
        if ((!(r6 instanceof b)) == true) goto L10;
        throw new AssertionError();
    L10:
        if (q0.a() == true) goto L12;
    L16:
        j2 r0 = a0(r6);
        if (r0 != null) goto L20;
        return false;
    L20:
        if (f17349f.compareAndSet(this, r6, new b(r0, false, r7)) == true) goto L22;
        return false;
    L22:
        s0(r0, r7);
        return true;
    L12:
        if (r6.b() == true) goto L16;
        throw new AssertionError();
    }

    private final Object I0(Object r2, Object r3) {
        if ((r2 instanceof s1) == true) goto L7;
        return g2.a();
    L7:
        if ((r2 instanceof g1) == true) goto L11;
        if ((r2 instanceof e2) == true) goto L11;
    L20:
        return J0((s1) r2, r3);
    L11:
        if ((r2 instanceof u) == true) goto L20;
        if ((r3 instanceof y) == true) goto L20;
        if (G0((s1) r2, r3) == false) goto L18;
        return r3;
    L18:
        return g2.b();
    }

    private final void J(s1 r4, Object r5) {
        t r0 = b0();
        if (r0 == null) goto L6;
        r0.dispose();
        A0(k2.f17534f);
    L6:
        Throwable r1 = null;
        if ((r5 instanceof y) == false) goto L9;
        y r6 = (y) r5;
    L10:
        if (r6 == null) goto L14;
        r1 = r6.f17588a;
    L14:
        if ((r4 instanceof e2) == true) goto L24;
        j2 r7 = r4.d();
        if (r7 == null) goto L28;
        t0(r7, r1);
        return;
    L28:
        return;
    L24:
        ((e2) r4).C(r1);     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        f0(new b0("Exception in completion handler " + r4 + " for " + this, th));
        return;
    L9:
        r6 = null;
        goto L10
    }

    private final Object J0(s1 r7, Object r8) {
        j2 r0 = a0(r7);
        if (r0 == null) goto L5;
        Throwable r2 = null;
        if ((r7 instanceof b) == false) goto L9;
        b r1 = (b) r7;
    L10:
        if (r1 != null) goto L12;
        r1 = new b(r0, false, null);
    L12:
        monitor-enter(r1);
    L56:
        th = move-exception;
        throw th;
    L14:
        if (r1.h() == false) goto L19;
        h.a.f3.f0 r6 = g2.a();     // Catch: Throwable -> L56
        monitor-exit(r1);
        return r6;
    L19:
        r1.k(true);     // Catch: Throwable -> L56
        if (r1 == r7) goto L27;
        if (f17349f.compareAndSet(this, r7, r1) == true) goto L27;
        h.a.f3.f0 r9 = g2.b();     // Catch: Throwable -> L56
        monitor-exit(r1);
        return r9;
    L27:
        if (q0.a() == true) goto L29;
    L33:
        boolean r4 = r1.g();     // Catch: Throwable -> L56
        if ((r8 instanceof y) == false) goto L36;
        y r5 = (y) r8;     // Catch: Throwable -> L56
    L37:
        if (r5 == null) goto L40;
        r1.a(r5.f17588a);     // Catch: Throwable -> L56
    L40:
        Throwable r10 = r1.f();     // Catch: Throwable -> L56
        if ((true ^ r4) == false) goto L43;
        r2 = r10;
    L43:
        kotlin.f0 r3 = kotlin.f0.f18324a;     // Catch: Throwable -> L56
        monitor-exit(r1);
        if (r2 == null) goto L48;
        s0(r0, r2);
    L48:
        u r11 = R(r7);
        if (r11 == null) goto L55;
        if (K0(r1, r11, r8) == false) goto L55;
        return g2.f17440b;
    L55:
        return P(r1, r8);
    L36:
        r5 = null;
        goto L37
    L29:
        if ((!r1.i()) == true) goto L33;
        throw new AssertionError();     // Catch: Throwable -> L56
    L9:
        r1 = null;
        goto L10
    L5:
        return g2.b();
    }

    private final void K(b r2, u r3, Object r4) {
        if (q0.a() == true) goto L5;
    L12:
        u r5 = r0(r3);
        if (r5 != null) goto L15;
    L17:
        w(P(r2, r4));
        return;
    L15:
        if (K0(r2, r5, r4) == false) goto L17;
        return;
    L5:
        if (c0() != r2) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == true) goto L12;
        throw new AssertionError();
    L7:
        r0 = false;
        goto L8
    }

    private final boolean K0(b r7, u r8, Object r9) {
    L3:
        if (x1.a.d(r8.f17569j, false, false, new a(this, r7, r8, r9), 1, null) != k2.f17534f) goto L4;
        r8 = r0(r8);
        if (r8 != null) goto L3;
        return false;
    L4:
        return true;
    }

    private final Throwable M(Object r3) {
        if (r3 != null) goto L4;
        boolean r0 = true;
    L5:
        if (r0 == false) goto L9;
        Throwable r4 = (Throwable) r3;
        if (r4 == null) goto L12;
        return r4;
    L12:
        return new y1(r(this), null, this);
    L9:
        Objects.requireNonNull(r3, "null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
        return ((m2) r3).Y();
    L4:
        r0 = r3 instanceof Throwable;
        goto L5
    }

    private final Object P(b r8, Object r9) {
        boolean r1 = true;
        if (q0.a() == false) goto L13;
        if (c0() != r8) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == true) goto L13;
        throw new AssertionError();
    L7:
        r0 = false;
    L13:
        if (q0.a() == false) goto L20;
        if ((!r8.i()) == true) goto L20;
        throw new AssertionError();
    L20:
        if (q0.a() == false) goto L27;
        if (r8.h() == true) goto L27;
        throw new AssertionError();
    L27:
        if ((r9 instanceof y) == false) goto L29;
        y r2 = (y) r9;
    L30:
        if (r2 != null) goto L32;
        Throwable r3 = null;
    L33:
        monitor-enter(r8);
        boolean r4 = r8.g();     // Catch: Throwable -> L62
        List<Throwable> r5 = r8.j(r3);     // Catch: Throwable -> L62
        Throwable r6 = U(r8, r5);     // Catch: Throwable -> L62
        if (r6 == null) goto L37;
        v(r6, r5);     // Catch: Throwable -> L62
    L37:
        monitor-exit(r8);
        if (r6 == null) goto L43;
        if (r6 == r3) goto L43;
        r9 = new y(r6, false, 2, null);
    L43:
        if (r6 != null) goto L45;
    L52:
        if (r4 == true) goto L54;
        u0(r6);
    L54:
        v0(r9);
        boolean r7 = f17349f.compareAndSet(this, r8, g2.g(r9));
        if (q0.a() == false) goto L60;
        if (r7 == true) goto L60;
        throw new AssertionError();
    L60:
        J(r8, r9);
        return r9;
    L45:
        if (G(r6) == false) goto L47;
    L50:
        if (r1 == false) goto L52;
        Objects.requireNonNull(r9, "null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
        ((y) r9).b();
        goto L52
    L47:
        if (e0(r6) == true) goto L50;
        r1 = false;
    L62:
        th = move-exception;
        throw th;
    L32:
        r3 = r2.f17588a;
        goto L33
    L29:
        r2 = null;
        goto L30
    }

    private final u R(s1 r3) {
        if ((r3 instanceof u) == false) goto L5;
        u r0 = (u) r3;
    L6:
        if (r0 != null) goto L12;
        j2 r4 = r3.d();
        if (r4 != null) goto L13;
        return null;
    L13:
        return r0(r4);
    L12:
        return r0;
    L5:
        r0 = null;
        goto L6
    }

    private final Throwable T(Object r2) {
        if ((r2 instanceof y) == false) goto L5;
        y r3 = (y) r2;
    L6:
        if (r3 != null) goto L9;
        return null;
    L9:
        return r3.f17588a;
    L5:
        r3 = null;
        goto L6
    }

    private final Throwable U(b r5, List<? extends Throwable> r6) {
        Object r1 = null;
        if (r6.isEmpty() == true) goto L5;
        Iterator<T> r4 = r6.iterator();
    L11:
        if (r4.hasNext() == false) goto L15;
        Object r7 = r4.next();
        if ((!(((Throwable) r7) instanceof CancellationException)) == false) goto L11;
    L16:
        Throwable r8 = (Throwable) r7;
        if (r8 == null) goto L19;
        return r8;
    L19:
        Throwable r9 = r6.get(0);
        if ((r9 instanceof w2) == false) goto L35;
        Iterator<T> r10 = r6.iterator();
    L23:
        if (r10.hasNext() == false) goto L32;
        Object r2 = r10.next();
        Throwable r3 = (Throwable) r2;
        if (r3 != r9) goto L27;
    L29:
        boolean r11 = false;
    L30:
        if (r11 == false) goto L23;
        r1 = r2;
        goto L32
    L27:
        if ((r3 instanceof w2) == false) goto L29;
        r11 = true;
    L32:
        Throwable r12 = (Throwable) r1;
        if (r12 == null) goto L35;
        return r12;
    L35:
        return r9;
    L15:
        r7 = null;
        goto L16
    L5:
        if (r5.g() == true) goto L7;
        return null;
    L7:
        return new y1(r(this), null, this);
    }

    private final j2 a0(s1 r2) {
        j2 r0 = r2.d();
        if (r0 == null) goto L5;
        return r0;
    L5:
        if ((r2 instanceof g1) == false) goto L8;
        return new j2();
    L8:
        if ((r2 instanceof e2) == false) goto L11;
        y0((e2) r2);
        return null;
    L11:
        throw new IllegalStateException(kotlin.n0.d.o.m("State should have list: ", r2).toString());
    }

    private final boolean l0() {
    L2:
        Object r0 = c0();
        if ((r0 instanceof s1) == false) goto L4;
        if (B0(r0) < 0) goto L2;
        return true;
    L4:
        return false;
    }

    private final Object m0(kotlin.k0.d<? super kotlin.f0> r4) {
        o r0 = new o(kotlin.k0.i.b.b(r4), 1);
        r0.A();
        q.a(r0, L(new o2(r0)));
        Object r3 = r0.x();
        if (r3 != kotlin.k0.i.b.c()) goto L6;
        kotlin.k0.j.a.h.c(r4);
    L6:
        if (r3 != kotlin.k0.i.b.c()) goto L9;
        return r3;
    L9:
        return kotlin.f0.f18324a;
    }

    private final Object n0(Object r7) {
        Throwable r0 = null;
        Throwable r1 = null;
    L3:
        Object r2 = c0();
        if ((r2 instanceof b) == true) goto L5;
        if ((r2 instanceof s1) == false) goto L49;
        if (r1 != null) goto L34;
        r1 = M(r7);
    L34:
        s1 r3 = (s1) r2;
        if (r3.b() == true) goto L37;
        Object r4 = I0(r2, new y(r1, false, 2, null));
        if (r4 == g2.a()) goto L47;
        if (r4 == g2.b()) goto L3;
        return r4;
    L47:
        throw new IllegalStateException(kotlin.n0.d.o.m("Cannot happen in ", r2).toString());
    L37:
        if (H0(r3, r1) == false) goto L3;
        return g2.a();
    L49:
        return g2.f();
    L5:
        monitor-enter(r2);
    L27:
        th = move-exception;
        throw th;
    L7:
        if (((b) r2).i() == false) goto L11;
        h.a.f3.f0 r6 = g2.f();     // Catch: Throwable -> L27
        monitor-exit(r2);
        return r6;
    L11:
        boolean r5 = ((b) r2).g();     // Catch: Throwable -> L27
        if (r7 != null) goto L14;
        if (r5 == false) goto L14;
    L17:
        Throwable r8 = ((b) r2).f();     // Catch: Throwable -> L27
        if ((!r5) == false) goto L21;
        r0 = r8;
    L21:
        monitor-exit(r2);
        if (r0 == null) goto L26;
        s0(((b) r2).d(), r0);
    L26:
        return g2.a();
    L14:
        if (r1 != null) goto L16;
        r1 = M(r7);     // Catch: Throwable -> L27
    L16:
        ((b) r2).a(r1);     // Catch: Throwable -> L27
        goto L17
    }

    private final e2 p0(kotlin.n0.c.l<? super Throwable, kotlin.f0> r2, boolean r3) {
        e2 r0 = null;
        if (r3 == false) goto L10;
        if ((r2 instanceof z1) == false) goto L7;
        r0 = (z1) r2;
    L7:
        if (r0 != null) goto L25;
        r0 = new v1(r2);
    L25:
        r0.E(this);
        return r0;
    L10:
        if ((r2 instanceof e2) == false) goto L12;
        e2 r4 = (e2) r2;
    L13:
        if (r4 != null) goto L16;
    L23:
        if (r0 != null) goto L25;
        r0 = new w1(r2);
        goto L25
    L16:
        if (q0.a() == true) goto L18;
    L22:
        r0 = r4;
        goto L23
    L18:
        if ((!(r4 instanceof z1)) == true) goto L22;
        throw new AssertionError();
    L12:
        r4 = null;
        goto L13
    }

    public static final /* synthetic */ String r(f2 r0) {
        return r0.H();
    }

    private final u r0(h.a.f3.s r1) {
    L3:
        if (r1.w() == false) goto L5;
        r1 = r1.t();
    L5:
        r1 = r1.s();
        if (r1.w() == true) goto L5;
        if ((r1 instanceof u) == true) goto L11;
        if ((r1 instanceof j2) == false) goto L5;
        return null;
    L11:
        return (u) r1;
    }

    private final void s0(j2 r8, Throwable r9) {
        u0(r9);
        h.a.f3.s r0 = (h.a.f3.s) r8.r();
        b0 r2 = null;
    L4:
        if (kotlin.n0.d.o.a(r0, r8) == true) goto L17;
        if ((r0 instanceof z1) == false) goto L16;
        e2 r3 = (e2) r0;
        r3.C(r9);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        if (r2 != null) goto L13;
        b0 r5 = null;
    L14:
        if (r5 != null) goto L16;
        r2 = new b0("Exception in completion handler " + r3 + " for " + this, th);
        goto L16
    L13:
        kotlin.a.a(r2, th);
        r5 = r2;
    L16:
        r0 = r0.s();
        goto L4
    L17:
        if (r2 == null) goto L20;
        f0(r2);
    L20:
        G(r9);
    }

    public static final /* synthetic */ void t(f2 r0, b r1, u r2, Object r3) {
        r0.K(r1, r2, r3);
    }

    private final void t0(j2 r8, Throwable r9) {
        h.a.f3.s r0 = (h.a.f3.s) r8.r();
        b0 r2 = null;
    L4:
        if (kotlin.n0.d.o.a(r0, r8) == true) goto L17;
        if ((r0 instanceof e2) == false) goto L16;
        e2 r3 = (e2) r0;
        r3.C(r9);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        if (r2 != null) goto L13;
        b0 r5 = null;
    L14:
        if (r5 != null) goto L16;
        r2 = new b0("Exception in completion handler " + r3 + " for " + this, th);
        goto L16
    L13:
        kotlin.a.a(r2, th);
        r5 = r2;
    L16:
        r0 = r0.s();
        goto L4
    L17:
        if (r2 == null) goto L28;
        f0(r2);
        return;
    }

    private final boolean u(Object r2, j2 r3, e2 r4) {
        c r0 = new c(r4, this, r2);
    L3:
        int r1 = r3.t().B(r4, r3, r0);
        if (r1 == 1) goto L13;
        if (r1 != 2) goto L3;
        return false;
    L13:
        return true;
    }

    private final void v(Throwable r4, List<? extends Throwable> r5) {
        if (r5.size() > 1) goto L5;
        return;
    L5:
        Set r3 = Collections.newSetFromMap(new IdentityHashMap(r5.size()));
        if (q0.d() == true) goto L8;
        Throwable r0 = r4;
    L9:
        Iterator<? extends Throwable> r6 = r5.iterator();
    L11:
        if (r6.hasNext() == false) goto L23;
        Throwable r1 = r6.next();
        if (q0.d() == false) goto L16;
        r1 = h.a.f3.e0.n(r1);
    L16:
        if (r1 == r4) goto L11;
        if (r1 == r0) goto L11;
        if ((r1 instanceof CancellationException) == true) goto L11;
        if (r3.add(r1) == false) goto L11;
        kotlin.a.a(r4, r1);
        goto L11
    L23:
        return;
    L8:
        r0 = h.a.f3.e0.n(r4);
        goto L9
    }

    private final void x0(g1 r3) {
        j2 r0 = new j2();
        Object r1 = r0;
        if (r3.b() == true) goto L6;
        r1 = new r1(r0);
    L6:
        f17349f.compareAndSet(this, r3, r1);
    }

    private final void y0(e2 r3) {
        r3.n(new j2());
        h.a.f3.s r0 = r3.s();
        f17349f.compareAndSet(this, r3, r0);
    }

    @Override // h.a.x1
    public final CancellationException A() {
        Object r0 = c0();
        CancellationException r3 = null;
        if ((r0 instanceof b) == false) goto L13;
        Throwable r1 = ((b) r0).f();
        if (r1 == null) goto L8;
        r3 = D0(r1, kotlin.n0.d.o.m(r0.a(this), " is cancelling"));
    L8:
        if (r3 == null) goto L11;
        return r3;
    L11:
        throw new IllegalStateException(kotlin.n0.d.o.m("Job is still new or active: ", this).toString());
    L13:
        if ((r0 instanceof s1) == true) goto L20;
        if ((r0 instanceof y) == false) goto L18;
        return E0(this, ((y) r0).f17588a, null, 1, null);
    L18:
        return new y1(kotlin.n0.d.o.m(r0.a(this), " has completed normally"), null, this);
    L20:
        throw new IllegalStateException(kotlin.n0.d.o.m("Job is still new or active: ", this).toString());
    }

    public final void A0(t r1) {
        this._parentHandle = r1;
    }

    public void B(Throwable r1) {
        z(r1);
    }

    @Override // h.a.v
    public final void C(m2 r1) {
        z(r1);
    }

    protected final CancellationException D0(Throwable r2, String r3) {
        if ((r2 instanceof CancellationException) == false) goto L5;
        CancellationException r0 = (CancellationException) r2;
    L6:
        if (r0 == null) goto L8;
    L11:
        return r0;
    L8:
        if (r3 != null) goto L10;
        r3 = r(this);
    L10:
        r0 = new y1(r3, r2, this);
        goto L11
    L5:
        r0 = null;
        goto L6
    }

    public final String F0() {
        return q0() + '{' + C0(c0()) + '}';
    }

    protected String H() {
        return "Job was cancelled";
    }

    public boolean I(Throwable r3) {
        if ((r3 instanceof CancellationException) == false) goto L6;
        return true;
    L6:
        if (z(r3) == true) goto L8;
    L10:
        return false;
    L8:
        if (W() == false) goto L10;
        return true;
    }

    @Override // h.a.x1
    public final d1 L(kotlin.n0.c.l<? super Throwable, kotlin.f0> r3) {
        return x(false, true, r3);
    }

    public boolean W() {
        return true;
    }

    @Override // h.a.m2
    public CancellationException Y() {
        Object r0 = c0();
        CancellationException r2 = null;
        if ((r0 instanceof b) == false) goto L6;
        Throwable r1 = ((b) r0).f();
    L12:
        if ((r1 instanceof CancellationException) == false) goto L14;
        r2 = (CancellationException) r1;
    L14:
        if (r2 == null) goto L16;
        return r2;
    L16:
        return new y1(kotlin.n0.d.o.m("Parent job is ", C0(r0)), r1, this);
    L6:
        if ((r0 instanceof y) == false) goto L9;
        r1 = ((y) r0).f17588a;
        goto L12
    L9:
        if ((r0 instanceof s1) == true) goto L18;
        r1 = null;
        goto L12
    L18:
        throw new IllegalStateException(kotlin.n0.d.o.m("Cannot be cancelling child in this state: ", r0).toString());
    }

    public boolean Z() {
        return false;
    }

    @Override // h.a.x1, h.a.d3.v
    public void a(CancellationException r3) {
        if (r3 != null) goto L4;
        r3 = new y1(r(this), null, this);
    L4:
        B(r3);
    }

    @Override // h.a.x1
    public boolean b() {
        Object r1 = c0();
        if ((r1 instanceof s1) == true) goto L5;
    L7:
        return false;
    L5:
        if (((s1) r1).b() == false) goto L7;
        return true;
    }

    public final t b0() {
        return (t) this._parentHandle;
    }

    public final Object c0() {
    L2:
        Object r0 = this._state;
        if ((r0 instanceof h.a.f3.a0) == false) goto L4;
        ((h.a.f3.a0) r0).c(this);
        goto L2
    L4:
        return r0;
    }

    protected boolean e0(Throwable r1) {
        return false;
    }

    public void f0(Throwable r1) {
        throw r1;
    }

    @Override // kotlin.k0.g
    public <R> R fold(R r1, kotlin.n0.c.p<? super R, ? super kotlin.k0.g.b, ? extends R> r2) {
        return (R) x1.a.b(this, r1, r2);
    }

    @Override // h.a.x1
    public final t g0(v r7) {
        return (t) x1.a.d(this, true, false, new u(r7), 2, null);
    }

    @Override // kotlin.k0.g.b, kotlin.k0.g
    public <E extends kotlin.k0.g.b> E get(kotlin.k0.g.c<E> r1) {
        return (E) x1.a.c(this, r1);
    }

    @Override // kotlin.k0.g.b
    public final kotlin.k0.g.c<?> getKey() {
        return x1.f17584d;
    }

    protected final void h0(x1 r2) {
        if (q0.a() == true) goto L5;
    L12:
        if (r2 != null) goto L15;
        A0(k2.f17534f);
        return;
    L15:
        r2.start();
        t r3 = r2.g0(this);
        A0(r3);
        if (j0() == false) goto L19;
        r3.dispose();
        A0(k2.f17534f);
        return;
    L19:
        return;
    L5:
        if (b0() != null) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == true) goto L12;
        throw new AssertionError();
    L7:
        r0 = false;
        goto L8
    }

    public final boolean i0() {
        Object r1 = c0();
        if ((r1 instanceof y) == false) goto L5;
    L10:
        return true;
    L5:
        if ((r1 instanceof b) == true) goto L7;
    L9:
        return false;
    L7:
        if (((b) r1).g() == false) goto L9;
        goto L9
    }

    public final boolean j0() {
        return !(c0() instanceof s1);
    }

    protected boolean k0() {
        return false;
    }

    @Override // kotlin.k0.g
    public kotlin.k0.g minusKey(kotlin.k0.g.c<?> r1) {
        return x1.a.e(this, r1);
    }

    public final Object o0(Object r4) {
    L2:
        Object r0 = I0(c0(), r4);
        if (r0 == g2.a()) goto L9;
        if (r0 == g2.b()) goto L2;
        return r0;
    L9:
        throw new IllegalStateException("Job " + this + " is already complete or completing, but is being completed with " + r4, T(r4));
    }

    @Override // kotlin.k0.g
    public kotlin.k0.g plus(kotlin.k0.g r1) {
        return x1.a.f(this, r1);
    }

    public String q0() {
        return r0.a(this);
    }

    @Override // h.a.x1
    public final Object s(kotlin.k0.d<? super kotlin.f0> r2) {
        if (l0() == true) goto L6;
        b2.g(r2.getContext());
        return kotlin.f0.f18324a;
    L6:
        Object r1 = m0(r2);
        if (r1 != kotlin.k0.i.b.c()) goto L10;
        return r1;
    L10:
        return kotlin.f0.f18324a;
    }

    @Override // h.a.x1
    public final boolean start() {
    L2:
        int r0 = B0(c0());
        if (r0 == 0) goto L8;
        if (r0 != 1) goto L2;
        return true;
    L8:
        return false;
    }

    public String toString() {
        return F0() + '@' + r0.b(this);
    }

    protected void u0(Throwable r1) {
    }

    protected void v0(Object r1) {
    }

    protected void w(Object r1) {
    }

    protected void w0() {
    }

    @Override // h.a.x1
    public final d1 x(boolean r7, boolean r8, kotlin.n0.c.l<? super Throwable, kotlin.f0> r9) {
        e2 r0 = p0(r9, r7);
    L3:
        Object r1 = c0();
        if ((r1 instanceof g1) == true) goto L5;
        Throwable r3 = null;
        if ((r1 instanceof s1) == false) goto L48;
        j2 r2 = ((s1) r1).d();
        if (r2 == null) goto L15;
        d1 r4 = k2.f17534f;
        if (r7 == false) goto L41;
        if ((r1 instanceof b) == false) goto L41;
        monitor-enter(r1);
        r3 = ((b) r1).f();     // Catch: Throwable -> L38
        if (r3 == null) goto L28;
        if ((r9 instanceof u) == false) goto L35;
        if (((b) r1).h() == false) goto L28;
    L35:
        kotlin.f0 r5 = kotlin.f0.f18324a;     // Catch: Throwable -> L38
        monitor-exit(r1);
    L28:
        if (u(r1, r2, r0) == false) goto L29;
        if (r3 == null) goto L32;
        r4 = r0;
        goto L35
    L32:
        monitor-exit(r1);
        return r0;
    L29:
        monitor-exit(r1);
    L38:
        th = move-exception;
        throw th;
    L41:
        if (r3 != null) goto L42;
        if (u(r1, r2, r0) == false) goto L3;
        return r0;
    L42:
        if (r8 == false) goto L44;
        r9.invoke(r3);
    L44:
        return r4;
    L15:
        Objects.requireNonNull(r1, "null cannot be cast to non-null type kotlinx.coroutines.JobNode");
        y0((e2) r1);
        goto L3
    L48:
        if (r8 == false) goto L58;
        if ((r1 instanceof y) == false) goto L52;
        y r6 = (y) r1;
    L53:
        if (r6 == null) goto L56;
        r3 = r6.f17588a;
    L56:
        r9.invoke(r3);
        goto L58
    L52:
        r6 = null;
    L58:
        return k2.f17534f;
    L5:
        g1 r10 = (g1) r1;
        if (r10.b() == true) goto L8;
        x0(r10);
        goto L3
    L8:
        if (f17349f.compareAndSet(this, r1, r0) == false) goto L3;
        return r0;
    }

    public final boolean y(Throwable r1) {
        return z(r1);
    }

    public final boolean z(Object r4) {
        Object r0 = g2.a();
        if (Z() == false) goto L8;
        r0 = D(r4);
        if (r0 != g2.f17440b) goto L8;
        return true;
    L8:
        if (r0 != g2.a()) goto L11;
        r0 = n0(r4);
    L11:
        if (r0 != g2.a()) goto L14;
        return true;
    L14:
        if (r0 != g2.f17440b) goto L17;
        return true;
    L17:
        if (r0 != g2.f()) goto L19;
        return false;
    L19:
        w(r0);
        return true;
    }

    public final void z0(e2 r4) {
    L2:
        Object r0 = c0();
        if ((r0 instanceof e2) == false) goto L10;
        if (r0 != r4) goto L5;
        if (f17349f.compareAndSet(this, r0, g2.c()) == false) goto L2;
        return;
    L5:
        return;
    L10:
        if ((r0 instanceof s1) == true) goto L12;
        return;
    L12:
        if (((s1) r0).d() == null) goto L20;
        r4.x();
        return;
    }
}
