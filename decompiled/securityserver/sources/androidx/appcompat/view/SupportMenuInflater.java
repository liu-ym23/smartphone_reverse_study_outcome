package androidx.appcompat.view;

import a.a;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.annotation.LayoutRes;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuItemWrapperICS;
import androidx.appcompat.widget.DrawableUtils;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ActionProvider;
import androidx.core.view.MenuItemCompat;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class SupportMenuInflater extends MenuInflater {
    static final Class<?>[] ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE = null;
    static final Class<?>[] ACTION_VIEW_CONSTRUCTOR_SIGNATURE = null;
    static final String LOG_TAG = "SupportMenuInflater";
    static final int NO_ID = 0;
    private static final String XML_GROUP = "group";
    private static final String XML_ITEM = "item";
    private static final String XML_MENU = "menu";
    final Object[] mActionProviderConstructorArguments;
    final Object[] mActionViewConstructorArguments;
    Context mContext;
    private Object mRealOwner;

    public static class InflatedOnMenuItemClickListener implements MenuItem.OnMenuItemClickListener {
        private static final Class<?>[] PARAM_TYPES = null;
        private Method mMethod;
        private Object mRealOwner;

        static {
            PARAM_TYPES = new Class[]{MenuItem.class};
        }

        public InflatedOnMenuItemClickListener(Object r4, String r5) {
            this.mRealOwner = r4;
            Class<?> r6 = r4.getClass();
            this.mMethod = r6.getMethod(r5, PARAM_TYPES);     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            StringBuilder r7 = a.u("Couldn't resolve menu item onClick handler ", r5, " in class ");
            r7.append(r6.getName());
            InflateException r0 = new InflateException(r7.toString());
            r0.initCause(e);
            throw r0;
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem r3) {
        L6:
            e = move-exception;
            throw new RuntimeException(e);
        L3:
            if (this.mMethod.getReturnType() == Boolean.TYPE) goto L5;
            this.mMethod.invoke(this.mRealOwner, new Object[]{r3});     // Catch: Exception -> L6
            return true;
        L5:
            return ((Boolean) this.mMethod.invoke(this.mRealOwner, new Object[]{r3})).booleanValue();
        }
    }

    public class MenuState {
        private static final int defaultGroupId = 0;
        private static final int defaultItemCategory = 0;
        private static final int defaultItemCheckable = 0;
        private static final boolean defaultItemChecked = false;
        private static final boolean defaultItemEnabled = true;
        private static final int defaultItemId = 0;
        private static final int defaultItemOrder = 0;
        private static final boolean defaultItemVisible = true;
        private int groupCategory;
        private int groupCheckable;
        private boolean groupEnabled;
        private int groupId;
        private int groupOrder;
        private boolean groupVisible;
        ActionProvider itemActionProvider;
        private String itemActionProviderClassName;
        private String itemActionViewClassName;
        private int itemActionViewLayout;
        private boolean itemAdded;
        private int itemAlphabeticModifiers;
        private char itemAlphabeticShortcut;
        private int itemCategoryOrder;
        private int itemCheckable;
        private boolean itemChecked;
        private CharSequence itemContentDescription;
        private boolean itemEnabled;
        private int itemIconResId;
        private ColorStateList itemIconTintList;
        private PorterDuff.Mode itemIconTintMode;
        private int itemId;
        private String itemListenerMethodName;
        private int itemNumericModifiers;
        private char itemNumericShortcut;
        private int itemShowAsAction;
        private CharSequence itemTitle;
        private CharSequence itemTitleCondensed;
        private CharSequence itemTooltipText;
        private boolean itemVisible;
        private Menu menu;
        final /* synthetic */ SupportMenuInflater this$0;

        public MenuState(SupportMenuInflater r1, Menu r2) {
            this.this$0 = r1;
            this.itemIconTintList = null;
            this.itemIconTintMode = null;
            this.menu = r2;
            resetGroup();
        }

        private char getShortcut(String r1) {
            if (r1 != null) goto L6;
            return 0;
        L6:
            return r1.charAt(0);
        }

        private <T> T newInstance(String r2, Class<?>[] r3, Object[] r4) {
            Constructor<?> r1 = Class.forName(r2, false, this.this$0.mContext.getClassLoader()).getConstructor(r3);     // Catch: Exception -> L4
            r1.setAccessible(true);     // Catch: Exception -> L4
            return (T) r1.newInstance(r4);
        L4:
            e = move-exception;
            Log.w(SupportMenuInflater.LOG_TAG, "Cannot instantiate class: " + r2, e);
            return null;
        }

        private void setItem(MenuItem r6) {
            MenuItem r0 = r6.setChecked(this.itemChecked).setVisible(this.itemVisible).setEnabled(this.itemEnabled);
            boolean r2 = false;
            if (this.itemCheckable < 1) goto L5;
            boolean r1 = true;
        L6:
            r0.setCheckable(r1).setTitleCondensed(this.itemTitleCondensed).setIcon(this.itemIconResId);
            int r3 = this.itemShowAsAction;
            if (r3 < 0) goto L10;
            r6.setShowAsAction(r3);
        L10:
            if (this.itemListenerMethodName == null) goto L17;
            if (this.this$0.mContext.isRestricted() == true) goto L15;
            r6.setOnMenuItemClickListener(new InflatedOnMenuItemClickListener(this.this$0.getRealOwner(), this.itemListenerMethodName));
            goto L17
        L15:
            throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
        L17:
            if (this.itemCheckable >= 2) goto L19;
        L24:
            String r4 = this.itemActionViewClassName;
            if (r4 == null) goto L27;
            r6.setActionView((View) newInstance(r4, SupportMenuInflater.ACTION_VIEW_CONSTRUCTOR_SIGNATURE, this.this$0.mActionViewConstructorArguments));
            r2 = true;
        L27:
            int r5 = this.itemActionViewLayout;
            if (r5 <= 0) goto L32;
            if (r2 == true) goto L31;
            r6.setActionView(r5);
            goto L32
        L31:
            Log.w(SupportMenuInflater.LOG_TAG, "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
        L32:
            ActionProvider r7 = this.itemActionProvider;
            if (r7 == null) goto L35;
            MenuItemCompat.setActionProvider(r6, r7);
        L35:
            MenuItemCompat.setContentDescription(r6, this.itemContentDescription);
            MenuItemCompat.setTooltipText(r6, this.itemTooltipText);
            MenuItemCompat.setAlphabeticShortcut(r6, this.itemAlphabeticShortcut, this.itemAlphabeticModifiers);
            MenuItemCompat.setNumericShortcut(r6, this.itemNumericShortcut, this.itemNumericModifiers);
            PorterDuff.Mode r8 = this.itemIconTintMode;
            if (r8 == null) goto L38;
            MenuItemCompat.setIconTintMode(r6, r8);
        L38:
            ColorStateList r9 = this.itemIconTintList;
            if (r9 == null) goto L42;
            MenuItemCompat.setIconTintList(r6, r9);
            return;
        L42:
            return;
        L19:
            if ((r6 instanceof MenuItemImpl) == false) goto L22;
            ((MenuItemImpl) r6).setExclusiveCheckable(true);
            goto L24
        L22:
            if ((r6 instanceof MenuItemWrapperICS) == false) goto L24;
            ((MenuItemWrapperICS) r6).setExclusiveCheckable(true);
            goto L24
        L5:
            r1 = false;
            goto L6
        }

        public void addItem() {
            this.itemAdded = true;
            setItem(this.menu.add(this.groupId, this.itemId, this.itemCategoryOrder, this.itemTitle));
        }

        public SubMenu addSubMenuItem() {
            this.itemAdded = true;
            SubMenu r0 = this.menu.addSubMenu(this.groupId, this.itemId, this.itemCategoryOrder, this.itemTitle);
            setItem(r0.getItem());
            return r0;
        }

        public boolean hasAddedItem() {
            return this.itemAdded;
        }

        public void readGroup(AttributeSet r3) {
            TypedArray r4 = this.this$0.mContext.obtainStyledAttributes(r3, R.styleable.MenuGroup);
            this.groupId = r4.getResourceId(R.styleable.MenuGroup_android_id, 0);
            this.groupCategory = r4.getInt(R.styleable.MenuGroup_android_menuCategory, 0);
            this.groupOrder = r4.getInt(R.styleable.MenuGroup_android_orderInCategory, 0);
            this.groupCheckable = r4.getInt(R.styleable.MenuGroup_android_checkableBehavior, 0);
            this.groupVisible = r4.getBoolean(R.styleable.MenuGroup_android_visible, true);
            this.groupEnabled = r4.getBoolean(R.styleable.MenuGroup_android_enabled, true);
            r4.recycle();
        }

        public void readItem(AttributeSet r7) {
            TintTypedArray r8 = TintTypedArray.obtainStyledAttributes(this.this$0.mContext, r7, R.styleable.MenuItem);
            this.itemId = r8.getResourceId(R.styleable.MenuItem_android_id, 0);
            this.itemCategoryOrder = (r8.getInt(R.styleable.MenuItem_android_menuCategory, this.groupCategory) & SupportMenu.CATEGORY_MASK) | (r8.getInt(R.styleable.MenuItem_android_orderInCategory, this.groupOrder) & 65535);
            this.itemTitle = r8.getText(R.styleable.MenuItem_android_title);
            this.itemTitleCondensed = r8.getText(R.styleable.MenuItem_android_titleCondensed);
            this.itemIconResId = r8.getResourceId(R.styleable.MenuItem_android_icon, 0);
            this.itemAlphabeticShortcut = getShortcut(r8.getString(R.styleable.MenuItem_android_alphabeticShortcut));
            this.itemAlphabeticModifiers = r8.getInt(R.styleable.MenuItem_alphabeticModifiers, 4096);
            this.itemNumericShortcut = getShortcut(r8.getString(R.styleable.MenuItem_android_numericShortcut));
            this.itemNumericModifiers = r8.getInt(R.styleable.MenuItem_numericModifiers, 4096);
            if (r8.hasValue(R.styleable.MenuItem_android_checkable) == false) goto L5;
            this.itemCheckable = r8.getBoolean(R.styleable.MenuItem_android_checkable, false) ? 1 : 0;
        L6:
            this.itemChecked = r8.getBoolean(R.styleable.MenuItem_android_checked, false);
            this.itemVisible = r8.getBoolean(R.styleable.MenuItem_android_visible, this.groupVisible);
            this.itemEnabled = r8.getBoolean(R.styleable.MenuItem_android_enabled, this.groupEnabled);
            this.itemShowAsAction = r8.getInt(R.styleable.MenuItem_showAsAction, -1);
            this.itemListenerMethodName = r8.getString(R.styleable.MenuItem_android_onClick);
            this.itemActionViewLayout = r8.getResourceId(R.styleable.MenuItem_actionLayout, 0);
            this.itemActionViewClassName = r8.getString(R.styleable.MenuItem_actionViewClass);
            String r0 = r8.getString(R.styleable.MenuItem_actionProviderClass);
            this.itemActionProviderClassName = r0;
            if (r0 == null) goto L9;
            boolean r3 = true;
        L11:
            if (r3 == true) goto L13;
        L17:
            if (r3 == false) goto L19;
            Log.w(SupportMenuInflater.LOG_TAG, "Ignoring attribute 'actionProviderClass'. Action view already specified.");
        L19:
            this.itemActionProvider = null;
        L20:
            this.itemContentDescription = r8.getText(R.styleable.MenuItem_contentDescription);
            this.itemTooltipText = r8.getText(R.styleable.MenuItem_tooltipText);
            if (r8.hasValue(R.styleable.MenuItem_iconTintMode) == false) goto L23;
            this.itemIconTintMode = DrawableUtils.parseTintMode(r8.getInt(R.styleable.MenuItem_iconTintMode, -1), this.itemIconTintMode);
        L25:
            if (r8.hasValue(R.styleable.MenuItem_iconTint) == false) goto L27;
            this.itemIconTintList = r8.getColorStateList(R.styleable.MenuItem_iconTint);
        L28:
            r8.recycle();
            this.itemAdded = false;
            return;
        L27:
            this.itemIconTintList = null;
            goto L28
        L23:
            this.itemIconTintMode = null;
            goto L25
        L13:
            if (this.itemActionViewLayout != 0) goto L17;
            if (this.itemActionViewClassName != null) goto L17;
            this.itemActionProvider = (ActionProvider) newInstance(r0, SupportMenuInflater.ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE, this.this$0.mActionProviderConstructorArguments);
            goto L20
        L9:
            r3 = false;
            goto L11
        L5:
            this.itemCheckable = this.groupCheckable;
            goto L6
        }

        public void resetGroup() {
            this.groupId = 0;
            this.groupCategory = 0;
            this.groupOrder = 0;
            this.groupCheckable = 0;
            this.groupVisible = true;
            this.groupEnabled = true;
        }
    }

    static {
        Class<?>[] r0 = {Context.class};
        ACTION_VIEW_CONSTRUCTOR_SIGNATURE = r0;
        ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE = r0;
    }

    public SupportMenuInflater(Context r1) {
        super(r1);
        this.mContext = r1;
        Object[] r2 = {r1};
        this.mActionViewConstructorArguments = r2;
        this.mActionProviderConstructorArguments = r2;
    }

    private Object findRealOwner(Object r2) {
        if ((r2 instanceof Activity) == false) goto L6;
        return r2;
    L6:
        if ((r2 instanceof ContextWrapper) == true) goto L8;
        return r2;
    L8:
        return findRealOwner(((ContextWrapper) r2).getBaseContext());
    }

    private void parseMenu(XmlPullParser r13, AttributeSet r14, Menu r15) {
        MenuState r0 = new MenuState(this, r15);
        int r16 = r13.getEventType();
    L4:
        if (r16 == 2) goto L5;
        r16 = r13.next();
        if (r16 != 1) goto L4;
    L12:
        boolean r6 = false;
        boolean r7 = false;
        String r8 = null;
    L13:
        if (r6 == true) goto L56;
        if (r16 == 1) goto L55;
        if (r16 != 2) goto L18;
        if (r7 == true) goto L53;
        String r17 = r13.getName();
        if (r17.equals(XML_GROUP) == false) goto L47;
        r0.readGroup(r14);
        goto L53
    L47:
        if (r17.equals(XML_ITEM) == false) goto L50;
        r0.readItem(r14);
        goto L53
    L50:
        if (r17.equals(XML_MENU) == false) goto L52;
        parseMenu(r13, r14, r0.addSubMenuItem());
        goto L53
    L52:
        r8 = r17;
        r7 = true;
    L53:
        r16 = r13.next();
        goto L13
    L18:
        if (r16 != 3) goto L53;
        String r18 = r13.getName();
        if (r7 == false) goto L26;
        if (r18.equals(r8) == false) goto L26;
        r7 = false;
        r8 = null;
    L26:
        if (r18.equals(XML_GROUP) == false) goto L29;
        r0.resetGroup();
        goto L53
    L29:
        if (r18.equals(XML_ITEM) == false) goto L39;
        if (r0.hasAddedItem() == true) goto L53;
        ActionProvider r19 = r0.itemActionProvider;
        if (r19 != null) goto L35;
    L37:
        r0.addItem();
        goto L53
    L35:
        if (r19.hasSubMenu() == false) goto L37;
        r0.addSubMenuItem();
        goto L53
    L39:
        if (r18.equals(XML_MENU) == false) goto L53;
        r6 = true;
        goto L53
    L55:
        throw new RuntimeException("Unexpected end of document");
    L56:
        return;
    L5:
        String r110 = r13.getName();
        if (r110.equals(XML_MENU) == false) goto L9;
        r16 = r13.next();
        goto L12
    L9:
        throw new RuntimeException("Expecting menu, got ".concat(r110));
    }

    public Object getRealOwner() {
        if (this.mRealOwner != null) goto L6;
        this.mRealOwner = findRealOwner(this.mContext);
    L6:
        return this.mRealOwner;
    }

    @Override // android.view.MenuInflater
    public void inflate(@LayoutRes int r4, Menu r5) {
        if ((r5 instanceof SupportMenu) == true) goto L6;
        super.inflate(r4, r5);
        return;
    L6:
        XmlResourceParser r1 = null;
        r1 = this.mContext.getResources().getLayout(r4);     // Catch: Throwable -> L11 IOException -> L13 XmlPullParserException -> L15
        parseMenu(r1, Xml.asAttributeSet(r1), r5);     // Catch: Throwable -> L11 IOException -> L13 XmlPullParserException -> L15
        if (r1 == null) goto L26;
        r1.close();
        return;
    L26:
        return;
    L11:
        th = move-exception;
        if (r1 == null) goto L23;
        r1.close();
    L23:
        throw th;
    L13:
        e = move-exception;
        throw new InflateException("Error inflating menu XML", e);     // Catch: Throwable -> L11
    L15:
        e = move-exception;
        throw new InflateException("Error inflating menu XML", e);     // Catch: Throwable -> L11
    }
}
