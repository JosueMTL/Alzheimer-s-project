import com.alzheimer.alzheimer.s.project.model.PatienteInfo
import com.alzheimer.alzheimer.s.project.repository.PatienteInfoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.Date

@Service
class PatienteInfoService {

    @Autowired
    private lateinit var patienteInfoRepository: PatienteInfoRepository

    fun savePatienteInfo(patienteInfo: PatienteInfo) {
        patienteInfoRepository.save(patienteInfo)
    }

    fun getPatienteInfoById(id: Long): PatienteInfo? {
        return patienteInfoRepository.findById(id).orElse(null)
    }

    fun getAllPatienteInfo(): List<PatienteInfo> {
        return patienteInfoRepository.findAll()
    }

    fun updatePatienteInfo(patienteInfo: PatienteInfo) {
        patienteInfoRepository.save(patienteInfo)
    }

    fun deletePatienteInfo(id: Long) {
        patienteInfoRepository.deleteById(id)
    }

}
