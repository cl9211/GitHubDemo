package com.bennyhuo.github.view.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.ToggleButton
import com.bennyhuo.github.R
import com.bennyhuo.github.utils.subscribeIgnoreError
import kotlinx.android.synthetic.main.detail_item.view.*
import kotlinx.android.synthetic.main.item_issue.view.titleView
import org.jetbrains.anko.sdk15.listeners.onClick
import rx.Observable
import kotlin.reflect.KProperty

/**
 * Created by CHULEI on 2019/11/19.
 */

typealias CheckEvent = (Boolean) -> Observable<Boolean>

class ObjectPropertyDelegate<T, R>(val receiver: R,
                                   val getter: ((R) -> T)? = null,
                                   val setter: ((R, T) -> Unit)? = null,
                                   defaultValue: T? = null) {

    private var value: T? = defaultValue

    operator fun getValue(ref: Any, property: KProperty<*>): T {
        return getter?.invoke(receiver) ?: value!!
    }

    operator fun setValue(ref: Any, property: KProperty<*>, value: T) {
        setter?.invoke(receiver, value)
        this.value = value
    }

}

class DetailItemView
@JvmOverloads
constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
        RelativeLayout(context, attrs, defStyleAttr) {

    init {
        View.inflate(context, R.layout.detail_item, this)
    }

    var title by ObjectPropertyDelegate(titleView, TextView::getText, TextView::setText, "")
    var content by ObjectPropertyDelegate(contentView, TextView::getText, TextView::setText, "")
    var icon by ObjectPropertyDelegate(iconView, null, ImageView::setImageResource, 0)
    var operatorIcon by ObjectPropertyDelegate(operatorIconView, null, ToggleButton::setBackgroundResource, 0)
    var isChecked by ObjectPropertyDelegate(operatorIconView, ToggleButton::isChecked, ToggleButton::setChecked)


    var checkEvent: CheckEvent? = null

    init {
        attrs?.let {
            val a = context.obtainStyledAttributes(it, R.styleable.DetailItemView)
            title = a.getString(R.styleable.DetailItemView_item_title)
            content = a.getString(R.styleable.DetailItemView_item_content)
            icon = a.getResourceId(R.styleable.DetailItemView_item_icon, 0)
            operatorIcon = a.getResourceId(R.styleable.DetailItemView_item_op_icon, 0)
            a.recycle()
        }

        onClick {
            checkEvent?.invoke(isChecked)
                    ?.subscribeIgnoreError {
                        isChecked = it
                    }
        }
    }


}