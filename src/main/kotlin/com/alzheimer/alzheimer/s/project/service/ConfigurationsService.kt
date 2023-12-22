import com.alzheimer.alzheimer.s.project.model.Configurations
import com.alzheimer.alzheimer.s.project.repository.ConfigurationsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ConfigurationsService @Autowired constructor(
    private val configurationsRepository: ConfigurationsRepository
) {

    @Transactional
    fun saveConfigurations(configurations: Configurations): Configurations {
        return configurationsRepository.save(configurations)
    }

    @Transactional(readOnly = true)
    fun getConfigurationsById(id: Long): Configurations? {
        return configurationsRepository.findById(id).orElse(null)
    }

    @Transactional
    fun updateConfigurations(configurations: Configurations): Configurations {

        val existingConfigurations = getConfigurationsById(configurations.id!!)
            ?: throw RuntimeException("La configuración con ID ${configurations.id} no existe.")


        existingConfigurations.volume = configurations.volume
        existingConfigurations.alertTones = configurations.alertTones

        return configurationsRepository.save(existingConfigurations)
    }

    @Transactional
    fun deleteConfigurations(id: Long) {
        configurationsRepository.deleteById(id)
    }

    // Otros métodos según sea necesario...

}
