package com.obric.oui.segmentedtab;

import android.R;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.android.settings.revone.TabletDpiSettingsFragment;
import com.android.settings.search.IndexDatabaseHelper;
import com.bytedance.apm.constant.PerfConsts;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.obric.common.oea.foundation.animation.manager.AnimationManager;
import com.obric.oui.color.OPalette;
import com.obric.oui.common.style.OUILayoutHelper;
import com.obric.oui.common.style.Shadow;
import com.obric.oui.common.style.ShadowAnimator;
import com.obric.oui.common.style.SmoothCornerH;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.haptic.VibratorSmt;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.material.MaterialConfig;
import com.obric.oui.material.MaterialConfigFormatNames;
import com.obric.oui.material.MaterialOwner;
import com.obric.oui.material.MaterialOwnerKt;
import com.obric.oui.material.MaterialToken;
import com.obric.oui.material.OMaterialExtBaseKt;
import com.obric.oui.material.OMaterialHelper;
import com.obric.oui.utils.KtExt;
import com.obric.oui.utils.ViewUtilKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import obric.widget.calendar.MonthWeekEventsView;

/* JADX INFO: compiled from: OBottomNavActionBar.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000ò\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0014\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u001b\u0018\u0000 î\u00012\u00020\u00012\u00020\u0002:\nî\u0001ï\u0001ð\u0001ñ\u0001ò\u0001B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u001c\u0010\u0093\u0001\u001a\u00030\u0094\u00012\u0007\u0010\u0095\u0001\u001a\u00020\b2\u0007\u0010\u0096\u0001\u001a\u00020\u0016H\u0003J\u0013\u0010\u0097\u0001\u001a\u00030\u0094\u00012\u0007\u0010\u0098\u0001\u001a\u00020$H\u0016J\n\u0010\u0099\u0001\u001a\u00030\u0094\u0001H\u0002J\u0013\u0010\u009a\u0001\u001a\u00020$2\b\u0010\u009b\u0001\u001a\u00030\u009c\u0001H\u0016J\u0013\u0010\u009d\u0001\u001a\u00030\u0094\u00012\u0007\u0010\u009e\u0001\u001a\u00020$H\u0002J\u0012\u0010\u009f\u0001\u001a\u00020\b2\u0007\u0010 \u0001\u001a\u00020\u001bH\u0002J\u001d\u0010¡\u0001\u001a\u00030\u0094\u00012\b\u0010¢\u0001\u001a\u00030£\u00012\u0007\u0010¤\u0001\u001a\u00020\u001bH\u0002J\u0014\u0010¥\u0001\u001a\u00030\u0094\u00012\b\u0010¢\u0001\u001a\u00030£\u0001H\u0002J\u0014\u0010¦\u0001\u001a\u00030\u0094\u00012\b\u0010¢\u0001\u001a\u00030£\u0001H\u0002J\u001d\u0010§\u0001\u001a\u00030\u0094\u00012\b\u0010¢\u0001\u001a\u00030£\u00012\u0007\u0010¤\u0001\u001a\u00020\u001bH\u0002J\t\u0010¨\u0001\u001a\u0004\u0018\u00010TJ\u0011\u0010©\u0001\u001a\u00030ª\u00012\u0007\u0010\u0095\u0001\u001a\u00020\bJ\u0011\u0010«\u0001\u001a\u00030¬\u00012\u0007\u0010\u00ad\u0001\u001a\u00020\bJ\u0011\u0010®\u0001\u001a\u00030\u0094\u00012\u0007\u0010\u0095\u0001\u001a\u00020\bJ\n\u0010¯\u0001\u001a\u00030\u0094\u0001H\u0002J\u001c\u0010°\u0001\u001a\u00030\u0094\u00012\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010±\u0001\u001a\u00030²\u0001H\u0002J\u0013\u0010³\u0001\u001a\u00030\u0094\u00012\u0007\u0010´\u0001\u001a\u00020bH\u0016J\t\u0010µ\u0001\u001a\u00020$H\u0002J\n\u0010¶\u0001\u001a\u00030\u0094\u0001H\u0002J\u001a\u0010·\u0001\u001a\u00030\u0094\u00012\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0014\u0010¸\u0001\u001a\u00030\u0094\u00012\b\u0010¢\u0001\u001a\u00030£\u0001H\u0014J7\u0010¹\u0001\u001a\u00030\u0094\u00012\u0007\u0010º\u0001\u001a\u00020$2\u0007\u0010»\u0001\u001a\u00020\b2\u0007\u0010¼\u0001\u001a\u00020\b2\u0007\u0010½\u0001\u001a\u00020\b2\u0007\u0010¾\u0001\u001a\u00020\bH\u0014J\u001c\u0010¿\u0001\u001a\u00030\u0094\u00012\u0007\u0010À\u0001\u001a\u00020\b2\u0007\u0010Á\u0001\u001a\u00020\bH\u0014J\u0014\u0010Â\u0001\u001a\u00030\u0094\u00012\b\u0010Ã\u0001\u001a\u00030Ä\u0001H\u0014J\f\u0010Å\u0001\u001a\u0005\u0018\u00010Ä\u0001H\u0014J\u0015\u0010Æ\u0001\u001a\u00030\u0094\u00012\t\u0010Ç\u0001\u001a\u0004\u0018\u00010\u0016H\u0016J\u0013\u0010È\u0001\u001a\u00030\u0094\u00012\u0007\u0010É\u0001\u001a\u00020$H\u0016J\u0013\u0010Ê\u0001\u001a\u00030\u0094\u00012\u0007\u0010Ë\u0001\u001a\u00020\bH\u0002J\u001a\u0010Ì\u0001\u001a\u00030\u0094\u00012\u0007\u0010Í\u0001\u001a\u00020\b2\u0007\u0010Î\u0001\u001a\u00020\bJ%\u0010Ï\u0001\u001a\u00030\u0094\u00012\u0007\u0010\u0095\u0001\u001a\u00020\b2\u0007\u0010Ð\u0001\u001a\u00020\u001b2\u0007\u0010Ñ\u0001\u001a\u00020\u001bH\u0002J\u0013\u0010Ò\u0001\u001a\u00030\u0094\u00012\t\u0010Ó\u0001\u001a\u0004\u0018\u00010_J\u0013\u0010Ô\u0001\u001a\u00030\u0094\u00012\t\u0010Ó\u0001\u001a\u0004\u0018\u00010\\JO\u0010Õ\u0001\u001a\u00030\u0094\u00012\u000f\u0010Ö\u0001\u001a\n\u0012\u0004\u0012\u00020o\u0018\u00010a2\b\u0010×\u0001\u001a\u00030Ø\u00012\u0007\u0010Ù\u0001\u001a\u00020\b2\u001b\u0010Ú\u0001\u001a\u0016\u0012\u0004\u0012\u00020T\u0018\u00010Sj\n\u0012\u0004\u0012\u00020T\u0018\u0001`U¢\u0006\u0003\u0010Û\u0001J\u001a\u0010Ü\u0001\u001a\u00030\u0094\u00012\u0007\u0010Ë\u0001\u001a\u00020\b2\u0007\u0010´\u0001\u001a\u00020bJ\u001a\u0010Ý\u0001\u001a\u00030\u0094\u00012\u0007\u0010Ë\u0001\u001a\u00020\b2\u0007\u0010Þ\u0001\u001a\u00020oJ0\u0010ß\u0001\u001a\u00030\u0094\u00012\u000f\u0010Ö\u0001\u001a\n\u0012\u0004\u0012\u00020o\u0018\u00010a2\u000f\u0010à\u0001\u001a\n\u0012\u0004\u0012\u00020b\u0018\u00010a¢\u0006\u0003\u0010á\u0001J\u0011\u0010â\u0001\u001a\u00030\u0094\u00012\u0007\u0010\u0095\u0001\u001a\u00020\bJ\u001c\u0010ã\u0001\u001a\u00030\u0094\u00012\u0007\u0010\u0095\u0001\u001a\u00020\b2\u0007\u0010ä\u0001\u001a\u00020\bH\u0002J\u0012\u0010å\u0001\u001a\u00020\b2\u0007\u0010æ\u0001\u001a\u00020\u001bH\u0002J\n\u0010ç\u0001\u001a\u00030\u0094\u0001H\u0002J\u0013\u0010è\u0001\u001a\u00030\u0094\u00012\u0007\u0010é\u0001\u001a\u00020\bH\u0016J\u0012\u0010ê\u0001\u001a\u00030\u0094\u00012\u0006\u00105\u001a\u00020$H\u0016J\u0013\u0010ë\u0001\u001a\u00030\u0094\u00012\u0007\u0010Ë\u0001\u001a\u00020\bH\u0002J\u0013\u0010ì\u0001\u001a\u00030\u0094\u00012\u0007\u0010\u0095\u0001\u001a\u00020\bH\u0002J\n\u0010í\u0001\u001a\u00030\u0094\u0001H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0012\"\u0004\b\u0019\u0010\u0014R$\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u001b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010 \u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u001b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001fR\u000e\u0010#\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010%\u001a\u00020\b2\u0006\u0010%\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b&\u0010\u0012\"\u0004\b'\u0010\u0014R&\u0010)\u001a\u00020\u001b2\u0006\u0010(\u001a\u00020\u001b8F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u001d\"\u0004\b+\u0010\u001fR\u000e\u0010,\u001a\u00020-X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010.\u001a\u00020\u001b2\u0006\u0010(\u001a\u00020\u001b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b/\u0010\u001d\"\u0004\b0\u0010\u001fR\u001e\u00102\u001a\u00020\b2\u0006\u00101\u001a\u00020\b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u0012R\u000e\u00104\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00106\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R$\u0010:\u001a\u00020$8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b;\u0010<\u001a\u0004\b:\u00107\"\u0004\b=\u00109R$\u0010?\u001a\u00020$2\u0006\u0010>\u001a\u00020$8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b?\u00107\"\u0004\b@\u00109R$\u0010B\u001a\u00020$2\u0006\u0010A\u001a\u00020$8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bB\u00107\"\u0004\bC\u00109R\u000e\u0010D\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010P\u001a\u0004\u0018\u00010QX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010R\u001a\u0016\u0012\u0004\u0012\u00020T\u0018\u00010Sj\n\u0012\u0004\u0012\u00020T\u0018\u0001`UX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010V\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010W\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010$0XX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010Y\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Z\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010[\u001a\u0004\u0018\u00010\\X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010]\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010^\u001a\u0004\u0018\u00010_X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010`\u001a\n\u0012\u0004\u0012\u00020b\u0018\u00010aX\u0082\u000e¢\u0006\u0004\n\u0002\u0010cR\u000e\u0010d\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010e\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010f\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010g\u001a\u00020hX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010i\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010j\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010k\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010l\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010m\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010n\u001a\n\u0012\u0004\u0012\u00020o\u0018\u00010aX\u0082\u000e¢\u0006\u0004\n\u0002\u0010pR\u000e\u0010q\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010r\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010s\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010t\u001a\u0004\u0018\u00010uX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010v\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010w\u001a\u0004\u0018\u00010uX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010x\u001a\n\u0012\u0004\u0012\u00020z\u0018\u00010yX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010{\u001a\n\u0012\u0004\u0012\u00020z\u0018\u00010yX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010|\u001a\u00020\b2\u0006\u00101\u001a\u00020\b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b}\u0010\u0012R$\u0010~\u001a\b\u0012\u0004\u0012\u00020\u00160\u007fX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001\"\u0006\b\u0082\u0001\u0010\u0083\u0001R(\u0010\u0084\u0001\u001a\u00020\u001b2\u0007\u0010\u0084\u0001\u001a\u00020\u001b8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u0085\u0001\u0010\u001d\"\u0005\b\u0086\u0001\u0010\u001fR(\u0010\u0087\u0001\u001a\u00020\u001b2\u0007\u0010\u0087\u0001\u001a\u00020\u001b8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u0088\u0001\u0010\u001d\"\u0005\b\u0089\u0001\u0010\u001fR(\u0010\u008a\u0001\u001a\u00020\b2\u0007\u0010\u008a\u0001\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u008b\u0001\u0010\u0012\"\u0005\b\u008c\u0001\u0010\u0014R(\u0010\u008d\u0001\u001a\u00020\u001b2\u0007\u0010\u008d\u0001\u001a\u00020\u001b8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u008e\u0001\u0010\u001d\"\u0005\b\u008f\u0001\u0010\u001fR(\u0010\u0090\u0001\u001a\u00020\b2\u0007\u0010\u0090\u0001\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u0091\u0001\u0010\u0012\"\u0005\b\u0092\u0001\u0010\u0014¨\u0006ó\u0001"}, d2 = {"Lcom/obric/oui/segmentedtab/OBottomNavActionBar;", "Lcom/obric/oui/layout/OUIFrameLayout;", "Lcom/obric/oui/material/MaterialOwner;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "barPaint", "Landroid/graphics/Paint;", "barRectF", "Landroid/graphics/RectF;", "barStrokePaint", "barStrokeRectF", "currentTab", "getCurrentTab", "()I", "setCurrentTab", "(I)V", "currentTabView", "Landroid/view/View;", "dividerColor", "getDividerColor", "setDividerColor", "dividerPadding", "", "getDividerPadding", "()F", "setDividerPadding", "(F)V", "dividerWidth", "getDividerWidth", "setDividerWidth", "enableMaterial", "", "indicatorColor", "getIndicatorColor", "setIndicatorColor", "value", "indicatorCornerRadius", "getIndicatorCornerRadius", "setIndicatorCornerRadius", "indicatorDrawable", "Lcom/obric/oui/segmentedtab/ONaviIndicatorDrawable;", "indicatorHeight", "getIndicatorHeight", "setIndicatorHeight", "<set-?>", "indicatorSpacing", "getIndicatorSpacing", "initScale", "isBackdropView", "isIndicatorAnimEnable", "()Z", "setIndicatorAnimEnable", "(Z)V", "isIndicatorBounceEnable", "isIndicatorBounceEnable$annotations", "()V", "setIndicatorBounceEnable", "tabSpaceEqual", "isTabSpaceEqual", "setTabSpaceEqual", "textAllCaps", "isTextAllCaps", "setTextAllCaps", "lastLayoutWidth", "mBarColor", "mBarStrokeColor", "mBarStrokeWidth", "mContainerViewId", "mContentRoot", "mContext", "mCurrentTabIndex", "mDividerColor", "mDividerPadding", "mDividerPaint", "mDividerWidth", "mFragmentManager", "Landroidx/fragment/app/FragmentManager;", "mFragments", "Ljava/util/ArrayList;", "Landroidx/fragment/app/Fragment;", "Lkotlin/collections/ArrayList;", "mHeight", "mInitSetMap", "Landroid/util/SparseArray;", "mIsFirstDraw", "mLastTabIndex", "mListener", "Lcom/obric/oui/segmentedtab/OBottomNavActionBar$TabSelectListener;", "mPressedTab", "mSelectAnimListener", "Lcom/obric/oui/segmentedtab/OBottomNavActionBar$TabSelectAnimListener;", "mTabDrawables", "", "Landroid/graphics/drawable/Drawable;", "[Landroid/graphics/drawable/Drawable;", "mTabPadding", "mTabSpaceEqual", "mTabWidth", "mTabsContainer", "Landroid/widget/LinearLayout;", "mTextAllCaps", "mTextPaint", "mTextSelectColor", "mTextSize", "mTextUnselectColor", "mTitles", "", "[Ljava/lang/String;", "mVibrateOnTabSelected", "materialApplied", "materialSrcType", "pressAnim", "Lcom/obric/common/oea/foundation/animation/manager/AnimationManager;", "pressScale", "releaseAnim", "shadowsNormal", "", "Lcom/obric/oui/common/style/Shadow;", "shadowsPressed", "tabCount", "getTabCount", "tabList", "", "getTabList", "()Ljava/util/List;", "setTabList", "(Ljava/util/List;)V", "tabPadding", "getTabPadding", "setTabPadding", "tabWidth", "getTabWidth", "setTabWidth", "textSelectColor", "getTextSelectColor", "setTextSelectColor", "textSize", "getTextSize", "setTextSize", "textUnselectColor", "getTextUnselectColor", "setTextUnselectColor", "addTab", "", "position", "tabView", "applyContentMaterial", "apply", "calcIndicatorRect", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "doPressAnim", "pressed", "dp2px", TabletDpiSettingsFragment.UNIT, "drawBar", "canvas", "Landroid/graphics/Canvas;", "cornerRadius", "drawDivider", "drawIndicator", "drawStroke", "getCurrentFragment", "getMsgView", "Lcom/obric/oui/segmentedtab/UnReadMsgView;", "getTitleView", "Landroid/widget/TextView;", "tab", "hideMsg", "initFragments", "initShadows", "typedArray", "Landroid/content/res/TypedArray;", "invalidateDrawable", "drawable", "isDarkTheme", "notifyDataSetChanged", "obtainAttributes", "onDraw", "onLayout", "changed", "left", "top", "right", "bottom", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onRestoreInstanceState", "state", "Landroid/os/Parcelable;", "onSaveInstanceState", "setBackdropTarget", "view", "setEnabled", IndexDatabaseHelper.IndexColumns.ENABLED, "setFragments", "index", "setImageSize", MaterialConfigFormatNames.WIDTH, MonthWeekEventsView.VIEW_PARAMS_HEIGHT, "setMsgMargin", "leftPadding", "bottomPadding", "setOnTabSelectAnimListener", "listener", "setOnTabSelectListener", "setTabData", "titles", "fa", "Landroidx/fragment/app/FragmentActivity;", "containerViewId", "fragments", "([Ljava/lang/String;Landroidx/fragment/app/FragmentActivity;ILjava/util/ArrayList;)V", "setTabDrawable", "setTabTitle", "title", "setTabTitleAndDrawable", "drawables", "([Ljava/lang/String;[Landroid/graphics/drawable/Drawable;)V", "showDot", "showMsg", PerfConsts.PERF_DISK_FILE_NUM, "sp2px", CloudControlInf.SP, "trackNewTabPosition", "updateBackdropSrcType", "srcType", "updateBackdropTargetType", "updateTabContent", "updateTabSelection", "updateTabStyles", "Companion", "IndicatorPoint", "PointEvaluator", "TabSelectAnimListener", "TabSelectListener", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OBottomNavActionBar extends OUIFrameLayout implements MaterialOwner {
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
    private View currentTabView;
    private boolean enableMaterial;
    private float indicatorCornerRadius;
    private final ONaviIndicatorDrawable indicatorDrawable;
    private int indicatorSpacing;
    private float initScale;
    private boolean isBackdropView;
    private boolean isIndicatorAnimEnable;
    private boolean isIndicatorBounceEnable;
    private int lastLayoutWidth;
    private int mBarColor;
    private int mBarStrokeColor;
    private float mBarStrokeWidth;
    private int mContainerViewId;
    private OUIFrameLayout mContentRoot;
    private final Context mContext;
    private int mCurrentTabIndex;
    private int mDividerColor;
    private float mDividerPadding;
    private final Paint mDividerPaint;
    private float mDividerWidth;
    private FragmentManager mFragmentManager;
    private ArrayList<Fragment> mFragments;
    private int mHeight;
    private final SparseArray<Boolean> mInitSetMap;
    private boolean mIsFirstDraw;
    private int mLastTabIndex;
    private TabSelectListener mListener;
    private int mPressedTab;
    private TabSelectAnimListener mSelectAnimListener;
    private Drawable[] mTabDrawables;
    private float mTabPadding;
    private boolean mTabSpaceEqual;
    private float mTabWidth;
    private final LinearLayout mTabsContainer;
    private boolean mTextAllCaps;
    private final Paint mTextPaint;
    private int mTextSelectColor;
    private float mTextSize;
    private int mTextUnselectColor;
    private String[] mTitles;
    private boolean mVibrateOnTabSelected;
    private boolean materialApplied;
    private int materialSrcType;
    private AnimationManager pressAnim;
    private float pressScale;
    private AnimationManager releaseAnim;
    private List<Shadow> shadowsNormal;
    private List<Shadow> shadowsPressed;
    private int tabCount;
    private List<View> tabList;

    /* JADX INFO: compiled from: OBottomNavActionBar.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/obric/oui/segmentedtab/OBottomNavActionBar$Companion;", "", "()V", "TAB_ANIM_DURATION", "", "TAG", "", "TEXT_BOLD_BOTH", "", "TEXT_BOLD_NONE", "TEXT_BOLD_WHEN_SELECT", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: OBottomNavActionBar.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\f\u001a\u00020\rH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/obric/oui/segmentedtab/OBottomNavActionBar$IndicatorPoint;", "", "(Lcom/obric/oui/segmentedtab/OBottomNavActionBar;)V", "left", "", "getLeft", "()F", "setLeft", "(F)V", "right", "getRight", "setRight", "toString", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class IndicatorPoint {
        private float left;
        private float right;
        final /* synthetic */ OBottomNavActionBar this$0;

        public IndicatorPoint(OBottomNavActionBar r2) {
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

    /* JADX INFO: compiled from: OBottomNavActionBar.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0080\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J,\u0010\u0005\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\n\u0010\b\u001a\u00060\u0002R\u00020\u00032\n\u0010\t\u001a\u00060\u0002R\u00020\u0003H\u0016¨\u0006\n"}, d2 = {"Lcom/obric/oui/segmentedtab/OBottomNavActionBar$PointEvaluator;", "Landroid/animation/TypeEvaluator;", "Lcom/obric/oui/segmentedtab/OBottomNavActionBar$IndicatorPoint;", "Lcom/obric/oui/segmentedtab/OBottomNavActionBar;", "(Lcom/obric/oui/segmentedtab/OBottomNavActionBar;)V", "evaluate", "fraction", "", "startValue", "endValue", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class PointEvaluator implements TypeEvaluator<IndicatorPoint> {
        final /* synthetic */ OBottomNavActionBar this$0;

        public PointEvaluator(OBottomNavActionBar r2) {
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

    /* JADX INFO: compiled from: OBottomNavActionBar.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/segmentedtab/OBottomNavActionBar$TabSelectAnimListener;", "", "onSelectAnimCancel", "", "onSelectAnimEnd", "onSelectAnimStart", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface TabSelectAnimListener {
        void onSelectAnimCancel();

        void onSelectAnimEnd();

        void onSelectAnimStart();
    }

    /* JADX INFO: compiled from: OBottomNavActionBar.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/segmentedtab/OBottomNavActionBar$TabSelectListener;", "", "onReselect", "", "position", "", "onSelect", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface TabSelectListener {
        void onReselect(int r1);

        void onSelect(int r1);
    }

    public static /* synthetic */ boolean $r8$lambda$7258ncJ1iWxieQXegYqFwneHHUc(OBottomNavActionBar r0, View r1, MotionEvent r2) {
        return m1358addTab$lambda16(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$Y4uTlwuKRCxhtGmggx87tRUucZI(OBottomNavActionBar r0, View r1) {
        m1359addTab$lambda17(r0, r1);
    }

    static {
        Companion = new Companion(null);
    }

    public OBottomNavActionBar(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, null, 0, 6, null);
    }

    public OBottomNavActionBar(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, 4, null);
    }

    @Deprecated(message = "")
    public static /* synthetic */ void isIndicatorBounceEnable$annotations() {
    }

    public /* synthetic */ OBottomNavActionBar(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public static final /* synthetic */ TabSelectAnimListener access$getMSelectAnimListener$p(OBottomNavActionBar r0) {
        return r0.mSelectAnimListener;
    }

    public OBottomNavActionBar(Context r11, AttributeSet r12, int r13) {
        Intrinsics.checkNotNullParameter(r11, "context");
        super(r11, r12, r13, null, 8, null);
        this.tabList = new ArrayList();
        this.mPressedTab = -1;
        this.mDividerPaint = new Paint(1);
        this.indicatorDrawable = new ONaviIndicatorDrawable();
        this.isIndicatorAnimEnable = true;
        Paint r0 = new Paint(1);
        r0.setStyle(Paint.Style.FILL);
        this.barPaint = r0;
        Paint r1 = new Paint(1);
        r1.setStyle(Paint.Style.STROKE);
        this.barStrokePaint = r1;
        this.barRectF = new RectF();
        this.barStrokeRectF = new RectF();
        this.pressScale = 0.988f;
        this.initScale = 1.0f;
        this.isBackdropView = true;
        this.materialSrcType = -1;
        this.lastLayoutWidth = -1;
        OBottomNavActionBar r14 = this;
        if (OMaterialExtBaseKt.isMaterialEffectEnabled(r14) == true) goto L5;
    L7:
        boolean r2 = false;
    L8:
        this.enableMaterial = r2;
        this.materialApplied = r2;
        this.mIsFirstDraw = true;
        this.mTextPaint = new Paint(1);
        this.mInitSetMap = new SparseArray();
        setWillNotDraw(false);
        setClipChildren(false);
        setClipToPadding(false);
        this.mContext = r11;
        this.mTabsContainer = new LinearLayout(r11);
        OUIFrameLayout r3 = new OUIFrameLayout(r11, null, 0, null, 14, null);
        this.mContentRoot = r3;
        r3.setRadius(OUnitExtensionKt.vdp(r14, 99));
        this.mContentRoot.setChangeAlphaWhenPress(false);
        this.mContentRoot.setChangeAlphaWhenDisable(false);
        this.mContentRoot.setChangeAlphaWhenSelected(false);
        addView(this.mContentRoot);
        Intrinsics.checkNotNull(r12);
        String r15 = r12.getAttributeValue("http://schemas.android.com/apk/res/android", "layout_height");
        if (Intrinsics.areEqual(r15, "-1") == false) goto L12;
        return;
    L12:
        if (Intrinsics.areEqual(r15, "-2") == true) goto L17;
        TypedArray r16 = r11.obtainStyledAttributes(r12, new int[]{R.attr.layout_height});
        Intrinsics.checkNotNullExpressionValue(r16, "context.obtainStyledAttributes(attrs, systemAttrs)");
        this.mHeight = r16.getDimensionPixelSize(0, -2);
        r16.recycle();
        return;
    L17:
        return;
    L5:
        if (OMaterialHelper.isWidgetMaterialEffectEnabled() == false) goto L7;
        r2 = true;
        goto L8
    }

    public final List<View> getTabList() {
        return this.tabList;
    }

    public final void setTabList(List<View> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.tabList = r2;
    }

    public final int getTabCount() {
        return this.tabCount;
    }

    public final int getIndicatorSpacing() {
        return this.indicatorSpacing;
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

    public final void obtainAttributes(Context r12, AttributeSet r13) {
        Intrinsics.checkNotNullParameter(r12, "context");
        this.indicatorDrawable.setCallback(this);
        TypedArray r14 = r12.obtainStyledAttributes(r13, com.obric.common.oui.R.styleable.OTabLayout);
        Intrinsics.checkNotNullExpressionValue(r14, "context.obtainStyledAttr…, R.styleable.OTabLayout)");
        this.indicatorDrawable.setIndicatorColor(r14.getColor(com.obric.common.oui.R.styleable.OTabLayout_indicator_color, getResources().getColor(com.obric.common.oui.R.color.oui_fill_element_3)));
        this.indicatorDrawable.setIndicatorHeight(r14.getDimension(com.obric.common.oui.R.styleable.OTabLayout_indicator_height, -1.0f));
        this.indicatorDrawable.setIndicatorCornerRadius(r14.getDimension(com.obric.common.oui.R.styleable.OTabLayout_indicator_corner_radius, -1.0f));
        setIndicatorCornerRadius(this.indicatorDrawable.getIndicatorCornerRadius());
        this.indicatorSpacing = r14.getDimensionPixelSize(com.obric.common.oui.R.styleable.OTabLayout_indicator_spacing, dp2px(4.0f));
        this.indicatorDrawable.setEnableAnimation(r14.getBoolean(com.obric.common.oui.R.styleable.OTabLayout_indicator_anim_enable, false));
        this.isIndicatorBounceEnable = r14.getBoolean(com.obric.common.oui.R.styleable.OTabLayout_indicator_bounce_enable, true);
        this.mTabsContainer.setPadding(getIndicatorSpacing(), 0, getIndicatorSpacing(), 0);
        this.mContentRoot.addView(this.mTabsContainer);
        this.mDividerColor = r14.getColor(com.obric.common.oui.R.styleable.OTabLayout_divider_color, this.indicatorDrawable.getIndicatorColor());
        this.mDividerWidth = r14.getDimension(com.obric.common.oui.R.styleable.OTabLayout_divider_width, 0.0f);
        this.mDividerPadding = r14.getDimension(com.obric.common.oui.R.styleable.OTabLayout_divider_padding, 0.0f);
        this.mTextSize = r14.getDimension(com.obric.common.oui.R.styleable.OTabLayout_tab_textSize, dp2px(10.0f));
        this.mTextSelectColor = r14.getColor(com.obric.common.oui.R.styleable.OTabLayout_tab_textSelectColor, this.mContext.getColor(com.obric.common.oui.R.color.oui_text_1));
        this.mTextUnselectColor = r14.getColor(com.obric.common.oui.R.styleable.OTabLayout_tab_textUnselectColor, this.mContext.getColor(com.obric.common.oui.R.color.oui_text_3b));
        this.mTextAllCaps = r14.getBoolean(com.obric.common.oui.R.styleable.OTabLayout_tab_textAllCaps, false);
        this.mTabSpaceEqual = r14.getBoolean(com.obric.common.oui.R.styleable.OTabLayout_tab_space_equal, true);
        this.mTabWidth = r14.getDimension(com.obric.common.oui.R.styleable.OTabLayout_tab_width, dp2px(-1.0f));
        int r0 = com.obric.common.oui.R.styleable.OTabLayout_tab_padding;
        if (this.mTabSpaceEqual == false) goto L5;
    L8:
        int r2 = dp2px(0.0f);
    L9:
        this.mTabPadding = r14.getDimension(r0, r2);
        this.mBarColor = r14.getColor(com.obric.common.oui.R.styleable.OTabLayout_bar_color, 0);
        this.mBarStrokeColor = r14.getColor(com.obric.common.oui.R.styleable.OTabLayout_bar_stroke_color, this.mBarColor);
        this.mBarStrokeWidth = r14.getDimension(com.obric.common.oui.R.styleable.OTabLayout_bar_stroke_width, dp2px(0.0f));
        this.mVibrateOnTabSelected = r14.getBoolean(com.obric.common.oui.R.styleable.OTabLayout_vibrate_on_tab_selected, false);
        initShadows(r12, r14);
        OBottomNavActionBar r15 = this;
        setShadowCornerRadius(OUnitExtensionKt.vdp(r15, 99));
        if (this.enableMaterial == false) goto L29;
        this.materialSrcType = r14.getInt(com.obric.common.oui.R.styleable.OTabLayout_oui_widgetMaterialSrcType, -1);
        String r3 = r14.getString(com.obric.common.oui.R.styleable.OTabLayout_oui_widgetMaterial);
        if (r3 != null) goto L14;
        r3 = getResources().getString(com.obric.common.oui.R.string.oui_material_bg_floating);
    L14:
        MaterialConfig[] r5 = MaterialToken.parseSet(r3, !ViewUtilKt.isDarkMode(r15));
        if (r5 == null) goto L17;
        boolean r4 = true;
    L18:
        this.enableMaterial = r4;
        this.materialApplied = r4;
        r14.recycle();
        if (this.materialApplied == false) goto L30;
        setEnableShadowWidthRadius(true);
        setRadius(OUnitExtensionKt.vdp(r15, 99));
        if (r5 == null) goto L31;
        int r16 = this.materialSrcType;
        if (r16 != (-1)) goto L27;
        r16 = 2;
    L27:
        OMaterialExtBaseKt.materials$default(r15, r5, false, r16, null, 10, null);
        GradientDrawable r17 = new GradientDrawable();
        r17.setShape(0);
        r17.setCornerRadius(OUnitExtensionKt.vdpFloat(r15, 99));
        r17.setColor(0);
        setBackground(r17);
        setOutlineProvider(ViewOutlineProvider.BACKGROUND);
        return;
    L31:
        return;
    L30:
        return;
    L17:
        r4 = false;
        goto L18
    L29:
        return;
    L5:
        if (this.mTabWidth > 0.0f) goto L8;
        r2 = dp2px(10.0f);
        goto L9
    }

    private final boolean isDarkTheme() {
        int r0 = this.mBarColor;
        if (r0 != 0) goto L7;
        return ViewUtilKt.isDarkMode(this);
    L7:
        return OPalette.isDarkColor(r0);
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

    public final void setTabTitle(int r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "title");
        String[] r0 = this.mTitles;
        if (r0 == null) goto L12;
        if (r3 >= 0) goto L7;
        return;
    L7:
        if (r3 >= r0.length) goto L11;
        r0[r3] = r4;
        updateTabContent(r3);
        return;
    L11:
        return;
    }

    public final void setTabDrawable(int r3, Drawable r4) {
        Intrinsics.checkNotNullParameter(r4, "drawable");
        Drawable[] r0 = this.mTabDrawables;
        if (r0 == null) goto L12;
        if (r3 >= 0) goto L7;
        return;
    L7:
        if (r3 >= r0.length) goto L11;
        r0[r3] = r4;
        updateTabContent(r3);
        return;
    L11:
        return;
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
        this.mCurrentTabIndex = r7;
        return;
    }

    public final Fragment getCurrentFragment() {
        ArrayList<Fragment> r0 = this.mFragments;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.get(this.mCurrentTabIndex);
    }

    private final void notifyDataSetChanged() {
        this.mIsFirstDraw = true;
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

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.View
    public void setEnabled(boolean r2) {
        super.setEnabled(r2);
        Iterator<View> r1 = this.tabList.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().setEnabled(r2);
        goto L4
    }

    @Override // com.obric.oui.material.MaterialOwner
    public void applyContentMaterial(boolean r4) {
        if (this.materialApplied != r4) goto L5;
        return;
    L5:
        this.materialApplied = r4;
        OBottomNavActionBar r0 = this;
        MaterialOwnerKt.applyBackdropMaterial(r0, r4, this.isBackdropView);
        if (this.materialApplied == false) goto L8;
        GradientDrawable r5 = new GradientDrawable();
        r5.setShape(0);
        r5.setCornerRadius(OUnitExtensionKt.vdpFloat(r0, 99));
        r5.setColor(0);
        setBackground(r5);
    L8:
        invalidate();
    }

    @Override // com.obric.oui.material.MaterialOwner, com.obric.oui.material.MaskMaterialOwner
    public void setBackdropTarget(View r1) {
        OMaterialExtBaseKt.setMaterialBackdropTarget(this, r1);
    }

    @Override // com.obric.oui.material.MaterialOwner, com.obric.oui.material.MaskMaterialOwner
    public void updateBackdropTargetType(boolean r3) {
        if (this.isBackdropView == r3) goto L9;
        this.isBackdropView = r3;
        if (this.materialSrcType == (-1)) goto L7;
        return;
    L7:
        OMaterialExtBaseKt.updateMaterialBackdropTargetType(this, r3);
        return;
    }

    @Override // com.obric.oui.material.MaterialOwner, com.obric.oui.material.MaskMaterialOwner
    public void updateBackdropSrcType(int r1) {
        this.materialSrcType = r1;
        OMaterialExtBaseKt.updateMaterialBackdropSrcType(this, r1);
    }

    private final void addTab(int r9, View r10) {
        View r0 = r10.findViewById(com.obric.common.oui.R.id.tv_tab_title);
        if (r0 == null) goto L45;
        TextView r1 = (TextView) r0;
        ImageView r2 = (ImageView) r10.findViewById(com.obric.common.oui.R.id.tv_tab_icon);
        int r3 = OUnitExtensionKt.vdp(this, 2);
        String[] r4 = this.mTitles;
        Unit r5 = null;
        Drawable r6 = null;
        if (r4 != null) goto L8;
        Unit r7 = null;
    L18:
        if (r7 != null) goto L20;
        r1.setVisibility(8);
    L20:
        Drawable[] r8 = this.mTabDrawables;
        if (r8 == null) goto L27;
        if (r8 == null) goto L26;
        r6 = r8[r9];
    L26:
        r2.setImageDrawable(r6);
        r5 = Unit.INSTANCE;
    L27:
        if (r5 != null) goto L33;
        r2.setVisibility(8);
        ViewGroup.LayoutParams r11 = r1.getLayoutParams();
        if (r11 == null) goto L32;
        LinearLayout.LayoutParams r12 = (LinearLayout.LayoutParams) r11;
        r12.setMargins(0, r3, 0, 0);
        r1.setLayoutParams(r12);
        goto L33
    L32:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L33:
        r10.setOnTouchListener(new OBottomNavActionBar$$ExternalSyntheticLambda0(this));
        r10.setOnClickListener(new OBottomNavActionBar$$ExternalSyntheticLambda1(this));
        this.tabList.add(r10);
        if (this.mTabSpaceEqual == false) goto L36;
        LinearLayout.LayoutParams r13 = new LinearLayout.LayoutParams(0, -1, 1.0f);
    L38:
        if (this.mTabWidth <= 0.0f) goto L40;
        r13 = new LinearLayout.LayoutParams((int) this.mTabWidth, -1);
    L40:
        this.mTabsContainer.addView(r10, r9, r13);
        return;
    L36:
        r13 = new LinearLayout.LayoutParams(-2, -1);
        goto L38
    L8:
        if (r4 != null) goto L10;
    L9:
    L14:
        r1.setText(r7);
        ViewGroup.LayoutParams r14 = r1.getLayoutParams();
        if (r14 == null) goto L43;
        LinearLayout.LayoutParams r15 = (LinearLayout.LayoutParams) r14;
        r15.setMargins(0, r3, 0, 0);
        r1.setLayoutParams(r15);
        r7 = Unit.INSTANCE;
        goto L18
    L43:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L10:
        String r16 = r4[r9];
        if (r16 == null) goto L9;
        String r17 = r16;
        goto L14
    L45:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    }

    /* JADX INFO: renamed from: addTab$lambda-16, reason: not valid java name */
    private static final boolean m1358addTab$lambda16(OBottomNavActionBar r1, View r2, MotionEvent r3) {
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

    /* JADX INFO: renamed from: addTab$lambda-17, reason: not valid java name */
    private static final void m1359addTab$lambda17(OBottomNavActionBar r2, View r3) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        if (r2.mVibrateOnTabSelected == false) goto L5;
        VibratorSmt.vibrateEffectWithHapticPlayer(r2.getContext(), 1);
    L5:
        Object r4 = r3.getTag();
        if (r4 == null) goto L10;
        r2.setCurrentTab(((Integer) r4).intValue());
        return;
    L10:
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

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        int r0 = r3.getAction();
        if (r0 == 0) goto L9;
        if (r0 != 1) goto L6;
    L8:
        doPressAnim(false);
    L11:
        return super.dispatchTouchEvent(r3);
    L6:
        if (r0 == 3) goto L8;
    L9:
        doPressAnim(true);
        goto L11
    }

    private final void doPressAnim(boolean r5) {
        AnimationManager r0 = this.pressAnim;
        if (r0 == null) goto L6;
        AnimationManager.cancelAnimation$default(r0, false, 1, null);
    L6:
        AnimationManager r1 = this.releaseAnim;
        if (r1 == null) goto L10;
        AnimationManager.cancelAnimation$default(r1, false, 1, null);
    L10:
        if (r5 == false) goto L12;
        this.pressAnim = ShadowAnimator.startWithScaleAnimation(this, this.initScale, this.pressScale, getCurrentShadows(), this.shadowsPressed);
        return;
    L12:
        this.releaseAnim = ShadowAnimator.startWithScaleAnimation(this, this.pressScale, this.initScale, getCurrentShadows(), this.shadowsNormal);
    }

    private final void updateTabStyles() {
        int r0 = this.tabCount;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L29;
        int r3 = r2 + 1;
        View r4 = this.mTabsContainer.getChildAt(r2);
        float r5 = this.mTabPadding;
        r4.setPadding((int) r5, 0, (int) r5, 0);
        View r6 = r4.findViewById(com.obric.common.oui.R.id.tv_tab_title);
        if (r6 == null) goto L28;
        TextView r7 = (TextView) r6;
        if (r2 != this.mCurrentTabIndex) goto L9;
        boolean r8 = true;
    L11:
        if ((r4 instanceof OSegmentTabView) == false) goto L13;
        ((OSegmentTabView) r4).updateSelectState(r8);
        r7.setTextSize(0, this.mTextSize);
    L17:
        ImageView r9 = (ImageView) r4.findViewById(com.obric.common.oui.R.id.tv_tab_icon);
        if (r8 == false) goto L20;
        int r10 = this.mTextSelectColor;
    L21:
        r9.setImageTintList(ColorStateList.valueOf(r10));
        if (this.mTextAllCaps == false) goto L24;
        String r11 = r7.getText().toString();
        Locale r12 = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(r12, "ROOT");
        String r13 = r11.toUpperCase(r12);
        Intrinsics.checkNotNullExpressionValue(r13, "this as java.lang.String).toUpperCase(locale)");
        r7.setText(r13);
    L24:
        if (r8 == false) goto L26;
        this.currentTabView = r4;
    L26:
        r2 = r3;
        goto L3
    L20:
        r10 = this.mTextUnselectColor;
        goto L21
    L13:
        if (r8 == false) goto L15;
        int r14 = this.mTextSelectColor;
    L16:
        r7.setTextColor(r14);
        r7.setTextSize(0, this.mTextSize);
        goto L17
    L15:
        r14 = this.mTextUnselectColor;
        goto L16
    L9:
        r8 = false;
        goto L11
    L28:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    }

    private final void updateTabContent(int r5) {
        View r0 = this.mTabsContainer.getChildAt(r5);
        View r1 = r0.findViewById(com.obric.common.oui.R.id.tv_tab_title);
        if (r1 == null) goto L24;
        TextView r2 = (TextView) r1;
        ImageView r3 = (ImageView) r0.findViewById(com.obric.common.oui.R.id.tv_tab_icon);
        String[] r4 = this.mTitles;
        if (r4 != null) goto L8;
    L15:
        Drawable[] r6 = this.mTabDrawables;
        if (r6 == null) goto L25;
        if (r6 != null) goto L20;
        Drawable r7 = null;
    L21:
        r3.setImageDrawable(r7);
        return;
    L20:
        r7 = r6[r5];
        goto L21
    L25:
        return;
    L8:
        if (r4 != null) goto L10;
    L9:
    L14:
        r2.setText(r3);
        goto L15
    L10:
        String r8 = r4[r5];
        if (r8 == null) goto L9;
        String r9 = r8;
        goto L14
    L24:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    }

    private final void updateTabSelection(int r8) {
        int r0 = this.tabCount;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L25;
        int r3 = r2 + 1;
        View r4 = this.mTabsContainer.getChildAt(r2);
        if (r2 != r8) goto L7;
        boolean r5 = true;
    L8:
        ImageView r6 = (ImageView) r4.findViewById(com.obric.common.oui.R.id.tv_tab_icon);
        if (r5 == false) goto L11;
        int r7 = this.mTextSelectColor;
    L12:
        r6.setImageTintList(ColorStateList.valueOf(r7));
        KtExt r9 = KtExt.INSTANCE;
        View r10 = null;
        if (r4 != null) goto L16;
    L18:
        OSegmentTabView r11 = (OSegmentTabView) r10;
        if (r11 == null) goto L22;
        r11.updateSelectState(r5);
    L22:
        if (r5 == false) goto L24;
        this.currentTabView = r4;
    L24:
        r2 = r3;
        goto L3
    L16:
        if ((r4 instanceof OSegmentTabView) == false) goto L18;
        r10 = r4;
        goto L18
    L11:
        r7 = this.mTextUnselectColor;
        goto L12
    L7:
        r5 = false;
        goto L8
    }

    private final void trackNewTabPosition() {
        View r0 = this.currentTabView;
        Intrinsics.checkNotNull(r0);
        float r1 = r0.getLeft();
        View r2 = this.currentTabView;
        Intrinsics.checkNotNull(r2);
        float r3 = r2.getRight();
        ONaviIndicatorDrawable r4 = this.indicatorDrawable;
        r4.updateBound(r1, this.indicatorSpacing, r3 - r1, r4.getIndicatorHeight());
    }

    private final void calcIndicatorRect() {
        if (this.indicatorDrawable.isAnimRunning() == true) goto L6;
        View r0 = this.currentTabView;
        Intrinsics.checkNotNull(r0);
        float r1 = r0.getLeft();
        View r2 = this.currentTabView;
        Intrinsics.checkNotNull(r2);
        float r3 = r2.getRight();
        ONaviIndicatorDrawable r4 = this.indicatorDrawable;
        r4.setBound(r1, this.indicatorSpacing + this.mBarStrokeWidth, r3 - r1, r4.getIndicatorHeight());
        return;
    }

    @Override // android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable r2) {
        Intrinsics.checkNotNullParameter(r2, "drawable");
        super.invalidateDrawable(r2);
        if (Intrinsics.areEqual(r2, this.indicatorDrawable) == false) goto L6;
        invalidate();
        return;
    }

    @Override // android.view.View
    protected void onDraw(Canvas r3) {
        Intrinsics.checkNotNullParameter(r3, "canvas");
        super.onDraw(r3);
        if (isInEditMode() == false) goto L5;
        return;
    L5:
        if (this.tabCount <= 0) goto L10;
        float r0 = this.indicatorDrawable.getIndicatorCornerRadius() + (this.indicatorSpacing / 2);
        drawBar(r3, r0);
        drawStroke(r3, r0);
        drawDivider(r3);
        drawIndicator(r3);
        return;
    }

    private final void drawBar(Canvas r6, float r7) {
        if (this.materialApplied == false) goto L5;
        return;
    L5:
        this.barPaint.setColor(this.mBarColor);
        this.barRectF.set(0.0f, getPaddingTop(), getWidth(), getHeight() - getPaddingBottom());
        SmoothCornerH.drawRoundRect(r6, this.barRectF, r7, this.barPaint);
    }

    private final void drawStroke(Canvas r8, float r9) {
        if (this.mBarStrokeWidth <= 0.0f) goto L6;
        this.barStrokePaint.setColor(this.mBarStrokeColor);
        this.barStrokePaint.setStrokeWidth(this.mBarStrokeWidth);
        float r2 = 2;
        this.barStrokeRectF.set(this.mBarStrokeWidth / r2, getPaddingTop() + (this.mBarStrokeWidth / r2), getWidth() - (this.mBarStrokeWidth / r2), (getHeight() - getPaddingBottom()) - (this.mBarStrokeWidth / r2));
        SmoothCornerH.drawRoundRect(r8, this.barStrokeRectF, r9, this.barStrokePaint);
        return;
    }

    private final void drawDivider(Canvas r11) {
        if (this.indicatorDrawable.getEnableAnimation() == true) goto L9;
        float r0 = this.mDividerWidth;
        if (r0 <= 0.0f) goto L11;
        this.mDividerPaint.setStrokeWidth(r0);
        this.mDividerPaint.setColor(this.mDividerColor);
        int r1 = this.tabCount - 1;
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L12;
        int r3 = r2 + 1;
        View r4 = this.mTabsContainer.getChildAt(r2);
        r11.drawLine(getPaddingLeft() + r4.getRight(), this.mDividerPadding, getPaddingLeft() + r4.getRight(), getHeight() - this.mDividerPadding, this.mDividerPaint);
        r2 = r3;
        goto L7
    L12:
        return;
    L11:
        return;
    }

    private final void drawIndicator(Canvas r3) {
        if (this.indicatorDrawable.getEnableAnimation() == true) goto L5;
        calcIndicatorRect();
    L8:
        r3.translate(getPaddingLeft(), getPaddingTop());
        this.indicatorDrawable.draw(r3);
        r3.translate(-getPaddingLeft(), -getPaddingTop());
        return;
    L5:
        if (this.mIsFirstDraw == false) goto L8;
        this.mIsFirstDraw = false;
        calcIndicatorRect();
        goto L8
    }

    public final int getCurrentTab() {
        return this.mCurrentTabIndex;
    }

    public final void setCurrentTab(int r3) {
        int r0 = this.mCurrentTabIndex;
        if (r3 != r0) goto L10;
        TabSelectListener r2 = this.mListener;
        if (r2 == null) goto L20;
        if (r2 == null) goto L21;
        r2.onReselect(r0);
        return;
    L21:
        return;
    L20:
        return;
    L10:
        this.mIsFirstDraw = true;
        this.mLastTabIndex = r0;
        this.mCurrentTabIndex = r3;
        updateTabSelection(r3);
        setFragments(r3);
        TabSelectListener r4 = this.mListener;
        if (r4 == null) goto L16;
        if (r4 == null) goto L16;
        r4.onSelect(this.mCurrentTabIndex);
    L16:
        if (this.indicatorDrawable.getEnableAnimation() == false) goto L18;
        trackNewTabPosition();
        return;
    L18:
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
        return this.indicatorDrawable.getIndicatorColor();
    }

    public final void setIndicatorColor(int r1) {
        this.indicatorDrawable.setIndicatorColor(r1);
    }

    public final float getIndicatorHeight() {
        return this.indicatorDrawable.getIndicatorHeight();
    }

    public final void setIndicatorHeight(float r2) {
        this.indicatorDrawable.setIndicatorHeight(dp2px(r2));
    }

    public final float getIndicatorCornerRadius() {
        return this.indicatorCornerRadius;
    }

    public final void setIndicatorCornerRadius(float r2) {
        this.indicatorDrawable.setIndicatorCornerRadius(dp2px(r2));
        this.indicatorCornerRadius = this.indicatorDrawable.getIndicatorCornerRadius();
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

    public final float getTextSize() {
        return this.mTextSize;
    }

    public final void setTextSize(float r1) {
        this.mTextSize = sp2px(r1);
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
        this.mTextPaint.setTextSize(this.mTextSize);
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

    public final void setOnTabSelectAnimListener(TabSelectAnimListener r2) {
        this.mSelectAnimListener = r2;
        if (r2 != null) goto L6;
        this.indicatorDrawable.setAnimListener(null);
        return;
    L6:
        this.indicatorDrawable.setAnimListener(new AnonymousClass1(this));
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Bundle r0 = new Bundle();
        r0.putInt("mCurrentTab", this.mCurrentTabIndex);
        r0.putParcelable("instanceState", super.onSaveInstanceState());
        return r0;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
        if ((r2 instanceof Bundle) == false) goto L12;
        Bundle r3 = (Bundle) r2;
        int r0 = r3.getInt("mCurrentTab");
        this.mCurrentTabIndex = r0;
        this.mLastTabIndex = r0;
        r2 = r3.getParcelable("instanceState");
        if (this.mCurrentTabIndex == 0) goto L12;
        if (this.mTabsContainer.getChildCount() == 0) goto L9;
        boolean r1 = true;
    L10:
        if (r1 == false) goto L12;
        updateTabSelection(this.mCurrentTabIndex);
        goto L12
    L9:
        r1 = false;
    L12:
        super.onRestoreInstanceState(r2);
    }

    private final int dp2px(float r1) {
        return (int) ((r1 * this.mContext.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private final int sp2px(float r1) {
        return (int) ((r1 * this.mContext.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    private final void initShadows(Context r4, TypedArray r5) {
        List<Shadow> r0 = OUILayoutHelper.createShadowListFromAttr(r4, r5, com.obric.common.oui.R.styleable.OTabLayout_shadow_normal);
        if (r0 != null) goto L5;
        r0 = OUILayoutHelper.createShadowListFromAttr(r4, r5, com.obric.common.oui.R.styleable.OTabLayout_oui_widgetShadowNormal);
    L5:
        if (r0 == null) goto L7;
        this.shadowsNormal = r0;
        Intrinsics.checkNotNull(r0);
        Shadow r1 = (Shadow) CollectionsKt.getOrNull(r0, 0);
        List<Shadow> r2 = this.shadowsNormal;
        Intrinsics.checkNotNull(r2);
        setShadow(r1, (Shadow) CollectionsKt.getOrNull(r2, 1));
    L7:
        List<Shadow> r3 = OUILayoutHelper.createShadowListFromAttr(r4, r5, com.obric.common.oui.R.styleable.OTabLayout_shadow_pressed);
        if (r3 != null) goto L10;
        r3 = OUILayoutHelper.createShadowListFromAttr(r4, r5, com.obric.common.oui.R.styleable.OTabLayout_oui_widgetShadowPressed);
    L10:
        if (r3 == null) goto L13;
        this.shadowsPressed = r3;
        return;
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        this.indicatorDrawable.checkAndInitHeightAndRadius(getHeight(), this.indicatorSpacing);
        if (getWidth() == this.lastLayoutWidth) goto L6;
        this.lastLayoutWidth = getWidth();
        this.mIsFirstDraw = true;
        return;
    }
}
