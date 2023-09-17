package gangnam.sft.corruptedargument.service

import gangnam.sft.corruptedargument.domain.user.User

data class UserRequest(val name: String) {
    fun toUser() = User(name = this.name)
}

data class UserResponse(val name: String) {
    companion object{
        fun toUserResponse(user: User) = UserResponse(name = user.name)
    }
}