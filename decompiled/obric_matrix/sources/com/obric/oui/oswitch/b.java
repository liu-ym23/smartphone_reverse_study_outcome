package com.obric.oui.oswitch;

import android.R;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.Property;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.PathInterpolator;
import android.widget.CompoundButton;
import androidx.annotation.CallSuper;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.text.AllCapsTransformationMethod;
import androidx.appcompat.widget.DrawableUtils;
import androidx.appcompat.widget.TintTypedArray;
import androidx.appcompat.widget.ViewUtils;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.n0.d.g;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b4\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0017\u0018\u0000 \u0099\u00022\u00020\u0001:\u0001eB.\b\u0007\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\f\b\u0002\u0010\u0095\u0002\u001a\u0005\u0018\u00010\u0094\u0002\u0012\t\b\u0002\u0010\u0096\u0002\u001a\u00020\u0004¢\u0006\u0006\b\u0097\u0002\u0010\u0098\u0002J\u001f\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0004¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0004¢\u0006\u0004\b\u0014\u0010\u0013J\u001f\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010 \u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b \u0010!J\u0015\u0010$\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\"¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\u0006H\u0016¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\u001fH\u0016¢\u0006\u0004\b(\u0010)J\u0017\u0010+\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u001fH\u0016¢\u0006\u0004\b+\u0010,J\u0017\u0010-\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u001fH\u0016¢\u0006\u0004\b-\u0010,J\u0017\u0010.\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u001fH\u0017¢\u0006\u0004\b.\u0010,J7\u00104\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u001f2\u0006\u00100\u001a\u00020\u00042\u0006\u00101\u001a\u00020\u00042\u0006\u00102\u001a\u00020\u00042\u0006\u00103\u001a\u00020\u0004H\u0014¢\u0006\u0004\b4\u00105J\u0017\u00108\u001a\u00020\u00062\u0006\u00107\u001a\u000206H\u0016¢\u0006\u0004\b8\u00109J\u0017\u0010;\u001a\u00020\u00062\u0006\u0010:\u001a\u000206H\u0014¢\u0006\u0004\b;\u00109J\u000f\u0010<\u001a\u00020\u0004H\u0016¢\u0006\u0004\b<\u0010=J\u000f\u0010>\u001a\u00020\u0004H\u0016¢\u0006\u0004\b>\u0010=J\u0017\u0010A\u001a\u00020@2\u0006\u0010?\u001a\u00020\u0004H\u0014¢\u0006\u0004\bA\u0010BJ\u000f\u0010C\u001a\u00020\u0006H\u0014¢\u0006\u0004\bC\u0010'J\u001f\u0010F\u001a\u00020\u00062\u0006\u0010D\u001a\u00020\"2\u0006\u0010E\u001a\u00020\"H\u0016¢\u0006\u0004\bF\u0010GJ\u0017\u0010J\u001a\u00020\u001f2\u0006\u0010I\u001a\u00020HH\u0014¢\u0006\u0004\bJ\u0010KJ\u000f\u0010L\u001a\u00020\u0006H\u0016¢\u0006\u0004\bL\u0010'J\u0017\u0010M\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\bM\u0010\u001cJ\u0017\u0010P\u001a\u00020\u00062\u0006\u0010O\u001a\u00020NH\u0016¢\u0006\u0004\bP\u0010QJ\u0017\u0010T\u001a\u00020\u00062\u0006\u0010S\u001a\u00020RH\u0016¢\u0006\u0004\bT\u0010UJ\u001f\u0010X\u001a\u00020\u00062\u0006\u0010V\u001a\u00020\u00042\u0006\u0010W\u001a\u00020\u0004H\u0002¢\u0006\u0004\bX\u0010\u0018J\u000f\u0010Y\u001a\u00020\u0006H\u0002¢\u0006\u0004\bY\u0010'J\u000f\u00107\u001a\u00020\u0006H\u0002¢\u0006\u0004\b7\u0010'J\u001b\u0010]\u001a\u0004\u0018\u00010\\2\b\u0010[\u001a\u0004\u0018\u00010ZH\u0002¢\u0006\u0004\b]\u0010^J\u001f\u0010_\u001a\u00020\u001f2\u0006\u0010D\u001a\u00020\"2\u0006\u0010E\u001a\u00020\"H\u0002¢\u0006\u0004\b_\u0010`J\u0017\u0010a\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\ba\u0010bJ\u0017\u0010c\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\bc\u0010bJ\u0017\u0010e\u001a\u00020\u00062\u0006\u0010d\u001a\u00020\u001fH\u0002¢\u0006\u0004\be\u0010,J\u000f\u0010f\u001a\u00020\u0006H\u0002¢\u0006\u0004\bf\u0010'R\u0016\u0010i\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bg\u0010hR\u0016\u0010l\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bj\u0010kR\u0016\u0010n\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bm\u0010kR\u0016\u0010o\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010hR$\u0010s\u001a\u00020\u00042\u0006\u0010p\u001a\u00020\u00048F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bq\u0010=\"\u0004\br\u0010\u0013R\u0018\u0010u\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010tR\u0016\u0010v\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bk\u0010kR\u0016\u0010w\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bh\u0010kR\u0018\u0010{\u001a\u0004\u0018\u00010x8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\by\u0010zR\u0016\u0010}\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010|R\u0016\u0010\u007f\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b~\u0010kR(\u0010\u0080\u0001\u001a\u00020\u001f2\u0007\u0010\u0080\u0001\u001a\u00020\u001f8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u0081\u0001\u0010)\"\u0005\b\u0082\u0001\u0010,R\u001b\u0010\u0085\u0001\u001a\u0004\u0018\u00010\\8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0083\u0001\u0010\u0084\u0001R(\u0010\u0089\u0001\u001a\u00020\u00042\u0007\u0010\u0086\u0001\u001a\u00020\u00048F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u0087\u0001\u0010=\"\u0005\b\u0088\u0001\u0010\u0013R\u0018\u0010\u008b\u0001\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u008a\u0001\u0010kR\u001b\u0010\u008e\u0001\u001a\u0005\u0018\u00010\u008c\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b]\u0010\u008d\u0001R'\u0010\u0091\u0001\u001a\u00020\u00042\u0006\u0010p\u001a\u00020\u00048F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u008f\u0001\u0010=\"\u0005\b\u0090\u0001\u0010\u0013R\u0019\u0010\u0092\u0001\u001a\u0004\u0018\u00010x8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010zR(\u0010\u0095\u0001\u001a\u00020\u00042\u0007\u0010\u0086\u0001\u001a\u00020\u00048F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u0093\u0001\u0010=\"\u0005\b\u0094\u0001\u0010\u0013R\u0018\u0010\u0097\u0001\u001a\u00020\u001f8B@\u0002X\u0082\u0004¢\u0006\u0007\u001a\u0005\b\u0096\u0001\u0010)R\u0018\u0010\u0099\u0001\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0098\u0001\u0010kR\u001a\u0010\u009d\u0001\u001a\u00030\u009a\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u009b\u0001\u0010\u009c\u0001R\u0019\u0010\u009e\u0001\u001a\u0004\u0018\u00010x8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u0010zR\u0018\u0010 \u0001\u001a\u00020\u00048\u0002@\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u009f\u0001\u0010kR.\u0010¦\u0001\u001a\u0004\u0018\u00010H2\t\u0010¡\u0001\u001a\u0004\u0018\u00010H8F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\b¢\u0001\u0010£\u0001\"\u0006\b¤\u0001\u0010¥\u0001R(\u0010§\u0001\u001a\u00020\u001f2\u0007\u0010§\u0001\u001a\u00020\u001f8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b¨\u0001\u0010)\"\u0005\b©\u0001\u0010,R\u001b\u0010¬\u0001\u001a\u0004\u0018\u00010Z8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bª\u0001\u0010«\u0001R\u001c\u0010°\u0001\u001a\u0005\u0018\u00010\u00ad\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b®\u0001\u0010¯\u0001R\u001b\u0010²\u0001\u001a\u0004\u0018\u00010Z8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b±\u0001\u0010«\u0001R\u0017\u0010³\u0001\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010|R$\u0010¸\u0001\u001a\r µ\u0001*\u0005\u0018\u00010´\u00010´\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¶\u0001\u0010·\u0001R\u001a\u0010¼\u0001\u001a\u00030¹\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\bº\u0001\u0010»\u0001R0\u0010Â\u0001\u001a\u0005\u0018\u00010\u008c\u00012\n\u0010½\u0001\u001a\u0005\u0018\u00010\u008c\u00018F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\b¾\u0001\u0010¿\u0001\"\u0006\bÀ\u0001\u0010Á\u0001R\u0019\u0010Ã\u0001\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\ba\u0010tR\u0018\u0010Å\u0001\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bÄ\u0001\u0010|R\u0018\u0010Ç\u0001\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bÆ\u0001\u0010|R\u0018\u0010É\u0001\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bÈ\u0001\u0010kR.\u0010Ê\u0001\u001a\u0004\u0018\u00010Z2\t\u0010Ê\u0001\u001a\u0004\u0018\u00010Z8F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\bË\u0001\u0010Ì\u0001\"\u0006\bÍ\u0001\u0010Î\u0001R\u0018\u0010Ð\u0001\u001a\u00020\u00048B@\u0002X\u0082\u0004¢\u0006\u0007\u001a\u0005\bÏ\u0001\u0010=R.\u0010Ô\u0001\u001a\u0004\u0018\u00010H2\t\u0010Ñ\u0001\u001a\u0004\u0018\u00010H8F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\bÒ\u0001\u0010£\u0001\"\u0006\bÓ\u0001\u0010¥\u0001R0\u0010×\u0001\u001a\u0005\u0018\u00010\u008c\u00012\n\u0010½\u0001\u001a\u0005\u0018\u00010\u008c\u00018F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\bÕ\u0001\u0010¿\u0001\"\u0006\bÖ\u0001\u0010Á\u0001R\u0018\u0010Ù\u0001\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bØ\u0001\u0010kR&\u0010Ý\u0001\u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bÚ\u0001\u0010|\u001a\u0005\bÛ\u0001\u0010)\"\u0005\bÜ\u0001\u0010,R\u0018\u0010ß\u0001\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bÞ\u0001\u0010kR\u001b\u0010á\u0001\u001a\u0004\u0018\u00010\\8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bà\u0001\u0010\u0084\u0001R\u0018\u0010ã\u0001\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bâ\u0001\u0010kR\u0018\u0010å\u0001\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bä\u0001\u0010kR\u0018\u0010ç\u0001\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bæ\u0001\u0010hR\u0017\u0010è\u0001\u001a\u00020\u00048\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bD\u0010kR'\u0010í\u0001\u001a\u00020\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0005\bé\u0001\u0010h\u001a\u0006\bê\u0001\u0010ë\u0001\"\u0005\bì\u0001\u0010%R,\u0010õ\u0001\u001a\u0005\u0018\u00010î\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bï\u0001\u0010ð\u0001\u001a\u0006\bñ\u0001\u0010ò\u0001\"\u0006\bó\u0001\u0010ô\u0001R\u001a\u0010ù\u0001\u001a\u00030ö\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b÷\u0001\u0010ø\u0001R\u0018\u0010û\u0001\u001a\u00020\u00048B@\u0002X\u0082\u0004¢\u0006\u0007\u001a\u0005\bú\u0001\u0010=R\u0018\u0010ý\u0001\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bü\u0001\u0010kR\u0018\u0010ÿ\u0001\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bþ\u0001\u0010|R\u0018\u0010\u0081\u0002\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0080\u0002\u0010|R.\u0010\u0087\u0002\u001a\u0004\u0018\u00010x2\t\u0010\u0082\u0002\u001a\u0004\u0018\u00010x8F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\b\u0083\u0002\u0010\u0084\u0002\"\u0006\b\u0085\u0002\u0010\u0086\u0002R\u001b\u0010\u0088\u0002\u001a\u0005\u0018\u00010\u008c\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bc\u0010\u008d\u0001R.\u0010\u0089\u0002\u001a\u0004\u0018\u00010Z2\t\u0010\u0089\u0002\u001a\u0004\u0018\u00010Z8F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\b\u008a\u0002\u0010Ì\u0001\"\u0006\b\u008b\u0002\u0010Î\u0001R.\u0010\u008e\u0002\u001a\u0004\u0018\u00010x2\t\u0010\u0082\u0002\u001a\u0004\u0018\u00010x8F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\b\u008c\u0002\u0010\u0084\u0002\"\u0006\b\u008d\u0002\u0010\u0086\u0002R\u0018\u0010\u0090\u0002\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u008f\u0002\u0010kR(\u0010\u0093\u0002\u001a\u00020\u00042\u0007\u0010\u0086\u0001\u001a\u00020\u00048F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u0091\u0002\u0010=\"\u0005\b\u0092\u0002\u0010\u0013¨\u0006\u009a\u0002"}, d2 = {"Lcom/obric/oui/oswitch/b;", "Landroid/widget/CompoundButton;", "Landroid/content/Context;", "context", "", "resid", "Lkotlin/f0;", "j", "(Landroid/content/Context;I)V", "Landroid/graphics/Typeface;", "tf", "style", "k", "(Landroid/graphics/Typeface;I)V", "typeface", "setSwitchTypeface", "(Landroid/graphics/Typeface;)V", "resId", "setTrackResource", "(I)V", "setThumbResource", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "Landroid/view/accessibility/AccessibilityEvent;", NotificationCompat.CATEGORY_EVENT, "onPopulateAccessibilityEvent", "(Landroid/view/accessibility/AccessibilityEvent;)V", "Landroid/view/MotionEvent;", "ev", "", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "", "position", "setThumbPosition", "(F)V", "toggle", "()V", "performClick", "()Z", "checked", "i", "(Z)V", "setChecked", "setCheckedNoAnim", "changed", "left", "top", "right", "bottom", "onLayout", "(ZIIII)V", "Landroid/graphics/Canvas;", "c", "draw", "(Landroid/graphics/Canvas;)V", "canvas", "onDraw", "getCompoundPaddingLeft", "()I", "getCompoundPaddingRight", "extraSpace", "", "onCreateDrawableState", "(I)[I", "drawableStateChanged", "x", "y", "drawableHotspotChanged", "(FF)V", "Landroid/graphics/drawable/Drawable;", "who", "verifyDrawable", "(Landroid/graphics/drawable/Drawable;)Z", "jumpDrawablesToCurrentState", "onInitializeAccessibilityEvent", "Landroid/view/accessibility/AccessibilityNodeInfo;", LocationMonitorConst.INFO, "onInitializeAccessibilityNodeInfo", "(Landroid/view/accessibility/AccessibilityNodeInfo;)V", "Landroid/view/ActionMode$Callback;", "actionModeCallback", "setCustomSelectionActionModeCallback", "(Landroid/view/ActionMode$Callback;)V", "typefaceIndex", "styleIndex", "l", "d", "", "text", "Landroid/text/Layout;", "h", "(Ljava/lang/CharSequence;)Landroid/text/Layout;", "g", "(FF)Z", "f", "(Landroid/view/MotionEvent;)V", "m", "newCheckedState", "b", "e", "W", "F", "mThumbDragPosition", "E", "I", "mSwitchHeight", "K", "mSwitchBottom", "mTouchX", "value", "getThumbConstraintLeft", "setThumbConstraintLeft", "thumbConstraintLeft", "Landroid/graphics/drawable/Drawable;", "mTrackDrawable", "mSwitchTop", "mThumbWidth", "Landroid/content/res/ColorStateList;", "M", "Landroid/content/res/ColorStateList;", "mTextColors", "Z", "mHasThumbTintMode", "S", "mThumbConstraintLeft", "showText", "getShowText", "setShowText", "O", "Landroid/text/Layout;", "mOffLayout", "pixels", "getThumbTextPadding", "setThumbTextPadding", "thumbTextPadding", "w", "mTouchMode", "Landroid/graphics/PorterDuff$Mode;", "Landroid/graphics/PorterDuff$Mode;", "mThumbTintMode", "getThumbConstraintRight", "setThumbConstraintRight", "thumbConstraintRight", "mThumbTintList", "getSwitchMinWidth", "setSwitchMinWidth", "switchMinWidth", "getTargetCheckedState", "targetCheckedState", "p", "mThumbTextPadding", "Landroid/text/TextPaint;", "L", "Landroid/text/TextPaint;", "mTextPaint", "mTrackTintList", "B", "mMinFlingVelocity", "track", "getTrackDrawable", "()Landroid/graphics/drawable/Drawable;", "setTrackDrawable", "(Landroid/graphics/drawable/Drawable;)V", "trackDrawable", "splitTrack", "getSplitTrack", "setSplitTrack", "t", "Ljava/lang/CharSequence;", "mTextOn", "Landroid/text/method/TransformationMethod;", "P", "Landroid/text/method/TransformationMethod;", "mSwitchTransformationMethod", "u", "mTextOff", "mHasThumbTint", "Landroid/view/VelocityTracker;", "kotlin.jvm.PlatformType", "A", "Landroid/view/VelocityTracker;", "mVelocityTracker", "Landroid/view/animation/PathInterpolator;", "V", "Landroid/view/animation/PathInterpolator;", "thumbAnimInterpolator", "tintMode", "getThumbTintMode", "()Landroid/graphics/PorterDuff$Mode;", "setThumbTintMode", "(Landroid/graphics/PorterDuff$Mode;)V", "thumbTintMode", "mThumbDrawable", "n", "mHasTrackTint", "s", "mSplitTrack", "G", "mThumbHeight", "textOff", "getTextOff", "()Ljava/lang/CharSequence;", "setTextOff", "(Ljava/lang/CharSequence;)V", "getThumbOffset", "thumbOffset", "thumb", "getThumbDrawable", "setThumbDrawable", "thumbDrawable", "getTrackTintMode", "setTrackTintMode", "trackTintMode", "r", "mSwitchPadding", "U", "getAutoCheck", "setAutoCheck", "autoCheck", "H", "mSwitchLeft", "N", "mOnLayout", "J", "mSwitchRight", "T", "mThumbConstraintRight", "z", "mTouchY", "mTouchSlop", "C", "getMThumbPosition", "()F", "setMThumbPosition", "mThumbPosition", "Landroid/animation/ObjectAnimator;", "Q", "Landroid/animation/ObjectAnimator;", "getMPositionAnimator", "()Landroid/animation/ObjectAnimator;", "setMPositionAnimator", "(Landroid/animation/ObjectAnimator;)V", "mPositionAnimator", "Landroid/graphics/Rect;", "R", "Landroid/graphics/Rect;", "mTempRect", "getThumbScrollRange", "thumbScrollRange", "D", "mSwitchWidth", "o", "mHasTrackTintMode", BaseSwitches.V, "mShowText", "tint", "getThumbTintList", "()Landroid/content/res/ColorStateList;", "setThumbTintList", "(Landroid/content/res/ColorStateList;)V", "thumbTintList", "mTrackTintMode", "textOn", "getTextOn", "setTextOn", "getTrackTintList", "setTrackTintList", "trackTintList", "q", "mSwitchMinWidth", "getSwitchPadding", "setSwitchPadding", "switchPadding", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "c0", "OUI_standardRelease"}, k = 1, mv = {1, 1, 15})
@SuppressLint({"RestrictedApi"})
public class b extends CompoundButton {
    private static final Property<b, Float> a0 = null;
    private static final int[] b0 = null;
    public static final C0292b c0 = null;
    private final VelocityTracker A;
    private final int B;
    private float C;
    private int D;
    private int E;
    private int F;
    private int G;
    private int H;
    private int I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private int f11146J;
    private int K;
    private final TextPaint L;
    private ColorStateList M;
    private Layout N;
    private Layout O;
    private TransformationMethod P;
    private ObjectAnimator Q;
    private final Rect R;
    private int S;
    private int T;
    private boolean U;
    private final PathInterpolator V;
    private float W;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Drawable f11147f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ColorStateList f11148g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private PorterDuff.Mode f11149h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f11150i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f11151j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Drawable f11152k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private ColorStateList f11153l;
    private PorterDuff.Mode m;
    private boolean n;
    private boolean o;
    private int p;
    private int q;
    private int r;
    private boolean s;
    private CharSequence t;
    private CharSequence u;
    private boolean v;
    private int w;
    private final int x;
    private float y;
    private float z;

