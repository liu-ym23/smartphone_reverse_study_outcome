package com.obric.oui.forms;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.SpannableString;
import android.text.method.DigitsKeyListener;
import android.text.method.KeyListener;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.ViewGroupKt;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.oui.layout.OUIConstraintLayout;
import com.obric.oui.text.OTextView;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.Iterator;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.n0.c.r;
import kotlin.n0.d.o;
import kotlin.n0.d.q;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Þ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001:\u0006ð\u0001Å\u0001·\u0001B.\b\u0007\u0012\b\u0010\u008d\u0002\u001a\u00030\u008c\u0002\u0012\f\b\u0002\u0010\u008f\u0002\u001a\u0005\u0018\u00010\u008e\u0002\u0012\t\b\u0002\u0010\u0090\u0002\u001a\u00020\u0016¢\u0006\u0006\b\u0091\u0002\u0010\u0092\u0002J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000f\u0010\rJ\u0017\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0015\u0010\rJ/\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0018\u001a\u00020\u00162\b\b\u0002\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ/\u0010\u001e\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0018\u001a\u00020\u00162\b\b\u0002\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001e\u0010\u001dJ'\u0010#\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020!2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b#\u0010$J\u0017\u0010%\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020!H\u0002¢\u0006\u0004\b%\u0010&J\u0017\u0010'\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020!H\u0002¢\u0006\u0004\b'\u0010&J\u0017\u0010(\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020!H\u0002¢\u0006\u0004\b(\u0010&J'\u0010-\u001a\u00020\u00162\u0006\u0010)\u001a\u00020\u00162\u0006\u0010*\u001a\u00020\u00162\u0006\u0010,\u001a\u00020+H\u0002¢\u0006\u0004\b-\u0010.J\u000f\u0010/\u001a\u00020+H\u0002¢\u0006\u0004\b/\u00100J\u0017\u00102\u001a\u00020+2\u0006\u00101\u001a\u00020!H\u0002¢\u0006\u0004\b2\u00103J\u000f\u00104\u001a\u00020\u0016H\u0016¢\u0006\u0004\b4\u00105J\u0019\u00108\u001a\u00020\u00162\b\u00107\u001a\u0004\u0018\u000106H\u0016¢\u0006\u0004\b8\u00109J\u0019\u0010<\u001a\u00020\u00022\b\u0010;\u001a\u0004\u0018\u00010:H\u0016¢\u0006\u0004\b<\u0010=J\u0017\u0010@\u001a\u00020\u00022\b\u0010?\u001a\u0004\u0018\u00010>¢\u0006\u0004\b@\u0010AJ\u0015\u0010C\u001a\u00020\u00022\u0006\u0010B\u001a\u00020\u0016¢\u0006\u0004\bC\u0010DJ\u0015\u0010F\u001a\u00020\u00022\u0006\u0010E\u001a\u00020\u0016¢\u0006\u0004\bF\u0010DJ\r\u0010G\u001a\u00020\u0016¢\u0006\u0004\bG\u00105J\u0015\u0010J\u001a\u00020\u00022\u0006\u0010I\u001a\u00020H¢\u0006\u0004\bJ\u0010KJ\u000f\u0010L\u001a\u0004\u0018\u00010H¢\u0006\u0004\bL\u0010MJ\u0017\u0010O\u001a\u00020\u00022\u0006\u0010N\u001a\u00020\bH\u0016¢\u0006\u0004\bO\u0010\rJ\u0015\u0010Q\u001a\u00020\u00022\u0006\u0010P\u001a\u00020\b¢\u0006\u0004\bQ\u0010\rJ\u0015\u0010S\u001a\u00020\u00022\u0006\u0010R\u001a\u00020\b¢\u0006\u0004\bS\u0010\rJ\u0017\u0010U\u001a\u00020\u00022\b\u0010T\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\bU\u0010\u0013J\u0015\u0010W\u001a\u00020\u00022\u0006\u0010V\u001a\u00020\b¢\u0006\u0004\bW\u0010\rJ\u0015\u0010X\u001a\u00020\u00022\u0006\u0010V\u001a\u00020\b¢\u0006\u0004\bX\u0010\rJ\u0015\u0010Y\u001a\u00020\u00022\u0006\u0010V\u001a\u00020\b¢\u0006\u0004\bY\u0010\rJ\u0015\u0010[\u001a\u00020\u00022\u0006\u0010Z\u001a\u00020\u0016¢\u0006\u0004\b[\u0010DJ\u0011\u0010\\\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\\\u0010]J\u0017\u0010_\u001a\u00020\u00022\b\u0010^\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b_\u0010\u0013J\u0017\u0010a\u001a\u00020\u00022\b\u0010`\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\ba\u0010\u0013J\u0015\u0010c\u001a\u00020\u00022\u0006\u0010b\u001a\u00020\b¢\u0006\u0004\bc\u0010\rJ!\u0010g\u001a\u00020\u00022\u0012\u0010f\u001a\u000e\u0012\u0004\u0012\u00020e\u0012\u0004\u0012\u00020\u00020d¢\u0006\u0004\bg\u0010hJ!\u0010i\u001a\u00020\u00022\u0012\u0010f\u001a\u000e\u0012\u0004\u0012\u00020e\u0012\u0004\u0012\u00020\u00020d¢\u0006\u0004\bi\u0010hJ\u0015\u0010k\u001a\u00020\u00022\u0006\u0010j\u001a\u00020\u0016¢\u0006\u0004\bk\u0010DJ\u0015\u0010m\u001a\u00020\u00022\u0006\u0010l\u001a\u00020\u0016¢\u0006\u0004\bm\u0010DJ\u0017\u0010n\u001a\u00020\u00022\u0006\u0010l\u001a\u00020\u0016H\u0016¢\u0006\u0004\bn\u0010DJ\r\u0010o\u001a\u00020\u0016¢\u0006\u0004\bo\u00105J\u0015\u0010p\u001a\u00020\u00022\u0006\u0010V\u001a\u00020\b¢\u0006\u0004\bp\u0010\rJ\u0017\u0010q\u001a\u00020\u00022\b\u0010^\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\bq\u0010\u0013J\u0017\u0010s\u001a\u00020\u00022\b\b\u0001\u0010r\u001a\u00020\u0016¢\u0006\u0004\bs\u0010DJ\u0015\u0010t\u001a\u00020\u00022\u0006\u0010N\u001a\u00020\b¢\u0006\u0004\bt\u0010\rJ\u0017\u0010w\u001a\u00020\u00022\b\u0010v\u001a\u0004\u0018\u00010u¢\u0006\u0004\bw\u0010xJ\u0017\u0010z\u001a\u00020\u00022\b\u0010v\u001a\u0004\u0018\u00010y¢\u0006\u0004\bz\u0010{J\u0017\u0010}\u001a\u00020\u00022\b\u0010|\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b}\u0010\u0013J\u0015\u0010~\u001a\u00020\u00022\u0006\u0010V\u001a\u00020\b¢\u0006\u0004\b~\u0010\rJ\u0017\u0010\u007f\u001a\u00020\u00022\b\u0010|\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u007f\u0010\u0013J\u0017\u0010\u0080\u0001\u001a\u00020\u00022\u0006\u0010V\u001a\u00020\b¢\u0006\u0005\b\u0080\u0001\u0010\rJ\u001a\u0010\u0083\u0001\u001a\u00020\u00022\b\u0010\u0082\u0001\u001a\u00030\u0081\u0001¢\u0006\u0006\b\u0083\u0001\u0010\u0084\u0001J\u001e\u0010\u0087\u0001\u001a\u00020\b2\n\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u0085\u0001H\u0016¢\u0006\u0006\b\u0087\u0001\u0010\u0088\u0001J\u001e\u0010\u008a\u0001\u001a\u00020\b2\n\u0010\u0089\u0001\u001a\u0005\u0018\u00010\u0085\u0001H\u0016¢\u0006\u0006\b\u008a\u0001\u0010\u0088\u0001J\u001e\u0010\u008b\u0001\u001a\u00020\b2\n\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u0085\u0001H\u0016¢\u0006\u0006\b\u008b\u0001\u0010\u0088\u0001J\u0015\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u008c\u0001H\u0016¢\u0006\u0006\b\u008d\u0001\u0010\u008e\u0001J\u001d\u0010\u008f\u0001\u001a\u00020\u00022\t\u0010v\u001a\u0005\u0018\u00010\u008c\u0001H\u0016¢\u0006\u0006\b\u008f\u0001\u0010\u0090\u0001J\u001b\u0010\u0091\u0001\u001a\u00020\u00022\b\u0010v\u001a\u0004\u0018\u00010uH\u0016¢\u0006\u0005\b\u0091\u0001\u0010xJ\u0018\u0010\u0093\u0001\u001a\u00020\u00022\u0007\u0010\u0092\u0001\u001a\u00020\u0016¢\u0006\u0005\b\u0093\u0001\u0010DJ\u0018\u0010\u0095\u0001\u001a\u00020\u00022\u0007\u0010\u0094\u0001\u001a\u00020\b¢\u0006\u0005\b\u0095\u0001\u0010\rJ$\u0010\u0098\u0001\u001a\u00020\u00022\u0007\u0010\u0096\u0001\u001a\u00020\u00162\u0007\u0010\u0097\u0001\u001a\u00020\u0016H\u0014¢\u0006\u0006\b\u0098\u0001\u0010\u0099\u0001J?\u0010\u009f\u0001\u001a\u00020\u00022\u0007\u0010\u009a\u0001\u001a\u00020\b2\u0007\u0010\u009b\u0001\u001a\u00020\u00162\u0007\u0010\u009c\u0001\u001a\u00020\u00162\u0007\u0010\u009d\u0001\u001a\u00020\u00162\u0007\u0010\u009e\u0001\u001a\u00020\u0016H\u0014¢\u0006\u0006\b\u009f\u0001\u0010 \u0001R\u0018\u0010¢\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u001e\u0010¡\u0001R\u001b\u0010¥\u0001\u001a\u0004\u0018\u00010y8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b£\u0001\u0010¤\u0001R\u0019\u0010§\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¦\u0001\u0010¡\u0001R\u001b\u0010ª\u0001\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¨\u0001\u0010©\u0001R\u0019\u0010\u00ad\u0001\u001a\u00030«\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bq\u0010¬\u0001R\u0019\u0010¯\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b®\u0001\u0010¡\u0001R\u001c\u0010²\u0001\u001a\u0005\u0018\u00010\u0081\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b°\u0001\u0010±\u0001R'\u0010¶\u0001\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0006\b³\u0001\u0010¡\u0001\u001a\u0005\b´\u0001\u0010\n\"\u0005\bµ\u0001\u0010\rR\u0018\u0010¸\u0001\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b·\u0001\u0010~R\u0018\u0010º\u0001\u001a\u00020+8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b¹\u0001\u0010\tR\u001b\u0010½\u0001\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b»\u0001\u0010¼\u0001R\u001a\u0010¿\u0001\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0015\u0010¾\u0001R\u0019\u0010Á\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÀ\u0001\u0010¡\u0001R\u0017\u0010B\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0080\u0001\u0010~R\u001a\u0010Ã\u0001\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b-\u0010Â\u0001R\u0018\u0010Ä\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\t\u0010¡\u0001R\u0018\u0010Æ\u0001\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bÅ\u0001\u0010~R\u0019\u0010Ç\u0001\u001a\u00030«\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b'\u0010¬\u0001R\u001a\u0010Ë\u0001\u001a\u00030È\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÉ\u0001\u0010Ê\u0001R\u0018\u0010Í\u0001\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bÌ\u0001\u0010~R\u0018\u0010Î\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b<\u0010¡\u0001R\u001a\u0010Ð\u0001\u001a\u00030È\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÏ\u0001\u0010Ê\u0001R\u001b\u0010Ó\u0001\u001a\u0004\u0018\u00010u8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÑ\u0001\u0010Ò\u0001R\u0019\u0010Õ\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÔ\u0001\u0010¡\u0001R\u001a\u0010Ö\u0001\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b2\u0010Â\u0001R\u001e\u0010Û\u0001\u001a\u00030×\u00018\u0006@\u0006¢\u0006\u000f\n\u0005\b\u0003\u0010Ø\u0001\u001a\u0006\bÙ\u0001\u0010Ú\u0001R\u0019\u0010Ü\u0001\u001a\u00030È\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b%\u0010Ê\u0001R\u001b\u0010ß\u0001\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÝ\u0001\u0010Þ\u0001R\u001a\u0010à\u0001\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b8\u0010Â\u0001R\u0018\u0010â\u0001\u001a\u00020e8\u0002@\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u000f\u0010á\u0001R\u0019\u0010å\u0001\u001a\u00030ã\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0006\u0010ä\u0001R\u0018\u0010æ\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0012\u0010¡\u0001R\u0019\u0010è\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bç\u0001\u0010¡\u0001R\u0018\u0010é\u0001\u001a\u00020e8\u0002@\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\f\u0010á\u0001R\u001a\u0010ê\u0001\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0005\u0010Â\u0001R\u001a\u0010ì\u0001\u001a\u00030ã\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\bë\u0001\u0010ä\u0001R\u0019\u0010í\u0001\u001a\u00030ã\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0007\u0010ä\u0001R\u0019\u0010ï\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bî\u0001\u0010¡\u0001R\u0019\u0010ñ\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bð\u0001\u0010¡\u0001R\u0019\u0010ó\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bò\u0001\u0010¡\u0001R\u0019\u0010ö\u0001\u001a\u00030ô\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b(\u0010õ\u0001R\u0019\u0010÷\u0001\u001a\u00030ã\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b#\u0010ä\u0001R\u0018\u0010ù\u0001\u001a\u00020+8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bø\u0001\u0010\tR\u0018\u0010û\u0001\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bú\u0001\u0010~R\u0018\u0010R\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bü\u0001\u0010¡\u0001R\u0019\u0010ÿ\u0001\u001a\u00030ý\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b~\u0010þ\u0001R\u001a\u0010\u0081\u0002\u001a\u00030È\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0080\u0002\u0010Ê\u0001R\u0018\u0010\u0083\u0002\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0082\u0002\u0010~R\u0018\u0010\u0084\u0002\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bv\u0010¡\u0001R\u001b\u0010\u0086\u0002\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0085\u0002\u0010¼\u0001R\u0019\u0010\u0088\u0002\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0087\u0002\u0010¡\u0001R\u0019\u0010\u008a\u0002\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0089\u0002\u0010¡\u0001R\u0019\u0010`\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u001c\u0010Â\u0001R\u0017\u0010\u008b\u0002\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u0010~¨\u0006\u0093\u0002"}, d2 = {"Lcom/obric/oui/forms/OInputView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lkotlin/f0;", "M", "()V", "E", "P", "Q", "", "F", "()Z", "focus", "O", "(Z)V", "pressed", "N", "", "scene", BaseSwitches.V, "(Ljava/lang/String;)V", "hasFocus", "G", "", "labelTextColor", "inputHintTextColor", "", TypedValues.TransitionType.S_DURATION, "Landroid/animation/ValueAnimator;", "A", "(IIJ)Landroid/animation/ValueAnimator;", "y", "Lcom/obric/oui/forms/OInputView$h;", WsConstants.KEY_CONNECTION_STATE, "Landroid/widget/TextView;", "fakeLabel", "R", "(Lcom/obric/oui/forms/OInputView$h;Landroid/widget/TextView;Ljava/lang/String;)V", "K", "(Landroid/widget/TextView;)V", "L", "J", "startColor", "endColor", "", "ratio", "w", "(IIF)I", "getFakeInputOffsetY", "()F", "vFakeInput", "D", "(Landroid/widget/TextView;)F", "getContentViewRes", "()I", "", "s", "C", "(Ljava/lang/CharSequence;)I", "Landroid/text/Editable;", "editable", "x", "(Landroid/text/Editable;)V", "Landroid/text/method/KeyListener;", "keyListener", "setKeyListener", "(Landroid/text/method/KeyListener;)V", "radius", "setRadius", "(I)V", WsConstants.KEY_CONNECTION_TYPE, "setInputType", "getInputType", "Lcom/obric/oui/forms/OEditText$a;", "commitCompletionListener", "setCommitCompletionListener", "(Lcom/obric/oui/forms/OEditText$a;)V", "getCommitCompletionListener", "()Lcom/obric/oui/forms/OEditText$a;", "enabled", "setEnabled", WsConstants.KEY_CONNECTION_ERROR, "setErrorState", "inScrollableView", "setIsInScrollableView", "label", "setLabel", "show", "setShowLabel", "setShowLabelAnim", "setShowLabelIcon", "height", "setInputHeight", "getText", "()Ljava/lang/String;", "text", "setText", "hint", "setHint", "single", "setSingleLine", "Lkotlin/Function1;", "Landroid/widget/FrameLayout;", "creator", "setLeftView", "(Lkotlin/n0/c/l;)V", "setActionView", "max", "setMaxLines", "limit", "setLimitCountValue", "setLimitCount", "getLimitCount", "setShowLimitIndicator", "S", "mode", "setInputMode", "setComboInputEnabled", "Landroid/view/View$OnClickListener;", "l", "setOnComboArrowClickListener", "(Landroid/view/View$OnClickListener;)V", "Lcom/obric/oui/forms/OInputView$j;", "setOnTextExceedLengthListener", "(Lcom/obric/oui/forms/OInputView$j;)V", "tip", "setErrorTip", "I", "setCommonTip", "H", "Lcom/obric/oui/forms/OInputView$i;", "listener", "setOnTextClearedListener", "(Lcom/obric/oui/forms/OInputView$i;)V", "Landroid/view/MotionEvent;", "ev", "onInterceptTouchEvent", "(Landroid/view/MotionEvent;)Z", NotificationCompat.CATEGORY_EVENT, "onTouchEvent", "dispatchTouchEvent", "Landroid/view/View$OnFocusChangeListener;", "getOnFocusChangeListener", "()Landroid/view/View$OnFocusChangeListener;", "setOnFocusChangeListener", "(Landroid/view/View$OnFocusChangeListener;)V", "setOnClickListener", "resId", "setBgResId", "hide", "setAlwaysHideEye", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "changed", "left", "top", "right", "bottom", "onLayout", "(ZIIII)V", "Z", "isEnable", "d0", "Lcom/obric/oui/forms/OInputView$j;", "onTextExceedLengthListener", "r", "showLimitIndicator", "a0", "Landroid/widget/TextView;", "vFakeLabel", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "vEye", "f", "comboInputEnabled", "c0", "Lcom/obric/oui/forms/OInputView$i;", "onTextClearedListener", "f0", "getAutoHideSoftInputWhenLoseFocus", "setAutoHideSoftInputWhenLoseFocus", "autoHideSoftInputWhenLoseFocus", "j", "gravity", "n", "lastScrollX", "j0", "Landroid/animation/ValueAnimator;", "labelHideAnimator", "Ljava/lang/CharSequence;", "digits", "b0", "shouldDispatchToInput", "Ljava/lang/String;", "insideLabel", "showCommonTip", "i", "maxLines", "vTitleIcon", "Lcom/obric/oui/text/OTextView;", "V", "Lcom/obric/oui/text/OTextView;", "vCommonTip", "g", "inputMode", "isError", "W", "vLimitIndicator", "e0", "Landroid/view/View$OnClickListener;", "onComboArrowClickListener", "k", "transparentBorder", "errorTip", "Lcom/obric/oui/forms/OEditText;", "Lcom/obric/oui/forms/OEditText;", "getVInput", "()Lcom/obric/oui/forms/OEditText;", "vInput", "vTitle", "z", "Ljava/lang/Integer;", "inputHeight", "initText", "Landroid/widget/FrameLayout;", "vLeftViewContainer", "Landroid/view/View;", "Landroid/view/View;", "vActionContainer", "showLabelIcon", "t", "showLabel", "vCustomActionContainer", "commonTip", "T", "vInputResizer", "vClear", "p", "autoShowClear", "h", "singleLine", "q", "showResizer", "Landroid/widget/LinearLayout;", "Landroid/widget/LinearLayout;", "vTitleContainer", "vComboArrow", "m", "lastScrollY", "g0", "bgResId", "o", "Lcom/obric/oui/layout/OUIConstraintLayout;", "Lcom/obric/oui/layout/OUIConstraintLayout;", "vBorderContainer", "U", "vErrorTip", "B", "inputType", "transparentBg", "i0", "labelShowAnimator", "h0", "alwaysHideEye", "u", "showLabelAnim", "limitCount", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "OUI_standardRelease"}, k = 1, mv = {1, 1, 15})
@SuppressLint({"ClickableViewAccessibility"})
public class OInputView extends ConstraintLayout {
    private String A;
    private int B;
    private String C;
    private String D;
    private String E;
    private boolean F;
    private CharSequence G;
    private int H;
    private final OUIConstraintLayout I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private final LinearLayout f11023J;
    private final OTextView K;
    private final ImageView L;
    private final OEditText M;
    private final FrameLayout N;
    private final FrameLayout O;
    private final View P;
    private final View Q;
    private final View R;
    private final ImageView S;
    private final View T;
    private final OTextView U;
    private final OTextView V;
    private final OTextView W;
    private TextView a0;
    private boolean b0;
    private i c0;
    private j d0;
    private View.OnClickListener e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f11024f;
    private boolean f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f11025g;
    private int g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f11026h;
    private boolean h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f11027i;
    private ValueAnimator i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f11028j;
    private ValueAnimator j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f11029k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f11030l;
    private float m;
    private float n;
    private boolean o;
    private boolean p;
    private boolean q;
    private boolean r;
    private int s;
    private boolean t;
    private boolean u;
    private boolean v;
    private String w;
    private boolean x;
    private boolean y;
    private Integer z;

    static final class a extends q implements kotlin.n0.c.l<Boolean, f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ OInputView f11031f;

        a(OInputView r1) {
            this.f11031f = r1;
            super(1);
        }

        public final void a(boolean r3) {
            OInputView r0 = this.f11031f;
            if (r3 == false) goto L6;
            OInputView.p(r0);
        L8:
            OInputView.s(this.f11031f);
            OInputView.t(this.f11031f);
            OInputView.r(this.f11031f, r3);
            OInputView.q(this.f11031f, false);
            OInputView.o(this.f11031f, r3);
            return;
        L6:
            if (r0.getAutoHideSoftInputWhenLoseFocus() == false) goto L8;
            OInputView.m(this.f11031f);
            goto L8
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ f0 invoke(Boolean r1) {
            a(r1.booleanValue());
            return f0.f18324a;
        }
    }

    static final class b extends q implements kotlin.n0.c.l<MotionEvent, f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ OInputView f11032f;

        b(OInputView r1) {
            this.f11032f = r1;
            super(1);
        }

        public final void a(MotionEvent r4) {
            if (r4 == null) goto L4;
            Integer r5 = Integer.valueOf(r4.getActionMasked());
        L6:
            if (r5 == null) goto L12;
            if (r5.intValue() != 0) goto L12;
            OInputView.q(this.f11032f, true);
            return;
        L12:
            if (r5 != null) goto L15;
        L17:
            if (r5 != null) goto L20;
            return;
        L20:
            if (r5.intValue() != 1) goto L24;
        L21:
            OInputView.q(this.f11032f, false);
            return;
        L24:
            return;
        L15:
            if (r5.intValue() != 3) goto L17;
        L4:
            r5 = null;
            goto L6
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ f0 invoke(MotionEvent r1) {
            a(r1);
            return f0.f18324a;
        }
    }

    static final class c extends q implements r<CharSequence, Integer, Integer, Integer, f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ OInputView f11033f;

        c(OInputView r1) {
            this.f11033f = r1;
            super(4);
        }

        @Override // kotlin.n0.c.r
        public /* bridge */ /* synthetic */ f0 invoke(CharSequence r1, Integer r2, Integer r3, Integer r4) {
            invoke(r1, r2.intValue(), r3.intValue(), r4.intValue());
            return f0.f18324a;
        }

        public final void invoke(CharSequence r3, int r4, int r5, int r6) {
            if (OInputView.h(this.f11033f) <= 0) goto L20;
            int r7 = this.f11033f.C(r3);
            OInputView r8 = this.f11033f;
            boolean r0 = true;
            if (r7 <= OInputView.h(r8)) goto L7;
            boolean r9 = true;
        L8:
            r8.setErrorState(r9);
            OInputView r10 = this.f11033f;
            if (r3 == null) goto L11;
            String r11 = r3.toString();
        L12:
            r10.S(r11);
            OInputView r12 = this.f11033f;
            r12.I(OInputView.n(r12));
            OInputView r13 = this.f11033f;
            if (OInputView.k(r13) == true) goto L15;
        L17:
            r0 = false;
        L18:
            r13.H(r0);
            return;
        L15:
            if (OInputView.n(this.f11033f) == true) goto L17;
        L11:
            r11 = null;
            goto L12
        L7:
            r9 = false;
            goto L8
        }
    }

    static final class d extends q implements kotlin.n0.c.l<Editable, f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ OInputView f11034f;

        d(OInputView r1) {
            this.f11034f = r1;
            super(1);
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ f0 invoke(Editable r1) {
            invoke2(r1);
            return f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Editable r6) {
            this.f11034f.x(r6);
            if (OInputView.h(this.f11034f) <= 0) goto L19;
            int r0 = this.f11034f.C(r6);
            OInputView r1 = this.f11034f;
            boolean r3 = true;
            if (r0 <= OInputView.h(r1)) goto L7;
            boolean r2 = true;
        L8:
            r1.setErrorState(r2);
            OInputView r4 = this.f11034f;
            r4.I(OInputView.n(r4));
            OInputView r5 = this.f11034f;
            if (OInputView.k(r5) == true) goto L11;
        L13:
            r3 = false;
        L14:
            r5.H(r3);
            if (r0 <= OInputView.h(this.f11034f)) goto L19;
            j r7 = OInputView.j(this.f11034f);
            if (r7 == null) goto L19;
            r7.a(String.valueOf(r6));
            goto L19
        L11:
            if (OInputView.n(this.f11034f) == true) goto L13;
        L7:
            r2 = false;
        L19:
            OInputView.s(this.f11034f);
            OInputView.t(this.f11034f);
        }
    }

    static final class e implements View.OnClickListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ OInputView f11035f;

        e(OInputView r1) {
            this.f11035f = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            i r3 = OInputView.i(this.f11035f);
            if (r3 == null) goto L9;
            Editable r0 = this.f11035f.getVInput().getText();
            if (r0 == null) goto L7;
            String r1 = r0.toString();
        L8:
            r3.b(r1);
            goto L9
        L7:
            r1 = null;
        L9:
            this.f11035f.setText("");
            i r4 = OInputView.i(this.f11035f);
            if (r4 == null) goto L12;
            r4.a();
        L12:
            OInputView.s(this.f11035f);
        }
    }

    static final class f implements View.OnClickListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ OInputView f11036f;

        f(OInputView r1) {
            this.f11036f = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            if (OInputView.g(this.f11036f) != this.f11036f.getVInput().getInputType()) goto L5;
            OInputView.l(this.f11036f).setImageResource(com.obric.common.oui.e.z);
            OEditText r3 = this.f11036f.getVInput();
            int r0 = this.f11036f.getVInput().getInputType() | 144;
        L6:
            r3.setInputType(r0);
            if (this.f11036f.getVInput().hasFocus() == false) goto L14;
            OEditText r4 = this.f11036f.getVInput();
            Editable r1 = this.f11036f.getVInput().getText();
            if (r1 == null) goto L11;
            int r5 = r1.length();
        L12:
            r4.setSelection(r5);
            return;
        L11:
            r5 = 0;
            goto L12
        L14:
            return;
        L5:
            OInputView.l(this.f11036f).setImageResource(com.obric.common.oui.e.y);
            r3 = this.f11036f.getVInput();
            r0 = OInputView.g(this.f11036f);
            goto L6
        }
    }

    static final class g implements View.OnClickListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ OInputView f11037f;

        g(OInputView r1) {
            this.f11037f = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            this.f11037f.getVInput().requestFocus();
            if (this.f11037f.getVInput().hasFocus() == true) goto L5;
        L7:
            OInputView.p(this.f11037f);
            return;
        L5:
            if (this.f11037f.getVInput().isCursorVisible() == true) goto L7;
            this.f11037f.getVInput().setCursorVisible(true);
            goto L7
        }
    }

    public static final enum h extends Enum<h> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final h f11038f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final h f11039g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final h f11040h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final /* synthetic */ h[] f11041i = null;

        static {
            h r1 = new h("REAL_LABEL_SHOW", 0);
            f11038f = r1;
            h r2 = new h("FAKE_LABEL_SHOW", 1);
            f11039g = r2;
            h r3 = new h("LABEL_NONE", 2);
            f11040h = r3;
            f11041i = new h[]{r1, r2, r3};
        }

        private h(String r1, int r2) {
            super(r1, r2);
        }

        public static h valueOf(String r1) {
            return (h) Enum.valueOf(h.class, r1);
        }

        public static h[] values() {
            return (h[]) f11041i.clone();
        }
    }

    public interface i {
        void a();

        void b(String r1);
    }

    public interface j {
        void a(String r1);
    }

    static final class k implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OInputView f11042a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ float f11043b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f11044c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f11045d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ float f11046e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ TextView f11047f;

        k(OInputView r1, float r2, int r3, int r4, float r5, TextView r6) {
            this.f11042a = r1;
            this.f11043b = r2;
            this.f11044c = r3;
            this.f11045d = r4;
            this.f11046e = r5;
            this.f11047f = r6;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r5) {
            o.f(r5, "animation");
            Object r6 = r5.getAnimatedValue();
            Objects.requireNonNull(r6, "null cannot be cast to non-null type kotlin.Float");
            float r7 = ((Float) r6).floatValue();
            float r0 = this.f11043b;
            float r1 = r0 + ((0 - r0) * r7);
            int r2 = OInputView.f(this.f11042a, this.f11044c, this.f11045d, r7);
            float r3 = this.f11046e;
            float r4 = r3 + ((1.0f - r3) * r7);
            this.f11047f.setTextColor(r2);
            this.f11047f.setScaleX(r4);
            this.f11047f.setScaleY(r4);
            this.f11047f.setTranslationY(r1);
            d.g.d.f.f.b.i("OInputView", "progress: " + r7 + ", transY: " + r1 + ", scale: " + r4);
        }
    }

    public static final class l extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OInputView f11048a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ TextView f11049b;

        l(OInputView r1, TextView r2) {
            this.f11048a = r1;
            this.f11049b = r2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r3) {
            o.f(r3, "animation");
            if (this.f11048a.getVInput().hasFocus() == false) goto L5;
            OInputView r4 = this.f11048a;
            h r1 = h.f11038f;
        L6:
            OInputView.u(r4, r1, this.f11049b, "LabelHideAnim, onAnimationCancel");
            return;
        L5:
            r4 = this.f11048a;
            r1 = h.f11039g;
            goto L6
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r3) {
            o.f(r3, "animation");
            if (this.f11048a.getVInput().hasFocus() == false) goto L5;
            OInputView r4 = this.f11048a;
            h r1 = h.f11038f;
        L6:
            OInputView.u(r4, r1, this.f11049b, "LabelHideAnim, onAnimationCancel");
            return;
        L5:
            r4 = this.f11048a;
            r1 = h.f11039g;
            goto L6
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r2, boolean r3) {
            o.f(r2, "animation");
            OInputView.u(this.f11048a, h.f11039g, this.f11049b, "LabelHideAnim, onAnimationStart");
        }
    }

    static final class m implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OInputView f11050a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ float f11051b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f11052c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f11053d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ float f11054e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ TextView f11055f;

        m(OInputView r1, float r2, int r3, int r4, float r5, TextView r6) {
            this.f11050a = r1;
            this.f11051b = r2;
            this.f11052c = r3;
            this.f11053d = r4;
            this.f11054e = r5;
            this.f11055f = r6;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r5) {
            o.f(r5, "animation");
            Object r6 = r5.getAnimatedValue();
            Objects.requireNonNull(r6, "null cannot be cast to non-null type kotlin.Float");
            float r7 = ((Float) r6).floatValue();
            float r0 = 0;
            float r1 = r0 + ((this.f11051b - r0) * r7);
            int r2 = OInputView.f(this.f11050a, this.f11052c, this.f11053d, r7);
            float r3 = ((this.f11054e - 1.0f) * r7) + 1.0f;
            this.f11055f.setTextColor(r2);
            this.f11055f.setScaleX(r3);
            this.f11055f.setScaleY(r3);
            this.f11055f.setTranslationY(r1);
            d.g.d.f.f.b.i("OInputView", "progress: " + r7 + ", transY: " + r1 + ", scale: " + r3);
        }
    }

    public static final class n extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OInputView f11056a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ TextView f11057b;

        n(OInputView r1, TextView r2) {
            this.f11056a = r1;
            this.f11057b = r2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r3) {
            o.f(r3, "animation");
            if (this.f11056a.getVInput().hasFocus() == false) goto L5;
            OInputView r4 = this.f11056a;
            h r1 = h.f11038f;
        L6:
            OInputView.u(r4, r1, this.f11057b, "LabelShowAnim, onAnimationCancel");
            return;
        L5:
            r4 = this.f11056a;
            r1 = h.f11039g;
            goto L6
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r3) {
            o.f(r3, "animation");
            if (this.f11056a.getVInput().hasFocus() == false) goto L5;
            OInputView r4 = this.f11056a;
            h r1 = h.f11038f;
        L6:
            OInputView.u(r4, r1, this.f11057b, "LabelShowAnim, onAnimationCancel");
            return;
        L5:
            r4 = this.f11056a;
            r1 = h.f11039g;
            goto L6
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r2, boolean r3) {
            o.f(r2, "animation");
            OInputView.u(this.f11056a, h.f11039g, this.f11057b, "LabelShowAnim, onAnimationStart");
        }
    }

    static {
    }

    public OInputView(Context r7, AttributeSet r8) {
        this(r7, r8, 0, 4, null);
    }

    public OInputView(Context r8, AttributeSet r9, int r10) {
        o.f(r8, "context");
        super(r8, r9, r10);
        int r0 = 1;
        this.f11024f = true;
        this.f11026h = true;
        this.f11027i = Integer.MAX_VALUE;
        this.f11028j = 16;
        this.p = true;
        this.q = true;
        this.s = -1;
        this.t = true;
        this.v = true;
        this.y = true;
        Resources r5 = Resources.getSystem();
        o.e(r5, "Resources.getSystem()");
        this.H = kotlin.o0.a.a(TypedValue.applyDimension(1, 10, r5.getDisplayMetrics()));
        TypedArray r11 = r8.getTheme().obtainStyledAttributes(r9, com.obric.common.oui.k.Y, r10, 0);
        this.o = r11.getBoolean(com.obric.common.oui.k.n0, false);
        this.p = r11.getBoolean(com.obric.common.oui.k.h0, true);
        this.q = r11.getBoolean(com.obric.common.oui.k.x0, true);
        this.t = r11.getBoolean(com.obric.common.oui.k.t0, true);
        this.u = r11.getBoolean(com.obric.common.oui.k.u0, false);
        this.v = r11.getBoolean(com.obric.common.oui.k.v0, true);
        this.w = r11.getString(com.obric.common.oui.k.o0);
        this.D = r11.getString(com.obric.common.oui.k.k0);
        this.E = r11.getString(com.obric.common.oui.k.j0);
        this.F = r11.getBoolean(com.obric.common.oui.k.s0, false);
        this.H = r11.getDimensionPixelSize(com.obric.common.oui.k.l0, this.H);
        this.f11024f = r11.getBoolean(com.obric.common.oui.k.i0, true);
        this.f11025g = r11.getInt(com.obric.common.oui.k.p0, 0);
        this.f11026h = r11.getBoolean(com.obric.common.oui.k.q0, true);
        int r12 = r11.getDimensionPixelSize(com.obric.common.oui.k.m0, 0);
        if (r12 <= 0) goto L5;
        this.z = Integer.valueOf(r12);
    L5:
        this.s = r11.getInt(com.obric.common.oui.k.r0, -1);
        this.r = r11.getBoolean(com.obric.common.oui.k.w0, false);
        this.G = r11.getText(com.obric.common.oui.k.f0);
        this.A = r11.getString(com.obric.common.oui.k.d0);
        this.B = r11.getInt(com.obric.common.oui.k.g0, 0);
        this.C = r11.getString(com.obric.common.oui.k.c0);
        this.y = r11.getBoolean(com.obric.common.oui.k.Z, true);
        this.f11027i = r11.getInt(com.obric.common.oui.k.e0, Integer.MAX_VALUE);
        r11.getInt(com.obric.common.oui.k.b0, 0);
        this.f11028j = r11.getInt(com.obric.common.oui.k.a0, 16);
        r11.recycle();
        LayoutInflater.from(r8).inflate(getContentViewRes(), this);
        View r13 = findViewById(com.obric.common.oui.f.l0);
        o.e(r13, "findViewById(R.id.o_input_border_container)");
        OUIConstraintLayout r14 = (OUIConstraintLayout) r13;
        this.I = r14;
        r14.setRadius(this.H);
        View r15 = findViewById(com.obric.common.oui.f.w0);
        o.e(r15, "findViewById(R.id.o_input_title_container)");
        this.f11023J = (LinearLayout) r15;
        View r16 = findViewById(com.obric.common.oui.f.v0);
        o.e(r16, "findViewById(R.id.o_input_title)");
        this.K = (OTextView) r16;
        View r17 = findViewById(com.obric.common.oui.f.x0);
        o.e(r17, "findViewById(R.id.o_input_title_icon)");
        this.L = (ImageView) r17;
        View r18 = findViewById(com.obric.common.oui.f.j0);
        o.e(r18, "findViewById(R.id.o_input)");
        OEditText r19 = (OEditText) r18;
        this.M = r19;
        r19.setVerticalScrollBarEnabled(false);
        View r20 = findViewById(com.obric.common.oui.f.s0);
        o.e(r20, "findViewById(R.id.o_input_left_view_container)");
        this.N = (FrameLayout) r20;
        View r21 = findViewById(com.obric.common.oui.f.p0);
        o.e(r21, "findViewById(R.id.o_input_custom_action_container)");
        this.O = (FrameLayout) r21;
        View r22 = findViewById(com.obric.common.oui.f.k0);
        o.e(r22, "findViewById(R.id.o_input_action_container)");
        this.P = r22;
        View r23 = findViewById(com.obric.common.oui.f.m0);
        o.e(r23, "findViewById(R.id.o_input_clear)");
        this.Q = r23;
        View r24 = findViewById(com.obric.common.oui.f.n0);
        o.e(r24, "findViewById(R.id.o_input_combo_arrow)");
        this.R = r24;
        View r25 = findViewById(com.obric.common.oui.f.r0);
        o.e(r25, "findViewById(R.id.o_input_eyes_slash)");
        ImageView r26 = (ImageView) r25;
        this.S = r26;
        View r110 = findViewById(com.obric.common.oui.f.u0);
        o.e(r110, "findViewById(R.id.o_input_resizer)");
        this.T = r110;
        View r111 = findViewById(com.obric.common.oui.f.q0);
        o.e(r111, "findViewById(R.id.o_input_error_tip)");
        this.U = (OTextView) r111;
        View r112 = findViewById(com.obric.common.oui.f.o0);
        o.e(r112, "findViewById(R.id.o_input_common_tip)");
        this.V = (OTextView) r112;
        View r113 = findViewById(com.obric.common.oui.f.t0);
        o.e(r113, "findViewById(R.id.o_input_limit_indicator)");
        this.W = (OTextView) r113;
        this.a0 = (TextView) findViewById(com.obric.common.oui.f.y0);
        setFocusableInTouchMode(true);
        setFocusable(true);
        setDescendantFocusability(262144);
        if (this.G == null) goto L11;
        this.M.setKeyListener(DigitsKeyListener.getInstance(String.valueOf(this.G)));
        int r114 = this.B;
        if (r114 == 0) goto L10;
        r0 = r114;
    L10:
        this.B = r0;
    L11:
        this.M.setGravity(this.f11028j);
        Integer r115 = this.z;
        if (r115 == null) goto L14;
        setInputHeight(r115.intValue());
    L14:
        this.M.b(new a(this));
        this.M.c(new b(this));
        this.M.d(new c(this));
        this.M.a(new d(this));
        r23.setOnClickListener(new e(this));
        setCommonTip(this.E);
        H(this.F);
        setErrorTip(this.D);
        I(false);
        setComboInputEnabled(this.f11024f);
        setLabel(this.w);
        setShowLabel(this.t);
        setShowLabelIcon(this.v);
        setLimitCount(this.s);
        setShowLimitIndicator(this.r);
        setSingleLine(this.f11026h);
        setMaxLines(this.f11027i);
        setHint(this.A);
        setText(this.C);
        setInputMode(this.f11025g);
        setEnabled(this.y);
        P();
        O(this.M.hasFocus());
        int r27 = this.B;
        if (r27 == 0) goto L17;
        setInputType(r27);
    L17:
        Q();
        r26.setOnClickListener(new f(this));
        this.I.setOnClickListener(new g(this));
        v("init");
    }

    public /* synthetic */ OInputView(Context r1, AttributeSet r2, int r3, int r4, kotlin.n0.d.g r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    private final ValueAnimator A(int r10, int r11, long r12) {
        TextView r7 = this.a0;
        if (r7 == null) goto L6;
        float r2 = getFakeInputOffsetY();
        float r5 = D(r7);
        r7.setPivotX(0.0f);
        r7.setPivotY(-r2);
        ValueAnimator r8 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        o.e(r8, "animator");
        r8.setDuration(r12);
        r8.setInterpolator(new DecelerateInterpolator());
        r8.addUpdateListener(new m(this, r2, r11, r10, r5, r7));
        r8.addListener(new n(this, r7));
        return r8;
    L6:
        return null;
    }

    static /* synthetic */ ValueAnimator B(OInputView r0, int r1, int r2, long r3, int r5, Object r6) {
        if (r6 != null) goto L15;
        if ((r5 & 1) == 0) goto L7;
        r1 = ContextCompat.getColor(r0.getContext(), com.obric.common.oui.c.P);
    L7:
        if ((r5 & 2) == 0) goto L10;
        r2 = ContextCompat.getColor(r0.getContext(), com.obric.common.oui.c.R);
    L10:
        if ((r5 & 4) == 0) goto L13;
        r3 = 200;
    L13:
        return r0.A(r1, r2, r3);
    L15:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: genLabelShowAnim");
    }

    private final float D(TextView r4) {
        float r1 = 0;
        if (this.K.getTextSize() > r1) goto L5;
    L7:
        d.g.d.f.f.b.j("OInputView", "getScaleRatio, use default scale, vTitle.textSize: " + this.K.getTextSize() + ", vFakeInput.textSize: " + r4.getTextSize());
        float r3 = 0.857143f;
    L8:
        d.g.d.f.f.b.a("OInputView", "getScaleRatio, scale: " + r3);
        return r3;
    L5:
        if (r4.getTextSize() <= r1) goto L7;
        r3 = this.K.getTextSize() / r4.getTextSize();
        goto L8
    }

    private final void E() {
        Object r0 = getContext().getSystemService("input_method");
        if ((r0 instanceof InputMethodManager) == true) goto L5;
        r0 = null;
    L5:
        InputMethodManager r1 = (InputMethodManager) r0;
        if (r1 == null) goto L9;
        r1.hideSoftInputFromWindow(this.M.getWindowToken(), 0);
        return;
    }

    private final boolean F() {
        int r5 = this.B & 4095;
        if (r5 != 129) goto L5;
        boolean r2 = true;
    L7:
        if (r5 != 225) goto L9;
        boolean r3 = true;
    L11:
        if (r5 != 18) goto L13;
        boolean r6 = true;
    L14:
        if (r2 == true) goto L20;
        if (r3 == true) goto L21;
        if (r6 == false) goto L19;
        return true;
    L19:
        return false;
    L21:
        return true;
    L20:
        return true;
    L13:
        r6 = false;
        goto L14
    L9:
        r3 = false;
        goto L11
    L5:
        r2 = false;
        goto L7
    }

    private final void G(boolean r9) {
        if (this.u == true) goto L6;
        return;
    L6:
        if (this.t == true) goto L9;
        return;
    L9:
        if (this.f11026h == true) goto L12;
        return;
    L12:
        if (this.a0 != null) goto L14;
        return;
    L14:
        Editable r0 = this.M.getText();
        if (r0 != null) goto L17;
    L20:
        boolean r1 = true;
    L21:
        if (r1 == true) goto L25;
        h r2 = h.f11038f;
        TextView r3 = this.a0;
        o.c(r3);
        R(r2, r3, "playLabelAnim, hasFocus: " + r9);
        return;
    L25:
        if (r9 == false) goto L45;
        ValueAnimator r10 = this.j0;
        if (r10 == null) goto L29;
        r10.cancel();
    L29:
        ValueAnimator r11 = this.j0;
        if (r11 == null) goto L32;
        r11.removeAllUpdateListeners();
    L32:
        ValueAnimator r12 = this.j0;
        if (r12 == null) goto L35;
        r12.removeAllListeners();
    L35:
        ValueAnimator r13 = this.i0;
        if (r13 != null) goto L38;
    L41:
        ValueAnimator r14 = B(this, 0, 0, 0, 7, null);
        this.i0 = r14;
        if (r14 == null) goto L44;
        r14.start();
    L44:
        String r8 = "start label show anim";
    L65:
        d.g.d.f.f.b.a("OInputView", r8);
        return;
    L38:
        if (r13.isRunning() != true) goto L41;
        String r15 = "label show anim is running, do nothing";
    L60:
        d.g.d.f.f.b.j("OInputView", r15);
        return;
    L45:
        ValueAnimator r16 = this.i0;
        if (r16 == null) goto L48;
        r16.cancel();
    L48:
        ValueAnimator r17 = this.i0;
        if (r17 == null) goto L51;
        r17.removeAllUpdateListeners();
    L51:
        ValueAnimator r18 = this.i0;
        if (r18 == null) goto L54;
        r18.removeAllListeners();
    L54:
        ValueAnimator r19 = this.j0;
        if (r19 != null) goto L57;
    L61:
        ValueAnimator r20 = z(this, 0, 0, 0, 7, null);
        this.j0 = r20;
        if (r20 == null) goto L64;
        r20.start();
    L64:
        r8 = "start label hide anim";
        goto L65
    L57:
        if (r19.isRunning() != true) goto L61;
        r15 = "label hide anim is running, do nothing";
        goto L60
    L17:
        if (r0.length() == 0) goto L20;
        r1 = false;
        goto L21
    }

    private final void J(TextView r3) {
        this.f11023J.setVisibility(4);
        r3.setVisibility(0);
        this.M.setAlpha(0.0f);
    }

    private final void K(TextView r3) {
        this.f11023J.setVisibility(8);
        r3.setVisibility(8);
        this.M.setAlpha(1.0f);
    }

    private final void L(TextView r3) {
        this.f11023J.setVisibility(0);
        r3.setVisibility(8);
        this.M.setAlpha(1.0f);
    }

    private final void M() {
        Object r0 = getContext().getSystemService("input_method");
        if ((r0 instanceof InputMethodManager) == true) goto L5;
        r0 = null;
    L5:
        InputMethodManager r1 = (InputMethodManager) r0;
        if (r1 == null) goto L9;
        r1.showSoftInput(this.M, 0);
        return;
    }

    private final void N(boolean r2) {
        int r0 = this.g0;
        if (r0 == 0) goto L7;
        this.I.setBackgroundResource(r0);
        return;
    L7:
        if (this.f11030l == false) goto L11;
        this.I.setBackgroundResource(com.obric.common.oui.c.u);
        return;
    L11:
        if (this.y == true) goto L13;
    L12:
        int r3 = com.obric.common.oui.e.C;
    L19:
        this.I.setBackgroundResource(r3);
        return;
    L13:
        if (r2 == true) goto L12;
        if (this.M.hasFocus() == false) goto L18;
        r3 = com.obric.common.oui.e.A;
        goto L19
    L18:
        r3 = com.obric.common.oui.e.B;
        goto L19
    }

    private final void O(boolean r7) {
        int r1 = 0;
        if (this.f11029k == false) goto L7;
        this.I.setBorderWidth(0);
        this.I.setBorderColor(ContextCompat.getColor(getContext(), com.obric.common.oui.c.u));
        return;
    L7:
        if (this.y == true) goto L10;
    L8:
        float r0 = 0;
    L9:
        Resources r4 = Resources.getSystem();
        o.e(r4, "Resources.getSystem()");
        this.I.setBorderWidth(kotlin.o0.a.a(TypedValue.applyDimension(1, r0, r4.getDisplayMetrics())));
        if (this.y == true) goto L19;
        Resources r2 = Resources.getSystem();
        o.e(r2, "Resources.getSystem()");
        r1 = kotlin.o0.a.a(TypedValue.applyDimension(1, 0, r2.getDisplayMetrics()));
    L23:
        if (r1 == 0) goto L26;
        this.I.setBorderColor(ContextCompat.getColor(getContext(), r1));
        return;
    L26:
        return;
    L19:
        if (this.x == false) goto L21;
        r1 = com.obric.common.oui.c.I;
        goto L23
    L21:
        if (r7 == false) goto L23;
        r1 = com.obric.common.oui.c.A;
        goto L23
    L10:
        if (r7 == false) goto L13;
        r0 = 2;
        goto L9
    L13:
        if (this.x == false) goto L8;
        r0 = (float) 1.2d;
        goto L9
    }

    private final void P() {
        if (this.p == true) goto L5;
        return;
    L5:
        boolean r1 = true;
        if (F() == false) goto L8;
    L22:
        boolean r0 = false;
    L23:
        com.obric.oui.common.util.j.j(this.Q, r0);
        if (r0 == false) goto L26;
        com.obric.oui.common.util.j.j(this.S, false);
    L26:
        View r2 = this.P;
        if (this.Q.getVisibility() != 0) goto L29;
        boolean r3 = true;
    L30:
        if (r3 == false) goto L32;
    L43:
        com.obric.oui.common.util.j.j(r2, r1);
        return;
    L32:
        if (this.S.getVisibility() != 0) goto L34;
        boolean r4 = true;
    L35:
        if (r4 == true) goto L43;
        if (this.R.getVisibility() != 0) goto L39;
        boolean r5 = true;
    L40:
        if (r5 == true) goto L43;
        r1 = false;
        goto L43
    L39:
        r5 = false;
        goto L40
    L34:
        r4 = false;
        goto L35
    L29:
        r3 = false;
        goto L30
    L8:
        if (this.f11025g != 0) goto L22;
        if (this.y == false) goto L22;
        if (this.M.hasFocus() == false) goto L22;
        Editable r6 = this.M.getText();
        if (r6 != null) goto L16;
    L19:
        boolean r7 = true;
    L20:
        if (r7 == true) goto L22;
        r0 = true;
        goto L23
    L16:
        if (r6.length() == 0) goto L19;
        r7 = false;
        goto L20
    }

    private final void Q() {
        boolean r1 = true;
        if (F() == true) goto L5;
    L17:
        boolean r0 = false;
    L18:
        com.obric.oui.common.util.j.j(this.S, r0);
        if (r0 == false) goto L21;
        com.obric.oui.common.util.j.j(this.Q, false);
    L21:
        View r2 = this.P;
        if (this.Q.getVisibility() != 0) goto L24;
        boolean r3 = true;
    L25:
        if (r3 == false) goto L27;
    L38:
        com.obric.oui.common.util.j.j(r2, r1);
        return;
    L27:
        if (this.S.getVisibility() != 0) goto L29;
        boolean r4 = true;
    L30:
        if (r4 == true) goto L38;
        if (this.R.getVisibility() != 0) goto L34;
        boolean r5 = true;
    L35:
        if (r5 == true) goto L38;
        r1 = false;
        goto L38
    L34:
        r5 = false;
        goto L35
    L29:
        r4 = false;
        goto L30
    L24:
        r3 = false;
        goto L25
    L5:
        if (this.y == false) goto L17;
        Editable r6 = this.M.getText();
        if (r6 != null) goto L9;
    L12:
        boolean r7 = true;
    L13:
        if (r7 == true) goto L17;
        if (this.h0 == true) goto L17;
        r0 = true;
        goto L18
    L9:
        if (r6.length() == 0) goto L12;
        r7 = false;
        goto L13
    }

    private final void R(h r3, TextView r4, String r5) {
        d.g.d.f.f.b.a("OInputView", "updateLabelUIState, state: " + r3 + ", scene: [" + r5 + ']');
        int r6 = com.obric.oui.forms.a.f11061a[r3.ordinal()];
        if (r6 != 1) goto L5;
        L(r4);
        return;
    L5:
        if (r6 != 2) goto L7;
        J(r4);
        return;
    L7:
        if (r6 != 3) goto L15;
        K(r4);
        return;
    }

    public static final /* synthetic */ int f(OInputView r0, int r1, int r2, float r3) {
        return r0.w(r1, r2, r3);
    }

    public static final /* synthetic */ int g(OInputView r0) {
        return r0.B;
    }

    private final float getFakeInputOffsetY() {
        if (this.f11023J.getHeight() > 0) goto L5;
    L7:
        d.g.d.f.f.b.j("OInputView", "getFakeInputOffsetY, use default offset, vTitleContainer.height: " + this.f11023J.getHeight() + ", height: " + getHeight());
        Resources r2 = Resources.getSystem();
        o.e(r2, "Resources.getSystem()");
        float r0 = TypedValue.applyDimension(1, -11.0f, r2.getDisplayMetrics());
    L8:
        d.g.d.f.f.b.a("OInputView", "getFakeInputOffsetY, offsetY: " + r0);
        return r0;
    L5:
        if (getHeight() <= 0) goto L7;
        r0 = (this.f11023J.getY() + (this.f11023J.getHeight() / 2.0f)) - (getHeight() / 2.0f);
        goto L8
    }

    public static final /* synthetic */ int h(OInputView r0) {
        return r0.s;
    }

    public static final /* synthetic */ i i(OInputView r0) {
        return r0.c0;
    }

    public static final /* synthetic */ j j(OInputView r0) {
        return r0.d0;
    }

    public static final /* synthetic */ boolean k(OInputView r0) {
        return r0.F;
    }

    public static final /* synthetic */ ImageView l(OInputView r0) {
        return r0.S;
    }

    public static final /* synthetic */ void m(OInputView r0) {
        r0.E();
    }

    public static final /* synthetic */ boolean n(OInputView r0) {
        return r0.x;
    }

    public static final /* synthetic */ void o(OInputView r0, boolean r1) {
        r0.G(r1);
    }

    public static final /* synthetic */ void p(OInputView r0) {
        r0.M();
    }

    public static final /* synthetic */ void q(OInputView r0, boolean r1) {
        r0.N(r1);
    }

    public static final /* synthetic */ void r(OInputView r0, boolean r1) {
        r0.O(r1);
    }

    public static final /* synthetic */ void s(OInputView r0) {
        r0.P();
    }

    public static final /* synthetic */ void t(OInputView r0) {
        r0.Q();
    }

    public static final /* synthetic */ void u(OInputView r0, h r1, TextView r2, String r3) {
        r0.R(r1, r2, r3);
    }

    private final void v(String r5) {
        if (this.u == true) goto L5;
        return;
    L5:
        TextView r0 = this.a0;
        if (r0 != null) goto L8;
        return;
    L8:
        if (this.t == true) goto L12;
        this.M.setHint(this.A);
        h r1 = h.f11040h;
        StringBuilder r3 = new StringBuilder();
        r3.append("adjustInputViewAndLabel, ");
        r3.append(r5);
        String r6 = ", no label";
    L10:
        r3.append(r6);
        R(r1, r0, r3.toString());
        return;
    L12:
        if (this.f11026h == true) goto L14;
        this.M.setHint(this.A);
        r1 = h.f11038f;
        r3 = new StringBuilder();
        r3.append("adjustInputViewAndLabel, ");
        r3.append(r5);
        r6 = ", can not show label anim";
        goto L10
    L14:
        this.M.setHint("");
        r0.setText(this.w);
        Editable r2 = this.M.getText();
        if (r2 != null) goto L17;
    L20:
        boolean r4 = true;
    L21:
        if (r4 == true) goto L23;
        r1 = h.f11038f;
        r3 = new StringBuilder();
        r3.append("adjustInputViewAndLabel, ");
        r3.append(r5);
        r6 = ", can show label anim, vInput.text not empty";
        goto L10
    L23:
        if (this.M.hasFocus() == false) goto L25;
        r1 = h.f11038f;
        r3 = new StringBuilder();
        r3.append("adjustInputViewAndLabel, ");
        r3.append(r5);
        r6 = ", can show label anim, vInput.text empty, focused";
        goto L10
    L25:
        r1 = h.f11039g;
        r3 = new StringBuilder();
        r3.append("adjustInputViewAndLabel, ");
        r3.append(r5);
        r6 = ", can show label anim, vInput.text empty, not focused";
        goto L10
    L17:
        if (r2.length() == 0) goto L20;
        r4 = false;
        goto L21
    }

    private final int w(int r2, int r3, float r4) {
        return ColorUtils.blendARGB(r2, r3, kotlin.r0.e.h(r4, 0.0f, 1.0f));
    }

    private final ValueAnimator y(int r10, int r11, long r12) {
        TextView r7 = this.a0;
        if (r7 == null) goto L6;
        float r2 = getFakeInputOffsetY();
        float r5 = D(r7);
        r7.setPivotX(0.0f);
        r7.setPivotY(-r2);
        ValueAnimator r8 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        o.e(r8, "animator");
        r8.setDuration(r12);
        r8.setInterpolator(new DecelerateInterpolator());
        r8.addUpdateListener(new k(this, r2, r10, r11, r5, r7));
        r8.addListener(new l(this, r7));
        return r8;
    L6:
        return null;
    }

    static /* synthetic */ ValueAnimator z(OInputView r0, int r1, int r2, long r3, int r5, Object r6) {
        if (r6 != null) goto L15;
        if ((r5 & 1) == 0) goto L7;
        r1 = ContextCompat.getColor(r0.getContext(), com.obric.common.oui.c.P);
    L7:
        if ((r5 & 2) == 0) goto L10;
        r2 = ContextCompat.getColor(r0.getContext(), com.obric.common.oui.c.R);
    L10:
        if ((r5 & 4) == 0) goto L13;
        r3 = 200;
    L13:
        return r0.y(r1, r2, r3);
    L15:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: genLabelHideAnim");
    }

    public int C(CharSequence r1) {
        if (r1 != null) goto L6;
        return 0;
    L6:
        return r1.length();
    }

    public final void H(boolean r1) {
        com.obric.oui.common.util.j.j(this.V, r1);
    }

    public final void I(boolean r1) {
        com.obric.oui.common.util.j.j(this.U, r1);
    }

    public final void S(String r7) {
        OTextView r0 = this.W;
        if (this.r == true) goto L5;
    L7:
        boolean r1 = false;
    L8:
        com.obric.oui.common.util.j.j(r0, r1);
        if (this.r == true) goto L11;
        return;
    L11:
        if (this.s <= 0) goto L18;
        int r8 = C(r7);
        String r2 = getResources().getString(com.obric.common.oui.i.f8271h, new Object[]{String.valueOf(r8), String.valueOf(this.s)});
        o.e(r2, "resources.getString(\n   ….toString()\n            )");
        SpannableString r3 = new SpannableString(r2);
        if (r8 <= this.s) goto L15;
        r3.setSpan(new ForegroundColorSpan(ContextCompat.getColor(getContext(), com.obric.common.oui.c.I)), 0, String.valueOf(r8).length(), 18);
    L15:
        this.W.setText(r3, TextView.BufferType.SPANNABLE);
        return;
    L18:
        return;
    L5:
        if (this.s <= 0) goto L7;
        r1 = true;
        goto L8
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r7) {
        if (r7 == null) goto L36;
        if (this.o == false) goto L36;
        float r0 = r7.getX();
        float r1 = r7.getY();
        int r2 = r7.getAction();
        if (r2 != 0) goto L8;
        this.m = r0;
    L34:
        this.m = r1;
        goto L36
    L8:
        if (r2 != 1) goto L10;
    L32:
        super.requestDisallowInterceptTouchEvent(false);
        goto L36
    L10:
        if (r2 == 2) goto L15;
        if (r2 == 3) goto L32;
    L15:
        if (r0 <= this.n) goto L19;
        if (this.M.canScrollHorizontally(-1) == false) goto L19;
    L30:
        super.requestDisallowInterceptTouchEvent(true);
    L31:
        this.n = r0;
    L19:
        if (r0 >= this.n) goto L23;
        if (this.M.canScrollHorizontally(1) == true) goto L30;
    L23:
        if (r1 >= this.m) goto L27;
        if (this.M.canScrollVertically(1) == true) goto L30;
    L27:
        if (r1 <= this.m) goto L31;
        if (this.M.canScrollVertically(-1) == false) goto L31;
    L36:
        return super.dispatchTouchEvent(r7);
    }

    public final boolean getAutoHideSoftInputWhenLoseFocus() {
        return this.f0;
    }

    public final OEditText.a getCommitCompletionListener() {
        return this.M.getCommitCompletionListener();
    }

    public int getContentViewRes() {
        return com.obric.common.oui.g.q;
    }

    public final int getInputType() {
        return this.B;
    }

    public final int getLimitCount() {
        return this.s;
    }

    @Override // android.view.View
    public View.OnFocusChangeListener getOnFocusChangeListener() {
        return this.M.getOnFocusChangeListener();
    }

    public String getText() {
        Editable r0 = this.M.getText();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.toString();
    }

    public final OEditText getVInput() {
        return this.M;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r6) {
        if (r6 != null) goto L5;
    L13:
        if (r6 != null) goto L15;
    L22:
        return super.onInterceptTouchEvent(r6);
    L15:
        if (r6.getAction() == 1) goto L19;
        if (r6.getAction() != 3) goto L22;
    L19:
        if (this.b0 == false) goto L22;
    L12:
        this.b0 = false;
        goto L22
    L5:
        if (r6.getAction() != 0) goto L13;
        float r2 = r6.getX();
        int r3 = this.M.getLeft();
        int r4 = this.M.getRight();
        if (r2 < r3) goto L12;
        if (r2 > r4) goto L12;
        this.b0 = true;
        return true;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    protected void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r4) {
        if (r4 == null) goto L12;
        if (this.b0 == false) goto L12;
        MotionEvent r0 = MotionEvent.obtain(r4);
        r0.offsetLocation(-this.M.getLeft(), -this.M.getTop());
        boolean r1 = this.M.dispatchTouchEvent(r0);
        r0.recycle();
        if (r4.getAction() != 1) goto L8;
    L9:
        this.b0 = false;
    L10:
        return r1;
    L8:
        if (r4.getAction() != 3) goto L10;
    L12:
        return super.onTouchEvent(r4);
    }

    public final void setActionView(kotlin.n0.c.l<? super FrameLayout, f0> r2) {
        o.f(r2, "creator");
        this.O.removeAllViews();
        r2.invoke(this.O);
        FrameLayout r1 = this.O;
        if (r1.getChildCount() <= 0) goto L5;
        boolean r3 = true;
    L6:
        com.obric.oui.common.util.j.j(r1, r3);
        return;
    L5:
        r3 = false;
        goto L6
    }

    public final void setAlwaysHideEye(boolean r1) {
        this.h0 = r1;
        if (r1 == false) goto L6;
        com.obric.oui.common.util.j.j(this.S, false);
        return;
    }

    public final void setAutoHideSoftInputWhenLoseFocus(boolean r1) {
        this.f0 = r1;
    }

    public final void setBgResId(int r1) {
        this.g0 = r1;
        N(true);
    }

    public final void setComboInputEnabled(boolean r2) {
        this.f11024f = r2;
        this.M.setFocusable(r2);
        this.M.setFocusableInTouchMode(r2);
        View.OnClickListener r3 = this.e0;
        if (r3 == null) goto L6;
        this.M.setOnClickListener(r3);
        return;
    }

    public final void setCommitCompletionListener(OEditText.a r2) {
        o.f(r2, "commitCompletionListener");
        this.M.setCommitCompletionListener(r2);
    }

    public final void setCommonTip(String r1) {
        this.E = r1;
        this.V.setText(r1);
    }

    @Override // android.view.View
    public void setEnabled(boolean r3) {
        this.y = r3;
        super.setEnabled(r3);
        Iterator<View> r0 = ViewGroupKt.getChildren(this).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().setEnabled(r3);
        goto L4
    L6:
        this.M.setEnabled(r3);
        O(this.M.hasFocus());
        N(false);
    }

    public final void setErrorState(boolean r1) {
        this.x = r1;
        O(this.M.hasFocus());
        N(false);
    }

    public final void setErrorTip(String r1) {
        this.D = r1;
        this.U.setText(r1);
    }

    public final void setHint(String r2) {
        this.A = r2;
        this.M.setHint(r2);
        v("setHint");
    }

    public final void setInputHeight(int r3) {
        this.z = Integer.valueOf(r3);
        OEditText r2 = this.M;
        ViewGroup.LayoutParams r0 = r2.getLayoutParams();
        Objects.requireNonNull(r0, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r1 = (ConstraintLayout.LayoutParams) r0;
        ((ViewGroup.MarginLayoutParams) r1).height = r3;
        r2.setLayoutParams(r1);
    }

    public final void setInputMode(int r4) {
        this.f11025g = r4;
        boolean r0 = false;
        if (r4 == 0) goto L23;
        if (r4 != 1) goto L42;
        setSingleLine(true);
        com.obric.oui.common.util.j.j(this.R, true);
        View r5 = this.P;
        if (this.Q.getVisibility() != 0) goto L9;
        boolean r2 = true;
    L10:
        if (r2 == false) goto L12;
    L21:
        r0 = true;
    L22:
        com.obric.oui.common.util.j.j(r5, r0);
        setComboInputEnabled(this.f11024f);
        return;
    L12:
        if (this.S.getVisibility() != 0) goto L14;
        boolean r3 = true;
    L15:
        if (r3 == true) goto L21;
        if (this.R.getVisibility() != 0) goto L19;
        boolean r6 = true;
    L20:
        if (r6 == false) goto L22;
    L19:
        r6 = false;
        goto L20
    L14:
        r3 = false;
        goto L15
    L9:
        r2 = false;
        goto L10
    L42:
        return;
    L23:
        com.obric.oui.common.util.j.j(this.R, false);
        View r7 = this.P;
        if (this.Q.getVisibility() != 0) goto L26;
        boolean r8 = true;
    L27:
        if (r8 == false) goto L29;
    L38:
        r0 = true;
    L39:
        com.obric.oui.common.util.j.j(r7, r0);
        this.M.setFocusable(true);
        this.M.setFocusableInTouchMode(true);
        return;
    L29:
        if (this.S.getVisibility() != 0) goto L31;
        boolean r9 = true;
    L32:
        if (r9 == true) goto L38;
        if (this.R.getVisibility() != 0) goto L36;
        boolean r10 = true;
    L37:
        if (r10 == false) goto L39;
    L36:
        r10 = false;
        goto L37
    L31:
        r9 = false;
        goto L32
    L26:
        r8 = false;
        goto L27
    }

    public final void setInputType(int r2) {
        if ((r2 & 1) == 0) goto L5;
    L11:
        this.B = r2;
        if (r2 != this.M.getInputType()) goto L15;
    L13:
        x(this.M.getText());
        return;
    L15:
        this.M.setInputType(this.B);
        Q();
        goto L13
    L5:
        if ((r2 & 2) != 0) goto L11;
        if ((r2 & 3) != 0) goto L11;
        if ((r2 & 4) != 0) goto L11;
        r2 = r2 | 1;
        goto L11
    }

    public final void setIsInScrollableView(boolean r1) {
        this.o = r1;
    }

    public final void setKeyListener(KeyListener r1) {
        this.M.setKeyListener(r1);
    }

    public final void setLabel(String r1) {
        this.w = r1;
        this.K.setText(r1);
    }

    public final void setLeftView(kotlin.n0.c.l<? super FrameLayout, f0> r2) {
        o.f(r2, "creator");
        this.N.removeAllViews();
        r2.invoke(this.N);
        FrameLayout r1 = this.N;
        if (r1.getChildCount() <= 0) goto L5;
        boolean r3 = true;
    L6:
        com.obric.oui.common.util.j.j(r1, r3);
        return;
    L5:
        r3 = false;
        goto L6
    }

    public void setLimitCount(int r1) {
        setLimitCountValue(r1);
        Editable r2 = this.M.getText();
        if (r2 == null) goto L5;
        String r3 = r2.toString();
    L6:
        S(r3);
        x(this.M.getText());
        return;
    L5:
        r3 = null;
        goto L6
    }

    public final void setLimitCountValue(int r1) {
        this.s = r1;
    }

    public final void setMaxLines(int r3) {
        int r0 = 1;
        if (r3 >= 1) goto L5;
        r3 = Integer.MAX_VALUE;
    L5:
        this.f11027i = r3;
        OEditText r1 = this.M;
        if (this.f11026h == true) goto L9;
        r0 = r3;
    L9:
        r1.setMaxLines(r0);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener r3) {
        if (this.f11025g == 1) goto L5;
    L7:
        super.setOnClickListener(r3);
        return;
    L5:
        if (this.f11024f == true) goto L7;
        this.R.setOnClickListener(r3);
        this.M.setOnClickListener(r3);
        goto L7
    }

    public final void setOnComboArrowClickListener(View.OnClickListener r2) {
        this.e0 = r2;
        this.R.setOnClickListener(r2);
        if (this.f11024f == true) goto L8;
        View.OnClickListener r3 = this.e0;
        if (r3 == null) goto L9;
        this.M.setOnClickListener(r3);
        return;
    L9:
        return;
    }

    @Override // android.view.View
    public void setOnFocusChangeListener(View.OnFocusChangeListener r1) {
        this.M.setOnFocusChangeListener(r1);
    }

    public final void setOnTextClearedListener(i r2) {
        o.f(r2, "listener");
        this.c0 = r2;
    }

    public final void setOnTextExceedLengthListener(j r1) {
        this.d0 = r1;
    }

    public final void setRadius(int r2) {
        if (r2 != this.H) goto L5;
        return;
    L5:
        this.H = r2;
        this.I.setRadius(r2);
    }

    public final void setShowLabel(boolean r6) {
        this.t = r6;
        com.obric.oui.common.util.j.j(this.f11023J, r6);
        OEditText r7 = this.M;
        ViewGroup.LayoutParams r0 = r7.getLayoutParams();
        Objects.requireNonNull(r0, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r1 = (ConstraintLayout.LayoutParams) r0;
        if (this.t == false) goto L5;
        int r2 = 16;
    L6:
        Resources r4 = Resources.getSystem();
        o.e(r4, "Resources.getSystem()");
        int r3 = kotlin.o0.a.a(TypedValue.applyDimension(1, r2, r4.getDisplayMetrics()));
        r1.goneLeftMargin = r3;
        r1.goneStartMargin = r3;
        r7.setLayoutParams(r1);
        v("setShowLabel");
        return;
    L5:
        r2 = 12;
        goto L6
    }

    public final void setShowLabelAnim(boolean r1) {
        this.u = r1;
        v("setShowLabelAnim");
    }

    public final void setShowLabelIcon(boolean r1) {
        this.v = r1;
        com.obric.oui.common.util.j.j(this.L, r1);
    }

    public final void setShowLimitIndicator(boolean r1) {
        this.r = r1;
        Editable r2 = this.M.getText();
        if (r2 == null) goto L5;
        String r3 = r2.toString();
    L6:
        S(r3);
        return;
    L5:
        r3 = null;
        goto L6
    }

    public final void setSingleLine(boolean r14) {
        this.f11026h = r14;
        int r0 = getResources().getDimensionPixelSize(com.obric.common.oui.d.f8218e);
        ViewGroup.LayoutParams r4 = null;
        if (r14 == false) goto L25;
        com.obric.oui.common.util.j.j(this.T, false);
        this.M.setMaxLines(1);
        this.M.setSingleLine(true);
        OEditText r15 = this.M;
        ViewGroup.LayoutParams r9 = r15.getLayoutParams();
        Objects.requireNonNull(r9, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r10 = (ConstraintLayout.LayoutParams) r9;
        ViewGroup.LayoutParams r11 = getLayoutParams();
        if ((r11 instanceof ViewGroup.MarginLayoutParams) == true) goto L7;
        r11 = null;
    L7:
        ViewGroup.MarginLayoutParams r12 = (ViewGroup.MarginLayoutParams) r11;
        if (r12 == null) goto L10;
        int r13 = r12.leftMargin;
    L11:
        ViewGroup.LayoutParams r16 = getLayoutParams();
        if ((r16 instanceof ViewGroup.MarginLayoutParams) == false) goto L15;
        r4 = r16;
    L15:
        ViewGroup.MarginLayoutParams r5 = (ViewGroup.MarginLayoutParams) r4;
        if (r5 == null) goto L18;
        int r6 = r5.rightMargin;
    L19:
        r10.setMargins(r13, 0, r6, r0);
        r10.goneTopMargin = r0;
        if (this.t == false) goto L22;
        float r1 = 16;
    L23:
        Resources r2 = Resources.getSystem();
        o.e(r2, "Resources.getSystem()");
        int r3 = kotlin.o0.a.a(TypedValue.applyDimension(1, r1, r2.getDisplayMetrics()));
        r10.goneLeftMargin = r3;
        r10.goneStartMargin = r3;
        r15.setLayoutParams(r10);
        View r17 = this.P;
        ViewGroup.LayoutParams r7 = r17.getLayoutParams();
        Objects.requireNonNull(r7, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r8 = (ConstraintLayout.LayoutParams) r7;
        r8.topToTop = 0;
        r8.bottomToBottom = 0;
        r17.setLayoutParams(r8);
        FrameLayout r18 = this.O;
        ViewGroup.LayoutParams r19 = r18.getLayoutParams();
        Objects.requireNonNull(r19, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r20 = (ConstraintLayout.LayoutParams) r19;
        r20.topToTop = 0;
        r20.bottomToBottom = 0;
        r18.setLayoutParams(r20);
        FrameLayout r110 = this.N;
        ViewGroup.LayoutParams r21 = r110.getLayoutParams();
        Objects.requireNonNull(r21, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r22 = (ConstraintLayout.LayoutParams) r21;
        float r23 = 4;
        Resources r24 = Resources.getSystem();
        o.e(r24, "Resources.getSystem()");
        int r25 = kotlin.o0.a.a(TypedValue.applyDimension(1, r23, r24.getDisplayMetrics()));
        Resources r26 = Resources.getSystem();
        o.e(r26, "Resources.getSystem()");
        int r27 = kotlin.o0.a.a(TypedValue.applyDimension(1, r23, r26.getDisplayMetrics()));
        Resources r28 = Resources.getSystem();
        o.e(r28, "Resources.getSystem()");
        r22.setMargins(r25, r27, 0, kotlin.o0.a.a(TypedValue.applyDimension(1, r23, r28.getDisplayMetrics())));
        r22.topToTop = 0;
        r22.bottomToBottom = 0;
    L24:
        r110.setLayoutParams(r22);
        v("setSingleLine");
        return;
    L22:
        r1 = 12;
        goto L23
    L18:
        r6 = 0;
        goto L19
    L10:
        r13 = 0;
        goto L11
    L25:
        com.obric.oui.common.util.j.j(this.T, this.q);
        this.M.setMaxLines(this.f11027i);
        this.M.setSingleLine(false);
        OEditText r111 = this.M;
        int r29 = getPaddingLeft();
        Resources r112 = Resources.getSystem();
        o.e(r112, "Resources.getSystem()");
        r111.setPadding(r29, kotlin.o0.a.a(TypedValue.applyDimension(1, 2, r112.getDisplayMetrics())), getPaddingRight(), getPaddingBottom());
        this.M.setGravity(48);
        OEditText r113 = this.M;
        ViewGroup.LayoutParams r30 = r113.getLayoutParams();
        Objects.requireNonNull(r30, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r31 = (ConstraintLayout.LayoutParams) r30;
        ViewGroup.LayoutParams r32 = getLayoutParams();
        if ((r32 instanceof ViewGroup.MarginLayoutParams) == true) goto L28;
        r32 = null;
    L28:
        ViewGroup.MarginLayoutParams r33 = (ViewGroup.MarginLayoutParams) r32;
        if (r33 == null) goto L31;
        int r34 = r33.leftMargin;
    L32:
        ViewGroup.LayoutParams r114 = getLayoutParams();
        if ((r114 instanceof ViewGroup.MarginLayoutParams) == true) goto L35;
        r114 = null;
    L35:
        ViewGroup.MarginLayoutParams r115 = (ViewGroup.MarginLayoutParams) r114;
        if (r115 == null) goto L38;
        int r116 = r115.rightMargin;
    L39:
        float r117 = 8;
        Resources r118 = Resources.getSystem();
        o.e(r118, "Resources.getSystem()");
        r31.setMargins(r34, 0, r116, kotlin.o0.a.a(TypedValue.applyDimension(1, r117, r118.getDisplayMetrics())));
        Resources r35 = Resources.getSystem();
        o.e(r35, "Resources.getSystem()");
        r31.goneTopMargin = kotlin.o0.a.a(TypedValue.applyDimension(1, r117, r35.getDisplayMetrics()));
        if (this.t == false) goto L42;
        float r36 = 16;
    L43:
        Resources r37 = Resources.getSystem();
        o.e(r37, "Resources.getSystem()");
        int r38 = kotlin.o0.a.a(TypedValue.applyDimension(1, r36, r37.getDisplayMetrics()));
        r31.goneLeftMargin = r38;
        r31.goneStartMargin = r38;
        r113.setLayoutParams(r31);
        View r119 = this.P;
        ViewGroup.LayoutParams r39 = r119.getLayoutParams();
        Objects.requireNonNull(r39, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r40 = (ConstraintLayout.LayoutParams) r39;
        r40.topToTop = 0;
        ViewGroup.LayoutParams r41 = getLayoutParams();
        if ((r41 instanceof ViewGroup.MarginLayoutParams) == true) goto L46;
        r41 = null;
    L46:
        ViewGroup.MarginLayoutParams r42 = (ViewGroup.MarginLayoutParams) r41;
        if (r42 == null) goto L49;
        int r43 = r42.leftMargin;
    L50:
        float r44 = 4;
        Resources r45 = Resources.getSystem();
        o.e(r45, "Resources.getSystem()");
        int r46 = kotlin.o0.a.a(TypedValue.applyDimension(1, r44, r45.getDisplayMetrics()));
        ViewGroup.LayoutParams r47 = getLayoutParams();
        if ((r47 instanceof ViewGroup.MarginLayoutParams) == true) goto L53;
        r47 = null;
    L53:
        ViewGroup.MarginLayoutParams r48 = (ViewGroup.MarginLayoutParams) r47;
        if (r48 == null) goto L56;
        int r49 = r48.rightMargin;
    L57:
        ViewGroup.LayoutParams r120 = getLayoutParams();
        if ((r120 instanceof ViewGroup.MarginLayoutParams) == false) goto L61;
        r4 = r120;
    L61:
        ViewGroup.MarginLayoutParams r50 = (ViewGroup.MarginLayoutParams) r4;
        if (r50 == null) goto L64;
        int r51 = r50.bottomMargin;
    L65:
        r40.setMargins(r43, r46, r49, r51);
        r40.bottomToBottom = -1;
        r119.setLayoutParams(r40);
        FrameLayout r121 = this.O;
        ViewGroup.LayoutParams r52 = r121.getLayoutParams();
        Objects.requireNonNull(r52, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r53 = (ConstraintLayout.LayoutParams) r52;
        r53.topToTop = 0;
        r53.bottomToBottom = 0;
        r121.setLayoutParams(r53);
        r110 = this.N;
        ViewGroup.LayoutParams r54 = r110.getLayoutParams();
        Objects.requireNonNull(r54, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        r22 = (ConstraintLayout.LayoutParams) r54;
        Resources r55 = Resources.getSystem();
        o.e(r55, "Resources.getSystem()");
        int r56 = kotlin.o0.a.a(TypedValue.applyDimension(1, r44, r55.getDisplayMetrics()));
        Resources r57 = Resources.getSystem();
        o.e(r57, "Resources.getSystem()");
        r22.setMargins(r56, kotlin.o0.a.a(TypedValue.applyDimension(1, r44, r57.getDisplayMetrics())), 0, 0);
        r22.topToTop = 0;
        r22.bottomToBottom = -1;
        goto L24
    L64:
        r51 = 0;
        goto L65
    L56:
        r49 = 0;
        goto L57
    L49:
        r43 = 0;
        goto L50
    L42:
        r36 = 12;
        goto L43
    L38:
        r116 = 0;
        goto L39
    L31:
        r34 = 0;
        goto L32
    }

    public final void setText(String r2) {
        this.M.setText(r2);
        v("setText");
        x(this.M.getText());
    }

    public void x(Editable r1) {
    }
}
