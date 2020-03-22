package com.example.notesapp;

/**
 * Created by kapil on 05/10/18.
 */

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;


import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;



public class BottomNavigationBehavior extends CoordinatorLayout.Behavior<com.google.android.material.tabs.TabLayout> {

    public BottomNavigationBehavior() {
        super();
    }

    public BottomNavigationBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, com.google.android.material.tabs.TabLayout child, View dependency) {
        boolean dependsOn = dependency instanceof FrameLayout;
        return dependsOn;
    }

    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, com.google.android.material.tabs.TabLayout child, View directTargetChild, View target, int nestedScrollAxes) {
        return nestedScrollAxes == ViewCompat.SCROLL_AXIS_VERTICAL;
    }

    @Override
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, com.google.android.material.tabs.TabLayout child, View target, int dx, int dy, int[] consumed) {
        if (dy < 0) {
            showBottomNavigationView(child);
        } else if (dy > 0) {
            hideBottomNavigationView(child);
        }
    }

    private void hideBottomNavigationView(com.google.android.material.tabs.TabLayout view) {
        view.animate().translationY(view.getHeight());
    }

    private void showBottomNavigationView(com.google.android.material.tabs.TabLayout view) {
        view.animate().translationY(0);
    }
}