    public static final class a extends Property<b, Float> {
        a(Class r1, String r2) {
            super(r1, r2);
        }

        public Float a(b r1) {
            o.f(r1, "object");
            return Float.valueOf(r1.getMThumbPosition());
        }

        public void b(b r1, float r2) {
            o.f(r1, "object");
            r1.setThumbPosition(r2);
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ Float get(b r1) {
            return a(r1);
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ void set(b r1, Float r2) {
            b(r1, r2.floatValue());
        }
    }

    /* JADX INFO: renamed from: com.obric.oui.oswitch.b$b, reason: collision with other inner class name */
    public static final class C0292b {
        private C0292b() {
        }

        public /* synthetic */ C0292b(g r1) {
            this();
        }

        public static final /* synthetic */ float a(C0292b r0, float r1, float r2, float r3) {
            return r0.b(r1, r2, r3);
        }

        private final float b(float r1, float r2, float r3) {
            if (r1 >= r2) goto L6;
            return r2;
        L6:
            if (r1 > r3) goto L8;
            return r1;
        L8:
            return r3;
        }
    }

    static {
        c0 = new C0292b(null);
        a0 = new a(Float.TYPE, "thumbPos");
        b0 = new int[]{R.attr.state_checked};
    }

    public b(Context r7, AttributeSet r8) {
        this(r7, r8, 0, 4, null);
    }

    public b(Context r7, AttributeSet r8, int r9) {
        super(r7, r8, r9);
        this.A = VelocityTracker.obtain();
        this.R = new Rect();
        this.U = true;
        this.V = new PathInterpolator(0.33f, 1.3f, 0.15f, 1.0f);
        TextPaint r1 = new TextPaint(1);
        this.L = r1;
        Resources r2 = getResources();
        o.e(r2, "res");
        r1.density = r2.getDisplayMetrics().density;
        TintTypedArray r10 = TintTypedArray.obtainStyledAttributes(r7, r8, androidx.appcompat.R.styleable.SwitchCompat, r9, 0);
        Drawable r11 = r10.getDrawable(androidx.appcompat.R.styleable.SwitchCompat_android_thumb);
        this.f11147f = r11;
        if (r11 == null) goto L5;
        o.c(r11);
        r11.setCallback(this);
    L5:
        Drawable r12 = r10.getDrawable(androidx.appcompat.R.styleable.SwitchCompat_track);
        this.f11152k = r12;
        if (r12 == null) goto L8;
        o.c(r12);
        r12.setCallback(this);
    L8:
        this.t = r10.getText(androidx.appcompat.R.styleable.SwitchCompat_android_textOn);
        this.u = r10.getText(androidx.appcompat.R.styleable.SwitchCompat_android_textOff);
        this.v = false;
        this.p = r10.getDimensionPixelSize(androidx.appcompat.R.styleable.SwitchCompat_thumbTextPadding, 0);
        this.q = r10.getDimensionPixelSize(androidx.appcompat.R.styleable.SwitchCompat_switchMinWidth, 0);
        this.r = r10.getDimensionPixelSize(androidx.appcompat.R.styleable.SwitchCompat_switchPadding, 0);
        this.s = r10.getBoolean(androidx.appcompat.R.styleable.SwitchCompat_splitTrack, false);
        ColorStateList r13 = r10.getColorStateList(androidx.appcompat.R.styleable.SwitchCompat_thumbTint);
        if (r13 == null) goto L11;
        this.f11148g = r13;
        this.f11150i = true;
    L11:
        PorterDuff.Mode r14 = DrawableUtils.parseTintMode(r10.getInt(androidx.appcompat.R.styleable.SwitchCompat_thumbTintMode, -1), null);
        if (this.f11149h == r14) goto L15;
        this.f11149h = r14;
        this.f11151j = true;
    L15:
        if (this.f11150i == false) goto L17;
    L18:
        c();
    L19:
        ColorStateList r15 = r10.getColorStateList(androidx.appcompat.R.styleable.SwitchCompat_trackTint);
        if (r15 == null) goto L22;
        this.f11153l = r15;
        this.n = true;
    L22:
        PorterDuff.Mode r16 = DrawableUtils.parseTintMode(r10.getInt(androidx.appcompat.R.styleable.SwitchCompat_trackTintMode, -1), null);
        if (this.m == r16) goto L26;
        this.m = r16;
        this.o = true;
    L26:
        if (this.n == false) goto L28;
    L29:
        d();
    L30:
        int r17 = r10.getResourceId(androidx.appcompat.R.styleable.SwitchCompat_switchTextAppearance, 0);
        if (r17 == 0) goto L33;
        j(r7, r17);
    L33:
        r10.recycle();
        if (r7 == null) goto L36;
        ViewConfiguration r18 = ViewConfiguration.get(r7);
        o.e(r18, "config");
        this.x = r18.getScaledTouchSlop();
        this.B = r18.getScaledMinimumFlingVelocity();
    L37:
        refreshDrawableState();
        setChecked(isChecked());
        return;
    L36:
        this.x = 0;
        this.B = 0;
        goto L37
    L28:
        if (this.o == false) goto L30;
    L17:
        if (this.f11151j == false) goto L19;
        goto L18
    }

    public /* synthetic */ b(Context r1, AttributeSet r2, int r3, int r4, g r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = androidx.appcompat.R.attr.switchStyle;
    L8:
        this(r1, r2, r3);
    }

    public static final /* synthetic */ int[] a(int[] r0, int[] r1) {
        return View.mergeDrawableStates(r0, r1);
    }

    private final void b(boolean r5) {
        if (r5 == false) goto L5;
        float r6 = 1.0f;
    L6:
        ObjectAnimator r7 = ObjectAnimator.ofFloat(this, a0, new float[]{r6});
        this.Q = r7;
        if (r7 == null) goto L10;
        r7.setDuration(443);
    L10:
        if (Build.VERSION.SDK_INT < 18) goto L14;
        ObjectAnimator r8 = this.Q;
        if (r8 == null) goto L14;
        r8.setAutoCancel(true);
    L14:
        ObjectAnimator r9 = this.Q;
        if (r9 == null) goto L17;
        r9.setInterpolator(this.V);
    L17:
        ObjectAnimator r4 = this.Q;
        if (r4 == null) goto L21;
        r4.start();
        return;
    L21:
        return;
    L5:
        r6 = 0;
        goto L6
    }

    private final void c() {
        Drawable r0 = this.f11147f;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.f11150i == false) goto L7;
    L8:
        o.c(r0);
        Drawable r1 = r0.mutate();
        this.f11147f = r1;
        if (this.f11150i == false) goto L12;
        o.c(r1);
        DrawableCompat.setTintList(r1, this.f11148g);
    L12:
        if (this.f11151j == false) goto L14;
        Drawable r2 = this.f11147f;
        o.c(r2);
        PorterDuff.Mode r3 = this.f11149h;
        o.c(r3);
        DrawableCompat.setTintMode(r2, r3);
    L14:
        Drawable r4 = this.f11147f;
        o.c(r4);
        if (r4.isStateful() == false) goto L20;
        Drawable r5 = this.f11147f;
        o.c(r5);
        r5.setState(getDrawableState());
        return;
    L20:
        return;
    L7:
        if (this.f11151j == true) goto L8;
    }

