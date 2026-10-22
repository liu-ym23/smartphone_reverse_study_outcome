package com.obric.oui.button;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.core.content.ContextCompat;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.obric.common.oui.R;
import com.obric.oui.common.style.IOUIAlpha;
import com.obric.oui.common.style.IOUILayout;
import com.obric.oui.common.style.IOUIStyleProvider;
import com.obric.oui.common.style.OUIAlphaHelper;
import com.obric.oui.common.style.OUIEffectHelper;
import com.obric.oui.common.style.OUILayoutHelper;
import com.obric.oui.common.style.OUIStyleProvider;
import com.obric.oui.common.style.Shadow;
import com.obric.oui.material.MaterialConfigFormatNames;
import com.obric.oui.utils.ViewUtil;
import com.obric.oui.utils.log.L;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: OButton.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000e\n\u0002\b^\b\u0017\u0018\u0000 Õ\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002Õ\u0001B7\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0010\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0010H\u0002J\t\u0010.\u001a\u00020\u0010H\u0096\u0001J\u0011\u0010/\u001a\u00020,2\u0006\u00100\u001a\u00020\u0010H\u0096\u0001J\u0010\u00101\u001a\u00020,2\b\u00102\u001a\u0004\u0018\u000103J\t\u00104\u001a\u00020\u0002H\u0096\u0001J\u0010\u00105\u001a\u00020\u00132\u0006\u00106\u001a\u00020\u0013H\u0002J\u0010\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:H\u0002J-\u0010;\u001a&\u0012\f\u0012\n >*\u0004\u0018\u00010=0= >*\u0012\u0012\f\u0012\n >*\u0004\u0018\u00010=0=\u0018\u00010?0<H\u0096\u0001J\t\u0010@\u001a\u00020(H\u0096\u0001J\t\u0010A\u001a\u00020\u0003H\u0096\u0001J\t\u0010B\u001a\u00020\nH\u0096\u0001J\t\u0010C\u001a\u00020\u0013H\u0096\u0001J\t\u0010D\u001a\u00020\nH\u0096\u0001J\t\u0010E\u001a\u00020\nH\u0096\u0001J\u0019\u0010F\u001a\u00020,2\u000e\u0010G\u001a\n >*\u0004\u0018\u00010H0HH\u0096\u0001J\t\u0010I\u001a\u00020\u0010H\u0096\u0001J\t\u0010J\u001a\u00020\u0010H\u0096\u0001J\t\u0010K\u001a\u00020\u0010H\u0096\u0001J\t\u0010L\u001a\u00020\u0010H\u0096\u0001J\t\u0010M\u001a\u00020\u0010H\u0096\u0001J\u001a\u0010N\u001a\u00020,2\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J\t\u0010O\u001a\u00020\u0010H\u0096\u0001J\t\u0010P\u001a\u00020\u0010H\u0096\u0001J\u0010\u0010Q\u001a\u00020,2\u0006\u00102\u001a\u000203H\u0014J0\u0010R\u001a\u00020,2\u0006\u0010S\u001a\u00020\u00102\u0006\u0010T\u001a\u00020\n2\u0006\u0010U\u001a\u00020\n2\u0006\u0010V\u001a\u00020\n2\u0006\u0010W\u001a\u00020\nH\u0014J\u0018\u0010X\u001a\u00020,2\u0006\u0010Y\u001a\u00020\n2\u0006\u0010Z\u001a\u00020\nH\u0014J\u0010\u0010[\u001a\u00020,2\u0006\u0010\\\u001a\u00020\nH\u0017J!\u0010]\u001a\u00020,2\u000e\u0010^\u001a\n >*\u0004\u0018\u00010_0_2\u0006\u0010`\u001a\u00020\u0010H\u0096\u0001J!\u0010a\u001a\u00020,2\u000e\u0010^\u001a\n >*\u0004\u0018\u00010_0_2\u0006\u0010`\u001a\u00020\u0010H\u0096\u0001J)\u0010b\u001a\u00020,2\u0006\u0010c\u001a\u00020\n2\u0006\u0010d\u001a\u00020\n2\u0006\u0010e\u001a\u00020\n2\u0006\u0010f\u001a\u00020\nH\u0096\u0001J)\u0010g\u001a\u00020,2\u0006\u0010h\u001a\u00020\n2\u0006\u0010i\u001a\u00020\n2\u0006\u0010j\u001a\u00020\n2\u0006\u0010k\u001a\u00020\nH\u0096\u0001J)\u0010l\u001a\u00020,2\u0006\u0010m\u001a\u00020\n2\u0006\u0010n\u001a\u00020\n2\u0006\u0010o\u001a\u00020\n2\u0006\u0010p\u001a\u00020\nH\u0096\u0001J)\u0010q\u001a\u00020,2\u0006\u0010r\u001a\u00020\n2\u0006\u0010s\u001a\u00020\n2\u0006\u0010t\u001a\u00020\n2\u0006\u0010u\u001a\u00020\nH\u0096\u0001J\u0019\u0010v\u001a\u00020,2\u000e\u0010w\u001a\n >*\u0004\u0018\u00010x0xH\u0096\u0001J\t\u0010y\u001a\u00020,H\u0096\u0001J\u0013\u0010z\u001a\u00020,2\b\b\u0001\u0010{\u001a\u00020\nH\u0096\u0001J\u0011\u0010|\u001a\u00020,2\u0006\u0010}\u001a\u00020\nH\u0096\u0001J\u0011\u0010~\u001a\u00020,2\u0006\u0010\u007f\u001a\u00020\nH\u0096\u0001J\u0010\u0010\u0080\u0001\u001a\u00020,2\u0007\u0010\u0081\u0001\u001a\u00020\nJ\u0019\u0010\u0080\u0001\u001a\u00020,2\u0007\u0010\u0081\u0001\u001a\u00020\n2\u0007\u0010\u0082\u0001\u001a\u00020\nJ\u0013\u0010\u0083\u0001\u001a\u00020,2\u0007\u0010\u0084\u0001\u001a\u00020\u0010H\u0096\u0001J\u0013\u0010\u0085\u0001\u001a\u00020,2\u0007\u0010\u0086\u0001\u001a\u00020\u0010H\u0096\u0001J\u0013\u0010\u0087\u0001\u001a\u00020,2\u0007\u0010\u0088\u0001\u001a\u00020\u0010H\u0096\u0001J1\u0010\u0089\u0001\u001a\u00020,2\b\u0010T\u001a\u0004\u0018\u00010\u00192\b\u0010U\u001a\u0004\u0018\u00010\u00192\b\u0010V\u001a\u0004\u0018\u00010\u00192\b\u0010W\u001a\u0004\u0018\u00010\u0019H\u0016J3\u0010\u008a\u0001\u001a\u00020,2\t\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u00192\b\u0010U\u001a\u0004\u0018\u00010\u00192\t\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u00192\b\u0010W\u001a\u0004\u0018\u00010\u0019H\u0016J\u000f\u0010\u008d\u0001\u001a\u00020,2\u0006\u0010\\\u001a\u00020\u0013J\u0013\u0010\u008e\u0001\u001a\u00020,2\u0007\u0010\u008f\u0001\u001a\u00020\u0010H\u0096\u0001J\u0012\u0010\u0090\u0001\u001a\u00020,2\u0007\u0010\u0091\u0001\u001a\u00020\u0010H\u0016J\u0013\u0010\u0092\u0001\u001a\u00020\u00102\u0007\u0010\u0093\u0001\u001a\u00020\nH\u0096\u0001J\u0013\u0010\u0094\u0001\u001a\u00020,2\u0007\u0010\u0095\u0001\u001a\u00020\u0010H\u0096\u0001J\u0012\u0010\u0096\u0001\u001a\u00020,2\u0006\u0010\u007f\u001a\u00020\nH\u0096\u0001J\u0013\u0010\u0097\u0001\u001a\u00020,2\u0007\u0010\u0098\u0001\u001a\u00020\nH\u0096\u0001J\u0013\u0010\u0099\u0001\u001a\u00020,2\u0007\u0010\u009a\u0001\u001a\u00020\u0010H\u0096\u0001J*\u0010\u009b\u0001\u001a\u00020,2\u0006\u0010T\u001a\u00020\n2\u0006\u0010U\u001a\u00020\n2\u0006\u0010V\u001a\u00020\n2\u0006\u0010W\u001a\u00020\nH\u0096\u0001J\u0013\u0010\u009c\u0001\u001a\u00020,2\u0007\u0010\u0098\u0001\u001a\u00020\nH\u0096\u0001J\u0011\u0010\u009d\u0001\u001a\u00020,2\u0006\u0010`\u001a\u00020\u0010H\u0002J\u0011\u0010\u009e\u0001\u001a\u00020,2\u0006\u0010`\u001a\u00020\u0010H\u0016J\u0013\u0010\u009f\u0001\u001a\u00020,2\u0007\u0010 \u0001\u001a\u00020\nH\u0096\u0001J.\u0010\u009f\u0001\u001a\u00020,2\u0007\u0010¡\u0001\u001a\u00020\n2\u0007\u0010¢\u0001\u001a\u00020\n2\u0007\u0010£\u0001\u001a\u00020\n2\u0007\u0010¤\u0001\u001a\u00020\nH\u0096\u0001J%\u0010¥\u0001\u001a\u00020,2\u0007\u0010 \u0001\u001a\u00020\n2\u0007\u0010¦\u0001\u001a\u00020\n2\u0007\u0010§\u0001\u001a\u00020\u0013H\u0096\u0001J.\u0010¥\u0001\u001a\u00020,2\u0007\u0010 \u0001\u001a\u00020\n2\u0007\u0010¦\u0001\u001a\u00020\n2\u0007\u0010¨\u0001\u001a\u00020\n2\u0007\u0010§\u0001\u001a\u00020\u0013H\u0096\u0001J\u0012\u0010©\u0001\u001a\u00020,2\u0006\u0010\u007f\u001a\u00020\nH\u0096\u0001J\u0012\u0010ª\u0001\u001a\u00020,2\u0007\u0010«\u0001\u001a\u00020\u0010H\u0016J-\u0010¬\u0001\u001a\u00020,2\u000b\b\u0001\u0010\u00ad\u0001\u001a\u0004\u0018\u00010=2\u000b\b\u0001\u0010®\u0001\u001a\u0004\u0018\u00010=2\u0007\u0010¯\u0001\u001a\u00020\u0010H\u0096\u0001J\u0013\u0010°\u0001\u001a\u00020,2\u0007\u0010§\u0001\u001a\u00020\u0013H\u0096\u0001J\u0013\u0010±\u0001\u001a\u00020,2\u0007\u0010¨\u0001\u001a\u00020\nH\u0096\u0001J\u0013\u0010²\u0001\u001a\u00020,2\u0007\u0010 \u0001\u001a\u00020\nH\u0096\u0001J\u0013\u0010³\u0001\u001a\u00020,2\u0007\u0010´\u0001\u001a\u00020\nH\u0096\u0001J\u001c\u0010µ\u0001\u001a\u00020,2\u0007\u0010¶\u0001\u001a\u00020\n2\u0007\u0010·\u0001\u001a\u00020\nH\u0096\u0001J\u0015\u0010¸\u0001\u001a\u00020,2\t\b\u0001\u0010¹\u0001\u001a\u00020\nH\u0096\u0001J\u001c\u0010º\u0001\u001a\u00020,2\u0007\u0010»\u0001\u001a\u00020\u00102\u0007\u0010¯\u0001\u001a\u00020\u0010H\u0096\u0001J\u0013\u0010¼\u0001\u001a\u00020,2\u0007\u0010½\u0001\u001a\u00020\u0010H\u0096\u0001J\u0012\u0010¾\u0001\u001a\u00020,2\u0007\u0010\u0098\u0001\u001a\u00020\nH\u0016J\u0012\u0010¿\u0001\u001a\u00020,2\u0006\u0010\u007f\u001a\u00020\nH\u0096\u0001J\n\u0010À\u0001\u001a\u00020,H\u0096\u0001J\u0013\u0010Á\u0001\u001a\u00020\u00102\u0007\u0010Â\u0001\u001a\u00020\nH\u0096\u0001J\u0013\u0010Ã\u0001\u001a\u00020,2\u0007\u0010Ä\u0001\u001a\u00020\nH\u0096\u0001J\n\u0010Å\u0001\u001a\u00020\u0010H\u0096\u0001J*\u0010Æ\u0001\u001a\u00020,2\u0006\u0010c\u001a\u00020\n2\u0006\u0010d\u001a\u00020\n2\u0006\u0010e\u001a\u00020\n2\u0006\u0010f\u001a\u00020\nH\u0096\u0001J\u0013\u0010Ç\u0001\u001a\u00020,2\u0007\u0010\u0098\u0001\u001a\u00020\nH\u0096\u0001J\u0012\u0010È\u0001\u001a\u00020,2\u0007\u0010\u0091\u0001\u001a\u00020\u0010H\u0002J\u0013\u0010É\u0001\u001a\u00020,2\u0007\u0010Ê\u0001\u001a\u00020\u0013H\u0096\u0001J\u0011\u0010Ë\u0001\u001a\u00020,2\u0006\u00106\u001a\u00020\u0013H\u0002J*\u0010Ì\u0001\u001a\u00020,2\u0006\u0010h\u001a\u00020\n2\u0006\u0010i\u001a\u00020\n2\u0006\u0010j\u001a\u00020\n2\u0006\u0010k\u001a\u00020\nH\u0096\u0001J\u0013\u0010Í\u0001\u001a\u00020,2\u0007\u0010\u0098\u0001\u001a\u00020\nH\u0096\u0001J*\u0010Î\u0001\u001a\u00020,2\u0006\u0010m\u001a\u00020\n2\u0006\u0010n\u001a\u00020\n2\u0006\u0010o\u001a\u00020\n2\u0006\u0010p\u001a\u00020\nH\u0096\u0001J\u0013\u0010Ï\u0001\u001a\u00020,2\u0007\u0010\u0098\u0001\u001a\u00020\nH\u0096\u0001J;\u0010Ð\u0001\u001a\u00020,2/\b\u0001\u0010Ñ\u0001\u001a(\u0012\f\u0012\n >*\u0004\u0018\u00010=0=\u0018\u0001 >*\u0012\u0012\f\u0012\n >*\u0004\u0018\u00010=0=\u0018\u00010?0<H\u0096\u0001J\u0011\u0010Ò\u0001\u001a\u00020,2\u0006\u00106\u001a\u00020\u0013H\u0002J*\u0010Ó\u0001\u001a\u00020,2\u0006\u0010r\u001a\u00020\n2\u0006\u0010s\u001a\u00020\n2\u0006\u0010t\u001a\u00020\n2\u0006\u0010u\u001a\u00020\nH\u0096\u0001J\u0013\u0010Ô\u0001\u001a\u00020,2\u0007\u0010\u0098\u0001\u001a\u00020\nH\u0096\u0001R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010 \u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Ö\u0001"}, d2 = {"Lcom/obric/oui/button/OButton;", "Landroid/widget/Button;", "Lcom/obric/oui/common/style/IOUIAlpha;", "Lcom/obric/oui/common/style/IOUILayout;", "Lcom/obric/oui/common/style/IOUIStyleProvider;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "provider", "Lcom/obric/oui/common/style/OUIStyleProvider;", "(Landroid/content/Context;Landroid/util/AttributeSet;IILcom/obric/oui/common/style/OUIStyleProvider;)V", "changeAlphaWhenPressed", "", "customPaddingOffset", "disabledAlpha", "", "internalPressState", "isInternalTextColorChange", "mAlphaHelper", "Lcom/obric/oui/common/style/OUIAlphaHelper;", "value", "Landroid/graphics/drawable/Drawable;", "mIcon", "getMIcon", "()Landroid/graphics/drawable/Drawable;", "setMIcon", "(Landroid/graphics/drawable/Drawable;)V", "mImageSourceId", "mImageTintColorId", "getMImageTintColorId", "()I", "setMImageTintColorId", "(I)V", "mLayoutHelper", "Lcom/obric/oui/common/style/OUILayoutHelper;", "mOUIEffectHelper", "Lcom/obric/oui/common/style/OUIEffectHelper;", "originIconAlpha", "originTextColor", "adjustPaddingLeft", "", "hasLeftDrawable", "decideIsNeedUpdatePressedForegroundBySelf", "disablePressReleaseAnim", MaterialConfigFormatNames.DISABLE, "drawIcon", "canvas", "Landroid/graphics/Canvas;", "getAlphaHelper", "getAnimatedPressAlpha", "fraction", "getBitmapFromVectorDrawable", "Landroid/graphics/Bitmap;", "vectorDrawable", "Landroid/graphics/drawable/VectorDrawable;", "getCurrentShadows", "", "Lcom/obric/oui/common/style/Shadow;", "kotlin.jvm.PlatformType", "", "getEffectHelper", "getLayoutHelper", "getRadius", "getShadowAlpha", "getShadowColor", "getShadowElevation", "handleTouchEvent", "event", "Landroid/view/MotionEvent;", "hasBorder", "hasBottomSeparator", "hasLeftSeparator", "hasRightSeparator", "hasTopSeparator", "initView", "isEnableShadowWidthRadius", "isShadowVisible", "onDraw", "onLayout", "changed", "left", "top", "right", "bottom", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onPressAlphaChange", "alpha", "onPressedChanged", PerfConsts.KEY_CURRENT_GALVANIC, "Landroid/view/View;", "pressed", "onSelectedChanged", "onlyShowBottomDivider", "bottomInsetLeft", "bottomInsetRight", "bottomDividerHeight", "bottomDividerColor", "onlyShowLeftDivider", "leftInsetTop", "leftInsetBottom", "leftDividerWidth", "leftDividerColor", "onlyShowRightDivider", "rightInsetTop", "rightInsetBottom", "rightDividerWidth", "rightDividerColor", "onlyShowTopDivider", "topInsetLeft", "topInsetRight", "topDividerHeight", "topDividerColor", "refreshColors", "scene", "", "resetAlphaAnim", "setBorderColor", "borderColor", "setBorderWidth", "borderWidth", "setBottomDividerAlpha", "dividerAlpha", "setButtonSourceBitmap", "resId", "tintColor", "setChangeAlphaWhenDisable", "changeAlphaWhenDisable", "setChangeAlphaWhenPress", "changeAlphaWhenPress", "setChangeAlphaWhenSelected", "changeAlphaWhenSelected", "setCompoundDrawables", "setCompoundDrawablesRelative", "start", TraceStatsConsts.STATS_KEY_END, "setDisabledTextAlpha", "setEnableShadowWidthRadius", "enableShadowWidthRadius", "setEnabled", "enabled", "setHeightLimit", "heightLimit", "setKeepPressAlpha", "keep", "setLeftDividerAlpha", "setOuterNormalColor", "color", "setOutlineExcludePadding", "outlineExcludePadding", "setOutlineInset", "setOverridePressColor", "setPressState", "setPressed", "setRadius", "radius", "tlRadius", "trRadius", "blRadius", "brRadius", "setRadiusAndShadow", "shadowElevation", "shadowAlpha", "shadowColor", "setRightDividerAlpha", "setSelected", MaterialConfigFormatNames.SELECTED, "setShadow", "firstShadow", "secondShadow", "animate", "setShadowAlpha", "setShadowColor", "setShadowCornerRadius", "setShadowElevation", "elevation", "setShadowInsets", "insetX", "insetY", "setShadowStyle", "styleResId", "setShadowVisible", "visible", "setShowBorderOnlyBeforeL", "showBorderOnlyBeforeL", "setTextColor", "setTopDividerAlpha", "setUseThemeGeneralShadowElevation", "setWidthLimit", "widthLimit", "setWidthMin", "minWidth", "shouldUpdateDividerColorOnPress", "updateBottomDivider", "updateBottomSeparatorColor", "updateContentColorForState", "updateDividerColorStrength", "strength", "updateIconAlphaOnPress", "updateLeftDivider", "updateLeftSeparatorColor", "updateRightDivider", "updateRightSeparatorColor", "updateShadows", MaterialConfigFormatNames.SHADOWS, "updateTextColorOnPress", "updateTopDivider", "updateTopSeparatorColor", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OButton extends Button implements IOUIAlpha, IOUILayout, IOUIStyleProvider {
    private static final float ALPHA_ON_PRESS = 0.3f;
    public static final Companion Companion = null;
    private static final String TAG = "OButton";
    private final /* synthetic */ IOUIAlpha $$delegate_0;
    private final /* synthetic */ IOUILayout $$delegate_1;
    private final /* synthetic */ OUIStyleProvider $$delegate_2;
    private boolean changeAlphaWhenPressed;
    private int customPaddingOffset;
    private float disabledAlpha;
    private boolean internalPressState;
    private boolean isInternalTextColorChange;
    private OUIAlphaHelper mAlphaHelper;
    private Drawable mIcon;
    private int mImageSourceId;
    private int mImageTintColorId;
    private OUILayoutHelper mLayoutHelper;
    private OUIEffectHelper mOUIEffectHelper;
    private int originIconAlpha;
    private int originTextColor;

    /* JADX INFO: compiled from: OButton.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\u0010\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\u0011\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\u0012\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\u0013\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\u0014\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/obric/oui/button/OButton$Companion;", "", "()V", "ALPHA_ON_PRESS", "", "TAG", "", "createButton", "Lcom/obric/oui/button/OButton;", "context", "Landroid/content/Context;", "root", "Landroid/view/ViewGroup;", "layoutResId", "", "createNeutralButton", "createPrimaryButton", "createPrimaryLightButton", "createTransButton", "createTransIconButton", "createUnderstatedButton", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final OButton createNeutralButton(Context r2, ViewGroup r3) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r3, "root");
            return createButton(r2, r3, R.layout.o_widget_titlebar_button_neutral);
        }

        public final OButton createPrimaryButton(Context r2, ViewGroup r3) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r3, "root");
            return createButton(r2, r3, R.layout.o_widget_titlebar_primary_button);
        }

        public final OButton createPrimaryLightButton(Context r2, ViewGroup r3) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r3, "root");
            return createButton(r2, r3, R.layout.o_widget_titlebar_primarylight_button);
        }

        public final OButton createTransButton(Context r2, ViewGroup r3) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r3, "root");
            return createButton(r2, r3, R.layout.o_widget_titlebar_trans_button);
        }

        public final OButton createUnderstatedButton(Context r2, ViewGroup r3) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r3, "root");
            return createButton(r2, r3, R.layout.o_widget_titlebar_understated_button);
        }

        public final OButton createTransIconButton(Context r2, ViewGroup r3) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r3, "root");
            return createButton(r2, r3, R.layout.o_widget_titlebar_trans_icon_button);
        }

        public final OButton createButton(Context r1, ViewGroup r2, int r3) {
            Intrinsics.checkNotNullParameter(r1, "context");
            Intrinsics.checkNotNullParameter(r2, "root");
            if (((OButton) r2.findViewById(R.id.btn_titlebar)) != null) goto L5;
            View r0 = Button.inflate(r1, r3, r2).findViewById(R.id.btn_titlebar);
            Intrinsics.checkNotNull(r0);
            return (OButton) r0;
        L5:
            View r4 = LayoutInflater.from(r1).inflate(r3, r2, false);
            if (r4 == null) goto L10;
            OButton r5 = (OButton) r4;
            r5.setId(-1);
            r2.addView(r5);
            return r5;
        L10:
            throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.button.OButton");
        }
    }

    static {
        Companion = new Companion(null);
    }

    public OButton(Context r10, AttributeSet r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        this(r10, r11, 0, 0, null, 28, null);
    }

    public OButton(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        this(r10, r11, r12, 0, null, 24, null);
    }

    public OButton(Context r10, AttributeSet r11, int r12, int r13) {
        Intrinsics.checkNotNullParameter(r10, "context");
        this(r10, r11, r12, r13, null, 16, null);
    }

    private final float getAnimatedPressAlpha(float r2) {
        return 1 - (r2 * 0.7f);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public boolean decideIsNeedUpdatePressedForegroundBySelf() {
        return this.$$delegate_1.decideIsNeedUpdatePressedForegroundBySelf();
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public void disablePressReleaseAnim(boolean r1) {
        this.$$delegate_0.disablePressReleaseAnim(r1);
    }

    @Override // com.obric.oui.common.style.IOUIStyleProvider
    public IOUIAlpha getAlphaHelper() {
        return this.$$delegate_2.getAlphaHelper();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public List<Shadow> getCurrentShadows() {
        return this.$$delegate_1.getCurrentShadows();
    }

    @Override // com.obric.oui.common.style.IOUIStyleProvider
    public OUIEffectHelper getEffectHelper() {
        return this.$$delegate_2.getEffectHelper();
    }

    @Override // com.obric.oui.common.style.IOUIStyleProvider
    public IOUILayout getLayoutHelper() {
        return this.$$delegate_2.getLayoutHelper();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public int getRadius() {
        return this.$$delegate_1.getRadius();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public float getShadowAlpha() {
        return this.$$delegate_1.getShadowAlpha();
    }

    @Override // android.widget.TextView, com.obric.oui.common.style.IOUILayout
    public int getShadowColor() {
        return this.$$delegate_1.getShadowColor();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public int getShadowElevation() {
        return this.$$delegate_1.getShadowElevation();
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public void handleTouchEvent(MotionEvent r1) {
        this.$$delegate_0.handleTouchEvent(r1);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public boolean hasBorder() {
        return this.$$delegate_1.hasBorder();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public boolean hasBottomSeparator() {
        return this.$$delegate_1.hasBottomSeparator();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public boolean hasLeftSeparator() {
        return this.$$delegate_1.hasLeftSeparator();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public boolean hasRightSeparator() {
        return this.$$delegate_1.hasRightSeparator();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public boolean hasTopSeparator() {
        return this.$$delegate_1.hasTopSeparator();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public boolean isEnableShadowWidthRadius() {
        return this.$$delegate_1.isEnableShadowWidthRadius();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public boolean isShadowVisible() {
        return this.$$delegate_1.isShadowVisible();
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public void onPressedChanged(View r1, boolean r2) {
        this.$$delegate_0.onPressedChanged(r1, r2);
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public void onSelectedChanged(View r1, boolean r2) {
        this.$$delegate_0.onSelectedChanged(r1, r2);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void onlyShowBottomDivider(int r1, int r2, int r3, int r4) {
        this.$$delegate_1.onlyShowBottomDivider(r1, r2, r3, r4);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void onlyShowLeftDivider(int r1, int r2, int r3, int r4) {
        this.$$delegate_1.onlyShowLeftDivider(r1, r2, r3, r4);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void onlyShowRightDivider(int r1, int r2, int r3, int r4) {
        this.$$delegate_1.onlyShowRightDivider(r1, r2, r3, r4);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void onlyShowTopDivider(int r1, int r2, int r3, int r4) {
        this.$$delegate_1.onlyShowTopDivider(r1, r2, r3, r4);
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public void refreshColors(String r1) {
        this.$$delegate_0.refreshColors(r1);
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public void resetAlphaAnim() {
        this.$$delegate_0.resetAlphaAnim();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setBorderColor(int r1) {
        this.$$delegate_1.setBorderColor(r1);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setBorderWidth(int r1) {
        this.$$delegate_1.setBorderWidth(r1);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setBottomDividerAlpha(int r1) {
        this.$$delegate_1.setBottomDividerAlpha(r1);
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public void setChangeAlphaWhenDisable(boolean r1) {
        this.$$delegate_0.setChangeAlphaWhenDisable(r1);
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public void setChangeAlphaWhenPress(boolean r1) {
        this.$$delegate_0.setChangeAlphaWhenPress(r1);
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public void setChangeAlphaWhenSelected(boolean r1) {
        this.$$delegate_0.setChangeAlphaWhenSelected(r1);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setEnableShadowWidthRadius(boolean r1) {
        this.$$delegate_1.setEnableShadowWidthRadius(r1);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public boolean setHeightLimit(int r1) {
        return this.$$delegate_1.setHeightLimit(r1);
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public void setKeepPressAlpha(boolean r1) {
        this.$$delegate_0.setKeepPressAlpha(r1);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setLeftDividerAlpha(int r1) {
        this.$$delegate_1.setLeftDividerAlpha(r1);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setOuterNormalColor(int r1) {
        this.$$delegate_1.setOuterNormalColor(r1);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setOutlineExcludePadding(boolean r1) {
        this.$$delegate_1.setOutlineExcludePadding(r1);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setOutlineInset(int r1, int r2, int r3, int r4) {
        this.$$delegate_1.setOutlineInset(r1, r2, r3, r4);
    }

    @Override // com.obric.oui.common.style.IOUIAlpha
    public void setOverridePressColor(int r1) {
        this.$$delegate_0.setOverridePressColor(r1);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setRadius(int r1) {
        this.$$delegate_1.setRadius(r1);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setRadius(int r1, int r2, int r3, int r4) {
        this.$$delegate_1.setRadius(r1, r2, r3, r4);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setRadiusAndShadow(int r1, int r2, float r3) {
        this.$$delegate_1.setRadiusAndShadow(r1, r2, r3);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setRadiusAndShadow(int r1, int r2, int r3, float r4) {
        this.$$delegate_1.setRadiusAndShadow(r1, r2, r3, r4);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setRightDividerAlpha(int r1) {
        this.$$delegate_1.setRightDividerAlpha(r1);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setShadow(Shadow r1, Shadow r2, boolean r3) {
        this.$$delegate_1.setShadow(r1, r2, r3);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setShadowAlpha(float r1) {
        this.$$delegate_1.setShadowAlpha(r1);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setShadowColor(int r1) {
        this.$$delegate_1.setShadowColor(r1);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setShadowCornerRadius(int r1) {
        this.$$delegate_1.setShadowCornerRadius(r1);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setShadowElevation(int r1) {
        this.$$delegate_1.setShadowElevation(r1);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setShadowInsets(int r1, int r2) {
        this.$$delegate_1.setShadowInsets(r1, r2);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setShadowStyle(int r1) {
        this.$$delegate_1.setShadowStyle(r1);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setShadowVisible(boolean r1, boolean r2) {
        this.$$delegate_1.setShadowVisible(r1, r2);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setShowBorderOnlyBeforeL(boolean r1) {
        this.$$delegate_1.setShowBorderOnlyBeforeL(r1);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setTopDividerAlpha(int r1) {
        this.$$delegate_1.setTopDividerAlpha(r1);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setUseThemeGeneralShadowElevation() {
        this.$$delegate_1.setUseThemeGeneralShadowElevation();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public boolean setWidthLimit(int r1) {
        return this.$$delegate_1.setWidthLimit(r1);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void setWidthMin(int r1) {
        this.$$delegate_1.setWidthMin(r1);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public boolean shouldUpdateDividerColorOnPress() {
        return this.$$delegate_1.shouldUpdateDividerColorOnPress();
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void updateBottomDivider(int r1, int r2, int r3, int r4) {
        this.$$delegate_1.updateBottomDivider(r1, r2, r3, r4);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void updateBottomSeparatorColor(int r1) {
        this.$$delegate_1.updateBottomSeparatorColor(r1);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void updateDividerColorStrength(float r1) {
        this.$$delegate_1.updateDividerColorStrength(r1);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void updateLeftDivider(int r1, int r2, int r3, int r4) {
        this.$$delegate_1.updateLeftDivider(r1, r2, r3, r4);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void updateLeftSeparatorColor(int r1) {
        this.$$delegate_1.updateLeftSeparatorColor(r1);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void updateRightDivider(int r1, int r2, int r3, int r4) {
        this.$$delegate_1.updateRightDivider(r1, r2, r3, r4);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void updateRightSeparatorColor(int r1) {
        this.$$delegate_1.updateRightSeparatorColor(r1);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void updateShadows(List<Shadow> r1) {
        this.$$delegate_1.updateShadows(r1);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void updateTopDivider(int r1, int r2, int r3, int r4) {
        this.$$delegate_1.updateTopDivider(r1, r2, r3, r4);
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void updateTopSeparatorColor(int r1) {
        this.$$delegate_1.updateTopSeparatorColor(r1);
    }

    public /* synthetic */ OButton(Context r8, AttributeSet r9, int r10, int r11, OUIStyleProvider r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 4) == 0) goto L5;
        int r4 = 0;
    L7:
        if ((r13 & 8) == 0) goto L9;
        int r5 = 0;
    L11:
        if ((r13 & 16) == 0) goto L13;
        r12 = new OUIStyleProvider(r8, r9, r4, r5);
    L13:
        this(r8, r9, r4, r5, r12);
        return;
    L9:
        r5 = r11;
        goto L11
    L5:
        r4 = r10;
        goto L7
    }

    public OButton(Context r1, AttributeSet r2, int r3, int r4, OUIStyleProvider r5) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r5, "provider");
        super(r1, r2, r3);
        this.$$delegate_0 = r5.getAlphaHelper();
        this.$$delegate_1 = r5.getLayoutHelper();
        this.$$delegate_2 = r5;
        this.disabledAlpha = 1.0f;
        ((OUILayoutHelper) r5.getLayoutHelper()).setAdaptNoXmlConstruct(true);
        r5.initView(this);
        this.mLayoutHelper = (OUILayoutHelper) getLayoutHelper();
        this.mAlphaHelper = (OUIAlphaHelper) getAlphaHelper();
        this.mOUIEffectHelper = getEffectHelper();
        setChangeAlphaWhenPress(true);
        setChangeAlphaWhenDisable(true);
        initView(r1, r2);
    }

    public final Drawable getMIcon() {
        return this.mIcon;
    }

    public final void setMIcon(Drawable r1) {
        this.mIcon = r1;
        requestLayout();
        invalidate();
    }

    public final int getMImageTintColorId() {
        return this.mImageTintColorId;
    }

    public final void setMImageTintColorId(int r1) {
        this.mImageTintColorId = r1;
        invalidate();
    }

    private final void initView(Context r3, AttributeSet r4) {
        TypedArray r5 = r3.obtainStyledAttributes(r4, R.styleable.OButton);
        Intrinsics.checkNotNullExpressionValue(r5, "context.obtainStyledAttr…trs, R.styleable.OButton)");
        this.mImageSourceId = r5.getResourceId(R.styleable.OButton_icon, 0);
        setMImageTintColorId(r5.getResourceId(R.styleable.OButton_iconTint, 0));
        int r6 = this.mImageSourceId;
        if (r6 == 0) goto L5;
        setButtonSourceBitmap(r6);
    L5:
        setTextAppearance(r5.getResourceId(R.styleable.OButton_oui_buttonTextStyle, R.style.Title_Title_M_Thick));
        this.changeAlphaWhenPressed = r5.getBoolean(R.styleable.OButton_oui_buttonChangeAlphaWhenPressed, false);
        int r7 = getCurrentTextColor();
        this.originTextColor = r7;
        ColorStateList r8 = ColorStateList.valueOf(r7);
        Intrinsics.checkNotNullExpressionValue(r8, "valueOf(textColor)");
        setCompoundDrawableTintList(r8);
        this.customPaddingOffset = r5.getDimensionPixelSize(R.styleable.OButton_oui_widgetPaddingOffset, 0);
        Drawable[] r9 = getCompoundDrawables();
        Intrinsics.checkNotNullExpressionValue(r9, "getCompoundDrawables()");
        if (((Drawable) ArraysKt.getOrNull(r9, 0)) == null) goto L8;
        adjustPaddingLeft(true);
    L8:
        this.disabledAlpha = r5.getFloat(R.styleable.OButton_oui_widgetDisableAlpha, 1.0f);
        r5.recycle();
        updateContentColorForState(isEnabled());
    }

    public final void setButtonSourceBitmap(int r2) {
        if (r2 != 0) goto L4;
        return;
    L4:
        setMIcon(ContextCompat.getDrawable(getContext(), r2));
        Drawable r3 = this.mIcon;
        if (r3 != null) goto L7;
        int r4 = 0;
    L8:
        this.originIconAlpha = r4;
        invalidate();
        return;
    L7:
        r4 = r3.getAlpha();
        goto L8
    }

    public final void setButtonSourceBitmap(int r2, int r3) {
        if (r2 != 0) goto L4;
        return;
    L4:
        Drawable r4 = ContextCompat.getDrawable(getContext(), r2);
        if (r4 != null) goto L7;
        Drawable r5 = null;
    L8:
        setMIcon(r5);
        Drawable r6 = this.mIcon;
        if (r6 == null) goto L12;
        r6.setTint(r3);
    L12:
        Drawable r7 = this.mIcon;
        if (r7 != null) goto L15;
        int r8 = 0;
    L16:
        this.originIconAlpha = r8;
        invalidate();
        return;
    L15:
        r8 = r7.getAlpha();
        goto L16
    L7:
        r5 = r4.mutate();
        goto L8
    }

    private final Bitmap getBitmapFromVectorDrawable(VectorDrawable r5) {
        Bitmap r4 = Bitmap.createBitmap(r5.getIntrinsicWidth(), r5.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas r0 = new Canvas(r4);
        r5.setBounds(0, 0, r0.getWidth(), r0.getHeight());
        r5.draw(r0);
        Intrinsics.checkNotNullExpressionValue(r4, "bitmap");
        return r4;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas r2) {
        Intrinsics.checkNotNullParameter(r2, "canvas");
        super.onDraw(r2);
        drawIcon(r2);
    }

    public final void drawIcon(Canvas r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        Drawable r0 = this.mIcon;
        if (r0 != null) goto L7;
        return;
    L7:
        int r1 = (getWidth() - r0.getIntrinsicWidth()) / 2;
        int r2 = (getHeight() - r0.getIntrinsicHeight()) / 2;
        r0.setBounds(r1, r2, r0.getIntrinsicWidth() + r1, r0.getIntrinsicHeight() + r2);
        if (this.mImageTintColorId == 0) goto L10;
        r0.setColorFilter(new PorterDuffColorFilter(getResources().getColor(this.mImageTintColorId), PorterDuff.Mode.SRC_IN));
    L10:
        r0.draw(r6);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int r4, int r5) {
        super.onMeasure(r4, r5);
        int r6 = getMeasuredWidth();
        int r7 = getMeasuredHeight();
        Drawable r0 = this.mIcon;
        if (r0 == null) goto L6;
        r6 = Math.max(r6, (r0.getIntrinsicWidth() + getPaddingLeft()) + getPaddingRight());
        r7 = Math.max(r7, (r0.getIntrinsicHeight() + getPaddingTop()) + getPaddingBottom());
    L6:
        setMeasuredDimension(r6, r7);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }

    @Override // android.widget.TextView, android.view.View
    public void setSelected(boolean r2) {
        super.setSelected(r2);
        OUIAlphaHelper r0 = this.mAlphaHelper;
        if (r0 == null) goto L7;
        r0.onSelectedChanged(this, r2);
        return;
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean r3) {
        super.setEnabled(r3);
        OUIAlphaHelper r0 = this.mAlphaHelper;
        if (r0 == null) goto L6;
        r0.onEnabledChanged(this, r3);
    L6:
        updateContentColorForState(r3);
    }

    @Override // android.view.View
    public void setPressed(boolean r2) {
        super.setPressed(r2);
        OUIEffectHelper r0 = this.mOUIEffectHelper;
        if (r0 == null) goto L6;
        r0.setPressed(r2);
    L6:
        OUIAlphaHelper r1 = this.mAlphaHelper;
        if (r1 == null) goto L11;
        r1.onPressedChanged(this, r2);
        return;
    }

    private final void setPressState(boolean r2) {
        if (this.internalPressState != r2) goto L6;
        L.w(TAG, Intrinsics.stringPlus("setPressState, already set, skip! pressed: ", Boolean.valueOf(r2)));
        return;
    L6:
        this.internalPressState = r2;
        OUIEffectHelper r0 = this.mOUIEffectHelper;
        if (r0 == null) goto L10;
        r0.setPressed(r2);
    L10:
        OUIAlphaHelper r1 = this.mAlphaHelper;
        if (r1 == null) goto L15;
        r1.onPressedChanged(this, r2);
        return;
    }

    @Override // com.obric.oui.common.style.IOUILayout
    public void onPressAlphaChange(int r3) {
        if (this.changeAlphaWhenPressed == true) goto L5;
        return;
    L5:
        float r4 = RangesKt.coerceIn(r3 / 255.0f, 0.0f, 1.0f);
        updateTextColorOnPress(r4);
        updateIconAlphaOnPress(r4);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable r1, Drawable r2, Drawable r3, Drawable r4) {
        super.setCompoundDrawables(r1, r2, r3, r4);
        if (r1 == null) goto L5;
        boolean r5 = true;
    L6:
        adjustPaddingLeft(r5);
        return;
    L5:
        r5 = false;
        goto L6
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable r1, Drawable r2, Drawable r3, Drawable r4) {
        super.setCompoundDrawablesRelative(r1, r2, r3, r4);
        if (r1 == null) goto L5;
        boolean r5 = true;
    L6:
        adjustPaddingLeft(r5);
        return;
    L5:
        r5 = false;
        goto L6
    }

    public final void setDisabledTextAlpha(float r1) {
        this.disabledAlpha = r1;
        if (isEnabled() == true) goto L6;
        updateContentColorForState(false);
        return;
    }

    @Override // android.widget.TextView
    public void setTextColor(int r2) {
        if (this.isInternalTextColorChange == true) goto L5;
        this.originTextColor = r2;
    L5:
        super.setTextColor(r2);
    }

    private final void updateContentColorForState(boolean r7) {
        int r0 = this.originTextColor;
        if (r0 != 0) goto L5;
        return;
    L5:
        int r3 = 0;
        if (r7 == true) goto L14;
        int r8 = ViewUtil.applyColorAlphaStrength(r0, this.disabledAlpha);
        this.isInternalTextColorChange = true;
        super.setTextColor(r8);
        this.isInternalTextColorChange = false;
        Drawable[] r9 = getCompoundDrawables();
        Intrinsics.checkNotNullExpressionValue(r9, "compoundDrawables");
        Drawable[] r10 = r9;
        int r1 = r10.length;
    L8:
        if (r3 >= r1) goto L21;
        Drawable r2 = r10[r3];
        if (r2 == null) goto L13;
        r2.setAlpha((int) (this.disabledAlpha * 255));
    L13:
        r3 = r3 + 1;
    L21:
        invalidate();
        return;
    L14:
        this.isInternalTextColorChange = true;
        super.setTextColor(r0);
        this.isInternalTextColorChange = false;
        Drawable[] r11 = getCompoundDrawables();
        Intrinsics.checkNotNullExpressionValue(r11, "compoundDrawables");
        Drawable[] r12 = r11;
        int r4 = r12.length;
    L15:
        if (r3 >= r4) goto L21;
        Drawable r5 = r12[r3];
        if (r5 == null) goto L20;
        r5.setAlpha(255);
    L20:
        r3 = r3 + 1;
        goto L15
    }

    private final void adjustPaddingLeft(boolean r5) {
        int r0 = getPaddingTop();
        int r1 = getPaddingRight();
        int r2 = getPaddingBottom();
        if (r5 == false) goto L5;
        int r6 = getPaddingRight() - this.customPaddingOffset;
    L7:
        if (r6 == getPaddingLeft()) goto L10;
        setPadding(r6, r0, r1, r2);
        return;
    L10:
        return;
    L5:
        r6 = getPaddingRight();
        goto L7
    }

    private final void updateTextColorOnPress(float r8) {
        int r0 = this.originTextColor;
        if (r0 != 0) goto L5;
        return;
    L5:
        int r1 = (r0 >> 24) & 255;
        int r2 = RangesKt.coerceIn((int) (r1 * getAnimatedPressAlpha(r8)), 0, 255);
        int r3 = ((r0 >> 16) & 255) << 16;
        setTextColor((r0 & 255) | ((r3 | (r2 << 24)) | (((r0 >> 8) & 255) << 8)));
        L.d(TAG, "updateTextColorOnPress, fraction: " + r8 + ", newTextAlpha: " + r2 + ", originTextAlpha: " + r1);
    }

    private final void updateIconAlphaOnPress(float r4) {
        int r0 = this.originIconAlpha;
        if (r0 != 0) goto L5;
        return;
    L5:
        int r1 = RangesKt.coerceIn((int) (r0 * getAnimatedPressAlpha(r4)), 0, 255);
        Drawable r2 = this.mIcon;
        if (r2 == null) goto L9;
        r2.setAlpha(r1);
    L9:
        L.d(TAG, "updateIconAlphaOnPress, fraction: " + r4 + ", alpha: " + r1 + ", originIconAlpha: " + this.originIconAlpha);
    }
}
