package gangnam.sft.corruptedargument.presentation.api

import gangnam.sft.corruptedargument.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user")
class UserController(private val userService: UserService) {

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    fun signUp(@RequestBody signUp: SignUp) = userService.signUp(signUp.toUserRequest())

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    fun signIn(@RequestBody signIn: SignIn) = userService.signIn(signIn)

}