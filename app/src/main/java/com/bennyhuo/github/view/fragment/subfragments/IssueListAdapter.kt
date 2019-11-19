package com.bennyhuo.github.view.fragment.subfragments

import android.support.v7.widget.RecyclerView
import android.view.View
import com.bennyhuo.github.R
import com.bennyhuo.github.network.entities.Issue
import com.bennyhuo.github.utils.githubTimeToDate
import com.bennyhuo.github.utils.htmlText
import com.bennyhuo.github.utils.view
import com.bennyhuo.github.view.common.CommonListAdapter
import kotlinx.android.synthetic.main.item_issue.view.*
import org.jetbrains.anko.imageResource

/**
 * Created by CHULEI on 2019/11/19.
 */
class IssueListAdapter : CommonListAdapter<Issue>(R.layout.item_issue) {
    override fun onBindData(viewHolder: RecyclerView.ViewHolder, issue: Issue) {
        viewHolder.itemView.apply {
            iconView.imageResource = if (issue.state == "open") R.drawable.ic_issue_open else R.drawable.ic_issue_closed
            titleView.text = issue.title
            timeView.text = githubTimeToDate(issue.created_at).view()
            bodyView.htmlText = issue.body_html
            commentCount.text = issue.comments.toString()
        }
    }

    override fun onItemClicked(itemView: View, item: Issue) {
        // todo
    }
}