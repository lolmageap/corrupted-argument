package gangnam.sft.corruptedargument.jwt

data class TokenResponse(
    val token: String,
    val role: String,
    val userId: Long,
)