package com.example.demo

import com.fasterxml.jackson.annotation.JsonValue
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import tools.jackson.databind.JsonNode
import tools.jackson.databind.ObjectMapper

@RestController
class Controller(val repository: BuildHistoryRepository) {

  @PostMapping("/webhook")
  fun handleHook(@RequestBody body: PushHook) {
    println("got hook: $body")
    repository.save(BuildInfo(-1,  body.after))
  }

  @GetMapping("/history", produces = [MediaType.APPLICATION_JSON_VALUE])
  fun getHistory(): List<BuildInfo> {
    return repository.findAll()
  }
}