    private final void d() {
        Drawable r0 = this.f11152k;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.n == false) goto L7;
    L8:
        o.c(r0);
        Drawable r1 = r0.mutate();
        this.f11152k = r1;
        if (this.n == false) goto L12;
        o.c(r1);
        DrawableCompat.setTintList(r1, this.f11153l);
    L12:
        if (this.o == false) goto L14;
        Drawable r2 = this.f11152k;
        o.c(r2);
        PorterDuff.Mode r3 = this.m;
        o.c(r3);
        DrawableCompat.setTintMode(r2, r3);
    L14:
        Drawable r4 = this.f11152k;
        o.c(r4);
        if (r4.isStateful() == false) goto L20;
        Drawable r5 = this.f11152k;
        o.c(r5);
        r5.setState(getDrawableState());
        return;
    L20:
        return;
    L7:
        if (this.o == true) goto L8;
    }

    private final void e() {
        ObjectAnimator r0 = this.Q;
        if (r0 == null) goto L6;
        o.c(r0);
        r0.cancel();
        return;
    }

    private final void f(MotionEvent r2) {
        MotionEvent r3 = MotionEvent.obtain(r2);
        o.e(r3, "cancel");
        r3.setAction(3);
        super.onTouchEvent(r3);
        r3.recycle();
    }

