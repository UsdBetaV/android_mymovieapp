package app.beta.myanimeapp.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TmdbResponse<T>(
    val dates: RangeDate?,
    val page: String,
    val results: T,
    val total_results: Int,
    val total_pages: Int
) {
    @JsonClass(generateAdapter = true)
    data class RangeDate(
        val maximum: String,
        val minimum: String
    )
}