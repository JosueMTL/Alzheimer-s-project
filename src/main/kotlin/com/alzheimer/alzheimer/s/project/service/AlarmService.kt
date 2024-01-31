package com.alzheimer.alzheimer.s.project.service

import com.alzheimer.alzheimer.s.project.model.Alarm
import com.alzheimer.alzheimer.s.project.repository.AlarmRepository
import com.alzheimer.alzheimer.s.project.repository.CaragiversRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import org.springframework.data.domain.Pageable
import java.util.Optional

@Service
class AlarmService {
    @Autowired
    lateinit var alarmRepository: AlarmRepository

    @Autowired
    lateinit var caragiversRepository: CaragiversRepository

    fun list(pageable: Pageable, alarm: Alarm): kotlin.collections.List<Alarm> {
        return alarmRepository.findByTitleAndTimeAndRepeatAndDateAndCaregiversId(
            alarm.title,
            alarm.time,
            alarm.repeat,
            alarm.date,
            alarm.caregiversId,
            pageable
        ).toMutableList()
    }



    fun listById(id: Long): Optional<Alarm> {
        return alarmRepository.findById(id)
    }

    fun save(modelo: Alarm): Alarm {
        try {
            modelo.caregiversId?.let { caregiversId ->
                caragiversRepository.findById(caregiversId)
                    ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "Id no encontrado")
            }
            return alarmRepository.save(modelo)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.message)
        }
    }


    fun update(alarm: Alarm): Alarm {
        try {
            val existingAlarm = alarm.id?.let { alarmRepository.findById(it) }
            if (existingAlarm != null) {
                if (existingAlarm.isPresent) {
                    return alarmRepository.save(alarm)
                } else {
                    throw ResponseStatusException(HttpStatus.NOT_FOUND, "ID no existe")
                }
            }
            // Agrega el return para manejar el caso cuando existingAlarm es null
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "ID no existe")
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.message)
        }
    }



    fun delete(id: Long?): Boolean {
        try {
            val response = alarmRepository.findById(id!!)
                ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "ID no existe")
            alarmRepository.deleteById(id)
            return true
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.message)
        }
    }


}
