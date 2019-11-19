package com.bennyhuo.github.view.fragment

import android.os.Bundle
import com.bennyhuo.github.model.account.AccountManager
import com.bennyhuo.github.model.people.PeoplePage
import com.bennyhuo.github.view.common.CommonViewPagerFragment
import com.bennyhuo.github.view.config.FragmentPage
import com.bennyhuo.github.view.fragment.subfragments.PeopleListFragment
import com.bennyhuo.github.view.fragment.subfragments.PeopleListFragmentBuilder

/**
 * Created by benny on 7/16/17.
 */
class PeopleFragment : CommonViewPagerFragment() {
    override fun getFragmentPagesLoggedIn(): List<FragmentPage> = listOf(
            FragmentPage(PeopleListFragment().also {
                it.arguments = Bundle().apply {
                    putString(PeopleListFragmentBuilder.OPTIONAL_LOGIN, AccountManager.currentUser?.login)
                    putString(PeopleListFragmentBuilder.REQUIRED_TYPE, PeoplePage.Type.FOLLOWER.name)
                }
            }, "Followers"),

            FragmentPage(PeopleListFragment().also {
                it.arguments = Bundle().apply {
                    putString(PeopleListFragmentBuilder.OPTIONAL_LOGIN, AccountManager.currentUser!!.login)
                    putString(PeopleListFragmentBuilder.REQUIRED_TYPE, PeoplePage.Type.FOLLOWING.name)
                }
            }, "Following"),

            FragmentPage(PeopleListFragment().also {
                it.arguments = Bundle().apply {
                    putString(PeopleListFragmentBuilder.REQUIRED_TYPE, PeoplePage.Type.ALL.name)
                }
            }, "All")
    )

    override fun getFragmentPagesNotLoggedIn(): List<FragmentPage> {
        return listOf(
                FragmentPage(PeopleListFragment().also {
                    it.arguments = Bundle().apply {
                        putString(PeopleListFragmentBuilder.REQUIRED_TYPE, PeoplePage.Type.ALL.name)
                    }
                }, "All")
        )
    }

}