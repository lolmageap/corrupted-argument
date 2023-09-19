package gangnam.sft.corruptedargument.presentation.api

import gangnam.sft.corruptedargument.presentation.ArgumentInfo
import gangnam.sft.corruptedargument.service.ArgumentService
import gangnam.sft.corruptedargument.presentation.NewArgument
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/argument")
class ArgumentController(private val argumentService: ArgumentService) {

    @PostMapping
    fun addArticle(@RequestBody request: NewArgument) {
        argumentService.saveArgument(request.toServiceRequest())
    }

    @GetMapping("/{argument-id}")
    fun getArticle(@PathVariable("argument-id") id: Long): ResponseEntity<ArgumentInfo> {
        val argument = argumentService.findArgument(id)
        val response = ArgumentInfo.from(argument)
        return ResponseEntity.ok(response)
    }

}