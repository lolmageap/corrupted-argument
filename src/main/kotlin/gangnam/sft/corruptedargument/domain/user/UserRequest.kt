package gangnam.sft.corruptedargument.domain.user

data class UserRequest(val name: String) {

    fun toUser() = User(name = this.name)

}