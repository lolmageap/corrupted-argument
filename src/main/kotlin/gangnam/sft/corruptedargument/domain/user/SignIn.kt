package gangnam.sft.corruptedargument.domain.user

data class SignIn(val name: String) {

    fun toUserRequest() = UserRequest(name = this.name)

}