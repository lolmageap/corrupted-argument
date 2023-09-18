package gangnam.sft.corruptedargument.service

import gangnam.sft.corruptedargument.domain.user.User
import java.time.LocalDateTime

data class UserRequest(
    val name: String,
    val password: String,
    val email: String,
    val birth: LocalDateTime?,
) {
    fun toUser() = User(
        name = this.name,
        password = this.password,
        email = this.email,
        birth = this.birth,
    )
}

data class UserResponse(val name: String) {
    companion object{
        fun toUserResponse(user: User) = UserResponse(name = user.name)
    }
}