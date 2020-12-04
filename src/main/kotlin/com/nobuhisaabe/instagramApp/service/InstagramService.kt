package com.nobuhisaabe.instagramApp.service

import com.nobuhisaabe.instagramApp.component.InstagramApiComponent
import com.nobuhisaabe.instagramApp.domain.model.Instagram
import com.nobuhisaabe.instagramApp.domain.model.Media
import org.springframework.stereotype.Service
import java.io.IOException

@Service
class InstagramService(
        private val instagramApiComponent: InstagramApiComponent
) {
    /**
     * インスタグラム情報を取得する
     */
    fun getInstagram() : Instagram {
        // インスタグラム情報の取得
        val getInstagramResponse = instagramApiComponent.getInstagram()

        // mediaIdからメディア情報を取得
        var medias: MutableList<Media> = mutableListOf()
        getInstagramResponse.data.forEach { data ->
            val getInstagramMediaResponse = instagramApiComponent.getInstagramMedia(data.id)
            val media: Media = Media(getInstagramMediaResponse.id,getInstagramMediaResponse.mediaType,getInstagramMediaResponse.mediaUrl)
            medias.add(media)
        }

        // インスタグラム情報の生成
        val instagram: Instagram = Instagram(medias)

        return instagram
    }

}