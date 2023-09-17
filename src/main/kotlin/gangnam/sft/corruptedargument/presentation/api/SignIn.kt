package gangnam.sft.corruptedargument.presentation.api

import gangnam.sft.corruptedargument.service.UserRequest

data class SignIn(val name: String) {

    fun toUserRequest() = UserRequest(name = this.name)

}