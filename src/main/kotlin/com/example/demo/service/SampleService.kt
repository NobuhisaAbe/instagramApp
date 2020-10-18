package com.example.demo.service

import com.example.demo.mapper.SampleMapper
import com.example.demo.model.SampleModel
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class SampleService(private val mapper: SampleMapper) {

    fun find() : List<SampleModel> = mapper.find()

}