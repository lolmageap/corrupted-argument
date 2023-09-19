package gangnam.sft.corruptedargument.service

import gangnam.sft.corruptedargument.domain.user.User
import java.time.LocalDate

data class UserRequest(
    val name: String,
    val password: String,
    val email: String,
    val birth: LocalDate?,
) {
    fun toUser() = User(
        name = this.name,
        password = this.password,
        email = this.email,
        birth = this.birth,
    )
}

data class UserUpdate(
    val name: String,
    val birth: LocalDate?,
)

data class UserResponse(val name: String) {
    companion object{
        fun toUserResponse(user: User) = UserResponse(name = user.name)
    }
}