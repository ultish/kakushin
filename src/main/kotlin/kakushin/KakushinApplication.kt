package kakushin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching

@SpringBootApplication
@EnableCaching
class KakushinApplication

fun main(args: Array<String>) {
    runApplication<KakushinApplication>(*args)
}