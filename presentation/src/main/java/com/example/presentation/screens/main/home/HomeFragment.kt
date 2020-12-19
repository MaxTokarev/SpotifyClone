package com.example.presentation.screens.main.home

import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import com.example.presentation.R
import com.example.presentation.databinding.FragmentHomeBinding
import com.example.presentation.helpers.viewBinding
import com.example.presentation.screens.main.home.adapters.listAdapterDelegate
import com.example.presentation.screens.main.home.models.BaseModelImpl
import com.example.presentation.screens.main.home.models.CategoryModel
import com.example.presentation.screens.main.home.models.ContentModel
import com.example.presentation.screens.main.home.models.GenreModel
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject


class HomeFragment : Fragment(R.layout.fragment_home) {

    private val binding by viewBinding(FragmentHomeBinding::bind)

    @Inject
    lateinit var sharedPreferences: SharedPreferences

    private val mainAdapter = ListDelegationAdapter(
        listAdapterDelegate()
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onViewCreated(view, savedInstanceState)

        binding.rvMain.adapter = mainAdapter

        val list = listOf(getListBig(), getListCategory(), getListSmall(), getListBig())

        mainAdapter.items = list
        mainAdapter.notifyDataSetChanged()

        Log.e("TAG", "onViewCreated: ${sharedPreferences.getString("name", "dsafasdf")}")
    }

    private fun getListSmall(): BaseModelImpl {
        val smallContentModel = mutableListOf<ContentModel.BigContentModel>()
        for (i in 0..12) {
            smallContentModel.add(
                ContentModel.BigContentModel(
                    "1",
                    "fasdfsa",
                    "fadsfa",
                    "https://sun9-53.userapi.com/impf/uF7t2omHErm9W1G9lJjj6c_ieebVH5JCfY8N7Q/MWiCgYcWLcw.jpg?size=1080x1080&quality=96&proxy=1&sign=f8e971ccb1dd01511051fa887ae44a30"
                )
            )
        }
        return BaseModelImpl(
            categoryModel = CategoryModel("YEP"),
            bigContentModel = smallContentModel
        )
    }

    private fun getListBig(): BaseModelImpl {
        val smallContentModel = mutableListOf<ContentModel.PlateContentModel>()
        for (i in 0..12) {
            smallContentModel.add(
                ContentModel.PlateContentModel(
                    "1",
                    "fasdfsa",
                    "fadsfa",
                    "https://sun9-53.userapi.com/impf/uF7t2omHErm9W1G9lJjj6c_ieebVH5JCfY8N7Q/MWiCgYcWLcw.jpg?size=1080x1080&quality=96&proxy=1&sign=f8e971ccb1dd01511051fa887ae44a30"
                )
            )
        }
        return BaseModelImpl(
            categoryModel = CategoryModel("YEP"),
            plateContentModel = smallContentModel
        )
    }

    private fun getListCategory(): BaseModelImpl {
        val smallContentModel = mutableListOf<GenreModel>()
        for (i in 0..12) {
            smallContentModel.add(GenreModel("yeppp", Color.CYAN))
        }
        return BaseModelImpl(categoryModel = CategoryModel("YEP"), genreModel = smallContentModel)
    }
}