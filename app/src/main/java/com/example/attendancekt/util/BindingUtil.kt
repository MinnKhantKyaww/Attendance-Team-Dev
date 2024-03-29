package com.example.attendancekt.util

import android.net.Uri
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isInvisible
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.attendancekt.R
import com.example.attendancekt.model.entity.ChatMessage
import com.example.attendancekt.model.entity.Member
import com.example.attendancekt.model.entity.MessageType
import kotlin.math.abs

class BindingUtil {

    companion object {
        /*@BindingAdapter("android:text")
    fun setNumber(textView: TextView, value: Long) {
        textView.text = value.toString()
    }

    @BindingAdapter("android:text")
    fun setNumber(editText: EditText, value: Int) {
        editText.setText(value.toString())
    }

    @InverseBindingAdapter(attribute = "android:text")
    fun getNumber(editText: EditText): Int {
        val value: String = editText.text.toString()
        return if(value.isEmpty()) 0 else value.toInt()
    }*/
        @JvmStatic
        @BindingAdapter("path")
        fun setImageUri(imageView: ImageView, imageFilePath: String?) {
            if (imageFilePath != null && imageFilePath.isNotEmpty()) {
                imageView.setImageURI(Uri.parse(imageFilePath))
            }
        }

        @BindingAdapter("visibility")
        fun View.setVisibile(member: MutableLiveData<Member?>) {
            visibility = if (member.value?.id!! > 0) {
                View.VISIBLE
            } else View.INVISIBLE
        }

        @JvmStatic
        @BindingAdapter("android:text")
        fun setMessage(textView: TextView, msg: ChatMessage?) {
            msg?.also {
                when(it.messageType) {
                    MessageType.JOIN -> textView.text = textView.context.getString(R.string.chat_info_join, it.sender)
                    MessageType.LEAVE -> textView.text = textView.context.getString(R.string.chat_info_leave, it.sender)
                    else -> {}
                }
            }
        }


    }
}