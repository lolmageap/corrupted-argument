package gangnam.sft.corruptedargument.presentation

import gangnam.sft.corruptedargument.service.UserRequest
import gangnam.sft.corruptedargument.service.UserUpdate
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Past
import jakarta.validation.constraints.Pattern
import java.time.LocalDate



data class SignUp(

    @field:Email
    val email: String,

    @field:Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[!@#$%^&*])(?=.*[0-9]).{6,16}$")
    val password: String,

    @field:Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[!@#$%^&*])(?=.*[0-9]).{6,16}$")
    val confirmPassword: String,

    @field:NotEmpty(message = "이름은 필수입니다.")
    val name: String?,

    @field:Past
    var birth: LocalDate?,
) {
    fun toUserRequest() : UserRequest {
        require(password == confirmPassword) {"비밀번호 재입력 오류"}

        return UserRequest(
            name = this.name!!,
            password = this.password,
            email = this.email,
            birth = this.birth,
        )
    }
}

data class UserEdit(
    @field:NotBlank
    val name: String,

    @field:Past
    val birth: LocalDate?,
) {
    fun toUserUpdate() : UserUpdate {
        return UserUpdate(
            name = this.name,
            birth = this.birth
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