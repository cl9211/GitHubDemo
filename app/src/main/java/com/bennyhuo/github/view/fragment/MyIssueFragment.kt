package com.bennyhuo.github.view.fragment

import com.bennyhuo.github.view.common.CommonViewPagerFragment
import com.bennyhuo.github.view.config.FragmentPage
import com.bennyhuo.github.view.fragment.subfragments.MyIssueListFragment

/**
 * Created by benny on 7/16/17.
 */
class MyIssueFragment : CommonViewPagerFragment() {
    override fun getFragmentPagesLoggedIn(): List<FragmentPage> = listOf(
            FragmentPage(MyIssueListFragment(), "My")
    )


    override fun getFragmentPagesNotLoggedIn(): List<FragmentPage> = listOf(
            FragmentPage(MyIssueListFragment(), "My")
    )

}