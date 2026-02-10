package com.example.demo

import org.springframework.data.repository.Repository

interface BuildHistoryRepository: Repository<BuildInfo, Long> {
  fun save(buildInfo: BuildInfo)

  fun findAll(): List<BuildInfo>
}