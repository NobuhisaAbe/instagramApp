package com.nobuhisaabe.instagramApp.domain.model

data class Instagram(
        var medias: List<Media>
)

data class Media(
        var id: String,
        var mediaType: String,
        var mediaUrl: String
)