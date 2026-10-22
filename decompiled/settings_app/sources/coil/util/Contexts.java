package coil.util;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.monitor.cloudmessage.consts.CloudControlInf;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: renamed from: coil.util.-Contexts, reason: invalid class name */
/* JADX INFO: compiled from: Contexts.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0004H\u0000\u001a$\u0010\u0000\u001a\u00020\u0001*\u00020\u00052\b\b\u0001\u0010\u0003\u001a\u00020\u00042\f\u0010\u0006\u001a\b\u0018\u00010\u0007R\u00020\u0005H\u0000\u001a\u0010\u0010\b\u001a\u0004\u0018\u00010\t*\u0004\u0018\u00010\u0002H\u0000\u001a\u001e\u0010\n\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00052\b\b\u0001\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\u0014\u0010\f\u001a\u00020\r*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000fH\u0000\u001a\u001e\u0010\u0010\u001a\u0002H\u0011\"\n\b\u0000\u0010\u0011\u0018\u0001*\u00020\u0012*\u00020\u0002H\u0080\b¢\u0006\u0002\u0010\u0013¨\u0006\u0014"}, d2 = {"getDrawableCompat", "Landroid/graphics/drawable/Drawable;", "Landroid/content/Context;", "resId", "", "Landroid/content/res/Resources;", "theme", "Landroid/content/res/Resources$Theme;", "getLifecycle", "Landroidx/lifecycle/Lifecycle;", "getXmlDrawableCompat", "resources", "isPermissionGranted", "", CloudControlInf.PERMISSION, "", "requireSystemService", ExifInterface.GPS_DIRECTION_TRUE, "", "(Landroid/content/Context;)Ljava/lang/Object;", "coil-base_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class Contexts {
    public static final Drawable getDrawableCompat(Context r1, int r2) {
        Drawable r3 = AppCompatResources.getDrawable(r1, r2);
        if (r3 == null) goto L6;
        return r3;
    L6:
        throw new IllegalStateException(("Invalid resource ID: " + r2).toString());
    }

    public static final Drawable getDrawableCompat(Resources r0, int r1, Resources.Theme r2) {
        Drawable r3 = ResourcesCompat.getDrawable(r0, r1, r2);
        if (r3 == null) goto L6;
        return r3;
    L6:
        throw new IllegalStateException(("Invalid resource ID: " + r1).toString());
    }

    public static final Drawable getXmlDrawableCompat(Context r4, Resources r5, int r6) {
        XmlResourceParser r0 = r5.getXml(r6);
        int r1 = r0.next();
    L4:
        if (r1 == 2) goto L8;
        if (r1 == 1) goto L8;
        r1 = r0.next();
    L8:
        if (r1 != 2) goto L12;
        return getDrawableCompat(r5, r6, r4.getTheme());
    L12:
        throw new XmlPullParserException("No start tag found.");
    }

    public static final Lifecycle getLifecycle(Context r1) {
    L3:
        if ((r1 instanceof LifecycleOwner) == true) goto L5;
        if ((r1 instanceof ContextWrapper) == false) goto L8;
        Object r2 = ((ContextWrapper) r2).getBaseContext();
        goto L3
    L8:
        return null;
    L5:
        return ((LifecycleOwner) r2).getLifecycle();
    }

    public static final boolean isPermissionGranted(Context r0, String r1) {
        if (ContextCompat.checkSelfPermission(r0, r1) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final /* synthetic */ <T> T requireSystemService(Context r2) {
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        T r3 = (T) ContextCompat.getSystemService(r2, Object.class);
        Intrinsics.checkNotNull(r3);
        return r3;
    }
}
