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
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import androidx.versionedparcelable.CustomVersionedParcelable;
import com.android.settings.utils.HanziToPinyin;
import com.android.settingslib.applications.RecentAppOpsAccess;
import com.bytedance.librarian.LibrarianImpl;
import com.bytedance.networkstackapplib.NetworkStackConstant;
import com.obric.oui.material.MaterialConfigFormatNames;
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
    static final String EXTRA_INT1 = "int1";
    static final String EXTRA_INT2 = "int2";
    static final String EXTRA_OBJ = "obj";
    static final String EXTRA_STRING1 = "string1";
    static final String EXTRA_TINT_LIST = "tint_list";
    static final String EXTRA_TINT_MODE = "tint_mode";
    static final String EXTRA_TYPE = "type";
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
    public byte[] mData;
    public int mInt1;
    public int mInt2;
    Object mObj1;
    public Parcelable mParcelable;
    public String mString1;
    public ColorStateList mTintList;
    PorterDuff.Mode mTintMode;
    public String mTintModeStr;
    public int mType;

    static class Api23Impl {
        private Api23Impl() {
        }

        static IconCompat createFromIcon(Context r2, Icon r3) {
            int r0 = getType(r3);
            if (r0 != 2) goto L5;
            String r1 = getResPackage(r3);
            return IconCompat.createWithResource(IconCompat.getResources(r2, r1), r1, getResId(r3));
        L18:
            throw new IllegalArgumentException("Icon resource cannot be found");
        L5:
            if (r0 == 4) goto L13;
            if (r0 == 6) goto L11;
            IconCompat r4 = new IconCompat(-1);
            r4.mObj1 = r3;
            return r4;
        L11:
            return IconCompat.createWithAdaptiveBitmapContentUri(getUri(r3));
        L13:
            return IconCompat.createWithContentUri(getUri(r3));
        }

        static int getType(Object r0) {
            return Api28Impl.getType(r0);
        }

        static String getResPackage(Object r0) {
            return Api28Impl.getResPackage(r0);
        }

        static IconCompat createFromIconInner(Object r2) {
            Preconditions.checkNotNull(r2);
            int r0 = getType(r2);
            if (r0 == 2) goto L15;
            if (r0 == 4) goto L13;
            if (r0 == 6) goto L11;
            IconCompat r1 = new IconCompat(-1);
            r1.mObj1 = r2;
            return r1;
        L11:
            return IconCompat.createWithAdaptiveBitmapContentUri(getUri(r2));
        L13:
            return IconCompat.createWithContentUri(getUri(r2));
        L15:
            return IconCompat.createWithResource(null, getResPackage(r2), getResId(r2));
        }

        static int getResId(Object r0) {
            return Api28Impl.getResId(r0);
        }

        static Uri getUri(Object r0) {
            return Api28Impl.getUri(r0);
        }

        static Icon toIcon(IconCompat r2, Context r3) {
            switch(r2.mType) {
                case -1: goto L20;
                case 0: goto L5;
                case 1: goto L11;
                case 2: goto L10;
                case 3: goto L9;
                case 4: goto L8;
                case 5: goto L7;
                case 6: goto L6;
                default: goto L5;
            };
        L6:
            Icon r4 = Api30Impl.createWithAdaptiveBitmapContentUri(r2.getUri());
        L13:
            if (r2.mTintList == null) goto L16;
            r4.setTintList(r2.mTintList);
        L16:
            if (r2.mTintMode == IconCompat.DEFAULT_TINT_MODE) goto L18;
            r4.setTintMode(r2.mTintMode);
        L18:
            return r4;
        L7:
            r4 = Api26Impl.createWithAdaptiveBitmap((Bitmap) r2.mObj1);
            goto L13
        L8:
            r4 = Icon.createWithContentUri((String) r2.mObj1);
            goto L13
        L9:
            r4 = Icon.createWithData((byte[]) r2.mObj1, r2.mInt1, r2.mInt2);
            goto L13
        L10:
            r4 = Icon.createWithResource(r2.getResPackage(), r2.mInt1);
            goto L13
        L11:
            r4 = Icon.createWithBitmap((Bitmap) r2.mObj1);
            goto L13
        L5:
            throw new IllegalArgumentException("Unknown type");
        L20:
            return (Icon) r2.mObj1;
        }

        static Drawable loadDrawable(Icon r0, Context r1) {
            return r0.loadDrawable(r1);
        }
    }

    static class Api26Impl {
        private Api26Impl() {
        }

        static Drawable createAdaptiveIconDrawable(Drawable r1, Drawable r2) {
            return new AdaptiveIconDrawable(r1, r2);
        }

        static Icon createWithAdaptiveBitmap(Bitmap r0) {
            return Icon.createWithAdaptiveBitmap(r0);
        }
    }

    static class Api28Impl {
        private Api28Impl() {
        }

        static String getResPackage(Object r0) {
            return ((Icon) r0).getResPackage();
        }

        static int getType(Object r0) {
            return ((Icon) r0).getType();
        }

        static int getResId(Object r0) {
            return ((Icon) r0).getResId();
        }

        static Uri getUri(Object r0) {
            return ((Icon) r0).getUri();
        }
    }

    static class Api30Impl {
        private Api30Impl() {
        }

        static Icon createWithAdaptiveBitmapContentUri(Uri r0) {
            return Icon.createWithAdaptiveBitmapContentUri(r0);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface IconType {
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

    static {
        DEFAULT_TINT_MODE = PorterDuff.Mode.SRC_IN;
    }

    public static IconCompat createWithResource(Context r1, int r2) {
        ObjectsCompat.requireNonNull(r1);
        return createWithResource(r1.getResources(), r1.getPackageName(), r2);
    }

    public static IconCompat createWithResource(Resources r2, String r3, int r4) {
        ObjectsCompat.requireNonNull(r3);
        if (r4 == 0) goto L14;
        IconCompat r0 = new IconCompat(2);
        r0.mInt1 = r4;
        if (r2 != null) goto L15;
        r0.mObj1 = r3;
    L11:
        r0.mString1 = r3;
        return r0;
    L15:
        r0.mObj1 = r2.getResourceName(r4);     // Catch: Resources.NotFoundException -> L8
    L9:
        throw new IllegalArgumentException("Icon resource cannot be found");
    L14:
        throw new IllegalArgumentException("Drawable resource ID must not be 0");
    }

    public static IconCompat createWithBitmap(Bitmap r2) {
        ObjectsCompat.requireNonNull(r2);
        IconCompat r0 = new IconCompat(1);
        r0.mObj1 = r2;
        return r0;
    }

    public static IconCompat createWithAdaptiveBitmap(Bitmap r2) {
        ObjectsCompat.requireNonNull(r2);
        IconCompat r0 = new IconCompat(5);
        r0.mObj1 = r2;
        return r0;
    }

    public static IconCompat createWithData(byte[] r2, int r3, int r4) {
        ObjectsCompat.requireNonNull(r2);
        IconCompat r0 = new IconCompat(3);
        r0.mObj1 = r2;
        r0.mInt1 = r3;
        r0.mInt2 = r4;
        return r0;
    }

    public static IconCompat createWithContentUri(String r2) {
        ObjectsCompat.requireNonNull(r2);
        IconCompat r0 = new IconCompat(4);
        r0.mObj1 = r2;
        return r0;
    }

    public static IconCompat createWithContentUri(Uri r0) {
        ObjectsCompat.requireNonNull(r0);
        return createWithContentUri(r0.toString());
    }

    public static IconCompat createWithAdaptiveBitmapContentUri(String r2) {
        ObjectsCompat.requireNonNull(r2);
        IconCompat r0 = new IconCompat(6);
        r0.mObj1 = r2;
        return r0;
    }

    public static IconCompat createWithAdaptiveBitmapContentUri(Uri r0) {
        ObjectsCompat.requireNonNull(r0);
        return createWithAdaptiveBitmapContentUri(r0.toString());
    }

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

    IconCompat(int r3) {
        this.mData = null;
        this.mParcelable = null;
        this.mInt1 = 0;
        this.mInt2 = 0;
        this.mTintList = null;
        this.mTintMode = DEFAULT_TINT_MODE;
        this.mTintModeStr = null;
        this.mType = r3;
    }

    public int getType() {
        int r0 = this.mType;
        if (r0 == (-1)) goto L5;
        return r0;
    L5:
        return Api23Impl.getType(this.mObj1);
    }

    public String getResPackage() {
        int r0 = this.mType;
        if (r0 != (-1)) goto L7;
        return Api23Impl.getResPackage(this.mObj1);
    L7:
        if (r0 != 2) goto L18;
        String r1 = this.mString1;
        if (r1 == null) goto L16;
        if (TextUtils.isEmpty(r1) == true) goto L16;
        return this.mString1;
    L16:
        return ((String) this.mObj1).split(":", -1)[0];
    L18:
        throw new IllegalStateException("called getResPackage() on " + this);
    }

    public int getResId() {
        int r0 = this.mType;
        if (r0 != (-1)) goto L7;
        return Api23Impl.getResId(this.mObj1);
    L7:
        if (r0 != 2) goto L11;
        return this.mInt1;
    L11:
        throw new IllegalStateException("called getResId() on " + this);
    }

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

    public Uri getUri() {
        int r0 = this.mType;
        if (r0 != (-1)) goto L7;
        return Api23Impl.getUri(this.mObj1);
    L7:
        if (r0 == 4) goto L14;
        if (r0 == 6) goto L14;
        throw new IllegalStateException("called getUri() on " + this);
    L14:
        return Uri.parse((String) this.mObj1);
    }

    public IconCompat setTint(int r1) {
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

    @Deprecated
    public Icon toIcon() {
        return toIcon(null);
    }

    public Icon toIcon(Context r1) {
        return Api23Impl.toIcon(this, r1);
    }

    public void checkResource(Context r9) {
        if (this.mType != 2) goto L17;
        Object r0 = this.mObj1;
        if (r0 == null) goto L18;
        String r1 = (String) r0;
        if (r1.contains(":") == true) goto L9;
        return;
    L9:
        String r3 = r1.split(":", -1)[1];
        String r6 = r3.split(LibrarianImpl.Constants.SEPARATOR, -1)[0];
        String r4 = r3.split(LibrarianImpl.Constants.SEPARATOR, -1)[1];
        String r2 = r1.split(":", -1)[0];
        if ("0_resource_name_obfuscated".equals(r4) == false) goto L13;
        Log.i(TAG, "Found obfuscated resource, not trying to update resource id for it");
        return;
    L13:
        String r5 = getResPackage();
        int r10 = getResources(r9, r5).getIdentifier(r4, r6, r2);
        if (this.mInt1 == r10) goto L19;
        Log.i(TAG, "Id has changed for " + r5 + HanziToPinyin.Token.SEPARATOR + r1);
        this.mInt1 = r10;
        return;
    L19:
        return;
    L18:
        return;
    }

    public Drawable loadDrawable(Context r1) {
        checkResource(r1);
        return Api23Impl.loadDrawable(toIcon(r1), r1);
    }

    private Drawable loadDrawableInner(Context r5) {
        switch(this.mType) {
            case 1: goto L26;
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L5;
            default: goto L27;
        };
    L5:
        InputStream r4 = getUriInputStream(r5);
        if (r4 == null) goto L27;
        return Api26Impl.createAdaptiveIconDrawable(null, new BitmapDrawable(r5.getResources(), BitmapFactory.decodeStream(r4)));
    L11:
        InputStream r6 = getUriInputStream(r5);
        if (r6 == null) goto L27;
        return new BitmapDrawable(r5.getResources(), BitmapFactory.decodeStream(r6));
    L17:
        String r0 = getResPackage();
        if (TextUtils.isEmpty(r0) == false) goto L28;
        r0 = r5.getPackageName();
    L28:
        return ResourcesCompat.getDrawable(getResources(r5, r0), this.mInt1, r5.getTheme());
    L23:
        e = move-exception;
        Log.e(TAG, String.format("Unable to load resource 0x%08x from pkg=%s", new Object[]{Integer.valueOf(this.mInt1), this.mObj1}), e);
    L27:
        return null;
    L10:
        return new BitmapDrawable(r5.getResources(), createLegacyIconFromAdaptiveIcon((Bitmap) this.mObj1, false));
    L16:
        return new BitmapDrawable(r5.getResources(), BitmapFactory.decodeByteArray((byte[]) this.mObj1, this.mInt1, this.mInt2));
    L26:
        return new BitmapDrawable(r5.getResources(), (Bitmap) this.mObj1);
    }

    public InputStream getUriInputStream(Context r5) {
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

    static Resources getResources(Context r3, String r4) {
        if (RecentAppOpsAccess.ANDROID_SYSTEM_PACKAGE_NAME.equals(r4) == true) goto L5;
        PackageManager r5 = r3.getPackageManager();
        ApplicationInfo r0 = r5.getApplicationInfo(r4, 8192);     // Catch: PackageManager.NameNotFoundException -> L12
        if (r0 == null) goto L11;
        return r5.getResourcesForApplication(r0);
    L11:
        return null;
    L12:
        e = move-exception;
        Log.e(TAG, String.format("Unable to find pkg=%s for icon", new Object[]{r4}), e);
        return null;
    L5:
        return Resources.getSystem();
    }

    public void addToShortcutIntent(Intent r5, Drawable r6, Context r7) {
        checkResource(r7);
        int r0 = this.mType;
        if (r0 != 1) goto L5;
        Bitmap r4 = (Bitmap) this.mObj1;
        if (r6 == null) goto L30;
        r4 = r4.copy(r4.getConfig(), true);
    L30:
        if (r6 == null) goto L32;
        int r8 = r4.getWidth();
        int r1 = r4.getHeight();
        r6.setBounds(r8 / 2, r1 / 2, r8, r1);
        r6.draw(new Canvas(r4));
    L32:
        r5.putExtra("android.intent.extra.shortcut.ICON", r4);
        return;
    L5:
        if (r0 != 2) goto L7;
        Context r9 = r7.createPackageContext(getResPackage(), 0);     // Catch: PackageManager.NameNotFoundException -> L24
        if (r6 != null) goto L15;
        r5.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(r9, this.mInt1));     // Catch: PackageManager.NameNotFoundException -> L24
        return;
    L15:
        Drawable r2 = ContextCompat.getDrawable(r9, this.mInt1);     // Catch: PackageManager.NameNotFoundException -> L24
        if (r2.getIntrinsicWidth() > 0) goto L18;
    L21:
        int r10 = ((ActivityManager) r9.getSystemService("activity")).getLauncherLargeIconSize();     // Catch: PackageManager.NameNotFoundException -> L24
        Bitmap r11 = Bitmap.createBitmap(r10, r10, Bitmap.Config.ARGB_8888);     // Catch: PackageManager.NameNotFoundException -> L24
    L22:
        r2.setBounds(0, 0, r11.getWidth(), r11.getHeight());     // Catch: PackageManager.NameNotFoundException -> L24
        r2.draw(new Canvas(r11));     // Catch: PackageManager.NameNotFoundException -> L24
        r4 = r11;
        goto L30
    L18:
        if (r2.getIntrinsicHeight() <= 0) goto L21;
        r11 = Bitmap.createBitmap(r2.getIntrinsicWidth(), r2.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);     // Catch: PackageManager.NameNotFoundException -> L24
    L24:
        e = move-exception;
        throw new IllegalArgumentException("Can't find package " + this.mObj1, e);
    L7:
        if (r0 != 5) goto L10;
        r4 = createLegacyIconFromAdaptiveIcon((Bitmap) this.mObj1, true);
        goto L30
    L10:
        throw new IllegalArgumentException("Icon type not supported for intent shortcuts");
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
        r0.putString(EXTRA_STRING1, this.mString1);
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

    public String toString() {
        if (this.mType == (-1)) goto L5;
        StringBuilder r0 = new StringBuilder("Icon(typ=").append(typeToString(this.mType));
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
        r0.append(" uri=").append(this.mObj1);
        goto L16
    L10:
        r0.append(" len=").append(this.mInt1);
        if (this.mInt2 == 0) goto L16;
        r0.append(" off=").append(this.mInt2);
        goto L16
    L13:
        r0.append(" pkg=").append(this.mString1).append(" id=").append(String.format("0x%08x", new Object[]{Integer.valueOf(getResId())}));
        goto L16
    L14:
        r0.append(" size=").append(((Bitmap) this.mObj1).getWidth()).append(MaterialConfigFormatNames.X).append(((Bitmap) this.mObj1).getHeight());
    L16:
        if (this.mTintList == null) goto L19;
        r0.append(" tint=");
        r0.append(this.mTintList);
    L19:
        if (this.mTintMode == DEFAULT_TINT_MODE) goto L21;
        r0.append(" mode=").append(this.mTintMode);
    L21:
        r0.append(")");
        return r0.toString();
    L5:
        return String.valueOf(this.mObj1);
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
        this.mData = this.mObj1.toString().getBytes(Charset.forName("UTF-16"));
        return;
    L6:
        this.mData = (byte[]) this.mObj1;
        return;
    L7:
        this.mData = ((String) this.mObj1).getBytes(Charset.forName("UTF-16"));
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
        if (r4 == true) goto L14;
        this.mParcelable = (Parcelable) this.mObj1;
        return;
    L14:
        throw new IllegalArgumentException("Can't serialize Icon created with IconCompat#createFromIcon");
    }

    @Override // androidx.versionedparcelable.CustomVersionedParcelable
    public void onPostParceling() {
        this.mTintMode = PorterDuff.Mode.valueOf(this.mTintModeStr);
        switch(this.mType) {
            case -1: goto L15;
            case 0: goto L27;
            case 1: goto L11;
            case 2: goto L6;
            case 3: goto L5;
            case 4: goto L6;
            case 5: goto L11;
            case 6: goto L6;
            default: goto L27;
        };
    L5:
        this.mObj1 = this.mData;
        return;
    L6:
        String r0 = new String(this.mData, Charset.forName("UTF-16"));
        this.mObj1 = r0;
        if (this.mType == 2) goto L9;
        return;
    L9:
        if (this.mString1 != null) goto L22;
        this.mString1 = r0.split(":", -1)[0];
        return;
    L22:
        return;
    L11:
        Parcelable r1 = this.mParcelable;
        if (r1 == null) goto L14;
        this.mObj1 = r1;
        return;
    L14:
        byte[] r2 = this.mData;
        this.mObj1 = r2;
        this.mType = 3;
        this.mInt1 = 0;
        this.mInt2 = r2.length;
        return;
    L15:
        Parcelable r3 = this.mParcelable;
        if (r3 == null) goto L19;
        this.mObj1 = r3;
        return;
    L19:
        throw new IllegalArgumentException("Invalid icon");
    }

    public static IconCompat createFromBundle(Bundle r4) {
        int r0 = r4.getInt("type");
        IconCompat r1 = new IconCompat(r0);
        r1.mInt1 = r4.getInt(EXTRA_INT1);
        r1.mInt2 = r4.getInt(EXTRA_INT2);
        r1.mString1 = r4.getString(EXTRA_STRING1);
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

    public static IconCompat createFromIcon(Context r0, Icon r1) {
        Preconditions.checkNotNull(r1);
        return Api23Impl.createFromIcon(r0, r1);
    }

    public static IconCompat createFromIcon(Icon r0) {
        return Api23Impl.createFromIconInner(r0);
    }

    public static IconCompat createFromIconOrNullIfZeroResId(Icon r2) {
        if (Api23Impl.getType(r2) != 2) goto L9;
        if (Api23Impl.getResId(r2) != 0) goto L9;
        return null;
    L9:
        return Api23Impl.createFromIconInner(r2);
    }

    static Bitmap createLegacyIconFromAdaptiveIcon(Bitmap r9, boolean r10) {
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
        r3.setShadowLayer(r11, 0.0f, r4 * 0.020833334f, 1023410176);
        r2.drawCircle(r5, r5, r6, r3);
        r3.setShadowLayer(r11, 0.0f, 0.0f, 503316480);
        r2.drawCircle(r5, r5, r6, r3);
        r3.clearShadowLayer();
    L5:
        r3.setColor(-16777216);
        BitmapShader r12 = new BitmapShader(r9, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        Matrix r7 = new Matrix();
        r7.setTranslate((-(r9.getWidth() - r0)) / 2.0f, (-(r9.getHeight() - r0)) / 2.0f);
        r12.setLocalMatrix(r7);
        r3.setShader(r12);
        r2.drawCircle(r5, r5, r6, r3);
        r2.setBitmap(null);
        return r1;
    }
}