    private final boolean g(float r8, float r9) {
        if (this.f11147f != null) goto L5;
        return false;
    L5:
        int r0 = getThumbOffset();
        Drawable r2 = this.f11147f;
        o.c(r2);
        r2.getPadding(this.R);
        int r3 = this.I;
        int r4 = this.x;
        int r5 = r3 - r4;
        int r6 = (this.H + r0) - r4;
        int r1 = this.F + r6;
        Rect r7 = this.R;
        int r10 = ((r1 + r7.left) + r7.right) + r4;
        int r11 = this.K + r4;
        if (r8 > r6) goto L8;
        return false;
    L8:
        if (r8 < r10) goto L10;
        return false;
    L10:
        if (r9 > r5) goto L12;
        return false;
    L12:
        if (r9 >= r11) goto L18;
        return true;
    L18:
        return false;
    }

    private final boolean getTargetCheckedState() {
        if (this.W <= 0.5f) goto L5;
        return true;
    L5:
        return false;
    }

    private final int getThumbOffset() {
        if (ViewUtils.isLayoutRtl(this) == false) goto L5;
        float r0 = 1 - this.C;
    L7:
        return (int) ((r0 * getThumbScrollRange()) + 0.5f);
    L5:
        r0 = this.C;
        goto L7
    }

