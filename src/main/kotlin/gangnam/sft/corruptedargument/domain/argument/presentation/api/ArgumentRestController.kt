package gangnam.sft.corruptedargument.domain.argument.presentation.api

import gangnam.sft.corruptedargument.domain.argument.application.ArgumentService
import gangnam.sft.corruptedargument.domain.argument.presentation.ArgumentRequest
import gangnam.sft.corruptedargument.domain.argument.presentation.ArgumentResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/argument")
class ArgumentRestController(private val argumentService: ArgumentService) {

    @PostMapping("/")
    fun addArticle(@RequestBody request: ArgumentRequest) {
        argumentService.saveArgument(request.toServiceRequest())
    }

    @GetMapping("/{argument-id}")
    fun getArticle(@PathVariable("argument-id") id: Long): ResponseEntity<ArgumentResponse> {
        val argument = argumentService.findArgument(id)
        val response = ArgumentResponse.from(argument)
        return ResponseEntity.ok(response)
    }

}