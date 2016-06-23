package com.trycatchkamal.android;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import com.google.android.R;

/*
* Custom layout that arranges child views in a polygon like figure.
* PolygonLayout takes care of arranging the child views in the vertices based
* on the number of child views added to the PolygonLayout.
* */
public class PolygonLayout extends ViewGroup {
    private static final float MIN_VALUE = 0f;
    private static final float MAX_VALUE = 1f;
    private static final int ANIM_DURATION = 300;
    private static final float POSITION_MULTIPLIER = .6f;

    private int maxX = 0, maxY = 0;
    // Adjust this to increase/decrease the size of the edges
    private float radiusRatio = -.30f;
    // Adjust this value to increase/decrease the size of vertices
    private float childViewWidth = 280f;
    // Adjust this value to increase/decrease the size of vertices
    private float childViewHeight = 280f;
    private final Context context;
    private final AnimationSet set = new AnimationSet(true);
    private final RectF rect = new RectF();
    private final LayoutAnimationController controller = new LayoutAnimationController(set, .5f);

    public PolygonLayout(Context context) {
        super(context);
        this.context = context;
    }

    public PolygonLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    public PolygonLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        //To measure the screen width & height only once
        if (maxX == 0 || maxY == 0) {
            measureMaxXAndMaxY();
        }
        for (int childIndex = 0; childIndex < getChildCount(); childIndex++) {
            float centreX, centreY;

            View child = getChildAt(childIndex);
            float w = getWidth();
            float h = getHeight();
            float x = (float) getWidth() / 2.0f;
            float y = (float) getHeight() / 2.0f;
            float radius;
            if (w > h) {
                radius = h * radiusRatio;
            } else {
                radius = w * radiusRatio;
            }
            // Layout the child view in the geometrical figure
            double section = (childIndex * 2 + 1 + Math.PI / 2) * Math.PI / getChildCount();
            centreX = (float) (x + radius * Math.cos(section));
            centreY = (float) (y + radius * Math.sin(section));

            rect.left = -childViewWidth * POSITION_MULTIPLIER + centreX;
            rect.right = childViewWidth * POSITION_MULTIPLIER + centreX;
            rect.top = -childViewHeight * POSITION_MULTIPLIER + centreY;
            rect.bottom = childViewHeight * POSITION_MULTIPLIER + centreY;
            child.layout((int) rect.left, (int) rect.top, (int) rect.right, (int) rect.bottom);

            // Animation to launch child from bottom right corner
            ObjectAnimator objectAnimatorX = ObjectAnimator.ofFloat(child, View.SCALE_X, MIN_VALUE, MAX_VALUE);
            ObjectAnimator objectAnimatorPosX = ObjectAnimator.ofFloat(child, View.TRANSLATION_X, maxX, MIN_VALUE);
            objectAnimatorPosX.setDuration(ANIM_DURATION).start();
            objectAnimatorX.setDuration(ANIM_DURATION).start();

            ObjectAnimator objectAnimatorY = ObjectAnimator.ofFloat(child, View.SCALE_Y, MIN_VALUE, MAX_VALUE);
            ObjectAnimator objectAnimatorPosY = ObjectAnimator.ofFloat(child, View.TRANSLATION_Y, maxY, MIN_VALUE);
            objectAnimatorPosY.setDuration(ANIM_DURATION).start();
            objectAnimatorY.setDuration(ANIM_DURATION).start();
        }
        // Post-Animation to give little wobble effect
        Animation animation = AnimationUtils.loadAnimation(getContext(), R.anim.events_ui_wobble_effect);
        animation.setDuration(ANIM_DURATION);
        set.addAnimation(animation);
        this.setLayoutAnimation(controller);
    }

    private void measureMaxXAndMaxY() {
        DisplayMetrics metrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        windowManager.getDefaultDisplay().getMetrics(metrics);
        maxX = metrics.widthPixels;
        maxY = metrics.heightPixels;
    }

    public void setRadiusRatio(float radiusRatio) {
        this.radiusRatio = radiusRatio;
    }

    public float getRadiusRatio() {
        return radiusRatio;
    }

    public float getChildViewWidth() {
        return childViewWidth;
    }

    public void setChildViewWidth(float childViewWidth) {
        this.childViewWidth = childViewWidth;
    }

    public float getChildViewHeight() {
        return childViewHeight;
    }

    public void setChildViewHeight(float childViewHeight) {
        this.childViewHeight = childViewHeight;
    }
}
