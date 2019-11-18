package com.bennyhuo.github.view.common

import android.os.Bundle
import com.bennyhuo.github.model.account.AccountManager
import com.bennyhuo.github.view.config.FragmentPage
import com.bennyhuo.github.view.fragment.subfragments.RepoListFragment
import com.bennyhuo.github.view.fragment.subfragments.RepoListFragmentBuilder

/**
 * Created by CHULEI on 2019/11/18.
 */
class RepoFragment : CommonViewPagerFragment() {
    override fun getFragmentPagesNotLoggedIn(): List<FragmentPage> {
        return listOf(
                FragmentPage(RepoListFragment(), "All")
        )
    }

    override fun getFragmentPagesLoggedIn(): List<FragmentPage> {
        return listOf(
                FragmentPage(RepoListFragment().apply {
                    arguments = Bundle().apply {
                        putParcelable(RepoListFragmentBuilder.OPTIONAL_USER, AccountManager.currentUser)

                    }
                }, "My"),
                FragmentPage(RepoListFragment(), "All")
        )
    }
}