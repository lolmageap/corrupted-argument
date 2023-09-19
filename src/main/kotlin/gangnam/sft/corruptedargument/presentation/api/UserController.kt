package gangnam.sft.corruptedargument.presentation.api

import gangnam.sft.corruptedargument.presentation.SignIn
import gangnam.sft.corruptedargument.presentation.SignUp
import gangnam.sft.corruptedargument.presentation.UserEdit
import gangnam.sft.corruptedargument.service.UserService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user")
class UserController(private val userService: UserService) {

    @PostMapping("/sign-up")
    @ResponseStatus(value = HttpStatus.CREATED)
    fun signUp(@RequestBody @Valid signUp: SignUp) = userService.signUp(signUp.toUserRequest())

    @PutMapping
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    fun editUser(@RequestBody @Valid userEdit: UserEdit) = userService.editUser(0L, userEdit)

    @PostMapping("/sign-in")
    @ResponseStatus(value = HttpStatus.CREATED)
    fun signIn(@RequestBody signIn: SignIn) = userService.signIn(signIn)

}