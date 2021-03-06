package com.yanfangxiong.multipagerdemo.tranformer

import android.support.v4.view.ViewPager
import android.view.View

/**
 * @author fxYan
 */
class AlphaPageTransformer(
        private var minAlpha: Float
) : ViewPager.PageTransformer {

    override fun transformPage(page: View?, position: Float) {
        val alpha: Float = when {
            position < -1 -> minAlpha
            position >= -1 && position < 0 -> minAlpha + (1 - minAlpha) * (1 + position)
            position >= 0 && position < 1 -> minAlpha + (1 - minAlpha) * (1 - position)
            else -> minAlpha
        }
        page?.alpha = alpha
    }

}