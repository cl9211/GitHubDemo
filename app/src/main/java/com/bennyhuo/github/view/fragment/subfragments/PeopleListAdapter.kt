package com.bennyhuo.github.view.fragment.subfragments

import android.support.v7.widget.RecyclerView
import android.view.View
import com.bennyhuo.github.R
import com.bennyhuo.github.network.entities.User
import com.bennyhuo.github.utils.loadWithGlide
import com.bennyhuo.github.view.common.CommonListAdapter
import kotlinx.android.synthetic.main.item_user.view.*

/**
 * Created by CHULEI on 2019/11/18.
 */
class PeopleListAdapter : CommonListAdapter<User>(R.layout.item_user) {
    override fun onBindData(viewHolder: RecyclerView.ViewHolder, item: User) {
        viewHolder.itemView.apply {
            avatarView.loadWithGlide(item.avatar_url, item.login.first())
            nameView.text = item.login
        }
    }

    override fun onItemClicked(itemView: View, item: User) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}