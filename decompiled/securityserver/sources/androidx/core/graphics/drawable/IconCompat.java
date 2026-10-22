package androidx.core.graphics.drawable;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import androidx.versionedparcelable.CustomVersionedParcelable;
import com.bytedance.librarian.LibrarianImpl;
import com.bytedance.networkstackapplib.NetworkStackConstant;
import com.ss.android.http.legacy.protocol.HTTP;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
public class IconCompat extends CustomVersionedParcelable {
    private static final float ADAPTIVE_ICON_INSET_FACTOR = 0.25f;
    private static final int AMBIENT_SHADOW_ALPHA = 30;
    private static final float BLUR_FACTOR = 0.010416667f;
    static final PorterDuff.Mode DEFAULT_TINT_MODE = null;
    private static final float DEFAULT_VIEW_PORT_SCALE = 0.6666667f;
    private static final String EXTRA_INT1 = "int1";
    private static final String EXTRA_INT2 = "int2";
    private static final String EXTRA_OBJ = "obj";
    private static final String EXTRA_TINT_LIST = "tint_list";
    private static final String EXTRA_TINT_MODE = "tint_mode";
    private static final String EXTRA_TYPE = "type";
    private static final float ICON_DIAMETER_FACTOR = 0.9166667f;
    private static final int KEY_SHADOW_ALPHA = 61;
    private static final float KEY_SHADOW_OFFSET_FACTOR = 0.020833334f;
    private static final String TAG = "IconCompat";
    public static final int TYPE_ADAPTIVE_BITMAP = 5;
    public static final int TYPE_BITMAP = 1;
    public static final int TYPE_DATA = 3;
    public static final int TYPE_RESOURCE = 2;
    public static final int TYPE_UNKNOWN = -1;
    public static final int TYPE_URI = 4;
    public static final int TYPE_URI_ADAPTIVE_BITMAP = 6;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public byte[] mData;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int mInt1;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int mInt2;
    Object mObj1;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Parcelable mParcelable;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public ColorStateList mTintList;
    PorterDuff.Mode mTintMode;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public String mTintModeStr;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int mType;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface IconType {
    }

