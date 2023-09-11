package gangnam.sft.corruptedargument.domain.user

data class UserResponse(val name: String) {

    companion object{
        fun toUserResponse(user: User) = UserResponse(name = user.name)
    }

}