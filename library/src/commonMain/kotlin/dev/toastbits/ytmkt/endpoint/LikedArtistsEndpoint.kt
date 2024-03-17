package dev.toastbits.ytmkt.endpoint

import dev.toastbits.ytmkt.model.AuthenticatedApiEndpoint
import dev.toastbits.ytmkt.model.external.mediaitem.YtmArtist

abstract class LikedArtistsEndpoint: AuthenticatedApiEndpoint() {
    abstract suspend fun getLikedArtists(): Result<List<YtmArtist>>
}
