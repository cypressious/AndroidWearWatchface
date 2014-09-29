package com.google.android.clockwork.watchfaces;

import android.app.Activity;
import android.content.ComponentName;
import android.os.Parcel;
import android.os.Parcelable;

public class WatchFaceStyle implements Parcelable {
    public final int ambientPeekMode;
    public final int backgroundVisibility;
    public final int cardPeekMode;
    public final int cardProgressMode;
    public final ComponentName component;
    public final int hotwordIndicatorGravity;
    public final int peekOpacityMode;
    public final boolean showSystemUiTime;
    public final int statusBarGravity;
    public final int viewProtectionMode;

    private WatchFaceStyle(
            ComponentName paramComponentName, int paramInt1, int paramInt2, int paramInt3,
            boolean paramBoolean, int paramInt4, int paramInt5, int paramInt6, int paramInt7,
            int paramInt8) {
        this.component = paramComponentName;
        this.cardPeekMode = paramInt1;
        this.cardProgressMode = paramInt2;
        this.backgroundVisibility = paramInt3;
        this.showSystemUiTime = paramBoolean;
        this.ambientPeekMode = paramInt4;
        this.peekOpacityMode = paramInt5;
        this.viewProtectionMode = paramInt6;
        this.statusBarGravity = paramInt7;
        this.hotwordIndicatorGravity = paramInt8;
    }

    private WatchFaceStyle(Parcel paramParcel) {
        this.component = paramParcel.readParcelable(ComponentName.class.getClassLoader());
        this.cardPeekMode = paramParcel.readInt();
        this.cardProgressMode = paramParcel.readInt();
        this.backgroundVisibility = paramParcel.readInt();
        boolean[] arrayOfBoolean = new boolean[1];
        paramParcel.readBooleanArray(arrayOfBoolean);
        this.showSystemUiTime = arrayOfBoolean[0];
        this.ambientPeekMode = paramParcel.readInt();
        this.peekOpacityMode = paramParcel.readInt();
        this.viewProtectionMode = paramParcel.readInt();
        this.statusBarGravity = paramParcel.readInt();
        this.hotwordIndicatorGravity = paramParcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        paramParcel.writeParcelable(this.component, paramInt);
        paramParcel.writeInt(this.cardPeekMode);
        paramParcel.writeInt(this.cardProgressMode);
        paramParcel.writeInt(this.backgroundVisibility);
        boolean[] arrayOfBoolean = new boolean[1];
        arrayOfBoolean[0] = this.showSystemUiTime;
        paramParcel.writeBooleanArray(arrayOfBoolean);
        paramParcel.writeInt(this.ambientPeekMode);
        paramParcel.writeInt(this.peekOpacityMode);
        paramParcel.writeInt(this.viewProtectionMode);
        paramParcel.writeInt(this.statusBarGravity);
        paramParcel.writeInt(this.hotwordIndicatorGravity);
    }

    public static class Builder {
        private int mAmbientPeekMode = 0;
        private int mBackgroundVisibility = 1;
        private int mCardPeekMode = 0;
        private int mCardProgressMode = 0;
        private ComponentName mComponent;
        private int mHotwordIndicatorGravity = 0;
        private int mPeekOpacityMode = 0;
        private boolean mShowSystemUiTime = false;
        private int mStatusBarGravity = 0;
        private int mViewProtectionMode = 0;

        public static Builder forActivity(Activity paramActivity) {
            if (paramActivity == null)
                throw new IllegalArgumentException("activity must not be null.");
            return forComponentName(new ComponentName(paramActivity, paramActivity.getClass()));
        }

        public static Builder forComponentName(ComponentName paramComponentName) {
            if (paramComponentName == null)
                throw new IllegalArgumentException("component must not be null.");
            Builder localBuilder = new Builder();
            localBuilder.mComponent = paramComponentName;
            return localBuilder;
        }

        public WatchFaceStyle build() {
            return new WatchFaceStyle(this.mComponent, this.mCardPeekMode, this.mCardProgressMode,
                                      this.mBackgroundVisibility, this.mShowSystemUiTime,
                                      this.mAmbientPeekMode, this.mPeekOpacityMode,
                                      this.mViewProtectionMode, this.mStatusBarGravity,
                                      this.mHotwordIndicatorGravity);
        }

        public Builder setBackgroundVisibility(int paramInt) {
            switch (paramInt) {
                default:
                    throw new IllegalArgumentException(
                            "backgroundVisibility must be BACKGROUND_VISIBILITY_INTERRUPTIVE or BACKGROUND_VISIBILITY_PERSISTENT");
                case 0:
                case 1:
            }
            this.mBackgroundVisibility = paramInt;
            return this;
        }

        public Builder setCardPeekMode(int paramInt) {
            switch (paramInt) {
                default:
                    throw new IllegalArgumentException(
                            "peekMode must be PEEK_MODE_VARIABLE or PEEK_MODE_SHORT");
                case 0:
                case 1:
            }
            this.mCardPeekMode = paramInt;
            return this;
        }

        public Builder setCardProgressMode(int paramInt) {
            switch (paramInt) {
                default:
                    throw new IllegalArgumentException(
                            "progressMode must be PROGRESS_MODE_NONE or PROGRESS_MODE_DISPLAY");
                case 0:
                case 1:
            }
            this.mCardProgressMode = paramInt;
            return this;
        }

        public Builder setShowSystemUiTime(boolean paramBoolean) {
            this.mShowSystemUiTime = paramBoolean;
            return this;
        }
    }

    @SuppressWarnings("unchecked")
    public static final Parcelable.Creator<WatchFaceStyle> CREATOR = new Parcelable.Creator() {
        public WatchFaceStyle createFromParcel(Parcel paramParcel) {
            return new WatchFaceStyle(paramParcel);
        }

        public WatchFaceStyle[] newArray(int paramInt) {
            return new WatchFaceStyle[paramInt];
        }
    };
}

