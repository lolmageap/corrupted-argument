package gangnam.sft.corruptedargument.service

import gangnam.sft.corruptedargument.domain.user.User

data class UserServiceRequest(val name: String) {
    fun toUser() = User(name = this.name)
}

data class UserServiceResponse(val name: String) {
    companion object{
        fun toUserResponse(user: User) = UserServiceResponse(name = user.name)
    }
}