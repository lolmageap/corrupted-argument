package gangnam.sft.corruptedargument.presentation.api

import gangnam.sft.corruptedargument.service.UserRequest
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Past
import jakarta.validation.constraints.Pattern
import java.time.LocalDateTime


data class SignUp(
    @field:Email
    val email: String,

    @field:Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[!@#$%^&*])(?=.*[0-9]).{6,16}$")
    val password: String,

    @field:Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[!@#$%^&*])(?=.*[0-9]).{6,16}$")
    val confirmPassword: String,

    @field:NotBlank
    val name: String,

    @field:Past
    val birth: LocalDateTime?,
) {
    fun toUserRequest() : UserRequest {
        require(password == confirmPassword) {"비밀번호 재입력 오류"}

        return UserRequest(
            name = this.name,
            password = this.password,
            email = this.email,
            birth = this.birth,
        )
    }
}

data class SignIn(
    @field:Email
    val email: String,

    @field:Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[!@#$%^&*])(?=.*[0-9]).{6,16}$")
    val password: String,
) {

}