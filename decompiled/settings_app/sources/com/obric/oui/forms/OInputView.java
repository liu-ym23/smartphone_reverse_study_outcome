package com.obric.oui.forms;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.icu.text.DateFormat;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.DigitsKeyListener;
import android.text.method.KeyListener;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
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
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.ViewGroupKt;
import com.android.settings.DataUsageFragment;
import com.android.settings.search.IndexDatabaseHelper;
import com.obric.common.oui.R;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.common.util.ViewExtensionsKt;
import com.obric.oui.layout.OUIConstraintLayout;
import com.obric.oui.text.OTextView;
import com.obric.oui.utils.log.L;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import obric.widget.calendar.MonthWeekEventsView;

/* JADX INFO: compiled from: OInputView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000è\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b'\n\u0002\u0018\u0002\n\u0002\b\b\b\u0017\u0018\u0000 Þ\u00012\u00020\u0001:\nÞ\u0001ß\u0001à\u0001á\u0001â\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010Y\u001a\u00020Z2\b\u0010[\u001a\u0004\u0018\u00010\\J\u0010\u0010]\u001a\u00020Z2\u0006\u0010^\u001a\u00020\u0014H\u0002J \u0010_\u001a\u00020\u00072\u0006\u0010`\u001a\u00020\u00072\u0006\u0010a\u001a\u00020\u00072\u0006\u0010b\u001a\u00020)H\u0002J\u0012\u0010c\u001a\u00020\n2\b\u0010d\u001a\u0004\u0018\u00010eH\u0016J\u0012\u0010f\u001a\u00020Z2\b\u0010g\u001a\u0004\u0018\u00010hH\u0016J\u0006\u0010i\u001a\u00020ZJ\u0006\u0010j\u001a\u00020ZJ(\u0010k\u001a\u0004\u0018\u00010&2\b\b\u0002\u0010l\u001a\u00020\u00072\b\b\u0002\u0010m\u001a\u00020\u00072\b\b\u0002\u0010n\u001a\u00020oH\u0002J(\u0010p\u001a\u0004\u0018\u00010&2\b\b\u0002\u0010l\u001a\u00020\u00072\b\b\u0002\u0010m\u001a\u00020\u00072\b\b\u0002\u0010n\u001a\u00020oH\u0002J\b\u0010q\u001a\u0004\u0018\u00010rJ\u0012\u0010s\u001a\u00020\u00072\b\u0010t\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010u\u001a\u00020\u0007H\u0016J\b\u0010v\u001a\u0004\u0018\u00010\u0018J\b\u0010w\u001a\u00020)H\u0002J\u0006\u0010x\u001a\u00020\u0007J\u0006\u0010y\u001a\u00020\u0007J\n\u0010z\u001a\u0004\u0018\u00010{H\u0016J\u0010\u0010|\u001a\u00020)2\u0006\u0010}\u001a\u00020MH\u0002J\n\u0010~\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u007f\u001a\u00020ZH\u0002J\t\u0010\u0080\u0001\u001a\u00020\nH\u0002J\u0013\u0010\u0081\u0001\u001a\u00020\n2\b\u0010d\u001a\u0004\u0018\u00010eH\u0016J6\u0010\u0082\u0001\u001a\u00020Z2\u0007\u0010\u0083\u0001\u001a\u00020\n2\u0007\u0010\u0084\u0001\u001a\u00020\u00072\u0007\u0010\u0085\u0001\u001a\u00020\u00072\u0007\u0010\u0086\u0001\u001a\u00020\u00072\u0007\u0010\u0087\u0001\u001a\u00020\u0007H\u0014J\u001b\u0010\u0088\u0001\u001a\u00020Z2\u0007\u0010\u0089\u0001\u001a\u00020\u00072\u0007\u0010\u008a\u0001\u001a\u00020\u0007H\u0014J\u0014\u0010\u008b\u0001\u001a\u00020\n2\t\u0010\u008c\u0001\u001a\u0004\u0018\u00010eH\u0016J\u0014\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u00182\u0007\u0010\u008e\u0001\u001a\u00020\u0007H\u0002J\u0012\u0010\u008f\u0001\u001a\u00020Z2\u0007\u0010\u0090\u0001\u001a\u00020\nH\u0002J\u0011\u0010\u0091\u0001\u001a\u00020Z2\b\u0010[\u001a\u0004\u0018\u00010\\J/\u0010\u0092\u0001\u001a\u00020Z2&\u0010\u0093\u0001\u001a!\u0012\u0016\u0012\u00140H¢\u0006\u000f\b\u0095\u0001\u0012\n\b\u0096\u0001\u0012\u0005\b\b(\u0097\u0001\u0012\u0004\u0012\u00020Z0\u0094\u0001J\u0010\u0010\u0098\u0001\u001a\u00020Z2\u0007\u0010\u0099\u0001\u001a\u00020\nJ\u0007\u0010\u009a\u0001\u001a\u00020ZJ\u0010\u0010\u009b\u0001\u001a\u00020Z2\u0007\u0010\u009c\u0001\u001a\u00020\u0007J\u0010\u0010\u009d\u0001\u001a\u00020Z2\u0007\u0010\u009e\u0001\u001a\u00020\nJ\u0010\u0010\u009f\u0001\u001a\u00020Z2\u0007\u0010 \u0001\u001a\u00020rJ\u0012\u0010¡\u0001\u001a\u00020Z2\t\u0010¢\u0001\u001a\u0004\u0018\u00010\u0014J\u0012\u0010£\u0001\u001a\u00020Z2\t\u0010¤\u0001\u001a\u0004\u0018\u00010\u0018J\u0012\u0010¥\u0001\u001a\u00020Z2\u0007\u0010\u009e\u0001\u001a\u00020\nH\u0016J\u0010\u0010¦\u0001\u001a\u00020Z2\u0007\u0010§\u0001\u001a\u00020\nJ\u0012\u0010¨\u0001\u001a\u00020Z2\t\u0010¢\u0001\u001a\u0004\u0018\u00010\u0014J\u0011\u0010©\u0001\u001a\u00020Z2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0014J\u0010\u0010ª\u0001\u001a\u00020Z2\u0007\u0010«\u0001\u001a\u00020\u0007J\u0012\u0010¬\u0001\u001a\u00020Z2\t\b\u0001\u0010\u00ad\u0001\u001a\u00020\u0007J\u0010\u0010®\u0001\u001a\u00020Z2\u0007\u0010¯\u0001\u001a\u00020\u0007J\u000f\u0010°\u0001\u001a\u00020Z2\u0006\u0010\u001c\u001a\u00020\nJ\u0013\u0010±\u0001\u001a\u00020Z2\n\u0010²\u0001\u001a\u0005\u0018\u00010³\u0001J\u0012\u0010´\u0001\u001a\u00020Z2\t\u0010µ\u0001\u001a\u0004\u0018\u00010\u0014J/\u0010¶\u0001\u001a\u00020Z2&\u0010\u0093\u0001\u001a!\u0012\u0016\u0012\u00140H¢\u0006\u000f\b\u0095\u0001\u0012\n\b\u0096\u0001\u0012\u0005\b\b(\u0097\u0001\u0012\u0004\u0012\u00020Z0\u0094\u0001J\u0012\u0010·\u0001\u001a\u00020Z2\u0007\u0010¸\u0001\u001a\u00020\u0007H\u0016J\u0010\u0010¹\u0001\u001a\u00020Z2\u0007\u0010¸\u0001\u001a\u00020\u0007J\u0010\u0010º\u0001\u001a\u00020Z2\u0007\u0010»\u0001\u001a\u00020\u0007J\u0014\u0010¼\u0001\u001a\u00020Z2\t\u0010½\u0001\u001a\u0004\u0018\u00010.H\u0016J\u0012\u0010¾\u0001\u001a\u00020Z2\t\u0010½\u0001\u001a\u0004\u0018\u00010.J\u0014\u0010¿\u0001\u001a\u00020Z2\t\u0010½\u0001\u001a\u0004\u0018\u00010{H\u0016J\u0010\u0010À\u0001\u001a\u00020Z2\u0007\u0010Á\u0001\u001a\u000200J\u0012\u0010Â\u0001\u001a\u00020Z2\t\u0010½\u0001\u001a\u0004\u0018\u000102J\u000f\u0010Ã\u0001\u001a\u00020Z2\u0006\u00104\u001a\u00020\u0007J\u0010\u0010Ä\u0001\u001a\u00020Z2\u0007\u0010Å\u0001\u001a\u00020\nJ\u0010\u0010Æ\u0001\u001a\u00020Z2\u0007\u0010Å\u0001\u001a\u00020\nJ\u0010\u0010Ç\u0001\u001a\u00020Z2\u0007\u0010Å\u0001\u001a\u00020\nJ\u0010\u0010È\u0001\u001a\u00020Z2\u0007\u0010Å\u0001\u001a\u00020\nJ\u0010\u0010É\u0001\u001a\u00020Z2\u0007\u0010Ê\u0001\u001a\u00020\nJ\u0012\u0010Ë\u0001\u001a\u00020Z2\t\u0010Ì\u0001\u001a\u0004\u0018\u00010\u0014J\u000f\u00106\u001a\u00020Z2\u0007\u0010Å\u0001\u001a\u00020\nJ\u0010\u0010Í\u0001\u001a\u00020Z2\u0007\u0010Å\u0001\u001a\u00020\nJ\u0012\u0010Î\u0001\u001a\u00020Z2\u0007\u0010Ï\u0001\u001a\u00020MH\u0002J\u0012\u0010Ð\u0001\u001a\u00020Z2\u0007\u0010Ï\u0001\u001a\u00020MH\u0002J\u0012\u0010Ñ\u0001\u001a\u00020Z2\u0007\u0010Ï\u0001\u001a\u00020MH\u0002J\t\u0010Ò\u0001\u001a\u00020ZH\u0002J\u0012\u0010Ó\u0001\u001a\u00020Z2\u0007\u0010Ô\u0001\u001a\u00020\nH\u0002J\u0012\u0010Õ\u0001\u001a\u00020Z2\u0007\u0010Ö\u0001\u001a\u00020\nH\u0002J\t\u0010×\u0001\u001a\u00020ZH\u0002J\u0010\u0010×\u0001\u001a\u00020Z2\u0007\u0010Å\u0001\u001a\u00020\nJ\t\u0010Ø\u0001\u001a\u00020ZH\u0002J$\u0010Ù\u0001\u001a\u00020Z2\b\u0010Ú\u0001\u001a\u00030Û\u00012\u0007\u0010Ï\u0001\u001a\u00020M2\u0006\u0010^\u001a\u00020\u0014H\u0002J\u0012\u0010Ü\u0001\u001a\u00020Z2\t\u0010Ì\u0001\u001a\u0004\u0018\u00010\u0014J\u0010\u0010Ý\u0001\u001a\u00020Z2\u0007\u0010Å\u0001\u001a\u00020\nR\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001fR\u000e\u0010 \u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020@X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020BX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020@X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020@X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020FX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020HX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020FX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020KX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010L\u001a\u0004\u0018\u00010MX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010N\u001a\u00020O¢\u0006\b\n\u0000\u001a\u0004\bP\u0010QR\u000e\u0010R\u001a\u00020@X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010S\u001a\u00020HX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010T\u001a\u00020FX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010U\u001a\u00020FX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010V\u001a\u00020WX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010X\u001a\u00020KX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006ã\u0001"}, d2 = {"Lcom/obric/oui/forms/OInputView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "alwaysHideEye", "", "autoHideSoftInputWhenLoseFocus", "getAutoHideSoftInputWhenLoseFocus", "()Z", "setAutoHideSoftInputWhenLoseFocus", "(Z)V", "autoShowClear", "bgResId", "comboInputEnabled", "commonTip", "", "digits", "", "ellipsize", "Landroid/text/TextUtils$TruncateAt;", "errorTip", "gravity", "hint", "inScrollableView", "initText", "inputHeight", "Ljava/lang/Integer;", "inputMode", "inputType", "insideLabel", "isEnable", "isError", "labelHideAnimator", "Landroid/animation/ValueAnimator;", "labelShowAnimator", "lastScrollX", "", "lastScrollY", "limitCount", "maxLines", "onComboArrowClickListener", "Landroid/view/View$OnClickListener;", "onTextClearedListener", "Lcom/obric/oui/forms/OInputView$OnTextClearedListener;", "onTextExceedLengthListener", "Lcom/obric/oui/forms/OInputView$OnTextExceedLengthListener;", "orientation", "radius", "shouldDispatchToInput", "showCommonTip", "showLabel", "showLabelAnim", "showLabelIcon", "showLimitIndicator", "showResizer", "singleLine", "transparentBg", "transparentBorder", "vActionContainer", "Landroid/view/View;", "vBorderContainer", "Lcom/obric/oui/layout/OUIConstraintLayout;", "vClear", "vComboArrow", "vCommonTip", "Lcom/obric/oui/text/OTextView;", "vCustomActionContainer", "Landroid/widget/FrameLayout;", "vErrorTip", "vEye", "Landroid/widget/ImageView;", "vFakeLabel", "Landroid/widget/TextView;", "vInput", "Lcom/obric/oui/forms/OEditText;", "getVInput", "()Lcom/obric/oui/forms/OEditText;", "vInputResizer", "vLeftViewContainer", "vLimitIndicator", "vTitle", "vTitleContainer", "Landroid/widget/LinearLayout;", "vTitleIcon", "addTextChangedListener", "", "watcher", "Landroid/text/TextWatcher;", "adjustInputViewAndLabel", "scene", "blendColors", "startColor", "endColor", "ratio", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "doAfterTextStateChange", "editable", "Landroid/text/Editable;", "enableTransparentBg", "enableTransparentBorder", "genLabelHideAnim", "labelTextColor", "inputHintTextColor", "duration", "", "genLabelShowAnim", "getCommitCompletionListener", "Lcom/obric/oui/forms/OEditText$CommitCompletionListener;", "getConstraintLength", DateFormat.SECOND, "getContentViewRes", "getEllipsize", "getFakeInputOffsetY", "getInputType", "getLimitCount", "getOnFocusChangeListener", "Landroid/view/View$OnFocusChangeListener;", "getScaleRatio", "vFakeInput", "getText", "hideSoftInput", "isPasswordMode", "onInterceptTouchEvent", "onLayout", "changed", "left", "top", "right", "bottom", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onTouchEvent", "event", "parseEllipsize", "value", "playLabelAnim", "hasFocus", "removeTextChangedListener", "setActionView", "creator", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "parent", "setAlwaysHideEye", "hide", "setAutoHideSoft", "setBgResId", "resId", "setComboInputEnabled", IndexDatabaseHelper.IndexColumns.ENABLED, "setCommitCompletionListener", "commitCompletionListener", "setCommonTip", "tip", "setEllipsize", "where", "setEnabled", "setErrorState", "error", "setErrorTip", "setHint", "setInputHeight", MonthWeekEventsView.VIEW_PARAMS_HEIGHT, "setInputMode", "mode", "setInputType", "type", "setIsInScrollableView", "setKeyListener", "keyListener", "Landroid/text/method/KeyListener;", "setLabel", "label", "setLeftView", "setLimitCount", DataUsageFragment.INTENT_EXTRA_LIMIT, "setLimitCountValue", "setMaxLines", "max", "setOnClickListener", "l", "setOnComboArrowClickListener", "setOnFocusChangeListener", "setOnTextClearedListener", "listener", "setOnTextExceedLengthListener", "setRadius", "setShowLabel", "show", "setShowLabelAnim", "setShowLabelIcon", "setShowLimitIndicator", "setSingleLine", "single", "setText", "text", "showErrorTip", "showFakeLabel", "fakeLabel", "showNoLabel", "showRealLabel", "showSoftInput", "updateBackground", "pressed", "updateBorder", "focus", "updateClearVisibility", "updateEyeVisibility", "updateLabelUIState", "state", "Lcom/obric/oui/forms/OInputView$LabelUIState;", "updateLimitIndicator", "updateResizerVisibility", "Companion", "InputMode", "LabelUIState", "OnTextClearedListener", "OnTextExceedLengthListener", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OInputView extends ConstraintLayout {
    public static final Companion Companion = null;
    private static final float FAKE_LABEL_OFFSET_Y = -11.0f;
    private static final float FAKE_LABEL_TARGET_SCALE = 0.857143f;
    public static final int HORIZONTAL = 1;
    public static final int INPUT_MODE_COMBO = 1;
    public static final int INPUT_MODE_TEXT = 0;
    private static final long LABEL_ANIM_DURATION = 200;
    public static final String TAG = "OInputView";
    public static final int VERTICAL = 0;
    private boolean alwaysHideEye;
    private boolean autoHideSoftInputWhenLoseFocus;
    private boolean autoShowClear;
    private int bgResId;
    private boolean comboInputEnabled;
    private String commonTip;
    private CharSequence digits;
    private TextUtils.TruncateAt ellipsize;
    private String errorTip;
    private int gravity;
    private String hint;
    private boolean inScrollableView;
    private String initText;
    private Integer inputHeight;
    private int inputMode;
    private int inputType;
    private String insideLabel;
    private boolean isEnable;
    private boolean isError;
    private ValueAnimator labelHideAnimator;
    private ValueAnimator labelShowAnimator;
    private float lastScrollX;
    private float lastScrollY;
    private int limitCount;
    private int maxLines;
    private View.OnClickListener onComboArrowClickListener;
    private OnTextClearedListener onTextClearedListener;
    private OnTextExceedLengthListener onTextExceedLengthListener;
    private int orientation;
    private int radius;
    private boolean shouldDispatchToInput;
    private boolean showCommonTip;
    private boolean showLabel;
    private boolean showLabelAnim;
    private boolean showLabelIcon;
    private boolean showLimitIndicator;
    private boolean showResizer;
    private boolean singleLine;
    private boolean transparentBg;
    private boolean transparentBorder;
    private final View vActionContainer;
    private final OUIConstraintLayout vBorderContainer;
    private final View vClear;
    private final View vComboArrow;
    private final OTextView vCommonTip;
    private final FrameLayout vCustomActionContainer;
    private final OTextView vErrorTip;
    private final ImageView vEye;
    private TextView vFakeLabel;
    private final OEditText vInput;
    private final View vInputResizer;
    private final FrameLayout vLeftViewContainer;
    private final OTextView vLimitIndicator;
    private final OTextView vTitle;
    private final LinearLayout vTitleContainer;
    private final ImageView vTitleIcon;

    /* JADX INFO: compiled from: OInputView.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/oui/forms/OInputView$Companion;", "", "()V", "FAKE_LABEL_OFFSET_Y", "", "FAKE_LABEL_TARGET_SCALE", "HORIZONTAL", "", "INPUT_MODE_COMBO", "INPUT_MODE_TEXT", "LABEL_ANIM_DURATION", "", "TAG", "", "VERTICAL", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: OInputView.kt */
    @Retention(RetentionPolicy.RUNTIME)
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0086\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/obric/oui/forms/OInputView$InputMode;", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public @interface InputMode {
    }

    /* JADX INFO: compiled from: OInputView.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/forms/OInputView$LabelUIState;", "", "(Ljava/lang/String;I)V", "REAL_LABEL_SHOW", "FAKE_LABEL_SHOW", "LABEL_NONE", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum LabelUIState extends Enum<LabelUIState> {
        private static final /* synthetic */ LabelUIState[] $VALUES = null;
        public static final LabelUIState FAKE_LABEL_SHOW = null;
        public static final LabelUIState LABEL_NONE = null;
        public static final LabelUIState REAL_LABEL_SHOW = null;

        private static final /* synthetic */ LabelUIState[] $values() {
            return new LabelUIState[]{REAL_LABEL_SHOW, FAKE_LABEL_SHOW, LABEL_NONE};
        }

        public static LabelUIState valueOf(String r1) {
            return (LabelUIState) Enum.valueOf(LabelUIState.class, r1);
        }

        public static LabelUIState[] values() {
            return (LabelUIState[]) $VALUES.clone();
        }

        private LabelUIState(String r1, int r2) {
            super(r1, r2);
        }

        static {
            REAL_LABEL_SHOW = new LabelUIState("REAL_LABEL_SHOW", 0);
            FAKE_LABEL_SHOW = new LabelUIState("FAKE_LABEL_SHOW", 1);
            LABEL_NONE = new LabelUIState("LABEL_NONE", 2);
            $VALUES = $values();
        }
    }

    /* JADX INFO: compiled from: OInputView.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/forms/OInputView$OnTextClearedListener;", "", "afterClear", "", "beforeClear", "text", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnTextClearedListener {
        void afterClear();

        void beforeClear(String r1);
    }

    /* JADX INFO: compiled from: OInputView.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/forms/OInputView$OnTextExceedLengthListener;", "", "textExceedLength", "", DateFormat.SECOND, "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnTextExceedLengthListener {
        void textExceedLength(String r1);
    }

    /* JADX INFO: compiled from: OInputView.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[LabelUIState.values().length];
            r0[LabelUIState.REAL_LABEL_SHOW.ordinal()] = 1;
            r0[LabelUIState.FAKE_LABEL_SHOW.ordinal()] = 2;
            r0[LabelUIState.LABEL_NONE.ordinal()] = 3;
            $EnumSwitchMapping$0 = r0;
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$EPqC_mzuaX9Ry-0zElIgnKZj7W0, reason: not valid java name */
    public static /* synthetic */ void m1197$r8$lambda$EPqC_mzuaX9Ry0zElIgnKZj7W0(OInputView r0, View r1) {
        m1200_init_$lambda2(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$KO4WQs6Bqp62Cqr4qgf4NxbZD-s, reason: not valid java name */
    public static /* synthetic */ void m1198$r8$lambda$KO4WQs6Bqp62Cqr4qgf4NxbZDs(OInputView r0, View r1) {
        m1201_init_$lambda3(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$SYSx3isEZPpqzYb1lP3uY2QcJJY(OInputView r0, View r1) {
        m1202_init_$lambda4(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$gnmwHB0yD4gH-05Z-MpO8O2Cmdk, reason: not valid java name */
    public static /* synthetic */ void m1199$r8$lambda$gnmwHB0yD4gH05ZMpO8O2Cmdk(float r0, OInputView r1, int r2, int r3, float r4, TextView r5, ValueAnimator r6) {
        m1204genLabelShowAnim$lambda17(r0, r1, r2, r3, r4, r5, r6);
    }

    public static /* synthetic */ void $r8$lambda$hIako26qIeCTv7C0iCOxMprCrNo(float r0, OInputView r1, int r2, int r3, float r4, TextView r5, ValueAnimator r6) {
        m1203genLabelHideAnim$lambda18(r0, r1, r2, r3, r4, r5, r6);
    }

    static {
        Companion = new Companion(null);
    }

    public OInputView(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, null, 0, 6, null);
    }

    public OInputView(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, 4, null);
    }

    public void doAfterTextStateChange(Editable r1) {
    }

    public static final /* synthetic */ int access$getLimitCount$p(OInputView r0) {
        return r0.limitCount;
    }

    public static final /* synthetic */ OnTextExceedLengthListener access$getOnTextExceedLengthListener$p(OInputView r0) {
        return r0.onTextExceedLengthListener;
    }

    public static final /* synthetic */ boolean access$getShowCommonTip$p(OInputView r0) {
        return r0.showCommonTip;
    }

    public static final /* synthetic */ void access$hideSoftInput(OInputView r0) {
        r0.hideSoftInput();
    }

    public static final /* synthetic */ boolean access$isError$p(OInputView r0) {
        return r0.isError;
    }

    public static final /* synthetic */ void access$playLabelAnim(OInputView r0, boolean r1) {
        r0.playLabelAnim(r1);
    }

    public static final /* synthetic */ void access$showSoftInput(OInputView r0) {
        r0.showSoftInput();
    }

    public static final /* synthetic */ void access$updateBackground(OInputView r0, boolean r1) {
        r0.updateBackground(r1);
    }

    public static final /* synthetic */ void access$updateBorder(OInputView r0, boolean r1) {
        r0.updateBorder(r1);
    }

    public static final /* synthetic */ void access$updateClearVisibility(OInputView r0) {
        r0.updateClearVisibility();
    }

    public static final /* synthetic */ void access$updateEyeVisibility(OInputView r0) {
        r0.updateEyeVisibility();
    }

    public static final /* synthetic */ void access$updateLabelUIState(OInputView r0, LabelUIState r1, TextView r2, String r3) {
        r0.updateLabelUIState(r1, r2, r3);
    }

    public /* synthetic */ OInputView(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public OInputView(Context r8, AttributeSet r9, int r10) {
        Intrinsics.checkNotNullParameter(r8, "context");
        super(r8, r9, r10);
        int r0 = 1;
        this.comboInputEnabled = true;
        this.singleLine = true;
        this.maxLines = Integer.MAX_VALUE;
        this.gravity = 16;
        this.autoShowClear = true;
        this.showResizer = true;
        this.limitCount = -1;
        this.showLabel = true;
        this.showLabelIcon = true;
        this.isEnable = true;
        this.radius = OUnitExtensionKt.vdp(this, 10);
        TypedArray r11 = r8.getTheme().obtainStyledAttributes(r9, R.styleable.OInputView, r10, 0);
        this.inScrollableView = r11.getBoolean(R.styleable.OInputView_oui_inputInScrollableView, false);
        this.autoShowClear = r11.getBoolean(R.styleable.OInputView_oui_autoShowClear, true);
        this.showResizer = r11.getBoolean(R.styleable.OInputView_oui_showResizer, true);
        this.showLabel = r11.getBoolean(R.styleable.OInputView_oui_showLabel, true);
        this.showLabelAnim = r11.getBoolean(R.styleable.OInputView_oui_showLabelAnim, false);
        this.showLabelIcon = r11.getBoolean(R.styleable.OInputView_oui_showLabelIcon, true);
        this.insideLabel = r11.getString(R.styleable.OInputView_oui_inputLabel);
        this.errorTip = r11.getString(R.styleable.OInputView_oui_errorTip);
        this.commonTip = r11.getString(R.styleable.OInputView_oui_commonTip);
        this.showCommonTip = r11.getBoolean(R.styleable.OInputView_oui_showCommonTip, false);
        this.radius = r11.getDimensionPixelSize(R.styleable.OInputView_oui_inputBorderRadius, this.radius);
        this.comboInputEnabled = r11.getBoolean(R.styleable.OInputView_oui_comboInputEnabled, true);
        this.inputMode = r11.getInt(R.styleable.OInputView_oui_inputMode, 0);
        this.singleLine = r11.getBoolean(R.styleable.OInputView_oui_inputSingleLine, true);
        int r12 = r11.getDimensionPixelSize(R.styleable.OInputView_oui_inputHeight, 0);
        if (r12 <= 0) goto L5;
        this.inputHeight = Integer.valueOf(r12);
    L5:
        this.limitCount = r11.getInt(R.styleable.OInputView_oui_limitCount, -1);
        this.showLimitIndicator = r11.getBoolean(R.styleable.OInputView_oui_showLimitIndicator, false);
        this.digits = r11.getText(R.styleable.OInputView_android_digits);
        this.hint = r11.getString(R.styleable.OInputView_android_hint);
        this.inputType = r11.getInt(R.styleable.OInputView_android_inputType, 0);
        this.initText = r11.getString(R.styleable.OInputView_android_text);
        this.isEnable = r11.getBoolean(R.styleable.OInputView_android_enabled, true);
        this.maxLines = r11.getInt(R.styleable.OInputView_android_maxLines, Integer.MAX_VALUE);
        this.orientation = r11.getInt(R.styleable.OInputView_android_orientation, 0);
        this.gravity = r11.getInt(R.styleable.OInputView_android_gravity, 16);
        if (r11.hasValue(R.styleable.OInputView_android_ellipsize) == false) goto L8;
        this.ellipsize = parseEllipsize(r11.getInt(R.styleable.OInputView_android_ellipsize, 0));
    L8:
        r11.recycle();
        LayoutInflater.from(r8).inflate(getContentViewRes(), this);
        View r13 = findViewById(R.id.o_input_border_container);
        Intrinsics.checkNotNullExpressionValue(r13, "findViewById(R.id.o_input_border_container)");
        OUIConstraintLayout r14 = (OUIConstraintLayout) r13;
        this.vBorderContainer = r14;
        r14.setRadius(this.radius);
        View r15 = findViewById(R.id.o_input_title_container);
        Intrinsics.checkNotNullExpressionValue(r15, "findViewById(R.id.o_input_title_container)");
        this.vTitleContainer = (LinearLayout) r15;
        View r16 = findViewById(R.id.o_input_title);
        Intrinsics.checkNotNullExpressionValue(r16, "findViewById(R.id.o_input_title)");
        this.vTitle = (OTextView) r16;
        View r17 = findViewById(R.id.o_input_title_icon);
        Intrinsics.checkNotNullExpressionValue(r17, "findViewById(R.id.o_input_title_icon)");
        this.vTitleIcon = (ImageView) r17;
        View r18 = findViewById(R.id.o_input);
        Intrinsics.checkNotNullExpressionValue(r18, "findViewById(R.id.o_input)");
        OEditText r19 = (OEditText) r18;
        this.vInput = r19;
        r19.setVerticalScrollBarEnabled(false);
        View r110 = findViewById(R.id.o_input_left_view_container);
        Intrinsics.checkNotNullExpressionValue(r110, "findViewById(R.id.o_input_left_view_container)");
        this.vLeftViewContainer = (FrameLayout) r110;
        View r111 = findViewById(R.id.o_input_custom_action_container);
        Intrinsics.checkNotNullExpressionValue(r111, "findViewById(R.id.o_input_custom_action_container)");
        this.vCustomActionContainer = (FrameLayout) r111;
        View r112 = findViewById(R.id.o_input_action_container);
        Intrinsics.checkNotNullExpressionValue(r112, "findViewById(R.id.o_input_action_container)");
        this.vActionContainer = r112;
        View r113 = findViewById(R.id.o_input_clear);
        Intrinsics.checkNotNullExpressionValue(r113, "findViewById(R.id.o_input_clear)");
        this.vClear = r113;
        View r1 = findViewById(R.id.o_input_combo_arrow);
        Intrinsics.checkNotNullExpressionValue(r1, "findViewById(R.id.o_input_combo_arrow)");
        this.vComboArrow = r1;
        View r2 = findViewById(R.id.o_input_eyes_slash);
        Intrinsics.checkNotNullExpressionValue(r2, "findViewById(R.id.o_input_eyes_slash)");
        ImageView r3 = (ImageView) r2;
        this.vEye = r3;
        View r4 = findViewById(R.id.o_input_resizer);
        Intrinsics.checkNotNullExpressionValue(r4, "findViewById(R.id.o_input_resizer)");
        this.vInputResizer = r4;
        View r5 = findViewById(R.id.o_input_error_tip);
        Intrinsics.checkNotNullExpressionValue(r5, "findViewById(R.id.o_input_error_tip)");
        this.vErrorTip = (OTextView) r5;
        View r6 = findViewById(R.id.o_input_common_tip);
        Intrinsics.checkNotNullExpressionValue(r6, "findViewById(R.id.o_input_common_tip)");
        this.vCommonTip = (OTextView) r6;
        View r7 = findViewById(R.id.o_input_limit_indicator);
        Intrinsics.checkNotNullExpressionValue(r7, "findViewById(R.id.o_input_limit_indicator)");
        this.vLimitIndicator = (OTextView) r7;
        this.vFakeLabel = (TextView) findViewById(R.id.o_input_view_fake_label);
        setFocusableInTouchMode(true);
        setFocusable(true);
        setDescendantFocusability(262144);
        CharSequence r20 = this.digits;
        if (r20 == null) goto L14;
        r19.setKeyListener(DigitsKeyListener.getInstance(String.valueOf(r20)));
        int r21 = this.inputType;
        if (r21 == 0) goto L13;
        r0 = r21;
    L13:
        this.inputType = r0;
    L14:
        r19.setGravity(this.gravity);
        Integer r22 = this.inputHeight;
        if (r22 == null) goto L18;
        setInputHeight(r22.intValue());
    L18:
        r19.onFocusChange$OUI_standardRelease(new AnonymousClass3(this));
        r19.onOnTouchEvent$OUI_standardRelease(new AnonymousClass4(this));
        r19.onTextChanged$OUI_standardRelease(new AnonymousClass5(this));
        r19.afterTextChanged$OUI_standardRelease(new AnonymousClass6(this));
        r113.setOnClickListener(new OInputView$$ExternalSyntheticLambda2(this));
        setCommonTip(this.commonTip);
        showCommonTip(this.showCommonTip);
        setErrorTip(this.errorTip);
        showErrorTip(false);
        setComboInputEnabled(this.comboInputEnabled);
        setLabel(this.insideLabel);
        setShowLabel(this.showLabel);
        setShowLabelIcon(this.showLabelIcon);
        setLimitCount(this.limitCount);
        setShowLimitIndicator(this.showLimitIndicator);
        setSingleLine(this.singleLine);
        setMaxLines(this.maxLines);
        setEllipsize(this.ellipsize);
        setHint(this.hint);
        setText(this.initText);
        setInputMode(this.inputMode);
        setEnabled(this.isEnable);
        updateClearVisibility();
        updateBorder(r19.hasFocus());
        int r23 = this.inputType;
        if (r23 == 0) goto L21;
        setInputType(r23);
    L21:
        updateEyeVisibility();
        r3.setOnClickListener(new OInputView$$ExternalSyntheticLambda3(this));
        r14.setOnClickListener(new OInputView$$ExternalSyntheticLambda4(this));
        adjustInputViewAndLabel("init");
    }

    public final OEditText getVInput() {
        return this.vInput;
    }

    public final boolean getAutoHideSoftInputWhenLoseFocus() {
        return this.autoHideSoftInputWhenLoseFocus;
    }

    public final void setAutoHideSoftInputWhenLoseFocus(boolean r1) {
        this.autoHideSoftInputWhenLoseFocus = r1;
    }

    /* JADX INFO: renamed from: _init_$lambda-2, reason: not valid java name */
    private static final void m1200_init_$lambda2(OInputView r1, View r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        OnTextClearedListener r3 = r1.onTextClearedListener;
        if (r3 == null) goto L10;
        Editable r0 = r1.vInput.getText();
        if (r0 != null) goto L8;
        String r4 = null;
    L9:
        r3.beforeClear(r4);
        goto L10
    L8:
        r4 = r0.toString();
    L10:
        r1.setText("");
        OnTextClearedListener r5 = r1.onTextClearedListener;
        if (r5 == null) goto L14;
        r5.afterClear();
    L14:
        r1.updateClearVisibility();
    }

    /* JADX INFO: renamed from: _init_$lambda-3, reason: not valid java name */
    private static final void m1201_init_$lambda3(OInputView r1, View r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        if (r1.inputType != r1.vInput.getInputType()) goto L5;
        r1.vEye.setImageResource(R.drawable.o_input_view_eyes_open);
        OEditText r3 = r1.vInput;
        r3.setInputType(r3.getInputType() | 144);
    L7:
        if (r1.vInput.hasFocus() == false) goto L14;
        OEditText r4 = r1.vInput;
        Editable r5 = r4.getText();
        if (r5 != null) goto L11;
        int r6 = 0;
    L12:
        r4.setSelection(r6);
        return;
    L11:
        r6 = r5.length();
        goto L12
    L14:
        return;
    L5:
        r1.vEye.setImageResource(R.drawable.o_input_view_eyes_close);
        r1.vInput.setInputType(r1.inputType);
        goto L7
    }

    /* JADX INFO: renamed from: _init_$lambda-4, reason: not valid java name */
    private static final void m1202_init_$lambda4(OInputView r1, View r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        r1.vInput.requestFocus();
        if (r1.vInput.hasFocus() == true) goto L5;
    L7:
        r1.showSoftInput();
        return;
    L5:
        if (r1.vInput.isCursorVisible() == true) goto L7;
        r1.vInput.setCursorVisible(true);
        goto L7
    }

    public int getContentViewRes() {
        return R.layout.o_input_view_layout_vertical;
    }

    public int getConstraintLength(CharSequence r1) {
        if (r1 != null) goto L5;
        return 0;
    L5:
        return r1.length();
    }

    public final void setAutoHideSoft() {
        this.autoHideSoftInputWhenLoseFocus = true;
    }

    public final void setKeyListener(KeyListener r1) {
        this.vInput.setKeyListener(r1);
    }

    private final void showSoftInput() {
        Object r0 = getContext().getSystemService("input_method");
        if ((r0 instanceof InputMethodManager) == false) goto L5;
        InputMethodManager r1 = (InputMethodManager) r0;
    L6:
        if (r1 == null) goto L10;
        r1.showSoftInput(this.vInput, 0);
        return;
    L10:
        return;
    L5:
        r1 = null;
        goto L6
    }

    private final void hideSoftInput() {
        Object r0 = getContext().getSystemService("input_method");
        if ((r0 instanceof InputMethodManager) == false) goto L5;
        InputMethodManager r1 = (InputMethodManager) r0;
    L6:
        if (r1 == null) goto L10;
        r1.hideSoftInputFromWindow(this.vInput.getWindowToken(), 0);
        return;
    L10:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void setRadius(int r2) {
        if (r2 != this.radius) goto L5;
        return;
    L5:
        this.radius = r2;
        this.vBorderContainer.setRadius(r2);
    }

    public final void setInputType(int r2) {
        if ((r2 & 1) == 0) goto L5;
    L11:
        this.inputType = r2;
        if (r2 != this.vInput.getInputType()) goto L15;
        doAfterTextStateChange(this.vInput.getText());
        return;
    L15:
        this.vInput.setInputType(this.inputType);
        updateEyeVisibility();
        doAfterTextStateChange(this.vInput.getText());
        return;
    L5:
        if ((r2 & 2) != 0) goto L11;
        if ((r2 & 3) != 0) goto L11;
        if ((r2 & 4) != 0) goto L11;
        r2 = r2 | 1;
        goto L11
    }

    public final int getInputType() {
        return this.inputType;
    }

    public final void setCommitCompletionListener(OEditText.CommitCompletionListener r2) {
        Intrinsics.checkNotNullParameter(r2, "commitCompletionListener");
        this.vInput.setCommitCompletionListener(r2);
    }

    public final OEditText.CommitCompletionListener getCommitCompletionListener() {
        return this.vInput.getCommitCompletionListener();
    }

    @Override // android.view.View
    public void setEnabled(boolean r3) {
        this.isEnable = r3;
        super.setEnabled(r3);
        Iterator<View> r0 = ViewGroupKt.getChildren(this).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().setEnabled(r3);
        goto L4
    L6:
        this.vInput.setEnabled(r3);
        updateBorder(this.vInput.hasFocus());
        updateBackground(false);
    }

    public final void setErrorState(boolean r1) {
        this.isError = r1;
        updateBorder(this.vInput.hasFocus());
        updateBackground(false);
    }

    public final void updateClearVisibility(boolean r5) {
        boolean r0 = false;
        this.autoShowClear = false;
        ViewExtensionsKt.setVisibility(this.vClear, r5);
        if (r5 == false) goto L5;
    L19:
        boolean r2 = false;
    L20:
        ViewExtensionsKt.setVisibility(this.vEye, r2);
        View r3 = this.vComboArrow;
        if (r5 == false) goto L23;
    L25:
        boolean r6 = false;
    L26:
        ViewExtensionsKt.setVisibility(r3, r6);
        View r7 = this.vActionContainer;
        if (this.vClear.getVisibility() != 0) goto L29;
        boolean r4 = true;
    L30:
        if (r4 == false) goto L32;
    L41:
        r0 = true;
    L42:
        ViewExtensionsKt.setVisibility(r7, r0);
        return;
    L32:
        if (this.vEye.getVisibility() != 0) goto L34;
        boolean r8 = true;
    L35:
        if (r8 == true) goto L41;
        if (this.vComboArrow.getVisibility() != 0) goto L39;
        boolean r9 = true;
    L40:
        if (r9 == false) goto L42;
    L39:
        r9 = false;
        goto L40
    L34:
        r8 = false;
        goto L35
    L29:
        r4 = false;
        goto L30
    L23:
        if (this.inputMode != 1) goto L25;
        r6 = true;
        goto L26
    L5:
        if (isPasswordMode() == false) goto L19;
        if (this.isEnable == false) goto L19;
        Editable r10 = this.vInput.getText();
        if (r10 != null) goto L11;
    L14:
        boolean r11 = true;
    L15:
        if (r11 == true) goto L19;
        if (this.alwaysHideEye == true) goto L19;
        r2 = true;
        goto L20
    L11:
        if (r10.length() == 0) goto L14;
        r11 = false;
        goto L15
    }

    public final void setIsInScrollableView(boolean r1) {
        this.inScrollableView = r1;
    }

    public final void updateResizerVisibility(boolean r2) {
        this.showResizer = r2;
        View r0 = this.vInputResizer;
        if (r2 == true) goto L5;
    L7:
        boolean r1 = false;
    L8:
        ViewExtensionsKt.setVisibility(r0, r1);
        return;
    L5:
        if (this.singleLine == true) goto L7;
        r1 = true;
        goto L8
    }

    private final void updateClearVisibility() {
        if (this.autoShowClear == true) goto L5;
        return;
    L5:
        boolean r1 = true;
        if (isPasswordMode() == false) goto L8;
    L22:
        boolean r0 = false;
    L23:
        ViewExtensionsKt.setVisibility(this.vClear, r0);
        if (r0 == false) goto L26;
        ViewExtensionsKt.setVisibility(this.vEye, false);
    L26:
        View r2 = this.vActionContainer;
        if (this.vClear.getVisibility() != 0) goto L29;
        boolean r3 = true;
    L30:
        if (r3 == false) goto L32;
    L43:
        ViewExtensionsKt.setVisibility(r2, r1);
        return;
    L32:
        if (this.vEye.getVisibility() != 0) goto L34;
        boolean r4 = true;
    L35:
        if (r4 == true) goto L43;
        if (this.vComboArrow.getVisibility() != 0) goto L39;
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
        if (this.inputMode != 0) goto L22;
        if (this.isEnable == false) goto L22;
        if (this.vInput.hasFocus() == false) goto L22;
        Editable r6 = this.vInput.getText();
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

    private final void updateEyeVisibility() {
        boolean r1 = true;
        if (isPasswordMode() == true) goto L5;
    L17:
        boolean r0 = false;
    L18:
        ViewExtensionsKt.setVisibility(this.vEye, r0);
        if (r0 == false) goto L21;
        ViewExtensionsKt.setVisibility(this.vClear, false);
    L21:
        View r2 = this.vActionContainer;
        if (this.vClear.getVisibility() != 0) goto L24;
        boolean r3 = true;
    L25:
        if (r3 == false) goto L27;
    L38:
        ViewExtensionsKt.setVisibility(r2, r1);
        return;
    L27:
        if (this.vEye.getVisibility() != 0) goto L29;
        boolean r4 = true;
    L30:
        if (r4 == true) goto L38;
        if (this.vComboArrow.getVisibility() != 0) goto L34;
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
        if (this.isEnable == false) goto L17;
        Editable r6 = this.vInput.getText();
        if (r6 != null) goto L9;
    L12:
        boolean r7 = true;
    L13:
        if (r7 == true) goto L17;
        if (this.alwaysHideEye == true) goto L17;
        r0 = true;
        goto L18
    L9:
        if (r6.length() == 0) goto L12;
        r7 = false;
        goto L13
    }

    private final boolean isPasswordMode() {
        int r5 = this.inputType & 4095;
        if (r5 != 129) goto L5;
        boolean r0 = true;
    L7:
        if (r5 != 225) goto L9;
        boolean r3 = true;
    L11:
        if (r5 != 18) goto L13;
        boolean r6 = true;
    L14:
        if (r0 == true) goto L20;
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
        r0 = false;
        goto L7
    }

    public final void setLabel(String r1) {
        this.insideLabel = r1;
        this.vTitle.setText(r1);
    }

    public final void setShowLabel(boolean r5) {
        this.showLabel = r5;
        ViewExtensionsKt.setVisibility(this.vTitleContainer, r5);
        OEditText r6 = this.vInput;
        ViewGroup.LayoutParams r0 = r6.getLayoutParams();
        if (r0 == null) goto L11;
        ConstraintLayout.LayoutParams r1 = (ConstraintLayout.LayoutParams) r0;
        ConstraintLayout.LayoutParams r2 = r1;
        if (this.showLabel == false) goto L7;
        OInputView r3 = this;
        int r4 = 16;
    L8:
        r2.goneLeftMargin = OUnitExtensionKt.vdp(r3, r4);
        r2.goneStartMargin = r2.goneLeftMargin;
        r6.setLayoutParams(r1);
        adjustInputViewAndLabel("setShowLabel");
        return;
    L7:
        r3 = this;
        r4 = 12;
        goto L8
    L11:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    }

    public final void setShowLabelAnim(boolean r1) {
        this.showLabelAnim = r1;
        adjustInputViewAndLabel("setShowLabelAnim");
    }

    public final void setShowLabelIcon(boolean r1) {
        this.showLabelIcon = r1;
        ViewExtensionsKt.setVisibility(this.vTitleIcon, r1);
    }

    public final void setInputHeight(int r3) {
        this.inputHeight = Integer.valueOf(r3);
        OEditText r2 = this.vInput;
        ViewGroup.LayoutParams r0 = r2.getLayoutParams();
        if (r0 == null) goto L7;
        ConstraintLayout.LayoutParams r1 = (ConstraintLayout.LayoutParams) r0;
        r1.height = r3;
        r2.setLayoutParams(r1);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    }

    public String getText() {
        Editable r0 = this.vInput.getText();
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.toString();
    }

    public final void setText(String r2) {
        this.vInput.setText(r2);
        adjustInputViewAndLabel("setText");
        doAfterTextStateChange(this.vInput.getText());
    }

    public final void setHint(String r2) {
        this.hint = r2;
        this.vInput.setHint(r2);
        adjustInputViewAndLabel("setHint");
    }

    public final void setSingleLine(boolean r14) {
        this.singleLine = r14;
        int r0 = getResources().getDimensionPixelSize(R.dimen.o_input_view_space_top_bottom);
        ViewGroup.LayoutParams r4 = null;
        if (r14 == false) goto L40;
        ViewExtensionsKt.setVisibility(this.vInputResizer, false);
        this.vInput.setMaxLines(1);
        this.vInput.setSingleLine(true);
        OEditText r15 = this.vInput;
        ViewGroup.LayoutParams r7 = r15.getLayoutParams();
        if (r7 == null) goto L39;
        ConstraintLayout.LayoutParams r8 = (ConstraintLayout.LayoutParams) r7;
        ConstraintLayout.LayoutParams r9 = r8;
        OInputView r10 = this;
        ViewGroup.LayoutParams r11 = r10.getLayoutParams();
        if ((r11 instanceof ViewGroup.MarginLayoutParams) == true) goto L9;
        r11 = null;
    L9:
        ViewGroup.MarginLayoutParams r12 = (ViewGroup.MarginLayoutParams) r11;
        if (r12 == null) goto L12;
        int r13 = r12.leftMargin;
    L13:
        ViewGroup.LayoutParams r16 = r10.getLayoutParams();
        if ((r16 instanceof ViewGroup.MarginLayoutParams) == false) goto L17;
        r4 = r16;
    L17:
        ViewGroup.MarginLayoutParams r5 = (ViewGroup.MarginLayoutParams) r4;
        if (r5 == null) goto L20;
        int r6 = r5.rightMargin;
    L21:
        r9.setMargins(r13, 0, r6, r0);
        r9.goneTopMargin = r0;
        if (this.showLabel == false) goto L24;
        int r1 = OUnitExtensionKt.vdp(r10, 16);
    L25:
        r9.goneLeftMargin = r1;
        r9.goneStartMargin = r9.goneLeftMargin;
        r15.setLayoutParams(r8);
        View r17 = this.vActionContainer;
        ViewGroup.LayoutParams r2 = r17.getLayoutParams();
        if (r2 == null) goto L37;
        ConstraintLayout.LayoutParams r3 = (ConstraintLayout.LayoutParams) r2;
        ConstraintLayout.LayoutParams r18 = r3;
        r18.topToTop = 0;
        r18.bottomToBottom = 0;
        r17.setLayoutParams(r3);
        FrameLayout r19 = this.vCustomActionContainer;
        ViewGroup.LayoutParams r20 = r19.getLayoutParams();
        if (r20 == null) goto L35;
        ConstraintLayout.LayoutParams r21 = (ConstraintLayout.LayoutParams) r20;
        ConstraintLayout.LayoutParams r22 = r21;
        r22.topToTop = 0;
        r22.bottomToBottom = 0;
        r19.setLayoutParams(r21);
        FrameLayout r110 = this.vLeftViewContainer;
        ViewGroup.LayoutParams r23 = r110.getLayoutParams();
        if (r23 == null) goto L33;
        ConstraintLayout.LayoutParams r24 = (ConstraintLayout.LayoutParams) r23;
        ConstraintLayout.LayoutParams r25 = r24;
        r25.setMargins(OUnitExtensionKt.vdp(r10, 4), OUnitExtensionKt.vdp(r10, 4), 0, OUnitExtensionKt.vdp(r10, 4));
        r25.topToTop = 0;
        r25.bottomToBottom = 0;
        r110.setLayoutParams(r24);
    L89:
        adjustInputViewAndLabel("setSingleLine");
        return;
    L33:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L35:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L37:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L24:
        r1 = OUnitExtensionKt.vdp(r10, 12);
        goto L25
    L20:
        r6 = 0;
        goto L21
    L12:
        r13 = 0;
        goto L13
    L39:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L40:
        ViewExtensionsKt.setVisibility(this.vInputResizer, this.showResizer);
        this.vInput.setMaxLines(this.maxLines);
        this.vInput.setSingleLine(false);
        OInputView r26 = this;
        this.vInput.setPadding(getPaddingLeft(), OUnitExtensionKt.vdp(r26, 2), getPaddingRight(), getPaddingBottom());
        this.vInput.setGravity(48);
        OEditText r111 = this.vInput;
        ViewGroup.LayoutParams r27 = r111.getLayoutParams();
        if (r27 == null) goto L98;
        ConstraintLayout.LayoutParams r28 = (ConstraintLayout.LayoutParams) r27;
        ConstraintLayout.LayoutParams r29 = r28;
        ViewGroup.LayoutParams r30 = r26.getLayoutParams();
        if ((r30 instanceof ViewGroup.MarginLayoutParams) == true) goto L45;
        r30 = null;
    L45:
        ViewGroup.MarginLayoutParams r31 = (ViewGroup.MarginLayoutParams) r30;
        if (r31 == null) goto L48;
        int r32 = r31.leftMargin;
    L49:
        ViewGroup.LayoutParams r112 = r26.getLayoutParams();
        if ((r112 instanceof ViewGroup.MarginLayoutParams) == true) goto L52;
        r112 = null;
    L52:
        ViewGroup.MarginLayoutParams r113 = (ViewGroup.MarginLayoutParams) r112;
        if (r113 == null) goto L55;
        int r114 = r113.rightMargin;
    L56:
        r29.setMargins(r32, 0, r114, OUnitExtensionKt.vdp(r26, 8));
        r29.goneTopMargin = OUnitExtensionKt.vdp(r26, 8);
        if (this.showLabel == false) goto L59;
        int r33 = OUnitExtensionKt.vdp(r26, 16);
    L60:
        r29.goneLeftMargin = r33;
        r29.goneStartMargin = r29.goneLeftMargin;
        r111.setLayoutParams(r28);
        View r115 = this.vActionContainer;
        ViewGroup.LayoutParams r34 = r115.getLayoutParams();
        if (r34 == null) goto L96;
        ConstraintLayout.LayoutParams r35 = (ConstraintLayout.LayoutParams) r34;
        ConstraintLayout.LayoutParams r36 = r35;
        r36.topToTop = 0;
        ViewGroup.LayoutParams r37 = r26.getLayoutParams();
        if ((r37 instanceof ViewGroup.MarginLayoutParams) == true) goto L65;
        r37 = null;
    L65:
        ViewGroup.MarginLayoutParams r38 = (ViewGroup.MarginLayoutParams) r37;
        if (r38 == null) goto L68;
        int r39 = r38.leftMargin;
    L69:
        int r40 = OUnitExtensionKt.vdp(r26, 4);
        ViewGroup.LayoutParams r41 = r26.getLayoutParams();
        if ((r41 instanceof ViewGroup.MarginLayoutParams) == true) goto L72;
        r41 = null;
    L72:
        ViewGroup.MarginLayoutParams r42 = (ViewGroup.MarginLayoutParams) r41;
        if (r42 == null) goto L75;
        int r43 = r42.rightMargin;
    L76:
        ViewGroup.LayoutParams r116 = r26.getLayoutParams();
        if ((r116 instanceof ViewGroup.MarginLayoutParams) == false) goto L80;
        r4 = r116;
    L80:
        ViewGroup.MarginLayoutParams r44 = (ViewGroup.MarginLayoutParams) r4;
        if (r44 == null) goto L83;
        int r45 = r44.bottomMargin;
    L84:
        r36.setMargins(r39, r40, r43, r45);
        r36.bottomToBottom = -1;
        r115.setLayoutParams(r35);
        FrameLayout r117 = this.vCustomActionContainer;
        ViewGroup.LayoutParams r46 = r117.getLayoutParams();
        if (r46 == null) goto L94;
        ConstraintLayout.LayoutParams r47 = (ConstraintLayout.LayoutParams) r46;
        ConstraintLayout.LayoutParams r48 = r47;
        r48.topToTop = 0;
        r48.bottomToBottom = 0;
        r117.setLayoutParams(r47);
        FrameLayout r118 = this.vLeftViewContainer;
        ViewGroup.LayoutParams r49 = r118.getLayoutParams();
        if (r49 == null) goto L92;
        ConstraintLayout.LayoutParams r50 = (ConstraintLayout.LayoutParams) r49;
        ConstraintLayout.LayoutParams r51 = r50;
        r51.setMargins(OUnitExtensionKt.vdp(r26, 4), OUnitExtensionKt.vdp(r26, 4), 0, 0);
        r51.topToTop = 0;
        r51.bottomToBottom = -1;
        r118.setLayoutParams(r50);
        goto L89
    L92:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L94:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L83:
        r45 = 0;
        goto L84
    L75:
        r43 = 0;
        goto L76
    L68:
        r39 = 0;
        goto L69
    L96:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L59:
        r33 = OUnitExtensionKt.vdp(r26, 12);
        goto L60
    L55:
        r114 = 0;
        goto L56
    L48:
        r32 = 0;
        goto L49
    L98:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    }

    public final void setLeftView(Function1<? super FrameLayout, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "creator");
        this.vLeftViewContainer.removeAllViews();
        r2.invoke(this.vLeftViewContainer);
        FrameLayout r1 = this.vLeftViewContainer;
        FrameLayout r3 = r1;
        if (r1.getChildCount() <= 0) goto L5;
        boolean r4 = true;
    L6:
        ViewExtensionsKt.setVisibility(r3, r4);
        return;
    L5:
        r4 = false;
        goto L6
    }

    public final void setActionView(Function1<? super FrameLayout, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "creator");
        this.vCustomActionContainer.removeAllViews();
        r2.invoke(this.vCustomActionContainer);
        FrameLayout r1 = this.vCustomActionContainer;
        FrameLayout r3 = r1;
        if (r1.getChildCount() <= 0) goto L5;
        boolean r4 = true;
    L6:
        ViewExtensionsKt.setVisibility(r3, r4);
        return;
    L5:
        r4 = false;
        goto L6
    }

    public final void setMaxLines(int r3) {
        int r0 = 1;
        if (r3 >= 1) goto L5;
        r3 = Integer.MAX_VALUE;
    L5:
        this.maxLines = r3;
        OEditText r1 = this.vInput;
        if (this.singleLine == true) goto L9;
        r0 = r3;
    L9:
        r1.setMaxLines(r0);
    }

    public final void setEllipsize(TextUtils.TruncateAt r1) {
        this.ellipsize = r1;
        this.vInput.setEllipsize(r1);
    }

    public final TextUtils.TruncateAt getEllipsize() {
        return this.vInput.getEllipsize();
    }

    private final TextUtils.TruncateAt parseEllipsize(int r1) {
        if (r1 == 1) goto L15;
        if (r1 == 2) goto L19;
        if (r1 == 3) goto L18;
        if (r1 == 4) goto L17;
        return null;
    L17:
        return TextUtils.TruncateAt.MARQUEE;
    L18:
        return TextUtils.TruncateAt.END;
    L19:
        return TextUtils.TruncateAt.MIDDLE;
    L15:
        return TextUtils.TruncateAt.START;
    }

    public final void setLimitCountValue(int r1) {
        this.limitCount = r1;
    }

    public void setLimitCount(int r1) {
        setLimitCountValue(r1);
        Editable r2 = this.vInput.getText();
        if (r2 != null) goto L5;
        String r3 = null;
    L6:
        updateLimitIndicator(r3);
        doAfterTextStateChange(this.vInput.getText());
        return;
    L5:
        r3 = r2.toString();
        goto L6
    }

    public final int getLimitCount() {
        return this.limitCount;
    }

    public final void setShowLimitIndicator(boolean r1) {
        this.showLimitIndicator = r1;
        Editable r2 = this.vInput.getText();
        if (r2 != null) goto L5;
        String r3 = null;
    L6:
        updateLimitIndicator(r3);
        return;
    L5:
        r3 = r2.toString();
        goto L6
    }

    public final void updateLimitIndicator(String r7) {
        OTextView r0 = this.vLimitIndicator;
        if (this.showLimitIndicator == true) goto L5;
    L7:
        boolean r1 = false;
    L8:
        ViewExtensionsKt.setVisibility(r0, r1);
        if (this.showLimitIndicator == true) goto L11;
        return;
    L11:
        if (this.limitCount <= 0) goto L18;
        int r8 = getConstraintLength(r7);
        String r2 = getResources().getString(R.string.oui_form_counter, new Object[]{String.valueOf(r8), String.valueOf(this.limitCount)});
        Intrinsics.checkNotNullExpressionValue(r2, "resources.getString(\n   ….toString()\n            )");
        SpannableString r3 = new SpannableString(r2);
        if (r8 <= this.limitCount) goto L15;
        r3.setSpan(new ForegroundColorSpan(ContextCompat.getColor(getContext(), R.color.oui_functional_red_7)), 0, String.valueOf(r8).length(), 18);
    L15:
        this.vLimitIndicator.setText(r3, TextView.BufferType.SPANNABLE);
        return;
    L18:
        return;
    L5:
        if (this.limitCount <= 0) goto L7;
        r1 = true;
        goto L8
    }

    public final void setInputMode(@InputMode int r4) {
        this.inputMode = r4;
        boolean r0 = false;
        if (r4 == 0) goto L23;
        if (r4 != 1) goto L42;
        setSingleLine(true);
        ViewExtensionsKt.setVisibility(this.vComboArrow, true);
        View r5 = this.vActionContainer;
        if (this.vClear.getVisibility() != 0) goto L9;
        boolean r2 = true;
    L10:
        if (r2 == false) goto L12;
    L21:
        r0 = true;
    L22:
        ViewExtensionsKt.setVisibility(r5, r0);
        setComboInputEnabled(this.comboInputEnabled);
        return;
    L12:
        if (this.vEye.getVisibility() != 0) goto L14;
        boolean r3 = true;
    L15:
        if (r3 == true) goto L21;
        if (this.vComboArrow.getVisibility() != 0) goto L19;
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
        ViewExtensionsKt.setVisibility(this.vComboArrow, false);
        View r7 = this.vActionContainer;
        if (this.vClear.getVisibility() != 0) goto L26;
        boolean r8 = true;
    L27:
        if (r8 == false) goto L29;
    L38:
        r0 = true;
    L39:
        ViewExtensionsKt.setVisibility(r7, r0);
        this.vInput.setFocusable(true);
        this.vInput.setFocusableInTouchMode(true);
        return;
    L29:
        if (this.vEye.getVisibility() != 0) goto L31;
        boolean r9 = true;
    L32:
        if (r9 == true) goto L38;
        if (this.vComboArrow.getVisibility() != 0) goto L36;
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

    public final void setComboInputEnabled(boolean r2) {
        this.comboInputEnabled = r2;
        this.vInput.setFocusable(r2);
        this.vInput.setFocusableInTouchMode(r2);
        View.OnClickListener r3 = this.onComboArrowClickListener;
        if (r3 == null) goto L7;
        getVInput().setOnClickListener(r3);
        return;
    }

    public final void setOnComboArrowClickListener(View.OnClickListener r2) {
        this.onComboArrowClickListener = r2;
        this.vComboArrow.setOnClickListener(r2);
        if (this.comboInputEnabled == true) goto L9;
        View.OnClickListener r3 = this.onComboArrowClickListener;
        if (r3 == null) goto L10;
        getVInput().setOnClickListener(r3);
        return;
    L10:
        return;
    }

    public final void setOnTextExceedLengthListener(OnTextExceedLengthListener r1) {
        this.onTextExceedLengthListener = r1;
    }

    public final void setErrorTip(String r1) {
        this.errorTip = r1;
        this.vErrorTip.setText(r1);
    }

    public final void showErrorTip(boolean r1) {
        ViewExtensionsKt.setVisibility(this.vErrorTip, r1);
    }

    public final void setCommonTip(String r1) {
        this.commonTip = r1;
        this.vCommonTip.setText(r1);
    }

    public final void showCommonTip(boolean r1) {
        ViewExtensionsKt.setVisibility(this.vCommonTip, r1);
    }

    public final void setOnTextClearedListener(OnTextClearedListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.onTextClearedListener = r2;
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
        if (this.shouldDispatchToInput == false) goto L22;
        this.shouldDispatchToInput = false;
        goto L22
    L5:
        if (r6.getAction() != 0) goto L13;
        float r2 = r6.getX();
        int r3 = this.vInput.getLeft();
        int r4 = this.vInput.getRight();
        if (r2 >= r3) goto L9;
    L12:
        this.shouldDispatchToInput = false;
        goto L22
    L9:
        if (r2 > r4) goto L12;
        this.shouldDispatchToInput = true;
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r4) {
        if (r4 == null) goto L12;
        if (this.shouldDispatchToInput == false) goto L12;
        MotionEvent r0 = MotionEvent.obtain(r4);
        r0.offsetLocation(-this.vInput.getLeft(), -this.vInput.getTop());
        boolean r1 = this.vInput.dispatchTouchEvent(r0);
        r0.recycle();
        if (r4.getAction() != 1) goto L8;
    L9:
        this.shouldDispatchToInput = false;
    L10:
        return r1;
    L8:
        if (r4.getAction() != 3) goto L10;
    L12:
        return super.onTouchEvent(r4);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r7) {
        if (r7 == null) goto L36;
        if (this.inScrollableView == false) goto L36;
        float r0 = r7.getX();
        float r1 = r7.getY();
        int r2 = r7.getAction();
        if (r2 != 0) goto L8;
        this.lastScrollY = r1;
        goto L36
    L8:
        if (r2 != 1) goto L10;
        super.requestDisallowInterceptTouchEvent(false);
        goto L36
    L10:
        if (r2 == 2) goto L16;
        if (r2 != 3) goto L36;
        super.requestDisallowInterceptTouchEvent(false);
        goto L36
    L16:
        if (r0 <= this.lastScrollX) goto L20;
        if (this.vInput.canScrollHorizontally(-1) == false) goto L20;
    L31:
        super.requestDisallowInterceptTouchEvent(true);
    L32:
        this.lastScrollX = r0;
        this.lastScrollY = r1;
    L20:
        if (r0 >= this.lastScrollX) goto L24;
        if (this.vInput.canScrollHorizontally(1) == true) goto L31;
    L24:
        if (r1 >= this.lastScrollY) goto L28;
        if (this.vInput.canScrollVertically(1) == true) goto L31;
    L28:
        if (r1 <= this.lastScrollY) goto L32;
        if (this.vInput.canScrollVertically(-1) == false) goto L32;
    L36:
        return super.dispatchTouchEvent(r7);
    }

    @Override // android.view.View
    public View.OnFocusChangeListener getOnFocusChangeListener() {
        return this.vInput.getOnFocusChangeListener();
    }

    @Override // android.view.View
    public void setOnFocusChangeListener(View.OnFocusChangeListener r1) {
        this.vInput.setOnFocusChangeListener(r1);
    }

    public final void addTextChangedListener(TextWatcher r1) {
        this.vInput.addTextChangedListener(r1);
    }

    public final void removeTextChangedListener(TextWatcher r1) {
        this.vInput.removeTextChangedListener(r1);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener r3) {
        if (this.inputMode == 1) goto L5;
    L7:
        super.setOnClickListener(r3);
        return;
    L5:
        if (this.comboInputEnabled == true) goto L7;
        this.vComboArrow.setOnClickListener(r3);
        this.vInput.setOnClickListener(r3);
        goto L7
    }

    private final void updateBorder(boolean r5) {
        int r1 = 0;
        if (this.transparentBorder == false) goto L7;
        this.vBorderContainer.setBorderWidth(0);
        this.vBorderContainer.setBorderColor(ContextCompat.getColor(getContext(), R.color.Transparent));
        return;
    L7:
        if (this.isEnable == true) goto L9;
    L8:
        int r0 = OUnitExtensionKt.vdp(this, 0);
    L14:
        this.vBorderContainer.setBorderWidth(r0);
        if (this.isEnable == true) goto L18;
        r1 = OUnitExtensionKt.vdp(this, 0);
    L22:
        if (r1 == 0) goto L25;
        this.vBorderContainer.setBorderColor(ContextCompat.getColor(getContext(), r1));
        return;
    L25:
        return;
    L18:
        if (this.isError == false) goto L20;
        r1 = R.color.oui_functional_red_7;
        goto L22
    L20:
        if (r5 == false) goto L22;
        r1 = R.color.oui_basic_line_3;
        goto L22
    L9:
        if (r5 == false) goto L12;
        r0 = OUnitExtensionKt.vdp(this, 2);
        goto L14
    L12:
        if (this.isError == false) goto L8;
        r0 = OUnitExtensionKt.vdp(this, 1.2d);
        goto L14
    }

    private final void updateBackground(boolean r2) {
        int r0 = this.bgResId;
        if (r0 == 0) goto L7;
        this.vBorderContainer.setBackgroundResource(r0);
        return;
    L7:
        if (this.transparentBg == false) goto L11;
        this.vBorderContainer.setBackgroundResource(R.color.Transparent);
        return;
    L11:
        if (this.isEnable == true) goto L13;
        int r3 = R.drawable.o_input_view_pressed_background;
    L19:
        this.vBorderContainer.setBackgroundResource(r3);
        return;
    L13:
        if (r2 == false) goto L16;
        r3 = R.drawable.o_input_view_pressed_background;
        goto L19
    L16:
        if (this.vInput.hasFocus() == false) goto L18;
        r3 = R.drawable.o_input_view_focused_background;
        goto L19
    L18:
        r3 = R.drawable.o_input_view_normal_background;
        goto L19
    }

    public final void enableTransparentBg() {
        this.transparentBg = true;
        updateBackground(true);
    }

    public final void enableTransparentBorder() {
        this.transparentBorder = true;
        updateBorder(true);
    }

    public final void setBgResId(int r1) {
        this.bgResId = r1;
        updateBackground(true);
    }

    public final void setAlwaysHideEye(boolean r1) {
        this.alwaysHideEye = r1;
        if (r1 == false) goto L6;
        ViewExtensionsKt.setVisibility(this.vEye, false);
        return;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    protected void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }

    private final void adjustInputViewAndLabel(String r5) {
        if (this.showLabelAnim == true) goto L5;
        return;
    L5:
        TextView r0 = this.vFakeLabel;
        if (r0 != null) goto L9;
        return;
    L9:
        if (this.showLabel == true) goto L12;
        this.vInput.setHint(this.hint);
        updateLabelUIState(LabelUIState.LABEL_NONE, r0, "adjustInputViewAndLabel, " + r5 + ", no label");
        return;
    L12:
        if (this.singleLine == true) goto L14;
        this.vInput.setHint(this.hint);
        updateLabelUIState(LabelUIState.REAL_LABEL_SHOW, r0, "adjustInputViewAndLabel, " + r5 + ", can not show label anim");
        return;
    L14:
        this.vInput.setHint("");
        r0.setText(this.insideLabel);
        Editable r1 = this.vInput.getText();
        if (r1 != null) goto L17;
    L20:
        boolean r2 = true;
    L21:
        if (r2 == true) goto L23;
        updateLabelUIState(LabelUIState.REAL_LABEL_SHOW, r0, "adjustInputViewAndLabel, " + r5 + ", can show label anim, vInput.text not empty");
        return;
    L23:
        if (this.vInput.hasFocus() == false) goto L25;
        updateLabelUIState(LabelUIState.REAL_LABEL_SHOW, r0, "adjustInputViewAndLabel, " + r5 + ", can show label anim, vInput.text empty, focused");
        return;
    L25:
        updateLabelUIState(LabelUIState.FAKE_LABEL_SHOW, r0, "adjustInputViewAndLabel, " + r5 + ", can show label anim, vInput.text empty, not focused");
        return;
    L17:
        if (r1.length() == 0) goto L20;
        r2 = false;
        goto L21
    }

    private final void playLabelAnim(boolean r10) {
        if (this.showLabelAnim == true) goto L6;
        return;
    L6:
        if (this.showLabel == true) goto L9;
        return;
    L9:
        if (this.singleLine == true) goto L12;
        return;
    L12:
        if (this.vFakeLabel != null) goto L14;
        return;
    L14:
        Editable r0 = this.vInput.getText();
        boolean r1 = false;
        if (r0 != null) goto L17;
    L20:
        boolean r2 = true;
    L21:
        if (r2 == true) goto L25;
        LabelUIState r3 = LabelUIState.REAL_LABEL_SHOW;
        TextView r4 = this.vFakeLabel;
        Intrinsics.checkNotNull(r4);
        updateLabelUIState(r3, r4, Intrinsics.stringPlus("playLabelAnim, hasFocus: ", Boolean.valueOf(r10)));
        return;
    L25:
        if (r10 == false) goto L51;
        ValueAnimator r11 = this.labelHideAnimator;
        if (r11 == null) goto L30;
        r11.cancel();
    L30:
        ValueAnimator r12 = this.labelHideAnimator;
        if (r12 == null) goto L34;
        r12.removeAllUpdateListeners();
    L34:
        ValueAnimator r13 = this.labelHideAnimator;
        if (r13 == null) goto L38;
        r13.removeAllListeners();
    L38:
        ValueAnimator r14 = this.labelShowAnimator;
        if (r14 != null) goto L42;
    L44:
        if (r1 == true) goto L50;
        ValueAnimator r15 = genLabelShowAnim$default(this, 0, 0, 0, 7, null);
        this.labelShowAnimator = r15;
        if (r15 == null) goto L49;
        r15.start();
    L49:
        L.d(TAG, "start label show anim");
        return;
    L50:
        L.w(TAG, "label show anim is running, do nothing");
        return;
    L42:
        if (r14.isRunning() != true) goto L44;
        r1 = true;
        goto L44
    L51:
        ValueAnimator r16 = this.labelShowAnimator;
        if (r16 == null) goto L55;
        r16.cancel();
    L55:
        ValueAnimator r17 = this.labelShowAnimator;
        if (r17 == null) goto L59;
        r17.removeAllUpdateListeners();
    L59:
        ValueAnimator r18 = this.labelShowAnimator;
        if (r18 == null) goto L63;
        r18.removeAllListeners();
    L63:
        ValueAnimator r19 = this.labelHideAnimator;
        if (r19 != null) goto L67;
    L69:
        if (r1 == true) goto L75;
        ValueAnimator r110 = genLabelHideAnim$default(this, 0, 0, 0, 7, null);
        this.labelHideAnimator = r110;
        if (r110 == null) goto L74;
        r110.start();
    L74:
        L.d(TAG, "start label hide anim");
        return;
    L75:
        L.w(TAG, "label hide anim is running, do nothing");
        return;
    L67:
        if (r19.isRunning() != true) goto L69;
        r1 = true;
        goto L69
    L17:
        if (r0.length() == 0) goto L20;
        r2 = false;
        goto L21
    }

    static /* synthetic */ ValueAnimator genLabelShowAnim$default(OInputView r0, int r1, int r2, long r3, int r5, Object r6) {
        if (r6 != null) goto L15;
        if ((r5 & 1) == 0) goto L7;
        r1 = ContextCompat.getColor(r0.getContext(), R.color.oui_text_3);
    L7:
        if ((r5 & 2) == 0) goto L10;
        r2 = ContextCompat.getColor(r0.getContext(), R.color.oui_text_4);
    L10:
        if ((r5 & 4) == 0) goto L13;
        r3 = 200;
    L13:
        return r0.genLabelShowAnim(r1, r2, r3);
    L15:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: genLabelShowAnim");
    }

    private final ValueAnimator genLabelShowAnim(final int r10, final int r11, long r12) {
        final TextView r7 = this.vFakeLabel;
        if (r7 != null) goto L6;
        return null;
    L6:
        final float r1 = getFakeInputOffsetY();
        final float r5 = getScaleRatio(r7);
        r7.setPivotX(0.0f);
        r7.setPivotY(-r1);
        ValueAnimator r8 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r8.setDuration(r12);
        r8.setInterpolator(new DecelerateInterpolator());
        r8.addUpdateListener(new OInputView$$ExternalSyntheticLambda0(r1, this, r11, r10, r5, r7));
        r8.addListener(new C02792(this, r7));
        return r8;
    }

    /* JADX INFO: renamed from: genLabelShowAnim$lambda-17, reason: not valid java name */
    private static final void m1204genLabelShowAnim$lambda17(float r1, OInputView r2, int r3, int r4, float r5, TextView r6, ValueAnimator r7) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        Intrinsics.checkNotNullParameter(r6, "$vFakeInput");
        Intrinsics.checkNotNullParameter(r7, "animation");
        Object r8 = r7.getAnimatedValue();
        if (r8 == null) goto L7;
        float r9 = ((Float) r8).floatValue();
        float r0 = 0;
        float r10 = r0 + ((r1 - r0) * r9);
        float r11 = ((r5 - 1.0f) * r9) + 1.0f;
        r6.setTextColor(r2.blendColors(r3, r4, r9));
        r6.setScaleX(r11);
        r6.setScaleY(r11);
        r6.setTranslationY(r10);
        L.v(TAG, "progress: " + r9 + ", transY: " + r10 + ", scale: " + r11);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }

    static /* synthetic */ ValueAnimator genLabelHideAnim$default(OInputView r0, int r1, int r2, long r3, int r5, Object r6) {
        if (r6 != null) goto L15;
        if ((r5 & 1) == 0) goto L7;
        r1 = ContextCompat.getColor(r0.getContext(), R.color.oui_text_3);
    L7:
        if ((r5 & 2) == 0) goto L10;
        r2 = ContextCompat.getColor(r0.getContext(), R.color.oui_text_4);
    L10:
        if ((r5 & 4) == 0) goto L13;
        r3 = 200;
    L13:
        return r0.genLabelHideAnim(r1, r2, r3);
    L15:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: genLabelHideAnim");
    }

    private final ValueAnimator genLabelHideAnim(final int r10, final int r11, long r12) {
        final TextView r7 = this.vFakeLabel;
        if (r7 != null) goto L6;
        return null;
    L6:
        final float r1 = getFakeInputOffsetY();
        final float r5 = getScaleRatio(r7);
        r7.setPivotX(0.0f);
        r7.setPivotY(-r1);
        ValueAnimator r8 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r8.setDuration(r12);
        r8.setInterpolator(new DecelerateInterpolator());
        r8.addUpdateListener(new OInputView$$ExternalSyntheticLambda1(r1, this, r10, r11, r5, r7));
        r8.addListener(new AnonymousClass2(this, r7));
        return r8;
    }

    /* JADX INFO: renamed from: genLabelHideAnim$lambda-18, reason: not valid java name */
    private static final void m1203genLabelHideAnim$lambda18(float r1, OInputView r2, int r3, int r4, float r5, TextView r6, ValueAnimator r7) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        Intrinsics.checkNotNullParameter(r6, "$vFakeInput");
        Intrinsics.checkNotNullParameter(r7, "animation");
        Object r8 = r7.getAnimatedValue();
        if (r8 == null) goto L7;
        float r9 = ((Float) r8).floatValue();
        float r10 = r1 + ((0 - r1) * r9);
        float r11 = r5 + ((1.0f - r5) * r9);
        r6.setTextColor(r2.blendColors(r3, r4, r9));
        r6.setScaleX(r11);
        r6.setScaleY(r11);
        r6.setTranslationY(r10);
        L.v(TAG, "progress: " + r9 + ", transY: " + r10 + ", scale: " + r11);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }

    private final void updateLabelUIState(LabelUIState r3, TextView r4, String r5) {
        L.d(TAG, "updateLabelUIState, state: " + r3 + ", scene: [" + r5 + ']');
        int r6 = WhenMappings.$EnumSwitchMapping$0[r3.ordinal()];
        if (r6 != 1) goto L5;
        showRealLabel(r4);
        return;
    L5:
        if (r6 != 2) goto L7;
        showFakeLabel(r4);
        return;
    L7:
        if (r6 != 3) goto L15;
        showNoLabel(r4);
        return;
    }

    private final void showNoLabel(TextView r3) {
        this.vTitleContainer.setVisibility(8);
        r3.setVisibility(8);
        this.vInput.setAlpha(1.0f);
    }

    private final void showRealLabel(TextView r3) {
        this.vTitleContainer.setVisibility(0);
        r3.setVisibility(8);
        this.vInput.setAlpha(1.0f);
    }

    private final void showFakeLabel(TextView r3) {
        this.vTitleContainer.setVisibility(4);
        r3.setVisibility(0);
        this.vInput.setAlpha(0.0f);
    }

    private final int blendColors(int r2, int r3, float r4) {
        return ColorUtils.blendARGB(r2, r3, RangesKt.coerceIn(r4, 0.0f, 1.0f));
    }

    private final float getFakeInputOffsetY() {
        if (this.vTitleContainer.getHeight() > 0) goto L5;
    L7:
        L.w(TAG, "getFakeInputOffsetY, use default offset, vTitleContainer.height: " + this.vTitleContainer.getHeight() + ", height: " + getHeight());
        float r0 = OUnitExtensionKt.vdpFloat(this, FAKE_LABEL_OFFSET_Y);
    L8:
        L.d(TAG, Intrinsics.stringPlus("getFakeInputOffsetY, offsetY: ", Float.valueOf(r0)));
        return r0;
    L5:
        if (getHeight() <= 0) goto L7;
        r0 = (this.vTitleContainer.getY() + (this.vTitleContainer.getHeight() / 2.0f)) - (getHeight() / 2.0f);
        goto L8
    }

    private final float getScaleRatio(TextView r4) {
        if (this.vTitle.getTextSize() > 0.0f) goto L5;
    L7:
        L.w(TAG, "getScaleRatio, use default scale, vTitle.textSize: " + this.vTitle.getTextSize() + ", vFakeInput.textSize: " + r4.getTextSize());
        float r3 = FAKE_LABEL_TARGET_SCALE;
    L8:
        L.d(TAG, Intrinsics.stringPlus("getScaleRatio, scale: ", Float.valueOf(r3)));
        return r3;
    L5:
        if (r4.getTextSize() <= 0.0f) goto L7;
        r3 = this.vTitle.getTextSize() / r4.getTextSize();
        goto L8
    }
}