    static {
        DEFAULT_TINT_MODE = PorterDuff.Mode.SRC_IN;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public IconCompat() {
        this.mType = -1;
        this.mData = null;
        this.mParcelable = null;
        this.mInt1 = 0;
        this.mInt2 = 0;
        this.mTintList = null;
        this.mTintMode = DEFAULT_TINT_MODE;
        this.mTintModeStr = null;
    }

    @Nullable
    public static IconCompat createFromBundle(@NonNull Bundle r4) {
        int r0 = r4.getInt("type");
        IconCompat r1 = new IconCompat(r0);
        r1.mInt1 = r4.getInt(EXTRA_INT1);
        r1.mInt2 = r4.getInt(EXTRA_INT2);
        if (r4.containsKey(EXTRA_TINT_LIST) == false) goto L6;
        r1.mTintList = (ColorStateList) r4.getParcelable(EXTRA_TINT_LIST);
    L6:
        if (r4.containsKey(EXTRA_TINT_MODE) == false) goto L9;
        r1.mTintMode = PorterDuff.Mode.valueOf(r4.getString(EXTRA_TINT_MODE));
    L9:
        switch(r0) {
            case -1: goto L14;
            case 0: goto L10;
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L13;
            case 5: goto L14;
            case 6: goto L13;
            default: goto L10;
        };
    L10:
        Log.w(TAG, "Unknown type " + r0);
        return null;
    L12:
        r1.mObj1 = r4.getByteArray(EXTRA_OBJ);
    L15:
        return r1;
    L13:
        r1.mObj1 = r4.getString(EXTRA_OBJ);
        goto L15
    L14:
        r1.mObj1 = r4.getParcelable(EXTRA_OBJ);
        goto L15
    }

    @Nullable
    @RequiresApi(23)
    public static IconCompat createFromIcon(@NonNull Context r2, @NonNull Icon r3) {
        Preconditions.checkNotNull(r3);
        int r0 = getType(r3);
        if (r0 != 2) goto L5;
        String r1 = getResPackage(r3);
        return createWithResource(getResources(r2, r1), r1, getResId(r3));
    L18:
        throw new IllegalArgumentException("Icon resource cannot be found");
    L5:
        if (r0 == 4) goto L13;
        if (r0 == 6) goto L11;
        IconCompat r4 = new IconCompat(-1);
        r4.mObj1 = r3;
        return r4;
    L11:
        return createWithAdaptiveBitmapContentUri(getUri(r3));
    L13:
        return createWithContentUri(getUri(r3));
    }

    @Nullable
    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static IconCompat createFromIconOrNullIfZeroResId(@NonNull Icon r2) {
        if (getType(r2) != 2) goto L9;
        if (getResId(r2) != 0) goto L9;
        return null;
    L9:
        return createFromIcon(r2);
    }

    @VisibleForTesting
    public static Bitmap createLegacyIconFromAdaptiveIcon(Bitmap r9, boolean r10) {
        int r0 = (int) (Math.min(r9.getWidth(), r9.getHeight()) * DEFAULT_VIEW_PORT_SCALE);
        Bitmap r1 = Bitmap.createBitmap(r0, r0, Bitmap.Config.ARGB_8888);
        Canvas r2 = new Canvas(r1);
        Paint r3 = new Paint(3);
        float r4 = r0;
        float r5 = 0.5f * r4;
        float r6 = ICON_DIAMETER_FACTOR * r5;
        if (r10 == false) goto L5;
        float r11 = BLUR_FACTOR * r4;
        r3.setColor(0);
        r3.setShadowLayer(r11, 0.0f, r4 * KEY_SHADOW_OFFSET_FACTOR, 1023410176);
        r2.drawCircle(r5, r5, r6, r3);
        r3.setShadowLayer(r11, 0.0f, 0.0f, 503316480);
        r2.drawCircle(r5, r5, r6, r3);
        r3.clearShadowLayer();
    L5:
        r3.setColor(ViewCompat.MEASURED_STATE_MASK);
        Shader.TileMode r7 = Shader.TileMode.CLAMP;
        BitmapShader r12 = new BitmapShader(r9, r7, r7);
        Matrix r8 = new Matrix();
        r8.setTranslate((-(r9.getWidth() - r0)) / 2, (-(r9.getHeight() - r0)) / 2);
        r12.setLocalMatrix(r8);
        r3.setShader(r12);
        r2.drawCircle(r5, r5, r6, r3);
        r2.setBitmap(null);
        return r1;
    }

    public static IconCompat createWithAdaptiveBitmap(Bitmap r2) {
        if (r2 == null) goto L6;
        IconCompat r0 = new IconCompat(5);
        r0.mObj1 = r2;
        return r0;
    L6:
        throw new IllegalArgumentException("Bitmap must not be null.");
    }

    @NonNull
    public static IconCompat createWithAdaptiveBitmapContentUri(@NonNull String r2) {
        if (r2 == null) goto L6;
        IconCompat r0 = new IconCompat(6);
        r0.mObj1 = r2;
        return r0;
    L6:
        throw new IllegalArgumentException("Uri must not be null.");
    }

    public static IconCompat createWithBitmap(Bitmap r2) {
        if (r2 == null) goto L6;
        IconCompat r0 = new IconCompat(1);
        r0.mObj1 = r2;
        return r0;
    L6:
        throw new IllegalArgumentException("Bitmap must not be null.");
    }

    public static IconCompat createWithContentUri(String r2) {
        if (r2 == null) goto L6;
        IconCompat r0 = new IconCompat(4);
        r0.mObj1 = r2;
        return r0;
    L6:
        throw new IllegalArgumentException("Uri must not be null.");
    }

    public static IconCompat createWithData(byte[] r2, int r3, int r4) {
        if (r2 == null) goto L6;
        IconCompat r0 = new IconCompat(3);
        r0.mObj1 = r2;
        r0.mInt1 = r3;
        r0.mInt2 = r4;
        return r0;
    L6:
        throw new IllegalArgumentException("Data must not be null.");
    }

    public static IconCompat createWithResource(Context r1, @DrawableRes int r2) {
        if (r1 == null) goto L6;
        return createWithResource(r1.getResources(), r1.getPackageName(), r2);
    L6:
        throw new IllegalArgumentException("Context must not be null.");
    }

    private static Resources getResources(Context r3, String r4) {
        if ("android".equals(r4) == true) goto L5;
        PackageManager r5 = r3.getPackageManager();
        ApplicationInfo r0 = r5.getApplicationInfo(r4, 8192);     // Catch: PackageManager.NameNotFoundException -> L11
        if (r0 == null) goto L13;
        return r5.getResourcesForApplication(r0);
    L13:
        return null;
    L11:
        e = move-exception;
        Log.e(TAG, "Unable to find pkg=" + r4 + " for icon", e);
        return null;
    L5:
        return Resources.getSystem();
    }

    private InputStream getUriInputStream(Context r5) {
        Uri r0 = getUri();
        String r1 = r0.getScheme();
        if ("content".equals(r1) == false) goto L5;
    L17:
        return r5.getContentResolver().openInputStream(r0);
    L13:
        e = move-exception;
        Log.w(TAG, "Unable to load image from URI: " + r0, e);
        return null;
    L5:
        if ("file".equals(r1) == true) goto L17;
        return new FileInputStream(new File((String) this.mObj1));
    L9:
        e = move-exception;
        Log.w(TAG, "Unable to load image from path: " + r0, e);
        return null;
    }

    private Drawable loadDrawableInner(Context r4) {
        switch(this.mType) {
            case 1: goto L27;
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L5;
            default: goto L25;
        };
    L5:
        InputStream r3 = getUriInputStream(r4);
        if (r3 == null) goto L25;
        return new AdaptiveIconDrawable(null, new BitmapDrawable(r4.getResources(), BitmapFactory.decodeStream(r3)));
    L11:
        InputStream r5 = getUriInputStream(r4);
        if (r5 == null) goto L25;
        return new BitmapDrawable(r4.getResources(), BitmapFactory.decodeStream(r5));
    L17:
        String r0 = getResPackage();
        if (TextUtils.isEmpty(r0) == false) goto L20;
        r0 = r4.getPackageName();
    L20:
        Resources r1 = getResources(r4, r0);
        return ResourcesCompat.getDrawable(r1, this.mInt1, r4.getTheme());
    L23:
        e = move-exception;
        Log.e(TAG, String.format("Unable to load resource 0x%08x from pkg=%s", new Object[]{Integer.valueOf(this.mInt1), this.mObj1}), e);
    L25:
        return null;
    L10:
        return new BitmapDrawable(r4.getResources(), createLegacyIconFromAdaptiveIcon((Bitmap) this.mObj1, false));
    L16:
        return new BitmapDrawable(r4.getResources(), BitmapFactory.decodeByteArray((byte[]) this.mObj1, this.mInt1, this.mInt2));
    L27:
        return new BitmapDrawable(r4.getResources(), (Bitmap) this.mObj1);
    }

    private static String typeToString(int r0) {
        switch(r0) {
            case 1: goto L15;
            case 2: goto L13;
            case 3: goto L11;
            case 4: goto L9;
            case 5: goto L7;
            case 6: goto L5;
            default: goto L3;
        };
    L3:
        return NetworkStackConstant.UNKNOWN_TYPE;
    L5:
        return "URI_MASKABLE";
    L7:
        return "BITMAP_MASKABLE";
    L9:
        return "URI";
    L11:
        return "DATA";
    L13:
        return "RESOURCE";
    L15:
        return "BITMAP";
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void addToShortcutIntent(@NonNull Intent r5, @Nullable Drawable r6, @NonNull Context r7) {
        checkResource(r7);
        int r0 = this.mType;
        if (r0 != 1) goto L5;
        Bitmap r4 = (Bitmap) this.mObj1;
        if (r6 == null) goto L31;
        r4 = r4.copy(r4.getConfig(), true);
    L31:
        if (r6 == null) goto L33;
        int r8 = r4.getWidth();
        int r1 = r4.getHeight();
        r6.setBounds(r8 / 2, r1 / 2, r8, r1);
        r6.draw(new Canvas(r4));
    L33:
        r5.putExtra("android.intent.extra.shortcut.ICON", r4);
        return;
    L5:
        if (r0 != 2) goto L7;
        Context r9 = r7.createPackageContext(getResPackage(), 0);     // Catch: PackageManager.NameNotFoundException -> L15
        if (r6 != null) goto L17;
        r5.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(r9, this.mInt1));     // Catch: PackageManager.NameNotFoundException -> L15
        return;
    L17:
        Drawable r2 = ContextCompat.getDrawable(r9, this.mInt1);     // Catch: PackageManager.NameNotFoundException -> L15
        if (r2.getIntrinsicWidth() > 0) goto L20;
    L23:
        int r10 = ((ActivityManager) r9.getSystemService("activity")).getLauncherLargeIconSize();     // Catch: PackageManager.NameNotFoundException -> L15
        Bitmap r11 = Bitmap.createBitmap(r10, r10, Bitmap.Config.ARGB_8888);     // Catch: PackageManager.NameNotFoundException -> L15
    L24:
        r2.setBounds(0, 0, r11.getWidth(), r11.getHeight());     // Catch: PackageManager.NameNotFoundException -> L15
        r2.draw(new Canvas(r11));     // Catch: PackageManager.NameNotFoundException -> L15
        r4 = r11;
        goto L31
    L20:
        if (r2.getIntrinsicHeight() <= 0) goto L23;
        r11 = Bitmap.createBitmap(r2.getIntrinsicWidth(), r2.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);     // Catch: PackageManager.NameNotFoundException -> L15
    L15:
        e = move-exception;
        throw new IllegalArgumentException("Can't find package " + this.mObj1, e);
    L7:
        if (r0 != 5) goto L10;
        r4 = createLegacyIconFromAdaptiveIcon((Bitmap) this.mObj1, true);
        goto L31
    L10:
        throw new IllegalArgumentException("Icon type not supported for intent shortcuts");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void checkResource(@NonNull Context r9) {
        if (this.mType != 2) goto L11;
        String r0 = (String) this.mObj1;
        if (r0.contains(":") == true) goto L7;
        return;
    L7:
        String r3 = r0.split(":", -1)[1];
        String r6 = r3.split(LibrarianImpl.Constants.SEPARATOR, -1)[0];
        String r4 = r3.split(LibrarianImpl.Constants.SEPARATOR, -1)[1];
        String r1 = r0.split(":", -1)[0];
        int r10 = getResources(r9, r1).getIdentifier(r4, r6, r1);
        if (this.mInt1 == r10) goto L12;
        Log.i(TAG, "Id has changed for " + r1 + LibrarianImpl.Constants.SEPARATOR + r4);
        this.mInt1 = r10;
        return;
    L12:
        return;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public Bitmap getBitmap() {
        int r0 = this.mType;
        if (r0 != (-1)) goto L11;
        Object r3 = this.mObj1;
        if ((r3 instanceof Bitmap) == true) goto L7;
        return null;
    L7:
        return (Bitmap) r3;
    L11:
        if (r0 != 1) goto L15;
        return (Bitmap) this.mObj1;
    L15:
        if (r0 != 5) goto L19;
        return createLegacyIconFromAdaptiveIcon((Bitmap) this.mObj1, true);
    L19:
        throw new IllegalStateException("called getBitmap() on " + this);
    }

    @IdRes
    public int getResId() {
        int r0 = this.mType;
        if (r0 != (-1)) goto L7;
        return getResId((Icon) this.mObj1);
    L7:
        if (r0 != 2) goto L11;
        return this.mInt1;
    L11:
        throw new IllegalStateException("called getResId() on " + this);
    }

    @NonNull
    public String getResPackage() {
        int r0 = this.mType;
        if (r0 != (-1)) goto L7;
        return getResPackage((Icon) this.mObj1);
    L7:
        if (r0 != 2) goto L11;
        return ((String) this.mObj1).split(":", -1)[0];
    L11:
        throw new IllegalStateException("called getResPackage() on " + this);
    }

    public int getType() {
        int r0 = this.mType;
        if (r0 == (-1)) goto L5;
        return r0;
    L5:
        return getType((Icon) this.mObj1);
    }

    @NonNull
    public Uri getUri() {
        int r0 = this.mType;
        if (r0 != (-1)) goto L7;
        return getUri((Icon) this.mObj1);
    L7:
        if (r0 == 4) goto L14;
        if (r0 == 6) goto L14;
        throw new IllegalStateException("called getUri() on " + this);
    L14:
        return Uri.parse((String) this.mObj1);
    }

    @Nullable
    public Drawable loadDrawable(@NonNull Context r1) {
        checkResource(r1);
        return toIcon(r1).loadDrawable(r1);
    }

    @Override // androidx.versionedparcelable.CustomVersionedParcelable
    public void onPostParceling() {
        this.mTintMode = PorterDuff.Mode.valueOf(this.mTintModeStr);
        switch(this.mType) {
            case -1: goto L11;
            case 0: goto L21;
            case 1: goto L7;
            case 2: goto L6;
            case 3: goto L5;
            case 4: goto L6;
            case 5: goto L7;
            case 6: goto L6;
            default: goto L21;
        };
    L5:
        this.mObj1 = this.mData;
        return;
    L6:
        this.mObj1 = new String(this.mData, Charset.forName(HTTP.UTF_16));
        return;
    L7:
        Parcelable r0 = this.mParcelable;
        if (r0 == null) goto L10;
        this.mObj1 = r0;
        return;
    L10:
        byte[] r1 = this.mData;
        this.mObj1 = r1;
        this.mType = 3;
        this.mInt1 = 0;
        this.mInt2 = r1.length;
        return;
    L11:
        Parcelable r2 = this.mParcelable;
        if (r2 == null) goto L16;
        this.mObj1 = r2;
        return;
    L16:
        throw new IllegalArgumentException("Invalid icon");
    }

    @Override // androidx.versionedparcelable.CustomVersionedParcelable
    public void onPreParceling(boolean r4) {
        this.mTintModeStr = this.mTintMode.name();
        switch(this.mType) {
            case -1: goto L11;
            case 0: goto L21;
            case 1: goto L8;
            case 2: goto L7;
            case 3: goto L6;
            case 4: goto L5;
            case 5: goto L8;
            case 6: goto L5;
            default: goto L21;
        };
    L5:
        this.mData = this.mObj1.toString().getBytes(Charset.forName(HTTP.UTF_16));
        return;
    L6:
        this.mData = (byte[]) this.mObj1;
        return;
    L7:
        this.mData = ((String) this.mObj1).getBytes(Charset.forName(HTTP.UTF_16));
        return;
    L8:
        if (r4 == false) goto L10;
        Bitmap r5 = (Bitmap) this.mObj1;
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        r5.compress(Bitmap.CompressFormat.PNG, 90, r0);
        this.mData = r0.toByteArray();
        return;
    L10:
        this.mParcelable = (Parcelable) this.mObj1;
        return;
    L11:
        if (r4 == true) goto L15;
        this.mParcelable = (Parcelable) this.mObj1;
        return;
    L15:
        throw new IllegalArgumentException("Can't serialize Icon created with IconCompat#createFromIcon");
    }

    public IconCompat setTint(@ColorInt int r1) {
        return setTintList(ColorStateList.valueOf(r1));
    }

    public IconCompat setTintList(ColorStateList r1) {
        this.mTintList = r1;
        return this;
    }

    public IconCompat setTintMode(PorterDuff.Mode r1) {
        this.mTintMode = r1;
        return this;
    }

    public Bundle toBundle() {
        Bundle r0 = new Bundle();
        switch(this.mType) {
            case -1: goto L9;
            case 0: goto L5;
            case 1: goto L8;
            case 2: goto L7;
            case 3: goto L6;
            case 4: goto L7;
            case 5: goto L8;
            case 6: goto L7;
            default: goto L5;
        };
    L6:
        r0.putByteArray(EXTRA_OBJ, (byte[]) this.mObj1);
    L10:
        r0.putInt("type", this.mType);
        r0.putInt(EXTRA_INT1, this.mInt1);
        r0.putInt(EXTRA_INT2, this.mInt2);
        ColorStateList r1 = this.mTintList;
        if (r1 == null) goto L13;
        r0.putParcelable(EXTRA_TINT_LIST, r1);
    L13:
        PorterDuff.Mode r3 = this.mTintMode;
        if (r3 == DEFAULT_TINT_MODE) goto L16;
        r0.putString(EXTRA_TINT_MODE, r3.name());
    L16:
        return r0;
    L7:
        r0.putString(EXTRA_OBJ, (String) this.mObj1);
        goto L10
    L8:
        r0.putParcelable(EXTRA_OBJ, (Bitmap) this.mObj1);
        goto L10
    L9:
        r0.putParcelable(EXTRA_OBJ, (Parcelable) this.mObj1);
        goto L10
    L5:
        throw new IllegalArgumentException("Invalid icon");
    }

    @NonNull
    @RequiresApi(23)
    @Deprecated
    public Icon toIcon() {
        return toIcon(null);
    }

    @NonNull
    public String toString() {
        if (this.mType == (-1)) goto L5;
        StringBuilder r0 = new StringBuilder("Icon(typ=");
        r0.append(typeToString(this.mType));
        switch(this.mType) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L14;
            case 6: goto L9;
            default: goto L16;
        };
    L9:
        r0.append(" uri=");
        r0.append(this.mObj1);
        goto L16
    L10:
        r0.append(" len=");
        r0.append(this.mInt1);
        if (this.mInt2 == 0) goto L16;
        r0.append(" off=");
        r0.append(this.mInt2);
        goto L16
    L13:
        r0.append(" pkg=");
        r0.append(getResPackage());
        r0.append(" id=");
        r0.append(String.format("0x%08x", new Object[]{Integer.valueOf(getResId())}));
        goto L16
    L14:
        r0.append(" size=");
        r0.append(((Bitmap) this.mObj1).getWidth());
        r0.append("x");
        r0.append(((Bitmap) this.mObj1).getHeight());
    L16:
        if (this.mTintList == null) goto L19;
        r0.append(" tint=");
        r0.append(this.mTintList);
    L19:
        if (this.mTintMode == DEFAULT_TINT_MODE) goto L21;
        r0.append(" mode=");
        r0.append(this.mTintMode);
    L21:
        r0.append(")");
        return r0.toString();
    L5:
        return String.valueOf(this.mObj1);
    }

    @NonNull
    @RequiresApi(23)
    public Icon toIcon(@Nullable Context r3) {
        switch(this.mType) {
            case -1: goto L27;
            case 0: goto L5;
            case 1: goto L18;
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L6;
            default: goto L5;
        };
    L6:
        if (r3 == null) goto L13;
        InputStream r4 = getUriInputStream(r3);
        if (r4 == null) goto L11;
        Icon r5 = Icon.createWithAdaptiveBitmap(BitmapFactory.decodeStream(r4));
    L19:
        ColorStateList r0 = this.mTintList;
        if (r0 == null) goto L22;
        r5.setTintList(r0);
    L22:
        PorterDuff.Mode r2 = this.mTintMode;
        if (r2 == DEFAULT_TINT_MODE) goto L25;
        r5.setTintMode(r2);
    L25:
        return r5;
    L11:
        throw new IllegalStateException("Cannot load adaptive icon from uri: " + getUri());
    L13:
        throw new IllegalArgumentException("Context is required to resolve the file uri of the icon: " + getUri());
    L14:
        r5 = Icon.createWithAdaptiveBitmap((Bitmap) this.mObj1);
        goto L19
    L15:
        r5 = Icon.createWithContentUri((String) this.mObj1);
        goto L19
    L16:
        r5 = Icon.createWithData((byte[]) this.mObj1, this.mInt1, this.mInt2);
        goto L19
    L17:
        r5 = Icon.createWithResource(getResPackage(), this.mInt1);
        goto L19
    L18:
        r5 = Icon.createWithBitmap((Bitmap) this.mObj1);
        goto L19
    L5:
        throw new IllegalArgumentException("Unknown type");
    L27:
        return (Icon) this.mObj1;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static IconCompat createWithResource(Resources r2, String r3, @DrawableRes int r4) {
        if (r3 == null) goto L15;
        if (r4 == 0) goto L13;
        IconCompat r0 = new IconCompat(2);
        r0.mInt1 = r4;
        if (r2 != null) goto L16;
        r0.mObj1 = r3;
    L11:
        return r0;
    L16:
        r0.mObj1 = r2.getResourceName(r4);     // Catch: Resources.NotFoundException -> L8
    L9:
        throw new IllegalArgumentException("Icon resource cannot be found");
    L13:
        throw new IllegalArgumentException("Drawable resource ID must not be 0");
    L15:
        throw new IllegalArgumentException("Package must not be null.");
    }

    @RequiresApi(23)
    private static int getType(@NonNull Icon r0) {
        return r0.getType();
    }

    @NonNull
    public static IconCompat createWithAdaptiveBitmapContentUri(@NonNull Uri r1) {
        if (r1 == null) goto L6;
        return createWithAdaptiveBitmapContentUri(r1.toString());
    L6:
        throw new IllegalArgumentException("Uri must not be null.");
    }

    public static IconCompat createWithContentUri(Uri r1) {
        if (r1 == null) goto L6;
        return createWithContentUri(r1.toString());
    L6:
        throw new IllegalArgumentException("Uri must not be null.");
    }

    @DrawableRes
    @IdRes
    @RequiresApi(23)
    private static int getResId(@NonNull Icon r0) {
        return r0.getResId();
    }

    @Nullable
    @RequiresApi(23)
    private static String getResPackage(@NonNull Icon r0) {
        return r0.getResPackage();
    }

    @Nullable
    @RequiresApi(23)
    private static Uri getUri(@NonNull Icon r0) {
        return r0.getUri();
    }

    private IconCompat(int r3) {
        this.mData = null;
        this.mParcelable = null;
        this.mInt1 = 0;
        this.mInt2 = 0;
        this.mTintList = null;
        this.mTintMode = DEFAULT_TINT_MODE;
        this.mTintModeStr = null;
        this.mType = r3;
    }

    @Nullable
    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static IconCompat createFromIcon(@NonNull Icon r2) {
        Preconditions.checkNotNull(r2);
        int r0 = getType(r2);
        if (r0 == 2) goto L15;
        if (r0 == 4) goto L13;
        if (r0 == 6) goto L11;
        IconCompat r1 = new IconCompat(-1);
        r1.mObj1 = r2;
        return r1;
    L11:
        return createWithAdaptiveBitmapContentUri(getUri(r2));
    L13:
        return createWithContentUri(getUri(r2));
    L15:
        return createWithResource(null, getResPackage(r2), getResId(r2));
    }
}