    private final int getThumbScrollRange() {
        Drawable r0 = this.f11152k;
        if (r0 == null) goto L9;
        Rect r1 = this.R;
        o.c(r0);
        r0.getPadding(r1);
        Drawable r2 = this.f11147f;
        if (r2 == null) goto L7;
        Rect r3 = DrawableUtils.getOpticalBounds(r2);
        String r4 = "DrawableUtils.getOpticalBounds(mThumbDrawable)";
    L8:
        o.e(r3, r4);
        return ((((((this.D - this.F) - r1.left) - r1.right) - r3.left) - r3.right) - this.T) - this.S;
    L7:
        r3 = DrawableUtils.INSETS_NONE;
        r4 = "DrawableUtils.INSETS_NONE";
        goto L8
    L9:
        return 0;
    }

    private final Layout h(CharSequence r9) {
        if (r9 != null) goto L5;
        return null;
    L5:
        TransformationMethod r0 = this.P;
        if (r0 == null) goto L8;
        o.c(r0);
        r9 = r0.getTransformation(r9, this);
    L8:
        CharSequence r1 = r9;
        TextPaint r2 = this.L;
        if (r1 == null) goto L11;
        int r8 = (int) Math.ceil(Layout.getDesiredWidth(r1, r2));
    L13:
        return new StaticLayout(r1, r2, r8, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
    L11:
        r8 = 0;
        goto L13
    }

    private final void l(int r2, int r3) {
        if (r2 != 1) goto L5;
        Typeface r4 = Typeface.SANS_SERIF;
    L12:
        k(r4, r3);
        return;
    L5:
        if (r2 != 2) goto L7;
        r4 = Typeface.SERIF;
        goto L12
    L7:
        if (r2 == 3) goto L9;
        r4 = null;
        goto L12
    L9:
        r4 = Typeface.MONOSPACE;
        goto L12
    }

    private final void m(MotionEvent r7) {
        this.w = 0;
        boolean r2 = true;
        if (r7.getAction() == 1) goto L5;
    L7:
        boolean r1 = false;
    L8:
        boolean r3 = isChecked();
        if (r1 == false) goto L22;
        this.A.computeCurrentVelocity(1000);
        VelocityTracker r4 = this.A;
        o.e(r4, "mVelocityTracker");
        float r5 = r4.getXVelocity();
        if (Math.abs(r5) > this.B) goto L13;
        r2 = getTargetCheckedState();
    L23:
        if (r2 == r3) goto L25;
        playSoundEffect(0);
    L25:
        setChecked(r2);
        f(r7);
        return;
    L13:
        if (ViewUtils.isLayoutRtl(this) == false) goto L18;
        if (r5 < 0) goto L23;
    L20:
        r2 = false;
        goto L23
    L18:
        if (r5 <= 0) goto L20;
    L22:
        r2 = r3;
        goto L23
    L5:
        if (isEnabled() == false) goto L7;
        r1 = true;
        goto L8
    }

    @Override // android.view.View
    public void draw(Canvas r11) {
        o.f(r11, "c");
        Rect r0 = this.R;
        int r1 = this.H;
        int r2 = this.I;
        int r3 = this.f11146J;
        int r4 = this.K;
        int r5 = getThumbOffset() + r1;
        Drawable r6 = this.f11147f;
        if (r6 == null) goto L5;
        Rect r7 = DrawableUtils.getOpticalBounds(r6);
    L6:
        Drawable r8 = this.f11152k;
        if (r8 == null) goto L26;
        o.c(r8);
        r8.getPadding(r0);
        int r9 = r0.left;
        r5 = r5 + r9;
        if (r7 == null) goto L23;
        int r10 = r7.left;
        if (r10 <= r9) goto L13;
        r1 = r1 + (r10 - r9);
    L13:
        int r12 = r7.top;
        int r13 = r0.top;
        if (r12 <= r13) goto L16;
        int r14 = (r12 - r13) + r2;
    L17:
        int r15 = r7.right;
        int r16 = r0.right;
        if (r15 <= r16) goto L20;
        r3 = r3 - (r15 - r16);
    L20:
        int r17 = r7.bottom;
        int r18 = r0.bottom;
        if (r17 <= r18) goto L24;
        int r19 = r4 - (r17 - r18);
    L25:
        Drawable r20 = this.f11152k;
        o.c(r20);
        r20.setBounds(r1, r14, r3, r19);
    L24:
        r19 = r4;
        goto L25
    L16:
        r14 = r2;
        goto L17
    L23:
        r14 = r2;
    L26:
        Drawable r21 = this.f11147f;
        if (r21 == null) goto L31;
        o.c(r21);
        r21.getPadding(r0);
        int r22 = r5 - r0.left;
        int r23 = this.S;
        int r24 = r22 + r23;
        int r25 = ((r5 + this.F) + r0.right) + r23;
        int r26 = ((r4 - r2) - this.G) / 2;
        Drawable r27 = this.f11147f;
        o.c(r27);
        r27.setBounds(r24, r26, r25, this.G + r26);
        Drawable r28 = getBackground();
        if (r28 == null) goto L31;
        DrawableCompat.setHotspotBounds(r28, r24, r2, r25, r4);
    L31:
        super.draw(r11);
        return;
    L5:
        r7 = DrawableUtils.INSETS_NONE;
        goto L6
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableHotspotChanged(float r3, float r4) {
        if (Build.VERSION.SDK_INT < 21) goto L5;
        super.drawableHotspotChanged(r3, r4);
    L5:
        Drawable r0 = this.f11147f;
        if (r0 == null) goto L8;
        o.c(r0);
        DrawableCompat.setHotspot(r0, r3, r4);
    L8:
        Drawable r2 = this.f11152k;
        if (r2 == null) goto L12;
        o.c(r2);
        DrawableCompat.setHotspot(r2, r3, r4);
        return;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] r0 = getDrawableState();
        Drawable r1 = this.f11147f;
        boolean r2 = false;
        if (r1 != null) goto L5;
    L7:
        Drawable r3 = this.f11152k;
        if (r3 != null) goto L10;
    L12:
        if (r2 == false) goto L15;
        invalidate();
        return;
    L15:
        return;
    L10:
        if (r3.isStateful() == false) goto L12;
        r2 = r2 | r3.setState(r0);
        goto L12
    L5:
        if (r1.isStateful() == false) goto L7;
        r2 = false | r1.setState(r0);
        goto L7
    }

    public final boolean getAutoCheck() {
        return this.U;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        if (ViewUtils.isLayoutRtl(this) == false) goto L5;
        int r0 = super.getCompoundPaddingLeft() + this.D;
        if (TextUtils.isEmpty(getText()) == false) goto L9;
        return r0;
    L9:
        return r0 + this.r;
    L5:
        return super.getCompoundPaddingLeft();
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingRight() {
        if (ViewUtils.isLayoutRtl(this) == true) goto L5;
        int r0 = super.getCompoundPaddingRight() + this.D;
        if (TextUtils.isEmpty(getText()) == false) goto L9;
        return r0;
    L9:
        return r0 + this.r;
    L5:
        return super.getCompoundPaddingRight();
    }

    public final ObjectAnimator getMPositionAnimator() {
        return this.Q;
    }

    public final float getMThumbPosition() {
        return this.C;
    }

    public final boolean getShowText() {
        return this.v;
    }

    public final boolean getSplitTrack() {
        return this.s;
    }

    public final int getSwitchMinWidth() {
        return this.q;
    }

    public final int getSwitchPadding() {
        return this.r;
    }

    public final CharSequence getTextOff() {
        return this.u;
    }

    public final CharSequence getTextOn() {
        return this.t;
    }

    public final int getThumbConstraintLeft() {
        return this.S;
    }

    public final int getThumbConstraintRight() {
        return this.T;
    }

    public final Drawable getThumbDrawable() {
        return this.f11147f;
    }

    public final int getThumbTextPadding() {
        return this.p;
    }

    public final ColorStateList getThumbTintList() {
        return this.f11148g;
    }

    public final PorterDuff.Mode getThumbTintMode() {
        return this.f11149h;
    }

    public final Drawable getTrackDrawable() {
        return this.f11152k;
    }

    public final ColorStateList getTrackTintList() {
        return this.f11153l;
    }

    public final PorterDuff.Mode getTrackTintMode() {
        return this.m;
    }

    public void i(boolean r1) {
        Context r0 = getContext();
        if (r1 == false) goto L5;
        int r2 = 4;
    L6:
        d.g.d.d.a.b(r0, r2);
        return;
    L5:
        r2 = 5;
        goto L6
    }

    public final void j(Context r4, int r5) {
        TintTypedArray r6 = TintTypedArray.obtainStyledAttributes(r4, r5, androidx.appcompat.R.styleable.TextAppearance);
        ColorStateList r7 = r6.getColorStateList(androidx.appcompat.R.styleable.TextAppearance_android_textColor);
        if (r7 != null) goto L6;
        r7 = getTextColors();
    L6:
        this.M = r7;
        int r8 = r6.getDimensionPixelSize(androidx.appcompat.R.styleable.TextAppearance_android_textSize, 0);
        if (r8 == 0) goto L11;
        float r9 = r8;
        if (r9 == this.L.getTextSize()) goto L11;
        this.L.setTextSize(r9);
        requestLayout();
    L11:
        l(r6.getInt(androidx.appcompat.R.styleable.TextAppearance_android_typeface, -1), r6.getInt(androidx.appcompat.R.styleable.TextAppearance_android_textStyle, -1));
        if (r6.getBoolean(androidx.appcompat.R.styleable.TextAppearance_textAllCaps, false) == false) goto L14;
        AllCapsTransformationMethod r10 = new AllCapsTransformationMethod(getContext());
    L15:
        this.P = r10;
        r6.recycle();
        return;
    L14:
        r10 = null;
        goto L15
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable r0 = this.f11147f;
        if (r0 == null) goto L5;
        o.c(r0);
        r0.jumpToCurrentState();
    L5:
        Drawable r1 = this.f11152k;
        if (r1 == null) goto L8;
        o.c(r1);
        r1.jumpToCurrentState();
    L8:
        ObjectAnimator r2 = this.Q;
        if (r2 == null) goto L14;
        o.c(r2);
        if (r2.isStarted() == false) goto L15;
        ObjectAnimator r3 = this.Q;
        o.c(r3);
        r3.end();
        this.Q = null;
        return;
    L15:
        return;
    }

    public final void k(Typeface r4, int r5) {
        float r0 = 0.0f;
        boolean r1 = false;
        if (r5 <= 0) goto L18;
        if (r4 != null) goto L6;
        Typeface r6 = Typeface.defaultFromStyle(r5);
    L7:
        setSwitchTypeface(r6);
        if (r6 == null) goto L10;
        int r7 = r6.getStyle();
    L11:
        int r8 = (~r7) & r5;
        TextPaint r9 = this.L;
        if ((r8 & 1) == 0) goto L14;
        r1 = true;
    L14:
        r9.setFakeBoldText(r1);
        TextPaint r3 = this.L;
        if ((r8 & 2) == 0) goto L17;
        r0 = -0.25f;
    L17:
        r3.setTextSkewX(r0);
        return;
    L10:
        r7 = 0;
        goto L11
    L6:
        r6 = Typeface.create(r4, r5);
        goto L7
    L18:
        this.L.setFakeBoldText(false);
        this.L.setTextSkewX(0.0f);
        setSwitchTypeface(r4);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected int[] onCreateDrawableState(int r1) {
        int[] r2 = super.onCreateDrawableState(r1 + 1);
        if (isChecked() == false) goto L5;
        a(r2, b0);
    L5:
        o.e(r2, "drawableState");
        return r2;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas r10) {
        o.f(r10, "canvas");
        super.onDraw(r10);
        Rect r0 = this.R;
        Drawable r1 = this.f11152k;
        if (r1 == null) goto L5;
        r1.getPadding(r0);
    L6:
        int r2 = this.I;
        int r3 = this.K;
        int r4 = r2 + r0.top;
        int r5 = r3 - r0.bottom;
        Drawable r6 = this.f11147f;
        if (r1 != null) goto L9;
    L13:
        int r7 = r10.save();
        if (r6 == null) goto L17;
        r6.draw(r10);
    L17:
        if (getTargetCheckedState() == false) goto L19;
        Layout r8 = this.N;
    L20:
        if (r8 == null) goto L29;
        int[] r9 = getDrawableState();
        ColorStateList r11 = this.M;
        if (r11 == null) goto L24;
        TextPaint r12 = this.L;
        o.c(r11);
        r12.setColor(r11.getColorForState(r9, 0));
    L24:
        this.L.drawableState = r9;
        if (r6 == null) goto L27;
        Rect r13 = r6.getBounds();
        o.e(r13, "thumbDrawable.bounds");
        int r14 = r13.left + r13.right;
    L28:
        r10.translate((r14 / 2) - (r8.getWidth() / 2), ((r4 + r5) / 2) - (r8.getHeight() / 2));
        r8.draw(r10);
        goto L29
    L27:
        r14 = getWidth();
    L29:
        r10.restoreToCount(r7);
        return;
    L19:
        r8 = this.O;
        goto L20
    L9:
        if (this.s == false) goto L12;
        if (r6 == null) goto L12;
        Rect r15 = DrawableUtils.getOpticalBounds(r6);
        r6.copyBounds(r0);
        r0.left += r15.left;
        r0.right -= r15.right;
        int r16 = r10.save();
        r10.clipRect(r0, Region.Op.DIFFERENCE);
        r1.draw(r10);
        r10.restoreToCount(r16);
    L12:
        r1.draw(r10);
        goto L13
    L5:
        r0.setEmpty();
        goto L6
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent r2) {
        o.f(r2, NotificationCompat.CATEGORY_EVENT);
        super.onInitializeAccessibilityEvent(r2);
        r2.setClassName("android.widget.Switch");
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r3) {
        o.f(r3, LocationMonitorConst.INFO);
        super.onInitializeAccessibilityNodeInfo(r3);
        r3.setClassName("android.widget.Switch");
        if (isChecked() == false) goto L5;
        CharSequence r2 = this.t;
    L7:
        if (TextUtils.isEmpty(r2) == true) goto L13;
        CharSequence r0 = r3.getText();
        if (TextUtils.isEmpty(r0) == false) goto L11;
        r3.setText(r2);
        return;
    L11:
        StringBuilder r1 = new StringBuilder();
        r1.append(r0);
        r1.append(' ');
        r1.append(r2);
        r3.setText(r1);
        return;
    L13:
        return;
    L5:
        r2 = this.u;
        goto L7
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        int r6 = 0;
        if (this.f11147f == null) goto L9;
        Rect r7 = this.R;
        Drawable r8 = this.f11152k;
        if (r8 == null) goto L7;
        o.c(r8);
        r8.getPadding(r7);
    L8:
        Rect r9 = DrawableUtils.getOpticalBounds(this.f11147f);
        int r10 = Math.max(0, r9.left - r7.left);
        r6 = Math.max(0, r9.right - r7.right);
    L11:
        if (ViewUtils.isLayoutRtl(this) == false) goto L13;
        int r11 = getPaddingLeft() + r10;
        int r12 = ((this.D + r11) - r10) - r6;
    L14:
        int r13 = getGravity() & 112;
        if (r13 != 16) goto L17;
        int r14 = ((getPaddingTop() + getHeight()) - getPaddingBottom()) / 2;
        int r15 = this.E;
        int r16 = r14 - (r15 / 2);
    L24:
        int r17 = r15 + r16;
    L25:
        this.H = r11;
        this.I = r16;
        this.K = r17;
        this.f11146J = r12;
        return;
    L17:
        if (r13 != 48) goto L19;
    L22:
        r16 = getPaddingTop();
        r15 = this.E;
        goto L24
    L19:
        if (r13 != 80) goto L22;
        r17 = getHeight() - getPaddingBottom();
        r16 = r17 - this.E;
        goto L25
    L13:
        r12 = (getWidth() - getPaddingRight()) - r6;
        r11 = ((r12 - this.D) + r10) + r6;
        goto L14
    L7:
        r7.setEmpty();
        goto L8
    L9:
        r10 = 0;
        goto L11
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int r7, int r8) {
        if (this.v == true) goto L5;
    L10:
        Rect r0 = this.R;
        Drawable r1 = this.f11147f;
        int r2 = 0;
        if (r1 == null) goto L13;
        o.c(r1);
        r1.getPadding(r0);
        Drawable r3 = this.f11147f;
        o.c(r3);
        int r4 = (r3.getIntrinsicWidth() - r0.left) - r0.right;
        Drawable r5 = this.f11147f;
        o.c(r5);
        int r6 = r5.getIntrinsicHeight();
    L15:
        if (this.v == false) goto L25;
        Layout r9 = this.N;
        if (r9 == null) goto L19;
        int r10 = r9.getWidth();
    L20:
        Layout r11 = this.O;
        if (r11 == null) goto L23;
        int r12 = r11.getWidth();
    L24:
        int r13 = Math.max(r10, r12) + (this.p * 2);
    L26:
        this.F = Math.max(r13, r4);
        this.G = r6;
        Drawable r14 = this.f11152k;
        if (r14 == null) goto L29;
        o.c(r14);
        r14.getPadding(r0);
        Drawable r15 = this.f11152k;
        o.c(r15);
        r2 = r15.getIntrinsicHeight();
    L30:
        int r16 = r0.left;
        int r17 = r0.right;
        Drawable r18 = this.f11147f;
        if (r18 == null) goto L33;
        Rect r19 = DrawableUtils.getOpticalBounds(r18);
        r16 = Math.max(r16, r19.left);
        r17 = Math.max(r17, r19.right);
    L33:
        int r20 = Math.max(this.q, ((this.F * 2) + r16) + r17);
        int r21 = Math.max(r2, r6);
        Resources r22 = Resources.getSystem();
        o.e(r22, "Resources.getSystem()");
        this.D = r20 - kotlin.o0.a.a(TypedValue.applyDimension(1, 4, r22.getDisplayMetrics()));
        this.E = r21;
        super.onMeasure(r7, r8);
        if (getMeasuredHeight() >= r21) goto L37;
        setMeasuredDimension(getMeasuredWidthAndState(), r21);
        return;
    L37:
        return;
    L29:
        r0.setEmpty();
        goto L30
    L23:
        r12 = 0;
        goto L24
    L19:
        r10 = 0;
        goto L20
    L25:
        r13 = 0;
        goto L26
    L13:
        r4 = 0;
        r6 = 0;
        goto L15
    L5:
        if (this.N != null) goto L8;
        this.N = h(this.t);
    L8:
        if (this.O != null) goto L10;
        this.O = h(this.u);
        goto L10
    }

    @Override // android.view.View
    public void onPopulateAccessibilityEvent(AccessibilityEvent r2) {
        o.f(r2, NotificationCompat.CATEGORY_EVENT);
        super.onPopulateAccessibilityEvent(r2);
        if (isChecked() == false) goto L5;
        CharSequence r1 = this.t;
    L6:
        if (r1 == null) goto L9;
        r2.getText().add(r1);
        return;
    L9:
        return;
    L5:
        r1 = this.u;
        goto L6
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent r7) {
        o.f(r7, "ev");
        this.A.addMovement(r7);
        int r0 = r7.getActionMasked();
        if (r0 != 0) goto L5;
        float r1 = r7.getX();
        float r2 = r7.getY();
        if (isEnabled() == true) goto L42;
    L45:
        return super.onTouchEvent(r7);
    L42:
        if (g(r1, r2) == false) goto L45;
        this.w = 1;
        this.y = r1;
        this.z = r2;
        goto L45
    L5:
        if (r0 == 1) goto L35;
        if (r0 != 2) goto L8;
        int r3 = this.w;
        if (r3 == 1) goto L28;
        if (r3 != 2) goto L45;
        float r8 = r7.getX();
        int r4 = getThumbScrollRange();
        float r5 = r8 - this.y;
        if (r4 == 0) goto L18;
        float r6 = r5 / r4;
    L22:
        if (ViewUtils.isLayoutRtl(this) == false) goto L24;
        r6 = -r6;
    L24:
        float r9 = C0292b.a(c0, this.W + r6, 0.0f, 1.0f);
        if (r9 == this.W) goto L27;
        this.y = r8;
        this.W = r9;
    L27:
        return true;
    L18:
        if (r5 <= 0) goto L20;
        r6 = 1.0f;
        goto L22
    L20:
        r6 = -1.0f;
        goto L22
    L28:
        float r10 = r7.getX();
        float r11 = r7.getY();
        if (Math.abs(r10 - this.y) <= this.x) goto L31;
    L32:
        this.w = 2;
        getParent().requestDisallowInterceptTouchEvent(true);
        this.y = r10;
        this.z = r11;
        return true;
    L31:
        if (Math.abs(r11 - this.z) <= this.x) goto L45;
    L8:
        if (r0 != 3) goto L45;
    L35:
        if (this.w != 2) goto L38;
        m(r7);
        super.onTouchEvent(r7);
        return true;
    L38:
        this.w = 0;
        this.A.clear();
        goto L45
    }

    @Override // android.widget.CompoundButton, android.view.View
    public boolean performClick() {
        boolean r0 = super.performClick();
        if (isHapticFeedbackEnabled() == false) goto L5;
        i(isChecked());
    L5:
        return r0;
    }

    public final void setAutoCheck(boolean r1) {
        this.U = r1;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean r2) {
        super.setChecked(r2);
        boolean r3 = isChecked();
        if (getWindowToken() != null) goto L5;
    L7:
        e();
        if (r3 == false) goto L10;
        float r4 = 1.0f;
    L11:
        setThumbPosition(r4);
        return;
    L10:
        r4 = 0;
        goto L11
    L5:
        if (ViewCompat.isLaidOut(this) == false) goto L7;
        b(r3);
    }

    @CallSuper
    public void setCheckedNoAnim(boolean r1) {
        super.setChecked(r1);
        e();
        if (isChecked() == false) goto L5;
        float r2 = 1.0f;
    L6:
        setThumbPosition(r2);
        return;
    L5:
        r2 = 0;
        goto L6
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback r2) {
        o.f(r2, "actionModeCallback");
        super.setCustomSelectionActionModeCallback(TextViewCompat.wrapCustomSelectionActionModeCallback(this, r2));
    }

    public final void setMPositionAnimator(ObjectAnimator r1) {
        this.Q = r1;
    }

    public final void setMThumbPosition(float r1) {
        this.C = r1;
    }

    public final void setShowText(boolean r1) {
    }

    public final void setSplitTrack(boolean r1) {
        this.s = r1;
        invalidate();
    }

    public final void setSwitchMinWidth(int r1) {
        this.q = r1;
        requestLayout();
    }

    public final void setSwitchPadding(int r1) {
        this.r = r1;
        requestLayout();
    }

    public final void setSwitchTypeface(Typeface r2) {
        if (this.L.getTypeface() == null) goto L7;
        if ((!o.a(this.L.getTypeface(), r2)) == false) goto L7;
    L9:
        this.L.setTypeface(r2);
        requestLayout();
        invalidate();
        return;
    L7:
        if (this.L.getTypeface() != null) goto L11;
        if (r2 != null) goto L9;
        return;
    }

    public final void setTextOff(CharSequence r1) {
        this.u = r1;
        requestLayout();
    }

    public final void setTextOn(CharSequence r1) {
        this.t = r1;
        requestLayout();
    }

    public final void setThumbConstraintLeft(int r1) {
        this.S = r1;
    }

    public final void setThumbConstraintRight(int r1) {
        this.T = r1;
    }

    public final void setThumbDrawable(Drawable r3) {
        Drawable r0 = this.f11147f;
        if (r0 == null) goto L5;
        o.c(r0);
        r0.setCallback(null);
    L5:
        this.f11147f = r3;
        if (r3 == null) goto L8;
        r3.setCallback(this);
    L8:
        requestLayout();
    }

    public final void setThumbPosition(float r1) {
        this.C = r1;
        invalidate();
    }

    public final void setThumbResource(int r2) {
        setThumbDrawable(AppCompatResources.getDrawable(getContext(), r2));
    }

    public final void setThumbTextPadding(int r1) {
        this.p = r1;
        requestLayout();
    }

    public final void setThumbTintList(ColorStateList r1) {
        this.f11148g = r1;
        this.f11150i = true;
        c();
    }

    public final void setThumbTintMode(PorterDuff.Mode r1) {
        this.f11149h = r1;
        this.f11151j = true;
        c();
    }

    public final void setTrackDrawable(Drawable r3) {
        Drawable r0 = this.f11152k;
        if (r0 == null) goto L5;
        o.c(r0);
        r0.setCallback(null);
    L5:
        this.f11152k = r3;
        if (r3 == null) goto L8;
        r3.setCallback(this);
    L8:
        requestLayout();
    }

    public final void setTrackResource(int r2) {
        setTrackDrawable(AppCompatResources.getDrawable(getContext(), r2));
    }

    public final void setTrackTintList(ColorStateList r1) {
        this.f11153l = r1;
        this.n = true;
        d();
    }

    public final void setTrackTintMode(PorterDuff.Mode r1) {
        this.m = r1;
        this.o = true;
        d();
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void toggle() {
        if (this.U == false) goto L6;
        setChecked(!isChecked());
        return;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected boolean verifyDrawable(Drawable r2) {
        o.f(r2, "who");
        if (super.verifyDrawable(r2) == false) goto L5;
    L10:
        return true;
    L5:
        if (r2 == this.f11147f) goto L10;
        if (r2 == this.f11152k) goto L10;
        return false;
    }
}
