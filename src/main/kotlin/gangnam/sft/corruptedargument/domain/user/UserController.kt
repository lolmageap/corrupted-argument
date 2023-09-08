package gangnam.sft.corruptedargument.domain.user

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(private val userService: UserService) {

    @PostMapping("/")
    @ResponseStatus(value = HttpStatus.CREATED)
    fun createUser(@RequestBody signIn: SignIn) = userService.save(signIn.toUserRequest())

}