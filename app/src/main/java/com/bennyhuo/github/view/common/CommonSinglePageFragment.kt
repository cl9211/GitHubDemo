package com.bennyhuo.github.view.common

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import com.bennyhuo.github.view.MainActivity

/**
 * Created by CHULEI on 2019/11/18.
 */
abstract class CommonSinglePageFragment : Fragment() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity).actionBarController.setupWithViewPager(null)
    }
}