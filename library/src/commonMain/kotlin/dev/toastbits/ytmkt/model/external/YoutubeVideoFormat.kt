package dev.toastbits.ytmkt.model.external

import kotlinx.serialization.Serializable

@Serializable
data class YoutubeVideoFormat(
    val itag: Int?,
    val mimeType: String,
    val bitrate: Int,
    val url: String?,
    val audioTrack: AudioTrack? = null,
    val audioTrackType: String? = null,
    val loudness_db: Float? = null,
) {
    fun isDefault(): Boolean =
        audioTrack?.audioIsDefault == true || audioTrackType != "DUBBED"

    fun isAudioOnly(): Boolean =
        mimeType.startsWith("audio")

    override fun toString(): String =
        "YoutubeVideoFormat(itag=$itag, mimeType=$mimeType, bitrate=$bitrate, loudness_db=$loudness_db, url=$url)"

    @Serializable
    data class AudioTrack(val audioIsDefault: Boolean)
}

@Serializable
internal data class YoutubeFormatsResponse(
    val playabilityStatus: PlayabilityStatus,
    val streamingData: StreamingData?,
    val playerConfig: PlayerConfig?
) {
    @Serializable
    data class StreamingData(val formats: List<YoutubeVideoFormat>? = null, val adaptiveFormats: List<YoutubeVideoFormat>)
    @Serializable
    data class PlayabilityStatus(val status: String)

    @Serializable
    data class PlayerConfig(val audioConfig: AudioConfig?)
    @Serializable
    data class AudioConfig(val loudnessDb: Float?)
}
