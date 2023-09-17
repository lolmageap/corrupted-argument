package gangnam.sft.corruptedargument.presentation.api

import gangnam.sft.corruptedargument.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user")
class UserController(private val userService: UserService) {

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    fun createUser(@RequestBody signIn: SignIn) = userService.save(signIn.toUserRequest())

}