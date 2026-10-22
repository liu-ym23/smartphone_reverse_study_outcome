package com.obric.oui.segmentedtab;

import android.R;
import android.animation.Animator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedanceos.security.Utils;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.obric.oui.common.style.SmoothCornerH;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.haptic.VibratorSmt;
import com.obric.oui.material.MaterialConfigFormatNames;
import com.obric.oui.utils.KtExt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import obric.widget.calendar.MonthWeekEventsView;

/* JADX INFO: compiled from: OTabSegmentedLayout.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u008a\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 ì\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\nì\u0001í\u0001î\u0001ï\u0001ð\u0001B%\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001d\u0010\u009d\u0001\u001a\u00030\u009e\u00012\u0007\u0010\u009f\u0001\u001a\u00020\t2\b\u0010 \u0001\u001a\u00030\u0085\u0001H\u0003J\n\u0010¡\u0001\u001a\u00030\u009e\u0001H\u0002J\n\u0010¢\u0001\u001a\u00030\u009e\u0001H\u0002J\n\u0010£\u0001\u001a\u00030\u009e\u0001H\u0002J\u0012\u0010¤\u0001\u001a\u00020\t2\u0007\u0010¥\u0001\u001a\u00020\u001aH\u0002J\t\u0010¦\u0001\u001a\u0004\u0018\u00010TJ\u0011\u0010§\u0001\u001a\u00030¨\u00012\u0007\u0010\u009f\u0001\u001a\u00020\tJ\u0011\u0010©\u0001\u001a\u00030ª\u00012\u0007\u0010«\u0001\u001a\u00020\tJ\u0011\u0010¬\u0001\u001a\u00030\u009e\u00012\u0007\u0010\u009f\u0001\u001a\u00020\tJ\n\u0010\u00ad\u0001\u001a\u00030\u009e\u0001H\u0002J\n\u0010®\u0001\u001a\u00030\u009e\u0001H\u0002J\u001c\u0010¯\u0001\u001a\u00030\u009e\u00012\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u0014\u0010°\u0001\u001a\u00030\u009e\u00012\b\u0010±\u0001\u001a\u00030²\u0001H\u0016J\u0014\u0010³\u0001\u001a\u00030\u009e\u00012\b\u0010±\u0001\u001a\u00030²\u0001H\u0016J\u0014\u0010´\u0001\u001a\u00030\u009e\u00012\b\u0010±\u0001\u001a\u00030²\u0001H\u0016J\u0014\u0010µ\u0001\u001a\u00030\u009e\u00012\b\u0010±\u0001\u001a\u00030²\u0001H\u0016J\u0013\u0010¶\u0001\u001a\u00030\u009e\u00012\u0007\u0010±\u0001\u001a\u00020\u007fH\u0016J\u0016\u0010·\u0001\u001a\u00030\u009e\u00012\n\u0010¸\u0001\u001a\u0005\u0018\u00010¹\u0001H\u0014J\u0014\u0010º\u0001\u001a\u00030\u009e\u00012\b\u0010»\u0001\u001a\u00030¼\u0001H\u0014J7\u0010½\u0001\u001a\u00030\u009e\u00012\u0007\u0010¾\u0001\u001a\u0002082\u0007\u0010¿\u0001\u001a\u00020\t2\u0007\u0010À\u0001\u001a\u00020\t2\u0007\u0010Á\u0001\u001a\u00020\t2\u0007\u0010Â\u0001\u001a\u00020\tH\u0014J\u001c\u0010Ã\u0001\u001a\u00030\u009e\u00012\u0007\u0010Ä\u0001\u001a\u00020\t2\u0007\u0010Å\u0001\u001a\u00020\tH\u0014J\u0014\u0010Æ\u0001\u001a\u00030\u009e\u00012\b\u0010Ç\u0001\u001a\u00030È\u0001H\u0014J\f\u0010É\u0001\u001a\u0005\u0018\u00010È\u0001H\u0014J\n\u0010Ê\u0001\u001a\u00030\u009e\u0001H\u0002J\u0013\u0010Ë\u0001\u001a\u00030\u009e\u00012\u0007\u0010Ì\u0001\u001a\u000208H\u0016J\u0013\u0010Í\u0001\u001a\u00030\u009e\u00012\u0007\u0010Î\u0001\u001a\u00020\tH\u0002J\u001a\u0010Ï\u0001\u001a\u00030\u009e\u00012\u0007\u0010Ð\u0001\u001a\u00020\t2\u0007\u0010Ñ\u0001\u001a\u00020\tJ%\u0010Ò\u0001\u001a\u00030\u009e\u00012\u0007\u0010\u009f\u0001\u001a\u00020\t2\u0007\u0010Ó\u0001\u001a\u00020\u001a2\u0007\u0010Ô\u0001\u001a\u00020\u001aH\u0002J\u0013\u0010Õ\u0001\u001a\u00030\u009e\u00012\t\u0010Ö\u0001\u001a\u0004\u0018\u00010kJ\u0013\u0010×\u0001\u001a\u00030\u009e\u00012\t\u0010Ö\u0001\u001a\u0004\u0018\u00010fJO\u0010Ø\u0001\u001a\u00030\u009e\u00012\u000f\u0010Ù\u0001\u001a\n\u0012\u0004\u0012\u00020|\u0018\u00010m2\b\u0010Ú\u0001\u001a\u00030Û\u00012\u0007\u0010Ü\u0001\u001a\u00020\t2\u001b\u0010Ý\u0001\u001a\u0016\u0012\u0004\u0012\u00020T\u0018\u00010Sj\n\u0012\u0004\u0012\u00020T\u0018\u0001`U¢\u0006\u0003\u0010Þ\u0001J0\u0010ß\u0001\u001a\u00030\u009e\u00012\u000f\u0010Ù\u0001\u001a\n\u0012\u0004\u0012\u00020|\u0018\u00010m2\u000f\u0010à\u0001\u001a\n\u0012\u0004\u0012\u00020n\u0018\u00010m¢\u0006\u0003\u0010á\u0001J\u0011\u0010â\u0001\u001a\u00030\u009e\u00012\u0007\u0010\u009f\u0001\u001a\u00020\tJ\u001c\u0010ã\u0001\u001a\u00030\u009e\u00012\u0007\u0010\u009f\u0001\u001a\u00020\t2\u0007\u0010ä\u0001\u001a\u00020\tH\u0002J\u0012\u0010å\u0001\u001a\u00020\t2\u0007\u0010æ\u0001\u001a\u00020\u001aH\u0002J\u0013\u0010ç\u0001\u001a\u00030\u009e\u00012\u0007\u0010\u009f\u0001\u001a\u00020\tH\u0002J\n\u0010è\u0001\u001a\u00030\u009e\u0001H\u0002J\u0018\u0010é\u0001\u001a\u00030\u009e\u0001*\u00030ê\u00012\u0007\u0010ë\u0001\u001a\u000208H\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\t8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\t8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R$\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u001a8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u001a8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001eR\u001a\u0010\"\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R$\u0010(\u001a\u00020\t2\u0006\u0010(\u001a\u00020\t8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b)\u0010\u0013\"\u0004\b*\u0010\u0015R$\u0010+\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020\u001a8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b,\u0010\u001c\"\u0004\b-\u0010\u001eR$\u0010.\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020\u001a8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b/\u0010\u001c\"\u0004\b0\u0010\u001eR\u000e\u00101\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u00105\u001a\u00020\u001a2\u0006\u00104\u001a\u00020\u001a@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\u001cR\u001a\u00107\u001a\u000208X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00109\"\u0004\b:\u0010;R\u001a\u0010<\u001a\u000208X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u00109\"\u0004\b=\u0010;R$\u0010?\u001a\u0002082\u0006\u0010>\u001a\u0002088F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b?\u00109\"\u0004\b@\u0010;R$\u0010B\u001a\u0002082\u0006\u0010A\u001a\u0002088F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bB\u00109\"\u0004\bC\u0010;R\u000e\u0010D\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010I\u001a\u00060JR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010P\u001a\u0004\u0018\u00010QX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010R\u001a\u0016\u0012\u0004\u0012\u00020T\u0018\u00010Sj\n\u0012\u0004\u0012\u00020T\u0018\u0001`UX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010V\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010W\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010X\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Y\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Z\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010[\u001a\u00020\\X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010]\u001a\u00020\\X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010^\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001080_X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010`\u001a\u00020aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010b\u001a\u000208X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010c\u001a\u00060JR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010d\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010e\u001a\u0004\u0018\u00010fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010g\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010h\u001a\u00020iX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010j\u001a\u0004\u0018\u00010kX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010l\u001a\n\u0012\u0004\u0012\u00020n\u0018\u00010mX\u0082\u000e¢\u0006\u0004\n\u0002\u0010oR\u000e\u0010p\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010q\u001a\u000208X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010r\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010s\u001a\u00020tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010u\u001a\u000208X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010v\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010w\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010x\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010y\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010z\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010{\u001a\n\u0012\u0004\u0012\u00020|\u0018\u00010mX\u0082\u000e¢\u0006\u0004\n\u0002\u0010}R\u000e\u0010~\u001a\u00020\u007fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000f\u0010\u0080\u0001\u001a\u000208X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u0081\u0001\u001a\u00020\t2\u0006\u00104\u001a\u00020\t@BX\u0086\u000e¢\u0006\t\n\u0000\u001a\u0005\b\u0082\u0001\u0010\u0013R'\u0010\u0083\u0001\u001a\n\u0012\u0005\u0012\u00030\u0085\u00010\u0084\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001\"\u0006\b\u0088\u0001\u0010\u0089\u0001R(\u0010\u008a\u0001\u001a\u00020\u001a2\u0007\u0010\u008a\u0001\u001a\u00020\u001a8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u008b\u0001\u0010\u001c\"\u0005\b\u008c\u0001\u0010\u001eR(\u0010\u008d\u0001\u001a\u00020\u001a2\u0007\u0010\u008d\u0001\u001a\u00020\u001a8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u008e\u0001\u0010\u001c\"\u0005\b\u008f\u0001\u0010\u001eR(\u0010\u0090\u0001\u001a\u00020\t2\u0007\u0010\u0090\u0001\u001a\u00020\t8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u0091\u0001\u0010\u0013\"\u0005\b\u0092\u0001\u0010\u0015R(\u0010\u0093\u0001\u001a\u00020\t2\u0007\u0010\u0093\u0001\u001a\u00020\t8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u0094\u0001\u0010\u0013\"\u0005\b\u0095\u0001\u0010\u0015R(\u0010\u0096\u0001\u001a\u00020\t2\u0007\u0010\u0096\u0001\u001a\u00020\t8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u0097\u0001\u0010\u0013\"\u0005\b\u0098\u0001\u0010\u0015R(\u0010\u009a\u0001\u001a\u00020\u001a2\u0007\u0010\u0099\u0001\u001a\u00020\u001a8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u009b\u0001\u0010\u001c\"\u0005\b\u009c\u0001\u0010\u001e¨\u0006ñ\u0001"}, d2 = {"Lcom/obric/oui/segmentedtab/OTabSegmentedLayout;", "Landroid/widget/FrameLayout;", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "Landroid/animation/Animator$AnimatorListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "barPaint", "Landroid/graphics/Paint;", "barRectF", "Landroid/graphics/RectF;", "barStrokePaint", "barStrokeRectF", "currentTab", "getCurrentTab", "()I", "setCurrentTab", "(I)V", "dividerColor", "getDividerColor", "setDividerColor", "dividerPadding", "", "getDividerPadding", "()F", "setDividerPadding", "(F)V", "dividerWidth", "getDividerWidth", "setDividerWidth", "indicatorAnimDuration", "", "getIndicatorAnimDuration", "()J", "setIndicatorAnimDuration", "(J)V", "indicatorColor", "getIndicatorColor", "setIndicatorColor", "indicatorCornerRadius", "getIndicatorCornerRadius", "setIndicatorCornerRadius", "indicatorHeight", "getIndicatorHeight", "setIndicatorHeight", "indicatorShadowDxPx", "indicatorShadowDyPx", "indicatorShadowRadiusPx", "<set-?>", "indicatorSpacing", "getIndicatorSpacing", "isIndicatorAnimEnable", "", "()Z", "setIndicatorAnimEnable", "(Z)V", "isIndicatorBounceEnable", "setIndicatorBounceEnable", "tabSpaceEqual", "isTabSpaceEqual", "setTabSpaceEqual", "textAllCaps", "isTextAllCaps", "setTextAllCaps", "mBarColor", "mBarStrokeColor", "mBarStrokeWidth", "mContainerViewId", "mContext", "mCurrentP", "Lcom/obric/oui/segmentedtab/OTabSegmentedLayout$IndicatorPoint;", "mCurrentTab", "mDividerColor", "mDividerPadding", "mDividerPaint", "mDividerWidth", "mFragmentManager", "Landroidx/fragment/app/FragmentManager;", "mFragments", "Ljava/util/ArrayList;", "Landroidx/fragment/app/Fragment;", "Lkotlin/collections/ArrayList;", "mHeight", "mIndicatorColor", "mIndicatorCornerRadius", "mIndicatorHeight", "mIndicatorPaint", "mIndicatorPressedRect", "Landroid/graphics/Rect;", "mIndicatorRect", "mInitSetMap", "Landroid/util/SparseArray;", "mInterpolator", "Landroid/view/animation/PathInterpolator;", "mIsFirstDraw", "mLastP", "mLastTab", "mListener", "Lcom/obric/oui/segmentedtab/OTabSegmentedLayout$TabSelectListener;", "mPressedTab", "mRadiusArr", "", "mSelectAnimListener", "Lcom/obric/oui/segmentedtab/OTabSegmentedLayout$TabSelectAnimListener;", "mTabDrawables", "", "Landroid/graphics/drawable/Drawable;", "[Landroid/graphics/drawable/Drawable;", "mTabPadding", "mTabSpaceEqual", "mTabWidth", "mTabsContainer", "Landroid/widget/LinearLayout;", "mTextAllCaps", "mTextBold", "mTextPaint", "mTextSelectColor", "mTextUnselectColor", "mTextsize", "mTitles", "", "[Ljava/lang/String;", "mValueAnimator", "Landroid/animation/ValueAnimator;", "mVibrateOnTabSelected", "tabCount", "getTabCount", "tabList", "", "Landroid/view/View;", "getTabList", "()Ljava/util/List;", "setTabList", "(Ljava/util/List;)V", "tabPadding", "getTabPadding", "setTabPadding", "tabWidth", "getTabWidth", "setTabWidth", "textBold", "getTextBold", "setTextBold", "textSelectColor", "getTextSelectColor", "setTextSelectColor", "textUnselectColor", "getTextUnselectColor", "setTextUnselectColor", "textSize", "textsize", "getTextsize", "setTextsize", "addTab", "", "position", "tabView", "calcIndicatorPressedRect", "calcIndicatorRect", "calcOffset", "dp2px", "dp", "getCurrentFragment", "getMsgView", "Lcom/obric/oui/segmentedtab/UnReadMsgView;", "getTitleView", "Landroid/widget/TextView;", "tab", "hideMsg", "initFragments", "notifyDataSetChanged", "obtainAttributes", "onAnimationCancel", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "onAnimationUpdate", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onLayout", "changed", "left", "top", "right", "bottom", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onRestoreInstanceState", "state", "Landroid/os/Parcelable;", "onSaveInstanceState", "refreshDimensionCache", "setEnabled", "enabled", "setFragments", Utils.INTENT_KEY_INDEX, "setImageSize", MaterialConfigFormatNames.WIDTH, MonthWeekEventsView.VIEW_PARAMS_HEIGHT, "setMsgMargin", "leftPadding", "bottomPadding", "setOnTabSelectAnimListener", "listener", "setOnTabSelectListener", "setTabData", "titles", "fa", "Landroidx/fragment/app/FragmentActivity;", "containerViewId", "fragments", "([Ljava/lang/String;Landroidx/fragment/app/FragmentActivity;ILjava/util/ArrayList;)V", "setTabTitleAndDrawable", "drawables", "([Ljava/lang/String;[Landroid/graphics/drawable/Drawable;)V", "showDot", "showMsg", PerfConsts.PERF_DISK_FILE_NUM, "sp2px", CloudControlInf.SP, "updateTabSelection", "updateTabStyles", "applyBold", "Landroid/text/TextPaint;", "bold", "Companion", "IndicatorPoint", "PointEvaluator", "TabSelectAnimListener", "TabSelectListener", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OTabSegmentedLayout extends FrameLayout implements ValueAnimator.AnimatorUpdateListener, Animator.AnimatorListener {
    public static final Companion Companion = null;
    private static final long TAB_ANIM_DURATION = 350;
    private static final String TAG = "OTabSegmentedLayout";
    private static final int TEXT_BOLD_BOTH = 2;
    private static final int TEXT_BOLD_NONE = 0;
    private static final int TEXT_BOLD_WHEN_SELECT = 1;
    private final Paint barPaint;
    private final RectF barRectF;
    private final Paint barStrokePaint;
    private final RectF barStrokeRectF;
    private long indicatorAnimDuration;
    private float indicatorShadowDxPx;
    private float indicatorShadowDyPx;
    private float indicatorShadowRadiusPx;
    private float indicatorSpacing;
    private boolean isIndicatorAnimEnable;
    private boolean isIndicatorBounceEnable;
    private int mBarColor;
    private int mBarStrokeColor;
    private float mBarStrokeWidth;
    private int mContainerViewId;
    private final Context mContext;
    private final IndicatorPoint mCurrentP;
    private int mCurrentTab;
    private int mDividerColor;
    private float mDividerPadding;
    private final Paint mDividerPaint;
    private float mDividerWidth;
    private FragmentManager mFragmentManager;
    private ArrayList<Fragment> mFragments;
    private int mHeight;
    private int mIndicatorColor;
    private float mIndicatorCornerRadius;
    private float mIndicatorHeight;
    private final Paint mIndicatorPaint;
    private final Rect mIndicatorPressedRect;
    private final Rect mIndicatorRect;
    private final SparseArray<Boolean> mInitSetMap;
    private final PathInterpolator mInterpolator;
    private boolean mIsFirstDraw;
    private final IndicatorPoint mLastP;
    private int mLastTab;
    private TabSelectListener mListener;
    private int mPressedTab;
    private final float[] mRadiusArr;
    private TabSelectAnimListener mSelectAnimListener;
    private Drawable[] mTabDrawables;
    private float mTabPadding;
    private boolean mTabSpaceEqual;
    private float mTabWidth;
    private final LinearLayout mTabsContainer;
    private boolean mTextAllCaps;
    private int mTextBold;
    private final Paint mTextPaint;
    private int mTextSelectColor;
    private int mTextUnselectColor;
    private float mTextsize;
    private String[] mTitles;
    private final ValueAnimator mValueAnimator;
    private boolean mVibrateOnTabSelected;
    private int tabCount;
    private List<View> tabList;

    /* JADX INFO: compiled from: OTabSegmentedLayout.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/obric/oui/segmentedtab/OTabSegmentedLayout$Companion;", "", "()V", "TAB_ANIM_DURATION", "", "TAG", "", "TEXT_BOLD_BOTH", "", "TEXT_BOLD_NONE", "TEXT_BOLD_WHEN_SELECT", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: OTabSegmentedLayout.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\f\u001a\u00020\rH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/obric/oui/segmentedtab/OTabSegmentedLayout$IndicatorPoint;", "", "(Lcom/obric/oui/segmentedtab/OTabSegmentedLayout;)V", "left", "", "getLeft", "()F", "setLeft", "(F)V", "right", "getRight", "setRight", "toString", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class IndicatorPoint {
        private float left;
        private float right;
        final /* synthetic */ OTabSegmentedLayout this$0;

        public IndicatorPoint(OTabSegmentedLayout r2) {
            Intrinsics.checkNotNullParameter(r2, "this$0");
            this.this$0 = r2;
        }

        public final float getLeft() {
            return this.left;
        }

        public final void setLeft(float r1) {
            this.left = r1;
        }

        public final float getRight() {
            return this.right;
        }

        public final void setRight(float r1) {
            this.right = r1;
        }

        public String toString() {
            return "(left = " + this.left + ", right = " + this.right + ')';
        }
    }

    /* JADX INFO: compiled from: OTabSegmentedLayout.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0080\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J,\u0010\u0005\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\n\u0010\b\u001a\u00060\u0002R\u00020\u00032\n\u0010\t\u001a\u00060\u0002R\u00020\u0003H\u0016¨\u0006\n"}, d2 = {"Lcom/obric/oui/segmentedtab/OTabSegmentedLayout$PointEvaluator;", "Landroid/animation/TypeEvaluator;", "Lcom/obric/oui/segmentedtab/OTabSegmentedLayout$IndicatorPoint;", "Lcom/obric/oui/segmentedtab/OTabSegmentedLayout;", "(Lcom/obric/oui/segmentedtab/OTabSegmentedLayout;)V", "evaluate", "fraction", "", "startValue", "endValue", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class PointEvaluator implements TypeEvaluator<IndicatorPoint> {
        final /* synthetic */ OTabSegmentedLayout this$0;

        public PointEvaluator(OTabSegmentedLayout r2) {
            Intrinsics.checkNotNullParameter(r2, "this$0");
            this.this$0 = r2;
        }

        @Override // android.animation.TypeEvaluator
        public /* bridge */ /* synthetic */ IndicatorPoint evaluate(float r1, IndicatorPoint r2, IndicatorPoint r3) {
            return evaluate2(r1, r2, r3);
        }

        /* JADX INFO: renamed from: evaluate, reason: avoid collision after fix types in other method */
        public IndicatorPoint evaluate2(float r4, IndicatorPoint r5, IndicatorPoint r6) {
            Intrinsics.checkNotNullParameter(r5, "startValue");
            Intrinsics.checkNotNullParameter(r6, "endValue");
            float r0 = r5.getLeft() + ((r6.getLeft() - r5.getLeft()) * r4);
            float r1 = r5.getRight() + (r4 * (r6.getRight() - r5.getRight()));
            IndicatorPoint r7 = new IndicatorPoint(this.this$0);
            r7.setLeft(r0);
            r7.setRight(r1);
            return r7;
        }
    }

    /* JADX INFO: compiled from: OTabSegmentedLayout.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/segmentedtab/OTabSegmentedLayout$TabSelectAnimListener;", "", "onSelectAnimCancel", "", "onSelectAnimEnd", "onSelectAnimStart", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface TabSelectAnimListener {
        void onSelectAnimCancel();

        void onSelectAnimEnd();

        void onSelectAnimStart();
    }

    /* JADX INFO: compiled from: OTabSegmentedLayout.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/segmentedtab/OTabSegmentedLayout$TabSelectListener;", "", "onReselect", "", "position", "", "onSelect", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface TabSelectListener {
        void onReselect(int r1);

        void onSelect(int r1);
    }

    public static /* synthetic */ boolean $r8$lambda$ZQy8aCmqu4h0ox8KYJwo1umkHxc(OTabSegmentedLayout r0, View r1, MotionEvent r2) {
        return m505addTab$lambda11(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$fNpfBGKgTv9m59I9pyxPZue_s8I(OTabSegmentedLayout r0, View r1) {
        m506addTab$lambda12(r0, r1);
    }

    static {
        Companion = new Companion(null);
    }

    public OTabSegmentedLayout(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, null, 0, 6, null);
    }

    public OTabSegmentedLayout(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, 4, null);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator r1) {
        Intrinsics.checkNotNullParameter(r1, "animation");
    }

    public /* synthetic */ OTabSegmentedLayout(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public OTabSegmentedLayout(Context r6, AttributeSet r7, int r8) {
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6, r7, r8);
        this.mPressedTab = -1;
        this.mIndicatorRect = new Rect();
        this.mIndicatorPressedRect = new Rect();
        this.mIndicatorPaint = new Paint();
        this.mDividerPaint = new Paint(1);
        this.indicatorAnimDuration = TAB_ANIM_DURATION;
        this.isIndicatorAnimEnable = true;
        this.mVibrateOnTabSelected = true;
        this.mInterpolator = new PathInterpolator(0.34f, 0.69f, 0.1f, 1.0f);
        this.mRadiusArr = new float[8];
        Paint r9 = new Paint(1);
        r9.setStyle(Paint.Style.FILL);
        this.barPaint = r9;
        Paint r10 = new Paint(1);
        r10.setStyle(Paint.Style.STROKE);
        this.barStrokePaint = r10;
        this.barRectF = new RectF();
        this.barStrokeRectF = new RectF();
        this.tabList = new ArrayList();
        this.mIsFirstDraw = true;
        this.mTextPaint = new Paint(1);
        this.mInitSetMap = new SparseArray();
        IndicatorPoint r11 = new IndicatorPoint(this);
        this.mCurrentP = r11;
        IndicatorPoint r1 = new IndicatorPoint(this);
        this.mLastP = r1;
        refreshDimensionCache();
        setWillNotDraw(false);
        setClipChildren(false);
        setClipToPadding(false);
        this.mContext = r6;
        LinearLayout r3 = new LinearLayout(r6);
        this.mTabsContainer = r3;
        addView(r3);
        obtainAttributes(r6, r7);
        Intrinsics.checkNotNull(r7);
        String r4 = r7.getAttributeValue("http://schemas.android.com/apk/res/android", "layout_height");
        if (Intrinsics.areEqual(r4, "-1") == false) goto L6;
    L9:
        ValueAnimator r12 = ValueAnimator.ofObject(new PointEvaluator(this), new Object[]{r1, r11});
        Intrinsics.checkNotNullExpressionValue(r12, "ofObject(PointEvaluator(), mLastP, mCurrentP)");
        this.mValueAnimator = r12;
        r12.addUpdateListener(this);
        r12.addListener(this);
        return;
    L6:
        if (Intrinsics.areEqual(r4, "-2") == true) goto L9;
        TypedArray r13 = r6.obtainStyledAttributes(r7, new int[]{R.attr.layout_height});
        Intrinsics.checkNotNullExpressionValue(r13, "context.obtainStyledAttributes(attrs, systemAttrs)");
        this.mHeight = r13.getDimensionPixelSize(0, -2);
        r13.recycle();
        goto L9
    }

    public final int getTabCount() {
        return this.tabCount;
    }

    public final float getIndicatorSpacing() {
        return this.indicatorSpacing;
    }

    public final long getIndicatorAnimDuration() {
        return this.indicatorAnimDuration;
    }

    public final void setIndicatorAnimDuration(long r1) {
        this.indicatorAnimDuration = r1;
    }

    public final boolean isIndicatorAnimEnable() {
        return this.isIndicatorAnimEnable;
    }

    public final void setIndicatorAnimEnable(boolean r1) {
        this.isIndicatorAnimEnable = r1;
    }

    public final boolean isIndicatorBounceEnable() {
        return this.isIndicatorBounceEnable;
    }

    public final void setIndicatorBounceEnable(boolean r1) {
        this.isIndicatorBounceEnable = r1;
    }

    private final void obtainAttributes(Context r6, AttributeSet r7) {
        TypedArray r8 = r6.obtainStyledAttributes(r7, com.obric.common.oui.R.styleable.OTabLayout);
        Intrinsics.checkNotNullExpressionValue(r8, "context.obtainStyledAttr…, R.styleable.OTabLayout)");
        this.mIndicatorColor = r8.getColor(com.obric.common.oui.R.styleable.OTabLayout_indicator_color, getResources().getColor(com.obric.common.oui.R.color.oui_fill_seg_selected));
        this.mIndicatorHeight = r8.getDimension(com.obric.common.oui.R.styleable.OTabLayout_indicator_height, -1.0f);
        this.mIndicatorCornerRadius = r8.getDimension(com.obric.common.oui.R.styleable.OTabLayout_indicator_corner_radius, -1.0f);
        this.indicatorSpacing = r8.getDimension(com.obric.common.oui.R.styleable.OTabLayout_indicator_spacing, dp2px(4.0f));
        LinearLayout r9 = this.mTabsContainer;
        int r1 = (int) (getIndicatorSpacing() / 2);
        r9.setPadding(r1, 0, r1, 0);
        this.isIndicatorAnimEnable = r8.getBoolean(com.obric.common.oui.R.styleable.OTabLayout_indicator_anim_enable, false);
        this.isIndicatorBounceEnable = r8.getBoolean(com.obric.common.oui.R.styleable.OTabLayout_indicator_bounce_enable, true);
        this.mDividerColor = r8.getColor(com.obric.common.oui.R.styleable.OTabLayout_divider_color, this.mIndicatorColor);
        this.mDividerWidth = r8.getDimension(com.obric.common.oui.R.styleable.OTabLayout_divider_width, dp2px(1.0f));
        this.mDividerPadding = r8.getDimension(com.obric.common.oui.R.styleable.OTabLayout_divider_padding, 0.0f);
        this.mTextsize = r8.getDimension(com.obric.common.oui.R.styleable.OTabLayout_tab_textSize, sp2px(13.0f));
        this.mTextSelectColor = r8.getColor(com.obric.common.oui.R.styleable.OTabLayout_tab_textSelectColor, Color.parseColor("#ffffff"));
        this.mTextUnselectColor = r8.getColor(com.obric.common.oui.R.styleable.OTabLayout_tab_textUnselectColor, this.mIndicatorColor);
        this.mTextBold = r8.getInt(com.obric.common.oui.R.styleable.OTabLayout_tab_textBold, 0);
        this.mTextAllCaps = r8.getBoolean(com.obric.common.oui.R.styleable.OTabLayout_tab_textAllCaps, false);
        this.mTabSpaceEqual = r8.getBoolean(com.obric.common.oui.R.styleable.OTabLayout_tab_space_equal, true);
        this.mTabWidth = r8.getDimension(com.obric.common.oui.R.styleable.OTabLayout_tab_width, dp2px(-1.0f));
        int r10 = com.obric.common.oui.R.styleable.OTabLayout_tab_padding;
        if (this.mTabSpaceEqual == false) goto L5;
    L8:
        int r0 = dp2px(0.0f);
    L9:
        this.mTabPadding = r8.getDimension(r10, r0);
        this.mBarColor = r8.getColor(com.obric.common.oui.R.styleable.OTabLayout_bar_color, 0);
        this.mBarStrokeColor = r8.getColor(com.obric.common.oui.R.styleable.OTabLayout_bar_stroke_color, this.mBarColor);
        this.mBarStrokeWidth = r8.getDimension(com.obric.common.oui.R.styleable.OTabLayout_bar_stroke_width, dp2px(0.0f));
        this.mVibrateOnTabSelected = r8.getBoolean(com.obric.common.oui.R.styleable.OTabLayout_vibrate_on_tab_selected, true);
        r8.recycle();
        return;
    L5:
        if (this.mTabWidth > 0.0f) goto L8;
        r0 = dp2px(10.0f);
        goto L9
    }

    public final void setTabTitleAndDrawable(String[] r4, Drawable[] r5) {
        boolean r0 = false;
        if (r4 != null) goto L5;
    L11:
        boolean r2 = true;
    L12:
        if (r2 == false) goto L23;
        if (r5 != null) goto L15;
    L21:
        boolean r3 = true;
    L22:
        if (r3 == false) goto L23;
    L24:
        if (r0 == false) goto L28;
        this.mTitles = r4;
        this.mTabDrawables = r5;
        notifyDataSetChanged();
        return;
    L28:
        throw new IllegalStateException("Titles and Drawables can not be NULL or EMPTY !".toString());
    L15:
        if (r5.length != 0) goto L17;
        boolean r6 = true;
    L18:
        if (r6 == true) goto L21;
        r3 = false;
        goto L22
    L17:
        r6 = false;
    L23:
        r0 = true;
        goto L24
    L5:
        if (r4.length != 0) goto L7;
        boolean r7 = true;
    L8:
        if (r7 == true) goto L11;
        r2 = false;
        goto L12
    L7:
        r7 = false;
        goto L8
    }

    public final void setTabData(String[] r2, FragmentActivity r3, int r4, ArrayList<Fragment> r5) {
        Intrinsics.checkNotNullParameter(r3, "fa");
        this.mFragmentManager = r3.getSupportFragmentManager();
        this.mContainerViewId = r4;
        this.mFragments = r5;
        initFragments();
        setTabTitleAndDrawable(r2, null);
    }

    private final void initFragments() {
        ArrayList<Fragment> r0 = this.mFragments;
        if (r0 == null) goto L12;
        Iterator<Fragment> r1 = r0.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        Fragment r2 = r1.next();
        FragmentManager r3 = this.mFragmentManager;
        Intrinsics.checkNotNull(r3);
        r3.beginTransaction().add(this.mContainerViewId, r2).hide(r2).commit();
        goto L7
    L9:
        setFragments(0);
        return;
    }

    private final void setFragments(int r7) {
        ArrayList<Fragment> r0 = this.mFragments;
        if (r0 == null) goto L17;
        int r1 = r0.size();
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L12;
        int r3 = r2 + 1;
        FragmentManager r4 = this.mFragmentManager;
        Intrinsics.checkNotNull(r4);
        FragmentTransaction r5 = r4.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(r5, "mFragmentManager!!.beginTransaction()");
        ArrayList<Fragment> r6 = this.mFragments;
        Intrinsics.checkNotNull(r6);
        Fragment r8 = r6.get(r2);
        Intrinsics.checkNotNullExpressionValue(r8, "mFragments!![i]");
        Fragment r9 = r8;
        if (r2 != r7) goto L10;
        r5.show(r9);
    L11:
        r5.commit();
        r2 = r3;
        goto L6
    L10:
        r5.hide(r9);
        goto L11
    L12:
        this.mCurrentTab = r7;
        return;
    }

    public final Fragment getCurrentFragment() {
        ArrayList<Fragment> r0 = this.mFragments;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.get(this.mCurrentTab);
    }

    private final void notifyDataSetChanged() {
        this.mTabsContainer.removeAllViews();
        String[] r0 = this.mTitles;
        if (r0 != null) goto L5;
        Integer r1 = null;
    L6:
        int r2 = 0;
        if (r1 != null) goto L12;
        Drawable[] r3 = this.mTabDrawables;
        if (r3 != null) goto L11;
        int r4 = 0;
    L13:
        this.tabCount = r4;
        this.tabList.clear();
        int r5 = this.tabCount;
    L14:
        if (r2 >= r5) goto L16;
        OSegmentTabView r6 = OSegmentTabView.Companion.newInstance(this.mContext);
        r6.setOriginTextColor(this.mTextSelectColor, this.mTextUnselectColor);
        r6.setOriginIconAlpha(255);
        OSegmentTabView r7 = r6;
        r7.setTag(Integer.valueOf(r2));
        addTab(r2, r7);
        r2 = r2 + 1;
        goto L14
    L16:
        updateTabStyles();
        return;
    L11:
        r4 = r3.length;
        goto L13
    L12:
        r4 = r1.intValue();
        goto L13
    L5:
        r1 = Integer.valueOf(r0.length);
        goto L6
    }

    @Override // android.view.View
    public void setEnabled(boolean r2) {
        super.setEnabled(r2);
        Iterator<View> r1 = this.tabList.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().setEnabled(r2);
        goto L4
    }

    public final List<View> getTabList() {
        return this.tabList;
    }

    public final void setTabList(List<View> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.tabList = r2;
    }

    private final void addTab(int r6, View r7) {
        View r0 = r7.findViewById(com.obric.common.oui.R.id.tv_tab_title);
        if (r0 == null) goto L42;
        TextView r1 = (TextView) r0;
        ImageView r2 = (ImageView) r7.findViewById(com.obric.common.oui.R.id.tv_tab_icon);
        String[] r3 = this.mTitles;
        Unit r4 = null;
        Drawable r5 = null;
        if (r3 != null) goto L8;
        Unit r8 = null;
    L16:
        if (r8 != null) goto L18;
        r1.setVisibility(8);
    L18:
        Drawable[] r9 = this.mTabDrawables;
        if (r9 == null) goto L26;
        if (r9 == null) goto L24;
        r5 = r9[r6];
    L24:
        r2.setImageDrawable(r5);
        r4 = Unit.INSTANCE;
    L26:
        if (r4 != null) goto L32;
        r2.setVisibility(8);
        ViewGroup.LayoutParams r10 = r1.getLayoutParams();
        if (r10 == null) goto L31;
        LinearLayout.LayoutParams r11 = (LinearLayout.LayoutParams) r10;
        r11.setMargins(0, 0, 0, 0);
        r1.setLayoutParams(r11);
        goto L32
    L31:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L32:
        r7.setOnTouchListener(new OTabSegmentedLayout$$ExternalSyntheticLambda0(this));
        r7.setOnClickListener(new OTabSegmentedLayout$$ExternalSyntheticLambda1(this));
        this.tabList.add(r7);
        if (this.mTabSpaceEqual == false) goto L35;
        LinearLayout.LayoutParams r12 = new LinearLayout.LayoutParams(0, -1, 1.0f);
    L37:
        if (this.mTabWidth <= 0.0f) goto L39;
        r12 = new LinearLayout.LayoutParams((int) this.mTabWidth, -1);
    L39:
        this.mTabsContainer.addView(r7, r6, r12);
        return;
    L35:
        r12 = new LinearLayout.LayoutParams(-2, -1);
        goto L37
    L8:
        if (r3 != null) goto L10;
    L9:
    L14:
        r1.setText(r4);
        r8 = Unit.INSTANCE;
        goto L16
    L10:
        String r13 = r3[r6];
        if (r13 == null) goto L9;
        String r14 = r13;
        goto L14
    L42:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    }

    /* JADX INFO: renamed from: addTab$lambda-11, reason: not valid java name */
    private static final boolean m505addTab$lambda11(OTabSegmentedLayout r1, View r2, MotionEvent r3) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        int r4 = r3.getAction();
        if (r4 != 0) goto L5;
        Object r5 = r2.getTag();
        if (r5 == null) goto L16;
        r1.mPressedTab = ((Integer) r5).intValue();
        r1.postInvalidate();
        return false;
    L16:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L5:
        if (r4 != 1) goto L7;
    L9:
        r1.mPressedTab = -1;
        r1.postInvalidate();
        return false;
    L7:
        if (r4 == 3) goto L9;
        return false;
    }

    /* JADX INFO: renamed from: addTab$lambda-12, reason: not valid java name */
    private static final void m506addTab$lambda12(OTabSegmentedLayout r2, View r3) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        if (r2.mVibrateOnTabSelected == false) goto L5;
        VibratorSmt.vibrateEffectWithHapticPlayer(r2.getContext(), 1);
    L5:
        Object r4 = r3.getTag();
        if (r4 == null) goto L21;
        int r5 = ((Integer) r4).intValue();
        if (r2.mCurrentTab == r5) goto L14;
        r2.setCurrentTab(r5);
        TabSelectListener r6 = r2.mListener;
        if (r6 == null) goto L22;
        if (r6 == null) goto L25;
        r6.onSelect(r5);
        return;
    L25:
        return;
    L22:
        return;
    L14:
        TabSelectListener r7 = r2.mListener;
        if (r7 == null) goto L24;
        if (r7 == null) goto L26;
        r7.onReselect(r5);
        return;
    L26:
        return;
    L24:
        return;
    L21:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    public final void setImageSize(int r5, int r6) {
        int r0 = this.tabCount;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L9;
        int r2 = r1 + 1;
        ImageView r3 = (ImageView) this.mTabsContainer.getChildAt(r1).findViewById(com.obric.common.oui.R.id.tv_tab_icon);
        ViewGroup.LayoutParams r4 = r3.getLayoutParams();
        if (r4 == null) goto L8;
        LinearLayout.LayoutParams r7 = (LinearLayout.LayoutParams) r4;
        r7.width = r5;
        r7.height = r6;
        r3.setLayoutParams(r7);
        r1 = r2;
        goto L3
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    }

    private final void updateTabStyles() {
        int r0 = this.tabCount;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L30;
        int r3 = r2 + 1;
        View r4 = this.mTabsContainer.getChildAt(r2);
        float r5 = this.mTabPadding;
        r4.setPadding((int) r5, 0, (int) r5, 0);
        View r6 = r4.findViewById(com.obric.common.oui.R.id.tv_tab_title);
        if (r6 == null) goto L29;
        TextView r7 = (TextView) r6;
        int r8 = this.mCurrentTab;
        if (r2 != r8) goto L9;
        boolean r9 = true;
    L10:
        if (r2 != r8) goto L12;
        int r10 = this.mTextSelectColor;
    L13:
        r7.setTextColor(r10);
        r7.setTextSize(0, this.mTextsize);
        ImageView r11 = (ImageView) r4.findViewById(com.obric.common.oui.R.id.tv_tab_icon);
        if (r2 != this.mCurrentTab) goto L16;
        int r12 = this.mTextSelectColor;
    L17:
        r11.setImageTintList(ColorStateList.valueOf(r12));
        if (this.mTextAllCaps == false) goto L20;
        String r13 = r7.getText().toString();
        Locale r14 = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(r14, "ROOT");
        String r15 = r13.toUpperCase(r14);
        Intrinsics.checkNotNullExpressionValue(r15, "this as java.lang.String).toUpperCase(locale)");
        r7.setText(r15);
    L20:
        int r16 = this.mTextBold;
        if (r16 != 2) goto L23;
        TextPaint r17 = r7.getPaint();
        Intrinsics.checkNotNullExpressionValue(r17, "tvTabTitle.paint");
        applyBold(r17, true);
    L27:
        r2 = r3;
        goto L3
    L23:
        if (r16 != 0) goto L25;
        TextPaint r18 = r7.getPaint();
        Intrinsics.checkNotNullExpressionValue(r18, "tvTabTitle.paint");
        applyBold(r18, false);
        goto L27
    L25:
        if (r16 != 1) goto L27;
        TextPaint r19 = r7.getPaint();
        Intrinsics.checkNotNullExpressionValue(r19, "tvTabTitle.paint");
        applyBold(r19, r9);
        goto L27
    L16:
        r12 = this.mTextUnselectColor;
        goto L17
    L12:
        r10 = this.mTextUnselectColor;
        goto L13
    L9:
        r9 = false;
        goto L10
    L29:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    }

    private final void applyBold(TextPaint r2, boolean r3) {
        if (r3 == false) goto L4;
        int r1 = 700;
    L5:
        r2.setTypeface(Typeface.create(null, r1, false));
        return;
    L4:
        r1 = 400;
        goto L5
    }

    private final void updateTabSelection(int r10) {
        int r0 = this.tabCount;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L29;
        int r3 = r2 + 1;
        View r4 = this.mTabsContainer.getChildAt(r2);
        if (r2 != r10) goto L7;
        boolean r5 = true;
    L8:
        View r6 = r4.findViewById(com.obric.common.oui.R.id.tv_tab_title);
        if (r6 == null) goto L28;
        TextView r7 = (TextView) r6;
        ImageView r8 = (ImageView) r4.findViewById(com.obric.common.oui.R.id.tv_tab_icon);
        if (r5 == false) goto L13;
        int r9 = this.mTextSelectColor;
    L14:
        r8.setImageTintList(ColorStateList.valueOf(r9));
        if (this.mTextBold != 1) goto L17;
        TextPaint r11 = r7.getPaint();
        Intrinsics.checkNotNullExpressionValue(r11, "tabTitle.paint");
        applyBold(r11, r5);
        r7.invalidate();
    L17:
        KtExt r12 = KtExt.INSTANCE;
        if (r4 != null) goto L21;
    L19:
        r4 = null;
    L22:
        OSegmentTabView r13 = (OSegmentTabView) r4;
        if (r13 == null) goto L26;
        r13.updateSelectState(r5);
    L26:
        r2 = r3;
        goto L3
    L21:
        if ((r4 instanceof OSegmentTabView) == false) goto L19;
    L13:
        r9 = this.mTextUnselectColor;
        goto L14
    L28:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    L7:
        r5 = false;
        goto L8
    }

    private final void calcOffset() {
        View r0 = this.mTabsContainer.getChildAt(this.mCurrentTab);
        this.mCurrentP.setLeft(r0.getLeft());
        this.mCurrentP.setRight(r0.getRight());
        View r1 = this.mTabsContainer.getChildAt(this.mLastTab);
        this.mLastP.setLeft(r1.getLeft());
        this.mLastP.setRight(r1.getRight());
        if (this.mLastP.getLeft() != this.mCurrentP.getLeft()) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == true) goto L8;
    L13:
        this.mValueAnimator.setObjectValues(new Object[]{this.mLastP, this.mCurrentP});
        if (this.isIndicatorBounceEnable == false) goto L16;
        this.mValueAnimator.setInterpolator(this.mInterpolator);
    L16:
        this.mValueAnimator.setDuration(TAB_ANIM_DURATION);
        this.mValueAnimator.start();
        return;
    L8:
        if (this.mLastP.getRight() != this.mCurrentP.getRight()) goto L10;
        boolean r3 = true;
    L11:
        if (r3 == false) goto L13;
        invalidate();
        return;
    L10:
        r3 = false;
        goto L11
    L5:
        r2 = false;
        goto L6
    }

    private final void calcIndicatorRect() {
        View r0 = this.mTabsContainer.getChildAt(this.mCurrentTab);
        float r1 = r0.getLeft();
        float r2 = r0.getRight();
        this.mIndicatorRect.left = (int) r1;
        this.mIndicatorRect.right = (int) r2;
        if (this.isIndicatorAnimEnable == true) goto L11;
        int r3 = this.mCurrentTab;
        if (r3 != 0) goto L8;
        float[] r4 = this.mRadiusArr;
        float r11 = this.mIndicatorCornerRadius;
        r4[0] = r11;
        r4[1] = r11;
        r4[2] = 0.0f;
        r4[3] = 0.0f;
        r4[4] = 0.0f;
        r4[5] = 0.0f;
        r4[6] = r11;
        r4[7] = r11;
        return;
    L8:
        if (r3 != (this.tabCount - 1)) goto L10;
        float[] r5 = this.mRadiusArr;
        r5[0] = 0.0f;
        r5[1] = 0.0f;
        float r12 = this.mIndicatorCornerRadius;
        r5[2] = r12;
        r5[3] = r12;
        r5[4] = r12;
        r5[5] = r12;
        r5[6] = 0.0f;
        r5[7] = 0.0f;
        return;
    L10:
        float[] r13 = this.mRadiusArr;
        r13[0] = 0.0f;
        r13[1] = 0.0f;
        r13[2] = 0.0f;
        r13[3] = 0.0f;
        r13[4] = 0.0f;
        r13[5] = 0.0f;
        r13[6] = 0.0f;
        r13[7] = 0.0f;
        return;
    L11:
        float[] r6 = this.mRadiusArr;
        float r14 = this.mIndicatorCornerRadius;
        r6[0] = r14;
        r6[1] = r14;
        r6[2] = r14;
        r6[3] = r14;
        r6[4] = r14;
        r6[5] = r14;
        r6[6] = r14;
        r6[7] = r14;
    }

    private final void calcIndicatorPressedRect() {
        int r0 = this.mPressedTab;
        if (r0 == (-1)) goto L5;
        View r1 = this.mTabsContainer.getChildAt(r0);
    L6:
        if (r1 == null) goto L10;
        Rect r2 = this.mIndicatorPressedRect;
        r2.left = r1.getLeft();
        Rect r3 = this.mIndicatorPressedRect;
        r3.right = r1.getRight();
        return;
    L10:
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        Object r4 = r3.getAnimatedValue();
        if (r4 == null) goto L7;
        IndicatorPoint r5 = (IndicatorPoint) r4;
        Rect r0 = this.mIndicatorRect;
        r0.left = (int) r5.getLeft();
        Rect r1 = this.mIndicatorRect;
        r1.right = (int) r5.getRight();
        invalidate();
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.segmentedtab.OTabSegmentedLayout.IndicatorPoint");
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        TabSelectAnimListener r1 = this.mSelectAnimListener;
        if (r1 == null) goto L7;
        r1.onSelectAnimStart();
        return;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        TabSelectAnimListener r1 = this.mSelectAnimListener;
        if (r1 == null) goto L7;
        r1.onSelectAnimEnd();
        return;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        TabSelectAnimListener r1 = this.mSelectAnimListener;
        if (r1 == null) goto L7;
        r1.onSelectAnimCancel();
        return;
    }

    @Override // android.view.View
    protected void onDraw(Canvas r15) {
        Intrinsics.checkNotNullParameter(r15, "canvas");
        super.onDraw(r15);
        if (isInEditMode() == false) goto L5;
        return;
    L5:
        if (this.tabCount <= 0) goto L35;
        int r0 = getHeight();
        int r1 = getPaddingLeft();
        if (this.mIndicatorHeight >= 0.0f) goto L10;
        this.mIndicatorHeight = r0 - (this.indicatorSpacing * 2);
    L10:
        float r2 = this.mIndicatorCornerRadius;
        if (r2 >= 0.0f) goto L13;
    L14:
        this.mIndicatorCornerRadius = this.mIndicatorHeight;
    L15:
        this.barPaint.setColor(this.mBarColor);
        this.barRectF.set(0.0f, getPaddingTop(), getWidth(), r0 - getPaddingBottom());
        float r4 = 2;
        float r3 = this.mIndicatorCornerRadius + (this.indicatorSpacing / r4);
        SmoothCornerH.drawRoundRect(r15, this.barRectF, r3, this.barPaint);
        if (this.mBarStrokeWidth <= 0.0f) goto L19;
        this.barStrokePaint.setColor(this.mBarStrokeColor);
        this.barStrokePaint.setStrokeWidth(this.mBarStrokeWidth);
        this.barStrokeRectF.set(this.mBarStrokeWidth / r4, getPaddingTop() + (this.mBarStrokeWidth / r4), getWidth() - (this.mBarStrokeWidth / r4), (r0 - getPaddingBottom()) - (this.mBarStrokeWidth / r4));
        SmoothCornerH.drawRoundRect(r15, this.barStrokeRectF, r3, this.barStrokePaint);
    L19:
        if (this.isIndicatorAnimEnable == true) goto L26;
        float r5 = this.mDividerWidth;
        if (r5 <= 0.0f) goto L26;
        this.mDividerPaint.setStrokeWidth(r5);
        this.mDividerPaint.setColor(this.mDividerColor);
        int r6 = this.tabCount - 1;
        int r7 = 0;
    L23:
        if (r7 >= r6) goto L26;
        int r8 = r7 + 1;
        View r9 = this.mTabsContainer.getChildAt(r7);
        r15.drawLine(r9.getRight() + r1, this.mDividerPadding, r9.getRight() + r1, r0 - this.mDividerPadding, this.mDividerPaint);
        r7 = r8;
    L26:
        if (this.isIndicatorAnimEnable == true) goto L28;
        calcIndicatorRect();
    L31:
        calcIndicatorPressedRect();
        float r10 = (this.indicatorSpacing / r4) + this.mBarStrokeWidth;
        Paint r11 = this.mIndicatorPaint;
        r11.setColor(this.mIndicatorColor);
        r11.setShadowLayer(this.indicatorShadowRadiusPx, this.indicatorShadowDxPx, this.indicatorShadowDyPx, ContextCompat.getColor(getContext(), com.obric.common.oui.R.color.TabSegmentedShadowColor));
        SmoothCornerH.drawRoundRect(r15, (r1 + r10) + this.mIndicatorRect.left, this.indicatorSpacing + this.mBarStrokeWidth, (r1 + this.mIndicatorRect.right) - r10, (this.indicatorSpacing + this.mIndicatorHeight) - this.mBarStrokeWidth, this.mIndicatorCornerRadius, this.mIndicatorPaint);
        return;
    L28:
        if (this.mIsFirstDraw == false) goto L31;
        this.mIsFirstDraw = false;
        calcIndicatorRect();
        goto L31
    L13:
        if (r2 <= (this.mIndicatorHeight / 2)) goto L15;
    }

    public final int getCurrentTab() {
        return this.mCurrentTab;
    }

    public final void setCurrentTab(int r3) {
        int r0 = this.mCurrentTab;
        if (r3 != r0) goto L5;
        return;
    L5:
        this.mIsFirstDraw = true;
        this.mLastTab = r0;
        this.mCurrentTab = r3;
        Log.d(TAG, "setCurrentTab, currentTab: " + r3 + ", lastTab: " + this.mLastTab);
        updateTabSelection(r3);
        setFragments(r3);
        if (this.isIndicatorAnimEnable == false) goto L8;
        calcOffset();
        return;
    L8:
        invalidate();
    }

    public final float getTabPadding() {
        return this.mTabPadding;
    }

    public final void setTabPadding(float r1) {
        this.mTabPadding = dp2px(r1);
        updateTabStyles();
    }

    public final boolean isTabSpaceEqual() {
        return this.mTabSpaceEqual;
    }

    public final void setTabSpaceEqual(boolean r1) {
        this.mTabSpaceEqual = r1;
        updateTabStyles();
    }

    public final float getTabWidth() {
        return this.mTabWidth;
    }

    public final void setTabWidth(float r1) {
        this.mTabWidth = dp2px(r1);
        updateTabStyles();
    }

    public final int getIndicatorColor() {
        return this.mIndicatorColor;
    }

    public final void setIndicatorColor(int r1) {
        this.mIndicatorColor = r1;
        invalidate();
    }

    public final float getIndicatorHeight() {
        return this.mIndicatorHeight;
    }

    public final void setIndicatorHeight(float r1) {
        this.mIndicatorHeight = dp2px(r1);
        invalidate();
    }

    public final float getIndicatorCornerRadius() {
        return this.mIndicatorCornerRadius;
    }

    public final void setIndicatorCornerRadius(float r1) {
        this.mIndicatorCornerRadius = dp2px(r1);
        invalidate();
    }

    public final int getDividerColor() {
        return this.mDividerColor;
    }

    public final void setDividerColor(int r1) {
        this.mDividerColor = r1;
        invalidate();
    }

    public final float getDividerWidth() {
        return this.mDividerWidth;
    }

    public final void setDividerWidth(float r1) {
        this.mDividerWidth = dp2px(r1);
        invalidate();
    }

    public final float getDividerPadding() {
        return this.mDividerPadding;
    }

    public final void setDividerPadding(float r1) {
        this.mDividerPadding = dp2px(r1);
        invalidate();
    }

    public final float getTextsize() {
        return this.mTextsize;
    }

    public final void setTextsize(float r1) {
        this.mTextsize = sp2px(r1);
        updateTabStyles();
    }

    public final int getTextSelectColor() {
        return this.mTextSelectColor;
    }

    public final void setTextSelectColor(int r1) {
        this.mTextSelectColor = r1;
        updateTabStyles();
    }

    public final int getTextUnselectColor() {
        return this.mTextUnselectColor;
    }

    public final void setTextUnselectColor(int r1) {
        this.mTextUnselectColor = r1;
        updateTabStyles();
    }

    public final int getTextBold() {
        return this.mTextBold;
    }

    public final void setTextBold(int r1) {
        this.mTextBold = r1;
        updateTabStyles();
    }

    public final boolean isTextAllCaps() {
        return this.mTextAllCaps;
    }

    public final void setTextAllCaps(boolean r1) {
        this.mTextAllCaps = r1;
        updateTabStyles();
    }

    public final TextView getTitleView(int r1) {
        View r0 = this.mTabsContainer.getChildAt(r1).findViewById(com.obric.common.oui.R.id.tv_tab_title);
        if (r0 == null) goto L7;
        return (TextView) r0;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    }

    private final void showMsg(int r4, int r5) {
        int r0 = this.tabCount;
        if (r4 < r0) goto L5;
        r4 = r0 - 1;
    L5:
        View r1 = this.mTabsContainer.getChildAt(r4).findViewById(com.obric.common.oui.R.id.rtv_msg_tip);
        if (r1 == null) goto L15;
        ((UnReadMsgView) r1).show(r5);
        if (this.mInitSetMap.get(r4) == null) goto L12;
        Boolean r6 = this.mInitSetMap.get(r4);
        Intrinsics.checkNotNull(r6);
        if (r6.booleanValue() == false) goto L12;
        return;
    L12:
        setMsgMargin(r4, 2.0f, 2.0f);
        this.mInitSetMap.put(r4, true);
        return;
    L15:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.segmentedtab.UnReadMsgView");
    }

    public final void showDot(int r2) {
        int r0 = this.tabCount;
        if (r2 < r0) goto L5;
        r2 = r0 - 1;
    L5:
        showMsg(r2, 0);
    }

    public final void hideMsg(int r2) {
        int r0 = this.tabCount;
        if (r2 < r0) goto L5;
        r2 = r0 - 1;
    L5:
        View r1 = this.mTabsContainer.getChildAt(r2).findViewById(com.obric.common.oui.R.id.rtv_msg_tip);
        if (r1 == null) goto L10;
        ((UnReadMsgView) r1).setVisibility(8);
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.segmentedtab.UnReadMsgView");
    }

    private final void setMsgMargin(int r4, float r5, float r6) {
        int r0 = this.tabCount;
        if (r4 < r0) goto L5;
        r4 = r0 - 1;
    L5:
        View r7 = this.mTabsContainer.getChildAt(r4);
        View r1 = r7.findViewById(com.obric.common.oui.R.id.rtv_msg_tip);
        if (r1 == null) goto L22;
        UnReadMsgView r2 = (UnReadMsgView) r1;
        View r8 = r7.findViewById(com.obric.common.oui.R.id.tv_tab_title);
        if (r8 == null) goto L20;
        this.mTextPaint.setTextSize(this.mTextsize);
        this.mTextPaint.measureText(((TextView) r8).getText().toString());
        float r9 = this.mTextPaint.descent() - this.mTextPaint.ascent();
        ViewGroup.LayoutParams r3 = r2.getLayoutParams();
        if (r3 == null) goto L18;
        ViewGroup.MarginLayoutParams r10 = (ViewGroup.MarginLayoutParams) r3;
        r10.leftMargin = dp2px(r5);
        int r11 = this.mHeight;
        if (r11 <= 0) goto L14;
        int r12 = (((int) (r11 - r9)) / 2) - dp2px(r6);
    L15:
        r10.topMargin = r12;
        r2.setLayoutParams(r10);
        return;
    L14:
        r12 = dp2px(r6);
        goto L15
    L18:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L20:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    L22:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.segmentedtab.UnReadMsgView");
    }

    public final UnReadMsgView getMsgView(int r2) {
        int r0 = this.tabCount;
        if (r2 < r0) goto L5;
        r2 = r0 - 1;
    L5:
        View r1 = this.mTabsContainer.getChildAt(r2).findViewById(com.obric.common.oui.R.id.rtv_msg_tip);
        if (r1 == null) goto L10;
        return (UnReadMsgView) r1;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.segmentedtab.UnReadMsgView");
    }

    public final void setOnTabSelectListener(TabSelectListener r1) {
        this.mListener = r1;
    }

    public final void setOnTabSelectAnimListener(TabSelectAnimListener r1) {
        this.mSelectAnimListener = r1;
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Bundle r0 = new Bundle();
        r0.putParcelable("instanceState", super.onSaveInstanceState());
        r0.putInt("mCurrentTab", this.mCurrentTab);
        return r0;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
        if ((r2 instanceof Bundle) == false) goto L9;
        Bundle r3 = (Bundle) r2;
        this.mCurrentTab = r3.getInt("mCurrentTab");
        r2 = r3.getParcelable("instanceState");
        if (this.mCurrentTab == 0) goto L9;
        if (this.mTabsContainer.getChildCount() <= 0) goto L9;
        updateTabSelection(this.mCurrentTab);
    L9:
        super.onRestoreInstanceState(r2);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration r1) {
        super.onConfigurationChanged(r1);
        refreshDimensionCache();
    }

    private final void refreshDimensionCache() {
        OTabSegmentedLayout r0 = this;
        this.indicatorShadowRadiusPx = OUnitExtensionKt.vdpFloat(r0, 10);
        this.indicatorShadowDxPx = OUnitExtensionKt.vdpFloat(r0, 0);
        this.indicatorShadowDyPx = OUnitExtensionKt.vdpFloat(r0, 4);
    }

    private final int dp2px(float r1) {
        return (int) ((r1 * this.mContext.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private final int sp2px(float r1) {
        return (int) ((r1 * this.mContext.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }
}
